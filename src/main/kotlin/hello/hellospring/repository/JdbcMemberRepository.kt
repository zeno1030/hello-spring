package hello.hellospring.repository

import hello.hellospring.domain.Member
import org.springframework.jdbc.datasource.DataSourceUtils
import java.sql.*
import java.util.*
import javax.sql.DataSource

class JdbcMemberRepository(private val dataSource: DataSource) : MemberRepository {
    override fun save(member: Member): Member {
        val sql = "insert into member(name) values(?)"
        var conn: Connection? = null
        var pstmt: PreparedStatement? = null
        var rs: ResultSet? = null
        try {
            conn = getConnection()
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
            pstmt.setString(1, member.name)
            pstmt.executeUpdate()
            rs = pstmt.generatedKeys
            if (rs.next()) {
                member.id = rs.getLong(1)
            } else {
                throw SQLException("id 조회 실패")
            }
            return member
        } catch (e: Exception) {
            throw IllegalStateException(e)
        } finally {
            close(conn, pstmt, rs)
        }
    }

    override fun findById(id: Long): Member? {
        val sql = "select * from member where id = ?"
        var conn: Connection? = null
        var pstmt: PreparedStatement? = null
        var rs: ResultSet? = null
        try {
            conn = getConnection()
            pstmt = conn.prepareStatement(sql)
            pstmt.setLong(1, id)
            rs = pstmt.executeQuery()
            if (rs.next()) {
                val member = Member().apply {
                    member.id = rs.getLong("id")
                    member.name = rs.getString("name")
                }
                return member
            } else {
                return Optional.empty()
            }
        } catch (e: Exception) {
            throw IllegalStateException(e)
        } finally {
            close(conn, pstmt, rs)
        }
    }

    override fun findAll(): List<Member> {
        val sql = "select * from member"
        var conn: Connection? = null
        var pstmt: PreparedStatement? = null
        var rs: ResultSet? = null
        try {
            conn = getConnection()
            pstmt = conn.prepareStatement(sql)
            rs = pstmt.executeQuery()
            val members = mutableListOf<Member>()
            while (rs.next()) {
                val member = Member().apply {
                    setId(rs.getLong("id"))
                    setName(rs.getString("name"))
                }
                members.add(member)
            }
            return members
        } catch (e: Exception) {
            throw IllegalStateException(e)
        } finally {
            close(conn, pstmt, rs)
        }
    }

    override fun findByName(name: String): Optional<Member> {
        val sql = "select * from member where name = ?"
        var conn: Connection? = null
        var pstmt: PreparedStatement? = null
        var rs: ResultSet? = null
        try {
            conn = getConnection()
            pstmt = conn.prepareStatement(sql)
            pstmt.setString(1, name)
            rs = pstmt.executeQuery()
            if (rs.next()) {
                val member = Member().apply {
                    setId(rs.getLong("id"))
                    setName(rs.getString("name"))
                }
                return Optional.of(member)
            }
            return Optional.empty()
        } catch (e: Exception) {
            throw IllegalStateException(e)
        } finally {
            close(conn, pstmt, rs)
        }
    }

    private fun getConnection(): Connection {
        return DataSourceUtils.getConnection(dataSource)
    }

    private fun close(conn: Connection?, pstmt: PreparedStatement?, rs: ResultSet?) {
        rs?.close()
        pstmt?.close()
        conn?.close()
    }
}

/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CodeUtilDAO.java
*@FileTitle : 코드 성격의 데이터를 가져오는 Util DAO 클래스
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-02
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-10-02 Seong-mun Kang
* 1.0 최초 생성
* 수정 내역
* [1] : 2008.12.01 - 한정우 : COA 분배치를 위한 업데이트 시, IC 가 성공한 ( bkg_if_sts_cd =99 ) 경우에만 업데이트 하도록 수정 - IF 꼬임 방
* 2009-04-06 Jeong-seon An [N200903200140]   [SCEM] COP Header 로직 보완:작업메소드:;OB_ITCHG_CTNT,IB_ITCHG_CTNT 컬럼 UPDATE
=========================================================*/

package com.clt.apps.opus.esd.sce.common.util.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.sce.common.util.basic.CodeUtilBCImpl;
import com.clt.apps.opus.esd.sce.common.util.vo.CodeUtilVO;
import com.clt.apps.opus.esd.sce.common.util.vo.SearchExptTgtVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * 코드 성격의 데이터를 가져오는 DAO
 *
 * @author Seong-mun Kang
 * @see CodeUtilBCImpl.java
 * @since J2EE 1.4
 */
public class CodeUtilDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;
	
	/**
	 *
	 * @param table 테이블명
	 * @param valueField value 필드명
	 * @param textField text 필드명
	 * @param orderByField 정렬 필드명
	 * @return dRs DBRowSet
	 * @throws DAOException
	 */
	/*public DBRowSet searchCodeCombo(String table, String valueField, String textField, String orderByField) throws DAOException{
		Connection con  = null;
        PreparedStatement  pstmt = null;
        ResultSet  rs   = null;
        DBRowSet   dRs  = null;

        StringBuffer queryStr = new StringBuffer() ;
        queryStr.append("SELECT  " + valueField + ",\n") ;
        queryStr.append("        " + textField + "\n") ;
        queryStr.append("FROM    " + table + "\n") ;

        if(orderByField!=null && !orderByField.equals("")){
            queryStr.append("ORDER BY " + orderByField) ;
        }

        log.debug("\n " + queryStr) ;

        try{
        	con  = getConnection();
        	if(LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
        		pstmt = new LoggableStatement(con, queryStr.toString());
        	}else{
        		pstmt = con.prepareStatement(queryStr.toString());
        	}

        	log.debug("\n SQL : "+queryStr.toString());

            rs   = pstmt.executeQuery() ;

            // 결과를 DBRowset에 담는다.
            dRs = new DBRowSet();
            dRs.populate(rs) ;
		} catch (SQLException se) {
	        log.error(se.getMessage(), se);
	        throw new DAOException(new ErrorHandler(se).getMessage());
	    } catch (DAOException de) {
	        log.error(de.getMessage(), de);
	        throw de;
	    } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        } finally {
	    	if (rs != null) try { closeResultSet(rs); } catch (Exception e) {
	    		log.error(e.getMessage(), e);
	    		 throw new DAOException(new ErrorHandler(e).getMessage());	
	    	}
	    	if (pstmt != null) try { closeStatement(pstmt); } catch (Exception e) {
	    		 log.error(e.getMessage(), e);
		   		 throw new DAOException(new ErrorHandler(e).getMessage());	
		   	}
	    	if (con != null) try { closeConnection(con); } catch (Exception e) {
	    		 log.error(e.getMessage(), e);
		   		 throw new DAOException(new ErrorHandler(e).getMessage());	
	    	}
	    }

        return dRs ;
	}*/
	
	/**
	 *
	 * @param table 테이블명
	 * @param valueField value 필드명
	 * @param textField text 필드명
	 * @param orderByField 정렬 필드명
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchCodeCombo(String table, String valueField, String textField, String orderByField) throws DAOException{
       DBRowSet   dRs  = null;
       Map<String, Object> param = new HashMap<String, Object>();
       Map<String, Object> velParam = new HashMap<String, Object>();
       
       try{
	       	param.put("valuefield", valueField);
	       	param.put("textfield" , textField);
	       	param.put("tablefield", table);
       	
        	if(orderByField != null && !orderByField.equals("")){
	       		param.put	("orderbyfield",orderByField);
	       	}
	       	velParam.putAll(param);
	        dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CodeUtilDAOSearchCodeComboRSQL(), param, velParam);
		} catch (SQLException se) {
	        log.error(se.getMessage(), se);
	        throw new DAOException(new ErrorHandler(se).getMessage());
	    } catch (DAOException de) {
	        log.error(de.getMessage(), de);
	        throw de;
	    } catch (Exception e) {
           log.error(e.getMessage(), e);
           throw new DAOException(e.getMessage());
       }
       return dRs ;
	}

	/**
	 *
	 * @param table 테이블명
	 * @param codeField value 코드필드명
	 * @param nameField text 이름필드명
	 * @param code 코드
	 *
	 * @return dRs DBRowSet
	 * @throws DAOException
	 */
	/*public DBRowSet searchCodeName(String table, String codeField, String nameField, String code) throws DAOException{
		Connection con  = null;
        PreparedStatement  pstmt = null;
        ResultSet  rs   = null;
        DBRowSet   dRs  = null;

        StringBuffer queryStr = new StringBuffer() ;
        queryStr.append("SELECT  " + nameField + "\n") ;
        queryStr.append("FROM    " + table + "\n") ;
        queryStr.append("WHERE   " + codeField + " = '" + JSPUtil.replace(code,"'" ,"''") + "'") ;

        log.debug("\n " + queryStr) ;

        try{
        	con  = getConnection();
        	if(LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
        		pstmt = new LoggableStatement(con, queryStr.toString());
        	}else{
        		pstmt = con.prepareStatement(queryStr.toString());
        	}

        	log.debug("\n SQL : "+queryStr.toString());

            rs   = pstmt.executeQuery() ;

            // 결과를 DBRowset에 담는다.
            dRs = new DBRowSet();
            dRs.populate(rs) ;
		} catch (SQLException se) {
	        log.error(se.getMessage(), se);
	        throw new DAOException(new ErrorHandler(se).getMessage());
	    } catch (DAOException de) {
	        log.error(de.getMessage(), de);
	        throw de;
	    } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        } finally {
	    	if (rs != null) try { closeResultSet(rs); } catch (Exception e) {
	    		 log.error(e.getMessage(), e);
		   		 throw new DAOException(new ErrorHandler(e).getMessage());	
	    	}
	    	if (pstmt != null) try { closeStatement(pstmt); } catch (Exception e) {
	    		 log.error(e.getMessage(), e);
		   		 throw new DAOException(new ErrorHandler(e).getMessage());	
	    	}
	    	if (con != null) try { closeConnection(con); } catch (Exception e) {
	    		 log.error(e.getMessage(), e);
		   		 throw new DAOException(new ErrorHandler(e).getMessage());	
	    	}
	    }

        return dRs ;
	}*/
	
	/**
	 *
	 * @param table 테이블명
	 * @param codeField value 코드필드명
	 * @param nameField text 이름필드명
	 * @param code 코드
	 *
	 * @return dRs DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchCodeName(String table, String codeField, String nameField, String code) throws DAOException{
        DBRowSet   dRs  = null;
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
	    	param.put("valuefield", nameField);
	    	param.put("tablefield", table);
	    	param.put("wherefield", codeField);
	    	param.put("codevalue", JSPUtil.replace(code,"'" ,"''"));
	    	velParam.putAll(param);
	   
	    	dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CodeUtilDBDAOSearchCodeNameRSQL(), param, velParam);
		} catch (SQLException se) {
	        log.error(se.getMessage(), se);
	        throw new DAOException(new ErrorHandler(se).getMessage());
	    } catch (DAOException de) {
	        log.error(de.getMessage(), de);
	        throw de;
	    } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
        return dRs ;
	}

	/**
	 *
	 * @param table 테이블명
	 * @param codeField value 코드필드명
	 * @param nameField text 이름필드명
	 *
	 * @return dRs DBRowSet
	 * @throws DAOException
	 */
	/*public DBRowSet searchCodeNameList(String table, String codeField, String nameField) throws DAOException{
		Connection con  = null;
        PreparedStatement  pstmt = null;
        ResultSet  rs   = null;
        DBRowSet   dRs  = null;

        StringBuffer queryStr = new StringBuffer() ;
        queryStr.append("SELECT  " + codeField + ",\n") ;
        queryStr.append("        " + nameField + "\n") ;
        queryStr.append("FROM    " + table + "\n") ;

        try{
        	con  = getConnection();
        	if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
        		pstmt = new LoggableStatement(con, queryStr.toString());
        	}else{
        		pstmt = con.prepareStatement(queryStr.toString());
        	}

        	// 바인드 변수가 없으므로 String만 출력한다
        	log.debug("\n SQL : "+queryStr.toString());

            rs   = pstmt.executeQuery();

            // 결과를 DBRowset에 담는다.
            dRs = new DBRowSet();
            dRs.populate(rs) ;
		} catch (SQLException se) {
	        log.error(se.getMessage(), se);
	        throw new DAOException(new ErrorHandler(se).getMessage());
	    } catch (DAOException de) {
	        log.error(de.getMessage(), de);
	        throw de;
	    } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        } finally {
	    	if (rs != null) try { closeResultSet(rs); } catch (Exception e) {
	    		 log.error(e.getMessage(), e);
		   		 throw new DAOException(new ErrorHandler(e).getMessage());	
	    	}
	    	if (pstmt != null) try { closeStatement(pstmt); } catch (Exception e) {
	    		 log.error(e.getMessage(), e);
		   		 throw new DAOException(new ErrorHandler(e).getMessage());	
	    	}
	    	if (con != null) try { closeConnection(con); } catch (Exception e) {
	    		 log.error(e.getMessage(), e);
		   		 throw new DAOException(new ErrorHandler(e).getMessage());	
	    	}
	    }

        return dRs ;
	}*/

	/**
	 *
	 * @param String subCode
	 * @return DBRowSet
	 * @throws DAOException
	 */
	/*public DBRowSet searchCommonCodeNameList(String subCode) throws DAOException{
		Connection        con   = null;
		PreparedStatement pstmt = null;
        ResultSet         rs    = null;
        DBRowSet          dRs   = null;

        StringBuffer queryStr = new StringBuffer() ;
        queryStr.append("SELECT  intg_cd_val_ctnt,\n") ;
        queryStr.append("        intg_Cd_val_dp_desc\n") ;
        queryStr.append("FROM    com_intg_cd_dtl \n") ;
        queryStr.append("WHERE   intg_cd_id  = ? \n") ;

        try{
        	con   = getConnection();
        	// Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
                pstmt = new LoggableStatement(con, queryStr.toString());
            } else {
                pstmt = con.prepareStatement(queryStr.toString());
            }

            pstmt.setString(1, subCode) ;

            // Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
                log.info("\n SQL :" + ((LoggableStatement)pstmt).getQueryString());
            } else {
                log.info("\n SQL :" + queryStr );
            }

            rs = pstmt.executeQuery() ;

            // 결과를 DBRowset에 담는다.
            dRs = new DBRowSet();
            dRs.populate(rs) ;
		} catch (SQLException se) {
	        log.error(se.getMessage(), se);
	        throw new DAOException(new ErrorHandler(se).getMessage());
	    } catch (DAOException de) {
	        log.error(de.getMessage(), de);
	        throw de;
	    } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        } finally {
	    	if (rs != null) try { closeResultSet(rs); } catch (Exception e) {
	    		 log.error(e.getMessage(), e);
		   		 throw new DAOException(new ErrorHandler(e).getMessage());	
	    	}
	    	if (pstmt != null) try { closeStatement(pstmt); } catch (Exception e) {
	    		 log.error(e.getMessage(), e);
		   		 throw new DAOException(new ErrorHandler(e).getMessage());	
	    	}
	    	if (con != null) try { closeConnection(con); } catch (Exception e) {
	    		 log.error(e.getMessage(), e);
		   		 throw new DAOException(new ErrorHandler(e).getMessage());	
	    	}
	    }

        return dRs ;
	}*/

	/**
     *
     * @param table 테이블명
     * @param valueField value 필드명
     * @param textField text 필드명
     * @param orderByField 정렬 필드명
     * @return dRs DBRowSet
     * @throws DAOException
     */
	/*
    public DBRowSet searchCodeCombo(String table, String valueField, String textField, String whereField, String orderByField) throws DAOException{
        Connection con  = null;
        PreparedStatement pstmt = null;
        ResultSet  rs   = null;
        DBRowSet   dRs  = null;

        StringBuffer queryStr = new StringBuffer() ;
        queryStr.append("SELECT  " + valueField + ",\n") ;
        queryStr.append("        " + textField + "\n") ;
        queryStr.append("FROM    " + table + "\n") ;


        if(whereField!=null && !whereField.equals("")){
        	queryStr.append("WHERE   " + whereField + "\n");
        }
        if(orderByField!=null && !orderByField.equals("")){
            queryStr.append("ORDER BY " + orderByField) ;
        }

        log.debug("\n " + queryStr) ;
        log.debug("\n DBDAO::searchCodeCombo ");
        try{
            con  = getConnection();
        	// Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
            	pstmt = new LoggableStatement(con, queryStr.toString());
            }else{
            	pstmt = con.prepareStatement(queryStr.toString());
            }

            // Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
                log.info("\n SQL :" + ((LoggableStatement)pstmt).getQueryString());
            } else {
                log.info("\n SQL :" + queryStr );
            }

            rs = pstmt.executeQuery() ;


            // 결과를 DBRowset에 담는다.
            dRs = new DBRowSet();
            dRs.populate(rs) ;
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage(), de);
            throw de;
        }  finally {
            closeResultSet(rs);
            closeStatement(pstmt);
            closeConnection(con);
        }

        return dRs ;
    }
*/
    /**
    *
    * @param String table
    * @param String valueField
    * @param String textField
    * @param String whereField
    * @param String orderByField
    * @return DBRowSet
    * @throws DAOException
    */
	
   public DBRowSet searchCodeCombo(String table, String valueField, String textField, String whereField, String orderByField) throws DAOException{
       DBRowSet   dRs  = null;
	   Map<String, Object> param = new HashMap<String, Object>();
	   Map<String, Object> velParam = new HashMap<String, Object>();

       log.debug("\n DBDAO::searchCodeCombo ");
       try{
    	   param.put("valuefield", valueField);
    	   param.put("textfield" , textField);
       	   param.put("tablefield", table);
       	   
    	   velParam.putAll(param);
    	   
    	   if(whereField != null && !whereField.equals("")){
				param.put	("wherefield",whereField);
				velParam.put("wherefield",whereField);
		   }
    	   
    	   if(orderByField != null && !orderByField.equals("")){
				param.put	("orderbyfield",orderByField);
				velParam.put("orderbyfield",orderByField);
		   }

    	   dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CodeUtilDAOSearchCodeComboRSQL(), param, velParam);
       } catch (SQLException se) {
           log.error(se.getMessage(), se);
           throw new DAOException(new ErrorHandler(se).getMessage());
       } catch (DAOException de) {
           log.error(de.getMessage(), de);
           throw de;
       } catch (Exception e) {
           log.error(e.getMessage(), e);
           throw new DAOException(e.getMessage());
       } 
       return dRs ;
   }
   
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param CodeUtilVO codeUtilVO 
	 * @return List<CodeUtilVO>
	 * @throws DAOException
	 */
	 /*
	public List<CodeUtilVO> searchCodeCombo(CodeUtilVO codeUtilVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CodeUtilVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(codeUtilVO != null){
				Map<String, String> mapVO = codeUtilVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodeUtilDAOGetCodeComboRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CodeUtilVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 */

   /**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param CodeUtilVO codeUtilVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchCodeComboActual(CodeUtilVO codeUtilVO) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(codeUtilVO != null){
				Map<String, String> mapVO = codeUtilVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodeUtilDAOSearchCodeComboRSQL(), param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	 
	/**
	 * @param inbkg_rcv_dt
	 * @param inbkg_rcv_no
	 * @throws DAOException
	 */
	/*public void bkgif_dayB_Upcoa( String inbkg_rcv_dt, String inbkg_rcv_no ) throws DAOException {

	    Connection con = null;
	    PreparedStatement ps = null;

	    StringBuffer queryStr = new StringBuffer();

	    queryStr.append(" update sce_bkg_if             											\n");
	    queryStr.append(" set 					        											\n");
	    queryStr.append("       bkg_if_sts_cd = '99'    											\n");
	    queryStr.append("      ,coa_bat_cd = 'N'        											\n");
	    queryStr.append("      ,upd_dt = sysdate        											\n");
	    queryStr.append("      ,cost_calc_rmk = 'UC/UT/MT-'||TO_CHAR(sysdate,'YYYYMMDDHH24MISS')	\n");
	    queryStr.append("      ,umch_chk_dt = sysdate   											\n");
	    queryStr.append(" WHERE  bkg_rcv_dt    = ?      											\n");
	    queryStr.append(" AND    bkg_rcv_no    = ?      											\n");

	    try {

	        con = getConnection();

	        if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
	            ps = new LoggableStatement(con, queryStr.toString());
	        } else {
	            ps = con.prepareStatement(queryStr.toString());
	        }

			int ix = 1;

			ps.setString(ix++, inbkg_rcv_dt );
			ps.setString(ix++, inbkg_rcv_no );


	        if(LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
	            log.info(" bkgif_dayB_Upcoa SQL :\n" + ((LoggableStatement)ps).getQueryString());
	        } else {
	            log.info(" bkgif_dayB_Upcoa SQL :\n" + queryStr.toString());
	        }

	        ps.executeUpdate();

	    }  catch (DAOException de) {
	        log.error(de.getMessage(), de);
	        throw de;
	    } catch (Exception e) {
	        log.error(e.getMessage(), e);
	        throw new DAOException(e.getMessage());
	    } finally {
	    	if (ps != null) try { closeStatement(ps); } catch (Exception e) {
	    		 log.error(e.getMessage(), e);
		   		 throw new DAOException(new ErrorHandler(e).getMessage());	
	    	}
	    	if (con != null) try { closeConnection(con); } catch (Exception e) {
	    		 log.error(e.getMessage(), e);
		   		 throw new DAOException(new ErrorHandler(e).getMessage());	
	    	}
	    }

	}*/

	/**
	 * @param inbkg_no
	 * @param inbkg_no_split
	 * @throws DAOException
	 */
	/*public void bkgif_minB_Upcoa( String inbkg_no, String inbkg_no_split ) throws DAOException {

	    Connection con = null;
	    PreparedStatement ps = null;

	    StringBuffer queryStr = new StringBuffer();

	    queryStr.append(" update sce_bkg_if             									\n");
	    queryStr.append(" set 					        									\n");
	    queryStr.append("       bkg_if_sts_cd = '99'    									\n");
	    queryStr.append("      ,coa_bat_cd = 'N'        									\n");
	    queryStr.append("      ,coa_bat_seq = '0'       									\n");
	    queryStr.append("      ,umch_chk_dt = sysdate   									\n");
	    queryStr.append("      ,cost_calc_rmk = 'UR-'||TO_CHAR(sysdate,'YYYYMMDDHH24MISS')  \n");
	    queryStr.append(" WHERE  bkg_no    = ?          									\n");
	    queryStr.append(" AND    bkg_no_split    = ?    									\n");
	    queryStr.append(" AND    bkg_evnt_tp_cd  = 'IC' 									\n");
	    queryStr.append(" AND    BKG_IF_STS_CD  = '99' 										\n"); //[1] - minestar 2008.12.01

	    try {

	        con = getConnection();

	        if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
	            ps = new LoggableStatement(con, queryStr.toString());
	        } else {
	            ps = con.prepareStatement(queryStr.toString());
	        }

			int ix = 1;

			ps.setString(ix++, inbkg_no );
			ps.setString(ix++, inbkg_no_split );


//	        if(LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//	            log.info(" bkgif_dayB_Upcoa SQL :\n" + ((LoggableStatement)ps).getQueryString());
//	        } else {
//	            log.info(" bkgif_dayB_Upcoa SQL :\n" + queryStr.toString());
//	        }

	        ps.executeUpdate();

	    } catch (DAOException de) {
	        log.error(de.getMessage(), de);
	        throw de;
	    } catch (Exception e) {
	        log.error(e.getMessage(), e);
	        throw new DAOException(e.getMessage());
	    } finally {
	    	if (ps != null) try { closeStatement(ps); } catch (Exception e) {
	    		 log.error(e.getMessage(), e);
		   		 throw new DAOException(new ErrorHandler(e).getMessage());	
	    	}
	    	if (con != null) try { closeConnection(con); } catch (Exception e) {
	    		 log.error(e.getMessage(), e);
		   		 throw new DAOException(new ErrorHandler(e).getMessage());	
	    	}
	    }

	}*/

    /**
     * @param in_cop_no
     * @param in_con
     * @return
     * @throws DAOException
     */
    /*public String searchRailChk( String in_cop_no , Connection in_con) throws DAOException {

        PreparedStatement ps = null;
        ResultSet rs = null;

        String result = "";

        StringBuffer queryStr = new StringBuffer();

        queryStr.append(" select                                        \n");
        queryStr.append("     o.o_rd_bnd||i.i_rd_bnd rd_bnd_cd          \n");
        queryStr.append(" from                                          \n");
        queryStr.append(" (                                             \n");
        queryStr.append("     select                                    \n");
        queryStr.append("     nvl(max(bnd_vskd_seq_cd),'X') o_rd_bnd    \n");
        queryStr.append("     from sce_cop_grp                          \n");
        queryStr.append("     where                                     \n");
        queryStr.append("     cop_no = ?                                \n");
        queryStr.append("     and trsp_mod_cd = 'RD'                    \n");
        queryStr.append("     and bnd_vskd_seq_cd = 'O'                 \n");
        queryStr.append(" ) o,                                          \n");
        queryStr.append(" (                                             \n");
        queryStr.append("     select                                    \n");
        queryStr.append("     nvl(max(bnd_vskd_seq_cd),'X') i_rd_bnd    \n");
        queryStr.append("     from sce_cop_grp                          \n");
        queryStr.append("     where                                     \n");
        queryStr.append("     cop_no = ?                                \n");
        queryStr.append("     and trsp_mod_cd = 'RD'                    \n");
        queryStr.append("     and bnd_vskd_seq_cd = 'I'                 \n");
        queryStr.append(" ) i                                           \n");

        try {

        	if ( in_con != null ){

            	if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
                    ps = new LoggableStatement(in_con, queryStr.toString());
                } else {
                    ps = in_con.prepareStatement(queryStr.toString());
                }

    	        int ix = 1;

    	        ps.setString(ix++, in_cop_no);
    	        ps.setString(ix++, in_cop_no);

                rs = ps.executeQuery();

                while(rs.next()) {

                	result = rs.getString(1);

                }
        	}

        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        } finally {
	    	if (rs != null) try { closeResultSet(rs); } catch (Exception e) {
	    		 log.error(e.getMessage(), e);
		   		 throw new DAOException(new ErrorHandler(e).getMessage());	
	    	}
	    	if (ps != null) try { closeStatement(ps); } catch (Exception e) {
	    		 log.error(e.getMessage(), e);
		   		 throw new DAOException(new ErrorHandler(e).getMessage());	
	    	}
        }

        return result;
    }*/

    /**
     * @param inbkg_no
     * @param inbkg_no_split
     * @param in_con
     * @return
     * @throws DAOException
     */
    /*public DBRowSet getCopNoBKG(String inbkg_no, String inbkg_no_split, Connection in_con ) throws DAOException{

        PreparedStatement pstmt = null;
        ResultSet  rs   = null;
        DBRowSet   dRs  = null;

        StringBuffer queryStr = new StringBuffer() ;

        queryStr.append(" select cop_no            \n");
        queryStr.append(" from sce_cop_hdr         \n");
        queryStr.append(" where bkg_no = ?         \n");
        queryStr.append("     and bkg_no_split = ? \n");

        try{

        	if( in_con != null ){

            	// Loggable Statement 사용에 의해 추가
                if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
                	pstmt = new LoggableStatement(in_con, queryStr.toString());
                }else{
                	pstmt = in_con.prepareStatement(queryStr.toString());
                }

				int ix = 1;

				pstmt.setString(ix++, inbkg_no );
				pstmt.setString(ix++, inbkg_no_split );

                rs = pstmt.executeQuery() ;

                // 결과를 DBRowset에 담는다.
                dRs = new DBRowSet();
                dRs.populate(rs) ;
        	}


        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        } finally {
	    	if (rs != null) try { closeResultSet(rs); } catch (Exception e) {
	    		 log.error(e.getMessage(), e);
		   		 throw new DAOException(new ErrorHandler(e).getMessage());	
	    	}
	    	if (pstmt != null) try { closeStatement(pstmt); } catch (Exception e) {
	    		 log.error(e.getMessage(), e);
		   		 throw new DAOException(new ErrorHandler(e).getMessage());	
	    	}
        }

        return dRs ;
    }*/

	/**
	 * COP_RAIL_CHK_CD : Outbound, Inbound 별로 Rail 운송 수단이 존재하는 지 여부를 관리
	 *  ex> OI : Outbound, Inbound 모두 rail 존재
	 *  	XI : Inbound 에만 rail 존재
	 *
	 * @param inbkg_no
	 * @param inbkg_no_split
	 * @param in_con
	 * @throws DAOException
	 */
	/*public void modifyRailChk( String inbkg_no, String inbkg_no_split, Connection in_con ) throws DAOException {

	    PreparedStatement ps = null;
	    DBRowSet copRow = null;
	    String strcop_no = "";
	    String str_oib = "";

	    StringBuffer queryStr = new StringBuffer();

	    queryStr.append(" update sce_cop_hdr             									\n");
	    queryStr.append(" set 					        									\n");
	    queryStr.append("       COP_RAIL_CHK_CD = ?	    									\n");
	    queryStr.append(" WHERE  cop_no    = ?          									\n");

	    try {

	    	if( in_con != null ) {

		        if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
		            ps = new LoggableStatement(in_con, queryStr.toString());
		        } else {
		            ps = in_con.prepareStatement(queryStr.toString());
		        }

		        copRow = getCopNoBKG(inbkg_no, inbkg_no_split, in_con );

		        copRow.getRow();

	    		while(copRow.next()){
	    			strcop_no = copRow.getString("cop_no");

	    			str_oib = searchRailChk( strcop_no , in_con);

					int ix = 1;

					ps.setString(ix++, str_oib );
					ps.setString(ix++, strcop_no );

			        ps.executeUpdate();
			        ps.clearWarnings();
			        ps.clearParameters();

	    		}

	    	}

	    }  catch (Exception e) {
	        log.error(e.getMessage(), e);
	        throw new DAOException(e.getMessage());
	    } finally {
	    	if (ps != null) try { closeStatement(ps); } catch (Exception e) {
	    		 log.error(e.getMessage(), e);
		   		 throw new DAOException(new ErrorHandler(e).getMessage());	
	    	}
	    }

	}*/

	/**
	 * @param incop_no
	 * @param in_con
	 * @throws DAOException
	 */
	/*public void modifyRailChk( String incop_no, Connection in_con ) throws DAOException {

	    PreparedStatement ps = null;
	    //DBRowSet CopRow = null;
	    String str_oib = "";

	    StringBuffer queryStr = new StringBuffer();

	    queryStr.append(" update sce_cop_hdr             									\n");
	    queryStr.append(" set 					        									\n");
	    queryStr.append("       COP_RAIL_CHK_CD = ?	    									\n");
	    queryStr.append(" WHERE  cop_no    = ?          									\n");

	    try {

	    	if( in_con != null ) {

		        if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
		            ps = new LoggableStatement(in_con, queryStr.toString());
		        } else {
		            ps = in_con.prepareStatement(queryStr.toString());
		        }

    			str_oib = searchRailChk( incop_no , in_con);

				int ix = 1;

				ps.setString(ix++, str_oib );
				ps.setString(ix++, incop_no );

		        ps.executeUpdate();


	    	}

	    }  catch (Exception e) {
	        log.error(e.getMessage(), e);
	        throw new DAOException(e.getMessage());
	    } finally {
	    	if (ps != null) try { closeStatement(ps); } catch (Exception e) {
	    		 log.error(e.getMessage(), e);
		   		 throw new DAOException(new ErrorHandler(e).getMessage());	
	    	}
	    }

	}*/
	
	/** SCE_COP_HDR 테이블 update 
	 * 2009-04-06 Jeong-seon An [N200903200140]관련; OB_ITCHG_CTNT&IB_ITCHG_CTNT컬럼 UPDATE
	 * @param String cop_no
	 * @throws EventException
	 */
	/*public void modifyItchgCtnt(String cop_no) throws DAOException {

	    Connection con = null;
	    PreparedStatement ps = null;

	    StringBuffer queryStr = new StringBuffer();
	    StringBuffer queryStr1 = new StringBuffer();
	    
	    queryStr.append(" MERGE INTO SCE_COP_HDR D      \n");
	    queryStr.append(" USING ( SELECT H.COP_NO,H.OB_PCTL_NO,M.OB_ITCHG_CTNT    \n");
	    queryStr.append("         FROM  SCE_COP_HDR H, PRD_PROD_CTL_MST M        \n");
	    queryStr.append("         WHERE H.COP_NO = ?        \n");
	    queryStr.append("         AND H.COP_STS_CD <> 'X'    \n");
	    queryStr.append("         AND M.PCTL_NO = H.OB_PCTL_NO        \n");
	    queryStr.append("       ) S   \n");
	    queryStr.append("  ON (D.COP_NO = S.COP_NO AND D.OB_PCTL_NO = S.OB_PCTL_NO)   \n");
	    queryStr.append("  WHEN MATCHED THEN UPDATE SET D.OB_ITCHG_CTNT = S.OB_ITCHG_CTNT        \n");

	    queryStr1.append(" MERGE INTO SCE_COP_HDR D       \n");
	    queryStr1.append(" USING ( SELECT H.COP_NO,H.IB_PCTL_NO,M.IB_ITCHG_CTNT    \n"); 
	    queryStr1.append("         FROM  SCE_COP_HDR H, PRD_PROD_CTL_MST M          \n");
	    queryStr1.append("         WHERE H.COP_NO = ?          \n");
	    queryStr1.append("         AND H.COP_STS_CD <> 'X'      \n");
	    queryStr1.append("         AND M.PCTL_NO = H.IB_PCTL_NO          \n");
	    queryStr1.append("        ) S    \n");
	    queryStr1.append("  ON (D.COP_NO = S.COP_NO AND D.IB_PCTL_NO = S.IB_PCTL_NO)    \n");
	    queryStr1.append("  WHEN MATCHED THEN UPDATE SET D.IB_ITCHG_CTNT = S.IB_ITCHG_CTNT    \n"); 	    
	        
	    try {

	        con = getConnection();

	        if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
	            ps = new LoggableStatement(con, queryStr.toString());
	        } else {
	            ps = con.prepareStatement(queryStr.toString());
	        }

			int ix = 1;

			ps.setString(ix++, cop_no );


	        if(LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
	            log.info(" modifyItchgCtnt(cop) SQL :\n" + ((LoggableStatement)ps).getQueryString());
	        } else {
	            log.info(" modifyItchgCtnt(cop) SQL :\n" + queryStr.toString());
	        }

	        ps.executeUpdate();


	        if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
	            ps = new LoggableStatement(con, queryStr1.toString());
	        } else {
	            ps = con.prepareStatement(queryStr1.toString());
	        }

			int jx = 1;

			ps.setString(jx++, cop_no );


	        if(LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
	            log.info(" modifyItchgCtnt(cop) SQL :\n" + ((LoggableStatement)ps).getQueryString());
	        } else {
	            log.info(" modifyItchgCtnt(cop) SQL :\n" + queryStr1.toString());
	        }

	        ps.executeUpdate();
	        
	        
	    }  catch (DAOException de) {
	        log.error(de.getMessage(), de);
	        throw de;
	    } catch (Exception e) {
	        log.error(e.getMessage(), e);
	        throw new DAOException(e.getMessage());
	    } finally {
	    	if (ps != null) try { closeStatement(ps); } catch (Exception e) {
	    		 log.error(e.getMessage(), e);
		   		 throw new DAOException(new ErrorHandler(e).getMessage());	
	    	}
	    	if (con != null) try { closeConnection(con); } catch (Exception e) {
	    		 log.error(e.getMessage(), e);
		   		 throw new DAOException(new ErrorHandler(e).getMessage());	
	    	}
	    }

	}*/

	/** SCE_COP_HDR 테이블 update 
	 * 2009-04-06 Jeong-seon An [N200903200140]관련; OB_ITCHG_CTNT&IB_ITCHG_CTNT컬럼 UPDATE
	 * @param soOfc
	 * @param soSeq
	 * @throws EventException
	 */
	/*public void modifyItchgCtnt(String soOfc, String soSeq) throws DAOException {

	    Connection con = null;
	    PreparedStatement ps = null;

	    StringBuffer queryStr = new StringBuffer();
	    StringBuffer queryStr1 = new StringBuffer();

	    queryStr.append(" MERGE INTO SCE_COP_HDR D        \n");
	    queryStr.append(" USING ( SELECT H.COP_NO, H.OB_PCTL_NO, M.OB_ITCHG_CTNT   \n");
	    queryStr.append("               FROM  SCE_COP_HDR H, PRD_PROD_CTL_MST M, SCE_COST_ACT_GRP G       \n");
	    queryStr.append("               WHERE G.TRSP_SO_OFC_CTY_CD = ?       \n");
	    queryStr.append("               AND   G.TRSP_SO_SEQ = ?     \n");
	    queryStr.append("               AND   G.COST_ACT_GRP_SEQ < 400     \n");
	    queryStr.append("               AND H.COP_NO = G.COP_NO       \n");
	    queryStr.append("               AND M.PCTL_NO = H.OB_PCTL_NO       \n");
	    queryStr.append("       ) S        \n");
	    queryStr.append("  ON (D.COP_NO = S.COP_NO AND D.OB_PCTL_NO = S.OB_PCTL_NO)   \n");
	    queryStr.append("  WHEN MATCHED THEN UPDATE SET D.OB_ITCHG_CTNT = S.OB_ITCHG_CTNT        \n");
	    		
	    queryStr1.append(" MERGE INTO SCE_COP_HDR D        \n");
	    queryStr1.append(" USING ( SELECT H.COP_NO, H.IB_PCTL_NO, M.IB_ITCHG_CTNT   \n");
	    queryStr1.append("               FROM  SCE_COP_HDR H, PRD_PROD_CTL_MST M, SCE_COST_ACT_GRP G       \n");
	    queryStr1.append("               WHERE G.TRSP_SO_OFC_CTY_CD = ?       \n");
	    queryStr1.append("               AND   G.TRSP_SO_SEQ = ?     \n");
	    queryStr1.append("               AND   G.COST_ACT_GRP_SEQ > 600     \n");
	    queryStr1.append("               AND H.COP_NO = G.COP_NO       \n");
	    queryStr1.append("               AND M.PCTL_NO = H.IB_PCTL_NO       \n");
	    queryStr1.append("       ) S        \n");
	    queryStr1.append("  ON (D.COP_NO = S.COP_NO AND D.IB_PCTL_NO = S.IB_PCTL_NO)   \n");
	    queryStr1.append("  WHEN MATCHED THEN UPDATE SET D.IB_ITCHG_CTNT = S.IB_ITCHG_CTNT        \n");
	    
	    try {

	        con = getConnection();

	        if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
	            ps = new LoggableStatement(con, queryStr.toString());
	        } else {
	            ps = con.prepareStatement(queryStr.toString());
	        }

			int ix = 1;

			ps.setString(ix++, soOfc );
			ps.setString(ix++, soSeq );
			

	        if(LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
	            log.info(" modifyItchgCtnt(so) SQL OB:\n" + ((LoggableStatement)ps).getQueryString());
	        } else {
	            log.info(" modifyItchgCtnt(so) SQL OB:\n" + queryStr.toString());
	        }

	        ps.executeUpdate();
	        
	        if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
	            ps = new LoggableStatement(con, queryStr1.toString());
	        } else {
	            ps = con.prepareStatement(queryStr1.toString());
	        }

			int jx = 1;

			ps.setString(jx++, soOfc );
			ps.setString(jx++, soSeq );
			

	        if(LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
	            log.info(" modifyItchgCtnt(so) SQL IB:\n" + ((LoggableStatement)ps).getQueryString());
	        } else {
	            log.info(" modifyItchgCtnt(so) SQL IB:\n" + queryStr1.toString());
	        }

	        ps.executeUpdate();
	        
	        

	    }  catch (DAOException de) {
	        log.error(de.getMessage(), de);
	        throw de;
	    } catch (Exception e) {
	        log.error(e.getMessage(), e);
	        throw new DAOException(e.getMessage());
	    } finally {
	    	if (ps != null) try { closeStatement(ps); } catch (Exception e) {
	    		 log.error(e.getMessage(), e);
		   		 throw new DAOException(new ErrorHandler(e).getMessage());	
	    	}
	    	if (con != null) try { closeConnection(con); } catch (Exception e) {
	    		 log.error(e.getMessage(), e);
		   		 throw new DAOException(new ErrorHandler(e).getMessage());	
	    	}
	    }

	}*/

	/** SCE_COP_HDR 테이블 update 
	 * 2009-04-06 Jeong-seon An [N200903200140]관련; OB_ITCHG_CTNT&IB_ITCHG_CTNT컬럼 UPDATE
	 * @param rcvDt
	 * @param rcvNo
	 * @throws EventException
	 */
	/*public void modifyItchgCtntBkgIf(String rcvDt, String rcvNo) throws DAOException {

	    Connection con = null;
	    PreparedStatement ps = null;

	    StringBuffer queryStr = new StringBuffer();
	    StringBuffer queryStr1 = new StringBuffer();

	    queryStr.append(" MERGE INTO SCE_COP_HDR D      \n");
	    queryStr.append(" USING ( SELECT I.BKG_NO,I.BKG_NO_SPLIT,H.COP_NO,M.OB_ITCHG_CTNT    \n");
	    queryStr.append("         FROM SCE_BKG_IF I, PRD_PROD_CTL_MST M, SCE_COP_HDR H   \n");
	    queryStr.append("         WHERE I.BKG_RCV_DT = ?   \n");
	    queryStr.append("         AND  I.BKG_RCV_NO = ?   \n");
	    queryStr.append("         AND I.PCTL_NO LIKE 'R%'   \n");
	    queryStr.append("         AND M.PCTL_NO = I.PCTL_NO   \n");
	    queryStr.append("         AND H.OB_PCTL_NO=M.PCTL_NO   \n");
	    queryStr.append("         AND H.BKG_NO = I.BKG_NO   \n");
	    queryStr.append("         AND H.BKG_NO_SPLIT = I.BKG_NO_SPLIT   \n");
	    queryStr.append("         AND H.COP_STS_CD <> 'X'   \n");
	    queryStr.append("         AND I.BKG_IF_STS_CD = '99' ) S   \n");
	    queryStr.append("  ON (D.COP_NO = S.COP_NO)   \n");
	    queryStr.append("  WHEN MATCHED THEN UPDATE SET D.OB_ITCHG_CTNT = S.OB_ITCHG_CTNT        \n");
	     
	    queryStr1.append(" MERGE INTO SCE_COP_HDR D       \n");
	    queryStr1.append(" USING ( SELECT I.BKG_NO,I.BKG_NO_SPLIT,H.COP_NO,M.IB_ITCHG_CTNT    \n"); 
	    queryStr1.append("         FROM SCE_BKG_IF I, PRD_PROD_CTL_MST M, SCE_COP_HDR H    \n");
	    queryStr1.append("         WHERE I.BKG_RCV_DT = ?    \n");
	    queryStr1.append("         AND  I.BKG_RCV_NO = ?    \n");
	    queryStr1.append("         AND I.PCTL_NO LIKE 'R%'    \n");
	    queryStr1.append("         AND M.PCTL_NO = I.PCTL_NO    \n");
	    queryStr1.append("         AND H.IB_PCTL_NO=M.PCTL_NO     \n");
	    queryStr1.append("         AND H.BKG_NO = I.BKG_NO    \n");
	    queryStr1.append("         AND H.BKG_NO_SPLIT = I.BKG_NO_SPLIT    \n");
	    queryStr1.append("         AND H.COP_STS_CD <> 'X'    \n");
	    queryStr1.append("         AND I.BKG_IF_STS_CD = '99' ) S    \n");
	    queryStr1.append("  ON (D.COP_NO = S.COP_NO)    \n");
	    queryStr1.append("  WHEN MATCHED THEN UPDATE SET D.IB_ITCHG_CTNT = S.IB_ITCHG_CTNT    \n"); 	    
	    
	    try {

	        con = getConnection();

	        if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
	            ps = new LoggableStatement(con, queryStr.toString());
	        } else {
	            ps = con.prepareStatement(queryStr.toString());
	        }

			int ix = 1;

			ps.setString(ix++, rcvDt );
			ps.setString(ix++, rcvNo );

	        if(LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
	            log.info("\n modifyItchgCtntBkgIf SQL : OB \n" + ((LoggableStatement)ps).getQueryString());
	        } else {
	            log.info("\n modifyItchgCtntBkgIf SQL : OB \n" + queryStr.toString());
	        }

	        ps.executeUpdate();
	        
	        if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
	            ps = new LoggableStatement(con, queryStr1.toString());
	        } else {
	            ps = con.prepareStatement(queryStr1.toString());
	        }

			int jx = 1;

			ps.setString(jx++, rcvDt );
			ps.setString(jx++, rcvNo );

	        if(LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
	            log.info("\n modifyItchgCtntBkgIf SQL : IB \n" + ((LoggableStatement)ps).getQueryString());
	        } else {
	            log.info("\n modifyItchgCtntBkgIf SQL : IB \n" + queryStr1.toString());
	        }

	        ps.executeUpdate();

	    }  catch (DAOException de) {
	        log.error(de.getMessage(), de);
	        throw de;
	    } catch (Exception e) {
	        log.error(e.getMessage(), e);
	        throw new DAOException(e.getMessage());
	    } finally {
	    	if (ps != null) try { closeStatement(ps); } catch (Exception e) {
	    		 log.error(e.getMessage(), e);
		   		 throw new DAOException(new ErrorHandler(e).getMessage());	
	    	}
	    	if (con != null) try { closeConnection(con); } catch (Exception e) {
	    		 log.error(e.getMessage(), e);
		   		 throw new DAOException(new ErrorHandler(e).getMessage());	
	    	}
	    }

	}*/

	/**
	 * @param cop_no
	 * @param unmatchedCode
	 * @throws DAOException
	 */
//	public void modifyUnmatchedReason( String cop_no, String unmatchedCode) throws DAOException {
//
//	    Connection con = null;
//	    PreparedStatement ps = null;
//
//	    StringBuffer queryStr = new StringBuffer();
//
//	    queryStr.append(" update sce_cop_hdr             								   \n");
//	    queryStr.append(" set 					        								   \n");
//	    queryStr.append("       UMCH_STS_CD = ?    										   \n");
//	    queryStr.append(" WHERE COP_NO    = ?      											\n");
//
//	    try {
//
//	        con = getConnection();
//
//	        if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//	            ps = new LoggableStatement(con, queryStr.toString());
//	        } else {
//	            ps = con.prepareStatement(queryStr.toString());
//	        }
//
//			int ix = 1;
//
//			ps.setString(ix++, unmatchedCode );
//			ps.setString(ix++, cop_no );
//
//
//
//	        if(LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//	            log.info(" modifyUnmatchedReason SQL :\n" + ((LoggableStatement)ps).getQueryString());
//	        } else {
//	            log.info(" modifyUnmatchedReason SQL :\n" + queryStr.toString());
//	        }
//
//	        ps.executeUpdate();
//
//	    }  catch (DAOException de) {
//	        log.error(de.getMessage(), de);
//	        throw de;
//	    } catch (Exception e) {
//	        log.error(e.getMessage(), e);
//	        throw new DAOException(e.getMessage());
//	    } finally {
//	        closeStatement(ps);
//	        closeConnection(con);
//	    }
//
//	}

    /**
     * GenS/O 가 cre_usr_id 인 부분은 조회 되지않는다.
     * COP History Setting;<br>
     * @param String cop_no
     * @param String event_cd
     * @param String ofc_cd
     * @param String usr_id
     * @param String scs_flg
     * @return String
     * @throws DAOException
     */
    public String  addSceCopHistory(String cop_no, String event_cd, String ofc_cd, String usr_id, String scs_flg) throws DAOException {
    	if(cop_no.equals("") || event_cd.equals("") || event_cd.length() != 2) {
        	return "000001";
        }
    	
    	String result = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		int rowCnt = 0;
		try{
			param.put("cop_no", cop_no);
			param.put("event_cd", event_cd);
			param.put("usr_id", usr_id);
			param.put("scs_flg", scs_flg);
			
			rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new CodeUtilDAOAddSceCopHistoryCSQL(), param, velParam);
			if(rowCnt>0) result="000000";
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return result;
    }

    /** ExptMst 테이블 cancel
	 * @param copNo
	 * @param usrId
	 * @return
	 * @throws DAOException
	 */
//	public int updateExptMst(String copNo, String usrId)  throws DAOException {
//
//		Connection con = null;
//        PreparedStatement ps = null;
//        StringBuffer queryStr = new StringBuffer();
//
//        int result = 0;
//        int i = 1;
//
//        queryStr.append(" UPDATE SCE_EXPT_MST                                						\n");
//        queryStr.append(" SET    COP_EXPT_STS_CD = 'X'               								\n");
//        queryStr.append("       ,NTFD_FLG        = 'N'          		 							\n");
//        queryStr.append("       ,UPD_USR_ID = ?      												\n");
//        queryStr.append(" 		,UPD_DT = SYSDATE        											\n");
//        queryStr.append(" WHERE  COP_NO = ?       													\n");
//        queryStr.append(" AND    COP_EXPT_STS_CD in ('O','R')        								\n");
//
//        try{
//        	con = getConnection();
//
//	        if(LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//	            ps = new LoggableStatement(con, queryStr.toString());
//	        } else {
//	            ps = con.prepareStatement(queryStr.toString());
//	        }
//
//	        ps.setString(i++, usrId);
//	        ps.setString(i++, copNo);
//
//	        if(LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//  				log.debug(" SQL :\n" + ((LoggableStatement)ps).getQueryString());
//      	  	} else {
//      	  		log.debug(" SQL :\n" + queryStr.toString());
//      	  	}
//	        result = ps.executeUpdate();
//
//        } catch (SQLException se) {
//	        log.error(se.getMessage(), se);
//	        throw new DAOException(new ErrorHandler(se).getMessage());
//	    } catch (DAOException de) {
//	        log.error(de.getMessage(), de);
//	        throw de;
//	    } catch (Exception e) {
//	        log.error(e.getMessage(), e);
//	        throw new DAOException(e.getMessage());
//	    } finally {
//	        closeStatement(ps);
//	        closeConnection(con);
//	    }
//	    return result;
//	}

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param String cop_no
	 * @return int
	 * @throws DAOException
	 */
	public int cancelExptMst(String cop_no) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		int rowCnt = 0;
		try{
			param.put("cop_no", cop_no);
			rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new CodeUtilDAOCancelExptMstUSQL(), param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param String cop_no
	 * @return int
	 * @throws DAOException
	 */
	public int resolveExptMst(String cop_no) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		int rowCnt = 0;
		try{
			param.put("cop_no", cop_no);
			rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new CodeUtilDAOResolveExptMstUSQL(), param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt;
	}
	 
	/**
	 * @param cop_no
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchExptTgtVO> searchExptTgt(String cop_no) throws DAOException {
		Map<String, String> velParam = new HashMap<String, String>();
		Map<String, String> param = new HashMap<String, String>();
		DBRowSet dbRowset = null;
		param.put("cop_no", cop_no);
		velParam.put("cop_no", cop_no);
		
		List<SearchExptTgtVO> rtnList = new ArrayList<SearchExptTgtVO> ();
		
		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CodeUtilDBDAOSearchExptTgtRSQL(),
					param, velParam);

			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchExptTgtVO.class);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;
	}
	
	/**
	 * @param String cop_no
	 * @param String cop_dtl_seq
	 * @param String act_dt
	 * @param String upd_usr_id
	 * @param String commit_flg
	 * @throws DAOException
	 */
	public void callSceExcetionResistActPrc(String cop_no, String cop_dtl_seq, String act_dt, String upd_usr_id, String commit_flg) throws DAOException {
		try {
			Map<String, String> velParam = new HashMap<String, String>();
			Map<String, String> param = new HashMap<String, String>();
			
			param.put("cop_no", cop_no);
			param.put("cop_dtl_seq", cop_dtl_seq);
			param.put("act_dt", act_dt);
			param.put("upd_usr_id", upd_usr_id);
			param.put("commit_flg", commit_flg);
			
			velParam.put("cop_no", cop_no);
			velParam.put("cop_dtl_seq", cop_dtl_seq);
			velParam.put("act_dt", act_dt);
			velParam.put("upd_usr_id", upd_usr_id);
			velParam.put("commit_flg", commit_flg);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			sqlExe.executeSP(
					(ISQLTemplate) new CodeUtilDBDAOCallSceExceptionResistActPrcRSQL(),
					param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/** Exception 판별 로직
	 *  MVMT 대상으로 Actual Delay판별
	 *  SCE_EXCEPTION_RESIST_ACT_PRC 안에 로직 다 있으므로 prc call하는 method.
	 * @param copNo
	 * @return
	 * @throws DAOException
	 */
//	public String setCopExptResistAct(String copNo, String userId, String cmmt_yn)  throws DAOException {
//		Connection con = null;
//        PreparedStatement ps = null;
//        CallableStatement cs = null;
//        ResultSet rs = null;
//        String queryStr = "";
//        String result = "";
//
//
//        int i = 1;
//
//
//        String copGrpSeq = "";
//        String copDtlSeq = "";
//        String actualDt = "";
//
//
//        DBRowSet rowSet = new DBRowSet();
//        queryStr =
//        	"    SELECT  d.cop_no, d.cop_grp_seq, d.cop_dtl_seq,to_char(d.act_dt,'yyyymmddhh24miss')act_dt "+"\n"+
//        	"           ,decode(ACT_CD,'FIRRLO','AL','FIRRDO','RL','N') rd_eta_flg, NOD_CD			"+"\n"+
//        	"    FROM sce_cop_dtl d, sce_cop_hdr h    "+"\n"+
//        	"    WHERE h.cop_no = ?  and d.cop_no = h.cop_no   											"+"\n"+
//        	"    AND (d.cop_grp_seq < 400 OR d.cop_grp_seq >= 600) AND d.act_dt is not null   AND h.cop_sts_cd not in ('X','F')		"+"\n"+
//        	"    order by 	d.cop_no, d.cop_grp_seq, d.cop_dtl_seq"+"\n"+
//        	""+"\n";
//
//        try{
//        	con = getConnection();
//
//	        if(LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//	            ps = new LoggableStatement(con, queryStr.toString());
//	        } else {
//	            ps = con.prepareStatement(queryStr.toString());
//	        }
//
//	        ps.setString(i++, copNo);
//
//
//	        if(LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//  				log.debug(" SQL :\n" + ((LoggableStatement)ps).getQueryString());
//      	  	} else {
//      	  		log.debug(" SQL :\n" + queryStr.toString());
//      	  	}
//
//	        rs = ps.executeQuery();
//
//	        while(rs.next()){
//
//	            copGrpSeq = JSPUtil.getNull(rs.getString(  "COP_GRP_SEQ"       ));
//	            copDtlSeq = JSPUtil.getNull(rs.getString(  "COP_DTL_SEQ"   	));
//	        	actualDt  = JSPUtil.getNull(rs.getString(  "ACT_DT"            ));
//
//
//
//	        	int j = 1;
//		        String queryStr1   = "{call SCE_EXCEPTION_RESIST_ACT_PRC(?,?,?,?,?,?)}";
//
//		        cs = con.prepareCall(queryStr1);
//	            cs.setString(j++,copNo);
//	            cs.setString(j++,copGrpSeq);
//	            cs.setString(j++,copDtlSeq);
//	            cs.setString(j++,actualDt);
//	            cs.setString(j++,userId );      // user ID 는 위 prc에서 구분자로 쓰이고 있음. replan관련 조건문은 expt% 임. 단 EXPT는 이미 쓰이므로 주의 .
//	            cs.setString(j++,cmmt_yn);
//
//	            cs.executeUpdate();
//
//	            closeStatement(cs);
//
//
//	            	log.info("\n\n\n\n execute SCE_EXCEPTION_RESIST_ACT_PRC("
//						+"\'" + JSPUtil.getNull(rs.getString(  "COP_NO"      	))+"\'" + ","
//						+"\'" + JSPUtil.getNull(rs.getString(  "COP_GRP_SEQ"  	))+"\'" + ","
//						+"\'" + JSPUtil.getNull(rs.getString(  "COP_DTL_SEQ" 	))+"\'" + ","
//						+"\'" + JSPUtil.getNull(rs.getString(  "ACT_DT"        	))+"\'" + ","
//						+"\'" + userId+"\'" + ","
//						+"\'" + cmmt_yn+"\'"
//	            		+");\n\n\n\n" +
//	            		"" );
//
//	        }
//	        rowSet.populate(rs);
//        } catch (SQLException se) {
//	        log.error(se.getMessage(), se);
//	        throw new DAOException(new ErrorHandler(se).getMessage());
//	    } catch (DAOException de) {
//	        log.error(de.getMessage(), de);
//	        throw de;
//	    } catch (Exception e) {
//	        log.error(e.getMessage(), e);
//	        throw new DAOException(e.getMessage());
//	    } finally {
//	        closeResultSet(rs);
//	        closeStatement(cs);
//	        closeStatement(ps);
//	        closeConnection(con);
//	    }
//		return result;
//	}
//
//	/** RAIL ETA Delay Exception 판별 로직
//	 *  I/B 구간
//	 *  SCE_EXCEPTION_RESIST_ACT_PRC 안에 로직 다 있으므로 prc call하는 method.
//	 * @param copNo
//	 * @return
//	 * @throws DAOException
//	 */
//	public String railEtaDelayExpt(String copNo, String copGrpSeq, String copDtlSeq, String rdEtaFlg, String nodeCd)  throws DAOException {
//		Connection con = null;
//        PreparedStatement ps = null;
//        CallableStatement cs = null;
//        ResultSet rs = null;
//        String queryStr = "";
//        String result = "";
//
//
//        int i = 1;
//
//
////        String copGrpSeq = "";
////        String copDtlSeq = "";
////        String actualDt = "";
////        String nodeCd = "";
////        String rdEtaFlg = "";
////        String rdEtaAl = "N";
////        String rdEtaRl = "N";
//
//        DBRowSet rowSet = new DBRowSet();
//        queryStr =
//
//        	"        select ACT_RCV_DT, ACT_RCV_NO, TO_CHAR(ACT_DT,'YYYYMMDDHH24MISS') ACT_DT      							"+"\n"+
//        	" 	     	  , TO_CHAR(RAIL_DEST_N1ST_ETA_DT,'YYYYMMDDHH24MISS') RAIL_DEST_N1ST_ETA_DT 						"+"\n"+
//        	" 	     from   sce_act_rcv_if ad,                                                                    			"+"\n"+
//        	" 	           	(select bkg_no, bkg_no_split, cntr_no from sce_cop_hdr 											"+"\n"+
//        	" 	           	 where cop_no = ? and cop_sts_cd NOT IN ('X','O') )V  											"+"\n"+
//        	" 	     where AD.BKG_NO = V.BKG_NO                                                             			"+"\n"+
//        	"	     and   AD.BKG_NO_SPLIT = V.BKG_NO_SPLIT                                                 			"+"\n"+
//        	" 	     and   AD.CNTR_NO = V.CNTR_NO                     													"+"\n"+
//        	" 	     and   AD.ACT_UMCH_TP_CD NOT IN ('00','XX') 														"+"\n"+
//        	" 	     and   AD.ACT_STS_MAPG_CD = ?																		"+"\n"+
//        	" 	     and   AD.NOD_CD = ?																				"+"\n"+
//        	"			"+"\n";
//
//        try{
//        	con = getConnection();
//
//	        if(LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//	            ps = new LoggableStatement(con, queryStr.toString());
//	        } else {
//	            ps = con.prepareStatement(queryStr.toString());
//	        }
//	        ps.setString(i++, copNo);
//	        ps.setString(i++, rdEtaFlg);
//	        ps.setString(i++, nodeCd);
//
//
//	        if(LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//  				log.debug(" SQL :\n" + ((LoggableStatement)ps).getQueryString());
//      	  	} else {
//      	  		log.debug(" SQL :\n" + queryStr.toString());
//      	  	}
//
//	        rs = ps.executeQuery();
//
//	        while(rs.next()){
//
////	        	int j = 1;
////
////	        	String queryStr1   = "{call RAIL_ETA_DELAY_EXPT_PRC(?,?,?,?,?,?,?,?)}";
////
////		        cs = con.prepareCall(queryStr1);
////	            cs.setString(j++,JSPUtil.getNull(rs.getString("ACT_RCV_DT")));
////	            cs.setString(j++,JSPUtil.getNull(rs.getString("ACT_RCV_NO")));
////	            cs.setString(j++,copNo);
////	            cs.setString(j++,copGrpSeq);
////	            cs.setString(j++,copDtlSeq );
////	            cs.setString(j++,JSPUtil.getNull(rs.getString("ACT_DT")));
////	            cs.setString(j++,JSPUtil.getNull(rs.getString("RAIL_DEST_N1ST_ETA_DT")));
////	            cs.setString(j++,rdEtaFlg);
////
////	            cs.executeUpdate();
//
////	            closeStatement(cs);
//
//
//	            	log.info("\n\n\n\n execute RAIL_ETA_DELAY_EXPT_PRC("
//						+"\'" + JSPUtil.getNull(rs.getString("ACT_RCV_DT"))+"\'" + ","
//						+"\'" + JSPUtil.getNull(rs.getString("ACT_RCV_NO"))+"\'" + ","
//						+"\'" + copNo+"\'" + ","
//						+"\'" + copGrpSeq+"\'" + ","
//						+"\'" + copDtlSeq+"\'" + ","
//						+"\'" + JSPUtil.getNull(rs.getString("ACT_DT"))+"\'"
//						+"\'" + JSPUtil.getNull(rs.getString("RAIL_DEST_N1ST_ETA_DT"))+"\'"
//						+"\'" + rdEtaFlg+"\'"
//	            		+");\n\n\n" );
//
//
//
//	        }
//	        rowSet.populate(rs);
//        } catch (SQLException se) {
//	        log.error(se.getMessage(), se);
//	        throw new DAOException(new ErrorHandler(se).getMessage());
//	    } catch (DAOException de) {
//	        log.error(de.getMessage(), de);
//	        throw de;
//	    } catch (Exception e) {
//	        log.error(e.getMessage(), e);
//	        throw new DAOException(e.getMessage());
//	    } finally {
//	        closeResultSet(rs);
//	        closeStatement(cs);
//	        closeStatement(ps);
//	        closeConnection(con);
//	    }
//		return result;
//
//
//	}
//


}

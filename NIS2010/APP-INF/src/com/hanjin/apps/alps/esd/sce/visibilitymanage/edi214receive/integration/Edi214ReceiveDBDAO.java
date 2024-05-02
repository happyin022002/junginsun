/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : Edi214ReceiveDBDAO.java
*@FileTitle : Service Scope
*Open Issues :
*Change history :
*@LastModifyDate : 2008-08-01
*@LastModifier : Y
*@LastVersion : 1.0
* 2008-08-01 Y
* 1.0 최초 생성
=========================================================*/


package com.hanjin.apps.alps.esd.sce.visibilitymanage.edi214receive.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.esd.sce.visibilitymanage.edi214receive.basic.Edi214ReceiveBCImpl;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.edi214receive.vo.SearchActualDateInfoVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
/**
 * ENIS-SCE에 대한 DB 처리를 담당<br>
 * - ENIS-SCE Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author yjlee
 * @see Edi214ReceiveBCImpl 참조
 * @since J2EE 1.4
 */
public class Edi214ReceiveDBDAO extends DBDAOSupport {

	/**
	 * EDI HDR 임시 저장하기
	 * @param SearchActualDateInfoVO msgVO
	 * @throws DAOException
	 */
	public void createEDI214TmpData(SearchActualDateInfoVO msgVO) throws DAOException {
		log.debug("createEDI214TmpData를 실행합니다.");
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{        	
        	if (msgVO != null) {
				Map<String, String> mapVO = msgVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
        	SQLExecuter sqlExe = new SQLExecuter("");
			log.debug("param==" + param);
			log.debug("velParam==" + velParam);
			
			int insCnt = 0;
			insCnt = sqlExe.executeUpdate(new Edi214ReceiveDBDAOCreateEDI214TmpDataCSQL(),
					param, null);
			return ;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * EDI로 접수된 data의 유효성을 체크한다.
	 * @param SearchActualDateInfoVO msgVo
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet validateEDI214(SearchActualDateInfoVO msgVo) throws DAOException {
		log.debug("validateEDI214를 실행합니다.");
    	DBRowSet dbRowset = null;
		//List<Edi214MsgVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String cop_no = "";

		try {
			if (msgVo != null) {
				Map<String, String> mapVO = msgVo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.debug("param"+ param);
			}

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi214ReceiveDBDAOSearchValidateEdi214RSQL(),
					param, velParam);

			//list = (List) RowSetUtil.rowSetToVOs(dbRowset,SearchCustomerDataVO.class);
			log.debug("dbRowset.getRowCount == " + dbRowset.getRowCount());
			if(dbRowset.next()) {
				cop_no = dbRowset.getString("COP_NO");
            	log.debug("cop_seq(if-in) == " + cop_no);
            }
			log.debug("cop_seq(if-out) == " + cop_no);
            
			return dbRowset;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}


//    /** ExptMst 테이블 cancel
//	 * @param String cop_seq
//	 * @return int
//	 * @throws DAOException
//	 */
//	public int updateExptMst(String cop_seq)  throws DAOException {
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
//        queryStr.append(" AND    COP_GRP_SEQ = ?          								\n");
//        queryStr.append(" AND    COP_DTL_SEQ = ?          								\n");
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
//	        ps.setString(i++, "edi214");
//	        ps.setString(i++, cop_seq.substring(4));
//	        ps.setString(i++, cop_seq.substring(0,3));
//	        ps.setString(i++, cop_seq.substring(3,4));
//
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
	 * SearchActualDateInfoVO msgVo
	 * 
	 * @param SearchActualDateInfoVO msgVo
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet callSceEstDue(SearchActualDateInfoVO msgVo) throws DAOException {
        log.debug("DAO - callSceEstDue 시작");
        DBRowSet dbRowset = null;
//        List<Edi214MsgVO> list = null;
        // query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		
		
//		String resultCd = "";
		
        try{        	
        	if (msgVo != null) {
				Map<String, String> mapVO = msgVo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			    log.debug("VO-param:"+ param);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi214ReceiveDBDAOSearchCallSceEstDueRSQL(),
					param, velParam);
			//list = (List) RowSetUtil.rowSetToVOs(dbRowset,Edi214MsgVO.class);
			
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}


//	/** Exception 판별 로직
//	 *  MVMT 대상으로 Actual Delay판별 
//	 *  SCE_EXCEPTION_RESIST_ACT_PRC 안에 로직 다 있으므로 prc call하는 method. 
//	 * @param copNo
//	 * @return
//	 * @throws DAOException
//	 */
//	public String callCopExptResistAct(String cop_seq, String deliveryDate)  throws DAOException {
//        Connection con = null;
//        CallableStatement cs = null;
//
//        String queryStr = "{call SCE_EXCEPTION_RESIST_ACT_PRC(?,?,?,?,?,?)}";
//        String resultCd = "";
//
//        try {
//            con = getConnection();
//
//            cs = con.prepareCall(queryStr);
//
//            cs.setString(1, cop_seq.substring(4));
//            cs.setString(2, cop_seq.substring(0,3));
//            cs.setString(3, cop_seq.substring(3,4));
//            cs.setString(4, deliveryDate);
//            cs.setString(5, "Edi214");
//            cs.setString(6, "N");
//            
//        	log.info("\n :::::::::::: execute SCE_EXCEPTION_RESIST_ACT_PRC(" 
//			+"\'" + cop_seq.substring(4)	+"\'" + ","
//			+"\'" + cop_seq.substring(0,3) 	+"\'" + ","
//			+"\'" + cop_seq.substring(3,4)	+"\'" + ","
//			+"\'" + deliveryDate			+"\'" + ","
//			+"\'" + "Edi214"				+"\'" + ","
//			+"\'" + "N"						+"\'"
//    		+");" +
//    		"" );
//
//            cs.executeUpdate();
//
//
//        } catch (SQLException se) {
//            log.error(se.getMessage(), se);
//            throw new DAOException(new ErrorHandler(se).getMessage());
//        } catch (DAOException de) {
//            log.error(de.getMessage(), de);
//            throw de;
//        } catch (Exception e) {
//            log.error(e.getMessage(), e);
//            throw new DAOException(e.getMessage());
//        } finally {
//            closeStatement(cs);
//            closeConnection(con);
//        }
//        return resultCd;
//	}	    

	/** 
	 * COP에 Actual Date를 Update 한다. 
	 * @param SearchActualDateInfoVO msgVo
	 * @param String cop_seq
	 * @return int
	 * @throws DAOException
	 */
	public int modifyEDI214ActualDate(SearchActualDateInfoVO msgVo, String cop_seq)  throws DAOException {
		log.debug("DAO - modifyEDI214ActualDate 를 시작");
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		
        try{        	
        	if (msgVo != null) {
        		msgVo.setCopSeq(cop_seq);
				Map<String, String> mapVO = msgVo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
        	SQLExecuter sqlExe = new SQLExecuter("");
			log.debug("param==" + param);
			log.debug("velParam==" + velParam);
			
			result = sqlExe.executeUpdate(new Edi214ReceiveDBDAOModifyEDI214ActualDateUSQL(),
					param, null);
			return result;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
}
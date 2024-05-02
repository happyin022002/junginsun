/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EQCOrgChartDBDAO.java
*@FileTitle : EQC Organization Chart
*Open Issues :
*Change history :
*@LastModifyDate : 2013-06-03
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrfcstsimul.eqcorgchart.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.eqr.cntrfcstsimul.eqcorgchart.vo.EQCOrgChartListVO;
import com.clt.bizcommon.eqorgchart.basic.EQOrgChartBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * eNIS-BIZCOMMON에 대한 DB 처리를 담당<br>
 * - eNIS-BIZCOMMON Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Hyung Choon_Roh
 * @see EQOrgChartBCImpl 참조
 * @since J2EE 1.4
 */
@SuppressWarnings("serial")
public class EQCOrgChartDBDAO extends DBDAOSupport {
	
	/**
     * 1. 기능 : EQC Organization count<p>
     * 2. 처리개요 : EQC Organization 의 총 카운트를 조회한다.<p>
     * - totalEQCOrgChartList<p>
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 :                   <br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
	 * @param String depth
	 * @param String chkDepth
     * @return int
     * @throws DAOException
     *
     */
	public int totalEQCOrgChartList(String depth, String chkDepth) throws DAOException {
		DBRowSet dbRowset = null;
    	//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
	        int iDepth		 = 0;        
	        if(depth != null && !depth.equals("")) {
	        	iDepth = Integer.parseInt(depth);        		
	        }
	        
	        if(iDepth < 4){
	        	velParam.put("idepth", iDepth);
	        }
	        dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EQCOrgChartDBDAOTotalListRSQL(), param, velParam);
			if (dbRowset.next()) {
				return dbRowset.getInt(1);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return 0;
	}
	
	/**
	 * EQCOrgChart의 모든 목록을 가져온다.<br>
	 * @param String depth
	 * @param String chkDepth
	 * @param String usrId
	 * @return List<EQQrgChartListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EQCOrgChartListVO> searchEQCOrgChartList(String depth, String chkDepth, String usrId) throws DAOException {
		DBRowSet dbRowset = null;
    	//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		//List
		List<EQCOrgChartListVO> list = null; 
		try {
	        
	        int iDepth		 = 0;        
	        if(depth != null && !depth.equals("")) {
	        	iDepth = Integer.parseInt(depth);
	        }
	        
	        if(iDepth < 4){
	        	velParam.put("idepth", iDepth);
	        }
	        param.put("usr_id", usrId);
	        dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EQCOrgChartDBDAOEQCOrgChartListRSQL(), param, velParam);
	        list = (List)RowSetUtil.rowSetToVOs(dbRowset, EQCOrgChartListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * EQR_CTRL_FCAST_LOC 테이블 건 삭제.<br>
	 * 
	 * @param String usrId
	 * @return int
	 * @exception DAOException
	 * @exception Exception
	 */
	public int removeEqrCtrlFcastLocData(String usrId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			param.put("usr_id", usrId);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new EQCOrgChartDBDAOremoveEqrCtrlFcastLocDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to insert SQL");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * EQR_CTRL_FCAST_LOC 테이블 건 생성<br>
	 * 
	 * @param List<EQCOrgChartListVO> eQCOrgChartListVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] addEqrCtrlFcastLocData(List<EQCOrgChartListVO> eQCOrgChartListVOs) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(eQCOrgChartListVOs .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new EQCOrgChartDBDAOaddEqrCtrlFcastLocCSQL(), eQCOrgChartListVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
}
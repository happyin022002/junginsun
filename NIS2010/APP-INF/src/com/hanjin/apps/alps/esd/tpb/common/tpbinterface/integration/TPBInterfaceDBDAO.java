/*=========================================================
*Copyright(c) Since 2009 CyberLogitec
*@FileName : OutstandingManageDBDAO.java
*@FileTitle : 3자구상 Interface (Receive; Source=>TPB)
*Open Issues :
*Change history :
*@LastModifyDate : 2009-08-20
*@LastModifier : O Wan-Ki
*@LastVersion : 1.0
* 2009-08-20 O Wan-Ki 1.0 최초 생성 
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.common.tpbinterface.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.tpb.common.tpbinterface.basic.TPBInterfaceBCImpl;
import com.hanjin.apps.alps.esd.tpb.common.tpbinterface.vo.TPBInterfaceVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ENIS-ESD에 대한 DB 처리를 담당<br>
 * - ENIS-ESD Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author O Wan-Ki
 * @see TPBInterfaceBCImpl 참조
 * @since J2EE 1.4
 */
public class TPBInterfaceDBDAO extends DBDAOSupport {

	/**
	 * TES로부터 3자구상 대상 건을 3rd Party Billing측 테이블(TPB_N3RD_PTY_BIL_IF)로 Interface(Receive) 처리한다. <br>
	 * <b><font color=blue>[SQL]</font></b> CALL TPB_CRE_IF_DATA_TES_PRC <br>
	 * @param List<TPBInterfaceVO> insModels
	 * @return boolean 처리 성공여부
	 * @throws DAOException
	 */
	public boolean createTESTPB(List<TPBInterfaceVO> insModels) throws DAOException {
		int insCnt[] = null;
		boolean isSuccessful = false; 
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TPBInterfaceDBDAOCreateTesTpbCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
				isSuccessful = true;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return isSuccessful; 
		
	}
	/**
	 * TRS로부터 3자구상 대상 건을 3rd Party Billing측 테이블(TPB_N3RD_PTY_BIL_IF)로 Interface(Receive) 처리한다. <br>
	 * <b><font color=blue>[SQL]</font></b> CALL TPB_CRE_IF_DATA_TRS_PRC <br>
	 * @param List<TPBInterfaceVO> insModels
	 * @return boolean 처리 성공여부
	 * @throws DAOException
	 */
	public boolean createTRSTPB(List<TPBInterfaceVO> insModels) throws DAOException {
		int insCnt[] = null;
		boolean isSuccessful = false; 
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TPBInterfaceDBDAOCreateTrsTpbCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
				isSuccessful = true;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return isSuccessful; 
		
	}
	
	/**
	 * MNR로부터 3자구상 대상 건을 3rd Party Billing측 테이블(TPB_N3RD_PTY_BIL_IF)로 Interface(Receive) 처리한다. <br>
	 * <b><font color=blue>[SQL]</font></b> CALL TPB_CRE_IF_DATA_TRS_PRC <br>
	 * @param List<TPBInterfaceVO> insModels
	 * @return boolean 처리 성공여부
	 * @throws DAOException
	 */
	public boolean createMNRTPB(List<TPBInterfaceVO> insModels) throws DAOException {
		int insCnt[] = null;
		boolean isSuccessful = false; 
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TPBInterfaceDBDAOCreateMnrTpbCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
				isSuccessful = true;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return isSuccessful; 
		
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param TPBInterfaceVO tpbInterfaceVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchTpbTesDltFlg(TPBInterfaceVO tpbInterfaceVO) throws DAOException {
		String resultFlag = "";
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(tpbInterfaceVO != null){
				Map<String, String> mapVO = tpbInterfaceVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TPBInterfaceDBDAOSearchTpbTesDltFlgRSQL(), param, velParam);
			if (dbRowset.next()) {
				resultFlag = dbRowset.getString("DLT_FLG");
				
				// resultFlag : 'Y' - Non TPB건으로 삭제 가능
				// resultFlag : 'N' - Candidate건으로 TPB 진행되지 않은 건
				// resultFlag : 'X' - TPB Confirm 진행 이후건으로 삭제 불가 
				// resultFlag : 'O' - I/F 대상 없음
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return resultFlag;
	}

}
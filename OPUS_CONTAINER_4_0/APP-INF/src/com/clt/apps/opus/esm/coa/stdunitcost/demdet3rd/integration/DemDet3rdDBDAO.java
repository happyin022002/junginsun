/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DemDet3rdDBDAO.java
*@FileTitle : DEM/DET 3RD조회수정
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2009.08.25 송호진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.demdet3rd.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.stdunitcost.demdet3rd.basic.DemDet3rdBCImpl;
import com.clt.apps.opus.esm.coa.stdunitcost.demdet3rd.vo.DemDet3rdVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * OPUS DemDet3rdDBDAO <br>
 * - OPUS-STDUnitCost system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Song Ho Jin
 * @see DemDet3rdBCImpl 참조
 * @since J2EE 1.6
DemDet3rdDBDAODemDet3rdVOUSQL
DemDet3rdDBDAOMultiDEMDET3RDUSQL
 */
public class DemDet3rdDBDAO extends DBDAOSupport {

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchConditionVO conditionVO
	 * @return List<DemDet3rdVO>
	 * @throws DAOException
	 */
	public List<DemDet3rdVO> searchDEMDET3RDList(SearchConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DemDet3rdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DemDet3rdDBDAOSearchDEMDET3RDListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DemDet3rdVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<DemDet3rdVO> demDet3rdVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyDEMDET3RD(List<DemDet3rdVO> demDet3rdVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(demDet3rdVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new DemDet3rdDBDAOMultiDEMDET3RDUSQL(), demDet3rdVO,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
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
		return updCnt;
	}
	
	/**
	 * [DEM/DET, Vol Discount (PA/RA)] 정보를 [추가] 합니다.<br>
	 * 
	 * @param List<DemDet3rdVO> demDet3rdVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] addDEMDET3RD(List<DemDet3rdVO> demDet3rdVO) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(demDet3rdVO .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new DemDet3rdDBDAOMultiDEMDET3RDCSQL(), demDet3rdVO,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insCnt;
	}
	
	/**
	 * [DEM/DET, Vol Discount (PA/RA)] 정보를 [삭제] 합니다.<br>
	 * 
	 * @param List<DemDet3rdVO> demDet3rdVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] deleteDEMDET3RD(List<DemDet3rdVO> demDet3rdVO) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(demDet3rdVO.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new DemDet3rdDBDAOMultiDEMDET3RDDSQL(), demDet3rdVO,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return delCnt;
	}
}
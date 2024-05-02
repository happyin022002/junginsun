/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InterfacedCancelDBDAO.java
*@FileTitle : InterfacedCancel
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 황건하
*@LastVersion : 1.0
* 2009.07.17 황건하
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.candidatemanage.interfacedcancel.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.tpb.candidatemanage.interfacedcancel.basic.InterfacedCancelBCImpl;
import com.clt.apps.opus.esd.tpb.candidatemanage.interfacedcancel.vo.SearchInterfacedCancelListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 *  InterfacedCancelDBDAO <br>
 * - -CandidateManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author GUN-HA HWANG
 * @see InterfacedCancelBCImpl 참조
 * @since J2EE 1.6
 */
public class InterfacedCancelDBDAO extends DBDAOSupport {
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchInterfacedCancelListVO SearchInterfacedCancelListVO
	 * @return List<SearchInterfacedCancelListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchInterfacedCancelListVO> searchCanceledTPB(SearchInterfacedCancelListVO SearchInterfacedCancelListVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<SearchInterfacedCancelListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(SearchInterfacedCancelListVO != null){
				Map<String, String> mapVO = SearchInterfacedCancelListVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InterfacedCancelDBDAOSearchInterfacedCancelListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchInterfacedCancelListVO .class);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SearchInterfacedCancelListVO> delModels
	 * @return int[]
	 * @throws DAOException
	 */
	public int[] removeInterfacedTPBCancel(List<SearchInterfacedCancelListVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new InterfacedCancelDBDAORemoveInterfacedCancelListDSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}

}
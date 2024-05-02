/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MSTCommonDBDAO.java
*@FileTitle : MST COMMON PAGE
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.27
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.06.18 이호선
* 1.0 Creation
*   
* History
* 2010.12.27 진마리아 [CHM-201007809-01] OWN CNTR Creation화면에서 Unit Type에 DF/UF추가 및 Full Name 표기
=========================================================*/
package com.hanjin.apps.alps.ees.mst.mstcommon.mstcommon.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.mst.mstcommon.mstcommon.basic.MSTCommonBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.apps.alps.ees.mst.mstcommon.mstcommon.vo.AgmtInfoVO;
import com.hanjin.apps.alps.ees.mst.mstcommon.mstcommon.vo.CommonListVO;

/**
 * NIS2010 MSTCommonDBDAO <br>
 * - NIS2010-MSTCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Lee Ho Sun
 * @see MSTCommonBCImpl 참조
 * @since J2EE 1.6
 */
public class MSTCommonDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Manufacturer List를 조회합니다.<br>
	 * 
	 * @param CommonListVO commonListVO
	 * @return List<CommonListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CommonListVO> searchManufacturerListData(CommonListVO commonListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CommonListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			if(commonListVO != null){
				Map<String, String> mapVO = commonListVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			
		    dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MSTCommonDBDAOsearchManufacturerListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CommonListVO .class);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * Eq Type Size를 조회합니다.<br>
	 * 
	 * @param CommonListVO commonListVO
	 * @return List<CommonListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CommonListVO> searchEqTypeSizeListData(CommonListVO commonListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CommonListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(commonListVO != null){
				Map<String, String> mapVO = commonListVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}				
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MSTCommonDBDAOsearchEqTypeSizeListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CommonListVO .class);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**                       
	 * Manufacture Place List를 조회합니다.<br>
	 * 
	 * @param CommonListVO commonListVO
	 * @return List<CommonListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CommonListVO> searchManufacturePlaceListData(CommonListVO commonListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CommonListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			if(commonListVO != null){
				Map<String, String> mapVO = commonListVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}					
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MSTCommonDBDAOsearchManufacturePlaceListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CommonListVO .class);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	} 
	
	/**
	 * EES_MST_0014 : retrieve<br>
	 * Lease Agreement List를 조회합니다.<br>
	 * 
	 * @param AgmtInfoVO agmtInfoVO
	 * @return List<AgmtInfoVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AgmtInfoVO> searchAgmtData(AgmtInfoVO agmtInfoVO) throws DAOException {
		 
		DBRowSet dbRowset = null;
		List<AgmtInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(agmtInfoVO != null){
				Map<String, String> mapVO = agmtInfoVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MSTCommonDBDAOSearchAgmtDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgmtInfoVO .class);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 * EES_MST_0014, EES_MST_0024 : retrieve<br>
	 * Yard Code를 조회합니다.<br>
	 * 
	 * @param CommonListVO commonListVO
	 * @return CommonListVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
 	public CommonListVO searchYardCodeData(CommonListVO commonListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CommonListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			if(commonListVO != null){
				Map<String, String> mapVO = commonListVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}					
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MSTCommonDBDAOSearchYardCodeDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CommonListVO .class);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list.get(0);
	}	 
 	
	/**
	 * Lessor 코드명을 조회합니다.<br>
	 * 
	 * @param CommonListVO commonListVO
	 * @return String
	 * @throws DAOException
	 */
 	public String searchLessorCodeData(CommonListVO commonListVO) throws DAOException {
		DBRowSet dbRowset = null;
		String code_nm = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{			
			if(commonListVO != null){
				Map<String, String> mapVO = commonListVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}					
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MSTCommonDBDAOSearchLessorCodeDataRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		code_nm = dbRowset.getString("CODE_NM");
	    	}			
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return code_nm;
	}
 	
	/**
	 * Reefer Type Code를 조회합니다.<br>
	 * 
	 * @return List<CommonListVO>
	 * @throws DAOException
	 */
 	@SuppressWarnings("unchecked")
	public List<CommonListVO> searchReeferTypeCodeListData() throws DAOException {
		DBRowSet dbRowset = null;
		List<CommonListVO> list = null;

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MSTCommonDBDAOsearchReeferTypeCodeListDataRSQL(), null, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CommonListVO .class);			
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
 	
 	/**
	 * COM_INTG_CD를 조회합니다.<br>
	 * @param String   intgCdId
	 * @param String   intgCdVal
	 * @return List<CommonListVO>
	 * @exception EventException
	 */	
	@SuppressWarnings("unchecked")
	public List<CommonListVO> searchComIntgCdListData(String intgCdId, String intgCdVal)throws DAOException {
		DBRowSet dbRowset = null;
		List<CommonListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (intgCdId != null) {
				param.put("intg_cd_id", intgCdId);
				param.put("intg_cd_val", intgCdVal);
				velParam.put("intg_cd_val", intgCdVal);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MSTCommonDBDAOSearchComIntgCdListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CommonListVO .class);			
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
}
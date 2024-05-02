/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MSTCommonDBDAO.java
*@FileTitle : MST COMMON PAGE
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
* History
=========================================================*/
package com.clt.apps.opus.ees.mst.mstcommon.mstcommon.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.integration.GeneralCodeSearchMgtDBDAOmodifyMnrQexeDataUSQL;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.integration.GeneralCodeSearchMgtDBDAOsearchMnrQexeDataRSQL;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.integration.GeneralCodeSearchMgtDBDAOsearchTabColInfoDataRSQL;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.ComboInitDataINVO;
import com.clt.apps.opus.ees.mst.mstcommon.mstcommon.basic.MSTCommonBCImpl;
import com.clt.apps.opus.ees.mst.mstcommon.mstcommon.vo.AgmtInfoVO;
import com.clt.apps.opus.ees.mst.mstcommon.mstcommon.vo.CommonListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * OPUS MSTCommonDBDAO <br>
 * - OPUS-MSTCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
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
			
		    dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MSTCommonDBDAOSearchManufacturerListDataRSQL(), param, velParam);
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MSTCommonDBDAOSearchEqTypeSizeListDataRSQL(), param, velParam);
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
			//dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MSTCommonDBDAOSearchManufacturePlaceListDataRSQL(), param, velParam);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MSTCommonDBDAOSearchManuFacturePlaceCodeListDataRSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MSTCommonDBDAOSearchReeferTypeCodeListDataRSQL(), null, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CommonListVO .class);			
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
 	
 	/**
	 * Humidity Control Code를 조회합니다.<br>
	 * 
	 * @return List<CommonListVO>
	 * @throws DAOException
	 */
 	@SuppressWarnings("unchecked")
	public List<CommonListVO> searchHumidityControlCodeListData() throws DAOException {
		DBRowSet dbRowset = null;
		List<CommonListVO> list = null;

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MSTCommonDBDAOSearchHumidityControlCodeListRSQL(), null, null);
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
	
	/**
	 * [EES_MST_QEXE] TEMP<br>
	 * 
	 * @param String sql
	 * @return int
	 * @exception DAOException
	 */
	public int modifyMstQexeData(String sql) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;

		try {
			Map<String, String> mapVO = new ComboInitDataINVO().getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new GeneralCodeSearchMgtDBDAOmodifyMstQexeDataUSQL(sql), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * [EES_MST_QEXE] TEMP <br>
	 * 
	 * @param String sql
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchMstQexeData(String sql) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralCodeSearchMgtDBDAOsearchMstQexeDataRSQL(sql), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * [EES_MST_QEXE] TEMP <br>
	 * 
	 * @param String tabName
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchTabColInfoData(String tabName) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("tab_name", tabName);
			velParam.put("tab_name", tabName);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralCodeSearchMgtDBDAOsearchTabColInfoDataRSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	
	/**
	 * USER_INFO_CD를 조회합니다.<br>
	 * @param String   inputUser
	 * @return String
	 * @exception EventException
	 */	
	@SuppressWarnings("unchecked")
	public String searchUserInfoData(String inputUser)throws DAOException {
		DBRowSet dbRowset = null;
		String strPw = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (inputUser != null) {
				param.put("input_user", inputUser);
				velParam.put("input_user", inputUser);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MSTCommonDBDAOSearchUserInfoDataRSQL(), param, velParam);
			if(dbRowset.next()) {
				strPw = dbRowset.getString("USR_PWD");
	    	}	
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strPw;
	}
	
	
	/**
	 * SAKURA INFO 를 조회합니다.<br>
	 * @return List<CommonListVO>
	 * @exception EventException
	 */	
	@SuppressWarnings("unchecked")
	public List<CommonListVO> searchSakuraCdListData()throws DAOException {
		DBRowSet dbRowset = null;
		List<CommonListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MSTCommonDBDAOSearchSakuraCdListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CommonListVO .class);			
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
}
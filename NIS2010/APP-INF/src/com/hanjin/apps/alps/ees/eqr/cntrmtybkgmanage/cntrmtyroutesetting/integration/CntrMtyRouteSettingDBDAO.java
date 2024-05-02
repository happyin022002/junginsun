/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CntrMtyRouteSettingDBDAO.java
*@FileTitle : CntrMtyRouteSettingDBDAO
*Open Issues :
*Change history : 최초등록
*@LastModifyDate : 2016.08.01
*@LastModifier : 두기민
*@LastVersion : 1.0
* 2013.07.30 두기민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtyroutesetting.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtyroutesetting.basic.CntrMtyRouteSettingBCImpl;
import com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtyroutesetting.vo.EesEqr1019RouteSettingVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS CntrMtyRouteSettingDBDAO <br>
 * - ALPS-RepoPlanManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 두기민
 * @see CntrMtyRouteSettingBCImpl 참조
 * @since J2EE 1.6
 */
public class CntrMtyRouteSettingDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * [ EES_EQR_1019 ]<br>
	 * 
	 * @param EesEqr1019RouteSettingVO eesEqr1019RouteSettingVO
	 * @return List<EesEqr1019RouteSettingVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EesEqr1019RouteSettingVO> searchCntrMtyRouteSettingList(EesEqr1019RouteSettingVO eesEqr1019RouteSettingVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<EesEqr1019RouteSettingVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(eesEqr1019RouteSettingVO != null){
				Map<String, String> mapVO = eesEqr1019RouteSettingVO.getColumnValues();
				
				param.putAll(mapVO);								
				velParam.putAll(mapVO);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrMtyRouteSettingDBDAOSearchCntrMtyRouteSettingListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, EesEqr1019RouteSettingVO .class);
			}

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
	 * [ EES_EQR_1019 ]<br>
	 * 
	 * @param EesEqr1019RouteSettingVO eesEqr1019RouteSettingVO
	 * @return List<EesEqr1019RouteSettingVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EesEqr1019RouteSettingVO> searchCntrTpSzList(EesEqr1019RouteSettingVO eesEqr1019RouteSettingVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<EesEqr1019RouteSettingVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(eesEqr1019RouteSettingVO != null){
				Map<String, String> mapVO = eesEqr1019RouteSettingVO.getColumnValues();
				
				param.putAll(mapVO);								
				velParam.putAll(mapVO);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrMtyRouteSettingDBDAOsearchCntrTpSzListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, EesEqr1019RouteSettingVO .class);
			}

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
	 * EES_EQR_1019 : [이벤트]<br>
	 * MTY BKG ROUTE SETTING Location 유효성 조회.
	 * @param EesEqr1019RouteSettingVO eesEqr1019RouteSettingVO
	 * @return int
	 * @exception DAOException
	 */
	public int checkLocationDuplication(EesEqr1019RouteSettingVO eesEqr1019RouteSettingVO) throws DAOException {
		DBRowSet dbRowset = null;
    	//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		//List
		int count = 0; 
		try {
			Map<String, String> mapVO = eesEqr1019RouteSettingVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
	        dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrMtyRouteSettingDBDAOCheckLocationDuplicationRSQL(), param, velParam);
	        
	        if(dbRowset != null){
	        	if(dbRowset.next()){
	        		count = Integer.parseInt(dbRowset.getString("CNT"));
	        	}
	        }
	        
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return count;
	}
	
	/**
	 * EES_EQR_1019 : [이벤트]<br>
	 * MTY BKG ROUTE SETTING Location 유효성 조회. <br>
	 * 
	 * @param EesEqr1019RouteSettingVO eesEqr1019RouteSettingVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchLocationByRccCode(EesEqr1019RouteSettingVO eesEqr1019RouteSettingVO) throws DAOException {
		DBRowSet dbRowset = null;
    	//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		//List
		String rccCd = "N"; 
		try {
			Map<String, String> mapVO = eesEqr1019RouteSettingVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
	        dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrMtyRouteSettingDBDAOSearchLocationByRccCodeRSQL(), param, velParam);
	        
	        if(dbRowset != null){
	        	if(dbRowset.next()){
	        		rccCd = dbRowset.getString("RCC");
	        	}
	        }
	        
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rccCd;
	}
	
	/**
	 * EES_EQR_1019 : [이벤트]<br>
	 * MTY BKG ROUTE SETTING Location 유효성 조회.<br>
	 * 
	 * @param EesEqr1019RouteSettingVO eesEqr1019RouteSettingVO
	 * @return int
	 * @exception DAOException
	 */
	public int checkLocationByGroupCode(EesEqr1019RouteSettingVO eesEqr1019RouteSettingVO) throws DAOException {
		DBRowSet dbRowset = null;
    	//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		//List
		int count = 0; 
		try {
			Map<String, String> mapVO = eesEqr1019RouteSettingVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
	        dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrMtyRouteSettingDBDAOsearchLocationCodeByTypeRSQL(), param, velParam);
	        
	        if(dbRowset != null){
	        	if(dbRowset.next()){
	        		count = Integer.parseInt(dbRowset.getString("CNT"));
	        	}
	        }
	        
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return count;
	}
	
	
	/**
	 * [ EES_EQR_1019 : MTY BKG ROUTE SETTING 화면 수정.<]<br>
	 * 
	 * @param EesEqr1019RouteSettingVO eesEqr1019RouteSettingVO
	 * @exception DAOException
	 */
	public void modifyCntrMtyRouteSettingList(EesEqr1019RouteSettingVO eesEqr1019RouteSettingVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.putAll(eesEqr1019RouteSettingVO.getColumnValues());
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrMtyRouteSettingDBDAOCntrMtyRouteSettingListUSQL(), param, null);
			
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
	}
	
	/**
	 * [ EES_EQR_1019 : tp/sz save]<br>
	 * 
	 * @param EesEqr1019RouteSettingVO eesEqr1019RouteSettingVO
	 * @exception DAOException
	 */
	public void addCntrTpSzList(EesEqr1019RouteSettingVO eesEqr1019RouteSettingVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.putAll(eesEqr1019RouteSettingVO.getColumnValues());
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrMtyRouteSettingDBDAOCntrTpSzListCSQL(), param, null);
			
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
	}
	
	/**
	 * [ EES_EQR_1019]<br>
	 * 
	 * @param String ibFlag
	 * @param EesEqr1019RouteSettingVO eesEqr1019RouteSettingVO
	 * @exception DAOException
	 */
	public void deleteCntrTpSzList(EesEqr1019RouteSettingVO eesEqr1019RouteSettingVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.putAll(eesEqr1019RouteSettingVO.getColumnValues());
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrMtyRouteSettingDBDAOCntrTpSzListDSQL(), param, null);
			
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
	}
	
	/**
	 * [ EES_EQR_1019]<br>
	 * 
	 * @param EesEqr1019RouteSettingVO eesEqr1019RouteSettingVO
	 * @exception DAOException
	 */
	public void deleteBKGCntrTpSzList(EesEqr1019RouteSettingVO eesEqr1019RouteSettingVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.putAll(eesEqr1019RouteSettingVO.getColumnValues());
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrMtyRouteSettingDBDAOBKGCntrTpSzListDSQL(), param, null);
			
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
	}
	
	/**
	 * [ EES_EQR_1019]<br>
	 * 
	 * @param String ibFlag
	 * @param EesEqr1019RouteSettingVO eesEqr1019RouteSettingVO
	 * @exception DAOException
	 */
	public void deleteCntrMtyRouteSettingList(EesEqr1019RouteSettingVO eesEqr1019RouteSettingVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.putAll(eesEqr1019RouteSettingVO.getColumnValues());
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrMtyRouteSettingDBDAOCntrMtyRouteSettingListDSQL(), param, null);
			
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
	}
	
}
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerSupplyDemandPlanDBDAO.java
*@FileTitle : Container Purchasing Trend by Year & input & update
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.06.11 이호선
* 1.0 Creation
* ===========================================================
* 2010.08.03 남궁진호 - 소스품질 개선
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.basic.ContainerSupplyDemandPlanBCImpl;
import com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.vo.EqPriceDetailVO;
import com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.vo.EqPriceOptionVO;
import com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.vo.EqPurSubListVO;
import com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.vo.ProcurementDetailVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS ContainerSupplyDemandPlanDBDAO <br>
 * - ALPS-EquipmentOperationPlan system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Lee Ho Sun
 * @see ContainerSupplyDemandPlanBCImpl 참조
 * @since J2EE 1.6
 */
public class ContainerSupplyDemandPlanDBDAO extends DBDAOSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * EES_MST_0034 : retrieve <br>
	 * Year/Month와 EQ Type으로 해당되는 값을 검색한다.<br>
	 * @author LEE HO SUN
	 * @category EES_MST_0034_1
	 * @category searchEqPriceListData    
	 * @param EqPriceOptionVO eqPriceOptionVO
	 * @return List<EqPriceDetailVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<EqPriceDetailVO> searchEqPriceListData(EqPriceOptionVO eqPriceOptionVO) throws DAOException {
		 
		DBRowSet dbRowset = null;
		List<EqPriceDetailVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//파라미터 맵핑시에 모델 설계 문서 질문
			
			if(eqPriceOptionVO != null){
				Map<String, String> mapVO = eqPriceOptionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerSupplyDemandPlanDBDAOEqPriceDetailVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EqPriceDetailVO .class);
			
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	* EES_MST_0034 : save <br>
	* 입력데이타의 유효성을 체크한다.<br>
    * Validation 체크시 RowCount > 0 true <br>
	* @author NAM KOONG JIN HO
	* @category EES_MST_0034_2
	* @category validationEqPriceData    
	* @param EqPriceDetailVO eqPriceDetailVO
	* @return boolean
	* @throws DAOException, Exception
	*/	 
	public boolean  validationEqPriceData(EqPriceDetailVO eqPriceDetailVO) throws DAOException {
		DBRowSet dbRowset = null;
		boolean result = false;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(eqPriceDetailVO != null){
				Map<String, String> mapVO = eqPriceDetailVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			                                                              
		    dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerSupplyDemandPlanDBDAOValidationEqPriceDataRSQL(), param, velParam);
		    if(dbRowset.getRowCount() > 0 )
				result = true;			
			
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result ;
	}
	
	/**
	* EES_MST_0034 : 화면 load시 <br>
	* ManufacturerList를 검색한다.<br>
	* @author LEE HO SUN
	* @category EES_MST_0034_3
	* @category searchManufacturerListData    
	* @param EqPriceDetailVO eqPriceDetailVO
	* @return List<EqPriceDetailVO>
	* @throws DAOException
	*/	
	 @SuppressWarnings("unchecked")
	public List<EqPriceDetailVO> searchManufacturerListData(EqPriceDetailVO eqPriceDetailVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EqPriceDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			if(eqPriceDetailVO != null){
				Map<String, String> mapVO = eqPriceDetailVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			                                                              
		    dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerSupplyDemandPlanDBDAOsearchManufacturerListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EqPriceDetailVO .class);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 * EES_MST_0034 :화면 load시 <br>
	 * Delivery Location을 검색한다.<br>
	 * @author LEE HO SUN
	 * @category EES_MST_0034_4
	 * @category searchManufacturePlaceListData    
	 * @param EqPriceDetailVO eqPriceDetailVO
	 * @return List<EqPriceDetailVO>
	 * @throws DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public List<EqPriceDetailVO> searchManufacturePlaceListData(EqPriceDetailVO eqPriceDetailVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EqPriceDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			if(eqPriceDetailVO != null){
				Map<String, String> mapVO = eqPriceDetailVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}					
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerSupplyDemandPlanDBDAOSearchLocationDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EqPriceDetailVO .class);
			
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	} 	 
	 
	/**
	 * EES_MST_0034 : save <br> 
	 * Manufacturer, Delivery Location, TP/SZ, QTY, Price등을 포함한 데이타를 추가 한다.<br>
     * Insert시 에러 발생 할 경우 exception 처리 안함. 에러 flag 이용 화면에서 메시지 처리 <br>
	 * @author LEE HO SUN
	 * @category EES_MST_0034_5
	 * @category addEqPriceData  
	 * @param EqPriceDetailVO eqPriceDetailVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int addEqPriceData (EqPriceDetailVO eqPriceDetailVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;		
		try {
			if(eqPriceDetailVO != null){
				Map<String, String> mapVO = eqPriceDetailVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new ContainerSupplyDemandPlanDBDAOEqPriceDetailVOCSQL(), param, velParam);
//				if(result == Statement.EXECUTE_FAILED){
					//eqPriceDetailVO.setInsflg("E");
//					throw new DAOException("");					
//				}		
			}					
		} catch (SQLException se) {
			//eqPriceDetailVO.setInsflg("E");
			throw new DAOException(se.getMessage());			
		}catch(Exception ex){
			//eqPriceDetailVO.setInsflg("E");
			throw new DAOException(ex.getMessage());			
		}
		return result;
	}
		
	/**
	 * ees_mst_0034 : save<br>
	 * Manufacturer, Delivery Location, TP/SZ, QTY, Price등을 포함한 데이타를 수정 한다.<br>
     * Update시 에러 발생 할 경우 exception 처리 안함. 에러 flag 이용 화면에서 메시지 처리 <br>
	 * @author LEE HO SUN
	 * @category EES_MST_0034_6
	 * @category modifyEqPriceData  
	 * @param EqPriceDetailVO eqPriceDetailVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception 
	 */
	public int modifyEqPriceData(EqPriceDetailVO eqPriceDetailVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = eqPriceDetailVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ContainerSupplyDemandPlanDBDAOEqPriceDetailVOUSQL(), param, velParam);
//			if(result == Statement.EXECUTE_FAILED)
//				throw new DAOException("1");				
				
		} catch (SQLException se) {
			throw new DAOException(se.getMessage());
		}catch(Exception ex){
			throw new DAOException(ex.getMessage());
		}
	return result;
	}		
	
	/**
	 * EES_MST_0034 : save<br>
	 * Manufacturer, Delivery Location, TP/SZ, QTY, Price등을 포함한 데이타를 삭제 한다.<br>
     * Delete시 에러 발생 할 경우 exception 처리 안함. 에러 flag 이용 화면에서 메시지 처리 <br> 
	 * @author LEE HO SUN
	 * @category EES_MST_0034_7
	 * @category removeEqPriceData  
	 * @param EqPriceDetailVO eqPriceDetailVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception 
	 */
	public int removeEqPriceData(EqPriceDetailVO eqPriceDetailVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;		
		
		try {
			Map<String, String> mapVO = eqPriceDetailVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ContainerSupplyDemandPlanDBDAOEqPriceDetailVODSQL(), param, velParam);
//			if(result == Statement.EXECUTE_FAILED)
//				throw new DAOException("");
		} catch (SQLException se) {
			throw new DAOException(se.getMessage());
		}catch(Exception ex){
			throw new DAOException(ex.getMessage());
		}
		return result;
	}
	
	/**
	 * EES_MST_0039 :  retrieve <br>
	 * Location code List 데이타를 조회한다.<br>
	 * @author LEE HO SUN
	 * @category EES_MST_0039_1
	 * @category searchEqPriceReportLocListData  
	 * @param EqPriceOptionVO eqPriceOptionVO
	 * @return List<EqPurSubListVO>
	 * @throws DAOException
	 */	
	public List<EqPurSubListVO> searchEqPriceReportLocListData(EqPriceOptionVO eqPriceOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EqPurSubListVO> list = new ArrayList<EqPurSubListVO>();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			
			//파라미터 맵핑시에 모델 설계 문서 질문
			if(eqPriceOptionVO != null){
				Map<String, String> mapVO = eqPriceOptionVO .getColumnValues();
			
				String sTpsz = eqPriceOptionVO.getCntrTpszCd();

				List<String> tpszCdList = new ArrayList<String>();
				StringTokenizer st = new StringTokenizer(sTpsz, ",");
				     
		        while (st.hasMoreTokens()) {
		        	tpszCdList.add(st.nextToken());
		        }
		        
				velParam.put("vel_tpsz_cd", tpszCdList);				
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerSupplyDemandPlanDBDAOSearchEqPriceDataSubSeqRSQL(), param, velParam);
			while (dbRowset.next()) {
				EqPurSubListVO eqPurSubListVO = new EqPurSubListVO();
				eqPurSubListVO.setPurList(dbRowset.getString("loc_cd"));
				list.add(eqPurSubListVO);
			}
			
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
	/**
	 * EES_MST_0039 : retrieve <br>  
	 * Year/Month, Location, TP/SZ, EQ Type으로 데이타를 조회한다.<br>
	 * @author LEE HO SUN
	 * @category EES_MST_0039_2
	 * @category searchEqPriceReportData  
	 * @param EqPriceOptionVO eqPriceOptionVO
	 * @param List<EqPurSubListVO> eqPurSubListVOs
	 * @return List<EqPurSubListVO>
	 * @throws DAOException
	 */		
	 @SuppressWarnings("unchecked")
	public List<EqPurSubListVO> searchEqPriceReportData(EqPriceOptionVO eqPriceOptionVO, List<EqPurSubListVO> eqPurSubListVOs) throws DAOException {
		 
		DBRowSet dbRowset = null;
		List<EqPurSubListVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//파라미터 맵핑시에 모델 설계 문서 질문
			
			if(eqPriceOptionVO != null){
				Map<String, String> mapVO = eqPriceOptionVO .getColumnValues();
				
				String sTpsz = eqPriceOptionVO.getCntrTpszCd();

				List<String> tpszCdList = new ArrayList();
				StringTokenizer st = new StringTokenizer(sTpsz, ",");
				     
		        while (st.hasMoreTokens()) {
		        	tpszCdList.add(st.nextToken());
		        }
		        
				velParam.put("vel_tpsz_cd", tpszCdList);				
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			ArrayList array = new ArrayList();			
			
			for(int i = 0; i < eqPurSubListVOs.size(); i++) {
				Map rtnHash = new HashMap();
				rtnHash.put("cnt", i+1);
				rtnHash.put("loc_cd", eqPurSubListVOs.get(i).getPurList());
				array.add(rtnHash);
			}			
			
			Iterator it = array.iterator();
			velParam.put("paramlist", it);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerSupplyDemandPlanDBDAOEqPurPrcReportDetailVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EqPurSubListVO.class);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	 
	/**
	 * 연도별 Equipment Procurement를 조회한다.<br>
	 * 
     * @author J.H.Min
     * @category EES_MST_0033
     * @category searchProcurementPlanResultReportBasic 
	 * 
     * @param ProcurementDetailVO procurementDetailVO
     * @return List<ProcurementDetailVO>
	 * @throws DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<ProcurementDetailVO> searchProcurementPlanResultReportData(ProcurementDetailVO procurementDetailVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ProcurementDetailVO> list = null;	
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{			
			if(procurementDetailVO != null){
				Map<String, String> mapVO = procurementDetailVO.getColumnValues();
		        
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerSupplyDemandPlanDBDAOSearchProcurementPlanResultReportDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ProcurementDetailVO.class);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	 
	
	/**
	 * 연말 추정 재고를 기초로 작성한 장비 TY-SZ별 차년도 장비 확보 계획을 조회한다.<br>
	 * 
     * @author J.H.Min
     * @category EES_MST_0040
     * @category searchProcurementPlanListData 
	 * 
	 * @param ProcurementDetailVO procurementDetailVO
	 * @return List<ProcurementDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ProcurementDetailVO> searchProcurementPlanListData(ProcurementDetailVO procurementDetailVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ProcurementDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{			
			if(procurementDetailVO != null){
				Map<String, String> mapVO = procurementDetailVO.getColumnValues();
						        
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerSupplyDemandPlanDBDAOSearchProcurementPlanListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ProcurementDetailVO.class);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	 			
						
		
    /**
	 * 연말 추정 재고를 기초로 작성한 장비 TY-SZ별 차년도 장비 확보 계획을 생성한다.<br> 
	 * 
	 * @author J.H.Min
	 * @category EES_MST_0040
	 * @category addProcurementPlanData
	 * 
	 * @param List<ProcurementDetailVO> procurementDetailVOs
	 * @throws DAOException
	*/
	public void addProcurementPlanData(List<ProcurementDetailVO> procurementDetailVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insertCnt[] = null;
			if(procurementDetailVOs.size() > 0){								
				insertCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerSupplyDemandPlanDBDAOAddProcurementPlanDataCSQL(), procurementDetailVOs, null);
				for(int i = 0; i < insertCnt.length; i++){
					if(insertCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}	 
 	 
	
    /**
	 *  연말 추정 재고를 기초로 작성한 장비 TY-SZ별 차년도 장비 확보 계획을 수정한다.<br> 
	 * 
	 * @author J.H.Min
	 * @category EES_MST_0040
	 * @category modifyProcurementPlanData
	 * 
	 * @param List<ProcurementDetailVO> procurementDetailVOs
	 * @throws DAOException
	*/
	public void modifyProcurementPlanData(List<ProcurementDetailVO> procurementDetailVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updateCnt[] = null;
			if(procurementDetailVOs.size() > 0){
				updateCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerSupplyDemandPlanDBDAOModifyProcurementPlanDataUSQL(), procurementDetailVOs, null);
				for(int i = 0; i < updateCnt.length; i++){
					if(updateCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}	
	
}
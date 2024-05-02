/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AssetsAuditMgtDBDAO.java
*@FileTitle : Output Alive EQ Master Data for Owned Equipment
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.09.01 이호선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.basic.AssetsAuditMgtBCImpl;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.vo.AssetsAuditDetailVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.vo.AssetsDetailVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.vo.AssetsOptionVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.vo.AssetsSmryVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.vo.EqAsetAudVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.vo.EqAverageUsingDayVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.vo.EqMftPlanListVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.vo.EqMftPlanOptionVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.vo.EqAsetDpcAmtVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS ContainerOnOffhireDBDAO <br>
 * - ALPS-EquipmentManagement system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Ho Sun Lee
 * @see AssetsAuditMgtBCImpl 참조
 * @since J2EE 1.6
 */
public class AssetsAuditMgtDBDAO extends DBDAOSupport {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * EES_MST_0032 : Version Retrieve <br>
     * output Alive EQ Master Data for Owned Equipment을 Month와 Eq Type에 따라 Version을 조회 합니다.<br>
	 * @author LEE HO SUN
	 * @category EES_MST_0032_1
	 * @category searchAssetsAuditVersionListData     
     * @param  EqAsetAudVO eqAsetAudVO
     * @return List<EqAsetAudVO>
     * @throws EventException
     */
	 @SuppressWarnings("unchecked")	
	 public List<EqAsetAudVO> searchAssetsAuditVersionListData(EqAsetAudVO eqAsetAudVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<EqAsetAudVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(eqAsetAudVO != null){
					Map<String, String> mapVO = eqAsetAudVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AssetsAuditMgtDBDAOSearchAssetsAuditVersionListDataRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, EqAsetAudVO .class);
	
			}catch(SQLException se){
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
	 }
	 
    /**
     * EES_MST_0032 : Retrieve <br> 
     * output Alive EQ Master Data for Owned Equipment을 검색조건에 따라 마스터를 조회합니다.<br>
	 * @author LEE HO SUN
	 * @category EES_MST_0032_2
	 * @category searchAssetsAuditData      
     * @param  EqAsetAudVO  eqAsetAudVO
     * @return EqAsetAudVO
     * @throws EventException
     */
	 @SuppressWarnings("unchecked")
	 public EqAsetAudVO searchAssetsAuditData(EqAsetAudVO eqAsetAudVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<EqAsetAudVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(eqAsetAudVO != null){
					Map<String, String> mapVO = eqAsetAudVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AssetsAuditMgtDBDAOSearchAssetsAuditDataRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, EqAsetAudVO .class);
				
			}catch(SQLException se){
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list.get(0);
	 }
	 
    /**
     * EES_MST_0032 : retrieve 
     * Output Alive EQ Master Data for Owned Equipment을 검색조건에 따라 디테일을 조회합니다.<br>
	 * @author LEE HO SUN
	 * @category EES_MST_0032_1
	 * @category searchAssetsAuditResultListData     
     * @param  EqAsetAudVO eqAsetAudVO
     * @return List<AssetsAuditDetailVO>
     * @throws EventException
     */
	 @SuppressWarnings("unchecked")
	 public List<AssetsAuditDetailVO> searchAssetsAuditResultListData(EqAsetAudVO eqAsetAudVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<AssetsAuditDetailVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(eqAsetAudVO != null){
					Map<String, String> mapVO = eqAsetAudVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AssetsAuditMgtDBDAOSearchAssetsAuditResultListDataRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, AssetsAuditDetailVO .class);
				
			}catch(SQLException se){
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
	 }
	 
	/**
	 * ees_mst_0032 : save<br>
	 * Output Alive EQ Master Data for Owned Equipmen을 디테일 Remark 저장 합니다.<br>
	 * @author LEE HO SUN
	 * @category EES_MST_0032_2
	 * @category modifyAssetsAuditResultData      
	 * @param List<AssetsAuditDetailVO> assetsAuditDetailVOs
	 * @exception EventException
	 */	 	 	 
	public void modifyAssetsAuditResultData(List<AssetsAuditDetailVO> assetsAuditDetailVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(assetsAuditDetailVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new AssetsAuditMgtDBDAOModifyAssetsAuditResultDataUSQL(), assetsAuditDetailVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}	
	} 	 
	 
	/**
	 * ees_mst_0032 : save<br>
	 * Output Alive EQ Master Data for Owned Equipment을 대한 마스터 Remark 저장 이벤트 처리합니다.<br>
	 * @author LEE HO SUN
	 * @category EES_MST_0032_3
	 * @category modifyAssetsAuditData     
	 * @param AssetsAuditDetailVO assetsAuditDetailVO
	 * @return AssetsAuditDetailVO
	 * @exception EventException
	 */	 	 	 
	public AssetsAuditDetailVO modifyAssetsAuditData(AssetsAuditDetailVO assetsAuditDetailVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();			
	
		int result = 0;		
		try {

			Map<String, String> mapVO = assetsAuditDetailVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new AssetsAuditMgtDBDAOModifyAssetsAuditDataUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Update SQL");		
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
		return assetsAuditDetailVO;		
	}
	
	/**
	 * 연도별 자산 집계현황을 조회한다.<br>
	 * 
	 * @author J.H.Min
	 * @category EES_MST_0041
	 * @category searchAssetsSmryOwnListData  
	 *  
	 * @param AssetsOptionVO assetsOptionVO
	 * @return List<AssetsSmryVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")	
	 public List<AssetsSmryVO> searchAssetsSmryOwnListData(AssetsOptionVO assetsOptionVO) throws DAOException {			 						 
			DBRowSet dbRowset = null;
			List<AssetsSmryVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(assetsOptionVO != null){
					Map<String, String> mapVO = assetsOptionVO.getColumnValues();
					
					String sTpsz = assetsOptionVO.getCntrTpszCd();
					
					List<String> tpszCdList = new ArrayList<String>();
					StringTokenizer st = new StringTokenizer(sTpsz, ",");							
				
			        while (st.hasMoreTokens()) {
			        	tpszCdList.add(st.nextToken());
			        }
					velParam.put("vel_tpsz_cd", tpszCdList);		

					param.putAll(mapVO);
					velParam.putAll(mapVO);										        
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AssetsAuditMgtDBDAOSearchAssetsSmryOwnListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, AssetsSmryVO.class);
				
			}catch(SQLException se){
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
	 }
	 
	/**
	 * 연도별 자산 집계현황을 조회한다.(임대)<br>
	 * 
	 * @author Dong-sun Moon
	 * @category EES_MST_0041
	 * @category searchAssetsSmryLeaseListData  
	 *  
	 * @param AssetsOptionVO assetsOptionVO
	 * @return List<AssetsSmryVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")	
	 public List<AssetsSmryVO> searchAssetsSmryLeaseListData(AssetsOptionVO assetsOptionVO) throws DAOException {			 						 
			DBRowSet dbRowset = null;
			List<AssetsSmryVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(assetsOptionVO != null){
					Map<String, String> mapVO = assetsOptionVO.getColumnValues();
					
					String sTpsz = assetsOptionVO.getCntrTpszCd();
					
					List<String> tpszCdList = new ArrayList<String>();
					StringTokenizer st = new StringTokenizer(sTpsz, ",");							
				
			        while (st.hasMoreTokens()) {
			        	tpszCdList.add(st.nextToken());
			        }
					velParam.put("vel_tpsz_cd", tpszCdList);		

					param.putAll(mapVO);
					velParam.putAll(mapVO);										        
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AssetsAuditMgtDBDAOSearchAssetsSmryLeaseListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, AssetsSmryVO.class);
				
			}catch(SQLException se){
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
	 }
	 
	 /**
	 * 연도별 자산 현황을 장비별로 상세 조회한다.<br>
	 * 
	 * @author kjo
	 * @category EES_MST_0041
	 * @category searchAssetsDetailOwnListData 
	 * 
	 * @param AssetsOptionVO assetsOptionVO
	 * @return List<AssetsDetailVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<AssetsDetailVO> searchAssetsDetailOwnListData(AssetsOptionVO assetsOptionVO) throws DAOException {			 						 
			DBRowSet dbRowset = null;
			List<AssetsDetailVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(assetsOptionVO != null){
					Map<String, String> mapVO = assetsOptionVO.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);										        
				}

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AssetsAuditMgtDBDAOSearchAssetsDetailOwnListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, AssetsDetailVO.class);
				
			}catch(SQLException se){
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
	 }	
	 
	 /**
		 * 연도별 자산 현황을 장비별로 상세 조회한다.(임대)<br>
		 * 
		 * @author Dong-sun Moon
		 * @category EES_MST_0041
		 * @category searchAssetsDetailLeaseListData 
		 * 
		 * @param AssetsOptionVO assetsOptionVO
		 * @return List<AssetsDetailVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		 public List<AssetsDetailVO> searchAssetsDetailLeaseListData(AssetsOptionVO assetsOptionVO) throws DAOException {			 						 
				DBRowSet dbRowset = null;
				List<AssetsDetailVO> list = null;
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();

				try{
					if(assetsOptionVO != null){
						Map<String, String> mapVO = assetsOptionVO.getColumnValues();
						
						String sTpsz = assetsOptionVO.getCntrTpszCd();
						
						List<String> tpszCdList = new ArrayList<String>();
						StringTokenizer st = new StringTokenizer(sTpsz, ",");							
					
				        while (st.hasMoreTokens()) {
				        	tpszCdList.add(st.nextToken());
				        }
						velParam.put("vel_tpsz_cd", tpszCdList);

						param.putAll(mapVO);
						velParam.putAll(mapVO);										        
					}

					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AssetsAuditMgtDBDAOSearchAssetsDetailLeaseListRSQL(), param, velParam);
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, AssetsDetailVO.class);
					
				}catch(SQLException se){
					throw new DAOException(new ErrorHandler(se).getMessage());
				}catch(Exception ex){
					throw new DAOException(new ErrorHandler(ex).getMessage());
				}
				return list;
		 }
		 
    /**
     * EES_MST_0045 : retreive
     * Container Average using Day by TP/SZ을 검색조건에 따라 조회합니다.<br>
	 * @author LEE HO SUN
	 * @category EES_MST_0032_3
	 * @category modifyAssetsAuditData      
     * @param  EqAverageUsingDayVO eqAverageUsingDayVO
     * @return List<EqAverageUsingDayVO>
     * @throws DAOException
     */
	@SuppressWarnings("unchecked")
	 public List<EqAverageUsingDayVO> searchEqAverageUsingDayData(EqAverageUsingDayVO eqAverageUsingDayVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<EqAverageUsingDayVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(eqAverageUsingDayVO != null){
					
					StringTokenizer  st = new StringTokenizer(eqAverageUsingDayVO.getHeadCntrTpszCd(),"|");
					if ( st.hasMoreTokens() ) eqAverageUsingDayVO.setCntrTpszCd1  (st.nextToken());
					if ( st.hasMoreTokens() ) eqAverageUsingDayVO.setCntrTpszCd2  (st.nextToken());
					if ( st.hasMoreTokens() ) eqAverageUsingDayVO.setCntrTpszCd3  (st.nextToken());
					if ( st.hasMoreTokens() ) eqAverageUsingDayVO.setCntrTpszCd4  (st.nextToken());
					if ( st.hasMoreTokens() ) eqAverageUsingDayVO.setCntrTpszCd5  (st.nextToken());
					if ( st.hasMoreTokens() ) eqAverageUsingDayVO.setCntrTpszCd6  (st.nextToken());
					if ( st.hasMoreTokens() ) eqAverageUsingDayVO.setCntrTpszCd7  (st.nextToken());
					if ( st.hasMoreTokens() ) eqAverageUsingDayVO.setCntrTpszCd8  (st.nextToken());
					if ( st.hasMoreTokens() ) eqAverageUsingDayVO.setCntrTpszCd9  (st.nextToken());
					if ( st.hasMoreTokens() ) eqAverageUsingDayVO.setCntrTpszCd10 (st.nextToken());
					if ( st.hasMoreTokens() ) eqAverageUsingDayVO.setCntrTpszCd11 (st.nextToken());
					if ( st.hasMoreTokens() ) eqAverageUsingDayVO.setCntrTpszCd12 (st.nextToken());
					if ( st.hasMoreTokens() ) eqAverageUsingDayVO.setCntrTpszCd13 (st.nextToken());
					if ( st.hasMoreTokens() ) eqAverageUsingDayVO.setCntrTpszCd14 (st.nextToken());
					if ( st.hasMoreTokens() ) eqAverageUsingDayVO.setCntrTpszCd15 (st.nextToken());
					if ( st.hasMoreTokens() ) eqAverageUsingDayVO.setCntrTpszCd16 (st.nextToken());
					if ( st.hasMoreTokens() ) eqAverageUsingDayVO.setCntrTpszCd17 (st.nextToken());
					if ( st.hasMoreTokens() ) eqAverageUsingDayVO.setCntrTpszCd18 (st.nextToken());
					if ( st.hasMoreTokens() ) eqAverageUsingDayVO.setCntrTpszCd19 (st.nextToken());
					if ( st.hasMoreTokens() ) eqAverageUsingDayVO.setCntrTpszCd20 (st.nextToken());
					if ( st.hasMoreTokens() ) eqAverageUsingDayVO.setCntrTpszCd21 (st.nextToken());
					if ( st.hasMoreTokens() ) eqAverageUsingDayVO.setCntrTpszCd22 (st.nextToken());
					if ( st.hasMoreTokens() ) eqAverageUsingDayVO.setCntrTpszCd23 (st.nextToken());
					if ( st.hasMoreTokens() ) eqAverageUsingDayVO.setCntrTpszCd24 (st.nextToken());
					if ( st.hasMoreTokens() ) eqAverageUsingDayVO.setCntrTpszCd25 (st.nextToken());
					if ( st.hasMoreTokens() ) eqAverageUsingDayVO.setCntrTpszCd26 (st.nextToken());
					if ( st.hasMoreTokens() ) eqAverageUsingDayVO.setCntrTpszCd27 (st.nextToken());
					if ( st.hasMoreTokens() ) eqAverageUsingDayVO.setCntrTpszCd28 (st.nextToken());
					if ( st.hasMoreTokens() ) eqAverageUsingDayVO.setCntrTpszCd29 (st.nextToken());
					if ( st.hasMoreTokens() ) eqAverageUsingDayVO.setCntrTpszCd30 (st.nextToken());
					eqAverageUsingDayVO.setHeadCntrTpszCd(eqAverageUsingDayVO.getHeadCntrTpszCd().replace("|", ","));					
					
					Map<String, String> mapVO = eqAverageUsingDayVO .getColumnValues();
					
					String lstmcd = eqAverageUsingDayVO.getLstmCd();
                    if (!lstmcd.equals("ALL")){
						List<String> cdList = new ArrayList<String>();
						StringTokenizer lst = new StringTokenizer(lstmcd, ",");
						     
				        while (lst.hasMoreTokens()) {
				        	cdList.add(lst.nextToken());
				        }
				        
						velParam.put("vel_lstm_cd", cdList);
                    } else {
                    	velParam.put("vel_lstm_cd", "");
                    }
                    
                    String lvndr_abbr_nm = eqAverageUsingDayVO.getVndrAbbrNm();
                    if (!lvndr_abbr_nm.equals("ALL")){
						List<String> cdList = new ArrayList<String>();
						StringTokenizer lst = new StringTokenizer(lvndr_abbr_nm, ",");
						     
				        while (lst.hasMoreTokens()) {
				        	cdList.add(lst.nextToken());
				        }
				        
						velParam.put("vel_vndr_abbr_nm", cdList);
                    } else {
                    	velParam.put("vel_vndr_abbr_nm", "");
                    }
                    
                    String lcntr_tpsz_cd = eqAverageUsingDayVO.getCntrTpszCd();
                    if (!lcntr_tpsz_cd.equals("ALL")){
						List<String> cdList = new ArrayList<String>();
						StringTokenizer lst = new StringTokenizer(lcntr_tpsz_cd, ",");
						     
				        while (lst.hasMoreTokens()) {
				        	cdList.add(lst.nextToken());
				        }
				        
						velParam.put("vel_cntr_tpsz_cd", cdList);
                    } else {
                    	velParam.put("vel_cntr_tpsz_cd", "");
                    }
					
                    String lman_year = eqAverageUsingDayVO.getManYear();
                    if (!lman_year.equals("ALL")){
						List<String> cdList = new ArrayList<String>();
						StringTokenizer lst = new StringTokenizer(lman_year, ",");
						     
				        while (lst.hasMoreTokens()) {
				        	cdList.add(lst.nextToken());
				        }
				        
						velParam.put("vel_man_year", cdList);
                    } else {
                    	velParam.put("vel_man_year", "");
                    }					
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AssetsAuditMgtDBDAOSearchEqAverageUsingDayDataRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, EqAverageUsingDayVO .class);
				
			}catch(SQLException se){
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
	 }	
	
	/**
	 * 연도별 신조장비 제작 Serial Range를 Kind of Eq별로 조회한다.<br>
	 * 
	 * @author NKJH
	 * @category EES_MST_0048
	 * @category searchEqManufacturePlanListData 
	 * 
	 * @param EqMftPlanOptionVO eqMftPlanOptionVO
	 * @return List<EqMftPlanListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<EqMftPlanListVO> searchEqManufacturePlanListData(EqMftPlanOptionVO eqMftPlanOptionVO) throws DAOException {			 						 
			DBRowSet dbRowset = null;
			List<EqMftPlanListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(eqMftPlanOptionVO != null){
					Map<String, String> mapVO = eqMftPlanOptionVO.getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AssetsAuditMgtDBDAOSearchEqManufacturePlanListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, EqMftPlanListVO.class);
				
			}catch(SQLException se){
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
	 }
	 
	 /**
		 * 신조장비 제작 Serial Range의 Validation을 체크한다.<br>	 
		 * @author NKJH
		 * @category EES_MST_0048
		 * @category searchEqMftPlnInfoData     
		 * @param EqMftPlanListVO eqMftPlanListVO
		 * @return List<EqMftPlanListVO>
		 * @throws DAOException, Exception
		 */
		@SuppressWarnings("unchecked")
		public List<EqMftPlanListVO> searchEqMftPlnInfoData(EqMftPlanListVO eqMftPlanListVO) throws DAOException,Exception {
			DBRowSet dbRowset = null;
			List<EqMftPlanListVO> list = null;
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			try{
				if(eqMftPlanListVO != null){
					
					list = new ArrayList<EqMftPlanListVO>();
					Map<String, String> mapVO = eqMftPlanListVO.getColumnValues();					
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AssetsAuditMgtDBDAOValidationEqManufacturePlanRSQL(), param, velParam);
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, EqMftPlanListVO .class);
				}	
			}catch(SQLException se){
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}
	 
	 /**
	 * 연도별 신조장비 제작 Serial Range Data를 생성한다.<br> 
	 * 
	 * @author NKJH
	 * @category EES_MST_0048
	 * @category addMstEqMftPlnListData
	 * 
	 * @param List<EqMftPlanListVO> eqMftPlanListVOs
	 * @throws DAOException
	*/
	public void addMstEqMftPlnListData(List<EqMftPlanListVO> eqMftPlanListVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insertCnt[] = null;
			if(eqMftPlanListVOs.size() > 0){								
				insertCnt = sqlExe.executeBatch((ISQLTemplate)new AssetsAuditMgtDBDAOAddMstEqMftPlnListCSQL(), eqMftPlanListVOs, null);
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
	 * 연도별 신조장비 제작 Serial Range Data를 수정한다.<br> 
	 * 
	 * @author NKJH
	 * @category EES_MST_0048
	 * @category modifyMstEqMftPlnListData
	 * 
	 * @param List<EqMftPlanListVO> eqMftPlanListVOs
	 * @throws DAOException
	*/
	public void modifyMstEqMftPlnListData(List<EqMftPlanListVO> eqMftPlanListVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updateCnt[] = null;
			if(eqMftPlanListVOs.size() > 0){								
				updateCnt = sqlExe.executeBatch((ISQLTemplate)new AssetsAuditMgtDBDAOModifyMstEqMftPlnListUSQL(), eqMftPlanListVOs, null);
				for(int i = 0; i < updateCnt.length; i++){
					if(updateCnt[i]== Statement.EXECUTE_FAILED)
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
	 * 연도별 신조장비 제작 Serial Range를 Data를 삭제한다.<br> 
	 * 
	 * @author NKJH
	 * @category EES_MST_0048
	 * @category removeMstEqMftPlnListData
	 * 
	 * @param List<EqMftPlanListVO> eqMftPlanListVOs
	 * @throws DAOException
	*/
	public void removeMstEqMftPlnListData(List<EqMftPlanListVO> eqMftPlanListVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int deleteCnt[] = null;
			if(eqMftPlanListVOs.size() > 0){								
				deleteCnt = sqlExe.executeBatch((ISQLTemplate)new AssetsAuditMgtDBDAORemoveMstEqMftPlnListDSQL(), eqMftPlanListVOs, null);
				for(int i = 0; i < deleteCnt.length; i++){
					if(deleteCnt[i]== Statement.EXECUTE_FAILED)
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
     * EES_MST_0032 : retrieve 
     * Output Alive EQ Master Data for Owned Equipment을 검색조건에 따라 디테일을 조회합니다.<br>
	 * @author La Sang bo
	 * @category EES_MST_0032
	 * @category searchAssetsAuditResultListData     
     * @param  EqAsetAudVO eqAsetAudVO
     * @return List<AssetsAuditDetailVO>
     * @throws EventException
     */
	 @SuppressWarnings("unchecked")
	 public List<EqAsetDpcAmtVO> searchAssetsDepreciatedAmtListData(EqAsetAudVO eqAsetAudVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<EqAsetDpcAmtVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(eqAsetAudVO != null){
					Map<String, String> mapVO = eqAsetAudVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AssetsAuditMgtDBDAOSearchAssetsDepreciatedAmtListDataRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, EqAsetDpcAmtVO .class);
				
			}catch(SQLException se){
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
	 }
}	 
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PerformanceReportDBDAO.java
*@FileTitle : Disposal PFMC by Region
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.28
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.09.28 민정호
* 1.0 Creation
* =======================================================
* 2010.11.30 남궁진호 [CHM-201007327-01] Disposal Performance를 장비별 Detail 내역 조회 추가
*            searchDisposalPFMCByEqDetailListData
* 2010.12.06 남궁진호 [CHM-201007441-01]Disposal Result Equipment list 팝업 신규개발 
=========================================================*/
package com.clt.apps.opus.ees.mnr.reportmanage.performancereport.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.basic.PerformanceReportBCImpl;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.ACEPListGRPVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.ACEPListINVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.ACEPListVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.DisposalPFMCByBuyerVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.DisposalPFMCByEqDetailVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.DisposalPFMCByMonthVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.DisposalPFMCByRCCVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.PMFCByAgreementTariffGRPVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.PMFCByAgreementTariffINVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.PMFCByAgreementTariffListVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByACCTINVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByACCTVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByESTINVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByESTVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByRepairCodeINVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByRepairCodeVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.RepairPFMCBySPINVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.RepairPFMCBySPVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByTSINVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByTSVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByWOINVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByWOVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.TirePurcharseByItemINVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.TirePurcharseByItemVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.TirePurcharseBySupplierINVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.TirePurcharseBySupplierVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.TireReplacementHistoryVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.TireReplacementINVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.TotalLossPerformanceINVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.TotalLossPerformanceVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
	
/**
 * COM PerformanceReportDBDAO <br>
 * - COM-ReportManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Jung Ho Min
 * @see PerformanceReportBCImpl 참조
 * @since J2EE 1.6
 */
public class PerformanceReportDBDAO extends DBDAOSupport {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	 /**
	  * [EES_MNR_0166] 장비별 매각실적 상세정보를 조회합니다. <br>
	  *
	  * @param DisposalPFMCByEqDetailVO disposalPFMCByEqDetailVO
	  * @return List<DisposalPFMCByEqDetailVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<DisposalPFMCByEqDetailVO> searchDisposalPFMCByEqDetailListData(DisposalPFMCByEqDetailVO disposalPFMCByEqDetailVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<DisposalPFMCByEqDetailVO> resultVOs = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 List<String> arrLabelValueList = null;
		 
		 try{
			 if(disposalPFMCByEqDetailVO != null){
				 Map<String, String> mapVO = disposalPFMCByEqDetailVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
				 
				if (!JSPUtil.getNull(disposalPFMCByEqDetailVO.getRstrUsgLbl()).equals("")) {
					arrLabelValueList = JSPUtil.convertStringToArrayList(JSPUtil.replace(disposalPFMCByEqDetailVO.getRstrUsgLbl(), ",", "|"));
					param.put("labelvalue_list", arrLabelValueList);
					velParam.put("labelvalue_list", arrLabelValueList);
				}
				 
			 }
			 	
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOsearchDisposalPFMCByEqDetailListRSQL(), param, velParam);
			 resultVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, DisposalPFMCByEqDetailVO.class);
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }

		 return resultVOs;
	 }
	 
	/**
	 * Tire Replacement Report 를 조회합니다.<br>
	 *
	 * @param TireReplacementINVO tireReplacementINVO
	 * @param SignOnUserAccount account
	 * @return List<TireReplacementHistoryVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TireReplacementHistoryVO> searchTireReplacementListData(TireReplacementINVO tireReplacementINVO, SignOnUserAccount account) throws DAOException {

		DBRowSet dbRowset = null;
		List<TireReplacementHistoryVO> tireReplacementHistoryVOs = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//파라미터 맵핑시에 모델 설계 문서 질문

			if(tireReplacementINVO != null){
				Map<String, String> mapVO = tireReplacementINVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("user_ofc_cd", account.getOfc_cd());
				velParam.put("user_ofc_cd", account.getOfc_cd());
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchTireReplacementListDataRSQL(), param, velParam);
			tireReplacementHistoryVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, TireReplacementHistoryVO .class);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return tireReplacementHistoryVOs;
	}

	/**
	 * Tire Replacement History Report 를 조회합니다.<br>
	 *
	 * @param TireReplacementINVO tireReplacementINVO
	 * @param SignOnUserAccount account
	 * @return List<TireReplacementHistoryVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TireReplacementHistoryVO> searchTireReplacementHistoryListData(TireReplacementINVO tireReplacementINVO, SignOnUserAccount account) throws DAOException {

		DBRowSet dbRowset = null;
		List<TireReplacementHistoryVO> tireReplacementHistoryVOs = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//파라미터 맵핑시에 모델 설계 문서 질문

			if(tireReplacementINVO != null){
				Map<String, String> mapVO = tireReplacementINVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("user_ofc_cd", account.getOfc_cd());
				velParam.put("user_ofc_cd", account.getOfc_cd());
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchTireReplacementHistoryListDataRSQL(), param, velParam);
			tireReplacementHistoryVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, TireReplacementHistoryVO .class);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return tireReplacementHistoryVOs;
	}

	/**
	 * Item에 의한 Tire Purchase Report를 조회합니다.<br>
	 *
	 * @param TirePurcharseByItemINVO tirePurcharseByItemINVO
	 * @param SignOnUserAccount account
	 * @return List<TirePurcharseByItemVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TirePurcharseByItemVO> searchTirePurchaseByItemListData(TirePurcharseByItemINVO tirePurcharseByItemINVO, SignOnUserAccount account) throws DAOException {

		DBRowSet dbRowset = null;
		List<TirePurcharseByItemVO> tirePurcharseByItemVOs = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//파라미터 맵핑시에 모델 설계 문서 질문

			if(tirePurcharseByItemINVO != null){
				Map<String, String> mapVO = tirePurcharseByItemINVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("user_ofc_cd", account.getOfc_cd());
				velParam.put("user_ofc_cd", account.getOfc_cd());

			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchTirePurchaseByItemListDataRSQL(), param, velParam);
			tirePurcharseByItemVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, TirePurcharseByItemVO .class);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return tirePurcharseByItemVOs;
	}

	/**
	 * Tire Purchase Report by Supplier를 조회합니다.<br>
	 *
	 * @param TirePurcharseBySupplierINVO tirePurcharseBySupplierINVO
	 * @param SignOnUserAccount account
	 * @return List<TirePurcharseBySupplierVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TirePurcharseBySupplierVO> searchTirePurchaseBySupplierListData(TirePurcharseBySupplierINVO tirePurcharseBySupplierINVO, SignOnUserAccount account) throws DAOException {

		DBRowSet dbRowset = null;
		List<TirePurcharseBySupplierVO> tirePurcharseBySupplierVOs = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//파라미터 맵핑시에 모델 설계 문서 질문

			if(tirePurcharseBySupplierINVO != null){
				Map<String, String> mapVO = tirePurcharseBySupplierINVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("user_ofc_cd", account.getOfc_cd());
				velParam.put("user_ofc_cd", account.getOfc_cd());
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchTirePurchaseBySupplierListDataRSQL(), param, velParam);
			tirePurcharseBySupplierVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, TirePurcharseBySupplierVO .class);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return tirePurcharseBySupplierVOs;
	}

	/**
	 * Total Loss Payment to Lessor Report를 조회합니다.<br>
	 *
	 * @param TotalLossPerformanceINVO totalLossPerformanceINVO
	 * @param SignOnUserAccount account
	 * @return List<TotalLossPerformanceVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TotalLossPerformanceVO> searchTotalLossPerformanceListData(TotalLossPerformanceINVO totalLossPerformanceINVO, SignOnUserAccount account) throws DAOException {

		DBRowSet dbRowset = null;
		List<TotalLossPerformanceVO> totalLossPerformanceVOs = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<String> arrLabelValueList = null;
		
		try{
			//파라미터 맵핑시에 모델 설계 문서 질문

			if(totalLossPerformanceINVO != null){
				Map<String, String> mapVO = totalLossPerformanceINVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("user_ofc_cd", account.getOfc_cd());
				velParam.put("user_ofc_cd", account.getOfc_cd());

				//rep_Multiful_inquiry eq_no
				List<String> eqNos = new ArrayList<String>();
				String[] arrEqNo =  totalLossPerformanceINVO.getEqNo().split(",");
				for(int i = 0; i < arrEqNo.length; i ++){
					eqNos.add(arrEqNo[i]);
				}
				velParam.put("eqNos", eqNos);

				//rep_Multiful_inquiry total_loss_no
				List<String> totalLossNos = new ArrayList<String>();
				String[] arrTotalLossNo =  totalLossPerformanceINVO.getTotalLossNo().split(",");
				for(int i = 0; i < arrTotalLossNo.length; i ++){
					totalLossNos.add(arrTotalLossNo[i]);
				}
				velParam.put("totalLossNos", totalLossNos);
				
				if ( !JSPUtil.getNull(totalLossPerformanceINVO.getRstrUsgLbl()).equals("") ) {
					arrLabelValueList = JSPUtil.convertStringToArrayList(JSPUtil.replace(totalLossPerformanceINVO.getRstrUsgLbl(),",","|"));
		        	param.put("labelvalue_list", arrLabelValueList);
		        	velParam.put("labelvalue_list", arrLabelValueList);        	
		        } 
				
				
				if("ALL".equals(totalLossPerformanceINVO.getRuLableType())) {
					param.put("ru_lable_type", "");
					velParam.put("ru_lable_type", "");
				}
				
				
				if("ALL".equals(totalLossPerformanceINVO.getRstrUsgLbl())) {
					param.put("rstr_usg_lbl", "");
					velParam.put("rstr_usg_lbl", "");
				}				
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchTotalLossPerformanceListDataRSQL(), param, velParam);
			totalLossPerformanceVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, TotalLossPerformanceVO .class);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return totalLossPerformanceVOs;
	}

	/**
	 * (By Serive Provider)Estimation Creation에 의한 MNR PFMC를 조회합니다.<br>
	 *
	 * @param RepairPFMCByESTINVO repairPFMCByESTINVO
	 * @return List<RepairPFMCByESTVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RepairPFMCByESTVO> searchRepairPFMCByESTListSPData(RepairPFMCByESTINVO repairPFMCByESTINVO) throws DAOException {

		DBRowSet dbRowset = null;
		List<RepairPFMCByESTVO> repairPFMCByESTVOs = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//파라미터 맵핑시에 모델 설계 문서 질문

			if(repairPFMCByESTINVO != null){
				Map<String, String> mapVO = repairPFMCByESTINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				//멀티 콤보로 넘어온 값 tpsz
				List<String> tpszCds = new ArrayList<String>();
				String[] arrYdCd =  repairPFMCByESTINVO.getTpSzCd().split(",");
				for(int i = 0; i < arrYdCd.length; i ++){
					tpszCds.add(arrYdCd[i]);
				}
				velParam.put("tpszCds", tpszCds);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchRepairPFMCByESTListDataSPRSQL(), param, velParam);
			repairPFMCByESTVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, RepairPFMCByESTVO .class);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return repairPFMCByESTVOs;
	}

	/**
	 * (By Cedex Code)Estimation Creation에 의한 MNR PFMC를 조회합니다.<br>
	 *
	 * @param RepairPFMCByESTINVO repairPFMCByESTINVO
	 * @return List<RepairPFMCByESTVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RepairPFMCByESTVO> searchRepairPFMCByESTListCCData(RepairPFMCByESTINVO repairPFMCByESTINVO) throws DAOException {

		DBRowSet dbRowset = null;
		List<RepairPFMCByESTVO> repairPFMCByESTVOs = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//파라미터 맵핑시에 모델 설계 문서 질문

			if(repairPFMCByESTINVO != null){
				Map<String, String> mapVO = repairPFMCByESTINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				//멀티 콤보로 넘어온 값 tpsz
				List<String> tpszCds = new ArrayList<String>();
				String[] arrYdCd =  repairPFMCByESTINVO.getTpSzCd().split(",");
				for(int i = 0; i < arrYdCd.length; i ++){
					tpszCds.add(arrYdCd[i]);
				}
				velParam.put("tpszCds", tpszCds);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchRepairPFMCByESTListDataCCRSQL(), param, velParam);
			repairPFMCByESTVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, RepairPFMCByESTVO .class);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return repairPFMCByESTVOs;
	}


	/**
	 * Work Order에 의한 MNR PFMC를 조회합니다.<br>
	 *
	 * @param RepairPFMCByWOINVO repairPFMCByWOINVO
	 * @return List<RepairPFMCByWOVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RepairPFMCByWOVO> searchRepairPFMCByWOListData(RepairPFMCByWOINVO repairPFMCByWOINVO) throws DAOException {

		DBRowSet dbRowset = null;
		List<RepairPFMCByWOVO> repairPFMCByWOVOs = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//파라미터 맵핑시에 모델 설계 문서 질문

			if(repairPFMCByWOINVO != null){
				Map<String, String> mapVO = repairPFMCByWOINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				//멀티 콤보로 넘어온 값 tpsz
				List<String> tpszCds = new ArrayList<String>();
				String[] arrTpszCd =  repairPFMCByWOINVO.getTpSzCd().split(",");
				for(int i = 0; i < arrTpszCd.length; i ++){
					tpszCds.add(arrTpszCd[i]);
				}
				velParam.put("tpszCds", tpszCds);

				//멀티 콤보로 넘어온 값 tpsz
				List<String> wotpCds = new ArrayList<String>();
				String[] arrWotpCd =  repairPFMCByWOINVO.getMnrWoTpCd().split(",");
				for(int i = 0; i < arrWotpCd.length; i ++){
					wotpCds.add(arrWotpCd[i]);
				}
				velParam.put("wotpCds", wotpCds);

				//멀티 콤보로 넘어온 값 ofc_cd
				List<String> ofcCds = new ArrayList<String>();
				String[] arrOfcCds =  repairPFMCByWOINVO.getOfcCd().split(",");
				for(int i = 0; i < arrOfcCds.length; i ++){
					ofcCds.add(arrOfcCds[i]);
				}
				velParam.put("ofcCds", ofcCds);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchRepairPFMCByWOListDataRSQL(), param, velParam);
			repairPFMCByWOVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, RepairPFMCByWOVO .class);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return repairPFMCByWOVOs;
	}

	/**
	 * AGMT TRIFF에 의한 MNR PFMC를 조회합니다.<br>
	 *
	 * @param RepairPFMCByRepairCodeINVO repairPFMCByRepairCodeINVO
	 * @return List<RepairPFMCByRepairCodeVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RepairPFMCByRepairCodeVO> searchRepairPFMCByRepairCodeListData(RepairPFMCByRepairCodeINVO repairPFMCByRepairCodeINVO) throws DAOException {

		DBRowSet dbRowset = null;
		List<RepairPFMCByRepairCodeVO> repairPFMCByRepairCodeVOs = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			Map<String, String> mapVO = repairPFMCByRepairCodeINVO .getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);


			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchRepairPFMCByRepairCodeListDataRSQL(), param, velParam);
			repairPFMCByRepairCodeVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, RepairPFMCByRepairCodeVO .class);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return repairPFMCByRepairCodeVOs;
	}

	/**
	 * (By Service Provider)Type/Size에 의한 MNR PFMC을 조회 합니다.<br>
	 *
	 * @param RepairPFMCByTSINVO repairPFMCByTSINVO
	 * @return List<RepairPFMCByTSVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RepairPFMCByTSVO> searchRepairPFMCByTSListSPData(RepairPFMCByTSINVO repairPFMCByTSINVO) throws DAOException {

		DBRowSet dbRowset = null;
		List<RepairPFMCByTSVO> repairPFMCByTSVOs = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//파라미터 맵핑시에 모델 설계 문서 질문
			if(repairPFMCByTSINVO != null){
				Map<String, String> mapVO = repairPFMCByTSINVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				//멀티 콤보로 넘어온 값 tpsz
				List<String> tpszCds = new ArrayList<String>();
				String[] arrTpszCd =  repairPFMCByTSINVO.getTpSzCd().split(",");
				for(int i = 0; i < arrTpszCd.length; i ++){
					tpszCds.add(arrTpszCd[i]);
				}
				velParam.put("tpszCds", tpszCds);

				//멀티 콤보로 넘어온 값 lstm_cd
				List<String> lstmCds = new ArrayList<String>();
				String[] arrLstmCd =  repairPFMCByTSINVO.getLstmCd().split(",");
				for(int i = 0; i < arrLstmCd.length; i ++){
					lstmCds.add(arrLstmCd[i]);
				}
				velParam.put("lstmCds", lstmCds);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchRepairPFMCByTSListSPDataRSQL(), param, velParam);
			repairPFMCByTSVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, RepairPFMCByTSVO .class);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return repairPFMCByTSVOs;
	}

	/**
	 * (By Office)Type/Size에 의한 MNR PFMC을 조회 합니다.<br>
	 *
	 * @param RepairPFMCByTSINVO repairPFMCByTSINVO
	 * @return List<RepairPFMCByTSVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RepairPFMCByTSVO> searchRepairPFMCByTSListOFData(RepairPFMCByTSINVO repairPFMCByTSINVO) throws DAOException {

		DBRowSet dbRowset = null;
		List<RepairPFMCByTSVO> repairPFMCByTSVOs = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//파라미터 맵핑시에 모델 설계 문서 질문

			if(repairPFMCByTSINVO != null){
				Map<String, String> mapVO = repairPFMCByTSINVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				//멀티 콤보로 넘어온 값 tpsz
				List<String> tpszCds = new ArrayList<String>();
				String[] arrYdCd =  repairPFMCByTSINVO.getTpSzCd().split(",");
				for(int i = 0; i < arrYdCd.length; i ++){
					tpszCds.add(arrYdCd[i]);
				}
				velParam.put("tpszCds", tpszCds);

				//멀티 콤보로 넘어온 값 lstm_cd
				List<String> lstmCds = new ArrayList<String>();
				String[] arrLstmCd =  repairPFMCByTSINVO.getLstmCd().split(",");
				for(int i = 0; i < arrLstmCd.length; i ++){
					lstmCds.add(arrLstmCd[i]);
				}
				velParam.put("lstmCds", lstmCds);
			}



			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchRepairPFMCByTSListOFDataRSQL(), param, velParam);
			repairPFMCByTSVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, RepairPFMCByTSVO .class);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return repairPFMCByTSVOs;
	}

	/**
	 * (By Manufacturer)VNDR/Manufacturer에 의한 MNR PFMC을 조회 합니다.<br>
	 *
	 * @param RepairPFMCBySPINVO repairPFMCBySPINVO
	 * @return List<RepairPFMCBySPVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RepairPFMCBySPVO> searchRepairPFMCBySPListMFData(RepairPFMCBySPINVO repairPFMCBySPINVO) throws DAOException {

		DBRowSet dbRowset = null;
		List<RepairPFMCBySPVO> repairPFMCBySPVOs = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//파라미터 맵핑시에 모델 설계 문서 질문

			if(repairPFMCBySPINVO != null){
				Map<String, String> mapVO = repairPFMCBySPINVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				//멀티 콤보로 넘어온 값 tpsz
				List<String> tpszCds = new ArrayList<String>();
				String[] arrYdCd =  repairPFMCBySPINVO.getTpSzCd().split(",");
				for(int i = 0; i < arrYdCd.length; i ++){
					tpszCds.add(arrYdCd[i]);
				}
				velParam.put("tpszCds", tpszCds);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchRepairPFMCBySPListMFDataRSQL(), param, velParam);
			repairPFMCBySPVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, RepairPFMCBySPVO .class);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return repairPFMCBySPVOs;
	}

	/**
	 * (By Service Provider)VNDR/Manufacturer에 의한 MNR PFMC을 조회 합니다.<br>
	 *
	 * @param RepairPFMCBySPINVO repairPFMCBySPINVO
	 * @return List<RepairPFMCBySPVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RepairPFMCBySPVO> searchRepairPFMCBySPListSPData(RepairPFMCBySPINVO repairPFMCBySPINVO) throws DAOException {

		DBRowSet dbRowset = null;
		List<RepairPFMCBySPVO> repairPFMCBySPVOs = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//파라미터 맵핑시에 모델 설계 문서 질문

			if(repairPFMCBySPINVO != null){
				Map<String, String> mapVO = repairPFMCBySPINVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				//멀티 콤보로 넘어온 값 tpsz
				List<String> tpszCds = new ArrayList<String>();
				String[] arrYdCd =  repairPFMCBySPINVO.getTpSzCd().split(",");
				for(int i = 0; i < arrYdCd.length; i ++){
					tpszCds.add(arrYdCd[i]);
				}
				velParam.put("tpszCds", tpszCds);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOSearchRepairPFMCBySPListSPDataRSQL(), param, velParam);
			repairPFMCBySPVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, RepairPFMCBySPVO .class);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return repairPFMCBySPVOs;
	}

	/**
	 * [EES_MNR_0230]ACEP Candidate Cntr List를 조회 합니다. <br>
	 *
	 * @param ACEPListGRPVO aCEPListGRPVO
	 * @return List<ACEPListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<ACEPListVO> searchACEPListData(ACEPListGRPVO aCEPListGRPVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ACEPListVO> aCEPListVOs = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			ACEPListINVO aCEPListINVO = aCEPListGRPVO.getACEPListINVO();
			Map<String, String> mapVO = aCEPListINVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOsearchACEPListDataRSQL(), param, velParam);
			aCEPListVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, ACEPListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return aCEPListVOs;
	}

	 /**
	  * [EES_MNR_0236]MNR PFMC by Agreement/Tariff List를 조회 합니다. <br>
	  *
	  * @param PMFCByAgreementTariffGRPVO pMFCByAgreementTariffGRPVO
	  * @return List<PMFCByAgreementTariffListVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<PMFCByAgreementTariffListVO> searchPMFCByAgreementTariffData(PMFCByAgreementTariffGRPVO pMFCByAgreementTariffGRPVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<PMFCByAgreementTariffListVO> pMFCByAgreementTariffListVOs = null;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 PMFCByAgreementTariffINVO pMFCByAgreementTariffINVO = pMFCByAgreementTariffGRPVO.getPMFCByAgreementTariffINVO();
			 Map<String, String> mapVO = pMFCByAgreementTariffINVO.getColumnValues();

			 param.putAll(mapVO);
			 velParam.putAll(mapVO);

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOsearchPMFCByAgreementTariffDataRSQL(), param, velParam);
			 pMFCByAgreementTariffListVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, PMFCByAgreementTariffListVO .class);
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return pMFCByAgreementTariffListVOs;
	 }

	 /**
	 * (By Manufacturer)VNDR/Manufacturer에 의한 MNR PFMC을 조회 합니다.<br>
	 *
	 * @param RepairPFMCByACCTINVO repairPFMCByACCTINVO
	 * @return List<RepairPFMCByACCTVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RepairPFMCByACCTVO> searchRepairPFMCByACCTListData(RepairPFMCByACCTINVO repairPFMCByACCTINVO) throws DAOException {

		DBRowSet dbRowset = null;
		List<RepairPFMCByACCTVO> repairPFMCByACCTVOS = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//파라미터 맵핑시에 모델 설계 문서 질문

			if(repairPFMCByACCTINVO != null){
				Map<String, String> mapVO = repairPFMCByACCTINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				//멀티 콤보로 넘어온 값 tpsz
				List<String> tpszCds = new ArrayList<String>();
				String[] arrTpszCds =  repairPFMCByACCTINVO.getTpSzCd().split(",");
				for(int i = 0; i < arrTpszCds.length; i ++){
					tpszCds.add(arrTpszCds[i]);
				}
				velParam.put("tpszCds", tpszCds);
				//멀티 콤보로 넘어온 값 Account Code
				List<String> acctCds = new ArrayList<String>();
				String[] arrAcctCds =  repairPFMCByACCTINVO.getAcctCd().split(",");
				for(int i = 0; i < arrAcctCds.length; i ++){
					acctCds.add(arrAcctCds[i]);
				}
				velParam.put("acctCds", acctCds);

				//멀티 콤보로 넘어온 값 ofc_cd
				List<String> ofcCds = new ArrayList<String>();
				String[] arrOfcCds =  repairPFMCByACCTINVO.getOfcCd().split(",");
				for(int i = 0; i < arrOfcCds.length; i ++){
					ofcCds.add(arrOfcCds[i]);
				}
				velParam.put("ofcCds", ofcCds);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOsearchRepairPFMCByACCTListDataRSQL(), param, velParam);
			repairPFMCByACCTVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, RepairPFMCByACCTVO .class);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return repairPFMCByACCTVOS;
	}

	/**
	  * [EES_MNR_0244] RCC/LCC/SCC 지역별 매각실적 현황목록을 조회합니다. <br>
	  *
	  * @param DisposalPFMCByRCCVO disposalPFMCByRCCVO
	  * @return List<DisposalPFMCByRCCVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<DisposalPFMCByRCCVO> searchDisposalPFMCByRCCListData(DisposalPFMCByRCCVO disposalPFMCByRCCVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<DisposalPFMCByRCCVO> resultVOs = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 if(disposalPFMCByRCCVO != null){
				 Map<String, String> mapVO = disposalPFMCByRCCVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOsearchDisposalPFMCByRCCListRSQL(), param, velParam);
			 resultVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, DisposalPFMCByRCCVO .class);
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }

		 return resultVOs;
	 }

	 /**
	  * [EES_MNR_0245] 월별 매각실적 현황목록을 조회합니다. <br>
	  *
	  * @param DisposalPFMCByMonthVO disposalPFMCByMonthVO
	  * @return List<DisposalPFMCByMonthVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<DisposalPFMCByMonthVO> searchDisposalPFMCByMonthListData(DisposalPFMCByMonthVO disposalPFMCByMonthVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<DisposalPFMCByMonthVO> resultVOs = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 if(disposalPFMCByMonthVO != null){
				 Map<String, String> mapVO = disposalPFMCByMonthVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOsearchDisposalPFMCByMonthListRSQL(), param, velParam);
			 resultVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, DisposalPFMCByMonthVO .class);
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }

		 return resultVOs;
	 }
	 
	 /**
	  * [EES_MNR_0246] Buyer별 매각실적 현황목록을 조회합니다. <br>
	  *
	  * @param DisposalPFMCByBuyerVO disposalPFMCByBuyerVO
	  * @return List<DisposalPFMCByBuyerVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<DisposalPFMCByBuyerVO> searchDisposalPFMCByBuyerListData(DisposalPFMCByBuyerVO disposalPFMCByBuyerVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<DisposalPFMCByBuyerVO> resultVOs = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 if(disposalPFMCByBuyerVO != null){
				 Map<String, String> mapVO = disposalPFMCByBuyerVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceReportDBDAOsearchDisposalPFMCByBuyerListRSQL(), param, velParam);
			 resultVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, DisposalPFMCByBuyerVO .class);
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }

		 return resultVOs;
	 }
}
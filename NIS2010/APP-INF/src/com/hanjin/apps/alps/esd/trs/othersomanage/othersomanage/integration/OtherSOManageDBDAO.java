/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OtherSOManageDBDAO.java
*@FileTitle : Other SO 생성화면
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.19
*@LastModifier : 유선오
*@LastVersion : 1.3
* 2009.10.01 kimjin
* 1.0 최초 생성
* ----------------------------------------------------------
*  History
* 2010.11.22 이재위   1.1 [CHM-201005356-01] [TRS] RD CNTR 의 Usage Rate 변경 요청
* 2011.04.27 손은주   1.2 [CHM-201109770-01][TRS] MEXBB 에서 처리되는 Rail S/O 에 대한 exception logic 적용가능성 검토요청 (US Rail surcharge 기능 연계)
* 2011.10.19 유선오   1.3 [CHM-201112874] [TRS] OTHER S/O Creation 화면 상 오류 수정요청
* 2011.10.20 이수진           [CHM-201113210] [TRS] Feeder Term 표기 칼럼 추가 요청
* 2012.05.08 김종호 [CHM-201217449] [TRS] Additional 칼럼, Other S/O creation 화면 입력기능 일부 변경
=========================================================*/
package com.hanjin.apps.alps.esd.trs.othersomanage.othersomanage.integration;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.trs.chassisgensetsomanage.chassisgensetsomanage.event.CostcdVO;
import com.hanjin.apps.alps.esd.trs.chassisgensetsomanage.chassisgensetsomanage.vo.ChassisGensetVO;
import com.hanjin.apps.alps.esd.trs.common.util.CommonUtil;
import com.hanjin.apps.alps.esd.trs.invoicemanage.surchargeinputinquiry.vo.SurchargeVO;
import com.hanjin.apps.alps.esd.trs.othersomanage.othersomanage.basic.OtherSOManageBCImpl;
import com.hanjin.apps.alps.esd.trs.othersomanage.othersomanage.event.EsdTrs0018Event;
import com.hanjin.apps.alps.esd.trs.othersomanage.othersomanage.vo.OtherSOVO;
import com.hanjin.apps.alps.esd.trs.othersomanage.othersomanage.vo.OtherSearchVO;
import com.hanjin.apps.alps.esd.trs.othersomanage.othersomanage.vo.RateApplyListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.TrsTrspSvcOrdVO;


/**
 * ESD-OtherSOManage에 대한 DB 처리를 담당<br>
 * - ESD-OtherSOManage Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author kimjin
 * @see OtherSOManageBCImpl 참조
 * @since J2EE 1.6
 */
public class OtherSOManageDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * WorkOrderIssue의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public GeneralEventResponse searchRateApplyList(EsdTrs0018Event event) throws DAOException {		
		DBRowSet dRs 	= null;
		Date costMonth 	= null;
		Map outProc 	= null;
		List rtnArr 	= new ArrayList();
		
		Map<String, Object> param 			= new HashMap<String, Object>();
		GeneralEventResponse eventResponse 	= new GeneralEventResponse();		
		TrsTrspSvcOrdVO[] model 			= event.getTrsTrspSvcOrdVOS();
		
		param.put("DATE", "20"+event.getTrspOtrCostMonDt()+"01");

		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new OtherSOManageDBDAOSearchCostMonthRSQL(), param, param);

			if(dRs.next()) 
				costMonth = dRs.getDate("COST_MONTH");
			
			param.clear();
			
			for(int m=0; model != null && m<model.length; m++){
				param.put("PI_CTRL_OFC_CD", 		event.getFormUsrOfcCd());
				param.put("PI_VNDR_SEQ", 			model[m].getVndrSeq());   
				if(costMonth!=null){
					param.put("PI_BASIS_DT", 			costMonth);
				}
				param.put("PI_WAY_TP_CD", 			"");
				param.put("PI_EQ_KND_CD", 			model[m].getEqKndCd());
				param.put("PI_EQ_TP_SZ_CD", 		model[m].getEqTpszCd());
				param.put("PI_CMB_TP_CD", 			"");
				param.put("PI_CGO_TP_CD", 			model[m].getCgoTpCd());
				param.put("PI_BOUND_CD", 			model[m].getTrspBndCd());
				param.put("PI_CRR_MOD_CD", 			model[m].getTrspCrrModCd());
				param.put("PI_COST_MOD_CD", 		model[m].getTrspCostDtlModCd());
				param.put("PI_CUST_NOMI_TRKR_FLG", 	model[m].getCustNomiTrkrIndCd());
				param.put("PI_CUST_CNT_CD", 		model[m].getCustCntCd());
				param.put("PI_CUST_SEQ", 			Integer.parseInt((model[m].getCustSeq()==null||model[m].getCustSeq().equals("")?"0":model[m].getCustSeq())));
				param.put("PI_RAIL_SVC_TP_CD", 		"");
				param.put("PI_CMDT_CD", 			model[m].getCmdtCd());
				param.put("PI_FROM_NOD_CD", 		model[m].getFmNodCd());
				param.put("PI_VIA_NOD_CD", 			model[m].getViaNodCd());
				param.put("PI_DOOR_NOD_CD", 		model[m].getDorNodCd());
				param.put("PI_TO_NOD_CD", 			model[m].getToNodCd());
				param.put("PI_BUNDLE_CNT", 			1);
				param.put("PI_WGT_UOM", 			model[m].getWgtMeasUtCd());
				param.put("PI_WGT_QTY", 			Float.parseFloat((model[m].getCntrWgt()==null||model[m].getCntrWgt().equals("")?"0":model[m].getCntrWgt())));
				param.put("PI_SPCL_CGO_CNTR_TP_CD", model[m].getSpclCgoCntrTpCd());

				outProc = new SQLExecuter("DEFAULT").executeSP((ISQLTemplate)new OtherSOManageDBDAOSearchRateApplyListRSQL(), param, param);

				String po_cust_cnt_cd 	= JSPUtil.getNull((String) outProc.get("po_cust_cnt_cd"));
				String po_cust_seq 		= JSPUtil.getNull((String) outProc.get("po_cust_seq"));
		
				RateApplyListVO rateApplyVO = new RateApplyListVO();
				
				rateApplyVO.setInvXchRt				(model[m].getInvXchRt());
				rateApplyVO.setPoTrspAgmtOfcCtyCd	(JSPUtil.getNull((String) outProc.get("PO_TRSP_AGMT_OFC_CTY_CD")));
				rateApplyVO.setPoTrspAgmtSeq		(JSPUtil.getNull((String) outProc.get("PO_TRSP_AGMT_SEQ")));
				rateApplyVO.setPoTrspAgmtRtTpCd		(JSPUtil.getNull((String) outProc.get("PO_TRSP_AGMT_RT_TP_CD")));
				rateApplyVO.setPoWayType			(JSPUtil.getNull((String) outProc.get("PO_WAY_TYPE")));
				rateApplyVO.setPoTrspAgmtRtTpNm		(JSPUtil.getNull((String) outProc.get("PO_TRSP_AGMT_RT_TP_NM")));
				rateApplyVO.setPoSpType				(JSPUtil.getNull((String) outProc.get("PO_SP_TYPE")));
				rateApplyVO.setPoCustNomiTrkrFlg	(JSPUtil.getNull((String) outProc.get("PO_CUST_NOMI_TRKR_FLG")));
				rateApplyVO.setPoCustCntCd			(po_cust_cnt_cd);
				rateApplyVO.setPoCustSeq			(po_cust_seq);
				rateApplyVO.setPoCustCndCdSeq		(po_cust_cnt_cd+po_cust_seq);
				rateApplyVO.setPoLocalCurrCd		(JSPUtil.getNull((String) outProc.get("PO_LOCAL_CURR_CD")));
				rateApplyVO.setPoBasicRt			(JSPUtil.getNull((String) outProc.get("PO_BASIC_RT")));
				rateApplyVO.setPoFuelScgRt			(JSPUtil.getNull((String) outProc.get("PO_FUEL_SCG_RT")));
				rateApplyVO.setPoOverWgtScgRt		(JSPUtil.getNull((String) outProc.get("PO_OVER_WGT_SCG_RT")));
				rateApplyVO.setPoVatScgRt			(JSPUtil.getNull((String) outProc.get("PO_VAT_SCG_RT")));
				rateApplyVO.setPoScg1Rt				(JSPUtil.getNull((String) outProc.get("PO_SCG1_RT")));
				rateApplyVO.setPoScg2Rt				(JSPUtil.getNull((String) outProc.get("PO_SCG2_RT")));
				rateApplyVO.setPoScg3Rt				(JSPUtil.getNull((String) outProc.get("PO_SCG3_RT")));
				rateApplyVO.setPoLocalCurrTotAmt	(JSPUtil.getNull((String) outProc.get("PO_LOCAL_CURR_TOT_AMT")));
				rateApplyVO.setPoUsdCurrTotAmt		(JSPUtil.getNull((String) outProc.get("PO_USD_CURR_TOT_AMT")));
				rateApplyVO.setPoRtnCd				(JSPUtil.getNull((String) outProc.get("PO_RTN_CD")));
				rateApplyVO.setPoRtnMsg				(JSPUtil.getNull((String) outProc.get("PO_RTN_MSG")));
				rateApplyVO.setPoWtrRcvTermCd       (JSPUtil.getNull((String) outProc.get("PO_WTR_RCV_TERM_CD"))); //2011.10.19 이수진 추가
				rateApplyVO.setPoWtrDeTermCd        (JSPUtil.getNull((String) outProc.get("PO_WTR_DE_TERM_CD")));
				
				rtnArr.add(rateApplyVO);
			}
			eventResponse.setRsVoList(rtnArr);
			return eventResponse;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
	}

	/**
	 * OtherSOManage의 모든 목록을 가져온다.<br>
	 *
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchOtherSOCorrectionList(EsdTrs0018Event event) throws DAOException {
		
		log.debug("\n\n:::::::::::: [searchOtherSOCorrectionList] :::::::::::::::::\n\n");
		
		OtherSearchVO 			searchVO 		= event.getOtherSearchVO();
		DBRowSet 				dRs 			= null;
		Map<String, Object> 	param 			= new HashMap<String, Object>();
		
		String fmdate 			= "".equals(searchVO.getFmdate())? null : JSPUtil.removeCharacter(searchVO.getFmdate(),"-");
		String todate 			= "".equals(searchVO.getTodate())? null : JSPUtil.removeCharacter(searchVO.getTodate(),"-");
		String trsCostMdCd 		= searchVO.getTrsCostMdCd();
		String trsMdCd 			= searchVO.getTrsMdCd();
		String trspSoFmNode 	= searchVO.getSearchFmLoc() + searchVO.getSearchFmYard();
		String trspSoToNode 	= searchVO.getSearchToLoc() + searchVO.getSearchToYard();
		String trspSoTpCd 		= event.getTrspSoTpCd();
		String creOfcCd			= event.getFormUsrOfcCd();
		String eqnumberArr 		= searchVO.getEqNo();
		
		try {
			
			if(fmdate!=null){
				param.put("fmdate"			, fmdate);
			}
			if(todate!=null){
				param.put("todate"			, todate);
			}
			param.put("trs_cost_md_cd"	, trsCostMdCd);
			param.put("trs_md_cd"		, trsMdCd);
			param.put("trsp_so_fm_node"	, trspSoFmNode);
			param.put("trsp_so_to_node"	, trspSoToNode);
			param.put("trsp_so_tp_cd"	, trspSoTpCd);
			param.put("cre_ofc_cd"		, creOfcCd);
			
			param.put("eqnumberArr"		, CommonUtil.seperationParameter(eqnumberArr, ","));			
			
			dRs = new SQLExecuter("DEFAULT").executeQuery(new OtherSOManageDBDAOSearchOtherSOCorrectionListRSQL(), param, param);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		
		return dRs;
	}

	/**
	 * OtherSOManage의 모든 목록을 가져온다.<br>
	 *
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchContainerEqNo(EsdTrs0018Event event) throws DAOException {
		
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		TrsTrspSvcOrdVO[] model = event.getTrsTrspSvcOrdVOS();
		List<String> eqNo = new ArrayList();   
		for(int i=0;i<model.length;i++){   
			eqNo.add(model[i].getEqNo());   
		}   
		
		param.put("eqNo", eqNo);
		param.put("row", event.getRow());
				
		try {
			dRs = new SQLExecuter("").executeQuery(new OtherSOManageDBDAOSearchContainerEqNoRSQL(), param,param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return dRs;
	}

	/**
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchChassisEqNo(EsdTrs0018Event event) throws DAOException {
		
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		TrsTrspSvcOrdVO[] model = event.getTrsTrspSvcOrdVOS();
		List<String> eqNo = new ArrayList();   
		for(int i=0;i<model.length;i++){   
			eqNo.add(model[i].getEqNo());   
		}   
		
		param.put("eqNo", eqNo);
		
		try {
			dRs = new SQLExecuter("").executeQuery(new OtherSOManageDBDAOSearchChassisEqNoRSQL(), param,param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return dRs;
		
	}

	/**
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchGensetEqNo(EsdTrs0018Event event) throws DAOException {
		
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		TrsTrspSvcOrdVO[] model = event.getTrsTrspSvcOrdVOS();
		List<String> eqNo = new ArrayList();   
		for(int i=0;i<model.length;i++){   
			eqNo.add(model[i].getEqNo());   
		}   
		
		param.put("eqNo", eqNo);
		
		try {
			dRs = new SQLExecuter("").executeQuery(new OtherSOManageDBDAOSearchGensetEqNoRSQL(), param,param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return dRs;
		
	}

	/**
	 * ChassisGensetSOManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param svcOrdV
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchTrspSvcOrdList(ArrayList svcOrdV) throws DAOException {

		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		param.put("TRSP_SO_SEQ", svcOrdV);
				
		try {
			dRs = new SQLExecuter("").executeQuery(new OtherSOManageDBDAOSearchTrspSvcOrdListRSQL(), param,param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return dRs;
	}

	/**
	 * OtherSOManage의 데이타 모델을 DB에 저장한다.<br>
	 *
	 * @param event
	 * @return 
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public ArrayList addTRS_TRSP_SVC_ORD(EsdTrs0018Event event) throws DAOException {
		DBRowSet dRs 		= null;
		String trspSoSeq	= "";
		ArrayList returnV 	= new ArrayList();
		CostcdVO costCdVO 	= new CostcdVO();
		
		Map<String,Object> param = new HashMap<String,Object>();
		
		try {
			
			TrsTrspSvcOrdVO[] 	soModel 		= event.getTrsTrspSvcOrdVOS();
			ChassisGensetVO[] 	cgModel 		= event.getChassisGensetVOS();			
			OtherSOVO[] 		otherSoModel 	= event.getOtherSOVOS();
			SurchargeVO[] 		scgModel 		= event.getSurchargeVOS();

			log.error("-_-;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;; OTHER SO CREATION soModel.length : "+soModel.length);
			
			for(int i=0;i<soModel.length;i++){
				dRs = new SQLExecuter("DEFAULT").executeQuery(new OtherSOManageDBDAOAddTrsSvcSeqRSQL(), null, null);

				if(dRs.next()) 
					trspSoSeq = dRs.getString("seq");

				String surchargeKey = otherSoModel[i].getSurchargeKey();
				
				//TRS_TRSP_SVC_ORD INSERT
				param.put("EQ_NO", 					soModel[i].getEqNo());				
				param.put("EQ_TPSZ_CD", 			JSPUtil.getNull(soModel[i].getEqTpszCd()).toUpperCase());			
				param.put("TRSP_BND_CD", 			soModel[i].getTrspBndCd());			
				param.put("CGO_TP_CD", 				soModel[i].getCgoTpCd());			
				param.put("CNTR_WGT", 				soModel[i].getCntrWgt());				
				param.put("WGT_MEAS_UT_CD", 		soModel[i].getWgtMeasUtCd());		
				param.put("TRSP_COST_DTL_MOD_CD", 	soModel[i].getTrspCostDtlModCd());	
				param.put("TRSP_CRR_MOD_CD", 		otherSoModel[i].getTrspCrrModCd());		
				param.put("CMDT_CD", 				soModel[i].getCmdtCd());				
				param.put("CUST_NOMI_TRKR_FLG", 	soModel[i].getCustNomiTrkrFlg());	
				param.put("CUST_CNT_CD", 			soModel[i].getCustCntCd());			
				param.put("CUST_SEQ", 				soModel[i].getCustSeq());				
				param.put("TRSP_OTR_COST_MON_DT", 	soModel[i].getTrspOtrCostMonDt());				
				param.put("FM_NOD_CD", 				cgModel[i].getFmLocValue() + cgModel[i].getFmYardValue());			
				param.put("VIA_NOD_CD", 			cgModel[i].getViaLocValue() + cgModel[i].getViaYardValue());			
				param.put("TO_NOD_CD", 				cgModel[i].getToLocValue() + cgModel[i].getToYardValue());			
				param.put("DOR_NOD_CD", 			cgModel[i].getDrLocValue() + cgModel[i].getDrYardValue());			
				param.put("DOR_DE_ADDR", 			soModel[i].getDorDeAddr());			
				param.put("VNDR_SEQ", 				soModel[i].getVndrSeq());				
				param.put("CURR_CD", 				soModel[i].getCurrCd());				
				param.put("BZC_AMT", 				soModel[i].getBzcAmt());				
				param.put("NEGO_AMT", 				soModel[i].getNegoAmt());				
				param.put("FUEL_SCG_AMT", 			soModel[i].getFuelScgAmt());
				param.put("TOLL_FEE_AMT", 			soModel[i].getTollFeeAmt());
				param.put("ETC_ADD_AMT", JSPUtil.removeCharacter(soModel[i].getEtcAddAmt(),","));			
				param.put("REF_BKG_NO", 			soModel[i].getRefBkgNo());			
				param.put("REF_BL_NO", 				soModel[i].getRefBlNo());				
//				param.put("SEN_WO_NO", soModel[i].get);			
				param.put("TRSP_PURP_RSN", 			soModel[i].getTrspPurpRsn());			
				param.put("TRSP_SO_OFC_CTY_CD_", 	event.getFormUsrOfcCd().substring(0,3));
				param.put("TRSP_SO_SEQ_", 			trspSoSeq);
				param.put("TRSP_SO_TP_CD_", 		event.getTrspSoTpCd());
				param.put("TRSP_SO_STS_CD_", 		event.getTrspSoStsCd());
				param.put("EQ_KND_CD", 				soModel[i].getEqKndCd());				
				param.put("TRSP_AGMT_RT_TP_CD", 	soModel[i].getTrspAgmtRtTpCd());	
				param.put("TRSP_AGMT_WY_TP_CD", 	soModel[i].getTrspAgmtWyTpCd());	
				param.put("TRSP_AGMT_OFC_CTY_CD", 	soModel[i].getTrspAgmtOfcCtyCd());	
				param.put("TRSP_AGMT_SEQ", 			soModel[i].getTrspAgmtSeq());		
				param.put("ACT_CUST_CNT_CD", 		soModel[i].getActCustCntCd());		
				param.put("ACT_CUST_SEQ", 			soModel[i].getActCustSeq());			
				param.put("ACT_CUST_ADDR_SEQ", 		soModel[i].getActCustAddrSeq());		
				param.put("FCTRY_NM", 				soModel[i].getFctryNm());				
				param.put("CNTC_PSON_NM", 			soModel[i].getCntcPsonNm());			
				param.put("CNTC_PSON_PHN_NO", 		soModel[i].getCntcPsonPhnNo());		
				param.put("CNTC_PSON_FAX_NO", 		soModel[i].getCntcPsonFaxNo());		
				param.put("COST_MODE", 				costCdVO.getCostCd("OT", otherSoModel[i].getTrspCrrModCd(),soModel[i].getCgoTpCd()));
				param.put("FORM_USR_OFC_CD", 		event.getFormUsrOfcCd());
				param.put("FORM_CRE_USR_ID", 		event.getFormCreUsrId());
				param.put("WTR_RCV_TERM_CD", 		soModel[i].getWtrRcvTermCd());
				param.put("WTR_DE_TERM_CD", 		soModel[i].getWtrDeTermCd());
				param.put("TTL_DIST", 				soModel[i].getTtlDist());
				param.put("LNK_DIST_DIV_CD", 		soModel[i].getLnkDistDivCd());
				param.put("NEGO_RMK", 				soModel[i].getNegoRmk());
				returnV.add(event.getFormUsrOfcCd().substring(0,3)+trspSoSeq);
								
				int x = new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new OtherSOManageDBDAOAddTrsSvcOrdCSQL(), param, param);
				
				log.error("\n-_-;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;; OTHER SO CREATION COUNT : "+x);
				
				//TRS_TRSP_SCG_DTL INSERT		
				
				if(scgModel!=null){
					for(int j=0;j<scgModel.length;j++){
						String unique_key = scgModel[j].getUniqueCd();
						if(unique_key!=null && unique_key.equals(surchargeKey)){				
							param.clear();
							param.put("TRSP_SO_OFC_CTY_CD", 		event.getFormUsrOfcCd().substring(0,3));
							param.put("TRSP_SO_SEQ", 				trspSoSeq);				
							param.put("LGS_COST_CD", 				scgModel[j].getLgsCostCd());				
							param.put("SCG_AMT", JSPUtil.removeCharacter(scgModel[j].getScgAmt(),","));
							param.put("DRY_RUN_RLBL_PTY_TP_CD", 	scgModel[j].getDryRunRlblPtyTpCd());		
							param.put("FNE_CUZ_DESC", 				scgModel[j].getFneCuzDesc());				
							param.put("FUMG_COST_TP_CD", 			scgModel[j].getFumgCostTpCd());			
							param.put("MGST_TPSZ_CD", 				scgModel[j].getMgstTpszCd());				
							param.put("INSP_RF_PTI_CSTMS_TP_CD", 	scgModel[j].getInspRfPtiCstmsTpCd());	
							param.put("LFTG_KNT", 					scgModel[j].getLftgKnt());					
							param.put("LFTG_CUZ_DESC", 				scgModel[j].getLftgCuzDesc());				
							param.put("STOP_LOC_NOD_CD", 			scgModel[j].getStopLocNodCd());			
							param.put("GRS_WGT", 					scgModel[j].getGrsWgt());
						if("SCOWAL".equals(scgModel[j].getLgsCostCd())){ // Surcharge 항목 중 Over Weight(Tri-axle) 값이 있을 경우 단위 정보 저장
							param.put("WO_GRS_WGT_MEAS_UT_CD", 				event.getWo_grs_wgt_meas_ut_cd());	
						}
							param.put("INCRT_DT", 					scgModel[j].getIncrtDt());	
							param.put("SCL_STOP_PLC_NOD_CD", 		scgModel[j].getSclStopPlcNodCd());		
							param.put("STO_DYS", 					scgModel[j].getStoDys());					
							param.put("OB_BKG_NO", 					scgModel[j].getObBkgNo());				
							param.put("WT_HRS", 					scgModel[j].getWtHrs());					
							param.put("OTR_RMK", 					scgModel[j].getOtrRmk());					
							param.put("INV_SCG_AMT", JSPUtil.removeCharacter(scgModel[j].getInvScgAmt(),","));
							param.put("INV_DRY_RUN_RLBL_PTY_TP_CD", scgModel[j].getInvDryRunRlblPtyTpCd());	
							param.put("INV_FNE_CUZ_DESC", 			scgModel[j].getInvFneCuzDesc());			
							param.put("INV_FUMG_COST_TP_CD", 		scgModel[j].getInvFumgCostTpCd());		
							param.put("INV_MGST_TPSZ_CD", 			scgModel[j].getInvMgstTpszCd());			
							param.put("INV_INSP_RF_PTI_CSTMS_TP_CD", scgModel[j].getInvInspRfPtiCstmsTpCd());	
							param.put("INV_LFTG_KNT", 				scgModel[j].getInvLftgKnt());				
							param.put("INV_LFTG_CUZ_DESC", 			scgModel[j].getInvLftgCuzDesc());			
							param.put("INV_STOP_LOC_NOD_CD", 		scgModel[j].getInvStopLocNodCd());		
							param.put("INV_GRS_WGT", 				scgModel[j].getInvGrsWgt());				
							param.put("INV_INCRT_DT", 				scgModel[j].getInvIncrtDt());	
							param.put("INV_SCL_STOP_PLC_NOD_CD", 	scgModel[j].getInvSclStopPlcNodCd());	
							param.put("INV_STO_DYS", 				scgModel[j].getInvStoDys());				
							param.put("INV_OB_BKG_NO", 				scgModel[j].getInvObBkgNo());				
							param.put("INV_WT_HRS", 				scgModel[j].getInvWtHrs());				
							param.put("INV_OTR_RMK", 				scgModel[j].getInvOtrRmk());				
							param.put("N3PTY_BIL_FLG", 				scgModel[j].getN3ptyBilFlg());				
							param.put("CUST_CNT_CD", 				scgModel[j].getCustCntCd());				
							param.put("CUST_SEQ", 					scgModel[j].getCustSeq());					
							param.put("N3PTY_VNDR_SEQ", 			scgModel[j].getN3ptyVndrSeq());			
							param.put("N3PTY_OFC_CD", 				scgModel[j].getN3ptyOfcCd());				
							param.put("N3PTY_AMT", JSPUtil.removeCharacter(scgModel[j].getN3ptyAmt(),","));				
							param.put("N3PTY_DESC", 				scgModel[j].getN3ptyDesc());				
							param.put("FORM_USR_OFC_CD", 			event.getFormUsrOfcCd());
							param.put("FORM_CRE_USR_ID", 			event.getFormCreUsrId());
							param.put("INCUR_DT", 				scgModel[j].getIncurDt());
							param.put("CHSS_NO", 				scgModel[j].getChssNo());
							param.put("INV_INCUR_DT", 				scgModel[j].getInvIncurDt());
							param.put("INV_CHSS_NO", 				scgModel[j].getInvChssNo());
							
							param.put("RF_HNDL_FLG", 				scgModel[j].getRfHndlFlg());
							param.put("RF_MGST_USG_FLG", 			scgModel[j].getRfMgstUsgFlg());
							param.put("TRI_AXL_FLG", 				scgModel[j].getTriAxlFlg());
							param.put("OVR_WGT_PRMT_FLG", 			scgModel[j].getOvrWgtPrmtFlg());
							param.put("OVR_WGT_OTR_FLG", 			scgModel[j].getOvrWgtOtrFlg());
							param.put("OVR_WGT_RMK", 				scgModel[j].getOvrWgtRmk());
							param.put("INV_RF_HNDL_FLG", 			scgModel[j].getInvRfHndlFlg());
							param.put("INV_RF_MGST_USG_FLG", 		scgModel[j].getInvRfMgstUsgFlg());
							param.put("INV_TRI_AXL_FLG", 			scgModel[j].getInvTriAxlFlg());
							param.put("INV_OVR_WGT_PRMT_FLG", 		scgModel[j].getInvOvrWgtPrmtFlg());
							param.put("INV_OVR_WGT_OTR_FLG", 		scgModel[j].getInvOvrWgtOtrFlg());
							param.put("INV_OVR_WGT_RMK", 			scgModel[j].getInvOtrRmk());
							
							new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new OtherSOManageDBDAOAddTrsSvcScgDtlCSQL(), param, param);
						}
					}
				}
				//TRS_TRSP_EXPN_CONV_AMT INSERT
				if(otherSoModel[i].getCurrCd()!= null && !otherSoModel[i].getCurrCd().equals("")){				
					param.clear();
					param.put("TRSP_SO_OFC_CTY_CD", event.getFormUsrOfcCd().substring(0,3));
					param.put("TRSP_SO_SEQ", 		trspSoSeq);				
					param.put("BZC_AMT", 			otherSoModel[i].getBzcAmt());
					param.put("CURR_CD", 			otherSoModel[i].getCurrCd());
					param.put("FUEL_SCG_AMT", 		otherSoModel[i].getFuelScgAmt());
					param.put("OVR_WGT_SCG_AMT", 	otherSoModel[i].getOvrWgtScgAmt());
					param.put("ETC_ADD_AMT", 		JSPUtil.removeCharacter(otherSoModel[i].getEtcAddAmt(),","));
					param.put("FORM_USR_OFC_CD", 	event.getFormUsrOfcCd());
					param.put("FORM_CRE_USR_ID", 	event.getFormCreUsrId());
					
					new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new OtherSOManageDBDAOAddTrsSvcConvAmtUsdCSQL(), param, param);
					new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new OtherSOManageDBDAOAddTrsSvcConvAmtEurCSQL(), param, param);
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnV;
	}

	/**
	 * OtherSOManage의 수정 된 데이타 모델을 DB에 반영한다.<br>
	 *
	 * @param event
	 * @throws DAOException
	 */
	public void modifyOtherSOManage(EsdTrs0018Event event) throws DAOException {
		
		Map<String, Object> param 	= new HashMap<String, Object>();
		
		TrsTrspSvcOrdVO[] models = event.getTrsTrspSvcOrdVOS();
		
		int updCnt = 0;
		
		try {
			//TRS_TRSP_SVC_ORD 테이블에 자료 입력
			
			TrsTrspSvcOrdVO model = null;
			
			for(int i=0; models!=null && i<models.length; i++) {
				
				model = (TrsTrspSvcOrdVO)models[i];

				if (model.getIbflag().length() > 0) {
                    if(model.getActCustCntCd() != null && model.getActCustCntCd().length() > 2){
						param.put("act_cust_cnt_cd"		, model.getActCustCntCd().substring(0,2));
				    	param.put("act_cust_seq"		, model.getActCustCntCd().substring(2, model.getActCustCntCd().length()));
                    }
                    param.put("ref_bkg_no"			, model.getRefBkgNo());
					param.put("ref_bl_no"			, model.getRefBlNo());
					param.put("trsp_purp_rsn"		, model.getTrspPurpRsn());
					param.put("usr_ofc_cd"			, event.getFormUsrOfcCd());
					param.put("upd_usr_id"			, event.getFormCreUsrId());
					param.put("trsp_so_ofc_cty_cd"	, model.getTrspSoOfcCtyCd());		
					param.put("trsp_so_seq"			, model.getTrspSoSeq());
					param.put("trsp_so_tp_cd"       , model.getTrspSoTpCd());
					param.put("cgo_tp_cd"			, model.getCgoTpCd());
					param.put("eq_knd_cd"			, model.getEqKndCd());	
					param.put("trsp_otr_cost_mon_dt", model.getTrspOtrCostMonDt());   
					param.put("dor_de_addr"			, model.getDorDeAddr());
				
					updCnt = new SQLExecuter("DEFAULT").executeUpdate(new OtherSOManageDBDAOModifyOtherSOManageUSQL(), param, param);
					if(updCnt == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to update SQL");
					}			
				}
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
	}			

	/**
	 * OtherSOManage의 데이타 모델을 DB에서 삭제한다.<br>
	 *
	 * @param event
	 * @throws DAOException
	 */
	public void removeOtherSOManage(EsdTrs0018Event event) throws DAOException {
		
		Map<String, Object> param 	= new HashMap<String, Object>();
		
		TrsTrspSvcOrdVO[] models = event.getTrsTrspSvcOrdVOS();
		
		int updCnt = 0;
		
		try {
			//TRS_TRSP_SVC_ORD 테이블에 자료 입력
			
			TrsTrspSvcOrdVO model = null;
			
			for(int i=0; models!=null && i<models.length; i++) {
				
				model = (TrsTrspSvcOrdVO)models[i];

				if (model.getIbflag().length() > 0) {
					
					param.put("usr_ofc_cd"			, event.getFormUsrOfcCd());
					param.put("upd_usr_id"			, event.getFormCreUsrId());
					param.put("trsp_so_ofc_cty_cd"	, model.getTrspSoOfcCtyCd());
					param.put("trsp_so_seq"			, model.getTrspSoSeq());
					
					updCnt = new SQLExecuter("DEFAULT").executeUpdate(new OtherSOManageDBDAORemoveOtherSOManageUSQL(), param, param);
					if(updCnt == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to update SQL");
					}			
				}
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 		
	}	
}



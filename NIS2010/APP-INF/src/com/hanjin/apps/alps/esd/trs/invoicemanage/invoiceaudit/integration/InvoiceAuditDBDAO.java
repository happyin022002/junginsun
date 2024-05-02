/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : invoiceauditDBDAO.java
 *@FileTitle : Currency Change Popup
 *Open Issues :
 *2006-12-06 Lee_SangWoo
 *1.0 최초 생성
 *Change history :
 *@LastModifyDate : 2009-03-04
 *@LastModifier : ah_young
 *@LastVersion : 1.198
 * N200902260160 WIS Invoice의 TRS Process User ID 표시건 요청 (2009-03-04)
 * 1.199 N200902240180 [TRS] TPB 대상 건 I/F 가능 시점 추가 요청 (09.03.17)
 * 2011.06.08 손은주 [CHM-201109770-01]	[TRS] MEXBB 에서 처리되는 Rail S/O 에 대한 exception logic 적용가능성 검토요청 (US Rail surcharge 기능 연계)
 * 2012.05.08 김종호 [CHM-201217449] [TRS] Additional 칼럼, Other S/O creation 화면 입력기능 일부 변경  
 * 2013.02.26 조인영 [CHM-201323086] Invoice Audit시 validation 추가 요청
 =========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.basic.InvoiceAuditBCImpl;
import com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.event.EsdTrs0033Event;
import com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.event.EsdTrs0040Event;
import com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.vo.InvoiceAuditVO;
import com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.vo.SearchInvoiceAuditVO;
import com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.vo.SearchTruckInvoiceFileImportVO;
import com.hanjin.apps.alps.esd.trs.invoicemanage.surchargeinputinquiry.vo.SurchargeVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.TrsTrspSvcOrdVO;
import com.hanjin.syscommon.common.table.TrsTrspRfndInvVO;
import com.hanjin.framework.component.util.JSPUtil;


/**
 * ESD-invoicemanage에 대한 DB 처리를 담당<br> - ESD-invoicemanage Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Lee_SangWoo
 * @see InvoiceAuditBCImpl 참조
 * @since J2EE 1.4
 */
@SuppressWarnings("unchecked")
public class InvoiceAuditDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6581140445032704788L;

	/**
	 * invoice 리스트 가져오기<br>
	 * 
	 * @param event
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchInvoiceAuditList(EsdTrs0033Event event) throws DAOException {
		DBRowSet dRs = null;		
		Map<String, Object> param = new HashMap<String, Object>();
		SearchInvoiceAuditVO siavo = event.getSearchInvoiceAuditVO();
		StringTokenizer st = null;
		
		try {
			String wo_no = siavo.getWoNo();
			String so_no = siavo.getSoNo();
			String booking_no = siavo.getBookingNo();
			String bl_no = siavo.getBlNo();
			String eq_no = siavo.getEqNoText();
			String temp = "";
			
			
			if( !wo_no.equals("") && !wo_no.equals("null")) {
				int j = 0;
				st = new StringTokenizer(wo_no, ",");
				List<InvoiceAuditVO> woArr = new ArrayList<InvoiceAuditVO>(); 
				

				while( st.hasMoreTokens() ) {
					InvoiceAuditVO woVO = new InvoiceAuditVO(); 
					temp = "";
					temp = st.nextToken();
					woVO.setTrspWoOfcCtyCd(temp.substring(0, 3));
					woVO.setTrspWoSeq(temp.substring(3));
					woArr.add(j++,woVO);
				}
				param.put("woArr", woArr);
			} 

			
			if( !so_no.equals("") && !so_no.equals("null")) {
//				int j = 0;
				st = new StringTokenizer(so_no, ",");
				List<InvoiceAuditVO> soArr = new ArrayList<InvoiceAuditVO>(); 

				while( st.hasMoreTokens() ) {
					InvoiceAuditVO soVO = new InvoiceAuditVO();
					temp = "";
					temp = st.nextToken();
					soVO.setTrspSoOfcCtyCd(temp.substring(0, 3));
					soVO.setTrspSoSeq(temp.substring(3));
					soArr.add(soVO);
				}
				param.put("soArr", soArr);
			} 
			
			if( !booking_no.equals("") && !booking_no.equals("null")) {
				int j = 0;
				st = new StringTokenizer(booking_no, ",");
				ArrayList<String> bkgNoArr = new ArrayList<String>(); 
				
				while( st.hasMoreTokens() ) {
					bkgNoArr.add(j++,  st.nextToken());
					
				}
				param.put("bkgNoArr", bkgNoArr);
			} 
			
			if( !bl_no.equals("") && !bl_no.equals("null")) {
				int j = 0;
				st = new StringTokenizer(bl_no, ",");
				ArrayList<String> blNoArr = new ArrayList<String>(); 
				
				while( st.hasMoreTokens() ) {
					blNoArr.add(j++,  st.nextToken());
					
				}
				param.put("blNoArr", blNoArr);
			} 
			
			if( !eq_no.equals("") && !eq_no.equals("null")) {
				int j = 0;
				st = new StringTokenizer(eq_no, ",");
				ArrayList<String> eqNoArr = new ArrayList<String>(); 
				
				while( st.hasMoreTokens() ) {
					eqNoArr.add(j++,  st.nextToken());
					
				}
				param.put("eqNoArr", eqNoArr);
			}
	
			param.put("paymt_sp_cd", siavo.getPaymtSpCd());
			param.put("ofc_cd", siavo.getFormUsrOfcCd());

			dRs = new SQLExecuter("DEFAULT").executeQuery(new InvoiceAuditDBDAOSearchInvoiceAuditListRSQL(), param,param);
			

			
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
	 * invoice 리스트 가져오기<br>
	 * 
	 * @param event
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchInvoiceAuditListByInvoiceNo(EsdTrs0033Event event) throws DAOException {
		DBRowSet dRs = null;		
		Map<String, Object> param = new HashMap<String, Object>();
		SearchInvoiceAuditVO siavo = event.getSearchInvoiceAuditVO();
		
		try {
			param.put("inv_no", siavo.getInvoiceNo());
			param.put("paymt_sp_cd", siavo.getPaymtSpCd());
			param.put("trsp_inv_act_sts_cd_param", JSPUtil.getNull(siavo.getTrspInvActStsCdParam()));
			dRs = new SQLExecuter("DEFAULT").executeQuery(new InvoiceAuditDBDAOSearchInvoiceAuditListByInvoiceNoRSQL(), param,param);
						
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
	 *  SPP Invoice 건일경우 Invoice 상태를 Reject 상태로 수정.<br>
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void rejectInvoice(EsdTrs0033Event event) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		SearchInvoiceAuditVO siaVo = event.getSearchInvoiceAuditVO();

		try{
			if( siaVo != null ){
				param.put("ofc_cd", siaVo.getFormUsrOfcCd());
				param.put("inv_no", siaVo.getInvoiceNo());
				param.put("paymt_sp_cd", siaVo.getPaymtSpCd());
				new SQLExecuter("DEFAULT").executeUpdate(new InvoiceAuditDBDAORejectInvoiceUSQL(), param, param);
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
	 * invoice office 리스트 가져오기<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchInvOfcCd(EsdTrs0033Event event) throws DAOException {
		DBRowSet dRs = null;		
		Map<String, Object> param = new HashMap<String, Object>();
		SearchInvoiceAuditVO siav = event.getSearchInvoiceAuditVO();

		try {
			param.put("ofc_cd", siav.getFormUsrOfcCd());
						
			dRs = new SQLExecuter("DEFAULT").executeQuery(new InvoiceAuditDBDAOSearchInvOfcCdRSQL(), param,param);
						
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
	 * invoice 중복 체크<br>
	 * 
	 * @param event
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchDupChkInvoice(EsdTrs0033Event event) throws DAOException {
		DBRowSet dRs = null;		
		Map<String, Object> param = new HashMap<String, Object>();
		SearchInvoiceAuditVO siav = event.getSearchInvoiceAuditVO();
		String mode_param = null;
		try {
			mode_param = siav.getModeParam();
			if (mode_param != null && (mode_param.equals("search") || mode_param.equals("modify"))) {
				param.put("inv_no", siav.getInvNoParam());
				param.put("paymt_sp_cd", siav.getInvVndrSeqParam());

			}else{
				param.put("inv_no", siav.getInvoiceNo());
				param.put("paymt_sp_cd", siav.getPaymtSpCd());
			}
			
			dRs = new SQLExecuter("DEFAULT").executeQuery(new InvoiceAuditDBDAOSearchDupChkInvoiceRSQL(), param,param);
						
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
	 * WO SP의 PARENTS SP를 가져온다.<br>
	 * 
	 * @param event
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchPaymentSP(EsdTrs0033Event event) throws DAOException {
		DBRowSet dRs = null;		
		Map<String, Object> param = new HashMap<String, Object>();

		String combo_svc_provider = event.getCombo_svc_provider();
		
		
		try {
			
			if(!"".equals(combo_svc_provider) && combo_svc_provider != null ){
				param.put("combo_svc_provider", combo_svc_provider);
				dRs = new SQLExecuter("DEFAULT").executeQuery(new InvoiceAuditDBDAOSearchPaymentSPRSQL(), param,param);
			}

			
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
	 * SO의 Suchargy를 가지고 온다.<br>
	 * 
	 * @param event
	 * 
	 * @return ArrayList
	 * @throws DAOException
	 */
	
	public ArrayList searchWoSurcharge(EsdTrs0033Event event) throws DAOException {
		DBRowSet dRs = null;		
		Map<String, Object> param = new HashMap<String, Object>();
		SurchargeVO[] scgArr 			= event.getSurchargeVOs(); // event.getSurchargeVoList();
//		List<AbstractValueObject> suchargyList = null;
		ArrayList returnScgList = new ArrayList();
		try {

			ArrayList ofcList 			= new ArrayList();
			ArrayList soList 			= new ArrayList();
			HashMap soListMap			= new HashMap();
			double	n3ptyAmt			= 0;
			
			String trspSoOfcCtyCd 		= null;
			String trspSoSeq 			= null;
			if( scgArr != null ){
				for(int k=0; k<scgArr.length; k++){
					trspSoSeq 				= scgArr[k].getTrspSoSeq();
					if(!contains(soList, trspSoSeq)){
						trspSoOfcCtyCd 		= scgArr[k].getTrspSoOfcCtyCd();
						ofcList.add(trspSoOfcCtyCd);
						soList.add(trspSoSeq);
						ArrayList tempList = new ArrayList();
						tempList.add(scgArr[k]);
						soListMap.put(trspSoSeq, tempList);
					}else{
						ArrayList tempList = (ArrayList) soListMap.get(trspSoSeq);
						tempList.add(scgArr[k]);
						soListMap.put(trspSoSeq, tempList);
					}
				}
				
				for(int n=0; n<soList.size(); n++){
					param.put("trsp_so_ofc_cty_cd", ofcList.get(n));
					param.put("trsp_so_seq", soList.get(n));
					ArrayList tempList = (ArrayList) soListMap.get((String) soList.get(n));
					
					dRs = new SQLExecuter("DEFAULT").executeQuery(new InvoiceAuditDBDAOSearchWoSurchargeRSQL(), param, param);
					
					while( dRs.next()){
						SurchargeVO scgVO = getScgByLgsCostCd(tempList, dRs.getString("LGS_COST_CD"));
						scgVO.setTrspSoOfcCtyCd(dRs.getString("TRSP_SO_OFC_CTY_CD"));
						scgVO.setTrspSoSeq(dRs.getString("TRSP_SO_SEQ")); 
						scgVO.setLgsCostCd(dRs.getString("LGS_COST_CD"));
						scgVO.setScgAmt(dRs.getString("SCG_AMT"));
						//scgVO.setChssMgstTpszCd(dRs.getString("CHSS_MGST_TPSZ_CD")); 
						scgVO.setDryRunRlblPtyTpCd(dRs.getString("DRY_RUN_RLBL_PTY_TP_CD"));
						scgVO.setFneCuzDesc(dRs.getString("FNE_CUZ_DESC"));
						scgVO.setFumgCostTpCd(dRs.getString("FUMG_COST_TP_CD"));
						scgVO.setMgstTpszCd(dRs.getString("MGST_TPSZ_CD"));
						scgVO.setInspRfPtiCstmsTpCd(dRs.getString("INSP_RF_PTI_CSTMS_TP_CD"));
						scgVO.setLftgKnt(dRs.getString("LFTG_KNT"));
						scgVO.setLftgCuzDesc(dRs.getString("LFTG_CUZ_DESC"));
						scgVO.setStopLocNodCd(dRs.getString("STOP_LOC_NOD_CD"));
						scgVO.setGrsWgt(dRs.getString("GRS_WGT"));
						scgVO.setIncrtDt(dRs.getString("INCRT_DT"));
						scgVO.setSclStopPlcNodCd(dRs.getString("SCL_STOP_PLC_NOD_CD"));
						scgVO.setStoDys(dRs.getString("STO_DYS"));
						scgVO.setObBkgNo(dRs.getString("OB_BKG_NO"));
						//scgVO.setObBkgNoSplit(dRs.getString("OB_BKG_NO_SPLIT"));
						scgVO.setWtHrs(dRs.getString("WT_HRS"));
						scgVO.setOtrRmk(dRs.getString("OTR_RMK"));
						scgVO.setChssNo(dRs.getString("CHSS_NO"));
						scgVO.setIncurDt(dRs.getString("INCUR_DT"));
						
						n3ptyAmt =  toDouble(scgVO.getN3ptyAmt());
						
						if( n3ptyAmt == 0 ){
							scgVO.setN3ptyBilFlg(dRs.getString("N3PTY_BIL_FLG"));
							scgVO.setCustCntCd(dRs.getString("CUST_CNT_CD"));
							scgVO.setCustSeq(dRs.getString("CUST_SEQ"));
							scgVO.setN3ptyVndrSeq(dRs.getString("N3PTY_VNDR_SEQ"));
							scgVO.setN3ptyOfcCd(dRs.getString("N3PTY_OFC_CD"));
							scgVO.setN3ptyAmt(dRs.getString("N3PTY_AMT"));
							scgVO.setN3ptyDesc(dRs.getString("N3PTY_DESC"));
						}
						scgVO.setCreOfcCd(dRs.getString("CRE_OFC_CD"));
						scgVO.setCreUsrId(dRs.getString("CRE_USR_ID"));
						scgVO.setCreDt(dRs.getString("CRE_DT"));
						scgVO.setUniqueCd(dRs.getString("TRSP_SO_SEQ"));
						returnScgList.add(scgVO);
					}
					returnScgList.addAll(tempList);
					
					
				}
			}
			
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		
		return returnScgList;

	}

	
	/**
	 * 중복 try 때문에 toDouble에 대해 따로 정의함..<br>
	 * @param String
	 * 
	 * @param double
	 *            데이타 모델
	 * @throws
	 */
	private double toDouble(String src){
		double n3ptyAmt = 0;
		try{
			if(src != null && !src.equals("")) {
				n3ptyAmt = Double.parseDouble(src);
			}else{
				n3ptyAmt = 0;
			}
		}catch(NumberFormatException nfe){
			n3ptyAmt = 0;
			log.error(nfe.getMessage(), nfe);
		}
		return n3ptyAmt;
	}
	
	
	/**
	 * LGS_COST_CD가 일치하는 SurchargeVO를 리턴한다..<br>
	 * 일치하는 건이 없을경우 NEW SurchargeVO를 리턴한다.
	 * @param event
	 * 
	 * @param model
	 *            데이타 모델
	 * @throws DAOException
	 */
	private SurchargeVO getScgByLgsCostCd(ArrayList soList, String lgsCd){
		
		SurchargeVO returnVO = null;
		for(int i=0;lgsCd != null && soList != null &&  i<soList.size(); i++){
			if ( lgsCd.equals(((SurchargeVO) soList.get(i)).getLgsCostCd() ) ){
				returnVO = (SurchargeVO) soList.get(i);
				soList.remove(i);
				break;
			}
		}
		if( returnVO == null){ returnVO = new SurchargeVO(); }
		return returnVO;
	}

	/**
	 * Invoice Audit List를 DB에 저장한다.<br>
	 * 
	 * @param event EsdTrs0033Event
	 *
	 * @throws DAOException
	 */
	public void saveInvoiceAudit(EsdTrs0033Event event) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		SearchInvoiceAuditVO searchInvAudVo = event.getSearchInvoiceAuditVO();
		boolean isDelete = true;
		String ida_ofc_yn = event.getIda_ofc_cd();

		try {
			String if_sys_knd_cd = searchInvAudVo.getIfSysKndCdParam();
			if(if_sys_knd_cd == null || "".equals(if_sys_knd_cd))
				if_sys_knd_cd = "E";
			
			String trsp_inv_aud_sts_cd = searchInvAudVo.getTrspInvAudStsCdParam();
			if (trsp_inv_aud_sts_cd == null || trsp_inv_aud_sts_cd.equals(""))
				trsp_inv_aud_sts_cd = "SV";
		
			searchInvAudVo.setIfSysKndCd(if_sys_knd_cd);
			searchInvAudVo.setTrspInvAudStsCd(trsp_inv_aud_sts_cd);
			Map<String, String> param_Vo = searchInvAudVo.getColumnValues();

			param.putAll(param_Vo);

			int updateResult = new SQLExecuter("DEFAULT").executeUpdate(new InvoiceAuditDBDAOSaveInvoiceAuditUSQL(), param,param);			
						
			if(updateResult == 0){
//				int insertResult = new SQLExecuter("DEFAULT").executeUpdate(new InvoiceAuditDBDAOSaveInvoiceAuditCSQL(), param,param);			
				new SQLExecuter("DEFAULT").executeUpdate(new InvoiceAuditDBDAOSaveInvoiceAuditCSQL(), param,param);			
						
			}

			Collection<InvoiceAuditVO> soModels = new ArrayList<InvoiceAuditVO>();
			Collection<SurchargeVO> scModels = new ArrayList<SurchargeVO>();
			Collection<TrsTrspSvcOrdVO> svcModels = new ArrayList<TrsTrspSvcOrdVO>();
			
			InvoiceAuditVO[] invArr = event.getInvoiceAuditVOs();
			SurchargeVO[] surArr = event.getSurchargeVOs();
			TrsTrspSvcOrdVO[] soArr = event.getTrsTrspSvcOrdVOS();
			
			for( int i=0; i<invArr.length; i++){
				soModels.add((InvoiceAuditVO)invArr[i]);
			}
			if(surArr != null ){
				for( int i=0; i<surArr.length; i++){
					scModels.add((SurchargeVO)surArr[i]);
				}
			}
			for( int i=0; i<soArr.length; i++){
				svcModels.add((TrsTrspSvcOrdVO)soArr[i]);
			}
			
			
			InvoiceAuditVO model = null;
			SurchargeVO model3 = null;
			TrsTrspSvcOrdVO svcModel = null;
			String uniqueSeq = "";
			String surchargeKey = "";
			String invoiceCurr = searchInvAudVo.getApplyCurrency();
			
			Iterator itr = soModels.iterator();
			Iterator svcItr = svcModels.iterator();
			while (itr.hasNext()) {
				model = (InvoiceAuditVO) itr.next();
				svcModel = (TrsTrspSvcOrdVO) svcItr.next();
				uniqueSeq = model.getTrspSoSeq();
				DBRowSet checkWrkordRs = null;	
				DBRowSet selectRs = null;	
				if (svcModel != null) {
					Map<String, Object> param_chk = new HashMap<String, Object>();
					param_chk.put("trsp_so_ofc_cty_cd", svcModel.getTrspSoOfcCtyCd());
					param_chk.put("trsp_so_seq", svcModel.getTrspSoSeq());

					checkWrkordRs = new SQLExecuter("DEFAULT").executeQuery(new InvoiceAuditDBDAOSaveInvoiceAuditRSQL(), param_chk,param_chk);
					
					if( checkWrkordRs.next()){
						throw new DAOException(new ErrorHandler("TRS50103").getMessage());						
					}

					param_chk.put("invoice_no", searchInvAudVo.getInvoiceNo());
					param_chk.put("paymt_sp_cd", searchInvAudVo.getPaymtSpCd());
					
					selectRs = new SQLExecuter("DEFAULT").executeQuery(new InvoiceAuditDBDAOSaveInvoiceAuditNotInvNoRSQL(), param_chk,param_chk);
					
					if( selectRs.next()){
						throw new DAOException(new ErrorHandler("TRS00100").getMessage());						
					}					
				}
				//SPP 데이터 Surcharge Temp에 정보 입력
				if(if_sys_knd_cd!= null && if_sys_knd_cd.equals("W")){
					
					param.clear();
					if( svcModel != null ){
						svcModel.setN3ptyDesc("SPP_INV_BZC_AMT:"+svcModel.getInvBzcAmt());
					}
					if( svcModel != null ){
						Map<String, String> param_soVo = svcModel.getColumnValues();
						param.putAll(param_soVo);
						param.put("bzc_amt", JSPUtil.removeCharacter(param_soVo.get("bzc_amt"),","));
						param.put("fuel_scg_amt", JSPUtil.removeCharacter(param_soVo.get("fuel_scg_amt"),","));
						param.put("etc_add_amt", JSPUtil.removeCharacter(param_soVo.get("etc_add_amt"),","));
						param.put("nego_amt", JSPUtil.removeCharacter(param_soVo.get("nego_amt"),","));
					}
					param.put("FORM_USR_OFC_CD", searchInvAudVo.getFormUsrOfcCd());
					param.put("FORM_CRE_USR_ID", searchInvAudVo.getFormCreUsrId());
//					int insertResult = new SQLExecuter("DEFAULT").executeUpdate(new InvoiceAuditDBDAOSaveInvoiceAuditScgTmpCSQL(), param,param);			
					new SQLExecuter("DEFAULT").executeUpdate(new InvoiceAuditDBDAOSaveInvoiceAuditScgTmpCSQL(), param,param);			
					
				}
				//SPP에서 조회 가능하도록 WORK ORDER OPEN FLAG를 'Y'로 수정
				param.clear();
				param.put("FORM_CRE_USR_ID", searchInvAudVo.getFormCreUsrId());
				param.put("FORM_USR_OFC_CD", searchInvAudVo.getFormUsrOfcCd());
				if( svcModel != null ){
					Map<String, String> param_wo = svcModel.getColumnValues();
					param.putAll(param_wo);
				}
				new SQLExecuter("DEFAULT").executeUpdate(new InvoiceAuditDBDAOSaveInvoiceAuditWoOpnFlgUSQL(), param,param);			
				
				param.clear();
				
				if( svcModel != null ){
					TrsTrspSvcOrdVO svcModel_copy = (TrsTrspSvcOrdVO)svcModel.clone();
					if (model.getIbflag().length() > 0) {
						surchargeKey = model.getTrspSoSeq(); // getSurcharge_key();
	
						svcModel_copy.setEqNo(model.getEqNo());
						if( svcModel != null ){
							if( svcModel_copy.getEqTpszCd() == null || "".equals(svcModel.getEqTpszCd()) ){
								svcModel_copy.setEqTpszCd(model.getEqTpszCd());
							}
						}
						svcModel_copy.setTrspInvActStsCd(model.getTrspInvActStsCd());
						svcModel_copy.setInvCurrCd(searchInvAudVo.getApplyCurrency());
						svcModel_copy.setTrspSoOfcCtyCd(model.getTrspSoOfcCtyCd());
						svcModel_copy.setTrspSoSeq(model.getTrspSoSeq());
						Map<String, String> param_so = svcModel_copy.getColumnValues();
						param.put("invoice_no", searchInvAudVo.getInvoiceNo());
						param.put("paymt_sp_cd", searchInvAudVo.getPaymtSpCd());
						param.put("FORM_CRE_USR_ID", searchInvAudVo.getFormCreUsrId());
						param.put("FORM_USR_OFC_CD", event.getFORM_USR_OFC_CD());
						param.put("inv_curr_cd", invoiceCurr);
						param.putAll(param_so);
						param.put("inv_bzc_amt", JSPUtil.removeCharacter(param_so.get("inv_bzc_amt"),","));
						param.put("inv_etc_add_amt", JSPUtil.removeCharacter(param_so.get("inv_etc_add_amt"),","));
						
						new SQLExecuter("DEFAULT").executeUpdate(new InvoiceAuditDBDAOSaveInvoiceAuditSoUSQL(), param,param);
						if ("Y".equals(ida_ofc_yn)) {
							new SQLExecuter("DEFAULT").executeUpdate(new InvoiceAuditDAOSaveIdaGstMergeCSQL(), param,param);
						}
						
						if(!"".equals(model.getInvEtcAddAmt()) && Double.parseDouble(JSPUtil.removeCharacter(model.getInvEtcAddAmt(), ","))==0){
							Map<String, Object> param_zero = new HashMap<String, Object>();
							param_zero.put("FORM_CRE_USR_ID", searchInvAudVo.getFormCreUsrId());
							param_zero.put("FORM_USR_OFC_CD", searchInvAudVo.getFormUsrOfcCd());
							param_zero.put("trsp_so_ofc_cty_cd", model.getTrspSoOfcCtyCd());
							param_zero.put("trsp_so_seq", model.getTrspSoSeq());
							new SQLExecuter("DEFAULT").executeUpdate(new InvoiceAuditDBDAOSaveInvoiceAuditScgEtcAddAmtZeroUSQL(), param_zero,param_zero);			
							new SQLExecuter("DEFAULT").executeUpdate(new InvoiceAuditDBDAOSaveInvoiceAuditScgAmtZeroDSQL(), param_zero,param_zero);			
							
						}
						
						if( svcModel != null && !"Y".equals(svcModel.getN3ptyBilFlg())){
							Map<String, Object> param_zero = new HashMap<String, Object>();
							param_zero.put("FORM_CRE_USR_ID", searchInvAudVo.getFormCreUsrId());
							param_zero.put("FORM_USR_OFC_CD", searchInvAudVo.getFormUsrOfcCd());
							param_zero.put("trsp_so_ofc_cty_cd", model.getTrspSoOfcCtyCd());
							param_zero.put("trsp_so_seq", model.getTrspSoSeq());
							new SQLExecuter("DEFAULT").executeUpdate(new InvoiceAuditDBDAOSaveInvoiceAudit3PtyBilFlgUSQL(), param_zero,param_zero);			
							
						}					
					}
					isDelete = true;
					if (scModels != null) {
	
						Iterator itr3 = scModels.iterator();
						while (itr3.hasNext()) {
							model3 = (SurchargeVO) itr3.next();
							String unique_key = model3.getUniqueCd();
							param.clear();
							if (unique_key != null && unique_key.equals(surchargeKey)) {
									if (isDelete) {
										Map<String, Object> param_fu = new HashMap<String, Object>();
										//Substr(Cost cd, 3,2)이 'FU' 아닌 경우 Surcharge 삭제
										param_fu.put("trsp_so_ofc_cty_cd", model3.getTrspSoOfcCtyCd());
										param_fu.put("trsp_so_seq", uniqueSeq);
										new SQLExecuter("DEFAULT").executeUpdate(new InvoiceAuditDBDAOSaveInvoiceAuditScgCostCdFuDSQL(), param_fu,param_fu);			
										
										isDelete = false;
									}	
									Map<String, String> param_sch = model3.getColumnValues();
									param.putAll(param_sch);
									param.put("scg_amt", JSPUtil.removeCharacter(param_sch.get("scg_amt"),","));
									param.put("inv_scg_amt", JSPUtil.removeCharacter(param_sch.get("inv_scg_amt"),","));
									param.put("n3pty_amt", JSPUtil.removeCharacter(param_sch.get("n3pty_amt"),","));
									param.put("trsp_so_ofc_cty_cd", model3.getTrspSoOfcCtyCd());
									param.put("trsp_so_seq", uniqueSeq);
									param.put("FORM_CRE_USR_ID", searchInvAudVo.getFormCreUsrId());
									param.put("FORM_USR_OFC_CD", searchInvAudVo.getFormUsrOfcCd());
									// 금액 단위 추가
									param.put("wo_grs_wgt_meas_ut_cd", model3.getWoGrsWgtMeasUtCd());
									param.put("inv_grs_wgt_meas_ut_cd", model3.getInvGrsWgtMeasUtCd());
									
									new SQLExecuter("DEFAULT").executeUpdate(new InvoiceAuditDBDAOSaveInvoiceAuditScgCSQL(), param,param);			
									
								
								
							}
						}
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
	 * Invoice Audit List를 Confirm 상태로 DB에 저장한다.<br>
	 * 
	 * @param event EsdTrs0033Event
	 *
	 * @throws DAOException
	 */
	
	public void confirmInvoiceAudit(EsdTrs0033Event event) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
//		Collection<TrsTrspSvcOrdVO> insModels =new ArrayList<TrsTrspSvcOrdVO>();
		SearchInvoiceAuditVO searchInvAudVo = event.getSearchInvoiceAuditVO();
		String ida_ofc_yn = event.getIda_ofc_cd();
		boolean isDelete = false;
		try {
			
			
			String if_sys_knd_cd = searchInvAudVo.getIfSysKndCdParam();
			if(if_sys_knd_cd == null || "".equals(if_sys_knd_cd))
				if_sys_knd_cd = "E";
			String trsp_inv_aud_sts_cd = "CF";
			
			searchInvAudVo.setIfSysKndCd(if_sys_knd_cd);
			searchInvAudVo.setTrspInvAudStsCd(trsp_inv_aud_sts_cd);
			
			Map<String, String> param_Vo = searchInvAudVo.getColumnValues();

			param.putAll(param_Vo);
			param.put("inv_amt", JSPUtil.removeCharacter(param_Vo.get("inv_amt"),","));
			param.put("vat_amt", JSPUtil.removeCharacter(param_Vo.get("vat_amt"),","));
			param.put("wht_amt", JSPUtil.removeCharacter(param_Vo.get("wht_amt"),","));
			param.put("sbc_amt", JSPUtil.removeCharacter(param_Vo.get("sbc_amt"),","));
			param.put("tot_amt", JSPUtil.removeCharacter(param_Vo.get("tot_amt"),","));
			int updateResult = new SQLExecuter("DEFAULT").executeUpdate(new InvoiceAuditDBDAOConfirmInvoiceAuditUSQL(), param,param);			
			if(updateResult == 0){
//				int insertResult = new SQLExecuter("DEFAULT").executeUpdate(new InvoiceAuditDBDAOConfirmInvoiceAuditCSQL(), param,param);
				new SQLExecuter("DEFAULT").executeUpdate(new InvoiceAuditDBDAOConfirmInvoiceAuditCSQL(), param,param);			
			}

			Collection<InvoiceAuditVO> soModels = new ArrayList<InvoiceAuditVO>();
			Collection<SurchargeVO> scModels = new ArrayList<SurchargeVO>();
			Collection<TrsTrspSvcOrdVO> svcModels = new ArrayList<TrsTrspSvcOrdVO>();
			
			InvoiceAuditVO[] invArr = event.getInvoiceAuditVOs();
			SurchargeVO[] surArr = event.getSurchargeVOs();
			TrsTrspSvcOrdVO[] soArr = event.getTrsTrspSvcOrdVOS();
			
			for( int i=0; i<invArr.length; i++){
				soModels.add((InvoiceAuditVO)invArr[i]);
			}
			if(surArr != null ){
				for( int i=0; i<surArr.length; i++){
					scModels.add((SurchargeVO)surArr[i]);
				}
			}
			for( int i=0; i<soArr.length; i++){
				svcModels.add((TrsTrspSvcOrdVO)soArr[i]);
			}
			
			
			InvoiceAuditVO model = null;
			SurchargeVO model3 = null;
			TrsTrspSvcOrdVO svcModel = null;
			String uniqueSeq = "";
			String surchargeKey = "";
			String actStatusCd = null;
			boolean isConfirm = false;
			String invoiceCurr = searchInvAudVo.getApplyCurrency();
			
			Iterator itr = soModels.iterator();
			Iterator svcItr = svcModels.iterator();
			while (itr.hasNext()) {
				model = (InvoiceAuditVO) itr.next();
				svcModel = (TrsTrspSvcOrdVO) svcItr.next();
				uniqueSeq = model.getTrspSoSeq();
				DBRowSet checkWrkordRs = null;	
				DBRowSet selectRs = null;	
				if (svcModel != null) {
					Map<String, Object> param_chk = new HashMap<String, Object>();
					param_chk.put("trsp_so_ofc_cty_cd", svcModel.getTrspSoOfcCtyCd());
					param_chk.put("trsp_so_seq", svcModel.getTrspSoSeq());

					checkWrkordRs = new SQLExecuter("DEFAULT").executeQuery(new InvoiceAuditDBDAOSaveInvoiceAuditRSQL(), param_chk,param_chk);
					
					if( checkWrkordRs.next()){
						throw new DAOException(new ErrorHandler("TRS50103").getMessage());						
					}

					param_chk.put("invoice_no", searchInvAudVo.getInvoiceNo());
					param_chk.put("paymt_sp_cd", searchInvAudVo.getPaymtSpCd());
					
					selectRs = new SQLExecuter("DEFAULT").executeQuery(new InvoiceAuditDBDAOSaveInvoiceAuditNotInvNoRSQL(), param_chk,param_chk);
					
					if( selectRs.next()){
						throw new DAOException(new ErrorHandler("TRS00100").getMessage());						
					}					
				}			
				
				
				if (model.getTrspInvActStsCd() != null && model.getTrspInvActStsCd().equals("C"))
					isConfirm = true;
				else
					isConfirm = false;
				
				param.clear();
				
				if( svcModel != null ){
					TrsTrspSvcOrdVO svcModel_copy = (TrsTrspSvcOrdVO)svcModel.clone();
					if (model.getIbflag().length() > 0) {
						surchargeKey = model.getTrspSoSeq(); // getSurcharge_key();
						actStatusCd = model.getTrspInvActStsCd();
	
						// confirm 건 처리
						if (actStatusCd != null && actStatusCd.equals("C")) {						
			
							svcModel_copy.setEqNo(model.getEqNo());
							if( svcModel != null ){
								if( svcModel_copy.getEqTpszCd() == null || "".equals(svcModel.getEqTpszCd()) ){
									svcModel_copy.setEqTpszCd(model.getEqTpszCd());
								}
							}
							svcModel_copy.setTrspInvActStsCd(model.getTrspInvActStsCd());
							svcModel_copy.setInvCurrCd(searchInvAudVo.getApplyCurrency());
							svcModel_copy.setTrspSoOfcCtyCd(model.getTrspSoOfcCtyCd());
							svcModel_copy.setTrspSoSeq(model.getTrspSoSeq());
							Map<String, String> param_so = svcModel_copy.getColumnValues();
							if (isConfirm) {
								param.put("invoice_no", searchInvAudVo.getInvoiceNo());
								param.put("paymt_sp_cd", searchInvAudVo.getPaymtSpCd());
							}else{
								param.put("invoice_no", null);
								param.put("paymt_sp_cd", null);
							}
							param.put("FORM_CRE_USR_ID", searchInvAudVo.getFormCreUsrId());
							param.put("FORM_USR_OFC_CD", event.getFORM_USR_OFC_CD());
							param.putAll(param_so);
							param.put("apply_currency", invoiceCurr);		
							param.put("inv_bzc_amt", JSPUtil.removeCharacter(param_so.get("inv_bzc_amt"),","));
							param.put("inv_etc_add_amt", JSPUtil.removeCharacter(param_so.get("inv_etc_add_amt"),","));
							
							new SQLExecuter("DEFAULT").executeUpdate(new InvoiceAuditDBDAOConfirmInvoiceAuditSoUSQL(), param,param);
							if ("Y".equals(ida_ofc_yn)) {
								new SQLExecuter("DEFAULT").executeUpdate(new InvoiceAuditDAOSaveIdaGstMergeCSQL(), param,param);
							}
						
						}else{
							param.put("FORM_CRE_USR_ID", searchInvAudVo.getFormCreUsrId());
							param.put("FORM_USR_OFC_CD", event.getFORM_USR_OFC_CD());
							param.put("trsp_so_ofc_cty_cd",model.getTrspSoOfcCtyCd());
							param.put("trsp_so_seq", model.getTrspSoSeq());
							new SQLExecuter("DEFAULT").executeUpdate(new InvoiceAuditDBDAOConfirmInvoiceAuditSoDelUSQL(), param,param);			
							if ("Y".equals(ida_ofc_yn)) {
								new SQLExecuter("DEFAULT").executeUpdate(new InvoiceAuditDAOSaveIdaGstMergeCSQL(), param,param);
							}
						}							
								
								
						if(!model.getInvEtcAddAmt().equals("") && Double.parseDouble(JSPUtil.removeCharacter(model.getInvEtcAddAmt(), ","))==0){
							Map<String, Object> param_zero = new HashMap<String, Object>();
							param_zero.put("FORM_CRE_USR_ID", searchInvAudVo.getFormCreUsrId());
							param_zero.put("FORM_USR_OFC_CD", searchInvAudVo.getFormUsrOfcCd());
							param_zero.put("trsp_so_ofc_cty_cd", model.getTrspSoOfcCtyCd());
							param_zero.put("trsp_so_seq", model.getTrspSoSeq());
							new SQLExecuter("DEFAULT").executeUpdate(new InvoiceAuditDBDAOSaveInvoiceAuditScgEtcAddAmtZeroUSQL(), param_zero,param_zero);			
							new SQLExecuter("DEFAULT").executeUpdate(new InvoiceAuditDBDAOSaveInvoiceAuditScgAmtZeroDSQL(), param_zero,param_zero);			
							
						}
						
						if( svcModel != null && !svcModel.getN3ptyBilFlg().equals("Y")){
							Map<String, Object> param_zero = new HashMap<String, Object>();
							param_zero.put("FORM_CRE_USR_ID", searchInvAudVo.getFormCreUsrId());
							param_zero.put("FORM_USR_OFC_CD", searchInvAudVo.getFormUsrOfcCd());
							param_zero.put("trsp_so_ofc_cty_cd", model.getTrspSoOfcCtyCd());
							param_zero.put("trsp_so_seq", model.getTrspSoSeq());
							new SQLExecuter("DEFAULT").executeUpdate(new InvoiceAuditDBDAOSaveInvoiceAudit3PtyBilFlgUSQL(), param_zero,param_zero);			
							
						}
						
					}
					isDelete = true;
					if (scModels != null) {
						Iterator itr3 = scModels.iterator();
						while (itr3.hasNext()) {
							model3 = (SurchargeVO) itr3.next();
							String unique_key = model3.getUniqueCd();
							param.clear();
							if (unique_key != null && unique_key.equals(surchargeKey)) {
								if (isConfirm == true && isDelete == true){
									Map<String, Object> param_fu = new HashMap<String, Object>();
									//Substr(Cost cd, 3,2)이 'FU' 아닌 경우 Surcharge 삭제
									param_fu.put("trsp_so_ofc_cty_cd", model3.getTrspSoOfcCtyCd());
									param_fu.put("trsp_so_seq", uniqueSeq);
									new SQLExecuter("DEFAULT").executeUpdate(new InvoiceAuditDBDAOSaveInvoiceAuditScgCostCdFuDSQL(), param_fu,param_fu);			
									isDelete = false;
								}
								
								if(isConfirm){
									Map<String, String> param_sch = model3.getColumnValues();
									param.putAll(param_sch);
									param.put("scg_amt", JSPUtil.removeCharacter(param_sch.get("scg_amt"),","));
									param.put("inv_scg_amt", JSPUtil.removeCharacter(param_sch.get("inv_scg_amt"),","));
									param.put("n3pty_amt", JSPUtil.removeCharacter(param_sch.get("n3pty_amt"),","));
									param.put("trsp_so_ofc_cty_cd", model.getTrspSoOfcCtyCd());
									param.put("trsp_so_seq", uniqueSeq);
									param.put("FORM_CRE_USR_ID", searchInvAudVo.getFormCreUsrId());
									param.put("FORM_USR_OFC_CD", searchInvAudVo.getFormUsrOfcCd());
									
									new SQLExecuter("DEFAULT").executeUpdate(new InvoiceAuditDBDAOSaveInvoiceAuditScgCSQL(), param,param);								
																	
								}							
							}
						}
					}
					param.clear();
					if( svcModel != null && svcModel.getN3ptyBilFlg().equals("Y")){
	
						param.put("FORM_CRE_USR_ID", searchInvAudVo.getFormCreUsrId());
						param.put("FORM_USR_OFC_CD", searchInvAudVo.getFormUsrOfcCd());
						param.put("trsp_so_ofc_cty_cd", model.getTrspSoOfcCtyCd());
						param.put("trsp_so_seq", model.getTrspSoSeq());
						new SQLExecuter("DEFAULT").executeUpdate(new InvoiceAuditDBDAOConfirmInvoiceAuditThirdPartyIfScgCSQL(), param,param);			
						new SQLExecuter("DEFAULT").executeUpdate(new InvoiceAuditDBDAOConfirmInvoiceAuditThirdPartyIfCSQL(), param,param);			
						
					}
				}
			}
			
			// INV_SBC_AMT UPDATE
			param.clear();
			param.putAll(param_Vo);
			param.put("inv_amt", JSPUtil.removeCharacter(param_Vo.get("inv_amt"),","));
			param.put("vat_amt", JSPUtil.removeCharacter(param_Vo.get("vat_amt"),","));
			param.put("wht_amt", JSPUtil.removeCharacter(param_Vo.get("wht_amt"),","));
			param.put("sbc_amt", JSPUtil.removeCharacter(param_Vo.get("sbc_amt"),","));
			param.put("tot_amt", JSPUtil.removeCharacter(param_Vo.get("tot_amt"),","));

			new SQLExecuter("DEFAULT").executeUpdate(new InvoiceAuditDBDAOConfirmInvoiceAuditSbcUSQL(), param, param);			
			
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
	 * Invoice confirm 생성 및 수정
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void confirmInvoiceAuditForMain(EsdTrs0033Event event) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		SearchInvoiceAuditVO searchInvAudVo = event.getSearchInvoiceAuditVO();	
		try {
			
			
			String if_sys_knd_cd = searchInvAudVo.getIfSysKndCdParam();
			if(if_sys_knd_cd == null || "".equals(if_sys_knd_cd))
				if_sys_knd_cd = "E";
			String trsp_inv_aud_sts_cd = "CF";
			
			searchInvAudVo.setIfSysKndCd(if_sys_knd_cd);
			searchInvAudVo.setTrspInvAudStsCd(trsp_inv_aud_sts_cd);
			
			Map<String, String> param_Vo = searchInvAudVo.getColumnValues();

			param.putAll(param_Vo);

			int updateResult = new SQLExecuter("DEFAULT").executeUpdate(new InvoiceAuditDBDAOConfirmInvoiceAuditUSQL(), param,param);			
						
			if(updateResult == 0){
//				int insertResult = new SQLExecuter("DEFAULT").executeUpdate(new InvoiceAuditDBDAOConfirmInvoiceAuditCSQL(), param,param);			
				new SQLExecuter("DEFAULT").executeUpdate(new InvoiceAuditDBDAOConfirmInvoiceAuditCSQL(), param,param);			
						
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
	 * Invoice Confirm 처리한다.<br>
	 * 
	 * @param event
	 * @param h
	 * @throws DAOException
	 */
	public void confirmInvoiceAuditForSvcOrd(EsdTrs0033Event event, int h) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
//		Collection<TrsTrspSvcOrdVO> insModels =new ArrayList<TrsTrspSvcOrdVO>();
		SearchInvoiceAuditVO searchInvAudVo = event.getSearchInvoiceAuditVO();	
		String if_sys_knd_cd = null;
		try {
			
			
			if_sys_knd_cd = searchInvAudVo.getIfSysKndCdParam();
			if(if_sys_knd_cd == null || "".equals(if_sys_knd_cd))
				if_sys_knd_cd = "E";
			
			searchInvAudVo.setIfSysKndCd(if_sys_knd_cd);
			
			ArrayList<InvoiceAuditVO> soModels = new ArrayList<InvoiceAuditVO>();
			ArrayList<SurchargeVO> scModels = new ArrayList<SurchargeVO>();
			ArrayList<TrsTrspSvcOrdVO> svcModels = new ArrayList<TrsTrspSvcOrdVO>();
			
			InvoiceAuditVO[] invArr = event.getInvoiceAuditVOs();
			SurchargeVO[] surArr = event.getSurchargeVOs();
			TrsTrspSvcOrdVO[] soArr = event.getTrsTrspSvcOrdVOS();
			
			for( int j=0; j<invArr.length; j++){
				soModels.add((InvoiceAuditVO)invArr[j]);
			}
			if(surArr != null ){
				for( int j=0; j<surArr.length; j++){
					scModels.add((SurchargeVO)surArr[j]);
				}
			}
			for( int j=0; j<soArr.length; j++){
				svcModels.add((TrsTrspSvcOrdVO)soArr[j]);
			}
			
			
			InvoiceAuditVO model = null;
			SurchargeVO model3 = null;
			TrsTrspSvcOrdVO svcModel = null;
			String uniqueSeq = "";
			String surchargeKey = "";
			String actStatusCd = null;
			boolean isConfirm = false;
			

			model = (InvoiceAuditVO) soModels.get(h);
			svcModel = (TrsTrspSvcOrdVO) svcModels.get(h);
			uniqueSeq = model.getTrspSoSeq();
			
			if (model.getTrspInvActStsCd() != null && model.getTrspInvActStsCd().equals("C"))
				isConfirm = true;
			else
				isConfirm = false;

		

			TrsTrspSvcOrdVO svcModel_copy = (TrsTrspSvcOrdVO)svcModel.clone();
			if (model.getIbflag().length() > 0) {
				surchargeKey = model.getTrspSoSeq(); // getSurcharge_key();
				actStatusCd = model.getTrspInvActStsCd();

				// confirm 건 처리
				if (actStatusCd != null && actStatusCd.equals("C")) {						
	
					svcModel_copy.setEqNo(model.getEqNo());
					if( svcModel_copy.getEqTpszCd() == null || "".equals(svcModel.getEqTpszCd()) )
						svcModel_copy.setEqTpszCd(model.getEqTpszCd());  
					svcModel_copy.setTrspInvActStsCd(model.getTrspInvActStsCd());
					svcModel_copy.setInvCurrCd(searchInvAudVo.getApplyCurrency());
					svcModel_copy.setTrspSoOfcCtyCd(model.getTrspSoOfcCtyCd());
					svcModel_copy.setTrspSoSeq(model.getTrspSoSeq());
					Map<String, String> param_so = svcModel_copy.getColumnValues();
					if (isConfirm) {
						param.put("invoice_no", searchInvAudVo.getInvoiceNo());
						param.put("paymt_sp_cd", searchInvAudVo.getPaymtSpCd());
					}else{
						param.put("invoice_no", null);
						param.put("paymt_sp_cd", null);
					}
					param.put("FORM_CRE_USR_ID", searchInvAudVo.getFormCreUsrId());
					param.put("FORM_USR_OFC_CD", event.getFORM_USR_OFC_CD());
					param.putAll(param_so);
					param.put("apply_currency", searchInvAudVo.getApplyCurrency());					
					param.put("inv_bzc_amt", JSPUtil.removeCharacter(param_so.get("inv_bzc_amt"),","));
					param.put("inv_etc_add_amt", JSPUtil.removeCharacter(param_so.get("inv_etc_add_amt"),","));
					
					
					new SQLExecuter("DEFAULT").executeUpdate(new InvoiceAuditDBDAOConfirmInvoiceAuditSoUSQL(), param,param);			
				
				}else{
					param.put("FORM_CRE_USR_ID", searchInvAudVo.getFormCreUsrId());
					param.put("FORM_USR_OFC_CD", event.getFORM_USR_OFC_CD());
					param.put("trsp_so_ofc_cty_cd",model.getTrspSoOfcCtyCd());
					param.put("trsp_so_seq", model.getTrspSoSeq());
					new SQLExecuter("DEFAULT").executeUpdate(new InvoiceAuditDBDAOConfirmInvoiceAuditSoDelUSQL(), param,param);			
					
				}							
						
						
				if(!model.getInvEtcAddAmt().equals("") && Double.parseDouble(JSPUtil.removeCharacter(model.getInvEtcAddAmt(), ","))==0){
					Map<String, Object> param_zero = new HashMap<String, Object>();
					param_zero.put("FORM_CRE_USR_ID", searchInvAudVo.getFormCreUsrId());
					param_zero.put("FORM_USR_OFC_CD", searchInvAudVo.getFormUsrOfcCd());
					param_zero.put("trsp_so_ofc_cty_cd", model.getTrspSoOfcCtyCd());
					param_zero.put("trsp_so_seq", model.getTrspSoSeq());
					new SQLExecuter("DEFAULT").executeUpdate(new InvoiceAuditDBDAOSaveInvoiceAuditScgEtcAddAmtZeroUSQL(), param_zero,param_zero);			
					new SQLExecuter("DEFAULT").executeUpdate(new InvoiceAuditDBDAOSaveInvoiceAuditScgAmtZeroDSQL(), param_zero,param_zero);			
					
				}
				
				if(!svcModel.getN3ptyBilFlg().equals("Y")){
					Map<String, Object> param_zero = new HashMap<String, Object>();
					param_zero.put("FORM_CRE_USR_ID", searchInvAudVo.getFormCreUsrId());
					param_zero.put("FORM_USR_OFC_CD", searchInvAudVo.getFormUsrOfcCd());
					param_zero.put("trsp_so_ofc_cty_cd", model.getTrspSoOfcCtyCd());
					param_zero.put("trsp_so_seq", model.getTrspSoSeq());
					new SQLExecuter("DEFAULT").executeUpdate(new InvoiceAuditDBDAOSaveInvoiceAudit3PtyBilFlgUSQL(), param_zero,param_zero);			
					
				}
				
			}
			if (scModels != null) {
				Iterator itr3 = scModels.iterator();
				while (itr3.hasNext()) {
					model3 = (SurchargeVO) itr3.next();
					String unique_key = model3.getUniqueCd();
					param.clear();
					if (unique_key != null && unique_key.equals(surchargeKey)) {
						if (isConfirm == true){
							Map<String, Object> param_fu = new HashMap<String, Object>();
							//Substr(Cost cd, 3,2)이 'FU' 아닌 경우 Surcharge 삭제
							param_fu.put("trsp_so_ofc_cty_cd", model3.getTrspSoOfcCtyCd());
							param_fu.put("trsp_so_seq", uniqueSeq);
							new SQLExecuter("DEFAULT").executeUpdate(new InvoiceAuditDBDAOSaveInvoiceAuditScgCostCdFuDSQL(), param_fu,param_fu);			
							
						}
						
						if(isConfirm){
							Map<String, String> param_sch = model3.getColumnValues();
							param.putAll(param_sch);
							param.put("scg_amt", JSPUtil.removeCharacter(param_sch.get("scg_amt"),","));
							param.put("inv_scg_amt", JSPUtil.removeCharacter(param_sch.get("inv_scg_amt"),","));
							param.put("n3pty_amt", JSPUtil.removeCharacter(param_sch.get("n3pty_amt"),","));							
							param.put("trsp_so_ofc_cty_cd", model.getTrspSoOfcCtyCd());
							param.put("trsp_so_seq", uniqueSeq);
							param.put("FORM_CRE_USR_ID", searchInvAudVo.getFormCreUsrId());
							param.put("FORM_USR_OFC_CD", searchInvAudVo.getFormUsrOfcCd());
							
							new SQLExecuter("DEFAULT").executeUpdate(new InvoiceAuditDBDAOSaveInvoiceAuditScgCSQL(), param,param);								
															
						}							
					}
				}
			}
			param.clear();
			if(svcModel.getN3ptyBilFlg().equals("Y")){

				param.put("FORM_CRE_USR_ID", searchInvAudVo.getFormCreUsrId());
				param.put("FORM_USR_OFC_CD", searchInvAudVo.getFormUsrOfcCd());
				param.put("trsp_so_ofc_cty_cd", model.getTrspSoOfcCtyCd());
				param.put("trsp_so_seq", model.getTrspSoSeq());
				new SQLExecuter("DEFAULT").executeUpdate(new InvoiceAuditDBDAOConfirmInvoiceAuditThirdPartyIfScgCSQL(), param,param);			
				new SQLExecuter("DEFAULT").executeUpdate(new InvoiceAuditDBDAOConfirmInvoiceAuditThirdPartyIfCSQL(), param,param);			
				
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
	 * WO issue , Invoice 처리 안된 데이터인지 체크.<br>
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void checkConfirmInvoice(EsdTrs0033Event event) throws DAOException {
		
		SearchInvoiceAuditVO searchInvAudVo = event.getSearchInvoiceAuditVO();
		Collection<InvoiceAuditVO> soModels = new ArrayList<InvoiceAuditVO>();
		Collection<TrsTrspSvcOrdVO> svcModels = new ArrayList<TrsTrspSvcOrdVO>();
		try{
		
			InvoiceAuditVO[] invArr = event.getInvoiceAuditVOs();

			TrsTrspSvcOrdVO[] soArr = event.getTrsTrspSvcOrdVOS();
			
			for( int i=0; i<invArr.length; i++){
				soModels.add((InvoiceAuditVO)invArr[i]);
			}
			
			for( int i=0; i<soArr.length; i++){
				svcModels.add((TrsTrspSvcOrdVO)soArr[i]);
			}			
			
			TrsTrspSvcOrdVO svcModel = null;

			
			Iterator itr = soModels.iterator();
			Iterator svcItr = svcModels.iterator();
			while (itr.hasNext()) {

				svcModel = (TrsTrspSvcOrdVO) svcItr.next();
				DBRowSet checkWrkordRs = null;	
				DBRowSet selectRs = null;	
				if (svcModel != null) {
					Map<String, Object> param_chk = new HashMap<String, Object>();
					param_chk.put("trsp_so_ofc_cty_cd", svcModel.getTrspSoOfcCtyCd());
					param_chk.put("trsp_so_seq", svcModel.getTrspSoSeq());
	
					checkWrkordRs = new SQLExecuter("DEFAULT").executeQuery(new InvoiceAuditDBDAOSaveInvoiceAuditRSQL(), param_chk,param_chk);
					
					if( checkWrkordRs.next()){
						throw new DAOException(new ErrorHandler("TRS50103").getMessage());						
					}
	
					param_chk.put("invoice_no", searchInvAudVo.getInvoiceNo());
					param_chk.put("paymt_sp_cd", searchInvAudVo.getPaymtSpCd());
					
					selectRs = new SQLExecuter("DEFAULT").executeQuery(new InvoiceAuditDBDAOSaveInvoiceAuditNotInvNoRSQL(), param_chk,param_chk);
					
					if( selectRs.next()){
						throw new DAOException(new ErrorHandler("TRS00100").getMessage());						
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
	 * Invoice 상태를 Save 상태로 Rollback.<br>
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void rollbackInvoiceAuditForMain(EsdTrs0033Event event) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		SearchInvoiceAuditVO searchInvAudVo = event.getSearchInvoiceAuditVO();	
		try {
			
			
			String trsp_inv_aud_sts_cd = "SV";
			searchInvAudVo.setTrspInvAudStsCd(trsp_inv_aud_sts_cd);
			
			Map<String, String> param_Vo = searchInvAudVo.getColumnValues();
			
			param.put("FORM_CRE_USR_ID", searchInvAudVo.getFormCreUsrId());
			param.put("FORM_USR_OFC_CD", searchInvAudVo.getFormUsrOfcCd());
			param.putAll(param_Vo);

			new SQLExecuter("DEFAULT").executeUpdate(new InvoiceAuditDBDAORollbackInvoiceAuditForMainUSQL(), param,param);			
						
			
		
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
	 * EQ 정보 조회<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet[] verifyEqNo(EsdTrs0033Event event) throws DAOException {
		
		DBRowSet[] dRs = null;	
		Map<String, Object> param = new HashMap<String, Object>();
		TrsTrspSvcOrdVO[] models = event.getTrsTrspSvcOrdVOS();

		try {
			
			dRs = new DBRowSet[models.length];

			for( int i=0; i< models.length; i++){
				param.put("eq_no", models[i].getEqNo());
				
				dRs[i] = new SQLExecuter("DEFAULT").executeQuery(new InvoiceAuditDBDAOVerifyEqNoRSQL(), param,param);				

			}
			
			
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
	 * EQ 정보의 타입사이즈 조회<br>
	 * 
	 * @param eqNo
	 * @return
	 * @throws DAOException
	 */
	public String verifyEqNo(String eqNo) throws DAOException {
		DBRowSet dRs = null;		
		Map<String, Object> param = new HashMap<String, Object>();
		String eq_tpsz_cd = null;
		
		try {
			
			param.put("eq_no", eqNo);
			dRs = new SQLExecuter("DEFAULT").executeQuery(new InvoiceAuditDBDAOVerifyEqNoRSQL(), param,param);
			
			while( dRs.next()){
				eq_tpsz_cd = dRs.getString("TP_CD");
			}

			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		
		return eq_tpsz_cd;
		
	}


	/**
	 * Invoice Audit for Refund의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void multiTRS_TRSP_RFND_INV(EsdTrs0040Event event) throws DAOException {		

		Map<String, Object> param = new HashMap<String, Object>();
		
		Collection<TrsTrspRfndInvVO> insModels =new ArrayList<TrsTrspRfndInvVO>();
		
		TrsTrspRfndInvVO[] trsTrspRfndInvVOs = event.getTrsTrspRfndInvVOs();
		
		try {
			if("true".equals(event.getInsflag())){
				event.getInv_no();
				param.put("inv_no", event.getInv_no());
				param.put("paymt_sp_cd", event.getPaymt_sp_cd());
				param.put("combo_svc_provider", event.getCombo_svc_provider());
				param.put("inv_curr_cd", event.getInv_curr_cd());
				param.put("inv_bzc_amt", JSPUtil.getNull(event.getInv_bzc_amt().replaceAll(",", "")));
				param.put("inv_vat_amt", JSPUtil.getNull(event.getInv_vat_amt().replaceAll(",", "")));
				param.put("inv_ttl_amt", JSPUtil.getNull(event.getInv_ttl_amt().replaceAll(",", "")));
				param.put("usr_id", event.getUsr_id());
				param.put("ofc_cd", event.getOfc_cd());
				param.put("inv_rcv_dt", JSPUtil.getNull(event.getInv_rcv_dt()));
				param.put("inv_iss_dt", JSPUtil.getNull(event.getInv_iss_dt()));
				param.put("inv_whld_tax_amt", JSPUtil.getNull(event.getInv_whld_tax_amt().replaceAll(",", "")));
				
				new SQLExecuter("DEFAULT").executeUpdate(new InvoiceAuditDBDAOMultiTrsTrspRfndInvWrkCSQL(), param,param);			
				
			}

			for(int i=0;i<trsTrspRfndInvVOs.length;i++){
				if (trsTrspRfndInvVOs[i].getIbflag().equals("I")) {
					insModels.add(trsTrspRfndInvVOs[i]);
				}
			}
						
			int[] insCnt = null;
			Map<String,Object> param_wrk = new HashMap<String,Object>();
			if(insModels.size()>0){
				
				param_wrk.put("inv_no", event.getInv_no());
				param_wrk.put("paymt_sp_cd", event.getPaymt_sp_cd());
				param_wrk.put("usr_id", event.getUsr_id());
				param_wrk.put("ofc_cd", event.getOfc_cd());
				param_wrk.put("inv_whld_tax_amt", JSPUtil.getNull(event.getInv_whld_tax_amt().replaceAll(",", "")));
				param_wrk.put("inv_curr_cd", event.getInv_curr_cd());

				insCnt = new SQLExecuter("DEFAULT").executeBatch(new InvoiceAuditDBDAOMultiTrsTrspRfndInvCSQL(), insModels, param_wrk, param_wrk);
			 				
			}
			
			if(insCnt != null){
				for(int i=0;i<insCnt.length;i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
						
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
	 * WO SP의 PARENTS SP를 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchPaymentVnder(EsdTrs0040Event event) throws DAOException {

		DBRowSet dRs = null;		
		Map<String, Object> param = new HashMap<String, Object>();

		String combo_svc_provider = event.getCombo_svc_provider();
		
		
		try {
			
			if(!"".equals(combo_svc_provider) && combo_svc_provider != null ){
				param.put("combo_svc_provider", combo_svc_provider);
				dRs = new SQLExecuter("DEFAULT").executeQuery(new InvoiceAuditDBDAOSearchPaymentVnderRSQL(), param,param);
			}

			
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
	 * WO SP의 PaymentChildVnder 를 가져온다.<br>
	 * 
	 * @param vndrSeq
	 * @return
	 * @throws DAOException
	 */
	public ArrayList searchPaymentChildVnder(String vndrSeq) throws DAOException {
		DBRowSet dRs = null;		
		Map<String, Object> param = new HashMap<String, Object>();
		ArrayList<String>  dRsList = new ArrayList<String>();
		
		try {			
			
				param.put("vndr_seq", vndrSeq);
				dRs = new SQLExecuter("DEFAULT").executeQuery(new InvoiceAuditDBDAOSearchPaymentChildVnderRSQL(), param,param);
				while(dRs.next()){	
					dRsList.add(dRs.getString("VNDR_SEQ"));
				}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		
		return dRsList;
		
	}

	/**
	 * Invoice No와 vendor로 Invoice No 존재 유무 조회.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchInvoiceNo(EsdTrs0040Event event) throws DAOException {
		
		DBRowSet dRs = null;		
		Map<String, Object> param = new HashMap<String, Object>();

		
		try {			
			
				param.put("inv_no", event.getInv_no());
				param.put("combo_svc_provider", event.getCombo_svc_provider());
				dRs = new SQLExecuter("DEFAULT").executeQuery(new InvoiceAuditDBDAOSearchInvoiceNoRSQL(), param,param);
			
			
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
	 * Refund List.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchRefundList(EsdTrs0040Event event) throws DAOException {
		
		DBRowSet dRs = null;		
		Map<String, Object> param = new HashMap<String, Object>();

		
		try {			
			
				param.put("inv_no", event.getInv_no());
				param.put("combo_svc_provider", event.getCombo_svc_provider());
				dRs = new SQLExecuter("DEFAULT").executeQuery(new InvoiceAuditDBDAOSearchRefundListRSQL(), param,param);
			
			
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
	 * Office의 Bill Currency Cd를 조회한다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchMdmOrganization(EsdTrs0033Event event) throws DAOException {
		
		DBRowSet dRs = null;		
		Map<String, Object> param = new HashMap<String, Object>();
		SearchInvoiceAuditVO siav = event.getSearchInvoiceAuditVO();
		
		try {
			param.put("ofc_cd", siav.getFormUsrOfcCd());
			dRs = new SQLExecuter("DEFAULT").executeQuery(new InvoiceAuditDBDAOSearchMdmOrganizationRSQL(), param,param);
			

			
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
	 * 기존 저장된 3rd party billing currency를 가져온다.<br>
	 * 
	 * @param event EsdTrs0033Event
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchN3ptyCurrCd(EsdTrs0033Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			
			String trspSoOfcCtyCd = event.getTrspSoOfcCtyCd();
			String trspSoSeq = event.getTrspSoSeq();
			
			param.put("TrspSoOfcCtyCd", trspSoOfcCtyCd);
			param.put("TrspSoSeq", trspSoSeq);
			
			dRs = new SQLExecuter("DEFAULT").executeQuery(new InvoiceAuditDBDAOSearchN3ptyCurrCdRSQL(), param,param);
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
	 * Currency 환률을 계산한다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet calculateExchangeRate(EsdTrs0033Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {					
			param.put("trsp_so_ofc_cty_cd", JSPUtil.getNull(event.getTrspSoOfcCtyCd()));
			param.put("trsp_so_seq", JSPUtil.getNull(event.getTrspSoSeq()));
			param.put("trsp_inv_calc_lgc_tp_cd", JSPUtil.getNull(event.getTrspInvCalcLgcTpCd()));
			param.put("inv_xch_rt", JSPUtil.getNull(event.getInvXchRt()));
			dRs = new SQLExecuter("DEFAULT").executeQuery(new InvoiceAuditDBDAOCalculateExchangeRateRSQL(), param,param);
			
			
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
	 * invoice 리스트 가져오기<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public ArrayList searchInvoiceImportSO(EsdTrs0033Event event) throws DAOException {
	
		Map<String, Object> param = new HashMap<String, Object>();
		ArrayList<DBRowSet>  dRsList = new ArrayList<DBRowSet>();
		TrsTrspSvcOrdVO[] soArr = event.getTrsTrspSvcOrdVOS();
		SearchInvoiceAuditVO siav = event.getSearchInvoiceAuditVO();
		try {
			
			if(soArr != null ){
				for(int i=0; i<soArr.length; i++){
					DBRowSet dRs = new DBRowSet();
					if(!soArr[i].getTrspSoSeq().equals("") && soArr[i].getDtnUseFlg().equals("1")){
						param.put("trsp_so_ofc_cty_cd", soArr[i].getTrspSoOfcCtyCd());
						param.put("trsp_so_seq", soArr[i].getTrspSoSeq());
						param.put("FORM_USR_OFC_CD", siav.getFormUsrOfcCd());
						dRs = new SQLExecuter("DEFAULT").executeQuery(new InvoiceAuditDBDAOSearchInvoiceImportSoRSQL(), param,param);
						
					}
					dRsList.add(dRs);
				}
			}

			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		
		return dRsList;
	}
	
	/**
	 * invoice 리스트 가져오기<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public ArrayList searchInvoiceImportWO(EsdTrs0033Event event) throws DAOException {	
		Map<String, Object> param = new HashMap<String, Object>();
		ArrayList<DBRowSet>  dRsList = new ArrayList<DBRowSet>();
		TrsTrspSvcOrdVO[] soArr = event.getTrsTrspSvcOrdVOS();
		SearchInvoiceAuditVO siav = event.getSearchInvoiceAuditVO();
		try {
			
			if(soArr != null ){
				for(int i=0; i<soArr.length; i++){
					DBRowSet dRs = new DBRowSet();
					if(soArr[i].getTrspWoSeq() != null && !soArr[i].getTrspWoSeq().equals("") && soArr[i].getDtnUseFlg().equals("1")){
						
						param.put("trsp_wo_ofc_cty_cd", soArr[i].getTrspWoOfcCtyCd());
						param.put("trsp_wo_seq", soArr[i].getTrspWoSeq());
						param.put("eq_no", soArr[i].getEqNo());
						param.put("FORM_USR_OFC_CD", siav.getFormUsrOfcCd());
						dRs = new SQLExecuter("DEFAULT").executeQuery(new InvoiceAuditDBDAOSearchInvoiceImportWoRSQL(), param,param);
						
					}
					dRsList.add(dRs);
				}
			}

			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		
		return dRsList;
	}
	
	/**
	 * EQ_NO가 비어있는 WO리스트를 중복되지 않게 조회하여 가져오기<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public ArrayList searchInvoiceImportEmptyWO(EsdTrs0033Event event) throws DAOException {
			
		Map<String, Object> param = new HashMap<String, Object>();
		//ArrayList  dRsList = new ArrayList();
		TrsTrspSvcOrdVO[] soArr = event.getTrsTrspSvcOrdVOS();
		SearchInvoiceAuditVO siav = event.getSearchInvoiceAuditVO();
		String woOfcCtyCd = null;
		String woOfcSeq = null;
		ArrayList<String> emptyWoList = new ArrayList<String>();
		List<TrsTrspSvcOrdVO> dRsList = null;
		try {
			
			if(soArr != null ){
				for(int i=0; i<soArr.length; i++){
					woOfcCtyCd = JSPUtil.getNull(soArr[i].getTrspWoOfcCtyCd());
					woOfcSeq = JSPUtil.getNull(soArr[i].getTrspWoSeq());
					
					if(!woOfcSeq.equals("") && !contains(emptyWoList, woOfcCtyCd+woOfcSeq)
							&& soArr[i].getDtnUseFlg().equals("1")){
						DBRowSet dRs = new DBRowSet();	
						param.put("trsp_wo_ofc_cty_cd", soArr[i].getTrspWoOfcCtyCd());
						param.put("trsp_wo_seq", soArr[i].getTrspWoSeq());
						param.put("FORM_USR_OFC_CD", siav.getFormUsrOfcCd());
						dRs = new SQLExecuter("DEFAULT").executeQuery(new InvoiceAuditDBDAOSearchInvoiceImportEmptyWoRSQL(), param,param);
						List<TrsTrspSvcOrdVO> listTemp = (List)RowSetUtil.rowSetToVOs(dRs, TrsTrspSvcOrdVO.class);
						if(dRsList == null){
							dRsList = listTemp;
						}else{
							dRsList.addAll(listTemp);
						}
						emptyWoList.add(woOfcCtyCd+woOfcSeq);
					}
				}
			}

			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		
		return (ArrayList)dRsList;
	}
	
	
	
	/**
	 * searchInvoiceImportDuplicateCheckByDate<br>
	 * data에 의한 중복체크 처리 +- 2일 <br>
	 * 
	 * @param model TrsTrspSvcOrdVO
	 * @return ArrayList
	 * @exception DAOException
	 */
	public ArrayList searchInvoiceImportDuplicateCheckByDate(TrsTrspSvcOrdVO model) throws DAOException {
		DBRowSet dRs = null;		
		Map<String, Object> param = new HashMap<String, Object>();
		List<TrsTrspSvcOrdVO> dRsList = null;
		
		try {
			
			if(model != null ){
				param.put("eq_no", model.getEqNo());
				param.put("cre_dt", model.getCreDt());
				param.put("fm_nod_cd", model.getFmNodCd());
				dRs = new SQLExecuter("DEFAULT").executeQuery(new InvoiceAuditDBDAOSearchInvoiceImportDuplicateCheckByDate2RSQL(), param,param);
				List<TrsTrspSvcOrdVO> listTemp = (List)RowSetUtil.rowSetToVOs(dRs, TrsTrspSvcOrdVO.class);
				if(dRsList == null){
					dRsList = listTemp;
				}else{
					dRsList.addAll(listTemp);
				}
			}

			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		
		return (ArrayList)dRsList;
	}
	
		
	/**
	 * S/O Creation 날짜 기준으로 Invoice 중복여부를 조회<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public List searchInvoiceImportDuplicateCheckByDate2(EsdTrs0033Event event) throws DAOException {
		
			
		Map<String, Object> param = new HashMap<String, Object>();
		TrsTrspSvcOrdVO[] modelArr = event.getTrsTrspSvcOrdVOS();
		//ArrayList<TrsTrspSvcOrdVO> models	=  (ArrayList<TrsTrspSvcOrdVO>) event.getTrsTrspSvcOrdVoList();
		TrsTrspSvcOrdVO soVo = null;
		ArrayList resultLists = new ArrayList();
		List<AbstractValueObject> dupList = null;
				
		try {

			for( int i=0; modelArr != null && i< modelArr.length; i++ ){
				soVo	= (TrsTrspSvcOrdVO)modelArr[i];
				//soVo						= (TrsTrspSvcOrdVO) models.get(i);
				param.put("eq_no", soVo.getEqNo());
				param.put("cre_dt", soVo.getCreDt());
				param.put("fm_nod_cd", soVo.getFmNodCd());
				param.put("ref_seq", soVo.getRefSeq());
				dupList = new SQLExecuter("DEFAULT").executeQuery(new InvoiceAuditDBDAOSearchInvoiceImportDuplicateCheckByDate2RSQL(), param,param, TrsTrspSvcOrdVO.class);
				
				if( dupList != null && dupList.size()>0 )
					resultLists.add(dupList);	
				
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		
		return (List)resultLists;
		
	
		
	}
		
		
		
	
	/**
	 * bkg_no와 EQ가 mapping이 되어있는 컨테이너를 조회한다.
	 * 
	 * @param svcModel
	 * @param model
	 * @return
	 * @throws DAOException
	 */
	public String searchInvoiceImportBkgBkgCntr2(TrsTrspSvcOrdVO svcModel, TrsTrspSvcOrdVO model) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> tpsz_param = new HashMap<String, Object>();
		DBRowSet dbRs = null;
		DBRowSet tpSzRs = null;
		String cntrNo = null;
		String tgtCntrTpSz = null;	
		String srcCntrTpSz = null;
		try {


				param.put("bkg_no", svcModel.getBkgNo());
				param.put("org_bkg_no", svcModel.getOrgBkgNo());
				param.put("eq_no", model.getEqNo());
				
				dbRs = new SQLExecuter("DEFAULT").executeQuery(new InvoiceAuditDBDAOSearchInvoiceImportBkgBkgCntrRSQL(), param,param);
				
				while(dbRs.next()){
					cntrNo = dbRs.getString("CNTR_NO");
					tgtCntrTpSz = dbRs.getString("CNTR_TPSZ_CD");
					srcCntrTpSz = svcModel.getEqTpszCd();
					
					if(tgtCntrTpSz != null && !tgtCntrTpSz.equals(srcCntrTpSz)){
						tpsz_param.put("eq_tpsz_cd", srcCntrTpSz);
						tpsz_param.put("cntr_tpsz_cd", tgtCntrTpSz);					

						tpSzRs = new SQLExecuter("DEFAULT").executeQuery(new InvoiceAuditDBDAOSearchInvoiceImportBkgBkgCntrProvTpszRSQL(), tpsz_param,tpsz_param);
						
						
						if(!tpSzRs.next()){
							cntrNo = null;
						}
					}
				}

			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		
		return cntrNo;
	}
	
	/**
	 * bkg_no와 EQ가 mapping이 되어있는 컨테이너를 조회한다.<br>
	 * 
	 * @param inputRs
	 * @param model
	 * @return
	 * @throws DAOException
	 */
	public String searchInvoiceImportBkgBkgCntr(DBRowSet inputRs, TrsTrspSvcOrdVO model) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> tpsz_param = new HashMap<String, Object>();
		DBRowSet dbRs = null;
		DBRowSet tpSzRs = null;
		String cntrNo = null;
		String tgtCntrTpSz = null;	
		String srcCntrTpSz = null;
		try {

				param.put("bkg_no", inputRs.getString("BKG_NO"));
				param.put("org_bkg_no", inputRs.getString("ORG_BKG_NO"));
				param.put("eq_no", model.getEqNo());
				
				dbRs = new SQLExecuter("DEFAULT").executeQuery(new InvoiceAuditDBDAOSearchInvoiceImportBkgBkgCntrRSQL(), param,param);
				
				while(dbRs.next()){
					cntrNo = dbRs.getString("CNTR_NO");
					tgtCntrTpSz = dbRs.getString("CNTR_TPSZ_CD");
					srcCntrTpSz = inputRs.getString("EQ_TPSZ_CD");
					
					if(tgtCntrTpSz != null && !tgtCntrTpSz.equals(srcCntrTpSz)){
						tpsz_param.put("eq_tpsz_cd", srcCntrTpSz);
						tpsz_param.put("cntr_tpsz_cd", tgtCntrTpSz);					

						tpSzRs = new SQLExecuter("DEFAULT").executeQuery(new InvoiceAuditDBDAOSearchInvoiceImportBkgBkgCntrProvTpszRSQL(), tpsz_param,tpsz_param);
						
						
						if(!tpSzRs.next()){
							cntrNo = null;
						}
					}
				}

			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		
		return cntrNo;
	}
	
	/**
	 * InvoiceFileImport를 통해 입력해주는 데이터를 조회한다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public List searchTruckInvoiceFileImport(EsdTrs0033Event event) throws DAOException {
		DBRowSet dRs = null;		
		Map<String, Object> param = new HashMap<String, Object>();
		TrsTrspSvcOrdVO[] soArr = event.getTrsTrspSvcOrdVOS();
		String apply_currency = event.getApply_currency();
		List<SearchTruckInvoiceFileImportVO> rsList = null;
		
		try {
			
			for(int i=0; soArr != null && i<soArr.length; i++){
				
				param.put("eq_no", soArr[i].getEqNo());
				param.put("eq_tpsz_cd", soArr[i].getEqTpszCd());
				param.put("inv_curr_cd", apply_currency);
				param.put("inv_rmk", soArr[i].getInvRmk());
				param.put("cntr_sub_flg", soArr[i].getCntrSubFlg());
				param.put("trsp_so_ofc_cty_cd", soArr[i].getTrspSoOfcCtyCd());
				param.put("trsp_so_seq", soArr[i].getTrspSoSeq());

				dRs = new SQLExecuter("DEFAULT").executeQuery(new InvoiceAuditDBDAOSearchTruckInvoiceFileImportRSQL(), param,param);
				List<SearchTruckInvoiceFileImportVO> listTemp = (List)RowSetUtil.rowSetToVOs(dRs, SearchTruckInvoiceFileImportVO.class);

				if(rsList == null){
					rsList = listTemp;
				}else{
					rsList.addAll(listTemp);
				}
			}
			


			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		
		return rsList;
	}
	
	/**
	 * 특정값이 ArrayList에 포함 되었는지 체크한다...<br>
	 * 
	 * @param ArrayList src
	 * 
	 * @param String elem
	 *            
	 * @return boolean result 처리 결과           
	 * 
	 */
	
	public boolean contains(ArrayList src, String elem){
		
		boolean result = false;
		for(int i=0; src != null && i< src.size(); i++){
			if(elem.equals((String)src.get(i))){
				result = true;
			}
		}
		return result;
	}
	
	/**
	 * WO SP의 PARENTS SP를 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchVendor(EsdTrs0040Event event) throws DAOException {
		DBRowSet dRs = null;		
		Map<String, Object> param = new HashMap<String, Object>();

		String combo_svc_provider = event.getCombo_svc_provider();
		
		
		try {
			
			if(!"".equals(combo_svc_provider) && combo_svc_provider != null ){
				param.put("combo_svc_provider", combo_svc_provider);
				dRs = new SQLExecuter("DEFAULT").executeQuery(new InvoiceAuditDBDAOSearchVendorRSQL(), param,param);
			}

			
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
	 * SO Amt 일치 여부를 검사한다.<br>
	 * 
	 * @param model TrsTrspSvcOrdVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchSOAmt(TrsTrspSvcOrdVO model) throws DAOException {
		DBRowSet dRs = null;		
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			
			if(model != null ){
				param.put("bzc_amt", model.getBzcAmt());
				param.put("etc_add_amt", model.getEtcAddAmt());
				param.put("nego_amt", model.getNegoAmt());
				param.put("fuel_scg_amt", model.getFuelScgAmt());
				param.put("scg_vat_amt", model.getScgVatAmt());
				param.put("trsp_so_ofc_cty_cd", model.getTrspSoOfcCtyCd());
				param.put("trsp_so_seq", model.getTrspSoSeq());
				dRs = new SQLExecuter("DEFAULT").executeQuery(new InvoiceAuditDBDAOSearchSOAmtRSQL(), param,param);			
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		
		return dRs;
	}
	
	public String getIndiaOfcCdChk(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		String indOfcCd = "";
		try {
			if ( !"".equals( ofcCd )) {
				param.put("ofc_cd", ofcCd );
				velParam.put("ofc_cd", ofcCd );
			}			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery(new InvoiceAuditDAOIndiaOfcChkRSQL(), param,param);
			while (dbRowset.next()){
				indOfcCd = dbRowset.getString("IND_OFC_CD");
			}
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
		return indOfcCd;
	}
	
	public DBRowSet searchIdaTaxRto(EsdTrs0033Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();		
		String ofc_Cd = event.getFORM_USR_OFC_CD();
		String payment_sp_seq = event.getPaymentVndrSeq();
		String sac_no = event.getSacNo();		
		param.put("ofc_cd", ofc_Cd);
		param.put("payment_sp_seq", payment_sp_seq);
		param.put("sac_no", sac_no);		
		try {
			dRs = new SQLExecuter("").executeQuery(new InvoiceAuditDAOSearchIdaTaxRtoRSQL(), param,param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return dRs;		
	}
	
	public DBRowSet verifySacNo(EsdTrs0033Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		String sac_no = event.getSacNo();
		param.put("sac_no", sac_no);
		try {
			dRs = new SQLExecuter("").executeQuery(new InvoiceAuditDAOSearchIdaSacNoExistsRSQL(), param,param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
		return dRs;
	}
	
}
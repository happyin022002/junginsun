/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ConsultationSlipRequestBackEndJob.java
*@FileTitle : Approval Request BackEndJob
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.20
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.11.20 함대성
* 1.0 Creation
* -------------------------------------------------------
* History
* 2010.10.18 김영철 [CHM-201006348-01] CSR 전표 Remark 보완 - INV_DESC 추가
* 2010.10.18 김영철 [CHM-201006951-01] [VOP-PSO] 전도금 CSR내 detail 항목에 VVD 표기 요청건
* 2014.11.19 김영신 [CHM-201432872] 10만불 이상 G/W연동 관련 로직 추가
* 2015.05.13 심성윤 [CHM-201535807] PSO 별도 파일 추가 탭 기능 개발
=========================================================*/
package com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.basic;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.basic.GeneralInvoiceAuditBCImpl;
import com.hanjin.bizcommon.approval.util.ApprovalUtil;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.integration.ConsultationSlipRequestMgtDBDAO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.AutoRevVVDListVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.CSRSOhdrVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.CreateApInvDTRBASANoSelectVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.CsrParmVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.SearchDTRBTtlVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.PayInvVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.syscommon.common.table.ApInvDtrbVO;
 
/**
 * ALPS-ConsultationSlipRequestMgt Long Transaction Business Logic <br>
 * - ALPS-ConsultationSlipRequestMgt 대한 Long Transaction 비지니스 로직<br>
 *
 * @author Ham Dae Sung
 * @see com_csr_0002 참조
 * @since J2EE 1.6
 */
public class ConsultationSlipRequestBackEndJob extends BackEndCommandSupport {
	
	private ConsultationSlipRequestMgtDBDAO dbDao;
	private String jobFlg = null;
	private String creUsrId = null;
	private List<AutoRevVVDListVO> autoRevVVDListVO = null;
	private List<SearchDTRBTtlVO> searchDTRBTtlVOList = null;
	private CsrParmVO csrParmVO = null;
	private Collection<PayInvVO> payInvVOs = null;

	/**
	 * serialVersionUID 
	 */
	private static final long serialVersionUID = -4432166936180768897L;

	/**
	 * Main Start
	 * @return List<EstmActRsltVO>
	 * @throws Exception
	 */
	public String doStart() throws Exception {
        String csr_no = null;
        try{
	        dbDao = new ConsultationSlipRequestMgtDBDAO();
	
	       if ("SAVE".equals(jobFlg)){
	    	   csr_no = this.approvalRequest(payInvVOs, autoRevVVDListVO, searchDTRBTtlVOList, csrParmVO, creUsrId);
	        }
		} catch (DAOException de) {
			log.error("\n DONE - approvalRequest.DAOException - CSR_NO:"+csr_no+" / "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n\n");
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
        return csr_no;
	}

	/**
	 * JOB FLAG setting
	 * @param String jobFlg
	 */
	public void setJobFlg(String jobFlg){
		this.jobFlg = jobFlg;
	}
	
	/**
	 * @return the creUsrId
	 */
	public String getCreUsrId() {
		return creUsrId;
	}

	/**
	 * @param creUsrId the creUsrId to set
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	/**
	 * @return the searchDTRBTtlVOList
	 */
	public List<SearchDTRBTtlVO> getSearchDTRBTtlVOList() {
		return searchDTRBTtlVOList;
	}

	/**
	 * @param searchDTRBTtlVOList the searchDTRBTtlVOList to set
	 */
	public void setSearchDTRBTtlVOList(List<SearchDTRBTtlVO> searchDTRBTtlVOList) {
		this.searchDTRBTtlVOList = searchDTRBTtlVOList;
	}
	
	/**
	 * @return the autoRevVVDListVO
	 */
	public List<AutoRevVVDListVO> getAutoRevVVDListVO() {
		return autoRevVVDListVO;
	}

	/**
	 * @param autoRevVVDListVO the autoRevVVDListVO to set
	 */
	public void setAutoRevVVDListVO(List<AutoRevVVDListVO> autoRevVVDListVO) {
		this.autoRevVVDListVO = autoRevVVDListVO;
	}
	
	/**
	 * @return the csrParmVO
	 */
	public CsrParmVO getCsrParmVO() {
		return csrParmVO;
	}

	/**
	 * @param csrParmVO the csrParmVO to set
	 */
	public void setCsrParmVO(CsrParmVO csrParmVO) {
		this.csrParmVO = csrParmVO;
	}

	/**
	 * @return the payInvVOs
	 */
	public Collection<PayInvVO> getPayInvVOs() {
		return payInvVOs;
	}

	/**
	 * @param payInvVOs the payInvVOs to set
	 */
	public void setPayInvVOs(Collection<PayInvVO> payInvVOs) {
		this.payInvVOs = payInvVOs;
	}

	/**
	 * Estimation Save
	 * @throws Exception
	 */
	private String approvalRequest(Collection<PayInvVO> payInvVOs, List<AutoRevVVDListVO> autoRevVVDListVO, List<SearchDTRBTtlVO> searchDTRBTtlVOList, CsrParmVO csrParmVO, String creUsrId) throws Exception {

		log.error("\n\n\n\n\n BCImpl approvalRequest >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> approvalRequest");
		log.error("\n approvalRequest:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");

		String asa_no 	 = csrParmVO.getAsaNoS();
		String csr_tp_cd = csrParmVO.getCsrTpCd();
		String cnt_cd 	 = csrParmVO.getCntCd();
		String evi_gb 	 = csrParmVO.getEviGb();
		String csr_no 	 = "";
		String chkAmt    = ""; 
		//TLL로직 추가
		String inv_sub_sys_cd = csrParmVO.getInvSubSysCd();
		String ofc_cd    	  = JSPUtil.getNull(csrParmVO.getOfcCd());
		String cost_ofc_cd    = JSPUtil.getNull(csrParmVO.getCostOfcCd());
		//createApInvDTRB_sum
		DBRowSet		dtrbSumSet	= null;		
		String inv_no2			= "";
		String vndr_seq			= ""; 
		String gap		 		= "";
		String cost_cd	 		= "";
		String cntr_tpsz_cd		= ""; 
		//Rev.VVD
		DBRowSet 		revVVDSet 	= null;
		DBRowSet 		revVVDSet2 	= null;
		DBRowSet 		acctCdSet 	= null;
		String 			vvd_cd 	= "";
		String 			dtrb_coa_acct_cd 	= "";
		String 			inv_no 	= "";
		String 			chk 	= "";
		String 			tmp_del_vvd_inv 		= "";
		String 			tmp_not_found_vvd_inv 	= "";
		
		//createApInvDTRBASANo
		DBRowSet		asaRowSet	= null;
		String iss_dt = "";
		String loc_cd = "";
		String line_seq = "";
		String line_no = "";
		String total_amt = "";
		String acct_cd = "954113";
		//modifyApInvDTRBLineNo
		DBRowSet 		dtrbLineSet 	= null;
		ApInvDtrbVO		apInvDtrbVO		= null;
		List<ApInvDtrbVO> 	lineNoVoList 	= new ArrayList<ApInvDtrbVO>();
		
		DBRowSet[] 						dbRowSetArr				= null;
		List<SearchDTRBTtlVO> 			searchCorrDTRBTtlVOList = new ArrayList<SearchDTRBTtlVO>();
		SearchDTRBTtlVO 				searchDTRBTtlVO 		= null;
		
		try {
			
			//다건의 인보이스의 상태들을 조회만 하고 사용하진 않는다 -> 인보이스상태를 처음에 불러놓고 사용하진 않는다 ? -> 이 checkInvoiceStatus 메소드는 제거해도 되지않는가? 아니면 상태값으로 무엇을 하려함인가?
			// 2007-12-10 : invoice의 상태를 확인
			//dbDao.checkInvoiceStatus(event.getPayInvs(),ConsultationSlipRequestMgtBC.INV_STS_CF);
			//1. 각 데이터 CHECK  후 없는 경우 Exception 발생 시켜  더이상 진행시키지 않음 - mdm_organization
			CSRSOhdrVO rtnVO = dbDao.searchApInvCheck1(csrParmVO);
			if((rtnVO.getApOfcCd()).equals("N") || (rtnVO.getApOfcCd()).equals("")){
				throw new DAOException(new ErrorHandler("CSR00023").getMessage());
			}
			if((rtnVO.getFincRgnCd()).equals("N") || (rtnVO.getFincRgnCd()).equals("")){
				throw new DAOException(new ErrorHandler("CSR00023").getMessage());
			}
			if((rtnVO.getApCtrCd()).equals("N") || (rtnVO.getApCtrCd()).equals("")){
				throw new DAOException(new ErrorHandler("CSR00023").getMessage());
			}
			log.error("\n DONE - approvalRequest.searchApInvCheck1:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			//2. ACCT_CD(비용코드)?
			dbDao.searchApInvCheck2(payInvVOs);
			log.error("\n DONE - approvalRequest.searchApInvCheck2:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			//3. csr_no 생성: csr_no 채번후 ap_csr_no 테이블에 insert / >>>>>>>물류와 장비 두개의 구분으로 CSR_NO 채번 [SM]
			//if(!inv_sub_sys_cd.equals("CNI")){	//CNI모듈이 아닌 경우 CSR_NO 채번
			csr_no = dbDao.multiCSRNo(cost_ofc_cd, csr_tp_cd);
			dbDao.multiCSRInsert(cost_ofc_cd, csr_no, creUsrId);

			log.error("\n DONE - approvalRequest.multiCSRNo:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			csrParmVO.setCsrNo(csr_no); 
			
			
/*			 "PSO" Only REV_DIR_CD(RLANE_DIR_CD) DIFF 데이터 존재여부 추출 및 예외처리 (R.VVD 업데이트이전 체크) :: 2012-07-10 
			if("PSO".equals(inv_sub_sys_cd)){
				
				iPsoRevDirCdDiffKnt		= dbDao.checkPSORevDirCdEffectiveness(payInvVOs);  //Collection payInvVOs, CsrParmVO csrParmVO
				
				 SERVER WARNING MESSAGE : CSR00099 :: Cancel your port charge invoice and reprocess it since revenue vvd of this invoice was changed. 
				if(iPsoRevDirCdDiffKnt >0)	throw new DAOException(new ErrorHandler("CSR00099").getMessage()+"Inv no : 000341-12, 000342-12"); 
			}
*/
			
			
			if(!inv_sub_sys_cd.equals("CNI") && autoRevVVDListVO.size() > 0){	//CNI모듈이 아닌경우만 재무VVD 업데이트
				// 2. REVENUE VVD CONVERSION AUTO, MANUAL invoice UPDATE 처리
				dbDao.modifyAutoRevVVD(autoRevVVDListVO);
				log.error("\n DONE - searchPreVeiw.modifyAutoRevVVD:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			}

			/* "PSO" Only REV_DIR_CD(RLANE_DIR_CD) DIFF 데이터 존재여부 추출 및 업	데이트처리  :: 2012-07-16 
			 * AP_PAY_INV_DTL.ACT_VVD_CD & VSL_CD||SKD_VOY_NO||SKD_DIR_CD||REV_DIR_CD
			 * */
			if(inv_sub_sys_cd.equals("PSO") && autoRevVVDListVO.size() > 0){	//PSOCNI모듈이 아닌경우만 재무VVD 업데이트
				// 2. REVENUE VVD CONVERSION AUTO, MANUAL invoice UPDATE 처리
				dbDao.modifyPSORevVVD(autoRevVVDListVO);
				log.error("\n DONE - searchPreVeiw.modifyPSOActVvdCd:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			}			
			
			//4.AP HDR 및 DTRB INSERT
			dbDao.createApInvHDR(csrParmVO, creUsrId);
			log.error("\n DONE - approvalRequest.createApInvHDR:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");

			
			/**
			 * AP_INV_HDR에 PDT결재 관련 부수적인 사항 UPDATE한다.  
			 */
			dbDao.updateApInvHdrPDTApproval(csr_no);
			
			/**
			 * 환율 상태 확인 : AP_INV_HDR에 PDT결재 관련 부수적인 사항 UPDATE후에 USD환율이 NULL이거나 해당기간에 USD 환율변환이 안되는 상태면 띵긴다.  
			 */
			dbDao.checkUSDExchSts(csr_no);
			
			
			
			/* AP_PAY_INV_DTL 테이블에 REV.VVD 업데이트이후 결과 추출(한국지역+국외지역) START ::2012-07-16 */
			if (cnt_cd.equals("KR")){
				dbRowSetArr	= dbDao.searchApInvDTRBIn	(payInvVOs, csrParmVO);
			}else{
				dbRowSetArr	= dbDao.searchApInvDTRBOut	(payInvVOs, csrParmVO);
			}
			/* AP_PAY_INV_DTL 테이블에 REV.VVD 업데이트이후 결과 추출(한국지역+국외지역) FINISH ::2012-07-16 */
				
			//REV.VVD 업데이트 변경된 AP_PAY_INV_DTL 기준으로 searchCorrDTRBTtlVOList Setting
			if(dbRowSetArr != null){
				for(int j=0; j<dbRowSetArr.length; j++){
					while (dbRowSetArr[j].next()){
						searchDTRBTtlVO = new SearchDTRBTtlVO();
						
						searchDTRBTtlVO.setLineSeq			(dbRowSetArr[j].getString("line_seq"));
						searchDTRBTtlVO.setLineNo           (dbRowSetArr[j].getString("line_no"));
						searchDTRBTtlVO.setLineTpLuCd       (dbRowSetArr[j].getString("line_tp_lu_cd"));
						searchDTRBTtlVO.setCsrAmt           (dbRowSetArr[j].getString("csr_amt"));
						searchDTRBTtlVO.setInvDesc          (dbRowSetArr[j].getString("inv_desc"));
						searchDTRBTtlVO.setInvTaxCd         (dbRowSetArr[j].getString("inv_tax_cd"));
						searchDTRBTtlVO.setDtrbCoaCoCd      (dbRowSetArr[j].getString("dtrb_coa_co_cd"));
						searchDTRBTtlVO.setDtrbCoaRgnCd     (dbRowSetArr[j].getString("dtrb_coa_rgn_cd"));
						searchDTRBTtlVO.setDtrbCoaCtrCd     (dbRowSetArr[j].getString("dtrb_coa_ctr_cd"));
						searchDTRBTtlVO.setDtrbCoaAcctCd    (dbRowSetArr[j].getString("dtrb_coa_acct_cd"));
						searchDTRBTtlVO.setDtrbCoaVvdCd     (dbRowSetArr[j].getString("dtrb_coa_vvd_cd"));
						searchDTRBTtlVO.setDtrbCoaInterCoCd (dbRowSetArr[j].getString("dtrb_coa_inter_co_cd"));
						searchDTRBTtlVO.setDtrbCoaFtuN1stCd (dbRowSetArr[j].getString("dtrb_coa_ftu_n1st_cd"));
						searchDTRBTtlVO.setDtrbCoaFtuN2ndCd (dbRowSetArr[j].getString("dtrb_coa_ftu_n2nd_cd"));
						searchDTRBTtlVO.setAttrCateNm       (dbRowSetArr[j].getString("attr_cate_nm"));
						searchDTRBTtlVO.setAttrCtnt1        (dbRowSetArr[j].getString("attr_ctnt1"));
						searchDTRBTtlVO.setAttrCtnt2        (dbRowSetArr[j].getString("attr_ctnt2"));
						searchDTRBTtlVO.setAttrCtnt3        (dbRowSetArr[j].getString("attr_ctnt3"));
						searchDTRBTtlVO.setAttrCtnt4        (dbRowSetArr[j].getString("attr_ctnt4"));
						searchDTRBTtlVO.setAttrCtnt5        (dbRowSetArr[j].getString("attr_ctnt5"));
						searchDTRBTtlVO.setAttrCtnt6        (dbRowSetArr[j].getString("attr_ctnt6"));
						searchDTRBTtlVO.setAttrCtnt7        (dbRowSetArr[j].getString("attr_ctnt7"));
						searchDTRBTtlVO.setAttrCtnt8        (dbRowSetArr[j].getString("attr_ctnt8"));
						searchDTRBTtlVO.setAttrCtnt9        (dbRowSetArr[j].getString("attr_ctnt9"));
						searchDTRBTtlVO.setAttrCtnt10       (dbRowSetArr[j].getString("attr_ctnt10"));
						searchDTRBTtlVO.setAttrCtnt11       (dbRowSetArr[j].getString("attr_ctnt11"));
						searchDTRBTtlVO.setAttrCtnt12       (dbRowSetArr[j].getString("attr_ctnt12"));
						searchDTRBTtlVO.setAttrCtnt13       (dbRowSetArr[j].getString("attr_ctnt13"));
						searchDTRBTtlVO.setAttrCtnt14       (dbRowSetArr[j].getString("attr_ctnt14"));
						searchDTRBTtlVO.setAttrCtnt15       (dbRowSetArr[j].getString("attr_ctnt15"));
						searchDTRBTtlVO.setBkgNo            (dbRowSetArr[j].getString("bkg_no"));
						searchDTRBTtlVO.setCntrTpszCd       (dbRowSetArr[j].getString("cntr_tpsz_cd"));
						searchDTRBTtlVO.setActVvdCd         (dbRowSetArr[j].getString("act_vvd_cd"));
						searchDTRBTtlVO.setPlnSctrDivCd     (dbRowSetArr[j].getString("pln_sctr_div_cd"));
						searchDTRBTtlVO.setSoCrrCd          (dbRowSetArr[j].getString("so_crr_cd"));
						searchDTRBTtlVO.setYdCd             (dbRowSetArr[j].getString("yd_cd"));
						searchDTRBTtlVO.setFtuUseCtnt1      (dbRowSetArr[j].getString("ftu_use_ctnt1"));
						searchDTRBTtlVO.setFtuUseCtnt2      (dbRowSetArr[j].getString("ftu_use_ctnt2"));
						searchDTRBTtlVO.setFtuUseCtnt3      (dbRowSetArr[j].getString("ftu_use_ctnt3"));
						searchDTRBTtlVO.setFtuUseCtnt4      (dbRowSetArr[j].getString("ftu_use_ctnt4"));
						searchDTRBTtlVO.setFtuUseCntr5      (dbRowSetArr[j].getString("ftu_use_cntr5"));
						searchDTRBTtlVO.setCreDt            (dbRowSetArr[j].getString("cre_dt"));
						searchDTRBTtlVO.setCreUsrId         (dbRowSetArr[j].getString("cre_usr_id"));
						searchDTRBTtlVO.setEaiEvntDt        (dbRowSetArr[j].getString("eai_evnt_dt"));
						
						searchCorrDTRBTtlVOList.add(searchDTRBTtlVO);
					}				
				}
			}			
				
			 //searchApInvDTRBIn -> or searchApInvDTRBOut -> 로직으로 DBRowSet[] 타입으로 담아온 데이타들을 AP_INV_DTRB에 INSERT, AP_INV_HDR에 UPDATE
			if (cnt_cd.equals("KR")){
				//
				
				//::jsk::2012.07.16::dbDao.createApInvDTRB(searchDTRBTtlVOList, csrParmVO, creUsrId);  //SC에서 event.setDTRBRowSetArr()를 실행한 경우만 사용해야 합니다.
				dbDao.createApInvDTRB(searchCorrDTRBTtlVOList, csrParmVO, creUsrId);  //SC에서 event.setDTRBRowSetArr()를 실행한 경우만 사용해야 합니다.
				
				dbDao.createApInvHdrUpdate(csrParmVO);
				log.error("\n DONE - approvalRequest.createApInvDTRB:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
				if(evi_gb.equals("1") || evi_gb.equals("2")){	//AP_INV_DTRB INSERT [증빙]
					//
					dbDao.createApInvDTRBEvi(payInvVOs, csrParmVO);
					log.error("\n DONE - approvalRequest.createApInvDTRBEvi:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
				}else{
					if(inv_sub_sys_cd.equals("TLL")){
						dbDao.createApInvDTRBEviTll(payInvVOs, csrParmVO);
					}
				}
				
			} else { //
				dbDao.createApInvDTRB(searchCorrDTRBTtlVOList, csrParmVO, creUsrId);  //SC에서 event.setDTRBRowSetArr()를 실행한 경우만 사용해야 합니다.
				log.error("\n DONE - approvalRequest.createApInvDTRB:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			}
			
			//AP_INV_DTRB 의 LINE_SEQ, LINE_NO UPDATE
			dbDao.modifyApInvDTRBLineNo(csr_no);
			dtrbLineSet = dbDao.modifyApInvDTRBLineNo03(csr_no);
			if (dtrbLineSet != null) {
				while(dtrbLineSet.next()){
					apInvDtrbVO = new ApInvDtrbVO();
					
					apInvDtrbVO.setLineNo(dtrbLineSet.getString("line_no"));
					apInvDtrbVO.setCsrNo(csr_no);
					apInvDtrbVO.setAttrCtnt1(dtrbLineSet.getString("attr_ctnt1"));
					apInvDtrbVO.setDtrbCoaAcctCd(dtrbLineSet.getString("dtrb_coa_acct_cd"));
					apInvDtrbVO.setDtrbCoaVvdCd(dtrbLineSet.getString("dtrb_coa_vvd_cd"));
					
					lineNoVoList.add(apInvDtrbVO);
				}
			}
			dbDao.modifyApInvDTRBLineNo02(lineNoVoList); 
			
			log.error("\n DONE - approvalRequest.modifyApInvDTRBLineNo:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			
			//AP_INV_DTRB GAP(청구받은 Invoice의 금액 - 공급액) UPDATE
			Iterator itr   =	payInvVOs.iterator();
			PayInvVO model = null;

			while (itr.hasNext()) {
				model 			= (PayInvVO)itr.next();
				inv_no = model.getInv_no();
				vndr_seq = model.getVndr_seq();
				
				dtrbSumSet = dbDao.createApInvDTRB_sum(csr_no, inv_no, vndr_seq);
				
				if (dtrbSumSet != null) {
    				while(dtrbSumSet.next()){
    					gap 			= dtrbSumSet.getString("GAP");
    					inv_no2 		= dtrbSumSet.getString("ATTR_CTNT1");
    					cost_cd 		= dtrbSumSet.getString("FTU_USE_CTNT1");
    					cntr_tpsz_cd 	= dtrbSumSet.getString("CNTR_TPSZ_CD");
    					
    					if (inv_no==null || inv_no.trim().equals("") || inv_no2==null || inv_no2.trim().equals("") || !inv_no.equals(inv_no2)){
    						throw new DAOException(new ErrorHandler("Wrong Inv.No Exception!!!").getMessage());
    					}
    					
    					dbDao.createApInvDTRB_sumUpdateDiff(csrParmVO, gap, inv_no2, cost_cd, cntr_tpsz_cd);
    				}
				}
			}
			
			log.error("\n DONE - approvalRequest.createApInvDTRB_sum:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");

			if (!asa_no.equals("")) {
				//asa_no 값이 있는경우
				asaRowSet = dbDao.createApInvDTRBASANoSelect(csr_no);
	            if (asaRowSet != null) {
	            	while(asaRowSet.next()){
	            		inv_no  	= asaRowSet.getString("inv_no");
	            		iss_dt  	= asaRowSet.getString("iss_dt");
	            		loc_cd		= asaRowSet.getString("loc_cd");
	            		line_seq	= asaRowSet.getString("line_seq");
	            		line_no		= asaRowSet.getString("line_no");
	            		total_amt	= asaRowSet.getString("total_amt");
	            	}
	            }
	            
	            CreateApInvDTRBASANoSelectVO createApInvDTRBASANoSelectVO = new CreateApInvDTRBASANoSelectVO();
	            
	            createApInvDTRBASANoSelectVO.setInvNo(inv_no);
	            createApInvDTRBASANoSelectVO.setIssDt(iss_dt);
	            createApInvDTRBASANoSelectVO.setLocCd(loc_cd);
	            createApInvDTRBASANoSelectVO.setLineSeq(line_seq);
	            createApInvDTRBASANoSelectVO.setLineNo(line_no);
	            createApInvDTRBASANoSelectVO.setTotalAmt(total_amt);
	            createApInvDTRBASANoSelectVO.setAcctCd(acct_cd);
	            createApInvDTRBASANoSelectVO.setCsrNo(csr_no);
	            
	            dbDao.createApInvDTRBASANoInsert(createApInvDTRBASANoSelectVO, ofc_cd, cost_ofc_cd, vndr_seq, creUsrId, csr_tp_cd);
	            dbDao.createApInvDTRBASANoUpdate(csr_no);
				log.error("\n DONE - approvalRequest.createApInvDTRBASANo:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			}
			 
			if(!inv_sub_sys_cd.equals("CNI")){	//CNI모듈인 경우 레벨체크하지 않는다
				// 5. R.VVD LEVEL CHECK 2009-09 추가 :: .?
	 			dbDao.searchApInvVVDChacke(csr_no);
	 			log.error("\n DONE - approvalRequest.searchApInvVVDChacke:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			}
			
			//7.HDR CSR NO UPDATE 처리 -> AP_PAY_INV 의 CSR_NO 업데이트
			dbDao.upateInvCSRNo(payInvVOs, csr_no,"Y");
			log.error("\n DONE - approvalRequest.upateInvCSRNo:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			
			/* ALPS에서 Approval Step을 지정하지 않음
			//8.EP 결제하기 - 결제등록 (COM_APRO_RQST_HDR, ComAproRqstRoutVO)
			dbDao.createCSREPApproval(csrParmVO);
			log.error("\n DONE - approvalRequest.createCSREPApproval:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			String apro_step_chk = new ApprovalUtil().checkAproStepSts(csr_no,creUsrId);
			log.error("\n\n csr_no : " + JSPUtil.getNull(csr_no) + " --- apro_step_chk : " + JSPUtil.getNull(apro_step_chk) + " ======================= \n\n");
			if (apro_step_chk!=null){
				
				 // P : 10만불 이상인데 PDT 미지정
				 // M : 10만불 이하인데 본부장 미지정
				 // K : Approval Step PDT/본부장 포함 2단계 이하인 경우
				 // E : 오류
				 // I : CEO는 항상 제일 뒤에 위치하는지 검사 
				 // Y : 정상
				 / X : [2014-07,08] PDT 지시 시항 적용 대상이 아님
				 // F : PDT결재완료후 I/F ERROR이후 재발행건들 -> PDT/본부장 결재 우회 허용 
				 // C : 운하통과료 (SO_PORT) -> 결재자 상관없이 무조건 통과 요청
				 
				if (apro_step_chk.trim().equals("P")){
					throw new EventException(new ErrorHandler("CSR10011", new String[]{}).getMessage());
				} else if (apro_step_chk.trim().equals("M")){
					throw new EventException(new ErrorHandler("CSR10012", new String[]{}).getMessage());
				} else if (apro_step_chk.trim().equals("K")){
					throw new EventException(new ErrorHandler("CSR10014", new String[]{}).getMessage());
				} else if (apro_step_chk.trim().equals("E")){
					throw new EventException(new ErrorHandler("COM12240", new String[]{}).getMessage());
				} else if (apro_step_chk.trim().equals("I")){
					throw new EventException(new ErrorHandler("CSR10019", new String[]{}).getMessage());
				} else if (
						   apro_step_chk.trim().equals("Y") // 정상
						|| apro_step_chk.trim().equals("X") // 대상아님(적용전CSR들)
						|| apro_step_chk.trim().equals("F") // PDT결재완료후 I/F ERROR이후 재발행건들 -> PDT결재 우회 허용
						|| apro_step_chk.trim().equals("C") // (SO_PORT용) 운하통과료는 우회 허용
						   )
				{
					log.error("\n >>>>>>>>>>>>>>>>>>>>> --- apro_step_chk : " + JSPUtil.getNull(apro_step_chk) + "   [PASS] csr_no: " + JSPUtil.getNull(csr_no) + " <<<<<<<<<<<<<<<<<<<<< \n");
				} else {
					throw new EventException(new ErrorHandler("COM12240", new String[]{}).getMessage());					
				}				
			} else {
				throw new EventException(new ErrorHandler("COM12240", new String[]{}).getMessage());
			}*/
			
			
			// 9. inv_sts_cd 'A' 결제하기
			dbDao.modifyStsCdSOHDR(payInvVOs, "A");
			log.error("\n DONE - approvalRequest.modifyStsCdSOHDR:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");

			//10. CSR AMT VAILD CHECK
			chkAmt = dbDao.checkCSRAmtVsInvAmt(csr_no);
			log.error("\n DONE - approvalRequest.checkCSRAmtVsInvAmt:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			if (chkAmt==null || (chkAmt!=null && !chkAmt.equals("Y"))){
				//throw new DAOException("\n\n Invoice header amout don't match invoice detail amount. \n\n Please, contact COL.");
				throw new DAOException(new ErrorHandler("CSR00080").getMessage());	//\n\n Invoice header amout don't match invoice detail amount. \n\n Please, contact COL.
			}

			// 11. Rev.VVD로 Rev.VVD master에 존재/삭제 여부를 조회..
			revVVDSet = dbDao.checkMstRevVVD01(csr_no);

			if (revVVDSet!=null){
				while (revVVDSet.next()){
					vvd_cd = revVVDSet.getString("DTRB_COA_VVD_CD");
					inv_no = revVVDSet.getString("ATTR_CTNT1");
					log.debug("\n\n DTRB_COA_VVD_CD:"+revVVDSet.getString("DTRB_COA_VVD_CD")+" / inv_no:"+revVVDSet.getString("ATTR_CTNT1")+"  ---------------------  --------------------- ---------------------  \n\n");

					revVVDSet2 = dbDao.checkMstRevVVD02(csr_no);
					if (revVVDSet2!=null){
						while (revVVDSet2.next()){
							chk = revVVDSet2.getString("CHK");
							if (chk!=null){
								if (chk.trim().equals("Y")){
									tmp_del_vvd_inv = tmp_del_vvd_inv + (vvd_cd + " at the invoice " + inv_no + " has been deleted. ");
								}
							} else {
								tmp_not_found_vvd_inv = tmp_not_found_vvd_inv + (vvd_cd + " at the invoice " + inv_no + " is not found in Revenue VVD master. ");
							}
						}
					}
				}
			} else {
				throw new DAOException((new ErrorHandler("CSR00026").getMessage()));			
			}
			
			//12. PSO모듈인경우 INV_DESC 수정
			
			if(inv_sub_sys_cd.equals("PSO")){
				acctCdSet = dbDao.checkAcctCd(csr_no);	
				
				// 2010.10.19 Accunt Code가 110911 이고 PSO_TRNS_SLP_CTNT = 'GO' 일때만 AP_INV_HDR 테이블의 INV_DESC 컬럼에 기존 INV_DESC + (Actual VVD) 업데이트
				dbDao.modifyHdrDesc(csr_no);
				
				// 2010.10.19 Account Code가 962111 일때만 AP_INV_DTRB 테이블의 INV_DESC 컬럼에 기존 INV_DESC + AP_PAY_INV_DTL에 추가된 INV_DESC 값을 업데이트
				if (acctCdSet!=null){
					while (acctCdSet.next()){
						dtrb_coa_acct_cd = acctCdSet.getString("DTRB_COA_ACCT_CD");
						line_seq = acctCdSet.getString("LINE_SEQ");
						line_no  = acctCdSet.getString("LINE_NO");
						
						if(dtrb_coa_acct_cd.equals("962111") || dtrb_coa_acct_cd.equals("110911")){
							dbDao.modifyDesc(csr_no, dtrb_coa_acct_cd, line_seq, line_no);
						}
					}
				}
			}
			
			//13. CSR생성 후 Approval Request 하기 위한 단계로 업데이트
			ApprovalUtil aproUtil = new ApprovalUtil();
			
			aproUtil.updateAproGwFlg(csr_no, ofc_cd);
			
			//[CHM-201535807] PSO인 경우 Tariff 목록을 COM_AP_FILE_UPLD에 추가한다
			if (inv_sub_sys_cd.equals("PSO")) {
				//log.error("\n" + ">>>>>>>>>>>>>> addCsrAttchTariffFile 시작");
				new GeneralInvoiceAuditBCImpl().addCsrAttchTariffFile(csr_no, creUsrId);
			}
		} catch (DAOException de) {
			log.error("\n DONE - approvalRequest.DAOException - CSR_NO:"+csr_no+" / "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n\n");
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return csr_no;	
	}
	
}

/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TESeBillingManageDetailType003BCImpl.java
*@FileTitle : TES eBilling EDI 처리
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2012-01-04 
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.edi.ebilling.basic;

import java.util.List;
import java.util.HashMap;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.syscommon.common.table.TesEdiSoHdrVO;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.basic.TESeBillingCommonBC;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.integration.TESeBillingManageBizType003DBDAO;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.util.TESeBillingManageParseUtil;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.util.TESeBillingManageUtil;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.vo.ComTesEdiRcvFltFileTagVO;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.vo.ComTesEdiRcvRuleMnVO;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.vo.ComTesEdiRcvRuleVndrMgmtVO;

/**
 * ALPS-ESD Business Logic Basic Command implementation<br>
 * - ALPS-ESD에 대한 비지니스 로직을 처리한다.<br>
 *
 * TYPE3. PSA
 * 
 * @author 
 * @see TESeBillingManageBizType003BCImpl 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class TESeBillingManageBizType003BCImpl extends TESeBillingManageBizType000BCImpl {

	/**
	 * TES eBilling TYPE별 DBDAO
	 */
	private transient TESeBillingManageBizType003DBDAO ediDbDao = new TESeBillingManageBizType003DBDAO();
	
	/**
	 * TESeBillingManageDetailType003BCImpl default 객체 생성<br>
	 */
	public TESeBillingManageBizType003BCImpl(){
		super(new TESeBillingManageBizType003DBDAO());
	}
	
	/**
	 * TESeBillingManageDetailType003BCImpl dao 인자 객체 생성<br>
	 * @param ediDbDao
	 */
	public TESeBillingManageBizType003BCImpl(TESeBillingManageBizType003DBDAO ediDbDao) {
		super(ediDbDao);
	}

	/**
	 * F/F을 parse method로 해당 tag만 대상으로 DATA 분리해 내기
	 * 
	 * @param pars_mzd_cd
	 * @param str_ff
	 * @param tag_nm
	 * @return Object
	 * @throws EventException
	 */
	public Object getTagUnitData(String pars_mzd_cd, String str_ff, String tag_nm) throws EventException {
		log.error("\n\n bbbb -- TESeBillingManageDetailType003BCImpl.getTagUnitData - ########################################### ");
		if (pars_mzd_cd!=null && !pars_mzd_cd.trim().equals("")){
			return new TESeBillingManageParseUtil(pars_mzd_cd).getTagUnitData(str_ff, tag_nm);
		} else {
			return null;
		}
	} 
	
	/**
	 * EDI data를 임시 저장소에 저장
	 * 
	 * @param eventResponse
	 * @exception EventException
	 */
	public void createEDIInvoiceData(EventResponse eventResponse) throws EventException {
		log.debug("\n  TESeBillingManageBizType003BCImpl-createEDIInvoiceData~~~~~BBBB \n");
		
		/**
		 *  임시저장소에 넣고 나서...

			1) PSA DTL 정보 넣기 
			psaDbDao.createEDInvoicePSADTLTmpData(eventResponse, tab_cols);
			
			2) PSA DTL 후속 작업 : COST CODE MAPPING/YARD MAPPING/COST CODE로 INV유형 결정/VVD MAPPING 등 
			psaDbDao.updateEDInvoicePSADTLTmp(eventResponse);
			 	COST CODE MAPPING 필요
			 	YARD CODE MAPPING 필요 
			 	COST_OFC_CD 처리 : F/F에서 COST_OFC_CD가 오더라도 RULE에 의해 MDM_YARD를 통해 OFC를 가져올지 정해서 COST_OFC_CD정함
			 	VVD 처리 : PSA 전용 BKG VVD TABLE을 조회해서 VVD를 구한다. (VVD가 구해지면 VSL_CD|SKD_VOY_CD|SKD_DIR_CD를 UPDATE한다)
	
			3) 기본 임시 저장소에 HDR/DTL/CNTRLIST에 정보 넣기까지 1번에서 다 마쳐야한다.
		**/
		
		ComTesEdiRcvRuleMnVO tesEdiRuleMainVO = null;
		ComTesEdiRcvRuleVndrMgmtVO tesEdiRcvRuleVndrMgmtVO = null;
		List<ComTesEdiRcvFltFileTagVO> tesEdiRcvFltFileTagVOlist = null;
		TesEdiSoHdrVO tesEdiInitVO = null;
		HashMap<String,String>[] hms = null;
		String[] tab_cols = null;
		String[][] exc_cols_n_val = null;
		int valid_hdr_knt = 0;
		
		try {
			tesEdiRuleMainVO	= (ComTesEdiRcvRuleMnVO)((GeneralEventResponse)eventResponse).getCustomData(TESeBillingCommonBC.EDI_RULE_MAIN);
			tesEdiInitVO		= (TesEdiSoHdrVO)((GeneralEventResponse)eventResponse).getCustomData(TESeBillingCommonBC.EDI_INIT_VO);
			
			tesEdiRcvRuleVndrMgmtVO = tesEdiRuleMainVO.getComTesEdiRcvRuleVndrMgmtVO();
			if (tesEdiRcvRuleVndrMgmtVO!=null){
				tesEdiRcvFltFileTagVOlist = tesEdiRcvRuleVndrMgmtVO.getComTesEdiRcvFltFileTagVOlist();
			}
			
			/**
			 * 임시 TABLE에 일단 저장
			 */
			for (int i=0; tesEdiRcvFltFileTagVOlist!=null && i<tesEdiRcvFltFileTagVOlist.size(); i++){
				/** EDI RULE에서 TAG의 SAVE SEQ. 순서에 맞게 저장한다. 각 순서당 PK를 추출 및 HMS에 저장한다. **/
				if (tesEdiRcvFltFileTagVOlist.get(i)!=null){
					if (tesEdiRcvFltFileTagVOlist.get(i).getFltFileTagNm()!=null && !tesEdiRcvFltFileTagVOlist.get(i).getFltFileTagNm().trim().equals("")){
						log.debug("\n TAG_NAME: "+tesEdiRcvFltFileTagVOlist.get(i).getFltFileTagNm()+"@@@@@@@@@@@@@@@@@ \n");
						hms = (HashMap<String,String>[])((GeneralEventResponse)eventResponse).getCustomData(tesEdiRcvFltFileTagVOlist.get(i).getFltFileTagNm().trim());
						if (hms!=null && hms.length>0){
							if (tesEdiRcvFltFileTagVOlist.get(i).getHdrTagFlg()!=null && tesEdiRcvFltFileTagVOlist.get(i).getHdrTagFlg().trim().equals("Y")){
								/** HDR TAG인 경우 **/
								if (tesEdiRcvFltFileTagVOlist.get(i).getTagVldKnt()!=null && !tesEdiRcvFltFileTagVOlist.get(i).getTagVldKnt().trim().equals("")){
									valid_hdr_knt =  Integer.parseInt(tesEdiRcvFltFileTagVOlist.get(i).getTagVldKnt()!=null&&!tesEdiRcvFltFileTagVOlist.get(i).getTagVldKnt().trim().equals("")?tesEdiRcvFltFileTagVOlist.get(i).getTagVldKnt().trim():"1");
								}
								log.debug("\n valid_hdr_knt: "+valid_hdr_knt+" <<<@@@@@@@@@@@@@@@@@ \n");
								if (hms.length == valid_hdr_knt){
									/** KEY값  inv_ofc_cd/tml_edi_so_ofc_cty_cd/tml_edi_so_seq들을 조회하고 hms[0]에도 넣어주고, tesEdiInitVO에도 설정하여 이후에도 참조할 수 있게 한다. **/
									setMainKeyValue(hms[0], tesEdiInitVO, tesEdiRcvRuleVndrMgmtVO);
								} else {
									throw new EventException("\n EDI INVOICE HEADER COUNT EXCEPTION! \n");
								}
							}
							tab_cols = ediDbDao.getTabColumns(JSPUtil.getNull(tesEdiRcvFltFileTagVOlist.get(i).getTblNm()).trim());
							log.debug("\n tab_cols.length:"+(tab_cols!=null?tab_cols.length:0)+" <<<<<\n");
							
							log.debug("\n tesEdiInitVO --"
									+" TmlEdiSoOfcCtyCd : "+(tesEdiInitVO!=null?JSPUtil.getNull(tesEdiInitVO.getTmlEdiSoOfcCtyCd()):"") 
									+" TmlEdiSoSeq : "+(tesEdiInitVO!=null?JSPUtil.getNull(tesEdiInitVO.getTmlEdiSoSeq()):"")
									+" InvOfcCd : "+(tesEdiInitVO!=null?JSPUtil.getNull(tesEdiInitVO.getInvOfcCd()):"")
									+" <<<<<\n");
							
							exc_cols_n_val 	= TESeBillingManageUtil.getExcColsNVal(tesEdiRcvFltFileTagVOlist.get(i).getComTesEdiRcvFltFileXcldVOlist(), tesEdiInitVO);
							if (tab_cols!=null && tab_cols.length>0 && exc_cols_n_val!=null && exc_cols_n_val.length>0){
								ediDbDao.saveEDInvoiceTmpData(tesEdiRcvFltFileTagVOlist.get(i), hms, tab_cols, exc_cols_n_val, tesEdiInitVO);
							}
						} else {
							log.debug("\n ["+(JSPUtil.getNull(tesEdiRcvFltFileTagVOlist.get(i).getFltFileTagNm()))+"] no hm found!!! \n");
						}
					}
				}
			}
			
			/**
			 * 2) PSA DTL 후속 작업 : COST CODE MAPPING/YARD MAPPING/COST CODE로 INV유형 결정/VVD MAPPING 등
			 */
			ediDbDao.updateEDInvoicePSADTLTmp(eventResponse);
			
			/**
			 * 3) 기본 임시 저장소에 HDR/DTL/CNTRLIST에 정보 넣기까지 1번에서 다 마쳐야한다.
			 */
			ediDbDao.createEDInvoicePSAHDRTmpData(eventResponse);
			ediDbDao.updateEDInvoicePSADTLHDRseq(eventResponse);
			
			/**
			 * 4) VVD에 해당하는 ATB DATE를 찾아서 UPDATE한다.
			 */
			ediDbDao.updateEDInvoicePSADTLAtbDt(eventResponse);
			
		} catch(Exception e) {
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		}
		
		log.debug("\n  TESeBillingManageBizType000Impl-createEDIInvoiceData~~~~~EEEE \n");
	}
	
	/**
	 * <중> PSA는 기본적인 VALIDATION 단계에서 마지막에 한 과정을 더 걸친다.
	 *  ->  Invoice의 모든 비용이 NON-TES tariff로만 된 경우는 과감히 삭제처리한다. 물론 remark에 그런한 내용은 남긴다.
	 *   
	 * @param tesEdiSoHdrVO
	 * @param strRjctRmk
	 * @throws EventException
	 */
	protected void validateEDIInvoiceStep02(TesEdiSoHdrVO tesEdiSoHdrVO, String strRjctRmk) throws EventException {
		log.debug("\n TESeBillingManageDetailType003BCImpl-validateEDIInvoiceStep02 ---- BBBB \n");
		
		try {
			if (tesEdiSoHdrVO!=null){
				/**
				 * EDI invoice validation 확인 작업 완료 표시하고,
				 * 하나라도 자동 reject 건수가 있으면, REMARK값에 설정이 되고 AUTO REJECT 처리한다.
				 */			
				ediDbDao.setEDIInvoiceValidSts(tesEdiSoHdrVO, strRjctRmk);
				
				/**
				 * [PSA전용]
				 * 기본 수신단계에서 유효성 확인까지 마치고, NON-TES tariff로만 된 경우
				 * (물류 cost code와는 mapping이 되나 TES 전용 cost code와 mapping이 하나도 안된 경우) invoice를 자체를 삭제처리 하랍시요.
				 * 물론, rmk에 NON-TES어쩌구저쩌구 남긴다.
				 */					
				ediDbDao.deleteNonTESTariffInvoice(tesEdiSoHdrVO);
				
			} else {
				throw new EventException("\n TESeBillingManageDetailType003BCImpl - validateEDIInvoiceStep02 ERROR (NO TesEdiSoHdrVO FOUND)");
			}
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch(Exception e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		}
		log.debug("\n TESeBillingManageDetailType003BCImpl-validateEDIInvoiceStep02 ---- EEEE \n");
	}
	
	/**
	 * ESD 업무 시나리오 마감작업<br>
	 * TESeBillingManageDetailType003BCImpl업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		ediDbDao = null;
	}
}
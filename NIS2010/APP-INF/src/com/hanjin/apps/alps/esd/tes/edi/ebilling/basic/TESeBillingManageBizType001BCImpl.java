/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TESeBillingManageDetailType001BCImpl.java
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

//import java.util.HashMap;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.syscommon.common.table.TesEdiSoHdrVO;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.integration.TESeBillingManageBizType001DBDAO;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.util.TESeBillingManageParseUtil;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.vo.ComTesEdiRcvRuleMnVO;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.vo.ComTesEdiRcvRuleVndrMgmtVO;

/**
 * ALPS-ESD Business Logic Basic Command implementation<br>
 * - ALPS-ESD에 대한 비지니스 로직을 처리한다.<br>
 * 
 * TYPE1. HJNC/HJGT/KHH/TTIA(추가예정)
 *
 * @author 
 * @see TESeBillingManageBizType001BCImpl 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class TESeBillingManageBizType001BCImpl extends TESeBillingManageBizType000BCImpl {

	/**
	 * TES eBilling TYPE별 DBDAO
	 */
	private transient TESeBillingManageBizType001DBDAO ediDbDao = new TESeBillingManageBizType001DBDAO();
	
	/**
	 * TESeBillingManageDetailType001BCImpl default 객체 생성<br>
	 */
	public TESeBillingManageBizType001BCImpl() {
		super(new TESeBillingManageBizType001DBDAO());
	}

	/**
	 * TESeBillingManageDetailType001BCImpl dao 인자 객체 생성<br>
	 * @param ediDbDao
	 */
	public TESeBillingManageBizType001BCImpl(TESeBillingManageBizType001DBDAO ediDbDao) {
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
		log.error("\n\n bbbb -- TESeBillingManageBizType001BCImpl.getTagUnitData - ########################################### ");
		if (pars_mzd_cd!=null && !pars_mzd_cd.trim().equals("")){
			return new TESeBillingManageParseUtil(pars_mzd_cd).getTagUnitData(str_ff, tag_nm);
		} else {
			return null;
		}
	}
	
	
	/**
	 * EDI invoice 저장시 첫번째 단계 처리
	 * 
	 * @param eventResponse
	 * @throws EventException
	 */
	protected void createEDIInvoiceData2Step01(EventResponse eventResponse) throws EventException {
		log.error("\n\n TESeBillingManageBizType001BCImpl.createEDIInvoiceData2Step01 - ########################################### ");
		
		TesEdiSoHdrVO invVO = null;
		ComTesEdiRcvRuleMnVO tesEdiRuleMainVO = null;
		ComTesEdiRcvRuleVndrMgmtVO tesEdiRcvRuleVndrMgmtVO = null;
		
		try {
			invVO = (TesEdiSoHdrVO)((GeneralEventResponse)eventResponse).getCustomData(TESeBillingCommonBC.INV_HDR);
			tesEdiRuleMainVO	= (ComTesEdiRcvRuleMnVO)((GeneralEventResponse)eventResponse).getCustomData(TESeBillingCommonBC.EDI_RULE_MAIN);
			tesEdiRcvRuleVndrMgmtVO = tesEdiRuleMainVO.getComTesEdiRcvRuleVndrMgmtVO();
			if (tesEdiRcvRuleVndrMgmtVO!=null){
				if (tesEdiRcvRuleVndrMgmtVO.getCostOfcMdmRefFlg()!=null && tesEdiRcvRuleVndrMgmtVO.getCostOfcMdmRefFlg().trim().equals("Y")){
					/**
					 * Cost Ofc가 안 넘어왔거나 mapping이 안된 경우 EDI Rule에 딸 MDM YARD를 참조하여 설정한다.
					 */
					ediDbDao.updateEDInvoiceTmpCostOfc(invVO);
				}
				if (tesEdiRcvRuleVndrMgmtVO.getStoPrdDtChkFlg()!=null && tesEdiRcvRuleVndrMgmtVO.getStoPrdDtChkFlg().trim().equals("Y")){
					if (JSPUtil.getNull(invVO.getTmlInvTpCd()).trim().equals("ST")){
						/**
						 * Storage invoice의 경우 FM PRD DT와 TO PRD DT를 안 주는 경우 EDI Rule에 따라 Gate In/Out의 최소/최대 값으로 기본 설정한다.
						 * 여기서 넣지 않을 경우 정규 invoice로 변환시 설정한다.
						 */
						ediDbDao.updateEDInvoiceTmpFmToDt(invVO);
					}
				}
				if (JSPUtil.getNull(tesEdiRcvRuleVndrMgmtVO.getImplSubTpCd()).trim().equals("001")){
					/** KHH의 예외처리: VAT는 INVOICE AMT의 10%와 CURR_CD는 TWD로 update하기 **/
					ediDbDao.updateEDInvoiceVATamtNCurr(invVO);
				}
			}
		} catch(DAOException e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		} catch(Exception e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		}
		log.error("\n\n END - TESeBillingManageBizType001BCImpl.createEDIInvoiceData2Step01 - ########################################### ");
	}
	
	/**
	 * ESD 업무 시나리오 마감작업<br>
	 * TESeBillingManageDetailType001BCImpl업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		ediDbDao = null;
	}
}
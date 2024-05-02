/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0016Event.java
*@FileTitle : Charterer's Account
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.13
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.04.13 정윤태
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event;

import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondCharterInvoiceVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomInvDtlVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomInvoiceVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomSdmsSettlementVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCharterInvoiceListVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0016 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0016HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JUNGINSUN
 * @see ESM_FMS_0016HTMLAction 참조
 * @since J2EE 1.5
 */

public class EsmFms0016Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** FletCtrlNo 계약번호 */
	private String fletCtrtNo = "";

	/** revYrmon Target Month */
	private String revYrmon = "";

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchCharterInvoiceListVO searchCharterIniceListVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CondCharterInvoiceVO condCharterInvoiceVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomInvoiceVO customInvoiceVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomInvDtlVO[] customInvDtlVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomSdmsSettlementVO[] customSdmsSettlementVOs = null;

	public EsmFms0016Event(){}
	
	public void setSearchCharterIniceListVO(SearchCharterInvoiceListVO searchCharterIniceListVO){
		this.searchCharterIniceListVO = searchCharterIniceListVO;
	}
	
	public void setCondCharterInvoiceVO(CondCharterInvoiceVO condCharterInvoiceVO){
		this.condCharterInvoiceVO = condCharterInvoiceVO;
	}
	
	public void setCustomInvoiceVO(CustomInvoiceVO customInvoiceVO){
		this.customInvoiceVO = customInvoiceVO;
	}

	public void setCustomInvDtlVOS(CustomInvDtlVO[] customInvDtlVOs){
		if (customInvDtlVOs != null) {
			CustomInvDtlVO[] tmpVOs = new CustomInvDtlVO[customInvDtlVOs.length];
			System.arraycopy(customInvDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.customInvDtlVOs = tmpVOs;
		}
	}

	public CustomInvoiceVO getCustomInvoiceVO(){
		return customInvoiceVO;
	}
	
	public SearchCharterInvoiceListVO getSearchCharterIniceListVO(){
		return searchCharterIniceListVO;
	}
	
	public CondCharterInvoiceVO getCondCharterInvoiceVO(){
		return condCharterInvoiceVO;
	}

	public CustomInvDtlVO[] getCustomInvDtlVOS(){
		CustomInvDtlVO[] tmpVOs = null;
		if (this.customInvDtlVOs != null) {
			tmpVOs = new CustomInvDtlVO[customInvDtlVOs.length];
			System.arraycopy(customInvDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public String getFletCtrtNo() {
		return fletCtrtNo;
	}
	
	public CustomSdmsSettlementVO[] getCustomSdmsSettlementVOS(){
		CustomSdmsSettlementVO[] tmpVOs = null;
		if (this.customSdmsSettlementVOs != null) {
			tmpVOs = new CustomSdmsSettlementVO[customSdmsSettlementVOs.length];
			System.arraycopy(customSdmsSettlementVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public void setCustomSdmsSettlementVOS(CustomSdmsSettlementVO[] customSdmsSettlementVOs){
		if (customSdmsSettlementVOs != null) {
			CustomSdmsSettlementVO[] tmpVOs = new CustomSdmsSettlementVO[customSdmsSettlementVOs.length];
			System.arraycopy(customSdmsSettlementVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.customSdmsSettlementVOs = tmpVOs;
		}
	}

	public void setFletCtrtNo(String fletCtrtNo) {
		this.fletCtrtNo = fletCtrtNo;
	}
	
	public String getRevYrmon() {
		return revYrmon;
	}

	public void setRevYrmon(String revYrmon) {
		this.revYrmon = revYrmon;
	}

}
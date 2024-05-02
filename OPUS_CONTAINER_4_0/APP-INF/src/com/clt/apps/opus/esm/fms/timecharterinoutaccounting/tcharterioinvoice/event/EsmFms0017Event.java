/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0017Event.java
*@FileTitle : SDMS - Window
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.09.11 정윤태
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event;

import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomSdmsSettlementVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0017 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0017HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JUNGYOONTAE
 * @see ESM_FMS_0017HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmFms0017Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** fletCtrtNo */
	private String fletCtrtNo = "";

	/** vslCd vesselCode */
	private String vslCd = "";
	
	/** 전표 승인여부 */
	private String appFlg = "";

	/** Duration From */
	private String fromPayDt = "";

	/** Duration To */
	private String toPayDt = "";
	
	/** INV No */
	private String invNo = "";
	
	/** Table Value Object Multi Data 처리 */
	private CustomSdmsSettlementVO[] customSdmsSettlementVOs = null;
	
	public EsmFms0017Event(){}
	
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

	public String getFletCtrtNo() {
		return fletCtrtNo;
	}

	public void setFletCtrtNo(String fletCtrtNo) {
		this.fletCtrtNo = fletCtrtNo;
	}
	
	public String getVslCd() {
		return vslCd;
	}

	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	public String getAppFlg() {
		return appFlg;
	}

	public void setAppFlg(String appFlg) {
		this.appFlg = appFlg;
	}
	
	public String getFromPayDt() {
		return fromPayDt;
	}

	public void setFromPayDt(String fromPayDt) {
		this.fromPayDt = fromPayDt;
	}

	public String getToPayDt() {
		return toPayDt;
	}

	public void setToPayDt(String toPayDt) {
		this.toPayDt = toPayDt;
	}
	
	public String getInvNo() {
		return invNo;
	}

	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
}
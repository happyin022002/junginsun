/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0056Event.java
*@FileTitle : Invoice File import
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.06.22 진준성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containercostanalysis.onoffhireaudit.event;

import com.clt.apps.opus.ees.lse.containercostanalysis.onoffhireaudit.vo.OnOffHireAuditSearchVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ees_lse_0056 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_lse_0056HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jin Jun Sung
 * @see ees_lse_0056HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesLse0056Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OnOffHireAuditSearchVO onOffHireAuditSearchVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private OnOffHireAuditSearchVO[] onOffHireAuditSearchVOs = null;

	private String refNo = null;
	
	public EesLse0056Event(){}
	
	public void setOnOffHireAuditSearchVO(OnOffHireAuditSearchVO onOffHireAuditSearchVO){
		this.onOffHireAuditSearchVO = onOffHireAuditSearchVO;
	}
	public void setOnOffHireAuditSearchVOS(OnOffHireAuditSearchVO[] onOffHireAuditSearchVOs){
		if (onOffHireAuditSearchVOs != null) {
			OnOffHireAuditSearchVO[] tmpVOs = new OnOffHireAuditSearchVO[onOffHireAuditSearchVOs.length];
			System.arraycopy(onOffHireAuditSearchVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.onOffHireAuditSearchVOs = tmpVOs;
		}
	}	
	public void setRefNo(String ref_no){
		this.refNo = ref_no;
	}
	public OnOffHireAuditSearchVO getOnOffHireAuditSearchVO(){
		return onOffHireAuditSearchVO;
	}
	public OnOffHireAuditSearchVO[] getOnOffHireAuditSearchVOS(){
		OnOffHireAuditSearchVO[] tmpVOs = null;
		if (this.onOffHireAuditSearchVOs != null) {
			tmpVOs = new OnOffHireAuditSearchVO[onOffHireAuditSearchVOs.length];
			System.arraycopy(onOffHireAuditSearchVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}	
	public String getRefNo(){
		return refNo;
	}
}
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt3007AEvent.java
*@FileTitle : Demand Note Issue Preview
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.09.18 최성환
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.event;

import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNoteRDParmVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_DMT_3007_2 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_3007AHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Sung Hwan
 * @see EES_DMT_3007AHTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt3007AEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DemandNoteRDParmVO demandNoteRDParmVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private DemandNoteRDParmVO[] demandNoteRDParmVOs = null;
	
	public EesDmt3007AEvent(){}
	
	public void setDemandNoteRDParmVO(DemandNoteRDParmVO demandNoteRDParmVO){
		this. demandNoteRDParmVO = demandNoteRDParmVO;
	}
	
	public void setDemandNoteRDParmVOS(DemandNoteRDParmVO[] demandNoteRDParmVOs){
		if (demandNoteRDParmVOs != null) {
			DemandNoteRDParmVO[] tmpVOs = new DemandNoteRDParmVO[demandNoteRDParmVOs.length];
			System.arraycopy(demandNoteRDParmVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.demandNoteRDParmVOs = tmpVOs;
		}
	}
	
	public DemandNoteRDParmVO getDemandNoteRDParmVO(){
		return demandNoteRDParmVO;
	}
	
	public DemandNoteRDParmVO[] getDemandNoteRDParmVOS(){
		DemandNoteRDParmVO[] tmpVOs = null;
		if (this.demandNoteRDParmVOs != null) {
			tmpVOs = new DemandNoteRDParmVO[demandNoteRDParmVOs.length];
			System.arraycopy(demandNoteRDParmVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
}
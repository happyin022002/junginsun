/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt3013Event.java
*@FileTitle : Demand Note Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.09.18 최성환
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.event;

import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNoteListParmVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_DMT_3013 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_3013HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Sung Hwan
 * @see EES_DMT_3013HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt3013Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DemandNoteListParmVO demandNoteListParmVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private DemandNoteListParmVO[] demandNoteListParmVOS = null;

	public EesDmt3013Event(){}
	
	public void setDemandNoteListParmVO(DemandNoteListParmVO demandNoteListParmVO){
		this. demandNoteListParmVO = demandNoteListParmVO;
	}

	public void setDemandNoteListParmVOS(DemandNoteListParmVO[] demandNoteListParmVOS){
		if (demandNoteListParmVOS != null) {
			DemandNoteListParmVO[] tmpVOs = new DemandNoteListParmVO[demandNoteListParmVOS.length];
			System.arraycopy(demandNoteListParmVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.demandNoteListParmVOS = tmpVOs;
		}
	}

	public DemandNoteListParmVO getDemandNoteListParmVO(){
		return demandNoteListParmVO;
	}

	public DemandNoteListParmVO[] getDemandNoteListParmVOS(){
		DemandNoteListParmVO[] tmpVOs = null;
		if (this.demandNoteListParmVOS != null) {
			tmpVOs = new DemandNoteListParmVO[demandNoteListParmVOS.length];
			System.arraycopy(demandNoteListParmVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}
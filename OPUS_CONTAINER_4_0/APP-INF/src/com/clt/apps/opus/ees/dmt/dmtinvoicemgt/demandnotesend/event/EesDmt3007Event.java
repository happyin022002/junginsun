/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt3007Event.java
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

import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNotePreviewParmVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_DMT_3007 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_3007HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Sung Hwan
 * @see EES_DMT_3007HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt3007Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DemandNotePreviewParmVO demandNotePreviewParmVO = null;
	
	public EesDmt3007Event(){}
	
	public void setDemandNotePreviewParmVO(DemandNotePreviewParmVO demandNotePreviewParmVO){
		this. demandNotePreviewParmVO = demandNotePreviewParmVO;
	}

	public DemandNotePreviewParmVO getDemandNotePreviewParmVO(){
		return demandNotePreviewParmVO;
	}

}
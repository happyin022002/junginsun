/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsmPri0140Event.java
*@FileTitle : MOT/SSE Filing Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.24
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2014.04.24 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchMOTSSEFilingListVO;


/**
 * ESM_PRI_0140 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0140HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SongHoJin
 * @see ESM_PRI_0140HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri0140Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	RsltSearchMOTSSEFilingListVO[] rsltSearchMOTSSEFilingListVOs = null;

	public EsmPri0140Event(){}
	
	public void setRsltSearchMOTSSEFilingListVO(RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO){
		this. rsltSearchMOTSSEFilingListVO = rsltSearchMOTSSEFilingListVO;
	}

	public void setRsltSearchMOTSSEFilingListVOS(RsltSearchMOTSSEFilingListVO[] rsltSearchMOTSSEFilingListVOs){
		this. rsltSearchMOTSSEFilingListVOs = rsltSearchMOTSSEFilingListVOs;
	}

	public RsltSearchMOTSSEFilingListVO getRsltSearchMOTSSEFilingListVO(){
		return rsltSearchMOTSSEFilingListVO;
	}

	public RsltSearchMOTSSEFilingListVO[] getRsltSearchMOTSSEFilingListVOS(){
		return rsltSearchMOTSSEFilingListVOs;
	}

}
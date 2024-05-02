/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsmPri0141Event.java
*@FileTitle : MOT/SSE Tariff 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.25
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2014.04.25 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriMotTrfMnVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchMOTSSEFilingListVO;


/**
 * ESM_PRI_0141 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0141HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SongHoJin
 * @see ESM_PRI_0141HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri0141Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	RsltSearchMOTSSEFilingListVO[] rsltSearchMOTSSEFilingListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	PriMotTrfMnVO priMotTrfMnVO = null;
	
	public EsmPri0141Event(){}
	
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

	public void setPriMotTrfMnVO(PriMotTrfMnVO priMotTrfMnVO){
		this. priMotTrfMnVO = priMotTrfMnVO;
	}

	public PriMotTrfMnVO getPriMotTrfMnVO(){
		return priMotTrfMnVO;
	}

}
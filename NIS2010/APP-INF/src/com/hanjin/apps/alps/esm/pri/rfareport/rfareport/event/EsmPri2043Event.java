/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri2043Event.java
*@FileTitle : RFA Retrieve
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.20
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.09.20 김대호
* 1.0 Creation
=========================================================
* History
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfareport.rfareport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.vo.RsltSearchRFAListVO;

/**
 * ESM_PRI_2043 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_2043HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Byeon Young Joo
 * @see ESM_PRI_2043HTMLAction 참조
 * @since J2EE 1.6
 */
 
public class EsmPri2043Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltSearchRFAListVO rsltSearchRFAListVO = null;
	/** Table Value Object Multi Data 처리 */
	private RsltSearchRFAListVO[] rsltSearchRFAListVOs = null;

	public EsmPri2043Event(){}
	
	/* set */
	public void setRsltSearchRFAListVO(RsltSearchRFAListVO rsltSearchRFAListVO){
		this.rsltSearchRFAListVO = rsltSearchRFAListVO;
	}
	public void setRsltSearchRFAListVOS(RsltSearchRFAListVO[] rsltSearchRFAListVOs){
		if(rsltSearchRFAListVOs != null){
			RsltSearchRFAListVO[] tmpVOs = new RsltSearchRFAListVO[rsltSearchRFAListVOs.length];
			System.arraycopy(rsltSearchRFAListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltSearchRFAListVOs = tmpVOs;
		}
	}
	
	/* get */
	public RsltSearchRFAListVO getRsltSearchRFAListVO(){
		return rsltSearchRFAListVO;
	}
	public RsltSearchRFAListVO[] getRsltSearchRFAListVOS(){
		RsltSearchRFAListVO[] rtnVOs = null;
		if (this.rsltSearchRFAListVOs != null) {
			rtnVOs = new RsltSearchRFAListVO[rsltSearchRFAListVOs.length];
			System.arraycopy(rsltSearchRFAListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}
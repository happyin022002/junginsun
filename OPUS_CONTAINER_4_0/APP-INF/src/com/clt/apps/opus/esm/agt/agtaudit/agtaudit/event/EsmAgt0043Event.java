/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsmAgt0043Event.java
*@FileTitle : Agent Commission CSR Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2007-03-12
*@LastModifier : Jung-Hyung,Kim
*@LastVersion : 1.0
* 2007-03-12 Jung-Hyung,Kim
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.agtaudit.event;

import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.CSRDetailforCommissionDtrbVO;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.CSRDetailforCommissionHdrVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EsmAgt0043Event 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_AGT_043HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Junghyung_kim
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmAgt0043Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;

	private CSRDetailforCommissionHdrVO csrDetailforCommissionHdrVO = null;
	
	private CSRDetailforCommissionHdrVO[] csrDetailforCommissionHdrVOS = null;
	
	private CSRDetailforCommissionDtrbVO csrDetailforCommissionDtrbVO = null;
	
	private CSRDetailforCommissionDtrbVO[] csrDetailforCommissionDtrbVOS = null;
	
	public EsmAgt0043Event(){}

	public CSRDetailforCommissionHdrVO getCsrDetailforCommissionHdrVO() {
    	return csrDetailforCommissionHdrVO;
    }

	public void setCsrDetailforCommissionHdrVO(CSRDetailforCommissionHdrVO csrDetailforCommissionHdrVO) {
    	this.csrDetailforCommissionHdrVO = csrDetailforCommissionHdrVO;
    }

	public CSRDetailforCommissionHdrVO[] getCsrDetailforCommissionHdrVOS() {
    	return csrDetailforCommissionHdrVOS;
    }

	public void setCsrDetailforCommissionHdrVOS(CSRDetailforCommissionHdrVO[] csrDetailforCommissionHdrVOS) {
    	this.csrDetailforCommissionHdrVOS = csrDetailforCommissionHdrVOS;
    }

	public CSRDetailforCommissionDtrbVO getCsrDetailforCommissionDtrbVO() {
    	return csrDetailforCommissionDtrbVO;
    }

	public void setCsrDetailforCommissionDtrbVO(CSRDetailforCommissionDtrbVO csrDetailforCommissionDtrbVO) {
    	this.csrDetailforCommissionDtrbVO = csrDetailforCommissionDtrbVO;
    }

	public CSRDetailforCommissionDtrbVO[] getCsrDetailforCommissionDtrbVOS() {
    	return csrDetailforCommissionDtrbVOS;
    }

	public void setCsrDetailforCommissionDtrbVOS(CSRDetailforCommissionDtrbVO[] csrDetailforCommissionDtrbVOS) {
    	this.csrDetailforCommissionDtrbVOS = csrDetailforCommissionDtrbVOS;
    }
	
	
}

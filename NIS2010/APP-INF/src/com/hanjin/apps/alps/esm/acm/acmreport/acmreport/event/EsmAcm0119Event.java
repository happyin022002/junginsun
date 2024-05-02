/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsmAcm0119Event.java
*@FileTitle : Agent Commission CSR Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2014-06-11
*@LastModifier : Da-eun, PARK
*@LastVersion : 1.0
* 2014-06-11 Da-eun, PARK
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmreport.acmreport.event;

import com.hanjin.apps.alps.esm.acm.acmreport.acmreport.vo.CSRDetailforCommissionVO;
import com.hanjin.apps.alps.esm.acm.acmreport.acmreport.vo.CSRDetailforCommissionHdVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_ACM_0119 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_ACM_0119HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author PARK, Da-eun
 * @see ESM_ACM_0110HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmAcm0119Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;

	private CSRDetailforCommissionHdVO csrDetailforCommissionHdVO = null;
	
	private CSRDetailforCommissionHdVO[] csrDetailforCommissionHdVOS = null;
	
	private CSRDetailforCommissionVO csrDetailforCommissionVO = null;
	
	private CSRDetailforCommissionVO[] csrDetailforCommissionVOS = null;
	
	public EsmAcm0119Event(){}

	public CSRDetailforCommissionHdVO getCsrDetailforCommissionHdVO() {
    	return csrDetailforCommissionHdVO;
    }

	public void setCsrDetailforCommissionHdVO(CSRDetailforCommissionHdVO csrDetailforCommissionHdVO) {
    	this.csrDetailforCommissionHdVO = csrDetailforCommissionHdVO;
    }

	public CSRDetailforCommissionHdVO[] getCsrDetailforCommissionHdVOS() {
    	return csrDetailforCommissionHdVOS;
    }

	public void setCsrDetailforCommissionHdVOS(CSRDetailforCommissionHdVO[] csrDetailforCommissionHdrVOS) {
    	this.csrDetailforCommissionHdVOS = csrDetailforCommissionHdrVOS;
    }

	public CSRDetailforCommissionVO getCsrDetailforCommissionVO() {
    	return csrDetailforCommissionVO;
    }

	public void setCsrDetailforCommissionVO(CSRDetailforCommissionVO csrDetailforCommissionVO) {
    	this.csrDetailforCommissionVO = csrDetailforCommissionVO;
    }

	public CSRDetailforCommissionVO[] getCsrDetailforCommissionVOS() {
    	return csrDetailforCommissionVOS;
    }

	public void setCsrDetailforCommissionVOS(CSRDetailforCommissionVO[] csrDetailforCommissionVOS) {
    	this.csrDetailforCommissionVOS = csrDetailforCommissionVOS;
    }
	
	
}

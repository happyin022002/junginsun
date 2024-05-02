/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmPri0072Event.java
 *@FileTitle : Rate Guideline Inquiry - Origin & Destination
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.30
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.09.30 박성수
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.event;

import com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.vo.RsltRtRoutPntListVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * UI_PRI_0021 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_PRI_0021HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Kong Back Jin
 * @see ESM_PRI_0021HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri0072Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private RsltRtRoutPntListVO rsltrtroutpntlistvo = null;

	public EsmPri0072Event() {
	}

	public void setRsltRtRoutPntListVO(RsltRtRoutPntListVO rsltrtroutpntlistvo) {
		this.rsltrtroutpntlistvo = rsltrtroutpntlistvo;
	}

	public RsltRtRoutPntListVO getRsltRtRoutPntListVO() {
		return rsltrtroutpntlistvo;
	}

}
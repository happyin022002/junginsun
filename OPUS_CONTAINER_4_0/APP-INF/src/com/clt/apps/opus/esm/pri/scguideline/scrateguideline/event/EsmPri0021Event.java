/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UiPri0021Event.java
 *@FileTitle : Rate Guideline Creation - Route Point
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.07
 *@LastModifier : 공백진
 *@LastVersion : 1.0
 * 2009.05.07 공백진
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline.scrateguideline.event;

import com.clt.apps.opus.esm.pri.scguideline.scrateguideline.vo.RsltRtRoutPntListVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * UI_PRI_0021 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_PRI_0021HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Kong Back Jin
 * @see ESM_PRI_0021HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri0021Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private RsltRtRoutPntListVO rsltrtroutpntlistvo = null;
	
	public EsmPri0021Event() {
	}

	public void setRsltRtRoutPntListVO(RsltRtRoutPntListVO rsltrtroutpntlistvo) {
		this.rsltrtroutpntlistvo = rsltrtroutpntlistvo;
	}

	public RsltRtRoutPntListVO getRsltRtRoutPntListVO() {
		return rsltrtroutpntlistvo;
	}

}
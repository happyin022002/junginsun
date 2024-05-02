/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmPri2079Event.java
 *@FileTitle : RFA Guideline Inquiry - Rate (Route Point)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.30
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.09.30 박성수
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.event;

import com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.vo.RsltRtRoutPntListVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * UI_PRI_0021 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_PRI_0021HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Kong Back Jin
 * @see ESM_PRI_2077HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri2079Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private RsltRtRoutPntListVO rsltrtroutpntlistvo = null;

	public EsmPri2079Event() {
	}

	public void setRsltRtRoutPntListVO(RsltRtRoutPntListVO rsltrtroutpntlistvo) {
		this.rsltrtroutpntlistvo = rsltrtroutpntlistvo;
	}

	public RsltRtRoutPntListVO getRsltRtRoutPntListVO() {
		return rsltrtroutpntlistvo;
	}

}
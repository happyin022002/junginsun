/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmPri2076Event.java
 *@FileTitle : Rate Creation - Commodity 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.06
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.08.06 박성수
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaguideline.rfarateguideline.event;

import com.hanjin.apps.alps.esm.pri.rfaguideline.rfarateguideline.vo.RsltRtRoutPntListVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * UI_PRI_0106 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_PRI_0106HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Kong Back Jin
 * @see ESM_PRI_2076HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri2076Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private RsltRtRoutPntListVO rsltrtroutpntlistvo = null;

	public EsmPri2076Event() {
	}

	public void setRsltRtRoutPntListVO(RsltRtRoutPntListVO rsltrtroutpntlistvo) {
		this.rsltrtroutpntlistvo = rsltrtroutpntlistvo;
	}

	public RsltRtRoutPntListVO getRsltRtRoutPntListVO() {
		return rsltrtroutpntlistvo;
	}

}
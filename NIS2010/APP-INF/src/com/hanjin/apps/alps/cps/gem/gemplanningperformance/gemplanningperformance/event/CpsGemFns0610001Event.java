/*=========================================================
 * Copyright(c) 2006 CyberLogitec
 * @FileName : CpsGemFns0610001Event.java
 * @FileTitle : ERP(A/P)에서 일반관리비 집계대상 전표에 대하여 승인자 정보를 수신한다.
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2009-06-25
 * @LastModifier : choijungmi
 * @LastVersion : 1.0
 * 2009-06-25 choijungmi
 * 
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.event;

import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.GemSlpPerfVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * FNS061_0001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * FNS061_0001HTMLAction에서 작성<br>
 * ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author choijungmi
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class CpsGemFns0610001Event extends EventSupport {
	private static final long serialVersionUID = 6498880634263177698L;
	/*
	public XmlObject xmlObject = null;

	public XmlObject getXmlObject() {
		return xmlObject;
	}

	public void setXmlObject(XmlObject xmlObject) {
		this.xmlObject = xmlObject;
	}
	*/

	public GemSlpPerfVO gemSlpPerfVO = null;
	public GemSlpPerfVO[] gemSlpPerfVOs = null;

	public GemSlpPerfVO getGemSlpPerfVO() {
		return gemSlpPerfVO;
	}

	public void setGemSlpPerfVO(GemSlpPerfVO gemSlpPerfVO) {
		this.gemSlpPerfVO = gemSlpPerfVO;
	}

	public GemSlpPerfVO[] getGemSlpPerfVOs() {
		return gemSlpPerfVOs;
	}

	public void setGemSlpPerfVOs(GemSlpPerfVO[] gemSlpPerfVOs) {
		this.gemSlpPerfVOs = gemSlpPerfVOs;
	}
}
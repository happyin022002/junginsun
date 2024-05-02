/*=========================================================
 * Copyright(c) 2006 CyberLogitec
 * @FileName : CpsGemFns0090001Event.java
 * @FileTitle : ERP(A/P)에서 일반관리비 집계대상 전표에 대하여 GEM로 인터페이스 한다
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2009-06-16
 * @LastModifier : choijungmi
 * @LastVersion : 1.0
 * 2009-06-16 choijungmi
 * 
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.event;

import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.GemSlpIfVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * FNS009_0001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * FNS009_0001HTMLAction에서 작성<br>
 * ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author choijungmi
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class CpsGemFns0090001Event extends EventSupport {
	private static final long serialVersionUID = -3185463831351987650L;
	/*
	public XmlObject xmlObject = null;

	public XmlObject getXmlObject() {
		return xmlObject;
	}

	public void setXmlObject(XmlObject xmlObject) {
		this.xmlObject = xmlObject;
	}
	*/

	public GemSlpIfVO gemSlpIfVO = null;
	public GemSlpIfVO[] gemSlpIfVOs = null;

	public GemSlpIfVO getGemSlpIfVO() {
		return gemSlpIfVO;
	}

	public void setGemSlpIfVO(GemSlpIfVO gemSlpIfVO) {
		this.gemSlpIfVO = gemSlpIfVO;
	}

	public GemSlpIfVO[] getGemSlpIfVOs() {
		return gemSlpIfVOs;
	}

	public void setGemSlpIfVOs(GemSlpIfVO[] gemSlpIfVOs) {
		this.gemSlpIfVOs = gemSlpIfVOs;
	}

}
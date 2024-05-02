/*=========================================================
 * Copyright(c) 2006 CyberLogitec
 * @FileName : CpsGemFns0030001Event.java
 * @FileTitle : ERP(G/L)에서 일반관리비 집계대상 전표에 대하여 회계마감 이후 GEM로 인터페이스 한다.
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

import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.GemSlpIfVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * FNS003_0001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * FNS003_0001HTMLAction에서 작성<br>
 * ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author choijungmi
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class CpsGemFns0030001Event extends EventSupport {
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
/*=========================================================
 * Copyright(c) 2006 CyberLogitec
 * @FileName : CpsGem0032Event.java
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
package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.event;

import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.ActRsltSubsPerfVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.GemSlpIfVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * FNS009_0001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * FNS009_0001HTMLAction에서 작성<br>
 * ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author choijungmi
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class CpsGem0032Event extends EventSupport {
	private static final long serialVersionUID = -3185463831351987650L;

	private String ofcCd   = "";
	private String glEffDt = "";
	private String slpIfFlg = "";

	private GemSlpIfVO gemSlpIfVO = null;
	private GemSlpIfVO[] gemSlpIfVOs = null;
	private ActRsltSubsPerfVO actRsltSubsPerfVO = null;
	private ActRsltSubsPerfVO[] actRsltSubsPerfVOs = null;

	/**
	 * @return the actRsltSubsPerfVO
	 */
	public ActRsltSubsPerfVO getActRsltSubsPerfVO() {
		return actRsltSubsPerfVO;
	}
	/**
	 * @param actRsltSubsPerfVO the actRsltSubsPerfVO to set
	 */
	public void setActRsltSubsPerfVO(ActRsltSubsPerfVO actRsltSubsPerfVO) {
		this.actRsltSubsPerfVO = actRsltSubsPerfVO;
	}
	
	/**
	 * @return the actRsltSubsPerfVOs
	 */
	public ActRsltSubsPerfVO[] getActRsltSubsPerfVOs() {
		return actRsltSubsPerfVOs;
	}
	/**
	 * @param actRsltSubsPerfVOs the actRsltSubsPerfVOs to set
	 */
	public void setActRsltSubsPerfVOs(ActRsltSubsPerfVO[] actRsltSubsPerfVOs) {
		this.actRsltSubsPerfVOs = actRsltSubsPerfVOs;
	}	

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

	public String getOfcCd() {
		return ofcCd;
	}

	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	public String getGlEffDt() {
		return glEffDt;
	}

	public void setGlEffDt(String glEffDt) {
		this.glEffDt = glEffDt;
	}
	
	public String getSlpIfFlg() {
		return slpIfFlg;
	}
	public void setSlpIfFlg(String slpIfFlg) {
		this.slpIfFlg = slpIfFlg;
	}
}
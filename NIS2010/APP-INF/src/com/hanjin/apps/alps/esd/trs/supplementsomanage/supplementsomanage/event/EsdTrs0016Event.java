/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_016Event.java
*@FileTitle : Service Order 생성-Supplement
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-30
*@LastModifier : juhyun
*@LastVersion : 1.0
* 2006-10-30 juhyun
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.supplementsomanage.supplementsomanage.event;

import java.util.Collection;
import java.util.HashMap;

import com.hanjin.apps.alps.esd.trs.invoicemanage.surchargeinputinquiry.vo.SurchargeVO;
import com.hanjin.apps.alps.esd.trs.supplementsomanage.supplementsomanage.vo.SupplementSearchVO;
import com.hanjin.apps.alps.esd.trs.supplementsomanage.supplementsomanage.vo.SupplementVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_TRS_016 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_016HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author juhyun
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0016Event extends EventSupport {
	
	/** Supplement Target 조회를 위한 VO	 */
	private  SupplementSearchVO supplementSearchVO = null;
	
	/** supplementVO Table  Value Object */
	private SupplementVO supplementVO = null;

	/** supplementVOs Multi Action을 위한 Collection */
	//private Collection supplementVOs = null;
	private SupplementVO[] supplementVOs = null;

	/** supplementVOs Multi Action을 위한 Collection */
	//private Collection surchargeVO = null;
	private SurchargeVO surchargeVO = null;
	private SurchargeVO[] surchargeVOs = null;

	private Collection trsTrspScgDtls = null;

	/** select 변수 (Form 객체) */
	private HashMap hashParam = new HashMap();

	/** ESD_TRS_016Event */
	public EsdTrs0016Event(){}

	/** ESD_TRS_016Event */
	/**
	 * @param supplementVO
	 */
	public EsdTrs0016Event(SupplementVO supplementVO) {
		this.supplementVO = supplementVO;
    }

	/**
	 * @return the supplementSearchVO
	 */
	public SupplementSearchVO getSupplementSearchVO() {
		return supplementSearchVO;
	}

	/**
	 * @param supplementSearchVO the supplementSearchVO to set
	 */
	public void setSupplementSearchVO(SupplementSearchVO supplementSearchVO) {
		this.supplementSearchVO = supplementSearchVO;
	}

	/**
	 * @return the supplementVOs
	 */
	public SupplementVO[] getSupplementVOs() {
		return supplementVOs;
	}

	/**
	 * @param supplementVOs the supplementVOs to set
	 */
	public void setSupplementVOs(SupplementVO[] supplementVOs) {
		this.supplementVOs = supplementVOs;
	}

	/**
	 * @return the surchargeVO
	 */
	public SurchargeVO getSurchargeVO() {
		return surchargeVO;
	}

	/**
	 * @param surchargeVO the surchargeVO to set
	 */
	public void setSurchargeVO(SurchargeVO surchargeVO) {
		this.surchargeVO = surchargeVO;
	}

	/**
	 * @return the surchargeVOs
	 */
	public SurchargeVO[] getSurchargeVOs() {
		return surchargeVOs;
	}

	/**
	 * @param surchargeVOs the surchargeVOs to set
	 */
	public void setSurchargeVOs(SurchargeVO[] surchargeVOs) {
		this.surchargeVOs = surchargeVOs;
	}

	/**
	 * @param supplementVO the supplementVO to set
	 */
	public void setSupplementVO(SupplementVO supplementVO) {
		this.supplementVO = supplementVO;
	}

	/** getSupplementVO */
	public SupplementVO getSupplementVO(){
		return supplementVO;
	}

	/** setTRS_TRSP_SCG_DTLS */
	public void setTRS_TRSP_SCG_DTLS(Collection trs_trsp_scg_dtlsValue){
		this.trsTrspScgDtls = trs_trsp_scg_dtlsValue;
	}

	/** getHashParam */
	public HashMap getHashParam() {
		return hashParam;
	}

	/** setHashParam */
	public void setHashParam(HashMap hashParamValue){
		this.hashParam = hashParamValue;
	}

	/** getEventName */
	public String getEventName() {
		return "EsdTrs0016Event";
	}

	/** toString */
	public String toString() {
		return "EsdTrs0016Event";
	}

}

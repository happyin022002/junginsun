/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri6001Event.java
*@FileTitle : CMPB Guideline Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.06.30 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.event;

import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo.RsltCmpbGuidelineVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_6001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Seung-Jun,Lee
 * @see ESM_PRI_6001HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri6003Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltCmpbGuidelineVO rsltCmpbGuidelineVO = null;

	/**
	 * @return the rsltCmpbGuidelineVO
	 */
	public RsltCmpbGuidelineVO getRsltCmpbGuidelineVO() {
		return rsltCmpbGuidelineVO;
	}

	/**
	 * @param rsltCmpbGuidelineVO the rsltCmpbGuidelineVO to set
	 */
	public void setRsltCmpbGuidelineVO(RsltCmpbGuidelineVO rsltCmpbGuidelineVO) {
		this.rsltCmpbGuidelineVO = rsltCmpbGuidelineVO;
	}

	
	
}
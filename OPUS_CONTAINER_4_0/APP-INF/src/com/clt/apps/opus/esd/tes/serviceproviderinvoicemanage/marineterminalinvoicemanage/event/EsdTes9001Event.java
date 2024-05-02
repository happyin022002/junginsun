/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName :  EsdTes9001Event.java
*@FileTitle : Get Container List Pop Up
*Open Issues : 
*Change history :
*@LastModifyDate : 2013-12-06
*@LastModifier : park eunjung
*@LastVersion : 1.0
* 2013-12-06 park eunjung
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event;

import com.clt.apps.opus.esd.tes.common.vo.TesCommonVO;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.vo.SearchCostCodeDetailListVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EsdTes9001Event 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_9001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author lee jung hye
 * @see HTMLAction 참조 
 * @since J2EE 1.4
 */
public class EsdTes9001Event  extends EventSupport {
	private SearchCostCodeDetailListVO   infoVO = null;
	private String cost_cd_inv_tp_cd = "";
	private TesCommonVO   cmnVO = null;
	
	public SearchCostCodeDetailListVO getInfoVO() {
		return infoVO;
	}

	public void setInfoVO(SearchCostCodeDetailListVO infoVO) {
		this.infoVO = infoVO;
	}

	public String getCost_cd_inv_tp_cd() {
		return cost_cd_inv_tp_cd;
	}

	public void setCost_cd_inv_tp_cd(String cost_cd_inv_tp_cd) {
		this.cost_cd_inv_tp_cd = cost_cd_inv_tp_cd;
	}

	public TesCommonVO getCmnVO() {
		return cmnVO;
	}

	public void setCmnVO(TesCommonVO cmnVO) {
		this.cmnVO = cmnVO;
	}

	public String getEventName() {
		return "EsdTes9001Event";
	}

	public String toString() {
		return "EsdTes9001Event";
	}
}

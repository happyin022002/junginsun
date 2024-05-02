/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0195Event.java
*@FileTitle : Total Loss No Inquiry_Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.09.15 김완규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.event;

import com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.vo.TotalLossInfoGRPVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ees_mnr_0195 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_mnr_0195HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김완규
 * @see ees_mnr_0195HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMnr0195Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	public EesMnr0195Event(){}

	/** Total Loss No 조회 조건 및 단건 처리  */
	private TotalLossInfoGRPVO totalLossInfoGRPVO = null;

	public TotalLossInfoGRPVO getTotalLossInfoGRPVO() {
		return totalLossInfoGRPVO;
	}

	public void setTotalLossInfoGRPVO(TotalLossInfoGRPVO totalLossInfoGRPVO) {
		this.totalLossInfoGRPVO = totalLossInfoGRPVO;
	}
}
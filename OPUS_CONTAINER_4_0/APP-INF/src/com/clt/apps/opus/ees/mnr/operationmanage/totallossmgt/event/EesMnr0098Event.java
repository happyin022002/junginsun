/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0098Event.java
*@FileTitle : Total Loss Collection & Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.28
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.09.28 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.event;

import com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.vo.TotalLossGRPVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ees_mnr_0098 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_mnr_0098HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 박명신
 * @see ees_mnr_0098HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMnr0098Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	public EesMnr0098Event(){}

	/** Total Loss 조회 조건 및 단건 처리  */
	private TotalLossGRPVO totalLossGRPVO = null;

	public TotalLossGRPVO getTotalLossGRPVO() {
		return totalLossGRPVO;
	}

	public void setTotalLossGRPVO(TotalLossGRPVO totalLossGRPVO) {
		this.totalLossGRPVO = totalLossGRPVO;
	}
}
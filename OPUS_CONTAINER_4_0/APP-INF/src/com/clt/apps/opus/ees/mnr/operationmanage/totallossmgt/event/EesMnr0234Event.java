/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0234Event.java
*@FileTitle : Total Loss Collection & Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.11
*@LastModifier : 권영법
*@LastVersion : 1.0
* 2010.01.11 권영법
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.event;

import com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.vo.TotalLossGRPVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ees_mnr_0234 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_mnr_0234HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 권영법
 * @see ees_mnr_0234HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMnr0234Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	public EesMnr0234Event(){}

	/** Total Loss 조회 조건 및 단건 처리  */
	private TotalLossGRPVO totalLossGRPVO = null;

	public TotalLossGRPVO getTotalLossGRPVO() {
		return totalLossGRPVO;
	}

	public void setTotalLossGRPVO(TotalLossGRPVO totalLossGRPVO) {
		this.totalLossGRPVO = totalLossGRPVO;
	}
}
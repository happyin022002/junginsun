/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0028Event.java
*@FileTitle : SKD vs Delay
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.11
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.10.08 유혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.OnTimeRsltAnalGRPVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * VOP_VSK_0028 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0028HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author RYU HYUK
 * @see VOP_VSK_0028HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopVsk0028Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OnTimeRsltAnalGRPVO onTimeRsltAnalGRPVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private OnTimeRsltAnalGRPVO[] onTimeRsltAnalGRPVOs = null;

	public VopVsk0028Event(){}

	public OnTimeRsltAnalGRPVO getOnTimeRsltAnalGRPVO() {
		return onTimeRsltAnalGRPVO;
	}

	public void setOnTimeRsltAnalGRPVO(OnTimeRsltAnalGRPVO onTimeRsltAnalGRPVO) {
		this.onTimeRsltAnalGRPVO = onTimeRsltAnalGRPVO;
	}

	public OnTimeRsltAnalGRPVO[] getOnTimeRsltAnalGRPVOS() {
		OnTimeRsltAnalGRPVO[] rtnVOs = null;
		if (this.onTimeRsltAnalGRPVOs != null) {
			rtnVOs = Arrays.copyOf(onTimeRsltAnalGRPVOs, onTimeRsltAnalGRPVOs.length);
		}
		return rtnVOs;
	}

	public void setOnTimeRsltAnalGRPVOS(OnTimeRsltAnalGRPVO[] onTimeRsltAnalGRPVOs) {
		if(onTimeRsltAnalGRPVOs != null){
			OnTimeRsltAnalGRPVO[] tmpVOs = Arrays.copyOf(onTimeRsltAnalGRPVOs, onTimeRsltAnalGRPVOs.length);
			this.onTimeRsltAnalGRPVOs = tmpVOs;
		}
	}
	
}
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0231Event.java
*@FileTitle : SKD for Conversion
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.13
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2009.07.13 정명훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.OnTimeRsltAnalGRPVO;


/**
 * VOP_VSK_0231 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0231HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jeong Myounghun
 * @see VOP_VSK_0231HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopVsk0231Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OnTimeRsltAnalGRPVO onTimeRsltAnalGRPVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private OnTimeRsltAnalGRPVO[] onTimeRsltAnalGRPVOs = null;

	public VopVsk0231Event(){}
	
	public void setOnTimeRsltAnalGRPVO(OnTimeRsltAnalGRPVO onTimeRsltAnalGRPVO){
		this.onTimeRsltAnalGRPVO = onTimeRsltAnalGRPVO;
	}

	public void setOnTimeRsltAnalGRPVOs(OnTimeRsltAnalGRPVO[] onTimeRsltAnalGRPVOs){
		if(onTimeRsltAnalGRPVOs != null){
			OnTimeRsltAnalGRPVO[] tmpVOs = new OnTimeRsltAnalGRPVO[onTimeRsltAnalGRPVOs.length];
			System.arraycopy(onTimeRsltAnalGRPVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.onTimeRsltAnalGRPVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this.onTimeRsltAnalGRPVOs = onTimeRsltAnalGRPVOs;
	}

	public OnTimeRsltAnalGRPVO getOnTimeRsltAnalGRPVO(){
		return onTimeRsltAnalGRPVO;
	}

	public OnTimeRsltAnalGRPVO[] getOnTimeRsltAnalGRPVOs(){
		OnTimeRsltAnalGRPVO[] rtnVOs =  null;
		if(this.onTimeRsltAnalGRPVOs != null){
			rtnVOs = new OnTimeRsltAnalGRPVO[onTimeRsltAnalGRPVOs.length];
			System.arraycopy(onTimeRsltAnalGRPVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return onTimeRsltAnalGRPVOs;
	}

}
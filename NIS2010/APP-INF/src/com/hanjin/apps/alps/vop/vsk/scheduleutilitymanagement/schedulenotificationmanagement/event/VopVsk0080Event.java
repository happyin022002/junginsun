/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : VopVsk0080Event.java
*@FileTitle : Schedule Notification
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.25
*@LastModifier : 정상기
*@LastVersion : 1.0
* 2012.12.05 정상기
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.schedulenotificationmanagement.event;

import com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.schedulenotificationmanagement.vo.VslSkdCngNotificationSetupVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * VOP_VSK_0080 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0080HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JEONG SANGKI
 * @see VOP_VSK_0080HTMLAction 참조
 * @since J2EE 1.6
 */
public class VopVsk0080Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VslSkdCngNotificationSetupVO vslSkdCngNotificationSetupVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private VslSkdCngNotificationSetupVO[] vslSkdCngNotificationSetupVOs = null;

	public VopVsk0080Event(){}

	public VslSkdCngNotificationSetupVO getVslSkdCngNotificationSetupVO() {
		return vslSkdCngNotificationSetupVO;
	}

	public void setVslSkdCngNotificationSetupVO(VslSkdCngNotificationSetupVO vslSkdCngNotificationSetupVO) {
		this.vslSkdCngNotificationSetupVO = vslSkdCngNotificationSetupVO;
	}

	public VslSkdCngNotificationSetupVO[] getVslSkdCngNotificationSetupVOs() {
		VslSkdCngNotificationSetupVO[] rtnVOs =  null;
		if(this.vslSkdCngNotificationSetupVOs != null){
			rtnVOs = new VslSkdCngNotificationSetupVO[vslSkdCngNotificationSetupVOs.length];
			System.arraycopy(vslSkdCngNotificationSetupVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return vslSkdCngNotificationSetupVOs;
	}

	public void setVslSkdCngNotificationSetupVOs(VslSkdCngNotificationSetupVO[] vslSkdCngNotificationSetupVOs) {
		if(vslSkdCngNotificationSetupVOs != null){
			VslSkdCngNotificationSetupVO[] tmpVOs = new VslSkdCngNotificationSetupVO[vslSkdCngNotificationSetupVOs.length];
			System.arraycopy(vslSkdCngNotificationSetupVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vslSkdCngNotificationSetupVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this.vslSkdCngNotificationSetupVOs = vslSkdCngNotificationSetupVOs;
	}

}
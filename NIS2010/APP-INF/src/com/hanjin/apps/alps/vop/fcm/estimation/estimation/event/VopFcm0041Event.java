/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VopFcm9999Event.java
*@FileTitle : VopFcm9999Event
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.04
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2011.10.04 유혁
* 1.0 Creation
* 
* 2015.04.30 이병훈 [CHM-201534057] Split09-2015년 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.estimation.estimation.event;


import com.hanjin.apps.alps.vop.fcm.estimation.estimation.vo.MonEstmCsmVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * VOP_FCM_0041 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_FCM_0041HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ryu Hyuk
 * @see VOP_FCM_0041HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopFcm0041Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MonEstmCsmVO monEstmCsmVO;
	private MonEstmCsmVO[] monEstmCsmVOs;
	
	public VopFcm0041Event(){}

	public MonEstmCsmVO getMonEstmCsmVO() {
		return monEstmCsmVO;
	}

	public void setMonEstmCsmVO(MonEstmCsmVO monEstmCsmVO) {
		this.monEstmCsmVO = monEstmCsmVO;
	}

	public MonEstmCsmVO[] getMonEstmCsmVOs() {
//		return monEstmCsmVOs;
		MonEstmCsmVO[] rtnVOs = null;
		if (this.monEstmCsmVOs != null) {
			rtnVOs = new MonEstmCsmVO[monEstmCsmVOs.length];
			System.arraycopy(monEstmCsmVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setMonEstmCsmVOs(MonEstmCsmVO[] monEstmCsmVOs) {
//		this.monEstmCsmVOs = monEstmCsmVOs;
		if (monEstmCsmVOs != null) {
			MonEstmCsmVO[] tmpVOs = new MonEstmCsmVO[monEstmCsmVOs.length];
			System.arraycopy(monEstmCsmVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.monEstmCsmVOs = tmpVOs;
		}
	}

	
}
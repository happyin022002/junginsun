/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VopFcm0002Event.java
*@FileTitle : VopFcm0002Event
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.07
*@LastModifier : 이병훈
*@LastVersion : 1.0
* 1.0 Creation
* 
* [CHM-201640787] 연료 소모 분석관련  Departure Report 신규 화면 개발 - 2016.04.07 이병훈
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.event;

import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslFcmDepRptVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslRptInqVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * VOP_FCM_0002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_FCM_0002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 이병훈
 * @see VOP_FCM_0002HTMLAction 참조
 * @since J2EE 1.4
 */
public class VopFcm0002Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VslRptInqVO vslRptInqVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private VslFcmDepRptVO[] vslFcmDepRptVOs = null;

	public VopFcm0002Event(){}

	public VslRptInqVO getVslRptInqVO() {
		return vslRptInqVO;
	}
	
	public VslFcmDepRptVO[] getVslFcmDepRptVOs() {
		VslFcmDepRptVO[] rtnVOs = null;
		if (this.vslFcmDepRptVOs != null) {
			rtnVOs = new VslFcmDepRptVO[vslFcmDepRptVOs.length];
			System.arraycopy(vslFcmDepRptVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public void setVslRptInqVO(VslRptInqVO vslRptInqVO) {
		this.vslRptInqVO = vslRptInqVO;
	}
	
	public void setVslFcmDepRptVOs(VslFcmDepRptVO[] vslFcmDepRptVOs) {
		if (vslFcmDepRptVOs != null) {
			VslFcmDepRptVO[] tmpVOs = new VslFcmDepRptVO[vslFcmDepRptVOs.length];
			System.arraycopy(vslFcmDepRptVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vslFcmDepRptVOs = tmpVOs;
		}
	}
}
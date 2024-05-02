/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VopFcm0004Event.java
*@FileTitle : VopFcm0004Event
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.16
*@LastModifier :
*@LastVersion : 1.0
* 1.0 Creation
* 
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.event;

import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.FcmDepRptErrClsVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.FcmDepRptVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * VOP_FCM_0004 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_FCM_0004HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 9016018
 * @see VOP_FCM_0004HTMLAction 참조
 * @since J2EE 1.6
 */
public class VopFcm0004Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private FcmDepRptErrClsVO fcmDepRptErrClsVO= null;
	
	private FcmDepRptVO fcmDepRptVO= null;
	
	public VopFcm0004Event(){};
	
	public FcmDepRptErrClsVO getFcmDepRptErrClsVO() {
		return fcmDepRptErrClsVO;
	}

	public void setFcmDepRptErrClsVO(FcmDepRptErrClsVO fcmDepRptErrClsVO) {
		this.fcmDepRptErrClsVO = fcmDepRptErrClsVO;
	}

	public FcmDepRptVO getFcmDepRptVO() {
		return fcmDepRptVO;
	}

	public void setFcmDepRptVO(FcmDepRptVO fcmDepRptVO) {
		this.fcmDepRptVO = fcmDepRptVO;
	}
	
	
}
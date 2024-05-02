/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VopFcm0005Event.java
*@FileTitle : VopFcm0005Event
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.04
*@LastModifier :
*@LastVersion : 1.0
* 1.0 Creation
* 
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.event;

import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.FcmDepRptErrClsVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * VOP_FCM_0005 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_FCM_0005HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 9016018
 * @see VOP_FCM_0005HTMLAction 참조
 * @since J2EE 1.6
 */
public class VopFcm0005Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private FcmDepRptErrClsVO fcmDepRptErrClsVO= null;
	
	public VopFcm0005Event(){};
	
	public FcmDepRptErrClsVO getFcmDepRptErrClsVO() {
		return fcmDepRptErrClsVO;
	}

	public void setFcmDepRptErrClsVO(FcmDepRptErrClsVO fcmDepRptErrClsVO) {
		this.fcmDepRptErrClsVO = fcmDepRptErrClsVO;
	}
	
	
}
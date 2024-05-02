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
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.budgetplan.budgetplan.event;

import com.hanjin.apps.alps.vop.fcm.budgetplan.budgetplan.vo.FcmBudTgtVvdCsmVO;
import com.hanjin.apps.alps.vop.fcm.budgetplan.budgetplan.vo.FcmBudTgtVvdInqVO;
import com.hanjin.apps.alps.vop.fcm.budgetplan.budgetplan.vo.FcmBudTgtVvdVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * VOP_FCM_0031 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_FCM_0031HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ryu Hyuk
 * @see VOP_FCM_0031HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopFcm0031Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private FcmBudTgtVvdVO fcmBudTgtVvdVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private FcmBudTgtVvdCsmVO fcmBudTgtVvdCsmVO = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private FcmBudTgtVvdInqVO fcmBudTgtVvdInqVO = null;
	
	
	public VopFcm0031Event(){}

	public FcmBudTgtVvdVO getFcmBudTgtVvdVO() {
		return fcmBudTgtVvdVO;
	}

	public void setFcmBudTgtVvdVO(FcmBudTgtVvdVO fcmBudTgtVvdVO) {
		this.fcmBudTgtVvdVO = fcmBudTgtVvdVO;
	}

	public FcmBudTgtVvdCsmVO getFcmBudTgtVvdCsmVO() {
		return fcmBudTgtVvdCsmVO;
	}

	public void setFcmBudTgtVvdCsmVO(FcmBudTgtVvdCsmVO fcmBudTgtVvdCsmVO) {
		this.fcmBudTgtVvdCsmVO = fcmBudTgtVvdCsmVO;
	}

	public FcmBudTgtVvdInqVO getFcmBudTgtVvdInqVO() {
		return fcmBudTgtVvdInqVO;
	}

	public void setFcmBudTgtVvdInqVO(FcmBudTgtVvdInqVO fcmBudTgtVvdInqVO) {
		this.fcmBudTgtVvdInqVO = fcmBudTgtVvdInqVO;
	}
	

}
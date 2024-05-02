/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : VopFcm0051Event.java
 *@FileTitle : VopFcm0051Event
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
package com.hanjin.apps.alps.vop.fcm.simulation.simulation.event;

import com.hanjin.apps.alps.vop.fcm.simulation.simulation.vo.BnkReqSimVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * VOP_FCM_0051 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - VOP_FCM_0051HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Ryu Hyuk
 * @see VOP_FCM_0051HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopFcm0051Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */

	private BnkReqSimVO bnkReqSimVO;
	private BnkReqSimVO[] bnkReqSimVOs;

	public BnkReqSimVO getBnkReqSimVO() {
		return bnkReqSimVO;
	}

	public void setBnkReqSimVO(BnkReqSimVO bnkReqSimVO) {
		this.bnkReqSimVO = bnkReqSimVO;
	}
	
	public BnkReqSimVO[] getBnkReqSimVOs() {
//		return bnkReqSimVOs;
		BnkReqSimVO[] rtnVOs = null;
		if (this.bnkReqSimVOs != null) {
			rtnVOs = new BnkReqSimVO[bnkReqSimVOs.length];
			System.arraycopy(bnkReqSimVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setBnkReqSimVOs(BnkReqSimVO[] bnkReqSimVOs) {
//		this.bnkReqSimVOs = bnkReqSimVOs;
		if (bnkReqSimVOs != null) {
			BnkReqSimVO[] tmpVOs = new BnkReqSimVO[bnkReqSimVOs.length];
			System.arraycopy(bnkReqSimVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bnkReqSimVOs = tmpVOs;
		}
	}

	public VopFcm0051Event() {
	}

}
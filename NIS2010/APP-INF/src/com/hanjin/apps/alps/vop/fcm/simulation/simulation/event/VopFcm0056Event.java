/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName       : VopFcm0056Event.java
 *@FileTitle      : Standard FOC
 *Open Issues     :
 *Change history  :
 *@LastModifyDate : 2014.04.16
 *@LastModifier   :
 *@LastVersion    : 1.0
 * 2014.04.16 [CHM-201429874] Standard FOC 생성 및 단계별 저장 기능 개발
 * 1.0 Creation
 *
 * History
 * 2015.04.30 이병훈 [CHM-201534057] Split09-2015년 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.simulation.simulation.event;

import com.hanjin.apps.alps.vop.fcm.simulation.simulation.vo.BnkReqSimVO;
import com.hanjin.apps.alps.vop.fcm.simulation.simulation.vo.StandardFocVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.FcmVslPortStndFuelOilVO;

/**
 * VOP_FCM_0056 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - VOP_FCM_0056HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author CHOI Yun Sung
 * @see VOP_FCM_0056HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopFcm0056Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private StandardFocVO standardFocVO;
	private StandardFocVO[] standardFocVOs;
	
	private FcmVslPortStndFuelOilVO fcmVslPortStndFuelOilVO;
	private FcmVslPortStndFuelOilVO[] fcmVslPortStndFuelOilVOs;
	
	private BnkReqSimVO bnkReqSimVO;
	
	public BnkReqSimVO getBnkReqSimVO() {
		return bnkReqSimVO;
	}
	
	public void setBnkReqSimVO(BnkReqSimVO bnkReqSimVO) {
		this.bnkReqSimVO = bnkReqSimVO;
	}
	
	public StandardFocVO getStandardFocVO() {
		return standardFocVO;
	}
	
	public void setStandardFocVO(StandardFocVO standardFocVO) {
		this.standardFocVO = standardFocVO;
	}
	
	public StandardFocVO[] getStandardFocVOs() {
//		return standardFocVOs;
		StandardFocVO[] rtnVOs = null;
		if (this.standardFocVOs != null) {
			rtnVOs = new StandardFocVO[standardFocVOs.length];
			System.arraycopy(standardFocVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setStandardFocVOs(StandardFocVO[] standardFocVOs) {
//		this.standardFocVOs = standardFocVOs;
		if (standardFocVOs != null) {
			StandardFocVO[] tmpVOs = new StandardFocVO[standardFocVOs.length];
			System.arraycopy(standardFocVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.standardFocVOs = tmpVOs;
		}
	}

	public FcmVslPortStndFuelOilVO getFcmVslPortStndFuelOilVO() {
		return fcmVslPortStndFuelOilVO;
	}
	
	public void setFcmVslPortStndFuelOilVO(FcmVslPortStndFuelOilVO fcmVslPortStndFuelOilVO) {
		this.fcmVslPortStndFuelOilVO = fcmVslPortStndFuelOilVO;
	}
	
	public FcmVslPortStndFuelOilVO[] getFcmVslPortStndFuelOilVOs() {
//		return fcmVslPortStndFuelOilVOs;
		FcmVslPortStndFuelOilVO[] rtnVOs = null;
		if (this.fcmVslPortStndFuelOilVOs != null) {
			rtnVOs = new FcmVslPortStndFuelOilVO[fcmVslPortStndFuelOilVOs.length];
			System.arraycopy(fcmVslPortStndFuelOilVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public void setFcmVslPortStndFuelOilVOs(FcmVslPortStndFuelOilVO[] fcmVslPortStndFuelOilVOs) {
//		this.fcmVslPortStndFuelOilVOs = fcmVslPortStndFuelOilVOs;
		if (fcmVslPortStndFuelOilVOs != null) {
			FcmVslPortStndFuelOilVO[] tmpVOs = new FcmVslPortStndFuelOilVO[fcmVslPortStndFuelOilVOs.length];
			System.arraycopy(fcmVslPortStndFuelOilVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.fcmVslPortStndFuelOilVOs = tmpVOs;
		}
	}
	
	public VopFcm0056Event() {
	}

}
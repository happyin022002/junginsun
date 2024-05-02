/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueEvent.java
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2007-02-26
 *@LastModifier : Kim Jung-Jae
 *@LastVersion : 1.0
 * 2006-12-21 Kim Jung-Jae
 * 1.0 최초 생성
 * 
 * History
 * 2015.08.10 이병훈 [CHM-201536635] Split11-2015년 소스 보안 품질 3단계 중 4차 작업 진행 요청
 =========================================================*/
package com.hanjin.apps.alps.vop.vsk.externalvesselinfomanagement.vesselpassageplanmanagement.event;

import com.hanjin.apps.alps.vop.vsk.externalvesselinfomanagement.vesselpassageplanmanagement.vo.PassagePlanDtVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * Event 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see ReceiveQueueEvent 참조
 * @since J2EE 1.4
 */
public class VesselPassagePlanReceiveQueueEvent extends EventSupport {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7901449189938813804L;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PassagePlanDtVO passagePlanDtVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PassagePlanDtVO[] passagePlanDtVOs = null;
	

	public PassagePlanDtVO getPassagePlanDtVO() {
		return passagePlanDtVO;
	}

	public void setpassagePlanDtVO(PassagePlanDtVO passagePlanDtVO) {
		this.passagePlanDtVO = passagePlanDtVO;
	}
	
	public PassagePlanDtVO[] getPassagePlanDtVOs() {
//		return passagePlanDtVOs;
		PassagePlanDtVO[] rtnVOs = null;
		if (this.passagePlanDtVOs != null) {
			rtnVOs = new PassagePlanDtVO[passagePlanDtVOs.length];
			System.arraycopy(passagePlanDtVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setPassagePlanDtVOs(PassagePlanDtVO[] passagePlanDtVOs) {
//		this.passagePlanDtVOs = passagePlanDtVOs;
		if (passagePlanDtVOs != null) {
			PassagePlanDtVO[] tmpVOs = new PassagePlanDtVO[passagePlanDtVOs.length];
			System.arraycopy(passagePlanDtVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.passagePlanDtVOs = tmpVOs;
		}
	}

}

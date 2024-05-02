/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName 		: EesCgm1158Event.java
*@FileTitle 	: Chassis Long Staying Report
*Open Issues 	: 
*Change history :
*@LastModifyDate: 2015.04.24
*@LastModifier 	: 이율규
*@LastVersion 	: 1.0
* 2015.04.24 이율규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassisreport.chassislongstayingreport.event;

import java.util.Arrays;

import com.hanjin.apps.alps.ees.cgm.chassisreport.chassislongstayingreport.vo.ChassisLongStayingVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ees_cgm_1158 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_cgm_1157HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 이율규
 * @see EES_CGM_1158HTMLAction 참조
 * @since J2EE 1.4
 */

@SuppressWarnings("serial")
public class EesCgm1158Event extends EventSupport {
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ChassisLongStayingVO chassisLongStayingVO = null;
	/** Table Value Object Multi Data 처리━ */
	private ChassisLongStayingVO[] chassisLongStayingVOS = null;

	public ChassisLongStayingVO getChassisLongStayingVO() {
		return chassisLongStayingVO;
	}

	public void setChassisLongStayingVO(
			ChassisLongStayingVO chassisLongStayingVO) {
		this.chassisLongStayingVO = chassisLongStayingVO;
	}

	public ChassisLongStayingVO[] getChassisLongStayingVOS() {
		ChassisLongStayingVO[] rtnVOs = null;
		if (this.chassisLongStayingVOS != null) {
			rtnVOs = new ChassisLongStayingVO[chassisLongStayingVOS.length];
			System.arraycopy(chassisLongStayingVOS, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setChassisLongStayingVOS(ChassisLongStayingVO[] chassisLongStayingVOS){
		if(chassisLongStayingVOS != null){
			ChassisLongStayingVO[] tmpVOs = Arrays.copyOf(chassisLongStayingVOS, chassisLongStayingVOS.length);
			this.chassisLongStayingVOS = tmpVOs;
		}
	}

}

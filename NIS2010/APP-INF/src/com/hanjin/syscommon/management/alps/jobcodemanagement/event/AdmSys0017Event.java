/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : AdmSys0017Event.java
*@FileTitle : Job Code Request
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.24
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2013.05.24 최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps.jobcodemanagement.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.AdjustmentVO;


/**
 * ADM_SYS_0017 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ADM_SYS_0017HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi, DukWoo
 * @see ADM_SYS_0017HTMLAction 참조
 * @since J2EE 1.6
 */

public class AdmSys0017Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Input Value Object 단건 처리  */
	private AdjustmentVO adjustmentVO = null;

	public AdjustmentVO getAdjustmentVO() {
		return adjustmentVO;
	}

	public void setAdjustmentVO(AdjustmentVO adjustmentVO) {
		this.adjustmentVO = adjustmentVO;
	}

}
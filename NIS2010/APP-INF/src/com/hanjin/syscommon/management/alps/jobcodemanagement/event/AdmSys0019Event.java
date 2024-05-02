/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : AdmSys0019Event.java
*@FileTitle : Job Code Approval
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.24
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2013.05.24 김상수
* 1.0 Creation 
=========================================================*/
package com.hanjin.syscommon.management.alps.jobcodemanagement.event;

import java.util.Arrays;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.AdjustmentVO;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.RequestVO;


/**
 * ADM_SYS_0019 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ADM_SYS_0019HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ADM_SYS_0019HTMLAction 참조
 * @since J2EE 1.6
 */

public class AdmSys0019Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private RequestVO requestVO = null;

	/** Table Value Object Multi Data 처리 */
	private RequestVO[] requestVOs = null;

	/** Input Value Object 단건 처리  */
	private AdjustmentVO adjustmentVO = null;

	public RequestVO getRequestVO() {
		return requestVO;
	}

	public void setRequestVO(RequestVO requestVO) {
		this.requestVO = requestVO;
	}

	public RequestVO[] getRequestVOs() {
		RequestVO[] rtnVOs = null;
		if(this.requestVOs != null){
			rtnVOs = Arrays.copyOf(this.requestVOs, this.requestVOs.length);
		}
		return rtnVOs;
	}

	public void setRequestVOs(RequestVO[] requestVOs) {
		if(requestVOs != null){
			RequestVO[] tempVOs = Arrays.copyOf(requestVOs,requestVOs.length);
			this.requestVOs = tempVOs;
		}
	}

	public AdjustmentVO getAdjustmentVO() {
		return adjustmentVO;
	}

	public void setAdjustmentVO(AdjustmentVO adjustmentVO) {
		this.adjustmentVO = adjustmentVO;
	}

}
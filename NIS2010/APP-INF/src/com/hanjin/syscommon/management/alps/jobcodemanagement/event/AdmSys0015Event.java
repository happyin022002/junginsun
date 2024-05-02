/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UserManagementEvent.java
*@FileTitle : User Management
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.21
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2013.05.21 최덕우
* 1.0 Creation 
=========================================================*/
package com.hanjin.syscommon.management.alps.jobcodemanagement.event;

import java.util.Arrays;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.AdjustmentVO;


/**
 * UserManagement 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UserManagementHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi, DukWoo
 * @see UserManagementHTMLAction 참조
 * @since J2EE 1.6 JobCodeAdjustReqGRPVO
 */
public class AdmSys0015Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private AdjustmentVO adjustmentVO = null;

	/** Table Value Object Multi Data 처리 */
	private AdjustmentVO[] adjustmentVOs = null;

	public AdmSys0015Event(){}

	/**
	 * @return the adjustmentVO
	 */
	public AdjustmentVO getAdjustmentVO() {
		return adjustmentVO;
	}

	/**
	 * @param adjustmentVO the adjustmentVO to set
	 */
	public void setAdjustmentVO(AdjustmentVO adjustmentVO) {
		this.adjustmentVO = adjustmentVO;
	}

	/**
	 * @return the adjustmentVOs
	 */
	public AdjustmentVO[] getAdjustmentVOs() {
		AdjustmentVO[] rtnVOs = null;
		if(this.adjustmentVOs != null){
			rtnVOs = Arrays.copyOf(this.adjustmentVOs, this.adjustmentVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param adjustmentVOs the adjustmentVOs to set
	 */
	public void setAdjustmentVOs(AdjustmentVO[] adjustmentVOs) {
		if(adjustmentVOs != null){
			AdjustmentVO[] tempVOs = Arrays.copyOf(adjustmentVOs, adjustmentVOs.length);
			this.adjustmentVOs = tempVOs;
		}
	}


}

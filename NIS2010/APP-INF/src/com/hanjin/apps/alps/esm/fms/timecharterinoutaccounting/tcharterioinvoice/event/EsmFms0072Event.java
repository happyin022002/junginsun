/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UiFms0072Event.java
*@FileTitle : Manhour Item Registration & Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.05.12 최우석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedProRevenueListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomManHrListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0072 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0072HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Woo-Seok
 * @see ESM_FMS_0072HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmFms0072Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomManHrListVO customManHrListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomManHrListVO[] customManHrListVOs = null;
	
	public void setCustomManHrListVO(CustomManHrListVO customManHrListVO){
		this. customManHrListVO = customManHrListVO;
	}

	public void setCustomManHrListVOS(CustomManHrListVO[] customManHrListVOs){
			if (customManHrListVOs != null) {
			CustomManHrListVO[] tmpVOs = Arrays.copyOf(customManHrListVOs, customManHrListVOs.length);
			this.customManHrListVOs = tmpVOs;
		}
	}

	public CustomManHrListVO getCustomManHrListVO(){
		return customManHrListVO;
	}

	public CustomManHrListVO[] getCustomManHrListVOS(){
		CustomManHrListVO[] rtnVOs = null;
		if (this.customManHrListVOs != null) {
			rtnVOs = Arrays.copyOf(customManHrListVOs, customManHrListVOs.length);
		}
		return rtnVOs;
	}
	
}
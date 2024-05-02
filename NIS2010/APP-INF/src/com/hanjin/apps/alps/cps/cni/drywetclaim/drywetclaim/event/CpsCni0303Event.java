/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CpsCni0303Event.java
*@FileTitle : Handling Costs
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.10.12 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.event;

import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.CustomHandlingCostVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * CPS_CNI_0303 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  CPS_CNI_0303HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Yoon, Seyeong
 * @see CPS_CNI_0303HTMLAction 참조
 * @since J2EE 1.6
 */

public class CpsCni0303Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** DW Claim No */
	private String dwClmNo = "";
	
	/** Table Value Object Multi Data 처리 */
	private CustomHandlingCostVO[] customHandlingCostVOs = null;

	public CpsCni0303Event(){}

	public void setCustomHandlingCostVOS(CustomHandlingCostVO[] customHandlingCostVOs){
		this.customHandlingCostVOs = customHandlingCostVOs;
	}

	public void setDwClmNo(String dwClmNo) {
		this.dwClmNo = dwClmNo;
	}

	public CustomHandlingCostVO[] getCustomHandlingCostVOS(){
		return customHandlingCostVOs;
	}
	
	public String getDwClmNo() {
		return dwClmNo;
	}

}
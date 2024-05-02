/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0062Event.java
*@FileTitle : TEU Range Target
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.15
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.04.15 최우석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.event;

import java.util.Arrays;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedProRevenueListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.vo.CustomTeuRngVO;


/**
 * ESM_FMS_0062 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0062HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Woo-Seok
 * @see ESM_FMS_0062HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmFms0062Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomTeuRngVO customTeuRngVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomTeuRngVO[] customTeuRngVOs = null;
	
	private String rngYr =  "";

	public EsmFms0062Event(){}
	
	public void setCustomTeuRngVO(CustomTeuRngVO customTeuRngVO){
		this. customTeuRngVO = customTeuRngVO;
	}

	public void setCustomTeuRngVOS(CustomTeuRngVO[] customTeuRngVOs){
		if (customTeuRngVOs != null) {
			CustomTeuRngVO[] tmpVOs = Arrays.copyOf(customTeuRngVOs, customTeuRngVOs.length);
			this.customTeuRngVOs = tmpVOs;
		}
	}
	
	public void setRngYr(String rngYr){
		this. rngYr = rngYr;
	}

	public CustomTeuRngVO getCustomTeuRngVO(){
		return customTeuRngVO;
	}

	public CustomTeuRngVO[] getCustomTeuRngVOS(){
		CustomTeuRngVO[] rtnVOs = null;
		if (this.customTeuRngVOs != null) {
			rtnVOs = Arrays.copyOf(customTeuRngVOs, customTeuRngVOs.length);
		}
		return rtnVOs;
	}
	
	public String getRngYr(){
		return rngYr;
	}

}
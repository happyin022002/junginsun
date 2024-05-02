/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0063Event.java
*@FileTitle : Hire Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.14
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.05.14 최우석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedProRevenueListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.vo.CustomStndHirVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0063 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0063HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Woo-Seok
 * @see ESM_FMS_0063HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmFms0063Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomStndHirVO customStndHirVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomStndHirVO[] customStndHirVOs = null;
	
	private String rngYr =  "";

	public EsmFms0063Event(){}
	
	public void setCustomStndHirVO(CustomStndHirVO customStndHirVO){
		this. customStndHirVO = customStndHirVO;
	}

	public void setCustomStndHirVOS(CustomStndHirVO[] customStndHirVOs){
		if (customStndHirVOs != null) {
			CustomStndHirVO[] tmpVOs = Arrays.copyOf(customStndHirVOs, customStndHirVOs.length);
			this.customStndHirVOs = tmpVOs;
		}
	}
	
	public void setRngYr(String rngYr){
		this. rngYr = rngYr;
	}

	public CustomStndHirVO getCustomStndHirVO(){
		return customStndHirVO;
	}

	public CustomStndHirVO[] getCustomStndHirVOS(){
		CustomStndHirVO[] rtnVOs = null;
		if (this.customStndHirVOs != null) {
			rtnVOs = Arrays.copyOf(customStndHirVOs, customStndHirVOs.length);
		}
		return rtnVOs;
	}
	
	public String getRngYr(){
		return rngYr;
	}

}
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0007Event.java
*@FileTitle : Manhour List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.08
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.05.08 최우석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedProRevenueListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondSearchManhourListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomManHrChgVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0007 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0007HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Woo-Seok
 * @see ESM_FMS_0007HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmFms0007Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomManHrChgVO customManHrChgVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CondSearchManhourListVO condSearchManhourListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomManHrChgVO[] customManHrChgVOs = null;
	
	public void setCustomManHrChgVO(CustomManHrChgVO customManHrChgVO){
		this. customManHrChgVO = customManHrChgVO;
	}

	public void setCustomManHrChgVOS(CustomManHrChgVO[] customManHrChgVOs){
		if (customManHrChgVOs != null) {
			CustomManHrChgVO[] tmpVOs = Arrays.copyOf(customManHrChgVOs, customManHrChgVOs.length);
			this.customManHrChgVOs = tmpVOs;
		}
	}

	public CustomManHrChgVO getCustomManHrChgVO(){
		return customManHrChgVO;
	}

	public CustomManHrChgVO[] getCustomManHrChgVOS(){
		CustomManHrChgVO[] rtnVOs = null;
		if (this.customManHrChgVOs != null) {
			rtnVOs = Arrays.copyOf(customManHrChgVOs, customManHrChgVOs.length);
		}
		return rtnVOs;
	}
	
	public void setCondSearchManhourListVO(CondSearchManhourListVO condSearchManhourListVO){
		this. condSearchManhourListVO = condSearchManhourListVO;
	}

	public CondSearchManhourListVO getCondSearchManhourListVO(){
		return condSearchManhourListVO;
	}
}
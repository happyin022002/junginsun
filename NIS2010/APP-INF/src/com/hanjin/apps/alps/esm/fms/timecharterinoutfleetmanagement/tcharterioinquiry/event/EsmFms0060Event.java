/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0060Event.java
*@FileTitle : Fleet Status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.05.26 최우석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedProRevenueListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.CondSearchFleetStatusSumVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.CondSearchFleetStatusVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0060 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0060HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Woo-Seok
 * @see ESM_FMS_0060HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmFms0060Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CondSearchFleetStatusVO condSearchFleetStatusVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CondSearchFleetStatusVO[] condSearchFleetStatusVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CondSearchFleetStatusSumVO condSearchFleetStatusSumVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CondSearchFleetStatusSumVO[] condSearchFleetStatusSumVOs = null;

	public EsmFms0060Event(){}
	
	public void setCondSearchFleetStatusVO(CondSearchFleetStatusVO condSearchFleetStatusVO){
		this. condSearchFleetStatusVO = condSearchFleetStatusVO;
	}

	public void setCondSearchFleetStatusVOS(CondSearchFleetStatusVO[] condSearchFleetStatusVOs){
		if (condSearchFleetStatusVOs != null) {
			CondSearchFleetStatusVO[] tmpVOs = Arrays.copyOf(condSearchFleetStatusVOs, condSearchFleetStatusVOs.length);
			this.condSearchFleetStatusVOs = tmpVOs;
		}
	}

	public CondSearchFleetStatusVO getCondSearchFleetStatusVO(){
		return condSearchFleetStatusVO;
	}

	public CondSearchFleetStatusVO[] getCondSearchFleetStatusVOS(){
		CondSearchFleetStatusVO[] rtnVOs = null;
		if (this.condSearchFleetStatusVOs != null) {
			rtnVOs = Arrays.copyOf(condSearchFleetStatusVOs, condSearchFleetStatusVOs.length);
		}
		return rtnVOs;
	}
	
	public void setCondSearchFleetStatusSumVO(CondSearchFleetStatusSumVO condSearchFleetStatusSumVO){
		this. condSearchFleetStatusSumVO = condSearchFleetStatusSumVO;
	}

	public void setCondSearchFleetStatusSumVOS(CondSearchFleetStatusSumVO[] condSearchFleetStatusSumVOs){
		if (condSearchFleetStatusSumVOs != null) {
			CondSearchFleetStatusSumVO[] tmpVOs = Arrays.copyOf(condSearchFleetStatusSumVOs, condSearchFleetStatusSumVOs.length);
			this.condSearchFleetStatusSumVOs = tmpVOs;
		}
	}

	public CondSearchFleetStatusSumVO getCondSearchFleetStatusSumVO(){
		return condSearchFleetStatusSumVO;
	}

	public CondSearchFleetStatusSumVO[] getCondSearchFleetStatusSumVOS(){
		CondSearchFleetStatusSumVO[] rtnVOs = null;
		if (this.condSearchFleetStatusSumVOs != null) {
			rtnVOs = Arrays.copyOf(condSearchFleetStatusSumVOs, condSearchFleetStatusSumVOs.length);
		}
		return rtnVOs;
	}
}
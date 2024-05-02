/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0037Event.java
*@FileTitle : New Van Delivery Plan and Performance
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.06.22 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.event;

import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.vo.LeasePlanVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.vo.PlanSearchVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * UI_LSE_0037 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_LSE_0034HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Jun-Woo
 * @see EES_LSE_0037HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesLse0037Event extends EventSupport {
	/*
	 * 객체직렬화 버젼 UID
	 */
	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PlanSearchVO planSearchVO = null;

	/** Table Value Object Multi Data 처리 */
	public LeasePlanVO[] leasePlanVOs = null;

	/**
	 * Default Constructor.
	 */
	public EesLse0037Event(){}

	/**
	 * 단건처리 DataModel를 설정한다.
	 * @param planSearchVO
	 */
	public void setPlanSearchVO(PlanSearchVO planSearchVO){
		this.planSearchVO = planSearchVO;
	}

	/**
	 * 단건처리 DataModel를 반환한다.
	 * @return PlanSearchVO
	 */
	public PlanSearchVO getPlanSearchVO(){
		return planSearchVO;
	}

	/**
	 * 복수처리 DataModel를 설정한다.
	 * @param leasePlanVOs LeasePlanVO[]
	 */
	public void setLeasePlanVOs(LeasePlanVO[] leasePlanVOs) {
		this.leasePlanVOs = leasePlanVOs;
	}

	/**
	 * 복수처리 DataModel를 반환한다.
	 * @return LeasePlanVO[]
	 */
	public LeasePlanVO[] getLeasePlanVOs() {
		return leasePlanVOs;
	}
}
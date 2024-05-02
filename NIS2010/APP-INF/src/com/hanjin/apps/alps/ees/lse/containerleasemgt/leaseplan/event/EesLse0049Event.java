/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UiLse0049Event.java
*@FileTitle : Long Term Lease CNTR Delivery Plan & Performance
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.04.27 노정용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.event;

import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.vo.LeasePlanVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.vo.PlanSearchVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * UI_LSE_0049 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_LSE_0049HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Nho Jung Yong
 * @see EES_LSE_0049HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesLse0049Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PlanSearchVO planSearchVO = null;

	/** Table Value Object Multi Data 처리 */
	public LeasePlanVO[] leasePlanVOs = null;

	public EesLse0049Event(){}

	public void setPlanSearchVO(PlanSearchVO planSearchVO){
		this. planSearchVO = planSearchVO;
	}

	public PlanSearchVO getPlanSearchVO(){
		return planSearchVO;
	}

	public void setLeasePlanVOs(LeasePlanVO[] leasePlanVOs) {
		this.leasePlanVOs = leasePlanVOs;
	}

	public LeasePlanVO[] getLeasePlanVOs() {
		return leasePlanVOs;
	}
}
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0046Event.java
*@FileTitle : Off Hire Plan Input and Update by RCC
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.07.03 노정용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.event;

import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.vo.OffHirePlanRccVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.vo.OffHirePlanSearchVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_LSE_0046 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_LSE_0046HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Nho Jung Yong
 * @see EES_LSE_0046HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesLse0046Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OffHirePlanSearchVO offHirePlanSearchVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public OffHirePlanRccVO[] offHirePlanRccVOs = null;

	public EesLse0046Event(){}

	public void setOffHirePlanSearchVO(OffHirePlanSearchVO offHirePlanSearchVO) {
		this.offHirePlanSearchVO = offHirePlanSearchVO;
	}

	public OffHirePlanSearchVO getOffHirePlanSearchVO() {
		return offHirePlanSearchVO;
	}

	public void setOffHirePlanRccVOs(OffHirePlanRccVO[] offHirePlanRccVOs) {
		this.offHirePlanRccVOs = offHirePlanRccVOs;
	}

	public OffHirePlanRccVO[] getOffHirePlanRccVOs() {
		return offHirePlanRccVOs;
	}
}
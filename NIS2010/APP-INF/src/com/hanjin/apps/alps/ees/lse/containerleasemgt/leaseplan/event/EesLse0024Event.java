/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0024Event.java
*@FileTitle : Off Hire Plan Input &amp; Update by H/Q
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 오봉현
*@LastVersion : 1.0
* 2009.06.02 오봉현
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.event;

import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.vo.OffHirePlanVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.vo.OffHirePlanSearchVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_LSE_0024 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_LSE_0024HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author OH BONG HYUN
 * @see EES_LSE_0024HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesLse0024Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OffHirePlanSearchVO offHirePlanSearchVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public OffHirePlanVO[] offHirePlanVOs = null;

	public EesLse0024Event(){}
	
	public void setOffHirePlanSearchVO(OffHirePlanSearchVO offHirePlanSearchVO) {
		this.offHirePlanSearchVO = offHirePlanSearchVO;
	}

	public OffHirePlanSearchVO getOffHirePlanSearchVO() {
		return offHirePlanSearchVO;
	}
	
	/**
	 * @param os
	 */
	public void setOffHirePlanVOs(OffHirePlanVO[] offHirePlanVOs){
		this. offHirePlanVOs = offHirePlanVOs;
	}

	public OffHirePlanVO[] getOffHirePlanVOs(){
		return offHirePlanVOs;
	}
}
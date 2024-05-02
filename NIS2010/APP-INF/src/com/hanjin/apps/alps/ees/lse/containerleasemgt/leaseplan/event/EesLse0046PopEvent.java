/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0008PopEvent.java
*@FileTitle : Invoice File Data Inquery
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.09.23 노정용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.event;

import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.vo.OffHirePlanSearchVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ees_lse_0008 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_lse_0008HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Nho Jung Yong
 * @see ees_lse_0008HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesLse0046PopEvent extends EventSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6129194606211427359L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private OffHirePlanSearchVO offHirePlanSearchVO = null;

	public EesLse0046PopEvent(){}

	public void setOffHirePlanSearchVO(OffHirePlanSearchVO offHirePlanSearchVO) {
		this.offHirePlanSearchVO = offHirePlanSearchVO;
	}

	public OffHirePlanSearchVO getOffHirePlanSearchVO() {
		return offHirePlanSearchVO;
	}
}
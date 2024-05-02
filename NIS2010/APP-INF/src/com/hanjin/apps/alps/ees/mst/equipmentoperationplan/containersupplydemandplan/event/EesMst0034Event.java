/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMst0035Event.java
*@FileTitle : Container Check Digit and Container Checking Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.06.11 이호선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.vo.EqPriceDetailVO;
import com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.vo.EqPriceOptionVO;

/**
 * EES_MST_0035 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MST_0035HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Ho Sun
 * @see EES_MST_0035HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMst0034Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private EqPriceOptionVO eqPriceOptionVO = null;

	/** Table Value Object Multi Data 처리 */
	public EqPriceDetailVO[] eqPriceDetailVos = null;
	
	/**
	 * @return the eqPriceDetailVos
	 */
	public EqPriceDetailVO[] getEqPriceDetailVos() {
		return eqPriceDetailVos;
	}

	/**
	 * @param eqPriceDetailVos the eqPriceDetailVos to set
	 */
	public void setEqPriceDetailVos(EqPriceDetailVO[] eqPriceDetailVos) {
		this.eqPriceDetailVos = eqPriceDetailVos;
	}	
	
	/**
	 * @return the eqPriceOptionVO
	 */
	public EqPriceOptionVO getEqPriceOptionVO() {
		return eqPriceOptionVO;
	}

	/**
	 * @param eqPriceOptionVO the eqPriceOptionVO to set
	 */
	public void setEqPriceOptionVO(EqPriceOptionVO eqPriceOptionVO) {
		this.eqPriceOptionVO = eqPriceOptionVO;
	}
	
}
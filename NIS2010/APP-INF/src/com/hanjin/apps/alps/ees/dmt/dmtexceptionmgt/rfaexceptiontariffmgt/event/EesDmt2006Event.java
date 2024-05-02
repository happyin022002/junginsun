/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt2006Event.java
*@FileTitle : DEM/DET Adjustment Request & Approval Status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.04
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.08.04 이성훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.event;

import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeAfterStatusInputVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EES_DMT_2006 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_2006HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SungHoon, Lee
 * @see EES_DMT_2006HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt2006Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	public EesDmt2006Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */

	
	/** Table Value Object Multi Data 처리 */
	
	private BeforeAfterStatusInputVO  inputVO = null;
	
	public void setBeforeAfterStatusInputVO(BeforeAfterStatusInputVO inputVO) {
		this.inputVO = inputVO;
	}
	
	public BeforeAfterStatusInputVO getBeforeAfterStatusInputVO() {
		return inputVO;
	}
}

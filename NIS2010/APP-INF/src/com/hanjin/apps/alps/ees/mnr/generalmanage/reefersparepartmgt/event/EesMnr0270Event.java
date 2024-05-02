/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0270Event.java
*@FileTitle : Spare Part VSL Inventory Code
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.02
*@LastModifier : 차상영
*@LastVersion : 1.0
* 2014.12.02 차상영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.event;

import com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.vo.RFVessleSparePartCodeVO;
import com.hanjin.framework.support.layer.event.EventSupport;
   

/**
 * EES_MNR_0270 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MNR_0270HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 차상영
 * @see EES_MNR_0266HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesMnr0270Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RFVessleSparePartCodeVO rfVessleSparePartCodeVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RFVessleSparePartCodeVO[] rfVessleSparePartCodeVOs = null;

	public EesMnr0270Event(){}
	
	public RFVessleSparePartCodeVO getRFVessleSparePartCodeVO() {
		return rfVessleSparePartCodeVO;
	}
	public void setRFVessleSparePartCodeVO(RFVessleSparePartCodeVO rfVessleSparePartCodeVO) {
		this.rfVessleSparePartCodeVO = rfVessleSparePartCodeVO;
	}

	public RFVessleSparePartCodeVO[] getRFVessleSparePartCodeVOs() {
		return rfVessleSparePartCodeVOs;
	}
	public void setRFVessleSparePartCodeVOs(RFVessleSparePartCodeVO[] rfVessleSparePartCodeVOs) {
		this.rfVessleSparePartCodeVOs = rfVessleSparePartCodeVOs;
	}
	
	
}
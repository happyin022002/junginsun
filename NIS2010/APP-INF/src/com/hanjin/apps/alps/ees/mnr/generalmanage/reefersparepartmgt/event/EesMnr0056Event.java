/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EssMnr0056Event.java
*@FileTitle : M&R Other Code
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 권영법
*@LastVersion : 1.0
* 2009.09.07 권영법
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.event;

import com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.vo.RFSparePartInventoryListVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.vo.RFSparePartInventoryMgtINVO;
import com.hanjin.framework.support.layer.event.EventSupport;
   

/**
 * ESS_MNR_0009 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESS_MNR_0009HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author WanGyu Kim 
 * @see EES_MNR_0056HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesMnr0056Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RFSparePartInventoryMgtINVO rfSparePartInventoryMgtINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RFSparePartInventoryListVO[] rfSparePartInventoryListVOs = null;

	public EesMnr0056Event(){}
	
	public RFSparePartInventoryMgtINVO getRFSparePartInventoryMgtINVO() {
		return rfSparePartInventoryMgtINVO;
	}
	public void setRFSparePartInventoryMgtINVO(RFSparePartInventoryMgtINVO rfSparePartInventoryMgtINVO) {
		this.rfSparePartInventoryMgtINVO = rfSparePartInventoryMgtINVO;
	}

	public RFSparePartInventoryListVO[] getRFSparePartInventoryListVOs() {
		return rfSparePartInventoryListVOs;
	}
	public void setRFSparePartInventoryListVOs(RFSparePartInventoryListVO[] rfSparePartInventoryListVOs) {
		this.rfSparePartInventoryListVOs = rfSparePartInventoryListVOs;
	}
	
}
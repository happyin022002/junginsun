/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0024Event.java
*@FileTitle : Vessel Charter / Lay up Expense
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0  
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.costsetup.event;

import com.hanjin.apps.alps.esm.coa.stdunitcost.costsetup.vo.VesselLayupVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 *  ESM_COA_0024에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0024HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi, DukWoo
 * @see ESM_COA_0024HTMLAction 참조
 * @since J2EE 1.6 VesselLayupVO
 */
public class EsmCoa0024Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private VesselLayupVO vesselLayupVO = null;

	/** Table Value Object Multi Data 처리 */
	private VesselLayupVO[] vesselLayupVOs = null;

	public EsmCoa0024Event(){}

	
	public VesselLayupVO getVesselLayupVO() {
		return vesselLayupVO;
	}

	public void setVesselLayupVO(VesselLayupVO vesselLayupVO) {
		this.vesselLayupVO = vesselLayupVO;
	}

	public VesselLayupVO[] getVesselLayupVOs() {
		return vesselLayupVOs;
	}

	public void setVesselLayupVOs(VesselLayupVO[] vesselLayupVOs) {
		this.vesselLayupVOs = vesselLayupVOs;
	}

}

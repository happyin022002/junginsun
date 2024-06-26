/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0746Event.java
*@FileTitle : Vessel Utilization Status vs. BSA by Lane
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.26
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.10.26 강동윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.VesselUtilizationStatusReportInVO;


/**
 * ESM_BKG_0746 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0746HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kang dong yun
 * @see ESM_BKG_0746HTMLAction 참조
 * @since J2EE 1.6 
 */

public class EsmBkg0746Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VesselUtilizationStatusReportInVO vesselUtilizationStatusReportInVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private VesselUtilizationStatusReportInVO[] vesselUtilizationStatusReportInVOs = null;

	public EsmBkg0746Event(){}
	
	public void setVesselUtilizationStatusReportInVO(VesselUtilizationStatusReportInVO vesselUtilizationStatusReportInVO){
		this. vesselUtilizationStatusReportInVO = vesselUtilizationStatusReportInVO;
	}

	public void setVesselUtilizationStatusReportInVOS(VesselUtilizationStatusReportInVO[] vesselUtilizationStatusReportInVOs){
		if(vesselUtilizationStatusReportInVOs != null){
			VesselUtilizationStatusReportInVO[] tmpVOs = new VesselUtilizationStatusReportInVO[vesselUtilizationStatusReportInVOs.length];
			System.arraycopy(vesselUtilizationStatusReportInVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vesselUtilizationStatusReportInVOs = tmpVOs;
		}
	}

	public VesselUtilizationStatusReportInVO getVesselUtilizationStatusReportInVO(){
		return vesselUtilizationStatusReportInVO;
	}

	public VesselUtilizationStatusReportInVO[] getVesselUtilizationStatusReportInVOS(){
		VesselUtilizationStatusReportInVO[] rtnVOs = null;
		if (this.vesselUtilizationStatusReportInVOs != null) {
			rtnVOs = new VesselUtilizationStatusReportInVO[vesselUtilizationStatusReportInVOs.length];
			System.arraycopy(vesselUtilizationStatusReportInVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}


	
}
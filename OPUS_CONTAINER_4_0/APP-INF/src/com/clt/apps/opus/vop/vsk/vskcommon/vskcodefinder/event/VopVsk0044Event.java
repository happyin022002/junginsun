/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0044Event.java
*@FileTitle : Port Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.14
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.05.14 유혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo.CarrierVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VesselVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * VOP_VSK_0219 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0219HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ryu Hyuk
 * @see VOP_VSK_0219HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopVsk0044Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VesselVO vesselVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private VesselVO[] vesselVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CarrierVO carrierVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CarrierVO[] carrierVOs = null;
	
	public VopVsk0044Event(){}
	
	public void setVesselVO(VesselVO vesselVO){
		this.vesselVO = vesselVO;
	}

	public void setVesselVOS(VesselVO[] vesselVOs){
		if (vesselVOs != null) {
			VesselVO[] tmpVOs = Arrays.copyOf(vesselVOs, vesselVOs.length);
			this.vesselVOs = tmpVOs;
		} // end if

	}

	public VesselVO getVesselVO(){
		return vesselVO;
	}

	public VesselVO[] getVesselVOS(){
		VesselVO[] rtnVOs = null;
		if (this.vesselVOs != null) {
			rtnVOs = Arrays.copyOf(this.vesselVOs, this.vesselVOs.length);
		} // end if
		return rtnVOs;
	}
	
	public void setCarrierVO(CarrierVO carrierVO){
		this.carrierVO = carrierVO;
	}

	public void setCarrierVOS(CarrierVO[] carrierVOs){
		if (carrierVOs != null) {
			CarrierVO[] tmpVOs = Arrays.copyOf(carrierVOs, carrierVOs.length);
			this.carrierVOs = tmpVOs;
		} // end if

	}

	public CarrierVO getCarrierVO(){
		return carrierVO;
	}

	public CarrierVO[] getCarrierVOS(){
		CarrierVO[] rtnVOs = null;
		if (this.carrierVOs != null) {
			rtnVOs = Arrays.copyOf(this.carrierVOs, this.carrierVOs.length);
		} // end if
		return rtnVOs;
	}

}
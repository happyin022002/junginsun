/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0249Event.java
*@FileTitle : Add Call Information (Pop-Up)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.05
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.06.05 유혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.ActivationVvdVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.LocationVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VvdVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;
import com.clt.syscommon.common.table.VskVslSkdHisVO;


/**
 * VOP_VSK_0249 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0249HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ryu Hyuk
 * @see VOP_VSK_0249HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopVsk0249Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmVslSvcLaneVO mdmVslSvcLaneVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MdmVslSvcLaneVO[] mdmVslSvcLaneVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VvdVO vvdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private VvdVO[] vvdVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private LocationVO locationVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private LocationVO[] locationVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ActivationVvdVO activationVvdVO1 = null;
	
	/** Table Value Object Multi Data 처리 */
	private ActivationVvdVO[] activationVvdVO1s = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ActivationVvdVO activationVvdVO2 = null;
	
	/** Table Value Object Multi Data 처리 */
	private ActivationVvdVO[] activationVvdVO2s = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VskVslSkdHisVO vskVslSkdHisVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private VskVslSkdHisVO[] vskVslSkdHisVOs = null;
	
	public VopVsk0249Event(){}

	public MdmVslSvcLaneVO getMdmVslSvcLaneVO() {
		return mdmVslSvcLaneVO;
	}

	public void setMdmVslSvcLaneVO(MdmVslSvcLaneVO mdmVslSvcLaneVO) {
		this.mdmVslSvcLaneVO = mdmVslSvcLaneVO;
	}

	public MdmVslSvcLaneVO[] getMdmVslSvcLaneVOS() {
		MdmVslSvcLaneVO[] rtnVOs = null;
		if (this.mdmVslSvcLaneVOs != null) {
			rtnVOs = Arrays.copyOf(this.mdmVslSvcLaneVOs, this.mdmVslSvcLaneVOs.length);
		} // end if
		return rtnVOs;
	}

	public void setMdmVslSvcLaneVOS(MdmVslSvcLaneVO[] mdmVslSvcLaneVOs) {
		if (mdmVslSvcLaneVOs != null) {
			MdmVslSvcLaneVO[] tmpVOs = Arrays.copyOf(mdmVslSvcLaneVOs, mdmVslSvcLaneVOs.length);
			this.mdmVslSvcLaneVOs = tmpVOs;
		} // end if
	}
	
	public VvdVO getVvdVO() {
		return vvdVO;
	}

	public void setVvdVO(VvdVO vvdVO) {
		this.vvdVO = vvdVO;
	}

	public VvdVO[] getVvdVOS() {
		VvdVO[] rtnVOs = null;
		if (this.vvdVOs != null) {
			rtnVOs = Arrays.copyOf(this.vvdVOs, this.vvdVOs.length);
		} // end if
		return rtnVOs;
	}

	public void setVvdVOS(VvdVO[] vvdVOs) {
		if (vvdVOs != null) {
			VvdVO[] tmpVOs = Arrays.copyOf(vvdVOs, vvdVOs.length);
			this.vvdVOs = tmpVOs;
		} // end if
	}
	
	public LocationVO getLocationVO() {
		return locationVO;
	}

	public void setLocationVO(LocationVO locationVO) {
		this.locationVO = locationVO;
	}

	public LocationVO[] getLocationVOS() {
		LocationVO[] rtnVOs = null;
		if (this.locationVOs != null) {
			rtnVOs = Arrays.copyOf(this.locationVOs, this.locationVOs.length);
		} // end if
		return rtnVOs;
	}

	public void setLocationVOS(LocationVO[] locationVOs) {
		if (locationVOs != null) {
			LocationVO[] tmpVOs = Arrays.copyOf(locationVOs, locationVOs.length);
			this.locationVOs = tmpVOs;
		} // end if
	}

	public ActivationVvdVO getActivationVvdVO1() {
		return activationVvdVO1;
	}

	public void setActivationVvdVO1(ActivationVvdVO activationVvdVO1) {
		this.activationVvdVO1 = activationVvdVO1;
	}

	public ActivationVvdVO[] getActivationVvdVO1S() {
		ActivationVvdVO[] rtnVOs = null;
		if (this.activationVvdVO1s != null) {
			rtnVOs = Arrays.copyOf(this.activationVvdVO1s, this.activationVvdVO1s.length);
		} // end if
		return rtnVOs;
	}

	public void setActivationVvdVO1S(ActivationVvdVO[] activationVvdVO1s) {
		if (activationVvdVO1s != null) {
			ActivationVvdVO[] tmpVOs = Arrays.copyOf(activationVvdVO1s, activationVvdVO1s.length);
			this.activationVvdVO1s = tmpVOs;
		} // end if
	}
	
	public ActivationVvdVO getActivationVvdVO2() {
		return activationVvdVO2;
	}

	public void setActivationVvdVO2(ActivationVvdVO activationVvdVO2) {
		this.activationVvdVO2 = activationVvdVO2;
	}

	public ActivationVvdVO[] getActivationVvdVO2S() {
		ActivationVvdVO[] rtnVOs = null;
		if (this.activationVvdVO2s != null) {
			rtnVOs = Arrays.copyOf(this.activationVvdVO2s, this.activationVvdVO2s.length);
		} // end if
		return rtnVOs;
	}

	public void setActivationVvdVO2S(ActivationVvdVO[] activationVvdVO2s) {
		if (activationVvdVO2s != null) {
			ActivationVvdVO[] tmpVOs = Arrays.copyOf(activationVvdVO2s, activationVvdVO2s.length);
			this.activationVvdVO2s = tmpVOs;
		} // end if
	}

	public VskVslSkdHisVO getVskVslSkdHisVO() {
		return vskVslSkdHisVO;
	}

	public void setVskVslSkdHisVO(VskVslSkdHisVO vskVslSkdHisVO) {
		this.vskVslSkdHisVO = vskVslSkdHisVO;
	}

	public VskVslSkdHisVO[] getVskVslSkdHisVOS() {
		VskVslSkdHisVO[] rtnVOs = null;
		if (this.vskVslSkdHisVOs != null) {
			rtnVOs = Arrays.copyOf(this.vskVslSkdHisVOs, this.vskVslSkdHisVOs.length);
		} // end if
		return rtnVOs;
	}

	public void setVskVslSkdHisVOS(VskVslSkdHisVO[] vskVslSkdHisVOs) {
		if (vskVslSkdHisVOs != null) {
			VskVslSkdHisVO[] tmpVOs = Arrays.copyOf(vskVslSkdHisVOs, vskVslSkdHisVOs.length);
			this.vskVslSkdHisVOs = tmpVOs;
		} // end if
	}
	
	
	
	
}
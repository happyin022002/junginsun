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
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event;

import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.ActivationVvdVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.LocationVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VvdVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;
import com.hanjin.syscommon.common.table.VskVslSkdHisVO;


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
		MdmVslSvcLaneVO[] rtnVOs =  null;
		if(this.mdmVslSvcLaneVOs != null){
			rtnVOs = new MdmVslSvcLaneVO[mdmVslSvcLaneVOs.length];
			System.arraycopy(mdmVslSvcLaneVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return mdmVslSvcLaneVOs;
	}

	public void setMdmVslSvcLaneVOS(MdmVslSvcLaneVO[] mdmVslSvcLaneVOs) {
		if(mdmVslSvcLaneVOs != null){
			MdmVslSvcLaneVO[] tmpVOs = new MdmVslSvcLaneVO[mdmVslSvcLaneVOs.length];
			System.arraycopy(mdmVslSvcLaneVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mdmVslSvcLaneVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this.mdmVslSvcLaneVOs = mdmVslSvcLaneVOs;
	}
	
	public VvdVO getVvdVO() {
		return vvdVO;
	}

	public void setVvdVO(VvdVO vvdVO) {
		this.vvdVO = vvdVO;
	}

	public VvdVO[] getVvdVOS() {
		VvdVO[] rtnVOs =  null;
		if(this.vvdVOs != null){
			rtnVOs = new VvdVO[vvdVOs.length];
			System.arraycopy(vvdVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return vvdVOs;
	}

	public void setVvdVOS(VvdVO[] vvdVOs) {
		if(vvdVOs != null){
			VvdVO[] tmpVOs = new VvdVO[vvdVOs.length];
			System.arraycopy(vvdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vvdVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this.vvdVOs = vvdVOs;
	}
	
	public LocationVO getLocationVO() {
		return locationVO;
	}

	public void setLocationVO(LocationVO locationVO) {
		this.locationVO = locationVO;
	}

	public LocationVO[] getLocationVOS() {
		LocationVO[] rtnVOs =  null;
		if(this.locationVOs != null){
			rtnVOs = new LocationVO[locationVOs.length];
			System.arraycopy(locationVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return locationVOs;
	}

	public void setLocationVOS(LocationVO[] locationVOs) {
		if(locationVOs != null){
			LocationVO[] tmpVOs = new LocationVO[locationVOs.length];
			System.arraycopy(locationVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.locationVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this.locationVOs = locationVOs;
	}

	public ActivationVvdVO getActivationVvdVO1() {
		return activationVvdVO1;
	}

	public void setActivationVvdVO1(ActivationVvdVO activationVvdVO1) {
		this.activationVvdVO1 = activationVvdVO1;
	}

	public ActivationVvdVO[] getActivationVvdVO1S() {
		ActivationVvdVO[] rtnVOs =  null;
		if(this.activationVvdVO1s != null){
			rtnVOs = new ActivationVvdVO[activationVvdVO1s.length];
			System.arraycopy(activationVvdVO1s, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return activationVvdVO1s;
	}

	public void setActivationVvdVO1S(ActivationVvdVO[] activationVvdVO1s) {
		if(activationVvdVO1s != null){
			ActivationVvdVO[] tmpVOs = new ActivationVvdVO[activationVvdVO1s.length];
			System.arraycopy(activationVvdVO1s, 0, tmpVOs, 0, tmpVOs.length);
			this.activationVvdVO1s = tmpVOs;
		}
		//소스보안 2015.08
		//this.activationVvdVO1s = activationVvdVO1s;
	}
	
	public ActivationVvdVO getActivationVvdVO2() {
		return activationVvdVO2;
	}

	public void setActivationVvdVO2(ActivationVvdVO activationVvdVO2) {
		this.activationVvdVO2 = activationVvdVO2;
	}

	public ActivationVvdVO[] getActivationVvdVO2S() {
		ActivationVvdVO[] rtnVOs =  null;
		if(this.activationVvdVO2s != null){
			rtnVOs = new ActivationVvdVO[activationVvdVO2s.length];
			System.arraycopy(activationVvdVO2s, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return activationVvdVO2s;
	}

	public void setActivationVvdVO2S(ActivationVvdVO[] activationVvdVO2s) {
		if(activationVvdVO2s != null){
			ActivationVvdVO[] tmpVOs = new ActivationVvdVO[activationVvdVO2s.length];
			System.arraycopy(activationVvdVO2s, 0, tmpVOs, 0, tmpVOs.length);
			this.activationVvdVO2s = tmpVOs;
		}
		//소스보안 2015.08
		//this.activationVvdVO2s = activationVvdVO2s;
	}

	public VskVslSkdHisVO getVskVslSkdHisVO() {
		return vskVslSkdHisVO;
	}

	public void setVskVslSkdHisVO(VskVslSkdHisVO vskVslSkdHisVO) {
		this.vskVslSkdHisVO = vskVslSkdHisVO;
	}

	public VskVslSkdHisVO[] getVskVslSkdHisVOS() {
		VskVslSkdHisVO[] rtnVOs =  null;
		if(this.vskVslSkdHisVOs != null){
			rtnVOs = new VskVslSkdHisVO[vskVslSkdHisVOs.length];
			System.arraycopy(vskVslSkdHisVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return vskVslSkdHisVOs;
	}

	public void setVskVslSkdHisVOS(VskVslSkdHisVO[] vskVslSkdHisVOs) {
		if(vskVslSkdHisVOs != null){
			VskVslSkdHisVO[] tmpVOs = new VskVslSkdHisVO[vskVslSkdHisVOs.length];
			System.arraycopy(vskVslSkdHisVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vskVslSkdHisVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this.vskVslSkdHisVOs = vskVslSkdHisVOs;
	}
	
	
	
	
}
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0512Event.java
*@FileTitle : Lane Information Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.06.16 장석현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.vo.LaneInfoConditionVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.vo.VskPortBnkRfuelRtoSheetVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;
import com.clt.syscommon.common.table.VskLanePicVO;


/**
 * VOP_VSK_0010 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0010HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Suk Hyun
 * @see VOP_VSK_0010HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopVsk0512Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private MdmVslSvcLaneVO mdmVslSvcLaneVO = null;
	
	private LaneInfoConditionVO laneInfoConditionVO = null;
	
	public LaneInfoConditionVO getLaneInfoConditionVO() {
		return laneInfoConditionVO;
	}

	public void setLaneInfoConditionVO(LaneInfoConditionVO laneInfoConditionVO) {
		this.laneInfoConditionVO = laneInfoConditionVO;
	}

	private VskLanePicVO vskLanePicVO = null;

	private VskLanePicVO[] vskLanePicVOs = null;	

	private VskPortBnkRfuelRtoSheetVO[] vskPortBnkRfuelRtoSheetVOs = null;	
	
	public VskPortBnkRfuelRtoSheetVO[] getVskPortBnkRfuelRtoSheetVOS() {
		VskPortBnkRfuelRtoSheetVO[] rtnVOs = null;
		if (this.vskPortBnkRfuelRtoSheetVOs != null) {
			rtnVOs = Arrays.copyOf(vskPortBnkRfuelRtoSheetVOs, vskPortBnkRfuelRtoSheetVOs.length);
		}
		return rtnVOs;
	}

	public void setVskPortBnkRfuelRtoSheetVOS(
			VskPortBnkRfuelRtoSheetVO[] vskPortBnkRfuelRtoSheetVOs) {
		if(vskPortBnkRfuelRtoSheetVOs != null){
			VskPortBnkRfuelRtoSheetVO[] tmpVOs = Arrays.copyOf(vskPortBnkRfuelRtoSheetVOs, vskPortBnkRfuelRtoSheetVOs.length);
			this.vskPortBnkRfuelRtoSheetVOs = tmpVOs;
		}
	}

	public VskLanePicVO[] getVskLanePicVOS() {
		VskLanePicVO[] rtnVOs = null;
		if (this.vskLanePicVOs != null) {
			rtnVOs = Arrays.copyOf(vskLanePicVOs, vskLanePicVOs.length);
		}
		return rtnVOs;
	}

	public void setVskLanePicVOS(VskLanePicVO[] vskLanePicVOs) {
		if(vskLanePicVOs != null){
			VskLanePicVO[] tmpVOs = Arrays.copyOf(vskLanePicVOs, vskLanePicVOs.length);
			this.vskLanePicVOs = tmpVOs;
		}
	}

	public VskLanePicVO getVskLanePicVO() {
		return vskLanePicVO;
	}

	public void setVskLanePicVO(VskLanePicVO vskLanePicVO) {
		this.vskLanePicVO = vskLanePicVO;
	}

	public MdmVslSvcLaneVO getMdmVslSvcLaneVO() {
		return mdmVslSvcLaneVO;
	}

	public void setMdmVslSvcLaneVO(MdmVslSvcLaneVO mdmVslSvcLaneVO) {
		this.mdmVslSvcLaneVO = mdmVslSvcLaneVO;
	}

	public VopVsk0512Event(){}
	
	

}
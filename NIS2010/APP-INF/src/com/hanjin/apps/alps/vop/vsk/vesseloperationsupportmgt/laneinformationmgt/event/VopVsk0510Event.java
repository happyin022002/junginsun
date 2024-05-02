/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0510Event.java
*@FileTitle : Lane Information Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.28
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.06.16 장석현
* 1.0 Creation
* 
* History
* 2011.04.28 진마리아 [CHM-201110229-01] Lane informtion내 PIC의 Vessel 칼럼을 Carrier로 변경 요청건 - Carrier Code 체크로직 생성
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.event;

import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.vo.VskPortBnkRfuelRtoSheetVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;
import com.hanjin.syscommon.common.table.VskLanePicVO;


/**
 * VOP_VSK_0510 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0510HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Suk Hyun
 * @see VOP_VSK_0510HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopVsk0510Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private MdmVslSvcLaneVO mdmVslSvcLaneVO = null;
	
	private VskLanePicVO vskLanePicVO = null;

	private VskLanePicVO[] vskLanePicVOs = null;
	
	private String crrCd = null;

	private VskPortBnkRfuelRtoSheetVO[] vskPortBnkRfuelRtoSheetVOs = null;	
	
	public VskPortBnkRfuelRtoSheetVO[] getVskPortBnkRfuelRtoSheetVOS() { 
		VskPortBnkRfuelRtoSheetVO[] rtnVOs =  null;
		if(this.vskPortBnkRfuelRtoSheetVOs != null){
			rtnVOs = new VskPortBnkRfuelRtoSheetVO[vskPortBnkRfuelRtoSheetVOs.length];
			System.arraycopy(vskPortBnkRfuelRtoSheetVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.20
		//return vskPortBnkRfuelRtoSheetVOs;
	}

	public void setVskPortBnkRfuelRtoSheetVOS(VskPortBnkRfuelRtoSheetVO[] vskPortBnkRfuelRtoSheetVOs) {
		if(vskPortBnkRfuelRtoSheetVOs != null){
			VskPortBnkRfuelRtoSheetVO[] tmpVOs = new VskPortBnkRfuelRtoSheetVO[vskPortBnkRfuelRtoSheetVOs.length];
			System.arraycopy(vskPortBnkRfuelRtoSheetVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vskPortBnkRfuelRtoSheetVOs = tmpVOs;
		}
		//소스보안 2015.07.20
		//this.vskPortBnkRfuelRtoSheetVOs = vskPortBnkRfuelRtoSheetVOs;
	}

	public VskLanePicVO[] getVskLanePicVOS() {
		VskLanePicVO[] rtnVOs =  null;
		if(this.vskLanePicVOs != null){
			rtnVOs = new VskLanePicVO[vskLanePicVOs.length];
			System.arraycopy(vskLanePicVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.20
		//return vskLanePicVOs;
	}

	public void setVskLanePicVOS(VskLanePicVO[] vskLanePicVOs) {
		if(vskLanePicVOs != null){
			VskLanePicVO[] tmpVOs = new VskLanePicVO[vskLanePicVOs.length];
			System.arraycopy(vskLanePicVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vskLanePicVOs = tmpVOs;
		}
		//소스보안 2015.07.20
		//this.vskLanePicVOs = vskLanePicVOs;
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

	public String getCrrCd() {
		return crrCd;
	}

	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
	}

	public VopVsk0510Event(){}
	
	

}
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0702Event.java
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

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;


/**
 * VOP_VSK_0010 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0010HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Suk Hyun
 * @see VOP_VSK_0010HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopVsk0702Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private MdmVslSvcLaneVO mdmVslSvcLaneVO = null;
	
	private MdmVslSvcLaneVO[] mdmVslSvcLaneVOs = null;

	public MdmVslSvcLaneVO[] getMdmVslSvcLaneVOS() {
		MdmVslSvcLaneVO[] rtnVOs = null;
		if (this.mdmVslSvcLaneVOs != null) {
			rtnVOs = Arrays.copyOf(mdmVslSvcLaneVOs, mdmVslSvcLaneVOs.length);
		}
		return rtnVOs;
	}

	public void setMdmVslSvcLaneVOS(MdmVslSvcLaneVO[] mdmVslSvcLaneVOs) {
		if(mdmVslSvcLaneVOs != null){
			MdmVslSvcLaneVO[] tmpVOs = Arrays.copyOf(mdmVslSvcLaneVOs, mdmVslSvcLaneVOs.length);
			this.mdmVslSvcLaneVOs = tmpVOs;
		}
	}

	public MdmVslSvcLaneVO getMdmVslSvcLaneVO() {
		return mdmVslSvcLaneVO;
	}

	public void setMdmVslSvcLaneVO(MdmVslSvcLaneVO mdmVslSvcLaneVO) {
		this.mdmVslSvcLaneVO = mdmVslSvcLaneVO;
	}

	public VopVsk0702Event(){}
	
	

}
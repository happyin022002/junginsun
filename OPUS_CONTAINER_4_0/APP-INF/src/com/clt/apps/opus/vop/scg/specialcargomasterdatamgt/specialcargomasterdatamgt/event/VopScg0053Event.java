/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg0053Event.java
*@FileTitle : Target Lane for SPCL CGO APVL (Inquiry)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.05.26 장강철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.MdmVslSvcLaneListVO;
import com.clt.framework.support.layer.event.EventSupport;
 

/**
 * VOP_SCG_0053 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG_0053HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see VOP_SCG_0053HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg0053Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmVslSvcLaneListVO mdmVslSvcLaneListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MdmVslSvcLaneListVO[] mdmVslSvcLaneListVOs = null;

	public VopScg0053Event(){}
	
	public void setMdmVslSvcLaneListVO(MdmVslSvcLaneListVO mdmVslSvcLaneListVO){
		this. mdmVslSvcLaneListVO = mdmVslSvcLaneListVO;
	}

	public void setMdmVslSvcLaneListVOS(MdmVslSvcLaneListVO[] mdmVslSvcLaneListVOs){
		if(mdmVslSvcLaneListVOs != null){
			MdmVslSvcLaneListVO[] tmpVOs = Arrays.copyOf(mdmVslSvcLaneListVOs, mdmVslSvcLaneListVOs.length);
			this.mdmVslSvcLaneListVOs = tmpVOs;
		}
	}

	public MdmVslSvcLaneListVO getMdmVslSvcLaneListVO(){
		return mdmVslSvcLaneListVO;
	}

	public MdmVslSvcLaneListVO[] getMdmVslSvcLaneListVOS(){
		MdmVslSvcLaneListVO[] rtnVOs = null;
		if (this.mdmVslSvcLaneListVOs != null) {
			rtnVOs = Arrays.copyOf(mdmVslSvcLaneListVOs, mdmVslSvcLaneListVOs.length);
		}
		return rtnVOs;
	}

}
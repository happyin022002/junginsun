/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg0035Event.java
*@FileTitle : Target Lane for SPCL CGO APVL (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.05.25 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.MdmVslSvcLaneListVO;


/**
 * VOP_SCG_0035 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG_0035HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see VOP_SCG_0035HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg0035Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmVslSvcLaneListVO mdmVslSvcLaneListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MdmVslSvcLaneListVO[] mdmVslSvcLaneListVOs = null;

	public VopScg0035Event(){}
	
	public void setMdmVslSvcLaneListVO(MdmVslSvcLaneListVO mdmVslSvcLaneListVO){
		this. mdmVslSvcLaneListVO = mdmVslSvcLaneListVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setMdmVslSvcLaneListVOS(MdmVslSvcLaneListVO[] mdmVslSvcLaneListVOs){
		if (mdmVslSvcLaneListVOs != null) {
			MdmVslSvcLaneListVO[] tmpVOs = new MdmVslSvcLaneListVO[mdmVslSvcLaneListVOs.length];
			System.arraycopy(mdmVslSvcLaneListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mdmVslSvcLaneListVOs = tmpVOs;
		}
	}

	public MdmVslSvcLaneListVO getMdmVslSvcLaneListVO(){
		return mdmVslSvcLaneListVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public MdmVslSvcLaneListVO[] getMdmVslSvcLaneListVOS(){
		MdmVslSvcLaneListVO[] rtnVOs = null;
		if (this.mdmVslSvcLaneListVOs != null) {
			rtnVOs = new MdmVslSvcLaneListVO[mdmVslSvcLaneListVOs.length];
			System.arraycopy(mdmVslSvcLaneListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}
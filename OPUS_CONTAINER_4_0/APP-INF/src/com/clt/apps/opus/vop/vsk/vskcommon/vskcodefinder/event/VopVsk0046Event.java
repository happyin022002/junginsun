/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0046Event.java
*@FileTitle : Lane Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.06.04 유혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.event;

import java.util.Arrays;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;


/**
 * VOP_VSK_0046 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0046HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ryu Hyuk
 * @see VOP_VSK_0046HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopVsk0046Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmVslSvcLaneVO mdmVslSvcLaneVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MdmVslSvcLaneVO[] mdmVslSvcLaneVOs = null;
	
	public VopVsk0046Event(){}
	
	public void setMdmVslSvcLaneVO(MdmVslSvcLaneVO mdmVslSvcLaneVO){
		this.mdmVslSvcLaneVO = mdmVslSvcLaneVO;
	}

	public void setMdmVslSvcLaneVOS(MdmVslSvcLaneVO[] mdmVslSvcLaneVOs){
		if (mdmVslSvcLaneVOs != null) {
			MdmVslSvcLaneVO[] tmpVOs = Arrays.copyOf(mdmVslSvcLaneVOs, mdmVslSvcLaneVOs.length);
			this.mdmVslSvcLaneVOs = tmpVOs;
		} // end if
	}

	public MdmVslSvcLaneVO getMdmVslSvcLaneVO(){
		return mdmVslSvcLaneVO;
	}

	public MdmVslSvcLaneVO[] getMdmVslSvcLaneVOS(){
		MdmVslSvcLaneVO[] rtnVOs = null;
		if (this.mdmVslSvcLaneVOs != null) {
			rtnVOs = Arrays.copyOf(this.mdmVslSvcLaneVOs, this.mdmVslSvcLaneVOs.length);
		} // end if
		return rtnVOs;
	}

}
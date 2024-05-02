/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VopVsk5001Event.java
*@FileTitle : consortiumvoyagemgt
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.01
*@LastModifier : dongsoo
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleutilitymanagement.consortiumvoyagemgt.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VOP_VSK_0010HTMLAction;
import com.clt.apps.opus.vop.vsk.scheduleutilitymanagement.consortiumvoyagemgt.vo.ConsortiumVoyageVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * VOP_VSK-0010 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK-0010HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ryu Hyuk
 * @see VOP_VSK_0010HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopVsk5001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ConsortiumVoyageVO consortiumVoyageVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ConsortiumVoyageVO[] consortiumVoyageVOs = null;
	
	public VopVsk5001Event(){}

	public ConsortiumVoyageVO getConsortiumVoyageVO() {
		return consortiumVoyageVO;
	}

	public void setConsortiumVoyageVO(ConsortiumVoyageVO consortiumVoyageVO) {
		this.consortiumVoyageVO = consortiumVoyageVO;
	}

	public ConsortiumVoyageVO[] getConsortiumVoyageVOs() {
		ConsortiumVoyageVO[] rtnVOs = null;
		if (this.consortiumVoyageVOs != null) {
			rtnVOs = Arrays.copyOf(this.consortiumVoyageVOs, this.consortiumVoyageVOs.length);
		} // end if
		return rtnVOs;
	}

	public void setConsortiumVoyageVOs(ConsortiumVoyageVO[] consortiumVoyageVOs) {
		if (consortiumVoyageVOs != null) {
			ConsortiumVoyageVO[] tmpVOs = Arrays.copyOf(consortiumVoyageVOs, consortiumVoyageVOs.length);
			this.consortiumVoyageVOs = tmpVOs;
		} // end if
	}
}
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopOpf1052Event.java
*@FileTitle : Supporting Upload
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.06.25 이선영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.event;

import java.util.Arrays;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.OpfStvDmgAtchFileVO;


/**
 * VOP_OPF_1052 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF_1052HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Sunyoung
 * @see VOP_OPF_1052HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopOpf1052Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OpfStvDmgAtchFileVO opfStvDmgAtchFileVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private OpfStvDmgAtchFileVO[] opfStvDmgAtchFileVOs = null;

	public VopOpf1052Event(){}
	
	public void setOpfStvDmgAtchFileVO(OpfStvDmgAtchFileVO opfStvDmgAtchFileVO){
		this. opfStvDmgAtchFileVO = opfStvDmgAtchFileVO;
	}

	public void setOpfStvDmgAtchFileVOS(OpfStvDmgAtchFileVO[] opfStvDmgAtchFileVOs){
		if (opfStvDmgAtchFileVOs != null) {
			OpfStvDmgAtchFileVO[] tmpVOs = Arrays.copyOf(opfStvDmgAtchFileVOs, opfStvDmgAtchFileVOs.length);
			this.opfStvDmgAtchFileVOs = tmpVOs;
		} // end if
	}

	public OpfStvDmgAtchFileVO getOpfStvDmgAtchFileVO(){
		return opfStvDmgAtchFileVO;
	}

	public OpfStvDmgAtchFileVO[] getOpfStvDmgAtchFileVOS(){
		OpfStvDmgAtchFileVO[] rtnVOs = null;
		if (this.opfStvDmgAtchFileVOs != null) {
			rtnVOs = Arrays.copyOf(this.opfStvDmgAtchFileVOs, this.opfStvDmgAtchFileVOs.length);
		} // end if
		return rtnVOs;
	}

}
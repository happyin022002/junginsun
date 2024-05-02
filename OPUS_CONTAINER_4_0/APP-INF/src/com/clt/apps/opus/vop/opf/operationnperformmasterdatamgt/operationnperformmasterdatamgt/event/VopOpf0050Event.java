/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopOpf0048Event.java
*@FileTitle : Stevedore Damage Part Code (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 우지석
*@LastVersion : 1.0
* 2009.05.12 우지석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.event;

import java.util.Arrays;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.OpfStvDmgCdVO;


/**
 * vop_opf_0048 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  vop_opf_0048HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ji Seok Woo
 * @see vop_opf_0048HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopOpf0050Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OpfStvDmgCdVO opfStvDmgCdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private OpfStvDmgCdVO[] opfStvDmgCdVOs = null;

	public VopOpf0050Event(){}
	
	public void setOpfStvDmgCdVO(OpfStvDmgCdVO opfStvDmgCdVO){
		this. opfStvDmgCdVO = opfStvDmgCdVO;
	}

	public void setOpfStvDmgCdVOS(OpfStvDmgCdVO[] opfStvDmgCdVOs){
		if (opfStvDmgCdVOs != null) {
			OpfStvDmgCdVO[] tmpVOs = Arrays.copyOf(opfStvDmgCdVOs, opfStvDmgCdVOs.length);
			this.opfStvDmgCdVOs = tmpVOs;
		} // end if
	}

	public OpfStvDmgCdVO getOpfStvDmgCdVO(){
		return opfStvDmgCdVO;
	}

	public OpfStvDmgCdVO[] getOpfStvDmgCdVOS(){
		OpfStvDmgCdVO[] rtnVOs = null;
		if (this.opfStvDmgCdVOs != null) {
			rtnVOs = Arrays.copyOf(this.opfStvDmgCdVOs, this.opfStvDmgCdVOs.length);
		} // end if
		return rtnVOs;
	}

}
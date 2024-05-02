/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VopOpf9003Event.java
*@FileTitle : COD Diversion Fee Cdoe
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.12
*@LastModifier : 백승일
*@LastVersion : 1.0
* 2012.04.12 백승일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.event;

import java.util.Arrays;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.OpfCodDvsFeeVO;


/**
 * VOP_OPF_9003 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF_9003HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Baek Seungil
 * @see VOP_OPF_9003HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopOpf9003Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OpfCodDvsFeeVO opfCodDvsFeeVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private OpfCodDvsFeeVO[] opfCodDvsFeeVOs = null;

	public VopOpf9003Event(){}
	
	public void setOpfCodDvsFeeVO(OpfCodDvsFeeVO opfCodDvsFeeVO){
		this. opfCodDvsFeeVO = opfCodDvsFeeVO;
	}

	public void setOpfCodDvsFeeVOS(OpfCodDvsFeeVO[] opfCodDvsFeeVOs){
		if (opfCodDvsFeeVOs != null) {
			OpfCodDvsFeeVO[] tmpVOs = Arrays.copyOf(opfCodDvsFeeVOs, opfCodDvsFeeVOs.length);
			this.opfCodDvsFeeVOs = tmpVOs;
		} // end if
	}

	public OpfCodDvsFeeVO getOpfCodDvsFeeVO(){
		return opfCodDvsFeeVO;
	}

	public OpfCodDvsFeeVO[] getOpfCodDvsFeeVOS(){
		OpfCodDvsFeeVO[] rtnVOs = null;
		if (this.opfCodDvsFeeVOs != null) {
			rtnVOs = Arrays.copyOf(this.opfCodDvsFeeVOs, this.opfCodDvsFeeVOs.length);
		} // end if
		return rtnVOs;
	}

}
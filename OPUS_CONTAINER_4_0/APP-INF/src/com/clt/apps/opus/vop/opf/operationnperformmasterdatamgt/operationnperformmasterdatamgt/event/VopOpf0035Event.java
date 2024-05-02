/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopOpf0034Event.java
*@FileTitle : COD Reject Reason Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.05.11 이선영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.event;
 
import java.util.Arrays;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.OpfCodRjctCdVO;


/**
 * VOP_OPF-0034 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF-0034HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Sunyoung
 * @see VOP_OPF-0034HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopOpf0035Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OpfCodRjctCdVO opfCodRjctCdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private OpfCodRjctCdVO[] opfCodRjctCdVOs = null;

	public VopOpf0035Event(){}
	
	public void setOpfCodRjctCdVO(OpfCodRjctCdVO opfCodRjctCdVO){
		this. opfCodRjctCdVO = opfCodRjctCdVO;
	}

	public void setOpfCodRjctCdVOS(OpfCodRjctCdVO[] opfCodRjctCdVOs){
		if (opfCodRjctCdVOs != null) {
			OpfCodRjctCdVO[] tmpVOs = Arrays.copyOf(opfCodRjctCdVOs, opfCodRjctCdVOs.length);
			this.opfCodRjctCdVOs = tmpVOs;
		} // end if
	}

	public OpfCodRjctCdVO getOpfCodRjctCdVO(){
		return opfCodRjctCdVO;
	}

	public OpfCodRjctCdVO[] getOpfCodRjctCdVOS(){
		OpfCodRjctCdVO[] rtnVOs = null;
		if (this.opfCodRjctCdVOs != null) {
			rtnVOs = Arrays.copyOf(this.opfCodRjctCdVOs, this.opfCodRjctCdVOs.length);
		} // end if
		return rtnVOs;
	}

}
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopOpf0068Event.java
*@FileTitle : TPR Target Ports Register
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.05.19 장석현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.event;

import java.util.Arrays;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.MdmLocationVO;


/**
 * VOP_OPF_0068 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF_0068HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Suk Hyun
 * @see VOP_OPF_0068HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopOpf0068Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmLocationVO mdmLocationVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MdmLocationVO[] mdmLocationVOs = null;

	public VopOpf0068Event(){}
	
	public void setMdmLocationVO(MdmLocationVO mdmLocationVO){
		this. mdmLocationVO = mdmLocationVO;
	}

	public void setMdmLocationVOS(MdmLocationVO[] mdmLocationVOs){
		if (mdmLocationVOs != null) {
			MdmLocationVO[] tmpVOs = Arrays.copyOf(mdmLocationVOs, mdmLocationVOs.length);
			this.mdmLocationVOs = tmpVOs;
		} // end if
	}

	public MdmLocationVO getMdmLocationVO(){
		return mdmLocationVO;
	}

	public MdmLocationVO[] getMdmLocationVOS(){
		MdmLocationVO[] rtnVOs = null;
		if (this.mdmLocationVOs != null) {
			rtnVOs = Arrays.copyOf(this.mdmLocationVOs, this.mdmLocationVOs.length);
		} // end if
		return rtnVOs;
	}

}
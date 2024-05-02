/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri4013Event.java
*@FileTitle : Vessel Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.05.27 문동규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.vessel.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MdmVslCntrVO;


/**
 * ESM_PRI_4013 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_4013HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Moon Dong Gyu
 * @see ESM_PRI_4013HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri4013Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmVslCntrVO mdmVslCntrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MdmVslCntrVO[] mdmVslCntrVOs = null;

	public EsmPri4013Event(){}
	
	public void setMdmVslCntrVO(MdmVslCntrVO mdmVslCntrVO){
		this. mdmVslCntrVO = mdmVslCntrVO;
	}

	public void setMdmVslCntrVOS(MdmVslCntrVO[] mdmVslCntrVOs){
		this. mdmVslCntrVOs = mdmVslCntrVOs;
	}

	public MdmVslCntrVO getMdmVslCntrVO(){
		return mdmVslCntrVO;
	}

	public MdmVslCntrVO[] getMdmVslCntrVOS(){
		return mdmVslCntrVOs;
	}

}
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri4014Event.java
*@FileTitle : Customer Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.29
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.04.29 김재연
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.event;

import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.vo.MdmCustVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_4014 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_4014HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JaeYeon Kim
 * @see ESM_PRI_4014HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri8105Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmCustVO mdmCustVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MdmCustVO[] mdmCustVOs = null;

	public EsmPri8105Event(){}
	
	public void setMdmCustVO(MdmCustVO mdmCustVO){
		this. mdmCustVO = mdmCustVO;
	}

	public void setMdmCustVOS(MdmCustVO[] mdmCustVOs){
		this. mdmCustVOs = mdmCustVOs;
	}

	public MdmCustVO getMdmCustVO(){
		return mdmCustVO;
	}

	public MdmCustVO[] getMdmCustVOS(){
		return mdmCustVOs;
	}

}
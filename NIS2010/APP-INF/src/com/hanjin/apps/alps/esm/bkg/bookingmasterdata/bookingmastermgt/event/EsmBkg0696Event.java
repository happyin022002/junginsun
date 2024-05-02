/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0696Event.java
*@FileTitle : Package Table
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.05.19 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MdmPckTpVO;


/**
 * esm_bkg_0696.jsp 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  esm_bkg_0696HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Jong
 * @see esm_bkg_0696HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0696Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmPckTpVO mdmPckTpVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MdmPckTpVO[] mdmPckTpVOs = null;

	public EsmBkg0696Event(){}
	
	public void setMdmPckTpVO(MdmPckTpVO mdmPckTpVO){
		this. mdmPckTpVO = mdmPckTpVO;
	}

	public void setMdmPckTpVOS(MdmPckTpVO[] mdmPckTpVOs){
		this. mdmPckTpVOs = mdmPckTpVOs;
	}

	public MdmPckTpVO getMdmPckTpVO(){
		return mdmPckTpVO;
	}

	public MdmPckTpVO[] getMdmPckTpVOS(){
		return mdmPckTpVOs;
	}

}
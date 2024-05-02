/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0080Event.java
*@FileTitle : Booking Creation 1_Container Type/Size
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.05.04 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MdmCntrTpSzVO;


/**
 * esm_bkg_0080 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  esm_bkg_0080HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Jong
 * @see esm_bkg_0080HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0080Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmCntrTpSzVO mdmCntrTpSzVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MdmCntrTpSzVO[] mdmCntrTpSzVOs = null;

	public EsmBkg0080Event(){}
	
	public void setMdmCntrTpSzVO(MdmCntrTpSzVO mdmCntrTpSzVO){
		this. mdmCntrTpSzVO = mdmCntrTpSzVO;
	}

	public void setMdmCntrTpSzVOS(MdmCntrTpSzVO[] mdmCntrTpSzVOs){
		this. mdmCntrTpSzVOs = mdmCntrTpSzVOs;
	}

	public MdmCntrTpSzVO getMdmCntrTpSzVO(){
		return mdmCntrTpSzVO;
	}

	public MdmCntrTpSzVO[] getMdmCntrTpSzVOS(){
		return mdmCntrTpSzVOs;
	}

}
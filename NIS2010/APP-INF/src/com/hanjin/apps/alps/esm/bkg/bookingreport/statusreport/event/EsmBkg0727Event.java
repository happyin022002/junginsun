/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0727Event.java
*@FileTitle : BDR Booking No Status - Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.14
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.08.14 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.BdrBookingNoListVO;


/**
 * ESM_BKG_0727 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0727HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Jong
 * @see ESM_BKG_0727HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0727Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BdrBookingNoListVO bdrBookingNoListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BdrBookingNoListVO[] bdrBookingNoListVOs = null;

	public EsmBkg0727Event(){}
	
	public void setBdrBookingNoListVO(BdrBookingNoListVO bdrBookingNoListVO){
		this. bdrBookingNoListVO = bdrBookingNoListVO;
	}

	public void setBdrBookingNoListVOS(BdrBookingNoListVO[] bdrBookingNoListVOs){
		this. bdrBookingNoListVOs = bdrBookingNoListVOs;
	}

	public BdrBookingNoListVO getBdrBookingNoListVO(){
		return bdrBookingNoListVO;
	}

	public BdrBookingNoListVO[] getBdrBookingNoListVOS(){
		return bdrBookingNoListVOs;
	}

}
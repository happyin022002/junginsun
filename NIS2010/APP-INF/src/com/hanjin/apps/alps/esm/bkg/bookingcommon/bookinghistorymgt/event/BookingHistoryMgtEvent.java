/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingHistoryMgtEvent.java
*@FileTitle : Booking_History_Mgt
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.05.11 김영출
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.event;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.MndVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * Booking_History_Mgt 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  Booking_History_MgtHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Youngchul
 * @see Booking_History_MgtHTMLAction 참조
 * @since J2EE 1.4
 */

public class BookingHistoryMgtEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MndVO mndVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MndVO[] mndVOs = null;

	public BookingHistoryMgtEvent(){}
	
	public void setMndVO(MndVO mndVO){
		this. mndVO = mndVO;
	}

	public void setMndVOS(MndVO[] mndVOs){
		this. mndVOs = mndVOs;
	}

	public MndVO getMndVO(){
		return mndVO;
	}

	public MndVO[] getMndVOS(){
		return mndVOs;
	}

}
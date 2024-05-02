/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1100Event.java
*@FileTitle : e-Booking n SI Process
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.05.21 전용진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.EBookingControlMgmtVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_1100 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1100HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jun Yong Jin
 * @see ESM_BKG_1100HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg1100Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	public EsmBkg1100Event(){}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private EBookingControlMgmtVO eBookingControlMgmtVO = null;

	/** Table Value Object Multi Data 처리 */
	private EBookingControlMgmtVO[] eBookingControlMgmtVOs = null;

	public EBookingControlMgmtVO getEBookingControlMgmtVO() {
		return eBookingControlMgmtVO;
	}

	public void setEBookingControlMgmtVO(EBookingControlMgmtVO bookingControlMgmtVO) {
		eBookingControlMgmtVO = bookingControlMgmtVO;
	}

	public EBookingControlMgmtVO[] getEBookingControlMgmtVOs() {
		EBookingControlMgmtVO[] rtnVOs = null;
		if (this.eBookingControlMgmtVOs != null) {
			rtnVOs = Arrays.copyOf(eBookingControlMgmtVOs, eBookingControlMgmtVOs.length);
		}
		return rtnVOs;
	}

	public void setEBookingControlMgmtVOs(EBookingControlMgmtVO[] eBookingControlMgmtVOs){
		if(eBookingControlMgmtVOs != null){
			EBookingControlMgmtVO[] tmpVOs = Arrays.copyOf(eBookingControlMgmtVOs, eBookingControlMgmtVOs.length);
			this.eBookingControlMgmtVOs = tmpVOs;
		}
	}
	

}
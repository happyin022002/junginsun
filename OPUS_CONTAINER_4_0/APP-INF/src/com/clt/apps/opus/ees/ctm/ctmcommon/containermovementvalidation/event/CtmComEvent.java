/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CtmcommonEvent.java
*@FileTitle : CTM Common Util
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.05.06 우경민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.ctmcommon.containermovementvalidation.event;

import com.clt.apps.opus.ees.ctm.ctmcommon.containermovementvalidation.vo.BookingInfoVO;
import com.clt.apps.opus.ees.ctm.ctmcommon.containermovementvalidation.vo.CtmCommonVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * CTMCommon 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  CTMCommonHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KyungMin Woo
 * @see CTM_COM_HTMLAction 참조
 * @since J2EE 1.4
 */
public class CtmComEvent extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CtmCommonVO ctmCommonVO = null;

	/** Table Value Object Multi Data 처리 */
	private CtmCommonVO[] ctmCommonVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BookingInfoVO bookingInfoVO = null;

	/** Table Value Object Multi Data 처리 */
	private BookingInfoVO[] bookingInfoVOs = null;

	public CtmComEvent(){}

	public void setCTMCommonVO(CtmCommonVO ctmCommonVO){
		this. ctmCommonVO = ctmCommonVO;
	}

	public void setCTMCommonVOS(CtmCommonVO[] ctmCommonVOs){
		if (ctmCommonVOs != null) {
			CtmCommonVO[] tmpVOs = new CtmCommonVO[ctmCommonVOs.length];
			System.arraycopy(ctmCommonVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.ctmCommonVOs = tmpVOs;
		}
	}

	public void setBookingInfoVO(BookingInfoVO bookingInfoVO){
		this. bookingInfoVO = bookingInfoVO;
	}

	public void setBookingInfoVOS(BookingInfoVO[] bookingInfoVOs){
		if (bookingInfoVOs != null) {
			BookingInfoVO[] tmpVOs = new BookingInfoVO[bookingInfoVOs.length];
			System.arraycopy(bookingInfoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bookingInfoVOs = tmpVOs;
		}
	}

	public CtmCommonVO getCtmCommonVO(){
		return ctmCommonVO;
	}

	public CtmCommonVO[] getCtmCommonVOS(){
		CtmCommonVO[] tmpVOs = null;
		if (this.ctmCommonVOs != null) {
			tmpVOs = new CtmCommonVO[ctmCommonVOs.length];
			System.arraycopy(ctmCommonVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public BookingInfoVO getBookingInfoVO(){
		return bookingInfoVO;
	}

	public BookingInfoVO[] getBookingInfoVOS(){
		BookingInfoVO[] tmpVOs = null;
		if (this.bookingInfoVOs != null) {
			tmpVOs = new BookingInfoVO[bookingInfoVOs.length];
			System.arraycopy(bookingInfoVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}
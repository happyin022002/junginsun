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
package com.hanjin.apps.alps.ees.ctm.ctmcommon.containermovementvalidation.event;

import java.util.List;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.ctm.ctmcommon.containermovementvalidation.vo.CtmCommonVO;
import com.hanjin.apps.alps.ees.ctm.ctmcommon.containermovementvalidation.vo.BookingInfoVO;


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
	public CtmCommonVO[] ctmCommonVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BookingInfoVO bookingInfoVO = null;

	/** Table Value Object Multi Data 처리 */
	public BookingInfoVO[] bookingInfoVOs = null;

	// 첨부 file key value.
	private List<String> filekeys = null;

	public CtmComEvent(){}

	public void setCTMCommonVO(CtmCommonVO ctmCommonVO){
		this. ctmCommonVO = ctmCommonVO;
	}

	public void setCTMCommonVOS(CtmCommonVO[] ctmCommonVOs){
		this. ctmCommonVOs = ctmCommonVOs;
	}

	public void setBookingInfoVO(BookingInfoVO bookingInfoVO){
		this. bookingInfoVO = bookingInfoVO;
	}

	public void setBookingInfoVOS(BookingInfoVO[] bookingInfoVOs){
		this. bookingInfoVOs = bookingInfoVOs;
	}

	public CtmCommonVO getCtmCommonVO(){
		return ctmCommonVO;
	}

	public CtmCommonVO[] getCtmCommonVOS(){
		return ctmCommonVOs;
	}

	public BookingInfoVO getBookingInfoVO(){
		return bookingInfoVO;
	}

	public BookingInfoVO[] getBookingInfoVOS(){
		return bookingInfoVOs;
	}

	public List<String> getFilekeys() {
		return filekeys;
	}

	public void setFilekeys(List<String> filekeys) {
		this.filekeys = filekeys;
	}
}

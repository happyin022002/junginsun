/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCtm04Event.java
*@FileTitle : MVMT
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.12
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.event;

import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.BookingQTYVO;
import com.clt.framework.support.layer.event.EventSupport;

 
/**
 * EES_CTM_04 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CTM_04HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kyung Min Woo
 * @see EES_CTM_0458HTMLAction 참조
 * @since J2EE 1.6
 */
public class EesCtm0458Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BookingQTYVO bookingQTY = null;
	
	/** Table Value Object Multi Data 처리 */
	private BookingQTYVO[] bookingQTYs = null;

	public EesCtm0458Event(){}
	
	public void setBookingQTY(BookingQTYVO bookingQTY){
		this. bookingQTY = bookingQTY;
	}

	public void setBookingQTYS(BookingQTYVO[] bookingQTYs){
		if (bookingQTYs != null) {
			BookingQTYVO[] tmpVOs = new BookingQTYVO[bookingQTYs.length];
			System.arraycopy(bookingQTYs, 0, tmpVOs, 0, tmpVOs.length);
			this.bookingQTYs = tmpVOs;
		}
	}

	public BookingQTYVO getBookingQTY(){
		return bookingQTY;
	}

	public BookingQTYVO[] getBookingQTYS(){
		BookingQTYVO[] tmpVOs = null;
		if (this.bookingQTYs != null) {
			tmpVOs = new BookingQTYVO[bookingQTYs.length];
			System.arraycopy(bookingQTYs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}
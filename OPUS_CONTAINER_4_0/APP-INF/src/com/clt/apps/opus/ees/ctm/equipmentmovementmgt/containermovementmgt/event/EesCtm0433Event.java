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

import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.BkgCNTRListVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CTM_0433 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EES_CTM_0433HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kyung Min Woo
 * @see EES_CTM_0433HTMLAction 참조
 * @since J2EE 1.6
 */
public class EesCtm0433Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgCNTRListVO bookingQTY = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgCNTRListVO[] bookingQTYs = null;

	public EesCtm0433Event(){}
	
	public void setBookingQTY(BkgCNTRListVO bookingQTY){
		this. bookingQTY = bookingQTY;
	}

	public void setBookingQTYS(BkgCNTRListVO[] bookingQTYs){
		if (bookingQTYs != null) {
			BkgCNTRListVO[] tmpVOs = new BkgCNTRListVO[bookingQTYs.length];
			System.arraycopy(bookingQTYs, 0, tmpVOs, 0, tmpVOs.length);
			this.bookingQTYs = tmpVOs;
		}
	}

	public BkgCNTRListVO getBookingQTY(){
		return bookingQTY;
	}

	public BkgCNTRListVO[] getBookingQTYS(){
		BkgCNTRListVO[] tmpVOs = null;
		if (this.bookingQTYs != null) {
			tmpVOs = new BkgCNTRListVO[bookingQTYs.length];
			System.arraycopy(bookingQTYs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}
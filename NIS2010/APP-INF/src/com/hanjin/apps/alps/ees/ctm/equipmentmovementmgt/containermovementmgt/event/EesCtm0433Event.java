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
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.event;

import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.BkgCNTRListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


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
		this. bookingQTYs = bookingQTYs;
	}

	public BkgCNTRListVO getBookingQTY(){
		return bookingQTY;
	}

	public BkgCNTRListVO[] getBookingQTYS(){
		return bookingQTYs;
	}

}
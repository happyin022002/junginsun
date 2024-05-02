/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EsmBkgChnEdiReceiveEvent.java
*@FileTitle : B/L Detail 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.23
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.08.23 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event;

import java.util.List;

import com.clt.apps.opus.esm.bkg.servicesio.BookingReportProxy;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgObChnRcvVO;


/**
 * 중국 EDI 수신
 *
 * @author Kim Minjeong
 * @see BookingReportProxy 참조
 * @since J2EE 1.6
 */

public class EsmBkgChnEdiReceiveEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmBkgChnEdiReceiveEvent(){}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private List<BkgObChnRcvVO> bkgObChnRcvVOs = null;
	private String rcvMsg = null;
	
	public void setBkgObChnRcvVOs(List<BkgObChnRcvVO> bkgObChnRcvVOs){
		this. bkgObChnRcvVOs = bkgObChnRcvVOs;
	}

	public List<BkgObChnRcvVO> getBkgObChnRcvVOs(){
		return bkgObChnRcvVOs;
	}
	
	public void setRcvMsg(String rcvMsg){
		this. rcvMsg = rcvMsg;
	}

	public String getRcvMsg(){
		return rcvMsg;
	}
}
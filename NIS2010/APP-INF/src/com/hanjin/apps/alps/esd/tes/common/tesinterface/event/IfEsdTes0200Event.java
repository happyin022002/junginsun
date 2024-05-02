/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : IF_ESD_TES_1001Event.java
*@FileTitle : Service Scope
*Open Issues :
*Change history :
*@LastModifyDate : 2008-04-13
*@LastModifier : Y
*@LastVersion : 1.0
* 2008-04-13 Y
* 1.0 최초 생성
* 2011-10-13: [CHM-201113119] [TES] HIT의 TES invoice eBilling 2단계(invoice PDF 수신) 개발 진행 요청
=========================================================*/

package com.hanjin.apps.alps.esd.tes.common.tesinterface.event;

import com.hanjin.apps.alps.esd.tes.common.tesinterface.basic.TESInterfaceManageBCImpl;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TesEdiSoHdrVO;
import com.hanjin.syscommon.common.table.TesEdiSoFileVO;
import com.jf.transfer.TransferEAI;

/**
 * IF_ESD_TES_200 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Y
 * @see TESInterfaceManageBCImpl 참조
 * @since J2EE 1.4
 */
public class IfEsdTes0200Event extends EventSupport {
	public IfEsdTes0200Event(){}

	public TesEdiSoHdrVO tesEdiSoHdrVO = null;
	public TesEdiSoFileVO tesEdiSoFileVO = null;
	
	public String str = null;
	public String flnm = null;
	public byte[] flbuf = null;
	public TransferEAI eai = null;
	
	public TesEdiSoHdrVO getTesEdiSoHdrVO() {
		return tesEdiSoHdrVO;
	}

	public void setTesEdiSoHdrVO(TesEdiSoHdrVO tesEdiSoHdrVO) {
		this.tesEdiSoHdrVO = tesEdiSoHdrVO;
	}

	public TesEdiSoFileVO getTesEdiSoFileVO() {
		return tesEdiSoFileVO;
	}

	public void setTesEdiSoFileVO(TesEdiSoFileVO tesEdiSoFileVO) {
		this.tesEdiSoFileVO = tesEdiSoFileVO;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public String getFileNm(){
		return flnm;
	}

	public void setFileNm(String flnm){
		this.flnm = flnm;
	}
	
	public byte[] getFileBuf(){
		return flbuf;
	}

	public void setFileBuf(byte[] flbuf){
		this.flbuf = flbuf;
	}

	public TransferEAI getEai(){
		return eai;
	}
	
	public void setEai(TransferEAI eai){
		this.eai = eai;
	}
}
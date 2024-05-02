/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : TESeBillingEvent.java
*@FileTitle : TES eBilling EDI 처리용 Event
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2012-01-04
=========================================================*/

package com.hanjin.apps.alps.esd.tes.edi.ebilling.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TesEdiSoHdrVO;
import com.hanjin.syscommon.common.table.TesEdiSoFileVO;
import com.hanjin.syscommon.common.table.TesTmlSoHdrVO;

/**
 * TESeBilling 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Y
 * @see TESeBillingManageBCImpl 참조
 * @since J2EE 1.4
 */
public class TESeBillingEvent extends EventSupport {
	public TESeBillingEvent(){}

	private TesEdiSoHdrVO tesEdiSoHdrVO = null;
	private TesEdiSoFileVO tesEdiSoFileVO = null;
	private TesTmlSoHdrVO tesTmlSoHdrVO = null;
	private String str = null;
	private String file_nm = null;
	
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
	
	public TesTmlSoHdrVO getTesTmlSoHdrVO() {
		return tesTmlSoHdrVO;
	}

	public void setTesTmlSoHdrVO(TesTmlSoHdrVO tesTmlSoHdrVO) {
		this.tesTmlSoHdrVO = tesTmlSoHdrVO;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
	
	public String getFileNm() {
		return file_nm;
	}

	public void setFileNm(String file_nm) {
		this.file_nm = file_nm;
	}

}
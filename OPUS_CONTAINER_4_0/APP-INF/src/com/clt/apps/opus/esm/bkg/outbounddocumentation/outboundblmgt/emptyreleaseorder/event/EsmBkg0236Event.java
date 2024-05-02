/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0236Event.java
*@FileTitle : OPUS Container Office Setup
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.event;

import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.BkgLodFctrDlLogHdrVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0236 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0236HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see ESM_BKG_0236HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0236Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgLodFctrDlLogHdrVO logHdrVO= null;
	private String ofcCd = null;
	private String ldfDt = null;
	private String fromDt = null;
	private String toDt = null;
	private String fileNm = null;

	public EsmBkg0236Event(){}

	public BkgLodFctrDlLogHdrVO getLogHdrVO() {
		return logHdrVO;
	}

	public void setLogHdrVO(BkgLodFctrDlLogHdrVO logHdrVO) {
		this.logHdrVO = logHdrVO;
	}

	public String getOfcCd() {
		return ofcCd;
	}

	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}


	public String getLdfDt() {
		return ldfDt;
	}

	public void setLdfDt(String ldfDt) {
		this.ldfDt = ldfDt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getFromDt() {
		return fromDt;
	}

	public void setFromDt(String fromDt) {
		this.fromDt = fromDt;
	}

	public String getToDt() {
		return toDt;
	}

	public void setToDt(String toDt) {
		this.toDt = toDt;
	}

	public String getFileNm() {
		return fileNm;
	}

	public void setFileNm(String fileNm) {
		this.fileNm = fileNm;
	}
	
	
}
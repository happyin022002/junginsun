/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0418Event.java
*@FileTitle : Cancel Issue Release
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.08
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2009.09.08 박준용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event;

import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0649 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0649HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Jin Seo
 * @see ESM_BKG_0649HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0418Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	public EsmBkg0418Event(){}
	
	private String[] bkgBlNos = null;
	
	private String mode = null;
	private String vvd = null;
	private String port = null;
	private String vslCd = null;
	private String voyNo = null;
	private String dirCd = null;
	private String clptIndSeq = null;
	
	public String[] getBkgBlNos() {
		return bkgBlNos;
	}
	public void setBkgBlNos(String[] bkgBlNos) {
		this.bkgBlNos = bkgBlNos;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getVvd() {
		return vvd;
	}
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getVslCd() {
		return vslCd;
	}
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	public String getVoyNo() {
		return voyNo;
	}
	public void setVoyNo(String voyNo) {
		this.voyNo = voyNo;
	}
	public String getDirCd() {
		return dirCd;
	}
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	public String getClptIndSeq() {
		return clptIndSeq;
	}
	public void setClptIndSeq(String clptIndSeq) {
		this.clptIndSeq = clptIndSeq;
	}


}
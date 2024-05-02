/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmFms0092Event.java
 *@FileTitle : File Upload
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.11.08
 *@LastModifier : 이준범
 *@LastVersion : 1.0
 * 2009.10.05 이준범
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.fmscommon.fmsfileupload.event;


import com.hanjin.apps.alps.esm.fms.fmscommon.fmsfileupload.vo.FileUploadListVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * UI_JOO_0098 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_JOO_0098HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br> 
 *
 * @author Min Jung Ho
 * @see FNS_JOO_0098HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmFms0092Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	/* 검색 조건 */
	private String vslCd;
	
	private String vnorSeq;
	
	private String vnorItmSeq;	
	
	private String csrNo;
	
	private FileUploadListVO fileUploadListVO = null;
	
	private FileUploadListVO[] fileUploadListVOs = null;

	public String getVslCd() {
		return vslCd;
	}

	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	public String getVnorSeq() {
		return vnorSeq;
	}

	public void setVnorSeq(String vnorSeq) {
		this.vnorSeq = vnorSeq;
	}

	public String getVnorItmSeq() {
		return vnorItmSeq;
	}

	public void setVnorItmSeq(String vnorItmSeq) {
		this.vnorItmSeq = vnorItmSeq;
	}
		
	public String getCsrNo() {
		return csrNo;
	}

	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}

	public FileUploadListVO getFileUploadListVO() {
		return fileUploadListVO;
	}

	public void setFileUploadListVO(FileUploadListVO fileUploadListVO) {
		this. fileUploadListVO = fileUploadListVO;
	}
	
	public FileUploadListVO[] getFileUploadListVOs() {
		FileUploadListVO[] rtnVOs = null;
		if (this.fileUploadListVOs != null) {
			rtnVOs = new FileUploadListVO[fileUploadListVOs.length];
			System.arraycopy(fileUploadListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;				
	}

	public void setFileUploadListVOs(FileUploadListVO[] fileUploadListVOs) {
		if (fileUploadListVOs != null) {
			FileUploadListVO[] tmpVOs = new FileUploadListVO[fileUploadListVOs.length];
			System.arraycopy(fileUploadListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.fileUploadListVOs = tmpVOs;
		}		
	}
}
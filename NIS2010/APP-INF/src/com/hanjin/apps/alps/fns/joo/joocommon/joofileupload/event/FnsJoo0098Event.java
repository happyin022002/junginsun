/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : FnsJoo0082Event.java
 *@FileTitle : File Upload
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.11.08
 *@LastModifier : 이준범
 *@LastVersion : 1.0
 * 2009.10.05 이준범
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.joocommon.joofileupload.event;


import com.hanjin.apps.alps.fns.joo.joocommon.joofileupload.vo.FileUploadListVO;
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

public class FnsJoo0098Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	/* 검색 조건 */
	private String csrNo;
	
	private String fileSeq;
	
	private FileUploadListVO fileUploadListVO = null;
	
	private FileUploadListVO[] fileUploadListVOs = null;

	public String getCsrNo() {
		return csrNo;
	}

	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}
	
	public String getFileSeq() {
		return fileSeq;
	}

	public void setFileSeq(String fileSeq) {
		this.fileSeq = fileSeq;
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
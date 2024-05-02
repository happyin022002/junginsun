/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : FnsJoo0097Event.java
 *@FileTitle : File Upload Infomation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.05.30
 *@LastModifier : 김현주
 *@LastVersion : 1.0
 * 2015.10.05 김현주
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.joocommon.joofileupload.event;
import com.hanjin.apps.alps.fns.joo.joocommon.joofileupload.vo.FileUploadInfoVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * UI_JOO_0097 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_JOO_0097HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Hyun Joo
 * @see FNS_JOO_0097HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsJoo0097Event extends EventSupport {

	private static final long serialVersionUID = 1L;
		
	private FileUploadInfoVO fileUploadInfoVO = null;
	
	private FileUploadInfoVO[] fileUploadInfoVOs = null;

	public FileUploadInfoVO getFileUploadInfoVO() {
		return fileUploadInfoVO;
	}

	public void setFileUploadInfoVO(FileUploadInfoVO fileUploadInfoVO) {
		this. fileUploadInfoVO = fileUploadInfoVO;
	}
	
	public FileUploadInfoVO[] getFileUploadInfoVOs() {
		FileUploadInfoVO[] rtnVOs = null;
		if (this.fileUploadInfoVOs != null) {
			rtnVOs = new FileUploadInfoVO[fileUploadInfoVOs.length];
			System.arraycopy(fileUploadInfoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;				
	}

	public void setFileUploadInfoVOs(FileUploadInfoVO[] fileUploadInfoVOs) {
		if (fileUploadInfoVOs != null) {
			FileUploadInfoVO[] tmpVOs = new FileUploadInfoVO[fileUploadInfoVOs.length];
			System.arraycopy(fileUploadInfoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.fileUploadInfoVOs = tmpVOs;
		}		
	}
}
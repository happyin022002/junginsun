/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsCni0025Event.java
 *@FileTitle : Main Code Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.05
 *@LastModifier : 진윤오
 *@LastVersion : 1.0
 * 2009.10.05 진윤오 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.codemgt.filemgt.event;


import com.clt.apps.opus.cps.cni.codemgt.codemgt.event.CPS_CNI_0025HTMLAction;
import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.CniPartyVO;
import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.PartyCntVO;
import com.clt.apps.opus.cps.cni.codemgt.filemgt.vo.CniAtchFileVO;
import com.clt.apps.opus.cps.cni.codemgt.filemgt.vo.FileUploadCondVO;
import com.clt.apps.opus.cps.cni.codemgt.filemgt.vo.FileUploadVO;
import com.clt.framework.component.attachment.file.upload.FileUpload;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * [CPS_CNI_0025] Main Code Creation
 * @author choijungmi
 * @see CPS_CNI_0025HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsCni0011Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	/* 검색 조건 */
	private FileUploadCondVO fileUploadCondVO;

    public FileUploadCondVO getFileUploadCondVO() {
		return fileUploadCondVO;
	}

	public void setFileUploadCondVO(FileUploadCondVO fileUploadCondVO) {
		this.fileUploadCondVO = fileUploadCondVO;
	}

	/* File Upload */
    private CniAtchFileVO[] cniAtchFileVOs;
    
    
	public CniAtchFileVO[] getCniAtchFileVOs() {
		CniAtchFileVO[] rtnVOs = null;
		if (this.cniAtchFileVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(cniAtchFileVOs, cniAtchFileVOs.length);
		}
		return rtnVOs;
	}

	public void setCniAtchFileVOs(CniAtchFileVO[] cniAtchFileVOs){
		if(cniAtchFileVOs != null){
			CniAtchFileVO[] tmpVOs = java.util.Arrays.copyOf(cniAtchFileVOs, cniAtchFileVOs.length);
			this.cniAtchFileVOs = tmpVOs;
		}
	}

}
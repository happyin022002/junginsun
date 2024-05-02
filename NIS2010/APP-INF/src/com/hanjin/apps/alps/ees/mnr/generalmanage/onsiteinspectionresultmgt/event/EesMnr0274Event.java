/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UiMnr0273Event.java
*@FileTitle : FQA Result Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.21
*@LastModifier : 이율규
*@LastVersion : 1.0
* 2015.07.21 이율규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.onsiteinspectionresultmgt.event;

import java.util.List;

import com.hanjin.apps.alps.ees.mnr.generalmanage.onsiteinspectionresultmgt.vo.MnrOnSiteVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.CustomMnrFileAtchVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * UI_MNR_0273 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_MNR_0273HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author LEE YULKYU
 * @see UI_MNR_0270HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesMnr0274Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	private List<String> keys;

	/**
	 * It sets filekeys
	 * 
	 * @author LEE YULKYU
	 * @param keys
	 */
	public void setFileKey(List<String> keys) {
		this.keys = keys;
	}

	/**
	 * It gets filekeys.
	 * 
	 * @author LEE YULKYU
	 * @return
	 */
	public List<String> getFileKey() {
		return this.keys;
	}

	private String fileCnt = "";

	private String fileSeq = "";

	private String fileStat = "";

	/** Table Value Object 조회 조건 및 단건 처리 */
	private MnrOnSiteVO mnrOnSiteVO = null;

	/** Table Value Object Multi Data 처리 */
	public MnrOnSiteVO[] mnrOnSiteVOs = null;
	
	public CustomMnrFileAtchVO[] customMnrFileAtchVOs = null;

	public CustomMnrFileAtchVO[] getCustomMnrFileAtchVOs() {
		return customMnrFileAtchVOs;
	}

	public void setCustomMnrFileAtchVOs(CustomMnrFileAtchVO[] customMnrFileAtchVOs) {
		this.customMnrFileAtchVOs = customMnrFileAtchVOs;
	}

	public EesMnr0274Event() {
	}

	public MnrOnSiteVO getMnrOnSiteVO() {
		return mnrOnSiteVO;
	}

	public void setMnrOnSiteVO(MnrOnSiteVO mnrOnSiteVO) {
		this.mnrOnSiteVO = mnrOnSiteVO;
	}

	public MnrOnSiteVO[] getMnrOnSiteVOs() {
		return mnrOnSiteVOs;
	}

	public void setMnrOnSiteVOs(MnrOnSiteVO[] mnrOnSiteVOs) {
		this.mnrOnSiteVOs = mnrOnSiteVOs;
	}

	public String getFileCnt() {
		return fileCnt;
	}

	public void setFileCnt(String fileCnt) {
		this.fileCnt = fileCnt;
	}

	public String getFileSeq() {
		return fileSeq;
	}

	public void setFileSeq(String fileSeq) {
		this.fileSeq = fileSeq;
	}

	public String getFileStat() {
		return fileStat;
	}

	public void setFileStat(String fileStat) {
		this.fileStat = fileStat;
	}
}
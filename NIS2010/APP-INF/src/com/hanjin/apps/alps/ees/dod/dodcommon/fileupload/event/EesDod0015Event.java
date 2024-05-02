/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EesDod0015Event.java
*@FileTitle : DOD File Upload
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.04
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2016.01.04 손진환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.dodcommon.fileupload.event;

import java.util.Arrays;

import com.hanjin.apps.alps.ees.dod.dodcommon.fileupload.vo.FileUploadListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_DOD_0015 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DOD_0015HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Son, Jin-Hwan
 * @see EES_DOD_0015HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDod0015Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	/* 검색 조건 */
	private String bkgNo;
	
	private String cntrNo;
	
	private String drpOffChgSeq;
	
	private String drpOffChgTrfSeq;
	
	private String caller;
	
	private String atchFileLnkId;
	
	private String tabGubun;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	FileUploadListVO fileUploadListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	FileUploadListVO[] fileUploadListVOs = null;

	public EesDod0015Event(){}

	public String getBkgNo() {
		return bkgNo;
	}

	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	public String getCntrNo() {
		return cntrNo;
	}

	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}

	public String getDrpOffChgSeq() {
		return drpOffChgSeq;
	}

	public void setDrpOffChgSeq(String drpOffChgSeq) {
		this.drpOffChgSeq = drpOffChgSeq;
	}

	public String getDrpOffChgTrfSeq() {
		return drpOffChgTrfSeq;
	}

	public void setDrpOffChgTrfSeq(String drpOffChgTrfSeq) {
		this.drpOffChgTrfSeq = drpOffChgTrfSeq;
	}

	public String getCaller() {
		return caller;
	}

	public void setCaller(String caller) {
		this.caller = caller;
	}

	public String getAtchFileLnkId() {
		return atchFileLnkId;
	}

	public void setAtchFileLnkId(String atchFileLnkId) {
		this.atchFileLnkId = atchFileLnkId;
	}

	public String getTabGubun() {
		return tabGubun;
	}

	public void setTabGubun(String tabGubun) {
		this.tabGubun = tabGubun;
	}

	public void setFileUploadListVO(FileUploadListVO fileUploadListVO){
		this. fileUploadListVO = fileUploadListVO;
	}

	public void setFileUploadListVOs(FileUploadListVO[] fileUploadListVOs){
		if (fileUploadListVOs != null) {
			FileUploadListVO[] tmpVOs = Arrays.copyOf(fileUploadListVOs, fileUploadListVOs .length);
			this. fileUploadListVOs = tmpVOs;
		}
	}

	public FileUploadListVO getFileUploadListVO(){
		return fileUploadListVO;
	}

	public FileUploadListVO[] getFileUploadListVOs(){
		FileUploadListVO[] tmpVOs = null;
		if (this. fileUploadListVOs != null) {
			tmpVOs = Arrays.copyOf(fileUploadListVOs, fileUploadListVOs .length);
		}
		return tmpVOs;
	}

}
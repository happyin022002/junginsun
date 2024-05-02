/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LseInterfasceEvent.java
*@FileTitle : 공통펑션으로 코드값과 디스크립션을 받아온다.
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 노정용
*@LastVersion : 1.0   
* 2009.09.21 노정용 
* 1.0 Creation 
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.event;

import java.util.List;

import com.hanjin.framework.support.layer.event.EventSupport;
    
/**
 * MNR_COM 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  MNR_COM_HTMLAction 에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author lee ju hyun
 * @see MNR_INTERFACE_HTMLAction 참조
 * @since J2EE 1.4
 * 
 */ 
     
public class CgmFileUploadEvent extends EventSupport { 
	private static final long serialVersionUID = 1L;
	
	public CgmFileUploadEvent(){} 
	
	private List<String> filekeys;
		
	private String fileCnt = "";
	
	private String fileSeq = "";
	
	private String fileStat = "";

	/**
	 * @return the filekeys
	 */
	public List<String> getFilekeys() {
		return filekeys;
	}

	/**
	 * @param filekeys the filekeys to set
	 */
	public void setFilekeys(List<String> filekeys) {
		this.filekeys = filekeys;
	}

	/**
	 * @return the fileCnt
	 */
	public String getFileCnt() {
		return fileCnt;
	}

	/**
	 * @param fileCnt the fileCnt to set
	 */
	public void setFileCnt(String fileCnt) {
		this.fileCnt = fileCnt;
	}

	/**
	 * @return the fileSeq
	 */
	public String getFileSeq() {
		return fileSeq;
	}

	/**
	 * @param fileSeq the fileSeq to set
	 */
	public void setFileSeq(String fileSeq) {
		this.fileSeq = fileSeq;
	}

	/**
	 * @return the fileStat
	 */
	public String getFileStat() {
		return fileStat;
	}

	/**
	 * @param fileStat the fileStat to set
	 */
	public void setFileStat(String fileStat) {
		this.fileStat = fileStat;
	}

	/**
	 * @return the serialVersionUID
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
}
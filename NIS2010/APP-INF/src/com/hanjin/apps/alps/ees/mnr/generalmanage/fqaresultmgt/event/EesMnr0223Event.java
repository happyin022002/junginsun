/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0223Event.java
*@FileTitle : FQA Result Detail Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.10.09 함형석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.fqaresultmgt.event;

import com.hanjin.apps.alps.ees.mnr.generalmanage.fqaresultmgt.vo.FQAResultMgtINVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.fqaresultmgt.vo.MnrFieldQualityAuditResultVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.CustomMnrFileAtchVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import java.util.List;

/**
 * EES_MNR_0223 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MNR_0223HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HyungSeok Ham
 * @see EES_MNR_0223HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesMnr0223Event extends EventSupport {

	private static final long serialVersionUID = 1L;	
	private List<String> keys;

	/**
	 * It sets filekeys
	 * @author SEONG DUK KYUNG
	 * @param keys
	 */
	public void setFileKey(List<String> keys) {
		this.keys = keys;
	}

	/**
	 * It gets filekeys.
	 * @author SEONG DUK KYUNG
	 * @return
	 */
	public List<String> getFileKey(){
		return this.keys;
	}
	private String fileCnt = "";
	
	private String fileSeq = "";
	
	private String fileStat = "";
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private FQAResultMgtINVO fQAResultMgtINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MnrFieldQualityAuditResultVO[] mnrFieldQualityAuditResultVOs = null;
	
	private CustomMnrFileAtchVO[] customMnrFileAtchVOs = null;
	
	public EesMnr0223Event(){}

	public FQAResultMgtINVO getFQAResultMgtINVO() {
		return fQAResultMgtINVO;      
	} 

	public void setFQAResultMgtINVO(FQAResultMgtINVO fQAResultMgtINVO) {
		this.fQAResultMgtINVO = fQAResultMgtINVO;
	}  

	public MnrFieldQualityAuditResultVO[] getMnrFieldQualityAuditResultVOS(){
		return mnrFieldQualityAuditResultVOs;
	}
	public void setMnrFieldQualityAuditResultVOs(MnrFieldQualityAuditResultVO[] mnrFieldQualityAuditResultVOs) {
		this.mnrFieldQualityAuditResultVOs = mnrFieldQualityAuditResultVOs;
	}
	public CustomMnrFileAtchVO[] getCustomMnrFileAtchVOs(){
		return customMnrFileAtchVOs;
	}
	public void setCustomMnrFileAtchVOs(CustomMnrFileAtchVO[] customMnrFileAtchVOs) {
		this.customMnrFileAtchVOs = customMnrFileAtchVOs;
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
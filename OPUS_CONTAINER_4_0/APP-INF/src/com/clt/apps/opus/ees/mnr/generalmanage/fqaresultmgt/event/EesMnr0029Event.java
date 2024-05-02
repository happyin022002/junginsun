/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UiMnr0029Event.java
*@FileTitle : FQA Result Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 성덕경
*@LastVersion : 1.0
* 2009.05.20 성덕경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.fqaresultmgt.event;

import com.clt.apps.opus.ees.mnr.generalmanage.fqaresultmgt.vo.FQAResultMgtINVO;
import com.clt.apps.opus.ees.mnr.generalmanage.fqaresultmgt.vo.MnrFieldQualityAuditResultVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.CustomMnrFileAtchVO;
import com.clt.framework.support.layer.event.EventSupport;
import java.util.List;

/**
 * UI_MNR_0029 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_MNR_0029HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SEONG DUK KYUNG
 * @see UI_MNR_0029HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesMnr0029Event extends EventSupport {

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
	
	public EesMnr0029Event(){}

	public FQAResultMgtINVO getFQAResultMgtINVO() {
		return fQAResultMgtINVO;      
	} 

	public void setFQAResultMgtINVO(FQAResultMgtINVO fQAResultMgtINVO) {
		this.fQAResultMgtINVO = fQAResultMgtINVO;
	}  

	public MnrFieldQualityAuditResultVO[] getMnrFieldQualityAuditResultVOS(){
		MnrFieldQualityAuditResultVO[] rtnVOs = null;
		if (this.mnrFieldQualityAuditResultVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(mnrFieldQualityAuditResultVOs, mnrFieldQualityAuditResultVOs.length);
		}
		return rtnVOs;
	}
	public void setMnrFieldQualityAuditResultVOs(MnrFieldQualityAuditResultVO[] mnrFieldQualityAuditResultVOs){
		if(mnrFieldQualityAuditResultVOs != null){
			MnrFieldQualityAuditResultVO[] tmpVOs = java.util.Arrays.copyOf(mnrFieldQualityAuditResultVOs, mnrFieldQualityAuditResultVOs.length);
			this.mnrFieldQualityAuditResultVOs = tmpVOs;
		}
	}
	public CustomMnrFileAtchVO[] getCustomMnrFileAtchVOs(){
		CustomMnrFileAtchVO[] rtnVOs = null;
		if (this.customMnrFileAtchVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(customMnrFileAtchVOs, customMnrFileAtchVOs.length);
		}
		return rtnVOs;
	}
	public void setCustomMnrFileAtchVOs(CustomMnrFileAtchVO[] customMnrFileAtchVOs){
		if(customMnrFileAtchVOs != null){
			CustomMnrFileAtchVO[] tmpVOs = java.util.Arrays.copyOf(customMnrFileAtchVOs, customMnrFileAtchVOs.length);
			this.customMnrFileAtchVOs = tmpVOs;
		}
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
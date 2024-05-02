/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1063Event.java
*@FileTitle : Pick up down-load
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.21
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event;

import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNoMnlUpldSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNoMnlUpldVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1063 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1063HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see ESM_BKG_1063HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1063Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PkupNoMnlUpldVO pkupNoMnlUpldVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PkupNoMnlUpldVO[] pkupNoMnlUpldVOs = null;
	
	private PkupNoMnlUpldSearchVO pkupNoMnlUpldSearchVO = null;
	
	private String jobId = null;
	
	private String batchCd = null;

	public EsmBkg1063Event(){}

	/**
	 * @param pkupNoMnlUpldVO the pkupNoMnlUpldVO to set
	 */
	public void setPkupNoMnlUpldVO(PkupNoMnlUpldVO pkupNoMnlUpldVO) {
		this.pkupNoMnlUpldVO = pkupNoMnlUpldVO;
	}

	/**
	 * @return the pkupNoMnlUpldVO
	 */
	public PkupNoMnlUpldVO getPkupNoMnlUpldVO() {
		return pkupNoMnlUpldVO;
	}

	/**
	 * @param pkupNoMnlUpldVOs the pkupNoMnlUpldVOs to set
	 */
//	public void setPkupNoMnlUpldVOs(PkupNoMnlUpldVO[] pkupNoMnlUpldVOs) {
//		this.pkupNoMnlUpldVOs = pkupNoMnlUpldVOs;
//	}

	//2015.04.14 Secure Coding 적용[CWE-496]
	public void setPkupNoMnlUpldVOs(PkupNoMnlUpldVO[] pkupNoMnlUpldVOs) {
		if (pkupNoMnlUpldVOs != null) {
			PkupNoMnlUpldVO[] tmpVOs = new PkupNoMnlUpldVO[pkupNoMnlUpldVOs.length];
			System.arraycopy(pkupNoMnlUpldVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.pkupNoMnlUpldVOs = tmpVOs;
		}		
	} 
	
	/**
	 * @return the pkupNoMnlUpldVOs
	 */
//	public PkupNoMnlUpldVO[] getPkupNoMnlUpldVOs() {
//		return pkupNoMnlUpldVOs;
//	}
	
	//2015.04.14 Secure Coding 적용[CWE-496]
	public PkupNoMnlUpldVO[] getPkupNoMnlUpldVOs() {
		PkupNoMnlUpldVO[] tmpVOs = null;
		if (this.pkupNoMnlUpldVOs != null) {
			tmpVOs = new PkupNoMnlUpldVO[pkupNoMnlUpldVOs.length];
			System.arraycopy(pkupNoMnlUpldVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	} 		

	/**
	 * @param pkupNoMnlUpldSearchVO the pkupNoMnlUpldSearchVO to set
	 */
	public void setPkupNoMnlUpldSearchVO(PkupNoMnlUpldSearchVO pkupNoMnlUpldSearchVO) {
		this.pkupNoMnlUpldSearchVO = pkupNoMnlUpldSearchVO;
	}

	/**
	 * @return the pkupNoMnlUpldSearchVO
	 */
	public PkupNoMnlUpldSearchVO getPkupNoMnlUpldSearchVO() {
		return pkupNoMnlUpldSearchVO;
	}

	/**
	 * @param jobId the jobId to set
	 */
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	/**
	 * @return the jobId
	 */
	public String getJobId() {
		return jobId;
	}

	/**
	 * @param batchCd the batchCd to set
	 */
	public void setBatchCd(String batchCd) {
		this.batchCd = batchCd;
	}

	/**
	 * @return the batchCd
	 */
	public String getBatchCd() {
		return batchCd;
	}
	

}
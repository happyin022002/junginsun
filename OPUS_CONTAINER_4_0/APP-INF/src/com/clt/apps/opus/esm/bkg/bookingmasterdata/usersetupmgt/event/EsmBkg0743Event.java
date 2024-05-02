/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0743Event.java
*@FileTitle : B/L Print Option
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.25 김경섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlIssInfoVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgUsrDfltSetVO;


/**
 * ESM_BKG_0743 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0743HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김경섭
 * @see ESM_BKG_0743HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0743Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	


	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgUsrDfltSetVO infoVO = null;
	
	/* BKG_BL_ISS 관련 Object */
	private BlIssInfoVO infoVO2 = null;

	public BlIssInfoVO getInfoVO2() {
		return infoVO2;
	}


	public void setInfoVO2(BlIssInfoVO infoVO2) {
		this.infoVO2 = infoVO2;
	}


	/** Table Value Object Multi Data 처리 */
	private BkgUsrDfltSetVO[] infoVOs = null;

	private String bkgNo ="";
	
	private String blNo ="";
	
	private String corrNo ="";
	
	private String chargeTp ="";
	
	private String containerTp ="";
	
	private String hiddenData ="";
	
	private String mrdFile = "";
	
	private String mrdParam = "";
	
	private String[] mrdFiles = null;
	private String[] mrdParams = null;
	private String[] pBkgNo = null;
	private String[] pBlNo = null;
	private String key = "";
	private String caYn = "";
	private String fileKey = "";
	private String formType = "";

	public String getHiddenData() {
		return hiddenData;
	}


	public void setHiddenData(String hiddenData) {
		this.hiddenData = hiddenData;
	}


	public String getChargeTp() {
		return chargeTp;
	}


	public void setChargeTp(String chargeTp) {
		this.chargeTp = chargeTp;
	}


	public String getContainerTp() {
		return containerTp;
	}


	public void setContainerTp(String containerTp) {
		this.containerTp = containerTp;
	}


	public String getCorrNo() {
		return corrNo;
	}


	public void setCorrNo(String corrNo) {
		this.corrNo = corrNo;
	}


	public EsmBkg0743Event(){}


	public String getBkgNo() {
		return bkgNo;
	}


	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	public String getBlNo() {
		return blNo;
	}


	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	public String getMrdFile() {
		return mrdFile;
	}


	public void setMrdFile(String mrdFile) {
		this.mrdFile = mrdFile;
	}


	public String getMrdParam() {
		return mrdParam;
	}


	public void setMrdParam(String mrdParam) {
		this.mrdParam = mrdParam;
	}


	public BkgUsrDfltSetVO getInfoVO() {
		return infoVO;
	}


	public void setInfoVO(BkgUsrDfltSetVO infoVO) {
		this.infoVO = infoVO;
	}

	

//	public BkgUsrDfltSetVO[] getInfoVOs() {
//		return infoVOs;
//	}

	//2015.04.10 Secure Coding 적용[CWE-496]
	public BkgUsrDfltSetVO[] getInfoVOs() {
		BkgUsrDfltSetVO[] tmpVOs = null;
		if (this.infoVOs != null) {
			tmpVOs = new BkgUsrDfltSetVO[infoVOs.length];
			System.arraycopy(infoVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}			

//	public void setInfoVOs(BkgUsrDfltSetVO[] infoVOs) {
//		this.infoVOs = infoVOs;
//	}
	
	
	//2015.04.10 Secure Coding 적용[CWE-496]
	public void setInfoVOs(BkgUsrDfltSetVO[] infoVOs) {
		if (infoVOs != null) {
			BkgUsrDfltSetVO[] tmpVOs = new BkgUsrDfltSetVO[infoVOs.length];
			System.arraycopy(infoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.infoVOs = tmpVOs;
		}		
	}	
	
	public String[] getMrdFiles() {
		String[] tmpVOs = null;
		if (this. mrdFiles != null) {
			tmpVOs = Arrays.copyOf(mrdFiles, mrdFiles .length);
		}
		return tmpVOs;
	}			

	public void setMrdFiles(String[] mrdFiles) {
		if (mrdFiles != null) {
			String[] tmpVOs = Arrays.copyOf(mrdFiles, mrdFiles .length);
			this. mrdFiles = tmpVOs;
		}		
	}	
	
	public String[] getMrdParams() {
		String[] tmpVOs = null;
		if (this. mrdParams != null) {
			tmpVOs = Arrays.copyOf(mrdParams, mrdParams .length);
		}
		return tmpVOs;
	}			

	public void setMrdParams(String[] mrdParams) {
		if (mrdParams != null) {
			String[] tmpVOs = Arrays.copyOf(mrdParams, mrdParams .length);
			this. mrdParams = tmpVOs;
		}		
	}
	
	public String[] getPBkgNo() {
		String[] tmpVOs = null;
		if (this.pBkgNo  != null) {
			tmpVOs = Arrays.copyOf(pBkgNo, pBkgNo .length);
		}
		return tmpVOs;
	}			

	public void setPBlNo(String[] pBlNo) {
		if (pBlNo != null) {
			String[] tmpVOs = Arrays.copyOf(pBlNo, pBlNo .length);
			this. pBlNo = tmpVOs;
		}		
	}
	
	public String[] getPBlNo() {
		String[] tmpVOs = null;
		if (this.pBlNo  != null) {
			tmpVOs = Arrays.copyOf(pBlNo, pBlNo .length);
		}
		return tmpVOs;
	}			

	public void setPBkgNo(String[] pBkgNo) {
		if (pBkgNo != null) {
			String[] tmpVOs = Arrays.copyOf(pBkgNo, pBkgNo .length);
			this. pBkgNo = tmpVOs;
		}		
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getCaYn() {
		return caYn;
	}

	public void setCaYn(String caYn) {
		this.caYn = caYn;
	}	
	
	public String getFileKey() {
		return fileKey;
	}

	public void setFileKey(String fileKey) {
		this.fileKey = fileKey;
	}

	public String getFormType() {
		return formType;
	}

	public void setFormType(String formType) {
		this.formType = formType;
	} 
	
	
}
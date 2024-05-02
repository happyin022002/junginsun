/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0204Event.java
*@FileTitle : Awakward Cargo Application
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.13
*@LastModifier : 이병규
*@LastVersion : 1.0
* 2009.06.10 이병규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.ScgImdgUnNoVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0204 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0204HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Byung Kyu 
 * @see ESM_BKG_0204HTMLAction에서 참조
 * @since J2EE 1.6
 */

public class EsmBkg0204Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgImdgUnNoVO scgImdgUnNoVO = null;
	private String bkgNo = null;
	private String unNo = null;
    private String imdgClass = null;
    private String prpShpNm = null;
    private String evntUsrId = null;
    private String evntDt = null;
   

	/** Table Value Object Multi Data 처리 */
	private ScgImdgUnNoVO[] scgImdgUnNoVOs = null;

	public EsmBkg0204Event(){}

	/**
	 * @return the scgImdgUnNoVO
	 */
	public ScgImdgUnNoVO getScgImdgUnNoVO() {
		return scgImdgUnNoVO;
	}

	/**
	 * @param scgImdgUnNoVO the scgImdgUnNoVO to set
	 */
	public void setScgImdgUnNoVO(ScgImdgUnNoVO scgImdgUnNoVO) {
		this.scgImdgUnNoVO = scgImdgUnNoVO;
	}

	/**
	 * @return the unNo
	 */
	public String getUnNo() {
		return unNo;
	}

	/**
	 * @param unNo the unNo to set
	 */
	public void setUnNo(String unNo) {
		this.unNo = unNo;
	}

	/**
	 * @return the imdgClass
	 */
	public String getImdgClass() {
		return imdgClass;
	}

	/**
	 * @param imdgClass the imdgClass to set
	 */
	public void setImdgClass(String imdgClass) {
		this.imdgClass = imdgClass;
	}

	/**
	 * @return the prpShpNm
	 */
	public String getPrpShpNm() {
		return prpShpNm;
	}

	/**
	 * @param prpShpNm the prpShpNm to set
	 */
	public void setPrpShpNm(String prpShpNm) {
		this.prpShpNm = prpShpNm;
	}

	/**
	 * @return the evntUsrId
	 */
	public String getEvntUsrId() {
		return evntUsrId;
	}

	/**
	 * @param evntUsrId the evntUsrId to set
	 */
	public void setEvntUsrId(String evntUsrId) {
		this.evntUsrId = evntUsrId;
	}

	/**
	 * @return the evntDt
	 */
	public String getEvntDt() {
		return evntDt;
	}

	/**
	 * @param evntDt the evntDt to set
	 */
	public void setEvntDt(String evntDt) {
		this.evntDt = evntDt;
	}

	/**
	 * @return the scgImdgUnNoVOs
	 */
	public ScgImdgUnNoVO[] getScgImdgUnNoVOs() {
		ScgImdgUnNoVO[] rtnVOs = null;
		if (this.scgImdgUnNoVOs != null) {
			rtnVOs = Arrays.copyOf(scgImdgUnNoVOs, scgImdgUnNoVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param scgImdgUnNoVOs the scgImdgUnNoVOs to set
	 */
	public void setScgImdgUnNoVOs(ScgImdgUnNoVO[] scgImdgUnNoVOs) {
		if(scgImdgUnNoVOs != null){
			ScgImdgUnNoVO[] tmpVOs = Arrays.copyOf(scgImdgUnNoVOs, scgImdgUnNoVOs.length);
			this.scgImdgUnNoVOs = tmpVOs;
		}
	}

	/**
	 * @return the bkgNo
	 */
	public String getBkgNo() {
		return bkgNo;
	}

	/**
	 * @param bkgNo the bkgNo to set
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	
	
}
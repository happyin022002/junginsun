/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0955HTMLAction.java
*@FileTitle : Booking History (B/L Data)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.14
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.08.14 이남경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0955 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0955HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Nam Kyung
 * @see ESM_BKG_0955HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0955Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgBlNoVO bkgBlNoVO = null; 
	private String    hisCateNm = null;
	private String    crntCtnt  = null; 
	private String    preCtnt   = null; 
	private String    creUsrId  = null; 
	private String    office    = null; 
	private String    creDt     = null; 
	
	
	public EsmBkg0955Event(){}

	/**
	 * @return the bkgBlNoVO
	 */
	public BkgBlNoVO getBkgBlNoVO() {
		return bkgBlNoVO;
	}

	/**
	 * @param bkgBlNoVO the bkgBlNoVO to set
	 */
	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO) {
		this.bkgBlNoVO = bkgBlNoVO;
	}

	/**
	 * @return the hisCateNm
	 */
	public String getHisCateNm() {
		return hisCateNm;
	}

	/**
	 * @param hisCateNm the hisCateNm to set
	 */
	public void setHisCateNm(String hisCateNm) {
		this.hisCateNm = hisCateNm;
	}

	/**
	 * @return the crntCtnt
	 */
	public String getCrntCtnt() {
		return crntCtnt;
	}

	/**
	 * @param crntCtnt the crntCtnt to set
	 */
	public void setCrntCtnt(String crntCtnt) {
		this.crntCtnt = crntCtnt;
	}

	/**
	 * @return the preCtnt
	 */
	public String getPreCtnt() {
		return preCtnt;
	}

	/**
	 * @param preCtnt the preCtnt to set
	 */
	public void setPreCtnt(String preCtnt) {
		this.preCtnt = preCtnt;
	}

	/**
	 * @return the creUsrId
	 */
	public String getCreUsrId() {
		return creUsrId;
	}

	/**
	 * @param creUsrId the creUsrId to set
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	/**
	 * @return the office
	 */
	public String getOffice() {
		return office;
	}

	/**
	 * @param office the office to set
	 */
	public void setOffice(String office) {
		this.office = office;
	}

	/**
	 * @return the creDt
	 */
	public String getCreDt() {
		return creDt;
	}

	/**
	 * @param creDt the creDt to set
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
}
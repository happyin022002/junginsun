/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0770Event.java
*@FileTitle : Awakward Cargo Application
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.13
*@LastModifier : 이병규
*@LastVersion : 1.0
* 2009.06.10 이병규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.event;


import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgDgCgoInfoVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0770 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0770HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Byung Kyu
 * @see ESM_BKG_0770HTMLAction에서 참조
 * @since J2EE 1.6
 */

public class EsmBkg0770Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	
	private BkgDgCgoInfoVO bkgDgCgoInfo = null;
	private String bkgNo = null;
    private String evntUsrId = null;
    private String evntDt = null;    

	/** Table Value Object Multi Data 처리 */
	private BkgDgCgoInfoVO[] bkgDgCgoInfoVOs = null;

	public EsmBkg0770Event(){}

	/**
	 * @return the bkgDgCgoInfo
	 */
	public BkgDgCgoInfoVO getBkgDgCgoInfo() {
		return bkgDgCgoInfo;
	}

	/**
	 * @param bkgDgCgoInfo the bkgDgCgoInfo to set
	 */
	public void setBkgDgCgoInfo(BkgDgCgoInfoVO bkgDgCgoInfo) {
		this.bkgDgCgoInfo = bkgDgCgoInfo;
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

	/**
	 * @return the bkgDgCgoInfoVOs
	 */
	public BkgDgCgoInfoVO[] getBkgDgCgoInfoVOs() {
		return bkgDgCgoInfoVOs;
	}

	/**
	 * @param bkgDgCgoInfoVOs the bkgDgCgoInfoVOs to set
	 */
	public void setBkgDgCgoInfoVOs(BkgDgCgoInfoVO[] bkgDgCgoInfoVOs) {
		this.bkgDgCgoInfoVOs = bkgDgCgoInfoVOs;
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
	 * @return the serialVersionUID
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

}
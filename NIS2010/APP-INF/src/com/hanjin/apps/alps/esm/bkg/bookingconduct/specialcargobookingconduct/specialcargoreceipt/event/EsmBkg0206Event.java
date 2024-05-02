/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0206Event.java
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

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.AwkCgoApplVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgAwkCgoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgAwkDimVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.CntrTypzQtyVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0206 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0206HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Byung Kyu
 * @see ESM_BKG_0206HTMLAction에서 참조
 * @since J2EE 1.6
 */

public class EsmBkg0206Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	
    private String imdgPckTpCd = null;
    private String imdgPckCd = null;
    private String bkgNo = null;
    private String blNo = null;

	public EsmBkg0206Event(){}

	/**
	 * @return the imdgPckTpCd
	 */
	public String getImdgPckTpCd() {
		return imdgPckTpCd;
	}

	/**
	 * @param imdgPckTpCd the imdgPckTpCd to set
	 */
	public void setImdgPckTpCd(String imdgPckTpCd) {
		this.imdgPckTpCd = imdgPckTpCd;
	}

	/**
	 * @return the imdgPckCd
	 */
	public String getImdgPckCd() {
		return imdgPckCd;
	}

	/**
	 * @param imdgPckCd the imdgPckCd to set
	 */
	public void setImdgPckCd(String imdgPckCd) {
		this.imdgPckCd = imdgPckCd;
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
	 * @return the blNo
	 */
	public String getBlNo() {
		return blNo;
	}

	/**
	 * @param blNo the blNo to set
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	

}
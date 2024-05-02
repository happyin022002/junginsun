/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0082Event.java
*@FileTitle : Booking Creation 1_MT P/UP CY inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.05.04 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgMTPickupCYVO;
import com.hanjin.syscommon.common.table.MdmYardVO;


/**
 * esm_bkg_0082 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  esm_bkg_0082HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Jong
 * @see esm_bkg_0082HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0082Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgMTPickupCYVO bkgMTPickupCYVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgMTPickupCYVO[] bkgMTPickupCYVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmYardVO mdmYardVO = null;
	
	/*private String loc_cd = null;
	private String yd_cd = null;
	
	public String getYd_cd() {
		return yd_cd;
	}

	public void setYd_cd(String yd_cd) {
		this.yd_cd = yd_cd;
	}

	public String getLoc_cd() {
		return loc_cd;
	}

	public void setLoc_cd(String loc_cd) {
		this.loc_cd = loc_cd;
	}
*/
	public MdmYardVO getMdmYardVO() {
		return mdmYardVO;
	}

	public void setMdmYardVO(MdmYardVO mdmYardVO) {
		this.mdmYardVO = mdmYardVO;
	}

	public MdmYardVO[] getMdmYardVOs() {
		return mdmYardVOs;
	}

	public void setMdmYardVOs(MdmYardVO[] mdmYardVOs) {
		this.mdmYardVOs = mdmYardVOs;
	}

	/** Table Value Object Multi Data 처리 */
	private MdmYardVO[] mdmYardVOs = null;
	
	private String            locCd            = null;
    private String            selectSheetYdCd       = null;
    
	public String getLocCd() {
		return locCd;
	}

	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}


	public String getSelectSheetYdCd() {
		return selectSheetYdCd;
	}

	public void setSelectSheetYdCd(String selectSheetYdCd) {
		this.selectSheetYdCd = selectSheetYdCd;
	}

	public EsmBkg0082Event(){}
	
	public void setBkgMTPickupCYVO(BkgMTPickupCYVO esmBkgUi0082VO){
		this. bkgMTPickupCYVO = esmBkgUi0082VO;
	}

	public void setBkgMTPickupCYVOS(BkgMTPickupCYVO[] esmBkgUi0082VOs){
		this. bkgMTPickupCYVOs = esmBkgUi0082VOs;
	}

	public BkgMTPickupCYVO getBkgMTPickupCYVO(){
		return bkgMTPickupCYVO;
	}

	public BkgMTPickupCYVO[] getBkgMTPickupCYVOS(){
		return bkgMTPickupCYVOs;
	}

}
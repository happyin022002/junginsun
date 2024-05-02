/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OceanRouteVO.java
*@FileTitle : OceanRouteVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.05.12 김병규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.syscommon.common.table.BkgBookingVO;
import com.hanjin.syscommon.common.table.BkgVvdVO;

/**
 * Container VO<br>
 * - BkgBookingVO
 * - BkgVvdVO
 * - VslSkdVO
 *
 * @author 김병규
 * @since J2EE 1.5
 * @see ..
 */
public class OceanRouteVO {
	/* BkgBookingVO Start  */
	List<BkgBookingVO> bkgBooking 	= new ArrayList<BkgBookingVO>();
	private BkgBookingVO bkgBookingVO = null;
	private BkgBookingVO[] bkgBookingVOs = null;

	public void setBkgBookingVOs(BkgBookingVO[] bkgBookingVOs) {
		this.bkgBookingVOs = bkgBookingVOs;
	}

	public BkgBookingVO[] getBkgBookingVOs() {
		return bkgBookingVOs;
	}

	public void setBkgBookingVO(BkgBookingVO bkgBookingVO) {
		this.bkgBookingVO = bkgBookingVO;
	}

	public BkgBookingVO getBkgBookingVO() {
		return bkgBookingVO;
	}

	public List<BkgBookingVO> getBkgBooking() {
		return bkgBooking;
	}

	public void setBkgBooking(List<BkgBookingVO> bkgBooking) {
		this.bkgBooking = bkgBooking;
	}
	/* BkgBookingVO End  */
	/* BkgVvdVO Start  */
	List<BkgVvdVO> bkgVvd 	= new ArrayList<BkgVvdVO>();
	private BkgVvdVO bkgVvdVO = null;
	private BkgVvdVO[] bkgVvdVOs = null;

	public void setBkgVvdVOs(BkgVvdVO[] bkgVvdVOs) {
		this.bkgVvdVOs = bkgVvdVOs;
	}

	public BkgVvdVO[] getBkgVvdVOs() {
		return bkgVvdVOs;
	}

	public void setBkgVvdVO(BkgVvdVO bkgVvdVO) {
		this.bkgVvdVO = bkgVvdVO;
	}

	public BkgVvdVO getBkgVvdVO() {
		return bkgVvdVO;
	}

	public List<BkgVvdVO> getBkgVvd() {
		return bkgVvd;
	}

	public void setBkgVvd(List<BkgVvdVO> bkgVvd) {
		this.bkgVvd = bkgVvd;
	}
	/* BkgVvdVO End  */
	/* VslSkdVO Start  */
	List<VslSkdVO> vslSkd 	= new ArrayList<VslSkdVO>();
	private VslSkdVO vslSkdVO = null;
	private VslSkdVO[] vslSkdVOs = null;

	public void setVslSkdVOs(VslSkdVO[] vslSkdVOs) {
		this.vslSkdVOs = vslSkdVOs;
	}

	public VslSkdVO[] getVslSkdVOs() {
		return vslSkdVOs;
	}

	public void setVslSkdVO(VslSkdVO vslSkdVO) {
		this.vslSkdVO = vslSkdVO;
	}

	public VslSkdVO getVslSkdVO() {
		return vslSkdVO;
	}

	public List<VslSkdVO> getVslSkd() {
		return vslSkd;
	}

	public void setVslSkd(List<VslSkdVO> vslSkd) {
		this.vslSkd = vslSkd;
	}
	private N1stEtaDelEtaVO n1stEtaDelEtaVO = null;
	/* VslSkdVO End  */

	public N1stEtaDelEtaVO getN1stEtaDelEtaVO() {
		return n1stEtaDelEtaVO;
	}

	public void setN1stEtaDelEtaVO(N1stEtaDelEtaVO etaDelEtaVO) {
		n1stEtaDelEtaVO = etaDelEtaVO;
	}
}

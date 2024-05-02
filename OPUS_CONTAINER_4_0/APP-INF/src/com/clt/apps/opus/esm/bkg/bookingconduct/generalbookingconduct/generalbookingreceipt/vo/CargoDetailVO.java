/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CargoDetailVO.java
*@FileTitle : CargoDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.05.12 김병규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo;

import java.util.ArrayList;
import java.util.List;

import com.clt.syscommon.common.table.BkgQtyDtlVO;
import com.clt.syscommon.common.table.BkgQuantityVO;

public class CargoDetailVO {
	/* BkgQuantityVO Start  */
	List<BkgQuantityVO> bkgQuantity 	= new ArrayList<BkgQuantityVO>();
	private BkgQuantityVO bkgQuantityVO = null;
	private BkgQuantityVO[] bkgQuantityVOs = null;

	public void setBkgQuantityVOs(BkgQuantityVO[] bkgQuantityVOs) {
		this.bkgQuantityVOs = bkgQuantityVOs;
	}

	public BkgQuantityVO[] getBkgQuantityVOs() {
		return bkgQuantityVOs;
	}

	public void setBkgQuantityVO(BkgQuantityVO bkgQuantityVO) {
		this.bkgQuantityVO = bkgQuantityVO;
	}

	public BkgQuantityVO getBkgQuantityVO() {
		return bkgQuantityVO;
	}

	public List<BkgQuantityVO> getBkgQuantity() {
		return bkgQuantity;
	}

	public void setBkgQuantity(List<BkgQuantityVO> bkgQuantity) {
		this.bkgQuantity = bkgQuantity;
	}
	/* BkgQuantityVO End  */
	/* BkgQtyDtlVO Start  */
	List<BkgQtyDtlVO> bkgQtyDtl 	= new ArrayList<BkgQtyDtlVO>();
	private BkgQtyDtlVO bkgQtyDtlVO = null;
	private BkgQtyDtlVO[] bkgQtyDtlVOs = null;

	public void setBkgQtyDtlVOs(BkgQtyDtlVO[] bkgQtyDtlVOs) {
		this.bkgQtyDtlVOs = bkgQtyDtlVOs;
	}

	public BkgQtyDtlVO[] getBkgQtyDtlVOs() {
		return bkgQtyDtlVOs;
	}

	public void setBkgQtyDtlVO(BkgQtyDtlVO bkgQtyDtlVO) {
		this.bkgQtyDtlVO = bkgQtyDtlVO;
	}

	public BkgQtyDtlVO getBkgQtyDtlVO() {
		return bkgQtyDtlVO;
	}

	public List<BkgQtyDtlVO> getBkgQtyDtl() {
		return bkgQtyDtl;
	}

	public void setBkgQtyDtl(List<BkgQtyDtlVO> bkgQtyDtl) {
		this.bkgQtyDtl = bkgQtyDtl;
	}
	/* BkgQtyDtlVO End  */
	/* CargoDtlEtcVO Start  */
	List<CargoDtlEtcVO> cargoDtlEtc 	= new ArrayList<CargoDtlEtcVO>();
	private CargoDtlEtcVO cargoDtlEtcVO = null;
	private CargoDtlEtcVO[] cargoDtlEtcVOs = null;

	public void setCargoDtlEtcVOs(CargoDtlEtcVO[] cargoDtlEtcVOs) {
		this.cargoDtlEtcVOs = cargoDtlEtcVOs;
	}

	public CargoDtlEtcVO[] getCargoDtlEtcVOs() {
		return cargoDtlEtcVOs;
	}

	public void setCargoDtlEtcVO(CargoDtlEtcVO cargoDtlEtcVO) {
		this.cargoDtlEtcVO = cargoDtlEtcVO;
	}

	public CargoDtlEtcVO getCargoDtlEtcVO() {
		return cargoDtlEtcVO;
	}

	public List<CargoDtlEtcVO> getCargoDtlEtc() {
		return cargoDtlEtc;
	}

	public void setCargoDtlEtc(List<CargoDtlEtcVO> cargoDtlEtc) {
		this.cargoDtlEtc = cargoDtlEtc;
	}
	/* CargoDtlEtcVO End  */		
}

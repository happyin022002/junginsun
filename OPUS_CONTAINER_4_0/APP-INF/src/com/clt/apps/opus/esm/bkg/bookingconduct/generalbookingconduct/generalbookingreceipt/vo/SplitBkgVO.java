package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.NewRouteForSplitCodVO;

public class SplitBkgVO {
	List<CopySplitBkgEtcVO> copySplitBkgEtcVO = new ArrayList<CopySplitBkgEtcVO>();
	List<SplitBlInfoVO> splitBlInfoVO = new ArrayList<SplitBlInfoVO>();
//	List<BkgCodCntrVO> bkgCodCntrVO = new ArrayList<BkgCodCntrVO>();
//	List<CodChargeVO> codChargeVO = new ArrayList<CodChargeVO>();
	List<NewRouteForSplitCodVO> newRouteForSplitCodVO = new ArrayList<NewRouteForSplitCodVO>();
	List<SelectSpclCgoVO>selectSpclCgoVO = new ArrayList<SelectSpclCgoVO>();
	List<SplitQtyVO>splitQtyVO = new ArrayList<SplitQtyVO>();
	List<SelectCntrVO>selectCntrVO = new ArrayList<SelectCntrVO>();
	List<SelectTroVO>SelectTroVO = new ArrayList<SelectTroVO>();

	public List<NewRouteForSplitCodVO> getNewRouteForSplitCodVO() {
		return newRouteForSplitCodVO;
	}

	public void setNewRouteForSplitCodVO(
			List<NewRouteForSplitCodVO> newRouteForSplitCodVO) {
		this.newRouteForSplitCodVO = newRouteForSplitCodVO;
	}

	public List<CopySplitBkgEtcVO> getCopySplitBkgEtcVO() {
		return copySplitBkgEtcVO;
	}

	public void setCopySplitBkgEtcVO(List<CopySplitBkgEtcVO> copySplitBkgEtcVO) {
		this.copySplitBkgEtcVO = copySplitBkgEtcVO;
	}

	public List<SplitBlInfoVO> getSplitBlInfoVO() {
		return splitBlInfoVO;
	}

	public void setSplitBlInfoVO(List<SplitBlInfoVO> splitBlInfoVO) {
		this.splitBlInfoVO = splitBlInfoVO;
	}

	public List<SelectSpclCgoVO> getSelectSpclCgoVO() {
		return selectSpclCgoVO;
	}

	public void setSelectSpclCgoVO(List<SelectSpclCgoVO> selectSpclCgoVO) {
		this.selectSpclCgoVO = selectSpclCgoVO;
	}

	public List<SplitQtyVO> getSplitQtyVO() {
		return splitQtyVO;
	}

	public void setSplitQtyVO(List<SplitQtyVO> splitQtyVO) {
		this.splitQtyVO = splitQtyVO;
	}

	public List<SelectCntrVO> getSelectCntrVO() {
		return selectCntrVO;
	}

	public void setSelectCntrVO(List<SelectCntrVO> selectCntrVO) {
		this.selectCntrVO = selectCntrVO;
	}

	public List<SelectTroVO> getSelectTroVO() {
		return SelectTroVO;
	}

	public void setSelectTroVO(List<SelectTroVO> selectTroVO) {
		SelectTroVO = selectTroVO;
	}


}

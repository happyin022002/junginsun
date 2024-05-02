package com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.vo;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.BkgBlForSplitVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.CntrSpclTroSelectVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.CodQtyForSplitVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.LastSplitNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.SpclSeqForSplitVO;
import com.hanjin.syscommon.common.table.BkgQuantityVO;

public class CodSplitVO {
	private List<BkgBlForSplitVO> bkgBlForSplitVO = null;
	private List<BkgQuantityVO> bkgQuantityVO = null;
	private List<CntrSpclTroSelectVO> cntrSpclTroSelectVO = null;
	private List<CodQtyForSplitVO> codQtyForSplitVO = null;
	private List<LastSplitNoVO> lastSplitNoVO = null;
	List<SpclSeqForSplitVO>spclSeqForSplitVO = new ArrayList<SpclSeqForSplitVO>();
	
	public List<BkgBlForSplitVO> getBkgBlForSplitVO() {
		return bkgBlForSplitVO;
	}
	public void setBkgBlForSplitVO(List<BkgBlForSplitVO> bkgBlForSplitVO) {
		this.bkgBlForSplitVO = bkgBlForSplitVO;
	}
	public List<BkgQuantityVO> getBkgQuantityVO() {
		return bkgQuantityVO;
	}
	public void setBkgQuantityVO(List<BkgQuantityVO> bkgQuantityVO) {
		this.bkgQuantityVO = bkgQuantityVO;
	}
	 
	public List<CodQtyForSplitVO> getCodQtyForSplitVO() {
		return codQtyForSplitVO;
	}
	public void setCodQtyForSplitVO(List<CodQtyForSplitVO> codQtyForSplitVO) {
		this.codQtyForSplitVO = codQtyForSplitVO;
	}
	public List<LastSplitNoVO> getLastSplitNoVO() {
		return lastSplitNoVO;
	}
	public void setLastSplitNoVO(List<LastSplitNoVO> lastSplitNoVO) {
		this.lastSplitNoVO = lastSplitNoVO;
	}
	public List<CntrSpclTroSelectVO> getCntrSpclTroSelectVO() {
		return cntrSpclTroSelectVO;
	}
	public void setCntrSpclTroSelectVO(List<CntrSpclTroSelectVO> cntrSpclTroSelectVO) {
		this.cntrSpclTroSelectVO = cntrSpclTroSelectVO;
	}
	public List<SpclSeqForSplitVO> getSpclSeqForSplitVO() {
		return spclSeqForSplitVO;
	}
	public void setSpclSeqForSplitVO(List<SpclSeqForSplitVO> spclSeqForSplitVO) {
		this.spclSeqForSplitVO = spclSeqForSplitVO;
	}
	
	
	
}

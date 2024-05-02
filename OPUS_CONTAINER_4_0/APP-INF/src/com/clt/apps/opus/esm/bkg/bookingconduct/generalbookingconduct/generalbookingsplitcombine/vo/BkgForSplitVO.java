package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo;

import java.util.ArrayList;
import java.util.List;

import com.clt.syscommon.common.table.BkgQuantityVO;



/**
 * BkgBlForSplitListVO Object<br>
 * - 조회결과를 전송하는 Container VO<br>
 *
 * @author 최영희
 * @since J2EE 1.6
 */
public class BkgForSplitVO {
	List<BkgBlForSplitVO>bkgBlForSplitVO = new ArrayList<BkgBlForSplitVO>();
	List<BkgQuantityVO>bkgQuantityVO = new ArrayList<BkgQuantityVO>();
	List<CntrSpclTroSelectVO>cntrSpclTroSelectVO = new ArrayList<CntrSpclTroSelectVO>();
	List<LastSplitNoVO>lastSplitNoVO = new ArrayList<LastSplitNoVO>();
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
	public List<CntrSpclTroSelectVO> getCntrSpclTroSelectVO() {
		return cntrSpclTroSelectVO;
	}
	public void setCntrSpclTroSelectVO(List<CntrSpclTroSelectVO> cntrSpclTroSelectVO) {
		this.cntrSpclTroSelectVO = cntrSpclTroSelectVO;
	}
	public List<LastSplitNoVO> getLastSplitNoVO() {
		return lastSplitNoVO;
	}
	public void setLastSplitNoVO(List<LastSplitNoVO> lastSplitNoVO) {
		this.lastSplitNoVO = lastSplitNoVO;
	}
	public List<SpclSeqForSplitVO> getSpclSeqForSplitVO() {
		return spclSeqForSplitVO;
	}
	public void setSpclSeqForSplitVO(List<SpclSeqForSplitVO> spclSeqForSplitVO) {
		this.spclSeqForSplitVO = spclSeqForSplitVO;
	}
 


}

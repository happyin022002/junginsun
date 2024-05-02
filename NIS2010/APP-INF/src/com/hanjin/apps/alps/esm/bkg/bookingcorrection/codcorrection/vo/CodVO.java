package com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.vo;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.syscommon.common.table.BkgCodCostVO;
import com.hanjin.syscommon.common.table.BkgCodHisDtlVO;
import com.hanjin.syscommon.common.table.BkgCodHisVO;
import com.hanjin.syscommon.common.table.BkgCodVO;
import com.hanjin.syscommon.common.table.BkgCodVvdVO;

public class CodVO {
	private List<CodCntrVO>codCntrVO = new ArrayList<CodCntrVO>();
	private List<BkgCodCostVO>bkgCodCostVO = new ArrayList<BkgCodCostVO>();
	private List<BkgCodHisDtlVO>bkgCodHisDtlVO = new ArrayList<BkgCodHisDtlVO>();
	private List<BkgCodHisVO>bkgCodHisVO = new ArrayList<BkgCodHisVO>();
	private List<CodEtcVO>codEtcVO = new ArrayList<CodEtcVO>();
	private List<BkgCodVvdVO>bkgCodVvdVO = new ArrayList<BkgCodVvdVO>();
	private List<BkgCodVvdVO>bkgOldCodVvdVO = new ArrayList<BkgCodVvdVO>();
	private List<BkgCodVvdVO>bkgNewCodVvdVO = new ArrayList<BkgCodVvdVO>();
	private List<CodLastHistoryVO>codLastHistoryVO = new ArrayList<CodLastHistoryVO>();
	private List<BkgCodVO>bkgCodVO = new ArrayList<BkgCodVO>();
	private List<BkgCodCostSumVO>bkgCodCostSumVO = new ArrayList<BkgCodCostSumVO>();
	private BkgCodVvdVO[] bkgOldCodVvdVOs = null;
	private BkgCodVvdVO[] bkgNewCodVvdVOs = null;
	private BkgCodCostVO[] bkgCodCostVOs = null;
	private BkgCodCostSumVO[] bkgCodCostSumVOs = null;
	private CodRsoVO codRsoVO = null;
	
	public List<CodEtcVO> getCodEtcVO() {
		return codEtcVO;
	}
	public void setCodEtcVO(List<CodEtcVO> codEtcVO) {
		this.codEtcVO = codEtcVO;
	}
	 
	public List<CodCntrVO> getCodCntrVO() {
		return codCntrVO;
	}
	public void setCodCntrVO(List<CodCntrVO> codCntrVO) {
		this.codCntrVO = codCntrVO;
	}
	public List<BkgCodCostVO> getBkgCodCostVO() {
		return bkgCodCostVO;
	}
	public void setBkgCodCostVO(List<BkgCodCostVO> bkgCodCostVO) {
		this.bkgCodCostVO = bkgCodCostVO;
	}
	public List<BkgCodHisDtlVO> getBkgCodHisDtlVO() {
		return bkgCodHisDtlVO;
	}
	public void setBkgCodHisDtlVO(List<BkgCodHisDtlVO> bkgCodHisDtlVO) {
		this.bkgCodHisDtlVO = bkgCodHisDtlVO;
	}
	public List<BkgCodHisVO> getBkgCodHisVO() {
		return bkgCodHisVO;
	}
	public void setBkgCodHisVO(List<BkgCodHisVO> bkgCodHisVO) {
		this.bkgCodHisVO = bkgCodHisVO;
	}
	 
	public List<CodLastHistoryVO> getCodLastHistoryVO() {
		return codLastHistoryVO;
	}
	public void setCodLastHistoryVO(List<CodLastHistoryVO> codLastHistoryVO) {
		this.codLastHistoryVO = codLastHistoryVO;
	}
	public List<BkgCodVO> getBkgCodVO() {
		return bkgCodVO;
	}
	public void setBkgCodVO(List<BkgCodVO> bkgCodVO) {
		this.bkgCodVO = bkgCodVO;
	}
	public List<BkgCodCostSumVO> getBkgCodCostSumVO() {
		return bkgCodCostSumVO;
	}
	public void setBkgCodCostSumVO(List<BkgCodCostSumVO> bkgCodCostSumVO) {
		this.bkgCodCostSumVO = bkgCodCostSumVO;
	}
	public List<BkgCodVvdVO> getBkgOldCodVvdVO() {
		return bkgOldCodVvdVO;
	}
	public void setBkgOldCodVvdVO(List<BkgCodVvdVO> bkgOldCodVvdVO) {
		this.bkgOldCodVvdVO = bkgOldCodVvdVO;
	}
	public List<BkgCodVvdVO> getBkgNewCodVvdVO() {
		return bkgNewCodVvdVO;
	}
	public void setBkgNewCodVvdVO(List<BkgCodVvdVO> bkgNewCodVvdVO) {
		this.bkgNewCodVvdVO = bkgNewCodVvdVO;
	}
	public List<BkgCodVvdVO> getBkgCodVvdVO() {
		return bkgCodVvdVO;
	}
	public void setBkgCodVvdVO(List<BkgCodVvdVO> bkgCodVvdVO) {
		this.bkgCodVvdVO = bkgCodVvdVO;
	}
	public BkgCodVvdVO[] getBkgOldCodVvdVOs() {
		return bkgOldCodVvdVOs;
	}
	public void setBkgOldCodVvdVOs(BkgCodVvdVO[] bkgOldCodVvdVOs) {
		this.bkgOldCodVvdVOs = bkgOldCodVvdVOs;
	}
	public BkgCodVvdVO[] getBkgNewCodVvdVOs() {
		return bkgNewCodVvdVOs;
	}
	public void setBkgNewCodVvdVOs(BkgCodVvdVO[] bkgNewCodVvdVOs) {
		this.bkgNewCodVvdVOs = bkgNewCodVvdVOs;
	}
	public BkgCodCostVO[] getBkgCodCostVOs() {
		return bkgCodCostVOs;
	}
	public void setBkgCodCostVOs(BkgCodCostVO[] bkgCodCostVOs) {
		this.bkgCodCostVOs = bkgCodCostVOs;
	}
	public BkgCodCostSumVO[] getBkgCodCostSumVOs() {
		return bkgCodCostSumVOs;
	}
	public void setBkgCodCostSumVOs(BkgCodCostSumVO[] bkgCodCostSumVOs) {
		this.bkgCodCostSumVOs = bkgCodCostSumVOs;
	}
	public CodRsoVO getCodRsoVO() {
		return codRsoVO;
	}
	public void setCodRsoVO(CodRsoVO codRsoVO) {
		this.codRsoVO = codRsoVO;
	}
	
}

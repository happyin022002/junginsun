package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 * ESM_BKG_0566 화면에서, 조회용 Container VO
 * @author 이남경
 * @since J2EE 1.6
 */
public class HistMainVO {

	/** 조회용 */
	private BkgInforForHistVO bkgInforForHistVO = null;
	
	private List<HistUiNmVO> histUiNmVOs = new ArrayList<HistUiNmVO>();
	private List<BlHistVO>   blHistVOs   = new ArrayList<BlHistVO>();
	

	/**
	 * @return the bkgInforForHistVO
	 */
	public BkgInforForHistVO getBkgInforForHistVO() {
		return bkgInforForHistVO;
	}
	/**
	 * @param bkgInforForHistVO the bkgInforForHistVO to set
	 */
	public void setBkgInforForHistVO(BkgInforForHistVO bkgInforForHistVO) {
		this.bkgInforForHistVO = bkgInforForHistVO;
	}
	/**
	 * @return the histUiNmVOs
	 */
	public List<HistUiNmVO> getHistUiNmVOs() {
		return histUiNmVOs;
	}
	/**
	 * @param histUiNmVOs the histUiNmVOs to set
	 */
	public void setHistUiNmVOs(List<HistUiNmVO> histUiNmVOs) {
		this.histUiNmVOs = histUiNmVOs;
	}
	/**
	 * @return the blHistVOs
	 */
	public List<BlHistVO> getBlHistVOs() {
		return blHistVOs;
	}
	/**
	 * @param blHistVOs the blHistVOs to set
	 */
	public void setBlHistVOs(List<BlHistVO> blHistVOs) {
		this.blHistVOs = blHistVOs;
	}
}
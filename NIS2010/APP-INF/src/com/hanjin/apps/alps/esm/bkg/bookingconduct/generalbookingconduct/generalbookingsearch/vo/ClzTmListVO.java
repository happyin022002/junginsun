package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo;

import java.util.List;

import com.hanjin.framework.component.common.AbstractValueObject;

/**
 *
 * 관련 VO List
 *
 * @author 최영희
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class ClzTmListVO  {
	private List<ClzTmVO> clzTmVO = null;
	private List<BkgForCargoClosingVO> bkgForCargoClosingVO = null;

	public List<ClzTmVO> getClzTmVO() {
		return clzTmVO;
	}
	public void setClzTmVO(List<ClzTmVO> clzTmVO) {
		this.clzTmVO = clzTmVO;
	}
	public List<BkgForCargoClosingVO> getBkgForCargoClosingVO() {
		return bkgForCargoClosingVO;
	}
	public void setBkgForCargoClosingVO(
			List<BkgForCargoClosingVO> bkgForCargoClosingVO) {
		this.bkgForCargoClosingVO = bkgForCargoClosingVO;
	}




}

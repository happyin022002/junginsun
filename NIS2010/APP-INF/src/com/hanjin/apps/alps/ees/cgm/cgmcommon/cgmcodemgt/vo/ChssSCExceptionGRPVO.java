package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo;

import java.util.ArrayList;
import java.util.List;

public class ChssSCExceptionGRPVO {
	
	private CHSSSCExceptionVersionVO 	sCExceptionVersionVO 	= null;
	
	private List<ChssScExceptionVO> 	chssScExceptionVOS		= null;

	public CHSSSCExceptionVersionVO getsCExceptionVersionVO() {
		return sCExceptionVersionVO;
	}

	public void setsCExceptionVersionVO(CHSSSCExceptionVersionVO sCExceptionVersionVO) {
		this.sCExceptionVersionVO = sCExceptionVersionVO;
	}

	public List<ChssScExceptionVO> getChssScExceptionVOS() {
		return chssScExceptionVOS;
	}

	public void setChssScExceptionVOS(List<ChssScExceptionVO> chssScExceptionVOS) {
		this.chssScExceptionVOS = chssScExceptionVOS;
	}
	
	public void setChssScExceptionVOS(ChssScExceptionVO[] chssScExceptionVOs) {
		if (chssScExceptionVOs != null && chssScExceptionVOs.length > 0) {
			chssScExceptionVOS = new ArrayList<ChssScExceptionVO>();
			for (int i = 0 ; i < chssScExceptionVOs.length ; i++) {
				chssScExceptionVOS.add(chssScExceptionVOs[i]);
			}
		}
	}
}

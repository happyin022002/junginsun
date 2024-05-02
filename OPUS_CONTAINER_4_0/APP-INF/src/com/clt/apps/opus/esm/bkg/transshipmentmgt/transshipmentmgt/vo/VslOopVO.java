package com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo;

import java.util.ArrayList;
import java.util.List;

import com.clt.syscommon.common.table.BkgVslOpCrrCdVO;
/**
 * Container Value Object<br>
 * - 조회결과를 전송하는 Container VO<br>
 *
 * @author 최영희
 * @since J2EE 1.6
 */
public class VslOopVO {
	List<VslOopInqVO>vslOopInqVO = new ArrayList<VslOopInqVO>();
	List<BkgVslOpCrrCdVO>bkgVslOpCrrCdVO = new ArrayList<BkgVslOpCrrCdVO>();
	
	 
	public List<VslOopInqVO> getVslOopInqVO() {
		return vslOopInqVO;
	}
	public void setVslOopInqVO(List<VslOopInqVO> vslOopInqVO) {
		this.vslOopInqVO = vslOopInqVO;
	}
	public List<BkgVslOpCrrCdVO> getBkgVslOpCrrCdVO() {
		return bkgVslOpCrrCdVO;
	}
	public void setBkgVslOpCrrCdVO(List<BkgVslOpCrrCdVO> bkgVslOpCrrCdVO) {
		this.bkgVslOpCrrCdVO = bkgVslOpCrrCdVO;
	}
	
}

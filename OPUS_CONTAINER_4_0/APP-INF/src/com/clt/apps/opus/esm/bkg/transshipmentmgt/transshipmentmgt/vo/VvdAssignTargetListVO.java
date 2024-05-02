package com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo;

import java.util.List;

public class VvdAssignTargetListVO {
	private FormerVvdSkdVO formerVvdSkdVO = null;
	private List<VvdAssignTargetBkgVO>vvdAssignTargetBkgVO = null;
	private List<VvdAssignTargetVvdVO>vvdAssignTargetVvdVO = null;
	 
	public List<VvdAssignTargetBkgVO> getVvdAssignTargetBkgVO() {
		return vvdAssignTargetBkgVO;
	}
	public void setVvdAssignTargetBkgVO(
			List<VvdAssignTargetBkgVO> vvdAssignTargetBkgVO) {
		this.vvdAssignTargetBkgVO = vvdAssignTargetBkgVO;
	}
	public List<VvdAssignTargetVvdVO> getVvdAssignTargetVvdVO() {
		return vvdAssignTargetVvdVO;
	}
	public void setVvdAssignTargetVvdVO(
			List<VvdAssignTargetVvdVO> vvdAssignTargetVvdVO) {
		this.vvdAssignTargetVvdVO = vvdAssignTargetVvdVO;
	}
	public FormerVvdSkdVO getFormerVvdSkdVO() {
		return formerVvdSkdVO;
	}
	public void setFormerVvdSkdVO(FormerVvdSkdVO formerVvdSkdVO) {
		this.formerVvdSkdVO = formerVvdSkdVO;
	}
	
	
}

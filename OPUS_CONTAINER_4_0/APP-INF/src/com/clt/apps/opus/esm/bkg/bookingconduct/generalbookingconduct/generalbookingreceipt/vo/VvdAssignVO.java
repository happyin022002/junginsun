package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.VvdPortAssinVO;

public class VvdAssignVO {
	private BkgBlNoVO bkgBlNoVO = null;
	private OldNewVvdVO oldNewVvdVO = null;
	private VvdPortAssinVO vvdPortAssinVO = null;
	private VvdPortAssinVO[] vvdPortAssinVOs = null;
	
	public BkgBlNoVO getBkgBlNoVO() {
		return bkgBlNoVO;
	}
	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO) {
		this.bkgBlNoVO = bkgBlNoVO;
	}
	public OldNewVvdVO getOldNewVvdVO() {
		return oldNewVvdVO;
	}
	public void setOldNewVvdVO(OldNewVvdVO oldNewVvdVO) {
		this.oldNewVvdVO = oldNewVvdVO;
	}

	public void setVvdPortAssinVOs(VvdPortAssinVO[] vvdPortAssinVOs) {
		this.vvdPortAssinVOs = vvdPortAssinVOs;
	}

	public VvdPortAssinVO[] getVvdPortAssinVOs() {
		return vvdPortAssinVOs;
	}
	public void setVvdPortAssinVO(VvdPortAssinVO vvdPortAssinVO) {
		this.vvdPortAssinVO = vvdPortAssinVO;
	}

	public VvdPortAssinVO getVvdPortAssinVO() {
		return vvdPortAssinVO;
	}
	
	
	
}

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.VvdPortAssinVO;

public class VvdAssignVO {
	private BkgBlNoVO bkgBlNoVO = null;
	private OldNewVvdVO oldNewVvdVO = null;
	private VvdPortAssinVO vvdPortAssinVO = null;
	private VvdPortAssinVO[] vvdPortAssinVOs = null;
	private String portSkpFlg = null; 
	private String closedVvds = null;
	
	public String getPortSkpFlg() {
		return portSkpFlg;
	}
	public void setPortSkpFlg(String portSkpFlg) {
		this.portSkpFlg = portSkpFlg;
	}
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
	public String getClosedVvds() {
		return closedVvds;
	}
	public void setClosedVvds(String closedVvds) {
		this.closedVvds = closedVvds;
	}
	
}

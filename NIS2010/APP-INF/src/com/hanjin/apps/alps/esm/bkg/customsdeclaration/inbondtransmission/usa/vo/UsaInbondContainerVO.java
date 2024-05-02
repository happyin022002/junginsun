/**
 * 
 */
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.vo;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.vo.InbondVO;
import com.hanjin.syscommon.common.table.BkgCstmsIbdHisDtlVO;

/**
 * @author user
 * 
 */
public class UsaInbondContainerVO extends InbondVO {
	private static final long serialVersionUID = 1L;
	
	private UsaInbondManifestListVO[] usaInbondManifestListVOs;
	private UsaInbondManifestDetailListVO[] usaInbondManifestDetailListVOs;
	private BkgCstmsIbdHisDtlVO[] bkgCstmsIbdHisDtlVOs;
	
	/**
	 * 생성자
	 * @param
	 * @return 
	 */
	public UsaInbondContainerVO() {}
	
	public UsaInbondManifestListVO[] getUsaInbondManifestListVOs() {
		return usaInbondManifestListVOs;
	}
	
	public void setUsaInbondManifestListVOs(UsaInbondManifestListVO[] usaInbondManifestDetailVOs) {
		this.usaInbondManifestListVOs = usaInbondManifestDetailVOs;
	}

	public UsaInbondManifestDetailListVO[] getUsaInbondManifestDetailListVOs() {
		
		return usaInbondManifestDetailListVOs;
	}
	
	public void setUsaInbondManifestDetailListVOs(UsaInbondManifestDetailListVO[] usaInbondManifestDetailListVOs) {
		this.usaInbondManifestDetailListVOs = usaInbondManifestDetailListVOs;
	}
	
	public void setBlHisDtlVOs(BkgCstmsIbdHisDtlVO[] bkgCstmsIbdHisDtlVOs) {
		this.bkgCstmsIbdHisDtlVOs = bkgCstmsIbdHisDtlVOs;
	}
	public BkgCstmsIbdHisDtlVO[] getBlHisDtlVOs(){
		return this.bkgCstmsIbdHisDtlVOs;
	}
	

}

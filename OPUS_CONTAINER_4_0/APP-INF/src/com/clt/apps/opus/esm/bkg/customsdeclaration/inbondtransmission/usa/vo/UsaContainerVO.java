/**
 * 
 */
package com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.vo;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.vo.InbondMibListDetailVO;

/**
 * @author user
 * 
 */
public class UsaContainerVO extends InbondMibListDetailVO {
	private static final long serialVersionUID = 1L;
	
	private List<UsaInbondManifestListVO> usaInbondManifestListVOs;
	
	private List<UsaInbondManifestDetailListVO> inbondBlDetailListVOs;
	private List<UsaInbondManifestDetailListVO> localBlDetailListVOs;
	
	/**
	 * 생성자
	 * @param
	 * @return 
	 */
	public UsaContainerVO() {}
	
	public List<UsaInbondManifestListVO> getUsaInbondManifestListVOs() {
		return usaInbondManifestListVOs;
	}
	
	public void setUsaInbondManifestListVOs(List<UsaInbondManifestListVO> usaInbondManifestDetailVOs) {
		this.usaInbondManifestListVOs = usaInbondManifestDetailVOs;
	}

	public List<UsaInbondManifestDetailListVO> getInbondBlDetailListVOs() {
		
		return inbondBlDetailListVOs;
	}
	
	public void setInbondBlDetailListVOs(List<UsaInbondManifestDetailListVO> inbondBlDetailListVOs) {
		this.inbondBlDetailListVOs = inbondBlDetailListVOs;
	}
	

	public List<UsaInbondManifestDetailListVO> getLocalBlDetailListVOs() {
		return localBlDetailListVOs;
	}
	
	public void setLocalBlDetailListVOs(List<UsaInbondManifestDetailListVO> localBlDetailListVOs) {
		this.localBlDetailListVOs = localBlDetailListVOs;
	}

}

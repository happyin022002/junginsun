package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.bangladesh.vo;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestModificationVO;

public class BangladeshManifestModificationVO extends ManifestModificationVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BangladeshManifestListInboundVO[] bangladeshManifestListInboundVOs = null;
	private BangladeshManifestListOutboundVO[] bangladeshManifestListOutboundVOs = null;
	
	private String ioFlag = null;
	

	public BangladeshManifestModificationVO() {}


	public BangladeshManifestListInboundVO[] getBangladeshManifestListInboundVOs() {
		return bangladeshManifestListInboundVOs;
	}


	public void setBangladeshManifestListInboundVOs(
			BangladeshManifestListInboundVO[] bangladeshManifestListInboundVOs) {
		this.bangladeshManifestListInboundVOs = bangladeshManifestListInboundVOs;
	}


	public BangladeshManifestListOutboundVO[] getBangladeshManifestListOutboundVOs() {
		return bangladeshManifestListOutboundVOs;
	}


	public void setBangladeshManifestListOutboundVOs(
			BangladeshManifestListOutboundVO[] bangladeshManifestListOutboundVOs) {
		this.bangladeshManifestListOutboundVOs = bangladeshManifestListOutboundVOs;
	}


	public String getIoFlag() {
		return ioFlag;
	}

	public void setIoFlag(String ioFlag) {
		this.ioFlag = ioFlag;
	} 
	
	
}

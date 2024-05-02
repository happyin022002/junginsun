package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo;

import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.CustomMnrOrdTmpDtlVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.CustomMnrOrdTmpHdrVO;

public class EDIInvoiceParkingLotGRPVO {
	private CustomMnrOrdTmpHdrVO[] customMnrOrdTmpHdrVOs = null;
	private CustomMnrOrdTmpDtlVO[] customMnrOrdTmpDtlVOs = null;
	
	public CustomMnrOrdTmpHdrVO[] getCustomMnrOrdTmpHdrVOs() {
		return customMnrOrdTmpHdrVOs;
	}
	public void setCustomMnrOrdTmpHdrVOs(
			CustomMnrOrdTmpHdrVO[] customMnrOrdTmpHdrVOs) {
		this.customMnrOrdTmpHdrVOs = customMnrOrdTmpHdrVOs;
	}
	public CustomMnrOrdTmpDtlVO[] getCustomMnrOrdTmpDtlVOs() {
		return customMnrOrdTmpDtlVOs;
	}
	public void setCustomMnrOrdTmpDtlVOs(
			CustomMnrOrdTmpDtlVO[] customMnrOrdTmpDtlVOs) {
		this.customMnrOrdTmpDtlVOs = customMnrOrdTmpDtlVOs;
	}
	
	
}

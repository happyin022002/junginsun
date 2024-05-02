package com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.vo;

import java.util.List;

public class CodRehandlingInfoVO {
	private List<CodCntrVO> codCntrVOs = null;
	private CodOldNewRhndPortVvdVO codOldNewRhndPortVvdVO = null;
	public CodOldNewRhndPortVvdVO getCodOldNewRhndPortVvdVO() {
		return codOldNewRhndPortVvdVO;
	}
	public void setCodOldNewRhndPortVvdVO(CodOldNewRhndPortVvdVO codOldNewRhndPortVvdVO) {
		this.codOldNewRhndPortVvdVO = codOldNewRhndPortVvdVO;
	}
	public List<CodCntrVO> getCodCntrVOs() {
		return codCntrVOs;
	}
	public void setCodCntrVOs(List<CodCntrVO> codCntrVOs) {
		this.codCntrVOs = codCntrVOs;
	}
}

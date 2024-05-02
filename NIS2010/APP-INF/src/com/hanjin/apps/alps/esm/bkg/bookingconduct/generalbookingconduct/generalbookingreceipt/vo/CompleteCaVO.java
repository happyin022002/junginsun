package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.vo.CaRsnRmkVO;

public class CompleteCaVO {
	BkgBlNoVO bkgBlNoVO = null;
	CaRsnRmkVO caRsnRmkVO = null; 
	String preChecking = null;
	String codFlg = null;
	
	public BkgBlNoVO getBkgBlNoVO() {
		return bkgBlNoVO;
	}
	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO) {
		this.bkgBlNoVO = bkgBlNoVO;
	}
	public CaRsnRmkVO getCaRsnRmkVO() {
		return caRsnRmkVO;
	}
	public void setCaRsnRmkVO(CaRsnRmkVO caRsnRmkVO) {
		this.caRsnRmkVO = caRsnRmkVO;
	}
	public String getPreChecking() {
		return preChecking;
	}
	public void setPreChecking(String preChecking) {
		this.preChecking = preChecking;
	}
	public String getCodFlg() {
		return codFlg;
	}
	public void setCodFlg(String codFlg) {
		this.codFlg = codFlg;
	}
	
	
}

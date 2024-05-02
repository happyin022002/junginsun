/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ExRateListVO.java
 *@FileTitle : ExRateListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.16
 *@LastModifier : 박정진
 *@LastVersion : 1.0
 * 2009.10.16 박정진 
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo;

import java.util.List;

public class ExRateListVO {

	private List<VVDExrateVO> vvdExrateList = null;

	private List<CustDailyExRateVO> custDailyExRateList = null;

	private List<GLMonExrateVO> glMonExrateList = null;

	public List<VVDExrateVO> getVvdExrateList() {
		return vvdExrateList;
	}

	public void setVvdExrateList(List<VVDExrateVO> vvdExrateList) {
		this.vvdExrateList = vvdExrateList;
	}

	public List<CustDailyExRateVO> getCustDailyExRateList() {
		return custDailyExRateList;
	}

	public void setCustDailyExRateList(List<CustDailyExRateVO> custDailyExRateList) {
		this.custDailyExRateList = custDailyExRateList;
	}

	public List<GLMonExrateVO> getGlMonExrateList() {
		return glMonExrateList;
	}

	public void setGlMonExrateList(List<GLMonExrateVO> glMonExrateList) {
		this.glMonExrateList = glMonExrateList;
	}
}

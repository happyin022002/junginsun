/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0956Event.java
 *@FileTitle : Integrated Customer Data Management
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.20
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2009.05.20 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgArrNtcCntrVO;

/**
 * esm_bkg_0956 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0956HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author
 * @see ESM_BKG_0956HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0956Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private BkgArrNtcCntrVO[] listVOS = null;
	private BkgArrNtcCntrVO searchVO = null;
	private String bkgNo = "";
	

	public BkgArrNtcCntrVO getSearchVO() {
		return searchVO;
	}

	public void setSearchVO(BkgArrNtcCntrVO searchVO) {
		this.searchVO = searchVO;
	}

	public EsmBkg0956Event() {
	}

//	public BkgArrNtcCntrVO[] getListVOS() {
//		return listVOS;
//	}

	//2015.04.14 Secure Coding 적용[CWE-496]
	public BkgArrNtcCntrVO[] getListVOS() {
		BkgArrNtcCntrVO[] tmpVOs = null;
		if (this.listVOS != null) {
			tmpVOs = new BkgArrNtcCntrVO[listVOS.length];
			System.arraycopy(listVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	} 
	
//	public void setListVOS(BkgArrNtcCntrVO[] listVOS) {
//		this.listVOS = listVOS;
//	}
	
	//2015.04.14 Secure Coding 적용[CWE-496]
	public void setListVOS(BkgArrNtcCntrVO[] listVOS) {
		if (listVOS != null) {
			BkgArrNtcCntrVO[] tmpVOs = new BkgArrNtcCntrVO[listVOS.length];
			System.arraycopy(listVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.listVOS = tmpVOs;
		}		
	} 

	public void setBkgNo(String bkgNo) {
		// TODO Auto-generated method stub
		this.bkgNo = bkgNo;
	}
	public String getBkgNo() {
		return bkgNo;
	}

}
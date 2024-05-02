/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0243Event.java
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
import com.clt.syscommon.common.table.BkgArrNtcVO;

/**
 * esm_bkg_0243 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0243HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author
 * @see ESM_BKG_0243HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0243Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String ofcCd = "";
	private String podCd = "";
	private String anFomCd = "";
	private String agent = "";
	
	private BkgArrNtcVO bkgArrNtcVO = null;
	private BkgArrNtcVO[] bkgArrNtcVOS = null;

	public EsmBkg0243Event() {
	}

	public String getOfcCd() {
		return ofcCd;
	}

	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	public String getPodCd() {
		return podCd;
	}

	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}

	public String getAnFomCd() {
		return anFomCd;
	}

	public void setAnFomCd(String anFomCd) {
		this.anFomCd = anFomCd;
	}

//	public BkgArrNtcVO[] getBkgArrNtcVOS() {
//		return bkgArrNtcVOS;
//	}
	
	//2015.04.14 Secure Coding 적용[CWE-496]
	public BkgArrNtcVO[] getBkgArrNtcVOS() {
		BkgArrNtcVO[] tmpVOs = null;
		if (this.bkgArrNtcVOS != null) {
			tmpVOs = new BkgArrNtcVO[bkgArrNtcVOS.length];
			System.arraycopy(bkgArrNtcVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	} 

//	public void setBkgArrNtcVOS(BkgArrNtcVO[] bkgArrNtcVOS) {
//		this.bkgArrNtcVOS = bkgArrNtcVOS;
//	}

	//2015.04.14 Secure Coding 적용[CWE-496]
	public void setBkgArrNtcVOS(BkgArrNtcVO[] bkgArrNtcVOS) {
		if (bkgArrNtcVOS != null) {
			BkgArrNtcVO[] tmpVOs = new BkgArrNtcVO[bkgArrNtcVOS.length];
			System.arraycopy(bkgArrNtcVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.bkgArrNtcVOS = tmpVOs;
		}		
	} 
	
	/**
	 * @param bkgArrNtcVO the bkgArrNtcVO to set
	 */
	public void setBkgArrNtcVO(BkgArrNtcVO bkgArrNtcVO) {
		this.bkgArrNtcVO = bkgArrNtcVO;
	}

	/**
	 * @return the bkgArrNtcVO
	 */
	public BkgArrNtcVO getBkgArrNtcVO() {
		return bkgArrNtcVO;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	
}
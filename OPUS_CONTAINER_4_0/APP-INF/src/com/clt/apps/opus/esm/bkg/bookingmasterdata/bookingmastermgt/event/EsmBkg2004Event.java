	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : EsmBkg2004Event.java
	 *@FileTitle : Hard Coding Setup
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2012.04.09
	 *@LastModifier : 조정민
	 *@LastVersion : 1.0
	 * 2012.04.09 조정민
	 * 1.0 Creation
	 =========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event;

import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgHrdCdgDescVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_2004 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_2004HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see ESM_BKG_2004HTMLAction reference
 * @since J2EE 1.6
 */
public class EsmBkg2004Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 화면 조회 조건 */
	private BkgHrdCdgDescVO bkgHrdCdgDescVO = null;
	
	/** Table Value Object 화면 조회 복수 출력 */
	private BkgHrdCdgDescVO[] bkgHrdCdgDescVOs = null;
	
	public EsmBkg2004Event(){}

	public BkgHrdCdgDescVO getBkgHrdCdgDescVO() {
		return bkgHrdCdgDescVO;
	}

	public void setBkgHrdCdgDescVO(BkgHrdCdgDescVO bkgHrdCdgDescVO) {
		this.bkgHrdCdgDescVO = bkgHrdCdgDescVO;
	}

//	public BkgHrdCdgDescVO[] getBkgHrdCdgDescVOs() {
//		return bkgHrdCdgDescVOs;
//	}
	
	//2015.04.10 Secure Coding 적용[CWE-496]
	public BkgHrdCdgDescVO[] getBkgHrdCdgDescVOs() {
		BkgHrdCdgDescVO[] tmpVOs = null;
		if (this.bkgHrdCdgDescVOs != null) {
			tmpVOs = new BkgHrdCdgDescVO[bkgHrdCdgDescVOs.length];
			System.arraycopy(bkgHrdCdgDescVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}	

//	public void setBkgHrdCdgDescVOs(BkgHrdCdgDescVO[] bkgHrdCdgDescVOs) {
//		this.bkgHrdCdgDescVOs = bkgHrdCdgDescVOs;
//	}
	
	//2015.04.10 Secure Coding 적용[CWE-496]
	public void setBkgHrdCdgDescVOs(BkgHrdCdgDescVO[] bkgHrdCdgDescVOs) {
		if (bkgHrdCdgDescVOs != null) {
			BkgHrdCdgDescVO[] tmpVOs = new BkgHrdCdgDescVO[bkgHrdCdgDescVOs.length];
			System.arraycopy(bkgHrdCdgDescVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bkgHrdCdgDescVOs = tmpVOs;
		}		
	} 
}

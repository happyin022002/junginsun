/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0320Event.java
*@FileTitle : CndManifestListDownload
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.25 김경섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event;

import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCustTmpltVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchInBoundCustListVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.VskVslPortSkdConditionVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0320 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0320HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김경섭
 * @see ESM_BKG_0320HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0192Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmBkg0192Event(){}
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchInBoundCustListVO infoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchInBoundCustListVO[] infoVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgCustTmpltVO infoVO2 = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgCustTmpltVO[] infoVO2s = null;
	
	
	
	
	public SearchInBoundCustListVO getInfoVO() {
		return infoVO;
	}

	public void setInfoVO(SearchInBoundCustListVO infoVO) {
		this.infoVO = infoVO;
	}

//	public SearchInBoundCustListVO[] getInfoVOs() {
//		return infoVOs;
//	}
	
	//2015.04.13 Secure Coding 적용[CWE-496]
	public SearchInBoundCustListVO[] getInfoVOs() {
		SearchInBoundCustListVO[] tmpVOs = null;
		if (this.infoVOs != null) {
			tmpVOs = new SearchInBoundCustListVO[infoVOs.length];
			System.arraycopy(infoVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}	

//	public void setInfoVOs(SearchInBoundCustListVO[] infoVOs) {
//		this.infoVOs = infoVOs;
//	}

	//2015.04.13 Secure Coding 적용[CWE-496]
	public void setInfoVOs(SearchInBoundCustListVO[] infoVOs) {
		if (infoVOs != null) {
			SearchInBoundCustListVO[] tmpVOs = new SearchInBoundCustListVO[infoVOs.length];
			System.arraycopy(infoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.infoVOs = tmpVOs;
		}		
	}	
	
	public BkgCustTmpltVO getInfoVO2() {
		return infoVO2;
	}

	public void setInfoVO2(BkgCustTmpltVO infoVO2) {
		this.infoVO2 = infoVO2;
	}

//	public BkgCustTmpltVO[] getInfoVO2s() {
//		return infoVO2s;
//	}

	//2015.04.13 Secure Coding 적용[CWE-496]
	public BkgCustTmpltVO[] getInfoVO2s() {
		BkgCustTmpltVO[] tmpVOs = null;
		if (this.infoVO2s != null) {
			tmpVOs = new BkgCustTmpltVO[infoVO2s.length];
			System.arraycopy(infoVO2s, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}
	
//	public void setInfoVO2s(BkgCustTmpltVO[] infoVO2s) {
//		this.infoVO2s = infoVO2s;
//	}

	//2015.04.13 Secure Coding 적용[CWE-496]
	public void setInfoVO2s(BkgCustTmpltVO[] infoVO2s) {
		if (infoVO2s != null) {
			BkgCustTmpltVO[] tmpVOs = new BkgCustTmpltVO[infoVO2s.length];
			System.arraycopy(infoVO2s, 0, tmpVOs, 0, tmpVOs.length);
			this.infoVO2s = tmpVOs;
		}		
	}	
	
	
}
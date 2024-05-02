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
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event;

import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCustTmpltVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchInBoundCustListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


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

	public SearchInBoundCustListVO[] getInfoVOs() {
		return infoVOs;
	}

	public void setInfoVOs(SearchInBoundCustListVO[] infoVOs) {
		this.infoVOs = infoVOs;
	}

	public BkgCustTmpltVO getInfoVO2() {
		return infoVO2;
	}

	public void setInfoVO2(BkgCustTmpltVO infoVO2) {
		this.infoVO2 = infoVO2;
	}

	public BkgCustTmpltVO[] getInfoVO2s() {
		return infoVO2s;
	}

	public void setInfoVO2s(BkgCustTmpltVO[] infoVO2s) {
		this.infoVO2s = infoVO2s;
	}


	
	
}
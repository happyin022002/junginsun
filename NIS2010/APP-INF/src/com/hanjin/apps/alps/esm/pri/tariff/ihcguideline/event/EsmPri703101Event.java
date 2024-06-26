/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmPri703101Event.java
*@FileTitle : US Inland Add-on Creation & Amendment - Dry tab
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.07
*@LastModifier : SEO MI JIN
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.event;

import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.IHCGuidelineDetailVO;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.IHCGuidelineMainVO;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.SearchUsInlandServiceModeTotalVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_703101 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_7031_01HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SEO MI JIN
 * @see ESM_PRI_7031_01HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri703101Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	public EsmPri703101Event(){}
	
	private SearchUsInlandServiceModeTotalVO searchUsInlandServiceModeTotalVO = null;
	
	private IHCGuidelineMainVO iHCGuidelineMainVO = null;
	
	private IHCGuidelineDetailVO iHCGuidelineDetailVO = null;
	
	private IHCGuidelineDetailVO[] iHCGuidelineDetailVOs = null;



	public SearchUsInlandServiceModeTotalVO getSearchUsInlandServiceModeTotalVO() {
		return searchUsInlandServiceModeTotalVO;
	}

	public void setSearchUsInlandServiceModeTotalVO(
			SearchUsInlandServiceModeTotalVO searchUsInlandServiceModeTotalVO) {
		this.searchUsInlandServiceModeTotalVO = searchUsInlandServiceModeTotalVO;
	}

	public IHCGuidelineMainVO getiHCGuidelineMainVO() {
		return iHCGuidelineMainVO;
	}

	public void setiHCGuidelineMainVO(IHCGuidelineMainVO iHCGuidelineMainVO) {
		this.iHCGuidelineMainVO = iHCGuidelineMainVO;
	}

	public IHCGuidelineDetailVO getiHCGuidelineDetailVO() {
		return iHCGuidelineDetailVO;
	}

	public void setiHCGuidelineDetailVO(IHCGuidelineDetailVO iHCGuidelineDetailVO) {
		this.iHCGuidelineDetailVO = iHCGuidelineDetailVO;
	}

	public IHCGuidelineDetailVO[] getiHCGuidelineDetailVOs() {
		return iHCGuidelineDetailVOs;
	}

	public void setiHCGuidelineDetailVOs(
			IHCGuidelineDetailVO[] iHCGuidelineDetailVOs) {
		this.iHCGuidelineDetailVOs = iHCGuidelineDetailVOs;
	}
	
}
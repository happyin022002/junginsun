/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg1604Event.java
 *@FileTitle :
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier :
 *@LastVersion : 1.0
 * 2014.12.11
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.EurDgListVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.EurDgSummaryListVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * esm_bkg_1604 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_1604HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author CLT
 * @see ESM_BKG_1604HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg1604Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private EurDgListVO eurDgListVO = null;
	private EurDgListVO[] eurDgListVOs = null;
    private EurDgSummaryListVO eurDgSummaryListVO =null;
    private EurDgSummaryListVO[] eurDgSummaryListVOs =null;
	/**
	 * @return the EurDgListVO
	 */
	public EurDgListVO getEurDgListVO() {
		return eurDgListVO;
	}
    
	/**
	 * @param EurDgListVO
	 *            the EurDgListVO to set
	 */
	public void setEurDgListVO(EurDgListVO eurDgListVO) {
		this.eurDgListVO = eurDgListVO;
	}

	public EurDgListVO[] getEurDgListVOs() {
		EurDgListVO[] rtnVOs = null;
		if (this.eurDgListVOs != null) {
			rtnVOs = Arrays.copyOf(eurDgListVOs, eurDgListVOs.length);
		}
		return rtnVOs;
	}

	public void setEurDgListVOs(EurDgListVO[] eurDgListVOs) {
		if (eurDgListVOs != null) {
			EurDgListVO[] tmpVOs = Arrays.copyOf(eurDgListVOs, eurDgListVOs.length);
			this.eurDgListVOs = tmpVOs;
		}
	}
	
	/**
	 * @return the EurDgSummaryListVO
	 */
	public EurDgSummaryListVO getEurDgSummaryListVO() {
		return eurDgSummaryListVO;
	}
    
	/**
	 * @param EurDgSummaryListVO
	 *            the EurDgSummaryListVO to set
	 */
	public void setEurDgSummaryListVO(EurDgSummaryListVO eurDgSummaryListVO) {
		this.eurDgSummaryListVO = eurDgSummaryListVO;
	}

	public EurDgSummaryListVO[] getEurDgSummaryListVOs() {
		EurDgSummaryListVO[] rtnVOs = null;
		if (this.eurDgListVOs != null) {
			rtnVOs = Arrays.copyOf(eurDgSummaryListVOs, eurDgSummaryListVOs.length);
		}
		return rtnVOs;
	}

	public void setEurDgSummaryListVOs(EurDgSummaryListVO[] eurDgSummaryListVOs) {
		if (eurDgSummaryListVOs != null) {
			EurDgSummaryListVO[] tmpVOs = Arrays.copyOf(eurDgSummaryListVOs, eurDgSummaryListVOs.length);
			this.eurDgSummaryListVOs = tmpVOs;
		}
	}
}

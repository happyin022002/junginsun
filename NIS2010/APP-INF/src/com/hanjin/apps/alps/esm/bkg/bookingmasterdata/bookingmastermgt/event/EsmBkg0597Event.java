/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0597HTMLAction.java
*@FileTitle :l BDR
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.01
*@LastModifier : 신규정
*@LastVersion : 1.0
* 2014.04.01 신규정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BdrAccessAuthorityInfoVO;


/**
 * ESM_BKG_0597 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0597HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Shin Kyu Jeong
 * @see ESM_BKG_0597HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0597Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BdrAccessAuthorityInfoVO bdrAccessAuthorityInfoVO = null;
	private BdrAccessAuthorityInfoVO[] bdrAccessAuthorityInfoVOs = null;

	/**
	 * @return the bdrAccessAuthorityInfoVO
	 */
	public BdrAccessAuthorityInfoVO getBdrAccessAuthorityInfoVO() {
		return bdrAccessAuthorityInfoVO;
	}

	/**
	 * @param bdrAccessAuthorityInfoVO the bdrAccessAuthorityInfoVO to set
	 */
	public void setBdrAccessAuthorityInfoVO(
			BdrAccessAuthorityInfoVO bdrAccessAuthorityInfoVO) {
		this.bdrAccessAuthorityInfoVO = bdrAccessAuthorityInfoVO;
	}

	/**
	 * @return the bdrAccessAuthorityInfoVOs
	 */
	public BdrAccessAuthorityInfoVO[] getBdrAccessAuthorityInfoVOs() {
		return bdrAccessAuthorityInfoVOs;
	}

	/**
	 * @param bdrAccessAuthorityInfoVOs the bdrAccessAuthorityInfoVOs to set
	 */
	public void setBdrAccessAuthorityInfoVOs(
			BdrAccessAuthorityInfoVO[] bdrAccessAuthorityInfoVOs) {
		this.bdrAccessAuthorityInfoVOs = bdrAccessAuthorityInfoVOs;
	}
	



}
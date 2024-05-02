/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0771Event.java
*@FileTitle : Covered B/L
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.08
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.07.08 이진서
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.CoveredBlListVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0771 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0771HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Jin Seo
 * @see ESM_BKG_0771HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0771Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	public EsmBkg0771Event(){}

	private String bkgNo = null;
	private String blNo = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CoveredBlListVO coveredBlListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CoveredBlListVO[] coveredBlListVOs = null;


	/**
	 * @return the bkg_no
	 */
	public String getBkg_no() {
		return bkgNo;
	}

	/**
	 * @param bkg_no the bkg_no to set
	 */
	public void setBkg_no(String bkg_no) {
		this.bkgNo = bkg_no;
	}

	/**
	 * @return the bl_no
	 */
	public String getBl_no() {
		return blNo;
	}

	/**
	 * @param bl_no the bl_no to set
	 */
	public void setBl_no(String bl_no) {
		this.blNo = bl_no;
	}

	/**
	 * @return the coveredBlListVO
	 */
	public CoveredBlListVO getCoveredBlListVO() {
		return coveredBlListVO;
	}

	/**
	 * @param coveredBlListVO the coveredBlListVO to set
	 */
	public void setCoveredBlListVO(CoveredBlListVO coveredBlListVO) {
		this.coveredBlListVO = coveredBlListVO;
	}

	public CoveredBlListVO[] getCoveredBlListVOs() {
		CoveredBlListVO[] rtnVOs = null;
		if (this.coveredBlListVOs != null) {
			rtnVOs = Arrays.copyOf(coveredBlListVOs, coveredBlListVOs.length);
		}
		return rtnVOs;
	}

	public void setCoveredBlListVOs(CoveredBlListVO[] coveredBlListVOs) {
		if (coveredBlListVOs != null) {
			CoveredBlListVO[] tmpVOs = Arrays.copyOf(coveredBlListVOs, coveredBlListVOs.length);
			this.coveredBlListVOs = tmpVOs;
		}
	}





}
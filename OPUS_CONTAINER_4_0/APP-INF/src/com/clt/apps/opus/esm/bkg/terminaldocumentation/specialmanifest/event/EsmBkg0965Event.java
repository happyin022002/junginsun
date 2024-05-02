/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0965Event.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier :
*@LastVersion : 1.0
* 2009.05.11
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.DgEdiVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.DgListCondVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.DgListModiVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.DgValidationCondVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.sun.xml.bind.v2.TODO;

/**
 * esm_bkg_0965 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0965HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kyoung Jong Yun
 * @see ESM_BKG_0965HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg0965Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private DgListCondVO dgListCondVO = null;
	private DgValidationCondVO dgValidationCondVO = null;

	private DgListModiVO dgListModiVO = null;
	private DgListModiVO[] dgListModiVOs = null;

	private DgEdiVO[] dgEdiVOs = null;

	public String ediPreview = null;

	/**
	 * @return the dgListCondVO
	 */
	public DgListCondVO getDgListCondVO() {
		return dgListCondVO;
	}

	/**
	 * @param dgListCondVO the dgListCondVO to set
	 */
	public void setDgListCondVO(DgListCondVO dgListCondVO) {
		this.dgListCondVO = dgListCondVO;
	}

	/**
	 * @return the dgListModiVO
	 */
	public DgListModiVO getDgListModiVO() {
		return dgListModiVO;
	}

	/**
	 * @param dgListModiVO the dgListModiVO to set
	 */
	public void setDgListModiVO(DgListModiVO dgListModiVO) {
		this.dgListModiVO = dgListModiVO;
	}

	/**
	 * @return the dgValidationCondVO
	 */
	public DgValidationCondVO getDgValidationCondVO() {
		return dgValidationCondVO;
	}

	/**
	 * @param dgValidationCondVO the dgValidationCondVO to set
	 */
	public void setDgValidationCondVO(DgValidationCondVO dgValidationCondVO) {
		this.dgValidationCondVO = dgValidationCondVO;
	}

	public void setEdiPreview(String ediPreview) {
		this.ediPreview = ediPreview;
	}

	public String getEdiPreview() {
		return ediPreview;
	}

	public DgListModiVO[] getDgListModiVOs() {
		DgListModiVO[] rtnVOs = null;
		if (this.dgListModiVOs != null) {
			rtnVOs = Arrays.copyOf(dgListModiVOs, dgListModiVOs.length);
		}
		return rtnVOs;
	}

	public void setDgListModiVOs(DgListModiVO[] dgListModiVOs) {
		if (dgListModiVOs != null) {
			DgListModiVO[] tmpVOs = Arrays.copyOf(dgListModiVOs, dgListModiVOs.length);
			this.dgListModiVOs = tmpVOs;
		}
	}

	public DgEdiVO[] getDgEdiVOs() {
		DgEdiVO[] rtnVOs = null;
		if (this.dgEdiVOs != null) {
			rtnVOs = Arrays.copyOf(dgEdiVOs, dgEdiVOs.length);
		}
		return rtnVOs;
	}

	public void setDgEdiVOs(DgEdiVO[] dgEdiVOs) {
		if (dgEdiVOs != null) {
			DgEdiVO[] tmpVOs = Arrays.copyOf(dgEdiVOs, dgEdiVOs.length);
			this.dgEdiVOs = tmpVOs;
		}
	}

}

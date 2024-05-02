/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0965Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.05.11 경종윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.event;

import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.vo.DgEdiVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.vo.DgListCondVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.vo.DgListModiVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.vo.DgValidationCondVO;
import com.hanjin.framework.support.layer.event.EventSupport;

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
	 * @return the dgListModiVOs
	 */
	public DgListModiVO[] getDgListModiVOs() {
		return dgListModiVOs;
	}

	/**
	 * @param dgListModiVOs the dgListModiVOs to set
	 */
	public void setDgListModiVOs(DgListModiVO[] dgListModiVOs) {
		this.dgListModiVOs = dgListModiVOs;
	}

	/**
	 * @return the dgEdiVOs
	 */
	public DgEdiVO[] getDgEdiVOs() {
		return dgEdiVOs;
	}

	/**
	 * @param dgEdiVOs the dgEdiVOs to set
	 */
	public void setDgEdiVOs(DgEdiVO[] dgEdiVOs) {
		this.dgEdiVOs = dgEdiVOs;
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

	

	
}

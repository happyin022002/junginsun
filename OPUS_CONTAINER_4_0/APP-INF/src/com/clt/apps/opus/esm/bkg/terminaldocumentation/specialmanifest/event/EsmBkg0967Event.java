/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0967Event.java
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

import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.DgCargoCondVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.DgInqModiVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.DgListCondVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * esm_bkg_0967 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0967HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kyoung Jong Yun
 * @see ESM_BKG_0967HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg0967Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private DgListCondVO dgListCondVO = null;
	private DgCargoCondVO dgCargoCondVO = null;
	private DgInqModiVO dgInqModiVO = null;
	private DgInqModiVO[] dgInqModiVOs = null;
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
	 * @return the dgCargoCondVO
	 */
	public DgCargoCondVO getDgCargoCondVO() {
		return dgCargoCondVO;
	}
	/**
	 * @param dgCargoCondVO the dgCargoCondVO to set
	 */
	public void setDgCargoCondVO(DgCargoCondVO dgCargoCondVO) {
		this.dgCargoCondVO = dgCargoCondVO;
	}
	/**
	 * @return the dgInqModiVO
	 */
	public DgInqModiVO getDgInqModiVO() {
		return dgInqModiVO;
	}
	/**
	 * @param dgInqModiVO the dgInqModiVO to set
	 */
	public void setDgInqModiVO(DgInqModiVO dgInqModiVO) {
		this.dgInqModiVO = dgInqModiVO;
	}
	public DgInqModiVO[] getDgInqModiVOs() {
		DgInqModiVO[] rtnVOs = null;
		if (this.dgInqModiVOs != null) {
			rtnVOs = Arrays.copyOf(dgInqModiVOs, dgInqModiVOs.length);
		}
		return rtnVOs;
	}
	public void setDgInqModiVOs(DgInqModiVO[] dgInqModiVOs) {
		if (dgInqModiVOs != null) {
			DgInqModiVO[] tmpVOs = Arrays.copyOf(dgInqModiVOs, dgInqModiVOs.length);
			this.dgInqModiVOs = tmpVOs;
		}
	}
	
	



}

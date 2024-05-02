/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTes2006Event.java
*@FileTitle : Irregular Creation & Adjustment
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.10.14 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.guaranteemanage.irregularmanage.event;

import com.hanjin.apps.alps.esd.tes.guaranteemanage.guaranteemanage.vo.GuaranteeCommonVO;
import com.hanjin.apps.alps.esd.tes.guaranteemanage.guaranteemanage.vo.SearchUSGuaranteeCntrInfoVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TesGnteCntrListVO;
import com.hanjin.syscommon.common.table.TesGnteHdrVO;
import com.hanjin.syscommon.common.table.TesIrrHdrVO;


/**
 * ESD_TES_2006 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TES_2006HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author yOng hO lEE
 * @see ESD_TES_2006HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTes2006Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	
	private TesGnteHdrVO					tesGnteHdrVO				= null;
	private TesIrrHdrVO						tesIrrHdrVO					= null;
	private TesGnteCntrListVO				tesGnteCntrListVO 			= null;
	private GuaranteeCommonVO				guaranteeCommonVO			= null;
	private SearchUSGuaranteeCntrInfoVO		searchUSGuaranteeCntrInfoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TesGnteHdrVO[]					tesGnteHdrVOs					= null;
	private TesIrrHdrVO[] 					tesIrrHdrVOs					= null;
	private TesGnteCntrListVO[]				tesGnteCntrListVOs				= null;
	private GuaranteeCommonVO[]				guaranteeCommonVOs				= null;
	private SearchUSGuaranteeCntrInfoVO[]	searchUSGuaranteeCntrInfoVOs 	= null;

	public EsdTes2006Event(){}

	public TesGnteHdrVO getTesGnteHdrVO() {
		return tesGnteHdrVO;
	}

	public void setTesGnteHdrVO(TesGnteHdrVO tesGnteHdrVO) {
		this.tesGnteHdrVO = tesGnteHdrVO;
	}

	public TesIrrHdrVO getTesIrrHdrVO() {
		return tesIrrHdrVO;
	}

	public void setTesIrrHdrVO(TesIrrHdrVO tesIrrHdrVO) {
		this.tesIrrHdrVO = tesIrrHdrVO;
	}

	public TesGnteCntrListVO getTesGnteCntrListVO() {
		return tesGnteCntrListVO;
	}

	public void setTesGnteCntrListVO(TesGnteCntrListVO tesGnteCntrListVO) {
		this.tesGnteCntrListVO = tesGnteCntrListVO;
	}

	public GuaranteeCommonVO getGuaranteeCommonVO() {
		return guaranteeCommonVO;
	}

	public void setGuaranteeCommonVO(GuaranteeCommonVO guaranteeCommonVO) {
		this.guaranteeCommonVO = guaranteeCommonVO;
	}

	public SearchUSGuaranteeCntrInfoVO getSearchUSGuaranteeCntrInfoVO() {
		return searchUSGuaranteeCntrInfoVO;
	}

	public void setSearchUSGuaranteeCntrInfoVO(
			SearchUSGuaranteeCntrInfoVO searchUSGuaranteeCntrInfoVO) {
		this.searchUSGuaranteeCntrInfoVO = searchUSGuaranteeCntrInfoVO;
	}

	public TesGnteHdrVO[] getTesGnteHdrVOs() {
		return tesGnteHdrVOs;
	}

	public void setTesGnteHdrVOs(TesGnteHdrVO[] tesGnteHdrVOs) {
		this.tesGnteHdrVOs = tesGnteHdrVOs;
	}

	public TesIrrHdrVO[] getTesIrrHdrVOs() {
		return tesIrrHdrVOs;
	}

	public void setTesIrrHdrVOs(TesIrrHdrVO[] tesIrrHdrVOs) {
		this.tesIrrHdrVOs = tesIrrHdrVOs;
	}

	public TesGnteCntrListVO[] getTesGnteCntrListVOs() {
		return tesGnteCntrListVOs;
	}

	public void setTesGnteCntrListVOs(TesGnteCntrListVO[] tesGnteCntrListVOs) {
		this.tesGnteCntrListVOs = tesGnteCntrListVOs;
	}

	public GuaranteeCommonVO[] getGuaranteeCommonVOs() {
		return guaranteeCommonVOs;
	}

	public void setGuaranteeCommonVOs(GuaranteeCommonVO[] guaranteeCommonVOs) {
		this.guaranteeCommonVOs = guaranteeCommonVOs;
	}

	public SearchUSGuaranteeCntrInfoVO[] getSearchUSGuaranteeCntrInfoVOs() {
		return searchUSGuaranteeCntrInfoVOs;
	}

	public void setSearchUSGuaranteeCntrInfoVOs(
			SearchUSGuaranteeCntrInfoVO[] searchUSGuaranteeCntrInfoVOs) {
		this.searchUSGuaranteeCntrInfoVOs = searchUSGuaranteeCntrInfoVOs;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}



}
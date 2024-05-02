/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTes2001Event.java
*@FileTitle : Guarantee Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.10.13 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.guaranteemanage.guaranteemanage.event;

import com.hanjin.apps.alps.esd.tes.guaranteemanage.guaranteemanage.vo.SearchUSGuaranteeCntrInfoVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TesGnteCntrListVO;
import com.hanjin.syscommon.common.table.TesGnteHdrVO;


/**
 * ESD_TES_2001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TES_2001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author yOng hO lEE
 * @see ESD_TES_2001HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTes2001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TesGnteHdrVO					tesGnteHdrVO				= null;
	private TesGnteCntrListVO				tesGnteCntrListVO 			= null;
	private SearchUSGuaranteeCntrInfoVO		searchUSGuaranteeCntrInfoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TesGnteHdrVO[] 					tesGnteHdrVOs					= null;
	private TesGnteCntrListVO[]				tesGnteCntrListVOs				= null;
	private SearchUSGuaranteeCntrInfoVO[]	searchUSGuaranteeCntrInfoVOs 	= null;

	public EsdTes2001Event(){}

	public TesGnteHdrVO getTesGnteHdrVO() {
		return tesGnteHdrVO;
	}

	public void setTesGnteHdrVO(TesGnteHdrVO tesGnteHdrVO) {
		this.tesGnteHdrVO = tesGnteHdrVO;
	}

	public TesGnteCntrListVO getTesGnteCntrListVO() {
		return tesGnteCntrListVO;
	}

	public void setTesGnteCntrListVO(TesGnteCntrListVO tesGnteCntrListVO) {
		this.tesGnteCntrListVO = tesGnteCntrListVO;
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

	public TesGnteCntrListVO[] getTesGnteCntrListVOs() {
		return tesGnteCntrListVOs;
	}

	public void setTesGnteCntrListVOs(TesGnteCntrListVO[] tesGnteCntrListVOs) {
		this.tesGnteCntrListVOs = tesGnteCntrListVOs;
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
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
package com.clt.apps.opus.esd.tes.guaranteemanage.irregularmanage.event;

import com.clt.apps.opus.esd.tes.guaranteemanage.guaranteemanage.vo.GuaranteeCommonVO;
import com.clt.apps.opus.esd.tes.guaranteemanage.guaranteemanage.vo.SearchUSGuaranteeCntrInfoVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.TesGnteCntrListVO;
import com.clt.syscommon.common.table.TesGnteHdrVO;
import com.clt.syscommon.common.table.TesIrrHdrVO;


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
		TesGnteHdrVO[] rtnVOs = null;
		if (this.tesGnteHdrVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(tesGnteHdrVOs, tesGnteHdrVOs.length);
		}
		return rtnVOs;
	}

	public void setTesGnteHdrVOs(TesGnteHdrVO[] tesGnteHdrVOs){
		if(tesGnteHdrVOs != null){
			TesGnteHdrVO[] tmpVOs = java.util.Arrays.copyOf(tesGnteHdrVOs, tesGnteHdrVOs.length);
			this.tesGnteHdrVOs = tmpVOs;
		}
	}

	public TesIrrHdrVO[] getTesIrrHdrVOs() {
		TesIrrHdrVO[] rtnVOs = null;
		if (this.tesIrrHdrVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(tesIrrHdrVOs, tesIrrHdrVOs.length);
		}
		return rtnVOs;
	}

	public void setTesIrrHdrVOs(TesIrrHdrVO[] tesIrrHdrVOs){
		if(tesIrrHdrVOs != null){
			TesIrrHdrVO[] tmpVOs = java.util.Arrays.copyOf(tesIrrHdrVOs, tesIrrHdrVOs.length);
			this.tesIrrHdrVOs = tmpVOs;
		}
	}

	public TesGnteCntrListVO[] getTesGnteCntrListVOs() {
		TesGnteCntrListVO[] rtnVOs = null;
		if (this.tesGnteCntrListVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(tesGnteCntrListVOs, tesGnteCntrListVOs.length);
		}
		return rtnVOs;
	}

	public void setTesGnteCntrListVOs(TesGnteCntrListVO[] tesGnteCntrListVOs){
		if(tesGnteCntrListVOs != null){
			TesGnteCntrListVO[] tmpVOs = java.util.Arrays.copyOf(tesGnteCntrListVOs, tesGnteCntrListVOs.length);
			this.tesGnteCntrListVOs = tmpVOs;
		}
	}

	public GuaranteeCommonVO[] getGuaranteeCommonVOs() {
		GuaranteeCommonVO[] rtnVOs = null;
		if (this.guaranteeCommonVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(guaranteeCommonVOs, guaranteeCommonVOs.length);
		}
		return rtnVOs;
	}

	public void setGuaranteeCommonVOs(GuaranteeCommonVO[] guaranteeCommonVOs){
		if(guaranteeCommonVOs != null){
			GuaranteeCommonVO[] tmpVOs = java.util.Arrays.copyOf(guaranteeCommonVOs, guaranteeCommonVOs.length);
			this.guaranteeCommonVOs = tmpVOs;
		}
	}

	public SearchUSGuaranteeCntrInfoVO[] getSearchUSGuaranteeCntrInfoVOs() {
		SearchUSGuaranteeCntrInfoVO[] rtnVOs = null;
		if (this.searchUSGuaranteeCntrInfoVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(searchUSGuaranteeCntrInfoVOs, searchUSGuaranteeCntrInfoVOs.length);
		}
		return rtnVOs;
	}

	public void setSearchUSGuaranteeCntrInfoVOs(SearchUSGuaranteeCntrInfoVO[] searchUSGuaranteeCntrInfoVOs){
		if(searchUSGuaranteeCntrInfoVOs != null){
			SearchUSGuaranteeCntrInfoVO[] tmpVOs = java.util.Arrays.copyOf(searchUSGuaranteeCntrInfoVOs, searchUSGuaranteeCntrInfoVOs.length);
			this.searchUSGuaranteeCntrInfoVOs = tmpVOs;
		}
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}



}
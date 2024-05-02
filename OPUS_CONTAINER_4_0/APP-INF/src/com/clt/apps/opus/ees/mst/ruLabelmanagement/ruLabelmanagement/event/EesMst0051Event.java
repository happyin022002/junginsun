/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EesMst0050Event.java
 *@FileTitle :  Reefer Unit Info Inquiry and Update
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.08.07
 *@LastModifier : 박영진
 *@LastVersion : 1.0
 * 2014.08.07 박영진
=========================================================*/
package com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.event;

import java.util.List;

import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.vo.CustomMnrDatVrfyVO;
import com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.vo.RuLabelListVO;
import com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.vo.RuLabelInfoVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.MstCntrPreStsVO;

/**
 * EES_MST_0050 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EES_MST_0050HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Park Young Jin
 * @see EES_MST_0051HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMst0051Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private RuLabelInfoVO ruLabelInfoVO = null;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private RuLabelListVO ruLabelListVO = null;

	/** 검색결과 **/
	private RuLabelListVO[] ruLabelListVOs = null;

	/** 검색결과 **/
	private RuLabelInfoVO[] ruLabelInfoVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomMnrDatVrfyVO[] customMnrDatVrfyVOs = null;
	
	// 조회 결과값을 받기위한 테이블 VO리스트
	private List<RuLabelListVO> ruLabelExcelListVO = null;

	/**
	 * @return the ruLabelInfoVO
	 */
	public RuLabelInfoVO getRuLabelInfoVO() {
		return ruLabelInfoVO;
	}

	/**
	 * @return the ruLabelInfoVO
	 */
	public RuLabelListVO getRuLabelListVO() {
		return ruLabelListVO;
	}

	/**
	 * @param ruLabelInfoVO
	 *            the ruLabelInfoVO to set
	 */
	public void setRuLabelListVO(RuLabelListVO ruLabelListVO) {
		this.ruLabelListVO = ruLabelListVO;
	}

	/**
	 * @param ruLabelInfoVO
	 *            the ruLabelInfoVO to set
	 */
	public void setRuLabelInfoVO(RuLabelInfoVO ruLabelInfoVO) {
		this.ruLabelInfoVO = ruLabelInfoVO;
	}

	/**
	 * @return the ruLabelListVOs
	 */
	public RuLabelListVO[] getRuLabelListVOs() {
		RuLabelListVO[] tmpVOs = null;
		if (this.ruLabelListVOs != null) {
			tmpVOs = new RuLabelListVO[ruLabelListVOs.length];
			System.arraycopy(ruLabelListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;

	}

	/**
	 * @param ruLabelListVOs
	 *            the ruLabelListVOs to set
	 */
	public void setRuLabelListVOs(RuLabelListVO[] ruLabelListVOs) {
		if (ruLabelListVOs != null) {
			RuLabelListVO[] tmpVOs = new RuLabelListVO[ruLabelListVOs.length];
			System.arraycopy(ruLabelListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.ruLabelListVOs = tmpVOs;
		}

	}

	/**
	 * @param ruLabelListVOs
	 *            the ruLabelListVOs to set
	 */
	public void setRuLabelInfoVOs(RuLabelInfoVO[] ruLabelInfoVOs) {
		if (ruLabelInfoVOs != null) {
			RuLabelInfoVO[] tmpVOs = new RuLabelInfoVO[ruLabelInfoVOs.length];
			System.arraycopy(ruLabelInfoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.ruLabelInfoVOs = tmpVOs;
		}

	}
	
	public CustomMnrDatVrfyVO[] getCustomMnrDatVrfyVOs() {
		CustomMnrDatVrfyVO[] rtnVOs = null;
		if (this.customMnrDatVrfyVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(customMnrDatVrfyVOs, customMnrDatVrfyVOs.length);
		}
		return rtnVOs;
	}
	
	public void setCustomMnrDatVrfyVOs(CustomMnrDatVrfyVO[] customMnrDatVrfyVOs){
		if(customMnrDatVrfyVOs != null){
			CustomMnrDatVrfyVO[] tmpVOs = java.util.Arrays.copyOf(customMnrDatVrfyVOs, customMnrDatVrfyVOs.length);
			this.customMnrDatVrfyVOs = tmpVOs;
		}
	}

	
	public List<RuLabelListVO> getRuLabelExcelListVO() {
		return ruLabelExcelListVO;
	}

	public void setRuLabelExcelListVO(List<RuLabelListVO> ruLabelExcelListVO) {
		this.ruLabelExcelListVO = ruLabelExcelListVO;
	}

	
}
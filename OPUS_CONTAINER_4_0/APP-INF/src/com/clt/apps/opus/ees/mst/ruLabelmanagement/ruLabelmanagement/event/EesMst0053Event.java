/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EesMst0053Event.java
 *@FileTitle :  RU Label Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.02.17
 *@LastModifier : 
 *@LastVersion : 
 * 2015.02.17
=========================================================*/
package com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.event;

import com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.vo.RuLabelListVO;
import com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.vo.RuLabelInfoVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EES_MST_0053 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EES_MST_0053HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author
 * @see EES_MST_0053HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMst0053Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private RuLabelInfoVO ruLabelInfoVO = null;

	private RuLabelListVO ruLabelListVO = null;

	/** 검색결과 **/
	private RuLabelListVO[] ruLabelListVOs = null;

	/** 검색결과 **/
	private RuLabelInfoVO[] ruLabelInfoVOs = null;

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
	public void setRuLabelInfoVO(RuLabelInfoVO ruLabelInfoVO) {
		this.ruLabelInfoVO = ruLabelInfoVO;
	}

	/**
	 * @param ruLabelInfoVO
	 *            the ruLabelInfoVO to set
	 */
	public void setRuLabelListVO(RuLabelListVO ruLabelListVO) {
		this.ruLabelListVO = ruLabelListVO;
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

}
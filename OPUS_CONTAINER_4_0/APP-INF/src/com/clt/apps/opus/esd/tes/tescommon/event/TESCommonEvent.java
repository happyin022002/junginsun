/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : TESCommonEvent.java
 *@FileTitle : TES Common 관리
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016-03-08 KHS
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.tes.tescommon.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.tes.tescommon.vo.TesCommonVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * TESCommon 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - TESCommonHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author byungheeyoo
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class TESCommonEvent extends EventSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * TESCommonEvent 생성자 함수
	 */
	public TESCommonEvent() {

	}

	/** Table Value Object 조회 조건 및 단건 처리 */
	private TesCommonVO tesCommonVO = null;

	/** Table Value Object Multi Data 처리 */
	private TesCommonVO[] tesCommonVOs = null;

	public void setTesCommonVO(TesCommonVO tesCommonVO) {
		this.tesCommonVO = tesCommonVO;
	}

	public void setTesCommonVOS(TesCommonVO[] tesCommonVOs) {
		if (tesCommonVOs != null) {
			TesCommonVO[] tempVo = Arrays.copyOf(tesCommonVOs, tesCommonVOs.length);
			this.tesCommonVOs = tempVo;
		}
	}

	public TesCommonVO getTesCommonVO() {
		return tesCommonVO;
	}

	public TesCommonVO[] getTesCommonVOS() {
		TesCommonVO[] tempVOs = null;

		if (this.tesCommonVOs != null) {
			tempVOs = Arrays.copyOf(this.tesCommonVOs, this.tesCommonVOs.length);
		}
		return tempVOs;
	}
}

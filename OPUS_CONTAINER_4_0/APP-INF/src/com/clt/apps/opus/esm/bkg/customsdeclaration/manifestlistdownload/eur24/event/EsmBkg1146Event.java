/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg1146Event.java
 *@FileTitle : EsmBkg1146Event
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.05.24
 *@LastModifier : 김보배
 *@LastVersion : 1.0
 * 2012.05.24 김보배
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.EurCrnRcvMsgVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_1146 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_1146HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author BOBAE KIM
 * @see ESM_BKG_1146HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg1146Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	public EsmBkg1146Event() {
	}

	private EurCrnRcvMsgVO eurCrnRcvMsgVO = null;
	private EurCrnRcvMsgVO[] eurCrnRcvMsgVOs = null;

	/**
	 * @return the eurCrnRcvMsgVO
	 */
	public EurCrnRcvMsgVO getEurCrnRcvMsgVO() {
		return eurCrnRcvMsgVO;
	}

	/**
	 * @param eurCrnRcvMsgVO
	 *            the eurCrnRcvMsgVO to set
	 */
	public void setEurCrnRcvMsgVO(EurCrnRcvMsgVO eurCrnRcvMsgVO) {
		this.eurCrnRcvMsgVO = eurCrnRcvMsgVO;
	}

	public EurCrnRcvMsgVO[] getEurCrnRcvMsgVOs() {
		EurCrnRcvMsgVO[] rtnVOs = null;
		if (eurCrnRcvMsgVOs != null)
			rtnVOs = Arrays.copyOf(eurCrnRcvMsgVOs, eurCrnRcvMsgVOs.length);
		return rtnVOs;
	}

	public void setEurCrnRcvMsgVOs(EurCrnRcvMsgVO[] eurCrnRcvMsgVOs) {
		if (eurCrnRcvMsgVOs != null)
			this.eurCrnRcvMsgVOs = Arrays.copyOf(eurCrnRcvMsgVOs, eurCrnRcvMsgVOs.length);
	}
}
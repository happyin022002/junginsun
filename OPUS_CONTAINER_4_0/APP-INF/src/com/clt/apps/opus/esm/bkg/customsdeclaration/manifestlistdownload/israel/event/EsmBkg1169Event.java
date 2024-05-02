/*=========================================================
 *Copyright(c) 2013 CyberLogitec
 *@FileName : EsmBkg1169Event.java
 *@FileTitle : ESM_BKG_1169
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.08.30
 *@LastModifier : 김보배
 *@LastVersion : 1.0
 * 2013.08.30 김보배
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.israel.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.israel.vo.IsraelRcvHisCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.israel.vo.IsraelSearchRcvHisVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_1169 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_1169HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author BOBAE KIM
 * @see ESM_BKG_1169HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg1169Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private IsraelRcvHisCondVO israelRcvHisCondVO = null;
	private IsraelSearchRcvHisVO israelSearchRcvHisVO = null;

	private IsraelRcvHisCondVO[] israelRcvHisCondVOs = null;
	private IsraelSearchRcvHisVO[] israelSearchRcvHisVOs = null;

	public EsmBkg1169Event() {
	}

	public IsraelRcvHisCondVO getIsraelRcvHisCondVO() {
		return israelRcvHisCondVO;
	}

	public void setIsraelRcvHisCondVO(IsraelRcvHisCondVO israelRcvHisCondVO) {
		this.israelRcvHisCondVO = israelRcvHisCondVO;
	}

	public IsraelSearchRcvHisVO getIsraelSearchRcvHisVO() {
		return israelSearchRcvHisVO;
	}

	public void setIsraelSearchRcvHisVO(IsraelSearchRcvHisVO israelSearchRcvHisVO) {
		this.israelSearchRcvHisVO = israelSearchRcvHisVO;
	}

	public IsraelRcvHisCondVO[] getIsraelRcvHisCondVOs() {
		IsraelRcvHisCondVO[] rtnVOs = null;
		if (israelRcvHisCondVOs != null)
			rtnVOs = Arrays.copyOf(israelRcvHisCondVOs, israelRcvHisCondVOs.length);
		return rtnVOs;
	}

	public void setIsraelRcvHisCondVOs(IsraelRcvHisCondVO[] israelRcvHisCondVOs) {
		if (israelRcvHisCondVOs != null)
			this.israelRcvHisCondVOs = Arrays.copyOf(israelRcvHisCondVOs, israelRcvHisCondVOs.length);
	}

	public IsraelSearchRcvHisVO[] getIsraelSearchRcvHisVOs() {
		IsraelSearchRcvHisVO[] rtnVOs = null;
		if (israelSearchRcvHisVOs != null)
			rtnVOs = Arrays.copyOf(israelSearchRcvHisVOs, israelSearchRcvHisVOs.length);
		return rtnVOs;
	}

	public void setIsraelSearchRcvHisVOs(IsraelSearchRcvHisVO[] israelSearchRcvHisVOs) {
		if (israelSearchRcvHisVOs != null)
			this.israelSearchRcvHisVOs = Arrays.copyOf(israelSearchRcvHisVOs, israelSearchRcvHisVOs.length);
	}
}
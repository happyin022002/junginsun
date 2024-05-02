/*=========================================================
 *Copyright(c) SMLines. All Rights Reserved.
 *@FileName : EsmBkgN006Event.java
 *@FileTitle : EsmBkgN006Event
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion :
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.event;
 
import java.util.Arrays;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsRcvHisListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsRcvHisVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_N006 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_N006HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see ESM_BKG_N006HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkgN006Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** 조회조건 */
	private CstmsRcvHisListCondVO cstmsRcvHisListCondVO = null;
	/** Receive History Log 결과 */
	private CstmsRcvHisVO cstmsRcvHisVO = null;
	/** Receive History Log 결과리스트 */
	private CstmsRcvHisVO[] cstmsRcvHisVOs = null;

	public EsmBkgN006Event() {}

	public void setCstmsRcvHisListCondVO(CstmsRcvHisListCondVO cstmsRcvHisListCondVO) {
		this.cstmsRcvHisListCondVO = cstmsRcvHisListCondVO;
	}

	public void setCstmsRcvHisVO(CstmsRcvHisVO cstmsRcvHisVO) {
		this.cstmsRcvHisVO = cstmsRcvHisVO;
	}

	public void setCstmsRcvHisVOs(CstmsRcvHisVO[] cstmsRcvHisVOs) {
		if (cstmsRcvHisVOs != null)
			this.cstmsRcvHisVOs = Arrays.copyOf(cstmsRcvHisVOs, cstmsRcvHisVOs.length);
	}

	public CstmsRcvHisListCondVO getCstmsRcvHisListCondVO() {
		return cstmsRcvHisListCondVO;
	}

	public CstmsRcvHisVO getCstmsRcvHisVO() {
		return cstmsRcvHisVO;
	}

	public CstmsRcvHisVO[] getCstmsRcvHisVOs() {
		CstmsRcvHisVO[] rtnVOs = null;
		if (cstmsRcvHisVOs != null)
			rtnVOs = Arrays.copyOf(cstmsRcvHisVOs, cstmsRcvHisVOs.length);
		return rtnVOs;
	}
}
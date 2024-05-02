/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EesMst0021Event.java
 *@FileTitle :  Container Specification Creation &amp; Update
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.11
 *@LastModifier : 김석준
 *@LastVersion : 1.0
 * 2009.05.11 김석준
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.event;

import com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.vo.MstCntrSpecVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EES_MST_0021 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EES_MST_0021HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Suk Jun Kim
 * @see EES_MST_0021HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesMst0021Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private MstCntrSpecVO mstCntrSpecVO = null;

	/** Table Value Object Multi Data 처리 */
	private MstCntrSpecVO[] mstCntrSpecVOs = null;

	public EesMst0021Event() {
	}

	public void setMstCntrSpecVO(MstCntrSpecVO mstCntrSpecVO) {
		this.mstCntrSpecVO = mstCntrSpecVO;
	}

	public void setMstCntrSpecVOS(MstCntrSpecVO[] mstCntrSpecVOs) {
		if (mstCntrSpecVOs != null) {
			MstCntrSpecVO[] tmpVOs = new MstCntrSpecVO[mstCntrSpecVOs.length];
			System.arraycopy(mstCntrSpecVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mstCntrSpecVOs = tmpVOs;
		}

	}

	public MstCntrSpecVO getMstCntrSpecVO() {
		return mstCntrSpecVO;
	}

	public MstCntrSpecVO[] getMstCntrSpecVOS() {
		MstCntrSpecVO[] tmpVOs = null;
		if (this.mstCntrSpecVOs != null) {
			tmpVOs = new MstCntrSpecVO[mstCntrSpecVOs.length];
			System.arraycopy(mstCntrSpecVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}
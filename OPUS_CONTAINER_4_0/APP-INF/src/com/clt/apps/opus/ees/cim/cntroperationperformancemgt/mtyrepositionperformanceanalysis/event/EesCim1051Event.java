/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EesCim1051Event.java
 *@FileTitle : MTY CNTR PFMC by Movement
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.02
 *@LastModifier : 박광석
 *@LastVersion : 1.0
 * 2009.06.02 박광석
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.event;

import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo.MTYCNTRPERFSearchOptionVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EES_CIM_1051 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EES_CIM_1051HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Prak Kwang Seok
 * @see EES_CIM_1051HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCim1051Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private MTYCNTRPERFSearchOptionVO mTYCNTRPERFSearchOptionVO = null;

	/** Table Value Object Multi Data 처리 */
	private MTYCNTRPERFSearchOptionVO[] mTYCNTRPERFSearchOptionVOs = null;

	public EesCim1051Event() {
	}

	public void setMTYCNTRPERFSearchOptionVO(
			MTYCNTRPERFSearchOptionVO mTYCNTRPERFSearchOptionVO) {
		this.mTYCNTRPERFSearchOptionVO = mTYCNTRPERFSearchOptionVO;
	}

	public void setMTYCNTRPERFSearchOptionVOS(
			MTYCNTRPERFSearchOptionVO[] mTYCNTRPERFSearchOptionVOs) {
		if (mTYCNTRPERFSearchOptionVOs != null) {
			MTYCNTRPERFSearchOptionVO[] tmpVOs = new MTYCNTRPERFSearchOptionVO[mTYCNTRPERFSearchOptionVOs.length];
			System.arraycopy(mTYCNTRPERFSearchOptionVOs, 0, tmpVOs, 0,
					tmpVOs.length);
			this.mTYCNTRPERFSearchOptionVOs = tmpVOs;
		}
	}

	public MTYCNTRPERFSearchOptionVO getMTYCNTRPERFSearchOptionVO() {
		return mTYCNTRPERFSearchOptionVO;
	}

	public MTYCNTRPERFSearchOptionVO[] getMTYCNTRPERFSearchOptionVOS() {
		MTYCNTRPERFSearchOptionVO[] tmpVOs = null;
		if (this.mTYCNTRPERFSearchOptionVOs != null) {
			tmpVOs = new MTYCNTRPERFSearchOptionVO[mTYCNTRPERFSearchOptionVOs.length];
			System.arraycopy(mTYCNTRPERFSearchOptionVOs, 0, tmpVOs, 0,
					tmpVOs.length);
		}
		return tmpVOs;
	}

}
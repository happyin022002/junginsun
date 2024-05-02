/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0052Event.java
 *@FileTitle : Integrated Customer Data Management
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.20
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2009.05.20 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event;

import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.MrnRtnYdVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * esm_bkg_0052 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0052HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author
 * @see ESM_BKG_0052HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0052Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private MrnRtnYdVO mrnRtnYdVO = null;

	/** Table Value Object Multi Data 처리 */
	private MrnRtnYdVO[] mrnRtnYdVOs = null;

	public EsmBkg0052Event() {
	}

	public MrnRtnYdVO getMrnRtnYdVO() {
		return mrnRtnYdVO;
	}

	public void setMrnRtnYdVO(MrnRtnYdVO mrnRtnYdVO) {
		this.mrnRtnYdVO = mrnRtnYdVO;
	}

//	public MrnRtnYdVO[] getMrnRtnYdVOs() {
//		return mrnRtnYdVOs;
//	}
	
	//2015.04.14 Secure Coding 적용[CWE-496]
	public MrnRtnYdVO[] getMrnRtnYdVOs() {
		MrnRtnYdVO[] tmpVOs = null;
		if (this.mrnRtnYdVOs != null) {
			tmpVOs = new MrnRtnYdVO[mrnRtnYdVOs.length];
			System.arraycopy(mrnRtnYdVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	} 

//	public void setMrnRtnYdVOs(MrnRtnYdVO[] mrnRtnYdVOs) {
//		this.mrnRtnYdVOs = mrnRtnYdVOs;
//	}

	//2015.04.14 Secure Coding 적용[CWE-496]
	public void setMrnRtnYdVOs(MrnRtnYdVO[] mrnRtnYdVOs) {
		if (mrnRtnYdVOs != null) {
			MrnRtnYdVO[] tmpVOs = new MrnRtnYdVO[mrnRtnYdVOs.length];
			System.arraycopy(mrnRtnYdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mrnRtnYdVOs = tmpVOs;
		}		
	} 
	
}
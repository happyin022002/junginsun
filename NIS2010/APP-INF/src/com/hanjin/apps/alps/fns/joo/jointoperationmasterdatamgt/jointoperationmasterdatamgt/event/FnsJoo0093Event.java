/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : FnsJoo0093Event.java
*@FileTitle : Basic Information for Loading Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.23
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.12.23 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.event;

import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.BsaCarrieHistoryVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_JOO_0093 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0093HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Hee Dong
 * @see FNS_JOO_0093HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0093Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BsaCarrieHistoryVO bsaCarrieHistoryVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BsaCarrieHistoryVO[] bsaCarrieHistoryVOs = null;

	public FnsJoo0093Event(){}

	public BsaCarrieHistoryVO getBsaCarrieHistoryVO() {
		return bsaCarrieHistoryVO;
	}

	public void setBsaCarrieHistoryVO(BsaCarrieHistoryVO bsaCarrieHistoryVO) {
		this.bsaCarrieHistoryVO = bsaCarrieHistoryVO;
	}

	public BsaCarrieHistoryVO[] getBsaCarrieHistoryVOs() {
		BsaCarrieHistoryVO[] rtnVOs = null;
		if (this.bsaCarrieHistoryVOs != null) {
			rtnVOs = new BsaCarrieHistoryVO[bsaCarrieHistoryVOs.length];
			System.arraycopy(bsaCarrieHistoryVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}

	public void setBsaCarrieHistoryVOs(BsaCarrieHistoryVO[] bsaCarrieHistoryVOs) {
		if (bsaCarrieHistoryVOs != null) {
			BsaCarrieHistoryVO[] tmpVOs = new BsaCarrieHistoryVO[bsaCarrieHistoryVOs.length];
			System.arraycopy(bsaCarrieHistoryVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bsaCarrieHistoryVOs = tmpVOs;
		}		
	}
}
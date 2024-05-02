/*=========================================================
*Copyright(c) 2012 CyberLogitec 
*@FileName : FnsJoo0086Event.java
*@FileTitle : Basic Information for Loading Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.15
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.01.15 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.event;

import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.BzcAgmtCrrVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_JOO_0086 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0086HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author young oh Kim
 * @see FNS_JOO_0086HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0086Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BzcAgmtCrrVO bzcAgmtCrrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BzcAgmtCrrVO[] bzcAgmtCrrVOs = null;

	public FnsJoo0086Event(){}

	public BzcAgmtCrrVO getBzcAgmtCrrVO() {
		return bzcAgmtCrrVO;
	}

	public void setBzcAgmtCrrVO(BzcAgmtCrrVO bzcAgmtCrrVO) {
		this.bzcAgmtCrrVO = bzcAgmtCrrVO;
	}

	public BzcAgmtCrrVO[] getBzcAgmtCrrVOs() {
		BzcAgmtCrrVO[] rtnVOs = null;
		if (this.bzcAgmtCrrVOs != null) {
			rtnVOs = new BzcAgmtCrrVO[bzcAgmtCrrVOs.length];
			System.arraycopy(bzcAgmtCrrVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}

	public void setBzcAgmtCrrVOs(BzcAgmtCrrVO[] bzcAgmtCrrVOs) {
		if (bzcAgmtCrrVOs != null) {
			BzcAgmtCrrVO[] tmpVOs = new BzcAgmtCrrVO[bzcAgmtCrrVOs.length];
			System.arraycopy(bzcAgmtCrrVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bzcAgmtCrrVOs = tmpVOs;
		}		
	}
}
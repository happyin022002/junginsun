/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0028Event.java
*@FileTitle : Settlement Item & Account Code List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.04.24 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.STLItemAcctVO;


/**
 * UI_JOO_0028 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_JOO_0028HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Hee Dong
 * @see FNS_JOO_0028HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsJoo0028Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private STLItemAcctVO sTLItemAcctVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private STLItemAcctVO[] sTLItemAcctVOs = null;

	public FnsJoo0028Event(){}
	
	public void setSTLItemAcctVO(STLItemAcctVO sTLItemAcctVO){
		this. sTLItemAcctVO = sTLItemAcctVO;
	}

	public void setSTLItemAcctVOS(STLItemAcctVO[] sTLItemAcctVOs){
		if (sTLItemAcctVOs != null) {
			STLItemAcctVO[] tmpVOs = new STLItemAcctVO[sTLItemAcctVOs.length];
			System.arraycopy(sTLItemAcctVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.sTLItemAcctVOs = tmpVOs;
		}				
	}

	public STLItemAcctVO getSTLItemAcctVO(){
		return sTLItemAcctVO;
	}

	public STLItemAcctVO[] getSTLItemAcctVOS(){
		STLItemAcctVO[] rtnVOs = null;
		if (this.sTLItemAcctVOs != null) {
			rtnVOs = new STLItemAcctVO[sTLItemAcctVOs.length];
			System.arraycopy(sTLItemAcctVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}
}
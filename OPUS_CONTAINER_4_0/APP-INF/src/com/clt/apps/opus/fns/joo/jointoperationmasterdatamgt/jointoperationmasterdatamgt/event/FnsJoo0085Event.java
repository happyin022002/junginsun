/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : FnsJoo0085Event.java
*@FileTitle : Basic Information for Loading Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.23
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.12.23 박희동
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.event;

import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.CusBzcAgmtVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * FNS_JOO_0085 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0085HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Hee Dong
 * @see FNS_JOO_0085HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0085Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CusBzcAgmtVO cusBzcAgmtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CusBzcAgmtVO[] cusBzcAgmtVOs = null;

	public FnsJoo0085Event(){}
	
	public void setCusBzcAgmtVO(CusBzcAgmtVO cusBzcAgmtVO){
		this. cusBzcAgmtVO = cusBzcAgmtVO;
	}

	public void setCusBzcAgmtVOS(CusBzcAgmtVO[] cusBzcAgmtVOs){
		if (cusBzcAgmtVOs != null) {
			CusBzcAgmtVO[] tmpVOs = new CusBzcAgmtVO[cusBzcAgmtVOs.length];
			System.arraycopy(cusBzcAgmtVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cusBzcAgmtVOs = tmpVOs;
		}
	}

	public CusBzcAgmtVO getCusBzcAgmtVO(){
		return cusBzcAgmtVO;
	}

	public CusBzcAgmtVO[] getCusBzcAgmtVOS(){
		CusBzcAgmtVO[] tmpVOs = null;
		if (this.cusBzcAgmtVOs != null) {
			tmpVOs = new CusBzcAgmtVO[cusBzcAgmtVOs.length];
			System.arraycopy(cusBzcAgmtVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}
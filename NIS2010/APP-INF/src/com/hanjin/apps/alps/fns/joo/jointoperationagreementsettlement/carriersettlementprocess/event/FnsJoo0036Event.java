/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0036Event.java
*@FileTitle : Summary of Monthly Clearance Status by Carrier
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.03
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.06.23 함대성
* 1.0 Creation
* 
* History
* 2010.11.03 CHM-201006730-01 진마리아  Summary of Monthly Clearance Status by Carrier 기능에  Due Date,  Remark 컬럼 추가
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.McsStatusVO;


/**
 * FNS_JOO_0036 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0036HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HAM DAE SUNG
 * @see FNS_JOO_0036HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0036Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private McsStatusVO mcsStatusVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private McsStatusVO[] mcsStatusVOs = null;

	public FnsJoo0036Event(){}
	
	public void setMcsStatusVO(McsStatusVO mcsStatusVO){
		this. mcsStatusVO = mcsStatusVO;
	}

	public void setMcsStatusVOS(McsStatusVO[] mcsStatusVOs){
		if (mcsStatusVOs != null) {
			McsStatusVO[] tmpVOs = new McsStatusVO[mcsStatusVOs.length];
			System.arraycopy(mcsStatusVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mcsStatusVOs = tmpVOs;
		}		
	}

	public McsStatusVO getMcsStatusVO(){
		return mcsStatusVO;
	}

	public McsStatusVO[] getMcsStatusVOS(){
		McsStatusVO[] rtnVOs = null;
		if (this.mcsStatusVOs != null) {
			rtnVOs = new McsStatusVO[mcsStatusVOs.length];
			System.arraycopy(mcsStatusVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;						
	}
	
}
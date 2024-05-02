/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm2001Event.java
*@FileTitle : M.G Set Model Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 박의수
*@LastVersion : 1.0
* 2009.05.26 박의수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event;

import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSEqSpecINVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_2001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_2001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Eui-su Park
 * @see EES_CGM_2001HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm2001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MGSEqSpecINVO mGSEqSpecINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MGSEqSpecINVO[] mGSEqSpecINVOs = null;

	public EesCgm2001Event(){}
	
	public void setMGSEqSpecINVO(MGSEqSpecINVO mGSEqSpecINVO){
		this. mGSEqSpecINVO = mGSEqSpecINVO;
	}

	public void setMGSEqSpecINVOS(MGSEqSpecINVO[] mGSEqSpecINVOs){
		if(mGSEqSpecINVOs != null){
			MGSEqSpecINVO[] tmpVOs = java.util.Arrays.copyOf(mGSEqSpecINVOs, mGSEqSpecINVOs.length);
			this.mGSEqSpecINVOs = tmpVOs;
		}
	}

	public MGSEqSpecINVO getMGSEqSpecINVO(){
		return mGSEqSpecINVO;
	}

	public MGSEqSpecINVO[] getMGSEqSpecINVOS(){
		MGSEqSpecINVO[] rtnVOs = null;
		if (this.mGSEqSpecINVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(mGSEqSpecINVOs, mGSEqSpecINVOs.length);
		}
		return rtnVOs;
	}
}

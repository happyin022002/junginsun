/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm2083Event.java
*@FileTitle : M.G set Type Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 박의수
*@LastVersion : 1.0
* 2009.05.20 박의수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event;

import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSEqTpSzINVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_2083 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_2083HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Eui-su Park
 * @see EES_CGM_2083HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesCgm2083Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MGSEqTpSzINVO mGSEqTpSzINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MGSEqTpSzINVO[] mGSEqTpSzINVOs = null;

	public EesCgm2083Event(){}
	
	public void setMGSEqTpSzINVO(MGSEqTpSzINVO mGSEqTpSzINVO){
		this. mGSEqTpSzINVO = mGSEqTpSzINVO;
	}

	public void setMGSEqTpSzINVOS(MGSEqTpSzINVO[] mGSEqTpSzINVOs){
		if(mGSEqTpSzINVOs != null){
			MGSEqTpSzINVO[] tmpVOs = java.util.Arrays.copyOf(mGSEqTpSzINVOs, mGSEqTpSzINVOs.length);
			this.mGSEqTpSzINVOs = tmpVOs;
		}
	}

	public MGSEqTpSzINVO getMGSEqTpSzINVO(){
		return mGSEqTpSzINVO;
	}

	public MGSEqTpSzINVO[] getMGSEqTpSzINVOS(){
		MGSEqTpSzINVO[] rtnVOs = null;
		if (this.mGSEqTpSzINVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(mGSEqTpSzINVOs, mGSEqTpSzINVOs.length);
		}
		return rtnVOs;
	}
}

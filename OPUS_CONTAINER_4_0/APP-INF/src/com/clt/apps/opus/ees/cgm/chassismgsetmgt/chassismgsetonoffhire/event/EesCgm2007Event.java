/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm2007Event.java
*@FileTitle : M.G Set On-Hire Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.09
*@LastModifier : 박의수
*@LastVersion : 1.0
* 2009.07.09 박의수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event;

import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSOnHireINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSOnHireMGTVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_2007 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_2007HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Eui-su Park
 * @see EES_CGM_2007HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm2007Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MGSOnHireINVO mGSOnHireINVO = null;

	public MGSOnHireINVO getMGSOnHireINVO(){
		return mGSOnHireINVO;
	}

	public void setMGSOnHireINVO(MGSOnHireINVO OnHireINVO){
		mGSOnHireINVO = OnHireINVO;
	}
	
	/** Table Value Object Multi Data 처리 */
	private MGSOnHireMGTVO mGSOnHireMGTVO = null;

	private MGSOnHireMGTVO[] mGSOnHireMGTVOs = null;
	
	public EesCgm2007Event(){}
	
	public void setMGSOnHireMGTVO(MGSOnHireMGTVO mGSOnHireMGTVO){
		this. mGSOnHireMGTVO = mGSOnHireMGTVO;
	}

	public void setMGSOnHireMGTVOS(MGSOnHireMGTVO[] mGSOnHireMGTVOs){
		if(mGSOnHireMGTVOs != null){
			MGSOnHireMGTVO[] tmpVOs = java.util.Arrays.copyOf(mGSOnHireMGTVOs, mGSOnHireMGTVOs.length);
			this.mGSOnHireMGTVOs = tmpVOs;
		}
	}

	public MGSOnHireMGTVO getMGSOnHireMGTVO(){
		return mGSOnHireMGTVO;
	}

	public MGSOnHireMGTVO[] getMGSOnHireMGTVOS(){
		MGSOnHireMGTVO[] rtnVOs = null;
		if (this.mGSOnHireMGTVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(mGSOnHireMGTVOs, mGSOnHireMGTVOs.length);
		}
		return rtnVOs;
	}

}
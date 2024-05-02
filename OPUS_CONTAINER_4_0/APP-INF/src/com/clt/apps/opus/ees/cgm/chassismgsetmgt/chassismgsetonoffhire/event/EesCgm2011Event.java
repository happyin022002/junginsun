/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm2011Event.java
*@FileTitle : M.G Set Off-Hire Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.05.26 최민회
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event;

import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSOffHireINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSOffHireMGTVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_2011 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_2011HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI MIN HOI
 * @see EES_CGM_2011HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm2011Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	/** Table Value Object 조회 조건  */
	private MGSOffHireINVO mGSOffHireINVO = null;
	
	/**
	 * @return the mGSEOffHireINVO
	 */
	public MGSOffHireINVO getMGSOffHireINVO() {
		return mGSOffHireINVO;
	}

	/**
	 * @param eOffHireINVO the mGSEOffHireINVO to set
	 */
	public void setMGSOffHireINVO(MGSOffHireINVO OffHireINVO) {
		mGSOffHireINVO = OffHireINVO;
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private MGSOffHireMGTVO mGSOffHireMGTVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MGSOffHireMGTVO[] mGSOffHireMGTVOs = null;

	public EesCgm2011Event(){}
	
	public void setMGSOffHireMGTVO(MGSOffHireMGTVO mGSOffHireMGTVO){
		this. mGSOffHireMGTVO = mGSOffHireMGTVO;
	}

	public void setMGSOffHireMGTVOS(MGSOffHireMGTVO[] mGSOffHireMGTVOs){
		if(mGSOffHireMGTVOs != null){
			MGSOffHireMGTVO[] tmpVOs = java.util.Arrays.copyOf(mGSOffHireMGTVOs, mGSOffHireMGTVOs.length);
			this.mGSOffHireMGTVOs = tmpVOs;
		}
	}

	public MGSOffHireMGTVO getMGSOffHireMGTVO(){
		return mGSOffHireMGTVO;
	}

	public MGSOffHireMGTVO[] getMGSOffHireMGTVOS(){
		MGSOffHireMGTVO[] rtnVOs = null;
		if (this.mGSOffHireMGTVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(mGSOffHireMGTVOs, mGSOffHireMGTVOs.length);
		}
		return rtnVOs;
	}

}
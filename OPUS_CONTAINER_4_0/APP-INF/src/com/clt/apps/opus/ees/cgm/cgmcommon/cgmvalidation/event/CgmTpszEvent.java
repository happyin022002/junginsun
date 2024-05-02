/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CgmTpszEvent.java
*@FileTitle : TpszDupChk
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.08
*@LastModifier : 박의수
*@LastVersion : 1.0
* 2009.07.08 박의수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.event;

import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.vo.TpSzDupChkINVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.vo.TpSzDupChkMGTVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * CGM_TPSZ 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  CGM_TPSZHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Eui-su Park
 * @see CGM_TPSZ_HTMLAction 참조
 * @since J2EE 1.6
 */

public class CgmTpszEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TpSzDupChkMGTVO tpSzDupChkMGTVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TpSzDupChkMGTVO[] tpSzDupChkMGTVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private TpSzDupChkINVO tpSzDupChkINVO = null;

	/**
	 * @return the tpSzDupChkINVO
	 */
	public TpSzDupChkINVO getTpSzDupChkINVO() {
		return tpSzDupChkINVO;
	}
	
	/**
	 * @param cgmYardINVO the cgmYardINVO to set
	 */
	public void setTpSzDupChkINVO(TpSzDupChkINVO tpSzDupChkINVO) {
		this.tpSzDupChkINVO = tpSzDupChkINVO;
	}
	
	public CgmTpszEvent(){}
	
	public void setTpSzDupChkMGTVO(TpSzDupChkMGTVO tpSzDupChkMGTVO) {
		this.tpSzDupChkMGTVO = tpSzDupChkMGTVO;
	}
	public void setTpSzDupChkMGTVO(TpSzDupChkMGTVO[] tpSzDupChkMGTVOs){
		if(tpSzDupChkMGTVOs != null){
			TpSzDupChkMGTVO[] tmpVOs = java.util.Arrays.copyOf(tpSzDupChkMGTVOs, tpSzDupChkMGTVOs.length);
			this.tpSzDupChkMGTVOs = tmpVOs;
		}
	}
	
	public TpSzDupChkMGTVO getTpSzDupChkMGTVOs() {
		return tpSzDupChkMGTVO;
	}
	public TpSzDupChkMGTVO[] getTpSzDupChkMGTVOS() {
		TpSzDupChkMGTVO[] rtnVOs = null;
		if (this.tpSzDupChkMGTVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(tpSzDupChkMGTVOs, tpSzDupChkMGTVOs.length);
		}
		return rtnVOs;
	}
}

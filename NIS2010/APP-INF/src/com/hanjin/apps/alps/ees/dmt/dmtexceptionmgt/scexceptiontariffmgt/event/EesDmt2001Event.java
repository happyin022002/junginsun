/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt2001Event.java
*@FileTitle : DEM/DET Exception - S/C Exception Terms Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.05.27 이성훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.event;

import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionCommodityVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionCoverageVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionCustomerVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionDeleteVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionFreeTimeVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionRateAdjustVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionVersionVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * UI_DMT_2001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_2001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br> 
 *
 * @author SungHoon Lee 
 * @see EES_DMT_2001HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesDmt2001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SCExceptionParmVO parmVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SCExceptionParmVO[] parmVOS = null;
	
	private SCExceptionVO[] sCExceptionVOS = null;
	
	private SCExceptionCoverageVO[] sCExceptionCoverageVOS = null;
	
	private SCExceptionFreeTimeVO[] sCExceptionFreeTimeVOS = null;
	
	private SCExceptionRateAdjustVO[] sCExceptionRateAdjustVOS = null;
	
	private SCExceptionCustomerVO[] sCExceptionCustomerVOS = null;
	
	private SCExceptionCommodityVO[] sCExceptionCommodityVOS = null;
	
	private SCExceptionVersionVO sCExceptionVersionVO = null;
	
	private SCExceptionDeleteVO sCExceptionDeleteVO = null;
	
	private SCExceptionVO sCExceptionVO = null;	

	public EesDmt2001Event(){}
	
	public void setSCExceptionParmVO(SCExceptionParmVO parmVO) {
		this.parmVO = parmVO;
	}

	public void setSCExceptionParmVOS(SCExceptionParmVO[] parmVOS){
		this.parmVOS = parmVOS;
	}
	
	public void setSCExceptionVOS(SCExceptionVO[] sCExceptionVOS) {
		this.sCExceptionVOS = sCExceptionVOS;
	}
	
	public void setSCExceptionCoverageVOS(SCExceptionCoverageVO[] sCExceptionCoverageVOS) {
		this.sCExceptionCoverageVOS = sCExceptionCoverageVOS;
	}	
	
	public void setSCExceptionFreeTimeVOS(SCExceptionFreeTimeVO[] sCExceptionFreeTimeVOS) {
		this.sCExceptionFreeTimeVOS = sCExceptionFreeTimeVOS;
	}	
	
	public void setSCExceptionRateAdjustVOS(SCExceptionRateAdjustVO[] sCExceptionRateAdjustVOS) {
		this.sCExceptionRateAdjustVOS = sCExceptionRateAdjustVOS;
	}	
	
	public void setSCExceptionCustomerVOS(SCExceptionCustomerVO[] sCExceptionCustomerVOS) {
		this.sCExceptionCustomerVOS = sCExceptionCustomerVOS;
	}
	
	public void setSCExceptionCommodityVOS(SCExceptionCommodityVO[] sCExceptionCommodityVOS) {
		this.sCExceptionCommodityVOS = sCExceptionCommodityVOS;
	}
	
	public void setSCExceptionVersionVO(SCExceptionVersionVO sCExceptionVersionVO) {
		this.sCExceptionVersionVO = sCExceptionVersionVO;
	}	
	
	public  void setSCExceptionDeleteVO(SCExceptionDeleteVO sCExceptionDeleteVO) {
		this.sCExceptionDeleteVO = sCExceptionDeleteVO;
	}
	
	public void setSCExceptionVO(SCExceptionVO sCExceptionVO) {
		this.sCExceptionVO = sCExceptionVO;
	}
	
	public SCExceptionParmVO getSCExceptionParmVO() {
		return parmVO;
	}

	public SCExceptionParmVO[] getSCExceptionParmVOS(){
		return parmVOS;
	}
	
	public SCExceptionVO[] getSCExceptionVOS(){
		return sCExceptionVOS;
	}
	
	public SCExceptionCoverageVO[] getSCExceptionCoverageVOS(){
		return sCExceptionCoverageVOS;
	}	
	
	public SCExceptionFreeTimeVO[] getSCExceptionFreeTimeVOS(){
		return sCExceptionFreeTimeVOS;
	}	
	
	public SCExceptionRateAdjustVO[] getSCExceptionRateAdjustVOS(){
		return sCExceptionRateAdjustVOS;
	}	
	
	public SCExceptionCustomerVO[] getSCExceptionCustomerVOS(){
		return sCExceptionCustomerVOS;
	}

	public SCExceptionCommodityVO[] getSCExceptionCommodityVOS(){
		return sCExceptionCommodityVOS;
	}
	
	public SCExceptionVersionVO getSCExceptionVersionVO() {
		return sCExceptionVersionVO;
	}
	
	public SCExceptionDeleteVO getSCExceptionDeleteVO() {
		return sCExceptionDeleteVO;
	}
	
	public SCExceptionVO getSCExceptionVO() {
		return sCExceptionVO;
	}	
}

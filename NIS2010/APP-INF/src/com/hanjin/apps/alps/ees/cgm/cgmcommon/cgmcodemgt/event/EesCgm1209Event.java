/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1209Event.java
*@FileTitle : S/C Exception Terms Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.15
*@LastModifier : 조경완
*@LastVersion : 1.0
* 2013.10.15 조경완
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.event;


import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.ChssScExceptionVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.SCExceptionCommodityVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.SCExceptionCustomerVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.SCExceptionParmVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.CHSSSCExceptionVersionVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.event.EES_DMT_2001HTMLAction;
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

public class EesCgm1209Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SCExceptionParmVO parmVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SCExceptionParmVO[] parmVOS = null;
	
	
	private SCExceptionCustomerVO[] sCExceptionCustomerVOS = null;
	
	private SCExceptionCommodityVO[] sCExceptionCommodityVOS = null;
	
	private ChssScExceptionVO chssScExcptionVO = null;
	
	private ChssScExceptionVO[] chssScExceptionVOS = null;
	
	public ChssScExceptionVO getChssScExcptionVO() {
		return chssScExcptionVO;
	}

	public void setChssScExcptionVO(ChssScExceptionVO chssScExcptionVO) {
		this.chssScExcptionVO = chssScExcptionVO;
	}

	public ChssScExceptionVO[] getChssScExceptionVOS() {
		return chssScExceptionVOS;
	}

	public void setChssScExceptionVOS(ChssScExceptionVO[] chssScExceptionVOS) {
		this.chssScExceptionVOS = chssScExceptionVOS;
	}

	public CHSSSCExceptionVersionVO getsCExceptionVersionVO() {
		return sCExceptionVersionVO;
	}

	public void setsCExceptionVersionVO(CHSSSCExceptionVersionVO sCExceptionVersionVO) {
		this.sCExceptionVersionVO = sCExceptionVersionVO;
	}

	private CHSSSCExceptionVersionVO sCExceptionVersionVO = null;
	
	public EesCgm1209Event(){}
	
	public void setSCExceptionParmVO(SCExceptionParmVO parmVO) {
		this.parmVO = parmVO;
	}

	public void setSCExceptionParmVOS(SCExceptionParmVO[] parmVOS){
		this.parmVOS = parmVOS;
	}
	
	public void setSCExceptionCustomerVOS(SCExceptionCustomerVO[] sCExceptionCustomerVOS) {
		this.sCExceptionCustomerVOS = sCExceptionCustomerVOS;
	}
	
	public void setSCExceptionCommodityVOS(SCExceptionCommodityVO[] sCExceptionCommodityVOS) {
		this.sCExceptionCommodityVOS = sCExceptionCommodityVOS;
	}
	
	public SCExceptionParmVO getSCExceptionParmVO() {
		return parmVO;
	}

	public SCExceptionParmVO[] getSCExceptionParmVOS(){
		return parmVOS;
	}
	
	public SCExceptionCustomerVO[] getSCExceptionCustomerVOS(){
		return sCExceptionCustomerVOS;
	}

	public SCExceptionCommodityVO[] getSCExceptionCommodityVOS(){
		return sCExceptionCommodityVOS;
	}
}

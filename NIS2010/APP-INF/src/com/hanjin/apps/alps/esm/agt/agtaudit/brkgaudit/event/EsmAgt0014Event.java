/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_014Event.java
*@FileTitle : Brokerage Detail & History fo BL
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-23
*@LastModifier : Hwang GyeongNam
*@LastVersion : 1.0
* 2007-01-23 Hwang GyeongNam
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.event;

import com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.vo.AGTBRKGRateInfoVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.vo.BRKGCommDetailBasicbyBLVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.vo.BRKGCommDetailChargebyBLVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.vo.BRKGCommDetailHistorybyBLVO;
import com.hanjin.apps.alps.esm.agt.common.event.AGTEvent;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_AGT_014 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_AGT_014HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Hwang GyeongNam
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmAgt0014Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private BRKGCommDetailBasicbyBLVO brkgCommDetailBasicbyBLVO = null;
	
	private BRKGCommDetailBasicbyBLVO[] brkgCommDetailBasicbyBLVOS = null;
	
	private AGTBRKGRateInfoVO agtBRKGRateInfoVO = null;
	
	private AGTBRKGRateInfoVO[] agtBRKGRateInfoVOS = null;
	
	private BRKGCommDetailChargebyBLVO brkgCommDetailChargebyBLVO = null;
	
	private BRKGCommDetailChargebyBLVO[] brkgCommDetailChargebyBLVOS = null;
	
	private BRKGCommDetailHistorybyBLVO brkgCommDetailHistorybyBLVO = null;
	
	private BRKGCommDetailHistorybyBLVO[] brkgCommDetailHistorybyBLVOS = null;

	public BRKGCommDetailBasicbyBLVO getBrkgCommDetailBasicbyBLVO() {
    	return brkgCommDetailBasicbyBLVO;
    }

	public void setBrkgCommDetailBasicbyBLVO(BRKGCommDetailBasicbyBLVO brkgCommDetailBasicbyBLVO) {
    	this.brkgCommDetailBasicbyBLVO = brkgCommDetailBasicbyBLVO;
    }

	public BRKGCommDetailBasicbyBLVO[] getBrkgCommDetailBasicbyBLVOS() {
    	return brkgCommDetailBasicbyBLVOS;
    }

	public void setBrkgCommDetailBasicbyBLVOS(BRKGCommDetailBasicbyBLVO[] brkgCommDetailBasicbyBLVOS) {
    	this.brkgCommDetailBasicbyBLVOS = brkgCommDetailBasicbyBLVOS;
    }

	public AGTBRKGRateInfoVO getAgtBRKGRateInfoVO() {
    	return agtBRKGRateInfoVO;
    }

	public void setAgtBRKGRateInfoVO(AGTBRKGRateInfoVO agtBRKGRateInfoVO) {
    	this.agtBRKGRateInfoVO = agtBRKGRateInfoVO;
    }

	public AGTBRKGRateInfoVO[] getAgtBRKGRateInfoVOS() {
    	return agtBRKGRateInfoVOS;
    }

	public void setAgtBRKGRateInfoVOS(AGTBRKGRateInfoVO[] agtBRKGRateInfoVOS) {
    	this.agtBRKGRateInfoVOS = agtBRKGRateInfoVOS;
    }

	public BRKGCommDetailChargebyBLVO getBrkgCommDetailChargebyBLVO() {
    	return brkgCommDetailChargebyBLVO;
    }

	public void setBrkgCommDetailChargebyBLVO(BRKGCommDetailChargebyBLVO brkgCommDetailChargebyBLVO) {
    	this.brkgCommDetailChargebyBLVO = brkgCommDetailChargebyBLVO;
    }

	public BRKGCommDetailChargebyBLVO[] getBrkgCommDetailChargebyBLVOS() {
    	return brkgCommDetailChargebyBLVOS;
    }

	public void setBrkgCommDetailChargebyBLVOS(BRKGCommDetailChargebyBLVO[] brkgCommDetailChargebyBLVOS) {
    	this.brkgCommDetailChargebyBLVOS = brkgCommDetailChargebyBLVOS;
    }

	public BRKGCommDetailHistorybyBLVO getBrkgCommDetailHistorybyBLVO() {
    	return brkgCommDetailHistorybyBLVO;
    }

	public void setBrkgCommDetailHistorybyBLVO(BRKGCommDetailHistorybyBLVO brkgCommDetailHistorybyBLVO) {
    	this.brkgCommDetailHistorybyBLVO = brkgCommDetailHistorybyBLVO;
    }

	public BRKGCommDetailHistorybyBLVO[] getBrkgCommDetailHistorybyBLVOS() {
    	return brkgCommDetailHistorybyBLVOS;
    }

	public void setBrkgCommDetailHistorybyBLVOS(BRKGCommDetailHistorybyBLVO[] brkgCommDetailHistorybyBLVOS) {
    	this.brkgCommDetailHistorybyBLVOS = brkgCommDetailHistorybyBLVOS;
    }
	
	

}

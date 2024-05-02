/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_015Event.java
*@FileTitle : FAC Detail & History fo BL
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-24
*@LastModifier : Hwang GyeongNam
*@LastVersion : 1.0
* 2007-01-24 Hwang GyeongNam
* 1.0 최초 생성
* 2009-10-12 : Ho-Jin Lee Alps 전환
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtaudit.facaudit.event;

import com.hanjin.apps.alps.esm.agt.agtaudit.facaudit.vo.AGTFACRateInfoVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.facaudit.vo.FACCommDetailBasicbyBLVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.facaudit.vo.FACCommDetailChargebyBLVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.facaudit.vo.FACCommDetailHistorybyBLVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_AGT_0015 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Hwang GyeongNam
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmAgt0015Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private FACCommDetailBasicbyBLVO facCommDetailBasicbyBLVO = null;
	
	private FACCommDetailBasicbyBLVO[] facCommDetailBasicbyBLVOs = null;
	
	private FACCommDetailChargebyBLVO facCommDetailChargebyBLVO = null;
	
	private FACCommDetailChargebyBLVO[] facCommDetailChargebyBLVOs = null;
	
	private FACCommDetailHistorybyBLVO facCommDetailHistorybyBLVO = null;
	
	private FACCommDetailHistorybyBLVO[] facCommDetailHistorybyBLVOs = null;
	
	private AGTFACRateInfoVO agtFacRateInfoVO = null;
	
	private AGTFACRateInfoVO[] agtFacRateInfoVOs = null;

	public FACCommDetailBasicbyBLVO getFacCommDetailBasicbyBLVO() {
    	return facCommDetailBasicbyBLVO;
    }

	public void setFacCommDetailBasicbyBLVO(FACCommDetailBasicbyBLVO facCommDetailBasicbyBLVO) {
    	this.facCommDetailBasicbyBLVO = facCommDetailBasicbyBLVO;
    }

	public FACCommDetailBasicbyBLVO[] getFacCommDetailBasicbyBLVOs() {
    	return facCommDetailBasicbyBLVOs;
    }

	public void setFacCommDetailBasicbyBLVOs(FACCommDetailBasicbyBLVO[] facCommDetailBasicbyBLVOs) {
    	this.facCommDetailBasicbyBLVOs = facCommDetailBasicbyBLVOs;
    }

	public FACCommDetailChargebyBLVO getFacCommDetailChargebyBLVO() {
    	return facCommDetailChargebyBLVO;
    }

	public void setFacCommDetailChargebyBLVO(FACCommDetailChargebyBLVO facCommDetailChargebyBLVO) {
    	this.facCommDetailChargebyBLVO = facCommDetailChargebyBLVO;
    }

	public FACCommDetailChargebyBLVO[] getFacCommDetailChargebyBLVOs() {
    	return facCommDetailChargebyBLVOs;
    }

	public void setFacCommDetailChargebyBLVOs(FACCommDetailChargebyBLVO[] facCommDetailChargebyBLVOs) {
    	this.facCommDetailChargebyBLVOs = facCommDetailChargebyBLVOs;
    }

	public FACCommDetailHistorybyBLVO getFacCommDetailHistorybyBLVO() {
    	return facCommDetailHistorybyBLVO;
    }

	public void setFacCommDetailHistorybyBLVO(FACCommDetailHistorybyBLVO facCommDetailHistorybyBLVO) {
    	this.facCommDetailHistorybyBLVO = facCommDetailHistorybyBLVO;
    }

	public FACCommDetailHistorybyBLVO[] getFacCommDetailHistorybyBLVOs() {
    	return facCommDetailHistorybyBLVOs;
    }

	public void setFacCommDetailHistorybyBLVOs(FACCommDetailHistorybyBLVO[] facCommDetailHistorybyBLVOs) {
    	this.facCommDetailHistorybyBLVOs = facCommDetailHistorybyBLVOs;
    }

	public AGTFACRateInfoVO getAgtFacRateInfoVO() {
    	return agtFacRateInfoVO;
    }

	public void setAgtFacRateInfoVO(AGTFACRateInfoVO agtFacRateInfoVO) {
    	this.agtFacRateInfoVO = agtFacRateInfoVO;
    }

	public AGTFACRateInfoVO[] getAgtFacRateInfoVOs() {
    	return agtFacRateInfoVOs;
    }

	public void setAgtFacRateInfoVOs(AGTFACRateInfoVO[] agtFacRateInfoVOs) {
    	this.agtFacRateInfoVOs = agtFacRateInfoVOs;
    }

	
	
	

}

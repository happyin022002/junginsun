/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_011Event.java
*@FileTitle : Agent Commission Detail & History for B/L
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-01
*@LastModifier : Junghyung_kim
*@LastVersion : 1.0
* 2006-12-01 Junghyung_kim
* 1.0 최초 생성
* 2009-09-21 : Ho-Jin Lee Alps 전환
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.event;

import com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.vo.AgtCommBasicInformationVO;
import com.hanjin.apps.alps.esm.agt.common.event.AGTEvent;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.AgtAgnCommVO;
import com.hanjin.syscommon.common.table.BkgQuantityVO;

/**
 * ESM_AGT_011 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_AGT_011HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Junghyung_kim
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmAgt0011Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	/** Agt_Agn_Comm Table Value Object 조회 조건 및 단건 처리  */
	private AgtAgnCommVO agtAgnCommVO = null;
	
	/** Agt_Agn_Comm Table Value Object Multi Data 처리 */
	private AgtAgnCommVO[] agtAgnCommVOs = null;
	
	/** Bkg_Quantity Table Value Object 조회 조건 및 단건 처리  */
	private BkgQuantityVO bkgQuantityVO = null;
	
	/** Bkg_Quantity Table Value Object Multi Data 처리 */
	private BkgQuantityVO[] bkgQuantityVOs = null;
	
	private AgtCommBasicInformationVO agtCommBasicInformationVO = null;
	
	private AgtCommBasicInformationVO[] agtCommBasicInformationVOs = null;

	/**
	 * ESM_AGT_O011Event 생성자
	 */
	public EsmAgt0011Event(){}


	public AgtAgnCommVO getAgtAgnCommVO() {
    	return agtAgnCommVO;
    }


	public void setAgtAgnCommVO(AgtAgnCommVO agtAgnCommVO) {
    	this.agtAgnCommVO = agtAgnCommVO;
    }


	public AgtAgnCommVO[] getAgtAgnCommVOs() {
    	return agtAgnCommVOs;
    }


	public void setAgtAgnCommVOs(AgtAgnCommVO[] agtAgnCommVOs) {
    	this.agtAgnCommVOs = agtAgnCommVOs;
    }


	public BkgQuantityVO getBkgQuantityVO() {
    	return bkgQuantityVO;
    }


	public void setBkgQuantityVO(BkgQuantityVO bkgQuantityVO) {
    	this.bkgQuantityVO = bkgQuantityVO;
    }


	public BkgQuantityVO[] getBkgQuantityVOs() {
    	return bkgQuantityVOs;
    }


	public void setBkgQuantityVOs(BkgQuantityVO[] bkgQuantityVOs) {
    	this.bkgQuantityVOs = bkgQuantityVOs;
    }

	public AgtCommBasicInformationVO getAgtCommBasicInformationVO() {
    	return agtCommBasicInformationVO;
    }


	public void setAgtCommBasicInformationVO(AgtCommBasicInformationVO agtCommBasicInformationVO) {
    	this.agtCommBasicInformationVO = agtCommBasicInformationVO;
    }


	public AgtCommBasicInformationVO[] getAgtCommBasicInformationVOs() {
    	return agtCommBasicInformationVOs;
    }


	public void setAgtCommBasicInformationVOs(AgtCommBasicInformationVO[] agtCommBasicInformationVOs) {
    	this.agtCommBasicInformationVOs = agtCommBasicInformationVOs;
    }

}

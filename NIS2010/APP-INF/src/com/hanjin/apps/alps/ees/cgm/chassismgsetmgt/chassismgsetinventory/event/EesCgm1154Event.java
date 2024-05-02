/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1154Event.java
*@FileTitle : Asset inquiry by Year
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.24
*@LastModifier : NK Jin-Ho
*@LastVersion : 1.0
* 2011.05.242 NK Jin-Ho
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.event;

import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSAssetsSmryVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_1154에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_1154HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Ho Min
 * @see EES_CGM_1154HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm1154Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSAssetsSmryVO chsAssetsSmryVO = null;
	
	public EesCgm1154Event(){}
	
	public void setChsAssetsSmryVO(CHSAssetsSmryVO chsAssetsSmryVO){
		this.chsAssetsSmryVO = chsAssetsSmryVO;
	}

	public CHSAssetsSmryVO getChsAssetsSmryVO(){
		return chsAssetsSmryVO;
	}

}
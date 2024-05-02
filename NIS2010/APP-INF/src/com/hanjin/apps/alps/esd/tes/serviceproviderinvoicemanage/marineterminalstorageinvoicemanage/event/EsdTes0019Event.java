/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_019Event.java
*@FileTitle : Marine Terminal Storage Container List 조회 - Coincidence
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-22
*@LastModifier : kimjinjoo
*@LastVersion : 1.0
* 2006-11-22 kimjinjoo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.event;

import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TesTmlSoHdrVO;


/**
 * ESD_TES_019 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_019HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kimjinjoo
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTes0019Event extends EventSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** TES_TML_SO_HDR Table  Value Object */
	private TesTmlSoHdrVO tesTmlSoHdrVO = null;		
	
	public EsdTes0019Event(){
	}
		
	public void setTesTmlSoHdrVO(TesTmlSoHdrVO tesTmlSoHdrVO){
		this.tesTmlSoHdrVO = tesTmlSoHdrVO;
	}	
	
	public TesTmlSoHdrVO getTesTmlSoHdrVO(){
		return tesTmlSoHdrVO;
	}		
}

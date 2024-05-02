/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsGem0015Event.java
 *@FileTitle : Expense Vs Performance
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.09
 *@LastModifier : 박창준
 *@LastVersion : 1.0
 * 2009.06.09 박창준
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.event;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.RsltSlpErrorInformationVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 
/**
 *[CPS_GEM-0015] Expense Vs Performance
 * CPS_GEM_0015 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - CPS_GEM_0015HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Park Changjune
 * @see CPS_GEM_0015HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsGem0112Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private RsltSlpErrorInformationVO RsltSlpErrorInformationVO =null;
	
	
	public RsltSlpErrorInformationVO getRsltSlpErrorInformationVO() {
		return RsltSlpErrorInformationVO;
	}
	
	public void setRsltSlpErrorInformationVO(RsltSlpErrorInformationVO rsltSlpErrorInformationVO) {
		RsltSlpErrorInformationVO = rsltSlpErrorInformationVO;
	}
	
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
	
	
	
	
	
}	
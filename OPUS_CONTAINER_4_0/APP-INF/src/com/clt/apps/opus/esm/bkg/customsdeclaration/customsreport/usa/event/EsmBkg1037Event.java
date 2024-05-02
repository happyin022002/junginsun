/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1037Event.java
*@FileTitle : Rail Ams History
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.09.01 김도완
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.event; 


import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.AmsRailCondVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1037 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1037HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김도완
 * @see ESM_BKG_1037HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg1037Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Ams Report 정보 조회조건 */
	private AmsRailCondVO condVO = null;
	
	public EsmBkg1037Event(){}

	/** Set Method **/
	public void setCondVO(AmsRailCondVO condVO){
		this. condVO = condVO;
	}	

	/** Get Method **/
	public AmsRailCondVO getCondVO(){
		return condVO;
	}
}
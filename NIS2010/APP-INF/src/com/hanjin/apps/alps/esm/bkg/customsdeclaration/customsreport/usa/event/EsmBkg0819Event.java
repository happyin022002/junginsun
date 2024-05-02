/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0015Event.java
*@FileTitle : CndManifestListDownload
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.05.25 김도완
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.vo.MiTransmitHistoryCondVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0819 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0819HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김도완
 * @see ESM_BKG_0819HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0819Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** MiTransmitHistory  정보 조회조건 */
	private MiTransmitHistoryCondVO condVO = null;
	
	public EsmBkg0819Event(){}

	/** Set Method **/
	public void setCondVO(MiTransmitHistoryCondVO condVO){
		this. condVO = condVO;
	}
	

	/** Get Method **/
	public MiTransmitHistoryCondVO getMiTransmitHistoryCondVO(){
		return condVO;
	}

}
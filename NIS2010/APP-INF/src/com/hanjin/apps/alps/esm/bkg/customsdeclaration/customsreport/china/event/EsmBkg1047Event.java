/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1047Event.java
*@FileTitle : ESM_BKG-1047
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.08
*@LastModifier : 오동현
*@LastVersion : 1.0
* 2009.08.22 오동현
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.china.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.china.vo.ChinaTransmitHistCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.china.vo.ChinaManifestListTransmitHistDetailVO;

 
/**
 * ESM_BKG-1047 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-1047HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author  OH DONG HYUN
 * @see ESM_BKG-0497HTMLAction 참조
 * @since J2EE 1.4  
 */

public class EsmBkg1047Event extends EventSupport {
	private static final long serialVersionUID = 1L;  
	  
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ChinaTransmitHistCondVO chinaTransmitHistCondVO = null; 
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ChinaManifestListTransmitHistDetailVO[] chinaManifestListTransmitHistDetailVOs  = null;

	public EsmBkg1047Event(){}
	
	public void setChinaTransmitHistCondVO(ChinaTransmitHistCondVO chinaTransmitHistCondVO){
		this.chinaTransmitHistCondVO = chinaTransmitHistCondVO;
	}	
	 
	public ChinaTransmitHistCondVO getChinaTransmitHistCondVO(){
		return chinaTransmitHistCondVO;
	}
	
	public void setChinaManifestListTransmitHistDetailVOs(ChinaManifestListTransmitHistDetailVO[] chinaManifestListTransmitHistDetailVOs){
		this.chinaManifestListTransmitHistDetailVOs = chinaManifestListTransmitHistDetailVOs;
	}	
	 
	public ChinaManifestListTransmitHistDetailVO[] getChinaManifestListTransmitHistDetailVO(){
		return chinaManifestListTransmitHistDetailVOs;
	}
	
	
  
}
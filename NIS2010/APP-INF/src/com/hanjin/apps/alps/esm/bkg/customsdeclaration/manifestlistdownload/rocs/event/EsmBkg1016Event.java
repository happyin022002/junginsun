/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1016Event.java
*@FileTitle : ESM_BKG-1016
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.13
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.05.27 임재택
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsManifestListCondVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 
/**
 * ESM_BKG-1016 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-1016HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author  LIM JAE TAEK
 * @see ESM_BKG-1016HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg1016Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RocsManifestListCondVO rocsManifestListCondVO = null; 
	
	public RocsManifestListCondVO getRocsManifestListCondVO(){
		return rocsManifestListCondVO;
	} 
    public EsmBkg1016Event(){}
    
    public void setRocsManifestListCondVO(RocsManifestListCondVO rocsManifestListCondVO){
		this. rocsManifestListCondVO = rocsManifestListCondVO;
	}
    
    
}

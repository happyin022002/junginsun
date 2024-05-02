/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1027Event.java
*@FileTitle : ESM_BKG-1027
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.04.21 임재택
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsReceiveLogCondVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG-1027 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-1027HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author LIM JAE TAEK
 * @see ESM_BKG-1027HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg1027Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RocsReceiveLogCondVO rocsReceiveLogCondVO = null; 
	 
	 
	public EsmBkg1027Event(){}
	
	 public void setRocsReceiveLogCondVO(RocsReceiveLogCondVO rocsReceiveLogCondVO){
			this. rocsReceiveLogCondVO = rocsReceiveLogCondVO;
		}
	 
	 
	public RocsReceiveLogCondVO getRocsReceiveLogCondVO(){
		return rocsReceiveLogCondVO;
	} 
	
	 
}
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0450Event.java
*@FileTitle : ESM_BKG-0450
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.27
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.04.21 임재택
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsTransmitHistCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsTransmitHistListCondVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG-0450 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-0450HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author LIM JAE TAEK
 * @see ESM_BKG-0450HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0450Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RocsTransmitHistCondVO rocsTransmitHistCondVO = null; 
	private RocsTransmitHistListCondVO rocsTransmitHistListCondVO = null;  
	 
	public EsmBkg0450Event(){}
	
	 public void setRocsTransmitHistCondVO(RocsTransmitHistCondVO rocsTransmitHistCondVO){
			this. rocsTransmitHistCondVO = rocsTransmitHistCondVO;
		}
	 public void setRocsTransmitHistListCondVO(RocsTransmitHistListCondVO rocsTransmitHistListCondVO){
			this. rocsTransmitHistListCondVO = rocsTransmitHistListCondVO;
		}
	 
	public RocsTransmitHistCondVO getRocsTransmitHistCondVO(){
		return rocsTransmitHistCondVO;
	} 
	
	public RocsTransmitHistListCondVO getRocsTransmitHistListCondVO(){
		return rocsTransmitHistListCondVO;
	} 
	 
}
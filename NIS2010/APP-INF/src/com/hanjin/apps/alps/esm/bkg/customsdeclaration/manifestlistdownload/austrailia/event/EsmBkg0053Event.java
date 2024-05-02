/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0053Event.java
*@FileTitle : ESM_BKG-0053
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.05.27 임재택
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.AustrailiaManifestTransmitVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 
/**
 * ESM_BKG-0053 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-0053HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author  LIM JAE TAEK
 * @see ESM_BKG-0053HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0053Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	 
	private AustrailiaManifestTransmitVO[] austrailiaManifestTransmitVO = null;
	private AustrailiaManifestTransmitVO austrailiaManifestTransmitSingleVO = null;
	private String key = "";
	
    public EsmBkg0053Event(){}
     
    public void setAustrailiaManifestTransmitVO(AustrailiaManifestTransmitVO[] austrailiaManifestTransmitVO){
		this. austrailiaManifestTransmitVO = austrailiaManifestTransmitVO;
	}
 
	public AustrailiaManifestTransmitVO[] getAustrailiaManifestTransmitVO(){
		return austrailiaManifestTransmitVO;
	}
	
	public void setAustrailiaManifestTransmitSingleVO(AustrailiaManifestTransmitVO austrailiaManifestTransmitSingleVO){
		this. austrailiaManifestTransmitSingleVO = austrailiaManifestTransmitSingleVO;
	}
 
	public AustrailiaManifestTransmitVO getAustrailiaManifestTransmitSingleVO(){
		return austrailiaManifestTransmitSingleVO;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getKey() {
		return key;
	}		
  
}

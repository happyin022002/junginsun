/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0497Event.java
*@FileTitle : ESM_BKG-0497
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.05.27 임재택
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.taiwan.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.taiwan.vo.TaiwanManifestTransmitVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 
/**
 * ESM_BKG-0497 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-0497HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author  LIM JAE TAEK
 * @see ESM_BKG-0497HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0497Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	 
	private TaiwanManifestTransmitVO[] taiwanManifestTransmitVOs = null;
	private String key = "";
	 
    public EsmBkg0497Event(){}
     
    public void setTaiwanManifestTransmitVOs(TaiwanManifestTransmitVO[] taiwanManifestTransmitVOs){
		this. taiwanManifestTransmitVOs = taiwanManifestTransmitVOs;
	}
 
	public TaiwanManifestTransmitVO[] getTaiwanManifestTransmitVOs(){
		return taiwanManifestTransmitVOs;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	public String getKey() {
		return key;
	}	
  
}

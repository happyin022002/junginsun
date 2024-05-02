/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0282Event.java
*@FileTitle : ESM_BKG-0082
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.05.27 임재택
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.hongkong.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.hongkong.vo.HongKongManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.hongkong.vo.HongKongManifestListCondVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 
/**
 * ESM_BKG-0282 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-0282HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author  LIM JAE TAEK
 * @see ESM_BKG-0282HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0282Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private HongKongManifestListCondVO hongKongManifestListCondVO = null; 
	
	/** Table Value Object Multi Data 처리 */
	private HongKongManifestListCondVO[] hongKongManifestListCondVOs = null;
	
	private HongKongManifestTransmitVO[] hongKongManifestTransmitVOs = null;
	private ManifestTransmitVO[] manifestTransmitVOs = null;
	
	private String polCd = null; 
	private String podCd = null; 
	private String key = "";
	 
    public EsmBkg0282Event(){}
    
    public String getPolCd() {
		return polCd;
	}

	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	 public String getPoDCd() {
		return podCd;
	}

	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
    
    public void setHongKongManifestListCondVO(HongKongManifestListCondVO hongKongManifestListCondVO){
		this. hongKongManifestListCondVO = hongKongManifestListCondVO;
	}

	public void setHongKongManifestListCondVOS(HongKongManifestListCondVO[] hongKongManifestListCondVOs){
		this. hongKongManifestListCondVOs = hongKongManifestListCondVOs;
	}
	public void setHongKongManifestTransmitVOS(HongKongManifestTransmitVO[] hongKongManifestTransmitVOs){
		this. hongKongManifestTransmitVOs = hongKongManifestTransmitVOs;
	}
	public void setManifestTransmitVOS(ManifestTransmitVO[] manifestTransmitVOs){
		this. manifestTransmitVOs = manifestTransmitVOs;
	}
	 
	public HongKongManifestListCondVO getHongKongManifestListCondVO(){
		return hongKongManifestListCondVO;
	}
 
	public HongKongManifestListCondVO[] getHongKongManifestListCondVOS(){
		return hongKongManifestListCondVOs;
	}	
	public HongKongManifestTransmitVO[] getHongKongManifestTransmitVOs(){
		return hongKongManifestTransmitVOs;
	} 
	public ManifestTransmitVO[] getManifestTransmitVOS(){
		return manifestTransmitVOs;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	public String getKey() {
		return key;
	}	
}

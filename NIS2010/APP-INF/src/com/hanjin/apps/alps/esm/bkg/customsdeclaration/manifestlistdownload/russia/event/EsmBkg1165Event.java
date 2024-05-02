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
* 2015.10.21 소스보안 [CWE-495,766] 관련 수정 - Go live
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.russia.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.russia.vo.FdrBlInVO;
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

public class EsmBkg1165Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private FdrBlInVO fdrBlInVO = null; 
	
	/** Table Value Object Multi Data 처리 */
	private FdrBlInVO[] fdrBlInVOs = null;


	private ManifestTransmitVO[] manifestTransmitVOs = null;
	
	private String polCd = null; 
	private String podCd = null; 
	private String key = "";
	 
    public EsmBkg1165Event(){}
    
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
    
    public void setFdrBlInVO(FdrBlInVO fdrBlInVO){
		this. fdrBlInVO = fdrBlInVO;
	}

	public void setFdrBlInVOS(FdrBlInVO[] fdrBlInVOs){
		if(fdrBlInVOs != null){
			FdrBlInVO[] tmpVOs = Arrays.copyOf(fdrBlInVOs, fdrBlInVOs.length);
			this.fdrBlInVOs = tmpVOs;
		}
	}

	public void setManifestTransmitVOS(ManifestTransmitVO[] manifestTransmitVOs){
		if(manifestTransmitVOs != null){
			ManifestTransmitVO[] tmpVOs = Arrays.copyOf(manifestTransmitVOs, manifestTransmitVOs.length);
			this.manifestTransmitVOs = tmpVOs;
		}
	}
	 
	public FdrBlInVO getFdrBlInVO(){
		return fdrBlInVO;
	}
 
	public FdrBlInVO[] getFdrBlInVOS(){
		FdrBlInVO[] rtnVOs = null;
		if (this.fdrBlInVOs != null) {
			rtnVOs = Arrays.copyOf(fdrBlInVOs, fdrBlInVOs.length);
		}
		return rtnVOs;
	}	
 
	public ManifestTransmitVO[] getManifestTransmitVOS(){
		ManifestTransmitVO[] rtnVOs = null;
		if (this.manifestTransmitVOs != null) {
			rtnVOs = Arrays.copyOf(manifestTransmitVOs, manifestTransmitVOs.length);
		}
		return rtnVOs;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	public String getKey() {
		return key;
	}	
}

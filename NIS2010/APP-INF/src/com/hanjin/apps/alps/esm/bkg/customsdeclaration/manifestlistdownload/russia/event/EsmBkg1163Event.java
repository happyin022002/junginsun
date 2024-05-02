/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EsmBkg1163Event.java
*@FileTitle : ESM_BKG_1163
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.04
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2013.07.04 김보배
* 1.0 Creation
* 2015.10.21 소스보안 [CWE-495,766] 관련 수정 - Go live
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.russia.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.BlInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.BlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.russia.vo.ModifyCntrInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.russia.vo.RussiaManifestListCondVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 
/**
 * ESM_BKG_1163 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1163HTMLAction 에서 작성<br>
 * - ServiceCommand Layer 로 전달하는 PDTO로 사용<br>
 *
 * @author  BOBAE KIM
 * @see ESM_BKG_1163HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg1163Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RussiaManifestListCondVO russiaManifestListCondVO = null; 
	
	/** Table Value Object Multi Data 처리 */
	private RussiaManifestListCondVO[] russiaManifestListCondVOs = null;
	
//	private ManifestTransmitVO[] manifestTransmitVOs = null;
	
	private ModifyCntrInfoVO modifyCntrInfoVO = null;
	private ModifyCntrInfoVO[] modifyCntrInfoVOs = null;
	
	private String polCd = null; 
	private String podCd = null; 
	private String key = "";
	
	
	
	private BlInfoCondVO blInfoCondVO = null;
	private BlInfoVO[] blInfoVOs = null;
	private ManifestTransmitVO manifestTransmitVO = null;
	
	private String transMode = null;
//	private String key = null;
	
	
	
	 
    public BlInfoCondVO getBlInfoCondVO() {
		return blInfoCondVO;
	}

	public void setBlInfoCondVO(BlInfoCondVO blInfoCondVO) {
		this.blInfoCondVO = blInfoCondVO;
	}

	public BlInfoVO[] getBlInfoVOs() {
		return blInfoVOs;
	}

	public void setBlInfoVOs(BlInfoVO[] blInfoVOs) {
		this.blInfoVOs = blInfoVOs;
	}

	public ManifestTransmitVO getManifestTransmitVO() {
		return manifestTransmitVO;
	}

	public void setManifestTransmitVO(ManifestTransmitVO manifestTransmitVO) {
		this.manifestTransmitVO = manifestTransmitVO;
	}

	public String getTransMode() {
		return transMode;
	}

	public void setTransMode(String transMode) {
		this.transMode = transMode;
	}

	public EsmBkg1163Event(){}
    
    public RussiaManifestListCondVO getRussiaManifestListCondVO() {
		return russiaManifestListCondVO;
	}

	public void setRussiaManifestListCondVO(
			RussiaManifestListCondVO russiaManifestListCondVO) {
		this.russiaManifestListCondVO = russiaManifestListCondVO;
	}

	public RussiaManifestListCondVO[] getRussiaManifestListCondVOs() {
		RussiaManifestListCondVO[] rtnVOs = null;
		if (this.russiaManifestListCondVOs != null) {
			rtnVOs = Arrays.copyOf(russiaManifestListCondVOs, russiaManifestListCondVOs.length);
		}
		return rtnVOs;
	}

	public void setRussiaManifestListCondVOs(RussiaManifestListCondVO[] russiaManifestListCondVOs){
		if(russiaManifestListCondVOs != null){
			RussiaManifestListCondVO[] tmpVOs = Arrays.copyOf(russiaManifestListCondVOs, russiaManifestListCondVOs.length);
			this.russiaManifestListCondVOs = tmpVOs;
		}
	}

//	public void setManifestTransmitVOS(ManifestTransmitVO[] manifestTransmitVOs){
//		this. manifestTransmitVOs = manifestTransmitVOs;
//	}
//	 
//	public ManifestTransmitVO[] getManifestTransmitVOS(){
//		return manifestTransmitVOs;
//	}

	public ModifyCntrInfoVO getModifyCntrInfoVO() {
		return modifyCntrInfoVO;
	}

	public void setModifyCntrInfoVO(ModifyCntrInfoVO modifyCntrInfoVO) {
		this.modifyCntrInfoVO = modifyCntrInfoVO;
	}

	public ModifyCntrInfoVO[] getModifyCntrInfoVOs() {
		ModifyCntrInfoVO[] rtnVOs = null;
		if (this.modifyCntrInfoVOs != null) {
			rtnVOs = Arrays.copyOf(modifyCntrInfoVOs, modifyCntrInfoVOs.length);
		}
		return rtnVOs;
	}

	public void setModifyCntrInfoVOs(ModifyCntrInfoVO[] modifyCntrInfoVOs){
		if(modifyCntrInfoVOs != null){
			ModifyCntrInfoVO[] tmpVOs = Arrays.copyOf(modifyCntrInfoVOs, modifyCntrInfoVOs.length);
			this.modifyCntrInfoVOs = tmpVOs;
		}
	}
	
	public String getPolCd() {
		return polCd;
	}

	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	 public String getPodCd() {
		return podCd;
	}

	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public String getKey() {
		return key;
	}	
}

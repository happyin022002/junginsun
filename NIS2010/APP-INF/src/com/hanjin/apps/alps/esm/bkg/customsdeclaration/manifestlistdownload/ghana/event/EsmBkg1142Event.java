/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1142Event.java
*@FileTitle : Ghana Customs Manifest
*Open Issues :
*Change history :
 *@LastModifyDate : 2012.04.12
 *@LastModifier : 김보배
 *@LastVersion : 1.0
 * 2012.04.12 김보배
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ghana.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo.EurManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ghana.vo.GhanaManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ghana.vo.GhanaSearchManifestListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 
/**
 * ESM_BKG_1142 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1142HTMLAction 에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author  BOBAE KIM
 * @see ESM_BKG_1142HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg1142Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private GhanaSearchManifestListVO ghanaSearchManifestListVO = null; 
	
	/** Table Value Object Multi Data 처리 */
	private GhanaSearchManifestListVO[] ghanaSearchManifestListVOs = null;
	
	private GhanaManifestTransmitVO[] ghanaManifestTransmitVOs = null;
	private ManifestTransmitVO[] manifestTransmitVOs = null;
	private EurManifestTransmitVO[] euManifestTransmitVOs = null;
	
	private String polCd = null; 
	private String podCd = null; 
	private String key = "";
	 
    public EsmBkg1142Event(){}
    
    
    
    public GhanaSearchManifestListVO getGhanaSearchManifestListVO() {
		return ghanaSearchManifestListVO;
	}

	public void setGhanaSearchManifestListVO(GhanaSearchManifestListVO ghanaSearchManifestListVO) {
		this.ghanaSearchManifestListVO = ghanaSearchManifestListVO;
	}


	
	public GhanaSearchManifestListVO[] getGhanaSearchManifestListVOs() {
		return ghanaSearchManifestListVOs;
	}

	public void setGhanaSearchManifestListVOs(GhanaSearchManifestListVO[] ghanaSearchManifestListVOs) {
		this.ghanaSearchManifestListVOs = ghanaSearchManifestListVOs;
	}

	
	
	public GhanaManifestTransmitVO[] getGhanaManifestTransmitVOs() {
		return ghanaManifestTransmitVOs;
	}

	public void setGhanaManifestTransmitVOs(GhanaManifestTransmitVO[] ghanaManifestTransmitVOs) {
		this.ghanaManifestTransmitVOs = ghanaManifestTransmitVOs;
	}

	
	
	public ManifestTransmitVO[] getManifestTransmitVOs() {
		return manifestTransmitVOs;
	}

	public void setManifestTransmitVOs(ManifestTransmitVO[] manifestTransmitVOs) {
		this.manifestTransmitVOs = manifestTransmitVOs;
	}

	
	
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
    
   	public void setKey(String key) {
		this.key = key;
	}
	public String getKey() {
		return key;
	}



	public EurManifestTransmitVO[] getEuManifestTransmitVOs() {
		return euManifestTransmitVOs;
	}

	public void setEuManifestTransmitVOs(
			EurManifestTransmitVO[] euManifestTransmitVOs) {
		this.euManifestTransmitVOs = euManifestTransmitVOs;
	}

	
}

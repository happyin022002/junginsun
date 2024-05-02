/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmBkg1121Event.java
*@FileTitle : ESM_BKG-1121
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.07
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2010.09.03 박성진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eu24ManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eu24CountryListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eu24ManifestTransmitOBVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 
/**
 * ESM_BKG-1121 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-1121HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author  KIM GYOUNG SUB
 * @see ESM_BKG_1121HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg1121Event extends EventSupport {
	private static final long serialVersionUID = 1L;
		
	private String key = "";
	
	private Eu24CountryListVO   eu24CountryListVO = null;
	private ManifestListCondVO   manifestListCondVO = null;
	private ManifestListDetailVO[] eu24ManifestListVOs = null;
	
	private Eu24ManifestTransmitVO[] eu24ManifestTransmitVOs = null;
	private Eu24ManifestTransmitOBVO[] eu24ManifestTransmitOBVOs = null;
	
	
    public Eu24CountryListVO getEu24CountryListVO() {
		return eu24CountryListVO;
	}


	public void setEu24CountryListVO(Eu24CountryListVO eu24CountryListVO) {
		this.eu24CountryListVO = eu24CountryListVO;
	}


	public Eu24ManifestTransmitVO[] getEu24ManifestTransmitVOs() {
		return eu24ManifestTransmitVOs;
	}
	
	public Eu24ManifestTransmitOBVO[] getEu24ManifestTransmitOBVOs() {
		return eu24ManifestTransmitOBVOs;
	}


	public void setEu24ManifestTransmitVOs(
			Eu24ManifestTransmitVO[] eu24ManifestTransmitVOs) {
		this.eu24ManifestTransmitVOs = eu24ManifestTransmitVOs;
	}
	public void setEu24ManifestTransmitOBVOs(Eu24ManifestTransmitOBVO[] eu24ManifestTransmitOBVOs) {
		this.eu24ManifestTransmitOBVOs = eu24ManifestTransmitOBVOs;
	}


	public ManifestListDetailVO[] getEu24ManifestListVOs() {
		return eu24ManifestListVOs;
	}


	public void setEu24ManifestListVOs(ManifestListDetailVO[] eu24ManifestListVOs) {
		this.eu24ManifestListVOs = eu24ManifestListVOs;
	}


	public ManifestListCondVO getManifestListCondVO() {
		return manifestListCondVO;
	}


	public void setManifestListCondVO(ManifestListCondVO manifestListCondVO) {
		this.manifestListCondVO = manifestListCondVO;
	}


	public EsmBkg1121Event(){}
    
    
	public void setKey(String key) {
		this.key = key;
	}
	public String getKey() {
		return key;
	}	
	 
}

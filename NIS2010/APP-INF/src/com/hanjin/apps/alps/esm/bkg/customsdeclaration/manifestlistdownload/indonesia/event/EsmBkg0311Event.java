/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0311Event.java
*@FileTitle : ESM_BKG-0311
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 장지영
*@LastVersion : 1.0
* 2009.09.29 장지영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.vo.IndonesiaManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.vo.IndonesiaManifestModificationVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 
/**
 * ESM_BKG-0311 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-0311HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author  JI-YOUNG JANG
 * @see ESM_BKG-0311HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0311Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private IndonesiaManifestListCondVO indonesiaManifestListCondVO = null; 
	
	/** Table Value Object Multi Data 처리 */
	private IndonesiaManifestListCondVO[] indonesiaManifestListCondVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private IndonesiaManifestModificationVO indonesiaManifestModificationVO = null; 
	
	/** Table Value Object Multi Data 처리 */
	private IndonesiaManifestModificationVO[] indonesiaManifestModificationVOs = null;
	
	private ManifestTransmitVO manifestTransmitVO = null;
		
	private String vvd = null; 
	private String polCd = null; 
	private String podCd = null;
	private String bkgNo = null;

	 
    public EsmBkg0311Event(){}
    
    public String getVvd() {
		return vvd;
	}

	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	
	 public String getBkgNo() {
		return bkgNo;
	}

	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
    
    public void setIndonesiaManifestListCondVO(IndonesiaManifestListCondVO indonesiaManifestListCondVO){
		this. indonesiaManifestListCondVO = indonesiaManifestListCondVO;
	}

	public void setIndonesiaManifestListCondVOS(IndonesiaManifestListCondVO[] indonesiaManifestListCondVOs){
		this. indonesiaManifestListCondVOs = indonesiaManifestListCondVOs;
	}
	 
	public IndonesiaManifestListCondVO getIndonesiaManifestListCondVO(){
		return indonesiaManifestListCondVO;
	}
 
	public IndonesiaManifestListCondVO[] getIndonesiaManifestListCondVOS(){
		return indonesiaManifestListCondVOs;
	}
	
	public void setIndonesiaManifestModificationVO(IndonesiaManifestModificationVO indonesiaManifestModificationVO){
		this. indonesiaManifestModificationVO = indonesiaManifestModificationVO;
	}

	public void setIndonesiaManifestModificationVOS(IndonesiaManifestModificationVO[] indonesiaManifestModificationVOs){
		this. indonesiaManifestModificationVOs = indonesiaManifestModificationVOs;
	}
		
	public IndonesiaManifestModificationVO getIndonesiaManifestModificationVO(){
		return indonesiaManifestModificationVO;
	}

	public IndonesiaManifestModificationVO[] getIndonesiaManifestModificationVOS(){
		return indonesiaManifestModificationVOs;
	}	

	public ManifestTransmitVO getManifestTransmitVO() {
		return manifestTransmitVO;
	}

	public void setManifestTransmitVO(ManifestTransmitVO manifestTransmitVO) {
		this.manifestTransmitVO = manifestTransmitVO;
	}
}

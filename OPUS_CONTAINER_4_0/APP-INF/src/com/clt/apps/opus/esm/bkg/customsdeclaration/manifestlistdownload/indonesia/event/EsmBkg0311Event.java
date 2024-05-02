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
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.vo.IndonesiaManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.vo.IndonesiaManifestModificationVO;
import com.clt.framework.support.layer.event.EventSupport;


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

	public void setIndonesiaManifestListCondVOS(IndonesiaManifestListCondVO[] indonesiaManifestListCondVOs) {
		if (indonesiaManifestListCondVOs != null) {
			IndonesiaManifestListCondVO[] tmpVOs = Arrays.copyOf(indonesiaManifestListCondVOs, indonesiaManifestListCondVOs.length);
			this.indonesiaManifestListCondVOs = tmpVOs;
		}
	}

	public IndonesiaManifestListCondVO getIndonesiaManifestListCondVO(){
		return indonesiaManifestListCondVO;
	}

	public IndonesiaManifestListCondVO[] getIndonesiaManifestListCondVOS(){
		IndonesiaManifestListCondVO[] rtnVOs = null;
		if (this.indonesiaManifestListCondVOs != null) {
			rtnVOs = Arrays.copyOf(indonesiaManifestListCondVOs, indonesiaManifestListCondVOs.length);
		}
		return rtnVOs;
	}

	public void setIndonesiaManifestModificationVO(IndonesiaManifestModificationVO indonesiaManifestModificationVO){
		this. indonesiaManifestModificationVO = indonesiaManifestModificationVO;
	}

	public void setIndonesiaManifestModificationVOS(IndonesiaManifestModificationVO[] indonesiaManifestModificationVOs) {
		if (indonesiaManifestModificationVOs != null) {
			IndonesiaManifestModificationVO[] tmpVOs = Arrays.copyOf(indonesiaManifestModificationVOs, indonesiaManifestModificationVOs.length);
			this.indonesiaManifestModificationVOs = tmpVOs;
		}
	}

	public IndonesiaManifestModificationVO getIndonesiaManifestModificationVO(){
		return indonesiaManifestModificationVO;
	}

	public IndonesiaManifestModificationVO[] getIndonesiaManifestModificationVOS(){
		IndonesiaManifestModificationVO[] rtnVOs = null;
		if (this.indonesiaManifestModificationVOs != null) {
			rtnVOs = Arrays.copyOf(indonesiaManifestModificationVOs, indonesiaManifestModificationVOs.length);
		}
		return rtnVOs;
	}

	public ManifestTransmitVO getManifestTransmitVO() {
		return manifestTransmitVO;
	}

	public void setManifestTransmitVO(ManifestTransmitVO manifestTransmitVO) {
		this.manifestTransmitVO = manifestTransmitVO;
	}
}

/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0006Event.java
 *@FileTitle : Canada Export EDI Transmit
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.29
 *@LastModifier : 김민정
 *@LastVersion : 1.0
 * 2009.04.29 김민정
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsManifestListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsManifestCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsBlVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0006 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0006HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Kim Min Jeong
 * @see ESM_BKG_0006HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0006Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	// 조회조건
	private CstmsManifestCondVO cstmsManifestCondVO = null;
	// 삭제시 VO 세팅
	private CstmsBlVO[] cstmsBlVOs = null;
	// 전송시 VO 세팅
	private ManifestTransmitVO manifestTransmitVO = null;
	
	private CndCstmsManifestListVO[] CndCstmsManifestListVOs = null;
	
	public EsmBkg0006Event() {}

	/** Set Method */
	public void setCstmsManifestCondVO(CstmsManifestCondVO cstmsManifestCondVO) {
		this.cstmsManifestCondVO = cstmsManifestCondVO;
	}
	public void setCstmsBlVOs(CstmsBlVO[] cstmsBlVOs){
		if(cstmsBlVOs != null){
			CstmsBlVO[] tmpVOs = Arrays.copyOf(cstmsBlVOs, cstmsBlVOs.length);
			this.cstmsBlVOs = tmpVOs;
		}
	}
	public void setManifestTransmitVO(ManifestTransmitVO manifestTransmitVO) {
		this.manifestTransmitVO = manifestTransmitVO;
	}
	public void setCndCstmsManifestListVOs(ManifestTransmitVO manifestTransmitVO) {
		this.manifestTransmitVO = manifestTransmitVO;
	}	
	public void setCndCstmsManifestListVOs(CndCstmsManifestListVO[] CndCstmsManifestListVOs) {
		if(CndCstmsManifestListVOs != null){
			CndCstmsManifestListVO[] tmpVOs = Arrays.copyOf(CndCstmsManifestListVOs, cstmsBlVOs.length);
			this.CndCstmsManifestListVOs = tmpVOs;
		}
	}	
			
	
	/** Get Method */
	public CstmsManifestCondVO getCstmsManifestCondVO() {
		return cstmsManifestCondVO;
	}
	public CstmsBlVO[] getCstmsBlVOs() {
		CstmsBlVO[] rtnVOs = null;
		if (this.cstmsBlVOs != null) {
			rtnVOs = Arrays.copyOf(cstmsBlVOs, cstmsBlVOs.length);
		}
		return rtnVOs;
	}	
	public ManifestTransmitVO getManifestTransmitVO() {
		return manifestTransmitVO;
	}
	public CndCstmsManifestListVO[] getCndCstmsManifestListVOs() {
		CndCstmsManifestListVO[] rtnVOs = null;
		if (this.CndCstmsManifestListVOs != null) {
			rtnVOs = Arrays.copyOf(CndCstmsManifestListVOs, CndCstmsManifestListVOs.length);
		}
		return rtnVOs;
	}		
	

	private String key = "";
	public String getKey() {
		return key;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	private String pgmNo = null;
	
	/**
	 * 화면ID
	 * @return pgmNo
	 */
	public String getPgmNo () {
		return pgmNo; 
	}
	
	/**
	 * 화면ID세팅
	 * @param pgmNo
	 */
	public void setPgmNo(String pgmNo) {
		this.pgmNo = pgmNo;
	}

}
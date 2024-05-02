/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0484Event.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.08
 *@LastModifier : 경종윤
 *@LastVersion : 1.0
 * 2009.10.08 경종윤
 * 1.0 Creation
*--------------------------------------------------------
* History
 * 2011.02.23 이일민 [CHM-201108294] 구주 EU24 관련 SITPRO 수정 요청 (ENS Download 버튼 추가)
 * 2015.04.23 소스보안 [CWE-495,766] 관련 수정
 * 2015.10.06 소스보안 live반영
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo.EurManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProCargoManifestCondForEdiVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0484 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0484HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Kyoung Jong Yun
 * @see ESM_BKG_0484HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg0484Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private SitProCargoManifestCondForEdiVO sitProCargoManifestCondForEdiVO = null;

	private EurManifestTransmitVO[] euManifestTransmitVOs = null;
	
	private String key = "";
	private String[] bkgNos = null;
	
	/**
	 * @return the sitProCargoManifestCondForEdiVO
	 */
	public SitProCargoManifestCondForEdiVO getSitProCargoManifestCondForEdiVO() {
		return sitProCargoManifestCondForEdiVO;
	}

	/**
	 * @param sitProCargoManifestCondForEdiVO the sitProCargoManifestCondForEdiVO to set
	 */
	public void setSitProCargoManifestCondForEdiVO(
			SitProCargoManifestCondForEdiVO sitProCargoManifestCondForEdiVO) {
		this.sitProCargoManifestCondForEdiVO = sitProCargoManifestCondForEdiVO;
	}
	
	/**
	 * @return the euManifestTransmitVOs
	 */
	public EurManifestTransmitVO[] getEuManifestTransmitVOs() {
		EurManifestTransmitVO[] rtnVOs = null;
		if (this.euManifestTransmitVOs != null) {
			rtnVOs = Arrays.copyOf(euManifestTransmitVOs, euManifestTransmitVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param euManifestTransmitVOs the euManifestTransmitVOs to set
	 */
	public void setEuManifestTransmitVOs(EurManifestTransmitVO[] euManifestTransmitVOs){
		if(euManifestTransmitVOs != null){
			EurManifestTransmitVO[] tmpVOs = Arrays.copyOf(euManifestTransmitVOs, euManifestTransmitVOs.length);
			this.euManifestTransmitVOs = tmpVOs;
		}
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}
	
	/**
	 * @return the bkgNos
	 */
	public String[] getBkgNos() {
		String[] rtnVOs = null;
		if (this.bkgNos != null) {
			rtnVOs = Arrays.copyOf(bkgNos, bkgNos.length);
		}
		return rtnVOs;
	}

	/**
	 * @param bkgNos the bkgNos to set
	 */
	public void setBkgNos(String[] bkgNos){
		if(bkgNos != null){
			String[] tmpVOs = Arrays.copyOf(bkgNos, bkgNos.length);
			this.bkgNos = tmpVOs;
		}
	}

}

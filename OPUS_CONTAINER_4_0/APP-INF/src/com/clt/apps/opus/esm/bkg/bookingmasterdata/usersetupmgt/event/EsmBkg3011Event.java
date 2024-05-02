/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0320Event.java
 *@FileTitle : CndManifestListDownload
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.25
 *@LastModifier : 김경섭
 *@LastVersion : 1.0
 * 2009.05.25 김경섭
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.event;

import com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.vo.PlaceOfIssueAssociationVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0320 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0320HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author 김경섭
 * @see ESM_BKG_0320HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg3011Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String blEsigAsgnSeq;
	private String countryCode;
	private String blIssOfcNm;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private PlaceOfIssueAssociationVO placeOfIssueAssociationVO = null;

	/** Table Value Object Multi Data 처리 */
	private PlaceOfIssueAssociationVO[] placeOfIssueAssociationVOs = null;

	public String getBlEsigAsgnSeq() {
		return blEsigAsgnSeq;
	}

	public void setBlEsigAsgnSeq(String blEsigAsgnSeq) {
		this.blEsigAsgnSeq = blEsigAsgnSeq;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public PlaceOfIssueAssociationVO getPlaceOfIssueAssociationVO() {
		return placeOfIssueAssociationVO;
	}

	public void setBlIssOfcNm(String blIssOfcNm) {
		this.blIssOfcNm = blIssOfcNm;
	}

	public String getBlIssOfcNm() {
		return blIssOfcNm;
	}

	public void setPlaceOfIssueAssociationVO(PlaceOfIssueAssociationVO placeOfIssueAssociationVO) {
		this.placeOfIssueAssociationVO = placeOfIssueAssociationVO;
	}

//	public PlaceOfIssueAssociationVO[] getPlaceOfIssueAssociationVOs() {
//		return placeOfIssueAssociationVOs;
//	}

	//2015.04.10 Secure Coding 적용[CWE-496]
	public PlaceOfIssueAssociationVO[] getPlaceOfIssueAssociationVOs() {
		PlaceOfIssueAssociationVO[] tmpVOs = null;
		if (this.placeOfIssueAssociationVOs != null) {
			tmpVOs = new PlaceOfIssueAssociationVO[placeOfIssueAssociationVOs.length];
			System.arraycopy(placeOfIssueAssociationVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}	
	
//	public void setPlaceOfIssueAssociationVOs(PlaceOfIssueAssociationVO[] placeOfIssueAssociationVOs) {
//		this.placeOfIssueAssociationVOs = placeOfIssueAssociationVOs;
//	}
	
	//2015.04.10 Secure Coding 적용[CWE-496]
	public void setPlaceOfIssueAssociationVOs(PlaceOfIssueAssociationVO[] placeOfIssueAssociationVOs) {
		if (placeOfIssueAssociationVOs != null) {
			PlaceOfIssueAssociationVO[] tmpVOs = new PlaceOfIssueAssociationVO[placeOfIssueAssociationVOs.length];
			System.arraycopy(placeOfIssueAssociationVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.placeOfIssueAssociationVOs = tmpVOs;
		}		
	}		
}
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0029Event.java
 *@FileTitle : CndManifestListDownload
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.29
 *@LastModifier : 김민정
 *@LastVersion : 1.0
 * 2009.04.29 김민정
 * 1.0 Creation
 * 2012.09.04 변종건 [CHM-201219976-01] Split 01-Canada A/N 수정 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.event;

import java.util.Arrays;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsBlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsBlMainVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsBlVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0029 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0029HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Kim Min Jeong
 * @see ESM_BKG_0029HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0029Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 */
	private CndCstmsBlCondVO cndCstmsBlCondVO = null;
	/** 저장 VO */
	private CstmsBlVO[] cstmsBlVOs = null;
	/** 전송 VO */
	private ManifestTransmitVO manifestTransmitVO = null;
	private CndCstmsBlMainVO cndCstmsBlMainVO = null;
	private String podCd = null;
	private String delCd = null;
	private String custCntCd = null;
	private String custSeq = null;
	private String custTp = null;
	private String podNodCd = null;

	public EsmBkg0029Event() {}

	public void setCndCstmsBlCondVO(CndCstmsBlCondVO cndCstmsBlCondVO) {
		this.cndCstmsBlCondVO = cndCstmsBlCondVO;
	}

	public CndCstmsBlCondVO getCndCstmsBlCondVO() {
		return cndCstmsBlCondVO;
	}
	
	public void setCstmsBlVOs(CstmsBlVO[] cstmsBlVOs){
		if(cstmsBlVOs != null){
			CstmsBlVO[] tmpVOs = Arrays.copyOf(cstmsBlVOs, cstmsBlVOs.length);
			this.cstmsBlVOs = tmpVOs;
		}
	}

	public CstmsBlVO[] getCstmsBlVOs() {
		CstmsBlVO[] rtnVOs = null;
		if (this.cstmsBlVOs != null) {
			rtnVOs = Arrays.copyOf(cstmsBlVOs, cstmsBlVOs.length);
		}
		return rtnVOs;
	}
	
	public void setManifestTransmitVO(ManifestTransmitVO manifestTransmitVO) {
		this.manifestTransmitVO = manifestTransmitVO;
	}

	public ManifestTransmitVO getManifestTransmitVO() {
		return manifestTransmitVO;
	}
	
	public void setCndCstmsBlMainVO(CndCstmsBlMainVO cndCstmsBlMainVO) {
		this.cndCstmsBlMainVO = cndCstmsBlMainVO;
	}

	public CndCstmsBlMainVO getCndCstmsBlMainVO() {
		return cndCstmsBlMainVO;
	}
	
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	public String getPodCd() {
		return podCd;
	}
	
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	public String getDelCd() {
		return delCd;
	}
	
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	public String getCustSeq() {
		return this.custSeq;
	}
	
	public void setCustTp(String custTp) {
		this.custTp = custTp;
	}
	
	public String getCustTp() {
		return this.custTp;
	}

	public String getPodNodCd() {
		return podNodCd;
	}

	public void setPodNodCd(String podNodCd) {
		this.podNodCd = podNodCd;
	}
	
}
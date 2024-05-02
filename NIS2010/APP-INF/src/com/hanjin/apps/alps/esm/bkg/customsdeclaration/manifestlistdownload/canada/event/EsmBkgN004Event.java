/*=========================================================
 *Copyright(c) SMLines
 *@FileName : EsmBkgN004Event.java
 *@FileTitle : EsmBkgN004Event
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsBlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsBlMainVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsBlVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_N004 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_1572HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see ESM_BKG_1572HTMLAction 참조
 * @since
 */

public class EsmBkgN004Event extends EventSupport {

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

	public EsmBkgN004Event() {
	}

	public void setCndCstmsBlCondVO(CndCstmsBlCondVO cndCstmsBlCondVO) {
		this.cndCstmsBlCondVO = cndCstmsBlCondVO;
	}

	public CndCstmsBlCondVO getCndCstmsBlCondVO() {
		return cndCstmsBlCondVO;
	}

	public void setCstmsBlVOs(CstmsBlVO[] cstmsBlVOs) {
		if (cstmsBlVOs != null)
			this.cstmsBlVOs = Arrays.copyOf(cstmsBlVOs, cstmsBlVOs.length);
	}

	public CstmsBlVO[] getCstmsBlVOs() {
		CstmsBlVO[] rtnVOs = null;
		if (cstmsBlVOs != null)
			rtnVOs = Arrays.copyOf(cstmsBlVOs, cstmsBlVOs.length);
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
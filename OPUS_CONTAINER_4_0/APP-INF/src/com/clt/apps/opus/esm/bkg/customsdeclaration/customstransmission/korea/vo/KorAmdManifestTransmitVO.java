/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorAmdManifestTransmitVO.java
*@FileTitle : KorAmdManifestTransmitVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.08.11 박상훈
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.AmdManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorBlAmdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorCntrCorrVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorCorrListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorCustCorrVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorExpCorrVO;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박상훈
 * @since J2EE 1.6
 * @see AmdManifestTransmitVO
 */

public class KorAmdManifestTransmitVO extends AmdManifestTransmitVO {

	private static final long serialVersionUID = 1L;

	private String mode = null;
	private String polLoc = null;
	private String podLoc = null;
	private String userId = null;
	private String ofcCd = null;
	private String dmstPortCd = null;
	private String cTrnsSeq = null;

	private KorBlAmdVO 		 korBlAmdVO 	= null;
	private KorCntrCorrVO[] korCntrCorrVOs 	= null;
	private KorCustCorrVO   korCustCorrVO  = null;
	private KorExpCorrVO[]  korExpCorrVOs 	= null;
	private KorCorrListVO[] korCorrListVOs	= null;

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}


	/**
	 * @return the ofcCd
	 */
	public String getOfcCd() {
		return ofcCd;
	}

	/**
	 * Column Info
	 * @return dmstPortCd
	 */
	public String getDmstPortCd() {
		return this.dmstPortCd;
	}

	/**
	 * Column Info
	 * @return cTrnsSeq
	 */
	public String getCTrnsSeq() {
		return this.cTrnsSeq;
	}

	/**
	 * @param ofcCd the ofcCd to set
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}


	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * Column Info
	 * @param cTrnsSeq
	 */
	public void setCTrnsSeq(String cTrnsSeq) {
		this.cTrnsSeq = cTrnsSeq;
	}
	/**
	 * Column Info
	 * @param dmstPortCd
	 */
	public void setDmstPortCd(String dmstPortCd) {
		this.dmstPortCd = dmstPortCd;
	}

	/**
	 * @return the korCorrListVOs
	 */
	public KorCorrListVO[] getKorCorrListVOs() {
		return korCorrListVOs;
	}


	/**
	 * @param korCorrListVOs the korCorrListVOs to set
	 */
	public void setKorCorrListVOs(KorCorrListVO[] korCorrListVOs) {
		this.korCorrListVOs = korCorrListVOs;
	}


	/**
	 * @return the korBlAmdVO
	 */
	public KorBlAmdVO getKorBlAmdVO() {
		return korBlAmdVO;
	}


	/**
	 * @param korBlAmdVO the korBlAmdVO to set
	 */
	public void setKorBlAmdVO(KorBlAmdVO korBlAmdVO) {
		this.korBlAmdVO = korBlAmdVO;
	}


	/**
	 * @return the korCntrCorrVOs
	 */
	public KorCntrCorrVO[] getKorCntrCorrVOs() {
		return korCntrCorrVOs;
	}


	/**
	 * @param korCntrCorrVOs the korCntrCorrVOs to set
	 */
	public void setKorCntrCorrVOs(KorCntrCorrVO[] korCntrCorrVOs) {
		this.korCntrCorrVOs = korCntrCorrVOs;
	}


	/**
	 * @return the korCustCorrVO
	 */
	public KorCustCorrVO getKorCustCorrVO() {
		return korCustCorrVO;
	}


	/**
	 * @param korCustCorrVO the korCustCorrVO to set
	 */
	public void setKorCustCorrVO(KorCustCorrVO korCustCorrVO) {
		this.korCustCorrVO = korCustCorrVO;
	}


	/**
	 * @return the korExpCorrVOs
	 */
	public KorExpCorrVO[] getKorExpCorrVOs() {
		return korExpCorrVOs;
	}


	/**
	 * @param korExpCorrVOs the korExpCorrVOs to set
	 */
	public void setKorExpCorrVOs(KorExpCorrVO[] korExpCorrVOs) {
		this.korExpCorrVOs = korExpCorrVOs;
	}

	/**
	 * @return the mode
	 */
	public String getMode() {
		return mode;
	}


	/**
	 * @param mode the mode to set
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}


	/**
	 * @return the polLoc
	 */
	public String getPolLoc() {
		return polLoc;
	}


	/**
	 * @param polLoc the polLoc to set
	 */
	public void setPolLoc(String polLoc) {
		this.polLoc = polLoc;
	}


	/**
	 * @return the podLoc
	 */
	public String getPodLoc() {
		return podLoc;
	}


	/**
	 * @param podLoc the podLoc to set
	 */
	public void setPodLoc(String podLoc) {
		this.podLoc = podLoc;
	}


	public KorAmdManifestTransmitVO() {}
}

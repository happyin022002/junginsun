/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileTitle : <Kor24AmdManifestTransmitVO.java
*@FileTitle : Kor24AmdManifestTransmitVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.08.11 박상훈
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.AmdManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24BlAmdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24CntrCorrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24CorrListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24CustCorrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24ExpCorrVO;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박상훈
 * @since J2EE 1.6
 * @see AmdManifestTransmitVO
 */

public class Kor24AmdManifestTransmitVO extends AmdManifestTransmitVO {

	private static final long serialVersionUID = 1L;

	private String mode = null;
	private String polLoc = null;
	private String podLoc = null;
	private String userId = null;
	private String ofcCd = null;
	private String dmstPortCd = null;
	private String cTrnsSeq = null;

	private Kor24BlAmdVO 		 korBlAmdVO 	= null;
	private Kor24CntrCorrVO[] korCntrCorrVOs 	= null;
	private Kor24CustCorrVO   korCustCorrVO  = null;
	private Kor24ExpCorrVO[]  korExpCorrVOs 	= null;
	private Kor24CorrListVO[] korCorrListVOs	= null;

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
	public Kor24CorrListVO[] getKor24CorrListVOs() {
		return korCorrListVOs;
	}


	/**
	 * @param korCorrListVOs the korCorrListVOs to set
	 */
	public void setKor24CorrListVOs(Kor24CorrListVO[] korCorrListVOs) {
		this.korCorrListVOs = korCorrListVOs;
	}


	/**
	 * @return the korBlAmdVO
	 */
	public Kor24BlAmdVO getKor24BlAmdVO() {
		return korBlAmdVO;
	}


	/**
	 * @param korBlAmdVO the korBlAmdVO to set
	 */
	public void setKor24BlAmdVO(Kor24BlAmdVO korBlAmdVO) {
		this.korBlAmdVO = korBlAmdVO;
	}


	/**
	 * @return the korCntrCorrVOs
	 */
	public Kor24CntrCorrVO[] getKor24CntrCorrVOs() {
		return korCntrCorrVOs;
	}


	/**
	 * @param korCntrCorrVOs the korCntrCorrVOs to set
	 */
	public void setKor24CntrCorrVOs(Kor24CntrCorrVO[] korCntrCorrVOs) {
		this.korCntrCorrVOs = korCntrCorrVOs;
	}


	/**
	 * @return the korCustCorrVO
	 */
	public Kor24CustCorrVO getKor24CustCorrVO() {
		return korCustCorrVO;
	}


	/**
	 * @param korCustCorrVO the korCustCorrVO to set
	 */
	public void setKor24CustCorrVO(Kor24CustCorrVO korCustCorrVO) {
		this.korCustCorrVO = korCustCorrVO;
	}


	/**
	 * @return the korExpCorrVOs
	 */
	public Kor24ExpCorrVO[] getKor24ExpCorrVOs() {
		return korExpCorrVOs;
	}


	/**
	 * @param korExpCorrVOs the korExpCorrVOs to set
	 */
	public void setKor24ExpCorrVOs(Kor24ExpCorrVO[] korExpCorrVOs) {
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


	public Kor24AmdManifestTransmitVO() {}
}

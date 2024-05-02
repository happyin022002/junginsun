/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : EsdTrs0300Event.java
 *@FileTitle :Bidding Candidate
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.06.01
 *@LastModifier : SHIN DONG IL
 *@LastVersion : 1.0
 * 2015.06.01 SHIN DONG IL
 * 1.0 최초 생성
 *----------------------------------------------------------
 * History
=========================================================*/
package com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidateregistration.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidateregistration.vo.BiddingCandidateRegistrationVO;
import com.hanjin.apps.alps.esd.trs.report.pnlreport.vo.PnLRptOptionVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_TRS_0300 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_0300HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SHIN DONG IL
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsdTrs0300Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	String spotBidCnddtTermSeq	= null;
	String vndrSeq				= null;
	String creUsrId				= null;
	String creOfcCd				= null;
	String spotBidOfcCd			= null;
	String trspCrrModCd			= null;
	
	BiddingCandidateRegistrationVO[] biddingCandidateRegistrationVOs;

	/**
	 * @return the spotBidCnddtTermSeq
	 */
	public String getSpotBidCnddtTermSeq() {
		return spotBidCnddtTermSeq;
	}

	/**
	 * @param spotBidCnddtTermSeq the spotBidCnddtTermSeq to set
	 */
	public void setSpotBidCnddtTermSeq(String spotBidCnddtTermSeq) {
		this.spotBidCnddtTermSeq = spotBidCnddtTermSeq;
	}

	/**
	 * @return the vndrSeq
	 */
	public String getVndrSeq() {
		return vndrSeq;
	}

	/**
	 * @param vndrSeq the vndrSeq to set
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}

	/**
	 * @return the spotBidOfcCd
	 */
	public String getSpotBidOfcCd() {
		return spotBidOfcCd;
	}

	/**
	 * @return the creUsrId
	 */
	public String getCreUsrId() {
		return creUsrId;
	}

	/**
	 * @param creUsrId the creUsrId to set
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	/**
	 * @return the creOfcCd
	 */
	public String getCreOfcCd() {
		return creOfcCd;
	}

	/**
	 * @param creOfcCd the creOfcCd to set
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}

	/**
	 * @param spotBidOfcCd the spotBidOfcCd to set
	 */
	public void setSpotBidOfcCd(String spotBidOfcCd) {
		this.spotBidOfcCd = spotBidOfcCd;
	}

	/**
	 * @return the trspCrrModCd
	 */
	public String getTrspCrrModCd() {
		return trspCrrModCd;
	}

	/**
	 * @param trspCrrModCd the trspCrrModCd to set
	 */
	public void setTrspCrrModCd(String trspCrrModCd) {
		this.trspCrrModCd = trspCrrModCd;
	}

	/**
	 * @return the biddingCandidateRegistrationVOs
	 */
	public BiddingCandidateRegistrationVO[] getBiddingCandidateRegistrationVOs() {
		BiddingCandidateRegistrationVO[] rtnVOs = null;
		if (this.biddingCandidateRegistrationVOs != null) {
			rtnVOs = Arrays.copyOf(biddingCandidateRegistrationVOs, biddingCandidateRegistrationVOs.length);
		}
		return rtnVOs;  //return biddingCandidateRegistrationVOs;
	}

	/**
	 * @param biddingCandidateRegistrationVOs the biddingCandidateRegistrationVOs to set
	 */
	public void setBiddingCandidateRegistrationVOs(BiddingCandidateRegistrationVO[] biddingCandidateRegistrationVOs) {
		if(biddingCandidateRegistrationVOs != null){
			BiddingCandidateRegistrationVO[] tmpVOs = Arrays.copyOf(biddingCandidateRegistrationVOs, biddingCandidateRegistrationVOs.length);
			this.biddingCandidateRegistrationVOs = tmpVOs;  //this.biddingCandidateRegistrationVOs = biddingCandidateRegistrationVOs;
		}
	}
}
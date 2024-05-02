/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1025Event.java
*@FileTitle : Booking split_TRO/O Split
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.06.16 최영희
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.TroSplitVO;


/**
 * ESM_BKG_1025 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1025HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Yeoung Hee
 * @see ESM_BKG_1025HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1025Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private TroSplitVO troSplitVO = null;

	/** Table Value Object Multi Data 처리 */
	private TroSplitVO[] troSplitVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgBlNoVO bkgBlNoVO = null;
	/** Table Value Object Multi Data 처리 */
	private BkgBlNoVO[] bkgBlNoVOs = null;

	private String splitCnt = null;
	private String splitReason = null;
	private String splitCntrSplitNo = null;
	private String lastSplitNo = null;
	private String orgSplit = null;
	private String validateSplitNo = null;
	private String bkgSplitNo = null;

	public EsmBkg1025Event(){}

	public TroSplitVO getTroSplitVO() {
		return troSplitVO;
	}

	public void setTroSplitVO(TroSplitVO troSplitVO) {
		this.troSplitVO = troSplitVO;
	}

	public TroSplitVO[] getTroSplitVOs() {
		return troSplitVOs;
	}

	public void setTroSplitVOs(TroSplitVO[] troSplitVOs) {
		this.troSplitVOs = troSplitVOs;
	}

	public BkgBlNoVO getBkgBlNoVO() {
		return bkgBlNoVO;
	}

	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO) {
		this.bkgBlNoVO = bkgBlNoVO;
	}

	public BkgBlNoVO[] getBkgBlNoVOs() {
		return bkgBlNoVOs;
	}

	public void setBkgBlNoVOs(BkgBlNoVO[] bkgBlNoVOs) {
		this.bkgBlNoVOs = bkgBlNoVOs;
	}


	public String getSplitCnt() {
		return splitCnt;
	}

	public void setSplitCnt(String splitCnt) {
		this.splitCnt = splitCnt;
	}

	public String getSplitReason() {
		return splitReason;
	}

	public void setSplitReason(String splitReason) {
		this.splitReason = splitReason;
	}

	public String getSplitCntrSplitNo() {
		return splitCntrSplitNo;
	}

	public void setSplitCntrSplitNo(String splitCntrSplitNo) {
		this.splitCntrSplitNo = splitCntrSplitNo;
	}

	public String getLastSplitNo() {
		return lastSplitNo;
	}

	public void setLastSplitNo(String lastSplitNo) {
		this.lastSplitNo = lastSplitNo;
	}

	public String getOrgSplit() {
		return orgSplit;
	}

	public void setOrgSplit(String orgSplit) {
		this.orgSplit = orgSplit;
	}

	public String getValidateSplitNo() {
		return validateSplitNo;
	}

	public void setValidateSplitNo(String validateSplitNo) {
		this.validateSplitNo = validateSplitNo;
	}

	public String getBkgSplitNo() {
		return bkgSplitNo;
	}

	public void setBkgSplitNo(String bkgSplitNo) {
		this.bkgSplitNo = bkgSplitNo;
	}


}
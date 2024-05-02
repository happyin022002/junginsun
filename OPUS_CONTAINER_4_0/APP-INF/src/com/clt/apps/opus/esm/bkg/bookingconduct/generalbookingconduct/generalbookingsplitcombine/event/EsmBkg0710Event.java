/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0710Event.java
*@FileTitle : RF Cargo Split
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.06.16 최영희
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.RfSplitVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0710 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0710HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Yeoung Hee
 * @see ESM_BKG_0710HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0710Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private RfSplitVO rfSplitVO = null;

	/** Table Value Object Multi Data 처리 */
	private RfSplitVO[] rfSplitVOs = null;

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
	private String cntrExists = null;
	private String cntrPopExists = null;

	public EsmBkg0710Event(){}

	public RfSplitVO getRfSplitVO() {
		return rfSplitVO;
	}

	public void setRfSplitVO(RfSplitVO rfSplitVO) {
		this.rfSplitVO = rfSplitVO;
	}

	public RfSplitVO[] getRfSplitVOs() {
		RfSplitVO[] tmpVOs = null;
		if (this. rfSplitVOs != null) {
			tmpVOs = Arrays.copyOf(rfSplitVOs, rfSplitVOs .length);
		}
		return tmpVOs;
	}

	public void setRfSplitVOs(RfSplitVO[] rfSplitVOs) {
		if (rfSplitVOs != null) {
			RfSplitVO[] tmpVOs = Arrays.copyOf(rfSplitVOs, rfSplitVOs .length);
			this. rfSplitVOs = tmpVOs;
		}
	}

	public BkgBlNoVO getBkgBlNoVO() {
		return bkgBlNoVO;
	}

	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO) {
		this.bkgBlNoVO = bkgBlNoVO;
	}

	public BkgBlNoVO[] getBkgBlNoVOs() {
		BkgBlNoVO[] tmpVOs = null;
		if (this. bkgBlNoVOs != null) {
			tmpVOs = Arrays.copyOf(bkgBlNoVOs, bkgBlNoVOs .length);
		}
		return tmpVOs;
	}

	public void setBkgBlNoVOs(BkgBlNoVO[] bkgBlNoVOs) {
		if (bkgBlNoVOs != null) {
			BkgBlNoVO[] tmpVOs = Arrays.copyOf(bkgBlNoVOs, bkgBlNoVOs .length);
			this. bkgBlNoVOs = tmpVOs;
		}
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

	public String getCntrExists() {
		return cntrExists;
	}

	public void setCntrExists(String cntrExists) {
		this.cntrExists = cntrExists;
	}

	public String getCntrPopExists() {
		return cntrPopExists;
	}

	public void setCntrPopExists(String cntrPopExists) {
		this.cntrPopExists = cntrPopExists;
	}



}
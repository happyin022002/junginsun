/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0099Event.java
*@FileTitle : Booking Split
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.18
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.06.18 최영희
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SplitBkgVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.BkgForSplitVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0099 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0099HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Yeoung Hee
 * @see ESM_BKG_0099HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0099Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgForSplitVO bkgBlForSplitVO = null;

	/** Table Value Object Multi Data 처리 */
	private BkgForSplitVO[] bkgBlForSplitVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgBlNoVO bkgBlNoVO = null;
	/** Table Value Object Multi Data 처리 */
	private BkgBlNoVO[] bkgBlNoVOs = null;

	private SplitBkgVO splitBkgVO = null;
	private SplitBkgVO[] splitBkgVOs = null;

	private BkgBlNoVO sourceBkg=null;
	private BkgBlNoVO[] targetBkg = null;
	private String localTime = null;
	private String codFlag = null;
	private int pcIdx=0;
	private String pcMode=null;
	private String caRsnCd= null;
	private String caRemark = null;
	private String troTp = null;
	private String currSplitBkg = null;
	private String lastTarget = null;
	
	public EsmBkg0099Event(){}


	public BkgForSplitVO getBkgBlForSplitVO() {
		return bkgBlForSplitVO;
	}


	public void setBkgBlForSplitVO(BkgForSplitVO bkgBlForSplitVO) {
		this.bkgBlForSplitVO = bkgBlForSplitVO;
	}



	public BkgForSplitVO[] getBkgBlForSplitVOs() {
		BkgForSplitVO[] tmpVOs = null;
		if (this. bkgBlForSplitVOs != null) {
			tmpVOs = Arrays.copyOf(bkgBlForSplitVOs, bkgBlForSplitVOs .length);
		}
		return tmpVOs;
	}



	public void setBkgBlForSplitVOs(BkgForSplitVO[] bkgBlForSplitVOs) {
		if (bkgBlForSplitVOs != null) {
			BkgForSplitVO[] tmpVOs = Arrays.copyOf(bkgBlForSplitVOs, bkgBlForSplitVOs .length);
			this. bkgBlForSplitVOs = tmpVOs;
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


	public SplitBkgVO getSplitBkgVO() {
		return splitBkgVO;
	}


	public void setSplitBkgVO(SplitBkgVO splitBkgVO) {
		this.splitBkgVO = splitBkgVO;
	}


	public SplitBkgVO[] getSplitBkgVOs() {
		SplitBkgVO[] tmpVOs = null;
		if (this. splitBkgVOs != null) {
			tmpVOs = Arrays.copyOf(splitBkgVOs, splitBkgVOs .length);
		}
		return tmpVOs;
	}


	public void setSplitBkgVOs(SplitBkgVO[] splitBkgVOs) {
		if (splitBkgVOs != null) {
			SplitBkgVO[] tmpVOs = Arrays.copyOf(splitBkgVOs, splitBkgVOs .length);
			this. splitBkgVOs = tmpVOs;
		}
	}


	public BkgBlNoVO getSourceBkg() {
		return sourceBkg;
	}


	public void setSourceBkg(BkgBlNoVO sourceBkg) {
		this.sourceBkg = sourceBkg;
	}


	public BkgBlNoVO[] getTargetBkg() {
		BkgBlNoVO[] tmpVOs = null;
		if (this. targetBkg != null) {
			tmpVOs = Arrays.copyOf(targetBkg, targetBkg .length);
		}
		return tmpVOs;
	}


	public void setTargetBkg(BkgBlNoVO[] targetBkg) {
		if (targetBkg != null) {
			BkgBlNoVO[] tmpVOs = Arrays.copyOf(targetBkg, targetBkg .length);
			this. targetBkg = tmpVOs;
		}
	}


	public String getLocalTime() {
		return localTime;
	}


	public void setLocalTime(String localTime) {
		this.localTime = localTime;
	}


	public String getCodFlag() {
		return codFlag;
	}


	public void setCodFlag(String codFlag) {
		this.codFlag = codFlag;
	}


	public int getPcIdx() {
		return pcIdx;
	}


	public void setPcIdx(int pcIdx) {
		this.pcIdx = pcIdx;
	}


	public String getPcMode() {
		return pcMode;
	}


	public void setPcMode(String pcMode) {
		this.pcMode = pcMode;
	}


	public String getCaRsnCd() {
		return caRsnCd;
	}


	public void setCaRsnCd(String caRsnCd) {
		this.caRsnCd = caRsnCd;
	}


	public String getCaRemark() {
		return caRemark;
	}


	public void setCaRemark(String caRemark) {
		this.caRemark = caRemark;
	}

	public String getTroTp() {
		return troTp;
	}

	public void setTroTp(String troTp) {
		this.troTp = troTp;
	}

	public String getCurrSplitBkg() {
		return currSplitBkg;
	}

	public void setCurrSplitBkg(String currSplitBkg) {
		this.currSplitBkg = currSplitBkg;
	}


	public String getLastTarget() {
		return lastTarget;
	}


	public void setLastTarget(String lastTarget) {
		this.lastTarget = lastTarget;
	}



}
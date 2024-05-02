/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0997Event.java
*@FileTitle : COD Comfirm Pop-up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.08.06 최영희
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.event;

import java.util.Arrays;
import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SplitBkgVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodSplitVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgCodVvdVO;


/**
 * ESM_BKG_0997 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0997HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Choi Yeoung Hee
 * @see ESM_BKG_0997HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0997Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	 
	
	private CodSplitVO codSplitVO = null;
	private CodSplitVO[] codSplitVOs = null;

	private BkgBlNoVO bkgBlNoVO = null;
	private BkgBlNoVO[] bkgBlNoVOs = null; 
	private SplitBkgVO splitBkgVO = null;
	private SplitBkgVO[] splitBkgVOs = null;
	
	private BkgBlNoVO sourceBkg=null;
	private BkgBlNoVO[] targetBkg = null;
	private List<BkgCodVvdVO> bkgCodVvdVO = null;
	private BkgCodVvdVO[] bkgCodVvdVOs = null;
	private String codRqstSeq = null;
	private String localTime = null;
	private String codFlag = null;
	private String codCntrNo = null;
	private String codDg = null;
	private String codBb = null;
	private String codAk = null;
	private String codRf = null;
	private String tvvd = null;
	private String codRqstRsnCd = null;
	private String caRsnCd = null;
	private String caRemark = null;
	
	
	public EsmBkg0997Event(){}

	public CodSplitVO getCodSplitVO() {
		return codSplitVO;
	}

	public void setCodSplitVO(CodSplitVO codSplitVO) {
		this.codSplitVO = codSplitVO;
	}

	public CodSplitVO[] getCodSplitVOs() {
		CodSplitVO[] rtnVOs = null;
		if (this.codSplitVOs != null) {
			rtnVOs = Arrays.copyOf(codSplitVOs, codSplitVOs.length);
		}
		return rtnVOs;
	}

	public void setCodSplitVOs(CodSplitVO[] codSplitVOs) {
		if(codSplitVOs != null){
			CodSplitVO[] tmpVOs = Arrays.copyOf(codSplitVOs, codSplitVOs.length);
			this.codSplitVOs = tmpVOs;
		}
	}

	public BkgBlNoVO getBkgBlNoVO() {
		return bkgBlNoVO;
	}

	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO) {
		this.bkgBlNoVO = bkgBlNoVO;
	}

	public BkgBlNoVO[] getBkgBlNoVOs() {
		BkgBlNoVO[] rtnVOs = null;
		if (this.bkgBlNoVOs != null) {
			rtnVOs = Arrays.copyOf(bkgBlNoVOs, bkgBlNoVOs.length);
		}
		return rtnVOs;
	}

	public void setBkgBlNoVOs(BkgBlNoVO[] bkgBlNoVOs) {
		if(bkgBlNoVOs != null){
			BkgBlNoVO[] tmpVOs = Arrays.copyOf(bkgBlNoVOs, bkgBlNoVOs.length);
			this.bkgBlNoVOs = tmpVOs;
		}
	}

	public BkgBlNoVO getSourceBkg() {
		return sourceBkg;
	}

	public void setSourceBkg(BkgBlNoVO sourceBkg) {
		this.sourceBkg = sourceBkg;
	}

	public BkgBlNoVO[] getTargetBkg() {
		BkgBlNoVO[] rtnVOs = null;
		if (this.targetBkg != null) {
			rtnVOs = Arrays.copyOf(targetBkg, targetBkg.length);
		}
		return rtnVOs;
	}

	public void setTargetBkg(BkgBlNoVO[] targetBkg) {
		if(targetBkg != null){
			BkgBlNoVO[] tmpVOs = Arrays.copyOf(targetBkg, targetBkg.length);
			this.targetBkg = tmpVOs;
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

	public String getCodRqstSeq() {
		return codRqstSeq;
	}

	public void setCodRqstSeq(String codRqstSeq) {
		this.codRqstSeq = codRqstSeq;
	}

	public SplitBkgVO getSplitBkgVO() {
		return splitBkgVO;
	}

	public void setSplitBkgVO(SplitBkgVO splitBkgVO) {
		this.splitBkgVO = splitBkgVO;
	}

	public SplitBkgVO[] getSplitBkgVOs() {
		SplitBkgVO[] rtnVOs = null;
		if (this.splitBkgVOs != null) {
			rtnVOs = Arrays.copyOf(splitBkgVOs, splitBkgVOs.length);
		}
		return rtnVOs;
	}

	public void setSplitBkgVOs(SplitBkgVO[] splitBkgVOs) {
		if(splitBkgVOs != null){
			SplitBkgVO[] tmpVOs = Arrays.copyOf(splitBkgVOs, splitBkgVOs.length);
			this.splitBkgVOs = tmpVOs;
		}
	}

	public List<BkgCodVvdVO> getBkgCodVvdVO() {
		return bkgCodVvdVO;
	}

	public void setBkgCodVvdVO(List<BkgCodVvdVO> bkgCodVvdVO) {
		this.bkgCodVvdVO = bkgCodVvdVO;
	}

	public BkgCodVvdVO[] getBkgCodVvdVOs() {
		BkgCodVvdVO[] rtnVOs = null;
		if (this.bkgCodVvdVOs != null) {
			rtnVOs = Arrays.copyOf(bkgCodVvdVOs, bkgCodVvdVOs.length);
		}
		return rtnVOs;
	}

	public void setBkgCodVvdVOs(BkgCodVvdVO[] bkgCodVvdVOs) {
		if(bkgCodVvdVOs != null){
			BkgCodVvdVO[] tmpVOs = Arrays.copyOf(bkgCodVvdVOs, bkgCodVvdVOs.length);
			this.bkgCodVvdVOs = tmpVOs;
		}
	}

	public String getCodCntrNo() {
		return codCntrNo;
	}

	public void setCodCntrNo(String codCntrNo) {
		this.codCntrNo = codCntrNo;
	}

	public String getCodDg() {
		return codDg;
	}

	public void setCodDg(String codDg) {
		this.codDg = codDg;
	}

	public String getCodBb() {
		return codBb;
	}

	public void setCodBb(String codBb) {
		this.codBb = codBb;
	}

	public String getCodAk() {
		return codAk;
	}

	public void setCodAk(String codAk) {
		this.codAk = codAk;
	}

	public String getCodRf() {
		return codRf;
	}

	public void setCodRf(String codRf) {
		this.codRf = codRf;
	}

	public String getTvvd() {
		return tvvd;
	}

	public void setTvvd(String tvvd) {
		this.tvvd = tvvd;
	}

	public String getCodRqstRsnCd() {
		return codRqstRsnCd;
	}

	public void setCodRqstRsnCd(String codRqstRsnCd) {
		this.codRqstRsnCd = codRqstRsnCd;
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
    
	 
	 

}
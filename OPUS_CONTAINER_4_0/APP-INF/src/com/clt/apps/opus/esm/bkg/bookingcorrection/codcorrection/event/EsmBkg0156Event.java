/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0156Event.java
*@FileTitle : COD Application at BKG Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.27
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.07.27 최영희
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.BkgCODMgtConditionVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodAuthVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodMailSendVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgEmlEdtVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0156 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0156HTMLAction에서 작성<br> 
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Yeoung Hee
 * @see ESM_BKG_0156HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0156Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgBlNoVO bkgBlNoVO = null;
	private CodMailSendVO codMailSendVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgBlNoVO[] bkgBlNoVOs = null;
	private BkgEmlEdtVO bkgEmlEdtVO = null;	
	private CodMailSendVO[] codMailSendVOs = null;
	private CodVO codVO = null;
	private CodVO[] codVOs = null;
	private CodAuthVO codAuthVO = null;
	private CodAuthVO[] codAuthVOs = null; 
	private BkgCODMgtConditionVO bkgCODMgtConditionVO = null;
	private String[] ntcKndCd = null;
	private String[] eml = null;
	private String[] remark = null;
	
	private String codRqstSeq = null;
	private String codRemark = null;
	private String codRjctRsnRmk = null;
	private String saveModeCd = null;
	private String confirmModeCd = null;
	private String oldBkgNo = null;
	private String oldBkgNoSplit = null;
	private String oldBlNo = null;
	private String oldCodRqstSeq = null;
	private String codStsCd = null;
	private String codRqstRsnCd = null;
	private String popFlg = null;
	private String chgRmk = null;
	private String bdrFlag=null;
	private String rgnCd = null;
	private String caRsnCd = null;
	private String caRemark = null;
	

	
	
	public EsmBkg0156Event(){}

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
	
	public CodMailSendVO getCodMailSendVO() {
		return codMailSendVO;
	}

	public void setCodMailSendVO(CodMailSendVO codMailSendVO) {
		this.codMailSendVO = codMailSendVO;
	}

	public CodMailSendVO[] getCodMailSendVOs() {
		CodMailSendVO[] rtnVOs = null;
		if (this.codMailSendVOs != null) {
			rtnVOs = Arrays.copyOf(codMailSendVOs, codMailSendVOs.length);
		}
		return rtnVOs;
	}

	public void setCodMailSendVOs(CodMailSendVO[] codMailSendVOs) {
		if(codMailSendVOs != null){
			CodMailSendVO[] tmpVOs = Arrays.copyOf(codMailSendVOs, codMailSendVOs.length);
			this.codMailSendVOs = tmpVOs;
		}
	}

	public String getCodRqstSeq() {
		return codRqstSeq;
	}

	public void setCodRqstSeq(String codRqstSeq) {
		this.codRqstSeq = codRqstSeq;
	}

	public String getSaveModeCd() {
		return saveModeCd;
	}

	public void setSaveModeCd(String saveModeCd) {
		this.saveModeCd = saveModeCd;
	}

	public String getConfirmModeCd() {
		return confirmModeCd;
	}

	public void setConfirmModeCd(String confirmModeCd) {
		this.confirmModeCd = confirmModeCd;
	}

	public String getOldBkgNo() {
		return oldBkgNo;
	}

	public void setOldBkgNo(String oldBkgNo) {
		this.oldBkgNo = oldBkgNo;
	}

	public String getOldBkgNoSplit() {
		return oldBkgNoSplit;
	}

	public void setOldBkgNoSplit(String oldBkgNoSplit) {
		this.oldBkgNoSplit = oldBkgNoSplit;
	}

	public String getOldBlNo() {
		return oldBlNo;
	}

	public void setOldBlNo(String oldBlNo) {
		this.oldBlNo = oldBlNo;
	}

	public String getOldCodRqstSeq() {
		return oldCodRqstSeq;
	}

	public void setOldCodRqstSeq(String oldCodRqstSeq) {
		this.oldCodRqstSeq = oldCodRqstSeq;
	}

	public String getCodStsCd() {
		return codStsCd;
	}

	public void setCodStsCd(String codStsCd) {
		this.codStsCd = codStsCd;
	}

	public String getCodRemark() {
		return codRemark;
	}

	public void setCodRemark(String codRemark) {
		this.codRemark = codRemark;
	}

	public String getCodRjctRsnRmk() {
		return codRjctRsnRmk;
	}

	public void setCodRjctRsnRmk(String codRjctRsnRmk) {
		this.codRjctRsnRmk = codRjctRsnRmk;
	}

	public CodVO getCodVO() {
		return codVO;
	}

	public void setCodVO(CodVO codVO) {
		this.codVO = codVO;
	}

	public CodVO[] getCodVOs() {
		CodVO[] rtnVOs = null;
		if (this.codVOs != null) {
			rtnVOs = Arrays.copyOf(codVOs, codVOs.length);
		}
		return rtnVOs;
	}

	public void setCodVOs(CodVO[] codVOs) {
		if(codVOs != null){
			CodVO[] tmpVOs = Arrays.copyOf(codVOs, codVOs.length);
			this.codVOs = tmpVOs;
		}
	}

	public String getCodRqstRsnCd() {
		return codRqstRsnCd;
	}

	public void setCodRqstRsnCd(String codRqstRsnCd) {
		this.codRqstRsnCd = codRqstRsnCd;
	}

	public String getPopFlg() {
		return popFlg;
	}

	public void setPopFlg(String popFlg) {
		this.popFlg = popFlg;
	}

	public CodAuthVO getCodAuthVO() {
		return codAuthVO;
	}

	public void setCodAuthVO(CodAuthVO codAuthVO) {
		this.codAuthVO = codAuthVO;
	}

	public CodAuthVO[] getCodAuthVOs() {
		CodAuthVO[] rtnVOs = null;
		if (this.codAuthVOs != null) {
			rtnVOs = Arrays.copyOf(codAuthVOs, codAuthVOs.length);
		}
		return rtnVOs;
	}

	public void setCodAuthVOs(CodAuthVO[] codAuthVOs) {
		if(codAuthVOs != null){
			CodAuthVO[] tmpVOs = Arrays.copyOf(codAuthVOs, codAuthVOs.length);
			this.codAuthVOs = tmpVOs;
		}
	}

	public String getChgRmk() {
		return chgRmk;
	}

	public void setChgRmk(String chgRmk) {
		this.chgRmk = chgRmk;
	}

	public String getBdrFlag() {
		return bdrFlag;
	}

	public void setBdrFlag(String bdrFlag) {
		this.bdrFlag = bdrFlag;
	}

	public String getRgnCd() {
		return rgnCd;
	}

	public void setRgnCd(String rgnCd) {
		this.rgnCd = rgnCd;
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
	public BkgEmlEdtVO getBkgEmlEdtVO() {
		return bkgEmlEdtVO;
	}
	public void setBkgEmlEdtVO(BkgEmlEdtVO bkgEmlEdtVO) {
		this.bkgEmlEdtVO = bkgEmlEdtVO;
	}
	public String[] getNtcKndCd() {
		String[] tmpVOs = null;
		if (this. ntcKndCd != null) {
			tmpVOs = Arrays.copyOf(ntcKndCd, ntcKndCd .length);
		}
		return tmpVOs;
	}

	public void setNtcKndCd(String[] ntcKndCd) {
		if (ntcKndCd != null) {
			String[] tmpVOs = Arrays.copyOf(ntcKndCd, ntcKndCd .length);
			this. ntcKndCd = tmpVOs;
		}
	}
	public String[] getEml() {
		String[] tmpVOs = null;
		if (this. eml != null) {
			tmpVOs = Arrays.copyOf(eml, eml .length);
		}
		return tmpVOs;
	}

	public void setEml(String[] eml) {
		if (eml != null) {
			String[] tmpVOs = Arrays.copyOf(eml, eml .length);
			this. eml = tmpVOs;
		}
	}

	public String[] getRemark() {
		String[] tmpVOs = null;
		if (this. remark != null) {
			tmpVOs = Arrays.copyOf(remark, remark .length);
		}
		return tmpVOs;
	}

	public void setRemark(String[] remark) {
		if (remark != null) {
			String[] tmpVOs = Arrays.copyOf(remark, remark .length);
			this. remark = tmpVOs;
		}
	}
	public void setBkgCODMgtConditionVO(BkgCODMgtConditionVO bkgCODMgtConditionVO) {
		this.bkgCODMgtConditionVO = bkgCODMgtConditionVO;
	}
	
	public BkgCODMgtConditionVO getBkgCODMgtConditionVO() {
		return bkgCODMgtConditionVO;
	}
}
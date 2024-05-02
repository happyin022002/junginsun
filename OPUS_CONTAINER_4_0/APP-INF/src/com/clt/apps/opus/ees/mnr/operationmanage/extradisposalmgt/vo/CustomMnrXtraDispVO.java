/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CustomMnrXtraDispVO.java
*@FileTitle : CustomMnrXtraDispVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.02
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2010.03.02 김완규 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.operationmanage.extradisposalmgt.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김완규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomMnrXtraDispVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomMnrXtraDispVO> models = new ArrayList<CustomMnrXtraDispVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String xtraDispRmk = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String mnrXtraDispTpCd = null;
	/* Column Info */
	private String issOfcCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String xtraDispIncmAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String xtraDispSeq = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String xtraDispStsCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String issDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String issYdCd = null;
	/* Column Info */
	private String xtraDispDesc = null;
	/* Column Info */
	private String fileSeq = null;
	/* Column Info */
	private String xtraDispExpnAmt = null;
	/* Column Info */
	private String ifTrcSeq = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CustomMnrXtraDispVO() {}

	public CustomMnrXtraDispVO(String ibflag, String pagerows, String updDt, String xtraDispRmk, String currCd, String mnrXtraDispTpCd, String issOfcCd, String creDt, String eqKndCd, String xtraDispIncmAmt, String xtraDispSeq, String eqTpszCd, String xtraDispStsCd, String issDt, String creUsrId, String eqNo, String xtraDispDesc, String issYdCd, String fileSeq, String xtraDispExpnAmt, String updUsrId, String ifTrcSeq, String ofcCd) {
		this.updDt = updDt;
		this.xtraDispRmk = xtraDispRmk;
		this.currCd = currCd;
		this.mnrXtraDispTpCd = mnrXtraDispTpCd;
		this.issOfcCd = issOfcCd;
		this.creDt = creDt;
		this.eqKndCd = eqKndCd;
		this.xtraDispIncmAmt = xtraDispIncmAmt;
		this.pagerows = pagerows;
		this.xtraDispSeq = xtraDispSeq;
		this.eqTpszCd = eqTpszCd;
		this.xtraDispStsCd = xtraDispStsCd;
		this.ofcCd = ofcCd;
		this.issDt = issDt;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.issYdCd = issYdCd;
		this.xtraDispDesc = xtraDispDesc;
		this.fileSeq = fileSeq;
		this.xtraDispExpnAmt = xtraDispExpnAmt;
		this.ifTrcSeq = ifTrcSeq;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("xtra_disp_rmk", getXtraDispRmk());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("mnr_xtra_disp_tp_cd", getMnrXtraDispTpCd());
		this.hashColumns.put("iss_ofc_cd", getIssOfcCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("xtra_disp_incm_amt", getXtraDispIncmAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("xtra_disp_seq", getXtraDispSeq());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("xtra_disp_sts_cd", getXtraDispStsCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("iss_dt", getIssDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("iss_yd_cd", getIssYdCd());
		this.hashColumns.put("xtra_disp_desc", getXtraDispDesc());
		this.hashColumns.put("file_seq", getFileSeq());
		this.hashColumns.put("xtra_disp_expn_amt", getXtraDispExpnAmt());
		this.hashColumns.put("if_trc_seq", getIfTrcSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("xtra_disp_rmk", "xtraDispRmk");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("mnr_xtra_disp_tp_cd", "mnrXtraDispTpCd");
		this.hashFields.put("iss_ofc_cd", "issOfcCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("xtra_disp_incm_amt", "xtraDispIncmAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("xtra_disp_seq", "xtraDispSeq");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("xtra_disp_sts_cd", "xtraDispStsCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("iss_dt", "issDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("iss_yd_cd", "issYdCd");
		this.hashFields.put("xtra_disp_desc", "xtraDispDesc");
		this.hashFields.put("file_seq", "fileSeq");
		this.hashFields.put("xtra_disp_expn_amt", "xtraDispExpnAmt");
		this.hashFields.put("if_trc_seq", "ifTrcSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return xtraDispRmk
	 */
	public String getXtraDispRmk() {
		return this.xtraDispRmk;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return mnrXtraDispTpCd
	 */
	public String getMnrXtraDispTpCd() {
		return this.mnrXtraDispTpCd;
	}
	
	/**
	 * Column Info
	 * @return issOfcCd
	 */
	public String getIssOfcCd() {
		return this.issOfcCd;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	
	/**
	 * Column Info
	 * @return xtraDispIncmAmt
	 */
	public String getXtraDispIncmAmt() {
		return this.xtraDispIncmAmt;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return xtraDispSeq
	 */
	public String getXtraDispSeq() {
		return this.xtraDispSeq;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @return xtraDispStsCd
	 */
	public String getXtraDispStsCd() {
		return this.xtraDispStsCd;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return issDt
	 */
	public String getIssDt() {
		return this.issDt;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return issYdCd
	 */
	public String getIssYdCd() {
		return this.issYdCd;
	}
	
	/**
	 * Column Info
	 * @return xtraDispDesc
	 */
	public String getXtraDispDesc() {
		return this.xtraDispDesc;
	}
	
	/**
	 * Column Info
	 * @return fileSeq
	 */
	public String getFileSeq() {
		return this.fileSeq;
	}
	
	/**
	 * Column Info
	 * @return xtraDispExpnAmt
	 */
	public String getXtraDispExpnAmt() {
		return this.xtraDispExpnAmt;
	}
	
	/**
	 * Column Info
	 * @return ifTrcSeq
	 */
	public String getIfTrcSeq() {
		return this.ifTrcSeq;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	

	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param xtraDispRmk
	 */
	public void setXtraDispRmk(String xtraDispRmk) {
		this.xtraDispRmk = xtraDispRmk;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param mnrXtraDispTpCd
	 */
	public void setMnrXtraDispTpCd(String mnrXtraDispTpCd) {
		this.mnrXtraDispTpCd = mnrXtraDispTpCd;
	}
	
	/**
	 * Column Info
	 * @param issOfcCd
	 */
	public void setIssOfcCd(String issOfcCd) {
		this.issOfcCd = issOfcCd;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}
	
	/**
	 * Column Info
	 * @param xtraDispIncmAmt
	 */
	public void setXtraDispIncmAmt(String xtraDispIncmAmt) {
		this.xtraDispIncmAmt = xtraDispIncmAmt;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param xtraDispSeq
	 */
	public void setXtraDispSeq(String xtraDispSeq) {
		this.xtraDispSeq = xtraDispSeq;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @param xtraDispStsCd
	 */
	public void setXtraDispStsCd(String xtraDispStsCd) {
		this.xtraDispStsCd = xtraDispStsCd;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param issDt
	 */
	public void setIssDt(String issDt) {
		this.issDt = issDt;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param issYdCd
	 */
	public void setIssYdCd(String issYdCd) {
		this.issYdCd = issYdCd;
	}
	
	/**
	 * Column Info
	 * @param xtraDispDesc
	 */
	public void setXtraDispDesc(String xtraDispDesc) {
		this.xtraDispDesc = xtraDispDesc;
	}
	
	/**
	 * Column Info
	 * @param fileSeq
	 */
	public void setFileSeq(String fileSeq) {
		this.fileSeq = fileSeq;
	}
	
	/**
	 * Column Info
	 * @param xtraDispExpnAmt
	 */
	public void setXtraDispExpnAmt(String xtraDispExpnAmt) {
		this.xtraDispExpnAmt = xtraDispExpnAmt;
	}
	
	/**
	 * Column Info
	 * @param ifTrcSeq
	 */
	public void setIfTrcSeq(String ifTrcSeq) {
		this.ifTrcSeq = ifTrcSeq;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setXtraDispRmk(JSPUtil.getParameter(request, "xtra_disp_rmk", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setMnrXtraDispTpCd(JSPUtil.getParameter(request, "mnr_xtra_disp_tp_cd", ""));
		setIssOfcCd(JSPUtil.getParameter(request, "iss_ofc_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setXtraDispIncmAmt(JSPUtil.getParameter(request, "xtra_disp_incm_amt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setXtraDispSeq(JSPUtil.getParameter(request, "xtra_disp_seq", ""));
		setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd", ""));
		setXtraDispStsCd(JSPUtil.getParameter(request, "xtra_disp_sts_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIssDt(JSPUtil.getParameter(request, "iss_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setIssYdCd(JSPUtil.getParameter(request, "iss_yd_cd", ""));
		setXtraDispDesc(JSPUtil.getParameter(request, "xtra_disp_desc", ""));
		setFileSeq(JSPUtil.getParameter(request, "file_seq", ""));
		setXtraDispExpnAmt(JSPUtil.getParameter(request, "xtra_disp_expn_amt", ""));
		setIfTrcSeq(JSPUtil.getParameter(request, "if_trc_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomMnrXtraDispVO[]
	 */
	public CustomMnrXtraDispVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomMnrXtraDispVO[]
	 */
	public CustomMnrXtraDispVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomMnrXtraDispVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] xtraDispRmk = (JSPUtil.getParameter(request, prefix	+ "xtra_disp_rmk", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] mnrXtraDispTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_xtra_disp_tp_cd", length));
			String[] issOfcCd = (JSPUtil.getParameter(request, prefix	+ "iss_ofc_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] xtraDispIncmAmt = (JSPUtil.getParameter(request, prefix	+ "xtra_disp_incm_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] xtraDispSeq = (JSPUtil.getParameter(request, prefix	+ "xtra_disp_seq", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] xtraDispStsCd = (JSPUtil.getParameter(request, prefix	+ "xtra_disp_sts_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] issDt = (JSPUtil.getParameter(request, prefix	+ "iss_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] issYdCd = (JSPUtil.getParameter(request, prefix	+ "iss_yd_cd", length));
			String[] xtraDispDesc = (JSPUtil.getParameter(request, prefix	+ "xtra_disp_desc", length));
			String[] fileSeq = (JSPUtil.getParameter(request, prefix	+ "file_seq", length));
			String[] xtraDispExpnAmt = (JSPUtil.getParameter(request, prefix	+ "xtra_disp_expn_amt", length));
			String[] ifTrcSeq = (JSPUtil.getParameter(request, prefix	+ "if_trc_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomMnrXtraDispVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (xtraDispRmk[i] != null)
					model.setXtraDispRmk(xtraDispRmk[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (mnrXtraDispTpCd[i] != null)
					model.setMnrXtraDispTpCd(mnrXtraDispTpCd[i]);
				if (issOfcCd[i] != null)
					model.setIssOfcCd(issOfcCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (xtraDispIncmAmt[i] != null)
					model.setXtraDispIncmAmt(xtraDispIncmAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (xtraDispSeq[i] != null)
					model.setXtraDispSeq(xtraDispSeq[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (xtraDispStsCd[i] != null)
					model.setXtraDispStsCd(xtraDispStsCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (issDt[i] != null)
					model.setIssDt(issDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (issYdCd[i] != null)
					model.setIssYdCd(issYdCd[i]);
				if (xtraDispDesc[i] != null)
					model.setXtraDispDesc(xtraDispDesc[i]);
				if (fileSeq[i] != null)
					model.setFileSeq(fileSeq[i]);
				if (xtraDispExpnAmt[i] != null)
					model.setXtraDispExpnAmt(xtraDispExpnAmt[i]);
				if (ifTrcSeq[i] != null)
					model.setIfTrcSeq(ifTrcSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomMnrXtraDispVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomMnrXtraDispVO[]
	 */
	public CustomMnrXtraDispVO[] getCustomMnrXtraDispVOs(){
		CustomMnrXtraDispVO[] vos = (CustomMnrXtraDispVO[])models.toArray(new CustomMnrXtraDispVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xtraDispRmk = this.xtraDispRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrXtraDispTpCd = this.mnrXtraDispTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issOfcCd = this.issOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xtraDispIncmAmt = this.xtraDispIncmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xtraDispSeq = this.xtraDispSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xtraDispStsCd = this.xtraDispStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt = this.issDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issYdCd = this.issYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xtraDispDesc = this.xtraDispDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSeq = this.fileSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xtraDispExpnAmt = this.xtraDispExpnAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifTrcSeq = this.ifTrcSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

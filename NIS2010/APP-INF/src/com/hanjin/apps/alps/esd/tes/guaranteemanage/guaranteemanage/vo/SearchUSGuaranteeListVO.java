/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchUSGuaranteeListVO.java
*@FileTitle : SearchUSGuaranteeListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.16
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2010.02.16 yOng hO lEE 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.tes.guaranteemanage.guaranteemanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author yOng hO lEE
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchUSGuaranteeListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchUSGuaranteeListVO> models = new ArrayList<SearchUSGuaranteeListVO>();
	
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String tpbInvNo = null;
	/* Column Info */
	private String gnteAmt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String chkIrr = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String gnteNo = null;
	/* Column Info */
	private String chkTpbIf = null;
	/* Column Info */
	private String vndrSeqName = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String gnteTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchUSGuaranteeListVO() {}

	public SearchUSGuaranteeListVO(String ibflag, String pagerows, String gnteNo, String cntrNo, String cntrTpszCd, String gnteTpCd, String chkTpbIf, String chkIrr, String bkgNo, String blNo, String scNo, String fmDt, String toDt, String gnteAmt, String tpbInvNo, String deltFlg, String creUsrId, String usrNm, String creDt, String ydCd, String vndrSeq, String vndrSeqName) {
		this.fmDt = fmDt;
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.tpbInvNo = tpbInvNo;
		this.gnteAmt = gnteAmt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.toDt = toDt;
		this.chkIrr = chkIrr;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.gnteNo = gnteNo;
		this.chkTpbIf = chkTpbIf;
		this.vndrSeqName = vndrSeqName;
		this.ydCd = ydCd;
		this.usrNm = usrNm;
		this.vndrSeq = vndrSeq;
		this.cntrNo = cntrNo;
		this.scNo = scNo;
		this.cntrTpszCd = cntrTpszCd;
		this.gnteTpCd = gnteTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("tpb_inv_no", getTpbInvNo());
		this.hashColumns.put("gnte_amt", getGnteAmt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("chk_irr", getChkIrr());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("gnte_no", getGnteNo());
		this.hashColumns.put("chk_tpb_if", getChkTpbIf());
		this.hashColumns.put("vndr_seq_name", getVndrSeqName());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("gnte_tp_cd", getGnteTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("tpb_inv_no", "tpbInvNo");
		this.hashFields.put("gnte_amt", "gnteAmt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("chk_irr", "chkIrr");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("gnte_no", "gnteNo");
		this.hashFields.put("chk_tpb_if", "chkTpbIf");
		this.hashFields.put("vndr_seq_name", "vndrSeqName");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("gnte_tp_cd", "gnteTpCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fmDt
	 */
	public String getFmDt() {
		return this.fmDt;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
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
	 * @return tpbInvNo
	 */
	public String getTpbInvNo() {
		return this.tpbInvNo;
	}
	
	/**
	 * Column Info
	 * @return gnteAmt
	 */
	public String getGnteAmt() {
		return this.gnteAmt;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	
	/**
	 * Column Info
	 * @return chkIrr
	 */
	public String getChkIrr() {
		return this.chkIrr;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return gnteNo
	 */
	public String getGnteNo() {
		return this.gnteNo;
	}
	
	/**
	 * Column Info
	 * @return chkTpbIf
	 */
	public String getChkTpbIf() {
		return this.chkTpbIf;
	}
	
	/**
	 * Column Info
	 * @return vndrSeqName
	 */
	public String getVndrSeqName() {
		return this.vndrSeqName;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return gnteTpCd
	 */
	public String getGnteTpCd() {
		return this.gnteTpCd;
	}
	

	/**
	 * Column Info
	 * @param fmDt
	 */
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
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
	 * @param tpbInvNo
	 */
	public void setTpbInvNo(String tpbInvNo) {
		this.tpbInvNo = tpbInvNo;
	}
	
	/**
	 * Column Info
	 * @param gnteAmt
	 */
	public void setGnteAmt(String gnteAmt) {
		this.gnteAmt = gnteAmt;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param chkIrr
	 */
	public void setChkIrr(String chkIrr) {
		this.chkIrr = chkIrr;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param gnteNo
	 */
	public void setGnteNo(String gnteNo) {
		this.gnteNo = gnteNo;
	}
	
	/**
	 * Column Info
	 * @param chkTpbIf
	 */
	public void setChkTpbIf(String chkTpbIf) {
		this.chkTpbIf = chkTpbIf;
	}
	
	/**
	 * Column Info
	 * @param vndrSeqName
	 */
	public void setVndrSeqName(String vndrSeqName) {
		this.vndrSeqName = vndrSeqName;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param gnteTpCd
	 */
	public void setGnteTpCd(String gnteTpCd) {
		this.gnteTpCd = gnteTpCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFmDt(JSPUtil.getParameter(request, "fm_dt", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setTpbInvNo(JSPUtil.getParameter(request, "tpb_inv_no", ""));
		setGnteAmt(JSPUtil.getParameter(request, "gnte_amt", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setToDt(JSPUtil.getParameter(request, "to_dt", ""));
		setChkIrr(JSPUtil.getParameter(request, "chk_irr", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setGnteNo(JSPUtil.getParameter(request, "gnte_no", ""));
		setChkTpbIf(JSPUtil.getParameter(request, "chk_tpb_if", ""));
		setVndrSeqName(JSPUtil.getParameter(request, "vndr_seq_name", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setUsrNm(JSPUtil.getParameter(request, "usr_nm", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setGnteTpCd(JSPUtil.getParameter(request, "gnte_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchUSGuaranteeListVO[]
	 */
	public SearchUSGuaranteeListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchUSGuaranteeListVO[]
	 */
	public SearchUSGuaranteeListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchUSGuaranteeListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] tpbInvNo = (JSPUtil.getParameter(request, prefix	+ "tpb_inv_no", length));
			String[] gnteAmt = (JSPUtil.getParameter(request, prefix	+ "gnte_amt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] chkIrr = (JSPUtil.getParameter(request, prefix	+ "chk_irr", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] gnteNo = (JSPUtil.getParameter(request, prefix	+ "gnte_no", length));
			String[] chkTpbIf = (JSPUtil.getParameter(request, prefix	+ "chk_tpb_if", length));
			String[] vndrSeqName = (JSPUtil.getParameter(request, prefix	+ "vndr_seq_name", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] gnteTpCd = (JSPUtil.getParameter(request, prefix	+ "gnte_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchUSGuaranteeListVO();
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (tpbInvNo[i] != null)
					model.setTpbInvNo(tpbInvNo[i]);
				if (gnteAmt[i] != null)
					model.setGnteAmt(gnteAmt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (chkIrr[i] != null)
					model.setChkIrr(chkIrr[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (gnteNo[i] != null)
					model.setGnteNo(gnteNo[i]);
				if (chkTpbIf[i] != null)
					model.setChkTpbIf(chkTpbIf[i]);
				if (vndrSeqName[i] != null)
					model.setVndrSeqName(vndrSeqName[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (gnteTpCd[i] != null)
					model.setGnteTpCd(gnteTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchUSGuaranteeListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchUSGuaranteeListVO[]
	 */
	public SearchUSGuaranteeListVO[] getSearchUSGuaranteeListVOs(){
		SearchUSGuaranteeListVO[] vos = (SearchUSGuaranteeListVO[])models.toArray(new SearchUSGuaranteeListVO[models.size()]);
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
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpbInvNo = this.tpbInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gnteAmt = this.gnteAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkIrr = this.chkIrr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gnteNo = this.gnteNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkTpbIf = this.chkTpbIf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeqName = this.vndrSeqName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gnteTpCd = this.gnteTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

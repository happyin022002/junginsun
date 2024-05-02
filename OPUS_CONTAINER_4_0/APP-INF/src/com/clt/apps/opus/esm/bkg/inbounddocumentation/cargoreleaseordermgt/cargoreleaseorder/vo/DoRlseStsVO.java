/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DoRlseStsVO.java
*@FileTitle : DoRlseStsVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.19
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.19  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DoRlseStsVO extends AbstractValueObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2216804598177652677L;

	private Collection<DoRlseStsVO> models = new ArrayList<DoRlseStsVO>();
	
	/* Column Info */
	private String doNoSplit = null;
	/* Column Info */
	private String evntOfcCd = null;
	/* Column Info */
	private String selfTrnsFlg = null;
	/* Column Info */
	private String rlseStsNm = null;
	/* Column Info */
	private String rlseSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String doNo = null;
	/* Column Info */
	private String rlseStsCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String rlseStsSeq = null;
	/* Column Info */
	private String evntUsrId = null;
	/* Column Info */
	private String updUsrNm = null;
	/* Column Info */
	private String jpDoId = null;
	/* Column Info */
	private String evntDt = null;
	/* Column Info */
	private String resetFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DoRlseStsVO() {}

	public DoRlseStsVO(String ibflag, String pagerows, String doNoSplit, String evntOfcCd, String rlseStsNm, String rlseSeq, String doNo, String rlseStsCd, String bkgNo, String rlseStsSeq, String evntUsrId, String updUsrNm, String resetFlg, String evntDt, String jpDoId, String selfTrnsFlg) {
		this.doNoSplit = doNoSplit;
		this.evntOfcCd = evntOfcCd;
		this.selfTrnsFlg = selfTrnsFlg;
		this.rlseStsNm = rlseStsNm;
		this.rlseSeq = rlseSeq;
		this.pagerows = pagerows;
		this.doNo = doNo;
		this.rlseStsCd = rlseStsCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.rlseStsSeq = rlseStsSeq;
		this.evntUsrId = evntUsrId;
		this.updUsrNm = updUsrNm;
		this.jpDoId = jpDoId;
		this.evntDt = evntDt;
		this.resetFlg = resetFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("do_no_split", getDoNoSplit());
		this.hashColumns.put("evnt_ofc_cd", getEvntOfcCd());
		this.hashColumns.put("self_trns_flg", getSelfTrnsFlg());
		this.hashColumns.put("rlse_sts_nm", getRlseStsNm());
		this.hashColumns.put("rlse_seq", getRlseSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("do_no", getDoNo());
		this.hashColumns.put("rlse_sts_cd", getRlseStsCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("rlse_sts_seq", getRlseStsSeq());
		this.hashColumns.put("evnt_usr_id", getEvntUsrId());
		this.hashColumns.put("upd_usr_nm", getUpdUsrNm());
		this.hashColumns.put("jp_do_id", getJpDoId());
		this.hashColumns.put("evnt_dt", getEvntDt());
		this.hashColumns.put("reset_flg", getResetFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("do_no_split", "doNoSplit");
		this.hashFields.put("evnt_ofc_cd", "evntOfcCd");
		this.hashFields.put("self_trns_flg", "selfTrnsFlg");
		this.hashFields.put("rlse_sts_nm", "rlseStsNm");
		this.hashFields.put("rlse_seq", "rlseSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("do_no", "doNo");
		this.hashFields.put("rlse_sts_cd", "rlseStsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("rlse_sts_seq", "rlseStsSeq");
		this.hashFields.put("evnt_usr_id", "evntUsrId");
		this.hashFields.put("upd_usr_nm", "updUsrNm");
		this.hashFields.put("jp_do_id", "jpDoId");
		this.hashFields.put("evnt_dt", "evntDt");
		this.hashFields.put("reset_flg", "resetFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return doNoSplit
	 */
	public String getDoNoSplit() {
		return this.doNoSplit;
	}
	
	/**
	 * Column Info
	 * @return evntOfcCd
	 */
	public String getEvntOfcCd() {
		return this.evntOfcCd;
	}
	
	/**
	 * Column Info
	 * @return selfTrnsFlg
	 */
	public String getSelfTrnsFlg() {
		return this.selfTrnsFlg;
	}
	
	/**
	 * Column Info
	 * @return rlseStsNm
	 */
	public String getRlseStsNm() {
		return this.rlseStsNm;
	}
	
	/**
	 * Column Info
	 * @return rlseSeq
	 */
	public String getRlseSeq() {
		return this.rlseSeq;
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
	 * @return doNo
	 */
	public String getDoNo() {
		return this.doNo;
	}
	
	/**
	 * Column Info
	 * @return rlseStsCd
	 */
	public String getRlseStsCd() {
		return this.rlseStsCd;
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
	 * @return rlseStsSeq
	 */
	public String getRlseStsSeq() {
		return this.rlseStsSeq;
	}
	
	/**
	 * Column Info
	 * @return evntUsrId
	 */
	public String getEvntUsrId() {
		return this.evntUsrId;
	}
	
	/**
	 * Column Info
	 * @return updUsrNm
	 */
	public String getUpdUsrNm() {
		return this.updUsrNm;
	}
	
	/**
	 * Column Info
	 * @return jpDoId
	 */
	public String getJpDoId() {
		return this.jpDoId;
	}
	
	/**
	 * Column Info
	 * @return evntDt
	 */
	public String getEvntDt() {
		return this.evntDt;
	}
	
	/**
	 * Column Info
	 * @return resetFlg
	 */
	public String getResetFlg() {
		return this.resetFlg;
	}
	

	/**
	 * Column Info
	 * @param doNoSplit
	 */
	public void setDoNoSplit(String doNoSplit) {
		this.doNoSplit = doNoSplit;
	}
	
	/**
	 * Column Info
	 * @param evntOfcCd
	 */
	public void setEvntOfcCd(String evntOfcCd) {
		this.evntOfcCd = evntOfcCd;
	}
	
	/**
	 * Column Info
	 * @param selfTrnsFlg
	 */
	public void setSelfTrnsFlg(String selfTrnsFlg) {
		this.selfTrnsFlg = selfTrnsFlg;
	}
	
	/**
	 * Column Info
	 * @param rlseStsNm
	 */
	public void setRlseStsNm(String rlseStsNm) {
		this.rlseStsNm = rlseStsNm;
	}
	
	/**
	 * Column Info
	 * @param rlseSeq
	 */
	public void setRlseSeq(String rlseSeq) {
		this.rlseSeq = rlseSeq;
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
	 * @param doNo
	 */
	public void setDoNo(String doNo) {
		this.doNo = doNo;
	}
	
	/**
	 * Column Info
	 * @param rlseStsCd
	 */
	public void setRlseStsCd(String rlseStsCd) {
		this.rlseStsCd = rlseStsCd;
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
	 * @param rlseStsSeq
	 */
	public void setRlseStsSeq(String rlseStsSeq) {
		this.rlseStsSeq = rlseStsSeq;
	}
	
	/**
	 * Column Info
	 * @param evntUsrId
	 */
	public void setEvntUsrId(String evntUsrId) {
		this.evntUsrId = evntUsrId;
	}
	
	/**
	 * Column Info
	 * @param updUsrNm
	 */
	public void setUpdUsrNm(String updUsrNm) {
		this.updUsrNm = updUsrNm;
	}
	
	/**
	 * Column Info
	 * @param jpDoId
	 */
	public void setJpDoId(String jpDoId) {
		this.jpDoId = jpDoId;
	}
	
	/**
	 * Column Info
	 * @param evntDt
	 */
	public void setEvntDt(String evntDt) {
		this.evntDt = evntDt;
	}
	
	/**
	 * Column Info
	 * @param resetFlg
	 */
	public void setResetFlg(String resetFlg) {
		this.resetFlg = resetFlg;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setDoNoSplit(JSPUtil.getParameter(request, "do_no_split", ""));
		setEvntOfcCd(JSPUtil.getParameter(request, "evnt_ofc_cd", ""));
		setSelfTrnsFlg(JSPUtil.getParameter(request, "self_trns_flg", ""));
		setRlseStsNm(JSPUtil.getParameter(request, "rlse_sts_nm", ""));
		setRlseSeq(JSPUtil.getParameter(request, "rlse_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDoNo(JSPUtil.getParameter(request, "do_no", ""));
		setRlseStsCd(JSPUtil.getParameter(request, "rlse_sts_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setRlseStsSeq(JSPUtil.getParameter(request, "rlse_sts_seq", ""));
		setEvntUsrId(JSPUtil.getParameter(request, "evnt_usr_id", ""));
		setUpdUsrNm(JSPUtil.getParameter(request, "upd_usr_nm", ""));
		setJpDoId(JSPUtil.getParameter(request, "jp_do_id", ""));
		setEvntDt(JSPUtil.getParameter(request, "evnt_dt", ""));
		setResetFlg(JSPUtil.getParameter(request, "reset_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DoRlseStsVO[]
	 */
	public DoRlseStsVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DoRlseStsVO[]
	 */
	public DoRlseStsVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DoRlseStsVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] doNoSplit = (JSPUtil.getParameter(request, prefix	+ "do_no_split", length));
			String[] evntOfcCd = (JSPUtil.getParameter(request, prefix	+ "evnt_ofc_cd", length));
			String[] selfTrnsFlg = (JSPUtil.getParameter(request, prefix	+ "self_trns_flg", length));
			String[] rlseStsNm = (JSPUtil.getParameter(request, prefix	+ "rlse_sts_nm", length));
			String[] rlseSeq = (JSPUtil.getParameter(request, prefix	+ "rlse_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] doNo = (JSPUtil.getParameter(request, prefix	+ "do_no", length));
			String[] rlseStsCd = (JSPUtil.getParameter(request, prefix	+ "rlse_sts_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] rlseStsSeq = (JSPUtil.getParameter(request, prefix	+ "rlse_sts_seq", length));
			String[] evntUsrId = (JSPUtil.getParameter(request, prefix	+ "evnt_usr_id", length));
			String[] updUsrNm = (JSPUtil.getParameter(request, prefix	+ "upd_usr_nm", length));
			String[] jpDoId = (JSPUtil.getParameter(request, prefix	+ "jp_do_id", length));
			String[] evntDt = (JSPUtil.getParameter(request, prefix	+ "evnt_dt", length));
			String[] resetFlg = (JSPUtil.getParameter(request, prefix	+ "reset_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new DoRlseStsVO();
				if (doNoSplit[i] != null)
					model.setDoNoSplit(doNoSplit[i]);
				if (evntOfcCd[i] != null)
					model.setEvntOfcCd(evntOfcCd[i]);
				if (selfTrnsFlg[i] != null)
					model.setSelfTrnsFlg(selfTrnsFlg[i]);
				if (rlseStsNm[i] != null)
					model.setRlseStsNm(rlseStsNm[i]);
				if (rlseSeq[i] != null)
					model.setRlseSeq(rlseSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (doNo[i] != null)
					model.setDoNo(doNo[i]);
				if (rlseStsCd[i] != null)
					model.setRlseStsCd(rlseStsCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (rlseStsSeq[i] != null)
					model.setRlseStsSeq(rlseStsSeq[i]);
				if (evntUsrId[i] != null)
					model.setEvntUsrId(evntUsrId[i]);
				if (updUsrNm[i] != null)
					model.setUpdUsrNm(updUsrNm[i]);
				if (jpDoId[i] != null)
					model.setJpDoId(jpDoId[i]);
				if (evntDt[i] != null)
					model.setEvntDt(evntDt[i]);
				if (resetFlg[i] != null)
					model.setResetFlg(resetFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDoRlseStsVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DoRlseStsVO[]
	 */
	public DoRlseStsVO[] getDoRlseStsVOs(){
		DoRlseStsVO[] vos = (DoRlseStsVO[])models.toArray(new DoRlseStsVO[models.size()]);
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
		this.doNoSplit = this.doNoSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntOfcCd = this.evntOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selfTrnsFlg = this.selfTrnsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlseStsNm = this.rlseStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlseSeq = this.rlseSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doNo = this.doNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlseStsCd = this.rlseStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlseStsSeq = this.rlseStsSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntUsrId = this.evntUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrNm = this.updUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jpDoId = this.jpDoId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDt = this.evntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.resetFlg = this.resetFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

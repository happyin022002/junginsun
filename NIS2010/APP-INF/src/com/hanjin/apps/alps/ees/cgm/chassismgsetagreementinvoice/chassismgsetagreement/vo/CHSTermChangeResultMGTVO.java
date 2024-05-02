/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CHSTermChangeResultMGTVO.java
*@FileTitle : CHSTermChangeResultMGTVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.07.02 김창식 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김창식
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CHSTermChangeResultMGTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CHSTermChangeResultMGTVO> models = new ArrayList<CHSTermChangeResultMGTVO>();
	
	/* Column Info */
	private String stsEvntOfcCd = null;
	/* Column Info */
	private String eqTpszCdSf4 = null;
	/* Column Info */
	private String stsEvntDtFr = null;
	/* Column Info */
	private String newAgmtLstmCd = null;
	/* Column Info */
	private String oldAgmtLstmCd = null;
	/* Column Info */
	private String eqTpszCdCb4 = null;
	/* Column Info */
	private String eqTpszCdSl2 = null;
	/* Column Info */
	private String newAgmtNo = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String viewflg = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqTpszCdEg8 = null;
	/* Column Info */
	private String newVndrSeq = null;
	/* Column Info */
	private String eqTpszCdZt4 = null;
	/* Column Info */
	private String eqTpszCdGn4 = null;
	/* Column Info */
	private String eqTpszCdTa2 = null;
	/* Column Info */
	private String eqTpszCdGn5 = null;
	/* Column Info */
	private String eqTpszCdEg5 = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String oldAgmtNo = null;
	/* Column Info */
	private String stsEvntDtTo = null;
	/* Column Info */
	private String eqTpszCdSf2 = null;
	/* Column Info */
	private String oldVndrSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CHSTermChangeResultMGTVO() {}

	public CHSTermChangeResultMGTVO(String ibflag, String pagerows, String eqKndCd, String stsEvntDtFr, String stsEvntDtTo, String viewflg, String vndrSeq, String stsEvntOfcCd, String oldVndrSeq, String oldAgmtNo, String oldAgmtLstmCd, String newVndrSeq, String newAgmtNo, String newAgmtLstmCd, String eqTpszCdSf2, String eqTpszCdSl2, String eqTpszCdTa2, String eqTpszCdSf4, String eqTpszCdGn4, String eqTpszCdCb4, String eqTpszCdEg5, String eqTpszCdEg8, String eqTpszCdGn5, String eqTpszCdZt4) {
		this.stsEvntOfcCd = stsEvntOfcCd;
		this.eqTpszCdSf4 = eqTpszCdSf4;
		this.stsEvntDtFr = stsEvntDtFr;
		this.newAgmtLstmCd = newAgmtLstmCd;
		this.oldAgmtLstmCd = oldAgmtLstmCd;
		this.eqTpszCdCb4 = eqTpszCdCb4;
		this.eqTpszCdSl2 = eqTpszCdSl2;
		this.newAgmtNo = newAgmtNo;
		this.eqKndCd = eqKndCd;
		this.viewflg = viewflg;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.eqTpszCdEg8 = eqTpszCdEg8;
		this.newVndrSeq = newVndrSeq;
		this.eqTpszCdZt4 = eqTpszCdZt4;
		this.eqTpszCdGn4 = eqTpszCdGn4;
		this.eqTpszCdTa2 = eqTpszCdTa2;
		this.eqTpszCdGn5 = eqTpszCdGn5;
		this.eqTpszCdEg5 = eqTpszCdEg5;
		this.vndrSeq = vndrSeq;
		this.oldAgmtNo = oldAgmtNo;
		this.stsEvntDtTo = stsEvntDtTo;
		this.eqTpszCdSf2 = eqTpszCdSf2;
		this.oldVndrSeq = oldVndrSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sts_evnt_ofc_cd", getStsEvntOfcCd());
		this.hashColumns.put("eq_tpsz_cd_sf4", getEqTpszCdSf4());
		this.hashColumns.put("sts_evnt_dt_fr", getStsEvntDtFr());
		this.hashColumns.put("new_agmt_lstm_cd", getNewAgmtLstmCd());
		this.hashColumns.put("old_agmt_lstm_cd", getOldAgmtLstmCd());
		this.hashColumns.put("eq_tpsz_cd_cb4", getEqTpszCdCb4());
		this.hashColumns.put("eq_tpsz_cd_sl2", getEqTpszCdSl2());
		this.hashColumns.put("new_agmt_no", getNewAgmtNo());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("viewflg", getViewflg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_tpsz_cd_eg8", getEqTpszCdEg8());
		this.hashColumns.put("new_vndr_seq", getNewVndrSeq());
		this.hashColumns.put("eq_tpsz_cd_zt4", getEqTpszCdZt4());
		this.hashColumns.put("eq_tpsz_cd_gn4", getEqTpszCdGn4());
		this.hashColumns.put("eq_tpsz_cd_ta2", getEqTpszCdTa2());
		this.hashColumns.put("eq_tpsz_cd_gn5", getEqTpszCdGn5());
		this.hashColumns.put("eq_tpsz_cd_eg5", getEqTpszCdEg5());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("old_agmt_no", getOldAgmtNo());
		this.hashColumns.put("sts_evnt_dt_to", getStsEvntDtTo());
		this.hashColumns.put("eq_tpsz_cd_sf2", getEqTpszCdSf2());
		this.hashColumns.put("old_vndr_seq", getOldVndrSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sts_evnt_ofc_cd", "stsEvntOfcCd");
		this.hashFields.put("eq_tpsz_cd_sf4", "eqTpszCdSf4");
		this.hashFields.put("sts_evnt_dt_fr", "stsEvntDtFr");
		this.hashFields.put("new_agmt_lstm_cd", "newAgmtLstmCd");
		this.hashFields.put("old_agmt_lstm_cd", "oldAgmtLstmCd");
		this.hashFields.put("eq_tpsz_cd_cb4", "eqTpszCdCb4");
		this.hashFields.put("eq_tpsz_cd_sl2", "eqTpszCdSl2");
		this.hashFields.put("new_agmt_no", "newAgmtNo");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("viewflg", "viewflg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_tpsz_cd_eg8", "eqTpszCdEg8");
		this.hashFields.put("new_vndr_seq", "newVndrSeq");
		this.hashFields.put("eq_tpsz_cd_zt4", "eqTpszCdZt4");
		this.hashFields.put("eq_tpsz_cd_gn4", "eqTpszCdGn4");
		this.hashFields.put("eq_tpsz_cd_ta2", "eqTpszCdTa2");
		this.hashFields.put("eq_tpsz_cd_gn5", "eqTpszCdGn5");
		this.hashFields.put("eq_tpsz_cd_eg5", "eqTpszCdEg5");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("old_agmt_no", "oldAgmtNo");
		this.hashFields.put("sts_evnt_dt_to", "stsEvntDtTo");
		this.hashFields.put("eq_tpsz_cd_sf2", "eqTpszCdSf2");
		this.hashFields.put("old_vndr_seq", "oldVndrSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return stsEvntOfcCd
	 */
	public String getStsEvntOfcCd() {
		return this.stsEvntOfcCd;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCdSf4
	 */
	public String getEqTpszCdSf4() {
		return this.eqTpszCdSf4;
	}
	
	/**
	 * Column Info
	 * @return stsEvntDtFr
	 */
	public String getStsEvntDtFr() {
		return this.stsEvntDtFr;
	}
	
	/**
	 * Column Info
	 * @return newAgmtLstmCd
	 */
	public String getNewAgmtLstmCd() {
		return this.newAgmtLstmCd;
	}
	
	/**
	 * Column Info
	 * @return oldAgmtLstmCd
	 */
	public String getOldAgmtLstmCd() {
		return this.oldAgmtLstmCd;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCdCb4
	 */
	public String getEqTpszCdCb4() {
		return this.eqTpszCdCb4;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCdSl2
	 */
	public String getEqTpszCdSl2() {
		return this.eqTpszCdSl2;
	}
	
	/**
	 * Column Info
	 * @return newAgmtNo
	 */
	public String getNewAgmtNo() {
		return this.newAgmtNo;
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
	 * @return viewflg
	 */
	public String getViewflg() {
		return this.viewflg;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return eqTpszCdEg8
	 */
	public String getEqTpszCdEg8() {
		return this.eqTpszCdEg8;
	}
	
	/**
	 * Column Info
	 * @return newVndrSeq
	 */
	public String getNewVndrSeq() {
		return this.newVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCdZt4
	 */
	public String getEqTpszCdZt4() {
		return this.eqTpszCdZt4;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCdGn4
	 */
	public String getEqTpszCdGn4() {
		return this.eqTpszCdGn4;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCdTa2
	 */
	public String getEqTpszCdTa2() {
		return this.eqTpszCdTa2;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCdGn5
	 */
	public String getEqTpszCdGn5() {
		return this.eqTpszCdGn5;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCdEg5
	 */
	public String getEqTpszCdEg5() {
		return this.eqTpszCdEg5;
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
	 * @return oldAgmtNo
	 */
	public String getOldAgmtNo() {
		return this.oldAgmtNo;
	}
	
	/**
	 * Column Info
	 * @return stsEvntDtTo
	 */
	public String getStsEvntDtTo() {
		return this.stsEvntDtTo;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCdSf2
	 */
	public String getEqTpszCdSf2() {
		return this.eqTpszCdSf2;
	}
	
	/**
	 * Column Info
	 * @return oldVndrSeq
	 */
	public String getOldVndrSeq() {
		return this.oldVndrSeq;
	}
	

	/**
	 * Column Info
	 * @param stsEvntOfcCd
	 */
	public void setStsEvntOfcCd(String stsEvntOfcCd) {
		this.stsEvntOfcCd = stsEvntOfcCd;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCdSf4
	 */
	public void setEqTpszCdSf4(String eqTpszCdSf4) {
		this.eqTpszCdSf4 = eqTpszCdSf4;
	}
	
	/**
	 * Column Info
	 * @param stsEvntDtFr
	 */
	public void setStsEvntDtFr(String stsEvntDtFr) {
		this.stsEvntDtFr = stsEvntDtFr;
	}
	
	/**
	 * Column Info
	 * @param newAgmtLstmCd
	 */
	public void setNewAgmtLstmCd(String newAgmtLstmCd) {
		this.newAgmtLstmCd = newAgmtLstmCd;
	}
	
	/**
	 * Column Info
	 * @param oldAgmtLstmCd
	 */
	public void setOldAgmtLstmCd(String oldAgmtLstmCd) {
		this.oldAgmtLstmCd = oldAgmtLstmCd;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCdCb4
	 */
	public void setEqTpszCdCb4(String eqTpszCdCb4) {
		this.eqTpszCdCb4 = eqTpszCdCb4;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCdSl2
	 */
	public void setEqTpszCdSl2(String eqTpszCdSl2) {
		this.eqTpszCdSl2 = eqTpszCdSl2;
	}
	
	/**
	 * Column Info
	 * @param newAgmtNo
	 */
	public void setNewAgmtNo(String newAgmtNo) {
		this.newAgmtNo = newAgmtNo;
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
	 * @param viewflg
	 */
	public void setViewflg(String viewflg) {
		this.viewflg = viewflg;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param eqTpszCdEg8
	 */
	public void setEqTpszCdEg8(String eqTpszCdEg8) {
		this.eqTpszCdEg8 = eqTpszCdEg8;
	}
	
	/**
	 * Column Info
	 * @param newVndrSeq
	 */
	public void setNewVndrSeq(String newVndrSeq) {
		this.newVndrSeq = newVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCdZt4
	 */
	public void setEqTpszCdZt4(String eqTpszCdZt4) {
		this.eqTpszCdZt4 = eqTpszCdZt4;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCdGn4
	 */
	public void setEqTpszCdGn4(String eqTpszCdGn4) {
		this.eqTpszCdGn4 = eqTpszCdGn4;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCdTa2
	 */
	public void setEqTpszCdTa2(String eqTpszCdTa2) {
		this.eqTpszCdTa2 = eqTpszCdTa2;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCdGn5
	 */
	public void setEqTpszCdGn5(String eqTpszCdGn5) {
		this.eqTpszCdGn5 = eqTpszCdGn5;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCdEg5
	 */
	public void setEqTpszCdEg5(String eqTpszCdEg5) {
		this.eqTpszCdEg5 = eqTpszCdEg5;
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
	 * @param oldAgmtNo
	 */
	public void setOldAgmtNo(String oldAgmtNo) {
		this.oldAgmtNo = oldAgmtNo;
	}
	
	/**
	 * Column Info
	 * @param stsEvntDtTo
	 */
	public void setStsEvntDtTo(String stsEvntDtTo) {
		this.stsEvntDtTo = stsEvntDtTo;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCdSf2
	 */
	public void setEqTpszCdSf2(String eqTpszCdSf2) {
		this.eqTpszCdSf2 = eqTpszCdSf2;
	}
	
	/**
	 * Column Info
	 * @param oldVndrSeq
	 */
	public void setOldVndrSeq(String oldVndrSeq) {
		this.oldVndrSeq = oldVndrSeq;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setStsEvntOfcCd(JSPUtil.getParameter(request, "sts_evnt_ofc_cd", ""));
		setEqTpszCdSf4(JSPUtil.getParameter(request, "eq_tpsz_cd_sf4", ""));
		setStsEvntDtFr(JSPUtil.getParameter(request, "sts_evnt_dt_fr", ""));
		setNewAgmtLstmCd(JSPUtil.getParameter(request, "new_agmt_lstm_cd", ""));
		setOldAgmtLstmCd(JSPUtil.getParameter(request, "old_agmt_lstm_cd", ""));
		setEqTpszCdCb4(JSPUtil.getParameter(request, "eq_tpsz_cd_cb4", ""));
		setEqTpszCdSl2(JSPUtil.getParameter(request, "eq_tpsz_cd_sl2", ""));
		setNewAgmtNo(JSPUtil.getParameter(request, "new_agmt_no", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setViewflg(JSPUtil.getParameter(request, "viewflg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEqTpszCdEg8(JSPUtil.getParameter(request, "eq_tpsz_cd_eg8", ""));
		setNewVndrSeq(JSPUtil.getParameter(request, "new_vndr_seq", ""));
		setEqTpszCdZt4(JSPUtil.getParameter(request, "eq_tpsz_cd_zt4", ""));
		setEqTpszCdGn4(JSPUtil.getParameter(request, "eq_tpsz_cd_gn4", ""));
		setEqTpszCdTa2(JSPUtil.getParameter(request, "eq_tpsz_cd_ta2", ""));
		setEqTpszCdGn5(JSPUtil.getParameter(request, "eq_tpsz_cd_gn5", ""));
		setEqTpszCdEg5(JSPUtil.getParameter(request, "eq_tpsz_cd_eg5", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setOldAgmtNo(JSPUtil.getParameter(request, "old_agmt_no", ""));
		setStsEvntDtTo(JSPUtil.getParameter(request, "sts_evnt_dt_to", ""));
		setEqTpszCdSf2(JSPUtil.getParameter(request, "eq_tpsz_cd_sf2", ""));
		setOldVndrSeq(JSPUtil.getParameter(request, "old_vndr_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CHSTermChangeResultMGTVO[]
	 */
	public CHSTermChangeResultMGTVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CHSTermChangeResultMGTVO[]
	 */
	public CHSTermChangeResultMGTVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CHSTermChangeResultMGTVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] stsEvntOfcCd = (JSPUtil.getParameter(request, prefix	+ "sts_evnt_ofc_cd", length));
			String[] eqTpszCdSf4 = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd_sf4", length));
			String[] stsEvntDtFr = (JSPUtil.getParameter(request, prefix	+ "sts_evnt_dt_fr", length));
			String[] newAgmtLstmCd = (JSPUtil.getParameter(request, prefix	+ "new_agmt_lstm_cd", length));
			String[] oldAgmtLstmCd = (JSPUtil.getParameter(request, prefix	+ "old_agmt_lstm_cd", length));
			String[] eqTpszCdCb4 = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd_cb4", length));
			String[] eqTpszCdSl2 = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd_sl2", length));
			String[] newAgmtNo = (JSPUtil.getParameter(request, prefix	+ "new_agmt_no", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] viewflg = (JSPUtil.getParameter(request, prefix	+ "viewflg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqTpszCdEg8 = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd_eg8", length));
			String[] newVndrSeq = (JSPUtil.getParameter(request, prefix	+ "new_vndr_seq", length));
			String[] eqTpszCdZt4 = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd_zt4", length));
			String[] eqTpszCdGn4 = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd_gn4", length));
			String[] eqTpszCdTa2 = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd_ta2", length));
			String[] eqTpszCdGn5 = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd_gn5", length));
			String[] eqTpszCdEg5 = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd_eg5", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] oldAgmtNo = (JSPUtil.getParameter(request, prefix	+ "old_agmt_no", length));
			String[] stsEvntDtTo = (JSPUtil.getParameter(request, prefix	+ "sts_evnt_dt_to", length));
			String[] eqTpszCdSf2 = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd_sf2", length));
			String[] oldVndrSeq = (JSPUtil.getParameter(request, prefix	+ "old_vndr_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new CHSTermChangeResultMGTVO();
				if (stsEvntOfcCd[i] != null)
					model.setStsEvntOfcCd(stsEvntOfcCd[i]);
				if (eqTpszCdSf4[i] != null)
					model.setEqTpszCdSf4(eqTpszCdSf4[i]);
				if (stsEvntDtFr[i] != null)
					model.setStsEvntDtFr(stsEvntDtFr[i]);
				if (newAgmtLstmCd[i] != null)
					model.setNewAgmtLstmCd(newAgmtLstmCd[i]);
				if (oldAgmtLstmCd[i] != null)
					model.setOldAgmtLstmCd(oldAgmtLstmCd[i]);
				if (eqTpszCdCb4[i] != null)
					model.setEqTpszCdCb4(eqTpszCdCb4[i]);
				if (eqTpszCdSl2[i] != null)
					model.setEqTpszCdSl2(eqTpszCdSl2[i]);
				if (newAgmtNo[i] != null)
					model.setNewAgmtNo(newAgmtNo[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (viewflg[i] != null)
					model.setViewflg(viewflg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqTpszCdEg8[i] != null)
					model.setEqTpszCdEg8(eqTpszCdEg8[i]);
				if (newVndrSeq[i] != null)
					model.setNewVndrSeq(newVndrSeq[i]);
				if (eqTpszCdZt4[i] != null)
					model.setEqTpszCdZt4(eqTpszCdZt4[i]);
				if (eqTpszCdGn4[i] != null)
					model.setEqTpszCdGn4(eqTpszCdGn4[i]);
				if (eqTpszCdTa2[i] != null)
					model.setEqTpszCdTa2(eqTpszCdTa2[i]);
				if (eqTpszCdGn5[i] != null)
					model.setEqTpszCdGn5(eqTpszCdGn5[i]);
				if (eqTpszCdEg5[i] != null)
					model.setEqTpszCdEg5(eqTpszCdEg5[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (oldAgmtNo[i] != null)
					model.setOldAgmtNo(oldAgmtNo[i]);
				if (stsEvntDtTo[i] != null)
					model.setStsEvntDtTo(stsEvntDtTo[i]);
				if (eqTpszCdSf2[i] != null)
					model.setEqTpszCdSf2(eqTpszCdSf2[i]);
				if (oldVndrSeq[i] != null)
					model.setOldVndrSeq(oldVndrSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCHSTermChangeResultMGTVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CHSTermChangeResultMGTVO[]
	 */
	public CHSTermChangeResultMGTVO[] getCHSTermChangeResultMGTVOs(){
		CHSTermChangeResultMGTVO[] vos = (CHSTermChangeResultMGTVO[])models.toArray(new CHSTermChangeResultMGTVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.stsEvntOfcCd = this.stsEvntOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdSf4 = this.eqTpszCdSf4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsEvntDtFr = this.stsEvntDtFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newAgmtLstmCd = this.newAgmtLstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldAgmtLstmCd = this.oldAgmtLstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdCb4 = this.eqTpszCdCb4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdSl2 = this.eqTpszCdSl2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newAgmtNo = this.newAgmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viewflg = this.viewflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdEg8 = this.eqTpszCdEg8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newVndrSeq = this.newVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdZt4 = this.eqTpszCdZt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdGn4 = this.eqTpszCdGn4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdTa2 = this.eqTpszCdTa2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdGn5 = this.eqTpszCdGn5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdEg5 = this.eqTpszCdEg5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldAgmtNo = this.oldAgmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsEvntDtTo = this.stsEvntDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdSf2 = this.eqTpszCdSf2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldVndrSeq = this.oldVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

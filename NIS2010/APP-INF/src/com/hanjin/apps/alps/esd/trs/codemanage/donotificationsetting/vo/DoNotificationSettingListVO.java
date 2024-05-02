/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DoNotificationSettingListVO.java
*@FileTitle : DoNotificationSettingListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016-05-30
*@LastModifier : geun hwan park
*@LastVersion : 1.0
* 2016-05-30 geun hwan park 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.codemanage.donotificationsetting.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 신동일
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DoNotificationSettingListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DoNotificationSettingListVO> models = new ArrayList<DoNotificationSettingListVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String ctrtCustCntCd = null;
	/* Column Info */
	private String ctrtCustSeq = null;
	/* Column Info */
	private String ctrtEffDt = null;
	/* Column Info */
	private String destNodNm = null;
	/* Column Info */
	private String ctrtCustCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String chk = null;
	/* Column Info */
	private String ntfcActFlg = null;
	/* Column Info */
	private String ctrtTpCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String ctrtCustNm = null;
	/* Column Info */
	private String destNodYd = null;
	/* Column Info */
	private String doNtfcSetSeq = null;
	/* Column Info */
	private String destNodCd = null;
	/* Column Info */
	private String updUsrNm = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String ctrtExpDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public DoNotificationSettingListVO() {}

	public DoNotificationSettingListVO(String ibflag, String pagerows, String ctrtTpCd, String ntfcActFlg, String chk, String scNo, String ctrtCustCd, String ctrtCustNm, String ctrtEffDt, String ctrtExpDt, String destNodCd, String destNodYd, String destNodNm, String updDt, String updUsrNm, String doNtfcSetSeq, String ctrtCustCntCd, String ctrtCustSeq, String updUsrId) {
		this.updDt = updDt;
		this.ctrtCustCntCd = ctrtCustCntCd;
		this.ctrtCustSeq = ctrtCustSeq;
		this.ctrtEffDt = ctrtEffDt;
		this.destNodNm = destNodNm;
		this.ctrtCustCd = ctrtCustCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.chk = chk;
		this.ctrtTpCd = ctrtTpCd;
		this.ntfcActFlg = ntfcActFlg;
		this.scNo = scNo;
		this.ctrtCustNm = ctrtCustNm;
		this.destNodYd = destNodYd;
		this.doNtfcSetSeq = doNtfcSetSeq;
		this.destNodCd = destNodCd;
		this.updUsrNm = updUsrNm;
		this.updUsrId = updUsrId;
		this.ctrtExpDt = ctrtExpDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ctrt_cust_cnt_cd", getCtrtCustCntCd());
		this.hashColumns.put("ctrt_cust_seq", getCtrtCustSeq());
		this.hashColumns.put("ctrt_eff_dt", getCtrtEffDt());
		this.hashColumns.put("dest_nod_nm", getDestNodNm());
		this.hashColumns.put("ctrt_cust_cd", getCtrtCustCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("chk", getChk());
		this.hashColumns.put("ctrtTpCd", getCtrtTpCd());
		this.hashColumns.put("ntfc_act_flg", getNtfcActFlg());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("ctrt_cust_nm", getCtrtCustNm());
		this.hashColumns.put("dest_nod_yd", getDestNodYd());
		this.hashColumns.put("do_ntfc_set_seq", getDoNtfcSetSeq());
		this.hashColumns.put("dest_nod_cd", getDestNodCd());
		this.hashColumns.put("upd_usr_nm", getUpdUsrNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("ctrt_exp_dt", getCtrtExpDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ctrt_cust_cnt_cd", "ctrtCustCntCd");
		this.hashFields.put("ctrt_cust_seq", "ctrtCustSeq");
		this.hashFields.put("ctrt_eff_dt", "ctrtEffDt");
		this.hashFields.put("dest_nod_nm", "destNodNm");
		this.hashFields.put("ctrt_cust_cd", "ctrtCustCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("chk", "chk");
		this.hashFields.put("ctrt_tp_cd", "ctrtTpCd");
		this.hashFields.put("ntfc_act_flg", "ntfcActFlg");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("ctrt_cust_nm", "ctrtCustNm");
		this.hashFields.put("dest_nod_yd", "destNodYd");
		this.hashFields.put("do_ntfc_set_seq", "doNtfcSetSeq");
		this.hashFields.put("dest_nod_cd", "destNodCd");
		this.hashFields.put("upd_usr_nm", "updUsrNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("ctrt_exp_dt", "ctrtExpDt");
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
	 * @return ctrtCustCntCd
	 */
	public String getCtrtCustCntCd() {
		return this.ctrtCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtCustSeq
	 */
	public String getCtrtCustSeq() {
		return this.ctrtCustSeq;
	}
	
	/**
	 * Column Info
	 * @return ctrtEffDt
	 */
	public String getCtrtEffDt() {
		return this.ctrtEffDt;
	}
	
	/**
	 * Column Info
	 * @return destNodNm
	 */
	public String getDestNodNm() {
		return this.destNodNm;
	}
	
	/**
	 * Column Info
	 * @return ctrtCustCd
	 */
	public String getCtrtCustCd() {
		return this.ctrtCustCd;
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
	 * @return chk
	 */
	public String getChk() {
		return this.chk;
	}
	
	/**
	 * Column Info
	 * @return ctrtTpCd
	 */
	public String getCtrtTpCd() {
		return ctrtTpCd;
	}

	/**
	 * Column Info
	 * @param ctrtTpCd
	 */
	public void setCtrtTpCd(String ctrtTpCd) {
		this.ctrtTpCd = ctrtTpCd;
	}

	/**
	 * Column Info
	 * @return ntfcActFlg
	 */
	public String getNtfcActFlg() {
		return this.ntfcActFlg;
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
	 * @return ctrtCustNm
	 */
	public String getCtrtCustNm() {
		return this.ctrtCustNm;
	}
	
	/**
	 * Column Info
	 * @return destNodYd
	 */
	public String getDestNodYd() {
		return this.destNodYd;
	}
	
	/**
	 * Column Info
	 * @return doNtfcSetSeq
	 */
	public String getDoNtfcSetSeq() {
		return this.doNtfcSetSeq;
	}
	
	/**
	 * Column Info
	 * @return destNodCd
	 */
	public String getDestNodCd() {
		return this.destNodCd;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return ctrtExpDt
	 */
	public String getCtrtExpDt() {
		return this.ctrtExpDt;
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
	 * @param ctrtCustCntCd
	 */
	public void setCtrtCustCntCd(String ctrtCustCntCd) {
		this.ctrtCustCntCd = ctrtCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtCustSeq
	 */
	public void setCtrtCustSeq(String ctrtCustSeq) {
		this.ctrtCustSeq = ctrtCustSeq;
	}
	
	/**
	 * Column Info
	 * @param ctrtEffDt
	 */
	public void setCtrtEffDt(String ctrtEffDt) {
		this.ctrtEffDt = ctrtEffDt;
	}
	
	/**
	 * Column Info
	 * @param destNodNm
	 */
	public void setDestNodNm(String destNodNm) {
		this.destNodNm = destNodNm;
	}
	
	/**
	 * Column Info
	 * @param ctrtCustCd
	 */
	public void setCtrtCustCd(String ctrtCustCd) {
		this.ctrtCustCd = ctrtCustCd;
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
	 * @param chk
	 */
	public void setChk(String chk) {
		this.chk = chk;
	}
	
	/**
	 * Column Info
	 * @param ntfcActFlg
	 */
	public void setNtfcActFlg(String ntfcActFlg) {
		this.ntfcActFlg = ntfcActFlg;
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
	 * @param ctrtCustNm
	 */
	public void setCtrtCustNm(String ctrtCustNm) {
		this.ctrtCustNm = ctrtCustNm;
	}
	
	/**
	 * Column Info
	 * @param destNodYd
	 */
	public void setDestNodYd(String destNodYd) {
		this.destNodYd = destNodYd;
	}
	
	/**
	 * Column Info
	 * @param doNtfcSetSeq
	 */
	public void setDoNtfcSetSeq(String doNtfcSetSeq) {
		this.doNtfcSetSeq = doNtfcSetSeq;
	}
	
	/**
	 * Column Info
	 * @param destNodCd
	 */
	public void setDestNodCd(String destNodCd) {
		this.destNodCd = destNodCd;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param ctrtExpDt
	 */
	public void setCtrtExpDt(String ctrtExpDt) {
		this.ctrtExpDt = ctrtExpDt;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCtrtCustCntCd(JSPUtil.getParameter(request, prefix + "ctrt_cust_cnt_cd", ""));
		setCtrtCustSeq(JSPUtil.getParameter(request, prefix + "ctrt_cust_seq", ""));
		setCtrtEffDt(JSPUtil.getParameter(request, prefix + "ctrt_eff_dt", ""));
		setDestNodNm(JSPUtil.getParameter(request, prefix + "dest_nod_nm", ""));
		setCtrtCustCd(JSPUtil.getParameter(request, prefix + "ctrt_cust_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setChk(JSPUtil.getParameter(request, prefix + "chk", ""));
		setCtrtTpCd(JSPUtil.getParameter(request, prefix + "ctrt_tp_cd", ""));
		setNtfcActFlg(JSPUtil.getParameter(request, prefix + "ntfc_act_flg", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setCtrtCustNm(JSPUtil.getParameter(request, prefix + "ctrt_cust_nm", ""));
		setDestNodYd(JSPUtil.getParameter(request, prefix + "dest_nod_yd", ""));
		setDoNtfcSetSeq(JSPUtil.getParameter(request, prefix + "do_ntfc_set_seq", ""));
		setDestNodCd(JSPUtil.getParameter(request, prefix + "dest_nod_cd", ""));
		setUpdUsrNm(JSPUtil.getParameter(request, prefix + "upd_usr_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCtrtExpDt(JSPUtil.getParameter(request, prefix + "ctrt_exp_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DoNotificationSettingListVO[]
	 */
	public DoNotificationSettingListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DoNotificationSettingListVO[]
	 */
	public DoNotificationSettingListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DoNotificationSettingListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] ctrtCustCntCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_cnt_cd", length));
			String[] ctrtCustSeq = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_seq", length));
			String[] ctrtEffDt = (JSPUtil.getParameter(request, prefix	+ "ctrt_eff_dt", length));
			String[] destNodNm = (JSPUtil.getParameter(request, prefix	+ "dest_nod_nm", length));
			String[] ctrtCustCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] chk = (JSPUtil.getParameter(request, prefix	+ "chk", length));
			String[] ctrtTpCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_tp_cd", length));
			String[] ntfcActFlg = (JSPUtil.getParameter(request, prefix	+ "ntfc_act_flg", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] ctrtCustNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_nm", length));
			String[] destNodYd = (JSPUtil.getParameter(request, prefix	+ "dest_nod_yd", length));
			String[] doNtfcSetSeq = (JSPUtil.getParameter(request, prefix	+ "do_ntfc_set_seq", length));
			String[] destNodCd = (JSPUtil.getParameter(request, prefix	+ "dest_nod_cd", length));
			String[] updUsrNm = (JSPUtil.getParameter(request, prefix	+ "upd_usr_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] ctrtExpDt = (JSPUtil.getParameter(request, prefix	+ "ctrt_exp_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new DoNotificationSettingListVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ctrtCustCntCd[i] != null)
					model.setCtrtCustCntCd(ctrtCustCntCd[i]);
				if (ctrtCustSeq[i] != null)
					model.setCtrtCustSeq(ctrtCustSeq[i]);
				if (ctrtEffDt[i] != null)
					model.setCtrtEffDt(ctrtEffDt[i]);
				if (destNodNm[i] != null)
					model.setDestNodNm(destNodNm[i]);
				if (ctrtCustCd[i] != null)
					model.setCtrtCustCd(ctrtCustCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (chk[i] != null)
					model.setChk(chk[i]);
				if (ctrtTpCd[i] != null)
					model.setCtrtTpCd(ctrtTpCd[i]);
				if (ntfcActFlg[i] != null)
					model.setNtfcActFlg(ntfcActFlg[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (ctrtCustNm[i] != null)
					model.setCtrtCustNm(ctrtCustNm[i]);
				if (destNodYd[i] != null)
					model.setDestNodYd(destNodYd[i]);
				if (doNtfcSetSeq[i] != null)
					model.setDoNtfcSetSeq(doNtfcSetSeq[i]);
				if (destNodCd[i] != null)
					model.setDestNodCd(destNodCd[i]);
				if (updUsrNm[i] != null)
					model.setUpdUsrNm(updUsrNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (ctrtExpDt[i] != null)
					model.setCtrtExpDt(ctrtExpDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDoNotificationSettingListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DoNotificationSettingListVO[]
	 */
	public DoNotificationSettingListVO[] getDoNotificationSettingListVOs(){
		DoNotificationSettingListVO[] vos = (DoNotificationSettingListVO[])models.toArray(new DoNotificationSettingListVO[models.size()]);
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
		this.ctrtCustCntCd = this.ctrtCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustSeq = this.ctrtCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtEffDt = this.ctrtEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destNodNm = this.destNodNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustCd = this.ctrtCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk = this.chk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtTpCd = this.ctrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfcActFlg = this.ntfcActFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustNm = this.ctrtCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destNodYd = this.destNodYd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doNtfcSetSeq = this.doNtfcSetSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destNodCd = this.destNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrNm = this.updUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtExpDt = this.ctrtExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchTerminalAgreeementSummaryListVO.java
*@FileTitle : SearchTerminalAgreeementSummaryListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.08.10 yOng hO lEE 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author yOng hO lEE
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchTerminalAgreeementSummaryListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchTerminalAgreeementSummaryListVO> models = new ArrayList<SearchTerminalAgreeementSummaryListVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String tmlAgmtStsCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String tmlAgmtOfcCtyCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String verNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String tmlAgmtSeq = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String ydNm = null;
	/* Column Info */
	private String effFmDt = null;
	/* Column Info */
	private String autoXtdFlg = null;
	/* Column Info */
	private String effToDt = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchTerminalAgreeementSummaryListVO() {}

	public SearchTerminalAgreeementSummaryListVO(String ibflag, String pagerows, String tmlAgmtOfcCtyCd, String tmlAgmtSeq, String agmtNo, String verNo, String ydCd, String vndrSeq, String ydNm, String vndrLglEngNm, String effFmDt, String effToDt, String autoXtdFlg, String ctrtOfcCd, String currCd, String creDt, String creUsrId, String updDt, String updUsrId, String deltFlg, String tmlAgmtStsCd, String creOfcCd) {
		this.updDt = updDt;
		this.tmlAgmtStsCd = tmlAgmtStsCd;
		this.currCd = currCd;
		this.tmlAgmtOfcCtyCd = tmlAgmtOfcCtyCd;
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.agmtNo = agmtNo;
		this.vndrLglEngNm = vndrLglEngNm;
		this.pagerows = pagerows;
		this.verNo = verNo;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.ydCd = ydCd;
		this.creOfcCd = creOfcCd;
		this.ctrtOfcCd = ctrtOfcCd;
		this.tmlAgmtSeq = tmlAgmtSeq;
		this.vndrSeq = vndrSeq;
		this.ydNm = ydNm;
		this.effFmDt = effFmDt;
		this.autoXtdFlg = autoXtdFlg;
		this.effToDt = effToDt;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("tml_agmt_sts_cd", getTmlAgmtStsCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("tml_agmt_ofc_cty_cd", getTmlAgmtOfcCtyCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ver_no", getVerNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("tml_agmt_seq", getTmlAgmtSeq());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("yd_nm", getYdNm());
		this.hashColumns.put("eff_fm_dt", getEffFmDt());
		this.hashColumns.put("auto_xtd_flg", getAutoXtdFlg());
		this.hashColumns.put("eff_to_dt", getEffToDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("tml_agmt_sts_cd", "tmlAgmtStsCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("tml_agmt_ofc_cty_cd", "tmlAgmtOfcCtyCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ver_no", "verNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("tml_agmt_seq", "tmlAgmtSeq");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("yd_nm", "ydNm");
		this.hashFields.put("eff_fm_dt", "effFmDt");
		this.hashFields.put("auto_xtd_flg", "autoXtdFlg");
		this.hashFields.put("eff_to_dt", "effToDt");
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
	 * @return tmlAgmtStsCd
	 */
	public String getTmlAgmtStsCd() {
		return this.tmlAgmtStsCd;
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
	 * @return tmlAgmtOfcCtyCd
	 */
	public String getTmlAgmtOfcCtyCd() {
		return this.tmlAgmtOfcCtyCd;
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
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
	}
	
	/**
	 * Column Info
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
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
	 * @return verNo
	 */
	public String getVerNo() {
		return this.verNo;
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
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtOfcCd
	 */
	public String getCtrtOfcCd() {
		return this.ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @return tmlAgmtSeq
	 */
	public String getTmlAgmtSeq() {
		return this.tmlAgmtSeq;
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
	 * @return ydNm
	 */
	public String getYdNm() {
		return this.ydNm;
	}
	
	/**
	 * Column Info
	 * @return effFmDt
	 */
	public String getEffFmDt() {
		return this.effFmDt;
	}
	
	/**
	 * Column Info
	 * @return autoXtdFlg
	 */
	public String getAutoXtdFlg() {
		return this.autoXtdFlg;
	}
	
	/**
	 * Column Info
	 * @return effToDt
	 */
	public String getEffToDt() {
		return this.effToDt;
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
	 * @param tmlAgmtStsCd
	 */
	public void setTmlAgmtStsCd(String tmlAgmtStsCd) {
		this.tmlAgmtStsCd = tmlAgmtStsCd;
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
	 * @param tmlAgmtOfcCtyCd
	 */
	public void setTmlAgmtOfcCtyCd(String tmlAgmtOfcCtyCd) {
		this.tmlAgmtOfcCtyCd = tmlAgmtOfcCtyCd;
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
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}
	
	/**
	 * Column Info
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
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
	 * @param verNo
	 */
	public void setVerNo(String verNo) {
		this.verNo = verNo;
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
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtOfcCd
	 */
	public void setCtrtOfcCd(String ctrtOfcCd) {
		this.ctrtOfcCd = ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @param tmlAgmtSeq
	 */
	public void setTmlAgmtSeq(String tmlAgmtSeq) {
		this.tmlAgmtSeq = tmlAgmtSeq;
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
	 * @param ydNm
	 */
	public void setYdNm(String ydNm) {
		this.ydNm = ydNm;
	}
	
	/**
	 * Column Info
	 * @param effFmDt
	 */
	public void setEffFmDt(String effFmDt) {
		this.effFmDt = effFmDt;
	}
	
	/**
	 * Column Info
	 * @param autoXtdFlg
	 */
	public void setAutoXtdFlg(String autoXtdFlg) {
		this.autoXtdFlg = autoXtdFlg;
	}
	
	/**
	 * Column Info
	 * @param effToDt
	 */
	public void setEffToDt(String effToDt) {
		this.effToDt = effToDt;
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
		setTmlAgmtStsCd(JSPUtil.getParameter(request, "tml_agmt_sts_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setTmlAgmtOfcCtyCd(JSPUtil.getParameter(request, "tml_agmt_ofc_cty_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, "vndr_lgl_eng_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVerNo(JSPUtil.getParameter(request, "ver_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, "ctrt_ofc_cd", ""));
		setTmlAgmtSeq(JSPUtil.getParameter(request, "tml_agmt_seq", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setYdNm(JSPUtil.getParameter(request, "yd_nm", ""));
		setEffFmDt(JSPUtil.getParameter(request, "eff_fm_dt", ""));
		setAutoXtdFlg(JSPUtil.getParameter(request, "auto_xtd_flg", ""));
		setEffToDt(JSPUtil.getParameter(request, "eff_to_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchTerminalAgreeementSummaryListVO[]
	 */
	public SearchTerminalAgreeementSummaryListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchTerminalAgreeementSummaryListVO[]
	 */
	public SearchTerminalAgreeementSummaryListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchTerminalAgreeementSummaryListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] tmlAgmtStsCd = (JSPUtil.getParameter(request, prefix	+ "tml_agmt_sts_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] tmlAgmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "tml_agmt_ofc_cty_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] verNo = (JSPUtil.getParameter(request, prefix	+ "ver_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] tmlAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "tml_agmt_seq", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] ydNm = (JSPUtil.getParameter(request, prefix	+ "yd_nm", length));
			String[] effFmDt = (JSPUtil.getParameter(request, prefix	+ "eff_fm_dt", length));
			String[] autoXtdFlg = (JSPUtil.getParameter(request, prefix	+ "auto_xtd_flg", length));
			String[] effToDt = (JSPUtil.getParameter(request, prefix	+ "eff_to_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchTerminalAgreeementSummaryListVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (tmlAgmtStsCd[i] != null)
					model.setTmlAgmtStsCd(tmlAgmtStsCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (tmlAgmtOfcCtyCd[i] != null)
					model.setTmlAgmtOfcCtyCd(tmlAgmtOfcCtyCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (verNo[i] != null)
					model.setVerNo(verNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (tmlAgmtSeq[i] != null)
					model.setTmlAgmtSeq(tmlAgmtSeq[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (ydNm[i] != null)
					model.setYdNm(ydNm[i]);
				if (effFmDt[i] != null)
					model.setEffFmDt(effFmDt[i]);
				if (autoXtdFlg[i] != null)
					model.setAutoXtdFlg(autoXtdFlg[i]);
				if (effToDt[i] != null)
					model.setEffToDt(effToDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchTerminalAgreeementSummaryListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchTerminalAgreeementSummaryListVO[]
	 */
	public SearchTerminalAgreeementSummaryListVO[] getSearchTerminalAgreeementSummaryListVOs(){
		SearchTerminalAgreeementSummaryListVO[] vos = (SearchTerminalAgreeementSummaryListVO[])models.toArray(new SearchTerminalAgreeementSummaryListVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlAgmtStsCd = this.tmlAgmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlAgmtOfcCtyCd = this.tmlAgmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.verNo = this.verNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlAgmtSeq = this.tmlAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydNm = this.ydNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effFmDt = this.effFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoXtdFlg = this.autoXtdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effToDt = this.effToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

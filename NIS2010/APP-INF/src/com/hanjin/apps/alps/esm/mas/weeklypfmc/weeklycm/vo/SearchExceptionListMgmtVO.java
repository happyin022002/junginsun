/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SearchExceptionListMgmtVO.java
*@FileTitle : SearchExceptionListMgmtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.15
*@LastModifier : 유제량
*@LastVersion : 1.0
* 2015.06.15 유제량 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo;

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
 * @author 유제량
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchExceptionListMgmtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchExceptionListMgmtVO> models = new ArrayList<SearchExceptionListMgmtVO>();
	
	/* Column Info */
	private String costExptFlg = null;
	/* Column Info */
	private String ctrtSeq = null;
	/* Column Info */
	private String actShprCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String scnoScccd = null;
	/* Column Info */
	private String fScno = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String sccCd = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String tYearmonth = null;
	/* Column Info */
	private String actShprCntCd = null;
	/* Column Info */
	private String fYearmonth = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String actShprSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchExceptionListMgmtVO() {}

	public SearchExceptionListMgmtVO(String ibflag, String pagerows, String cntCd, String costYrmon, String scNo, String sccCd, String scnoScccd, String ctrtSeq, String cmdtCd, String actShprCntCd, String actShprSeq, String actShprCd, String costExptFlg, String fYearmonth, String tYearmonth, String fScno, String updUsrId) {
		this.costExptFlg = costExptFlg;
		this.ctrtSeq = ctrtSeq;
		this.actShprCd = actShprCd;
		this.pagerows = pagerows;
		this.scnoScccd = scnoScccd;
		this.fScno = fScno;
		this.ibflag = ibflag;
		this.costYrmon = costYrmon;
		this.sccCd = sccCd;
		this.cmdtCd = cmdtCd;
		this.scNo = scNo;
		this.cntCd = cntCd;
		this.tYearmonth = tYearmonth;
		this.actShprCntCd = actShprCntCd;
		this.fYearmonth = fYearmonth;
		this.updUsrId = updUsrId;
		this.actShprSeq = actShprSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cost_expt_flg", getCostExptFlg());
		this.hashColumns.put("ctrt_seq", getCtrtSeq());
		this.hashColumns.put("act_shpr_cd", getActShprCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("scno_scccd", getScnoScccd());
		this.hashColumns.put("f_scno", getFScno());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("scc_cd", getSccCd());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("t_yearmonth", getTYearmonth());
		this.hashColumns.put("act_shpr_cnt_cd", getActShprCntCd());
		this.hashColumns.put("f_yearmonth", getFYearmonth());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("act_shpr_seq", getActShprSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cost_expt_flg", "costExptFlg");
		this.hashFields.put("ctrt_seq", "ctrtSeq");
		this.hashFields.put("act_shpr_cd", "actShprCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("scno_scccd", "scnoScccd");
		this.hashFields.put("f_scno", "fScno");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("scc_cd", "sccCd");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("t_yearmonth", "tYearmonth");
		this.hashFields.put("act_shpr_cnt_cd", "actShprCntCd");
		this.hashFields.put("f_yearmonth", "fYearmonth");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("act_shpr_seq", "actShprSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return costExptFlg
	 */
	public String getCostExptFlg() {
		return this.costExptFlg;
	}
	
	/**
	 * Column Info
	 * @return ctrtSeq
	 */
	public String getCtrtSeq() {
		return this.ctrtSeq;
	}
	
	/**
	 * Column Info
	 * @return actShprCd
	 */
	public String getActShprCd() {
		return this.actShprCd;
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
	 * @return scnoScccd
	 */
	public String getScnoScccd() {
		return this.scnoScccd;
	}
	
	/**
	 * Column Info
	 * @return fScno
	 */
	public String getFScno() {
		return this.fScno;
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
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
	}
	
	/**
	 * Column Info
	 * @return sccCd
	 */
	public String getSccCd() {
		return this.sccCd;
	}
	
	/**
	 * Column Info
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
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
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return tYearmonth
	 */
	public String getTYearmonth() {
		return this.tYearmonth;
	}
	
	/**
	 * Column Info
	 * @return actShprCntCd
	 */
	public String getActShprCntCd() {
		return this.actShprCntCd;
	}
	
	/**
	 * Column Info
	 * @return fYearmonth
	 */
	public String getFYearmonth() {
		return this.fYearmonth;
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
	 * @return actShprSeq
	 */
	public String getActShprSeq() {
		return this.actShprSeq;
	}
	

	/**
	 * Column Info
	 * @param costExptFlg
	 */
	public void setCostExptFlg(String costExptFlg) {
		this.costExptFlg = costExptFlg;
	}
	
	/**
	 * Column Info
	 * @param ctrtSeq
	 */
	public void setCtrtSeq(String ctrtSeq) {
		this.ctrtSeq = ctrtSeq;
	}
	
	/**
	 * Column Info
	 * @param actShprCd
	 */
	public void setActShprCd(String actShprCd) {
		this.actShprCd = actShprCd;
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
	 * @param scnoScccd
	 */
	public void setScnoScccd(String scnoScccd) {
		this.scnoScccd = scnoScccd;
	}
	
	/**
	 * Column Info
	 * @param fScno
	 */
	public void setFScno(String fScno) {
		this.fScno = fScno;
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
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
	}
	
	/**
	 * Column Info
	 * @param sccCd
	 */
	public void setSccCd(String sccCd) {
		this.sccCd = sccCd;
	}
	
	/**
	 * Column Info
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
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
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param tYearmonth
	 */
	public void setTYearmonth(String tYearmonth) {
		this.tYearmonth = tYearmonth;
	}
	
	/**
	 * Column Info
	 * @param actShprCntCd
	 */
	public void setActShprCntCd(String actShprCntCd) {
		this.actShprCntCd = actShprCntCd;
	}
	
	/**
	 * Column Info
	 * @param fYearmonth
	 */
	public void setFYearmonth(String fYearmonth) {
		this.fYearmonth = fYearmonth;
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
	 * @param actShprSeq
	 */
	public void setActShprSeq(String actShprSeq) {
		this.actShprSeq = actShprSeq;
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
		setCostExptFlg(JSPUtil.getParameter(request, prefix + "cost_expt_flg", ""));
		setCtrtSeq(JSPUtil.getParameter(request, prefix + "ctrt_seq", ""));
		setActShprCd(JSPUtil.getParameter(request, prefix + "act_shpr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setScnoScccd(JSPUtil.getParameter(request, prefix + "scno_scccd", ""));
		setFScno(JSPUtil.getParameter(request, prefix + "f_scno", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setSccCd(JSPUtil.getParameter(request, prefix + "scc_cd", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setTYearmonth(JSPUtil.getParameter(request, prefix + "t_yearmonth", ""));
		setActShprCntCd(JSPUtil.getParameter(request, prefix + "act_shpr_cnt_cd", ""));
		setFYearmonth(JSPUtil.getParameter(request, prefix + "f_yearmonth", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setActShprSeq(JSPUtil.getParameter(request, prefix + "act_shpr_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchExceptionListMgmtVO[]
	 */
	public SearchExceptionListMgmtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchExceptionListMgmtVO[]
	 */
	public SearchExceptionListMgmtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchExceptionListMgmtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] costExptFlg = (JSPUtil.getParameter(request, prefix	+ "cost_expt_flg", length));
			String[] ctrtSeq = (JSPUtil.getParameter(request, prefix	+ "ctrt_seq", length));
			String[] actShprCd = (JSPUtil.getParameter(request, prefix	+ "act_shpr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] scnoScccd = (JSPUtil.getParameter(request, prefix	+ "scno_scccd", length));
			String[] fScno = (JSPUtil.getParameter(request, prefix	+ "f_scno", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] sccCd = (JSPUtil.getParameter(request, prefix	+ "scc_cd", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] tYearmonth = (JSPUtil.getParameter(request, prefix	+ "t_yearmonth", length));
			String[] actShprCntCd = (JSPUtil.getParameter(request, prefix	+ "act_shpr_cnt_cd", length));
			String[] fYearmonth = (JSPUtil.getParameter(request, prefix	+ "f_yearmonth", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] actShprSeq = (JSPUtil.getParameter(request, prefix	+ "act_shpr_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchExceptionListMgmtVO();
				if (costExptFlg[i] != null)
					model.setCostExptFlg(costExptFlg[i]);
				if (ctrtSeq[i] != null)
					model.setCtrtSeq(ctrtSeq[i]);
				if (actShprCd[i] != null)
					model.setActShprCd(actShprCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (scnoScccd[i] != null)
					model.setScnoScccd(scnoScccd[i]);
				if (fScno[i] != null)
					model.setFScno(fScno[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (sccCd[i] != null)
					model.setSccCd(sccCd[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (tYearmonth[i] != null)
					model.setTYearmonth(tYearmonth[i]);
				if (actShprCntCd[i] != null)
					model.setActShprCntCd(actShprCntCd[i]);
				if (fYearmonth[i] != null)
					model.setFYearmonth(fYearmonth[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (actShprSeq[i] != null)
					model.setActShprSeq(actShprSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchExceptionListMgmtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchExceptionListMgmtVO[]
	 */
	public SearchExceptionListMgmtVO[] getSearchExceptionListMgmtVOs(){
		SearchExceptionListMgmtVO[] vos = (SearchExceptionListMgmtVO[])models.toArray(new SearchExceptionListMgmtVO[models.size()]);
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
		this.costExptFlg = this.costExptFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtSeq = this.ctrtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actShprCd = this.actShprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scnoScccd = this.scnoScccd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fScno = this.fScno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccCd = this.sccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tYearmonth = this.tYearmonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actShprCntCd = this.actShprCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fYearmonth = this.fYearmonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actShprSeq = this.actShprSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

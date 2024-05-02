/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchOTSAgingBaseVO.java
*@FileTitle : SearchOTSAgingBaseVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.21
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.21  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo;

import java.lang.reflect.Field;
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchOTSAgingBaseVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchOTSAgingBaseVO> models = new ArrayList<SearchOTSAgingBaseVO>();
	
	/* Column Info */
	private String balUsdAmt = null;
	/* Column Info */
	private String sumTp = null;
	/* Column Info */
	private String balLoclAmt = null;
	/* Column Info */
	private String obBalUsdAmt = null;
	/* Column Info */
	private String cnt = null;
	/* Column Info */
	private String stlFlg = null;
	/* Column Info */
	private String cltOfcCd = null;
	/* Column Info */
	private String blInvTp = null;
	/* Column Info */
	private String blSumTp = null;
	/* Column Info */
	private String sailArrDt = null;
	/* Column Info */
	private String ibBalLoclAmt = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String crMkFlg = null;
	/* Column Info */
	private String obBalLoclAmt = null;
	/* Column Info */
	private String otsGrpTpCd = null;
	/* Column Info */
	private String ibBalUsdAmt = null;
	/* Column Info */
	private String dueDt = null;
	/* Column Info */
	private String otsSrcCd = null;
	/* Column Info */
	private String otsRtFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchOTSAgingBaseVO() {}

	public SearchOTSAgingBaseVO(String ibflag, String pagerows, String sailArrDt, String stlFlg, String crMkFlg, String otsGrpTpCd, String otsRtFlg, String dueDt, String otsSrcCd, String blSumTp, String blInvTp, String sumTp, String cltOfcCd, String custLglEngNm, String cnt, String ibBalLoclAmt, String obBalLoclAmt, String ibBalUsdAmt, String obBalUsdAmt, String balLoclAmt, String balUsdAmt) {
		this.balUsdAmt = balUsdAmt;
		this.sumTp = sumTp;
		this.balLoclAmt = balLoclAmt;
		this.obBalUsdAmt = obBalUsdAmt;
		this.cnt = cnt;
		this.stlFlg = stlFlg;
		this.cltOfcCd = cltOfcCd;
		this.blInvTp = blInvTp;
		this.blSumTp = blSumTp;
		this.sailArrDt = sailArrDt;
		this.ibBalLoclAmt = ibBalLoclAmt;
		this.custLglEngNm = custLglEngNm;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.crMkFlg = crMkFlg;
		this.obBalLoclAmt = obBalLoclAmt;
		this.otsGrpTpCd = otsGrpTpCd;
		this.ibBalUsdAmt = ibBalUsdAmt;
		this.dueDt = dueDt;
		this.otsSrcCd = otsSrcCd;
		this.otsRtFlg = otsRtFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bal_usd_amt", getBalUsdAmt());
		this.hashColumns.put("sum_tp", getSumTp());
		this.hashColumns.put("bal_locl_amt", getBalLoclAmt());
		this.hashColumns.put("ob_bal_usd_amt", getObBalUsdAmt());
		this.hashColumns.put("cnt", getCnt());
		this.hashColumns.put("stl_flg", getStlFlg());
		this.hashColumns.put("clt_ofc_cd", getCltOfcCd());
		this.hashColumns.put("bl_inv_tp", getBlInvTp());
		this.hashColumns.put("bl_sum_tp", getBlSumTp());
		this.hashColumns.put("sail_arr_dt", getSailArrDt());
		this.hashColumns.put("ib_bal_locl_amt", getIbBalLoclAmt());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cr_mk_flg", getCrMkFlg());
		this.hashColumns.put("ob_bal_locl_amt", getObBalLoclAmt());
		this.hashColumns.put("ots_grp_tp_cd", getOtsGrpTpCd());
		this.hashColumns.put("ib_bal_usd_amt", getIbBalUsdAmt());
		this.hashColumns.put("due_dt", getDueDt());
		this.hashColumns.put("ots_src_cd", getOtsSrcCd());
		this.hashColumns.put("ots_rt_flg", getOtsRtFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bal_usd_amt", "balUsdAmt");
		this.hashFields.put("sum_tp", "sumTp");
		this.hashFields.put("bal_locl_amt", "balLoclAmt");
		this.hashFields.put("ob_bal_usd_amt", "obBalUsdAmt");
		this.hashFields.put("cnt", "cnt");
		this.hashFields.put("stl_flg", "stlFlg");
		this.hashFields.put("clt_ofc_cd", "cltOfcCd");
		this.hashFields.put("bl_inv_tp", "blInvTp");
		this.hashFields.put("bl_sum_tp", "blSumTp");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("ib_bal_locl_amt", "ibBalLoclAmt");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cr_mk_flg", "crMkFlg");
		this.hashFields.put("ob_bal_locl_amt", "obBalLoclAmt");
		this.hashFields.put("ots_grp_tp_cd", "otsGrpTpCd");
		this.hashFields.put("ib_bal_usd_amt", "ibBalUsdAmt");
		this.hashFields.put("due_dt", "dueDt");
		this.hashFields.put("ots_src_cd", "otsSrcCd");
		this.hashFields.put("ots_rt_flg", "otsRtFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return balUsdAmt
	 */
	public String getBalUsdAmt() {
		return this.balUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return sumTp
	 */
	public String getSumTp() {
		return this.sumTp;
	}
	
	/**
	 * Column Info
	 * @return balLoclAmt
	 */
	public String getBalLoclAmt() {
		return this.balLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return obBalUsdAmt
	 */
	public String getObBalUsdAmt() {
		return this.obBalUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return cnt
	 */
	public String getCnt() {
		return this.cnt;
	}
	
	/**
	 * Column Info
	 * @return stlFlg
	 */
	public String getStlFlg() {
		return this.stlFlg;
	}
	
	/**
	 * Column Info
	 * @return cltOfcCd
	 */
	public String getCltOfcCd() {
		return this.cltOfcCd;
	}
	
	/**
	 * Column Info
	 * @return blInvTp
	 */
	public String getBlInvTp() {
		return this.blInvTp;
	}
	
	/**
	 * Column Info
	 * @return blSumTp
	 */
	public String getBlSumTp() {
		return this.blSumTp;
	}
	
	/**
	 * Column Info
	 * @return sailArrDt
	 */
	public String getSailArrDt() {
		return this.sailArrDt;
	}
	
	/**
	 * Column Info
	 * @return ibBalLoclAmt
	 */
	public String getIbBalLoclAmt() {
		return this.ibBalLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return custLglEngNm
	 */
	public String getCustLglEngNm() {
		return this.custLglEngNm;
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
	 * @return crMkFlg
	 */
	public String getCrMkFlg() {
		return this.crMkFlg;
	}
	
	/**
	 * Column Info
	 * @return obBalLoclAmt
	 */
	public String getObBalLoclAmt() {
		return this.obBalLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return otsGrpTpCd
	 */
	public String getOtsGrpTpCd() {
		return this.otsGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @return ibBalUsdAmt
	 */
	public String getIbBalUsdAmt() {
		return this.ibBalUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return dueDt
	 */
	public String getDueDt() {
		return this.dueDt;
	}
	
	/**
	 * Column Info
	 * @return otsSrcCd
	 */
	public String getOtsSrcCd() {
		return this.otsSrcCd;
	}
	
	/**
	 * Column Info
	 * @return otsRtFlg
	 */
	public String getOtsRtFlg() {
		return this.otsRtFlg;
	}
	

	/**
	 * Column Info
	 * @param balUsdAmt
	 */
	public void setBalUsdAmt(String balUsdAmt) {
		this.balUsdAmt = balUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param sumTp
	 */
	public void setSumTp(String sumTp) {
		this.sumTp = sumTp;
	}
	
	/**
	 * Column Info
	 * @param balLoclAmt
	 */
	public void setBalLoclAmt(String balLoclAmt) {
		this.balLoclAmt = balLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param obBalUsdAmt
	 */
	public void setObBalUsdAmt(String obBalUsdAmt) {
		this.obBalUsdAmt = obBalUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param cnt
	 */
	public void setCnt(String cnt) {
		this.cnt = cnt;
	}
	
	/**
	 * Column Info
	 * @param stlFlg
	 */
	public void setStlFlg(String stlFlg) {
		this.stlFlg = stlFlg;
	}
	
	/**
	 * Column Info
	 * @param cltOfcCd
	 */
	public void setCltOfcCd(String cltOfcCd) {
		this.cltOfcCd = cltOfcCd;
	}
	
	/**
	 * Column Info
	 * @param blInvTp
	 */
	public void setBlInvTp(String blInvTp) {
		this.blInvTp = blInvTp;
	}
	
	/**
	 * Column Info
	 * @param blSumTp
	 */
	public void setBlSumTp(String blSumTp) {
		this.blSumTp = blSumTp;
	}
	
	/**
	 * Column Info
	 * @param sailArrDt
	 */
	public void setSailArrDt(String sailArrDt) {
		this.sailArrDt = sailArrDt;
	}
	
	/**
	 * Column Info
	 * @param ibBalLoclAmt
	 */
	public void setIbBalLoclAmt(String ibBalLoclAmt) {
		this.ibBalLoclAmt = ibBalLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param custLglEngNm
	 */
	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
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
	 * @param crMkFlg
	 */
	public void setCrMkFlg(String crMkFlg) {
		this.crMkFlg = crMkFlg;
	}
	
	/**
	 * Column Info
	 * @param obBalLoclAmt
	 */
	public void setObBalLoclAmt(String obBalLoclAmt) {
		this.obBalLoclAmt = obBalLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param otsGrpTpCd
	 */
	public void setOtsGrpTpCd(String otsGrpTpCd) {
		this.otsGrpTpCd = otsGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @param ibBalUsdAmt
	 */
	public void setIbBalUsdAmt(String ibBalUsdAmt) {
		this.ibBalUsdAmt = ibBalUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param dueDt
	 */
	public void setDueDt(String dueDt) {
		this.dueDt = dueDt;
	}
	
	/**
	 * Column Info
	 * @param otsSrcCd
	 */
	public void setOtsSrcCd(String otsSrcCd) {
		this.otsSrcCd = otsSrcCd;
	}
	
	/**
	 * Column Info
	 * @param otsRtFlg
	 */
	public void setOtsRtFlg(String otsRtFlg) {
		this.otsRtFlg = otsRtFlg;
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
		setBalUsdAmt(JSPUtil.getParameter(request, prefix + "bal_usd_amt", ""));
		setSumTp(JSPUtil.getParameter(request, prefix + "sum_tp", ""));
		setBalLoclAmt(JSPUtil.getParameter(request, prefix + "bal_locl_amt", ""));
		setObBalUsdAmt(JSPUtil.getParameter(request, prefix + "ob_bal_usd_amt", ""));
		setCnt(JSPUtil.getParameter(request, prefix + "cnt", ""));
		setStlFlg(JSPUtil.getParameter(request, prefix + "stl_flg", ""));
		setCltOfcCd(JSPUtil.getParameter(request, prefix + "clt_ofc_cd", ""));
		setBlInvTp(JSPUtil.getParameter(request, prefix + "bl_inv_tp", ""));
		setBlSumTp(JSPUtil.getParameter(request, prefix + "bl_sum_tp", ""));
		setSailArrDt(JSPUtil.getParameter(request, prefix + "sail_arr_dt", ""));
		setIbBalLoclAmt(JSPUtil.getParameter(request, prefix + "ib_bal_locl_amt", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCrMkFlg(JSPUtil.getParameter(request, prefix + "cr_mk_flg", ""));
		setObBalLoclAmt(JSPUtil.getParameter(request, prefix + "ob_bal_locl_amt", ""));
		setOtsGrpTpCd(JSPUtil.getParameter(request, prefix + "ots_grp_tp_cd", ""));
		setIbBalUsdAmt(JSPUtil.getParameter(request, prefix + "ib_bal_usd_amt", ""));
		setDueDt(JSPUtil.getParameter(request, prefix + "due_dt", ""));
		setOtsSrcCd(JSPUtil.getParameter(request, prefix + "ots_src_cd", ""));
		setOtsRtFlg(JSPUtil.getParameter(request, prefix + "ots_rt_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchOTSAgingBaseVO[]
	 */
	public SearchOTSAgingBaseVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchOTSAgingBaseVO[]
	 */
	public SearchOTSAgingBaseVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchOTSAgingBaseVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] balUsdAmt = (JSPUtil.getParameter(request, prefix	+ "bal_usd_amt", length));
			String[] sumTp = (JSPUtil.getParameter(request, prefix	+ "sum_tp", length));
			String[] balLoclAmt = (JSPUtil.getParameter(request, prefix	+ "bal_locl_amt", length));
			String[] obBalUsdAmt = (JSPUtil.getParameter(request, prefix	+ "ob_bal_usd_amt", length));
			String[] cnt = (JSPUtil.getParameter(request, prefix	+ "cnt", length));
			String[] stlFlg = (JSPUtil.getParameter(request, prefix	+ "stl_flg", length));
			String[] cltOfcCd = (JSPUtil.getParameter(request, prefix	+ "clt_ofc_cd", length));
			String[] blInvTp = (JSPUtil.getParameter(request, prefix	+ "bl_inv_tp", length));
			String[] blSumTp = (JSPUtil.getParameter(request, prefix	+ "bl_sum_tp", length));
			String[] sailArrDt = (JSPUtil.getParameter(request, prefix	+ "sail_arr_dt", length));
			String[] ibBalLoclAmt = (JSPUtil.getParameter(request, prefix	+ "ib_bal_locl_amt", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] crMkFlg = (JSPUtil.getParameter(request, prefix	+ "cr_mk_flg", length));
			String[] obBalLoclAmt = (JSPUtil.getParameter(request, prefix	+ "ob_bal_locl_amt", length));
			String[] otsGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "ots_grp_tp_cd", length));
			String[] ibBalUsdAmt = (JSPUtil.getParameter(request, prefix	+ "ib_bal_usd_amt", length));
			String[] dueDt = (JSPUtil.getParameter(request, prefix	+ "due_dt", length));
			String[] otsSrcCd = (JSPUtil.getParameter(request, prefix	+ "ots_src_cd", length));
			String[] otsRtFlg = (JSPUtil.getParameter(request, prefix	+ "ots_rt_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchOTSAgingBaseVO();
				if (balUsdAmt[i] != null)
					model.setBalUsdAmt(balUsdAmt[i]);
				if (sumTp[i] != null)
					model.setSumTp(sumTp[i]);
				if (balLoclAmt[i] != null)
					model.setBalLoclAmt(balLoclAmt[i]);
				if (obBalUsdAmt[i] != null)
					model.setObBalUsdAmt(obBalUsdAmt[i]);
				if (cnt[i] != null)
					model.setCnt(cnt[i]);
				if (stlFlg[i] != null)
					model.setStlFlg(stlFlg[i]);
				if (cltOfcCd[i] != null)
					model.setCltOfcCd(cltOfcCd[i]);
				if (blInvTp[i] != null)
					model.setBlInvTp(blInvTp[i]);
				if (blSumTp[i] != null)
					model.setBlSumTp(blSumTp[i]);
				if (sailArrDt[i] != null)
					model.setSailArrDt(sailArrDt[i]);
				if (ibBalLoclAmt[i] != null)
					model.setIbBalLoclAmt(ibBalLoclAmt[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (crMkFlg[i] != null)
					model.setCrMkFlg(crMkFlg[i]);
				if (obBalLoclAmt[i] != null)
					model.setObBalLoclAmt(obBalLoclAmt[i]);
				if (otsGrpTpCd[i] != null)
					model.setOtsGrpTpCd(otsGrpTpCd[i]);
				if (ibBalUsdAmt[i] != null)
					model.setIbBalUsdAmt(ibBalUsdAmt[i]);
				if (dueDt[i] != null)
					model.setDueDt(dueDt[i]);
				if (otsSrcCd[i] != null)
					model.setOtsSrcCd(otsSrcCd[i]);
				if (otsRtFlg[i] != null)
					model.setOtsRtFlg(otsRtFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchOTSAgingBaseVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchOTSAgingBaseVO[]
	 */
	public SearchOTSAgingBaseVO[] getSearchOTSAgingBaseVOs(){
		SearchOTSAgingBaseVO[] vos = (SearchOTSAgingBaseVO[])models.toArray(new SearchOTSAgingBaseVO[models.size()]);
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
		this.balUsdAmt = this.balUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumTp = this.sumTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.balLoclAmt = this.balLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obBalUsdAmt = this.obBalUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnt = this.cnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlFlg = this.stlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltOfcCd = this.cltOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blInvTp = this.blInvTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSumTp = this.blSumTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt = this.sailArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibBalLoclAmt = this.ibBalLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crMkFlg = this.crMkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obBalLoclAmt = this.obBalLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsGrpTpCd = this.otsGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibBalUsdAmt = this.ibBalUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDt = this.dueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsSrcCd = this.otsSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsRtFlg = this.otsRtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

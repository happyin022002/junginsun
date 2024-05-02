/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : TesActCostTpSzVO.java
*@FileTitle : TesActCostTpSzVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.21
*@LastModifier : 
*@LastVersion : 1.0
* 2013.03.21  
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TesActCostTpSzVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TesActCostTpSzVO> models = new ArrayList<TesActCostTpSzVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String loclCurrAmt = null;
	/* Column Info */
	private String cntrSzCd = null;
	/* Column Info */
	private String loclCurrCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String ioGaCd = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usdAmt = null;
	/* Column Info */
	private String usdXchDt = null;
	/* Column Info */
	private String tmlActCostSeq = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String tmlAwkCgoTrfTpCd = null;
	/* Column Info */
	private String tmlAwkTsCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TesActCostTpSzVO() {}

	public TesActCostTpSzVO(String ibflag, String pagerows, String tmlActCostSeq, String ydCd, String tmlAwkCgoTrfTpCd, String ioBndCd, String ioGaCd, String tmlAwkTsCd, String cntrSzCd, String loclCurrCd, String loclCurrAmt, String usdAmt, String usdXchDt, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.loclCurrAmt = loclCurrAmt;
		this.cntrSzCd = cntrSzCd;
		this.loclCurrCd = loclCurrCd;
		this.creDt = creDt;
		this.ioGaCd = ioGaCd;
		this.ioBndCd = ioBndCd;
		this.pagerows = pagerows;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.usdAmt = usdAmt;
		this.usdXchDt = usdXchDt;
		this.tmlActCostSeq = tmlActCostSeq;
		this.ydCd = ydCd;
		this.tmlAwkCgoTrfTpCd = tmlAwkCgoTrfTpCd;
		this.tmlAwkTsCd = tmlAwkTsCd;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("locl_curr_amt", getLoclCurrAmt());
		this.hashColumns.put("cntr_sz_cd", getCntrSzCd());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("io_ga_cd", getIoGaCd());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usd_amt", getUsdAmt());
		this.hashColumns.put("usd_xch_dt", getUsdXchDt());
		this.hashColumns.put("tml_act_cost_seq", getTmlActCostSeq());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("tml_awk_cgo_trf_tp_cd", getTmlAwkCgoTrfTpCd());
		this.hashColumns.put("tml_awk_ts_cd", getTmlAwkTsCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("locl_curr_amt", "loclCurrAmt");
		this.hashFields.put("cntr_sz_cd", "cntrSzCd");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("io_ga_cd", "ioGaCd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usd_amt", "usdAmt");
		this.hashFields.put("usd_xch_dt", "usdXchDt");
		this.hashFields.put("tml_act_cost_seq", "tmlActCostSeq");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("tml_awk_cgo_trf_tp_cd", "tmlAwkCgoTrfTpCd");
		this.hashFields.put("tml_awk_ts_cd", "tmlAwkTsCd");
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
	 * @return loclCurrAmt
	 */
	public String getLoclCurrAmt() {
		return this.loclCurrAmt;
	}
	
	/**
	 * Column Info
	 * @return cntrSzCd
	 */
	public String getCntrSzCd() {
		return this.cntrSzCd;
	}
	
	/**
	 * Column Info
	 * @return loclCurrCd
	 */
	public String getLoclCurrCd() {
		return this.loclCurrCd;
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
	 * @return ioGaCd
	 */
	public String getIoGaCd() {
		return this.ioGaCd;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
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
	 * @return usdAmt
	 */
	public String getUsdAmt() {
		return this.usdAmt;
	}
	
	/**
	 * Column Info
	 * @return usdXchDt
	 */
	public String getUsdXchDt() {
		return this.usdXchDt;
	}
	
	/**
	 * Column Info
	 * @return tmlActCostSeq
	 */
	public String getTmlActCostSeq() {
		return this.tmlActCostSeq;
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
	 * @return tmlAwkCgoTrfTpCd
	 */
	public String getTmlAwkCgoTrfTpCd() {
		return this.tmlAwkCgoTrfTpCd;
	}
	
	/**
	 * Column Info
	 * @return tmlAwkTsCd
	 */
	public String getTmlAwkTsCd() {
		return this.tmlAwkTsCd;
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
	 * @param loclCurrAmt
	 */
	public void setLoclCurrAmt(String loclCurrAmt) {
		this.loclCurrAmt = loclCurrAmt;
	}
	
	/**
	 * Column Info
	 * @param cntrSzCd
	 */
	public void setCntrSzCd(String cntrSzCd) {
		this.cntrSzCd = cntrSzCd;
	}
	
	/**
	 * Column Info
	 * @param loclCurrCd
	 */
	public void setLoclCurrCd(String loclCurrCd) {
		this.loclCurrCd = loclCurrCd;
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
	 * @param ioGaCd
	 */
	public void setIoGaCd(String ioGaCd) {
		this.ioGaCd = ioGaCd;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
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
	 * @param usdAmt
	 */
	public void setUsdAmt(String usdAmt) {
		this.usdAmt = usdAmt;
	}
	
	/**
	 * Column Info
	 * @param usdXchDt
	 */
	public void setUsdXchDt(String usdXchDt) {
		this.usdXchDt = usdXchDt;
	}
	
	/**
	 * Column Info
	 * @param tmlActCostSeq
	 */
	public void setTmlActCostSeq(String tmlActCostSeq) {
		this.tmlActCostSeq = tmlActCostSeq;
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
	 * @param tmlAwkCgoTrfTpCd
	 */
	public void setTmlAwkCgoTrfTpCd(String tmlAwkCgoTrfTpCd) {
		this.tmlAwkCgoTrfTpCd = tmlAwkCgoTrfTpCd;
	}
	
	/**
	 * Column Info
	 * @param tmlAwkTsCd
	 */
	public void setTmlAwkTsCd(String tmlAwkTsCd) {
		this.tmlAwkTsCd = tmlAwkTsCd;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setLoclCurrAmt(JSPUtil.getParameter(request, prefix + "locl_curr_amt", ""));
		setCntrSzCd(JSPUtil.getParameter(request, prefix + "cntr_sz_cd", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, prefix + "locl_curr_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setIoGaCd(JSPUtil.getParameter(request, prefix + "io_ga_cd", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsdAmt(JSPUtil.getParameter(request, prefix + "usd_amt", ""));
		setUsdXchDt(JSPUtil.getParameter(request, prefix + "usd_xch_dt", ""));
		setTmlActCostSeq(JSPUtil.getParameter(request, prefix + "tml_act_cost_seq", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setTmlAwkCgoTrfTpCd(JSPUtil.getParameter(request, prefix + "tml_awk_cgo_trf_tp_cd", ""));
		setTmlAwkTsCd(JSPUtil.getParameter(request, prefix + "tml_awk_ts_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TesActCostTpSzVO[]
	 */
	public TesActCostTpSzVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TesActCostTpSzVO[]
	 */
	public TesActCostTpSzVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TesActCostTpSzVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] loclCurrAmt = (JSPUtil.getParameter(request, prefix	+ "locl_curr_amt", length));
			String[] cntrSzCd = (JSPUtil.getParameter(request, prefix	+ "cntr_sz_cd", length));
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] ioGaCd = (JSPUtil.getParameter(request, prefix	+ "io_ga_cd", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usdAmt = (JSPUtil.getParameter(request, prefix	+ "usd_amt", length));
			String[] usdXchDt = (JSPUtil.getParameter(request, prefix	+ "usd_xch_dt", length));
			String[] tmlActCostSeq = (JSPUtil.getParameter(request, prefix	+ "tml_act_cost_seq", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] tmlAwkCgoTrfTpCd = (JSPUtil.getParameter(request, prefix	+ "tml_awk_cgo_trf_tp_cd", length));
			String[] tmlAwkTsCd = (JSPUtil.getParameter(request, prefix	+ "tml_awk_ts_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new TesActCostTpSzVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (loclCurrAmt[i] != null)
					model.setLoclCurrAmt(loclCurrAmt[i]);
				if (cntrSzCd[i] != null)
					model.setCntrSzCd(cntrSzCd[i]);
				if (loclCurrCd[i] != null)
					model.setLoclCurrCd(loclCurrCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (ioGaCd[i] != null)
					model.setIoGaCd(ioGaCd[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usdAmt[i] != null)
					model.setUsdAmt(usdAmt[i]);
				if (usdXchDt[i] != null)
					model.setUsdXchDt(usdXchDt[i]);
				if (tmlActCostSeq[i] != null)
					model.setTmlActCostSeq(tmlActCostSeq[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (tmlAwkCgoTrfTpCd[i] != null)
					model.setTmlAwkCgoTrfTpCd(tmlAwkCgoTrfTpCd[i]);
				if (tmlAwkTsCd[i] != null)
					model.setTmlAwkTsCd(tmlAwkTsCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTesActCostTpSzVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TesActCostTpSzVO[]
	 */
	public TesActCostTpSzVO[] getTesActCostTpSzVOs(){
		TesActCostTpSzVO[] vos = (TesActCostTpSzVO[])models.toArray(new TesActCostTpSzVO[models.size()]);
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
		this.loclCurrAmt = this.loclCurrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSzCd = this.cntrSzCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd = this.loclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioGaCd = this.ioGaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdAmt = this.usdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdXchDt = this.usdXchDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlActCostSeq = this.tmlActCostSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlAwkCgoTrfTpCd = this.tmlAwkCgoTrfTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlAwkTsCd = this.tmlAwkTsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

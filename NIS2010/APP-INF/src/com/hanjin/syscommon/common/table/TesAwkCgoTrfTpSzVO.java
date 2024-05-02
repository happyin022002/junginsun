/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : TesAwkCgoTrfTpSzVO.java
*@FileTitle : TesAwkCgoTrfTpSzVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.18
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.02.18 이혜민 
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

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
 * @author 이혜민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TesAwkCgoTrfTpSzVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TesAwkCgoTrfTpSzVO> models = new ArrayList<TesAwkCgoTrfTpSzVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String loclCurrAmt = null;
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
	private String spclCgoRefSeq = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String usdXchDt = null;
	/* Column Info */
	private String usdAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String tmlAwkCgoTrfTpCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String tmlAwkTrfVerNo = null;
	/* Column Info */
	private String tmlAwkUcCalcTpCd = null;
	/* Column Info */
	private String tmlAwkTsCd = null;
	/* Column Info */
	private String condNo = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TesAwkCgoTrfTpSzVO() {}

	public TesAwkCgoTrfTpSzVO(String ibflag, String pagerows, String ydCd, String tmlAwkCgoTrfTpCd, String ioBndCd, String ioGaCd, String tmlAwkTsCd, String condNo, String tmlAwkTrfVerNo, String tmlAwkUcCalcTpCd, String cntrTpszCd, String loclCurrCd, String loclCurrAmt, String usdAmt, String usdXchDt, String spclCgoRefSeq, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.loclCurrAmt = loclCurrAmt;
		this.loclCurrCd = loclCurrCd;
		this.creDt = creDt;
		this.ioGaCd = ioGaCd;
		this.ioBndCd = ioBndCd;
		this.pagerows = pagerows;
		this.spclCgoRefSeq = spclCgoRefSeq;
		this.creUsrId = creUsrId;
		this.usdXchDt = usdXchDt;
		this.usdAmt = usdAmt;
		this.ibflag = ibflag;
		this.ydCd = ydCd;
		this.tmlAwkCgoTrfTpCd = tmlAwkCgoTrfTpCd;
		this.cntrTpszCd = cntrTpszCd;
		this.tmlAwkTrfVerNo = tmlAwkTrfVerNo;
		this.tmlAwkUcCalcTpCd = tmlAwkUcCalcTpCd;
		this.tmlAwkTsCd = tmlAwkTsCd;
		this.condNo = condNo;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("locl_curr_amt", getLoclCurrAmt());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("io_ga_cd", getIoGaCd());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("spcl_cgo_ref_seq", getSpclCgoRefSeq());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("usd_xch_dt", getUsdXchDt());
		this.hashColumns.put("usd_amt", getUsdAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("tml_awk_cgo_trf_tp_cd", getTmlAwkCgoTrfTpCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("tml_awk_trf_ver_no", getTmlAwkTrfVerNo());
		this.hashColumns.put("tml_awk_uc_calc_tp_cd", getTmlAwkUcCalcTpCd());
		this.hashColumns.put("tml_awk_ts_cd", getTmlAwkTsCd());
		this.hashColumns.put("cond_no", getCondNo());
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
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("io_ga_cd", "ioGaCd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("spcl_cgo_ref_seq", "spclCgoRefSeq");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("usd_xch_dt", "usdXchDt");
		this.hashFields.put("usd_amt", "usdAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("tml_awk_cgo_trf_tp_cd", "tmlAwkCgoTrfTpCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("tml_awk_trf_ver_no", "tmlAwkTrfVerNo");
		this.hashFields.put("tml_awk_uc_calc_tp_cd", "tmlAwkUcCalcTpCd");
		this.hashFields.put("tml_awk_ts_cd", "tmlAwkTsCd");
		this.hashFields.put("cond_no", "condNo");
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
	 * @return spclCgoRefSeq
	 */
	public String getSpclCgoRefSeq() {
		return this.spclCgoRefSeq;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return usdAmt
	 */
	public String getUsdAmt() {
		return this.usdAmt;
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
	 * @return tmlAwkCgoTrfTpCd
	 */
	public String getTmlAwkCgoTrfTpCd() {
		return this.tmlAwkCgoTrfTpCd;
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
	 * @return tmlAwkTrfVerNo
	 */
	public String getTmlAwkTrfVerNo() {
		return this.tmlAwkTrfVerNo;
	}
	
	/**
	 * Column Info
	 * @return tmlAwkUcCalcTpCd
	 */
	public String getTmlAwkUcCalcTpCd() {
		return this.tmlAwkUcCalcTpCd;
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
	 * @return condNo
	 */
	public String getCondNo() {
		return this.condNo;
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
	 * @param spclCgoRefSeq
	 */
	public void setSpclCgoRefSeq(String spclCgoRefSeq) {
		this.spclCgoRefSeq = spclCgoRefSeq;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param usdAmt
	 */
	public void setUsdAmt(String usdAmt) {
		this.usdAmt = usdAmt;
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
	 * @param tmlAwkCgoTrfTpCd
	 */
	public void setTmlAwkCgoTrfTpCd(String tmlAwkCgoTrfTpCd) {
		this.tmlAwkCgoTrfTpCd = tmlAwkCgoTrfTpCd;
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
	 * @param tmlAwkTrfVerNo
	 */
	public void setTmlAwkTrfVerNo(String tmlAwkTrfVerNo) {
		this.tmlAwkTrfVerNo = tmlAwkTrfVerNo;
	}
	
	/**
	 * Column Info
	 * @param tmlAwkUcCalcTpCd
	 */
	public void setTmlAwkUcCalcTpCd(String tmlAwkUcCalcTpCd) {
		this.tmlAwkUcCalcTpCd = tmlAwkUcCalcTpCd;
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
	 * @param condNo
	 */
	public void setCondNo(String condNo) {
		this.condNo = condNo;
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
		setLoclCurrCd(JSPUtil.getParameter(request, prefix + "locl_curr_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setIoGaCd(JSPUtil.getParameter(request, prefix + "io_ga_cd", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSpclCgoRefSeq(JSPUtil.getParameter(request, prefix + "spcl_cgo_ref_seq", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setUsdXchDt(JSPUtil.getParameter(request, prefix + "usd_xch_dt", ""));
		setUsdAmt(JSPUtil.getParameter(request, prefix + "usd_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setTmlAwkCgoTrfTpCd(JSPUtil.getParameter(request, prefix + "tml_awk_cgo_trf_tp_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setTmlAwkTrfVerNo(JSPUtil.getParameter(request, prefix + "tml_awk_trf_ver_no", ""));
		setTmlAwkUcCalcTpCd(JSPUtil.getParameter(request, prefix + "tml_awk_uc_calc_tp_cd", ""));
		setTmlAwkTsCd(JSPUtil.getParameter(request, prefix + "tml_awk_ts_cd", ""));
		setCondNo(JSPUtil.getParameter(request, prefix + "cond_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TesAwkCgoTrfTpSzVO[]
	 */
	public TesAwkCgoTrfTpSzVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TesAwkCgoTrfTpSzVO[]
	 */
	public TesAwkCgoTrfTpSzVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TesAwkCgoTrfTpSzVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] loclCurrAmt = (JSPUtil.getParameter(request, prefix	+ "locl_curr_amt", length));
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] ioGaCd = (JSPUtil.getParameter(request, prefix	+ "io_ga_cd", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] spclCgoRefSeq = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_ref_seq", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] usdXchDt = (JSPUtil.getParameter(request, prefix	+ "usd_xch_dt", length));
			String[] usdAmt = (JSPUtil.getParameter(request, prefix	+ "usd_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] tmlAwkCgoTrfTpCd = (JSPUtil.getParameter(request, prefix	+ "tml_awk_cgo_trf_tp_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] tmlAwkTrfVerNo = (JSPUtil.getParameter(request, prefix	+ "tml_awk_trf_ver_no", length));
			String[] tmlAwkUcCalcTpCd = (JSPUtil.getParameter(request, prefix	+ "tml_awk_uc_calc_tp_cd", length));
			String[] tmlAwkTsCd = (JSPUtil.getParameter(request, prefix	+ "tml_awk_ts_cd", length));
			String[] condNo = (JSPUtil.getParameter(request, prefix	+ "cond_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new TesAwkCgoTrfTpSzVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (loclCurrAmt[i] != null)
					model.setLoclCurrAmt(loclCurrAmt[i]);
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
				if (spclCgoRefSeq[i] != null)
					model.setSpclCgoRefSeq(spclCgoRefSeq[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (usdXchDt[i] != null)
					model.setUsdXchDt(usdXchDt[i]);
				if (usdAmt[i] != null)
					model.setUsdAmt(usdAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (tmlAwkCgoTrfTpCd[i] != null)
					model.setTmlAwkCgoTrfTpCd(tmlAwkCgoTrfTpCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (tmlAwkTrfVerNo[i] != null)
					model.setTmlAwkTrfVerNo(tmlAwkTrfVerNo[i]);
				if (tmlAwkUcCalcTpCd[i] != null)
					model.setTmlAwkUcCalcTpCd(tmlAwkUcCalcTpCd[i]);
				if (tmlAwkTsCd[i] != null)
					model.setTmlAwkTsCd(tmlAwkTsCd[i]);
				if (condNo[i] != null)
					model.setCondNo(condNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTesAwkCgoTrfTpSzVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TesAwkCgoTrfTpSzVO[]
	 */
	public TesAwkCgoTrfTpSzVO[] getTesAwkCgoTrfTpSzVOs(){
		TesAwkCgoTrfTpSzVO[] vos = (TesAwkCgoTrfTpSzVO[])models.toArray(new TesAwkCgoTrfTpSzVO[models.size()]);
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
		this.loclCurrCd = this.loclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioGaCd = this.ioGaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoRefSeq = this.spclCgoRefSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdXchDt = this.usdXchDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdAmt = this.usdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlAwkCgoTrfTpCd = this.tmlAwkCgoTrfTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlAwkTrfVerNo = this.tmlAwkTrfVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlAwkUcCalcTpCd = this.tmlAwkUcCalcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlAwkTsCd = this.tmlAwkTsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.condNo = this.condNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

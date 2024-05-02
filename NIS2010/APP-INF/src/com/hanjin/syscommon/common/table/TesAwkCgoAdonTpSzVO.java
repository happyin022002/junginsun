/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : TesAwkCgoAdonTpSzVO.java
*@FileTitle : TesAwkCgoAdonTpSzVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.11
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.03.11 이혜민 
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

public class TesAwkCgoAdonTpSzVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TesAwkCgoAdonTpSzVO> models = new ArrayList<TesAwkCgoAdonTpSzVO>();
	
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
	private String toLocCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fmNodYdNo = null;
	/* Column Info */
	private String spclCgoRefSeq = null;
	/* Column Info */
	private String usdXchDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String toNodYdNo = null;
	/* Column Info */
	private String tmlAwkAdonVerNo = null;
	/* Column Info */
	private String usdAmt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String fmLocCd = null;
	/* Column Info */
	private String condNo = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TesAwkCgoAdonTpSzVO() {}

	public TesAwkCgoAdonTpSzVO(String ibflag, String pagerows, String fmLocCd, String fmNodYdNo, String toLocCd, String toNodYdNo, String condNo, String tmlAwkAdonVerNo, String cntrSzCd, String spclCgoRefSeq, String usdAmt, String creUsrId, String creDt, String updUsrId, String updDt, String loclCurrCd, String loclCurrAmt, String usdXchDt) {
		this.updDt = updDt;
		this.loclCurrAmt = loclCurrAmt;
		this.cntrSzCd = cntrSzCd;
		this.loclCurrCd = loclCurrCd;
		this.creDt = creDt;
		this.toLocCd = toLocCd;
		this.pagerows = pagerows;
		this.fmNodYdNo = fmNodYdNo;
		this.spclCgoRefSeq = spclCgoRefSeq;
		this.usdXchDt = usdXchDt;
		this.ibflag = ibflag;
		this.toNodYdNo = toNodYdNo;
		this.tmlAwkAdonVerNo = tmlAwkAdonVerNo;
		this.usdAmt = usdAmt;
		this.creUsrId = creUsrId;
		this.fmLocCd = fmLocCd;
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
		this.hashColumns.put("cntr_sz_cd", getCntrSzCd());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("to_loc_cd", getToLocCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fm_nod_yd_no", getFmNodYdNo());
		this.hashColumns.put("spcl_cgo_ref_seq", getSpclCgoRefSeq());
		this.hashColumns.put("usd_xch_dt", getUsdXchDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("to_nod_yd_no", getToNodYdNo());
		this.hashColumns.put("tml_awk_adon_ver_no", getTmlAwkAdonVerNo());
		this.hashColumns.put("usd_amt", getUsdAmt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("fm_loc_cd", getFmLocCd());
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
		this.hashFields.put("cntr_sz_cd", "cntrSzCd");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("to_loc_cd", "toLocCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fm_nod_yd_no", "fmNodYdNo");
		this.hashFields.put("spcl_cgo_ref_seq", "spclCgoRefSeq");
		this.hashFields.put("usd_xch_dt", "usdXchDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("to_nod_yd_no", "toNodYdNo");
		this.hashFields.put("tml_awk_adon_ver_no", "tmlAwkAdonVerNo");
		this.hashFields.put("usd_amt", "usdAmt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("fm_loc_cd", "fmLocCd");
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
	 * @return toLocCd
	 */
	public String getToLocCd() {
		return this.toLocCd;
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
	 * @return fmNodYdNo
	 */
	public String getFmNodYdNo() {
		return this.fmNodYdNo;
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
	 * @return usdXchDt
	 */
	public String getUsdXchDt() {
		return this.usdXchDt;
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
	 * @return toNodYdNo
	 */
	public String getToNodYdNo() {
		return this.toNodYdNo;
	}
	
	/**
	 * Column Info
	 * @return tmlAwkAdonVerNo
	 */
	public String getTmlAwkAdonVerNo() {
		return this.tmlAwkAdonVerNo;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return fmLocCd
	 */
	public String getFmLocCd() {
		return this.fmLocCd;
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
	 * @param toLocCd
	 */
	public void setToLocCd(String toLocCd) {
		this.toLocCd = toLocCd;
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
	 * @param fmNodYdNo
	 */
	public void setFmNodYdNo(String fmNodYdNo) {
		this.fmNodYdNo = fmNodYdNo;
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
	 * @param usdXchDt
	 */
	public void setUsdXchDt(String usdXchDt) {
		this.usdXchDt = usdXchDt;
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
	 * @param toNodYdNo
	 */
	public void setToNodYdNo(String toNodYdNo) {
		this.toNodYdNo = toNodYdNo;
	}
	
	/**
	 * Column Info
	 * @param tmlAwkAdonVerNo
	 */
	public void setTmlAwkAdonVerNo(String tmlAwkAdonVerNo) {
		this.tmlAwkAdonVerNo = tmlAwkAdonVerNo;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param fmLocCd
	 */
	public void setFmLocCd(String fmLocCd) {
		this.fmLocCd = fmLocCd;
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
		setCntrSzCd(JSPUtil.getParameter(request, prefix + "cntr_sz_cd", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, prefix + "locl_curr_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setToLocCd(JSPUtil.getParameter(request, prefix + "to_loc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFmNodYdNo(JSPUtil.getParameter(request, prefix + "fm_nod_yd_no", ""));
		setSpclCgoRefSeq(JSPUtil.getParameter(request, prefix + "spcl_cgo_ref_seq", ""));
		setUsdXchDt(JSPUtil.getParameter(request, prefix + "usd_xch_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setToNodYdNo(JSPUtil.getParameter(request, prefix + "to_nod_yd_no", ""));
		setTmlAwkAdonVerNo(JSPUtil.getParameter(request, prefix + "tml_awk_adon_ver_no", ""));
		setUsdAmt(JSPUtil.getParameter(request, prefix + "usd_amt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setFmLocCd(JSPUtil.getParameter(request, prefix + "fm_loc_cd", ""));
		setCondNo(JSPUtil.getParameter(request, prefix + "cond_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TesAwkCgoAdonTpSzVO[]
	 */
	public TesAwkCgoAdonTpSzVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TesAwkCgoAdonTpSzVO[]
	 */
	public TesAwkCgoAdonTpSzVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TesAwkCgoAdonTpSzVO model = null;
		
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
			String[] toLocCd = (JSPUtil.getParameter(request, prefix	+ "to_loc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fmNodYdNo = (JSPUtil.getParameter(request, prefix	+ "fm_nod_yd_no", length));
			String[] spclCgoRefSeq = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_ref_seq", length));
			String[] usdXchDt = (JSPUtil.getParameter(request, prefix	+ "usd_xch_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] toNodYdNo = (JSPUtil.getParameter(request, prefix	+ "to_nod_yd_no", length));
			String[] tmlAwkAdonVerNo = (JSPUtil.getParameter(request, prefix	+ "tml_awk_adon_ver_no", length));
			String[] usdAmt = (JSPUtil.getParameter(request, prefix	+ "usd_amt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] fmLocCd = (JSPUtil.getParameter(request, prefix	+ "fm_loc_cd", length));
			String[] condNo = (JSPUtil.getParameter(request, prefix	+ "cond_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new TesAwkCgoAdonTpSzVO();
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
				if (toLocCd[i] != null)
					model.setToLocCd(toLocCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fmNodYdNo[i] != null)
					model.setFmNodYdNo(fmNodYdNo[i]);
				if (spclCgoRefSeq[i] != null)
					model.setSpclCgoRefSeq(spclCgoRefSeq[i]);
				if (usdXchDt[i] != null)
					model.setUsdXchDt(usdXchDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (toNodYdNo[i] != null)
					model.setToNodYdNo(toNodYdNo[i]);
				if (tmlAwkAdonVerNo[i] != null)
					model.setTmlAwkAdonVerNo(tmlAwkAdonVerNo[i]);
				if (usdAmt[i] != null)
					model.setUsdAmt(usdAmt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (fmLocCd[i] != null)
					model.setFmLocCd(fmLocCd[i]);
				if (condNo[i] != null)
					model.setCondNo(condNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTesAwkCgoAdonTpSzVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TesAwkCgoAdonTpSzVO[]
	 */
	public TesAwkCgoAdonTpSzVO[] getTesAwkCgoAdonTpSzVOs(){
		TesAwkCgoAdonTpSzVO[] vos = (TesAwkCgoAdonTpSzVO[])models.toArray(new TesAwkCgoAdonTpSzVO[models.size()]);
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
		this.toLocCd = this.toLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodYdNo = this.fmNodYdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoRefSeq = this.spclCgoRefSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdXchDt = this.usdXchDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toNodYdNo = this.toNodYdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlAwkAdonVerNo = this.tmlAwkAdonVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdAmt = this.usdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmLocCd = this.fmLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.condNo = this.condNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

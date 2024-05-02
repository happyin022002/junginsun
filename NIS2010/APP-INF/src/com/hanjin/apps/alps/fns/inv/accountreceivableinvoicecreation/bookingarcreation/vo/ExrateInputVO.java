/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExrateInputVO.java
*@FileTitle : ExrateInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.28
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.08.28 최도순 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo;

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
 * @author 최도순
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ExrateInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ExrateInputVO> models = new ArrayList<ExrateInputVO>();
	
	/* Column Info */
	private String xchRtDt = null;
	/* Column Info */
	private String fmIfDt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String exrate = null;
	/* Column Info */
	private String xchRtN3rdTpCd = null;
	/* Column Info */
	private String chgSeq = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String obrdDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String xchRtUsdTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String arIfNo = null;
	/* Column Info */
	private String toIfDt = null;
	/* Column Info */
	private String arIfSerNo = null;
	/* Column Info */
	private String invXchRt = null;
	/* Column Info */
	private String runOpt = null;
	/* Column Info */
	private String blSrcNo = null;
	/* Column Info */
	private String invCustCntCd = null;
	/* Column Info */
	private String invCustSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ExrateInputVO() {}

	public ExrateInputVO(String ibflag, String pagerows, String ofcCd, String fmIfDt, String toIfDt, String ioBndCd, String vvd, String runOpt, String arIfNo, String arIfSerNo, String chgSeq, String currCd, String invXchRt, String exrate, String xchRtUsdTpCd, String xchRtN3rdTpCd, String xchRtDt, String obrdDt, String blSrcNo, String invCustCntCd, String invCustSeq) {
		this.xchRtDt = xchRtDt;
		this.fmIfDt = fmIfDt;
		this.currCd = currCd;
		this.exrate = exrate;
		this.xchRtN3rdTpCd = xchRtN3rdTpCd;
		this.chgSeq = chgSeq;
		this.ioBndCd = ioBndCd;
		this.obrdDt = obrdDt;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.ofcCd = ofcCd;
		this.xchRtUsdTpCd = xchRtUsdTpCd;
		this.ibflag = ibflag;
		this.arIfNo = arIfNo;
		this.toIfDt = toIfDt;
		this.arIfSerNo = arIfSerNo;
		this.invXchRt = invXchRt;
		this.runOpt = runOpt;
		this.blSrcNo = blSrcNo;
		this.invCustCntCd = invCustCntCd;
		this.invCustSeq = invCustSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("xch_rt_dt", getXchRtDt());
		this.hashColumns.put("fm_if_dt", getFmIfDt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("exrate", getExrate());
		this.hashColumns.put("xch_rt_n3rd_tp_cd", getXchRtN3rdTpCd());
		this.hashColumns.put("chg_seq", getChgSeq());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("obrd_dt", getObrdDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("xch_rt_usd_tp_cd", getXchRtUsdTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ar_if_no", getArIfNo());
		this.hashColumns.put("to_if_dt", getToIfDt());
		this.hashColumns.put("ar_if_ser_no", getArIfSerNo());
		this.hashColumns.put("inv_xch_rt", getInvXchRt());
		this.hashColumns.put("run_opt", getRunOpt());
		this.hashColumns.put("inv_cust_cnt_cd", getInvCustCntCd());
		this.hashColumns.put("inv_cust_seq", getInvCustSeq());
		this.hashColumns.put("bl_src_no", getBlSrcNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("xch_rt_dt", "xchRtDt");
		this.hashFields.put("fm_if_dt", "fmIfDt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("exrate", "exrate");
		this.hashFields.put("xch_rt_n3rd_tp_cd", "xchRtN3rdTpCd");
		this.hashFields.put("chg_seq", "chgSeq");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("obrd_dt", "obrdDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("xch_rt_usd_tp_cd", "xchRtUsdTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ar_if_no", "arIfNo");
		this.hashFields.put("to_if_dt", "toIfDt");
		this.hashFields.put("ar_if_ser_no", "arIfSerNo");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("run_opt", "runOpt");
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("inv_cust_cnt_cd", "invCustCntCd");
		this.hashFields.put("inv_cust_seq", "invCustSeq");
		return this.hashFields;
	}
	
	
	/**
	 * @return the blSrcNo
	 */
	public String getBlSrcNo() {
		return blSrcNo;
	}

	/**
	 * @param blSrcNo the blSrcNo to set
	 */
	public void setBlSrcNo(String blSrcNo) {
		this.blSrcNo = blSrcNo;
	}

	/**
	 * @return the invCustCntCd
	 */
	public String getInvCustCntCd() {
		return invCustCntCd;
	}

	/**
	 * @param invCustCntCd the invCustCntCd to set
	 */
	public void setInvCustCntCd(String invCustCntCd) {
		this.invCustCntCd = invCustCntCd;
	}

	/**
	 * @return the invCustSeq
	 */
	public String getInvCustSeq() {
		return invCustSeq;
	}

	/**
	 * @param invCustSeq the invCustSeq to set
	 */
	public void setInvCustSeq(String invCustSeq) {
		this.invCustSeq = invCustSeq;
	}

	/**
	 * Column Info
	 * @return xchRtDt
	 */
	public String getXchRtDt() {
		return this.xchRtDt;
	}
	
	/**
	 * Column Info
	 * @return fmIfDt
	 */
	public String getFmIfDt() {
		return this.fmIfDt;
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
	 * @return exrate
	 */
	public String getExrate() {
		return this.exrate;
	}
	
	/**
	 * Column Info
	 * @return xchRtN3rdTpCd
	 */
	public String getXchRtN3rdTpCd() {
		return this.xchRtN3rdTpCd;
	}
	
	/**
	 * Column Info
	 * @return chgSeq
	 */
	public String getChgSeq() {
		return this.chgSeq;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return obrdDt
	 */
	public String getObrdDt() {
		return this.obrdDt;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return xchRtUsdTpCd
	 */
	public String getXchRtUsdTpCd() {
		return this.xchRtUsdTpCd;
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
	 * @return arIfNo
	 */
	public String getArIfNo() {
		return this.arIfNo;
	}
	
	/**
	 * Column Info
	 * @return toIfDt
	 */
	public String getToIfDt() {
		return this.toIfDt;
	}
	
	/**
	 * Column Info
	 * @return arIfSerNo
	 */
	public String getArIfSerNo() {
		return this.arIfSerNo;
	}
	
	/**
	 * Column Info
	 * @return invXchRt
	 */
	public String getInvXchRt() {
		return this.invXchRt;
	}
	
	/**
	 * Column Info
	 * @return runOpt
	 */
	public String getRunOpt() {
		return this.runOpt;
	}
	

	/**
	 * Column Info
	 * @param xchRtDt
	 */
	public void setXchRtDt(String xchRtDt) {
		this.xchRtDt = xchRtDt;
	}
	
	/**
	 * Column Info
	 * @param fmIfDt
	 */
	public void setFmIfDt(String fmIfDt) {
		this.fmIfDt = fmIfDt;
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
	 * @param exrate
	 */
	public void setExrate(String exrate) {
		this.exrate = exrate;
	}
	
	/**
	 * Column Info
	 * @param xchRtN3rdTpCd
	 */
	public void setXchRtN3rdTpCd(String xchRtN3rdTpCd) {
		this.xchRtN3rdTpCd = xchRtN3rdTpCd;
	}
	
	/**
	 * Column Info
	 * @param chgSeq
	 */
	public void setChgSeq(String chgSeq) {
		this.chgSeq = chgSeq;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param obrdDt
	 */
	public void setObrdDt(String obrdDt) {
		this.obrdDt = obrdDt;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param xchRtUsdTpCd
	 */
	public void setXchRtUsdTpCd(String xchRtUsdTpCd) {
		this.xchRtUsdTpCd = xchRtUsdTpCd;
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
	 * @param arIfNo
	 */
	public void setArIfNo(String arIfNo) {
		this.arIfNo = arIfNo;
	}
	
	/**
	 * Column Info
	 * @param toIfDt
	 */
	public void setToIfDt(String toIfDt) {
		this.toIfDt = toIfDt;
	}
	
	/**
	 * Column Info
	 * @param arIfSerNo
	 */
	public void setArIfSerNo(String arIfSerNo) {
		this.arIfSerNo = arIfSerNo;
	}
	
	/**
	 * Column Info
	 * @param invXchRt
	 */
	public void setInvXchRt(String invXchRt) {
		this.invXchRt = invXchRt;
	}
	
	/**
	 * Column Info
	 * @param runOpt
	 */
	public void setRunOpt(String runOpt) {
		this.runOpt = runOpt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setXchRtDt(JSPUtil.getParameter(request, "xch_rt_dt", ""));
		setFmIfDt(JSPUtil.getParameter(request, "fm_if_dt", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setExrate(JSPUtil.getParameter(request, "exrate", ""));
		setXchRtN3rdTpCd(JSPUtil.getParameter(request, "xch_rt_n3rd_tp_cd", ""));
		setChgSeq(JSPUtil.getParameter(request, "chg_seq", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setObrdDt(JSPUtil.getParameter(request, "obrd_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setXchRtUsdTpCd(JSPUtil.getParameter(request, "xch_rt_usd_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setArIfNo(JSPUtil.getParameter(request, "ar_if_no", ""));
		setToIfDt(JSPUtil.getParameter(request, "to_if_dt", ""));
		setArIfSerNo(JSPUtil.getParameter(request, "ar_if_ser_no", ""));
		setInvXchRt(JSPUtil.getParameter(request, "inv_xch_rt", ""));
		setRunOpt(JSPUtil.getParameter(request, "run_opt", ""));
		setBlSrcNo(JSPUtil.getParameter(request, "bl_src_no", ""));
		setInvCustCntCd(JSPUtil.getParameter(request, "inv_cust_cnt_cd", ""));
		setInvCustSeq(JSPUtil.getParameter(request, "inv_cust_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ExrateInputVO[]
	 */
	public ExrateInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ExrateInputVO[]
	 */
	public ExrateInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ExrateInputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] xchRtDt = (JSPUtil.getParameter(request, prefix	+ "xch_rt_dt", length));
			String[] fmIfDt = (JSPUtil.getParameter(request, prefix	+ "fm_if_dt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] exrate = (JSPUtil.getParameter(request, prefix	+ "exrate", length));
			String[] xchRtN3rdTpCd = (JSPUtil.getParameter(request, prefix	+ "xch_rt_n3rd_tp_cd", length));
			String[] chgSeq = (JSPUtil.getParameter(request, prefix	+ "chg_seq", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] obrdDt = (JSPUtil.getParameter(request, prefix	+ "obrd_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] xchRtUsdTpCd = (JSPUtil.getParameter(request, prefix	+ "xch_rt_usd_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] arIfNo = (JSPUtil.getParameter(request, prefix	+ "ar_if_no", length));
			String[] toIfDt = (JSPUtil.getParameter(request, prefix	+ "to_if_dt", length));
			String[] arIfSerNo = (JSPUtil.getParameter(request, prefix	+ "ar_if_ser_no", length));
			String[] invXchRt = (JSPUtil.getParameter(request, prefix	+ "inv_xch_rt", length));
			String[] runOpt = (JSPUtil.getParameter(request, prefix	+ "run_opt", length));
			String[] blSrcNo = (JSPUtil.getParameter(request, prefix	+ "bl_src_no", length));
			String[] invCustCntCd = (JSPUtil.getParameter(request, prefix	+ "inv_cust_cnt_cd", length));
			String[] invCustSeq = (JSPUtil.getParameter(request, prefix	+ "inv_cust_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new ExrateInputVO();
				if (xchRtDt[i] != null)
					model.setXchRtDt(xchRtDt[i]);
				if (fmIfDt[i] != null)
					model.setFmIfDt(fmIfDt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (exrate[i] != null)
					model.setExrate(exrate[i]);
				if (xchRtN3rdTpCd[i] != null)
					model.setXchRtN3rdTpCd(xchRtN3rdTpCd[i]);
				if (chgSeq[i] != null)
					model.setChgSeq(chgSeq[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (obrdDt[i] != null)
					model.setObrdDt(obrdDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (xchRtUsdTpCd[i] != null)
					model.setXchRtUsdTpCd(xchRtUsdTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (arIfNo[i] != null)
					model.setArIfNo(arIfNo[i]);
				if (toIfDt[i] != null)
					model.setToIfDt(toIfDt[i]);
				if (arIfSerNo[i] != null)
					model.setArIfSerNo(arIfSerNo[i]);
				if (invXchRt[i] != null)
					model.setInvXchRt(invXchRt[i]);
				if (runOpt[i] != null)
					model.setRunOpt(runOpt[i]);
				if (blSrcNo[i] != null)
					model.setBlSrcNo(blSrcNo[i]);
				if (invCustCntCd[i] != null)
					model.setInvCustCntCd(invCustCntCd[i]);
				if (invCustSeq[i] != null)
					model.setInvCustSeq(invCustSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getExrateInputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ExrateInputVO[]
	 */
	public ExrateInputVO[] getExrateInputVOs(){
		ExrateInputVO[] vos = (ExrateInputVO[])models.toArray(new ExrateInputVO[models.size()]);
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
		this.xchRtDt = this.xchRtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmIfDt = this.fmIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exrate = this.exrate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtN3rdTpCd = this.xchRtN3rdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSeq = this.chgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obrdDt = this.obrdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtUsdTpCd = this.xchRtUsdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfNo = this.arIfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toIfDt = this.toIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfSerNo = this.arIfSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt = this.invXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.runOpt = this.runOpt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrcNo = this.blSrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCustCntCd = this.invCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCustSeq = this.invCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

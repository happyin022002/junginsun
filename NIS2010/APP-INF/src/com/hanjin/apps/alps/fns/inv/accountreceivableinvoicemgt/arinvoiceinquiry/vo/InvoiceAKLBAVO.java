/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceAKLBAVO.java
*@FileTitle : InvoiceAKLBAVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.09.10 최도순 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo;

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

public class InvoiceAKLBAVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvoiceAKLBAVO> models = new ArrayList<InvoiceAKLBAVO>();
	
	/* Column Info */
	private String blInvIfDt = null;
	/* Column Info */
	private String blInvCfmDt = null;
	/* Column Info */
	private String blSrcNo = null;
	/* Column Info */
	private String arIfNo = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String shpr = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cnee = null;
	/* Column Info */
	private String notify = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String chgCd = null;
	/* Column Info */
	private String chgFullNm = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String trfRtAmt = null;
	/* Column Info */
	private String chgAmt = null;
	/* Column Info */
	private String invXchRt = null;
	/* Column Info */
	private String invTtlLoclAmt = null;
	/* Column Info */
	private String cntrNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;


	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InvoiceAKLBAVO() {}

	public InvoiceAKLBAVO(String ibflag, String pagerows, String blInvIfDt, String blInvCfmDt, String blSrcNo, String arIfNo, String vvd, String shpr, String cnee, String notify, String porCd, String polCd, String podCd, String delCd, String chgCd, String chgFullNm, String currCd, String trfRtAmt, String chgAmt, String invXchRt, String invTtlLoclAmt, String cntrNo) {
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.blInvIfDt = blInvIfDt;
		this.blInvCfmDt = blInvCfmDt;
		this.blSrcNo = blSrcNo;
		this.arIfNo = arIfNo;
		this.vvd = vvd;
		this.shpr = shpr;
		this.cnee = cnee;
		this.notify = notify;
		this.porCd = porCd;
		this.polCd = polCd;
		this.podCd = podCd;
		this.delCd = delCd;
		this.chgCd = chgCd;
		this.chgFullNm = chgFullNm;
		this.currCd = currCd;
		this.trfRtAmt = trfRtAmt;
		this.chgAmt = chgAmt;
		this.invXchRt = invXchRt;
		this.invTtlLoclAmt = invTtlLoclAmt;
		this.cntrNo = cntrNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bl_inv_if_dt", getBlInvIfDt());
		this.hashColumns.put("bl_inv_cfm_dt", getBlInvCfmDt());
		this.hashColumns.put("bl_src_no", getBlSrcNo());
		this.hashColumns.put("ar_if_no", getArIfNo());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("shpr", getShpr());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnee", getCnee());
		this.hashColumns.put("notify", getNotify());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("chg_full_nm", getChgFullNm());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("trf_rt_amt", getTrfRtAmt());
		this.hashColumns.put("chg_amt", getChgAmt());
		this.hashColumns.put("inv_xch_rt", getInvXchRt());
		this.hashColumns.put("inv_ttl_locl_amt", getInvTtlLoclAmt());
		this.hashColumns.put("cntr_no", getCntrNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bl_inv_if_dt", "blInvIfDt");
		this.hashFields.put("bl_inv_cfm_dt", "blInvCfmDt");
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("ar_if_no", "arIfNo");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("shpr", "shpr");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnee", "cnee");
		this.hashFields.put("notify", "notify");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("chg_full_nm", "chgFullNm");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("trf_rt_amt", "trfRtAmt");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("inv_ttl_locl_amt", "invTtlLoclAmt");
		this.hashFields.put("cntr_no", "cntrNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return blInvIfDt
	 */
	public String getBlInvIfDt() {
		return this.blInvIfDt;
	}
	
	/**
	 * Column Info
	 * @return blInvCfmDt
	 */
	public String getBlInvCfmDt() {
		return this.blInvCfmDt;
	}
	
	/**
	 * Column Info
	 * @return blSrcNo
	 */
	public String getBlSrcNo() {
		return this.blSrcNo;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return shpr
	 */
	public String getShpr() {
		return this.shpr;
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
	 * @return cnee
	 */
	public String getCnee() {
		return this.cnee;
	}
	
	/**
	 * Column Info
	 * @return notify
	 */
	public String getNotify() {
		return this.notify;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
	}
	
	/**
	 * Column Info
	 * @return chgFullNm
	 */
	public String getChgFullNm() {
		return this.chgFullNm;
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
	 * @return trfRtAmt
	 */
	public String getTrfRtAmt() {
		return this.trfRtAmt;
	}
	
	/**
	 * Column Info
	 * @return chgAmt
	 */
	public String getChgAmt() {
		return this.chgAmt;
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
	 * @return invTtlLoclAmt
	 */
	public String getInvTtlLoclAmt() {
		return this.invTtlLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
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
	 * @param blInvIfDt
	 */
	public void setBlInvIfDt(String blInvIfDt) {
		this.blInvIfDt = blInvIfDt;
	}
	
	/**
	 * Column Info
	 * @param blInvCfmDt
	 */
	public void setBlInvCfmDt(String blInvCfmDt) {
		this.blInvCfmDt = blInvCfmDt;
	}
	
	/**
	 * Column Info
	 * @param blSrcNo
	 */
	public void setBlSrcNo(String blSrcNo) {
		this.blSrcNo = blSrcNo;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param shpr
	 */
	public void setShpr(String shpr) {
		this.shpr = shpr;
	}
	
	/**
	 * Column Info
	 * @param cnee
	 */
	public void setCnee(String cnee) {
		this.cnee = cnee;
	}
	
	/**
	 * Column Info
	 * @param notify
	 */
	public void setNotify(String notify) {
		this.notify = notify;
	}
	
	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
	}
	
	/**
	 * Column Info
	 * @param chgFullNm
	 */
	public void setChgFullNm(String chgFullNm) {
		this.chgFullNm = chgFullNm;
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
	 * @param trfRtAmt
	 */
	public void setTrfRtAmt(String trfRtAmt) {
		this.trfRtAmt = trfRtAmt;
	}
	
	/**
	 * Column Info
	 * @param chgAmt
	 */
	public void setChgAmt(String chgAmt) {
		this.chgAmt = chgAmt;
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
	 * @param invTtlLoclAmt
	 */
	public void setInvTtlLoclAmt(String invTtlLoclAmt) {
		this.invTtlLoclAmt = invTtlLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setBlInvIfDt(JSPUtil.getParameter(request, "bl_inv_if_dt", ""));
		setBlInvCfmDt(JSPUtil.getParameter(request, "bl_inv_cfm_dt", ""));
		setBlSrcNo(JSPUtil.getParameter(request, "bl_src_no", ""));
		setArIfNo(JSPUtil.getParameter(request, "ar_if_no", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setShpr(JSPUtil.getParameter(request, "shpr", ""));
		setCnee(JSPUtil.getParameter(request, "cnee", ""));
		setNotify(JSPUtil.getParameter(request, "notify", ""));
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setChgCd(JSPUtil.getParameter(request, "chg_cd", ""));
		setChgFullNm(JSPUtil.getParameter(request, "chg_full_nm", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setTrfRtAmt(JSPUtil.getParameter(request, "trf_rt_amt", ""));
		setChgAmt(JSPUtil.getParameter(request, "chg_amt", ""));
		setInvXchRt(JSPUtil.getParameter(request, "inv_xch_rt", ""));
		setInvTtlLoclAmt(JSPUtil.getParameter(request, "inv_ttl_locl_amt", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setIbflag(JSPUtil.getParameter(request, "cgo_wgt", ""));

	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvoiceAKLBAVO[]
	 */
	public InvoiceAKLBAVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvoiceAKLBAVO[]
	 */
	public InvoiceAKLBAVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvoiceAKLBAVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] blInvIfDt = (JSPUtil.getParameter(request, prefix	+ "bl_inv_if_dt", length));
			String[] blInvCfmDt = (JSPUtil.getParameter(request, prefix	+ "bl_inv_cfm_dt", length));
			String[] blSrcNo = (JSPUtil.getParameter(request, prefix	+ "bl_src_no", length));
			String[] arIfNo = (JSPUtil.getParameter(request, prefix	+ "ar_if_no", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] shpr = (JSPUtil.getParameter(request, prefix	+ "shpr", length));
			String[] cnee = (JSPUtil.getParameter(request, prefix	+ "cnee", length));
			String[] notify = (JSPUtil.getParameter(request, prefix	+ "notify", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));		
			String[] chgFullNm = (JSPUtil.getParameter(request, prefix	+ "chg_full_nm", length));			
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] trfRtAmt = (JSPUtil.getParameter(request, prefix	+ "trf_rt_amt", length));
			String[] chgAmt = (JSPUtil.getParameter(request, prefix	+ "chg_amt", length));
			String[] invXchRt = (JSPUtil.getParameter(request, prefix	+ "inv_xch_rt", length));
			String[] invTtlLoclAmt = (JSPUtil.getParameter(request, prefix	+ "inv_ttl_locl_amt", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));

			
			for (int i = 0; i < length; i++) {
				model = new InvoiceAKLBAVO();
				if (blInvIfDt[i] != null)
					model.setBlInvIfDt(blInvIfDt[i]);
				if (blInvCfmDt[i] != null)
					model.setBlInvCfmDt(blInvCfmDt[i]);
				if (blSrcNo[i] != null)
					model.setBlSrcNo(blSrcNo[i]);
				if (arIfNo[i] != null)
					model.setArIfNo(arIfNo[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (shpr[i] != null)
					model.setShpr(shpr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cnee[i] != null)
					model.setCnee(cnee[i]);
				if (notify[i] != null)
					model.setNotify(notify[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (chgFullNm[i] != null)
					model.setChgFullNm(chgFullNm[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (trfRtAmt[i] != null)
					model.setTrfRtAmt(trfRtAmt[i]);
				if (chgAmt[i] != null)
					model.setChgAmt(chgAmt[i]);
				if (invXchRt[i] != null)
					model.setInvXchRt(invXchRt[i]);
				if (invTtlLoclAmt[i] != null)
					model.setInvTtlLoclAmt(invTtlLoclAmt[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvoiceAKLBAVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DirectBillingInvoiceVO[]
	 */
	public InvoiceAKLBAVO[] getInvoiceAKLBAVOs(){
		InvoiceAKLBAVO[] vos = (InvoiceAKLBAVO[])models.toArray(new InvoiceAKLBAVO[models.size()]);
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
		this.blInvIfDt = this.blInvIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blInvCfmDt = this.blInvCfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrcNo = this.blSrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfNo = this.arIfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr = this.shpr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee = this.cnee .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.notify = this.notify .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgFullNm = this.chgFullNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfRtAmt = this.trfRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt = this.chgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt = this.invXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTtlLoclAmt = this.invTtlLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

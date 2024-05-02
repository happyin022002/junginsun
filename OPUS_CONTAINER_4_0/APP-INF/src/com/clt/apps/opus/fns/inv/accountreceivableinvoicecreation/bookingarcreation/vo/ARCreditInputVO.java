/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ARCreditInputVO.java
*@FileTitle : ARCreditInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.26
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.10.26 최도순 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최도순
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ARCreditInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ARCreditInputVO> models = new ArrayList<ARCreditInputVO>();
	
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String destTrnsSvcModCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String actCustSeq = null;
	/* Column Info */
	private String actCustCntCd = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String sailArrDt = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String blSrcNo = null;
	/* Column Info */
	private String revSrcCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ARCreditInputVO() {}

	public ARCreditInputVO(String ibflag, String pagerows, String actCustCntCd, String actCustSeq, String sailArrDt, String arOfcCd, String ioBndCd, String destTrnsSvcModCd, String locCd, String delCd, String blSrcNo, String revSrcCd) {
		this.locCd = locCd;
		this.destTrnsSvcModCd = destTrnsSvcModCd;
		this.ibflag = ibflag;
		this.actCustSeq = actCustSeq;
		this.actCustCntCd = actCustCntCd;
		this.ioBndCd = ioBndCd;
		this.sailArrDt = sailArrDt;
		this.arOfcCd = arOfcCd;
		this.pagerows = pagerows;
		this.delCd = delCd;
		this.blSrcNo = blSrcNo;
		this.revSrcCd = revSrcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("dest_trns_svc_mod_cd", getDestTrnsSvcModCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("act_cust_seq", getActCustSeq());
		this.hashColumns.put("act_cust_cnt_cd", getActCustCntCd());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("sail_arr_dt", getSailArrDt());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("bl_src_no", getBlSrcNo());
		this.hashColumns.put("rev_src_cd", getRevSrcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("dest_trns_svc_mod_cd", "destTrnsSvcModCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("act_cust_seq", "actCustSeq");
		this.hashFields.put("act_cust_cnt_cd", "actCustCntCd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("rev_src_cd", "revSrcCd");
		return this.hashFields;
	}
	
	
	/**
	 * @return the revSrcCd
	 */
	public String getRevSrcCd() {
		return revSrcCd;
	}

	/**
	 * @param revSrcCd the revSrcCd to set
	 */
	public void setRevSrcCd(String revSrcCd) {
		this.revSrcCd = revSrcCd;
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
	 * @return the delCd
	 */
	public String getDelCd() {
		return delCd;
	}

	/**
	 * @param delCd the delCd to set
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}

	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return destTrnsSvcModCd
	 */
	public String getDestTrnsSvcModCd() {
		return this.destTrnsSvcModCd;
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
	 * @return actCustSeq
	 */
	public String getActCustSeq() {
		return this.actCustSeq;
	}
	
	/**
	 * Column Info
	 * @return actCustCntCd
	 */
	public String getActCustCntCd() {
		return this.actCustCntCd;
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
	 * @return sailArrDt
	 */
	public String getSailArrDt() {
		return this.sailArrDt;
	}
	
	/**
	 * Column Info
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param destTrnsSvcModCd
	 */
	public void setDestTrnsSvcModCd(String destTrnsSvcModCd) {
		this.destTrnsSvcModCd = destTrnsSvcModCd;
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
	 * @param actCustSeq
	 */
	public void setActCustSeq(String actCustSeq) {
		this.actCustSeq = actCustSeq;
	}
	
	/**
	 * Column Info
	 * @param actCustCntCd
	 */
	public void setActCustCntCd(String actCustCntCd) {
		this.actCustCntCd = actCustCntCd;
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
	 * @param sailArrDt
	 */
	public void setSailArrDt(String sailArrDt) {
		this.sailArrDt = sailArrDt;
	}
	
	/**
	 * Column Info
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setDestTrnsSvcModCd(JSPUtil.getParameter(request, "dest_trns_svc_mod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setActCustSeq(JSPUtil.getParameter(request, "act_cust_seq", ""));
		setActCustCntCd(JSPUtil.getParameter(request, "act_cust_cnt_cd", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setSailArrDt(JSPUtil.getParameter(request, "sail_arr_dt", ""));
		setArOfcCd(JSPUtil.getParameter(request, "ar_ofc_cd", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDelCd(JSPUtil.getParameter(request, "bl_src_no", ""));
		setRevSrcCd(JSPUtil.getParameter(request, "rev_src_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ARCreditInputVO[]
	 */
	public ARCreditInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ARCreditInputVO[]
	 */
	public ARCreditInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ARCreditInputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] destTrnsSvcModCd = (JSPUtil.getParameter(request, prefix	+ "dest_trns_svc_mod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] actCustSeq = (JSPUtil.getParameter(request, prefix	+ "act_cust_seq", length));
			String[] actCustCntCd = (JSPUtil.getParameter(request, prefix	+ "act_cust_cnt_cd", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] sailArrDt = (JSPUtil.getParameter(request, prefix	+ "sail_arr_dt", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] blSrcNo = (JSPUtil.getParameter(request, prefix	+ "bl_src_no", length));
			String[] revSrcCd = (JSPUtil.getParameter(request, prefix	+ "rev_src_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new ARCreditInputVO();
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (destTrnsSvcModCd[i] != null)
					model.setDestTrnsSvcModCd(destTrnsSvcModCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (actCustSeq[i] != null)
					model.setActCustSeq(actCustSeq[i]);
				if (actCustCntCd[i] != null)
					model.setActCustCntCd(actCustCntCd[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (sailArrDt[i] != null)
					model.setSailArrDt(sailArrDt[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (blSrcNo[i] != null)
					model.setBlSrcNo(blSrcNo[i]);
				if (revSrcCd[i] != null)
					model.setRevSrcCd(revSrcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getARCreditInputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ARCreditInputVO[]
	 */
	public ARCreditInputVO[] getARCreditInputVOs(){
		ARCreditInputVO[] vos = (ARCreditInputVO[])models.toArray(new ARCreditInputVO[models.size()]);
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
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destTrnsSvcModCd = this.destTrnsSvcModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustSeq = this.actCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustCntCd = this.actCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt = this.sailArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrcNo = this.blSrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revSrcCd = this.revSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ErpErrorVO.java
*@FileTitle : ErpErrorVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.14
*@LastModifier : Hyunhwa Kim
*@LastVersion : 1.0
* 2010.12.14 Hyunhwa Kim 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo;

import java.lang.reflect.Field;
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
 * @author Hyunhwa Kim
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ErpErrorVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ErpErrorVO> models = new ArrayList<ErpErrorVO>();
	
	/* Column Info */
	private String ifDt = null;
	/* Column Info */
	private String blSrcNo = null;
	/* Column Info */
	private String glDt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String arHdQtrOfcCd = null;
	/* Column Info */
	private String revTpSrc = null;
	/* Column Info */
	private String tjSrcNm = null;
	/* Column Info */
	private String invErpIfStsCd = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String revTp = null;
	/* Column Info */
	private String invNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String errDesc = null;
	/* Column Info */
	private String arIfNo = null;
	/* Column Info */
	private String goodDt = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String arIfSerNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ErpErrorVO() {}

	public ErpErrorVO(String ibflag, String pagerows, String arHdQtrOfcCd, String arOfcCd, String invErpIfStsCd, String arIfNo, String arIfSerNo, String blSrcNo, String invNo, String revTp, String revTpSrc, String tjSrcNm, String currCd, String invAmt, String ifDt, String goodDt, String glDt, String creDt, String errDesc) {
		this.ifDt = ifDt;
		this.blSrcNo = blSrcNo;
		this.glDt = glDt;
		this.currCd = currCd;
		this.creDt = creDt;
		this.arHdQtrOfcCd = arHdQtrOfcCd;
		this.revTpSrc = revTpSrc;
		this.tjSrcNm = tjSrcNm;
		this.invErpIfStsCd = invErpIfStsCd;
		this.arOfcCd = arOfcCd;
		this.pagerows = pagerows;
		this.revTp = revTp;
		this.invNo = invNo;
		this.ibflag = ibflag;
		this.errDesc = errDesc;
		this.arIfNo = arIfNo;
		this.goodDt = goodDt;
		this.invAmt = invAmt;
		this.arIfSerNo = arIfSerNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("if_dt", getIfDt());
		this.hashColumns.put("bl_src_no", getBlSrcNo());
		this.hashColumns.put("gl_dt", getGlDt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("ar_hd_qtr_ofc_cd", getArHdQtrOfcCd());
		this.hashColumns.put("rev_tp_src", getRevTpSrc());
		this.hashColumns.put("tj_src_nm", getTjSrcNm());
		this.hashColumns.put("inv_erp_if_sts_cd", getInvErpIfStsCd());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rev_tp", getRevTp());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("err_desc", getErrDesc());
		this.hashColumns.put("ar_if_no", getArIfNo());
		this.hashColumns.put("good_dt", getGoodDt());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("ar_if_ser_no", getArIfSerNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("if_dt", "ifDt");
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("gl_dt", "glDt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("ar_hd_qtr_ofc_cd", "arHdQtrOfcCd");
		this.hashFields.put("rev_tp_src", "revTpSrc");
		this.hashFields.put("tj_src_nm", "tjSrcNm");
		this.hashFields.put("inv_erp_if_sts_cd", "invErpIfStsCd");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rev_tp", "revTp");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("err_desc", "errDesc");
		this.hashFields.put("ar_if_no", "arIfNo");
		this.hashFields.put("good_dt", "goodDt");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("ar_if_ser_no", "arIfSerNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ifDt
	 */
	public String getIfDt() {
		return this.ifDt;
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
	 * @return glDt
	 */
	public String getGlDt() {
		return this.glDt;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return arHdQtrOfcCd
	 */
	public String getArHdQtrOfcCd() {
		return this.arHdQtrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return revTpSrc
	 */
	public String getRevTpSrc() {
		return this.revTpSrc;
	}
	
	/**
	 * Column Info
	 * @return tjSrcNm
	 */
	public String getTjSrcNm() {
		return this.tjSrcNm;
	}
	
	/**
	 * Column Info
	 * @return invErpIfStsCd
	 */
	public String getInvErpIfStsCd() {
		return this.invErpIfStsCd;
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
	 * @return revTp
	 */
	public String getRevTp() {
		return this.revTp;
	}
	
	/**
	 * Column Info
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
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
	 * @return errDesc
	 */
	public String getErrDesc() {
		return this.errDesc;
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
	 * @return goodDt
	 */
	public String getGoodDt() {
		return this.goodDt;
	}
	
	/**
	 * Column Info
	 * @return invAmt
	 */
	public String getInvAmt() {
		return this.invAmt;
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
	 * @param ifDt
	 */
	public void setIfDt(String ifDt) {
		this.ifDt = ifDt;
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
	 * @param glDt
	 */
	public void setGlDt(String glDt) {
		this.glDt = glDt;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param arHdQtrOfcCd
	 */
	public void setArHdQtrOfcCd(String arHdQtrOfcCd) {
		this.arHdQtrOfcCd = arHdQtrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param revTpSrc
	 */
	public void setRevTpSrc(String revTpSrc) {
		this.revTpSrc = revTpSrc;
	}
	
	/**
	 * Column Info
	 * @param tjSrcNm
	 */
	public void setTjSrcNm(String tjSrcNm) {
		this.tjSrcNm = tjSrcNm;
	}
	
	/**
	 * Column Info
	 * @param invErpIfStsCd
	 */
	public void setInvErpIfStsCd(String invErpIfStsCd) {
		this.invErpIfStsCd = invErpIfStsCd;
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
	 * Column Info
	 * @param revTp
	 */
	public void setRevTp(String revTp) {
		this.revTp = revTp;
	}
	
	/**
	 * Column Info
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
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
	 * @param errDesc
	 */
	public void setErrDesc(String errDesc) {
		this.errDesc = errDesc;
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
	 * @param goodDt
	 */
	public void setGoodDt(String goodDt) {
		this.goodDt = goodDt;
	}
	
	/**
	 * Column Info
	 * @param invAmt
	 */
	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
	}
	
	/**
	 * Column Info
	 * @param arIfSerNo
	 */
	public void setArIfSerNo(String arIfSerNo) {
		this.arIfSerNo = arIfSerNo;
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
		setIfDt(JSPUtil.getParameter(request, prefix + "if_dt", ""));
		setBlSrcNo(JSPUtil.getParameter(request, prefix + "bl_src_no", ""));
		setGlDt(JSPUtil.getParameter(request, prefix + "gl_dt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setArHdQtrOfcCd(JSPUtil.getParameter(request, prefix + "ar_hd_qtr_ofc_cd", ""));
		setRevTpSrc(JSPUtil.getParameter(request, prefix + "rev_tp_src", ""));
		setTjSrcNm(JSPUtil.getParameter(request, prefix + "tj_src_nm", ""));
		setInvErpIfStsCd(JSPUtil.getParameter(request, prefix + "inv_erp_if_sts_cd", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRevTp(JSPUtil.getParameter(request, prefix + "rev_tp", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setErrDesc(JSPUtil.getParameter(request, prefix + "err_desc", ""));
		setArIfNo(JSPUtil.getParameter(request, prefix + "ar_if_no", ""));
		setGoodDt(JSPUtil.getParameter(request, prefix + "good_dt", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setArIfSerNo(JSPUtil.getParameter(request, prefix + "ar_if_ser_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ErpErrorVO[]
	 */
	public ErpErrorVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ErpErrorVO[]
	 */
	public ErpErrorVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ErpErrorVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ifDt = (JSPUtil.getParameter(request, prefix	+ "if_dt", length));
			String[] blSrcNo = (JSPUtil.getParameter(request, prefix	+ "bl_src_no", length));
			String[] glDt = (JSPUtil.getParameter(request, prefix	+ "gl_dt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] arHdQtrOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_hd_qtr_ofc_cd", length));
			String[] revTpSrc = (JSPUtil.getParameter(request, prefix	+ "rev_tp_src", length));
			String[] tjSrcNm = (JSPUtil.getParameter(request, prefix	+ "tj_src_nm", length));
			String[] invErpIfStsCd = (JSPUtil.getParameter(request, prefix	+ "inv_erp_if_sts_cd", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] revTp = (JSPUtil.getParameter(request, prefix	+ "rev_tp", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] errDesc = (JSPUtil.getParameter(request, prefix	+ "err_desc", length));
			String[] arIfNo = (JSPUtil.getParameter(request, prefix	+ "ar_if_no", length));
			String[] goodDt = (JSPUtil.getParameter(request, prefix	+ "good_dt", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] arIfSerNo = (JSPUtil.getParameter(request, prefix	+ "ar_if_ser_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new ErpErrorVO();
				if (ifDt[i] != null)
					model.setIfDt(ifDt[i]);
				if (blSrcNo[i] != null)
					model.setBlSrcNo(blSrcNo[i]);
				if (glDt[i] != null)
					model.setGlDt(glDt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (arHdQtrOfcCd[i] != null)
					model.setArHdQtrOfcCd(arHdQtrOfcCd[i]);
				if (revTpSrc[i] != null)
					model.setRevTpSrc(revTpSrc[i]);
				if (tjSrcNm[i] != null)
					model.setTjSrcNm(tjSrcNm[i]);
				if (invErpIfStsCd[i] != null)
					model.setInvErpIfStsCd(invErpIfStsCd[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (revTp[i] != null)
					model.setRevTp(revTp[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (errDesc[i] != null)
					model.setErrDesc(errDesc[i]);
				if (arIfNo[i] != null)
					model.setArIfNo(arIfNo[i]);
				if (goodDt[i] != null)
					model.setGoodDt(goodDt[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (arIfSerNo[i] != null)
					model.setArIfSerNo(arIfSerNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getErpErrorVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ErpErrorVO[]
	 */
	public ErpErrorVO[] getErpErrorVOs(){
		ErpErrorVO[] vos = (ErpErrorVO[])models.toArray(new ErpErrorVO[models.size()]);
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
		this.ifDt = this.ifDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrcNo = this.blSrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glDt = this.glDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arHdQtrOfcCd = this.arHdQtrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revTpSrc = this.revTpSrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tjSrcNm = this.tjSrcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invErpIfStsCd = this.invErpIfStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revTp = this.revTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errDesc = this.errDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfNo = this.arIfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.goodDt = this.goodDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfSerNo = this.arIfSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

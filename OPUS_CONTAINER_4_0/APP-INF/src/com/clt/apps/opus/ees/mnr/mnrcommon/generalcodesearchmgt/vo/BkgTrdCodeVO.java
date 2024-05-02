/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BkgTrdCodeVO.java
*@FileTitle : BkgTrdCodeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.21
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.21  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo;

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

public class BkgTrdCodeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgTrdCodeVO> models = new ArrayList<BkgTrdCodeVO>();
	
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String shpMvmtCd = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rprRsltDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String costCd = null;
	/* Column Info */
	private String eqType = null;
	/* Column Info */
	private String pl = null;
	/* Column Info */
	private String fm = null;
	/* Column Info */
	private String costDtlCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BkgTrdCodeVO() {}

	public BkgTrdCodeVO(String ibflag, String pagerows, String bkgNo, String trdCd, String rprRsltDt, String eqNo, String shpMvmtCd, String costCd, String eqType, String pl, String fm, String costDtlCd) {
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.shpMvmtCd = shpMvmtCd;
		this.trdCd = trdCd;
		this.rprRsltDt = rprRsltDt;
		this.pagerows = pagerows;
		this.costCd = costCd;
		this.eqType = eqType;
		this.pl = pl;
		this.fm = fm;
		this.costDtlCd = costDtlCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("shp_mvmt_cd", getShpMvmtCd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rpr_rslt_dt", getRprRsltDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cost_cd", getCostCd());
		this.hashColumns.put("eq_type", getEqType());
		this.hashColumns.put("pl", getPl());
		this.hashColumns.put("fm", getFm());
		this.hashColumns.put("cost_dtl_cd", getCostDtlCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("shp_mvmt_cd", "shpMvmtCd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rpr_rslt_dt", "rprRsltDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cost_cd", "costCd");
		this.hashFields.put("eq_type", "eqType");
		this.hashFields.put("pl", "pl");
		this.hashFields.put("pl", "pl");
		this.hashFields.put("cost_dtl_cd", "costDtlCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return shpMvmtCd
	 */
	public String getShpMvmtCd() {
		return this.shpMvmtCd;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return rprRsltDt
	 */
	public String getRprRsltDt() {
		return this.rprRsltDt;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Page Number
	 * @return costCd
	 */
	public String getCostCd() {
		return this.costCd;
	}
	
	/**
	 * Page Number
	 * @return eqType
	 */
	public String getEqType() {
		return this.eqType;
	}
	
	/**
	 * Page Number
	 * @return pl
	 */
	public String getPl() {
		return this.pl;
	}
	
	/**
	 * Page Number
	 * @return fm
	 */
	public String getFm() {
		return this.fm;
	}
	
	/**
	 * Page Number
	 * @return costDtlCd
	 */
	public String getCostDtlCd() {
		return this.costDtlCd;
	}
	
	/**
	 * Column Info
	 * @param costDtlCd
	 */
	public void setCostDtlCd(String costDtlCd) {
		this.costDtlCd = costDtlCd;
	}

	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param shpMvmtCd
	 */
	public void setShpMvmtCd(String shpMvmtCd) {
		this.shpMvmtCd = shpMvmtCd;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param rprRsltDt
	 */
	public void setRprRsltDt(String rprRsltDt) {
		this.rprRsltDt = rprRsltDt;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Page Number
	 * @param costCd
	 */
	public void setCostCd(String costCd) {
		this.costCd = costCd;
	}
	
	/**
	 * Page Number
	 * @param eqType
	 */
	public void setEqType(String eqType) {
		this.eqType = eqType;
	}
	
	/**
	 * Page Number
	 * @param pl
	 */
	public void setPl(String pl) {
		this.pl = pl;
	}
	
	/**
	 * Page Number
	 * @param fm
	 */
	public void setFm(String fm) {
		this.fm = fm;
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
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setShpMvmtCd(JSPUtil.getParameter(request, prefix + "shp_mvmt_cd", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRprRsltDt(JSPUtil.getParameter(request, prefix + "rpr_rslt_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCostCd(JSPUtil.getParameter(request, prefix + "cost_cd", ""));
		setEqType(JSPUtil.getParameter(request, prefix + "eq_type", ""));
		setPl(JSPUtil.getParameter(request, prefix + "pl", ""));
		setFm(JSPUtil.getParameter(request, prefix + "fm", ""));
		setCostDtlCd(JSPUtil.getParameter(request, prefix + "cost_dtl_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgTrdCodeVO[]
	 */
	public BkgTrdCodeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgTrdCodeVO[]
	 */
	public BkgTrdCodeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgTrdCodeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] shpMvmtCd = (JSPUtil.getParameter(request, prefix	+ "shp_mvmt_cd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rprRsltDt = (JSPUtil.getParameter(request, prefix	+ "rpr_rslt_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] costCd = (JSPUtil.getParameter(request, prefix	+ "cost_cd", length));
			String[] eqType = (JSPUtil.getParameter(request, prefix	+ "eq_type", length));
			String[] pl = (JSPUtil.getParameter(request, prefix	+ "pl", length));
			String[] fm = (JSPUtil.getParameter(request, prefix	+ "fm", length));
			String[] costDtlCd = (JSPUtil.getParameter(request, prefix	+ "cost_dtl_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgTrdCodeVO();
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (shpMvmtCd[i] != null)
					model.setShpMvmtCd(shpMvmtCd[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rprRsltDt[i] != null)
					model.setRprRsltDt(rprRsltDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (costCd[i] != null)
					model.setCostCd(costCd[i]);
				if (eqType[i] != null)
					model.setEqType(eqType[i]);
				if (pl[i] != null)
					model.setPl(pl[i]);
				if (fm[i] != null)
					model.setFm(fm[i]);
				if (costDtlCd[i] != null)
					model.setCostDtlCd(costDtlCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgTrdCodeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgTrdCodeVO[]
	 */
	public BkgTrdCodeVO[] getBkgTrdCodeVOs(){
		BkgTrdCodeVO[] vos = (BkgTrdCodeVO[])models.toArray(new BkgTrdCodeVO[models.size()]);
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
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpMvmtCd = this.shpMvmtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprRsltDt = this.rprRsltDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCd = this.costCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqType = this.eqType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pl = this.pl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fm = this.fm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costDtlCd = this.costDtlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

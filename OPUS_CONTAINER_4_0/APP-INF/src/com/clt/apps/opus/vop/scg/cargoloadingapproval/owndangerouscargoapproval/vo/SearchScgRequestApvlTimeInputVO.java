/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchScgRequestApvlTimeInputVO.java
*@FileTitle : SearchScgRequestApvlTimeInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.28
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2010.04.28 김현욱 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo;

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
 * @author 김현욱
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchScgRequestApvlTimeInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchScgRequestApvlTimeInputVO> models = new ArrayList<SearchScgRequestApvlTimeInputVO>();
	
	/* Column Info */
	private String optionPostVvd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String rgnShpOprCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String scgFlg = null;
	/* Column Info */
	private String toRqstDt = null;
	/* Column Info */
	private String crrCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String optionPending = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String term = null;
	/* Column Info */
	private String fromRqstDt = null;
	/* Column Info */
	private String procHour = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchScgRequestApvlTimeInputVO() {}

	public SearchScgRequestApvlTimeInputVO(String ibflag, String pagerows, String term, String fromRqstDt, String toRqstDt, String rgnShpOprCd, String crrCd, String slanCd, String vslCd, String skdVoyNo, String skdDirCd, String scgFlg, String optionPending, String procHour, String optionPostVvd) {
		this.optionPostVvd = optionPostVvd;
		this.vslCd = vslCd;
		this.rgnShpOprCd = rgnShpOprCd;
		this.skdVoyNo = skdVoyNo;
		this.scgFlg = scgFlg;
		this.toRqstDt = toRqstDt;
		this.crrCd = crrCd;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.optionPending = optionPending;
		this.slanCd = slanCd;
		this.term = term;
		this.fromRqstDt = fromRqstDt;
		this.procHour = procHour;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("option_post_vvd", getOptionPostVvd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("rgn_shp_opr_cd", getRgnShpOprCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("scg_flg", getScgFlg());
		this.hashColumns.put("to_rqst_dt", getToRqstDt());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("option_pending", getOptionPending());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("term", getTerm());
		this.hashColumns.put("from_rqst_dt", getFromRqstDt());
		this.hashColumns.put("proc_hour", getProcHour());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("option_post_vvd", "optionPostVvd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("rgn_shp_opr_cd", "rgnShpOprCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("scg_flg", "scgFlg");
		this.hashFields.put("to_rqst_dt", "toRqstDt");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("option_pending", "optionPending");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("term", "term");
		this.hashFields.put("from_rqst_dt", "fromRqstDt");
		this.hashFields.put("proc_hour", "procHour");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return optionPostVvd
	 */
	public String getOptionPostVvd() {
		return this.optionPostVvd;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return rgnShpOprCd
	 */
	public String getRgnShpOprCd() {
		return this.rgnShpOprCd;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return scgFlg
	 */
	public String getScgFlg() {
		return this.scgFlg;
	}
	
	/**
	 * Column Info
	 * @return toRqstDt
	 */
	public String getToRqstDt() {
		return this.toRqstDt;
	}
	
	/**
	 * Column Info
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return optionPending
	 */
	public String getOptionPending() {
		return this.optionPending;
	}
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return term
	 */
	public String getTerm() {
		return this.term;
	}
	
	/**
	 * Column Info
	 * @return fromRqstDt
	 */
	public String getFromRqstDt() {
		return this.fromRqstDt;
	}
	
	/**
	 * Column Info
	 * @return procHour
	 */
	public String getProcHour() {
		return this.procHour;
	}
	

	/**
	 * Column Info
	 * @param optionPostVvd
	 */
	public void setOptionPostVvd(String optionPostVvd) {
		this.optionPostVvd = optionPostVvd;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param rgnShpOprCd
	 */
	public void setRgnShpOprCd(String rgnShpOprCd) {
		this.rgnShpOprCd = rgnShpOprCd;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param scgFlg
	 */
	public void setScgFlg(String scgFlg) {
		this.scgFlg = scgFlg;
	}
	
	/**
	 * Column Info
	 * @param toRqstDt
	 */
	public void setToRqstDt(String toRqstDt) {
		this.toRqstDt = toRqstDt;
	}
	
	/**
	 * Column Info
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param optionPending
	 */
	public void setOptionPending(String optionPending) {
		this.optionPending = optionPending;
	}
	
	/**
	 * Column Info
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param term
	 */
	public void setTerm(String term) {
		this.term = term;
	}
	
	/**
	 * Column Info
	 * @param fromRqstDt
	 */
	public void setFromRqstDt(String fromRqstDt) {
		this.fromRqstDt = fromRqstDt;
	}
	
	/**
	 * Column Info
	 * @param procHour
	 */
	public void setProcHour(String procHour) {
		this.procHour = procHour;
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
		setOptionPostVvd(JSPUtil.getParameter(request, prefix + "option_post_vvd", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setRgnShpOprCd(JSPUtil.getParameter(request, prefix + "rgn_shp_opr_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setScgFlg(JSPUtil.getParameter(request, prefix + "scg_flg", ""));
		setToRqstDt(JSPUtil.getParameter(request, prefix + "to_rqst_dt", ""));
		setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOptionPending(JSPUtil.getParameter(request, prefix + "option_pending", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setTerm(JSPUtil.getParameter(request, prefix + "term", ""));
		setFromRqstDt(JSPUtil.getParameter(request, prefix + "from_rqst_dt", ""));
		setProcHour(JSPUtil.getParameter(request, prefix + "proc_hour", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchScgRequestApvlTimeInputVO[]
	 */
	public SearchScgRequestApvlTimeInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchScgRequestApvlTimeInputVO[]
	 */
	public SearchScgRequestApvlTimeInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchScgRequestApvlTimeInputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] optionPostVvd = (JSPUtil.getParameter(request, prefix	+ "option_post_vvd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] rgnShpOprCd = (JSPUtil.getParameter(request, prefix	+ "rgn_shp_opr_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] scgFlg = (JSPUtil.getParameter(request, prefix	+ "scg_flg", length));
			String[] toRqstDt = (JSPUtil.getParameter(request, prefix	+ "to_rqst_dt", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] optionPending = (JSPUtil.getParameter(request, prefix	+ "option_pending", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] term = (JSPUtil.getParameter(request, prefix	+ "term", length));
			String[] fromRqstDt = (JSPUtil.getParameter(request, prefix	+ "from_rqst_dt", length));
			String[] procHour = (JSPUtil.getParameter(request, prefix	+ "proc_hour", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchScgRequestApvlTimeInputVO();
				if (optionPostVvd[i] != null)
					model.setOptionPostVvd(optionPostVvd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (rgnShpOprCd[i] != null)
					model.setRgnShpOprCd(rgnShpOprCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (scgFlg[i] != null)
					model.setScgFlg(scgFlg[i]);
				if (toRqstDt[i] != null)
					model.setToRqstDt(toRqstDt[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (optionPending[i] != null)
					model.setOptionPending(optionPending[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (term[i] != null)
					model.setTerm(term[i]);
				if (fromRqstDt[i] != null)
					model.setFromRqstDt(fromRqstDt[i]);
				if (procHour[i] != null)
					model.setProcHour(procHour[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchScgRequestApvlTimeInputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchScgRequestApvlTimeInputVO[]
	 */
	public SearchScgRequestApvlTimeInputVO[] getSearchScgRequestApvlTimeInputVOs(){
		SearchScgRequestApvlTimeInputVO[] vos = (SearchScgRequestApvlTimeInputVO[])models.toArray(new SearchScgRequestApvlTimeInputVO[models.size()]);
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
		this.optionPostVvd = this.optionPostVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnShpOprCd = this.rgnShpOprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgFlg = this.scgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toRqstDt = this.toRqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optionPending = this.optionPending .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.term = this.term .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromRqstDt = this.fromRqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.procHour = this.procHour .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

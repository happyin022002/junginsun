/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchExptTgtVO.java
*@FileTitle : SearchExptTgtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.22
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.01.22 김인수 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.common.util.vo;

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
 * @author 김인수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchExptTgtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchExptTgtVO> models = new ArrayList<SearchExptTgtVO>();
	
	/* Column Info */
	private String rdEtaFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String actDt = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String nodCd = null;
	/* Column Info */
	private String copDtlSeq = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchExptTgtVO() {}

	public SearchExptTgtVO(String ibflag, String pagerows, String copNo, String copDtlSeq, String actDt, String rdEtaFlg, String nodCd) {
		this.rdEtaFlg = rdEtaFlg;
		this.ibflag = ibflag;
		this.actDt = actDt;
		this.copNo = copNo;
		this.nodCd = nodCd;
		this.copDtlSeq = copDtlSeq;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rd_eta_flg", getRdEtaFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("act_dt", getActDt());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("nod_cd", getNodCd());
		this.hashColumns.put("cop_dtl_seq", getCopDtlSeq());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rd_eta_flg", "rdEtaFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("act_dt", "actDt");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("nod_cd", "nodCd");
		this.hashFields.put("cop_dtl_seq", "copDtlSeq");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rdEtaFlg
	 */
	public String getRdEtaFlg() {
		return this.rdEtaFlg;
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
	 * @return actDt
	 */
	public String getActDt() {
		return this.actDt;
	}
	
	/**
	 * Column Info
	 * @return copNo
	 */
	public String getCopNo() {
		return this.copNo;
	}
	
	/**
	 * Column Info
	 * @return nodCd
	 */
	public String getNodCd() {
		return this.nodCd;
	}
	
	/**
	 * Column Info
	 * @return copDtlSeq
	 */
	public String getCopDtlSeq() {
		return this.copDtlSeq;
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
	 * @param rdEtaFlg
	 */
	public void setRdEtaFlg(String rdEtaFlg) {
		this.rdEtaFlg = rdEtaFlg;
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
	 * @param actDt
	 */
	public void setActDt(String actDt) {
		this.actDt = actDt;
	}
	
	/**
	 * Column Info
	 * @param copNo
	 */
	public void setCopNo(String copNo) {
		this.copNo = copNo;
	}
	
	/**
	 * Column Info
	 * @param nodCd
	 */
	public void setNodCd(String nodCd) {
		this.nodCd = nodCd;
	}
	
	/**
	 * Column Info
	 * @param copDtlSeq
	 */
	public void setCopDtlSeq(String copDtlSeq) {
		this.copDtlSeq = copDtlSeq;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setRdEtaFlg(JSPUtil.getParameter(request, prefix + "rd_eta_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setActDt(JSPUtil.getParameter(request, prefix + "act_dt", ""));
		setCopNo(JSPUtil.getParameter(request, prefix + "cop_no", ""));
		setNodCd(JSPUtil.getParameter(request, prefix + "nod_cd", ""));
		setCopDtlSeq(JSPUtil.getParameter(request, prefix + "cop_dtl_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchExptTgtVO[]
	 */
	public SearchExptTgtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchExptTgtVO[]
	 */
	public SearchExptTgtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchExptTgtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rdEtaFlg = (JSPUtil.getParameter(request, prefix	+ "rd_eta_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] actDt = (JSPUtil.getParameter(request, prefix	+ "act_dt", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix	+ "cop_no", length));
			String[] nodCd = (JSPUtil.getParameter(request, prefix	+ "nod_cd", length));
			String[] copDtlSeq = (JSPUtil.getParameter(request, prefix	+ "cop_dtl_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchExptTgtVO();
				if (rdEtaFlg[i] != null)
					model.setRdEtaFlg(rdEtaFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (actDt[i] != null)
					model.setActDt(actDt[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (nodCd[i] != null)
					model.setNodCd(nodCd[i]);
				if (copDtlSeq[i] != null)
					model.setCopDtlSeq(copDtlSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchExptTgtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchExptTgtVO[]
	 */
	public SearchExptTgtVO[] getSearchExptTgtVOs(){
		SearchExptTgtVO[] vos = (SearchExptTgtVO[])models.toArray(new SearchExptTgtVO[models.size()]);
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
		this.rdEtaFlg = this.rdEtaFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDt = this.actDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodCd = this.nodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copDtlSeq = this.copDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchActualInfoVO.java
*@FileTitle : SearchActualInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.16
*@LastModifier : 오현경
*@LastVersion : 1.0
* 2009.09.16 오현경 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.copmanage.copsearch.vo;

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
 * @author 오현경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchActualInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchActualInfoVO> models = new ArrayList<SearchActualInfoVO>();
	
	/* Column Info */
	private String copyn = null;
	/* Column Info */
	private String actDt2 = null;
	/* Column Info */
	private String sortDt = null;
	/* Column Info */
	private String ediMsgTpCd = null;
	/* Column Info */
	private String copDtlSeq = null;
	/* Column Info */
	private String plnDt1 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String stsCd = null;
	/* Column Info */
	private String plnDt2 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String estmDt2 = null;
	/* Column Info */
	private String actNm = null;
	/* Column Info */
	private String estmDt1 = null;
	/* Column Info */
	private String nodCd = null;
	/* Column Info */
	private String actDt1 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchActualInfoVO() {}

	public SearchActualInfoVO(String ibflag, String pagerows, String actNm, String stsCd, String nodCd, String plnDt1, String plnDt2, String estmDt1, String estmDt2, String actDt1, String actDt2, String ediMsgTpCd, String copyn, String copDtlSeq, String sortDt) {
		this.copyn = copyn;
		this.actDt2 = actDt2;
		this.sortDt = sortDt;
		this.ediMsgTpCd = ediMsgTpCd;
		this.copDtlSeq = copDtlSeq;
		this.plnDt1 = plnDt1;
		this.pagerows = pagerows;
		this.stsCd = stsCd;
		this.plnDt2 = plnDt2;
		this.ibflag = ibflag;
		this.estmDt2 = estmDt2;
		this.actNm = actNm;
		this.estmDt1 = estmDt1;
		this.nodCd = nodCd;
		this.actDt1 = actDt1;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("copyn", getCopyn());
		this.hashColumns.put("act_dt2", getActDt2());
		this.hashColumns.put("sort_dt", getSortDt());
		this.hashColumns.put("edi_msg_tp_cd", getEdiMsgTpCd());
		this.hashColumns.put("cop_dtl_seq", getCopDtlSeq());
		this.hashColumns.put("pln_dt1", getPlnDt1());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sts_cd", getStsCd());
		this.hashColumns.put("pln_dt2", getPlnDt2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("estm_dt2", getEstmDt2());
		this.hashColumns.put("act_nm", getActNm());
		this.hashColumns.put("estm_dt1", getEstmDt1());
		this.hashColumns.put("nod_cd", getNodCd());
		this.hashColumns.put("act_dt1", getActDt1());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("copyn", "copyn");
		this.hashFields.put("act_dt2", "actDt2");
		this.hashFields.put("sort_dt", "sortDt");
		this.hashFields.put("edi_msg_tp_cd", "ediMsgTpCd");
		this.hashFields.put("cop_dtl_seq", "copDtlSeq");
		this.hashFields.put("pln_dt1", "plnDt1");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sts_cd", "stsCd");
		this.hashFields.put("pln_dt2", "plnDt2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("estm_dt2", "estmDt2");
		this.hashFields.put("act_nm", "actNm");
		this.hashFields.put("estm_dt1", "estmDt1");
		this.hashFields.put("nod_cd", "nodCd");
		this.hashFields.put("act_dt1", "actDt1");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return copyn
	 */
	public String getCopyn() {
		return this.copyn;
	}
	
	/**
	 * Column Info
	 * @return actDt2
	 */
	public String getActDt2() {
		return this.actDt2;
	}
	
	/**
	 * Column Info
	 * @return sortDt
	 */
	public String getSortDt() {
		return this.sortDt;
	}
	
	/**
	 * Column Info
	 * @return ediMsgTpCd
	 */
	public String getEdiMsgTpCd() {
		return this.ediMsgTpCd;
	}
	
	/**
	 * Column Info
	 * @return copDtlSeq
	 */
	public String getCopDtlSeq() {
		return this.copDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return plnDt1
	 */
	public String getPlnDt1() {
		return this.plnDt1;
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
	 * @return stsCd
	 */
	public String getStsCd() {
		return this.stsCd;
	}
	
	/**
	 * Column Info
	 * @return plnDt2
	 */
	public String getPlnDt2() {
		return this.plnDt2;
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
	 * @return estmDt2
	 */
	public String getEstmDt2() {
		return this.estmDt2;
	}
	
	/**
	 * Column Info
	 * @return actNm
	 */
	public String getActNm() {
		return this.actNm;
	}
	
	/**
	 * Column Info
	 * @return estmDt1
	 */
	public String getEstmDt1() {
		return this.estmDt1;
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
	 * @return actDt1
	 */
	public String getActDt1() {
		return this.actDt1;
	}
	

	/**
	 * Column Info
	 * @param copyn
	 */
	public void setCopyn(String copyn) {
		this.copyn = copyn;
	}
	
	/**
	 * Column Info
	 * @param actDt2
	 */
	public void setActDt2(String actDt2) {
		this.actDt2 = actDt2;
	}
	
	/**
	 * Column Info
	 * @param sortDt
	 */
	public void setSortDt(String sortDt) {
		this.sortDt = sortDt;
	}
	
	/**
	 * Column Info
	 * @param ediMsgTpCd
	 */
	public void setEdiMsgTpCd(String ediMsgTpCd) {
		this.ediMsgTpCd = ediMsgTpCd;
	}
	
	/**
	 * Column Info
	 * @param copDtlSeq
	 */
	public void setCopDtlSeq(String copDtlSeq) {
		this.copDtlSeq = copDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param plnDt1
	 */
	public void setPlnDt1(String plnDt1) {
		this.plnDt1 = plnDt1;
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
	 * @param stsCd
	 */
	public void setStsCd(String stsCd) {
		this.stsCd = stsCd;
	}
	
	/**
	 * Column Info
	 * @param plnDt2
	 */
	public void setPlnDt2(String plnDt2) {
		this.plnDt2 = plnDt2;
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
	 * @param estmDt2
	 */
	public void setEstmDt2(String estmDt2) {
		this.estmDt2 = estmDt2;
	}
	
	/**
	 * Column Info
	 * @param actNm
	 */
	public void setActNm(String actNm) {
		this.actNm = actNm;
	}
	
	/**
	 * Column Info
	 * @param estmDt1
	 */
	public void setEstmDt1(String estmDt1) {
		this.estmDt1 = estmDt1;
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
	 * @param actDt1
	 */
	public void setActDt1(String actDt1) {
		this.actDt1 = actDt1;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCopyn(JSPUtil.getParameter(request, "copyn", ""));
		setActDt2(JSPUtil.getParameter(request, "act_dt2", ""));
		setSortDt(JSPUtil.getParameter(request, "sort_dt", ""));
		setEdiMsgTpCd(JSPUtil.getParameter(request, "edi_msg_tp_cd", ""));
		setCopDtlSeq(JSPUtil.getParameter(request, "cop_dtl_seq", ""));
		setPlnDt1(JSPUtil.getParameter(request, "pln_dt1", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setStsCd(JSPUtil.getParameter(request, "sts_cd", ""));
		setPlnDt2(JSPUtil.getParameter(request, "pln_dt2", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEstmDt2(JSPUtil.getParameter(request, "estm_dt2", ""));
		setActNm(JSPUtil.getParameter(request, "act_nm", ""));
		setEstmDt1(JSPUtil.getParameter(request, "estm_dt1", ""));
		setNodCd(JSPUtil.getParameter(request, "nod_cd", ""));
		setActDt1(JSPUtil.getParameter(request, "act_dt1", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchActualInfoVO[]
	 */
	public SearchActualInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchActualInfoVO[]
	 */
	public SearchActualInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchActualInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] copyn = (JSPUtil.getParameter(request, prefix	+ "copyn", length));
			String[] actDt2 = (JSPUtil.getParameter(request, prefix	+ "act_dt2", length));
			String[] sortDt = (JSPUtil.getParameter(request, prefix	+ "sort_dt", length));
			String[] ediMsgTpCd = (JSPUtil.getParameter(request, prefix	+ "edi_msg_tp_cd", length));
			String[] copDtlSeq = (JSPUtil.getParameter(request, prefix	+ "cop_dtl_seq", length));
			String[] plnDt1 = (JSPUtil.getParameter(request, prefix	+ "pln_dt1", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] stsCd = (JSPUtil.getParameter(request, prefix	+ "sts_cd", length));
			String[] plnDt2 = (JSPUtil.getParameter(request, prefix	+ "pln_dt2", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] estmDt2 = (JSPUtil.getParameter(request, prefix	+ "estm_dt2", length));
			String[] actNm = (JSPUtil.getParameter(request, prefix	+ "act_nm", length));
			String[] estmDt1 = (JSPUtil.getParameter(request, prefix	+ "estm_dt1", length));
			String[] nodCd = (JSPUtil.getParameter(request, prefix	+ "nod_cd", length));
			String[] actDt1 = (JSPUtil.getParameter(request, prefix	+ "act_dt1", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchActualInfoVO();
				if (copyn[i] != null)
					model.setCopyn(copyn[i]);
				if (actDt2[i] != null)
					model.setActDt2(actDt2[i]);
				if (sortDt[i] != null)
					model.setSortDt(sortDt[i]);
				if (ediMsgTpCd[i] != null)
					model.setEdiMsgTpCd(ediMsgTpCd[i]);
				if (copDtlSeq[i] != null)
					model.setCopDtlSeq(copDtlSeq[i]);
				if (plnDt1[i] != null)
					model.setPlnDt1(plnDt1[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (stsCd[i] != null)
					model.setStsCd(stsCd[i]);
				if (plnDt2[i] != null)
					model.setPlnDt2(plnDt2[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (estmDt2[i] != null)
					model.setEstmDt2(estmDt2[i]);
				if (actNm[i] != null)
					model.setActNm(actNm[i]);
				if (estmDt1[i] != null)
					model.setEstmDt1(estmDt1[i]);
				if (nodCd[i] != null)
					model.setNodCd(nodCd[i]);
				if (actDt1[i] != null)
					model.setActDt1(actDt1[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchActualInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchActualInfoVO[]
	 */
	public SearchActualInfoVO[] getSearchActualInfoVOs(){
		SearchActualInfoVO[] vos = (SearchActualInfoVO[])models.toArray(new SearchActualInfoVO[models.size()]);
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
		this.copyn = this.copyn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDt2 = this.actDt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sortDt = this.sortDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediMsgTpCd = this.ediMsgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copDtlSeq = this.copDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnDt1 = this.plnDt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsCd = this.stsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnDt2 = this.plnDt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmDt2 = this.estmDt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actNm = this.actNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmDt1 = this.estmDt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodCd = this.nodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDt1 = this.actDt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

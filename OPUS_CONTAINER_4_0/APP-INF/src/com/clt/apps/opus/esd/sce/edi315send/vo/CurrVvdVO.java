/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CurrVvdVO.java
*@FileTitle : CurrVvdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.17
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.02.17 이윤정 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.edi315send.vo;

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
 * @author 이윤정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CurrVvdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CurrVvdVO> models = new ArrayList<CurrVvdVO>();
	
	/* Column Info */
	private String currVvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String lloydCd = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String vslCntCd = null;
	/* Column Info */
	private String currDtlSeq = null;
	/* Column Info */
	private String bound = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CurrVvdVO() {}

	public CurrVvdVO(String ibflag, String pagerows, String currVvd, String bound, String currDtlSeq, String vslNm, String vslCntCd, String lloydCd) {
		this.currVvd = currVvd;
		this.ibflag = ibflag;
		this.lloydCd = lloydCd;
		this.vslNm = vslNm;
		this.vslCntCd = vslCntCd;
		this.currDtlSeq = currDtlSeq;
		this.bound = bound;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("curr_vvd", getCurrVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("lloyd_cd", getLloydCd());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("vsl_cnt_cd", getVslCntCd());
		this.hashColumns.put("curr_dtl_seq", getCurrDtlSeq());
		this.hashColumns.put("bound", getBound());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("curr_vvd", "currVvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("lloyd_cd", "lloydCd");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("vsl_cnt_cd", "vslCntCd");
		this.hashFields.put("curr_dtl_seq", "currDtlSeq");
		this.hashFields.put("bound", "bound");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return currVvd
	 */
	public String getCurrVvd() {
		return this.currVvd;
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
	 * @return lloydCd
	 */
	public String getLloydCd() {
		return this.lloydCd;
	}
	
	/**
	 * Column Info
	 * @return vslNm
	 */
	public String getVslNm() {
		return this.vslNm;
	}
	
	/**
	 * Column Info
	 * @return vslCntCd
	 */
	public String getVslCntCd() {
		return this.vslCntCd;
	}
	
	/**
	 * Column Info
	 * @return currDtlSeq
	 */
	public String getCurrDtlSeq() {
		return this.currDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return bound
	 */
	public String getBound() {
		return this.bound;
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
	 * @param currVvd
	 */
	public void setCurrVvd(String currVvd) {
		this.currVvd = currVvd;
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
	 * @param lloydCd
	 */
	public void setLloydCd(String lloydCd) {
		this.lloydCd = lloydCd;
	}
	
	/**
	 * Column Info
	 * @param vslNm
	 */
	public void setVslNm(String vslNm) {
		this.vslNm = vslNm;
	}
	
	/**
	 * Column Info
	 * @param vslCntCd
	 */
	public void setVslCntCd(String vslCntCd) {
		this.vslCntCd = vslCntCd;
	}
	
	/**
	 * Column Info
	 * @param currDtlSeq
	 */
	public void setCurrDtlSeq(String currDtlSeq) {
		this.currDtlSeq = currDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param bound
	 */
	public void setBound(String bound) {
		this.bound = bound;
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
		setCurrVvd(JSPUtil.getParameter(request, prefix + "curr_vvd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLloydCd(JSPUtil.getParameter(request, prefix + "lloyd_cd", ""));
		setVslNm(JSPUtil.getParameter(request, prefix + "vsl_nm", ""));
		setVslCntCd(JSPUtil.getParameter(request, prefix + "vsl_cnt_cd", ""));
		setCurrDtlSeq(JSPUtil.getParameter(request, prefix + "curr_dtl_seq", ""));
		setBound(JSPUtil.getParameter(request, prefix + "bound", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CurrVvdVO[]
	 */
	public CurrVvdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CurrVvdVO[]
	 */
	public CurrVvdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CurrVvdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] currVvd = (JSPUtil.getParameter(request, prefix	+ "curr_vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] lloydCd = (JSPUtil.getParameter(request, prefix	+ "lloyd_cd", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] vslCntCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cnt_cd", length));
			String[] currDtlSeq = (JSPUtil.getParameter(request, prefix	+ "curr_dtl_seq", length));
			String[] bound = (JSPUtil.getParameter(request, prefix	+ "bound", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CurrVvdVO();
				if (currVvd[i] != null)
					model.setCurrVvd(currVvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (lloydCd[i] != null)
					model.setLloydCd(lloydCd[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (vslCntCd[i] != null)
					model.setVslCntCd(vslCntCd[i]);
				if (currDtlSeq[i] != null)
					model.setCurrDtlSeq(currDtlSeq[i]);
				if (bound[i] != null)
					model.setBound(bound[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCurrVvdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CurrVvdVO[]
	 */
	public CurrVvdVO[] getCurrVvdVOs(){
		CurrVvdVO[] vos = (CurrVvdVO[])models.toArray(new CurrVvdVO[models.size()]);
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
		this.currVvd = this.currVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lloydCd = this.lloydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCntCd = this.vslCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currDtlSeq = this.currDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bound = this.bound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchAgmtHdrVO.java
*@FileTitle : SearchAgmtHdrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.19
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2010.04.19 최종혁 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.vo;

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
 * @author 최종혁
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchAgmtHdrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchAgmtHdrVO> models = new ArrayList<SearchAgmtHdrVO>();
	
	/* Column Info */
	private String vndrPrmrySeq = null;
	/* Column Info */
	private String agmtRefNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String interRmk = null;
	/* Column Info */
	private String trspAgmtSeq = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String trspAgmtOfcCtyCd = null;
	/* Column Info */
	private String agmtPicNm = null;
	/* Column Info */
	private String vndrPrmryNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchAgmtHdrVO() {}

	public SearchAgmtHdrVO(String ibflag, String pagerows, String trspAgmtOfcCtyCd, String trspAgmtSeq, String vndrPrmrySeq, String vndrPrmryNm, String ctrtOfcCd, String agmtRefNo, String agmtPicNm, String interRmk, String creOfcCd, String creUsrId) {
		this.vndrPrmrySeq = vndrPrmrySeq;
		this.agmtRefNo = agmtRefNo;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.interRmk = interRmk;
		this.trspAgmtSeq = trspAgmtSeq;
		this.creOfcCd = creOfcCd;
		this.ctrtOfcCd = ctrtOfcCd;
		this.trspAgmtOfcCtyCd = trspAgmtOfcCtyCd;
		this.agmtPicNm = agmtPicNm;
		this.vndrPrmryNm = vndrPrmryNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vndr_prmry_seq", getVndrPrmrySeq());
		this.hashColumns.put("agmt_ref_no", getAgmtRefNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("inter_rmk", getInterRmk());
		this.hashColumns.put("trsp_agmt_seq", getTrspAgmtSeq());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("trsp_agmt_ofc_cty_cd", getTrspAgmtOfcCtyCd());
		this.hashColumns.put("agmt_pic_nm", getAgmtPicNm());
		this.hashColumns.put("vndr_prmry_nm", getVndrPrmryNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vndr_prmry_seq", "vndrPrmrySeq");
		this.hashFields.put("agmt_ref_no", "agmtRefNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inter_rmk", "interRmk");
		this.hashFields.put("trsp_agmt_seq", "trspAgmtSeq");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("trsp_agmt_ofc_cty_cd", "trspAgmtOfcCtyCd");
		this.hashFields.put("agmt_pic_nm", "agmtPicNm");
		this.hashFields.put("vndr_prmry_nm", "vndrPrmryNm");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vndrPrmrySeq
	 */
	public String getVndrPrmrySeq() {
		return this.vndrPrmrySeq;
	}
	
	/**
	 * Column Info
	 * @return agmtRefNo
	 */
	public String getAgmtRefNo() {
		return this.agmtRefNo;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return interRmk
	 */
	public String getInterRmk() {
		return this.interRmk;
	}
	
	/**
	 * Column Info
	 * @return trspAgmtSeq
	 */
	public String getTrspAgmtSeq() {
		return this.trspAgmtSeq;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtOfcCd
	 */
	public String getCtrtOfcCd() {
		return this.ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @return trspAgmtOfcCtyCd
	 */
	public String getTrspAgmtOfcCtyCd() {
		return this.trspAgmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return agmtPicNm
	 */
	public String getAgmtPicNm() {
		return this.agmtPicNm;
	}
	
	/**
	 * Column Info
	 * @return vndrPrmryNm
	 */
	public String getVndrPrmryNm() {
		return this.vndrPrmryNm;
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
	 * @param vndrPrmrySeq
	 */
	public void setVndrPrmrySeq(String vndrPrmrySeq) {
		this.vndrPrmrySeq = vndrPrmrySeq;
	}
	
	/**
	 * Column Info
	 * @param agmtRefNo
	 */
	public void setAgmtRefNo(String agmtRefNo) {
		this.agmtRefNo = agmtRefNo;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param interRmk
	 */
	public void setInterRmk(String interRmk) {
		this.interRmk = interRmk;
	}
	
	/**
	 * Column Info
	 * @param trspAgmtSeq
	 */
	public void setTrspAgmtSeq(String trspAgmtSeq) {
		this.trspAgmtSeq = trspAgmtSeq;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtOfcCd
	 */
	public void setCtrtOfcCd(String ctrtOfcCd) {
		this.ctrtOfcCd = ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @param trspAgmtOfcCtyCd
	 */
	public void setTrspAgmtOfcCtyCd(String trspAgmtOfcCtyCd) {
		this.trspAgmtOfcCtyCd = trspAgmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param agmtPicNm
	 */
	public void setAgmtPicNm(String agmtPicNm) {
		this.agmtPicNm = agmtPicNm;
	}
	
	/**
	 * Column Info
	 * @param vndrPrmryNm
	 */
	public void setVndrPrmryNm(String vndrPrmryNm) {
		this.vndrPrmryNm = vndrPrmryNm;
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
		setVndrPrmrySeq(JSPUtil.getParameter(request, prefix + "vndr_prmry_seq", ""));
		setAgmtRefNo(JSPUtil.getParameter(request, prefix + "agmt_ref_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setInterRmk(JSPUtil.getParameter(request, prefix + "inter_rmk", ""));
		setTrspAgmtSeq(JSPUtil.getParameter(request, prefix + "trsp_agmt_seq", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
		setTrspAgmtOfcCtyCd(JSPUtil.getParameter(request, prefix + "trsp_agmt_ofc_cty_cd", ""));
		setAgmtPicNm(JSPUtil.getParameter(request, prefix + "agmt_pic_nm", ""));
		setVndrPrmryNm(JSPUtil.getParameter(request, prefix + "vndr_prmry_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchAgmtHdrVO[]
	 */
	public SearchAgmtHdrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchAgmtHdrVO[]
	 */
	public SearchAgmtHdrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchAgmtHdrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vndrPrmrySeq = (JSPUtil.getParameter(request, prefix	+ "vndr_prmry_seq", length));
			String[] agmtRefNo = (JSPUtil.getParameter(request, prefix	+ "agmt_ref_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] interRmk = (JSPUtil.getParameter(request, prefix	+ "inter_rmk", length));
			String[] trspAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_seq", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] trspAgmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_ofc_cty_cd", length));
			String[] agmtPicNm = (JSPUtil.getParameter(request, prefix	+ "agmt_pic_nm", length));
			String[] vndrPrmryNm = (JSPUtil.getParameter(request, prefix	+ "vndr_prmry_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchAgmtHdrVO();
				if (vndrPrmrySeq[i] != null)
					model.setVndrPrmrySeq(vndrPrmrySeq[i]);
				if (agmtRefNo[i] != null)
					model.setAgmtRefNo(agmtRefNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (interRmk[i] != null)
					model.setInterRmk(interRmk[i]);
				if (trspAgmtSeq[i] != null)
					model.setTrspAgmtSeq(trspAgmtSeq[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (trspAgmtOfcCtyCd[i] != null)
					model.setTrspAgmtOfcCtyCd(trspAgmtOfcCtyCd[i]);
				if (agmtPicNm[i] != null)
					model.setAgmtPicNm(agmtPicNm[i]);
				if (vndrPrmryNm[i] != null)
					model.setVndrPrmryNm(vndrPrmryNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchAgmtHdrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchAgmtHdrVO[]
	 */
	public SearchAgmtHdrVO[] getSearchAgmtHdrVOs(){
		SearchAgmtHdrVO[] vos = (SearchAgmtHdrVO[])models.toArray(new SearchAgmtHdrVO[models.size()]);
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
		this.vndrPrmrySeq = this.vndrPrmrySeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtRefNo = this.agmtRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interRmk = this.interRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtSeq = this.trspAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtOfcCtyCd = this.trspAgmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtPicNm = this.agmtPicNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrPrmryNm = this.vndrPrmryNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

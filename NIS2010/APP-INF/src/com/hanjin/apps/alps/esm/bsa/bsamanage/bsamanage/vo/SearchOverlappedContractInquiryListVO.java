/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchOverlappedContractInquiryListVO.java
*@FileTitle : SearchOverlappedContractInquiryListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.11
*@LastModifier : 김용습
*@LastVersion : 1.0
* 2014.12.11  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchOverlappedContractInquiryListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchOverlappedContractInquiryListVO> models = new ArrayList<SearchOverlappedContractInquiryListVO>();
	
	/* Column Info */
	private String bsaFmDt = null;
	/* Column Info */
	private String vopCd = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vslCapa = null;
	/* Column Info */
	private String reverseFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String bsaToDt = null;
	/* Column Info */
	private String bsaGroup = null;
	/* Column Info */
	private String bsaSeq = null;
	/* Column Info */
	private String dirCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchOverlappedContractInquiryListVO() {}

	public SearchOverlappedContractInquiryListVO(String ibflag, String pagerows, String bsaGroup, String bsaSeq, String vvdCd, String bsaFmDt, String bsaToDt, String trdCd, String rlaneCd, String dirCd, String vopCd, String vslCapa, String reverseFlg) {
		this.bsaFmDt = bsaFmDt;
		this.vopCd = vopCd;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.pagerows = pagerows;
		this.vslCapa = vslCapa;
		this.reverseFlg = reverseFlg;
		this.ibflag = ibflag;
		this.vvdCd = vvdCd;
		this.bsaToDt = bsaToDt;
		this.bsaGroup = bsaGroup;
		this.bsaSeq = bsaSeq;
		this.dirCd = dirCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bsa_fm_dt", getBsaFmDt());
		this.hashColumns.put("vop_cd", getVopCd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vsl_capa", getVslCapa());
		this.hashColumns.put("reverse_flg", getReverseFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("bsa_to_dt", getBsaToDt());
		this.hashColumns.put("bsa_group", getBsaGroup());
		this.hashColumns.put("bsa_seq", getBsaSeq());
		this.hashColumns.put("dir_cd", getDirCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bsa_fm_dt", "bsaFmDt");
		this.hashFields.put("vop_cd", "vopCd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vsl_capa", "vslCapa");
		this.hashFields.put("reverse_flg", "reverseFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("bsa_to_dt", "bsaToDt");
		this.hashFields.put("bsa_group", "bsaGroup");
		this.hashFields.put("bsa_seq", "bsaSeq");
		this.hashFields.put("dir_cd", "dirCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bsaFmDt
	 */
	public String getBsaFmDt() {
		return this.bsaFmDt;
	}
	
	/**
	 * Column Info
	 * @return vopCd
	 */
	public String getVopCd() {
		return this.vopCd;
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
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
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
	 * @return vslCapa
	 */
	public String getVslCapa() {
		return this.vslCapa;
	}
	
	/**
	 * Column Info
	 * @return reverseFlg
	 */
	public String getReverseFlg() {
		return this.reverseFlg;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return bsaToDt
	 */
	public String getBsaToDt() {
		return this.bsaToDt;
	}
	
	/**
	 * Column Info
	 * @return bsaGroup
	 */
	public String getBsaGroup() {
		return this.bsaGroup;
	}
	
	/**
	 * Column Info
	 * @return bsaSeq
	 */
	public String getBsaSeq() {
		return this.bsaSeq;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	

	/**
	 * Column Info
	 * @param bsaFmDt
	 */
	public void setBsaFmDt(String bsaFmDt) {
		this.bsaFmDt = bsaFmDt;
	}
	
	/**
	 * Column Info
	 * @param vopCd
	 */
	public void setVopCd(String vopCd) {
		this.vopCd = vopCd;
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
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
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
	 * @param vslCapa
	 */
	public void setVslCapa(String vslCapa) {
		this.vslCapa = vslCapa;
	}
	
	/**
	 * Column Info
	 * @param reverseFlg
	 */
	public void setReverseFlg(String reverseFlg) {
		this.reverseFlg = reverseFlg;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param bsaToDt
	 */
	public void setBsaToDt(String bsaToDt) {
		this.bsaToDt = bsaToDt;
	}
	
	/**
	 * Column Info
	 * @param bsaGroup
	 */
	public void setBsaGroup(String bsaGroup) {
		this.bsaGroup = bsaGroup;
	}
	
	/**
	 * Column Info
	 * @param bsaSeq
	 */
	public void setBsaSeq(String bsaSeq) {
		this.bsaSeq = bsaSeq;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
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
		setBsaFmDt(JSPUtil.getParameter(request, prefix + "bsa_fm_dt", ""));
		setVopCd(JSPUtil.getParameter(request, prefix + "vop_cd", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVslCapa(JSPUtil.getParameter(request, prefix + "vsl_capa", ""));
		setReverseFlg(JSPUtil.getParameter(request, prefix + "reverse_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setBsaToDt(JSPUtil.getParameter(request, prefix + "bsa_to_dt", ""));
		setBsaGroup(JSPUtil.getParameter(request, prefix + "bsa_group", ""));
		setBsaSeq(JSPUtil.getParameter(request, prefix + "bsa_seq", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchOverlappedContractInquiryListVO[]
	 */
	public SearchOverlappedContractInquiryListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchOverlappedContractInquiryListVO[]
	 */
	public SearchOverlappedContractInquiryListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchOverlappedContractInquiryListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bsaFmDt = (JSPUtil.getParameter(request, prefix	+ "bsa_fm_dt", length));
			String[] vopCd = (JSPUtil.getParameter(request, prefix	+ "vop_cd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vslCapa = (JSPUtil.getParameter(request, prefix	+ "vsl_capa", length));
			String[] reverseFlg = (JSPUtil.getParameter(request, prefix	+ "reverse_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] bsaToDt = (JSPUtil.getParameter(request, prefix	+ "bsa_to_dt", length));
			String[] bsaGroup = (JSPUtil.getParameter(request, prefix	+ "bsa_group", length));
			String[] bsaSeq = (JSPUtil.getParameter(request, prefix	+ "bsa_seq", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchOverlappedContractInquiryListVO();
				if (bsaFmDt[i] != null)
					model.setBsaFmDt(bsaFmDt[i]);
				if (vopCd[i] != null)
					model.setVopCd(vopCd[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vslCapa[i] != null)
					model.setVslCapa(vslCapa[i]);
				if (reverseFlg[i] != null)
					model.setReverseFlg(reverseFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (bsaToDt[i] != null)
					model.setBsaToDt(bsaToDt[i]);
				if (bsaGroup[i] != null)
					model.setBsaGroup(bsaGroup[i]);
				if (bsaSeq[i] != null)
					model.setBsaSeq(bsaSeq[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchOverlappedContractInquiryListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchOverlappedContractInquiryListVO[]
	 */
	public SearchOverlappedContractInquiryListVO[] getSearchOverlappedContractInquiryListVOs(){
		SearchOverlappedContractInquiryListVO[] vos = (SearchOverlappedContractInquiryListVO[])models.toArray(new SearchOverlappedContractInquiryListVO[models.size()]);
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
		this.bsaFmDt = this.bsaFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vopCd = this.vopCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCapa = this.vslCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reverseFlg = this.reverseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaToDt = this.bsaToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaGroup = this.bsaGroup .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaSeq = this.bsaSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

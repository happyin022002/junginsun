/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSpcScPortDownMasterListVO.java
*@FileTitle : SearchSpcScPortDownMasterListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.09
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.11.09 남궁진호 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo;

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
 * @author 남궁진호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSpcScPortDownMasterListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSpcScPortDownMasterListVO> models = new ArrayList<SearchSpcScPortDownMasterListVO>();
	
	/* Column Info */
	private String bsaFmDt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String vslSeq = null;
	/* Column Info */
	private String coFnlBsaCapa = null;
	/* Column Info */
	private String crrBsaCapa = null;
	/* Column Info */
	private String crrCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bsaOpJbCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String bsaToDt = null;
	/* Column Info */
	private String stupFlg = null;
	/* Column Info */
	private String bsaOpCd = null;
	/* Column Info */
	private String bsaSeq = null;
	/* Column Info */
	private String dirCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSpcScPortDownMasterListVO() {}

	public SearchSpcScPortDownMasterListVO(String ibflag, String pagerows, String bsaSeq, String trdCd, String rlaneCd, String dirCd, String vslSeq, String vvdCd, String bsaFmDt, String bsaToDt, String vslCd, String coFnlBsaCapa, String bsaOpCd, String bsaOpJbCd, String crrCd, String stupFlg, String crrBsaCapa) {
		this.bsaFmDt = bsaFmDt;
		this.vslCd = vslCd;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.vslSeq = vslSeq;
		this.coFnlBsaCapa = coFnlBsaCapa;
		this.crrBsaCapa = crrBsaCapa;
		this.crrCd = crrCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.bsaOpJbCd = bsaOpJbCd;
		this.vvdCd = vvdCd;
		this.bsaToDt = bsaToDt;
		this.stupFlg = stupFlg;
		this.bsaOpCd = bsaOpCd;
		this.bsaSeq = bsaSeq;
		this.dirCd = dirCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bsa_fm_dt", getBsaFmDt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("vsl_seq", getVslSeq());
		this.hashColumns.put("co_fnl_bsa_capa", getCoFnlBsaCapa());
		this.hashColumns.put("crr_bsa_capa", getCrrBsaCapa());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bsa_op_jb_cd", getBsaOpJbCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("bsa_to_dt", getBsaToDt());
		this.hashColumns.put("stup_flg", getStupFlg());
		this.hashColumns.put("bsa_op_cd", getBsaOpCd());
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
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("vsl_seq", "vslSeq");
		this.hashFields.put("co_fnl_bsa_capa", "coFnlBsaCapa");
		this.hashFields.put("crr_bsa_capa", "crrBsaCapa");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bsa_op_jb_cd", "bsaOpJbCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("bsa_to_dt", "bsaToDt");
		this.hashFields.put("stup_flg", "stupFlg");
		this.hashFields.put("bsa_op_cd", "bsaOpCd");
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
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
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
	 * Column Info
	 * @return vslSeq
	 */
	public String getVslSeq() {
		return this.vslSeq;
	}
	
	/**
	 * Column Info
	 * @return coFnlBsaCapa
	 */
	public String getCoFnlBsaCapa() {
		return this.coFnlBsaCapa;
	}
	
	/**
	 * Column Info
	 * @return crrBsaCapa
	 */
	public String getCrrBsaCapa() {
		return this.crrBsaCapa;
	}
	
	/**
	 * Column Info
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
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
	 * @return bsaOpJbCd
	 */
	public String getBsaOpJbCd() {
		return this.bsaOpJbCd;
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
	 * @return stupFlg
	 */
	public String getStupFlg() {
		return this.stupFlg;
	}
	
	/**
	 * Column Info
	 * @return bsaOpCd
	 */
	public String getBsaOpCd() {
		return this.bsaOpCd;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
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
	 * Column Info
	 * @param vslSeq
	 */
	public void setVslSeq(String vslSeq) {
		this.vslSeq = vslSeq;
	}
	
	/**
	 * Column Info
	 * @param coFnlBsaCapa
	 */
	public void setCoFnlBsaCapa(String coFnlBsaCapa) {
		this.coFnlBsaCapa = coFnlBsaCapa;
	}
	
	/**
	 * Column Info
	 * @param crrBsaCapa
	 */
	public void setCrrBsaCapa(String crrBsaCapa) {
		this.crrBsaCapa = crrBsaCapa;
	}
	
	/**
	 * Column Info
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
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
	 * @param bsaOpJbCd
	 */
	public void setBsaOpJbCd(String bsaOpJbCd) {
		this.bsaOpJbCd = bsaOpJbCd;
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
	 * @param stupFlg
	 */
	public void setStupFlg(String stupFlg) {
		this.stupFlg = stupFlg;
	}
	
	/**
	 * Column Info
	 * @param bsaOpCd
	 */
	public void setBsaOpCd(String bsaOpCd) {
		this.bsaOpCd = bsaOpCd;
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
		setBsaFmDt(JSPUtil.getParameter(request, "bsa_fm_dt", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setVslSeq(JSPUtil.getParameter(request, "vsl_seq", ""));
		setCoFnlBsaCapa(JSPUtil.getParameter(request, "co_fnl_bsa_capa", ""));
		setCrrBsaCapa(JSPUtil.getParameter(request, "crr_bsa_capa", ""));
		setCrrCd(JSPUtil.getParameter(request, "crr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBsaOpJbCd(JSPUtil.getParameter(request, "bsa_op_jb_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setBsaToDt(JSPUtil.getParameter(request, "bsa_to_dt", ""));
		setStupFlg(JSPUtil.getParameter(request, "stup_flg", ""));
		setBsaOpCd(JSPUtil.getParameter(request, "bsa_op_cd", ""));
		setBsaSeq(JSPUtil.getParameter(request, "bsa_seq", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSpcScPortDownMasterListVO[]
	 */
	public SearchSpcScPortDownMasterListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSpcScPortDownMasterListVO[]
	 */
	public SearchSpcScPortDownMasterListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSpcScPortDownMasterListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bsaFmDt = (JSPUtil.getParameter(request, prefix	+ "bsa_fm_dt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] vslSeq = (JSPUtil.getParameter(request, prefix	+ "vsl_seq", length));
			String[] coFnlBsaCapa = (JSPUtil.getParameter(request, prefix	+ "co_fnl_bsa_capa", length));
			String[] crrBsaCapa = (JSPUtil.getParameter(request, prefix	+ "crr_bsa_capa", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bsaOpJbCd = (JSPUtil.getParameter(request, prefix	+ "bsa_op_jb_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] bsaToDt = (JSPUtil.getParameter(request, prefix	+ "bsa_to_dt", length));
			String[] stupFlg = (JSPUtil.getParameter(request, prefix	+ "stup_flg", length));
			String[] bsaOpCd = (JSPUtil.getParameter(request, prefix	+ "bsa_op_cd", length));
			String[] bsaSeq = (JSPUtil.getParameter(request, prefix	+ "bsa_seq", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSpcScPortDownMasterListVO();
				if (bsaFmDt[i] != null)
					model.setBsaFmDt(bsaFmDt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (vslSeq[i] != null)
					model.setVslSeq(vslSeq[i]);
				if (coFnlBsaCapa[i] != null)
					model.setCoFnlBsaCapa(coFnlBsaCapa[i]);
				if (crrBsaCapa[i] != null)
					model.setCrrBsaCapa(crrBsaCapa[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bsaOpJbCd[i] != null)
					model.setBsaOpJbCd(bsaOpJbCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (bsaToDt[i] != null)
					model.setBsaToDt(bsaToDt[i]);
				if (stupFlg[i] != null)
					model.setStupFlg(stupFlg[i]);
				if (bsaOpCd[i] != null)
					model.setBsaOpCd(bsaOpCd[i]);
				if (bsaSeq[i] != null)
					model.setBsaSeq(bsaSeq[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSpcScPortDownMasterListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSpcScPortDownMasterListVO[]
	 */
	public SearchSpcScPortDownMasterListVO[] getSearchSpcScPortDownMasterListVOs(){
		SearchSpcScPortDownMasterListVO[] vos = (SearchSpcScPortDownMasterListVO[])models.toArray(new SearchSpcScPortDownMasterListVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSeq = this.vslSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coFnlBsaCapa = this.coFnlBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrBsaCapa = this.crrBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaOpJbCd = this.bsaOpJbCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaToDt = this.bsaToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stupFlg = this.stupFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaOpCd = this.bsaOpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaSeq = this.bsaSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

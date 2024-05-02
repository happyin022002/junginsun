/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BlGetVO.java
*@FileTitle : BlGetVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.21
*@LastModifier : 정행룡
*@LastVersion : 1.0
* 2009.10.21 정행룡 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo;

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
 * @author 정행룡
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BlGetVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BlGetVO> models = new ArrayList<BlGetVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String crrTermCd = null;
	/* Column Info */
	private String lodgDt = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String trnkRefVvdNo = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String cgoQltyDesc = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BlGetVO() {}

	public BlGetVO(String ibflag, String pagerows, String delCd, String crrTermCd, String trnkRefVvdNo, String vslEngNm, String cgoQltyDesc, String slanCd, String lodgDt) {
		this.ibflag = ibflag;
		this.slanCd = slanCd;
		this.crrTermCd = crrTermCd;
		this.lodgDt = lodgDt;
		this.vslEngNm = vslEngNm;
		this.trnkRefVvdNo = trnkRefVvdNo;
		this.delCd = delCd;
		this.cgoQltyDesc = cgoQltyDesc;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("crr_term_cd", getCrrTermCd());
		this.hashColumns.put("lodg_dt", getLodgDt());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("trnk_ref_vvd_no", getTrnkRefVvdNo());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("cgo_qlty_desc", getCgoQltyDesc());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("crr_term_cd", "crrTermCd");
		this.hashFields.put("lodg_dt", "lodgDt");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("trnk_ref_vvd_no", "trnkRefVvdNo");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("cgo_qlty_desc", "cgoQltyDesc");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return crrTermCd
	 */
	public String getCrrTermCd() {
		return this.crrTermCd;
	}
	
	/**
	 * Column Info
	 * @return lodgDt
	 */
	public String getLodgDt() {
		return this.lodgDt;
	}
	
	/**
	 * Column Info
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	
	/**
	 * Column Info
	 * @return trnkRefVvdNo
	 */
	public String getTrnkRefVvdNo() {
		return this.trnkRefVvdNo;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return cgoQltyDesc
	 */
	public String getCgoQltyDesc() {
		return this.cgoQltyDesc;
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
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
	 * @param crrTermCd
	 */
	public void setCrrTermCd(String crrTermCd) {
		this.crrTermCd = crrTermCd;
	}
	
	/**
	 * Column Info
	 * @param lodgDt
	 */
	public void setLodgDt(String lodgDt) {
		this.lodgDt = lodgDt;
	}
	
	/**
	 * Column Info
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
	}
	
	/**
	 * Column Info
	 * @param trnkRefVvdNo
	 */
	public void setTrnkRefVvdNo(String trnkRefVvdNo) {
		this.trnkRefVvdNo = trnkRefVvdNo;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param cgoQltyDesc
	 */
	public void setCgoQltyDesc(String cgoQltyDesc) {
		this.cgoQltyDesc = cgoQltyDesc;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setCrrTermCd(JSPUtil.getParameter(request, "crr_term_cd", ""));
		setLodgDt(JSPUtil.getParameter(request, "lodg_dt", ""));
		setVslEngNm(JSPUtil.getParameter(request, "vsl_eng_nm", ""));
		setTrnkRefVvdNo(JSPUtil.getParameter(request, "trnk_ref_vvd_no", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setCgoQltyDesc(JSPUtil.getParameter(request, "cgo_qlty_desc", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BlGetVO[]
	 */
	public BlGetVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BlGetVO[]
	 */
	public BlGetVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BlGetVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] crrTermCd = (JSPUtil.getParameter(request, prefix	+ "crr_term_cd", length));
			String[] lodgDt = (JSPUtil.getParameter(request, prefix	+ "lodg_dt", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] trnkRefVvdNo = (JSPUtil.getParameter(request, prefix	+ "trnk_ref_vvd_no", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] cgoQltyDesc = (JSPUtil.getParameter(request, prefix	+ "cgo_qlty_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new BlGetVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (crrTermCd[i] != null)
					model.setCrrTermCd(crrTermCd[i]);
				if (lodgDt[i] != null)
					model.setLodgDt(lodgDt[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (trnkRefVvdNo[i] != null)
					model.setTrnkRefVvdNo(trnkRefVvdNo[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (cgoQltyDesc[i] != null)
					model.setCgoQltyDesc(cgoQltyDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBlGetVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BlGetVO[]
	 */
	public BlGetVO[] getBlGetVOs(){
		BlGetVO[] vos = (BlGetVO[])models.toArray(new BlGetVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrTermCd = this.crrTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodgDt = this.lodgDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkRefVvdNo = this.trnkRefVvdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoQltyDesc = this.cgoQltyDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

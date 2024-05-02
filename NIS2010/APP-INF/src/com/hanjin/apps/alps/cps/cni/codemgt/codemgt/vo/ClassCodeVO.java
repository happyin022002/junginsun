/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ClassCodeVO.java
*@FileTitle : ClassCodeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 박제성
*@LastVersion : 1.0
* 2009.10.07 박제성 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박제성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ClassCodeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CniClassCodeVO> models = new ArrayList<CniClassCodeVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String clssClmMiscRmk = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String clssClmMiscCd = null;
	/* Column Info */
	private String clssClmMiscAbbrNm = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String clssClmMiscNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ClassCodeVO() {}

	public ClassCodeVO(String ibflag, String pagerows, String clssClmMiscCd, String clssClmMiscNm, String clssClmMiscAbbrNm, String clssClmMiscRmk, String creOfcCd, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.creOfcCd = creOfcCd;
		this.clssClmMiscRmk = clssClmMiscRmk;
		this.creDt = creDt;
		this.clssClmMiscCd = clssClmMiscCd;
		this.clssClmMiscAbbrNm = clssClmMiscAbbrNm;
		this.updUsrId = updUsrId;
		this.clssClmMiscNm = clssClmMiscNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("clss_clm_misc_rmk", getClssClmMiscRmk());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("clss_clm_misc_cd", getClssClmMiscCd());
		this.hashColumns.put("clss_clm_misc_abbr_nm", getClssClmMiscAbbrNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("clss_clm_misc_nm", getClssClmMiscNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("clss_clm_misc_rmk", "clssClmMiscRmk");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("clss_clm_misc_cd", "clssClmMiscCd");
		this.hashFields.put("clss_clm_misc_abbr_nm", "clssClmMiscAbbrNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("clss_clm_misc_nm", "clssClmMiscNm");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
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
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return clssClmMiscRmk
	 */
	public String getClssClmMiscRmk() {
		return this.clssClmMiscRmk;
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
	 * @return clssClmMiscCd
	 */
	public String getClssClmMiscCd() {
		return this.clssClmMiscCd;
	}
	
	/**
	 * Column Info
	 * @return clssClmMiscAbbrNm
	 */
	public String getClssClmMiscAbbrNm() {
		return this.clssClmMiscAbbrNm;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return clssClmMiscNm
	 */
	public String getClssClmMiscNm() {
		return this.clssClmMiscNm;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param clssClmMiscRmk
	 */
	public void setClssClmMiscRmk(String clssClmMiscRmk) {
		this.clssClmMiscRmk = clssClmMiscRmk;
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
	 * @param clssClmMiscCd
	 */
	public void setClssClmMiscCd(String clssClmMiscCd) {
		this.clssClmMiscCd = clssClmMiscCd;
	}
	
	/**
	 * Column Info
	 * @param clssClmMiscAbbrNm
	 */
	public void setClssClmMiscAbbrNm(String clssClmMiscAbbrNm) {
		this.clssClmMiscAbbrNm = clssClmMiscAbbrNm;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param clssClmMiscNm
	 */
	public void setClssClmMiscNm(String clssClmMiscNm) {
		this.clssClmMiscNm = clssClmMiscNm;
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
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setClssClmMiscRmk(JSPUtil.getParameter(request, "clss_clm_misc_rmk", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setClssClmMiscCd(JSPUtil.getParameter(request, "clss_clm_misc_cd", ""));
		setClssClmMiscAbbrNm(JSPUtil.getParameter(request, "clss_clm_misc_abbr_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setClssClmMiscNm(JSPUtil.getParameter(request, "clss_clm_misc_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CniClassCodeVO[]
	 */
	public CniClassCodeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CniClassCodeVO[]
	 */
	public CniClassCodeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CniClassCodeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] clssClmMiscRmk = (JSPUtil.getParameter(request, prefix	+ "clss_clm_misc_rmk", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] clssClmMiscCd = (JSPUtil.getParameter(request, prefix	+ "clss_clm_misc_cd", length));
			String[] clssClmMiscAbbrNm = (JSPUtil.getParameter(request, prefix	+ "clss_clm_misc_abbr_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] clssClmMiscNm = (JSPUtil.getParameter(request, prefix	+ "clss_clm_misc_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CniClassCodeVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (clssClmMiscRmk[i] != null)
					model.setClssClmMiscRmk(clssClmMiscRmk[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (clssClmMiscCd[i] != null)
					model.setClssClmMiscCd(clssClmMiscCd[i]);
				if (clssClmMiscAbbrNm[i] != null)
					model.setClssClmMiscAbbrNm(clssClmMiscAbbrNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (clssClmMiscNm[i] != null)
					model.setClssClmMiscNm(clssClmMiscNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCniClassCodeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CniClassCodeVO[]
	 */
	public CniClassCodeVO[] getCniClassCodeVOs(){
		CniClassCodeVO[] vos = (CniClassCodeVO[])models.toArray(new CniClassCodeVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clssClmMiscRmk = this.clssClmMiscRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clssClmMiscCd = this.clssClmMiscCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clssClmMiscAbbrNm = this.clssClmMiscAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clssClmMiscNm = this.clssClmMiscNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

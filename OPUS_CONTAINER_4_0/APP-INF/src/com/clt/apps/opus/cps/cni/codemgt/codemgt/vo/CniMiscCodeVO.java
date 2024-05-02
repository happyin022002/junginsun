/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CniMiscCodeVO.java
*@FileTitle : CniMiscCodeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.09
*@LastModifier : 박제성
*@LastVersion : 1.0
* 2009.11.09 박제성 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.cps.cni.codemgt.codemgt.vo;

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
 * @author 박제성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CniMiscCodeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CniMiscCodeVO> models = new ArrayList<CniMiscCodeVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String dpSeq = null;
	/* Column Info */
	private String clmMiscAbbrNm = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String clmMiscRmk = null;
	/* Column Info */
	private String oldClmMiscCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String clmMiscNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String clssClmMiscCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String clmMiscCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CniMiscCodeVO() {}

	public CniMiscCodeVO(String ibflag, String pagerows, String clssClmMiscCd, String clmMiscCd, String dpSeq, String clmMiscAbbrNm, String clmMiscNm, String oldClmMiscCd, String clmMiscRmk, String creOfcCd, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.dpSeq = dpSeq;
		this.clmMiscAbbrNm = clmMiscAbbrNm;
		this.creDt = creDt;
		this.clmMiscRmk = clmMiscRmk;
		this.oldClmMiscCd = oldClmMiscCd;
		this.pagerows = pagerows;
		this.clmMiscNm = clmMiscNm;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.creOfcCd = creOfcCd;
		this.clssClmMiscCd = clssClmMiscCd;
		this.updUsrId = updUsrId;
		this.clmMiscCd = clmMiscCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("dp_seq", getDpSeq());
		this.hashColumns.put("clm_misc_abbr_nm", getClmMiscAbbrNm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("clm_misc_rmk", getClmMiscRmk());
		this.hashColumns.put("old_clm_misc_cd", getOldClmMiscCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("clm_misc_nm", getClmMiscNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("clss_clm_misc_cd", getClssClmMiscCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("clm_misc_cd", getClmMiscCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("dp_seq", "dpSeq");
		this.hashFields.put("clm_misc_abbr_nm", "clmMiscAbbrNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("clm_misc_rmk", "clmMiscRmk");
		this.hashFields.put("old_clm_misc_cd", "oldClmMiscCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("clm_misc_nm", "clmMiscNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("clss_clm_misc_cd", "clssClmMiscCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("clm_misc_cd", "clmMiscCd");
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
	 * @return dpSeq
	 */
	public String getDpSeq() {
		return this.dpSeq;
	}
	
	/**
	 * Column Info
	 * @return clmMiscAbbrNm
	 */
	public String getClmMiscAbbrNm() {
		return this.clmMiscAbbrNm;
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
	 * @return clmMiscRmk
	 */
	public String getClmMiscRmk() {
		return this.clmMiscRmk;
	}
	
	/**
	 * Column Info
	 * @return oldClmMiscCd
	 */
	public String getOldClmMiscCd() {
		return this.oldClmMiscCd;
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
	 * @return clmMiscNm
	 */
	public String getClmMiscNm() {
		return this.clmMiscNm;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return clssClmMiscCd
	 */
	public String getClssClmMiscCd() {
		return this.clssClmMiscCd;
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
	 * @return clmMiscCd
	 */
	public String getClmMiscCd() {
		return this.clmMiscCd;
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
	 * @param dpSeq
	 */
	public void setDpSeq(String dpSeq) {
		this.dpSeq = dpSeq;
	}
	
	/**
	 * Column Info
	 * @param clmMiscAbbrNm
	 */
	public void setClmMiscAbbrNm(String clmMiscAbbrNm) {
		this.clmMiscAbbrNm = clmMiscAbbrNm;
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
	 * @param clmMiscRmk
	 */
	public void setClmMiscRmk(String clmMiscRmk) {
		this.clmMiscRmk = clmMiscRmk;
	}
	
	/**
	 * Column Info
	 * @param oldClmMiscCd
	 */
	public void setOldClmMiscCd(String oldClmMiscCd) {
		this.oldClmMiscCd = oldClmMiscCd;
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
	 * @param clmMiscNm
	 */
	public void setClmMiscNm(String clmMiscNm) {
		this.clmMiscNm = clmMiscNm;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param clssClmMiscCd
	 */
	public void setClssClmMiscCd(String clssClmMiscCd) {
		this.clssClmMiscCd = clssClmMiscCd;
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
	 * @param clmMiscCd
	 */
	public void setClmMiscCd(String clmMiscCd) {
		this.clmMiscCd = clmMiscCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setDpSeq(JSPUtil.getParameter(request, "dp_seq", ""));
		setClmMiscAbbrNm(JSPUtil.getParameter(request, "clm_misc_abbr_nm", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setClmMiscRmk(JSPUtil.getParameter(request, "clm_misc_rmk", ""));
		setOldClmMiscCd(JSPUtil.getParameter(request, "old_clm_misc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setClmMiscNm(JSPUtil.getParameter(request, "clm_misc_nm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setClssClmMiscCd(JSPUtil.getParameter(request, "clss_clm_misc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setClmMiscCd(JSPUtil.getParameter(request, "clm_misc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CniMiscCodeVO[]
	 */
	public CniMiscCodeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CniMiscCodeVO[]
	 */
	public CniMiscCodeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CniMiscCodeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] dpSeq = (JSPUtil.getParameter(request, prefix	+ "dp_seq", length));
			String[] clmMiscAbbrNm = (JSPUtil.getParameter(request, prefix	+ "clm_misc_abbr_nm", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] clmMiscRmk = (JSPUtil.getParameter(request, prefix	+ "clm_misc_rmk", length));
			String[] oldClmMiscCd = (JSPUtil.getParameter(request, prefix	+ "old_clm_misc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] clmMiscNm = (JSPUtil.getParameter(request, prefix	+ "clm_misc_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] clssClmMiscCd = (JSPUtil.getParameter(request, prefix	+ "clss_clm_misc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] clmMiscCd = (JSPUtil.getParameter(request, prefix	+ "clm_misc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CniMiscCodeVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (dpSeq[i] != null)
					model.setDpSeq(dpSeq[i]);
				if (clmMiscAbbrNm[i] != null)
					model.setClmMiscAbbrNm(clmMiscAbbrNm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (clmMiscRmk[i] != null)
					model.setClmMiscRmk(clmMiscRmk[i]);
				if (oldClmMiscCd[i] != null)
					model.setOldClmMiscCd(oldClmMiscCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (clmMiscNm[i] != null)
					model.setClmMiscNm(clmMiscNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (clssClmMiscCd[i] != null)
					model.setClssClmMiscCd(clssClmMiscCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (clmMiscCd[i] != null)
					model.setClmMiscCd(clmMiscCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCniMiscCodeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CniMiscCodeVO[]
	 */
	public CniMiscCodeVO[] getCniMiscCodeVOs(){
		CniMiscCodeVO[] vos = (CniMiscCodeVO[])models.toArray(new CniMiscCodeVO[models.size()]);
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
		this.dpSeq = this.dpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmMiscAbbrNm = this.clmMiscAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmMiscRmk = this.clmMiscRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldClmMiscCd = this.oldClmMiscCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmMiscNm = this.clmMiscNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clssClmMiscCd = this.clssClmMiscCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmMiscCd = this.clmMiscCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

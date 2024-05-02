/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : RevenuePortEachLaneVO.java
*@FileTitle : RevenuePortEachLaneVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.18
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.18  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RevenuePortEachLaneVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RevenuePortEachLaneVO> models = new ArrayList<RevenuePortEachLaneVO>();
	
	/* Column Info */
	private String dirCngCd = null;
	/* Column Info */
	private String fincRevDirCd = null;
	/* Column Info */
	private String hRevIptOcnCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String revPortCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String rlaneNm = null;
	/* Column Info */
	private String revIptOcnCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RevenuePortEachLaneVO() {}

	public RevenuePortEachLaneVO(String ibflag, String pagerows, String slanCd, String rlaneCd, String rlaneNm, String fincRevDirCd, String revIptOcnCd, String hRevIptOcnCd, String revPortCd, String dirCngCd, String deltFlg, String creUsrId, String updUsrId) {
		this.dirCngCd = dirCngCd;
		this.fincRevDirCd = fincRevDirCd;
		this.hRevIptOcnCd = hRevIptOcnCd;
		this.deltFlg = deltFlg;
		this.rlaneCd = rlaneCd;
		this.revPortCd = revPortCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.slanCd = slanCd;
		this.rlaneNm = rlaneNm;
		this.revIptOcnCd = revIptOcnCd;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dir_cng_cd", getDirCngCd());
		this.hashColumns.put("finc_rev_dir_cd", getFincRevDirCd());
		this.hashColumns.put("h_rev_ipt_ocn_cd", getHRevIptOcnCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("rev_port_cd", getRevPortCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("rlane_nm", getRlaneNm());
		this.hashColumns.put("rev_ipt_ocn_cd", getRevIptOcnCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dir_cng_cd", "dirCngCd");
		this.hashFields.put("finc_rev_dir_cd", "fincRevDirCd");
		this.hashFields.put("h_rev_ipt_ocn_cd", "hRevIptOcnCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("rev_port_cd", "revPortCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("rlane_nm", "rlaneNm");
		this.hashFields.put("rev_ipt_ocn_cd", "revIptOcnCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dirCngCd
	 */
	public String getDirCngCd() {
		return this.dirCngCd;
	}
	
	/**
	 * Column Info
	 * @return fincRevDirCd
	 */
	public String getFincRevDirCd() {
		return this.fincRevDirCd;
	}
	
	/**
	 * Column Info
	 * @return hRevIptOcnCd
	 */
	public String getHRevIptOcnCd() {
		return this.hRevIptOcnCd;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
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
	 * @return revPortCd
	 */
	public String getRevPortCd() {
		return this.revPortCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return rlaneNm
	 */
	public String getRlaneNm() {
		return this.rlaneNm;
	}
	
	/**
	 * Column Info
	 * @return revIptOcnCd
	 */
	public String getRevIptOcnCd() {
		return this.revIptOcnCd;
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
	 * @param dirCngCd
	 */
	public void setDirCngCd(String dirCngCd) {
		this.dirCngCd = dirCngCd;
	}
	
	/**
	 * Column Info
	 * @param fincRevDirCd
	 */
	public void setFincRevDirCd(String fincRevDirCd) {
		this.fincRevDirCd = fincRevDirCd;
	}
	
	/**
	 * Column Info
	 * @param hRevIptOcnCd
	 */
	public void setHRevIptOcnCd(String hRevIptOcnCd) {
		this.hRevIptOcnCd = hRevIptOcnCd;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
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
	 * @param revPortCd
	 */
	public void setRevPortCd(String revPortCd) {
		this.revPortCd = revPortCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param rlaneNm
	 */
	public void setRlaneNm(String rlaneNm) {
		this.rlaneNm = rlaneNm;
	}
	
	/**
	 * Column Info
	 * @param revIptOcnCd
	 */
	public void setRevIptOcnCd(String revIptOcnCd) {
		this.revIptOcnCd = revIptOcnCd;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setDirCngCd(JSPUtil.getParameter(request, prefix + "dir_cng_cd", ""));
		setFincRevDirCd(JSPUtil.getParameter(request, prefix + "finc_rev_dir_cd", ""));
		setHRevIptOcnCd(JSPUtil.getParameter(request, prefix + "h_rev_ipt_ocn_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setRevPortCd(JSPUtil.getParameter(request, prefix + "rev_port_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setRlaneNm(JSPUtil.getParameter(request, prefix + "rlane_nm", ""));
		setRevIptOcnCd(JSPUtil.getParameter(request, prefix + "rev_ipt_ocn_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RevenuePortEachLaneVO[]
	 */
	public RevenuePortEachLaneVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RevenuePortEachLaneVO[]
	 */
	public RevenuePortEachLaneVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RevenuePortEachLaneVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dirCngCd = (JSPUtil.getParameter(request, prefix	+ "dir_cng_cd", length));
			String[] fincRevDirCd = (JSPUtil.getParameter(request, prefix	+ "finc_rev_dir_cd", length));
			String[] hRevIptOcnCd = (JSPUtil.getParameter(request, prefix	+ "h_rev_ipt_ocn_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] revPortCd = (JSPUtil.getParameter(request, prefix	+ "rev_port_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] rlaneNm = (JSPUtil.getParameter(request, prefix	+ "rlane_nm", length));
			String[] revIptOcnCd = (JSPUtil.getParameter(request, prefix	+ "rev_ipt_ocn_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new RevenuePortEachLaneVO();
				if (dirCngCd[i] != null)
					model.setDirCngCd(dirCngCd[i]);
				if (fincRevDirCd[i] != null)
					model.setFincRevDirCd(fincRevDirCd[i]);
				if (hRevIptOcnCd[i] != null)
					model.setHRevIptOcnCd(hRevIptOcnCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (revPortCd[i] != null)
					model.setRevPortCd(revPortCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (rlaneNm[i] != null)
					model.setRlaneNm(rlaneNm[i]);
				if (revIptOcnCd[i] != null)
					model.setRevIptOcnCd(revIptOcnCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRevenuePortEachLaneVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RevenuePortEachLaneVO[]
	 */
	public RevenuePortEachLaneVO[] getRevenuePortEachLaneVOs(){
		RevenuePortEachLaneVO[] vos = (RevenuePortEachLaneVO[])models.toArray(new RevenuePortEachLaneVO[models.size()]);
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
		this.dirCngCd = this.dirCngCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fincRevDirCd = this.fincRevDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hRevIptOcnCd = this.hRevIptOcnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revPortCd = this.revPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneNm = this.rlaneNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revIptOcnCd = this.revIptOcnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

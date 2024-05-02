/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : LaneDirVO.java
*@FileTitle : LaneDirVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.11
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.03.23 진마리아 
* 1.0 Creation
* 
* History
* 2011.10.11 진마리아 CHM-201112822-01 Lane Code inquiry내 trade 및 Sub trade, SKD 로 lane Code 정보를 조회 가능하도록 로직 수정
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 진마리아
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class LaneDirVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<LaneDirVO> models = new ArrayList<LaneDirVO>();

	/* Column Info */
	private String dirCd1 = null;
	/* Column Info */
	private String vslSvcTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vslSlanNm = null;
	/* Column Info */
	private String dirCd2 = null;
	/* Column Info */
	private String vslTpCd = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String trdNm = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String subTrdNm = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String fdrDivCd = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String toDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public LaneDirVO() {}

	public LaneDirVO(String ibflag, String pagerows, String vslSlanCd, String vslSlanNm, String vslSvcTpCd, String vslTpCd, String dirCd1, String dirCd2, String trdCd, String trdNm, String subTrdCd, String subTrdNm, String rlaneCd, String fdrDivCd, String fmDt, String toDt) {
		this.dirCd1 = dirCd1;
		this.vslSvcTpCd = vslSvcTpCd;
		this.ibflag = ibflag;
		this.vslSlanNm = vslSlanNm;
		this.dirCd2 = dirCd2;
		this.vslTpCd = vslTpCd;
		this.vslSlanCd = vslSlanCd;
		this.pagerows = pagerows;
		this.trdCd = trdCd;
		this.trdNm = trdNm;
		this.subTrdCd = subTrdCd;
		this.subTrdNm = subTrdNm;
		this.rlaneCd = rlaneCd;
		this.fdrDivCd = fdrDivCd;
		this.fmDt = fmDt;
		this.toDt = toDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dir_cd1", getDirCd1());
		this.hashColumns.put("vsl_svc_tp_cd", getVslSvcTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_slan_nm", getVslSlanNm());
		this.hashColumns.put("dir_cd2", getDirCd2());
		this.hashColumns.put("vsl_tp_cd", getVslTpCd());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("trd_nm", getTrdNm());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("sub_trd_nm", getSubTrdNm());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("fdr_div_cd", getFdrDivCd());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("to_dt", getToDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dir_cd1", "dirCd1");
		this.hashFields.put("vsl_svc_tp_cd", "vslSvcTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_slan_nm", "vslSlanNm");
		this.hashFields.put("dir_cd2", "dirCd2");
		this.hashFields.put("vsl_tp_cd", "vslTpCd");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("trd_nm", "trdNm");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("sub_trd_nm", "subTrdNm");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("fdr_div_cd", "fdrDivCd");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("to_dt", "toDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dirCd1
	 */
	public String getDirCd1() {
		return this.dirCd1;
	}
	
	/**
	 * Column Info
	 * @return vslSvcTpCd
	 */
	public String getVslSvcTpCd() {
		return this.vslSvcTpCd;
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
	 * @return vslSlanNm
	 */
	public String getVslSlanNm() {
		return this.vslSlanNm;
	}
	
	/**
	 * Column Info
	 * @return dirCd2
	 */
	public String getDirCd2() {
		return this.dirCd2;
	}
	
	/**
	 * Column Info
	 * @return vslTpCd
	 */
	public String getVslTpCd() {
		return this.vslTpCd;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
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
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return trdNm
	 */
	public String getTrdNm() {
		return this.trdNm;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	
	/**
	 * Column Info
	 * @return subTrdNm
	 */
	public String getSubTrdNm() {
		return this.subTrdNm;
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
	 * @return fdrDivCd
	 */
	public String getFdrDivCd() {
		return this.fdrDivCd;
	}
	
	/**
	 * Column Info
	 * @return fmDt
	 */
	public String getFmDt() {
		return this.fmDt;
	}
	
	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	

	/**
	 * Column Info
	 * @param dirCd1
	 */
	public void setDirCd1(String dirCd1) {
		this.dirCd1 = dirCd1;
	}
	
	/**
	 * Column Info
	 * @param vslSvcTpCd
	 */
	public void setVslSvcTpCd(String vslSvcTpCd) {
		this.vslSvcTpCd = vslSvcTpCd;
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
	 * @param vslSlanNm
	 */
	public void setVslSlanNm(String vslSlanNm) {
		this.vslSlanNm = vslSlanNm;
	}
	
	/**
	 * Column Info
	 * @param dirCd2
	 */
	public void setDirCd2(String dirCd2) {
		this.dirCd2 = dirCd2;
	}
	
	/**
	 * Column Info
	 * @param vslTpCd
	 */
	public void setVslTpCd(String vslTpCd) {
		this.vslTpCd = vslTpCd;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
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
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param trdNm
	 */
	public void setTrdNm(String trdNm) {
		this.trdNm = trdNm;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * Column Info
	 * @param subTrdNm
	 */
	public void setSubTrdNm(String subTrdNm) {
		this.subTrdNm = subTrdNm;
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
	 * @param fdrDivCd
	 */
	public void setFdrDivCd(String fdrDivCd) {
		this.fdrDivCd = fdrDivCd;
	}
	
	/**
	 * Column Info
	 * @param fmDt
	 */
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}
	
	/**
	 * Column Info
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
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
		setDirCd1(JSPUtil.getParameter(request, prefix + "dir_cd1", ""));
		setVslSvcTpCd(JSPUtil.getParameter(request, prefix + "vsl_svc_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVslSlanNm(JSPUtil.getParameter(request, prefix + "vsl_slan_nm", ""));
		setDirCd2(JSPUtil.getParameter(request, prefix + "dir_cd2", ""));
		setVslTpCd(JSPUtil.getParameter(request, prefix + "vsl_tp_cd", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setTrdNm(JSPUtil.getParameter(request, prefix + "trd_nm", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setSubTrdNm(JSPUtil.getParameter(request, prefix + "sub_trd_nm", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setFdrDivCd(JSPUtil.getParameter(request, prefix + "fdr_div_cd", ""));
		setFmDt(JSPUtil.getParameter(request, prefix + "fm_dt", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return LaneDirVO[]
	 */
	public LaneDirVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return LaneDirVO[]
	 */
	public LaneDirVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		LaneDirVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dirCd1 = (JSPUtil.getParameter(request, prefix	+ "dir_cd1", length));
			String[] vslSvcTpCd = (JSPUtil.getParameter(request, prefix	+ "vsl_svc_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vslSlanNm = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_nm", length));
			String[] dirCd2 = (JSPUtil.getParameter(request, prefix	+ "dir_cd2", length));
			String[] vslTpCd = (JSPUtil.getParameter(request, prefix	+ "vsl_tp_cd", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] trdNm = (JSPUtil.getParameter(request, prefix	+ "trd_nm", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] subTrdNm = (JSPUtil.getParameter(request, prefix	+ "sub_trd_nm", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] fdrDivCd = (JSPUtil.getParameter(request, prefix	+ "fdr_div_cd", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new LaneDirVO();
				if (dirCd1[i] != null)
					model.setDirCd1(dirCd1[i]);
				if (vslSvcTpCd[i] != null)
					model.setVslSvcTpCd(vslSvcTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslSlanNm[i] != null)
					model.setVslSlanNm(vslSlanNm[i]);
				if (dirCd2[i] != null)
					model.setDirCd2(dirCd2[i]);
				if (vslTpCd[i] != null)
					model.setVslTpCd(vslTpCd[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (trdNm[i] != null)
					model.setTrdNm(trdNm[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (subTrdNm[i] != null)
					model.setSubTrdNm(subTrdNm[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (fdrDivCd[i] != null)
					model.setFdrDivCd(fdrDivCd[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getLaneDirVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return LaneDirVO[]
	 */
	public LaneDirVO[] getLaneDirVOs(){
		LaneDirVO[] vos = (LaneDirVO[])models.toArray(new LaneDirVO[models.size()]);
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
		this.dirCd1 = this.dirCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSvcTpCd = this.vslSvcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanNm = this.vslSlanNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd2 = this.dirCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslTpCd = this.vslTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdNm = this.trdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdNm = this.subTrdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrDivCd = this.fdrDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

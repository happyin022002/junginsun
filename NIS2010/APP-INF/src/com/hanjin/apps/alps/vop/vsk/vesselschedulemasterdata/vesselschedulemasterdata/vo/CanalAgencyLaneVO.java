/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CanalAgencyLaneVO.java
*@FileTitle : CanalAgencyLaneVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.21
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2010.03.21 정진우 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo;

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
 * @author 정진우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CanalAgencyLaneVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CanalAgencyLaneVO> models = new ArrayList<CanalAgencyLaneVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String northDir = null;
	/* Column Info */
	private String southDir = null;
	/* Column Info */
	private String cnlAgnVndrSeq = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String vslSlanDirSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vslSlanNm = null;
	/* Column Info */
	private String svcScpBndCd = null;
	/* Column Info */
	private String vslSlanDirCd = null;
	/* Column Info */
	private String bound1 = null;
	/* Column Info */
	private String bound2 = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String creUsrId = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CanalAgencyLaneVO() {}

	public CanalAgencyLaneVO(String ibflag, String pagerows, String vslSlanCd, String vslSlanNm, String cnlAgnVndrSeq, String northDir, String southDir, String bound1, String bound2, String updUsrId, String updDt, String vslSlanDirCd, String vslSlanDirSeq, String svcScpBndCd, String vndrSeq, String creDt, String creUsrId) {
		this.updDt = updDt;
		this.northDir = northDir;
		this.southDir = southDir;
		this.cnlAgnVndrSeq = cnlAgnVndrSeq;
		this.vslSlanCd = vslSlanCd;
		this.vslSlanDirSeq = vslSlanDirSeq;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.vslSlanNm = vslSlanNm;
		this.svcScpBndCd = svcScpBndCd;
		this.vslSlanDirCd = vslSlanDirCd;
		this.bound1 = bound1;
		this.bound2 = bound2;
		this.updUsrId = updUsrId;
		this.vndrSeq = vndrSeq;
		this.creDt = creDt;
		this.creUsrId = creUsrId;

	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("north_dir", getNorthDir());
		this.hashColumns.put("south_dir", getSouthDir());
		this.hashColumns.put("cnl_agn_vndr_seq", getCnlAgnVndrSeq());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("vsl_slan_dir_seq", getVslSlanDirSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_slan_nm", getVslSlanNm());
		this.hashColumns.put("svc_scp_bnd_cd", getSvcScpBndCd());
		this.hashColumns.put("vsl_slan_dir_cd", getVslSlanDirCd());
		this.hashColumns.put("bound1", getBound1());
		this.hashColumns.put("bound2", getBound2());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("north_dir", "northDir");
		this.hashFields.put("south_dir", "southDir");
		this.hashFields.put("cnl_agn_vndr_seq", "cnlAgnVndrSeq");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("vsl_slan_dir_seq", "vslSlanDirSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_slan_nm", "vslSlanNm");
		this.hashFields.put("svc_scp_bnd_cd", "svcScpBndCd");
		this.hashFields.put("vsl_slan_dir_cd", "vslSlanDirCd");
		this.hashFields.put("bound1", "bound1");
		this.hashFields.put("bound2", "bound2");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		
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
	 * @return northDir
	 */
	public String getNorthDir() {
		return this.northDir;
	}
	
	/**
	 * Column Info
	 * @return southDir
	 */
	public String getSouthDir() {
		return this.southDir;
	}
	
	/**
	 * Column Info
	 * @return cnlAgnVndrSeq
	 */
	public String getCnlAgnVndrSeq() {
		return this.cnlAgnVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return vslSlanDirSeq
	 */
	public String getVslSlanDirSeq() {
		return this.vslSlanDirSeq;
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
	 * @return vslSlanNm
	 */
	public String getVslSlanNm() {
		return this.vslSlanNm;
	}
	
	/**
	 * Column Info
	 * @return svcScpBndCd
	 */
	public String getSvcScpBndCd() {
		return this.svcScpBndCd;
	}
	
	/**
	 * Column Info
	 * @return vslSlanDirCd
	 */
	public String getVslSlanDirCd() {
		return this.vslSlanDirCd;
	}
	
	/**
	 * Column Info
	 * @return bound1
	 */
	public String getBound1() {
		return this.bound1;
	}
	
	/**
	 * Column Info
	 * @return bound2
	 */
	public String getBound2() {
		return this.bound2;
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
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @param northDir
	 */
	public void setNorthDir(String northDir) {
		this.northDir = northDir;
	}
	
	/**
	 * Column Info
	 * @param southDir
	 */
	public void setSouthDir(String southDir) {
		this.southDir = southDir;
	}
	
	/**
	 * Column Info
	 * @param cnlAgnVndrSeq
	 */
	public void setCnlAgnVndrSeq(String cnlAgnVndrSeq) {
		this.cnlAgnVndrSeq = cnlAgnVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param vslSlanDirSeq
	 */
	public void setVslSlanDirSeq(String vslSlanDirSeq) {
		this.vslSlanDirSeq = vslSlanDirSeq;
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
	 * @param vslSlanNm
	 */
	public void setVslSlanNm(String vslSlanNm) {
		this.vslSlanNm = vslSlanNm;
	}
	
	/**
	 * Column Info
	 * @param svcScpBndCd
	 */
	public void setSvcScpBndCd(String svcScpBndCd) {
		this.svcScpBndCd = svcScpBndCd;
	}
	
	/**
	 * Column Info
	 * @param vslSlanDirCd
	 */
	public void setVslSlanDirCd(String vslSlanDirCd) {
		this.vslSlanDirCd = vslSlanDirCd;
	}
	
	/**
	 * Column Info
	 * @param bound1
	 */
	public void setBound1(String bound1) {
		this.bound1 = bound1;
	}
	
	/**
	 * Column Info
	 * @param bound2
	 */
	public void setBound2(String bound2) {
		this.bound2 = bound2;
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
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setNorthDir(JSPUtil.getParameter(request, "north_dir", ""));
		setSouthDir(JSPUtil.getParameter(request, "south_dir", ""));
		setCnlAgnVndrSeq(JSPUtil.getParameter(request, "cnl_agn_vndr_seq", ""));
		setVslSlanCd(JSPUtil.getParameter(request, "vsl_slan_cd", ""));
		setVslSlanDirSeq(JSPUtil.getParameter(request, "vsl_slan_dir_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVslSlanNm(JSPUtil.getParameter(request, "vsl_slan_nm", ""));
		setSvcScpBndCd(JSPUtil.getParameter(request, "svc_scp_bnd_cd", ""));
		setVslSlanDirCd(JSPUtil.getParameter(request, "vsl_slan_dir_cd", ""));
		setBound1(JSPUtil.getParameter(request, "bound1", ""));
		setBound2(JSPUtil.getParameter(request, "bound2", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CanalAgencyLaneVO[]
	 */
	public CanalAgencyLaneVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CanalAgencyLaneVO[]
	 */
	public CanalAgencyLaneVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CanalAgencyLaneVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] northDir = (JSPUtil.getParameter(request, prefix	+ "north_dir", length));
			String[] southDir = (JSPUtil.getParameter(request, prefix	+ "south_dir", length));
			String[] cnlAgnVndrSeq = (JSPUtil.getParameter(request, prefix	+ "cnl_agn_vndr_seq", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] vslSlanDirSeq = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_dir_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vslSlanNm = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_nm", length));
			String[] svcScpBndCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_bnd_cd", length));
			String[] vslSlanDirCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_dir_cd", length));
			String[] bound1 = (JSPUtil.getParameter(request, prefix	+ "bound1", length));
			String[] bound2 = (JSPUtil.getParameter(request, prefix	+ "bound2", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));


			
			for (int i = 0; i < length; i++) {
				model = new CanalAgencyLaneVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (northDir[i] != null)
					model.setNorthDir(northDir[i]);
				if (southDir[i] != null)
					model.setSouthDir(southDir[i]);
				if (cnlAgnVndrSeq[i] != null)
					model.setCnlAgnVndrSeq(cnlAgnVndrSeq[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (vslSlanDirSeq[i] != null)
					model.setVslSlanDirSeq(vslSlanDirSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslSlanNm[i] != null)
					model.setVslSlanNm(vslSlanNm[i]);
				if (svcScpBndCd[i] != null)
					model.setSvcScpBndCd(svcScpBndCd[i]);
				if (vslSlanDirCd[i] != null)
					model.setVslSlanDirCd(vslSlanDirCd[i]);
				if (bound1[i] != null)
					model.setBound1(bound1[i]);
				if (bound2[i] != null)
					model.setBound2(bound2[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCanalAgencyLaneVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CanalAgencyLaneVO[]
	 */
	public CanalAgencyLaneVO[] getCanalAgencyLaneVOs(){
		CanalAgencyLaneVO[] vos = (CanalAgencyLaneVO[])models.toArray(new CanalAgencyLaneVO[models.size()]);
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
		this.northDir = this.northDir .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.southDir = this.southDir .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnlAgnVndrSeq = this.cnlAgnVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanDirSeq = this.vslSlanDirSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanNm = this.vslSlanNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpBndCd = this.svcScpBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanDirCd = this.vslSlanDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bound1 = this.bound1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bound2 = this.bound2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}
}

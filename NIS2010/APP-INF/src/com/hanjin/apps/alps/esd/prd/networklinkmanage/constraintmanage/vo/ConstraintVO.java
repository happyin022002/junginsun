/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ConstraintVO.java
*@FileTitle : ConstraintVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.27
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2012.02.27 박만건 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.vo;

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
 * @author 박만건
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ConstraintVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ConstraintVO> models = new ArrayList<ConstraintVO>();
	
	/* Column Info */
	private String svc = null;
	/* Column Info */
	private String select1 = null;
	/* Column Info */
	private String loc = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String tlane = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String fromNd = null;
	/* Column Info */
	private String pointCode = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String tsport = null;
	/* Column Info */
	private String toNd = null;
	/* Column Info */
	private String linkFlg = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String del = null;
	/* Column Info */
	private String pod = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ConstraintVO() {}

	public ConstraintVO(String ibflag, String pagerows, String svc, String select1, String loc, String tlane, String fromNd, String tsport, String toNd, String linkFlg, String pol, String dirCd, String del, String pod, String pointCode, String cmdtCd, String cmdtNm, String vslSlanCd, String vvd) {
		this.svc = svc;
		this.select1 = select1;
		this.loc = loc;
		this.vslSlanCd = vslSlanCd;
		this.tlane = tlane;
		this.cmdtNm = cmdtNm;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.fromNd = fromNd;
		this.pointCode = pointCode;
		this.ibflag = ibflag;
		this.cmdtCd = cmdtCd;
		this.tsport = tsport;
		this.toNd = toNd;
		this.linkFlg = linkFlg;
		this.pol = pol;
		this.dirCd = dirCd;
		this.del = del;
		this.pod = pod;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("svc", getSvc());
		this.hashColumns.put("select1", getSelect1());
		this.hashColumns.put("loc", getLoc());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("tlane", getTlane());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("from_nd", getFromNd());
		this.hashColumns.put("point_code", getPointCode());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("tsport", getTsport());
		this.hashColumns.put("to_nd", getToNd());
		this.hashColumns.put("link_flg", getLinkFlg());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("del", getDel());
		this.hashColumns.put("pod", getPod());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("svc", "svc");
		this.hashFields.put("select1", "select1");
		this.hashFields.put("loc", "loc");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("tlane", "tlane");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("from_nd", "fromNd");
		this.hashFields.put("point_code", "pointCode");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("tsport", "tsport");
		this.hashFields.put("to_nd", "toNd");
		this.hashFields.put("link_flg", "linkFlg");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("del", "del");
		this.hashFields.put("pod", "pod");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return svc
	 */
	public String getSvc() {
		return this.svc;
	}
	
	/**
	 * Column Info
	 * @return select1
	 */
	public String getSelect1() {
		return this.select1;
	}
	
	/**
	 * Column Info
	 * @return loc
	 */
	public String getLoc() {
		return this.loc;
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
	 * @return tlane
	 */
	public String getTlane() {
		return this.tlane;
	}
	
	/**
	 * Column Info
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return fromNd
	 */
	public String getFromNd() {
		return this.fromNd;
	}
	
	/**
	 * Column Info
	 * @return pointCode
	 */
	public String getPointCode() {
		return this.pointCode;
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
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}
	
	/**
	 * Column Info
	 * @return tsport
	 */
	public String getTsport() {
		return this.tsport;
	}
	
	/**
	 * Column Info
	 * @return toNd
	 */
	public String getToNd() {
		return this.toNd;
	}
	
	/**
	 * Column Info
	 * @return linkFlg
	 */
	public String getLinkFlg() {
		return this.linkFlg;
	}
	
	/**
	 * Column Info
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
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
	 * @return del
	 */
	public String getDel() {
		return this.del;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}
	

	/**
	 * Column Info
	 * @param svc
	 */
	public void setSvc(String svc) {
		this.svc = svc;
	}
	
	/**
	 * Column Info
	 * @param select1
	 */
	public void setSelect1(String select1) {
		this.select1 = select1;
	}
	
	/**
	 * Column Info
	 * @param loc
	 */
	public void setLoc(String loc) {
		this.loc = loc;
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
	 * @param tlane
	 */
	public void setTlane(String tlane) {
		this.tlane = tlane;
	}
	
	/**
	 * Column Info
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param fromNd
	 */
	public void setFromNd(String fromNd) {
		this.fromNd = fromNd;
	}
	
	/**
	 * Column Info
	 * @param pointCode
	 */
	public void setPointCode(String pointCode) {
		this.pointCode = pointCode;
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
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}
	
	/**
	 * Column Info
	 * @param tsport
	 */
	public void setTsport(String tsport) {
		this.tsport = tsport;
	}
	
	/**
	 * Column Info
	 * @param toNd
	 */
	public void setToNd(String toNd) {
		this.toNd = toNd;
	}
	
	/**
	 * Column Info
	 * @param linkFlg
	 */
	public void setLinkFlg(String linkFlg) {
		this.linkFlg = linkFlg;
	}
	
	/**
	 * Column Info
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param del
	 */
	public void setDel(String del) {
		this.del = del;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
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
		setSvc(JSPUtil.getParameter(request, prefix + "svc", ""));
		setSelect1(JSPUtil.getParameter(request, prefix + "select1", ""));
		setLoc(JSPUtil.getParameter(request, prefix + "loc", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setTlane(JSPUtil.getParameter(request, prefix + "tlane", ""));
		setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setFromNd(JSPUtil.getParameter(request, prefix + "from_nd", ""));
		setPointCode(JSPUtil.getParameter(request, prefix + "point_code", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setTsport(JSPUtil.getParameter(request, prefix + "tsport", ""));
		setToNd(JSPUtil.getParameter(request, prefix + "to_nd", ""));
		setLinkFlg(JSPUtil.getParameter(request, prefix + "link_flg", ""));
		setPol(JSPUtil.getParameter(request, prefix + "pol", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setDel(JSPUtil.getParameter(request, prefix + "del", ""));
		setPod(JSPUtil.getParameter(request, prefix + "pod", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ConstraintVO[]
	 */
	public ConstraintVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ConstraintVO[]
	 */
	public ConstraintVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ConstraintVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] svc = (JSPUtil.getParameter(request, prefix	+ "svc", length));
			String[] select1 = (JSPUtil.getParameter(request, prefix	+ "select1", length));
			String[] loc = (JSPUtil.getParameter(request, prefix	+ "loc", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] tlane = (JSPUtil.getParameter(request, prefix	+ "tlane", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] fromNd = (JSPUtil.getParameter(request, prefix	+ "from_nd", length));
			String[] pointCode = (JSPUtil.getParameter(request, prefix	+ "point_code", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] tsport = (JSPUtil.getParameter(request, prefix	+ "tsport", length));
			String[] toNd = (JSPUtil.getParameter(request, prefix	+ "to_nd", length));
			String[] linkFlg = (JSPUtil.getParameter(request, prefix	+ "link_flg", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] del = (JSPUtil.getParameter(request, prefix	+ "del", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			
			for (int i = 0; i < length; i++) {
				model = new ConstraintVO();
				if (svc[i] != null)
					model.setSvc(svc[i]);
				if (select1[i] != null)
					model.setSelect1(select1[i]);
				if (loc[i] != null)
					model.setLoc(loc[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (tlane[i] != null)
					model.setTlane(tlane[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (fromNd[i] != null)
					model.setFromNd(fromNd[i]);
				if (pointCode[i] != null)
					model.setPointCode(pointCode[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (tsport[i] != null)
					model.setTsport(tsport[i]);
				if (toNd[i] != null)
					model.setToNd(toNd[i]);
				if (linkFlg[i] != null)
					model.setLinkFlg(linkFlg[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (del[i] != null)
					model.setDel(del[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getConstraintVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ConstraintVO[]
	 */
	public ConstraintVO[] getConstraintVOs(){
		ConstraintVO[] vos = (ConstraintVO[])models.toArray(new ConstraintVO[models.size()]);
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
		this.svc = this.svc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.select1 = this.select1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loc = this.loc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tlane = this.tlane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromNd = this.fromNd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pointCode = this.pointCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsport = this.tsport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toNd = this.toNd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.linkFlg = this.linkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.del = this.del .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

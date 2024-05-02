/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ConstraintVO.java
 *@FileTitle : ConstraintVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.18
 *@LastModifier : 김귀진
 *@LastVersion : 1.0
 * 2009.08.18 김귀진 
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 * 
 * @author 김귀진
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
	private String tlane = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fromNd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tsport = null;
	/* Column Info */
	private String toNd = null;
	/* Column Info */
	private String linkFlg = null;
	/* Column Info */
	private String por = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String del = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String pointCode = null;
	/* Column Info */
	private String hportCd = null;
	/* Column Info */
	private String hhubLocCd = null;
	/* Column Info */
	private String hnodCd = null;
	/* Column Info */
	private String cntrTpCd = null;
	/* Column Info */
	private String cntrSzCd = null;

	private String pGubun = null;

	/* Column Info */

	public String getPointCode() {
		return pointCode;
	}

	public void setPointCode(String pointCode) {
		this.pointCode = pointCode;
	}

	/* 테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/* 테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public ConstraintVO() {
	}

	public ConstraintVO(String ibflag, String pagerows, String loc, String fromNd, String toNd, String tlane, String dirCd, String por, String pol, String tsport, String pod, String del, String linkFlg, String svc, String select1, String pointCode, String hportCd, String hhubLocCd, String hnodCd,
			String cntrTpCd, String cntrSzCd) {
		this.svc = svc;
		this.select1 = select1;
		this.loc = loc;
		this.tlane = tlane;
		this.pagerows = pagerows;
		this.fromNd = fromNd;
		this.ibflag = ibflag;
		this.tsport = tsport;
		this.toNd = toNd;
		this.linkFlg = linkFlg;
		this.por = por;
		this.pol = pol;
		this.dirCd = dirCd;
		this.del = del;
		this.pod = pod;
		this.pointCode = pointCode;
		this.hportCd = hportCd;
		this.hhubLocCd = hhubLocCd;
		this.hnodCd = hnodCd;
		this.cntrTpCd = cntrTpCd;
		this.cntrSzCd = cntrSzCd;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * 
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues() {
		this.hashColumns.put("svc", getSvc());
		this.hashColumns.put("select1", getSelect1());
		this.hashColumns.put("loc", getLoc());
		this.hashColumns.put("tlane", getTlane());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("from_nd", getFromNd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tsport", getTsport());
		this.hashColumns.put("to_nd", getToNd());
		this.hashColumns.put("link_flg", getLinkFlg());
		this.hashColumns.put("por", getPor());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("del", getDel());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("point_code", getPointCode());
		this.hashColumns.put("hport_cd", getHportCd());
		this.hashColumns.put("hhub_loc_cd", getHhubLocCd());
		this.hashColumns.put("hnod_cd", getHnodCd());
		this.hashColumns.put("cntr_tp_cd", getCntrTpCd());
		this.hashColumns.put("cntr_sz_cd", getCntrSzCd());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * 
	 * @return
	 */
	public HashMap<String, String> getFieldNames() {
		this.hashFields.put("svc", "svc");
		this.hashFields.put("select1", "select1");
		this.hashFields.put("loc", "loc");
		this.hashFields.put("tlane", "tlane");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("from_nd", "fromNd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tsport", "tsport");
		this.hashFields.put("to_nd", "toNd");
		this.hashFields.put("link_flg", "linkFlg");
		this.hashFields.put("por", "por");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("del", "del");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("point_code", "pointCode");
		this.hashFields.put("hport_cd", "hportCd");
		this.hashFields.put("hhub_loc_cd", "hhubLocCd");
		this.hashFields.put("hnod_cd", "hnodCd");
		this.hashFields.put("cntr_tp_cd", "cntrTpCd");
		this.hashFields.put("cntr_sz_cd", "cntrSzCd");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * 
	 * @return svc
	 */
	public String getSvc() {
		return this.svc;
	}

	/**
	 * Column Info
	 * 
	 * @return select1
	 */
	public String getSelect1() {
		return this.select1;
	}

	/**
	 * Column Info
	 * 
	 * @return loc
	 */
	public String getLoc() {
		return this.loc;
	}

	/**
	 * Column Info
	 * 
	 * @return tlane
	 */
	public String getTlane() {
		return this.tlane;
	}

	/**
	 * Page Number
	 * 
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}

	/**
	 * Column Info
	 * 
	 * @return fromNd
	 */
	public String getFromNd() {
		return this.fromNd;
	}

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * 
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}

	/**
	 * Column Info
	 * 
	 * @return tsport
	 */
	public String getTsport() {
		return this.tsport;
	}

	/**
	 * Column Info
	 * 
	 * @return toNd
	 */
	public String getToNd() {
		return this.toNd;
	}

	/**
	 * Column Info
	 * 
	 * @return linkFlg
	 */
	public String getLinkFlg() {
		return this.linkFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return por
	 */
	public String getPor() {
		return this.por;
	}

	/**
	 * Column Info
	 * 
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
	}

	/**
	 * Column Info
	 * 
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}

	/**
	 * Column Info
	 * 
	 * @return del
	 */
	public String getDel() {
		return this.del;
	}

	/**
	 * Column Info
	 * 
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}

	/**
	 * Column Info
	 * 
	 * @param svc
	 */
	public void setSvc(String svc) {
		this.svc = svc;
	}

	/**
	 * Column Info
	 * 
	 * @param select1
	 */
	public void setSelect1(String select1) {
		this.select1 = select1;
	}

	/**
	 * Column Info
	 * 
	 * @param loc
	 */
	public void setLoc(String loc) {
		this.loc = loc;
	}

	/**
	 * Column Info
	 * 
	 * @param tlane
	 */
	public void setTlane(String tlane) {
		this.tlane = tlane;
	}

	/**
	 * Page Number
	 * 
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	/**
	 * Column Info
	 * 
	 * @param fromNd
	 */
	public void setFromNd(String fromNd) {
		this.fromNd = fromNd;
	}

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * 
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	/**
	 * Column Info
	 * 
	 * @param tsport
	 */
	public void setTsport(String tsport) {
		this.tsport = tsport;
	}

	/**
	 * Column Info
	 * 
	 * @param toNd
	 */
	public void setToNd(String toNd) {
		this.toNd = toNd;
	}

	/**
	 * Column Info
	 * 
	 * @param linkFlg
	 */
	public void setLinkFlg(String linkFlg) {
		this.linkFlg = linkFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param por
	 */
	public void setPor(String por) {
		this.por = por;
	}

	/**
	 * Column Info
	 * 
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}

	/**
	 * Column Info
	 * 
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}

	/**
	 * Column Info
	 * 
	 * @param del
	 */
	public void setDel(String del) {
		this.del = del;
	}

	/**
	 * Column Info
	 * 
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}

	/**
	 * 
	 * @return
	 */
	public String getHportCd() {
		return hportCd;
	}

	/**
	 * Column Info
	 * 
	 * @param hportCd
	 */
	public void setHportCd(String hportCd) {
		this.hportCd = hportCd;
	}

	/**
	 * 
	 * @return
	 */
	public String getHhubLocCd() {
		return hhubLocCd;
	}

	/**
	 * Column Info
	 * 
	 * @param hhubLocCd
	 */
	public void setHhubLocCd(String hhubLocCd) {
		this.hhubLocCd = hhubLocCd;
	}

	/**
	 * 
	 * @return
	 */
	public String getHnodCd() {
		return hnodCd;
	}

	/**
	 * 
	 * @param hnodCd
	 */
	public void setHnodCd(String hnodCd) {
		this.hnodCd = hnodCd;
	}

	public String getCntrTpCd() {
		return cntrTpCd;
	}

	public void setCntrTpCd(String cntrTpCd) {
		this.cntrTpCd = cntrTpCd;
	}

	public String getCntrSzCd() {
		return cntrSzCd;
	}

	public void setCntrSzCd(String cntrSzCd) {
		this.cntrSzCd = cntrSzCd;
	}

	public String getpGubun() {
		return pGubun;
	}

	public void setpGubun(String pGubun) {
		this.pGubun = pGubun;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSvc(JSPUtil.getParameter(request, "svc", ""));
		setSelect1(JSPUtil.getParameter(request, "select1", ""));
		setLoc(JSPUtil.getParameter(request, "loc", ""));
		setTlane(JSPUtil.getParameter(request, "tlane", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFromNd(JSPUtil.getParameter(request, "from_nd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTsport(JSPUtil.getParameter(request, "tsport", ""));
		setToNd(JSPUtil.getParameter(request, "to_nd", ""));
		setLinkFlg(JSPUtil.getParameter(request, "link_flg", ""));
		setPor(JSPUtil.getParameter(request, "por", ""));
		setPol(JSPUtil.getParameter(request, "pol", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setDel(JSPUtil.getParameter(request, "del", ""));
		setPod(JSPUtil.getParameter(request, "pod", ""));
		setPointCode(JSPUtil.getParameter(request, "point_code", ""));
		setHportCd(JSPUtil.getParameter(request, "hport_cd", ""));
		setHhubLocCd(JSPUtil.getParameter(request, "hhub_loc_cd", ""));
		setHnodCd(JSPUtil.getParameter(request, "hnod_cd", ""));
		setCntrTpCd(JSPUtil.getParameter(request, "cntr_tp_cd", ""));
		setCntrSzCd(JSPUtil.getParameter(request, "cntr_sz_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * 
	 * @param request
	 * @return ConstraintVO[]
	 */
	public ConstraintVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * 
	 * @param request
	 * @param prefix
	 * @return ConstraintVO[]
	 */
	public ConstraintVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ConstraintVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] svc = (JSPUtil.getParameter(request, prefix + "svc", length));
			String[] select1 = (JSPUtil.getParameter(request, prefix + "select1", length));
			String[] loc = (JSPUtil.getParameter(request, prefix + "loc", length));
			String[] tlane = (JSPUtil.getParameter(request, prefix + "tlane", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
			String[] fromNd = (JSPUtil.getParameter(request, prefix + "from_nd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
			String[] tsport = (JSPUtil.getParameter(request, prefix + "tsport", length));
			String[] toNd = (JSPUtil.getParameter(request, prefix + "to_nd", length));
			String[] linkFlg = (JSPUtil.getParameter(request, prefix + "link_flg", length));
			String[] por = (JSPUtil.getParameter(request, prefix + "por", length));
			String[] pol = (JSPUtil.getParameter(request, prefix + "pol", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix + "dir_cd", length));
			String[] del = (JSPUtil.getParameter(request, prefix + "del", length));
			String[] pod = (JSPUtil.getParameter(request, prefix + "pod", length));
			String[] pointCode = (JSPUtil.getParameter(request, prefix + "point_code", length));
			String[] hportCd = (JSPUtil.getParameter(request, prefix + "hport_cd", length));
			String[] hhubLocCd = (JSPUtil.getParameter(request, prefix + "hhub_loc_cd", length));
			String[] hnodCd = (JSPUtil.getParameter(request, prefix + "hnod_cd", length));
			String[] cntrTpCd = (JSPUtil.getParameter(request, prefix + "cntr_tp_cd", length));
			String[] cntrSzCd = (JSPUtil.getParameter(request, prefix + "cntr_sz_cd", length));

			for (int i = 0; i < length; i++) {
				model = new ConstraintVO();
				if (svc[i] != null)
					model.setSvc(svc[i]);
				if (select1[i] != null)
					model.setSelect1(select1[i]);
				if (loc[i] != null)
					model.setLoc(loc[i]);
				if (tlane[i] != null)
					model.setTlane(tlane[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fromNd[i] != null)
					model.setFromNd(fromNd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tsport[i] != null)
					model.setTsport(tsport[i]);
				if (toNd[i] != null)
					model.setToNd(toNd[i]);
				if (linkFlg[i] != null)
					model.setLinkFlg(linkFlg[i]);
				if (por[i] != null)
					model.setPor(por[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (del[i] != null)
					model.setDel(del[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (pointCode[i] != null)
					model.setPointCode(pointCode[i]);
				if (hportCd[i] != null)
					model.setHportCd(hportCd[i]);
				if (hhubLocCd[i] != null)
					model.setHhubLocCd(hhubLocCd[i]);
				if (hnodCd[i] != null)
					model.setHnodCd(hnodCd[i]);
				if (cntrTpCd[i] != null)
					model.setCntrTpCd(cntrTpCd[i]);
				if (cntrSzCd[i] != null)
					model.setCntrSzCd(cntrSzCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getConstraintVOs();
	}

	/**
	 * VO 배열을 반환
	 * 
	 * @return ConstraintVO[]
	 */
	public ConstraintVO[] getConstraintVOs() {
		ConstraintVO[] vos = (ConstraintVO[]) models.toArray(new ConstraintVO[models.size()]);
		return vos;
	}

	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try {
			for (int i = 0; i < field.length; i++) {
				String[] arr = null;
				arr = getField(field, i);
				if (arr != null) {
					for (int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}

	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * 
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try {
			arr = (String[]) field[i].get(this);
		} catch (Exception ex) {
			arr = null;
		}
		return arr;
	}

	/**
	 * 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	 */
	public void unDataFormat() {
		this.svc = this.svc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.select1 = this.select1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loc = this.loc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tlane = this.tlane.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromNd = this.fromNd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsport = this.tsport.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toNd = this.toNd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.linkFlg = this.linkFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.por = this.por.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.del = this.del.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pointCode = this.pointCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hportCd = this.hportCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hhubLocCd = this.hhubLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hnodCd = this.hnodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpCd = this.cntrTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSzCd = this.cntrSzCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

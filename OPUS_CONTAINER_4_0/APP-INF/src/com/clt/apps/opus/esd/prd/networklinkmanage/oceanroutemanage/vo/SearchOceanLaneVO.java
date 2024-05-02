/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SearchOceanLaneVO.java
 *@FileTitle : SearchOceanLaneVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.31
 *@LastModifier : 김귀진
 *@LastVersion : 1.0
 * 2009.08.31 김귀진 
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.vo;

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

public class SearchOceanLaneVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<SearchOceanLaneVO> models = new ArrayList<SearchOceanLaneVO>();

	/* Column Info */
	private String polx = null;
	/* Column Info */
	private String svcTpx = null;
	/* Column Info */
	private String oriLoc = null;
	/* Column Info */
	private String podx = null;
	/* Column Info */
	private String polxetb = null;
	/* Column Info */
	private String destLoc = null;
	/* Column Info */
	private String lane = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String dirx = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String podxetb = null;
	/* Column Info */
	private String lanex = null;
	/* Column Info */
	private String ttx = null;
	/* Column Info */
	private String fdrFlgx = null;
	/* Column Info */
	private String dir = null;

	/* 테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/* 테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public SearchOceanLaneVO() {
	}

	public SearchOceanLaneVO(String ibflag, String pagerows, String polx, String podx, String lanex, String dirx, String fdrFlgx, String svcTpx, String ttx, String polxetb, String podxetb, String oriLoc, String destLoc, String lane, String dir) {
		this.polx = polx;
		this.svcTpx = svcTpx;
		this.oriLoc = oriLoc;
		this.podx = podx;
		this.polxetb = polxetb;
		this.destLoc = destLoc;
		this.lane = lane;
		this.pagerows = pagerows;
		this.dirx = dirx;
		this.ibflag = ibflag;
		this.podxetb = podxetb;
		this.lanex = lanex;
		this.ttx = ttx;
		this.fdrFlgx = fdrFlgx;
		this.dir = dir;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * 
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues() {
		this.hashColumns.put("polx", getPolx());
		this.hashColumns.put("svc_tpx", getSvcTpx());
		this.hashColumns.put("ori_loc", getOriLoc());
		this.hashColumns.put("podx", getPodx());
		this.hashColumns.put("polxetb", getPolxetb());
		this.hashColumns.put("dest_loc", getDestLoc());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dirx", getDirx());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("podxetb", getPodxetb());
		this.hashColumns.put("lanex", getLanex());
		this.hashColumns.put("ttx", getTtx());
		this.hashColumns.put("fdr_flgx", getFdrFlgx());
		this.hashColumns.put("dir", getDir());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * 
	 * @return
	 */
	public HashMap<String, String> getFieldNames() {
		this.hashFields.put("polx", "polx");
		this.hashFields.put("svc_tpx", "svcTpx");
		this.hashFields.put("ori_loc", "oriLoc");
		this.hashFields.put("podx", "podx");
		this.hashFields.put("polxetb", "polxetb");
		this.hashFields.put("dest_loc", "destLoc");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dirx", "dirx");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("podxetb", "podxetb");
		this.hashFields.put("lanex", "lanex");
		this.hashFields.put("ttx", "ttx");
		this.hashFields.put("fdr_flgx", "fdrFlgx");
		this.hashFields.put("dir", "dir");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * 
	 * @return polx
	 */
	public String getPolx() {
		return this.polx;
	}

	/**
	 * Column Info
	 * 
	 * @return svcTpx
	 */
	public String getSvcTpx() {
		return this.svcTpx;
	}

	/**
	 * Column Info
	 * 
	 * @return oriLoc
	 */
	public String getOriLoc() {
		return this.oriLoc;
	}

	/**
	 * Column Info
	 * 
	 * @return podx
	 */
	public String getPodx() {
		return this.podx;
	}

	/**
	 * Column Info
	 * 
	 * @return polxetb
	 */
	public String getPolxetb() {
		return this.polxetb;
	}

	/**
	 * Column Info
	 * 
	 * @return destLoc
	 */
	public String getDestLoc() {
		return this.destLoc;
	}

	/**
	 * Column Info
	 * 
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
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
	 * @return dirx
	 */
	public String getDirx() {
		return this.dirx;
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
	 * @return podxetb
	 */
	public String getPodxetb() {
		return this.podxetb;
	}

	/**
	 * Column Info
	 * 
	 * @return lanex
	 */
	public String getLanex() {
		return this.lanex;
	}

	/**
	 * Column Info
	 * 
	 * @return ttx
	 */
	public String getTtx() {
		return this.ttx;
	}

	/**
	 * Column Info
	 * 
	 * @return fdrFlgx
	 */
	public String getFdrFlgx() {
		return this.fdrFlgx;
	}

	/**
	 * Column Info
	 * 
	 * @param polx
	 */
	public void setPolx(String polx) {
		this.polx = polx;
	}

	/**
	 * Column Info
	 * 
	 * @param svcTpx
	 */
	public void setSvcTpx(String svcTpx) {
		this.svcTpx = svcTpx;
	}

	/**
	 * Column Info
	 * 
	 * @param oriLoc
	 */
	public void setOriLoc(String oriLoc) {
		this.oriLoc = oriLoc;
	}

	/**
	 * Column Info
	 * 
	 * @param podx
	 */
	public void setPodx(String podx) {
		this.podx = podx;
	}

	/**
	 * Column Info
	 * 
	 * @param polxetb
	 */
	public void setPolxetb(String polxetb) {
		this.polxetb = polxetb;
	}

	/**
	 * Column Info
	 * 
	 * @param destLoc
	 */
	public void setDestLoc(String destLoc) {
		this.destLoc = destLoc;
	}

	/**
	 * Column Info
	 * 
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
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
	 * @param dirx
	 */
	public void setDirx(String dirx) {
		this.dirx = dirx;
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
	 * @param podxetb
	 */
	public void setPodxetb(String podxetb) {
		this.podxetb = podxetb;
	}

	/**
	 * Column Info
	 * 
	 * @param lanex
	 */
	public void setLanex(String lanex) {
		this.lanex = lanex;
	}

	/**
	 * Column Info
	 * 
	 * @param ttx
	 */
	public void setTtx(String ttx) {
		this.ttx = ttx;
	}

	/**
	 * Column Info
	 * 
	 * @param fdrFlgx
	 */
	public void setFdrFlgx(String fdrFlgx) {
		this.fdrFlgx = fdrFlgx;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPolx(JSPUtil.getParameter(request, "polx", ""));
		setSvcTpx(JSPUtil.getParameter(request, "svc_tpx", ""));
		setOriLoc(JSPUtil.getParameter(request, "ori_loc", ""));
		setPodx(JSPUtil.getParameter(request, "podx", ""));
		setPolxetb(JSPUtil.getParameter(request, "polxetb", ""));
		setDestLoc(JSPUtil.getParameter(request, "dest_loc", ""));
		setLane(JSPUtil.getParameter(request, "lane", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDirx(JSPUtil.getParameter(request, "dirx", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPodxetb(JSPUtil.getParameter(request, "podxetb", ""));
		setLanex(JSPUtil.getParameter(request, "lanex", ""));
		setTtx(JSPUtil.getParameter(request, "ttx", ""));
		setFdrFlgx(JSPUtil.getParameter(request, "fdr_flgx", ""));
		setDir(JSPUtil.getParameter(request, "dir", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * 
	 * @param request
	 * @return SearchOceanLaneVO[]
	 */
	public SearchOceanLaneVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * 
	 * @param request
	 * @param prefix
	 * @return SearchOceanLaneVO[]
	 */
	public SearchOceanLaneVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchOceanLaneVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] polx = (JSPUtil.getParameter(request, prefix + "polx", length));
			String[] svcTpx = (JSPUtil.getParameter(request, prefix + "svc_tpx", length));
			String[] oriLoc = (JSPUtil.getParameter(request, prefix + "ori_loc", length));
			String[] podx = (JSPUtil.getParameter(request, prefix + "podx", length));
			String[] polxetb = (JSPUtil.getParameter(request, prefix + "polxetb", length));
			String[] destLoc = (JSPUtil.getParameter(request, prefix + "dest_loc", length));
			String[] lane = (JSPUtil.getParameter(request, prefix + "lane", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
			String[] dirx = (JSPUtil.getParameter(request, prefix + "dirx", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
			String[] podxetb = (JSPUtil.getParameter(request, prefix + "podxetb", length));
			String[] lanex = (JSPUtil.getParameter(request, prefix + "lanex", length));
			String[] ttx = (JSPUtil.getParameter(request, prefix + "ttx", length));
			String[] fdrFlgx = (JSPUtil.getParameter(request, prefix + "fdr_flgx", length));
			String[] dir = (JSPUtil.getParameter(request, prefix + "dir", length));

			for (int i = 0; i < length; i++) {
				model = new SearchOceanLaneVO();
				if (polx[i] != null)
					model.setPolx(polx[i]);
				if (svcTpx[i] != null)
					model.setSvcTpx(svcTpx[i]);
				if (oriLoc[i] != null)
					model.setOriLoc(oriLoc[i]);
				if (podx[i] != null)
					model.setPodx(podx[i]);
				if (polxetb[i] != null)
					model.setPolxetb(polxetb[i]);
				if (destLoc[i] != null)
					model.setDestLoc(destLoc[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (dirx[i] != null)
					model.setDirx(dirx[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (podxetb[i] != null)
					model.setPodxetb(podxetb[i]);
				if (lanex[i] != null)
					model.setLanex(lanex[i]);
				if (ttx[i] != null)
					model.setTtx(ttx[i]);
				if (fdrFlgx[i] != null)
					model.setFdrFlgx(fdrFlgx[i]);
				if (dir[i] != null)
					model.setDir(dir[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchOceanLaneVOs();
	}

	/**
	 * VO 배열을 반환
	 * 
	 * @return SearchOceanLaneVO[]
	 */
	public SearchOceanLaneVO[] getSearchOceanLaneVOs() {
		SearchOceanLaneVO[] vos = (SearchOceanLaneVO[]) models.toArray(new SearchOceanLaneVO[models.size()]);
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
		this.polx = this.polx.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcTpx = this.svcTpx.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriLoc = this.oriLoc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podx = this.podx.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polxetb = this.polxetb.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destLoc = this.destLoc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirx = this.dirx.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podxetb = this.podxetb.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lanex = this.lanex.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttx = this.ttx.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrFlgx = this.fdrFlgx.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dir = this.dir.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

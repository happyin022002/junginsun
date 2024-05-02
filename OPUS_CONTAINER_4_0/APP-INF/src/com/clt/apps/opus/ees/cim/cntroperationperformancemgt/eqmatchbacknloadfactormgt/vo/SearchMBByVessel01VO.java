/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchMBByVessel01VO.java
*@FileTitle : SearchMBByVessel01VO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.01
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.07.01 문중철 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo;

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
 * @author 문중철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchMBByVessel01VO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMBByVessel01VO> models = new ArrayList<SearchMBByVessel01VO>();
	
	/* Column Info */
	private String laneCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String toRgn = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* Column Info */
	private String clptSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String wkStDt = null;
	/* Column Info */
	private String clptIndSeq = null;
	/* Column Info */
	private String fromRgn = null;
	/* Column Info */
	private String wkEndDt = null;
	/* Column Info */
	private String week = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchMBByVessel01VO() {}

	public SearchMBByVessel01VO(String ibflag, String pagerows, String trdCd, String laneCd, String vvd, String vslCd, String skdVoyNo, String skdDirCd, String vpsPortCd, String clptIndSeq, String clptSeq, String vpsEtdDt, String week, String wkStDt, String wkEndDt, String fromRgn, String toRgn) {
		this.laneCd = laneCd;
		this.vslCd = vslCd;
		this.vpsEtdDt = vpsEtdDt;
		this.trdCd = trdCd;
		this.skdVoyNo = skdVoyNo;
		this.toRgn = toRgn;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.vpsPortCd = vpsPortCd;
		this.clptSeq = clptSeq;
		this.ibflag = ibflag;
		this.wkStDt = wkStDt;
		this.clptIndSeq = clptIndSeq;
		this.fromRgn = fromRgn;
		this.wkEndDt = wkEndDt;
		this.week = week;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("lane_cd", getLaneCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("to_rgn", getToRgn());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("clpt_seq", getClptSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("wk_st_dt", getWkStDt());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		this.hashColumns.put("from_rgn", getFromRgn());
		this.hashColumns.put("wk_end_dt", getWkEndDt());
		this.hashColumns.put("week", getWeek());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("lane_cd", "laneCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("to_rgn", "toRgn");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("clpt_seq", "clptSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("wk_st_dt", "wkStDt");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		this.hashFields.put("from_rgn", "fromRgn");
		this.hashFields.put("wk_end_dt", "wkEndDt");
		this.hashFields.put("week", "week");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return laneCd
	 */
	public String getLaneCd() {
		return this.laneCd;
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
	 * @return vpsEtdDt
	 */
	public String getVpsEtdDt() {
		return this.vpsEtdDt;
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
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return toRgn
	 */
	public String getToRgn() {
		return this.toRgn;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
	}
	
	/**
	 * Column Info
	 * @return clptSeq
	 */
	public String getClptSeq() {
		return this.clptSeq;
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
	 * @return wkStDt
	 */
	public String getWkStDt() {
		return this.wkStDt;
	}
	
	/**
	 * Column Info
	 * @return clptIndSeq
	 */
	public String getClptIndSeq() {
		return this.clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return fromRgn
	 */
	public String getFromRgn() {
		return this.fromRgn;
	}
	
	/**
	 * Column Info
	 * @return wkEndDt
	 */
	public String getWkEndDt() {
		return this.wkEndDt;
	}
	
	/**
	 * Column Info
	 * @return week
	 */
	public String getWeek() {
		return this.week;
	}
	

	/**
	 * Column Info
	 * @param laneCd
	 */
	public void setLaneCd(String laneCd) {
		this.laneCd = laneCd;
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
	 * @param vpsEtdDt
	 */
	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param toRgn
	 */
	public void setToRgn(String toRgn) {
		this.toRgn = toRgn;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
	}
	
	/**
	 * Column Info
	 * @param clptSeq
	 */
	public void setClptSeq(String clptSeq) {
		this.clptSeq = clptSeq;
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
	 * @param wkStDt
	 */
	public void setWkStDt(String wkStDt) {
		this.wkStDt = wkStDt;
	}
	
	/**
	 * Column Info
	 * @param clptIndSeq
	 */
	public void setClptIndSeq(String clptIndSeq) {
		this.clptIndSeq = clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param fromRgn
	 */
	public void setFromRgn(String fromRgn) {
		this.fromRgn = fromRgn;
	}
	
	/**
	 * Column Info
	 * @param wkEndDt
	 */
	public void setWkEndDt(String wkEndDt) {
		this.wkEndDt = wkEndDt;
	}
	
	/**
	 * Column Info
	 * @param week
	 */
	public void setWeek(String week) {
		this.week = week;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setLaneCd(JSPUtil.getParameter(request, "lane_cd", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, "vps_etd_dt", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setToRgn(JSPUtil.getParameter(request, "to_rgn", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setVpsPortCd(JSPUtil.getParameter(request, "vps_port_cd", ""));
		setClptSeq(JSPUtil.getParameter(request, "clpt_seq", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setWkStDt(JSPUtil.getParameter(request, "wk_st_dt", ""));
		setClptIndSeq(JSPUtil.getParameter(request, "clpt_ind_seq", ""));
		setFromRgn(JSPUtil.getParameter(request, "from_rgn", ""));
		setWkEndDt(JSPUtil.getParameter(request, "wk_end_dt", ""));
		setWeek(JSPUtil.getParameter(request, "week", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMBByVessel01VO[]
	 */
	public SearchMBByVessel01VO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMBByVessel01VO[]
	 */
	public SearchMBByVessel01VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMBByVessel01VO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] laneCd = (JSPUtil.getParameter(request, prefix	+ "lane_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] toRgn = (JSPUtil.getParameter(request, prefix	+ "to_rgn", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] clptSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] wkStDt = (JSPUtil.getParameter(request, prefix	+ "wk_st_dt", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			String[] fromRgn = (JSPUtil.getParameter(request, prefix	+ "from_rgn", length));
			String[] wkEndDt = (JSPUtil.getParameter(request, prefix	+ "wk_end_dt", length));
			String[] week = (JSPUtil.getParameter(request, prefix	+ "week", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMBByVessel01VO();
				if (laneCd[i] != null)
					model.setLaneCd(laneCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (toRgn[i] != null)
					model.setToRgn(toRgn[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (clptSeq[i] != null)
					model.setClptSeq(clptSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (wkStDt[i] != null)
					model.setWkStDt(wkStDt[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				if (fromRgn[i] != null)
					model.setFromRgn(fromRgn[i]);
				if (wkEndDt[i] != null)
					model.setWkEndDt(wkEndDt[i]);
				if (week[i] != null)
					model.setWeek(week[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMBByVessel01VOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMBByVessel01VO[]
	 */
	public SearchMBByVessel01VO[] getSearchMBByVessel01VOs(){
		SearchMBByVessel01VO[] vos = (SearchMBByVessel01VO[])models.toArray(new SearchMBByVessel01VO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
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
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.laneCd = this.laneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toRgn = this.toRgn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptSeq = this.clptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wkStDt = this.wkStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromRgn = this.fromRgn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wkEndDt = this.wkEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.week = this.week .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

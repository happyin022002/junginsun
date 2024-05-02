/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RowSearchInlandRouteManageVO.java
*@FileTitle : RowSearchInlandRouteManageVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 김귀진
*@LastVersion : 1.0
* 2009.08.13 김귀진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo;

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

public class RowSearchInlandRouteManageVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RowSearchInlandRouteManageVO> models = new ArrayList<RowSearchInlandRouteManageVO>();
	
	/* Column Info */
	private String lnkDestNodCd = null;
	/* Column Info */
	private String fmtTztmHrs = null;
	/* Column Info */
	private String lnkDist = null;
	/* Column Info */
	private String vndrName = null;
	/* Column Info */
	private String railCrrTpCd = null;
	/* Column Info */
	private String fromNod = null;
	/* Column Info */
	private String trspMod = null;
	/* Column Info */
	private String tztmHrs = null;
	/* Column Info */
	private String trspModCd = null;
	/* Column Info */
	private String row = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String lnkOrgNodCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String distUtCd = null;
	/* Column Info */
	private String toNod = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RowSearchInlandRouteManageVO() {}

	public RowSearchInlandRouteManageVO(String ibflag, String pagerows, String lnkOrgNodCd, String lnkDestNodCd, String vndrSeq, String vndrName, String fmtTztmHrs, String tztmHrs, String lnkDist, String distUtCd, String railCrrTpCd, String trspModCd, String row, String fromNod, String toNod, String trspMod) {
		this.lnkDestNodCd = lnkDestNodCd;
		this.fmtTztmHrs = fmtTztmHrs;
		this.lnkDist = lnkDist;
		this.vndrName = vndrName;
		this.railCrrTpCd = railCrrTpCd;
		this.fromNod = fromNod;
		this.trspMod = trspMod;
		this.tztmHrs = tztmHrs;
		this.trspModCd = trspModCd;
		this.row = row;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.lnkOrgNodCd = lnkOrgNodCd;
		this.vndrSeq = vndrSeq;
		this.distUtCd = distUtCd;
		this.toNod = toNod;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("lnk_dest_nod_cd", getLnkDestNodCd());
		this.hashColumns.put("fmt_tztm_hrs", getFmtTztmHrs());
		this.hashColumns.put("lnk_dist", getLnkDist());
		this.hashColumns.put("vndr_name", getVndrName());
		this.hashColumns.put("rail_crr_tp_cd", getRailCrrTpCd());
		this.hashColumns.put("from_nod", getFromNod());
		this.hashColumns.put("trsp_mod", getTrspMod());
		this.hashColumns.put("tztm_hrs", getTztmHrs());
		this.hashColumns.put("trsp_mod_cd", getTrspModCd());
		this.hashColumns.put("row", getRow());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("lnk_org_nod_cd", getLnkOrgNodCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("dist_ut_cd", getDistUtCd());
		this.hashColumns.put("to_nod", getToNod());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("lnk_dest_nod_cd", "lnkDestNodCd");
		this.hashFields.put("fmt_tztm_hrs", "fmtTztmHrs");
		this.hashFields.put("lnk_dist", "lnkDist");
		this.hashFields.put("vndr_name", "vndrName");
		this.hashFields.put("rail_crr_tp_cd", "railCrrTpCd");
		this.hashFields.put("from_nod", "fromNod");
		this.hashFields.put("trsp_mod", "trspMod");
		this.hashFields.put("tztm_hrs", "tztmHrs");
		this.hashFields.put("trsp_mod_cd", "trspModCd");
		this.hashFields.put("row", "row");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("lnk_org_nod_cd", "lnkOrgNodCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("dist_ut_cd", "distUtCd");
		this.hashFields.put("to_nod", "toNod");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return lnkDestNodCd
	 */
	public String getLnkDestNodCd() {
		return this.lnkDestNodCd;
	}
	
	/**
	 * Column Info
	 * @return fmtTztmHrs
	 */
	public String getFmtTztmHrs() {
		return this.fmtTztmHrs;
	}
	
	/**
	 * Column Info
	 * @return lnkDist
	 */
	public String getLnkDist() {
		return this.lnkDist;
	}
	
	/**
	 * Column Info
	 * @return vndrName
	 */
	public String getVndrName() {
		return this.vndrName;
	}
	
	/**
	 * Column Info
	 * @return railCrrTpCd
	 */
	public String getRailCrrTpCd() {
		return this.railCrrTpCd;
	}
	
	/**
	 * Column Info
	 * @return fromNod
	 */
	public String getFromNod() {
		return this.fromNod;
	}
	
	/**
	 * Column Info
	 * @return trspMod
	 */
	public String getTrspMod() {
		return this.trspMod;
	}
	
	/**
	 * Column Info
	 * @return tztmHrs
	 */
	public String getTztmHrs() {
		return this.tztmHrs;
	}
	
	/**
	 * Column Info
	 * @return trspModCd
	 */
	public String getTrspModCd() {
		return this.trspModCd;
	}
	
	/**
	 * Column Info
	 * @return row
	 */
	public String getRow() {
		return this.row;
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
	 * @return lnkOrgNodCd
	 */
	public String getLnkOrgNodCd() {
		return this.lnkOrgNodCd;
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
	 * @return distUtCd
	 */
	public String getDistUtCd() {
		return this.distUtCd;
	}
	
	/**
	 * Column Info
	 * @return toNod
	 */
	public String getToNod() {
		return this.toNod;
	}
	

	/**
	 * Column Info
	 * @param lnkDestNodCd
	 */
	public void setLnkDestNodCd(String lnkDestNodCd) {
		this.lnkDestNodCd = lnkDestNodCd;
	}
	
	/**
	 * Column Info
	 * @param fmtTztmHrs
	 */
	public void setFmtTztmHrs(String fmtTztmHrs) {
		this.fmtTztmHrs = fmtTztmHrs;
	}
	
	/**
	 * Column Info
	 * @param lnkDist
	 */
	public void setLnkDist(String lnkDist) {
		this.lnkDist = lnkDist;
	}
	
	/**
	 * Column Info
	 * @param vndrName
	 */
	public void setVndrName(String vndrName) {
		this.vndrName = vndrName;
	}
	
	/**
	 * Column Info
	 * @param railCrrTpCd
	 */
	public void setRailCrrTpCd(String railCrrTpCd) {
		this.railCrrTpCd = railCrrTpCd;
	}
	
	/**
	 * Column Info
	 * @param fromNod
	 */
	public void setFromNod(String fromNod) {
		this.fromNod = fromNod;
	}
	
	/**
	 * Column Info
	 * @param trspMod
	 */
	public void setTrspMod(String trspMod) {
		this.trspMod = trspMod;
	}
	
	/**
	 * Column Info
	 * @param tztmHrs
	 */
	public void setTztmHrs(String tztmHrs) {
		this.tztmHrs = tztmHrs;
	}
	
	/**
	 * Column Info
	 * @param trspModCd
	 */
	public void setTrspModCd(String trspModCd) {
		this.trspModCd = trspModCd;
	}
	
	/**
	 * Column Info
	 * @param row
	 */
	public void setRow(String row) {
		this.row = row;
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
	 * @param lnkOrgNodCd
	 */
	public void setLnkOrgNodCd(String lnkOrgNodCd) {
		this.lnkOrgNodCd = lnkOrgNodCd;
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
	 * @param distUtCd
	 */
	public void setDistUtCd(String distUtCd) {
		this.distUtCd = distUtCd;
	}
	
	/**
	 * Column Info
	 * @param toNod
	 */
	public void setToNod(String toNod) {
		this.toNod = toNod;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setLnkDestNodCd(JSPUtil.getParameter(request, "lnk_dest_nod_cd", ""));
		setFmtTztmHrs(JSPUtil.getParameter(request, "fmt_tztm_hrs", ""));
		setLnkDist(JSPUtil.getParameter(request, "lnk_dist", ""));
		setVndrName(JSPUtil.getParameter(request, "vndr_name", ""));
		setRailCrrTpCd(JSPUtil.getParameter(request, "rail_crr_tp_cd", ""));
		setFromNod(JSPUtil.getParameter(request, "from_nod", ""));
		setTrspMod(JSPUtil.getParameter(request, "trsp_mod", ""));
		setTztmHrs(JSPUtil.getParameter(request, "tztm_hrs", ""));
		setTrspModCd(JSPUtil.getParameter(request, "trsp_mod_cd", ""));
		setRow(JSPUtil.getParameter(request, "row", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLnkOrgNodCd(JSPUtil.getParameter(request, "lnk_org_nod_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setDistUtCd(JSPUtil.getParameter(request, "dist_ut_cd", ""));
		setToNod(JSPUtil.getParameter(request, "to_nod", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RowSearchInlandRouteManageVO[]
	 */
	public RowSearchInlandRouteManageVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RowSearchInlandRouteManageVO[]
	 */
	public RowSearchInlandRouteManageVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RowSearchInlandRouteManageVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] lnkDestNodCd = (JSPUtil.getParameter(request, prefix	+ "lnk_dest_nod_cd", length));
			String[] fmtTztmHrs = (JSPUtil.getParameter(request, prefix	+ "fmt_tztm_hrs", length));
			String[] lnkDist = (JSPUtil.getParameter(request, prefix	+ "lnk_dist", length));
			String[] vndrName = (JSPUtil.getParameter(request, prefix	+ "vndr_name", length));
			String[] railCrrTpCd = (JSPUtil.getParameter(request, prefix	+ "rail_crr_tp_cd", length));
			String[] fromNod = (JSPUtil.getParameter(request, prefix	+ "from_nod", length));
			String[] trspMod = (JSPUtil.getParameter(request, prefix	+ "trsp_mod", length));
			String[] tztmHrs = (JSPUtil.getParameter(request, prefix	+ "tztm_hrs", length));
			String[] trspModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_mod_cd", length));
			String[] row = (JSPUtil.getParameter(request, prefix	+ "row", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] lnkOrgNodCd = (JSPUtil.getParameter(request, prefix	+ "lnk_org_nod_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] distUtCd = (JSPUtil.getParameter(request, prefix	+ "dist_ut_cd", length));
			String[] toNod = (JSPUtil.getParameter(request, prefix	+ "to_nod", length));
			
			for (int i = 0; i < length; i++) {
				model = new RowSearchInlandRouteManageVO();
				if (lnkDestNodCd[i] != null)
					model.setLnkDestNodCd(lnkDestNodCd[i]);
				if (fmtTztmHrs[i] != null)
					model.setFmtTztmHrs(fmtTztmHrs[i]);
				if (lnkDist[i] != null)
					model.setLnkDist(lnkDist[i]);
				if (vndrName[i] != null)
					model.setVndrName(vndrName[i]);
				if (railCrrTpCd[i] != null)
					model.setRailCrrTpCd(railCrrTpCd[i]);
				if (fromNod[i] != null)
					model.setFromNod(fromNod[i]);
				if (trspMod[i] != null)
					model.setTrspMod(trspMod[i]);
				if (tztmHrs[i] != null)
					model.setTztmHrs(tztmHrs[i]);
				if (trspModCd[i] != null)
					model.setTrspModCd(trspModCd[i]);
				if (row[i] != null)
					model.setRow(row[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (lnkOrgNodCd[i] != null)
					model.setLnkOrgNodCd(lnkOrgNodCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (distUtCd[i] != null)
					model.setDistUtCd(distUtCd[i]);
				if (toNod[i] != null)
					model.setToNod(toNod[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRowSearchInlandRouteManageVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RowSearchInlandRouteManageVO[]
	 */
	public RowSearchInlandRouteManageVO[] getRowSearchInlandRouteManageVOs(){
		RowSearchInlandRouteManageVO[] vos = (RowSearchInlandRouteManageVO[])models.toArray(new RowSearchInlandRouteManageVO[models.size()]);
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
		this.lnkDestNodCd = this.lnkDestNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtTztmHrs = this.fmtTztmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkDist = this.lnkDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrName = this.vndrName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railCrrTpCd = this.railCrrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromNod = this.fromNod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspMod = this.trspMod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tztmHrs = this.tztmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspModCd = this.trspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.row = this.row .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkOrgNodCd = this.lnkOrgNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.distUtCd = this.distUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toNod = this.toNod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

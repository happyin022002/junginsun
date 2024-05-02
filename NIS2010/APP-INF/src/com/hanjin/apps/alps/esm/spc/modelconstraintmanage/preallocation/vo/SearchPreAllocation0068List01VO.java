/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchPreAllocation0068List01VO.java
*@FileTitle : SearchPreAllocation0068List01VO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 주선영
*@LastVersion : 1.0
* 2009.09.07 주선영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.spc.modelconstraintmanage.preallocation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 주선영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchPreAllocation0068List01VO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchPreAllocation0068List01VO> models = new ArrayList<SearchPreAllocation0068List01VO>();
	
	/* Column Info */
	private String toTrdCd = null;
	/* Column Info */
	private String bseYr = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String repTrdCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vslClssCapaTxt = null;
	/* Column Info */
	private String bseMon = null;
	/* Column Info */
	private String toDirCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String vslClssCapa = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String spcAlocQty = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchPreAllocation0068List01VO() {}

	public SearchPreAllocation0068List01VO(String ibflag, String pagerows, String bseYr, String bseMon, String repTrdCd, String rlaneCd, String dirCd, String vslClssCapa, String vslClssCapaTxt, String portCd, String spcAlocQty, String toTrdCd, String toDirCd) {
		this.toTrdCd = toTrdCd;
		this.bseYr = bseYr;
		this.rlaneCd = rlaneCd;
		this.repTrdCd = repTrdCd;
		this.pagerows = pagerows;
		this.vslClssCapaTxt = vslClssCapaTxt;
		this.bseMon = bseMon;
		this.toDirCd = toDirCd;
		this.ibflag = ibflag;
		this.dirCd = dirCd;
		this.vslClssCapa = vslClssCapa;
		this.portCd = portCd;
		this.spcAlocQty = spcAlocQty;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_trd_cd", getToTrdCd());
		this.hashColumns.put("bse_yr", getBseYr());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("rep_trd_cd", getRepTrdCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vsl_clss_capa_txt", getVslClssCapaTxt());
		this.hashColumns.put("bse_mon", getBseMon());
		this.hashColumns.put("to_dir_cd", getToDirCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("vsl_clss_capa", getVslClssCapa());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("spc_aloc_qty", getSpcAlocQty());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_trd_cd", "toTrdCd");
		this.hashFields.put("bse_yr", "bseYr");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("rep_trd_cd", "repTrdCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vsl_clss_capa_txt", "vslClssCapaTxt");
		this.hashFields.put("bse_mon", "bseMon");
		this.hashFields.put("to_dir_cd", "toDirCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("vsl_clss_capa", "vslClssCapa");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("spc_aloc_qty", "spcAlocQty");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toTrdCd
	 */
	public String getToTrdCd() {
		return this.toTrdCd;
	}
	
	/**
	 * Column Info
	 * @return bseYr
	 */
	public String getBseYr() {
		return this.bseYr;
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
	 * @return repTrdCd
	 */
	public String getRepTrdCd() {
		return this.repTrdCd;
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
	 * @return vslClssCapaTxt
	 */
	public String getVslClssCapaTxt() {
		return this.vslClssCapaTxt;
	}
	
	/**
	 * Column Info
	 * @return bseMon
	 */
	public String getBseMon() {
		return this.bseMon;
	}
	
	/**
	 * Column Info
	 * @return toDirCd
	 */
	public String getToDirCd() {
		return this.toDirCd;
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
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return vslClssCapa
	 */
	public String getVslClssCapa() {
		return this.vslClssCapa;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return spcAlocQty
	 */
	public String getSpcAlocQty() {
		return this.spcAlocQty;
	}
	

	/**
	 * Column Info
	 * @param toTrdCd
	 */
	public void setToTrdCd(String toTrdCd) {
		this.toTrdCd = toTrdCd;
	}
	
	/**
	 * Column Info
	 * @param bseYr
	 */
	public void setBseYr(String bseYr) {
		this.bseYr = bseYr;
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
	 * @param repTrdCd
	 */
	public void setRepTrdCd(String repTrdCd) {
		this.repTrdCd = repTrdCd;
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
	 * @param vslClssCapaTxt
	 */
	public void setVslClssCapaTxt(String vslClssCapaTxt) {
		this.vslClssCapaTxt = vslClssCapaTxt;
	}
	
	/**
	 * Column Info
	 * @param bseMon
	 */
	public void setBseMon(String bseMon) {
		this.bseMon = bseMon;
	}
	
	/**
	 * Column Info
	 * @param toDirCd
	 */
	public void setToDirCd(String toDirCd) {
		this.toDirCd = toDirCd;
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
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param vslClssCapa
	 */
	public void setVslClssCapa(String vslClssCapa) {
		this.vslClssCapa = vslClssCapa;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param spcAlocQty
	 */
	public void setSpcAlocQty(String spcAlocQty) {
		this.spcAlocQty = spcAlocQty;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setToTrdCd(JSPUtil.getParameter(request, "to_trd_cd", ""));
		setBseYr(JSPUtil.getParameter(request, "bse_yr", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setRepTrdCd(JSPUtil.getParameter(request, "rep_trd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVslClssCapaTxt(JSPUtil.getParameter(request, "vsl_clss_capa_txt", ""));
		setBseMon(JSPUtil.getParameter(request, "bse_mon", ""));
		setToDirCd(JSPUtil.getParameter(request, "to_dir_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setVslClssCapa(JSPUtil.getParameter(request, "vsl_clss_capa", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setSpcAlocQty(JSPUtil.getParameter(request, "spc_aloc_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchPreAllocation0068List01VO[]
	 */
	public SearchPreAllocation0068List01VO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchPreAllocation0068List01VO[]
	 */
	public SearchPreAllocation0068List01VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchPreAllocation0068List01VO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toTrdCd = (JSPUtil.getParameter(request, prefix	+ "to_trd_cd", length));
			String[] bseYr = (JSPUtil.getParameter(request, prefix	+ "bse_yr", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] repTrdCd = (JSPUtil.getParameter(request, prefix	+ "rep_trd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vslClssCapaTxt = (JSPUtil.getParameter(request, prefix	+ "vsl_clss_capa_txt", length));
			String[] bseMon = (JSPUtil.getParameter(request, prefix	+ "bse_mon", length));
			String[] toDirCd = (JSPUtil.getParameter(request, prefix	+ "to_dir_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] vslClssCapa = (JSPUtil.getParameter(request, prefix	+ "vsl_clss_capa", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] spcAlocQty = (JSPUtil.getParameter(request, prefix	+ "spc_aloc_qty", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchPreAllocation0068List01VO();
				if (toTrdCd[i] != null)
					model.setToTrdCd(toTrdCd[i]);
				if (bseYr[i] != null)
					model.setBseYr(bseYr[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (repTrdCd[i] != null)
					model.setRepTrdCd(repTrdCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vslClssCapaTxt[i] != null)
					model.setVslClssCapaTxt(vslClssCapaTxt[i]);
				if (bseMon[i] != null)
					model.setBseMon(bseMon[i]);
				if (toDirCd[i] != null)
					model.setToDirCd(toDirCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (vslClssCapa[i] != null)
					model.setVslClssCapa(vslClssCapa[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (spcAlocQty[i] != null)
					model.setSpcAlocQty(spcAlocQty[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchPreAllocation0068List01VOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchPreAllocation0068List01VO[]
	 */
	public SearchPreAllocation0068List01VO[] getSearchPreAllocation0068List01VOs(){
		SearchPreAllocation0068List01VO[] vos = (SearchPreAllocation0068List01VO[])models.toArray(new SearchPreAllocation0068List01VO[models.size()]);
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
		this.toTrdCd = this.toTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYr = this.bseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repTrdCd = this.repTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslClssCapaTxt = this.vslClssCapaTxt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseMon = this.bseMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDirCd = this.toDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslClssCapa = this.vslClssCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spcAlocQty = this.spcAlocQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

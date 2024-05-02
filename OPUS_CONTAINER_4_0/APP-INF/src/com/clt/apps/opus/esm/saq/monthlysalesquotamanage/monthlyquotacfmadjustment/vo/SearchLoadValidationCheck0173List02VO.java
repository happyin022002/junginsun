/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchLoadValidationCheck0173List02VO.java
*@FileTitle : SearchLoadValidationCheck0173List02VO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 주선영
*@LastVersion : 1.0
* 2009.09.22 주선영 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacfmadjustment.vo;

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
 * @author 주선영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchLoadValidationCheck0173List02VO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchLoadValidationCheck0173List02VO> models = new ArrayList<SearchLoadValidationCheck0173List02VO>();
	
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String bseMon = null;
	/* Column Info */
	private String lodCompare = null;
	/* Column Info */
	private String lodQty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String rgnOfcCd = null;
	/* Column Info */
	private String msg = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchLoadValidationCheck0173List02VO() {}

	public SearchLoadValidationCheck0173List02VO(String ibflag, String pagerows, String msg, String trdCd, String rlaneCd, String dirCd, String rgnOfcCd, String bseMon, String vvd, String lodQty, String lodCompare) {
		this.vvd = vvd;
		this.bseMon = bseMon;
		this.lodCompare = lodCompare;
		this.lodQty = lodQty;
		this.ibflag = ibflag;
		this.trdCd = trdCd;
		this.dirCd = dirCd;
		this.rlaneCd = rlaneCd;
		this.rgnOfcCd = rgnOfcCd;
		this.msg = msg;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("bse_mon", getBseMon());
		this.hashColumns.put("lod_compare", getLodCompare());
		this.hashColumns.put("lod_qty", getLodQty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("rgn_ofc_cd", getRgnOfcCd());
		this.hashColumns.put("msg", getMsg());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("bse_mon", "bseMon");
		this.hashFields.put("lod_compare", "lodCompare");
		this.hashFields.put("lod_qty", "lodQty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("rgn_ofc_cd", "rgnOfcCd");
		this.hashFields.put("msg", "msg");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return bseMon
	 */
	public String getBseMon() {
		return this.bseMon;
	}
	
	/**
	 * Column Info
	 * @return lodCompare
	 */
	public String getLodCompare() {
		return this.lodCompare;
	}
	
	/**
	 * Column Info
	 * @return lodQty
	 */
	public String getLodQty() {
		return this.lodQty;
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
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
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
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return rgnOfcCd
	 */
	public String getRgnOfcCd() {
		return this.rgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @return msg
	 */
	public String getMsg() {
		return this.msg;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param lodCompare
	 */
	public void setLodCompare(String lodCompare) {
		this.lodCompare = lodCompare;
	}
	
	/**
	 * Column Info
	 * @param lodQty
	 */
	public void setLodQty(String lodQty) {
		this.lodQty = lodQty;
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
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
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
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param rgnOfcCd
	 */
	public void setRgnOfcCd(String rgnOfcCd) {
		this.rgnOfcCd = rgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @param msg
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setBseMon(JSPUtil.getParameter(request, "bse_mon", ""));
		setLodCompare(JSPUtil.getParameter(request, "lod_compare", ""));
		setLodQty(JSPUtil.getParameter(request, "lod_qty", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setRgnOfcCd(JSPUtil.getParameter(request, "rgn_ofc_cd", ""));
		setMsg(JSPUtil.getParameter(request, "msg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchLoadValidationCheck0173List02VO[]
	 */
	public SearchLoadValidationCheck0173List02VO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchLoadValidationCheck0173List02VO[]
	 */
	public SearchLoadValidationCheck0173List02VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchLoadValidationCheck0173List02VO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] bseMon = (JSPUtil.getParameter(request, prefix	+ "bse_mon", length));
			String[] lodCompare = (JSPUtil.getParameter(request, prefix	+ "lod_compare", length));
			String[] lodQty = (JSPUtil.getParameter(request, prefix	+ "lod_qty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] rgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "rgn_ofc_cd", length));
			String[] msg = (JSPUtil.getParameter(request, prefix	+ "msg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchLoadValidationCheck0173List02VO();
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (bseMon[i] != null)
					model.setBseMon(bseMon[i]);
				if (lodCompare[i] != null)
					model.setLodCompare(lodCompare[i]);
				if (lodQty[i] != null)
					model.setLodQty(lodQty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (rgnOfcCd[i] != null)
					model.setRgnOfcCd(rgnOfcCd[i]);
				if (msg[i] != null)
					model.setMsg(msg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchLoadValidationCheck0173List02VOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchLoadValidationCheck0173List02VO[]
	 */
	public SearchLoadValidationCheck0173List02VO[] getSearchLoadValidationCheck0173List02VOs(){
		SearchLoadValidationCheck0173List02VO[] vos = (SearchLoadValidationCheck0173List02VO[])models.toArray(new SearchLoadValidationCheck0173List02VO[models.size()]);
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
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseMon = this.bseMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodCompare = this.lodCompare .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodQty = this.lodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnOfcCd = this.rgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msg = this.msg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSimBunkerListVO.java
*@FileTitle : SearchSimBunkerListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.13  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.coa.lanesimulation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSimBunkerListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSimBunkerListVO> models = new ArrayList<SearchSimBunkerListVO>();
	
	/* Column Info */
	private String sectDesc = null;
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String foilSailCsm = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String sectNo = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String foilPortCsm = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String foilUcAmt = null;
	/* Column Info */
	private String doilUcAmt = null;
	/* Column Info */
	private String vslClssCapa = null;
	/* Column Info */
	private String doilCsm = null;
	/* Column Info */
	private String bzcVslSpd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSimBunkerListVO() {}

	public SearchSimBunkerListVO(String ibflag, String pagerows, String sectDesc, String sectNo, String trdCd, String rlaneCd, String iocCd, String skdDirCd, String vslClssCapa, String bzcVslSpd, String foilSailCsm, String foilPortCsm, String foilUcAmt, String doilCsm, String doilUcAmt) {
		this.sectDesc = sectDesc;
		this.iocCd = iocCd;
		this.foilSailCsm = foilSailCsm;
		this.trdCd = trdCd;
		this.sectNo = sectNo;
		this.rlaneCd = rlaneCd;
		this.foilPortCsm = foilPortCsm;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.foilUcAmt = foilUcAmt;
		this.doilUcAmt = doilUcAmt;
		this.vslClssCapa = vslClssCapa;
		this.doilCsm = doilCsm;
		this.bzcVslSpd = bzcVslSpd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sect_desc", getSectDesc());
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("foil_sail_csm", getFoilSailCsm());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("sect_no", getSectNo());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("foil_port_csm", getFoilPortCsm());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("foil_uc_amt", getFoilUcAmt());
		this.hashColumns.put("doil_uc_amt", getDoilUcAmt());
		this.hashColumns.put("vsl_clss_capa", getVslClssCapa());
		this.hashColumns.put("doil_csm", getDoilCsm());
		this.hashColumns.put("bzc_vsl_spd", getBzcVslSpd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sect_desc", "sectDesc");
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("foil_sail_csm", "foilSailCsm");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("sect_no", "sectNo");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("foil_port_csm", "foilPortCsm");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("foil_uc_amt", "foilUcAmt");
		this.hashFields.put("doil_uc_amt", "doilUcAmt");
		this.hashFields.put("vsl_clss_capa", "vslClssCapa");
		this.hashFields.put("doil_csm", "doilCsm");
		this.hashFields.put("bzc_vsl_spd", "bzcVslSpd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sectDesc
	 */
	public String getSectDesc() {
		return this.sectDesc;
	}
	
	/**
	 * Column Info
	 * @return iocCd
	 */
	public String getIocCd() {
		return this.iocCd;
	}
	
	/**
	 * Column Info
	 * @return foilSailCsm
	 */
	public String getFoilSailCsm() {
		return this.foilSailCsm;
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
	 * @return sectNo
	 */
	public String getSectNo() {
		return this.sectNo;
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
	 * @return foilPortCsm
	 */
	public String getFoilPortCsm() {
		return this.foilPortCsm;
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
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return foilUcAmt
	 */
	public String getFoilUcAmt() {
		return this.foilUcAmt;
	}
	
	/**
	 * Column Info
	 * @return doilUcAmt
	 */
	public String getDoilUcAmt() {
		return this.doilUcAmt;
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
	 * @return doilCsm
	 */
	public String getDoilCsm() {
		return this.doilCsm;
	}
	
	/**
	 * Column Info
	 * @return bzcVslSpd
	 */
	public String getBzcVslSpd() {
		return this.bzcVslSpd;
	}
	

	/**
	 * Column Info
	 * @param sectDesc
	 */
	public void setSectDesc(String sectDesc) {
		this.sectDesc = sectDesc;
	}
	
	/**
	 * Column Info
	 * @param iocCd
	 */
	public void setIocCd(String iocCd) {
		this.iocCd = iocCd;
	}
	
	/**
	 * Column Info
	 * @param foilSailCsm
	 */
	public void setFoilSailCsm(String foilSailCsm) {
		this.foilSailCsm = foilSailCsm;
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
	 * @param sectNo
	 */
	public void setSectNo(String sectNo) {
		this.sectNo = sectNo;
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
	 * @param foilPortCsm
	 */
	public void setFoilPortCsm(String foilPortCsm) {
		this.foilPortCsm = foilPortCsm;
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
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param foilUcAmt
	 */
	public void setFoilUcAmt(String foilUcAmt) {
		this.foilUcAmt = foilUcAmt;
	}
	
	/**
	 * Column Info
	 * @param doilUcAmt
	 */
	public void setDoilUcAmt(String doilUcAmt) {
		this.doilUcAmt = doilUcAmt;
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
	 * @param doilCsm
	 */
	public void setDoilCsm(String doilCsm) {
		this.doilCsm = doilCsm;
	}
	
	/**
	 * Column Info
	 * @param bzcVslSpd
	 */
	public void setBzcVslSpd(String bzcVslSpd) {
		this.bzcVslSpd = bzcVslSpd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSectDesc(JSPUtil.getParameter(request, "sect_desc", ""));
		setIocCd(JSPUtil.getParameter(request, "ioc_cd", ""));
		setFoilSailCsm(JSPUtil.getParameter(request, "foil_sail_csm", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setSectNo(JSPUtil.getParameter(request, "sect_no", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setFoilPortCsm(JSPUtil.getParameter(request, "foil_port_csm", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFoilUcAmt(JSPUtil.getParameter(request, "foil_uc_amt", ""));
		setDoilUcAmt(JSPUtil.getParameter(request, "doil_uc_amt", ""));
		setVslClssCapa(JSPUtil.getParameter(request, "vsl_clss_capa", ""));
		setDoilCsm(JSPUtil.getParameter(request, "doil_csm", ""));
		setBzcVslSpd(JSPUtil.getParameter(request, "bzc_vsl_spd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSimBunkerListVO[]
	 */
	public SearchSimBunkerListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSimBunkerListVO[]
	 */
	public SearchSimBunkerListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSimBunkerListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sectDesc = (JSPUtil.getParameter(request, prefix	+ "sect_desc", length));
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] foilSailCsm = (JSPUtil.getParameter(request, prefix	+ "foil_sail_csm", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] sectNo = (JSPUtil.getParameter(request, prefix	+ "sect_no", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] foilPortCsm = (JSPUtil.getParameter(request, prefix	+ "foil_port_csm", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] foilUcAmt = (JSPUtil.getParameter(request, prefix	+ "foil_uc_amt", length));
			String[] doilUcAmt = (JSPUtil.getParameter(request, prefix	+ "doil_uc_amt", length));
			String[] vslClssCapa = (JSPUtil.getParameter(request, prefix	+ "vsl_clss_capa", length));
			String[] doilCsm = (JSPUtil.getParameter(request, prefix	+ "doil_csm", length));
			String[] bzcVslSpd = (JSPUtil.getParameter(request, prefix	+ "bzc_vsl_spd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSimBunkerListVO();
				if (sectDesc[i] != null)
					model.setSectDesc(sectDesc[i]);
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (foilSailCsm[i] != null)
					model.setFoilSailCsm(foilSailCsm[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (sectNo[i] != null)
					model.setSectNo(sectNo[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (foilPortCsm[i] != null)
					model.setFoilPortCsm(foilPortCsm[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (foilUcAmt[i] != null)
					model.setFoilUcAmt(foilUcAmt[i]);
				if (doilUcAmt[i] != null)
					model.setDoilUcAmt(doilUcAmt[i]);
				if (vslClssCapa[i] != null)
					model.setVslClssCapa(vslClssCapa[i]);
				if (doilCsm[i] != null)
					model.setDoilCsm(doilCsm[i]);
				if (bzcVslSpd[i] != null)
					model.setBzcVslSpd(bzcVslSpd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSimBunkerListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSimBunkerListVO[]
	 */
	public SearchSimBunkerListVO[] getSearchSimBunkerListVOs(){
		SearchSimBunkerListVO[] vos = (SearchSimBunkerListVO[])models.toArray(new SearchSimBunkerListVO[models.size()]);
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
		this.sectDesc = this.sectDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilSailCsm = this.foilSailCsm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sectNo = this.sectNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilPortCsm = this.foilPortCsm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilUcAmt = this.foilUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doilUcAmt = this.doilUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslClssCapa = this.vslClssCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doilCsm = this.doilCsm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcVslSpd = this.bzcVslSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

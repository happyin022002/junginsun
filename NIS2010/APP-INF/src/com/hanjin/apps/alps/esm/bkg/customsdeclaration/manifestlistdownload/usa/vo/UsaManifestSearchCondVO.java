/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaManifestSearchCondVO.java
*@FileTitle : UsaManifestSearchCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.06.02 김도완 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김도완
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UsaManifestSearchCondVO extends ManifestListCondVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaManifestSearchCondVO> models = new ArrayList<UsaManifestSearchCondVO>();
	
	/* Column Info */
	private String searchMtd = null;
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fullEmpty = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String allErr = null;
	/* Column Info */
	private String frob = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String customs = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsaManifestSearchCondVO() {}

	public UsaManifestSearchCondVO(String ibflag, String pagerows, String vvd, String pod, String pol, String frob, String allErr, String fullEmpty, String searchMtd, String customs) {
		this.searchMtd = searchMtd;
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.fullEmpty = fullEmpty;
		this.pol = pol;
		this.allErr = allErr;
		this.frob = frob;
		this.pod = pod;
		this.pagerows = pagerows;
		this.customs = customs;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("search_mtd", getSearchMtd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("full_empty", getFullEmpty());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("all_err", getAllErr());
		this.hashColumns.put("frob", getFrob());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("customs", getCustoms());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("search_mtd", "searchMtd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("full_empty", "fullEmpty");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("all_err", "allErr");
		this.hashFields.put("frob", "frob");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("customs", "customs");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return searchMtd
	 */
	public String getCustoms() {
		return this.customs;
	}
	
	/**
	 * Column Info
	 * @return searchMtd
	 */
	public String getSearchMtd() {
		return this.searchMtd;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return fullEmpty
	 */
	public String getFullEmpty() {
		return this.fullEmpty;
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
	 * @return allErr
	 */
	public String getAllErr() {
		return this.allErr;
	}
	
	/**
	 * Column Info
	 * @return frob
	 */
	public String getFrob() {
		return this.frob;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
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
	 * @param searchMtd
	 */
	public void setCustoms(String customs) {
		this.customs = customs;
	}
	
	/**
	 * Column Info
	 * @param searchMtd
	 */
	public void setSearchMtd(String searchMtd) {
		this.searchMtd = searchMtd;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param fullEmpty
	 */
	public void setFullEmpty(String fullEmpty) {
		this.fullEmpty = fullEmpty;
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
	 * @param allErr
	 */
	public void setAllErr(String allErr) {
		this.allErr = allErr;
	}
	
	/**
	 * Column Info
	 * @param frob
	 */
	public void setFrob(String frob) {
		this.frob = frob;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
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
		setSearchMtd(JSPUtil.getParameter(request, "search_mtd", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFullEmpty(JSPUtil.getParameter(request, "full_empty", ""));
		setPol(JSPUtil.getParameter(request, "pol", ""));
		setAllErr(JSPUtil.getParameter(request, "all_err", ""));
		setFrob(JSPUtil.getParameter(request, "frob", ""));
		setPod(JSPUtil.getParameter(request, "pod", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCustoms(JSPUtil.getParameter(request, "customs", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaManifestSearchCondVO[]
	 */
	public UsaManifestSearchCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaManifestSearchCondVO[]
	 */
	public UsaManifestSearchCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaManifestSearchCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] searchMtd = (JSPUtil.getParameter(request, prefix	+ "search_mtd".trim(), length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] fullEmpty = (JSPUtil.getParameter(request, prefix	+ "full_empty".trim(), length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol".trim(), length));
			String[] allErr = (JSPUtil.getParameter(request, prefix	+ "all_err".trim(), length));
			String[] frob = (JSPUtil.getParameter(request, prefix	+ "frob".trim(), length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] customs = (JSPUtil.getParameter(request, prefix	+ "customs".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new UsaManifestSearchCondVO();
				if (searchMtd[i] != null)
					model.setSearchMtd(searchMtd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fullEmpty[i] != null)
					model.setFullEmpty(fullEmpty[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (allErr[i] != null)
					model.setAllErr(allErr[i]);
				if (frob[i] != null)
					model.setFrob(frob[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (customs[i] != null)
					model.setCustoms(customs[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaManifestSearchCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaManifestSearchCondVO[]
	 */
	public UsaManifestSearchCondVO[] getUsaManifestSearchCondVOs(){
		UsaManifestSearchCondVO[] vos = (UsaManifestSearchCondVO[])models.toArray(new UsaManifestSearchCondVO[models.size()]);
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
		this.searchMtd = this.searchMtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullEmpty = this.fullEmpty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.allErr = this.allErr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frob = this.frob .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customs = this.customs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

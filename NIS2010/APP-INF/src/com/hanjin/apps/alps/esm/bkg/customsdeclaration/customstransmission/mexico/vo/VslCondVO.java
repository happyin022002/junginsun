/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VslCondVO.java
*@FileTitle : VslCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.24
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.10.24 김도완 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CargoManifestCondForEdiVO;
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

public class VslCondVO extends CargoManifestCondForEdiVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<VslCondVO> models = new ArrayList<VslCondVO>();
	
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String tmp2 = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tmp1 = null;
	/* Column Info */
	private String tmp3 = null;
	/* Column Info */
	private String totalBl = null;
	/* Column Info */
	private String searchFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String searchCargo = null;	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VslCondVO() {}

	public VslCondVO(String ibflag, String pagerows, String vvd, String podCd, String polCd, String totalBl, String searchFlg, String tmp1, String tmp2, String tmp3, String searchCargo) {
		this.podCd = podCd;
		this.vvd = vvd;
		this.tmp2 = tmp2;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.tmp1 = tmp1;
		this.tmp3 = tmp3;
		this.totalBl = totalBl;
		this.searchFlg = searchFlg;
		this.pagerows = pagerows;
		this.searchCargo = searchCargo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("tmp2", getTmp2());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tmp1", getTmp1());
		this.hashColumns.put("tmp3", getTmp3());
		this.hashColumns.put("total_bl", getTotalBl());
		this.hashColumns.put("search_flg", getSearchFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("search_cargo", getSearchCargo());		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("tmp2", "tmp2");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tmp1", "tmp1");
		this.hashFields.put("tmp3", "tmp3");
		this.hashFields.put("total_bl", "totalBl");
		this.hashFields.put("search_flg", "searchFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("search_cargo", "searchCargo");		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return tmp2
	 */
	public String getTmp2() {
		return this.tmp2;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return tmp1
	 */
	public String getTmp1() {
		return this.tmp1;
	}
	
	/**
	 * Column Info
	 * @return tmp3
	 */
	public String getTmp3() {
		return this.tmp3;
	}
	
	/**
	 * Column Info
	 * @return totalBl
	 */
	public String getTotalBl() {
		return this.totalBl;
	}
	
	/**
	 * Column Info
	 * @return searchFlg
	 */
	public String getSearchFlg() {
		return this.searchFlg;
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
	 * @return searchCargo
	 */
	public String getSearchCargo() {
		return this.searchCargo;
	}

	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param tmp2
	 */
	public void setTmp2(String tmp2) {
		this.tmp2 = tmp2;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param tmp1
	 */
	public void setTmp1(String tmp1) {
		this.tmp1 = tmp1;
	}
	
	/**
	 * Column Info
	 * @param tmp3
	 */
	public void setTmp3(String tmp3) {
		this.tmp3 = tmp3;
	}
	
	/**
	 * Column Info
	 * @param totalBl
	 */
	public void setTotalBl(String totalBl) {
		this.totalBl = totalBl;
	}
	
	/**
	 * Column Info
	 * @param searchFlg
	 */
	public void setSearchFlg(String searchFlg) {
		this.searchFlg = searchFlg;
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
	 * @param searchCargo
	 */
	public void setSearchCargo(String searchCargo) {
		this.searchCargo = searchCargo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setTmp2(JSPUtil.getParameter(request, "tmp2", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTmp1(JSPUtil.getParameter(request, "tmp1", ""));
		setTmp3(JSPUtil.getParameter(request, "tmp3", ""));
		setTotalBl(JSPUtil.getParameter(request, "total_bl", ""));
		setSearchFlg(JSPUtil.getParameter(request, "search_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSearchCargo(JSPUtil.getParameter(request, "search_cargo", ""));		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VslCondVO[]
	 */
	public VslCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VslCondVO[]
	 */
	public VslCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VslCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] tmp2 = (JSPUtil.getParameter(request, prefix	+ "tmp2", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tmp1 = (JSPUtil.getParameter(request, prefix	+ "tmp1", length));
			String[] tmp3 = (JSPUtil.getParameter(request, prefix	+ "tmp3", length));
			String[] totalBl = (JSPUtil.getParameter(request, prefix	+ "total_bl", length));
			String[] searchFlg = (JSPUtil.getParameter(request, prefix	+ "search_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] searchCargo = (JSPUtil.getParameter(request, prefix	+ "search_cargo", length));			
			
			for (int i = 0; i < length; i++) {
				model = new VslCondVO();
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (tmp2[i] != null)
					model.setTmp2(tmp2[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tmp1[i] != null)
					model.setTmp1(tmp1[i]);
				if (tmp3[i] != null)
					model.setTmp3(tmp3[i]);
				if (totalBl[i] != null)
					model.setTotalBl(totalBl[i]);
				if (searchFlg[i] != null)
					model.setSearchFlg(searchFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (searchCargo[i] != null)
					model.setSearchCargo(searchCargo[i]);				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVslCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VslCondVO[]
	 */
	public VslCondVO[] getVslCondVOs(){
		VslCondVO[] vos = (VslCondVO[])models.toArray(new VslCondVO[models.size()]);
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
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmp2 = this.tmp2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmp1 = this.tmp1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmp3 = this.tmp3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalBl = this.totalBl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchFlg = this.searchFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchCargo = this.searchCargo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
	}
}

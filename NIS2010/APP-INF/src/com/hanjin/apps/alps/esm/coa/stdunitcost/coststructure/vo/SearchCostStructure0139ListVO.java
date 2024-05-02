/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchCostStructure0139ListVO.java
*@FileTitle : SearchCostStructure0139ListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 장영석
*@LastVersion : 1.0
* 2009.10.14 장영석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.coa.stdunitcost.coststructure.vo;

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
 * @author 장영석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchCostStructure0139ListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchCostStructure0139ListVO> models = new ArrayList<SearchCostStructure0139ListVO>();
	
	/* Column Info */
	private String fdrRcvTermCd = null;
	/* Column Info */
	private String orgLocCd = null;
	/* Column Info */
	private String destLocCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fdrDeTermCd = null;
	/* Column Info */
	private String fullMtyCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchCostStructure0139ListVO() {}

	public SearchCostStructure0139ListVO(String ibflag, String pagerows, String orgLocCd, String destLocCd, String fullMtyCd, String fdrRcvTermCd, String fdrDeTermCd) {
		this.fdrRcvTermCd = fdrRcvTermCd;
		this.orgLocCd = orgLocCd;
		this.destLocCd = destLocCd;
		this.ibflag = ibflag;
		this.fdrDeTermCd = fdrDeTermCd;
		this.fullMtyCd = fullMtyCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("fdr_rcv_term_cd", getFdrRcvTermCd());
		this.hashColumns.put("org_loc_cd", getOrgLocCd());
		this.hashColumns.put("dest_loc_cd", getDestLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fdr_de_term_cd", getFdrDeTermCd());
		this.hashColumns.put("full_mty_cd", getFullMtyCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("fdr_rcv_term_cd", "fdrRcvTermCd");
		this.hashFields.put("org_loc_cd", "orgLocCd");
		this.hashFields.put("dest_loc_cd", "destLocCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fdr_de_term_cd", "fdrDeTermCd");
		this.hashFields.put("full_mty_cd", "fullMtyCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fdrRcvTermCd
	 */
	public String getFdrRcvTermCd() {
		return this.fdrRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return orgLocCd
	 */
	public String getOrgLocCd() {
		return this.orgLocCd;
	}
	
	/**
	 * Column Info
	 * @return destLocCd
	 */
	public String getDestLocCd() {
		return this.destLocCd;
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
	 * @return fdrDeTermCd
	 */
	public String getFdrDeTermCd() {
		return this.fdrDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return fullMtyCd
	 */
	public String getFullMtyCd() {
		return this.fullMtyCd;
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
	 * @param fdrRcvTermCd
	 */
	public void setFdrRcvTermCd(String fdrRcvTermCd) {
		this.fdrRcvTermCd = fdrRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param orgLocCd
	 */
	public void setOrgLocCd(String orgLocCd) {
		this.orgLocCd = orgLocCd;
	}
	
	/**
	 * Column Info
	 * @param destLocCd
	 */
	public void setDestLocCd(String destLocCd) {
		this.destLocCd = destLocCd;
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
	 * @param fdrDeTermCd
	 */
	public void setFdrDeTermCd(String fdrDeTermCd) {
		this.fdrDeTermCd = fdrDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param fullMtyCd
	 */
	public void setFullMtyCd(String fullMtyCd) {
		this.fullMtyCd = fullMtyCd;
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
		setFdrRcvTermCd(JSPUtil.getParameter(request, "fdr_rcv_term_cd", ""));
		setOrgLocCd(JSPUtil.getParameter(request, "org_loc_cd", ""));
		setDestLocCd(JSPUtil.getParameter(request, "dest_loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFdrDeTermCd(JSPUtil.getParameter(request, "fdr_de_term_cd", ""));
		setFullMtyCd(JSPUtil.getParameter(request, "full_mty_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCostStructure0139ListVO[]
	 */
	public SearchCostStructure0139ListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchCostStructure0139ListVO[]
	 */
	public SearchCostStructure0139ListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchCostStructure0139ListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fdrRcvTermCd = (JSPUtil.getParameter(request, prefix	+ "fdr_rcv_term_cd", length));
			String[] orgLocCd = (JSPUtil.getParameter(request, prefix	+ "org_loc_cd", length));
			String[] destLocCd = (JSPUtil.getParameter(request, prefix	+ "dest_loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fdrDeTermCd = (JSPUtil.getParameter(request, prefix	+ "fdr_de_term_cd", length));
			String[] fullMtyCd = (JSPUtil.getParameter(request, prefix	+ "full_mty_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchCostStructure0139ListVO();
				if (fdrRcvTermCd[i] != null)
					model.setFdrRcvTermCd(fdrRcvTermCd[i]);
				if (orgLocCd[i] != null)
					model.setOrgLocCd(orgLocCd[i]);
				if (destLocCd[i] != null)
					model.setDestLocCd(destLocCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fdrDeTermCd[i] != null)
					model.setFdrDeTermCd(fdrDeTermCd[i]);
				if (fullMtyCd[i] != null)
					model.setFullMtyCd(fullMtyCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchCostStructure0139ListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchCostStructure0139ListVO[]
	 */
	public SearchCostStructure0139ListVO[] getSearchCostStructure0139ListVOs(){
		SearchCostStructure0139ListVO[] vos = (SearchCostStructure0139ListVO[])models.toArray(new SearchCostStructure0139ListVO[models.size()]);
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
		this.fdrRcvTermCd = this.fdrRcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgLocCd = this.orgLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destLocCd = this.destLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrDeTermCd = this.fdrDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullMtyCd = this.fullMtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

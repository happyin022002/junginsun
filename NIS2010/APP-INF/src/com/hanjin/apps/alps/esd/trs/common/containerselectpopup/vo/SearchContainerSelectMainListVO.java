/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchContainerSelectMainListVO.java
*@FileTitle : SearchContainerSelectMainListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 조풍연
*@LastVersion : 1.0
* 2009.07.28 조풍연 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.common.containerselectpopup.vo;

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
 * @author 조풍연
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchContainerSelectMainListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchContainerSelectMainListVO> models = new ArrayList<SearchContainerSelectMainListVO>();
	
	/* Column Info */
	private String trspWoSeq = null;
	/* Column Info */
	private String troSeq = null;
	/* Column Info */
	private String orgBkgNo = null;
	/* Column Info */
	private String trspSoSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String trspSoOfcCtyCd = null;
	/* Column Info */
	private String trspWoOfcCtyCd = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String rvisTroSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String trspSoOfcCtyCdSeq = null;
	/* Column Info */
	private String trspWoOfcCtyCdSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchContainerSelectMainListVO() {}

	public SearchContainerSelectMainListVO(String ibflag, String pagerows, String bkgNo, String troSeq, String trspSoOfcCtyCd, String trspSoSeq, String trspSoOfcCtyCdSeq, String trspWoOfcCtyCd, String trspWoSeq, String trspWoOfcCtyCdSeq, String eqTpszCd, String orgBkgNo, String rvisTroSeq) {
		this.trspWoSeq = trspWoSeq;
		this.troSeq = troSeq;
		this.orgBkgNo = orgBkgNo;
		this.trspSoSeq = trspSoSeq;
		this.pagerows = pagerows;
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
		this.trspWoOfcCtyCd = trspWoOfcCtyCd;
		this.eqTpszCd = eqTpszCd;
		this.rvisTroSeq = rvisTroSeq;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.trspSoOfcCtyCdSeq = trspSoOfcCtyCdSeq;
		this.trspWoOfcCtyCdSeq = trspWoOfcCtyCdSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("trsp_wo_seq", getTrspWoSeq());
		this.hashColumns.put("tro_seq", getTroSeq());
		this.hashColumns.put("org_bkg_no", getOrgBkgNo());
		this.hashColumns.put("trsp_so_seq", getTrspSoSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("trsp_so_ofc_cty_cd", getTrspSoOfcCtyCd());
		this.hashColumns.put("trsp_wo_ofc_cty_cd", getTrspWoOfcCtyCd());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("rvis_tro_seq", getRvisTroSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("trsp_so_ofc_cty_cd_seq", getTrspSoOfcCtyCdSeq());
		this.hashColumns.put("trsp_wo_ofc_cty_cd_seq", getTrspWoOfcCtyCdSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("trsp_wo_seq", "trspWoSeq");
		this.hashFields.put("tro_seq", "troSeq");
		this.hashFields.put("org_bkg_no", "orgBkgNo");
		this.hashFields.put("trsp_so_seq", "trspSoSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("trsp_so_ofc_cty_cd", "trspSoOfcCtyCd");
		this.hashFields.put("trsp_wo_ofc_cty_cd", "trspWoOfcCtyCd");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("rvis_tro_seq", "rvisTroSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("trsp_so_ofc_cty_cd_seq", "trspSoOfcCtyCdSeq");
		this.hashFields.put("trsp_wo_ofc_cty_cd_seq", "trspWoOfcCtyCdSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return trspWoSeq
	 */
	public String getTrspWoSeq() {
		return this.trspWoSeq;
	}
	
	/**
	 * Column Info
	 * @return troSeq
	 */
	public String getTroSeq() {
		return this.troSeq;
	}
	
	/**
	 * Column Info
	 * @return orgBkgNo
	 */
	public String getOrgBkgNo() {
		return this.orgBkgNo;
	}
	
	/**
	 * Column Info
	 * @return trspSoSeq
	 */
	public String getTrspSoSeq() {
		return this.trspSoSeq;
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
	 * @return trspSoOfcCtyCd
	 */
	public String getTrspSoOfcCtyCd() {
		return this.trspSoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return trspWoOfcCtyCd
	 */
	public String getTrspWoOfcCtyCd() {
		return this.trspWoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @return rvisTroSeq
	 */
	public String getRvisTroSeq() {
		return this.rvisTroSeq;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return trspSoOfcCtyCdSeq
	 */
	public String getTrspSoOfcCtyCdSeq() {
		return this.trspSoOfcCtyCdSeq;
	}
	
	/**
	 * Column Info
	 * @return trspWoOfcCtyCdSeq
	 */
	public String getTrspWoOfcCtyCdSeq() {
		return this.trspWoOfcCtyCdSeq;
	}
	

	/**
	 * Column Info
	 * @param trspWoSeq
	 */
	public void setTrspWoSeq(String trspWoSeq) {
		this.trspWoSeq = trspWoSeq;
	}
	
	/**
	 * Column Info
	 * @param troSeq
	 */
	public void setTroSeq(String troSeq) {
		this.troSeq = troSeq;
	}
	
	/**
	 * Column Info
	 * @param orgBkgNo
	 */
	public void setOrgBkgNo(String orgBkgNo) {
		this.orgBkgNo = orgBkgNo;
	}
	
	/**
	 * Column Info
	 * @param trspSoSeq
	 */
	public void setTrspSoSeq(String trspSoSeq) {
		this.trspSoSeq = trspSoSeq;
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
	 * @param trspSoOfcCtyCd
	 */
	public void setTrspSoOfcCtyCd(String trspSoOfcCtyCd) {
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param trspWoOfcCtyCd
	 */
	public void setTrspWoOfcCtyCd(String trspWoOfcCtyCd) {
		this.trspWoOfcCtyCd = trspWoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @param rvisTroSeq
	 */
	public void setRvisTroSeq(String rvisTroSeq) {
		this.rvisTroSeq = rvisTroSeq;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param trspSoOfcCtyCdSeq
	 */
	public void setTrspSoOfcCtyCdSeq(String trspSoOfcCtyCdSeq) {
		this.trspSoOfcCtyCdSeq = trspSoOfcCtyCdSeq;
	}
	
	/**
	 * Column Info
	 * @param trspWoOfcCtyCdSeq
	 */
	public void setTrspWoOfcCtyCdSeq(String trspWoOfcCtyCdSeq) {
		this.trspWoOfcCtyCdSeq = trspWoOfcCtyCdSeq;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTrspWoSeq(JSPUtil.getParameter(request, "trsp_wo_seq", ""));
		setTroSeq(JSPUtil.getParameter(request, "tro_seq", ""));
		setOrgBkgNo(JSPUtil.getParameter(request, "org_bkg_no", ""));
		setTrspSoSeq(JSPUtil.getParameter(request, "trsp_so_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setTrspSoOfcCtyCd(JSPUtil.getParameter(request, "trsp_so_ofc_cty_cd", ""));
		setTrspWoOfcCtyCd(JSPUtil.getParameter(request, "trsp_wo_ofc_cty_cd", ""));
		setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd", ""));
		setRvisTroSeq(JSPUtil.getParameter(request, "rvis_tro_seq", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setTrspSoOfcCtyCdSeq(JSPUtil.getParameter(request, "trsp_so_ofc_cty_cd_seq", ""));
		setTrspWoOfcCtyCdSeq(JSPUtil.getParameter(request, "trsp_wo_ofc_cty_cd_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchContainerSelectMainListVO[]
	 */
	public SearchContainerSelectMainListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchContainerSelectMainListVO[]
	 */
	public SearchContainerSelectMainListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchContainerSelectMainListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] trspWoSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_wo_seq", length));
			String[] troSeq = (JSPUtil.getParameter(request, prefix	+ "tro_seq", length));
			String[] orgBkgNo = (JSPUtil.getParameter(request, prefix	+ "org_bkg_no", length));
			String[] trspSoSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_so_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] trspSoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_ofc_cty_cd", length));
			String[] trspWoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_wo_ofc_cty_cd", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] rvisTroSeq = (JSPUtil.getParameter(request, prefix	+ "rvis_tro_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] trspSoOfcCtyCdSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_so_ofc_cty_cd_seq", length));
			String[] trspWoOfcCtyCdSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_wo_ofc_cty_cd_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchContainerSelectMainListVO();
				if (trspWoSeq[i] != null)
					model.setTrspWoSeq(trspWoSeq[i]);
				if (troSeq[i] != null)
					model.setTroSeq(troSeq[i]);
				if (orgBkgNo[i] != null)
					model.setOrgBkgNo(orgBkgNo[i]);
				if (trspSoSeq[i] != null)
					model.setTrspSoSeq(trspSoSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (trspSoOfcCtyCd[i] != null)
					model.setTrspSoOfcCtyCd(trspSoOfcCtyCd[i]);
				if (trspWoOfcCtyCd[i] != null)
					model.setTrspWoOfcCtyCd(trspWoOfcCtyCd[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (rvisTroSeq[i] != null)
					model.setRvisTroSeq(rvisTroSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (trspSoOfcCtyCdSeq[i] != null)
					model.setTrspSoOfcCtyCdSeq(trspSoOfcCtyCdSeq[i]);
				if (trspWoOfcCtyCdSeq[i] != null)
					model.setTrspWoOfcCtyCdSeq(trspWoOfcCtyCdSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchContainerSelectMainListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchContainerSelectMainListVO[]
	 */
	public SearchContainerSelectMainListVO[] getSearchContainerSelectMainListVOs(){
		SearchContainerSelectMainListVO[] vos = (SearchContainerSelectMainListVO[])models.toArray(new SearchContainerSelectMainListVO[models.size()]);
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
		this.trspWoSeq = this.trspWoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troSeq = this.troSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgBkgNo = this.orgBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoSeq = this.trspSoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoOfcCtyCd = this.trspSoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspWoOfcCtyCd = this.trspWoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisTroSeq = this.rvisTroSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoOfcCtyCdSeq = this.trspSoOfcCtyCdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspWoOfcCtyCdSeq = this.trspWoOfcCtyCdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

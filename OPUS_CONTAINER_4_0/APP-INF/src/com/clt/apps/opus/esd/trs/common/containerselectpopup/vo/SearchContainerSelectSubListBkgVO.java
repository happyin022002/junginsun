/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchContainerSelectSubListBkgVO.java
*@FileTitle : SearchContainerSelectSubListBkgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 조풍연
*@LastVersion : 1.0
* 2009.07.28 조풍연 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.trs.common.containerselectpopup.vo;

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
 * @author 조풍연
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchContainerSelectSubListBkgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchContainerSelectSubListBkgVO> models = new ArrayList<SearchContainerSelectSubListBkgVO>();
	
	/* Column Info */
	private String applySoSeq = null;
	/* Column Info */
	private String orgApplySoSeq = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String dupCheck = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchContainerSelectSubListBkgVO() {}

	public SearchContainerSelectSubListBkgVO(String ibflag, String pagerows, String bkgNo, String bkgStsCd, String eqNo, String eqTpszCd, String dupCheck, String applySoSeq, String orgApplySoSeq) {
		this.applySoSeq = applySoSeq;
		this.orgApplySoSeq = orgApplySoSeq;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.bkgStsCd = bkgStsCd;
		this.dupCheck = dupCheck;
		this.eqTpszCd = eqTpszCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("apply_so_seq", getApplySoSeq());
		this.hashColumns.put("org_apply_so_seq", getOrgApplySoSeq());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("dup_check", getDupCheck());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("apply_so_seq", "applySoSeq");
		this.hashFields.put("org_apply_so_seq", "orgApplySoSeq");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("dup_check", "dupCheck");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return applySoSeq
	 */
	public String getApplySoSeq() {
		return this.applySoSeq;
	}
	
	/**
	 * Column Info
	 * @return orgApplySoSeq
	 */
	public String getOrgApplySoSeq() {
		return this.orgApplySoSeq;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @return dupCheck
	 */
	public String getDupCheck() {
		return this.dupCheck;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
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
	 * @param applySoSeq
	 */
	public void setApplySoSeq(String applySoSeq) {
		this.applySoSeq = applySoSeq;
	}
	
	/**
	 * Column Info
	 * @param orgApplySoSeq
	 */
	public void setOrgApplySoSeq(String orgApplySoSeq) {
		this.orgApplySoSeq = orgApplySoSeq;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @param dupCheck
	 */
	public void setDupCheck(String dupCheck) {
		this.dupCheck = dupCheck;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
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
		setApplySoSeq(JSPUtil.getParameter(request, "apply_so_seq", ""));
		setOrgApplySoSeq(JSPUtil.getParameter(request, "org_apply_so_seq", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setBkgStsCd(JSPUtil.getParameter(request, "bkg_sts_cd", ""));
		setDupCheck(JSPUtil.getParameter(request, "dup_check", ""));
		setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchContainerSelectSubListBkgVO[]
	 */
	public SearchContainerSelectSubListBkgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchContainerSelectSubListBkgVO[]
	 */
	public SearchContainerSelectSubListBkgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchContainerSelectSubListBkgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] applySoSeq = (JSPUtil.getParameter(request, prefix	+ "apply_so_seq", length));
			String[] orgApplySoSeq = (JSPUtil.getParameter(request, prefix	+ "org_apply_so_seq", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] dupCheck = (JSPUtil.getParameter(request, prefix	+ "dup_check", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchContainerSelectSubListBkgVO();
				if (applySoSeq[i] != null)
					model.setApplySoSeq(applySoSeq[i]);
				if (orgApplySoSeq[i] != null)
					model.setOrgApplySoSeq(orgApplySoSeq[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (dupCheck[i] != null)
					model.setDupCheck(dupCheck[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchContainerSelectSubListBkgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchContainerSelectSubListBkgVO[]
	 */
	public SearchContainerSelectSubListBkgVO[] getSearchContainerSelectSubListBkgVOs(){
		SearchContainerSelectSubListBkgVO[] vos = (SearchContainerSelectSubListBkgVO[])models.toArray(new SearchContainerSelectSubListBkgVO[models.size()]);
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
		this.applySoSeq = this.applySoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgApplySoSeq = this.orgApplySoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dupCheck = this.dupCheck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

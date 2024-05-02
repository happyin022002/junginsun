/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchOfficeListForInquiryVO.java
*@FileTitle : SearchOfficeListForInquiryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 황건하
*@LastVersion : 1.0
* 2009.07.20 황건하 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.tpb.masterdatamanage.officemanage.vo;

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
 * @author 황건하
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchOfficeListForInquiryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchOfficeListForInquiryVO> models = new ArrayList<SearchOfficeListForInquiryVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String n3ptyOfcCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String n3ptyCtrlOfcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String sOfcCd = null;
	/* Column Info */
	private String n3ptyArOfcCd = null;
	/* Column Info */
	private String sIfOfcCd = null;
	/* Column Info */
	private String sIfRhqCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchOfficeListForInquiryVO() {}

	public SearchOfficeListForInquiryVO(String ibflag, String pagerows, String ofcCd, String n3ptyOfcCd, String rhqCd, String n3ptyCtrlOfcCd, String n3ptyArOfcCd, String updUsrId, String updDt, String sIfRhqCd, String sIfOfcCd, String sOfcCd) {
		this.updDt = updDt;
		this.n3ptyOfcCd = n3ptyOfcCd;
		this.ofcCd = ofcCd;
		this.n3ptyCtrlOfcCd = n3ptyCtrlOfcCd;
		this.ibflag = ibflag;
		this.rhqCd = rhqCd;
		this.sOfcCd = sOfcCd;
		this.n3ptyArOfcCd = n3ptyArOfcCd;
		this.sIfOfcCd = sIfOfcCd;
		this.sIfRhqCd = sIfRhqCd;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("n3pty_ofc_cd", getN3ptyOfcCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("n3pty_ctrl_ofc_cd", getN3ptyCtrlOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("s_ofc_cd", getSOfcCd());
		this.hashColumns.put("n3pty_ar_ofc_cd", getN3ptyArOfcCd());
		this.hashColumns.put("s_if_ofc_cd", getSIfOfcCd());
		this.hashColumns.put("s_if_rhq_cd", getSIfRhqCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("n3pty_ofc_cd", "n3ptyOfcCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("n3pty_ctrl_ofc_cd", "n3ptyCtrlOfcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("s_ofc_cd", "sOfcCd");
		this.hashFields.put("n3pty_ar_ofc_cd", "n3ptyArOfcCd");
		this.hashFields.put("s_if_ofc_cd", "sIfOfcCd");
		this.hashFields.put("s_if_rhq_cd", "sIfRhqCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return n3ptyOfcCd
	 */
	public String getN3ptyOfcCd() {
		return this.n3ptyOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptyCtrlOfcCd
	 */
	public String getN3ptyCtrlOfcCd() {
		return this.n3ptyCtrlOfcCd;
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
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return sOfcCd
	 */
	public String getSOfcCd() {
		return this.sOfcCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptyArOfcCd
	 */
	public String getN3ptyArOfcCd() {
		return this.n3ptyArOfcCd;
	}
	
	/**
	 * Column Info
	 * @return sIfOfcCd
	 */
	public String getSIfOfcCd() {
		return this.sIfOfcCd;
	}
	
	/**
	 * Column Info
	 * @return sIfRhqCd
	 */
	public String getSIfRhqCd() {
		return this.sIfRhqCd;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param n3ptyOfcCd
	 */
	public void setN3ptyOfcCd(String n3ptyOfcCd) {
		this.n3ptyOfcCd = n3ptyOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptyCtrlOfcCd
	 */
	public void setN3ptyCtrlOfcCd(String n3ptyCtrlOfcCd) {
		this.n3ptyCtrlOfcCd = n3ptyCtrlOfcCd;
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
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param sOfcCd
	 */
	public void setSOfcCd(String sOfcCd) {
		this.sOfcCd = sOfcCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptyArOfcCd
	 */
	public void setN3ptyArOfcCd(String n3ptyArOfcCd) {
		this.n3ptyArOfcCd = n3ptyArOfcCd;
	}
	
	/**
	 * Column Info
	 * @param sIfOfcCd
	 */
	public void setSIfOfcCd(String sIfOfcCd) {
		this.sIfOfcCd = sIfOfcCd;
	}
	
	/**
	 * Column Info
	 * @param sIfRhqCd
	 */
	public void setSIfRhqCd(String sIfRhqCd) {
		this.sIfRhqCd = sIfRhqCd;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setN3ptyOfcCd(JSPUtil.getParameter(request, "n3pty_ofc_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setN3ptyCtrlOfcCd(JSPUtil.getParameter(request, "n3pty_ctrl_ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRhqCd(JSPUtil.getParameter(request, "rhq_cd", ""));
		setSOfcCd(JSPUtil.getParameter(request, "s_ofc_cd", ""));
		setN3ptyArOfcCd(JSPUtil.getParameter(request, "n3pty_ar_ofc_cd", ""));
		setSIfOfcCd(JSPUtil.getParameter(request, "s_if_ofc_cd", ""));
		setSIfRhqCd(JSPUtil.getParameter(request, "s_if_rhq_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchOfficeListForInquiryVO[]
	 */
	public SearchOfficeListForInquiryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchOfficeListForInquiryVO[]
	 */
	public SearchOfficeListForInquiryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchOfficeListForInquiryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] n3ptyOfcCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_ofc_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] n3ptyCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_ctrl_ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] sOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_ofc_cd", length));
			String[] n3ptyArOfcCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_ar_ofc_cd", length));
			String[] sIfOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_if_ofc_cd", length));
			String[] sIfRhqCd = (JSPUtil.getParameter(request, prefix	+ "s_if_rhq_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchOfficeListForInquiryVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (n3ptyOfcCd[i] != null)
					model.setN3ptyOfcCd(n3ptyOfcCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (n3ptyCtrlOfcCd[i] != null)
					model.setN3ptyCtrlOfcCd(n3ptyCtrlOfcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (sOfcCd[i] != null)
					model.setSOfcCd(sOfcCd[i]);
				if (n3ptyArOfcCd[i] != null)
					model.setN3ptyArOfcCd(n3ptyArOfcCd[i]);
				if (sIfOfcCd[i] != null)
					model.setSIfOfcCd(sIfOfcCd[i]);
				if (sIfRhqCd[i] != null)
					model.setSIfRhqCd(sIfRhqCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchOfficeListForInqiuryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchOfficeListForInquiryVO[]
	 */
	public SearchOfficeListForInquiryVO[] getSearchOfficeListForInqiuryVOs(){
		SearchOfficeListForInquiryVO[] vos = (SearchOfficeListForInquiryVO[])models.toArray(new SearchOfficeListForInquiryVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyOfcCd = this.n3ptyOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCtrlOfcCd = this.n3ptyCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOfcCd = this.sOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyArOfcCd = this.n3ptyArOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIfOfcCd = this.sIfOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIfRhqCd = this.sIfRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

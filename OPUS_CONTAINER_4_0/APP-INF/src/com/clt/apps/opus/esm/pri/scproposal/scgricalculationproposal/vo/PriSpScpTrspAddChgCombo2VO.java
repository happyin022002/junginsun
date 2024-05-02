/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PriSpScpTrspAddChgCombo2VO.java
*@FileTitle : PriSpScpTrspAddChgCombo2VO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.13
*@LastModifier : 서호열
*@LastVersion : 1.0
* 2009.07.13 서호열 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.scproposal.scgricalculationproposal.vo;

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
 * @author 서호열
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PriSpScpTrspAddChgCombo2VO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PriSpScpTrspAddChgCombo2VO> models = new ArrayList<PriSpScpTrspAddChgCombo2VO>();
	
	/* Column Info */
	private String addChgTpCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String prcCgoTpCd = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String orgDestTpCd = null;
	/* Column Info */
	private String ratUtCdNm = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String prcCgoTpCdNm = null;
	/* Column Info */
	private String n1stCmncDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PriSpScpTrspAddChgCombo2VO() {}

	public PriSpScpTrspAddChgCombo2VO(String ibflag, String pagerows, String propNo, String amdtSeq, String svcScpCd, String addChgTpCd, String orgDestTpCd, String ratUtCd, String ratUtCdNm, String prcCgoTpCd, String prcCgoTpCdNm, String currCd, String n1stCmncDt) {
		this.addChgTpCd = addChgTpCd;
		this.currCd = currCd;
		this.prcCgoTpCd = prcCgoTpCd;
		this.amdtSeq = amdtSeq;
		this.svcScpCd = svcScpCd;
		this.orgDestTpCd = orgDestTpCd;
		this.ratUtCdNm = ratUtCdNm;
		this.ratUtCd = ratUtCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.propNo = propNo;
		this.prcCgoTpCdNm = prcCgoTpCdNm;
		this.n1stCmncDt = n1stCmncDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("add_chg_tp_cd", getAddChgTpCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("prc_cgo_tp_cd", getPrcCgoTpCd());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("org_dest_tp_cd", getOrgDestTpCd());
		this.hashColumns.put("rat_ut_cd_nm", getRatUtCdNm());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("prc_cgo_tp_cd_nm", getPrcCgoTpCdNm());
		this.hashColumns.put("n1st_cmnc_dt", getN1stCmncDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("add_chg_tp_cd", "addChgTpCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("prc_cgo_tp_cd", "prcCgoTpCd");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("org_dest_tp_cd", "orgDestTpCd");
		this.hashFields.put("rat_ut_cd_nm", "ratUtCdNm");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("prc_cgo_tp_cd_nm", "prcCgoTpCdNm");
		this.hashFields.put("n1st_cmnc_dt", "n1stCmncDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return addChgTpCd
	 */
	public String getAddChgTpCd() {
		return this.addChgTpCd;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return prcCgoTpCd
	 */
	public String getPrcCgoTpCd() {
		return this.prcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return orgDestTpCd
	 */
	public String getOrgDestTpCd() {
		return this.orgDestTpCd;
	}
	
	/**
	 * Column Info
	 * @return ratUtCdNm
	 */
	public String getRatUtCdNm() {
		return this.ratUtCdNm;
	}
	
	/**
	 * Column Info
	 * @return ratUtCd
	 */
	public String getRatUtCd() {
		return this.ratUtCd;
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
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return prcCgoTpCdNm
	 */
	public String getPrcCgoTpCdNm() {
		return this.prcCgoTpCdNm;
	}
	
	/**
	 * Column Info
	 * @return n1stCmncDt
	 */
	public String getN1stCmncDt() {
		return this.n1stCmncDt;
	}
	

	/**
	 * Column Info
	 * @param addChgTpCd
	 */
	public void setAddChgTpCd(String addChgTpCd) {
		this.addChgTpCd = addChgTpCd;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param prcCgoTpCd
	 */
	public void setPrcCgoTpCd(String prcCgoTpCd) {
		this.prcCgoTpCd = prcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param orgDestTpCd
	 */
	public void setOrgDestTpCd(String orgDestTpCd) {
		this.orgDestTpCd = orgDestTpCd;
	}
	
	/**
	 * Column Info
	 * @param ratUtCdNm
	 */
	public void setRatUtCdNm(String ratUtCdNm) {
		this.ratUtCdNm = ratUtCdNm;
	}
	
	/**
	 * Column Info
	 * @param ratUtCd
	 */
	public void setRatUtCd(String ratUtCd) {
		this.ratUtCd = ratUtCd;
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
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param prcCgoTpCdNm
	 */
	public void setPrcCgoTpCdNm(String prcCgoTpCdNm) {
		this.prcCgoTpCdNm = prcCgoTpCdNm;
	}
	
	/**
	 * Column Info
	 * @param n1stCmncDt
	 */
	public void setN1stCmncDt(String n1stCmncDt) {
		this.n1stCmncDt = n1stCmncDt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setAddChgTpCd(JSPUtil.getParameter(request, "add_chg_tp_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setPrcCgoTpCd(JSPUtil.getParameter(request, "prc_cgo_tp_cd", ""));
		setAmdtSeq(JSPUtil.getParameter(request, "amdt_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setOrgDestTpCd(JSPUtil.getParameter(request, "org_dest_tp_cd", ""));
		setRatUtCdNm(JSPUtil.getParameter(request, "rat_ut_cd_nm", ""));
		setRatUtCd(JSPUtil.getParameter(request, "rat_ut_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
		setPrcCgoTpCdNm(JSPUtil.getParameter(request, "prc_cgo_tp_cd_nm", ""));
		setN1stCmncDt(JSPUtil.getParameter(request, "n1st_cmnc_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PriSpScpTrspAddChgCombo2VO[]
	 */
	public PriSpScpTrspAddChgCombo2VO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PriSpScpTrspAddChgCombo2VO[]
	 */
	public PriSpScpTrspAddChgCombo2VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PriSpScpTrspAddChgCombo2VO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] addChgTpCd = (JSPUtil.getParameter(request, prefix	+ "add_chg_tp_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] prcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_cgo_tp_cd", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] orgDestTpCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_tp_cd", length));
			String[] ratUtCdNm = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd_nm", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] prcCgoTpCdNm = (JSPUtil.getParameter(request, prefix	+ "prc_cgo_tp_cd_nm", length));
			String[] n1stCmncDt = (JSPUtil.getParameter(request, prefix	+ "n1st_cmnc_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new PriSpScpTrspAddChgCombo2VO();
				if (addChgTpCd[i] != null)
					model.setAddChgTpCd(addChgTpCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (prcCgoTpCd[i] != null)
					model.setPrcCgoTpCd(prcCgoTpCd[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (orgDestTpCd[i] != null)
					model.setOrgDestTpCd(orgDestTpCd[i]);
				if (ratUtCdNm[i] != null)
					model.setRatUtCdNm(ratUtCdNm[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (prcCgoTpCdNm[i] != null)
					model.setPrcCgoTpCdNm(prcCgoTpCdNm[i]);
				if (n1stCmncDt[i] != null)
					model.setN1stCmncDt(n1stCmncDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPriSpScpTrspAddChgCombo2VOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PriSpScpTrspAddChgCombo2VO[]
	 */
	public PriSpScpTrspAddChgCombo2VO[] getPriSpScpTrspAddChgCombo2VOs(){
		PriSpScpTrspAddChgCombo2VO[] vos = (PriSpScpTrspAddChgCombo2VO[])models.toArray(new PriSpScpTrspAddChgCombo2VO[models.size()]);
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
		this.addChgTpCd = this.addChgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCgoTpCd = this.prcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestTpCd = this.orgDestTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCdNm = this.ratUtCdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCgoTpCdNm = this.prcCgoTpCdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stCmncDt = this.n1stCmncDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchInterfacedCancelListVO.java
*@FileTitle : SearchInterfacedCancelListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-16
*@LastModifier : 변종건
*@LastVersion : 1.0
* 2009-09-16 Jong-Geon Byeon	1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.tpb.candidatemanage.interfacedcancel.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 변종건
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchInterfacedCancelListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchInterfacedCancelListVO> models = new ArrayList<SearchInterfacedCancelListVO>();
	
	/* Column Info */
	private String soNo = null;
	/* Column Info */
	private String invAmtUsd = null;
	/* Column Info */
	private String orgIfDt = null;
	/* Column Info */
	private String sIfOfcCd = null;
	/* Column Info */
	private String cxlIfDt = null;
	/* Column Info */
	private String sIfCtrlCd = null;
	/* Column Info */
	private String otsAmtUsd = null;
	/* Column Info */
	private String editable = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String grpFlg = null;
	/* Column Info */
	private String n3ptyNo = null;
	/* Column Info */
	private String sIsNoticeOnly = null;
	/* Column Info */
	private String sUsrOfcCd = null;
	/* Column Info */
	private String cxlSeq = null;
	/* Column Info */
	private String ifAmtUsd = null;
	/* Column Info */
	private String otsSts = null;
	/* Column Info */
	private String sIfRhqCd = null;
	/* Column Info */
	private String orgSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchInterfacedCancelListVO() {}

	public SearchInterfacedCancelListVO(String ibflag, String pagerows, String ofcCd, String soNo, String ifAmtUsd, String orgIfDt, String cxlIfDt, String otsSts, String otsAmtUsd, String invAmtUsd, String grpFlg, String orgSeq, String cxlSeq, String n3ptyNo, String editable, String sIfRhqCd, String sIfCtrlCd, String sIfOfcCd, String sUsrOfcCd, String creUsrId, String sIsNoticeOnly) {
		this.soNo = soNo;
		this.invAmtUsd = invAmtUsd;
		this.orgIfDt = orgIfDt;
		this.sIfOfcCd = sIfOfcCd;
		this.cxlIfDt = cxlIfDt;
		this.sIfCtrlCd = sIfCtrlCd;
		this.otsAmtUsd = otsAmtUsd;
		this.editable = editable;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.grpFlg = grpFlg;
		this.n3ptyNo = n3ptyNo;
		this.sIsNoticeOnly = sIsNoticeOnly;
		this.sUsrOfcCd = sUsrOfcCd;
		this.cxlSeq = cxlSeq;
		this.ifAmtUsd = ifAmtUsd;
		this.otsSts = otsSts;
		this.sIfRhqCd = sIfRhqCd;
		this.orgSeq = orgSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("so_no", getSoNo());
		this.hashColumns.put("inv_amt_usd", getInvAmtUsd());
		this.hashColumns.put("org_if_dt", getOrgIfDt());
		this.hashColumns.put("s_if_ofc_cd", getSIfOfcCd());
		this.hashColumns.put("cxl_if_dt", getCxlIfDt());
		this.hashColumns.put("s_if_ctrl_cd", getSIfCtrlCd());
		this.hashColumns.put("ots_amt_usd", getOtsAmtUsd());
		this.hashColumns.put("editable", getEditable());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("grp_flg", getGrpFlg());
		this.hashColumns.put("n3pty_no", getN3ptyNo());
		this.hashColumns.put("s_isNoticeOnly", getSIsNoticeOnly());
		this.hashColumns.put("s_usr_ofc_cd", getSUsrOfcCd());
		this.hashColumns.put("cxl_seq", getCxlSeq());
		this.hashColumns.put("if_amt_usd", getIfAmtUsd());
		this.hashColumns.put("ots_sts", getOtsSts());
		this.hashColumns.put("s_if_rhq_cd", getSIfRhqCd());
		this.hashColumns.put("org_seq", getOrgSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("so_no", "soNo");
		this.hashFields.put("inv_amt_usd", "invAmtUsd");
		this.hashFields.put("org_if_dt", "orgIfDt");
		this.hashFields.put("s_if_ofc_cd", "sIfOfcCd");
		this.hashFields.put("cxl_if_dt", "cxlIfDt");
		this.hashFields.put("s_if_ctrl_cd", "sIfCtrlCd");
		this.hashFields.put("ots_amt_usd", "otsAmtUsd");
		this.hashFields.put("editable", "editable");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("grp_flg", "grpFlg");
		this.hashFields.put("n3pty_no", "n3ptyNo");
		this.hashFields.put("s_isNoticeOnly", "sIsNoticeOnly");
		this.hashFields.put("s_usr_ofc_cd", "sUsrOfcCd");
		this.hashFields.put("cxl_seq", "cxlSeq");
		this.hashFields.put("if_amt_usd", "ifAmtUsd");
		this.hashFields.put("ots_sts", "otsSts");
		this.hashFields.put("s_if_rhq_cd", "sIfRhqCd");
		this.hashFields.put("org_seq", "orgSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return soNo
	 */
	public String getSoNo() {
		return this.soNo;
	}
	
	/**
	 * Column Info
	 * @return invAmtUsd
	 */
	public String getInvAmtUsd() {
		return this.invAmtUsd;
	}
	
	/**
	 * Column Info
	 * @return orgIfDt
	 */
	public String getOrgIfDt() {
		return this.orgIfDt;
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
	 * @return cxlIfDt
	 */
	public String getCxlIfDt() {
		return this.cxlIfDt;
	}
	
	/**
	 * Column Info
	 * @return sIfCtrlCd
	 */
	public String getSIfCtrlCd() {
		return this.sIfCtrlCd;
	}
	
	/**
	 * Column Info
	 * @return otsAmtUsd
	 */
	public String getOtsAmtUsd() {
		return this.otsAmtUsd;
	}
	
	/**
	 * Column Info
	 * @return editable
	 */
	public String getEditable() {
		return this.editable;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return grpFlg
	 */
	public String getGrpFlg() {
		return this.grpFlg;
	}
	
	/**
	 * Column Info
	 * @return n3ptyNo
	 */
	public String getN3ptyNo() {
		return this.n3ptyNo;
	}
	
	/**
	 * Column Info
	 * @return sIsnoticeonly
	 */
	public String getSIsNoticeOnly() {
		return this.sIsNoticeOnly;
	}
	
	/**
	 * Column Info
	 * @return sUsrOfcCd
	 */
	public String getSUsrOfcCd() {
		return this.sUsrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return cxlSeq
	 */
	public String getCxlSeq() {
		return this.cxlSeq;
	}
	
	/**
	 * Column Info
	 * @return ifAmtUsd
	 */
	public String getIfAmtUsd() {
		return this.ifAmtUsd;
	}
	
	/**
	 * Column Info
	 * @return otsSts
	 */
	public String getOtsSts() {
		return this.otsSts;
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
	 * @return orgSeq
	 */
	public String getOrgSeq() {
		return this.orgSeq;
	}
	

	/**
	 * Column Info
	 * @param soNo
	 */
	public void setSoNo(String soNo) {
		this.soNo = soNo;
	}
	
	/**
	 * Column Info
	 * @param invAmtUsd
	 */
	public void setInvAmtUsd(String invAmtUsd) {
		this.invAmtUsd = invAmtUsd;
	}
	
	/**
	 * Column Info
	 * @param orgIfDt
	 */
	public void setOrgIfDt(String orgIfDt) {
		this.orgIfDt = orgIfDt;
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
	 * @param cxlIfDt
	 */
	public void setCxlIfDt(String cxlIfDt) {
		this.cxlIfDt = cxlIfDt;
	}
	
	/**
	 * Column Info
	 * @param sIfCtrlCd
	 */
	public void setSIfCtrlCd(String sIfCtrlCd) {
		this.sIfCtrlCd = sIfCtrlCd;
	}
	
	/**
	 * Column Info
	 * @param otsAmtUsd
	 */
	public void setOtsAmtUsd(String otsAmtUsd) {
		this.otsAmtUsd = otsAmtUsd;
	}
	
	/**
	 * Column Info
	 * @param editable
	 */
	public void setEditable(String editable) {
		this.editable = editable;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param grpFlg
	 */
	public void setGrpFlg(String grpFlg) {
		this.grpFlg = grpFlg;
	}
	
	/**
	 * Column Info
	 * @param n3ptyNo
	 */
	public void setN3ptyNo(String n3ptyNo) {
		this.n3ptyNo = n3ptyNo;
	}
	
	/**
	 * Column Info
	 * @param sIsnoticeonly
	 */
	public void setSIsNoticeOnly(String sIsNoticeOnly) {
		this.sIsNoticeOnly = sIsNoticeOnly;
	}
	
	/**
	 * Column Info
	 * @param sUsrOfcCd
	 */
	public void setSUsrOfcCd(String sUsrOfcCd) {
		this.sUsrOfcCd = sUsrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param cxlSeq
	 */
	public void setCxlSeq(String cxlSeq) {
		this.cxlSeq = cxlSeq;
	}
	
	/**
	 * Column Info
	 * @param ifAmtUsd
	 */
	public void setIfAmtUsd(String ifAmtUsd) {
		this.ifAmtUsd = ifAmtUsd;
	}
	
	/**
	 * Column Info
	 * @param otsSts
	 */
	public void setOtsSts(String otsSts) {
		this.otsSts = otsSts;
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
	 * @param orgSeq
	 */
	public void setOrgSeq(String orgSeq) {
		this.orgSeq = orgSeq;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSoNo(JSPUtil.getParameter(request, "so_no", ""));
		setInvAmtUsd(JSPUtil.getParameter(request, "inv_amt_usd", ""));
		setOrgIfDt(JSPUtil.getParameter(request, "org_if_dt", ""));
		setSIfOfcCd(JSPUtil.getParameter(request, "s_if_ofc_cd", ""));
		setCxlIfDt(JSPUtil.getParameter(request, "cxl_if_dt", ""));
		setSIfCtrlCd(JSPUtil.getParameter(request, "s_if_ctrl_cd", ""));
		setOtsAmtUsd(JSPUtil.getParameter(request, "ots_amt_usd", ""));
		setEditable(JSPUtil.getParameter(request, "editable", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setGrpFlg(JSPUtil.getParameter(request, "grp_flg", ""));
		setN3ptyNo(JSPUtil.getParameter(request, "n3pty_no", ""));
		setSIsNoticeOnly(JSPUtil.getParameter(request, "s_isNoticeOnly", ""));
		setSUsrOfcCd(JSPUtil.getParameter(request, "s_usr_ofc_cd", ""));
		setCxlSeq(JSPUtil.getParameter(request, "cxl_seq", ""));
		setIfAmtUsd(JSPUtil.getParameter(request, "if_amt_usd", ""));
		setOtsSts(JSPUtil.getParameter(request, "ots_sts", ""));
		setSIfRhqCd(JSPUtil.getParameter(request, "s_if_rhq_cd", ""));
		setOrgSeq(JSPUtil.getParameter(request, "org_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchInterfacedCancelListVO[]
	 */
	public SearchInterfacedCancelListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchInterfacedCancelListVO[]
	 */
	public SearchInterfacedCancelListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchInterfacedCancelListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] soNo = (JSPUtil.getParameter(request, prefix	+ "so_no", length));
			String[] invAmtUsd = (JSPUtil.getParameter(request, prefix	+ "inv_amt_usd", length));
			String[] orgIfDt = (JSPUtil.getParameter(request, prefix	+ "org_if_dt", length));
			String[] sIfOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_if_ofc_cd", length));
			String[] cxlIfDt = (JSPUtil.getParameter(request, prefix	+ "cxl_if_dt", length));
			String[] sIfCtrlCd = (JSPUtil.getParameter(request, prefix	+ "s_if_ctrl_cd", length));
			String[] otsAmtUsd = (JSPUtil.getParameter(request, prefix	+ "ots_amt_usd", length));
			String[] editable = (JSPUtil.getParameter(request, prefix	+ "editable", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] grpFlg = (JSPUtil.getParameter(request, prefix	+ "grp_flg", length));
			String[] n3ptyNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_no", length));
			String[] sIsNoticeOnly = (JSPUtil.getParameter(request, prefix	+ "s_isNoticeOnly", length));
			String[] sUsrOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_usr_ofc_cd", length));
			String[] cxlSeq = (JSPUtil.getParameter(request, prefix	+ "cxl_seq", length));
			String[] ifAmtUsd = (JSPUtil.getParameter(request, prefix	+ "if_amt_usd", length));
			String[] otsSts = (JSPUtil.getParameter(request, prefix	+ "ots_sts", length));
			String[] sIfRhqCd = (JSPUtil.getParameter(request, prefix	+ "s_if_rhq_cd", length));
			String[] orgSeq = (JSPUtil.getParameter(request, prefix	+ "org_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchInterfacedCancelListVO();
				if (soNo[i] != null)
					model.setSoNo(soNo[i]);
				if (invAmtUsd[i] != null)
					model.setInvAmtUsd(invAmtUsd[i]);
				if (orgIfDt[i] != null)
					model.setOrgIfDt(orgIfDt[i]);
				if (sIfOfcCd[i] != null)
					model.setSIfOfcCd(sIfOfcCd[i]);
				if (cxlIfDt[i] != null)
					model.setCxlIfDt(cxlIfDt[i]);
				if (sIfCtrlCd[i] != null)
					model.setSIfCtrlCd(sIfCtrlCd[i]);
				if (otsAmtUsd[i] != null)
					model.setOtsAmtUsd(otsAmtUsd[i]);
				if (editable[i] != null)
					model.setEditable(editable[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (grpFlg[i] != null)
					model.setGrpFlg(grpFlg[i]);
				if (n3ptyNo[i] != null)
					model.setN3ptyNo(n3ptyNo[i]);
				if (sIsNoticeOnly[i] != null)
					model.setSIsNoticeOnly(sIsNoticeOnly[i]);
				if (sUsrOfcCd[i] != null)
					model.setSUsrOfcCd(sUsrOfcCd[i]);
				if (cxlSeq[i] != null)
					model.setCxlSeq(cxlSeq[i]);
				if (ifAmtUsd[i] != null)
					model.setIfAmtUsd(ifAmtUsd[i]);
				if (otsSts[i] != null)
					model.setOtsSts(otsSts[i]);
				if (sIfRhqCd[i] != null)
					model.setSIfRhqCd(sIfRhqCd[i]);
				if (orgSeq[i] != null)
					model.setOrgSeq(orgSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchInterfacedCancelListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchInterfacedCancelListVO[]
	 */
	public SearchInterfacedCancelListVO[] getSearchInterfacedCancelListVOs(){
		SearchInterfacedCancelListVO[] vos = (SearchInterfacedCancelListVO[])models.toArray(new SearchInterfacedCancelListVO[models.size()]);
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
		this.soNo = this.soNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmtUsd = this.invAmtUsd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgIfDt = this.orgIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIfOfcCd = this.sIfOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlIfDt = this.cxlIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIfCtrlCd = this.sIfCtrlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsAmtUsd = this.otsAmtUsd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.editable = this.editable .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpFlg = this.grpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyNo = this.n3ptyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIsNoticeOnly = this.sIsNoticeOnly .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sUsrOfcCd = this.sUsrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlSeq = this.cxlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifAmtUsd = this.ifAmtUsd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsSts = this.otsSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIfRhqCd = this.sIfRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSeq = this.orgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltPriSpScpTrspAddChgGriArbOKCLSubListVO.java
*@FileTitle : RsltPriSpScpTrspAddChgGriArbOKCLSubListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.30
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.08.30 김대호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo;

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
 * @author 김대호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltPriSpScpTrspAddChgGriArbOKCLSubListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPriSpScpTrspAddChgGriArbOKCLSubListVO> models = new ArrayList<RsltPriSpScpTrspAddChgGriArbOKCLSubListVO>();
	
	/* Column Info */
	private String griRtAmt = null;
	/* Column Info */
	private String fltPctTpCd = null;
	/* Column Info */
	private String griAdjSeq = null;
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
	private String ratUtCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String griGrpSeq = null;
	/* Column Info */
	private String griRtRto = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPriSpScpTrspAddChgGriArbOKCLSubListVO() {}

	public RsltPriSpScpTrspAddChgGriArbOKCLSubListVO(String ibflag, String pagerows, String propNo, String amdtSeq, String svcScpCd, String orgDestTpCd, String griGrpSeq, String griAdjSeq, String ratUtCd, String prcCgoTpCd, String currCd, String griRtAmt, String griRtRto, String fltPctTpCd, String updUsrId) {
		this.griRtAmt = griRtAmt;
		this.fltPctTpCd = fltPctTpCd;
		this.griAdjSeq = griAdjSeq;
		this.currCd = currCd;
		this.prcCgoTpCd = prcCgoTpCd;
		this.amdtSeq = amdtSeq;
		this.svcScpCd = svcScpCd;
		this.orgDestTpCd = orgDestTpCd;
		this.ratUtCd = ratUtCd;
		this.pagerows = pagerows;
		this.griGrpSeq = griGrpSeq;
		this.griRtRto = griRtRto;
		this.ibflag = ibflag;
		this.propNo = propNo;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("gri_rt_amt", getGriRtAmt());
		this.hashColumns.put("flt_pct_tp_cd", getFltPctTpCd());
		this.hashColumns.put("gri_adj_seq", getGriAdjSeq());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("prc_cgo_tp_cd", getPrcCgoTpCd());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("org_dest_tp_cd", getOrgDestTpCd());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("gri_grp_seq", getGriGrpSeq());
		this.hashColumns.put("gri_rt_rto", getGriRtRto());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("gri_rt_amt", "griRtAmt");
		this.hashFields.put("flt_pct_tp_cd", "fltPctTpCd");
		this.hashFields.put("gri_adj_seq", "griAdjSeq");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("prc_cgo_tp_cd", "prcCgoTpCd");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("org_dest_tp_cd", "orgDestTpCd");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("gri_grp_seq", "griGrpSeq");
		this.hashFields.put("gri_rt_rto", "griRtRto");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return griRtAmt
	 */
	public String getGriRtAmt() {
		return this.griRtAmt;
	}
	
	/**
	 * Column Info
	 * @return fltPctTpCd
	 */
	public String getFltPctTpCd() {
		return this.fltPctTpCd;
	}
	
	/**
	 * Column Info
	 * @return griAdjSeq
	 */
	public String getGriAdjSeq() {
		return this.griAdjSeq;
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
	 * Column Info
	 * @return griGrpSeq
	 */
	public String getGriGrpSeq() {
		return this.griGrpSeq;
	}
	
	/**
	 * Column Info
	 * @return griRtRto
	 */
	public String getGriRtRto() {
		return this.griRtRto;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	

	/**
	 * Column Info
	 * @param griRtAmt
	 */
	public void setGriRtAmt(String griRtAmt) {
		this.griRtAmt = griRtAmt;
	}
	
	/**
	 * Column Info
	 * @param fltPctTpCd
	 */
	public void setFltPctTpCd(String fltPctTpCd) {
		this.fltPctTpCd = fltPctTpCd;
	}
	
	/**
	 * Column Info
	 * @param griAdjSeq
	 */
	public void setGriAdjSeq(String griAdjSeq) {
		this.griAdjSeq = griAdjSeq;
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
	 * Column Info
	 * @param griGrpSeq
	 */
	public void setGriGrpSeq(String griGrpSeq) {
		this.griGrpSeq = griGrpSeq;
	}
	
	/**
	 * Column Info
	 * @param griRtRto
	 */
	public void setGriRtRto(String griRtRto) {
		this.griRtRto = griRtRto;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setGriRtAmt(JSPUtil.getParameter(request, "gri_rt_amt", ""));
		setFltPctTpCd(JSPUtil.getParameter(request, "flt_pct_tp_cd", ""));
		setGriAdjSeq(JSPUtil.getParameter(request, "gri_adj_seq", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setPrcCgoTpCd(JSPUtil.getParameter(request, "prc_cgo_tp_cd", ""));
		setAmdtSeq(JSPUtil.getParameter(request, "amdt_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setOrgDestTpCd(JSPUtil.getParameter(request, "org_dest_tp_cd", ""));
		setRatUtCd(JSPUtil.getParameter(request, "rat_ut_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setGriGrpSeq(JSPUtil.getParameter(request, "gri_grp_seq", ""));
		setGriRtRto(JSPUtil.getParameter(request, "gri_rt_rto", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPriSpScpTrspAddChgGriArbOKCLSubListVO[]
	 */
	public RsltPriSpScpTrspAddChgGriArbOKCLSubListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPriSpScpTrspAddChgGriArbOKCLSubListVO[]
	 */
	public RsltPriSpScpTrspAddChgGriArbOKCLSubListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPriSpScpTrspAddChgGriArbOKCLSubListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] griRtAmt = (JSPUtil.getParameter(request, prefix	+ "gri_rt_amt", length));
			String[] fltPctTpCd = (JSPUtil.getParameter(request, prefix	+ "flt_pct_tp_cd", length));
			String[] griAdjSeq = (JSPUtil.getParameter(request, prefix	+ "gri_adj_seq", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] prcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_cgo_tp_cd", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] orgDestTpCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_tp_cd", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] griGrpSeq = (JSPUtil.getParameter(request, prefix	+ "gri_grp_seq", length));
			String[] griRtRto = (JSPUtil.getParameter(request, prefix	+ "gri_rt_rto", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPriSpScpTrspAddChgGriArbOKCLSubListVO();
				if (griRtAmt[i] != null)
					model.setGriRtAmt(griRtAmt[i]);
				if (fltPctTpCd[i] != null)
					model.setFltPctTpCd(fltPctTpCd[i]);
				if (griAdjSeq[i] != null)
					model.setGriAdjSeq(griAdjSeq[i]);
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
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (griGrpSeq[i] != null)
					model.setGriGrpSeq(griGrpSeq[i]);
				if (griRtRto[i] != null)
					model.setGriRtRto(griRtRto[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPriSpScpTrspAddChgGriArbOKCLSubListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPriSpScpTrspAddChgGriArbOKCLSubListVO[]
	 */
	public RsltPriSpScpTrspAddChgGriArbOKCLSubListVO[] getRsltPriSpScpTrspAddChgGriArbOKCLSubListVOs(){
		RsltPriSpScpTrspAddChgGriArbOKCLSubListVO[] vos = (RsltPriSpScpTrspAddChgGriArbOKCLSubListVO[])models.toArray(new RsltPriSpScpTrspAddChgGriArbOKCLSubListVO[models.size()]);
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
		this.griRtAmt = this.griRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fltPctTpCd = this.fltPctTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.griAdjSeq = this.griAdjSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCgoTpCd = this.prcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestTpCd = this.orgDestTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.griGrpSeq = this.griGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.griRtRto = this.griRtRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

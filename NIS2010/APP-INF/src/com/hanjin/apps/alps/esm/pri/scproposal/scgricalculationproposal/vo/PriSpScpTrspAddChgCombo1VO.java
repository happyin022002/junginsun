/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PriSpScpTrspAddChgCombo1VO.java
*@FileTitle : PriSpScpTrspAddChgCombo1VO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.09.17 김대호 
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

public class PriSpScpTrspAddChgCombo1VO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PriSpScpTrspAddChgCombo1VO> models = new ArrayList<PriSpScpTrspAddChgCombo1VO>();
	
	/* Column Info */
	private String rcvDeTermNm = null;
	/* Column Info */
	private String addChgTpCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String bsePortDefNm = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String routPntLocDefNm = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String orgDestTpCd = null;
	/* Column Info */
	private String routPntLocDefCd = null;
	/* Column Info */
	private String bsePortDefCd = null;
	/* Column Info */
	private String viaPortDefCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String prcTrspModNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rnum = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String prcTrspModCd = null;
	/* Column Info */
	private String rcvDeTermCd = null;
	/* Column Info */
	private String viaPortDefNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PriSpScpTrspAddChgCombo1VO() {}

	public PriSpScpTrspAddChgCombo1VO(String ibflag, String pagerows, String rnum, String propNo, String amdtSeq, String svcScpCd, String addChgTpCd, String orgDestTpCd, String routPntLocDefCd, String routPntLocDefNm, String prcTrspModCd, String prcTrspModNm, String rcvDeTermCd, String rcvDeTermNm, String bsePortDefCd, String bsePortDefNm, String viaPortDefCd, String viaPortDefNm, String currCd) {
		this.rcvDeTermNm = rcvDeTermNm;
		this.addChgTpCd = addChgTpCd;
		this.currCd = currCd;
		this.bsePortDefNm = bsePortDefNm;
		this.amdtSeq = amdtSeq;
		this.routPntLocDefNm = routPntLocDefNm;
		this.svcScpCd = svcScpCd;
		this.orgDestTpCd = orgDestTpCd;
		this.routPntLocDefCd = routPntLocDefCd;
		this.bsePortDefCd = bsePortDefCd;
		this.viaPortDefCd = viaPortDefCd;
		this.pagerows = pagerows;
		this.prcTrspModNm = prcTrspModNm;
		this.ibflag = ibflag;
		this.rnum = rnum;
		this.propNo = propNo;
		this.prcTrspModCd = prcTrspModCd;
		this.rcvDeTermCd = rcvDeTermCd;
		this.viaPortDefNm = viaPortDefNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rcv_de_term_nm", getRcvDeTermNm());
		this.hashColumns.put("add_chg_tp_cd", getAddChgTpCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("bse_port_def_nm", getBsePortDefNm());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("rout_pnt_loc_def_nm", getRoutPntLocDefNm());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("org_dest_tp_cd", getOrgDestTpCd());
		this.hashColumns.put("rout_pnt_loc_def_cd", getRoutPntLocDefCd());
		this.hashColumns.put("bse_port_def_cd", getBsePortDefCd());
		this.hashColumns.put("via_port_def_cd", getViaPortDefCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("prc_trsp_mod_nm", getPrcTrspModNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rnum", getRnum());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("prc_trsp_mod_cd", getPrcTrspModCd());
		this.hashColumns.put("rcv_de_term_cd", getRcvDeTermCd());
		this.hashColumns.put("via_port_def_nm", getViaPortDefNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rcv_de_term_nm", "rcvDeTermNm");
		this.hashFields.put("add_chg_tp_cd", "addChgTpCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("bse_port_def_nm", "bsePortDefNm");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("rout_pnt_loc_def_nm", "routPntLocDefNm");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("org_dest_tp_cd", "orgDestTpCd");
		this.hashFields.put("rout_pnt_loc_def_cd", "routPntLocDefCd");
		this.hashFields.put("bse_port_def_cd", "bsePortDefCd");
		this.hashFields.put("via_port_def_cd", "viaPortDefCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("prc_trsp_mod_nm", "prcTrspModNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rnum", "rnum");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("prc_trsp_mod_cd", "prcTrspModCd");
		this.hashFields.put("rcv_de_term_cd", "rcvDeTermCd");
		this.hashFields.put("via_port_def_nm", "viaPortDefNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rcvDeTermNm
	 */
	public String getRcvDeTermNm() {
		return this.rcvDeTermNm;
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
	 * @return bsePortDefNm
	 */
	public String getBsePortDefNm() {
		return this.bsePortDefNm;
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
	 * @return routPntLocDefNm
	 */
	public String getRoutPntLocDefNm() {
		return this.routPntLocDefNm;
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
	 * @return routPntLocDefCd
	 */
	public String getRoutPntLocDefCd() {
		return this.routPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @return bsePortDefCd
	 */
	public String getBsePortDefCd() {
		return this.bsePortDefCd;
	}
	
	/**
	 * Column Info
	 * @return viaPortDefCd
	 */
	public String getViaPortDefCd() {
		return this.viaPortDefCd;
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
	 * @return prcTrspModNm
	 */
	public String getPrcTrspModNm() {
		return this.prcTrspModNm;
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
	 * @return rnum
	 */
	public String getRnum() {
		return this.rnum;
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
	 * @return prcTrspModCd
	 */
	public String getPrcTrspModCd() {
		return this.prcTrspModCd;
	}
	
	/**
	 * Column Info
	 * @return rcvDeTermCd
	 */
	public String getRcvDeTermCd() {
		return this.rcvDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return viaPortDefNm
	 */
	public String getViaPortDefNm() {
		return this.viaPortDefNm;
	}
	

	/**
	 * Column Info
	 * @param rcvDeTermNm
	 */
	public void setRcvDeTermNm(String rcvDeTermNm) {
		this.rcvDeTermNm = rcvDeTermNm;
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
	 * @param bsePortDefNm
	 */
	public void setBsePortDefNm(String bsePortDefNm) {
		this.bsePortDefNm = bsePortDefNm;
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
	 * @param routPntLocDefNm
	 */
	public void setRoutPntLocDefNm(String routPntLocDefNm) {
		this.routPntLocDefNm = routPntLocDefNm;
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
	 * @param routPntLocDefCd
	 */
	public void setRoutPntLocDefCd(String routPntLocDefCd) {
		this.routPntLocDefCd = routPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @param bsePortDefCd
	 */
	public void setBsePortDefCd(String bsePortDefCd) {
		this.bsePortDefCd = bsePortDefCd;
	}
	
	/**
	 * Column Info
	 * @param viaPortDefCd
	 */
	public void setViaPortDefCd(String viaPortDefCd) {
		this.viaPortDefCd = viaPortDefCd;
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
	 * @param prcTrspModNm
	 */
	public void setPrcTrspModNm(String prcTrspModNm) {
		this.prcTrspModNm = prcTrspModNm;
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
	 * @param rnum
	 */
	public void setRnum(String rnum) {
		this.rnum = rnum;
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
	 * @param prcTrspModCd
	 */
	public void setPrcTrspModCd(String prcTrspModCd) {
		this.prcTrspModCd = prcTrspModCd;
	}
	
	/**
	 * Column Info
	 * @param rcvDeTermCd
	 */
	public void setRcvDeTermCd(String rcvDeTermCd) {
		this.rcvDeTermCd = rcvDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param viaPortDefNm
	 */
	public void setViaPortDefNm(String viaPortDefNm) {
		this.viaPortDefNm = viaPortDefNm;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRcvDeTermNm(JSPUtil.getParameter(request, "rcv_de_term_nm", ""));
		setAddChgTpCd(JSPUtil.getParameter(request, "add_chg_tp_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setBsePortDefNm(JSPUtil.getParameter(request, "bse_port_def_nm", ""));
		setAmdtSeq(JSPUtil.getParameter(request, "amdt_seq", ""));
		setRoutPntLocDefNm(JSPUtil.getParameter(request, "rout_pnt_loc_def_nm", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setOrgDestTpCd(JSPUtil.getParameter(request, "org_dest_tp_cd", ""));
		setRoutPntLocDefCd(JSPUtil.getParameter(request, "rout_pnt_loc_def_cd", ""));
		setBsePortDefCd(JSPUtil.getParameter(request, "bse_port_def_cd", ""));
		setViaPortDefCd(JSPUtil.getParameter(request, "via_port_def_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPrcTrspModNm(JSPUtil.getParameter(request, "prc_trsp_mod_nm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRnum(JSPUtil.getParameter(request, "rnum", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
		setPrcTrspModCd(JSPUtil.getParameter(request, "prc_trsp_mod_cd", ""));
		setRcvDeTermCd(JSPUtil.getParameter(request, "rcv_de_term_cd", ""));
		setViaPortDefNm(JSPUtil.getParameter(request, "via_port_def_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PriSpScpTrspAddChgCombo1VO[]
	 */
	public PriSpScpTrspAddChgCombo1VO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PriSpScpTrspAddChgCombo1VO[]
	 */
	public PriSpScpTrspAddChgCombo1VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PriSpScpTrspAddChgCombo1VO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rcvDeTermNm = (JSPUtil.getParameter(request, prefix	+ "rcv_de_term_nm", length));
			String[] addChgTpCd = (JSPUtil.getParameter(request, prefix	+ "add_chg_tp_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] bsePortDefNm = (JSPUtil.getParameter(request, prefix	+ "bse_port_def_nm", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] routPntLocDefNm = (JSPUtil.getParameter(request, prefix	+ "rout_pnt_loc_def_nm", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] orgDestTpCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_tp_cd", length));
			String[] routPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "rout_pnt_loc_def_cd", length));
			String[] bsePortDefCd = (JSPUtil.getParameter(request, prefix	+ "bse_port_def_cd", length));
			String[] viaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "via_port_def_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] prcTrspModNm = (JSPUtil.getParameter(request, prefix	+ "prc_trsp_mod_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rnum = (JSPUtil.getParameter(request, prefix	+ "rnum", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] prcTrspModCd = (JSPUtil.getParameter(request, prefix	+ "prc_trsp_mod_cd", length));
			String[] rcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_de_term_cd", length));
			String[] viaPortDefNm = (JSPUtil.getParameter(request, prefix	+ "via_port_def_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new PriSpScpTrspAddChgCombo1VO();
				if (rcvDeTermNm[i] != null)
					model.setRcvDeTermNm(rcvDeTermNm[i]);
				if (addChgTpCd[i] != null)
					model.setAddChgTpCd(addChgTpCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (bsePortDefNm[i] != null)
					model.setBsePortDefNm(bsePortDefNm[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (routPntLocDefNm[i] != null)
					model.setRoutPntLocDefNm(routPntLocDefNm[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (orgDestTpCd[i] != null)
					model.setOrgDestTpCd(orgDestTpCd[i]);
				if (routPntLocDefCd[i] != null)
					model.setRoutPntLocDefCd(routPntLocDefCd[i]);
				if (bsePortDefCd[i] != null)
					model.setBsePortDefCd(bsePortDefCd[i]);
				if (viaPortDefCd[i] != null)
					model.setViaPortDefCd(viaPortDefCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (prcTrspModNm[i] != null)
					model.setPrcTrspModNm(prcTrspModNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rnum[i] != null)
					model.setRnum(rnum[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (prcTrspModCd[i] != null)
					model.setPrcTrspModCd(prcTrspModCd[i]);
				if (rcvDeTermCd[i] != null)
					model.setRcvDeTermCd(rcvDeTermCd[i]);
				if (viaPortDefNm[i] != null)
					model.setViaPortDefNm(viaPortDefNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPriSpScpTrspAddChgCombo1VOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PriSpScpTrspAddChgCombo1VO[]
	 */
	public PriSpScpTrspAddChgCombo1VO[] getPriSpScpTrspAddChgCombo1VOs(){
		PriSpScpTrspAddChgCombo1VO[] vos = (PriSpScpTrspAddChgCombo1VO[])models.toArray(new PriSpScpTrspAddChgCombo1VO[models.size()]);
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
		this.rcvDeTermNm = this.rcvDeTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addChgTpCd = this.addChgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsePortDefNm = this.bsePortDefNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routPntLocDefNm = this.routPntLocDefNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestTpCd = this.orgDestTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routPntLocDefCd = this.routPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsePortDefCd = this.bsePortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaPortDefCd = this.viaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcTrspModNm = this.prcTrspModNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rnum = this.rnum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcTrspModCd = this.prcTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDeTermCd = this.rcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaPortDefNm = this.viaPortDefNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

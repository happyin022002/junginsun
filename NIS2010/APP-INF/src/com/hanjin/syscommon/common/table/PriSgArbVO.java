/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PriSgArbVO.java
*@FileTitle : PriSgArbVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.17
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.04.17 공백진 
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 공백진
 * @since J2EE 1.5
 */

public class PriSgArbVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PriSgArbVO> models = new ArrayList<PriSgArbVO>();
	
	/* Column Info */
	private String rcvDeTermCd = null;
	/* Column Info */
	private String prcCgoTpCd = null;
	/* Column Info */
	private String routPntLocTpCd = null;
	/* Column Info */
	private String routPntLocDefCd = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String glineSeq = null;
	/* Column Info */
	private String frtRtAmt = null;
	/* Column Info */
	private String arbSeq = null;
	/* Column Info */
	private String dirCallFlg = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String bsePortTpCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String prcTrspModCd = null;
	/* Column Info */
	private String orgDestTpCd = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String bsePortDefCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String viaPortTpCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String currCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String viaPortDefCd = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PriSgArbVO() {}

	public PriSgArbVO(String ibflag, String pagerows, String svcScpCd, String glineSeq, String orgDestTpCd, String arbSeq, String routPntLocTpCd, String routPntLocDefCd, String bsePortTpCd, String bsePortDefCd, String viaPortTpCd, String viaPortDefCd, String dirCallFlg, String ratUtCd, String prcCgoTpCd, String prcTrspModCd, String rcvDeTermCd, String currCd, String frtRtAmt, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.rcvDeTermCd = rcvDeTermCd;
		this.prcCgoTpCd = prcCgoTpCd;
		this.routPntLocTpCd = routPntLocTpCd;
		this.routPntLocDefCd = routPntLocDefCd;
		this.ibflag = ibflag;
		this.glineSeq = glineSeq;
		this.frtRtAmt = frtRtAmt;
		this.arbSeq = arbSeq;
		this.dirCallFlg = dirCallFlg;
		this.svcScpCd = svcScpCd;
		this.bsePortTpCd = bsePortTpCd;
		this.updUsrId = updUsrId;
		this.prcTrspModCd = prcTrspModCd;
		this.orgDestTpCd = orgDestTpCd;
		this.ratUtCd = ratUtCd;
		this.bsePortDefCd = bsePortDefCd;
		this.updDt = updDt;
		this.viaPortTpCd = viaPortTpCd;
		this.creDt = creDt;
		this.creUsrId = creUsrId;
		this.currCd = currCd;
		this.pagerows = pagerows;
		this.viaPortDefCd = viaPortDefCd;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rcv_de_term_cd", getRcvDeTermCd());
		this.hashColumns.put("prc_cgo_tp_cd", getPrcCgoTpCd());
		this.hashColumns.put("rout_pnt_loc_tp_cd", getRoutPntLocTpCd());
		this.hashColumns.put("rout_pnt_loc_def_cd", getRoutPntLocDefCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("gline_seq", getGlineSeq());
		this.hashColumns.put("frt_rt_amt", getFrtRtAmt());
		this.hashColumns.put("arb_seq", getArbSeq());
		this.hashColumns.put("dir_call_flg", getDirCallFlg());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("bse_port_tp_cd", getBsePortTpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("prc_trsp_mod_cd", getPrcTrspModCd());
		this.hashColumns.put("org_dest_tp_cd", getOrgDestTpCd());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("bse_port_def_cd", getBsePortDefCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("via_port_tp_cd", getViaPortTpCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("via_port_def_cd", getViaPortDefCd());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rcv_de_term_cd", "rcvDeTermCd");
		this.hashFields.put("prc_cgo_tp_cd", "prcCgoTpCd");
		this.hashFields.put("rout_pnt_loc_tp_cd", "routPntLocTpCd");
		this.hashFields.put("rout_pnt_loc_def_cd", "routPntLocDefCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("gline_seq", "glineSeq");
		this.hashFields.put("frt_rt_amt", "frtRtAmt");
		this.hashFields.put("arb_seq", "arbSeq");
		this.hashFields.put("dir_call_flg", "dirCallFlg");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("bse_port_tp_cd", "bsePortTpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("prc_trsp_mod_cd", "prcTrspModCd");
		this.hashFields.put("org_dest_tp_cd", "orgDestTpCd");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("bse_port_def_cd", "bsePortDefCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("via_port_tp_cd", "viaPortTpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("via_port_def_cd", "viaPortDefCd");
		return this.hashFields;
	}
	
	public String getRcvDeTermCd() {
		return this.rcvDeTermCd;
	}
	public String getPrcCgoTpCd() {
		return this.prcCgoTpCd;
	}
	public String getRoutPntLocTpCd() {
		return this.routPntLocTpCd;
	}
	public String getRoutPntLocDefCd() {
		return this.routPntLocDefCd;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getGlineSeq() {
		return this.glineSeq;
	}
	public String getFrtRtAmt() {
		return this.frtRtAmt;
	}
	public String getArbSeq() {
		return this.arbSeq;
	}
	public String getDirCallFlg() {
		return this.dirCallFlg;
	}
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	public String getBsePortTpCd() {
		return this.bsePortTpCd;
	}
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	public String getPrcTrspModCd() {
		return this.prcTrspModCd;
	}
	public String getOrgDestTpCd() {
		return this.orgDestTpCd;
	}
	public String getRatUtCd() {
		return this.ratUtCd;
	}
	public String getBsePortDefCd() {
		return this.bsePortDefCd;
	}
	public String getUpdDt() {
		return this.updDt;
	}
	public String getViaPortTpCd() {
		return this.viaPortTpCd;
	}
	public String getCreDt() {
		return this.creDt;
	}
	public String getCreUsrId() {
		return this.creUsrId;
	}
	public String getCurrCd() {
		return this.currCd;
	}
	public String getPagerows() {
		return this.pagerows;
	}
	public String getViaPortDefCd() {
		return this.viaPortDefCd;
	}

	public void setRcvDeTermCd(String rcvDeTermCd) {
		this.rcvDeTermCd = rcvDeTermCd;
		//this.rcvDeTermCd=true;
	}
	public void setPrcCgoTpCd(String prcCgoTpCd) {
		this.prcCgoTpCd = prcCgoTpCd;
		//this.prcCgoTpCd=true;
	}
	public void setRoutPntLocTpCd(String routPntLocTpCd) {
		this.routPntLocTpCd = routPntLocTpCd;
		//this.routPntLocTpCd=true;
	}
	public void setRoutPntLocDefCd(String routPntLocDefCd) {
		this.routPntLocDefCd = routPntLocDefCd;
		//this.routPntLocDefCd=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setGlineSeq(String glineSeq) {
		this.glineSeq = glineSeq;
		//this.glineSeq=true;
	}
	public void setFrtRtAmt(String frtRtAmt) {
		this.frtRtAmt = frtRtAmt;
		//this.frtRtAmt=true;
	}
	public void setArbSeq(String arbSeq) {
		this.arbSeq = arbSeq;
		//this.arbSeq=true;
	}
	public void setDirCallFlg(String dirCallFlg) {
		this.dirCallFlg = dirCallFlg;
		//this.dirCallFlg=true;
	}
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
		//this.svcScpCd=true;
	}
	public void setBsePortTpCd(String bsePortTpCd) {
		this.bsePortTpCd = bsePortTpCd;
		//this.bsePortTpCd=true;
	}
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
		//this.updUsrId=true;
	}
	public void setPrcTrspModCd(String prcTrspModCd) {
		this.prcTrspModCd = prcTrspModCd;
		//this.prcTrspModCd=true;
	}
	public void setOrgDestTpCd(String orgDestTpCd) {
		this.orgDestTpCd = orgDestTpCd;
		//this.orgDestTpCd=true;
	}
	public void setRatUtCd(String ratUtCd) {
		this.ratUtCd = ratUtCd;
		//this.ratUtCd=true;
	}
	public void setBsePortDefCd(String bsePortDefCd) {
		this.bsePortDefCd = bsePortDefCd;
		//this.bsePortDefCd=true;
	}
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
		//this.updDt=true;
	}
	public void setViaPortTpCd(String viaPortTpCd) {
		this.viaPortTpCd = viaPortTpCd;
		//this.viaPortTpCd=true;
	}
	public void setCreDt(String creDt) {
		this.creDt = creDt;
		//this.creDt=true;
	}
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
		//this.creUsrId=true;
	}
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
		//this.currCd=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void setViaPortDefCd(String viaPortDefCd) {
		this.viaPortDefCd = viaPortDefCd;
		//this.viaPortDefCd=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setRcvDeTermCd(JSPUtil.getParameter(request, "rcv_de_term_cd", ""));
		setPrcCgoTpCd(JSPUtil.getParameter(request, "prc_cgo_tp_cd", ""));
		setRoutPntLocTpCd(JSPUtil.getParameter(request, "rout_pnt_loc_tp_cd", ""));
		setRoutPntLocDefCd(JSPUtil.getParameter(request, "rout_pnt_loc_def_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setGlineSeq(JSPUtil.getParameter(request, "gline_seq", ""));
		setFrtRtAmt(JSPUtil.getParameter(request, "frt_rt_amt", ""));
		setArbSeq(JSPUtil.getParameter(request, "arb_seq", ""));
		setDirCallFlg(JSPUtil.getParameter(request, "dir_call_flg", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setBsePortTpCd(JSPUtil.getParameter(request, "bse_port_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setPrcTrspModCd(JSPUtil.getParameter(request, "prc_trsp_mod_cd", ""));
		setOrgDestTpCd(JSPUtil.getParameter(request, "org_dest_tp_cd", ""));
		setRatUtCd(JSPUtil.getParameter(request, "rat_ut_cd", ""));
		setBsePortDefCd(JSPUtil.getParameter(request, "bse_port_def_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setViaPortTpCd(JSPUtil.getParameter(request, "via_port_tp_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setViaPortDefCd(JSPUtil.getParameter(request, "via_port_def_cd", ""));
	}

	public PriSgArbVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public PriSgArbVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PriSgArbVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_de_term_cd".trim(), length));
			String[] prcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_cgo_tp_cd".trim(), length));
			String[] routPntLocTpCd = (JSPUtil.getParameter(request, prefix	+ "rout_pnt_loc_tp_cd".trim(), length));
			String[] routPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "rout_pnt_loc_def_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] glineSeq = (JSPUtil.getParameter(request, prefix	+ "gline_seq".trim(), length));
			String[] frtRtAmt = (JSPUtil.getParameter(request, prefix	+ "frt_rt_amt".trim(), length));
			String[] arbSeq = (JSPUtil.getParameter(request, prefix	+ "arb_seq".trim(), length));
			String[] dirCallFlg = (JSPUtil.getParameter(request, prefix	+ "dir_call_flg".trim(), length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd".trim(), length));
			String[] bsePortTpCd = (JSPUtil.getParameter(request, prefix	+ "bse_port_tp_cd".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] prcTrspModCd = (JSPUtil.getParameter(request, prefix	+ "prc_trsp_mod_cd".trim(), length));
			String[] orgDestTpCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_tp_cd".trim(), length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd".trim(), length));
			String[] bsePortDefCd = (JSPUtil.getParameter(request, prefix	+ "bse_port_def_cd".trim(), length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] viaPortTpCd = (JSPUtil.getParameter(request, prefix	+ "via_port_tp_cd".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] viaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "via_port_def_cd".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new PriSgArbVO();
				if (rcvDeTermCd[i] != null)
					model.setRcvDeTermCd(rcvDeTermCd[i]);
				if (prcCgoTpCd[i] != null)
					model.setPrcCgoTpCd(prcCgoTpCd[i]);
				if (routPntLocTpCd[i] != null)
					model.setRoutPntLocTpCd(routPntLocTpCd[i]);
				if (routPntLocDefCd[i] != null)
					model.setRoutPntLocDefCd(routPntLocDefCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (glineSeq[i] != null)
					model.setGlineSeq(glineSeq[i]);
				if (frtRtAmt[i] != null)
					model.setFrtRtAmt(frtRtAmt[i]);
				if (arbSeq[i] != null)
					model.setArbSeq(arbSeq[i]);
				if (dirCallFlg[i] != null)
					model.setDirCallFlg(dirCallFlg[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (bsePortTpCd[i] != null)
					model.setBsePortTpCd(bsePortTpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (prcTrspModCd[i] != null)
					model.setPrcTrspModCd(prcTrspModCd[i]);
				if (orgDestTpCd[i] != null)
					model.setOrgDestTpCd(orgDestTpCd[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (bsePortDefCd[i] != null)
					model.setBsePortDefCd(bsePortDefCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (viaPortTpCd[i] != null)
					model.setViaPortTpCd(viaPortTpCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (viaPortDefCd[i] != null)
					model.setViaPortDefCd(viaPortDefCd[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getPriSgArbVOs();
	}

	public PriSgArbVO[] getPriSgArbVOs(){
		PriSgArbVO[] vos = (PriSgArbVO[])models.toArray(new PriSgArbVO[models.size()]);
		return vos;
	}
	
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
		} catch (Exception ex) {}
		return ret.toString();
	}
	
	/**
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 * @throws IllegalAccessException
	 */
	private String[] getField(Field[] field, int i) throws IllegalAccessException {
		String[] arr;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void onDataFormat(){
		this.rcvDeTermCd = this.rcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCgoTpCd = this.prcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routPntLocTpCd = this.routPntLocTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routPntLocDefCd = this.routPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineSeq = this.glineSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtRtAmt = this.frtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arbSeq = this.arbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCallFlg = this.dirCallFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsePortTpCd = this.bsePortTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcTrspModCd = this.prcTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestTpCd = this.orgDestTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsePortDefCd = this.bsePortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaPortTpCd = this.viaPortTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaPortDefCd = this.viaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

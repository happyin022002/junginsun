/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PriGriGrpCmdtVO.java
*@FileTitle : PriGriGrpCmdtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.05.13 문동규 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.scguideline.scgroupcommodityguideline.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 문동규
 * @since J2EE 1.5
 * @see ..
 */

public class PriGriGrpCmdtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PriGriGrpCmdtVO> models = new ArrayList<PriGriGrpCmdtVO>();
	
	/* Column Info */
	private String prcCmdtTpCd = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String glineSeq = null;
	/* Column Info */
	private String scgGrpCmdtDesc = null;
	/* Column Info */
	private String prcGrpCmdtDesc = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String scgGrpCmdtCd = null;
	/* Column Info */
	private String scgGrpCmdtSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String grpCmdtDtlSeq = null;
	/* Column Info */
	private String prcCustTpCd = null;
	/* Column Info */
	private String prcCmdtDefCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String prcGrpCmdtCd = null;
	/* Column Info */
	private String grpCmdtSeq = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PriGriGrpCmdtVO() {}

	public PriGriGrpCmdtVO(String ibflag, String pagerows, String svcScpCd, String glineSeq, String prcCustTpCd, String prcCmdtTpCd, String grpCmdtDtlSeq, String prcCmdtDefCd, String grpCmdtSeq, String scgGrpCmdtCd, String scgGrpCmdtSeq, String scgGrpCmdtDesc, String prcGrpCmdtCd, String prcGrpCmdtDesc, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.prcCmdtTpCd = prcCmdtTpCd;
		this.ibflag = ibflag;
		this.glineSeq = glineSeq;
		this.scgGrpCmdtDesc = scgGrpCmdtDesc;
		this.prcGrpCmdtDesc = prcGrpCmdtDesc;
		this.svcScpCd = svcScpCd;
		this.scgGrpCmdtCd = scgGrpCmdtCd;
		this.scgGrpCmdtSeq = scgGrpCmdtSeq;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.creDt = creDt;
		this.creUsrId = creUsrId;
		this.grpCmdtDtlSeq = grpCmdtDtlSeq;
		this.prcCustTpCd = prcCustTpCd;
		this.prcCmdtDefCd = prcCmdtDefCd;
		this.pagerows = pagerows;
		this.prcGrpCmdtCd = prcGrpCmdtCd;
		this.grpCmdtSeq = grpCmdtSeq;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("prc_cmdt_tp_cd", getPrcCmdtTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("gline_seq", getGlineSeq());
		this.hashColumns.put("scg_grp_cmdt_desc", getScgGrpCmdtDesc());
		this.hashColumns.put("prc_grp_cmdt_desc", getPrcGrpCmdtDesc());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("scg_grp_cmdt_cd", getScgGrpCmdtCd());
		this.hashColumns.put("scg_grp_cmdt_seq", getScgGrpCmdtSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("grp_cmdt_dtl_seq", getGrpCmdtDtlSeq());
		this.hashColumns.put("prc_cust_tp_cd", getPrcCustTpCd());
		this.hashColumns.put("prc_cmdt_def_cd", getPrcCmdtDefCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("prc_grp_cmdt_cd", getPrcGrpCmdtCd());
		this.hashColumns.put("grp_cmdt_seq", getGrpCmdtSeq());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("prc_cmdt_tp_cd", "prcCmdtTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("gline_seq", "glineSeq");
		this.hashFields.put("scg_grp_cmdt_desc", "scgGrpCmdtDesc");
		this.hashFields.put("prc_grp_cmdt_desc", "prcGrpCmdtDesc");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("scg_grp_cmdt_cd", "scgGrpCmdtCd");
		this.hashFields.put("scg_grp_cmdt_seq", "scgGrpCmdtSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("grp_cmdt_dtl_seq", "grpCmdtDtlSeq");
		this.hashFields.put("prc_cust_tp_cd", "prcCustTpCd");
		this.hashFields.put("prc_cmdt_def_cd", "prcCmdtDefCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("prc_grp_cmdt_cd", "prcGrpCmdtCd");
		this.hashFields.put("grp_cmdt_seq", "grpCmdtSeq");
		return this.hashFields;
	}
	
	public String getPrcCmdtTpCd() {
		return this.prcCmdtTpCd;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getGlineSeq() {
		return this.glineSeq;
	}
	public String getScgGrpCmdtDesc() {
		return this.scgGrpCmdtDesc;
	}
	public String getPrcGrpCmdtDesc() {
		return this.prcGrpCmdtDesc;
	}
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	public String getScgGrpCmdtCd() {
		return this.scgGrpCmdtCd;
	}
	public String getScgGrpCmdtSeq() {
		return this.scgGrpCmdtSeq;
	}
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	public String getUpdDt() {
		return this.updDt;
	}
	public String getCreDt() {
		return this.creDt;
	}
	public String getCreUsrId() {
		return this.creUsrId;
	}
	public String getGrpCmdtDtlSeq() {
		return this.grpCmdtDtlSeq;
	}
	public String getPrcCustTpCd() {
		return this.prcCustTpCd;
	}
	public String getPrcCmdtDefCd() {
		return this.prcCmdtDefCd;
	}
	public String getPagerows() {
		return this.pagerows;
	}
	public String getPrcGrpCmdtCd() {
		return this.prcGrpCmdtCd;
	}
	public String getGrpCmdtSeq() {
		return this.grpCmdtSeq;
	}

	public void setPrcCmdtTpCd(String prcCmdtTpCd) {
		this.prcCmdtTpCd = prcCmdtTpCd;
		//this.prcCmdtTpCd=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setGlineSeq(String glineSeq) {
		this.glineSeq = glineSeq;
		//this.glineSeq=true;
	}
	public void setScgGrpCmdtDesc(String scgGrpCmdtDesc) {
		this.scgGrpCmdtDesc = scgGrpCmdtDesc;
		//this.scgGrpCmdtDesc=true;
	}
	public void setPrcGrpCmdtDesc(String prcGrpCmdtDesc) {
		this.prcGrpCmdtDesc = prcGrpCmdtDesc;
		//this.prcGrpCmdtDesc=true;
	}
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
		//this.svcScpCd=true;
	}
	public void setScgGrpCmdtCd(String scgGrpCmdtCd) {
		this.scgGrpCmdtCd = scgGrpCmdtCd;
		//this.scgGrpCmdtCd=true;
	}
	public void setScgGrpCmdtSeq(String scgGrpCmdtSeq) {
		this.scgGrpCmdtSeq = scgGrpCmdtSeq;
		//this.scgGrpCmdtSeq=true;
	}
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
		//this.updUsrId=true;
	}
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
		//this.updDt=true;
	}
	public void setCreDt(String creDt) {
		this.creDt = creDt;
		//this.creDt=true;
	}
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
		//this.creUsrId=true;
	}
	public void setGrpCmdtDtlSeq(String grpCmdtDtlSeq) {
		this.grpCmdtDtlSeq = grpCmdtDtlSeq;
		//this.grpCmdtDtlSeq=true;
	}
	public void setPrcCustTpCd(String prcCustTpCd) {
		this.prcCustTpCd = prcCustTpCd;
		//this.prcCustTpCd=true;
	}
	public void setPrcCmdtDefCd(String prcCmdtDefCd) {
		this.prcCmdtDefCd = prcCmdtDefCd;
		//this.prcCmdtDefCd=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void setPrcGrpCmdtCd(String prcGrpCmdtCd) {
		this.prcGrpCmdtCd = prcGrpCmdtCd;
		//this.prcGrpCmdtCd=true;
	}
	public void setGrpCmdtSeq(String grpCmdtSeq) {
		this.grpCmdtSeq = grpCmdtSeq;
		//this.grpCmdtSeq=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setPrcCmdtTpCd(JSPUtil.getParameter(request, "prc_cmdt_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setGlineSeq(JSPUtil.getParameter(request, "gline_seq", ""));
		setScgGrpCmdtDesc(JSPUtil.getParameter(request, "scg_grp_cmdt_desc", ""));
		setPrcGrpCmdtDesc(JSPUtil.getParameter(request, "prc_grp_cmdt_desc", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setScgGrpCmdtCd(JSPUtil.getParameter(request, "scg_grp_cmdt_cd", ""));
		setScgGrpCmdtSeq(JSPUtil.getParameter(request, "scg_grp_cmdt_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setGrpCmdtDtlSeq(JSPUtil.getParameter(request, "grp_cmdt_dtl_seq", ""));
		setPrcCustTpCd(JSPUtil.getParameter(request, "prc_cust_tp_cd", ""));
		setPrcCmdtDefCd(JSPUtil.getParameter(request, "prc_cmdt_def_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPrcGrpCmdtCd(JSPUtil.getParameter(request, "prc_grp_cmdt_cd", ""));
		setGrpCmdtSeq(JSPUtil.getParameter(request, "grp_cmdt_seq", ""));
	}

	public PriGriGrpCmdtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public PriGriGrpCmdtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PriGriGrpCmdtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] prcCmdtTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_cmdt_tp_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] glineSeq = (JSPUtil.getParameter(request, prefix	+ "gline_seq".trim(), length));
			String[] scgGrpCmdtDesc = (JSPUtil.getParameter(request, prefix	+ "scg_grp_cmdt_desc".trim(), length));
			String[] prcGrpCmdtDesc = (JSPUtil.getParameter(request, prefix	+ "prc_grp_cmdt_desc".trim(), length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd".trim(), length));
			String[] scgGrpCmdtCd = (JSPUtil.getParameter(request, prefix	+ "scg_grp_cmdt_cd".trim(), length));
			String[] scgGrpCmdtSeq = (JSPUtil.getParameter(request, prefix	+ "scg_grp_cmdt_seq".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] grpCmdtDtlSeq = (JSPUtil.getParameter(request, prefix	+ "grp_cmdt_dtl_seq".trim(), length));
			String[] prcCustTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_cust_tp_cd".trim(), length));
			String[] prcCmdtDefCd = (JSPUtil.getParameter(request, prefix	+ "prc_cmdt_def_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] prcGrpCmdtCd = (JSPUtil.getParameter(request, prefix	+ "prc_grp_cmdt_cd".trim(), length));
			String[] grpCmdtSeq = (JSPUtil.getParameter(request, prefix	+ "grp_cmdt_seq".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new PriGriGrpCmdtVO();
				if (prcCmdtTpCd[i] != null)
					model.setPrcCmdtTpCd(prcCmdtTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (glineSeq[i] != null)
					model.setGlineSeq(glineSeq[i]);
				if (scgGrpCmdtDesc[i] != null)
					model.setScgGrpCmdtDesc(scgGrpCmdtDesc[i]);
				if (prcGrpCmdtDesc[i] != null)
					model.setPrcGrpCmdtDesc(prcGrpCmdtDesc[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (scgGrpCmdtCd[i] != null)
					model.setScgGrpCmdtCd(scgGrpCmdtCd[i]);
				if (scgGrpCmdtSeq[i] != null)
					model.setScgGrpCmdtSeq(scgGrpCmdtSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (grpCmdtDtlSeq[i] != null)
					model.setGrpCmdtDtlSeq(grpCmdtDtlSeq[i]);
				if (prcCustTpCd[i] != null)
					model.setPrcCustTpCd(prcCustTpCd[i]);
				if (prcCmdtDefCd[i] != null)
					model.setPrcCmdtDefCd(prcCmdtDefCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (prcGrpCmdtCd[i] != null)
					model.setPrcGrpCmdtCd(prcGrpCmdtCd[i]);
				if (grpCmdtSeq[i] != null)
					model.setGrpCmdtSeq(grpCmdtSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPriGriGrpCmdtVOs();
	}

	public PriGriGrpCmdtVO[] getPriGriGrpCmdtVOs(){
		PriGriGrpCmdtVO[] vos = (PriGriGrpCmdtVO[])models.toArray(new PriGriGrpCmdtVO[models.size()]);
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
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = getFieldCatct(field, i, arr);
		}
		return arr;
	}
	
	/**
	 * getField 에서 catch문에 대한 로직
	 * @param field
	 * @param i
	 * @param arr
	 * @return arr
	 */
	private String[] getFieldCatct(Field[] field, int i, String[] arr) {
		try {
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		} catch (IllegalAccessException e) {
			return null;
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void onDataFormat(){
		this.prcCmdtTpCd = this.prcCmdtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineSeq = this.glineSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgGrpCmdtDesc = this.scgGrpCmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcGrpCmdtDesc = this.prcGrpCmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgGrpCmdtCd = this.scgGrpCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgGrpCmdtSeq = this.scgGrpCmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpCmdtDtlSeq = this.grpCmdtDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCustTpCd = this.prcCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCmdtDefCd = this.prcCmdtDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcGrpCmdtCd = this.prcGrpCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpCmdtSeq = this.grpCmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

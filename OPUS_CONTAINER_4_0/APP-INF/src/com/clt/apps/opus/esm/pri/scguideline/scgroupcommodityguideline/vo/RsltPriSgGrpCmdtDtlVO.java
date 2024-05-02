/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltPriSgGrpCmdtDtlVO.java
*@FileTitle : RsltPriSgGrpCmdtDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.23
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.04.23 공백진 
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
 * @author 공백진
 * @since J2EE 1.5
 */

public class RsltPriSgGrpCmdtDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPriSgGrpCmdtDtlVO> models = new ArrayList<RsltPriSgGrpCmdtDtlVO>();
	
	/* Column Info */
	private String prcCmdtTpCd = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String glineSeq = null;
	/* Column Info */
	private String grpCmdtDtlSeq = null;
	/* Column Info */
	private String prcCmdtDefCd = null;
	/* Column Info */
	private String prcCustTpCd = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String locDes = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String grpCmdtSeq = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPriSgGrpCmdtDtlVO() {}

	public RsltPriSgGrpCmdtDtlVO(String ibflag, String pagerows, String svcScpCd, String glineSeq, String prcCustTpCd, String grpCmdtSeq, String grpCmdtDtlSeq, String prcCmdtTpCd, String prcCmdtDefCd, String locDes) {
		this.prcCmdtTpCd = prcCmdtTpCd;
		this.ibflag = ibflag;
		this.glineSeq = glineSeq;
		this.grpCmdtDtlSeq = grpCmdtDtlSeq;
		this.prcCmdtDefCd = prcCmdtDefCd;
		this.prcCustTpCd = prcCustTpCd;
		this.svcScpCd = svcScpCd;
		this.locDes = locDes;
		this.pagerows = pagerows;
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
		this.hashColumns.put("grp_cmdt_dtl_seq", getGrpCmdtDtlSeq());
		this.hashColumns.put("prc_cmdt_def_cd", getPrcCmdtDefCd());
		this.hashColumns.put("prc_cust_tp_cd", getPrcCustTpCd());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("loc_des", getLocDes());
		this.hashColumns.put("pagerows", getPagerows());
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
		this.hashFields.put("grp_cmdt_dtl_seq", "grpCmdtDtlSeq");
		this.hashFields.put("prc_cmdt_def_cd", "prcCmdtDefCd");
		this.hashFields.put("prc_cust_tp_cd", "prcCustTpCd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("loc_des", "locDes");
		this.hashFields.put("pagerows", "pagerows");
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
	public String getGrpCmdtDtlSeq() {
		return this.grpCmdtDtlSeq;
	}
	public String getPrcCmdtDefCd() {
		return this.prcCmdtDefCd;
	}
	public String getPrcCustTpCd() {
		return this.prcCustTpCd;
	}
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	public String getLocDes() {
		return this.locDes;
	}
	public String getPagerows() {
		return this.pagerows;
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
	public void setGrpCmdtDtlSeq(String grpCmdtDtlSeq) {
		this.grpCmdtDtlSeq = grpCmdtDtlSeq;
		//this.grpCmdtDtlSeq=true;
	}
	public void setPrcCmdtDefCd(String prcCmdtDefCd) {
		this.prcCmdtDefCd = prcCmdtDefCd;
		//this.prcCmdtDefCd=true;
	}
	public void setPrcCustTpCd(String prcCustTpCd) {
		this.prcCustTpCd = prcCustTpCd;
		//this.prcCustTpCd=true;
	}
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
		//this.svcScpCd=true;
	}
	public void setLocDes(String locDes) {
		this.locDes = locDes;
		//this.locDes=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void setGrpCmdtSeq(String grpCmdtSeq) {
		this.grpCmdtSeq = grpCmdtSeq;
		//this.grpCmdtSeq=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setPrcCmdtTpCd(JSPUtil.getParameter(request, "prc_cmdt_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setGlineSeq(JSPUtil.getParameter(request, "gline_seq", ""));
		setGrpCmdtDtlSeq(JSPUtil.getParameter(request, "grp_cmdt_dtl_seq", ""));
		setPrcCmdtDefCd(JSPUtil.getParameter(request, "prc_cmdt_def_cd", ""));
		setPrcCustTpCd(JSPUtil.getParameter(request, "prc_cust_tp_cd", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setLocDes(JSPUtil.getParameter(request, "loc_des", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setGrpCmdtSeq(JSPUtil.getParameter(request, "grp_cmdt_seq", ""));
	}

	public RsltPriSgGrpCmdtDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public RsltPriSgGrpCmdtDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPriSgGrpCmdtDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] prcCmdtTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_cmdt_tp_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] glineSeq = (JSPUtil.getParameter(request, prefix	+ "gline_seq".trim(), length));
			String[] grpCmdtDtlSeq = (JSPUtil.getParameter(request, prefix	+ "grp_cmdt_dtl_seq".trim(), length));
			String[] prcCmdtDefCd = (JSPUtil.getParameter(request, prefix	+ "prc_cmdt_def_cd".trim(), length));
			String[] prcCustTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_cust_tp_cd".trim(), length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd".trim(), length));
			String[] locDes = (JSPUtil.getParameter(request, prefix	+ "loc_des".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] grpCmdtSeq = (JSPUtil.getParameter(request, prefix	+ "grp_cmdt_seq".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPriSgGrpCmdtDtlVO();
				if (prcCmdtTpCd[i] != null)
					model.setPrcCmdtTpCd(prcCmdtTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (glineSeq[i] != null)
					model.setGlineSeq(glineSeq[i]);
				if (grpCmdtDtlSeq[i] != null)
					model.setGrpCmdtDtlSeq(grpCmdtDtlSeq[i]);
				if (prcCmdtDefCd[i] != null)
					model.setPrcCmdtDefCd(prcCmdtDefCd[i]);
				if (prcCustTpCd[i] != null)
					model.setPrcCustTpCd(prcCustTpCd[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (locDes[i] != null)
					model.setLocDes(locDes[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (grpCmdtSeq[i] != null)
					model.setGrpCmdtSeq(grpCmdtSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getRsltPriSgGrpCmdtDtlVOs();
	}

	public RsltPriSgGrpCmdtDtlVO[] getRsltPriSgGrpCmdtDtlVOs(){
		RsltPriSgGrpCmdtDtlVO[] vos = (RsltPriSgGrpCmdtDtlVO[])models.toArray(new RsltPriSgGrpCmdtDtlVO[models.size()]);
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
		this.prcCmdtTpCd = this.prcCmdtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineSeq = this.glineSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpCmdtDtlSeq = this.grpCmdtDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCmdtDefCd = this.prcCmdtDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCustTpCd = this.prcCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locDes = this.locDes .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpCmdtSeq = this.grpCmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

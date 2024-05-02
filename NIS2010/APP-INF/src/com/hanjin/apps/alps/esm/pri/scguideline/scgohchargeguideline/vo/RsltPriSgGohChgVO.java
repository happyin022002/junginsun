/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltPriSgGohChgVO.java
*@FileTitle : RsltPriSgGohChgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.17
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.04.17 공백진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.scguideline.scgohchargeguideline.vo;

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

public class RsltPriSgGohChgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPriSgGohChgVO> models = new ArrayList<RsltPriSgGohChgVO>();
	
	/* Column Info */
	private String routPntLocDefCd = null;
	/* Column Info */
	private String routPntLocTpCd = null;
	/* Column Info */
	private String prcHngrBarTpCd = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String gohChgSeq = null;
	/* Column Info */
	private String glineSeq = null;
	/* Column Info */
	private String frtRtAmt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String locDes = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPriSgGohChgVO() {}

	public RsltPriSgGohChgVO(String ibflag, String pagerows, String svcScpCd, String glineSeq, String gohChgSeq, String routPntLocTpCd, String routPntLocDefCd, String locDes, String ratUtCd, String prcHngrBarTpCd, String currCd, String frtRtAmt) {
		this.routPntLocDefCd = routPntLocDefCd;
		this.routPntLocTpCd = routPntLocTpCd;
		this.prcHngrBarTpCd = prcHngrBarTpCd;
		this.ratUtCd = ratUtCd;
		this.ibflag = ibflag;
		this.gohChgSeq = gohChgSeq;
		this.glineSeq = glineSeq;
		this.frtRtAmt = frtRtAmt;
		this.currCd = currCd;
		this.svcScpCd = svcScpCd;
		this.locDes = locDes;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rout_pnt_loc_def_cd", getRoutPntLocDefCd());
		this.hashColumns.put("rout_pnt_loc_tp_cd", getRoutPntLocTpCd());
		this.hashColumns.put("prc_hngr_bar_tp_cd", getPrcHngrBarTpCd());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("goh_chg_seq", getGohChgSeq());
		this.hashColumns.put("gline_seq", getGlineSeq());
		this.hashColumns.put("frt_rt_amt", getFrtRtAmt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("loc_des", getLocDes());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rout_pnt_loc_def_cd", "routPntLocDefCd");
		this.hashFields.put("rout_pnt_loc_tp_cd", "routPntLocTpCd");
		this.hashFields.put("prc_hngr_bar_tp_cd", "prcHngrBarTpCd");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("goh_chg_seq", "gohChgSeq");
		this.hashFields.put("gline_seq", "glineSeq");
		this.hashFields.put("frt_rt_amt", "frtRtAmt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("loc_des", "locDes");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getRoutPntLocDefCd() {
		return this.routPntLocDefCd;
	}
	public String getRoutPntLocTpCd() {
		return this.routPntLocTpCd;
	}
	public String getPrcHngrBarTpCd() {
		return this.prcHngrBarTpCd;
	}
	public String getRatUtCd() {
		return this.ratUtCd;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getGohChgSeq() {
		return this.gohChgSeq;
	}
	public String getGlineSeq() {
		return this.glineSeq;
	}
	public String getFrtRtAmt() {
		return this.frtRtAmt;
	}
	public String getCurrCd() {
		return this.currCd;
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

	public void setRoutPntLocDefCd(String routPntLocDefCd) {
		this.routPntLocDefCd = routPntLocDefCd;
		//this.routPntLocDefCd=true;
	}
	public void setRoutPntLocTpCd(String routPntLocTpCd) {
		this.routPntLocTpCd = routPntLocTpCd;
		//this.routPntLocTpCd=true;
	}
	public void setPrcHngrBarTpCd(String prcHngrBarTpCd) {
		this.prcHngrBarTpCd = prcHngrBarTpCd;
		//this.prcHngrBarTpCd=true;
	}
	public void setRatUtCd(String ratUtCd) {
		this.ratUtCd = ratUtCd;
		//this.ratUtCd=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setGohChgSeq(String gohChgSeq) {
		this.gohChgSeq = gohChgSeq;
		//this.gohChgSeq=true;
	}
	public void setGlineSeq(String glineSeq) {
		this.glineSeq = glineSeq;
		//this.glineSeq=true;
	}
	public void setFrtRtAmt(String frtRtAmt) {
		this.frtRtAmt = frtRtAmt;
		//this.frtRtAmt=true;
	}
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
		//this.currCd=true;
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
	public void fromRequest(HttpServletRequest request) {
		setRoutPntLocDefCd(JSPUtil.getParameter(request, "rout_pnt_loc_def_cd", ""));
		setRoutPntLocTpCd(JSPUtil.getParameter(request, "rout_pnt_loc_tp_cd", ""));
		setPrcHngrBarTpCd(JSPUtil.getParameter(request, "prc_hngr_bar_tp_cd", ""));
		setRatUtCd(JSPUtil.getParameter(request, "rat_ut_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setGohChgSeq(JSPUtil.getParameter(request, "goh_chg_seq", ""));
		setGlineSeq(JSPUtil.getParameter(request, "gline_seq", ""));
		setFrtRtAmt(JSPUtil.getParameter(request, "frt_rt_amt", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setLocDes(JSPUtil.getParameter(request, "loc_des", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public RsltPriSgGohChgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public RsltPriSgGohChgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPriSgGohChgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] routPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "rout_pnt_loc_def_cd".trim(), length));
			String[] routPntLocTpCd = (JSPUtil.getParameter(request, prefix	+ "rout_pnt_loc_tp_cd".trim(), length));
			String[] prcHngrBarTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_hngr_bar_tp_cd".trim(), length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] gohChgSeq = (JSPUtil.getParameter(request, prefix	+ "goh_chg_seq".trim(), length));
			String[] glineSeq = (JSPUtil.getParameter(request, prefix	+ "gline_seq".trim(), length));
			String[] frtRtAmt = (JSPUtil.getParameter(request, prefix	+ "frt_rt_amt".trim(), length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd".trim(), length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd".trim(), length));
			String[] locDes = (JSPUtil.getParameter(request, prefix	+ "loc_des".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPriSgGohChgVO();
				if (routPntLocDefCd[i] != null)
					model.setRoutPntLocDefCd(routPntLocDefCd[i]);
				if (routPntLocTpCd[i] != null)
					model.setRoutPntLocTpCd(routPntLocTpCd[i]);
				if (prcHngrBarTpCd[i] != null)
					model.setPrcHngrBarTpCd(prcHngrBarTpCd[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (gohChgSeq[i] != null)
					model.setGohChgSeq(gohChgSeq[i]);
				if (glineSeq[i] != null)
					model.setGlineSeq(glineSeq[i]);
				if (frtRtAmt[i] != null)
					model.setFrtRtAmt(frtRtAmt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (locDes[i] != null)
					model.setLocDes(locDes[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getRsltPriSgGohChgVOs();
	}

	public RsltPriSgGohChgVO[] getRsltPriSgGohChgVOs(){
		RsltPriSgGohChgVO[] vos = (RsltPriSgGohChgVO[])models.toArray(new RsltPriSgGohChgVO[models.size()]);
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
		this.routPntLocDefCd = this.routPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routPntLocTpCd = this.routPntLocTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcHngrBarTpCd = this.prcHngrBarTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gohChgSeq = this.gohChgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineSeq = this.glineSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtRtAmt = this.frtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locDes = this.locDes .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

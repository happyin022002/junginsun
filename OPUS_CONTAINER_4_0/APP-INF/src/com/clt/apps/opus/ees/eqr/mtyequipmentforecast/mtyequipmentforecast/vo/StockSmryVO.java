/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StockSmryVO.java
*@FileTitle : StockSmryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.14
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.08.14 김종준 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo;

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
 * @author 김종준
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class StockSmryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<StockSmryVO> models = new ArrayList<StockSmryVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String avalQty = null;
	/* Column Info */
	private String totQty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rptDpSeq = null;
	/* Column Info */
	private String dueOutQty = null;
	/* Column Info */
	private String variQty = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String opmzQty = null;
	/* Column Info */
	private String dueInQty = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String dmgQty = null;
	/* Column Info */
	private String cntrQty = null;
	/* Column Info */
	private String sndQty = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String fmDur = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public StockSmryVO() {}

	public StockSmryVO(String ibflag, String pagerows, String fmDur, String avalQty, String totQty, String rptDpSeq, String dueOutQty, String variQty, String locCd, String opmzQty, String dueInQty, String cntrTpszCd, String cntrQty, String dmgQty, String sndQty, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.creDt = creDt;
		this.avalQty = avalQty;
		this.totQty = totQty;
		this.pagerows = pagerows;
		this.rptDpSeq = rptDpSeq;
		this.dueOutQty = dueOutQty;
		this.variQty = variQty;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.opmzQty = opmzQty;
		this.dueInQty = dueInQty;
		this.cntrTpszCd = cntrTpszCd;
		this.dmgQty = dmgQty;
		this.cntrQty = cntrQty;
		this.sndQty = sndQty;
		this.updUsrId = updUsrId;
		this.fmDur = fmDur;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("aval_qty", getAvalQty());
		this.hashColumns.put("tot_qty", getTotQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rpt_dp_seq", getRptDpSeq());
		this.hashColumns.put("due_out_qty", getDueOutQty());
		this.hashColumns.put("vari_qty", getVariQty());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("opmz_qty", getOpmzQty());
		this.hashColumns.put("due_in_qty", getDueInQty());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("dmg_qty", getDmgQty());
		this.hashColumns.put("cntr_qty", getCntrQty());
		this.hashColumns.put("snd_qty", getSndQty());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("fm_dur", getFmDur());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("aval_qty", "avalQty");
		this.hashFields.put("tot_qty", "totQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rpt_dp_seq", "rptDpSeq");
		this.hashFields.put("due_out_qty", "dueOutQty");
		this.hashFields.put("vari_qty", "variQty");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("opmz_qty", "opmzQty");
		this.hashFields.put("due_in_qty", "dueInQty");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("dmg_qty", "dmgQty");
		this.hashFields.put("cntr_qty", "cntrQty");
		this.hashFields.put("snd_qty", "sndQty");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("fm_dur", "fmDur");
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return avalQty
	 */
	public String getAvalQty() {
		return this.avalQty;
	}
	
	/**
	 * Column Info
	 * @return totQty
	 */
	public String getTotQty() {
		return this.totQty;
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
	 * @return rptDpSeq
	 */
	public String getRptDpSeq() {
		return this.rptDpSeq;
	}
	
	/**
	 * Column Info
	 * @return dueOutQty
	 */
	public String getDueOutQty() {
		return this.dueOutQty;
	}
	
	/**
	 * Column Info
	 * @return variQty
	 */
	public String getVariQty() {
		return this.variQty;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return opmzQty
	 */
	public String getOpmzQty() {
		return this.opmzQty;
	}
	
	/**
	 * Column Info
	 * @return dueInQty
	 */
	public String getDueInQty() {
		return this.dueInQty;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return dmgQty
	 */
	public String getDmgQty() {
		return this.dmgQty;
	}
	
	/**
	 * Column Info
	 * @return cntrQty
	 */
	public String getCntrQty() {
		return this.cntrQty;
	}
	
	/**
	 * Column Info
	 * @return sndQty
	 */
	public String getSndQty() {
		return this.sndQty;
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
	 * @return fmDur
	 */
	public String getFmDur() {
		return this.fmDur;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param avalQty
	 */
	public void setAvalQty(String avalQty) {
		this.avalQty = avalQty;
	}
	
	/**
	 * Column Info
	 * @param totQty
	 */
	public void setTotQty(String totQty) {
		this.totQty = totQty;
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
	 * @param rptDpSeq
	 */
	public void setRptDpSeq(String rptDpSeq) {
		this.rptDpSeq = rptDpSeq;
	}
	
	/**
	 * Column Info
	 * @param dueOutQty
	 */
	public void setDueOutQty(String dueOutQty) {
		this.dueOutQty = dueOutQty;
	}
	
	/**
	 * Column Info
	 * @param variQty
	 */
	public void setVariQty(String variQty) {
		this.variQty = variQty;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param opmzQty
	 */
	public void setOpmzQty(String opmzQty) {
		this.opmzQty = opmzQty;
	}
	
	/**
	 * Column Info
	 * @param dueInQty
	 */
	public void setDueInQty(String dueInQty) {
		this.dueInQty = dueInQty;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param dmgQty
	 */
	public void setDmgQty(String dmgQty) {
		this.dmgQty = dmgQty;
	}
	
	/**
	 * Column Info
	 * @param cntrQty
	 */
	public void setCntrQty(String cntrQty) {
		this.cntrQty = cntrQty;
	}
	
	/**
	 * Column Info
	 * @param sndQty
	 */
	public void setSndQty(String sndQty) {
		this.sndQty = sndQty;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param fmDur
	 */
	public void setFmDur(String fmDur) {
		this.fmDur = fmDur;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setAvalQty(JSPUtil.getParameter(request, "aval_qty", ""));
		setTotQty(JSPUtil.getParameter(request, "tot_qty", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setRptDpSeq(JSPUtil.getParameter(request, "rpt_dp_seq", ""));
		setDueOutQty(JSPUtil.getParameter(request, "due_out_qty", ""));
		setVariQty(JSPUtil.getParameter(request, "vari_qty", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setOpmzQty(JSPUtil.getParameter(request, "opmz_qty", ""));
		setDueInQty(JSPUtil.getParameter(request, "due_in_qty", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setDmgQty(JSPUtil.getParameter(request, "dmg_qty", ""));
		setCntrQty(JSPUtil.getParameter(request, "cntr_qty", ""));
		setSndQty(JSPUtil.getParameter(request, "snd_qty", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setFmDur(JSPUtil.getParameter(request, "fm_dur", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return StockSmryVO[]
	 */
	public StockSmryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return StockSmryVO[]
	 */
	public StockSmryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		StockSmryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] avalQty = (JSPUtil.getParameter(request, prefix	+ "aval_qty", length));
			String[] totQty = (JSPUtil.getParameter(request, prefix	+ "tot_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rptDpSeq = (JSPUtil.getParameter(request, prefix	+ "rpt_dp_seq", length));
			String[] dueOutQty = (JSPUtil.getParameter(request, prefix	+ "due_out_qty", length));
			String[] variQty = (JSPUtil.getParameter(request, prefix	+ "vari_qty", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] opmzQty = (JSPUtil.getParameter(request, prefix	+ "opmz_qty", length));
			String[] dueInQty = (JSPUtil.getParameter(request, prefix	+ "due_in_qty", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] dmgQty = (JSPUtil.getParameter(request, prefix	+ "dmg_qty", length));
			String[] cntrQty = (JSPUtil.getParameter(request, prefix	+ "cntr_qty", length));
			String[] sndQty = (JSPUtil.getParameter(request, prefix	+ "snd_qty", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] fmDur = (JSPUtil.getParameter(request, prefix	+ "fm_dur", length));
			
			for (int i = 0; i < length; i++) {
				model = new StockSmryVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (avalQty[i] != null)
					model.setAvalQty(avalQty[i]);
				if (totQty[i] != null)
					model.setTotQty(totQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rptDpSeq[i] != null)
					model.setRptDpSeq(rptDpSeq[i]);
				if (dueOutQty[i] != null)
					model.setDueOutQty(dueOutQty[i]);
				if (variQty[i] != null)
					model.setVariQty(variQty[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (opmzQty[i] != null)
					model.setOpmzQty(opmzQty[i]);
				if (dueInQty[i] != null)
					model.setDueInQty(dueInQty[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (dmgQty[i] != null)
					model.setDmgQty(dmgQty[i]);
				if (cntrQty[i] != null)
					model.setCntrQty(cntrQty[i]);
				if (sndQty[i] != null)
					model.setSndQty(sndQty[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (fmDur[i] != null)
					model.setFmDur(fmDur[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getStockSmryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return StockSmryVO[]
	 */
	public StockSmryVO[] getStockSmryVOs(){
		StockSmryVO[] vos = (StockSmryVO[])models.toArray(new StockSmryVO[models.size()]);
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
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avalQty = this.avalQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totQty = this.totQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptDpSeq = this.rptDpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueOutQty = this.dueOutQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.variQty = this.variQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opmzQty = this.opmzQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueInQty = this.dueInQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgQty = this.dmgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrQty = this.cntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndQty = this.sndQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDur = this.fmDur .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

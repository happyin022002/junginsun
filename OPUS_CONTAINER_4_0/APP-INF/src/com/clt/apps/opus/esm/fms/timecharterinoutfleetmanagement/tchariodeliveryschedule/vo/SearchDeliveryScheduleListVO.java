/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchDeliveryScheduleListVO.java
*@FileTitle : SearchDeliveryScheduleListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.04.24 최우석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.vo;

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
 * @author 최우석
 * @see
 * @since J2EE 1.5
 */

public class SearchDeliveryScheduleListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchDeliveryScheduleListVO> models = new ArrayList<SearchDeliveryScheduleListVO>();
	
	/* Column Info */
	private String shpNm = null;
	/* Column Info */
	private String shpBldNm = null;
	/* Column Info */
	private String vslDeDt = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String rfCntrPlgQty = null;
	/* Column Info */
	private String ownrSeq = null;
	/* Column Info */
	private String shpYdNm = null;
	/* Column Info */
	private String ownrNm = null;
	/* Column Info */
	private String ydSeq = null;
	/* Column Info */
	private String bse14tonVslCapa = null;
	/* Column Info */
	private String shpDeSeq = null;
	/* Column Info */
	private String fletCtrtDurCtnt = null;
	/* Column Info */
	private String vslDzndCapa = null;
	/* Column Info */
	private String trdHusNm = null;
	/* Column Info */
	private String shpSpdQty = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchDeliveryScheduleListVO() {}

	public SearchDeliveryScheduleListVO(String ibflag, String pagerows, String shpDeSeq, String shpNm, String shpBldNm, String vslDzndCapa, String bse14tonVslCapa, String rfCntrPlgQty, String shpSpdQty, String fletCtrtDurCtnt, String trdHusNm, String vslDeDt, String ydSeq, String shpYdNm, String ownrSeq, String ownrNm) {
		this.shpNm = shpNm;
		this.shpBldNm = shpBldNm;
		this.vslDeDt = vslDeDt;
		this.ibflag = ibflag;
		this.rfCntrPlgQty = rfCntrPlgQty;
		this.ownrSeq = ownrSeq;
		this.shpYdNm = shpYdNm;
		this.ownrNm = ownrNm;
		this.ydSeq = ydSeq;
		this.bse14tonVslCapa = bse14tonVslCapa;
		this.shpDeSeq = shpDeSeq;
		this.fletCtrtDurCtnt = fletCtrtDurCtnt;
		this.vslDzndCapa = vslDzndCapa;
		this.trdHusNm = trdHusNm;
		this.shpSpdQty = shpSpdQty;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("shp_nm", getShpNm());
		this.hashColumns.put("shp_bld_nm", getShpBldNm());
		this.hashColumns.put("vsl_de_dt", getVslDeDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rf_cntr_plg_qty", getRfCntrPlgQty());
		this.hashColumns.put("ownr_seq", getOwnrSeq());
		this.hashColumns.put("shp_yd_nm", getShpYdNm());
		this.hashColumns.put("ownr_nm", getOwnrNm());
		this.hashColumns.put("yd_seq", getYdSeq());
		this.hashColumns.put("bse_14ton_vsl_capa", getBse14tonVslCapa());
		this.hashColumns.put("shp_de_seq", getShpDeSeq());
		this.hashColumns.put("flet_ctrt_dur_ctnt", getFletCtrtDurCtnt());
		this.hashColumns.put("vsl_dznd_capa", getVslDzndCapa());
		this.hashColumns.put("trd_hus_nm", getTrdHusNm());
		this.hashColumns.put("shp_spd_qty", getShpSpdQty());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("shp_nm", "shpNm");
		this.hashFields.put("shp_bld_nm", "shpBldNm");
		this.hashFields.put("vsl_de_dt", "vslDeDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rf_cntr_plg_qty", "rfCntrPlgQty");
		this.hashFields.put("ownr_seq", "ownrSeq");
		this.hashFields.put("shp_yd_nm", "shpYdNm");
		this.hashFields.put("ownr_nm", "ownrNm");
		this.hashFields.put("yd_seq", "ydSeq");
		this.hashFields.put("bse_14ton_vsl_capa", "bse14tonVslCapa");
		this.hashFields.put("shp_de_seq", "shpDeSeq");
		this.hashFields.put("flet_ctrt_dur_ctnt", "fletCtrtDurCtnt");
		this.hashFields.put("vsl_dznd_capa", "vslDzndCapa");
		this.hashFields.put("trd_hus_nm", "trdHusNm");
		this.hashFields.put("shp_spd_qty", "shpSpdQty");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getShpNm() {
		return this.shpNm;
	}
	public String getShpBldNm() {
		return this.shpBldNm;
	}
	public String getVslDeDt() {
		return this.vslDeDt;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getRfCntrPlgQty() {
		return this.rfCntrPlgQty;
	}
	public String getOwnrSeq() {
		return this.ownrSeq;
	}
	public String getShpYdNm() {
		return this.shpYdNm;
	}
	public String getOwnrNm() {
		return this.ownrNm;
	}
	public String getYdSeq() {
		return this.ydSeq;
	}
	public String getBse14tonVslCapa() {
		return this.bse14tonVslCapa;
	}
	public String getShpDeSeq() {
		return this.shpDeSeq;
	}
	public String getFletCtrtDurCtnt() {
		return this.fletCtrtDurCtnt;
	}
	public String getVslDzndCapa() {
		return this.vslDzndCapa;
	}
	public String getTrdHusNm() {
		return this.trdHusNm;
	}
	public String getShpSpdQty() {
		return this.shpSpdQty;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setShpNm(String shpNm) {
		this.shpNm = shpNm;
		//this.shpNm=true;
	}
	public void setShpBldNm(String shpBldNm) {
		this.shpBldNm = shpBldNm;
		//this.shpBldNm=true;
	}
	public void setVslDeDt(String vslDeDt) {
		this.vslDeDt = vslDeDt;
		//this.vslDeDt=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setRfCntrPlgQty(String rfCntrPlgQty) {
		this.rfCntrPlgQty = rfCntrPlgQty;
		//this.rfCntrPlgQty=true;
	}
	public void setOwnrSeq(String ownrSeq) {
		this.ownrSeq = ownrSeq;
		//this.ownrSeq=true;
	}
	public void setShpYdNm(String shpYdNm) {
		this.shpYdNm = shpYdNm;
		//this.shpYdNm=true;
	}
	public void setOwnrNm(String ownrNm) {
		this.ownrNm = ownrNm;
		//this.ownrNm=true;
	}
	public void setYdSeq(String ydSeq) {
		this.ydSeq = ydSeq;
		//this.ydSeq=true;
	}
	public void setBse14tonVslCapa(String bse14tonVslCapa) {
		this.bse14tonVslCapa = bse14tonVslCapa;
		//this.bse14tonVslCapa=true;
	}
	public void setShpDeSeq(String shpDeSeq) {
		this.shpDeSeq = shpDeSeq;
		//this.shpDeSeq=true;
	}
	public void setFletCtrtDurCtnt(String fletCtrtDurCtnt) {
		this.fletCtrtDurCtnt = fletCtrtDurCtnt;
		//this.fletCtrtDurCtnt=true;
	}
	public void setVslDzndCapa(String vslDzndCapa) {
		this.vslDzndCapa = vslDzndCapa;
		//this.vslDzndCapa=true;
	}
	public void setTrdHusNm(String trdHusNm) {
		this.trdHusNm = trdHusNm;
		//this.trdHusNm=true;
	}
	public void setShpSpdQty(String shpSpdQty) {
		this.shpSpdQty = shpSpdQty;
		//this.shpSpdQty=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setShpNm(JSPUtil.getParameter(request, "shp_nm", ""));
		setShpBldNm(JSPUtil.getParameter(request, "shp_bld_nm", ""));
		setVslDeDt(JSPUtil.getParameter(request, "vsl_de_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRfCntrPlgQty(JSPUtil.getParameter(request, "rf_cntr_plg_qty", ""));
		setOwnrSeq(JSPUtil.getParameter(request, "ownr_seq", ""));
		setShpYdNm(JSPUtil.getParameter(request, "shp_yd_nm", ""));
		setOwnrNm(JSPUtil.getParameter(request, "ownr_nm", ""));
		setYdSeq(JSPUtil.getParameter(request, "yd_seq", ""));
		setBse14tonVslCapa(JSPUtil.getParameter(request, "bse_14ton_vsl_capa", ""));
		setShpDeSeq(JSPUtil.getParameter(request, "shp_de_seq", ""));
		setFletCtrtDurCtnt(JSPUtil.getParameter(request, "flet_ctrt_dur_ctnt", ""));
		setVslDzndCapa(JSPUtil.getParameter(request, "vsl_dznd_capa", ""));
		setTrdHusNm(JSPUtil.getParameter(request, "trd_hus_nm", ""));
		setShpSpdQty(JSPUtil.getParameter(request, "shp_spd_qty", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public SearchDeliveryScheduleListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public SearchDeliveryScheduleListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchDeliveryScheduleListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] shpNm = (JSPUtil.getParameter(request, prefix	+ "shp_nm".trim(), length));
			String[] shpBldNm = (JSPUtil.getParameter(request, prefix	+ "shp_bld_nm".trim(), length));
			String[] vslDeDt = (JSPUtil.getParameter(request, prefix	+ "vsl_de_dt".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] rfCntrPlgQty = (JSPUtil.getParameter(request, prefix	+ "rf_cntr_plg_qty".trim(), length));
			String[] ownrSeq = (JSPUtil.getParameter(request, prefix	+ "ownr_seq".trim(), length));
			String[] shpYdNm = (JSPUtil.getParameter(request, prefix	+ "shp_yd_nm".trim(), length));
			String[] ownrNm = (JSPUtil.getParameter(request, prefix	+ "ownr_nm".trim(), length));
			String[] ydSeq = (JSPUtil.getParameter(request, prefix	+ "yd_seq".trim(), length));
			String[] bse14tonVslCapa = (JSPUtil.getParameter(request, prefix	+ "bse_14ton_vsl_capa".trim(), length));
			String[] shpDeSeq = (JSPUtil.getParameter(request, prefix	+ "shp_de_seq".trim(), length));
			String[] fletCtrtDurCtnt = (JSPUtil.getParameter(request, prefix	+ "flet_ctrt_dur_ctnt".trim(), length));
			String[] vslDzndCapa = (JSPUtil.getParameter(request, prefix	+ "vsl_dznd_capa".trim(), length));
			String[] trdHusNm = (JSPUtil.getParameter(request, prefix	+ "trd_hus_nm".trim(), length));
			String[] shpSpdQty = (JSPUtil.getParameter(request, prefix	+ "shp_spd_qty".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchDeliveryScheduleListVO();
				if (shpNm[i] != null)
					model.setShpNm(shpNm[i]);
				if (shpBldNm[i] != null)
					model.setShpBldNm(shpBldNm[i]);
				if (vslDeDt[i] != null)
					model.setVslDeDt(vslDeDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rfCntrPlgQty[i] != null)
					model.setRfCntrPlgQty(rfCntrPlgQty[i]);
				if (ownrSeq[i] != null)
					model.setOwnrSeq(ownrSeq[i]);
				if (shpYdNm[i] != null)
					model.setShpYdNm(shpYdNm[i]);
				if (ownrNm[i] != null)
					model.setOwnrNm(ownrNm[i]);
				if (ydSeq[i] != null)
					model.setYdSeq(ydSeq[i]);
				if (bse14tonVslCapa[i] != null)
					model.setBse14tonVslCapa(bse14tonVslCapa[i]);
				if (shpDeSeq[i] != null)
					model.setShpDeSeq(shpDeSeq[i]);
				if (fletCtrtDurCtnt[i] != null)
					model.setFletCtrtDurCtnt(fletCtrtDurCtnt[i]);
				if (vslDzndCapa[i] != null)
					model.setVslDzndCapa(vslDzndCapa[i]);
				if (trdHusNm[i] != null)
					model.setTrdHusNm(trdHusNm[i]);
				if (shpSpdQty[i] != null)
					model.setShpSpdQty(shpSpdQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getSearchDeliveryScheduleListVOs();
	}

	public SearchDeliveryScheduleListVO[] getSearchDeliveryScheduleListVOs(){
		SearchDeliveryScheduleListVO[] vos = (SearchDeliveryScheduleListVO[])models.toArray(new SearchDeliveryScheduleListVO[models.size()]);
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
		this.shpNm = this.shpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpBldNm = this.shpBldNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDeDt = this.vslDeDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfCntrPlgQty = this.rfCntrPlgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrSeq = this.ownrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpYdNm = this.shpYdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrNm = this.ownrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydSeq = this.ydSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bse14tonVslCapa = this.bse14tonVslCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpDeSeq = this.shpDeSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtDurCtnt = this.fletCtrtDurCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDzndCapa = this.vslDzndCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdHusNm = this.trdHusNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpSpdQty = this.shpSpdQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

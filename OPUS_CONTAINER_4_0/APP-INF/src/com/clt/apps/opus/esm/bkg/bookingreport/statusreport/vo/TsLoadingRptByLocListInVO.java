/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TsLoadingRptByLocListInVO.java
*@FileTitle : TsLoadingRptByLocListInVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.10.07 김경섭 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo;

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
 * @author 김경섭
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TsLoadingRptByLocListInVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TsLoadingRptByLocListInVO> models = new ArrayList<TsLoadingRptByLocListInVO>();
	
	/* Column Info */
	private String orderByTitle = null;
	/* Column Info */
	private String outTmnl = null;
	/* Column Info */
	private String orderBy = null;
	/* Column Info */
	private String tradeZone = null;
	/* Column Info */
	private String blTypeOb = null;
	/* Column Info */
	private String blTypeTs = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String locationCd = null;
	/* Column Info */
	private String duraToDt = null;
	/* Column Info */
	private String shipperCd = null;
	/* Column Info */
	private String locationYdCd = null;
	/* Column Info */
	private String duraFromDt = null;
	/* Column Info */
	private String outLane = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TsLoadingRptByLocListInVO() {}

	public TsLoadingRptByLocListInVO(String ibflag, String pagerows, String locationCd, String locationYdCd, String duraFromDt, String duraToDt, String blTypeOb, String blTypeTs, String tradeZone, String polCd, String podCd, String outLane, String outTmnl, String shipperCd, String orderBy, String orderByTitle) {
		this.orderByTitle = orderByTitle;
		this.outTmnl = outTmnl;
		this.orderBy = orderBy;
		this.tradeZone = tradeZone;
		this.blTypeOb = blTypeOb;
		this.blTypeTs = blTypeTs;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.locationCd = locationCd;
		this.duraToDt = duraToDt;
		this.shipperCd = shipperCd;
		this.locationYdCd = locationYdCd;
		this.duraFromDt = duraFromDt;
		this.outLane = outLane;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("order_by_title", getOrderByTitle());
		this.hashColumns.put("out_tmnl", getOutTmnl());
		this.hashColumns.put("order_by", getOrderBy());
		this.hashColumns.put("trade_zone", getTradeZone());
		this.hashColumns.put("bl_type_ob", getBlTypeOb());
		this.hashColumns.put("bl_type_ts", getBlTypeTs());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("location_cd", getLocationCd());
		this.hashColumns.put("dura_to_dt", getDuraToDt());
		this.hashColumns.put("shipper_cd", getShipperCd());
		this.hashColumns.put("location_yd_cd", getLocationYdCd());
		this.hashColumns.put("dura_from_dt", getDuraFromDt());
		this.hashColumns.put("out_lane", getOutLane());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("order_by_title", "orderByTitle");
		this.hashFields.put("out_tmnl", "outTmnl");
		this.hashFields.put("order_by", "orderBy");
		this.hashFields.put("trade_zone", "tradeZone");
		this.hashFields.put("bl_type_ob", "blTypeOb");
		this.hashFields.put("bl_type_ts", "blTypeTs");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("location_cd", "locationCd");
		this.hashFields.put("dura_to_dt", "duraToDt");
		this.hashFields.put("shipper_cd", "shipperCd");
		this.hashFields.put("location_yd_cd", "locationYdCd");
		this.hashFields.put("dura_from_dt", "duraFromDt");
		this.hashFields.put("out_lane", "outLane");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return orderByTitle
	 */
	public String getOrderByTitle() {
		return this.orderByTitle;
	}
	
	/**
	 * Column Info
	 * @return outTmnl
	 */
	public String getOutTmnl() {
		return this.outTmnl;
	}
	
	/**
	 * Column Info
	 * @return orderBy
	 */
	public String getOrderBy() {
		return this.orderBy;
	}
	
	/**
	 * Column Info
	 * @return tradeZone
	 */
	public String getTradeZone() {
		return this.tradeZone;
	}
	
	/**
	 * Column Info
	 * @return blTypeOb
	 */
	public String getBlTypeOb() {
		return this.blTypeOb;
	}
	
	/**
	 * Column Info
	 * @return blTypeTs
	 */
	public String getBlTypeTs() {
		return this.blTypeTs;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return locationCd
	 */
	public String getLocationCd() {
		return this.locationCd;
	}
	
	/**
	 * Column Info
	 * @return duraToDt
	 */
	public String getDuraToDt() {
		return this.duraToDt;
	}
	
	/**
	 * Column Info
	 * @return shipperCd
	 */
	public String getShipperCd() {
		return this.shipperCd;
	}
	
	/**
	 * Column Info
	 * @return locationYdCd
	 */
	public String getLocationYdCd() {
		return this.locationYdCd;
	}
	
	/**
	 * Column Info
	 * @return duraFromDt
	 */
	public String getDuraFromDt() {
		return this.duraFromDt;
	}
	
	/**
	 * Column Info
	 * @return outLane
	 */
	public String getOutLane() {
		return this.outLane;
	}
	

	/**
	 * Column Info
	 * @param orderByTitle
	 */
	public void setOrderByTitle(String orderByTitle) {
		this.orderByTitle = orderByTitle;
	}
	
	/**
	 * Column Info
	 * @param outTmnl
	 */
	public void setOutTmnl(String outTmnl) {
		this.outTmnl = outTmnl;
	}
	
	/**
	 * Column Info
	 * @param orderBy
	 */
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
	/**
	 * Column Info
	 * @param tradeZone
	 */
	public void setTradeZone(String tradeZone) {
		this.tradeZone = tradeZone;
	}
	
	/**
	 * Column Info
	 * @param blTypeOb
	 */
	public void setBlTypeOb(String blTypeOb) {
		this.blTypeOb = blTypeOb;
	}
	
	/**
	 * Column Info
	 * @param blTypeTs
	 */
	public void setBlTypeTs(String blTypeTs) {
		this.blTypeTs = blTypeTs;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param locationCd
	 */
	public void setLocationCd(String locationCd) {
		this.locationCd = locationCd;
	}
	
	/**
	 * Column Info
	 * @param duraToDt
	 */
	public void setDuraToDt(String duraToDt) {
		this.duraToDt = duraToDt;
	}
	
	/**
	 * Column Info
	 * @param shipperCd
	 */
	public void setShipperCd(String shipperCd) {
		this.shipperCd = shipperCd;
	}
	
	/**
	 * Column Info
	 * @param locationYdCd
	 */
	public void setLocationYdCd(String locationYdCd) {
		this.locationYdCd = locationYdCd;
	}
	
	/**
	 * Column Info
	 * @param duraFromDt
	 */
	public void setDuraFromDt(String duraFromDt) {
		this.duraFromDt = duraFromDt;
	}
	
	/**
	 * Column Info
	 * @param outLane
	 */
	public void setOutLane(String outLane) {
		this.outLane = outLane;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setOrderByTitle(JSPUtil.getParameter(request, "order_by_title", ""));
		setOutTmnl(JSPUtil.getParameter(request, "out_tmnl", ""));
		setOrderBy(JSPUtil.getParameter(request, "order_by", ""));
		setTradeZone(JSPUtil.getParameter(request, "trade_zone", ""));
		setBlTypeOb(JSPUtil.getParameter(request, "bl_type_ob", ""));
		setBlTypeTs(JSPUtil.getParameter(request, "bl_type_ts", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setLocationCd(JSPUtil.getParameter(request, "location_cd", ""));
		setDuraToDt(JSPUtil.getParameter(request, "dura_to_dt", ""));
		setShipperCd(JSPUtil.getParameter(request, "shipper_cd", ""));
		setLocationYdCd(JSPUtil.getParameter(request, "location_yd_cd", ""));
		setDuraFromDt(JSPUtil.getParameter(request, "dura_from_dt", ""));
		setOutLane(JSPUtil.getParameter(request, "out_lane", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TsLoadingRptByLocListInVO[]
	 */
	public TsLoadingRptByLocListInVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TsLoadingRptByLocListInVO[]
	 */
	public TsLoadingRptByLocListInVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TsLoadingRptByLocListInVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] orderByTitle = (JSPUtil.getParameter(request, prefix	+ "order_by_title", length));
			String[] outTmnl = (JSPUtil.getParameter(request, prefix	+ "out_tmnl", length));
			String[] orderBy = (JSPUtil.getParameter(request, prefix	+ "order_by", length));
			String[] tradeZone = (JSPUtil.getParameter(request, prefix	+ "trade_zone", length));
			String[] blTypeOb = (JSPUtil.getParameter(request, prefix	+ "bl_type_ob", length));
			String[] blTypeTs = (JSPUtil.getParameter(request, prefix	+ "bl_type_ts", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] locationCd = (JSPUtil.getParameter(request, prefix	+ "location_cd", length));
			String[] duraToDt = (JSPUtil.getParameter(request, prefix	+ "dura_to_dt", length));
			String[] shipperCd = (JSPUtil.getParameter(request, prefix	+ "shipper_cd", length));
			String[] locationYdCd = (JSPUtil.getParameter(request, prefix	+ "location_yd_cd", length));
			String[] duraFromDt = (JSPUtil.getParameter(request, prefix	+ "dura_from_dt", length));
			String[] outLane = (JSPUtil.getParameter(request, prefix	+ "out_lane", length));
			
			for (int i = 0; i < length; i++) {
				model = new TsLoadingRptByLocListInVO();
				if (orderByTitle[i] != null)
					model.setOrderByTitle(orderByTitle[i]);
				if (outTmnl[i] != null)
					model.setOutTmnl(outTmnl[i]);
				if (orderBy[i] != null)
					model.setOrderBy(orderBy[i]);
				if (tradeZone[i] != null)
					model.setTradeZone(tradeZone[i]);
				if (blTypeOb[i] != null)
					model.setBlTypeOb(blTypeOb[i]);
				if (blTypeTs[i] != null)
					model.setBlTypeTs(blTypeTs[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (locationCd[i] != null)
					model.setLocationCd(locationCd[i]);
				if (duraToDt[i] != null)
					model.setDuraToDt(duraToDt[i]);
				if (shipperCd[i] != null)
					model.setShipperCd(shipperCd[i]);
				if (locationYdCd[i] != null)
					model.setLocationYdCd(locationYdCd[i]);
				if (duraFromDt[i] != null)
					model.setDuraFromDt(duraFromDt[i]);
				if (outLane[i] != null)
					model.setOutLane(outLane[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTsLoadingRptByLocListInVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TsLoadingRptByLocListInVO[]
	 */
	public TsLoadingRptByLocListInVO[] getTsLoadingRptByLocListInVOs(){
		TsLoadingRptByLocListInVO[] vos = (TsLoadingRptByLocListInVO[])models.toArray(new TsLoadingRptByLocListInVO[models.size()]);
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
		this.orderByTitle = this.orderByTitle .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outTmnl = this.outTmnl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orderBy = this.orderBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tradeZone = this.tradeZone .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTypeOb = this.blTypeOb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTypeTs = this.blTypeTs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locationCd = this.locationCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duraToDt = this.duraToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipperCd = this.shipperCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locationYdCd = this.locationYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duraFromDt = this.duraFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outLane = this.outLane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

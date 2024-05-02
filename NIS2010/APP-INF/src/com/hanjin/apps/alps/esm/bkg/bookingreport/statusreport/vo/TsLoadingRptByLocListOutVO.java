/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TsLoadingRptByLocListOutVO.java
*@FileTitle : TsLoadingRptByLocListOutVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.10.07 김경섭 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo;

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
 * @author 김경섭
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TsLoadingRptByLocListOutVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TsLoadingRptByLocListOutVO> models = new ArrayList<TsLoadingRptByLocListOutVO>();
	
	/* Column Info */
	private String inVvd = null;
	/* Column Info */
	private String orderByTitle = null;
	/* Column Info */
	private String outTmnl = null;
	/* Column Info */
	private String feu = null;
	/* Column Info */
	private String total20t = null;
	/* Column Info */
	private String orderBy = null;
	/* Column Info */
	private String seqNo = null;
	/* Column Info */
	private String outZone = null;
	/* Column Info */
	private String inLane = null;
	/* Column Info */
	private String inZone = null;
	/* Column Info */
	private String outVvd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String total40t = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String shipperNm = null;
	/* Column Info */
	private String shipperCd = null;
	/* Column Info */
	private String teu = null;
	/* Column Info */
	private String inTmnl = null;
	/* Column Info */
	private String outLane = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TsLoadingRptByLocListOutVO() {}

	public TsLoadingRptByLocListOutVO(String ibflag, String pagerows, String seqNo, String bkgNo, String shipperCd, String polCd, String podCd, String inVvd, String outVvd, String feu, String teu, String orderBy, String orderByTitle, String blNo, String shipperNm, String inLane, String outLane, String inTmnl, String outTmnl, String inZone, String outZone, String total40t, String total20t) {
		this.inVvd = inVvd;
		this.orderByTitle = orderByTitle;
		this.outTmnl = outTmnl;
		this.feu = feu;
		this.total20t = total20t;
		this.orderBy = orderBy;
		this.seqNo = seqNo;
		this.outZone = outZone;
		this.inLane = inLane;
		this.inZone = inZone;
		this.outVvd = outVvd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.total40t = total40t;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.polCd = polCd;
		this.shipperNm = shipperNm;
		this.shipperCd = shipperCd;
		this.teu = teu;
		this.inTmnl = inTmnl;
		this.outLane = outLane;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("in_vvd", getInVvd());
		this.hashColumns.put("order_by_title", getOrderByTitle());
		this.hashColumns.put("out_tmnl", getOutTmnl());
		this.hashColumns.put("feu", getFeu());
		this.hashColumns.put("total_20t", getTotal20t());
		this.hashColumns.put("order_by", getOrderBy());
		this.hashColumns.put("seq_no", getSeqNo());
		this.hashColumns.put("out_zone", getOutZone());
		this.hashColumns.put("in_lane", getInLane());
		this.hashColumns.put("in_zone", getInZone());
		this.hashColumns.put("out_vvd", getOutVvd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("total_40t", getTotal40t());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("shipper_nm", getShipperNm());
		this.hashColumns.put("shipper_cd", getShipperCd());
		this.hashColumns.put("teu", getTeu());
		this.hashColumns.put("in_tmnl", getInTmnl());
		this.hashColumns.put("out_lane", getOutLane());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("in_vvd", "inVvd");
		this.hashFields.put("order_by_title", "orderByTitle");
		this.hashFields.put("out_tmnl", "outTmnl");
		this.hashFields.put("feu", "feu");
		this.hashFields.put("total_20t", "total20t");
		this.hashFields.put("order_by", "orderBy");
		this.hashFields.put("seq_no", "seqNo");
		this.hashFields.put("out_zone", "outZone");
		this.hashFields.put("in_lane", "inLane");
		this.hashFields.put("in_zone", "inZone");
		this.hashFields.put("out_vvd", "outVvd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("total_40t", "total40t");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("shipper_nm", "shipperNm");
		this.hashFields.put("shipper_cd", "shipperCd");
		this.hashFields.put("teu", "teu");
		this.hashFields.put("in_tmnl", "inTmnl");
		this.hashFields.put("out_lane", "outLane");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return inVvd
	 */
	public String getInVvd() {
		return this.inVvd;
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
	 * @return feu
	 */
	public String getFeu() {
		return this.feu;
	}
	
	/**
	 * Column Info
	 * @return total20t
	 */
	public String getTotal20t() {
		return this.total20t;
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
	 * @return seqNo
	 */
	public String getSeqNo() {
		return this.seqNo;
	}
	
	/**
	 * Column Info
	 * @return outZone
	 */
	public String getOutZone() {
		return this.outZone;
	}
	
	/**
	 * Column Info
	 * @return inLane
	 */
	public String getInLane() {
		return this.inLane;
	}
	
	/**
	 * Column Info
	 * @return inZone
	 */
	public String getInZone() {
		return this.inZone;
	}
	
	/**
	 * Column Info
	 * @return outVvd
	 */
	public String getOutVvd() {
		return this.outVvd;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * Column Info
	 * @return total40t
	 */
	public String getTotal40t() {
		return this.total40t;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return shipperNm
	 */
	public String getShipperNm() {
		return this.shipperNm;
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
	 * @return teu
	 */
	public String getTeu() {
		return this.teu;
	}
	
	/**
	 * Column Info
	 * @return inTmnl
	 */
	public String getInTmnl() {
		return this.inTmnl;
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
	 * @param inVvd
	 */
	public void setInVvd(String inVvd) {
		this.inVvd = inVvd;
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
	 * @param feu
	 */
	public void setFeu(String feu) {
		this.feu = feu;
	}
	
	/**
	 * Column Info
	 * @param total20t
	 */
	public void setTotal20t(String total20t) {
		this.total20t = total20t;
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
	 * @param seqNo
	 */
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}
	
	/**
	 * Column Info
	 * @param outZone
	 */
	public void setOutZone(String outZone) {
		this.outZone = outZone;
	}
	
	/**
	 * Column Info
	 * @param inLane
	 */
	public void setInLane(String inLane) {
		this.inLane = inLane;
	}
	
	/**
	 * Column Info
	 * @param inZone
	 */
	public void setInZone(String inZone) {
		this.inZone = inZone;
	}
	
	/**
	 * Column Info
	 * @param outVvd
	 */
	public void setOutVvd(String outVvd) {
		this.outVvd = outVvd;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * Column Info
	 * @param total40t
	 */
	public void setTotal40t(String total40t) {
		this.total40t = total40t;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param shipperNm
	 */
	public void setShipperNm(String shipperNm) {
		this.shipperNm = shipperNm;
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
	 * @param teu
	 */
	public void setTeu(String teu) {
		this.teu = teu;
	}
	
	/**
	 * Column Info
	 * @param inTmnl
	 */
	public void setInTmnl(String inTmnl) {
		this.inTmnl = inTmnl;
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
		setInVvd(JSPUtil.getParameter(request, "in_vvd", ""));
		setOrderByTitle(JSPUtil.getParameter(request, "order_by_title", ""));
		setOutTmnl(JSPUtil.getParameter(request, "out_tmnl", ""));
		setFeu(JSPUtil.getParameter(request, "feu", ""));
		setTotal20t(JSPUtil.getParameter(request, "total_20t", ""));
		setOrderBy(JSPUtil.getParameter(request, "order_by", ""));
		setSeqNo(JSPUtil.getParameter(request, "seq_no", ""));
		setOutZone(JSPUtil.getParameter(request, "out_zone", ""));
		setInLane(JSPUtil.getParameter(request, "in_lane", ""));
		setInZone(JSPUtil.getParameter(request, "in_zone", ""));
		setOutVvd(JSPUtil.getParameter(request, "out_vvd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setTotal40t(JSPUtil.getParameter(request, "total_40t", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setShipperNm(JSPUtil.getParameter(request, "shipper_nm", ""));
		setShipperCd(JSPUtil.getParameter(request, "shipper_cd", ""));
		setTeu(JSPUtil.getParameter(request, "teu", ""));
		setInTmnl(JSPUtil.getParameter(request, "in_tmnl", ""));
		setOutLane(JSPUtil.getParameter(request, "out_lane", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TsLoadingRptByLocListOutVO[]
	 */
	public TsLoadingRptByLocListOutVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TsLoadingRptByLocListOutVO[]
	 */
	public TsLoadingRptByLocListOutVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TsLoadingRptByLocListOutVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] inVvd = (JSPUtil.getParameter(request, prefix	+ "in_vvd", length));
			String[] orderByTitle = (JSPUtil.getParameter(request, prefix	+ "order_by_title", length));
			String[] outTmnl = (JSPUtil.getParameter(request, prefix	+ "out_tmnl", length));
			String[] feu = (JSPUtil.getParameter(request, prefix	+ "feu", length));
			String[] total20t = (JSPUtil.getParameter(request, prefix	+ "total_20t", length));
			String[] orderBy = (JSPUtil.getParameter(request, prefix	+ "order_by", length));
			String[] seqNo = (JSPUtil.getParameter(request, prefix	+ "seq_no", length));
			String[] outZone = (JSPUtil.getParameter(request, prefix	+ "out_zone", length));
			String[] inLane = (JSPUtil.getParameter(request, prefix	+ "in_lane", length));
			String[] inZone = (JSPUtil.getParameter(request, prefix	+ "in_zone", length));
			String[] outVvd = (JSPUtil.getParameter(request, prefix	+ "out_vvd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] total40t = (JSPUtil.getParameter(request, prefix	+ "total_40t", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] shipperNm = (JSPUtil.getParameter(request, prefix	+ "shipper_nm", length));
			String[] shipperCd = (JSPUtil.getParameter(request, prefix	+ "shipper_cd", length));
			String[] teu = (JSPUtil.getParameter(request, prefix	+ "teu", length));
			String[] inTmnl = (JSPUtil.getParameter(request, prefix	+ "in_tmnl", length));
			String[] outLane = (JSPUtil.getParameter(request, prefix	+ "out_lane", length));
			
			for (int i = 0; i < length; i++) {
				model = new TsLoadingRptByLocListOutVO();
				if (inVvd[i] != null)
					model.setInVvd(inVvd[i]);
				if (orderByTitle[i] != null)
					model.setOrderByTitle(orderByTitle[i]);
				if (outTmnl[i] != null)
					model.setOutTmnl(outTmnl[i]);
				if (feu[i] != null)
					model.setFeu(feu[i]);
				if (total20t[i] != null)
					model.setTotal20t(total20t[i]);
				if (orderBy[i] != null)
					model.setOrderBy(orderBy[i]);
				if (seqNo[i] != null)
					model.setSeqNo(seqNo[i]);
				if (outZone[i] != null)
					model.setOutZone(outZone[i]);
				if (inLane[i] != null)
					model.setInLane(inLane[i]);
				if (inZone[i] != null)
					model.setInZone(inZone[i]);
				if (outVvd[i] != null)
					model.setOutVvd(outVvd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (total40t[i] != null)
					model.setTotal40t(total40t[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (shipperNm[i] != null)
					model.setShipperNm(shipperNm[i]);
				if (shipperCd[i] != null)
					model.setShipperCd(shipperCd[i]);
				if (teu[i] != null)
					model.setTeu(teu[i]);
				if (inTmnl[i] != null)
					model.setInTmnl(inTmnl[i]);
				if (outLane[i] != null)
					model.setOutLane(outLane[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTsLoadingRptByLocListOutVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TsLoadingRptByLocListOutVO[]
	 */
	public TsLoadingRptByLocListOutVO[] getTsLoadingRptByLocListOutVOs(){
		TsLoadingRptByLocListOutVO[] vos = (TsLoadingRptByLocListOutVO[])models.toArray(new TsLoadingRptByLocListOutVO[models.size()]);
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
		this.inVvd = this.inVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orderByTitle = this.orderByTitle .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outTmnl = this.outTmnl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.feu = this.feu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.total20t = this.total20t .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orderBy = this.orderBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seqNo = this.seqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outZone = this.outZone .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inLane = this.inLane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inZone = this.inZone .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outVvd = this.outVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.total40t = this.total40t .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipperNm = this.shipperNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipperCd = this.shipperCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teu = this.teu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inTmnl = this.inTmnl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outLane = this.outLane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

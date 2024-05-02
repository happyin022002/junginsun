/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : HPInvoiceEDIVO.java
*@FileTitle : HPInvoiceEDIVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.16
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.08.16 최도순 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최도순
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class HPInvoiceEDIVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<HPInvoiceEDIVO> models = new ArrayList<HPInvoiceEDIVO>();
	
	/* Column Info */
	private String shipId = null;
	/* Column Info */
	private String hpAckCd = null;
	/* Column Info */
	private String valid = null;
	/* Column Info */
	private String blSrcNo = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String partNo = null;
	/* Column Info */
	private String consigneeCntNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String issDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String shipperCntNm = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String chgAmt = null;
	/* Column Info */
	private String shipperCntCd = null;
	/* Column Info */
	private String ediSndFlg = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String ediAmt = null;
	/* Column Info */
	private String consigneeCntCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public HPInvoiceEDIVO() {}

	public HPInvoiceEDIVO(String ibflag, String pagerows, String blSrcNo, String invNo, String issDt, String chgAmt, String ediAmt, String currCd, String vvd, String polCd, String podCd, String custCd, String shipperCntCd, String shipperCntNm, String consigneeCntCd, String consigneeCntNm, String shipId, String partNo, String valid, String ediSndFlg, String hpAckCd, String updUsrId) {
		this.shipId = shipId;
		this.hpAckCd = hpAckCd;
		this.valid = valid;
		this.blSrcNo = blSrcNo;
		this.currCd = currCd;
		this.partNo = partNo;
		this.consigneeCntNm = consigneeCntNm;
		this.pagerows = pagerows;
		this.invNo = invNo;
		this.vvd = vvd;
		this.podCd = podCd;
		this.issDt = issDt;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.shipperCntNm = shipperCntNm;
		this.custCd = custCd;
		this.chgAmt = chgAmt;
		this.shipperCntCd = shipperCntCd;
		this.ediSndFlg = ediSndFlg;
		this.updUsrId = updUsrId;
		this.ediAmt = ediAmt;
		this.consigneeCntCd = consigneeCntCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ship_id", getShipId());
		this.hashColumns.put("hp_ack_cd", getHpAckCd());
		this.hashColumns.put("valid", getValid());
		this.hashColumns.put("bl_src_no", getBlSrcNo());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("part_no", getPartNo());
		this.hashColumns.put("consignee_cnt_nm", getConsigneeCntNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("iss_dt", getIssDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("shipper_cnt_nm", getShipperCntNm());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("chg_amt", getChgAmt());
		this.hashColumns.put("shipper_cnt_cd", getShipperCntCd());
		this.hashColumns.put("edi_snd_flg", getEdiSndFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("edi_amt", getEdiAmt());
		this.hashColumns.put("consignee_cnt_cd", getConsigneeCntCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ship_id", "shipId");
		this.hashFields.put("hp_ack_cd", "hpAckCd");
		this.hashFields.put("valid", "valid");
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("part_no", "partNo");
		this.hashFields.put("consignee_cnt_nm", "consigneeCntNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("iss_dt", "issDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("shipper_cnt_nm", "shipperCntNm");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("shipper_cnt_cd", "shipperCntCd");
		this.hashFields.put("edi_snd_flg", "ediSndFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("edi_amt", "ediAmt");
		this.hashFields.put("consignee_cnt_cd", "consigneeCntCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return shipId
	 */
	public String getShipId() {
		return this.shipId;
	}
	
	/**
	 * Column Info
	 * @return hpAckCd
	 */
	public String getHpAckCd() {
		return this.hpAckCd;
	}
	
	/**
	 * Column Info
	 * @return valid
	 */
	public String getValid() {
		return this.valid;
	}
	
	/**
	 * Column Info
	 * @return blSrcNo
	 */
	public String getBlSrcNo() {
		return this.blSrcNo;
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
	 * @return partNo
	 */
	public String getPartNo() {
		return this.partNo;
	}
	
	/**
	 * Column Info
	 * @return consigneeCntNm
	 */
	public String getConsigneeCntNm() {
		return this.consigneeCntNm;
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
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return issDt
	 */
	public String getIssDt() {
		return this.issDt;
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
	 * @return shipperCntNm
	 */
	public String getShipperCntNm() {
		return this.shipperCntNm;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return chgAmt
	 */
	public String getChgAmt() {
		return this.chgAmt;
	}
	
	/**
	 * Column Info
	 * @return shipperCntCd
	 */
	public String getShipperCntCd() {
		return this.shipperCntCd;
	}
	
	/**
	 * Column Info
	 * @return ediSndFlg
	 */
	public String getEdiSndFlg() {
		return this.ediSndFlg;
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
	 * @return ediAmt
	 */
	public String getEdiAmt() {
		return this.ediAmt;
	}
	
	/**
	 * Column Info
	 * @return consigneeCntCd
	 */
	public String getConsigneeCntCd() {
		return this.consigneeCntCd;
	}
	

	/**
	 * Column Info
	 * @param shipId
	 */
	public void setShipId(String shipId) {
		this.shipId = shipId;
	}
	
	/**
	 * Column Info
	 * @param hpAckCd
	 */
	public void setHpAckCd(String hpAckCd) {
		this.hpAckCd = hpAckCd;
	}
	
	/**
	 * Column Info
	 * @param valid
	 */
	public void setValid(String valid) {
		this.valid = valid;
	}
	
	/**
	 * Column Info
	 * @param blSrcNo
	 */
	public void setBlSrcNo(String blSrcNo) {
		this.blSrcNo = blSrcNo;
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
	 * @param partNo
	 */
	public void setPartNo(String partNo) {
		this.partNo = partNo;
	}
	
	/**
	 * Column Info
	 * @param consigneeCntNm
	 */
	public void setConsigneeCntNm(String consigneeCntNm) {
		this.consigneeCntNm = consigneeCntNm;
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
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param issDt
	 */
	public void setIssDt(String issDt) {
		this.issDt = issDt;
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
	 * @param shipperCntNm
	 */
	public void setShipperCntNm(String shipperCntNm) {
		this.shipperCntNm = shipperCntNm;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param chgAmt
	 */
	public void setChgAmt(String chgAmt) {
		this.chgAmt = chgAmt;
	}
	
	/**
	 * Column Info
	 * @param shipperCntCd
	 */
	public void setShipperCntCd(String shipperCntCd) {
		this.shipperCntCd = shipperCntCd;
	}
	
	/**
	 * Column Info
	 * @param ediSndFlg
	 */
	public void setEdiSndFlg(String ediSndFlg) {
		this.ediSndFlg = ediSndFlg;
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
	 * @param ediAmt
	 */
	public void setEdiAmt(String ediAmt) {
		this.ediAmt = ediAmt;
	}
	
	/**
	 * Column Info
	 * @param consigneeCntCd
	 */
	public void setConsigneeCntCd(String consigneeCntCd) {
		this.consigneeCntCd = consigneeCntCd;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setShipId(JSPUtil.getParameter(request, prefix + "ship_id", ""));
		setHpAckCd(JSPUtil.getParameter(request, prefix + "hp_ack_cd", ""));
		setValid(JSPUtil.getParameter(request, prefix + "valid", ""));
		setBlSrcNo(JSPUtil.getParameter(request, prefix + "bl_src_no", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setPartNo(JSPUtil.getParameter(request, prefix + "part_no", ""));
		setConsigneeCntNm(JSPUtil.getParameter(request, prefix + "consignee_cnt_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setIssDt(JSPUtil.getParameter(request, prefix + "iss_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setShipperCntNm(JSPUtil.getParameter(request, prefix + "shipper_cnt_nm", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setChgAmt(JSPUtil.getParameter(request, prefix + "chg_amt", ""));
		setShipperCntCd(JSPUtil.getParameter(request, prefix + "shipper_cnt_cd", ""));
		setEdiSndFlg(JSPUtil.getParameter(request, prefix + "edi_snd_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setEdiAmt(JSPUtil.getParameter(request, prefix + "edi_amt", ""));
		setConsigneeCntCd(JSPUtil.getParameter(request, prefix + "consignee_cnt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return HPInvoiceEDIVO[]
	 */
	public HPInvoiceEDIVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return HPInvoiceEDIVO[]
	 */
	public HPInvoiceEDIVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		HPInvoiceEDIVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] shipId = (JSPUtil.getParameter(request, prefix	+ "ship_id", length));
			String[] hpAckCd = (JSPUtil.getParameter(request, prefix	+ "hp_ack_cd", length));
			String[] valid = (JSPUtil.getParameter(request, prefix	+ "valid", length));
			String[] blSrcNo = (JSPUtil.getParameter(request, prefix	+ "bl_src_no", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] partNo = (JSPUtil.getParameter(request, prefix	+ "part_no", length));
			String[] consigneeCntNm = (JSPUtil.getParameter(request, prefix	+ "consignee_cnt_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] issDt = (JSPUtil.getParameter(request, prefix	+ "iss_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] shipperCntNm = (JSPUtil.getParameter(request, prefix	+ "shipper_cnt_nm", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] chgAmt = (JSPUtil.getParameter(request, prefix	+ "chg_amt", length));
			String[] shipperCntCd = (JSPUtil.getParameter(request, prefix	+ "shipper_cnt_cd", length));
			String[] ediSndFlg = (JSPUtil.getParameter(request, prefix	+ "edi_snd_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] ediAmt = (JSPUtil.getParameter(request, prefix	+ "edi_amt", length));
			String[] consigneeCntCd = (JSPUtil.getParameter(request, prefix	+ "consignee_cnt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new HPInvoiceEDIVO();
				if (shipId[i] != null)
					model.setShipId(shipId[i]);
				if (hpAckCd[i] != null)
					model.setHpAckCd(hpAckCd[i]);
				if (valid[i] != null)
					model.setValid(valid[i]);
				if (blSrcNo[i] != null)
					model.setBlSrcNo(blSrcNo[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (partNo[i] != null)
					model.setPartNo(partNo[i]);
				if (consigneeCntNm[i] != null)
					model.setConsigneeCntNm(consigneeCntNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (issDt[i] != null)
					model.setIssDt(issDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (shipperCntNm[i] != null)
					model.setShipperCntNm(shipperCntNm[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (chgAmt[i] != null)
					model.setChgAmt(chgAmt[i]);
				if (shipperCntCd[i] != null)
					model.setShipperCntCd(shipperCntCd[i]);
				if (ediSndFlg[i] != null)
					model.setEdiSndFlg(ediSndFlg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (ediAmt[i] != null)
					model.setEdiAmt(ediAmt[i]);
				if (consigneeCntCd[i] != null)
					model.setConsigneeCntCd(consigneeCntCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getHPInvoiceEDIVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return HPInvoiceEDIVO[]
	 */
	public HPInvoiceEDIVO[] getHPInvoiceEDIVOs(){
		HPInvoiceEDIVO[] vos = (HPInvoiceEDIVO[])models.toArray(new HPInvoiceEDIVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.shipId = this.shipId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hpAckCd = this.hpAckCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.valid = this.valid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrcNo = this.blSrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.partNo = this.partNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consigneeCntNm = this.consigneeCntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt = this.issDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipperCntNm = this.shipperCntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt = this.chgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipperCntCd = this.shipperCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndFlg = this.ediSndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediAmt = this.ediAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consigneeCntCd = this.consigneeCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

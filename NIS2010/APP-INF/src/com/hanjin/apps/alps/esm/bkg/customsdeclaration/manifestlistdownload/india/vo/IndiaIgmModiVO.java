/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : IndiaIgmModiVO.java
*@FileTitle : IndiaIgmModiVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.04
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.04  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.india.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class IndiaIgmModiVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<IndiaIgmModiVO> models = new ArrayList<IndiaIgmModiVO>();
	
	/* Column Info */
	private String ial = null;
	/* Column Info */
	private String idaLineNo = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String blCustTp = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String entryTp = null;
	/* Column Info */
	private String hblInd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String hblNo = null;
	/* Column Info */
	private String cfsBondCd = null;
	/* Column Info */
	private String cfsCd = null;
	/* Column Info */
	private String destCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String customerName = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String bdAreaCd = null;
	/* Column Info */
	private String trnsOprId = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bcdDesc = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String itemTp = null;
	/* Column Info */
	private String modeTrans = null;
	/* Column Info */
	private String downCheck = null;
	/* Column Info */
	private String transOper = null;
	/* Column Info */
	private String ibdNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public IndiaIgmModiVO() {}

	public IndiaIgmModiVO(String ibflag, String pagerows, String vvdCd, String customerName, String ial, String idaLineNo, String delCd, String blCustTp, String blNo, String podCd, String entryTp, String bcdDesc, String hblInd, String polCd, String itemTp, String modeTrans, String hblNo, String transOper, String cfsBondCd, String cfsCd, String destCd, String creUsrId, String updUsrId, String downCheck, String ibdNo, String bdAreaCd, String trnsOprId) {
		this.ial = ial;
		this.idaLineNo = idaLineNo;
		this.blNo = blNo;
		this.blCustTp = blCustTp;
		this.pagerows = pagerows;
		this.entryTp = entryTp;
		this.hblInd = hblInd;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.vvdCd = vvdCd;
		this.hblNo = hblNo;
		this.cfsBondCd = cfsBondCd;
		this.cfsCd = cfsCd;
		this.destCd = destCd;
		this.updUsrId = updUsrId;
		this.customerName = customerName;
		this.delCd = delCd;
		this.bdAreaCd = bdAreaCd;
		this.trnsOprId = trnsOprId;
		this.podCd = podCd;
		this.bcdDesc = bcdDesc;
		this.creUsrId = creUsrId;
		this.itemTp = itemTp;
		this.modeTrans = modeTrans;
		this.downCheck = downCheck;
		this.transOper = transOper;
		this.ibdNo = ibdNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ial", getIal());
		this.hashColumns.put("ida_line_no", getIdaLineNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("bl_cust_tp", getBlCustTp());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("entry_tp", getEntryTp());
		this.hashColumns.put("hbl_ind", getHblInd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("hbl_no", getHblNo());
		this.hashColumns.put("cfs_bond_cd", getCfsBondCd());
		this.hashColumns.put("cfs_cd", getCfsCd());
		this.hashColumns.put("dest_cd", getDestCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("customer_name", getCustomerName());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("bd_area_cd", getBdAreaCd());
		this.hashColumns.put("trns_opr_id", getTrnsOprId());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bcd_desc", getBcdDesc());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("item_tp", getItemTp());
		this.hashColumns.put("mode_trans", getModeTrans());
		this.hashColumns.put("down_check", getDownCheck());
		this.hashColumns.put("trans_oper", getTransOper());
		this.hashColumns.put("ibd_no", getIbdNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ial", "ial");
		this.hashFields.put("ida_line_no", "idaLineNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("bl_cust_tp", "blCustTp");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("entry_tp", "entryTp");
		this.hashFields.put("hbl_ind", "hblInd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("hbl_no", "hblNo");
		this.hashFields.put("cfs_bond_cd", "cfsBondCd");
		this.hashFields.put("cfs_cd", "cfsCd");
		this.hashFields.put("dest_cd", "destCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("customer_name", "customerName");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("bd_area_cd", "bdAreaCd");
		this.hashFields.put("trns_opr_id", "trnsOprId");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bcd_desc", "bcdDesc");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("item_tp", "itemTp");
		this.hashFields.put("mode_trans", "modeTrans");
		this.hashFields.put("down_check", "downCheck");
		this.hashFields.put("trans_oper", "transOper");
		this.hashFields.put("ibd_no", "ibdNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ial
	 */
	public String getIal() {
		return this.ial;
	}
	
	/**
	 * Column Info
	 * @return idaLineNo
	 */
	public String getIdaLineNo() {
		return this.idaLineNo;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return blCustTp
	 */
	public String getBlCustTp() {
		return this.blCustTp;
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
	 * @return entryTp
	 */
	public String getEntryTp() {
		return this.entryTp;
	}
	
	/**
	 * Column Info
	 * @return hblInd
	 */
	public String getHblInd() {
		return this.hblInd;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return hblNo
	 */
	public String getHblNo() {
		return this.hblNo;
	}
	
	/**
	 * Column Info
	 * @return cfsBondCd
	 */
	public String getCfsBondCd() {
		return this.cfsBondCd;
	}
	
	/**
	 * Column Info
	 * @return cfsCd
	 */
	public String getCfsCd() {
		return this.cfsCd;
	}
	
	/**
	 * Column Info
	 * @return destCd
	 */
	public String getDestCd() {
		return this.destCd;
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
	 * @return customerName
	 */
	public String getCustomerName() {
		return this.customerName;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return bdAreaCd
	 */
	public String getBdAreaCd() {
		return this.bdAreaCd;
	}
	
	/**
	 * Column Info
	 * @return trnsOprId
	 */
	public String getTrnsOprId() {
		return this.trnsOprId;
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
	 * @return bcdDesc
	 */
	public String getBcdDesc() {
		return this.bcdDesc;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return itemTp
	 */
	public String getItemTp() {
		return this.itemTp;
	}
	
	/**
	 * Column Info
	 * @return modeTrans
	 */
	public String getModeTrans() {
		return this.modeTrans;
	}
	
	/**
	 * Column Info
	 * @return downCheck
	 */
	public String getDownCheck() {
		return this.downCheck;
	}
	
	/**
	 * Column Info
	 * @return transOper
	 */
	public String getTransOper() {
		return this.transOper;
	}
	
	/**
	 * Column Info
	 * @return ibdNo
	 */
	public String getIbdNo() {
		return this.ibdNo;
	}
	

	/**
	 * Column Info
	 * @param ial
	 */
	public void setIal(String ial) {
		this.ial = ial;
	}
	
	/**
	 * Column Info
	 * @param idaLineNo
	 */
	public void setIdaLineNo(String idaLineNo) {
		this.idaLineNo = idaLineNo;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param blCustTp
	 */
	public void setBlCustTp(String blCustTp) {
		this.blCustTp = blCustTp;
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
	 * @param entryTp
	 */
	public void setEntryTp(String entryTp) {
		this.entryTp = entryTp;
	}
	
	/**
	 * Column Info
	 * @param hblInd
	 */
	public void setHblInd(String hblInd) {
		this.hblInd = hblInd;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param hblNo
	 */
	public void setHblNo(String hblNo) {
		this.hblNo = hblNo;
	}
	
	/**
	 * Column Info
	 * @param cfsBondCd
	 */
	public void setCfsBondCd(String cfsBondCd) {
		this.cfsBondCd = cfsBondCd;
	}
	
	/**
	 * Column Info
	 * @param cfsCd
	 */
	public void setCfsCd(String cfsCd) {
		this.cfsCd = cfsCd;
	}
	
	/**
	 * Column Info
	 * @param destCd
	 */
	public void setDestCd(String destCd) {
		this.destCd = destCd;
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
	 * @param customerName
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param bdAreaCd
	 */
	public void setBdAreaCd(String bdAreaCd) {
		this.bdAreaCd = bdAreaCd;
	}
	
	/**
	 * Column Info
	 * @param trnsOprId
	 */
	public void setTrnsOprId(String trnsOprId) {
		this.trnsOprId = trnsOprId;
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
	 * @param bcdDesc
	 */
	public void setBcdDesc(String bcdDesc) {
		this.bcdDesc = bcdDesc;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param itemTp
	 */
	public void setItemTp(String itemTp) {
		this.itemTp = itemTp;
	}
	
	/**
	 * Column Info
	 * @param modeTrans
	 */
	public void setModeTrans(String modeTrans) {
		this.modeTrans = modeTrans;
	}
	
	/**
	 * Column Info
	 * @param downCheck
	 */
	public void setDownCheck(String downCheck) {
		this.downCheck = downCheck;
	}
	
	/**
	 * Column Info
	 * @param transOper
	 */
	public void setTransOper(String transOper) {
		this.transOper = transOper;
	}
	
	/**
	 * Column Info
	 * @param ibdNo
	 */
	public void setIbdNo(String ibdNo) {
		this.ibdNo = ibdNo;
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
		setIal(JSPUtil.getParameter(request, prefix + "ial", ""));
		setIdaLineNo(JSPUtil.getParameter(request, prefix + "ida_line_no", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setBlCustTp(JSPUtil.getParameter(request, prefix + "bl_cust_tp", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEntryTp(JSPUtil.getParameter(request, prefix + "entry_tp", ""));
		setHblInd(JSPUtil.getParameter(request, prefix + "hbl_ind", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setHblNo(JSPUtil.getParameter(request, prefix + "hbl_no", ""));
		setCfsBondCd(JSPUtil.getParameter(request, prefix + "cfs_bond_cd", ""));
		setCfsCd(JSPUtil.getParameter(request, prefix + "cfs_cd", ""));
		setDestCd(JSPUtil.getParameter(request, prefix + "dest_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCustomerName(JSPUtil.getParameter(request, prefix + "customer_name", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setBdAreaCd(JSPUtil.getParameter(request, prefix + "bd_area_cd", ""));
		setTrnsOprId(JSPUtil.getParameter(request, prefix + "trns_opr_id", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBcdDesc(JSPUtil.getParameter(request, prefix + "bcd_desc", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setItemTp(JSPUtil.getParameter(request, prefix + "item_tp", ""));
		setModeTrans(JSPUtil.getParameter(request, prefix + "mode_trans", ""));
		setDownCheck(JSPUtil.getParameter(request, prefix + "down_check", ""));
		setTransOper(JSPUtil.getParameter(request, prefix + "trans_oper", ""));
		setIbdNo(JSPUtil.getParameter(request, prefix + "ibd_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IndiaIgmModiVO[]
	 */
	public IndiaIgmModiVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IndiaIgmModiVO[]
	 */
	public IndiaIgmModiVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		IndiaIgmModiVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ial = (JSPUtil.getParameter(request, prefix	+ "ial", length));
			String[] idaLineNo = (JSPUtil.getParameter(request, prefix	+ "ida_line_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] blCustTp = (JSPUtil.getParameter(request, prefix	+ "bl_cust_tp", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] entryTp = (JSPUtil.getParameter(request, prefix	+ "entry_tp", length));
			String[] hblInd = (JSPUtil.getParameter(request, prefix	+ "hbl_ind", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] hblNo = (JSPUtil.getParameter(request, prefix	+ "hbl_no", length));
			String[] cfsBondCd = (JSPUtil.getParameter(request, prefix	+ "cfs_bond_cd", length));
			String[] cfsCd = (JSPUtil.getParameter(request, prefix	+ "cfs_cd", length));
			String[] destCd = (JSPUtil.getParameter(request, prefix	+ "dest_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] customerName = (JSPUtil.getParameter(request, prefix	+ "customer_name", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] bdAreaCd = (JSPUtil.getParameter(request, prefix	+ "bd_area_cd", length));
			String[] trnsOprId = (JSPUtil.getParameter(request, prefix	+ "trns_opr_id", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bcdDesc = (JSPUtil.getParameter(request, prefix	+ "bcd_desc", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] itemTp = (JSPUtil.getParameter(request, prefix	+ "item_tp", length));
			String[] modeTrans = (JSPUtil.getParameter(request, prefix	+ "mode_trans", length));
			String[] downCheck = (JSPUtil.getParameter(request, prefix	+ "down_check", length));
			String[] transOper = (JSPUtil.getParameter(request, prefix	+ "trans_oper", length));
			String[] ibdNo = (JSPUtil.getParameter(request, prefix	+ "ibd_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new IndiaIgmModiVO();
				if (ial[i] != null)
					model.setIal(ial[i]);
				if (idaLineNo[i] != null)
					model.setIdaLineNo(idaLineNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (blCustTp[i] != null)
					model.setBlCustTp(blCustTp[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (entryTp[i] != null)
					model.setEntryTp(entryTp[i]);
				if (hblInd[i] != null)
					model.setHblInd(hblInd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (hblNo[i] != null)
					model.setHblNo(hblNo[i]);
				if (cfsBondCd[i] != null)
					model.setCfsBondCd(cfsBondCd[i]);
				if (cfsCd[i] != null)
					model.setCfsCd(cfsCd[i]);
				if (destCd[i] != null)
					model.setDestCd(destCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (customerName[i] != null)
					model.setCustomerName(customerName[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (bdAreaCd[i] != null)
					model.setBdAreaCd(bdAreaCd[i]);
				if (trnsOprId[i] != null)
					model.setTrnsOprId(trnsOprId[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bcdDesc[i] != null)
					model.setBcdDesc(bcdDesc[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (itemTp[i] != null)
					model.setItemTp(itemTp[i]);
				if (modeTrans[i] != null)
					model.setModeTrans(modeTrans[i]);
				if (downCheck[i] != null)
					model.setDownCheck(downCheck[i]);
				if (transOper[i] != null)
					model.setTransOper(transOper[i]);
				if (ibdNo[i] != null)
					model.setIbdNo(ibdNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getIndiaIgmModiVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return IndiaIgmModiVO[]
	 */
	public IndiaIgmModiVO[] getIndiaIgmModiVOs(){
		IndiaIgmModiVO[] vos = (IndiaIgmModiVO[])models.toArray(new IndiaIgmModiVO[models.size()]);
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
		this.ial = this.ial .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaLineNo = this.idaLineNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCustTp = this.blCustTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.entryTp = this.entryTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hblInd = this.hblInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hblNo = this.hblNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfsBondCd = this.cfsBondCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfsCd = this.cfsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destCd = this.destCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customerName = this.customerName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdAreaCd = this.bdAreaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsOprId = this.trnsOprId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bcdDesc = this.bcdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itemTp = this.itemTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modeTrans = this.modeTrans .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.downCheck = this.downCheck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transOper = this.transOper .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdNo = this.ibdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

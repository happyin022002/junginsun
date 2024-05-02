/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RailHistoryDetailListVO.java
*@FileTitle : RailHistoryDetailListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.09.02 김도완 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김도완
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RailHistoryDetailListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RailHistoryDetailListVO> models = new ArrayList<RailHistoryDetailListVO>();
	
	/* Column Info */
	private String eta = null;
	/* Column Info */
	private String entryNumber = null;
	/* Column Info */
	private String remark = null;
	/* Column Info */
	private String hub = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String codeDesc = null;
	/* Column Info */
	private String nvoccVvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String railAmsFileNo = null;
	/* Column Info */
	private String wgt = null;
	/* Column Info */
	private String qtyTp = null;
	/* Column Info */
	private String rcvDt = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String del = null;
	/* Column Info */
	private String cDesc = null;
	/* Column Info */
	private String customs = null;
	/* Column Info */
	private String wgtUt = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String f = null;
	/* Column Info */
	private String d = null;
	/* Column Info */
	private String c = null;
	/* Column Info */
	private String o = null;
	/* Column Info */
	private String qty = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String code = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String tmp2 = null;
	/* Column Info */
	private String tmp1 = null;
	/* Column Info */
	private String entryType = null;
	/* Column Info */
	private String tmp3 = null;
	/* Column Info */
	private String r = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String batch = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RailHistoryDetailListVO() {}

	public RailHistoryDetailListVO(String ibflag, String pagerows, String c, String code, String codeDesc, String cntrNo, String railAmsFileNo, String qty, String entryType, String entryNumber, String rcvDt, String customs, String nvoccVvd, String remark, String batch, String cDesc, String f, String o, String vvd, String vslNm, String pol, String pod, String eta, String del, String hub, String r, String d, String blNo, String wgt, String qtyTp, String wgtUt, String tmp1, String tmp2, String tmp3) {
		this.eta = eta;
		this.entryNumber = entryNumber;
		this.remark = remark;
		this.hub = hub;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.codeDesc = codeDesc;
		this.nvoccVvd = nvoccVvd;
		this.ibflag = ibflag;
		this.railAmsFileNo = railAmsFileNo;
		this.wgt = wgt;
		this.qtyTp = qtyTp;
		this.rcvDt = rcvDt;
		this.pol = pol;
		this.del = del;
		this.cDesc = cDesc;
		this.customs = customs;
		this.wgtUt = wgtUt;
		this.pod = pod;
		this.f = f;
		this.d = d;
		this.c = c;
		this.o = o;
		this.qty = qty;
		this.vslNm = vslNm;
		this.code = code;
		this.vvd = vvd;
		this.tmp2 = tmp2;
		this.tmp1 = tmp1;
		this.entryType = entryType;
		this.tmp3 = tmp3;
		this.r = r;
		this.cntrNo = cntrNo;
		this.batch = batch;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eta", getEta());
		this.hashColumns.put("entry_number", getEntryNumber());
		this.hashColumns.put("remark", getRemark());
		this.hashColumns.put("hub", getHub());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("code_desc", getCodeDesc());
		this.hashColumns.put("nvocc_vvd", getNvoccVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rail_ams_file_no", getRailAmsFileNo());
		this.hashColumns.put("wgt", getWgt());
		this.hashColumns.put("qty_tp", getQtyTp());
		this.hashColumns.put("rcv_dt", getRcvDt());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("del", getDel());
		this.hashColumns.put("c_desc", getCDesc());
		this.hashColumns.put("customs", getCustoms());
		this.hashColumns.put("wgt_ut", getWgtUt());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("f", getF());
		this.hashColumns.put("d", getD());
		this.hashColumns.put("c", getC());
		this.hashColumns.put("o", getO());
		this.hashColumns.put("qty", getQty());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("code", getCode());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("tmp2", getTmp2());
		this.hashColumns.put("tmp1", getTmp1());
		this.hashColumns.put("entry_type", getEntryType());
		this.hashColumns.put("tmp3", getTmp3());
		this.hashColumns.put("r", getR());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("batch", getBatch());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eta", "eta");
		this.hashFields.put("entry_number", "entryNumber");
		this.hashFields.put("remark", "remark");
		this.hashFields.put("hub", "hub");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("code_desc", "codeDesc");
		this.hashFields.put("nvocc_vvd", "nvoccVvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rail_ams_file_no", "railAmsFileNo");
		this.hashFields.put("wgt", "wgt");
		this.hashFields.put("qty_tp", "qtyTp");
		this.hashFields.put("rcv_dt", "rcvDt");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("del", "del");
		this.hashFields.put("c_desc", "cDesc");
		this.hashFields.put("customs", "customs");
		this.hashFields.put("wgt_ut", "wgtUt");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("f", "f");
		this.hashFields.put("d", "d");
		this.hashFields.put("c", "c");
		this.hashFields.put("o", "o");
		this.hashFields.put("qty", "qty");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("code", "code");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("tmp2", "tmp2");
		this.hashFields.put("tmp1", "tmp1");
		this.hashFields.put("entry_type", "entryType");
		this.hashFields.put("tmp3", "tmp3");
		this.hashFields.put("r", "r");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("batch", "batch");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return eta
	 */
	public String getEta() {
		return this.eta;
	}
	
	/**
	 * Column Info
	 * @return entryNumber
	 */
	public String getEntryNumber() {
		return this.entryNumber;
	}
	
	/**
	 * Column Info
	 * @return remark
	 */
	public String getRemark() {
		return this.remark;
	}
	
	/**
	 * Column Info
	 * @return hub
	 */
	public String getHub() {
		return this.hub;
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
	 * @return codeDesc
	 */
	public String getCodeDesc() {
		return this.codeDesc;
	}
	
	/**
	 * Column Info
	 * @return nvoccVvd
	 */
	public String getNvoccVvd() {
		return this.nvoccVvd;
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
	 * @return railAmsFileNo
	 */
	public String getRailAmsFileNo() {
		return this.railAmsFileNo;
	}
	
	/**
	 * Column Info
	 * @return wgt
	 */
	public String getWgt() {
		return this.wgt;
	}
	
	/**
	 * Column Info
	 * @return qtyTp
	 */
	public String getQtyTp() {
		return this.qtyTp;
	}
	
	/**
	 * Column Info
	 * @return rcvDt
	 */
	public String getRcvDt() {
		return this.rcvDt;
	}
	
	/**
	 * Column Info
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
	}
	
	/**
	 * Column Info
	 * @return del
	 */
	public String getDel() {
		return this.del;
	}
	
	/**
	 * Column Info
	 * @return cDesc
	 */
	public String getCDesc() {
		return this.cDesc;
	}
	
	/**
	 * Column Info
	 * @return customs
	 */
	public String getCustoms() {
		return this.customs;
	}
	
	/**
	 * Column Info
	 * @return wgtUt
	 */
	public String getWgtUt() {
		return this.wgtUt;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}
	
	/**
	 * Column Info
	 * @return f
	 */
	public String getF() {
		return this.f;
	}
	
	/**
	 * Column Info
	 * @return d
	 */
	public String getD() {
		return this.d;
	}
	
	/**
	 * Column Info
	 * @return c
	 */
	public String getC() {
		return this.c;
	}
	
	/**
	 * Column Info
	 * @return o
	 */
	public String getO() {
		return this.o;
	}
	
	/**
	 * Column Info
	 * @return qty
	 */
	public String getQty() {
		return this.qty;
	}
	
	/**
	 * Column Info
	 * @return vslNm
	 */
	public String getVslNm() {
		return this.vslNm;
	}
	
	/**
	 * Column Info
	 * @return code
	 */
	public String getCode() {
		return this.code;
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
	 * @return tmp2
	 */
	public String getTmp2() {
		return this.tmp2;
	}
	
	/**
	 * Column Info
	 * @return tmp1
	 */
	public String getTmp1() {
		return this.tmp1;
	}
	
	/**
	 * Column Info
	 * @return entryType
	 */
	public String getEntryType() {
		return this.entryType;
	}
	
	/**
	 * Column Info
	 * @return tmp3
	 */
	public String getTmp3() {
		return this.tmp3;
	}
	
	/**
	 * Column Info
	 * @return r
	 */
	public String getR() {
		return this.r;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return batch
	 */
	public String getBatch() {
		return this.batch;
	}
	

	/**
	 * Column Info
	 * @param eta
	 */
	public void setEta(String eta) {
		this.eta = eta;
	}
	
	/**
	 * Column Info
	 * @param entryNumber
	 */
	public void setEntryNumber(String entryNumber) {
		this.entryNumber = entryNumber;
	}
	
	/**
	 * Column Info
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * Column Info
	 * @param hub
	 */
	public void setHub(String hub) {
		this.hub = hub;
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
	 * @param codeDesc
	 */
	public void setCodeDesc(String codeDesc) {
		this.codeDesc = codeDesc;
	}
	
	/**
	 * Column Info
	 * @param nvoccVvd
	 */
	public void setNvoccVvd(String nvoccVvd) {
		this.nvoccVvd = nvoccVvd;
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
	 * @param railAmsFileNo
	 */
	public void setRailAmsFileNo(String railAmsFileNo) {
		this.railAmsFileNo = railAmsFileNo;
	}
	
	/**
	 * Column Info
	 * @param wgt
	 */
	public void setWgt(String wgt) {
		this.wgt = wgt;
	}
	
	/**
	 * Column Info
	 * @param qtyTp
	 */
	public void setQtyTp(String qtyTp) {
		this.qtyTp = qtyTp;
	}
	
	/**
	 * Column Info
	 * @param rcvDt
	 */
	public void setRcvDt(String rcvDt) {
		this.rcvDt = rcvDt;
	}
	
	/**
	 * Column Info
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	/**
	 * Column Info
	 * @param del
	 */
	public void setDel(String del) {
		this.del = del;
	}
	
	/**
	 * Column Info
	 * @param cDesc
	 */
	public void setCDesc(String cDesc) {
		this.cDesc = cDesc;
	}
	
	/**
	 * Column Info
	 * @param customs
	 */
	public void setCustoms(String customs) {
		this.customs = customs;
	}
	
	/**
	 * Column Info
	 * @param wgtUt
	 */
	public void setWgtUt(String wgtUt) {
		this.wgtUt = wgtUt;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}
	
	/**
	 * Column Info
	 * @param f
	 */
	public void setF(String f) {
		this.f = f;
	}
	
	/**
	 * Column Info
	 * @param d
	 */
	public void setD(String d) {
		this.d = d;
	}
	
	/**
	 * Column Info
	 * @param c
	 */
	public void setC(String c) {
		this.c = c;
	}
	
	/**
	 * Column Info
	 * @param o
	 */
	public void setO(String o) {
		this.o = o;
	}
	
	/**
	 * Column Info
	 * @param qty
	 */
	public void setQty(String qty) {
		this.qty = qty;
	}
	
	/**
	 * Column Info
	 * @param vslNm
	 */
	public void setVslNm(String vslNm) {
		this.vslNm = vslNm;
	}
	
	/**
	 * Column Info
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
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
	 * @param tmp2
	 */
	public void setTmp2(String tmp2) {
		this.tmp2 = tmp2;
	}
	
	/**
	 * Column Info
	 * @param tmp1
	 */
	public void setTmp1(String tmp1) {
		this.tmp1 = tmp1;
	}
	
	/**
	 * Column Info
	 * @param entryType
	 */
	public void setEntryType(String entryType) {
		this.entryType = entryType;
	}
	
	/**
	 * Column Info
	 * @param tmp3
	 */
	public void setTmp3(String tmp3) {
		this.tmp3 = tmp3;
	}
	
	/**
	 * Column Info
	 * @param r
	 */
	public void setR(String r) {
		this.r = r;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param batch
	 */
	public void setBatch(String batch) {
		this.batch = batch;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setEta(JSPUtil.getParameter(request, "eta", ""));
		setEntryNumber(JSPUtil.getParameter(request, "entry_number", ""));
		setRemark(JSPUtil.getParameter(request, "remark", ""));
		setHub(JSPUtil.getParameter(request, "hub", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCodeDesc(JSPUtil.getParameter(request, "code_desc", ""));
		setNvoccVvd(JSPUtil.getParameter(request, "nvocc_vvd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRailAmsFileNo(JSPUtil.getParameter(request, "rail_ams_file_no", ""));
		setWgt(JSPUtil.getParameter(request, "wgt", ""));
		setQtyTp(JSPUtil.getParameter(request, "qty_tp", ""));
		setRcvDt(JSPUtil.getParameter(request, "rcv_dt", ""));
		setPol(JSPUtil.getParameter(request, "pol", ""));
		setDel(JSPUtil.getParameter(request, "del", ""));
		setCDesc(JSPUtil.getParameter(request, "c_desc", ""));
		setCustoms(JSPUtil.getParameter(request, "customs", ""));
		setWgtUt(JSPUtil.getParameter(request, "wgt_ut", ""));
		setPod(JSPUtil.getParameter(request, "pod", ""));
		setF(JSPUtil.getParameter(request, "f", ""));
		setD(JSPUtil.getParameter(request, "d", ""));
		setC(JSPUtil.getParameter(request, "c", ""));
		setO(JSPUtil.getParameter(request, "o", ""));
		setQty(JSPUtil.getParameter(request, "qty", ""));
		setVslNm(JSPUtil.getParameter(request, "vsl_nm", ""));
		setCode(JSPUtil.getParameter(request, "code", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setTmp2(JSPUtil.getParameter(request, "tmp2", ""));
		setTmp1(JSPUtil.getParameter(request, "tmp1", ""));
		setEntryType(JSPUtil.getParameter(request, "entry_type", ""));
		setTmp3(JSPUtil.getParameter(request, "tmp3", ""));
		setR(JSPUtil.getParameter(request, "r", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setBatch(JSPUtil.getParameter(request, "batch", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RailHistoryDetailListVO[]
	 */
	public RailHistoryDetailListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RailHistoryDetailListVO[]
	 */
	public RailHistoryDetailListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RailHistoryDetailListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] eta = (JSPUtil.getParameter(request, prefix	+ "eta", length));
			String[] entryNumber = (JSPUtil.getParameter(request, prefix	+ "entry_number", length));
			String[] remark = (JSPUtil.getParameter(request, prefix	+ "remark", length));
			String[] hub = (JSPUtil.getParameter(request, prefix	+ "hub", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] codeDesc = (JSPUtil.getParameter(request, prefix	+ "code_desc", length));
			String[] nvoccVvd = (JSPUtil.getParameter(request, prefix	+ "nvocc_vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] railAmsFileNo = (JSPUtil.getParameter(request, prefix	+ "rail_ams_file_no", length));
			String[] wgt = (JSPUtil.getParameter(request, prefix	+ "wgt", length));
			String[] qtyTp = (JSPUtil.getParameter(request, prefix	+ "qty_tp", length));
			String[] rcvDt = (JSPUtil.getParameter(request, prefix	+ "rcv_dt", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] del = (JSPUtil.getParameter(request, prefix	+ "del", length));
			String[] cDesc = (JSPUtil.getParameter(request, prefix	+ "c_desc", length));
			String[] customs = (JSPUtil.getParameter(request, prefix	+ "customs", length));
			String[] wgtUt = (JSPUtil.getParameter(request, prefix	+ "wgt_ut", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] f = (JSPUtil.getParameter(request, prefix	+ "f", length));
			String[] d = (JSPUtil.getParameter(request, prefix	+ "d", length));
			String[] c = (JSPUtil.getParameter(request, prefix	+ "c", length));
			String[] o = (JSPUtil.getParameter(request, prefix	+ "o", length));
			String[] qty = (JSPUtil.getParameter(request, prefix	+ "qty", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] code = (JSPUtil.getParameter(request, prefix	+ "code", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] tmp2 = (JSPUtil.getParameter(request, prefix	+ "tmp2", length));
			String[] tmp1 = (JSPUtil.getParameter(request, prefix	+ "tmp1", length));
			String[] entryType = (JSPUtil.getParameter(request, prefix	+ "entry_type", length));
			String[] tmp3 = (JSPUtil.getParameter(request, prefix	+ "tmp3", length));
			String[] r = (JSPUtil.getParameter(request, prefix	+ "r", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] batch = (JSPUtil.getParameter(request, prefix	+ "batch", length));
			
			for (int i = 0; i < length; i++) {
				model = new RailHistoryDetailListVO();
				if (eta[i] != null)
					model.setEta(eta[i]);
				if (entryNumber[i] != null)
					model.setEntryNumber(entryNumber[i]);
				if (remark[i] != null)
					model.setRemark(remark[i]);
				if (hub[i] != null)
					model.setHub(hub[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (codeDesc[i] != null)
					model.setCodeDesc(codeDesc[i]);
				if (nvoccVvd[i] != null)
					model.setNvoccVvd(nvoccVvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (railAmsFileNo[i] != null)
					model.setRailAmsFileNo(railAmsFileNo[i]);
				if (wgt[i] != null)
					model.setWgt(wgt[i]);
				if (qtyTp[i] != null)
					model.setQtyTp(qtyTp[i]);
				if (rcvDt[i] != null)
					model.setRcvDt(rcvDt[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (del[i] != null)
					model.setDel(del[i]);
				if (cDesc[i] != null)
					model.setCDesc(cDesc[i]);
				if (customs[i] != null)
					model.setCustoms(customs[i]);
				if (wgtUt[i] != null)
					model.setWgtUt(wgtUt[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (f[i] != null)
					model.setF(f[i]);
				if (d[i] != null)
					model.setD(d[i]);
				if (c[i] != null)
					model.setC(c[i]);
				if (o[i] != null)
					model.setO(o[i]);
				if (qty[i] != null)
					model.setQty(qty[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (code[i] != null)
					model.setCode(code[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (tmp2[i] != null)
					model.setTmp2(tmp2[i]);
				if (tmp1[i] != null)
					model.setTmp1(tmp1[i]);
				if (entryType[i] != null)
					model.setEntryType(entryType[i]);
				if (tmp3[i] != null)
					model.setTmp3(tmp3[i]);
				if (r[i] != null)
					model.setR(r[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (batch[i] != null)
					model.setBatch(batch[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRailHistoryDetailListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RailHistoryDetailListVO[]
	 */
	public RailHistoryDetailListVO[] getRailHistoryDetailListVOs(){
		RailHistoryDetailListVO[] vos = (RailHistoryDetailListVO[])models.toArray(new RailHistoryDetailListVO[models.size()]);
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
		this.eta = this.eta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.entryNumber = this.entryNumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark = this.remark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hub = this.hub .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codeDesc = this.codeDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nvoccVvd = this.nvoccVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railAmsFileNo = this.railAmsFileNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgt = this.wgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtyTp = this.qtyTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDt = this.rcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.del = this.del .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cDesc = this.cDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customs = this.customs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUt = this.wgtUt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f = this.f .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d = this.d .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.c = this.c .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o = this.o .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty = this.qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.code = this.code .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmp2 = this.tmp2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmp1 = this.tmp1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.entryType = this.entryType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmp3 = this.tmp3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r = this.r .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batch = this.batch .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

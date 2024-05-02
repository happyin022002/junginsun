/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : ManilaSearchGenVO.java
*@FileTitle : ManilaSearchGenVO
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.24
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
public class ManilaSearchGenVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ManilaSearchGenVO> models = new ArrayList<ManilaSearchGenVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	
	/* Page Number */
	private String pagerows = null;

	/* Column Info */
	private String seq = null;

	/* Column Info */
	private String ofcCd = null;

	/* Column Info */
	private String regNo = null;

	/* Column Info */
	private String etaDt = null;

	/* Column Info */
	private String etaTm = null;

	/* Column Info */
	private String porCd = null;

	/* Column Info */
	private String delCd = null;

	/* Column Info */
	private String crrCd = null;

	/* Column Info */
	private String crrNm = null;

	/* Column Info */
	private String crrAddr1 = null;

	/* Column Info */
	private String crrAddr2 = null;

	/* Column Info */
	private String crrAddr3 = null;

	/* Column Info */
	private String crrAddr4 = null;

	/* Column Info */
	private String trspMod = null;

	/* Column Info */
	private String trspId = null;

	/* Column Info */
	private String trspNtlt = null;

	/* Column Info */
	private String plzReg = null;

	/* Column Info */
	private String trspRegNo = null;

	/* Column Info */
	private String trspRegDt = null;

	/* Column Info */
	private String vvd = null;

	/* Column Info */
	private String por = null;

	/* Column Info */
	private String mstInfo2 = null;

	/* Column Info */
	private String netTon = null;

	/* Column Info */
	private String grsTon = null;

	/* Column Info */
	private String totBl = null;

	/* Column Info */
	private String totCntr = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ManilaSearchGenVO() {}

	public ManilaSearchGenVO(String ibflag, String pagerows, String seq, String ofcCd, String regNo, String etaDt, String etaTm, String porCd, String delCd, String crrCd, String crrNm, String crrAddr1, String crrAddr2, String crrAddr3, String crrAddr4, String trspMod, String trspId, String trspNtlt, String plzReg, String trspRegNo, String trspRegDt, String vvd, String por, String mstInfo2, String netTon, String grsTon, String totBl, String totCntr) {
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.seq = seq;
		this.ofcCd = ofcCd;
		this.regNo = regNo;
		this.etaDt = etaDt;
		this.etaTm = etaTm;
		this.porCd = porCd;
		this.delCd = delCd;
		this.crrCd = crrCd;
		this.crrNm = crrNm;
		this.crrAddr1 = crrAddr1;
		this.crrAddr2 = crrAddr2;
		this.crrAddr3 = crrAddr3;
		this.crrAddr4 = crrAddr4;
		this.trspMod = trspMod;
		this.trspId = trspId;
		this.trspNtlt = trspNtlt;
		this.plzReg = plzReg;
		this.trspRegNo = trspRegNo;
		this.trspRegDt = trspRegDt;
		this.vvd = vvd;
		this.por = por;
		this.mstInfo2 = mstInfo2;
		this.netTon = netTon;
		this.grsTon = grsTon;
		this.totBl = totBl;
		this.totCntr = totCntr;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("reg_no", getRegNo());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("eta_tm", getEtaTm());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("crr_nm", getCrrNm());
		this.hashColumns.put("crr_addr1", getCrrAddr1());
		this.hashColumns.put("crr_addr2", getCrrAddr2());
		this.hashColumns.put("crr_addr3", getCrrAddr3());
		this.hashColumns.put("crr_addr4", getCrrAddr4());
		this.hashColumns.put("trsp_mod", getTrspMod());
		this.hashColumns.put("trsp_id", getTrspId());
		this.hashColumns.put("trsp_ntlt", getTrspNtlt());
		this.hashColumns.put("plz_reg", getPlzReg());
		this.hashColumns.put("trsp_reg_no", getTrspRegNo());
		this.hashColumns.put("trsp_reg_dt", getTrspRegDt());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("por", getPor());
		this.hashColumns.put("mst_info2", getMstInfo2());
		this.hashColumns.put("net_ton", getNetTon());
		this.hashColumns.put("grs_ton", getGrsTon());
		this.hashColumns.put("tot_bl", getTotBl());
		this.hashColumns.put("tot_cntr", getTotCntr());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("reg_no", "regNo");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("eta_tm", "etaTm");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("crr_nm", "crrNm");
		this.hashFields.put("crr_addr1", "crrAddr1");
		this.hashFields.put("crr_addr2", "crrAddr2");
		this.hashFields.put("crr_addr3", "crrAddr3");
		this.hashFields.put("crr_addr4", "crrAddr4");
		this.hashFields.put("trsp_mod", "trspMod");
		this.hashFields.put("trsp_id", "trspId");
		this.hashFields.put("trsp_ntlt", "trspNtlt");
		this.hashFields.put("plz_reg", "plzReg");
		this.hashFields.put("trsp_reg_no", "trspRegNo");
		this.hashFields.put("trsp_reg_dt", "trspRegDt");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("por", "por");
		this.hashFields.put("mst_info2", "mstInfo2");
		this.hashFields.put("net_ton", "netTon");
		this.hashFields.put("grs_ton", "grsTon");
		this.hashFields.put("tot_bl", "totBl");
		this.hashFields.put("tot_cntr", "totCntr");
		return this.hashFields;
	}
	
	/**
	 *
	 * @param String ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * 
	 * @return String ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 *
	 * @param String pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * 
	 * @return String pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 *
	 * @param String seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * 
	 * @return String seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 *
	 * @param String ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * 
	 * @return String ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 *
	 * @param String regNo
	 */
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	
	/**
	 * 
	 * @return String regNo
	 */
	public String getRegNo() {
		return this.regNo;
	}
	
	/**
	 *
	 * @param String etaDt
	 */
	public void setEtaDt(String etaDt) {
		this.etaDt = etaDt;
	}
	
	/**
	 * 
	 * @return String etaDt
	 */
	public String getEtaDt() {
		return this.etaDt;
	}
	
	/**
	 *
	 * @param String etaTm
	 */
	public void setEtaTm(String etaTm) {
		this.etaTm = etaTm;
	}
	
	/**
	 * 
	 * @return String etaTm
	 */
	public String getEtaTm() {
		return this.etaTm;
	}
	
	/**
	 *
	 * @param String porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * 
	 * @return String porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 *
	 * @param String delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * 
	 * @return String delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 *
	 * @param String crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
	}
	
	/**
	 * 
	 * @return String crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
	}
	
	/**
	 *
	 * @param String crrNm
	 */
	public void setCrrNm(String crrNm) {
		this.crrNm = crrNm;
	}
	
	/**
	 * 
	 * @return String crrNm
	 */
	public String getCrrNm() {
		return this.crrNm;
	}
	
	/**
	 *
	 * @param String crrAddr1
	 */
	public void setCrrAddr1(String crrAddr1) {
		this.crrAddr1 = crrAddr1;
	}
	
	/**
	 * 
	 * @return String crrAddr1
	 */
	public String getCrrAddr1() {
		return this.crrAddr1;
	}
	
	/**
	 *
	 * @param String crrAddr2
	 */
	public void setCrrAddr2(String crrAddr2) {
		this.crrAddr2 = crrAddr2;
	}
	
	/**
	 * 
	 * @return String crrAddr2
	 */
	public String getCrrAddr2() {
		return this.crrAddr2;
	}
	
	/**
	 *
	 * @param String crrAddr3
	 */
	public void setCrrAddr3(String crrAddr3) {
		this.crrAddr3 = crrAddr3;
	}
	
	/**
	 * 
	 * @return String crrAddr3
	 */
	public String getCrrAddr3() {
		return this.crrAddr3;
	}
	
	/**
	 *
	 * @param String crrAddr4
	 */
	public void setCrrAddr4(String crrAddr4) {
		this.crrAddr4 = crrAddr4;
	}
	
	/**
	 * 
	 * @return String crrAddr4
	 */
	public String getCrrAddr4() {
		return this.crrAddr4;
	}
	
	/**
	 *
	 * @param String trspMod
	 */
	public void setTrspMod(String trspMod) {
		this.trspMod = trspMod;
	}
	
	/**
	 * 
	 * @return String trspMod
	 */
	public String getTrspMod() {
		return this.trspMod;
	}
	
	/**
	 *
	 * @param String trspId
	 */
	public void setTrspId(String trspId) {
		this.trspId = trspId;
	}
	
	/**
	 * 
	 * @return String trspId
	 */
	public String getTrspId() {
		return this.trspId;
	}
	
	/**
	 *
	 * @param String trspNtlt
	 */
	public void setTrspNtlt(String trspNtlt) {
		this.trspNtlt = trspNtlt;
	}
	
	/**
	 * 
	 * @return String trspNtlt
	 */
	public String getTrspNtlt() {
		return this.trspNtlt;
	}
	
	/**
	 *
	 * @param String plzReg
	 */
	public void setPlzReg(String plzReg) {
		this.plzReg = plzReg;
	}
	
	/**
	 * 
	 * @return String plzReg
	 */
	public String getPlzReg() {
		return this.plzReg;
	}
	
	/**
	 *
	 * @param String trspRegNo
	 */
	public void setTrspRegNo(String trspRegNo) {
		this.trspRegNo = trspRegNo;
	}
	
	/**
	 * 
	 * @return String trspRegNo
	 */
	public String getTrspRegNo() {
		return this.trspRegNo;
	}
	
	/**
	 *
	 * @param String trspRegDt
	 */
	public void setTrspRegDt(String trspRegDt) {
		this.trspRegDt = trspRegDt;
	}
	
	/**
	 * 
	 * @return String trspRegDt
	 */
	public String getTrspRegDt() {
		return this.trspRegDt;
	}
	
	/**
	 *
	 * @param String vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * 
	 * @return String vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 *
	 * @param String por
	 */
	public void setPor(String por) {
		this.por = por;
	}
	
	/**
	 * 
	 * @return String por
	 */
	public String getPor() {
		return this.por;
	}
	
	/**
	 *
	 * @param String mstInfo2
	 */
	public void setMstInfo2(String mstInfo2) {
		this.mstInfo2 = mstInfo2;
	}
	
	/**
	 * 
	 * @return String mstInfo2
	 */
	public String getMstInfo2() {
		return this.mstInfo2;
	}
	
	/**
	 *
	 * @param String netTon
	 */
	public void setNetTon(String netTon) {
		this.netTon = netTon;
	}
	
	/**
	 * 
	 * @return String netTon
	 */
	public String getNetTon() {
		return this.netTon;
	}
	
	/**
	 *
	 * @param String grsTon
	 */
	public void setGrsTon(String grsTon) {
		this.grsTon = grsTon;
	}
	
	/**
	 * 
	 * @return String grsTon
	 */
	public String getGrsTon() {
		return this.grsTon;
	}
	
	/**
	 *
	 * @param String totBl
	 */
	public void setTotBl(String totBl) {
		this.totBl = totBl;
	}
	
	/**
	 * 
	 * @return String totBl
	 */
	public String getTotBl() {
		return this.totBl;
	}
	
	/**
	 *
	 * @param String totCntr
	 */
	public void setTotCntr(String totCntr) {
		this.totCntr = totCntr;
	}
	
	/**
	 * 
	 * @return String totCntr
	 */
	public String getTotCntr() {
		return this.totCntr;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setRegNo(JSPUtil.getParameter(request, prefix + "reg_no", ""));
		setEtaDt(JSPUtil.getParameter(request, prefix + "eta_dt", ""));
		setEtaTm(JSPUtil.getParameter(request, prefix + "eta_tm", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
		setCrrNm(JSPUtil.getParameter(request, prefix + "crr_nm", ""));
		setCrrAddr1(JSPUtil.getParameter(request, prefix + "crr_addr1", ""));
		setCrrAddr2(JSPUtil.getParameter(request, prefix + "crr_addr2", ""));
		setCrrAddr3(JSPUtil.getParameter(request, prefix + "crr_addr3", ""));
		setCrrAddr4(JSPUtil.getParameter(request, prefix + "crr_addr4", ""));
		setTrspMod(JSPUtil.getParameter(request, prefix + "trsp_mod", ""));
		setTrspId(JSPUtil.getParameter(request, prefix + "trsp_id", ""));
		setTrspNtlt(JSPUtil.getParameter(request, prefix + "trsp_ntlt", ""));
		setPlzReg(JSPUtil.getParameter(request, prefix + "plz_reg", ""));
		setTrspRegNo(JSPUtil.getParameter(request, prefix + "trsp_reg_no", ""));
		setTrspRegDt(JSPUtil.getParameter(request, prefix + "trsp_reg_dt", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPor(JSPUtil.getParameter(request, prefix + "por", ""));
		setMstInfo2(JSPUtil.getParameter(request, prefix + "mst_info2", ""));
		setNetTon(JSPUtil.getParameter(request, prefix + "net_ton", ""));
		setGrsTon(JSPUtil.getParameter(request, prefix + "grs_ton", ""));
		setTotBl(JSPUtil.getParameter(request, prefix + "tot_bl", ""));
		setTotCntr(JSPUtil.getParameter(request, prefix + "tot_cntr", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ManilaSearchGenVO[]
	 */
	public ManilaSearchGenVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ManilaSearchGenVO[]
	 */
	public ManilaSearchGenVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ManilaSearchGenVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] regNo = (JSPUtil.getParameter(request, prefix	+ "reg_no", length));
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] etaTm = (JSPUtil.getParameter(request, prefix	+ "eta_tm", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] crrNm = (JSPUtil.getParameter(request, prefix	+ "crr_nm", length));
			String[] crrAddr1 = (JSPUtil.getParameter(request, prefix	+ "crr_addr1", length));
			String[] crrAddr2 = (JSPUtil.getParameter(request, prefix	+ "crr_addr2", length));
			String[] crrAddr3 = (JSPUtil.getParameter(request, prefix	+ "crr_addr3", length));
			String[] crrAddr4 = (JSPUtil.getParameter(request, prefix	+ "crr_addr4", length));
			String[] trspMod = (JSPUtil.getParameter(request, prefix	+ "trsp_mod", length));
			String[] trspId = (JSPUtil.getParameter(request, prefix	+ "trsp_id", length));
			String[] trspNtlt = (JSPUtil.getParameter(request, prefix	+ "trsp_ntlt", length));
			String[] plzReg = (JSPUtil.getParameter(request, prefix	+ "plz_reg", length));
			String[] trspRegNo = (JSPUtil.getParameter(request, prefix	+ "trsp_reg_no", length));
			String[] trspRegDt = (JSPUtil.getParameter(request, prefix	+ "trsp_reg_dt", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] por = (JSPUtil.getParameter(request, prefix	+ "por", length));
			String[] mstInfo2 = (JSPUtil.getParameter(request, prefix	+ "mst_info2", length));
			String[] netTon = (JSPUtil.getParameter(request, prefix	+ "net_ton", length));
			String[] grsTon = (JSPUtil.getParameter(request, prefix	+ "grs_ton", length));
			String[] totBl = (JSPUtil.getParameter(request, prefix	+ "tot_bl", length));
			String[] totCntr = (JSPUtil.getParameter(request, prefix	+ "tot_cntr", length));
			/* Add a field line, do not delete */
			
			for (int i = 0; i < length; i++) {
				model = new ManilaSearchGenVO();
				if (ibflag[i] != null) 
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null) 
					model.setPagerows(pagerows[i]);
				if (seq[i] != null) 
					model.setSeq(seq[i]);
				if (ofcCd[i] != null) 
					model.setOfcCd(ofcCd[i]);
				if (regNo[i] != null) 
					model.setRegNo(regNo[i]);
				if (etaDt[i] != null) 
					model.setEtaDt(etaDt[i]);
				if (etaTm[i] != null) 
					model.setEtaTm(etaTm[i]);
				if (porCd[i] != null) 
					model.setPorCd(porCd[i]);
				if (delCd[i] != null) 
					model.setDelCd(delCd[i]);
				if (crrCd[i] != null) 
					model.setCrrCd(crrCd[i]);
				if (crrNm[i] != null) 
					model.setCrrNm(crrNm[i]);
				if (crrAddr1[i] != null) 
					model.setCrrAddr1(crrAddr1[i]);
				if (crrAddr2[i] != null) 
					model.setCrrAddr2(crrAddr2[i]);
				if (crrAddr3[i] != null) 
					model.setCrrAddr3(crrAddr3[i]);
				if (crrAddr4[i] != null) 
					model.setCrrAddr4(crrAddr4[i]);
				if (trspMod[i] != null) 
					model.setTrspMod(trspMod[i]);
				if (trspId[i] != null) 
					model.setTrspId(trspId[i]);
				if (trspNtlt[i] != null) 
					model.setTrspNtlt(trspNtlt[i]);
				if (plzReg[i] != null) 
					model.setPlzReg(plzReg[i]);
				if (trspRegNo[i] != null) 
					model.setTrspRegNo(trspRegNo[i]);
				if (trspRegDt[i] != null) 
					model.setTrspRegDt(trspRegDt[i]);
				if (vvd[i] != null) 
					model.setVvd(vvd[i]);
				if (por[i] != null) 
					model.setPor(por[i]);
				if (mstInfo2[i] != null) 
					model.setMstInfo2(mstInfo2[i]);
				if (netTon[i] != null) 
					model.setNetTon(netTon[i]);
				if (grsTon[i] != null) 
					model.setGrsTon(grsTon[i]);
				if (totBl[i] != null) 
					model.setTotBl(totBl[i]);
				if (totCntr[i] != null) 
					model.setTotCntr(totCntr[i]);
				/* Add a Method line, do not delete */
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getManilaSearchGenVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ManilaSearchGenVO[]
	 */
	public ManilaSearchGenVO[] getManilaSearchGenVOs(){
		ManilaSearchGenVO[] vos = (ManilaSearchGenVO[])models.toArray(new ManilaSearchGenVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.regNo = this.regNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaTm = this.etaTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrNm = this.crrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrAddr1 = this.crrAddr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrAddr2 = this.crrAddr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrAddr3 = this.crrAddr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrAddr4 = this.crrAddr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspMod = this.trspMod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspId = this.trspId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspNtlt = this.trspNtlt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plzReg = this.plzReg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspRegNo = this.trspRegNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspRegDt = this.trspRegDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.por = this.por .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstInfo2 = this.mstInfo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netTon = this.netTon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsTon = this.grsTon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totBl = this.totBl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totCntr = this.totCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
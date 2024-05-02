/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PsaBkgCntrFlatVO.java
*@FileTitle : PsaBkgCntrFlatVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.09
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.02.09 박상훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo;

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
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PsaBkgCntrFlatVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PsaBkgCntrFlatVO> models = new ArrayList<PsaBkgCntrFlatVO>();
	
	/* Column Info */
	private String cntrNo2 = null;
	/* Column Info */
	private String cntrNo3 = null;
	/* Column Info */
	private String cntrNo4 = null;
	/* Column Info */
	private String tpszNo = null;
	/* Column Info */
	private String cntrFi = null;
	/* Column Info */
	private String cntrNo5 = null;
	/* Column Info */
	private String cntrNo6 = null;
	/* Column Info */
	private String noCntr = null;
	/* Column Info */
	private String owInd = null;
	/* Column Info */
	private String cntrSz = null;
	/* Column Info */
	private String bkgSeq = null;
	/* Column Info */
	private String cntrNo1 = null;
	/* Column Info */
	private String spDtl = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cntrHeight = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrSt = null;
	/* Column Info */
	private String dgInd = null;
	/* Column Info */
	private String ohInd = null;
	/* Column Info */
	private String rfInd = null;
	/* Column Info */
	private String rfTemp = null;
	/* Column Info */
	private String olInd = null;
	/* Column Info */
	private String seqCntr = null;
	/* Column Info */
	private String humidNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PsaBkgCntrFlatVO() {}

	public PsaBkgCntrFlatVO(String ibflag, String pagerows, String tpszNo, String cntrFi, String seqCntr, String cntrSz, String cntrSt, String dgInd, String rfInd, String ohInd, String owInd, String olInd, String noCntr, String rfTemp, String spDtl, String cntrNo1, String cntrNo2, String cntrNo3, String cntrNo4, String cntrNo5, String cntrNo6, String cntrHeight, String bkgNo, String bkgSeq, String humidNo) {
		this.cntrNo2 = cntrNo2;
		this.cntrNo3 = cntrNo3;
		this.cntrNo4 = cntrNo4;
		this.tpszNo = tpszNo;
		this.cntrFi = cntrFi;
		this.cntrNo5 = cntrNo5;
		this.cntrNo6 = cntrNo6;
		this.noCntr = noCntr;
		this.owInd = owInd;
		this.cntrSz = cntrSz;
		this.bkgSeq = bkgSeq;
		this.cntrNo1 = cntrNo1;
		this.spDtl = spDtl;
		this.pagerows = pagerows;
		this.cntrHeight = cntrHeight;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.cntrSt = cntrSt;
		this.dgInd = dgInd;
		this.ohInd = ohInd;
		this.rfInd = rfInd;
		this.rfTemp = rfTemp;
		this.olInd = olInd;
		this.seqCntr = seqCntr;
		this.humidNo = humidNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_no2", getCntrNo2());
		this.hashColumns.put("cntr_no3", getCntrNo3());
		this.hashColumns.put("cntr_no4", getCntrNo4());
		this.hashColumns.put("tpsz_no", getTpszNo());
		this.hashColumns.put("cntr_fi", getCntrFi());
		this.hashColumns.put("cntr_no5", getCntrNo5());
		this.hashColumns.put("cntr_no6", getCntrNo6());
		this.hashColumns.put("no_cntr", getNoCntr());
		this.hashColumns.put("ow_ind", getOwInd());
		this.hashColumns.put("cntr_sz", getCntrSz());
		this.hashColumns.put("bkg_seq", getBkgSeq());
		this.hashColumns.put("cntr_no1", getCntrNo1());
		this.hashColumns.put("sp_dtl", getSpDtl());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cntr_height", getCntrHeight());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_st", getCntrSt());
		this.hashColumns.put("dg_ind", getDgInd());
		this.hashColumns.put("oh_ind", getOhInd());
		this.hashColumns.put("rf_ind", getRfInd());
		this.hashColumns.put("rf_temp", getRfTemp());
		this.hashColumns.put("ol_ind", getOlInd());
		this.hashColumns.put("seq_cntr", getSeqCntr());
		this.hashColumns.put("humid_no", getHumidNo());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_no2", "cntrNo2");
		this.hashFields.put("cntr_no3", "cntrNo3");
		this.hashFields.put("cntr_no4", "cntrNo4");
		this.hashFields.put("tpsz_no", "tpszNo");
		this.hashFields.put("cntr_fi", "cntrFi");
		this.hashFields.put("cntr_no5", "cntrNo5");
		this.hashFields.put("cntr_no6", "cntrNo6");
		this.hashFields.put("no_cntr", "noCntr");
		this.hashFields.put("ow_ind", "owInd");
		this.hashFields.put("cntr_sz", "cntrSz");
		this.hashFields.put("bkg_seq", "bkgSeq");
		this.hashFields.put("cntr_no1", "cntrNo1");
		this.hashFields.put("sp_dtl", "spDtl");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cntr_height", "cntrHeight");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_st", "cntrSt");
		this.hashFields.put("dg_ind", "dgInd");
		this.hashFields.put("oh_ind", "ohInd");
		this.hashFields.put("rf_ind", "rfInd");
		this.hashFields.put("rf_temp", "rfTemp");
		this.hashFields.put("ol_ind", "olInd");
		this.hashFields.put("seq_cntr", "seqCntr");
		this.hashFields.put("humid_no", "humidNo");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntrNo2
	 */
	public String getCntrNo2() {
		return this.cntrNo2;
	}
	
	/**
	 * Column Info
	 * @return cntrNo3
	 */
	public String getCntrNo3() {
		return this.cntrNo3;
	}
	
	/**
	 * Column Info
	 * @return cntrNo4
	 */
	public String getCntrNo4() {
		return this.cntrNo4;
	}
	
	/**
	 * Column Info
	 * @return tpszNo
	 */
	public String getTpszNo() {
		return this.tpszNo;
	}
	
	/**
	 * Column Info
	 * @return cntrFi
	 */
	public String getCntrFi() {
		return this.cntrFi;
	}
	
	/**
	 * Column Info
	 * @return cntrNo5
	 */
	public String getCntrNo5() {
		return this.cntrNo5;
	}
	
	/**
	 * Column Info
	 * @return cntrNo6
	 */
	public String getCntrNo6() {
		return this.cntrNo6;
	}
	
	/**
	 * Column Info
	 * @return noCntr
	 */
	public String getNoCntr() {
		return this.noCntr;
	}
	
	/**
	 * Column Info
	 * @return owInd
	 */
	public String getOwInd() {
		return this.owInd;
	}
	
	/**
	 * Column Info
	 * @return cntrSz
	 */
	public String getCntrSz() {
		return this.cntrSz;
	}
	
	/**
	 * Column Info
	 * @return bkgSeq
	 */
	public String getBkgSeq() {
		return this.bkgSeq;
	}
	
	/**
	 * Column Info
	 * @return cntrNo1
	 */
	public String getCntrNo1() {
		return this.cntrNo1;
	}
	
	/**
	 * Column Info
	 * @return spDtl
	 */
	public String getSpDtl() {
		return this.spDtl;
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
	 * @return cntrHeight
	 */
	public String getCntrHeight() {
		return this.cntrHeight;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return cntrSt
	 */
	public String getCntrSt() {
		return this.cntrSt;
	}
	
	/**
	 * Column Info
	 * @return dgInd
	 */
	public String getDgInd() {
		return this.dgInd;
	}
	
	/**
	 * Column Info
	 * @return ohInd
	 */
	public String getOhInd() {
		return this.ohInd;
	}
	
	/**
	 * Column Info
	 * @return rfInd
	 */
	public String getRfInd() {
		return this.rfInd;
	}
	
	/**
	 * Column Info
	 * @return rfTemp
	 */
	public String getRfTemp() {
		return this.rfTemp;
	}
	
	/**
	 * Column Info
	 * @return olInd
	 */
	public String getOlInd() {
		return this.olInd;
	}
	
	/**
	 * Column Info
	 * @return seqCntr
	 */
	public String getSeqCntr() {
		return this.seqCntr;
	}
	

	/**
	 * Column Info
	 * @param cntrNo2
	 */
	public void setCntrNo2(String cntrNo2) {
		this.cntrNo2 = cntrNo2;
	}
	
	/**
	 * Column Info
	 * @param cntrNo3
	 */
	public void setCntrNo3(String cntrNo3) {
		this.cntrNo3 = cntrNo3;
	}
	
	/**
	 * Column Info
	 * @param cntrNo4
	 */
	public void setCntrNo4(String cntrNo4) {
		this.cntrNo4 = cntrNo4;
	}
	
	/**
	 * Column Info
	 * @param tpszNo
	 */
	public void setTpszNo(String tpszNo) {
		this.tpszNo = tpszNo;
	}
	
	/**
	 * Column Info
	 * @param cntrFi
	 */
	public void setCntrFi(String cntrFi) {
		this.cntrFi = cntrFi;
	}
	
	/**
	 * Column Info
	 * @param cntrNo5
	 */
	public void setCntrNo5(String cntrNo5) {
		this.cntrNo5 = cntrNo5;
	}
	
	/**
	 * Column Info
	 * @param cntrNo6
	 */
	public void setCntrNo6(String cntrNo6) {
		this.cntrNo6 = cntrNo6;
	}
	
	/**
	 * Column Info
	 * @param noCntr
	 */
	public void setNoCntr(String noCntr) {
		this.noCntr = noCntr;
	}
	
	/**
	 * Column Info
	 * @param owInd
	 */
	public void setOwInd(String owInd) {
		this.owInd = owInd;
	}
	
	/**
	 * Column Info
	 * @param cntrSz
	 */
	public void setCntrSz(String cntrSz) {
		this.cntrSz = cntrSz;
	}
	
	/**
	 * Column Info
	 * @param bkgSeq
	 */
	public void setBkgSeq(String bkgSeq) {
		this.bkgSeq = bkgSeq;
	}
	
	/**
	 * Column Info
	 * @param cntrNo1
	 */
	public void setCntrNo1(String cntrNo1) {
		this.cntrNo1 = cntrNo1;
	}
	
	/**
	 * Column Info
	 * @param spDtl
	 */
	public void setSpDtl(String spDtl) {
		this.spDtl = spDtl;
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
	 * @param cntrHeight
	 */
	public void setCntrHeight(String cntrHeight) {
		this.cntrHeight = cntrHeight;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param cntrSt
	 */
	public void setCntrSt(String cntrSt) {
		this.cntrSt = cntrSt;
	}
	
	/**
	 * Column Info
	 * @param dgInd
	 */
	public void setDgInd(String dgInd) {
		this.dgInd = dgInd;
	}
	
	/**
	 * Column Info
	 * @param ohInd
	 */
	public void setOhInd(String ohInd) {
		this.ohInd = ohInd;
	}
	
	/**
	 * Column Info
	 * @param rfInd
	 */
	public void setRfInd(String rfInd) {
		this.rfInd = rfInd;
	}
	
	/**
	 * Column Info
	 * @param rfTemp
	 */
	public void setRfTemp(String rfTemp) {
		this.rfTemp = rfTemp;
	}
	
	/**
	 * Column Info
	 * @param olInd
	 */
	public void setOlInd(String olInd) {
		this.olInd = olInd;
	}
	
	/**
	 * Column Info
	 * @param seqCntr
	 */
	public void setSeqCntr(String seqCntr) {
		this.seqCntr = seqCntr;
	}
		
	public String getHumidNo() {
		return humidNo;
	}

	public void setHumidNo(String humidNo) {
		this.humidNo = humidNo;
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
		setCntrNo2(JSPUtil.getParameter(request, prefix + "cntr_no2", ""));
		setCntrNo3(JSPUtil.getParameter(request, prefix + "cntr_no3", ""));
		setCntrNo4(JSPUtil.getParameter(request, prefix + "cntr_no4", ""));
		setTpszNo(JSPUtil.getParameter(request, prefix + "tpsz_no", ""));
		setCntrFi(JSPUtil.getParameter(request, prefix + "cntr_fi", ""));
		setCntrNo5(JSPUtil.getParameter(request, prefix + "cntr_no5", ""));
		setCntrNo6(JSPUtil.getParameter(request, prefix + "cntr_no6", ""));
		setNoCntr(JSPUtil.getParameter(request, prefix + "no_cntr", ""));
		setOwInd(JSPUtil.getParameter(request, prefix + "ow_ind", ""));
		setCntrSz(JSPUtil.getParameter(request, prefix + "cntr_sz", ""));
		setBkgSeq(JSPUtil.getParameter(request, prefix + "bkg_seq", ""));
		setCntrNo1(JSPUtil.getParameter(request, prefix + "cntr_no1", ""));
		setSpDtl(JSPUtil.getParameter(request, prefix + "sp_dtl", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCntrHeight(JSPUtil.getParameter(request, prefix + "cntr_height", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntrSt(JSPUtil.getParameter(request, prefix + "cntr_st", ""));
		setDgInd(JSPUtil.getParameter(request, prefix + "dg_ind", ""));
		setOhInd(JSPUtil.getParameter(request, prefix + "oh_ind", ""));
		setRfInd(JSPUtil.getParameter(request, prefix + "rf_ind", ""));
		setRfTemp(JSPUtil.getParameter(request, prefix + "rf_temp", ""));
		setOlInd(JSPUtil.getParameter(request, prefix + "ol_ind", ""));
		setSeqCntr(JSPUtil.getParameter(request, prefix + "seq_cntr", ""));
		setHumidNo(JSPUtil.getParameter(request, prefix + "humid_no", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PsaBkgCntrFlatVO[]
	 */
	public PsaBkgCntrFlatVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PsaBkgCntrFlatVO[]
	 */
	public PsaBkgCntrFlatVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PsaBkgCntrFlatVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrNo2 = (JSPUtil.getParameter(request, prefix	+ "cntr_no2", length));
			String[] cntrNo3 = (JSPUtil.getParameter(request, prefix	+ "cntr_no3", length));
			String[] cntrNo4 = (JSPUtil.getParameter(request, prefix	+ "cntr_no4", length));
			String[] tpszNo = (JSPUtil.getParameter(request, prefix	+ "tpsz_no", length));
			String[] cntrFi = (JSPUtil.getParameter(request, prefix	+ "cntr_fi", length));
			String[] cntrNo5 = (JSPUtil.getParameter(request, prefix	+ "cntr_no5", length));
			String[] cntrNo6 = (JSPUtil.getParameter(request, prefix	+ "cntr_no6", length));
			String[] noCntr = (JSPUtil.getParameter(request, prefix	+ "no_cntr", length));
			String[] owInd = (JSPUtil.getParameter(request, prefix	+ "ow_ind", length));
			String[] cntrSz = (JSPUtil.getParameter(request, prefix	+ "cntr_sz", length));
			String[] bkgSeq = (JSPUtil.getParameter(request, prefix	+ "bkg_seq", length));
			String[] cntrNo1 = (JSPUtil.getParameter(request, prefix	+ "cntr_no1", length));
			String[] spDtl = (JSPUtil.getParameter(request, prefix	+ "sp_dtl", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cntrHeight = (JSPUtil.getParameter(request, prefix	+ "cntr_height", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrSt = (JSPUtil.getParameter(request, prefix	+ "cntr_st", length));
			String[] dgInd = (JSPUtil.getParameter(request, prefix	+ "dg_ind", length));
			String[] ohInd = (JSPUtil.getParameter(request, prefix	+ "oh_ind", length));
			String[] rfInd = (JSPUtil.getParameter(request, prefix	+ "rf_ind", length));
			String[] rfTemp = (JSPUtil.getParameter(request, prefix	+ "rf_temp", length));
			String[] olInd = (JSPUtil.getParameter(request, prefix	+ "ol_ind", length));
			String[] seqCntr = (JSPUtil.getParameter(request, prefix	+ "seq_cntr", length));
			String[] humidNo = (JSPUtil.getParameter(request, prefix	+ "humid_no", length));
			
			
			for (int i = 0; i < length; i++) {
				model = new PsaBkgCntrFlatVO();
				if (cntrNo2[i] != null)
					model.setCntrNo2(cntrNo2[i]);
				if (cntrNo3[i] != null)
					model.setCntrNo3(cntrNo3[i]);
				if (cntrNo4[i] != null)
					model.setCntrNo4(cntrNo4[i]);
				if (tpszNo[i] != null)
					model.setTpszNo(tpszNo[i]);
				if (cntrFi[i] != null)
					model.setCntrFi(cntrFi[i]);
				if (cntrNo5[i] != null)
					model.setCntrNo5(cntrNo5[i]);
				if (cntrNo6[i] != null)
					model.setCntrNo6(cntrNo6[i]);
				if (noCntr[i] != null)
					model.setNoCntr(noCntr[i]);
				if (owInd[i] != null)
					model.setOwInd(owInd[i]);
				if (cntrSz[i] != null)
					model.setCntrSz(cntrSz[i]);
				if (bkgSeq[i] != null)
					model.setBkgSeq(bkgSeq[i]);
				if (cntrNo1[i] != null)
					model.setCntrNo1(cntrNo1[i]);
				if (spDtl[i] != null)
					model.setSpDtl(spDtl[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cntrHeight[i] != null)
					model.setCntrHeight(cntrHeight[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrSt[i] != null)
					model.setCntrSt(cntrSt[i]);
				if (dgInd[i] != null)
					model.setDgInd(dgInd[i]);
				if (ohInd[i] != null)
					model.setOhInd(ohInd[i]);
				if (rfInd[i] != null)
					model.setRfInd(rfInd[i]);
				if (rfTemp[i] != null)
					model.setRfTemp(rfTemp[i]);
				if (olInd[i] != null)
					model.setOlInd(olInd[i]);
				if (seqCntr[i] != null)
					model.setSeqCntr(seqCntr[i]);
				if (humidNo[i] != null)
					model.setHumidNo(humidNo[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPsaBkgCntrFlatVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PsaBkgCntrFlatVO[]
	 */
	public PsaBkgCntrFlatVO[] getPsaBkgCntrFlatVOs(){
		PsaBkgCntrFlatVO[] vos = (PsaBkgCntrFlatVO[])models.toArray(new PsaBkgCntrFlatVO[models.size()]);
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
		this.cntrNo2 = this.cntrNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo3 = this.cntrNo3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo4 = this.cntrNo4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszNo = this.tpszNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrFi = this.cntrFi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo5 = this.cntrNo5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo6 = this.cntrNo6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noCntr = this.noCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.owInd = this.owInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSz = this.cntrSz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSeq = this.bkgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo1 = this.cntrNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spDtl = this.spDtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHeight = this.cntrHeight .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSt = this.cntrSt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgInd = this.dgInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ohInd = this.ohInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfInd = this.rfInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfTemp = this.rfTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.olInd = this.olInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seqCntr = this.seqCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.humidNo = this.humidNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
}

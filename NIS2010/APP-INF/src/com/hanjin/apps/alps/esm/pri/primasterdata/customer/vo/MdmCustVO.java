/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MdmCustVO.java
*@FileTitle : MdmCustVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.28
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2009.07.04 김재연 
* 1.0 Creation
=========================================================
* History
* 2011.03.30 이행지 [CHM-201109659-01] OTI Bond / Tariff Title page / OTI License Attach / Signing POA 기능 개발(Customer section) 및 Loading Agent POA Attach(L/Agent section) 기능 개발요청
*                                    - Customer 조회시 OTI Bond No, OTI License No. 가져와서 보여주기 위해 VO 수정
* 2013.05.28 이혜민 [CHM-201324516-01] Surcharge 종합체계 구축 T/F - Surcharge Summary Report 화면 신규개발                                 
* =========================================================*/

package com.hanjin.apps.alps.esm.pri.primasterdata.customer.vo;

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
 * @author 이혜민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MdmCustVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MdmCustVO> models = new ArrayList<MdmCustVO>();
	
	/* Column Info */
	private String vbsClssNm = null;
	/* Column Info */
	private String nvoccLicNo = null;
	/* Column Info */
	private String custGrpId = null;
	/* Column Info */
	private String grpSrepCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String bzetAddr = null;
	/* Column Info */
	private String srepCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String rvisCntrCustTpCd = null;
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String grpOfcCd = null;
	/* Column Info */
	private String custGrpNm = null;
	/* Column Info */
	private String nvoccBdNo = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String rvisCntrCustTpNm = null;
	/* Column Info */
	private String custGrpIdSeq = null;
	/* Column Info */
	private String nmdCustFlg = null;
	/* Column Info */
	private String custCntCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MdmCustVO() {}

	public MdmCustVO(String ibflag, String pagerows, String custGrpId, String custGrpIdSeq, String custGrpNm, String grpOfcCd, String grpSrepCd, String vbsClssNm, String custSeq, String bzetAddr, String srepCd, String custLglEngNm, String rvisCntrCustTpCd, String ofcCd, String locCd, String custCd, String rvisCntrCustTpNm, String nmdCustFlg, String custCntCd, String nvoccBdNo, String nvoccLicNo) {
		this.vbsClssNm = vbsClssNm;
		this.nvoccLicNo = nvoccLicNo;
		this.custGrpId = custGrpId;
		this.grpSrepCd = grpSrepCd;
		this.custSeq = custSeq;
		this.bzetAddr = bzetAddr;
		this.srepCd = srepCd;
		this.pagerows = pagerows;
		this.custLglEngNm = custLglEngNm;
		this.ofcCd = ofcCd;
		this.rvisCntrCustTpCd = rvisCntrCustTpCd;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.grpOfcCd = grpOfcCd;
		this.custGrpNm = custGrpNm;
		this.nvoccBdNo = nvoccBdNo;
		this.custCd = custCd;
		this.rvisCntrCustTpNm = rvisCntrCustTpNm;
		this.custGrpIdSeq = custGrpIdSeq;
		this.nmdCustFlg = nmdCustFlg;
		this.custCntCd = custCntCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vbs_clss_nm", getVbsClssNm());
		this.hashColumns.put("nvocc_lic_no", getNvoccLicNo());
		this.hashColumns.put("cust_grp_id", getCustGrpId());
		this.hashColumns.put("grp_srep_cd", getGrpSrepCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("bzet_addr", getBzetAddr());
		this.hashColumns.put("srep_cd", getSrepCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("rvis_cntr_cust_tp_cd", getRvisCntrCustTpCd());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("grp_ofc_cd", getGrpOfcCd());
		this.hashColumns.put("cust_grp_nm", getCustGrpNm());
		this.hashColumns.put("nvocc_bd_no", getNvoccBdNo());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("rvis_cntr_cust_tp_nm", getRvisCntrCustTpNm());
		this.hashColumns.put("cust_grp_id_seq", getCustGrpIdSeq());
		this.hashColumns.put("nmd_cust_flg", getNmdCustFlg());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vbs_clss_nm", "vbsClssNm");
		this.hashFields.put("nvocc_lic_no", "nvoccLicNo");
		this.hashFields.put("cust_grp_id", "custGrpId");
		this.hashFields.put("grp_srep_cd", "grpSrepCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("bzet_addr", "bzetAddr");
		this.hashFields.put("srep_cd", "srepCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("rvis_cntr_cust_tp_cd", "rvisCntrCustTpCd");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("grp_ofc_cd", "grpOfcCd");
		this.hashFields.put("cust_grp_nm", "custGrpNm");
		this.hashFields.put("nvocc_bd_no", "nvoccBdNo");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("rvis_cntr_cust_tp_nm", "rvisCntrCustTpNm");
		this.hashFields.put("cust_grp_id_seq", "custGrpIdSeq");
		this.hashFields.put("nmd_cust_flg", "nmdCustFlg");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vbsClssNm
	 */
	public String getVbsClssNm() {
		return this.vbsClssNm;
	}
	
	/**
	 * Column Info
	 * @return nvoccLicNo
	 */
	public String getNvoccLicNo() {
		return this.nvoccLicNo;
	}
	
	/**
	 * Column Info
	 * @return custGrpId
	 */
	public String getCustGrpId() {
		return this.custGrpId;
	}
	
	/**
	 * Column Info
	 * @return grpSrepCd
	 */
	public String getGrpSrepCd() {
		return this.grpSrepCd;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return bzetAddr
	 */
	public String getBzetAddr() {
		return this.bzetAddr;
	}
	
	/**
	 * Column Info
	 * @return srepCd
	 */
	public String getSrepCd() {
		return this.srepCd;
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
	 * @return custLglEngNm
	 */
	public String getCustLglEngNm() {
		return this.custLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return rvisCntrCustTpCd
	 */
	public String getRvisCntrCustTpCd() {
		return this.rvisCntrCustTpCd;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return grpOfcCd
	 */
	public String getGrpOfcCd() {
		return this.grpOfcCd;
	}
	
	/**
	 * Column Info
	 * @return custGrpNm
	 */
	public String getCustGrpNm() {
		return this.custGrpNm;
	}
	
	/**
	 * Column Info
	 * @return nvoccBdNo
	 */
	public String getNvoccBdNo() {
		return this.nvoccBdNo;
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
	 * @return rvisCntrCustTpNm
	 */
	public String getRvisCntrCustTpNm() {
		return this.rvisCntrCustTpNm;
	}
	
	/**
	 * Column Info
	 * @return custGrpIdSeq
	 */
	public String getCustGrpIdSeq() {
		return this.custGrpIdSeq;
	}
	
	/**
	 * Column Info
	 * @return nmdCustFlg
	 */
	public String getNmdCustFlg() {
		return this.nmdCustFlg;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	

	/**
	 * Column Info
	 * @param vbsClssNm
	 */
	public void setVbsClssNm(String vbsClssNm) {
		this.vbsClssNm = vbsClssNm;
	}
	
	/**
	 * Column Info
	 * @param nvoccLicNo
	 */
	public void setNvoccLicNo(String nvoccLicNo) {
		this.nvoccLicNo = nvoccLicNo;
	}
	
	/**
	 * Column Info
	 * @param custGrpId
	 */
	public void setCustGrpId(String custGrpId) {
		this.custGrpId = custGrpId;
	}
	
	/**
	 * Column Info
	 * @param grpSrepCd
	 */
	public void setGrpSrepCd(String grpSrepCd) {
		this.grpSrepCd = grpSrepCd;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param bzetAddr
	 */
	public void setBzetAddr(String bzetAddr) {
		this.bzetAddr = bzetAddr;
	}
	
	/**
	 * Column Info
	 * @param srepCd
	 */
	public void setSrepCd(String srepCd) {
		this.srepCd = srepCd;
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
	 * @param custLglEngNm
	 */
	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param rvisCntrCustTpCd
	 */
	public void setRvisCntrCustTpCd(String rvisCntrCustTpCd) {
		this.rvisCntrCustTpCd = rvisCntrCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param grpOfcCd
	 */
	public void setGrpOfcCd(String grpOfcCd) {
		this.grpOfcCd = grpOfcCd;
	}
	
	/**
	 * Column Info
	 * @param custGrpNm
	 */
	public void setCustGrpNm(String custGrpNm) {
		this.custGrpNm = custGrpNm;
	}
	
	/**
	 * Column Info
	 * @param nvoccBdNo
	 */
	public void setNvoccBdNo(String nvoccBdNo) {
		this.nvoccBdNo = nvoccBdNo;
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
	 * @param rvisCntrCustTpNm
	 */
	public void setRvisCntrCustTpNm(String rvisCntrCustTpNm) {
		this.rvisCntrCustTpNm = rvisCntrCustTpNm;
	}
	
	/**
	 * Column Info
	 * @param custGrpIdSeq
	 */
	public void setCustGrpIdSeq(String custGrpIdSeq) {
		this.custGrpIdSeq = custGrpIdSeq;
	}
	
	/**
	 * Column Info
	 * @param nmdCustFlg
	 */
	public void setNmdCustFlg(String nmdCustFlg) {
		this.nmdCustFlg = nmdCustFlg;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
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
		setVbsClssNm(JSPUtil.getParameter(request, prefix + "vbs_clss_nm", ""));
		setNvoccLicNo(JSPUtil.getParameter(request, prefix + "nvocc_lic_no", ""));
		setCustGrpId(JSPUtil.getParameter(request, prefix + "cust_grp_id", ""));
		setGrpSrepCd(JSPUtil.getParameter(request, prefix + "grp_srep_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setBzetAddr(JSPUtil.getParameter(request, prefix + "bzet_addr", ""));
		setSrepCd(JSPUtil.getParameter(request, prefix + "srep_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setRvisCntrCustTpCd(JSPUtil.getParameter(request, prefix + "rvis_cntr_cust_tp_cd", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setGrpOfcCd(JSPUtil.getParameter(request, prefix + "grp_ofc_cd", ""));
		setCustGrpNm(JSPUtil.getParameter(request, prefix + "cust_grp_nm", ""));
		setNvoccBdNo(JSPUtil.getParameter(request, prefix + "nvocc_bd_no", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setRvisCntrCustTpNm(JSPUtil.getParameter(request, prefix + "rvis_cntr_cust_tp_nm", ""));
		setCustGrpIdSeq(JSPUtil.getParameter(request, prefix + "cust_grp_id_seq", ""));
		setNmdCustFlg(JSPUtil.getParameter(request, prefix + "nmd_cust_flg", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MdmCustVO[]
	 */
	public MdmCustVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MdmCustVO[]
	 */
	public MdmCustVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MdmCustVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vbsClssNm = (JSPUtil.getParameter(request, prefix	+ "vbs_clss_nm", length));
			String[] nvoccLicNo = (JSPUtil.getParameter(request, prefix	+ "nvocc_lic_no", length));
			String[] custGrpId = (JSPUtil.getParameter(request, prefix	+ "cust_grp_id", length));
			String[] grpSrepCd = (JSPUtil.getParameter(request, prefix	+ "grp_srep_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] bzetAddr = (JSPUtil.getParameter(request, prefix	+ "bzet_addr", length));
			String[] srepCd = (JSPUtil.getParameter(request, prefix	+ "srep_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] rvisCntrCustTpCd = (JSPUtil.getParameter(request, prefix	+ "rvis_cntr_cust_tp_cd", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] grpOfcCd = (JSPUtil.getParameter(request, prefix	+ "grp_ofc_cd", length));
			String[] custGrpNm = (JSPUtil.getParameter(request, prefix	+ "cust_grp_nm", length));
			String[] nvoccBdNo = (JSPUtil.getParameter(request, prefix	+ "nvocc_bd_no", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] rvisCntrCustTpNm = (JSPUtil.getParameter(request, prefix	+ "rvis_cntr_cust_tp_nm", length));
			String[] custGrpIdSeq = (JSPUtil.getParameter(request, prefix	+ "cust_grp_id_seq", length));
			String[] nmdCustFlg = (JSPUtil.getParameter(request, prefix	+ "nmd_cust_flg", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new MdmCustVO();
				if (vbsClssNm[i] != null)
					model.setVbsClssNm(vbsClssNm[i]);
				if (nvoccLicNo[i] != null)
					model.setNvoccLicNo(nvoccLicNo[i]);
				if (custGrpId[i] != null)
					model.setCustGrpId(custGrpId[i]);
				if (grpSrepCd[i] != null)
					model.setGrpSrepCd(grpSrepCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (bzetAddr[i] != null)
					model.setBzetAddr(bzetAddr[i]);
				if (srepCd[i] != null)
					model.setSrepCd(srepCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (rvisCntrCustTpCd[i] != null)
					model.setRvisCntrCustTpCd(rvisCntrCustTpCd[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (grpOfcCd[i] != null)
					model.setGrpOfcCd(grpOfcCd[i]);
				if (custGrpNm[i] != null)
					model.setCustGrpNm(custGrpNm[i]);
				if (nvoccBdNo[i] != null)
					model.setNvoccBdNo(nvoccBdNo[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (rvisCntrCustTpNm[i] != null)
					model.setRvisCntrCustTpNm(rvisCntrCustTpNm[i]);
				if (custGrpIdSeq[i] != null)
					model.setCustGrpIdSeq(custGrpIdSeq[i]);
				if (nmdCustFlg[i] != null)
					model.setNmdCustFlg(nmdCustFlg[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMdmCustVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MdmCustVO[]
	 */
	public MdmCustVO[] getMdmCustVOs(){
		MdmCustVO[] vos = (MdmCustVO[])models.toArray(new MdmCustVO[models.size()]);
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
		this.vbsClssNm = this.vbsClssNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nvoccLicNo = this.nvoccLicNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custGrpId = this.custGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpSrepCd = this.grpSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzetAddr = this.bzetAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepCd = this.srepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisCntrCustTpCd = this.rvisCntrCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpOfcCd = this.grpOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custGrpNm = this.custGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nvoccBdNo = this.nvoccBdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisCntrCustTpNm = this.rvisCntrCustTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custGrpIdSeq = this.custGrpIdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nmdCustFlg = this.nmdCustFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

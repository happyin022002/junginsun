/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KORGiroListVO.java
*@FileTitle : KORGiroListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.09.24 박정진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박정진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KORGiroListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KORGiroListVO> models = new ArrayList<KORGiroListVO>();
	
	/* Column Info */
	private String giroRmk = null;
	/* Column Info */
	private String blSrcNo = null;
	/* Column Info */
	private String bzctNm = null;
	/* Column Info */
	private String loclNm = null;
	/* Column Info */
	private String actCustSeq = null;
	/* Column Info */
	private String invTvaAmt = null;
	/* Column Info */
	private String custRgstNo = null;
	/* Column Info */
	private String sailArrDt = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String loclAddr = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String issDt = null;
	/* Column Info */
	private String invSplAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String actCustCntCd = null;
	/* Column Info */
	private String ownrNm = null;
	/* Column Info */
	private String dueDt = null;
	/* Column Info */
	private String giroNo = null;
		
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String totGiroAmt = null;
	/* Column Info */
	private String splGiroAmt = null;
	/* Column Info */
	private String tvaGiroAmt = null;
	/* Column Info */
	private String deltFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	/** Table Value Object Multi Data 처리 */
	private List<InvArGiroVO> invArGiroVO;
	
	public KORGiroListVO() {}

	public KORGiroListVO(String ibflag, String pagerows, String blSrcNo, String giroNo, String issDt, String arOfcCd, String actCustCntCd, String actCustSeq, String loclNm, String custRgstNo, String loclAddr, String ownrNm, String bzctNm, String vvd, String sailArrDt, String dueDt, String giroRmk, String invSplAmt, String invTvaAmt, String custCd, String custLglEngNm, String totGiroAmt, String splGiroAmt, String tvaGiroAmt, String deltFlg) {
		this.giroRmk = giroRmk;
		this.blSrcNo = blSrcNo;
		this.bzctNm = bzctNm;
		this.loclNm = loclNm;
		this.actCustSeq = actCustSeq;
		this.invTvaAmt = invTvaAmt;
		this.custRgstNo = custRgstNo;
		this.sailArrDt = sailArrDt;
		this.arOfcCd = arOfcCd;
		this.loclAddr = loclAddr;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.issDt = issDt;
		this.invSplAmt = invSplAmt;
		this.ibflag = ibflag;
		this.actCustCntCd = actCustCntCd;
		this.ownrNm = ownrNm;
		this.dueDt = dueDt;
		this.giroNo = giroNo;
		this.custCd = custCd;
		this.custLglEngNm = custLglEngNm;
		this.totGiroAmt = totGiroAmt;
		this.splGiroAmt = splGiroAmt;
		this.tvaGiroAmt = tvaGiroAmt;
		this.deltFlg = deltFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("giro_rmk", getGiroRmk());
		this.hashColumns.put("bl_src_no", getBlSrcNo());
		this.hashColumns.put("bzct_nm", getBzctNm());
		this.hashColumns.put("locl_nm", getLoclNm());
		this.hashColumns.put("act_cust_seq", getActCustSeq());
		this.hashColumns.put("inv_tva_amt", getInvTvaAmt());
		this.hashColumns.put("cust_rgst_no", getCustRgstNo());
		this.hashColumns.put("sail_arr_dt", getSailArrDt());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("locl_addr", getLoclAddr());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("iss_dt", getIssDt());
		this.hashColumns.put("inv_spl_amt", getInvSplAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("act_cust_cnt_cd", getActCustCntCd());
		this.hashColumns.put("ownr_nm", getOwnrNm());
		this.hashColumns.put("due_dt", getDueDt());
		this.hashColumns.put("giro_no", getGiroNo());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());	
		this.hashColumns.put("tot_giro_amt", getTotGiroAmt());	
		this.hashColumns.put("spl_giro_amt", getSplGiroAmt());	
		this.hashColumns.put("tva_giro_amt", getTvaGiroAmt());	
		this.hashColumns.put("delt_flg", getDeltFlg());	
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("giro_rmk", "giroRmk");
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("bzct_nm", "bzctNm");
		this.hashFields.put("locl_nm", "loclNm");
		this.hashFields.put("act_cust_seq", "actCustSeq");
		this.hashFields.put("inv_tva_amt", "invTvaAmt");
		this.hashFields.put("cust_rgst_no", "custRgstNo");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("locl_addr", "loclAddr");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("iss_dt", "issDt");
		this.hashFields.put("inv_spl_amt", "invSplAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("act_cust_cnt_cd", "actCustCntCd");
		this.hashFields.put("ownr_nm", "ownrNm");
		this.hashFields.put("due_dt", "dueDt");
		this.hashFields.put("giro_no", "giroNo");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("tot_giro_amt", "totGiroAmt");
		this.hashFields.put("spl_giro_amt", "splGiroAmt");
		this.hashFields.put("tva_giro_amt", "tvaGiroAmt");
		this.hashFields.put("delt_flg", "deltFlg");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return giroRmk
	 */
	public String getGiroRmk() {
		return this.giroRmk;
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
	 * @return bzctNm
	 */
	public String getBzctNm() {
		return this.bzctNm;
	}
	
	/**
	 * Column Info
	 * @return loclNm
	 */
	public String getLoclNm() {
		return this.loclNm;
	}
	
	/**
	 * Column Info
	 * @return actCustSeq
	 */
	public String getActCustSeq() {
		return this.actCustSeq;
	}
	
	/**
	 * Column Info
	 * @return invTvaAmt
	 */
	public String getInvTvaAmt() {
		return this.invTvaAmt;
	}
	
	/**
	 * Column Info
	 * @return custRgstNo
	 */
	public String getCustRgstNo() {
		return this.custRgstNo;
	}
	
	/**
	 * Column Info
	 * @return sailArrDt
	 */
	public String getSailArrDt() {
		return this.sailArrDt;
	}
	
	/**
	 * Column Info
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
	}
	
	/**
	 * Column Info
	 * @return loclAddr
	 */
	public String getLoclAddr() {
		return this.loclAddr;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return issDt
	 */
	public String getIssDt() {
		return this.issDt;
	}
	
	/**
	 * Column Info
	 * @return invSplAmt
	 */
	public String getInvSplAmt() {
		return this.invSplAmt;
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
	 * @return actCustCntCd
	 */
	public String getActCustCntCd() {
		return this.actCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return ownrNm
	 */
	public String getOwnrNm() {
		return this.ownrNm;
	}
	
	/**
	 * Column Info
	 * @return dueDt
	 */
	public String getDueDt() {
		return this.dueDt;
	}
	
	/**
	 * Column Info
	 * @return giroNo
	 */
	public String getGiroNo() {
		return this.giroNo;
	}
	

	/**
	 * Column Info
	 * @param giroRmk
	 */
	public void setGiroRmk(String giroRmk) {
		this.giroRmk = giroRmk;
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
	 * @param bzctNm
	 */
	public void setBzctNm(String bzctNm) {
		this.bzctNm = bzctNm;
	}
	
	/**
	 * Column Info
	 * @param loclNm
	 */
	public void setLoclNm(String loclNm) {
		this.loclNm = loclNm;
	}
	
	/**
	 * Column Info
	 * @param actCustSeq
	 */
	public void setActCustSeq(String actCustSeq) {
		this.actCustSeq = actCustSeq;
	}
	
	/**
	 * Column Info
	 * @param invTvaAmt
	 */
	public void setInvTvaAmt(String invTvaAmt) {
		this.invTvaAmt = invTvaAmt;
	}
	
	/**
	 * Column Info
	 * @param custRgstNo
	 */
	public void setCustRgstNo(String custRgstNo) {
		this.custRgstNo = custRgstNo;
	}
	
	/**
	 * Column Info
	 * @param sailArrDt
	 */
	public void setSailArrDt(String sailArrDt) {
		this.sailArrDt = sailArrDt;
	}
	
	/**
	 * Column Info
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
	}
	
	/**
	 * Column Info
	 * @param loclAddr
	 */
	public void setLoclAddr(String loclAddr) {
		this.loclAddr = loclAddr;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param issDt
	 */
	public void setIssDt(String issDt) {
		this.issDt = issDt;
	}
	
	/**
	 * Column Info
	 * @param invSplAmt
	 */
	public void setInvSplAmt(String invSplAmt) {
		this.invSplAmt = invSplAmt;
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
	 * @param actCustCntCd
	 */
	public void setActCustCntCd(String actCustCntCd) {
		this.actCustCntCd = actCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param ownrNm
	 */
	public void setOwnrNm(String ownrNm) {
		this.ownrNm = ownrNm;
	}
	
	/**
	 * Column Info
	 * @param dueDt
	 */
	public void setDueDt(String dueDt) {
		this.dueDt = dueDt;
	}
	
	/**
	 * Column Info
	 * @param giroNo
	 */
	public void setGiroNo(String giroNo) {
		this.giroNo = giroNo;
	}
	
	public List<InvArGiroVO> getInvArGiroVO() {
		return invArGiroVO;
	}

	public void setInvArGiroVO(List<InvArGiroVO> invArGiroVO) {
		this.invArGiroVO = invArGiroVO;
	}
	
	/**
	 * @return the custCd
	 */
	public String getCustCd() {
		return custCd;
	}

	/**
	 * @param custCd the custCd to set
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}

	/**
	 * @return the custLglEngNm
	 */
	public String getCustLglEngNm() {
		return custLglEngNm;
	}

	/**
	 * @param custLglEngNm the custLglEngNm to set
	 */
	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
	}
    
	/**
	 * @return the totGiroAmt
	 */
	public String getTotGiroAmt() {
		return totGiroAmt;
	}

	/**
	 * @param totGiroAmt the totGiroAmt to set
	 */
	public void setTotGiroAmt(String totGiroAmt) {
		this.totGiroAmt = totGiroAmt;
	}

	/**
	 * @return the splGiroAmt
	 */
	public String getSplGiroAmt() {
		return splGiroAmt;
	}

	/**
	 * @param splGiroAmt the splGiroAmt to set
	 */
	public void setSplGiroAmt(String splGiroAmt) {
		this.splGiroAmt = splGiroAmt;
	}

	/**
	 * @return the tvaGiroAmt
	 */
	public String getTvaGiroAmt() {
		return tvaGiroAmt;
	}

	/**
	 * @param tvaGiroAmt the tvaGiroAmt to set
	 */
	public void setTvaGiroAmt(String tvaGiroAmt) {
		this.tvaGiroAmt = tvaGiroAmt;
	}

	/**
	 * @return the deltFlg
	 */
	public String getDeltFlg() {
		return deltFlg;
	}

	/**
	 * @param deltFlg the deltFlg to set
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setGiroRmk(JSPUtil.getParameter(request, "giro_rmk", ""));
		setBlSrcNo(JSPUtil.getParameter(request, "bl_src_no", ""));
		setBzctNm(JSPUtil.getParameter(request, "bzct_nm", ""));
		setLoclNm(JSPUtil.getParameter(request, "locl_nm", ""));
		setActCustSeq(JSPUtil.getParameter(request, "act_cust_seq", ""));
		setInvTvaAmt(JSPUtil.getParameter(request, "inv_tva_amt", ""));
		setCustRgstNo(JSPUtil.getParameter(request, "cust_rgst_no", ""));
		setSailArrDt(JSPUtil.getParameter(request, "sail_arr_dt", ""));
		setArOfcCd(JSPUtil.getParameter(request, "ar_ofc_cd", ""));
		setLoclAddr(JSPUtil.getParameter(request, "locl_addr", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setIssDt(JSPUtil.getParameter(request, "iss_dt", ""));
		setInvSplAmt(JSPUtil.getParameter(request, "inv_spl_amt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setActCustCntCd(JSPUtil.getParameter(request, "act_cust_cnt_cd", ""));
		setOwnrNm(JSPUtil.getParameter(request, "ownr_nm", ""));
		setDueDt(JSPUtil.getParameter(request, "due_dt", ""));
		setGiroNo(JSPUtil.getParameter(request, "giro_no", ""));
		setCustCd(JSPUtil.getParameter(request, "cust_cd", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, "cust_lgl_eng_nm", ""));
		setTotGiroAmt(JSPUtil.getParameter(request, "tot_giro_amt", ""));
		setSplGiroAmt(JSPUtil.getParameter(request, "spl_giro_amt", ""));
		setTvaGiroAmt(JSPUtil.getParameter(request, "tva_giro_amt", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KORGiroListVO[]
	 */
	public KORGiroListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KORGiroListVO[]
	 */
	public KORGiroListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KORGiroListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] giroRmk = (JSPUtil.getParameter(request, prefix	+ "giro_rmk", length));
			String[] blSrcNo = (JSPUtil.getParameter(request, prefix	+ "bl_src_no", length));
			String[] bzctNm = (JSPUtil.getParameter(request, prefix	+ "bzct_nm", length));
			String[] loclNm = (JSPUtil.getParameter(request, prefix	+ "locl_nm", length));
			String[] actCustSeq = (JSPUtil.getParameter(request, prefix	+ "act_cust_seq", length));
			String[] invTvaAmt = (JSPUtil.getParameter(request, prefix	+ "inv_tva_amt", length));
			String[] custRgstNo = (JSPUtil.getParameter(request, prefix	+ "cust_rgst_no", length));
			String[] sailArrDt = (JSPUtil.getParameter(request, prefix	+ "sail_arr_dt", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] loclAddr = (JSPUtil.getParameter(request, prefix	+ "locl_addr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] issDt = (JSPUtil.getParameter(request, prefix	+ "iss_dt", length));
			String[] invSplAmt = (JSPUtil.getParameter(request, prefix	+ "inv_spl_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] actCustCntCd = (JSPUtil.getParameter(request, prefix	+ "act_cust_cnt_cd", length));
			String[] ownrNm = (JSPUtil.getParameter(request, prefix	+ "ownr_nm", length));
			String[] dueDt = (JSPUtil.getParameter(request, prefix	+ "due_dt", length));
			String[] giroNo = (JSPUtil.getParameter(request, prefix	+ "giro_no", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] totGiroAmt = (JSPUtil.getParameter(request, prefix	+ "tot_giro_amt", length));
			String[] splGiroAmt = (JSPUtil.getParameter(request, prefix	+ "spl_giro_amt", length));
			String[] tvaGiroAmt = (JSPUtil.getParameter(request, prefix	+ "tva_giro_amt", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new KORGiroListVO();
				if (giroRmk[i] != null)
					model.setGiroRmk(giroRmk[i]);
				if (blSrcNo[i] != null)
					model.setBlSrcNo(blSrcNo[i]);
				if (bzctNm[i] != null)
					model.setBzctNm(bzctNm[i]);
				if (loclNm[i] != null)
					model.setLoclNm(loclNm[i]);
				if (actCustSeq[i] != null)
					model.setActCustSeq(actCustSeq[i]);
				if (invTvaAmt[i] != null)
					model.setInvTvaAmt(invTvaAmt[i]);
				if (custRgstNo[i] != null)
					model.setCustRgstNo(custRgstNo[i]);
				if (sailArrDt[i] != null)
					model.setSailArrDt(sailArrDt[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (loclAddr[i] != null)
					model.setLoclAddr(loclAddr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (issDt[i] != null)
					model.setIssDt(issDt[i]);
				if (invSplAmt[i] != null)
					model.setInvSplAmt(invSplAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (actCustCntCd[i] != null)
					model.setActCustCntCd(actCustCntCd[i]);
				if (ownrNm[i] != null)
					model.setOwnrNm(ownrNm[i]);
				if (dueDt[i] != null)
					model.setDueDt(dueDt[i]);
				if (giroNo[i] != null)
					model.setGiroNo(giroNo[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (totGiroAmt[i] != null)
					model.setTotGiroAmt(totGiroAmt[i]);
				if (splGiroAmt[i] != null)
					model.setSplGiroAmt(splGiroAmt[i]);
				if (tvaGiroAmt[i] != null)
					model.setTvaGiroAmt(tvaGiroAmt[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKORGiroListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KORGiroListVO[]
	 */
	public KORGiroListVO[] getKORGiroListVOs(){
		KORGiroListVO[] vos = (KORGiroListVO[])models.toArray(new KORGiroListVO[models.size()]);
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
		this.giroRmk = this.giroRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrcNo = this.blSrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzctNm = this.bzctNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclNm = this.loclNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustSeq = this.actCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTvaAmt = this.invTvaAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRgstNo = this.custRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt = this.sailArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclAddr = this.loclAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt = this.issDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSplAmt = this.invSplAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustCntCd = this.actCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrNm = this.ownrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDt = this.dueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.giroNo = this.giroNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totGiroAmt = this.totGiroAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splGiroAmt = this.splGiroAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tvaGiroAmt = this.tvaGiroAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}
}

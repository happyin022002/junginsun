/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InPriPrsRoutCsVO.java
*@FileTitle : InPriPrsRoutCsVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.12
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.01.12 송민석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 송민석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InPriPrsRoutCsVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InPriPrsRoutCsVO> models = new ArrayList<InPriPrsRoutCsVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String prcCgoTpCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String bkgRcvTermCd = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pctlNo = null;
	/* Column Info */
	private String teuFrtRev = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String routCsSrcDt = null;
	/* Column Info */
	private String routCsClssNo = null;
	/* Column Info */
	private String obSlsOfcCd = null;
	/* Column Info */
	private String routCsNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String bkgDeTermCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InPriPrsRoutCsVO() {}

	public InPriPrsRoutCsVO(String ibflag, String pagerows, String routCsNo, String routCsSrcDt, String pctlNo, String updUsrId, String porCd, String polCd, String podCd, String delCd, String bkgRcvTermCd, String bkgDeTermCd, String bkgOfcCd, String ctrtOfcCd, String obSlsOfcCd, String ratUtCd, String prcCgoTpCd, String teuFrtRev, String routCsClssNo) {
		this.porCd = porCd;
		this.bkgOfcCd = bkgOfcCd;
		this.prcCgoTpCd = prcCgoTpCd;
		this.delCd = delCd;
		this.bkgRcvTermCd = bkgRcvTermCd;
		this.ratUtCd = ratUtCd;
		this.pagerows = pagerows;
		this.pctlNo = pctlNo;
		this.teuFrtRev = teuFrtRev;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.ctrtOfcCd = ctrtOfcCd;
		this.routCsSrcDt = routCsSrcDt;
		this.routCsClssNo = routCsClssNo;
		this.obSlsOfcCd = obSlsOfcCd;
		this.routCsNo = routCsNo;
		this.updUsrId = updUsrId;
		this.bkgDeTermCd = bkgDeTermCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("prc_cgo_tp_cd", getPrcCgoTpCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("bkg_rcv_term_cd", getBkgRcvTermCd());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pctl_no", getPctlNo());
		this.hashColumns.put("teu_frt_rev", getTeuFrtRev());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("rout_cs_src_dt", getRoutCsSrcDt());
		this.hashColumns.put("rout_cs_clss_no", getRoutCsClssNo());
		this.hashColumns.put("ob_sls_ofc_cd", getObSlsOfcCd());
		this.hashColumns.put("rout_cs_no", getRoutCsNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("bkg_de_term_cd", getBkgDeTermCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("prc_cgo_tp_cd", "prcCgoTpCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("bkg_rcv_term_cd", "bkgRcvTermCd");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pctl_no", "pctlNo");
		this.hashFields.put("teu_frt_rev", "teuFrtRev");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("rout_cs_src_dt", "routCsSrcDt");
		this.hashFields.put("rout_cs_clss_no", "routCsClssNo");
		this.hashFields.put("ob_sls_ofc_cd", "obSlsOfcCd");
		this.hashFields.put("rout_cs_no", "routCsNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("bkg_de_term_cd", "bkgDeTermCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return prcCgoTpCd
	 */
	public String getPrcCgoTpCd() {
		return this.prcCgoTpCd;
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
	 * @return bkgRcvTermCd
	 */
	public String getBkgRcvTermCd() {
		return this.bkgRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return ratUtCd
	 */
	public String getRatUtCd() {
		return this.ratUtCd;
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
	 * @return pctlNo
	 */
	public String getPctlNo() {
		return this.pctlNo;
	}
	
	/**
	 * Column Info
	 * @return teuFrtRev
	 */
	public String getTeuFrtRev() {
		return this.teuFrtRev;
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
	 * @return ctrtOfcCd
	 */
	public String getCtrtOfcCd() {
		return this.ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @return routCsSrcDt
	 */
	public String getRoutCsSrcDt() {
		return this.routCsSrcDt;
	}
	
	/**
	 * Column Info
	 * @return routCsClssNo
	 */
	public String getRoutCsClssNo() {
		return this.routCsClssNo;
	}
	
	/**
	 * Column Info
	 * @return obSlsOfcCd
	 */
	public String getObSlsOfcCd() {
		return this.obSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return routCsNo
	 */
	public String getRoutCsNo() {
		return this.routCsNo;
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
	 * @return bkgDeTermCd
	 */
	public String getBkgDeTermCd() {
		return this.bkgDeTermCd;
	}
	

	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param prcCgoTpCd
	 */
	public void setPrcCgoTpCd(String prcCgoTpCd) {
		this.prcCgoTpCd = prcCgoTpCd;
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
	 * @param bkgRcvTermCd
	 */
	public void setBkgRcvTermCd(String bkgRcvTermCd) {
		this.bkgRcvTermCd = bkgRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param ratUtCd
	 */
	public void setRatUtCd(String ratUtCd) {
		this.ratUtCd = ratUtCd;
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
	 * @param pctlNo
	 */
	public void setPctlNo(String pctlNo) {
		this.pctlNo = pctlNo;
	}
	
	/**
	 * Column Info
	 * @param teuFrtRev
	 */
	public void setTeuFrtRev(String teuFrtRev) {
		this.teuFrtRev = teuFrtRev;
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
	 * @param ctrtOfcCd
	 */
	public void setCtrtOfcCd(String ctrtOfcCd) {
		this.ctrtOfcCd = ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @param routCsSrcDt
	 */
	public void setRoutCsSrcDt(String routCsSrcDt) {
		this.routCsSrcDt = routCsSrcDt;
	}
	
	/**
	 * Column Info
	 * @param routCsClssNo
	 */
	public void setRoutCsClssNo(String routCsClssNo) {
		this.routCsClssNo = routCsClssNo;
	}
	
	/**
	 * Column Info
	 * @param obSlsOfcCd
	 */
	public void setObSlsOfcCd(String obSlsOfcCd) {
		this.obSlsOfcCd = obSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param routCsNo
	 */
	public void setRoutCsNo(String routCsNo) {
		this.routCsNo = routCsNo;
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
	 * @param bkgDeTermCd
	 */
	public void setBkgDeTermCd(String bkgDeTermCd) {
		this.bkgDeTermCd = bkgDeTermCd;
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
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setPrcCgoTpCd(JSPUtil.getParameter(request, prefix + "prc_cgo_tp_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setBkgRcvTermCd(JSPUtil.getParameter(request, prefix + "bkg_rcv_term_cd", ""));
		setRatUtCd(JSPUtil.getParameter(request, prefix + "rat_ut_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPctlNo(JSPUtil.getParameter(request, prefix + "pctl_no", ""));
		setTeuFrtRev(JSPUtil.getParameter(request, prefix + "teu_frt_rev", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
		setRoutCsSrcDt(JSPUtil.getParameter(request, prefix + "rout_cs_src_dt", ""));
		setRoutCsClssNo(JSPUtil.getParameter(request, prefix + "rout_cs_clss_no", ""));
		setObSlsOfcCd(JSPUtil.getParameter(request, prefix + "ob_sls_ofc_cd", ""));
		setRoutCsNo(JSPUtil.getParameter(request, prefix + "rout_cs_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setBkgDeTermCd(JSPUtil.getParameter(request, prefix + "bkg_de_term_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InPriPrsRoutCsVO[]
	 */
	public InPriPrsRoutCsVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InPriPrsRoutCsVO[]
	 */
	public InPriPrsRoutCsVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InPriPrsRoutCsVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] prcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_cgo_tp_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] bkgRcvTermCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rcv_term_cd", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] pctlNo = (JSPUtil.getParameter(request, prefix	+ "pctl_no", length));
			String[] teuFrtRev = (JSPUtil.getParameter(request, prefix	+ "teu_frt_rev", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] routCsSrcDt = (JSPUtil.getParameter(request, prefix	+ "rout_cs_src_dt", length));
			String[] routCsClssNo = (JSPUtil.getParameter(request, prefix	+ "rout_cs_clss_no", length));
			String[] obSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ob_sls_ofc_cd", length));
			String[] routCsNo = (JSPUtil.getParameter(request, prefix	+ "rout_cs_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] bkgDeTermCd = (JSPUtil.getParameter(request, prefix	+ "bkg_de_term_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new InPriPrsRoutCsVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (prcCgoTpCd[i] != null)
					model.setPrcCgoTpCd(prcCgoTpCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (bkgRcvTermCd[i] != null)
					model.setBkgRcvTermCd(bkgRcvTermCd[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pctlNo[i] != null)
					model.setPctlNo(pctlNo[i]);
				if (teuFrtRev[i] != null)
					model.setTeuFrtRev(teuFrtRev[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (routCsSrcDt[i] != null)
					model.setRoutCsSrcDt(routCsSrcDt[i]);
				if (routCsClssNo[i] != null)
					model.setRoutCsClssNo(routCsClssNo[i]);
				if (obSlsOfcCd[i] != null)
					model.setObSlsOfcCd(obSlsOfcCd[i]);
				if (routCsNo[i] != null)
					model.setRoutCsNo(routCsNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (bkgDeTermCd[i] != null)
					model.setBkgDeTermCd(bkgDeTermCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInPriPrsRoutCsVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InPriPrsRoutCsVO[]
	 */
	public InPriPrsRoutCsVO[] getInPriPrsRoutCsVOs(){
		InPriPrsRoutCsVO[] vos = (InPriPrsRoutCsVO[])models.toArray(new InPriPrsRoutCsVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCgoTpCd = this.prcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRcvTermCd = this.bkgRcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctlNo = this.pctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teuFrtRev = this.teuFrtRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routCsSrcDt = this.routCsSrcDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routCsClssNo = this.routCsClssNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSlsOfcCd = this.obSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routCsNo = this.routCsNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDeTermCd = this.bkgDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

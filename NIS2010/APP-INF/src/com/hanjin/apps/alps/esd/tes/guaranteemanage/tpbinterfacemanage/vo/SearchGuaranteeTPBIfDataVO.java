/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchGuaranteeTPBIfDataVO.java
*@FileTitle : SearchGuaranteeTPBIfDataVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.27
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2010.01.27 yOng hO lEE 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.tes.guaranteemanage.tpbinterfacemanage.vo;

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
 * @author yOng hO lEE
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchGuaranteeTPBIfDataVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchGuaranteeTPBIfDataVO> models = new ArrayList<SearchGuaranteeTPBIfDataVO>();
	
	/* Column Info */
	private String gnteCustCd = null;
	/* Column Info */
	private String tmlIfSeq = null;
	/* Column Info */
	private String ttlAmt = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String n3ptyDesc = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String gnteCustCdName = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String tmlGnteCntrListSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String gnteNo = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String ifAmt = null;
	/* Column Info */
	private String gnteTpCd = null;
	/* Column Info */
	private String tmlIfOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchGuaranteeTPBIfDataVO() {}

	public SearchGuaranteeTPBIfDataVO(String ibflag, String pagerows, String gnteNo, String ttlAmt, String ofcCd, String gnteTpCd, String gnteCustCd, String gnteCustCdName, String tmlGnteCntrListSeq, String bkgNo, String blNo, String scNo, String cntrTpszCd, String cntrNo, String vvdCd, String ifAmt, String tmlIfOfcCd, String tmlIfSeq, String n3ptyDesc) {
		this.gnteCustCd = gnteCustCd;
		this.tmlIfSeq = tmlIfSeq;
		this.ttlAmt = ttlAmt;
		this.blNo = blNo;
		this.n3ptyDesc = n3ptyDesc;
		this.pagerows = pagerows;
		this.gnteCustCdName = gnteCustCdName;
		this.ofcCd = ofcCd;
		this.tmlGnteCntrListSeq = tmlGnteCntrListSeq;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.gnteNo = gnteNo;
		this.vvdCd = vvdCd;
		this.cntrNo = cntrNo;
		this.scNo = scNo;
		this.cntrTpszCd = cntrTpszCd;
		this.ifAmt = ifAmt;
		this.gnteTpCd = gnteTpCd;
		this.tmlIfOfcCd = tmlIfOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("gnte_cust_cd", getGnteCustCd());
		this.hashColumns.put("tml_if_seq", getTmlIfSeq());
		this.hashColumns.put("ttl_amt", getTtlAmt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("n3pty_desc", getN3ptyDesc());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("gnte_cust_cd_name", getGnteCustCdName());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("tml_gnte_cntr_list_seq", getTmlGnteCntrListSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("gnte_no", getGnteNo());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("if_amt", getIfAmt());
		this.hashColumns.put("gnte_tp_cd", getGnteTpCd());
		this.hashColumns.put("tml_if_ofc_cd", getTmlIfOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("gnte_cust_cd", "gnteCustCd");
		this.hashFields.put("tml_if_seq", "tmlIfSeq");
		this.hashFields.put("ttl_amt", "ttlAmt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("n3pty_desc", "n3ptyDesc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("gnte_cust_cd_name", "gnteCustCdName");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("tml_gnte_cntr_list_seq", "tmlGnteCntrListSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("gnte_no", "gnteNo");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("if_amt", "ifAmt");
		this.hashFields.put("gnte_tp_cd", "gnteTpCd");
		this.hashFields.put("tml_if_ofc_cd", "tmlIfOfcCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return gnteCustCd
	 */
	public String getGnteCustCd() {
		return this.gnteCustCd;
	}
	
	/**
	 * Column Info
	 * @return tmlIfSeq
	 */
	public String getTmlIfSeq() {
		return this.tmlIfSeq;
	}
	
	/**
	 * Column Info
	 * @return ttlAmt
	 */
	public String getTtlAmt() {
		return this.ttlAmt;
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
	 * @return n3ptyDesc
	 */
	public String getN3ptyDesc() {
		return this.n3ptyDesc;
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
	 * @return gnteCustCdName
	 */
	public String getGnteCustCdName() {
		return this.gnteCustCdName;
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
	 * @return tmlGnteCntrListSeq
	 */
	public String getTmlGnteCntrListSeq() {
		return this.tmlGnteCntrListSeq;
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
	 * @return gnteNo
	 */
	public String getGnteNo() {
		return this.gnteNo;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return ifAmt
	 */
	public String getIfAmt() {
		return this.ifAmt;
	}
	
	/**
	 * Column Info
	 * @return gnteTpCd
	 */
	public String getGnteTpCd() {
		return this.gnteTpCd;
	}
	
	/**
	 * Column Info
	 * @return tmlIfOfcCd
	 */
	public String getTmlIfOfcCd() {
		return this.tmlIfOfcCd;
	}
	

	/**
	 * Column Info
	 * @param gnteCustCd
	 */
	public void setGnteCustCd(String gnteCustCd) {
		this.gnteCustCd = gnteCustCd;
	}
	
	/**
	 * Column Info
	 * @param tmlIfSeq
	 */
	public void setTmlIfSeq(String tmlIfSeq) {
		this.tmlIfSeq = tmlIfSeq;
	}
	
	/**
	 * Column Info
	 * @param ttlAmt
	 */
	public void setTtlAmt(String ttlAmt) {
		this.ttlAmt = ttlAmt;
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
	 * @param n3ptyDesc
	 */
	public void setN3ptyDesc(String n3ptyDesc) {
		this.n3ptyDesc = n3ptyDesc;
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
	 * @param gnteCustCdName
	 */
	public void setGnteCustCdName(String gnteCustCdName) {
		this.gnteCustCdName = gnteCustCdName;
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
	 * @param tmlGnteCntrListSeq
	 */
	public void setTmlGnteCntrListSeq(String tmlGnteCntrListSeq) {
		this.tmlGnteCntrListSeq = tmlGnteCntrListSeq;
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
	 * @param gnteNo
	 */
	public void setGnteNo(String gnteNo) {
		this.gnteNo = gnteNo;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param ifAmt
	 */
	public void setIfAmt(String ifAmt) {
		this.ifAmt = ifAmt;
	}
	
	/**
	 * Column Info
	 * @param gnteTpCd
	 */
	public void setGnteTpCd(String gnteTpCd) {
		this.gnteTpCd = gnteTpCd;
	}
	
	/**
	 * Column Info
	 * @param tmlIfOfcCd
	 */
	public void setTmlIfOfcCd(String tmlIfOfcCd) {
		this.tmlIfOfcCd = tmlIfOfcCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setGnteCustCd(JSPUtil.getParameter(request, "gnte_cust_cd", ""));
		setTmlIfSeq(JSPUtil.getParameter(request, "tml_if_seq", ""));
		setTtlAmt(JSPUtil.getParameter(request, "ttl_amt", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setN3ptyDesc(JSPUtil.getParameter(request, "n3pty_desc", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setGnteCustCdName(JSPUtil.getParameter(request, "gnte_cust_cd_name", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setTmlGnteCntrListSeq(JSPUtil.getParameter(request, "tml_gnte_cntr_list_seq", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setGnteNo(JSPUtil.getParameter(request, "gnte_no", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setIfAmt(JSPUtil.getParameter(request, "if_amt", ""));
		setGnteTpCd(JSPUtil.getParameter(request, "gnte_tp_cd", ""));
		setTmlIfOfcCd(JSPUtil.getParameter(request, "tml_if_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchGuaranteeTPBIfDataVO[]
	 */
	public SearchGuaranteeTPBIfDataVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchGuaranteeTPBIfDataVO[]
	 */
	public SearchGuaranteeTPBIfDataVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchGuaranteeTPBIfDataVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] gnteCustCd = (JSPUtil.getParameter(request, prefix	+ "gnte_cust_cd", length));
			String[] tmlIfSeq = (JSPUtil.getParameter(request, prefix	+ "tml_if_seq", length));
			String[] ttlAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_amt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] n3ptyDesc = (JSPUtil.getParameter(request, prefix	+ "n3pty_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] gnteCustCdName = (JSPUtil.getParameter(request, prefix	+ "gnte_cust_cd_name", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] tmlGnteCntrListSeq = (JSPUtil.getParameter(request, prefix	+ "tml_gnte_cntr_list_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] gnteNo = (JSPUtil.getParameter(request, prefix	+ "gnte_no", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] ifAmt = (JSPUtil.getParameter(request, prefix	+ "if_amt", length));
			String[] gnteTpCd = (JSPUtil.getParameter(request, prefix	+ "gnte_tp_cd", length));
			String[] tmlIfOfcCd = (JSPUtil.getParameter(request, prefix	+ "tml_if_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchGuaranteeTPBIfDataVO();
				if (gnteCustCd[i] != null)
					model.setGnteCustCd(gnteCustCd[i]);
				if (tmlIfSeq[i] != null)
					model.setTmlIfSeq(tmlIfSeq[i]);
				if (ttlAmt[i] != null)
					model.setTtlAmt(ttlAmt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (n3ptyDesc[i] != null)
					model.setN3ptyDesc(n3ptyDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (gnteCustCdName[i] != null)
					model.setGnteCustCdName(gnteCustCdName[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (tmlGnteCntrListSeq[i] != null)
					model.setTmlGnteCntrListSeq(tmlGnteCntrListSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (gnteNo[i] != null)
					model.setGnteNo(gnteNo[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (ifAmt[i] != null)
					model.setIfAmt(ifAmt[i]);
				if (gnteTpCd[i] != null)
					model.setGnteTpCd(gnteTpCd[i]);
				if (tmlIfOfcCd[i] != null)
					model.setTmlIfOfcCd(tmlIfOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchGuaranteeTPBIfDataVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchGuaranteeTPBIfDataVO[]
	 */
	public SearchGuaranteeTPBIfDataVO[] getSearchGuaranteeTPBIfDataVOs(){
		SearchGuaranteeTPBIfDataVO[] vos = (SearchGuaranteeTPBIfDataVO[])models.toArray(new SearchGuaranteeTPBIfDataVO[models.size()]);
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
		this.gnteCustCd = this.gnteCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlIfSeq = this.tmlIfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlAmt = this.ttlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyDesc = this.n3ptyDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gnteCustCdName = this.gnteCustCdName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlGnteCntrListSeq = this.tmlGnteCntrListSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gnteNo = this.gnteNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifAmt = this.ifAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gnteTpCd = this.gnteTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlIfOfcCd = this.tmlIfOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

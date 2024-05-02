/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RsltCdListVO2.java
*@FileTitle : RsltCdListVO2
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.11
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.11  
* 1.0 Creation
* histroy
* 2011-07-07 채창호 [CHM-201111381-01] Dwell Notification Management 신규개발 요청.
=========================================================*/

package com.hanjin.apps.alps.esd.sce.common.util.vo;

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

public class RsltCdListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltCdListVO> models = new ArrayList<RsltCdListVO>();
	
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String glineSeq = null;
	/* Column Info */
	private String etc1 = null;
	/* Column Info */
	private String etc3 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String etc2 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String etc4 = null;
	/* Column Info */
	private String etc5 = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String qttnVerNo = null;
	/* Column Info */
	private String qttnNo = null;
	/* Column Info */
	private String prcCustTpCd = null;
	/* Column Info */
	private String nm = null;
	/* Column Info */
	private String cd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltCdListVO() {}

	public RsltCdListVO(String ibflag, String pagerows, String amdtSeq, String svcScpCd, String glineSeq, String prcCustTpCd, String etc1, String etc3, String etc2, String etc4, String etc5, String propNo, String cd, String nm, String creOfcCd, String qttnNo, String qttnVerNo) {
		this.amdtSeq = amdtSeq;
		this.svcScpCd = svcScpCd;
		this.glineSeq = glineSeq;
		this.etc1 = etc1;
		this.etc3 = etc3;
		this.pagerows = pagerows;
		this.etc2 = etc2;
		this.ibflag = ibflag;
		this.etc4 = etc4;
		this.etc5 = etc5;
		this.propNo = propNo;
		this.creOfcCd = creOfcCd;
		this.qttnVerNo = qttnVerNo;
		this.qttnNo = qttnNo;
		this.prcCustTpCd = prcCustTpCd;
		this.nm = nm;
		this.cd = cd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("gline_seq", getGlineSeq());
		this.hashColumns.put("etc1", getEtc1());
		this.hashColumns.put("etc3", getEtc3());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("etc2", getEtc2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("etc4", getEtc4());
		this.hashColumns.put("etc5", getEtc5());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("qttn_ver_no", getQttnVerNo());
		this.hashColumns.put("qttn_no", getQttnNo());
		this.hashColumns.put("prc_cust_tp_cd", getPrcCustTpCd());
		this.hashColumns.put("nm", getNm());
		this.hashColumns.put("cd", getCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("gline_seq", "glineSeq");
		this.hashFields.put("etc1", "etc1");
		this.hashFields.put("etc3", "etc3");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("etc2", "etc2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("etc4", "etc4");
		this.hashFields.put("etc5", "etc5");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("qttn_ver_no", "qttnVerNo");
		this.hashFields.put("qttn_no", "qttnNo");
		this.hashFields.put("prc_cust_tp_cd", "prcCustTpCd");
		this.hashFields.put("nm", "nm");
		this.hashFields.put("cd", "cd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return glineSeq
	 */
	public String getGlineSeq() {
		return this.glineSeq;
	}
	
	/**
	 * Column Info
	 * @return etc1
	 */
	public String getEtc1() {
		return this.etc1;
	}
	
	/**
	 * Column Info
	 * @return etc3
	 */
	public String getEtc3() {
		return this.etc3;
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
	 * @return etc2
	 */
	public String getEtc2() {
		return this.etc2;
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
	 * @return etc4
	 */
	public String getEtc4() {
		return this.etc4;
	}
	
	/**
	 * Column Info
	 * @return etc5
	 */
	public String getEtc5() {
		return this.etc5;
	}
	
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return qttnVerNo
	 */
	public String getQttnVerNo() {
		return this.qttnVerNo;
	}
	
	/**
	 * Column Info
	 * @return qttnNo
	 */
	public String getQttnNo() {
		return this.qttnNo;
	}
	
	/**
	 * Column Info
	 * @return prcCustTpCd
	 */
	public String getPrcCustTpCd() {
		return this.prcCustTpCd;
	}
	
	/**
	 * Column Info
	 * @return nm
	 */
	public String getNm() {
		return this.nm;
	}
	
	/**
	 * Column Info
	 * @return cd
	 */
	public String getCd() {
		return this.cd;
	}
	

	/**
	 * Column Info
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param glineSeq
	 */
	public void setGlineSeq(String glineSeq) {
		this.glineSeq = glineSeq;
	}
	
	/**
	 * Column Info
	 * @param etc1
	 */
	public void setEtc1(String etc1) {
		this.etc1 = etc1;
	}
	
	/**
	 * Column Info
	 * @param etc3
	 */
	public void setEtc3(String etc3) {
		this.etc3 = etc3;
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
	 * @param etc2
	 */
	public void setEtc2(String etc2) {
		this.etc2 = etc2;
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
	 * @param etc4
	 */
	public void setEtc4(String etc4) {
		this.etc4 = etc4;
	}
	
	/**
	 * Column Info
	 * @param etc5
	 */
	public void setEtc5(String etc5) {
		this.etc5 = etc5;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param qttnVerNo
	 */
	public void setQttnVerNo(String qttnVerNo) {
		this.qttnVerNo = qttnVerNo;
	}
	
	/**
	 * Column Info
	 * @param qttnNo
	 */
	public void setQttnNo(String qttnNo) {
		this.qttnNo = qttnNo;
	}
	
	/**
	 * Column Info
	 * @param prcCustTpCd
	 */
	public void setPrcCustTpCd(String prcCustTpCd) {
		this.prcCustTpCd = prcCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param nm
	 */
	public void setNm(String nm) {
		this.nm = nm;
	}
	
	/**
	 * Column Info
	 * @param cd
	 */
	public void setCd(String cd) {
		this.cd = cd;
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
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setGlineSeq(JSPUtil.getParameter(request, prefix + "gline_seq", ""));
		setEtc1(JSPUtil.getParameter(request, prefix + "etc1", ""));
		setEtc3(JSPUtil.getParameter(request, prefix + "etc3", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEtc2(JSPUtil.getParameter(request, prefix + "etc2", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEtc4(JSPUtil.getParameter(request, prefix + "etc4", ""));
		setEtc5(JSPUtil.getParameter(request, prefix + "etc5", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setQttnVerNo(JSPUtil.getParameter(request, prefix + "qttn_ver_no", ""));
		setQttnNo(JSPUtil.getParameter(request, prefix + "qttn_no", ""));
		setPrcCustTpCd(JSPUtil.getParameter(request, prefix + "prc_cust_tp_cd", ""));
		setNm(JSPUtil.getParameter(request, prefix + "nm", ""));
		setCd(JSPUtil.getParameter(request, prefix + "cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltCdListVO2[]
	 */
	public RsltCdListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltCdListVO2[]
	 */
	public RsltCdListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltCdListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] glineSeq = (JSPUtil.getParameter(request, prefix	+ "gline_seq", length));
			String[] etc1 = (JSPUtil.getParameter(request, prefix	+ "etc1", length));
			String[] etc3 = (JSPUtil.getParameter(request, prefix	+ "etc3", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] etc2 = (JSPUtil.getParameter(request, prefix	+ "etc2", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] etc4 = (JSPUtil.getParameter(request, prefix	+ "etc4", length));
			String[] etc5 = (JSPUtil.getParameter(request, prefix	+ "etc5", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] qttnVerNo = (JSPUtil.getParameter(request, prefix	+ "qttn_ver_no", length));
			String[] qttnNo = (JSPUtil.getParameter(request, prefix	+ "qttn_no", length));
			String[] prcCustTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_cust_tp_cd", length));
			String[] nm = (JSPUtil.getParameter(request, prefix	+ "nm", length));
			String[] cd = (JSPUtil.getParameter(request, prefix	+ "cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltCdListVO();
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (glineSeq[i] != null)
					model.setGlineSeq(glineSeq[i]);
				if (etc1[i] != null)
					model.setEtc1(etc1[i]);
				if (etc3[i] != null)
					model.setEtc3(etc3[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (etc2[i] != null)
					model.setEtc2(etc2[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (etc4[i] != null)
					model.setEtc4(etc4[i]);
				if (etc5[i] != null)
					model.setEtc5(etc5[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (qttnVerNo[i] != null)
					model.setQttnVerNo(qttnVerNo[i]);
				if (qttnNo[i] != null)
					model.setQttnNo(qttnNo[i]);
				if (prcCustTpCd[i] != null)
					model.setPrcCustTpCd(prcCustTpCd[i]);
				if (nm[i] != null)
					model.setNm(nm[i]);
				if (cd[i] != null)
					model.setCd(cd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltCdListVO2s();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltCdListVO2[]
	 */
	public RsltCdListVO[] getRsltCdListVO2s(){
		RsltCdListVO[] vos = (RsltCdListVO[])models.toArray(new RsltCdListVO[models.size()]);
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
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineSeq = this.glineSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etc1 = this.etc1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etc3 = this.etc3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etc2 = this.etc2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etc4 = this.etc4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etc5 = this.etc5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qttnVerNo = this.qttnVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qttnNo = this.qttnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCustTpCd = this.prcCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nm = this.nm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cd = this.cd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

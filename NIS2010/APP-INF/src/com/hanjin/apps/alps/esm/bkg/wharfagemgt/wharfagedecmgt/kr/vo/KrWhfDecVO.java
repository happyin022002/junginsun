/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KrWhfDecVO.java
*@FileTitle : KrWhfDecVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.30
*@LastModifier : 
*@LastVersion : 1.0
* 2010.11.30  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo;

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

public class KrWhfDecVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KrWhfDecVO> models = new ArrayList<KrWhfDecVO>();
	
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String whfNtcNoYr = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String whfNtcNoMon = null;
	/* Column Info */
	private String whfNtcNoSeq = null;
	/* Column Info */
	private String whfDeclNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KrWhfDecVO() {}

	public KrWhfDecVO(String ibflag, String pagerows, String whfDeclNo, String whfNtcNoYr, String whfNtcNoMon, String whfNtcNoSeq, String csrNo) {
		this.csrNo = csrNo;
		this.whfNtcNoYr = whfNtcNoYr;
		this.ibflag = ibflag;
		this.whfNtcNoMon = whfNtcNoMon;
		this.whfNtcNoSeq = whfNtcNoSeq;
		this.whfDeclNo = whfDeclNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("whf_ntc_no_yr", getWhfNtcNoYr());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("whf_ntc_no_mon", getWhfNtcNoMon());
		this.hashColumns.put("whf_ntc_no_seq", getWhfNtcNoSeq());
		this.hashColumns.put("whf_decl_no", getWhfDeclNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("whf_ntc_no_yr", "whfNtcNoYr");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("whf_ntc_no_mon", "whfNtcNoMon");
		this.hashFields.put("whf_ntc_no_seq", "whfNtcNoSeq");
		this.hashFields.put("whf_decl_no", "whfDeclNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return csrNo
	 */
	public String getCsrNo() {
		return this.csrNo;
	}
	
	/**
	 * Column Info
	 * @return whfNtcNoYr
	 */
	public String getWhfNtcNoYr() {
		return this.whfNtcNoYr;
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
	 * @return whfNtcNoMon
	 */
	public String getWhfNtcNoMon() {
		return this.whfNtcNoMon;
	}
	
	/**
	 * Column Info
	 * @return whfNtcNoSeq
	 */
	public String getWhfNtcNoSeq() {
		return this.whfNtcNoSeq;
	}
	
	/**
	 * Column Info
	 * @return whfDeclNo
	 */
	public String getWhfDeclNo() {
		return this.whfDeclNo;
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
	 * @param csrNo
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}
	
	/**
	 * Column Info
	 * @param whfNtcNoYr
	 */
	public void setWhfNtcNoYr(String whfNtcNoYr) {
		this.whfNtcNoYr = whfNtcNoYr;
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
	 * @param whfNtcNoMon
	 */
	public void setWhfNtcNoMon(String whfNtcNoMon) {
		this.whfNtcNoMon = whfNtcNoMon;
	}
	
	/**
	 * Column Info
	 * @param whfNtcNoSeq
	 */
	public void setWhfNtcNoSeq(String whfNtcNoSeq) {
		this.whfNtcNoSeq = whfNtcNoSeq;
	}
	
	/**
	 * Column Info
	 * @param whfDeclNo
	 */
	public void setWhfDeclNo(String whfDeclNo) {
		this.whfDeclNo = whfDeclNo;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
		setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
		setWhfNtcNoYr(JSPUtil.getParameter(request, prefix + "whf_ntc_no_yr", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setWhfNtcNoMon(JSPUtil.getParameter(request, prefix + "whf_ntc_no_mon", ""));
		setWhfNtcNoSeq(JSPUtil.getParameter(request, prefix + "whf_ntc_no_seq", ""));
		setWhfDeclNo(JSPUtil.getParameter(request, prefix + "whf_decl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KrWhfDecVO[]
	 */
	public KrWhfDecVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KrWhfDecVO[]
	 */
	public KrWhfDecVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KrWhfDecVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] whfNtcNoYr = (JSPUtil.getParameter(request, prefix	+ "whf_ntc_no_yr", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] whfNtcNoMon = (JSPUtil.getParameter(request, prefix	+ "whf_ntc_no_mon", length));
			String[] whfNtcNoSeq = (JSPUtil.getParameter(request, prefix	+ "whf_ntc_no_seq", length));
			String[] whfDeclNo = (JSPUtil.getParameter(request, prefix	+ "whf_decl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new KrWhfDecVO();
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (whfNtcNoYr[i] != null)
					model.setWhfNtcNoYr(whfNtcNoYr[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (whfNtcNoMon[i] != null)
					model.setWhfNtcNoMon(whfNtcNoMon[i]);
				if (whfNtcNoSeq[i] != null)
					model.setWhfNtcNoSeq(whfNtcNoSeq[i]);
				if (whfDeclNo[i] != null)
					model.setWhfDeclNo(whfDeclNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKrWhfDecVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KrWhfDecVO[]
	 */
	public KrWhfDecVO[] getKrWhfDecVOs(){
		KrWhfDecVO[] vos = (KrWhfDecVO[])models.toArray(new KrWhfDecVO[models.size()]);
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
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfNtcNoYr = this.whfNtcNoYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfNtcNoMon = this.whfNtcNoMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfNtcNoSeq = this.whfNtcNoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfDeclNo = this.whfDeclNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

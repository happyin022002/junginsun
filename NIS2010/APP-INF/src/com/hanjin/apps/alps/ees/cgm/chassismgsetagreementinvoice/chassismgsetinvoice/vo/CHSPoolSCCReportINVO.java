/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CHSPoolSCCReportINVO.java
*@FileTitle : CHSPoolSCCReportINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.18
*@LastModifier : 
*@LastVersion : 1.0
* 2014.02.18  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo;

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

public class CHSPoolSCCReportINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CHSPoolSCCReportINVO> models = new ArrayList<CHSPoolSCCReportINVO>();
	
	/* Column Info */
	private String toBseDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sccCd = null;
	/* Column Info */
	private String comboPool = null;
	/* Column Info */
	private String fromBseDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String searchVndrSeq = null;
	/* Column Info */
	private String searchYdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CHSPoolSCCReportINVO() {}

	public CHSPoolSCCReportINVO(String ibflag, String pagerows, String fromBseDt, String toBseDt, String comboPool, String sccCd, String searchVndrSeq, String searchYdCd) {
		this.toBseDt = toBseDt;
		this.ibflag = ibflag;
		this.sccCd = sccCd;
		this.comboPool = comboPool;
		this.fromBseDt = fromBseDt;
		this.pagerows = pagerows;
		this.searchVndrSeq = searchVndrSeq;
		this.searchYdCd = searchYdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_bse_dt", getToBseDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("scc_cd", getSccCd());
		this.hashColumns.put("combo_pool", getComboPool());
		this.hashColumns.put("from_bse_dt", getFromBseDt());
		this.hashColumns.put("search_vndr_seq", getSearchVndrSeq());
		this.hashColumns.put("search_yd_cd", getSearchYdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_bse_dt", "toBseDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("scc_cd", "sccCd");
		this.hashFields.put("combo_pool", "comboPool");
		this.hashFields.put("from_bse_dt", "fromBseDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("search_vndr_seq", "searchVndrSeq");
		this.hashFields.put("search_yd_cd", "searchYdCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toBseDt
	 */
	public String getToBseDt() {
		return this.toBseDt;
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
	 * @return sccCd
	 */
	public String getSccCd() {
		return this.sccCd;
	}
	
	/**
	 * Column Info
	 * @return comboPool
	 */
	public String getComboPool() {
		return this.comboPool;
	}
	
	/**
	 * Column Info
	 * @return fromBseDt
	 */
	public String getFromBseDt() {
		return this.fromBseDt;
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
	 * @param toBseDt
	 */
	public void setToBseDt(String toBseDt) {
		this.toBseDt = toBseDt;
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
	 * @param sccCd
	 */
	public void setSccCd(String sccCd) {
		this.sccCd = sccCd;
	}
	
	/**
	 * Column Info
	 * @param comboPool
	 */
	public void setComboPool(String comboPool) {
		this.comboPool = comboPool;
	}
	
	/**
	 * Column Info
	 * @param fromBseDt
	 */
	public void setFromBseDt(String fromBseDt) {
		this.fromBseDt = fromBseDt;
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
		setToBseDt(JSPUtil.getParameter(request, prefix + "to_bse_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSccCd(JSPUtil.getParameter(request, prefix + "scc_cd", ""));
		setComboPool(JSPUtil.getParameter(request, prefix + "combo_pool", ""));
		setFromBseDt(JSPUtil.getParameter(request, prefix + "from_bse_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSearchVndrSeq(JSPUtil.getParameter(request, prefix + "search_vndr_seq", ""));
		setSearchYdCd(JSPUtil.getParameter(request, prefix + "search_yd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CHSPoolSCCReportINVO[]
	 */
	public CHSPoolSCCReportINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CHSPoolSCCReportINVO[]
	 */
	public CHSPoolSCCReportINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CHSPoolSCCReportINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toBseDt = (JSPUtil.getParameter(request, prefix	+ "to_bse_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sccCd = (JSPUtil.getParameter(request, prefix	+ "scc_cd", length));
			String[] comboPool = (JSPUtil.getParameter(request, prefix	+ "combo_pool", length));
			String[] fromBseDt = (JSPUtil.getParameter(request, prefix	+ "from_bse_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] searchVndrSeq = (JSPUtil.getParameter(request, prefix	+ "search_vndr_seq", length));
			String[] searchYdCd = (JSPUtil.getParameter(request, prefix	+ "search_yd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CHSPoolSCCReportINVO();
				if (toBseDt[i] != null)
					model.setToBseDt(toBseDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sccCd[i] != null)
					model.setSccCd(sccCd[i]);
				if (comboPool[i] != null)
					model.setComboPool(comboPool[i]);
				if (fromBseDt[i] != null)
					model.setFromBseDt(fromBseDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (searchVndrSeq[i] != null)
					model.setSearchVndrSeq(searchVndrSeq[i]);
				if (searchYdCd[i] != null)
					model.setSearchYdCd(searchYdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCHSPoolSCCReportINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CHSPoolSCCReportINVO[]
	 */
	public CHSPoolSCCReportINVO[] getCHSPoolSCCReportINVOs(){
		CHSPoolSCCReportINVO[] vos = (CHSPoolSCCReportINVO[])models.toArray(new CHSPoolSCCReportINVO[models.size()]);
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
		this.toBseDt = this.toBseDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccCd = this.sccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comboPool = this.comboPool .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromBseDt = this.fromBseDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchVndrSeq = this.searchVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchYdCd = this.searchYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

	public String getSearchVndrSeq() {
		return searchVndrSeq;
	}

	public void setSearchVndrSeq(String searchVndrSeq) {
		this.searchVndrSeq = searchVndrSeq;
	}

	public String getSearchYdCd() {
		return searchYdCd;
	}

	public void setSearchYdCd(String searchYdCd) {
		this.searchYdCd = searchYdCd;
	}
}

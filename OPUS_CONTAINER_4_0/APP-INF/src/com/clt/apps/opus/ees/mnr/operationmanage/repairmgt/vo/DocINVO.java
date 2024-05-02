/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DocINVO.java
*@FileTitle : DocINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.22
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2010.01.22 함형석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 함형석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DocINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DocINVO> models = new ArrayList<DocINVO>();
	
	/* Column Info */
	private String mnrOrdOfcCtyCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mnrOrdSeq = null;
	/* Column Info */
	private String trsmModCd = null;
	/* Column Info */
	private String sel = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public DocINVO() {}

	public DocINVO(String ibflag, String pagerows, String mnrOrdSeq, String sel, String trsmModCd, String mnrOrdOfcCtyCd) {
		this.mnrOrdOfcCtyCd = mnrOrdOfcCtyCd;
		this.ibflag = ibflag;
		this.mnrOrdSeq = mnrOrdSeq;
		this.trsmModCd = trsmModCd;
		this.sel = sel;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mnr_ord_ofc_cty_cd", getMnrOrdOfcCtyCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mnr_ord_seq", getMnrOrdSeq());
		this.hashColumns.put("trsm_mod_cd", getTrsmModCd());
		this.hashColumns.put("sel", getSel());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mnr_ord_ofc_cty_cd", "mnrOrdOfcCtyCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mnr_ord_seq", "mnrOrdSeq");
		this.hashFields.put("trsm_mod_cd", "trsmModCd");
		this.hashFields.put("sel", "sel");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mnrOrdOfcCtyCd
	 */
	public String getMnrOrdOfcCtyCd() {
		return this.mnrOrdOfcCtyCd;
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
	 * @return mnrOrdSeq
	 */
	public String getMnrOrdSeq() {
		return this.mnrOrdSeq;
	}
	
	/**
	 * Column Info
	 * @return trsmModCd
	 */
	public String getTrsmModCd() {
		return this.trsmModCd;
	}
	
	/**
	 * Column Info
	 * @return sel
	 */
	public String getSel() {
		return this.sel;
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
	 * @param mnrOrdOfcCtyCd
	 */
	public void setMnrOrdOfcCtyCd(String mnrOrdOfcCtyCd) {
		this.mnrOrdOfcCtyCd = mnrOrdOfcCtyCd;
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
	 * @param mnrOrdSeq
	 */
	public void setMnrOrdSeq(String mnrOrdSeq) {
		this.mnrOrdSeq = mnrOrdSeq;
	}
	
	/**
	 * Column Info
	 * @param trsmModCd
	 */
	public void setTrsmModCd(String trsmModCd) {
		this.trsmModCd = trsmModCd;
	}
	
	/**
	 * Column Info
	 * @param sel
	 */
	public void setSel(String sel) {
		this.sel = sel;
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
		setMnrOrdOfcCtyCd(JSPUtil.getParameter(request, prefix + "mnr_ord_ofc_cty_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMnrOrdSeq(JSPUtil.getParameter(request, prefix + "mnr_ord_seq", ""));
		setTrsmModCd(JSPUtil.getParameter(request, prefix + "trsm_mod_cd", ""));
		setSel(JSPUtil.getParameter(request, prefix + "sel", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DocINVO[]
	 */
	public DocINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DocINVO[]
	 */
	public DocINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DocINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mnrOrdOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "mnr_ord_ofc_cty_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mnrOrdSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_ord_seq", length));
			String[] trsmModCd = (JSPUtil.getParameter(request, prefix	+ "trsm_mod_cd", length));
			String[] sel = (JSPUtil.getParameter(request, prefix	+ "sel", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new DocINVO();
				if (mnrOrdOfcCtyCd[i] != null)
					model.setMnrOrdOfcCtyCd(mnrOrdOfcCtyCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mnrOrdSeq[i] != null)
					model.setMnrOrdSeq(mnrOrdSeq[i]);
				if (trsmModCd[i] != null)
					model.setTrsmModCd(trsmModCd[i]);
				if (sel[i] != null)
					model.setSel(sel[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDocINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DocINVO[]
	 */
	public DocINVO[] getDocINVOs(){
		DocINVO[] vos = (DocINVO[])models.toArray(new DocINVO[models.size()]);
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
		this.mnrOrdOfcCtyCd = this.mnrOrdOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrOrdSeq = this.mnrOrdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmModCd = this.trsmModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sel = this.sel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KrWhfDecCheckSendDtVO.java
*@FileTitle : KrWhfDecCheckSendDtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.16
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.16  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo;

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

public class KrWhfDecCheckSendDtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KrWhfDecCheckSendDtVO> models = new ArrayList<KrWhfDecCheckSendDtVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String emptyChk = null;
	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String dtChk = null;
	/* Column Info */
	private String frIndt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KrWhfDecCheckSendDtVO() {}

	public KrWhfDecCheckSendDtVO(String ibflag, String pagerows, String dtChk, String etaDt, String frIndt, String emptyChk) {
		this.ibflag = ibflag;
		this.emptyChk = emptyChk;
		this.etaDt = etaDt;
		this.dtChk = dtChk;
		this.frIndt = frIndt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("empty_chk", getEmptyChk());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("dt_chk", getDtChk());
		this.hashColumns.put("fr_indt", getFrIndt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("empty_chk", "emptyChk");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("dt_chk", "dtChk");
		this.hashFields.put("fr_indt", "frIndt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return emptyChk
	 */
	public String getEmptyChk() {
		return this.emptyChk;
	}
	
	/**
	 * Column Info
	 * @return etaDt
	 */
	public String getEtaDt() {
		return this.etaDt;
	}
	
	/**
	 * Column Info
	 * @return dtChk
	 */
	public String getDtChk() {
		return this.dtChk;
	}
	
	/**
	 * Column Info
	 * @return frIndt
	 */
	public String getFrIndt() {
		return this.frIndt;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @param emptyChk
	 */
	public void setEmptyChk(String emptyChk) {
		this.emptyChk = emptyChk;
	}
	
	/**
	 * Column Info
	 * @param etaDt
	 */
	public void setEtaDt(String etaDt) {
		this.etaDt = etaDt;
	}
	
	/**
	 * Column Info
	 * @param dtChk
	 */
	public void setDtChk(String dtChk) {
		this.dtChk = dtChk;
	}
	
	/**
	 * Column Info
	 * @param frIndt
	 */
	public void setFrIndt(String frIndt) {
		this.frIndt = frIndt;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEmptyChk(JSPUtil.getParameter(request, prefix + "empty_chk", ""));
		setEtaDt(JSPUtil.getParameter(request, prefix + "eta_dt", ""));
		setDtChk(JSPUtil.getParameter(request, prefix + "dt_chk", ""));
		setFrIndt(JSPUtil.getParameter(request, prefix + "fr_indt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KrWhfDecCheckSendDtVO[]
	 */
	public KrWhfDecCheckSendDtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KrWhfDecCheckSendDtVO[]
	 */
	public KrWhfDecCheckSendDtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KrWhfDecCheckSendDtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] emptyChk = (JSPUtil.getParameter(request, prefix	+ "empty_chk", length));
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] dtChk = (JSPUtil.getParameter(request, prefix	+ "dt_chk", length));
			String[] frIndt = (JSPUtil.getParameter(request, prefix	+ "fr_indt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new KrWhfDecCheckSendDtVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (emptyChk[i] != null)
					model.setEmptyChk(emptyChk[i]);
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (dtChk[i] != null)
					model.setDtChk(dtChk[i]);
				if (frIndt[i] != null)
					model.setFrIndt(frIndt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKrWhfDecCheckSendDtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KrWhfDecCheckSendDtVO[]
	 */
	public KrWhfDecCheckSendDtVO[] getKrWhfDecCheckSendDtVOs(){
		KrWhfDecCheckSendDtVO[] vos = (KrWhfDecCheckSendDtVO[])models.toArray(new KrWhfDecCheckSendDtVO[models.size()]);
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
		this.emptyChk = this.emptyChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtChk = this.dtChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frIndt = this.frIndt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

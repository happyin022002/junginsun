/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GetEDICgoInfoVO.java
*@FileTitle : GetEDICgoInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : 전병석
*@LastVersion : 1.0
* 2009.10.08 전병석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.edi315send.vo;

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
 * @author 전병석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class GetEDICgoInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GetEDICgoInfoVO> models = new ArrayList<GetEDICgoInfoVO>();
	
	/* Column Info */
	private String ediCntrSndTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ediVslTpCd = null;
	/* Column Info */
	private String ediEventCd = null;
	/* Column Info */
	private String ediSndItvalHr = null;
	/* Column Info */
	private String custEdiStsCd = null;
	/* Column Info */
	private String ediAutoSndFlg = null;
	/* Column Info */
	private String ediSndFlg = null;
	/* Column Info */
	private String ediStndStsCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public GetEDICgoInfoVO() {}

	public GetEDICgoInfoVO(String ibflag, String pagerows, String ediStndStsCd, String ediVslTpCd, String ediEventCd, String ediSndFlg, String custEdiStsCd, String ediSndItvalHr, String ediCntrSndTpCd, String ediAutoSndFlg) {
		this.ediCntrSndTpCd = ediCntrSndTpCd;
		this.ibflag = ibflag;
		this.ediVslTpCd = ediVslTpCd;
		this.ediEventCd = ediEventCd;
		this.ediSndItvalHr = ediSndItvalHr;
		this.custEdiStsCd = custEdiStsCd;
		this.ediAutoSndFlg = ediAutoSndFlg;
		this.ediSndFlg = ediSndFlg;
		this.ediStndStsCd = ediStndStsCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("edi_cntr_snd_tp_cd", getEdiCntrSndTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("edi_vsl_tp_cd", getEdiVslTpCd());
		this.hashColumns.put("edi_event_cd", getEdiEventCd());
		this.hashColumns.put("edi_snd_itval_hr", getEdiSndItvalHr());
		this.hashColumns.put("cust_edi_sts_cd", getCustEdiStsCd());
		this.hashColumns.put("edi_auto_snd_flg", getEdiAutoSndFlg());
		this.hashColumns.put("edi_snd_flg", getEdiSndFlg());
		this.hashColumns.put("edi_stnd_sts_cd", getEdiStndStsCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("edi_cntr_snd_tp_cd", "ediCntrSndTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("edi_vsl_tp_cd", "ediVslTpCd");
		this.hashFields.put("edi_event_cd", "ediEventCd");
		this.hashFields.put("edi_snd_itval_hr", "ediSndItvalHr");
		this.hashFields.put("cust_edi_sts_cd", "custEdiStsCd");
		this.hashFields.put("edi_auto_snd_flg", "ediAutoSndFlg");
		this.hashFields.put("edi_snd_flg", "ediSndFlg");
		this.hashFields.put("edi_stnd_sts_cd", "ediStndStsCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ediCntrSndTpCd
	 */
	public String getEdiCntrSndTpCd() {
		return this.ediCntrSndTpCd;
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
	 * @return ediVslTpCd
	 */
	public String getEdiVslTpCd() {
		return this.ediVslTpCd;
	}
	
	/**
	 * Column Info
	 * @return ediEventCd
	 */
	public String getEdiEventCd() {
		return this.ediEventCd;
	}
	
	/**
	 * Column Info
	 * @return ediSndItvalHr
	 */
	public String getEdiSndItvalHr() {
		return this.ediSndItvalHr;
	}
	
	/**
	 * Column Info
	 * @return custEdiStsCd
	 */
	public String getCustEdiStsCd() {
		return this.custEdiStsCd;
	}
	
	/**
	 * Column Info
	 * @return ediAutoSndFlg
	 */
	public String getEdiAutoSndFlg() {
		return this.ediAutoSndFlg;
	}
	
	/**
	 * Column Info
	 * @return ediSndFlg
	 */
	public String getEdiSndFlg() {
		return this.ediSndFlg;
	}
	
	/**
	 * Column Info
	 * @return ediStndStsCd
	 */
	public String getEdiStndStsCd() {
		return this.ediStndStsCd;
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
	 * @param ediCntrSndTpCd
	 */
	public void setEdiCntrSndTpCd(String ediCntrSndTpCd) {
		this.ediCntrSndTpCd = ediCntrSndTpCd;
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
	 * @param ediVslTpCd
	 */
	public void setEdiVslTpCd(String ediVslTpCd) {
		this.ediVslTpCd = ediVslTpCd;
	}
	
	/**
	 * Column Info
	 * @param ediEventCd
	 */
	public void setEdiEventCd(String ediEventCd) {
		this.ediEventCd = ediEventCd;
	}
	
	/**
	 * Column Info
	 * @param ediSndItvalHr
	 */
	public void setEdiSndItvalHr(String ediSndItvalHr) {
		this.ediSndItvalHr = ediSndItvalHr;
	}
	
	/**
	 * Column Info
	 * @param custEdiStsCd
	 */
	public void setCustEdiStsCd(String custEdiStsCd) {
		this.custEdiStsCd = custEdiStsCd;
	}
	
	/**
	 * Column Info
	 * @param ediAutoSndFlg
	 */
	public void setEdiAutoSndFlg(String ediAutoSndFlg) {
		this.ediAutoSndFlg = ediAutoSndFlg;
	}
	
	/**
	 * Column Info
	 * @param ediSndFlg
	 */
	public void setEdiSndFlg(String ediSndFlg) {
		this.ediSndFlg = ediSndFlg;
	}
	
	/**
	 * Column Info
	 * @param ediStndStsCd
	 */
	public void setEdiStndStsCd(String ediStndStsCd) {
		this.ediStndStsCd = ediStndStsCd;
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
		setEdiCntrSndTpCd(JSPUtil.getParameter(request, "edi_cntr_snd_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEdiVslTpCd(JSPUtil.getParameter(request, "edi_vsl_tp_cd", ""));
		setEdiEventCd(JSPUtil.getParameter(request, "edi_event_cd", ""));
		setEdiSndItvalHr(JSPUtil.getParameter(request, "edi_snd_itval_hr", ""));
		setCustEdiStsCd(JSPUtil.getParameter(request, "cust_edi_sts_cd", ""));
		setEdiAutoSndFlg(JSPUtil.getParameter(request, "edi_auto_snd_flg", ""));
		setEdiSndFlg(JSPUtil.getParameter(request, "edi_snd_flg", ""));
		setEdiStndStsCd(JSPUtil.getParameter(request, "edi_stnd_sts_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GetEDICgoInfoVO[]
	 */
	public GetEDICgoInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GetEDICgoInfoVO[]
	 */
	public GetEDICgoInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GetEDICgoInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ediCntrSndTpCd = (JSPUtil.getParameter(request, prefix	+ "edi_cntr_snd_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ediVslTpCd = (JSPUtil.getParameter(request, prefix	+ "edi_vsl_tp_cd", length));
			String[] ediEventCd = (JSPUtil.getParameter(request, prefix	+ "edi_event_cd", length));
			String[] ediSndItvalHr = (JSPUtil.getParameter(request, prefix	+ "edi_snd_itval_hr", length));
			String[] custEdiStsCd = (JSPUtil.getParameter(request, prefix	+ "cust_edi_sts_cd", length));
			String[] ediAutoSndFlg = (JSPUtil.getParameter(request, prefix	+ "edi_auto_snd_flg", length));
			String[] ediSndFlg = (JSPUtil.getParameter(request, prefix	+ "edi_snd_flg", length));
			String[] ediStndStsCd = (JSPUtil.getParameter(request, prefix	+ "edi_stnd_sts_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new GetEDICgoInfoVO();
				if (ediCntrSndTpCd[i] != null)
					model.setEdiCntrSndTpCd(ediCntrSndTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ediVslTpCd[i] != null)
					model.setEdiVslTpCd(ediVslTpCd[i]);
				if (ediEventCd[i] != null)
					model.setEdiEventCd(ediEventCd[i]);
				if (ediSndItvalHr[i] != null)
					model.setEdiSndItvalHr(ediSndItvalHr[i]);
				if (custEdiStsCd[i] != null)
					model.setCustEdiStsCd(custEdiStsCd[i]);
				if (ediAutoSndFlg[i] != null)
					model.setEdiAutoSndFlg(ediAutoSndFlg[i]);
				if (ediSndFlg[i] != null)
					model.setEdiSndFlg(ediSndFlg[i]);
				if (ediStndStsCd[i] != null)
					model.setEdiStndStsCd(ediStndStsCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGetEDICgoInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GetEDICgoInfoVO[]
	 */
	public GetEDICgoInfoVO[] getGetEDICgoInfoVOs(){
		GetEDICgoInfoVO[] vos = (GetEDICgoInfoVO[])models.toArray(new GetEDICgoInfoVO[models.size()]);
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
		this.ediCntrSndTpCd = this.ediCntrSndTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediVslTpCd = this.ediVslTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediEventCd = this.ediEventCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndItvalHr = this.ediSndItvalHr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custEdiStsCd = this.custEdiStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediAutoSndFlg = this.ediAutoSndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndFlg = this.ediSndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediStndStsCd = this.ediStndStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

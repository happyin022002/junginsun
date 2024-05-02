/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MiscLimitCondVO.java
*@FileTitle : MiscLimitCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.25
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.25  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo;

import java.lang.reflect.Field;
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MiscLimitCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MiscLimitCondVO> models = new ArrayList<MiscLimitCondVO>();
	
	/* Column Info */
	private String miscOfcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String miscTpCd = null;
	/* Column Info */
	private String miscXchRtDt = null;
	/* Column Info */
	private String miscAmt = null;
	/* Column Info */
	private String miscXchRt = null;
	/* Column Info */
	private String miscCurrCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public MiscLimitCondVO() {}

	public MiscLimitCondVO(String ibflag, String pagerows, String miscOfcCd, String miscXchRtDt, String miscTpCd, String miscCurrCd, String miscXchRt, String miscAmt) {
		this.miscOfcCd = miscOfcCd;
		this.ibflag = ibflag;
		this.miscTpCd = miscTpCd;
		this.miscXchRtDt = miscXchRtDt;
		this.miscAmt = miscAmt;
		this.miscXchRt = miscXchRt;
		this.miscCurrCd = miscCurrCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("misc_ofc_cd", getMiscOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("misc_tp_cd", getMiscTpCd());
		this.hashColumns.put("misc_xch_rt_dt", getMiscXchRtDt());
		this.hashColumns.put("misc_amt", getMiscAmt());
		this.hashColumns.put("misc_xch_rt", getMiscXchRt());
		this.hashColumns.put("misc_curr_cd", getMiscCurrCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("misc_ofc_cd", "miscOfcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("misc_tp_cd", "miscTpCd");
		this.hashFields.put("misc_xch_rt_dt", "miscXchRtDt");
		this.hashFields.put("misc_amt", "miscAmt");
		this.hashFields.put("misc_xch_rt", "miscXchRt");
		this.hashFields.put("misc_curr_cd", "miscCurrCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return miscOfcCd
	 */
	public String getMiscOfcCd() {
		return this.miscOfcCd;
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
	 * @return miscTpCd
	 */
	public String getMiscTpCd() {
		return this.miscTpCd;
	}
	
	/**
	 * Column Info
	 * @return miscXchRtDt
	 */
	public String getMiscXchRtDt() {
		return this.miscXchRtDt;
	}
	
	/**
	 * Column Info
	 * @return miscAmt
	 */
	public String getMiscAmt() {
		return this.miscAmt;
	}
	
	/**
	 * Column Info
	 * @return miscXchRt
	 */
	public String getMiscXchRt() {
		return this.miscXchRt;
	}
	
	/**
	 * Column Info
	 * @return miscCurrCd
	 */
	public String getMiscCurrCd() {
		return this.miscCurrCd;
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
	 * @param miscOfcCd
	 */
	public void setMiscOfcCd(String miscOfcCd) {
		this.miscOfcCd = miscOfcCd;
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
	 * @param miscTpCd
	 */
	public void setMiscTpCd(String miscTpCd) {
		this.miscTpCd = miscTpCd;
	}
	
	/**
	 * Column Info
	 * @param miscXchRtDt
	 */
	public void setMiscXchRtDt(String miscXchRtDt) {
		this.miscXchRtDt = miscXchRtDt;
	}
	
	/**
	 * Column Info
	 * @param miscAmt
	 */
	public void setMiscAmt(String miscAmt) {
		this.miscAmt = miscAmt;
	}
	
	/**
	 * Column Info
	 * @param miscXchRt
	 */
	public void setMiscXchRt(String miscXchRt) {
		this.miscXchRt = miscXchRt;
	}
	
	/**
	 * Column Info
	 * @param miscCurrCd
	 */
	public void setMiscCurrCd(String miscCurrCd) {
		this.miscCurrCd = miscCurrCd;
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
		setMiscOfcCd(JSPUtil.getParameter(request, prefix + "misc_ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMiscTpCd(JSPUtil.getParameter(request, prefix + "misc_tp_cd", ""));
		setMiscXchRtDt(JSPUtil.getParameter(request, prefix + "misc_xch_rt_dt", ""));
		setMiscAmt(JSPUtil.getParameter(request, prefix + "misc_amt", ""));
		setMiscXchRt(JSPUtil.getParameter(request, prefix + "misc_xch_rt", ""));
		setMiscCurrCd(JSPUtil.getParameter(request, prefix + "misc_curr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MiscLimitCondVO[]
	 */
	public MiscLimitCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MiscLimitCondVO[]
	 */
	public MiscLimitCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MiscLimitCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] miscOfcCd = (JSPUtil.getParameter(request, prefix	+ "misc_ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] miscTpCd = (JSPUtil.getParameter(request, prefix	+ "misc_tp_cd", length));
			String[] miscXchRtDt = (JSPUtil.getParameter(request, prefix	+ "misc_xch_rt_dt", length));
			String[] miscAmt = (JSPUtil.getParameter(request, prefix	+ "misc_amt", length));
			String[] miscXchRt = (JSPUtil.getParameter(request, prefix	+ "misc_xch_rt", length));
			String[] miscCurrCd = (JSPUtil.getParameter(request, prefix	+ "misc_curr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new MiscLimitCondVO();
				if (miscOfcCd[i] != null)
					model.setMiscOfcCd(miscOfcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (miscTpCd[i] != null)
					model.setMiscTpCd(miscTpCd[i]);
				if (miscXchRtDt[i] != null)
					model.setMiscXchRtDt(miscXchRtDt[i]);
				if (miscAmt[i] != null)
					model.setMiscAmt(miscAmt[i]);
				if (miscXchRt[i] != null)
					model.setMiscXchRt(miscXchRt[i]);
				if (miscCurrCd[i] != null)
					model.setMiscCurrCd(miscCurrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMiscLimitCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MiscLimitCondVO[]
	 */
	public MiscLimitCondVO[] getMiscLimitCondVOs(){
		MiscLimitCondVO[] vos = (MiscLimitCondVO[])models.toArray(new MiscLimitCondVO[models.size()]);
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
		this.miscOfcCd = this.miscOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.miscTpCd = this.miscTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.miscXchRtDt = this.miscXchRtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.miscAmt = this.miscAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.miscXchRt = this.miscXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.miscCurrCd = this.miscCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

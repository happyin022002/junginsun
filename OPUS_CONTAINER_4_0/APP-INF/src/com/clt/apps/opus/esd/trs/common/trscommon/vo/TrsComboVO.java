/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TrsComboVO.java
*@FileTitle : TrsComboVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.20
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2011.10.20 황효근 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.trs.common.trscommon.vo;

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
 * @author 황효근
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TrsComboVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TrsComboVO> models = new ArrayList<TrsComboVO>();
	
	/* Column Info */
	private String cntrVndrSvcCd = null;
	/* Column Info */
	private String vndrCntCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vndrCostCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TrsComboVO() {}

	public TrsComboVO(String ibflag, String pagerows, String cntrVndrSvcCd, String vndrCostCd, String vndrCntCd) {
		this.cntrVndrSvcCd = cntrVndrSvcCd;
		this.vndrCntCd = vndrCntCd;
		this.ibflag = ibflag;
		this.vndrCostCd = vndrCostCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_vndr_svc_cd", getCntrVndrSvcCd());
		this.hashColumns.put("vndr_cnt_cd", getVndrCntCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vndr_cost_cd", getVndrCostCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_vndr_svc_cd", "cntrVndrSvcCd");
		this.hashFields.put("vndr_cnt_cd", "vndrCntCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vndr_cost_cd", "vndrCostCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntrVndrSvcCd
	 */
	public String getCntrVndrSvcCd() {
		return this.cntrVndrSvcCd;
	}
	
	/**
	 * Column Info
	 * @return vndrCntCd
	 */
	public String getVndrCntCd() {
		return this.vndrCntCd;
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
	 * @return vndrCostCd
	 */
	public String getVndrCostCd() {
		return this.vndrCostCd;
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
	 * @param cntrVndrSvcCd
	 */
	public void setCntrVndrSvcCd(String cntrVndrSvcCd) {
		this.cntrVndrSvcCd = cntrVndrSvcCd;
	}
	
	/**
	 * Column Info
	 * @param vndrCntCd
	 */
	public void setVndrCntCd(String vndrCntCd) {
		this.vndrCntCd = vndrCntCd;
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
	 * @param vndrCostCd
	 */
	public void setVndrCostCd(String vndrCostCd) {
		this.vndrCostCd = vndrCostCd;
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
		setCntrVndrSvcCd(JSPUtil.getParameter(request, prefix + "cntr_vndr_svc_cd", ""));
		setVndrCntCd(JSPUtil.getParameter(request, prefix + "vndr_cnt_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVndrCostCd(JSPUtil.getParameter(request, prefix + "vndr_cost_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TrsComboVO[]
	 */
	public TrsComboVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TrsComboVO[]
	 */
	public TrsComboVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TrsComboVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrVndrSvcCd = (JSPUtil.getParameter(request, prefix	+ "cntr_vndr_svc_cd", length));
			String[] vndrCntCd = (JSPUtil.getParameter(request, prefix	+ "vndr_cnt_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vndrCostCd = (JSPUtil.getParameter(request, prefix	+ "vndr_cost_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new TrsComboVO();
				if (cntrVndrSvcCd[i] != null)
					model.setCntrVndrSvcCd(cntrVndrSvcCd[i]);
				if (vndrCntCd[i] != null)
					model.setVndrCntCd(vndrCntCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vndrCostCd[i] != null)
					model.setVndrCostCd(vndrCostCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTrsComboVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TrsComboVO[]
	 */
	public TrsComboVO[] getTrsComboVOs(){
		TrsComboVO[] vos = (TrsComboVO[])models.toArray(new TrsComboVO[models.size()]);
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
		this.cntrVndrSvcCd = this.cntrVndrSvcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCntCd = this.vndrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCostCd = this.vndrCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

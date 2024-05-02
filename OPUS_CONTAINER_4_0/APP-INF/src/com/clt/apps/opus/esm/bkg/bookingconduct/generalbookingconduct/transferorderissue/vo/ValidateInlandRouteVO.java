/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ValidateInlandRouteVO.java
*@FileTitle : ValidateInlandRouteVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.02
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2009.12.02 류대영 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo;

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
 * @author 류대영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ValidateInlandRouteVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ValidateInlandRouteVO> models = new ArrayList<ValidateInlandRouteVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fullPkupYdCd = null;
	/* Column Info */
	private String routDestNodCd = null;
	/* Column Info */
	private String routOrgNodCd = null;
	/* Column Info */
	private String fullRtnYdCd = null;
	/* Column Info */
	private String trspModCd = null;
	/* Column Info */
	private String routSeq = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ValidateInlandRouteVO() {}

	public ValidateInlandRouteVO(String ibflag, String pagerows, String routOrgNodCd, String routDestNodCd, String routSeq, String fullRtnYdCd, String fullPkupYdCd, String trspModCd) {
		this.ibflag = ibflag;
		this.fullPkupYdCd = fullPkupYdCd;
		this.routDestNodCd = routDestNodCd;
		this.routOrgNodCd = routOrgNodCd;
		this.fullRtnYdCd = fullRtnYdCd;
		this.trspModCd = trspModCd;
		this.routSeq = routSeq;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("full_pkup_yd_cd", getFullPkupYdCd());
		this.hashColumns.put("rout_dest_nod_cd", getRoutDestNodCd());
		this.hashColumns.put("rout_org_nod_cd", getRoutOrgNodCd());
		this.hashColumns.put("full_rtn_yd_cd", getFullRtnYdCd());
		this.hashColumns.put("trsp_mod_cd", getTrspModCd());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("full_pkup_yd_cd", "fullPkupYdCd");
		this.hashFields.put("rout_dest_nod_cd", "routDestNodCd");
		this.hashFields.put("rout_org_nod_cd", "routOrgNodCd");
		this.hashFields.put("full_rtn_yd_cd", "fullRtnYdCd");
		this.hashFields.put("trsp_mod_cd", "trspModCd");
		this.hashFields.put("rout_seq", "routSeq");
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
	 * @return fullPkupYdCd
	 */
	public String getFullPkupYdCd() {
		return this.fullPkupYdCd;
	}
	
	/**
	 * Column Info
	 * @return routDestNodCd
	 */
	public String getRoutDestNodCd() {
		return this.routDestNodCd;
	}
	
	/**
	 * Column Info
	 * @return routOrgNodCd
	 */
	public String getRoutOrgNodCd() {
		return this.routOrgNodCd;
	}
	
	/**
	 * Column Info
	 * @return fullRtnYdCd
	 */
	public String getFullRtnYdCd() {
		return this.fullRtnYdCd;
	}
	
	/**
	 * Column Info
	 * @return trspModCd
	 */
	public String getTrspModCd() {
		return this.trspModCd;
	}
	
	/**
	 * Column Info
	 * @return routSeq
	 */
	public String getRoutSeq() {
		return this.routSeq;
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
	 * @param fullPkupYdCd
	 */
	public void setFullPkupYdCd(String fullPkupYdCd) {
		this.fullPkupYdCd = fullPkupYdCd;
	}
	
	/**
	 * Column Info
	 * @param routDestNodCd
	 */
	public void setRoutDestNodCd(String routDestNodCd) {
		this.routDestNodCd = routDestNodCd;
	}
	
	/**
	 * Column Info
	 * @param routOrgNodCd
	 */
	public void setRoutOrgNodCd(String routOrgNodCd) {
		this.routOrgNodCd = routOrgNodCd;
	}
	
	/**
	 * Column Info
	 * @param fullRtnYdCd
	 */
	public void setFullRtnYdCd(String fullRtnYdCd) {
		this.fullRtnYdCd = fullRtnYdCd;
	}
	
	/**
	 * Column Info
	 * @param trspModCd
	 */
	public void setTrspModCd(String trspModCd) {
		this.trspModCd = trspModCd;
	}
	
	/**
	 * Column Info
	 * @param routSeq
	 */
	public void setRoutSeq(String routSeq) {
		this.routSeq = routSeq;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFullPkupYdCd(JSPUtil.getParameter(request, "full_pkup_yd_cd", ""));
		setRoutDestNodCd(JSPUtil.getParameter(request, "rout_dest_nod_cd", ""));
		setRoutOrgNodCd(JSPUtil.getParameter(request, "rout_org_nod_cd", ""));
		setFullRtnYdCd(JSPUtil.getParameter(request, "full_rtn_yd_cd", ""));
		setTrspModCd(JSPUtil.getParameter(request, "trsp_mod_cd", ""));
		setRoutSeq(JSPUtil.getParameter(request, "rout_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ValidateInlandRouteVO[]
	 */
	public ValidateInlandRouteVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ValidateInlandRouteVO[]
	 */
	public ValidateInlandRouteVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ValidateInlandRouteVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fullPkupYdCd = (JSPUtil.getParameter(request, prefix	+ "full_pkup_yd_cd", length));
			String[] routDestNodCd = (JSPUtil.getParameter(request, prefix	+ "rout_dest_nod_cd", length));
			String[] routOrgNodCd = (JSPUtil.getParameter(request, prefix	+ "rout_org_nod_cd", length));
			String[] fullRtnYdCd = (JSPUtil.getParameter(request, prefix	+ "full_rtn_yd_cd", length));
			String[] trspModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_mod_cd", length));
			String[] routSeq = (JSPUtil.getParameter(request, prefix	+ "rout_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ValidateInlandRouteVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fullPkupYdCd[i] != null)
					model.setFullPkupYdCd(fullPkupYdCd[i]);
				if (routDestNodCd[i] != null)
					model.setRoutDestNodCd(routDestNodCd[i]);
				if (routOrgNodCd[i] != null)
					model.setRoutOrgNodCd(routOrgNodCd[i]);
				if (fullRtnYdCd[i] != null)
					model.setFullRtnYdCd(fullRtnYdCd[i]);
				if (trspModCd[i] != null)
					model.setTrspModCd(trspModCd[i]);
				if (routSeq[i] != null)
					model.setRoutSeq(routSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getValidateInlandRouteVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ValidateInlandRouteVO[]
	 */
	public ValidateInlandRouteVO[] getValidateInlandRouteVOs(){
		ValidateInlandRouteVO[] vos = (ValidateInlandRouteVO[])models.toArray(new ValidateInlandRouteVO[models.size()]);
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
		this.fullPkupYdCd = this.fullPkupYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routDestNodCd = this.routDestNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routOrgNodCd = this.routOrgNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullRtnYdCd = this.fullRtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspModCd = this.trspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq = this.routSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaPartialBlVO.java
*@FileTitle : UsaPartialBlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.08
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.04.08 김민정 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo;

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
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UsaPartialBlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaPartialBlVO> models = new ArrayList<UsaPartialBlVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cstmsClrTpCd = null;
	/* Column Info */
	private String obNtcFlg = null;
	/* Column Info */
	private String lclBlNbrA = null;
	/* Column Info */
	private String lclCustcIndA = null;
	/* Column Info */
	private String oldCstmsClrCdJcd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsaPartialBlVO() {}

	public UsaPartialBlVO(String ibflag, String pagerows, String lclCustcIndA, String cstmsClrTpCd, String obNtcFlg, String lclBlNbrA, String oldCstmsClrCdJcd) {
		this.ibflag = ibflag;
		this.cstmsClrTpCd = cstmsClrTpCd;
		this.obNtcFlg = obNtcFlg;
		this.lclBlNbrA = lclBlNbrA;
		this.lclCustcIndA = lclCustcIndA;
		this.oldCstmsClrCdJcd = oldCstmsClrCdJcd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cstms_clr_tp_cd", getCstmsClrTpCd());
		this.hashColumns.put("ob_ntc_flg", getObNtcFlg());
		this.hashColumns.put("lcl_bl_nbr_a", getLclBlNbrA());
		this.hashColumns.put("lcl_custc_ind_a", getLclCustcIndA());
		this.hashColumns.put("old_cstms_clr_cd_jcd", getOldCstmsClrCdJcd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cstms_clr_tp_cd", "cstmsClrTpCd");
		this.hashFields.put("ob_ntc_flg", "obNtcFlg");
		this.hashFields.put("lcl_bl_nbr_a", "lclBlNbrA");
		this.hashFields.put("lcl_custc_ind_a", "lclCustcIndA");
		this.hashFields.put("old_cstms_clr_cd_jcd", "oldCstmsClrCdJcd");
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
	 * @return cstmsClrTpCd
	 */
	public String getCstmsClrTpCd() {
		return this.cstmsClrTpCd;
	}
	
	/**
	 * Column Info
	 * @return obNtcFlg
	 */
	public String getObNtcFlg() {
		return this.obNtcFlg;
	}
	
	/**
	 * Column Info
	 * @return lclBlNbrA
	 */
	public String getLclBlNbrA() {
		return this.lclBlNbrA;
	}
	
	/**
	 * Column Info
	 * @return lclCustcIndA
	 */
	public String getLclCustcIndA() {
		return this.lclCustcIndA;
	}
	
	/**
	 * Column Info
	 * @return oldCstmsClrCdJcd
	 */
	public String getOldCstmsClrCdJcd() {
		return this.oldCstmsClrCdJcd;
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
	 * @param cstmsClrTpCd
	 */
	public void setCstmsClrTpCd(String cstmsClrTpCd) {
		this.cstmsClrTpCd = cstmsClrTpCd;
	}
	
	/**
	 * Column Info
	 * @param obNtcFlg
	 */
	public void setObNtcFlg(String obNtcFlg) {
		this.obNtcFlg = obNtcFlg;
	}
	
	/**
	 * Column Info
	 * @param lclBlNbrA
	 */
	public void setLclBlNbrA(String lclBlNbrA) {
		this.lclBlNbrA = lclBlNbrA;
	}
	
	/**
	 * Column Info
	 * @param lclCustcIndA
	 */
	public void setLclCustcIndA(String lclCustcIndA) {
		this.lclCustcIndA = lclCustcIndA;
	}
	
	/**
	 * Column Info
	 * @param oldCstmsClrCdJcd
	 */
	public void setOldCstmsClrCdJcd(String oldCstmsClrCdJcd) {
		this.oldCstmsClrCdJcd = oldCstmsClrCdJcd;
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
		setCstmsClrTpCd(JSPUtil.getParameter(request, prefix + "cstms_clr_tp_cd", ""));
		setObNtcFlg(JSPUtil.getParameter(request, prefix + "ob_ntc_flg", ""));
		setLclBlNbrA(JSPUtil.getParameter(request, prefix + "lcl_bl_nbr_a", ""));
		setLclCustcIndA(JSPUtil.getParameter(request, prefix + "lcl_custc_ind_a", ""));
		setOldCstmsClrCdJcd(JSPUtil.getParameter(request, prefix + "old_cstms_clr_cd_jcd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaPartialBlVO[]
	 */
	public UsaPartialBlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaPartialBlVO[]
	 */
	public UsaPartialBlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaPartialBlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cstmsClrTpCd = (JSPUtil.getParameter(request, prefix	+ "cstms_clr_tp_cd", length));
			String[] obNtcFlg = (JSPUtil.getParameter(request, prefix	+ "ob_ntc_flg", length));
			String[] lclBlNbrA = (JSPUtil.getParameter(request, prefix	+ "lcl_bl_nbr_a", length));
			String[] lclCustcIndA = (JSPUtil.getParameter(request, prefix	+ "lcl_custc_ind_a", length));
			String[] oldCstmsClrCdJcd = (JSPUtil.getParameter(request, prefix	+ "old_cstms_clr_cd_jcd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsaPartialBlVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cstmsClrTpCd[i] != null)
					model.setCstmsClrTpCd(cstmsClrTpCd[i]);
				if (obNtcFlg[i] != null)
					model.setObNtcFlg(obNtcFlg[i]);
				if (lclBlNbrA[i] != null)
					model.setLclBlNbrA(lclBlNbrA[i]);
				if (lclCustcIndA[i] != null)
					model.setLclCustcIndA(lclCustcIndA[i]);
				if (oldCstmsClrCdJcd[i] != null)
					model.setOldCstmsClrCdJcd(oldCstmsClrCdJcd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaPartialBlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaPartialBlVO[]
	 */
	public UsaPartialBlVO[] getUsaPartialBlVOs(){
		UsaPartialBlVO[] vos = (UsaPartialBlVO[])models.toArray(new UsaPartialBlVO[models.size()]);
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
		this.cstmsClrTpCd = this.cstmsClrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obNtcFlg = this.obNtcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lclBlNbrA = this.lclBlNbrA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lclCustcIndA = this.lclCustcIndA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldCstmsClrCdJcd = this.oldCstmsClrCdJcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

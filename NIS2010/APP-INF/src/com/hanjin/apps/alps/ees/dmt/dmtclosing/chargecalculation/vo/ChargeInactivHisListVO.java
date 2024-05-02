/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChargeInactivHisListVO.java
*@FileTitle : ChargeInactivHisListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.06  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class ChargeInactivHisListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ChargeInactivHisListVO> models = new ArrayList<ChargeInactivHisListVO>();
	
	/* Column Info */
	private String inactDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String inactOfcCd = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String inactRmk = null;
	/* Column Info */
	private String inactUsrNm = null;
	/* Column Info */
	private String inactStsDesc = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ChargeInactivHisListVO() {}

	public ChargeInactivHisListVO(String ibflag, String pagerows, String inactStsDesc, String inactDt, String inactOfcCd, String inactUsrNm, String inactRmk, String seq) {
		this.inactDt = inactDt;
		this.ibflag = ibflag;
		this.inactOfcCd = inactOfcCd;
		this.seq = seq;
		this.inactRmk = inactRmk;
		this.inactUsrNm = inactUsrNm;
		this.inactStsDesc = inactStsDesc;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("inact_dt", getInactDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("inact_ofc_cd", getInactOfcCd());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("inact_rmk", getInactRmk());
		this.hashColumns.put("inact_usr_nm", getInactUsrNm());
		this.hashColumns.put("inact_sts_desc", getInactStsDesc());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("inact_dt", "inactDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inact_ofc_cd", "inactOfcCd");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("inact_rmk", "inactRmk");
		this.hashFields.put("inact_usr_nm", "inactUsrNm");
		this.hashFields.put("inact_sts_desc", "inactStsDesc");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return inactDt
	 */
	public String getInactDt() {
		return this.inactDt;
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
	 * @return inactOfcCd
	 */
	public String getInactOfcCd() {
		return this.inactOfcCd;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return inactRmk
	 */
	public String getInactRmk() {
		return this.inactRmk;
	}
	
	/**
	 * Column Info
	 * @return inactUsrNm
	 */
	public String getInactUsrNm() {
		return this.inactUsrNm;
	}
	
	/**
	 * Column Info
	 * @return inactStsDesc
	 */
	public String getInactStsDesc() {
		return this.inactStsDesc;
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
	 * @param inactDt
	 */
	public void setInactDt(String inactDt) {
		this.inactDt = inactDt;
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
	 * @param inactOfcCd
	 */
	public void setInactOfcCd(String inactOfcCd) {
		this.inactOfcCd = inactOfcCd;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param inactRmk
	 */
	public void setInactRmk(String inactRmk) {
		this.inactRmk = inactRmk;
	}
	
	/**
	 * Column Info
	 * @param inactUsrNm
	 */
	public void setInactUsrNm(String inactUsrNm) {
		this.inactUsrNm = inactUsrNm;
	}
	
	/**
	 * Column Info
	 * @param inactStsDesc
	 */
	public void setInactStsDesc(String inactStsDesc) {
		this.inactStsDesc = inactStsDesc;
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
		setInactDt(JSPUtil.getParameter(request, prefix + "inact_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setInactOfcCd(JSPUtil.getParameter(request, prefix + "inact_ofc_cd", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setInactRmk(JSPUtil.getParameter(request, prefix + "inact_rmk", ""));
		setInactUsrNm(JSPUtil.getParameter(request, prefix + "inact_usr_nm", ""));
		setInactStsDesc(JSPUtil.getParameter(request, prefix + "inact_sts_desc", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChargeInactivHisListVO[]
	 */
	public ChargeInactivHisListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ChargeInactivHisListVO[]
	 */
	public ChargeInactivHisListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChargeInactivHisListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] inactDt = (JSPUtil.getParameter(request, prefix	+ "inact_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] inactOfcCd = (JSPUtil.getParameter(request, prefix	+ "inact_ofc_cd", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] inactRmk = (JSPUtil.getParameter(request, prefix	+ "inact_rmk", length));
			String[] inactUsrNm = (JSPUtil.getParameter(request, prefix	+ "inact_usr_nm", length));
			String[] inactStsDesc = (JSPUtil.getParameter(request, prefix	+ "inact_sts_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ChargeInactivHisListVO();
				if (inactDt[i] != null)
					model.setInactDt(inactDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (inactOfcCd[i] != null)
					model.setInactOfcCd(inactOfcCd[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (inactRmk[i] != null)
					model.setInactRmk(inactRmk[i]);
				if (inactUsrNm[i] != null)
					model.setInactUsrNm(inactUsrNm[i]);
				if (inactStsDesc[i] != null)
					model.setInactStsDesc(inactStsDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChargeInactivHisListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChargeInactivHisListVO[]
	 */
	public ChargeInactivHisListVO[] getChargeInactivHisListVOs(){
		ChargeInactivHisListVO[] vos = (ChargeInactivHisListVO[])models.toArray(new ChargeInactivHisListVO[models.size()]);
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
		this.inactDt = this.inactDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inactOfcCd = this.inactOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inactRmk = this.inactRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inactUsrNm = this.inactUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inactStsDesc = this.inactStsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

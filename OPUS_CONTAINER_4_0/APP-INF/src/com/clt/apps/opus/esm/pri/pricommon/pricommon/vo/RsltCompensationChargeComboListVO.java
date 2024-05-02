/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RsltCompensationChargeComboListVO.java
*@FileTitle : RsltCompensationChargeComboListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.17
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2010.02.17 김대호 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.pricommon.pricommon.vo;

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
 * @author 김대호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltCompensationChargeComboListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltCompensationChargeComboListVO> models = new ArrayList<RsltCompensationChargeComboListVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String chgNm = null;
	/* Column Info */
	private String progId = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String chgCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltCompensationChargeComboListVO() {}

	public RsltCompensationChargeComboListVO(String ibflag, String pagerows, String chgCd, String chgNm, String deltFlg, String progId) {
		this.ibflag = ibflag;
		this.chgNm = chgNm;
		this.progId = progId;
		this.deltFlg = deltFlg;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("chg_nm", getChgNm());
		this.hashColumns.put("prog_id", getProgId());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("chg_nm", "chgNm");
		this.hashFields.put("prog_id", "progId");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("chg_cd", "chgCd");
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
	 * @return chgNm
	 */
	public String getChgNm() {
		return this.chgNm;
	}
	
	/**
	 * Column Info
	 * @return progId
	 */
	public String getProgId() {
		return this.progId;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
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
	 * @param chgNm
	 */
	public void setChgNm(String chgNm) {
		this.chgNm = chgNm;
	}
	
	/**
	 * Column Info
	 * @param progId
	 */
	public void setProgId(String progId) {
		this.progId = progId;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
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
		setChgNm(JSPUtil.getParameter(request, prefix + "chg_nm", ""));
		setProgId(JSPUtil.getParameter(request, prefix + "prog_id", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltCompensationChargeComboListVO[]
	 */
	public RsltCompensationChargeComboListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltCompensationChargeComboListVO[]
	 */
	public RsltCompensationChargeComboListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltCompensationChargeComboListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] chgNm = (JSPUtil.getParameter(request, prefix	+ "chg_nm", length));
			String[] progId = (JSPUtil.getParameter(request, prefix	+ "prog_id", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltCompensationChargeComboListVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (chgNm[i] != null)
					model.setChgNm(chgNm[i]);
				if (progId[i] != null)
					model.setProgId(progId[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltCompensationChargeComboListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltCompensationChargeComboListVO[]
	 */
	public RsltCompensationChargeComboListVO[] getRsltCompensationChargeComboListVOs(){
		RsltCompensationChargeComboListVO[] vos = (RsltCompensationChargeComboListVO[])models.toArray(new RsltCompensationChargeComboListVO[models.size()]);
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
		this.chgNm = this.chgNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.progId = this.progId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

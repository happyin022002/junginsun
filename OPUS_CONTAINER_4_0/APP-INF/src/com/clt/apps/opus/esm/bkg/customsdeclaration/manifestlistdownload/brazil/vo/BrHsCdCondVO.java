/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BrHsCdCondVO.java
*@FileTitle : BrHsCdCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.16
*@LastModifier : 
*@LastVersion : 1.0
* 2010.07.16  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.brazil.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BrHsCdCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BrHsCdCondVO> models = new ArrayList<BrHsCdCondVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String countrycode = null;
	/* Column Info */
	private String brzCmdtCd = null;
	/* Column Info */
	private String actFlg = null;
	/* Column Info */
	private String cmdtDesc = null;
	/* Column Info */
	private String delCheck = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String pageGubun = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BrHsCdCondVO() {}

	public BrHsCdCondVO(String ibflag, String pagerows, String brzCmdtCd, String cmdtDesc, String cntCd, String actFlg, String countrycode, String pageGubun, String delCheck) {
		this.ibflag = ibflag;
		this.countrycode = countrycode;
		this.brzCmdtCd = brzCmdtCd;
		this.actFlg = actFlg;
		this.cmdtDesc = cmdtDesc;
		this.delCheck = delCheck;
		this.cntCd = cntCd;
		this.pageGubun = pageGubun;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("countrycode", getCountrycode());
		this.hashColumns.put("brz_cmdt_cd", getBrzCmdtCd());
		this.hashColumns.put("act_flg", getActFlg());
		this.hashColumns.put("cmdt_desc", getCmdtDesc());
		this.hashColumns.put("del_check", getDelCheck());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("page_gubun", getPageGubun());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("countrycode", "countrycode");
		this.hashFields.put("brz_cmdt_cd", "brzCmdtCd");
		this.hashFields.put("act_flg", "actFlg");
		this.hashFields.put("cmdt_desc", "cmdtDesc");
		this.hashFields.put("del_check", "delCheck");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("page_gubun", "pageGubun");
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
	 * @return countrycode
	 */
	public String getCountrycode() {
		return this.countrycode;
	}
	
	/**
	 * Column Info
	 * @return brzCmdtCd
	 */
	public String getBrzCmdtCd() {
		return this.brzCmdtCd;
	}
	
	/**
	 * Column Info
	 * @return actFlg
	 */
	public String getActFlg() {
		return this.actFlg;
	}
	
	/**
	 * Column Info
	 * @return cmdtDesc
	 */
	public String getCmdtDesc() {
		return this.cmdtDesc;
	}
	
	/**
	 * Column Info
	 * @return delCheck
	 */
	public String getDelCheck() {
		return this.delCheck;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return pageGubun
	 */
	public String getPageGubun() {
		return this.pageGubun;
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
	 * @param countrycode
	 */
	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}
	
	/**
	 * Column Info
	 * @param brzCmdtCd
	 */
	public void setBrzCmdtCd(String brzCmdtCd) {
		this.brzCmdtCd = brzCmdtCd;
	}
	
	/**
	 * Column Info
	 * @param actFlg
	 */
	public void setActFlg(String actFlg) {
		this.actFlg = actFlg;
	}
	
	/**
	 * Column Info
	 * @param cmdtDesc
	 */
	public void setCmdtDesc(String cmdtDesc) {
		this.cmdtDesc = cmdtDesc;
	}
	
	/**
	 * Column Info
	 * @param delCheck
	 */
	public void setDelCheck(String delCheck) {
		this.delCheck = delCheck;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param pageGubun
	 */
	public void setPageGubun(String pageGubun) {
		this.pageGubun = pageGubun;
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
		setCountrycode(JSPUtil.getParameter(request, prefix + "countrycode", ""));
		setBrzCmdtCd(JSPUtil.getParameter(request, prefix + "brz_cmdt_cd", ""));
		setActFlg(JSPUtil.getParameter(request, prefix + "act_flg", ""));
		setCmdtDesc(JSPUtil.getParameter(request, prefix + "cmdt_desc", ""));
		setDelCheck(JSPUtil.getParameter(request, prefix + "del_check", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setPageGubun(JSPUtil.getParameter(request, prefix + "page_gubun", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BrHsCdCondVO[]
	 */
	public BrHsCdCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BrHsCdCondVO[]
	 */
	public BrHsCdCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BrHsCdCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] countrycode = (JSPUtil.getParameter(request, prefix	+ "countrycode", length));
			String[] brzCmdtCd = (JSPUtil.getParameter(request, prefix	+ "brz_cmdt_cd", length));
			String[] actFlg = (JSPUtil.getParameter(request, prefix	+ "act_flg", length));
			String[] cmdtDesc = (JSPUtil.getParameter(request, prefix	+ "cmdt_desc", length));
			String[] delCheck = (JSPUtil.getParameter(request, prefix	+ "del_check", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] pageGubun = (JSPUtil.getParameter(request, prefix	+ "page_gubun", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new BrHsCdCondVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (countrycode[i] != null)
					model.setCountrycode(countrycode[i]);
				if (brzCmdtCd[i] != null)
					model.setBrzCmdtCd(brzCmdtCd[i]);
				if (actFlg[i] != null)
					model.setActFlg(actFlg[i]);
				if (cmdtDesc[i] != null)
					model.setCmdtDesc(cmdtDesc[i]);
				if (delCheck[i] != null)
					model.setDelCheck(delCheck[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (pageGubun[i] != null)
					model.setPageGubun(pageGubun[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBrHsCdCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BrHsCdCondVO[]
	 */
	public BrHsCdCondVO[] getBrHsCdCondVOs(){
		BrHsCdCondVO[] vos = (BrHsCdCondVO[])models.toArray(new BrHsCdCondVO[models.size()]);
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
		this.countrycode = this.countrycode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brzCmdtCd = this.brzCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actFlg = this.actFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDesc = this.cmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCheck = this.delCheck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pageGubun = this.pageGubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

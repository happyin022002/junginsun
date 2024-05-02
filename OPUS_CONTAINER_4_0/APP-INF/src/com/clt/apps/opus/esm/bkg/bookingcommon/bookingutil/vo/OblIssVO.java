/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OblIssVO.java
*@FileTitle : OblIssVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.03
*@LastModifier : 
*@LastVersion : 1.0
* 2010.09.03  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo;

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

public class OblIssVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OblIssVO> models = new ArrayList<OblIssVO>();
	
	/* Column Info */
	private String oblRlseFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String rdnAcptFlg = null;
	/* Column Info */
	private String rdnNo = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String rvisSeq = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OblIssVO() {}

	public OblIssVO(String ibflag, String pagerows, String blNo, String oblRlseFlg, String rdnNo, String rvisSeq, String delCd, String rdnAcptFlg) {
		this.oblRlseFlg = oblRlseFlg;
		this.ibflag = ibflag;
		this.delCd = delCd;
		this.rdnAcptFlg = rdnAcptFlg;
		this.rdnNo = rdnNo;
		this.blNo = blNo;
		this.rvisSeq = rvisSeq;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("obl_rlse_flg", getOblRlseFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("rdn_acpt_flg", getRdnAcptFlg());
		this.hashColumns.put("rdn_no", getRdnNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("rvis_seq", getRvisSeq());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("obl_rlse_flg", "oblRlseFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("rdn_acpt_flg", "rdnAcptFlg");
		this.hashFields.put("rdn_no", "rdnNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("rvis_seq", "rvisSeq");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return oblRlseFlg
	 */
	public String getOblRlseFlg() {
		return this.oblRlseFlg;
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
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return rdnAcptFlg
	 */
	public String getRdnAcptFlg() {
		return this.rdnAcptFlg;
	}
	
	/**
	 * Column Info
	 * @return rdnNo
	 */
	public String getRdnNo() {
		return this.rdnNo;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return rvisSeq
	 */
	public String getRvisSeq() {
		return this.rvisSeq;
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
	 * @param oblRlseFlg
	 */
	public void setOblRlseFlg(String oblRlseFlg) {
		this.oblRlseFlg = oblRlseFlg;
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
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param rdnAcptFlg
	 */
	public void setRdnAcptFlg(String rdnAcptFlg) {
		this.rdnAcptFlg = rdnAcptFlg;
	}
	
	/**
	 * Column Info
	 * @param rdnNo
	 */
	public void setRdnNo(String rdnNo) {
		this.rdnNo = rdnNo;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param rvisSeq
	 */
	public void setRvisSeq(String rvisSeq) {
		this.rvisSeq = rvisSeq;
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
		setOblRlseFlg(JSPUtil.getParameter(request, prefix + "obl_rlse_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setRdnAcptFlg(JSPUtil.getParameter(request, prefix + "rdn_acpt_flg", ""));
		setRdnNo(JSPUtil.getParameter(request, prefix + "rdn_no", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setRvisSeq(JSPUtil.getParameter(request, prefix + "rvis_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OblIssVO[]
	 */
	public OblIssVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OblIssVO[]
	 */
	public OblIssVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OblIssVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] oblRlseFlg = (JSPUtil.getParameter(request, prefix	+ "obl_rlse_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] rdnAcptFlg = (JSPUtil.getParameter(request, prefix	+ "rdn_acpt_flg", length));
			String[] rdnNo = (JSPUtil.getParameter(request, prefix	+ "rdn_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] rvisSeq = (JSPUtil.getParameter(request, prefix	+ "rvis_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new OblIssVO();
				if (oblRlseFlg[i] != null)
					model.setOblRlseFlg(oblRlseFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (rdnAcptFlg[i] != null)
					model.setRdnAcptFlg(rdnAcptFlg[i]);
				if (rdnNo[i] != null)
					model.setRdnNo(rdnNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (rvisSeq[i] != null)
					model.setRvisSeq(rvisSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOblIssVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OblIssVO[]
	 */
	public OblIssVO[] getOblIssVOs(){
		OblIssVO[] vos = (OblIssVO[])models.toArray(new OblIssVO[models.size()]);
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
		this.oblRlseFlg = this.oblRlseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdnAcptFlg = this.rdnAcptFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdnNo = this.rdnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisSeq = this.rvisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

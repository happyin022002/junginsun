/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DODInvEmailFaxVO.java
*@FileTitle : DODInvEmailFaxVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.24
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2013.09.24 김종옥 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo;

import java.lang.reflect.Field;
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
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DODInvEmailFaxVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DODInvEmailFaxVO> models = new ArrayList<DODInvEmailFaxVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntcPntNm = null;
	/* Column Info */
	private String dodInvNo = null;
	/* Column Info */
	private String rdName = null;
	/* Column Info */
	private String cntcPntEml = null;
	/* Column Info */
	private String cntcPntFaxNo = null;
	/* Column Info */
	private String rdParm = null;
	/* Column Info */
	private String cntcPntPhnNo = null;
	/* Column Info */
	private String sendFlg = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DODInvEmailFaxVO() {}

	public DODInvEmailFaxVO(String ibflag, String pagerows, String sendFlg, String dodInvNo, String cntcPntNm, String cntcPntPhnNo, String cntcPntFaxNo, String cntcPntEml, String rdName, String rdParm) {
		this.ibflag = ibflag;
		this.cntcPntNm = cntcPntNm;
		this.dodInvNo = dodInvNo;
		this.rdName = rdName;
		this.cntcPntEml = cntcPntEml;
		this.cntcPntFaxNo = cntcPntFaxNo;
		this.rdParm = rdParm;
		this.cntcPntPhnNo = cntcPntPhnNo;
		this.sendFlg = sendFlg;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntc_pnt_nm", getCntcPntNm());
		this.hashColumns.put("dod_inv_no", getDodInvNo());
		this.hashColumns.put("rd_name", getRdName());
		this.hashColumns.put("cntc_pnt_eml", getCntcPntEml());
		this.hashColumns.put("cntc_pnt_fax_no", getCntcPntFaxNo());
		this.hashColumns.put("rd_parm", getRdParm());
		this.hashColumns.put("cntc_pnt_phn_no", getCntcPntPhnNo());
		this.hashColumns.put("send_flg", getSendFlg());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntc_pnt_nm", "cntcPntNm");
		this.hashFields.put("dod_inv_no", "dodInvNo");
		this.hashFields.put("rd_name", "rdName");
		this.hashFields.put("cntc_pnt_eml", "cntcPntEml");
		this.hashFields.put("cntc_pnt_fax_no", "cntcPntFaxNo");
		this.hashFields.put("rd_parm", "rdParm");
		this.hashFields.put("cntc_pnt_phn_no", "cntcPntPhnNo");
		this.hashFields.put("send_flg", "sendFlg");
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
	 * @return cntcPntNm
	 */
	public String getCntcPntNm() {
		return this.cntcPntNm;
	}
	
	/**
	 * Column Info
	 * @return dodInvNo
	 */
	public String getDodInvNo() {
		return this.dodInvNo;
	}
	
	/**
	 * Column Info
	 * @return rdName
	 */
	public String getRdName() {
		return this.rdName;
	}
	
	/**
	 * Column Info
	 * @return cntcPntEml
	 */
	public String getCntcPntEml() {
		return this.cntcPntEml;
	}
	
	/**
	 * Column Info
	 * @return cntcPntFaxNo
	 */
	public String getCntcPntFaxNo() {
		return this.cntcPntFaxNo;
	}
	
	/**
	 * Column Info
	 * @return rdParm
	 */
	public String getRdParm() {
		return this.rdParm;
	}
	
	/**
	 * Column Info
	 * @return cntcPntPhnNo
	 */
	public String getCntcPntPhnNo() {
		return this.cntcPntPhnNo;
	}
	
	/**
	 * Column Info
	 * @return sendFlg
	 */
	public String getSendFlg() {
		return this.sendFlg;
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
	 * @param cntcPntNm
	 */
	public void setCntcPntNm(String cntcPntNm) {
		this.cntcPntNm = cntcPntNm;
	}
	
	/**
	 * Column Info
	 * @param dodInvNo
	 */
	public void setDodInvNo(String dodInvNo) {
		this.dodInvNo = dodInvNo;
	}
	
	/**
	 * Column Info
	 * @param rdName
	 */
	public void setRdName(String rdName) {
		this.rdName = rdName;
	}
	
	/**
	 * Column Info
	 * @param cntcPntEml
	 */
	public void setCntcPntEml(String cntcPntEml) {
		this.cntcPntEml = cntcPntEml;
	}
	
	/**
	 * Column Info
	 * @param cntcPntFaxNo
	 */
	public void setCntcPntFaxNo(String cntcPntFaxNo) {
		this.cntcPntFaxNo = cntcPntFaxNo;
	}
	
	/**
	 * Column Info
	 * @param rdParm
	 */
	public void setRdParm(String rdParm) {
		this.rdParm = rdParm;
	}
	
	/**
	 * Column Info
	 * @param cntcPntPhnNo
	 */
	public void setCntcPntPhnNo(String cntcPntPhnNo) {
		this.cntcPntPhnNo = cntcPntPhnNo;
	}
	
	/**
	 * Column Info
	 * @param sendFlg
	 */
	public void setSendFlg(String sendFlg) {
		this.sendFlg = sendFlg;
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
		setCntcPntNm(JSPUtil.getParameter(request, prefix + "cntc_pnt_nm", ""));
		setDodInvNo(JSPUtil.getParameter(request, prefix + "dod_inv_no", ""));
		setRdName(JSPUtil.getParameter(request, prefix + "rd_name", ""));
		setCntcPntEml(JSPUtil.getParameter(request, prefix + "cntc_pnt_eml", ""));
		setCntcPntFaxNo(JSPUtil.getParameter(request, prefix + "cntc_pnt_fax_no", ""));
		setRdParm(JSPUtil.getParameter(request, prefix + "rd_parm", ""));
		setCntcPntPhnNo(JSPUtil.getParameter(request, prefix + "cntc_pnt_phn_no", ""));
		setSendFlg(JSPUtil.getParameter(request, prefix + "send_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DODInvEmailFaxVO[]
	 */
	public DODInvEmailFaxVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DODInvEmailFaxVO[]
	 */
	public DODInvEmailFaxVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DODInvEmailFaxVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntcPntNm = (JSPUtil.getParameter(request, prefix	+ "cntc_pnt_nm", length));
			String[] dodInvNo = (JSPUtil.getParameter(request, prefix	+ "dod_inv_no", length));
			String[] rdName = (JSPUtil.getParameter(request, prefix	+ "rd_name", length));
			String[] cntcPntEml = (JSPUtil.getParameter(request, prefix	+ "cntc_pnt_eml", length));
			String[] cntcPntFaxNo = (JSPUtil.getParameter(request, prefix	+ "cntc_pnt_fax_no", length));
			String[] rdParm = (JSPUtil.getParameter(request, prefix	+ "rd_parm", length));
			String[] cntcPntPhnNo = (JSPUtil.getParameter(request, prefix	+ "cntc_pnt_phn_no", length));
			String[] sendFlg = (JSPUtil.getParameter(request, prefix	+ "send_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new DODInvEmailFaxVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntcPntNm[i] != null)
					model.setCntcPntNm(cntcPntNm[i]);
				if (dodInvNo[i] != null)
					model.setDodInvNo(dodInvNo[i]);
				if (rdName[i] != null)
					model.setRdName(rdName[i]);
				if (cntcPntEml[i] != null)
					model.setCntcPntEml(cntcPntEml[i]);
				if (cntcPntFaxNo[i] != null)
					model.setCntcPntFaxNo(cntcPntFaxNo[i]);
				if (rdParm[i] != null)
					model.setRdParm(rdParm[i]);
				if (cntcPntPhnNo[i] != null)
					model.setCntcPntPhnNo(cntcPntPhnNo[i]);
				if (sendFlg[i] != null)
					model.setSendFlg(sendFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDODInvEmailFaxVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DODInvEmailFaxVO[]
	 */
	public DODInvEmailFaxVO[] getDODInvEmailFaxVOs(){
		DODInvEmailFaxVO[] vos = (DODInvEmailFaxVO[])models.toArray(new DODInvEmailFaxVO[models.size()]);
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
		this.cntcPntNm = this.cntcPntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dodInvNo = this.dodInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdName = this.rdName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPntEml = this.cntcPntEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPntFaxNo = this.cntcPntFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdParm = this.rdParm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPntPhnNo = this.cntcPntPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sendFlg = this.sendFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

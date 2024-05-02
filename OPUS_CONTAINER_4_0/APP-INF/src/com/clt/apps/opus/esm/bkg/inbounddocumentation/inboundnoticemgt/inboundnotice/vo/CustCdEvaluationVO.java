/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CustCdEvaluationVO.java
*@FileTitle : CustCdEvaluationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.25
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.25  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo;

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

public class CustCdEvaluationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustCdEvaluationVO> models = new ArrayList<CustCdEvaluationVO>();
	
	/* Column Info */
	private String orgCustCd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String corCustCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String tsFlg = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String valCustCd = null;
	/* Column Info */
	private String anSndFlg = null;
	/* Column Info */
	private String bkgCustTpCd = null;
	/* Column Info */
	private String mdmCustCd = null;
	/* Column Info */
	private String valCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustCdEvaluationVO() {}

	public CustCdEvaluationVO(String ibflag, String pagerows, String bkgNo, String bkgCustTpCd, String blNo, String valCustCd, String valCd, String ofcCd, String anSndFlg, String usrId, String corCustCd, String tsFlg, String mdmCustCd, String orgCustCd) {
		this.orgCustCd = orgCustCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.corCustCd = corCustCd;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.tsFlg = tsFlg;
		this.usrId = usrId;
		this.valCustCd = valCustCd;
		this.anSndFlg = anSndFlg;
		this.bkgCustTpCd = bkgCustTpCd;
		this.mdmCustCd = mdmCustCd;
		this.valCd = valCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("org_cust_cd", getOrgCustCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cor_cust_cd", getCorCustCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ts_flg", getTsFlg());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("val_cust_cd", getValCustCd());
		this.hashColumns.put("an_snd_flg", getAnSndFlg());
		this.hashColumns.put("bkg_cust_tp_cd", getBkgCustTpCd());
		this.hashColumns.put("mdm_cust_cd", getMdmCustCd());
		this.hashColumns.put("val_cd", getValCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("org_cust_cd", "orgCustCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cor_cust_cd", "corCustCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ts_flg", "tsFlg");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("val_cust_cd", "valCustCd");
		this.hashFields.put("an_snd_flg", "anSndFlg");
		this.hashFields.put("bkg_cust_tp_cd", "bkgCustTpCd");
		this.hashFields.put("mdm_cust_cd", "mdmCustCd");
		this.hashFields.put("val_cd", "valCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return orgCustCd
	 */
	public String getOrgCustCd() {
		return this.orgCustCd;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return corCustCd
	 */
	public String getCorCustCd() {
		return this.corCustCd;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return tsFlg
	 */
	public String getTsFlg() {
		return this.tsFlg;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return valCustCd
	 */
	public String getValCustCd() {
		return this.valCustCd;
	}
	
	/**
	 * Column Info
	 * @return anSndFlg
	 */
	public String getAnSndFlg() {
		return this.anSndFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgCustTpCd
	 */
	public String getBkgCustTpCd() {
		return this.bkgCustTpCd;
	}
	
	/**
	 * Column Info
	 * @return mdmCustCd
	 */
	public String getMdmCustCd() {
		return this.mdmCustCd;
	}
	
	/**
	 * Column Info
	 * @return valCd
	 */
	public String getValCd() {
		return this.valCd;
	}
	

	/**
	 * Column Info
	 * @param orgCustCd
	 */
	public void setOrgCustCd(String orgCustCd) {
		this.orgCustCd = orgCustCd;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param corCustCd
	 */
	public void setCorCustCd(String corCustCd) {
		this.corCustCd = corCustCd;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param tsFlg
	 */
	public void setTsFlg(String tsFlg) {
		this.tsFlg = tsFlg;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param valCustCd
	 */
	public void setValCustCd(String valCustCd) {
		this.valCustCd = valCustCd;
	}
	
	/**
	 * Column Info
	 * @param anSndFlg
	 */
	public void setAnSndFlg(String anSndFlg) {
		this.anSndFlg = anSndFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgCustTpCd
	 */
	public void setBkgCustTpCd(String bkgCustTpCd) {
		this.bkgCustTpCd = bkgCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param mdmCustCd
	 */
	public void setMdmCustCd(String mdmCustCd) {
		this.mdmCustCd = mdmCustCd;
	}
	
	/**
	 * Column Info
	 * @param valCd
	 */
	public void setValCd(String valCd) {
		this.valCd = valCd;
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
		setOrgCustCd(JSPUtil.getParameter(request, prefix + "org_cust_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCorCustCd(JSPUtil.getParameter(request, prefix + "cor_cust_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setTsFlg(JSPUtil.getParameter(request, prefix + "ts_flg", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setValCustCd(JSPUtil.getParameter(request, prefix + "val_cust_cd", ""));
		setAnSndFlg(JSPUtil.getParameter(request, prefix + "an_snd_flg", ""));
		setBkgCustTpCd(JSPUtil.getParameter(request, prefix + "bkg_cust_tp_cd", ""));
		setMdmCustCd(JSPUtil.getParameter(request, prefix + "mdm_cust_cd", ""));
		setValCd(JSPUtil.getParameter(request, prefix + "val_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustCdEvaluationVO[]
	 */
	public CustCdEvaluationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustCdEvaluationVO[]
	 */
	public CustCdEvaluationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustCdEvaluationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] orgCustCd = (JSPUtil.getParameter(request, prefix	+ "org_cust_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] corCustCd = (JSPUtil.getParameter(request, prefix	+ "cor_cust_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] tsFlg = (JSPUtil.getParameter(request, prefix	+ "ts_flg", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] valCustCd = (JSPUtil.getParameter(request, prefix	+ "val_cust_cd", length));
			String[] anSndFlg = (JSPUtil.getParameter(request, prefix	+ "an_snd_flg", length));
			String[] bkgCustTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cust_tp_cd", length));
			String[] mdmCustCd = (JSPUtil.getParameter(request, prefix	+ "mdm_cust_cd", length));
			String[] valCd = (JSPUtil.getParameter(request, prefix	+ "val_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustCdEvaluationVO();
				if (orgCustCd[i] != null)
					model.setOrgCustCd(orgCustCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (corCustCd[i] != null)
					model.setCorCustCd(corCustCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (tsFlg[i] != null)
					model.setTsFlg(tsFlg[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (valCustCd[i] != null)
					model.setValCustCd(valCustCd[i]);
				if (anSndFlg[i] != null)
					model.setAnSndFlg(anSndFlg[i]);
				if (bkgCustTpCd[i] != null)
					model.setBkgCustTpCd(bkgCustTpCd[i]);
				if (mdmCustCd[i] != null)
					model.setMdmCustCd(mdmCustCd[i]);
				if (valCd[i] != null)
					model.setValCd(valCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustCdEvaluationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustCdEvaluationVO[]
	 */
	public CustCdEvaluationVO[] getCustCdEvaluationVOs(){
		CustCdEvaluationVO[] vos = (CustCdEvaluationVO[])models.toArray(new CustCdEvaluationVO[models.size()]);
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
		this.orgCustCd = this.orgCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corCustCd = this.corCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsFlg = this.tsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.valCustCd = this.valCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anSndFlg = this.anSndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustTpCd = this.bkgCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdmCustCd = this.mdmCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.valCd = this.valCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

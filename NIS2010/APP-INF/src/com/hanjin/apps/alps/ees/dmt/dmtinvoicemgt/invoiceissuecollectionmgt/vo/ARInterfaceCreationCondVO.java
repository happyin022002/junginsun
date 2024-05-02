/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ARInterfaceCreationCondVO.java
*@FileTitle : ARInterfaceCreationCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.06
*@LastModifier : 
*@LastVersion : 1.0
* 2017.09.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo;

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
public class ARInterfaceCreationCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ARInterfaceCreationCondVO> models = new ArrayList<ARInterfaceCreationCondVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	
	/* Page Number */
	private String pagerows = null;

	/* Column Info */
	private String dmdtInvNo = null;

	/* Column Info */
	private String crInvFlg = null;

	/* Column Info */
	private String creOfcCd = null;

	/* Column Info */
	private String creCntCd = null;

	/* Column Info */
	private String idaTaxApplTm = null;

	/* Column Info */
	private String usrOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ARInterfaceCreationCondVO() {}

	public ARInterfaceCreationCondVO(String ibflag, String pagerows, String dmdtInvNo, String crInvFlg, String creOfcCd, String creCntCd, String idaTaxApplTm, String usrOfcCd) {
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.dmdtInvNo = dmdtInvNo;
		this.crInvFlg = crInvFlg;
		this.creOfcCd = creOfcCd;
		this.creCntCd = creCntCd;
		this.idaTaxApplTm = idaTaxApplTm;
		this.usrOfcCd = usrOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dmdt_inv_no", getDmdtInvNo());
		this.hashColumns.put("cr_inv_flg", getCrInvFlg());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("cre_cnt_cd", getCreCntCd());
		this.hashColumns.put("ida_tax_appl_tm", getIdaTaxApplTm());
		this.hashColumns.put("usr_ofc_cd", getUsrOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dmdt_inv_no", "dmdtInvNo");
		this.hashFields.put("cr_inv_flg", "crInvFlg");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("cre_cnt_cd", "creCntCd");
		this.hashFields.put("ida_tax_appl_tm", "idaTaxApplTm");
		this.hashFields.put("usr_ofc_cd", "usrOfcCd");
		return this.hashFields;
	}
	
	/**
	 *
	 * @param String ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * 
	 * @return String ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 *
	 * @param String pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * 
	 * @return String pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 *
	 * @param String dmdtInvNo
	 */
	public void setDmdtInvNo(String dmdtInvNo) {
		this.dmdtInvNo = dmdtInvNo;
	}
	
	/**
	 * 
	 * @return String dmdtInvNo
	 */
	public String getDmdtInvNo() {
		return this.dmdtInvNo;
	}
	
	/**
	 *
	 * @param String crInvFlg
	 */
	public void setCrInvFlg(String crInvFlg) {
		this.crInvFlg = crInvFlg;
	}
	
	/**
	 * 
	 * @return String crInvFlg
	 */
	public String getCrInvFlg() {
		return this.crInvFlg;
	}
	
	/**
	 *
	 * @param String creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * 
	 * @return String creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 *
	 * @param String creCntCd
	 */
	public void setCreCntCd(String creCntCd) {
		this.creCntCd = creCntCd;
	}
	
	/**
	 * 
	 * @return String creCntCd
	 */
	public String getCreCntCd() {
		return this.creCntCd;
	}
	
	/**
	 *
	 * @param String idaTaxApplTm
	 */
	public void setIdaTaxApplTm(String idaTaxApplTm) {
		this.idaTaxApplTm = idaTaxApplTm;
	}
	
	/**
	 * 
	 * @return String idaTaxApplTm
	 */
	public String getIdaTaxApplTm() {
		return this.idaTaxApplTm;
	}
	
	/**
	 *
	 * @param String usrOfcCd
	 */
	public void setUsrOfcCd(String usrOfcCd) {
		this.usrOfcCd = usrOfcCd;
	}
	
	/**
	 * 
	 * @return String usrOfcCd
	 */
	public String getUsrOfcCd() {
		return this.usrOfcCd;
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
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDmdtInvNo(JSPUtil.getParameter(request, prefix + "dmdt_inv_no", ""));
		setCrInvFlg(JSPUtil.getParameter(request, prefix + "cr_inv_flg", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setCreCntCd(JSPUtil.getParameter(request, prefix + "cre_cnt_cd", ""));
		setIdaTaxApplTm(JSPUtil.getParameter(request, prefix + "ida_tax_appl_tm", ""));
		setUsrOfcCd(JSPUtil.getParameter(request, prefix + "usr_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ARInterfaceCreationCondVO[]
	 */
	public ARInterfaceCreationCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ARInterfaceCreationCondVO[]
	 */
	public ARInterfaceCreationCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ARInterfaceCreationCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] dmdtInvNo = (JSPUtil.getParameter(request, prefix	+ "dmdt_inv_no", length));
			String[] crInvFlg = (JSPUtil.getParameter(request, prefix	+ "cr_inv_flg", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] creCntCd = (JSPUtil.getParameter(request, prefix	+ "cre_cnt_cd", length));
			String[] idaTaxApplTm = (JSPUtil.getParameter(request, prefix	+ "ida_tax_appl_tm", length));
			String[] usrOfcCd = (JSPUtil.getParameter(request, prefix	+ "usr_ofc_cd", length));
			/* Add a field line, do not delete */
			
			for (int i = 0; i < length; i++) {
				model = new ARInterfaceCreationCondVO();
				if (ibflag[i] != null) 
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null) 
					model.setPagerows(pagerows[i]);
				if (dmdtInvNo[i] != null) 
					model.setDmdtInvNo(dmdtInvNo[i]);
				if (crInvFlg[i] != null) 
					model.setCrInvFlg(crInvFlg[i]);
				if (creOfcCd[i] != null) 
					model.setCreOfcCd(creOfcCd[i]);
				if (creCntCd[i] != null) 
					model.setCreCntCd(creCntCd[i]);
				if (idaTaxApplTm[i] != null) 
					model.setIdaTaxApplTm(idaTaxApplTm[i]);
				if (usrOfcCd[i] != null) 
					model.setUsrOfcCd(usrOfcCd[i]);
				/* Add a Method line, do not delete */
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getARInterfaceCreationCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ARInterfaceCreationCondVO[]
	 */
	public ARInterfaceCreationCondVO[] getARInterfaceCreationCondVOs(){
		ARInterfaceCreationCondVO[] vos = (ARInterfaceCreationCondVO[])models.toArray(new ARInterfaceCreationCondVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtInvNo = this.dmdtInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crInvFlg = this.crInvFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creCntCd = this.creCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaTaxApplTm = this.idaTaxApplTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrOfcCd = this.usrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
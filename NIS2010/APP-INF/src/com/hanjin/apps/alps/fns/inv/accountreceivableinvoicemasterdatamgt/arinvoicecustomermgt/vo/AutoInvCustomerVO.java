/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AutoInvCustomerVO.java
*@FileTitle : AutoInvCustomerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.05.26 한동훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 한동훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AutoInvCustomerVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AutoInvCustomerVO> models = new ArrayList<AutoInvCustomerVO>();
	
	/* Column Info */
	private String hjsCustSvcPicTpCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String cust = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String autoInvHjsRefNo = null;
	/* Column Info */
	private String autoInvCustRefNoFlg = null;
	/* Column Info */
	private String autoInvLoclChgFlg = null;
	/* Column Info */
	private String autoInvEml = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AutoInvCustomerVO() {}

	public AutoInvCustomerVO(String ibflag, String pagerows, String hjsCustSvcPicTpCd,String ofcCd,  String ioBndCd, String cust, String custNm, String autoInvHjsRefNo, String autoInvCustRefNoFlg, String autoInvLoclChgFlg, String autoInvEml, String updDt, String updUsrId) {
		this.hjsCustSvcPicTpCd = hjsCustSvcPicTpCd;
		this.ofcCd = ofcCd;
		this.ioBndCd = ioBndCd;
		this.cust = cust;
		this.custNm = custNm;
		this.autoInvHjsRefNo = autoInvHjsRefNo;
		this.autoInvCustRefNoFlg = autoInvCustRefNoFlg;
		this.autoInvLoclChgFlg = autoInvLoclChgFlg;
		this.autoInvEml = autoInvEml;
		this.updDt = updDt;
		this.updUsrId = updUsrId;
		this.ibflag = ibflag;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("hjs_cust_svc_pic_tp_cd", getHjsCustSvcPicTpCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("cust", getCust());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("auto_inv_hjs_ref_no", getAutoInvHjsRefNo());
		this.hashColumns.put("auto_inv_cust_ref_no_flg", getAutoInvCustRefNoFlg());
		this.hashColumns.put("auto_inv_locl_chg_flg", getAutoInvLoclChgFlg());
		this.hashColumns.put("auto_inv_eml", getAutoInvEml());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("hjs_cust_svc_pic_tp_cd", "hjsCustSvcPicTpCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("cust", "cust");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("auto_inv_hjs_ref_no", "autoInvHjsRefNo");
		this.hashFields.put("auto_inv_cust_ref_no_flg", "autoInvCustRefNoFlg");
		this.hashFields.put("auto_inv_locl_chg_flg", "autoInvLoclChgFlg");
		this.hashFields.put("auto_inv_eml", "autoInvEml");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return hjsCustSvcPicTpCd
	 */
	public String getHjsCustSvcPicTpCd() {
		return this.hjsCustSvcPicTpCd;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return cust
	 */
	public String getCust() {
		return this.cust;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return autoInvHjsRefNo
	 */
	public String getAutoInvHjsRefNo() {
		return this.autoInvHjsRefNo;
	}
	
	/**
	 * Column Info
	 * @return autoInvCustRefNoFlg
	 */
	public String getAutoInvCustRefNoFlg() {
		return this.autoInvCustRefNoFlg;
	}
	
	/**
	 * Column Info
	 * @return autoInvLoclChgFlg
	 */
	public String getAutoInvLoclChgFlg() {
		return this.autoInvLoclChgFlg;
	}
	
	/**
	 * Column Info
	 * @return autoInvEml
	 */
	public String getAutoInvEml() {
		return this.autoInvEml;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param hjsCustSvcPicTpCd
	 */
	public void setHjsCustSvcPicTpCd(String hjsCustSvcPicTpCd) {
		this.hjsCustSvcPicTpCd = hjsCustSvcPicTpCd;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param cust
	 */
	public void setCust(String cust) {
		this.cust = cust;
	}
	
	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param autoInvHjsRefNo
	 */
	public void setAutoInvHjsRefNo(String autoInvHjsRefNo) {
		this.autoInvHjsRefNo = autoInvHjsRefNo;
	}
	
	/**
	 * Column Info
	 * @param autoInvCustRefNoFlg
	 */
	public void setAutoInvCustRefNoFlg(String autoInvCustRefNoFlg) {
		this.autoInvCustRefNoFlg = autoInvCustRefNoFlg;
	}
	
	/**
	 * Column Info
	 * @param autoInvLoclChgFlg
	 */
	public void setAutoInvLoclChgFlg(String autoInvLoclChgFlg) {
		this.autoInvLoclChgFlg = autoInvLoclChgFlg;
	}
	
	/**
	 * Column Info
	 * @param autoInvEml
	 */
	public void setAutoInvEml(String autoInvEml) {
		this.autoInvEml = autoInvEml;
	}
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
		setHjsCustSvcPicTpCd(JSPUtil.getParameter(request, "hjs_cust_svc_pic_tp_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setCust(JSPUtil.getParameter(request, "cust", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setAutoInvHjsRefNo(JSPUtil.getParameter(request, "auto_inv_hjs_ref_no", ""));
		setAutoInvCustRefNoFlg(JSPUtil.getParameter(request, "auto_inv_cust_ref_no_flg", ""));
		setAutoInvLoclChgFlg(JSPUtil.getParameter(request, "auto_inv_locl_chg_flg", ""));
		setAutoInvEml(JSPUtil.getParameter(request, "auto_inv_eml", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AutoInvCustomerVO[]
	 */
	public AutoInvCustomerVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AutoInvCustomerVO[]
	 */
	public AutoInvCustomerVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AutoInvCustomerVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd".trim(), length));
			String[] hjsCustSvcPicTpCd = (JSPUtil.getParameter(request, prefix	+ "hjs_cust_svc_pic_tp_cd".trim(), length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd".trim(), length));
			String[] cust = (JSPUtil.getParameter(request, prefix	+ "cust".trim(), length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm".trim(), length));
			String[] autoInvHjsRefNo = (JSPUtil.getParameter(request, prefix	+ "auto_inv_hjs_ref_no".trim(), length));
			String[] autoInvCustRefNoFlg = (JSPUtil.getParameter(request, prefix	+ "auto_inv_cust_ref_no_flg".trim(), length));
			String[] autoInvLoclChgFlg = (JSPUtil.getParameter(request, prefix	+ "auto_inv_locl_chg_flg".trim(), length));
			String[] autoInvEml = (JSPUtil.getParameter(request, prefix	+ "auto_inv_eml".trim(), length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new AutoInvCustomerVO();
				if (hjsCustSvcPicTpCd[i] != null)
					model.setHjsCustSvcPicTpCd(hjsCustSvcPicTpCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (cust[i] != null)
					model.setCust(cust[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (autoInvHjsRefNo[i] != null)
					model.setAutoInvHjsRefNo(autoInvHjsRefNo[i]);
				if (autoInvCustRefNoFlg[i] != null)
					model.setAutoInvCustRefNoFlg(autoInvCustRefNoFlg[i]);
				if (autoInvLoclChgFlg[i] != null)
					model.setAutoInvLoclChgFlg(autoInvLoclChgFlg[i]);
				if (autoInvEml[i] != null)
					model.setAutoInvEml(autoInvEml[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAutoInvCustomerVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AutoInvCustomerVO[]
	 */
	public AutoInvCustomerVO[] getAutoInvCustomerVOs(){
		AutoInvCustomerVO[] vos = (AutoInvCustomerVO[])models.toArray(new AutoInvCustomerVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.hjsCustSvcPicTpCd = this.hjsCustSvcPicTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cust = this.cust .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoInvHjsRefNo = this.autoInvHjsRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoInvCustRefNoFlg = this.autoInvCustRefNoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoInvLoclChgFlg = this.autoInvLoclChgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoInvEml = this.autoInvEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvCprtCdConvVO.java
*@FileTitle : InvCprtCdConvVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.19
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.11.19 한동훈 
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

public class InvCprtCdConvVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvCprtCdConvVO> models = new ArrayList<InvCprtCdConvVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cdRmk = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String custConvCdCtnt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String cprtConvTpCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String hjsCdCtnt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InvCprtCdConvVO() {}

	public InvCprtCdConvVO(String ibflag, String pagerows, String scNo, String rfaNo, String cprtConvTpCd, String hjsCdCtnt, String custConvCdCtnt, String cdRmk, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.rfaNo = rfaNo;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.cdRmk = cdRmk;
		this.scNo = scNo;
		this.custConvCdCtnt = custConvCdCtnt;
		this.creDt = creDt;
		this.cprtConvTpCd = cprtConvTpCd;
		this.updUsrId = updUsrId;
		this.hjsCdCtnt = hjsCdCtnt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cd_rmk", getCdRmk());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("cust_conv_cd_ctnt", getCustConvCdCtnt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cprt_conv_tp_cd", getCprtConvTpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("hjs_cd_ctnt", getHjsCdCtnt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cd_rmk", "cdRmk");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("cust_conv_cd_ctnt", "custConvCdCtnt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cprt_conv_tp_cd", "cprtConvTpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("hjs_cd_ctnt", "hjsCdCtnt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return cdRmk
	 */
	public String getCdRmk() {
		return this.cdRmk;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return custConvCdCtnt
	 */
	public String getCustConvCdCtnt() {
		return this.custConvCdCtnt;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return cprtConvTpCd
	 */
	public String getCprtConvTpCd() {
		return this.cprtConvTpCd;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return hjsCdCtnt
	 */
	public String getHjsCdCtnt() {
		return this.hjsCdCtnt;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param cdRmk
	 */
	public void setCdRmk(String cdRmk) {
		this.cdRmk = cdRmk;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param custConvCdCtnt
	 */
	public void setCustConvCdCtnt(String custConvCdCtnt) {
		this.custConvCdCtnt = custConvCdCtnt;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param cprtConvTpCd
	 */
	public void setCprtConvTpCd(String cprtConvTpCd) {
		this.cprtConvTpCd = cprtConvTpCd;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param hjsCdCtnt
	 */
	public void setHjsCdCtnt(String hjsCdCtnt) {
		this.hjsCdCtnt = hjsCdCtnt;
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
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setRfaNo(JSPUtil.getParameter(request, "rfa_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCdRmk(JSPUtil.getParameter(request, "cd_rmk", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setCustConvCdCtnt(JSPUtil.getParameter(request, "cust_conv_cd_ctnt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setCprtConvTpCd(JSPUtil.getParameter(request, "cprt_conv_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setHjsCdCtnt(JSPUtil.getParameter(request, "hjs_cd_ctnt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvCprtCdConvVO[]
	 */
	public InvCprtCdConvVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvCprtCdConvVO[]
	 */
	public InvCprtCdConvVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvCprtCdConvVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cdRmk = (JSPUtil.getParameter(request, prefix	+ "cd_rmk", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] custConvCdCtnt = (JSPUtil.getParameter(request, prefix	+ "cust_conv_cd_ctnt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] cprtConvTpCd = (JSPUtil.getParameter(request, prefix	+ "cprt_conv_tp_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] hjsCdCtnt = (JSPUtil.getParameter(request, prefix	+ "hjs_cd_ctnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvCprtCdConvVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cdRmk[i] != null)
					model.setCdRmk(cdRmk[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (custConvCdCtnt[i] != null)
					model.setCustConvCdCtnt(custConvCdCtnt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (cprtConvTpCd[i] != null)
					model.setCprtConvTpCd(cprtConvTpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (hjsCdCtnt[i] != null)
					model.setHjsCdCtnt(hjsCdCtnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvCprtCdConvVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvCprtCdConvVO[]
	 */
	public InvCprtCdConvVO[] getInvCprtCdConvVOs(){
		InvCprtCdConvVO[] vos = (InvCprtCdConvVO[])models.toArray(new InvCprtCdConvVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cdRmk = this.cdRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custConvCdCtnt = this.custConvCdCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cprtConvTpCd = this.cprtConvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjsCdCtnt = this.hjsCdCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

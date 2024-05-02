/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceIssueDateVO.java
*@FileTitle : InvoiceIssueDateVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.06.02 박정진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박정진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InvoiceIssueDateVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvoiceIssueDateVO> models = new ArrayList<InvoiceIssueDateVO>();
	
	/* Column Info */
	private String office = null;
	/* Column Info */
	private String port = null;
	/* Column Info */
	private String blSrcNo = null;
	/* Column Info */
	private String scope = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String custSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String invClrFlg = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String revType = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String issOfcCd = null;
	/* Column Info */
	private String issToDt = null;
	/* Column Info */
	private String issFmDt = null;
	/* Column Info */
	private String bound = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String invType = null;
	/* Column Info */
	private String actInvNo = null;
	/* Column Info */
	private String svrId = null;
	/* Column Info */
	private String userOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InvoiceIssueDateVO() {}

	public InvoiceIssueDateVO(String ibflag, String pagerows, String invNo, String blSrcNo, String issFmDt, String issToDt, String custCntCd, String custSeq, String custNm, String revType, String vvd, String invClrFlg, String scope, String port, String bound, String issOfcCd, String usrId, String office, String invType, String actInvNo, String svrId, String userOfcCd) {
		this.office = office;
		this.port = port;
		this.blSrcNo = blSrcNo;
		this.scope = scope;
		this.custNm = custNm;
		this.custSeq = custSeq;
		this.pagerows = pagerows;
		this.invClrFlg = invClrFlg;
		this.invNo = invNo;
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.revType = revType;
		this.usrId = usrId;
		this.issOfcCd = issOfcCd;
		this.issToDt = issToDt;
		this.issFmDt = issFmDt;
		this.bound = bound;
		this.custCntCd = custCntCd;
		this.invType = invType;
		this.actInvNo = actInvNo;
		this.svrId = svrId;
		this.userOfcCd = userOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("office", getOffice());
		this.hashColumns.put("port", getPort());
		this.hashColumns.put("bl_src_no", getBlSrcNo());
		this.hashColumns.put("scope", getScope());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("inv_clr_flg", getInvClrFlg());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rev_type", getRevType());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("iss_ofc_cd", getIssOfcCd());
		this.hashColumns.put("iss_to_dt", getIssToDt());
		this.hashColumns.put("iss_fm_dt", getIssFmDt());
		this.hashColumns.put("bound", getBound());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("inv_type", getInvType());
		this.hashColumns.put("act_inv_no", getActInvNo());
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("user_ofc_cd", getUserOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("office", "office");
		this.hashFields.put("port", "port");
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("scope", "scope");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_clr_flg", "invClrFlg");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rev_type", "revType");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("iss_ofc_cd", "issOfcCd");
		this.hashFields.put("iss_to_dt", "issToDt");
		this.hashFields.put("iss_fm_dt", "issFmDt");
		this.hashFields.put("bound", "bound");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("inv_type", "invType");
		this.hashFields.put("act_inv_no", "actInvNo");
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("user_ofc_cd", "user_ofc_cd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return office
	 */
	public String getOffice() {
		return this.office;
	}
	
	/**
	 * Column Info
	 * @return port
	 */
	public String getPort() {
		return this.port;
	}
	
	/**
	 * Column Info
	 * @return blSrcNo
	 */
	public String getBlSrcNo() {
		return this.blSrcNo;
	}
	
	/**
	 * Column Info
	 * @return scope
	 */
	public String getScope() {
		return this.scope;
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
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
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
	 * @return invClrFlg
	 */
	public String getInvClrFlg() {
		return this.invClrFlg;
	}
	
	/**
	 * Column Info
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return revType
	 */
	public String getRevType() {
		return this.revType;
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
	 * @return issOfcCd
	 */
	public String getIssOfcCd() {
		return this.issOfcCd;
	}
	
	/**
	 * Column Info
	 * @return issToDt
	 */
	public String getIssToDt() {
		return this.issToDt;
	}
	
	/**
	 * Column Info
	 * @return issFmDt
	 */
	public String getIssFmDt() {
		return this.issFmDt;
	}
	
	/**
	 * Column Info
	 * @return bound
	 */
	public String getBound() {
		return this.bound;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	

	/**
	 * Column Info
	 * @param office
	 */
	public void setOffice(String office) {
		this.office = office;
	}
	
	/**
	 * Column Info
	 * @param port
	 */
	public void setPort(String port) {
		this.port = port;
	}
	
	/**
	 * Column Info
	 * @param blSrcNo
	 */
	public void setBlSrcNo(String blSrcNo) {
		this.blSrcNo = blSrcNo;
	}
	
	/**
	 * Column Info
	 * @param scope
	 */
	public void setScope(String scope) {
		this.scope = scope;
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
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
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
	 * @param invClrFlg
	 */
	public void setInvClrFlg(String invClrFlg) {
		this.invClrFlg = invClrFlg;
	}
	
	/**
	 * Column Info
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param revType
	 */
	public void setRevType(String revType) {
		this.revType = revType;
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
	 * @param issOfcCd
	 */
	public void setIssOfcCd(String issOfcCd) {
		this.issOfcCd = issOfcCd;
	}
	
	/**
	 * Column Info
	 * @param issToDt
	 */
	public void setIssToDt(String issToDt) {
		this.issToDt = issToDt;
	}
	
	/**
	 * Column Info
	 * @param issFmDt
	 */
	public void setIssFmDt(String issFmDt) {
		this.issFmDt = issFmDt;
	}
	
	/**
	 * Column Info
	 * @param bound
	 */
	public void setBound(String bound) {
		this.bound = bound;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	public String getInvType() {
		return invType;
	}

	public void setInvType(String invType) {
		this.invType = invType;
	}

	public String getActInvNo() {
		return actInvNo;
	}

	public void setActInvNo(String actInvNo) {
		this.actInvNo = actInvNo;
	}

	public String getSvrId() {
		return svrId;
	}

	public void setSvrId(String svrId) {
		this.svrId = svrId;
	}

	public String getUserOfcCd() {
		return userOfcCd;
	}

	public void setUserOfcCd(String userOfcCd) {
		this.userOfcCd = userOfcCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setOffice(JSPUtil.getParameter(request, "office", ""));
		setPort(JSPUtil.getParameter(request, "port", ""));
		setBlSrcNo(JSPUtil.getParameter(request, "bl_src_no", ""));
		setScope(JSPUtil.getParameter(request, "scope", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setInvClrFlg(JSPUtil.getParameter(request, "inv_clr_flg", ""));
		setInvNo(JSPUtil.getParameter(request, "inv_no", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRevType(JSPUtil.getParameter(request, "rev_type", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setIssOfcCd(JSPUtil.getParameter(request, "iss_ofc_cd", ""));
		setIssToDt(JSPUtil.getParameter(request, "iss_to_dt", ""));
		setIssFmDt(JSPUtil.getParameter(request, "iss_fm_dt", ""));
		setBound(JSPUtil.getParameter(request, "bound", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setInvType(JSPUtil.getParameter(request, "inv_type", ""));
		setActInvNo(JSPUtil.getParameter(request, "act_inv_no", ""));
		setSvrId(JSPUtil.getParameter(request, "svr_id", ""));
		setUserOfcCd(JSPUtil.getParameter(request, "user_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvoiceIssueDateVO[]
	 */
	public InvoiceIssueDateVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvoiceIssueDateVO[]
	 */
	public InvoiceIssueDateVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvoiceIssueDateVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] office = (JSPUtil.getParameter(request, prefix	+ "office".trim(), length));
			String[] port = (JSPUtil.getParameter(request, prefix	+ "port".trim(), length));
			String[] blSrcNo = (JSPUtil.getParameter(request, prefix	+ "bl_src_no".trim(), length));
			String[] scope = (JSPUtil.getParameter(request, prefix	+ "scope".trim(), length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm".trim(), length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] invClrFlg = (JSPUtil.getParameter(request, prefix	+ "inv_clr_flg".trim(), length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no".trim(), length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] revType = (JSPUtil.getParameter(request, prefix	+ "rev_type".trim(), length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id".trim(), length));
			String[] issOfcCd = (JSPUtil.getParameter(request, prefix	+ "iss_ofc_cd".trim(), length));
			String[] issToDt = (JSPUtil.getParameter(request, prefix	+ "iss_to_dt".trim(), length));
			String[] issFmDt = (JSPUtil.getParameter(request, prefix	+ "iss_fm_dt".trim(), length));
			String[] bound = (JSPUtil.getParameter(request, prefix	+ "bound".trim(), length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd".trim(), length));
			String[] invType = (JSPUtil.getParameter(request, prefix	+ "inv_type".trim(), length));
			String[] actInvNo = (JSPUtil.getParameter(request, prefix	+ "act_inv_no".trim(), length));
			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id".trim(), length));
			String[] userOfcCd = (JSPUtil.getParameter(request, prefix	+ "user_ofc_cd".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new InvoiceIssueDateVO();
				if (office[i] != null)
					model.setOffice(office[i]);
				if (port[i] != null)
					model.setPort(port[i]);
				if (blSrcNo[i] != null)
					model.setBlSrcNo(blSrcNo[i]);
				if (scope[i] != null)
					model.setScope(scope[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (invClrFlg[i] != null)
					model.setInvClrFlg(invClrFlg[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (revType[i] != null)
					model.setRevType(revType[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (issOfcCd[i] != null)
					model.setIssOfcCd(issOfcCd[i]);
				if (issToDt[i] != null)
					model.setIssToDt(issToDt[i]);
				if (issFmDt[i] != null)
					model.setIssFmDt(issFmDt[i]);
				if (bound[i] != null)
					model.setBound(bound[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (invType[i] != null)
					model.setInvType(invType[i]);
				if (actInvNo[i] != null)
					model.setActInvNo(actInvNo[i]);
				if (svrId[i] != null)
					model.setSvrId(svrId[i]);
				if (userOfcCd[i] != null)
					model.setUserOfcCd(userOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvoiceIssueDateVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvoiceIssueDateVO[]
	 */
	public InvoiceIssueDateVO[] getInvoiceIssueDateVOs(){
		InvoiceIssueDateVO[] vos = (InvoiceIssueDateVO[])models.toArray(new InvoiceIssueDateVO[models.size()]);
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
		this.office = this.office .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port = this.port .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrcNo = this.blSrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scope = this.scope .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invClrFlg = this.invClrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revType = this.revType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issOfcCd = this.issOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issToDt = this.issToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issFmDt = this.issFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bound = this.bound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invType = this.invType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actInvNo = this.actInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrId = this.svrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userOfcCd = this.userOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

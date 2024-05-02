/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : printInvoiceVO.java
*@FileTitle : printInvoiceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.07.02 정휘택 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo;

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
 * @author 정휘택
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PrintInvoiceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PrintInvoiceVO> models = new ArrayList<PrintInvoiceVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String flag = null;
	/* Column Info */
	private String userOfc = null;
	/* Column Info */
	private String fInv = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String invs = null;
	/* Column Info */
	private String ifNo = null;
	/* Column Info */
	private String tInv = null;
	/* Column Info */
	private String issOfcCd = null;
	/* Column Info */
	private String issueGubn = null;
	/* Column Info */
	private String otsSmryCd = null;
	/* Column Info */
	private String prevFlg = null;
	/* Column Info */
	private String gotoFlg = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PrintInvoiceVO() {}

	public PrintInvoiceVO(String ibflag, String pagerows, String flag, String fInv, String tInv, String issOfcCd, String issueGubn, String invs, String userOfc, String userId, String otsSmryCd, String prevFlg, String gotoFlg, String ifNo) {
		this.ibflag = ibflag;
		this.flag = flag;
		this.userOfc = userOfc;
		this.fInv = fInv;
		this.userId = userId;
		this.invs = invs;
		this.tInv = tInv;
		this.issOfcCd = issOfcCd;
		this.issueGubn = issueGubn;
		this.otsSmryCd = otsSmryCd;
		this.prevFlg = prevFlg;
		this.gotoFlg = gotoFlg;
		this.pagerows = pagerows;
		this.ifNo = ifNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("flag", getFlag());
		this.hashColumns.put("user_ofc", getUserOfc());
		this.hashColumns.put("f_inv", getFInv());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("invs", getInvs());
		this.hashColumns.put("t_inv", getTInv());
		this.hashColumns.put("iss_ofc_cd", getIssOfcCd());
		this.hashColumns.put("issue_gubn", getIssueGubn());
		this.hashColumns.put("ots_smry_cd", getOtsSmryCd());
		this.hashColumns.put("prev_flg", getPrevFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("if_no", getIfNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("flag", "flag");
		this.hashFields.put("user_ofc", "userOfc");
		this.hashFields.put("f_inv", "fInv");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("invs", "invs");
		this.hashFields.put("t_inv", "tInv");
		this.hashFields.put("iss_ofc_cd", "issOfcCd");
		this.hashFields.put("issue_gubn", "issueGubn");
		this.hashFields.put("ots_smry_cd", "otsSmryCd");
		this.hashFields.put("prev_flg", "prevFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("if_no", "ifNo");
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
	 * @return flag
	 */
	public String getFlag() {
		return this.flag;
	}
	
	/**
	 * Column Info
	 * @return userOfc
	 */
	public String getUserOfc() {
		return this.userOfc;
	}
	
	/**
	 * Column Info
	 * @return fInv
	 */
	public String getFInv() {
		return this.fInv;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return invs
	 */
	public String getInvs() {
		return this.invs;
	}
	
	/**
	 * Column Info
	 * @return tInv
	 */
	public String getTInv() {
		return this.tInv;
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
	 * @param flag
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	/**
	 * Column Info
	 * @param userOfc
	 */
	public void setUserOfc(String userOfc) {
		this.userOfc = userOfc;
	}
	
	/**
	 * Column Info
	 * @param fInv
	 */
	public void setFInv(String fInv) {
		this.fInv = fInv;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param invs
	 */
	public void setInvs(String invs) {
		this.invs = invs;
	}
	
	/**
	 * Column Info
	 * @param tInv
	 */
	public void setTInv(String tInv) {
		this.tInv = tInv;
	}
	
	/**
	 * @return the issOfcCd
	 */
	public String getIssOfcCd() {
		return issOfcCd;
	}

	/**
	 * @param issOfcCd the issOfcCd to set
	 */
	public void setIssOfcCd(String issOfcCd) {
		this.issOfcCd = issOfcCd;
	}

	/**
	 * @return the issueGubn
	 */
	public String getIssueGubn() {
		return issueGubn;
	}

	/**
	 * @param issueGubn the issueGubn to set
	 */
	public void setIssueGubn(String issueGubn) {
		this.issueGubn = issueGubn;
	}

	/**
	 * @return the otsSmryCd
	 */
	public String getOtsSmryCd() {
		return otsSmryCd;
	}

	/**
	 * @param otsSmryCd the otsSmryCd to set
	 */
	public void setOtsSmryCd(String otsSmryCd) {
		this.otsSmryCd = otsSmryCd;
	}

	/**
	 * @return the prevFlg
	 */
	public String getPrevFlg() {
		return prevFlg;
	}

	/**
	 * @param prevFlg the prevFlg to set
	 */
	public void setPrevFlg(String prevFlg) {
		this.prevFlg = prevFlg;
	}

	/**
	 * @return the gotoFlg
	 */
	public String getGotoFlg() {
		return gotoFlg;
	}

	/**
	 * @param gotoFlg the gotoFlg to set
	 */
	public void setGotoFlg(String gotoFlg) {
		this.gotoFlg = gotoFlg;
	}

	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	
	/**
	 * @return the ifNo
	 */
	public String getIfNo() {
		return ifNo;
	}

	/**
	 * @param ifNo the ifNo to set
	 */
	public void setIfNo(String ifNo) {
		this.ifNo = ifNo;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFlag(JSPUtil.getParameter(request, "flag", ""));
		setUserOfc(JSPUtil.getParameter(request, "user_ofc", ""));
		setFInv(JSPUtil.getParameter(request, "f_inv", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setInvs(JSPUtil.getParameter(request, "invs", ""));
		setTInv(JSPUtil.getParameter(request, "t_inv", ""));
		setIssOfcCd(JSPUtil.getParameter(request, "iss_ofc_cd", ""));
		setIssueGubn(JSPUtil.getParameter(request, "issue_gubn", ""));
		setOtsSmryCd(JSPUtil.getParameter(request, "ots_smry_cd", ""));
		setPrevFlg(JSPUtil.getParameter(request, "prev_flg", ""));
		setGotoFlg(JSPUtil.getParameter(request, "goto_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIfNo(JSPUtil.getParameter(request, "if_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return printInvoiceVO[]
	 */
	public PrintInvoiceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return printInvoiceVO[]
	 */
	public PrintInvoiceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PrintInvoiceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] flag = (JSPUtil.getParameter(request, prefix	+ "flag", length));
			String[] userOfc = (JSPUtil.getParameter(request, prefix	+ "user_ofc", length));
			String[] fInv = (JSPUtil.getParameter(request, prefix	+ "f_inv", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] invs = (JSPUtil.getParameter(request, prefix	+ "invs", length));
			String[] tInv = (JSPUtil.getParameter(request, prefix	+ "t_inv", length));
			String[] issOfcCd = (JSPUtil.getParameter(request, prefix	+ "iss_ofc_cd", length));
			String[] issueGubn = (JSPUtil.getParameter(request, prefix	+ "issue_gubn", length));
			String[] otsSmryCd = (JSPUtil.getParameter(request, prefix	+ "ots_smry_cd", length));
			String[] prevFlg = (JSPUtil.getParameter(request, prefix	+ "prev_flg", length));
			String[] gotoFlg = (JSPUtil.getParameter(request, prefix	+ "goto_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ifNo = (JSPUtil.getParameter(request, prefix	+ "if_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new PrintInvoiceVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (flag[i] != null)
					model.setFlag(flag[i]);
				if (userOfc[i] != null)
					model.setUserOfc(userOfc[i]);
				if (fInv[i] != null)
					model.setFInv(fInv[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (invs[i] != null)
					model.setInvs(invs[i]);
				if (tInv[i] != null)
					model.setTInv(tInv[i]);
				if (issOfcCd[i] != null)
					model.setIssOfcCd(issOfcCd[i]);
				if (issueGubn[i] != null)
					model.setIssueGubn(issueGubn[i]);
				if (otsSmryCd[i] != null)
					model.setOtsSmryCd(otsSmryCd[i]);
				if (prevFlg[i] != null)
					model.setPrevFlg(prevFlg[i]);
				if (gotoFlg[i] != null)
					model.setGotoFlg(gotoFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ifNo[i] != null)
					model.setIfNo(ifNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getprintInvoiceVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return printInvoiceVO[]
	 */
	public PrintInvoiceVO[] getprintInvoiceVOs(){
		PrintInvoiceVO[] vos = (PrintInvoiceVO[])models.toArray(new PrintInvoiceVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flag = this.flag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userOfc = this.userOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fInv = this.fInv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invs = this.invs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tInv = this.tInv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issOfcCd = this.issOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issueGubn = this.issueGubn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsSmryCd = this.otsSmryCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prevFlg = this.prevFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gotoFlg = this.gotoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifNo = this.ifNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

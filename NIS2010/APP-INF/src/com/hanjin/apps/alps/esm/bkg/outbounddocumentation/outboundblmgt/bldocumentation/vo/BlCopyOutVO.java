/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : searchForCopyBlVO.java
*@FileTitle : searchForCopyBlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 이일민
*@LastVersion : 1.0
* 2009.08.24 이일민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo;

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
 * @author 이일민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BlCopyOutVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BlCopyOutVO> models = new ArrayList<BlCopyOutVO>();
	
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String repCmdtCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Page Number */
	private String pagerows = null;
	private String custFlg = null;
	private String markFlg = null;
	private String descFlg = null;

	private String bkgStatus = null;
	private String bdrFlg = null;
	private String shprCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BlCopyOutVO() {}

	public BlCopyOutVO(String ibflag, String pagerows, String bkgNo, String custCntCd, String custSeq, String custNm, String cmdtCd, String repCmdtCd, String cmdtNm,
			String custFlg, String markFlg, String descFlg, String bkgStatus, String bdrFlg, String shprCd) {
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.custNm = custNm;
		this.cmdtCd = cmdtCd;
		this.custSeq = custSeq;
		this.cmdtNm = cmdtNm;
		this.repCmdtCd = repCmdtCd;
		this.custCntCd = custCntCd;
		this.pagerows = pagerows;
		this.custFlg = custFlg;
		this.markFlg = markFlg;
		this.descFlg = descFlg;
		this.bkgStatus = bkgStatus;
		this.bdrFlg = bdrFlg;
		this.shprCd = shprCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("rep_cmdt_cd", getRepCmdtCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("custFlg", getCustFlg());
		this.hashColumns.put("markFlg", getMarkFlg());
		this.hashColumns.put("descFlg", getDescFlg());
		this.hashColumns.put("bkgStatus", getBkgStatus());
		this.hashColumns.put("bdrFlg", getBdrFlg());
		this.hashColumns.put("shprCd", getShprCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("rep_cmdt_cd", "repCmdtCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("custFlg", "custFlg");
		this.hashFields.put("markFlg", "markFlg");
		this.hashFields.put("descFlg", "descFlg");
		this.hashFields.put("bkgStatus", "bkgStatus");
		this.hashFields.put("bdrFlg", "bdrFlg");
		this.hashFields.put("shprCd", "shprCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
	}
	
	/**
	 * Column Info
	 * @return repCmdtCd
	 */
	public String getRepCmdtCd() {
		return this.repCmdtCd;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	public String getCustFlg() {
		return custFlg;
	}

	public String getMarkFlg() {
		return markFlg;
	}

	public String getDescFlg() {
		return descFlg;
	}

	public String getBkgStatus() {
		return this.bkgStatus;
	}

	public String getBdrFlg() {
		return this.bdrFlg;
	}

	public String getShprCd() {
		return this.shprCd;
	}

	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
	}
	
	/**
	 * Column Info
	 * @param repCmdtCd
	 */
	public void setRepCmdtCd(String repCmdtCd) {
		this.repCmdtCd = repCmdtCd;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	public void setCustFlg(String custFlg) {
		this.custFlg = custFlg;
	}

	public void setMarkFlg(String markFlg) {
		this.markFlg = markFlg;
	}

	public void setDescFlg(String descFlg) {
		this.descFlg = descFlg;
	}

	public void setBkgStatus(String bkgStatus) {
		this.bkgStatus = bkgStatus;
	}

	public void setBdrFlg(String bdrFlg) {
		this.bdrFlg = bdrFlg;
	}

	public void setShprCd(String shprCd) {
		this.shprCd = shprCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setCmdtCd(JSPUtil.getParameter(request, "cmdt_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setCmdtNm(JSPUtil.getParameter(request, "cmdt_nm", ""));
		setRepCmdtCd(JSPUtil.getParameter(request, "rep_cmdt_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCustFlg(JSPUtil.getParameter(request, "custFlg", ""));
		setMarkFlg(JSPUtil.getParameter(request, "markFlg", ""));
		setDescFlg(JSPUtil.getParameter(request, "descFlg", ""));
		setBkgStatus(JSPUtil.getParameter(request, "bkgStatus", ""));
		setBdrFlg(JSPUtil.getParameter(request, "bdrFlg", ""));
		setShprCd(JSPUtil.getParameter(request, "shprCd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BlCopyOutVO[]
	 */
	public BlCopyOutVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BlCopyOutVO[]
	 */
	public BlCopyOutVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BlCopyOutVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] repCmdtCd = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] custFlg = (JSPUtil.getParameter(request, prefix	+ "custFlg", length));
			String[] markFlg = (JSPUtil.getParameter(request, prefix	+ "markFlg", length));
			String[] descFlg = (JSPUtil.getParameter(request, prefix	+ "descFlg", length));
			String[] bkgStatus = (JSPUtil.getParameter(request, prefix	+ "bkgStatus", length));
			String[] bdrFlg = (JSPUtil.getParameter(request, prefix	+ "bdrFlg", length));
			String[] shprCd = (JSPUtil.getParameter(request, prefix	+ "shprCd", length));

			for (int i = 0; i < length; i++) {
				model = new BlCopyOutVO();
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (repCmdtCd[i] != null)
					model.setRepCmdtCd(repCmdtCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (custFlg[i] != null)
					model.setCustFlg(custFlg[i]);
				if (markFlg[i] != null)
					model.setMarkFlg(markFlg[i]);
				if (descFlg[i] != null)
					model.setDescFlg(descFlg[i]);
				if (bkgStatus[i] != null)
					model.setBkgStatus(bkgStatus[i]);
				if (bdrFlg[i] != null)
					model.setBdrFlg(bdrFlg[i]);
				if (shprCd[i] != null)
					model.setShprCd(shprCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBlCopyOutVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BlCopyOutVO[]
	 */
	public BlCopyOutVO[] getBlCopyOutVOs(){
		BlCopyOutVO[] vos = (BlCopyOutVO[])models.toArray(new BlCopyOutVO[models.size()]);
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
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtCd = this.repCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custFlg = this.custFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.markFlg = this.markFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.descFlg = this.descFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStatus = this.bkgStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrFlg = this.bdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCd = this.shprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

}

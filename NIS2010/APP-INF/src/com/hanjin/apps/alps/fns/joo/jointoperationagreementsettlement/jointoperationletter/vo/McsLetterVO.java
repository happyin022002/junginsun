/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : McsLetterVO.java
*@FileTitle : McsLetterVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.10.09 장강철 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo;

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
 * @author 장강철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class McsLetterVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<McsLetterVO> models = new ArrayList<McsLetterVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String n3rdStmtCtnt = null;
	/* Column Info */
	private String sigStmtCtnt = null;
	/* Column Info */
	private String n2ndStmtCtnt = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bankStmtCtnt = null;
	/* Column Info */
	private String joTmpltNo = null;
	/* Column Info */
	private String joLtrTpCd = null;
	/* Column Info */
	private String jointOperationLetterTemplat = null;
	/* Column Info */
	private String n1stStmtCtnt = null;
	/* Column Info */
	private String ofcAddr = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public McsLetterVO() {}

	public McsLetterVO(String ibflag, String pagerows, String jointOperationLetterTemplat, String ofcCd, String joTmpltNo, String joLtrTpCd, String ofcAddr, String n1stStmtCtnt, String n2ndStmtCtnt, String n3rdStmtCtnt, String sigStmtCtnt, String creDt, String creUsrId, String updDt, String updUsrId, String custLglEngNm, String bankStmtCtnt) {
		this.updDt = updDt;
		this.creDt = creDt;
		this.n3rdStmtCtnt = n3rdStmtCtnt;
		this.sigStmtCtnt = sigStmtCtnt;
		this.n2ndStmtCtnt = n2ndStmtCtnt;
		this.custLglEngNm = custLglEngNm;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.bankStmtCtnt = bankStmtCtnt;
		this.joTmpltNo = joTmpltNo;
		this.joLtrTpCd = joLtrTpCd;
		this.jointOperationLetterTemplat = jointOperationLetterTemplat;
		this.n1stStmtCtnt = n1stStmtCtnt;
		this.ofcAddr = ofcAddr;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("n3rd_stmt_ctnt", getN3rdStmtCtnt());
		this.hashColumns.put("sig_stmt_ctnt", getSigStmtCtnt());
		this.hashColumns.put("n2nd_stmt_ctnt", getN2ndStmtCtnt());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bank_stmt_ctnt", getBankStmtCtnt());
		this.hashColumns.put("jo_tmplt_no", getJoTmpltNo());
		this.hashColumns.put("jo_ltr_tp_cd", getJoLtrTpCd());
		this.hashColumns.put("joint_operation_letter_templat", getJointOperationLetterTemplat());
		this.hashColumns.put("n1st_stmt_ctnt", getN1stStmtCtnt());
		this.hashColumns.put("ofc_addr", getOfcAddr());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("n3rd_stmt_ctnt", "n3rdStmtCtnt");
		this.hashFields.put("sig_stmt_ctnt", "sigStmtCtnt");
		this.hashFields.put("n2nd_stmt_ctnt", "n2ndStmtCtnt");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bank_stmt_ctnt", "bankStmtCtnt");
		this.hashFields.put("jo_tmplt_no", "joTmpltNo");
		this.hashFields.put("jo_ltr_tp_cd", "joLtrTpCd");
		this.hashFields.put("joint_operation_letter_templat", "jointOperationLetterTemplat");
		this.hashFields.put("n1st_stmt_ctnt", "n1stStmtCtnt");
		this.hashFields.put("ofc_addr", "ofcAddr");
		this.hashFields.put("upd_usr_id", "updUsrId");
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return n3rdStmtCtnt
	 */
	public String getN3rdStmtCtnt() {
		return this.n3rdStmtCtnt;
	}
	
	/**
	 * Column Info
	 * @return sigStmtCtnt
	 */
	public String getSigStmtCtnt() {
		return this.sigStmtCtnt;
	}
	
	/**
	 * Column Info
	 * @return n2ndStmtCtnt
	 */
	public String getN2ndStmtCtnt() {
		return this.n2ndStmtCtnt;
	}
	
	/**
	 * Column Info
	 * @return custLglEngNm
	 */
	public String getCustLglEngNm() {
		return this.custLglEngNm;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return bankStmtCtnt
	 */
	public String getBankStmtCtnt() {
		return this.bankStmtCtnt;
	}
	
	/**
	 * Column Info
	 * @return joTmpltNo
	 */
	public String getJoTmpltNo() {
		return this.joTmpltNo;
	}
	
	/**
	 * Column Info
	 * @return joLtrTpCd
	 */
	public String getJoLtrTpCd() {
		return this.joLtrTpCd;
	}
	
	/**
	 * Column Info
	 * @return jointOperationLetterTemplat
	 */
	public String getJointOperationLetterTemplat() {
		return this.jointOperationLetterTemplat;
	}
	
	/**
	 * Column Info
	 * @return n1stStmtCtnt
	 */
	public String getN1stStmtCtnt() {
		return this.n1stStmtCtnt;
	}
	
	/**
	 * Column Info
	 * @return ofcAddr
	 */
	public String getOfcAddr() {
		return this.ofcAddr;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * @param n3rdStmtCtnt
	 */
	public void setN3rdStmtCtnt(String n3rdStmtCtnt) {
		this.n3rdStmtCtnt = n3rdStmtCtnt;
	}
	
	/**
	 * Column Info
	 * @param sigStmtCtnt
	 */
	public void setSigStmtCtnt(String sigStmtCtnt) {
		this.sigStmtCtnt = sigStmtCtnt;
	}
	
	/**
	 * Column Info
	 * @param n2ndStmtCtnt
	 */
	public void setN2ndStmtCtnt(String n2ndStmtCtnt) {
		this.n2ndStmtCtnt = n2ndStmtCtnt;
	}
	
	/**
	 * Column Info
	 * @param custLglEngNm
	 */
	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param bankStmtCtnt
	 */
	public void setBankStmtCtnt(String bankStmtCtnt) {
		this.bankStmtCtnt = bankStmtCtnt;
	}
	
	/**
	 * Column Info
	 * @param joTmpltNo
	 */
	public void setJoTmpltNo(String joTmpltNo) {
		this.joTmpltNo = joTmpltNo;
	}
	
	/**
	 * Column Info
	 * @param joLtrTpCd
	 */
	public void setJoLtrTpCd(String joLtrTpCd) {
		this.joLtrTpCd = joLtrTpCd;
	}
	
	/**
	 * Column Info
	 * @param jointOperationLetterTemplat
	 */
	public void setJointOperationLetterTemplat(String jointOperationLetterTemplat) {
		this.jointOperationLetterTemplat = jointOperationLetterTemplat;
	}
	
	/**
	 * Column Info
	 * @param n1stStmtCtnt
	 */
	public void setN1stStmtCtnt(String n1stStmtCtnt) {
		this.n1stStmtCtnt = n1stStmtCtnt;
	}
	
	/**
	 * Column Info
	 * @param ofcAddr
	 */
	public void setOfcAddr(String ofcAddr) {
		this.ofcAddr = ofcAddr;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setN3rdStmtCtnt(JSPUtil.getParameter(request, "n3rd_stmt_ctnt", ""));
		setSigStmtCtnt(JSPUtil.getParameter(request, "sig_stmt_ctnt", ""));
		setN2ndStmtCtnt(JSPUtil.getParameter(request, "n2nd_stmt_ctnt", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, "cust_lgl_eng_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setBankStmtCtnt(JSPUtil.getParameter(request, "bank_stmt_ctnt", ""));
		setJoTmpltNo(JSPUtil.getParameter(request, "jo_tmplt_no", ""));
		setJoLtrTpCd(JSPUtil.getParameter(request, "jo_ltr_tp_cd", ""));
		setJointOperationLetterTemplat(JSPUtil.getParameter(request, "joint_operation_letter_templat", ""));
		setN1stStmtCtnt(JSPUtil.getParameter(request, "n1st_stmt_ctnt", ""));
		setOfcAddr(JSPUtil.getParameter(request, "ofc_addr", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return McsLetterVO[]
	 */
	public McsLetterVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return McsLetterVO[]
	 */
	public McsLetterVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		McsLetterVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] n3rdStmtCtnt = (JSPUtil.getParameter(request, prefix	+ "n3rd_stmt_ctnt", length));
			String[] sigStmtCtnt = (JSPUtil.getParameter(request, prefix	+ "sig_stmt_ctnt", length));
			String[] n2ndStmtCtnt = (JSPUtil.getParameter(request, prefix	+ "n2nd_stmt_ctnt", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bankStmtCtnt = (JSPUtil.getParameter(request, prefix	+ "bank_stmt_ctnt", length));
			String[] joTmpltNo = (JSPUtil.getParameter(request, prefix	+ "jo_tmplt_no", length));
			String[] joLtrTpCd = (JSPUtil.getParameter(request, prefix	+ "jo_ltr_tp_cd", length));
			String[] jointOperationLetterTemplat = (JSPUtil.getParameter(request, prefix	+ "joint_operation_letter_templat", length));
			String[] n1stStmtCtnt = (JSPUtil.getParameter(request, prefix	+ "n1st_stmt_ctnt", length));
			String[] ofcAddr = (JSPUtil.getParameter(request, prefix	+ "ofc_addr", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new McsLetterVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (n3rdStmtCtnt[i] != null)
					model.setN3rdStmtCtnt(n3rdStmtCtnt[i]);
				if (sigStmtCtnt[i] != null)
					model.setSigStmtCtnt(sigStmtCtnt[i]);
				if (n2ndStmtCtnt[i] != null)
					model.setN2ndStmtCtnt(n2ndStmtCtnt[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bankStmtCtnt[i] != null)
					model.setBankStmtCtnt(bankStmtCtnt[i]);
				if (joTmpltNo[i] != null)
					model.setJoTmpltNo(joTmpltNo[i]);
				if (joLtrTpCd[i] != null)
					model.setJoLtrTpCd(joLtrTpCd[i]);
				if (jointOperationLetterTemplat[i] != null)
					model.setJointOperationLetterTemplat(jointOperationLetterTemplat[i]);
				if (n1stStmtCtnt[i] != null)
					model.setN1stStmtCtnt(n1stStmtCtnt[i]);
				if (ofcAddr[i] != null)
					model.setOfcAddr(ofcAddr[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMcsLetterVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return McsLetterVO[]
	 */
	public McsLetterVO[] getMcsLetterVOs(){
		McsLetterVO[] vos = (McsLetterVO[])models.toArray(new McsLetterVO[models.size()]);
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
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdStmtCtnt = this.n3rdStmtCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sigStmtCtnt = this.sigStmtCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndStmtCtnt = this.n2ndStmtCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankStmtCtnt = this.bankStmtCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joTmpltNo = this.joTmpltNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joLtrTpCd = this.joLtrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jointOperationLetterTemplat = this.jointOperationLetterTemplat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stStmtCtnt = this.n1stStmtCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcAddr = this.ofcAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

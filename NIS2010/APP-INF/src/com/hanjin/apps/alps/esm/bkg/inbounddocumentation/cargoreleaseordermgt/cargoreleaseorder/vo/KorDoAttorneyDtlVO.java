/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorDoAttorneyDtlVO.java
*@FileTitle : KorDoAttorneyDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.12
*@LastModifier : 임진영
*@LastVersion : 1.0
* 2009.06.12 임진영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

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
 * @author 임진영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorDoAttorneyDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorDoAttorneyDtlVO> models = new ArrayList<KorDoAttorneyDtlVO>();
	
	/* Column Info */
	private String currentDt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String rgstUsrId = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String fmAttyBizNo = null;
	/* Column Info */
	private String acctFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fmAttyBizNm = null;
	/* Column Info */
	private String toAttyBizNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String toAttyBizNm = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String rgstOfcCd = null;
	/* Column Info */
	private String custName = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String updUsrNm = null;
	/* Column Info */
	private String custBizNo = null;
	/* Column Info */
	private String dupCnt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String rgstDt = null;
	/* Column Info */
	private String custType = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KorDoAttorneyDtlVO() {}

	public KorDoAttorneyDtlVO(String ibflag, String pagerows, String fmAttyBizNo, String fmAttyBizNm, String toAttyBizNo, String toAttyBizNm, String effDt, String expDt, String acctFlg, String diffRmk, String rgstOfcCd, String rgstDt, String rgstUsrId, String updOfcCd, String creUsrId, String creDt, String updUsrId, String updUsrNm, String updDt, String dupCnt, String currentDt, String custType, String custName, String custBizNo) {
		this.currentDt = currentDt;
		this.updDt = updDt;
		this.rgstUsrId = rgstUsrId;
		this.creDt = creDt;
		this.fmAttyBizNo = fmAttyBizNo;
		this.acctFlg = acctFlg;
		this.pagerows = pagerows;
		this.fmAttyBizNm = fmAttyBizNm;
		this.toAttyBizNo = toAttyBizNo;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.toAttyBizNm = toAttyBizNm;
		this.effDt = effDt;
		this.diffRmk = diffRmk;
		this.rgstOfcCd = rgstOfcCd;
		this.custName = custName;
		this.expDt = expDt;
		this.updUsrNm = updUsrNm;
		this.custBizNo = custBizNo;
		this.dupCnt = dupCnt;
		this.updUsrId = updUsrId;
		this.updOfcCd = updOfcCd;
		this.rgstDt = rgstDt;
		this.custType = custType;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("current_dt", getCurrentDt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rgst_usr_id", getRgstUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("fm_atty_biz_no", getFmAttyBizNo());
		this.hashColumns.put("acct_flg", getAcctFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fm_atty_biz_nm", getFmAttyBizNm());
		this.hashColumns.put("to_atty_biz_no", getToAttyBizNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("to_atty_biz_nm", getToAttyBizNm());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("rgst_ofc_cd", getRgstOfcCd());
		this.hashColumns.put("cust_name", getCustName());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("upd_usr_nm", getUpdUsrNm());
		this.hashColumns.put("cust_biz_no", getCustBizNo());
		this.hashColumns.put("dup_cnt", getDupCnt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("rgst_dt", getRgstDt());
		this.hashColumns.put("cust_type", getCustType());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("current_dt", "currentDt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rgst_usr_id", "rgstUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("fm_atty_biz_no", "fmAttyBizNo");
		this.hashFields.put("acct_flg", "acctFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fm_atty_biz_nm", "fmAttyBizNm");
		this.hashFields.put("to_atty_biz_no", "toAttyBizNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("to_atty_biz_nm", "toAttyBizNm");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("rgst_ofc_cd", "rgstOfcCd");
		this.hashFields.put("cust_name", "custName");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("upd_usr_nm", "updUsrNm");
		this.hashFields.put("cust_biz_no", "custBizNo");
		this.hashFields.put("dup_cnt", "dupCnt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("rgst_dt", "rgstDt");
		this.hashFields.put("cust_type", "custType");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return currentDt
	 */
	public String getCurrentDt() {
		return this.currentDt;
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
	 * @return rgstUsrId
	 */
	public String getRgstUsrId() {
		return this.rgstUsrId;
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
	 * @return fmAttyBizNo
	 */
	public String getFmAttyBizNo() {
		return this.fmAttyBizNo;
	}
	
	/**
	 * Column Info
	 * @return acctFlg
	 */
	public String getAcctFlg() {
		return this.acctFlg;
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
	 * @return fmAttyBizNm
	 */
	public String getFmAttyBizNm() {
		return this.fmAttyBizNm;
	}
	
	/**
	 * Column Info
	 * @return toAttyBizNo
	 */
	public String getToAttyBizNo() {
		return this.toAttyBizNo;
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
	 * @return toAttyBizNm
	 */
	public String getToAttyBizNm() {
		return this.toAttyBizNm;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
	}
	
	/**
	 * Column Info
	 * @return rgstOfcCd
	 */
	public String getRgstOfcCd() {
		return this.rgstOfcCd;
	}
	
	/**
	 * Column Info
	 * @return custName
	 */
	public String getCustName() {
		return this.custName;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return updUsrNm
	 */
	public String getUpdUsrNm() {
		return this.updUsrNm;
	}
	
	/**
	 * Column Info
	 * @return custBizNo
	 */
	public String getCustBizNo() {
		return this.custBizNo;
	}
	
	/**
	 * Column Info
	 * @return dupCnt
	 */
	public String getDupCnt() {
		return this.dupCnt;
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
	 * @return updOfcCd
	 */
	public String getUpdOfcCd() {
		return this.updOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rgstDt
	 */
	public String getRgstDt() {
		return this.rgstDt;
	}
	
	/**
	 * Column Info
	 * @return custType
	 */
	public String getCustType() {
		return this.custType;
	}
	

	/**
	 * Column Info
	 * @param currentDt
	 */
	public void setCurrentDt(String currentDt) {
		this.currentDt = currentDt;
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
	 * @param rgstUsrId
	 */
	public void setRgstUsrId(String rgstUsrId) {
		this.rgstUsrId = rgstUsrId;
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
	 * @param fmAttyBizNo
	 */
	public void setFmAttyBizNo(String fmAttyBizNo) {
		this.fmAttyBizNo = fmAttyBizNo;
	}
	
	/**
	 * Column Info
	 * @param acctFlg
	 */
	public void setAcctFlg(String acctFlg) {
		this.acctFlg = acctFlg;
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
	 * @param fmAttyBizNm
	 */
	public void setFmAttyBizNm(String fmAttyBizNm) {
		this.fmAttyBizNm = fmAttyBizNm;
	}
	
	/**
	 * Column Info
	 * @param toAttyBizNo
	 */
	public void setToAttyBizNo(String toAttyBizNo) {
		this.toAttyBizNo = toAttyBizNo;
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
	 * @param toAttyBizNm
	 */
	public void setToAttyBizNm(String toAttyBizNm) {
		this.toAttyBizNm = toAttyBizNm;
	}
	
	/**
	 * Column Info
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
	}
	
	/**
	 * Column Info
	 * @param rgstOfcCd
	 */
	public void setRgstOfcCd(String rgstOfcCd) {
		this.rgstOfcCd = rgstOfcCd;
	}
	
	/**
	 * Column Info
	 * @param custName
	 */
	public void setCustName(String custName) {
		this.custName = custName;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param updUsrNm
	 */
	public void setUpdUsrNm(String updUsrNm) {
		this.updUsrNm = updUsrNm;
	}
	
	/**
	 * Column Info
	 * @param custBizNo
	 */
	public void setCustBizNo(String custBizNo) {
		this.custBizNo = custBizNo;
	}
	
	/**
	 * Column Info
	 * @param dupCnt
	 */
	public void setDupCnt(String dupCnt) {
		this.dupCnt = dupCnt;
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
	 * @param updOfcCd
	 */
	public void setUpdOfcCd(String updOfcCd) {
		this.updOfcCd = updOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rgstDt
	 */
	public void setRgstDt(String rgstDt) {
		this.rgstDt = rgstDt;
	}
	
	/**
	 * Column Info
	 * @param custType
	 */
	public void setCustType(String custType) {
		this.custType = custType;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCurrentDt(JSPUtil.getParameter(request, "current_dt", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setRgstUsrId(JSPUtil.getParameter(request, "rgst_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setFmAttyBizNo(JSPUtil.getParameter(request, "fm_atty_biz_no", ""));
		setAcctFlg(JSPUtil.getParameter(request, "acct_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFmAttyBizNm(JSPUtil.getParameter(request, "fm_atty_biz_nm", ""));
		setToAttyBizNo(JSPUtil.getParameter(request, "to_atty_biz_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setToAttyBizNm(JSPUtil.getParameter(request, "to_atty_biz_nm", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setDiffRmk(JSPUtil.getParameter(request, "diff_rmk", ""));
		setRgstOfcCd(JSPUtil.getParameter(request, "rgst_ofc_cd", ""));
		setCustName(JSPUtil.getParameter(request, "cust_name", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setUpdUsrNm(JSPUtil.getParameter(request, "upd_usr_nm", ""));
		setCustBizNo(JSPUtil.getParameter(request, "cust_biz_no", ""));
		setDupCnt(JSPUtil.getParameter(request, "dup_cnt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, "upd_ofc_cd", ""));
		setRgstDt(JSPUtil.getParameter(request, "rgst_dt", ""));
		setCustType(JSPUtil.getParameter(request, "cust_type", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorDoAttorneyDtlVO[]
	 */
	public KorDoAttorneyDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KorDoAttorneyDtlVO[]
	 */
	public KorDoAttorneyDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorDoAttorneyDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] currentDt = (JSPUtil.getParameter(request, prefix	+ "current_dt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] rgstUsrId = (JSPUtil.getParameter(request, prefix	+ "rgst_usr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] fmAttyBizNo = (JSPUtil.getParameter(request, prefix	+ "fm_atty_biz_no", length));
			String[] acctFlg = (JSPUtil.getParameter(request, prefix	+ "acct_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fmAttyBizNm = (JSPUtil.getParameter(request, prefix	+ "fm_atty_biz_nm", length));
			String[] toAttyBizNo = (JSPUtil.getParameter(request, prefix	+ "to_atty_biz_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] toAttyBizNm = (JSPUtil.getParameter(request, prefix	+ "to_atty_biz_nm", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] rgstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rgst_ofc_cd", length));
			String[] custName = (JSPUtil.getParameter(request, prefix	+ "cust_name", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] updUsrNm = (JSPUtil.getParameter(request, prefix	+ "upd_usr_nm", length));
			String[] custBizNo = (JSPUtil.getParameter(request, prefix	+ "cust_biz_no", length));
			String[] dupCnt = (JSPUtil.getParameter(request, prefix	+ "dup_cnt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] rgstDt = (JSPUtil.getParameter(request, prefix	+ "rgst_dt", length));
			String[] custType = (JSPUtil.getParameter(request, prefix	+ "cust_type", length));
			
			for (int i = 0; i < length; i++) {
				model = new KorDoAttorneyDtlVO();
				if (currentDt[i] != null)
					model.setCurrentDt(currentDt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (rgstUsrId[i] != null)
					model.setRgstUsrId(rgstUsrId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (fmAttyBizNo[i] != null)
					model.setFmAttyBizNo(fmAttyBizNo[i]);
				if (acctFlg[i] != null)
					model.setAcctFlg(acctFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fmAttyBizNm[i] != null)
					model.setFmAttyBizNm(fmAttyBizNm[i]);
				if (toAttyBizNo[i] != null)
					model.setToAttyBizNo(toAttyBizNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (toAttyBizNm[i] != null)
					model.setToAttyBizNm(toAttyBizNm[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (rgstOfcCd[i] != null)
					model.setRgstOfcCd(rgstOfcCd[i]);
				if (custName[i] != null)
					model.setCustName(custName[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (updUsrNm[i] != null)
					model.setUpdUsrNm(updUsrNm[i]);
				if (custBizNo[i] != null)
					model.setCustBizNo(custBizNo[i]);
				if (dupCnt[i] != null)
					model.setDupCnt(dupCnt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (rgstDt[i] != null)
					model.setRgstDt(rgstDt[i]);
				if (custType[i] != null)
					model.setCustType(custType[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorDoAttorneyDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorDoAttorneyDtlVO[]
	 */
	public KorDoAttorneyDtlVO[] getKorDoAttorneyDtlVOs(){
		KorDoAttorneyDtlVO[] vos = (KorDoAttorneyDtlVO[])models.toArray(new KorDoAttorneyDtlVO[models.size()]);
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
		this.currentDt = this.currentDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgstUsrId = this.rgstUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmAttyBizNo = this.fmAttyBizNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctFlg = this.acctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmAttyBizNm = this.fmAttyBizNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toAttyBizNo = this.toAttyBizNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toAttyBizNm = this.toAttyBizNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgstOfcCd = this.rgstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custName = this.custName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrNm = this.updUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custBizNo = this.custBizNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dupCnt = this.dupCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgstDt = this.rgstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custType = this.custType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

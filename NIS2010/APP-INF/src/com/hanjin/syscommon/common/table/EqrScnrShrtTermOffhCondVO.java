/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EqrScnrShrtTermOffhCondVO.java
*@FileTitle : EqrScnrShrtTermOffhCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.07
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.08.07 정은호 
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

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
 * @author 정은호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EqrScnrShrtTermOffhCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EqrScnrShrtTermOffhCondVO> models = new ArrayList<EqrScnrShrtTermOffhCondVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String scnrId = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String eccCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String ctrtSeq = null;
	/* Column Info */
	private String lftChgAmt = null;
	/* Column Info */
	private String drygAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String avalCntrQty = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String ctrtOfcCtyCd = null;
	/* Column Info */
	private String drffChgCrAmt = null;
	/* Column Info */
	private String dfltUsdDys = null;
	/* Column Info */
	private String updUsrId = null;
	
	/* input Parameter */
	private String pkupChgCrAmt = null;
	private String pdCostAmt	= null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EqrScnrShrtTermOffhCondVO() {}

	public EqrScnrShrtTermOffhCondVO(String ibflag, String pagerows, String scnrId, String eccCd, String ctrtOfcCtyCd, String ctrtSeq, String cntrTpszCd, String avalCntrQty, String lftChgAmt, String drygAmt, String drffChgCrAmt, String dfltUsdDys, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.scnrId = scnrId;
		this.deltFlg = deltFlg;
		this.eccCd = eccCd;
		this.creDt = creDt;
		this.ctrtSeq = ctrtSeq;
		this.lftChgAmt = lftChgAmt;
		this.drygAmt = drygAmt;
		this.pagerows = pagerows;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.avalCntrQty = avalCntrQty;
		this.cntrTpszCd = cntrTpszCd;
		this.ctrtOfcCtyCd = ctrtOfcCtyCd;
		this.drffChgCrAmt = drffChgCrAmt;
		this.dfltUsdDys = dfltUsdDys;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("scnr_id", getScnrId());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("ecc_cd", getEccCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("ctrt_seq", getCtrtSeq());
		this.hashColumns.put("lft_chg_amt", getLftChgAmt());
		this.hashColumns.put("dryg_amt", getDrygAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("aval_cntr_qty", getAvalCntrQty());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("ctrt_ofc_cty_cd", getCtrtOfcCtyCd());
		this.hashColumns.put("drff_chg_cr_amt", getDrffChgCrAmt());
		this.hashColumns.put("dflt_usd_dys", getDfltUsdDys());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("scnr_id", "scnrId");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("ecc_cd", "eccCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("ctrt_seq", "ctrtSeq");
		this.hashFields.put("lft_chg_amt", "lftChgAmt");
		this.hashFields.put("dryg_amt", "drygAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("aval_cntr_qty", "avalCntrQty");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("ctrt_ofc_cty_cd", "ctrtOfcCtyCd");
		this.hashFields.put("drff_chg_cr_amt", "drffChgCrAmt");
		this.hashFields.put("dflt_usd_dys", "dfltUsdDys");
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
	 * @return scnrId
	 */
	public String getScnrId() {
		return this.scnrId;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return eccCd
	 */
	public String getEccCd() {
		return this.eccCd;
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
	 * @return ctrtSeq
	 */
	public String getCtrtSeq() {
		return this.ctrtSeq;
	}
	
	/**
	 * Column Info
	 * @return lftChgAmt
	 */
	public String getLftChgAmt() {
		return this.lftChgAmt;
	}
	
	/**
	 * Column Info
	 * @return drygAmt
	 */
	public String getDrygAmt() {
		return this.drygAmt;
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
	 * @return avalCntrQty
	 */
	public String getAvalCntrQty() {
		return this.avalCntrQty;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtOfcCtyCd
	 */
	public String getCtrtOfcCtyCd() {
		return this.ctrtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return drffChgCrAmt
	 */
	public String getDrffChgCrAmt() {
		return this.drffChgCrAmt;
	}
	
	/**
	 * Column Info
	 * @return dfltUsdDys
	 */
	public String getDfltUsdDys() {
		return this.dfltUsdDys;
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
	 * @param scnrId
	 */
	public void setScnrId(String scnrId) {
		this.scnrId = scnrId;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param eccCd
	 */
	public void setEccCd(String eccCd) {
		this.eccCd = eccCd;
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
	 * @param ctrtSeq
	 */
	public void setCtrtSeq(String ctrtSeq) {
		this.ctrtSeq = ctrtSeq;
	}
	
	/**
	 * Column Info
	 * @param lftChgAmt
	 */
	public void setLftChgAmt(String lftChgAmt) {
		this.lftChgAmt = lftChgAmt;
	}
	
	/**
	 * Column Info
	 * @param drygAmt
	 */
	public void setDrygAmt(String drygAmt) {
		this.drygAmt = drygAmt;
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
	 * @param avalCntrQty
	 */
	public void setAvalCntrQty(String avalCntrQty) {
		this.avalCntrQty = avalCntrQty;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtOfcCtyCd
	 */
	public void setCtrtOfcCtyCd(String ctrtOfcCtyCd) {
		this.ctrtOfcCtyCd = ctrtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param drffChgCrAmt
	 */
	public void setDrffChgCrAmt(String drffChgCrAmt) {
		this.drffChgCrAmt = drffChgCrAmt;
	}
	
	/**
	 * Column Info
	 * @param dfltUsdDys
	 */
	public void setDfltUsdDys(String dfltUsdDys) {
		this.dfltUsdDys = dfltUsdDys;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	public String getPkupChgCrAmt() {
		return pkupChgCrAmt;
	}

	public void setPkupChgCrAmt(String pkupChgCrAmt) {
		this.pkupChgCrAmt = pkupChgCrAmt;
	}

	public String getPdCostAmt() {
		return pdCostAmt;
	}

	public void setPdCostAmt(String pdCostAmt) {
		this.pdCostAmt = pdCostAmt;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setScnrId(JSPUtil.getParameter(request, "scnr_id", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setEccCd(JSPUtil.getParameter(request, "ecc_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setCtrtSeq(JSPUtil.getParameter(request, "ctrt_seq", ""));
		setLftChgAmt(JSPUtil.getParameter(request, "lft_chg_amt", ""));
		setDrygAmt(JSPUtil.getParameter(request, "dryg_amt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAvalCntrQty(JSPUtil.getParameter(request, "aval_cntr_qty", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setCtrtOfcCtyCd(JSPUtil.getParameter(request, "ctrt_ofc_cty_cd", ""));
		setDrffChgCrAmt(JSPUtil.getParameter(request, "drff_chg_cr_amt", ""));
		setDfltUsdDys(JSPUtil.getParameter(request, "dflt_usd_dys", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EqrScnrShrtTermOffhCondVO[]
	 */
	public EqrScnrShrtTermOffhCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EqrScnrShrtTermOffhCondVO[]
	 */
	public EqrScnrShrtTermOffhCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EqrScnrShrtTermOffhCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] scnrId = (JSPUtil.getParameter(request, prefix	+ "scnr_id", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] eccCd = (JSPUtil.getParameter(request, prefix	+ "ecc_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] ctrtSeq = (JSPUtil.getParameter(request, prefix	+ "ctrt_seq", length));
			String[] lftChgAmt = (JSPUtil.getParameter(request, prefix	+ "lft_chg_amt", length));
			String[] drygAmt = (JSPUtil.getParameter(request, prefix	+ "dryg_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] avalCntrQty = (JSPUtil.getParameter(request, prefix	+ "aval_cntr_qty", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] ctrtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cty_cd", length));
			String[] drffChgCrAmt = (JSPUtil.getParameter(request, prefix	+ "drff_chg_cr_amt", length));
			String[] dfltUsdDys = (JSPUtil.getParameter(request, prefix	+ "dflt_usd_dys", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new EqrScnrShrtTermOffhCondVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (scnrId[i] != null)
					model.setScnrId(scnrId[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (eccCd[i] != null)
					model.setEccCd(eccCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (ctrtSeq[i] != null)
					model.setCtrtSeq(ctrtSeq[i]);
				if (lftChgAmt[i] != null)
					model.setLftChgAmt(lftChgAmt[i]);
				if (drygAmt[i] != null)
					model.setDrygAmt(drygAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (avalCntrQty[i] != null)
					model.setAvalCntrQty(avalCntrQty[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (ctrtOfcCtyCd[i] != null)
					model.setCtrtOfcCtyCd(ctrtOfcCtyCd[i]);
				if (drffChgCrAmt[i] != null)
					model.setDrffChgCrAmt(drffChgCrAmt[i]);
				if (dfltUsdDys[i] != null)
					model.setDfltUsdDys(dfltUsdDys[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEqrScnrShrtTermOffhCondVOs();
	}

	/*
	  *  해당되는 값으로 나누어서 저장하기 위한 데이터셋 정의 추가된 내용   
	  */
	
	public  EqrScnrShrtTermOffhCondVO[] fromRequestGridArrayList(HttpServletRequest request, String pirfix , String Loc) {
		EqrScnrShrtTermOffhCondVO model = null;
		//ArrayList models = new ArrayList();
	    //String[] prefix = {"D2","D4","D5","D7","R2","R5","O2","O4","F2","F4"};
	    String[] prefix = null;
        if (!(pirfix.equals(""))){
        	prefix = pirfix.split(",");
        }
        int length = request.getParameterValues("ibflag").length;
		try {
			for (int k=0 ; k < prefix.length ; k++){
			String[] ibflag          	=  (JSPUtil.getParameter(request, "ibflag         		".trim(), length));
			String[] pagerows       	=  (JSPUtil.getParameter(request, "page_rows      		".trim(), length));
			String[] scnrId         	=  (JSPUtil.getParameter(request, "scnr_id        		".trim(), length));
			String[] eccCd          	=  (JSPUtil.getParameter(request, "ecc_cd         		".trim(), length));
			String[] ctrtOfcCtyCd 		=  (JSPUtil.getParameter(request, "ctrt_ofc_cty_cd		".trim(), length));
			String[] ctrtSeq        	=  (JSPUtil.getParameter(request, "ctrt_seq       		".trim(), length));
			String cntrTpszCd      		=   prefix[k].trim().toString();
			String[] avalCntrQty   		=  (JSPUtil.getParameter(request, prefix[k] + "aval_cntr_qty  		".trim(), length));
			String[] lftChgAmt     		=  (JSPUtil.getParameter(request, prefix[k] + "lft_chg_amt    		".trim(), length));
			String[] drygAmt        	=  (JSPUtil.getParameter(request, prefix[k] + "dryg_amt       		".trim(), length));
			String[] pkupChgCrAmt 		=  (JSPUtil.getParameter(request, prefix[k] + "pkup_chg_cr_amt		".trim(), length));
			String[] pdCostAmt     		=  (JSPUtil.getParameter(request, prefix[k] + "pd_cost_amt    		".trim(), length));
			String[] dfltUsdDys    		=  (JSPUtil.getParameter(request, prefix[k] + "dflt_usd_dys  		".trim(), length));
			String[] drffChgCrAmt 		=  (JSPUtil.getParameter(request, prefix[k] + "drff_chg_cr_amt		".trim(), length));
			String[] deltFlg        	=  (JSPUtil.getParameter(request, "delt_flg       		".trim(), length));
			String[] creUsrId      		=  (JSPUtil.getParameter(request, "cre_usr_id     		".trim(), length));
			String[] creDt         		=  (JSPUtil.getParameter(request, "cre_dt         		".trim(), length));
			String[] updUsrId      		=  (JSPUtil.getParameter(request, "upd_usr_id     		".trim(), length));
			String[] updDt          	=  (JSPUtil.getParameter(request, "upd_dt         		".trim(), length));
				for (int i = 0; i < length; i++) {
					model = new EqrScnrShrtTermOffhCondVO();
					if (updDt[i] != null)
						model.setUpdDt(updDt[i]);
					if (scnrId[i] != null)
						model.setScnrId(scnrId[i]);
					if (deltFlg[i] != null)
						model.setDeltFlg(deltFlg[i]);
					if (eccCd[i] != null)
						model.setEccCd(eccCd[i]);
					if (creDt[i] != null)
						model.setCreDt(creDt[i]);
					if (ctrtSeq[i] != null)
						model.setCtrtSeq(ctrtSeq[i]);
					if (lftChgAmt[i] != null)
						model.setLftChgAmt(lftChgAmt[i]);
					if (drygAmt[i] != null)
						model.setDrygAmt(drygAmt[i]);
					if (pagerows[i] != null)
						model.setPagerows(pagerows[i]);
					if (creUsrId[i] != null)
						model.setCreUsrId(creUsrId[i]);
					if (ibflag[i] != null)
						model.setIbflag(ibflag[i]);
					if (avalCntrQty[i] != null)
						model.setAvalCntrQty(avalCntrQty[i]);
					if (cntrTpszCd != null)
						model.setCntrTpszCd(cntrTpszCd);
					if (ctrtOfcCtyCd[i] != null)
						model.setCtrtOfcCtyCd(ctrtOfcCtyCd[i]);
					if (drffChgCrAmt[i] != null)
						model.setDrffChgCrAmt(drffChgCrAmt[i]);
					if (dfltUsdDys[i] != null)
						model.setDfltUsdDys(dfltUsdDys[i]);
					if (updUsrId[i] != null)
						model.setUpdUsrId(updUsrId[i]);
					if (pkupChgCrAmt[i] != null)
						model.setPkupChgCrAmt(pkupChgCrAmt[i]);
					if (pdCostAmt[i] != null)
						model.setPdCostAmt(pdCostAmt[i]);
					models.add(model);
				}
			}
		} catch (Exception ex) {
		}
		return getEqrScnrShrtTermOffhCondVOs();
	}
	/**
	 * VO 배열을 반환
	 * @return EqrScnrShrtTermOffhCondVO[]
	 */
	public EqrScnrShrtTermOffhCondVO[] getEqrScnrShrtTermOffhCondVOs(){
		EqrScnrShrtTermOffhCondVO[] vos = (EqrScnrShrtTermOffhCondVO[])models.toArray(new EqrScnrShrtTermOffhCondVO[models.size()]);
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
		this.scnrId = this.scnrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eccCd = this.eccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtSeq = this.ctrtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lftChgAmt = this.lftChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drygAmt = this.drygAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avalCntrQty = this.avalCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCtyCd = this.ctrtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drffChgCrAmt = this.drffChgCrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfltUsdDys = this.dfltUsdDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LeasePlanVO.java
*@FileTitle : LeasePlanVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.29
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.04.29 노정용
* 1.0 Creation
* =======================================================
* 2010.12.01 박명신 [CHM-201007443-01] REF_NO 항목 추가
=========================================================*/

package com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Lease Plan VO Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 노정용
 * @since J2EE 1.5
 * @see ..
 */

public class LeasePlanVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<LeasePlanVO> models = new ArrayList<LeasePlanVO>();

	private Logger log = Logger.getLogger("com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.vo");

	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String deQty = null;
	/* Column Info */
	private String plnYr = null;
	/* Column Info */
	private String plnMon = null;
	/* Column Info */
	private String plnYrmon = null;
	/* Column Info */
	private String newVanYrmon = null;
	/* Column Info */
	private String plnSeq = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String agmtCtyCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String mftVndrSeq = null;
	/* Column Info */
	private String deYrmon = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;
	/* Sequence Number */
	private String insertSeq = null;
	/* Column Info */
	private String plnRmk = null;
	/* Column Info */
	private String refNo = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	/**
	 * Constructor
	 */
	public LeasePlanVO() {}

	/**
	 * Constructor
	 */
	public LeasePlanVO(String ibflag, String plnRmk, String pagerows, String plnYr, String plnMon, String plnYrmon, String newVanYrmon, String plnSeq, String lstmCd,
			           String agmtNo, String agmtCtyCd, String agmtSeq, String mftVndrSeq, String deYrmon, String delCd, String cntrTpszCd, String deQty,
			           String creUsrId, String updUsrId, String insertSeq, String refNo) {
		this.ibflag = ibflag;
		this.deQty = deQty;
		this.plnYr = plnYr;
		this.plnMon = plnMon;
		this.plnYrmon = plnYrmon;
		this.newVanYrmon = newVanYrmon;
		this.plnSeq = plnSeq;
		this.agmtSeq = agmtSeq;
		this.lstmCd = lstmCd;
		this.cntrTpszCd = cntrTpszCd;
		this.agmtCtyCd = agmtCtyCd;
		this.delCd = delCd;
		this.agmtNo = agmtNo;
		this.mftVndrSeq = mftVndrSeq;
		this.deYrmon = deYrmon;
		this.creUsrId = creUsrId;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
		this.insertSeq = insertSeq;
		this.plnRmk = plnRmk;
		this.refNo = refNo;
	}

	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("de_qty", getDeQty());
		this.hashColumns.put("pln_yr", getPlnYr());
		this.hashColumns.put("pln_mon", getPlnMon());
		this.hashColumns.put("pln_yrmon", getPlnYrmon());
		this.hashColumns.put("new_van_yrmon", getNewVanYrmon());
		this.hashColumns.put("pln_seq", getPlnSeq());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("mft_vndr_seq", getMftVndrSeq());
		this.hashColumns.put("de_yrmon", getDeYrmon());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("insert_seq", getInsertSeq());
		this.hashColumns.put("pln_rmk", getPlnRmk());
		this.hashColumns.put("ref_no", getRefNo());
		return this.hashColumns;
	}

	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("de_qty", "deQty");
		this.hashFields.put("pln_yr", "plnYr");
		this.hashFields.put("pln_mon", "plnMon");
		this.hashFields.put("pln_yrmon", "plnYrmon");
		this.hashFields.put("new_van_yrmon", "newVanYrmon");
		this.hashFields.put("pln_seq", "plnSeq");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("mft_vndr_seq", "mftVndrSeq");
		this.hashFields.put("de_yrmon", "deYrmon");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("insert_seq", "insertSeq");
		this.hashFields.put("pln_rmk", "plnRmk");
		this.hashFields.put("ref_no", "refNo");
		return this.hashFields;
	}

	public String getIbflag() {
		return this.ibflag;
	}
	public String getDeQty() {
		return this.deQty;
	}
	public String getPlnYr() {
		return this.plnYr;
	}
	public String getPlnMon() {
		return this.plnMon;
	}
	public String getPlnYrmon() {
		return this.plnYrmon;
	}
	public String getNewVanYrmon() {
		return this.newVanYrmon;
	}
	public String getAgmtSeq() {
		return this.agmtSeq;
	}
	public String getLstmCd() {
		return this.lstmCd;
	}
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	public String getAgmtCtyCd() {
		return this.agmtCtyCd;
	}
	public String getDelCd() {
		return this.delCd;
	}
	public String getAgmtNo() {
		return this.agmtNo;
	}
	public String getMftVndrSeq() {
		return this.mftVndrSeq;
	}
	public String getDeYrmon() {
		return this.deYrmon;
	}
	public String getPagerows() {
		return this.pagerows;
	}
	/**
	 * Column Info
	 * @return refNo
	 */
	public String getRefNo() {
		return this.refNo;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setDeQty(String deQty) {
		this.deQty = deQty;
		//this.deQty=true;
	}
	public void setPlnYr(String plnYr) {
		this.plnYr = plnYr;
		//this.plnYr=true;
	}
	public void setPlnMon(String plnMon) {
		this.plnMon = plnMon;
	}
	public void setPlnYrmon(String plnYrmon) {
		this.plnYrmon = plnYrmon;
	}
	public void setNewVanYrmon(String newVanYrmon) {
		this.newVanYrmon = newVanYrmon;
	}
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
		//this.agmtSeq=true;
	}
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
		//this.cntrTpszCd=true;
	}
	public void setAgmtCtyCd(String agmtCtyCd) {
		this.agmtCtyCd = agmtCtyCd;
		//this.agmtCtyCd=true;
	}
	public void setDelCd(String delCd) {
		this.delCd = delCd;
		//this.delCd=true;
	}
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
		//this.agmtNo=true;
	}
	public void setMftVndrSeq(String mftVndrSeq) {
		this.mftVndrSeq = mftVndrSeq;
		//this.mftVndrSeq=true;
	}
	public void setDeYrmon(String deYrmon) {
		this.deYrmon = deYrmon;
		//this.deYrmon=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}

	/**
	 * @return the plnRmk
	 */
	public String getPlnRmk() {
		return plnRmk;
	}

	/**
	 * @param plnRmk the plnRmk to set
	 */
	public void setPlnRmk(String plnRmk) {
		this.plnRmk = plnRmk;
	}
	
	/**
	 * Column Info
	 * @param refNo
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	
	/**
	 * hasHttpServletRequestInfo
	 * @return
	 */
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDeQty(JSPUtil.getParameter(request, "de_qty", ""));
		setPlnYr(JSPUtil.getParameter(request, "pln_yr", ""));
		setPlnMon(JSPUtil.getParameter(request, "pln_mon", ""));
		setPlnYrmon(JSPUtil.getParameter(request, "pln_yrmon", ""));
		setNewVanYrmon(JSPUtil.getParameter(request, "new_van_yrmon", ""));
		setPlnSeq(JSPUtil.getParameter(request, "pln_seq", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setLstmCd(JSPUtil.getParameter(request, "lstm_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request, "agmt_cty_cd", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setMftVndrSeq(JSPUtil.getParameter(request, "mft_vndr_seq", ""));
		setDeYrmon(JSPUtil.getParameter(request, "de_yrmon", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setInsertSeq(JSPUtil.getParameter(request, "insert_seq", ""));
		setPlnRmk(JSPUtil.getParameter(request, "pln_rmk", ""));
		setRefNo(JSPUtil.getParameter(request,  "ref_no", ""));
	}

	/**
	 * hasHttpServletRequestGridInfo
	 * @return
	 */
	public LeasePlanVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * hasHttpServletRequestGridInfo
	 * @return
	 */
	public LeasePlanVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		LeasePlanVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] deQty = (JSPUtil.getParameter(request, prefix	+ "de_qty".trim(), length));
			String[] plnYr = (JSPUtil.getParameter(request, prefix	+ "pln_yr".trim(), length));
			String[] plnMon = (JSPUtil.getParameter(request, prefix	+ "pln_mon".trim(), length));
			String[] plnYrmon = (JSPUtil.getParameter(request, prefix	+ "pln_yrmon".trim(), length));
			String[] newVanYrmon = (JSPUtil.getParameter(request, prefix	+ "new_van_yrmon".trim(), length));
			String[] plnSeq = (JSPUtil.getParameter(request, prefix	+ "pln_seq".trim(), length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq".trim(), length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd".trim(), length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd".trim(), length));
			String[] agmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cty_cd".trim(), length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd".trim(), length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no".trim(), length));
			String[] mftVndrSeq = (JSPUtil.getParameter(request, prefix	+ "mft_vndr_seq".trim(), length));
			String[] deYrmon = (JSPUtil.getParameter(request, prefix	+ "de_yrmon".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] insertSeq = (JSPUtil.getParameter(request, prefix	+ "insert_seq".trim(), length));
			String[] plnRmk = (JSPUtil.getParameter(request, prefix	+ "pln_rmk".trim(), length));
			String[] refNo = (JSPUtil.getParameter(request, prefix	+ "ref_no", length));

			for (int i = 0; i < length; i++) {
				model = new LeasePlanVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (deQty[i] != null)
					model.setDeQty(deQty[i]);
				if (plnYr[i] != null)
					model.setPlnYr(plnYr[i]);
				if (plnMon[i] != null)
					model.setPlnMon(plnMon[i]);
				if (plnYrmon[i] != null)
					model.setPlnYrmon(plnYrmon[i]);
				if (newVanYrmon[i] != null)
					model.setNewVanYrmon(newVanYrmon[i]);
				if (plnSeq[i] != null)
					model.setPlnSeq(plnSeq[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (agmtCtyCd[i] != null)
					model.setAgmtCtyCd(agmtCtyCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (mftVndrSeq[i] != null)
					model.setMftVndrSeq(mftVndrSeq[i]);
				if (deYrmon[i] != null)
					model.setDeYrmon(deYrmon[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (insertSeq[i] != null)
					model.setInsertSeq(insertSeq[i]);
				if (plnRmk[i] != null)
					model.setPlnRmk(plnRmk[i]);
				if (refNo[i] != null)
					model.setRefNo(refNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return getLeasePlanVOs();
	}

	public LeasePlanVO[] getLeasePlanVOs(){
		LeasePlanVO[] vos = (LeasePlanVO[])models.toArray(new LeasePlanVO[models.size()]);
		return vos;
	}

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
			log.error(ex.getMessage(), ex);
		}
		return ret.toString();
	}

	/**
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다
	 * @param field
	 * @param i
	 * @return String[]
	 * @throws IllegalAccessException
	 */
	private String[] getField(Field[] field, int i) throws IllegalAccessException {
		String[] arr;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
			log.error(ex.getMessage(), ex);
			throw new IllegalAccessException(ex.getMessage());
		}
		return arr;
	}

	/**
	* DataFormat 설정
	*/
	public void onDataFormat(){
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deQty = this.deQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYr = this.plnYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnMon = this.plnMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYrmon = this.plnYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newVanYrmon = this.newVanYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnSeq = this.plnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd = this.agmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mftVndrSeq = this.mftVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deYrmon = this.deYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insertSeq = this.insertSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnRmk = this.plnRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo = this.refNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	public String getCreUsrId() {
		return creUsrId;
	}

	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	public String getUpdUsrId() {
		return updUsrId;
	}

	public void setPlnSeq(String plnSeq) {
		this.plnSeq = plnSeq;
	}

	public String getPlnSeq() {
		return plnSeq;
	}

	public void setInsertSeq(String insertSeq) {
		this.insertSeq = insertSeq;
	}

	public String getInsertSeq() {
		return insertSeq;
	}
}

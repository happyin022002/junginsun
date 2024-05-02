/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OffHirePlanVO.java
*@FileTitle : OffHirePlanVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 오봉현
*@LastVersion : 1.0
* 2009.06.02 오봉현 
* 1.0 Creation
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
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 오봉현
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OffHirePlanVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OffHirePlanVO> models = new ArrayList<OffHirePlanVO>();
	
	private Logger log = Logger.getLogger("com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.vo");
	
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String yrTot = null;
	/* Column Info */
	private String plnYr = null;
	/* Column Info */
	private String plnSeq = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String offhPlnTpCd = null;
	/* Column Info */
	private String offhVerSeq = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String mnth01 = null;
	/* Column Info */
	private String mnth02 = null;
	/* Column Info */
	private String mnth03 = null;
	/* Column Info */
	private String mnth04 = null;
	/* Column Info */
	private String mnth05 = null;
	/* Column Info */
	private String mnth06 = null;
	/* Column Info */
	private String mnth07 = null;
	/* Column Info */
	private String mnth08 = null;
	/* Column Info */
	private String mnth09 = null;
	/* Column Info */
	private String mnth10 = null;
	/* Column Info */
	private String mnth11 = null;
	/* Column Info */
	private String mnth12 = null;
	/* Column Info */
	private String offhLocTpCd = null;
	/* Column Info */
	private String offhRgnLocCd = null;
	
	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	/**
	 * Constructor
	 */
	public OffHirePlanVO() {}

	/**
	 * Constructor
	 */
	public OffHirePlanVO(String ibflag, String pagerows, String plnYr, String plnSeq, String cntrTpszCd, String yrTot, String creUsrId, 
			             String updUsrId, String offhPlnTpCd, String offhVerSeq, String lstmCd, String offhLocTpCd, String offhRgnLocCd,
			             String mnth01,String mnth02,String mnth03,String mnth04,String mnth05,String mnth06,
			             String mnth07,String mnth08,String mnth09,String mnth10,String mnth11,String mnth12) {
		this.ibflag = ibflag;
		this.yrTot = yrTot;
		this.plnYr = plnYr;
		this.plnSeq = plnSeq;
		this.cntrTpszCd = cntrTpszCd;
		this.creUsrId = creUsrId;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
		this.offhPlnTpCd = offhPlnTpCd;
		this.offhVerSeq = offhVerSeq;
		this.lstmCd = lstmCd;
		this.mnth01 = mnth01;
		this.mnth02 = mnth02;
		this.mnth03 = mnth03;
		this.mnth04 = mnth04;
		this.mnth05 = mnth05;
		this.mnth06 = mnth06;
		this.mnth07 = mnth07;
		this.mnth08 = mnth08;
		this.mnth09 = mnth09;
		this.mnth10 = mnth10;
		this.mnth11 = mnth11;
		this.mnth12 = mnth12;
		this.offhLocTpCd = offhLocTpCd;
		this.offhRgnLocCd = offhRgnLocCd;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("yr_tot", getYrTot());
		this.hashColumns.put("pln_yr", getPlnYr());
		this.hashColumns.put("de_yr", getPlnYr());
		this.hashColumns.put("pln_seq", getPlnSeq());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("offh_pln_tp_cd", getOffhPlnTpCd());
		this.hashColumns.put("offh_ver_seq", getOffhVerSeq());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("mnth_01", getMnth01());
		this.hashColumns.put("mnth_02", getMnth02());
		this.hashColumns.put("mnth_03", getMnth03());
		this.hashColumns.put("mnth_04", getMnth04());
		this.hashColumns.put("mnth_05", getMnth05());
		this.hashColumns.put("mnth_06", getMnth06());
		this.hashColumns.put("mnth_07", getMnth07());
		this.hashColumns.put("mnth_08", getMnth08());
		this.hashColumns.put("mnth_09", getMnth09());
		this.hashColumns.put("mnth_10", getMnth10());
		this.hashColumns.put("mnth_11", getMnth11());
		this.hashColumns.put("mnth_12", getMnth12());
		this.hashColumns.put("offh_loc_tp_cd", getOffhLocTpCd());
		this.hashColumns.put("offh_rgn_loc_cd", getOffhRgnLocCd());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("yr_tot", "yrTot");
		this.hashFields.put("pln_yr", "plnYr");
		this.hashFields.put("de_yr", "deYr");
		this.hashFields.put("pln_seq", "plnSeq");
		this.hashFields.put("agmt_seq", "agmtSeq");
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
		this.hashFields.put("offh_pln_tp_cd", "offhPlnTpCd");
		this.hashFields.put("offh_ver_seq", "offhVerSeq");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("offh_loc_cd", "offhLocCd");
		this.hashFields.put("mnth_01", "mnth01");
		this.hashFields.put("mnth_02", "mnth02");
		this.hashFields.put("mnth_03", "mnth03");
		this.hashFields.put("mnth_04", "mnth04");
		this.hashFields.put("mnth_05", "mnth05");
		this.hashFields.put("mnth_06", "mnth06");
		this.hashFields.put("mnth_07", "mnth07");
		this.hashFields.put("mnth_08", "mnth08");
		this.hashFields.put("mnth_09", "mnth09");
		this.hashFields.put("mnth_10", "mnth10");
		this.hashFields.put("mnth_11", "mnth11");
		this.hashFields.put("mnth_12", "mnth12");
		this.hashFields.put("offh_loc_tp_cd", "offhLocTpCd");
		this.hashFields.put("offh_rgn_loc_cd", "offhRgnLocCd");
		return this.hashFields;
	}
	
	public String getIbflag() {
		return this.ibflag;
	}
	public String getYrTot() {
		return this.yrTot;
	}
	public String getPlnYr() {
		return this.plnYr;
	}
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	public String getOffhLocTpCd () {
		return this.offhLocTpCd ;
	}
	public void setOffhLocTpCd (String offhLocTpCd ) {
		this.offhLocTpCd  = offhLocTpCd ;
	}
	public String getOffhRgnLocCd () {
		return this.offhRgnLocCd ;
	}
	public void setOffhRgnLocCd (String offhRgnLocCd ) {
		this.offhRgnLocCd  = offhRgnLocCd ;
	}
	public String getPagerows() {
		return this.pagerows;
	}
	public String getOffhPlnTpCd() {
		return offhPlnTpCd;
	}
	public String getOffhVerSeq() {
		return offhVerSeq;
	}
	public String getLstmCd() {
		return lstmCd;
	}
	public void setOffhPlnTpCd(String offhPlnTpCd) {
		this.offhPlnTpCd = offhPlnTpCd;
	}
	public void setOffhVerSeq(String offhVerSeq) {
		this.offhVerSeq = offhVerSeq;
	}
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	public void setYrTot(String yrTot) {
		this.yrTot = yrTot;
	}
	public void setPlnYr(String plnYr) {
		this.plnYr = plnYr;
	}
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	public String getMnth01() {
		return this.mnth01;
	}
	public String getMnth02() {
		return this.mnth02;
	}
	public String getMnth03() {
		return this.mnth03;
	}
	public String getMnth04() {
		return this.mnth04;
	}
	public String getMnth05() {
		return this.mnth05;
	}
	public String getMnth06() {
		return this.mnth06;
	}
	public String getMnth07() {
		return this.mnth07;
	}
	public String getMnth08() {
		return this.mnth08;
	}
	public String getMnth09() {
		return this.mnth09;
	}
	public String getMnth10() {
		return this.mnth10;
	}
	public String getMnth11() {
		return this.mnth11;
	}
	public String getMnth12() {
		return this.mnth12;
	}
	public void setMnth01(String mnth01) {
		this.mnth01 = mnth01;
	}
	public void setMnth02(String mnth02) {
		this.mnth02 = mnth02;
	}
	public void setMnth03(String mnth03) {
		this.mnth03 = mnth03;
	}
	public void setMnth04(String mnth04) {
		this.mnth04 = mnth04;
	}
	public void setMnth05(String mnth05) {
		this.mnth05 = mnth05;
	}
	public void setMnth06(String mnth06) {
		this.mnth06 = mnth06;
	}
	public void setMnth07(String mnth07) {
		this.mnth07 = mnth07;
	}
	public void setMnth08(String mnth08) {
		this.mnth08 = mnth08;
	}
	public void setMnth09(String mnth09) {
		this.mnth09 = mnth09;
	}
	public void setMnth10(String mnth10) {
		this.mnth10 = mnth10;
	}
	public void setMnth11(String mnth11) {
		this.mnth11 = mnth11;
	}
	public void setMnth12(String mnth12) {
		this.mnth12 = mnth12;
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

	/**
	 * hasHttpServletRequestInfo
	 * @return
	 */
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setYrTot(JSPUtil.getParameter(request, "yr_tot", ""));
		setPlnYr(JSPUtil.getParameter(request, "pln_yr", ""));
		setPlnSeq(JSPUtil.getParameter(request, "pln_seq", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOffhPlnTpCd(JSPUtil.getParameter(request, "offh_pln_tp_cd", ""));
		setOffhVerSeq(JSPUtil.getParameter(request, "offh_ver_seq", ""));
		setLstmCd(JSPUtil.getParameter(request, "lstm_cd", ""));
		setMnth01(JSPUtil.getParameter(request, "mnth_01", ""));
		setMnth02(JSPUtil.getParameter(request, "mnth_02", ""));
		setMnth03(JSPUtil.getParameter(request, "mnth_03", ""));
		setMnth04(JSPUtil.getParameter(request, "mnth_04", ""));
		setMnth05(JSPUtil.getParameter(request, "mnth_05", ""));
		setMnth06(JSPUtil.getParameter(request, "mnth_06", ""));
		setMnth07(JSPUtil.getParameter(request, "mnth_07", ""));
		setMnth08(JSPUtil.getParameter(request, "mnth_08", ""));
		setMnth09(JSPUtil.getParameter(request, "mnth_09", ""));
		setMnth10(JSPUtil.getParameter(request, "mnth_10", ""));
		setMnth11(JSPUtil.getParameter(request, "mnth_11", ""));
		setMnth12(JSPUtil.getParameter(request, "mnth_12", ""));
		setOffhLocTpCd(JSPUtil.getParameter(request, "offh_loc_tp_cd", ""));
		setOffhRgnLocCd(JSPUtil.getParameter(request, "offh_rgn_loc_cd", ""));
	}

	/**
	 * hasHttpServletRequestGridInfo
	 * @return
	 */
	public OffHirePlanVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * hasHttpServletRequestGridInfo
	 * @return
	 */
	public OffHirePlanVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OffHirePlanVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] yrTot = (JSPUtil.getParameter(request, prefix	+ "yr_tot".trim(), length));
			String[] plnYr = (JSPUtil.getParameter(request, prefix	+ "pln_yr".trim(), length));
			String[] plnSeq = (JSPUtil.getParameter(request, prefix	+ "pln_seq".trim(), length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] offhPlnTpCd = (JSPUtil.getParameter(request, prefix	+ "offh_pln_tp_cd".trim(), length));
			String[] offhVerSeq = (JSPUtil.getParameter(request, prefix	+ "offh_ver_seq".trim(), length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd".trim(), length));
			String[] mnth01 = (JSPUtil.getParameter(request, prefix	+ "mnth_01".trim(), length));
			String[] mnth02 = (JSPUtil.getParameter(request, prefix	+ "mnth_02".trim(), length));
			String[] mnth03 = (JSPUtil.getParameter(request, prefix	+ "mnth_03".trim(), length));
			String[] mnth04 = (JSPUtil.getParameter(request, prefix	+ "mnth_04".trim(), length));
			String[] mnth05 = (JSPUtil.getParameter(request, prefix	+ "mnth_05".trim(), length));
			String[] mnth06 = (JSPUtil.getParameter(request, prefix	+ "mnth_06".trim(), length));
			String[] mnth07 = (JSPUtil.getParameter(request, prefix	+ "mnth_07".trim(), length));
			String[] mnth08 = (JSPUtil.getParameter(request, prefix	+ "mnth_08".trim(), length));
			String[] mnth09 = (JSPUtil.getParameter(request, prefix	+ "mnth_09".trim(), length));
			String[] mnth10 = (JSPUtil.getParameter(request, prefix	+ "mnth_10".trim(), length));
			String[] mnth11 = (JSPUtil.getParameter(request, prefix	+ "mnth_11".trim(), length));
			String[] mnth12 = (JSPUtil.getParameter(request, prefix	+ "mnth_12".trim(), length));
			String[] offhLocTpCd  = (JSPUtil.getParameter(request, prefix	+ "offh_loc_tp_cd".trim(), length));
			String[] offhRgnLocCd  = (JSPUtil.getParameter(request, prefix	+ "offh_rgn_loc_cd".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new OffHirePlanVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (yrTot[i] != null)
					model.setYrTot(yrTot[i]);
				if (plnYr[i] != null)
					model.setPlnYr(plnYr[i]);
				if (plnSeq[i] != null)
					model.setPlnSeq(plnSeq[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (offhPlnTpCd[i] != null)
					model.setOffhPlnTpCd(offhPlnTpCd[i]);
				if (offhVerSeq[i] != null)
					model.setOffhVerSeq(offhVerSeq[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mnth01[i] != null)
					model.setMnth01(mnth01[i]);
				if (mnth02[i] != null)
					model.setMnth02(mnth02[i]);
				if (mnth03[i] != null)
					model.setMnth03(mnth03[i]);
				if (mnth04[i] != null)
					model.setMnth04(mnth04[i]);
				if (mnth05[i] != null)
					model.setMnth05(mnth05[i]);
				if (mnth06[i] != null)
					model.setMnth06(mnth06[i]);
				if (mnth07[i] != null)
					model.setMnth07(mnth07[i]);
				if (mnth08[i] != null)
					model.setMnth08(mnth08[i]);
				if (mnth09[i] != null)
					model.setMnth09(mnth09[i]);
				if (mnth10[i] != null)
					model.setMnth10(mnth10[i]);
				if (mnth11[i] != null)
					model.setMnth11(mnth11[i]);
				if (mnth12[i] != null)
					model.setMnth12(mnth12[i]);
				if (offhLocTpCd[i] != null)
					model.setOffhLocTpCd(offhLocTpCd[i]);
				if (offhRgnLocCd[i] != null)
					model.setOffhRgnLocCd(offhRgnLocCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return getOffHirePlanVOs();
	}

	public OffHirePlanVO[] getOffHirePlanVOs(){
		OffHirePlanVO[] vos = (OffHirePlanVO[])models.toArray(new OffHirePlanVO[models.size()]);
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
		this.yrTot = this.yrTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYr = this.plnYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnSeq = this.plnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhPlnTpCd = this.offhPlnTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhVerSeq = this.offhVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnth01 = this.mnth01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnth02 = this.mnth02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnth03 = this.mnth03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnth04 = this.mnth04 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnth05 = this.mnth05 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnth06 = this.mnth06 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnth07 = this.mnth07 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnth08 = this.mnth08 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnth09 = this.mnth09 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnth10 = this.mnth10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnth11 = this.mnth11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnth12 = this.mnth12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhLocTpCd  = this.offhLocTpCd  .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhRgnLocCd  = this.offhRgnLocCd  .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
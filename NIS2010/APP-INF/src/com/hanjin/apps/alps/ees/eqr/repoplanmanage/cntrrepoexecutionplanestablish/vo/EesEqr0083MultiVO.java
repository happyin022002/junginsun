/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0083MultiVO.java
*@FileTitle : EesEqr0083MultiVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.09.23 정은호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

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

public class EesEqr0083MultiVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0083MultiVO> models = new ArrayList<EesEqr0083MultiVO>();
	
	/* Column Info */
	private String frlocRcc = null;
	/* Column Info */
	private String coCd = null;
	/* Column Info */
	private String fmYdCd = null;
	/* Column Info */
	private String refId = null;
	/* Column Info */
	private String soCancelFlag = null;
	/* Column Info */
	private String cntrno = null;
	/* Column Info */
	private String plnYrwk = null;
	/* Column Info */
	private String trspModCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String toYdCd = null;
	/* Column Info */
	private String repoPlnId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrDel = null;
	/* Column Info */
	private String fmEtdDt = null;
	/* Column Info */
	private String toEtaDt = null;
	/* Column Info */
	private String tpszno = null;
	/* Column Info */
	private String eqRepoPurpCd = null;
	/* Column Info */
	private String soIssFlg = null;
	/* input Param */
	/*
	 * type size 순서대로 해당 value를 담기위한 변수
	 */
	private List<String> volList = null;
	private List<String> flagList = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0083MultiVO() {}

	public EesEqr0083MultiVO(String ibflag, String pagerows, String repoPlnId, String refId, String plnYrwk, String coCd, String trspModCd, String fmYdCd, String fmEtdDt, String toYdCd, String toEtaDt, String eqRepoPurpCd, String soIssFlg, String cntrno, String tpszno, String cntrDel, String soCancelFlag, String frlocRcc) {
		this.frlocRcc = frlocRcc;
		this.coCd = coCd;
		this.fmYdCd = fmYdCd;
		this.refId = refId;
		this.soCancelFlag = soCancelFlag;
		this.cntrno = cntrno;
		this.plnYrwk = plnYrwk;
		this.trspModCd = trspModCd;
		this.pagerows = pagerows;
		this.toYdCd = toYdCd;
		this.repoPlnId = repoPlnId;
		this.ibflag = ibflag;
		this.cntrDel = cntrDel;
		this.fmEtdDt = fmEtdDt;
		this.toEtaDt = toEtaDt;
		this.tpszno = tpszno;
		this.eqRepoPurpCd = eqRepoPurpCd;
		this.soIssFlg = soIssFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("frloc_rcc", getFrlocRcc());
		this.hashColumns.put("co_cd", getCoCd());
		this.hashColumns.put("fm_yd_cd", getFmYdCd());
		this.hashColumns.put("ref_id", getRefId());
		this.hashColumns.put("so_cancel_flag", getSoCancelFlag());
		this.hashColumns.put("cntrno", getCntrno());
		this.hashColumns.put("pln_yrwk", getPlnYrwk());
		this.hashColumns.put("trsp_mod_cd", getTrspModCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("to_yd_cd", getToYdCd());
		this.hashColumns.put("repo_pln_id", getRepoPlnId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_del", getCntrDel());
		this.hashColumns.put("fm_etd_dt", getFmEtdDt());
		this.hashColumns.put("to_eta_dt", getToEtaDt());
		this.hashColumns.put("tpszno", getTpszno());
		this.hashColumns.put("eq_repo_purp_cd", getEqRepoPurpCd());
		this.hashColumns.put("so_iss_flg", getSoIssFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("frloc_rcc", "frlocRcc");
		this.hashFields.put("co_cd", "coCd");
		this.hashFields.put("fm_yd_cd", "fmYdCd");
		this.hashFields.put("ref_id", "refId");
		this.hashFields.put("so_cancel_flag", "soCancelFlag");
		this.hashFields.put("cntrno", "cntrno");
		this.hashFields.put("pln_yrwk", "plnYrwk");
		this.hashFields.put("trsp_mod_cd", "trspModCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("to_yd_cd", "toYdCd");
		this.hashFields.put("repo_pln_id", "repoPlnId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_del", "cntrDel");
		this.hashFields.put("fm_etd_dt", "fmEtdDt");
		this.hashFields.put("to_eta_dt", "toEtaDt");
		this.hashFields.put("tpszno", "tpszno");
		this.hashFields.put("eq_repo_purp_cd", "eqRepoPurpCd");
		this.hashFields.put("so_iss_flg", "soIssFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return frlocRcc
	 */
	public String getFrlocRcc() {
		return this.frlocRcc;
	}
	
	/**
	 * Column Info
	 * @return coCd
	 */
	public String getCoCd() {
		return this.coCd;
	}
	
	/**
	 * Column Info
	 * @return fmYdCd
	 */
	public String getFmYdCd() {
		return this.fmYdCd;
	}
	
	/**
	 * Column Info
	 * @return refId
	 */
	public String getRefId() {
		return this.refId;
	}
	
	/**
	 * Column Info
	 * @return soCancelFlag
	 */
	public String getSoCancelFlag() {
		return this.soCancelFlag;
	}
	
	/**
	 * Column Info
	 * @return cntrno
	 */
	public String getCntrno() {
		return this.cntrno;
	}
	
	/**
	 * Column Info
	 * @return plnYrwk
	 */
	public String getPlnYrwk() {
		return this.plnYrwk;
	}
	
	/**
	 * Column Info
	 * @return trspModCd
	 */
	public String getTrspModCd() {
		return this.trspModCd;
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
	 * @return toYdCd
	 */
	public String getToYdCd() {
		return this.toYdCd;
	}
	
	/**
	 * Column Info
	 * @return repoPlnId
	 */
	public String getRepoPlnId() {
		return this.repoPlnId;
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
	 * @return cntrDel
	 */
	public String getCntrDel() {
		return this.cntrDel;
	}
	
	/**
	 * Column Info
	 * @return fmEtdDt
	 */
	public String getFmEtdDt() {
		return this.fmEtdDt;
	}
	
	/**
	 * Column Info
	 * @return toEtaDt
	 */
	public String getToEtaDt() {
		return this.toEtaDt;
	}
	
	/**
	 * Column Info
	 * @return tpszno
	 */
	public String getTpszno() {
		return this.tpszno;
	}
	
	/**
	 * Column Info
	 * @return eqRepoPurpCd
	 */
	public String getEqRepoPurpCd() {
		return this.eqRepoPurpCd;
	}
	
	/**
	 * Column Info
	 * @return soIssFlg
	 */
	public String getSoIssFlg() {
		return this.soIssFlg;
	}
	

	/**
	 * Column Info
	 * @param frlocRcc
	 */
	public void setFrlocRcc(String frlocRcc) {
		this.frlocRcc = frlocRcc;
	}
	
	/**
	 * Column Info
	 * @param coCd
	 */
	public void setCoCd(String coCd) {
		this.coCd = coCd;
	}
	
	/**
	 * Column Info
	 * @param fmYdCd
	 */
	public void setFmYdCd(String fmYdCd) {
		this.fmYdCd = fmYdCd;
	}
	
	/**
	 * Column Info
	 * @param refId
	 */
	public void setRefId(String refId) {
		this.refId = refId;
	}
	
	/**
	 * Column Info
	 * @param soCancelFlag
	 */
	public void setSoCancelFlag(String soCancelFlag) {
		this.soCancelFlag = soCancelFlag;
	}
	
	/**
	 * Column Info
	 * @param cntrno
	 */
	public void setCntrno(String cntrno) {
		this.cntrno = cntrno;
	}
	
	/**
	 * Column Info
	 * @param plnYrwk
	 */
	public void setPlnYrwk(String plnYrwk) {
		this.plnYrwk = plnYrwk;
	}
	
	/**
	 * Column Info
	 * @param trspModCd
	 */
	public void setTrspModCd(String trspModCd) {
		this.trspModCd = trspModCd;
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
	 * @param toYdCd
	 */
	public void setToYdCd(String toYdCd) {
		this.toYdCd = toYdCd;
	}
	
	/**
	 * Column Info
	 * @param repoPlnId
	 */
	public void setRepoPlnId(String repoPlnId) {
		this.repoPlnId = repoPlnId;
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
	 * @param cntrDel
	 */
	public void setCntrDel(String cntrDel) {
		this.cntrDel = cntrDel;
	}
	
	/**
	 * Column Info
	 * @param fmEtdDt
	 */
	public void setFmEtdDt(String fmEtdDt) {
		this.fmEtdDt = fmEtdDt;
	}
	
	/**
	 * Column Info
	 * @param toEtaDt
	 */
	public void setToEtaDt(String toEtaDt) {
		this.toEtaDt = toEtaDt;
	}
	
	/**
	 * Column Info
	 * @param tpszno
	 */
	public void setTpszno(String tpszno) {
		this.tpszno = tpszno;
	}
	
	/**
	 * Column Info
	 * @param eqRepoPurpCd
	 */
	public void setEqRepoPurpCd(String eqRepoPurpCd) {
		this.eqRepoPurpCd = eqRepoPurpCd;
	}
	
	/**
	 * Column Info
	 * @param soIssFlg
	 */
	public void setSoIssFlg(String soIssFlg) {
		this.soIssFlg = soIssFlg;
	}
	
	public List<String> getVolList() {
		return volList;
	}

	public void setVolList(List<String> volList) {
		this.volList = volList;
	}

	public List<String> getFlagList() {
		return flagList;
	}

	public void setFlagList(List<String> flagList) {
		this.flagList = flagList;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFrlocRcc(JSPUtil.getParameter(request, "frloc_rcc", ""));
		setCoCd(JSPUtil.getParameter(request, "co_cd", ""));
		setFmYdCd(JSPUtil.getParameter(request, "fm_yd_cd", ""));
		setRefId(JSPUtil.getParameter(request, "ref_id", ""));
		setSoCancelFlag(JSPUtil.getParameter(request, "so_cancel_flag", ""));
		setCntrno(JSPUtil.getParameter(request, "cntrno", ""));
		setPlnYrwk(JSPUtil.getParameter(request, "pln_yrwk", ""));
		setTrspModCd(JSPUtil.getParameter(request, "trsp_mod_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setToYdCd(JSPUtil.getParameter(request, "to_yd_cd", ""));
		setRepoPlnId(JSPUtil.getParameter(request, "repo_pln_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntrDel(JSPUtil.getParameter(request, "cntrdel", ""));
		setFmEtdDt(JSPUtil.getParameter(request, "fm_etd_dt", ""));
		setToEtaDt(JSPUtil.getParameter(request, "to_eta_dt", ""));
		setTpszno(JSPUtil.getParameter(request, "tpszno", ""));
		setEqRepoPurpCd(JSPUtil.getParameter(request, "eq_repo_purp_cd", ""));
		setSoIssFlg(JSPUtil.getParameter(request, "so_iss_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr0083MultiVO[]
	 */
	public EesEqr0083MultiVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr0083MultiVO[]
	 */
	public EesEqr0083MultiVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0083MultiVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String tpsztype = JSPUtil.getParameter(request, "tpsztype".trim(), ""); // tpsz value
	    	String[] tpszArr = tpsztype.split(","); 
	    	
			String[] frlocRcc = (JSPUtil.getParameter(request, prefix	+ "frloc_rcc", length));
			String[] coCd = (JSPUtil.getParameter(request, prefix	+ "co_cd", length));
			String[] fmYdCd = (JSPUtil.getParameter(request, prefix	+ "fm_yd_cd", length));
			String[] refId = (JSPUtil.getParameter(request, prefix	+ "ref_id", length));
			String[] soCancelFlag = (JSPUtil.getParameter(request, prefix	+ "so_cancel_flag", length));
			String[] cntrno = (JSPUtil.getParameter(request, prefix	+ "cntrno", length));
			String[] plnYrwk = (JSPUtil.getParameter(request, prefix	+ "pln_yrwk", length));
			String[] trspModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_mod_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] toYdCd = (JSPUtil.getParameter(request, prefix	+ "to_yd_cd", length));
			String[] repoPlnId = (JSPUtil.getParameter(request, prefix	+ "repo_pln_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrDel = (JSPUtil.getParameter(request, prefix	+ "cntrdel", length));
			String[] fmEtdDt = (JSPUtil.getParameter(request, prefix	+ "fm_etd_dt", length));
			String[] toEtaDt = (JSPUtil.getParameter(request, prefix	+ "to_eta_dt", length));
			String[] tpszno = (JSPUtil.getParameter(request, prefix	+ "tpszno", length));
			String[] eqRepoPurpCd = (JSPUtil.getParameter(request, prefix	+ "eq_repo_purp_cd", length));
			String[] soIssFlg = (JSPUtil.getParameter(request, prefix	+ "so_iss_flg", length));
			
			List<String[]> volListArr = new ArrayList<String[]>();
			List<String[]> flagListArr = new ArrayList<String[]>();
			for(int i=0; i<tpszArr.length; i++) {
				String[] volArr = (JSPUtil.getParameter(request, prefix	+ "vol"+tpszArr[i], length));
				String[] flagArr = (JSPUtil.getParameter(request, prefix	+ "flag"+tpszArr[i], length));
				
				volListArr.add(volArr);
				flagListArr.add(flagArr);
			}
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0083MultiVO();
				List<String> volList = new ArrayList<String>();
				List<String> flagList = new ArrayList<String>();
				for(int t=0; t<tpszArr.length; t++) {
					String[] volArr  = (String[])volListArr.get(t);
					String[] flagArr = (String[])flagListArr.get(t);
					
					
					if(volArr[i] != null)
						volList.add(volArr[i]);
					if(flagArr[i] != null)
						flagList.add(flagArr[i]);
				}
				model.setVolList(volList);
				model.setFlagList(flagList);
				
				if (frlocRcc[i] != null)
					model.setFrlocRcc(frlocRcc[i]);
				if (coCd[i] != null)
					model.setCoCd(coCd[i]);
				if (fmYdCd[i] != null)
					model.setFmYdCd(fmYdCd[i]);
				if (refId[i] != null)
					model.setRefId(refId[i]);
				if (soCancelFlag[i] != null)
					model.setSoCancelFlag(soCancelFlag[i]);
				if (cntrno[i] != null)
					model.setCntrno(cntrno[i]);
				if (plnYrwk[i] != null)
					model.setPlnYrwk(plnYrwk[i]);
				if (trspModCd[i] != null)
					model.setTrspModCd(trspModCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (toYdCd[i] != null)
					model.setToYdCd(toYdCd[i]);
				if (repoPlnId[i] != null)
					model.setRepoPlnId(repoPlnId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrDel[i] != null)
					model.setCntrDel(cntrDel[i]);
				if (fmEtdDt[i] != null)
					model.setFmEtdDt(fmEtdDt[i]);
				if (toEtaDt[i] != null)
					model.setToEtaDt(toEtaDt[i]);
				if (tpszno[i] != null)
					model.setTpszno(tpszno[i]);
				if (eqRepoPurpCd[i] != null)
					model.setEqRepoPurpCd(eqRepoPurpCd[i]);
				if (soIssFlg[i] != null)
					model.setSoIssFlg(soIssFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr0083MultiVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr0083MultiVO[]
	 */
	public EesEqr0083MultiVO[] getEesEqr0083MultiVOs(){
		EesEqr0083MultiVO[] vos = (EesEqr0083MultiVO[])models.toArray(new EesEqr0083MultiVO[models.size()]);
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
		this.frlocRcc = this.frlocRcc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coCd = this.coCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmYdCd = this.fmYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refId = this.refId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soCancelFlag = this.soCancelFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrno = this.cntrno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYrwk = this.plnYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspModCd = this.trspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toYdCd = this.toYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoPlnId = this.repoPlnId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDel = this.cntrDel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEtdDt = this.fmEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEtaDt = this.toEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszno = this.tpszno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqRepoPurpCd = this.eqRepoPurpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soIssFlg = this.soIssFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

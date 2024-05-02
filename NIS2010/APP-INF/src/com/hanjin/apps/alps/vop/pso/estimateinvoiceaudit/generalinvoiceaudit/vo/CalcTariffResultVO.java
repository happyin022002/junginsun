/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CalcTariffResultVO.java
*@FileTitle : CalcTariffResultVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.25
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.06.18 김진일 
* 1.0 Creation
* 
* History
* 2010.11.22 진마리아 CHM-201006692-01 Port charge simulation 이 터미널별로 한번에 계산이 될수 있도록 멀티 기능 추가
* 2012.08.02 진마리아 CHM-201219306-01 surcharge 반영(in/out)
* 2012.09.25 진마리아 CHM-201220208-01 YD/ACCT별 Detail 비용을 Excel Down 기능 추가
=========================================================*/

package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo;

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
 * @author 김진일
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CalcTariffResultVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CalcTariffResultVO> models = new ArrayList<CalcTariffResultVO>();
	
	/* Column Info */
	private String tariffAmount = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String displayFormulaDesc = null;
	/* Column Info */
	private String runtimeFormulaDesc = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String tariffUsdAmount = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String acctEngNm = null;
	
	private String inAmt = null;
	private String outAmt = null;
	
	/* Column Info */
	private String exchgRate = null; /* 2015.05.20 */
	
	private String lgsCostCd;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	private ArrayList<Integer> tariffObjList;
	
	public CalcTariffResultVO() {}

	public CalcTariffResultVO(String ibflag, String pagerows, String tariffAmount, String displayFormulaDesc, String runtimeFormulaDesc, String acctCd, String vndrSeq, String vndrLglEngNm, String currCd, String tariffUsdAmount, String ydCd, String acctEngNm, String exchgRate, String lgsCostCd) {
		this.tariffAmount = tariffAmount;
		this.ibflag = ibflag;
		this.displayFormulaDesc = displayFormulaDesc;
		this.runtimeFormulaDesc = runtimeFormulaDesc;
		this.pagerows = pagerows;
		this.acctCd = acctCd;
		this.vndrSeq = vndrSeq;
		this.vndrLglEngNm = vndrLglEngNm;
		this.currCd = currCd;
		this.tariffUsdAmount = tariffUsdAmount;
		this.ydCd = ydCd;
		this.acctEngNm = acctEngNm;
		this.exchgRate = exchgRate;
		this.lgsCostCd = lgsCostCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tariff_amount", getTariffAmount());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("display_formula_desc", getDisplayFormulaDesc());
		this.hashColumns.put("runtime_formula_desc", getRuntimeFormulaDesc());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("tariff_usd_amount", getTariffUsdAmount());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("acct_eng_nm", getAcctEngNm());
		this.hashColumns.put("exchg_rate", getExchgRate());
		this.hashColumns.put("lgs_cost_cd", getLgsCostCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("tariff_amount", "tariffAmount");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("display_formula_desc", "displayFormulaDesc");
		this.hashFields.put("runtime_formula_desc", "runtimeFormulaDesc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("tariff_usd_amount", "tariffUsdAmount");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("acct_eng_nm", "acctEngNm");
		this.hashFields.put("exchg_rate", "exchgRate");
		this.hashFields.put("lgs_cost_cd", "lgsCostCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return exchgRate
	 */
	public String getExchgRate() {
		return this.exchgRate;
	}
	
	/**
	 * Column Info
	 * @return lgsCostCd
	 */
	public String getLgsCostCd() {
		return lgsCostCd;
	}
	
	/**
	 * Column Info
	 * @return tariffAmount
	 */
	public String getTariffAmount() {
		return this.tariffAmount;
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
	 * @return displayFormulaDesc
	 */
	public String getDisplayFormulaDesc() {
		return this.displayFormulaDesc;
	}
	
	/**
	 * Column Info
	 * @return runtimeFormulaDesc
	 */
	public String getRuntimeFormulaDesc() {
		return this.runtimeFormulaDesc;
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
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return tariffUsdAmount
	 */
	public String getTariffUsdAmount() {
		return this.tariffUsdAmount;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return acctEngNm
	 */
	public String getAcctEngNm() {
		return this.acctEngNm;
	}

	/**
	 * Column Info
	 * @param exchgRate
	 */
	public void setExchgRate(String exchgRate) {
		this.exchgRate = exchgRate;
	}
	
	/**
	 * Column Info
	 * @param tariffAmount
	 */
	public void setTariffAmount(String tariffAmount) {
		this.tariffAmount = tariffAmount;
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
	 * @param lgsCostCd
	 */
	public void setLgsCostCd(String lgsCostCd) {
		// TODO Auto-generated method stub
		this.lgsCostCd = lgsCostCd;
	}
	
	/**
	 * Column Info
	 * @param displayFormulaDesc
	 */
	public void setDisplayFormulaDesc(String displayFormulaDesc) {
		this.displayFormulaDesc = displayFormulaDesc;
	}
	
	/**
	 * Column Info
	 * @param runtimeFormulaDesc
	 */
	public void setRuntimeFormulaDesc(String runtimeFormulaDesc) {
		this.runtimeFormulaDesc = runtimeFormulaDesc;
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
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param tariffUsdAmount
	 */
	public void setTariffUsdAmount(String tariffUsdAmount) {
		this.tariffUsdAmount = tariffUsdAmount;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param acctEngNm
	 */
	public void setAcctEngNm(String acctEngNm) {
		this.acctEngNm = acctEngNm;
	}
	
	
	/**
	 * @return inAmt
	 */
	public String getInAmt() {
		return inAmt;
	}

	/**
	 * @param inAmt
	 */
	public void setInAmt(String inAmt) {
		this.inAmt = inAmt;
	}

	/**
	 * @return outAmt
	 */
	public String getOutAmt() {
		return outAmt;
	}

	/**
	 * @param inAmt
	 */
	public void setOutAmt(String outAmt) {
		this.outAmt = outAmt;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTariffAmount(JSPUtil.getParameter(request, "tariff_amount", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDisplayFormulaDesc(JSPUtil.getParameter(request, "display_formula_desc", ""));
		setRuntimeFormulaDesc(JSPUtil.getParameter(request, "runtime_formula_desc", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, "vndr_lgl_eng_nm", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setTariffUsdAmount(JSPUtil.getParameter(request, "tariff_usd_amount", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setAcctEngNm(JSPUtil.getParameter(request, "acct_eng_nm", ""));
		setExchgRate(JSPUtil.getParameter(request, "exchg_rate", ""));
		setLgsCostCd(JSPUtil.getParameter(request, "lgs_cost_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CalcTariffResultVO[]
	 */
	public CalcTariffResultVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CalcTariffResultVO[]
	 */
	public CalcTariffResultVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CalcTariffResultVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] tariffAmount = (JSPUtil.getParameter(request, prefix	+ "tariff_amount", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] displayFormulaDesc = (JSPUtil.getParameter(request, prefix	+ "display_formula_desc", length));
			String[] runtimeFormulaDesc = (JSPUtil.getParameter(request, prefix	+ "runtime_formula_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] tariffUsdAmount = (JSPUtil.getParameter(request, prefix	+ "tariff_usd_amount", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] acctEngNm = (JSPUtil.getParameter(request, prefix	+ "acct_eng_nm", length));
			String[] exchgRate = (JSPUtil.getParameter(request, prefix	+ "exchg_rate", length));
			String[] lgsCostCd = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CalcTariffResultVO();
				if (tariffAmount[i] != null)
					model.setTariffAmount(tariffAmount[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (displayFormulaDesc[i] != null)
					model.setDisplayFormulaDesc(displayFormulaDesc[i]);
				if (runtimeFormulaDesc[i] != null)
					model.setRuntimeFormulaDesc(runtimeFormulaDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (tariffUsdAmount[i] != null)
					model.setTariffUsdAmount(tariffUsdAmount[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (acctEngNm[i] != null)
					model.setAcctEngNm(acctEngNm[i]);
				if (exchgRate[i] != null)
					model.setExchgRate(exchgRate[i]);
				if (lgsCostCd[i] != null)
					model.setLgsCostCd(lgsCostCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCalcTariffResultVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CalcTariffResultVO[]
	 */
	public CalcTariffResultVO[] getCalcTariffResultVOs(){
		CalcTariffResultVO[] vos = (CalcTariffResultVO[])models.toArray(new CalcTariffResultVO[models.size()]);
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
		this.tariffAmount = this.tariffAmount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag       = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.displayFormulaDesc = this.displayFormulaDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.runtimeFormulaDesc = this.runtimeFormulaDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tariffUsdAmount = this.tariffUsdAmount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctEngNm = this.acctEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exchgRate = this.exchgRate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostCd = this.lgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
	
	/**
	 * Tariff에 사용된 Object의 No를 보관한다.
	 * 
	 * @param int objNo;
	 */
	public void addTariffObjList(int objNo){
		if(tariffObjList==null){
			tariffObjList = new ArrayList<Integer>();
		}
		tariffObjList.add(objNo);
	}
	
	/**
	 * Tariff에 사용된 Object의 No를 보관하고 있는 리스트를 설정한다.
	 * 
	 * @param ArrayList<Integer> tariffObjList
	 */
	public void setTariffObjList(ArrayList<Integer> tariffObjList){
		this.tariffObjList = tariffObjList;
	}
	
	/**
	 * Tariff에 사용된 Object의 No를 보관하고 있는 리스트를 반환한다.
	 * 
	 * @return ArrayList<Integer>
	 */
	public ArrayList<Integer> getTariffObjList(){
		return tariffObjList;
	}
	
	/**
	 * Tariff에서 해당 Object를 사용하는지 확인한다.
	 * 
	 * @param int objNo
	 * @return boolean
	 */
	public boolean existObj(int objNo){
		if(tariffObjList!=null){
			if(tariffObjList.contains(objNo)){
				return true;
			}
		}
		return false;
	}
}

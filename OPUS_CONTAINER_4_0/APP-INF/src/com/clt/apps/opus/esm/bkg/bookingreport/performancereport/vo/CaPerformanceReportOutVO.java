/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CaPerformanceReportOutVO.java
*@FileTitle : CaPerformanceReportOutVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.21
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.10.21 강동윤 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo;

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
 * @author 강동윤
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CaPerformanceReportOutVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CaPerformanceReportOutVO> models = new ArrayList<CaPerformanceReportOutVO>();
	
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String totCa = null;
	/* Column Info */
	private String kindJ = null;
	/* Column Info */
	private String kindK = null;
	/* Column Info */
	private String reaR = null;
	/* Column Info */
	private String kindH = null;
	/* Column Info */
	private String kindI = null;
	/* Column Info */
	private String kindF = null;
	/* Column Info */
	private String kindG = null;
	/* Column Info */
	private String kindD = null;
	/* Column Info */
	private String reaO = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String kindE = null;
	/* Column Info */
	private String kindC = null;
	/* Column Info */
	private String kindB = null;
	/* Column Info */
	private String totBl = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String kindA = null;
	/* Column Info */
	private String reaA = null;
	/* Column Info */
	private String ratio = null;
	/* Column Info */
	private String reaC = null;
	/* Column Info */
	private String reaG = null;
	/* Column Info */
	private String reaM = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CaPerformanceReportOutVO() {}

	public CaPerformanceReportOutVO(String ibflag, String pagerows, String custNm, String kindA, String kindB, String kindC, String kindD, String kindE, String kindF, String kindG, String kindH, String kindI, String kindJ, String kindK, String reaM, String reaC, String reaG, String reaA, String reaO, String reaR, String totBl, String totCa, String ratio, String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
		this.custNm = custNm;
		this.totCa = totCa;
		this.kindJ = kindJ;
		this.kindK = kindK;
		this.reaR = reaR;
		this.kindH = kindH;
		this.kindI = kindI;
		this.kindF = kindF;
		this.kindG = kindG;
		this.kindD = kindD;
		this.reaO = reaO;
		this.pagerows = pagerows;
		this.kindE = kindE;
		this.kindC = kindC;
		this.kindB = kindB;
		this.totBl = totBl;
		this.ibflag = ibflag;
		this.kindA = kindA;
		this.reaA = reaA;
		this.ratio = ratio;
		this.reaC = reaC;
		this.reaG = reaG;
		this.reaM = reaM;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("tot_ca", getTotCa());
		this.hashColumns.put("kind_j", getKindJ());
		this.hashColumns.put("kind_k", getKindK());
		this.hashColumns.put("rea_r", getReaR());
		this.hashColumns.put("kind_h", getKindH());
		this.hashColumns.put("kind_i", getKindI());
		this.hashColumns.put("kind_f", getKindF());
		this.hashColumns.put("kind_g", getKindG());
		this.hashColumns.put("kind_d", getKindD());
		this.hashColumns.put("rea_o", getReaO());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("kind_e", getKindE());
		this.hashColumns.put("kind_c", getKindC());
		this.hashColumns.put("kind_b", getKindB());
		this.hashColumns.put("tot_bl", getTotBl());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("kind_a", getKindA());
		this.hashColumns.put("rea_a", getReaA());
		this.hashColumns.put("ratio", getRatio());
		this.hashColumns.put("rea_c", getReaC());
		this.hashColumns.put("rea_g", getReaG());
		this.hashColumns.put("rea_m", getReaM());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("tot_ca", "totCa");
		this.hashFields.put("kind_j", "kindJ");
		this.hashFields.put("kind_k", "kindK");
		this.hashFields.put("rea_r", "reaR");
		this.hashFields.put("kind_h", "kindH");
		this.hashFields.put("kind_i", "kindI");
		this.hashFields.put("kind_f", "kindF");
		this.hashFields.put("kind_g", "kindG");
		this.hashFields.put("kind_d", "kindD");
		this.hashFields.put("rea_o", "reaO");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("kind_e", "kindE");
		this.hashFields.put("kind_c", "kindC");
		this.hashFields.put("kind_b", "kindB");
		this.hashFields.put("tot_bl", "totBl");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("kind_a", "kindA");
		this.hashFields.put("rea_a", "reaA");
		this.hashFields.put("ratio", "ratio");
		this.hashFields.put("rea_c", "reaC");
		this.hashFields.put("rea_g", "reaG");
		this.hashFields.put("rea_m", "reaM");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
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
	 * @return totCa
	 */
	public String getTotCa() {
		return this.totCa;
	}
	
	/**
	 * Column Info
	 * @return kindJ
	 */
	public String getKindJ() {
		return this.kindJ;
	}
	
	/**
	 * Column Info
	 * @return kindK
	 */
	public String getKindK() {
		return this.kindK;
	}
	
	/**
	 * Column Info
	 * @return reaR
	 */
	public String getReaR() {
		return this.reaR;
	}
	
	/**
	 * Column Info
	 * @return kindH
	 */
	public String getKindH() {
		return this.kindH;
	}
	
	/**
	 * Column Info
	 * @return kindI
	 */
	public String getKindI() {
		return this.kindI;
	}
	
	/**
	 * Column Info
	 * @return kindF
	 */
	public String getKindF() {
		return this.kindF;
	}
	
	/**
	 * Column Info
	 * @return kindG
	 */
	public String getKindG() {
		return this.kindG;
	}
	
	/**
	 * Column Info
	 * @return kindD
	 */
	public String getKindD() {
		return this.kindD;
	}
	
	/**
	 * Column Info
	 * @return reaO
	 */
	public String getReaO() {
		return this.reaO;
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
	 * @return kindE
	 */
	public String getKindE() {
		return this.kindE;
	}
	
	/**
	 * Column Info
	 * @return kindC
	 */
	public String getKindC() {
		return this.kindC;
	}
	
	/**
	 * Column Info
	 * @return kindB
	 */
	public String getKindB() {
		return this.kindB;
	}
	
	/**
	 * Column Info
	 * @return totBl
	 */
	public String getTotBl() {
		return this.totBl;
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
	 * @return kindA
	 */
	public String getKindA() {
		return this.kindA;
	}
	
	/**
	 * Column Info
	 * @return reaA
	 */
	public String getReaA() {
		return this.reaA;
	}
	
	/**
	 * Column Info
	 * @return ratio
	 */
	public String getRatio() {
		return this.ratio;
	}
	
	/**
	 * Column Info
	 * @return reaC
	 */
	public String getReaC() {
		return this.reaC;
	}
	
	/**
	 * Column Info
	 * @return reaG
	 */
	public String getReaG() {
		return this.reaG;
	}
	
	/**
	 * Column Info
	 * @return reaM
	 */
	public String getReaM() {
		return this.reaM;
	}
	

	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
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
	 * @param totCa
	 */
	public void setTotCa(String totCa) {
		this.totCa = totCa;
	}
	
	/**
	 * Column Info
	 * @param kindJ
	 */
	public void setKindJ(String kindJ) {
		this.kindJ = kindJ;
	}
	
	/**
	 * Column Info
	 * @param kindK
	 */
	public void setKindK(String kindK) {
		this.kindK = kindK;
	}
	
	/**
	 * Column Info
	 * @param reaR
	 */
	public void setReaR(String reaR) {
		this.reaR = reaR;
	}
	
	/**
	 * Column Info
	 * @param kindH
	 */
	public void setKindH(String kindH) {
		this.kindH = kindH;
	}
	
	/**
	 * Column Info
	 * @param kindI
	 */
	public void setKindI(String kindI) {
		this.kindI = kindI;
	}
	
	/**
	 * Column Info
	 * @param kindF
	 */
	public void setKindF(String kindF) {
		this.kindF = kindF;
	}
	
	/**
	 * Column Info
	 * @param kindG
	 */
	public void setKindG(String kindG) {
		this.kindG = kindG;
	}
	
	/**
	 * Column Info
	 * @param kindD
	 */
	public void setKindD(String kindD) {
		this.kindD = kindD;
	}
	
	/**
	 * Column Info
	 * @param reaO
	 */
	public void setReaO(String reaO) {
		this.reaO = reaO;
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
	 * @param kindE
	 */
	public void setKindE(String kindE) {
		this.kindE = kindE;
	}
	
	/**
	 * Column Info
	 * @param kindC
	 */
	public void setKindC(String kindC) {
		this.kindC = kindC;
	}
	
	/**
	 * Column Info
	 * @param kindB
	 */
	public void setKindB(String kindB) {
		this.kindB = kindB;
	}
	
	/**
	 * Column Info
	 * @param totBl
	 */
	public void setTotBl(String totBl) {
		this.totBl = totBl;
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
	 * @param kindA
	 */
	public void setKindA(String kindA) {
		this.kindA = kindA;
	}
	
	/**
	 * Column Info
	 * @param reaA
	 */
	public void setReaA(String reaA) {
		this.reaA = reaA;
	}
	
	/**
	 * Column Info
	 * @param ratio
	 */
	public void setRatio(String ratio) {
		this.ratio = ratio;
	}
	
	/**
	 * Column Info
	 * @param reaC
	 */
	public void setReaC(String reaC) {
		this.reaC = reaC;
	}
	
	/**
	 * Column Info
	 * @param reaG
	 */
	public void setReaG(String reaG) {
		this.reaG = reaG;
	}
	
	/**
	 * Column Info
	 * @param reaM
	 */
	public void setReaM(String reaM) {
		this.reaM = reaM;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBkgOfcCd(JSPUtil.getParameter(request, "bkg_ofc_cd", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setTotCa(JSPUtil.getParameter(request, "tot_ca", ""));
		setKindJ(JSPUtil.getParameter(request, "kind_j", ""));
		setKindK(JSPUtil.getParameter(request, "kind_k", ""));
		setReaR(JSPUtil.getParameter(request, "rea_r", ""));
		setKindH(JSPUtil.getParameter(request, "kind_h", ""));
		setKindI(JSPUtil.getParameter(request, "kind_i", ""));
		setKindF(JSPUtil.getParameter(request, "kind_f", ""));
		setKindG(JSPUtil.getParameter(request, "kind_g", ""));
		setKindD(JSPUtil.getParameter(request, "kind_d", ""));
		setReaO(JSPUtil.getParameter(request, "rea_o", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setKindE(JSPUtil.getParameter(request, "kind_e", ""));
		setKindC(JSPUtil.getParameter(request, "kind_c", ""));
		setKindB(JSPUtil.getParameter(request, "kind_b", ""));
		setTotBl(JSPUtil.getParameter(request, "tot_bl", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setKindA(JSPUtil.getParameter(request, "kind_a", ""));
		setReaA(JSPUtil.getParameter(request, "rea_a", ""));
		setRatio(JSPUtil.getParameter(request, "ratio", ""));
		setReaC(JSPUtil.getParameter(request, "rea_c", ""));
		setReaG(JSPUtil.getParameter(request, "rea_g", ""));
		setReaM(JSPUtil.getParameter(request, "rea_m", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CaPerformanceReportOutVO[]
	 */
	public CaPerformanceReportOutVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CaPerformanceReportOutVO[]
	 */
	public CaPerformanceReportOutVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CaPerformanceReportOutVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] totCa = (JSPUtil.getParameter(request, prefix	+ "tot_ca", length));
			String[] kindJ = (JSPUtil.getParameter(request, prefix	+ "kind_j", length));
			String[] kindK = (JSPUtil.getParameter(request, prefix	+ "kind_k", length));
			String[] reaR = (JSPUtil.getParameter(request, prefix	+ "rea_r", length));
			String[] kindH = (JSPUtil.getParameter(request, prefix	+ "kind_h", length));
			String[] kindI = (JSPUtil.getParameter(request, prefix	+ "kind_i", length));
			String[] kindF = (JSPUtil.getParameter(request, prefix	+ "kind_f", length));
			String[] kindG = (JSPUtil.getParameter(request, prefix	+ "kind_g", length));
			String[] kindD = (JSPUtil.getParameter(request, prefix	+ "kind_d", length));
			String[] reaO = (JSPUtil.getParameter(request, prefix	+ "rea_o", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] kindE = (JSPUtil.getParameter(request, prefix	+ "kind_e", length));
			String[] kindC = (JSPUtil.getParameter(request, prefix	+ "kind_c", length));
			String[] kindB = (JSPUtil.getParameter(request, prefix	+ "kind_b", length));
			String[] totBl = (JSPUtil.getParameter(request, prefix	+ "tot_bl", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] kindA = (JSPUtil.getParameter(request, prefix	+ "kind_a", length));
			String[] reaA = (JSPUtil.getParameter(request, prefix	+ "rea_a", length));
			String[] ratio = (JSPUtil.getParameter(request, prefix	+ "ratio", length));
			String[] reaC = (JSPUtil.getParameter(request, prefix	+ "rea_c", length));
			String[] reaG = (JSPUtil.getParameter(request, prefix	+ "rea_g", length));
			String[] reaM = (JSPUtil.getParameter(request, prefix	+ "rea_m", length));
			
			for (int i = 0; i < length; i++) {
				model = new CaPerformanceReportOutVO();
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (totCa[i] != null)
					model.setTotCa(totCa[i]);
				if (kindJ[i] != null)
					model.setKindJ(kindJ[i]);
				if (kindK[i] != null)
					model.setKindK(kindK[i]);
				if (reaR[i] != null)
					model.setReaR(reaR[i]);
				if (kindH[i] != null)
					model.setKindH(kindH[i]);
				if (kindI[i] != null)
					model.setKindI(kindI[i]);
				if (kindF[i] != null)
					model.setKindF(kindF[i]);
				if (kindG[i] != null)
					model.setKindG(kindG[i]);
				if (kindD[i] != null)
					model.setKindD(kindD[i]);
				if (reaO[i] != null)
					model.setReaO(reaO[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (kindE[i] != null)
					model.setKindE(kindE[i]);
				if (kindC[i] != null)
					model.setKindC(kindC[i]);
				if (kindB[i] != null)
					model.setKindB(kindB[i]);
				if (totBl[i] != null)
					model.setTotBl(totBl[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (kindA[i] != null)
					model.setKindA(kindA[i]);
				if (reaA[i] != null)
					model.setReaA(reaA[i]);
				if (ratio[i] != null)
					model.setRatio(ratio[i]);
				if (reaC[i] != null)
					model.setReaC(reaC[i]);
				if (reaG[i] != null)
					model.setReaG(reaG[i]);
				if (reaM[i] != null)
					model.setReaM(reaM[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCaPerformanceReportOutVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CaPerformanceReportOutVO[]
	 */
	public CaPerformanceReportOutVO[] getCaPerformanceReportOutVOs(){
		CaPerformanceReportOutVO[] vos = (CaPerformanceReportOutVO[])models.toArray(new CaPerformanceReportOutVO[models.size()]);
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
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totCa = this.totCa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kindJ = this.kindJ .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kindK = this.kindK .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reaR = this.reaR .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kindH = this.kindH .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kindI = this.kindI .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kindF = this.kindF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kindG = this.kindG .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kindD = this.kindD .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reaO = this.reaO .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kindE = this.kindE .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kindC = this.kindC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kindB = this.kindB .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totBl = this.totBl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kindA = this.kindA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reaA = this.reaA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratio = this.ratio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reaC = this.reaC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reaG = this.reaG .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reaM = this.reaM .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

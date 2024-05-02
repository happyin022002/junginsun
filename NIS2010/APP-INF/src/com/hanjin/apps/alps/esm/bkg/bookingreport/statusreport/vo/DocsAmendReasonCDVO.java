/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DocsAmendReasonCDVO.java
*@FileTitle : DocsAmendReasonCDVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.09.07 김경섭 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo;

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
 * @author 김경섭
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DocsAmendReasonCDVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DocsAmendReasonCDVO> models = new ArrayList<DocsAmendReasonCDVO>();
	
	/* Column Info */
	private String misRatRfa = null;
	/* Column Info */
	private String blDatCha = null;
	/* Column Info */
	private String sal = null;
	/* Column Info */
	private String datMis = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String misRatSc = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String uncFax = null;
	/* Column Info */
	private String cod = null;
	/* Column Info */
	private String spl = null;
	/* Column Info */
	private String wroDatInp = null;
	/* Column Info */
	private String foErr = null;
	/* Column Info */
	private String misTyp = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DocsAmendReasonCDVO() {}

	public DocsAmendReasonCDVO(String ibflag, String pagerows, String misTyp, String misRatSc, String misRatRfa, String wroDatInp, String sal, String foErr, String datMis, String uncFax, String blDatCha, String cod, String spl) {
		this.misRatRfa = misRatRfa;
		this.blDatCha = blDatCha;
		this.sal = sal;
		this.datMis = datMis;
		this.pagerows = pagerows;
		this.misRatSc = misRatSc;
		this.ibflag = ibflag;
		this.uncFax = uncFax;
		this.cod = cod;
		this.spl = spl;
		this.wroDatInp = wroDatInp;
		this.foErr = foErr;
		this.misTyp = misTyp;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mis_rat_rfa", getMisRatRfa());
		this.hashColumns.put("bl_dat_cha", getBlDatCha());
		this.hashColumns.put("sal", getSal());
		this.hashColumns.put("dat_mis", getDatMis());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mis_rat_sc", getMisRatSc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("unc_fax", getUncFax());
		this.hashColumns.put("cod", getCod());
		this.hashColumns.put("spl", getSpl());
		this.hashColumns.put("wro_dat_inp", getWroDatInp());
		this.hashColumns.put("fo_err", getFoErr());
		this.hashColumns.put("mis_typ", getMisTyp());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mis_rat_rfa", "misRatRfa");
		this.hashFields.put("bl_dat_cha", "blDatCha");
		this.hashFields.put("sal", "sal");
		this.hashFields.put("dat_mis", "datMis");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mis_rat_sc", "misRatSc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("unc_fax", "uncFax");
		this.hashFields.put("cod", "cod");
		this.hashFields.put("spl", "spl");
		this.hashFields.put("wro_dat_inp", "wroDatInp");
		this.hashFields.put("fo_err", "foErr");
		this.hashFields.put("mis_typ", "misTyp");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return misRatRfa
	 */
	public String getMisRatRfa() {
		return this.misRatRfa;
	}
	
	/**
	 * Column Info
	 * @return blDatCha
	 */
	public String getBlDatCha() {
		return this.blDatCha;
	}
	
	/**
	 * Column Info
	 * @return sal
	 */
	public String getSal() {
		return this.sal;
	}
	
	/**
	 * Column Info
	 * @return datMis
	 */
	public String getDatMis() {
		return this.datMis;
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
	 * @return misRatSc
	 */
	public String getMisRatSc() {
		return this.misRatSc;
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
	 * @return uncFax
	 */
	public String getUncFax() {
		return this.uncFax;
	}
	
	/**
	 * Column Info
	 * @return cod
	 */
	public String getCod() {
		return this.cod;
	}
	
	/**
	 * Column Info
	 * @return spl
	 */
	public String getSpl() {
		return this.spl;
	}
	
	/**
	 * Column Info
	 * @return wroDatInp
	 */
	public String getWroDatInp() {
		return this.wroDatInp;
	}
	
	/**
	 * Column Info
	 * @return foErr
	 */
	public String getFoErr() {
		return this.foErr;
	}
	
	/**
	 * Column Info
	 * @return misTyp
	 */
	public String getMisTyp() {
		return this.misTyp;
	}
	

	/**
	 * Column Info
	 * @param misRatRfa
	 */
	public void setMisRatRfa(String misRatRfa) {
		this.misRatRfa = misRatRfa;
	}
	
	/**
	 * Column Info
	 * @param blDatCha
	 */
	public void setBlDatCha(String blDatCha) {
		this.blDatCha = blDatCha;
	}
	
	/**
	 * Column Info
	 * @param sal
	 */
	public void setSal(String sal) {
		this.sal = sal;
	}
	
	/**
	 * Column Info
	 * @param datMis
	 */
	public void setDatMis(String datMis) {
		this.datMis = datMis;
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
	 * @param misRatSc
	 */
	public void setMisRatSc(String misRatSc) {
		this.misRatSc = misRatSc;
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
	 * @param uncFax
	 */
	public void setUncFax(String uncFax) {
		this.uncFax = uncFax;
	}
	
	/**
	 * Column Info
	 * @param cod
	 */
	public void setCod(String cod) {
		this.cod = cod;
	}
	
	/**
	 * Column Info
	 * @param spl
	 */
	public void setSpl(String spl) {
		this.spl = spl;
	}
	
	/**
	 * Column Info
	 * @param wroDatInp
	 */
	public void setWroDatInp(String wroDatInp) {
		this.wroDatInp = wroDatInp;
	}
	
	/**
	 * Column Info
	 * @param foErr
	 */
	public void setFoErr(String foErr) {
		this.foErr = foErr;
	}
	
	/**
	 * Column Info
	 * @param misTyp
	 */
	public void setMisTyp(String misTyp) {
		this.misTyp = misTyp;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setMisRatRfa(JSPUtil.getParameter(request, "mis_rat_rfa", ""));
		setBlDatCha(JSPUtil.getParameter(request, "bl_dat_cha", ""));
		setSal(JSPUtil.getParameter(request, "sal", ""));
		setDatMis(JSPUtil.getParameter(request, "dat_mis", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setMisRatSc(JSPUtil.getParameter(request, "mis_rat_sc", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setUncFax(JSPUtil.getParameter(request, "unc_fax", ""));
		setCod(JSPUtil.getParameter(request, "cod", ""));
		setSpl(JSPUtil.getParameter(request, "spl", ""));
		setWroDatInp(JSPUtil.getParameter(request, "wro_dat_inp", ""));
		setFoErr(JSPUtil.getParameter(request, "fo_err", ""));
		setMisTyp(JSPUtil.getParameter(request, "mis_typ", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DocsAmendReasonCDVO[]
	 */
	public DocsAmendReasonCDVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DocsAmendReasonCDVO[]
	 */
	public DocsAmendReasonCDVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DocsAmendReasonCDVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] misRatRfa = (JSPUtil.getParameter(request, prefix	+ "mis_rat_rfa", length));
			String[] blDatCha = (JSPUtil.getParameter(request, prefix	+ "bl_dat_cha", length));
			String[] sal = (JSPUtil.getParameter(request, prefix	+ "sal", length));
			String[] datMis = (JSPUtil.getParameter(request, prefix	+ "dat_mis", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] misRatSc = (JSPUtil.getParameter(request, prefix	+ "mis_rat_sc", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] uncFax = (JSPUtil.getParameter(request, prefix	+ "unc_fax", length));
			String[] cod = (JSPUtil.getParameter(request, prefix	+ "cod", length));
			String[] spl = (JSPUtil.getParameter(request, prefix	+ "spl", length));
			String[] wroDatInp = (JSPUtil.getParameter(request, prefix	+ "wro_dat_inp", length));
			String[] foErr = (JSPUtil.getParameter(request, prefix	+ "fo_err", length));
			String[] misTyp = (JSPUtil.getParameter(request, prefix	+ "mis_typ", length));
			
			for (int i = 0; i < length; i++) {
				model = new DocsAmendReasonCDVO();
				if (misRatRfa[i] != null)
					model.setMisRatRfa(misRatRfa[i]);
				if (blDatCha[i] != null)
					model.setBlDatCha(blDatCha[i]);
				if (sal[i] != null)
					model.setSal(sal[i]);
				if (datMis[i] != null)
					model.setDatMis(datMis[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (misRatSc[i] != null)
					model.setMisRatSc(misRatSc[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (uncFax[i] != null)
					model.setUncFax(uncFax[i]);
				if (cod[i] != null)
					model.setCod(cod[i]);
				if (spl[i] != null)
					model.setSpl(spl[i]);
				if (wroDatInp[i] != null)
					model.setWroDatInp(wroDatInp[i]);
				if (foErr[i] != null)
					model.setFoErr(foErr[i]);
				if (misTyp[i] != null)
					model.setMisTyp(misTyp[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDocsAmendReasonCDVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DocsAmendReasonCDVO[]
	 */
	public DocsAmendReasonCDVO[] getDocsAmendReasonCDVOs(){
		DocsAmendReasonCDVO[] vos = (DocsAmendReasonCDVO[])models.toArray(new DocsAmendReasonCDVO[models.size()]);
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
		this.misRatRfa = this.misRatRfa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blDatCha = this.blDatCha .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sal = this.sal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.datMis = this.datMis .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.misRatSc = this.misRatSc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uncFax = this.uncFax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cod = this.cod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spl = this.spl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wroDatInp = this.wroDatInp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foErr = this.foErr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.misTyp = this.misTyp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SheetOptionTermTitleListUpVO.java
*@FileTitle : SheetOptionTermTitleListUpVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.30
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.09.30 문중철 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo;

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
 * @author 문중철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SheetOptionTermTitleListUpVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SheetOptionTermTitleListUpVO> models = new ArrayList<SheetOptionTermTitleListUpVO>();
	
	/* Column Info */
	private String dtic = null;
	/* Column Info */
	private String alll = null;
	/* Column Info */
	private String dmof = null;
	/* Column Info */
	private String ctoc = null;
	/* Column Info */
	private String issd = null;
	/* Column Info */
	private String titl = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String shtp = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dtoc = null;
	/* Column Info */
	private String term = null;
	/* Column Info */
	private String ctic = null;
	/* Column Info */
	private String seqq = null;
	/* Column Info */
	private String dmif = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SheetOptionTermTitleListUpVO() {}

	public SheetOptionTermTitleListUpVO(String ibflag, String pagerows, String seqq, String alll, String dmif, String dtic, String dmof, String dtoc, String ctic, String ctoc, String term, String issd, String titl, String shtp) {
		this.dtic = dtic;
		this.alll = alll;
		this.dmof = dmof;
		this.ctoc = ctoc;
		this.issd = issd;
		this.titl = titl;
		this.pagerows = pagerows;
		this.shtp = shtp;
		this.ibflag = ibflag;
		this.dtoc = dtoc;
		this.term = term;
		this.ctic = ctic;
		this.seqq = seqq;
		this.dmif = dmif;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dtic", getDtic());
		this.hashColumns.put("alll", getAlll());
		this.hashColumns.put("dmof", getDmof());
		this.hashColumns.put("ctoc", getCtoc());
		this.hashColumns.put("issd", getIssd());
		this.hashColumns.put("titl", getTitl());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("shtp", getShtp());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dtoc", getDtoc());
		this.hashColumns.put("term", getTerm());
		this.hashColumns.put("ctic", getCtic());
		this.hashColumns.put("seqq", getSeqq());
		this.hashColumns.put("dmif", getDmif());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dtic", "dtic");
		this.hashFields.put("alll", "alll");
		this.hashFields.put("dmof", "dmof");
		this.hashFields.put("ctoc", "ctoc");
		this.hashFields.put("issd", "issd");
		this.hashFields.put("titl", "titl");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("shtp", "shtp");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dtoc", "dtoc");
		this.hashFields.put("term", "term");
		this.hashFields.put("ctic", "ctic");
		this.hashFields.put("seqq", "seqq");
		this.hashFields.put("dmif", "dmif");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dtic
	 */
	public String getDtic() {
		return this.dtic;
	}
	
	/**
	 * Column Info
	 * @return alll
	 */
	public String getAlll() {
		return this.alll;
	}
	
	/**
	 * Column Info
	 * @return dmof
	 */
	public String getDmof() {
		return this.dmof;
	}
	
	/**
	 * Column Info
	 * @return ctoc
	 */
	public String getCtoc() {
		return this.ctoc;
	}
	
	/**
	 * Column Info
	 * @return issd
	 */
	public String getIssd() {
		return this.issd;
	}
	
	/**
	 * Column Info
	 * @return titl
	 */
	public String getTitl() {
		return this.titl;
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
	 * @return shtp
	 */
	public String getShtp() {
		return this.shtp;
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
	 * @return dtoc
	 */
	public String getDtoc() {
		return this.dtoc;
	}
	
	/**
	 * Column Info
	 * @return term
	 */
	public String getTerm() {
		return this.term;
	}
	
	/**
	 * Column Info
	 * @return ctic
	 */
	public String getCtic() {
		return this.ctic;
	}
	
	/**
	 * Column Info
	 * @return seqq
	 */
	public String getSeqq() {
		return this.seqq;
	}
	
	/**
	 * Column Info
	 * @return dmif
	 */
	public String getDmif() {
		return this.dmif;
	}
	

	/**
	 * Column Info
	 * @param dtic
	 */
	public void setDtic(String dtic) {
		this.dtic = dtic;
	}
	
	/**
	 * Column Info
	 * @param alll
	 */
	public void setAlll(String alll) {
		this.alll = alll;
	}
	
	/**
	 * Column Info
	 * @param dmof
	 */
	public void setDmof(String dmof) {
		this.dmof = dmof;
	}
	
	/**
	 * Column Info
	 * @param ctoc
	 */
	public void setCtoc(String ctoc) {
		this.ctoc = ctoc;
	}
	
	/**
	 * Column Info
	 * @param issd
	 */
	public void setIssd(String issd) {
		this.issd = issd;
	}
	
	/**
	 * Column Info
	 * @param titl
	 */
	public void setTitl(String titl) {
		this.titl = titl;
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
	 * @param shtp
	 */
	public void setShtp(String shtp) {
		this.shtp = shtp;
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
	 * @param dtoc
	 */
	public void setDtoc(String dtoc) {
		this.dtoc = dtoc;
	}
	
	/**
	 * Column Info
	 * @param term
	 */
	public void setTerm(String term) {
		this.term = term;
	}
	
	/**
	 * Column Info
	 * @param ctic
	 */
	public void setCtic(String ctic) {
		this.ctic = ctic;
	}
	
	/**
	 * Column Info
	 * @param seqq
	 */
	public void setSeqq(String seqq) {
		this.seqq = seqq;
	}
	
	/**
	 * Column Info
	 * @param dmif
	 */
	public void setDmif(String dmif) {
		this.dmif = dmif;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setDtic(JSPUtil.getParameter(request, "dtic", ""));
		setAlll(JSPUtil.getParameter(request, "alll", ""));
		setDmof(JSPUtil.getParameter(request, "dmof", ""));
		setCtoc(JSPUtil.getParameter(request, "ctoc", ""));
		setIssd(JSPUtil.getParameter(request, "issd", ""));
		setTitl(JSPUtil.getParameter(request, "titl", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setShtp(JSPUtil.getParameter(request, "shtp", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDtoc(JSPUtil.getParameter(request, "dtoc", ""));
		setTerm(JSPUtil.getParameter(request, "term", ""));
		setCtic(JSPUtil.getParameter(request, "ctic", ""));
		setSeqq(JSPUtil.getParameter(request, "seqq", ""));
		setDmif(JSPUtil.getParameter(request, "dmif", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SheetOptionTermTitleListUpVO[]
	 */
	public SheetOptionTermTitleListUpVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SheetOptionTermTitleListUpVO[]
	 */
	public SheetOptionTermTitleListUpVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SheetOptionTermTitleListUpVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dtic = (JSPUtil.getParameter(request, prefix	+ "dtic", length));
			String[] alll = (JSPUtil.getParameter(request, prefix	+ "alll", length));
			String[] dmof = (JSPUtil.getParameter(request, prefix	+ "dmof", length));
			String[] ctoc = (JSPUtil.getParameter(request, prefix	+ "ctoc", length));
			String[] issd = (JSPUtil.getParameter(request, prefix	+ "issd", length));
			String[] titl = (JSPUtil.getParameter(request, prefix	+ "titl", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] shtp = (JSPUtil.getParameter(request, prefix	+ "shtp", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dtoc = (JSPUtil.getParameter(request, prefix	+ "dtoc", length));
			String[] term = (JSPUtil.getParameter(request, prefix	+ "term", length));
			String[] ctic = (JSPUtil.getParameter(request, prefix	+ "ctic", length));
			String[] seqq = (JSPUtil.getParameter(request, prefix	+ "seqq", length));
			String[] dmif = (JSPUtil.getParameter(request, prefix	+ "dmif", length));
			
			for (int i = 0; i < length; i++) {
				model = new SheetOptionTermTitleListUpVO();
				if (dtic[i] != null)
					model.setDtic(dtic[i]);
				if (alll[i] != null)
					model.setAlll(alll[i]);
				if (dmof[i] != null)
					model.setDmof(dmof[i]);
				if (ctoc[i] != null)
					model.setCtoc(ctoc[i]);
				if (issd[i] != null)
					model.setIssd(issd[i]);
				if (titl[i] != null)
					model.setTitl(titl[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (shtp[i] != null)
					model.setShtp(shtp[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dtoc[i] != null)
					model.setDtoc(dtoc[i]);
				if (term[i] != null)
					model.setTerm(term[i]);
				if (ctic[i] != null)
					model.setCtic(ctic[i]);
				if (seqq[i] != null)
					model.setSeqq(seqq[i]);
				if (dmif[i] != null)
					model.setDmif(dmif[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSheetOptionTermTitleListUpVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SheetOptionTermTitleListUpVO[]
	 */
	public SheetOptionTermTitleListUpVO[] getSheetOptionTermTitleListUpVOs(){
		SheetOptionTermTitleListUpVO[] vos = (SheetOptionTermTitleListUpVO[])models.toArray(new SheetOptionTermTitleListUpVO[models.size()]);
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
		this.dtic = this.dtic .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alll = this.alll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmof = this.dmof .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctoc = this.ctoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issd = this.issd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.titl = this.titl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shtp = this.shtp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtoc = this.dtoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.term = this.term .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctic = this.ctic .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seqq = this.seqq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmif = this.dmif .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

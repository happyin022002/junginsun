/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0136ConditionVO.java
*@FileTitle : EesEqr0136ConditionVO
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	Lee Byoung Hun	2009.09.22		1.0 최초 생성
*
*@LastModifyDate : 2009.09.22
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.09.22  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplankpianalysis.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr0136ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0136ConditionVO> models = new ArrayList<EesEqr0136ConditionVO>();
	
	/* Column Info */
	private String vslslancd = null;
	/* Column Info */
	private String toplnwk = null;
	/* Column Info */
	private String plnYrwk = null;
	/* Column Info */
	private String fmtype = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd1 = null;
	/* Column Info */
	private String yyyyww = null;
	/* Column Info */
	private String repoPlnId = null;
	/* Column Info */
	private String fmecccd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fmplnyr = null;
	/* Column Info */
	private String toplnyr = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String fmplnwk = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0136ConditionVO() {}

	public EesEqr0136ConditionVO(String ibflag, String pagerows, String yyyyww, String seq, String repoPlnId, String fmplnyr, String fmplnwk, String toplnyr, String toplnwk, String fmtype, String fmecccd, String vslslancd, String vvd1, String plnYrwk) {
		this.vslslancd = vslslancd;
		this.toplnwk = toplnwk;
		this.plnYrwk = plnYrwk;
		this.fmtype = fmtype;
		this.pagerows = pagerows;
		this.vvd1 = vvd1;
		this.yyyyww = yyyyww;
		this.repoPlnId = repoPlnId;
		this.fmecccd = fmecccd;
		this.ibflag = ibflag;
		this.fmplnyr = fmplnyr;
		this.toplnyr = toplnyr;
		this.seq = seq;
		this.fmplnwk = fmplnwk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vslslancd", getVslslancd());
		this.hashColumns.put("toplnwk", getToplnwk());
		this.hashColumns.put("pln_yrwk", getPlnYrwk());
		this.hashColumns.put("fmtype", getFmtype());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd_1", getVvd1());
		this.hashColumns.put("yyyyww", getYyyyww());
		this.hashColumns.put("repo_pln_id", getRepoPlnId());
		this.hashColumns.put("fmecccd", getFmecccd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fmplnyr", getFmplnyr());
		this.hashColumns.put("toplnyr", getToplnyr());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("fmplnwk", getFmplnwk());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vslslancd", "vslslancd");
		this.hashFields.put("toplnwk", "toplnwk");
		this.hashFields.put("pln_yrwk", "plnYrwk");
		this.hashFields.put("fmtype", "fmtype");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd_1", "vvd1");
		this.hashFields.put("yyyyww", "yyyyww");
		this.hashFields.put("repo_pln_id", "repoPlnId");
		this.hashFields.put("fmecccd", "fmecccd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fmplnyr", "fmplnyr");
		this.hashFields.put("toplnyr", "toplnyr");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("fmplnwk", "fmplnwk");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslslancd
	 */
	public String getVslslancd() {
		return this.vslslancd;
	}
	
	/**
	 * Column Info
	 * @return toplnwk
	 */
	public String getToplnwk() {
		return this.toplnwk;
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
	 * @return fmtype
	 */
	public String getFmtype() {
		return this.fmtype;
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
	 * @return vvd1
	 */
	public String getVvd1() {
		return this.vvd1;
	}
	
	/**
	 * Column Info
	 * @return yyyyww
	 */
	public String getYyyyww() {
		return this.yyyyww;
	}
	
	/**
	 * Column Info
	 * @return repoPlnId
	 */
	public String getRepoPlnId() {
		return this.repoPlnId;
	}
	
	/**
	 * Column Info
	 * @return fmecccd
	 */
	public String getFmecccd() {
		return this.fmecccd;
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
	 * @return fmplnyr
	 */
	public String getFmplnyr() {
		return this.fmplnyr;
	}
	
	/**
	 * Column Info
	 * @return toplnyr
	 */
	public String getToplnyr() {
		return this.toplnyr;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return fmplnwk
	 */
	public String getFmplnwk() {
		return this.fmplnwk;
	}
	

	/**
	 * Column Info
	 * @param vslslancd
	 */
	public void setVslslancd(String vslslancd) {
		this.vslslancd = vslslancd;
	}
	
	/**
	 * Column Info
	 * @param toplnwk
	 */
	public void setToplnwk(String toplnwk) {
		this.toplnwk = toplnwk;
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
	 * @param fmtype
	 */
	public void setFmtype(String fmtype) {
		this.fmtype = fmtype;
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
	 * @param vvd1
	 */
	public void setVvd1(String vvd1) {
		this.vvd1 = vvd1;
	}
	
	/**
	 * Column Info
	 * @param yyyyww
	 */
	public void setYyyyww(String yyyyww) {
		this.yyyyww = yyyyww;
	}
	
	/**
	 * Column Info
	 * @param repoPlnId
	 */
	public void setRepoPlnId(String repoPlnId) {
		this.repoPlnId = repoPlnId;
	}
	
	/**
	 * Column Info
	 * @param fmecccd
	 */
	public void setFmecccd(String fmecccd) {
		this.fmecccd = fmecccd;
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
	 * @param fmplnyr
	 */
	public void setFmplnyr(String fmplnyr) {
		this.fmplnyr = fmplnyr;
	}
	
	/**
	 * Column Info
	 * @param toplnyr
	 */
	public void setToplnyr(String toplnyr) {
		this.toplnyr = toplnyr;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param fmplnwk
	 */
	public void setFmplnwk(String fmplnwk) {
		this.fmplnwk = fmplnwk;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslslancd(JSPUtil.getParameter(request, "vslSlanCd", ""));
		setToplnwk(JSPUtil.getParameter(request, "toPlnWk", ""));
		setPlnYrwk(JSPUtil.getParameter(request, "pln_yrwk", ""));
		setFmtype(JSPUtil.getParameter(request, "fmType", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvd1(JSPUtil.getParameter(request, "vvd_1", ""));
		setYyyyww(JSPUtil.getParameter(request, "yyyyww", ""));
		setRepoPlnId(JSPUtil.getParameter(request, "repo_pln_id", ""));
		setFmecccd(JSPUtil.getParameter(request, "fmEccCd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFmplnyr(JSPUtil.getParameter(request, "fmPlnYr", ""));
		setToplnyr(JSPUtil.getParameter(request, "toPlnYr", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setFmplnwk(JSPUtil.getParameter(request, "fmPlnWk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr0136ConditionVO[]
	 */
	public EesEqr0136ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr0136ConditionVO[]
	 */
	public EesEqr0136ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0136ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslslancd = (JSPUtil.getParameter(request, prefix	+ "vslslancd", length));
			String[] toplnwk = (JSPUtil.getParameter(request, prefix	+ "toplnwk", length));
			String[] plnYrwk = (JSPUtil.getParameter(request, prefix	+ "pln_yrwk", length));
			String[] fmtype = (JSPUtil.getParameter(request, prefix	+ "fmtype", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd1 = (JSPUtil.getParameter(request, prefix	+ "vvd_1", length));
			String[] yyyyww = (JSPUtil.getParameter(request, prefix	+ "yyyyww", length));
			String[] repoPlnId = (JSPUtil.getParameter(request, prefix	+ "repo_pln_id", length));
			String[] fmecccd = (JSPUtil.getParameter(request, prefix	+ "fmecccd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fmplnyr = (JSPUtil.getParameter(request, prefix	+ "fmplnyr", length));
			String[] toplnyr = (JSPUtil.getParameter(request, prefix	+ "toplnyr", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] fmplnwk = (JSPUtil.getParameter(request, prefix	+ "fmplnwk", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0136ConditionVO();
				if (vslslancd[i] != null)
					model.setVslslancd(vslslancd[i]);
				if (toplnwk[i] != null)
					model.setToplnwk(toplnwk[i]);
				if (plnYrwk[i] != null)
					model.setPlnYrwk(plnYrwk[i]);
				if (fmtype[i] != null)
					model.setFmtype(fmtype[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd1[i] != null)
					model.setVvd1(vvd1[i]);
				if (yyyyww[i] != null)
					model.setYyyyww(yyyyww[i]);
				if (repoPlnId[i] != null)
					model.setRepoPlnId(repoPlnId[i]);
				if (fmecccd[i] != null)
					model.setFmecccd(fmecccd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fmplnyr[i] != null)
					model.setFmplnyr(fmplnyr[i]);
				if (toplnyr[i] != null)
					model.setToplnyr(toplnyr[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (fmplnwk[i] != null)
					model.setFmplnwk(fmplnwk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr0136ConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr0136ConditionVO[]
	 */
	public EesEqr0136ConditionVO[] getEesEqr0136ConditionVOs(){
		EesEqr0136ConditionVO[] vos = (EesEqr0136ConditionVO[])models.toArray(new EesEqr0136ConditionVO[models.size()]);
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
		this.vslslancd = this.vslslancd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toplnwk = this.toplnwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYrwk = this.plnYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtype = this.fmtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd1 = this.vvd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yyyyww = this.yyyyww .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoPlnId = this.repoPlnId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmecccd = this.fmecccd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmplnyr = this.fmplnyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toplnyr = this.toplnyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmplnwk = this.fmplnwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

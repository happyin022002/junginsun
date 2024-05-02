/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0071ConditionVO.java
*@FileTitle : EesEqr0071ConditionVO
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	Lee Byoung Hun	2009.09.16		1.0 최초 생성
*
*@LastModifyDate : 2009.09.16
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.09.16  
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

public class EesEqr0071ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0071ConditionVO> models = new ArrayList<EesEqr0071ConditionVO>();
	
	/* Column Info */
	private String radiocomp = null;
	/* Column Info */
	private String transshippln = null;
	/* Column Info */
	private String plnfmplnwk = null;
	/* Column Info */
	private String ecccd = null;
	/* Column Info */
	private String perftoplnyr = null;
	/* Column Info */
	private String perftoplnwk = null;
	/* Column Info */
	private String type = null;
	/* Column Info */
	private String radiototrcc = null;
	/* Column Info */
	private String perffmplnyr = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String yyyyww = null;
	/* Column Info */
	private String transship = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String plnfmplnyr = null;
	/* Column Info */
	private String plntoplnyr = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String radioopr = null;
	/* Column Info */
	private String perffmplnwk = null;
	/* Column Info */
	private String typeby = null;
	/* Column Info */
	private String plntoplnwk = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0071ConditionVO() {}

	public EesEqr0071ConditionVO(String ibflag, String pagerows, String radioopr, String perffmplnyr, String perffmplnwk, String perftoplnyr, String perftoplnwk, String radiocomp, String type, String ecccd, String typeby, String transship, String plnfmplnyr, String plnfmplnwk, String plntoplnyr, String plntoplnwk, String transshippln, String yyyyww, String seq, String radiototrcc) {
		this.radiocomp = radiocomp;
		this.transshippln = transshippln;
		this.plnfmplnwk = plnfmplnwk;
		this.ecccd = ecccd;
		this.perftoplnyr = perftoplnyr;
		this.perftoplnwk = perftoplnwk;
		this.type = type;
		this.radiototrcc = radiototrcc;
		this.perffmplnyr = perffmplnyr;
		this.pagerows = pagerows;
		this.yyyyww = yyyyww;
		this.transship = transship;
		this.ibflag = ibflag;
		this.plnfmplnyr = plnfmplnyr;
		this.plntoplnyr = plntoplnyr;
		this.seq = seq;
		this.radioopr = radioopr;
		this.perffmplnwk = perffmplnwk;
		this.typeby = typeby;
		this.plntoplnwk = plntoplnwk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("radiocomp", getRadiocomp());
		this.hashColumns.put("transshippln", getTransshippln());
		this.hashColumns.put("plnfmplnwk", getPlnfmplnwk());
		this.hashColumns.put("ecccd", getEcccd());
		this.hashColumns.put("perftoplnyr", getPerftoplnyr());
		this.hashColumns.put("perftoplnwk", getPerftoplnwk());
		this.hashColumns.put("type", getType());
		this.hashColumns.put("radiototrcc", getRadiototrcc());
		this.hashColumns.put("perffmplnyr", getPerffmplnyr());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("yyyyww", getYyyyww());
		this.hashColumns.put("transship", getTransship());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("plnfmplnyr", getPlnfmplnyr());
		this.hashColumns.put("plntoplnyr", getPlntoplnyr());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("radioopr", getRadioopr());
		this.hashColumns.put("perffmplnwk", getPerffmplnwk());
		this.hashColumns.put("typeby", getTypeby());
		this.hashColumns.put("plntoplnwk", getPlntoplnwk());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("radiocomp", "radiocomp");
		this.hashFields.put("transshippln", "transshippln");
		this.hashFields.put("plnfmplnwk", "plnfmplnwk");
		this.hashFields.put("ecccd", "ecccd");
		this.hashFields.put("perftoplnyr", "perftoplnyr");
		this.hashFields.put("perftoplnwk", "perftoplnwk");
		this.hashFields.put("type", "type");
		this.hashFields.put("radiototrcc", "radiototrcc");
		this.hashFields.put("perffmplnyr", "perffmplnyr");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("yyyyww", "yyyyww");
		this.hashFields.put("transship", "transship");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("plnfmplnyr", "plnfmplnyr");
		this.hashFields.put("plntoplnyr", "plntoplnyr");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("radioopr", "radioopr");
		this.hashFields.put("perffmplnwk", "perffmplnwk");
		this.hashFields.put("typeby", "typeby");
		this.hashFields.put("plntoplnwk", "plntoplnwk");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return radiocomp
	 */
	public String getRadiocomp() {
		return this.radiocomp;
	}
	
	/**
	 * Column Info
	 * @return transshippln
	 */
	public String getTransshippln() {
		return this.transshippln;
	}
	
	/**
	 * Column Info
	 * @return plnfmplnwk
	 */
	public String getPlnfmplnwk() {
		return this.plnfmplnwk;
	}
	
	/**
	 * Column Info
	 * @return ecccd
	 */
	public String getEcccd() {
		return this.ecccd;
	}
	
	/**
	 * Column Info
	 * @return perftoplnyr
	 */
	public String getPerftoplnyr() {
		return this.perftoplnyr;
	}
	
	/**
	 * Column Info
	 * @return perftoplnwk
	 */
	public String getPerftoplnwk() {
		return this.perftoplnwk;
	}
	
	/**
	 * Column Info
	 * @return type
	 */
	public String getType() {
		return this.type;
	}
	
	/**
	 * Column Info
	 * @return radiototrcc
	 */
	public String getRadiototrcc() {
		return this.radiototrcc;
	}
	
	/**
	 * Column Info
	 * @return perffmplnyr
	 */
	public String getPerffmplnyr() {
		return this.perffmplnyr;
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
	 * @return yyyyww
	 */
	public String getYyyyww() {
		return this.yyyyww;
	}
	
	/**
	 * Column Info
	 * @return transship
	 */
	public String getTransship() {
		return this.transship;
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
	 * @return plnfmplnyr
	 */
	public String getPlnfmplnyr() {
		return this.plnfmplnyr;
	}
	
	/**
	 * Column Info
	 * @return plntoplnyr
	 */
	public String getPlntoplnyr() {
		return this.plntoplnyr;
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
	 * @return radioopr
	 */
	public String getRadioopr() {
		return this.radioopr;
	}
	
	/**
	 * Column Info
	 * @return perffmplnwk
	 */
	public String getPerffmplnwk() {
		return this.perffmplnwk;
	}
	
	/**
	 * Column Info
	 * @return typeby
	 */
	public String getTypeby() {
		return this.typeby;
	}
	
	/**
	 * Column Info
	 * @return plntoplnwk
	 */
	public String getPlntoplnwk() {
		return this.plntoplnwk;
	}
	

	/**
	 * Column Info
	 * @param radiocomp
	 */
	public void setRadiocomp(String radiocomp) {
		this.radiocomp = radiocomp;
	}
	
	/**
	 * Column Info
	 * @param transshippln
	 */
	public void setTransshippln(String transshippln) {
		this.transshippln = transshippln;
	}
	
	/**
	 * Column Info
	 * @param plnfmplnwk
	 */
	public void setPlnfmplnwk(String plnfmplnwk) {
		this.plnfmplnwk = plnfmplnwk;
	}
	
	/**
	 * Column Info
	 * @param ecccd
	 */
	public void setEcccd(String ecccd) {
		this.ecccd = ecccd;
	}
	
	/**
	 * Column Info
	 * @param perftoplnyr
	 */
	public void setPerftoplnyr(String perftoplnyr) {
		this.perftoplnyr = perftoplnyr;
	}
	
	/**
	 * Column Info
	 * @param perftoplnwk
	 */
	public void setPerftoplnwk(String perftoplnwk) {
		this.perftoplnwk = perftoplnwk;
	}
	
	/**
	 * Column Info
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Column Info
	 * @param radiototrcc
	 */
	public void setRadiototrcc(String radiototrcc) {
		this.radiototrcc = radiototrcc;
	}
	
	/**
	 * Column Info
	 * @param perffmplnyr
	 */
	public void setPerffmplnyr(String perffmplnyr) {
		this.perffmplnyr = perffmplnyr;
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
	 * @param yyyyww
	 */
	public void setYyyyww(String yyyyww) {
		this.yyyyww = yyyyww;
	}
	
	/**
	 * Column Info
	 * @param transship
	 */
	public void setTransship(String transship) {
		this.transship = transship;
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
	 * @param plnfmplnyr
	 */
	public void setPlnfmplnyr(String plnfmplnyr) {
		this.plnfmplnyr = plnfmplnyr;
	}
	
	/**
	 * Column Info
	 * @param plntoplnyr
	 */
	public void setPlntoplnyr(String plntoplnyr) {
		this.plntoplnyr = plntoplnyr;
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
	 * @param radioopr
	 */
	public void setRadioopr(String radioopr) {
		this.radioopr = radioopr;
	}
	
	/**
	 * Column Info
	 * @param perffmplnwk
	 */
	public void setPerffmplnwk(String perffmplnwk) {
		this.perffmplnwk = perffmplnwk;
	}
	
	/**
	 * Column Info
	 * @param typeby
	 */
	public void setTypeby(String typeby) {
		this.typeby = typeby;
	}
	
	/**
	 * Column Info
	 * @param plntoplnwk
	 */
	public void setPlntoplnwk(String plntoplnwk) {
		this.plntoplnwk = plntoplnwk;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRadiocomp(JSPUtil.getParameter(request, "radioComp", ""));
		setTransshippln(JSPUtil.getParameter(request, "transshipPln", ""));
		setPlnfmplnwk(JSPUtil.getParameter(request, "plnFmPlnWk", ""));
		setEcccd(JSPUtil.getParameter(request, "eccCd", ""));
		setPerftoplnyr(JSPUtil.getParameter(request, "perfToPlnYr", ""));
		setPerftoplnwk(JSPUtil.getParameter(request, "perfToPlnWk", ""));
		setType(JSPUtil.getParameter(request, "type", ""));
		setRadiototrcc(JSPUtil.getParameter(request, "radioTotRcc", ""));
		setPerffmplnyr(JSPUtil.getParameter(request, "perfFmPlnYr", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setYyyyww(JSPUtil.getParameter(request, "yyyyww", ""));
		setTransship(JSPUtil.getParameter(request, "transship", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPlnfmplnyr(JSPUtil.getParameter(request, "plnFmPlnYr", ""));
		setPlntoplnyr(JSPUtil.getParameter(request, "plnToPlnYr", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setRadioopr(JSPUtil.getParameter(request, "radioOpr", ""));
		setPerffmplnwk(JSPUtil.getParameter(request, "perfFmPlnWk", ""));
		setTypeby(JSPUtil.getParameter(request, "typeBy", ""));
		setPlntoplnwk(JSPUtil.getParameter(request, "plnToPlnWk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr0071ConditionVO[]
	 */
	public EesEqr0071ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr0071ConditionVO[]
	 */
	public EesEqr0071ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0071ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] radiocomp = (JSPUtil.getParameter(request, prefix	+ "radiocomp", length));
			String[] transshippln = (JSPUtil.getParameter(request, prefix	+ "transshippln", length));
			String[] plnfmplnwk = (JSPUtil.getParameter(request, prefix	+ "plnfmplnwk", length));
			String[] ecccd = (JSPUtil.getParameter(request, prefix	+ "ecccd", length));
			String[] perftoplnyr = (JSPUtil.getParameter(request, prefix	+ "perftoplnyr", length));
			String[] perftoplnwk = (JSPUtil.getParameter(request, prefix	+ "perftoplnwk", length));
			String[] type = (JSPUtil.getParameter(request, prefix	+ "type", length));
			String[] radiototrcc = (JSPUtil.getParameter(request, prefix	+ "radiototrcc", length));
			String[] perffmplnyr = (JSPUtil.getParameter(request, prefix	+ "perffmplnyr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] yyyyww = (JSPUtil.getParameter(request, prefix	+ "yyyyww", length));
			String[] transship = (JSPUtil.getParameter(request, prefix	+ "transship", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] plnfmplnyr = (JSPUtil.getParameter(request, prefix	+ "plnfmplnyr", length));
			String[] plntoplnyr = (JSPUtil.getParameter(request, prefix	+ "plntoplnyr", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] radioopr = (JSPUtil.getParameter(request, prefix	+ "radioopr", length));
			String[] perffmplnwk = (JSPUtil.getParameter(request, prefix	+ "perffmplnwk", length));
			String[] typeby = (JSPUtil.getParameter(request, prefix	+ "typeby", length));
			String[] plntoplnwk = (JSPUtil.getParameter(request, prefix	+ "plntoplnwk", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0071ConditionVO();
				if (radiocomp[i] != null)
					model.setRadiocomp(radiocomp[i]);
				if (transshippln[i] != null)
					model.setTransshippln(transshippln[i]);
				if (plnfmplnwk[i] != null)
					model.setPlnfmplnwk(plnfmplnwk[i]);
				if (ecccd[i] != null)
					model.setEcccd(ecccd[i]);
				if (perftoplnyr[i] != null)
					model.setPerftoplnyr(perftoplnyr[i]);
				if (perftoplnwk[i] != null)
					model.setPerftoplnwk(perftoplnwk[i]);
				if (type[i] != null)
					model.setType(type[i]);
				if (radiototrcc[i] != null)
					model.setRadiototrcc(radiototrcc[i]);
				if (perffmplnyr[i] != null)
					model.setPerffmplnyr(perffmplnyr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (yyyyww[i] != null)
					model.setYyyyww(yyyyww[i]);
				if (transship[i] != null)
					model.setTransship(transship[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (plnfmplnyr[i] != null)
					model.setPlnfmplnyr(plnfmplnyr[i]);
				if (plntoplnyr[i] != null)
					model.setPlntoplnyr(plntoplnyr[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (radioopr[i] != null)
					model.setRadioopr(radioopr[i]);
				if (perffmplnwk[i] != null)
					model.setPerffmplnwk(perffmplnwk[i]);
				if (typeby[i] != null)
					model.setTypeby(typeby[i]);
				if (plntoplnwk[i] != null)
					model.setPlntoplnwk(plntoplnwk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr0071ConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr0071ConditionVO[]
	 */
	public EesEqr0071ConditionVO[] getEesEqr0071ConditionVOs(){
		EesEqr0071ConditionVO[] vos = (EesEqr0071ConditionVO[])models.toArray(new EesEqr0071ConditionVO[models.size()]);
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
		this.radiocomp = this.radiocomp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transshippln = this.transshippln .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnfmplnwk = this.plnfmplnwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ecccd = this.ecccd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perftoplnyr = this.perftoplnyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perftoplnwk = this.perftoplnwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.type = this.type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.radiototrcc = this.radiototrcc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perffmplnyr = this.perffmplnyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yyyyww = this.yyyyww .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transship = this.transship .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnfmplnyr = this.plnfmplnyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plntoplnyr = this.plntoplnyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.radioopr = this.radioopr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perffmplnwk = this.perffmplnwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.typeby = this.typeby .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plntoplnwk = this.plntoplnwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

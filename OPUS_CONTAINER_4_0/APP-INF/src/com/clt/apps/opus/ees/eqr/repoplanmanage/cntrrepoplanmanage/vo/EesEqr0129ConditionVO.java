/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0129ConditionVO.java
*@FileTitle : TS Guideline Popup
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	Lee Byoung Hun	2009.09.03		1.0 최초 생성
*
*@LastModifyDate : 2009.09.03
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.09.03  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr0129ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0129ConditionVO> models = new ArrayList<EesEqr0129ConditionVO>();
	
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String vslLaneCd = null;
	/* Column Info */
	private String repoPlnId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fmtoat = null;
	/* Column Info */
	private String totypeby = null;
	/* Column Info */
	private String attypeby = null;
	/* Column Info */
	private String fmtypeby = null;
	/* Column Info */
	private String plnYrwk = null;
	/* Column Info */
	private String toLoc = null;
	/* Column Info */
	private String fmLoc = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0129ConditionVO() {}

	public EesEqr0129ConditionVO(String ibflag, String pagerows, String fmLoc, String toLoc, String repoPlnId, String plnYrwk, String fmtypeby, String totypeby, String attypeby, String fmtoat, String vslLaneCd, String vvd) {
		this.vvd = vvd;
		this.vslLaneCd = vslLaneCd;
		this.repoPlnId = repoPlnId;
		this.ibflag = ibflag;
		this.fmtoat = fmtoat;
		this.totypeby = totypeby;
		this.attypeby = attypeby;
		this.fmtypeby = fmtypeby;
		this.plnYrwk = plnYrwk;
		this.toLoc = toLoc;
		this.fmLoc = fmLoc;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("vsl_lane_cd", getVslLaneCd());
		this.hashColumns.put("repo_pln_id", getRepoPlnId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fmtoat", getFmtoat());
		this.hashColumns.put("totypeby", getTotypeby());
		this.hashColumns.put("attypeby", getAttypeby());
		this.hashColumns.put("fmtypeby", getFmtypeby());
		this.hashColumns.put("pln_yrwk", getPlnYrwk());
		this.hashColumns.put("to_loc", getToLoc());
		this.hashColumns.put("fm_loc", getFmLoc());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("vsl_lane_cd", "vslLaneCd");
		this.hashFields.put("repo_pln_id", "repoPlnId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fmtoat", "fmtoat");
		this.hashFields.put("totypeby", "totypeby");
		this.hashFields.put("attypeby", "attypeby");
		this.hashFields.put("fmtypeby", "fmtypeby");
		this.hashFields.put("pln_yrwk", "plnYrwk");
		this.hashFields.put("to_loc", "toLoc");
		this.hashFields.put("fm_loc", "fmLoc");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return vslLaneCd
	 */
	public String getVslLaneCd() {
		return this.vslLaneCd;
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
	 * @return fmtoat
	 */
	public String getFmtoat() {
		return this.fmtoat;
	}
	
	/**
	 * Column Info
	 * @return totypeby
	 */
	public String getTotypeby() {
		return this.totypeby;
	}
	
	/**
	 * Column Info
	 * @return attypeby
	 */
	public String getAttypeby() {
		return this.attypeby;
	}
	
	/**
	 * Column Info
	 * @return fmtypeby
	 */
	public String getFmtypeby() {
		return this.fmtypeby;
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
	 * @return toLoc
	 */
	public String getToLoc() {
		return this.toLoc;
	}
	
	/**
	 * Column Info
	 * @return fmLoc
	 */
	public String getFmLoc() {
		return this.fmLoc;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param vslLaneCd
	 */
	public void setVslLaneCd(String vslLaneCd) {
		this.vslLaneCd = vslLaneCd;
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
	 * @param fmtoat
	 */
	public void setFmtoat(String fmtoat) {
		this.fmtoat = fmtoat;
	}
	
	/**
	 * Column Info
	 * @param totypeby
	 */
	public void setTotypeby(String totypeby) {
		this.totypeby = totypeby;
	}
	
	/**
	 * Column Info
	 * @param attypeby
	 */
	public void setAttypeby(String attypeby) {
		this.attypeby = attypeby;
	}
	
	/**
	 * Column Info
	 * @param fmtypeby
	 */
	public void setFmtypeby(String fmtypeby) {
		this.fmtypeby = fmtypeby;
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
	 * @param toLoc
	 */
	public void setToLoc(String toLoc) {
		this.toLoc = toLoc;
	}
	
	/**
	 * Column Info
	 * @param fmLoc
	 */
	public void setFmLoc(String fmLoc) {
		this.fmLoc = fmLoc;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setVslLaneCd(JSPUtil.getParameter(request, "vsl_lane_cd", ""));
		setRepoPlnId(JSPUtil.getParameter(request, "repo_pln_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFmtoat(JSPUtil.getParameter(request, "fmToAt", ""));
		setTotypeby(JSPUtil.getParameter(request, "toTypeBy", ""));
		setAttypeby(JSPUtil.getParameter(request, "atTypeBy", ""));
		setFmtypeby(JSPUtil.getParameter(request, "fmTypeBy", ""));
		setPlnYrwk(JSPUtil.getParameter(request, "pln_yrwk", ""));
		setToLoc(JSPUtil.getParameter(request, "to_loc", ""));
		setFmLoc(JSPUtil.getParameter(request, "fm_loc", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr0129ConditionVO[]
	 */
	public EesEqr0129ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr0129ConditionVO[]
	 */
	public EesEqr0129ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0129ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] vslLaneCd = (JSPUtil.getParameter(request, prefix	+ "vsl_lane_cd", length));
			String[] repoPlnId = (JSPUtil.getParameter(request, prefix	+ "repo_pln_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fmtoat = (JSPUtil.getParameter(request, prefix	+ "fmtoat", length));
			String[] totypeby = (JSPUtil.getParameter(request, prefix	+ "totypeby", length));
			String[] attypeby = (JSPUtil.getParameter(request, prefix	+ "attypeby", length));
			String[] fmtypeby = (JSPUtil.getParameter(request, prefix	+ "fmtypeby", length));
			String[] plnYrwk = (JSPUtil.getParameter(request, prefix	+ "pln_yrwk", length));
			String[] toLoc = (JSPUtil.getParameter(request, prefix	+ "to_loc", length));
			String[] fmLoc = (JSPUtil.getParameter(request, prefix	+ "fm_loc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0129ConditionVO();
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (vslLaneCd[i] != null)
					model.setVslLaneCd(vslLaneCd[i]);
				if (repoPlnId[i] != null)
					model.setRepoPlnId(repoPlnId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fmtoat[i] != null)
					model.setFmtoat(fmtoat[i]);
				if (totypeby[i] != null)
					model.setTotypeby(totypeby[i]);
				if (attypeby[i] != null)
					model.setAttypeby(attypeby[i]);
				if (fmtypeby[i] != null)
					model.setFmtypeby(fmtypeby[i]);
				if (plnYrwk[i] != null)
					model.setPlnYrwk(plnYrwk[i]);
				if (toLoc[i] != null)
					model.setToLoc(toLoc[i]);
				if (fmLoc[i] != null)
					model.setFmLoc(fmLoc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr0129ConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr0129ConditionVO[]
	 */
	public EesEqr0129ConditionVO[] getEesEqr0129ConditionVOs(){
		EesEqr0129ConditionVO[] vos = (EesEqr0129ConditionVO[])models.toArray(new EesEqr0129ConditionVO[models.size()]);
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
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslLaneCd = this.vslLaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoPlnId = this.repoPlnId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtoat = this.fmtoat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totypeby = this.totypeby .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attypeby = this.attypeby .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtypeby = this.fmtypeby .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYrwk = this.plnYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toLoc = this.toLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmLoc = this.fmLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

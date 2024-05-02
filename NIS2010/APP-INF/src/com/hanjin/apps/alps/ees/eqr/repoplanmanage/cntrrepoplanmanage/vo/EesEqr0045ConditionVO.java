/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0045ConditionVO.java
*@FileTitle : EesEqr0045ConditionVO
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	Lee Byoung Hun	2009.08.14		1.0 최초 생성
*
*@LastModifyDate : 2009.08.14
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.08.14  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo;

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

public class EesEqr0045ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0045ConditionVO> models = new ArrayList<EesEqr0045ConditionVO>();
	
	/* Column Info */
	private String reposyear = null;
	/* Column Info */
	private String scnrseq = null;
	/* Column Info */
	private String planidnormk = null;
	/* Column Info */
	private String scnrweek = null;
	/* Column Info */
	private String scnrId = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String repoeyear = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String reposweek = null;
	/* Column Info */
	private String repoPlnId = null;
	/* Column Info */
	private String planidflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String repoweek = null;
	/* Column Info */
	private String reposeq = null;
	/* Column Info */
	private String repoeweek = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0045ConditionVO() {}

	public EesEqr0045ConditionVO(String ibflag, String pagerows, String planidflag, String planidnormk, String reposyear, String reposweek, String repoeyear, String repoeweek, String status, String repoweek, String reposeq, String scnrweek, String scnrseq, String creUsrId, String repoPlnId, String scnrId) {
		this.reposyear = reposyear;
		this.scnrseq = scnrseq;
		this.planidnormk = planidnormk;
		this.scnrweek = scnrweek;
		this.scnrId = scnrId;
		this.status = status;
		this.repoeyear = repoeyear;
		this.pagerows = pagerows;
		this.reposweek = reposweek;
		this.repoPlnId = repoPlnId;
		this.planidflag = planidflag;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.repoweek = repoweek;
		this.reposeq = reposeq;
		this.repoeweek = repoeweek;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("repoSYear", getReposyear());
		this.hashColumns.put("scnrSeq", getScnrseq());
		this.hashColumns.put("planIdNoRmk", getPlanidnormk());
		this.hashColumns.put("scnrWeek", getScnrweek());
		this.hashColumns.put("scnr_id", getScnrId());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("repoEYear", getRepoeyear());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("repoSWeek", getReposweek());
		this.hashColumns.put("repo_pln_id", getRepoPlnId());
		this.hashColumns.put("planIdFlag", getPlanidflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("repoWeek", getRepoweek());
		this.hashColumns.put("repoSeq", getReposeq());
		this.hashColumns.put("repoEWeek", getRepoeweek());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("reposyear", "reposyear");
		this.hashFields.put("scnrseq", "scnrseq");
		this.hashFields.put("planidnormk", "planidnormk");
		this.hashFields.put("scnrweek", "scnrweek");
		this.hashFields.put("scnr_id", "scnrId");
		this.hashFields.put("status", "status");
		this.hashFields.put("repoeyear", "repoeyear");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("reposweek", "reposweek");
		this.hashFields.put("repo_pln_id", "repoPlnId");
		this.hashFields.put("planidflag", "planidflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("repoweek", "repoweek");
		this.hashFields.put("reposeq", "reposeq");
		this.hashFields.put("repoeweek", "repoeweek");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return reposyear
	 */
	public String getReposyear() {
		return this.reposyear;
	}
	
	/**
	 * Column Info
	 * @return scnrseq
	 */
	public String getScnrseq() {
		return this.scnrseq;
	}
	
	/**
	 * Column Info
	 * @return planidnormk
	 */
	public String getPlanidnormk() {
		return this.planidnormk;
	}
	
	/**
	 * Column Info
	 * @return scnrweek
	 */
	public String getScnrweek() {
		return this.scnrweek;
	}
	
	/**
	 * Column Info
	 * @return scnrId
	 */
	public String getScnrId() {
		return this.scnrId;
	}
	
	/**
	 * Column Info
	 * @return status
	 */
	public String getStatus() {
		return this.status;
	}
	
	/**
	 * Column Info
	 * @return repoeyear
	 */
	public String getRepoeyear() {
		return this.repoeyear;
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
	 * @return reposweek
	 */
	public String getReposweek() {
		return this.reposweek;
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
	 * @return planidflag
	 */
	public String getPlanidflag() {
		return this.planidflag;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return repoweek
	 */
	public String getRepoweek() {
		return this.repoweek;
	}
	
	/**
	 * Column Info
	 * @return reposeq
	 */
	public String getReposeq() {
		return this.reposeq;
	}
	
	/**
	 * Column Info
	 * @return repoeweek
	 */
	public String getRepoeweek() {
		return this.repoeweek;
	}
	

	/**
	 * Column Info
	 * @param reposyear
	 */
	public void setReposyear(String reposyear) {
		this.reposyear = reposyear;
	}
	
	/**
	 * Column Info
	 * @param scnrseq
	 */
	public void setScnrseq(String scnrseq) {
		this.scnrseq = scnrseq;
	}
	
	/**
	 * Column Info
	 * @param planidnormk
	 */
	public void setPlanidnormk(String planidnormk) {
		this.planidnormk = planidnormk;
	}
	
	/**
	 * Column Info
	 * @param scnrweek
	 */
	public void setScnrweek(String scnrweek) {
		this.scnrweek = scnrweek;
	}
	
	/**
	 * Column Info
	 * @param scnrId
	 */
	public void setScnrId(String scnrId) {
		this.scnrId = scnrId;
	}
	
	/**
	 * Column Info
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Column Info
	 * @param repoeyear
	 */
	public void setRepoeyear(String repoeyear) {
		this.repoeyear = repoeyear;
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
	 * @param reposweek
	 */
	public void setReposweek(String reposweek) {
		this.reposweek = reposweek;
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
	 * @param planidflag
	 */
	public void setPlanidflag(String planidflag) {
		this.planidflag = planidflag;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param repoweek
	 */
	public void setRepoweek(String repoweek) {
		this.repoweek = repoweek;
	}
	
	/**
	 * Column Info
	 * @param reposeq
	 */
	public void setReposeq(String reposeq) {
		this.reposeq = reposeq;
	}
	
	/**
	 * Column Info
	 * @param repoeweek
	 */
	public void setRepoeweek(String repoeweek) {
		this.repoeweek = repoeweek;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setReposyear(JSPUtil.getParameter(request, "repoSYear", ""));
		setScnrseq(JSPUtil.getParameter(request, "scnrSeq", ""));
		setPlanidnormk(JSPUtil.getParameter(request, "planIdNoRmk", ""));
		setScnrweek(JSPUtil.getParameter(request, "scnrWeek", ""));
		setScnrId(JSPUtil.getParameter(request, "scnr_id", ""));
		setStatus(JSPUtil.getParameter(request, "status", ""));
		setRepoeyear(JSPUtil.getParameter(request, "repoEYear", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setReposweek(JSPUtil.getParameter(request, "repoSWeek", ""));
		setRepoPlnId(JSPUtil.getParameter(request, "repo_pln_id", ""));
		setPlanidflag(JSPUtil.getParameter(request, "planIdFlag", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRepoweek(JSPUtil.getParameter(request, "repoWeek", ""));
		setReposeq(JSPUtil.getParameter(request, "repoSeq", ""));
		setRepoeweek(JSPUtil.getParameter(request, "repoEWeek", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr0045ConditionVO[]
	 */
	public EesEqr0045ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr0045ConditionVO[]
	 */
	public EesEqr0045ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0045ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] reposyear = (JSPUtil.getParameter(request, prefix	+ "reposyear", length));
			String[] scnrseq = (JSPUtil.getParameter(request, prefix	+ "scnrseq", length));
			String[] planidnormk = (JSPUtil.getParameter(request, prefix	+ "planidnormk", length));
			String[] scnrweek = (JSPUtil.getParameter(request, prefix	+ "scnrweek", length));
			String[] scnrId = (JSPUtil.getParameter(request, prefix	+ "scnr_id", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] repoeyear = (JSPUtil.getParameter(request, prefix	+ "repoeyear", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] reposweek = (JSPUtil.getParameter(request, prefix	+ "reposweek", length));
			String[] repoPlnId = (JSPUtil.getParameter(request, prefix	+ "repo_pln_id", length));
			String[] planidflag = (JSPUtil.getParameter(request, prefix	+ "planidflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] repoweek = (JSPUtil.getParameter(request, prefix	+ "repoweek", length));
			String[] reposeq = (JSPUtil.getParameter(request, prefix	+ "reposeq", length));
			String[] repoeweek = (JSPUtil.getParameter(request, prefix	+ "repoeweek", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0045ConditionVO();
				if (reposyear[i] != null)
					model.setReposyear(reposyear[i]);
				if (scnrseq[i] != null)
					model.setScnrseq(scnrseq[i]);
				if (planidnormk[i] != null)
					model.setPlanidnormk(planidnormk[i]);
				if (scnrweek[i] != null)
					model.setScnrweek(scnrweek[i]);
				if (scnrId[i] != null)
					model.setScnrId(scnrId[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (repoeyear[i] != null)
					model.setRepoeyear(repoeyear[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (reposweek[i] != null)
					model.setReposweek(reposweek[i]);
				if (repoPlnId[i] != null)
					model.setRepoPlnId(repoPlnId[i]);
				if (planidflag[i] != null)
					model.setPlanidflag(planidflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (repoweek[i] != null)
					model.setRepoweek(repoweek[i]);
				if (reposeq[i] != null)
					model.setReposeq(reposeq[i]);
				if (repoeweek[i] != null)
					model.setRepoeweek(repoeweek[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr0045ConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr0045ConditionVO[]
	 */
	public EesEqr0045ConditionVO[] getEesEqr0045ConditionVOs(){
		EesEqr0045ConditionVO[] vos = (EesEqr0045ConditionVO[])models.toArray(new EesEqr0045ConditionVO[models.size()]);
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
		this.reposyear = this.reposyear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scnrseq = this.scnrseq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.planidnormk = this.planidnormk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scnrweek = this.scnrweek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scnrId = this.scnrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoeyear = this.repoeyear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reposweek = this.reposweek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoPlnId = this.repoPlnId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.planidflag = this.planidflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoweek = this.repoweek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reposeq = this.reposeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoeweek = this.repoeweek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

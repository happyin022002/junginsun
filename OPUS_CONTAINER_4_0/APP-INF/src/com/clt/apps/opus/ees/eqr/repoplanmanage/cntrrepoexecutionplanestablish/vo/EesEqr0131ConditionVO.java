/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0131ConditionVO.java
*@FileTitle : EesEqr0131ConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.09.21 정은호 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo;

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
 * @author 정은호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr0131ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0131ConditionVO> models = new ArrayList<EesEqr0131ConditionVO>();
	
	/* Column Info */
	private String repoPlnId = null;
	/* Column Info */
	private String sendMode = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fax = null;
	/* Column Info */
	private String tpsz = null;
	/* Column Info */
	private String email = null;
	/* Column Info */
	private String refId = null;
	/* Column Info */
	private String btnMode = null;
	/* Column Info */
	private String week = null;
	/* Page Number */
	private String pagerows = null;

	private String emlContent = "";
	private String emlSubject = "";
	
	private String faxSubject = "";

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0131ConditionVO() {}

	public EesEqr0131ConditionVO(String ibflag, String pagerows, String repoPlnId, String refId, String tpsz, String email, String fax, String sendMode, String btnMode, String week) {
		this.repoPlnId = repoPlnId;
		this.sendMode = sendMode;
		this.ibflag = ibflag;
		this.fax = fax;
		this.tpsz = tpsz;
		this.email = email;
		this.refId = refId;
		this.btnMode = btnMode;
		this.week = week;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("repo_pln_id", getRepoPlnId());
		this.hashColumns.put("send_mode", getSendMode());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fax", getFax());
		this.hashColumns.put("tpsz", getTpsz());
		this.hashColumns.put("email", getEmail());
		this.hashColumns.put("ref_id", getRefId());
		this.hashColumns.put("btn_mode", getBtnMode());
		this.hashColumns.put("week", getWeek());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("emlContent", getEmlContent());
		this.hashColumns.put("emlSubject", getEmlSubject());
		this.hashColumns.put("faxSubject", getFaxSubject());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("repo_pln_id", "repoPlnId");
		this.hashFields.put("send_mode", "sendMode");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fax", "fax");
		this.hashFields.put("tpsz", "tpsz");
		this.hashFields.put("email", "email");
		this.hashFields.put("ref_id", "refId");
		this.hashFields.put("btn_mode", "btnMode");
		this.hashFields.put("week", "week");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eml_content", "emlContent");
		this.hashFields.put("eml_subject", "emlSubject");
		this.hashFields.put("fax_subject", "faxSubject");
		return this.hashFields;
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
	 * @return sendMode
	 */
	public String getSendMode() {
		return this.sendMode;
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
	 * @return fax
	 */
	public String getFax() {
		return this.fax;
	}
	
	/**
	 * Column Info
	 * @return tpsz
	 */
	public String getTpsz() {
		return this.tpsz;
	}
	
	/**
	 * Column Info
	 * @return email
	 */
	public String getEmail() {
		return this.email;
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
	 * @return btnMode
	 */
	public String getBtnMode() {
		return this.btnMode;
	}
	
	/**
	 * Column Info
	 * @return week
	 */
	public String getWeek() {
		return this.week;
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
	 * @param repoPlnId
	 */
	public void setRepoPlnId(String repoPlnId) {
		this.repoPlnId = repoPlnId;
	}
	
	/**
	 * Column Info
	 * @param sendMode
	 */
	public void setSendMode(String sendMode) {
		this.sendMode = sendMode;
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
	 * @param fax
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	/**
	 * Column Info
	 * @param tpsz
	 */
	public void setTpsz(String tpsz) {
		this.tpsz = tpsz;
	}
	
	/**
	 * Column Info
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
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
	 * @param btnMode
	 */
	public void setBtnMode(String btnMode) {
		this.btnMode = btnMode;
	}
	
	/**
	 * Column Info
	 * @param week
	 */
	public void setWeek(String week) {
		this.week = week;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	public String getEmlContent() {
		return emlContent;
	}

	public void setEmlContent(String emlContent) {
		this.emlContent = emlContent;
	}

	public String getEmlSubject() {
		return emlSubject;
	}

	public void setEmlSubject(String emlSubject) {
		this.emlSubject = emlSubject;
	}

	public String getFaxSubject() {
		return faxSubject;
	}

	public void setFaxSubject(String faxSubject) {
		this.faxSubject = faxSubject;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRepoPlnId(JSPUtil.getParameter(request, "repo_pln_id", ""));
		setSendMode(JSPUtil.getParameter(request, "send_mode", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFax(JSPUtil.getParameter(request, "fax", ""));
		setTpsz(JSPUtil.getParameter(request, "tpsz", ""));
		setEmail(JSPUtil.getParameter(request, "email", ""));
		setRefId(JSPUtil.getParameter(request, "ref_id", ""));
		setBtnMode(JSPUtil.getParameter(request, "btn_mode", ""));
		setWeek(JSPUtil.getParameter(request, "week", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr0131ConditionVO[]
	 */
	public EesEqr0131ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr0131ConditionVO[]
	 */
	public EesEqr0131ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0131ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] repoPlnId = (JSPUtil.getParameter(request, prefix	+ "repo_pln_id", length));
			String[] sendMode = (JSPUtil.getParameter(request, prefix	+ "send_mode", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fax = (JSPUtil.getParameter(request, prefix	+ "fax", length));
			String[] tpsz = (JSPUtil.getParameter(request, prefix	+ "tpsz", length));
			String[] email = (JSPUtil.getParameter(request, prefix	+ "email", length));
			String[] refId = (JSPUtil.getParameter(request, prefix	+ "ref_id", length));
			String[] btnMode = (JSPUtil.getParameter(request, prefix	+ "btn_mode", length));
			String[] week = (JSPUtil.getParameter(request, prefix	+ "week", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0131ConditionVO();
				if (repoPlnId[i] != null)
					model.setRepoPlnId(repoPlnId[i]);
				if (sendMode[i] != null)
					model.setSendMode(sendMode[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fax[i] != null)
					model.setFax(fax[i]);
				if (tpsz[i] != null)
					model.setTpsz(tpsz[i]);
				if (email[i] != null)
					model.setEmail(email[i]);
				if (refId[i] != null)
					model.setRefId(refId[i]);
				if (btnMode[i] != null)
					model.setBtnMode(btnMode[i]);
				if (week[i] != null)
					model.setWeek(week[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr0131ConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr0131ConditionVO[]
	 */
	public EesEqr0131ConditionVO[] getEesEqr0131ConditionVOs(){
		EesEqr0131ConditionVO[] vos = (EesEqr0131ConditionVO[])models.toArray(new EesEqr0131ConditionVO[models.size()]);
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
		this.repoPlnId = this.repoPlnId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sendMode = this.sendMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fax = this.fax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpsz = this.tpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.email = this.email .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refId = this.refId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.btnMode = this.btnMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.week = this.week .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

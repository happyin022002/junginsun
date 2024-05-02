/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0010MutiVO.java
*@FileTitle : EesEqr0010MutiVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.09.15 채창호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.simulationmanage.onewaysimulate.vo;

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
 * @author 채창호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr0010MutiVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0010MutiVO> models = new ArrayList<EesEqr0010MutiVO>();
	
	/* Column Info */
	private String fmEccCd = null;
	/* Column Info */
	private String fcastYrwk = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String division = null;
	/* Column Info */
	private String toEccCd = null;
	/* Column Info */
	private String fcastDelYrwk = null;
	/* Column Info */
	private String cntrtpsztype = null;
	/* Column Info */
	private String repoId = null;
	/* Column Info */
	private String numm = null;
	/* Column Info */
	private String fcastDt = null;
	/* Page Number */
	private String pagerows = null;
	
	private List<String> volList = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0010MutiVO() {}

	public EesEqr0010MutiVO(String ibflag, String pagerows, String fcastYrwk, String fmEccCd, String toEccCd, String division, String numm, String repoId, String cntrtpsztype, String fcastDelYrwk, String fcastDt) {
		this.fmEccCd = fmEccCd;
		this.fcastYrwk = fcastYrwk;
		this.ibflag = ibflag;
		this.division = division;
		this.toEccCd = toEccCd;
		this.fcastDelYrwk = fcastDelYrwk;
		this.cntrtpsztype = cntrtpsztype;
		this.repoId = repoId;
		this.numm = numm;
		this.fcastDt = fcastDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("fm_ecc_cd", getFmEccCd());
		this.hashColumns.put("fcast_yrwk", getFcastYrwk());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("division", getDivision());
		this.hashColumns.put("to_ecc_cd", getToEccCd());
		this.hashColumns.put("fcast_del_yrwk", getFcastDelYrwk());
		this.hashColumns.put("cntrtpsztype", getCntrtpsztype());
		this.hashColumns.put("repo_id", getRepoId());
		this.hashColumns.put("numm", getNumm());
		this.hashColumns.put("fcast_dt", getFcastDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("fm_ecc_cd", "fmEccCd");
		this.hashFields.put("fcast_yrwk", "fcastYrwk");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("division", "division");
		this.hashFields.put("to_ecc_cd", "toEccCd");
		this.hashFields.put("fcast_del_yrwk", "fcastDelYrwk");
		this.hashFields.put("cntrtpsztype", "cntrtpsztype");
		this.hashFields.put("repo_id", "repoId");
		this.hashFields.put("numm", "numm");
		this.hashFields.put("fcast_dt", "fcastDt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fmEccCd
	 */
	public String getFmEccCd() {
		return this.fmEccCd;
	}
	
	/**
	 * Column Info
	 * @return fcastYrwk
	 */
	public String getFcastYrwk() {
		return this.fcastYrwk;
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
	 * @return division
	 */
	public String getDivision() {
		return this.division;
	}
	
	/**
	 * Column Info
	 * @return toEccCd
	 */
	public String getToEccCd() {
		return this.toEccCd;
	}
	
	/**
	 * Column Info
	 * @return fcastDelYrwk
	 */
	public String getFcastDelYrwk() {
		return this.fcastDelYrwk;
	}
	
	/**
	 * Column Info
	 * @return cntrtpsztype
	 */
	public String getCntrtpsztype() {
		return this.cntrtpsztype;
	}
	
	/**
	 * Column Info
	 * @return repoId
	 */
	public String getRepoId() {
		return this.repoId;
	}
	
	/**
	 * Column Info
	 * @return numm
	 */
	public String getNumm() {
		return this.numm;
	}
	
	/**
	 * Column Info
	 * @return fcastDt
	 */
	public String getFcastDt() {
		return this.fcastDt;
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
	 * @param fmEccCd
	 */
	public void setFmEccCd(String fmEccCd) {
		this.fmEccCd = fmEccCd;
	}
	
	/**
	 * Column Info
	 * @param fcastYrwk
	 */
	public void setFcastYrwk(String fcastYrwk) {
		this.fcastYrwk = fcastYrwk;
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
	 * @param division
	 */
	public void setDivision(String division) {
		this.division = division;
	}
	
	/**
	 * Column Info
	 * @param toEccCd
	 */
	public void setToEccCd(String toEccCd) {
		this.toEccCd = toEccCd;
	}
	
	/**
	 * Column Info
	 * @param fcastDelYrwk
	 */
	public void setFcastDelYrwk(String fcastDelYrwk) {
		this.fcastDelYrwk = fcastDelYrwk;
	}
	
	/**
	 * Column Info
	 * @param cntrtpsztype
	 */
	public void setCntrtpsztype(String cntrtpsztype) {
		this.cntrtpsztype = cntrtpsztype;
	}
	
	/**
	 * Column Info
	 * @param repoId
	 */
	public void setRepoId(String repoId) {
		this.repoId = repoId;
	}
	
	/**
	 * Column Info
	 * @param numm
	 */
	public void setNumm(String numm) {
		this.numm = numm;
	}
	
	/**
	 * Column Info
	 * @param fcastDt
	 */
	public void setFcastDt(String fcastDt) {
		this.fcastDt = fcastDt;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	
	/**
	 * @return the volList
	 */
	public List<String> getVolList() {
		return volList;
	}

	/**
	 * @param volList the volList to set
	 */
	public void setVolList(List<String> volList) {
		this.volList = volList;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFmEccCd(JSPUtil.getParameter(request, "fm_ecc_cd", ""));
		setFcastYrwk(JSPUtil.getParameter(request, "fcast_yrwk", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDivision(JSPUtil.getParameter(request, "division", ""));
		setToEccCd(JSPUtil.getParameter(request, "to_ecc_cd", ""));
		setFcastDelYrwk(JSPUtil.getParameter(request, "fcast_del_yrwk", ""));
		setCntrtpsztype(JSPUtil.getParameter(request, "cntrtpsztype", ""));
		setRepoId(JSPUtil.getParameter(request, "repo_id", ""));
		setNumm(JSPUtil.getParameter(request, "numm", ""));
		setFcastDt(JSPUtil.getParameter(request, "fcast_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr0010MutiVO[]
	 */
	public EesEqr0010MutiVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr0010MutiVO[]
	 */
	public EesEqr0010MutiVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0010MutiVO model = null;
	
		String[] tmp = request.getParameterValues(prefix + "fm_ecc_cd");
  		if(tmp == null)
  			return null;

  		int length = request.getParameterValues(prefix + "fm_ecc_cd").length;
  		try {
			String cntrtpsztype = (JSPUtil.getParameter(request, "tpsz", ""));
			String[] tpszArr = cntrtpsztype.split(",");
			
			String[] fmEccCd = (JSPUtil.getParameter(request, prefix	+ "fm_ecc_cd", length));
			String[] fcastYrwk = (JSPUtil.getParameter(request, prefix	+ "fcast_yrwk", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] division = (JSPUtil.getParameter(request, prefix	+ "division", length));
			String[] toEccCd = (JSPUtil.getParameter(request, prefix	+ "to_ecc_cd", length));
			String[] fcastDelYrwk = (JSPUtil.getParameter(request, prefix	+ "fcast_del_yrwk", length));
		
			String[] repoId = (JSPUtil.getParameter(request, prefix	+ "repo_id", length));
			String[] numm = (JSPUtil.getParameter(request, prefix	+ "numm", length));
			String[] fcastDt = (JSPUtil.getParameter(request, prefix	+ "fcast_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			List<String[]> volListArr = new ArrayList<String[]>();
			
			for(int i=0; i<tpszArr.length; i++) {
				String[] volArr = (JSPUtil.getParameter(request, prefix	+ tpszArr[i].toLowerCase(), length));
				volListArr.add(volArr);
				
			}
			 for (int i = 0; i < length; i++) {
				model = new EesEqr0010MutiVO();
				List<String> volList = new ArrayList<String>();
					for(int t=0; t<tpszArr.length; t++) {
						String[] volArr  = (String[])volListArr.get(t);
						if(volArr[i] != null)
							volList.add(volArr[i]);
						}
				    model.setVolList(volList);
				if (fmEccCd[i] != null)
					model.setFmEccCd(fmEccCd[i]);
				if (fcastYrwk[i] != null)
					model.setFcastYrwk(fcastYrwk[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (division[i] != null)
					model.setDivision(division[i]);
				if (toEccCd[i] != null)
					model.setToEccCd(toEccCd[i]);
				if (fcastDelYrwk[i] != null)
					model.setFcastDelYrwk(fcastDelYrwk[i]);
			//	if (cntrtpsztype[i] != null)
			//		model.setCntrtpsztype(cntrtpsztype[i]);
				if (repoId[i] != null)
					model.setRepoId(repoId[i]);
				if (numm[i] != null)
					model.setNumm(numm[i]);
				if (fcastDt[i] != null)
					model.setFcastDt(fcastDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr0010MutiVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr0010MutiVO[]
	 */
	public EesEqr0010MutiVO[] getEesEqr0010MutiVOs(){
		EesEqr0010MutiVO[] vos = (EesEqr0010MutiVO[])models.toArray(new EesEqr0010MutiVO[models.size()]);
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
		this.fmEccCd = this.fmEccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastYrwk = this.fcastYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.division = this.division .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEccCd = this.toEccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastDelYrwk = this.fcastDelYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrtpsztype = this.cntrtpsztype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoId = this.repoId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.numm = this.numm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastDt = this.fcastDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerCargoVO.java
*@FileTitle : ContainerCargoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.15
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.06.15 김태균 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo;

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
 * @author 김태균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ContainerCargoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ContainerCargoVO> models = new ArrayList<ContainerCargoVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dmdtCntrTpNm = null;
	/* Column Info */
	private String code2 = null;
	/* Column Info */
	private String code1 = null;
	/* Column Info */
	private String codeAll = null;	
	/* Column Info */
	private String dmdtCntrTpCd = null;
	/* Column Info */
	private String dmdtCgoTpNm = null;
	/* Column Info */
	private String cntrCgo = null;
	/* Column Info */
	private String dmdtCgoTpCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ContainerCargoVO() {}

	public ContainerCargoVO(String ibflag, String pagerows, String cntrCgo, String dmdtCntrTpCd, String dmdtCgoTpNm, String dmdtCgoTpCd, String dmdtCntrTpNm, String code1, String code2, String codeAll) {
		this.ibflag = ibflag;
		this.dmdtCntrTpNm = dmdtCntrTpNm;
		this.code2 = code2;
		this.code1 = code1;
		this.codeAll = codeAll;
		this.dmdtCntrTpCd = dmdtCntrTpCd;
		this.dmdtCgoTpNm = dmdtCgoTpNm;
		this.cntrCgo = cntrCgo;
		this.dmdtCgoTpCd = dmdtCgoTpCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dmdt_cntr_tp_nm", getDmdtCntrTpNm());
		this.hashColumns.put("code2", getCode2());
		this.hashColumns.put("code1", getCode1());
		this.hashColumns.put("codeAll", getCodeAll());
		this.hashColumns.put("dmdt_cntr_tp_cd", getDmdtCntrTpCd());
		this.hashColumns.put("dmdt_cgo_tp_nm", getDmdtCgoTpNm());
		this.hashColumns.put("cntr_cgo", getCntrCgo());
		this.hashColumns.put("dmdt_cgo_tp_cd", getDmdtCgoTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dmdt_cntr_tp_nm", "dmdtCntrTpNm");
		this.hashFields.put("code2", "code2");
		this.hashFields.put("code1", "code1");
		this.hashFields.put("codeAll", "codeAll");
		this.hashFields.put("dmdt_cntr_tp_cd", "dmdtCntrTpCd");
		this.hashFields.put("dmdt_cgo_tp_nm", "dmdtCgoTpNm");
		this.hashFields.put("cntr_cgo", "cntrCgo");
		this.hashFields.put("dmdt_cgo_tp_cd", "dmdtCgoTpCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return dmdtCntrTpNm
	 */
	public String getDmdtCntrTpNm() {
		return this.dmdtCntrTpNm;
	}
	
	/**
	 * Column Info
	 * @return code2
	 */
	public String getCode2() {
		return this.code2;
	}
	
	/**
	 * Column Info
	 * @return code1
	 */
	public String getCode1() {
		return this.code1;
	}
	
	/**
	 * Column Info
	 * @return codeAll
	 */
	public String getCodeAll() {
		return this.codeAll;
	}
	
	/**
	 * Column Info
	 * @return dmdtCntrTpCd
	 */
	public String getDmdtCntrTpCd() {
		return this.dmdtCntrTpCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtCgoTpNm
	 */
	public String getDmdtCgoTpNm() {
		return this.dmdtCgoTpNm;
	}
	
	/**
	 * Column Info
	 * @return cntrCgo
	 */
	public String getCntrCgo() {
		return this.cntrCgo;
	}
	
	/**
	 * Column Info
	 * @return dmdtCgoTpCd
	 */
	public String getDmdtCgoTpCd() {
		return this.dmdtCgoTpCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @param dmdtCntrTpNm
	 */
	public void setDmdtCntrTpNm(String dmdtCntrTpNm) {
		this.dmdtCntrTpNm = dmdtCntrTpNm;
	}
	
	/**
	 * Column Info
	 * @param code2
	 */
	public void setCode2(String code2) {
		this.code2 = code2;
	}
	
	/**
	 * Column Info
	 * @param code1
	 */
	public void setCode1(String code1) {
		this.code1 = code1;
	}
	
	/**
	 * Column Info
	 * @param codeAll
	 */
	public void setCodeAll(String codeAll) {
		this.codeAll = codeAll;
	}
	
	/**
	 * Column Info
	 * @param dmdtCntrTpCd
	 */
	public void setDmdtCntrTpCd(String dmdtCntrTpCd) {
		this.dmdtCntrTpCd = dmdtCntrTpCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtCgoTpNm
	 */
	public void setDmdtCgoTpNm(String dmdtCgoTpNm) {
		this.dmdtCgoTpNm = dmdtCgoTpNm;
	}
	
	/**
	 * Column Info
	 * @param cntrCgo
	 */
	public void setCntrCgo(String cntrCgo) {
		this.cntrCgo = cntrCgo;
	}
	
	/**
	 * Column Info
	 * @param dmdtCgoTpCd
	 */
	public void setDmdtCgoTpCd(String dmdtCgoTpCd) {
		this.dmdtCgoTpCd = dmdtCgoTpCd;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDmdtCntrTpNm(JSPUtil.getParameter(request, "dmdt_cntr_tp_nm", ""));
		setCode2(JSPUtil.getParameter(request, "code2", ""));
		setCode1(JSPUtil.getParameter(request, "code1", ""));
		setCodeAll(JSPUtil.getParameter(request, "codeAll", "Y"));
		setDmdtCntrTpCd(JSPUtil.getParameter(request, "dmdt_cntr_tp_cd", ""));
		setDmdtCgoTpNm(JSPUtil.getParameter(request, "dmdt_cgo_tp_nm", ""));
		setCntrCgo(JSPUtil.getParameter(request, "cntr_cgo", ""));
		setDmdtCgoTpCd(JSPUtil.getParameter(request, "dmdt_cgo_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ContainerCargoVO[]
	 */
	public ContainerCargoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ContainerCargoVO[]
	 */
	public ContainerCargoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ContainerCargoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dmdtCntrTpNm = (JSPUtil.getParameter(request, prefix	+ "dmdt_cntr_tp_nm", length));
			String[] code2 = (JSPUtil.getParameter(request, prefix	+ "code2", length));
			String[] code1 = (JSPUtil.getParameter(request, prefix	+ "code1", length));
			String[] codeAll = (JSPUtil.getParameter(request, prefix	+ "codeAll", length));
			String[] dmdtCntrTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_cntr_tp_cd", length));
			String[] dmdtCgoTpNm = (JSPUtil.getParameter(request, prefix	+ "dmdt_cgo_tp_nm", length));
			String[] cntrCgo = (JSPUtil.getParameter(request, prefix	+ "cntr_cgo", length));
			String[] dmdtCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_cgo_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ContainerCargoVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dmdtCntrTpNm[i] != null)
					model.setDmdtCntrTpNm(dmdtCntrTpNm[i]);
				if (code2[i] != null)
					model.setCode2(code2[i]);
				if (code1[i] != null)
					model.setCode1(code1[i]);
				if (codeAll[i] != null)
					model.setCodeAll(codeAll[i]);				
				if (dmdtCntrTpCd[i] != null)
					model.setDmdtCntrTpCd(dmdtCntrTpCd[i]);
				if (dmdtCgoTpNm[i] != null)
					model.setDmdtCgoTpNm(dmdtCgoTpNm[i]);
				if (cntrCgo[i] != null)
					model.setCntrCgo(cntrCgo[i]);
				if (dmdtCgoTpCd[i] != null)
					model.setDmdtCgoTpCd(dmdtCgoTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getContainerCargoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ContainerCargoVO[]
	 */
	public ContainerCargoVO[] getContainerCargoVOs(){
		ContainerCargoVO[] vos = (ContainerCargoVO[])models.toArray(new ContainerCargoVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCntrTpNm = this.dmdtCntrTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.code2 = this.code2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.code1 = this.code1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codeAll = this.codeAll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCntrTpCd = this.dmdtCntrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCgoTpNm = this.dmdtCgoTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCgo = this.cntrCgo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCgoTpCd = this.dmdtCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

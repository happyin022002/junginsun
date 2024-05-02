/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltCrePropNoVO.java
*@FileTitle : RsltCrePropNoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.05
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.06.05 변영주 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.screport.screport.vo;

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
 * @author 변영주
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltRptPropListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltRptPropListVO> models = new ArrayList<RsltRptPropListVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String ctrtPtyNm = null;
	/* Column Info */
	private String propOfcCd = null;
	/* Column Info */
	private String fnlMqcQty = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String fileDt = null;
	
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltRptPropListVO() {}

	public RsltRptPropListVO(String ibflag, String pagerows, String propNo) {
		this.ibflag = ibflag;
		this.scNo = scNo;
		this.propNo = propNo;
		this.amdtSeq = amdtSeq;
		this.ctrtPtyNm = ctrtPtyNm;
		this.propOfcCd = propOfcCd;
		this.fnlMqcQty = fnlMqcQty;
		this.effDt = effDt;
		this.expDt = expDt;
		this.fileDt = fileDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("ctrt_pty_nm", getCtrtPtyNm());
		this.hashColumns.put("prop_ofc_cd", getPropOfcCd());
		this.hashColumns.put("fnl_mqc_qty", getFnlMqcQty());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("file_dt", getFileDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("ctrt_pty_nm", "ctrtPtyNm");
		this.hashFields.put("prop_ofc_cd", "propOfcCd");
		this.hashFields.put("fnl_mqc_qty", "fnlMqcQty");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("file_dt", "fileDt");
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
	 * @return propNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getCtrtPtyNm() {
		return this.ctrtPtyNm;
	}
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getPropOfcCd() {
		return this.propOfcCd;
	}
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getFnlMqcQty() {
		return this.fnlMqcQty;
	}
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getEffDt() {
		return this.effDt;
	}
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getExpDt() {
		return this.expDt;
	}
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getFileDt() {
		return this.fileDt;
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
	 * @param propNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setCtrtPtyNm(String ctrtPtyNm) {
		this.ctrtPtyNm = ctrtPtyNm;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setPropOfcCd(String propOfcCd) {
		this.propOfcCd = propOfcCd;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setFnlMqcQty(String fnlMqcQty) {
		this.fnlMqcQty = fnlMqcQty;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}	
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setFileDt(String fileDt) {
		this.fileDt = fileDt;
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
		setPropNo(JSPUtil.getParameter(request, "sc_no", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
		setPropNo(JSPUtil.getParameter(request, "amdt_seq", ""));
		setPropNo(JSPUtil.getParameter(request, "ctrt_pty_nm", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_ofc_cd", ""));
		setPropNo(JSPUtil.getParameter(request, "fnl_mqc_qty", ""));
		setPropNo(JSPUtil.getParameter(request, "eff_dt", ""));
		setPropNo(JSPUtil.getParameter(request, "exp_dt", ""));
		setPropNo(JSPUtil.getParameter(request, "file_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltCrePropNoVO[]
	 */
	public RsltRptPropListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltCrePropNoVO[]
	 */
	public RsltRptPropListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltRptPropListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no".trim(), length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no".trim(), length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq".trim(), length));
			String[] ctrtPtyNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_pty_nm".trim(), length));
			String[] propOfcCd = (JSPUtil.getParameter(request, prefix	+ "prop_ofc_cd".trim(), length));
			String[] fnlMqcQty = (JSPUtil.getParameter(request, prefix	+ "fnl_mqc_qty".trim(), length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt".trim(), length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt".trim(), length));
			String[] fileDt = (JSPUtil.getParameter(request, prefix	+ "file_dt".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltRptPropListVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltCrePropNoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltCrePropNoVO[]
	 */
	public RsltRptPropListVO[] getRsltCrePropNoVOs(){
		RsltRptPropListVO[] vos = (RsltRptPropListVO[])models.toArray(new RsltRptPropListVO[models.size()]);
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
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtPtyNm = this.ctrtPtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propOfcCd = this.propOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlMqcQty = this.fnlMqcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileDt = this.fileDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

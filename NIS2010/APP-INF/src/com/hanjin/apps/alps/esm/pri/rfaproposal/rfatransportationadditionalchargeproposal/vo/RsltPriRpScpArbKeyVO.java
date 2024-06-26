/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltPriRpScpArbKeyVO.java
*@FileTitle : RsltPriRpScpArbKeyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.14
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.08.14 최성민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo;

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
 * @author 최성민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltPriRpScpArbKeyVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPriRpScpArbKeyVO> models = new ArrayList<RsltPriRpScpArbKeyVO>();
	
	/* Column Info */
	private String addChgSeq = null;
	/* Column Info */
	private String addChgTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String orgDestTpCd = null;
	/* Column Info */
	private String n1stCmncDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPriRpScpArbKeyVO() {}

	public RsltPriRpScpArbKeyVO(String ibflag, String pagerows, String svcScpCd, String propNo, String amdtSeq, String addChgTpCd, String orgDestTpCd, String addChgSeq, String n1stCmncDt) {
		this.addChgSeq = addChgSeq;
		this.addChgTpCd = addChgTpCd;
		this.ibflag = ibflag;
		this.amdtSeq = amdtSeq;
		this.propNo = propNo;
		this.svcScpCd = svcScpCd;
		this.orgDestTpCd = orgDestTpCd;
		this.n1stCmncDt = n1stCmncDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("add_chg_seq", getAddChgSeq());
		this.hashColumns.put("add_chg_tp_cd", getAddChgTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("org_dest_tp_cd", getOrgDestTpCd());
		this.hashColumns.put("n1st_cmnc_dt", getN1stCmncDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("add_chg_seq", "addChgSeq");
		this.hashFields.put("add_chg_tp_cd", "addChgTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("org_dest_tp_cd", "orgDestTpCd");
		this.hashFields.put("n1st_cmnc_dt", "n1stCmncDt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return addChgSeq
	 */
	public String getAddChgSeq() {
		return this.addChgSeq;
	}
	
	/**
	 * Column Info
	 * @return addChgTpCd
	 */
	public String getAddChgTpCd() {
		return this.addChgTpCd;
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
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
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
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return orgDestTpCd
	 */
	public String getOrgDestTpCd() {
		return this.orgDestTpCd;
	}
	
	/**
	 * Column Info
	 * @return n1stCmncDt
	 */
	public String getN1stCmncDt() {
		return this.n1stCmncDt;
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
	 * @param addChgSeq
	 */
	public void setAddChgSeq(String addChgSeq) {
		this.addChgSeq = addChgSeq;
	}
	
	/**
	 * Column Info
	 * @param addChgTpCd
	 */
	public void setAddChgTpCd(String addChgTpCd) {
		this.addChgTpCd = addChgTpCd;
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
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
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
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param orgDestTpCd
	 */
	public void setOrgDestTpCd(String orgDestTpCd) {
		this.orgDestTpCd = orgDestTpCd;
	}
	
	/**
	 * Column Info
	 * @param n1stCmncDt
	 */
	public void setN1stCmncDt(String n1stCmncDt) {
		this.n1stCmncDt = n1stCmncDt;
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
		setAddChgSeq(JSPUtil.getParameter(request, "add_chg_seq", ""));
		setAddChgTpCd(JSPUtil.getParameter(request, "add_chg_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAmdtSeq(JSPUtil.getParameter(request, "amdt_seq", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setOrgDestTpCd(JSPUtil.getParameter(request, "org_dest_tp_cd", ""));
		setN1stCmncDt(JSPUtil.getParameter(request, "n1st_cmnc_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPriRpScpArbKeyVO[]
	 */
	public RsltPriRpScpArbKeyVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPriRpScpArbKeyVO[]
	 */
	public RsltPriRpScpArbKeyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPriRpScpArbKeyVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] addChgSeq = (JSPUtil.getParameter(request, prefix	+ "add_chg_seq", length));
			String[] addChgTpCd = (JSPUtil.getParameter(request, prefix	+ "add_chg_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] orgDestTpCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_tp_cd", length));
			String[] n1stCmncDt = (JSPUtil.getParameter(request, prefix	+ "n1st_cmnc_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPriRpScpArbKeyVO();
				if (addChgSeq[i] != null)
					model.setAddChgSeq(addChgSeq[i]);
				if (addChgTpCd[i] != null)
					model.setAddChgTpCd(addChgTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (orgDestTpCd[i] != null)
					model.setOrgDestTpCd(orgDestTpCd[i]);
				if (n1stCmncDt[i] != null)
					model.setN1stCmncDt(n1stCmncDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPriRpScpArbKeyVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPriRpScpArbKeyVO[]
	 */
	public RsltPriRpScpArbKeyVO[] getRsltPriRpScpArbKeyVOs(){
		RsltPriRpScpArbKeyVO[] vos = (RsltPriRpScpArbKeyVO[])models.toArray(new RsltPriRpScpArbKeyVO[models.size()]);
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
		this.addChgSeq = this.addChgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addChgTpCd = this.addChgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestTpCd = this.orgDestTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stCmncDt = this.n1stCmncDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

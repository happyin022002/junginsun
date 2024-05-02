/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExtraDisposalMgtINVO.java
*@FileTitle : ExtraDisposalMgtINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.09.10 김완규 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.operationmanage.extradisposalmgt.vo;

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
 * @author 김완규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ExtraDisposalMgtINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ExtraDisposalMgtINVO> models = new ArrayList<ExtraDisposalMgtINVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String issOfcCd = null;
	/* Column Info */
	private String mnrXtraDispTpCd = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String creDtTo = null;
	/* Column Info */
	private String creDtFr = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ExtraDisposalMgtINVO() {}

	public ExtraDisposalMgtINVO(String ibflag, String pagerows, String eqKndCd, String eqNo, String mnrXtraDispTpCd, String issOfcCd, String creDtFr, String creDtTo) {
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.issOfcCd = issOfcCd;
		this.mnrXtraDispTpCd = mnrXtraDispTpCd;
		this.eqKndCd = eqKndCd;
		this.creDtTo = creDtTo;
		this.creDtFr = creDtFr;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("iss_ofc_cd", getIssOfcCd());
		this.hashColumns.put("mnr_xtra_disp_tp_cd", getMnrXtraDispTpCd());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("cre_dt_to", getCreDtTo());
		this.hashColumns.put("cre_dt_fr", getCreDtFr());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("iss_ofc_cd", "issOfcCd");
		this.hashFields.put("mnr_xtra_disp_tp_cd", "mnrXtraDispTpCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("cre_dt_to", "creDtTo");
		this.hashFields.put("cre_dt_fr", "creDtFr");
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
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return issOfcCd
	 */
	public String getIssOfcCd() {
		return this.issOfcCd;
	}
	
	/**
	 * Column Info
	 * @return mnrXtraDispTpCd
	 */
	public String getMnrXtraDispTpCd() {
		return this.mnrXtraDispTpCd;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	
	/**
	 * Column Info
	 * @return creDtTo
	 */
	public String getCreDtTo() {
		return this.creDtTo;
	}
	
	/**
	 * Column Info
	 * @return creDtFr
	 */
	public String getCreDtFr() {
		return this.creDtFr;
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
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param issOfcCd
	 */
	public void setIssOfcCd(String issOfcCd) {
		this.issOfcCd = issOfcCd;
	}
	
	/**
	 * Column Info
	 * @param mnrXtraDispTpCd
	 */
	public void setMnrXtraDispTpCd(String mnrXtraDispTpCd) {
		this.mnrXtraDispTpCd = mnrXtraDispTpCd;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}
	
	/**
	 * Column Info
	 * @param creDtTo
	 */
	public void setCreDtTo(String creDtTo) {
		this.creDtTo = creDtTo;
	}
	
	/**
	 * Column Info
	 * @param creDtFr
	 */
	public void setCreDtFr(String creDtFr) {
		this.creDtFr = creDtFr;
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
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setIssOfcCd(JSPUtil.getParameter(request, "iss_ofc_cd", ""));
		setMnrXtraDispTpCd(JSPUtil.getParameter(request, "mnr_xtra_disp_tp_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setCreDtTo(JSPUtil.getParameter(request, "cre_dt_to", ""));
		setCreDtFr(JSPUtil.getParameter(request, "cre_dt_fr", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ExtraDisposalMgtINVO[]
	 */
	public ExtraDisposalMgtINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ExtraDisposalMgtINVO[]
	 */
	public ExtraDisposalMgtINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ExtraDisposalMgtINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] issOfcCd = (JSPUtil.getParameter(request, prefix	+ "iss_ofc_cd", length));
			String[] mnrXtraDispTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_xtra_disp_tp_cd", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] creDtTo = (JSPUtil.getParameter(request, prefix	+ "cre_dt_to", length));
			String[] creDtFr = (JSPUtil.getParameter(request, prefix	+ "cre_dt_fr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ExtraDisposalMgtINVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (issOfcCd[i] != null)
					model.setIssOfcCd(issOfcCd[i]);
				if (mnrXtraDispTpCd[i] != null)
					model.setMnrXtraDispTpCd(mnrXtraDispTpCd[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (creDtTo[i] != null)
					model.setCreDtTo(creDtTo[i]);
				if (creDtFr[i] != null)
					model.setCreDtFr(creDtFr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getExtraDisposalMgtINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ExtraDisposalMgtINVO[]
	 */
	public ExtraDisposalMgtINVO[] getExtraDisposalMgtINVOs(){
		ExtraDisposalMgtINVO[] vos = (ExtraDisposalMgtINVO[])models.toArray(new ExtraDisposalMgtINVO[models.size()]);
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
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issOfcCd = this.issOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrXtraDispTpCd = this.mnrXtraDispTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDtTo = this.creDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDtFr = this.creDtFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

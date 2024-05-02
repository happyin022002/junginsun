/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchBunkerConditonVO.java
*@FileTitle : SearchBunkerConditonVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
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
public class SearchBunkerConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchBunkerConditionVO> models = new ArrayList<SearchBunkerConditionVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	
	/* Page Number */
	private String pagerows = null;

	/* Column Info */
	private String fletCtrtNo = null;

	/* Column Info */
	private String fletCtrtTpCd = null;

	/* Column Info */
	private String csrCurrCd = null;

	/* Column Info */
	private String ofcCd = null;

	/* Column Info */
	private String aproFlg = null;

	/* Column Info */
	private String bnkTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchBunkerConditionVO() {}

	public SearchBunkerConditionVO(String ibflag, String pagerows, String fletCtrtNo, String fletCtrtTpCd, String csrCurrCd, String ofcCd, String aproFlg, String bnkTpCd) {
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.fletCtrtNo = fletCtrtNo;
		this.fletCtrtTpCd = fletCtrtTpCd;
		this.csrCurrCd = csrCurrCd;
		this.ofcCd = ofcCd;
		this.aproFlg = aproFlg;
		this.bnkTpCd = bnkTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("flet_ctrt_no", getFletCtrtNo());
		this.hashColumns.put("flet_ctrt_tp_cd", getFletCtrtTpCd());
		this.hashColumns.put("csr_curr_cd", getCsrCurrCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("apro_flg", getAproFlg());
		this.hashColumns.put("bnk_tp_cd", getBnkTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("flet_ctrt_no", "fletCtrtNo");
		this.hashFields.put("flet_ctrt_tp_cd", "fletCtrtTpCd");
		this.hashFields.put("csr_curr_cd", "csrCurrCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("apro_flg", "aproFlg");
		this.hashFields.put("bnk_tp_cd", "bnkTpCd");
		return this.hashFields;
	}
	
	/**
	 *
	 * @param String ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * 
	 * @return String ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 *
	 * @param String pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * 
	 * @return String pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 *
	 * @param String fletCtrtNo
	 */
	public void setFletCtrtNo(String fletCtrtNo) {
		this.fletCtrtNo = fletCtrtNo;
	}
	
	/**
	 * 
	 * @return String fletCtrtNo
	 */
	public String getFletCtrtNo() {
		return this.fletCtrtNo;
	}
	
	/**
	 *
	 * @param String fletCtrtTpCd
	 */
	public void setFletCtrtTpCd(String fletCtrtTpCd) {
		this.fletCtrtTpCd = fletCtrtTpCd;
	}
	
	/**
	 * 
	 * @return String fletCtrtTpCd
	 */
	public String getFletCtrtTpCd() {
		return this.fletCtrtTpCd;
	}
	
	/**
	 *
	 * @param String csrCurrCd
	 */
	public void setCsrCurrCd(String csrCurrCd) {
		this.csrCurrCd = csrCurrCd;
	}
	
	/**
	 * 
	 * @return String csrCurrCd
	 */
	public String getCsrCurrCd() {
		return this.csrCurrCd;
	}
	
	/**
	 *
	 * @param String ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * 
	 * @return String ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 *
	 * @param String aproFlg
	 */
	public void setAproFlg(String aproFlg) {
		this.aproFlg = aproFlg;
	}
	
	/**
	 * 
	 * @return String aproFlg
	 */
	public String getAproFlg() {
		return this.aproFlg;
	}
	
	/**
	 *
	 * @param String bnkTpCd
	 */
	public void setBnkTpCd(String bnkTpCd) {
		this.bnkTpCd = bnkTpCd;
	}
	
	/**
	 * 
	 * @return String bnkTpCd
	 */
	public String getBnkTpCd() {
		return this.bnkTpCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFletCtrtNo(JSPUtil.getParameter(request, prefix + "flet_ctrt_no", ""));
		setFletCtrtTpCd(JSPUtil.getParameter(request, prefix + "flet_ctrt_tp_cd", ""));
		setCsrCurrCd(JSPUtil.getParameter(request, prefix + "csr_curr_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setAproFlg(JSPUtil.getParameter(request, prefix + "apro_flg", ""));
		setBnkTpCd(JSPUtil.getParameter(request, prefix + "bnk_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchBunkerConditonVO[]
	 */
	public SearchBunkerConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchBunkerConditonVO[]
	 */
	public SearchBunkerConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchBunkerConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fletCtrtNo = (JSPUtil.getParameter(request, prefix	+ "flet_ctrt_no", length));
			String[] fletCtrtTpCd = (JSPUtil.getParameter(request, prefix	+ "flet_ctrt_tp_cd", length));
			String[] csrCurrCd = (JSPUtil.getParameter(request, prefix	+ "csr_curr_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] aproFlg = (JSPUtil.getParameter(request, prefix	+ "apro_flg", length));
			String[] bnkTpCd = (JSPUtil.getParameter(request, prefix	+ "bnk_tp_cd", length));
			/* Add a field line, do not delete */
			
			for (int i = 0; i < length; i++) {
				model = new SearchBunkerConditionVO();
				if (ibflag[i] != null) 
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null) 
					model.setPagerows(pagerows[i]);
				if (fletCtrtNo[i] != null) 
					model.setFletCtrtNo(fletCtrtNo[i]);
				if (fletCtrtTpCd[i] != null) 
					model.setFletCtrtTpCd(fletCtrtTpCd[i]);
				if (csrCurrCd[i] != null) 
					model.setCsrCurrCd(csrCurrCd[i]);
				if (ofcCd[i] != null) 
					model.setOfcCd(ofcCd[i]);
				if (aproFlg[i] != null) 
					model.setAproFlg(aproFlg[i]);
				if (bnkTpCd[i] != null) 
					model.setBnkTpCd(bnkTpCd[i]);
				/* Add a Method line, do not delete */
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchBunkerConditonVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchBunkerConditonVO[]
	 */
	public SearchBunkerConditionVO[] getSearchBunkerConditonVOs(){
		SearchBunkerConditionVO[] vos = (SearchBunkerConditionVO[])models.toArray(new SearchBunkerConditionVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	 * 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	 */
	public void unDataFormat(){
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtNo = this.fletCtrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtTpCd = this.fletCtrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrCurrCd = this.csrCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproFlg = this.aproFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bnkTpCd = this.bnkTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
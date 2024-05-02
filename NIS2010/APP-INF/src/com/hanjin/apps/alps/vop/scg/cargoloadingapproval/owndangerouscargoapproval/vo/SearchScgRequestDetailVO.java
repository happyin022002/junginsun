/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchScgRequestDetailVO.java
*@FileTitle : SearchScgRequestDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.20
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.11.20 이도형 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이도형
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchScgRequestDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchScgRequestDetailVO> models = new ArrayList<SearchScgRequestDetailVO>();
	
	/* Column Info */
	private String rqstDt = null;
	/* Column Info */
	private String rqstGdt = null;
	/* Column Info */
	private String rqstUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rqstUsrNm = null;
	/* Column Info */
	private String rqstOfcCd = null;
	/* Column Info */
	private String rqstUsrPhnNo = null;
	/* Column Info */
	private String rqstUsrEml = null;
	/* Page Number */
	private String pagerows = null;
	/* Page Number */
	private String dgFlag = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchScgRequestDetailVO() {}

	public SearchScgRequestDetailVO(String ibflag, String pagerows, String rqstUsrId, String rqstUsrNm, String rqstOfcCd, String rqstDt, String rqstGdt, String rqstUsrPhnNo, String rqstUsrEml, String dgFlag) {
		this.rqstDt = rqstDt;
		this.rqstGdt = rqstGdt;
		this.rqstUsrId = rqstUsrId;
		this.ibflag = ibflag;
		this.rqstUsrNm = rqstUsrNm;
		this.rqstOfcCd = rqstOfcCd;
		this.rqstUsrPhnNo = rqstUsrPhnNo;
		this.rqstUsrEml = rqstUsrEml;
		this.pagerows = pagerows;
		this.dgFlag = dgFlag;
		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rqst_dt", getRqstDt());
		this.hashColumns.put("rqst_gdt", getRqstGdt());
		this.hashColumns.put("rqst_usr_id", getRqstUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rqst_usr_nm", getRqstUsrNm());
		this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
		this.hashColumns.put("rqst_usr_phn_no", getRqstUsrPhnNo());
		this.hashColumns.put("rqst_usr_eml", getRqstUsrEml());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dg_flag", getDgFlag());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("rqst_gdt", "rqstGdt");
		this.hashFields.put("rqst_usr_id", "rqstUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rqst_usr_nm", "rqstUsrNm");
		this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
		this.hashFields.put("rqst_usr_phn_no", "rqstUsrPhnNo");
		this.hashFields.put("rqst_usr_eml", "rqstUsrEml");
		this.hashFields.put("dg_flag", "dgFlag");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rqstDt
	 */
	public String getRqstDt() {
		return this.rqstDt;
	}
	/**
	 * Column Info
	 * @return dgFlag
	 */
	public String getDgFlag() {
		return this.dgFlag;
	}
	
	/**
	 * Column Info
	 * @return rqstGdt
	 */
	public String getRqstGdt() {
		return this.rqstGdt;
	}
	
	/**
	 * Column Info
	 * @return rqstUsrId
	 */
	public String getRqstUsrId() {
		return this.rqstUsrId;
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
	 * @return rqstUsrNm
	 */
	public String getRqstUsrNm() {
		return this.rqstUsrNm;
	}
	
	/**
	 * Column Info
	 * @return rqstOfcCd
	 */
	public String getRqstOfcCd() {
		return this.rqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rqstUsrPhnNo
	 */
	public String getRqstUsrPhnNo() {
		return this.rqstUsrPhnNo;
	}
	
	/**
	 * Column Info
	 * @return rqstUsrEml
	 */
	public String getRqstUsrEml() {
		return this.rqstUsrEml;
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
	 * @param dgFlag
	 */
	public void setDgFlag(String dgFlag) {
		this.dgFlag = dgFlag;
	}
	/**
	 * Column Info
	 * @param rqstDt
	 */
	public void setRqstDt(String rqstDt) {
		this.rqstDt = rqstDt;
	}
	
	/**
	 * Column Info
	 * @param rqstDt
	 */
	public void setRqstGdt(String rqstGdt) {
		this.rqstGdt = rqstGdt;
	}
	
	/**
	 * Column Info
	 * @param rqstUsrId
	 */
	public void setRqstUsrId(String rqstUsrId) {
		this.rqstUsrId = rqstUsrId;
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
	 * @param rqstUsrNm
	 */
	public void setRqstUsrNm(String rqstUsrNm) {
		this.rqstUsrNm = rqstUsrNm;
	}
	
	/**
	 * Column Info
	 * @param rqstOfcCd
	 */
	public void setRqstOfcCd(String rqstOfcCd) {
		this.rqstOfcCd = rqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rqstUsrPhnNo
	 */
	public void setRqstUsrPhnNo(String rqstUsrPhnNo) {
		this.rqstUsrPhnNo = rqstUsrPhnNo;
	}
	
	/**
	 * Column Info
	 * @param rqstUsrEml
	 */
	public void setRqstUsrEml(String rqstUsrEml) {
		this.rqstUsrEml = rqstUsrEml;
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
		setRqstDt(JSPUtil.getParameter(request, "rqst_dt", ""));
		setRqstGdt(JSPUtil.getParameter(request, "rqst_gdt", ""));
		setRqstUsrId(JSPUtil.getParameter(request, "rqst_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRqstUsrNm(JSPUtil.getParameter(request, "rqst_usr_nm", ""));
		setRqstOfcCd(JSPUtil.getParameter(request, "rqst_ofc_cd", ""));
		setRqstUsrPhnNo(JSPUtil.getParameter(request, "rqst_usr_phn_no", ""));
		setRqstUsrEml(JSPUtil.getParameter(request, "rqst_usr_eml", ""));
		setDgFlag(JSPUtil.getParameter(request, "dg_flag", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchScgRequestDetailVO[]
	 */
	public SearchScgRequestDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchScgRequestDetailVO[]
	 */
	public SearchScgRequestDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchScgRequestDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rqstDt = (JSPUtil.getParameter(request, prefix	+ "rqst_dt", length));
			String[] rqstGdt = (JSPUtil.getParameter(request, prefix	+ "rqst_gdt", length));
			String[] rqstUsrId = (JSPUtil.getParameter(request, prefix	+ "rqst_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rqstUsrNm = (JSPUtil.getParameter(request, prefix	+ "rqst_usr_nm", length));
			String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rqst_ofc_cd", length));
			String[] rqstUsrPhnNo = (JSPUtil.getParameter(request, prefix	+ "rqst_usr_phn_no", length));
			String[] rqstUsrEml = (JSPUtil.getParameter(request, prefix	+ "rqst_usr_eml", length));
			String[] dgFlag = (JSPUtil.getParameter(request, prefix	+ "dg_flag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchScgRequestDetailVO();
				if (rqstDt[i] != null)
					model.setRqstDt(rqstDt[i]);
				if (rqstGdt[i] != null)
					model.setRqstGdt(rqstGdt[i]);
				if (rqstUsrId[i] != null)
					model.setRqstUsrId(rqstUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rqstUsrNm[i] != null)
					model.setRqstUsrNm(rqstUsrNm[i]);
				if (rqstOfcCd[i] != null)
					model.setRqstOfcCd(rqstOfcCd[i]);
				if (rqstUsrPhnNo[i] != null)
					model.setRqstUsrPhnNo(rqstUsrPhnNo[i]);
				if (rqstUsrEml[i] != null)
					model.setRqstUsrEml(rqstUsrEml[i]);
				if (dgFlag[i] != null)
					model.setDgFlag(dgFlag[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchScgRequestDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchScgRequestDetailVO[]
	 */
	public SearchScgRequestDetailVO[] getSearchScgRequestDetailVOs(){
		SearchScgRequestDetailVO[] vos = (SearchScgRequestDetailVO[])models.toArray(new SearchScgRequestDetailVO[models.size()]);
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
		this.rqstDt = this.rqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstGdt = this.rqstGdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUsrId = this.rqstUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUsrNm = this.rqstUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcCd = this.rqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUsrPhnNo = this.rqstUsrPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUsrEml = this.rqstUsrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

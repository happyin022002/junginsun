/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JapDoHisSearchVO.java
*@FileTitle : JapDoHisSearchVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 
*@LastVersion : 1.0
* 2009.08.11  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

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

public class JapDoHisSearchVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<JapDoHisSearchVO> models = new ArrayList<JapDoHisSearchVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String evntOfcCd = null;
	/* Column Info */
	private String issueOfcCd = null;
	/* Column Info */
	private String rdFlag = null;
	/* Column Info */
	private String evntDtStart = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String rlseStsCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String excelFlg = null;
	/* Column Info */
	private String pageNo = null;
	/* Column Info */
	private String evntDtEnd = null;
	/* Column Info */
	private String issueDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public JapDoHisSearchVO() {}

	public JapDoHisSearchVO(String ibflag, String pagerows, String evntDtStart, String evntDtEnd, String evntOfcCd, String issueDt, String issueOfcCd, String podCd, String rdFlag, String rlseStsCd, String skdDirCd, String skdVoyNo, String vslCd, String pageNo, String excelFlg) {
		this.vslCd = vslCd;
		this.evntOfcCd = evntOfcCd;
		this.issueOfcCd = issueOfcCd;
		this.rdFlag = rdFlag;
		this.evntDtStart = evntDtStart;
		this.skdVoyNo = skdVoyNo;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.rlseStsCd = rlseStsCd;
		this.ibflag = ibflag;
		this.excelFlg = excelFlg;
		this.pageNo = pageNo;
		this.evntDtEnd = evntDtEnd;
		this.issueDt = issueDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("evnt_ofc_cd", getEvntOfcCd());
		this.hashColumns.put("issue_ofc_cd", getIssueOfcCd());
		this.hashColumns.put("rd_flag", getRdFlag());
		this.hashColumns.put("evnt_dt_start", getEvntDtStart());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("rlse_sts_cd", getRlseStsCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("excel_flg", getExcelFlg());
		this.hashColumns.put("page_no", getPageNo());
		this.hashColumns.put("evnt_dt_end", getEvntDtEnd());
		this.hashColumns.put("issue_dt", getIssueDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("evnt_ofc_cd", "evntOfcCd");
		this.hashFields.put("issue_ofc_cd", "issueOfcCd");
		this.hashFields.put("rd_flag", "rdFlag");
		this.hashFields.put("evnt_dt_start", "evntDtStart");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("rlse_sts_cd", "rlseStsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("excel_flg", "excelFlg");
		this.hashFields.put("page_no", "pageNo");
		this.hashFields.put("evnt_dt_end", "evntDtEnd");
		this.hashFields.put("issue_dt", "issueDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return evntOfcCd
	 */
	public String getEvntOfcCd() {
		return this.evntOfcCd;
	}
	
	/**
	 * Column Info
	 * @return issueOfcCd
	 */
	public String getIssueOfcCd() {
		return this.issueOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rdFlag
	 */
	public String getRdFlag() {
		return this.rdFlag;
	}
	
	/**
	 * Column Info
	 * @return evntDtStart
	 */
	public String getEvntDtStart() {
		return this.evntDtStart;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return rlseStsCd
	 */
	public String getRlseStsCd() {
		return this.rlseStsCd;
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
	 * @return excelFlg
	 */
	public String getExcelFlg() {
		return this.excelFlg;
	}
	
	/**
	 * Column Info
	 * @return pageNo
	 */
	public String getPageNo() {
		return this.pageNo;
	}
	
	/**
	 * Column Info
	 * @return evntDtEnd
	 */
	public String getEvntDtEnd() {
		return this.evntDtEnd;
	}
	
	/**
	 * Column Info
	 * @return issueDt
	 */
	public String getIssueDt() {
		return this.issueDt;
	}
	

	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param evntOfcCd
	 */
	public void setEvntOfcCd(String evntOfcCd) {
		this.evntOfcCd = evntOfcCd;
	}
	
	/**
	 * Column Info
	 * @param issueOfcCd
	 */
	public void setIssueOfcCd(String issueOfcCd) {
		this.issueOfcCd = issueOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rdFlag
	 */
	public void setRdFlag(String rdFlag) {
		this.rdFlag = rdFlag;
	}
	
	/**
	 * Column Info
	 * @param evntDtStart
	 */
	public void setEvntDtStart(String evntDtStart) {
		this.evntDtStart = evntDtStart;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param rlseStsCd
	 */
	public void setRlseStsCd(String rlseStsCd) {
		this.rlseStsCd = rlseStsCd;
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
	 * @param excelFlg
	 */
	public void setExcelFlg(String excelFlg) {
		this.excelFlg = excelFlg;
	}
	
	/**
	 * Column Info
	 * @param pageNo
	 */
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	
	/**
	 * Column Info
	 * @param evntDtEnd
	 */
	public void setEvntDtEnd(String evntDtEnd) {
		this.evntDtEnd = evntDtEnd;
	}
	
	/**
	 * Column Info
	 * @param issueDt
	 */
	public void setIssueDt(String issueDt) {
		this.issueDt = issueDt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setEvntOfcCd(JSPUtil.getParameter(request, "evnt_ofc_cd", ""));
		setIssueOfcCd(JSPUtil.getParameter(request, "issue_ofc_cd", ""));
		setRdFlag(JSPUtil.getParameter(request, "rd_flag", ""));
		setEvntDtStart(JSPUtil.getParameter(request, "evnt_dt_start", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setRlseStsCd(JSPUtil.getParameter(request, "rlse_sts_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setExcelFlg(JSPUtil.getParameter(request, "excel_flg", ""));
		setPageNo(JSPUtil.getParameter(request, "page_no", ""));
		setEvntDtEnd(JSPUtil.getParameter(request, "evnt_dt_end", ""));
		setIssueDt(JSPUtil.getParameter(request, "issue_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return JapDoHisSearchVO[]
	 */
	public JapDoHisSearchVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return JapDoHisSearchVO[]
	 */
	public JapDoHisSearchVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		JapDoHisSearchVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] evntOfcCd = (JSPUtil.getParameter(request, prefix	+ "evnt_ofc_cd", length));
			String[] issueOfcCd = (JSPUtil.getParameter(request, prefix	+ "issue_ofc_cd", length));
			String[] rdFlag = (JSPUtil.getParameter(request, prefix	+ "rd_flag", length));
			String[] evntDtStart = (JSPUtil.getParameter(request, prefix	+ "evnt_dt_start", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] rlseStsCd = (JSPUtil.getParameter(request, prefix	+ "rlse_sts_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] excelFlg = (JSPUtil.getParameter(request, prefix	+ "excel_flg", length));
			String[] pageNo = (JSPUtil.getParameter(request, prefix	+ "page_no", length));
			String[] evntDtEnd = (JSPUtil.getParameter(request, prefix	+ "evnt_dt_end", length));
			String[] issueDt = (JSPUtil.getParameter(request, prefix	+ "issue_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new JapDoHisSearchVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (evntOfcCd[i] != null)
					model.setEvntOfcCd(evntOfcCd[i]);
				if (issueOfcCd[i] != null)
					model.setIssueOfcCd(issueOfcCd[i]);
				if (rdFlag[i] != null)
					model.setRdFlag(rdFlag[i]);
				if (evntDtStart[i] != null)
					model.setEvntDtStart(evntDtStart[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (rlseStsCd[i] != null)
					model.setRlseStsCd(rlseStsCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (excelFlg[i] != null)
					model.setExcelFlg(excelFlg[i]);
				if (pageNo[i] != null)
					model.setPageNo(pageNo[i]);
				if (evntDtEnd[i] != null)
					model.setEvntDtEnd(evntDtEnd[i]);
				if (issueDt[i] != null)
					model.setIssueDt(issueDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getJapDoHisSearchVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return JapDoHisSearchVO[]
	 */
	public JapDoHisSearchVO[] getJapDoHisSearchVOs(){
		JapDoHisSearchVO[] vos = (JapDoHisSearchVO[])models.toArray(new JapDoHisSearchVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntOfcCd = this.evntOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issueOfcCd = this.issueOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdFlag = this.rdFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDtStart = this.evntDtStart .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlseStsCd = this.rlseStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.excelFlg = this.excelFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pageNo = this.pageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDtEnd = this.evntDtEnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issueDt = this.issueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

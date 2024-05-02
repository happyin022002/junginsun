/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JapanManifestListCondVO.java
*@FileTitle : JapanManifestListCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.15
*@LastModifier : 
*@LastVersion : 1.0
* 2009.06.15  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see ManifestListCondVO
 */

public class JapanManifestListCondVO extends ManifestListCondVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<JapanManifestListCondVO> models = new ArrayList<JapanManifestListCondVO>();
	
	/* Column Info */
	private String inSkdVoyNo = null;
	/* Column Info */
	private String inErrGb = null;
	/* Column Info */
	private String inSkdDirCd = null;
	/* Column Info */
	private String inCallSgnNo = null;
	/* Column Info */
	private String inCallInd = null;
	/* Column Info */
	private String inEtaDt = null;
	/* Column Info */
	private String inVslCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String inBlType = null;
	/* Column Info */
	private String inBlNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String inPolCd = null;
	/* Column Info */
	private String inBlSplitNo = null;
	/* Column Info */
	private String inVvdCd = null;
	/* Column Info */
	private String inPodCd = null;
	/* Column Info */
	private String inVoyageNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public JapanManifestListCondVO() {}

	public JapanManifestListCondVO(String ibflag, String pagerows, String inSkdVoyNo, String inErrGb, String inSkdDirCd, String inCallSgnNo, String inCallInd, String inEtaDt, String inVslCd, String inBlType, String inPolCd, String inPodCd, String inVvdCd, String inBlNo, String inBlSplitNo, String inVoyageNo) {
		this.inSkdVoyNo = inSkdVoyNo;
		this.inErrGb = inErrGb;
		this.inSkdDirCd = inSkdDirCd;
		this.inCallSgnNo = inCallSgnNo;
		this.inCallInd = inCallInd;
		this.inEtaDt = inEtaDt;
		this.inVslCd = inVslCd;
		this.pagerows = pagerows;
		this.inBlType = inBlType;
		this.inBlNo = inBlNo;
		this.ibflag = ibflag;
		this.inPolCd = inPolCd;
		this.inBlSplitNo = inBlSplitNo;
		this.inVvdCd = inVvdCd;
		this.inPodCd = inPodCd;
		this.inVoyageNo = inVoyageNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("in_skd_voy_no", getInSkdVoyNo());
		this.hashColumns.put("in_err_gb", getInErrGb());
		this.hashColumns.put("in_skd_dir_cd", getInSkdDirCd());
		this.hashColumns.put("in_call_sgn_no", getInCallSgnNo());
		this.hashColumns.put("in_call_ind", getInCallInd());
		this.hashColumns.put("in_eta_dt", getInEtaDt());
		this.hashColumns.put("in_vsl_cd", getInVslCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("in_bl_type", getInBlType());
		this.hashColumns.put("in_bl_no", getInBlNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("in_pol_cd", getInPolCd());
		this.hashColumns.put("in_bl_split_no", getInBlSplitNo());
		this.hashColumns.put("in_vvd_cd", getInVvdCd());
		this.hashColumns.put("in_pod_cd", getInPodCd());
		this.hashColumns.put("in_voyage_no", getInVoyageNo());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("in_skd_voy_no", "inSkdVoyNo");
		this.hashFields.put("in_err_gb", "inErrGb");
		this.hashFields.put("in_skd_dir_cd", "inSkdDirCd");
		this.hashFields.put("in_call_sgn_no", "inCallSgnNo");
		this.hashFields.put("in_call_ind", "inCallInd");
		this.hashFields.put("in_eta_dt", "inEtaDt");
		this.hashFields.put("in_vsl_cd", "inVslCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("in_bl_type", "inBlType");
		this.hashFields.put("in_bl_no", "inBlNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("in_pol_cd", "inPolCd");
		this.hashFields.put("in_bl_split_no", "inBlSplitNo");
		this.hashFields.put("in_vvd_cd", "inVvdCd");
		this.hashFields.put("in_pod_cd", "inPodCd");
		this.hashFields.put("in_voyage_no", "inVoyageNo");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return inSkdVoyNo
	 */
	public String getInSkdVoyNo() {
		return this.inSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return inErrGb
	 */
	public String getInErrGb() {
		return this.inErrGb;
	}
	
	/**
	 * Column Info
	 * @return inSkdDirCd
	 */
	public String getInSkdDirCd() {
		return this.inSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return inCallSgnNo
	 */
	public String getInCallSgnNo() {
		return this.inCallSgnNo;
	}
	
	/**
	 * Column Info
	 * @return inCallInd
	 */
	public String getInCallInd() {
		return this.inCallInd;
	}
	
	/**
	 * Column Info
	 * @return inEtaDt
	 */
	public String getInEtaDt() {
		return this.inEtaDt;
	}
	
	/**
	 * Column Info
	 * @return inVslCd
	 */
	public String getInVslCd() {
		return this.inVslCd;
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
	 * @return inBlType
	 */
	public String getInBlType() {
		return this.inBlType;
	}
	
	/**
	 * Column Info
	 * @return inBlNo
	 */
	public String getInBlNo() {
		return this.inBlNo;
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
	 * @return inPolCd
	 */
	public String getInPolCd() {
		return this.inPolCd;
	}
	
	/**
	 * Column Info
	 * @return inBlSplitNo
	 */
	public String getInBlSplitNo() {
		return this.inBlSplitNo;
	}
	
	/**
	 * Column Info
	 * @return inVvdCd
	 */
	public String getInVvdCd() {
		return this.inVvdCd;
	}
	
	/**
	 * Column Info
	 * @return inPodCd
	 */
	public String getInPodCd() {
		return this.inPodCd;
	}
	

	/**
	 * Column Info
	 * @param inSkdVoyNo
	 */
	public void setInSkdVoyNo(String inSkdVoyNo) {
		this.inSkdVoyNo = inSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param inErrGb
	 */
	public void setInErrGb(String inErrGb) {
		this.inErrGb = inErrGb;
	}
	
	/**
	 * Column Info
	 * @param inSkdDirCd
	 */
	public void setInSkdDirCd(String inSkdDirCd) {
		this.inSkdDirCd = inSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param inCallSgnNo
	 */
	public void setInCallSgnNo(String inCallSgnNo) {
		this.inCallSgnNo = inCallSgnNo;
	}
	
	/**
	 * Column Info
	 * @param inCallInd
	 */
	public void setInCallInd(String inCallInd) {
		this.inCallInd = inCallInd;
	}
	
	/**
	 * Column Info
	 * @param inEtaDt
	 */
	public void setInEtaDt(String inEtaDt) {
		this.inEtaDt = inEtaDt;
	}
	
	/**
	 * Column Info
	 * @param inVslCd
	 */
	public void setInVslCd(String inVslCd) {
		this.inVslCd = inVslCd;
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
	 * @param inBlType
	 */
	public void setInBlType(String inBlType) {
		this.inBlType = inBlType;
	}
	
	/**
	 * Column Info
	 * @param inBlNo
	 */
	public void setInBlNo(String inBlNo) {
		this.inBlNo = inBlNo;
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
	 * @param inPolCd
	 */
	public void setInPolCd(String inPolCd) {
		this.inPolCd = inPolCd;
	}
	
	/**
	 * Column Info
	 * @param inBlSplitNo
	 */
	public void setInBlSplitNo(String inBlSplitNo) {
		this.inBlSplitNo = inBlSplitNo;
	}
	
	/**
	 * Column Info
	 * @param inVvdCd
	 */
	public void setInVvdCd(String inVvdCd) {
		this.inVvdCd = inVvdCd;
	}
	
	/**
	 * Column Info
	 * @param inPodCd
	 */
	public void setInPodCd(String inPodCd) {
		this.inPodCd = inPodCd;
	}
	
	public String getInVoyageNo() {
		return inVoyageNo;
	}

	public void setInVoyageNo(String inVoyageNo) {
		this.inVoyageNo = inVoyageNo;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setInSkdVoyNo(JSPUtil.getParameter(request, "in_skd_voy_no", ""));
		setInErrGb(JSPUtil.getParameter(request, "in_err_gb", ""));
		setInSkdDirCd(JSPUtil.getParameter(request, "in_skd_dir_cd", ""));
		setInCallSgnNo(JSPUtil.getParameter(request, "in_call_sgn_no", ""));
		setInCallInd(JSPUtil.getParameter(request, "in_call_ind", ""));
		setInEtaDt(JSPUtil.getParameter(request, "in_eta_dt", ""));
		setInVslCd(JSPUtil.getParameter(request, "in_vsl_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setInBlType(JSPUtil.getParameter(request, "in_bl_type", ""));
		setInBlNo(JSPUtil.getParameter(request, "in_bl_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setInPolCd(JSPUtil.getParameter(request, "in_pol_cd", ""));
		setInBlSplitNo(JSPUtil.getParameter(request, "in_bl_split_no", ""));
		setInVvdCd(JSPUtil.getParameter(request, "in_vvd_cd", ""));
		setInPodCd(JSPUtil.getParameter(request, "in_pod_cd", ""));
		setInVoyageNo(JSPUtil.getParameter(request, "in_voyage_no", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return JapanManifestListCondVO[]
	 */
	public JapanManifestListCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return JapanManifestListCondVO[]
	 */
	public JapanManifestListCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		JapanManifestListCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] inSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "in_skd_voy_no", length));
			String[] inErrGb = (JSPUtil.getParameter(request, prefix	+ "in_err_gb", length));
			String[] inSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "in_skd_dir_cd", length));
			String[] inCallSgnNo = (JSPUtil.getParameter(request, prefix	+ "in_call_sgn_no", length));
			String[] inCallInd = (JSPUtil.getParameter(request, prefix	+ "in_call_ind", length));
			String[] inEtaDt = (JSPUtil.getParameter(request, prefix	+ "in_eta_dt", length));
			String[] inVslCd = (JSPUtil.getParameter(request, prefix	+ "in_vsl_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] inBlType = (JSPUtil.getParameter(request, prefix	+ "in_bl_type", length));
			String[] inBlNo = (JSPUtil.getParameter(request, prefix	+ "in_bl_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] inPolCd = (JSPUtil.getParameter(request, prefix	+ "in_pol_cd", length));
			String[] inBlSplitNo = (JSPUtil.getParameter(request, prefix	+ "in_bl_split_no", length));
			String[] inVvdCd = (JSPUtil.getParameter(request, prefix	+ "in_vvd_cd", length));
			String[] inPodCd = (JSPUtil.getParameter(request, prefix	+ "in_pod_cd", length));
			String[] inVoyageNo = (JSPUtil.getParameter(request, prefix	+ "in_voyage_no", length));
			
			
			for (int i = 0; i < length; i++) {
				model = new JapanManifestListCondVO();
				if (inSkdVoyNo[i] != null)
					model.setInSkdVoyNo(inSkdVoyNo[i]);
				if (inErrGb[i] != null)
					model.setInErrGb(inErrGb[i]);
				if (inSkdDirCd[i] != null)
					model.setInSkdDirCd(inSkdDirCd[i]);
				if (inCallSgnNo[i] != null)
					model.setInCallSgnNo(inCallSgnNo[i]);
				if (inCallInd[i] != null)
					model.setInCallInd(inCallInd[i]);
				if (inEtaDt[i] != null)
					model.setInEtaDt(inEtaDt[i]);
				if (inVslCd[i] != null)
					model.setInVslCd(inVslCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (inBlType[i] != null)
					model.setInBlType(inBlType[i]);
				if (inBlNo[i] != null)
					model.setInBlNo(inBlNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (inPolCd[i] != null)
					model.setInPolCd(inPolCd[i]);
				if (inBlSplitNo[i] != null)
					model.setInBlSplitNo(inBlSplitNo[i]);
				if (inVvdCd[i] != null)
					model.setInVvdCd(inVvdCd[i]);
				if (inPodCd[i] != null)
					model.setInPodCd(inPodCd[i]);
				if (inVoyageNo[i] != null)
					model.setInVoyageNo(inVoyageNo[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getJapanManifestListCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return JapanManifestListCondVO[]
	 */
	public JapanManifestListCondVO[] getJapanManifestListCondVOs(){
		JapanManifestListCondVO[] vos = (JapanManifestListCondVO[])models.toArray(new JapanManifestListCondVO[models.size()]);
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
		this.inSkdVoyNo = this.inSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inErrGb = this.inErrGb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inSkdDirCd = this.inSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCallSgnNo = this.inCallSgnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCallInd = this.inCallInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inEtaDt = this.inEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVslCd = this.inVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inBlType = this.inBlType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inBlNo = this.inBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPolCd = this.inPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inBlSplitNo = this.inBlSplitNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVvdCd = this.inVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPodCd = this.inPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVoyageNo = this.inVoyageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
}

/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KrWhfDecChkVO.java
*@FileTitle : KrWhfDecChkVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.27
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.08.27 정재엽 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfDecChkVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정재엽
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KrWhfDecChkVO extends WhfDecChkVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<KrWhfDecChkVO> models = new ArrayList<KrWhfDecChkVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String gubun = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String whfNtcNo = null;
	/* Column Info */
	private String ntcAmt = null;
	/* Column Info */
	private String whfDeclNo = null;
	/* Column Info */
	private String whfNtcDt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mfRefNo = null;
	/* Column Info */
	private String sailDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String whfUsrNm = null;

	private String vvd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KrWhfDecChkVO() {}

	public KrWhfDecChkVO(String ibflag, String pagerows, String gubun, String vslCd, String skdVoyNo, String skdDirCd, 
			String portCd, String mfRefNo, String sailDt, String whfNtcDt, String whfNtcNo, String whfDeclNo, String ntcAmt, 
			String whfUsrNm, String vvd) {
		this.vslCd = vslCd;
		this.gubun = gubun;
		this.skdVoyNo = skdVoyNo;
		this.whfNtcNo = whfNtcNo;
		this.ntcAmt = ntcAmt;
		this.whfDeclNo = whfDeclNo;
		this.whfNtcDt = whfNtcDt;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.mfRefNo = mfRefNo;
		this.sailDt = sailDt;
		this.ibflag = ibflag;
		this.portCd = portCd;
		this.whfUsrNm = whfUsrNm;
		this.vvd = vvd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("gubun", getGubun());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("whf_ntc_no", getWhfNtcNo());
		this.hashColumns.put("ntc_amt", getNtcAmt());
		this.hashColumns.put("whf_decl_no", getWhfDeclNo());
		this.hashColumns.put("whf_ntc_dt", getWhfNtcDt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mf_ref_no", getMfRefNo());
		this.hashColumns.put("sail_dt", getSailDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("whf_usr_nm", getWhfUsrNm());
		this.hashColumns.put("vvd", getVvd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("gubun", "gubun");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("whf_ntc_no", "whfNtcNo");
		this.hashFields.put("ntc_amt", "ntcAmt");
		this.hashFields.put("whf_decl_no", "whfDeclNo");
		this.hashFields.put("whf_ntc_dt", "whfNtcDt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mf_ref_no", "mfRefNo");
		this.hashFields.put("sail_dt", "sailDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("whf_usr_nm", "whfUsrNm");
		this.hashFields.put("vvd", "vvd");
		return this.hashFields;
	}
	
	
	
	public String getVvd() {
		return vvd;
	}

	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @return gubun
	 */
	public String getGubun() {
		return this.gubun;
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
	 * @return whfNtcNo
	 */
	public String getWhfNtcNo() {
		return this.whfNtcNo;
	}
	
	/**
	 * Column Info
	 * @return ntcAmt
	 */
	public String getNtcAmt() {
		return this.ntcAmt;
	}
	
	/**
	 * Column Info
	 * @return whfDeclNo
	 */
	public String getWhfDeclNo() {
		return this.whfDeclNo;
	}
	
	/**
	 * Column Info
	 * @return whfNtcDt
	 */
	public String getWhfNtcDt() {
		return this.whfNtcDt;
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
	 * @return mfRefNo
	 */
	public String getMfRefNo() {
		return this.mfRefNo;
	}
	
	/**
	 * Column Info
	 * @return sailDt
	 */
	public String getSailDt() {
		return this.sailDt;
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
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return whfUsrNm
	 */
	public String getWhfUsrNm() {
		return this.whfUsrNm;
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
	 * @param gubun
	 */
	public void setGubun(String gubun) {
		this.gubun = gubun;
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
	 * @param whfNtcNo
	 */
	public void setWhfNtcNo(String whfNtcNo) {
		this.whfNtcNo = whfNtcNo;
	}
	
	/**
	 * Column Info
	 * @param ntcAmt
	 */
	public void setNtcAmt(String ntcAmt) {
		this.ntcAmt = ntcAmt;
	}
	
	/**
	 * Column Info
	 * @param whfDeclNo
	 */
	public void setWhfDeclNo(String whfDeclNo) {
		this.whfDeclNo = whfDeclNo;
	}
	
	/**
	 * Column Info
	 * @param whfNtcDt
	 */
	public void setWhfNtcDt(String whfNtcDt) {
		this.whfNtcDt = whfNtcDt;
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
	 * @param mfRefNo
	 */
	public void setMfRefNo(String mfRefNo) {
		this.mfRefNo = mfRefNo;
	}
	
	/**
	 * Column Info
	 * @param sailDt
	 */
	public void setSailDt(String sailDt) {
		this.sailDt = sailDt;
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
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param whfUsrNm
	 */
	public void setWhfUsrNm(String whfUsrNm) {
		this.whfUsrNm = whfUsrNm;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setGubun(JSPUtil.getParameter(request, "gubun", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setWhfNtcNo(JSPUtil.getParameter(request, "whf_ntc_no", ""));
		setNtcAmt(JSPUtil.getParameter(request, "ntc_amt", ""));
		setWhfDeclNo(JSPUtil.getParameter(request, "whf_decl_no", ""));
		setWhfNtcDt(JSPUtil.getParameter(request, "whf_ntc_dt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setMfRefNo(JSPUtil.getParameter(request, "mf_ref_no", ""));
		setSailDt(JSPUtil.getParameter(request, "sail_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setWhfUsrNm(JSPUtil.getParameter(request, "whf_usr_nm", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KrWhfDecChkVO[]
	 */
	public KrWhfDecChkVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KrWhfDecChkVO[]
	 */
	public KrWhfDecChkVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KrWhfDecChkVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] gubun = (JSPUtil.getParameter(request, prefix	+ "gubun", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] whfNtcNo = (JSPUtil.getParameter(request, prefix	+ "whf_ntc_no", length));
			String[] ntcAmt = (JSPUtil.getParameter(request, prefix	+ "ntc_amt", length));
			String[] whfDeclNo = (JSPUtil.getParameter(request, prefix	+ "whf_decl_no", length));
			String[] whfNtcDt = (JSPUtil.getParameter(request, prefix	+ "whf_ntc_dt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mfRefNo = (JSPUtil.getParameter(request, prefix	+ "mf_ref_no", length));
			String[] sailDt = (JSPUtil.getParameter(request, prefix	+ "sail_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] whfUsrNm = (JSPUtil.getParameter(request, prefix	+ "whf_usr_nm", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			
			for (int i = 0; i < length; i++) {
				model = new KrWhfDecChkVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (gubun[i] != null)
					model.setGubun(gubun[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (whfNtcNo[i] != null)
					model.setWhfNtcNo(whfNtcNo[i]);
				if (ntcAmt[i] != null)
					model.setNtcAmt(ntcAmt[i]);
				if (whfDeclNo[i] != null)
					model.setWhfDeclNo(whfDeclNo[i]);
				if (whfNtcDt[i] != null)
					model.setWhfNtcDt(whfNtcDt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mfRefNo[i] != null)
					model.setMfRefNo(mfRefNo[i]);
				if (sailDt[i] != null)
					model.setSailDt(sailDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (whfUsrNm[i] != null)
					model.setWhfUsrNm(whfUsrNm[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKrWhfDecChkVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KrWhfDecChkVO[]
	 */
	public KrWhfDecChkVO[] getKrWhfDecChkVOs(){
		KrWhfDecChkVO[] vos = (KrWhfDecChkVO[])models.toArray(new KrWhfDecChkVO[models.size()]);
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
		this.gubun = this.gubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfNtcNo = this.whfNtcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcAmt = this.ntcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfDeclNo = this.whfDeclNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfNtcDt = this.whfNtcDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfRefNo = this.mfRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailDt = this.sailDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfUsrNm = this.whfUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

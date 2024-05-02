/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TaaInformInVO.java
*@FileTitle : TaaInformInVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.03
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2009.07.06 김태경
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo;

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
 * @author 이진서
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TaaInformInVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<TaaInformInVO> models = new ArrayList<TaaInformInVO>();

	/* Column Info */
	private String startDate = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String taaNo = null;
	/* Column Info */
	private String endDate = null;
	/* Page Number */
	private String pagerows = null;
	/* Ctrt Type Cd */
	private String ctrtTpCd = null;
	/* rt aply dt*/
	private String rtAplyDt = null;
	/* Column Info */
	private String caFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public TaaInformInVO() {}

	public TaaInformInVO(String ibflag, String pagerows, String bkgNo, String taaNo, String startDate, String endDate, String ctrtTpCd, String rtAplyDt, String caFlg) {
		this.startDate = startDate;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.taaNo = taaNo;
		this.endDate = endDate;
		this.pagerows = pagerows;
		this.ctrtTpCd = ctrtTpCd;
		this.rtAplyDt = rtAplyDt;
		this.caFlg = caFlg;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("start_date", getStartDate());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("taa_no", getTaaNo());
		this.hashColumns.put("end_date", getEndDate());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ctrtTpCd", getCtrtTpCd());
		this.hashColumns.put("rt_aply_dt", getRtAplyDt());
		this.hashColumns.put("ca_flg", getCaFlg());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("start_date", "startDate");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("taa_no", "taaNo");
		this.hashFields.put("end_date", "endDate");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ctrtTpCd", "ctrtTpCd");
		this.hashFields.put("rt_aply_dt","rtAplyDt");
		this.hashFields.put("ca_flg","caFlg");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getCtrtTpCd() {
		return this.ctrtTpCd;
	}
	
	/**
	 * Column Info
	 * @return caFlg
	 */
	public String getCaFlg() {
		return this.caFlg;
	}
	
	/**
	 * Column Info
	 * @return startDate
	 */
	public String getStartDate() {
		return this.startDate;
	}

	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return taaNo
	 */
	public String getTaaNo() {
		return this.taaNo;
	}

	/**
	 * Column Info
	 * @return endDate
	 */
	public String getEndDate() {
		return this.endDate;
	}

	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Page Number
	 * @return RtAplyDt
	 */
	public String getRtAplyDt() {
		return this.rtAplyDt;
	}

	/**
	 * Column Info
	 * @param startDate
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	/**
	 * Column Info
	 * @param caFlg
	 */
	public void setCaFlg(String caFlg) {
		this.caFlg = caFlg;
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
	 * @param taaNo
	 */
	public void setTaaNo(String taaNo) {
		this.taaNo = taaNo;
	}

	/**
	 * Column Info
	 * @param endDate
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setCtrtTpCd(String ctrtTpCd) {
		this.ctrtTpCd = ctrtTpCd;
	}
	
	/**
	 * Page Number
	 * @param RtAplyDt
	 */
	public void setRtAplyDt(String rtAplyDt) {
		this.rtAplyDt = rtAplyDt;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setStartDate(JSPUtil.getParameter(request, "start_date", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTaaNo(JSPUtil.getParameter(request, "taa_no", ""));
		setEndDate(JSPUtil.getParameter(request, "end_date", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCtrtTpCd(JSPUtil.getParameter(request, "ctrtTpCd",""));
		setRtAplyDt(JSPUtil.getParameter(request, "rtAplyDt",""));
		setCaFlg(JSPUtil.getParameter(request, "ca_flg",""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TaaInformInVO[]
	 */
	public TaaInformInVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return TaaInformInVO[]
	 */
	public TaaInformInVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TaaInformInVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] startDate = (JSPUtil.getParameter(request, prefix	+ "start_date", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] taaNo = (JSPUtil.getParameter(request, prefix	+ "taa_no", length));
			String[] endDate = (JSPUtil.getParameter(request, prefix	+ "end_date", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ctrtTpCd = (JSPUtil.getParameter(request, prefix	+ "ctrtTpCd", length));
			String[] rtAplyDt = (JSPUtil.getParameter(request, prefix	+ "rtAplyDt", length));
			String[] caFlg = (JSPUtil.getParameter(request, prefix	+ "ca_flg", length));

			for (int i = 0; i < length; i++) {
				model = new TaaInformInVO();
				if (startDate[i] != null)
					model.setStartDate(startDate[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (taaNo[i] != null)
					model.setTaaNo(taaNo[i]);
				if (endDate[i] != null)
					model.setEndDate(endDate[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ctrtTpCd[i] != null)
					model.setCtrtTpCd(ctrtTpCd[i]);
				if (rtAplyDt[i] != null)
					model.setRtAplyDt(rtAplyDt[i]);
				if (caFlg[i] != null)
					model.setCaFlg(caFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTaaInformInVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TaaInformInVO[]
	 */
	public TaaInformInVO[] getTaaInformInVOs(){
		TaaInformInVO[] vos = (TaaInformInVO[])models.toArray(new TaaInformInVO[models.size()]);
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
		this.startDate = this.startDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taaNo = this.taaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endDate = this.endDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtTpCd = this.ctrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAplyDt = this.rtAplyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caFlg = this.caFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MovementParmVO.java
*@FileTitle : MovementParmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.07.07 최성환 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo;

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
 * @author 최성환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MovementParmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MovementParmVO> models = new ArrayList<MovementParmVO>();
	
	/* Column Info */
	private String cnmsCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cnmvCycNo = null;
	/* Column Info */
	private String cnmvYy = null;
	/* Column Info */
	private String cnmvSplit = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String bkgNoSplit = null;
	/* Column Info */
	private String cnmvSeq = null;
	/* Column Info */
	private String cntrNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MovementParmVO() {}

	public MovementParmVO(String ibflag, String pagerows, String cntrNo, String cnmvYy, String cnmvSeq, String cnmvSplit, String cnmvCycNo, String cnmsCd, String ydCd, String bkgNo, String bkgNoSplit) {
		this.cnmsCd = cnmsCd;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.cnmvCycNo = cnmvCycNo;
		this.cnmvYy = cnmvYy;
		this.cnmvSplit = cnmvSplit;
		this.ydCd = ydCd;
		this.bkgNoSplit = bkgNoSplit;
		this.cnmvSeq = cnmvSeq;
		this.cntrNo = cntrNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cnms_cd", getCnmsCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnmv_cyc_no", getCnmvCycNo());
		this.hashColumns.put("cnmv_yy", getCnmvYy());
		this.hashColumns.put("cnmv_split", getCnmvSplit());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("bkg_no_split", getBkgNoSplit());
		this.hashColumns.put("cnmv_seq", getCnmvSeq());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cnms_cd", "cnmsCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnmv_cyc_no", "cnmvCycNo");
		this.hashFields.put("cnmv_yy", "cnmvYy");
		this.hashFields.put("cnmv_split", "cnmvSplit");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("bkg_no_split", "bkgNoSplit");
		this.hashFields.put("cnmv_seq", "cnmvSeq");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cnmsCd
	 */
	public String getCnmsCd() {
		return this.cnmsCd;
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
	 * @return cnmvCycNo
	 */
	public String getCnmvCycNo() {
		return this.cnmvCycNo;
	}
	
	/**
	 * Column Info
	 * @return cnmvYy
	 */
	public String getCnmvYy() {
		return this.cnmvYy;
	}
	
	/**
	 * Column Info
	 * @return cnmvSplit
	 */
	public String getCnmvSplit() {
		return this.cnmvSplit;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return bkgNoSplit
	 */
	public String getBkgNoSplit() {
		return this.bkgNoSplit;
	}
	
	/**
	 * Column Info
	 * @return cnmvSeq
	 */
	public String getCnmvSeq() {
		return this.cnmvSeq;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
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
	 * @param cnmsCd
	 */
	public void setCnmsCd(String cnmsCd) {
		this.cnmsCd = cnmsCd;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param cnmvCycNo
	 */
	public void setCnmvCycNo(String cnmvCycNo) {
		this.cnmvCycNo = cnmvCycNo;
	}
	
	/**
	 * Column Info
	 * @param cnmvYy
	 */
	public void setCnmvYy(String cnmvYy) {
		this.cnmvYy = cnmvYy;
	}
	
	/**
	 * Column Info
	 * @param cnmvSplit
	 */
	public void setCnmvSplit(String cnmvSplit) {
		this.cnmvSplit = cnmvSplit;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param bkgNoSplit
	 */
	public void setBkgNoSplit(String bkgNoSplit) {
		this.bkgNoSplit = bkgNoSplit;
	}
	
	/**
	 * Column Info
	 * @param cnmvSeq
	 */
	public void setCnmvSeq(String cnmvSeq) {
		this.cnmvSeq = cnmvSeq;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
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
		setCnmsCd(JSPUtil.getParameter(request, "cnms_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCnmvCycNo(JSPUtil.getParameter(request, "cnmv_cyc_no", ""));
		setCnmvYy(JSPUtil.getParameter(request, "cnmv_yy", ""));
		setCnmvSplit(JSPUtil.getParameter(request, "cnmv_split", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setBkgNoSplit(JSPUtil.getParameter(request, "bkg_no_split", ""));
		setCnmvSeq(JSPUtil.getParameter(request, "cnmv_seq", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MovementParmVO[]
	 */
	public MovementParmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MovementParmVO[]
	 */
	public MovementParmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MovementParmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cnmsCd = (JSPUtil.getParameter(request, prefix	+ "cnms_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cnmvCycNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_cyc_no", length));
			String[] cnmvYy = (JSPUtil.getParameter(request, prefix	+ "cnmv_yy", length));
			String[] cnmvSplit = (JSPUtil.getParameter(request, prefix	+ "cnmv_split", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] bkgNoSplit = (JSPUtil.getParameter(request, prefix	+ "bkg_no_split", length));
			String[] cnmvSeq = (JSPUtil.getParameter(request, prefix	+ "cnmv_seq", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new MovementParmVO();
				if (cnmsCd[i] != null)
					model.setCnmsCd(cnmsCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cnmvCycNo[i] != null)
					model.setCnmvCycNo(cnmvCycNo[i]);
				if (cnmvYy[i] != null)
					model.setCnmvYy(cnmvYy[i]);
				if (cnmvSplit[i] != null)
					model.setCnmvSplit(cnmvSplit[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (bkgNoSplit[i] != null)
					model.setBkgNoSplit(bkgNoSplit[i]);
				if (cnmvSeq[i] != null)
					model.setCnmvSeq(cnmvSeq[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMovementParmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MovementParmVO[]
	 */
	public MovementParmVO[] getMovementParmVOs(){
		MovementParmVO[] vos = (MovementParmVO[])models.toArray(new MovementParmVO[models.size()]);
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
		this.cnmsCd = this.cnmsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvCycNo = this.cnmvCycNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvYy = this.cnmvYy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvSplit = this.cnmvSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNoSplit = this.bkgNoSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvSeq = this.cnmvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

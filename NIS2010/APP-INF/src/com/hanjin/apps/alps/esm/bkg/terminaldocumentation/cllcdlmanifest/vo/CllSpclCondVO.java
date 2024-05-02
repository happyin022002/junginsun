/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CllSpclCondVO.java
*@FileTitle : CllSpclCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.16
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.09.16 김승민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo;

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
 * @author 김승민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CllSpclCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CllSpclCondVO> models = new ArrayList<CllSpclCondVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String inCntrLodgNo = null;
	/* Column Info */
	private String inSkdVoyNo = null;
	/* Column Info */
	private String inSkdDirCd = null;
	/* Column Info */
	private String inVslCd = null;
	/* Column Info */
	private String inBkgNo = null;
	/* Column Info */
	private String inPortCd = null;
	/* Column Info */
	private String inCntrNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Page Number */
	private String inRcSeq = null;
	/* Page Number */
	private String inAwkCgoSeq = null;
	/* Column Info */
	private String polSplitNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CllSpclCondVO() {}

	public CllSpclCondVO(String ibflag, String pagerows, String inVslCd, String inSkdVoyNo, String inSkdDirCd, String inPortCd, String inBkgNo, String inCntrNo, String inCntrLodgNo, String inRcSeq, String inAwkCgoSeq, String polSplitNo) {
		this.ibflag = ibflag;
		this.inCntrLodgNo = inCntrLodgNo;
		this.inSkdVoyNo = inSkdVoyNo;
		this.inSkdDirCd = inSkdDirCd;
		this.inVslCd = inVslCd;
		this.inBkgNo = inBkgNo;
		this.inPortCd = inPortCd;
		this.inCntrNo = inCntrNo;
		this.pagerows = pagerows;
		this.inRcSeq = inRcSeq;
		this.inAwkCgoSeq = inAwkCgoSeq;
		this.polSplitNo = polSplitNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("in_cntr_lodg_no", getInCntrLodgNo());
		this.hashColumns.put("in_skd_voy_no", getInSkdVoyNo());
		this.hashColumns.put("in_skd_dir_cd", getInSkdDirCd());
		this.hashColumns.put("in_vsl_cd", getInVslCd());
		this.hashColumns.put("in_bkg_no", getInBkgNo());
		this.hashColumns.put("in_port_cd", getInPortCd());
		this.hashColumns.put("in_cntr_no", getInCntrNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("in_rc_seq", getInRcSeq());
		this.hashColumns.put("in_awk_cgo_seq", getInAwkCgoSeq());
		this.hashColumns.put("pol_split_no", getPolSplitNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("in_cntr_lodg_no", "inCntrLodgNo");
		this.hashFields.put("in_skd_voy_no", "inSkdVoyNo");
		this.hashFields.put("in_skd_dir_cd", "inSkdDirCd");
		this.hashFields.put("in_vsl_cd", "inVslCd");
		this.hashFields.put("in_bkg_no", "inBkgNo");
		this.hashFields.put("in_port_cd", "inPortCd");
		this.hashFields.put("in_cntr_no", "inCntrNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("in_rc_seq", "inRcSeq");
		this.hashFields.put("in_awk_cgo_seq", "inAwkCgoSeq");
		this.hashFields.put("pol_split_no", "polSplitNo");
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
	 * @return inCntrLodgNo
	 */
	public String getInCntrLodgNo() {
		return this.inCntrLodgNo;
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
	 * @return inSkdDirCd
	 */
	public String getInSkdDirCd() {
		return this.inSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return inVslCd
	 */
	public String getInVslCd() {
		return this.inVslCd;
	}
	
	/**
	 * Column Info
	 * @return inBkgNo
	 */
	public String getInBkgNo() {
		return this.inBkgNo;
	}
	
	/**
	 * Column Info
	 * @return inPortCd
	 */
	public String getInPortCd() {
		return this.inPortCd;
	}
	
	/**
	 * Column Info
	 * @return inCntrNo
	 */
	public String getInCntrNo() {
		return this.inCntrNo;
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
	 * @return polSplitNo
	 */
	public String getPolSplitNo() {
		return this.polSplitNo;
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
	 * @param inCntrLodgNo
	 */
	public void setInCntrLodgNo(String inCntrLodgNo) {
		this.inCntrLodgNo = inCntrLodgNo;
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
	 * @param inSkdDirCd
	 */
	public void setInSkdDirCd(String inSkdDirCd) {
		this.inSkdDirCd = inSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param inVslCd
	 */
	public void setInVslCd(String inVslCd) {
		this.inVslCd = inVslCd;
	}
	
	/**
	 * Column Info
	 * @param inBkgNo
	 */
	public void setInBkgNo(String inBkgNo) {
		this.inBkgNo = inBkgNo;
	}
	
	/**
	 * Column Info
	 * @param inPortCd
	 */
	public void setInPortCd(String inPortCd) {
		this.inPortCd = inPortCd;
	}
	
	/**
	 * Column Info
	 * @param inCntrNo
	 */
	public void setInCntrNo(String inCntrNo) {
		this.inCntrNo = inCntrNo;
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
	 * @param polSplitNo
	 */
	public void setPolSplitNo(String polSplitNo) {
		this.polSplitNo = polSplitNo;
	}
	
	public Collection<CllSpclCondVO> getModels() {
		return models;
	}

	public void setModels(Collection<CllSpclCondVO> models) {
		this.models = models;
	}

	public String getInRcSeq() {
		return inRcSeq;
	}

	public void setInRcSeq(String inRcSeq) {
		this.inRcSeq = inRcSeq;
	}

	public String getInAwkCgoSeq() {
		return inAwkCgoSeq;
	}

	public void setInAwkCgoSeq(String inAwkCgoSeq) {
		this.inAwkCgoSeq = inAwkCgoSeq;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setInCntrLodgNo(JSPUtil.getParameter(request, "in_cntr_lodg_no", ""));
		setInSkdVoyNo(JSPUtil.getParameter(request, "in_skd_voy_no", ""));
		setInSkdDirCd(JSPUtil.getParameter(request, "in_skd_dir_cd", ""));
		setInVslCd(JSPUtil.getParameter(request, "in_vsl_cd", ""));
		setInBkgNo(JSPUtil.getParameter(request, "in_bkg_no", ""));
		setInPortCd(JSPUtil.getParameter(request, "in_port_cd", ""));
		setInCntrNo(JSPUtil.getParameter(request, "in_cntr_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setInRcSeq(JSPUtil.getParameter(request, "in_rc_seq", ""));
		setInAwkCgoSeq(JSPUtil.getParameter(request, "in_awk_cgo_seq", ""));
		setPolSplitNo(JSPUtil.getParameter(request, "pol_split_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CllSpclCondVO[]
	 */
	public CllSpclCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CllSpclCondVO[]
	 */
	public CllSpclCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CllSpclCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] inCntrLodgNo = (JSPUtil.getParameter(request, prefix	+ "in_cntr_lodg_no", length));
			String[] inSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "in_skd_voy_no", length));
			String[] inSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "in_skd_dir_cd", length));
			String[] inVslCd = (JSPUtil.getParameter(request, prefix	+ "in_vsl_cd", length));
			String[] inBkgNo = (JSPUtil.getParameter(request, prefix	+ "in_bkg_no", length));
			String[] inPortCd = (JSPUtil.getParameter(request, prefix	+ "in_port_cd", length));
			String[] inCntrNo = (JSPUtil.getParameter(request, prefix	+ "in_cntr_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] inRcSeq = (JSPUtil.getParameter(request, prefix	+ "in_rc_seq", length));
			String[] inAwkCgoSeq = (JSPUtil.getParameter(request, prefix	+ "in_awk_cgo_seq", length));
			String[] polSplitNo = (JSPUtil.getParameter(request, prefix	+ "pol_split_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new CllSpclCondVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (inCntrLodgNo[i] != null)
					model.setInCntrLodgNo(inCntrLodgNo[i]);
				if (inSkdVoyNo[i] != null)
					model.setInSkdVoyNo(inSkdVoyNo[i]);
				if (inSkdDirCd[i] != null)
					model.setInSkdDirCd(inSkdDirCd[i]);
				if (inVslCd[i] != null)
					model.setInVslCd(inVslCd[i]);
				if (inBkgNo[i] != null)
					model.setInBkgNo(inBkgNo[i]);
				if (inPortCd[i] != null)
					model.setInPortCd(inPortCd[i]);
				if (inCntrNo[i] != null)
					model.setInCntrNo(inCntrNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (inRcSeq[i] != null)
					model.setInRcSeq(inRcSeq[i]);
				if (inAwkCgoSeq[i] != null)
					model.setInAwkCgoSeq(inAwkCgoSeq[i]);
				if (polSplitNo[i] != null)
					model.setPolSplitNo(polSplitNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCllSpclCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CllSpclCondVO[]
	 */
	public CllSpclCondVO[] getCllSpclCondVOs(){
		CllSpclCondVO[] vos = (CllSpclCondVO[])models.toArray(new CllSpclCondVO[models.size()]);
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
		this.inCntrLodgNo = this.inCntrLodgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inSkdVoyNo = this.inSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inSkdDirCd = this.inSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVslCd = this.inVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inBkgNo = this.inBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPortCd = this.inPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCntrNo = this.inCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inRcSeq = this.inRcSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inAwkCgoSeq = this.inAwkCgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polSplitNo = this.polSplitNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

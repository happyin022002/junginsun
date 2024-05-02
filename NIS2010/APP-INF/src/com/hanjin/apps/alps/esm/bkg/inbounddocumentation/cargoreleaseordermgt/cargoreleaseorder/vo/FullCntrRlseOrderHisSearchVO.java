/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FullCntrRlseOrderHisSearchVO.java
*@FileTitle : FullCntrRlseOrderHisSearchVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.08.20 손윤석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

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
 * @author 손윤석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FullCntrRlseOrderHisSearchVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FullCntrRlseOrderHisSearchVO> models = new ArrayList<FullCntrRlseOrderHisSearchVO>();
	
	/* Column Info */
	private String inVvd = null;
	/* Column Info */
	private String inBlNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String inYdCd = null;
	/* Column Info */
	private String fRad = null;
	/* Column Info */
	private String inCreDtFrom = null;
	/* Column Info */
	private String inPodCd = null;
	/* Column Info */
	private String inCreDtTo = null;
	/* Column Info */
	private String fMode = null;
	/* Column Info */
	private String inCntrNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FullCntrRlseOrderHisSearchVO() {}

	public FullCntrRlseOrderHisSearchVO(String ibflag, String pagerows, String inBlNo, String inVvd, String fRad, String fMode, String inYdCd, String inPodCd, String inCreDtFrom, String inCreDtTo, String inCntrNo) {
		this.inVvd = inVvd;
		this.inBlNo = inBlNo;
		this.ibflag = ibflag;
		this.inYdCd = inYdCd;
		this.fRad = fRad;
		this.inCreDtFrom = inCreDtFrom;
		this.inPodCd = inPodCd;
		this.inCreDtTo = inCreDtTo;
		this.fMode = fMode;
		this.inCntrNo = inCntrNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("in_vvd", getInVvd());
		this.hashColumns.put("in_bl_no", getInBlNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("in_yd_cd", getInYdCd());
		this.hashColumns.put("f_rad", getFRad());
		this.hashColumns.put("in_cre_dt_from", getInCreDtFrom());
		this.hashColumns.put("in_pod_cd", getInPodCd());
		this.hashColumns.put("in_cre_dt_to", getInCreDtTo());
		this.hashColumns.put("f_mode", getFMode());
		this.hashColumns.put("in_cntr_no", getInCntrNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("in_vvd", "inVvd");
		this.hashFields.put("in_bl_no", "inBlNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("in_yd_cd", "inYdCd");
		this.hashFields.put("f_rad", "fRad");
		this.hashFields.put("in_cre_dt_from", "inCreDtFrom");
		this.hashFields.put("in_pod_cd", "inPodCd");
		this.hashFields.put("in_cre_dt_to", "inCreDtTo");
		this.hashFields.put("f_mode", "fMode");
		this.hashFields.put("in_cntr_no", "inCntrNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return inVvd
	 */
	public String getInVvd() {
		return this.inVvd;
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
	 * @return inYdCd
	 */
	public String getInYdCd() {
		return this.inYdCd;
	}
	
	/**
	 * Column Info
	 * @return fRad
	 */
	public String getFRad() {
		return this.fRad;
	}
	
	/**
	 * Column Info
	 * @return inCreDtFrom
	 */
	public String getInCreDtFrom() {
		return this.inCreDtFrom;
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
	 * @return inCreDtTo
	 */
	public String getInCreDtTo() {
		return this.inCreDtTo;
	}
	
	/**
	 * Column Info
	 * @return fMode
	 */
	public String getFMode() {
		return this.fMode;
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
	 * @param inVvd
	 */
	public void setInVvd(String inVvd) {
		this.inVvd = inVvd;
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
	 * @param inYdCd
	 */
	public void setInYdCd(String inYdCd) {
		this.inYdCd = inYdCd;
	}
	
	/**
	 * Column Info
	 * @param fRad
	 */
	public void setFRad(String fRad) {
		this.fRad = fRad;
	}
	
	/**
	 * Column Info
	 * @param inCreDtFrom
	 */
	public void setInCreDtFrom(String inCreDtFrom) {
		this.inCreDtFrom = inCreDtFrom;
	}
	
	/**
	 * Column Info
	 * @param inPodCd
	 */
	public void setInPodCd(String inPodCd) {
		this.inPodCd = inPodCd;
	}
	
	/**
	 * Column Info
	 * @param inCreDtTo
	 */
	public void setInCreDtTo(String inCreDtTo) {
		this.inCreDtTo = inCreDtTo;
	}
	
	/**
	 * Column Info
	 * @param fMode
	 */
	public void setFMode(String fMode) {
		this.fMode = fMode;
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
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setInVvd(JSPUtil.getParameter(request, "in_vvd", ""));
		setInBlNo(JSPUtil.getParameter(request, "in_bl_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setInYdCd(JSPUtil.getParameter(request, "in_yd_cd", ""));
		setFRad(JSPUtil.getParameter(request, "f_rad", ""));
		setInCreDtFrom(JSPUtil.getParameter(request, "in_cre_dt_from", ""));
		setInPodCd(JSPUtil.getParameter(request, "in_pod_cd", ""));
		setInCreDtTo(JSPUtil.getParameter(request, "in_cre_dt_to", ""));
		setFMode(JSPUtil.getParameter(request, "f_mode", ""));
		setInCntrNo(JSPUtil.getParameter(request, "in_cntr_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FullCntrRlseOrderHisSearchVO[]
	 */
	public FullCntrRlseOrderHisSearchVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FullCntrRlseOrderHisSearchVO[]
	 */
	public FullCntrRlseOrderHisSearchVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FullCntrRlseOrderHisSearchVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] inVvd = (JSPUtil.getParameter(request, prefix	+ "in_vvd", length));
			String[] inBlNo = (JSPUtil.getParameter(request, prefix	+ "in_bl_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] inYdCd = (JSPUtil.getParameter(request, prefix	+ "in_yd_cd", length));
			String[] fRad = (JSPUtil.getParameter(request, prefix	+ "f_rad", length));
			String[] inCreDtFrom = (JSPUtil.getParameter(request, prefix	+ "in_cre_dt_from", length));
			String[] inPodCd = (JSPUtil.getParameter(request, prefix	+ "in_pod_cd", length));
			String[] inCreDtTo = (JSPUtil.getParameter(request, prefix	+ "in_cre_dt_to", length));
			String[] fMode = (JSPUtil.getParameter(request, prefix	+ "f_mode", length));
			String[] inCntrNo = (JSPUtil.getParameter(request, prefix	+ "in_cntr_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new FullCntrRlseOrderHisSearchVO();
				if (inVvd[i] != null)
					model.setInVvd(inVvd[i]);
				if (inBlNo[i] != null)
					model.setInBlNo(inBlNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (inYdCd[i] != null)
					model.setInYdCd(inYdCd[i]);
				if (fRad[i] != null)
					model.setFRad(fRad[i]);
				if (inCreDtFrom[i] != null)
					model.setInCreDtFrom(inCreDtFrom[i]);
				if (inPodCd[i] != null)
					model.setInPodCd(inPodCd[i]);
				if (inCreDtTo[i] != null)
					model.setInCreDtTo(inCreDtTo[i]);
				if (fMode[i] != null)
					model.setFMode(fMode[i]);
				if (inCntrNo[i] != null)
					model.setInCntrNo(inCntrNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFullCntrRlseOrderHisSearchVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FullCntrRlseOrderHisSearchVO[]
	 */
	public FullCntrRlseOrderHisSearchVO[] getFullCntrRlseOrderHisSearchVOs(){
		FullCntrRlseOrderHisSearchVO[] vos = (FullCntrRlseOrderHisSearchVO[])models.toArray(new FullCntrRlseOrderHisSearchVO[models.size()]);
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
		this.inVvd = this.inVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inBlNo = this.inBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inYdCd = this.inYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRad = this.fRad .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCreDtFrom = this.inCreDtFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPodCd = this.inPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCreDtTo = this.inCreDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fMode = this.fMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCntrNo = this.inCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

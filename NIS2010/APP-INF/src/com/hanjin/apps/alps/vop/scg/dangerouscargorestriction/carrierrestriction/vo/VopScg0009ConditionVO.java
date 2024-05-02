/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg0009ConditionVO.java
*@FileTitle : VopScg0009ConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.21
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.06.21 장강철 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.vo;

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
 * @author 장강철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VopScg0009ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VopScg0009ConditionVO> models = new ArrayList<VopScg0009ConditionVO>();
	
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String grpCd = null;
	/* Column Info */
	private String imdgTekNmCheck = null;
	/* Column Info */
	private String imdgClssCdDesc = null;
	/* Column Info */
	private String crrFullNm = null;
	/* Column Info */
	private String imdgUnNoSeq = null;
	/* Column Info */
	private String optclass = null;
	/* Column Info */
	private String prpShpNm = null;
	/* Column Info */
	private String imdgClssCd = null;
	/* Column Info */
	private String crrCd = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VopScg0009ConditionVO() {}

	public VopScg0009ConditionVO(String ibflag, String pagerows, String grpCd, String imdgUnNoSeq, String imdgClssCdDesc, String prpShpNm, String crrFullNm, String imdgUnNo, String crrCd, String optclass, String imdgClssCd, String imdgTekNmCheck) {
		this.ibflag = ibflag;
		this.grpCd = grpCd;
		this.imdgTekNmCheck = imdgTekNmCheck;
		this.imdgClssCdDesc = imdgClssCdDesc;
		this.crrFullNm = crrFullNm;
		this.imdgUnNoSeq = imdgUnNoSeq;
		this.optclass = optclass;
		this.prpShpNm = prpShpNm;
		this.imdgClssCd = imdgClssCd;
		this.crrCd = crrCd;
		this.imdgUnNo = imdgUnNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("grp_cd", getGrpCd());
		this.hashColumns.put("imdg_tek_nm_check", getImdgTekNmCheck());
		this.hashColumns.put("imdg_clss_cd_desc", getImdgClssCdDesc());
		this.hashColumns.put("crr_full_nm", getCrrFullNm());
		this.hashColumns.put("imdg_un_no_seq", getImdgUnNoSeq());
		this.hashColumns.put("optclass", getOptclass());
		this.hashColumns.put("prp_shp_nm", getPrpShpNm());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("grp_cd", "grpCd");
		this.hashFields.put("imdg_tek_nm_check", "imdgTekNmCheck");
		this.hashFields.put("imdg_clss_cd_desc", "imdgClssCdDesc");
		this.hashFields.put("crr_full_nm", "crrFullNm");
		this.hashFields.put("imdg_un_no_seq", "imdgUnNoSeq");
		this.hashFields.put("optclass", "optclass");
		this.hashFields.put("prp_shp_nm", "prpShpNm");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Status
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return grpCd
	 */
	public String getGrpCd() {
		return this.grpCd;
	}
	
	/**
	 * Column Info
	 * @return imdgTekNmCheck
	 */
	public String getImdgTekNmCheck() {
		return this.imdgTekNmCheck;
	}
	
	/**
	 * Column Info
	 * @return imdgClssCdDesc
	 */
	public String getImdgClssCdDesc() {
		return this.imdgClssCdDesc;
	}
	
	/**
	 * Column Info
	 * @return crrFullNm
	 */
	public String getCrrFullNm() {
		return this.crrFullNm;
	}
	
	/**
	 * Column Info
	 * @return imdgUnNoSeq
	 */
	public String getImdgUnNoSeq() {
		return this.imdgUnNoSeq;
	}
	
	/**
	 * Column Info
	 * @return optclass
	 */
	public String getOptclass() {
		return this.optclass;
	}
	
	/**
	 * Column Info
	 * @return prpShpNm
	 */
	public String getPrpShpNm() {
		return this.prpShpNm;
	}
	
	/**
	 * Column Info
	 * @return imdgClssCd
	 */
	public String getImdgClssCd() {
		return this.imdgClssCd;
	}
	
	/**
	 * Column Info
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
	}
	
	/**
	 * Column Info
	 * @return imdgUnNo
	 */
	public String getImdgUnNo() {
		return this.imdgUnNo;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	

	/**
	 * Status
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param grpCd
	 */
	public void setGrpCd(String grpCd) {
		this.grpCd = grpCd;
	}
	
	/**
	 * Column Info
	 * @param imdgTekNmCheck
	 */
	public void setImdgTekNmCheck(String imdgTekNmCheck) {
		this.imdgTekNmCheck = imdgTekNmCheck;
	}
	
	/**
	 * Column Info
	 * @param imdgClssCdDesc
	 */
	public void setImdgClssCdDesc(String imdgClssCdDesc) {
		this.imdgClssCdDesc = imdgClssCdDesc;
	}
	
	/**
	 * Column Info
	 * @param crrFullNm
	 */
	public void setCrrFullNm(String crrFullNm) {
		this.crrFullNm = crrFullNm;
	}
	
	/**
	 * Column Info
	 * @param imdgUnNoSeq
	 */
	public void setImdgUnNoSeq(String imdgUnNoSeq) {
		this.imdgUnNoSeq = imdgUnNoSeq;
	}
	
	/**
	 * Column Info
	 * @param optclass
	 */
	public void setOptclass(String optclass) {
		this.optclass = optclass;
	}
	
	/**
	 * Column Info
	 * @param prpShpNm
	 */
	public void setPrpShpNm(String prpShpNm) {
		this.prpShpNm = prpShpNm;
	}
	
	/**
	 * Column Info
	 * @param imdgClssCd
	 */
	public void setImdgClssCd(String imdgClssCd) {
		this.imdgClssCd = imdgClssCd;
	}
	
	/**
	 * Column Info
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
	}
	
	/**
	 * Column Info
	 * @param imdgUnNo
	 */
	public void setImdgUnNo(String imdgUnNo) {
		this.imdgUnNo = imdgUnNo;
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
		setGrpCd(JSPUtil.getParameter(request, "grp_cd", ""));
		setImdgTekNmCheck(JSPUtil.getParameter(request, "imdg_tek_nm_check", ""));
		setImdgClssCdDesc(JSPUtil.getParameter(request, "imdg_clss_cd_desc", ""));
		setCrrFullNm(JSPUtil.getParameter(request, "crr_full_nm", ""));
		setImdgUnNoSeq(JSPUtil.getParameter(request, "imdg_un_no_seq", ""));
		setOptclass(JSPUtil.getParameter(request, "optclass", ""));
		setPrpShpNm(JSPUtil.getParameter(request, "prp_shp_nm", ""));
		setImdgClssCd(JSPUtil.getParameter(request, "imdg_clss_cd", ""));
		setCrrCd(JSPUtil.getParameter(request, "crr_cd", ""));
		setImdgUnNo(JSPUtil.getParameter(request, "imdg_un_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VopScg0009ConditionVO[]
	 */
	public VopScg0009ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VopScg0009ConditionVO[]
	 */
	public VopScg0009ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VopScg0009ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] grpCd = (JSPUtil.getParameter(request, prefix	+ "grp_cd".trim(), length));
			String[] imdgTekNmCheck = (JSPUtil.getParameter(request, prefix	+ "imdg_tek_nm_check".trim(), length));
			String[] imdgClssCdDesc = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd_desc".trim(), length));
			String[] crrFullNm = (JSPUtil.getParameter(request, prefix	+ "crr_full_nm".trim(), length));
			String[] imdgUnNoSeq = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no_seq".trim(), length));
			String[] optclass = (JSPUtil.getParameter(request, prefix	+ "optclass".trim(), length));
			String[] prpShpNm = (JSPUtil.getParameter(request, prefix	+ "prp_shp_nm".trim(), length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd".trim(), length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd".trim(), length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new VopScg0009ConditionVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (grpCd[i] != null)
					model.setGrpCd(grpCd[i]);
				if (imdgTekNmCheck[i] != null)
					model.setImdgTekNmCheck(imdgTekNmCheck[i]);
				if (imdgClssCdDesc[i] != null)
					model.setImdgClssCdDesc(imdgClssCdDesc[i]);
				if (crrFullNm[i] != null)
					model.setCrrFullNm(crrFullNm[i]);
				if (imdgUnNoSeq[i] != null)
					model.setImdgUnNoSeq(imdgUnNoSeq[i]);
				if (optclass[i] != null)
					model.setOptclass(optclass[i]);
				if (prpShpNm[i] != null)
					model.setPrpShpNm(prpShpNm[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVopScg0009ConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VopScg0009ConditionVO[]
	 */
	public VopScg0009ConditionVO[] getVopScg0009ConditionVOs(){
		VopScg0009ConditionVO[] vos = (VopScg0009ConditionVO[])models.toArray(new VopScg0009ConditionVO[models.size()]);
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
		this.grpCd = this.grpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgTekNmCheck = this.imdgTekNmCheck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCdDesc = this.imdgClssCdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrFullNm = this.crrFullNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNoSeq = this.imdgUnNoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optclass = this.optclass .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prpShpNm = this.prpShpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

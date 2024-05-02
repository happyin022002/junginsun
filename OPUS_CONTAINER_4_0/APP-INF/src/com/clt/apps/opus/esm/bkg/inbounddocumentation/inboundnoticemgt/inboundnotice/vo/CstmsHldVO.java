/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CstmsHldVO.java
*@FileTitle : CstmsHldVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.09.24 박미옥 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.common.CountryCode;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박미옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CstmsHldVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CstmsHldVO> models = new ArrayList<CstmsHldVO>();
	
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String rlseHldDt = null;
	/* Column Info */
	private String cstmsLocCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String hldType = null;
	/* Column Info */
	private String rlseHldCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String hldCd = null;
	/* Column Info */
	private String hldDt = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String cntCd = CountryCode.US;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CstmsHldVO() {}

	public CstmsHldVO(String ibflag, String pagerows, String blNo, String podCd, String bkgNo, String cntrNo, String cstmsLocCd, String hldType, String hldCd, String hldDt, String rlseHldCd, String rlseHldDt, String cntCd) {
		this.podCd = podCd;
		this.rlseHldDt = rlseHldDt;
		this.cstmsLocCd = cstmsLocCd;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.hldType = hldType;
		this.rlseHldCd = rlseHldCd;
		this.cntrNo = cntrNo;
		this.hldCd = hldCd;
		this.hldDt = hldDt;
		this.blNo = blNo;
		this.cntCd = cntCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("rlse_hld_dt", getRlseHldDt());
		this.hashColumns.put("cstms_loc_cd", getCstmsLocCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("hld_type", getHldType());
		this.hashColumns.put("rlse_hld_cd", getRlseHldCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("hld_cd", getHldCd());
		this.hashColumns.put("hld_dt", getHldDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("rlse_hld_dt", "rlseHldDt");
		this.hashFields.put("cstms_loc_cd", "cstmsLocCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("hld_type", "hldType");
		this.hashFields.put("rlse_hld_cd", "rlseHldCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("hld_cd", "hldCd");
		this.hashFields.put("hld_dt", "hldDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return rlseHldDt
	 */
	public String getRlseHldDt() {
		return this.rlseHldDt;
	}
	
	/**
	 * Column Info
	 * @return cstmsLocCd
	 */
	public String getCstmsLocCd() {
		return this.cstmsLocCd;
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
	 * @return hldType
	 */
	public String getHldType() {
		return this.hldType;
	}
	
	/**
	 * Column Info
	 * @return rlseHldCd
	 */
	public String getRlseHldCd() {
		return this.rlseHldCd;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return hldCd
	 */
	public String getHldCd() {
		return this.hldCd;
	}
	
	/**
	 * Column Info
	 * @return hldDt
	 */
	public String getHldDt() {
		return this.hldDt;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param rlseHldDt
	 */
	public void setRlseHldDt(String rlseHldDt) {
		this.rlseHldDt = rlseHldDt;
	}
	
	/**
	 * Column Info
	 * @param cstmsLocCd
	 */
	public void setCstmsLocCd(String cstmsLocCd) {
		this.cstmsLocCd = cstmsLocCd;
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
	 * @param hldType
	 */
	public void setHldType(String hldType) {
		this.hldType = hldType;
	}
	
	/**
	 * Column Info
	 * @param rlseHldCd
	 */
	public void setRlseHldCd(String rlseHldCd) {
		this.rlseHldCd = rlseHldCd;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param hldCd
	 */
	public void setHldCd(String hldCd) {
		this.hldCd = hldCd;
	}
	
	/**
	 * Column Info
	 * @param hldDt
	 */
	public void setHldDt(String hldDt) {
		this.hldDt = hldDt;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.blNo = blNo;
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
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setRlseHldDt(JSPUtil.getParameter(request, "rlse_hld_dt", ""));
		setCstmsLocCd(JSPUtil.getParameter(request, "cstms_loc_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setHldType(JSPUtil.getParameter(request, "hld_type", ""));
		setRlseHldCd(JSPUtil.getParameter(request, "rlse_hld_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setHldCd(JSPUtil.getParameter(request, "hld_cd", ""));
		setHldDt(JSPUtil.getParameter(request, "hld_dt", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CstmsHldVO[]
	 */
	public CstmsHldVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CstmsHldVO[]
	 */
	public CstmsHldVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CstmsHldVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] rlseHldDt = (JSPUtil.getParameter(request, prefix	+ "rlse_hld_dt", length));
			String[] cstmsLocCd = (JSPUtil.getParameter(request, prefix	+ "cstms_loc_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] hldType = (JSPUtil.getParameter(request, prefix	+ "hld_type", length));
			String[] rlseHldCd = (JSPUtil.getParameter(request, prefix	+ "rlse_hld_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] hldCd = (JSPUtil.getParameter(request, prefix	+ "hld_cd", length));
			String[] hldDt = (JSPUtil.getParameter(request, prefix	+ "hld_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CstmsHldVO();
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (rlseHldDt[i] != null)
					model.setRlseHldDt(rlseHldDt[i]);
				if (cstmsLocCd[i] != null)
					model.setCstmsLocCd(cstmsLocCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (hldType[i] != null)
					model.setHldType(hldType[i]);
				if (rlseHldCd[i] != null)
					model.setRlseHldCd(rlseHldCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (hldCd[i] != null)
					model.setHldCd(hldCd[i]);
				if (hldDt[i] != null)
					model.setHldDt(hldDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCstmsHldVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CstmsHldVO[]
	 */
	public CstmsHldVO[] getCstmsHldVOs(){
		CstmsHldVO[] vos = (CstmsHldVO[])models.toArray(new CstmsHldVO[models.size()]);
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
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlseHldDt = this.rlseHldDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsLocCd = this.cstmsLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hldType = this.hldType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlseHldCd = this.rlseHldCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hldCd = this.hldCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hldDt = this.hldDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

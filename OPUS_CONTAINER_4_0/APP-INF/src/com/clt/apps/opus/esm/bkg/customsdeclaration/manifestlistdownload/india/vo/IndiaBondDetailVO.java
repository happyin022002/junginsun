/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IndiaBondDetailVO.java
*@FileTitle : IndiaBondDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.07.06 경종윤 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.BondDetailListVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 경종윤
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class IndiaBondDetailVO extends BondDetailListVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<IndiaBondDetailVO> models = new ArrayList<IndiaBondDetailVO>();
	
	/* Column Info */
	private String phnNo = null;
	/* Column Info */
	private String whCd = null;
	/* Column Info */
	private String cstmsCd = null;
	/* Column Info */
	private String psonNm = null;
	/* Column Info */
	private String bdAreaCd = null;
	/* Column Info */
	private String locNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String whNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String faxNo = null;
	/* Column Info */
	private String whAddr = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public IndiaBondDetailVO() {}

	public IndiaBondDetailVO(String ibflag, String pagerows, String cntCd, String locCd, String whCd, String cstmsCd, String whNm, String whAddr, String bdAreaCd, String locNm, String phnNo, String psonNm, String faxNo, String diffRmk) {
		this.phnNo = phnNo;
		this.whCd = whCd;
		this.cstmsCd = cstmsCd;
		this.psonNm = psonNm;
		this.bdAreaCd = bdAreaCd;
		this.locNm = locNm;
		this.pagerows = pagerows;
		this.whNm = whNm;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.diffRmk = diffRmk;
		this.cntCd = cntCd;
		this.faxNo = faxNo;
		this.whAddr = whAddr;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("phn_no", getPhnNo());
		this.hashColumns.put("wh_cd", getWhCd());
		this.hashColumns.put("cstms_cd", getCstmsCd());
		this.hashColumns.put("pson_nm", getPsonNm());
		this.hashColumns.put("bd_area_cd", getBdAreaCd());
		this.hashColumns.put("loc_nm", getLocNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("wh_nm", getWhNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("wh_addr", getWhAddr());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("phn_no", "phnNo");
		this.hashFields.put("wh_cd", "whCd");
		this.hashFields.put("cstms_cd", "cstmsCd");
		this.hashFields.put("pson_nm", "psonNm");
		this.hashFields.put("bd_area_cd", "bdAreaCd");
		this.hashFields.put("loc_nm", "locNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("wh_nm", "whNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("wh_addr", "whAddr");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return phnNo
	 */
	public String getPhnNo() {
		return this.phnNo;
	}
	
	/**
	 * Column Info
	 * @return whCd
	 */
	public String getWhCd() {
		return this.whCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsCd
	 */
	public String getCstmsCd() {
		return this.cstmsCd;
	}
	
	/**
	 * Column Info
	 * @return psonNm
	 */
	public String getPsonNm() {
		return this.psonNm;
	}
	
	/**
	 * Column Info
	 * @return bdAreaCd
	 */
	public String getBdAreaCd() {
		return this.bdAreaCd;
	}
	
	/**
	 * Column Info
	 * @return locNm
	 */
	public String getLocNm() {
		return this.locNm;
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
	 * @return whNm
	 */
	public String getWhNm() {
		return this.whNm;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return faxNo
	 */
	public String getFaxNo() {
		return this.faxNo;
	}
	
	/**
	 * Column Info
	 * @return whAddr
	 */
	public String getWhAddr() {
		return this.whAddr;
	}
	

	/**
	 * Column Info
	 * @param phnNo
	 */
	public void setPhnNo(String phnNo) {
		this.phnNo = phnNo;
	}
	
	/**
	 * Column Info
	 * @param whCd
	 */
	public void setWhCd(String whCd) {
		this.whCd = whCd;
	}
	
	/**
	 * Column Info
	 * @param cstmsCd
	 */
	public void setCstmsCd(String cstmsCd) {
		this.cstmsCd = cstmsCd;
	}
	
	/**
	 * Column Info
	 * @param psonNm
	 */
	public void setPsonNm(String psonNm) {
		this.psonNm = psonNm;
	}
	
	/**
	 * Column Info
	 * @param bdAreaCd
	 */
	public void setBdAreaCd(String bdAreaCd) {
		this.bdAreaCd = bdAreaCd;
	}
	
	/**
	 * Column Info
	 * @param locNm
	 */
	public void setLocNm(String locNm) {
		this.locNm = locNm;
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
	 * @param whNm
	 */
	public void setWhNm(String whNm) {
		this.whNm = whNm;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param faxNo
	 */
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}
	
	/**
	 * Column Info
	 * @param whAddr
	 */
	public void setWhAddr(String whAddr) {
		this.whAddr = whAddr;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPhnNo(JSPUtil.getParameter(request, "phn_no", ""));
		setWhCd(JSPUtil.getParameter(request, "wh_cd", ""));
		setCstmsCd(JSPUtil.getParameter(request, "cstms_cd", ""));
		setPsonNm(JSPUtil.getParameter(request, "pson_nm", ""));
		setBdAreaCd(JSPUtil.getParameter(request, "bd_area_cd", ""));
		setLocNm(JSPUtil.getParameter(request, "loc_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setWhNm(JSPUtil.getParameter(request, "wh_nm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setDiffRmk(JSPUtil.getParameter(request, "diff_rmk", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setFaxNo(JSPUtil.getParameter(request, "fax_no", ""));
		setWhAddr(JSPUtil.getParameter(request, "wh_addr", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IndiaBondDetailVO[]
	 */
	public IndiaBondDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IndiaBondDetailVO[]
	 */
	public IndiaBondDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		IndiaBondDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] phnNo = (JSPUtil.getParameter(request, prefix	+ "phn_no", length));
			String[] whCd = (JSPUtil.getParameter(request, prefix	+ "wh_cd", length));
			String[] cstmsCd = (JSPUtil.getParameter(request, prefix	+ "cstms_cd", length));
			String[] psonNm = (JSPUtil.getParameter(request, prefix	+ "pson_nm", length));
			String[] bdAreaCd = (JSPUtil.getParameter(request, prefix	+ "bd_area_cd", length));
			String[] locNm = (JSPUtil.getParameter(request, prefix	+ "loc_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] whNm = (JSPUtil.getParameter(request, prefix	+ "wh_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no", length));
			String[] whAddr = (JSPUtil.getParameter(request, prefix	+ "wh_addr", length));
			
			for (int i = 0; i < length; i++) {
				model = new IndiaBondDetailVO();
				if (phnNo[i] != null)
					model.setPhnNo(phnNo[i]);
				if (whCd[i] != null)
					model.setWhCd(whCd[i]);
				if (cstmsCd[i] != null)
					model.setCstmsCd(cstmsCd[i]);
				if (psonNm[i] != null)
					model.setPsonNm(psonNm[i]);
				if (bdAreaCd[i] != null)
					model.setBdAreaCd(bdAreaCd[i]);
				if (locNm[i] != null)
					model.setLocNm(locNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (whNm[i] != null)
					model.setWhNm(whNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (faxNo[i] != null)
					model.setFaxNo(faxNo[i]);
				if (whAddr[i] != null)
					model.setWhAddr(whAddr[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getIndiaBondDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return IndiaBondDetailVO[]
	 */
	public IndiaBondDetailVO[] getIndiaBondDetailVOs(){
		IndiaBondDetailVO[] vos = (IndiaBondDetailVO[])models.toArray(new IndiaBondDetailVO[models.size()]);
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
		this.phnNo = this.phnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whCd = this.whCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsCd = this.cstmsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psonNm = this.psonNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdAreaCd = this.bdAreaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locNm = this.locNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whNm = this.whNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whAddr = this.whAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

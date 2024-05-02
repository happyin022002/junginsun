/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorWareHouseVO.java
*@FileTitle : KorWareHouseVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.16
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.07.16 박상훈
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.WareHouseVO;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박상훈
 * @since J2EE 1.6
 * @see WareHouseVO
 */

public class KorWareHouseVO extends WareHouseVO {

	private static final long serialVersionUID = 1L;

	private Collection<KorWareHouseVO> models = new ArrayList<KorWareHouseVO>();

	/* Column Info */
	private String phnNo = null;
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String whCd = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String cstmsCd = null;
	/* Column Info */
	private String faxNo = null;
	/* Column Info */
	private String psonNm = null;
	/* Column Info */
	private String whAddr = null;
	/* Column Info */
	private String whNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public KorWareHouseVO() {}

	public KorWareHouseVO(String ibflag, String pagerows, String cntCd, String whCd, String whNm, String whAddr, String locCd, String cstmsCd, String phnNo, String faxNo, String psonNm, String diffRmk) {
		this.phnNo = phnNo;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.diffRmk = diffRmk;
		this.whCd = whCd;
		this.cntCd = cntCd;
		this.cstmsCd = cstmsCd;
		this.faxNo = faxNo;
		this.psonNm = psonNm;
		this.whAddr = whAddr;
		this.whNm = whNm;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("phn_no", getPhnNo());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("wh_cd", getWhCd());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("cstms_cd", getCstmsCd());
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("pson_nm", getPsonNm());
		this.hashColumns.put("wh_addr", getWhAddr());
		this.hashColumns.put("wh_nm", getWhNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("phn_no", "phnNo");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("wh_cd", "whCd");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("cstms_cd", "cstmsCd");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("pson_nm", "psonNm");
		this.hashFields.put("wh_addr", "whAddr");
		this.hashFields.put("wh_nm", "whNm");
		this.hashFields.put("pagerows", "pagerows");
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
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
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
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
	 * @return faxNo
	 */
	public String getFaxNo() {
		return this.faxNo;
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
	 * @return whAddr
	 */
	public String getWhAddr() {
		return this.whAddr;
	}

	/**
	 * Column Info
	 * @return whNm
	 */
	public String getWhNm() {
		return this.whNm;
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
	 * @param phnNo
	 */
	public void setPhnNo(String phnNo) {
		this.phnNo = phnNo;
	}

	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
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
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
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
	 * @param faxNo
	 */
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
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
	 * @param whAddr
	 */
	public void setWhAddr(String whAddr) {
		this.whAddr = whAddr;
	}

	/**
	 * Column Info
	 * @param whNm
	 */
	public void setWhNm(String whNm) {
		this.whNm = whNm;
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
		setPhnNo(JSPUtil.getParameter(request, "phn_no", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDiffRmk(JSPUtil.getParameter(request, "diff_rmk", ""));
		setWhCd(JSPUtil.getParameter(request, "wh_cd", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setCstmsCd(JSPUtil.getParameter(request, "cstms_cd", ""));
		setFaxNo(JSPUtil.getParameter(request, "fax_no", ""));
		setPsonNm(JSPUtil.getParameter(request, "pson_nm", ""));
		setWhAddr(JSPUtil.getParameter(request, "wh_addr", ""));
		setWhNm(JSPUtil.getParameter(request, "wh_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorWareHouseVO[]
	 */
	public KorWareHouseVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return KorWareHouseVO[]
	 */
	public KorWareHouseVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorWareHouseVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] phnNo = (JSPUtil.getParameter(request, prefix	+ "phn_no", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] whCd = (JSPUtil.getParameter(request, prefix	+ "wh_cd", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] cstmsCd = (JSPUtil.getParameter(request, prefix	+ "cstms_cd", length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no", length));
			String[] psonNm = (JSPUtil.getParameter(request, prefix	+ "pson_nm", length));
			String[] whAddr = (JSPUtil.getParameter(request, prefix	+ "wh_addr", length));
			String[] whNm = (JSPUtil.getParameter(request, prefix	+ "wh_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new KorWareHouseVO();
				if (phnNo[i] != null)
					model.setPhnNo(phnNo[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (whCd[i] != null)
					model.setWhCd(whCd[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (cstmsCd[i] != null)
					model.setCstmsCd(cstmsCd[i]);
				if (faxNo[i] != null)
					model.setFaxNo(faxNo[i]);
				if (psonNm[i] != null)
					model.setPsonNm(psonNm[i]);
				if (whAddr[i] != null)
					model.setWhAddr(whAddr[i]);
				if (whNm[i] != null)
					model.setWhNm(whNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorWareHouseVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorWareHouseVO[]
	 */
	public KorWareHouseVO[] getKorWareHouseVOs(){
		KorWareHouseVO[] vos = (KorWareHouseVO[])models.toArray(new KorWareHouseVO[models.size()]);
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
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whCd = this.whCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsCd = this.cstmsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psonNm = this.psonNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whAddr = this.whAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whNm = this.whNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JapanManifestListBkgCustInfoVO.java
*@FileTitle : JapanManifestListBkgCustInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier :
*@LastVersion : 1.0
* 2009.05.21
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class JapanManifestListBkgCustInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<JapanManifestListBkgCustInfoVO> models = new ArrayList<JapanManifestListBkgCustInfoVO>();

	/* Column Info */
	private String blNoChk = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String blNoSplit = null;
	/* Column Info */
	private String custAddr = null;
	/* Column Info */
	private String blNoTp = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String bkgCustTpCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String custCntCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public JapanManifestListBkgCustInfoVO() {}

	public JapanManifestListBkgCustInfoVO(String ibflag, String pagerows, String blNo, String blNoTp, String blNoChk, String blNoSplit, String bkgCustTpCd, String custSeq, String custCntCd, String custNm, String custAddr) {
		this.blNoChk = blNoChk;
		this.ibflag = ibflag;
		this.custNm = custNm;
		this.blNoSplit = blNoSplit;
		this.custAddr = custAddr;
		this.blNoTp = blNoTp;
		this.custSeq = custSeq;
		this.bkgCustTpCd = bkgCustTpCd;
		this.blNo = blNo;
		this.custCntCd = custCntCd;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bl_no_chk", getBlNoChk());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("bl_no_split", getBlNoSplit());
		this.hashColumns.put("cust_addr", getCustAddr());
		this.hashColumns.put("bl_no_tp", getBlNoTp());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("bkg_cust_tp_cd", getBkgCustTpCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bl_no_chk", "blNoChk");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("bl_no_split", "blNoSplit");
		this.hashFields.put("cust_addr", "custAddr");
		this.hashFields.put("bl_no_tp", "blNoTp");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("bkg_cust_tp_cd", "bkgCustTpCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return blNoChk
	 */
	public String getBlNoChk() {
		return this.blNoChk;
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
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}

	/**
	 * Column Info
	 * @return blNoSplit
	 */
	public String getBlNoSplit() {
		return this.blNoSplit;
	}

	/**
	 * Column Info
	 * @return custAddr
	 */
	public String getCustAddr() {
		return this.custAddr;
	}

	/**
	 * Column Info
	 * @return blNoTp
	 */
	public String getBlNoTp() {
		return this.blNoTp;
	}

	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}

	/**
	 * Column Info
	 * @return bkgCustTpCd
	 */
	public String getBkgCustTpCd() {
		return this.bkgCustTpCd;
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
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
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
	 * @param blNoChk
	 */
	public void setBlNoChk(String blNoChk) {
		this.blNoChk = blNoChk;
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
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}

	/**
	 * Column Info
	 * @param blNoSplit
	 */
	public void setBlNoSplit(String blNoSplit) {
		this.blNoSplit = blNoSplit;
	}

	/**
	 * Column Info
	 * @param custAddr
	 */
	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
	}

	/**
	 * Column Info
	 * @param blNoTp
	 */
	public void setBlNoTp(String blNoTp) {
		this.blNoTp = blNoTp;
	}

	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}

	/**
	 * Column Info
	 * @param bkgCustTpCd
	 */
	public void setBkgCustTpCd(String bkgCustTpCd) {
		this.bkgCustTpCd = bkgCustTpCd;
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
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
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
		setBlNoChk(JSPUtil.getParameter(request, "bl_no_chk", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setBlNoSplit(JSPUtil.getParameter(request, "bl_no_split", ""));
		setCustAddr(JSPUtil.getParameter(request, "cust_addr", ""));
		setBlNoTp(JSPUtil.getParameter(request, "bl_no_tp", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setBkgCustTpCd(JSPUtil.getParameter(request, "bkg_cust_tp_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return JapanManifestListBkgCustInfoVO[]
	 */
	public JapanManifestListBkgCustInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return JapanManifestListBkgCustInfoVO[]
	 */
	public JapanManifestListBkgCustInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		JapanManifestListBkgCustInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] blNoChk = (JSPUtil.getParameter(request, prefix	+ "bl_no_chk".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm".trim(), length));
			String[] blNoSplit = (JSPUtil.getParameter(request, prefix	+ "bl_no_split".trim(), length));
			String[] custAddr = (JSPUtil.getParameter(request, prefix	+ "cust_addr".trim(), length));
			String[] blNoTp = (JSPUtil.getParameter(request, prefix	+ "bl_no_tp".trim(), length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq".trim(), length));
			String[] bkgCustTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cust_tp_cd".trim(), length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no".trim(), length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));

			for (int i = 0; i < length; i++) {
				model = new JapanManifestListBkgCustInfoVO();
				if (blNoChk[i] != null)
					model.setBlNoChk(blNoChk[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (blNoSplit[i] != null)
					model.setBlNoSplit(blNoSplit[i]);
				if (custAddr[i] != null)
					model.setCustAddr(custAddr[i]);
				if (blNoTp[i] != null)
					model.setBlNoTp(blNoTp[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (bkgCustTpCd[i] != null)
					model.setBkgCustTpCd(bkgCustTpCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getJapanManifestListBkgCustInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return JapanManifestListBkgCustInfoVO[]
	 */
	public JapanManifestListBkgCustInfoVO[] getJapanManifestListBkgCustInfoVOs(){
		JapanManifestListBkgCustInfoVO[] vos = (JapanManifestListBkgCustInfoVO[])models.toArray(new JapanManifestListBkgCustInfoVO[models.size()]);
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
		this.blNoChk = this.blNoChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNoSplit = this.blNoSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAddr = this.custAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNoTp = this.blNoTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustTpCd = this.bkgCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

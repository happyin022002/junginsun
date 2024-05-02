/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JapanMfrCustModificationVO.java
*@FileTitle : JapanMfrCustModificationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.06.04
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.MfrCustModificationVO;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김승민
 * @since J2EE 1.6
 * @see MfrCustModificationVO
 */

public class JapanMfrCustModificationVO extends MfrCustModificationVO {

	private static final long serialVersionUID = 1L;

	private Collection<JapanMfrCustModificationVO> models = new ArrayList<JapanMfrCustModificationVO>();

	/* Column Info */
	private String custSeq2 = null;
	/* Column Info */
	private String custSeq3 = null;
	/* Column Info */
	private String phnNo = null;
	/* Column Info */
	private String custAddr3 = null;
	/* Column Info */
	private String custAddr2 = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String faxNo3 = null;
	/* Column Info */
	private String faxNo2 = null;
	/* Column Info */
	private String custAddr = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String blNumber = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String clptIndSeq = null;
	/* Column Info */
	private String custCntCd3 = null;
	/* Column Info */
	private String faxNo = null;
	/* Column Info */
	private String phnNo3 = null;
	/* Column Info */
	private String custNm3 = null;
	/* Column Info */
	private String phnNo2 = null;
	/* Column Info */
	private String custNm2 = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String custCntCd2 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public JapanMfrCustModificationVO() {}

	public JapanMfrCustModificationVO(String ibflag, String pagerows, String blNumber, String vvdCd, String podCd, String clptIndSeq, String custCntCd, String custSeq, String custNm, String custAddr, String phnNo, String faxNo, String custCntCd2, String custSeq2, String custNm2, String custAddr2, String phnNo2, String faxNo2, String custCntCd3, String custSeq3, String custNm3, String custAddr3, String phnNo3, String faxNo3) {
		this.custSeq2 = custSeq2;
		this.custSeq3 = custSeq3;
		this.phnNo = phnNo;
		this.custAddr3 = custAddr3;
		this.custAddr2 = custAddr2;
		this.custNm = custNm;
		this.faxNo3 = faxNo3;
		this.faxNo2 = faxNo2;
		this.custAddr = custAddr;
		this.custSeq = custSeq;
		this.blNumber = blNumber;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.vvdCd = vvdCd;
		this.clptIndSeq = clptIndSeq;
		this.custCntCd3 = custCntCd3;
		this.faxNo = faxNo;
		this.phnNo3 = phnNo3;
		this.custNm3 = custNm3;
		this.phnNo2 = phnNo2;
		this.custNm2 = custNm2;
		this.custCntCd = custCntCd;
		this.custCntCd2 = custCntCd2;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cust_seq2", getCustSeq2());
		this.hashColumns.put("cust_seq3", getCustSeq3());
		this.hashColumns.put("phn_no", getPhnNo());
		this.hashColumns.put("cust_addr3", getCustAddr3());
		this.hashColumns.put("cust_addr2", getCustAddr2());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("fax_no3", getFaxNo3());
		this.hashColumns.put("fax_no2", getFaxNo2());
		this.hashColumns.put("cust_addr", getCustAddr());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("bl_number", getBlNumber());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		this.hashColumns.put("cust_cnt_cd3", getCustCntCd3());
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("phn_no3", getPhnNo3());
		this.hashColumns.put("cust_nm3", getCustNm3());
		this.hashColumns.put("phn_no2", getPhnNo2());
		this.hashColumns.put("cust_nm2", getCustNm2());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cust_cnt_cd2", getCustCntCd2());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cust_seq2", "custSeq2");
		this.hashFields.put("cust_seq3", "custSeq3");
		this.hashFields.put("phn_no", "phnNo");
		this.hashFields.put("cust_addr3", "custAddr3");
		this.hashFields.put("cust_addr2", "custAddr2");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("fax_no3", "faxNo3");
		this.hashFields.put("fax_no2", "faxNo2");
		this.hashFields.put("cust_addr", "custAddr");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("bl_number", "blNumber");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		this.hashFields.put("cust_cnt_cd3", "custCntCd3");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("phn_no3", "phnNo3");
		this.hashFields.put("cust_nm3", "custNm3");
		this.hashFields.put("phn_no2", "phnNo2");
		this.hashFields.put("cust_nm2", "custNm2");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cust_cnt_cd2", "custCntCd2");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return custSeq2
	 */
	public String getCustSeq2() {
		return this.custSeq2;
	}

	/**
	 * Column Info
	 * @return custSeq3
	 */
	public String getCustSeq3() {
		return this.custSeq3;
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
	 * @return custAddr3
	 */
	public String getCustAddr3() {
		return this.custAddr3;
	}

	/**
	 * Column Info
	 * @return custAddr2
	 */
	public String getCustAddr2() {
		return this.custAddr2;
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
	 * @return faxNo3
	 */
	public String getFaxNo3() {
		return this.faxNo3;
	}

	/**
	 * Column Info
	 * @return faxNo2
	 */
	public String getFaxNo2() {
		return this.faxNo2;
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
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}

	/**
	 * Column Info
	 * @return blNumber
	 */
	public String getBlNumber() {
		return this.blNumber;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}

	/**
	 * Column Info
	 * @return clptIndSeq
	 */
	public String getClptIndSeq() {
		return this.clptIndSeq;
	}

	/**
	 * Column Info
	 * @return custCntCd3
	 */
	public String getCustCntCd3() {
		return this.custCntCd3;
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
	 * @return phnNo3
	 */
	public String getPhnNo3() {
		return this.phnNo3;
	}

	/**
	 * Column Info
	 * @return custNm3
	 */
	public String getCustNm3() {
		return this.custNm3;
	}

	/**
	 * Column Info
	 * @return phnNo2
	 */
	public String getPhnNo2() {
		return this.phnNo2;
	}

	/**
	 * Column Info
	 * @return custNm2
	 */
	public String getCustNm2() {
		return this.custNm2;
	}

	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}

	/**
	 * Column Info
	 * @return custCntCd2
	 */
	public String getCustCntCd2() {
		return this.custCntCd2;
	}


	/**
	 * Column Info
	 * @param custSeq2
	 */
	public void setCustSeq2(String custSeq2) {
		this.custSeq2 = custSeq2;
	}

	/**
	 * Column Info
	 * @param custSeq3
	 */
	public void setCustSeq3(String custSeq3) {
		this.custSeq3 = custSeq3;
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
	 * @param custAddr3
	 */
	public void setCustAddr3(String custAddr3) {
		this.custAddr3 = custAddr3;
	}

	/**
	 * Column Info
	 * @param custAddr2
	 */
	public void setCustAddr2(String custAddr2) {
		this.custAddr2 = custAddr2;
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
	 * @param faxNo3
	 */
	public void setFaxNo3(String faxNo3) {
		this.faxNo3 = faxNo3;
	}

	/**
	 * Column Info
	 * @param faxNo2
	 */
	public void setFaxNo2(String faxNo2) {
		this.faxNo2 = faxNo2;
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
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}

	/**
	 * Column Info
	 * @param blNumber
	 */
	public void setBlNumber(String blNumber) {
		this.blNumber = blNumber;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}

	/**
	 * Column Info
	 * @param clptIndSeq
	 */
	public void setClptIndSeq(String clptIndSeq) {
		this.clptIndSeq = clptIndSeq;
	}

	/**
	 * Column Info
	 * @param custCntCd3
	 */
	public void setCustCntCd3(String custCntCd3) {
		this.custCntCd3 = custCntCd3;
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
	 * @param phnNo3
	 */
	public void setPhnNo3(String phnNo3) {
		this.phnNo3 = phnNo3;
	}

	/**
	 * Column Info
	 * @param custNm3
	 */
	public void setCustNm3(String custNm3) {
		this.custNm3 = custNm3;
	}

	/**
	 * Column Info
	 * @param phnNo2
	 */
	public void setPhnNo2(String phnNo2) {
		this.phnNo2 = phnNo2;
	}

	/**
	 * Column Info
	 * @param custNm2
	 */
	public void setCustNm2(String custNm2) {
		this.custNm2 = custNm2;
	}

	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}

	/**
	 * Column Info
	 * @param custCntCd2
	 */
	public void setCustCntCd2(String custCntCd2) {
		this.custCntCd2 = custCntCd2;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCustSeq2(JSPUtil.getParameter(request, "cust_seq2", ""));
		setCustSeq3(JSPUtil.getParameter(request, "cust_seq3", ""));
		setPhnNo(JSPUtil.getParameter(request, "phn_no", ""));
		setCustAddr3(JSPUtil.getParameter(request, "cust_addr3", ""));
		setCustAddr2(JSPUtil.getParameter(request, "cust_addr2", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setFaxNo3(JSPUtil.getParameter(request, "fax_no3", ""));
		setFaxNo2(JSPUtil.getParameter(request, "fax_no2", ""));
		setCustAddr(JSPUtil.getParameter(request, "cust_addr", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setBlNumber(JSPUtil.getParameter(request, "bl_number", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setClptIndSeq(JSPUtil.getParameter(request, "clpt_ind_seq", ""));
		setCustCntCd3(JSPUtil.getParameter(request, "cust_cnt_cd3", ""));
		setFaxNo(JSPUtil.getParameter(request, "fax_no", ""));
		setPhnNo3(JSPUtil.getParameter(request, "phn_no3", ""));
		setCustNm3(JSPUtil.getParameter(request, "cust_nm3", ""));
		setPhnNo2(JSPUtil.getParameter(request, "phn_no2", ""));
		setCustNm2(JSPUtil.getParameter(request, "cust_nm2", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setCustCntCd2(JSPUtil.getParameter(request, "cust_cnt_cd2", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return JapanManifestListMfrCustInfoVO[]
	 */
	public JapanMfrCustModificationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return JapanManifestListMfrCustInfoVO[]
	 */
	public JapanMfrCustModificationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		JapanMfrCustModificationVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] custSeq2 = (JSPUtil.getParameter(request, prefix	+ "cust_seq2".trim(), length));
			String[] custSeq3 = (JSPUtil.getParameter(request, prefix	+ "cust_seq3".trim(), length));
			String[] phnNo = (JSPUtil.getParameter(request, prefix	+ "phn_no".trim(), length));
			String[] custAddr3 = (JSPUtil.getParameter(request, prefix	+ "cust_addr3".trim(), length));
			String[] custAddr2 = (JSPUtil.getParameter(request, prefix	+ "cust_addr2".trim(), length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm".trim(), length));
			String[] faxNo3 = (JSPUtil.getParameter(request, prefix	+ "fax_no3".trim(), length));
			String[] faxNo2 = (JSPUtil.getParameter(request, prefix	+ "fax_no2".trim(), length));
			String[] custAddr = (JSPUtil.getParameter(request, prefix	+ "cust_addr".trim(), length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq".trim(), length));
			String[] blNumber = (JSPUtil.getParameter(request, prefix	+ "bl_number".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd".trim(), length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq".trim(), length));
			String[] custCntCd3 = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd3".trim(), length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no".trim(), length));
			String[] phnNo3 = (JSPUtil.getParameter(request, prefix	+ "phn_no3".trim(), length));
			String[] custNm3 = (JSPUtil.getParameter(request, prefix	+ "cust_nm3".trim(), length));
			String[] phnNo2 = (JSPUtil.getParameter(request, prefix	+ "phn_no2".trim(), length));
			String[] custNm2 = (JSPUtil.getParameter(request, prefix	+ "cust_nm2".trim(), length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd".trim(), length));
			String[] custCntCd2 = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd2".trim(), length));

			for (int i = 0; i < length; i++) {
				model = new JapanMfrCustModificationVO();
				if (custSeq2[i] != null)
					model.setCustSeq2(custSeq2[i]);
				if (custSeq3[i] != null)
					model.setCustSeq3(custSeq3[i]);
				if (phnNo[i] != null)
					model.setPhnNo(phnNo[i]);
				if (custAddr3[i] != null)
					model.setCustAddr3(custAddr3[i]);
				if (custAddr2[i] != null)
					model.setCustAddr2(custAddr2[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (faxNo3[i] != null)
					model.setFaxNo3(faxNo3[i]);
				if (faxNo2[i] != null)
					model.setFaxNo2(faxNo2[i]);
				if (custAddr[i] != null)
					model.setCustAddr(custAddr[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (blNumber[i] != null)
					model.setBlNumber(blNumber[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				if (custCntCd3[i] != null)
					model.setCustCntCd3(custCntCd3[i]);
				if (faxNo[i] != null)
					model.setFaxNo(faxNo[i]);
				if (phnNo3[i] != null)
					model.setPhnNo3(phnNo3[i]);
				if (custNm3[i] != null)
					model.setCustNm3(custNm3[i]);
				if (phnNo2[i] != null)
					model.setPhnNo2(phnNo2[i]);
				if (custNm2[i] != null)
					model.setCustNm2(custNm2[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (custCntCd2[i] != null)
					model.setCustCntCd2(custCntCd2[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getJapanManifestListMfrCustInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return JapanManifestListMfrCustInfoVO[]
	 */
	public JapanMfrCustModificationVO[] getJapanManifestListMfrCustInfoVOs(){
		JapanMfrCustModificationVO[] vos = (JapanMfrCustModificationVO[])models.toArray(new JapanMfrCustModificationVO[models.size()]);
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
		this.custSeq2 = this.custSeq2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq3 = this.custSeq3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phnNo = this.phnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAddr3 = this.custAddr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAddr2 = this.custAddr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo3 = this.faxNo3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo2 = this.faxNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAddr = this.custAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNumber = this.blNumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd3 = this.custCntCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phnNo3 = this.phnNo3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm3 = this.custNm3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phnNo2 = this.phnNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm2 = this.custNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd2 = this.custCntCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

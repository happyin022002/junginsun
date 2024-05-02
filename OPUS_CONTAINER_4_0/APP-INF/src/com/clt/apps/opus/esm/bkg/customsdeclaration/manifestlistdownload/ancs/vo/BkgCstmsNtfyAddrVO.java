/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgCstmsNtfyAddrVO.java
*@FileTitle : BkgCstmsNtfyAddrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.15
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.06.15 정재엽 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsNtfyAddrVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정재엽
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgCstmsNtfyAddrVO extends CstmsNtfyAddrVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgCstmsNtfyAddrVO> models = new ArrayList<BkgCstmsNtfyAddrVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String keyAddr = null;
	/* Column Info */
	private String custAddr1 = null;
	/* Column Info */
	private String custAddr3 = null;
	/* Column Info */
	private String custAddr2 = null;
	/* Column Info */
	private String ntfyLtrRmk = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String addrSeq = null;
	/* Column Info */
	private String arCustRefNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String custAddr4 = null;
	/* Column Info */
	private String custAddr5 = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgCstmsNtfyAddrVO() {}

	public BkgCstmsNtfyAddrVO(String ibflag, String pagerows, String addrSeq, String keyAddr, String custAddr1, String custAddr2, String custAddr3, String custAddr4, String custAddr5, String arCustRefNo, String ntfyLtrRmk, String updUsrId, String updOfcCd, String creUsrId, String creOfcCd, String updDt, String creDt) {
		this.updDt = updDt;
		this.keyAddr = keyAddr;
		this.custAddr1 = custAddr1;
		this.custAddr3 = custAddr3;
		this.custAddr2 = custAddr2;
		this.ntfyLtrRmk = ntfyLtrRmk;
		this.creDt = creDt;
		this.addrSeq = addrSeq;
		this.arCustRefNo = arCustRefNo;
		this.pagerows = pagerows;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.creOfcCd = creOfcCd;
		this.custAddr4 = custAddr4;
		this.custAddr5 = custAddr5;
		this.updUsrId = updUsrId;
		this.updOfcCd = updOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("key_addr", getKeyAddr());
		this.hashColumns.put("cust_addr1", getCustAddr1());
		this.hashColumns.put("cust_addr3", getCustAddr3());
		this.hashColumns.put("cust_addr2", getCustAddr2());
		this.hashColumns.put("ntfy_ltr_rmk", getNtfyLtrRmk());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("addr_seq", getAddrSeq());
		this.hashColumns.put("ar_cust_ref_no", getArCustRefNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("cust_addr4", getCustAddr4());
		this.hashColumns.put("cust_addr5", getCustAddr5());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("key_addr", "keyAddr");
		this.hashFields.put("cust_addr1", "custAddr1");
		this.hashFields.put("cust_addr3", "custAddr3");
		this.hashFields.put("cust_addr2", "custAddr2");
		this.hashFields.put("ntfy_ltr_rmk", "ntfyLtrRmk");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("addr_seq", "addrSeq");
		this.hashFields.put("ar_cust_ref_no", "arCustRefNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("cust_addr4", "custAddr4");
		this.hashFields.put("cust_addr5", "custAddr5");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return keyAddr
	 */
	public String getKeyAddr() {
		return this.keyAddr;
	}
	
	/**
	 * Column Info
	 * @return custAddr1
	 */
	public String getCustAddr1() {
		return this.custAddr1;
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
	 * @return ntfyLtrRmk
	 */
	public String getNtfyLtrRmk() {
		return this.ntfyLtrRmk;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return addrSeq
	 */
	public String getAddrSeq() {
		return this.addrSeq;
	}
	
	/**
	 * Column Info
	 * @return arCustRefNo
	 */
	public String getArCustRefNo() {
		return this.arCustRefNo;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return custAddr4
	 */
	public String getCustAddr4() {
		return this.custAddr4;
	}
	
	/**
	 * Column Info
	 * @return custAddr5
	 */
	public String getCustAddr5() {
		return this.custAddr5;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return updOfcCd
	 */
	public String getUpdOfcCd() {
		return this.updOfcCd;
	}
	

	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param keyAddr
	 */
	public void setKeyAddr(String keyAddr) {
		this.keyAddr = keyAddr;
	}
	
	/**
	 * Column Info
	 * @param custAddr1
	 */
	public void setCustAddr1(String custAddr1) {
		this.custAddr1 = custAddr1;
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
	 * @param ntfyLtrRmk
	 */
	public void setNtfyLtrRmk(String ntfyLtrRmk) {
		this.ntfyLtrRmk = ntfyLtrRmk;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param addrSeq
	 */
	public void setAddrSeq(String addrSeq) {
		this.addrSeq = addrSeq;
	}
	
	/**
	 * Column Info
	 * @param arCustRefNo
	 */
	public void setArCustRefNo(String arCustRefNo) {
		this.arCustRefNo = arCustRefNo;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param custAddr4
	 */
	public void setCustAddr4(String custAddr4) {
		this.custAddr4 = custAddr4;
	}
	
	/**
	 * Column Info
	 * @param custAddr5
	 */
	public void setCustAddr5(String custAddr5) {
		this.custAddr5 = custAddr5;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param updOfcCd
	 */
	public void setUpdOfcCd(String updOfcCd) {
		this.updOfcCd = updOfcCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setKeyAddr(JSPUtil.getParameter(request, "key_addr", ""));
		setCustAddr1(JSPUtil.getParameter(request, "cust_addr1", ""));
		setCustAddr3(JSPUtil.getParameter(request, "cust_addr3", ""));
		setCustAddr2(JSPUtil.getParameter(request, "cust_addr2", ""));
		setNtfyLtrRmk(JSPUtil.getParameter(request, "ntfy_ltr_rmk", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setAddrSeq(JSPUtil.getParameter(request, "addr_seq", ""));
		setArCustRefNo(JSPUtil.getParameter(request, "ar_cust_ref_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setCustAddr4(JSPUtil.getParameter(request, "cust_addr4", ""));
		setCustAddr5(JSPUtil.getParameter(request, "cust_addr5", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, "upd_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCstmsRtmNtfyAddrVO[]
	 */
	public BkgCstmsNtfyAddrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgCstmsRtmNtfyAddrVO[]
	 */
	public BkgCstmsNtfyAddrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgCstmsNtfyAddrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] keyAddr = (JSPUtil.getParameter(request, prefix	+ "key_addr", length));
			String[] custAddr1 = (JSPUtil.getParameter(request, prefix	+ "cust_addr1", length));
			String[] custAddr3 = (JSPUtil.getParameter(request, prefix	+ "cust_addr3", length));
			String[] custAddr2 = (JSPUtil.getParameter(request, prefix	+ "cust_addr2", length));
			String[] ntfyLtrRmk = (JSPUtil.getParameter(request, prefix	+ "ntfy_ltr_rmk", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] addrSeq = (JSPUtil.getParameter(request, prefix	+ "addr_seq", length));
			String[] arCustRefNo = (JSPUtil.getParameter(request, prefix	+ "ar_cust_ref_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] custAddr4 = (JSPUtil.getParameter(request, prefix	+ "cust_addr4", length));
			String[] custAddr5 = (JSPUtil.getParameter(request, prefix	+ "cust_addr5", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgCstmsNtfyAddrVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (keyAddr[i] != null)
					model.setKeyAddr(keyAddr[i]);
				if (custAddr1[i] != null)
					model.setCustAddr1(custAddr1[i]);
				if (custAddr3[i] != null)
					model.setCustAddr3(custAddr3[i]);
				if (custAddr2[i] != null)
					model.setCustAddr2(custAddr2[i]);
				if (ntfyLtrRmk[i] != null)
					model.setNtfyLtrRmk(ntfyLtrRmk[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (addrSeq[i] != null)
					model.setAddrSeq(addrSeq[i]);
				if (arCustRefNo[i] != null)
					model.setArCustRefNo(arCustRefNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (custAddr4[i] != null)
					model.setCustAddr4(custAddr4[i]);
				if (custAddr5[i] != null)
					model.setCustAddr5(custAddr5[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgCstmsRtmNtfyAddrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgCstmsRtmNtfyAddrVO[]
	 */
	public BkgCstmsNtfyAddrVO[] getBkgCstmsRtmNtfyAddrVOs(){
		BkgCstmsNtfyAddrVO[] vos = (BkgCstmsNtfyAddrVO[])models.toArray(new BkgCstmsNtfyAddrVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keyAddr = this.keyAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAddr1 = this.custAddr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAddr3 = this.custAddr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAddr2 = this.custAddr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyLtrRmk = this.ntfyLtrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addrSeq = this.addrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arCustRefNo = this.arCustRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAddr4 = this.custAddr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAddr5 = this.custAddr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

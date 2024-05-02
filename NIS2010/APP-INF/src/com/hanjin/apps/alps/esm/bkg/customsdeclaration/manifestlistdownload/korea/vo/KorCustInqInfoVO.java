/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorCustInqInfoVO.java
*@FileTitle : KorCustInqInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.07.23 박상훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo;

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
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorCustInqInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorCustInqInfoVO> models = new ArrayList<KorCustInqInfoVO>();
	
	/* Column Info */
	private String nCustSeq = null;
	/* Column Info */
	private String cCntCd = null;
	/* Column Info */
	private String sCustSeq = null;
	/* Column Info */
	private String sCustNm = null;
	/* Column Info */
	private String trnsSeq = null;
	/* Column Info */
	private String cCustNm = null;
	/* Column Info */
	private String cCustSeq = null;
	/* Column Info */
	private String nCustAddr = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cCustAddr = null;
	/* Column Info */
	private String cstmsDeclTpCd = null;
	/* Column Info */
	private String oldCstmsDeclTpCd = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String sCustAddr = null;
	/* Column Info */
	private String sCntCd = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String nCustNm = null;
	/* Column Info */
	private String nCntCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KorCustInqInfoVO() {}

	public KorCustInqInfoVO(String ibflag, String pagerows, String bkgNo, String cstmsDeclTpCd, String trnsSeq, String sCntCd, String sCustSeq, String sCustNm, String sCustAddr, String cCntCd, String cCustSeq, String cCustNm, String cCustAddr, String nCntCd, String nCustSeq, String nCustNm, String nCustAddr, String userId, String portCd, String vvd, String oldCstmsDeclTpCd) {
		this.nCustSeq = nCustSeq;
		this.cCntCd = cCntCd;
		this.sCustSeq = sCustSeq;
		this.sCustNm = sCustNm;
		this.trnsSeq = trnsSeq;
		this.cCustNm = cCustNm;
		this.cCustSeq = cCustSeq;
		this.nCustAddr = nCustAddr;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.cCustAddr = cCustAddr;
		this.cstmsDeclTpCd = cstmsDeclTpCd;
		this.oldCstmsDeclTpCd = oldCstmsDeclTpCd;
		this.userId = userId;
		this.sCustAddr = sCustAddr;
		this.sCntCd = sCntCd;
		this.portCd = portCd;
		this.nCustNm = nCustNm;
		this.nCntCd = nCntCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("n_cust_seq", getNCustSeq());
		this.hashColumns.put("c_cnt_cd", getCCntCd());
		this.hashColumns.put("s_cust_seq", getSCustSeq());
		this.hashColumns.put("s_cust_nm", getSCustNm());
		this.hashColumns.put("trns_seq", getTrnsSeq());
		this.hashColumns.put("c_cust_nm", getCCustNm());
		this.hashColumns.put("c_cust_seq", getCCustSeq());
		this.hashColumns.put("n_cust_addr", getNCustAddr());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("c_cust_addr", getCCustAddr());
		this.hashColumns.put("cstms_decl_tp_cd", getCstmsDeclTpCd());
		this.hashColumns.put("old_cstms_decl_tp_cd", getOldCstmsDeclTpCd());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("s_cust_addr", getSCustAddr());
		this.hashColumns.put("s_cnt_cd", getSCntCd());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("n_cust_nm", getNCustNm());
		this.hashColumns.put("n_cnt_cd", getNCntCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("n_cust_seq", "nCustSeq");
		this.hashFields.put("c_cnt_cd", "cCntCd");
		this.hashFields.put("s_cust_seq", "sCustSeq");
		this.hashFields.put("s_cust_nm", "sCustNm");
		this.hashFields.put("trns_seq", "trnsSeq");
		this.hashFields.put("c_cust_nm", "cCustNm");
		this.hashFields.put("c_cust_seq", "cCustSeq");
		this.hashFields.put("n_cust_addr", "nCustAddr");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("c_cust_addr", "cCustAddr");
		this.hashFields.put("cstms_decl_tp_cd", "cstmsDeclTpCd");
		this.hashFields.put("old_cstms_decl_tp_cd", "oldCstmsDeclTpCd");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("s_cust_addr", "sCustAddr");
		this.hashFields.put("s_cnt_cd", "sCntCd");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("n_cust_nm", "nCustNm");
		this.hashFields.put("n_cnt_cd", "nCntCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return nCustSeq
	 */
	public String getNCustSeq() {
		return this.nCustSeq;
	}
	
	/**
	 * Column Info
	 * @return cCntCd
	 */
	public String getCCntCd() {
		return this.cCntCd;
	}
	
	/**
	 * Column Info
	 * @return sCustSeq
	 */
	public String getSCustSeq() {
		return this.sCustSeq;
	}
	
	/**
	 * Column Info
	 * @return sCustNm
	 */
	public String getSCustNm() {
		return this.sCustNm;
	}
	
	/**
	 * Column Info
	 * @return trnsSeq
	 */
	public String getTrnsSeq() {
		return this.trnsSeq;
	}
	
	/**
	 * Column Info
	 * @return cCustNm
	 */
	public String getCCustNm() {
		return this.cCustNm;
	}
	
	/**
	 * Column Info
	 * @return cCustSeq
	 */
	public String getCCustSeq() {
		return this.cCustSeq;
	}
	
	/**
	 * Column Info
	 * @return nCustAddr
	 */
	public String getNCustAddr() {
		return this.nCustAddr;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return cCustAddr
	 */
	public String getCCustAddr() {
		return this.cCustAddr;
	}
	
	/**
	 * Column Info
	 * @return cstmsDeclTpCd
	 */
	public String getCstmsDeclTpCd() {
		return this.cstmsDeclTpCd;
	}
	
	/**
	 * Column Info
	 * @return oldCstmsDeclTpCd
	 */
	public String getOldCstmsDeclTpCd() {
		return this.oldCstmsDeclTpCd;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return sCustAddr
	 */
	public String getSCustAddr() {
		return this.sCustAddr;
	}
	
	/**
	 * Column Info
	 * @return sCntCd
	 */
	public String getSCntCd() {
		return this.sCntCd;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return nCustNm
	 */
	public String getNCustNm() {
		return this.nCustNm;
	}
	
	/**
	 * Column Info
	 * @return nCntCd
	 */
	public String getNCntCd() {
		return this.nCntCd;
	}
	

	/**
	 * Column Info
	 * @param nCustSeq
	 */
	public void setNCustSeq(String nCustSeq) {
		this.nCustSeq = nCustSeq;
	}
	
	/**
	 * Column Info
	 * @param cCntCd
	 */
	public void setCCntCd(String cCntCd) {
		this.cCntCd = cCntCd;
	}
	
	/**
	 * Column Info
	 * @param sCustSeq
	 */
	public void setSCustSeq(String sCustSeq) {
		this.sCustSeq = sCustSeq;
	}
	
	/**
	 * Column Info
	 * @param sCustNm
	 */
	public void setSCustNm(String sCustNm) {
		this.sCustNm = sCustNm;
	}
	
	/**
	 * Column Info
	 * @param trnsSeq
	 */
	public void setTrnsSeq(String trnsSeq) {
		this.trnsSeq = trnsSeq;
	}
	
	/**
	 * Column Info
	 * @param cCustNm
	 */
	public void setCCustNm(String cCustNm) {
		this.cCustNm = cCustNm;
	}
	
	/**
	 * Column Info
	 * @param cCustSeq
	 */
	public void setCCustSeq(String cCustSeq) {
		this.cCustSeq = cCustSeq;
	}
	
	/**
	 * Column Info
	 * @param nCustAddr
	 */
	public void setNCustAddr(String nCustAddr) {
		this.nCustAddr = nCustAddr;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param cCustAddr
	 */
	public void setCCustAddr(String cCustAddr) {
		this.cCustAddr = cCustAddr;
	}
	
	/**
	 * Column Info
	 * @param cstmsDeclTpCd
	 */
	public void setCstmsDeclTpCd(String cstmsDeclTpCd) {
		this.cstmsDeclTpCd = cstmsDeclTpCd;
	}
	
	/**
	 * Column Info
	 * @param oldCstmsDeclTpCd
	 */
	public void setOldCstmsDeclTpCd(String oldCstmsDeclTpCd) {
		this.oldCstmsDeclTpCd = oldCstmsDeclTpCd;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param sCustAddr
	 */
	public void setSCustAddr(String sCustAddr) {
		this.sCustAddr = sCustAddr;
	}
	
	/**
	 * Column Info
	 * @param sCntCd
	 */
	public void setSCntCd(String sCntCd) {
		this.sCntCd = sCntCd;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param nCustNm
	 */
	public void setNCustNm(String nCustNm) {
		this.nCustNm = nCustNm;
	}
	
	/**
	 * Column Info
	 * @param nCntCd
	 */
	public void setNCntCd(String nCntCd) {
		this.nCntCd = nCntCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setNCustSeq(JSPUtil.getParameter(request, "n_cust_seq", ""));
		setCCntCd(JSPUtil.getParameter(request, "c_cnt_cd", ""));
		setSCustSeq(JSPUtil.getParameter(request, "s_cust_seq", ""));
		setSCustNm(JSPUtil.getParameter(request, "s_cust_nm", ""));
		setTrnsSeq(JSPUtil.getParameter(request, "trns_seq", ""));
		setCCustNm(JSPUtil.getParameter(request, "c_cust_nm", ""));
		setCCustSeq(JSPUtil.getParameter(request, "c_cust_seq", ""));
		setNCustAddr(JSPUtil.getParameter(request, "n_cust_addr", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCCustAddr(JSPUtil.getParameter(request, "c_cust_addr", ""));
		setCstmsDeclTpCd(JSPUtil.getParameter(request, "cstms_decl_tp_cd", ""));
		setOldCstmsDeclTpCd(JSPUtil.getParameter(request, "old_cstms_decl_tp_cd", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setSCustAddr(JSPUtil.getParameter(request, "s_cust_addr", ""));
		setSCntCd(JSPUtil.getParameter(request, "s_cnt_cd", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setNCustNm(JSPUtil.getParameter(request, "n_cust_nm", ""));
		setNCntCd(JSPUtil.getParameter(request, "n_cnt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorCustInqInfoVO[]
	 */
	public KorCustInqInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KorCustInqInfoVO[]
	 */
	public KorCustInqInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorCustInqInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] nCustSeq = (JSPUtil.getParameter(request, prefix	+ "n_cust_seq", length));
			String[] cCntCd = (JSPUtil.getParameter(request, prefix	+ "c_cnt_cd", length));
			String[] sCustSeq = (JSPUtil.getParameter(request, prefix	+ "s_cust_seq", length));
			String[] sCustNm = (JSPUtil.getParameter(request, prefix	+ "s_cust_nm", length));
			String[] trnsSeq = (JSPUtil.getParameter(request, prefix	+ "trns_seq", length));
			String[] cCustNm = (JSPUtil.getParameter(request, prefix	+ "c_cust_nm", length));
			String[] cCustSeq = (JSPUtil.getParameter(request, prefix	+ "c_cust_seq", length));
			String[] nCustAddr = (JSPUtil.getParameter(request, prefix	+ "n_cust_addr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cCustAddr = (JSPUtil.getParameter(request, prefix	+ "c_cust_addr", length));
			String[] cstmsDeclTpCd = (JSPUtil.getParameter(request, prefix	+ "cstms_decl_tp_cd", length));
			String[] oldCstmsDeclTpCd = (JSPUtil.getParameter(request, prefix	+ "old_cstms_decl_tp_cd", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] sCustAddr = (JSPUtil.getParameter(request, prefix	+ "s_cust_addr", length));
			String[] sCntCd = (JSPUtil.getParameter(request, prefix	+ "s_cnt_cd", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] nCustNm = (JSPUtil.getParameter(request, prefix	+ "n_cust_nm", length));
			String[] nCntCd = (JSPUtil.getParameter(request, prefix	+ "n_cnt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new KorCustInqInfoVO();
				if (nCustSeq[i] != null)
					model.setNCustSeq(nCustSeq[i]);
				if (cCntCd[i] != null)
					model.setCCntCd(cCntCd[i]);
				if (sCustSeq[i] != null)
					model.setSCustSeq(sCustSeq[i]);
				if (sCustNm[i] != null)
					model.setSCustNm(sCustNm[i]);
				if (trnsSeq[i] != null)
					model.setTrnsSeq(trnsSeq[i]);
				if (cCustNm[i] != null)
					model.setCCustNm(cCustNm[i]);
				if (cCustSeq[i] != null)
					model.setCCustSeq(cCustSeq[i]);
				if (nCustAddr[i] != null)
					model.setNCustAddr(nCustAddr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cCustAddr[i] != null)
					model.setCCustAddr(cCustAddr[i]);
				if (cstmsDeclTpCd[i] != null)
					model.setCstmsDeclTpCd(cstmsDeclTpCd[i]);
				if (oldCstmsDeclTpCd[i] != null)
					model.setOldCstmsDeclTpCd(oldCstmsDeclTpCd[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (sCustAddr[i] != null)
					model.setSCustAddr(sCustAddr[i]);
				if (sCntCd[i] != null)
					model.setSCntCd(sCntCd[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (nCustNm[i] != null)
					model.setNCustNm(nCustNm[i]);
				if (nCntCd[i] != null)
					model.setNCntCd(nCntCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorCustInqInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorCustInqInfoVO[]
	 */
	public KorCustInqInfoVO[] getKorCustInqInfoVOs(){
		KorCustInqInfoVO[] vos = (KorCustInqInfoVO[])models.toArray(new KorCustInqInfoVO[models.size()]);
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
		this.nCustSeq = this.nCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCntCd = this.cCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustSeq = this.sCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustNm = this.sCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsSeq = this.trnsSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCustNm = this.cCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCustSeq = this.cCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nCustAddr = this.nCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCustAddr = this.cCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDeclTpCd = this.cstmsDeclTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldCstmsDeclTpCd = this.oldCstmsDeclTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustAddr = this.sCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCntCd = this.sCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nCustNm = this.nCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nCntCd = this.nCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

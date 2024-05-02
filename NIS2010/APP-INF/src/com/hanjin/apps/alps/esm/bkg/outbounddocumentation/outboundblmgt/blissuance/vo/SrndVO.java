/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SrndVO.java
*@FileTitle : SrndVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.08.03 이진서 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이진서
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SrndVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SrndVO> models = new ArrayList<SrndVO>();

	private SignOnUserAccount 	account	= null;//사용자 정보

	/**
	 * @return the account
	 */
	public SignOnUserAccount getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(SignOnUserAccount account) {
		this.account = account;
	}

	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String oblIssDt = null;
	/* Column Info */
	private String oblIssKnt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String blTpCd = null;
	/* Column Info */
	private String oblRdemKnt = null;
	/* Column Info */
	private String oblRlseFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String oblSrndFlg = null;
	/* Column Info */
	private String oblRdemDt = null;
	/* Column Info */
	private String oblRdemUsrId = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String custToOrdFlg = null;
	/* Column Info */
	private String oblRdemOfcCd = null;
	/* Column Info */
	private String doIsuue = null;
	/* Column Info */
	private String oblIssOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SrndVO() {}

	public SrndVO(String ibflag, String pagerows, String bkgNo, String blNo, String oblRdemOfcCd, String oblRdemDt, String oblRdemKnt, String oblRdemUsrId, String diffRmk, String oblSrndFlg, String oblIssKnt, String oblRlseFlg, String blTpCd, String custToOrdFlg, String delCd, String bkgStsCd, String oblIssDt, String oblIssOfcCd, String doIsuue, String cntCd) {
		this.bkgStsCd = bkgStsCd;
		this.delCd = delCd;
		this.oblIssDt = oblIssDt;
		this.oblIssKnt = oblIssKnt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.blTpCd = blTpCd;
		this.oblRdemKnt = oblRdemKnt;
		this.oblRlseFlg = oblRlseFlg;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.diffRmk = diffRmk;
		this.oblSrndFlg = oblSrndFlg;
		this.oblRdemDt = oblRdemDt;
		this.oblRdemUsrId = oblRdemUsrId;
		this.cntCd = cntCd;
		this.custToOrdFlg = custToOrdFlg;
		this.oblRdemOfcCd = oblRdemOfcCd;
		this.doIsuue = doIsuue;
		this.oblIssOfcCd = oblIssOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("obl_iss_dt", getOblIssDt());
		this.hashColumns.put("obl_iss_knt", getOblIssKnt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bl_tp_cd", getBlTpCd());
		this.hashColumns.put("obl_rdem_knt", getOblRdemKnt());
		this.hashColumns.put("obl_rlse_flg", getOblRlseFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("obl_srnd_flg", getOblSrndFlg());
		this.hashColumns.put("obl_rdem_dt", getOblRdemDt());
		this.hashColumns.put("obl_rdem_usr_id", getOblRdemUsrId());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("cust_to_ord_flg", getCustToOrdFlg());
		this.hashColumns.put("obl_rdem_ofc_cd", getOblRdemOfcCd());
		this.hashColumns.put("do_isuue", getDoIsuue());
		this.hashColumns.put("obl_iss_ofc_cd", getOblIssOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("obl_iss_dt", "oblIssDt");
		this.hashFields.put("obl_iss_knt", "oblIssKnt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bl_tp_cd", "blTpCd");
		this.hashFields.put("obl_rdem_knt", "oblRdemKnt");
		this.hashFields.put("obl_rlse_flg", "oblRlseFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("obl_srnd_flg", "oblSrndFlg");
		this.hashFields.put("obl_rdem_dt", "oblRdemDt");
		this.hashFields.put("obl_rdem_usr_id", "oblRdemUsrId");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("cust_to_ord_flg", "custToOrdFlg");
		this.hashFields.put("obl_rdem_ofc_cd", "oblRdemOfcCd");
		this.hashFields.put("do_isuue", "doIsuue");
		this.hashFields.put("obl_iss_ofc_cd", "oblIssOfcCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return oblIssDt
	 */
	public String getOblIssDt() {
		return this.oblIssDt;
	}
	
	/**
	 * Column Info
	 * @return oblIssKnt
	 */
	public String getOblIssKnt() {
		return this.oblIssKnt;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return blTpCd
	 */
	public String getBlTpCd() {
		return this.blTpCd;
	}
	
	/**
	 * Column Info
	 * @return oblRdemKnt
	 */
	public String getOblRdemKnt() {
		return this.oblRdemKnt;
	}
	
	/**
	 * Column Info
	 * @return oblRlseFlg
	 */
	public String getOblRlseFlg() {
		return this.oblRlseFlg;
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
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
	}
	
	/**
	 * Column Info
	 * @return oblSrndFlg
	 */
	public String getOblSrndFlg() {
		return this.oblSrndFlg;
	}
	
	/**
	 * Column Info
	 * @return oblRdemDt
	 */
	public String getOblRdemDt() {
		return this.oblRdemDt;
	}
	
	/**
	 * Column Info
	 * @return oblRdemUsrId
	 */
	public String getOblRdemUsrId() {
		return this.oblRdemUsrId;
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
	 * @return custToOrdFlg
	 */
	public String getCustToOrdFlg() {
		return this.custToOrdFlg;
	}
	
	/**
	 * Column Info
	 * @return oblRdemOfcCd
	 */
	public String getOblRdemOfcCd() {
		return this.oblRdemOfcCd;
	}
	
	/**
	 * Column Info
	 * @return doIsuue
	 */
	public String getDoIsuue() {
		return this.doIsuue;
	}
	
	/**
	 * Column Info
	 * @return oblIssOfcCd
	 */
	public String getOblIssOfcCd() {
		return this.oblIssOfcCd;
	}
	

	/**
	 * Column Info
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param oblIssDt
	 */
	public void setOblIssDt(String oblIssDt) {
		this.oblIssDt = oblIssDt;
	}
	
	/**
	 * Column Info
	 * @param oblIssKnt
	 */
	public void setOblIssKnt(String oblIssKnt) {
		this.oblIssKnt = oblIssKnt;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
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
	 * Column Info
	 * @param blTpCd
	 */
	public void setBlTpCd(String blTpCd) {
		this.blTpCd = blTpCd;
	}
	
	/**
	 * Column Info
	 * @param oblRdemKnt
	 */
	public void setOblRdemKnt(String oblRdemKnt) {
		this.oblRdemKnt = oblRdemKnt;
	}
	
	/**
	 * Column Info
	 * @param oblRlseFlg
	 */
	public void setOblRlseFlg(String oblRlseFlg) {
		this.oblRlseFlg = oblRlseFlg;
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
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
	}
	
	/**
	 * Column Info
	 * @param oblSrndFlg
	 */
	public void setOblSrndFlg(String oblSrndFlg) {
		this.oblSrndFlg = oblSrndFlg;
	}
	
	/**
	 * Column Info
	 * @param oblRdemDt
	 */
	public void setOblRdemDt(String oblRdemDt) {
		this.oblRdemDt = oblRdemDt;
	}
	
	/**
	 * Column Info
	 * @param oblRdemUsrId
	 */
	public void setOblRdemUsrId(String oblRdemUsrId) {
		this.oblRdemUsrId = oblRdemUsrId;
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
	 * @param custToOrdFlg
	 */
	public void setCustToOrdFlg(String custToOrdFlg) {
		this.custToOrdFlg = custToOrdFlg;
	}
	
	/**
	 * Column Info
	 * @param oblRdemOfcCd
	 */
	public void setOblRdemOfcCd(String oblRdemOfcCd) {
		this.oblRdemOfcCd = oblRdemOfcCd;
	}
	
	/**
	 * Column Info
	 * @param doIsuue
	 */
	public void setDoIsuue(String doIsuue) {
		this.doIsuue = doIsuue;
	}
	
	/**
	 * Column Info
	 * @param oblIssOfcCd
	 */
	public void setOblIssOfcCd(String oblIssOfcCd) {
		this.oblIssOfcCd = oblIssOfcCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBkgStsCd(JSPUtil.getParameter(request, "bkg_sts_cd", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setOblIssDt(JSPUtil.getParameter(request, "obl_iss_dt", ""));
		setOblIssKnt(JSPUtil.getParameter(request, "obl_iss_knt", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setBlTpCd(JSPUtil.getParameter(request, "bl_tp_cd", ""));
		setOblRdemKnt(JSPUtil.getParameter(request, "obl_rdem_knt", ""));
		setOblRlseFlg(JSPUtil.getParameter(request, "obl_rlse_flg", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setDiffRmk(JSPUtil.getParameter(request, "diff_rmk", ""));
		setOblSrndFlg(JSPUtil.getParameter(request, "obl_srnd_flg", ""));
		setOblRdemDt(JSPUtil.getParameter(request, "obl_rdem_dt", ""));
		setOblRdemUsrId(JSPUtil.getParameter(request, "obl_rdem_usr_id", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setCustToOrdFlg(JSPUtil.getParameter(request, "cust_to_ord_flg", ""));
		setOblRdemOfcCd(JSPUtil.getParameter(request, "obl_rdem_ofc_cd", ""));
		setDoIsuue(JSPUtil.getParameter(request, "do_isuue", ""));
		setOblIssOfcCd(JSPUtil.getParameter(request, "obl_iss_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SrndVO[]
	 */
	public SrndVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SrndVO[]
	 */
	public SrndVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SrndVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] oblIssDt = (JSPUtil.getParameter(request, prefix	+ "obl_iss_dt", length));
			String[] oblIssKnt = (JSPUtil.getParameter(request, prefix	+ "obl_iss_knt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] blTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_tp_cd", length));
			String[] oblRdemKnt = (JSPUtil.getParameter(request, prefix	+ "obl_rdem_knt", length));
			String[] oblRlseFlg = (JSPUtil.getParameter(request, prefix	+ "obl_rlse_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] oblSrndFlg = (JSPUtil.getParameter(request, prefix	+ "obl_srnd_flg", length));
			String[] oblRdemDt = (JSPUtil.getParameter(request, prefix	+ "obl_rdem_dt", length));
			String[] oblRdemUsrId = (JSPUtil.getParameter(request, prefix	+ "obl_rdem_usr_id", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] custToOrdFlg = (JSPUtil.getParameter(request, prefix	+ "cust_to_ord_flg", length));
			String[] oblRdemOfcCd = (JSPUtil.getParameter(request, prefix	+ "obl_rdem_ofc_cd", length));
			String[] doIsuue = (JSPUtil.getParameter(request, prefix	+ "do_isuue", length));
			String[] oblIssOfcCd = (JSPUtil.getParameter(request, prefix	+ "obl_iss_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SrndVO();
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (oblIssDt[i] != null)
					model.setOblIssDt(oblIssDt[i]);
				if (oblIssKnt[i] != null)
					model.setOblIssKnt(oblIssKnt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (blTpCd[i] != null)
					model.setBlTpCd(blTpCd[i]);
				if (oblRdemKnt[i] != null)
					model.setOblRdemKnt(oblRdemKnt[i]);
				if (oblRlseFlg[i] != null)
					model.setOblRlseFlg(oblRlseFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (oblSrndFlg[i] != null)
					model.setOblSrndFlg(oblSrndFlg[i]);
				if (oblRdemDt[i] != null)
					model.setOblRdemDt(oblRdemDt[i]);
				if (oblRdemUsrId[i] != null)
					model.setOblRdemUsrId(oblRdemUsrId[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (custToOrdFlg[i] != null)
					model.setCustToOrdFlg(custToOrdFlg[i]);
				if (oblRdemOfcCd[i] != null)
					model.setOblRdemOfcCd(oblRdemOfcCd[i]);
				if (doIsuue[i] != null)
					model.setDoIsuue(doIsuue[i]);
				if (oblIssOfcCd[i] != null)
					model.setOblIssOfcCd(oblIssOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSrndVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SrndVO[]
	 */
	public SrndVO[] getSrndVOs(){
		SrndVO[] vos = (SrndVO[])models.toArray(new SrndVO[models.size()]);
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
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssDt = this.oblIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssKnt = this.oblIssKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTpCd = this.blTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRdemKnt = this.oblRdemKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRlseFlg = this.oblRlseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblSrndFlg = this.oblSrndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRdemDt = this.oblRdemDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRdemUsrId = this.oblRdemUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custToOrdFlg = this.custToOrdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRdemOfcCd = this.oblRdemOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doIsuue = this.doIsuue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssOfcCd = this.oblIssOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

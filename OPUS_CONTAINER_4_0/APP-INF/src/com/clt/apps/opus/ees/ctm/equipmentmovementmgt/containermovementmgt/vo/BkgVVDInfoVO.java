/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgVVDInfoVO.java
*@FileTitle : BkgVVDInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.04
*@LastModifier :
*@LastVersion : 1.0
* 2009.07.04
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgVVDInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<BkgVVDInfoVO> models = new ArrayList<BkgVVDInfoVO>();

	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String cnmvLvlNo = null;
	/* Column Info */
	private String aciacDivCd = null;
	/* Column Info */
	private String dmgFlg = null;
	/* Column Info */
	private String fcntrFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String dispFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rfubFlg = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String agmtCtyCd = null;
	/* Column Info */
	private String cntrHngrBarAtchKnt = null;
	/* Column Info */
	private String imdtExtFlg = null;
	/* Column Info */
	private String vslPrePstCd = null;
	/* Column Info */
	private String cntrHngrRckCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public BkgVVDInfoVO() {}

	public BkgVVDInfoVO(String ibflag, String pagerows, String cntrHngrBarAtchKnt, String cntrHngrRckCd, String aciacDivCd, String rfubFlg, String dispFlg, String imdtExtFlg, String cntrTpszCd, String agmtCtyCd, String agmtSeq, String dmgFlg, String cnmvLvlNo, String fcntrFlg, String vslPrePstCd) {
		this.agmtSeq = agmtSeq;
		this.cnmvLvlNo = cnmvLvlNo;
		this.aciacDivCd = aciacDivCd;
		this.dmgFlg = dmgFlg;
		this.fcntrFlg = fcntrFlg;
		this.pagerows = pagerows;
		this.dispFlg = dispFlg;
		this.ibflag = ibflag;
		this.rfubFlg = rfubFlg;
		this.cntrTpszCd = cntrTpszCd;
		this.agmtCtyCd = agmtCtyCd;
		this.cntrHngrBarAtchKnt = cntrHngrBarAtchKnt;
		this.imdtExtFlg = imdtExtFlg;
		this.vslPrePstCd = vslPrePstCd;
		this.cntrHngrRckCd = cntrHngrRckCd;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("cnmv_lvl_no", getCnmvLvlNo());
		this.hashColumns.put("aciac_div_cd", getAciacDivCd());
		this.hashColumns.put("dmg_flg", getDmgFlg());
		this.hashColumns.put("fcntr_flg", getFcntrFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("disp_flg", getDispFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rfub_flg", getRfubFlg());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());
		this.hashColumns.put("cntr_hngr_bar_atch_knt", getCntrHngrBarAtchKnt());
		this.hashColumns.put("imdt_ext_flg", getImdtExtFlg());
		this.hashColumns.put("vsl_pre_pst_cd", getVslPrePstCd());
		this.hashColumns.put("cntr_hngr_rck_cd", getCntrHngrRckCd());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("cnmv_lvl_no", "cnmvLvlNo");
		this.hashFields.put("aciac_div_cd", "aciacDivCd");
		this.hashFields.put("dmg_flg", "dmgFlg");
		this.hashFields.put("fcntr_flg", "fcntrFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("disp_flg", "dispFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rfub_flg", "rfubFlg");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("cntr_hngr_bar_atch_knt", "cntrHngrBarAtchKnt");
		this.hashFields.put("imdt_ext_flg", "imdtExtFlg");
		this.hashFields.put("vsl_pre_pst_cd", "vslPrePstCd");
		this.hashFields.put("cntr_hngr_rck_cd", "cntrHngrRckCd");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
	}

	/**
	 * Column Info
	 * @return cnmvLvlNo
	 */
	public String getCnmvLvlNo() {
		return this.cnmvLvlNo;
	}

	/**
	 * Column Info
	 * @return aciacDivCd
	 */
	public String getAciacDivCd() {
		return this.aciacDivCd;
	}

	/**
	 * Column Info
	 * @return dmgFlg
	 */
	public String getDmgFlg() {
		return this.dmgFlg;
	}

	/**
	 * Column Info
	 * @return fcntrFlg
	 */
	public String getFcntrFlg() {
		return this.fcntrFlg;
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
	 * @return dispFlg
	 */
	public String getDispFlg() {
		return this.dispFlg;
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
	 * @return rfubFlg
	 */
	public String getRfubFlg() {
		return this.rfubFlg;
	}

	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}

	/**
	 * Column Info
	 * @return agmtCtyCd
	 */
	public String getAgmtCtyCd() {
		return this.agmtCtyCd;
	}

	/**
	 * Column Info
	 * @return cntrHngrBarAtchKnt
	 */
	public String getCntrHngrBarAtchKnt() {
		return this.cntrHngrBarAtchKnt;
	}

	/**
	 * Column Info
	 * @return imdtExtFlg
	 */
	public String getImdtExtFlg() {
		return this.imdtExtFlg;
	}

	/**
	 * Column Info
	 * @return vslPrePstCd
	 */
	public String getVslPrePstCd() {
		return this.vslPrePstCd;
	}

	/**
	 * Column Info
	 * @return cntrHngrRckCd
	 */
	public String getCntrHngrRckCd() {
		return this.cntrHngrRckCd;
	}


	/**
	 * Column Info
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}

	/**
	 * Column Info
	 * @param cnmvLvlNo
	 */
	public void setCnmvLvlNo(String cnmvLvlNo) {
		this.cnmvLvlNo = cnmvLvlNo;
	}

	/**
	 * Column Info
	 * @param aciacDivCd
	 */
	public void setAciacDivCd(String aciacDivCd) {
		this.aciacDivCd = aciacDivCd;
	}

	/**
	 * Column Info
	 * @param dmgFlg
	 */
	public void setDmgFlg(String dmgFlg) {
		this.dmgFlg = dmgFlg;
	}

	/**
	 * Column Info
	 * @param fcntrFlg
	 */
	public void setFcntrFlg(String fcntrFlg) {
		this.fcntrFlg = fcntrFlg;
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
	 * @param dispFlg
	 */
	public void setDispFlg(String dispFlg) {
		this.dispFlg = dispFlg;
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
	 * @param rfubFlg
	 */
	public void setRfubFlg(String rfubFlg) {
		this.rfubFlg = rfubFlg;
	}

	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}

	/**
	 * Column Info
	 * @param agmtCtyCd
	 */
	public void setAgmtCtyCd(String agmtCtyCd) {
		this.agmtCtyCd = agmtCtyCd;
	}

	/**
	 * Column Info
	 * @param cntrHngrBarAtchKnt
	 */
	public void setCntrHngrBarAtchKnt(String cntrHngrBarAtchKnt) {
		this.cntrHngrBarAtchKnt = cntrHngrBarAtchKnt;
	}

	/**
	 * Column Info
	 * @param imdtExtFlg
	 */
	public void setImdtExtFlg(String imdtExtFlg) {
		this.imdtExtFlg = imdtExtFlg;
	}

	/**
	 * Column Info
	 * @param vslPrePstCd
	 */
	public void setVslPrePstCd(String vslPrePstCd) {
		this.vslPrePstCd = vslPrePstCd;
	}

	/**
	 * Column Info
	 * @param cntrHngrRckCd
	 */
	public void setCntrHngrRckCd(String cntrHngrRckCd) {
		this.cntrHngrRckCd = cntrHngrRckCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setCnmvLvlNo(JSPUtil.getParameter(request, "cnmv_lvl_no", ""));
		setAciacDivCd(JSPUtil.getParameter(request, "aciac_div_cd", ""));
		setDmgFlg(JSPUtil.getParameter(request, "dmg_flg", ""));
		setFcntrFlg(JSPUtil.getParameter(request, "fcntr_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDispFlg(JSPUtil.getParameter(request, "disp_flg", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRfubFlg(JSPUtil.getParameter(request, "rfub_flg", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request, "agmt_cty_cd", ""));
		setCntrHngrBarAtchKnt(JSPUtil.getParameter(request, "cntr_hngr_bar_atch_knt", ""));
		setImdtExtFlg(JSPUtil.getParameter(request, "imdt_ext_flg", ""));
		setVslPrePstCd(JSPUtil.getParameter(request, "vsl_pre_pst_cd", ""));
		setCntrHngrRckCd(JSPUtil.getParameter(request, "cntr_hngr_rck_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgVVDInfoVO[]
	 */
	public BkgVVDInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return BkgVVDInfoVO[]
	 */
	public BkgVVDInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgVVDInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] cnmvLvlNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_lvl_no", length));
			String[] aciacDivCd = (JSPUtil.getParameter(request, prefix	+ "aciac_div_cd", length));
			String[] dmgFlg = (JSPUtil.getParameter(request, prefix	+ "dmg_flg", length));
			String[] fcntrFlg = (JSPUtil.getParameter(request, prefix	+ "fcntr_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] dispFlg = (JSPUtil.getParameter(request, prefix	+ "disp_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rfubFlg = (JSPUtil.getParameter(request, prefix	+ "rfub_flg", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] agmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cty_cd", length));
			String[] cntrHngrBarAtchKnt = (JSPUtil.getParameter(request, prefix	+ "cntr_hngr_bar_atch_knt", length));
			String[] imdtExtFlg = (JSPUtil.getParameter(request, prefix	+ "imdt_ext_flg", length));
			String[] vslPrePstCd = (JSPUtil.getParameter(request, prefix	+ "vsl_pre_pst_cd", length));
			String[] cntrHngrRckCd = (JSPUtil.getParameter(request, prefix	+ "cntr_hngr_rck_cd", length));

			for (int i = 0; i < length; i++) {
				model = new BkgVVDInfoVO();
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (cnmvLvlNo[i] != null)
					model.setCnmvLvlNo(cnmvLvlNo[i]);
				if (aciacDivCd[i] != null)
					model.setAciacDivCd(aciacDivCd[i]);
				if (dmgFlg[i] != null)
					model.setDmgFlg(dmgFlg[i]);
				if (fcntrFlg[i] != null)
					model.setFcntrFlg(fcntrFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (dispFlg[i] != null)
					model.setDispFlg(dispFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rfubFlg[i] != null)
					model.setRfubFlg(rfubFlg[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (agmtCtyCd[i] != null)
					model.setAgmtCtyCd(agmtCtyCd[i]);
				if (cntrHngrBarAtchKnt[i] != null)
					model.setCntrHngrBarAtchKnt(cntrHngrBarAtchKnt[i]);
				if (imdtExtFlg[i] != null)
					model.setImdtExtFlg(imdtExtFlg[i]);
				if (vslPrePstCd[i] != null)
					model.setVslPrePstCd(vslPrePstCd[i]);
				if (cntrHngrRckCd[i] != null)
					model.setCntrHngrRckCd(cntrHngrRckCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgVVDInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgVVDInfoVO[]
	 */
	public BkgVVDInfoVO[] getBkgVVDInfoVOs(){
		BkgVVDInfoVO[] vos = (BkgVVDInfoVO[])models.toArray(new BkgVVDInfoVO[models.size()]);
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
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvLvlNo = this.cnmvLvlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aciacDivCd = this.aciacDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgFlg = this.dmgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcntrFlg = this.fcntrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispFlg = this.dispFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfubFlg = this.rfubFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd = this.agmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHngrBarAtchKnt = this.cntrHngrBarAtchKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdtExtFlg = this.imdtExtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslPrePstCd = this.vslPrePstCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHngrRckCd = this.cntrHngrRckCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvArGiroVO.java
*@FileTitle : InvArGiroVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.28
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.09.28 박정진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo;

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
 * @author 박정진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InvArGiroVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvArGiroVO> models = new ArrayList<InvArGiroVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String giroRmk = null;
	/* Column Info */
	private String blSrcNo = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String actCustSeq = null;
	/* Column Info */
	private String tvaGiroAmt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String sailArrDt = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String issDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String actCustCntCd = null;
	/* Column Info */
	private String splGiroAmt = null;
	/* Column Info */
	private String dueDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String giroNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InvArGiroVO() {}

	public InvArGiroVO(String ibflag, String pagerows, String giroNo, String blSrcNo, String arOfcCd, String actCustCntCd, String actCustSeq, String vslCd, String skdVoyNo, String skdDirCd, String sailArrDt, String splGiroAmt, String tvaGiroAmt, String issDt, String dueDt, String giroRmk, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.giroRmk = giroRmk;
		this.blSrcNo = blSrcNo;
		this.vslCd = vslCd;
		this.deltFlg = deltFlg;
		this.actCustSeq = actCustSeq;
		this.tvaGiroAmt = tvaGiroAmt;
		this.creDt = creDt;
		this.skdVoyNo = skdVoyNo;
		this.sailArrDt = sailArrDt;
		this.arOfcCd = arOfcCd;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.issDt = issDt;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.actCustCntCd = actCustCntCd;
		this.splGiroAmt = splGiroAmt;
		this.dueDt = dueDt;
		this.updUsrId = updUsrId;
		this.giroNo = giroNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("giro_rmk", getGiroRmk());
		this.hashColumns.put("bl_src_no", getBlSrcNo());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("act_cust_seq", getActCustSeq());
		this.hashColumns.put("tva_giro_amt", getTvaGiroAmt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("sail_arr_dt", getSailArrDt());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("iss_dt", getIssDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("act_cust_cnt_cd", getActCustCntCd());
		this.hashColumns.put("spl_giro_amt", getSplGiroAmt());
		this.hashColumns.put("due_dt", getDueDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("giro_no", getGiroNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("giro_rmk", "giroRmk");
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("act_cust_seq", "actCustSeq");
		this.hashFields.put("tva_giro_amt", "tvaGiroAmt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("iss_dt", "issDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("act_cust_cnt_cd", "actCustCntCd");
		this.hashFields.put("spl_giro_amt", "splGiroAmt");
		this.hashFields.put("due_dt", "dueDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("giro_no", "giroNo");
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
	 * @return giroRmk
	 */
	public String getGiroRmk() {
		return this.giroRmk;
	}
	
	/**
	 * Column Info
	 * @return blSrcNo
	 */
	public String getBlSrcNo() {
		return this.blSrcNo;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return actCustSeq
	 */
	public String getActCustSeq() {
		return this.actCustSeq;
	}
	
	/**
	 * Column Info
	 * @return tvaGiroAmt
	 */
	public String getTvaGiroAmt() {
		return this.tvaGiroAmt;
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
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return sailArrDt
	 */
	public String getSailArrDt() {
		return this.sailArrDt;
	}
	
	/**
	 * Column Info
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return issDt
	 */
	public String getIssDt() {
		return this.issDt;
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
	 * @return actCustCntCd
	 */
	public String getActCustCntCd() {
		return this.actCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return splGiroAmt
	 */
	public String getSplGiroAmt() {
		return this.splGiroAmt;
	}
	
	/**
	 * Column Info
	 * @return dueDt
	 */
	public String getDueDt() {
		return this.dueDt;
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
	 * @return giroNo
	 */
	public String getGiroNo() {
		return this.giroNo;
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
	 * @param giroRmk
	 */
	public void setGiroRmk(String giroRmk) {
		this.giroRmk = giroRmk;
	}
	
	/**
	 * Column Info
	 * @param blSrcNo
	 */
	public void setBlSrcNo(String blSrcNo) {
		this.blSrcNo = blSrcNo;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param actCustSeq
	 */
	public void setActCustSeq(String actCustSeq) {
		this.actCustSeq = actCustSeq;
	}
	
	/**
	 * Column Info
	 * @param tvaGiroAmt
	 */
	public void setTvaGiroAmt(String tvaGiroAmt) {
		this.tvaGiroAmt = tvaGiroAmt;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param sailArrDt
	 */
	public void setSailArrDt(String sailArrDt) {
		this.sailArrDt = sailArrDt;
	}
	
	/**
	 * Column Info
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param issDt
	 */
	public void setIssDt(String issDt) {
		this.issDt = issDt;
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
	 * @param actCustCntCd
	 */
	public void setActCustCntCd(String actCustCntCd) {
		this.actCustCntCd = actCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param splGiroAmt
	 */
	public void setSplGiroAmt(String splGiroAmt) {
		this.splGiroAmt = splGiroAmt;
	}
	
	/**
	 * Column Info
	 * @param dueDt
	 */
	public void setDueDt(String dueDt) {
		this.dueDt = dueDt;
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
	 * @param giroNo
	 */
	public void setGiroNo(String giroNo) {
		this.giroNo = giroNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setGiroRmk(JSPUtil.getParameter(request, "giro_rmk", ""));
		setBlSrcNo(JSPUtil.getParameter(request, "bl_src_no", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setActCustSeq(JSPUtil.getParameter(request, "act_cust_seq", ""));
		setTvaGiroAmt(JSPUtil.getParameter(request, "tva_giro_amt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setSailArrDt(JSPUtil.getParameter(request, "sail_arr_dt", ""));
		setArOfcCd(JSPUtil.getParameter(request, "ar_ofc_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIssDt(JSPUtil.getParameter(request, "iss_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setActCustCntCd(JSPUtil.getParameter(request, "act_cust_cnt_cd", ""));
		setSplGiroAmt(JSPUtil.getParameter(request, "spl_giro_amt", ""));
		setDueDt(JSPUtil.getParameter(request, "due_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setGiroNo(JSPUtil.getParameter(request, "giro_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvArGiroVO[]
	 */
	public InvArGiroVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvArGiroVO[]
	 */
	public InvArGiroVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvArGiroVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] giroRmk = (JSPUtil.getParameter(request, prefix	+ "giro_rmk", length));
			String[] blSrcNo = (JSPUtil.getParameter(request, prefix	+ "bl_src_no", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] actCustSeq = (JSPUtil.getParameter(request, prefix	+ "act_cust_seq", length));
			String[] tvaGiroAmt = (JSPUtil.getParameter(request, prefix	+ "tva_giro_amt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] sailArrDt = (JSPUtil.getParameter(request, prefix	+ "sail_arr_dt", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] issDt = (JSPUtil.getParameter(request, prefix	+ "iss_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] actCustCntCd = (JSPUtil.getParameter(request, prefix	+ "act_cust_cnt_cd", length));
			String[] splGiroAmt = (JSPUtil.getParameter(request, prefix	+ "spl_giro_amt", length));
			String[] dueDt = (JSPUtil.getParameter(request, prefix	+ "due_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] giroNo = (JSPUtil.getParameter(request, prefix	+ "giro_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvArGiroVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (giroRmk[i] != null)
					model.setGiroRmk(giroRmk[i]);
				if (blSrcNo[i] != null)
					model.setBlSrcNo(blSrcNo[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (actCustSeq[i] != null)
					model.setActCustSeq(actCustSeq[i]);
				if (tvaGiroAmt[i] != null)
					model.setTvaGiroAmt(tvaGiroAmt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (sailArrDt[i] != null)
					model.setSailArrDt(sailArrDt[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (issDt[i] != null)
					model.setIssDt(issDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (actCustCntCd[i] != null)
					model.setActCustCntCd(actCustCntCd[i]);
				if (splGiroAmt[i] != null)
					model.setSplGiroAmt(splGiroAmt[i]);
				if (dueDt[i] != null)
					model.setDueDt(dueDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (giroNo[i] != null)
					model.setGiroNo(giroNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvArGiroVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvArGiroVO[]
	 */
	public InvArGiroVO[] getInvArGiroVOs(){
		InvArGiroVO[] vos = (InvArGiroVO[])models.toArray(new InvArGiroVO[models.size()]);
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
		this.giroRmk = this.giroRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrcNo = this.blSrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustSeq = this.actCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tvaGiroAmt = this.tvaGiroAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt = this.sailArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt = this.issDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustCntCd = this.actCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splGiroAmt = this.splGiroAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDt = this.dueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.giroNo = this.giroNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

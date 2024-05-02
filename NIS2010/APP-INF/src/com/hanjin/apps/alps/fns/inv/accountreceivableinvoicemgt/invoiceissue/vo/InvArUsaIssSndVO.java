/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InvArUsaIssSndVO.java
*@FileTitle : InvArUsaIssSndVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.02
*@LastModifier : Do Soon Choi
*@LastVersion : 1.0
* 2015.02.02 Do Soon Choi 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author Do Soon Choi
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InvArUsaIssSndVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvArUsaIssSndVO> models = new ArrayList<InvArUsaIssSndVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String invIssSndTpCd = null;
	/* Column Info */
	private String blSrcNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String sailArrDt = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String invSndNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sndSeq = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String invSndCustNo = null;
	/* Column Info */
	private String invSndDt = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public InvArUsaIssSndVO() {}

	public InvArUsaIssSndVO(String ibflag, String pagerows, String blSrcNo, String sndSeq, String invIssSndTpCd, String invSndCustNo, String invSndDt, String invSndNo, String arOfcCd, String sailArrDt, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.invIssSndTpCd = invIssSndTpCd;
		this.blSrcNo = blSrcNo;
		this.creDt = creDt;
		this.sailArrDt = sailArrDt;
		this.arOfcCd = arOfcCd;
		this.pagerows = pagerows;
		this.invSndNo = invSndNo;
		this.ibflag = ibflag;
		this.sndSeq = sndSeq;
		this.creUsrId = creUsrId;
		this.invSndCustNo = invSndCustNo;
		this.invSndDt = invSndDt;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("inv_iss_snd_tp_cd", getInvIssSndTpCd());
		this.hashColumns.put("bl_src_no", getBlSrcNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("sail_arr_dt", getSailArrDt());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("inv_snd_no", getInvSndNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("snd_seq", getSndSeq());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("inv_snd_cust_no", getInvSndCustNo());
		this.hashColumns.put("inv_snd_dt", getInvSndDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("inv_iss_snd_tp_cd", "invIssSndTpCd");
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_snd_no", "invSndNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("snd_seq", "sndSeq");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("inv_snd_cust_no", "invSndCustNo");
		this.hashFields.put("inv_snd_dt", "invSndDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
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
	 * @return invIssSndTpCd
	 */
	public String getInvIssSndTpCd() {
		return this.invIssSndTpCd;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return invSndNo
	 */
	public String getInvSndNo() {
		return this.invSndNo;
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
	 * @return sndSeq
	 */
	public String getSndSeq() {
		return this.sndSeq;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return invSndCustNo
	 */
	public String getInvSndCustNo() {
		return this.invSndCustNo;
	}
	
	/**
	 * Column Info
	 * @return invSndDt
	 */
	public String getInvSndDt() {
		return this.invSndDt;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param invIssSndTpCd
	 */
	public void setInvIssSndTpCd(String invIssSndTpCd) {
		this.invIssSndTpCd = invIssSndTpCd;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param invSndNo
	 */
	public void setInvSndNo(String invSndNo) {
		this.invSndNo = invSndNo;
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
	 * @param sndSeq
	 */
	public void setSndSeq(String sndSeq) {
		this.sndSeq = sndSeq;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param invSndCustNo
	 */
	public void setInvSndCustNo(String invSndCustNo) {
		this.invSndCustNo = invSndCustNo;
	}
	
	/**
	 * Column Info
	 * @param invSndDt
	 */
	public void setInvSndDt(String invSndDt) {
		this.invSndDt = invSndDt;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setInvIssSndTpCd(JSPUtil.getParameter(request, prefix + "inv_iss_snd_tp_cd", ""));
		setBlSrcNo(JSPUtil.getParameter(request, prefix + "bl_src_no", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSailArrDt(JSPUtil.getParameter(request, prefix + "sail_arr_dt", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setInvSndNo(JSPUtil.getParameter(request, prefix + "inv_snd_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSndSeq(JSPUtil.getParameter(request, prefix + "snd_seq", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setInvSndCustNo(JSPUtil.getParameter(request, prefix + "inv_snd_cust_no", ""));
		setInvSndDt(JSPUtil.getParameter(request, prefix + "inv_snd_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvArUsaIssSndVO[]
	 */
	public InvArUsaIssSndVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvArUsaIssSndVO[]
	 */
	public InvArUsaIssSndVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvArUsaIssSndVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] invIssSndTpCd = (JSPUtil.getParameter(request, prefix	+ "inv_iss_snd_tp_cd", length));
			String[] blSrcNo = (JSPUtil.getParameter(request, prefix	+ "bl_src_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] sailArrDt = (JSPUtil.getParameter(request, prefix	+ "sail_arr_dt", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] invSndNo = (JSPUtil.getParameter(request, prefix	+ "inv_snd_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sndSeq = (JSPUtil.getParameter(request, prefix	+ "snd_seq", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] invSndCustNo = (JSPUtil.getParameter(request, prefix	+ "inv_snd_cust_no", length));
			String[] invSndDt = (JSPUtil.getParameter(request, prefix	+ "inv_snd_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvArUsaIssSndVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (invIssSndTpCd[i] != null)
					model.setInvIssSndTpCd(invIssSndTpCd[i]);
				if (blSrcNo[i] != null)
					model.setBlSrcNo(blSrcNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (sailArrDt[i] != null)
					model.setSailArrDt(sailArrDt[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (invSndNo[i] != null)
					model.setInvSndNo(invSndNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sndSeq[i] != null)
					model.setSndSeq(sndSeq[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (invSndCustNo[i] != null)
					model.setInvSndCustNo(invSndCustNo[i]);
				if (invSndDt[i] != null)
					model.setInvSndDt(invSndDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvArUsaIssSndVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvArUsaIssSndVO[]
	 */
	public InvArUsaIssSndVO[] getInvArUsaIssSndVOs(){
		InvArUsaIssSndVO[] vos = (InvArUsaIssSndVO[])models.toArray(new InvArUsaIssSndVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIssSndTpCd = this.invIssSndTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrcNo = this.blSrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt = this.sailArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSndNo = this.invSndNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndSeq = this.sndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSndCustNo = this.invSndCustNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSndDt = this.invSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

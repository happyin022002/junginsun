/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InterfaceCancelVO.java
*@FileTitle : InterfaceCancelVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.27
*@LastModifier : 추경원
*@LastVersion : 1.0
* 2009.10.27 추경원 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 추경원
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InterfaceCancelVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InterfaceCancelVO> models = new ArrayList<InterfaceCancelVO>();
	
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String estmUsdAmt = null;
	/* Column Info */
	private String rcvErrFlg = null;
	/* Column Info */
	private String maxAcSeq = null;
	/* Column Info */
	private String actIfLoclCommAmt = null;
	/* Column Info */
	private String ifFlg = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String agnCd = null;
	/* Column Info */
	private String curAcSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String actIfCommAmt = null;
	/* Column Info */
	private String acSeq = null;
	/* Column Info */
	private String actPreLoclCommAmt = null;
	/* Column Info */
	private String actCommAmt = null;
	/* Column Info */
	private String actPreCommAmt = null;
	/* Column Info */
	private String actLoclCommAmt = null;
	/* Column Info */
	private String acTpCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InterfaceCancelVO() {}

	public InterfaceCancelVO(String ibflag, String pagerows, String actPreCommAmt, String actCommAmt, String actIfCommAmt, String actPreLoclCommAmt, String actLoclCommAmt, String actIfLoclCommAmt, String bkgNo, String agnCd, String ioBndCd, String acTpCd, String acSeq, String ifFlg, String rcvErrFlg, String curAcSeq, String maxAcSeq, String updUsrId, String estmUsdAmt, String csrNo) {
		this.csrNo = csrNo;
		this.estmUsdAmt = estmUsdAmt;
		this.rcvErrFlg = rcvErrFlg;
		this.maxAcSeq = maxAcSeq;
		this.actIfLoclCommAmt = actIfLoclCommAmt;
		this.ifFlg = ifFlg;
		this.ioBndCd = ioBndCd;
		this.pagerows = pagerows;
		this.agnCd = agnCd;
		this.curAcSeq = curAcSeq;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.actIfCommAmt = actIfCommAmt;
		this.acSeq = acSeq;
		this.actPreLoclCommAmt = actPreLoclCommAmt;
		this.actCommAmt = actCommAmt;
		this.actPreCommAmt = actPreCommAmt;
		this.actLoclCommAmt = actLoclCommAmt;
		this.acTpCd = acTpCd;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("estm_usd_amt", getEstmUsdAmt());
		this.hashColumns.put("rcv_err_flg", getRcvErrFlg());
		this.hashColumns.put("max_ac_seq", getMaxAcSeq());
		this.hashColumns.put("act_if_locl_comm_amt", getActIfLoclCommAmt());
		this.hashColumns.put("if_flg", getIfFlg());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("agn_cd", getAgnCd());
		this.hashColumns.put("cur_ac_seq", getCurAcSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("act_if_comm_amt", getActIfCommAmt());
		this.hashColumns.put("ac_seq", getAcSeq());
		this.hashColumns.put("act_pre_locl_comm_amt", getActPreLoclCommAmt());
		this.hashColumns.put("act_comm_amt", getActCommAmt());
		this.hashColumns.put("act_pre_comm_amt", getActPreCommAmt());
		this.hashColumns.put("act_locl_comm_amt", getActLoclCommAmt());
		this.hashColumns.put("ac_tp_cd", getAcTpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("estm_usd_amt", "estmUsdAmt");
		this.hashFields.put("rcv_err_flg", "rcvErrFlg");
		this.hashFields.put("max_ac_seq", "maxAcSeq");
		this.hashFields.put("act_if_locl_comm_amt", "actIfLoclCommAmt");
		this.hashFields.put("if_flg", "ifFlg");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("agn_cd", "agnCd");
		this.hashFields.put("cur_ac_seq", "curAcSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("act_if_comm_amt", "actIfCommAmt");
		this.hashFields.put("ac_seq", "acSeq");
		this.hashFields.put("act_pre_locl_comm_amt", "actPreLoclCommAmt");
		this.hashFields.put("act_comm_amt", "actCommAmt");
		this.hashFields.put("act_pre_comm_amt", "actPreCommAmt");
		this.hashFields.put("act_locl_comm_amt", "actLoclCommAmt");
		this.hashFields.put("ac_tp_cd", "acTpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return csrNo
	 */
	public String getCsrNo() {
		return this.csrNo;
	}
	
	/**
	 * Column Info
	 * @return estmUsdAmt
	 */
	public String getEstmUsdAmt() {
		return this.estmUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return rcvErrFlg
	 */
	public String getRcvErrFlg() {
		return this.rcvErrFlg;
	}
	
	/**
	 * Column Info
	 * @return maxAcSeq
	 */
	public String getMaxAcSeq() {
		return this.maxAcSeq;
	}
	
	/**
	 * Column Info
	 * @return actIfLoclCommAmt
	 */
	public String getActIfLoclCommAmt() {
		return this.actIfLoclCommAmt;
	}
	
	/**
	 * Column Info
	 * @return ifFlg
	 */
	public String getIfFlg() {
		return this.ifFlg;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
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
	 * @return agnCd
	 */
	public String getAgnCd() {
		return this.agnCd;
	}
	
	/**
	 * Column Info
	 * @return curAcSeq
	 */
	public String getCurAcSeq() {
		return this.curAcSeq;
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
	 * @return actIfCommAmt
	 */
	public String getActIfCommAmt() {
		return this.actIfCommAmt;
	}
	
	/**
	 * Column Info
	 * @return acSeq
	 */
	public String getAcSeq() {
		return this.acSeq;
	}
	
	/**
	 * Column Info
	 * @return actPreLoclCommAmt
	 */
	public String getActPreLoclCommAmt() {
		return this.actPreLoclCommAmt;
	}
	
	/**
	 * Column Info
	 * @return actCommAmt
	 */
	public String getActCommAmt() {
		return this.actCommAmt;
	}
	
	/**
	 * Column Info
	 * @return actPreCommAmt
	 */
	public String getActPreCommAmt() {
		return this.actPreCommAmt;
	}
	
	/**
	 * Column Info
	 * @return actLoclCommAmt
	 */
	public String getActLoclCommAmt() {
		return this.actLoclCommAmt;
	}
	
	/**
	 * Column Info
	 * @return acTpCd
	 */
	public String getAcTpCd() {
		return this.acTpCd;
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
	 * @param csrNo
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}
	
	/**
	 * Column Info
	 * @param estmUsdAmt
	 */
	public void setEstmUsdAmt(String estmUsdAmt) {
		this.estmUsdAmt = estmUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param rcvErrFlg
	 */
	public void setRcvErrFlg(String rcvErrFlg) {
		this.rcvErrFlg = rcvErrFlg;
	}
	
	/**
	 * Column Info
	 * @param maxAcSeq
	 */
	public void setMaxAcSeq(String maxAcSeq) {
		this.maxAcSeq = maxAcSeq;
	}
	
	/**
	 * Column Info
	 * @param actIfLoclCommAmt
	 */
	public void setActIfLoclCommAmt(String actIfLoclCommAmt) {
		this.actIfLoclCommAmt = actIfLoclCommAmt;
	}
	
	/**
	 * Column Info
	 * @param ifFlg
	 */
	public void setIfFlg(String ifFlg) {
		this.ifFlg = ifFlg;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
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
	 * @param agnCd
	 */
	public void setAgnCd(String agnCd) {
		this.agnCd = agnCd;
	}
	
	/**
	 * Column Info
	 * @param curAcSeq
	 */
	public void setCurAcSeq(String curAcSeq) {
		this.curAcSeq = curAcSeq;
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
	 * @param actIfCommAmt
	 */
	public void setActIfCommAmt(String actIfCommAmt) {
		this.actIfCommAmt = actIfCommAmt;
	}
	
	/**
	 * Column Info
	 * @param acSeq
	 */
	public void setAcSeq(String acSeq) {
		this.acSeq = acSeq;
	}
	
	/**
	 * Column Info
	 * @param actPreLoclCommAmt
	 */
	public void setActPreLoclCommAmt(String actPreLoclCommAmt) {
		this.actPreLoclCommAmt = actPreLoclCommAmt;
	}
	
	/**
	 * Column Info
	 * @param actCommAmt
	 */
	public void setActCommAmt(String actCommAmt) {
		this.actCommAmt = actCommAmt;
	}
	
	/**
	 * Column Info
	 * @param actPreCommAmt
	 */
	public void setActPreCommAmt(String actPreCommAmt) {
		this.actPreCommAmt = actPreCommAmt;
	}
	
	/**
	 * Column Info
	 * @param actLoclCommAmt
	 */
	public void setActLoclCommAmt(String actLoclCommAmt) {
		this.actLoclCommAmt = actLoclCommAmt;
	}
	
	/**
	 * Column Info
	 * @param acTpCd
	 */
	public void setAcTpCd(String acTpCd) {
		this.acTpCd = acTpCd;
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
		setCsrNo(JSPUtil.getParameter(request, "csr_no", ""));
		setEstmUsdAmt(JSPUtil.getParameter(request, "estm_usd_amt", ""));
		setRcvErrFlg(JSPUtil.getParameter(request, "rcv_err_flg", ""));
		setMaxAcSeq(JSPUtil.getParameter(request, "max_ac_seq", ""));
		setActIfLoclCommAmt(JSPUtil.getParameter(request, "act_if_locl_comm_amt", ""));
		setIfFlg(JSPUtil.getParameter(request, "if_flg", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setAgnCd(JSPUtil.getParameter(request, "agn_cd", ""));
		setCurAcSeq(JSPUtil.getParameter(request, "cur_ac_seq", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setActIfCommAmt(JSPUtil.getParameter(request, "act_if_comm_amt", ""));
		setAcSeq(JSPUtil.getParameter(request, "ac_seq", ""));
		setActPreLoclCommAmt(JSPUtil.getParameter(request, "act_pre_locl_comm_amt", ""));
		setActCommAmt(JSPUtil.getParameter(request, "act_comm_amt", ""));
		setActPreCommAmt(JSPUtil.getParameter(request, "act_pre_comm_amt", ""));
		setActLoclCommAmt(JSPUtil.getParameter(request, "act_locl_comm_amt", ""));
		setAcTpCd(JSPUtil.getParameter(request, "ac_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InterfaceCancelVO[]
	 */
	public InterfaceCancelVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InterfaceCancelVO[]
	 */
	public InterfaceCancelVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InterfaceCancelVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] estmUsdAmt = (JSPUtil.getParameter(request, prefix	+ "estm_usd_amt", length));
			String[] rcvErrFlg = (JSPUtil.getParameter(request, prefix	+ "rcv_err_flg", length));
			String[] maxAcSeq = (JSPUtil.getParameter(request, prefix	+ "max_ac_seq", length));
			String[] actIfLoclCommAmt = (JSPUtil.getParameter(request, prefix	+ "act_if_locl_comm_amt", length));
			String[] ifFlg = (JSPUtil.getParameter(request, prefix	+ "if_flg", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] agnCd = (JSPUtil.getParameter(request, prefix	+ "agn_cd", length));
			String[] curAcSeq = (JSPUtil.getParameter(request, prefix	+ "cur_ac_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] actIfCommAmt = (JSPUtil.getParameter(request, prefix	+ "act_if_comm_amt", length));
			String[] acSeq = (JSPUtil.getParameter(request, prefix	+ "ac_seq", length));
			String[] actPreLoclCommAmt = (JSPUtil.getParameter(request, prefix	+ "act_pre_locl_comm_amt", length));
			String[] actCommAmt = (JSPUtil.getParameter(request, prefix	+ "act_comm_amt", length));
			String[] actPreCommAmt = (JSPUtil.getParameter(request, prefix	+ "act_pre_comm_amt", length));
			String[] actLoclCommAmt = (JSPUtil.getParameter(request, prefix	+ "act_locl_comm_amt", length));
			String[] acTpCd = (JSPUtil.getParameter(request, prefix	+ "ac_tp_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new InterfaceCancelVO();
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (estmUsdAmt[i] != null)
					model.setEstmUsdAmt(estmUsdAmt[i]);
				if (rcvErrFlg[i] != null)
					model.setRcvErrFlg(rcvErrFlg[i]);
				if (maxAcSeq[i] != null)
					model.setMaxAcSeq(maxAcSeq[i]);
				if (actIfLoclCommAmt[i] != null)
					model.setActIfLoclCommAmt(actIfLoclCommAmt[i]);
				if (ifFlg[i] != null)
					model.setIfFlg(ifFlg[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (agnCd[i] != null)
					model.setAgnCd(agnCd[i]);
				if (curAcSeq[i] != null)
					model.setCurAcSeq(curAcSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (actIfCommAmt[i] != null)
					model.setActIfCommAmt(actIfCommAmt[i]);
				if (acSeq[i] != null)
					model.setAcSeq(acSeq[i]);
				if (actPreLoclCommAmt[i] != null)
					model.setActPreLoclCommAmt(actPreLoclCommAmt[i]);
				if (actCommAmt[i] != null)
					model.setActCommAmt(actCommAmt[i]);
				if (actPreCommAmt[i] != null)
					model.setActPreCommAmt(actPreCommAmt[i]);
				if (actLoclCommAmt[i] != null)
					model.setActLoclCommAmt(actLoclCommAmt[i]);
				if (acTpCd[i] != null)
					model.setAcTpCd(acTpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInterfaceCancelVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InterfaceCancelVO[]
	 */
	public InterfaceCancelVO[] getInterfaceCancelVOs(){
		InterfaceCancelVO[] vos = (InterfaceCancelVO[])models.toArray(new InterfaceCancelVO[models.size()]);
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
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmUsdAmt = this.estmUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvErrFlg = this.rcvErrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxAcSeq = this.maxAcSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actIfLoclCommAmt = this.actIfLoclCommAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifFlg = this.ifFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCd = this.agnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.curAcSeq = this.curAcSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actIfCommAmt = this.actIfCommAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acSeq = this.acSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actPreLoclCommAmt = this.actPreLoclCommAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCommAmt = this.actCommAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actPreCommAmt = this.actPreCommAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actLoclCommAmt = this.actLoclCommAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acTpCd = this.acTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

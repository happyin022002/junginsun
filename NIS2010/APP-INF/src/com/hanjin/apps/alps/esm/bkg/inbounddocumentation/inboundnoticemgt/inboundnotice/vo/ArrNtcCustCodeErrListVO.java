/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ArrNtcCustCodeErrListVO.java
*@FileTitle : ArrNtcCustCodeErrListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.17
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2010.02.17 박만건 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박만건
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ArrNtcCustCodeErrListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ArrNtcCustCodeErrListVO> models = new ArrayList<ArrNtcCustCodeErrListVO>();
	
	/* Column Info */
	private String evlOfcCd = null;
	/* Column Info */
	private String custTpCdNm = null;
	/* Column Info */
	private String evlUsrId = null;
	/* Column Info */
	private String crtCdCreDt = null;
	/* Column Info */
	private String evlRstNm = null;
	/* Column Info */
	private String rowCount = null;
	/* Column Info */
	private String evlRstCd = null;
	/* Column Info */
	private String ibEvCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String hqEvCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String obEvCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cdCreDt = null;
	/* Column Info */
	private String cdInputUsrId = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String crtCd = null;
	/* Column Info */
	private String cdInputDt = null;
	/* Column Info */
	private String evlDt = null;
	/* Column Info */
	private String cdInputOfcCd = null;
	/* Column Info */
	private String bkgCustTpCd = null;
	/* Column Info */
	private String custTpCd = null;
	/* Column Info */
	private String errCd = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String wronginput2 = null;
	/* Column Info */
	private String cnt1 = null;
	/* Column Info */
	private String multi2 = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String notexisted = null;
	/* Column Info */
	private String evlRslt1 = null;
	/* Column Info */
	private String auto2 = null;
	/* Column Info */
	private String evlRslt3 = null;
	/* Column Info */
	private String notexisted2 = null;
	/* Column Info */
	private String evlRslt2 = null;
	/* Column Info */
	private String bb2 = null;
	/* Column Info */
	private String skip = null;
	/* Column Info */
	private String wronginput = null;
	/* Column Info */
	private String okay = null;
	/* Column Info */
	private String evlRslt4 = null;
	/* Column Info */
	private String evlRslt5 = null;
	/* Column Info */
	private String evlRslt6 = null;
	/* Column Info */
	private String multi = null;
	/* Column Info */
	private String auto = null;
	/* Column Info */
	private String okay2 = null;
	/* Column Info */
	private String skip2 = null;
	/* Column Info */
	private String bb = null;
	private String custToOrdFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ArrNtcCustCodeErrListVO() {}

	public ArrNtcCustCodeErrListVO(String ibflag, String pagerows, String blNo, String custTpCd, String custTpCdNm, String errCd, String crtCd, String cdCreDt, String evlRstCd, String evlRstNm, String cdInputOfcCd, String cdInputUsrId, String cdInputDt, String evlOfcCd, String evlUsrId, String evlDt, String obEvCd, String ibEvCd, String hqEvCd, String crtCdCreDt, String bkgNo, String bkgCustTpCd, String usrId, String rowCount, String bkgOfcCd, String rhqCd, String cnt1, String evlRslt1, String auto, String auto2, String evlRslt2, String okay, String okay2, String evlRslt3, String wronginput, String wronginput2, String evlRslt4, String notexisted, String notexisted2, String evlRslt5, String multi, String multi2, String evlRslt6, String skip, String skip2, String bb, String bb2,String custToOrdFlg) {
		this.evlOfcCd = evlOfcCd;
		this.custTpCdNm = custTpCdNm;
		this.evlUsrId = evlUsrId;
		this.crtCdCreDt = crtCdCreDt;
		this.evlRstNm = evlRstNm;
		this.rowCount = rowCount;
		this.evlRstCd = evlRstCd;
		this.ibEvCd = ibEvCd;
		this.blNo = blNo;
		this.hqEvCd = hqEvCd;
		this.pagerows = pagerows;
		this.bkgNo = bkgNo;
		this.obEvCd = obEvCd;
		this.ibflag = ibflag;
		this.cdCreDt = cdCreDt;
		this.cdInputUsrId = cdInputUsrId;
		this.usrId = usrId;
		this.crtCd = crtCd;
		this.cdInputDt = cdInputDt;
		this.evlDt = evlDt;
		this.cdInputOfcCd = cdInputOfcCd;
		this.bkgCustTpCd = bkgCustTpCd;
		this.custTpCd = custTpCd;
		this.errCd = errCd;
		this.bkgOfcCd = bkgOfcCd;
		this.wronginput2 = wronginput2;
		this.cnt1 = cnt1;
		this.multi2 = multi2;
		this.rhqCd = rhqCd;
		this.notexisted = notexisted;
		this.evlRslt1 = evlRslt1;
		this.auto2 = auto2;
		this.evlRslt3 = evlRslt3;
		this.notexisted2 = notexisted2;
		this.evlRslt2 = evlRslt2;
		this.bb2 = bb2;
		this.skip = skip;
		this.wronginput = wronginput;
		this.okay = okay;
		this.evlRslt4 = evlRslt4;
		this.evlRslt5 = evlRslt5;
		this.evlRslt6 = evlRslt6;
		this.multi = multi;
		this.auto = auto;
		this.okay2 = okay2;
		this.skip2 = skip2;
		this.bb = bb;
		this.custToOrdFlg = custToOrdFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("evl_ofc_cd", getEvlOfcCd());
		this.hashColumns.put("cust_tp_cd_nm", getCustTpCdNm());
		this.hashColumns.put("evl_usr_id", getEvlUsrId());
		this.hashColumns.put("crt_cd_cre_dt", getCrtCdCreDt());
		this.hashColumns.put("evl_rst_nm", getEvlRstNm());
		this.hashColumns.put("row_count", getRowCount());
		this.hashColumns.put("evl_rst_cd", getEvlRstCd());
		this.hashColumns.put("ib_ev_cd", getIbEvCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("hq_ev_cd", getHqEvCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ob_ev_cd", getObEvCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cd_cre_dt", getCdCreDt());
		this.hashColumns.put("cd_input_usr_id", getCdInputUsrId());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("crt_cd", getCrtCd());
		this.hashColumns.put("cd_input_dt", getCdInputDt());
		this.hashColumns.put("evl_dt", getEvlDt());
		this.hashColumns.put("cd_input_ofc_cd", getCdInputOfcCd());
		this.hashColumns.put("bkg_cust_tp_cd", getBkgCustTpCd());
		this.hashColumns.put("cust_tp_cd", getCustTpCd());
		this.hashColumns.put("err_cd", getErrCd());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("wronginput2", getWronginput2());
		this.hashColumns.put("cnt1", getCnt1());
		this.hashColumns.put("multi2", getMulti2());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("notexisted", getNotexisted());
		this.hashColumns.put("evl_rslt1", getEvlRslt1());
		this.hashColumns.put("auto2", getAuto2());
		this.hashColumns.put("evl_rslt3", getEvlRslt3());
		this.hashColumns.put("notexisted2", getNotexisted2());
		this.hashColumns.put("evl_rslt2", getEvlRslt2());
		this.hashColumns.put("bb2", getBb2());
		this.hashColumns.put("skip", getSkip());
		this.hashColumns.put("wronginput", getWronginput());
		this.hashColumns.put("okay", getOkay());
		this.hashColumns.put("evl_rslt4", getEvlRslt4());
		this.hashColumns.put("evl_rslt5", getEvlRslt5());
		this.hashColumns.put("evl_rslt6", getEvlRslt6());
		this.hashColumns.put("multi", getMulti());
		this.hashColumns.put("auto", getAuto());
		this.hashColumns.put("okay2", getOkay2());
		this.hashColumns.put("skip2", getSkip2());
		this.hashColumns.put("bb", getBb());
		this.hashColumns.put("cust_to_ord_flg", getCustToOrdFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("evl_ofc_cd", "evlOfcCd");
		this.hashFields.put("cust_tp_cd_nm", "custTpCdNm");
		this.hashFields.put("evl_usr_id", "evlUsrId");
		this.hashFields.put("crt_cd_cre_dt", "crtCdCreDt");
		this.hashFields.put("evl_rst_nm", "evlRstNm");
		this.hashFields.put("row_count", "rowCount");
		this.hashFields.put("evl_rst_cd", "evlRstCd");
		this.hashFields.put("ib_ev_cd", "ibEvCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("hq_ev_cd", "hqEvCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ob_ev_cd", "obEvCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cd_cre_dt", "cdCreDt");
		this.hashFields.put("cd_input_usr_id", "cdInputUsrId");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("crt_cd", "crtCd");
		this.hashFields.put("cd_input_dt", "cdInputDt");
		this.hashFields.put("evl_dt", "evlDt");
		this.hashFields.put("cd_input_ofc_cd", "cdInputOfcCd");
		this.hashFields.put("bkg_cust_tp_cd", "bkgCustTpCd");
		this.hashFields.put("cust_tp_cd", "custTpCd");
		this.hashFields.put("err_cd", "errCd");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("wronginput2", "wronginput2");
		this.hashFields.put("cnt1", "cnt1");
		this.hashFields.put("multi2", "multi2");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("notexisted", "notexisted");
		this.hashFields.put("evl_rslt1", "evlRslt1");
		this.hashFields.put("auto2", "auto2");
		this.hashFields.put("evl_rslt3", "evlRslt3");
		this.hashFields.put("notexisted2", "notexisted2");
		this.hashFields.put("evl_rslt2", "evlRslt2");
		this.hashFields.put("bb2", "bb2");
		this.hashFields.put("skip", "skip");
		this.hashFields.put("wronginput", "wronginput");
		this.hashFields.put("okay", "okay");
		this.hashFields.put("evl_rslt4", "evlRslt4");
		this.hashFields.put("evl_rslt5", "evlRslt5");
		this.hashFields.put("evl_rslt6", "evlRslt6");
		this.hashFields.put("multi", "multi");
		this.hashFields.put("auto", "auto");
		this.hashFields.put("okay2", "okay2");
		this.hashFields.put("skip2", "skip2");
		this.hashFields.put("bb", "bb");
		this.hashFields.put("cust_to_ord_flg", "custToOrdFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return evlOfcCd
	 */
	public String getEvlOfcCd() {
		return this.evlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return custTpCdNm
	 */
	public String getCustTpCdNm() {
		return this.custTpCdNm;
	}
	
	/**
	 * Column Info
	 * @return evlUsrId
	 */
	public String getEvlUsrId() {
		return this.evlUsrId;
	}
	
	/**
	 * Column Info
	 * @return crtCdCreDt
	 */
	public String getCrtCdCreDt() {
		return this.crtCdCreDt;
	}
	
	/**
	 * Column Info
	 * @return evlRstNm
	 */
	public String getEvlRstNm() {
		return this.evlRstNm;
	}
	
	/**
	 * Column Info
	 * @return rowCount
	 */
	public String getRowCount() {
		return this.rowCount;
	}
	
	/**
	 * Column Info
	 * @return evlRstCd
	 */
	public String getEvlRstCd() {
		return this.evlRstCd;
	}
	
	/**
	 * Column Info
	 * @return ibEvCd
	 */
	public String getIbEvCd() {
		return this.ibEvCd;
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
	 * @return hqEvCd
	 */
	public String getHqEvCd() {
		return this.hqEvCd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return obEvCd
	 */
	public String getObEvCd() {
		return this.obEvCd;
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
	 * @return cdCreDt
	 */
	public String getCdCreDt() {
		return this.cdCreDt;
	}
	
	/**
	 * Column Info
	 * @return cdInputUsrId
	 */
	public String getCdInputUsrId() {
		return this.cdInputUsrId;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return crtCd
	 */
	public String getCrtCd() {
		return this.crtCd;
	}
	
	/**
	 * Column Info
	 * @return cdInputDt
	 */
	public String getCdInputDt() {
		return this.cdInputDt;
	}
	
	/**
	 * Column Info
	 * @return evlDt
	 */
	public String getEvlDt() {
		return this.evlDt;
	}
	
	/**
	 * Column Info
	 * @return cdInputOfcCd
	 */
	public String getCdInputOfcCd() {
		return this.cdInputOfcCd;
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
	 * @return custTpCd
	 */
	public String getCustTpCd() {
		return this.custTpCd;
	}
	
	/**
	 * Column Info
	 * @return errCd
	 */
	public String getErrCd() {
		return this.errCd;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return wronginput2
	 */
	public String getWronginput2() {
		return this.wronginput2;
	}
	
	/**
	 * Column Info
	 * @return cnt1
	 */
	public String getCnt1() {
		return this.cnt1;
	}
	
	/**
	 * Column Info
	 * @return multi2
	 */
	public String getMulti2() {
		return this.multi2;
	}
	
	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return notexisted
	 */
	public String getNotexisted() {
		return this.notexisted;
	}
	
	/**
	 * Column Info
	 * @return evlRslt1
	 */
	public String getEvlRslt1() {
		return this.evlRslt1;
	}
	
	/**
	 * Column Info
	 * @return auto2
	 */
	public String getAuto2() {
		return this.auto2;
	}
	
	/**
	 * Column Info
	 * @return evlRslt3
	 */
	public String getEvlRslt3() {
		return this.evlRslt3;
	}
	
	/**
	 * Column Info
	 * @return notexisted2
	 */
	public String getNotexisted2() {
		return this.notexisted2;
	}
	
	/**
	 * Column Info
	 * @return evlRslt2
	 */
	public String getEvlRslt2() {
		return this.evlRslt2;
	}
	
	/**
	 * Column Info
	 * @return bb2
	 */
	public String getBb2() {
		return this.bb2;
	}
	
	/**
	 * Column Info
	 * @return skip
	 */
	public String getSkip() {
		return this.skip;
	}
	
	/**
	 * Column Info
	 * @return wronginput
	 */
	public String getWronginput() {
		return this.wronginput;
	}
	
	/**
	 * Column Info
	 * @return okay
	 */
	public String getOkay() {
		return this.okay;
	}
	
	/**
	 * Column Info
	 * @return evlRslt4
	 */
	public String getEvlRslt4() {
		return this.evlRslt4;
	}
	
	/**
	 * Column Info
	 * @return evlRslt5
	 */
	public String getEvlRslt5() {
		return this.evlRslt5;
	}
	
	/**
	 * Column Info
	 * @return evlRslt6
	 */
	public String getEvlRslt6() {
		return this.evlRslt6;
	}
	
	/**
	 * Column Info
	 * @return multi
	 */
	public String getMulti() {
		return this.multi;
	}
	
	/**
	 * Column Info
	 * @return auto
	 */
	public String getAuto() {
		return this.auto;
	}
	
	/**
	 * Column Info
	 * @return okay2
	 */
	public String getOkay2() {
		return this.okay2;
	}
	
	/**
	 * Column Info
	 * @return skip2
	 */
	public String getSkip2() {
		return this.skip2;
	}
	
	/**
	 * Column Info
	 * @return bb
	 */
	public String getBb() {
		return this.bb;
	}
	

	/**
	 * Column Info
	 * @param evlOfcCd
	 */
	public void setEvlOfcCd(String evlOfcCd) {
		this.evlOfcCd = evlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param custTpCdNm
	 */
	public void setCustTpCdNm(String custTpCdNm) {
		this.custTpCdNm = custTpCdNm;
	}
	
	/**
	 * Column Info
	 * @param evlUsrId
	 */
	public void setEvlUsrId(String evlUsrId) {
		this.evlUsrId = evlUsrId;
	}
	
	/**
	 * Column Info
	 * @param crtCdCreDt
	 */
	public void setCrtCdCreDt(String crtCdCreDt) {
		this.crtCdCreDt = crtCdCreDt;
	}
	
	/**
	 * Column Info
	 * @param evlRstNm
	 */
	public void setEvlRstNm(String evlRstNm) {
		this.evlRstNm = evlRstNm;
	}
	
	/**
	 * Column Info
	 * @param rowCount
	 */
	public void setRowCount(String rowCount) {
		this.rowCount = rowCount;
	}
	
	/**
	 * Column Info
	 * @param evlRstCd
	 */
	public void setEvlRstCd(String evlRstCd) {
		this.evlRstCd = evlRstCd;
	}
	
	/**
	 * Column Info
	 * @param ibEvCd
	 */
	public void setIbEvCd(String ibEvCd) {
		this.ibEvCd = ibEvCd;
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
	 * @param hqEvCd
	 */
	public void setHqEvCd(String hqEvCd) {
		this.hqEvCd = hqEvCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param obEvCd
	 */
	public void setObEvCd(String obEvCd) {
		this.obEvCd = obEvCd;
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
	 * @param cdCreDt
	 */
	public void setCdCreDt(String cdCreDt) {
		this.cdCreDt = cdCreDt;
	}
	
	/**
	 * Column Info
	 * @param cdInputUsrId
	 */
	public void setCdInputUsrId(String cdInputUsrId) {
		this.cdInputUsrId = cdInputUsrId;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param crtCd
	 */
	public void setCrtCd(String crtCd) {
		this.crtCd = crtCd;
	}
	
	/**
	 * Column Info
	 * @param cdInputDt
	 */
	public void setCdInputDt(String cdInputDt) {
		this.cdInputDt = cdInputDt;
	}
	
	/**
	 * Column Info
	 * @param evlDt
	 */
	public void setEvlDt(String evlDt) {
		this.evlDt = evlDt;
	}
	
	/**
	 * Column Info
	 * @param cdInputOfcCd
	 */
	public void setCdInputOfcCd(String cdInputOfcCd) {
		this.cdInputOfcCd = cdInputOfcCd;
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
	 * @param custTpCd
	 */
	public void setCustTpCd(String custTpCd) {
		this.custTpCd = custTpCd;
	}
	
	/**
	 * Column Info
	 * @param errCd
	 */
	public void setErrCd(String errCd) {
		this.errCd = errCd;
	}
	
	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param wronginput2
	 */
	public void setWronginput2(String wronginput2) {
		this.wronginput2 = wronginput2;
	}
	
	/**
	 * Column Info
	 * @param cnt1
	 */
	public void setCnt1(String cnt1) {
		this.cnt1 = cnt1;
	}
	
	/**
	 * Column Info
	 * @param multi2
	 */
	public void setMulti2(String multi2) {
		this.multi2 = multi2;
	}
	
	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param notexisted
	 */
	public void setNotexisted(String notexisted) {
		this.notexisted = notexisted;
	}
	
	/**
	 * Column Info
	 * @param evlRslt1
	 */
	public void setEvlRslt1(String evlRslt1) {
		this.evlRslt1 = evlRslt1;
	}
	
	/**
	 * Column Info
	 * @param auto2
	 */
	public void setAuto2(String auto2) {
		this.auto2 = auto2;
	}
	
	/**
	 * Column Info
	 * @param evlRslt3
	 */
	public void setEvlRslt3(String evlRslt3) {
		this.evlRslt3 = evlRslt3;
	}
	
	/**
	 * Column Info
	 * @param notexisted2
	 */
	public void setNotexisted2(String notexisted2) {
		this.notexisted2 = notexisted2;
	}
	
	/**
	 * Column Info
	 * @param evlRslt2
	 */
	public void setEvlRslt2(String evlRslt2) {
		this.evlRslt2 = evlRslt2;
	}
	
	/**
	 * Column Info
	 * @param bb2
	 */
	public void setBb2(String bb2) {
		this.bb2 = bb2;
	}
	
	/**
	 * Column Info
	 * @param skip
	 */
	public void setSkip(String skip) {
		this.skip = skip;
	}
		
	/**
	 * Column Info
	 * @param wronginput
	 */
	public void setWronginput(String wronginput) {
		this.wronginput = wronginput;
	}
	
	/**
	 * Column Info
	 * @param okay
	 */
	public void setOkay(String okay) {
		this.okay = okay;
	}
	
	/**
	 * Column Info
	 * @param evlRslt4
	 */
	public void setEvlRslt4(String evlRslt4) {
		this.evlRslt4 = evlRslt4;
	}
	
	/**
	 * Column Info
	 * @param evlRslt5
	 */
	public void setEvlRslt5(String evlRslt5) {
		this.evlRslt5 = evlRslt5;
	}
	
	/**
	 * Column Info
	 * @param evlRslt6
	 */
	public void setEvlRslt6(String evlRslt6) {
		this.evlRslt6 = evlRslt6;
	}
	
	/**
	 * Column Info
	 * @param multi
	 */
	public void setMulti(String multi) {
		this.multi = multi;
	}
	
	/**
	 * Column Info
	 * @param auto
	 */
	public void setAuto(String auto) {
		this.auto = auto;
	}
	
	/**
	 * Column Info
	 * @param okay2
	 */
	public void setOkay2(String okay2) {
		this.okay2 = okay2;
	}
	
	/**
	 * Column Info
	 * @param skip2
	 */
	public void setSkip2(String skip2) {
		this.skip2 = skip2;
	}
	
	/**
	 * Column Info
	 * @param bb
	 */
	public void setBb(String bb) {
		this.bb = bb;
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
		setEvlOfcCd(JSPUtil.getParameter(request, prefix + "evl_ofc_cd", ""));
		setCustTpCdNm(JSPUtil.getParameter(request, prefix + "cust_tp_cd_nm", ""));
		setEvlUsrId(JSPUtil.getParameter(request, prefix + "evl_usr_id", ""));
		setCrtCdCreDt(JSPUtil.getParameter(request, prefix + "crt_cd_cre_dt", ""));
		setEvlRstNm(JSPUtil.getParameter(request, prefix + "evl_rst_nm", ""));
		setRowCount(JSPUtil.getParameter(request, prefix + "row_count", ""));
		setEvlRstCd(JSPUtil.getParameter(request, prefix + "evl_rst_cd", ""));
		setIbEvCd(JSPUtil.getParameter(request, prefix + "ib_ev_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setHqEvCd(JSPUtil.getParameter(request, prefix + "hq_ev_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setObEvCd(JSPUtil.getParameter(request, prefix + "ob_ev_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCdCreDt(JSPUtil.getParameter(request, prefix + "cd_cre_dt", ""));
		setCdInputUsrId(JSPUtil.getParameter(request, prefix + "cd_input_usr_id", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setCrtCd(JSPUtil.getParameter(request, prefix + "crt_cd", ""));
		setCdInputDt(JSPUtil.getParameter(request, prefix + "cd_input_dt", ""));
		setEvlDt(JSPUtil.getParameter(request, prefix + "evl_dt", ""));
		setCdInputOfcCd(JSPUtil.getParameter(request, prefix + "cd_input_ofc_cd", ""));
		setBkgCustTpCd(JSPUtil.getParameter(request, prefix + "bkg_cust_tp_cd", ""));
		setCustTpCd(JSPUtil.getParameter(request, prefix + "cust_tp_cd", ""));
		setErrCd(JSPUtil.getParameter(request, prefix + "err_cd", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setWronginput2(JSPUtil.getParameter(request, prefix + "wronginput2", ""));
		setCnt1(JSPUtil.getParameter(request, prefix + "cnt1", ""));
		setMulti2(JSPUtil.getParameter(request, prefix + "multi2", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setNotexisted(JSPUtil.getParameter(request, prefix + "notexisted", ""));
		setEvlRslt1(JSPUtil.getParameter(request, prefix + "evl_rslt1", ""));
		setAuto2(JSPUtil.getParameter(request, prefix + "auto2", ""));
		setEvlRslt3(JSPUtil.getParameter(request, prefix + "evl_rslt3", ""));
		setNotexisted2(JSPUtil.getParameter(request, prefix + "notexisted2", ""));
		setEvlRslt2(JSPUtil.getParameter(request, prefix + "evl_rslt2", ""));
		setBb2(JSPUtil.getParameter(request, prefix + "bb2", ""));
		setSkip(JSPUtil.getParameter(request, prefix + "skip", ""));
		setWronginput(JSPUtil.getParameter(request, prefix + "wronginput", ""));
		setOkay(JSPUtil.getParameter(request, prefix + "okay", ""));
		setEvlRslt4(JSPUtil.getParameter(request, prefix + "evl_rslt4", ""));
		setEvlRslt5(JSPUtil.getParameter(request, prefix + "evl_rslt5", ""));
		setEvlRslt6(JSPUtil.getParameter(request, prefix + "evl_rslt6", ""));
		setMulti(JSPUtil.getParameter(request, prefix + "multi", ""));
		setAuto(JSPUtil.getParameter(request, prefix + "auto", ""));
		setOkay2(JSPUtil.getParameter(request, prefix + "okay2", ""));
		setSkip2(JSPUtil.getParameter(request, prefix + "skip2", ""));
		setBb(JSPUtil.getParameter(request, prefix + "bb", ""));
		setCustToOrdFlg(JSPUtil.getParameter(request, prefix + "cust_to_ord_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ArrNtcCustCodeErrListVO[]
	 */
	public ArrNtcCustCodeErrListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ArrNtcCustCodeErrListVO[]
	 */
	public ArrNtcCustCodeErrListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ArrNtcCustCodeErrListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] evlOfcCd = (JSPUtil.getParameter(request, prefix	+ "evl_ofc_cd", length));
			String[] custTpCdNm = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd_nm", length));
			String[] evlUsrId = (JSPUtil.getParameter(request, prefix	+ "evl_usr_id", length));
			String[] crtCdCreDt = (JSPUtil.getParameter(request, prefix	+ "crt_cd_cre_dt", length));
			String[] evlRstNm = (JSPUtil.getParameter(request, prefix	+ "evl_rst_nm", length));
			String[] rowCount = (JSPUtil.getParameter(request, prefix	+ "row_count", length));
			String[] evlRstCd = (JSPUtil.getParameter(request, prefix	+ "evl_rst_cd", length));
			String[] ibEvCd = (JSPUtil.getParameter(request, prefix	+ "ib_ev_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] hqEvCd = (JSPUtil.getParameter(request, prefix	+ "hq_ev_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] obEvCd = (JSPUtil.getParameter(request, prefix	+ "ob_ev_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cdCreDt = (JSPUtil.getParameter(request, prefix	+ "cd_cre_dt", length));
			String[] cdInputUsrId = (JSPUtil.getParameter(request, prefix	+ "cd_input_usr_id", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] crtCd = (JSPUtil.getParameter(request, prefix	+ "crt_cd", length));
			String[] cdInputDt = (JSPUtil.getParameter(request, prefix	+ "cd_input_dt", length));
			String[] evlDt = (JSPUtil.getParameter(request, prefix	+ "evl_dt", length));
			String[] cdInputOfcCd = (JSPUtil.getParameter(request, prefix	+ "cd_input_ofc_cd", length));
			String[] bkgCustTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cust_tp_cd", length));
			String[] custTpCd = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd", length));
			String[] errCd = (JSPUtil.getParameter(request, prefix	+ "err_cd", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] wronginput2 = (JSPUtil.getParameter(request, prefix	+ "wronginput2", length));
			String[] cnt1 = (JSPUtil.getParameter(request, prefix	+ "cnt1", length));
			String[] multi2 = (JSPUtil.getParameter(request, prefix	+ "multi2", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] notexisted = (JSPUtil.getParameter(request, prefix	+ "notexisted", length));
			String[] evlRslt1 = (JSPUtil.getParameter(request, prefix	+ "evl_rslt1", length));
			String[] auto2 = (JSPUtil.getParameter(request, prefix	+ "auto2", length));
			String[] evlRslt3 = (JSPUtil.getParameter(request, prefix	+ "evl_rslt3", length));
			String[] notexisted2 = (JSPUtil.getParameter(request, prefix	+ "notexisted2", length));
			String[] evlRslt2 = (JSPUtil.getParameter(request, prefix	+ "evl_rslt2", length));
			String[] bb2 = (JSPUtil.getParameter(request, prefix	+ "bb2", length));
			String[] skip = (JSPUtil.getParameter(request, prefix	+ "skip", length));
			String[] wronginput = (JSPUtil.getParameter(request, prefix	+ "wronginput", length));
			String[] okay = (JSPUtil.getParameter(request, prefix	+ "okay", length));
			String[] evlRslt4 = (JSPUtil.getParameter(request, prefix	+ "evl_rslt4", length));
			String[] evlRslt5 = (JSPUtil.getParameter(request, prefix	+ "evl_rslt5", length));
			String[] evlRslt6 = (JSPUtil.getParameter(request, prefix	+ "evl_rslt6", length));
			String[] multi = (JSPUtil.getParameter(request, prefix	+ "multi", length));
			String[] auto = (JSPUtil.getParameter(request, prefix	+ "auto", length));
			String[] okay2 = (JSPUtil.getParameter(request, prefix	+ "okay2", length));
			String[] skip2 = (JSPUtil.getParameter(request, prefix	+ "skip2", length));
			String[] bb = (JSPUtil.getParameter(request, prefix	+ "bb", length));
			String[] custToOrdFlg = (JSPUtil.getParameter(request, prefix	+ "cust_to_ord_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new ArrNtcCustCodeErrListVO();
				if (evlOfcCd[i] != null)
					model.setEvlOfcCd(evlOfcCd[i]);
				if (custTpCdNm[i] != null)
					model.setCustTpCdNm(custTpCdNm[i]);
				if (evlUsrId[i] != null)
					model.setEvlUsrId(evlUsrId[i]);
				if (crtCdCreDt[i] != null)
					model.setCrtCdCreDt(crtCdCreDt[i]);
				if (evlRstNm[i] != null)
					model.setEvlRstNm(evlRstNm[i]);
				if (rowCount[i] != null)
					model.setRowCount(rowCount[i]);
				if (evlRstCd[i] != null)
					model.setEvlRstCd(evlRstCd[i]);
				if (ibEvCd[i] != null)
					model.setIbEvCd(ibEvCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (hqEvCd[i] != null)
					model.setHqEvCd(hqEvCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (obEvCd[i] != null)
					model.setObEvCd(obEvCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cdCreDt[i] != null)
					model.setCdCreDt(cdCreDt[i]);
				if (cdInputUsrId[i] != null)
					model.setCdInputUsrId(cdInputUsrId[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (crtCd[i] != null)
					model.setCrtCd(crtCd[i]);
				if (cdInputDt[i] != null)
					model.setCdInputDt(cdInputDt[i]);
				if (evlDt[i] != null)
					model.setEvlDt(evlDt[i]);
				if (cdInputOfcCd[i] != null)
					model.setCdInputOfcCd(cdInputOfcCd[i]);
				if (bkgCustTpCd[i] != null)
					model.setBkgCustTpCd(bkgCustTpCd[i]);
				if (custTpCd[i] != null)
					model.setCustTpCd(custTpCd[i]);
				if (errCd[i] != null)
					model.setErrCd(errCd[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (wronginput2[i] != null)
					model.setWronginput2(wronginput2[i]);
				if (cnt1[i] != null)
					model.setCnt1(cnt1[i]);
				if (multi2[i] != null)
					model.setMulti2(multi2[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (notexisted[i] != null)
					model.setNotexisted(notexisted[i]);
				if (evlRslt1[i] != null)
					model.setEvlRslt1(evlRslt1[i]);
				if (auto2[i] != null)
					model.setAuto2(auto2[i]);
				if (evlRslt3[i] != null)
					model.setEvlRslt3(evlRslt3[i]);
				if (notexisted2[i] != null)
					model.setNotexisted2(notexisted2[i]);
				if (evlRslt2[i] != null)
					model.setEvlRslt2(evlRslt2[i]);
				if (bb2[i] != null)
					model.setBb2(bb2[i]);
				if (skip[i] != null)
					model.setSkip(skip[i]);
				if (wronginput[i] != null)
					model.setWronginput(wronginput[i]);
				if (okay[i] != null)
					model.setOkay(okay[i]);
				if (evlRslt4[i] != null)
					model.setEvlRslt4(evlRslt4[i]);
				if (evlRslt5[i] != null)
					model.setEvlRslt5(evlRslt5[i]);
				if (evlRslt6[i] != null)
					model.setEvlRslt6(evlRslt6[i]);
				if (multi[i] != null)
					model.setMulti(multi[i]);
				if (auto[i] != null)
					model.setAuto(auto[i]);
				if (okay2[i] != null)
					model.setOkay2(okay2[i]);
				if (skip2[i] != null)
					model.setSkip2(skip2[i]);
				if (bb[i] != null)
					model.setBb(bb[i]);
				if (custToOrdFlg[i] != null)
					model.setCustToOrdFlg(custToOrdFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getArrNtcCustCodeErrListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ArrNtcCustCodeErrListVO[]
	 */
	public ArrNtcCustCodeErrListVO[] getArrNtcCustCodeErrListVOs(){
		ArrNtcCustCodeErrListVO[] vos = (ArrNtcCustCodeErrListVO[])models.toArray(new ArrNtcCustCodeErrListVO[models.size()]);
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
		this.evlOfcCd = this.evlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCdNm = this.custTpCdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evlUsrId = this.evlUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crtCdCreDt = this.crtCdCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evlRstNm = this.evlRstNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowCount = this.rowCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evlRstCd = this.evlRstCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibEvCd = this.ibEvCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hqEvCd = this.hqEvCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obEvCd = this.obEvCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cdCreDt = this.cdCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cdInputUsrId = this.cdInputUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crtCd = this.crtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cdInputDt = this.cdInputDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evlDt = this.evlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cdInputOfcCd = this.cdInputOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustTpCd = this.bkgCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCd = this.custTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errCd = this.errCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wronginput2 = this.wronginput2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnt1 = this.cnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.multi2 = this.multi2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.notexisted = this.notexisted .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evlRslt1 = this.evlRslt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.auto2 = this.auto2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evlRslt3 = this.evlRslt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.notexisted2 = this.notexisted2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evlRslt2 = this.evlRslt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb2 = this.bb2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skip = this.skip .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wronginput = this.wronginput .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.okay = this.okay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evlRslt4 = this.evlRslt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evlRslt5 = this.evlRslt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evlRslt6 = this.evlRslt6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.multi = this.multi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.auto = this.auto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.okay2 = this.okay2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skip2 = this.skip2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb = this.bb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custToOrdFlg = this.custToOrdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

	public String getCustToOrdFlg() {
		return custToOrdFlg;
	}

	public void setCustToOrdFlg(String custToOrdFlg) {
		this.custToOrdFlg = custToOrdFlg;
	}
}

/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortTariffCodeGRPVO.java
*@FileTitle : PortTariffCodeGRPVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 박명종
*@LastVersion : 1.0
* 2009.07.02 박명종 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박명종
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PortTariffCodeGRPVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PortTariffCodeGRPVO> models = new ArrayList<PortTariffCodeGRPVO>();
	
	/* Column Info */
	private String combo5 = null;
	/* Column Info */
	private String combo4 = null;
	/* Column Info */
	private String csur = null;
	/* Column Info */
	private String combo3 = null;
	/* Column Info */
	private String combo2 = null;
	/* Column Info */
	private String combo1 = null;
	/* Column Info */
	private String ver = null;
	/* Column Info */
	private String toDate = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fromDate = null;
	/* Column Info */
	private String cdis = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String year = null;
	/* Column Info */
	private String portCd = null;
	
	private String type  = null;

	private String orgVndrNm  = null;

	private String ydChgNo  = null;

	private String ydChgVerSeq  = null;

	private String creUsrId  = null;

	private String cplsFlg  = null;

	private String uid  = null;
	/* Column Info */
	private String portTrfUrl = null;
	/* Column Info */
	private String portTrfRmk = null;
	
	
	private TariffBaseVO[] tariffBaseVO = null;
	private TariffBaseVO[] tariffListVO = null;
	private TariffBaseVO[] objListVO = null;

	private ConditionVO[] baseCondition = null;
	private ConditionVO[] tariffCondition = null;

	private TariffSurchargeVO[] tariffSurchargeVO = null;
	private TariffDiscountVO[] tariffDiscountVO = null;
	
	private ConditionVO[] surchargeCondition = null;
	private ConditionVO[] discountCondition = null;
	
	/*New*/
	private TariffBaseVO[] tariffBaseFomlCondVOs = null;
	private TariffBaseVO[] tariffBaseRegValVOs = null;
	private TariffBaseVO[] tariffBaseVOs = null;
	private TariffBaseVO[] tariffSurchargeVOs = null;
	private TariffBaseVO[] tariffDiscountVOs = null;
	
	
	private SignOnUserAccount account = null;


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

	/**
	 * @return the tariffBaseVO
	 */
	public TariffBaseVO[] getTariffBaseVO() {
		return tariffBaseVO;
	}

	/**
	 * @param tariffBaseVO the tariffBaseVO to set
	 */
	public void setTariffBaseVO(TariffBaseVO[] tariffBaseVO) {
		this.tariffBaseVO = tariffBaseVO;
	}

	/**
	 * @return the tariffListVO
	 */
	public TariffBaseVO[] getTariffListVO() {
		return tariffListVO;
	}

	/**
	 * @param tariffListVO the tariffListVO to set
	 */
	public void setTariffListVO(TariffBaseVO[] tariffListVO) {
		this.tariffListVO = tariffListVO;
	}

	/**
	 * @return the tariffSurchargeVO
	 */
	public TariffSurchargeVO[] getTariffSurchargeVO() {
		return tariffSurchargeVO;
	}

	/**
	 * @param tariffSurchargeVO the tariffSurchargeVO to set
	 */
	public void setTariffSurchargeVO(TariffSurchargeVO[] tariffSurchargeVO) {
		this.tariffSurchargeVO = tariffSurchargeVO;
	}

	/**
	 * @return the tariffDiscountVO
	 */
	public TariffDiscountVO[] getTariffDiscountVO() {
		return tariffDiscountVO;
	}

	/**
	 * @param tariffDiscountVO the tariffDiscountVO to set
	 */
	public void setTariffDiscountVO(TariffDiscountVO[] tariffDiscountVO) {
		this.tariffDiscountVO = tariffDiscountVO;
	}

	/**
	 * @return the baseCondition
	 */
	public ConditionVO[] getBaseCondition() {
		return baseCondition;
	}

	/**
	 * @param baseCondition the baseCondition to set
	 */
	public void setBaseCondition(ConditionVO[] baseCondition) {
		this.baseCondition = baseCondition;
	}

	/**
	 * @return the tariffCondition
	 */
	public ConditionVO[] getTariffCondition() {
		return tariffCondition;
	}

	/**
	 * @param tariffCondition the tariffCondition to set
	 */
	public void setTariffCondition(ConditionVO[] tariffCondition) {
		this.tariffCondition = tariffCondition;
	}

	/**
	 * @return the surchargeCondition
	 */
	public ConditionVO[] getSurchargeCondition() {
		return surchargeCondition;
	}

	/**
	 * @param surchargeCondition the surchargeCondition to set
	 */
	public void setSurchargeCondition(ConditionVO[] surchargeCondition) {
		this.surchargeCondition = surchargeCondition;
	}

	/**
	 * @return the discountCondition
	 */
	public ConditionVO[] getDiscountCondition() {
		return discountCondition;
	}

	/**
	 * @param discountCondition the discountCondition to set
	 */
	public void setDiscountCondition(ConditionVO[] discountCondition) {
		this.discountCondition = discountCondition;
	}

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PortTariffCodeGRPVO() {}

	public PortTariffCodeGRPVO(String ibflag, String pagerows, String combo1, String combo2, String combo3, String combo4, String combo5, String csur, String fromDate, String toDate, String cdis, String vndrSeq, String portCd, String year, String acctCd, String ver, String ofcCd, String orgVndrNm, String ydChgNo, String ydChgVerSeq, String creUsrId, String cplsFlg, String uid, String portTrfUrl, String portTrfRmk) {
		this.combo5 = combo5;
		this.combo4 = combo4;
		this.csur = csur;
		this.combo3 = combo3;
		this.combo2 = combo2;
		this.combo1 = combo1;
		this.ver = ver;
		this.toDate = toDate;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.fromDate = fromDate;
		this.cdis = cdis;
		this.vndrSeq = vndrSeq;
		this.acctCd = acctCd;
		this.year = year;
		this.portCd = portCd;
		this.orgVndrNm = orgVndrNm;
		this.ydChgNo = ydChgNo;
		this.ydChgVerSeq = ydChgVerSeq;
		this.creUsrId = creUsrId;
		this.cplsFlg = cplsFlg;
		this.uid = uid;
		this.portTrfUrl = portTrfUrl;
		this.portTrfRmk = portTrfRmk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("combo5", getCombo5());
		this.hashColumns.put("combo4", getCombo4());
		this.hashColumns.put("csur", getCsur());
		this.hashColumns.put("combo3", getCombo3());
		this.hashColumns.put("combo2", getCombo2());
		this.hashColumns.put("combo1", getCombo1());
		this.hashColumns.put("ver", getVer());
		this.hashColumns.put("to_date", getToDate());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("from_date", getFromDate());
		this.hashColumns.put("cdis", getCdis());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("year", getYear());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("org_vndr_nm", getOrgVndrNm());
		this.hashColumns.put("yd_chg_no", getYdChgNo());
		this.hashColumns.put("yd_chg_ver_seq", getYdChgVerSeq());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cpls_flg", getCplsFlg());
		this.hashColumns.put("uid", getUid());
		this.hashColumns.put("port_trf_url", getPortTrfUrl());
		this.hashColumns.put("port_trf_rmk", getPortTrfRmk());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("combo5", "combo5");
		this.hashFields.put("combo4", "combo4");
		this.hashFields.put("csur", "csur");
		this.hashFields.put("combo3", "combo3");
		this.hashFields.put("combo2", "combo2");
		this.hashFields.put("combo1", "combo1");
		this.hashFields.put("ver", "ver");
		this.hashFields.put("to_date", "toDate");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("from_date", "fromDate");
		this.hashFields.put("cdis", "cdis");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("year", "year");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("yd_chg_no", "ydChgNo");
		this.hashFields.put("yd_chg_ver_seq", "ydChgVerSeq");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cpls_flg", "cplsFlg");
		this.hashFields.put("uid", "uid");
		this.hashFields.put("port_trf_url", "portTrfUrl");
		this.hashFields.put("port_trf_rmk", "portTrfRmk");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return combo5
	 */
	public String getCombo5() {
		return this.combo5;
	}
	
	/**
	 * Column Info
	 * @return combo4
	 */
	public String getCombo4() {
		return this.combo4;
	}
	
	/**
	 * Column Info
	 * @return csur
	 */
	public String getCsur() {
		return this.csur;
	}
	
	/**
	 * Column Info
	 * @return combo3
	 */
	public String getCombo3() {
		return this.combo3;
	}
	
	/**
	 * Column Info
	 * @return combo2
	 */
	public String getCombo2() {
		return this.combo2;
	}
	
	/**
	 * Column Info
	 * @return combo1
	 */
	public String getCombo1() {
		return this.combo1;
	}
	
	/**
	 * Column Info
	 * @return ver
	 */
	public String getVer() {
		return this.ver;
	}
	
	/**
	 * Column Info
	 * @return toDate
	 */
	public String getToDate() {
		return this.toDate;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return fromDate
	 */
	public String getFromDate() {
		return this.fromDate;
	}
	
	/**
	 * Column Info
	 * @return cdis
	 */
	public String getCdis() {
		return this.cdis;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
	}
	
	/**
	 * Column Info
	 * @return year
	 */
	public String getYear() {
		return this.year;
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
	 * @return portTrfUrl
	 */
	public String getPortTrfUrl() {
		return this.portTrfUrl;
	}

	/**
	 * Column Info
	 * @return portTrfRmk
	 */
	public String getPortTrfRmk() {
		return this.portTrfRmk;
	}
	
	/**
	 * Column Info
	 * @param combo5
	 */
	public void setCombo5(String combo5) {
		this.combo5 = combo5;
	}
	
	/**
	 * Column Info
	 * @param combo4
	 */
	public void setCombo4(String combo4) {
		this.combo4 = combo4;
	}
	
	/**
	 * Column Info
	 * @param csur
	 */
	public void setCsur(String csur) {
		this.csur = csur;
	}
	
	/**
	 * Column Info
	 * @param combo3
	 */
	public void setCombo3(String combo3) {
		this.combo3 = combo3;
	}
	
	/**
	 * Column Info
	 * @param combo2
	 */
	public void setCombo2(String combo2) {
		this.combo2 = combo2;
	}
	
	/**
	 * Column Info
	 * @param combo1
	 */
	public void setCombo1(String combo1) {
		this.combo1 = combo1;
	}
	
	/**
	 * Column Info
	 * @param ver
	 */
	public void setVer(String ver) {
		this.ver = ver;
	}
	
	/**
	 * Column Info
	 * @param toDate
	 */
	public void setToDate(String toDate) {
		this.toDate = toDate;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param fromDate
	 */
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	
	/**
	 * Column Info
	 * @param cdis
	 */
	public void setCdis(String cdis) {
		this.cdis = cdis;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}
	
	/**
	 * Column Info
	 * @param year
	 */
	public void setYear(String year) {
		this.year = year;
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
	 * @param portTrfUrl
	 */
	public void setPortTrfUrl(String portTrfUrl) {
		this.portTrfUrl = portTrfUrl;
	}

	/**
	 * Column Info
	 * @param portTrfRmk
	 */
	public void setPortTrfRmk(String portTrfRmk) {
		this.portTrfRmk = portTrfRmk;
	}	
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCombo5(JSPUtil.getParameter(request, "combo5", ""));
		setCombo4(JSPUtil.getParameter(request, "combo4", ""));
		setCsur(JSPUtil.getParameter(request, "csur", ""));
		setCombo3(JSPUtil.getParameter(request, "combo3", ""));
		setCombo2(JSPUtil.getParameter(request, "combo2", ""));
		setCombo1(JSPUtil.getParameter(request, "combo1", ""));
		setVer(JSPUtil.getParameter(request, "ver", ""));
		setToDate(JSPUtil.getParameter(request, "to_date", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFromDate(JSPUtil.getParameter(request, "from_date", ""));
		setCdis(JSPUtil.getParameter(request, "cdis", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setYear(JSPUtil.getParameter(request, "year", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setOrgVndrNm(JSPUtil.getParameter(request, "org_vndr_nm", ""));
		setYdChgNo(JSPUtil.getParameter(request, "yd_chg_no", ""));
		setYdChgVerSeq(JSPUtil.getParameter(request, "yd_chg_ver_seq", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setCplsFlg(JSPUtil.getParameter(request, "cpls_flg", ""));
		setUid(JSPUtil.getParameter(request, "uid", ""));
		setPortTrfUrl(JSPUtil.getParameter(request, "port_trf_url", ""));
		setPortTrfRmk(JSPUtil.getParameter(request, "port_trf_rmk", ""));		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PortTariffCodeGRPVO[]
	 */
	public PortTariffCodeGRPVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PortTariffCodeGRPVO[]
	 */
	public PortTariffCodeGRPVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PortTariffCodeGRPVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] combo5 = (JSPUtil.getParameter(request, prefix	+ "combo5".trim(), length));
			String[] combo4 = (JSPUtil.getParameter(request, prefix	+ "combo4".trim(), length));
			String[] csur = (JSPUtil.getParameter(request, prefix	+ "csur".trim(), length));
			String[] combo3 = (JSPUtil.getParameter(request, prefix	+ "combo3".trim(), length));
			String[] combo2 = (JSPUtil.getParameter(request, prefix	+ "combo2".trim(), length));
			String[] combo1 = (JSPUtil.getParameter(request, prefix	+ "combo1".trim(), length));
			String[] ver = (JSPUtil.getParameter(request, prefix	+ "ver".trim(), length));
			String[] toDate = (JSPUtil.getParameter(request, prefix	+ "to_date".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] fromDate = (JSPUtil.getParameter(request, prefix	+ "from_date".trim(), length));
			String[] cdis = (JSPUtil.getParameter(request, prefix	+ "cdis".trim(), length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq".trim(), length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd".trim(), length));
			String[] year = (JSPUtil.getParameter(request, prefix	+ "year".trim(), length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd".trim(), length));
			String[] orgVndrNm = (JSPUtil.getParameter(request, prefix	+ "org_vndr_nm".trim(), length));
			String[] ydChgNo = (JSPUtil.getParameter(request, prefix	+ "yd_chg_no".trim(), length));
			String[] ydChgVerSeq = (JSPUtil.getParameter(request, prefix	+ "yd_chg_ver_seq".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] cplsFlg = (JSPUtil.getParameter(request, prefix	+ "cpls_flg".trim(), length));
			String[] uid = (JSPUtil.getParameter(request, prefix	+ "uid".trim(), length));
			String[] portTrfUrl = (JSPUtil.getParameter(request, prefix	+ "port_trf_url".trim(), length));
			String[] portTrfRmk = (JSPUtil.getParameter(request, prefix	+ "port_trf_rmk".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new PortTariffCodeGRPVO();
				if (combo5[i] != null)
					model.setCombo5(combo5[i]);
				if (combo4[i] != null)
					model.setCombo4(combo4[i]);
				if (csur[i] != null)
					model.setCsur(csur[i]);
				if (combo3[i] != null)
					model.setCombo3(combo3[i]);
				if (combo2[i] != null)
					model.setCombo2(combo2[i]);
				if (combo1[i] != null)
					model.setCombo1(combo1[i]);
				if (ver[i] != null)
					model.setVer(ver[i]);
				if (toDate[i] != null)
					model.setToDate(toDate[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fromDate[i] != null)
					model.setFromDate(fromDate[i]);
				if (cdis[i] != null)
					model.setCdis(cdis[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (year[i] != null)
					model.setYear(year[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (orgVndrNm[i] != null)
					model.setOrgVndrNm(orgVndrNm[i]);
				if (ydChgNo[i] != null)
					model.setYdChgNo(ydChgNo[i]);
				if (ydChgVerSeq[i] != null)
					model.setYdChgVerSeq(ydChgVerSeq[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cplsFlg[i] != null)
					model.setCplsFlg(cplsFlg[i]);
				if (uid[i] != null)
					model.setUid(uid[i]);
				if (portTrfUrl[i] != null)
					model.setPortTrfUrl(portTrfUrl[i]);
				if (portTrfRmk[i] != null)
					model.setPortTrfRmk(portTrfRmk[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPortTariffCodeGRPVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PortTariffCodeGRPVO[]
	 */
	public PortTariffCodeGRPVO[] getPortTariffCodeGRPVOs(){
		PortTariffCodeGRPVO[] vos = (PortTariffCodeGRPVO[])models.toArray(new PortTariffCodeGRPVO[models.size()]);
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
		this.combo5 = this.combo5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.combo4 = this.combo4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csur = this.csur .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.combo3 = this.combo3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.combo2 = this.combo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.combo1 = this.combo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ver = this.ver .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDate = this.toDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDate = this.fromDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cdis = this.cdis .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.year = this.year .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgVndrNm = this.orgVndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydChgNo = this.ydChgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydChgVerSeq = this.ydChgVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cplsFlg = this.cplsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uid = this.uid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portTrfUrl = this.portTrfUrl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
		this.portTrfRmk = this.portTrfRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");			
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	

	public void setOrgVndrNm(String orgVndrNm) {
		this.orgVndrNm = orgVndrNm;
	}

	public String getOrgVndrNm() {
		return orgVndrNm;
	}

	/**
	 * @param objListVO the objListVO to set
	 */
	public void setObjListVO(TariffBaseVO[] objListVO) {
		this.objListVO = objListVO;
	}

	/**
	 * @return the objListVO
	 */
	public TariffBaseVO[] getObjListVO() {
		return objListVO;
	}

	/**
	 * @return the ydChgNo
	 */
	public String getYdChgNo() {
		return ydChgNo;
	}

	/**
	 * @param ydChgNo the ydChgNo to set
	 */
	public void setYdChgNo(String ydChgNo) {
		this.ydChgNo = ydChgNo;
	}

	/**
	 * @return the ydChgVerSeq
	 */
	public String getYdChgVerSeq() {
		return ydChgVerSeq;
	}

	/**
	 * @param ydChgVerSeq the ydChgVerSeq to set
	 */
	public void setYdChgVerSeq(String ydChgVerSeq) {
		this.ydChgVerSeq = ydChgVerSeq;
	}

	/**
	 * @return the tariffBaseVOs
	 */
	public TariffBaseVO[] getTariffBaseVOs() {
		return tariffBaseVOs;
	}

	/**
	 * @param tariffBaseVOs the tariffBaseVOs to set
	 */
	public void setTariffBaseVOs(TariffBaseVO[] tariffBaseVOs) {
		this.tariffBaseVOs = tariffBaseVOs;
	}

	/**
	 * @return the tariffSurchargeVOs
	 */
	public TariffBaseVO[] getTariffSurchargeVOs() {
		return tariffSurchargeVOs;
	}

	/**
	 * @param tariffSurchargeVOs the tariffSurchargeVOs to set
	 */
	public void setTariffSurchargeVOs(TariffBaseVO[] tariffSurchargeVOs) {
		this.tariffSurchargeVOs = tariffSurchargeVOs;
	}

	/**
	 * @return the tariffDiscountVOs
	 */
	public TariffBaseVO[] getTariffDiscountVOs() {
		return tariffDiscountVOs;
	}

	/**
	 * @param tariffDiscountVOs the tariffDiscountVOs to set
	 */
	public void setTariffDiscountVOs(TariffBaseVO[] tariffDiscountVOs) {
		this.tariffDiscountVOs = tariffDiscountVOs;
	}

	/**
	 * @return the creUsrId
	 */
	public String getCreUsrId() {
		return creUsrId;
	}

	/**
	 * @param creUsrId the creUsrId to set
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	/**
	 * @return the cplsFlg
	 */
	public String getCplsFlg() {
		return cplsFlg;
	}

	/**
	 * @param cplsFlg the cplsFlg to set
	 */
	public void setCplsFlg(String cplsFlg) {
		this.cplsFlg = cplsFlg;
	}

	/**
	 * @return the tariffBaseFomlCondVOs
	 */
	public TariffBaseVO[] getTariffBaseFomlCondVOs() {
		return tariffBaseFomlCondVOs;
	}

	/**
	 * @param tariffBaseFomlCondVOs the tariffBaseFomlCondVOs to set
	 */
	public void setTariffBaseFomlCondVOs(TariffBaseVO[] tariffBaseFomlCondVOs) {
		this.tariffBaseFomlCondVOs = tariffBaseFomlCondVOs;
	}

	/**
	 * @return the tariffBaseRegValVOs
	 */
	public TariffBaseVO[] getTariffBaseRegValVOs() {
		return tariffBaseRegValVOs;
	}

	/**
	 * @param tariffBaseRegValVOs the tariffBaseRegValVOs to set
	 */
	public void setTariffBaseRegValVOs(TariffBaseVO[] tariffBaseRegValVOs) {
		this.tariffBaseRegValVOs = tariffBaseRegValVOs;
	}

	/**
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}

	/**
	 * @param uid the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}

}
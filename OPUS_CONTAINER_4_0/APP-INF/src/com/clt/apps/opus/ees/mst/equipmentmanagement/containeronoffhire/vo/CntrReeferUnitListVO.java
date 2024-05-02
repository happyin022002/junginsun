/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CntrReeferUnitListVO.java
*@FileTitle : CntrReeferUnitListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.20
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2010.10.20 남궁진호 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo;

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
 * @author 남궁진호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CntrReeferUnitListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CntrReeferUnitListVO> models = new ArrayList<CntrReeferUnitListVO>();
	/*  ****************** Retrieve Condition******** */
	/* Column Info */
	private String agmtCtyCd = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String stsFlg = null;
	/* Column Info */
	private String miFlg = null;
	/*  ****************** IBSheet******************* */
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rfMkrNm = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String ceflg = null;
	/* Column Info */
	private String minTemp = null;
	/* Column Info */
	private String onhDt = null;
	/* Column Info */
	private String rfMdlNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String maxTemp = null;
	/* Column Info */
	private String rfMkrSeq = null;
	/* Column Info */
	private String aeflg = null;
	/* Column Info */
	private String eeflg = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String beflg = null;
	/* Column Info */
	private String deflg = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String rfRfrNo = null;
	/*	Column Info	*/
	private  String	 rstr_usg_lbl   =  null;
	/*	Column Info	*/
	private  String	 ru_lable_type   =  null;
	/*	Column Info	*/
	private  String	 rfTpCd   =  null;
	/*	Column Info	*/
	private  String	 rfHumidCtrlValCd   =  null;
	/*	Column Info	*/
	private  String	 rfCmprCtnt   =  null;
	/*	Column Info	*/
	private  String	 rstrUsgLblTp   =  null;
	/*	Column Info	*/
	private  String	 rstrUsgLblDesc   =  null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CntrReeferUnitListVO() {}

	public CntrReeferUnitListVO(
			String ibflag, String pagerows, String cntrNo, String cntrTpszCd, String lstmCd, 
			String onhDt, String agmtNo, String vndrSeq, String rfMkrSeq, String rfMkrNm, 
			String rfMdlNm, String rfRfrNo, String minTemp, String maxTemp, String aeflg, 
			String beflg, String ceflg, String deflg, String eeflg, String agmtCtyCd, String agmtSeq, 
			String stsFlg, String miFlg,String rstr_usg_lbl,String ru_lable_type,String rfTpCd,String rfHumidCtrlValCd,String rfCmprCtnt,
			String rstrUsgLblTp,String rstrUsgLblDesc) {
		this.rfMkrNm = rfMkrNm;
		this.agmtNo = agmtNo;
		this.ceflg = ceflg;
		this.minTemp = minTemp;
		this.onhDt = onhDt;
		this.rfMdlNm = rfMdlNm;
		this.pagerows = pagerows;
		this.maxTemp = maxTemp;
		this.rfMkrSeq = rfMkrSeq;
		this.ibflag = ibflag;
		this.aeflg = aeflg;
		this.eeflg = eeflg;
		this.cntrNo = cntrNo;
		this.vndrSeq = vndrSeq;
		this.cntrTpszCd = cntrTpszCd;
		this.beflg = beflg;
		this.deflg = deflg;
		this.lstmCd = lstmCd;
		this.rfRfrNo = rfRfrNo;
		this.agmtCtyCd = agmtCtyCd;
		this.agmtSeq = agmtSeq;
		this.stsFlg = stsFlg;
		this.miFlg = miFlg;
		this.rstr_usg_lbl  = rstr_usg_lbl ;
		this.ru_lable_type  = ru_lable_type ;
		this.rfTpCd  = rfTpCd ;
		this.rfHumidCtrlValCd  = rfHumidCtrlValCd ;
		this.rfCmprCtnt  = rfCmprCtnt ;
		this.rstrUsgLblTp  = rstrUsgLblTp ;
		this.rstrUsgLblDesc  = rstrUsgLblDesc ;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rf_mkr_nm", getRfMkrNm());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("ceflg", getCeflg());
		this.hashColumns.put("min_temp", getMinTemp());
		this.hashColumns.put("onh_dt", getOnhDt());
		this.hashColumns.put("rf_mdl_nm", getRfMdlNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("max_temp", getMaxTemp());
		this.hashColumns.put("rf_mkr_seq", getRfMkrSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("aeflg", getAeflg());
		this.hashColumns.put("eeflg", getEeflg());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("beflg", getBeflg());
		this.hashColumns.put("deflg", getDeflg());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("rf_rfr_no", getRfRfrNo());
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("sts_flg", getStsFlg());
		this.hashColumns.put("mi_flg", getMiFlg());
		this.hashColumns.put("rstr_usg_lbl", getRstr_usg_lbl());		
		this.hashColumns.put("ru_lable_type", getRu_lable_type());	
		this.hashColumns.put("rf_tp_cd", getRfTpCd());		
		this.hashColumns.put("rf_humid_ctrl_val_cd", getRfHumidCtrlValCd());		
		this.hashColumns.put("rf_cmpr_ctnt", getRfCmprCtnt());		
		this.hashColumns.put("rstr_usg_lbl_tp", getRstrUsgLblTp());		
		this.hashColumns.put("rstr_usg_lbl_desc", getRstrUsgLblDesc());		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rf_mkr_nm", "rfMkrNm");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("ceflg", "ceflg");
		this.hashFields.put("min_temp", "minTemp");
		this.hashFields.put("onh_dt", "onhDt");
		this.hashFields.put("rf_mdl_nm", "rfMdlNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("max_temp", "maxTemp");
		this.hashFields.put("rf_mkr_seq", "rfMkrSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("aeflg", "aeflg");
		this.hashFields.put("eeflg", "eeflg");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("beflg", "beflg");
		this.hashFields.put("deflg", "deflg");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("rf_rfr_no", "rfRfrNo");
		this.hashFields.put("agmt_cty_cd","agmtCtyCd");
		this.hashFields.put("agmt_seq","agmtSeq");
		this.hashFields.put("sts_flg","stsFlg");
		this.hashFields.put("mi_flg", "miFlg");
		this.hashFields.put("rstr_usg_lbl", "rstr_usg_lbl");
		this.hashFields.put("ru_lable_type", "ru_lable_type");
		this.hashFields.put("rf_tp_cd", "rfTpCd");
		this.hashFields.put("rf_humid_ctrl_val_cd", "rfHumidCtrlValCd");
		this.hashFields.put("rf_cmpr_ctnt", "rfCmprCtnt");
		this.hashFields.put("rstr_usg_lbl_tp", "rstrUsgLblTp");
		this.hashFields.put("rstr_usg_lbl_desc", "rstrUsgLblDesc");
		return this.hashFields;
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
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
	}
	
	/**
	 * Column Info
	 * @return stsFlg
	 */
	public String getStsFlg() {
		return this.stsFlg;
	}
	
	/**
	 * Column Info
	 * @return miFlg
	 */
	public String getMiFlg() {
		return this.miFlg;
	}
	
	/**
	 * Column Info
	 * @return rfMkrNm
	 */
	public String getRfMkrNm() {
		return this.rfMkrNm;
	}
	
	/**
	 * Column Info
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
	}
	
	/**
	 * Column Info
	 * @return ceflg
	 */
	public String getCeflg() {
		return this.ceflg;
	}
	
	/**
	 * Column Info
	 * @return minTemp
	 */
	public String getMinTemp() {
		return this.minTemp;
	}
	
	/**
	 * Column Info
	 * @return onhDt
	 */
	public String getOnhDt() {
		return this.onhDt;
	}
	
	/**
	 * Column Info
	 * @return rfMdlNm
	 */
	public String getRfMdlNm() {
		return this.rfMdlNm;
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
	 * @return maxTemp
	 */
	public String getMaxTemp() {
		return this.maxTemp;
	}
	
	/**
	 * Column Info
	 * @return rfMkrSeq
	 */
	public String getRfMkrSeq() {
		return this.rfMkrSeq;
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
	 * @return aeflg
	 */
	public String getAeflg() {
		return this.aeflg;
	}
	
	/**
	 * Column Info
	 * @return eeflg
	 */
	public String getEeflg() {
		return this.eeflg;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return beflg
	 */
	public String getBeflg() {
		return this.beflg;
	}
	
	/**
	 * Column Info
	 * @return deflg
	 */
	public String getDeflg() {
		return this.deflg;
	}
	
	/**
	 * Column Info
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
	}
	
	/**
	 * Column Info
	 * @return rfRfrNo
	 */
	public String getRfRfrNo() {
		return this.rfRfrNo;
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
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}
	
	/**
	 * Column Info
	 * @param stsFlg
	 */
	public void setStsFlg(String stsFlg) {
		this.stsFlg = stsFlg;
	}
	
	/**
	 * Column Info
	 * @param miFlg
	 */
	public void setMiFlg(String miFlg) {
		this.miFlg = miFlg;
	}

	/**
	 * Column Info
	 * @param rfMkrNm
	 */
	public void setRfMkrNm(String rfMkrNm) {
		this.rfMkrNm = rfMkrNm;
	}
	
	/**
	 * Column Info
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}
	
	/**
	 * Column Info
	 * @param ceflg
	 */
	public void setCeflg(String ceflg) {
		this.ceflg = ceflg;
	}
	
	/**
	 * Column Info
	 * @param minTemp
	 */
	public void setMinTemp(String minTemp) {
		this.minTemp = minTemp;
	}
	
	/**
	 * Column Info
	 * @param onhDt
	 */
	public void setOnhDt(String onhDt) {
		this.onhDt = onhDt;
	}
	
	/**
	 * Column Info
	 * @param rfMdlNm
	 */
	public void setRfMdlNm(String rfMdlNm) {
		this.rfMdlNm = rfMdlNm;
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
	 * @param maxTemp
	 */
	public void setMaxTemp(String maxTemp) {
		this.maxTemp = maxTemp;
	}
	
	/**
	 * Column Info
	 * @param rfMkrSeq
	 */
	public void setRfMkrSeq(String rfMkrSeq) {
		this.rfMkrSeq = rfMkrSeq;
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
	 * @param aeflg
	 */
	public void setAeflg(String aeflg) {
		this.aeflg = aeflg;
	}
	
	/**
	 * Column Info
	 * @param eeflg
	 */
	public void setEeflg(String eeflg) {
		this.eeflg = eeflg;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param beflg
	 */
	public void setBeflg(String beflg) {
		this.beflg = beflg;
	}
	
	/**
	 * Column Info
	 * @param deflg
	 */
	public void setDeflg(String deflg) {
		this.deflg = deflg;
	}
	
	/**
	 * Column Info
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}
	
	/**
	 * Column Info
	 * @param rfRfrNo
	 */
	public void setRfRfrNo(String rfRfrNo) {
		this.rfRfrNo = rfRfrNo;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}
	
	/**
	* Column Info
	* @param  rstr_usg_lbl
	*/
	public void	setRstr_usg_lbl( String	rstr_usg_lbl ) {
		this.rstr_usg_lbl =	rstr_usg_lbl;
	}
 
	/**
	 * Column Info
	 * @return	rstr_usg_lbl
	 */
	 public	 String	getRstr_usg_lbl() {
		 return	this.rstr_usg_lbl;
	 } 
 	/**
	* Column Info
	* @param  ru_lable_type
	*/
	public void	setRu_lable_type( String	ru_lable_type ) {
		this.ru_lable_type =	ru_lable_type;
	}
 
	/**
	 * Column Info
	 * @return	ru_lable_type
	 */
	 public	 String	getRu_lable_type() {
		 return	this.ru_lable_type;
	 } 
	 
	 /**
	* Column Info
	* @param  rfTpCd
	*/
	public void	setRfTpCd( String	rfTpCd ) {
		this.rfTpCd =	rfTpCd;
	}
 
	/**
	 * Column Info
	 * @return	rfTpCd
	 */
	 public	 String	getRfTpCd() {
		 return	this.rfTpCd;
	 } 
 	/**
	* Column Info
	* @param  rfHumidCtrlValCd
	*/
	public void	setRfHumidCtrlValCd( String	rfHumidCtrlValCd ) {
		this.rfHumidCtrlValCd =	rfHumidCtrlValCd;
	}
 
	/**
	 * Column Info
	 * @return	rfHumidCtrlValCd
	 */
	 public	 String	getRfHumidCtrlValCd() {
		 return	this.rfHumidCtrlValCd;
	 } 
 	/**
	* Column Info
	* @param  rfCmprCtnt
	*/
	public void	setRfCmprCtnt( String	rfCmprCtnt ) {
		this.rfCmprCtnt =	rfCmprCtnt;
	}
 
	/**
	 * Column Info
	 * @return	rfCmprCtnt
	 */
	 public	 String	getRfCmprCtnt() {
		 return	this.rfCmprCtnt;
	 } 

	 /**
	* Column Info
	* @param  rstrUsgLblTp
	*/
	public void	setRstrUsgLblTp( String	rstrUsgLblTp ) {
		this.rstrUsgLblTp =	rstrUsgLblTp;
	}
 
	/**
	 * Column Info
	 * @return	rstrUsgLblTp
	 */
	 public	 String	getRstrUsgLblTp() {
		 return	this.rstrUsgLblTp;
	 } 
 	/**
	* Column Info
	* @param  rstrUsgLblDesc
	*/
	public void	setRstrUsgLblDesc( String	rstrUsgLblDesc ) {
		this.rstrUsgLblDesc =	rstrUsgLblDesc;
	}
 
	/**
	 * Column Info
	 * @return	rstrUsgLblDesc
	 */
	 public	 String	getRstrUsgLblDesc() {
		 return	this.rstrUsgLblDesc;
	 } 
	 
	 
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setLstmCd(JSPUtil.getParameter(request, prefix + "lstm_cd", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request, prefix + "agmt_cty_cd", ""));
		setAgmtSeq(JSPUtil.getParameter(request, prefix + "agmt_seq", ""));
		setStsFlg(JSPUtil.getParameter(request, prefix + "sts_flg", ""));
		setMiFlg(JSPUtil.getParameter(request, prefix + "mi_flg", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setRstr_usg_lbl(JSPUtil.getParameter(request,	prefix + "rstr_usg_lbl", ""));
		setRu_lable_type(JSPUtil.getParameter(request,	prefix + "ru_lable_type", ""));
		setRfTpCd(JSPUtil.getParameter(request,	prefix + "rf_tp_cd", ""));
		setRfHumidCtrlValCd(JSPUtil.getParameter(request,	prefix + "rf_humid_ctrl_val_cd", ""));
		setRfCmprCtnt(JSPUtil.getParameter(request,	prefix + "rf_cmpr_ctnt", ""));
		setRstrUsgLblTp(JSPUtil.getParameter(request,	prefix + "rstr_usg_lbl_tp", ""));
		setRstrUsgLblDesc(JSPUtil.getParameter(request,	prefix + "rstr_usg_lbl_desc", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return searchCntrReeferUnitInfoListVO[]
	 */
	public CntrReeferUnitListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return searchCntrReeferUnitInfoListVO[]
	 */
	public CntrReeferUnitListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CntrReeferUnitListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
		String arrCntrNo="";
		String arrLstmCd="";
		String arrTpsz="";
		String arrMkSeq="";
		String arrMdlNo="";
		String arrRfrNo="";
		String arrMinTemp="";
		String arrMaxTemp="";
		String arrRstrUsgLbl="";
		String arrRuLableType="";
		
		String arrRfTpCd="";
		String arrRfHumidCtrlValCd="";
		String arrRfCmprCtnt="";
		String arrRstrUsgLblTp="";
		String arrRstrUsgLblDesc="";
		
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] rfMkrSeq = (JSPUtil.getParameter(request, prefix	+ "rf_mkr_seq", length));
			String[] rfMdlNm = (JSPUtil.getParameter(request, prefix	+ "rf_mdl_nm", length));
			String[] rfRfrNo = (JSPUtil.getParameter(request, prefix	+ "rf_rfr_no", length));
			String[] minTemp = (JSPUtil.getParameter(request, prefix	+ "min_temp", length));
			String[] maxTemp = (JSPUtil.getParameter(request, prefix	+ "max_temp", length));
			String[] rstr_usg_lbl =	(JSPUtil.getParameter(request, prefix +	"rstr_usg_lbl".trim(),	length));
			String[] ru_lable_type =	(JSPUtil.getParameter(request, prefix +	"ru_lable_type".trim(),	length));
			String[] rfTpCd =	(JSPUtil.getParameter(request, prefix +	"rf_tp_cd".trim(),	length));
			String[] rfHumidCtrlValCd =	(JSPUtil.getParameter(request, prefix +	"rf_humid_ctrl_val_cd".trim(),	length));
			String[] rfCmprCtnt =	(JSPUtil.getParameter(request, prefix +	"rf_cmpr_ctnt".trim(),	length));
			String[] rstrUsgLblTp =	(JSPUtil.getParameter(request, prefix +	"rstr_usg_lbl_tp".trim(),	length));
			String[] rstrUsgLblDesc =	(JSPUtil.getParameter(request, prefix +	"rstr_usg_lbl_desc".trim(),	length));
			
			for (int i = 0; i < length; i++) {
				model = new CntrReeferUnitListVO();
				
				if (cntrNo[i] != null)					arrCntrNo=arrCntrNo+"|"+cntrNo[i];
				if (lstmCd[i] != null)					arrLstmCd=arrLstmCd+"|"+ lstmCd[i];
				if (cntrTpszCd[i] != null)				arrTpsz=arrTpsz+"|"+ cntrTpszCd[i];
				if (rfMkrSeq[i] != null)				arrMkSeq=arrMkSeq+"|"+rfMkrSeq[i];
				if (rfMdlNm[i] != null)					arrMdlNo=arrMdlNo+"|"+ rfMdlNm[i];
				if (rfRfrNo[i] != null)					arrRfrNo=arrRfrNo+"|"+ rfRfrNo[i];
				if (minTemp[i] != null)					arrMinTemp=arrMinTemp+"|"+ minTemp[i];
				if (maxTemp[i] != null)					arrMaxTemp=arrMaxTemp+"|"+ maxTemp[i];
				if (rstr_usg_lbl[i] != null)			arrRstrUsgLbl=arrRstrUsgLbl+"|"+ rstr_usg_lbl[i];
				if (ru_lable_type[i] != null)			arrRuLableType=arrRuLableType+"|"+ ru_lable_type[i];
				if (rfTpCd[i] != null)						arrRfTpCd=arrRfTpCd+"|"+ rfTpCd[i];
				if (rfHumidCtrlValCd[i] != null)			arrRfHumidCtrlValCd=arrRfHumidCtrlValCd+"|"+ rfHumidCtrlValCd[i];
				if (rfCmprCtnt[i] != null)			arrRfCmprCtnt=arrRfCmprCtnt+"|"+ rfCmprCtnt[i];
				if (rstrUsgLblTp[i] != null)			arrRstrUsgLblTp=arrRstrUsgLblTp+"|"+ rstrUsgLblTp[i];
				if (rstrUsgLblDesc[i] != null)			arrRstrUsgLblDesc=arrRstrUsgLblDesc+"|"+ rstrUsgLblDesc[i];

				if((i+1)%100==0){
					model.setCntrNo(arrCntrNo+"|");
 					model.setLstmCd(arrLstmCd+"|");
 					model.setCntrTpszCd(arrTpsz+"|");
					model.setRfMkrSeq(arrMkSeq+"|");
					model.setRfMdlNm(arrMdlNo+"|");
					model.setRfRfrNo(arrRfrNo+"|");
					model.setMinTemp(arrMinTemp+"|");
					model.setMaxTemp(arrMaxTemp+"|");
					model.setRstr_usg_lbl(arrRstrUsgLbl+"|");
					model.setRu_lable_type(arrRuLableType+"|");
					
					model.setRfTpCd(arrRfTpCd+"|");
					model.setRfHumidCtrlValCd(arrRfHumidCtrlValCd+"|");
					model.setRfCmprCtnt(arrRfCmprCtnt+"|");
					model.setRstrUsgLblTp(arrRstrUsgLblTp+"|");
					model.setRstrUsgLblDesc(arrRstrUsgLblDesc+"|");
					
					models.add(model);
					arrCntrNo="";
					arrLstmCd="";
					arrTpsz ="";
					arrMkSeq="";
					arrMdlNo="";
					arrRfrNo="";
					arrMinTemp="";
					arrMaxTemp="";
					arrRstrUsgLbl="";
					arrRuLableType="";
					
					arrRfTpCd="";
					arrRfHumidCtrlValCd="";
					arrRfCmprCtnt="";
					arrRstrUsgLblTp="";
					arrRstrUsgLblDesc="";

				}else if((i+1)/100==length/100 && (i+1)%100 > 0 && i+1==length) {
					model.setCntrNo(arrCntrNo+"|");
 					model.setLstmCd(arrLstmCd+"|");
 					model.setCntrTpszCd(arrTpsz+"|");
					model.setRfMkrSeq(arrMkSeq+"|");
					model.setRfMdlNm(arrMdlNo+"|");
					model.setRfRfrNo(arrRfrNo+"|");
					model.setMinTemp(arrMinTemp+"|");
					model.setMaxTemp(arrMaxTemp+"|");
					model.setRstr_usg_lbl(arrRstrUsgLbl+"|");
					model.setRu_lable_type(arrRuLableType+"|");
					model.setRfTpCd(arrRfTpCd+"|");
					model.setRfHumidCtrlValCd(arrRfHumidCtrlValCd+"|");
					model.setRfCmprCtnt(arrRfCmprCtnt+"|");
					model.setRstrUsgLblTp(arrRstrUsgLblTp+"|");
					model.setRstrUsgLblDesc(arrRstrUsgLblDesc+"|");

					models.add(model);
				}
			}

		} catch (Exception e) {
			return null;
		}
		return getCntrReeferUnitListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CntrReeferUnitInfoListVO[]
	 */
	public CntrReeferUnitListVO[] getCntrReeferUnitListVOs(){
		CntrReeferUnitListVO[] vos = (CntrReeferUnitListVO[])models.toArray(new CntrReeferUnitListVO[models.size()]);
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
		this.rfMkrNm = this.rfMkrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ceflg = this.ceflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minTemp = this.minTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhDt = this.onhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfMdlNm = this.rfMdlNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxTemp = this.maxTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfMkrSeq = this.rfMkrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aeflg = this.aeflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eeflg = this.eeflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.beflg = this.beflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfRfrNo = this.rfRfrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstr_usg_lbl =	this.rstr_usg_lbl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ru_lable_type =	this.ru_lable_type.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfTpCd =	this.rfTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfHumidCtrlValCd =	this.rfHumidCtrlValCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfCmprCtnt =	this.rfCmprCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstrUsgLblTp =	this.rstrUsgLblTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstrUsgLblDesc =	this.rstrUsgLblDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

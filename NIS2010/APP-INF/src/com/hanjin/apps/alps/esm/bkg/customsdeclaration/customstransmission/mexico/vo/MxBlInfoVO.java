/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MxBlInfoVO.java
*@FileTitle : MxBlInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.02
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.02  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MxBlInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MxBlInfoVO> models = new ArrayList<MxBlInfoVO>();
	
	/* Column Info */
	private String cneecn = null;
	/* Column Info */
	private String inRcFlg = null;
	/* Column Info */
	private String blpor = null;
	/* Column Info */
	private String polAms = null;
	/* Column Info */
	private String podFullname = null;
	/* Column Info */
	private String blpol = null;
	/* Column Info */
	private String delAms = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String shprcn = null;
	/* Column Info */
	private String bldel = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String inAwkCgoFlg = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String podAms = null;
	/* Column Info */
	private String inRdCgoFlg = null;
	/* Column Info */
	private String porFullname = null;
	/* Column Info */
	private String shprtaxid = null;
	/* Column Info */
	private String cneecd = null;
	/* Column Info */
	private String inBbCgoFlg = null;
	/* Column Info */
	private String blrly = null;
	/* Column Info */
	private String cneetaxid = null;
	/* Column Info */
	private String cnee5 = null;
	/* Column Info */
	private String polFullname = null;
	/* Column Info */
	private String cnee3 = null;
	/* Column Info */
	private String cnee4 = null;
	/* Column Info */
	private String cnee1 = null;
	/* Column Info */
	private String shpr2 = null;
	/* Column Info */
	private String cnee2 = null;
	/* Column Info */
	private String shpr1 = null;
	/* Column Info */
	private String rlyAms = null;
	/* Column Info */
	private String shpr5 = null;
	/* Column Info */
	private String rlyFullname = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String shpr4 = null;
	/* Column Info */
	private String shpr3 = null;
	/* Column Info */
	private String shprcd = null;
	/* Column Info */
	private String inDcgoFlg = null;
	/* Column Info */
	private String porAms = null;
	/* Column Info */
	private String blpod = null;
	/* Column Info */
	private String blplace = null;
	/* Column Info */
	private String inBkgCgoTpCd = null;
	/* Column Info */
	private String blnbr = null;
	/* Column Info */
	private String bldate = null;
	/* Column Info */
	private String delFullname = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MxBlInfoVO() {}

	public MxBlInfoVO(String ibflag, String pagerows, String blnbr, String blpol, String polAms, String polFullname, String blpod, String podAms, String podFullname, String blpor, String porAms, String porFullname, String bldel, String delAms, String delFullname, String blrly, String rlyAms, String rlyFullname, String blplace, String bldate, String shprcn, String shprcd, String shpr1, String shpr2, String shpr3, String shpr4, String shpr5, String shprtaxid, String cneecn, String cneecd, String cnee1, String cnee2, String cnee3, String cnee4, String cnee5, String cneetaxid, String blNo, String inBkgCgoTpCd, String inDcgoFlg, String inRcFlg, String inAwkCgoFlg, String inBbCgoFlg, String inRdCgoFlg, String cmdtCd, String cmdtNm) {
		this.cneecn = cneecn;
		this.inRcFlg = inRcFlg;
		this.blpor = blpor;
		this.polAms = polAms;
		this.podFullname = podFullname;
		this.blpol = blpol;
		this.delAms = delAms;
		this.blNo = blNo;
		this.shprcn = shprcn;
		this.bldel = bldel;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.inAwkCgoFlg = inAwkCgoFlg;
		this.cmdtCd = cmdtCd;
		this.podAms = podAms;
		this.inRdCgoFlg = inRdCgoFlg;
		this.porFullname = porFullname;
		this.shprtaxid = shprtaxid;
		this.cneecd = cneecd;
		this.inBbCgoFlg = inBbCgoFlg;
		this.blrly = blrly;
		this.cneetaxid = cneetaxid;
		this.cnee5 = cnee5;
		this.polFullname = polFullname;
		this.cnee3 = cnee3;
		this.cnee4 = cnee4;
		this.cnee1 = cnee1;
		this.shpr2 = shpr2;
		this.cnee2 = cnee2;
		this.shpr1 = shpr1;
		this.rlyAms = rlyAms;
		this.shpr5 = shpr5;
		this.rlyFullname = rlyFullname;
		this.cmdtNm = cmdtNm;
		this.shpr4 = shpr4;
		this.shpr3 = shpr3;
		this.shprcd = shprcd;
		this.inDcgoFlg = inDcgoFlg;
		this.porAms = porAms;
		this.blpod = blpod;
		this.blplace = blplace;
		this.inBkgCgoTpCd = inBkgCgoTpCd;
		this.blnbr = blnbr;
		this.bldate = bldate;
		this.delFullname = delFullname;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cneecn", getCneecn());
		this.hashColumns.put("in_rc_flg", getInRcFlg());
		this.hashColumns.put("blpor", getBlpor());
		this.hashColumns.put("pol_ams", getPolAms());
		this.hashColumns.put("pod_fullname", getPodFullname());
		this.hashColumns.put("blpol", getBlpol());
		this.hashColumns.put("del_ams", getDelAms());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("shprcn", getShprcn());
		this.hashColumns.put("bldel", getBldel());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("in_awk_cgo_flg", getInAwkCgoFlg());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("pod_ams", getPodAms());
		this.hashColumns.put("in_rd_cgo_flg", getInRdCgoFlg());
		this.hashColumns.put("por_fullname", getPorFullname());
		this.hashColumns.put("shprtaxid", getShprtaxid());
		this.hashColumns.put("cneecd", getCneecd());
		this.hashColumns.put("in_bb_cgo_flg", getInBbCgoFlg());
		this.hashColumns.put("blrly", getBlrly());
		this.hashColumns.put("cneetaxid", getCneetaxid());
		this.hashColumns.put("cnee5", getCnee5());
		this.hashColumns.put("pol_fullname", getPolFullname());
		this.hashColumns.put("cnee3", getCnee3());
		this.hashColumns.put("cnee4", getCnee4());
		this.hashColumns.put("cnee1", getCnee1());
		this.hashColumns.put("shpr2", getShpr2());
		this.hashColumns.put("cnee2", getCnee2());
		this.hashColumns.put("shpr1", getShpr1());
		this.hashColumns.put("rly_ams", getRlyAms());
		this.hashColumns.put("shpr5", getShpr5());
		this.hashColumns.put("rly_fullname", getRlyFullname());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("shpr4", getShpr4());
		this.hashColumns.put("shpr3", getShpr3());
		this.hashColumns.put("shprcd", getShprcd());
		this.hashColumns.put("in_dcgo_flg", getInDcgoFlg());
		this.hashColumns.put("por_ams", getPorAms());
		this.hashColumns.put("blpod", getBlpod());
		this.hashColumns.put("blplace", getBlplace());
		this.hashColumns.put("in_bkg_cgo_tp_cd", getInBkgCgoTpCd());
		this.hashColumns.put("blnbr", getBlnbr());
		this.hashColumns.put("bldate", getBldate());
		this.hashColumns.put("del_fullname", getDelFullname());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cneecn", "cneecn");
		this.hashFields.put("in_rc_flg", "inRcFlg");
		this.hashFields.put("blpor", "blpor");
		this.hashFields.put("pol_ams", "polAms");
		this.hashFields.put("pod_fullname", "podFullname");
		this.hashFields.put("blpol", "blpol");
		this.hashFields.put("del_ams", "delAms");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("shprcn", "shprcn");
		this.hashFields.put("bldel", "bldel");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("in_awk_cgo_flg", "inAwkCgoFlg");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("pod_ams", "podAms");
		this.hashFields.put("in_rd_cgo_flg", "inRdCgoFlg");
		this.hashFields.put("por_fullname", "porFullname");
		this.hashFields.put("shprtaxid", "shprtaxid");
		this.hashFields.put("cneecd", "cneecd");
		this.hashFields.put("in_bb_cgo_flg", "inBbCgoFlg");
		this.hashFields.put("blrly", "blrly");
		this.hashFields.put("cneetaxid", "cneetaxid");
		this.hashFields.put("cnee5", "cnee5");
		this.hashFields.put("pol_fullname", "polFullname");
		this.hashFields.put("cnee3", "cnee3");
		this.hashFields.put("cnee4", "cnee4");
		this.hashFields.put("cnee1", "cnee1");
		this.hashFields.put("shpr2", "shpr2");
		this.hashFields.put("cnee2", "cnee2");
		this.hashFields.put("shpr1", "shpr1");
		this.hashFields.put("rly_ams", "rlyAms");
		this.hashFields.put("shpr5", "shpr5");
		this.hashFields.put("rly_fullname", "rlyFullname");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("shpr4", "shpr4");
		this.hashFields.put("shpr3", "shpr3");
		this.hashFields.put("shprcd", "shprcd");
		this.hashFields.put("in_dcgo_flg", "inDcgoFlg");
		this.hashFields.put("por_ams", "porAms");
		this.hashFields.put("blpod", "blpod");
		this.hashFields.put("blplace", "blplace");
		this.hashFields.put("in_bkg_cgo_tp_cd", "inBkgCgoTpCd");
		this.hashFields.put("blnbr", "blnbr");
		this.hashFields.put("bldate", "bldate");
		this.hashFields.put("del_fullname", "delFullname");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cneecn
	 */
	public String getCneecn() {
		return this.cneecn;
	}
	
	/**
	 * Column Info
	 * @return inRcFlg
	 */
	public String getInRcFlg() {
		return this.inRcFlg;
	}
	
	/**
	 * Column Info
	 * @return blpor
	 */
	public String getBlpor() {
		return this.blpor;
	}
	
	/**
	 * Column Info
	 * @return polAms
	 */
	public String getPolAms() {
		return this.polAms;
	}
	
	/**
	 * Column Info
	 * @return podFullname
	 */
	public String getPodFullname() {
		return this.podFullname;
	}
	
	/**
	 * Column Info
	 * @return blpol
	 */
	public String getBlpol() {
		return this.blpol;
	}
	
	/**
	 * Column Info
	 * @return delAms
	 */
	public String getDelAms() {
		return this.delAms;
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
	 * @return shprcn
	 */
	public String getShprcn() {
		return this.shprcn;
	}
	
	/**
	 * Column Info
	 * @return bldel
	 */
	public String getBldel() {
		return this.bldel;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return inAwkCgoFlg
	 */
	public String getInAwkCgoFlg() {
		return this.inAwkCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}
	
	/**
	 * Column Info
	 * @return podAms
	 */
	public String getPodAms() {
		return this.podAms;
	}
	
	/**
	 * Column Info
	 * @return inRdCgoFlg
	 */
	public String getInRdCgoFlg() {
		return this.inRdCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return porFullname
	 */
	public String getPorFullname() {
		return this.porFullname;
	}
	
	/**
	 * Column Info
	 * @return shprtaxid
	 */
	public String getShprtaxid() {
		return this.shprtaxid;
	}
	
	/**
	 * Column Info
	 * @return cneecd
	 */
	public String getCneecd() {
		return this.cneecd;
	}
	
	/**
	 * Column Info
	 * @return inBbCgoFlg
	 */
	public String getInBbCgoFlg() {
		return this.inBbCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return blrly
	 */
	public String getBlrly() {
		return this.blrly;
	}
	
	/**
	 * Column Info
	 * @return cneetaxid
	 */
	public String getCneetaxid() {
		return this.cneetaxid;
	}
	
	/**
	 * Column Info
	 * @return cnee5
	 */
	public String getCnee5() {
		return this.cnee5;
	}
	
	/**
	 * Column Info
	 * @return polFullname
	 */
	public String getPolFullname() {
		return this.polFullname;
	}
	
	/**
	 * Column Info
	 * @return cnee3
	 */
	public String getCnee3() {
		return this.cnee3;
	}
	
	/**
	 * Column Info
	 * @return cnee4
	 */
	public String getCnee4() {
		return this.cnee4;
	}
	
	/**
	 * Column Info
	 * @return cnee1
	 */
	public String getCnee1() {
		return this.cnee1;
	}
	
	/**
	 * Column Info
	 * @return shpr2
	 */
	public String getShpr2() {
		return this.shpr2;
	}
	
	/**
	 * Column Info
	 * @return cnee2
	 */
	public String getCnee2() {
		return this.cnee2;
	}
	
	/**
	 * Column Info
	 * @return shpr1
	 */
	public String getShpr1() {
		return this.shpr1;
	}
	
	/**
	 * Column Info
	 * @return rlyAms
	 */
	public String getRlyAms() {
		return this.rlyAms;
	}
	
	/**
	 * Column Info
	 * @return shpr5
	 */
	public String getShpr5() {
		return this.shpr5;
	}
	
	/**
	 * Column Info
	 * @return rlyFullname
	 */
	public String getRlyFullname() {
		return this.rlyFullname;
	}
	
	/**
	 * Column Info
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
	}
	
	/**
	 * Column Info
	 * @return shpr4
	 */
	public String getShpr4() {
		return this.shpr4;
	}
	
	/**
	 * Column Info
	 * @return shpr3
	 */
	public String getShpr3() {
		return this.shpr3;
	}
	
	/**
	 * Column Info
	 * @return shprcd
	 */
	public String getShprcd() {
		return this.shprcd;
	}
	
	/**
	 * Column Info
	 * @return inDcgoFlg
	 */
	public String getInDcgoFlg() {
		return this.inDcgoFlg;
	}
	
	/**
	 * Column Info
	 * @return porAms
	 */
	public String getPorAms() {
		return this.porAms;
	}
	
	/**
	 * Column Info
	 * @return blpod
	 */
	public String getBlpod() {
		return this.blpod;
	}
	
	/**
	 * Column Info
	 * @return blplace
	 */
	public String getBlplace() {
		return this.blplace;
	}
	
	/**
	 * Column Info
	 * @return inBkgCgoTpCd
	 */
	public String getInBkgCgoTpCd() {
		return this.inBkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return blnbr
	 */
	public String getBlnbr() {
		return this.blnbr;
	}
	
	/**
	 * Column Info
	 * @return bldate
	 */
	public String getBldate() {
		return this.bldate;
	}
	
	/**
	 * Column Info
	 * @return delFullname
	 */
	public String getDelFullname() {
		return this.delFullname;
	}
	

	/**
	 * Column Info
	 * @param cneecn
	 */
	public void setCneecn(String cneecn) {
		this.cneecn = cneecn;
	}
	
	/**
	 * Column Info
	 * @param inRcFlg
	 */
	public void setInRcFlg(String inRcFlg) {
		this.inRcFlg = inRcFlg;
	}
	
	/**
	 * Column Info
	 * @param blpor
	 */
	public void setBlpor(String blpor) {
		this.blpor = blpor;
	}
	
	/**
	 * Column Info
	 * @param polAms
	 */
	public void setPolAms(String polAms) {
		this.polAms = polAms;
	}
	
	/**
	 * Column Info
	 * @param podFullname
	 */
	public void setPodFullname(String podFullname) {
		this.podFullname = podFullname;
	}
	
	/**
	 * Column Info
	 * @param blpol
	 */
	public void setBlpol(String blpol) {
		this.blpol = blpol;
	}
	
	/**
	 * Column Info
	 * @param delAms
	 */
	public void setDelAms(String delAms) {
		this.delAms = delAms;
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
	 * @param shprcn
	 */
	public void setShprcn(String shprcn) {
		this.shprcn = shprcn;
	}
	
	/**
	 * Column Info
	 * @param bldel
	 */
	public void setBldel(String bldel) {
		this.bldel = bldel;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param inAwkCgoFlg
	 */
	public void setInAwkCgoFlg(String inAwkCgoFlg) {
		this.inAwkCgoFlg = inAwkCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}
	
	/**
	 * Column Info
	 * @param podAms
	 */
	public void setPodAms(String podAms) {
		this.podAms = podAms;
	}
	
	/**
	 * Column Info
	 * @param inRdCgoFlg
	 */
	public void setInRdCgoFlg(String inRdCgoFlg) {
		this.inRdCgoFlg = inRdCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param porFullname
	 */
	public void setPorFullname(String porFullname) {
		this.porFullname = porFullname;
	}
	
	/**
	 * Column Info
	 * @param shprtaxid
	 */
	public void setShprtaxid(String shprtaxid) {
		this.shprtaxid = shprtaxid;
	}
	
	/**
	 * Column Info
	 * @param cneecd
	 */
	public void setCneecd(String cneecd) {
		this.cneecd = cneecd;
	}
	
	/**
	 * Column Info
	 * @param inBbCgoFlg
	 */
	public void setInBbCgoFlg(String inBbCgoFlg) {
		this.inBbCgoFlg = inBbCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param blrly
	 */
	public void setBlrly(String blrly) {
		this.blrly = blrly;
	}
	
	/**
	 * Column Info
	 * @param cneetaxid
	 */
	public void setCneetaxid(String cneetaxid) {
		this.cneetaxid = cneetaxid;
	}
	
	/**
	 * Column Info
	 * @param cnee5
	 */
	public void setCnee5(String cnee5) {
		this.cnee5 = cnee5;
	}
	
	/**
	 * Column Info
	 * @param polFullname
	 */
	public void setPolFullname(String polFullname) {
		this.polFullname = polFullname;
	}
	
	/**
	 * Column Info
	 * @param cnee3
	 */
	public void setCnee3(String cnee3) {
		this.cnee3 = cnee3;
	}
	
	/**
	 * Column Info
	 * @param cnee4
	 */
	public void setCnee4(String cnee4) {
		this.cnee4 = cnee4;
	}
	
	/**
	 * Column Info
	 * @param cnee1
	 */
	public void setCnee1(String cnee1) {
		this.cnee1 = cnee1;
	}
	
	/**
	 * Column Info
	 * @param shpr2
	 */
	public void setShpr2(String shpr2) {
		this.shpr2 = shpr2;
	}
	
	/**
	 * Column Info
	 * @param cnee2
	 */
	public void setCnee2(String cnee2) {
		this.cnee2 = cnee2;
	}
	
	/**
	 * Column Info
	 * @param shpr1
	 */
	public void setShpr1(String shpr1) {
		this.shpr1 = shpr1;
	}
	
	/**
	 * Column Info
	 * @param rlyAms
	 */
	public void setRlyAms(String rlyAms) {
		this.rlyAms = rlyAms;
	}
	
	/**
	 * Column Info
	 * @param shpr5
	 */
	public void setShpr5(String shpr5) {
		this.shpr5 = shpr5;
	}
	
	/**
	 * Column Info
	 * @param rlyFullname
	 */
	public void setRlyFullname(String rlyFullname) {
		this.rlyFullname = rlyFullname;
	}
	
	/**
	 * Column Info
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
	}
	
	/**
	 * Column Info
	 * @param shpr4
	 */
	public void setShpr4(String shpr4) {
		this.shpr4 = shpr4;
	}
	
	/**
	 * Column Info
	 * @param shpr3
	 */
	public void setShpr3(String shpr3) {
		this.shpr3 = shpr3;
	}
	
	/**
	 * Column Info
	 * @param shprcd
	 */
	public void setShprcd(String shprcd) {
		this.shprcd = shprcd;
	}
	
	/**
	 * Column Info
	 * @param inDcgoFlg
	 */
	public void setInDcgoFlg(String inDcgoFlg) {
		this.inDcgoFlg = inDcgoFlg;
	}
	
	/**
	 * Column Info
	 * @param porAms
	 */
	public void setPorAms(String porAms) {
		this.porAms = porAms;
	}
	
	/**
	 * Column Info
	 * @param blpod
	 */
	public void setBlpod(String blpod) {
		this.blpod = blpod;
	}
	
	/**
	 * Column Info
	 * @param blplace
	 */
	public void setBlplace(String blplace) {
		this.blplace = blplace;
	}
	
	/**
	 * Column Info
	 * @param inBkgCgoTpCd
	 */
	public void setInBkgCgoTpCd(String inBkgCgoTpCd) {
		this.inBkgCgoTpCd = inBkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param blnbr
	 */
	public void setBlnbr(String blnbr) {
		this.blnbr = blnbr;
	}
	
	/**
	 * Column Info
	 * @param bldate
	 */
	public void setBldate(String bldate) {
		this.bldate = bldate;
	}
	
	/**
	 * Column Info
	 * @param delFullname
	 */
	public void setDelFullname(String delFullname) {
		this.delFullname = delFullname;
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
		setCneecn(JSPUtil.getParameter(request, prefix + "cneecn", ""));
		setInRcFlg(JSPUtil.getParameter(request, prefix + "in_rc_flg", ""));
		setBlpor(JSPUtil.getParameter(request, prefix + "blpor", ""));
		setPolAms(JSPUtil.getParameter(request, prefix + "pol_ams", ""));
		setPodFullname(JSPUtil.getParameter(request, prefix + "pod_fullname", ""));
		setBlpol(JSPUtil.getParameter(request, prefix + "blpol", ""));
		setDelAms(JSPUtil.getParameter(request, prefix + "del_ams", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setShprcn(JSPUtil.getParameter(request, prefix + "shprcn", ""));
		setBldel(JSPUtil.getParameter(request, prefix + "bldel", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setInAwkCgoFlg(JSPUtil.getParameter(request, prefix + "in_awk_cgo_flg", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setPodAms(JSPUtil.getParameter(request, prefix + "pod_ams", ""));
		setInRdCgoFlg(JSPUtil.getParameter(request, prefix + "in_rd_cgo_flg", ""));
		setPorFullname(JSPUtil.getParameter(request, prefix + "por_fullname", ""));
		setShprtaxid(JSPUtil.getParameter(request, prefix + "shprtaxid", ""));
		setCneecd(JSPUtil.getParameter(request, prefix + "cneecd", ""));
		setInBbCgoFlg(JSPUtil.getParameter(request, prefix + "in_bb_cgo_flg", ""));
		setBlrly(JSPUtil.getParameter(request, prefix + "blrly", ""));
		setCneetaxid(JSPUtil.getParameter(request, prefix + "cneetaxid", ""));
		setCnee5(JSPUtil.getParameter(request, prefix + "cnee5", ""));
		setPolFullname(JSPUtil.getParameter(request, prefix + "pol_fullname", ""));
		setCnee3(JSPUtil.getParameter(request, prefix + "cnee3", ""));
		setCnee4(JSPUtil.getParameter(request, prefix + "cnee4", ""));
		setCnee1(JSPUtil.getParameter(request, prefix + "cnee1", ""));
		setShpr2(JSPUtil.getParameter(request, prefix + "shpr2", ""));
		setCnee2(JSPUtil.getParameter(request, prefix + "cnee2", ""));
		setShpr1(JSPUtil.getParameter(request, prefix + "shpr1", ""));
		setRlyAms(JSPUtil.getParameter(request, prefix + "rly_ams", ""));
		setShpr5(JSPUtil.getParameter(request, prefix + "shpr5", ""));
		setRlyFullname(JSPUtil.getParameter(request, prefix + "rly_fullname", ""));
		setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
		setShpr4(JSPUtil.getParameter(request, prefix + "shpr4", ""));
		setShpr3(JSPUtil.getParameter(request, prefix + "shpr3", ""));
		setShprcd(JSPUtil.getParameter(request, prefix + "shprcd", ""));
		setInDcgoFlg(JSPUtil.getParameter(request, prefix + "in_dcgo_flg", ""));
		setPorAms(JSPUtil.getParameter(request, prefix + "por_ams", ""));
		setBlpod(JSPUtil.getParameter(request, prefix + "blpod", ""));
		setBlplace(JSPUtil.getParameter(request, prefix + "blplace", ""));
		setInBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "in_bkg_cgo_tp_cd", ""));
		setBlnbr(JSPUtil.getParameter(request, prefix + "blnbr", ""));
		setBldate(JSPUtil.getParameter(request, prefix + "bldate", ""));
		setDelFullname(JSPUtil.getParameter(request, prefix + "del_fullname", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MxBlInfoVO[]
	 */
	public MxBlInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MxBlInfoVO[]
	 */
	public MxBlInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MxBlInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cneecn = (JSPUtil.getParameter(request, prefix	+ "cneecn", length));
			String[] inRcFlg = (JSPUtil.getParameter(request, prefix	+ "in_rc_flg", length));
			String[] blpor = (JSPUtil.getParameter(request, prefix	+ "blpor", length));
			String[] polAms = (JSPUtil.getParameter(request, prefix	+ "pol_ams", length));
			String[] podFullname = (JSPUtil.getParameter(request, prefix	+ "pod_fullname", length));
			String[] blpol = (JSPUtil.getParameter(request, prefix	+ "blpol", length));
			String[] delAms = (JSPUtil.getParameter(request, prefix	+ "del_ams", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] shprcn = (JSPUtil.getParameter(request, prefix	+ "shprcn", length));
			String[] bldel = (JSPUtil.getParameter(request, prefix	+ "bldel", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] inAwkCgoFlg = (JSPUtil.getParameter(request, prefix	+ "in_awk_cgo_flg", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] podAms = (JSPUtil.getParameter(request, prefix	+ "pod_ams", length));
			String[] inRdCgoFlg = (JSPUtil.getParameter(request, prefix	+ "in_rd_cgo_flg", length));
			String[] porFullname = (JSPUtil.getParameter(request, prefix	+ "por_fullname", length));
			String[] shprtaxid = (JSPUtil.getParameter(request, prefix	+ "shprtaxid", length));
			String[] cneecd = (JSPUtil.getParameter(request, prefix	+ "cneecd", length));
			String[] inBbCgoFlg = (JSPUtil.getParameter(request, prefix	+ "in_bb_cgo_flg", length));
			String[] blrly = (JSPUtil.getParameter(request, prefix	+ "blrly", length));
			String[] cneetaxid = (JSPUtil.getParameter(request, prefix	+ "cneetaxid", length));
			String[] cnee5 = (JSPUtil.getParameter(request, prefix	+ "cnee5", length));
			String[] polFullname = (JSPUtil.getParameter(request, prefix	+ "pol_fullname", length));
			String[] cnee3 = (JSPUtil.getParameter(request, prefix	+ "cnee3", length));
			String[] cnee4 = (JSPUtil.getParameter(request, prefix	+ "cnee4", length));
			String[] cnee1 = (JSPUtil.getParameter(request, prefix	+ "cnee1", length));
			String[] shpr2 = (JSPUtil.getParameter(request, prefix	+ "shpr2", length));
			String[] cnee2 = (JSPUtil.getParameter(request, prefix	+ "cnee2", length));
			String[] shpr1 = (JSPUtil.getParameter(request, prefix	+ "shpr1", length));
			String[] rlyAms = (JSPUtil.getParameter(request, prefix	+ "rly_ams", length));
			String[] shpr5 = (JSPUtil.getParameter(request, prefix	+ "shpr5", length));
			String[] rlyFullname = (JSPUtil.getParameter(request, prefix	+ "rly_fullname", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] shpr4 = (JSPUtil.getParameter(request, prefix	+ "shpr4", length));
			String[] shpr3 = (JSPUtil.getParameter(request, prefix	+ "shpr3", length));
			String[] shprcd = (JSPUtil.getParameter(request, prefix	+ "shprcd", length));
			String[] inDcgoFlg = (JSPUtil.getParameter(request, prefix	+ "in_dcgo_flg", length));
			String[] porAms = (JSPUtil.getParameter(request, prefix	+ "por_ams", length));
			String[] blpod = (JSPUtil.getParameter(request, prefix	+ "blpod", length));
			String[] blplace = (JSPUtil.getParameter(request, prefix	+ "blplace", length));
			String[] inBkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "in_bkg_cgo_tp_cd", length));
			String[] blnbr = (JSPUtil.getParameter(request, prefix	+ "blnbr", length));
			String[] bldate = (JSPUtil.getParameter(request, prefix	+ "bldate", length));
			String[] delFullname = (JSPUtil.getParameter(request, prefix	+ "del_fullname", length));
			
			for (int i = 0; i < length; i++) {
				model = new MxBlInfoVO();
				if (cneecn[i] != null)
					model.setCneecn(cneecn[i]);
				if (inRcFlg[i] != null)
					model.setInRcFlg(inRcFlg[i]);
				if (blpor[i] != null)
					model.setBlpor(blpor[i]);
				if (polAms[i] != null)
					model.setPolAms(polAms[i]);
				if (podFullname[i] != null)
					model.setPodFullname(podFullname[i]);
				if (blpol[i] != null)
					model.setBlpol(blpol[i]);
				if (delAms[i] != null)
					model.setDelAms(delAms[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (shprcn[i] != null)
					model.setShprcn(shprcn[i]);
				if (bldel[i] != null)
					model.setBldel(bldel[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (inAwkCgoFlg[i] != null)
					model.setInAwkCgoFlg(inAwkCgoFlg[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (podAms[i] != null)
					model.setPodAms(podAms[i]);
				if (inRdCgoFlg[i] != null)
					model.setInRdCgoFlg(inRdCgoFlg[i]);
				if (porFullname[i] != null)
					model.setPorFullname(porFullname[i]);
				if (shprtaxid[i] != null)
					model.setShprtaxid(shprtaxid[i]);
				if (cneecd[i] != null)
					model.setCneecd(cneecd[i]);
				if (inBbCgoFlg[i] != null)
					model.setInBbCgoFlg(inBbCgoFlg[i]);
				if (blrly[i] != null)
					model.setBlrly(blrly[i]);
				if (cneetaxid[i] != null)
					model.setCneetaxid(cneetaxid[i]);
				if (cnee5[i] != null)
					model.setCnee5(cnee5[i]);
				if (polFullname[i] != null)
					model.setPolFullname(polFullname[i]);
				if (cnee3[i] != null)
					model.setCnee3(cnee3[i]);
				if (cnee4[i] != null)
					model.setCnee4(cnee4[i]);
				if (cnee1[i] != null)
					model.setCnee1(cnee1[i]);
				if (shpr2[i] != null)
					model.setShpr2(shpr2[i]);
				if (cnee2[i] != null)
					model.setCnee2(cnee2[i]);
				if (shpr1[i] != null)
					model.setShpr1(shpr1[i]);
				if (rlyAms[i] != null)
					model.setRlyAms(rlyAms[i]);
				if (shpr5[i] != null)
					model.setShpr5(shpr5[i]);
				if (rlyFullname[i] != null)
					model.setRlyFullname(rlyFullname[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (shpr4[i] != null)
					model.setShpr4(shpr4[i]);
				if (shpr3[i] != null)
					model.setShpr3(shpr3[i]);
				if (shprcd[i] != null)
					model.setShprcd(shprcd[i]);
				if (inDcgoFlg[i] != null)
					model.setInDcgoFlg(inDcgoFlg[i]);
				if (porAms[i] != null)
					model.setPorAms(porAms[i]);
				if (blpod[i] != null)
					model.setBlpod(blpod[i]);
				if (blplace[i] != null)
					model.setBlplace(blplace[i]);
				if (inBkgCgoTpCd[i] != null)
					model.setInBkgCgoTpCd(inBkgCgoTpCd[i]);
				if (blnbr[i] != null)
					model.setBlnbr(blnbr[i]);
				if (bldate[i] != null)
					model.setBldate(bldate[i]);
				if (delFullname[i] != null)
					model.setDelFullname(delFullname[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMxBlInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MxBlInfoVO[]
	 */
	public MxBlInfoVO[] getMxBlInfoVOs(){
		MxBlInfoVO[] vos = (MxBlInfoVO[])models.toArray(new MxBlInfoVO[models.size()]);
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
		this.cneecn = this.cneecn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inRcFlg = this.inRcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpor = this.blpor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polAms = this.polAms .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podFullname = this.podFullname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpol = this.blpol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delAms = this.delAms .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprcn = this.shprcn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bldel = this.bldel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inAwkCgoFlg = this.inAwkCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podAms = this.podAms .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inRdCgoFlg = this.inRdCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porFullname = this.porFullname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprtaxid = this.shprtaxid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneecd = this.cneecd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inBbCgoFlg = this.inBbCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blrly = this.blrly .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneetaxid = this.cneetaxid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee5 = this.cnee5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polFullname = this.polFullname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee3 = this.cnee3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee4 = this.cnee4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee1 = this.cnee1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr2 = this.shpr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee2 = this.cnee2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr1 = this.shpr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlyAms = this.rlyAms .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr5 = this.shpr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlyFullname = this.rlyFullname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr4 = this.shpr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr3 = this.shpr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprcd = this.shprcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inDcgoFlg = this.inDcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porAms = this.porAms .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpod = this.blpod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blplace = this.blplace .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inBkgCgoTpCd = this.inBkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blnbr = this.blnbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bldate = this.bldate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delFullname = this.delFullname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

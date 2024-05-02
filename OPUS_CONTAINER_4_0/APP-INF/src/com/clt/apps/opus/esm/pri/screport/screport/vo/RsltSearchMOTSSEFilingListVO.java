/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : RsltSearchMOTSSEFilingListVO.java
 *@FileTitle : RsltSearchMOTSSEFilingListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.01.05
 *@LastModifier : jaewonLee
 *@LastVersion : 1.0
 * 2015.01.05 jaewonLee 
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.screport.screport.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author jaewonLee
 * @since J2EE 1.6
 * @see	..
 */
public class RsltSearchMOTSSEFilingListVO	extends	 AbstractValueObject {

	private	 static final long serialVersionUID = 1L;

	private	 Collection<RsltSearchMOTSSEFilingListVO>  models =	new	ArrayList<RsltSearchMOTSSEFilingListVO>();
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;
	/*	Column Info	*/
	private String testExecDt = null;
	/*	Column Info	*/
	private String execDt = null;
	/*	Column Info	*/
	private String svcScpCd = null;
	/*	Column Info	*/
	private String fOrgCd = null;
	/*	Column Info	*/
	private String updUsrId = null;
	/*	Column Info	*/
	private String toFileDt = null;
	/*	Column Info	*/
	private String frFileDt = null;
	/*	Column Info	*/
	private String fileDt = null;
	/*	Column Info	*/
	private String inqTpCd = null;
	/*	Column Info	*/
	private String creUsrId = null;
	/*	Column Info	*/
	private String motTrfSeq = null;
	/*	Column Info	*/
	private String rtSeq = null;
	/*	Column Info	*/
	private String batExeDt = null;
	/*	Column Info	*/
	private String seq = null;
	/*	Column Info	*/
	private String bkgSrcTpCd = null;
	/*	Column Info	*/
	private String bkgNo = null;
	/*	Column Info	*/
	private String carrier = null;
	/*	Column Info	*/
	private String ctrtNo = null;
	/*	Column Info	*/
	private String ctrtHldNm = null;
	/*	Column Info	*/
	private String bkgShprNm = null;
	/*	Column Info	*/
	private String bkgCneeNm = null;
	/*	Column Info	*/
	private String foreTraComp = null;
	/*	Column Info	*/
	private String operAgt = null;
	/*	Column Info	*/
	private String lane = null;
	/*	Column Info	*/
	private String wayPort = null;
	/*	Column Info	*/
	private String polCd = null;
	/*	Column Info	*/
	private String deptTsitPort = null;
	/*	Column Info	*/
	private String destTsitPort = null;
	/*	Column Info	*/
	private String podCd = null;
	/*	Column Info	*/
	private String transTerm = null;
	/*	Column Info	*/
	private String cntrTp = null;
	/*	Column Info	*/
	private String cmdtTp = null;
	/*	Column Info	*/
	private String cntrSz = null;
	/*	Column Info	*/
	private String cntrVol1 = null;
	/*	Column Info	*/
	private String cntrVol2 = null;
	/*	Column Info	*/
	private String oftRt = null;
	/*	Column Info	*/
	private String blnk1 = null;
	/*	Column Info	*/
	private String bafAmt = null;
	/*	Column Info	*/
	private String cafAmt = null;
	/*	Column Info	*/
	private String agsAmt = null;
	/*	Column Info	*/
	private String cgdAmt = null;
	/*	Column Info	*/
	private String cglAmt = null;
	/*	Column Info	*/
	private String cssAmt = null;
	/*	Column Info	*/
	private String ebsAmt = null;
	/*	Column Info	*/
	private String eisAmt = null;
	/*	Column Info	*/
	private String emsAmt = null;
	/*	Column Info	*/
	private String eriAmt = null;
	/*	Column Info	*/
	private String fafAmt = null;
	/*	Column Info	*/
	private String lsfAmt = null;
	/*	Column Info	*/
	private String pssAmt = null;
	/*	Column Info	*/
	private String sctAmt = null;
	/*	Column Info	*/
	private String codAmt = null;
	/*	Column Info	*/
	private String dgsAmt = null;
	/*	Column Info	*/
	private String gh2Amt = null;
	/*	Column Info	*/
	private String gohAmt = null;
	/*	Column Info	*/
	private String hazAmt = null;
	/*	Column Info	*/
	private String heaAmt = null;
	/*	Column Info	*/
	private String sesAmt = null;
	/*	Column Info	*/
	private String thcAmt = null;
	/*	Column Info	*/
	private String amsAmt = null;
	/*	Column Info	*/
	private String bkfAmt = null;
	/*	Column Info	*/
	private String cdcAmt = null;
	/*	Column Info	*/
	private String cddAmt = null;
	/*	Column Info	*/
	private String ctpAmt = null;
	/*	Column Info	*/
	private String cyrAmt = null;
	/*	Column Info	*/
	private String docAmt = null;
	/*	Column Info	*/
	private String empAmt = null;
	/*	Column Info	*/
	private String esdAmt = null;
	/*	Column Info	*/
	private String psfAmt = null;
	/*	Column Info	*/
	private String slfAmt = null;
	/*	Column Info	*/
	private String tslAmt = null;
	/*	Column Info	*/
	private String xdoAmt = null;
	/*	Column Info	*/
	private String ahaAmt = null;
	/*	Column Info	*/
	private String almAmt = null;
	/*	Column Info	*/
	private String amaAmt = null;
	/*	Column Info	*/
	private String ardAmt = null;
	/*	Column Info	*/
	private String badAmt = null;
	/*	Column Info	*/
	private String cccAmt = null;
	/*	Column Info	*/
	private String cfdAmt = null;
	/*	Column Info	*/
	private String cmcAmt = null;
	/*	Column Info	*/
	private String csvAmt = null;
	/*	Column Info	*/
	private String dofAmt = null;
	/*	Column Info	*/
	private String drpAmt = null;
	/*	Column Info	*/
	private String ediAmt = null;
	/*	Column Info	*/
	private String ehdAmt = null;
	/*	Column Info	*/
	private String hafAmt = null;
	/*	Column Info	*/
	private String hauAmt = null;
	/*	Column Info	*/
	private String ifiAmt = null;
	/*	Column Info	*/
	private String insAmt = null;
	/*	Column Info	*/
	private String kcsAmt = null;
	/*	Column Info	*/
	private String lloAmt = null;
	/*	Column Info	*/
	private String mplAmt = null;
	/*	Column Info	*/
	private String pscAmt = null;
	/*	Column Info	*/
	private String rhaAmt = null;
	/*	Column Info	*/
	private String rlsAmt = null;
	/*	Column Info	*/
	private String rpcAmt = null;
	/*	Column Info	*/
	private String tsdAmt = null;
	/*	Column Info	*/
	private String whaAmt = null;
	/*	Column Info	*/
	private String xddAmt = null;
	/*	Column Info	*/
	private String xdeAmt = null;
	/*	Column Info	*/
	private String xerAmt = null;
	/*	Column Info	*/
	private String xwfAmt = null;
	/*	Column Info	*/
	private String ecaAmt = null;
	/*	Column Info	*/
	private String wtrAmt = null;
	/*	Column Info	*/
	private String crsAmt = null;
	/*	Column Info	*/
	private String neoAmt = null;
	/*	Column Info	*/
	private String ocrAmt = null;
	/*	Column Info	*/
	private String effDt = null;
	/*	Column Info	*/
	private String expDt = null;
	/*	Column Info	*/
	private String remark = null;
	/*	Column Info	*/
	private String tBucAmt = null;
	/*	Column Info	*/
	private String tBafAmt = null;
	/*	Column Info	*/
	private String tCsrAmt = null;
	/*	Column Info	*/
	private String tCmsAmt = null;
	/*	Column Info	*/
	private String tOthAmt = null;
	/*	Column Info	*/
	private String tDhfAmt = null;
	/*	Column Info	*/
	private String tFafAmt = null;
	/*	Column Info	*/
	private String tFrcAmt = null;
	/*	Column Info	*/
	private String tTscAmt = null;
	/*	Column Info	*/
	private String tPscAmt = null;
	/*	Column Info	*/
	private String tEnsAmt = null;
	/*	Column Info	*/
	private String tStfAmt = null;
	/*	Column Info	*/
	private String tDdcAmt = null;
	/*	Column Info	*/
	private String tSzcAmt = null;
	/*	Column Info	*/
	private String tCucAmt = null;
	/*	Column Info	*/
	private String tDthAmt = null;
	/*	Column Info	*/
	private String tHrsAmt = null;
	/*	Column Info	*/
	private String tApsAmt = null;
	/*	Column Info	*/
	private String tFrbAmt = null;
	/*	Column Info	*/
	private String tOtsAmt = null;
	/*	Column Info	*/
	private String tCfrAmt = null;
	/*	Column Info	*/
	private String tOihAmt = null;
	/*	Column Info	*/
	private String tTacAmt = null;
	/*	Column Info	*/
	private String tActAmt = null;
	/*	Column Info	*/
	private String tWscAmt = null;
	/*	Column Info	*/
	private String agsCurrCd = null;
	/*	Column Info	*/
	private String cgdCurrCd = null;
	/*	Column Info	*/
	private String cglCurrCd = null;
	/*	Column Info	*/
	private String cssCurrCd = null;
	/*	Column Info	*/
	private String ebsCurrCd = null;
	/*	Column Info	*/
	private String eisCurrCd = null;
	/*	Column Info	*/
	private String emsCurrCd = null;
	/*	Column Info	*/
	private String eriCurrCd = null;
	/*	Column Info	*/
	private String fafCurrCd = null;
	/*	Column Info	*/
	private String lsfCurrCd = null;
	/*	Column Info	*/
	private String pssCurrCd = null;
	/*	Column Info	*/
	private String sctCurrCd = null;
	/*	Column Info	*/
	private String codCurrCd = null;
	/*	Column Info	*/
	private String dgsCurrCd = null;
	/*	Column Info	*/
	private String gh2CurrCd = null;
	/*	Column Info	*/
	private String gohCurrCd = null;
	/*	Column Info	*/
	private String hazCurrCd = null;
	/*	Column Info	*/
	private String heaCurrCd = null;
	/*	Column Info	*/
	private String sesCurrCd = null;
	/*	Column Info	*/
	private String ecaCurrCd = null;
	/*	Column Info	*/
	private String wtrCurrCd = null;
	/*	Column Info	*/
	private String agsUsdLoclXchRt = null;
	/*	Column Info	*/
	private String cgdUsdLoclXchRt = null;
	/*	Column Info	*/
	private String cglUsdLoclXchRt = null;
	/*	Column Info	*/
	private String cssUsdLoclXchRt = null;
	/*	Column Info	*/
	private String ebsUsdLoclXchRt = null;
	/*	Column Info	*/
	private String eisUsdLoclXchRt = null;
	/*	Column Info	*/
	private String emsUsdLoclXchRt = null;
	/*	Column Info	*/
	private String eriUsdLoclXchRt = null;
	/*	Column Info	*/
	private String fafUsdLoclXchRt = null;
	/*	Column Info	*/
	private String lsfUsdLoclXchRt = null;
	/*	Column Info	*/
	private String pssUsdLoclXchRt = null;
	/*	Column Info	*/
	private String sctUsdLoclXchRt = null;
	/*	Column Info	*/
	private String codUsdLoclXchRt = null;
	/*	Column Info	*/
	private String dgsUsdLoclXchRt = null;
	/*	Column Info	*/
	private String gh2UsdLoclXchRt = null;
	/*	Column Info	*/
	private String gohUsdLoclXchRt = null;
	/*	Column Info	*/
	private String hazUsdLoclXchRt = null;
	/*	Column Info	*/
	private String heaUsdLoclXchRt = null;
	/*	Column Info	*/
	private String sesUsdLoclXchRt = null;
	/*	Column Info	*/
	private String ecaUsdLoclXchRt = null;
	/*	Column Info	*/
	private String wtrUsdLoclXchRt = null;
	/*	Column Info	*/
	private String bucCurrCd = null;
	/*	Column Info	*/
	private String csrCurrCd = null;
	/*	Column Info	*/
	private String cmsCurrCd = null;
	/*	Column Info	*/
	private String othCurrCd = null;
	/*	Column Info	*/
	private String dhfCurrCd = null;
	/*	Column Info	*/
	private String frcCurrCd = null;
	/*	Column Info	*/
	private String tscCurrCd = null;
	/*	Column Info	*/
	private String ensCurrCd = null;
	/*	Column Info	*/
	private String stfCurrCd = null;
	/*	Column Info	*/
	private String ddcCurrCd = null;
	/*	Column Info	*/
	private String szcCurrCd = null;
	/*	Column Info	*/
	private String cucCurrCd = null;
	/*	Column Info	*/
	private String dthCurrCd = null;
	/*	Column Info	*/
	private String hrsCurrCd = null;
	/*	Column Info	*/
	private String apsCurrCd = null;
	/*	Column Info	*/
	private String frbCurrCd = null;
	/*	Column Info	*/
	private String otsCurrCd = null;
	/*	Column Info	*/
	private String cfrCurrCd = null;
	/*	Column Info	*/
	private String oihCurrCd = null;
	/*	Column Info	*/
	private String tacCurrCd = null;
	/*	Column Info	*/
	private String actCurrCd = null;
	/*	Column Info	*/
	private String wscCurrCd = null;
	/*	Column Info	*/
	private String bucUsdLoclXchRt = null;
	/*	Column Info	*/
	private String csrUsdLoclXchRt = null;
	/*	Column Info	*/
	private String cmsUsdLoclXchRt = null;
	/*	Column Info	*/
	private String othUsdLoclXchRt = null;
	/*	Column Info	*/
	private String dhfUsdLoclXchRt = null;
	/*	Column Info	*/
	private String frcUsdLoclXchRt = null;
	/*	Column Info	*/
	private String tscUsdLoclXchRt = null;
	/*	Column Info	*/
	private String ensUsdLoclXchRt = null;
	/*	Column Info	*/
	private String stfUsdLoclXchRt = null;
	/*	Column Info	*/
	private String ddcUsdLoclXchRt = null;
	/*	Column Info	*/
	private String szcUsdLoclXchRt = null;
	/*	Column Info	*/
	private String cucUsdLoclXchRt = null;
	/*	Column Info	*/
	private String dthUsdLoclXchRt = null;
	/*	Column Info	*/
	private String hrsUsdLoclXchRt = null;
	/*	Column Info	*/
	private String apsUsdLoclXchRt = null;
	/*	Column Info	*/
	private String frbUsdLoclXchRt = null;
	/*	Column Info	*/
	private String otsUsdLoclXchRt = null;
	/*	Column Info	*/
	private String cfrUsdLoclXchRt = null;
	/*	Column Info	*/
	private String oihUsdLoclXchRt = null;
	/*	Column Info	*/
	private String tacUsdLoclXchRt = null;
	/*	Column Info	*/
	private String actUsdLoclXchRt = null;
	/*	Column Info	*/
	private String wscUsdLoclXchRt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();


	/**	Constructor	*/
	public RsltSearchMOTSSEFilingListVO(){}

	public RsltSearchMOTSSEFilingListVO(String ibflag,String pagerows,String testExecDt,String execDt,String svcScpCd,String fOrgCd,String updUsrId,String toFileDt,String frFileDt,String fileDt,String inqTpCd,String creUsrId,String motTrfSeq,String rtSeq,String batExeDt,String seq,String bkgSrcTpCd,String bkgNo,String carrier,String ctrtNo,String ctrtHldNm,String bkgShprNm,String bkgCneeNm,String foreTraComp,String operAgt,String lane,String wayPort,String polCd,String deptTsitPort,String destTsitPort,String podCd,String transTerm,String cntrTp,String cmdtTp,String cntrSz,String cntrVol1,String cntrVol2,String oftRt,String blnk1,String bafAmt,String cafAmt,String agsAmt,String cgdAmt,String cglAmt,String cssAmt,String ebsAmt,String eisAmt,String emsAmt,String eriAmt,String fafAmt,String lsfAmt,String pssAmt,String sctAmt,String codAmt,String dgsAmt,String gh2Amt,String gohAmt,String hazAmt,String heaAmt,String sesAmt,String thcAmt,String amsAmt,String bkfAmt,String cdcAmt,String cddAmt,String ctpAmt,String cyrAmt,String docAmt,String empAmt,String esdAmt,String psfAmt,String slfAmt,String tslAmt,String xdoAmt,String ahaAmt,String almAmt,String amaAmt,String ardAmt,String badAmt,String cccAmt,String cfdAmt,String cmcAmt,String csvAmt,String dofAmt,String drpAmt,String ediAmt,String ehdAmt,String hafAmt,String hauAmt,String ifiAmt,String insAmt,String kcsAmt,String lloAmt,String mplAmt,String pscAmt,String rhaAmt,String rlsAmt,String rpcAmt,String tsdAmt,String whaAmt,String xddAmt,String xdeAmt,String xerAmt,String xwfAmt,String ecaAmt,String wtrAmt,String crsAmt,String neoAmt,String ocrAmt,String effDt,String expDt,String remark,String tBucAmt,String tBafAmt,String tCsrAmt,String tCmsAmt,String tOthAmt,String tDhfAmt,String tFafAmt,String tFrcAmt,String tTscAmt,String tPscAmt,String tEnsAmt,String tStfAmt,String tDdcAmt,String tSzcAmt,String tCucAmt,String tDthAmt,String tHrsAmt,String tApsAmt,String tFrbAmt,String tOtsAmt,String tCfrAmt,String tOihAmt,String tTacAmt,String tActAmt,String tWscAmt,String agsCurrCd,String cgdCurrCd,String cglCurrCd,String cssCurrCd,String ebsCurrCd,String eisCurrCd,String emsCurrCd,String eriCurrCd,String fafCurrCd,String lsfCurrCd,String pssCurrCd,String sctCurrCd,String codCurrCd,String dgsCurrCd,String gh2CurrCd,String gohCurrCd,String hazCurrCd,String heaCurrCd,String sesCurrCd,String ecaCurrCd,String wtrCurrCd,String agsUsdLoclXchRt,String cgdUsdLoclXchRt,String cglUsdLoclXchRt,String cssUsdLoclXchRt,String ebsUsdLoclXchRt,String eisUsdLoclXchRt,String emsUsdLoclXchRt,String eriUsdLoclXchRt,String fafUsdLoclXchRt,String lsfUsdLoclXchRt,String pssUsdLoclXchRt,String sctUsdLoclXchRt,String codUsdLoclXchRt,String dgsUsdLoclXchRt,String gh2UsdLoclXchRt,String gohUsdLoclXchRt,String hazUsdLoclXchRt,String heaUsdLoclXchRt,String sesUsdLoclXchRt,String ecaUsdLoclXchRt,String wtrUsdLoclXchRt,String bucCurrCd,String csrCurrCd,String cmsCurrCd,String othCurrCd,String dhfCurrCd,String frcCurrCd,String tscCurrCd,String ensCurrCd,String stfCurrCd,String ddcCurrCd,String szcCurrCd,String cucCurrCd,String dthCurrCd,String hrsCurrCd,String apsCurrCd,String frbCurrCd,String otsCurrCd,String cfrCurrCd,String oihCurrCd,String tacCurrCd,String actCurrCd,String wscCurrCd,String bucUsdLoclXchRt,String csrUsdLoclXchRt,String cmsUsdLoclXchRt,String othUsdLoclXchRt,String dhfUsdLoclXchRt,String frcUsdLoclXchRt,String tscUsdLoclXchRt,String ensUsdLoclXchRt,String stfUsdLoclXchRt,String ddcUsdLoclXchRt,String szcUsdLoclXchRt,String cucUsdLoclXchRt,String dthUsdLoclXchRt,String hrsUsdLoclXchRt,String apsUsdLoclXchRt,String frbUsdLoclXchRt,String otsUsdLoclXchRt,String cfrUsdLoclXchRt,String oihUsdLoclXchRt,String tacUsdLoclXchRt,String actUsdLoclXchRt,String wscUsdLoclXchRt)	{
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.testExecDt = testExecDt;
		this.execDt = execDt;
		this.svcScpCd = svcScpCd;
		this.fOrgCd = fOrgCd;
		this.updUsrId = updUsrId;
		this.toFileDt = toFileDt;
		this.frFileDt = frFileDt;
		this.fileDt = fileDt;
		this.inqTpCd = inqTpCd;
		this.creUsrId = creUsrId;
		this.motTrfSeq = motTrfSeq;
		this.rtSeq = rtSeq;
		this.batExeDt = batExeDt;
		this.seq = seq;
		this.bkgSrcTpCd = bkgSrcTpCd;
		this.bkgNo = bkgNo;
		this.carrier = carrier;
		this.ctrtNo = ctrtNo;
		this.ctrtHldNm = ctrtHldNm;
		this.bkgShprNm = bkgShprNm;
		this.bkgCneeNm = bkgCneeNm;
		this.foreTraComp = foreTraComp;
		this.operAgt = operAgt;
		this.lane = lane;
		this.wayPort = wayPort;
		this.polCd = polCd;
		this.deptTsitPort = deptTsitPort;
		this.destTsitPort = destTsitPort;
		this.podCd = podCd;
		this.transTerm = transTerm;
		this.cntrTp = cntrTp;
		this.cmdtTp = cmdtTp;
		this.cntrSz = cntrSz;
		this.cntrVol1 = cntrVol1;
		this.cntrVol2 = cntrVol2;
		this.oftRt = oftRt;
		this.blnk1 = blnk1;
		this.bafAmt = bafAmt;
		this.cafAmt = cafAmt;
		this.agsAmt = agsAmt;
		this.cgdAmt = cgdAmt;
		this.cglAmt = cglAmt;
		this.cssAmt = cssAmt;
		this.ebsAmt = ebsAmt;
		this.eisAmt = eisAmt;
		this.emsAmt = emsAmt;
		this.eriAmt = eriAmt;
		this.fafAmt = fafAmt;
		this.lsfAmt = lsfAmt;
		this.pssAmt = pssAmt;
		this.sctAmt = sctAmt;
		this.codAmt = codAmt;
		this.dgsAmt = dgsAmt;
		this.gh2Amt = gh2Amt;
		this.gohAmt = gohAmt;
		this.hazAmt = hazAmt;
		this.heaAmt = heaAmt;
		this.sesAmt = sesAmt;
		this.thcAmt = thcAmt;
		this.amsAmt = amsAmt;
		this.bkfAmt = bkfAmt;
		this.cdcAmt = cdcAmt;
		this.cddAmt = cddAmt;
		this.ctpAmt = ctpAmt;
		this.cyrAmt = cyrAmt;
		this.docAmt = docAmt;
		this.empAmt = empAmt;
		this.esdAmt = esdAmt;
		this.psfAmt = psfAmt;
		this.slfAmt = slfAmt;
		this.tslAmt = tslAmt;
		this.xdoAmt = xdoAmt;
		this.ahaAmt = ahaAmt;
		this.almAmt = almAmt;
		this.amaAmt = amaAmt;
		this.ardAmt = ardAmt;
		this.badAmt = badAmt;
		this.cccAmt = cccAmt;
		this.cfdAmt = cfdAmt;
		this.cmcAmt = cmcAmt;
		this.csvAmt = csvAmt;
		this.dofAmt = dofAmt;
		this.drpAmt = drpAmt;
		this.ediAmt = ediAmt;
		this.ehdAmt = ehdAmt;
		this.hafAmt = hafAmt;
		this.hauAmt = hauAmt;
		this.ifiAmt = ifiAmt;
		this.insAmt = insAmt;
		this.kcsAmt = kcsAmt;
		this.lloAmt = lloAmt;
		this.mplAmt = mplAmt;
		this.pscAmt = pscAmt;
		this.rhaAmt = rhaAmt;
		this.rlsAmt = rlsAmt;
		this.rpcAmt = rpcAmt;
		this.tsdAmt = tsdAmt;
		this.whaAmt = whaAmt;
		this.xddAmt = xddAmt;
		this.xdeAmt = xdeAmt;
		this.xerAmt = xerAmt;
		this.xwfAmt = xwfAmt;
		this.ecaAmt = ecaAmt;
		this.wtrAmt = wtrAmt;
		this.crsAmt = crsAmt;
		this.neoAmt = neoAmt;
		this.ocrAmt = ocrAmt;
		this.effDt = effDt;
		this.expDt = expDt;
		this.remark = remark;
		this.tBucAmt = tBucAmt;
		this.tBafAmt = tBafAmt;
		this.tCsrAmt = tCsrAmt;
		this.tCmsAmt = tCmsAmt;
		this.tOthAmt = tOthAmt;
		this.tDhfAmt = tDhfAmt;
		this.tFafAmt = tFafAmt;
		this.tFrcAmt = tFrcAmt;
		this.tTscAmt = tTscAmt;
		this.tPscAmt = tPscAmt;
		this.tEnsAmt = tEnsAmt;
		this.tStfAmt = tStfAmt;
		this.tDdcAmt = tDdcAmt;
		this.tSzcAmt = tSzcAmt;
		this.tCucAmt = tCucAmt;
		this.tDthAmt = tDthAmt;
		this.tHrsAmt = tHrsAmt;
		this.tApsAmt = tApsAmt;
		this.tFrbAmt = tFrbAmt;
		this.tOtsAmt = tOtsAmt;
		this.tCfrAmt = tCfrAmt;
		this.tOihAmt = tOihAmt;
		this.tTacAmt = tTacAmt;
		this.tActAmt = tActAmt;
		this.tWscAmt = tWscAmt;
		this.agsCurrCd = agsCurrCd;
		this.cgdCurrCd = cgdCurrCd;
		this.cglCurrCd = cglCurrCd;
		this.cssCurrCd = cssCurrCd;
		this.ebsCurrCd = ebsCurrCd;
		this.eisCurrCd = eisCurrCd;
		this.emsCurrCd = emsCurrCd;
		this.eriCurrCd = eriCurrCd;
		this.fafCurrCd = fafCurrCd;
		this.lsfCurrCd = lsfCurrCd;
		this.pssCurrCd = pssCurrCd;
		this.sctCurrCd = sctCurrCd;
		this.codCurrCd = codCurrCd;
		this.dgsCurrCd = dgsCurrCd;
		this.gh2CurrCd = gh2CurrCd;
		this.gohCurrCd = gohCurrCd;
		this.hazCurrCd = hazCurrCd;
		this.heaCurrCd = heaCurrCd;
		this.sesCurrCd = sesCurrCd;
		this.ecaCurrCd = ecaCurrCd;
		this.wtrCurrCd = wtrCurrCd;
		this.agsUsdLoclXchRt = agsUsdLoclXchRt;
		this.cgdUsdLoclXchRt = cgdUsdLoclXchRt;
		this.cglUsdLoclXchRt = cglUsdLoclXchRt;
		this.cssUsdLoclXchRt = cssUsdLoclXchRt;
		this.ebsUsdLoclXchRt = ebsUsdLoclXchRt;
		this.eisUsdLoclXchRt = eisUsdLoclXchRt;
		this.emsUsdLoclXchRt = emsUsdLoclXchRt;
		this.eriUsdLoclXchRt = eriUsdLoclXchRt;
		this.fafUsdLoclXchRt = fafUsdLoclXchRt;
		this.lsfUsdLoclXchRt = lsfUsdLoclXchRt;
		this.pssUsdLoclXchRt = pssUsdLoclXchRt;
		this.sctUsdLoclXchRt = sctUsdLoclXchRt;
		this.codUsdLoclXchRt = codUsdLoclXchRt;
		this.dgsUsdLoclXchRt = dgsUsdLoclXchRt;
		this.gh2UsdLoclXchRt = gh2UsdLoclXchRt;
		this.gohUsdLoclXchRt = gohUsdLoclXchRt;
		this.hazUsdLoclXchRt = hazUsdLoclXchRt;
		this.heaUsdLoclXchRt = heaUsdLoclXchRt;
		this.sesUsdLoclXchRt = sesUsdLoclXchRt;
		this.ecaUsdLoclXchRt = ecaUsdLoclXchRt;
		this.wtrUsdLoclXchRt = wtrUsdLoclXchRt;
		this.bucCurrCd = bucCurrCd;
		this.csrCurrCd = csrCurrCd;
		this.cmsCurrCd = cmsCurrCd;
		this.othCurrCd = othCurrCd;
		this.dhfCurrCd = dhfCurrCd;
		this.frcCurrCd = frcCurrCd;
		this.tscCurrCd = tscCurrCd;
		this.ensCurrCd = ensCurrCd;
		this.stfCurrCd = stfCurrCd;
		this.ddcCurrCd = ddcCurrCd;
		this.szcCurrCd = szcCurrCd;
		this.cucCurrCd = cucCurrCd;
		this.dthCurrCd = dthCurrCd;
		this.hrsCurrCd = hrsCurrCd;
		this.apsCurrCd = apsCurrCd;
		this.frbCurrCd = frbCurrCd;
		this.otsCurrCd = otsCurrCd;
		this.cfrCurrCd = cfrCurrCd;
		this.oihCurrCd = oihCurrCd;
		this.tacCurrCd = tacCurrCd;
		this.actCurrCd = actCurrCd;
		this.wscCurrCd = wscCurrCd;
		this.bucUsdLoclXchRt = bucUsdLoclXchRt;
		this.csrUsdLoclXchRt = csrUsdLoclXchRt;
		this.cmsUsdLoclXchRt = cmsUsdLoclXchRt;
		this.othUsdLoclXchRt = othUsdLoclXchRt;
		this.dhfUsdLoclXchRt = dhfUsdLoclXchRt;
		this.frcUsdLoclXchRt = frcUsdLoclXchRt;
		this.tscUsdLoclXchRt = tscUsdLoclXchRt;
		this.ensUsdLoclXchRt = ensUsdLoclXchRt;
		this.stfUsdLoclXchRt = stfUsdLoclXchRt;
		this.ddcUsdLoclXchRt = ddcUsdLoclXchRt;
		this.szcUsdLoclXchRt = szcUsdLoclXchRt;
		this.cucUsdLoclXchRt = cucUsdLoclXchRt;
		this.dthUsdLoclXchRt = dthUsdLoclXchRt;
		this.hrsUsdLoclXchRt = hrsUsdLoclXchRt;
		this.apsUsdLoclXchRt = apsUsdLoclXchRt;
		this.frbUsdLoclXchRt = frbUsdLoclXchRt;
		this.otsUsdLoclXchRt = otsUsdLoclXchRt;
		this.cfrUsdLoclXchRt = cfrUsdLoclXchRt;
		this.oihUsdLoclXchRt = oihUsdLoclXchRt;
		this.tacUsdLoclXchRt = tacUsdLoclXchRt;
		this.actUsdLoclXchRt = actUsdLoclXchRt;
		this.wscUsdLoclXchRt = wscUsdLoclXchRt;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("test_exec_dt", getTestExecDt());
		this.hashColumns.put("exec_dt", getExecDt());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("f_org_cd", getFOrgCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("to_file_dt", getToFileDt());
		this.hashColumns.put("fr_file_dt", getFrFileDt());
		this.hashColumns.put("file_dt", getFileDt());
		this.hashColumns.put("inq_tp_cd", getInqTpCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("mot_trf_seq", getMotTrfSeq());
		this.hashColumns.put("rt_seq", getRtSeq());
		this.hashColumns.put("bat_exe_dt", getBatExeDt());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("bkg_src_tp_cd", getBkgSrcTpCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("carrier", getCarrier());
		this.hashColumns.put("ctrt_no", getCtrtNo());
		this.hashColumns.put("ctrt_hld_nm", getCtrtHldNm());
		this.hashColumns.put("bkg_shpr_nm", getBkgShprNm());
		this.hashColumns.put("bkg_cnee_nm", getBkgCneeNm());
		this.hashColumns.put("fore_tra_comp", getForeTraComp());
		this.hashColumns.put("oper_agt", getOperAgt());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("way_port", getWayPort());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("dept_tsit_port", getDeptTsitPort());
		this.hashColumns.put("dest_tsit_port", getDestTsitPort());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("trans_term", getTransTerm());
		this.hashColumns.put("cntr_tp", getCntrTp());
		this.hashColumns.put("cmdt_tp", getCmdtTp());
		this.hashColumns.put("cntr_sz", getCntrSz());
		this.hashColumns.put("cntr_vol1", getCntrVol1());
		this.hashColumns.put("cntr_vol2", getCntrVol2());
		this.hashColumns.put("oft_rt", getOftRt());
		this.hashColumns.put("blnk1", getBlnk1());
		this.hashColumns.put("baf_amt", getBafAmt());
		this.hashColumns.put("caf_amt", getCafAmt());
		this.hashColumns.put("ags_amt", getAgsAmt());
		this.hashColumns.put("cgd_amt", getCgdAmt());
		this.hashColumns.put("cgl_amt", getCglAmt());
		this.hashColumns.put("css_amt", getCssAmt());
		this.hashColumns.put("ebs_amt", getEbsAmt());
		this.hashColumns.put("eis_amt", getEisAmt());
		this.hashColumns.put("ems_amt", getEmsAmt());
		this.hashColumns.put("eri_amt", getEriAmt());
		this.hashColumns.put("faf_amt", getFafAmt());
		this.hashColumns.put("lsf_amt", getLsfAmt());
		this.hashColumns.put("pss_amt", getPssAmt());
		this.hashColumns.put("sct_amt", getSctAmt());
		this.hashColumns.put("cod_amt", getCodAmt());
		this.hashColumns.put("dgs_amt", getDgsAmt());
		this.hashColumns.put("gh2_amt", getGh2Amt());
		this.hashColumns.put("goh_amt", getGohAmt());
		this.hashColumns.put("haz_amt", getHazAmt());
		this.hashColumns.put("hea_amt", getHeaAmt());
		this.hashColumns.put("ses_amt", getSesAmt());
		this.hashColumns.put("thc_amt", getThcAmt());
		this.hashColumns.put("ams_amt", getAmsAmt());
		this.hashColumns.put("bkf_amt", getBkfAmt());
		this.hashColumns.put("cdc_amt", getCdcAmt());
		this.hashColumns.put("cdd_amt", getCddAmt());
		this.hashColumns.put("ctp_amt", getCtpAmt());
		this.hashColumns.put("cyr_amt", getCyrAmt());
		this.hashColumns.put("doc_amt", getDocAmt());
		this.hashColumns.put("emp_amt", getEmpAmt());
		this.hashColumns.put("esd_amt", getEsdAmt());
		this.hashColumns.put("psf_amt", getPsfAmt());
		this.hashColumns.put("slf_amt", getSlfAmt());
		this.hashColumns.put("tsl_amt", getTslAmt());
		this.hashColumns.put("xdo_amt", getXdoAmt());
		this.hashColumns.put("aha_amt", getAhaAmt());
		this.hashColumns.put("alm_amt", getAlmAmt());
		this.hashColumns.put("ama_amt", getAmaAmt());
		this.hashColumns.put("ard_amt", getArdAmt());
		this.hashColumns.put("bad_amt", getBadAmt());
		this.hashColumns.put("ccc_amt", getCccAmt());
		this.hashColumns.put("cfd_amt", getCfdAmt());
		this.hashColumns.put("cmc_amt", getCmcAmt());
		this.hashColumns.put("csv_amt", getCsvAmt());
		this.hashColumns.put("dof_amt", getDofAmt());
		this.hashColumns.put("drp_amt", getDrpAmt());
		this.hashColumns.put("edi_amt", getEdiAmt());
		this.hashColumns.put("ehd_amt", getEhdAmt());
		this.hashColumns.put("haf_amt", getHafAmt());
		this.hashColumns.put("hau_amt", getHauAmt());
		this.hashColumns.put("ifi_amt", getIfiAmt());
		this.hashColumns.put("ins_amt", getInsAmt());
		this.hashColumns.put("kcs_amt", getKcsAmt());
		this.hashColumns.put("llo_amt", getLloAmt());
		this.hashColumns.put("mpl_amt", getMplAmt());
		this.hashColumns.put("psc_amt", getPscAmt());
		this.hashColumns.put("rha_amt", getRhaAmt());
		this.hashColumns.put("rls_amt", getRlsAmt());
		this.hashColumns.put("rpc_amt", getRpcAmt());
		this.hashColumns.put("tsd_amt", getTsdAmt());
		this.hashColumns.put("wha_amt", getWhaAmt());
		this.hashColumns.put("xdd_amt", getXddAmt());
		this.hashColumns.put("xde_amt", getXdeAmt());
		this.hashColumns.put("xer_amt", getXerAmt());
		this.hashColumns.put("xwf_amt", getXwfAmt());
		this.hashColumns.put("eca_amt", getEcaAmt());
		this.hashColumns.put("wtr_amt", getWtrAmt());
		this.hashColumns.put("crs_amt", getCrsAmt());
		this.hashColumns.put("neo_amt", getNeoAmt());
		this.hashColumns.put("ocr_amt", getOcrAmt());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("remark", getRemark());
		this.hashColumns.put("t_buc_amt", getTBucAmt());
		this.hashColumns.put("t_baf_amt", getTBafAmt());
		this.hashColumns.put("t_csr_amt", getTCsrAmt());
		this.hashColumns.put("t_cms_amt", getTCmsAmt());
		this.hashColumns.put("t_oth_amt", getTOthAmt());
		this.hashColumns.put("t_dhf_amt", getTDhfAmt());
		this.hashColumns.put("t_faf_amt", getTFafAmt());
		this.hashColumns.put("t_frc_amt", getTFrcAmt());
		this.hashColumns.put("t_tsc_amt", getTTscAmt());
		this.hashColumns.put("t_psc_amt", getTPscAmt());
		this.hashColumns.put("t_ens_amt", getTEnsAmt());
		this.hashColumns.put("t_stf_amt", getTStfAmt());
		this.hashColumns.put("t_ddc_amt", getTDdcAmt());
		this.hashColumns.put("t_szc_amt", getTSzcAmt());
		this.hashColumns.put("t_cuc_amt", getTCucAmt());
		this.hashColumns.put("t_dth_amt", getTDthAmt());
		this.hashColumns.put("t_hrs_amt", getTHrsAmt());
		this.hashColumns.put("t_aps_amt", getTApsAmt());
		this.hashColumns.put("t_frb_amt", getTFrbAmt());
		this.hashColumns.put("t_ots_amt", getTOtsAmt());
		this.hashColumns.put("t_cfr_amt", getTCfrAmt());
		this.hashColumns.put("t_oih_amt", getTOihAmt());
		this.hashColumns.put("t_tac_amt", getTTacAmt());
		this.hashColumns.put("t_act_amt", getTActAmt());
		this.hashColumns.put("t_wsc_amt", getTWscAmt());
		this.hashColumns.put("ags_curr_cd", getAgsCurrCd());
		this.hashColumns.put("cgd_curr_cd", getCgdCurrCd());
		this.hashColumns.put("cgl_curr_cd", getCglCurrCd());
		this.hashColumns.put("css_curr_cd", getCssCurrCd());
		this.hashColumns.put("ebs_curr_cd", getEbsCurrCd());
		this.hashColumns.put("eis_curr_cd", getEisCurrCd());
		this.hashColumns.put("ems_curr_cd", getEmsCurrCd());
		this.hashColumns.put("eri_curr_cd", getEriCurrCd());
		this.hashColumns.put("faf_curr_cd", getFafCurrCd());
		this.hashColumns.put("lsf_curr_cd", getLsfCurrCd());
		this.hashColumns.put("pss_curr_cd", getPssCurrCd());
		this.hashColumns.put("sct_curr_cd", getSctCurrCd());
		this.hashColumns.put("cod_curr_cd", getCodCurrCd());
		this.hashColumns.put("dgs_curr_cd", getDgsCurrCd());
		this.hashColumns.put("gh2_curr_cd", getGh2CurrCd());
		this.hashColumns.put("goh_curr_cd", getGohCurrCd());
		this.hashColumns.put("haz_curr_cd", getHazCurrCd());
		this.hashColumns.put("hea_curr_cd", getHeaCurrCd());
		this.hashColumns.put("ses_curr_cd", getSesCurrCd());
		this.hashColumns.put("eca_curr_cd", getEcaCurrCd());
		this.hashColumns.put("wtr_curr_cd", getWtrCurrCd());
		this.hashColumns.put("ags_usd_locl_xch_rt", getAgsUsdLoclXchRt());
		this.hashColumns.put("cgd_usd_locl_xch_rt", getCgdUsdLoclXchRt());
		this.hashColumns.put("cgl_usd_locl_xch_rt", getCglUsdLoclXchRt());
		this.hashColumns.put("css_usd_locl_xch_rt", getCssUsdLoclXchRt());
		this.hashColumns.put("ebs_usd_locl_xch_rt", getEbsUsdLoclXchRt());
		this.hashColumns.put("eis_usd_locl_xch_rt", getEisUsdLoclXchRt());
		this.hashColumns.put("ems_usd_locl_xch_rt", getEmsUsdLoclXchRt());
		this.hashColumns.put("eri_usd_locl_xch_rt", getEriUsdLoclXchRt());
		this.hashColumns.put("faf_usd_locl_xch_rt", getFafUsdLoclXchRt());
		this.hashColumns.put("lsf_usd_locl_xch_rt", getLsfUsdLoclXchRt());
		this.hashColumns.put("pss_usd_locl_xch_rt", getPssUsdLoclXchRt());
		this.hashColumns.put("sct_usd_locl_xch_rt", getSctUsdLoclXchRt());
		this.hashColumns.put("cod_usd_locl_xch_rt", getCodUsdLoclXchRt());
		this.hashColumns.put("dgs_usd_locl_xch_rt", getDgsUsdLoclXchRt());
		this.hashColumns.put("gh2_usd_locl_xch_rt", getGh2UsdLoclXchRt());
		this.hashColumns.put("goh_usd_locl_xch_rt", getGohUsdLoclXchRt());
		this.hashColumns.put("haz_usd_locl_xch_rt", getHazUsdLoclXchRt());
		this.hashColumns.put("hea_usd_locl_xch_rt", getHeaUsdLoclXchRt());
		this.hashColumns.put("ses_usd_locl_xch_rt", getSesUsdLoclXchRt());
		this.hashColumns.put("eca_usd_locl_xch_rt", getEcaUsdLoclXchRt());
		this.hashColumns.put("wtr_usd_locl_xch_rt", getWtrUsdLoclXchRt());
		this.hashColumns.put("buc_curr_cd", getBucCurrCd());
		this.hashColumns.put("csr_curr_cd", getCsrCurrCd());
		this.hashColumns.put("cms_curr_cd", getCmsCurrCd());
		this.hashColumns.put("oth_curr_cd", getOthCurrCd());
		this.hashColumns.put("dhf_curr_cd", getDhfCurrCd());
		this.hashColumns.put("frc_curr_cd", getFrcCurrCd());
		this.hashColumns.put("tsc_curr_cd", getTscCurrCd());
		this.hashColumns.put("ens_curr_cd", getEnsCurrCd());
		this.hashColumns.put("stf_curr_cd", getStfCurrCd());
		this.hashColumns.put("ddc_curr_cd", getDdcCurrCd());
		this.hashColumns.put("szc_curr_cd", getSzcCurrCd());
		this.hashColumns.put("cuc_curr_cd", getCucCurrCd());
		this.hashColumns.put("dth_curr_cd", getDthCurrCd());
		this.hashColumns.put("hrs_curr_cd", getHrsCurrCd());
		this.hashColumns.put("aps_curr_cd", getApsCurrCd());
		this.hashColumns.put("frb_curr_cd", getFrbCurrCd());
		this.hashColumns.put("ots_curr_cd", getOtsCurrCd());
		this.hashColumns.put("cfr_curr_cd", getCfrCurrCd());
		this.hashColumns.put("oih_curr_cd", getOihCurrCd());
		this.hashColumns.put("tac_curr_cd", getTacCurrCd());
		this.hashColumns.put("act_curr_cd", getActCurrCd());
		this.hashColumns.put("wsc_curr_cd", getWscCurrCd());
		this.hashColumns.put("buc_usd_locl_xch_rt", getBucUsdLoclXchRt());
		this.hashColumns.put("csr_usd_locl_xch_rt", getCsrUsdLoclXchRt());
		this.hashColumns.put("cms_usd_locl_xch_rt", getCmsUsdLoclXchRt());
		this.hashColumns.put("oth_usd_locl_xch_rt", getOthUsdLoclXchRt());
		this.hashColumns.put("dhf_usd_locl_xch_rt", getDhfUsdLoclXchRt());
		this.hashColumns.put("frc_usd_locl_xch_rt", getFrcUsdLoclXchRt());
		this.hashColumns.put("tsc_usd_locl_xch_rt", getTscUsdLoclXchRt());
		this.hashColumns.put("ens_usd_locl_xch_rt", getEnsUsdLoclXchRt());
		this.hashColumns.put("stf_usd_locl_xch_rt", getStfUsdLoclXchRt());
		this.hashColumns.put("ddc_usd_locl_xch_rt", getDdcUsdLoclXchRt());
		this.hashColumns.put("szc_usd_locl_xch_rt", getSzcUsdLoclXchRt());
		this.hashColumns.put("cuc_usd_locl_xch_rt", getCucUsdLoclXchRt());
		this.hashColumns.put("dth_usd_locl_xch_rt", getDthUsdLoclXchRt());
		this.hashColumns.put("hrs_usd_locl_xch_rt", getHrsUsdLoclXchRt());
		this.hashColumns.put("aps_usd_locl_xch_rt", getApsUsdLoclXchRt());
		this.hashColumns.put("frb_usd_locl_xch_rt", getFrbUsdLoclXchRt());
		this.hashColumns.put("ots_usd_locl_xch_rt", getOtsUsdLoclXchRt());
		this.hashColumns.put("cfr_usd_locl_xch_rt", getCfrUsdLoclXchRt());
		this.hashColumns.put("oih_usd_locl_xch_rt", getOihUsdLoclXchRt());
		this.hashColumns.put("tac_usd_locl_xch_rt", getTacUsdLoclXchRt());
		this.hashColumns.put("act_usd_locl_xch_rt", getActUsdLoclXchRt());
		this.hashColumns.put("wsc_usd_locl_xch_rt", getWscUsdLoclXchRt());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("test_exec_dt", "testExecDt");
		this.hashFields.put("exec_dt", "execDt");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("f_org_cd", "fOrgCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("to_file_dt", "toFileDt");
		this.hashFields.put("fr_file_dt", "frFileDt");
		this.hashFields.put("file_dt", "fileDt");
		this.hashFields.put("inq_tp_cd", "inqTpCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("mot_trf_seq", "motTrfSeq");
		this.hashFields.put("rt_seq", "rtSeq");
		this.hashFields.put("bat_exe_dt", "batExeDt");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("bkg_src_tp_cd", "bkgSrcTpCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("carrier", "carrier");
		this.hashFields.put("ctrt_no", "ctrtNo");
		this.hashFields.put("ctrt_hld_nm", "ctrtHldNm");
		this.hashFields.put("bkg_shpr_nm", "bkgShprNm");
		this.hashFields.put("bkg_cnee_nm", "bkgCneeNm");
		this.hashFields.put("fore_tra_comp", "foreTraComp");
		this.hashFields.put("oper_agt", "operAgt");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("way_port", "wayPort");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("dept_tsit_port", "deptTsitPort");
		this.hashFields.put("dest_tsit_port", "destTsitPort");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("trans_term", "transTerm");
		this.hashFields.put("cntr_tp", "cntrTp");
		this.hashFields.put("cmdt_tp", "cmdtTp");
		this.hashFields.put("cntr_sz", "cntrSz");
		this.hashFields.put("cntr_vol1", "cntrVol1");
		this.hashFields.put("cntr_vol2", "cntrVol2");
		this.hashFields.put("oft_rt", "oftRt");
		this.hashFields.put("blnk1", "blnk1");
		this.hashFields.put("baf_amt", "bafAmt");
		this.hashFields.put("caf_amt", "cafAmt");
		this.hashFields.put("ags_amt", "agsAmt");
		this.hashFields.put("cgd_amt", "cgdAmt");
		this.hashFields.put("cgl_amt", "cglAmt");
		this.hashFields.put("css_amt", "cssAmt");
		this.hashFields.put("ebs_amt", "ebsAmt");
		this.hashFields.put("eis_amt", "eisAmt");
		this.hashFields.put("ems_amt", "emsAmt");
		this.hashFields.put("eri_amt", "eriAmt");
		this.hashFields.put("faf_amt", "fafAmt");
		this.hashFields.put("lsf_amt", "lsfAmt");
		this.hashFields.put("pss_amt", "pssAmt");
		this.hashFields.put("sct_amt", "sctAmt");
		this.hashFields.put("cod_amt", "codAmt");
		this.hashFields.put("dgs_amt", "dgsAmt");
		this.hashFields.put("gh2_amt", "gh2Amt");
		this.hashFields.put("goh_amt", "gohAmt");
		this.hashFields.put("haz_amt", "hazAmt");
		this.hashFields.put("hea_amt", "heaAmt");
		this.hashFields.put("ses_amt", "sesAmt");
		this.hashFields.put("thc_amt", "thcAmt");
		this.hashFields.put("ams_amt", "amsAmt");
		this.hashFields.put("bkf_amt", "bkfAmt");
		this.hashFields.put("cdc_amt", "cdcAmt");
		this.hashFields.put("cdd_amt", "cddAmt");
		this.hashFields.put("ctp_amt", "ctpAmt");
		this.hashFields.put("cyr_amt", "cyrAmt");
		this.hashFields.put("doc_amt", "docAmt");
		this.hashFields.put("emp_amt", "empAmt");
		this.hashFields.put("esd_amt", "esdAmt");
		this.hashFields.put("psf_amt", "psfAmt");
		this.hashFields.put("slf_amt", "slfAmt");
		this.hashFields.put("tsl_amt", "tslAmt");
		this.hashFields.put("xdo_amt", "xdoAmt");
		this.hashFields.put("aha_amt", "ahaAmt");
		this.hashFields.put("alm_amt", "almAmt");
		this.hashFields.put("ama_amt", "amaAmt");
		this.hashFields.put("ard_amt", "ardAmt");
		this.hashFields.put("bad_amt", "badAmt");
		this.hashFields.put("ccc_amt", "cccAmt");
		this.hashFields.put("cfd_amt", "cfdAmt");
		this.hashFields.put("cmc_amt", "cmcAmt");
		this.hashFields.put("csv_amt", "csvAmt");
		this.hashFields.put("dof_amt", "dofAmt");
		this.hashFields.put("drp_amt", "drpAmt");
		this.hashFields.put("edi_amt", "ediAmt");
		this.hashFields.put("ehd_amt", "ehdAmt");
		this.hashFields.put("haf_amt", "hafAmt");
		this.hashFields.put("hau_amt", "hauAmt");
		this.hashFields.put("ifi_amt", "ifiAmt");
		this.hashFields.put("ins_amt", "insAmt");
		this.hashFields.put("kcs_amt", "kcsAmt");
		this.hashFields.put("llo_amt", "lloAmt");
		this.hashFields.put("mpl_amt", "mplAmt");
		this.hashFields.put("psc_amt", "pscAmt");
		this.hashFields.put("rha_amt", "rhaAmt");
		this.hashFields.put("rls_amt", "rlsAmt");
		this.hashFields.put("rpc_amt", "rpcAmt");
		this.hashFields.put("tsd_amt", "tsdAmt");
		this.hashFields.put("wha_amt", "whaAmt");
		this.hashFields.put("xdd_amt", "xddAmt");
		this.hashFields.put("xde_amt", "xdeAmt");
		this.hashFields.put("xer_amt", "xerAmt");
		this.hashFields.put("xwf_amt", "xwfAmt");
		this.hashFields.put("eca_amt", "ecaAmt");
		this.hashFields.put("wtr_amt", "wtrAmt");
		this.hashFields.put("crs_amt", "crsAmt");
		this.hashFields.put("neo_amt", "neoAmt");
		this.hashFields.put("ocr_amt", "ocrAmt");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("remark", "remark");
		this.hashFields.put("t_buc_amt", "tBucAmt");
		this.hashFields.put("t_baf_amt", "tBafAmt");
		this.hashFields.put("t_csr_amt", "tCsrAmt");
		this.hashFields.put("t_cms_amt", "tCmsAmt");
		this.hashFields.put("t_oth_amt", "tOthAmt");
		this.hashFields.put("t_dhf_amt", "tDhfAmt");
		this.hashFields.put("t_faf_amt", "tFafAmt");
		this.hashFields.put("t_frc_amt", "tFrcAmt");
		this.hashFields.put("t_tsc_amt", "tTscAmt");
		this.hashFields.put("t_psc_amt", "tPscAmt");
		this.hashFields.put("t_ens_amt", "tEnsAmt");
		this.hashFields.put("t_stf_amt", "tStfAmt");
		this.hashFields.put("t_ddc_amt", "tDdcAmt");
		this.hashFields.put("t_szc_amt", "tSzcAmt");
		this.hashFields.put("t_cuc_amt", "tCucAmt");
		this.hashFields.put("t_dth_amt", "tDthAmt");
		this.hashFields.put("t_hrs_amt", "tHrsAmt");
		this.hashFields.put("t_aps_amt", "tApsAmt");
		this.hashFields.put("t_frb_amt", "tFrbAmt");
		this.hashFields.put("t_ots_amt", "tOtsAmt");
		this.hashFields.put("t_cfr_amt", "tCfrAmt");
		this.hashFields.put("t_oih_amt", "tOihAmt");
		this.hashFields.put("t_tac_amt", "tTacAmt");
		this.hashFields.put("t_act_amt", "tActAmt");
		this.hashFields.put("t_wsc_amt", "tWscAmt");
		this.hashFields.put("ags_curr_cd", "agsCurrCd");
		this.hashFields.put("cgd_curr_cd", "cgdCurrCd");
		this.hashFields.put("cgl_curr_cd", "cglCurrCd");
		this.hashFields.put("css_curr_cd", "cssCurrCd");
		this.hashFields.put("ebs_curr_cd", "ebsCurrCd");
		this.hashFields.put("eis_curr_cd", "eisCurrCd");
		this.hashFields.put("ems_curr_cd", "emsCurrCd");
		this.hashFields.put("eri_curr_cd", "eriCurrCd");
		this.hashFields.put("faf_curr_cd", "fafCurrCd");
		this.hashFields.put("lsf_curr_cd", "lsfCurrCd");
		this.hashFields.put("pss_curr_cd", "pssCurrCd");
		this.hashFields.put("sct_curr_cd", "sctCurrCd");
		this.hashFields.put("cod_curr_cd", "codCurrCd");
		this.hashFields.put("dgs_curr_cd", "dgsCurrCd");
		this.hashFields.put("gh2_curr_cd", "gh2CurrCd");
		this.hashFields.put("goh_curr_cd", "gohCurrCd");
		this.hashFields.put("haz_curr_cd", "hazCurrCd");
		this.hashFields.put("hea_curr_cd", "heaCurrCd");
		this.hashFields.put("ses_curr_cd", "sesCurrCd");
		this.hashFields.put("eca_curr_cd", "ecaCurrCd");
		this.hashFields.put("wtr_curr_cd", "wtrCurrCd");
		this.hashFields.put("ags_usd_locl_xch_rt", "agsUsdLoclXchRt");
		this.hashFields.put("cgd_usd_locl_xch_rt", "cgdUsdLoclXchRt");
		this.hashFields.put("cgl_usd_locl_xch_rt", "cglUsdLoclXchRt");
		this.hashFields.put("css_usd_locl_xch_rt", "cssUsdLoclXchRt");
		this.hashFields.put("ebs_usd_locl_xch_rt", "ebsUsdLoclXchRt");
		this.hashFields.put("eis_usd_locl_xch_rt", "eisUsdLoclXchRt");
		this.hashFields.put("ems_usd_locl_xch_rt", "emsUsdLoclXchRt");
		this.hashFields.put("eri_usd_locl_xch_rt", "eriUsdLoclXchRt");
		this.hashFields.put("faf_usd_locl_xch_rt", "fafUsdLoclXchRt");
		this.hashFields.put("lsf_usd_locl_xch_rt", "lsfUsdLoclXchRt");
		this.hashFields.put("pss_usd_locl_xch_rt", "pssUsdLoclXchRt");
		this.hashFields.put("sct_usd_locl_xch_rt", "sctUsdLoclXchRt");
		this.hashFields.put("cod_usd_locl_xch_rt", "codUsdLoclXchRt");
		this.hashFields.put("dgs_usd_locl_xch_rt", "dgsUsdLoclXchRt");
		this.hashFields.put("gh2_usd_locl_xch_rt", "gh2UsdLoclXchRt");
		this.hashFields.put("goh_usd_locl_xch_rt", "gohUsdLoclXchRt");
		this.hashFields.put("haz_usd_locl_xch_rt", "hazUsdLoclXchRt");
		this.hashFields.put("hea_usd_locl_xch_rt", "heaUsdLoclXchRt");
		this.hashFields.put("ses_usd_locl_xch_rt", "sesUsdLoclXchRt");
		this.hashFields.put("eca_usd_locl_xch_rt", "ecaUsdLoclXchRt");
		this.hashFields.put("wtr_usd_locl_xch_rt", "wtrUsdLoclXchRt");
		this.hashFields.put("buc_curr_cd", "bucCurrCd");
		this.hashFields.put("csr_curr_cd", "csrCurrCd");
		this.hashFields.put("cms_curr_cd", "cmsCurrCd");
		this.hashFields.put("oth_curr_cd", "othCurrCd");
		this.hashFields.put("dhf_curr_cd", "dhfCurrCd");
		this.hashFields.put("frc_curr_cd", "frcCurrCd");
		this.hashFields.put("tsc_curr_cd", "tscCurrCd");
		this.hashFields.put("ens_curr_cd", "ensCurrCd");
		this.hashFields.put("stf_curr_cd", "stfCurrCd");
		this.hashFields.put("ddc_curr_cd", "ddcCurrCd");
		this.hashFields.put("szc_curr_cd", "szcCurrCd");
		this.hashFields.put("cuc_curr_cd", "cucCurrCd");
		this.hashFields.put("dth_curr_cd", "dthCurrCd");
		this.hashFields.put("hrs_curr_cd", "hrsCurrCd");
		this.hashFields.put("aps_curr_cd", "apsCurrCd");
		this.hashFields.put("frb_curr_cd", "frbCurrCd");
		this.hashFields.put("ots_curr_cd", "otsCurrCd");
		this.hashFields.put("cfr_curr_cd", "cfrCurrCd");
		this.hashFields.put("oih_curr_cd", "oihCurrCd");
		this.hashFields.put("tac_curr_cd", "tacCurrCd");
		this.hashFields.put("act_curr_cd", "actCurrCd");
		this.hashFields.put("wsc_curr_cd", "wscCurrCd");
		this.hashFields.put("buc_usd_locl_xch_rt", "bucUsdLoclXchRt");
		this.hashFields.put("csr_usd_locl_xch_rt", "csrUsdLoclXchRt");
		this.hashFields.put("cms_usd_locl_xch_rt", "cmsUsdLoclXchRt");
		this.hashFields.put("oth_usd_locl_xch_rt", "othUsdLoclXchRt");
		this.hashFields.put("dhf_usd_locl_xch_rt", "dhfUsdLoclXchRt");
		this.hashFields.put("frc_usd_locl_xch_rt", "frcUsdLoclXchRt");
		this.hashFields.put("tsc_usd_locl_xch_rt", "tscUsdLoclXchRt");
		this.hashFields.put("ens_usd_locl_xch_rt", "ensUsdLoclXchRt");
		this.hashFields.put("stf_usd_locl_xch_rt", "stfUsdLoclXchRt");
		this.hashFields.put("ddc_usd_locl_xch_rt", "ddcUsdLoclXchRt");
		this.hashFields.put("szc_usd_locl_xch_rt", "szcUsdLoclXchRt");
		this.hashFields.put("cuc_usd_locl_xch_rt", "cucUsdLoclXchRt");
		this.hashFields.put("dth_usd_locl_xch_rt", "dthUsdLoclXchRt");
		this.hashFields.put("hrs_usd_locl_xch_rt", "hrsUsdLoclXchRt");
		this.hashFields.put("aps_usd_locl_xch_rt", "apsUsdLoclXchRt");
		this.hashFields.put("frb_usd_locl_xch_rt", "frbUsdLoclXchRt");
		this.hashFields.put("ots_usd_locl_xch_rt", "otsUsdLoclXchRt");
		this.hashFields.put("cfr_usd_locl_xch_rt", "cfrUsdLoclXchRt");
		this.hashFields.put("oih_usd_locl_xch_rt", "oihUsdLoclXchRt");
		this.hashFields.put("tac_usd_locl_xch_rt", "tacUsdLoclXchRt");
		this.hashFields.put("act_usd_locl_xch_rt", "actUsdLoclXchRt");
		this.hashFields.put("wsc_usd_locl_xch_rt", "wscUsdLoclXchRt");
		return this.hashFields;
	}

	//	Getters	and	Setters

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public	String getIbflag() {
		return	this.ibflag;
	}

	/**
	 * Page Number
	 * @return pagerows
	 */
	public	String getPagerows() {
		return	this.pagerows;
	}

	/**
	 * Column Info
	 * @return testExecDt
	 */
	public	String getTestExecDt() {
		return	this.testExecDt;
	}

	/**
	 * Column Info
	 * @return execDt
	 */
	public	String getExecDt() {
		return	this.execDt;
	}

	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public	String getSvcScpCd() {
		return	this.svcScpCd;
	}

	/**
	 * Column Info
	 * @return fOrgCd
	 */
	public	String getFOrgCd() {
		return	this.fOrgCd;
	}

	/**
	 * Column Info
	 * @return updUsrId
	 */
	public	String getUpdUsrId() {
		return	this.updUsrId;
	}

	/**
	 * Column Info
	 * @return toFileDt
	 */
	public	String getToFileDt() {
		return	this.toFileDt;
	}

	/**
	 * Column Info
	 * @return frFileDt
	 */
	public	String getFrFileDt() {
		return	this.frFileDt;
	}

	/**
	 * Column Info
	 * @return fileDt
	 */
	public	String getFileDt() {
		return	this.fileDt;
	}

	/**
	 * Column Info
	 * @return inqTpCd
	 */
	public	String getInqTpCd() {
		return	this.inqTpCd;
	}

	/**
	 * Column Info
	 * @return creUsrId
	 */
	public	String getCreUsrId() {
		return	this.creUsrId;
	}

	/**
	 * Column Info
	 * @return motTrfSeq
	 */
	public	String getMotTrfSeq() {
		return	this.motTrfSeq;
	}

	/**
	 * Column Info
	 * @return rtSeq
	 */
	public	String getRtSeq() {
		return	this.rtSeq;
	}

	/**
	 * Column Info
	 * @return batExeDt
	 */
	public	String getBatExeDt() {
		return	this.batExeDt;
	}

	/**
	 * Column Info
	 * @return seq
	 */
	public	String getSeq() {
		return	this.seq;
	}

	/**
	 * Column Info
	 * @return bkgSrcTpCd
	 */
	public	String getBkgSrcTpCd() {
		return	this.bkgSrcTpCd;
	}

	/**
	 * Column Info
	 * @return bkgNo
	 */
	public	String getBkgNo() {
		return	this.bkgNo;
	}

	/**
	 * Column Info
	 * @return carrier
	 */
	public	String getCarrier() {
		return	this.carrier;
	}

	/**
	 * Column Info
	 * @return ctrtNo
	 */
	public	String getCtrtNo() {
		return	this.ctrtNo;
	}

	/**
	 * Column Info
	 * @return ctrtHldNm
	 */
	public	String getCtrtHldNm() {
		return	this.ctrtHldNm;
	}

	/**
	 * Column Info
	 * @return bkgShprNm
	 */
	public	String getBkgShprNm() {
		return	this.bkgShprNm;
	}

	/**
	 * Column Info
	 * @return bkgCneeNm
	 */
	public	String getBkgCneeNm() {
		return	this.bkgCneeNm;
	}

	/**
	 * Column Info
	 * @return foreTraComp
	 */
	public	String getForeTraComp() {
		return	this.foreTraComp;
	}

	/**
	 * Column Info
	 * @return operAgt
	 */
	public	String getOperAgt() {
		return	this.operAgt;
	}

	/**
	 * Column Info
	 * @return lane
	 */
	public	String getLane() {
		return	this.lane;
	}

	/**
	 * Column Info
	 * @return wayPort
	 */
	public	String getWayPort() {
		return	this.wayPort;
	}

	/**
	 * Column Info
	 * @return polCd
	 */
	public	String getPolCd() {
		return	this.polCd;
	}

	/**
	 * Column Info
	 * @return deptTsitPort
	 */
	public	String getDeptTsitPort() {
		return	this.deptTsitPort;
	}

	/**
	 * Column Info
	 * @return destTsitPort
	 */
	public	String getDestTsitPort() {
		return	this.destTsitPort;
	}

	/**
	 * Column Info
	 * @return podCd
	 */
	public	String getPodCd() {
		return	this.podCd;
	}

	/**
	 * Column Info
	 * @return transTerm
	 */
	public	String getTransTerm() {
		return	this.transTerm;
	}

	/**
	 * Column Info
	 * @return cntrTp
	 */
	public	String getCntrTp() {
		return	this.cntrTp;
	}

	/**
	 * Column Info
	 * @return cmdtTp
	 */
	public	String getCmdtTp() {
		return	this.cmdtTp;
	}

	/**
	 * Column Info
	 * @return cntrSz
	 */
	public	String getCntrSz() {
		return	this.cntrSz;
	}

	/**
	 * Column Info
	 * @return cntrVol1
	 */
	public	String getCntrVol1() {
		return	this.cntrVol1;
	}

	/**
	 * Column Info
	 * @return cntrVol2
	 */
	public	String getCntrVol2() {
		return	this.cntrVol2;
	}

	/**
	 * Column Info
	 * @return oftRt
	 */
	public	String getOftRt() {
		return	this.oftRt;
	}

	/**
	 * Column Info
	 * @return blnk1
	 */
	public	String getBlnk1() {
		return	this.blnk1;
	}

	/**
	 * Column Info
	 * @return bafAmt
	 */
	public	String getBafAmt() {
		return	this.bafAmt;
	}

	/**
	 * Column Info
	 * @return cafAmt
	 */
	public	String getCafAmt() {
		return	this.cafAmt;
	}

	/**
	 * Column Info
	 * @return agsAmt
	 */
	public	String getAgsAmt() {
		return	this.agsAmt;
	}

	/**
	 * Column Info
	 * @return cgdAmt
	 */
	public	String getCgdAmt() {
		return	this.cgdAmt;
	}

	/**
	 * Column Info
	 * @return cglAmt
	 */
	public	String getCglAmt() {
		return	this.cglAmt;
	}

	/**
	 * Column Info
	 * @return cssAmt
	 */
	public	String getCssAmt() {
		return	this.cssAmt;
	}

	/**
	 * Column Info
	 * @return ebsAmt
	 */
	public	String getEbsAmt() {
		return	this.ebsAmt;
	}

	/**
	 * Column Info
	 * @return eisAmt
	 */
	public	String getEisAmt() {
		return	this.eisAmt;
	}

	/**
	 * Column Info
	 * @return emsAmt
	 */
	public	String getEmsAmt() {
		return	this.emsAmt;
	}

	/**
	 * Column Info
	 * @return eriAmt
	 */
	public	String getEriAmt() {
		return	this.eriAmt;
	}

	/**
	 * Column Info
	 * @return fafAmt
	 */
	public	String getFafAmt() {
		return	this.fafAmt;
	}

	/**
	 * Column Info
	 * @return lsfAmt
	 */
	public	String getLsfAmt() {
		return	this.lsfAmt;
	}

	/**
	 * Column Info
	 * @return pssAmt
	 */
	public	String getPssAmt() {
		return	this.pssAmt;
	}

	/**
	 * Column Info
	 * @return sctAmt
	 */
	public	String getSctAmt() {
		return	this.sctAmt;
	}

	/**
	 * Column Info
	 * @return codAmt
	 */
	public	String getCodAmt() {
		return	this.codAmt;
	}

	/**
	 * Column Info
	 * @return dgsAmt
	 */
	public	String getDgsAmt() {
		return	this.dgsAmt;
	}

	/**
	 * Column Info
	 * @return gh2Amt
	 */
	public	String getGh2Amt() {
		return	this.gh2Amt;
	}

	/**
	 * Column Info
	 * @return gohAmt
	 */
	public	String getGohAmt() {
		return	this.gohAmt;
	}

	/**
	 * Column Info
	 * @return hazAmt
	 */
	public	String getHazAmt() {
		return	this.hazAmt;
	}

	/**
	 * Column Info
	 * @return heaAmt
	 */
	public	String getHeaAmt() {
		return	this.heaAmt;
	}

	/**
	 * Column Info
	 * @return sesAmt
	 */
	public	String getSesAmt() {
		return	this.sesAmt;
	}

	/**
	 * Column Info
	 * @return thcAmt
	 */
	public	String getThcAmt() {
		return	this.thcAmt;
	}

	/**
	 * Column Info
	 * @return amsAmt
	 */
	public	String getAmsAmt() {
		return	this.amsAmt;
	}

	/**
	 * Column Info
	 * @return bkfAmt
	 */
	public	String getBkfAmt() {
		return	this.bkfAmt;
	}

	/**
	 * Column Info
	 * @return cdcAmt
	 */
	public	String getCdcAmt() {
		return	this.cdcAmt;
	}

	/**
	 * Column Info
	 * @return cddAmt
	 */
	public	String getCddAmt() {
		return	this.cddAmt;
	}

	/**
	 * Column Info
	 * @return ctpAmt
	 */
	public	String getCtpAmt() {
		return	this.ctpAmt;
	}

	/**
	 * Column Info
	 * @return cyrAmt
	 */
	public	String getCyrAmt() {
		return	this.cyrAmt;
	}

	/**
	 * Column Info
	 * @return docAmt
	 */
	public	String getDocAmt() {
		return	this.docAmt;
	}

	/**
	 * Column Info
	 * @return empAmt
	 */
	public	String getEmpAmt() {
		return	this.empAmt;
	}

	/**
	 * Column Info
	 * @return esdAmt
	 */
	public	String getEsdAmt() {
		return	this.esdAmt;
	}

	/**
	 * Column Info
	 * @return psfAmt
	 */
	public	String getPsfAmt() {
		return	this.psfAmt;
	}

	/**
	 * Column Info
	 * @return slfAmt
	 */
	public	String getSlfAmt() {
		return	this.slfAmt;
	}

	/**
	 * Column Info
	 * @return tslAmt
	 */
	public	String getTslAmt() {
		return	this.tslAmt;
	}

	/**
	 * Column Info
	 * @return xdoAmt
	 */
	public	String getXdoAmt() {
		return	this.xdoAmt;
	}

	/**
	 * Column Info
	 * @return ahaAmt
	 */
	public	String getAhaAmt() {
		return	this.ahaAmt;
	}

	/**
	 * Column Info
	 * @return almAmt
	 */
	public	String getAlmAmt() {
		return	this.almAmt;
	}

	/**
	 * Column Info
	 * @return amaAmt
	 */
	public	String getAmaAmt() {
		return	this.amaAmt;
	}

	/**
	 * Column Info
	 * @return ardAmt
	 */
	public	String getArdAmt() {
		return	this.ardAmt;
	}

	/**
	 * Column Info
	 * @return badAmt
	 */
	public	String getBadAmt() {
		return	this.badAmt;
	}

	/**
	 * Column Info
	 * @return cccAmt
	 */
	public	String getCccAmt() {
		return	this.cccAmt;
	}

	/**
	 * Column Info
	 * @return cfdAmt
	 */
	public	String getCfdAmt() {
		return	this.cfdAmt;
	}

	/**
	 * Column Info
	 * @return cmcAmt
	 */
	public	String getCmcAmt() {
		return	this.cmcAmt;
	}

	/**
	 * Column Info
	 * @return csvAmt
	 */
	public	String getCsvAmt() {
		return	this.csvAmt;
	}

	/**
	 * Column Info
	 * @return dofAmt
	 */
	public	String getDofAmt() {
		return	this.dofAmt;
	}

	/**
	 * Column Info
	 * @return drpAmt
	 */
	public	String getDrpAmt() {
		return	this.drpAmt;
	}

	/**
	 * Column Info
	 * @return ediAmt
	 */
	public	String getEdiAmt() {
		return	this.ediAmt;
	}

	/**
	 * Column Info
	 * @return ehdAmt
	 */
	public	String getEhdAmt() {
		return	this.ehdAmt;
	}

	/**
	 * Column Info
	 * @return hafAmt
	 */
	public	String getHafAmt() {
		return	this.hafAmt;
	}

	/**
	 * Column Info
	 * @return hauAmt
	 */
	public	String getHauAmt() {
		return	this.hauAmt;
	}

	/**
	 * Column Info
	 * @return ifiAmt
	 */
	public	String getIfiAmt() {
		return	this.ifiAmt;
	}

	/**
	 * Column Info
	 * @return insAmt
	 */
	public	String getInsAmt() {
		return	this.insAmt;
	}

	/**
	 * Column Info
	 * @return kcsAmt
	 */
	public	String getKcsAmt() {
		return	this.kcsAmt;
	}

	/**
	 * Column Info
	 * @return lloAmt
	 */
	public	String getLloAmt() {
		return	this.lloAmt;
	}

	/**
	 * Column Info
	 * @return mplAmt
	 */
	public	String getMplAmt() {
		return	this.mplAmt;
	}

	/**
	 * Column Info
	 * @return pscAmt
	 */
	public	String getPscAmt() {
		return	this.pscAmt;
	}

	/**
	 * Column Info
	 * @return rhaAmt
	 */
	public	String getRhaAmt() {
		return	this.rhaAmt;
	}

	/**
	 * Column Info
	 * @return rlsAmt
	 */
	public	String getRlsAmt() {
		return	this.rlsAmt;
	}

	/**
	 * Column Info
	 * @return rpcAmt
	 */
	public	String getRpcAmt() {
		return	this.rpcAmt;
	}

	/**
	 * Column Info
	 * @return tsdAmt
	 */
	public	String getTsdAmt() {
		return	this.tsdAmt;
	}

	/**
	 * Column Info
	 * @return whaAmt
	 */
	public	String getWhaAmt() {
		return	this.whaAmt;
	}

	/**
	 * Column Info
	 * @return xddAmt
	 */
	public	String getXddAmt() {
		return	this.xddAmt;
	}

	/**
	 * Column Info
	 * @return xdeAmt
	 */
	public	String getXdeAmt() {
		return	this.xdeAmt;
	}

	/**
	 * Column Info
	 * @return xerAmt
	 */
	public	String getXerAmt() {
		return	this.xerAmt;
	}

	/**
	 * Column Info
	 * @return xwfAmt
	 */
	public	String getXwfAmt() {
		return	this.xwfAmt;
	}

	/**
	 * Column Info
	 * @return ecaAmt
	 */
	public	String getEcaAmt() {
		return	this.ecaAmt;
	}

	/**
	 * Column Info
	 * @return wtrAmt
	 */
	public	String getWtrAmt() {
		return	this.wtrAmt;
	}

	/**
	 * Column Info
	 * @return crsAmt
	 */
	public	String getCrsAmt() {
		return	this.crsAmt;
	}

	/**
	 * Column Info
	 * @return neoAmt
	 */
	public	String getNeoAmt() {
		return	this.neoAmt;
	}

	/**
	 * Column Info
	 * @return ocrAmt
	 */
	public	String getOcrAmt() {
		return	this.ocrAmt;
	}

	/**
	 * Column Info
	 * @return effDt
	 */
	public	String getEffDt() {
		return	this.effDt;
	}

	/**
	 * Column Info
	 * @return expDt
	 */
	public	String getExpDt() {
		return	this.expDt;
	}

	/**
	 * Column Info
	 * @return remark
	 */
	public	String getRemark() {
		return	this.remark;
	}

	/**
	 * Column Info
	 * @return tBucAmt
	 */
	public	String getTBucAmt() {
		return	this.tBucAmt;
	}

	/**
	 * Column Info
	 * @return tBafAmt
	 */
	public	String getTBafAmt() {
		return	this.tBafAmt;
	}

	/**
	 * Column Info
	 * @return tCsrAmt
	 */
	public	String getTCsrAmt() {
		return	this.tCsrAmt;
	}

	/**
	 * Column Info
	 * @return tCmsAmt
	 */
	public	String getTCmsAmt() {
		return	this.tCmsAmt;
	}

	/**
	 * Column Info
	 * @return tOthAmt
	 */
	public	String getTOthAmt() {
		return	this.tOthAmt;
	}

	/**
	 * Column Info
	 * @return tDhfAmt
	 */
	public	String getTDhfAmt() {
		return	this.tDhfAmt;
	}

	/**
	 * Column Info
	 * @return tFafAmt
	 */
	public	String getTFafAmt() {
		return	this.tFafAmt;
	}

	/**
	 * Column Info
	 * @return tFrcAmt
	 */
	public	String getTFrcAmt() {
		return	this.tFrcAmt;
	}

	/**
	 * Column Info
	 * @return tTscAmt
	 */
	public	String getTTscAmt() {
		return	this.tTscAmt;
	}

	/**
	 * Column Info
	 * @return tPscAmt
	 */
	public	String getTPscAmt() {
		return	this.tPscAmt;
	}

	/**
	 * Column Info
	 * @return tEnsAmt
	 */
	public	String getTEnsAmt() {
		return	this.tEnsAmt;
	}

	/**
	 * Column Info
	 * @return tStfAmt
	 */
	public	String getTStfAmt() {
		return	this.tStfAmt;
	}

	/**
	 * Column Info
	 * @return tDdcAmt
	 */
	public	String getTDdcAmt() {
		return	this.tDdcAmt;
	}

	/**
	 * Column Info
	 * @return tSzcAmt
	 */
	public	String getTSzcAmt() {
		return	this.tSzcAmt;
	}

	/**
	 * Column Info
	 * @return tCucAmt
	 */
	public	String getTCucAmt() {
		return	this.tCucAmt;
	}

	/**
	 * Column Info
	 * @return tDthAmt
	 */
	public	String getTDthAmt() {
		return	this.tDthAmt;
	}

	/**
	 * Column Info
	 * @return tHrsAmt
	 */
	public	String getTHrsAmt() {
		return	this.tHrsAmt;
	}

	/**
	 * Column Info
	 * @return tApsAmt
	 */
	public	String getTApsAmt() {
		return	this.tApsAmt;
	}

	/**
	 * Column Info
	 * @return tFrbAmt
	 */
	public	String getTFrbAmt() {
		return	this.tFrbAmt;
	}

	/**
	 * Column Info
	 * @return tOtsAmt
	 */
	public	String getTOtsAmt() {
		return	this.tOtsAmt;
	}

	/**
	 * Column Info
	 * @return tCfrAmt
	 */
	public	String getTCfrAmt() {
		return	this.tCfrAmt;
	}

	/**
	 * Column Info
	 * @return tOihAmt
	 */
	public	String getTOihAmt() {
		return	this.tOihAmt;
	}

	/**
	 * Column Info
	 * @return tTacAmt
	 */
	public	String getTTacAmt() {
		return	this.tTacAmt;
	}

	/**
	 * Column Info
	 * @return tActAmt
	 */
	public	String getTActAmt() {
		return	this.tActAmt;
	}

	/**
	 * Column Info
	 * @return tWscAmt
	 */
	public	String getTWscAmt() {
		return	this.tWscAmt;
	}

	/**
	 * Column Info
	 * @return agsCurrCd
	 */
	public	String getAgsCurrCd() {
		return	this.agsCurrCd;
	}

	/**
	 * Column Info
	 * @return cgdCurrCd
	 */
	public	String getCgdCurrCd() {
		return	this.cgdCurrCd;
	}

	/**
	 * Column Info
	 * @return cglCurrCd
	 */
	public	String getCglCurrCd() {
		return	this.cglCurrCd;
	}

	/**
	 * Column Info
	 * @return cssCurrCd
	 */
	public	String getCssCurrCd() {
		return	this.cssCurrCd;
	}

	/**
	 * Column Info
	 * @return ebsCurrCd
	 */
	public	String getEbsCurrCd() {
		return	this.ebsCurrCd;
	}

	/**
	 * Column Info
	 * @return eisCurrCd
	 */
	public	String getEisCurrCd() {
		return	this.eisCurrCd;
	}

	/**
	 * Column Info
	 * @return emsCurrCd
	 */
	public	String getEmsCurrCd() {
		return	this.emsCurrCd;
	}

	/**
	 * Column Info
	 * @return eriCurrCd
	 */
	public	String getEriCurrCd() {
		return	this.eriCurrCd;
	}

	/**
	 * Column Info
	 * @return fafCurrCd
	 */
	public	String getFafCurrCd() {
		return	this.fafCurrCd;
	}

	/**
	 * Column Info
	 * @return lsfCurrCd
	 */
	public	String getLsfCurrCd() {
		return	this.lsfCurrCd;
	}

	/**
	 * Column Info
	 * @return pssCurrCd
	 */
	public	String getPssCurrCd() {
		return	this.pssCurrCd;
	}

	/**
	 * Column Info
	 * @return sctCurrCd
	 */
	public	String getSctCurrCd() {
		return	this.sctCurrCd;
	}

	/**
	 * Column Info
	 * @return codCurrCd
	 */
	public	String getCodCurrCd() {
		return	this.codCurrCd;
	}

	/**
	 * Column Info
	 * @return dgsCurrCd
	 */
	public	String getDgsCurrCd() {
		return	this.dgsCurrCd;
	}

	/**
	 * Column Info
	 * @return gh2CurrCd
	 */
	public	String getGh2CurrCd() {
		return	this.gh2CurrCd;
	}

	/**
	 * Column Info
	 * @return gohCurrCd
	 */
	public	String getGohCurrCd() {
		return	this.gohCurrCd;
	}

	/**
	 * Column Info
	 * @return hazCurrCd
	 */
	public	String getHazCurrCd() {
		return	this.hazCurrCd;
	}

	/**
	 * Column Info
	 * @return heaCurrCd
	 */
	public	String getHeaCurrCd() {
		return	this.heaCurrCd;
	}

	/**
	 * Column Info
	 * @return sesCurrCd
	 */
	public	String getSesCurrCd() {
		return	this.sesCurrCd;
	}

	/**
	 * Column Info
	 * @return ecaCurrCd
	 */
	public	String getEcaCurrCd() {
		return	this.ecaCurrCd;
	}

	/**
	 * Column Info
	 * @return wtrCurrCd
	 */
	public	String getWtrCurrCd() {
		return	this.wtrCurrCd;
	}

	/**
	 * Column Info
	 * @return agsUsdLoclXchRt
	 */
	public	String getAgsUsdLoclXchRt() {
		return	this.agsUsdLoclXchRt;
	}

	/**
	 * Column Info
	 * @return cgdUsdLoclXchRt
	 */
	public	String getCgdUsdLoclXchRt() {
		return	this.cgdUsdLoclXchRt;
	}

	/**
	 * Column Info
	 * @return cglUsdLoclXchRt
	 */
	public	String getCglUsdLoclXchRt() {
		return	this.cglUsdLoclXchRt;
	}

	/**
	 * Column Info
	 * @return cssUsdLoclXchRt
	 */
	public	String getCssUsdLoclXchRt() {
		return	this.cssUsdLoclXchRt;
	}

	/**
	 * Column Info
	 * @return ebsUsdLoclXchRt
	 */
	public	String getEbsUsdLoclXchRt() {
		return	this.ebsUsdLoclXchRt;
	}

	/**
	 * Column Info
	 * @return eisUsdLoclXchRt
	 */
	public	String getEisUsdLoclXchRt() {
		return	this.eisUsdLoclXchRt;
	}

	/**
	 * Column Info
	 * @return emsUsdLoclXchRt
	 */
	public	String getEmsUsdLoclXchRt() {
		return	this.emsUsdLoclXchRt;
	}

	/**
	 * Column Info
	 * @return eriUsdLoclXchRt
	 */
	public	String getEriUsdLoclXchRt() {
		return	this.eriUsdLoclXchRt;
	}

	/**
	 * Column Info
	 * @return fafUsdLoclXchRt
	 */
	public	String getFafUsdLoclXchRt() {
		return	this.fafUsdLoclXchRt;
	}

	/**
	 * Column Info
	 * @return lsfUsdLoclXchRt
	 */
	public	String getLsfUsdLoclXchRt() {
		return	this.lsfUsdLoclXchRt;
	}

	/**
	 * Column Info
	 * @return pssUsdLoclXchRt
	 */
	public	String getPssUsdLoclXchRt() {
		return	this.pssUsdLoclXchRt;
	}

	/**
	 * Column Info
	 * @return sctUsdLoclXchRt
	 */
	public	String getSctUsdLoclXchRt() {
		return	this.sctUsdLoclXchRt;
	}

	/**
	 * Column Info
	 * @return codUsdLoclXchRt
	 */
	public	String getCodUsdLoclXchRt() {
		return	this.codUsdLoclXchRt;
	}

	/**
	 * Column Info
	 * @return dgsUsdLoclXchRt
	 */
	public	String getDgsUsdLoclXchRt() {
		return	this.dgsUsdLoclXchRt;
	}

	/**
	 * Column Info
	 * @return gh2UsdLoclXchRt
	 */
	public	String getGh2UsdLoclXchRt() {
		return	this.gh2UsdLoclXchRt;
	}

	/**
	 * Column Info
	 * @return gohUsdLoclXchRt
	 */
	public	String getGohUsdLoclXchRt() {
		return	this.gohUsdLoclXchRt;
	}

	/**
	 * Column Info
	 * @return hazUsdLoclXchRt
	 */
	public	String getHazUsdLoclXchRt() {
		return	this.hazUsdLoclXchRt;
	}

	/**
	 * Column Info
	 * @return heaUsdLoclXchRt
	 */
	public	String getHeaUsdLoclXchRt() {
		return	this.heaUsdLoclXchRt;
	}

	/**
	 * Column Info
	 * @return sesUsdLoclXchRt
	 */
	public	String getSesUsdLoclXchRt() {
		return	this.sesUsdLoclXchRt;
	}

	/**
	 * Column Info
	 * @return ecaUsdLoclXchRt
	 */
	public	String getEcaUsdLoclXchRt() {
		return	this.ecaUsdLoclXchRt;
	}

	/**
	 * Column Info
	 * @return wtrUsdLoclXchRt
	 */
	public	String getWtrUsdLoclXchRt() {
		return	this.wtrUsdLoclXchRt;
	}

	/**
	 * Column Info
	 * @return bucCurrCd
	 */
	public	String getBucCurrCd() {
		return	this.bucCurrCd;
	}

	/**
	 * Column Info
	 * @return csrCurrCd
	 */
	public	String getCsrCurrCd() {
		return	this.csrCurrCd;
	}

	/**
	 * Column Info
	 * @return cmsCurrCd
	 */
	public	String getCmsCurrCd() {
		return	this.cmsCurrCd;
	}

	/**
	 * Column Info
	 * @return othCurrCd
	 */
	public	String getOthCurrCd() {
		return	this.othCurrCd;
	}

	/**
	 * Column Info
	 * @return dhfCurrCd
	 */
	public	String getDhfCurrCd() {
		return	this.dhfCurrCd;
	}

	/**
	 * Column Info
	 * @return frcCurrCd
	 */
	public	String getFrcCurrCd() {
		return	this.frcCurrCd;
	}

	/**
	 * Column Info
	 * @return tscCurrCd
	 */
	public	String getTscCurrCd() {
		return	this.tscCurrCd;
	}

	/**
	 * Column Info
	 * @return ensCurrCd
	 */
	public	String getEnsCurrCd() {
		return	this.ensCurrCd;
	}

	/**
	 * Column Info
	 * @return stfCurrCd
	 */
	public	String getStfCurrCd() {
		return	this.stfCurrCd;
	}

	/**
	 * Column Info
	 * @return ddcCurrCd
	 */
	public	String getDdcCurrCd() {
		return	this.ddcCurrCd;
	}

	/**
	 * Column Info
	 * @return szcCurrCd
	 */
	public	String getSzcCurrCd() {
		return	this.szcCurrCd;
	}

	/**
	 * Column Info
	 * @return cucCurrCd
	 */
	public	String getCucCurrCd() {
		return	this.cucCurrCd;
	}

	/**
	 * Column Info
	 * @return dthCurrCd
	 */
	public	String getDthCurrCd() {
		return	this.dthCurrCd;
	}

	/**
	 * Column Info
	 * @return hrsCurrCd
	 */
	public	String getHrsCurrCd() {
		return	this.hrsCurrCd;
	}

	/**
	 * Column Info
	 * @return apsCurrCd
	 */
	public	String getApsCurrCd() {
		return	this.apsCurrCd;
	}

	/**
	 * Column Info
	 * @return frbCurrCd
	 */
	public	String getFrbCurrCd() {
		return	this.frbCurrCd;
	}

	/**
	 * Column Info
	 * @return otsCurrCd
	 */
	public	String getOtsCurrCd() {
		return	this.otsCurrCd;
	}

	/**
	 * Column Info
	 * @return cfrCurrCd
	 */
	public	String getCfrCurrCd() {
		return	this.cfrCurrCd;
	}

	/**
	 * Column Info
	 * @return oihCurrCd
	 */
	public	String getOihCurrCd() {
		return	this.oihCurrCd;
	}

	/**
	 * Column Info
	 * @return tacCurrCd
	 */
	public	String getTacCurrCd() {
		return	this.tacCurrCd;
	}

	/**
	 * Column Info
	 * @return actCurrCd
	 */
	public	String getActCurrCd() {
		return	this.actCurrCd;
	}

	/**
	 * Column Info
	 * @return wscCurrCd
	 */
	public	String getWscCurrCd() {
		return	this.wscCurrCd;
	}

	/**
	 * Column Info
	 * @return bucUsdLoclXchRt
	 */
	public	String getBucUsdLoclXchRt() {
		return	this.bucUsdLoclXchRt;
	}

	/**
	 * Column Info
	 * @return csrUsdLoclXchRt
	 */
	public	String getCsrUsdLoclXchRt() {
		return	this.csrUsdLoclXchRt;
	}

	/**
	 * Column Info
	 * @return cmsUsdLoclXchRt
	 */
	public	String getCmsUsdLoclXchRt() {
		return	this.cmsUsdLoclXchRt;
	}

	/**
	 * Column Info
	 * @return othUsdLoclXchRt
	 */
	public	String getOthUsdLoclXchRt() {
		return	this.othUsdLoclXchRt;
	}

	/**
	 * Column Info
	 * @return dhfUsdLoclXchRt
	 */
	public	String getDhfUsdLoclXchRt() {
		return	this.dhfUsdLoclXchRt;
	}

	/**
	 * Column Info
	 * @return frcUsdLoclXchRt
	 */
	public	String getFrcUsdLoclXchRt() {
		return	this.frcUsdLoclXchRt;
	}

	/**
	 * Column Info
	 * @return tscUsdLoclXchRt
	 */
	public	String getTscUsdLoclXchRt() {
		return	this.tscUsdLoclXchRt;
	}

	/**
	 * Column Info
	 * @return ensUsdLoclXchRt
	 */
	public	String getEnsUsdLoclXchRt() {
		return	this.ensUsdLoclXchRt;
	}

	/**
	 * Column Info
	 * @return stfUsdLoclXchRt
	 */
	public	String getStfUsdLoclXchRt() {
		return	this.stfUsdLoclXchRt;
	}

	/**
	 * Column Info
	 * @return ddcUsdLoclXchRt
	 */
	public	String getDdcUsdLoclXchRt() {
		return	this.ddcUsdLoclXchRt;
	}

	/**
	 * Column Info
	 * @return szcUsdLoclXchRt
	 */
	public	String getSzcUsdLoclXchRt() {
		return	this.szcUsdLoclXchRt;
	}

	/**
	 * Column Info
	 * @return cucUsdLoclXchRt
	 */
	public	String getCucUsdLoclXchRt() {
		return	this.cucUsdLoclXchRt;
	}

	/**
	 * Column Info
	 * @return dthUsdLoclXchRt
	 */
	public	String getDthUsdLoclXchRt() {
		return	this.dthUsdLoclXchRt;
	}

	/**
	 * Column Info
	 * @return hrsUsdLoclXchRt
	 */
	public	String getHrsUsdLoclXchRt() {
		return	this.hrsUsdLoclXchRt;
	}

	/**
	 * Column Info
	 * @return apsUsdLoclXchRt
	 */
	public	String getApsUsdLoclXchRt() {
		return	this.apsUsdLoclXchRt;
	}

	/**
	 * Column Info
	 * @return frbUsdLoclXchRt
	 */
	public	String getFrbUsdLoclXchRt() {
		return	this.frbUsdLoclXchRt;
	}

	/**
	 * Column Info
	 * @return otsUsdLoclXchRt
	 */
	public	String getOtsUsdLoclXchRt() {
		return	this.otsUsdLoclXchRt;
	}

	/**
	 * Column Info
	 * @return cfrUsdLoclXchRt
	 */
	public	String getCfrUsdLoclXchRt() {
		return	this.cfrUsdLoclXchRt;
	}

	/**
	 * Column Info
	 * @return oihUsdLoclXchRt
	 */
	public	String getOihUsdLoclXchRt() {
		return	this.oihUsdLoclXchRt;
	}

	/**
	 * Column Info
	 * @return tacUsdLoclXchRt
	 */
	public	String getTacUsdLoclXchRt() {
		return	this.tacUsdLoclXchRt;
	}

	/**
	 * Column Info
	 * @return actUsdLoclXchRt
	 */
	public	String getActUsdLoclXchRt() {
		return	this.actUsdLoclXchRt;
	}

	/**
	 * Column Info
	 * @return wscUsdLoclXchRt
	 */
	public	String getWscUsdLoclXchRt() {
		return	this.wscUsdLoclXchRt;
	}

 	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param  ibflag
 	 */
	public void	setIbflag(String ibflag ) {
		this.ibflag =	ibflag;
	}
 	/**
	 * Page Number
	 * @param  pagerows
 	 */
	public void	setPagerows(String pagerows ) {
		this.pagerows =	pagerows;
	}
 	/**
	 * Column Info
	 * @param  testExecDt
 	 */
	public void	setTestExecDt(String testExecDt ) {
		this.testExecDt =	testExecDt;
	}
 	/**
	 * Column Info
	 * @param  execDt
 	 */
	public void	setExecDt(String execDt ) {
		this.execDt =	execDt;
	}
 	/**
	 * Column Info
	 * @param  svcScpCd
 	 */
	public void	setSvcScpCd(String svcScpCd ) {
		this.svcScpCd =	svcScpCd;
	}
 	/**
	 * Column Info
	 * @param  fOrgCd
 	 */
	public void	setFOrgCd(String fOrgCd ) {
		this.fOrgCd =	fOrgCd;
	}
 	/**
	 * Column Info
	 * @param  updUsrId
 	 */
	public void	setUpdUsrId(String updUsrId ) {
		this.updUsrId =	updUsrId;
	}
 	/**
	 * Column Info
	 * @param  toFileDt
 	 */
	public void	setToFileDt(String toFileDt ) {
		this.toFileDt =	toFileDt;
	}
 	/**
	 * Column Info
	 * @param  frFileDt
 	 */
	public void	setFrFileDt(String frFileDt ) {
		this.frFileDt =	frFileDt;
	}
 	/**
	 * Column Info
	 * @param  fileDt
 	 */
	public void	setFileDt(String fileDt ) {
		this.fileDt =	fileDt;
	}
 	/**
	 * Column Info
	 * @param  inqTpCd
 	 */
	public void	setInqTpCd(String inqTpCd ) {
		this.inqTpCd =	inqTpCd;
	}
 	/**
	 * Column Info
	 * @param  creUsrId
 	 */
	public void	setCreUsrId(String creUsrId ) {
		this.creUsrId =	creUsrId;
	}
 	/**
	 * Column Info
	 * @param  motTrfSeq
 	 */
	public void	setMotTrfSeq(String motTrfSeq ) {
		this.motTrfSeq =	motTrfSeq;
	}
 	/**
	 * Column Info
	 * @param  rtSeq
 	 */
	public void	setRtSeq(String rtSeq ) {
		this.rtSeq =	rtSeq;
	}
 	/**
	 * Column Info
	 * @param  batExeDt
 	 */
	public void	setBatExeDt(String batExeDt ) {
		this.batExeDt =	batExeDt;
	}
 	/**
	 * Column Info
	 * @param  seq
 	 */
	public void	setSeq(String seq ) {
		this.seq =	seq;
	}
 	/**
	 * Column Info
	 * @param  bkgSrcTpCd
 	 */
	public void	setBkgSrcTpCd(String bkgSrcTpCd ) {
		this.bkgSrcTpCd =	bkgSrcTpCd;
	}
 	/**
	 * Column Info
	 * @param  bkgNo
 	 */
	public void	setBkgNo(String bkgNo ) {
		this.bkgNo =	bkgNo;
	}
 	/**
	 * Column Info
	 * @param  carrier
 	 */
	public void	setCarrier(String carrier ) {
		this.carrier =	carrier;
	}
 	/**
	 * Column Info
	 * @param  ctrtNo
 	 */
	public void	setCtrtNo(String ctrtNo ) {
		this.ctrtNo =	ctrtNo;
	}
 	/**
	 * Column Info
	 * @param  ctrtHldNm
 	 */
	public void	setCtrtHldNm(String ctrtHldNm ) {
		this.ctrtHldNm =	ctrtHldNm;
	}
 	/**
	 * Column Info
	 * @param  bkgShprNm
 	 */
	public void	setBkgShprNm(String bkgShprNm ) {
		this.bkgShprNm =	bkgShprNm;
	}
 	/**
	 * Column Info
	 * @param  bkgCneeNm
 	 */
	public void	setBkgCneeNm(String bkgCneeNm ) {
		this.bkgCneeNm =	bkgCneeNm;
	}
 	/**
	 * Column Info
	 * @param  foreTraComp
 	 */
	public void	setForeTraComp(String foreTraComp ) {
		this.foreTraComp =	foreTraComp;
	}
 	/**
	 * Column Info
	 * @param  operAgt
 	 */
	public void	setOperAgt(String operAgt ) {
		this.operAgt =	operAgt;
	}
 	/**
	 * Column Info
	 * @param  lane
 	 */
	public void	setLane(String lane ) {
		this.lane =	lane;
	}
 	/**
	 * Column Info
	 * @param  wayPort
 	 */
	public void	setWayPort(String wayPort ) {
		this.wayPort =	wayPort;
	}
 	/**
	 * Column Info
	 * @param  polCd
 	 */
	public void	setPolCd(String polCd ) {
		this.polCd =	polCd;
	}
 	/**
	 * Column Info
	 * @param  deptTsitPort
 	 */
	public void	setDeptTsitPort(String deptTsitPort ) {
		this.deptTsitPort =	deptTsitPort;
	}
 	/**
	 * Column Info
	 * @param  destTsitPort
 	 */
	public void	setDestTsitPort(String destTsitPort ) {
		this.destTsitPort =	destTsitPort;
	}
 	/**
	 * Column Info
	 * @param  podCd
 	 */
	public void	setPodCd(String podCd ) {
		this.podCd =	podCd;
	}
 	/**
	 * Column Info
	 * @param  transTerm
 	 */
	public void	setTransTerm(String transTerm ) {
		this.transTerm =	transTerm;
	}
 	/**
	 * Column Info
	 * @param  cntrTp
 	 */
	public void	setCntrTp(String cntrTp ) {
		this.cntrTp =	cntrTp;
	}
 	/**
	 * Column Info
	 * @param  cmdtTp
 	 */
	public void	setCmdtTp(String cmdtTp ) {
		this.cmdtTp =	cmdtTp;
	}
 	/**
	 * Column Info
	 * @param  cntrSz
 	 */
	public void	setCntrSz(String cntrSz ) {
		this.cntrSz =	cntrSz;
	}
 	/**
	 * Column Info
	 * @param  cntrVol1
 	 */
	public void	setCntrVol1(String cntrVol1 ) {
		this.cntrVol1 =	cntrVol1;
	}
 	/**
	 * Column Info
	 * @param  cntrVol2
 	 */
	public void	setCntrVol2(String cntrVol2 ) {
		this.cntrVol2 =	cntrVol2;
	}
 	/**
	 * Column Info
	 * @param  oftRt
 	 */
	public void	setOftRt(String oftRt ) {
		this.oftRt =	oftRt;
	}
 	/**
	 * Column Info
	 * @param  blnk1
 	 */
	public void	setBlnk1(String blnk1 ) {
		this.blnk1 =	blnk1;
	}
 	/**
	 * Column Info
	 * @param  bafAmt
 	 */
	public void	setBafAmt(String bafAmt ) {
		this.bafAmt =	bafAmt;
	}
 	/**
	 * Column Info
	 * @param  cafAmt
 	 */
	public void	setCafAmt(String cafAmt ) {
		this.cafAmt =	cafAmt;
	}
 	/**
	 * Column Info
	 * @param  agsAmt
 	 */
	public void	setAgsAmt(String agsAmt ) {
		this.agsAmt =	agsAmt;
	}
 	/**
	 * Column Info
	 * @param  cgdAmt
 	 */
	public void	setCgdAmt(String cgdAmt ) {
		this.cgdAmt =	cgdAmt;
	}
 	/**
	 * Column Info
	 * @param  cglAmt
 	 */
	public void	setCglAmt(String cglAmt ) {
		this.cglAmt =	cglAmt;
	}
 	/**
	 * Column Info
	 * @param  cssAmt
 	 */
	public void	setCssAmt(String cssAmt ) {
		this.cssAmt =	cssAmt;
	}
 	/**
	 * Column Info
	 * @param  ebsAmt
 	 */
	public void	setEbsAmt(String ebsAmt ) {
		this.ebsAmt =	ebsAmt;
	}
 	/**
	 * Column Info
	 * @param  eisAmt
 	 */
	public void	setEisAmt(String eisAmt ) {
		this.eisAmt =	eisAmt;
	}
 	/**
	 * Column Info
	 * @param  emsAmt
 	 */
	public void	setEmsAmt(String emsAmt ) {
		this.emsAmt =	emsAmt;
	}
 	/**
	 * Column Info
	 * @param  eriAmt
 	 */
	public void	setEriAmt(String eriAmt ) {
		this.eriAmt =	eriAmt;
	}
 	/**
	 * Column Info
	 * @param  fafAmt
 	 */
	public void	setFafAmt(String fafAmt ) {
		this.fafAmt =	fafAmt;
	}
 	/**
	 * Column Info
	 * @param  lsfAmt
 	 */
	public void	setLsfAmt(String lsfAmt ) {
		this.lsfAmt =	lsfAmt;
	}
 	/**
	 * Column Info
	 * @param  pssAmt
 	 */
	public void	setPssAmt(String pssAmt ) {
		this.pssAmt =	pssAmt;
	}
 	/**
	 * Column Info
	 * @param  sctAmt
 	 */
	public void	setSctAmt(String sctAmt ) {
		this.sctAmt =	sctAmt;
	}
 	/**
	 * Column Info
	 * @param  codAmt
 	 */
	public void	setCodAmt(String codAmt ) {
		this.codAmt =	codAmt;
	}
 	/**
	 * Column Info
	 * @param  dgsAmt
 	 */
	public void	setDgsAmt(String dgsAmt ) {
		this.dgsAmt =	dgsAmt;
	}
 	/**
	 * Column Info
	 * @param  gh2Amt
 	 */
	public void	setGh2Amt(String gh2Amt ) {
		this.gh2Amt =	gh2Amt;
	}
 	/**
	 * Column Info
	 * @param  gohAmt
 	 */
	public void	setGohAmt(String gohAmt ) {
		this.gohAmt =	gohAmt;
	}
 	/**
	 * Column Info
	 * @param  hazAmt
 	 */
	public void	setHazAmt(String hazAmt ) {
		this.hazAmt =	hazAmt;
	}
 	/**
	 * Column Info
	 * @param  heaAmt
 	 */
	public void	setHeaAmt(String heaAmt ) {
		this.heaAmt =	heaAmt;
	}
 	/**
	 * Column Info
	 * @param  sesAmt
 	 */
	public void	setSesAmt(String sesAmt ) {
		this.sesAmt =	sesAmt;
	}
 	/**
	 * Column Info
	 * @param  thcAmt
 	 */
	public void	setThcAmt(String thcAmt ) {
		this.thcAmt =	thcAmt;
	}
 	/**
	 * Column Info
	 * @param  amsAmt
 	 */
	public void	setAmsAmt(String amsAmt ) {
		this.amsAmt =	amsAmt;
	}
 	/**
	 * Column Info
	 * @param  bkfAmt
 	 */
	public void	setBkfAmt(String bkfAmt ) {
		this.bkfAmt =	bkfAmt;
	}
 	/**
	 * Column Info
	 * @param  cdcAmt
 	 */
	public void	setCdcAmt(String cdcAmt ) {
		this.cdcAmt =	cdcAmt;
	}
 	/**
	 * Column Info
	 * @param  cddAmt
 	 */
	public void	setCddAmt(String cddAmt ) {
		this.cddAmt =	cddAmt;
	}
 	/**
	 * Column Info
	 * @param  ctpAmt
 	 */
	public void	setCtpAmt(String ctpAmt ) {
		this.ctpAmt =	ctpAmt;
	}
 	/**
	 * Column Info
	 * @param  cyrAmt
 	 */
	public void	setCyrAmt(String cyrAmt ) {
		this.cyrAmt =	cyrAmt;
	}
 	/**
	 * Column Info
	 * @param  docAmt
 	 */
	public void	setDocAmt(String docAmt ) {
		this.docAmt =	docAmt;
	}
 	/**
	 * Column Info
	 * @param  empAmt
 	 */
	public void	setEmpAmt(String empAmt ) {
		this.empAmt =	empAmt;
	}
 	/**
	 * Column Info
	 * @param  esdAmt
 	 */
	public void	setEsdAmt(String esdAmt ) {
		this.esdAmt =	esdAmt;
	}
 	/**
	 * Column Info
	 * @param  psfAmt
 	 */
	public void	setPsfAmt(String psfAmt ) {
		this.psfAmt =	psfAmt;
	}
 	/**
	 * Column Info
	 * @param  slfAmt
 	 */
	public void	setSlfAmt(String slfAmt ) {
		this.slfAmt =	slfAmt;
	}
 	/**
	 * Column Info
	 * @param  tslAmt
 	 */
	public void	setTslAmt(String tslAmt ) {
		this.tslAmt =	tslAmt;
	}
 	/**
	 * Column Info
	 * @param  xdoAmt
 	 */
	public void	setXdoAmt(String xdoAmt ) {
		this.xdoAmt =	xdoAmt;
	}
 	/**
	 * Column Info
	 * @param  ahaAmt
 	 */
	public void	setAhaAmt(String ahaAmt ) {
		this.ahaAmt =	ahaAmt;
	}
 	/**
	 * Column Info
	 * @param  almAmt
 	 */
	public void	setAlmAmt(String almAmt ) {
		this.almAmt =	almAmt;
	}
 	/**
	 * Column Info
	 * @param  amaAmt
 	 */
	public void	setAmaAmt(String amaAmt ) {
		this.amaAmt =	amaAmt;
	}
 	/**
	 * Column Info
	 * @param  ardAmt
 	 */
	public void	setArdAmt(String ardAmt ) {
		this.ardAmt =	ardAmt;
	}
 	/**
	 * Column Info
	 * @param  badAmt
 	 */
	public void	setBadAmt(String badAmt ) {
		this.badAmt =	badAmt;
	}
 	/**
	 * Column Info
	 * @param  cccAmt
 	 */
	public void	setCccAmt(String cccAmt ) {
		this.cccAmt =	cccAmt;
	}
 	/**
	 * Column Info
	 * @param  cfdAmt
 	 */
	public void	setCfdAmt(String cfdAmt ) {
		this.cfdAmt =	cfdAmt;
	}
 	/**
	 * Column Info
	 * @param  cmcAmt
 	 */
	public void	setCmcAmt(String cmcAmt ) {
		this.cmcAmt =	cmcAmt;
	}
 	/**
	 * Column Info
	 * @param  csvAmt
 	 */
	public void	setCsvAmt(String csvAmt ) {
		this.csvAmt =	csvAmt;
	}
 	/**
	 * Column Info
	 * @param  dofAmt
 	 */
	public void	setDofAmt(String dofAmt ) {
		this.dofAmt =	dofAmt;
	}
 	/**
	 * Column Info
	 * @param  drpAmt
 	 */
	public void	setDrpAmt(String drpAmt ) {
		this.drpAmt =	drpAmt;
	}
 	/**
	 * Column Info
	 * @param  ediAmt
 	 */
	public void	setEdiAmt(String ediAmt ) {
		this.ediAmt =	ediAmt;
	}
 	/**
	 * Column Info
	 * @param  ehdAmt
 	 */
	public void	setEhdAmt(String ehdAmt ) {
		this.ehdAmt =	ehdAmt;
	}
 	/**
	 * Column Info
	 * @param  hafAmt
 	 */
	public void	setHafAmt(String hafAmt ) {
		this.hafAmt =	hafAmt;
	}
 	/**
	 * Column Info
	 * @param  hauAmt
 	 */
	public void	setHauAmt(String hauAmt ) {
		this.hauAmt =	hauAmt;
	}
 	/**
	 * Column Info
	 * @param  ifiAmt
 	 */
	public void	setIfiAmt(String ifiAmt ) {
		this.ifiAmt =	ifiAmt;
	}
 	/**
	 * Column Info
	 * @param  insAmt
 	 */
	public void	setInsAmt(String insAmt ) {
		this.insAmt =	insAmt;
	}
 	/**
	 * Column Info
	 * @param  kcsAmt
 	 */
	public void	setKcsAmt(String kcsAmt ) {
		this.kcsAmt =	kcsAmt;
	}
 	/**
	 * Column Info
	 * @param  lloAmt
 	 */
	public void	setLloAmt(String lloAmt ) {
		this.lloAmt =	lloAmt;
	}
 	/**
	 * Column Info
	 * @param  mplAmt
 	 */
	public void	setMplAmt(String mplAmt ) {
		this.mplAmt =	mplAmt;
	}
 	/**
	 * Column Info
	 * @param  pscAmt
 	 */
	public void	setPscAmt(String pscAmt ) {
		this.pscAmt =	pscAmt;
	}
 	/**
	 * Column Info
	 * @param  rhaAmt
 	 */
	public void	setRhaAmt(String rhaAmt ) {
		this.rhaAmt =	rhaAmt;
	}
 	/**
	 * Column Info
	 * @param  rlsAmt
 	 */
	public void	setRlsAmt(String rlsAmt ) {
		this.rlsAmt =	rlsAmt;
	}
 	/**
	 * Column Info
	 * @param  rpcAmt
 	 */
	public void	setRpcAmt(String rpcAmt ) {
		this.rpcAmt =	rpcAmt;
	}
 	/**
	 * Column Info
	 * @param  tsdAmt
 	 */
	public void	setTsdAmt(String tsdAmt ) {
		this.tsdAmt =	tsdAmt;
	}
 	/**
	 * Column Info
	 * @param  whaAmt
 	 */
	public void	setWhaAmt(String whaAmt ) {
		this.whaAmt =	whaAmt;
	}
 	/**
	 * Column Info
	 * @param  xddAmt
 	 */
	public void	setXddAmt(String xddAmt ) {
		this.xddAmt =	xddAmt;
	}
 	/**
	 * Column Info
	 * @param  xdeAmt
 	 */
	public void	setXdeAmt(String xdeAmt ) {
		this.xdeAmt =	xdeAmt;
	}
 	/**
	 * Column Info
	 * @param  xerAmt
 	 */
	public void	setXerAmt(String xerAmt ) {
		this.xerAmt =	xerAmt;
	}
 	/**
	 * Column Info
	 * @param  xwfAmt
 	 */
	public void	setXwfAmt(String xwfAmt ) {
		this.xwfAmt =	xwfAmt;
	}
 	/**
	 * Column Info
	 * @param  ecaAmt
 	 */
	public void	setEcaAmt(String ecaAmt ) {
		this.ecaAmt =	ecaAmt;
	}
 	/**
	 * Column Info
	 * @param  wtrAmt
 	 */
	public void	setWtrAmt(String wtrAmt ) {
		this.wtrAmt =	wtrAmt;
	}
 	/**
	 * Column Info
	 * @param  crsAmt
 	 */
	public void	setCrsAmt(String crsAmt ) {
		this.crsAmt =	crsAmt;
	}
 	/**
	 * Column Info
	 * @param  neoAmt
 	 */
	public void	setNeoAmt(String neoAmt ) {
		this.neoAmt =	neoAmt;
	}
 	/**
	 * Column Info
	 * @param  ocrAmt
 	 */
	public void	setOcrAmt(String ocrAmt ) {
		this.ocrAmt =	ocrAmt;
	}
 	/**
	 * Column Info
	 * @param  effDt
 	 */
	public void	setEffDt(String effDt ) {
		this.effDt =	effDt;
	}
 	/**
	 * Column Info
	 * @param  expDt
 	 */
	public void	setExpDt(String expDt ) {
		this.expDt =	expDt;
	}
 	/**
	 * Column Info
	 * @param  remark
 	 */
	public void	setRemark(String remark ) {
		this.remark =	remark;
	}
 	/**
	 * Column Info
	 * @param  tBucAmt
 	 */
	public void	setTBucAmt(String tBucAmt ) {
		this.tBucAmt =	tBucAmt;
	}
 	/**
	 * Column Info
	 * @param  tBafAmt
 	 */
	public void	setTBafAmt(String tBafAmt ) {
		this.tBafAmt =	tBafAmt;
	}
 	/**
	 * Column Info
	 * @param  tCsrAmt
 	 */
	public void	setTCsrAmt(String tCsrAmt ) {
		this.tCsrAmt =	tCsrAmt;
	}
 	/**
	 * Column Info
	 * @param  tCmsAmt
 	 */
	public void	setTCmsAmt(String tCmsAmt ) {
		this.tCmsAmt =	tCmsAmt;
	}
 	/**
	 * Column Info
	 * @param  tOthAmt
 	 */
	public void	setTOthAmt(String tOthAmt ) {
		this.tOthAmt =	tOthAmt;
	}
 	/**
	 * Column Info
	 * @param  tDhfAmt
 	 */
	public void	setTDhfAmt(String tDhfAmt ) {
		this.tDhfAmt =	tDhfAmt;
	}
 	/**
	 * Column Info
	 * @param  tFafAmt
 	 */
	public void	setTFafAmt(String tFafAmt ) {
		this.tFafAmt =	tFafAmt;
	}
 	/**
	 * Column Info
	 * @param  tFrcAmt
 	 */
	public void	setTFrcAmt(String tFrcAmt ) {
		this.tFrcAmt =	tFrcAmt;
	}
 	/**
	 * Column Info
	 * @param  tTscAmt
 	 */
	public void	setTTscAmt(String tTscAmt ) {
		this.tTscAmt =	tTscAmt;
	}
 	/**
	 * Column Info
	 * @param  tPscAmt
 	 */
	public void	setTPscAmt(String tPscAmt ) {
		this.tPscAmt =	tPscAmt;
	}
 	/**
	 * Column Info
	 * @param  tEnsAmt
 	 */
	public void	setTEnsAmt(String tEnsAmt ) {
		this.tEnsAmt =	tEnsAmt;
	}
 	/**
	 * Column Info
	 * @param  tStfAmt
 	 */
	public void	setTStfAmt(String tStfAmt ) {
		this.tStfAmt =	tStfAmt;
	}
 	/**
	 * Column Info
	 * @param  tDdcAmt
 	 */
	public void	setTDdcAmt(String tDdcAmt ) {
		this.tDdcAmt =	tDdcAmt;
	}
 	/**
	 * Column Info
	 * @param  tSzcAmt
 	 */
	public void	setTSzcAmt(String tSzcAmt ) {
		this.tSzcAmt =	tSzcAmt;
	}
 	/**
	 * Column Info
	 * @param  tCucAmt
 	 */
	public void	setTCucAmt(String tCucAmt ) {
		this.tCucAmt =	tCucAmt;
	}
 	/**
	 * Column Info
	 * @param  tDthAmt
 	 */
	public void	setTDthAmt(String tDthAmt ) {
		this.tDthAmt =	tDthAmt;
	}
 	/**
	 * Column Info
	 * @param  tHrsAmt
 	 */
	public void	setTHrsAmt(String tHrsAmt ) {
		this.tHrsAmt =	tHrsAmt;
	}
 	/**
	 * Column Info
	 * @param  tApsAmt
 	 */
	public void	setTApsAmt(String tApsAmt ) {
		this.tApsAmt =	tApsAmt;
	}
 	/**
	 * Column Info
	 * @param  tFrbAmt
 	 */
	public void	setTFrbAmt(String tFrbAmt ) {
		this.tFrbAmt =	tFrbAmt;
	}
 	/**
	 * Column Info
	 * @param  tOtsAmt
 	 */
	public void	setTOtsAmt(String tOtsAmt ) {
		this.tOtsAmt =	tOtsAmt;
	}
 	/**
	 * Column Info
	 * @param  tCfrAmt
 	 */
	public void	setTCfrAmt(String tCfrAmt ) {
		this.tCfrAmt =	tCfrAmt;
	}
 	/**
	 * Column Info
	 * @param  tOihAmt
 	 */
	public void	setTOihAmt(String tOihAmt ) {
		this.tOihAmt =	tOihAmt;
	}
 	/**
	 * Column Info
	 * @param  tTacAmt
 	 */
	public void	setTTacAmt(String tTacAmt ) {
		this.tTacAmt =	tTacAmt;
	}
 	/**
	 * Column Info
	 * @param  tActAmt
 	 */
	public void	setTActAmt(String tActAmt ) {
		this.tActAmt =	tActAmt;
	}
 	/**
	 * Column Info
	 * @param  tWscAmt
 	 */
	public void	setTWscAmt(String tWscAmt ) {
		this.tWscAmt =	tWscAmt;
	}
 	/**
	 * Column Info
	 * @param  agsCurrCd
 	 */
	public void	setAgsCurrCd(String agsCurrCd ) {
		this.agsCurrCd =	agsCurrCd;
	}
 	/**
	 * Column Info
	 * @param  cgdCurrCd
 	 */
	public void	setCgdCurrCd(String cgdCurrCd ) {
		this.cgdCurrCd =	cgdCurrCd;
	}
 	/**
	 * Column Info
	 * @param  cglCurrCd
 	 */
	public void	setCglCurrCd(String cglCurrCd ) {
		this.cglCurrCd =	cglCurrCd;
	}
 	/**
	 * Column Info
	 * @param  cssCurrCd
 	 */
	public void	setCssCurrCd(String cssCurrCd ) {
		this.cssCurrCd =	cssCurrCd;
	}
 	/**
	 * Column Info
	 * @param  ebsCurrCd
 	 */
	public void	setEbsCurrCd(String ebsCurrCd ) {
		this.ebsCurrCd =	ebsCurrCd;
	}
 	/**
	 * Column Info
	 * @param  eisCurrCd
 	 */
	public void	setEisCurrCd(String eisCurrCd ) {
		this.eisCurrCd =	eisCurrCd;
	}
 	/**
	 * Column Info
	 * @param  emsCurrCd
 	 */
	public void	setEmsCurrCd(String emsCurrCd ) {
		this.emsCurrCd =	emsCurrCd;
	}
 	/**
	 * Column Info
	 * @param  eriCurrCd
 	 */
	public void	setEriCurrCd(String eriCurrCd ) {
		this.eriCurrCd =	eriCurrCd;
	}
 	/**
	 * Column Info
	 * @param  fafCurrCd
 	 */
	public void	setFafCurrCd(String fafCurrCd ) {
		this.fafCurrCd =	fafCurrCd;
	}
 	/**
	 * Column Info
	 * @param  lsfCurrCd
 	 */
	public void	setLsfCurrCd(String lsfCurrCd ) {
		this.lsfCurrCd =	lsfCurrCd;
	}
 	/**
	 * Column Info
	 * @param  pssCurrCd
 	 */
	public void	setPssCurrCd(String pssCurrCd ) {
		this.pssCurrCd =	pssCurrCd;
	}
 	/**
	 * Column Info
	 * @param  sctCurrCd
 	 */
	public void	setSctCurrCd(String sctCurrCd ) {
		this.sctCurrCd =	sctCurrCd;
	}
 	/**
	 * Column Info
	 * @param  codCurrCd
 	 */
	public void	setCodCurrCd(String codCurrCd ) {
		this.codCurrCd =	codCurrCd;
	}
 	/**
	 * Column Info
	 * @param  dgsCurrCd
 	 */
	public void	setDgsCurrCd(String dgsCurrCd ) {
		this.dgsCurrCd =	dgsCurrCd;
	}
 	/**
	 * Column Info
	 * @param  gh2CurrCd
 	 */
	public void	setGh2CurrCd(String gh2CurrCd ) {
		this.gh2CurrCd =	gh2CurrCd;
	}
 	/**
	 * Column Info
	 * @param  gohCurrCd
 	 */
	public void	setGohCurrCd(String gohCurrCd ) {
		this.gohCurrCd =	gohCurrCd;
	}
 	/**
	 * Column Info
	 * @param  hazCurrCd
 	 */
	public void	setHazCurrCd(String hazCurrCd ) {
		this.hazCurrCd =	hazCurrCd;
	}
 	/**
	 * Column Info
	 * @param  heaCurrCd
 	 */
	public void	setHeaCurrCd(String heaCurrCd ) {
		this.heaCurrCd =	heaCurrCd;
	}
 	/**
	 * Column Info
	 * @param  sesCurrCd
 	 */
	public void	setSesCurrCd(String sesCurrCd ) {
		this.sesCurrCd =	sesCurrCd;
	}
 	/**
	 * Column Info
	 * @param  ecaCurrCd
 	 */
	public void	setEcaCurrCd(String ecaCurrCd ) {
		this.ecaCurrCd =	ecaCurrCd;
	}
 	/**
	 * Column Info
	 * @param  wtrCurrCd
 	 */
	public void	setWtrCurrCd(String wtrCurrCd ) {
		this.wtrCurrCd =	wtrCurrCd;
	}
 	/**
	 * Column Info
	 * @param  agsUsdLoclXchRt
 	 */
	public void	setAgsUsdLoclXchRt(String agsUsdLoclXchRt ) {
		this.agsUsdLoclXchRt =	agsUsdLoclXchRt;
	}
 	/**
	 * Column Info
	 * @param  cgdUsdLoclXchRt
 	 */
	public void	setCgdUsdLoclXchRt(String cgdUsdLoclXchRt ) {
		this.cgdUsdLoclXchRt =	cgdUsdLoclXchRt;
	}
 	/**
	 * Column Info
	 * @param  cglUsdLoclXchRt
 	 */
	public void	setCglUsdLoclXchRt(String cglUsdLoclXchRt ) {
		this.cglUsdLoclXchRt =	cglUsdLoclXchRt;
	}
 	/**
	 * Column Info
	 * @param  cssUsdLoclXchRt
 	 */
	public void	setCssUsdLoclXchRt(String cssUsdLoclXchRt ) {
		this.cssUsdLoclXchRt =	cssUsdLoclXchRt;
	}
 	/**
	 * Column Info
	 * @param  ebsUsdLoclXchRt
 	 */
	public void	setEbsUsdLoclXchRt(String ebsUsdLoclXchRt ) {
		this.ebsUsdLoclXchRt =	ebsUsdLoclXchRt;
	}
 	/**
	 * Column Info
	 * @param  eisUsdLoclXchRt
 	 */
	public void	setEisUsdLoclXchRt(String eisUsdLoclXchRt ) {
		this.eisUsdLoclXchRt =	eisUsdLoclXchRt;
	}
 	/**
	 * Column Info
	 * @param  emsUsdLoclXchRt
 	 */
	public void	setEmsUsdLoclXchRt(String emsUsdLoclXchRt ) {
		this.emsUsdLoclXchRt =	emsUsdLoclXchRt;
	}
 	/**
	 * Column Info
	 * @param  eriUsdLoclXchRt
 	 */
	public void	setEriUsdLoclXchRt(String eriUsdLoclXchRt ) {
		this.eriUsdLoclXchRt =	eriUsdLoclXchRt;
	}
 	/**
	 * Column Info
	 * @param  fafUsdLoclXchRt
 	 */
	public void	setFafUsdLoclXchRt(String fafUsdLoclXchRt ) {
		this.fafUsdLoclXchRt =	fafUsdLoclXchRt;
	}
 	/**
	 * Column Info
	 * @param  lsfUsdLoclXchRt
 	 */
	public void	setLsfUsdLoclXchRt(String lsfUsdLoclXchRt ) {
		this.lsfUsdLoclXchRt =	lsfUsdLoclXchRt;
	}
 	/**
	 * Column Info
	 * @param  pssUsdLoclXchRt
 	 */
	public void	setPssUsdLoclXchRt(String pssUsdLoclXchRt ) {
		this.pssUsdLoclXchRt =	pssUsdLoclXchRt;
	}
 	/**
	 * Column Info
	 * @param  sctUsdLoclXchRt
 	 */
	public void	setSctUsdLoclXchRt(String sctUsdLoclXchRt ) {
		this.sctUsdLoclXchRt =	sctUsdLoclXchRt;
	}
 	/**
	 * Column Info
	 * @param  codUsdLoclXchRt
 	 */
	public void	setCodUsdLoclXchRt(String codUsdLoclXchRt ) {
		this.codUsdLoclXchRt =	codUsdLoclXchRt;
	}
 	/**
	 * Column Info
	 * @param  dgsUsdLoclXchRt
 	 */
	public void	setDgsUsdLoclXchRt(String dgsUsdLoclXchRt ) {
		this.dgsUsdLoclXchRt =	dgsUsdLoclXchRt;
	}
 	/**
	 * Column Info
	 * @param  gh2UsdLoclXchRt
 	 */
	public void	setGh2UsdLoclXchRt(String gh2UsdLoclXchRt ) {
		this.gh2UsdLoclXchRt =	gh2UsdLoclXchRt;
	}
 	/**
	 * Column Info
	 * @param  gohUsdLoclXchRt
 	 */
	public void	setGohUsdLoclXchRt(String gohUsdLoclXchRt ) {
		this.gohUsdLoclXchRt =	gohUsdLoclXchRt;
	}
 	/**
	 * Column Info
	 * @param  hazUsdLoclXchRt
 	 */
	public void	setHazUsdLoclXchRt(String hazUsdLoclXchRt ) {
		this.hazUsdLoclXchRt =	hazUsdLoclXchRt;
	}
 	/**
	 * Column Info
	 * @param  heaUsdLoclXchRt
 	 */
	public void	setHeaUsdLoclXchRt(String heaUsdLoclXchRt ) {
		this.heaUsdLoclXchRt =	heaUsdLoclXchRt;
	}
 	/**
	 * Column Info
	 * @param  sesUsdLoclXchRt
 	 */
	public void	setSesUsdLoclXchRt(String sesUsdLoclXchRt ) {
		this.sesUsdLoclXchRt =	sesUsdLoclXchRt;
	}
 	/**
	 * Column Info
	 * @param  ecaUsdLoclXchRt
 	 */
	public void	setEcaUsdLoclXchRt(String ecaUsdLoclXchRt ) {
		this.ecaUsdLoclXchRt =	ecaUsdLoclXchRt;
	}
 	/**
	 * Column Info
	 * @param  wtrUsdLoclXchRt
 	 */
	public void	setWtrUsdLoclXchRt(String wtrUsdLoclXchRt ) {
		this.wtrUsdLoclXchRt =	wtrUsdLoclXchRt;
	}
 	/**
	 * Column Info
	 * @param  bucCurrCd
 	 */
	public void	setBucCurrCd(String bucCurrCd ) {
		this.bucCurrCd =	bucCurrCd;
	}
 	/**
	 * Column Info
	 * @param  csrCurrCd
 	 */
	public void	setCsrCurrCd(String csrCurrCd ) {
		this.csrCurrCd =	csrCurrCd;
	}
 	/**
	 * Column Info
	 * @param  cmsCurrCd
 	 */
	public void	setCmsCurrCd(String cmsCurrCd ) {
		this.cmsCurrCd =	cmsCurrCd;
	}
 	/**
	 * Column Info
	 * @param  othCurrCd
 	 */
	public void	setOthCurrCd(String othCurrCd ) {
		this.othCurrCd =	othCurrCd;
	}
 	/**
	 * Column Info
	 * @param  dhfCurrCd
 	 */
	public void	setDhfCurrCd(String dhfCurrCd ) {
		this.dhfCurrCd =	dhfCurrCd;
	}
 	/**
	 * Column Info
	 * @param  frcCurrCd
 	 */
	public void	setFrcCurrCd(String frcCurrCd ) {
		this.frcCurrCd =	frcCurrCd;
	}
 	/**
	 * Column Info
	 * @param  tscCurrCd
 	 */
	public void	setTscCurrCd(String tscCurrCd ) {
		this.tscCurrCd =	tscCurrCd;
	}
 	/**
	 * Column Info
	 * @param  ensCurrCd
 	 */
	public void	setEnsCurrCd(String ensCurrCd ) {
		this.ensCurrCd =	ensCurrCd;
	}
 	/**
	 * Column Info
	 * @param  stfCurrCd
 	 */
	public void	setStfCurrCd(String stfCurrCd ) {
		this.stfCurrCd =	stfCurrCd;
	}
 	/**
	 * Column Info
	 * @param  ddcCurrCd
 	 */
	public void	setDdcCurrCd(String ddcCurrCd ) {
		this.ddcCurrCd =	ddcCurrCd;
	}
 	/**
	 * Column Info
	 * @param  szcCurrCd
 	 */
	public void	setSzcCurrCd(String szcCurrCd ) {
		this.szcCurrCd =	szcCurrCd;
	}
 	/**
	 * Column Info
	 * @param  cucCurrCd
 	 */
	public void	setCucCurrCd(String cucCurrCd ) {
		this.cucCurrCd =	cucCurrCd;
	}
 	/**
	 * Column Info
	 * @param  dthCurrCd
 	 */
	public void	setDthCurrCd(String dthCurrCd ) {
		this.dthCurrCd =	dthCurrCd;
	}
 	/**
	 * Column Info
	 * @param  hrsCurrCd
 	 */
	public void	setHrsCurrCd(String hrsCurrCd ) {
		this.hrsCurrCd =	hrsCurrCd;
	}
 	/**
	 * Column Info
	 * @param  apsCurrCd
 	 */
	public void	setApsCurrCd(String apsCurrCd ) {
		this.apsCurrCd =	apsCurrCd;
	}
 	/**
	 * Column Info
	 * @param  frbCurrCd
 	 */
	public void	setFrbCurrCd(String frbCurrCd ) {
		this.frbCurrCd =	frbCurrCd;
	}
 	/**
	 * Column Info
	 * @param  otsCurrCd
 	 */
	public void	setOtsCurrCd(String otsCurrCd ) {
		this.otsCurrCd =	otsCurrCd;
	}
 	/**
	 * Column Info
	 * @param  cfrCurrCd
 	 */
	public void	setCfrCurrCd(String cfrCurrCd ) {
		this.cfrCurrCd =	cfrCurrCd;
	}
 	/**
	 * Column Info
	 * @param  oihCurrCd
 	 */
	public void	setOihCurrCd(String oihCurrCd ) {
		this.oihCurrCd =	oihCurrCd;
	}
 	/**
	 * Column Info
	 * @param  tacCurrCd
 	 */
	public void	setTacCurrCd(String tacCurrCd ) {
		this.tacCurrCd =	tacCurrCd;
	}
 	/**
	 * Column Info
	 * @param  actCurrCd
 	 */
	public void	setActCurrCd(String actCurrCd ) {
		this.actCurrCd =	actCurrCd;
	}
 	/**
	 * Column Info
	 * @param  wscCurrCd
 	 */
	public void	setWscCurrCd(String wscCurrCd ) {
		this.wscCurrCd =	wscCurrCd;
	}
 	/**
	 * Column Info
	 * @param  bucUsdLoclXchRt
 	 */
	public void	setBucUsdLoclXchRt(String bucUsdLoclXchRt ) {
		this.bucUsdLoclXchRt =	bucUsdLoclXchRt;
	}
 	/**
	 * Column Info
	 * @param  csrUsdLoclXchRt
 	 */
	public void	setCsrUsdLoclXchRt(String csrUsdLoclXchRt ) {
		this.csrUsdLoclXchRt =	csrUsdLoclXchRt;
	}
 	/**
	 * Column Info
	 * @param  cmsUsdLoclXchRt
 	 */
	public void	setCmsUsdLoclXchRt(String cmsUsdLoclXchRt ) {
		this.cmsUsdLoclXchRt =	cmsUsdLoclXchRt;
	}
 	/**
	 * Column Info
	 * @param  othUsdLoclXchRt
 	 */
	public void	setOthUsdLoclXchRt(String othUsdLoclXchRt ) {
		this.othUsdLoclXchRt =	othUsdLoclXchRt;
	}
 	/**
	 * Column Info
	 * @param  dhfUsdLoclXchRt
 	 */
	public void	setDhfUsdLoclXchRt(String dhfUsdLoclXchRt ) {
		this.dhfUsdLoclXchRt =	dhfUsdLoclXchRt;
	}
 	/**
	 * Column Info
	 * @param  frcUsdLoclXchRt
 	 */
	public void	setFrcUsdLoclXchRt(String frcUsdLoclXchRt ) {
		this.frcUsdLoclXchRt =	frcUsdLoclXchRt;
	}
 	/**
	 * Column Info
	 * @param  tscUsdLoclXchRt
 	 */
	public void	setTscUsdLoclXchRt(String tscUsdLoclXchRt ) {
		this.tscUsdLoclXchRt =	tscUsdLoclXchRt;
	}
 	/**
	 * Column Info
	 * @param  ensUsdLoclXchRt
 	 */
	public void	setEnsUsdLoclXchRt(String ensUsdLoclXchRt ) {
		this.ensUsdLoclXchRt =	ensUsdLoclXchRt;
	}
 	/**
	 * Column Info
	 * @param  stfUsdLoclXchRt
 	 */
	public void	setStfUsdLoclXchRt(String stfUsdLoclXchRt ) {
		this.stfUsdLoclXchRt =	stfUsdLoclXchRt;
	}
 	/**
	 * Column Info
	 * @param  ddcUsdLoclXchRt
 	 */
	public void	setDdcUsdLoclXchRt(String ddcUsdLoclXchRt ) {
		this.ddcUsdLoclXchRt =	ddcUsdLoclXchRt;
	}
 	/**
	 * Column Info
	 * @param  szcUsdLoclXchRt
 	 */
	public void	setSzcUsdLoclXchRt(String szcUsdLoclXchRt ) {
		this.szcUsdLoclXchRt =	szcUsdLoclXchRt;
	}
 	/**
	 * Column Info
	 * @param  cucUsdLoclXchRt
 	 */
	public void	setCucUsdLoclXchRt(String cucUsdLoclXchRt ) {
		this.cucUsdLoclXchRt =	cucUsdLoclXchRt;
	}
 	/**
	 * Column Info
	 * @param  dthUsdLoclXchRt
 	 */
	public void	setDthUsdLoclXchRt(String dthUsdLoclXchRt ) {
		this.dthUsdLoclXchRt =	dthUsdLoclXchRt;
	}
 	/**
	 * Column Info
	 * @param  hrsUsdLoclXchRt
 	 */
	public void	setHrsUsdLoclXchRt(String hrsUsdLoclXchRt ) {
		this.hrsUsdLoclXchRt =	hrsUsdLoclXchRt;
	}
 	/**
	 * Column Info
	 * @param  apsUsdLoclXchRt
 	 */
	public void	setApsUsdLoclXchRt(String apsUsdLoclXchRt ) {
		this.apsUsdLoclXchRt =	apsUsdLoclXchRt;
	}
 	/**
	 * Column Info
	 * @param  frbUsdLoclXchRt
 	 */
	public void	setFrbUsdLoclXchRt(String frbUsdLoclXchRt ) {
		this.frbUsdLoclXchRt =	frbUsdLoclXchRt;
	}
 	/**
	 * Column Info
	 * @param  otsUsdLoclXchRt
 	 */
	public void	setOtsUsdLoclXchRt(String otsUsdLoclXchRt ) {
		this.otsUsdLoclXchRt =	otsUsdLoclXchRt;
	}
 	/**
	 * Column Info
	 * @param  cfrUsdLoclXchRt
 	 */
	public void	setCfrUsdLoclXchRt(String cfrUsdLoclXchRt ) {
		this.cfrUsdLoclXchRt =	cfrUsdLoclXchRt;
	}
 	/**
	 * Column Info
	 * @param  oihUsdLoclXchRt
 	 */
	public void	setOihUsdLoclXchRt(String oihUsdLoclXchRt ) {
		this.oihUsdLoclXchRt =	oihUsdLoclXchRt;
	}
 	/**
	 * Column Info
	 * @param  tacUsdLoclXchRt
 	 */
	public void	setTacUsdLoclXchRt(String tacUsdLoclXchRt ) {
		this.tacUsdLoclXchRt =	tacUsdLoclXchRt;
	}
 	/**
	 * Column Info
	 * @param  actUsdLoclXchRt
 	 */
	public void	setActUsdLoclXchRt(String actUsdLoclXchRt ) {
		this.actUsdLoclXchRt =	actUsdLoclXchRt;
	}
 	/**
	 * Column Info
	 * @param  wscUsdLoclXchRt
 	 */
	public void	setWscUsdLoclXchRt(String wscUsdLoclXchRt ) {
		this.wscUsdLoclXchRt =	wscUsdLoclXchRt;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request)	{
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request,	String prefix) {
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setTestExecDt(JSPUtil.getParameter(request,	prefix + "test_exec_dt", ""));
		setExecDt(JSPUtil.getParameter(request,	prefix + "exec_dt", ""));
		setSvcScpCd(JSPUtil.getParameter(request,	prefix + "svc_scp_cd", ""));
		setFOrgCd(JSPUtil.getParameter(request,	prefix + "f_org_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setToFileDt(JSPUtil.getParameter(request,	prefix + "to_file_dt", ""));
		setFrFileDt(JSPUtil.getParameter(request,	prefix + "fr_file_dt", ""));
		setFileDt(JSPUtil.getParameter(request,	prefix + "file_dt", ""));
		setInqTpCd(JSPUtil.getParameter(request,	prefix + "inq_tp_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setMotTrfSeq(JSPUtil.getParameter(request,	prefix + "mot_trf_seq", ""));
		setRtSeq(JSPUtil.getParameter(request,	prefix + "rt_seq", ""));
		setBatExeDt(JSPUtil.getParameter(request,	prefix + "bat_exe_dt", ""));
		setSeq(JSPUtil.getParameter(request,	prefix + "seq", ""));
		setBkgSrcTpCd(JSPUtil.getParameter(request,	prefix + "bkg_src_tp_cd", ""));
		setBkgNo(JSPUtil.getParameter(request,	prefix + "bkg_no", ""));
		setCarrier(JSPUtil.getParameter(request,	prefix + "carrier", ""));
		setCtrtNo(JSPUtil.getParameter(request,	prefix + "ctrt_no", ""));
		setCtrtHldNm(JSPUtil.getParameter(request,	prefix + "ctrt_hld_nm", ""));
		setBkgShprNm(JSPUtil.getParameter(request,	prefix + "bkg_shpr_nm", ""));
		setBkgCneeNm(JSPUtil.getParameter(request,	prefix + "bkg_cnee_nm", ""));
		setForeTraComp(JSPUtil.getParameter(request,	prefix + "fore_tra_comp", ""));
		setOperAgt(JSPUtil.getParameter(request,	prefix + "oper_agt", ""));
		setLane(JSPUtil.getParameter(request,	prefix + "lane", ""));
		setWayPort(JSPUtil.getParameter(request,	prefix + "way_port", ""));
		setPolCd(JSPUtil.getParameter(request,	prefix + "pol_cd", ""));
		setDeptTsitPort(JSPUtil.getParameter(request,	prefix + "dept_tsit_port", ""));
		setDestTsitPort(JSPUtil.getParameter(request,	prefix + "dest_tsit_port", ""));
		setPodCd(JSPUtil.getParameter(request,	prefix + "pod_cd", ""));
		setTransTerm(JSPUtil.getParameter(request,	prefix + "trans_term", ""));
		setCntrTp(JSPUtil.getParameter(request,	prefix + "cntr_tp", ""));
		setCmdtTp(JSPUtil.getParameter(request,	prefix + "cmdt_tp", ""));
		setCntrSz(JSPUtil.getParameter(request,	prefix + "cntr_sz", ""));
		setCntrVol1(JSPUtil.getParameter(request,	prefix + "cntr_vol1", ""));
		setCntrVol2(JSPUtil.getParameter(request,	prefix + "cntr_vol2", ""));
		setOftRt(JSPUtil.getParameter(request,	prefix + "oft_rt", ""));
		setBlnk1(JSPUtil.getParameter(request,	prefix + "blnk1", ""));
		setBafAmt(JSPUtil.getParameter(request,	prefix + "baf_amt", ""));
		setCafAmt(JSPUtil.getParameter(request,	prefix + "caf_amt", ""));
		setAgsAmt(JSPUtil.getParameter(request,	prefix + "ags_amt", ""));
		setCgdAmt(JSPUtil.getParameter(request,	prefix + "cgd_amt", ""));
		setCglAmt(JSPUtil.getParameter(request,	prefix + "cgl_amt", ""));
		setCssAmt(JSPUtil.getParameter(request,	prefix + "css_amt", ""));
		setEbsAmt(JSPUtil.getParameter(request,	prefix + "ebs_amt", ""));
		setEisAmt(JSPUtil.getParameter(request,	prefix + "eis_amt", ""));
		setEmsAmt(JSPUtil.getParameter(request,	prefix + "ems_amt", ""));
		setEriAmt(JSPUtil.getParameter(request,	prefix + "eri_amt", ""));
		setFafAmt(JSPUtil.getParameter(request,	prefix + "faf_amt", ""));
		setLsfAmt(JSPUtil.getParameter(request,	prefix + "lsf_amt", ""));
		setPssAmt(JSPUtil.getParameter(request,	prefix + "pss_amt", ""));
		setSctAmt(JSPUtil.getParameter(request,	prefix + "sct_amt", ""));
		setCodAmt(JSPUtil.getParameter(request,	prefix + "cod_amt", ""));
		setDgsAmt(JSPUtil.getParameter(request,	prefix + "dgs_amt", ""));
		setGh2Amt(JSPUtil.getParameter(request,	prefix + "gh2_amt", ""));
		setGohAmt(JSPUtil.getParameter(request,	prefix + "goh_amt", ""));
		setHazAmt(JSPUtil.getParameter(request,	prefix + "haz_amt", ""));
		setHeaAmt(JSPUtil.getParameter(request,	prefix + "hea_amt", ""));
		setSesAmt(JSPUtil.getParameter(request,	prefix + "ses_amt", ""));
		setThcAmt(JSPUtil.getParameter(request,	prefix + "thc_amt", ""));
		setAmsAmt(JSPUtil.getParameter(request,	prefix + "ams_amt", ""));
		setBkfAmt(JSPUtil.getParameter(request,	prefix + "bkf_amt", ""));
		setCdcAmt(JSPUtil.getParameter(request,	prefix + "cdc_amt", ""));
		setCddAmt(JSPUtil.getParameter(request,	prefix + "cdd_amt", ""));
		setCtpAmt(JSPUtil.getParameter(request,	prefix + "ctp_amt", ""));
		setCyrAmt(JSPUtil.getParameter(request,	prefix + "cyr_amt", ""));
		setDocAmt(JSPUtil.getParameter(request,	prefix + "doc_amt", ""));
		setEmpAmt(JSPUtil.getParameter(request,	prefix + "emp_amt", ""));
		setEsdAmt(JSPUtil.getParameter(request,	prefix + "esd_amt", ""));
		setPsfAmt(JSPUtil.getParameter(request,	prefix + "psf_amt", ""));
		setSlfAmt(JSPUtil.getParameter(request,	prefix + "slf_amt", ""));
		setTslAmt(JSPUtil.getParameter(request,	prefix + "tsl_amt", ""));
		setXdoAmt(JSPUtil.getParameter(request,	prefix + "xdo_amt", ""));
		setAhaAmt(JSPUtil.getParameter(request,	prefix + "aha_amt", ""));
		setAlmAmt(JSPUtil.getParameter(request,	prefix + "alm_amt", ""));
		setAmaAmt(JSPUtil.getParameter(request,	prefix + "ama_amt", ""));
		setArdAmt(JSPUtil.getParameter(request,	prefix + "ard_amt", ""));
		setBadAmt(JSPUtil.getParameter(request,	prefix + "bad_amt", ""));
		setCccAmt(JSPUtil.getParameter(request,	prefix + "ccc_amt", ""));
		setCfdAmt(JSPUtil.getParameter(request,	prefix + "cfd_amt", ""));
		setCmcAmt(JSPUtil.getParameter(request,	prefix + "cmc_amt", ""));
		setCsvAmt(JSPUtil.getParameter(request,	prefix + "csv_amt", ""));
		setDofAmt(JSPUtil.getParameter(request,	prefix + "dof_amt", ""));
		setDrpAmt(JSPUtil.getParameter(request,	prefix + "drp_amt", ""));
		setEdiAmt(JSPUtil.getParameter(request,	prefix + "edi_amt", ""));
		setEhdAmt(JSPUtil.getParameter(request,	prefix + "ehd_amt", ""));
		setHafAmt(JSPUtil.getParameter(request,	prefix + "haf_amt", ""));
		setHauAmt(JSPUtil.getParameter(request,	prefix + "hau_amt", ""));
		setIfiAmt(JSPUtil.getParameter(request,	prefix + "ifi_amt", ""));
		setInsAmt(JSPUtil.getParameter(request,	prefix + "ins_amt", ""));
		setKcsAmt(JSPUtil.getParameter(request,	prefix + "kcs_amt", ""));
		setLloAmt(JSPUtil.getParameter(request,	prefix + "llo_amt", ""));
		setMplAmt(JSPUtil.getParameter(request,	prefix + "mpl_amt", ""));
		setPscAmt(JSPUtil.getParameter(request,	prefix + "psc_amt", ""));
		setRhaAmt(JSPUtil.getParameter(request,	prefix + "rha_amt", ""));
		setRlsAmt(JSPUtil.getParameter(request,	prefix + "rls_amt", ""));
		setRpcAmt(JSPUtil.getParameter(request,	prefix + "rpc_amt", ""));
		setTsdAmt(JSPUtil.getParameter(request,	prefix + "tsd_amt", ""));
		setWhaAmt(JSPUtil.getParameter(request,	prefix + "wha_amt", ""));
		setXddAmt(JSPUtil.getParameter(request,	prefix + "xdd_amt", ""));
		setXdeAmt(JSPUtil.getParameter(request,	prefix + "xde_amt", ""));
		setXerAmt(JSPUtil.getParameter(request,	prefix + "xer_amt", ""));
		setXwfAmt(JSPUtil.getParameter(request,	prefix + "xwf_amt", ""));
		setEcaAmt(JSPUtil.getParameter(request,	prefix + "eca_amt", ""));
		setWtrAmt(JSPUtil.getParameter(request,	prefix + "wtr_amt", ""));
		setCrsAmt(JSPUtil.getParameter(request,	prefix + "crs_amt", ""));
		setNeoAmt(JSPUtil.getParameter(request,	prefix + "neo_amt", ""));
		setOcrAmt(JSPUtil.getParameter(request,	prefix + "ocr_amt", ""));
		setEffDt(JSPUtil.getParameter(request,	prefix + "eff_dt", ""));
		setExpDt(JSPUtil.getParameter(request,	prefix + "exp_dt", ""));
		setRemark(JSPUtil.getParameter(request,	prefix + "remark", ""));
		setTBucAmt(JSPUtil.getParameter(request,	prefix + "t_buc_amt", ""));
		setTBafAmt(JSPUtil.getParameter(request,	prefix + "t_baf_amt", ""));
		setTCsrAmt(JSPUtil.getParameter(request,	prefix + "t_csr_amt", ""));
		setTCmsAmt(JSPUtil.getParameter(request,	prefix + "t_cms_amt", ""));
		setTOthAmt(JSPUtil.getParameter(request,	prefix + "t_oth_amt", ""));
		setTDhfAmt(JSPUtil.getParameter(request,	prefix + "t_dhf_amt", ""));
		setTFafAmt(JSPUtil.getParameter(request,	prefix + "t_faf_amt", ""));
		setTFrcAmt(JSPUtil.getParameter(request,	prefix + "t_frc_amt", ""));
		setTTscAmt(JSPUtil.getParameter(request,	prefix + "t_tsc_amt", ""));
		setTPscAmt(JSPUtil.getParameter(request,	prefix + "t_psc_amt", ""));
		setTEnsAmt(JSPUtil.getParameter(request,	prefix + "t_ens_amt", ""));
		setTStfAmt(JSPUtil.getParameter(request,	prefix + "t_stf_amt", ""));
		setTDdcAmt(JSPUtil.getParameter(request,	prefix + "t_ddc_amt", ""));
		setTSzcAmt(JSPUtil.getParameter(request,	prefix + "t_szc_amt", ""));
		setTCucAmt(JSPUtil.getParameter(request,	prefix + "t_cuc_amt", ""));
		setTDthAmt(JSPUtil.getParameter(request,	prefix + "t_dth_amt", ""));
		setTHrsAmt(JSPUtil.getParameter(request,	prefix + "t_hrs_amt", ""));
		setTApsAmt(JSPUtil.getParameter(request,	prefix + "t_aps_amt", ""));
		setTFrbAmt(JSPUtil.getParameter(request,	prefix + "t_frb_amt", ""));
		setTOtsAmt(JSPUtil.getParameter(request,	prefix + "t_ots_amt", ""));
		setTCfrAmt(JSPUtil.getParameter(request,	prefix + "t_cfr_amt", ""));
		setTOihAmt(JSPUtil.getParameter(request,	prefix + "t_oih_amt", ""));
		setTTacAmt(JSPUtil.getParameter(request,	prefix + "t_tac_amt", ""));
		setTActAmt(JSPUtil.getParameter(request,	prefix + "t_act_amt", ""));
		setTWscAmt(JSPUtil.getParameter(request,	prefix + "t_wsc_amt", ""));
		setAgsCurrCd(JSPUtil.getParameter(request,	prefix + "ags_curr_cd", ""));
		setCgdCurrCd(JSPUtil.getParameter(request,	prefix + "cgd_curr_cd", ""));
		setCglCurrCd(JSPUtil.getParameter(request,	prefix + "cgl_curr_cd", ""));
		setCssCurrCd(JSPUtil.getParameter(request,	prefix + "css_curr_cd", ""));
		setEbsCurrCd(JSPUtil.getParameter(request,	prefix + "ebs_curr_cd", ""));
		setEisCurrCd(JSPUtil.getParameter(request,	prefix + "eis_curr_cd", ""));
		setEmsCurrCd(JSPUtil.getParameter(request,	prefix + "ems_curr_cd", ""));
		setEriCurrCd(JSPUtil.getParameter(request,	prefix + "eri_curr_cd", ""));
		setFafCurrCd(JSPUtil.getParameter(request,	prefix + "faf_curr_cd", ""));
		setLsfCurrCd(JSPUtil.getParameter(request,	prefix + "lsf_curr_cd", ""));
		setPssCurrCd(JSPUtil.getParameter(request,	prefix + "pss_curr_cd", ""));
		setSctCurrCd(JSPUtil.getParameter(request,	prefix + "sct_curr_cd", ""));
		setCodCurrCd(JSPUtil.getParameter(request,	prefix + "cod_curr_cd", ""));
		setDgsCurrCd(JSPUtil.getParameter(request,	prefix + "dgs_curr_cd", ""));
		setGh2CurrCd(JSPUtil.getParameter(request,	prefix + "gh2_curr_cd", ""));
		setGohCurrCd(JSPUtil.getParameter(request,	prefix + "goh_curr_cd", ""));
		setHazCurrCd(JSPUtil.getParameter(request,	prefix + "haz_curr_cd", ""));
		setHeaCurrCd(JSPUtil.getParameter(request,	prefix + "hea_curr_cd", ""));
		setSesCurrCd(JSPUtil.getParameter(request,	prefix + "ses_curr_cd", ""));
		setEcaCurrCd(JSPUtil.getParameter(request,	prefix + "eca_curr_cd", ""));
		setWtrCurrCd(JSPUtil.getParameter(request,	prefix + "wtr_curr_cd", ""));
		setAgsUsdLoclXchRt(JSPUtil.getParameter(request,	prefix + "ags_usd_locl_xch_rt", ""));
		setCgdUsdLoclXchRt(JSPUtil.getParameter(request,	prefix + "cgd_usd_locl_xch_rt", ""));
		setCglUsdLoclXchRt(JSPUtil.getParameter(request,	prefix + "cgl_usd_locl_xch_rt", ""));
		setCssUsdLoclXchRt(JSPUtil.getParameter(request,	prefix + "css_usd_locl_xch_rt", ""));
		setEbsUsdLoclXchRt(JSPUtil.getParameter(request,	prefix + "ebs_usd_locl_xch_rt", ""));
		setEisUsdLoclXchRt(JSPUtil.getParameter(request,	prefix + "eis_usd_locl_xch_rt", ""));
		setEmsUsdLoclXchRt(JSPUtil.getParameter(request,	prefix + "ems_usd_locl_xch_rt", ""));
		setEriUsdLoclXchRt(JSPUtil.getParameter(request,	prefix + "eri_usd_locl_xch_rt", ""));
		setFafUsdLoclXchRt(JSPUtil.getParameter(request,	prefix + "faf_usd_locl_xch_rt", ""));
		setLsfUsdLoclXchRt(JSPUtil.getParameter(request,	prefix + "lsf_usd_locl_xch_rt", ""));
		setPssUsdLoclXchRt(JSPUtil.getParameter(request,	prefix + "pss_usd_locl_xch_rt", ""));
		setSctUsdLoclXchRt(JSPUtil.getParameter(request,	prefix + "sct_usd_locl_xch_rt", ""));
		setCodUsdLoclXchRt(JSPUtil.getParameter(request,	prefix + "cod_usd_locl_xch_rt", ""));
		setDgsUsdLoclXchRt(JSPUtil.getParameter(request,	prefix + "dgs_usd_locl_xch_rt", ""));
		setGh2UsdLoclXchRt(JSPUtil.getParameter(request,	prefix + "gh2_usd_locl_xch_rt", ""));
		setGohUsdLoclXchRt(JSPUtil.getParameter(request,	prefix + "goh_usd_locl_xch_rt", ""));
		setHazUsdLoclXchRt(JSPUtil.getParameter(request,	prefix + "haz_usd_locl_xch_rt", ""));
		setHeaUsdLoclXchRt(JSPUtil.getParameter(request,	prefix + "hea_usd_locl_xch_rt", ""));
		setSesUsdLoclXchRt(JSPUtil.getParameter(request,	prefix + "ses_usd_locl_xch_rt", ""));
		setEcaUsdLoclXchRt(JSPUtil.getParameter(request,	prefix + "eca_usd_locl_xch_rt", ""));
		setWtrUsdLoclXchRt(JSPUtil.getParameter(request,	prefix + "wtr_usd_locl_xch_rt", ""));
		setBucCurrCd(JSPUtil.getParameter(request,	prefix + "buc_curr_cd", ""));
		setCsrCurrCd(JSPUtil.getParameter(request,	prefix + "csr_curr_cd", ""));
		setCmsCurrCd(JSPUtil.getParameter(request,	prefix + "cms_curr_cd", ""));
		setOthCurrCd(JSPUtil.getParameter(request,	prefix + "oth_curr_cd", ""));
		setDhfCurrCd(JSPUtil.getParameter(request,	prefix + "dhf_curr_cd", ""));
		setFrcCurrCd(JSPUtil.getParameter(request,	prefix + "frc_curr_cd", ""));
		setTscCurrCd(JSPUtil.getParameter(request,	prefix + "tsc_curr_cd", ""));
		setEnsCurrCd(JSPUtil.getParameter(request,	prefix + "ens_curr_cd", ""));
		setStfCurrCd(JSPUtil.getParameter(request,	prefix + "stf_curr_cd", ""));
		setDdcCurrCd(JSPUtil.getParameter(request,	prefix + "ddc_curr_cd", ""));
		setSzcCurrCd(JSPUtil.getParameter(request,	prefix + "szc_curr_cd", ""));
		setCucCurrCd(JSPUtil.getParameter(request,	prefix + "cuc_curr_cd", ""));
		setDthCurrCd(JSPUtil.getParameter(request,	prefix + "dth_curr_cd", ""));
		setHrsCurrCd(JSPUtil.getParameter(request,	prefix + "hrs_curr_cd", ""));
		setApsCurrCd(JSPUtil.getParameter(request,	prefix + "aps_curr_cd", ""));
		setFrbCurrCd(JSPUtil.getParameter(request,	prefix + "frb_curr_cd", ""));
		setOtsCurrCd(JSPUtil.getParameter(request,	prefix + "ots_curr_cd", ""));
		setCfrCurrCd(JSPUtil.getParameter(request,	prefix + "cfr_curr_cd", ""));
		setOihCurrCd(JSPUtil.getParameter(request,	prefix + "oih_curr_cd", ""));
		setTacCurrCd(JSPUtil.getParameter(request,	prefix + "tac_curr_cd", ""));
		setActCurrCd(JSPUtil.getParameter(request,	prefix + "act_curr_cd", ""));
		setWscCurrCd(JSPUtil.getParameter(request,	prefix + "wsc_curr_cd", ""));
		setBucUsdLoclXchRt(JSPUtil.getParameter(request,	prefix + "buc_usd_locl_xch_rt", ""));
		setCsrUsdLoclXchRt(JSPUtil.getParameter(request,	prefix + "csr_usd_locl_xch_rt", ""));
		setCmsUsdLoclXchRt(JSPUtil.getParameter(request,	prefix + "cms_usd_locl_xch_rt", ""));
		setOthUsdLoclXchRt(JSPUtil.getParameter(request,	prefix + "oth_usd_locl_xch_rt", ""));
		setDhfUsdLoclXchRt(JSPUtil.getParameter(request,	prefix + "dhf_usd_locl_xch_rt", ""));
		setFrcUsdLoclXchRt(JSPUtil.getParameter(request,	prefix + "frc_usd_locl_xch_rt", ""));
		setTscUsdLoclXchRt(JSPUtil.getParameter(request,	prefix + "tsc_usd_locl_xch_rt", ""));
		setEnsUsdLoclXchRt(JSPUtil.getParameter(request,	prefix + "ens_usd_locl_xch_rt", ""));
		setStfUsdLoclXchRt(JSPUtil.getParameter(request,	prefix + "stf_usd_locl_xch_rt", ""));
		setDdcUsdLoclXchRt(JSPUtil.getParameter(request,	prefix + "ddc_usd_locl_xch_rt", ""));
		setSzcUsdLoclXchRt(JSPUtil.getParameter(request,	prefix + "szc_usd_locl_xch_rt", ""));
		setCucUsdLoclXchRt(JSPUtil.getParameter(request,	prefix + "cuc_usd_locl_xch_rt", ""));
		setDthUsdLoclXchRt(JSPUtil.getParameter(request,	prefix + "dth_usd_locl_xch_rt", ""));
		setHrsUsdLoclXchRt(JSPUtil.getParameter(request,	prefix + "hrs_usd_locl_xch_rt", ""));
		setApsUsdLoclXchRt(JSPUtil.getParameter(request,	prefix + "aps_usd_locl_xch_rt", ""));
		setFrbUsdLoclXchRt(JSPUtil.getParameter(request,	prefix + "frb_usd_locl_xch_rt", ""));
		setOtsUsdLoclXchRt(JSPUtil.getParameter(request,	prefix + "ots_usd_locl_xch_rt", ""));
		setCfrUsdLoclXchRt(JSPUtil.getParameter(request,	prefix + "cfr_usd_locl_xch_rt", ""));
		setOihUsdLoclXchRt(JSPUtil.getParameter(request,	prefix + "oih_usd_locl_xch_rt", ""));
		setTacUsdLoclXchRt(JSPUtil.getParameter(request,	prefix + "tac_usd_locl_xch_rt", ""));
		setActUsdLoclXchRt(JSPUtil.getParameter(request,	prefix + "act_usd_locl_xch_rt", ""));
		setWscUsdLoclXchRt(JSPUtil.getParameter(request,	prefix + "wsc_usd_locl_xch_rt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltSearchMOTSSEFilingListVO[]
	 */
	public RsltSearchMOTSSEFilingListVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return RsltSearchMOTSSEFilingListVO[]
	 */
	public RsltSearchMOTSSEFilingListVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		RsltSearchMOTSSEFilingListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
			String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag",	length));
			String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows",	length));
			String[] testExecDt =	(JSPUtil.getParameter(request, prefix +	"test_exec_dt",	length));
			String[] execDt =	(JSPUtil.getParameter(request, prefix +	"exec_dt",	length));
			String[] svcScpCd =	(JSPUtil.getParameter(request, prefix +	"svc_scp_cd",	length));
			String[] fOrgCd =	(JSPUtil.getParameter(request, prefix +	"f_org_cd",	length));
			String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id",	length));
			String[] toFileDt =	(JSPUtil.getParameter(request, prefix +	"to_file_dt",	length));
			String[] frFileDt =	(JSPUtil.getParameter(request, prefix +	"fr_file_dt",	length));
			String[] fileDt =	(JSPUtil.getParameter(request, prefix +	"file_dt",	length));
			String[] inqTpCd =	(JSPUtil.getParameter(request, prefix +	"inq_tp_cd",	length));
			String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id",	length));
			String[] motTrfSeq =	(JSPUtil.getParameter(request, prefix +	"mot_trf_seq",	length));
			String[] rtSeq =	(JSPUtil.getParameter(request, prefix +	"rt_seq",	length));
			String[] batExeDt =	(JSPUtil.getParameter(request, prefix +	"bat_exe_dt",	length));
			String[] seq =	(JSPUtil.getParameter(request, prefix +	"seq",	length));
			String[] bkgSrcTpCd =	(JSPUtil.getParameter(request, prefix +	"bkg_src_tp_cd",	length));
			String[] bkgNo =	(JSPUtil.getParameter(request, prefix +	"bkg_no",	length));
			String[] carrier =	(JSPUtil.getParameter(request, prefix +	"carrier",	length));
			String[] ctrtNo =	(JSPUtil.getParameter(request, prefix +	"ctrt_no",	length));
			String[] ctrtHldNm =	(JSPUtil.getParameter(request, prefix +	"ctrt_hld_nm",	length));
			String[] bkgShprNm =	(JSPUtil.getParameter(request, prefix +	"bkg_shpr_nm",	length));
			String[] bkgCneeNm =	(JSPUtil.getParameter(request, prefix +	"bkg_cnee_nm",	length));
			String[] foreTraComp =	(JSPUtil.getParameter(request, prefix +	"fore_tra_comp",	length));
			String[] operAgt =	(JSPUtil.getParameter(request, prefix +	"oper_agt",	length));
			String[] lane =	(JSPUtil.getParameter(request, prefix +	"lane",	length));
			String[] wayPort =	(JSPUtil.getParameter(request, prefix +	"way_port",	length));
			String[] polCd =	(JSPUtil.getParameter(request, prefix +	"pol_cd",	length));
			String[] deptTsitPort =	(JSPUtil.getParameter(request, prefix +	"dept_tsit_port",	length));
			String[] destTsitPort =	(JSPUtil.getParameter(request, prefix +	"dest_tsit_port",	length));
			String[] podCd =	(JSPUtil.getParameter(request, prefix +	"pod_cd",	length));
			String[] transTerm =	(JSPUtil.getParameter(request, prefix +	"trans_term",	length));
			String[] cntrTp =	(JSPUtil.getParameter(request, prefix +	"cntr_tp",	length));
			String[] cmdtTp =	(JSPUtil.getParameter(request, prefix +	"cmdt_tp",	length));
			String[] cntrSz =	(JSPUtil.getParameter(request, prefix +	"cntr_sz",	length));
			String[] cntrVol1 =	(JSPUtil.getParameter(request, prefix +	"cntr_vol1",	length));
			String[] cntrVol2 =	(JSPUtil.getParameter(request, prefix +	"cntr_vol2",	length));
			String[] oftRt =	(JSPUtil.getParameter(request, prefix +	"oft_rt",	length));
			String[] blnk1 =	(JSPUtil.getParameter(request, prefix +	"blnk1",	length));
			String[] bafAmt =	(JSPUtil.getParameter(request, prefix +	"baf_amt",	length));
			String[] cafAmt =	(JSPUtil.getParameter(request, prefix +	"caf_amt",	length));
			String[] agsAmt =	(JSPUtil.getParameter(request, prefix +	"ags_amt",	length));
			String[] cgdAmt =	(JSPUtil.getParameter(request, prefix +	"cgd_amt",	length));
			String[] cglAmt =	(JSPUtil.getParameter(request, prefix +	"cgl_amt",	length));
			String[] cssAmt =	(JSPUtil.getParameter(request, prefix +	"css_amt",	length));
			String[] ebsAmt =	(JSPUtil.getParameter(request, prefix +	"ebs_amt",	length));
			String[] eisAmt =	(JSPUtil.getParameter(request, prefix +	"eis_amt",	length));
			String[] emsAmt =	(JSPUtil.getParameter(request, prefix +	"ems_amt",	length));
			String[] eriAmt =	(JSPUtil.getParameter(request, prefix +	"eri_amt",	length));
			String[] fafAmt =	(JSPUtil.getParameter(request, prefix +	"faf_amt",	length));
			String[] lsfAmt =	(JSPUtil.getParameter(request, prefix +	"lsf_amt",	length));
			String[] pssAmt =	(JSPUtil.getParameter(request, prefix +	"pss_amt",	length));
			String[] sctAmt =	(JSPUtil.getParameter(request, prefix +	"sct_amt",	length));
			String[] codAmt =	(JSPUtil.getParameter(request, prefix +	"cod_amt",	length));
			String[] dgsAmt =	(JSPUtil.getParameter(request, prefix +	"dgs_amt",	length));
			String[] gh2Amt =	(JSPUtil.getParameter(request, prefix +	"gh2_amt",	length));
			String[] gohAmt =	(JSPUtil.getParameter(request, prefix +	"goh_amt",	length));
			String[] hazAmt =	(JSPUtil.getParameter(request, prefix +	"haz_amt",	length));
			String[] heaAmt =	(JSPUtil.getParameter(request, prefix +	"hea_amt",	length));
			String[] sesAmt =	(JSPUtil.getParameter(request, prefix +	"ses_amt",	length));
			String[] thcAmt =	(JSPUtil.getParameter(request, prefix +	"thc_amt",	length));
			String[] amsAmt =	(JSPUtil.getParameter(request, prefix +	"ams_amt",	length));
			String[] bkfAmt =	(JSPUtil.getParameter(request, prefix +	"bkf_amt",	length));
			String[] cdcAmt =	(JSPUtil.getParameter(request, prefix +	"cdc_amt",	length));
			String[] cddAmt =	(JSPUtil.getParameter(request, prefix +	"cdd_amt",	length));
			String[] ctpAmt =	(JSPUtil.getParameter(request, prefix +	"ctp_amt",	length));
			String[] cyrAmt =	(JSPUtil.getParameter(request, prefix +	"cyr_amt",	length));
			String[] docAmt =	(JSPUtil.getParameter(request, prefix +	"doc_amt",	length));
			String[] empAmt =	(JSPUtil.getParameter(request, prefix +	"emp_amt",	length));
			String[] esdAmt =	(JSPUtil.getParameter(request, prefix +	"esd_amt",	length));
			String[] psfAmt =	(JSPUtil.getParameter(request, prefix +	"psf_amt",	length));
			String[] slfAmt =	(JSPUtil.getParameter(request, prefix +	"slf_amt",	length));
			String[] tslAmt =	(JSPUtil.getParameter(request, prefix +	"tsl_amt",	length));
			String[] xdoAmt =	(JSPUtil.getParameter(request, prefix +	"xdo_amt",	length));
			String[] ahaAmt =	(JSPUtil.getParameter(request, prefix +	"aha_amt",	length));
			String[] almAmt =	(JSPUtil.getParameter(request, prefix +	"alm_amt",	length));
			String[] amaAmt =	(JSPUtil.getParameter(request, prefix +	"ama_amt",	length));
			String[] ardAmt =	(JSPUtil.getParameter(request, prefix +	"ard_amt",	length));
			String[] badAmt =	(JSPUtil.getParameter(request, prefix +	"bad_amt",	length));
			String[] cccAmt =	(JSPUtil.getParameter(request, prefix +	"ccc_amt",	length));
			String[] cfdAmt =	(JSPUtil.getParameter(request, prefix +	"cfd_amt",	length));
			String[] cmcAmt =	(JSPUtil.getParameter(request, prefix +	"cmc_amt",	length));
			String[] csvAmt =	(JSPUtil.getParameter(request, prefix +	"csv_amt",	length));
			String[] dofAmt =	(JSPUtil.getParameter(request, prefix +	"dof_amt",	length));
			String[] drpAmt =	(JSPUtil.getParameter(request, prefix +	"drp_amt",	length));
			String[] ediAmt =	(JSPUtil.getParameter(request, prefix +	"edi_amt",	length));
			String[] ehdAmt =	(JSPUtil.getParameter(request, prefix +	"ehd_amt",	length));
			String[] hafAmt =	(JSPUtil.getParameter(request, prefix +	"haf_amt",	length));
			String[] hauAmt =	(JSPUtil.getParameter(request, prefix +	"hau_amt",	length));
			String[] ifiAmt =	(JSPUtil.getParameter(request, prefix +	"ifi_amt",	length));
			String[] insAmt =	(JSPUtil.getParameter(request, prefix +	"ins_amt",	length));
			String[] kcsAmt =	(JSPUtil.getParameter(request, prefix +	"kcs_amt",	length));
			String[] lloAmt =	(JSPUtil.getParameter(request, prefix +	"llo_amt",	length));
			String[] mplAmt =	(JSPUtil.getParameter(request, prefix +	"mpl_amt",	length));
			String[] pscAmt =	(JSPUtil.getParameter(request, prefix +	"psc_amt",	length));
			String[] rhaAmt =	(JSPUtil.getParameter(request, prefix +	"rha_amt",	length));
			String[] rlsAmt =	(JSPUtil.getParameter(request, prefix +	"rls_amt",	length));
			String[] rpcAmt =	(JSPUtil.getParameter(request, prefix +	"rpc_amt",	length));
			String[] tsdAmt =	(JSPUtil.getParameter(request, prefix +	"tsd_amt",	length));
			String[] whaAmt =	(JSPUtil.getParameter(request, prefix +	"wha_amt",	length));
			String[] xddAmt =	(JSPUtil.getParameter(request, prefix +	"xdd_amt",	length));
			String[] xdeAmt =	(JSPUtil.getParameter(request, prefix +	"xde_amt",	length));
			String[] xerAmt =	(JSPUtil.getParameter(request, prefix +	"xer_amt",	length));
			String[] xwfAmt =	(JSPUtil.getParameter(request, prefix +	"xwf_amt",	length));
			String[] ecaAmt =	(JSPUtil.getParameter(request, prefix +	"eca_amt",	length));
			String[] wtrAmt =	(JSPUtil.getParameter(request, prefix +	"wtr_amt",	length));
			String[] crsAmt =	(JSPUtil.getParameter(request, prefix +	"crs_amt",	length));
			String[] neoAmt =	(JSPUtil.getParameter(request, prefix +	"neo_amt",	length));
			String[] ocrAmt =	(JSPUtil.getParameter(request, prefix +	"ocr_amt",	length));
			String[] effDt =	(JSPUtil.getParameter(request, prefix +	"eff_dt",	length));
			String[] expDt =	(JSPUtil.getParameter(request, prefix +	"exp_dt",	length));
			String[] remark =	(JSPUtil.getParameter(request, prefix +	"remark",	length));
			String[] tBucAmt =	(JSPUtil.getParameter(request, prefix +	"t_buc_amt",	length));
			String[] tBafAmt =	(JSPUtil.getParameter(request, prefix +	"t_baf_amt",	length));
			String[] tCsrAmt =	(JSPUtil.getParameter(request, prefix +	"t_csr_amt",	length));
			String[] tCmsAmt =	(JSPUtil.getParameter(request, prefix +	"t_cms_amt",	length));
			String[] tOthAmt =	(JSPUtil.getParameter(request, prefix +	"t_oth_amt",	length));
			String[] tDhfAmt =	(JSPUtil.getParameter(request, prefix +	"t_dhf_amt",	length));
			String[] tFafAmt =	(JSPUtil.getParameter(request, prefix +	"t_faf_amt",	length));
			String[] tFrcAmt =	(JSPUtil.getParameter(request, prefix +	"t_frc_amt",	length));
			String[] tTscAmt =	(JSPUtil.getParameter(request, prefix +	"t_tsc_amt",	length));
			String[] tPscAmt =	(JSPUtil.getParameter(request, prefix +	"t_psc_amt",	length));
			String[] tEnsAmt =	(JSPUtil.getParameter(request, prefix +	"t_ens_amt",	length));
			String[] tStfAmt =	(JSPUtil.getParameter(request, prefix +	"t_stf_amt",	length));
			String[] tDdcAmt =	(JSPUtil.getParameter(request, prefix +	"t_ddc_amt",	length));
			String[] tSzcAmt =	(JSPUtil.getParameter(request, prefix +	"t_szc_amt",	length));
			String[] tCucAmt =	(JSPUtil.getParameter(request, prefix +	"t_cuc_amt",	length));
			String[] tDthAmt =	(JSPUtil.getParameter(request, prefix +	"t_dth_amt",	length));
			String[] tHrsAmt =	(JSPUtil.getParameter(request, prefix +	"t_hrs_amt",	length));
			String[] tApsAmt =	(JSPUtil.getParameter(request, prefix +	"t_aps_amt",	length));
			String[] tFrbAmt =	(JSPUtil.getParameter(request, prefix +	"t_frb_amt",	length));
			String[] tOtsAmt =	(JSPUtil.getParameter(request, prefix +	"t_ots_amt",	length));
			String[] tCfrAmt =	(JSPUtil.getParameter(request, prefix +	"t_cfr_amt",	length));
			String[] tOihAmt =	(JSPUtil.getParameter(request, prefix +	"t_oih_amt",	length));
			String[] tTacAmt =	(JSPUtil.getParameter(request, prefix +	"t_tac_amt",	length));
			String[] tActAmt =	(JSPUtil.getParameter(request, prefix +	"t_act_amt",	length));
			String[] tWscAmt =	(JSPUtil.getParameter(request, prefix +	"t_wsc_amt",	length));
			String[] agsCurrCd =	(JSPUtil.getParameter(request, prefix +	"ags_curr_cd",	length));
			String[] cgdCurrCd =	(JSPUtil.getParameter(request, prefix +	"cgd_curr_cd",	length));
			String[] cglCurrCd =	(JSPUtil.getParameter(request, prefix +	"cgl_curr_cd",	length));
			String[] cssCurrCd =	(JSPUtil.getParameter(request, prefix +	"css_curr_cd",	length));
			String[] ebsCurrCd =	(JSPUtil.getParameter(request, prefix +	"ebs_curr_cd",	length));
			String[] eisCurrCd =	(JSPUtil.getParameter(request, prefix +	"eis_curr_cd",	length));
			String[] emsCurrCd =	(JSPUtil.getParameter(request, prefix +	"ems_curr_cd",	length));
			String[] eriCurrCd =	(JSPUtil.getParameter(request, prefix +	"eri_curr_cd",	length));
			String[] fafCurrCd =	(JSPUtil.getParameter(request, prefix +	"faf_curr_cd",	length));
			String[] lsfCurrCd =	(JSPUtil.getParameter(request, prefix +	"lsf_curr_cd",	length));
			String[] pssCurrCd =	(JSPUtil.getParameter(request, prefix +	"pss_curr_cd",	length));
			String[] sctCurrCd =	(JSPUtil.getParameter(request, prefix +	"sct_curr_cd",	length));
			String[] codCurrCd =	(JSPUtil.getParameter(request, prefix +	"cod_curr_cd",	length));
			String[] dgsCurrCd =	(JSPUtil.getParameter(request, prefix +	"dgs_curr_cd",	length));
			String[] gh2CurrCd =	(JSPUtil.getParameter(request, prefix +	"gh2_curr_cd",	length));
			String[] gohCurrCd =	(JSPUtil.getParameter(request, prefix +	"goh_curr_cd",	length));
			String[] hazCurrCd =	(JSPUtil.getParameter(request, prefix +	"haz_curr_cd",	length));
			String[] heaCurrCd =	(JSPUtil.getParameter(request, prefix +	"hea_curr_cd",	length));
			String[] sesCurrCd =	(JSPUtil.getParameter(request, prefix +	"ses_curr_cd",	length));
			String[] ecaCurrCd =	(JSPUtil.getParameter(request, prefix +	"eca_curr_cd",	length));
			String[] wtrCurrCd =	(JSPUtil.getParameter(request, prefix +	"wtr_curr_cd",	length));
			String[] agsUsdLoclXchRt =	(JSPUtil.getParameter(request, prefix +	"ags_usd_locl_xch_rt",	length));
			String[] cgdUsdLoclXchRt =	(JSPUtil.getParameter(request, prefix +	"cgd_usd_locl_xch_rt",	length));
			String[] cglUsdLoclXchRt =	(JSPUtil.getParameter(request, prefix +	"cgl_usd_locl_xch_rt",	length));
			String[] cssUsdLoclXchRt =	(JSPUtil.getParameter(request, prefix +	"css_usd_locl_xch_rt",	length));
			String[] ebsUsdLoclXchRt =	(JSPUtil.getParameter(request, prefix +	"ebs_usd_locl_xch_rt",	length));
			String[] eisUsdLoclXchRt =	(JSPUtil.getParameter(request, prefix +	"eis_usd_locl_xch_rt",	length));
			String[] emsUsdLoclXchRt =	(JSPUtil.getParameter(request, prefix +	"ems_usd_locl_xch_rt",	length));
			String[] eriUsdLoclXchRt =	(JSPUtil.getParameter(request, prefix +	"eri_usd_locl_xch_rt",	length));
			String[] fafUsdLoclXchRt =	(JSPUtil.getParameter(request, prefix +	"faf_usd_locl_xch_rt",	length));
			String[] lsfUsdLoclXchRt =	(JSPUtil.getParameter(request, prefix +	"lsf_usd_locl_xch_rt",	length));
			String[] pssUsdLoclXchRt =	(JSPUtil.getParameter(request, prefix +	"pss_usd_locl_xch_rt",	length));
			String[] sctUsdLoclXchRt =	(JSPUtil.getParameter(request, prefix +	"sct_usd_locl_xch_rt",	length));
			String[] codUsdLoclXchRt =	(JSPUtil.getParameter(request, prefix +	"cod_usd_locl_xch_rt",	length));
			String[] dgsUsdLoclXchRt =	(JSPUtil.getParameter(request, prefix +	"dgs_usd_locl_xch_rt",	length));
			String[] gh2UsdLoclXchRt =	(JSPUtil.getParameter(request, prefix +	"gh2_usd_locl_xch_rt",	length));
			String[] gohUsdLoclXchRt =	(JSPUtil.getParameter(request, prefix +	"goh_usd_locl_xch_rt",	length));
			String[] hazUsdLoclXchRt =	(JSPUtil.getParameter(request, prefix +	"haz_usd_locl_xch_rt",	length));
			String[] heaUsdLoclXchRt =	(JSPUtil.getParameter(request, prefix +	"hea_usd_locl_xch_rt",	length));
			String[] sesUsdLoclXchRt =	(JSPUtil.getParameter(request, prefix +	"ses_usd_locl_xch_rt",	length));
			String[] ecaUsdLoclXchRt =	(JSPUtil.getParameter(request, prefix +	"eca_usd_locl_xch_rt",	length));
			String[] wtrUsdLoclXchRt =	(JSPUtil.getParameter(request, prefix +	"wtr_usd_locl_xch_rt",	length));
			String[] bucCurrCd =	(JSPUtil.getParameter(request, prefix +	"buc_curr_cd",	length));
			String[] csrCurrCd =	(JSPUtil.getParameter(request, prefix +	"csr_curr_cd",	length));
			String[] cmsCurrCd =	(JSPUtil.getParameter(request, prefix +	"cms_curr_cd",	length));
			String[] othCurrCd =	(JSPUtil.getParameter(request, prefix +	"oth_curr_cd",	length));
			String[] dhfCurrCd =	(JSPUtil.getParameter(request, prefix +	"dhf_curr_cd",	length));
			String[] frcCurrCd =	(JSPUtil.getParameter(request, prefix +	"frc_curr_cd",	length));
			String[] tscCurrCd =	(JSPUtil.getParameter(request, prefix +	"tsc_curr_cd",	length));
			String[] ensCurrCd =	(JSPUtil.getParameter(request, prefix +	"ens_curr_cd",	length));
			String[] stfCurrCd =	(JSPUtil.getParameter(request, prefix +	"stf_curr_cd",	length));
			String[] ddcCurrCd =	(JSPUtil.getParameter(request, prefix +	"ddc_curr_cd",	length));
			String[] szcCurrCd =	(JSPUtil.getParameter(request, prefix +	"szc_curr_cd",	length));
			String[] cucCurrCd =	(JSPUtil.getParameter(request, prefix +	"cuc_curr_cd",	length));
			String[] dthCurrCd =	(JSPUtil.getParameter(request, prefix +	"dth_curr_cd",	length));
			String[] hrsCurrCd =	(JSPUtil.getParameter(request, prefix +	"hrs_curr_cd",	length));
			String[] apsCurrCd =	(JSPUtil.getParameter(request, prefix +	"aps_curr_cd",	length));
			String[] frbCurrCd =	(JSPUtil.getParameter(request, prefix +	"frb_curr_cd",	length));
			String[] otsCurrCd =	(JSPUtil.getParameter(request, prefix +	"ots_curr_cd",	length));
			String[] cfrCurrCd =	(JSPUtil.getParameter(request, prefix +	"cfr_curr_cd",	length));
			String[] oihCurrCd =	(JSPUtil.getParameter(request, prefix +	"oih_curr_cd",	length));
			String[] tacCurrCd =	(JSPUtil.getParameter(request, prefix +	"tac_curr_cd",	length));
			String[] actCurrCd =	(JSPUtil.getParameter(request, prefix +	"act_curr_cd",	length));
			String[] wscCurrCd =	(JSPUtil.getParameter(request, prefix +	"wsc_curr_cd",	length));
			String[] bucUsdLoclXchRt =	(JSPUtil.getParameter(request, prefix +	"buc_usd_locl_xch_rt",	length));
			String[] csrUsdLoclXchRt =	(JSPUtil.getParameter(request, prefix +	"csr_usd_locl_xch_rt",	length));
			String[] cmsUsdLoclXchRt =	(JSPUtil.getParameter(request, prefix +	"cms_usd_locl_xch_rt",	length));
			String[] othUsdLoclXchRt =	(JSPUtil.getParameter(request, prefix +	"oth_usd_locl_xch_rt",	length));
			String[] dhfUsdLoclXchRt =	(JSPUtil.getParameter(request, prefix +	"dhf_usd_locl_xch_rt",	length));
			String[] frcUsdLoclXchRt =	(JSPUtil.getParameter(request, prefix +	"frc_usd_locl_xch_rt",	length));
			String[] tscUsdLoclXchRt =	(JSPUtil.getParameter(request, prefix +	"tsc_usd_locl_xch_rt",	length));
			String[] ensUsdLoclXchRt =	(JSPUtil.getParameter(request, prefix +	"ens_usd_locl_xch_rt",	length));
			String[] stfUsdLoclXchRt =	(JSPUtil.getParameter(request, prefix +	"stf_usd_locl_xch_rt",	length));
			String[] ddcUsdLoclXchRt =	(JSPUtil.getParameter(request, prefix +	"ddc_usd_locl_xch_rt",	length));
			String[] szcUsdLoclXchRt =	(JSPUtil.getParameter(request, prefix +	"szc_usd_locl_xch_rt",	length));
			String[] cucUsdLoclXchRt =	(JSPUtil.getParameter(request, prefix +	"cuc_usd_locl_xch_rt",	length));
			String[] dthUsdLoclXchRt =	(JSPUtil.getParameter(request, prefix +	"dth_usd_locl_xch_rt",	length));
			String[] hrsUsdLoclXchRt =	(JSPUtil.getParameter(request, prefix +	"hrs_usd_locl_xch_rt",	length));
			String[] apsUsdLoclXchRt =	(JSPUtil.getParameter(request, prefix +	"aps_usd_locl_xch_rt",	length));
			String[] frbUsdLoclXchRt =	(JSPUtil.getParameter(request, prefix +	"frb_usd_locl_xch_rt",	length));
			String[] otsUsdLoclXchRt =	(JSPUtil.getParameter(request, prefix +	"ots_usd_locl_xch_rt",	length));
			String[] cfrUsdLoclXchRt =	(JSPUtil.getParameter(request, prefix +	"cfr_usd_locl_xch_rt",	length));
			String[] oihUsdLoclXchRt =	(JSPUtil.getParameter(request, prefix +	"oih_usd_locl_xch_rt",	length));
			String[] tacUsdLoclXchRt =	(JSPUtil.getParameter(request, prefix +	"tac_usd_locl_xch_rt",	length));
			String[] actUsdLoclXchRt =	(JSPUtil.getParameter(request, prefix +	"act_usd_locl_xch_rt",	length));
			String[] wscUsdLoclXchRt =	(JSPUtil.getParameter(request, prefix +	"wsc_usd_locl_xch_rt",	length));
			for	(int i = 0;	i <	length;	i++) {
				model =	new	RsltSearchMOTSSEFilingListVO();
				if ( ibflag[i] !=	null)
					model.setIbflag( ibflag[i]);
				if ( pagerows[i] !=	null)
					model.setPagerows( pagerows[i]);
				if ( testExecDt[i] !=	null)
					model.setTestExecDt( testExecDt[i]);
				if ( execDt[i] !=	null)
					model.setExecDt( execDt[i]);
				if ( svcScpCd[i] !=	null)
					model.setSvcScpCd( svcScpCd[i]);
				if ( fOrgCd[i] !=	null)
					model.setFOrgCd( fOrgCd[i]);
				if ( updUsrId[i] !=	null)
					model.setUpdUsrId( updUsrId[i]);
				if ( toFileDt[i] !=	null)
					model.setToFileDt( toFileDt[i]);
				if ( frFileDt[i] !=	null)
					model.setFrFileDt( frFileDt[i]);
				if ( fileDt[i] !=	null)
					model.setFileDt( fileDt[i]);
				if ( inqTpCd[i] !=	null)
					model.setInqTpCd( inqTpCd[i]);
				if ( creUsrId[i] !=	null)
					model.setCreUsrId( creUsrId[i]);
				if ( motTrfSeq[i] !=	null)
					model.setMotTrfSeq( motTrfSeq[i]);
				if ( rtSeq[i] !=	null)
					model.setRtSeq( rtSeq[i]);
				if ( batExeDt[i] !=	null)
					model.setBatExeDt( batExeDt[i]);
				if ( seq[i] !=	null)
					model.setSeq( seq[i]);
				if ( bkgSrcTpCd[i] !=	null)
					model.setBkgSrcTpCd( bkgSrcTpCd[i]);
				if ( bkgNo[i] !=	null)
					model.setBkgNo( bkgNo[i]);
				if ( carrier[i] !=	null)
					model.setCarrier( carrier[i]);
				if ( ctrtNo[i] !=	null)
					model.setCtrtNo( ctrtNo[i]);
				if ( ctrtHldNm[i] !=	null)
					model.setCtrtHldNm( ctrtHldNm[i]);
				if ( bkgShprNm[i] !=	null)
					model.setBkgShprNm( bkgShprNm[i]);
				if ( bkgCneeNm[i] !=	null)
					model.setBkgCneeNm( bkgCneeNm[i]);
				if ( foreTraComp[i] !=	null)
					model.setForeTraComp( foreTraComp[i]);
				if ( operAgt[i] !=	null)
					model.setOperAgt( operAgt[i]);
				if ( lane[i] !=	null)
					model.setLane( lane[i]);
				if ( wayPort[i] !=	null)
					model.setWayPort( wayPort[i]);
				if ( polCd[i] !=	null)
					model.setPolCd( polCd[i]);
				if ( deptTsitPort[i] !=	null)
					model.setDeptTsitPort( deptTsitPort[i]);
				if ( destTsitPort[i] !=	null)
					model.setDestTsitPort( destTsitPort[i]);
				if ( podCd[i] !=	null)
					model.setPodCd( podCd[i]);
				if ( transTerm[i] !=	null)
					model.setTransTerm( transTerm[i]);
				if ( cntrTp[i] !=	null)
					model.setCntrTp( cntrTp[i]);
				if ( cmdtTp[i] !=	null)
					model.setCmdtTp( cmdtTp[i]);
				if ( cntrSz[i] !=	null)
					model.setCntrSz( cntrSz[i]);
				if ( cntrVol1[i] !=	null)
					model.setCntrVol1( cntrVol1[i]);
				if ( cntrVol2[i] !=	null)
					model.setCntrVol2( cntrVol2[i]);
				if ( oftRt[i] !=	null)
					model.setOftRt( oftRt[i]);
				if ( blnk1[i] !=	null)
					model.setBlnk1( blnk1[i]);
				if ( bafAmt[i] !=	null)
					model.setBafAmt( bafAmt[i]);
				if ( cafAmt[i] !=	null)
					model.setCafAmt( cafAmt[i]);
				if ( agsAmt[i] !=	null)
					model.setAgsAmt( agsAmt[i]);
				if ( cgdAmt[i] !=	null)
					model.setCgdAmt( cgdAmt[i]);
				if ( cglAmt[i] !=	null)
					model.setCglAmt( cglAmt[i]);
				if ( cssAmt[i] !=	null)
					model.setCssAmt( cssAmt[i]);
				if ( ebsAmt[i] !=	null)
					model.setEbsAmt( ebsAmt[i]);
				if ( eisAmt[i] !=	null)
					model.setEisAmt( eisAmt[i]);
				if ( emsAmt[i] !=	null)
					model.setEmsAmt( emsAmt[i]);
				if ( eriAmt[i] !=	null)
					model.setEriAmt( eriAmt[i]);
				if ( fafAmt[i] !=	null)
					model.setFafAmt( fafAmt[i]);
				if ( lsfAmt[i] !=	null)
					model.setLsfAmt( lsfAmt[i]);
				if ( pssAmt[i] !=	null)
					model.setPssAmt( pssAmt[i]);
				if ( sctAmt[i] !=	null)
					model.setSctAmt( sctAmt[i]);
				if ( codAmt[i] !=	null)
					model.setCodAmt( codAmt[i]);
				if ( dgsAmt[i] !=	null)
					model.setDgsAmt( dgsAmt[i]);
				if ( gh2Amt[i] !=	null)
					model.setGh2Amt( gh2Amt[i]);
				if ( gohAmt[i] !=	null)
					model.setGohAmt( gohAmt[i]);
				if ( hazAmt[i] !=	null)
					model.setHazAmt( hazAmt[i]);
				if ( heaAmt[i] !=	null)
					model.setHeaAmt( heaAmt[i]);
				if ( sesAmt[i] !=	null)
					model.setSesAmt( sesAmt[i]);
				if ( thcAmt[i] !=	null)
					model.setThcAmt( thcAmt[i]);
				if ( amsAmt[i] !=	null)
					model.setAmsAmt( amsAmt[i]);
				if ( bkfAmt[i] !=	null)
					model.setBkfAmt( bkfAmt[i]);
				if ( cdcAmt[i] !=	null)
					model.setCdcAmt( cdcAmt[i]);
				if ( cddAmt[i] !=	null)
					model.setCddAmt( cddAmt[i]);
				if ( ctpAmt[i] !=	null)
					model.setCtpAmt( ctpAmt[i]);
				if ( cyrAmt[i] !=	null)
					model.setCyrAmt( cyrAmt[i]);
				if ( docAmt[i] !=	null)
					model.setDocAmt( docAmt[i]);
				if ( empAmt[i] !=	null)
					model.setEmpAmt( empAmt[i]);
				if ( esdAmt[i] !=	null)
					model.setEsdAmt( esdAmt[i]);
				if ( psfAmt[i] !=	null)
					model.setPsfAmt( psfAmt[i]);
				if ( slfAmt[i] !=	null)
					model.setSlfAmt( slfAmt[i]);
				if ( tslAmt[i] !=	null)
					model.setTslAmt( tslAmt[i]);
				if ( xdoAmt[i] !=	null)
					model.setXdoAmt( xdoAmt[i]);
				if ( ahaAmt[i] !=	null)
					model.setAhaAmt( ahaAmt[i]);
				if ( almAmt[i] !=	null)
					model.setAlmAmt( almAmt[i]);
				if ( amaAmt[i] !=	null)
					model.setAmaAmt( amaAmt[i]);
				if ( ardAmt[i] !=	null)
					model.setArdAmt( ardAmt[i]);
				if ( badAmt[i] !=	null)
					model.setBadAmt( badAmt[i]);
				if ( cccAmt[i] !=	null)
					model.setCccAmt( cccAmt[i]);
				if ( cfdAmt[i] !=	null)
					model.setCfdAmt( cfdAmt[i]);
				if ( cmcAmt[i] !=	null)
					model.setCmcAmt( cmcAmt[i]);
				if ( csvAmt[i] !=	null)
					model.setCsvAmt( csvAmt[i]);
				if ( dofAmt[i] !=	null)
					model.setDofAmt( dofAmt[i]);
				if ( drpAmt[i] !=	null)
					model.setDrpAmt( drpAmt[i]);
				if ( ediAmt[i] !=	null)
					model.setEdiAmt( ediAmt[i]);
				if ( ehdAmt[i] !=	null)
					model.setEhdAmt( ehdAmt[i]);
				if ( hafAmt[i] !=	null)
					model.setHafAmt( hafAmt[i]);
				if ( hauAmt[i] !=	null)
					model.setHauAmt( hauAmt[i]);
				if ( ifiAmt[i] !=	null)
					model.setIfiAmt( ifiAmt[i]);
				if ( insAmt[i] !=	null)
					model.setInsAmt( insAmt[i]);
				if ( kcsAmt[i] !=	null)
					model.setKcsAmt( kcsAmt[i]);
				if ( lloAmt[i] !=	null)
					model.setLloAmt( lloAmt[i]);
				if ( mplAmt[i] !=	null)
					model.setMplAmt( mplAmt[i]);
				if ( pscAmt[i] !=	null)
					model.setPscAmt( pscAmt[i]);
				if ( rhaAmt[i] !=	null)
					model.setRhaAmt( rhaAmt[i]);
				if ( rlsAmt[i] !=	null)
					model.setRlsAmt( rlsAmt[i]);
				if ( rpcAmt[i] !=	null)
					model.setRpcAmt( rpcAmt[i]);
				if ( tsdAmt[i] !=	null)
					model.setTsdAmt( tsdAmt[i]);
				if ( whaAmt[i] !=	null)
					model.setWhaAmt( whaAmt[i]);
				if ( xddAmt[i] !=	null)
					model.setXddAmt( xddAmt[i]);
				if ( xdeAmt[i] !=	null)
					model.setXdeAmt( xdeAmt[i]);
				if ( xerAmt[i] !=	null)
					model.setXerAmt( xerAmt[i]);
				if ( xwfAmt[i] !=	null)
					model.setXwfAmt( xwfAmt[i]);
				if ( ecaAmt[i] !=	null)
					model.setEcaAmt( ecaAmt[i]);
				if ( wtrAmt[i] !=	null)
					model.setWtrAmt( wtrAmt[i]);
				if ( crsAmt[i] !=	null)
					model.setCrsAmt( crsAmt[i]);
				if ( neoAmt[i] !=	null)
					model.setNeoAmt( neoAmt[i]);
				if ( ocrAmt[i] !=	null)
					model.setOcrAmt( ocrAmt[i]);
				if ( effDt[i] !=	null)
					model.setEffDt( effDt[i]);
				if ( expDt[i] !=	null)
					model.setExpDt( expDt[i]);
				if ( remark[i] !=	null)
					model.setRemark( remark[i]);
				if ( tBucAmt[i] !=	null)
					model.setTBucAmt( tBucAmt[i]);
				if ( tBafAmt[i] !=	null)
					model.setTBafAmt( tBafAmt[i]);
				if ( tCsrAmt[i] !=	null)
					model.setTCsrAmt( tCsrAmt[i]);
				if ( tCmsAmt[i] !=	null)
					model.setTCmsAmt( tCmsAmt[i]);
				if ( tOthAmt[i] !=	null)
					model.setTOthAmt( tOthAmt[i]);
				if ( tDhfAmt[i] !=	null)
					model.setTDhfAmt( tDhfAmt[i]);
				if ( tFafAmt[i] !=	null)
					model.setTFafAmt( tFafAmt[i]);
				if ( tFrcAmt[i] !=	null)
					model.setTFrcAmt( tFrcAmt[i]);
				if ( tTscAmt[i] !=	null)
					model.setTTscAmt( tTscAmt[i]);
				if ( tPscAmt[i] !=	null)
					model.setTPscAmt( tPscAmt[i]);
				if ( tEnsAmt[i] !=	null)
					model.setTEnsAmt( tEnsAmt[i]);
				if ( tStfAmt[i] !=	null)
					model.setTStfAmt( tStfAmt[i]);
				if ( tDdcAmt[i] !=	null)
					model.setTDdcAmt( tDdcAmt[i]);
				if ( tSzcAmt[i] !=	null)
					model.setTSzcAmt( tSzcAmt[i]);
				if ( tCucAmt[i] !=	null)
					model.setTCucAmt( tCucAmt[i]);
				if ( tDthAmt[i] !=	null)
					model.setTDthAmt( tDthAmt[i]);
				if ( tHrsAmt[i] !=	null)
					model.setTHrsAmt( tHrsAmt[i]);
				if ( tApsAmt[i] !=	null)
					model.setTApsAmt( tApsAmt[i]);
				if ( tFrbAmt[i] !=	null)
					model.setTFrbAmt( tFrbAmt[i]);
				if ( tOtsAmt[i] !=	null)
					model.setTOtsAmt( tOtsAmt[i]);
				if ( tCfrAmt[i] !=	null)
					model.setTCfrAmt( tCfrAmt[i]);
				if ( tOihAmt[i] !=	null)
					model.setTOihAmt( tOihAmt[i]);
				if ( tTacAmt[i] !=	null)
					model.setTTacAmt( tTacAmt[i]);
				if ( tActAmt[i] !=	null)
					model.setTActAmt( tActAmt[i]);
				if ( tWscAmt[i] !=	null)
					model.setTWscAmt( tWscAmt[i]);
				if ( agsCurrCd[i] !=	null)
					model.setAgsCurrCd( agsCurrCd[i]);
				if ( cgdCurrCd[i] !=	null)
					model.setCgdCurrCd( cgdCurrCd[i]);
				if ( cglCurrCd[i] !=	null)
					model.setCglCurrCd( cglCurrCd[i]);
				if ( cssCurrCd[i] !=	null)
					model.setCssCurrCd( cssCurrCd[i]);
				if ( ebsCurrCd[i] !=	null)
					model.setEbsCurrCd( ebsCurrCd[i]);
				if ( eisCurrCd[i] !=	null)
					model.setEisCurrCd( eisCurrCd[i]);
				if ( emsCurrCd[i] !=	null)
					model.setEmsCurrCd( emsCurrCd[i]);
				if ( eriCurrCd[i] !=	null)
					model.setEriCurrCd( eriCurrCd[i]);
				if ( fafCurrCd[i] !=	null)
					model.setFafCurrCd( fafCurrCd[i]);
				if ( lsfCurrCd[i] !=	null)
					model.setLsfCurrCd( lsfCurrCd[i]);
				if ( pssCurrCd[i] !=	null)
					model.setPssCurrCd( pssCurrCd[i]);
				if ( sctCurrCd[i] !=	null)
					model.setSctCurrCd( sctCurrCd[i]);
				if ( codCurrCd[i] !=	null)
					model.setCodCurrCd( codCurrCd[i]);
				if ( dgsCurrCd[i] !=	null)
					model.setDgsCurrCd( dgsCurrCd[i]);
				if ( gh2CurrCd[i] !=	null)
					model.setGh2CurrCd( gh2CurrCd[i]);
				if ( gohCurrCd[i] !=	null)
					model.setGohCurrCd( gohCurrCd[i]);
				if ( hazCurrCd[i] !=	null)
					model.setHazCurrCd( hazCurrCd[i]);
				if ( heaCurrCd[i] !=	null)
					model.setHeaCurrCd( heaCurrCd[i]);
				if ( sesCurrCd[i] !=	null)
					model.setSesCurrCd( sesCurrCd[i]);
				if ( ecaCurrCd[i] !=	null)
					model.setEcaCurrCd( ecaCurrCd[i]);
				if ( wtrCurrCd[i] !=	null)
					model.setWtrCurrCd( wtrCurrCd[i]);
				if ( agsUsdLoclXchRt[i] !=	null)
					model.setAgsUsdLoclXchRt( agsUsdLoclXchRt[i]);
				if ( cgdUsdLoclXchRt[i] !=	null)
					model.setCgdUsdLoclXchRt( cgdUsdLoclXchRt[i]);
				if ( cglUsdLoclXchRt[i] !=	null)
					model.setCglUsdLoclXchRt( cglUsdLoclXchRt[i]);
				if ( cssUsdLoclXchRt[i] !=	null)
					model.setCssUsdLoclXchRt( cssUsdLoclXchRt[i]);
				if ( ebsUsdLoclXchRt[i] !=	null)
					model.setEbsUsdLoclXchRt( ebsUsdLoclXchRt[i]);
				if ( eisUsdLoclXchRt[i] !=	null)
					model.setEisUsdLoclXchRt( eisUsdLoclXchRt[i]);
				if ( emsUsdLoclXchRt[i] !=	null)
					model.setEmsUsdLoclXchRt( emsUsdLoclXchRt[i]);
				if ( eriUsdLoclXchRt[i] !=	null)
					model.setEriUsdLoclXchRt( eriUsdLoclXchRt[i]);
				if ( fafUsdLoclXchRt[i] !=	null)
					model.setFafUsdLoclXchRt( fafUsdLoclXchRt[i]);
				if ( lsfUsdLoclXchRt[i] !=	null)
					model.setLsfUsdLoclXchRt( lsfUsdLoclXchRt[i]);
				if ( pssUsdLoclXchRt[i] !=	null)
					model.setPssUsdLoclXchRt( pssUsdLoclXchRt[i]);
				if ( sctUsdLoclXchRt[i] !=	null)
					model.setSctUsdLoclXchRt( sctUsdLoclXchRt[i]);
				if ( codUsdLoclXchRt[i] !=	null)
					model.setCodUsdLoclXchRt( codUsdLoclXchRt[i]);
				if ( dgsUsdLoclXchRt[i] !=	null)
					model.setDgsUsdLoclXchRt( dgsUsdLoclXchRt[i]);
				if ( gh2UsdLoclXchRt[i] !=	null)
					model.setGh2UsdLoclXchRt( gh2UsdLoclXchRt[i]);
				if ( gohUsdLoclXchRt[i] !=	null)
					model.setGohUsdLoclXchRt( gohUsdLoclXchRt[i]);
				if ( hazUsdLoclXchRt[i] !=	null)
					model.setHazUsdLoclXchRt( hazUsdLoclXchRt[i]);
				if ( heaUsdLoclXchRt[i] !=	null)
					model.setHeaUsdLoclXchRt( heaUsdLoclXchRt[i]);
				if ( sesUsdLoclXchRt[i] !=	null)
					model.setSesUsdLoclXchRt( sesUsdLoclXchRt[i]);
				if ( ecaUsdLoclXchRt[i] !=	null)
					model.setEcaUsdLoclXchRt( ecaUsdLoclXchRt[i]);
				if ( wtrUsdLoclXchRt[i] !=	null)
					model.setWtrUsdLoclXchRt( wtrUsdLoclXchRt[i]);
				if ( bucCurrCd[i] !=	null)
					model.setBucCurrCd( bucCurrCd[i]);
				if ( csrCurrCd[i] !=	null)
					model.setCsrCurrCd( csrCurrCd[i]);
				if ( cmsCurrCd[i] !=	null)
					model.setCmsCurrCd( cmsCurrCd[i]);
				if ( othCurrCd[i] !=	null)
					model.setOthCurrCd( othCurrCd[i]);
				if ( dhfCurrCd[i] !=	null)
					model.setDhfCurrCd( dhfCurrCd[i]);
				if ( frcCurrCd[i] !=	null)
					model.setFrcCurrCd( frcCurrCd[i]);
				if ( tscCurrCd[i] !=	null)
					model.setTscCurrCd( tscCurrCd[i]);
				if ( ensCurrCd[i] !=	null)
					model.setEnsCurrCd( ensCurrCd[i]);
				if ( stfCurrCd[i] !=	null)
					model.setStfCurrCd( stfCurrCd[i]);
				if ( ddcCurrCd[i] !=	null)
					model.setDdcCurrCd( ddcCurrCd[i]);
				if ( szcCurrCd[i] !=	null)
					model.setSzcCurrCd( szcCurrCd[i]);
				if ( cucCurrCd[i] !=	null)
					model.setCucCurrCd( cucCurrCd[i]);
				if ( dthCurrCd[i] !=	null)
					model.setDthCurrCd( dthCurrCd[i]);
				if ( hrsCurrCd[i] !=	null)
					model.setHrsCurrCd( hrsCurrCd[i]);
				if ( apsCurrCd[i] !=	null)
					model.setApsCurrCd( apsCurrCd[i]);
				if ( frbCurrCd[i] !=	null)
					model.setFrbCurrCd( frbCurrCd[i]);
				if ( otsCurrCd[i] !=	null)
					model.setOtsCurrCd( otsCurrCd[i]);
				if ( cfrCurrCd[i] !=	null)
					model.setCfrCurrCd( cfrCurrCd[i]);
				if ( oihCurrCd[i] !=	null)
					model.setOihCurrCd( oihCurrCd[i]);
				if ( tacCurrCd[i] !=	null)
					model.setTacCurrCd( tacCurrCd[i]);
				if ( actCurrCd[i] !=	null)
					model.setActCurrCd( actCurrCd[i]);
				if ( wscCurrCd[i] !=	null)
					model.setWscCurrCd( wscCurrCd[i]);
				if ( bucUsdLoclXchRt[i] !=	null)
					model.setBucUsdLoclXchRt( bucUsdLoclXchRt[i]);
				if ( csrUsdLoclXchRt[i] !=	null)
					model.setCsrUsdLoclXchRt( csrUsdLoclXchRt[i]);
				if ( cmsUsdLoclXchRt[i] !=	null)
					model.setCmsUsdLoclXchRt( cmsUsdLoclXchRt[i]);
				if ( othUsdLoclXchRt[i] !=	null)
					model.setOthUsdLoclXchRt( othUsdLoclXchRt[i]);
				if ( dhfUsdLoclXchRt[i] !=	null)
					model.setDhfUsdLoclXchRt( dhfUsdLoclXchRt[i]);
				if ( frcUsdLoclXchRt[i] !=	null)
					model.setFrcUsdLoclXchRt( frcUsdLoclXchRt[i]);
				if ( tscUsdLoclXchRt[i] !=	null)
					model.setTscUsdLoclXchRt( tscUsdLoclXchRt[i]);
				if ( ensUsdLoclXchRt[i] !=	null)
					model.setEnsUsdLoclXchRt( ensUsdLoclXchRt[i]);
				if ( stfUsdLoclXchRt[i] !=	null)
					model.setStfUsdLoclXchRt( stfUsdLoclXchRt[i]);
				if ( ddcUsdLoclXchRt[i] !=	null)
					model.setDdcUsdLoclXchRt( ddcUsdLoclXchRt[i]);
				if ( szcUsdLoclXchRt[i] !=	null)
					model.setSzcUsdLoclXchRt( szcUsdLoclXchRt[i]);
				if ( cucUsdLoclXchRt[i] !=	null)
					model.setCucUsdLoclXchRt( cucUsdLoclXchRt[i]);
				if ( dthUsdLoclXchRt[i] !=	null)
					model.setDthUsdLoclXchRt( dthUsdLoclXchRt[i]);
				if ( hrsUsdLoclXchRt[i] !=	null)
					model.setHrsUsdLoclXchRt( hrsUsdLoclXchRt[i]);
				if ( apsUsdLoclXchRt[i] !=	null)
					model.setApsUsdLoclXchRt( apsUsdLoclXchRt[i]);
				if ( frbUsdLoclXchRt[i] !=	null)
					model.setFrbUsdLoclXchRt( frbUsdLoclXchRt[i]);
				if ( otsUsdLoclXchRt[i] !=	null)
					model.setOtsUsdLoclXchRt( otsUsdLoclXchRt[i]);
				if ( cfrUsdLoclXchRt[i] !=	null)
					model.setCfrUsdLoclXchRt( cfrUsdLoclXchRt[i]);
				if ( oihUsdLoclXchRt[i] !=	null)
					model.setOihUsdLoclXchRt( oihUsdLoclXchRt[i]);
				if ( tacUsdLoclXchRt[i] !=	null)
					model.setTacUsdLoclXchRt( tacUsdLoclXchRt[i]);
				if ( actUsdLoclXchRt[i] !=	null)
					model.setActUsdLoclXchRt( actUsdLoclXchRt[i]);
				if ( wscUsdLoclXchRt[i] !=	null)
					model.setWscUsdLoclXchRt( wscUsdLoclXchRt[i]);
				models.add(model);
			}

		} catch	(Exception e) {
			return null;
		}
		return getRsltSearchMOTSSEFilingListVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return RsltSearchMOTSSEFilingListVO[]
	 */
	public RsltSearchMOTSSEFilingListVO[]	 getRsltSearchMOTSSEFilingListVOs(){
		RsltSearchMOTSSEFilingListVO[] vos = (RsltSearchMOTSSEFilingListVO[])models.toArray(new	RsltSearchMOTSSEFilingListVO[models.size()]);
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
	public void	unDataFormat(){
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.testExecDt =	this.testExecDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.execDt =	this.execDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd =	this.svcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fOrgCd =	this.fOrgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toFileDt =	this.toFileDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frFileDt =	this.frFileDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileDt =	this.fileDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inqTpCd =	this.inqTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.motTrfSeq =	this.motTrfSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtSeq =	this.rtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batExeDt =	this.batExeDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq =	this.seq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSrcTpCd =	this.bkgSrcTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo =	this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.carrier =	this.carrier.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtNo =	this.ctrtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtHldNm =	this.ctrtHldNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgShprNm =	this.bkgShprNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCneeNm =	this.bkgCneeNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foreTraComp =	this.foreTraComp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.operAgt =	this.operAgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane =	this.lane.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wayPort =	this.wayPort.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd =	this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deptTsitPort =	this.deptTsitPort.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destTsitPort =	this.destTsitPort.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd =	this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transTerm =	this.transTerm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTp =	this.cntrTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtTp =	this.cmdtTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSz =	this.cntrSz.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVol1 =	this.cntrVol1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVol2 =	this.cntrVol2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oftRt =	this.oftRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blnk1 =	this.blnk1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bafAmt =	this.bafAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cafAmt =	this.cafAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agsAmt =	this.agsAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgdAmt =	this.cgdAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cglAmt =	this.cglAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cssAmt =	this.cssAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ebsAmt =	this.ebsAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eisAmt =	this.eisAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emsAmt =	this.emsAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eriAmt =	this.eriAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fafAmt =	this.fafAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lsfAmt =	this.lsfAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pssAmt =	this.pssAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sctAmt =	this.sctAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codAmt =	this.codAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgsAmt =	this.dgsAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gh2Amt =	this.gh2Amt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gohAmt =	this.gohAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hazAmt =	this.hazAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.heaAmt =	this.heaAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sesAmt =	this.sesAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.thcAmt =	this.thcAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amsAmt =	this.amsAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkfAmt =	this.bkfAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cdcAmt =	this.cdcAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cddAmt =	this.cddAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctpAmt =	this.ctpAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cyrAmt =	this.cyrAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docAmt =	this.docAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.empAmt =	this.empAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.esdAmt =	this.esdAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psfAmt =	this.psfAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slfAmt =	this.slfAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tslAmt =	this.tslAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xdoAmt =	this.xdoAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ahaAmt =	this.ahaAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.almAmt =	this.almAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amaAmt =	this.amaAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ardAmt =	this.ardAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.badAmt =	this.badAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cccAmt =	this.cccAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfdAmt =	this.cfdAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmcAmt =	this.cmcAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csvAmt =	this.csvAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dofAmt =	this.dofAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drpAmt =	this.drpAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediAmt =	this.ediAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ehdAmt =	this.ehdAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hafAmt =	this.hafAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hauAmt =	this.hauAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifiAmt =	this.ifiAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insAmt =	this.insAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kcsAmt =	this.kcsAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lloAmt =	this.lloAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mplAmt =	this.mplAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pscAmt =	this.pscAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhaAmt =	this.rhaAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlsAmt =	this.rlsAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rpcAmt =	this.rpcAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsdAmt =	this.tsdAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whaAmt =	this.whaAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xddAmt =	this.xddAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xdeAmt =	this.xdeAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xerAmt =	this.xerAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xwfAmt =	this.xwfAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ecaAmt =	this.ecaAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wtrAmt =	this.wtrAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crsAmt =	this.crsAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.neoAmt =	this.neoAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ocrAmt =	this.ocrAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt =	this.effDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt =	this.expDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark =	this.remark.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tBucAmt =	this.tBucAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tBafAmt =	this.tBafAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tCsrAmt =	this.tCsrAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tCmsAmt =	this.tCmsAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tOthAmt =	this.tOthAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tDhfAmt =	this.tDhfAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tFafAmt =	this.tFafAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tFrcAmt =	this.tFrcAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tTscAmt =	this.tTscAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tPscAmt =	this.tPscAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tEnsAmt =	this.tEnsAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tStfAmt =	this.tStfAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tDdcAmt =	this.tDdcAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tSzcAmt =	this.tSzcAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tCucAmt =	this.tCucAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tDthAmt =	this.tDthAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tHrsAmt =	this.tHrsAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tApsAmt =	this.tApsAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tFrbAmt =	this.tFrbAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tOtsAmt =	this.tOtsAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tCfrAmt =	this.tCfrAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tOihAmt =	this.tOihAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tTacAmt =	this.tTacAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tActAmt =	this.tActAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tWscAmt =	this.tWscAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agsCurrCd =	this.agsCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgdCurrCd =	this.cgdCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cglCurrCd =	this.cglCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cssCurrCd =	this.cssCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ebsCurrCd =	this.ebsCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eisCurrCd =	this.eisCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emsCurrCd =	this.emsCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eriCurrCd =	this.eriCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fafCurrCd =	this.fafCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lsfCurrCd =	this.lsfCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pssCurrCd =	this.pssCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sctCurrCd =	this.sctCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codCurrCd =	this.codCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgsCurrCd =	this.dgsCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gh2CurrCd =	this.gh2CurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gohCurrCd =	this.gohCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hazCurrCd =	this.hazCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.heaCurrCd =	this.heaCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sesCurrCd =	this.sesCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ecaCurrCd =	this.ecaCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wtrCurrCd =	this.wtrCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agsUsdLoclXchRt =	this.agsUsdLoclXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgdUsdLoclXchRt =	this.cgdUsdLoclXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cglUsdLoclXchRt =	this.cglUsdLoclXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cssUsdLoclXchRt =	this.cssUsdLoclXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ebsUsdLoclXchRt =	this.ebsUsdLoclXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eisUsdLoclXchRt =	this.eisUsdLoclXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emsUsdLoclXchRt =	this.emsUsdLoclXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eriUsdLoclXchRt =	this.eriUsdLoclXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fafUsdLoclXchRt =	this.fafUsdLoclXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lsfUsdLoclXchRt =	this.lsfUsdLoclXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pssUsdLoclXchRt =	this.pssUsdLoclXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sctUsdLoclXchRt =	this.sctUsdLoclXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codUsdLoclXchRt =	this.codUsdLoclXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgsUsdLoclXchRt =	this.dgsUsdLoclXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gh2UsdLoclXchRt =	this.gh2UsdLoclXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gohUsdLoclXchRt =	this.gohUsdLoclXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hazUsdLoclXchRt =	this.hazUsdLoclXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.heaUsdLoclXchRt =	this.heaUsdLoclXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sesUsdLoclXchRt =	this.sesUsdLoclXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ecaUsdLoclXchRt =	this.ecaUsdLoclXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wtrUsdLoclXchRt =	this.wtrUsdLoclXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bucCurrCd =	this.bucCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrCurrCd =	this.csrCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmsCurrCd =	this.cmsCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.othCurrCd =	this.othCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dhfCurrCd =	this.dhfCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frcCurrCd =	this.frcCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tscCurrCd =	this.tscCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ensCurrCd =	this.ensCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stfCurrCd =	this.stfCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ddcCurrCd =	this.ddcCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.szcCurrCd =	this.szcCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cucCurrCd =	this.cucCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dthCurrCd =	this.dthCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hrsCurrCd =	this.hrsCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apsCurrCd =	this.apsCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frbCurrCd =	this.frbCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsCurrCd =	this.otsCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfrCurrCd =	this.cfrCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oihCurrCd =	this.oihCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tacCurrCd =	this.tacCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCurrCd =	this.actCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wscCurrCd =	this.wscCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bucUsdLoclXchRt =	this.bucUsdLoclXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrUsdLoclXchRt =	this.csrUsdLoclXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmsUsdLoclXchRt =	this.cmsUsdLoclXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.othUsdLoclXchRt =	this.othUsdLoclXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dhfUsdLoclXchRt =	this.dhfUsdLoclXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frcUsdLoclXchRt =	this.frcUsdLoclXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tscUsdLoclXchRt =	this.tscUsdLoclXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ensUsdLoclXchRt =	this.ensUsdLoclXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stfUsdLoclXchRt =	this.stfUsdLoclXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ddcUsdLoclXchRt =	this.ddcUsdLoclXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.szcUsdLoclXchRt =	this.szcUsdLoclXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cucUsdLoclXchRt =	this.cucUsdLoclXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dthUsdLoclXchRt =	this.dthUsdLoclXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hrsUsdLoclXchRt =	this.hrsUsdLoclXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apsUsdLoclXchRt =	this.apsUsdLoclXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frbUsdLoclXchRt =	this.frbUsdLoclXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsUsdLoclXchRt =	this.otsUsdLoclXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfrUsdLoclXchRt =	this.cfrUsdLoclXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oihUsdLoclXchRt =	this.oihUsdLoclXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tacUsdLoclXchRt =	this.tacUsdLoclXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actUsdLoclXchRt =	this.actUsdLoclXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wscUsdLoclXchRt =	this.wscUsdLoclXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
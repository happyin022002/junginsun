/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AusBkgAndLocalDgListDetailVO.java
*@FileTitle : AusBkgAndLocalDgListDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.21
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.21  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AusBkgAndLocalDgListDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AusBkgAndLocalDgListDetailVO> models = new ArrayList<AusBkgAndLocalDgListDetailVO>();
	
	/* Column Info */
	private String svcRqstNo = null;
	/* Column Info */
	private String imdgUnNoSeq = null;
	/* Column Info */
	private String outImdgPckQty1 = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String imdgCompGrpCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String dType = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String fdrVvdId = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Column Info */
	private String inImdgPckCd1 = null;
	/* Column Info */
	private String packages = null;
	/* Column Info */
	private String netWgt = null;
	/* Column Info */
	private String dgShortNm = null;
	/* Column Info */
	private String cntrCnt = null;
	/* Column Info */
	private String agent = null;
	/* Column Info */
	private String cntrCgoSeq = null;
	/* Column Info */
	private String fwrdNm = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String netExploWgt = null;
	/* Column Info */
	private String hzdDesc = null;
	/* Column Info */
	private String imdgClssCd = null;
	/* Column Info */
	private String outImdgPckCd1 = null;
	/* Column Info */
	private String grsWgt = null;
	/* Column Info */
	private String rn = null;
	/* Column Info */
	private String fdrVslNm = null;
	/* Column Info */
	private String imdgPckGrpCd = null;
	/* Column Info */
	private String flshPntCdoTemp = null;
	/* Column Info */
	private String sendType = null;
	/* Column Info */
	private String emsNo = null;
	/* Column Info */
	private String inPckDesc = null;
	/* Column Info */
	private String dg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fwrdId1 = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String scrFileNo = null;
	/* Column Info */
	private String dcgoMrnPolutCd = null;
	/* Column Info */
	private String dgCntrSeq = null;
	/* Column Info */
	private String dgShortNmCnt = null;
	/* Column Info */
	private String groupCnt = null;
	/* Column Info */
	private String dgListLocalYn = null;
	/* Column Info */
	private String fdrVslLloydNo = null;
	/* Column Info */
	private String firstMsgSndNo = null;
	/* Column Info */
	private String cType = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String inImdgPckQty1 = null;
	/* Column Info */
	private String outPckDesc = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String imdgSubsRskLblCd2 = null;
	/* Column Info */
	private String imdgSubsRskLblCd1 = null;
	/* Column Info */
	private String mergeBlNo = null;
	/* Column Info */
	private String prpShpNm = null;
	/* Column Info */
	private String msgSndNo = null;
	/* Column Info */
	private String imdgSubsRskLblCd4 = null;
	/* Column Info */
	private String fwrdId = null;
	/* Column Info */
	private String crrDt = null;
	/* Column Info */
	private String imdgLmtQtyFlg = null;
	/* Column Info */
	private String imdgSubsRskLblCd3 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AusBkgAndLocalDgListDetailVO() {}

	public AusBkgAndLocalDgListDetailVO(String ibflag, String pagerows, String seq, String cntrCnt, String mergeBlNo, String blNo, String bkgNo, String polCd, String podCd, String cntrNo, String cntrCgoSeq, String cntrTpszCd, String imdgClssCd, String imdgUnNo, String imdgUnNoSeq, String imdgCompGrpCd, String dgCntrSeq, String dgShortNm, String dgShortNmCnt, String flshPntCdoTemp, String agent, String fwrdId1, String cType, String svcRqstNo, String imdgPckGrpCd, String inImdgPckQty1, String inImdgPckCd1, String inPckDesc, String outImdgPckQty1, String outImdgPckCd1, String outPckDesc, String emsNo, String netWgt, String grsWgt, String packages, String prpShpNm, String hzdDesc, String fwrdId, String fwrdNm, String dcgoMrnPolutCd, String imdgLmtQtyFlg, String fdrVslNm, String fdrVslLloydNo, String fdrVvdId, String crrDt, String imdgSubsRskLblCd1, String imdgSubsRskLblCd2, String imdgSubsRskLblCd3, String imdgSubsRskLblCd4, String sendType, String scrFileNo, String msgSndNo, String firstMsgSndNo, String groupCnt, String netExploWgt, String dgListLocalYn, String dType, String vvdCd, String portCd, String creUsrId, String updUsrId, String rn, String dg) {
		this.svcRqstNo = svcRqstNo;
		this.imdgUnNoSeq = imdgUnNoSeq;
		this.outImdgPckQty1 = outImdgPckQty1;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.imdgCompGrpCd = imdgCompGrpCd;
		this.polCd = polCd;
		this.vvdCd = vvdCd;
		this.dType = dType;
		this.cntrTpszCd = cntrTpszCd;
		this.fdrVvdId = fdrVvdId;
		this.updUsrId = updUsrId;
		this.imdgUnNo = imdgUnNo;
		this.inImdgPckCd1 = inImdgPckCd1;
		this.packages = packages;
		this.netWgt = netWgt;
		this.dgShortNm = dgShortNm;
		this.cntrCnt = cntrCnt;
		this.agent = agent;
		this.cntrCgoSeq = cntrCgoSeq;
		this.fwrdNm = fwrdNm;
		this.podCd = podCd;
		this.creUsrId = creUsrId;
		this.bkgNo = bkgNo;
		this.netExploWgt = netExploWgt;
		this.hzdDesc = hzdDesc;
		this.imdgClssCd = imdgClssCd;
		this.outImdgPckCd1 = outImdgPckCd1;
		this.grsWgt = grsWgt;
		this.rn = rn;
		this.fdrVslNm = fdrVslNm;
		this.imdgPckGrpCd = imdgPckGrpCd;
		this.flshPntCdoTemp = flshPntCdoTemp;
		this.sendType = sendType;
		this.emsNo = emsNo;
		this.inPckDesc = inPckDesc;
		this.dg = dg;
		this.ibflag = ibflag;
		this.fwrdId1 = fwrdId1;
		this.portCd = portCd;
		this.scrFileNo = scrFileNo;
		this.dcgoMrnPolutCd = dcgoMrnPolutCd;
		this.dgCntrSeq = dgCntrSeq;
		this.dgShortNmCnt = dgShortNmCnt;
		this.groupCnt = groupCnt;
		this.dgListLocalYn = dgListLocalYn;
		this.fdrVslLloydNo = fdrVslLloydNo;
		this.firstMsgSndNo = firstMsgSndNo;
		this.cType = cType;
		this.cntrNo = cntrNo;
		this.inImdgPckQty1 = inImdgPckQty1;
		this.outPckDesc = outPckDesc;
		this.seq = seq;
		this.imdgSubsRskLblCd2 = imdgSubsRskLblCd2;
		this.imdgSubsRskLblCd1 = imdgSubsRskLblCd1;
		this.mergeBlNo = mergeBlNo;
		this.prpShpNm = prpShpNm;
		this.msgSndNo = msgSndNo;
		this.imdgSubsRskLblCd4 = imdgSubsRskLblCd4;
		this.fwrdId = fwrdId;
		this.crrDt = crrDt;
		this.imdgLmtQtyFlg = imdgLmtQtyFlg;
		this.imdgSubsRskLblCd3 = imdgSubsRskLblCd3;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("svc_rqst_no", getSvcRqstNo());
		this.hashColumns.put("imdg_un_no_seq", getImdgUnNoSeq());
		this.hashColumns.put("out_imdg_pck_qty1", getOutImdgPckQty1());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("imdg_comp_grp_cd", getImdgCompGrpCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("d_type", getDType());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("fdr_vvd_id", getFdrVvdId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("in_imdg_pck_cd1", getInImdgPckCd1());
		this.hashColumns.put("packages", getPackages());
		this.hashColumns.put("net_wgt", getNetWgt());
		this.hashColumns.put("dg_short_nm", getDgShortNm());
		this.hashColumns.put("cntr_cnt", getCntrCnt());
		this.hashColumns.put("agent", getAgent());
		this.hashColumns.put("cntr_cgo_seq", getCntrCgoSeq());
		this.hashColumns.put("fwrd_nm", getFwrdNm());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("net_explo_wgt", getNetExploWgt());
		this.hashColumns.put("hzd_desc", getHzdDesc());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		this.hashColumns.put("out_imdg_pck_cd1", getOutImdgPckCd1());
		this.hashColumns.put("grs_wgt", getGrsWgt());
		this.hashColumns.put("rn", getRn());
		this.hashColumns.put("fdr_vsl_nm", getFdrVslNm());
		this.hashColumns.put("imdg_pck_grp_cd", getImdgPckGrpCd());
		this.hashColumns.put("flsh_pnt_cdo_temp", getFlshPntCdoTemp());
		this.hashColumns.put("send_type", getSendType());
		this.hashColumns.put("ems_no", getEmsNo());
		this.hashColumns.put("in_pck_desc", getInPckDesc());
		this.hashColumns.put("dg", getDg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fwrd_id1", getFwrdId1());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("scr_file_no", getScrFileNo());
		this.hashColumns.put("dcgo_mrn_polut_cd", getDcgoMrnPolutCd());
		this.hashColumns.put("dg_cntr_seq", getDgCntrSeq());
		this.hashColumns.put("dg_short_nm_cnt", getDgShortNmCnt());
		this.hashColumns.put("group_cnt", getGroupCnt());
		this.hashColumns.put("dg_list_local_yn", getDgListLocalYn());
		this.hashColumns.put("fdr_vsl_lloyd_no", getFdrVslLloydNo());
		this.hashColumns.put("first_msg_snd_no", getFirstMsgSndNo());
		this.hashColumns.put("c_type", getCType());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("in_imdg_pck_qty1", getInImdgPckQty1());
		this.hashColumns.put("out_pck_desc", getOutPckDesc());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("imdg_subs_rsk_lbl_cd2", getImdgSubsRskLblCd2());
		this.hashColumns.put("imdg_subs_rsk_lbl_cd1", getImdgSubsRskLblCd1());
		this.hashColumns.put("merge_bl_no", getMergeBlNo());
		this.hashColumns.put("prp_shp_nm", getPrpShpNm());
		this.hashColumns.put("msg_snd_no", getMsgSndNo());
		this.hashColumns.put("imdg_subs_rsk_lbl_cd4", getImdgSubsRskLblCd4());
		this.hashColumns.put("fwrd_id", getFwrdId());
		this.hashColumns.put("crr_dt", getCrrDt());
		this.hashColumns.put("imdg_lmt_qty_flg", getImdgLmtQtyFlg());
		this.hashColumns.put("imdg_subs_rsk_lbl_cd3", getImdgSubsRskLblCd3());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("svc_rqst_no", "svcRqstNo");
		this.hashFields.put("imdg_un_no_seq", "imdgUnNoSeq");
		this.hashFields.put("out_imdg_pck_qty1", "outImdgPckQty1");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("imdg_comp_grp_cd", "imdgCompGrpCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("d_type", "dType");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("fdr_vvd_id", "fdrVvdId");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("in_imdg_pck_cd1", "inImdgPckCd1");
		this.hashFields.put("packages", "packages");
		this.hashFields.put("net_wgt", "netWgt");
		this.hashFields.put("dg_short_nm", "dgShortNm");
		this.hashFields.put("cntr_cnt", "cntrCnt");
		this.hashFields.put("agent", "agent");
		this.hashFields.put("cntr_cgo_seq", "cntrCgoSeq");
		this.hashFields.put("fwrd_nm", "fwrdNm");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("net_explo_wgt", "netExploWgt");
		this.hashFields.put("hzd_desc", "hzdDesc");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("out_imdg_pck_cd1", "outImdgPckCd1");
		this.hashFields.put("grs_wgt", "grsWgt");
		this.hashFields.put("rn", "rn");
		this.hashFields.put("fdr_vsl_nm", "fdrVslNm");
		this.hashFields.put("imdg_pck_grp_cd", "imdgPckGrpCd");
		this.hashFields.put("flsh_pnt_cdo_temp", "flshPntCdoTemp");
		this.hashFields.put("send_type", "sendType");
		this.hashFields.put("ems_no", "emsNo");
		this.hashFields.put("in_pck_desc", "inPckDesc");
		this.hashFields.put("dg", "dg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fwrd_id1", "fwrdId1");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("scr_file_no", "scrFileNo");
		this.hashFields.put("dcgo_mrn_polut_cd", "dcgoMrnPolutCd");
		this.hashFields.put("dg_cntr_seq", "dgCntrSeq");
		this.hashFields.put("dg_short_nm_cnt", "dgShortNmCnt");
		this.hashFields.put("group_cnt", "groupCnt");
		this.hashFields.put("dg_list_local_yn", "dgListLocalYn");
		this.hashFields.put("fdr_vsl_lloyd_no", "fdrVslLloydNo");
		this.hashFields.put("first_msg_snd_no", "firstMsgSndNo");
		this.hashFields.put("c_type", "cType");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("in_imdg_pck_qty1", "inImdgPckQty1");
		this.hashFields.put("out_pck_desc", "outPckDesc");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("imdg_subs_rsk_lbl_cd2", "imdgSubsRskLblCd2");
		this.hashFields.put("imdg_subs_rsk_lbl_cd1", "imdgSubsRskLblCd1");
		this.hashFields.put("merge_bl_no", "mergeBlNo");
		this.hashFields.put("prp_shp_nm", "prpShpNm");
		this.hashFields.put("msg_snd_no", "msgSndNo");
		this.hashFields.put("imdg_subs_rsk_lbl_cd4", "imdgSubsRskLblCd4");
		this.hashFields.put("fwrd_id", "fwrdId");
		this.hashFields.put("crr_dt", "crrDt");
		this.hashFields.put("imdg_lmt_qty_flg", "imdgLmtQtyFlg");
		this.hashFields.put("imdg_subs_rsk_lbl_cd3", "imdgSubsRskLblCd3");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return svcRqstNo
	 */
	public String getSvcRqstNo() {
		return this.svcRqstNo;
	}
	
	/**
	 * Column Info
	 * @return imdgUnNoSeq
	 */
	public String getImdgUnNoSeq() {
		return this.imdgUnNoSeq;
	}
	
	/**
	 * Column Info
	 * @return outImdgPckQty1
	 */
	public String getOutImdgPckQty1() {
		return this.outImdgPckQty1;
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
	 * @return imdgCompGrpCd
	 */
	public String getImdgCompGrpCd() {
		return this.imdgCompGrpCd;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return dType
	 */
	public String getDType() {
		return this.dType;
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
	 * @return fdrVvdId
	 */
	public String getFdrVvdId() {
		return this.fdrVvdId;
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
	 * @return imdgUnNo
	 */
	public String getImdgUnNo() {
		return this.imdgUnNo;
	}
	
	/**
	 * Column Info
	 * @return inImdgPckCd1
	 */
	public String getInImdgPckCd1() {
		return this.inImdgPckCd1;
	}
	
	/**
	 * Column Info
	 * @return packages
	 */
	public String getPackages() {
		return this.packages;
	}
	
	/**
	 * Column Info
	 * @return netWgt
	 */
	public String getNetWgt() {
		return this.netWgt;
	}
	
	/**
	 * Column Info
	 * @return dgShortNm
	 */
	public String getDgShortNm() {
		return this.dgShortNm;
	}
	
	/**
	 * Column Info
	 * @return cntrCnt
	 */
	public String getCntrCnt() {
		return this.cntrCnt;
	}
	
	/**
	 * Column Info
	 * @return agent
	 */
	public String getAgent() {
		return this.agent;
	}
	
	/**
	 * Column Info
	 * @return cntrCgoSeq
	 */
	public String getCntrCgoSeq() {
		return this.cntrCgoSeq;
	}
	
	/**
	 * Column Info
	 * @return fwrdNm
	 */
	public String getFwrdNm() {
		return this.fwrdNm;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return netExploWgt
	 */
	public String getNetExploWgt() {
		return this.netExploWgt;
	}
	
	/**
	 * Column Info
	 * @return hzdDesc
	 */
	public String getHzdDesc() {
		return this.hzdDesc;
	}
	
	/**
	 * Column Info
	 * @return imdgClssCd
	 */
	public String getImdgClssCd() {
		return this.imdgClssCd;
	}
	
	/**
	 * Column Info
	 * @return outImdgPckCd1
	 */
	public String getOutImdgPckCd1() {
		return this.outImdgPckCd1;
	}
	
	/**
	 * Column Info
	 * @return grsWgt
	 */
	public String getGrsWgt() {
		return this.grsWgt;
	}
	
	/**
	 * Column Info
	 * @return rn
	 */
	public String getRn() {
		return this.rn;
	}
	
	/**
	 * Column Info
	 * @return fdrVslNm
	 */
	public String getFdrVslNm() {
		return this.fdrVslNm;
	}
	
	/**
	 * Column Info
	 * @return imdgPckGrpCd
	 */
	public String getImdgPckGrpCd() {
		return this.imdgPckGrpCd;
	}
	
	/**
	 * Column Info
	 * @return flshPntCdoTemp
	 */
	public String getFlshPntCdoTemp() {
		return this.flshPntCdoTemp;
	}
	
	/**
	 * Column Info
	 * @return sendType
	 */
	public String getSendType() {
		return this.sendType;
	}
	
	/**
	 * Column Info
	 * @return emsNo
	 */
	public String getEmsNo() {
		return this.emsNo;
	}
	
	/**
	 * Column Info
	 * @return inPckDesc
	 */
	public String getInPckDesc() {
		return this.inPckDesc;
	}
	
	/**
	 * Column Info
	 * @return dg
	 */
	public String getDg() {
		return this.dg;
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
	 * @return fwrdId1
	 */
	public String getFwrdId1() {
		return this.fwrdId1;
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
	 * @return scrFileNo
	 */
	public String getScrFileNo() {
		return this.scrFileNo;
	}
	
	/**
	 * Column Info
	 * @return dcgoMrnPolutCd
	 */
	public String getDcgoMrnPolutCd() {
		return this.dcgoMrnPolutCd;
	}
	
	/**
	 * Column Info
	 * @return dgCntrSeq
	 */
	public String getDgCntrSeq() {
		return this.dgCntrSeq;
	}
	
	/**
	 * Column Info
	 * @return dgShortNmCnt
	 */
	public String getDgShortNmCnt() {
		return this.dgShortNmCnt;
	}
	
	/**
	 * Column Info
	 * @return groupCnt
	 */
	public String getGroupCnt() {
		return this.groupCnt;
	}
	
	/**
	 * Column Info
	 * @return dgListLocalYn
	 */
	public String getDgListLocalYn() {
		return this.dgListLocalYn;
	}
	
	/**
	 * Column Info
	 * @return fdrVslLloydNo
	 */
	public String getFdrVslLloydNo() {
		return this.fdrVslLloydNo;
	}
	
	/**
	 * Column Info
	 * @return firstMsgSndNo
	 */
	public String getFirstMsgSndNo() {
		return this.firstMsgSndNo;
	}
	
	/**
	 * Column Info
	 * @return cType
	 */
	public String getCType() {
		return this.cType;
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
	 * @return inImdgPckQty1
	 */
	public String getInImdgPckQty1() {
		return this.inImdgPckQty1;
	}
	
	/**
	 * Column Info
	 * @return outPckDesc
	 */
	public String getOutPckDesc() {
		return this.outPckDesc;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return imdgSubsRskLblCd2
	 */
	public String getImdgSubsRskLblCd2() {
		return this.imdgSubsRskLblCd2;
	}
	
	/**
	 * Column Info
	 * @return imdgSubsRskLblCd1
	 */
	public String getImdgSubsRskLblCd1() {
		return this.imdgSubsRskLblCd1;
	}
	
	/**
	 * Column Info
	 * @return mergeBlNo
	 */
	public String getMergeBlNo() {
		return this.mergeBlNo;
	}
	
	/**
	 * Column Info
	 * @return prpShpNm
	 */
	public String getPrpShpNm() {
		return this.prpShpNm;
	}
	
	/**
	 * Column Info
	 * @return msgSndNo
	 */
	public String getMsgSndNo() {
		return this.msgSndNo;
	}
	
	/**
	 * Column Info
	 * @return imdgSubsRskLblCd4
	 */
	public String getImdgSubsRskLblCd4() {
		return this.imdgSubsRskLblCd4;
	}
	
	/**
	 * Column Info
	 * @return fwrdId
	 */
	public String getFwrdId() {
		return this.fwrdId;
	}
	
	/**
	 * Column Info
	 * @return crrDt
	 */
	public String getCrrDt() {
		return this.crrDt;
	}
	
	/**
	 * Column Info
	 * @return imdgLmtQtyFlg
	 */
	public String getImdgLmtQtyFlg() {
		return this.imdgLmtQtyFlg;
	}
	
	/**
	 * Column Info
	 * @return imdgSubsRskLblCd3
	 */
	public String getImdgSubsRskLblCd3() {
		return this.imdgSubsRskLblCd3;
	}
	

	/**
	 * Column Info
	 * @param svcRqstNo
	 */
	public void setSvcRqstNo(String svcRqstNo) {
		this.svcRqstNo = svcRqstNo;
	}
	
	/**
	 * Column Info
	 * @param imdgUnNoSeq
	 */
	public void setImdgUnNoSeq(String imdgUnNoSeq) {
		this.imdgUnNoSeq = imdgUnNoSeq;
	}
	
	/**
	 * Column Info
	 * @param outImdgPckQty1
	 */
	public void setOutImdgPckQty1(String outImdgPckQty1) {
		this.outImdgPckQty1 = outImdgPckQty1;
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
	 * @param imdgCompGrpCd
	 */
	public void setImdgCompGrpCd(String imdgCompGrpCd) {
		this.imdgCompGrpCd = imdgCompGrpCd;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param dType
	 */
	public void setDType(String dType) {
		this.dType = dType;
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
	 * @param fdrVvdId
	 */
	public void setFdrVvdId(String fdrVvdId) {
		this.fdrVvdId = fdrVvdId;
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
	 * @param imdgUnNo
	 */
	public void setImdgUnNo(String imdgUnNo) {
		this.imdgUnNo = imdgUnNo;
	}
	
	/**
	 * Column Info
	 * @param inImdgPckCd1
	 */
	public void setInImdgPckCd1(String inImdgPckCd1) {
		this.inImdgPckCd1 = inImdgPckCd1;
	}
	
	/**
	 * Column Info
	 * @param packages
	 */
	public void setPackages(String packages) {
		this.packages = packages;
	}
	
	/**
	 * Column Info
	 * @param netWgt
	 */
	public void setNetWgt(String netWgt) {
		this.netWgt = netWgt;
	}
	
	/**
	 * Column Info
	 * @param dgShortNm
	 */
	public void setDgShortNm(String dgShortNm) {
		this.dgShortNm = dgShortNm;
	}
	
	/**
	 * Column Info
	 * @param cntrCnt
	 */
	public void setCntrCnt(String cntrCnt) {
		this.cntrCnt = cntrCnt;
	}
	
	/**
	 * Column Info
	 * @param agent
	 */
	public void setAgent(String agent) {
		this.agent = agent;
	}
	
	/**
	 * Column Info
	 * @param cntrCgoSeq
	 */
	public void setCntrCgoSeq(String cntrCgoSeq) {
		this.cntrCgoSeq = cntrCgoSeq;
	}
	
	/**
	 * Column Info
	 * @param fwrdNm
	 */
	public void setFwrdNm(String fwrdNm) {
		this.fwrdNm = fwrdNm;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param netExploWgt
	 */
	public void setNetExploWgt(String netExploWgt) {
		this.netExploWgt = netExploWgt;
	}
	
	/**
	 * Column Info
	 * @param hzdDesc
	 */
	public void setHzdDesc(String hzdDesc) {
		this.hzdDesc = hzdDesc;
	}
	
	/**
	 * Column Info
	 * @param imdgClssCd
	 */
	public void setImdgClssCd(String imdgClssCd) {
		this.imdgClssCd = imdgClssCd;
	}
	
	/**
	 * Column Info
	 * @param outImdgPckCd1
	 */
	public void setOutImdgPckCd1(String outImdgPckCd1) {
		this.outImdgPckCd1 = outImdgPckCd1;
	}
	
	/**
	 * Column Info
	 * @param grsWgt
	 */
	public void setGrsWgt(String grsWgt) {
		this.grsWgt = grsWgt;
	}
	
	/**
	 * Column Info
	 * @param rn
	 */
	public void setRn(String rn) {
		this.rn = rn;
	}
	
	/**
	 * Column Info
	 * @param fdrVslNm
	 */
	public void setFdrVslNm(String fdrVslNm) {
		this.fdrVslNm = fdrVslNm;
	}
	
	/**
	 * Column Info
	 * @param imdgPckGrpCd
	 */
	public void setImdgPckGrpCd(String imdgPckGrpCd) {
		this.imdgPckGrpCd = imdgPckGrpCd;
	}
	
	/**
	 * Column Info
	 * @param flshPntCdoTemp
	 */
	public void setFlshPntCdoTemp(String flshPntCdoTemp) {
		this.flshPntCdoTemp = flshPntCdoTemp;
	}
	
	/**
	 * Column Info
	 * @param sendType
	 */
	public void setSendType(String sendType) {
		this.sendType = sendType;
	}
	
	/**
	 * Column Info
	 * @param emsNo
	 */
	public void setEmsNo(String emsNo) {
		this.emsNo = emsNo;
	}
	
	/**
	 * Column Info
	 * @param inPckDesc
	 */
	public void setInPckDesc(String inPckDesc) {
		this.inPckDesc = inPckDesc;
	}
	
	/**
	 * Column Info
	 * @param dg
	 */
	public void setDg(String dg) {
		this.dg = dg;
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
	 * @param fwrdId1
	 */
	public void setFwrdId1(String fwrdId1) {
		this.fwrdId1 = fwrdId1;
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
	 * @param scrFileNo
	 */
	public void setScrFileNo(String scrFileNo) {
		this.scrFileNo = scrFileNo;
	}
	
	/**
	 * Column Info
	 * @param dcgoMrnPolutCd
	 */
	public void setDcgoMrnPolutCd(String dcgoMrnPolutCd) {
		this.dcgoMrnPolutCd = dcgoMrnPolutCd;
	}
	
	/**
	 * Column Info
	 * @param dgCntrSeq
	 */
	public void setDgCntrSeq(String dgCntrSeq) {
		this.dgCntrSeq = dgCntrSeq;
	}
	
	/**
	 * Column Info
	 * @param dgShortNmCnt
	 */
	public void setDgShortNmCnt(String dgShortNmCnt) {
		this.dgShortNmCnt = dgShortNmCnt;
	}
	
	/**
	 * Column Info
	 * @param groupCnt
	 */
	public void setGroupCnt(String groupCnt) {
		this.groupCnt = groupCnt;
	}
	
	/**
	 * Column Info
	 * @param dgListLocalYn
	 */
	public void setDgListLocalYn(String dgListLocalYn) {
		this.dgListLocalYn = dgListLocalYn;
	}
	
	/**
	 * Column Info
	 * @param fdrVslLloydNo
	 */
	public void setFdrVslLloydNo(String fdrVslLloydNo) {
		this.fdrVslLloydNo = fdrVslLloydNo;
	}
	
	/**
	 * Column Info
	 * @param firstMsgSndNo
	 */
	public void setFirstMsgSndNo(String firstMsgSndNo) {
		this.firstMsgSndNo = firstMsgSndNo;
	}
	
	/**
	 * Column Info
	 * @param cType
	 */
	public void setCType(String cType) {
		this.cType = cType;
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
	 * @param inImdgPckQty1
	 */
	public void setInImdgPckQty1(String inImdgPckQty1) {
		this.inImdgPckQty1 = inImdgPckQty1;
	}
	
	/**
	 * Column Info
	 * @param outPckDesc
	 */
	public void setOutPckDesc(String outPckDesc) {
		this.outPckDesc = outPckDesc;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param imdgSubsRskLblCd2
	 */
	public void setImdgSubsRskLblCd2(String imdgSubsRskLblCd2) {
		this.imdgSubsRskLblCd2 = imdgSubsRskLblCd2;
	}
	
	/**
	 * Column Info
	 * @param imdgSubsRskLblCd1
	 */
	public void setImdgSubsRskLblCd1(String imdgSubsRskLblCd1) {
		this.imdgSubsRskLblCd1 = imdgSubsRskLblCd1;
	}
	
	/**
	 * Column Info
	 * @param mergeBlNo
	 */
	public void setMergeBlNo(String mergeBlNo) {
		this.mergeBlNo = mergeBlNo;
	}
	
	/**
	 * Column Info
	 * @param prpShpNm
	 */
	public void setPrpShpNm(String prpShpNm) {
		this.prpShpNm = prpShpNm;
	}
	
	/**
	 * Column Info
	 * @param msgSndNo
	 */
	public void setMsgSndNo(String msgSndNo) {
		this.msgSndNo = msgSndNo;
	}
	
	/**
	 * Column Info
	 * @param imdgSubsRskLblCd4
	 */
	public void setImdgSubsRskLblCd4(String imdgSubsRskLblCd4) {
		this.imdgSubsRskLblCd4 = imdgSubsRskLblCd4;
	}
	
	/**
	 * Column Info
	 * @param fwrdId
	 */
	public void setFwrdId(String fwrdId) {
		this.fwrdId = fwrdId;
	}
	
	/**
	 * Column Info
	 * @param crrDt
	 */
	public void setCrrDt(String crrDt) {
		this.crrDt = crrDt;
	}
	
	/**
	 * Column Info
	 * @param imdgLmtQtyFlg
	 */
	public void setImdgLmtQtyFlg(String imdgLmtQtyFlg) {
		this.imdgLmtQtyFlg = imdgLmtQtyFlg;
	}
	
	/**
	 * Column Info
	 * @param imdgSubsRskLblCd3
	 */
	public void setImdgSubsRskLblCd3(String imdgSubsRskLblCd3) {
		this.imdgSubsRskLblCd3 = imdgSubsRskLblCd3;
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
		setSvcRqstNo(JSPUtil.getParameter(request, prefix + "svc_rqst_no", ""));
		setImdgUnNoSeq(JSPUtil.getParameter(request, prefix + "imdg_un_no_seq", ""));
		setOutImdgPckQty1(JSPUtil.getParameter(request, prefix + "out_imdg_pck_qty1", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setImdgCompGrpCd(JSPUtil.getParameter(request, prefix + "imdg_comp_grp_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setDType(JSPUtil.getParameter(request, prefix + "d_type", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setFdrVvdId(JSPUtil.getParameter(request, prefix + "fdr_vvd_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setImdgUnNo(JSPUtil.getParameter(request, prefix + "imdg_un_no", ""));
		setInImdgPckCd1(JSPUtil.getParameter(request, prefix + "in_imdg_pck_cd1", ""));
		setPackages(JSPUtil.getParameter(request, prefix + "packages", ""));
		setNetWgt(JSPUtil.getParameter(request, prefix + "net_wgt", ""));
		setDgShortNm(JSPUtil.getParameter(request, prefix + "dg_short_nm", ""));
		setCntrCnt(JSPUtil.getParameter(request, prefix + "cntr_cnt", ""));
		setAgent(JSPUtil.getParameter(request, prefix + "agent", ""));
		setCntrCgoSeq(JSPUtil.getParameter(request, prefix + "cntr_cgo_seq", ""));
		setFwrdNm(JSPUtil.getParameter(request, prefix + "fwrd_nm", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setNetExploWgt(JSPUtil.getParameter(request, prefix + "net_explo_wgt", ""));
		setHzdDesc(JSPUtil.getParameter(request, prefix + "hzd_desc", ""));
		setImdgClssCd(JSPUtil.getParameter(request, prefix + "imdg_clss_cd", ""));
		setOutImdgPckCd1(JSPUtil.getParameter(request, prefix + "out_imdg_pck_cd1", ""));
		setGrsWgt(JSPUtil.getParameter(request, prefix + "grs_wgt", ""));
		setRn(JSPUtil.getParameter(request, prefix + "rn", ""));
		setFdrVslNm(JSPUtil.getParameter(request, prefix + "fdr_vsl_nm", ""));
		setImdgPckGrpCd(JSPUtil.getParameter(request, prefix + "imdg_pck_grp_cd", ""));
		setFlshPntCdoTemp(JSPUtil.getParameter(request, prefix + "flsh_pnt_cdo_temp", ""));
		setSendType(JSPUtil.getParameter(request, prefix + "send_type", ""));
		setEmsNo(JSPUtil.getParameter(request, prefix + "ems_no", ""));
		setInPckDesc(JSPUtil.getParameter(request, prefix + "in_pck_desc", ""));
		setDg(JSPUtil.getParameter(request, prefix + "dg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFwrdId1(JSPUtil.getParameter(request, prefix + "fwrd_id1", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setScrFileNo(JSPUtil.getParameter(request, prefix + "scr_file_no", ""));
		setDcgoMrnPolutCd(JSPUtil.getParameter(request, prefix + "dcgo_mrn_polut_cd", ""));
		setDgCntrSeq(JSPUtil.getParameter(request, prefix + "dg_cntr_seq", ""));
		setDgShortNmCnt(JSPUtil.getParameter(request, prefix + "dg_short_nm_cnt", ""));
		setGroupCnt(JSPUtil.getParameter(request, prefix + "group_cnt", ""));
		setDgListLocalYn(JSPUtil.getParameter(request, prefix + "dg_list_local_yn", ""));
		setFdrVslLloydNo(JSPUtil.getParameter(request, prefix + "fdr_vsl_lloyd_no", ""));
		setFirstMsgSndNo(JSPUtil.getParameter(request, prefix + "first_msg_snd_no", ""));
		setCType(JSPUtil.getParameter(request, prefix + "c_type", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setInImdgPckQty1(JSPUtil.getParameter(request, prefix + "in_imdg_pck_qty1", ""));
		setOutPckDesc(JSPUtil.getParameter(request, prefix + "out_pck_desc", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setImdgSubsRskLblCd2(JSPUtil.getParameter(request, prefix + "imdg_subs_rsk_lbl_cd2", ""));
		setImdgSubsRskLblCd1(JSPUtil.getParameter(request, prefix + "imdg_subs_rsk_lbl_cd1", ""));
		setMergeBlNo(JSPUtil.getParameter(request, prefix + "merge_bl_no", ""));
		setPrpShpNm(JSPUtil.getParameter(request, prefix + "prp_shp_nm", ""));
		setMsgSndNo(JSPUtil.getParameter(request, prefix + "msg_snd_no", ""));
		setImdgSubsRskLblCd4(JSPUtil.getParameter(request, prefix + "imdg_subs_rsk_lbl_cd4", ""));
		setFwrdId(JSPUtil.getParameter(request, prefix + "fwrd_id", ""));
		setCrrDt(JSPUtil.getParameter(request, prefix + "crr_dt", ""));
		setImdgLmtQtyFlg(JSPUtil.getParameter(request, prefix + "imdg_lmt_qty_flg", ""));
		setImdgSubsRskLblCd3(JSPUtil.getParameter(request, prefix + "imdg_subs_rsk_lbl_cd3", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AusBkgAndLocalDgListDetailVO[]
	 */
	public AusBkgAndLocalDgListDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AusBkgAndLocalDgListDetailVO[]
	 */
	public AusBkgAndLocalDgListDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AusBkgAndLocalDgListDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] svcRqstNo = (JSPUtil.getParameter(request, prefix	+ "svc_rqst_no", length));
			String[] imdgUnNoSeq = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no_seq", length));
			String[] outImdgPckQty1 = (JSPUtil.getParameter(request, prefix	+ "out_imdg_pck_qty1", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] imdgCompGrpCd = (JSPUtil.getParameter(request, prefix	+ "imdg_comp_grp_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] dType = (JSPUtil.getParameter(request, prefix	+ "d_type", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] fdrVvdId = (JSPUtil.getParameter(request, prefix	+ "fdr_vvd_id", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			String[] inImdgPckCd1 = (JSPUtil.getParameter(request, prefix	+ "in_imdg_pck_cd1", length));
			String[] packages = (JSPUtil.getParameter(request, prefix	+ "packages", length));
			String[] netWgt = (JSPUtil.getParameter(request, prefix	+ "net_wgt", length));
			String[] dgShortNm = (JSPUtil.getParameter(request, prefix	+ "dg_short_nm", length));
			String[] cntrCnt = (JSPUtil.getParameter(request, prefix	+ "cntr_cnt", length));
			String[] agent = (JSPUtil.getParameter(request, prefix	+ "agent", length));
			String[] cntrCgoSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_cgo_seq", length));
			String[] fwrdNm = (JSPUtil.getParameter(request, prefix	+ "fwrd_nm", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] netExploWgt = (JSPUtil.getParameter(request, prefix	+ "net_explo_wgt", length));
			String[] hzdDesc = (JSPUtil.getParameter(request, prefix	+ "hzd_desc", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			String[] outImdgPckCd1 = (JSPUtil.getParameter(request, prefix	+ "out_imdg_pck_cd1", length));
			String[] grsWgt = (JSPUtil.getParameter(request, prefix	+ "grs_wgt", length));
			String[] rn = (JSPUtil.getParameter(request, prefix	+ "rn", length));
			String[] fdrVslNm = (JSPUtil.getParameter(request, prefix	+ "fdr_vsl_nm", length));
			String[] imdgPckGrpCd = (JSPUtil.getParameter(request, prefix	+ "imdg_pck_grp_cd", length));
			String[] flshPntCdoTemp = (JSPUtil.getParameter(request, prefix	+ "flsh_pnt_cdo_temp", length));
			String[] sendType = (JSPUtil.getParameter(request, prefix	+ "send_type", length));
			String[] emsNo = (JSPUtil.getParameter(request, prefix	+ "ems_no", length));
			String[] inPckDesc = (JSPUtil.getParameter(request, prefix	+ "in_pck_desc", length));
			String[] dg = (JSPUtil.getParameter(request, prefix	+ "dg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fwrdId1 = (JSPUtil.getParameter(request, prefix	+ "fwrd_id1", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] scrFileNo = (JSPUtil.getParameter(request, prefix	+ "scr_file_no", length));
			String[] dcgoMrnPolutCd = (JSPUtil.getParameter(request, prefix	+ "dcgo_mrn_polut_cd", length));
			String[] dgCntrSeq = (JSPUtil.getParameter(request, prefix	+ "dg_cntr_seq", length));
			String[] dgShortNmCnt = (JSPUtil.getParameter(request, prefix	+ "dg_short_nm_cnt", length));
			String[] groupCnt = (JSPUtil.getParameter(request, prefix	+ "group_cnt", length));
			String[] dgListLocalYn = (JSPUtil.getParameter(request, prefix	+ "dg_list_local_yn", length));
			String[] fdrVslLloydNo = (JSPUtil.getParameter(request, prefix	+ "fdr_vsl_lloyd_no", length));
			String[] firstMsgSndNo = (JSPUtil.getParameter(request, prefix	+ "first_msg_snd_no", length));
			String[] cType = (JSPUtil.getParameter(request, prefix	+ "c_type", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] inImdgPckQty1 = (JSPUtil.getParameter(request, prefix	+ "in_imdg_pck_qty1", length));
			String[] outPckDesc = (JSPUtil.getParameter(request, prefix	+ "out_pck_desc", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] imdgSubsRskLblCd2 = (JSPUtil.getParameter(request, prefix	+ "imdg_subs_rsk_lbl_cd2", length));
			String[] imdgSubsRskLblCd1 = (JSPUtil.getParameter(request, prefix	+ "imdg_subs_rsk_lbl_cd1", length));
			String[] mergeBlNo = (JSPUtil.getParameter(request, prefix	+ "merge_bl_no", length));
			String[] prpShpNm = (JSPUtil.getParameter(request, prefix	+ "prp_shp_nm", length));
			String[] msgSndNo = (JSPUtil.getParameter(request, prefix	+ "msg_snd_no", length));
			String[] imdgSubsRskLblCd4 = (JSPUtil.getParameter(request, prefix	+ "imdg_subs_rsk_lbl_cd4", length));
			String[] fwrdId = (JSPUtil.getParameter(request, prefix	+ "fwrd_id", length));
			String[] crrDt = (JSPUtil.getParameter(request, prefix	+ "crr_dt", length));
			String[] imdgLmtQtyFlg = (JSPUtil.getParameter(request, prefix	+ "imdg_lmt_qty_flg", length));
			String[] imdgSubsRskLblCd3 = (JSPUtil.getParameter(request, prefix	+ "imdg_subs_rsk_lbl_cd3", length));
			
			for (int i = 0; i < length; i++) {
				model = new AusBkgAndLocalDgListDetailVO();
				if (svcRqstNo[i] != null)
					model.setSvcRqstNo(svcRqstNo[i]);
				if (imdgUnNoSeq[i] != null)
					model.setImdgUnNoSeq(imdgUnNoSeq[i]);
				if (outImdgPckQty1[i] != null)
					model.setOutImdgPckQty1(outImdgPckQty1[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (imdgCompGrpCd[i] != null)
					model.setImdgCompGrpCd(imdgCompGrpCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (dType[i] != null)
					model.setDType(dType[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (fdrVvdId[i] != null)
					model.setFdrVvdId(fdrVvdId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (inImdgPckCd1[i] != null)
					model.setInImdgPckCd1(inImdgPckCd1[i]);
				if (packages[i] != null)
					model.setPackages(packages[i]);
				if (netWgt[i] != null)
					model.setNetWgt(netWgt[i]);
				if (dgShortNm[i] != null)
					model.setDgShortNm(dgShortNm[i]);
				if (cntrCnt[i] != null)
					model.setCntrCnt(cntrCnt[i]);
				if (agent[i] != null)
					model.setAgent(agent[i]);
				if (cntrCgoSeq[i] != null)
					model.setCntrCgoSeq(cntrCgoSeq[i]);
				if (fwrdNm[i] != null)
					model.setFwrdNm(fwrdNm[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (netExploWgt[i] != null)
					model.setNetExploWgt(netExploWgt[i]);
				if (hzdDesc[i] != null)
					model.setHzdDesc(hzdDesc[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				if (outImdgPckCd1[i] != null)
					model.setOutImdgPckCd1(outImdgPckCd1[i]);
				if (grsWgt[i] != null)
					model.setGrsWgt(grsWgt[i]);
				if (rn[i] != null)
					model.setRn(rn[i]);
				if (fdrVslNm[i] != null)
					model.setFdrVslNm(fdrVslNm[i]);
				if (imdgPckGrpCd[i] != null)
					model.setImdgPckGrpCd(imdgPckGrpCd[i]);
				if (flshPntCdoTemp[i] != null)
					model.setFlshPntCdoTemp(flshPntCdoTemp[i]);
				if (sendType[i] != null)
					model.setSendType(sendType[i]);
				if (emsNo[i] != null)
					model.setEmsNo(emsNo[i]);
				if (inPckDesc[i] != null)
					model.setInPckDesc(inPckDesc[i]);
				if (dg[i] != null)
					model.setDg(dg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fwrdId1[i] != null)
					model.setFwrdId1(fwrdId1[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (scrFileNo[i] != null)
					model.setScrFileNo(scrFileNo[i]);
				if (dcgoMrnPolutCd[i] != null)
					model.setDcgoMrnPolutCd(dcgoMrnPolutCd[i]);
				if (dgCntrSeq[i] != null)
					model.setDgCntrSeq(dgCntrSeq[i]);
				if (dgShortNmCnt[i] != null)
					model.setDgShortNmCnt(dgShortNmCnt[i]);
				if (groupCnt[i] != null)
					model.setGroupCnt(groupCnt[i]);
				if (dgListLocalYn[i] != null)
					model.setDgListLocalYn(dgListLocalYn[i]);
				if (fdrVslLloydNo[i] != null)
					model.setFdrVslLloydNo(fdrVslLloydNo[i]);
				if (firstMsgSndNo[i] != null)
					model.setFirstMsgSndNo(firstMsgSndNo[i]);
				if (cType[i] != null)
					model.setCType(cType[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (inImdgPckQty1[i] != null)
					model.setInImdgPckQty1(inImdgPckQty1[i]);
				if (outPckDesc[i] != null)
					model.setOutPckDesc(outPckDesc[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (imdgSubsRskLblCd2[i] != null)
					model.setImdgSubsRskLblCd2(imdgSubsRskLblCd2[i]);
				if (imdgSubsRskLblCd1[i] != null)
					model.setImdgSubsRskLblCd1(imdgSubsRskLblCd1[i]);
				if (mergeBlNo[i] != null)
					model.setMergeBlNo(mergeBlNo[i]);
				if (prpShpNm[i] != null)
					model.setPrpShpNm(prpShpNm[i]);
				if (msgSndNo[i] != null)
					model.setMsgSndNo(msgSndNo[i]);
				if (imdgSubsRskLblCd4[i] != null)
					model.setImdgSubsRskLblCd4(imdgSubsRskLblCd4[i]);
				if (fwrdId[i] != null)
					model.setFwrdId(fwrdId[i]);
				if (crrDt[i] != null)
					model.setCrrDt(crrDt[i]);
				if (imdgLmtQtyFlg[i] != null)
					model.setImdgLmtQtyFlg(imdgLmtQtyFlg[i]);
				if (imdgSubsRskLblCd3[i] != null)
					model.setImdgSubsRskLblCd3(imdgSubsRskLblCd3[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAusBkgAndLocalDgListDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AusBkgAndLocalDgListDetailVO[]
	 */
	public AusBkgAndLocalDgListDetailVO[] getAusBkgAndLocalDgListDetailVOs(){
		AusBkgAndLocalDgListDetailVO[] vos = (AusBkgAndLocalDgListDetailVO[])models.toArray(new AusBkgAndLocalDgListDetailVO[models.size()]);
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
		this.svcRqstNo = this.svcRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNoSeq = this.imdgUnNoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outImdgPckQty1 = this.outImdgPckQty1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgCompGrpCd = this.imdgCompGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dType = this.dType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrVvdId = this.fdrVvdId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inImdgPckCd1 = this.inImdgPckCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.packages = this.packages .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netWgt = this.netWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgShortNm = this.dgShortNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCnt = this.cntrCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agent = this.agent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCgoSeq = this.cntrCgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fwrdNm = this.fwrdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netExploWgt = this.netExploWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hzdDesc = this.hzdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outImdgPckCd1 = this.outImdgPckCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgt = this.grsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rn = this.rn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrVslNm = this.fdrVslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckGrpCd = this.imdgPckGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flshPntCdoTemp = this.flshPntCdoTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sendType = this.sendType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emsNo = this.emsNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPckDesc = this.inPckDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg = this.dg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fwrdId1 = this.fwrdId1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scrFileNo = this.scrFileNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoMrnPolutCd = this.dcgoMrnPolutCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgCntrSeq = this.dgCntrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgShortNmCnt = this.dgShortNmCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.groupCnt = this.groupCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgListLocalYn = this.dgListLocalYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrVslLloydNo = this.fdrVslLloydNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.firstMsgSndNo = this.firstMsgSndNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cType = this.cType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inImdgPckQty1 = this.inImdgPckQty1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outPckDesc = this.outPckDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSubsRskLblCd2 = this.imdgSubsRskLblCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSubsRskLblCd1 = this.imdgSubsRskLblCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mergeBlNo = this.mergeBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prpShpNm = this.prpShpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgSndNo = this.msgSndNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSubsRskLblCd4 = this.imdgSubsRskLblCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fwrdId = this.fwrdId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrDt = this.crrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgLmtQtyFlg = this.imdgLmtQtyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSubsRskLblCd3 = this.imdgSubsRskLblCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

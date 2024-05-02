/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PreRestrictionInputVO.java
*@FileTitle : PreRestrictionInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.20
*@LastModifier : 
*@LastVersion : 1.0
* 2013.03.20  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.ScgPrnrAproRqstCgoVO;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PreRestrictionInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PreRestrictionInputVO> models = new ArrayList<PreRestrictionInputVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String spclCgoSeq = null;
	/* Column Info */
	private String imdgPckGrpCd = null;
	/* Column Info */
	private String outTtlCapaPerUt = null;
	/* Column Info */
	private String polPortCd = null;
	/* Column Info */
	private String imdgUnNoSeq = null;
	/* Column Info */
	private String pass4PortCd = null;
	/* Column Info */
	private String fCmd = null;
	/* Column Info */
	private String dcgoStsCd = null;
	/* Column Info */
	private String outImdgPckQty1 = null;
	/* Column Info */
	private String pckStyCd = null;
	/* Column Info */
	private String crrCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String podPortCd = null;
	/* Column Info */
	private String optClss = null;
	/* Column Info */
	private String inGrsPerUt = null;
	/* Column Info */
	private String startNum = null;
	/* Column Info */
	private String inImdgPckCd1 = null;
	/* Column Info */
	private String intmdImdgPckQty1 = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Column Info */
	private String outGrsPerUt = null;
	/* Column Info */
	private String imdgExptQtyFlg = null;
	/* Column Info */
	private String inTtlCapaPerUt = null;
	/* Column Info */
	private String pass3PortCd = null;
	/* Column Info */
	private String pass1PortCd = null;
	/* Column Info */
	private String outNetPerUt = null;
	/* Column Info */
	private String netWgt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String spclCntrSeq = null;
	/* Column Info */
	private String grsCapaQty = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String intmdImdgPckCd1 = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String inNetPerUt = null;
	/* Column Info */
	private String inImdgPckQty1 = null;
	/* Column Info */
	private String pckDivCd = null;
	/* Column Info */
	private String pass2PortCd = null;
	/* Column Info */
	private String endNum = null;
	/* Column Info */
	private String imdgClssCd = null;
	/* Column Info */
	private String grsWgt = null;
	/* Column Info */
	private String outImdgPckCd1 = null;
	/* Column Info */
	private String imdgLmtQtyFlg = null;
	/*	Column Info	*/
	private  String	 pckChk   =  null;
	 
    /* VO Info */
	private PreRestrictionInputVO innerPreRestrictionInputVO = null;
	/* VO Info */
	private PreRestrictionInputVO[] innerPreRestrictionInputVOs = null;

	/* VO Info */
	private ScgPrnrAproRqstCgoVO innerScgPrnrAproRqstCgoVO = null;
	/* VO Info */
	private ScgPrnrAproRqstCgoVO[] innerScgPrnrAproRqstCgoVOs = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PreRestrictionInputVO() {}

	public PreRestrictionInputVO(String ibflag, String pagerows, String vslCd, String spclCgoSeq, String imdgPckGrpCd, String outNetPerUt, String inNetPerUt, String polPortCd, String pass4PortCd, String imdgUnNoSeq, String fCmd, String dcgoStsCd, String outImdgPckQty1, String crrCd, String polCd, String podPortCd, String optClss, String startNum, String inImdgPckCd1, String intmdImdgPckQty1, String imdgUnNo, String imdgExptQtyFlg, String pass3PortCd, String pass1PortCd, String outTtlCapaPerUt, String inTtlCapaPerUt, String netWgt, String spclCntrSeq, String skdVoyNo, String grsCapaQty, String skdDirCd, String podCd, String intmdImdgPckCd1, String bkgNo, String outGrsPerUt, String inGrsPerUt, String slanCd, String inImdgPckQty1, String pass2PortCd, String endNum, String outImdgPckCd1, String grsWgt, String imdgClssCd, String imdgLmtQtyFlg, String pckDivCd, String pckStyCd ,String pckChk)	{
		this.vslCd = vslCd;
		this.spclCgoSeq = spclCgoSeq;
		this.imdgPckGrpCd = imdgPckGrpCd;
		this.outTtlCapaPerUt = outTtlCapaPerUt;
		this.polPortCd = polPortCd;
		this.imdgUnNoSeq = imdgUnNoSeq;
		this.pass4PortCd = pass4PortCd;
		this.fCmd = fCmd;
		this.dcgoStsCd = dcgoStsCd;
		this.outImdgPckQty1 = outImdgPckQty1;
		this.pckStyCd = pckStyCd;
		this.crrCd = crrCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.podPortCd = podPortCd;
		this.optClss = optClss;
		this.inGrsPerUt = inGrsPerUt;
		this.startNum = startNum;
		this.inImdgPckCd1 = inImdgPckCd1;
		this.intmdImdgPckQty1 = intmdImdgPckQty1;
		this.imdgUnNo = imdgUnNo;
		this.outGrsPerUt = outGrsPerUt;
		this.imdgExptQtyFlg = imdgExptQtyFlg;
		this.inTtlCapaPerUt = inTtlCapaPerUt;
		this.pass3PortCd = pass3PortCd;
		this.pass1PortCd = pass1PortCd;
		this.outNetPerUt = outNetPerUt;
		this.netWgt = netWgt;
		this.skdVoyNo = skdVoyNo;
		this.spclCntrSeq = spclCntrSeq;
		this.grsCapaQty = grsCapaQty;
		this.skdDirCd = skdDirCd;
		this.podCd = podCd;
		this.intmdImdgPckCd1 = intmdImdgPckCd1;
		this.bkgNo = bkgNo;
		this.slanCd = slanCd;
		this.inNetPerUt = inNetPerUt;
		this.inImdgPckQty1 = inImdgPckQty1;
		this.pckDivCd = pckDivCd;
		this.pass2PortCd = pass2PortCd;
		this.endNum = endNum;
		this.imdgClssCd = imdgClssCd;
		this.grsWgt = grsWgt;
		this.outImdgPckCd1 = outImdgPckCd1;
		this.imdgLmtQtyFlg = imdgLmtQtyFlg;
		this.pckChk  = pckChk ;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("spcl_cgo_seq", getSpclCgoSeq());
		this.hashColumns.put("imdg_pck_grp_cd", getImdgPckGrpCd());
		this.hashColumns.put("out_ttl_capa_per_ut", getOutTtlCapaPerUt());
		this.hashColumns.put("pol_port_cd", getPolPortCd());
		this.hashColumns.put("imdg_un_no_seq", getImdgUnNoSeq());
		this.hashColumns.put("pass4_port_cd", getPass4PortCd());
		this.hashColumns.put("f_cmd", getFCmd());
		this.hashColumns.put("dcgo_sts_cd", getDcgoStsCd());
		this.hashColumns.put("out_imdg_pck_qty1", getOutImdgPckQty1());
		this.hashColumns.put("pck_sty_cd", getPckStyCd());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("pod_port_cd", getPodPortCd());
		this.hashColumns.put("opt_clss", getOptClss());
		this.hashColumns.put("in_grs_per_ut", getInGrsPerUt());
		this.hashColumns.put("start_num", getStartNum());
		this.hashColumns.put("in_imdg_pck_cd1", getInImdgPckCd1());
		this.hashColumns.put("intmd_imdg_pck_qty1", getIntmdImdgPckQty1());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("out_grs_per_ut", getOutGrsPerUt());
		this.hashColumns.put("imdg_expt_qty_flg", getImdgExptQtyFlg());
		this.hashColumns.put("in_ttl_capa_per_ut", getInTtlCapaPerUt());
		this.hashColumns.put("pass3_port_cd", getPass3PortCd());
		this.hashColumns.put("pass1_port_cd", getPass1PortCd());
		this.hashColumns.put("out_net_per_ut", getOutNetPerUt());
		this.hashColumns.put("net_wgt", getNetWgt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("spcl_cntr_seq", getSpclCntrSeq());
		this.hashColumns.put("grs_capa_qty", getGrsCapaQty());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("intmd_imdg_pck_cd1", getIntmdImdgPckCd1());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("in_net_per_ut", getInNetPerUt());
		this.hashColumns.put("in_imdg_pck_qty1", getInImdgPckQty1());
		this.hashColumns.put("pck_div_cd", getPckDivCd());
		this.hashColumns.put("pass2_port_cd", getPass2PortCd());
		this.hashColumns.put("end_num", getEndNum());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		this.hashColumns.put("grs_wgt", getGrsWgt());
		this.hashColumns.put("out_imdg_pck_cd1", getOutImdgPckCd1());
		this.hashColumns.put("imdg_lmt_qty_flg", getImdgLmtQtyFlg());
		this.hashColumns.put("pck_chk", getPckChk());	
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("spcl_cgo_seq", "spclCgoSeq");
		this.hashFields.put("imdg_pck_grp_cd", "imdgPckGrpCd");
		this.hashFields.put("out_ttl_capa_per_ut", "outTtlCapaPerUt");
		this.hashFields.put("pol_port_cd", "polPortCd");
		this.hashFields.put("imdg_un_no_seq", "imdgUnNoSeq");
		this.hashFields.put("pass4_port_cd", "pass4PortCd");
		this.hashFields.put("f_cmd", "fCmd");
		this.hashFields.put("dcgo_sts_cd", "dcgoStsCd");
		this.hashFields.put("out_imdg_pck_qty1", "outImdgPckQty1");
		this.hashFields.put("pck_sty_cd", "pckStyCd");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("pod_port_cd", "podPortCd");
		this.hashFields.put("opt_clss", "optClss");
		this.hashFields.put("in_grs_per_ut", "inGrsPerUt");
		this.hashFields.put("start_num", "startNum");
		this.hashFields.put("in_imdg_pck_cd1", "inImdgPckCd1");
		this.hashFields.put("intmd_imdg_pck_qty1", "intmdImdgPckQty1");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("out_grs_per_ut", "outGrsPerUt");
		this.hashFields.put("imdg_expt_qty_flg", "imdgExptQtyFlg");
		this.hashFields.put("in_ttl_capa_per_ut", "inTtlCapaPerUt");
		this.hashFields.put("pass3_port_cd", "pass3PortCd");
		this.hashFields.put("pass1_port_cd", "pass1PortCd");
		this.hashFields.put("out_net_per_ut", "outNetPerUt");
		this.hashFields.put("net_wgt", "netWgt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("spcl_cntr_seq", "spclCntrSeq");
		this.hashFields.put("grs_capa_qty", "grsCapaQty");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("intmd_imdg_pck_cd1", "intmdImdgPckCd1");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("in_net_per_ut", "inNetPerUt");
		this.hashFields.put("in_imdg_pck_qty1", "inImdgPckQty1");
		this.hashFields.put("pck_div_cd", "pckDivCd");
		this.hashFields.put("pass2_port_cd", "pass2PortCd");
		this.hashFields.put("end_num", "endNum");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("grs_wgt", "grsWgt");
		this.hashFields.put("out_imdg_pck_cd1", "outImdgPckCd1");
		this.hashFields.put("imdg_lmt_qty_flg", "imdgLmtQtyFlg");
		this.hashFields.put("pck_chk", "pckChk");
		return this.hashFields;
	}
	
	/**
	 * VO Info
	 * @return innerPreRestrictionInputVOs
	 */
	public PreRestrictionInputVO[] getInnerPreRestrictionInputVOS() {
		return this.innerPreRestrictionInputVOs;
	}
	
	/**
	 * VO Info
	 * @return innerPreRestrictionInputVOs
	 */
	public PreRestrictionInputVO getInnerPreRestrictionInputVO() {
		return this.innerPreRestrictionInputVO;
	}
	
	/**
	 * VO Info
	 * @param innerPreRestrictionInputVO
	 */
	public void setInnerPreRestrictionInputVO(PreRestrictionInputVO innerPreRestrictionInputVO) {
		this.innerPreRestrictionInputVO = innerPreRestrictionInputVO;
	}
	
	/**
	 * VO Info
	 * @param innerPreRestrictionInputVOs
	 */
	public void setInnerPreRestrictionInputVOS(PreRestrictionInputVO[] innerPreRestrictionInputVOs) {
		this.innerPreRestrictionInputVOs = innerPreRestrictionInputVOs;
	}
	
	/**
	 * VO Info
	 * @return innerScgPrnrAproRqstCgoVOs
	 */
	public ScgPrnrAproRqstCgoVO[] getInnerScgPrnrAproRqstCgoVOS() {
		return this.innerScgPrnrAproRqstCgoVOs;
	}
	
	/**
	 * VO Info
	 * @return innerScgPrnrAproRqstCgoVOs
	 */
	public ScgPrnrAproRqstCgoVO getInnerScgPrnrAproRqstCgoVO() {
		return this.innerScgPrnrAproRqstCgoVO;
	}
	
	/**
	 * VO Info
	 * @param innerScgPrnrAproRqstCgoVO
	 */
	public void setInnerScgPrnrAproRqstCgoVO(ScgPrnrAproRqstCgoVO innerScgPrnrAproRqstCgoVO) {
		this.innerScgPrnrAproRqstCgoVO = innerScgPrnrAproRqstCgoVO;
	}
	
	/**
	 * VO Info
	 * @param innerScgPrnrAproRqstCgoVOs
	 */
	public void setInnerScgPrnrAproRqstCgoVOS(ScgPrnrAproRqstCgoVO[] innerScgPrnrAproRqstCgoVOs) {
		this.innerScgPrnrAproRqstCgoVOs = innerScgPrnrAproRqstCgoVOs;
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
	 * @return spclCgoSeq
	 */
	public String getSpclCgoSeq() {
		return this.spclCgoSeq;
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
	 * @return outTtlCapaPerUt
	 */
	public String getOutTtlCapaPerUt() {
		return this.outTtlCapaPerUt;
	}
	
	/**
	 * Column Info
	 * @return polPortCd
	 */
	public String getPolPortCd() {
		return this.polPortCd;
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
	 * @return pass4PortCd
	 */
	public String getPass4PortCd() {
		return this.pass4PortCd;
	}
	
	/**
	 * Column Info
	 * @return fCmd
	 */
	public String getFCmd() {
		return this.fCmd;
	}
	
	/**
	 * Column Info
	 * @return dcgoStsCd
	 */
	public String getDcgoStsCd() {
		return this.dcgoStsCd;
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
	 * @return pckStyCd
	 */
	public String getPckStyCd() {
		return this.pckStyCd;
	}
	
	/**
	 * Column Info
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return podPortCd
	 */
	public String getPodPortCd() {
		return this.podPortCd;
	}
	
	/**
	 * Column Info
	 * @return optClss
	 */
	public String getOptClss() {
		return this.optClss;
	}
	
	/**
	 * Column Info
	 * @return inGrsPerUt
	 */
	public String getInGrsPerUt() {
		return this.inGrsPerUt;
	}
	
	/**
	 * Column Info
	 * @return startNum
	 */
	public String getStartNum() {
		return this.startNum;
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
	 * @return intmdImdgPckQty1
	 */
	public String getIntmdImdgPckQty1() {
		return this.intmdImdgPckQty1;
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
	 * @return outGrsPerUt
	 */
	public String getOutGrsPerUt() {
		return this.outGrsPerUt;
	}
	
	/**
	 * Column Info
	 * @return imdgExptQtyFlg
	 */
	public String getImdgExptQtyFlg() {
		return this.imdgExptQtyFlg;
	}
	
	/**
	 * Column Info
	 * @return inTtlCapaPerUt
	 */
	public String getInTtlCapaPerUt() {
		return this.inTtlCapaPerUt;
	}
	
	/**
	 * Column Info
	 * @return pass3PortCd
	 */
	public String getPass3PortCd() {
		return this.pass3PortCd;
	}
	
	/**
	 * Column Info
	 * @return pass1PortCd
	 */
	public String getPass1PortCd() {
		return this.pass1PortCd;
	}
	
	/**
	 * Column Info
	 * @return outNetPerUt
	 */
	public String getOutNetPerUt() {
		return this.outNetPerUt;
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
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return spclCntrSeq
	 */
	public String getSpclCntrSeq() {
		return this.spclCntrSeq;
	}
	
	/**
	 * Column Info
	 * @return grsCapaQty
	 */
	public String getGrsCapaQty() {
		return this.grsCapaQty;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return intmdImdgPckCd1
	 */
	public String getIntmdImdgPckCd1() {
		return this.intmdImdgPckCd1;
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
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return inNetPerUt
	 */
	public String getInNetPerUt() {
		return this.inNetPerUt;
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
	 * @return pckDivCd
	 */
	public String getPckDivCd() {
		return this.pckDivCd;
	}
	
	/**
	 * Column Info
	 * @return pass2PortCd
	 */
	public String getPass2PortCd() {
		return this.pass2PortCd;
	}
	
	/**
	 * Column Info
	 * @return endNum
	 */
	public String getEndNum() {
		return this.endNum;
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
	 * @return grsWgt
	 */
	public String getGrsWgt() {
		return this.grsWgt;
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
	 * @return imdgLmtQtyFlg
	 */
	public String getImdgLmtQtyFlg() {
		return this.imdgLmtQtyFlg;
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
	 * @param spclCgoSeq
	 */
	public void setSpclCgoSeq(String spclCgoSeq) {
		this.spclCgoSeq = spclCgoSeq;
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
	 * @param outTtlCapaPerUt
	 */
	public void setOutTtlCapaPerUt(String outTtlCapaPerUt) {
		this.outTtlCapaPerUt = outTtlCapaPerUt;
	}
	
	/**
	 * Column Info
	 * @param polPortCd
	 */
	public void setPolPortCd(String polPortCd) {
		this.polPortCd = polPortCd;
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
	 * @param pass4PortCd
	 */
	public void setPass4PortCd(String pass4PortCd) {
		this.pass4PortCd = pass4PortCd;
	}
	
	/**
	 * Column Info
	 * @param fCmd
	 */
	public void setFCmd(String fCmd) {
		this.fCmd = fCmd;
	}
	
	/**
	 * Column Info
	 * @param dcgoStsCd
	 */
	public void setDcgoStsCd(String dcgoStsCd) {
		this.dcgoStsCd = dcgoStsCd;
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
	 * @param pckStyCd
	 */
	public void setPckStyCd(String pckStyCd) {
		this.pckStyCd = pckStyCd;
	}
	
	/**
	 * Column Info
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param podPortCd
	 */
	public void setPodPortCd(String podPortCd) {
		this.podPortCd = podPortCd;
	}
	
	/**
	 * Column Info
	 * @param optClss
	 */
	public void setOptClss(String optClss) {
		this.optClss = optClss;
	}
	
	/**
	 * Column Info
	 * @param inGrsPerUt
	 */
	public void setInGrsPerUt(String inGrsPerUt) {
		this.inGrsPerUt = inGrsPerUt;
	}
	
	/**
	 * Column Info
	 * @param startNum
	 */
	public void setStartNum(String startNum) {
		this.startNum = startNum;
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
	 * @param intmdImdgPckQty1
	 */
	public void setIntmdImdgPckQty1(String intmdImdgPckQty1) {
		this.intmdImdgPckQty1 = intmdImdgPckQty1;
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
	 * @param outGrsPerUt
	 */
	public void setOutGrsPerUt(String outGrsPerUt) {
		this.outGrsPerUt = outGrsPerUt;
	}
	
	/**
	 * Column Info
	 * @param imdgExptQtyFlg
	 */
	public void setImdgExptQtyFlg(String imdgExptQtyFlg) {
		this.imdgExptQtyFlg = imdgExptQtyFlg;
	}
	
	/**
	 * Column Info
	 * @param inTtlCapaPerUt
	 */
	public void setInTtlCapaPerUt(String inTtlCapaPerUt) {
		this.inTtlCapaPerUt = inTtlCapaPerUt;
	}
	
	/**
	 * Column Info
	 * @param pass3PortCd
	 */
	public void setPass3PortCd(String pass3PortCd) {
		this.pass3PortCd = pass3PortCd;
	}
	
	/**
	 * Column Info
	 * @param pass1PortCd
	 */
	public void setPass1PortCd(String pass1PortCd) {
		this.pass1PortCd = pass1PortCd;
	}
	
	/**
	 * Column Info
	 * @param outNetPerUt
	 */
	public void setOutNetPerUt(String outNetPerUt) {
		this.outNetPerUt = outNetPerUt;
	}
	
	/**
	 * Column Info
	 * @param netWgt
	 */
	public void setNetWgt(String netWgt) {
		this.netWgt = netWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
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
	 * @param spclCntrSeq
	 */
	public void setSpclCntrSeq(String spclCntrSeq) {
		this.spclCntrSeq = spclCntrSeq;
	}
	
	/**
	 * Column Info
	 * @param grsCapaQty
	 */
	public void setGrsCapaQty(String grsCapaQty) {
		this.grsCapaQty = grsCapaQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param intmdImdgPckCd1
	 */
	public void setIntmdImdgPckCd1(String intmdImdgPckCd1) {
		this.intmdImdgPckCd1 = intmdImdgPckCd1;
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
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param inNetPerUt
	 */
	public void setInNetPerUt(String inNetPerUt) {
		this.inNetPerUt = inNetPerUt;
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
	 * @param pckDivCd
	 */
	public void setPckDivCd(String pckDivCd) {
		this.pckDivCd = pckDivCd;
	}
	
	/**
	 * Column Info
	 * @param pass2PortCd
	 */
	public void setPass2PortCd(String pass2PortCd) {
		this.pass2PortCd = pass2PortCd;
	}
	
	/**
	 * Column Info
	 * @param endNum
	 */
	public void setEndNum(String endNum) {
		this.endNum = endNum;
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
	 * @param grsWgt
	 */
	public void setGrsWgt(String grsWgt) {
		this.grsWgt = grsWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
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
	 * @param imdgLmtQtyFlg
	 */
	public void setImdgLmtQtyFlg(String imdgLmtQtyFlg) {
		this.imdgLmtQtyFlg = imdgLmtQtyFlg;
	}
	
 	/**
	* Column Info
	* @param  pckChk
	*/
	public void	setPckChk( String	pckChk ) {
		this.pckChk =	pckChk;
	}
 
	/**
	 * Column Info
	 * @return	pckChk
	 */
	 public	String	getPckChk() {
		 return	this.pckChk;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setSpclCgoSeq(JSPUtil.getParameter(request, prefix + "spcl_cgo_seq", ""));
		setImdgPckGrpCd(JSPUtil.getParameter(request, prefix + "imdg_pck_grp_cd", ""));
		setOutTtlCapaPerUt(JSPUtil.getParameter(request, prefix + "out_ttl_capa_per_ut", ""));
		setPolPortCd(JSPUtil.getParameter(request, prefix + "pol_port_cd", ""));
		setImdgUnNoSeq(JSPUtil.getParameter(request, prefix + "imdg_un_no_seq", ""));
		setPass4PortCd(JSPUtil.getParameter(request, prefix + "pass4_port_cd", ""));
		setFCmd(JSPUtil.getParameter(request, prefix + "f_cmd", ""));
		setDcgoStsCd(JSPUtil.getParameter(request, prefix + "dcgo_sts_cd", ""));
		setOutImdgPckQty1(JSPUtil.getParameter(request, prefix + "out_imdg_pck_qty1", ""));
		setPckStyCd(JSPUtil.getParameter(request, prefix + "pck_sty_cd", ""));
		setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setPodPortCd(JSPUtil.getParameter(request, prefix + "pod_port_cd", ""));
		setOptClss(JSPUtil.getParameter(request, prefix + "opt_clss", ""));
		setInGrsPerUt(JSPUtil.getParameter(request, prefix + "in_grs_per_ut", ""));
		setStartNum(JSPUtil.getParameter(request, prefix + "start_num", ""));
		setInImdgPckCd1(JSPUtil.getParameter(request, prefix + "in_imdg_pck_cd1", ""));
		setIntmdImdgPckQty1(JSPUtil.getParameter(request, prefix + "intmd_imdg_pck_qty1", ""));
		setImdgUnNo(JSPUtil.getParameter(request, prefix + "imdg_un_no", ""));
		setOutGrsPerUt(JSPUtil.getParameter(request, prefix + "out_grs_per_ut", ""));
		setImdgExptQtyFlg(JSPUtil.getParameter(request, prefix + "imdg_expt_qty_flg", ""));
		setInTtlCapaPerUt(JSPUtil.getParameter(request, prefix + "in_ttl_capa_per_ut", ""));
		setPass3PortCd(JSPUtil.getParameter(request, prefix + "pass3_port_cd", ""));
		setPass1PortCd(JSPUtil.getParameter(request, prefix + "pass1_port_cd", ""));
		setOutNetPerUt(JSPUtil.getParameter(request, prefix + "out_net_per_ut", ""));
		setNetWgt(JSPUtil.getParameter(request, prefix + "net_wgt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setSpclCntrSeq(JSPUtil.getParameter(request, prefix + "spcl_cntr_seq", ""));
		setGrsCapaQty(JSPUtil.getParameter(request, prefix + "grs_capa_qty", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setIntmdImdgPckCd1(JSPUtil.getParameter(request, prefix + "intmd_imdg_pck_cd1", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setInNetPerUt(JSPUtil.getParameter(request, prefix + "in_net_per_ut", ""));
		setInImdgPckQty1(JSPUtil.getParameter(request, prefix + "in_imdg_pck_qty1", ""));
		setPckDivCd(JSPUtil.getParameter(request, prefix + "pck_div_cd", ""));
		setPass2PortCd(JSPUtil.getParameter(request, prefix + "pass2_port_cd", ""));
		setEndNum(JSPUtil.getParameter(request, prefix + "end_num", ""));
		setImdgClssCd(JSPUtil.getParameter(request, prefix + "imdg_clss_cd", ""));
		setGrsWgt(JSPUtil.getParameter(request, prefix + "grs_wgt", ""));
		setOutImdgPckCd1(JSPUtil.getParameter(request, prefix + "out_imdg_pck_cd1", ""));
		setImdgLmtQtyFlg(JSPUtil.getParameter(request, prefix + "imdg_lmt_qty_flg", ""));
		setPckChk(JSPUtil.getParameter(request,	prefix + "pck_chk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PreRestrictionInputVO[]
	 */
	public PreRestrictionInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PreRestrictionInputVO[]
	 */
	public PreRestrictionInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PreRestrictionInputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] spclCgoSeq = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_seq", length));
			String[] imdgPckGrpCd = (JSPUtil.getParameter(request, prefix	+ "imdg_pck_grp_cd", length));
			String[] outTtlCapaPerUt = (JSPUtil.getParameter(request, prefix	+ "out_ttl_capa_per_ut", length));
			String[] polPortCd = (JSPUtil.getParameter(request, prefix	+ "pol_port_cd", length));
			String[] imdgUnNoSeq = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no_seq", length));
			String[] pass4PortCd = (JSPUtil.getParameter(request, prefix	+ "pass4_port_cd", length));
			String[] fCmd = (JSPUtil.getParameter(request, prefix	+ "f_cmd", length));
			String[] dcgoStsCd = (JSPUtil.getParameter(request, prefix	+ "dcgo_sts_cd", length));
			String[] outImdgPckQty1 = (JSPUtil.getParameter(request, prefix	+ "out_imdg_pck_qty1", length));
			String[] pckStyCd = (JSPUtil.getParameter(request, prefix	+ "pck_sty_cd", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] podPortCd = (JSPUtil.getParameter(request, prefix	+ "pod_port_cd", length));
			String[] optClss = (JSPUtil.getParameter(request, prefix	+ "opt_clss", length));
			String[] inGrsPerUt = (JSPUtil.getParameter(request, prefix	+ "in_grs_per_ut", length));
			String[] startNum = (JSPUtil.getParameter(request, prefix	+ "start_num", length));
			String[] inImdgPckCd1 = (JSPUtil.getParameter(request, prefix	+ "in_imdg_pck_cd1", length));
			String[] intmdImdgPckQty1 = (JSPUtil.getParameter(request, prefix	+ "intmd_imdg_pck_qty1", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			String[] outGrsPerUt = (JSPUtil.getParameter(request, prefix	+ "out_grs_per_ut", length));
			String[] imdgExptQtyFlg = (JSPUtil.getParameter(request, prefix	+ "imdg_expt_qty_flg", length));
			String[] inTtlCapaPerUt = (JSPUtil.getParameter(request, prefix	+ "in_ttl_capa_per_ut", length));
			String[] pass3PortCd = (JSPUtil.getParameter(request, prefix	+ "pass3_port_cd", length));
			String[] pass1PortCd = (JSPUtil.getParameter(request, prefix	+ "pass1_port_cd", length));
			String[] outNetPerUt = (JSPUtil.getParameter(request, prefix	+ "out_net_per_ut", length));
			String[] netWgt = (JSPUtil.getParameter(request, prefix	+ "net_wgt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] spclCntrSeq = (JSPUtil.getParameter(request, prefix	+ "spcl_cntr_seq", length));
			String[] grsCapaQty = (JSPUtil.getParameter(request, prefix	+ "grs_capa_qty", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] intmdImdgPckCd1 = (JSPUtil.getParameter(request, prefix	+ "intmd_imdg_pck_cd1", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] inNetPerUt = (JSPUtil.getParameter(request, prefix	+ "in_net_per_ut", length));
			String[] inImdgPckQty1 = (JSPUtil.getParameter(request, prefix	+ "in_imdg_pck_qty1", length));
			String[] pckDivCd = (JSPUtil.getParameter(request, prefix	+ "pck_div_cd", length));
			String[] pass2PortCd = (JSPUtil.getParameter(request, prefix	+ "pass2_port_cd", length));
			String[] endNum = (JSPUtil.getParameter(request, prefix	+ "end_num", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			String[] grsWgt = (JSPUtil.getParameter(request, prefix	+ "grs_wgt", length));
			String[] outImdgPckCd1 = (JSPUtil.getParameter(request, prefix	+ "out_imdg_pck_cd1", length));
			String[] imdgLmtQtyFlg = (JSPUtil.getParameter(request, prefix	+ "imdg_lmt_qty_flg", length));
			String[] pckChk =	(JSPUtil.getParameter(request, prefix +	"pck_chk".trim(),	length));
			
			for (int i = 0; i < length; i++) {
				model = new PreRestrictionInputVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (spclCgoSeq[i] != null)
					model.setSpclCgoSeq(spclCgoSeq[i]);
				if (imdgPckGrpCd[i] != null)
					model.setImdgPckGrpCd(imdgPckGrpCd[i]);
				if (outTtlCapaPerUt[i] != null)
					model.setOutTtlCapaPerUt(outTtlCapaPerUt[i]);
				if (polPortCd[i] != null)
					model.setPolPortCd(polPortCd[i]);
				if (imdgUnNoSeq[i] != null)
					model.setImdgUnNoSeq(imdgUnNoSeq[i]);
				if (pass4PortCd[i] != null)
					model.setPass4PortCd(pass4PortCd[i]);
				if (fCmd[i] != null)
					model.setFCmd(fCmd[i]);
				if (dcgoStsCd[i] != null)
					model.setDcgoStsCd(dcgoStsCd[i]);
				if (outImdgPckQty1[i] != null)
					model.setOutImdgPckQty1(outImdgPckQty1[i]);
				if (pckStyCd[i] != null)
					model.setPckStyCd(pckStyCd[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (podPortCd[i] != null)
					model.setPodPortCd(podPortCd[i]);
				if (optClss[i] != null)
					model.setOptClss(optClss[i]);
				if (inGrsPerUt[i] != null)
					model.setInGrsPerUt(inGrsPerUt[i]);
				if (startNum[i] != null)
					model.setStartNum(startNum[i]);
				if (inImdgPckCd1[i] != null)
					model.setInImdgPckCd1(inImdgPckCd1[i]);
				if (intmdImdgPckQty1[i] != null)
					model.setIntmdImdgPckQty1(intmdImdgPckQty1[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (outGrsPerUt[i] != null)
					model.setOutGrsPerUt(outGrsPerUt[i]);
				if (imdgExptQtyFlg[i] != null)
					model.setImdgExptQtyFlg(imdgExptQtyFlg[i]);
				if (inTtlCapaPerUt[i] != null)
					model.setInTtlCapaPerUt(inTtlCapaPerUt[i]);
				if (pass3PortCd[i] != null)
					model.setPass3PortCd(pass3PortCd[i]);
				if (pass1PortCd[i] != null)
					model.setPass1PortCd(pass1PortCd[i]);
				if (outNetPerUt[i] != null)
					model.setOutNetPerUt(outNetPerUt[i]);
				if (netWgt[i] != null)
					model.setNetWgt(netWgt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (spclCntrSeq[i] != null)
					model.setSpclCntrSeq(spclCntrSeq[i]);
				if (grsCapaQty[i] != null)
					model.setGrsCapaQty(grsCapaQty[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (intmdImdgPckCd1[i] != null)
					model.setIntmdImdgPckCd1(intmdImdgPckCd1[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (inNetPerUt[i] != null)
					model.setInNetPerUt(inNetPerUt[i]);
				if (inImdgPckQty1[i] != null)
					model.setInImdgPckQty1(inImdgPckQty1[i]);
				if (pckDivCd[i] != null)
					model.setPckDivCd(pckDivCd[i]);
				if (pass2PortCd[i] != null)
					model.setPass2PortCd(pass2PortCd[i]);
				if (endNum[i] != null)
					model.setEndNum(endNum[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				if (grsWgt[i] != null)
					model.setGrsWgt(grsWgt[i]);
				if (outImdgPckCd1[i] != null)
					model.setOutImdgPckCd1(outImdgPckCd1[i]);
				if (imdgLmtQtyFlg[i] != null)
					model.setImdgLmtQtyFlg(imdgLmtQtyFlg[i]);
				if ( pckChk[i] !=	null)
					model.setPckChk( pckChk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPreRestrictionInputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PreRestrictionInputVO[]
	 */
	public PreRestrictionInputVO[] getPreRestrictionInputVOs(){
		PreRestrictionInputVO[] vos = (PreRestrictionInputVO[])models.toArray(new PreRestrictionInputVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoSeq = this.spclCgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckGrpCd = this.imdgPckGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outTtlCapaPerUt = this.outTtlCapaPerUt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polPortCd = this.polPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNoSeq = this.imdgUnNoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pass4PortCd = this.pass4PortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCmd = this.fCmd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoStsCd = this.dcgoStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outImdgPckQty1 = this.outImdgPckQty1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckStyCd = this.pckStyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podPortCd = this.podPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optClss = this.optClss .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inGrsPerUt = this.inGrsPerUt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.startNum = this.startNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inImdgPckCd1 = this.inImdgPckCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intmdImdgPckQty1 = this.intmdImdgPckQty1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outGrsPerUt = this.outGrsPerUt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgExptQtyFlg = this.imdgExptQtyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inTtlCapaPerUt = this.inTtlCapaPerUt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pass3PortCd = this.pass3PortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pass1PortCd = this.pass1PortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outNetPerUt = this.outNetPerUt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netWgt = this.netWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCntrSeq = this.spclCntrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsCapaQty = this.grsCapaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intmdImdgPckCd1 = this.intmdImdgPckCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inNetPerUt = this.inNetPerUt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inImdgPckQty1 = this.inImdgPckQty1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckDivCd = this.pckDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pass2PortCd = this.pass2PortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endNum = this.endNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgt = this.grsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outImdgPckCd1 = this.outImdgPckCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgLmtQtyFlg = this.imdgLmtQtyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckChk =	this.pckChk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

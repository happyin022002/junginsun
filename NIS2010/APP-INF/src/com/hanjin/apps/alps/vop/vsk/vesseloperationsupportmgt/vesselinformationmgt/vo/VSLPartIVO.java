/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VSLPartIVO.java
*@FileTitle : VSLPartIVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.04
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.04  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

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

public class VSLPartIVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VSLPartIVO> models = new ArrayList<VSLPartIVO>();
	
	/* Column Info */
	private String bwthstRpmPwr = null;
	/* Column Info */
	private String mnEngTpDesc = null;
	/* Column Info */ 
	private String vslDpth = null; 
	/* Column Info */ 
	private String n2ndRmnDt = null;
	/* Column Info */
	private String n1stHirRtN2ndAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String n2ndHirRtN2ndAmt = null;
	/* Column Info */
	private String dplCapa = null;
	/* Column Info */
	private String gnrTpDesc = null;
	/* Column Info */
	private String fbdCapa = null;
	/* Column Info */
	private String vslHgt = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String vslLodLineCertiExpDt = null;
	/* Column Info */
	private String vslSftRdoCertiExpDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String rgstDt = null;
	/* Column Info */
	private String vslHldKnt = null;
	/* Column Info */
	private String rgstPortCd = null;
	/* Column Info */
	private String lbpLen = null;
	/* Column Info */
	private String callSgnNo = null;
	/* Column Info */
	private String n2ndHirRtN1stAmt = null;
	/* Column Info */
	private String clssNoRgstAreaNm = null;
	/* Column Info */
	private String grsRgstTongWgt = null;
	/* Column Info */
	private String tlxNo = null;
	/* Column Info */
	private String rfRcptKnt = null;
	/* Column Info */
	private String vslHlNo = null;
	/* Column Info */
	private String lloydNo = null;
	/* Column Info */
	private String suzNetTongWgt = null;
	/* Column Info */
	private String pnmNetTongWgt = null;
	/* Column Info */
	private String rgstNo = null;
	/* Column Info */
	private String n1stEffDt = null;
	/* Column Info */
	private String vslRmk = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String n2ndHirCurrN2ndCd = null;
	/* Column Info */
	private String n1stExpDt = null;
	/* Column Info */
	private String rfRcptMaxKnt = null;
	/* Column Info */
	private String loaLen = null;
	/* Column Info */
	private String vslLnchDt = null;
	/* Column Info */
	private String n2ndExpDt = null;
	/* Column Info */
	private String vslBldrNm = null;
	/* Column Info */
	private String crwKnt = null;
	/* Column Info */
	private String vslCreOfcCd = null;
	/* Column Info */
	private String vslClssCd = null;
	/* Column Info */
	private String vslSftCstruCertiExpDt = null;
	/* Column Info */
	private String blstTnkCapa = null;
	/* Column Info */
	private String vslKrnNm = null;
	/* Column Info */
	private String n1stHirCurrN2ndCd = null;
	/* Column Info */
	private String bwthstMkrNm = null;
	/* Column Info */
	private String pnmGtWgt = null;
	/* Column Info */
	private String vslClzDt = null;
	/* Column Info */
	private String suzGtWgt = null;
	/* Column Info */
	private String madnVoySuzNetTongWgt = null;
	/* Column Info */
	private String lgtShpTongWgt = null;
	/* Column Info */
	private String mnEngKwPwr = null;
	/* Column Info */
	private String foilCapa = null;
	/* Column Info */
	private String vslDeratCertiExpDt = null;
	/* Column Info */
	private String ttlTeuKnt = null;
	/* Column Info */
	private String foilCsm = null;
	/* Column Info */
	private String n2ndVndrNm = null;
	/* Column Info */
	private String doilCsm = null;
	/* Column Info */
	private String vslDeDt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String dwtWgt = null;
	/* Column Info */
	private String mnEngRpmPwr = null;
	/* Column Info */
	private String crrCd = null;
	/* Column Info */
	private String vslSftEqCertiExpDt = null;
	/* Column Info */
	private String n1stRmnDt = null;
	/* Column Info */
	private String doilCapa = null;
	/* Column Info */
	private String n2ndHirCurrN1stCd = null;
	/* Column Info */
	private String vslType = null;
	/* Column Info */
	private String frshWtrCapa = null;
	/* Column Info */
	private String phnNo = null;
	/* Column Info */
	private String n2ndVndrSeq = null;
	/* Column Info */
	private String cntrOpCapa = null;
	/* Column Info */
	private String n1stHirCurrN1stCd = null;
	/* Column Info */
	private String piclbDesc = null;
	/* Column Info */
	private String vslOwnIndCd = null;
	/* Column Info */
	private String frshWtrCsm = null;
	/* Column Info */
	private String cntrDznCapa = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String fdrDivCd = null;
	/* Column Info */
	private String n1stHirRtN1stAmt = null;
	/* Column Info */
	private String faxNo = null;
	/* Column Info */
	private String vslDeltOfcCd = null;
	/* Column Info */
	private String smrDrftHgt = null;
	/* Column Info */
	private String bwthstBhpPwr = null;
	/* Column Info */
	private String vslEdiNm = null;
	/* Column Info */
	private String vslEml = null;
	/* Column Info */
	private String crrFullNm = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String vslBldAreaNm = null;
	/* Column Info */
	private String mnEngMkrNm = null;
	/* Column Info */
	private String vslHtchKnt = null;
	/* Column Info */
	private String gnrBhpPwr = null;
	/* Column Info */
	private String cntNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String maxSpd = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String vslRgstCntCd = null;
	/* Column Info */
	private String cntrPnmCapa = null;
	/* Column Info */
	private String n1stVndrSeq = null;
	/* Column Info */
	private String n1stVndrNm = null;
	/* Column Info */
	private String gnrRpmPwr = null;
	/* Column Info */
	private String vslClssNo = null;
	/* Column Info */
	private String vslLoclNm = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String netRgstTongWgt = null;
	/* Column Info */
	private String coCd = null;
	/* Column Info */
	private String vslBldCd = null;
	/* Column Info */
	private String bwthstTpDesc = null;
	/* Column Info */
	private String n2ndEffDt = null;
	/* Column Info */
	private String ecnSpd = null;
	/* Column Info */
	private String eaiEvntDt = null;
	/* Column Info */
	private String mnEngBhpPwr = null;
	/* Column Info */
	private String vslKelLyDt = null;
	/* Column Info */
	private String cntrVslClssCapa = null;
	/* Column Info */
	private String intlTongCertiFlg = null;
	/* Column Info */
	private String vslWdt = null;
	/* Column Info */
	private String vslSvcSpd = null;
	/* Column Info */
	private String gnrMkrNm = null;
	/* Column Info */
	private String mnEngTrKnt = null;	
	/* Column Info */
	private String gnrTrKnt = null;	
	/* Column Info */
	private String bwthstTrKnt = null;
	/* Column Info */
	private String blkCrrTpCd          = null;
	/* Column Info */
	private String blstWgtSpd1         = null;
	/* Column Info */
	private String ctclRpmNo           = null;
	/* Column Info */
	private String ctclToRpmNo         = null;
	/* Column Info */
	private String foilBlstCsm2        = null;
	/* Column Info */
	private String fuelSavEqFlg        = null;
	/* Column Info */
	private String htchCvrInHldKnt     = null;
	/* Column Info */
	private String inHldPerRowKnt      = null;
	/* Column Info */
	private String inHldPerTrKnt       = null;
	/* Column Info */
	private String ldnWgtSpd1          = null;
	/* Column Info */
	private String onDeckPerRowKnt     = null;
	/* Column Info */
	private String onDeckPerTrKnt      = null;
	/* Column Info */
	private String opMinRpmNo          = null;
	/* Column Info */
	private String opMinSpd            = null;
	/* Column Info */
	private String portFoilTonCsm      = null;
	/* Column Info */
	private String portIdleDoilTonCsm  = null;
	/* Column Info */
	private String portWrkDoilTonCsm   = null;
	/* Column Info */
	private String slwStmngFlg         = null;
	/* Column Info */
	private String sprSlwStmngFlg      = null;
	/* Column Info */
	private String tropDrftHgt         = null;
	/* Column Info */
	private String tropDwtWgt          = null;
	/* Column Info */
	private String vslLodRto           = null;
	/* Column Info */
	private String wntDrftHgt          = null;
	/* Column Info */
	private String wntDwtWgt           = null;
	/* Column Info */
	private String pageNo	           = null;
	/* Column Info */
	private String ampTpCd	           = null;
	
	
	/* VO Info */
	private MdmVslCntrExcelVO[] mdmVslCntrExcelVOs = null;
	private List<MdmVslCntrExcelVO> mdmVslCntrExcelVOl = null;


	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VSLPartIVO() {}

	public VSLPartIVO(String ibflag, String pagerows, String cntrVslClssCapa, String rfRcptKnt, String rfRcptMaxKnt, String fbdCapa, String dplCapa, String blstTnkCapa, String foilCsm, String doilCsm, String frshWtrCsm, String mnEngRpmPwr, String gnrRpmPwr, String vslHgt, String rgstDt, String vslEdiNm, String coCd, String vslClzDt, String vslCreOfcCd, String vslDeltOfcCd, String vslBldAreaNm, String gnrMkrNm, String gnrTpDesc, String gnrBhpPwr, String bwthstMkrNm, String bwthstTpDesc, String bwthstBhpPwr, String bwthstRpmPwr, String lloydNo, String vslLnchDt, String vslDeDt, String vslKelLyDt, String vslHlNo, String ttlTeuKnt, String vslHtchKnt, String vslHldKnt, String vslRmk, String intlTongCertiFlg, String vslSftCstruCertiExpDt, String vslSftRdoCertiExpDt, String vslSftEqCertiExpDt, String vslLodLineCertiExpDt, String vslDeratCertiExpDt, String creUsrId, String creDt, String updUsrId, String updDt, String deltFlg, String eaiEvntDt, String vslCd, String vslClssCd, String vslEngNm, String vslKrnNm, String foilCapa, String doilCapa, String frshWtrCapa, String callSgnNo, String rgstNo, String phnNo, String faxNo, String tlxNo, String vslEml, String piclbDesc, String rgstPortCd, String clssNoRgstAreaNm, String vslClssNo, String vslBldrNm, String loaLen, String lbpLen, String vslWdt, String vslDpth, String smrDrftHgt, String dwtWgt, String lgtShpTongWgt, String grsRgstTongWgt, String netRgstTongWgt, String pnmGtWgt, String pnmNetTongWgt, String suzGtWgt, String suzNetTongWgt, String madnVoySuzNetTongWgt, String mnEngMkrNm, String mnEngTpDesc, String mnEngKwPwr, String mnEngBhpPwr, String vslOwnIndCd, String vslRgstCntCd, String vslBldCd, String crrCd, String fdrDivCd, String vslSvcSpd, String maxSpd, String ecnSpd, String crwKnt, String cntrDznCapa, String cntrOpCapa, String cntrPnmCapa, String crrFullNm, String cntCd, String cntNm, String vslType, String vslLoclNm, String n1stEffDt, String n1stExpDt, String n2ndEffDt, String n2ndExpDt, String n1stRmnDt, String n2ndRmnDt, String n1stVndrSeq, String n1stVndrNm, String n2ndVndrSeq, String n2ndVndrNm, String n1stHirCurrN1stCd, String n1stHirRtN1stAmt, String n1stHirCurrN2ndCd, String n1stHirRtN2ndAmt, String n2ndHirCurrN1stCd, String n2ndHirRtN1stAmt, String n2ndHirCurrN2ndCd, String n2ndHirRtN2ndAmt
			, String mnEngTrKnt, String gnrTrKnt, String bwthstTrKnt, String blkCrrTpCd, String blstWgtSpd1, String ctclRpmNo, String ctclToRpmNo, String foilBlstCsm2, String fuelSavEqFlg, String htchCvrInHldKnt, String inHldPerRowKnt, String inHldPerTrKnt, String ldnWgtSpd1, String onDeckPerRowKnt, String onDeckPerTrKnt, String opMinRpmNo, String opMinSpd, String portFoilTonCsm, String portIdleDoilTonCsm, String portWrkDoilTonCsm, String slwStmngFlg, String sprSlwStmngFlg, String tropDrftHgt, String tropDwtWgt, String vslLodRto, String wntDrftHgt, String wntDwtWgt, String ampTpCd) {
		this.bwthstRpmPwr = bwthstRpmPwr;
		this.mnEngTpDesc = mnEngTpDesc;
		this.vslDpth = vslDpth;
		this.n2ndRmnDt = n2ndRmnDt;
		this.n1stHirRtN2ndAmt = n1stHirRtN2ndAmt;
		this.pagerows = pagerows;
		this.n2ndHirRtN2ndAmt = n2ndHirRtN2ndAmt;
		this.dplCapa = dplCapa;
		this.gnrTpDesc = gnrTpDesc;
		this.fbdCapa = fbdCapa;
		this.vslHgt = vslHgt;
		this.cntCd = cntCd;
		this.vslLodLineCertiExpDt = vslLodLineCertiExpDt;
		this.vslSftRdoCertiExpDt = vslSftRdoCertiExpDt;
		this.updUsrId = updUsrId;
		this.rgstDt = rgstDt;
		this.vslHldKnt = vslHldKnt;
		this.rgstPortCd = rgstPortCd;
		this.lbpLen = lbpLen;
		this.callSgnNo = callSgnNo;
		this.n2ndHirRtN1stAmt = n2ndHirRtN1stAmt;
		this.clssNoRgstAreaNm = clssNoRgstAreaNm;
		this.grsRgstTongWgt = grsRgstTongWgt;
		this.tlxNo = tlxNo;
		this.rfRcptKnt = rfRcptKnt;
		this.vslHlNo = vslHlNo;
		this.lloydNo = lloydNo;
		this.suzNetTongWgt = suzNetTongWgt;
		this.pnmNetTongWgt = pnmNetTongWgt;
		this.rgstNo = rgstNo;
		this.n1stEffDt = n1stEffDt;
		this.vslRmk = vslRmk;
		this.deltFlg = deltFlg;
		this.n2ndHirCurrN2ndCd = n2ndHirCurrN2ndCd;
		this.n1stExpDt = n1stExpDt;
		this.rfRcptMaxKnt = rfRcptMaxKnt;
		this.loaLen = loaLen;
		this.vslLnchDt = vslLnchDt;
		this.n2ndExpDt = n2ndExpDt;
		this.vslBldrNm = vslBldrNm;
		this.crwKnt = crwKnt;
		this.vslCreOfcCd = vslCreOfcCd;
		this.vslClssCd = vslClssCd;
		this.vslSftCstruCertiExpDt = vslSftCstruCertiExpDt;
		this.blstTnkCapa = blstTnkCapa;
		this.vslKrnNm = vslKrnNm;
		this.n1stHirCurrN2ndCd = n1stHirCurrN2ndCd;
		this.bwthstMkrNm = bwthstMkrNm;
		this.pnmGtWgt = pnmGtWgt;
		this.vslClzDt = vslClzDt;
		this.suzGtWgt = suzGtWgt;
		this.madnVoySuzNetTongWgt = madnVoySuzNetTongWgt;
		this.lgtShpTongWgt = lgtShpTongWgt;
		this.mnEngKwPwr = mnEngKwPwr;
		this.foilCapa = foilCapa;
		this.vslDeratCertiExpDt = vslDeratCertiExpDt;
		this.ttlTeuKnt = ttlTeuKnt;
		this.foilCsm = foilCsm;
		this.n2ndVndrNm = n2ndVndrNm;
		this.doilCsm = doilCsm;
		this.vslDeDt = vslDeDt;
		this.vslCd = vslCd;
		this.dwtWgt = dwtWgt;
		this.mnEngRpmPwr = mnEngRpmPwr;
		this.crrCd = crrCd;
		this.vslSftEqCertiExpDt = vslSftEqCertiExpDt;
		this.n1stRmnDt = n1stRmnDt;
		this.doilCapa = doilCapa;
		this.n2ndHirCurrN1stCd = n2ndHirCurrN1stCd;
		this.vslType = vslType;
		this.frshWtrCapa = frshWtrCapa;
		this.phnNo = phnNo;
		this.n2ndVndrSeq = n2ndVndrSeq;
		this.cntrOpCapa = cntrOpCapa;
		this.n1stHirCurrN1stCd = n1stHirCurrN1stCd;
		this.piclbDesc = piclbDesc;
		this.vslOwnIndCd = vslOwnIndCd;
		this.frshWtrCsm = frshWtrCsm;
		this.cntrDznCapa = cntrDznCapa;
		this.creUsrId = creUsrId;
		this.fdrDivCd = fdrDivCd;
		this.n1stHirRtN1stAmt = n1stHirRtN1stAmt;
		this.faxNo = faxNo;
		this.vslDeltOfcCd = vslDeltOfcCd;
		this.smrDrftHgt = smrDrftHgt;
		this.bwthstBhpPwr = bwthstBhpPwr;
		this.vslEdiNm = vslEdiNm;
		this.vslEml = vslEml;
		this.crrFullNm = crrFullNm;
		this.creDt = creDt;
		this.vslBldAreaNm = vslBldAreaNm;
		this.mnEngMkrNm = mnEngMkrNm;
		this.vslHtchKnt = vslHtchKnt;
		this.gnrBhpPwr = gnrBhpPwr;
		this.cntNm = cntNm;
		this.ibflag = ibflag;
		this.maxSpd = maxSpd;
		this.vslEngNm = vslEngNm;
		this.vslRgstCntCd = vslRgstCntCd;
		this.cntrPnmCapa = cntrPnmCapa;
		this.n1stVndrSeq = n1stVndrSeq;
		this.n1stVndrNm = n1stVndrNm;
		this.gnrRpmPwr = gnrRpmPwr;
		this.vslClssNo = vslClssNo;
		this.vslLoclNm = vslLoclNm;
		this.updDt = updDt;
		this.netRgstTongWgt = netRgstTongWgt;
		this.coCd = coCd;
		this.vslBldCd = vslBldCd;
		this.bwthstTpDesc = bwthstTpDesc;
		this.n2ndEffDt = n2ndEffDt;
		this.ecnSpd = ecnSpd;
		this.eaiEvntDt = eaiEvntDt;
		this.mnEngBhpPwr = mnEngBhpPwr;
		this.vslKelLyDt = vslKelLyDt;
		this.cntrVslClssCapa = cntrVslClssCapa;
		this.intlTongCertiFlg = intlTongCertiFlg;
		this.vslWdt = vslWdt;
		this.vslSvcSpd = vslSvcSpd;
		this.gnrMkrNm = gnrMkrNm;
		this.mnEngTrKnt = mnEngTrKnt;
		this.gnrTrKnt = gnrTrKnt;
		this.bwthstTrKnt = bwthstTrKnt;
		this.blkCrrTpCd = blkCrrTpCd;
		this.blstWgtSpd1 = blstWgtSpd1;
		this.ctclRpmNo = ctclRpmNo;
		this.ctclToRpmNo = ctclToRpmNo;
		this.foilBlstCsm2 = foilBlstCsm2;
		this.fuelSavEqFlg = fuelSavEqFlg;
		this.htchCvrInHldKnt = htchCvrInHldKnt;
		this.inHldPerRowKnt = inHldPerRowKnt;
		this.inHldPerTrKnt = inHldPerTrKnt;
		this.ldnWgtSpd1 = ldnWgtSpd1;
		this.onDeckPerRowKnt = onDeckPerRowKnt;
		this.onDeckPerTrKnt = onDeckPerTrKnt;
		this.opMinRpmNo = opMinRpmNo;
		this.opMinSpd = opMinSpd;
		this.portFoilTonCsm = portFoilTonCsm;
		this.portIdleDoilTonCsm = portIdleDoilTonCsm;
		this.portWrkDoilTonCsm = portWrkDoilTonCsm;
		this.slwStmngFlg = slwStmngFlg;
		this.sprSlwStmngFlg = sprSlwStmngFlg;
		this.tropDrftHgt = tropDrftHgt;
		this.tropDwtWgt = tropDwtWgt;
		this.vslLodRto = vslLodRto;
		this.wntDrftHgt = wntDrftHgt;
		this.wntDwtWgt = wntDwtWgt;
		this.pageNo = pageNo;
		this.ampTpCd = ampTpCd;


	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bwthst_rpm_pwr", getBwthstRpmPwr());
		this.hashColumns.put("mn_eng_tp_desc", getMnEngTpDesc());
		this.hashColumns.put("vsl_dpth", getVslDpth());
		this.hashColumns.put("n2nd_rmn_dt", getN2ndRmnDt());
		this.hashColumns.put("n1st_hir_rt_n2nd_amt", getN1stHirRtN2ndAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("n2nd_hir_rt_n2nd_amt", getN2ndHirRtN2ndAmt());
		this.hashColumns.put("dpl_capa", getDplCapa());
		this.hashColumns.put("gnr_tp_desc", getGnrTpDesc());
		this.hashColumns.put("fbd_capa", getFbdCapa());
		this.hashColumns.put("vsl_hgt", getVslHgt());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("vsl_lod_line_certi_exp_dt", getVslLodLineCertiExpDt());
		this.hashColumns.put("vsl_sft_rdo_certi_exp_dt", getVslSftRdoCertiExpDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("rgst_dt", getRgstDt());
		this.hashColumns.put("vsl_hld_knt", getVslHldKnt());
		this.hashColumns.put("rgst_port_cd", getRgstPortCd());
		this.hashColumns.put("lbp_len", getLbpLen());
		this.hashColumns.put("call_sgn_no", getCallSgnNo());
		this.hashColumns.put("n2nd_hir_rt_n1st_amt", getN2ndHirRtN1stAmt());
		this.hashColumns.put("clss_no_rgst_area_nm", getClssNoRgstAreaNm());
		this.hashColumns.put("grs_rgst_tong_wgt", getGrsRgstTongWgt());
		this.hashColumns.put("tlx_no", getTlxNo());
		this.hashColumns.put("rf_rcpt_knt", getRfRcptKnt());
		this.hashColumns.put("vsl_hl_no", getVslHlNo());
		this.hashColumns.put("lloyd_no", getLloydNo());
		this.hashColumns.put("suz_net_tong_wgt", getSuzNetTongWgt());
		this.hashColumns.put("pnm_net_tong_wgt", getPnmNetTongWgt());
		this.hashColumns.put("rgst_no", getRgstNo());
		this.hashColumns.put("n1st_eff_dt", getN1stEffDt());
		this.hashColumns.put("vsl_rmk", getVslRmk());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("n2nd_hir_curr_n2nd_cd", getN2ndHirCurrN2ndCd());
		this.hashColumns.put("n1st_exp_dt", getN1stExpDt());
		this.hashColumns.put("rf_rcpt_max_knt", getRfRcptMaxKnt());
		this.hashColumns.put("loa_len", getLoaLen());
		this.hashColumns.put("vsl_lnch_dt", getVslLnchDt());
		this.hashColumns.put("n2nd_exp_dt", getN2ndExpDt());
		this.hashColumns.put("vsl_bldr_nm", getVslBldrNm());
		this.hashColumns.put("crw_knt", getCrwKnt());
		this.hashColumns.put("vsl_cre_ofc_cd", getVslCreOfcCd());
		this.hashColumns.put("vsl_clss_cd", getVslClssCd());
		this.hashColumns.put("vsl_sft_cstru_certi_exp_dt", getVslSftCstruCertiExpDt());
		this.hashColumns.put("blst_tnk_capa", getBlstTnkCapa());
		this.hashColumns.put("vsl_krn_nm", getVslKrnNm());
		this.hashColumns.put("n1st_hir_curr_n2nd_cd", getN1stHirCurrN2ndCd());
		this.hashColumns.put("bwthst_mkr_nm", getBwthstMkrNm());
		this.hashColumns.put("pnm_gt_wgt", getPnmGtWgt());
		this.hashColumns.put("vsl_clz_dt", getVslClzDt());
		this.hashColumns.put("suz_gt_wgt", getSuzGtWgt());
		this.hashColumns.put("madn_voy_suz_net_tong_wgt", getMadnVoySuzNetTongWgt());
		this.hashColumns.put("lgt_shp_tong_wgt", getLgtShpTongWgt());
		this.hashColumns.put("mn_eng_kw_pwr", getMnEngKwPwr());
		this.hashColumns.put("foil_capa", getFoilCapa());
		this.hashColumns.put("vsl_derat_certi_exp_dt", getVslDeratCertiExpDt());
		this.hashColumns.put("ttl_teu_knt", getTtlTeuKnt());
		this.hashColumns.put("foil_csm", getFoilCsm());
		this.hashColumns.put("n2nd_vndr_nm", getN2ndVndrNm());
		this.hashColumns.put("doil_csm", getDoilCsm());
		this.hashColumns.put("vsl_de_dt", getVslDeDt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("dwt_wgt", getDwtWgt());
		this.hashColumns.put("mn_eng_rpm_pwr", getMnEngRpmPwr());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("vsl_sft_eq_certi_exp_dt", getVslSftEqCertiExpDt());
		this.hashColumns.put("n1st_rmn_dt", getN1stRmnDt());
		this.hashColumns.put("doil_capa", getDoilCapa());
		this.hashColumns.put("n2nd_hir_curr_n1st_cd", getN2ndHirCurrN1stCd());
		this.hashColumns.put("vsl_type", getVslType());
		this.hashColumns.put("frsh_wtr_capa", getFrshWtrCapa());
		this.hashColumns.put("phn_no", getPhnNo());
		this.hashColumns.put("n2nd_vndr_seq", getN2ndVndrSeq());
		this.hashColumns.put("cntr_op_capa", getCntrOpCapa());
		this.hashColumns.put("n1st_hir_curr_n1st_cd", getN1stHirCurrN1stCd());
		this.hashColumns.put("piclb_desc", getPiclbDesc());
		this.hashColumns.put("vsl_own_ind_cd", getVslOwnIndCd());
		this.hashColumns.put("frsh_wtr_csm", getFrshWtrCsm());
		this.hashColumns.put("cntr_dzn_capa", getCntrDznCapa());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("fdr_div_cd", getFdrDivCd());
		this.hashColumns.put("n1st_hir_rt_n1st_amt", getN1stHirRtN1stAmt());
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("vsl_delt_ofc_cd", getVslDeltOfcCd());
		this.hashColumns.put("smr_drft_hgt", getSmrDrftHgt());
		this.hashColumns.put("bwthst_bhp_pwr", getBwthstBhpPwr());
		this.hashColumns.put("vsl_edi_nm", getVslEdiNm());
		this.hashColumns.put("vsl_eml", getVslEml());
		this.hashColumns.put("crr_full_nm", getCrrFullNm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("vsl_bld_area_nm", getVslBldAreaNm());
		this.hashColumns.put("mn_eng_mkr_nm", getMnEngMkrNm());
		this.hashColumns.put("vsl_htch_knt", getVslHtchKnt());
		this.hashColumns.put("gnr_bhp_pwr", getGnrBhpPwr());
		this.hashColumns.put("cnt_nm", getCntNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("max_spd", getMaxSpd());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("vsl_rgst_cnt_cd", getVslRgstCntCd());
		this.hashColumns.put("cntr_pnm_capa", getCntrPnmCapa());
		this.hashColumns.put("n1st_vndr_seq", getN1stVndrSeq());
		this.hashColumns.put("n1st_vndr_nm", getN1stVndrNm());
		this.hashColumns.put("gnr_rpm_pwr", getGnrRpmPwr());
		this.hashColumns.put("vsl_clss_no", getVslClssNo());
		this.hashColumns.put("vsl_locl_nm", getVslLoclNm());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("net_rgst_tong_wgt", getNetRgstTongWgt());
		this.hashColumns.put("co_cd", getCoCd());
		this.hashColumns.put("vsl_bld_cd", getVslBldCd());
		this.hashColumns.put("bwthst_tp_desc", getBwthstTpDesc());
		this.hashColumns.put("n2nd_eff_dt", getN2ndEffDt());
		this.hashColumns.put("ecn_spd", getEcnSpd());
		this.hashColumns.put("eai_evnt_dt", getEaiEvntDt());
		this.hashColumns.put("mn_eng_bhp_pwr", getMnEngBhpPwr());
		this.hashColumns.put("vsl_kel_ly_dt", getVslKelLyDt());
		this.hashColumns.put("cntr_vsl_clss_capa", getCntrVslClssCapa());
		this.hashColumns.put("intl_tong_certi_flg", getIntlTongCertiFlg());
		this.hashColumns.put("vsl_wdt", getVslWdt());
		this.hashColumns.put("vsl_svc_spd", getVslSvcSpd());
		this.hashColumns.put("gnr_mkr_nm", getGnrMkrNm());
		this.hashColumns.put("mn_eng_tr_knt", getMnEngTrKnt());	
		this.hashColumns.put("gnr_tr_knt", getGnrTrKnt());	
		this.hashColumns.put("bwthst_tr_knt", getBwthstTrKnt());
		this.hashColumns.put("blk_crr_tp_cd", getBlkCrrTpCd());
		this.hashColumns.put("blst_wgt_spd1", getBlstWgtSpd1());
		this.hashColumns.put("ctcl_rpm_no", getCtclRpmNo());
		this.hashColumns.put("ctcl_to_rpm_no", getCtclToRpmNo());
		this.hashColumns.put("foil_blst_csm2", getFoilBlstCsm2());
		this.hashColumns.put("fuel_sav_eq_flg", getFuelSavEqFlg());
		this.hashColumns.put("htch_cvr_in_hld_knt", getHtchCvrInHldKnt());
		this.hashColumns.put("in_hld_per_row_knt", getInHldPerRowKnt());
		this.hashColumns.put("in_hld_per_tr_knt", getInHldPerTrKnt());
		this.hashColumns.put("ldn_wgt_spd1", getLdnWgtSpd1());
		this.hashColumns.put("on_deck_per_row_knt", getOnDeckPerRowKnt());
		this.hashColumns.put("on_deck_per_tr_knt", getOnDeckPerTrKnt());
		this.hashColumns.put("op_min_rpm_no", getOpMinRpmNo());
		this.hashColumns.put("op_min_spd", getOpMinSpd());
		this.hashColumns.put("port_foil_ton_csm", getPortFoilTonCsm());
		this.hashColumns.put("port_idle_doil_ton_csm", getPortIdleDoilTonCsm());
		this.hashColumns.put("port_wrk_doil_ton_csm", getPortWrkDoilTonCsm());
		this.hashColumns.put("slw_stmng_flg", getSlwStmngFlg());
		this.hashColumns.put("spr_slw_stmng_flg", getSprSlwStmngFlg());
		this.hashColumns.put("trop_drft_hgt", getTropDrftHgt());
		this.hashColumns.put("trop_dwt_wgt", getTropDwtWgt());
		this.hashColumns.put("vsl_lod_rto", getVslLodRto());
		this.hashColumns.put("wnt_drft_hgt", getWntDrftHgt());
		this.hashColumns.put("wnt_dwt_wgt", getWntDwtWgt());
		this.hashColumns.put("page_no", getPageNo());
		this.hashColumns.put("amp_tp_cd", getAmpTpCd());

		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bwthst_rpm_pwr", "bwthstRpmPwr");
		this.hashFields.put("mn_eng_tp_desc", "mnEngTpDesc");
		this.hashFields.put("vsl_dpth", "vslDpth");
		this.hashFields.put("n2nd_rmn_dt", "n2ndRmnDt");
		this.hashFields.put("n1st_hir_rt_n2nd_amt", "n1stHirRtN2ndAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("n2nd_hir_rt_n2nd_amt", "n2ndHirRtN2ndAmt");
		this.hashFields.put("dpl_capa", "dplCapa");
		this.hashFields.put("gnr_tp_desc", "gnrTpDesc");
		this.hashFields.put("fbd_capa", "fbdCapa");
		this.hashFields.put("vsl_hgt", "vslHgt");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("vsl_lod_line_certi_exp_dt", "vslLodLineCertiExpDt");
		this.hashFields.put("vsl_sft_rdo_certi_exp_dt", "vslSftRdoCertiExpDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("rgst_dt", "rgstDt");
		this.hashFields.put("vsl_hld_knt", "vslHldKnt");
		this.hashFields.put("rgst_port_cd", "rgstPortCd");
		this.hashFields.put("lbp_len", "lbpLen");
		this.hashFields.put("call_sgn_no", "callSgnNo");
		this.hashFields.put("n2nd_hir_rt_n1st_amt", "n2ndHirRtN1stAmt");
		this.hashFields.put("clss_no_rgst_area_nm", "clssNoRgstAreaNm");
		this.hashFields.put("grs_rgst_tong_wgt", "grsRgstTongWgt");
		this.hashFields.put("tlx_no", "tlxNo");
		this.hashFields.put("rf_rcpt_knt", "rfRcptKnt");
		this.hashFields.put("vsl_hl_no", "vslHlNo");
		this.hashFields.put("lloyd_no", "lloydNo");
		this.hashFields.put("suz_net_tong_wgt", "suzNetTongWgt");
		this.hashFields.put("pnm_net_tong_wgt", "pnmNetTongWgt");
		this.hashFields.put("rgst_no", "rgstNo");
		this.hashFields.put("n1st_eff_dt", "n1stEffDt");
		this.hashFields.put("vsl_rmk", "vslRmk");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("n2nd_hir_curr_n2nd_cd", "n2ndHirCurrN2ndCd");
		this.hashFields.put("n1st_exp_dt", "n1stExpDt");
		this.hashFields.put("rf_rcpt_max_knt", "rfRcptMaxKnt");
		this.hashFields.put("loa_len", "loaLen");
		this.hashFields.put("vsl_lnch_dt", "vslLnchDt");
		this.hashFields.put("n2nd_exp_dt", "n2ndExpDt");
		this.hashFields.put("vsl_bldr_nm", "vslBldrNm");
		this.hashFields.put("crw_knt", "crwKnt");
		this.hashFields.put("vsl_cre_ofc_cd", "vslCreOfcCd");
		this.hashFields.put("vsl_clss_cd", "vslClssCd");
		this.hashFields.put("vsl_sft_cstru_certi_exp_dt", "vslSftCstruCertiExpDt");
		this.hashFields.put("blst_tnk_capa", "blstTnkCapa");
		this.hashFields.put("vsl_krn_nm", "vslKrnNm");
		this.hashFields.put("n1st_hir_curr_n2nd_cd", "n1stHirCurrN2ndCd");
		this.hashFields.put("bwthst_mkr_nm", "bwthstMkrNm");
		this.hashFields.put("pnm_gt_wgt", "pnmGtWgt");
		this.hashFields.put("vsl_clz_dt", "vslClzDt");
		this.hashFields.put("suz_gt_wgt", "suzGtWgt");
		this.hashFields.put("madn_voy_suz_net_tong_wgt", "madnVoySuzNetTongWgt");
		this.hashFields.put("lgt_shp_tong_wgt", "lgtShpTongWgt");
		this.hashFields.put("mn_eng_kw_pwr", "mnEngKwPwr");
		this.hashFields.put("foil_capa", "foilCapa");
		this.hashFields.put("vsl_derat_certi_exp_dt", "vslDeratCertiExpDt");
		this.hashFields.put("ttl_teu_knt", "ttlTeuKnt");
		this.hashFields.put("foil_csm", "foilCsm");
		this.hashFields.put("n2nd_vndr_nm", "n2ndVndrNm");
		this.hashFields.put("doil_csm", "doilCsm");
		this.hashFields.put("vsl_de_dt", "vslDeDt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("dwt_wgt", "dwtWgt");
		this.hashFields.put("mn_eng_rpm_pwr", "mnEngRpmPwr");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("vsl_sft_eq_certi_exp_dt", "vslSftEqCertiExpDt");
		this.hashFields.put("n1st_rmn_dt", "n1stRmnDt");
		this.hashFields.put("doil_capa", "doilCapa");
		this.hashFields.put("n2nd_hir_curr_n1st_cd", "n2ndHirCurrN1stCd");
		this.hashFields.put("vsl_type", "vslType");
		this.hashFields.put("frsh_wtr_capa", "frshWtrCapa");
		this.hashFields.put("phn_no", "phnNo");
		this.hashFields.put("n2nd_vndr_seq", "n2ndVndrSeq");
		this.hashFields.put("cntr_op_capa", "cntrOpCapa");
		this.hashFields.put("n1st_hir_curr_n1st_cd", "n1stHirCurrN1stCd");
		this.hashFields.put("piclb_desc", "piclbDesc");
		this.hashFields.put("vsl_own_ind_cd", "vslOwnIndCd");
		this.hashFields.put("frsh_wtr_csm", "frshWtrCsm");
		this.hashFields.put("cntr_dzn_capa", "cntrDznCapa");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("fdr_div_cd", "fdrDivCd");
		this.hashFields.put("n1st_hir_rt_n1st_amt", "n1stHirRtN1stAmt");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("vsl_delt_ofc_cd", "vslDeltOfcCd");
		this.hashFields.put("smr_drft_hgt", "smrDrftHgt");
		this.hashFields.put("bwthst_bhp_pwr", "bwthstBhpPwr");
		this.hashFields.put("vsl_edi_nm", "vslEdiNm");
		this.hashFields.put("vsl_eml", "vslEml");
		this.hashFields.put("crr_full_nm", "crrFullNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("vsl_bld_area_nm", "vslBldAreaNm");
		this.hashFields.put("mn_eng_mkr_nm", "mnEngMkrNm");
		this.hashFields.put("vsl_htch_knt", "vslHtchKnt");
		this.hashFields.put("gnr_bhp_pwr", "gnrBhpPwr");
		this.hashFields.put("cnt_nm", "cntNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("max_spd", "maxSpd");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("vsl_rgst_cnt_cd", "vslRgstCntCd");
		this.hashFields.put("cntr_pnm_capa", "cntrPnmCapa");
		this.hashFields.put("n1st_vndr_seq", "n1stVndrSeq");
		this.hashFields.put("n1st_vndr_nm", "n1stVndrNm");
		this.hashFields.put("gnr_rpm_pwr", "gnrRpmPwr");
		this.hashFields.put("vsl_clss_no", "vslClssNo");
		this.hashFields.put("vsl_locl_nm", "vslLoclNm");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("net_rgst_tong_wgt", "netRgstTongWgt");
		this.hashFields.put("co_cd", "coCd");
		this.hashFields.put("vsl_bld_cd", "vslBldCd");
		this.hashFields.put("bwthst_tp_desc", "bwthstTpDesc");
		this.hashFields.put("n2nd_eff_dt", "n2ndEffDt");
		this.hashFields.put("ecn_spd", "ecnSpd");
		this.hashFields.put("eai_evnt_dt", "eaiEvntDt");
		this.hashFields.put("mn_eng_bhp_pwr", "mnEngBhpPwr");
		this.hashFields.put("vsl_kel_ly_dt", "vslKelLyDt");
		this.hashFields.put("cntr_vsl_clss_capa", "cntrVslClssCapa");
		this.hashFields.put("intl_tong_certi_flg", "intlTongCertiFlg");
		this.hashFields.put("vsl_wdt", "vslWdt");
		this.hashFields.put("vsl_svc_spd", "vslSvcSpd");
		this.hashFields.put("gnr_mkr_nm", "gnrMkrNm");
		this.hashFields.put("mn_eng_tr_knt", "mnEngTrKnt");
		this.hashFields.put("gnr_tr_knt", "gnrTrKnt");
		this.hashFields.put("bwthst_tr_knt", "bwthstTrKnt");
		this.hashFields.put("blk_crr_tp_cd", "blkCrrTpCd");
		this.hashFields.put("blst_wgt_spd1", "blstWgtSpd1");
		this.hashFields.put("ctcl_rpm_no", "ctclRpmNo");
		this.hashFields.put("ctcl_to_rpm_no", "ctclToRpmNo");
		this.hashFields.put("foil_blst_csm2", "foilBlstCsm2");
		this.hashFields.put("fuel_sav_eq_flg", "fuelSavEqFlg");
		this.hashFields.put("htch_cvr_in_hld_knt", "htchCvrInHldKnt");
		this.hashFields.put("in_hld_per_row_knt", "inHldPerRowKnt");
		this.hashFields.put("in_hld_per_tr_knt", "inHldPerTrKnt");
		this.hashFields.put("ldn_wgt_spd1", "ldnWgtSpd1");
		this.hashFields.put("on_deck_per_row_knt", "onDeckPerRowKnt");
		this.hashFields.put("on_deck_per_tr_knt", "onDeckPerTrKnt");
		this.hashFields.put("op_min_rpm_no", "opMinRpmNo");
		this.hashFields.put("op_min_spd", "opMinSpd");
		this.hashFields.put("port_foil_ton_csm", "portFoilTonCsm");
		this.hashFields.put("port_idle_doil_ton_csm", "portIdleDoilTonCsm");
		this.hashFields.put("port_wrk_doil_ton_csm", "portWrkDoilTonCsm");
		this.hashFields.put("slw_stmng_flg", "slwStmngFlg");
		this.hashFields.put("spr_slw_stmng_flg", "sprSlwStmngFlg");
		this.hashFields.put("trop_drft_hgt", "tropDrftHgt");
		this.hashFields.put("trop_dwt_wgt", "tropDwtWgt");
		this.hashFields.put("vsl_lod_rto", "vslLodRto");
		this.hashFields.put("wnt_drft_hgt", "wntDrftHgt");
		this.hashFields.put("wnt_dwt_wgt", "wntDwtWgt");
		this.hashFields.put("page_no", "pageNo");
		this.hashFields.put("amp_tp_cd", "ampTpCd");

		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bwthstRpmPwr
	 */
	public String getBwthstRpmPwr() {
		return this.bwthstRpmPwr;
	}
	
	/**
	 * Column Info
	 * @return mnEngTpDesc
	 */
	public String getMnEngTpDesc() {
		return this.mnEngTpDesc;
	}
	
	/**
	 * Column Info
	 * @return vslDpth
	 */
	public String getVslDpth() {
		return this.vslDpth;
	}
	
	/**
	 * Column Info
	 * @return n2ndRmnDt
	 */
	public String getN2ndRmnDt() {
		return this.n2ndRmnDt;
	}
	
	/**
	 * Column Info
	 * @return n1stHirRtN2ndAmt
	 */
	public String getN1stHirRtN2ndAmt() {
		return this.n1stHirRtN2ndAmt;
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
	 * @return n2ndHirRtN2ndAmt
	 */
	public String getN2ndHirRtN2ndAmt() {
		return this.n2ndHirRtN2ndAmt;
	}
	
	/**
	 * Column Info
	 * @return dplCapa
	 */
	public String getDplCapa() {
		return this.dplCapa;
	}
	
	/**
	 * Column Info
	 * @return gnrTpDesc
	 */
	public String getGnrTpDesc() {
		return this.gnrTpDesc;
	}
	
	/**
	 * Column Info
	 * @return fbdCapa
	 */
	public String getFbdCapa() {
		return this.fbdCapa;
	}
	
	/**
	 * Column Info
	 * @return vslHgt
	 */
	public String getVslHgt() {
		return this.vslHgt;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return vslLodLineCertiExpDt
	 */
	public String getVslLodLineCertiExpDt() {
		return this.vslLodLineCertiExpDt;
	}
	
	/**
	 * Column Info
	 * @return vslSftRdoCertiExpDt
	 */
	public String getVslSftRdoCertiExpDt() {
		return this.vslSftRdoCertiExpDt;
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
	 * @return rgstDt
	 */
	public String getRgstDt() {
		return this.rgstDt;
	}
	
	/**
	 * Column Info
	 * @return vslHldKnt
	 */
	public String getVslHldKnt() {
		return this.vslHldKnt;
	}
	
	/**
	 * Column Info
	 * @return rgstPortCd
	 */
	public String getRgstPortCd() {
		return this.rgstPortCd;
	}
	
	/**
	 * Column Info
	 * @return lbpLen
	 */
	public String getLbpLen() {
		return this.lbpLen;
	}
	
	/**
	 * Column Info
	 * @return callSgnNo
	 */
	public String getCallSgnNo() {
		return this.callSgnNo;
	}
	
	/**
	 * Column Info
	 * @return n2ndHirRtN1stAmt
	 */
	public String getN2ndHirRtN1stAmt() {
		return this.n2ndHirRtN1stAmt;
	}
	
	/**
	 * Column Info
	 * @return clssNoRgstAreaNm
	 */
	public String getClssNoRgstAreaNm() {
		return this.clssNoRgstAreaNm;
	}
	
	/**
	 * Column Info
	 * @return grsRgstTongWgt
	 */
	public String getGrsRgstTongWgt() {
		return this.grsRgstTongWgt;
	}
	
	/**
	 * Column Info
	 * @return tlxNo
	 */
	public String getTlxNo() {
		return this.tlxNo;
	}
	
	/**
	 * Column Info
	 * @return rfRcptKnt
	 */
	public String getRfRcptKnt() {
		return this.rfRcptKnt;
	}
	
	/**
	 * Column Info
	 * @return vslHlNo
	 */
	public String getVslHlNo() {
		return this.vslHlNo;
	}
	
	/**
	 * Column Info
	 * @return lloydNo
	 */
	public String getLloydNo() {
		return this.lloydNo;
	}
	
	/**
	 * Column Info
	 * @return suzNetTongWgt
	 */
	public String getSuzNetTongWgt() {
		return this.suzNetTongWgt;
	}
	
	/**
	 * Column Info
	 * @return pnmNetTongWgt
	 */
	public String getPnmNetTongWgt() {
		return this.pnmNetTongWgt;
	}
	
	/**
	 * Column Info
	 * @return rgstNo
	 */
	public String getRgstNo() {
		return this.rgstNo;
	}
	
	/**
	 * Column Info
	 * @return n1stEffDt
	 */
	public String getN1stEffDt() {
		return this.n1stEffDt;
	}
	
	/**
	 * Column Info
	 * @return vslRmk
	 */
	public String getVslRmk() {
		return this.vslRmk;
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
	 * @return n2ndHirCurrN2ndCd
	 */
	public String getN2ndHirCurrN2ndCd() {
		return this.n2ndHirCurrN2ndCd;
	}
	
	/**
	 * Column Info
	 * @return n1stExpDt
	 */
	public String getN1stExpDt() {
		return this.n1stExpDt;
	}
	
	/**
	 * Column Info
	 * @return rfRcptMaxKnt
	 */
	public String getRfRcptMaxKnt() {
		return this.rfRcptMaxKnt;
	}
	
	/**
	 * Column Info
	 * @return loaLen
	 */
	public String getLoaLen() {
		return this.loaLen;
	}
	
	/**
	 * Column Info
	 * @return vslLnchDt
	 */
	public String getVslLnchDt() {
		return this.vslLnchDt;
	}
	
	/**
	 * Column Info
	 * @return n2ndExpDt
	 */
	public String getN2ndExpDt() {
		return this.n2ndExpDt;
	}
	
	/**
	 * Column Info
	 * @return vslBldrNm
	 */
	public String getVslBldrNm() {
		return this.vslBldrNm;
	}
	
	/**
	 * Column Info
	 * @return crwKnt
	 */
	public String getCrwKnt() {
		return this.crwKnt;
	}
	
	/**
	 * Column Info
	 * @return vslCreOfcCd
	 */
	public String getVslCreOfcCd() {
		return this.vslCreOfcCd;
	}
	
	/**
	 * Column Info
	 * @return vslClssCd
	 */
	public String getVslClssCd() {
		return this.vslClssCd;
	}
	
	/**
	 * Column Info
	 * @return vslSftCstruCertiExpDt
	 */
	public String getVslSftCstruCertiExpDt() {
		return this.vslSftCstruCertiExpDt;
	}
	
	/**
	 * Column Info
	 * @return blstTnkCapa
	 */
	public String getBlstTnkCapa() {
		return this.blstTnkCapa;
	}
	
	/**
	 * Column Info
	 * @return vslKrnNm
	 */
	public String getVslKrnNm() {
		return this.vslKrnNm;
	}
	
	/**
	 * Column Info
	 * @return n1stHirCurrN2ndCd
	 */
	public String getN1stHirCurrN2ndCd() {
		return this.n1stHirCurrN2ndCd;
	}
	
	/**
	 * Column Info
	 * @return bwthstMkrNm
	 */
	public String getBwthstMkrNm() {
		return this.bwthstMkrNm;
	}
	
	/**
	 * Column Info
	 * @return pnmGtWgt
	 */
	public String getPnmGtWgt() {
		return this.pnmGtWgt;
	}
	
	/**
	 * Column Info
	 * @return vslClzDt
	 */
	public String getVslClzDt() {
		return this.vslClzDt;
	}
	
	/**
	 * Column Info
	 * @return suzGtWgt
	 */
	public String getSuzGtWgt() {
		return this.suzGtWgt;
	}
	
	/**
	 * Column Info
	 * @return madnVoySuzNetTongWgt
	 */
	public String getMadnVoySuzNetTongWgt() {
		return this.madnVoySuzNetTongWgt;
	}
	
	/**
	 * Column Info
	 * @return lgtShpTongWgt
	 */
	public String getLgtShpTongWgt() {
		return this.lgtShpTongWgt;
	}
	
	/**
	 * Column Info
	 * @return mnEngKwPwr
	 */
	public String getMnEngKwPwr() {
		return this.mnEngKwPwr;
	}
	
	/**
	 * Column Info
	 * @return foilCapa
	 */
	public String getFoilCapa() {
		return this.foilCapa;
	}
	
	/**
	 * Column Info
	 * @return vslDeratCertiExpDt
	 */
	public String getVslDeratCertiExpDt() {
		return this.vslDeratCertiExpDt;
	}
	
	/**
	 * Column Info
	 * @return ttlTeuKnt
	 */
	public String getTtlTeuKnt() {
		return this.ttlTeuKnt;
	}
	
	/**
	 * Column Info
	 * @return foilCsm
	 */
	public String getFoilCsm() {
		return this.foilCsm;
	}
	
	/**
	 * Column Info
	 * @return n2ndVndrNm
	 */
	public String getN2ndVndrNm() {
		return this.n2ndVndrNm;
	}
	
	/**
	 * Column Info
	 * @return doilCsm
	 */
	public String getDoilCsm() {
		return this.doilCsm;
	}
	
	/**
	 * Column Info
	 * @return vslDeDt
	 */
	public String getVslDeDt() {
		return this.vslDeDt;
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
	 * @return dwtWgt
	 */
	public String getDwtWgt() {
		return this.dwtWgt;
	}
	
	/**
	 * Column Info
	 * @return mnEngRpmPwr
	 */
	public String getMnEngRpmPwr() {
		return this.mnEngRpmPwr;
	}
	
	/**
	 * Column Info
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
	}
	
	/**
	 * Column Info
	 * @return vslSftEqCertiExpDt
	 */
	public String getVslSftEqCertiExpDt() {
		return this.vslSftEqCertiExpDt;
	}
	
	/**
	 * Column Info
	 * @return n1stRmnDt
	 */
	public String getN1stRmnDt() {
		return this.n1stRmnDt;
	}
	
	/**
	 * Column Info
	 * @return doilCapa
	 */
	public String getDoilCapa() {
		return this.doilCapa;
	}
	
	/**
	 * Column Info
	 * @return n2ndHirCurrN1stCd
	 */
	public String getN2ndHirCurrN1stCd() {
		return this.n2ndHirCurrN1stCd;
	}
	
	/**
	 * Column Info
	 * @return vslType
	 */
	public String getVslType() {
		return this.vslType;
	}
	
	/**
	 * Column Info
	 * @return frshWtrCapa
	 */
	public String getFrshWtrCapa() {
		return this.frshWtrCapa;
	}
	
	/**
	 * Column Info
	 * @return phnNo
	 */
	public String getPhnNo() {
		return this.phnNo;
	}
	
	/**
	 * Column Info
	 * @return n2ndVndrSeq
	 */
	public String getN2ndVndrSeq() {
		return this.n2ndVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return cntrOpCapa
	 */
	public String getCntrOpCapa() {
		return this.cntrOpCapa;
	}
	
	/**
	 * Column Info
	 * @return n1stHirCurrN1stCd
	 */
	public String getN1stHirCurrN1stCd() {
		return this.n1stHirCurrN1stCd;
	}
	
	/**
	 * Column Info
	 * @return piclbDesc
	 */
	public String getPiclbDesc() {
		return this.piclbDesc;
	}
	
	/**
	 * Column Info
	 * @return vslOwnIndCd
	 */
	public String getVslOwnIndCd() {
		return this.vslOwnIndCd;
	}
	
	/**
	 * Column Info
	 * @return frshWtrCsm
	 */
	public String getFrshWtrCsm() {
		return this.frshWtrCsm;
	}
	
	/**
	 * Column Info
	 * @return cntrDznCapa
	 */
	public String getCntrDznCapa() {
		return this.cntrDznCapa;
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
	 * @return fdrDivCd
	 */
	public String getFdrDivCd() {
		return this.fdrDivCd;
	}
	
	/**
	 * Column Info
	 * @return n1stHirRtN1stAmt
	 */
	public String getN1stHirRtN1stAmt() {
		return this.n1stHirRtN1stAmt;
	}
	
	/**
	 * Column Info
	 * @return faxNo
	 */
	public String getFaxNo() {
		return this.faxNo;
	}
	
	/**
	 * Column Info
	 * @return vslDeltOfcCd
	 */
	public String getVslDeltOfcCd() {
		return this.vslDeltOfcCd;
	}
	
	/**
	 * Column Info
	 * @return smrDrftHgt
	 */
	public String getSmrDrftHgt() {
		return this.smrDrftHgt;
	}
	
	/**
	 * Column Info
	 * @return bwthstBhpPwr
	 */
	public String getBwthstBhpPwr() {
		return this.bwthstBhpPwr;
	}
	
	/**
	 * Column Info
	 * @return vslEdiNm
	 */
	public String getVslEdiNm() {
		return this.vslEdiNm;
	}
	
	/**
	 * Column Info
	 * @return vslEml
	 */
	public String getVslEml() {
		return this.vslEml;
	}
	
	/**
	 * Column Info
	 * @return crrFullNm
	 */
	public String getCrrFullNm() {
		return this.crrFullNm;
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
	 * @return vslBldAreaNm
	 */
	public String getVslBldAreaNm() {
		return this.vslBldAreaNm;
	}
	
	/**
	 * Column Info
	 * @return mnEngMkrNm
	 */
	public String getMnEngMkrNm() {
		return this.mnEngMkrNm;
	}
	
	/**
	 * Column Info
	 * @return vslHtchKnt
	 */
	public String getVslHtchKnt() {
		return this.vslHtchKnt;
	}
	
	/**
	 * Column Info
	 * @return gnrBhpPwr
	 */
	public String getGnrBhpPwr() {
		return this.gnrBhpPwr;
	}
	
	/**
	 * Column Info
	 * @return cntNm
	 */
	public String getCntNm() {
		return this.cntNm;
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
	 * @return maxSpd
	 */
	public String getMaxSpd() {
		return this.maxSpd;
	}
	
	/**
	 * Column Info
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	
	/**
	 * Column Info
	 * @return vslRgstCntCd
	 */
	public String getVslRgstCntCd() {
		return this.vslRgstCntCd;
	}
	
	/**
	 * Column Info
	 * @return cntrPnmCapa
	 */
	public String getCntrPnmCapa() {
		return this.cntrPnmCapa;
	}
	
	/**
	 * Column Info
	 * @return n1stVndrSeq
	 */
	public String getN1stVndrSeq() {
		return this.n1stVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return n1stVndrNm
	 */
	public String getN1stVndrNm() {
		return this.n1stVndrNm;
	}
	
	/**
	 * Column Info
	 * @return gnrRpmPwr
	 */
	public String getGnrRpmPwr() {
		return this.gnrRpmPwr;
	}
	
	/**
	 * Column Info
	 * @return vslClssNo
	 */
	public String getVslClssNo() {
		return this.vslClssNo;
	}
	
	/**
	 * Column Info
	 * @return vslLoclNm
	 */
	public String getVslLoclNm() {
		return this.vslLoclNm;
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
	 * @return netRgstTongWgt
	 */
	public String getNetRgstTongWgt() {
		return this.netRgstTongWgt;
	}
	
	/**
	 * Column Info
	 * @return coCd
	 */
	public String getCoCd() {
		return this.coCd;
	}
	
	/**
	 * Column Info
	 * @return vslBldCd
	 */
	public String getVslBldCd() {
		return this.vslBldCd;
	}
	
	/**
	 * Column Info
	 * @return bwthstTpDesc
	 */
	public String getBwthstTpDesc() {
		return this.bwthstTpDesc;
	}
	
	/**
	 * Column Info
	 * @return n2ndEffDt
	 */
	public String getN2ndEffDt() {
		return this.n2ndEffDt;
	}
	
	/**
	 * Column Info
	 * @return ecnSpd
	 */
	public String getEcnSpd() {
		return this.ecnSpd;
	}
	
	/**
	 * Column Info
	 * @return eaiEvntDt
	 */
	public String getEaiEvntDt() {
		return this.eaiEvntDt;
	}
	
	/**
	 * Column Info
	 * @return mnEngBhpPwr
	 */
	public String getMnEngBhpPwr() {
		return this.mnEngBhpPwr;
	}
	
	/**
	 * Column Info
	 * @return vslKelLyDt
	 */
	public String getVslKelLyDt() {
		return this.vslKelLyDt;
	}
	
	/**
	 * Column Info
	 * @return cntrVslClssCapa
	 */
	public String getCntrVslClssCapa() {
		return this.cntrVslClssCapa;
	}
	
	/**
	 * Column Info
	 * @return intlTongCertiFlg
	 */
	public String getIntlTongCertiFlg() {
		return this.intlTongCertiFlg;
	}
	
	/**
	 * Column Info
	 * @return vslWdt
	 */
	public String getVslWdt() {
		return this.vslWdt;
	}
	
	/**
	 * Column Info
	 * @return vslSvcSpd
	 */
	public String getVslSvcSpd() {
		return this.vslSvcSpd;
	}
	
	/**
	 * Column Info
	 * @return gnrMkrNm
	 */
	public String getGnrMkrNm() {
		return this.gnrMkrNm;
	}
	
	/**
	 * Column Info
	 * @return mnEngTrKnt
	 */
	public String getMnEngTrKnt() {
		return this.mnEngTrKnt;
	}
	
	/**
	 * Column Info
	 * @return gnrTrKnt
	 */
	public String getGnrTrKnt() {
		return this.gnrTrKnt;
	}
	
	/**
	 * Column Info
	 * @return bwthstTrKnt
	 */
	public String getBwthstTrKnt() {
		return this.bwthstTrKnt;
	}

	/**
	 * Column Info
	 * @return blkCrrTpCd
	 */
	public String getBlkCrrTpCd() {
		return this.blkCrrTpCd;
	}
	
	/**
	 * Column Info
	 * @return blstWgtSpd1
	 */
	public String getBlstWgtSpd1() {
		return this.blstWgtSpd1;
	}
	
	/**
	 * Column Info
	 * @return ctclRpmNo
	 */
	public String getCtclRpmNo() {
		return this.ctclRpmNo;
	}
	
	/**
	 * Column Info
	 * @return ctclToRpmNo
	 */
	public String getCtclToRpmNo() {
		return this.ctclToRpmNo;
	}
	
	/**
	 * Column Info
	 * @return foilBlstCsm2
	 */
	public String getFoilBlstCsm2() {
		return this.foilBlstCsm2;
	}
	
	/**
	 * Column Info
	 * @return fuelSavEqFlg
	 */
	public String getFuelSavEqFlg() {
		return this.fuelSavEqFlg;
	}
	
	/**
	 * Column Info
	 * @return htchCvrInHldKnt
	 */
	public String getHtchCvrInHldKnt() {
		return this.htchCvrInHldKnt;
	}
	
	/**
	 * Column Info
	 * @return inHldPerRowKnt
	 */
	public String getInHldPerRowKnt() {
		return this.inHldPerRowKnt;
	}
	
	/**
	 * Column Info
	 * @return inHldPerRowKnt
	 */
	public String getInHldPerTrKnt() {
		return this.inHldPerTrKnt;
	}
	
	/**
	 * Column Info
	 * @return ldnWgtSpd1
	 */
	public String getLdnWgtSpd1() {
		return this.ldnWgtSpd1;
	}
	
	/**
	 * Column Info
	 * @return onDeckPerRowKnt
	 */
	public String getOnDeckPerRowKnt() {
		return this.onDeckPerRowKnt;
	}
	
	/**
	 * Column Info
	 * @return onDeckPerTrKnt
	 */
	public String getOnDeckPerTrKnt() {
		return this.onDeckPerTrKnt;
	}
	
	/**
	 * Column Info
	 * @return opMinRpmNo
	 */
	public String getOpMinRpmNo() {
		return this.opMinRpmNo;
	}
	
	/**
	 * Column Info
	 * @return opMinSpd
	 */
	public String getOpMinSpd() {
		return this.opMinSpd;
	}
	
	/**
	 * Column Info
	 * @return portFoilTonCsm
	 */
	public String getPortFoilTonCsm() {
		return this.portFoilTonCsm;
	}
	
	/**
	 * Column Info
	 * @return portIdleDoilTonCsm
	 */
	public String getPortIdleDoilTonCsm() {
		return this.portIdleDoilTonCsm;
	}
	
	/**
	 * Column Info
	 * @return portWrkDoilTonCsm
	 */
	public String getPortWrkDoilTonCsm() {
		return this.portWrkDoilTonCsm;
	}
	
	/**
	 * Column Info
	 * @return slwStmngFlg
	 */
	public String getSlwStmngFlg() {
		return this.slwStmngFlg;
	}
	
	/**
	 * Column Info
	 * @return sprSlwStmngFlg
	 */
	public String getSprSlwStmngFlg() {
		return this.sprSlwStmngFlg;
	}
	
	/**
	 * Column Info
	 * @return tropDrftHgt
	 */
	public String getTropDrftHgt() {
		return this.tropDrftHgt;
	}
	
	/**
	 * Column Info
	 * @return tropDwtWgt
	 */
	public String getTropDwtWgt() {
		return this.tropDwtWgt;
	}
	
	/**
	 * Column Info
	 * @return vslLodRto
	 */
	public String getVslLodRto() {
		return this.vslLodRto;
	}
	
	/**
	 * Column Info
	 * @return wntDrftHgt
	 */
	public String getWntDrftHgt() {
		return this.wntDrftHgt;
	}
	
	/**
	 * Column Info
	 * @return wntDwtWgt
	 */
	public String getWntDwtWgt() {
		return this.wntDwtWgt;
	}	
	
	/**
	 * Column Info
	 * @return wntDwtWgt
	 */
	public String getPageNo() {
		return this.pageNo;
	}
	
	/**
	 * Column Info
	 * @return ampTpCd
	 */
	public String getAmpTpCd() {
		return this.ampTpCd;
	}
	
	/**
	 * VO Info
	 * @return MdmVslCntrExcelVO[]
	 */
	public MdmVslCntrExcelVO[] getMdmVslCntrExcelVOS() {
		return this.mdmVslCntrExcelVOs;
	}
	
	/**
	 * VO Info
	 * @return List<MdmVslCntrExcelVO>
	 */
	public List<MdmVslCntrExcelVO> getMdmVslCntrExcelVOL() {
		return this.mdmVslCntrExcelVOl;
	}

	/**
	 * Column Info
	 * @param bwthstRpmPwr
	 */
	public void setBwthstRpmPwr(String bwthstRpmPwr) {
		this.bwthstRpmPwr = bwthstRpmPwr;
	}
	
	/**
	 * Column Info
	 * @param mnEngTpDesc
	 */
	public void setMnEngTpDesc(String mnEngTpDesc) {
		this.mnEngTpDesc = mnEngTpDesc;
	}
	
	/**
	 * Column Info
	 * @param vslDpth
	 */
	public void setVslDpth(String vslDpth) {
		this.vslDpth = vslDpth;
	}
	
	/**
	 * Column Info
	 * @param n2ndRmnDt
	 */
	public void setN2ndRmnDt(String n2ndRmnDt) {
		this.n2ndRmnDt = n2ndRmnDt;
	}
	
	/**
	 * Column Info
	 * @param n1stHirRtN2ndAmt
	 */
	public void setN1stHirRtN2ndAmt(String n1stHirRtN2ndAmt) {
		this.n1stHirRtN2ndAmt = n1stHirRtN2ndAmt;
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
	 * @param n2ndHirRtN2ndAmt
	 */
	public void setN2ndHirRtN2ndAmt(String n2ndHirRtN2ndAmt) {
		this.n2ndHirRtN2ndAmt = n2ndHirRtN2ndAmt;
	}
	
	/**
	 * Column Info
	 * @param dplCapa
	 */
	public void setDplCapa(String dplCapa) {
		this.dplCapa = dplCapa;
	}
	
	/**
	 * Column Info
	 * @param gnrTpDesc
	 */
	public void setGnrTpDesc(String gnrTpDesc) {
		this.gnrTpDesc = gnrTpDesc;
	}
	
	/**
	 * Column Info
	 * @param fbdCapa
	 */
	public void setFbdCapa(String fbdCapa) {
		this.fbdCapa = fbdCapa;
	}
	
	/**
	 * Column Info
	 * @param vslHgt
	 */
	public void setVslHgt(String vslHgt) {
		this.vslHgt = vslHgt;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param vslLodLineCertiExpDt
	 */
	public void setVslLodLineCertiExpDt(String vslLodLineCertiExpDt) {
		this.vslLodLineCertiExpDt = vslLodLineCertiExpDt;
	}
	
	/**
	 * Column Info
	 * @param vslSftRdoCertiExpDt
	 */
	public void setVslSftRdoCertiExpDt(String vslSftRdoCertiExpDt) {
		this.vslSftRdoCertiExpDt = vslSftRdoCertiExpDt;
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
	 * @param rgstDt
	 */
	public void setRgstDt(String rgstDt) {
		this.rgstDt = rgstDt;
	}
	
	/**
	 * Column Info
	 * @param vslHldKnt
	 */
	public void setVslHldKnt(String vslHldKnt) {
		this.vslHldKnt = vslHldKnt;
	}
	
	/**
	 * Column Info
	 * @param rgstPortCd
	 */
	public void setRgstPortCd(String rgstPortCd) {
		this.rgstPortCd = rgstPortCd;
	}
	
	/**
	 * Column Info
	 * @param lbpLen
	 */
	public void setLbpLen(String lbpLen) {
		this.lbpLen = lbpLen;
	}
	
	/**
	 * Column Info
	 * @param callSgnNo
	 */
	public void setCallSgnNo(String callSgnNo) {
		this.callSgnNo = callSgnNo;
	}
	
	/**
	 * Column Info
	 * @param n2ndHirRtN1stAmt
	 */
	public void setN2ndHirRtN1stAmt(String n2ndHirRtN1stAmt) {
		this.n2ndHirRtN1stAmt = n2ndHirRtN1stAmt;
	}
	
	/**
	 * Column Info
	 * @param clssNoRgstAreaNm
	 */
	public void setClssNoRgstAreaNm(String clssNoRgstAreaNm) {
		this.clssNoRgstAreaNm = clssNoRgstAreaNm;
	}
	
	/**
	 * Column Info
	 * @param grsRgstTongWgt
	 */
	public void setGrsRgstTongWgt(String grsRgstTongWgt) {
		this.grsRgstTongWgt = grsRgstTongWgt;
	}
	
	/**
	 * Column Info
	 * @param tlxNo
	 */
	public void setTlxNo(String tlxNo) {
		this.tlxNo = tlxNo;
	}
	
	/**
	 * Column Info
	 * @param rfRcptKnt
	 */
	public void setRfRcptKnt(String rfRcptKnt) {
		this.rfRcptKnt = rfRcptKnt;
	}
	
	/**
	 * Column Info
	 * @param vslHlNo
	 */
	public void setVslHlNo(String vslHlNo) {
		this.vslHlNo = vslHlNo;
	}
	
	/**
	 * Column Info
	 * @param lloydNo
	 */
	public void setLloydNo(String lloydNo) {
		this.lloydNo = lloydNo;
	}
	
	/**
	 * Column Info
	 * @param suzNetTongWgt
	 */
	public void setSuzNetTongWgt(String suzNetTongWgt) {
		this.suzNetTongWgt = suzNetTongWgt;
	}
	
	/**
	 * Column Info
	 * @param pnmNetTongWgt
	 */
	public void setPnmNetTongWgt(String pnmNetTongWgt) {
		this.pnmNetTongWgt = pnmNetTongWgt;
	}
	
	/**
	 * Column Info
	 * @param rgstNo
	 */
	public void setRgstNo(String rgstNo) {
		this.rgstNo = rgstNo;
	}
	
	/**
	 * Column Info
	 * @param n1stEffDt
	 */
	public void setN1stEffDt(String n1stEffDt) {
		this.n1stEffDt = n1stEffDt;
	}
	
	/**
	 * Column Info
	 * @param vslRmk
	 */
	public void setVslRmk(String vslRmk) {
		this.vslRmk = vslRmk;
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
	 * @param n2ndHirCurrN2ndCd
	 */
	public void setN2ndHirCurrN2ndCd(String n2ndHirCurrN2ndCd) {
		this.n2ndHirCurrN2ndCd = n2ndHirCurrN2ndCd;
	}
	
	/**
	 * Column Info
	 * @param n1stExpDt
	 */
	public void setN1stExpDt(String n1stExpDt) {
		this.n1stExpDt = n1stExpDt;
	}
	
	/**
	 * Column Info
	 * @param rfRcptMaxKnt
	 */
	public void setRfRcptMaxKnt(String rfRcptMaxKnt) {
		this.rfRcptMaxKnt = rfRcptMaxKnt;
	}
	
	/**
	 * Column Info
	 * @param loaLen
	 */
	public void setLoaLen(String loaLen) {
		this.loaLen = loaLen;
	}
	
	/**
	 * Column Info
	 * @param vslLnchDt
	 */
	public void setVslLnchDt(String vslLnchDt) {
		this.vslLnchDt = vslLnchDt;
	}
	
	/**
	 * Column Info
	 * @param n2ndExpDt
	 */
	public void setN2ndExpDt(String n2ndExpDt) {
		this.n2ndExpDt = n2ndExpDt;
	}
	
	/**
	 * Column Info
	 * @param vslBldrNm
	 */
	public void setVslBldrNm(String vslBldrNm) {
		this.vslBldrNm = vslBldrNm;
	}
	
	/**
	 * Column Info
	 * @param crwKnt
	 */
	public void setCrwKnt(String crwKnt) {
		this.crwKnt = crwKnt;
	}
	
	/**
	 * Column Info
	 * @param vslCreOfcCd
	 */
	public void setVslCreOfcCd(String vslCreOfcCd) {
		this.vslCreOfcCd = vslCreOfcCd;
	}
	
	/**
	 * Column Info
	 * @param vslClssCd
	 */
	public void setVslClssCd(String vslClssCd) {
		this.vslClssCd = vslClssCd;
	}
	
	/**
	 * Column Info
	 * @param vslSftCstruCertiExpDt
	 */
	public void setVslSftCstruCertiExpDt(String vslSftCstruCertiExpDt) {
		this.vslSftCstruCertiExpDt = vslSftCstruCertiExpDt;
	}
	
	/**
	 * Column Info
	 * @param blstTnkCapa
	 */
	public void setBlstTnkCapa(String blstTnkCapa) {
		this.blstTnkCapa = blstTnkCapa;
	}
	
	/**
	 * Column Info
	 * @param vslKrnNm
	 */
	public void setVslKrnNm(String vslKrnNm) {
		this.vslKrnNm = vslKrnNm;
	}
	
	/**
	 * Column Info
	 * @param n1stHirCurrN2ndCd
	 */
	public void setN1stHirCurrN2ndCd(String n1stHirCurrN2ndCd) {
		this.n1stHirCurrN2ndCd = n1stHirCurrN2ndCd;
	}
	
	/**
	 * Column Info
	 * @param bwthstMkrNm
	 */
	public void setBwthstMkrNm(String bwthstMkrNm) {
		this.bwthstMkrNm = bwthstMkrNm;
	}
	
	/**
	 * Column Info
	 * @param pnmGtWgt
	 */
	public void setPnmGtWgt(String pnmGtWgt) {
		this.pnmGtWgt = pnmGtWgt;
	}
	
	/**
	 * Column Info
	 * @param vslClzDt
	 */
	public void setVslClzDt(String vslClzDt) {
		this.vslClzDt = vslClzDt;
	}
	
	/**
	 * Column Info
	 * @param suzGtWgt
	 */
	public void setSuzGtWgt(String suzGtWgt) {
		this.suzGtWgt = suzGtWgt;
	}
	
	/**
	 * Column Info
	 * @param madnVoySuzNetTongWgt
	 */
	public void setMadnVoySuzNetTongWgt(String madnVoySuzNetTongWgt) {
		this.madnVoySuzNetTongWgt = madnVoySuzNetTongWgt;
	}
	
	/**
	 * Column Info
	 * @param lgtShpTongWgt
	 */
	public void setLgtShpTongWgt(String lgtShpTongWgt) {
		this.lgtShpTongWgt = lgtShpTongWgt;
	}
	
	/**
	 * Column Info
	 * @param mnEngKwPwr
	 */
	public void setMnEngKwPwr(String mnEngKwPwr) {
		this.mnEngKwPwr = mnEngKwPwr;
	}
	
	/**
	 * Column Info
	 * @param foilCapa
	 */
	public void setFoilCapa(String foilCapa) {
		this.foilCapa = foilCapa;
	}
	
	/**
	 * Column Info
	 * @param vslDeratCertiExpDt
	 */
	public void setVslDeratCertiExpDt(String vslDeratCertiExpDt) {
		this.vslDeratCertiExpDt = vslDeratCertiExpDt;
	}
	
	/**
	 * Column Info
	 * @param ttlTeuKnt
	 */
	public void setTtlTeuKnt(String ttlTeuKnt) {
		this.ttlTeuKnt = ttlTeuKnt;
	}
	
	/**
	 * Column Info
	 * @param foilCsm
	 */
	public void setFoilCsm(String foilCsm) {
		this.foilCsm = foilCsm;
	}
	
	/**
	 * Column Info
	 * @param n2ndVndrNm
	 */
	public void setN2ndVndrNm(String n2ndVndrNm) {
		this.n2ndVndrNm = n2ndVndrNm;
	}
	
	/**
	 * Column Info
	 * @param doilCsm
	 */
	public void setDoilCsm(String doilCsm) {
		this.doilCsm = doilCsm;
	}
	
	/**
	 * Column Info
	 * @param vslDeDt
	 */
	public void setVslDeDt(String vslDeDt) {
		this.vslDeDt = vslDeDt;
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
	 * @param dwtWgt
	 */
	public void setDwtWgt(String dwtWgt) {
		this.dwtWgt = dwtWgt;
	}
	
	/**
	 * Column Info
	 * @param mnEngRpmPwr
	 */
	public void setMnEngRpmPwr(String mnEngRpmPwr) {
		this.mnEngRpmPwr = mnEngRpmPwr;
	}
	
	/**
	 * Column Info
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
	}
	
	/**
	 * Column Info
	 * @param vslSftEqCertiExpDt
	 */
	public void setVslSftEqCertiExpDt(String vslSftEqCertiExpDt) {
		this.vslSftEqCertiExpDt = vslSftEqCertiExpDt;
	}
	
	/**
	 * Column Info
	 * @param n1stRmnDt
	 */
	public void setN1stRmnDt(String n1stRmnDt) {
		this.n1stRmnDt = n1stRmnDt;
	}
	
	/**
	 * Column Info
	 * @param doilCapa
	 */
	public void setDoilCapa(String doilCapa) {
		this.doilCapa = doilCapa;
	}
	
	/**
	 * Column Info
	 * @param n2ndHirCurrN1stCd
	 */
	public void setN2ndHirCurrN1stCd(String n2ndHirCurrN1stCd) {
		this.n2ndHirCurrN1stCd = n2ndHirCurrN1stCd;
	}
	
	/**
	 * Column Info
	 * @param vslType
	 */
	public void setVslType(String vslType) {
		this.vslType = vslType;
	}
	
	/**
	 * Column Info
	 * @param frshWtrCapa
	 */
	public void setFrshWtrCapa(String frshWtrCapa) {
		this.frshWtrCapa = frshWtrCapa;
	}
	
	/**
	 * Column Info
	 * @param phnNo
	 */
	public void setPhnNo(String phnNo) {
		this.phnNo = phnNo;
	}
	
	/**
	 * Column Info
	 * @param n2ndVndrSeq
	 */
	public void setN2ndVndrSeq(String n2ndVndrSeq) {
		this.n2ndVndrSeq = n2ndVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param cntrOpCapa
	 */
	public void setCntrOpCapa(String cntrOpCapa) {
		this.cntrOpCapa = cntrOpCapa;
	}
	
	/**
	 * Column Info
	 * @param n1stHirCurrN1stCd
	 */
	public void setN1stHirCurrN1stCd(String n1stHirCurrN1stCd) {
		this.n1stHirCurrN1stCd = n1stHirCurrN1stCd;
	}
	
	/**
	 * Column Info
	 * @param piclbDesc
	 */
	public void setPiclbDesc(String piclbDesc) {
		this.piclbDesc = piclbDesc;
	}
	
	/**
	 * Column Info
	 * @param vslOwnIndCd
	 */
	public void setVslOwnIndCd(String vslOwnIndCd) {
		this.vslOwnIndCd = vslOwnIndCd;
	}
	
	/**
	 * Column Info
	 * @param frshWtrCsm
	 */
	public void setFrshWtrCsm(String frshWtrCsm) {
		this.frshWtrCsm = frshWtrCsm;
	}
	
	/**
	 * Column Info
	 * @param cntrDznCapa
	 */
	public void setCntrDznCapa(String cntrDznCapa) {
		this.cntrDznCapa = cntrDznCapa;
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
	 * @param fdrDivCd
	 */
	public void setFdrDivCd(String fdrDivCd) {
		this.fdrDivCd = fdrDivCd;
	}
	
	/**
	 * Column Info
	 * @param n1stHirRtN1stAmt
	 */
	public void setN1stHirRtN1stAmt(String n1stHirRtN1stAmt) {
		this.n1stHirRtN1stAmt = n1stHirRtN1stAmt;
	}
	
	/**
	 * Column Info
	 * @param faxNo
	 */
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}
	
	/**
	 * Column Info
	 * @param vslDeltOfcCd
	 */
	public void setVslDeltOfcCd(String vslDeltOfcCd) {
		this.vslDeltOfcCd = vslDeltOfcCd;
	}
	
	/**
	 * Column Info
	 * @param smrDrftHgt
	 */
	public void setSmrDrftHgt(String smrDrftHgt) {
		this.smrDrftHgt = smrDrftHgt;
	}
	
	/**
	 * Column Info
	 * @param bwthstBhpPwr
	 */
	public void setBwthstBhpPwr(String bwthstBhpPwr) {
		this.bwthstBhpPwr = bwthstBhpPwr;
	}
	
	/**
	 * Column Info
	 * @param vslEdiNm
	 */
	public void setVslEdiNm(String vslEdiNm) {
		this.vslEdiNm = vslEdiNm;
	}
	
	/**
	 * Column Info
	 * @param vslEml
	 */
	public void setVslEml(String vslEml) {
		this.vslEml = vslEml;
	}
	
	/**
	 * Column Info
	 * @param crrFullNm
	 */
	public void setCrrFullNm(String crrFullNm) {
		this.crrFullNm = crrFullNm;
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
	 * @param vslBldAreaNm
	 */
	public void setVslBldAreaNm(String vslBldAreaNm) {
		this.vslBldAreaNm = vslBldAreaNm;
	}
	
	/**
	 * Column Info
	 * @param mnEngMkrNm
	 */
	public void setMnEngMkrNm(String mnEngMkrNm) {
		this.mnEngMkrNm = mnEngMkrNm;
	}
	
	/**
	 * Column Info
	 * @param vslHtchKnt
	 */
	public void setVslHtchKnt(String vslHtchKnt) {
		this.vslHtchKnt = vslHtchKnt;
	}
	
	/**
	 * Column Info
	 * @param gnrBhpPwr
	 */
	public void setGnrBhpPwr(String gnrBhpPwr) {
		this.gnrBhpPwr = gnrBhpPwr;
	}
	
	/**
	 * Column Info
	 * @param cntNm
	 */
	public void setCntNm(String cntNm) {
		this.cntNm = cntNm;
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
	 * @param maxSpd
	 */
	public void setMaxSpd(String maxSpd) {
		this.maxSpd = maxSpd;
	}
	
	/**
	 * Column Info
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
	}
	
	/**
	 * Column Info
	 * @param vslRgstCntCd
	 */
	public void setVslRgstCntCd(String vslRgstCntCd) {
		this.vslRgstCntCd = vslRgstCntCd;
	}
	
	/**
	 * Column Info
	 * @param cntrPnmCapa
	 */
	public void setCntrPnmCapa(String cntrPnmCapa) {
		this.cntrPnmCapa = cntrPnmCapa;
	}
	
	/**
	 * Column Info
	 * @param n1stVndrSeq
	 */
	public void setN1stVndrSeq(String n1stVndrSeq) {
		this.n1stVndrSeq = n1stVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param n1stVndrNm
	 */
	public void setN1stVndrNm(String n1stVndrNm) {
		this.n1stVndrNm = n1stVndrNm;
	}
	
	/**
	 * Column Info
	 * @param gnrRpmPwr
	 */
	public void setGnrRpmPwr(String gnrRpmPwr) {
		this.gnrRpmPwr = gnrRpmPwr;
	}
	
	/**
	 * Column Info
	 * @param vslClssNo
	 */
	public void setVslClssNo(String vslClssNo) {
		this.vslClssNo = vslClssNo;
	}
	
	/**
	 * Column Info
	 * @param vslLoclNm
	 */
	public void setVslLoclNm(String vslLoclNm) {
		this.vslLoclNm = vslLoclNm;
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
	 * @param netRgstTongWgt
	 */
	public void setNetRgstTongWgt(String netRgstTongWgt) {
		this.netRgstTongWgt = netRgstTongWgt;
	}
	
	/**
	 * Column Info
	 * @param coCd
	 */
	public void setCoCd(String coCd) {
		this.coCd = coCd;
	}
	
	/**
	 * Column Info
	 * @param vslBldCd
	 */
	public void setVslBldCd(String vslBldCd) {
		this.vslBldCd = vslBldCd;
	}
	
	/**
	 * Column Info
	 * @param bwthstTpDesc
	 */
	public void setBwthstTpDesc(String bwthstTpDesc) {
		this.bwthstTpDesc = bwthstTpDesc;
	}
	
	/**
	 * Column Info
	 * @param n2ndEffDt
	 */
	public void setN2ndEffDt(String n2ndEffDt) {
		this.n2ndEffDt = n2ndEffDt;
	}
	
	/**
	 * Column Info
	 * @param ecnSpd
	 */
	public void setEcnSpd(String ecnSpd) {
		this.ecnSpd = ecnSpd;
	}
	
	/**
	 * Column Info
	 * @param eaiEvntDt
	 */
	public void setEaiEvntDt(String eaiEvntDt) {
		this.eaiEvntDt = eaiEvntDt;
	}
	
	/**
	 * Column Info
	 * @param mnEngBhpPwr
	 */
	public void setMnEngBhpPwr(String mnEngBhpPwr) {
		this.mnEngBhpPwr = mnEngBhpPwr;
	}
	
	/**
	 * Column Info
	 * @param vslKelLyDt
	 */
	public void setVslKelLyDt(String vslKelLyDt) {
		this.vslKelLyDt = vslKelLyDt;
	}
	
	/**
	 * Column Info
	 * @param cntrVslClssCapa
	 */
	public void setCntrVslClssCapa(String cntrVslClssCapa) {
		this.cntrVslClssCapa = cntrVslClssCapa;
	}
	
	/**
	 * Column Info
	 * @param intlTongCertiFlg
	 */
	public void setIntlTongCertiFlg(String intlTongCertiFlg) {
		this.intlTongCertiFlg = intlTongCertiFlg;
	}
	
	/**
	 * Column Info
	 * @param vslWdt
	 */
	public void setVslWdt(String vslWdt) {
		this.vslWdt = vslWdt;
	}
	
	/**
	 * Column Info
	 * @param vslSvcSpd
	 */
	public void setVslSvcSpd(String vslSvcSpd) {
		this.vslSvcSpd = vslSvcSpd;
	}
	
	/**
	 * Column Info
	 * @param gnrMkrNm
	 */
	public void setGnrMkrNm(String gnrMkrNm) {
		this.gnrMkrNm = gnrMkrNm;
	}
	
	/**
	 * Column Info
	 * @param mnEngTrKnt
	 */
	public void setMnEngTrKnt(String mnEngTrKnt) {
		this.mnEngTrKnt = mnEngTrKnt;
	}	
	
	/**
	 * Column Info
	 * @param gnrTrKnt
	 */
	public void setGnrTrKnt(String gnrTrKnt) {
		this.gnrTrKnt = gnrTrKnt;
	}	
	
	/**
	 * Column Info
	 * @param bwthstTrKnt
	 */
	public void setBwthstTrKnt(String bwthstTrKnt) {
		this.bwthstTrKnt = bwthstTrKnt;
	}	
	
	/**
	 * Column Info
	 * @param blkCrrTpCd
	 */
	public void setBlkCrrTpCd(String blkCrrTpCd) {
		this.blkCrrTpCd = blkCrrTpCd;
	}	

	/**
	 * Column Info
	 * @param blstWgtSpd1
	 */
	public void setBlstWgtSpd1(String blstWgtSpd1) {
		this.blstWgtSpd1 = blstWgtSpd1;
	}
	
	/**
	 * Column Info
	 * @param ctclRpmNo
	 */
	public void setCtclRpmNo(String ctclRpmNo) {
		this.ctclRpmNo = ctclRpmNo;
	}
	
	/**
	 * Column Info
	 * @param ctclToRpmNo
	 */
	public void setCtclToRpmNo(String ctclToRpmNo) {
		this.ctclToRpmNo = ctclToRpmNo;
	}
	
	/**
	 * Column Info
	 * @param foilBlstCsm2
	 */
	public void setFoilBlstCsm2(String foilBlstCsm2) {
		this.foilBlstCsm2 = foilBlstCsm2;
	}
	
	/**
	 * Column Info
	 * @param fuelSavEqFlg
	 */
	public void setFuelSavEqFlg(String fuelSavEqFlg) {
		this.fuelSavEqFlg = fuelSavEqFlg;
	}
	
	/**
	 * Column Info
	 * @param htchCvrInHldKnt
	 */
	public void setHtchCvrInHldKnt(String htchCvrInHldKnt) {
		this.htchCvrInHldKnt = htchCvrInHldKnt;
	}
	
	/**
	 * Column Info
	 * @param inHldPerRowKnt
	 */
	public void setInHldPerRowKnt(String inHldPerRowKnt) {
		this.inHldPerRowKnt = inHldPerRowKnt;
	}
	
	/**
	 * Column Info
	 * @param inHldPerTrKnt
	 */
	public void setInHldPerTrKnt(String inHldPerTrKnt) {
		this.inHldPerTrKnt = inHldPerTrKnt;
	}
	
	/**
	 * Column Info
	 * @param ldnWgtSpd1
	 */
	public void setLdnWgtSpd1(String ldnWgtSpd1) {
		this.ldnWgtSpd1 = ldnWgtSpd1;
	}
	
	/**
	 * Column Info
	 * @param onDeckPerRowKnt
	 */
	public void setOnDeckPerRowKnt(String onDeckPerRowKnt) {
		this.onDeckPerRowKnt = onDeckPerRowKnt;
	}
	
	/**
	 * Column Info
	 * @param onDeckPerTrKnt
	 */
	public void setOnDeckPerTrKnt(String onDeckPerTrKnt) {
		this.onDeckPerTrKnt = onDeckPerTrKnt;
	}
	
	/**
	 * Column Info
	 * @param opMinRpmNo
	 */
	public void setOpMinRpmNo(String opMinRpmNo) {
		this.opMinRpmNo = opMinRpmNo;
	}
	
	/**
	 * Column Info
	 * @param opMinSpd
	 */
	public void setOpMinSpd(String opMinSpd) {
		this.opMinSpd = opMinSpd;
	}
	
	/**
	 * Column Info
	 * @param portFoilTonCsm
	 */
	public void setPortFoilTonCsm(String portFoilTonCsm) {
		this.portFoilTonCsm = portFoilTonCsm;
	}
	
	/**
	 * Column Info
	 * @param portIdleDoilTonCsm
	 */
	public void setPortIdleDoilTonCsm(String portIdleDoilTonCsm) {
		this.portIdleDoilTonCsm = portIdleDoilTonCsm;
	}
	
	/**
	 * Column Info
	 * @param portWrkDoilTonCsm
	 */
	public void setPortWrkDoilTonCsm(String portWrkDoilTonCsm) {
		this.portWrkDoilTonCsm = portWrkDoilTonCsm;
	}
	
	/**
	 * Column Info
	 * @param slwStmngFlg
	 */
	public void setSlwStmngFlg(String slwStmngFlg) {
		this.slwStmngFlg = slwStmngFlg;
	}
	
	/**
	 * Column Info
	 * @param sprSlwStmngFlg
	 */
	public void setSprSlwStmngFlg(String sprSlwStmngFlg) {
		this.sprSlwStmngFlg = sprSlwStmngFlg;
	}
	
	/**
	 * Column Info
	 * @param tropDrftHgt
	 */
	public void setTropDrftHgt(String tropDrftHgt) {
		this.tropDrftHgt = tropDrftHgt;
	}
	
	/**
	 * Column Info
	 * @param tropDwtWgt
	 */
	public void setTropDwtWgt(String tropDwtWgt) {
		this.tropDwtWgt = tropDwtWgt;
	}
	
	/**
	 * Column Info
	 * @param vslLodRto
	 */
	public void setVslLodRto(String vslLodRto) {
		this.vslLodRto = vslLodRto;
	}
	
	/**
	 * Column Info
	 * @param wntDrftHgt
	 */
	public void setWntDrftHgt(String wntDrftHgt) {
		this.wntDrftHgt = wntDrftHgt;
	}
	
	/**
	 * Column Info
	 * @param wntDwtWgt
	 */
	public void setWntDwtWgt(String wntDwtWgt) {
		this.wntDrftHgt = wntDwtWgt;
	}
	
	/**
	 * Column Info
	 * @param pageNo
	 */
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	
	/**
	 * Column Info
	 * @param ampTpCd
	 */
	public void setAmpTpCd(String ampTpCd) {
		this.ampTpCd = ampTpCd;
	}
	
	/**
	 * VO Info
	 * @param MdmVslCntrExcelVO[] mdmVslCntrExcelVOs
	 */
	public void setMdmVslCntrExcelVOS(MdmVslCntrExcelVO[] mdmVslCntrExcelVOs) {
		this.mdmVslCntrExcelVOs = mdmVslCntrExcelVOs;
	}
	
	/**
	 * VO Info
	 * @param List<MdmVslCntrExcelVO> mdmVslCntrExcelVOl
	 */
	public void setMdmVslCntrExcelVOL(List<MdmVslCntrExcelVO> mdmVslCntrExcelVOl) {
		this.mdmVslCntrExcelVOl = mdmVslCntrExcelVOl;
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
		setBwthstRpmPwr(JSPUtil.getParameter(request, prefix + "bwthst_rpm_pwr", ""));
		setMnEngTpDesc(JSPUtil.getParameter(request, prefix + "mn_eng_tp_desc", ""));
		setVslDpth(JSPUtil.getParameter(request, prefix + "vsl_dpth", ""));
		setN2ndRmnDt(JSPUtil.getParameter(request, prefix + "n2nd_rmn_dt", ""));
		setN1stHirRtN2ndAmt(JSPUtil.getParameter(request, prefix + "n1st_hir_rt_n2nd_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setN2ndHirRtN2ndAmt(JSPUtil.getParameter(request, prefix + "n2nd_hir_rt_n2nd_amt", ""));
		setDplCapa(JSPUtil.getParameter(request, prefix + "dpl_capa", ""));
		setGnrTpDesc(JSPUtil.getParameter(request, prefix + "gnr_tp_desc", ""));
		setFbdCapa(JSPUtil.getParameter(request, prefix + "fbd_capa", ""));
		setVslHgt(JSPUtil.getParameter(request, prefix + "vsl_hgt", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setVslLodLineCertiExpDt(JSPUtil.getParameter(request, prefix + "vsl_lod_line_certi_exp_dt", ""));
		setVslSftRdoCertiExpDt(JSPUtil.getParameter(request, prefix + "vsl_sft_rdo_certi_exp_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setRgstDt(JSPUtil.getParameter(request, prefix + "rgst_dt", ""));
		setVslHldKnt(JSPUtil.getParameter(request, prefix + "vsl_hld_knt", ""));
		setRgstPortCd(JSPUtil.getParameter(request, prefix + "rgst_port_cd", ""));
		setLbpLen(JSPUtil.getParameter(request, prefix + "lbp_len", ""));
		setCallSgnNo(JSPUtil.getParameter(request, prefix + "call_sgn_no", ""));
		setN2ndHirRtN1stAmt(JSPUtil.getParameter(request, prefix + "n2nd_hir_rt_n1st_amt", ""));
		setClssNoRgstAreaNm(JSPUtil.getParameter(request, prefix + "clss_no_rgst_area_nm", ""));
		setGrsRgstTongWgt(JSPUtil.getParameter(request, prefix + "grs_rgst_tong_wgt", ""));
		setTlxNo(JSPUtil.getParameter(request, prefix + "tlx_no", ""));
		setRfRcptKnt(JSPUtil.getParameter(request, prefix + "rf_rcpt_knt", ""));
		setVslHlNo(JSPUtil.getParameter(request, prefix + "vsl_hl_no", ""));
		setLloydNo(JSPUtil.getParameter(request, prefix + "lloyd_no", ""));
		setSuzNetTongWgt(JSPUtil.getParameter(request, prefix + "suz_net_tong_wgt", ""));
		setPnmNetTongWgt(JSPUtil.getParameter(request, prefix + "pnm_net_tong_wgt", ""));
		setRgstNo(JSPUtil.getParameter(request, prefix + "rgst_no", ""));
		setN1stEffDt(JSPUtil.getParameter(request, prefix + "n1st_eff_dt", ""));
		setVslRmk(JSPUtil.getParameter(request, prefix + "vsl_rmk", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setN2ndHirCurrN2ndCd(JSPUtil.getParameter(request, prefix + "n2nd_hir_curr_n2nd_cd", ""));
		setN1stExpDt(JSPUtil.getParameter(request, prefix + "n1st_exp_dt", ""));
		setRfRcptMaxKnt(JSPUtil.getParameter(request, prefix + "rf_rcpt_max_knt", ""));
		setLoaLen(JSPUtil.getParameter(request, prefix + "loa_len", ""));
		setVslLnchDt(JSPUtil.getParameter(request, prefix + "vsl_lnch_dt", ""));
		setN2ndExpDt(JSPUtil.getParameter(request, prefix + "n2nd_exp_dt", ""));
		setVslBldrNm(JSPUtil.getParameter(request, prefix + "vsl_bldr_nm", ""));
		setCrwKnt(JSPUtil.getParameter(request, prefix + "crw_knt", ""));
		setVslCreOfcCd(JSPUtil.getParameter(request, prefix + "vsl_cre_ofc_cd", ""));
		setVslClssCd(JSPUtil.getParameter(request, prefix + "vsl_clss_cd", ""));
		setVslSftCstruCertiExpDt(JSPUtil.getParameter(request, prefix + "vsl_sft_cstru_certi_exp_dt", ""));
		setBlstTnkCapa(JSPUtil.getParameter(request, prefix + "blst_tnk_capa", ""));
		setVslKrnNm(JSPUtil.getParameter(request, prefix + "vsl_krn_nm", ""));
		setN1stHirCurrN2ndCd(JSPUtil.getParameter(request, prefix + "n1st_hir_curr_n2nd_cd", ""));
		setBwthstMkrNm(JSPUtil.getParameter(request, prefix + "bwthst_mkr_nm", ""));
		setPnmGtWgt(JSPUtil.getParameter(request, prefix + "pnm_gt_wgt", ""));
		setVslClzDt(JSPUtil.getParameter(request, prefix + "vsl_clz_dt", ""));
		setSuzGtWgt(JSPUtil.getParameter(request, prefix + "suz_gt_wgt", ""));
		setMadnVoySuzNetTongWgt(JSPUtil.getParameter(request, prefix + "madn_voy_suz_net_tong_wgt", ""));
		setLgtShpTongWgt(JSPUtil.getParameter(request, prefix + "lgt_shp_tong_wgt", ""));
		setMnEngKwPwr(JSPUtil.getParameter(request, prefix + "mn_eng_kw_pwr", ""));
		setFoilCapa(JSPUtil.getParameter(request, prefix + "foil_capa", ""));
		setVslDeratCertiExpDt(JSPUtil.getParameter(request, prefix + "vsl_derat_certi_exp_dt", ""));
		setTtlTeuKnt(JSPUtil.getParameter(request, prefix + "ttl_teu_knt", ""));
		setFoilCsm(JSPUtil.getParameter(request, prefix + "foil_csm", ""));
		setN2ndVndrNm(JSPUtil.getParameter(request, prefix + "n2nd_vndr_nm", ""));
		setDoilCsm(JSPUtil.getParameter(request, prefix + "doil_csm", ""));
		setVslDeDt(JSPUtil.getParameter(request, prefix + "vsl_de_dt", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setDwtWgt(JSPUtil.getParameter(request, prefix + "dwt_wgt", ""));
		setMnEngRpmPwr(JSPUtil.getParameter(request, prefix + "mn_eng_rpm_pwr", ""));
		setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
		setVslSftEqCertiExpDt(JSPUtil.getParameter(request, prefix + "vsl_sft_eq_certi_exp_dt", ""));
		setN1stRmnDt(JSPUtil.getParameter(request, prefix + "n1st_rmn_dt", ""));
		setDoilCapa(JSPUtil.getParameter(request, prefix + "doil_capa", ""));
		setN2ndHirCurrN1stCd(JSPUtil.getParameter(request, prefix + "n2nd_hir_curr_n1st_cd", ""));
		setVslType(JSPUtil.getParameter(request, prefix + "vsl_type", ""));
		setFrshWtrCapa(JSPUtil.getParameter(request, prefix + "frsh_wtr_capa", ""));
		setPhnNo(JSPUtil.getParameter(request, prefix + "phn_no", ""));
		setN2ndVndrSeq(JSPUtil.getParameter(request, prefix + "n2nd_vndr_seq", ""));
		setCntrOpCapa(JSPUtil.getParameter(request, prefix + "cntr_op_capa", ""));
		setN1stHirCurrN1stCd(JSPUtil.getParameter(request, prefix + "n1st_hir_curr_n1st_cd", ""));
		setPiclbDesc(JSPUtil.getParameter(request, prefix + "piclb_desc", ""));
		setVslOwnIndCd(JSPUtil.getParameter(request, prefix + "vsl_own_ind_cd", ""));
		setFrshWtrCsm(JSPUtil.getParameter(request, prefix + "frsh_wtr_csm", ""));
		setCntrDznCapa(JSPUtil.getParameter(request, prefix + "cntr_dzn_capa", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setFdrDivCd(JSPUtil.getParameter(request, prefix + "fdr_div_cd", ""));
		setN1stHirRtN1stAmt(JSPUtil.getParameter(request, prefix + "n1st_hir_rt_n1st_amt", ""));
		setFaxNo(JSPUtil.getParameter(request, prefix + "fax_no", ""));
		setVslDeltOfcCd(JSPUtil.getParameter(request, prefix + "vsl_delt_ofc_cd", ""));
		setSmrDrftHgt(JSPUtil.getParameter(request, prefix + "smr_drft_hgt", ""));
		setBwthstBhpPwr(JSPUtil.getParameter(request, prefix + "bwthst_bhp_pwr", ""));
		setVslEdiNm(JSPUtil.getParameter(request, prefix + "vsl_edi_nm", ""));
		setVslEml(JSPUtil.getParameter(request, prefix + "vsl_eml", ""));
		setCrrFullNm(JSPUtil.getParameter(request, prefix + "crr_full_nm", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setVslBldAreaNm(JSPUtil.getParameter(request, prefix + "vsl_bld_area_nm", ""));
		setMnEngMkrNm(JSPUtil.getParameter(request, prefix + "mn_eng_mkr_nm", ""));
		setVslHtchKnt(JSPUtil.getParameter(request, prefix + "vsl_htch_knt", ""));
		setGnrBhpPwr(JSPUtil.getParameter(request, prefix + "gnr_bhp_pwr", ""));
		setCntNm(JSPUtil.getParameter(request, prefix + "cnt_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMaxSpd(JSPUtil.getParameter(request, prefix + "max_spd", ""));
		setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
		setVslRgstCntCd(JSPUtil.getParameter(request, prefix + "vsl_rgst_cnt_cd", ""));
		setCntrPnmCapa(JSPUtil.getParameter(request, prefix + "cntr_pnm_capa", ""));
		setN1stVndrSeq(JSPUtil.getParameter(request, prefix + "n1st_vndr_seq", ""));
		setN1stVndrNm(JSPUtil.getParameter(request, prefix + "n1st_vndr_nm", ""));
		setGnrRpmPwr(JSPUtil.getParameter(request, prefix + "gnr_rpm_pwr", ""));
		setVslClssNo(JSPUtil.getParameter(request, prefix + "vsl_clss_no", ""));
		setVslLoclNm(JSPUtil.getParameter(request, prefix + "vsl_locl_nm", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setNetRgstTongWgt(JSPUtil.getParameter(request, prefix + "net_rgst_tong_wgt", ""));
		setCoCd(JSPUtil.getParameter(request, prefix + "co_cd", ""));
		setVslBldCd(JSPUtil.getParameter(request, prefix + "vsl_bld_cd", ""));
		setBwthstTpDesc(JSPUtil.getParameter(request, prefix + "bwthst_tp_desc", ""));
		setN2ndEffDt(JSPUtil.getParameter(request, prefix + "n2nd_eff_dt", ""));
		setEcnSpd(JSPUtil.getParameter(request, prefix + "ecn_spd", ""));
		setEaiEvntDt(JSPUtil.getParameter(request, prefix + "eai_evnt_dt", ""));
		setMnEngBhpPwr(JSPUtil.getParameter(request, prefix + "mn_eng_bhp_pwr", ""));
		setVslKelLyDt(JSPUtil.getParameter(request, prefix + "vsl_kel_ly_dt", ""));
		setCntrVslClssCapa(JSPUtil.getParameter(request, prefix + "cntr_vsl_clss_capa", ""));
		setIntlTongCertiFlg(JSPUtil.getParameter(request, prefix + "intl_tong_certi_flg", ""));
		setVslWdt(JSPUtil.getParameter(request, prefix + "vsl_wdt", ""));
		setVslSvcSpd(JSPUtil.getParameter(request, prefix + "vsl_svc_spd", ""));
		setGnrMkrNm(JSPUtil.getParameter(request, prefix + "gnr_mkr_nm", ""));
		setMnEngTrKnt(JSPUtil.getParameter(request, prefix + "mn_eng_tr_knt", ""));
		setGnrTrKnt(JSPUtil.getParameter(request, prefix + "gnr_tr_knt", ""));
		setBwthstTrKnt(JSPUtil.getParameter(request, prefix + "bwthst_tr_knt", ""));
		setBlkCrrTpCd(JSPUtil.getParameter(request, prefix + "blk_crr_tp_cd", ""));
		setBlstWgtSpd1(JSPUtil.getParameter(request, prefix + "blst_wgt_spd1", ""));
		setCtclRpmNo(JSPUtil.getParameter(request, prefix + "ctcl_rpm_no", ""));
		setCtclToRpmNo(JSPUtil.getParameter(request, prefix + "ctcl_to_rpm_no", ""));
		setFoilBlstCsm2(JSPUtil.getParameter(request, prefix + "foil_blst_csm2", ""));
		setFuelSavEqFlg(JSPUtil.getParameter(request, prefix + "fuel_sav_eq_flg", ""));
		setHtchCvrInHldKnt(JSPUtil.getParameter(request, prefix + "htch_cvr_in_hld_knt", ""));
		setInHldPerRowKnt(JSPUtil.getParameter(request, prefix + "in_hld_per_row_knt", ""));
		setInHldPerTrKnt(JSPUtil.getParameter(request, prefix + "in_hld_per_tr_knt", ""));
		setLdnWgtSpd1(JSPUtil.getParameter(request, prefix + "ldn_wgt_spd1", ""));
		setOnDeckPerRowKnt(JSPUtil.getParameter(request, prefix + "on_deck_per_row_knt", ""));
		setOnDeckPerTrKnt(JSPUtil.getParameter(request, prefix + "on_deck_per_tr_knt", ""));
		setOpMinRpmNo(JSPUtil.getParameter(request, prefix + "op_min_rpm_no", ""));
		setOpMinSpd(JSPUtil.getParameter(request, prefix + "op_min_spd", ""));
		setPortFoilTonCsm(JSPUtil.getParameter(request, prefix + "port_foil_ton_csm", ""));
		setPortIdleDoilTonCsm(JSPUtil.getParameter(request, prefix + "port_idle_doil_ton_csm", ""));
		setPortWrkDoilTonCsm(JSPUtil.getParameter(request, prefix + "port_wrk_doil_ton_csm", ""));
		setSlwStmngFlg(JSPUtil.getParameter(request, prefix + "slw_stmng_flg", ""));
		setSprSlwStmngFlg(JSPUtil.getParameter(request, prefix + "spr_slw_stmng_flg", ""));
		setTropDrftHgt(JSPUtil.getParameter(request, prefix + "trop_drft_hgt", ""));
		setTropDwtWgt(JSPUtil.getParameter(request, prefix + "trop_dwt_wgt", ""));
		setVslLodRto(JSPUtil.getParameter(request, prefix + "vsl_lod_rto", ""));
		setWntDrftHgt(JSPUtil.getParameter(request, prefix + "wnt_drft_hgt", ""));
		setWntDwtWgt(JSPUtil.getParameter(request, prefix + "wnt_dwt_wgt", ""));
		setPageNo(JSPUtil.getParameter(request, prefix + "page_no", ""));
		setAmpTpCd(JSPUtil.getParameter(request, prefix + "amp_tp_cd", ""));

	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VSLPartIVO[]
	 */
	public VSLPartIVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VSLPartIVO[]
	 */
	public VSLPartIVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VSLPartIVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bwthstRpmPwr = (JSPUtil.getParameter(request, prefix	+ "bwthst_rpm_pwr", length));
			String[] mnEngTpDesc = (JSPUtil.getParameter(request, prefix	+ "mn_eng_tp_desc", length));
			String[] vslDpth = (JSPUtil.getParameter(request, prefix	+ "vsl_dpth", length));
			String[] n2ndRmnDt = (JSPUtil.getParameter(request, prefix	+ "n2nd_rmn_dt", length));
			String[] n1stHirRtN2ndAmt = (JSPUtil.getParameter(request, prefix	+ "n1st_hir_rt_n2nd_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] n2ndHirRtN2ndAmt = (JSPUtil.getParameter(request, prefix	+ "n2nd_hir_rt_n2nd_amt", length));
			String[] dplCapa = (JSPUtil.getParameter(request, prefix	+ "dpl_capa", length));
			String[] gnrTpDesc = (JSPUtil.getParameter(request, prefix	+ "gnr_tp_desc", length));
			String[] fbdCapa = (JSPUtil.getParameter(request, prefix	+ "fbd_capa", length));
			String[] vslHgt = (JSPUtil.getParameter(request, prefix	+ "vsl_hgt", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] vslLodLineCertiExpDt = (JSPUtil.getParameter(request, prefix	+ "vsl_lod_line_certi_exp_dt", length));
			String[] vslSftRdoCertiExpDt = (JSPUtil.getParameter(request, prefix	+ "vsl_sft_rdo_certi_exp_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] rgstDt = (JSPUtil.getParameter(request, prefix	+ "rgst_dt", length));
			String[] vslHldKnt = (JSPUtil.getParameter(request, prefix	+ "vsl_hld_knt", length));
			String[] rgstPortCd = (JSPUtil.getParameter(request, prefix	+ "rgst_port_cd", length));
			String[] lbpLen = (JSPUtil.getParameter(request, prefix	+ "lbp_len", length));
			String[] callSgnNo = (JSPUtil.getParameter(request, prefix	+ "call_sgn_no", length));
			String[] n2ndHirRtN1stAmt = (JSPUtil.getParameter(request, prefix	+ "n2nd_hir_rt_n1st_amt", length));
			String[] clssNoRgstAreaNm = (JSPUtil.getParameter(request, prefix	+ "clss_no_rgst_area_nm", length));
			String[] grsRgstTongWgt = (JSPUtil.getParameter(request, prefix	+ "grs_rgst_tong_wgt", length));
			String[] tlxNo = (JSPUtil.getParameter(request, prefix	+ "tlx_no", length));
			String[] rfRcptKnt = (JSPUtil.getParameter(request, prefix	+ "rf_rcpt_knt", length));
			String[] vslHlNo = (JSPUtil.getParameter(request, prefix	+ "vsl_hl_no", length));
			String[] lloydNo = (JSPUtil.getParameter(request, prefix	+ "lloyd_no", length));
			String[] suzNetTongWgt = (JSPUtil.getParameter(request, prefix	+ "suz_net_tong_wgt", length));
			String[] pnmNetTongWgt = (JSPUtil.getParameter(request, prefix	+ "pnm_net_tong_wgt", length));
			String[] rgstNo = (JSPUtil.getParameter(request, prefix	+ "rgst_no", length));
			String[] n1stEffDt = (JSPUtil.getParameter(request, prefix	+ "n1st_eff_dt", length));
			String[] vslRmk = (JSPUtil.getParameter(request, prefix	+ "vsl_rmk", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] n2ndHirCurrN2ndCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_hir_curr_n2nd_cd", length));
			String[] n1stExpDt = (JSPUtil.getParameter(request, prefix	+ "n1st_exp_dt", length));
			String[] rfRcptMaxKnt = (JSPUtil.getParameter(request, prefix	+ "rf_rcpt_max_knt", length));
			String[] loaLen = (JSPUtil.getParameter(request, prefix	+ "loa_len", length));
			String[] vslLnchDt = (JSPUtil.getParameter(request, prefix	+ "vsl_lnch_dt", length));
			String[] n2ndExpDt = (JSPUtil.getParameter(request, prefix	+ "n2nd_exp_dt", length));
			String[] vslBldrNm = (JSPUtil.getParameter(request, prefix	+ "vsl_bldr_nm", length));
			String[] crwKnt = (JSPUtil.getParameter(request, prefix	+ "crw_knt", length));
			String[] vslCreOfcCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cre_ofc_cd", length));
			String[] vslClssCd = (JSPUtil.getParameter(request, prefix	+ "vsl_clss_cd", length));
			String[] vslSftCstruCertiExpDt = (JSPUtil.getParameter(request, prefix	+ "vsl_sft_cstru_certi_exp_dt", length));
			String[] blstTnkCapa = (JSPUtil.getParameter(request, prefix	+ "blst_tnk_capa", length));
			String[] vslKrnNm = (JSPUtil.getParameter(request, prefix	+ "vsl_krn_nm", length));
			String[] n1stHirCurrN2ndCd = (JSPUtil.getParameter(request, prefix	+ "n1st_hir_curr_n2nd_cd", length));
			String[] bwthstMkrNm = (JSPUtil.getParameter(request, prefix	+ "bwthst_mkr_nm", length));
			String[] pnmGtWgt = (JSPUtil.getParameter(request, prefix	+ "pnm_gt_wgt", length));
			String[] vslClzDt = (JSPUtil.getParameter(request, prefix	+ "vsl_clz_dt", length));
			String[] suzGtWgt = (JSPUtil.getParameter(request, prefix	+ "suz_gt_wgt", length));
			String[] madnVoySuzNetTongWgt = (JSPUtil.getParameter(request, prefix	+ "madn_voy_suz_net_tong_wgt", length));
			String[] lgtShpTongWgt = (JSPUtil.getParameter(request, prefix	+ "lgt_shp_tong_wgt", length));
			String[] mnEngKwPwr = (JSPUtil.getParameter(request, prefix	+ "mn_eng_kw_pwr", length));
			String[] foilCapa = (JSPUtil.getParameter(request, prefix	+ "foil_capa", length));
			String[] vslDeratCertiExpDt = (JSPUtil.getParameter(request, prefix	+ "vsl_derat_certi_exp_dt", length));
			String[] ttlTeuKnt = (JSPUtil.getParameter(request, prefix	+ "ttl_teu_knt", length));
			String[] foilCsm = (JSPUtil.getParameter(request, prefix	+ "foil_csm", length));
			String[] n2ndVndrNm = (JSPUtil.getParameter(request, prefix	+ "n2nd_vndr_nm", length));
			String[] doilCsm = (JSPUtil.getParameter(request, prefix	+ "doil_csm", length));
			String[] vslDeDt = (JSPUtil.getParameter(request, prefix	+ "vsl_de_dt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] dwtWgt = (JSPUtil.getParameter(request, prefix	+ "dwt_wgt", length));
			String[] mnEngRpmPwr = (JSPUtil.getParameter(request, prefix	+ "mn_eng_rpm_pwr", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] vslSftEqCertiExpDt = (JSPUtil.getParameter(request, prefix	+ "vsl_sft_eq_certi_exp_dt", length));
			String[] n1stRmnDt = (JSPUtil.getParameter(request, prefix	+ "n1st_rmn_dt", length));
			String[] doilCapa = (JSPUtil.getParameter(request, prefix	+ "doil_capa", length));
			String[] n2ndHirCurrN1stCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_hir_curr_n1st_cd", length));
			String[] vslType = (JSPUtil.getParameter(request, prefix	+ "vsl_type", length));
			String[] frshWtrCapa = (JSPUtil.getParameter(request, prefix	+ "frsh_wtr_capa", length));
			String[] phnNo = (JSPUtil.getParameter(request, prefix	+ "phn_no", length));
			String[] n2ndVndrSeq = (JSPUtil.getParameter(request, prefix	+ "n2nd_vndr_seq", length));
			String[] cntrOpCapa = (JSPUtil.getParameter(request, prefix	+ "cntr_op_capa", length));
			String[] n1stHirCurrN1stCd = (JSPUtil.getParameter(request, prefix	+ "n1st_hir_curr_n1st_cd", length));
			String[] piclbDesc = (JSPUtil.getParameter(request, prefix	+ "piclb_desc", length));
			String[] vslOwnIndCd = (JSPUtil.getParameter(request, prefix	+ "vsl_own_ind_cd", length));
			String[] frshWtrCsm = (JSPUtil.getParameter(request, prefix	+ "frsh_wtr_csm", length));
			String[] cntrDznCapa = (JSPUtil.getParameter(request, prefix	+ "cntr_dzn_capa", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] fdrDivCd = (JSPUtil.getParameter(request, prefix	+ "fdr_div_cd", length));
			String[] n1stHirRtN1stAmt = (JSPUtil.getParameter(request, prefix	+ "n1st_hir_rt_n1st_amt", length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no", length));
			String[] vslDeltOfcCd = (JSPUtil.getParameter(request, prefix	+ "vsl_delt_ofc_cd", length));
			String[] smrDrftHgt = (JSPUtil.getParameter(request, prefix	+ "smr_drft_hgt", length));
			String[] bwthstBhpPwr = (JSPUtil.getParameter(request, prefix	+ "bwthst_bhp_pwr", length));
			String[] vslEdiNm = (JSPUtil.getParameter(request, prefix	+ "vsl_edi_nm", length));
			String[] vslEml = (JSPUtil.getParameter(request, prefix	+ "vsl_eml", length));
			String[] crrFullNm = (JSPUtil.getParameter(request, prefix	+ "crr_full_nm", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] vslBldAreaNm = (JSPUtil.getParameter(request, prefix	+ "vsl_bld_area_nm", length));
			String[] mnEngMkrNm = (JSPUtil.getParameter(request, prefix	+ "mn_eng_mkr_nm", length));
			String[] vslHtchKnt = (JSPUtil.getParameter(request, prefix	+ "vsl_htch_knt", length));
			String[] gnrBhpPwr = (JSPUtil.getParameter(request, prefix	+ "gnr_bhp_pwr", length));
			String[] cntNm = (JSPUtil.getParameter(request, prefix	+ "cnt_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] maxSpd = (JSPUtil.getParameter(request, prefix	+ "max_spd", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] vslRgstCntCd = (JSPUtil.getParameter(request, prefix	+ "vsl_rgst_cnt_cd", length));
			String[] cntrPnmCapa = (JSPUtil.getParameter(request, prefix	+ "cntr_pnm_capa", length));
			String[] n1stVndrSeq = (JSPUtil.getParameter(request, prefix	+ "n1st_vndr_seq", length));
			String[] n1stVndrNm = (JSPUtil.getParameter(request, prefix	+ "n1st_vndr_nm", length));
			String[] gnrRpmPwr = (JSPUtil.getParameter(request, prefix	+ "gnr_rpm_pwr", length));
			String[] vslClssNo = (JSPUtil.getParameter(request, prefix	+ "vsl_clss_no", length));
			String[] vslLoclNm = (JSPUtil.getParameter(request, prefix	+ "vsl_locl_nm", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] netRgstTongWgt = (JSPUtil.getParameter(request, prefix	+ "net_rgst_tong_wgt", length));
			String[] coCd = (JSPUtil.getParameter(request, prefix	+ "co_cd", length));
			String[] vslBldCd = (JSPUtil.getParameter(request, prefix	+ "vsl_bld_cd", length));
			String[] bwthstTpDesc = (JSPUtil.getParameter(request, prefix	+ "bwthst_tp_desc", length));
			String[] n2ndEffDt = (JSPUtil.getParameter(request, prefix	+ "n2nd_eff_dt", length));
			String[] ecnSpd = (JSPUtil.getParameter(request, prefix	+ "ecn_spd", length));
			String[] eaiEvntDt = (JSPUtil.getParameter(request, prefix	+ "eai_evnt_dt", length));
			String[] mnEngBhpPwr = (JSPUtil.getParameter(request, prefix	+ "mn_eng_bhp_pwr", length));
			String[] vslKelLyDt = (JSPUtil.getParameter(request, prefix	+ "vsl_kel_ly_dt", length));
			String[] cntrVslClssCapa = (JSPUtil.getParameter(request, prefix	+ "cntr_vsl_clss_capa", length));
			String[] intlTongCertiFlg = (JSPUtil.getParameter(request, prefix	+ "intl_tong_certi_flg", length));
			String[] vslWdt = (JSPUtil.getParameter(request, prefix	+ "vsl_wdt", length));
			String[] vslSvcSpd = (JSPUtil.getParameter(request, prefix	+ "vsl_svc_spd", length));
			String[] gnrMkrNm = (JSPUtil.getParameter(request, prefix	+ "gnr_mkr_nm", length));
			String[] mnEngTrKnt = (JSPUtil.getParameter(request, prefix	+ "mn_eng_tr_knt", length));	
			String[] gnrTrKnt = (JSPUtil.getParameter(request, prefix	+ "gnr_tr_knt", length));	
			String[] bwthstTrKnt = (JSPUtil.getParameter(request, prefix	+ "bwthst_tr_knt", length));	
			String[] blkCrrTpCd           = (JSPUtil.getParameter(request, prefix    + "blk_crr_tp_cd", length));
			String[] blstWgtSpd1          = (JSPUtil.getParameter(request, prefix    + "blst_wgt_spd1", length));
			String[] ctclRpmNo            = (JSPUtil.getParameter(request, prefix    + "ctcl_rpm_no", length));
			String[] ctclToRpmNo          = (JSPUtil.getParameter(request, prefix    + "ctcl_to_rpm_no", length));
			String[] foilBlstCsm2         = (JSPUtil.getParameter(request, prefix    + "foil_blst_csm2", length));
			String[] fuelSavEqFlg         = (JSPUtil.getParameter(request, prefix    + "fuel_sav_eq_flg", length));
			String[] htchCvrInHldKnt      = (JSPUtil.getParameter(request, prefix    + "htch_cvr_in_hld_knt", length));
			String[] inHldPerRowKnt       = (JSPUtil.getParameter(request, prefix    + "in_hld_per_row_knt", length));
			String[] inHldPerTrKnt        = (JSPUtil.getParameter(request, prefix    + "in_hld_per_tr_knt", length));
			String[] ldnWgtSpd1           = (JSPUtil.getParameter(request, prefix    + "ldn_wgt_spd1", length));
			String[] onDeckPerRowKnt      = (JSPUtil.getParameter(request, prefix    + "on_deck_per_row_knt", length));
			String[] onDeckPerTrKnt       = (JSPUtil.getParameter(request, prefix    + "on_deck_per_tr_knt", length));
			String[] opMinRpmNo           = (JSPUtil.getParameter(request, prefix    + "op_min_rpm_no", length));
			String[] opMinSpd             = (JSPUtil.getParameter(request, prefix    + "op_min_spd", length));
			String[] portFoilTonCsm       = (JSPUtil.getParameter(request, prefix    + "port_foil_ton_csm", length));
			String[] portIdleDoilTonCsm   = (JSPUtil.getParameter(request, prefix    + "port_idle_doil_ton_csm", length));
			String[] portWrkDoilTonCsm    = (JSPUtil.getParameter(request, prefix    + "port_wrk_doil_ton_csm", length));
			String[] slwStmngFlg          = (JSPUtil.getParameter(request, prefix    + "slw_stmng_flg", length));
			String[] sprSlwStmngFlg       = (JSPUtil.getParameter(request, prefix    + "spr_slw_stmng_flg", length));
			String[] tropDrftHgt          = (JSPUtil.getParameter(request, prefix    + "trop_drft_hgt", length));
			String[] tropDwtWgt           = (JSPUtil.getParameter(request, prefix    + "trop_dwt_wgt", length));
			String[] vslLodRto            = (JSPUtil.getParameter(request, prefix    + "vsl_lod_rto", length));
			String[] wntDrftHgt           = (JSPUtil.getParameter(request, prefix    + "wnt_drft_hgt", length));
			String[] wntDwtWgt            = (JSPUtil.getParameter(request, prefix    + "wnt_dwt_wgt", length));
			String[] pageNo		          = (JSPUtil.getParameter(request, prefix    + "page_no", length));
			String[] ampTpCd	          = (JSPUtil.getParameter(request, prefix    + "amp_tp_cd", length));

			
			for (int i = 0; i < length; i++) {
				model = new VSLPartIVO();
				if (bwthstRpmPwr[i] != null)
					model.setBwthstRpmPwr(bwthstRpmPwr[i]);
				if (mnEngTpDesc[i] != null)
					model.setMnEngTpDesc(mnEngTpDesc[i]);
				if (vslDpth[i] != null)
					model.setVslDpth(vslDpth[i]);
				if (n2ndRmnDt[i] != null)
					model.setN2ndRmnDt(n2ndRmnDt[i]);
				if (n1stHirRtN2ndAmt[i] != null)
					model.setN1stHirRtN2ndAmt(n1stHirRtN2ndAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (n2ndHirRtN2ndAmt[i] != null)
					model.setN2ndHirRtN2ndAmt(n2ndHirRtN2ndAmt[i]);
				if (dplCapa[i] != null)
					model.setDplCapa(dplCapa[i]);
				if (gnrTpDesc[i] != null)
					model.setGnrTpDesc(gnrTpDesc[i]);
				if (fbdCapa[i] != null)
					model.setFbdCapa(fbdCapa[i]);
				if (vslHgt[i] != null)
					model.setVslHgt(vslHgt[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (vslLodLineCertiExpDt[i] != null)
					model.setVslLodLineCertiExpDt(vslLodLineCertiExpDt[i]);
				if (vslSftRdoCertiExpDt[i] != null)
					model.setVslSftRdoCertiExpDt(vslSftRdoCertiExpDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (rgstDt[i] != null)
					model.setRgstDt(rgstDt[i]);
				if (vslHldKnt[i] != null)
					model.setVslHldKnt(vslHldKnt[i]);
				if (rgstPortCd[i] != null)
					model.setRgstPortCd(rgstPortCd[i]);
				if (lbpLen[i] != null)
					model.setLbpLen(lbpLen[i]);
				if (callSgnNo[i] != null)
					model.setCallSgnNo(callSgnNo[i]);
				if (n2ndHirRtN1stAmt[i] != null)
					model.setN2ndHirRtN1stAmt(n2ndHirRtN1stAmt[i]);
				if (clssNoRgstAreaNm[i] != null)
					model.setClssNoRgstAreaNm(clssNoRgstAreaNm[i]);
				if (grsRgstTongWgt[i] != null)
					model.setGrsRgstTongWgt(grsRgstTongWgt[i]);
				if (tlxNo[i] != null)
					model.setTlxNo(tlxNo[i]);
				if (rfRcptKnt[i] != null)
					model.setRfRcptKnt(rfRcptKnt[i]);
				if (vslHlNo[i] != null)
					model.setVslHlNo(vslHlNo[i]);
				if (lloydNo[i] != null)
					model.setLloydNo(lloydNo[i]);
				if (suzNetTongWgt[i] != null)
					model.setSuzNetTongWgt(suzNetTongWgt[i]);
				if (pnmNetTongWgt[i] != null)
					model.setPnmNetTongWgt(pnmNetTongWgt[i]);
				if (rgstNo[i] != null)
					model.setRgstNo(rgstNo[i]);
				if (n1stEffDt[i] != null)
					model.setN1stEffDt(n1stEffDt[i]);
				if (vslRmk[i] != null)
					model.setVslRmk(vslRmk[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (n2ndHirCurrN2ndCd[i] != null)
					model.setN2ndHirCurrN2ndCd(n2ndHirCurrN2ndCd[i]);
				if (n1stExpDt[i] != null)
					model.setN1stExpDt(n1stExpDt[i]);
				if (rfRcptMaxKnt[i] != null)
					model.setRfRcptMaxKnt(rfRcptMaxKnt[i]);
				if (loaLen[i] != null)
					model.setLoaLen(loaLen[i]);
				if (vslLnchDt[i] != null)
					model.setVslLnchDt(vslLnchDt[i]);
				if (n2ndExpDt[i] != null)
					model.setN2ndExpDt(n2ndExpDt[i]);
				if (vslBldrNm[i] != null)
					model.setVslBldrNm(vslBldrNm[i]);
				if (crwKnt[i] != null)
					model.setCrwKnt(crwKnt[i]);
				if (vslCreOfcCd[i] != null)
					model.setVslCreOfcCd(vslCreOfcCd[i]);
				if (vslClssCd[i] != null)
					model.setVslClssCd(vslClssCd[i]);
				if (vslSftCstruCertiExpDt[i] != null)
					model.setVslSftCstruCertiExpDt(vslSftCstruCertiExpDt[i]);
				if (blstTnkCapa[i] != null)
					model.setBlstTnkCapa(blstTnkCapa[i]);
				if (vslKrnNm[i] != null)
					model.setVslKrnNm(vslKrnNm[i]);
				if (n1stHirCurrN2ndCd[i] != null)
					model.setN1stHirCurrN2ndCd(n1stHirCurrN2ndCd[i]);
				if (bwthstMkrNm[i] != null)
					model.setBwthstMkrNm(bwthstMkrNm[i]);
				if (pnmGtWgt[i] != null)
					model.setPnmGtWgt(pnmGtWgt[i]);
				if (vslClzDt[i] != null)
					model.setVslClzDt(vslClzDt[i]);
				if (suzGtWgt[i] != null)
					model.setSuzGtWgt(suzGtWgt[i]);
				if (madnVoySuzNetTongWgt[i] != null)
					model.setMadnVoySuzNetTongWgt(madnVoySuzNetTongWgt[i]);
				if (lgtShpTongWgt[i] != null)
					model.setLgtShpTongWgt(lgtShpTongWgt[i]);
				if (mnEngKwPwr[i] != null)
					model.setMnEngKwPwr(mnEngKwPwr[i]);
				if (foilCapa[i] != null)
					model.setFoilCapa(foilCapa[i]);
				if (vslDeratCertiExpDt[i] != null)
					model.setVslDeratCertiExpDt(vslDeratCertiExpDt[i]);
				if (ttlTeuKnt[i] != null)
					model.setTtlTeuKnt(ttlTeuKnt[i]);
				if (foilCsm[i] != null)
					model.setFoilCsm(foilCsm[i]);
				if (n2ndVndrNm[i] != null)
					model.setN2ndVndrNm(n2ndVndrNm[i]);
				if (doilCsm[i] != null)
					model.setDoilCsm(doilCsm[i]);
				if (vslDeDt[i] != null)
					model.setVslDeDt(vslDeDt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (dwtWgt[i] != null)
					model.setDwtWgt(dwtWgt[i]);
				if (mnEngRpmPwr[i] != null)
					model.setMnEngRpmPwr(mnEngRpmPwr[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (vslSftEqCertiExpDt[i] != null)
					model.setVslSftEqCertiExpDt(vslSftEqCertiExpDt[i]);
				if (n1stRmnDt[i] != null)
					model.setN1stRmnDt(n1stRmnDt[i]);
				if (doilCapa[i] != null)
					model.setDoilCapa(doilCapa[i]);
				if (n2ndHirCurrN1stCd[i] != null)
					model.setN2ndHirCurrN1stCd(n2ndHirCurrN1stCd[i]);
				if (vslType[i] != null)
					model.setVslType(vslType[i]);
				if (frshWtrCapa[i] != null)
					model.setFrshWtrCapa(frshWtrCapa[i]);
				if (phnNo[i] != null)
					model.setPhnNo(phnNo[i]);
				if (n2ndVndrSeq[i] != null)
					model.setN2ndVndrSeq(n2ndVndrSeq[i]);
				if (cntrOpCapa[i] != null)
					model.setCntrOpCapa(cntrOpCapa[i]);
				if (n1stHirCurrN1stCd[i] != null)
					model.setN1stHirCurrN1stCd(n1stHirCurrN1stCd[i]);
				if (piclbDesc[i] != null)
					model.setPiclbDesc(piclbDesc[i]);
				if (vslOwnIndCd[i] != null)
					model.setVslOwnIndCd(vslOwnIndCd[i]);
				if (frshWtrCsm[i] != null)
					model.setFrshWtrCsm(frshWtrCsm[i]);
				if (cntrDznCapa[i] != null)
					model.setCntrDznCapa(cntrDznCapa[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (fdrDivCd[i] != null)
					model.setFdrDivCd(fdrDivCd[i]);
				if (n1stHirRtN1stAmt[i] != null)
					model.setN1stHirRtN1stAmt(n1stHirRtN1stAmt[i]);
				if (faxNo[i] != null)
					model.setFaxNo(faxNo[i]);
				if (vslDeltOfcCd[i] != null)
					model.setVslDeltOfcCd(vslDeltOfcCd[i]);
				if (smrDrftHgt[i] != null)
					model.setSmrDrftHgt(smrDrftHgt[i]);
				if (bwthstBhpPwr[i] != null)
					model.setBwthstBhpPwr(bwthstBhpPwr[i]);
				if (vslEdiNm[i] != null)
					model.setVslEdiNm(vslEdiNm[i]);
				if (vslEml[i] != null)
					model.setVslEml(vslEml[i]);
				if (crrFullNm[i] != null)
					model.setCrrFullNm(crrFullNm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (vslBldAreaNm[i] != null)
					model.setVslBldAreaNm(vslBldAreaNm[i]);
				if (mnEngMkrNm[i] != null)
					model.setMnEngMkrNm(mnEngMkrNm[i]);
				if (vslHtchKnt[i] != null)
					model.setVslHtchKnt(vslHtchKnt[i]);
				if (gnrBhpPwr[i] != null)
					model.setGnrBhpPwr(gnrBhpPwr[i]);
				if (cntNm[i] != null)
					model.setCntNm(cntNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (maxSpd[i] != null)
					model.setMaxSpd(maxSpd[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (vslRgstCntCd[i] != null)
					model.setVslRgstCntCd(vslRgstCntCd[i]);
				if (cntrPnmCapa[i] != null)
					model.setCntrPnmCapa(cntrPnmCapa[i]);
				if (n1stVndrSeq[i] != null)
					model.setN1stVndrSeq(n1stVndrSeq[i]);
				if (n1stVndrNm[i] != null)
					model.setN1stVndrNm(n1stVndrNm[i]);
				if (gnrRpmPwr[i] != null)
					model.setGnrRpmPwr(gnrRpmPwr[i]);
				if (vslClssNo[i] != null)
					model.setVslClssNo(vslClssNo[i]);
				if (vslLoclNm[i] != null)
					model.setVslLoclNm(vslLoclNm[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (netRgstTongWgt[i] != null)
					model.setNetRgstTongWgt(netRgstTongWgt[i]);
				if (coCd[i] != null)
					model.setCoCd(coCd[i]);
				if (vslBldCd[i] != null)
					model.setVslBldCd(vslBldCd[i]);
				if (bwthstTpDesc[i] != null)
					model.setBwthstTpDesc(bwthstTpDesc[i]);
				if (n2ndEffDt[i] != null)
					model.setN2ndEffDt(n2ndEffDt[i]);
				if (ecnSpd[i] != null)
					model.setEcnSpd(ecnSpd[i]);
				if (eaiEvntDt[i] != null)
					model.setEaiEvntDt(eaiEvntDt[i]);
				if (mnEngBhpPwr[i] != null)
					model.setMnEngBhpPwr(mnEngBhpPwr[i]);
				if (vslKelLyDt[i] != null)
					model.setVslKelLyDt(vslKelLyDt[i]);
				if (cntrVslClssCapa[i] != null)
					model.setCntrVslClssCapa(cntrVslClssCapa[i]);
				if (intlTongCertiFlg[i] != null)
					model.setIntlTongCertiFlg(intlTongCertiFlg[i]);
				if (vslWdt[i] != null)
					model.setVslWdt(vslWdt[i]);
				if (vslSvcSpd[i] != null)
					model.setVslSvcSpd(vslSvcSpd[i]);
				if (gnrMkrNm[i] != null)
					model.setGnrMkrNm(gnrMkrNm[i]);
				if (mnEngTrKnt[i] != null)
					model.setMnEngTrKnt(mnEngTrKnt[i]);	
				if (gnrTrKnt[i] != null)
					model.setGnrTrKnt(gnrTrKnt[i]);	
				if (bwthstTrKnt[i] != null)
					model.setBwthstTrKnt(bwthstTrKnt[i]);
				if (blkCrrTpCd         [i] != null) model.setBlkCrrTpCd            (blkCrrTpCd         [i]); 
				if (blstWgtSpd1        [i] != null) model.setBlstWgtSpd1           (blstWgtSpd1        [i]);
				if (ctclRpmNo          [i] != null) model.setCtclRpmNo             (ctclRpmNo          [i]);
				if (ctclToRpmNo        [i] != null) model.setCtclToRpmNo           (ctclToRpmNo        [i]);
				if (foilBlstCsm2       [i] != null) model.setFoilBlstCsm2          (foilBlstCsm2       [i]);
				if (fuelSavEqFlg       [i] != null) model.setFuelSavEqFlg          (fuelSavEqFlg       [i]);
				if (htchCvrInHldKnt    [i] != null) model.setHtchCvrInHldKnt       (htchCvrInHldKnt    [i]);
				if (inHldPerRowKnt     [i] != null) model.setInHldPerRowKnt        (inHldPerRowKnt     [i]);
				if (inHldPerTrKnt      [i] != null) model.setInHldPerTrKnt         (inHldPerTrKnt      [i]);
				if (ldnWgtSpd1         [i] != null) model.setLdnWgtSpd1            (ldnWgtSpd1         [i]);
				if (onDeckPerRowKnt    [i] != null) model.setOnDeckPerRowKnt       (onDeckPerRowKnt    [i]);
				if (onDeckPerTrKnt     [i] != null) model.setOnDeckPerTrKnt        (onDeckPerTrKnt     [i]);
				if (opMinRpmNo         [i] != null) model.setOpMinRpmNo            (opMinRpmNo         [i]);
				if (opMinSpd           [i] != null) model.setOpMinSpd              (opMinSpd           [i]);
				if (portFoilTonCsm     [i] != null) model.setPortFoilTonCsm        (portFoilTonCsm     [i]);
				if (portIdleDoilTonCsm [i] != null) model.setPortIdleDoilTonCsm    (portIdleDoilTonCsm [i]);
				if (portWrkDoilTonCsm  [i] != null) model.setPortWrkDoilTonCsm     (portWrkDoilTonCsm  [i]);
				if (slwStmngFlg        [i] != null) model.setSlwStmngFlg           (slwStmngFlg        [i]);
				if (sprSlwStmngFlg     [i] != null) model.setSprSlwStmngFlg        (sprSlwStmngFlg     [i]);
				if (tropDrftHgt        [i] != null) model.setTropDrftHgt           (tropDrftHgt        [i]);
				if (tropDwtWgt         [i] != null) model.setTropDwtWgt            (tropDwtWgt         [i]);
				if (vslLodRto          [i] != null) model.setVslLodRto             (vslLodRto          [i]);
				if (wntDrftHgt         [i] != null) model.setWntDrftHgt            (wntDrftHgt         [i]);
				if (wntDwtWgt          [i] != null) model.setWntDwtWgt             (wntDwtWgt          [i]);
				if (pageNo             [i] != null) model.setPageNo                (pageNo             [i]);
				if (ampTpCd            [i] != null) model.setAmpTpCd               (ampTpCd            [i]);

				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVSLPartIVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VSLPartIVO[]
	 */
	public VSLPartIVO[] getVSLPartIVOs(){
		VSLPartIVO[] vos = (VSLPartIVO[])models.toArray(new VSLPartIVO[models.size()]);
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
		this.bwthstRpmPwr = this.bwthstRpmPwr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnEngTpDesc = this.mnEngTpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDpth = this.vslDpth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndRmnDt = this.n2ndRmnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stHirRtN2ndAmt = this.n1stHirRtN2ndAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndHirRtN2ndAmt = this.n2ndHirRtN2ndAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dplCapa = this.dplCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gnrTpDesc = this.gnrTpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fbdCapa = this.fbdCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslHgt = this.vslHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslLodLineCertiExpDt = this.vslLodLineCertiExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSftRdoCertiExpDt = this.vslSftRdoCertiExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgstDt = this.rgstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslHldKnt = this.vslHldKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgstPortCd = this.rgstPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lbpLen = this.lbpLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSgnNo = this.callSgnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndHirRtN1stAmt = this.n2ndHirRtN1stAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clssNoRgstAreaNm = this.clssNoRgstAreaNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsRgstTongWgt = this.grsRgstTongWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tlxNo = this.tlxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfRcptKnt = this.rfRcptKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslHlNo = this.vslHlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lloydNo = this.lloydNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.suzNetTongWgt = this.suzNetTongWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pnmNetTongWgt = this.pnmNetTongWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgstNo = this.rgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stEffDt = this.n1stEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslRmk = this.vslRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndHirCurrN2ndCd = this.n2ndHirCurrN2ndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stExpDt = this.n1stExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfRcptMaxKnt = this.rfRcptMaxKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loaLen = this.loaLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslLnchDt = this.vslLnchDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndExpDt = this.n2ndExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslBldrNm = this.vslBldrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crwKnt = this.crwKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCreOfcCd = this.vslCreOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslClssCd = this.vslClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSftCstruCertiExpDt = this.vslSftCstruCertiExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blstTnkCapa = this.blstTnkCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslKrnNm = this.vslKrnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stHirCurrN2ndCd = this.n1stHirCurrN2ndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bwthstMkrNm = this.bwthstMkrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pnmGtWgt = this.pnmGtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslClzDt = this.vslClzDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.suzGtWgt = this.suzGtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.madnVoySuzNetTongWgt = this.madnVoySuzNetTongWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgtShpTongWgt = this.lgtShpTongWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnEngKwPwr = this.mnEngKwPwr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilCapa = this.foilCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDeratCertiExpDt = this.vslDeratCertiExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlTeuKnt = this.ttlTeuKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilCsm = this.foilCsm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndVndrNm = this.n2ndVndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doilCsm = this.doilCsm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDeDt = this.vslDeDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwtWgt = this.dwtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnEngRpmPwr = this.mnEngRpmPwr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSftEqCertiExpDt = this.vslSftEqCertiExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stRmnDt = this.n1stRmnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doilCapa = this.doilCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndHirCurrN1stCd = this.n2ndHirCurrN1stCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslType = this.vslType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frshWtrCapa = this.frshWtrCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phnNo = this.phnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndVndrSeq = this.n2ndVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrOpCapa = this.cntrOpCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stHirCurrN1stCd = this.n1stHirCurrN1stCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.piclbDesc = this.piclbDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslOwnIndCd = this.vslOwnIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frshWtrCsm = this.frshWtrCsm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDznCapa = this.cntrDznCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrDivCd = this.fdrDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stHirRtN1stAmt = this.n1stHirRtN1stAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDeltOfcCd = this.vslDeltOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smrDrftHgt = this.smrDrftHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bwthstBhpPwr = this.bwthstBhpPwr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEdiNm = this.vslEdiNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEml = this.vslEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrFullNm = this.crrFullNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslBldAreaNm = this.vslBldAreaNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnEngMkrNm = this.mnEngMkrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslHtchKnt = this.vslHtchKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gnrBhpPwr = this.gnrBhpPwr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntNm = this.cntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxSpd = this.maxSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslRgstCntCd = this.vslRgstCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPnmCapa = this.cntrPnmCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stVndrSeq = this.n1stVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stVndrNm = this.n1stVndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gnrRpmPwr = this.gnrRpmPwr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslClssNo = this.vslClssNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslLoclNm = this.vslLoclNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netRgstTongWgt = this.netRgstTongWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coCd = this.coCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslBldCd = this.vslBldCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bwthstTpDesc = this.bwthstTpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndEffDt = this.n2ndEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ecnSpd = this.ecnSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiEvntDt = this.eaiEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnEngBhpPwr = this.mnEngBhpPwr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslKelLyDt = this.vslKelLyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVslClssCapa = this.cntrVslClssCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intlTongCertiFlg = this.intlTongCertiFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslWdt = this.vslWdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSvcSpd = this.vslSvcSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gnrMkrNm = this.gnrMkrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnEngTrKnt = this.mnEngTrKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gnrTrKnt = this.gnrTrKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bwthstTrKnt = this.bwthstTrKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blkCrrTpCd          = this.blkCrrTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");  
		this.blstWgtSpd1         = this.blstWgtSpd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""); 
		this.ctclRpmNo           = this.ctclRpmNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""); 
		this.ctclToRpmNo         = this.ctclToRpmNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""); 
		this.foilBlstCsm2        = this.foilBlstCsm2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""); 
		this.fuelSavEqFlg        = this.fuelSavEqFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""); 
		this.htchCvrInHldKnt     = this.htchCvrInHldKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""); 
		this.inHldPerRowKnt      = this.inHldPerRowKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""); 
		this.inHldPerTrKnt       = this.inHldPerTrKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""); 
		this.ldnWgtSpd1          = this.ldnWgtSpd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""); 
		this.onDeckPerRowKnt     = this.onDeckPerRowKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""); 
		this.onDeckPerTrKnt      = this.onDeckPerTrKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""); 
		this.opMinRpmNo          = this.opMinRpmNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""); 
		this.opMinSpd            = this.opMinSpd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""); 
		this.portFoilTonCsm      = this.portFoilTonCsm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""); 
		this.portIdleDoilTonCsm  = this.portIdleDoilTonCsm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""); 
		this.portWrkDoilTonCsm   = this.portWrkDoilTonCsm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""); 
		this.slwStmngFlg         = this.slwStmngFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""); 
		this.sprSlwStmngFlg      = this.sprSlwStmngFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""); 
		this.tropDrftHgt         = this.tropDrftHgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""); 
		this.tropDwtWgt          = this.tropDwtWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""); 
		this.vslLodRto           = this.vslLodRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""); 
		this.wntDrftHgt          = this.wntDrftHgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""); 
		this.wntDwtWgt           = this.wntDwtWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""); 
		this.pageNo              = this.pageNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""); 
		this.ampTpCd             = this.ampTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""); 

	}
}

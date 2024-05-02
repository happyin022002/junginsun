/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PriSimRoutInfoVO.java
*@FileTitle : PriSimRoutInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.26
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2015.05.26 김민정 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.prisimulation.prisimulation.vo;

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
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class PriSimRoutInfoVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<PriSimRoutInfoVO> models = new ArrayList<PriSimRoutInfoVO>();

    /* Column Info */
    private String porCd = null;

    /* Column Info */
    private String n1stSlan = null;

    /* Column Info */
    private String lastSlan = null;

    /* Column Info */
    private String estmCmAmt220 = null;

    /* Column Info */
    private String trdCd = null;

    /* Column Info */
    private String mtyPkupYdCd = null;

    /* Column Info */
    private String ord = null;

    /* Column Info */
    private String ibItchgCtnt = null;

    /* Column Info */
    private String cct = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String pctlNo = null;

    /* Column Info */
    private String obItchgCtnt = null;

    /* Column Info */
    private String estmCmCostAmt70 = null;

    /* Column Info */
    private String polCd = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String estmCmAmt70 = null;

    /* Column Info */
    private String estmCmAmt240 = null;

    /* Column Info */
    private String delNodCd = null;

    /* Column Info */
    private String estmCmAmt245 = null;

    /* Column Info */
    private String estmCmCostAmt270 = null;

    /* Column Info */
    private String estmCmCostAmt240 = null;

    /* Column Info */
    private String porNodCd = null;

    /* Column Info */
    private String estmCmCostAmt20 = null;

    /* Column Info */
    private String estmCmCostAmt220 = null;

    /* Column Info */
    private String cctT = null;

    /* Column Info */
    private String delCd = null;

    /* Column Info */
    private String costFlg = null;

    /* Column Info */
    private String ocnRoutPrioCd = null;

    /* Column Info */
    private String estmCmCostAmt245 = null;

    /* Column Info */
    private String tsRoute = null;

    /* Column Info */
    private String podCd = null;

    /* Column Info */
    private String ttlTztmHrs = null;

    /* Column Info */
    private String estmCmCostAmt40 = null;

    /* Column Info */
    private String estmCmAmt45 = null;

    /* Column Info */
    private String slanCd = null;

    /* Column Info */
    private String ttlTztm = null;

    /* Column Info */
    private String estmCmAmt40 = null;

    /* Column Info */
    private String cgoAvalHrs = null;

    /* Column Info */
    private String estmCmAmt20 = null;

    /* Column Info */
    private String estmCmAmt270 = null;

    /* Column Info */
    private String subTrdCd = null;

    /* Column Info */
    private String estmCmCostAmt45 = null;

    /* Column Info */
    private String svcScpCd = null;
    /* Column Info */
    private String cmlOcnTztmHrs = null;
    /* Column Info */
    private String cmlInlndTztmHrs = null;
    /* Column Info */
    private String misAvgFlg20 = null;
    /* Column Info */
    private String misAvgFlg40 = null;
    /* Column Info */
    private String misAvgFlg45 = null;
    /* Column Info */
    private String misAvgFlg70 = null;
    private String rOrgTrnsModCd = null;
    private String rDestTrnsModCd = null;
    private String polNodCd = null;
    private String podNodCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public PriSimRoutInfoVO() {
    }

    public PriSimRoutInfoVO(String ibflag, String pagerows, String trdCd, String subTrdCd, String slanCd, String cctT, String ttlTztm, String ttlTztmHrs, String porCd, String obItchgCtnt, String polCd, String tsRoute, String n1stSlan, String lastSlan, String podCd, String ibItchgCtnt, String delCd, String mtyPkupYdCd, String porNodCd, String delNodCd, String pctlNo, String ord, String estmCmCostAmt20, String estmCmCostAmt40, String estmCmCostAmt45, String estmCmCostAmt70, String estmCmAmt20, String estmCmAmt40, String estmCmAmt45, String estmCmAmt70, String estmCmCostAmt220, String estmCmCostAmt240, String estmCmCostAmt245, String estmCmCostAmt270, String estmCmAmt220, String estmCmAmt240, String estmCmAmt245, String estmCmAmt270, String costFlg, String ocnRoutPrioCd, String cct, String cgoAvalHrs, String svcScpCd, String cmlOcnTztmHrs, String cmlInlndTztmHrs, String misAvgFlg20, String misAvgFlg40, String misAvgFlg45, String misAvgFlg70, String rOrgTrnsModCd, String rDestTrnsModCd, String polNodCd, String podNodCd) {
        this.porCd = porCd;
        this.n1stSlan = n1stSlan;
        this.lastSlan = lastSlan;
        this.estmCmAmt220 = estmCmAmt220;
        this.trdCd = trdCd;
        this.mtyPkupYdCd = mtyPkupYdCd;
        this.ord = ord;
        this.ibItchgCtnt = ibItchgCtnt;
        this.cct = cct;
        this.pagerows = pagerows;
        this.pctlNo = pctlNo;
        this.obItchgCtnt = obItchgCtnt;
        this.estmCmCostAmt70 = estmCmCostAmt70;
        this.polCd = polCd;
        this.ibflag = ibflag;
        this.estmCmAmt70 = estmCmAmt70;
        this.estmCmAmt240 = estmCmAmt240;
        this.delNodCd = delNodCd;
        this.estmCmAmt245 = estmCmAmt245;
        this.estmCmCostAmt270 = estmCmCostAmt270;
        this.estmCmCostAmt240 = estmCmCostAmt240;
        this.porNodCd = porNodCd;
        this.estmCmCostAmt20 = estmCmCostAmt20;
        this.estmCmCostAmt220 = estmCmCostAmt220;
        this.cctT = cctT;
        this.delCd = delCd;
        this.costFlg = costFlg;
        this.ocnRoutPrioCd = ocnRoutPrioCd;
        this.estmCmCostAmt245 = estmCmCostAmt245;
        this.tsRoute = tsRoute;
        this.podCd = podCd;
        this.ttlTztmHrs = ttlTztmHrs;
        this.estmCmCostAmt40 = estmCmCostAmt40;
        this.estmCmAmt45 = estmCmAmt45;
        this.slanCd = slanCd;
        this.ttlTztm = ttlTztm;
        this.estmCmAmt40 = estmCmAmt40;
        this.cgoAvalHrs = cgoAvalHrs;
        this.estmCmAmt20 = estmCmAmt20;
        this.estmCmAmt270 = estmCmAmt270;
        this.subTrdCd = subTrdCd;
        this.estmCmCostAmt45 = estmCmCostAmt45;
        this.svcScpCd = svcScpCd;
        this.cmlOcnTztmHrs = cmlOcnTztmHrs;
        this.cmlInlndTztmHrs = cmlInlndTztmHrs;
        this.misAvgFlg20 = misAvgFlg20;
        this.misAvgFlg40 = misAvgFlg40;
        this.misAvgFlg45 = misAvgFlg45;
        this.misAvgFlg70 = misAvgFlg70;
        this.rOrgTrnsModCd   = rOrgTrnsModCd;
        this.rDestTrnsModCd  = rDestTrnsModCd;
        this.polNodCd  = polNodCd;
        this.podNodCd  = podNodCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("por_cd", getPorCd());
        this.hashColumns.put("n1st_slan", getN1stSlan());
        this.hashColumns.put("last_slan", getLastSlan());
        this.hashColumns.put("estm_cm_amt2_20", getEstmCmAmt220());
        this.hashColumns.put("trd_cd", getTrdCd());
        this.hashColumns.put("mty_pkup_yd_cd", getMtyPkupYdCd());
        this.hashColumns.put("ord", getOrd());
        this.hashColumns.put("ib_itchg_ctnt", getIbItchgCtnt());
        this.hashColumns.put("cct", getCct());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("pctl_no", getPctlNo());
        this.hashColumns.put("ob_itchg_ctnt", getObItchgCtnt());
        this.hashColumns.put("estm_cm_cost_amt_70", getEstmCmCostAmt70());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("estm_cm_amt_70", getEstmCmAmt70());
        this.hashColumns.put("estm_cm_amt2_40", getEstmCmAmt240());
        this.hashColumns.put("del_nod_cd", getDelNodCd());
        this.hashColumns.put("estm_cm_amt2_45", getEstmCmAmt245());
        this.hashColumns.put("estm_cm_cost_amt2_70", getEstmCmCostAmt270());
        this.hashColumns.put("estm_cm_cost_amt2_40", getEstmCmCostAmt240());
        this.hashColumns.put("por_nod_cd", getPorNodCd());
        this.hashColumns.put("estm_cm_cost_amt_20", getEstmCmCostAmt20());
        this.hashColumns.put("estm_cm_cost_amt2_20", getEstmCmCostAmt220());
        this.hashColumns.put("cct_t", getCctT());
        this.hashColumns.put("del_cd", getDelCd());
        this.hashColumns.put("cost_flg", getCostFlg());
        this.hashColumns.put("ocn_rout_prio_cd", getOcnRoutPrioCd());
        this.hashColumns.put("estm_cm_cost_amt2_45", getEstmCmCostAmt245());
        this.hashColumns.put("ts_route", getTsRoute());
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("ttl_tztm_hrs", getTtlTztmHrs());
        this.hashColumns.put("estm_cm_cost_amt_40", getEstmCmCostAmt40());
        this.hashColumns.put("estm_cm_amt_45", getEstmCmAmt45());
        this.hashColumns.put("slan_cd", getSlanCd());
        this.hashColumns.put("ttl_tztm", getTtlTztm());
        this.hashColumns.put("estm_cm_amt_40", getEstmCmAmt40());
        this.hashColumns.put("cgo_aval_hrs", getCgoAvalHrs());
        this.hashColumns.put("estm_cm_amt_20", getEstmCmAmt20());
        this.hashColumns.put("estm_cm_amt2_70", getEstmCmAmt270());
        this.hashColumns.put("sub_trd_cd", getSubTrdCd());
        this.hashColumns.put("estm_cm_cost_amt_45", getEstmCmCostAmt45());
        this.hashColumns.put("svc_scp_cd", getSvcScpCd());
        this.hashColumns.put("cml_ocn_tztm_hrs", getCmlOcnTztmHrs());
        this.hashColumns.put("cml_inlnd_tztm_hrs", getCmlInlndTztmHrs());
        this.hashColumns.put("mis_avg_flg_20", getMisAvgFlg20());
        this.hashColumns.put("mis_avg_flg_40", getMisAvgFlg40());
        this.hashColumns.put("mis_avg_flg_45", getMisAvgFlg45());
        this.hashColumns.put("mis_avg_flg_70", getMisAvgFlg70());
        this.hashColumns.put("r_org_trns_mod_cd", getROrgTrnsModCd());
        this.hashColumns.put("r_dest_trns_mod_cd", getRDestTrnsModCd());
        this.hashColumns.put("pol_nod_cd", getPolNodCd());
        this.hashColumns.put("pod_nod_cd", getPodNodCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("por_cd", "porCd");
        this.hashFields.put("n1st_slan", "n1stSlan");
        this.hashFields.put("last_slan", "lastSlan");
        this.hashFields.put("estm_cm_amt2_20", "estmCmAmt220");
        this.hashFields.put("trd_cd", "trdCd");
        this.hashFields.put("mty_pkup_yd_cd", "mtyPkupYdCd");
        this.hashFields.put("ord", "ord");
        this.hashFields.put("ib_itchg_ctnt", "ibItchgCtnt");
        this.hashFields.put("cct", "cct");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("pctl_no", "pctlNo");
        this.hashFields.put("ob_itchg_ctnt", "obItchgCtnt");
        this.hashFields.put("estm_cm_cost_amt_70", "estmCmCostAmt70");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("estm_cm_amt_70", "estmCmAmt70");
        this.hashFields.put("estm_cm_amt2_40", "estmCmAmt240");
        this.hashFields.put("del_nod_cd", "delNodCd");
        this.hashFields.put("estm_cm_amt2_45", "estmCmAmt245");
        this.hashFields.put("estm_cm_cost_amt2_70", "estmCmCostAmt270");
        this.hashFields.put("estm_cm_cost_amt2_40", "estmCmCostAmt240");
        this.hashFields.put("por_nod_cd", "porNodCd");
        this.hashFields.put("estm_cm_cost_amt_20", "estmCmCostAmt20");
        this.hashFields.put("estm_cm_cost_amt2_20", "estmCmCostAmt220");
        this.hashFields.put("cct_t", "cctT");
        this.hashFields.put("del_cd", "delCd");
        this.hashFields.put("cost_flg", "costFlg");
        this.hashFields.put("ocn_rout_prio_cd", "ocnRoutPrioCd");
        this.hashFields.put("estm_cm_cost_amt2_45", "estmCmCostAmt245");
        this.hashFields.put("ts_route", "tsRoute");
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("ttl_tztm_hrs", "ttlTztmHrs");
        this.hashFields.put("estm_cm_cost_amt_40", "estmCmCostAmt40");
        this.hashFields.put("estm_cm_amt_45", "estmCmAmt45");
        this.hashFields.put("slan_cd", "slanCd");
        this.hashFields.put("ttl_tztm", "ttlTztm");
        this.hashFields.put("estm_cm_amt_40", "estmCmAmt40");
        this.hashFields.put("cgo_aval_hrs", "cgoAvalHrs");
        this.hashFields.put("estm_cm_amt_20", "estmCmAmt20");
        this.hashFields.put("estm_cm_amt2_70", "estmCmAmt270");
        this.hashFields.put("sub_trd_cd", "subTrdCd");
        this.hashFields.put("estm_cm_cost_amt_45", "estmCmCostAmt45");
        this.hashFields.put("svc_scp_cd", "svcScpCd");
        this.hashFields.put("cml_ocn_tztm_hrs", "cmlOcnTztmHrs");
        this.hashFields.put("cml_inlnd_tztm_hrs", "cmlInlndTztmHrs");
        this.hashFields.put("mis_avg_flg_20", "misAvgFlg20");
        this.hashFields.put("mis_avg_flg_40", "misAvgFlg40");
        this.hashFields.put("mis_avg_flg_45", "misAvgFlg45");
        this.hashFields.put("mis_avg_flg_70", "misAvgFlg70");
        this.hashFields.put("r_org_trns_mod_cd", "rOrgTrnsModCd");
        this.hashFields.put("r_dest_trns_mod_cd", "rDestTrnsModCd");
        this.hashFields.put("pol_nod_cd", "polNodCd");
        this.hashFields.put("pod_nod_cd", "podNodCd");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return porCd
	 */
    public String getPorCd() {
        return this.porCd;
    }

    /**
	 * Column Info
	 * @return n1stSlan
	 */
    public String getN1stSlan() {
        return this.n1stSlan;
    }

    /**
	 * Column Info
	 * @return lastSlan
	 */
    public String getLastSlan() {
        return this.lastSlan;
    }

    /**
	 * Column Info
	 * @return estmCmAmt220
	 */
    public String getEstmCmAmt220() {
        return this.estmCmAmt220;
    }

    /**
	 * Column Info
	 * @return trdCd
	 */
    public String getTrdCd() {
        return this.trdCd;
    }

    /**
	 * Column Info
	 * @return mtyPkupYdCd
	 */
    public String getMtyPkupYdCd() {
        return this.mtyPkupYdCd;
    }

    /**
	 * Column Info
	 * @return ord
	 */
    public String getOrd() {
        return this.ord;
    }

    /**
	 * Column Info
	 * @return ibItchgCtnt
	 */
    public String getIbItchgCtnt() {
        return this.ibItchgCtnt;
    }

    /**
	 * Column Info
	 * @return cct
	 */
    public String getCct() {
        return this.cct;
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
	 * @return pctlNo
	 */
    public String getPctlNo() {
        return this.pctlNo;
    }

    /**
	 * Column Info
	 * @return obItchgCtnt
	 */
    public String getObItchgCtnt() {
        return this.obItchgCtnt;
    }

    /**
	 * Column Info
	 * @return estmCmCostAmt70
	 */
    public String getEstmCmCostAmt70() {
        return this.estmCmCostAmt70;
    }

    /**
	 * Column Info
	 * @return polCd
	 */
    public String getPolCd() {
        return this.polCd;
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
	 * @return estmCmAmt70
	 */
    public String getEstmCmAmt70() {
        return this.estmCmAmt70;
    }

    /**
	 * Column Info
	 * @return estmCmAmt240
	 */
    public String getEstmCmAmt240() {
        return this.estmCmAmt240;
    }

    /**
	 * Column Info
	 * @return delNodCd
	 */
    public String getDelNodCd() {
        return this.delNodCd;
    }

    /**
	 * Column Info
	 * @return estmCmAmt245
	 */
    public String getEstmCmAmt245() {
        return this.estmCmAmt245;
    }

    /**
	 * Column Info
	 * @return estmCmCostAmt270
	 */
    public String getEstmCmCostAmt270() {
        return this.estmCmCostAmt270;
    }

    /**
	 * Column Info
	 * @return estmCmCostAmt240
	 */
    public String getEstmCmCostAmt240() {
        return this.estmCmCostAmt240;
    }

    /**
	 * Column Info
	 * @return porNodCd
	 */
    public String getPorNodCd() {
        return this.porNodCd;
    }

    /**
	 * Column Info
	 * @return estmCmCostAmt20
	 */
    public String getEstmCmCostAmt20() {
        return this.estmCmCostAmt20;
    }

    /**
	 * Column Info
	 * @return estmCmCostAmt220
	 */
    public String getEstmCmCostAmt220() {
        return this.estmCmCostAmt220;
    }

    /**
	 * Column Info
	 * @return cctT
	 */
    public String getCctT() {
        return this.cctT;
    }

    /**
	 * Column Info
	 * @return delCd
	 */
    public String getDelCd() {
        return this.delCd;
    }

    /**
	 * Column Info
	 * @return costFlg
	 */
    public String getCostFlg() {
        return this.costFlg;
    }

    /**
	 * Column Info
	 * @return ocnRoutPrioCd
	 */
    public String getOcnRoutPrioCd() {
        return this.ocnRoutPrioCd;
    }

    /**
	 * Column Info
	 * @return estmCmCostAmt245
	 */
    public String getEstmCmCostAmt245() {
        return this.estmCmCostAmt245;
    }

    /**
	 * Column Info
	 * @return tsRoute
	 */
    public String getTsRoute() {
        return this.tsRoute;
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
	 * @return ttlTztmHrs
	 */
    public String getTtlTztmHrs() {
        return this.ttlTztmHrs;
    }

    /**
	 * Column Info
	 * @return estmCmCostAmt40
	 */
    public String getEstmCmCostAmt40() {
        return this.estmCmCostAmt40;
    }

    /**
	 * Column Info
	 * @return estmCmAmt45
	 */
    public String getEstmCmAmt45() {
        return this.estmCmAmt45;
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
	 * @return ttlTztm
	 */
    public String getTtlTztm() {
        return this.ttlTztm;
    }

    /**
	 * Column Info
	 * @return estmCmAmt40
	 */
    public String getEstmCmAmt40() {
        return this.estmCmAmt40;
    }

    /**
	 * Column Info
	 * @return cgoAvalHrs
	 */
    public String getCgoAvalHrs() {
        return this.cgoAvalHrs;
    }

    /**
	 * Column Info
	 * @return estmCmAmt20
	 */
    public String getEstmCmAmt20() {
        return this.estmCmAmt20;
    }

    /**
	 * Column Info
	 * @return estmCmAmt270
	 */
    public String getEstmCmAmt270() {
        return this.estmCmAmt270;
    }

    /**
	 * Column Info
	 * @return subTrdCd
	 */
    public String getSubTrdCd() {
        return this.subTrdCd;
    }

    /**
	 * Column Info
	 * @return estmCmCostAmt45
	 */
    public String getEstmCmCostAmt45() {
        return this.estmCmCostAmt45;
    }
    
    /**
	 * Column Info
	 * @return misAvgFlg20
	 */
    public String getMisAvgFlg20() {
        return this.misAvgFlg20;
    }
    
    /**
	 * Column Info
	 * @return misAvgFlg40
	 */
    public String getMisAvgFlg40() {
        return this.misAvgFlg40;
    }
    
    /**
	 * Column Info
	 * @return misAvgFlg45
	 */
    public String getMisAvgFlg45() {
        return this.misAvgFlg45;
    }
    
    /**
	 * Column Info
	 * @return misAvgFlg70
	 */
    public String getMisAvgFlg70() {
        return this.misAvgFlg70;
    }

	public String getROrgTrnsModCd() {
		return rOrgTrnsModCd;
	}

	public String getRDestTrnsModCd() {
		return rDestTrnsModCd;
	}
	
	public String getPolNodCd() {
		return polNodCd;
	}
	
	public String getPodNodCd() {
		return podNodCd;
	}

    /**
	 * Column Info
	 * @param porCd
	 */
    public void setPorCd(String porCd) {
        this.porCd = porCd;
    }

    /**
	 * Column Info
	 * @param n1stSlan
	 */
    public void setN1stSlan(String n1stSlan) {
        this.n1stSlan = n1stSlan;
    }

    /**
	 * Column Info
	 * @param lastSlan
	 */
    public void setLastSlan(String lastSlan) {
        this.lastSlan = lastSlan;
    }

    /**
	 * Column Info
	 * @param estmCmAmt220
	 */
    public void setEstmCmAmt220(String estmCmAmt220) {
        this.estmCmAmt220 = estmCmAmt220;
    }

    /**
	 * Column Info
	 * @param trdCd
	 */
    public void setTrdCd(String trdCd) {
        this.trdCd = trdCd;
    }

    /**
	 * Column Info
	 * @param mtyPkupYdCd
	 */
    public void setMtyPkupYdCd(String mtyPkupYdCd) {
        this.mtyPkupYdCd = mtyPkupYdCd;
    }

    /**
	 * Column Info
	 * @param ord
	 */
    public void setOrd(String ord) {
        this.ord = ord;
    }

    /**
	 * Column Info
	 * @param ibItchgCtnt
	 */
    public void setIbItchgCtnt(String ibItchgCtnt) {
        this.ibItchgCtnt = ibItchgCtnt;
    }

    /**
	 * Column Info
	 * @param cct
	 */
    public void setCct(String cct) {
        this.cct = cct;
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
	 * @param pctlNo
	 */
    public void setPctlNo(String pctlNo) {
        this.pctlNo = pctlNo;
    }

    /**
	 * Column Info
	 * @param obItchgCtnt
	 */
    public void setObItchgCtnt(String obItchgCtnt) {
        this.obItchgCtnt = obItchgCtnt;
    }

    /**
	 * Column Info
	 * @param estmCmCostAmt70
	 */
    public void setEstmCmCostAmt70(String estmCmCostAmt70) {
        this.estmCmCostAmt70 = estmCmCostAmt70;
    }

    /**
	 * Column Info
	 * @param polCd
	 */
    public void setPolCd(String polCd) {
        this.polCd = polCd;
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
	 * @param estmCmAmt70
	 */
    public void setEstmCmAmt70(String estmCmAmt70) {
        this.estmCmAmt70 = estmCmAmt70;
    }

    /**
	 * Column Info
	 * @param estmCmAmt240
	 */
    public void setEstmCmAmt240(String estmCmAmt240) {
        this.estmCmAmt240 = estmCmAmt240;
    }

    /**
	 * Column Info
	 * @param delNodCd
	 */
    public void setDelNodCd(String delNodCd) {
        this.delNodCd = delNodCd;
    }

    /**
	 * Column Info
	 * @param estmCmAmt245
	 */
    public void setEstmCmAmt245(String estmCmAmt245) {
        this.estmCmAmt245 = estmCmAmt245;
    }

    /**
	 * Column Info
	 * @param estmCmCostAmt270
	 */
    public void setEstmCmCostAmt270(String estmCmCostAmt270) {
        this.estmCmCostAmt270 = estmCmCostAmt270;
    }

    /**
	 * Column Info
	 * @param estmCmCostAmt240
	 */
    public void setEstmCmCostAmt240(String estmCmCostAmt240) {
        this.estmCmCostAmt240 = estmCmCostAmt240;
    }

    /**
	 * Column Info
	 * @param porNodCd
	 */
    public void setPorNodCd(String porNodCd) {
        this.porNodCd = porNodCd;
    }

    /**
	 * Column Info
	 * @param estmCmCostAmt20
	 */
    public void setEstmCmCostAmt20(String estmCmCostAmt20) {
        this.estmCmCostAmt20 = estmCmCostAmt20;
    }

    /**
	 * Column Info
	 * @param estmCmCostAmt220
	 */
    public void setEstmCmCostAmt220(String estmCmCostAmt220) {
        this.estmCmCostAmt220 = estmCmCostAmt220;
    }

    /**
	 * Column Info
	 * @param cctT
	 */
    public void setCctT(String cctT) {
        this.cctT = cctT;
    }

    /**
	 * Column Info
	 * @param delCd
	 */
    public void setDelCd(String delCd) {
        this.delCd = delCd;
    }

    /**
	 * Column Info
	 * @param costFlg
	 */
    public void setCostFlg(String costFlg) {
        this.costFlg = costFlg;
    }

    /**
	 * Column Info
	 * @param ocnRoutPrioCd
	 */
    public void setOcnRoutPrioCd(String ocnRoutPrioCd) {
        this.ocnRoutPrioCd = ocnRoutPrioCd;
    }

    /**
	 * Column Info
	 * @param estmCmCostAmt245
	 */
    public void setEstmCmCostAmt245(String estmCmCostAmt245) {
        this.estmCmCostAmt245 = estmCmCostAmt245;
    }

    /**
	 * Column Info
	 * @param tsRoute
	 */
    public void setTsRoute(String tsRoute) {
        this.tsRoute = tsRoute;
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
	 * @param ttlTztmHrs
	 */
    public void setTtlTztmHrs(String ttlTztmHrs) {
        this.ttlTztmHrs = ttlTztmHrs;
    }

    /**
	 * Column Info
	 * @param estmCmCostAmt40
	 */
    public void setEstmCmCostAmt40(String estmCmCostAmt40) {
        this.estmCmCostAmt40 = estmCmCostAmt40;
    }

    /**
	 * Column Info
	 * @param estmCmAmt45
	 */
    public void setEstmCmAmt45(String estmCmAmt45) {
        this.estmCmAmt45 = estmCmAmt45;
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
	 * @param ttlTztm
	 */
    public void setTtlTztm(String ttlTztm) {
        this.ttlTztm = ttlTztm;
    }

    /**
	 * Column Info
	 * @param estmCmAmt40
	 */
    public void setEstmCmAmt40(String estmCmAmt40) {
        this.estmCmAmt40 = estmCmAmt40;
    }

    /**
	 * Column Info
	 * @param cgoAvalHrs
	 */
    public void setCgoAvalHrs(String cgoAvalHrs) {
        this.cgoAvalHrs = cgoAvalHrs;
    }

    /**
	 * Column Info
	 * @param estmCmAmt20
	 */
    public void setEstmCmAmt20(String estmCmAmt20) {
        this.estmCmAmt20 = estmCmAmt20;
    }

    /**
	 * Column Info
	 * @param estmCmAmt270
	 */
    public void setEstmCmAmt270(String estmCmAmt270) {
        this.estmCmAmt270 = estmCmAmt270;
    }

    /**
	 * Column Info
	 * @param subTrdCd
	 */
    public void setSubTrdCd(String subTrdCd) {
        this.subTrdCd = subTrdCd;
    }

    /**
	 * Column Info
	 * @param estmCmCostAmt45
	 */
    public void setEstmCmCostAmt45(String estmCmCostAmt45) {
        this.estmCmCostAmt45 = estmCmCostAmt45;
    }
    
    /**
	 * Column Info
	 * @param misAvgFlg20
	 */
    public void setMisAvgFlg20(String misAvgFlg20) {
        this.misAvgFlg20 = misAvgFlg20;
    }
    
    /**
	 * Column Info
	 * @param misAvgFlg40
	 */
    public void setMisAvgFlg40(String misAvgFlg40) {
        this.misAvgFlg40 = misAvgFlg40;
    }
    
    /**
	 * Column Info
	 * @param misAvgFlg45
	 */
    public void setMisAvgFlg45(String misAvgFlg45) {
        this.misAvgFlg45 = misAvgFlg45;
    }
    
    /**
	 * Column Info
	 * @param misAvgFlg70
	 */
    public void setMisAvgFlg70(String misAvgFlg70) {
        this.misAvgFlg70 = misAvgFlg70;
    }

	public void setROrgTrnsModCd(String rOrgTrnsModCd) {
		this.rOrgTrnsModCd = rOrgTrnsModCd;
	}

	public void setRDestTrnsModCd(String rDestTrnsModCd) {
		this.rDestTrnsModCd = rDestTrnsModCd;
	}
	
	public void setPolNodCd(String polNodCd) {
		this.polNodCd = polNodCd;
	}
	
	public void setPodNodCd(String podNodCd) {
		this.podNodCd = podNodCd;
	}

    public void setSvcScpCd(String svcScpCd) {
        this.svcScpCd = svcScpCd;
    }

    public String getSvcScpCd() {
        return this.svcScpCd;
    }
    
    public void setCmlOcnTztmHrs(String cmlOcnTztmHrs) {
    	this.cmlOcnTztmHrs = cmlOcnTztmHrs;
    }
    
    public String getCmlOcnTztmHrs() {
    	return this.cmlOcnTztmHrs;
    }
    
    public void setCmlInlndTztmHrs(String cmlInlndTztmHrs) {
    	this.cmlInlndTztmHrs = cmlInlndTztmHrs;
    }
    
    public String getCmlInlndTztmHrs() {
    	return this.cmlInlndTztmHrs;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        fromRequest(request, "");
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request, String prefix) {
        setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
        setN1stSlan(JSPUtil.getParameter(request, prefix + "n1st_slan", ""));
        setLastSlan(JSPUtil.getParameter(request, prefix + "last_slan", ""));
        setEstmCmAmt220(JSPUtil.getParameter(request, prefix + "estm_cm_amt2_20", ""));
        setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
        setMtyPkupYdCd(JSPUtil.getParameter(request, prefix + "mty_pkup_yd_cd", ""));
        setOrd(JSPUtil.getParameter(request, prefix + "ord", ""));
        setIbItchgCtnt(JSPUtil.getParameter(request, prefix + "ib_itchg_ctnt", ""));
        setCct(JSPUtil.getParameter(request, prefix + "cct", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setPctlNo(JSPUtil.getParameter(request, prefix + "pctl_no", ""));
        setObItchgCtnt(JSPUtil.getParameter(request, prefix + "ob_itchg_ctnt", ""));
        setEstmCmCostAmt70(JSPUtil.getParameter(request, prefix + "estm_cm_cost_amt_70", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setEstmCmAmt70(JSPUtil.getParameter(request, prefix + "estm_cm_amt_70", ""));
        setEstmCmAmt240(JSPUtil.getParameter(request, prefix + "estm_cm_amt2_40", ""));
        setDelNodCd(JSPUtil.getParameter(request, prefix + "del_nod_cd", ""));
        setEstmCmAmt245(JSPUtil.getParameter(request, prefix + "estm_cm_amt2_45", ""));
        setEstmCmCostAmt270(JSPUtil.getParameter(request, prefix + "estm_cm_cost_amt2_70", ""));
        setEstmCmCostAmt240(JSPUtil.getParameter(request, prefix + "estm_cm_cost_amt2_40", ""));
        setPorNodCd(JSPUtil.getParameter(request, prefix + "por_nod_cd", ""));
        setEstmCmCostAmt20(JSPUtil.getParameter(request, prefix + "estm_cm_cost_amt_20", ""));
        setEstmCmCostAmt220(JSPUtil.getParameter(request, prefix + "estm_cm_cost_amt2_20", ""));
        setCctT(JSPUtil.getParameter(request, prefix + "cct_t", ""));
        setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
        setCostFlg(JSPUtil.getParameter(request, prefix + "cost_flg", ""));
        setOcnRoutPrioCd(JSPUtil.getParameter(request, prefix + "ocn_rout_prio_cd", ""));
        setEstmCmCostAmt245(JSPUtil.getParameter(request, prefix + "estm_cm_cost_amt2_45", ""));
        setTsRoute(JSPUtil.getParameter(request, prefix + "ts_route", ""));
        setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
        setTtlTztmHrs(JSPUtil.getParameter(request, prefix + "ttl_tztm_hrs", ""));
        setEstmCmCostAmt40(JSPUtil.getParameter(request, prefix + "estm_cm_cost_amt_40", ""));
        setEstmCmAmt45(JSPUtil.getParameter(request, prefix + "estm_cm_amt_45", ""));
        setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
        setTtlTztm(JSPUtil.getParameter(request, prefix + "ttl_tztm", ""));
        setEstmCmAmt40(JSPUtil.getParameter(request, prefix + "estm_cm_amt_40", ""));
        setCgoAvalHrs(JSPUtil.getParameter(request, prefix + "cgo_aval_hrs", ""));
        setEstmCmAmt20(JSPUtil.getParameter(request, prefix + "estm_cm_amt_20", ""));
        setEstmCmAmt270(JSPUtil.getParameter(request, prefix + "estm_cm_amt2_70", ""));
        setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
        setEstmCmCostAmt45(JSPUtil.getParameter(request, prefix + "estm_cm_cost_amt_45", ""));
        setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
        setCmlOcnTztmHrs(JSPUtil.getParameter(request, prefix + "cml_ocn_tztm_hrs", ""));
        setCmlInlndTztmHrs(JSPUtil.getParameter(request, prefix + "cml_inlnd_tztm_hrs", ""));
        setMisAvgFlg20(JSPUtil.getParameter(request, prefix + "mis_avg_flg_20", ""));
        setMisAvgFlg40(JSPUtil.getParameter(request, prefix + "mis_avg_flg_40", ""));
        setMisAvgFlg45(JSPUtil.getParameter(request, prefix + "mis_avg_flg_45", ""));
        setMisAvgFlg70(JSPUtil.getParameter(request, prefix + "mis_avg_flg_70", ""));
        setROrgTrnsModCd(JSPUtil.getParameter(request, prefix + "r_org_trns_mod_cd", ""));
        setRDestTrnsModCd(JSPUtil.getParameter(request, prefix + "r_dest_trns_mod_cd", ""));
        setPolNodCd(JSPUtil.getParameter(request, prefix + "pol_nod_cd", ""));
        setPodNodCd(JSPUtil.getParameter(request, prefix + "pod_nod_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PriSimRoutInfoVO[]
	 */
    public PriSimRoutInfoVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PriSimRoutInfoVO[]
	 */
    public PriSimRoutInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        PriSimRoutInfoVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] porCd = (JSPUtil.getParameter(request, prefix + "por_cd", length));
            String[] n1stSlan = (JSPUtil.getParameter(request, prefix + "n1st_slan", length));
            String[] lastSlan = (JSPUtil.getParameter(request, prefix + "last_slan", length));
            String[] estmCmAmt220 = (JSPUtil.getParameter(request, prefix + "estm_cm_amt2_20", length));
            String[] trdCd = (JSPUtil.getParameter(request, prefix + "trd_cd", length));
            String[] mtyPkupYdCd = (JSPUtil.getParameter(request, prefix + "mty_pkup_yd_cd", length));
            String[] ord = (JSPUtil.getParameter(request, prefix + "ord", length));
            String[] ibItchgCtnt = (JSPUtil.getParameter(request, prefix + "ib_itchg_ctnt", length));
            String[] cct = (JSPUtil.getParameter(request, prefix + "cct", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] pctlNo = (JSPUtil.getParameter(request, prefix + "pctl_no", length));
            String[] obItchgCtnt = (JSPUtil.getParameter(request, prefix + "ob_itchg_ctnt", length));
            String[] estmCmCostAmt70 = (JSPUtil.getParameter(request, prefix + "estm_cm_cost_amt_70", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] estmCmAmt70 = (JSPUtil.getParameter(request, prefix + "estm_cm_amt_70", length));
            String[] estmCmAmt240 = (JSPUtil.getParameter(request, prefix + "estm_cm_amt2_40", length));
            String[] delNodCd = (JSPUtil.getParameter(request, prefix + "del_nod_cd", length));
            String[] estmCmAmt245 = (JSPUtil.getParameter(request, prefix + "estm_cm_amt2_45", length));
            String[] estmCmCostAmt270 = (JSPUtil.getParameter(request, prefix + "estm_cm_cost_amt2_70", length));
            String[] estmCmCostAmt240 = (JSPUtil.getParameter(request, prefix + "estm_cm_cost_amt2_40", length));
            String[] porNodCd = (JSPUtil.getParameter(request, prefix + "por_nod_cd", length));
            String[] estmCmCostAmt20 = (JSPUtil.getParameter(request, prefix + "estm_cm_cost_amt_20", length));
            String[] estmCmCostAmt220 = (JSPUtil.getParameter(request, prefix + "estm_cm_cost_amt2_20", length));
            String[] cctT = (JSPUtil.getParameter(request, prefix + "cct_t", length));
            String[] delCd = (JSPUtil.getParameter(request, prefix + "del_cd", length));
            String[] costFlg = (JSPUtil.getParameter(request, prefix + "cost_flg", length));
            String[] ocnRoutPrioCd = (JSPUtil.getParameter(request, prefix + "ocn_rout_prio_cd", length));
            String[] estmCmCostAmt245 = (JSPUtil.getParameter(request, prefix + "estm_cm_cost_amt2_45", length));
            String[] tsRoute = (JSPUtil.getParameter(request, prefix + "ts_route", length));
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
            String[] ttlTztmHrs = (JSPUtil.getParameter(request, prefix + "ttl_tztm_hrs", length));
            String[] estmCmCostAmt40 = (JSPUtil.getParameter(request, prefix + "estm_cm_cost_amt_40", length));
            String[] estmCmAmt45 = (JSPUtil.getParameter(request, prefix + "estm_cm_amt_45", length));
            String[] slanCd = (JSPUtil.getParameter(request, prefix + "slan_cd", length));
            String[] ttlTztm = (JSPUtil.getParameter(request, prefix + "ttl_tztm", length));
            String[] estmCmAmt40 = (JSPUtil.getParameter(request, prefix + "estm_cm_amt_40", length));
            String[] cgoAvalHrs = (JSPUtil.getParameter(request, prefix + "cgo_aval_hrs", length));
            String[] estmCmAmt20 = (JSPUtil.getParameter(request, prefix + "estm_cm_amt_20", length));
            String[] estmCmAmt270 = (JSPUtil.getParameter(request, prefix + "estm_cm_amt2_70", length));
            String[] subTrdCd = (JSPUtil.getParameter(request, prefix + "sub_trd_cd", length));
            String[] estmCmCostAmt45 = (JSPUtil.getParameter(request, prefix + "estm_cm_cost_amt_45", length));
            String[] svcScpCd = (JSPUtil.getParameter(request, prefix + "svc_scp_cd", length));
            String[] cmlOcnTztmHrs = (JSPUtil.getParameter(request, prefix + "cml_ocn_tztm_hrs", length));
            String[] cmlInlndTztmHrs = (JSPUtil.getParameter(request, prefix + "cml_inlnd_tztm_hrs", length));
            String[] misAvgFlg20 = (JSPUtil.getParameter(request, prefix + "mis_avg_flg_20", length));
            String[] misAvgFlg40 = (JSPUtil.getParameter(request, prefix + "mis_avg_flg_40", length));
            String[] misAvgFlg45 = (JSPUtil.getParameter(request, prefix + "mis_avg_flg_45", length));
            String[] misAvgFlg70 = (JSPUtil.getParameter(request, prefix + "mis_avg_flg_70", length));
            String[] rOrgTrnsModCd   = (JSPUtil.getParameter(request, prefix + "r_org_trns_mod_cd", length));
            String[] rDestTrnsModCd  = (JSPUtil.getParameter(request, prefix + "r_dest_trns_mod_cd", length));
            String[] polNodCd  = (JSPUtil.getParameter(request, prefix + "pol_nod_cd", length));
            String[] podNodCd  = (JSPUtil.getParameter(request, prefix + "pod_nod_cd", length));
            for (int i = 0; i < length; i++) {
                model = new PriSimRoutInfoVO();
                if (porCd[i] != null)
                    model.setPorCd(porCd[i]);
                if (n1stSlan[i] != null)
                    model.setN1stSlan(n1stSlan[i]);
                if (lastSlan[i] != null)
                    model.setLastSlan(lastSlan[i]);
                if (estmCmAmt220[i] != null)
                    model.setEstmCmAmt220(estmCmAmt220[i]);
                if (trdCd[i] != null)
                    model.setTrdCd(trdCd[i]);
                if (mtyPkupYdCd[i] != null)
                    model.setMtyPkupYdCd(mtyPkupYdCd[i]);
                if (ord[i] != null)
                    model.setOrd(ord[i]);
                if (ibItchgCtnt[i] != null)
                    model.setIbItchgCtnt(ibItchgCtnt[i]);
                if (cct[i] != null)
                    model.setCct(cct[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (pctlNo[i] != null)
                    model.setPctlNo(pctlNo[i]);
                if (obItchgCtnt[i] != null)
                    model.setObItchgCtnt(obItchgCtnt[i]);
                if (estmCmCostAmt70[i] != null)
                    model.setEstmCmCostAmt70(estmCmCostAmt70[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (estmCmAmt70[i] != null)
                    model.setEstmCmAmt70(estmCmAmt70[i]);
                if (estmCmAmt240[i] != null)
                    model.setEstmCmAmt240(estmCmAmt240[i]);
                if (delNodCd[i] != null)
                    model.setDelNodCd(delNodCd[i]);
                if (estmCmAmt245[i] != null)
                    model.setEstmCmAmt245(estmCmAmt245[i]);
                if (estmCmCostAmt270[i] != null)
                    model.setEstmCmCostAmt270(estmCmCostAmt270[i]);
                if (estmCmCostAmt240[i] != null)
                    model.setEstmCmCostAmt240(estmCmCostAmt240[i]);
                if (porNodCd[i] != null)
                    model.setPorNodCd(porNodCd[i]);
                if (estmCmCostAmt20[i] != null)
                    model.setEstmCmCostAmt20(estmCmCostAmt20[i]);
                if (estmCmCostAmt220[i] != null)
                    model.setEstmCmCostAmt220(estmCmCostAmt220[i]);
                if (cctT[i] != null)
                    model.setCctT(cctT[i]);
                if (delCd[i] != null)
                    model.setDelCd(delCd[i]);
                if (costFlg[i] != null)
                    model.setCostFlg(costFlg[i]);
                if (ocnRoutPrioCd[i] != null)
                    model.setOcnRoutPrioCd(ocnRoutPrioCd[i]);
                if (estmCmCostAmt245[i] != null)
                    model.setEstmCmCostAmt245(estmCmCostAmt245[i]);
                if (tsRoute[i] != null)
                    model.setTsRoute(tsRoute[i]);
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (ttlTztmHrs[i] != null)
                    model.setTtlTztmHrs(ttlTztmHrs[i]);
                if (estmCmCostAmt40[i] != null)
                    model.setEstmCmCostAmt40(estmCmCostAmt40[i]);
                if (estmCmAmt45[i] != null)
                    model.setEstmCmAmt45(estmCmAmt45[i]);
                if (slanCd[i] != null)
                    model.setSlanCd(slanCd[i]);
                if (ttlTztm[i] != null)
                    model.setTtlTztm(ttlTztm[i]);
                if (estmCmAmt40[i] != null)
                    model.setEstmCmAmt40(estmCmAmt40[i]);
                if (cgoAvalHrs[i] != null)
                    model.setCgoAvalHrs(cgoAvalHrs[i]);
                if (estmCmAmt20[i] != null)
                    model.setEstmCmAmt20(estmCmAmt20[i]);
                if (estmCmAmt270[i] != null)
                    model.setEstmCmAmt270(estmCmAmt270[i]);
                if (subTrdCd[i] != null)
                    model.setSubTrdCd(subTrdCd[i]);
                if (estmCmCostAmt45[i] != null)
                    model.setEstmCmCostAmt45(estmCmCostAmt45[i]);
                if (svcScpCd[i] != null)
                    model.setSvcScpCd(svcScpCd[i]);
                if (cmlOcnTztmHrs[i] != null)
                	model.setCmlOcnTztmHrs(cmlOcnTztmHrs[i]);
                if (cmlInlndTztmHrs[i] != null)
                	model.setCmlInlndTztmHrs(cmlInlndTztmHrs[i]);
                if (misAvgFlg20[i] != null)
                	model.setMisAvgFlg20(misAvgFlg20[i]);
                if (misAvgFlg40[i] != null)
                	model.setMisAvgFlg40(misAvgFlg40[i]);
                if (misAvgFlg45[i] != null)
                	model.setMisAvgFlg45(misAvgFlg45[i]);
                if (misAvgFlg70[i] != null)
                	model.setMisAvgFlg70(misAvgFlg70[i]);
                if (rOrgTrnsModCd[i] != null)
                	model.setROrgTrnsModCd(rOrgTrnsModCd[i]);
                if (rDestTrnsModCd[i] != null)
                	model.setRDestTrnsModCd(rDestTrnsModCd[i]);
                if (polNodCd[i] != null)
                	model.setPolNodCd(polNodCd[i]);
                if (podNodCd[i] != null)
                	model.setPodNodCd(podNodCd[i]);
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getPriSimRoutInfoVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return PriSimRoutInfoVO[]
	 */
    public PriSimRoutInfoVO[] getPriSimRoutInfoVOs() {
        PriSimRoutInfoVO[] vos = (PriSimRoutInfoVO[]) models.toArray(new PriSimRoutInfoVO[models.size()]);
        return vos;
    }

    /**
	 * VO Class의 내용을 String으로 변환
	 */
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    /**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
    public void unDataFormat() {
        this.porCd = this.porCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n1stSlan = this.n1stSlan.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lastSlan = this.lastSlan.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.estmCmAmt220 = this.estmCmAmt220.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trdCd = this.trdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mtyPkupYdCd = this.mtyPkupYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ord = this.ord.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibItchgCtnt = this.ibItchgCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cct = this.cct.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pctlNo = this.pctlNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.obItchgCtnt = this.obItchgCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.estmCmCostAmt70 = this.estmCmCostAmt70.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.estmCmAmt70 = this.estmCmAmt70.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.estmCmAmt240 = this.estmCmAmt240.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delNodCd = this.delNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.estmCmAmt245 = this.estmCmAmt245.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.estmCmCostAmt270 = this.estmCmCostAmt270.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.estmCmCostAmt240 = this.estmCmCostAmt240.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.porNodCd = this.porNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.estmCmCostAmt20 = this.estmCmCostAmt20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.estmCmCostAmt220 = this.estmCmCostAmt220.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cctT = this.cctT.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delCd = this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.costFlg = this.costFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ocnRoutPrioCd = this.ocnRoutPrioCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.estmCmCostAmt245 = this.estmCmCostAmt245.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tsRoute = this.tsRoute.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ttlTztmHrs = this.ttlTztmHrs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.estmCmCostAmt40 = this.estmCmCostAmt40.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.estmCmAmt45 = this.estmCmAmt45.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd = this.slanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ttlTztm = this.ttlTztm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.estmCmAmt40 = this.estmCmAmt40.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cgoAvalHrs = this.cgoAvalHrs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.estmCmAmt20 = this.estmCmAmt20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.estmCmAmt270 = this.estmCmAmt270.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.subTrdCd = this.subTrdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.estmCmCostAmt45 = this.estmCmCostAmt45.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.svcScpCd = this.svcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmlOcnTztmHrs = this.cmlOcnTztmHrs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmlInlndTztmHrs = this.cmlInlndTztmHrs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.misAvgFlg20 = this.misAvgFlg20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.misAvgFlg40 = this.misAvgFlg40.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.misAvgFlg45 = this.misAvgFlg45.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.misAvgFlg70 = this.misAvgFlg70.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rOrgTrnsModCd   = this.rOrgTrnsModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rDestTrnsModCd  = this.rDestTrnsModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polNodCd  = this.polNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podNodCd  = this.podNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}

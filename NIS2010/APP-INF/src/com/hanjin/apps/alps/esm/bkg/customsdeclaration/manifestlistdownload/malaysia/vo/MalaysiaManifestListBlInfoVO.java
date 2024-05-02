/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MalaysiaManifestListBlInfoVO.java
*@FileTitle : MalaysiaManifestListBlInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.10
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.10  
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class MalaysiaManifestListBlInfoVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<MalaysiaManifestListBlInfoVO> models = new ArrayList<MalaysiaManifestListBlInfoVO>();

    /* Column Info */
    private String porCd = null;

    /* Column Info */
    private String rdCgoFlg = null;

    /* Column Info */
    private String blNo = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String polCd = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String description = null;

    /* Column Info */
    private String bbCgoFlg = null;

    /* Column Info */
    private String wgtUtCd = null;

    /* Column Info */
    private String measQty = null;

    /* Column Info */
    private String dcgoFlg = null;

    /* Column Info */
    private String pckQty = null;

    /* Column Info */
    private String rcvTermCd = null;

    /* Column Info */
    private String pckTpCd = null;

    /* Column Info */
    private String measUtCd = null;

    /* Column Info */
    private String trnkPol = null;

    /* Column Info */
    private String awkCgoFlg = null;

    /* Column Info */
    private String trsmSts = null;

    /* Column Info */
    private String delCd = null;

    /* Column Info */
    private String actWgt = null;

    /* Column Info */
    private String podCd = null;

    /* Column Info */
    private String vvd = null;

    /* Column Info */
    private String deTermCd = null;

    /* Column Info */
    private String bkgNo = null;

    /* Column Info */
    private String trnkPod = null;

    /* Column Info */
    private String trnkVvd = null;

    /* Column Info */
    private String eIInd = null;

    /* Column Info */
    private String inputPolCd = null;

    /* Column Info */
    private String inputPodCd = null;

    /* Column Info */
    private String cntrNo = null;

    /* Column Info */
    private String usrId = null;

    /* Column Info */
    private String description2 = null;

    /* Column Info */
    private String blKnt = null;

    /* Column Info */
    private String ttlCntrKnt = null;

    /* Column Info */
    private String tsTpCd = null;

    /* Column Info */
    private String cnFlg = null;

    /* Column Info */
    private String cmSeq = null;

    /* Column Info */
    private String preVvd = null;

    /* Column Info */
    private String prePolCd = null;

    /* Column Info */
    private String prePodCd = null;

    /* Column Info */
    private String nextVvd = null;

    /* Column Info */
    private String nextPolCd = null;

    /* Column Info */
    private String nextPodCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public MalaysiaManifestListBlInfoVO() {
    }

    public MalaysiaManifestListBlInfoVO(String ibflag, String pagerows, String cnFlg, String blNo, String tsTpCd, String bkgNo, String porCd, String polCd, String podCd, String delCd, String rcvTermCd, String deTermCd, String trnkVvd, String trnkPol, String trnkPod, String description, String pckQty, String pckTpCd, String actWgt, String wgtUtCd, String measQty, String measUtCd, String dcgoFlg, String rdCgoFlg, String awkCgoFlg, String bbCgoFlg, String vvd, String trsmSts, String eIInd, String inputPolCd, String inputPodCd, String cntrNo, String usrId, String description2, String blKnt, String ttlCntrKnt, String cmSeq, String preVvd, String prePolCd, String prePodCd, String nextVvd, String nextPolCd, String nextPodCd) {
        this.porCd = porCd;
        this.rdCgoFlg = rdCgoFlg;
        this.blNo = blNo;
        this.pagerows = pagerows;
        this.polCd = polCd;
        this.ibflag = ibflag;
        this.description = description;
        this.bbCgoFlg = bbCgoFlg;
        this.wgtUtCd = wgtUtCd;
        this.measQty = measQty;
        this.dcgoFlg = dcgoFlg;
        this.pckQty = pckQty;
        this.rcvTermCd = rcvTermCd;
        this.pckTpCd = pckTpCd;
        this.measUtCd = measUtCd;
        this.trnkPol = trnkPol;
        this.awkCgoFlg = awkCgoFlg;
        this.trsmSts = trsmSts;
        this.delCd = delCd;
        this.actWgt = actWgt;
        this.podCd = podCd;
        this.vvd = vvd;
        this.deTermCd = deTermCd;
        this.bkgNo = bkgNo;
        this.trnkPod = trnkPod;
        this.trnkVvd = trnkVvd;
        this.eIInd = eIInd;
        this.inputPolCd = inputPolCd;
        this.inputPodCd = inputPodCd;
        this.cntrNo = cntrNo;
        this.usrId = usrId;
        this.description2 = description2;
        this.blKnt = blKnt;
        this.ttlCntrKnt = ttlCntrKnt;
        this.tsTpCd = tsTpCd;
        this.cnFlg = cnFlg;
        this.cmSeq = cmSeq;
        this.preVvd = preVvd;
        this.prePolCd = prePolCd;
        this.prePodCd = prePodCd;
        this.nextVvd = nextVvd;
        this.nextPolCd = nextPolCd;
        this.nextPodCd = nextPodCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("por_cd", getPorCd());
        this.hashColumns.put("rd_cgo_flg", getRdCgoFlg());
        this.hashColumns.put("bl_no", getBlNo());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("description", getDescription());
        this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
        this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
        this.hashColumns.put("meas_qty", getMeasQty());
        this.hashColumns.put("dcgo_flg", getDcgoFlg());
        this.hashColumns.put("pck_qty", getPckQty());
        this.hashColumns.put("rcv_term_cd", getRcvTermCd());
        this.hashColumns.put("pck_tp_cd", getPckTpCd());
        this.hashColumns.put("meas_ut_cd", getMeasUtCd());
        this.hashColumns.put("trnk_pol", getTrnkPol());
        this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
        this.hashColumns.put("trsm_sts", getTrsmSts());
        this.hashColumns.put("del_cd", getDelCd());
        this.hashColumns.put("act_wgt", getActWgt());
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("vvd", getVvd());
        this.hashColumns.put("de_term_cd", getDeTermCd());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("trnk_pod", getTrnkPod());
        this.hashColumns.put("trnk_vvd", getTrnkVvd());
        this.hashColumns.put("e_i_ind", getEIInd());
        this.hashColumns.put("input_pol_cd", getInputPolCd());
        this.hashColumns.put("input_pod_cd", getInputPodCd());
        this.hashColumns.put("cntr_no", getCntrNo());
        this.hashColumns.put("usr_id", getUsrId());
        this.hashColumns.put("description2", getDescription2());
        this.hashColumns.put("bl_knt", getBlKnt());
        this.hashColumns.put("ttl_cntr_knt", getTtlCntrKnt());
        this.hashColumns.put("ts_tp_cd", getTsTpCd());
        this.hashColumns.put("cn_flg", getCnFlg());
        this.hashColumns.put("cm_seq", getCmSeq());
        this.hashColumns.put("pre_vvd", getPreVvd());
        this.hashColumns.put("pre_pol_cd", getPrePolCd());
        this.hashColumns.put("pre_pod_cd", getPrePodCd());
        this.hashColumns.put("next_vvd", getNextVvd());
        this.hashColumns.put("next_pol_cd", getNextPolCd());
        this.hashColumns.put("next_pod_cd", getNextPodCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("por_cd", "porCd");
        this.hashFields.put("rd_cgo_flg", "rdCgoFlg");
        this.hashFields.put("bl_no", "blNo");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("description", "description");
        this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
        this.hashFields.put("wgt_ut_cd", "wgtUtCd");
        this.hashFields.put("meas_qty", "measQty");
        this.hashFields.put("dcgo_flg", "dcgoFlg");
        this.hashFields.put("pck_qty", "pckQty");
        this.hashFields.put("rcv_term_cd", "rcvTermCd");
        this.hashFields.put("pck_tp_cd", "pckTpCd");
        this.hashFields.put("meas_ut_cd", "measUtCd");
        this.hashFields.put("trnk_pol", "trnkPol");
        this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
        this.hashFields.put("trsm_sts", "trsmSts");
        this.hashFields.put("del_cd", "delCd");
        this.hashFields.put("act_wgt", "actWgt");
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("vvd", "vvd");
        this.hashFields.put("de_term_cd", "deTermCd");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("trnk_pod", "trnkPod");
        this.hashFields.put("trnk_vvd", "trnkVvd");
        this.hashFields.put("e_i_ind", "eIInd");
        this.hashFields.put("input_pol_cd", "inputPolCd");
        this.hashFields.put("input_pod_cd", "inputPodCd");
        this.hashFields.put("cntr_no", "cntrNo");
        this.hashFields.put("usr_id", "usrId");
        this.hashFields.put("description2", "description2");
        this.hashFields.put("bl_knt", "blKnt");
        this.hashFields.put("ttl_cntr_knt", "ttlCntrKnt");
        this.hashFields.put("ts_tp_cd", "tsTpCd");
        this.hashFields.put("cn_flg", "cnFlg");
        this.hashFields.put("cm_seq", "cmSeq");
        this.hashFields.put("pre_vvd", "preVvd");
        this.hashFields.put("pre_pol_cd", "prePolCd");
        this.hashFields.put("pre_pod_cd", "prePodCd");
        this.hashFields.put("next_vvd", "nextVvd");
        this.hashFields.put("next_pol_cd", "nextPolCd");
        this.hashFields.put("next_pod_cd", "nextPodCd");
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
	 * @return rdCgoFlg
	 */
    public String getRdCgoFlg() {
        return this.rdCgoFlg;
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
	 * @return description
	 */
    public String getDescription() {
        return this.description;
    }

    /**
	 * Column Info
	 * @return bbCgoFlg
	 */
    public String getBbCgoFlg() {
        return this.bbCgoFlg;
    }

    /**
	 * Column Info
	 * @return wgtUtCd
	 */
    public String getWgtUtCd() {
        return this.wgtUtCd;
    }

    /**
	 * Column Info
	 * @return measQty
	 */
    public String getMeasQty() {
        return this.measQty;
    }

    /**
	 * Column Info
	 * @return dcgoFlg
	 */
    public String getDcgoFlg() {
        return this.dcgoFlg;
    }

    /**
	 * Column Info
	 * @return pckQty
	 */
    public String getPckQty() {
        return this.pckQty;
    }

    /**
	 * Column Info
	 * @return rcvTermCd
	 */
    public String getRcvTermCd() {
        return this.rcvTermCd;
    }

    /**
	 * Column Info
	 * @return pckTpCd
	 */
    public String getPckTpCd() {
        return this.pckTpCd;
    }

    /**
	 * Column Info
	 * @return measUtCd
	 */
    public String getMeasUtCd() {
        return this.measUtCd;
    }

    /**
	 * Column Info
	 * @return trnkPol
	 */
    public String getTrnkPol() {
        return this.trnkPol;
    }

    /**
	 * Column Info
	 * @return awkCgoFlg
	 */
    public String getAwkCgoFlg() {
        return this.awkCgoFlg;
    }

    /**
	 * Column Info
	 * @return trsmSts
	 */
    public String getTrsmSts() {
        return this.trsmSts;
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
	 * @return actWgt
	 */
    public String getActWgt() {
        return this.actWgt;
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
	 * @return vvd
	 */
    public String getVvd() {
        return this.vvd;
    }

    /**
	 * Column Info
	 * @return deTermCd
	 */
    public String getDeTermCd() {
        return this.deTermCd;
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
	 * @return trnkPod
	 */
    public String getTrnkPod() {
        return this.trnkPod;
    }

    /**
	 * Column Info
	 * @return trnkVvd
	 */
    public String getTrnkVvd() {
        return this.trnkVvd;
    }

    /**
	 * Column Info
	 * @return eIInd
	 */
    public String getEIInd() {
        return this.eIInd;
    }

    /**
	 * Column Info
	 * @return inputPolCd
	 */
    public String getInputPolCd() {
        return this.inputPolCd;
    }

    /**
	 * Column Info
	 * @return inputPodCd
	 */
    public String getInputPodCd() {
        return this.inputPodCd;
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
	 * @return usrId
	 */
    public String getUsrId() {
        return this.usrId;
    }

    /**
	 * Column Info
	 * @return description2
	 */
    public String getDescription2() {
        return this.description2;
    }

    /**
	 * Column Info
	 * @return blKnt
	 */
    public String getBlKnt() {
        return this.blKnt;
    }

    /**
	 * Column Info
	 * @return ttlCntrKnt
	 */
    public String getTtlCntrKnt() {
        return this.ttlCntrKnt;
    }

    /**
	 * Column Info
	 * @param porCd
	 */
    public void setPorCd(String porCd) {
        this.porCd = porCd;
    }

    /**
	 * Page Number
	 * @return tsTpCd
	 */
    public String getTsTpCd() {
        return this.tsTpCd;
    }

    /**
	 * Page Number
	 * @return cnFlg
	 */
    public String getCnFlg() {
        return this.cnFlg;
    }

    /**
	 * Column Info
	 * @param rdCgoFlg
	 */
    public void setRdCgoFlg(String rdCgoFlg) {
        this.rdCgoFlg = rdCgoFlg;
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
	 * @param description
	 */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
	 * Column Info
	 * @param bbCgoFlg
	 */
    public void setBbCgoFlg(String bbCgoFlg) {
        this.bbCgoFlg = bbCgoFlg;
    }

    /**
	 * Column Info
	 * @param wgtUtCd
	 */
    public void setWgtUtCd(String wgtUtCd) {
        this.wgtUtCd = wgtUtCd;
    }

    /**
	 * Column Info
	 * @param measQty
	 */
    public void setMeasQty(String measQty) {
        this.measQty = measQty;
    }

    /**
	 * Column Info
	 * @param dcgoFlg
	 */
    public void setDcgoFlg(String dcgoFlg) {
        this.dcgoFlg = dcgoFlg;
    }

    /**
	 * Column Info
	 * @param pckQty
	 */
    public void setPckQty(String pckQty) {
        this.pckQty = pckQty;
    }

    /**
	 * Column Info
	 * @param rcvTermCd
	 */
    public void setRcvTermCd(String rcvTermCd) {
        this.rcvTermCd = rcvTermCd;
    }

    /**
	 * Column Info
	 * @param pckTpCd
	 */
    public void setPckTpCd(String pckTpCd) {
        this.pckTpCd = pckTpCd;
    }

    /**
	 * Column Info
	 * @param measUtCd
	 */
    public void setMeasUtCd(String measUtCd) {
        this.measUtCd = measUtCd;
    }

    /**
	 * Column Info
	 * @param trnkPol
	 */
    public void setTrnkPol(String trnkPol) {
        this.trnkPol = trnkPol;
    }

    /**
	 * Column Info
	 * @param awkCgoFlg
	 */
    public void setAwkCgoFlg(String awkCgoFlg) {
        this.awkCgoFlg = awkCgoFlg;
    }

    /**
	 * Column Info
	 * @param trsmSts
	 */
    public void setTrsmSts(String trsmSts) {
        this.trsmSts = trsmSts;
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
	 * @param actWgt
	 */
    public void setActWgt(String actWgt) {
        this.actWgt = actWgt;
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
	 * @param vvd
	 */
    public void setVvd(String vvd) {
        this.vvd = vvd;
    }

    /**
	 * Column Info
	 * @param deTermCd
	 */
    public void setDeTermCd(String deTermCd) {
        this.deTermCd = deTermCd;
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
	 * @param trnkPod
	 */
    public void setTrnkPod(String trnkPod) {
        this.trnkPod = trnkPod;
    }

    /**
	 * Column Info
	 * @param trnkVvd
	 */
    public void setTrnkVvd(String trnkVvd) {
        this.trnkVvd = trnkVvd;
    }

    /**
	 * Column Info
	 * @param eIInd
	 */
    public void setEIInd(String eIInd) {
        this.eIInd = eIInd;
    }

    /**
	 * Column Info
	 * @param inputPolCd
	 */
    public void setInputPolCd(String inputPolCd) {
        this.inputPolCd = inputPolCd;
    }

    /**
	 * Column Info
	 * @param inputPodCd
	 */
    public void setInputPodCd(String inputPodCd) {
        this.inputPodCd = inputPodCd;
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
	 * @param usrId
	 */
    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

    /**
	 * Column Info
	 * @param description2
	 */
    public void setDescription2(String description2) {
        this.description2 = description2;
    }

    /**
	 * Column Info
	 * @param blKnt
	 */
    public void setBlKnt(String blKnt) {
        this.blKnt = blKnt;
    }

    /**
	 * Column Info
	 * @param ttlCntrKnt
	 */
    public void setTtlCntrKnt(String ttlCntrKnt) {
        this.ttlCntrKnt = ttlCntrKnt;
    }

    /**
	 * Column Info
	 * @param cnFlg
	 */
    public void setCnFlg(String cnFlg) {
        this.cnFlg = cnFlg;
    }

    /**
	 * Page Number
	 * @param tsTpCd
	 */
    public void setTsTpCd(String tsTpCd) {
        this.tsTpCd = tsTpCd;
    }

    public void setCmSeq(String cmSeq) {
        this.cmSeq = cmSeq;
    }

    public String getCmSeq() {
        return this.cmSeq;
    }

    public void setPreVvd(String preVvd) {
        this.preVvd = preVvd;
    }

    public String getPreVvd() {
        return this.preVvd;
    }

    public void setPrePolCd(String prePolCd) {
        this.prePolCd = prePolCd;
    }

    public String getPrePolCd() {
        return this.prePolCd;
    }

    public void setPrePodCd(String prePodCd) {
        this.prePodCd = prePodCd;
    }

    public String getPrePodCd() {
        return this.prePodCd;
    }

    public void setNextVvd(String nextVvd) {
        this.nextVvd = nextVvd;
    }

    public String getNextVvd() {
        return this.nextVvd;
    }

    public void setNextPolCd(String nextPolCd) {
        this.nextPolCd = nextPolCd;
    }

    public String getNextPolCd() {
        return this.nextPolCd;
    }

    public void setNextPodCd(String nextPodCd) {
        this.nextPodCd = nextPodCd;
    }

    public String getNextPodCd() {
        return this.nextPodCd;
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
        setRdCgoFlg(JSPUtil.getParameter(request, prefix + "rd_cgo_flg", ""));
        setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setDescription(JSPUtil.getParameter(request, prefix + "description", ""));
        setBbCgoFlg(JSPUtil.getParameter(request, prefix + "bb_cgo_flg", ""));
        setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
        setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
        setDcgoFlg(JSPUtil.getParameter(request, prefix + "dcgo_flg", ""));
        setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
        setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
        setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
        setMeasUtCd(JSPUtil.getParameter(request, prefix + "meas_ut_cd", ""));
        setTrnkPol(JSPUtil.getParameter(request, prefix + "trnk_pol", ""));
        setAwkCgoFlg(JSPUtil.getParameter(request, prefix + "awk_cgo_flg", ""));
        setTrsmSts(JSPUtil.getParameter(request, prefix + "trsm_sts", ""));
        setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
        setActWgt(JSPUtil.getParameter(request, prefix + "act_wgt", ""));
        setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
        setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
        setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setTrnkPod(JSPUtil.getParameter(request, prefix + "trnk_pod", ""));
        setTrnkVvd(JSPUtil.getParameter(request, prefix + "trnk_vvd", ""));
        setEIInd(JSPUtil.getParameter(request, prefix + "e_i_ind", ""));
        setInputPolCd(JSPUtil.getParameter(request, prefix + "input_pol_cd", ""));
        setInputPodCd(JSPUtil.getParameter(request, prefix + "input_pod_cd", ""));
        setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
        setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
        setDescription2(JSPUtil.getParameter(request, prefix + "description2", ""));
        setBlKnt(JSPUtil.getParameter(request, prefix + "bl_knt", ""));
        setTtlCntrKnt(JSPUtil.getParameter(request, prefix + "ttl_cntr_knt", ""));
        setTsTpCd(JSPUtil.getParameter(request, prefix + "ts_tp_cd", ""));
        setCnFlg(JSPUtil.getParameter(request, prefix + "cn_flg", ""));
        setCmSeq(JSPUtil.getParameter(request, prefix + "cm_seq", ""));
        setPreVvd(JSPUtil.getParameter(request, prefix + "pre_vvd", ""));
        setPrePolCd(JSPUtil.getParameter(request, prefix + "pre_pol_cd", ""));
        setPrePodCd(JSPUtil.getParameter(request, prefix + "pre_pod_cd", ""));
        setNextVvd(JSPUtil.getParameter(request, prefix + "next_vvd", ""));
        setNextPolCd(JSPUtil.getParameter(request, prefix + "next_pol_cd", ""));
        setNextPodCd(JSPUtil.getParameter(request, prefix + "next_pod_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MalaysiaManifestListBlInfoVO[]
	 */
    public MalaysiaManifestListBlInfoVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MalaysiaManifestListBlInfoVO[]
	 */
    public MalaysiaManifestListBlInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        MalaysiaManifestListBlInfoVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] porCd = (JSPUtil.getParameter(request, prefix + "por_cd", length));
            String[] rdCgoFlg = (JSPUtil.getParameter(request, prefix + "rd_cgo_flg", length));
            String[] blNo = (JSPUtil.getParameter(request, prefix + "bl_no", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] description = (JSPUtil.getParameter(request, prefix + "description", length));
            String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix + "bb_cgo_flg", length));
            String[] wgtUtCd = (JSPUtil.getParameter(request, prefix + "wgt_ut_cd", length));
            String[] measQty = (JSPUtil.getParameter(request, prefix + "meas_qty", length));
            String[] dcgoFlg = (JSPUtil.getParameter(request, prefix + "dcgo_flg", length));
            String[] pckQty = (JSPUtil.getParameter(request, prefix + "pck_qty", length));
            String[] rcvTermCd = (JSPUtil.getParameter(request, prefix + "rcv_term_cd", length));
            String[] pckTpCd = (JSPUtil.getParameter(request, prefix + "pck_tp_cd", length));
            String[] measUtCd = (JSPUtil.getParameter(request, prefix + "meas_ut_cd", length));
            String[] trnkPol = (JSPUtil.getParameter(request, prefix + "trnk_pol", length));
            String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix + "awk_cgo_flg", length));
            String[] trsmSts = (JSPUtil.getParameter(request, prefix + "trsm_sts", length));
            String[] delCd = (JSPUtil.getParameter(request, prefix + "del_cd", length));
            String[] actWgt = (JSPUtil.getParameter(request, prefix + "act_wgt", length));
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
            String[] vvd = (JSPUtil.getParameter(request, prefix + "vvd", length));
            String[] deTermCd = (JSPUtil.getParameter(request, prefix + "de_term_cd", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] trnkPod = (JSPUtil.getParameter(request, prefix + "trnk_pod", length));
            String[] trnkVvd = (JSPUtil.getParameter(request, prefix + "trnk_vvd", length));
            String[] eIInd = (JSPUtil.getParameter(request, prefix + "e_i_ind", length));
            String[] inputPolCd = (JSPUtil.getParameter(request, prefix + "input_pol_cd", length));
            String[] inputPodCd = (JSPUtil.getParameter(request, prefix + "input_pod_cd", length));
            String[] cntrNo = (JSPUtil.getParameter(request, prefix + "cntr_no", length));
            String[] usrId = (JSPUtil.getParameter(request, prefix + "usr_id", length));
            String[] description2 = (JSPUtil.getParameter(request, prefix + "description2", length));
            String[] blKnt = (JSPUtil.getParameter(request, prefix + "bl_knt", length));
            String[] ttlCntrKnt = (JSPUtil.getParameter(request, prefix + "ttl_cntr_knt", length));
            String[] tsTpCd = (JSPUtil.getParameter(request, prefix + "ts_tp_cd", length));
            String[] cnFlg = (JSPUtil.getParameter(request, prefix + "cn_flg", length));
            String[] cmSeq = (JSPUtil.getParameter(request, prefix + "cm_seq", length));
            String[] preVvd = (JSPUtil.getParameter(request, prefix + "pre_vvd", length));
	    	String[] prePolCd = (JSPUtil.getParameter(request, prefix + "pre_pol_cd", length));
	    	String[] prePodCd = (JSPUtil.getParameter(request, prefix + "pre_pod_cd", length));
	    	String[] nextVvd = (JSPUtil.getParameter(request, prefix + "next_vvd", length));
	    	String[] nextPolCd = (JSPUtil.getParameter(request, prefix + "next_pol_cd", length));
	    	String[] nextPodCd = (JSPUtil.getParameter(request, prefix + "next_pod_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new MalaysiaManifestListBlInfoVO();
                if (porCd[i] != null)
                    model.setPorCd(porCd[i]);
                if (rdCgoFlg[i] != null)
                    model.setRdCgoFlg(rdCgoFlg[i]);
                if (blNo[i] != null)
                    model.setBlNo(blNo[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (description[i] != null)
                    model.setDescription(description[i]);
                if (bbCgoFlg[i] != null)
                    model.setBbCgoFlg(bbCgoFlg[i]);
                if (wgtUtCd[i] != null)
                    model.setWgtUtCd(wgtUtCd[i]);
                if (measQty[i] != null)
                    model.setMeasQty(measQty[i]);
                if (dcgoFlg[i] != null)
                    model.setDcgoFlg(dcgoFlg[i]);
                if (pckQty[i] != null)
                    model.setPckQty(pckQty[i]);
                if (rcvTermCd[i] != null)
                    model.setRcvTermCd(rcvTermCd[i]);
                if (pckTpCd[i] != null)
                    model.setPckTpCd(pckTpCd[i]);
                if (measUtCd[i] != null)
                    model.setMeasUtCd(measUtCd[i]);
                if (trnkPol[i] != null)
                    model.setTrnkPol(trnkPol[i]);
                if (awkCgoFlg[i] != null)
                    model.setAwkCgoFlg(awkCgoFlg[i]);
                if (trsmSts[i] != null)
                    model.setTrsmSts(trsmSts[i]);
                if (delCd[i] != null)
                    model.setDelCd(delCd[i]);
                if (actWgt[i] != null)
                    model.setActWgt(actWgt[i]);
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (vvd[i] != null)
                    model.setVvd(vvd[i]);
                if (deTermCd[i] != null)
                    model.setDeTermCd(deTermCd[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (trnkPod[i] != null)
                    model.setTrnkPod(trnkPod[i]);
                if (trnkVvd[i] != null)
                    model.setTrnkVvd(trnkVvd[i]);
                if (eIInd[i] != null)
                    model.setEIInd(eIInd[i]);
                if (inputPolCd[i] != null)
                    model.setInputPolCd(inputPolCd[i]);
                if (inputPodCd[i] != null)
                    model.setInputPodCd(inputPodCd[i]);
                if (cntrNo[i] != null)
                    model.setCntrNo(cntrNo[i]);
                if (usrId[i] != null)
                    model.setUsrId(usrId[i]);
                if (description2[i] != null)
                    model.setDescription2(description2[i]);
                if (blKnt[i] != null)
                    model.setBlKnt(blKnt[i]);
                if (ttlCntrKnt[i] != null)
                    model.setTtlCntrKnt(ttlCntrKnt[i]);
                if (tsTpCd[i] != null)
                    model.setTsTpCd(tsTpCd[i]);
                if (cnFlg[i] != null)
                    model.setCnFlg(cnFlg[i]);
                if (cmSeq[i] != null)
                    model.setCmSeq(cmSeq[i]);
                if (preVvd[i] != null) 
		    		model.setPreVvd(preVvd[i]);
				if (prePolCd[i] != null) 
		    		model.setPrePolCd(prePolCd[i]);
				if (prePodCd[i] != null) 
		    		model.setPrePodCd(prePodCd[i]);
				if (nextVvd[i] != null) 
		    		model.setNextVvd(nextVvd[i]);
				if (nextPolCd[i] != null) 
		    		model.setNextPolCd(nextPolCd[i]);
				if (nextPodCd[i] != null) 
		    		model.setNextPodCd(nextPodCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getMalaysiaManifestListBlInfoVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return MalaysiaManifestListBlInfoVO[]
	 */
    public MalaysiaManifestListBlInfoVO[] getMalaysiaManifestListBlInfoVOs() {
        MalaysiaManifestListBlInfoVO[] vos = (MalaysiaManifestListBlInfoVO[]) models.toArray(new MalaysiaManifestListBlInfoVO[models.size()]);
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
        this.rdCgoFlg = this.rdCgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blNo = this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.description = this.description.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bbCgoFlg = this.bbCgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.wgtUtCd = this.wgtUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.measQty = this.measQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dcgoFlg = this.dcgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pckQty = this.pckQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcvTermCd = this.rcvTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pckTpCd = this.pckTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.measUtCd = this.measUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trnkPol = this.trnkPol.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.awkCgoFlg = this.awkCgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trsmSts = this.trsmSts.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delCd = this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.actWgt = this.actWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvd = this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deTermCd = this.deTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trnkPod = this.trnkPod.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trnkVvd = this.trnkVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eIInd = this.eIInd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inputPolCd = this.inputPolCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inputPodCd = this.inputPodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrNo = this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usrId = this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.description2 = this.description2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blKnt = this.blKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ttlCntrKnt = this.ttlCntrKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tsTpCd = this.tsTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cnFlg = this.cnFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmSeq = this.cmSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.preVvd = this.preVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prePolCd = this.prePolCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prePodCd = this.prePodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nextVvd = this.nextVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nextPolCd = this.nextPolCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nextPodCd = this.nextPodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}

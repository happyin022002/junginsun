/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TroDtlVO.java
*@FileTitle : TroDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.09
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.12.09 이남경 
* 1.0 Creation
* 2010.09.17 전성진 [CHM-201005982] [ESM-BKG] 미주지역 TRO 화면상에 W/O preview 버튼 추가 (TRS 정보 link)
		                           trspWoNo, trspWoOfcCtyCd, trspWoSeq 추가
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo;

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
 * @author 이남경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class TroDtlVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<TroDtlVO> models = new ArrayList<TroDtlVO>();

    /* Column Info */
    private String dorArrDt = null;

    /* Column Info */
    private String cxlFlg = null;

    /* Column Info */
    private String creDt = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String pctlNo = null;

    /* Column Info */
    private String pkupYdCd = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String cmdtCd = null;

    /* Column Info */
    private String cntrTpszCd = null;

    /* Column Info */
    private String del = null;

    /* Column Info */
    private String rtnTroFlg = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String pkupLocCd = null;

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String troQty = null;

    /* Column Info */
    private String troSubSeq = null;

    /* Column Info */
    private String cxlFlgOld = null;

    /* Column Info */
    private String cntrTpszCdOld = null;

    /* Column Info */
    private String troSeq = null;

    /* Column Info */
    private String rtnYdCd = null;

    /* Column Info */
    private String soUsrNm = null;

    /* Column Info */
    private String ioBndCd = null;

    /* Column Info */
    private String soCreDt = null;

    /* Column Info */
    private String cmdtNm = null;

    /* Column Info */
    private String bkgNo = null;

    /* Column Info */
    private String rtnLocCd = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String soCreUsrId = null;

    /* Column Info */
    private String trspSoNo = null;

    /* Column Info */
    private String dorArrDtHhmi = null;

    /* Column Info */
    private String cntrNo = null;

    /* Column Info */
    private String troQtyOld = null;

    /* Column Info */
    private String frFlg = null;

    /* Column Info */
    private String splitRmk = null;

    /* Column Info */
    private String trspWoNo = null;

    /* Column Info */
    private String trspWoOfcCtyCd = null;

    /* Column Info */
    private String trspWoSeq = null;

    /* Column Info */
    private String pkupDt = null;

    /* Column Info */
    private String pkupDtHhmi = null;

    /* Column Info */
    private String xterTroSeq = null;

    /* Column Info */
    private String xterTroSubSeq = null;

    /* Column Info */
    private String updUsrIdOld = null;

    /* Column Info */
    private String updDtOld = null;

    /* Column Info */
    private String copNo = null;

    /* Column Info */
    private String railSo = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public TroDtlVO() {
    }

    public TroDtlVO(String ibflag, String pagerows, String bkgNo, String del, String ioBndCd, String rtnTroFlg, String troSeq, String troSubSeq, String cntrTpszCd, String troQty, String cntrTpszCdOld, String troQtyOld, String cntrNo, String dorArrDt, String dorArrDtHhmi, String pkupLocCd, String pkupYdCd, String rtnLocCd, String rtnYdCd, String cmdtCd, String cmdtNm, String pctlNo, String cxlFlg, String creUsrId, String creDt, String updUsrId, String updDt, String trspSoNo, String soCreDt, String soCreUsrId, String soUsrNm, String frFlg, String cxlFlgOld, String splitRmk, String trspWoNo, String trspWoOfcCtyCd, String trspWoSeq, String pkupDt, String pkupDtHhmi, String xterTroSeq, String xterTroSubSeq, String updUsrIdOld, String updDtOld, String copNo, String railSo) {
        this.dorArrDt = dorArrDt;
        this.cxlFlg = cxlFlg;
        this.creDt = creDt;
        this.pagerows = pagerows;
        this.pctlNo = pctlNo;
        this.pkupYdCd = pkupYdCd;
        this.ibflag = ibflag;
        this.cmdtCd = cmdtCd;
        this.cntrTpszCd = cntrTpszCd;
        this.del = del;
        this.rtnTroFlg = rtnTroFlg;
        this.updUsrId = updUsrId;
        this.pkupLocCd = pkupLocCd;
        this.updDt = updDt;
        this.troQty = troQty;
        this.troSubSeq = troSubSeq;
        this.cxlFlgOld = cxlFlgOld;
        this.cntrTpszCdOld = cntrTpszCdOld;
        this.troSeq = troSeq;
        this.rtnYdCd = rtnYdCd;
        this.soUsrNm = soUsrNm;
        this.ioBndCd = ioBndCd;
        this.soCreDt = soCreDt;
        this.cmdtNm = cmdtNm;
        this.bkgNo = bkgNo;
        this.rtnLocCd = rtnLocCd;
        this.creUsrId = creUsrId;
        this.soCreUsrId = soCreUsrId;
        this.trspSoNo = trspSoNo;
        this.dorArrDtHhmi = dorArrDtHhmi;
        this.cntrNo = cntrNo;
        this.troQtyOld = troQtyOld;
        this.frFlg = frFlg;
        this.splitRmk = splitRmk;
        this.trspWoNo = trspWoNo;
        this.trspWoOfcCtyCd = trspWoOfcCtyCd;
        this.trspWoSeq = trspWoSeq;
        this.pkupDt = pkupDt;
        this.pkupDtHhmi = pkupDtHhmi;
        this.xterTroSeq = xterTroSeq;
        this.xterTroSubSeq = xterTroSubSeq;
        this.updUsrIdOld = updUsrIdOld;
        this.updDtOld = updDtOld;
        this.copNo = copNo;
        this.railSo = railSo;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("dor_arr_dt", getDorArrDt());
        this.hashColumns.put("cxl_flg", getCxlFlg());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("pctl_no", getPctlNo());
        this.hashColumns.put("pkup_yd_cd", getPkupYdCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("cmdt_cd", getCmdtCd());
        this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
        this.hashColumns.put("del", getDel());
        this.hashColumns.put("rtn_tro_flg", getRtnTroFlg());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("pkup_loc_cd", getPkupLocCd());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("tro_qty", getTroQty());
        this.hashColumns.put("tro_sub_seq", getTroSubSeq());
        this.hashColumns.put("cxl_flg_old", getCxlFlgOld());
        this.hashColumns.put("cntr_tpsz_cd_old", getCntrTpszCdOld());
        this.hashColumns.put("tro_seq", getTroSeq());
        this.hashColumns.put("rtn_yd_cd", getRtnYdCd());
        this.hashColumns.put("so_usr_nm", getSoUsrNm());
        this.hashColumns.put("io_bnd_cd", getIoBndCd());
        this.hashColumns.put("so_cre_dt", getSoCreDt());
        this.hashColumns.put("cmdt_nm", getCmdtNm());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("rtn_loc_cd", getRtnLocCd());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("so_cre_usr_id", getSoCreUsrId());
        this.hashColumns.put("trsp_so_no", getTrspSoNo());
        this.hashColumns.put("dor_arr_dt_hhmi", getDorArrDtHhmi());
        this.hashColumns.put("cntr_no", getCntrNo());
        this.hashColumns.put("tro_qty_old", getTroQtyOld());
        this.hashColumns.put("fr_flg", getFrFlg());
        this.hashColumns.put("split_rmk", getSplitRmk());
        this.hashColumns.put("trsp_wo_no", getTrspWoNo());
        this.hashColumns.put("trsp_wo_ofc_cty_cd", getTrspWoOfcCtyCd());
        this.hashColumns.put("trsp_wo_seq", getTrspWoSeq());
        this.hashColumns.put("pkup_dt", getPkupDt());
        this.hashColumns.put("pkup_dt_hhmi", getPkupDtHhmi());
        this.hashColumns.put("xter_tro_seq", getXterTroSeq());
        this.hashColumns.put("xter_tro_sub_seq", getXterTroSubSeq());
        this.hashColumns.put("upd_usr_id_old", getUpdUsrIdOld());
        this.hashColumns.put("upd_dt_old", getUpdDtOld());
        this.hashColumns.put("cop_no", getCopNo());
        this.hashColumns.put("rail_so", getRailSo());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("dor_arr_dt", "dorArrDt");
        this.hashFields.put("cxl_flg", "cxlFlg");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("pctl_no", "pctlNo");
        this.hashFields.put("pkup_yd_cd", "pkupYdCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("cmdt_cd", "cmdtCd");
        this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
        this.hashFields.put("del", "del");
        this.hashFields.put("rtn_tro_flg", "rtnTroFlg");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("pkup_loc_cd", "pkupLocCd");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("tro_qty", "troQty");
        this.hashFields.put("tro_sub_seq", "troSubSeq");
        this.hashFields.put("cxl_flg_old", "cxlFlgOld");
        this.hashFields.put("cntr_tpsz_cd_old", "cntrTpszCdOld");
        this.hashFields.put("tro_seq", "troSeq");
        this.hashFields.put("rtn_yd_cd", "rtnYdCd");
        this.hashFields.put("so_usr_nm", "soUsrNm");
        this.hashFields.put("io_bnd_cd", "ioBndCd");
        this.hashFields.put("so_cre_dt", "soCreDt");
        this.hashFields.put("cmdt_nm", "cmdtNm");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("rtn_loc_cd", "rtnLocCd");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("so_cre_usr_id", "soCreUsrId");
        this.hashFields.put("trsp_so_no", "trspSoNo");
        this.hashFields.put("dor_arr_dt_hhmi", "dorArrDtHhmi");
        this.hashFields.put("cntr_no", "cntrNo");
        this.hashFields.put("tro_qty_old", "troQtyOld");
        this.hashFields.put("fr_flg", "frFlg");
        this.hashFields.put("split_rmk", "splitRmk");
        this.hashFields.put("trsp_wo_no", "trspWoNo");
        this.hashFields.put("trsp_wo_ofc_cty_cd", "trspWoOfcCtyCd");
        this.hashFields.put("trsp_wo_seq", "trspWoSeq");
        this.hashFields.put("pkup_dt", "pkupDt");
        this.hashFields.put("pkup_dt_hhmi", "pkupDtHhmi");
        this.hashFields.put("xter_tro_seq", "xterTroSeq");
        this.hashFields.put("xter_tro_sub_seq", "xterTroSubSeq");
        this.hashFields.put("upd_usr_id_old", "updUsrIdOld");
        this.hashFields.put("upd_dt_old", "updDtOld");
        this.hashFields.put("cop_no", "copNo");
        this.hashFields.put("rail_so", "railSo");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return splitRmk
	 */
    public String getSplitRmk() {
        return this.splitRmk;
    }

    /**
	 * Column Info
	 * @param splitRmk
	 */
    public void setSplitRmk(String splitRmk) {
        this.splitRmk = splitRmk;
    }

    /**
	 * Column Info
	 * @return dorArrDt
	 */
    public String getDorArrDt() {
        return this.dorArrDt;
    }

    /**
	 * Column Info
	 * @return cxlFlg
	 */
    public String getCxlFlg() {
        return this.cxlFlg;
    }

    /**
	 * Column Info
	 * @return creDt
	 */
    public String getCreDt() {
        return this.creDt;
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
	 * @return pkupYdCd
	 */
    public String getPkupYdCd() {
        return this.pkupYdCd;
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
	 * @return cmdtCd
	 */
    public String getCmdtCd() {
        return this.cmdtCd;
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
	 * @return del
	 */
    public String getDel() {
        return this.del;
    }

    /**
	 * Column Info
	 * @return rtnTroFlg
	 */
    public String getRtnTroFlg() {
        return this.rtnTroFlg;
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
	 * @return pkupLocCd
	 */
    public String getPkupLocCd() {
        return this.pkupLocCd;
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
	 * @return troQty
	 */
    public String getTroQty() {
        return this.troQty;
    }

    /**
	 * Column Info
	 * @return troSubSeq
	 */
    public String getTroSubSeq() {
        return this.troSubSeq;
    }

    /**
	 * Column Info
	 * @return cxlFlgOld
	 */
    public String getCxlFlgOld() {
        return this.cxlFlgOld;
    }

    /**
	 * Column Info
	 * @return cntrTpszCdOld
	 */
    public String getCntrTpszCdOld() {
        return this.cntrTpszCdOld;
    }

    /**
	 * Column Info
	 * @return troSeq
	 */
    public String getTroSeq() {
        return this.troSeq;
    }

    /**
	 * Column Info
	 * @return rtnYdCd
	 */
    public String getRtnYdCd() {
        return this.rtnYdCd;
    }

    /**
	 * Column Info
	 * @return soUsrNm
	 */
    public String getSoUsrNm() {
        return this.soUsrNm;
    }

    /**
	 * Column Info
	 * @return ioBndCd
	 */
    public String getIoBndCd() {
        return this.ioBndCd;
    }

    /**
	 * Column Info
	 * @return soCreDt
	 */
    public String getSoCreDt() {
        return this.soCreDt;
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
	 * @return bkgNo
	 */
    public String getBkgNo() {
        return this.bkgNo;
    }

    /**
	 * Column Info
	 * @return rtnLocCd
	 */
    public String getRtnLocCd() {
        return this.rtnLocCd;
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
	 * @return soCreUsrId
	 */
    public String getSoCreUsrId() {
        return this.soCreUsrId;
    }

    /**
	 * Column Info
	 * @return trspSoNo
	 */
    public String getTrspSoNo() {
        return this.trspSoNo;
    }

    /**
	 * Column Info
	 * @return dorArrDtHhmi
	 */
    public String getDorArrDtHhmi() {
        return this.dorArrDtHhmi;
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
	 * @return troQtyOld
	 */
    public String getTroQtyOld() {
        return this.troQtyOld;
    }

    /**
	 * Column Info
	 * @return frFlg
	 */
    public String getFrFlg() {
        return this.frFlg;
    }

    /**
	 * @return the trspWoNo
	 */
    public String getTrspWoNo() {
        return trspWoNo;
    }

    /**
	 * @return the trspWoOfcCtyCd
	 */
    public String getTrspWoOfcCtyCd() {
        return trspWoOfcCtyCd;
    }

    /**
	 * @return the trspWoSeq
	 */
    public String getTrspWoSeq() {
        return trspWoSeq;
    }

    /**
	 * @return the pkupDt
	 */
    public String getPkupDt() {
        return pkupDt;
    }

    /**
	 * @return the pkupDtHhmi
	 */
    public String getPkupDtHhmi() {
        return pkupDtHhmi;
    }

    /**
	 * @return updUsrIdOld
	 */
    public String getUpdUsrIdOld() {
        return updUsrIdOld;
    }

    /**
	 * @return updDtOld
	 */
    public String getUpdDtOld() {
        return updDtOld;
    }

    /**
	 * @return copNo
	 */
    public String getCopNo() {
        return copNo;
    }

    /**
	 * @return railSo
	 */
    public String getRailSo() {
        return railSo;
    }

    /**
	 * Column Info
	 * @param dorArrDt
	 */
    public void setDorArrDt(String dorArrDt) {
        this.dorArrDt = dorArrDt;
    }

    /**
	 * Column Info
	 * @param cxlFlg
	 */
    public void setCxlFlg(String cxlFlg) {
        this.cxlFlg = cxlFlg;
    }

    /**
	 * Column Info
	 * @param creDt
	 */
    public void setCreDt(String creDt) {
        this.creDt = creDt;
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
	 * @param pkupYdCd
	 */
    public void setPkupYdCd(String pkupYdCd) {
        this.pkupYdCd = pkupYdCd;
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
	 * @param cmdtCd
	 */
    public void setCmdtCd(String cmdtCd) {
        this.cmdtCd = cmdtCd;
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
	 * @param del
	 */
    public void setDel(String del) {
        this.del = del;
    }

    /**
	 * Column Info
	 * @param rtnTroFlg
	 */
    public void setRtnTroFlg(String rtnTroFlg) {
        this.rtnTroFlg = rtnTroFlg;
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
	 * @param pkupLocCd
	 */
    public void setPkupLocCd(String pkupLocCd) {
        this.pkupLocCd = pkupLocCd;
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
	 * @param troQty
	 */
    public void setTroQty(String troQty) {
        this.troQty = troQty;
    }

    /**
	 * Column Info
	 * @param troSubSeq
	 */
    public void setTroSubSeq(String troSubSeq) {
        this.troSubSeq = troSubSeq;
    }

    /**
	 * Column Info
	 * @param cxlFlgOld
	 */
    public void setCxlFlgOld(String cxlFlgOld) {
        this.cxlFlgOld = cxlFlgOld;
    }

    /**
	 * Column Info
	 * @param cntrTpszCdOld
	 */
    public void setCntrTpszCdOld(String cntrTpszCdOld) {
        this.cntrTpszCdOld = cntrTpszCdOld;
    }

    /**
	 * Column Info
	 * @param troSeq
	 */
    public void setTroSeq(String troSeq) {
        this.troSeq = troSeq;
    }

    /**
	 * Column Info
	 * @param rtnYdCd
	 */
    public void setRtnYdCd(String rtnYdCd) {
        this.rtnYdCd = rtnYdCd;
    }

    /**
	 * Column Info
	 * @param soUsrNm
	 */
    public void setSoUsrNm(String soUsrNm) {
        this.soUsrNm = soUsrNm;
    }

    /**
	 * Column Info
	 * @param ioBndCd
	 */
    public void setIoBndCd(String ioBndCd) {
        this.ioBndCd = ioBndCd;
    }

    /**
	 * Column Info
	 * @param soCreDt
	 */
    public void setSoCreDt(String soCreDt) {
        this.soCreDt = soCreDt;
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
	 * @param bkgNo
	 */
    public void setBkgNo(String bkgNo) {
        this.bkgNo = bkgNo;
    }

    /**
	 * Column Info
	 * @param rtnLocCd
	 */
    public void setRtnLocCd(String rtnLocCd) {
        this.rtnLocCd = rtnLocCd;
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
	 * @param soCreUsrId
	 */
    public void setSoCreUsrId(String soCreUsrId) {
        this.soCreUsrId = soCreUsrId;
    }

    /**
	 * Column Info
	 * @param trspSoNo
	 */
    public void setTrspSoNo(String trspSoNo) {
        this.trspSoNo = trspSoNo;
    }

    /**
	 * Column Info
	 * @param dorArrDtHhmi
	 */
    public void setDorArrDtHhmi(String dorArrDtHhmi) {
        this.dorArrDtHhmi = dorArrDtHhmi;
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
	 * @param troQtyOld
	 */
    public void setTroQtyOld(String troQtyOld) {
        this.troQtyOld = troQtyOld;
    }

    /**
	 * Column Info
	 * @param frFlg
	 */
    public void setFrFlg(String frFlg) {
        this.frFlg = frFlg;
    }

    /**
	 * @param trspWoOfcCtyCd the trspWoOfcCtyCd to set
	 */
    public void setTrspWoNo(String trspWoNo) {
        this.trspWoNo = trspWoNo;
    }

    /**
	 * @param trspWoOfcCtyCd the trspWoOfcCtyCd to set
	 */
    public void setTrspWoOfcCtyCd(String trspWoOfcCtyCd) {
        this.trspWoOfcCtyCd = trspWoOfcCtyCd;
    }

    /**
	 * @param trspWoSeq the trspWoSeq to set
	 */
    public void setTrspWoSeq(String trspWoSeq) {
        this.trspWoSeq = trspWoSeq;
    }

    /**
	 * @param pkupDt the pkupDt to set
	 */
    public void setPkupDt(String pkupDt) {
        this.pkupDt = pkupDt;
    }

    /**
	 * @param pkupDtHhmi the pkupDt to set
	 */
    public void setPkupDtHhmi(String pkupDtHhmi) {
        this.pkupDtHhmi = pkupDtHhmi;
    }

    /**
	 * @param updUsrIdOld
	 */
    public void setUpdUsrIdOld(String updUsrIdOld) {
        this.updUsrIdOld = updUsrIdOld;
    }

    /**
	 * @param copNo
	 */
    public void setCopNo(String copNo) {
        this.copNo = copNo;
    }

    /**
	 * @param railSo
	 */
    public void setRailSo(String railSo) {
        this.railSo = railSo;
    }

    /**
	 * @param updDtOld
	 */
    public void setUpdDtOld(String updDtOld) {
        this.updDtOld = updDtOld;
    }

    public void setXterTroSeq(String xterTroSeq) {
        this.xterTroSeq = xterTroSeq;
    }

    public String getXterTroSeq() {
        return this.xterTroSeq;
    }

    public void setXterTroSubSeq(String xterTroSubSeq) {
        this.xterTroSubSeq = xterTroSubSeq;
    }

    public String getXterTroSubSeq() {
        return this.xterTroSubSeq;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setDorArrDt(JSPUtil.getParameter(request, "dor_arr_dt", ""));
        setCxlFlg(JSPUtil.getParameter(request, "cxl_flg", ""));
        setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setPctlNo(JSPUtil.getParameter(request, "pctl_no", ""));
        setPkupYdCd(JSPUtil.getParameter(request, "pkup_yd_cd", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setCmdtCd(JSPUtil.getParameter(request, "cmdt_cd", ""));
        setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
        setDel(JSPUtil.getParameter(request, "del", ""));
        setRtnTroFlg(JSPUtil.getParameter(request, "rtn_tro_flg", ""));
        setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
        setPkupLocCd(JSPUtil.getParameter(request, "pkup_loc_cd", ""));
        setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
        setTroQty(JSPUtil.getParameter(request, "tro_qty", ""));
        setTroSubSeq(JSPUtil.getParameter(request, "tro_sub_seq", ""));
        setCxlFlgOld(JSPUtil.getParameter(request, "cxl_flg_old", ""));
        setCntrTpszCdOld(JSPUtil.getParameter(request, "cntr_tpsz_cd_old", ""));
        setTroSeq(JSPUtil.getParameter(request, "tro_seq", ""));
        setRtnYdCd(JSPUtil.getParameter(request, "rtn_yd_cd", ""));
        setSoUsrNm(JSPUtil.getParameter(request, "so_usr_nm", ""));
        setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
        setSoCreDt(JSPUtil.getParameter(request, "so_cre_dt", ""));
        setCmdtNm(JSPUtil.getParameter(request, "cmdt_nm", ""));
        setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
        setRtnLocCd(JSPUtil.getParameter(request, "rtn_loc_cd", ""));
        setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
        setSoCreUsrId(JSPUtil.getParameter(request, "so_cre_usr_id", ""));
        setTrspSoNo(JSPUtil.getParameter(request, "trsp_so_no", ""));
        setDorArrDtHhmi(JSPUtil.getParameter(request, "dor_arr_dt_hhmi", ""));
        setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
        setTroQtyOld(JSPUtil.getParameter(request, "tro_qty_old", ""));
        setFrFlg(JSPUtil.getParameter(request, "fr_flg", ""));
        setSplitRmk(JSPUtil.getParameter(request, "split_rmk", ""));
        setTrspWoNo(JSPUtil.getParameter(request, "trsp_wo_no", ""));
        setTrspWoOfcCtyCd(JSPUtil.getParameter(request, "trsp_wo_ofc_cty_cd", ""));
        setTrspWoSeq(JSPUtil.getParameter(request, "trsp_wo_seq", ""));
        setPkupDt(JSPUtil.getParameter(request, "pkup_dt", ""));
        setUpdUsrIdOld(JSPUtil.getParameter(request, "upd_usr_id_old", ""));
        setUpdDtOld(JSPUtil.getParameter(request, "upd_dt_old", ""));
        setCopNo(JSPUtil.getParameter(request, "cop_no", ""));
        setRailSo(JSPUtil.getParameter(request, "rail_so", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TroDtlVO[]
	 */
    public TroDtlVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TroDtlVO[]
	 */
    public TroDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        TroDtlVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] dorArrDt = (JSPUtil.getParameter(request, prefix + "dor_arr_dt", length));
            String[] cxlFlg = (JSPUtil.getParameter(request, prefix + "cxl_flg", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] pctlNo = (JSPUtil.getParameter(request, prefix + "pctl_no", length));
            String[] pkupYdCd = (JSPUtil.getParameter(request, prefix + "pkup_yd_cd", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] cmdtCd = (JSPUtil.getParameter(request, prefix + "cmdt_cd", length));
            String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", length));
            String[] del = (JSPUtil.getParameter(request, prefix + "del", length));
            String[] rtnTroFlg = (JSPUtil.getParameter(request, prefix + "rtn_tro_flg", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] pkupLocCd = (JSPUtil.getParameter(request, prefix + "pkup_loc_cd", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] troQty = (JSPUtil.getParameter(request, prefix + "tro_qty", length));
            String[] troSubSeq = (JSPUtil.getParameter(request, prefix + "tro_sub_seq", length));
            String[] cxlFlgOld = (JSPUtil.getParameter(request, prefix + "cxl_flg_old", length));
            String[] cntrTpszCdOld = (JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd_old", length));
            String[] troSeq = (JSPUtil.getParameter(request, prefix + "tro_seq", length));
            String[] rtnYdCd = (JSPUtil.getParameter(request, prefix + "rtn_yd_cd", length));
            String[] soUsrNm = (JSPUtil.getParameter(request, prefix + "so_usr_nm", length));
            String[] ioBndCd = (JSPUtil.getParameter(request, prefix + "io_bnd_cd", length));
            String[] soCreDt = (JSPUtil.getParameter(request, prefix + "so_cre_dt", length));
            String[] cmdtNm = (JSPUtil.getParameter(request, prefix + "cmdt_nm", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] rtnLocCd = (JSPUtil.getParameter(request, prefix + "rtn_loc_cd", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] soCreUsrId = (JSPUtil.getParameter(request, prefix + "so_cre_usr_id", length));
            String[] trspSoNo = (JSPUtil.getParameter(request, prefix + "trsp_so_no", length));
            String[] dorArrDtHhmi = (JSPUtil.getParameter(request, prefix + "dor_arr_dt_hhmi", length));
            String[] cntrNo = (JSPUtil.getParameter(request, prefix + "cntr_no", length));
            String[] troQtyOld = (JSPUtil.getParameter(request, prefix + "tro_qty_old", length));
            String[] frFlg = (JSPUtil.getParameter(request, prefix + "fr_flg", length));
            String[] splitRmk = (JSPUtil.getParameter(request, prefix + "split_rmk", length));
            String[] trspWoNo = (JSPUtil.getParameter(request, prefix + "trsp_wo_no", length));
            String[] trspWoOfcCtyCd = (JSPUtil.getParameter(request, prefix + "trsp_wo_ofc_cty_cd", length));
            String[] trspWoSeq = (JSPUtil.getParameter(request, prefix + "trsp_wo_seq", length));
            String[] pkupDt = (JSPUtil.getParameter(request, prefix + "pkup_dt", length));
            String[] pkupDtHhmi = (JSPUtil.getParameter(request, prefix + "pkup_dt_hhmi", length));
            String[] xterTroSeq = (JSPUtil.getParameter(request, prefix + "xter_tro_seq", length));
            String[] xterTroSubSeq = (JSPUtil.getParameter(request, prefix + "xter_tro_sub_seq", length));
            String[] updUsrIdOld = (JSPUtil.getParameter(request, prefix + "upd_usr_id_old", length));
            String[] updDtOld = (JSPUtil.getParameter(request, prefix + "upd_dt_old", length));
            String[] copNo = (JSPUtil.getParameter(request, prefix + "cop_no", length));
            String[] railSo = (JSPUtil.getParameter(request, prefix + "rail_so", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new TroDtlVO();
                if (dorArrDt[i] != null)
                    model.setDorArrDt(dorArrDt[i]);
                if (cxlFlg[i] != null)
                    model.setCxlFlg(cxlFlg[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (pctlNo[i] != null)
                    model.setPctlNo(pctlNo[i]);
                if (pkupYdCd[i] != null)
                    model.setPkupYdCd(pkupYdCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (cmdtCd[i] != null)
                    model.setCmdtCd(cmdtCd[i]);
                if (cntrTpszCd[i] != null)
                    model.setCntrTpszCd(cntrTpszCd[i]);
                if (del[i] != null)
                    model.setDel(del[i]);
                if (rtnTroFlg[i] != null)
                    model.setRtnTroFlg(rtnTroFlg[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (pkupLocCd[i] != null)
                    model.setPkupLocCd(pkupLocCd[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (troQty[i] != null)
                    model.setTroQty(troQty[i]);
                if (troSubSeq[i] != null)
                    model.setTroSubSeq(troSubSeq[i]);
                if (cxlFlgOld[i] != null)
                    model.setCxlFlgOld(cxlFlgOld[i]);
                if (cntrTpszCdOld[i] != null)
                    model.setCntrTpszCdOld(cntrTpszCdOld[i]);
                if (troSeq[i] != null)
                    model.setTroSeq(troSeq[i]);
                if (rtnYdCd[i] != null)
                    model.setRtnYdCd(rtnYdCd[i]);
                if (soUsrNm[i] != null)
                    model.setSoUsrNm(soUsrNm[i]);
                if (ioBndCd[i] != null)
                    model.setIoBndCd(ioBndCd[i]);
                if (soCreDt[i] != null)
                    model.setSoCreDt(soCreDt[i]);
                if (cmdtNm[i] != null)
                    model.setCmdtNm(cmdtNm[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (rtnLocCd[i] != null)
                    model.setRtnLocCd(rtnLocCd[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (soCreUsrId[i] != null)
                    model.setSoCreUsrId(soCreUsrId[i]);
                if (trspSoNo[i] != null)
                    model.setTrspSoNo(trspSoNo[i]);
                if (dorArrDtHhmi[i] != null)
                    model.setDorArrDtHhmi(dorArrDtHhmi[i]);
                if (cntrNo[i] != null)
                    model.setCntrNo(cntrNo[i]);
                if (troQtyOld[i] != null)
                    model.setTroQtyOld(troQtyOld[i]);
                if (frFlg[i] != null)
                    model.setFrFlg(frFlg[i]);
                if (splitRmk[i] != null)
                    model.setSplitRmk(splitRmk[i]);
                if (trspWoNo[i] != null)
                    model.setTrspWoNo(trspWoNo[i]);
                if (trspWoOfcCtyCd[i] != null)
                    model.setTrspWoOfcCtyCd(trspWoOfcCtyCd[i]);
                if (trspWoSeq[i] != null)
                    model.setTrspWoSeq(trspWoSeq[i]);
                if (pkupDt[i] != null)
                    model.setPkupDt(pkupDt[i]);
                if (pkupDtHhmi[i] != null)
                    model.setPkupDtHhmi(pkupDtHhmi[i]);
                if (xterTroSeq[i] != null)
                    model.setXterTroSeq(xterTroSeq[i]);
                if (xterTroSubSeq[i] != null) 
		    		model.setXterTroSubSeq(xterTroSubSeq[i]);
                if (updUsrIdOld[i] != null) 
		    		model.setUpdUsrIdOld(updUsrIdOld[i]);
                if (updDtOld[i] != null) 
		    		model.setUpdDtOld(updDtOld[i]);
                if (copNo[i] != null) 
		    		model.setCopNo(copNo[i]);
                if (railSo[i] != null) 
		    		model.setRailSo(railSo[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getTroDtlVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return TroDtlVO[]
	 */
    public TroDtlVO[] getTroDtlVOs() {
        TroDtlVO[] vos = (TroDtlVO[]) models.toArray(new TroDtlVO[models.size()]);
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
        this.dorArrDt = this.dorArrDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cxlFlg = this.cxlFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pctlNo = this.pctlNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pkupYdCd = this.pkupYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtCd = this.cmdtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrTpszCd = this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.del = this.del.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtnTroFlg = this.rtnTroFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pkupLocCd = this.pkupLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.troQty = this.troQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.troSubSeq = this.troSubSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cxlFlgOld = this.cxlFlgOld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrTpszCdOld = this.cntrTpszCdOld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.troSeq = this.troSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtnYdCd = this.rtnYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.soUsrNm = this.soUsrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ioBndCd = this.ioBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.soCreDt = this.soCreDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtNm = this.cmdtNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtnLocCd = this.rtnLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.soCreUsrId = this.soCreUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trspSoNo = this.trspSoNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dorArrDtHhmi = this.dorArrDtHhmi.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrNo = this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.troQtyOld = this.troQtyOld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.frFlg = this.frFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.splitRmk = this.splitRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trspWoNo = this.trspWoNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trspWoOfcCtyCd = this.trspWoOfcCtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trspWoSeq = this.trspWoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pkupDt = this.pkupDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pkupDtHhmi = this.pkupDtHhmi.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterTroSeq = this.xterTroSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterTroSubSeq = this.xterTroSubSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrIdOld = this.updUsrIdOld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDtOld = this.updDtOld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.copNo = this.copNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.railSo = this.railSo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}

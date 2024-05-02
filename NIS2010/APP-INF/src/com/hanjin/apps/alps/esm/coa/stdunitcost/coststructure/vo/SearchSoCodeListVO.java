/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSoCodeListVO.java
*@FileTitle : SearchSoCodeListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 김기식
*@LastVersion : 1.0
* 2009.10.16 김기식 
* 1.0 Creation
* 2012.05.08 전윤주 [CHM-201217633] Hinterland cost table 생성 시 필요한 flag 추가
                                  inlnd_expn_use_flg, inlnd_tml_expn_calc_flg, ocn_fdr_expn_use_flg 추가
=========================================================*/

package com.hanjin.apps.alps.esm.coa.stdunitcost.coststructure.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김기식
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSoCodeListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSoCodeListVO> models = new ArrayList<SearchSoCodeListVO>();
	
	/* Column Info */
	private String coaCostSrcCdNm = null;
	/* Column Info */
	private String bkgFullSocCgoFlg = null;
	/* Column Info */
	private String costAssBseCd = null;
	/* Column Info */
	private String spclCgoAwkFlg = null;
	/* Column Info */
	private String bkgMcgoFlg = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String coaCostSrcCd = null;
	/* Column Info */
	private String sgrpCostCd = null;
	/* Column Info */
	private String coaCostSrcPrtCd = null;
	/* Column Info */
	private String costVolCd = null;
	/* Column Info */
	private String stndCostNm = null;
	/* Column Info */
	private String costUtAmtCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String costSrcSysCd = null;
	/* Column Info */
	private String costSrcMon = null;
	/* Column Info */
	private String costVolCd1 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String spclCgoDgFlg = null;
	/* Column Info */
	private String spclCgoRfFlg = null;
	/* Column Info */
	private String bkgRevMcgoFlg = null;
	/* Column Info */
	private String spclCgoBbFlg = null;
	/* Column Info */
	private String fullMtyCd = null;
	/* Column Info */
	private String sgrpCostCdDesc = null;
	/* Column Info */
	private String stndCostCd = null;
	/* Column Info */
	private String inlndExpnUseFlg = null;
	/* Column Info */
	private String inlndTmlExpnCalcFlg = null;	
	/* Column Info */
	private String ocnFdrExpnUseFlg = null;	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSoCodeListVO() {}

	public SearchSoCodeListVO(String ibflag, String pagerows, String deltFlg, String sgrpCostCdDesc, String sgrpCostCd, String stndCostNm, String stndCostCd, String coaCostSrcPrtCd, String costSrcSysCd, String costSrcMon, String coaCostSrcCd, String coaCostSrcCdNm, String costAssBseCd, String costUtAmtCd, String spclCgoDgFlg, String spclCgoRfFlg, String spclCgoAwkFlg, String spclCgoBbFlg, String costVolCd, String costVolCd1, String fullMtyCd, String bkgFullSocCgoFlg, String bkgRevMcgoFlg, String bkgMcgoFlg, String inlndExpnUseFlg, String inlndTmlExpnCalcFlg, String ocnFdrExpnUseFlg ) {
		this.coaCostSrcCdNm = coaCostSrcCdNm;
		this.bkgFullSocCgoFlg = bkgFullSocCgoFlg;
		this.costAssBseCd = costAssBseCd;
		this.spclCgoAwkFlg = spclCgoAwkFlg;
		this.bkgMcgoFlg = bkgMcgoFlg;
		this.deltFlg = deltFlg;
		this.coaCostSrcCd = coaCostSrcCd;
		this.sgrpCostCd = sgrpCostCd;
		this.coaCostSrcPrtCd = coaCostSrcPrtCd;
		this.costVolCd = costVolCd;
		this.stndCostNm = stndCostNm;
		this.costUtAmtCd = costUtAmtCd;
		this.pagerows = pagerows;
		this.costSrcSysCd = costSrcSysCd;
		this.costSrcMon = costSrcMon;
		this.costVolCd1 = costVolCd1;
		this.ibflag = ibflag;
		this.spclCgoDgFlg = spclCgoDgFlg;
		this.spclCgoRfFlg = spclCgoRfFlg;
		this.bkgRevMcgoFlg = bkgRevMcgoFlg;
		this.spclCgoBbFlg = spclCgoBbFlg;
		this.fullMtyCd = fullMtyCd;
		this.sgrpCostCdDesc = sgrpCostCdDesc;
		this.stndCostCd = stndCostCd;
		this.inlndExpnUseFlg = inlndExpnUseFlg;
		this.inlndTmlExpnCalcFlg = inlndTmlExpnCalcFlg;
		this.ocnFdrExpnUseFlg = ocnFdrExpnUseFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("coa_cost_src_cd_nm", getCoaCostSrcCdNm());
		this.hashColumns.put("bkg_full_soc_cgo_flg", getBkgFullSocCgoFlg());
		this.hashColumns.put("cost_ass_bse_cd", getCostAssBseCd());
		this.hashColumns.put("spcl_cgo_awk_flg", getSpclCgoAwkFlg());
		this.hashColumns.put("bkg_mcgo_flg", getBkgMcgoFlg());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("coa_cost_src_cd", getCoaCostSrcCd());
		this.hashColumns.put("sgrp_cost_cd", getSgrpCostCd());
		this.hashColumns.put("coa_cost_src_prt_cd", getCoaCostSrcPrtCd());
		this.hashColumns.put("cost_vol_cd", getCostVolCd());
		this.hashColumns.put("stnd_cost_nm", getStndCostNm());
		this.hashColumns.put("cost_ut_amt_cd", getCostUtAmtCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cost_src_sys_cd", getCostSrcSysCd());
		this.hashColumns.put("cost_src_mon", getCostSrcMon());
		this.hashColumns.put("cost_vol_cd1", getCostVolCd1());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("spcl_cgo_dg_flg", getSpclCgoDgFlg());
		this.hashColumns.put("spcl_cgo_rf_flg", getSpclCgoRfFlg());
		this.hashColumns.put("bkg_rev_mcgo_flg", getBkgRevMcgoFlg());
		this.hashColumns.put("spcl_cgo_bb_flg", getSpclCgoBbFlg());
		this.hashColumns.put("full_mty_cd", getFullMtyCd());
		this.hashColumns.put("sgrp_cost_cd_desc", getSgrpCostCdDesc());
		this.hashColumns.put("stnd_cost_cd", getStndCostCd());
		this.hashColumns.put("inlnd_expn_use_flg", getInlndExpnUseFlg()); 
		this.hashColumns.put("inlnd_tml_expn_calc_flg", getInlndTmlExpnCalcFlg()); 
		this.hashColumns.put("ocn_fdr_expn_use_flg", getOcnFdrExpnUseFlg()); 
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("coa_cost_src_cd_nm", "coaCostSrcCdNm");
		this.hashFields.put("bkg_full_soc_cgo_flg", "bkgFullSocCgoFlg");
		this.hashFields.put("cost_ass_bse_cd", "costAssBseCd");
		this.hashFields.put("spcl_cgo_awk_flg", "spclCgoAwkFlg");
		this.hashFields.put("bkg_mcgo_flg", "bkgMcgoFlg");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("coa_cost_src_cd", "coaCostSrcCd");
		this.hashFields.put("sgrp_cost_cd", "sgrpCostCd");
		this.hashFields.put("coa_cost_src_prt_cd", "coaCostSrcPrtCd");
		this.hashFields.put("cost_vol_cd", "costVolCd");
		this.hashFields.put("stnd_cost_nm", "stndCostNm");
		this.hashFields.put("cost_ut_amt_cd", "costUtAmtCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cost_src_sys_cd", "costSrcSysCd");
		this.hashFields.put("cost_src_mon", "costSrcMon");
		this.hashFields.put("cost_vol_cd1", "costVolCd1");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("spcl_cgo_dg_flg", "spclCgoDgFlg");
		this.hashFields.put("spcl_cgo_rf_flg", "spclCgoRfFlg");
		this.hashFields.put("bkg_rev_mcgo_flg", "bkgRevMcgoFlg");
		this.hashFields.put("spcl_cgo_bb_flg", "spclCgoBbFlg");
		this.hashFields.put("full_mty_cd", "fullMtyCd");
		this.hashFields.put("sgrp_cost_cd_desc", "sgrpCostCdDesc");
		this.hashFields.put("stnd_cost_cd", "stndCostCd");
		this.hashFields.put("inlnd_expn_use_flg", "inlndExpnUseFlg");
		this.hashFields.put("inlnd_tml_expn_calc_flg", "inlndTmlExpnCalcFlg");  
		this.hashFields.put("ocn_fdr_expn_use_flg", "ocnFdrExpnUseFlg");  
		return this.hashFields;
	}	
	
	/*  테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap hashReqeust = null;

    /**
     * hashReqeust
     * @param HashMap hashReqeust
     */
    public void setHashReqeust(HashMap hashReqeust) {
        this.hashReqeust = hashReqeust;
    }
    /**
     * hashReqeust
     * @return HashMap hashReqeust
     */
    public HashMap getHashReqeust() {
        return this.hashReqeust;
    }

    public String[] getHashAttribute(String key){
        return (String[])hashReqeust.get(key);
    }
    
    /*  테이블 컬럼의 다중 값을 저장하는  List */
    private List saveList = null;
    
    /*  테이블 컬럼의 다중 값을 저장하는  List */
    private List saveList2 = null;
    
    public List getMultiSaveList(){
        return saveList;
    }
    public void setMultiSaveList(List list){
        saveList = list;
    }
    
    public List getMultiSaveList2(){
        return saveList2;
    }
    public void setMultiSaveList2(List list){
        saveList2 = list;
    }

    /**
     * 화면에서 넘긴 request 객체의 데이터를 HashMap에 입력하여 HashMap객체를 리턴한다.
     *
     * key   : 화면의 컨트롤객체 이름
     * value : 화면의 컨트롤객체 값
     *
     * @param request
     * @return HashMap
     */
    public void requestToHashMap(HttpServletRequest request){
        // requestToHashMap(HttpServletRequest request)
        HashMap hash = new HashMap();
        hashReqeust = new HashMap();
        Map map = request.getParameterMap();
        Iterator it = map.keySet().iterator();
        Object key = null;
        String[] value = null;
//      StringBuffer sysOut = new StringBuffer();

        while(it.hasNext()){
            key = it.next();
            value = (String[])map.get(key);
            hashReqeust.put(key, value);       
            
//            sysOut.append("\n key[" +Utils.fillSpace((String)key, 15, " ", "right")+ "] : [");
//            for(int i=0; i<value.length; i++){
//                sysOut.append(value[i] );
//                if(i != value.length-1)sysOut.append( " : ");
//            }
//            sysOut.append("]");
        }    
    }
	
	/**
	 * Column Info
	 * @return coaCostSrcCdNm
	 */
	public String getCoaCostSrcCdNm() {
		return this.coaCostSrcCdNm;
	}
	
	/**
	 * Column Info
	 * @return bkgFullSocCgoFlg
	 */
	public String getBkgFullSocCgoFlg() {
		return this.bkgFullSocCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return costAssBseCd
	 */
	public String getCostAssBseCd() {
		return this.costAssBseCd;
	}
	
	/**
	 * Column Info
	 * @return spclCgoAwkFlg
	 */
	public String getSpclCgoAwkFlg() {
		return this.spclCgoAwkFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgMcgoFlg
	 */
	public String getBkgMcgoFlg() {
		return this.bkgMcgoFlg;
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
	 * @return coaCostSrcCd
	 */
	public String getCoaCostSrcCd() {
		return this.coaCostSrcCd;
	}
	
	/**
	 * Column Info
	 * @return sgrpCostCd
	 */
	public String getSgrpCostCd() {
		return this.sgrpCostCd;
	}
	
	/**
	 * Column Info
	 * @return coaCostSrcPrtCd
	 */
	public String getCoaCostSrcPrtCd() {
		return this.coaCostSrcPrtCd;
	}
	
	/**
	 * Column Info
	 * @return costVolCd
	 */
	public String getCostVolCd() {
		return this.costVolCd;
	}
	
	/**
	 * Column Info
	 * @return stndCostNm
	 */
	public String getStndCostNm() {
		return this.stndCostNm;
	}
	
	/**
	 * Column Info
	 * @return costUtAmtCd
	 */
	public String getCostUtAmtCd() {
		return this.costUtAmtCd;
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
	 * @return costSrcSysCd
	 */
	public String getCostSrcSysCd() {
		return this.costSrcSysCd;
	}
	
	/**
	 * Column Info
	 * @return costSrcMon
	 */
	public String getCostSrcMon() {
		return this.costSrcMon;
	}
	
	/**
	 * Column Info
	 * @return costVolCd1
	 */
	public String getCostVolCd1() {
		return this.costVolCd1;
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
	 * @return spclCgoDgFlg
	 */
	public String getSpclCgoDgFlg() {
		return this.spclCgoDgFlg;
	}
	
	/**
	 * Column Info
	 * @return spclCgoRfFlg
	 */
	public String getSpclCgoRfFlg() {
		return this.spclCgoRfFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgRevMcgoFlg
	 */
	public String getBkgRevMcgoFlg() {
		return this.bkgRevMcgoFlg;
	}
	
	/**
	 * Column Info
	 * @return spclCgoBbFlg
	 */
	public String getSpclCgoBbFlg() {
		return this.spclCgoBbFlg;
	}
	
	/**
	 * Column Info
	 * @return fullMtyCd
	 */
	public String getFullMtyCd() {
		return this.fullMtyCd;
	}
	
	/**
	 * Column Info
	 * @return sgrpCostCdDesc
	 */
	public String getSgrpCostCdDesc() {
		return this.sgrpCostCdDesc;
	}
	
	/**
	 * Column Info
	 * @return stndCostCd
	 */
	public String getStndCostCd() {
		return this.stndCostCd;
	}
	
	/**
	 * Column Info
	 * @return inlndExpnUseFlg
	 */
	public String getInlndExpnUseFlg() {
		return this.inlndExpnUseFlg;
	}
	
	/**
	 * Column Info
	 * @return inlndTmlExpnCalcFlg
	 */
	public String getInlndTmlExpnCalcFlg() {
		return this.inlndTmlExpnCalcFlg;
	}
	
	/**
	 * Column Info
	 * @return ocnFdrExpnUseFlg
	 */
	public String getOcnFdrExpnUseFlg() {
		return this.ocnFdrExpnUseFlg;
	}

	/**
	 * Column Info
	 * @param coaCostSrcCdNm
	 */
	public void setCoaCostSrcCdNm(String coaCostSrcCdNm) {
		this.coaCostSrcCdNm = coaCostSrcCdNm;
	}
	
	/**
	 * Column Info
	 * @param bkgFullSocCgoFlg
	 */
	public void setBkgFullSocCgoFlg(String bkgFullSocCgoFlg) {
		this.bkgFullSocCgoFlg = bkgFullSocCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param costAssBseCd
	 */
	public void setCostAssBseCd(String costAssBseCd) {
		this.costAssBseCd = costAssBseCd;
	}
	
	/**
	 * Column Info
	 * @param spclCgoAwkFlg
	 */
	public void setSpclCgoAwkFlg(String spclCgoAwkFlg) {
		this.spclCgoAwkFlg = spclCgoAwkFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgMcgoFlg
	 */
	public void setBkgMcgoFlg(String bkgMcgoFlg) {
		this.bkgMcgoFlg = bkgMcgoFlg;
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
	 * @param coaCostSrcCd
	 */
	public void setCoaCostSrcCd(String coaCostSrcCd) {
		this.coaCostSrcCd = coaCostSrcCd;
	}
	
	/**
	 * Column Info
	 * @param sgrpCostCd
	 */
	public void setSgrpCostCd(String sgrpCostCd) {
		this.sgrpCostCd = sgrpCostCd;
	}
	
	/**
	 * Column Info
	 * @param coaCostSrcPrtCd
	 */
	public void setCoaCostSrcPrtCd(String coaCostSrcPrtCd) {
		this.coaCostSrcPrtCd = coaCostSrcPrtCd;
	}
	
	/**
	 * Column Info
	 * @param costVolCd
	 */
	public void setCostVolCd(String costVolCd) {
		this.costVolCd = costVolCd;
	}
	
	/**
	 * Column Info
	 * @param stndCostNm
	 */
	public void setStndCostNm(String stndCostNm) {
		this.stndCostNm = stndCostNm;
	}
	
	/**
	 * Column Info
	 * @param costUtAmtCd
	 */
	public void setCostUtAmtCd(String costUtAmtCd) {
		this.costUtAmtCd = costUtAmtCd;
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
	 * @param costSrcSysCd
	 */
	public void setCostSrcSysCd(String costSrcSysCd) {
		this.costSrcSysCd = costSrcSysCd;
	}
	
	/**
	 * Column Info
	 * @param costSrcMon
	 */
	public void setCostSrcMon(String costSrcMon) {
		this.costSrcMon = costSrcMon;
	}
	
	/**
	 * Column Info
	 * @param costVolCd1
	 */
	public void setCostVolCd1(String costVolCd1) {
		this.costVolCd1 = costVolCd1;
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
	 * @param spclCgoDgFlg
	 */
	public void setSpclCgoDgFlg(String spclCgoDgFlg) {
		this.spclCgoDgFlg = spclCgoDgFlg;
	}
	
	/**
	 * Column Info
	 * @param spclCgoRfFlg
	 */
	public void setSpclCgoRfFlg(String spclCgoRfFlg) {
		this.spclCgoRfFlg = spclCgoRfFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgRevMcgoFlg
	 */
	public void setBkgRevMcgoFlg(String bkgRevMcgoFlg) {
		this.bkgRevMcgoFlg = bkgRevMcgoFlg;
	}
	
	/**
	 * Column Info
	 * @param spclCgoBbFlg
	 */
	public void setSpclCgoBbFlg(String spclCgoBbFlg) {
		this.spclCgoBbFlg = spclCgoBbFlg;
	}
	
	/**
	 * Column Info
	 * @param fullMtyCd
	 */
	public void setFullMtyCd(String fullMtyCd) {
		this.fullMtyCd = fullMtyCd;
	}
	
	/**
	 * Column Info
	 * @param sgrpCostCdDesc
	 */
	public void setSgrpCostCdDesc(String sgrpCostCdDesc) {
		this.sgrpCostCdDesc = sgrpCostCdDesc;
	}
	
	/**
	 * Column Info
	 * @param stndCostCd
	 */
	public void setStndCostCd(String stndCostCd) {
		this.stndCostCd = stndCostCd;
	}
	
	/**
	 * Column Info
	 * @param inlndExpnUseFlg
	 */
	public void setInlndExpnUseFlg(String inlndExpnUseFlg) {
		this.inlndExpnUseFlg = inlndExpnUseFlg;
	}
	
	/**
	 * Column Info
	 * @param inlndTmlExpnCalcFlg
	 */
	public void setInlndTmlExpnCalcFlg(String inlndTmlExpnCalcFlg) {
		this.inlndTmlExpnCalcFlg = inlndTmlExpnCalcFlg;
	}
	
	/**
	 * Column Info
	 * @param ocnFdrExpnUseFlg
	 */
	public void setOcnFdrExpnUseFlg(String ocnFdrExpnUseFlg) {
		this.ocnFdrExpnUseFlg = ocnFdrExpnUseFlg;
	}
	
	
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCoaCostSrcCdNm(JSPUtil.getParameter(request, "coa_cost_src_cd_nm", ""));
		setBkgFullSocCgoFlg(JSPUtil.getParameter(request, "bkg_full_soc_cgo_flg", ""));
		setCostAssBseCd(JSPUtil.getParameter(request, "cost_ass_bse_cd", ""));
		setSpclCgoAwkFlg(JSPUtil.getParameter(request, "spcl_cgo_awk_flg", ""));
		setBkgMcgoFlg(JSPUtil.getParameter(request, "bkg_mcgo_flg", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setCoaCostSrcCd(JSPUtil.getParameter(request, "coa_cost_src_cd", ""));
		setSgrpCostCd(JSPUtil.getParameter(request, "sgrp_cost_cd", ""));
		setCoaCostSrcPrtCd(JSPUtil.getParameter(request, "coa_cost_src_prt_cd", ""));
		setCostVolCd(JSPUtil.getParameter(request, "cost_vol_cd", ""));
		setStndCostNm(JSPUtil.getParameter(request, "stnd_cost_nm", ""));
		setCostUtAmtCd(JSPUtil.getParameter(request, "cost_ut_amt_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCostSrcSysCd(JSPUtil.getParameter(request, "cost_src_sys_cd", ""));
		setCostSrcMon(JSPUtil.getParameter(request, "cost_src_mon", ""));
		setCostVolCd1(JSPUtil.getParameter(request, "cost_vol_cd1", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSpclCgoDgFlg(JSPUtil.getParameter(request, "spcl_cgo_dg_flg", ""));
		setSpclCgoRfFlg(JSPUtil.getParameter(request, "spcl_cgo_rf_flg", ""));
		setBkgRevMcgoFlg(JSPUtil.getParameter(request, "bkg_rev_mcgo_flg", ""));
		setSpclCgoBbFlg(JSPUtil.getParameter(request, "spcl_cgo_bb_flg", ""));
		setFullMtyCd(JSPUtil.getParameter(request, "full_mty_cd", ""));
		setSgrpCostCdDesc(JSPUtil.getParameter(request, "sgrp_cost_cd_desc", ""));
		setStndCostCd(JSPUtil.getParameter(request, "stnd_cost_cd", ""));
		setInlndExpnUseFlg(JSPUtil.getParameter(request, "inlnd_expn_use_flg", ""));
		setInlndTmlExpnCalcFlg(JSPUtil.getParameter(request, "inlnd_tml_expn_calc_flg", ""));
		setOcnFdrExpnUseFlg(JSPUtil.getParameter(request, "ocn_fdr_expn_use_flg", ""));
		
		 
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSoCodeListVO[]
	 */
	public SearchSoCodeListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSoCodeListVO[]
	 */
	public SearchSoCodeListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSoCodeListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] coaCostSrcCdNm = (JSPUtil.getParameter(request, prefix	+ "coa_cost_src_cd_nm", length));
			String[] bkgFullSocCgoFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_full_soc_cgo_flg", length));
			String[] costAssBseCd = (JSPUtil.getParameter(request, prefix	+ "cost_ass_bse_cd", length));
			String[] spclCgoAwkFlg = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_awk_flg", length));
			String[] bkgMcgoFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_mcgo_flg", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] coaCostSrcCd = (JSPUtil.getParameter(request, prefix	+ "coa_cost_src_cd", length));
			String[] sgrpCostCd = (JSPUtil.getParameter(request, prefix	+ "sgrp_cost_cd", length));
			String[] coaCostSrcPrtCd = (JSPUtil.getParameter(request, prefix	+ "coa_cost_src_prt_cd", length));
			String[] costVolCd = (JSPUtil.getParameter(request, prefix	+ "cost_vol_cd", length));
			String[] stndCostNm = (JSPUtil.getParameter(request, prefix	+ "stnd_cost_nm", length));
			String[] costUtAmtCd = (JSPUtil.getParameter(request, prefix	+ "cost_ut_amt_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] costSrcSysCd = (JSPUtil.getParameter(request, prefix	+ "cost_src_sys_cd", length));
			String[] costSrcMon = (JSPUtil.getParameter(request, prefix	+ "cost_src_mon", length));
			String[] costVolCd1 = (JSPUtil.getParameter(request, prefix	+ "cost_vol_cd1", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] spclCgoDgFlg = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_dg_flg", length));
			String[] spclCgoRfFlg = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_rf_flg", length));
			String[] bkgRevMcgoFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_rev_mcgo_flg", length));
			String[] spclCgoBbFlg = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_bb_flg", length));
			String[] fullMtyCd = (JSPUtil.getParameter(request, prefix	+ "full_mty_cd", length));
			String[] sgrpCostCdDesc = (JSPUtil.getParameter(request, prefix	+ "sgrp_cost_cd_desc", length));
			String[] stndCostCd = (JSPUtil.getParameter(request, prefix	+ "stnd_cost_cd", length));
			String[] inlndExpnUseFlg = (JSPUtil.getParameter(request, prefix	+ "inlnd_expn_use_flg", length));
			String[] inlndTmlExpnCalcFlg = (JSPUtil.getParameter(request, prefix	+ "inlnd_tml_expn_calc_flg", length));
			String[] ocnFdrExpnUseFlg = (JSPUtil.getParameter(request, prefix	+ "ocn_fdr_expn_use_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSoCodeListVO();
				if (coaCostSrcCdNm[i] != null)
					model.setCoaCostSrcCdNm(coaCostSrcCdNm[i]);
				if (bkgFullSocCgoFlg[i] != null)
					model.setBkgFullSocCgoFlg(bkgFullSocCgoFlg[i]);
				if (costAssBseCd[i] != null)
					model.setCostAssBseCd(costAssBseCd[i]);
				if (spclCgoAwkFlg[i] != null)
					model.setSpclCgoAwkFlg(spclCgoAwkFlg[i]);
				if (bkgMcgoFlg[i] != null)
					model.setBkgMcgoFlg(bkgMcgoFlg[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (coaCostSrcCd[i] != null)
					model.setCoaCostSrcCd(coaCostSrcCd[i]);
				if (sgrpCostCd[i] != null)
					model.setSgrpCostCd(sgrpCostCd[i]);
				if (coaCostSrcPrtCd[i] != null)
					model.setCoaCostSrcPrtCd(coaCostSrcPrtCd[i]);
				if (costVolCd[i] != null)
					model.setCostVolCd(costVolCd[i]);
				if (stndCostNm[i] != null)
					model.setStndCostNm(stndCostNm[i]);
				if (costUtAmtCd[i] != null)
					model.setCostUtAmtCd(costUtAmtCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (costSrcSysCd[i] != null)
					model.setCostSrcSysCd(costSrcSysCd[i]);
				if (costSrcMon[i] != null)
					model.setCostSrcMon(costSrcMon[i]);
				if (costVolCd1[i] != null)
					model.setCostVolCd1(costVolCd1[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (spclCgoDgFlg[i] != null)
					model.setSpclCgoDgFlg(spclCgoDgFlg[i]);
				if (spclCgoRfFlg[i] != null)
					model.setSpclCgoRfFlg(spclCgoRfFlg[i]);
				if (bkgRevMcgoFlg[i] != null)
					model.setBkgRevMcgoFlg(bkgRevMcgoFlg[i]);
				if (spclCgoBbFlg[i] != null)
					model.setSpclCgoBbFlg(spclCgoBbFlg[i]);
				if (fullMtyCd[i] != null)
					model.setFullMtyCd(fullMtyCd[i]);
				if (sgrpCostCdDesc[i] != null)
					model.setSgrpCostCdDesc(sgrpCostCdDesc[i]);
				if (stndCostCd[i] != null)
					model.setStndCostCd(stndCostCd[i]);
				if (inlndExpnUseFlg[i] != null)
					model.setInlndExpnUseFlg(inlndExpnUseFlg[i]);
				if (inlndTmlExpnCalcFlg[i] != null)
					model.setInlndTmlExpnCalcFlg(inlndTmlExpnCalcFlg[i]);
				if (ocnFdrExpnUseFlg[i] != null)
					model.setOcnFdrExpnUseFlg(ocnFdrExpnUseFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSoCodeListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSoCodeListVO[]
	 */
	public SearchSoCodeListVO[] getSearchSoCodeListVOs(){
		SearchSoCodeListVO[] vos = (SearchSoCodeListVO[])models.toArray(new SearchSoCodeListVO[models.size()]);
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
		this.coaCostSrcCdNm = this.coaCostSrcCdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgFullSocCgoFlg = this.bkgFullSocCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costAssBseCd = this.costAssBseCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoAwkFlg = this.spclCgoAwkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgMcgoFlg = this.bkgMcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaCostSrcCd = this.coaCostSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sgrpCostCd = this.sgrpCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaCostSrcPrtCd = this.coaCostSrcPrtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costVolCd = this.costVolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndCostNm = this.stndCostNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costUtAmtCd = this.costUtAmtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costSrcSysCd = this.costSrcSysCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costSrcMon = this.costSrcMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costVolCd1 = this.costVolCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoDgFlg = this.spclCgoDgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoRfFlg = this.spclCgoRfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRevMcgoFlg = this.bkgRevMcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoBbFlg = this.spclCgoBbFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullMtyCd = this.fullMtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sgrpCostCdDesc = this.sgrpCostCdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndCostCd = this.stndCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndExpnUseFlg = this.inlndExpnUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndTmlExpnCalcFlg = this.inlndTmlExpnCalcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ocnFdrExpnUseFlg = this.ocnFdrExpnUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchSpaceControlTsVolumnListVO.java
*@FileTitle : SearchSpaceControlTsVolumnListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.30
*@LastModifier : 이상용
*@LastVersion : 1.0
* 2010.06.30 이상용 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo;

import java.lang.reflect.Field;
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
 * @author 이상용
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSpaceControlTsVolumnListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSpaceControlTsVolumnListVO> models = new ArrayList<SearchSpaceControlTsVolumnListVO>();
	
	/* Column Info */
	private String fcastWgt = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String repTrdCd = null;
	/* Column Info */
	private String asgn53 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String dif45 = null;
	/* Column Info */
	private String dif53 = null;
	/* Column Info */
	private String preVvd = null;
	/* Column Info */
	private String slsOfcCd = null;
	/* Column Info */
	private String dis53 = null;
	/* Column Info */
	private String etbDt = null;
	/* Column Info */
	private String asgnRf = null;
	/* Column Info */
	private String bkg20 = null;
	/* Column Info */
	private String slsAqCd = null;
	/* Column Info */
	private String bkgTtl = null;
	/* Column Info */
	private String asgn45 = null;
	/* Column Info */
	private String difRf = null;
	/* Column Info */
	private String disS40 = null;
	/* Column Info */
	private String bkg40 = null;
	/* Column Info */
	private String difWgt = null;
	/* Column Info */
	private String slsRhqCd = null;
	/* Column Info */
	private String bkg45 = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String fcast53 = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String asgnHc = null;
	/* Column Info */
	private String bkgRf20 = null;
	/* Column Info */
	private String dis45 = null;
	/* Column Info */
	private String dis40 = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String preRepSubTrdCd = null;
	/* Column Info */
	private String disRf40 = null;
	/* Column Info */
	private String disHc = null;
	/* Column Info */
	private String disRf20 = null;
	/* Column Info */
	private String disWgt = null;
	/* Column Info */
	private String bkg53 = null;
	/* Column Info */
	private String preRlaneCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fcastHc = null;
	/* Column Info */
	private String fcastTtl = null;
	/* Column Info */
	private String difHc = null;
	/* Column Info */
	private String bkgS20 = null;
	/* Column Info */
	private String bkgS40 = null;
	/* Column Info */
	private String bkgRf40 = null;
	/* Column Info */
	private String asgnTtl = null;
	/* Column Info */
	private String preRepTrdCd = null;
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String bkgHc = null;
	/* Column Info */
	private String disS20 = null;
	/* Column Info */
	private String fcast45 = null;
	/* Column Info */
	private String bkgWgt = null;
	/* Column Info */
	private String dis20 = null;
	/* Column Info */
	private String asgnWgt = null;
	/* Column Info */
	private String preEtbDt = null;
	/* Column Info */
	private String disTtl = null;
	/* Column Info */
	private String slsRgnOfcCd = null;
	/* Column Info */
	private String fcastRf = null;
	/* Column Info */
	private String difTtl = null;
	/* Column Info */
	private String repSubTrdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSpaceControlTsVolumnListVO() {}

	public SearchSpaceControlTsVolumnListVO(String ibflag, String pagerows, String etbDt, String repTrdCd, String repSubTrdCd, String trdCd, String subTrdCd, String rlaneCd, String costWk, String vvd, String iocCd, String slsRhqCd, String slsAqCd, String slsRgnOfcCd, String slsOfcCd, String podCd, String fcastTtl, String fcastHc, String fcast45, String fcast53, String fcastRf, String fcastWgt, String asgnTtl, String asgnHc, String asgn45, String asgn53, String asgnRf, String asgnWgt, String difTtl, String difHc, String dif45, String dif53, String difRf, String difWgt, String bkgTtl, String bkgS20, String bkgS40, String bkg20, String bkg40, String bkgHc, String bkg45, String bkg53, String bkgRf20, String bkgRf40, String bkgWgt, String preRepTrdCd, String preRepSubTrdCd, String preRlaneCd, String preVvd, String preEtbDt, String disTtl, String disS20, String disS40, String dis20, String dis40, String disHc, String dis45, String dis53, String disRf20, String disRf40, String disWgt) {
		this.fcastWgt = fcastWgt;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.repTrdCd = repTrdCd;
		this.asgn53 = asgn53;
		this.pagerows = pagerows;
		this.dif45 = dif45;
		this.dif53 = dif53;
		this.preVvd = preVvd;
		this.slsOfcCd = slsOfcCd;
		this.dis53 = dis53;
		this.etbDt = etbDt;
		this.asgnRf = asgnRf;
		this.bkg20 = bkg20;
		this.slsAqCd = slsAqCd;
		this.bkgTtl = bkgTtl;
		this.asgn45 = asgn45;
		this.difRf = difRf;
		this.disS40 = disS40;
		this.bkg40 = bkg40;
		this.difWgt = difWgt;
		this.slsRhqCd = slsRhqCd;
		this.bkg45 = bkg45;
		this.podCd = podCd;
		this.vvd = vvd;
		this.fcast53 = fcast53;
		this.costWk = costWk;
		this.asgnHc = asgnHc;
		this.bkgRf20 = bkgRf20;
		this.dis45 = dis45;
		this.dis40 = dis40;
		this.subTrdCd = subTrdCd;
		this.preRepSubTrdCd = preRepSubTrdCd;
		this.disRf40 = disRf40;
		this.disHc = disHc;
		this.disRf20 = disRf20;
		this.disWgt = disWgt;
		this.bkg53 = bkg53;
		this.preRlaneCd = preRlaneCd;
		this.ibflag = ibflag;
		this.fcastHc = fcastHc;
		this.fcastTtl = fcastTtl;
		this.difHc = difHc;
		this.bkgS20 = bkgS20;
		this.bkgS40 = bkgS40;
		this.bkgRf40 = bkgRf40;
		this.asgnTtl = asgnTtl;
		this.preRepTrdCd = preRepTrdCd;
		this.iocCd = iocCd;
		this.bkgHc = bkgHc;
		this.disS20 = disS20;
		this.fcast45 = fcast45;
		this.bkgWgt = bkgWgt;
		this.dis20 = dis20;
		this.asgnWgt = asgnWgt;
		this.preEtbDt = preEtbDt;
		this.disTtl = disTtl;
		this.slsRgnOfcCd = slsRgnOfcCd;
		this.fcastRf = fcastRf;
		this.difTtl = difTtl;
		this.repSubTrdCd = repSubTrdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("fcast_wgt", getFcastWgt());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("rep_trd_cd", getRepTrdCd());
		this.hashColumns.put("asgn_53", getAsgn53());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dif_45", getDif45());
		this.hashColumns.put("dif_53", getDif53());
		this.hashColumns.put("pre_vvd", getPreVvd());
		this.hashColumns.put("sls_ofc_cd", getSlsOfcCd());
		this.hashColumns.put("dis_53", getDis53());
		this.hashColumns.put("etb_dt", getEtbDt());
		this.hashColumns.put("asgn_rf", getAsgnRf());
		this.hashColumns.put("bkg_20", getBkg20());
		this.hashColumns.put("sls_aq_cd", getSlsAqCd());
		this.hashColumns.put("bkg_ttl", getBkgTtl());
		this.hashColumns.put("asgn_45", getAsgn45());
		this.hashColumns.put("dif_rf", getDifRf());
		this.hashColumns.put("dis_s40", getDisS40());
		this.hashColumns.put("bkg_40", getBkg40());
		this.hashColumns.put("dif_wgt", getDifWgt());
		this.hashColumns.put("sls_rhq_cd", getSlsRhqCd());
		this.hashColumns.put("bkg_45", getBkg45());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("fcast_53", getFcast53());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("asgn_hc", getAsgnHc());
		this.hashColumns.put("bkg_rf20", getBkgRf20());
		this.hashColumns.put("dis_45", getDis45());
		this.hashColumns.put("dis_40", getDis40());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("pre_rep_sub_trd_cd", getPreRepSubTrdCd());
		this.hashColumns.put("dis_rf40", getDisRf40());
		this.hashColumns.put("dis_hc", getDisHc());
		this.hashColumns.put("dis_rf20", getDisRf20());
		this.hashColumns.put("dis_wgt", getDisWgt());
		this.hashColumns.put("bkg_53", getBkg53());
		this.hashColumns.put("pre_rlane_cd", getPreRlaneCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fcast_hc", getFcastHc());
		this.hashColumns.put("fcast_ttl", getFcastTtl());
		this.hashColumns.put("dif_hc", getDifHc());
		this.hashColumns.put("bkg_s20", getBkgS20());
		this.hashColumns.put("bkg_s40", getBkgS40());
		this.hashColumns.put("bkg_rf40", getBkgRf40());
		this.hashColumns.put("asgn_ttl", getAsgnTtl());
		this.hashColumns.put("pre_rep_trd_cd", getPreRepTrdCd());
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("bkg_hc", getBkgHc());
		this.hashColumns.put("dis_s20", getDisS20());
		this.hashColumns.put("fcast_45", getFcast45());
		this.hashColumns.put("bkg_wgt", getBkgWgt());
		this.hashColumns.put("dis_20", getDis20());
		this.hashColumns.put("asgn_wgt", getAsgnWgt());
		this.hashColumns.put("pre_etb_dt", getPreEtbDt());
		this.hashColumns.put("dis_ttl", getDisTtl());
		this.hashColumns.put("sls_rgn_ofc_cd", getSlsRgnOfcCd());
		this.hashColumns.put("fcast_rf", getFcastRf());
		this.hashColumns.put("dif_ttl", getDifTtl());
		this.hashColumns.put("rep_sub_trd_cd", getRepSubTrdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("fcast_wgt", "fcastWgt");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("rep_trd_cd", "repTrdCd");
		this.hashFields.put("asgn_53", "asgn53");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dif_45", "dif45");
		this.hashFields.put("dif_53", "dif53");
		this.hashFields.put("pre_vvd", "preVvd");
		this.hashFields.put("sls_ofc_cd", "slsOfcCd");
		this.hashFields.put("dis_53", "dis53");
		this.hashFields.put("etb_dt", "etbDt");
		this.hashFields.put("asgn_rf", "asgnRf");
		this.hashFields.put("bkg_20", "bkg20");
		this.hashFields.put("sls_aq_cd", "slsAqCd");
		this.hashFields.put("bkg_ttl", "bkgTtl");
		this.hashFields.put("asgn_45", "asgn45");
		this.hashFields.put("dif_rf", "difRf");
		this.hashFields.put("dis_s40", "disS40");
		this.hashFields.put("bkg_40", "bkg40");
		this.hashFields.put("dif_wgt", "difWgt");
		this.hashFields.put("sls_rhq_cd", "slsRhqCd");
		this.hashFields.put("bkg_45", "bkg45");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("fcast_53", "fcast53");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("asgn_hc", "asgnHc");
		this.hashFields.put("bkg_rf20", "bkgRf20");
		this.hashFields.put("dis_45", "dis45");
		this.hashFields.put("dis_40", "dis40");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("pre_rep_sub_trd_cd", "preRepSubTrdCd");
		this.hashFields.put("dis_rf40", "disRf40");
		this.hashFields.put("dis_hc", "disHc");
		this.hashFields.put("dis_rf20", "disRf20");
		this.hashFields.put("dis_wgt", "disWgt");
		this.hashFields.put("bkg_53", "bkg53");
		this.hashFields.put("pre_rlane_cd", "preRlaneCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fcast_hc", "fcastHc");
		this.hashFields.put("fcast_ttl", "fcastTtl");
		this.hashFields.put("dif_hc", "difHc");
		this.hashFields.put("bkg_s20", "bkgS20");
		this.hashFields.put("bkg_s40", "bkgS40");
		this.hashFields.put("bkg_rf40", "bkgRf40");
		this.hashFields.put("asgn_ttl", "asgnTtl");
		this.hashFields.put("pre_rep_trd_cd", "preRepTrdCd");
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("bkg_hc", "bkgHc");
		this.hashFields.put("dis_s20", "disS20");
		this.hashFields.put("fcast_45", "fcast45");
		this.hashFields.put("bkg_wgt", "bkgWgt");
		this.hashFields.put("dis_20", "dis20");
		this.hashFields.put("asgn_wgt", "asgnWgt");
		this.hashFields.put("pre_etb_dt", "preEtbDt");
		this.hashFields.put("dis_ttl", "disTtl");
		this.hashFields.put("sls_rgn_ofc_cd", "slsRgnOfcCd");
		this.hashFields.put("fcast_rf", "fcastRf");
		this.hashFields.put("dif_ttl", "difTtl");
		this.hashFields.put("rep_sub_trd_cd", "repSubTrdCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fcastWgt
	 */
	public String getFcastWgt() {
		return this.fcastWgt;
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
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return repTrdCd
	 */
	public String getRepTrdCd() {
		return this.repTrdCd;
	}
	
	/**
	 * Column Info
	 * @return asgn53
	 */
	public String getAsgn53() {
		return this.asgn53;
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
	 * @return dif45
	 */
	public String getDif45() {
		return this.dif45;
	}
	
	/**
	 * Column Info
	 * @return dif53
	 */
	public String getDif53() {
		return this.dif53;
	}
	
	/**
	 * Column Info
	 * @return preVvd
	 */
	public String getPreVvd() {
		return this.preVvd;
	}
	
	/**
	 * Column Info
	 * @return slsOfcCd
	 */
	public String getSlsOfcCd() {
		return this.slsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return dis53
	 */
	public String getDis53() {
		return this.dis53;
	}
	
	/**
	 * Column Info
	 * @return etbDt
	 */
	public String getEtbDt() {
		return this.etbDt;
	}
	
	/**
	 * Column Info
	 * @return asgnRf
	 */
	public String getAsgnRf() {
		return this.asgnRf;
	}
	
	/**
	 * Column Info
	 * @return bkg20
	 */
	public String getBkg20() {
		return this.bkg20;
	}
	
	/**
	 * Column Info
	 * @return slsAqCd
	 */
	public String getSlsAqCd() {
		return this.slsAqCd;
	}
	
	/**
	 * Column Info
	 * @return bkgTtl
	 */
	public String getBkgTtl() {
		return this.bkgTtl;
	}
	
	/**
	 * Column Info
	 * @return asgn45
	 */
	public String getAsgn45() {
		return this.asgn45;
	}
	
	/**
	 * Column Info
	 * @return difRf
	 */
	public String getDifRf() {
		return this.difRf;
	}
	
	/**
	 * Column Info
	 * @return disS40
	 */
	public String getDisS40() {
		return this.disS40;
	}
	
	/**
	 * Column Info
	 * @return bkg40
	 */
	public String getBkg40() {
		return this.bkg40;
	}
	
	/**
	 * Column Info
	 * @return difWgt
	 */
	public String getDifWgt() {
		return this.difWgt;
	}
	
	/**
	 * Column Info
	 * @return slsRhqCd
	 */
	public String getSlsRhqCd() {
		return this.slsRhqCd;
	}
	
	/**
	 * Column Info
	 * @return bkg45
	 */
	public String getBkg45() {
		return this.bkg45;
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
	 * @return fcast53
	 */
	public String getFcast53() {
		return this.fcast53;
	}
	
	/**
	 * Column Info
	 * @return costWk
	 */
	public String getCostWk() {
		return this.costWk;
	}
	
	/**
	 * Column Info
	 * @return asgnHc
	 */
	public String getAsgnHc() {
		return this.asgnHc;
	}
	
	/**
	 * Column Info
	 * @return bkgRf20
	 */
	public String getBkgRf20() {
		return this.bkgRf20;
	}
	
	/**
	 * Column Info
	 * @return dis45
	 */
	public String getDis45() {
		return this.dis45;
	}
	
	/**
	 * Column Info
	 * @return dis40
	 */
	public String getDis40() {
		return this.dis40;
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
	 * @return preRepSubTrdCd
	 */
	public String getPreRepSubTrdCd() {
		return this.preRepSubTrdCd;
	}
	
	/**
	 * Column Info
	 * @return disRf40
	 */
	public String getDisRf40() {
		return this.disRf40;
	}
	
	/**
	 * Column Info
	 * @return disHc
	 */
	public String getDisHc() {
		return this.disHc;
	}
	
	/**
	 * Column Info
	 * @return disRf20
	 */
	public String getDisRf20() {
		return this.disRf20;
	}
	
	/**
	 * Column Info
	 * @return disWgt
	 */
	public String getDisWgt() {
		return this.disWgt;
	}
	
	/**
	 * Column Info
	 * @return bkg53
	 */
	public String getBkg53() {
		return this.bkg53;
	}
	
	/**
	 * Column Info
	 * @return preRlaneCd
	 */
	public String getPreRlaneCd() {
		return this.preRlaneCd;
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
	 * @return fcastHc
	 */
	public String getFcastHc() {
		return this.fcastHc;
	}
	
	/**
	 * Column Info
	 * @return fcastTtl
	 */
	public String getFcastTtl() {
		return this.fcastTtl;
	}
	
	/**
	 * Column Info
	 * @return difHc
	 */
	public String getDifHc() {
		return this.difHc;
	}
	
	/**
	 * Column Info
	 * @return bkgS20
	 */
	public String getBkgS20() {
		return this.bkgS20;
	}
	
	/**
	 * Column Info
	 * @return bkgS40
	 */
	public String getBkgS40() {
		return this.bkgS40;
	}
	
	/**
	 * Column Info
	 * @return bkgRf40
	 */
	public String getBkgRf40() {
		return this.bkgRf40;
	}
	
	/**
	 * Column Info
	 * @return asgnTtl
	 */
	public String getAsgnTtl() {
		return this.asgnTtl;
	}
	
	/**
	 * Column Info
	 * @return preRepTrdCd
	 */
	public String getPreRepTrdCd() {
		return this.preRepTrdCd;
	}
	
	/**
	 * Column Info
	 * @return iocCd
	 */
	public String getIocCd() {
		return this.iocCd;
	}
	
	/**
	 * Column Info
	 * @return bkgHc
	 */
	public String getBkgHc() {
		return this.bkgHc;
	}
	
	/**
	 * Column Info
	 * @return disS20
	 */
	public String getDisS20() {
		return this.disS20;
	}
	
	/**
	 * Column Info
	 * @return fcast45
	 */
	public String getFcast45() {
		return this.fcast45;
	}
	
	/**
	 * Column Info
	 * @return bkgWgt
	 */
	public String getBkgWgt() {
		return this.bkgWgt;
	}
	
	/**
	 * Column Info
	 * @return dis20
	 */
	public String getDis20() {
		return this.dis20;
	}
	
	/**
	 * Column Info
	 * @return asgnWgt
	 */
	public String getAsgnWgt() {
		return this.asgnWgt;
	}
	
	/**
	 * Column Info
	 * @return preEtbDt
	 */
	public String getPreEtbDt() {
		return this.preEtbDt;
	}
	
	/**
	 * Column Info
	 * @return disTtl
	 */
	public String getDisTtl() {
		return this.disTtl;
	}
	
	/**
	 * Column Info
	 * @return slsRgnOfcCd
	 */
	public String getSlsRgnOfcCd() {
		return this.slsRgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @return fcastRf
	 */
	public String getFcastRf() {
		return this.fcastRf;
	}
	
	/**
	 * Column Info
	 * @return difTtl
	 */
	public String getDifTtl() {
		return this.difTtl;
	}
	
	/**
	 * Column Info
	 * @return repSubTrdCd
	 */
	public String getRepSubTrdCd() {
		return this.repSubTrdCd;
	}
	

	/**
	 * Column Info
	 * @param fcastWgt
	 */
	public void setFcastWgt(String fcastWgt) {
		this.fcastWgt = fcastWgt;
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
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param repTrdCd
	 */
	public void setRepTrdCd(String repTrdCd) {
		this.repTrdCd = repTrdCd;
	}
	
	/**
	 * Column Info
	 * @param asgn53
	 */
	public void setAsgn53(String asgn53) {
		this.asgn53 = asgn53;
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
	 * @param dif45
	 */
	public void setDif45(String dif45) {
		this.dif45 = dif45;
	}
	
	/**
	 * Column Info
	 * @param dif53
	 */
	public void setDif53(String dif53) {
		this.dif53 = dif53;
	}
	
	/**
	 * Column Info
	 * @param preVvd
	 */
	public void setPreVvd(String preVvd) {
		this.preVvd = preVvd;
	}
	
	/**
	 * Column Info
	 * @param slsOfcCd
	 */
	public void setSlsOfcCd(String slsOfcCd) {
		this.slsOfcCd = slsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param dis53
	 */
	public void setDis53(String dis53) {
		this.dis53 = dis53;
	}
	
	/**
	 * Column Info
	 * @param etbDt
	 */
	public void setEtbDt(String etbDt) {
		this.etbDt = etbDt;
	}
	
	/**
	 * Column Info
	 * @param asgnRf
	 */
	public void setAsgnRf(String asgnRf) {
		this.asgnRf = asgnRf;
	}
	
	/**
	 * Column Info
	 * @param bkg20
	 */
	public void setBkg20(String bkg20) {
		this.bkg20 = bkg20;
	}
	
	/**
	 * Column Info
	 * @param slsAqCd
	 */
	public void setSlsAqCd(String slsAqCd) {
		this.slsAqCd = slsAqCd;
	}
	
	/**
	 * Column Info
	 * @param bkgTtl
	 */
	public void setBkgTtl(String bkgTtl) {
		this.bkgTtl = bkgTtl;
	}
	
	/**
	 * Column Info
	 * @param asgn45
	 */
	public void setAsgn45(String asgn45) {
		this.asgn45 = asgn45;
	}
	
	/**
	 * Column Info
	 * @param difRf
	 */
	public void setDifRf(String difRf) {
		this.difRf = difRf;
	}
	
	/**
	 * Column Info
	 * @param disS40
	 */
	public void setDisS40(String disS40) {
		this.disS40 = disS40;
	}
	
	/**
	 * Column Info
	 * @param bkg40
	 */
	public void setBkg40(String bkg40) {
		this.bkg40 = bkg40;
	}
	
	/**
	 * Column Info
	 * @param difWgt
	 */
	public void setDifWgt(String difWgt) {
		this.difWgt = difWgt;
	}
	
	/**
	 * Column Info
	 * @param slsRhqCd
	 */
	public void setSlsRhqCd(String slsRhqCd) {
		this.slsRhqCd = slsRhqCd;
	}
	
	/**
	 * Column Info
	 * @param bkg45
	 */
	public void setBkg45(String bkg45) {
		this.bkg45 = bkg45;
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
	 * @param fcast53
	 */
	public void setFcast53(String fcast53) {
		this.fcast53 = fcast53;
	}
	
	/**
	 * Column Info
	 * @param costWk
	 */
	public void setCostWk(String costWk) {
		this.costWk = costWk;
	}
	
	/**
	 * Column Info
	 * @param asgnHc
	 */
	public void setAsgnHc(String asgnHc) {
		this.asgnHc = asgnHc;
	}
	
	/**
	 * Column Info
	 * @param bkgRf20
	 */
	public void setBkgRf20(String bkgRf20) {
		this.bkgRf20 = bkgRf20;
	}
	
	/**
	 * Column Info
	 * @param dis45
	 */
	public void setDis45(String dis45) {
		this.dis45 = dis45;
	}
	
	/**
	 * Column Info
	 * @param dis40
	 */
	public void setDis40(String dis40) {
		this.dis40 = dis40;
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
	 * @param preRepSubTrdCd
	 */
	public void setPreRepSubTrdCd(String preRepSubTrdCd) {
		this.preRepSubTrdCd = preRepSubTrdCd;
	}
	
	/**
	 * Column Info
	 * @param disRf40
	 */
	public void setDisRf40(String disRf40) {
		this.disRf40 = disRf40;
	}
	
	/**
	 * Column Info
	 * @param disHc
	 */
	public void setDisHc(String disHc) {
		this.disHc = disHc;
	}
	
	/**
	 * Column Info
	 * @param disRf20
	 */
	public void setDisRf20(String disRf20) {
		this.disRf20 = disRf20;
	}
	
	/**
	 * Column Info
	 * @param disWgt
	 */
	public void setDisWgt(String disWgt) {
		this.disWgt = disWgt;
	}
	
	/**
	 * Column Info
	 * @param bkg53
	 */
	public void setBkg53(String bkg53) {
		this.bkg53 = bkg53;
	}
	
	/**
	 * Column Info
	 * @param preRlaneCd
	 */
	public void setPreRlaneCd(String preRlaneCd) {
		this.preRlaneCd = preRlaneCd;
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
	 * @param fcastHc
	 */
	public void setFcastHc(String fcastHc) {
		this.fcastHc = fcastHc;
	}
	
	/**
	 * Column Info
	 * @param fcastTtl
	 */
	public void setFcastTtl(String fcastTtl) {
		this.fcastTtl = fcastTtl;
	}
	
	/**
	 * Column Info
	 * @param difHc
	 */
	public void setDifHc(String difHc) {
		this.difHc = difHc;
	}
	
	/**
	 * Column Info
	 * @param bkgS20
	 */
	public void setBkgS20(String bkgS20) {
		this.bkgS20 = bkgS20;
	}
	
	/**
	 * Column Info
	 * @param bkgS40
	 */
	public void setBkgS40(String bkgS40) {
		this.bkgS40 = bkgS40;
	}
	
	/**
	 * Column Info
	 * @param bkgRf40
	 */
	public void setBkgRf40(String bkgRf40) {
		this.bkgRf40 = bkgRf40;
	}
	
	/**
	 * Column Info
	 * @param asgnTtl
	 */
	public void setAsgnTtl(String asgnTtl) {
		this.asgnTtl = asgnTtl;
	}
	
	/**
	 * Column Info
	 * @param preRepTrdCd
	 */
	public void setPreRepTrdCd(String preRepTrdCd) {
		this.preRepTrdCd = preRepTrdCd;
	}
	
	/**
	 * Column Info
	 * @param iocCd
	 */
	public void setIocCd(String iocCd) {
		this.iocCd = iocCd;
	}
	
	/**
	 * Column Info
	 * @param bkgHc
	 */
	public void setBkgHc(String bkgHc) {
		this.bkgHc = bkgHc;
	}
	
	/**
	 * Column Info
	 * @param disS20
	 */
	public void setDisS20(String disS20) {
		this.disS20 = disS20;
	}
	
	/**
	 * Column Info
	 * @param fcast45
	 */
	public void setFcast45(String fcast45) {
		this.fcast45 = fcast45;
	}
	
	/**
	 * Column Info
	 * @param bkgWgt
	 */
	public void setBkgWgt(String bkgWgt) {
		this.bkgWgt = bkgWgt;
	}
	
	/**
	 * Column Info
	 * @param dis20
	 */
	public void setDis20(String dis20) {
		this.dis20 = dis20;
	}
	
	/**
	 * Column Info
	 * @param asgnWgt
	 */
	public void setAsgnWgt(String asgnWgt) {
		this.asgnWgt = asgnWgt;
	}
	
	/**
	 * Column Info
	 * @param preEtbDt
	 */
	public void setPreEtbDt(String preEtbDt) {
		this.preEtbDt = preEtbDt;
	}
	
	/**
	 * Column Info
	 * @param disTtl
	 */
	public void setDisTtl(String disTtl) {
		this.disTtl = disTtl;
	}
	
	/**
	 * Column Info
	 * @param slsRgnOfcCd
	 */
	public void setSlsRgnOfcCd(String slsRgnOfcCd) {
		this.slsRgnOfcCd = slsRgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @param fcastRf
	 */
	public void setFcastRf(String fcastRf) {
		this.fcastRf = fcastRf;
	}
	
	/**
	 * Column Info
	 * @param difTtl
	 */
	public void setDifTtl(String difTtl) {
		this.difTtl = difTtl;
	}
	
	/**
	 * Column Info
	 * @param repSubTrdCd
	 */
	public void setRepSubTrdCd(String repSubTrdCd) {
		this.repSubTrdCd = repSubTrdCd;
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
		setFcastWgt(JSPUtil.getParameter(request, prefix + "fcast_wgt", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setRepTrdCd(JSPUtil.getParameter(request, prefix + "rep_trd_cd", ""));
		setAsgn53(JSPUtil.getParameter(request, prefix + "asgn_53", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDif45(JSPUtil.getParameter(request, prefix + "dif_45", ""));
		setDif53(JSPUtil.getParameter(request, prefix + "dif_53", ""));
		setPreVvd(JSPUtil.getParameter(request, prefix + "pre_vvd", ""));
		setSlsOfcCd(JSPUtil.getParameter(request, prefix + "sls_ofc_cd", ""));
		setDis53(JSPUtil.getParameter(request, prefix + "dis_53", ""));
		setEtbDt(JSPUtil.getParameter(request, prefix + "etb_dt", ""));
		setAsgnRf(JSPUtil.getParameter(request, prefix + "asgn_rf", ""));
		setBkg20(JSPUtil.getParameter(request, prefix + "bkg_20", ""));
		setSlsAqCd(JSPUtil.getParameter(request, prefix + "sls_aq_cd", ""));
		setBkgTtl(JSPUtil.getParameter(request, prefix + "bkg_ttl", ""));
		setAsgn45(JSPUtil.getParameter(request, prefix + "asgn_45", ""));
		setDifRf(JSPUtil.getParameter(request, prefix + "dif_rf", ""));
		setDisS40(JSPUtil.getParameter(request, prefix + "dis_s40", ""));
		setBkg40(JSPUtil.getParameter(request, prefix + "bkg_40", ""));
		setDifWgt(JSPUtil.getParameter(request, prefix + "dif_wgt", ""));
		setSlsRhqCd(JSPUtil.getParameter(request, prefix + "sls_rhq_cd", ""));
		setBkg45(JSPUtil.getParameter(request, prefix + "bkg_45", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setFcast53(JSPUtil.getParameter(request, prefix + "fcast_53", ""));
		setCostWk(JSPUtil.getParameter(request, prefix + "cost_wk", ""));
		setAsgnHc(JSPUtil.getParameter(request, prefix + "asgn_hc", ""));
		setBkgRf20(JSPUtil.getParameter(request, prefix + "bkg_rf20", ""));
		setDis45(JSPUtil.getParameter(request, prefix + "dis_45", ""));
		setDis40(JSPUtil.getParameter(request, prefix + "dis_40", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setPreRepSubTrdCd(JSPUtil.getParameter(request, prefix + "pre_rep_sub_trd_cd", ""));
		setDisRf40(JSPUtil.getParameter(request, prefix + "dis_rf40", ""));
		setDisHc(JSPUtil.getParameter(request, prefix + "dis_hc", ""));
		setDisRf20(JSPUtil.getParameter(request, prefix + "dis_rf20", ""));
		setDisWgt(JSPUtil.getParameter(request, prefix + "dis_wgt", ""));
		setBkg53(JSPUtil.getParameter(request, prefix + "bkg_53", ""));
		setPreRlaneCd(JSPUtil.getParameter(request, prefix + "pre_rlane_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFcastHc(JSPUtil.getParameter(request, prefix + "fcast_hc", ""));
		setFcastTtl(JSPUtil.getParameter(request, prefix + "fcast_ttl", ""));
		setDifHc(JSPUtil.getParameter(request, prefix + "dif_hc", ""));
		setBkgS20(JSPUtil.getParameter(request, prefix + "bkg_s20", ""));
		setBkgS40(JSPUtil.getParameter(request, prefix + "bkg_s40", ""));
		setBkgRf40(JSPUtil.getParameter(request, prefix + "bkg_rf40", ""));
		setAsgnTtl(JSPUtil.getParameter(request, prefix + "asgn_ttl", ""));
		setPreRepTrdCd(JSPUtil.getParameter(request, prefix + "pre_rep_trd_cd", ""));
		setIocCd(JSPUtil.getParameter(request, prefix + "ioc_cd", ""));
		setBkgHc(JSPUtil.getParameter(request, prefix + "bkg_hc", ""));
		setDisS20(JSPUtil.getParameter(request, prefix + "dis_s20", ""));
		setFcast45(JSPUtil.getParameter(request, prefix + "fcast_45", ""));
		setBkgWgt(JSPUtil.getParameter(request, prefix + "bkg_wgt", ""));
		setDis20(JSPUtil.getParameter(request, prefix + "dis_20", ""));
		setAsgnWgt(JSPUtil.getParameter(request, prefix + "asgn_wgt", ""));
		setPreEtbDt(JSPUtil.getParameter(request, prefix + "pre_etb_dt", ""));
		setDisTtl(JSPUtil.getParameter(request, prefix + "dis_ttl", ""));
		setSlsRgnOfcCd(JSPUtil.getParameter(request, prefix + "sls_rgn_ofc_cd", ""));
		setFcastRf(JSPUtil.getParameter(request, prefix + "fcast_rf", ""));
		setDifTtl(JSPUtil.getParameter(request, prefix + "dif_ttl", ""));
		setRepSubTrdCd(JSPUtil.getParameter(request, prefix + "rep_sub_trd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSpaceControlTsVolumnListVO[]
	 */
	public SearchSpaceControlTsVolumnListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSpaceControlTsVolumnListVO[]
	 */
	public SearchSpaceControlTsVolumnListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSpaceControlTsVolumnListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fcastWgt = (JSPUtil.getParameter(request, prefix	+ "fcast_wgt", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] repTrdCd = (JSPUtil.getParameter(request, prefix	+ "rep_trd_cd", length));
			String[] asgn53 = (JSPUtil.getParameter(request, prefix	+ "asgn_53", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] dif45 = (JSPUtil.getParameter(request, prefix	+ "dif_45", length));
			String[] dif53 = (JSPUtil.getParameter(request, prefix	+ "dif_53", length));
			String[] preVvd = (JSPUtil.getParameter(request, prefix	+ "pre_vvd", length));
			String[] slsOfcCd = (JSPUtil.getParameter(request, prefix	+ "sls_ofc_cd", length));
			String[] dis53 = (JSPUtil.getParameter(request, prefix	+ "dis_53", length));
			String[] etbDt = (JSPUtil.getParameter(request, prefix	+ "etb_dt", length));
			String[] asgnRf = (JSPUtil.getParameter(request, prefix	+ "asgn_rf", length));
			String[] bkg20 = (JSPUtil.getParameter(request, prefix	+ "bkg_20", length));
			String[] slsAqCd = (JSPUtil.getParameter(request, prefix	+ "sls_aq_cd", length));
			String[] bkgTtl = (JSPUtil.getParameter(request, prefix	+ "bkg_ttl", length));
			String[] asgn45 = (JSPUtil.getParameter(request, prefix	+ "asgn_45", length));
			String[] difRf = (JSPUtil.getParameter(request, prefix	+ "dif_rf", length));
			String[] disS40 = (JSPUtil.getParameter(request, prefix	+ "dis_s40", length));
			String[] bkg40 = (JSPUtil.getParameter(request, prefix	+ "bkg_40", length));
			String[] difWgt = (JSPUtil.getParameter(request, prefix	+ "dif_wgt", length));
			String[] slsRhqCd = (JSPUtil.getParameter(request, prefix	+ "sls_rhq_cd", length));
			String[] bkg45 = (JSPUtil.getParameter(request, prefix	+ "bkg_45", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] fcast53 = (JSPUtil.getParameter(request, prefix	+ "fcast_53", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] asgnHc = (JSPUtil.getParameter(request, prefix	+ "asgn_hc", length));
			String[] bkgRf20 = (JSPUtil.getParameter(request, prefix	+ "bkg_rf20", length));
			String[] dis45 = (JSPUtil.getParameter(request, prefix	+ "dis_45", length));
			String[] dis40 = (JSPUtil.getParameter(request, prefix	+ "dis_40", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] preRepSubTrdCd = (JSPUtil.getParameter(request, prefix	+ "pre_rep_sub_trd_cd", length));
			String[] disRf40 = (JSPUtil.getParameter(request, prefix	+ "dis_rf40", length));
			String[] disHc = (JSPUtil.getParameter(request, prefix	+ "dis_hc", length));
			String[] disRf20 = (JSPUtil.getParameter(request, prefix	+ "dis_rf20", length));
			String[] disWgt = (JSPUtil.getParameter(request, prefix	+ "dis_wgt", length));
			String[] bkg53 = (JSPUtil.getParameter(request, prefix	+ "bkg_53", length));
			String[] preRlaneCd = (JSPUtil.getParameter(request, prefix	+ "pre_rlane_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fcastHc = (JSPUtil.getParameter(request, prefix	+ "fcast_hc", length));
			String[] fcastTtl = (JSPUtil.getParameter(request, prefix	+ "fcast_ttl", length));
			String[] difHc = (JSPUtil.getParameter(request, prefix	+ "dif_hc", length));
			String[] bkgS20 = (JSPUtil.getParameter(request, prefix	+ "bkg_s20", length));
			String[] bkgS40 = (JSPUtil.getParameter(request, prefix	+ "bkg_s40", length));
			String[] bkgRf40 = (JSPUtil.getParameter(request, prefix	+ "bkg_rf40", length));
			String[] asgnTtl = (JSPUtil.getParameter(request, prefix	+ "asgn_ttl", length));
			String[] preRepTrdCd = (JSPUtil.getParameter(request, prefix	+ "pre_rep_trd_cd", length));
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] bkgHc = (JSPUtil.getParameter(request, prefix	+ "bkg_hc", length));
			String[] disS20 = (JSPUtil.getParameter(request, prefix	+ "dis_s20", length));
			String[] fcast45 = (JSPUtil.getParameter(request, prefix	+ "fcast_45", length));
			String[] bkgWgt = (JSPUtil.getParameter(request, prefix	+ "bkg_wgt", length));
			String[] dis20 = (JSPUtil.getParameter(request, prefix	+ "dis_20", length));
			String[] asgnWgt = (JSPUtil.getParameter(request, prefix	+ "asgn_wgt", length));
			String[] preEtbDt = (JSPUtil.getParameter(request, prefix	+ "pre_etb_dt", length));
			String[] disTtl = (JSPUtil.getParameter(request, prefix	+ "dis_ttl", length));
			String[] slsRgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "sls_rgn_ofc_cd", length));
			String[] fcastRf = (JSPUtil.getParameter(request, prefix	+ "fcast_rf", length));
			String[] difTtl = (JSPUtil.getParameter(request, prefix	+ "dif_ttl", length));
			String[] repSubTrdCd = (JSPUtil.getParameter(request, prefix	+ "rep_sub_trd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSpaceControlTsVolumnListVO();
				if (fcastWgt[i] != null)
					model.setFcastWgt(fcastWgt[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (repTrdCd[i] != null)
					model.setRepTrdCd(repTrdCd[i]);
				if (asgn53[i] != null)
					model.setAsgn53(asgn53[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (dif45[i] != null)
					model.setDif45(dif45[i]);
				if (dif53[i] != null)
					model.setDif53(dif53[i]);
				if (preVvd[i] != null)
					model.setPreVvd(preVvd[i]);
				if (slsOfcCd[i] != null)
					model.setSlsOfcCd(slsOfcCd[i]);
				if (dis53[i] != null)
					model.setDis53(dis53[i]);
				if (etbDt[i] != null)
					model.setEtbDt(etbDt[i]);
				if (asgnRf[i] != null)
					model.setAsgnRf(asgnRf[i]);
				if (bkg20[i] != null)
					model.setBkg20(bkg20[i]);
				if (slsAqCd[i] != null)
					model.setSlsAqCd(slsAqCd[i]);
				if (bkgTtl[i] != null)
					model.setBkgTtl(bkgTtl[i]);
				if (asgn45[i] != null)
					model.setAsgn45(asgn45[i]);
				if (difRf[i] != null)
					model.setDifRf(difRf[i]);
				if (disS40[i] != null)
					model.setDisS40(disS40[i]);
				if (bkg40[i] != null)
					model.setBkg40(bkg40[i]);
				if (difWgt[i] != null)
					model.setDifWgt(difWgt[i]);
				if (slsRhqCd[i] != null)
					model.setSlsRhqCd(slsRhqCd[i]);
				if (bkg45[i] != null)
					model.setBkg45(bkg45[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (fcast53[i] != null)
					model.setFcast53(fcast53[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (asgnHc[i] != null)
					model.setAsgnHc(asgnHc[i]);
				if (bkgRf20[i] != null)
					model.setBkgRf20(bkgRf20[i]);
				if (dis45[i] != null)
					model.setDis45(dis45[i]);
				if (dis40[i] != null)
					model.setDis40(dis40[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (preRepSubTrdCd[i] != null)
					model.setPreRepSubTrdCd(preRepSubTrdCd[i]);
				if (disRf40[i] != null)
					model.setDisRf40(disRf40[i]);
				if (disHc[i] != null)
					model.setDisHc(disHc[i]);
				if (disRf20[i] != null)
					model.setDisRf20(disRf20[i]);
				if (disWgt[i] != null)
					model.setDisWgt(disWgt[i]);
				if (bkg53[i] != null)
					model.setBkg53(bkg53[i]);
				if (preRlaneCd[i] != null)
					model.setPreRlaneCd(preRlaneCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fcastHc[i] != null)
					model.setFcastHc(fcastHc[i]);
				if (fcastTtl[i] != null)
					model.setFcastTtl(fcastTtl[i]);
				if (difHc[i] != null)
					model.setDifHc(difHc[i]);
				if (bkgS20[i] != null)
					model.setBkgS20(bkgS20[i]);
				if (bkgS40[i] != null)
					model.setBkgS40(bkgS40[i]);
				if (bkgRf40[i] != null)
					model.setBkgRf40(bkgRf40[i]);
				if (asgnTtl[i] != null)
					model.setAsgnTtl(asgnTtl[i]);
				if (preRepTrdCd[i] != null)
					model.setPreRepTrdCd(preRepTrdCd[i]);
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (bkgHc[i] != null)
					model.setBkgHc(bkgHc[i]);
				if (disS20[i] != null)
					model.setDisS20(disS20[i]);
				if (fcast45[i] != null)
					model.setFcast45(fcast45[i]);
				if (bkgWgt[i] != null)
					model.setBkgWgt(bkgWgt[i]);
				if (dis20[i] != null)
					model.setDis20(dis20[i]);
				if (asgnWgt[i] != null)
					model.setAsgnWgt(asgnWgt[i]);
				if (preEtbDt[i] != null)
					model.setPreEtbDt(preEtbDt[i]);
				if (disTtl[i] != null)
					model.setDisTtl(disTtl[i]);
				if (slsRgnOfcCd[i] != null)
					model.setSlsRgnOfcCd(slsRgnOfcCd[i]);
				if (fcastRf[i] != null)
					model.setFcastRf(fcastRf[i]);
				if (difTtl[i] != null)
					model.setDifTtl(difTtl[i]);
				if (repSubTrdCd[i] != null)
					model.setRepSubTrdCd(repSubTrdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSpaceControlTsVolumnListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSpaceControlTsVolumnListVO[]
	 */
	public SearchSpaceControlTsVolumnListVO[] getSearchSpaceControlTsVolumnListVOs(){
		SearchSpaceControlTsVolumnListVO[] vos = (SearchSpaceControlTsVolumnListVO[])models.toArray(new SearchSpaceControlTsVolumnListVO[models.size()]);
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
		this.fcastWgt = this.fcastWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repTrdCd = this.repTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asgn53 = this.asgn53 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dif45 = this.dif45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dif53 = this.dif53 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preVvd = this.preVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsOfcCd = this.slsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dis53 = this.dis53 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etbDt = this.etbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asgnRf = this.asgnRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg20 = this.bkg20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsAqCd = this.slsAqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTtl = this.bkgTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asgn45 = this.asgn45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.difRf = this.difRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.disS40 = this.disS40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg40 = this.bkg40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.difWgt = this.difWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsRhqCd = this.slsRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg45 = this.bkg45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast53 = this.fcast53 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asgnHc = this.asgnHc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRf20 = this.bkgRf20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dis45 = this.dis45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dis40 = this.dis40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preRepSubTrdCd = this.preRepSubTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.disRf40 = this.disRf40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.disHc = this.disHc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.disRf20 = this.disRf20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.disWgt = this.disWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg53 = this.bkg53 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preRlaneCd = this.preRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastHc = this.fcastHc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastTtl = this.fcastTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.difHc = this.difHc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgS20 = this.bkgS20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgS40 = this.bkgS40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRf40 = this.bkgRf40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asgnTtl = this.asgnTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preRepTrdCd = this.preRepTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgHc = this.bkgHc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.disS20 = this.disS20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast45 = this.fcast45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgWgt = this.bkgWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dis20 = this.dis20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asgnWgt = this.asgnWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preEtbDt = this.preEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.disTtl = this.disTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsRgnOfcCd = this.slsRgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastRf = this.fcastRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.difTtl = this.difTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repSubTrdCd = this.repSubTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

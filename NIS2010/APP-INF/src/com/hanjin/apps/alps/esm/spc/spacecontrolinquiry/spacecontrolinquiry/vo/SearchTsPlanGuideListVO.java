/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SearchTsPlanGuideListVO.java
*@FileTitle : SearchTsPlanGuideListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.20  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo;

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

public class SearchTsPlanGuideListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchTsPlanGuideListVO> models = new ArrayList<SearchTsPlanGuideListVO>();
	
	/* Column Info */
	private String n4thSkdVoyNo = null;
	/* Column Info */
	private String n3rdRlaneCd = null;
	/* Column Info */
	private String n5thPortEtdDt = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String repTrdCd = null;
	/* Column Info */
	private String mnCreUsrId = null;
	/* Column Info */
	private String repSubTrdCd = null;
	/* Column Info */
	private String tsRmk = null;
	/* Column Info */
	private String crrCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String n2ndVslCd = null;
	/* Column Info */
	private String n4thSkdDirCd = null;
	/* Column Info */
	private String n2ndPodYdCd = null;
	/* Column Info */
	private String n2ndPortEtbDt = null;
	/* Column Info */
	private String n4thVvdCd = null;
	/* Column Info */
	private String n5thRlaneCd = null;
	/* Column Info */
	private String n1stRlaneCd = null;
	/* Column Info */
	private String irrPortCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String skdCngRsnCd = null;
	/* Column Info */
	private String mnCreDt = null;
	/* Column Info */
	private String n3rdPodCd = null;
	/* Column Info */
	private String mltPolListCtnt = null;
	/* Column Info */
	private String fileSeq = null;
	/* Column Info */
	private String n2ndRlaneCd = null;
	/* Column Info */
	private String plnSeq = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String fileNm = null;
	/* Column Info */
	private String mnUpdUsrId = null;
	/* Column Info */
	private String n4thVslCd = null;
	/* Column Info */
	private String n5thVslCd = null;
	/* Column Info */
	private String portSkpRsnCd = null;
	/* Column Info */
	private String n3rdPolCd = null;
	/* Column Info */
	private String mltPodListCtnt = null;
	/* Column Info */
	private String n4thPodYdCd = null;
	/* Column Info */
	private String n2ndSkdDirCd = null;
	/* Column Info */
	private String n3rdPodYdCd = null;
	/* Column Info */
	private String n5thVvdCd = null;
	/* Column Info */
	private String usrRmk = null;
	/* Column Info */
	private String n2ndPolYdCd = null;
	/* Column Info */
	private String n1stPortEtbDt = null;
	/* Column Info */
	private String n4thPortEtbDt = null;
	/* Column Info */
	private String n3rdPortEtbDt = null;
	/* Column Info */
	private String n2ndSkdVoyNo = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String n5thPolCd = null;
	/* Column Info */
	private String portSkpTpCd = null;
	/* Column Info */
	private String tsPlnGidDtl = null;
	/* Column Info */
	private String cntrMtyFlg = null;
	/* Column Info */
	private String tsPlnCfmStsCd = null;
	/* Column Info */
	private String mltCrrListCtnt = null;
	/* Column Info */
	private String n3rdSkdVoyNo = null;
	/* Column Info */
	private String n5thPortEtbDt = null;
	/* Column Info */
	private String n1stSkdDirCd = null;
	/* Column Info */
	private String n3rdPolYdCd = null;
	/* Column Info */
	private String n3rdVvdCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String n5thPolYdCd = null;
	/* Column Info */
	private String n1stPortEtdDt = null;
	/* Column Info */
	private String existFlg = null;
	/* Column Info */
	private String n3rdSkdDirCd = null;
	/* Column Info */
	private String n1stVslCd = null;
	/* Column Info */
	private String n2ndPortEtdDt = null;
	/* Column Info */
	private String skdCngRsnNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String n4thPodCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String irrYdCd = null;
	/* Column Info */
	private String n1stVvdCd = null;
	/* Column Info */
	private String searchTp = null;
	/* Column Info */
	private String n1stSkdVoyNo = null;
	/* Column Info */
	private String fileSize = null;
	/* Column Info */
	private String n1stPodCd = null;
	/* Column Info */
	private String n3rdVslCd = null;
	/* Column Info */
	private String n4thPolCd = null;
	/* Column Info */
	private String costWk = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String n4thRlaneCd = null;
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String keys = null;
	/* Column Info */
	private String n1stPodYdCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String plnAtch = null;
	/* Column Info */
	private String fileSavId = null;
	/* Column Info */
	private String mnTsRmk = null;
	/* Column Info */
	private String n2ndPodCd = null;
	/* Column Info */
	private String n5thSkdVoyNo = null;
	/* Column Info */
	private String mnUpdDt = null;
	/* Column Info */
	private String n2ndVvdCd = null;
	/* Column Info */
	private String phsIoRsnCd = null;
	/* Column Info */
	private String cntrFullFlg = null;
	/* Column Info */
	private String n5thSkdDirCd = null;
	/* Column Info */
	private String filePathRmk = null;
	/* Column Info */
	private String skdCngStsCd = null;
	/* Column Info */
	private String n4thPortEtdDt = null;
	/* Column Info */
	private String n3rdPortEtdDt = null;
	/* Column Info */
	private String n2ndPolCd = null;
	/* Column Info */
	private String n4thPolYdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchTsPlanGuideListVO() {}

	public SearchTsPlanGuideListVO(String ibflag, String pagerows, String plnSeq, String repTrdCd, String repSubTrdCd, String rlaneCd, String vvdCd, String irrPortCd, String irrYdCd, String dirCd, String iocCd, String cntrFullFlg, String cntrMtyFlg, String crrCd, String polCd, String n1stPortEtdDt, String n1stRlaneCd, String n1stVslCd, String n1stSkdVoyNo, String n1stSkdDirCd, String n1stPortEtbDt, String n1stPodCd, String n1stPodYdCd, String n2ndPolCd, String n2ndPolYdCd, String n2ndPortEtdDt, String n2ndRlaneCd, String n2ndVslCd, String n2ndSkdVoyNo, String n2ndSkdDirCd, String n2ndPortEtbDt, String n2ndPodCd, String n2ndPodYdCd, String n3rdPolCd, String n3rdPolYdCd, String n3rdPortEtdDt, String n3rdRlaneCd, String n3rdVslCd, String n3rdSkdVoyNo, String n3rdSkdDirCd, String n3rdPortEtbDt, String n3rdPodCd, String n3rdPodYdCd, String n4thPolCd, String n4thPolYdCd, String n4thPortEtdDt, String n4thRlaneCd, String n4thVslCd, String n4thSkdVoyNo, String n4thSkdDirCd, String n4thPortEtbDt, String n4thPodCd, String n4thPodYdCd, String n5thPolCd, String n5thPolYdCd, String n5thPortEtdDt, String n5thRlaneCd, String n5thVslCd, String n5thSkdVoyNo, String n5thSkdDirCd, String n5thPortEtbDt, String podCd, String tsPlnCfmStsCd, String tsRmk, String creUsrId, String creDt, String updUsrId, String updDt, String fileSeq, String fileNm, String filePathRmk, String fileSavId, String skdCngStsCd, String skdCngRsnCd, String usrRmk, String keys, String costWk, String mltPolListCtnt, String mltPodListCtnt, String plnAtch, String n1stVvdCd, String n2ndVvdCd, String n3rdVvdCd, String n4thVvdCd, String n5thVvdCd, String portSkpTpCd, String mltCrrListCtnt, String portSkpRsnCd, String phsIoRsnCd, String fileSize, String searchTp, String tsPlnGidDtl, String skdCngRsnNm, String existFlg, String mnCreUsrId, String mnCreDt, String mnUpdUsrId, String mnUpdDt, String mnTsRmk) {
		this.n4thSkdVoyNo = n4thSkdVoyNo;
		this.n3rdRlaneCd = n3rdRlaneCd;
		this.n5thPortEtdDt = n5thPortEtdDt;
		this.rlaneCd = rlaneCd;
		this.repTrdCd = repTrdCd;
		this.mnCreUsrId = mnCreUsrId;
		this.repSubTrdCd = repSubTrdCd;
		this.tsRmk = tsRmk;
		this.crrCd = crrCd;
		this.updUsrId = updUsrId;
		this.n2ndVslCd = n2ndVslCd;
		this.n4thSkdDirCd = n4thSkdDirCd;
		this.n2ndPodYdCd = n2ndPodYdCd;
		this.n2ndPortEtbDt = n2ndPortEtbDt;
		this.n4thVvdCd = n4thVvdCd;
		this.n5thRlaneCd = n5thRlaneCd;
		this.n1stRlaneCd = n1stRlaneCd;
		this.irrPortCd = irrPortCd;
		this.updDt = updDt;
		this.skdCngRsnCd = skdCngRsnCd;
		this.mnCreDt = mnCreDt;
		this.n3rdPodCd = n3rdPodCd;
		this.mltPolListCtnt = mltPolListCtnt;
		this.fileSeq = fileSeq;
		this.n2ndRlaneCd = n2ndRlaneCd;
		this.plnSeq = plnSeq;
		this.creUsrId = creUsrId;
		this.fileNm = fileNm;
		this.mnUpdUsrId = mnUpdUsrId;
		this.n4thVslCd = n4thVslCd;
		this.n5thVslCd = n5thVslCd;
		this.portSkpRsnCd = portSkpRsnCd;
		this.n3rdPolCd = n3rdPolCd;
		this.mltPodListCtnt = mltPodListCtnt;
		this.n4thPodYdCd = n4thPodYdCd;
		this.n2ndSkdDirCd = n2ndSkdDirCd;
		this.n3rdPodYdCd = n3rdPodYdCd;
		this.n5thVvdCd = n5thVvdCd;
		this.usrRmk = usrRmk;
		this.n2ndPolYdCd = n2ndPolYdCd;
		this.n1stPortEtbDt = n1stPortEtbDt;
		this.n4thPortEtbDt = n4thPortEtbDt;
		this.n3rdPortEtbDt = n3rdPortEtbDt;
		this.n2ndSkdVoyNo = n2ndSkdVoyNo;
		this.dirCd = dirCd;
		this.n5thPolCd = n5thPolCd;
		this.portSkpTpCd = portSkpTpCd;
		this.tsPlnGidDtl = tsPlnGidDtl;
		this.cntrMtyFlg = cntrMtyFlg;
		this.tsPlnCfmStsCd = tsPlnCfmStsCd;
		this.mltCrrListCtnt = mltCrrListCtnt;
		this.n3rdSkdVoyNo = n3rdSkdVoyNo;
		this.n5thPortEtbDt = n5thPortEtbDt;
		this.n1stSkdDirCd = n1stSkdDirCd;
		this.n3rdPolYdCd = n3rdPolYdCd;
		this.n3rdVvdCd = n3rdVvdCd;
		this.vvdCd = vvdCd;
		this.n5thPolYdCd = n5thPolYdCd;
		this.n1stPortEtdDt = n1stPortEtdDt;
		this.existFlg = existFlg;
		this.n3rdSkdDirCd = n3rdSkdDirCd;
		this.n1stVslCd = n1stVslCd;
		this.n2ndPortEtdDt = n2ndPortEtdDt;
		this.skdCngRsnNm = skdCngRsnNm;
		this.pagerows = pagerows;
		this.n4thPodCd = n4thPodCd;
		this.creDt = creDt;
		this.irrYdCd = irrYdCd;
		this.n1stVvdCd = n1stVvdCd;
		this.searchTp = searchTp;
		this.n1stSkdVoyNo = n1stSkdVoyNo;
		this.fileSize = fileSize;
		this.n1stPodCd = n1stPodCd;
		this.n3rdVslCd = n3rdVslCd;
		this.n4thPolCd = n4thPolCd;
		this.costWk = costWk;
		this.ibflag = ibflag;
		this.n4thRlaneCd = n4thRlaneCd;
		this.iocCd = iocCd;
		this.keys = keys;
		this.n1stPodYdCd = n1stPodYdCd;
		this.polCd = polCd;
		this.podCd = podCd;
		this.plnAtch = plnAtch;
		this.fileSavId = fileSavId;
		this.mnTsRmk = mnTsRmk;
		this.n2ndPodCd = n2ndPodCd;
		this.n5thSkdVoyNo = n5thSkdVoyNo;
		this.mnUpdDt = mnUpdDt;
		this.n2ndVvdCd = n2ndVvdCd;
		this.phsIoRsnCd = phsIoRsnCd;
		this.cntrFullFlg = cntrFullFlg;
		this.n5thSkdDirCd = n5thSkdDirCd;
		this.filePathRmk = filePathRmk;
		this.skdCngStsCd = skdCngStsCd;
		this.n4thPortEtdDt = n4thPortEtdDt;
		this.n3rdPortEtdDt = n3rdPortEtdDt;
		this.n2ndPolCd = n2ndPolCd;
		this.n4thPolYdCd = n4thPolYdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("n4th_skd_voy_no", getN4thSkdVoyNo());
		this.hashColumns.put("n3rd_rlane_cd", getN3rdRlaneCd());
		this.hashColumns.put("n5th_port_etd_dt", getN5thPortEtdDt());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("rep_trd_cd", getRepTrdCd());
		this.hashColumns.put("mn_cre_usr_id", getMnCreUsrId());
		this.hashColumns.put("rep_sub_trd_cd", getRepSubTrdCd());
		this.hashColumns.put("ts_rmk", getTsRmk());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("n2nd_vsl_cd", getN2ndVslCd());
		this.hashColumns.put("n4th_skd_dir_cd", getN4thSkdDirCd());
		this.hashColumns.put("n2nd_pod_yd_cd", getN2ndPodYdCd());
		this.hashColumns.put("n2nd_port_etb_dt", getN2ndPortEtbDt());
		this.hashColumns.put("n4th_vvd_cd", getN4thVvdCd());
		this.hashColumns.put("n5th_rlane_cd", getN5thRlaneCd());
		this.hashColumns.put("n1st_rlane_cd", getN1stRlaneCd());
		this.hashColumns.put("irr_port_cd", getIrrPortCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("skd_cng_rsn_cd", getSkdCngRsnCd());
		this.hashColumns.put("mn_cre_dt", getMnCreDt());
		this.hashColumns.put("n3rd_pod_cd", getN3rdPodCd());
		this.hashColumns.put("mlt_pol_list_ctnt", getMltPolListCtnt());
		this.hashColumns.put("file_seq", getFileSeq());
		this.hashColumns.put("n2nd_rlane_cd", getN2ndRlaneCd());
		this.hashColumns.put("pln_seq", getPlnSeq());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("file_nm", getFileNm());
		this.hashColumns.put("mn_upd_usr_id", getMnUpdUsrId());
		this.hashColumns.put("n4th_vsl_cd", getN4thVslCd());
		this.hashColumns.put("n5th_vsl_cd", getN5thVslCd());
		this.hashColumns.put("port_skp_rsn_cd", getPortSkpRsnCd());
		this.hashColumns.put("n3rd_pol_cd", getN3rdPolCd());
		this.hashColumns.put("mlt_pod_list_ctnt", getMltPodListCtnt());
		this.hashColumns.put("n4th_pod_yd_cd", getN4thPodYdCd());
		this.hashColumns.put("n2nd_skd_dir_cd", getN2ndSkdDirCd());
		this.hashColumns.put("n3rd_pod_yd_cd", getN3rdPodYdCd());
		this.hashColumns.put("n5th_vvd_cd", getN5thVvdCd());
		this.hashColumns.put("usr_rmk", getUsrRmk());
		this.hashColumns.put("n2nd_pol_yd_cd", getN2ndPolYdCd());
		this.hashColumns.put("n1st_port_etb_dt", getN1stPortEtbDt());
		this.hashColumns.put("n4th_port_etb_dt", getN4thPortEtbDt());
		this.hashColumns.put("n3rd_port_etb_dt", getN3rdPortEtbDt());
		this.hashColumns.put("n2nd_skd_voy_no", getN2ndSkdVoyNo());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("n5th_pol_cd", getN5thPolCd());
		this.hashColumns.put("port_skp_tp_cd", getPortSkpTpCd());
		this.hashColumns.put("ts_pln_gid_dtl", getTsPlnGidDtl());
		this.hashColumns.put("cntr_mty_flg", getCntrMtyFlg());
		this.hashColumns.put("ts_pln_cfm_sts_cd", getTsPlnCfmStsCd());
		this.hashColumns.put("mlt_crr_list_ctnt", getMltCrrListCtnt());
		this.hashColumns.put("n3rd_skd_voy_no", getN3rdSkdVoyNo());
		this.hashColumns.put("n5th_port_etb_dt", getN5thPortEtbDt());
		this.hashColumns.put("n1st_skd_dir_cd", getN1stSkdDirCd());
		this.hashColumns.put("n3rd_pol_yd_cd", getN3rdPolYdCd());
		this.hashColumns.put("n3rd_vvd_cd", getN3rdVvdCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("n5th_pol_yd_cd", getN5thPolYdCd());
		this.hashColumns.put("n1st_port_etd_dt", getN1stPortEtdDt());
		this.hashColumns.put("exist_flg", getExistFlg());
		this.hashColumns.put("n3rd_skd_dir_cd", getN3rdSkdDirCd());
		this.hashColumns.put("n1st_vsl_cd", getN1stVslCd());
		this.hashColumns.put("n2nd_port_etd_dt", getN2ndPortEtdDt());
		this.hashColumns.put("skd_cng_rsn_nm", getSkdCngRsnNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("n4th_pod_cd", getN4thPodCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("irr_yd_cd", getIrrYdCd());
		this.hashColumns.put("n1st_vvd_cd", getN1stVvdCd());
		this.hashColumns.put("search_tp", getSearchTp());
		this.hashColumns.put("n1st_skd_voy_no", getN1stSkdVoyNo());
		this.hashColumns.put("file_size", getFileSize());
		this.hashColumns.put("n1st_pod_cd", getN1stPodCd());
		this.hashColumns.put("n3rd_vsl_cd", getN3rdVslCd());
		this.hashColumns.put("n4th_pol_cd", getN4thPolCd());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("n4th_rlane_cd", getN4thRlaneCd());
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("keys", getKeys());
		this.hashColumns.put("n1st_pod_yd_cd", getN1stPodYdCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("pln_atch", getPlnAtch());
		this.hashColumns.put("file_sav_id", getFileSavId());
		this.hashColumns.put("mn_ts_rmk", getMnTsRmk());
		this.hashColumns.put("n2nd_pod_cd", getN2ndPodCd());
		this.hashColumns.put("n5th_skd_voy_no", getN5thSkdVoyNo());
		this.hashColumns.put("mn_upd_dt", getMnUpdDt());
		this.hashColumns.put("n2nd_vvd_cd", getN2ndVvdCd());
		this.hashColumns.put("phs_io_rsn_cd", getPhsIoRsnCd());
		this.hashColumns.put("cntr_full_flg", getCntrFullFlg());
		this.hashColumns.put("n5th_skd_dir_cd", getN5thSkdDirCd());
		this.hashColumns.put("file_path_rmk", getFilePathRmk());
		this.hashColumns.put("skd_cng_sts_cd", getSkdCngStsCd());
		this.hashColumns.put("n4th_port_etd_dt", getN4thPortEtdDt());
		this.hashColumns.put("n3rd_port_etd_dt", getN3rdPortEtdDt());
		this.hashColumns.put("n2nd_pol_cd", getN2ndPolCd());
		this.hashColumns.put("n4th_pol_yd_cd", getN4thPolYdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("n4th_skd_voy_no", "n4thSkdVoyNo");
		this.hashFields.put("n3rd_rlane_cd", "n3rdRlaneCd");
		this.hashFields.put("n5th_port_etd_dt", "n5thPortEtdDt");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("rep_trd_cd", "repTrdCd");
		this.hashFields.put("mn_cre_usr_id", "mnCreUsrId");
		this.hashFields.put("rep_sub_trd_cd", "repSubTrdCd");
		this.hashFields.put("ts_rmk", "tsRmk");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("n2nd_vsl_cd", "n2ndVslCd");
		this.hashFields.put("n4th_skd_dir_cd", "n4thSkdDirCd");
		this.hashFields.put("n2nd_pod_yd_cd", "n2ndPodYdCd");
		this.hashFields.put("n2nd_port_etb_dt", "n2ndPortEtbDt");
		this.hashFields.put("n4th_vvd_cd", "n4thVvdCd");
		this.hashFields.put("n5th_rlane_cd", "n5thRlaneCd");
		this.hashFields.put("n1st_rlane_cd", "n1stRlaneCd");
		this.hashFields.put("irr_port_cd", "irrPortCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("skd_cng_rsn_cd", "skdCngRsnCd");
		this.hashFields.put("mn_cre_dt", "mnCreDt");
		this.hashFields.put("n3rd_pod_cd", "n3rdPodCd");
		this.hashFields.put("mlt_pol_list_ctnt", "mltPolListCtnt");
		this.hashFields.put("file_seq", "fileSeq");
		this.hashFields.put("n2nd_rlane_cd", "n2ndRlaneCd");
		this.hashFields.put("pln_seq", "plnSeq");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("file_nm", "fileNm");
		this.hashFields.put("mn_upd_usr_id", "mnUpdUsrId");
		this.hashFields.put("n4th_vsl_cd", "n4thVslCd");
		this.hashFields.put("n5th_vsl_cd", "n5thVslCd");
		this.hashFields.put("port_skp_rsn_cd", "portSkpRsnCd");
		this.hashFields.put("n3rd_pol_cd", "n3rdPolCd");
		this.hashFields.put("mlt_pod_list_ctnt", "mltPodListCtnt");
		this.hashFields.put("n4th_pod_yd_cd", "n4thPodYdCd");
		this.hashFields.put("n2nd_skd_dir_cd", "n2ndSkdDirCd");
		this.hashFields.put("n3rd_pod_yd_cd", "n3rdPodYdCd");
		this.hashFields.put("n5th_vvd_cd", "n5thVvdCd");
		this.hashFields.put("usr_rmk", "usrRmk");
		this.hashFields.put("n2nd_pol_yd_cd", "n2ndPolYdCd");
		this.hashFields.put("n1st_port_etb_dt", "n1stPortEtbDt");
		this.hashFields.put("n4th_port_etb_dt", "n4thPortEtbDt");
		this.hashFields.put("n3rd_port_etb_dt", "n3rdPortEtbDt");
		this.hashFields.put("n2nd_skd_voy_no", "n2ndSkdVoyNo");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("n5th_pol_cd", "n5thPolCd");
		this.hashFields.put("port_skp_tp_cd", "portSkpTpCd");
		this.hashFields.put("ts_pln_gid_dtl", "tsPlnGidDtl");
		this.hashFields.put("cntr_mty_flg", "cntrMtyFlg");
		this.hashFields.put("ts_pln_cfm_sts_cd", "tsPlnCfmStsCd");
		this.hashFields.put("mlt_crr_list_ctnt", "mltCrrListCtnt");
		this.hashFields.put("n3rd_skd_voy_no", "n3rdSkdVoyNo");
		this.hashFields.put("n5th_port_etb_dt", "n5thPortEtbDt");
		this.hashFields.put("n1st_skd_dir_cd", "n1stSkdDirCd");
		this.hashFields.put("n3rd_pol_yd_cd", "n3rdPolYdCd");
		this.hashFields.put("n3rd_vvd_cd", "n3rdVvdCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("n5th_pol_yd_cd", "n5thPolYdCd");
		this.hashFields.put("n1st_port_etd_dt", "n1stPortEtdDt");
		this.hashFields.put("exist_flg", "existFlg");
		this.hashFields.put("n3rd_skd_dir_cd", "n3rdSkdDirCd");
		this.hashFields.put("n1st_vsl_cd", "n1stVslCd");
		this.hashFields.put("n2nd_port_etd_dt", "n2ndPortEtdDt");
		this.hashFields.put("skd_cng_rsn_nm", "skdCngRsnNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("n4th_pod_cd", "n4thPodCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("irr_yd_cd", "irrYdCd");
		this.hashFields.put("n1st_vvd_cd", "n1stVvdCd");
		this.hashFields.put("search_tp", "searchTp");
		this.hashFields.put("n1st_skd_voy_no", "n1stSkdVoyNo");
		this.hashFields.put("file_size", "fileSize");
		this.hashFields.put("n1st_pod_cd", "n1stPodCd");
		this.hashFields.put("n3rd_vsl_cd", "n3rdVslCd");
		this.hashFields.put("n4th_pol_cd", "n4thPolCd");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("n4th_rlane_cd", "n4thRlaneCd");
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("keys", "keys");
		this.hashFields.put("n1st_pod_yd_cd", "n1stPodYdCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("pln_atch", "plnAtch");
		this.hashFields.put("file_sav_id", "fileSavId");
		this.hashFields.put("mn_ts_rmk", "mnTsRmk");
		this.hashFields.put("n2nd_pod_cd", "n2ndPodCd");
		this.hashFields.put("n5th_skd_voy_no", "n5thSkdVoyNo");
		this.hashFields.put("mn_upd_dt", "mnUpdDt");
		this.hashFields.put("n2nd_vvd_cd", "n2ndVvdCd");
		this.hashFields.put("phs_io_rsn_cd", "phsIoRsnCd");
		this.hashFields.put("cntr_full_flg", "cntrFullFlg");
		this.hashFields.put("n5th_skd_dir_cd", "n5thSkdDirCd");
		this.hashFields.put("file_path_rmk", "filePathRmk");
		this.hashFields.put("skd_cng_sts_cd", "skdCngStsCd");
		this.hashFields.put("n4th_port_etd_dt", "n4thPortEtdDt");
		this.hashFields.put("n3rd_port_etd_dt", "n3rdPortEtdDt");
		this.hashFields.put("n2nd_pol_cd", "n2ndPolCd");
		this.hashFields.put("n4th_pol_yd_cd", "n4thPolYdCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return n4thSkdVoyNo
	 */
	public String getN4thSkdVoyNo() {
		return this.n4thSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return n3rdRlaneCd
	 */
	public String getN3rdRlaneCd() {
		return this.n3rdRlaneCd;
	}
	
	/**
	 * Column Info
	 * @return n5thPortEtdDt
	 */
	public String getN5thPortEtdDt() {
		return this.n5thPortEtdDt;
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
	 * @return mnCreUsrId
	 */
	public String getMnCreUsrId() {
		return this.mnCreUsrId;
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
	 * @return tsRmk
	 */
	public String getTsRmk() {
		return this.tsRmk;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return n2ndVslCd
	 */
	public String getN2ndVslCd() {
		return this.n2ndVslCd;
	}
	
	/**
	 * Column Info
	 * @return n4thSkdDirCd
	 */
	public String getN4thSkdDirCd() {
		return this.n4thSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return n2ndPodYdCd
	 */
	public String getN2ndPodYdCd() {
		return this.n2ndPodYdCd;
	}
	
	/**
	 * Column Info
	 * @return n2ndPortEtbDt
	 */
	public String getN2ndPortEtbDt() {
		return this.n2ndPortEtbDt;
	}
	
	/**
	 * Column Info
	 * @return n4thVvdCd
	 */
	public String getN4thVvdCd() {
		return this.n4thVvdCd;
	}
	
	/**
	 * Column Info
	 * @return n5thRlaneCd
	 */
	public String getN5thRlaneCd() {
		return this.n5thRlaneCd;
	}
	
	/**
	 * Column Info
	 * @return n1stRlaneCd
	 */
	public String getN1stRlaneCd() {
		return this.n1stRlaneCd;
	}
	
	/**
	 * Column Info
	 * @return irrPortCd
	 */
	public String getIrrPortCd() {
		return this.irrPortCd;
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
	 * @return skdCngRsnCd
	 */
	public String getSkdCngRsnCd() {
		return this.skdCngRsnCd;
	}
	
	/**
	 * Column Info
	 * @return mnCreDt
	 */
	public String getMnCreDt() {
		return this.mnCreDt;
	}
	
	/**
	 * Column Info
	 * @return n3rdPodCd
	 */
	public String getN3rdPodCd() {
		return this.n3rdPodCd;
	}
	
	/**
	 * Column Info
	 * @return mltPolListCtnt
	 */
	public String getMltPolListCtnt() {
		return this.mltPolListCtnt;
	}
	
	/**
	 * Column Info
	 * @return fileSeq
	 */
	public String getFileSeq() {
		return this.fileSeq;
	}
	
	/**
	 * Column Info
	 * @return n2ndRlaneCd
	 */
	public String getN2ndRlaneCd() {
		return this.n2ndRlaneCd;
	}
	
	/**
	 * Column Info
	 * @return plnSeq
	 */
	public String getPlnSeq() {
		return this.plnSeq;
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
	 * @return fileNm
	 */
	public String getFileNm() {
		return this.fileNm;
	}
	
	/**
	 * Column Info
	 * @return mnUpdUsrId
	 */
	public String getMnUpdUsrId() {
		return this.mnUpdUsrId;
	}
	
	/**
	 * Column Info
	 * @return n4thVslCd
	 */
	public String getN4thVslCd() {
		return this.n4thVslCd;
	}
	
	/**
	 * Column Info
	 * @return n5thVslCd
	 */
	public String getN5thVslCd() {
		return this.n5thVslCd;
	}
	
	/**
	 * Column Info
	 * @return portSkpRsnCd
	 */
	public String getPortSkpRsnCd() {
		return this.portSkpRsnCd;
	}
	
	/**
	 * Column Info
	 * @return n3rdPolCd
	 */
	public String getN3rdPolCd() {
		return this.n3rdPolCd;
	}
	
	/**
	 * Column Info
	 * @return mltPodListCtnt
	 */
	public String getMltPodListCtnt() {
		return this.mltPodListCtnt;
	}
	
	/**
	 * Column Info
	 * @return n4thPodYdCd
	 */
	public String getN4thPodYdCd() {
		return this.n4thPodYdCd;
	}
	
	/**
	 * Column Info
	 * @return n2ndSkdDirCd
	 */
	public String getN2ndSkdDirCd() {
		return this.n2ndSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return n3rdPodYdCd
	 */
	public String getN3rdPodYdCd() {
		return this.n3rdPodYdCd;
	}
	
	/**
	 * Column Info
	 * @return n5thVvdCd
	 */
	public String getN5thVvdCd() {
		return this.n5thVvdCd;
	}
	
	/**
	 * Column Info
	 * @return usrRmk
	 */
	public String getUsrRmk() {
		return this.usrRmk;
	}
	
	/**
	 * Column Info
	 * @return n2ndPolYdCd
	 */
	public String getN2ndPolYdCd() {
		return this.n2ndPolYdCd;
	}
	
	/**
	 * Column Info
	 * @return n1stPortEtbDt
	 */
	public String getN1stPortEtbDt() {
		return this.n1stPortEtbDt;
	}
	
	/**
	 * Column Info
	 * @return n4thPortEtbDt
	 */
	public String getN4thPortEtbDt() {
		return this.n4thPortEtbDt;
	}
	
	/**
	 * Column Info
	 * @return n3rdPortEtbDt
	 */
	public String getN3rdPortEtbDt() {
		return this.n3rdPortEtbDt;
	}
	
	/**
	 * Column Info
	 * @return n2ndSkdVoyNo
	 */
	public String getN2ndSkdVoyNo() {
		return this.n2ndSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return n5thPolCd
	 */
	public String getN5thPolCd() {
		return this.n5thPolCd;
	}
	
	/**
	 * Column Info
	 * @return portSkpTpCd
	 */
	public String getPortSkpTpCd() {
		return this.portSkpTpCd;
	}
	
	/**
	 * Column Info
	 * @return tsPlnGidDtl
	 */
	public String getTsPlnGidDtl() {
		return this.tsPlnGidDtl;
	}
	
	/**
	 * Column Info
	 * @return cntrMtyFlg
	 */
	public String getCntrMtyFlg() {
		return this.cntrMtyFlg;
	}
	
	/**
	 * Column Info
	 * @return tsPlnCfmStsCd
	 */
	public String getTsPlnCfmStsCd() {
		return this.tsPlnCfmStsCd;
	}
	
	/**
	 * Column Info
	 * @return mltCrrListCtnt
	 */
	public String getMltCrrListCtnt() {
		return this.mltCrrListCtnt;
	}
	
	/**
	 * Column Info
	 * @return n3rdSkdVoyNo
	 */
	public String getN3rdSkdVoyNo() {
		return this.n3rdSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return n5thPortEtbDt
	 */
	public String getN5thPortEtbDt() {
		return this.n5thPortEtbDt;
	}
	
	/**
	 * Column Info
	 * @return n1stSkdDirCd
	 */
	public String getN1stSkdDirCd() {
		return this.n1stSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return n3rdPolYdCd
	 */
	public String getN3rdPolYdCd() {
		return this.n3rdPolYdCd;
	}
	
	/**
	 * Column Info
	 * @return n3rdVvdCd
	 */
	public String getN3rdVvdCd() {
		return this.n3rdVvdCd;
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
	 * @return n5thPolYdCd
	 */
	public String getN5thPolYdCd() {
		return this.n5thPolYdCd;
	}
	
	/**
	 * Column Info
	 * @return n1stPortEtdDt
	 */
	public String getN1stPortEtdDt() {
		return this.n1stPortEtdDt;
	}
	
	/**
	 * Column Info
	 * @return existFlg
	 */
	public String getExistFlg() {
		return this.existFlg;
	}
	
	/**
	 * Column Info
	 * @return n3rdSkdDirCd
	 */
	public String getN3rdSkdDirCd() {
		return this.n3rdSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return n1stVslCd
	 */
	public String getN1stVslCd() {
		return this.n1stVslCd;
	}
	
	/**
	 * Column Info
	 * @return n2ndPortEtdDt
	 */
	public String getN2ndPortEtdDt() {
		return this.n2ndPortEtdDt;
	}
	
	/**
	 * Column Info
	 * @return skdCngRsnNm
	 */
	public String getSkdCngRsnNm() {
		return this.skdCngRsnNm;
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
	 * @return n4thPodCd
	 */
	public String getN4thPodCd() {
		return this.n4thPodCd;
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
	 * @return irrYdCd
	 */
	public String getIrrYdCd() {
		return this.irrYdCd;
	}
	
	/**
	 * Column Info
	 * @return n1stVvdCd
	 */
	public String getN1stVvdCd() {
		return this.n1stVvdCd;
	}
	
	/**
	 * Column Info
	 * @return searchTp
	 */
	public String getSearchTp() {
		return this.searchTp;
	}
	
	/**
	 * Column Info
	 * @return n1stSkdVoyNo
	 */
	public String getN1stSkdVoyNo() {
		return this.n1stSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return fileSize
	 */
	public String getFileSize() {
		return this.fileSize;
	}
	
	/**
	 * Column Info
	 * @return n1stPodCd
	 */
	public String getN1stPodCd() {
		return this.n1stPodCd;
	}
	
	/**
	 * Column Info
	 * @return n3rdVslCd
	 */
	public String getN3rdVslCd() {
		return this.n3rdVslCd;
	}
	
	/**
	 * Column Info
	 * @return n4thPolCd
	 */
	public String getN4thPolCd() {
		return this.n4thPolCd;
	}
	
	/**
	 * Column Info
	 * @return costWk
	 */
	public String getCostWk() {
		return this.costWk;
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
	 * @return n4thRlaneCd
	 */
	public String getN4thRlaneCd() {
		return this.n4thRlaneCd;
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
	 * @return keys
	 */
	public String getKeys() {
		return this.keys;
	}
	
	/**
	 * Column Info
	 * @return n1stPodYdCd
	 */
	public String getN1stPodYdCd() {
		return this.n1stPodYdCd;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return plnAtch
	 */
	public String getPlnAtch() {
		return this.plnAtch;
	}
	
	/**
	 * Column Info
	 * @return fileSavId
	 */
	public String getFileSavId() {
		return this.fileSavId;
	}
	
	/**
	 * Column Info
	 * @return mnTsRmk
	 */
	public String getMnTsRmk() {
		return this.mnTsRmk;
	}
	
	/**
	 * Column Info
	 * @return n2ndPodCd
	 */
	public String getN2ndPodCd() {
		return this.n2ndPodCd;
	}
	
	/**
	 * Column Info
	 * @return n5thSkdVoyNo
	 */
	public String getN5thSkdVoyNo() {
		return this.n5thSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return mnUpdDt
	 */
	public String getMnUpdDt() {
		return this.mnUpdDt;
	}
	
	/**
	 * Column Info
	 * @return n2ndVvdCd
	 */
	public String getN2ndVvdCd() {
		return this.n2ndVvdCd;
	}
	
	/**
	 * Column Info
	 * @return phsIoRsnCd
	 */
	public String getPhsIoRsnCd() {
		return this.phsIoRsnCd;
	}
	
	/**
	 * Column Info
	 * @return cntrFullFlg
	 */
	public String getCntrFullFlg() {
		return this.cntrFullFlg;
	}
	
	/**
	 * Column Info
	 * @return n5thSkdDirCd
	 */
	public String getN5thSkdDirCd() {
		return this.n5thSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return filePathRmk
	 */
	public String getFilePathRmk() {
		return this.filePathRmk;
	}
	
	/**
	 * Column Info
	 * @return skdCngStsCd
	 */
	public String getSkdCngStsCd() {
		return this.skdCngStsCd;
	}
	
	/**
	 * Column Info
	 * @return n4thPortEtdDt
	 */
	public String getN4thPortEtdDt() {
		return this.n4thPortEtdDt;
	}
	
	/**
	 * Column Info
	 * @return n3rdPortEtdDt
	 */
	public String getN3rdPortEtdDt() {
		return this.n3rdPortEtdDt;
	}
	
	/**
	 * Column Info
	 * @return n2ndPolCd
	 */
	public String getN2ndPolCd() {
		return this.n2ndPolCd;
	}
	
	/**
	 * Column Info
	 * @return n4thPolYdCd
	 */
	public String getN4thPolYdCd() {
		return this.n4thPolYdCd;
	}
	

	/**
	 * Column Info
	 * @param n4thSkdVoyNo
	 */
	public void setN4thSkdVoyNo(String n4thSkdVoyNo) {
		this.n4thSkdVoyNo = n4thSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param n3rdRlaneCd
	 */
	public void setN3rdRlaneCd(String n3rdRlaneCd) {
		this.n3rdRlaneCd = n3rdRlaneCd;
	}
	
	/**
	 * Column Info
	 * @param n5thPortEtdDt
	 */
	public void setN5thPortEtdDt(String n5thPortEtdDt) {
		this.n5thPortEtdDt = n5thPortEtdDt;
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
	 * @param mnCreUsrId
	 */
	public void setMnCreUsrId(String mnCreUsrId) {
		this.mnCreUsrId = mnCreUsrId;
	}
	
	/**
	 * Column Info
	 * @param repSubTrdCd
	 */
	public void setRepSubTrdCd(String repSubTrdCd) {
		this.repSubTrdCd = repSubTrdCd;
	}
	
	/**
	 * Column Info
	 * @param tsRmk
	 */
	public void setTsRmk(String tsRmk) {
		this.tsRmk = tsRmk;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param n2ndVslCd
	 */
	public void setN2ndVslCd(String n2ndVslCd) {
		this.n2ndVslCd = n2ndVslCd;
	}
	
	/**
	 * Column Info
	 * @param n4thSkdDirCd
	 */
	public void setN4thSkdDirCd(String n4thSkdDirCd) {
		this.n4thSkdDirCd = n4thSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param n2ndPodYdCd
	 */
	public void setN2ndPodYdCd(String n2ndPodYdCd) {
		this.n2ndPodYdCd = n2ndPodYdCd;
	}
	
	/**
	 * Column Info
	 * @param n2ndPortEtbDt
	 */
	public void setN2ndPortEtbDt(String n2ndPortEtbDt) {
		this.n2ndPortEtbDt = n2ndPortEtbDt;
	}
	
	/**
	 * Column Info
	 * @param n4thVvdCd
	 */
	public void setN4thVvdCd(String n4thVvdCd) {
		this.n4thVvdCd = n4thVvdCd;
	}
	
	/**
	 * Column Info
	 * @param n5thRlaneCd
	 */
	public void setN5thRlaneCd(String n5thRlaneCd) {
		this.n5thRlaneCd = n5thRlaneCd;
	}
	
	/**
	 * Column Info
	 * @param n1stRlaneCd
	 */
	public void setN1stRlaneCd(String n1stRlaneCd) {
		this.n1stRlaneCd = n1stRlaneCd;
	}
	
	/**
	 * Column Info
	 * @param irrPortCd
	 */
	public void setIrrPortCd(String irrPortCd) {
		this.irrPortCd = irrPortCd;
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
	 * @param skdCngRsnCd
	 */
	public void setSkdCngRsnCd(String skdCngRsnCd) {
		this.skdCngRsnCd = skdCngRsnCd;
	}
	
	/**
	 * Column Info
	 * @param mnCreDt
	 */
	public void setMnCreDt(String mnCreDt) {
		this.mnCreDt = mnCreDt;
	}
	
	/**
	 * Column Info
	 * @param n3rdPodCd
	 */
	public void setN3rdPodCd(String n3rdPodCd) {
		this.n3rdPodCd = n3rdPodCd;
	}
	
	/**
	 * Column Info
	 * @param mltPolListCtnt
	 */
	public void setMltPolListCtnt(String mltPolListCtnt) {
		this.mltPolListCtnt = mltPolListCtnt;
	}
	
	/**
	 * Column Info
	 * @param fileSeq
	 */
	public void setFileSeq(String fileSeq) {
		this.fileSeq = fileSeq;
	}
	
	/**
	 * Column Info
	 * @param n2ndRlaneCd
	 */
	public void setN2ndRlaneCd(String n2ndRlaneCd) {
		this.n2ndRlaneCd = n2ndRlaneCd;
	}
	
	/**
	 * Column Info
	 * @param plnSeq
	 */
	public void setPlnSeq(String plnSeq) {
		this.plnSeq = plnSeq;
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
	 * @param fileNm
	 */
	public void setFileNm(String fileNm) {
		this.fileNm = fileNm;
	}
	
	/**
	 * Column Info
	 * @param mnUpdUsrId
	 */
	public void setMnUpdUsrId(String mnUpdUsrId) {
		this.mnUpdUsrId = mnUpdUsrId;
	}
	
	/**
	 * Column Info
	 * @param n4thVslCd
	 */
	public void setN4thVslCd(String n4thVslCd) {
		this.n4thVslCd = n4thVslCd;
	}
	
	/**
	 * Column Info
	 * @param n5thVslCd
	 */
	public void setN5thVslCd(String n5thVslCd) {
		this.n5thVslCd = n5thVslCd;
	}
	
	/**
	 * Column Info
	 * @param portSkpRsnCd
	 */
	public void setPortSkpRsnCd(String portSkpRsnCd) {
		this.portSkpRsnCd = portSkpRsnCd;
	}
	
	/**
	 * Column Info
	 * @param n3rdPolCd
	 */
	public void setN3rdPolCd(String n3rdPolCd) {
		this.n3rdPolCd = n3rdPolCd;
	}
	
	/**
	 * Column Info
	 * @param mltPodListCtnt
	 */
	public void setMltPodListCtnt(String mltPodListCtnt) {
		this.mltPodListCtnt = mltPodListCtnt;
	}
	
	/**
	 * Column Info
	 * @param n4thPodYdCd
	 */
	public void setN4thPodYdCd(String n4thPodYdCd) {
		this.n4thPodYdCd = n4thPodYdCd;
	}
	
	/**
	 * Column Info
	 * @param n2ndSkdDirCd
	 */
	public void setN2ndSkdDirCd(String n2ndSkdDirCd) {
		this.n2ndSkdDirCd = n2ndSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param n3rdPodYdCd
	 */
	public void setN3rdPodYdCd(String n3rdPodYdCd) {
		this.n3rdPodYdCd = n3rdPodYdCd;
	}
	
	/**
	 * Column Info
	 * @param n5thVvdCd
	 */
	public void setN5thVvdCd(String n5thVvdCd) {
		this.n5thVvdCd = n5thVvdCd;
	}
	
	/**
	 * Column Info
	 * @param usrRmk
	 */
	public void setUsrRmk(String usrRmk) {
		this.usrRmk = usrRmk;
	}
	
	/**
	 * Column Info
	 * @param n2ndPolYdCd
	 */
	public void setN2ndPolYdCd(String n2ndPolYdCd) {
		this.n2ndPolYdCd = n2ndPolYdCd;
	}
	
	/**
	 * Column Info
	 * @param n1stPortEtbDt
	 */
	public void setN1stPortEtbDt(String n1stPortEtbDt) {
		this.n1stPortEtbDt = n1stPortEtbDt;
	}
	
	/**
	 * Column Info
	 * @param n4thPortEtbDt
	 */
	public void setN4thPortEtbDt(String n4thPortEtbDt) {
		this.n4thPortEtbDt = n4thPortEtbDt;
	}
	
	/**
	 * Column Info
	 * @param n3rdPortEtbDt
	 */
	public void setN3rdPortEtbDt(String n3rdPortEtbDt) {
		this.n3rdPortEtbDt = n3rdPortEtbDt;
	}
	
	/**
	 * Column Info
	 * @param n2ndSkdVoyNo
	 */
	public void setN2ndSkdVoyNo(String n2ndSkdVoyNo) {
		this.n2ndSkdVoyNo = n2ndSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param n5thPolCd
	 */
	public void setN5thPolCd(String n5thPolCd) {
		this.n5thPolCd = n5thPolCd;
	}
	
	/**
	 * Column Info
	 * @param portSkpTpCd
	 */
	public void setPortSkpTpCd(String portSkpTpCd) {
		this.portSkpTpCd = portSkpTpCd;
	}
	
	/**
	 * Column Info
	 * @param tsPlnGidDtl
	 */
	public void setTsPlnGidDtl(String tsPlnGidDtl) {
		this.tsPlnGidDtl = tsPlnGidDtl;
	}
	
	/**
	 * Column Info
	 * @param cntrMtyFlg
	 */
	public void setCntrMtyFlg(String cntrMtyFlg) {
		this.cntrMtyFlg = cntrMtyFlg;
	}
	
	/**
	 * Column Info
	 * @param tsPlnCfmStsCd
	 */
	public void setTsPlnCfmStsCd(String tsPlnCfmStsCd) {
		this.tsPlnCfmStsCd = tsPlnCfmStsCd;
	}
	
	/**
	 * Column Info
	 * @param mltCrrListCtnt
	 */
	public void setMltCrrListCtnt(String mltCrrListCtnt) {
		this.mltCrrListCtnt = mltCrrListCtnt;
	}
	
	/**
	 * Column Info
	 * @param n3rdSkdVoyNo
	 */
	public void setN3rdSkdVoyNo(String n3rdSkdVoyNo) {
		this.n3rdSkdVoyNo = n3rdSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param n5thPortEtbDt
	 */
	public void setN5thPortEtbDt(String n5thPortEtbDt) {
		this.n5thPortEtbDt = n5thPortEtbDt;
	}
	
	/**
	 * Column Info
	 * @param n1stSkdDirCd
	 */
	public void setN1stSkdDirCd(String n1stSkdDirCd) {
		this.n1stSkdDirCd = n1stSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param n3rdPolYdCd
	 */
	public void setN3rdPolYdCd(String n3rdPolYdCd) {
		this.n3rdPolYdCd = n3rdPolYdCd;
	}
	
	/**
	 * Column Info
	 * @param n3rdVvdCd
	 */
	public void setN3rdVvdCd(String n3rdVvdCd) {
		this.n3rdVvdCd = n3rdVvdCd;
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
	 * @param n5thPolYdCd
	 */
	public void setN5thPolYdCd(String n5thPolYdCd) {
		this.n5thPolYdCd = n5thPolYdCd;
	}
	
	/**
	 * Column Info
	 * @param n1stPortEtdDt
	 */
	public void setN1stPortEtdDt(String n1stPortEtdDt) {
		this.n1stPortEtdDt = n1stPortEtdDt;
	}
	
	/**
	 * Column Info
	 * @param existFlg
	 */
	public void setExistFlg(String existFlg) {
		this.existFlg = existFlg;
	}
	
	/**
	 * Column Info
	 * @param n3rdSkdDirCd
	 */
	public void setN3rdSkdDirCd(String n3rdSkdDirCd) {
		this.n3rdSkdDirCd = n3rdSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param n1stVslCd
	 */
	public void setN1stVslCd(String n1stVslCd) {
		this.n1stVslCd = n1stVslCd;
	}
	
	/**
	 * Column Info
	 * @param n2ndPortEtdDt
	 */
	public void setN2ndPortEtdDt(String n2ndPortEtdDt) {
		this.n2ndPortEtdDt = n2ndPortEtdDt;
	}
	
	/**
	 * Column Info
	 * @param skdCngRsnNm
	 */
	public void setSkdCngRsnNm(String skdCngRsnNm) {
		this.skdCngRsnNm = skdCngRsnNm;
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
	 * @param n4thPodCd
	 */
	public void setN4thPodCd(String n4thPodCd) {
		this.n4thPodCd = n4thPodCd;
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
	 * @param irrYdCd
	 */
	public void setIrrYdCd(String irrYdCd) {
		this.irrYdCd = irrYdCd;
	}
	
	/**
	 * Column Info
	 * @param n1stVvdCd
	 */
	public void setN1stVvdCd(String n1stVvdCd) {
		this.n1stVvdCd = n1stVvdCd;
	}
	
	/**
	 * Column Info
	 * @param searchTp
	 */
	public void setSearchTp(String searchTp) {
		this.searchTp = searchTp;
	}
	
	/**
	 * Column Info
	 * @param n1stSkdVoyNo
	 */
	public void setN1stSkdVoyNo(String n1stSkdVoyNo) {
		this.n1stSkdVoyNo = n1stSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param fileSize
	 */
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	
	/**
	 * Column Info
	 * @param n1stPodCd
	 */
	public void setN1stPodCd(String n1stPodCd) {
		this.n1stPodCd = n1stPodCd;
	}
	
	/**
	 * Column Info
	 * @param n3rdVslCd
	 */
	public void setN3rdVslCd(String n3rdVslCd) {
		this.n3rdVslCd = n3rdVslCd;
	}
	
	/**
	 * Column Info
	 * @param n4thPolCd
	 */
	public void setN4thPolCd(String n4thPolCd) {
		this.n4thPolCd = n4thPolCd;
	}
	
	/**
	 * Column Info
	 * @param costWk
	 */
	public void setCostWk(String costWk) {
		this.costWk = costWk;
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
	 * @param n4thRlaneCd
	 */
	public void setN4thRlaneCd(String n4thRlaneCd) {
		this.n4thRlaneCd = n4thRlaneCd;
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
	 * @param keys
	 */
	public void setKeys(String keys) {
		this.keys = keys;
	}
	
	/**
	 * Column Info
	 * @param n1stPodYdCd
	 */
	public void setN1stPodYdCd(String n1stPodYdCd) {
		this.n1stPodYdCd = n1stPodYdCd;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param plnAtch
	 */
	public void setPlnAtch(String plnAtch) {
		this.plnAtch = plnAtch;
	}
	
	/**
	 * Column Info
	 * @param fileSavId
	 */
	public void setFileSavId(String fileSavId) {
		this.fileSavId = fileSavId;
	}
	
	/**
	 * Column Info
	 * @param mnTsRmk
	 */
	public void setMnTsRmk(String mnTsRmk) {
		this.mnTsRmk = mnTsRmk;
	}
	
	/**
	 * Column Info
	 * @param n2ndPodCd
	 */
	public void setN2ndPodCd(String n2ndPodCd) {
		this.n2ndPodCd = n2ndPodCd;
	}
	
	/**
	 * Column Info
	 * @param n5thSkdVoyNo
	 */
	public void setN5thSkdVoyNo(String n5thSkdVoyNo) {
		this.n5thSkdVoyNo = n5thSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param mnUpdDt
	 */
	public void setMnUpdDt(String mnUpdDt) {
		this.mnUpdDt = mnUpdDt;
	}
	
	/**
	 * Column Info
	 * @param n2ndVvdCd
	 */
	public void setN2ndVvdCd(String n2ndVvdCd) {
		this.n2ndVvdCd = n2ndVvdCd;
	}
	
	/**
	 * Column Info
	 * @param phsIoRsnCd
	 */
	public void setPhsIoRsnCd(String phsIoRsnCd) {
		this.phsIoRsnCd = phsIoRsnCd;
	}
	
	/**
	 * Column Info
	 * @param cntrFullFlg
	 */
	public void setCntrFullFlg(String cntrFullFlg) {
		this.cntrFullFlg = cntrFullFlg;
	}
	
	/**
	 * Column Info
	 * @param n5thSkdDirCd
	 */
	public void setN5thSkdDirCd(String n5thSkdDirCd) {
		this.n5thSkdDirCd = n5thSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param filePathRmk
	 */
	public void setFilePathRmk(String filePathRmk) {
		this.filePathRmk = filePathRmk;
	}
	
	/**
	 * Column Info
	 * @param skdCngStsCd
	 */
	public void setSkdCngStsCd(String skdCngStsCd) {
		this.skdCngStsCd = skdCngStsCd;
	}
	
	/**
	 * Column Info
	 * @param n4thPortEtdDt
	 */
	public void setN4thPortEtdDt(String n4thPortEtdDt) {
		this.n4thPortEtdDt = n4thPortEtdDt;
	}
	
	/**
	 * Column Info
	 * @param n3rdPortEtdDt
	 */
	public void setN3rdPortEtdDt(String n3rdPortEtdDt) {
		this.n3rdPortEtdDt = n3rdPortEtdDt;
	}
	
	/**
	 * Column Info
	 * @param n2ndPolCd
	 */
	public void setN2ndPolCd(String n2ndPolCd) {
		this.n2ndPolCd = n2ndPolCd;
	}
	
	/**
	 * Column Info
	 * @param n4thPolYdCd
	 */
	public void setN4thPolYdCd(String n4thPolYdCd) {
		this.n4thPolYdCd = n4thPolYdCd;
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
		setN4thSkdVoyNo(JSPUtil.getParameter(request, prefix + "n4th_skd_voy_no", ""));
		setN3rdRlaneCd(JSPUtil.getParameter(request, prefix + "n3rd_rlane_cd", ""));
		setN5thPortEtdDt(JSPUtil.getParameter(request, prefix + "n5th_port_etd_dt", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setRepTrdCd(JSPUtil.getParameter(request, prefix + "rep_trd_cd", ""));
		setMnCreUsrId(JSPUtil.getParameter(request, prefix + "mn_cre_usr_id", ""));
		setRepSubTrdCd(JSPUtil.getParameter(request, prefix + "rep_sub_trd_cd", ""));
		setTsRmk(JSPUtil.getParameter(request, prefix + "ts_rmk", ""));
		setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setN2ndVslCd(JSPUtil.getParameter(request, prefix + "n2nd_vsl_cd", ""));
		setN4thSkdDirCd(JSPUtil.getParameter(request, prefix + "n4th_skd_dir_cd", ""));
		setN2ndPodYdCd(JSPUtil.getParameter(request, prefix + "n2nd_pod_yd_cd", ""));
		setN2ndPortEtbDt(JSPUtil.getParameter(request, prefix + "n2nd_port_etb_dt", ""));
		setN4thVvdCd(JSPUtil.getParameter(request, prefix + "n4th_vvd_cd", ""));
		setN5thRlaneCd(JSPUtil.getParameter(request, prefix + "n5th_rlane_cd", ""));
		setN1stRlaneCd(JSPUtil.getParameter(request, prefix + "n1st_rlane_cd", ""));
		setIrrPortCd(JSPUtil.getParameter(request, prefix + "irr_port_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setSkdCngRsnCd(JSPUtil.getParameter(request, prefix + "skd_cng_rsn_cd", ""));
		setMnCreDt(JSPUtil.getParameter(request, prefix + "mn_cre_dt", ""));
		setN3rdPodCd(JSPUtil.getParameter(request, prefix + "n3rd_pod_cd", ""));
		setMltPolListCtnt(JSPUtil.getParameter(request, prefix + "mlt_pol_list_ctnt", ""));
		setFileSeq(JSPUtil.getParameter(request, prefix + "file_seq", ""));
		setN2ndRlaneCd(JSPUtil.getParameter(request, prefix + "n2nd_rlane_cd", ""));
		setPlnSeq(JSPUtil.getParameter(request, prefix + "pln_seq", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setFileNm(JSPUtil.getParameter(request, prefix + "file_nm", ""));
		setMnUpdUsrId(JSPUtil.getParameter(request, prefix + "mn_upd_usr_id", ""));
		setN4thVslCd(JSPUtil.getParameter(request, prefix + "n4th_vsl_cd", ""));
		setN5thVslCd(JSPUtil.getParameter(request, prefix + "n5th_vsl_cd", ""));
		setPortSkpRsnCd(JSPUtil.getParameter(request, prefix + "port_skp_rsn_cd", ""));
		setN3rdPolCd(JSPUtil.getParameter(request, prefix + "n3rd_pol_cd", ""));
		setMltPodListCtnt(JSPUtil.getParameter(request, prefix + "mlt_pod_list_ctnt", ""));
		setN4thPodYdCd(JSPUtil.getParameter(request, prefix + "n4th_pod_yd_cd", ""));
		setN2ndSkdDirCd(JSPUtil.getParameter(request, prefix + "n2nd_skd_dir_cd", ""));
		setN3rdPodYdCd(JSPUtil.getParameter(request, prefix + "n3rd_pod_yd_cd", ""));
		setN5thVvdCd(JSPUtil.getParameter(request, prefix + "n5th_vvd_cd", ""));
		setUsrRmk(JSPUtil.getParameter(request, prefix + "usr_rmk", ""));
		setN2ndPolYdCd(JSPUtil.getParameter(request, prefix + "n2nd_pol_yd_cd", ""));
		setN1stPortEtbDt(JSPUtil.getParameter(request, prefix + "n1st_port_etb_dt", ""));
		setN4thPortEtbDt(JSPUtil.getParameter(request, prefix + "n4th_port_etb_dt", ""));
		setN3rdPortEtbDt(JSPUtil.getParameter(request, prefix + "n3rd_port_etb_dt", ""));
		setN2ndSkdVoyNo(JSPUtil.getParameter(request, prefix + "n2nd_skd_voy_no", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setN5thPolCd(JSPUtil.getParameter(request, prefix + "n5th_pol_cd", ""));
		setPortSkpTpCd(JSPUtil.getParameter(request, prefix + "port_skp_tp_cd", ""));
		setTsPlnGidDtl(JSPUtil.getParameter(request, prefix + "ts_pln_gid_dtl", ""));
		setCntrMtyFlg(JSPUtil.getParameter(request, prefix + "cntr_mty_flg", ""));
		setTsPlnCfmStsCd(JSPUtil.getParameter(request, prefix + "ts_pln_cfm_sts_cd", ""));
		setMltCrrListCtnt(JSPUtil.getParameter(request, prefix + "mlt_crr_list_ctnt", ""));
		setN3rdSkdVoyNo(JSPUtil.getParameter(request, prefix + "n3rd_skd_voy_no", ""));
		setN5thPortEtbDt(JSPUtil.getParameter(request, prefix + "n5th_port_etb_dt", ""));
		setN1stSkdDirCd(JSPUtil.getParameter(request, prefix + "n1st_skd_dir_cd", ""));
		setN3rdPolYdCd(JSPUtil.getParameter(request, prefix + "n3rd_pol_yd_cd", ""));
		setN3rdVvdCd(JSPUtil.getParameter(request, prefix + "n3rd_vvd_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setN5thPolYdCd(JSPUtil.getParameter(request, prefix + "n5th_pol_yd_cd", ""));
		setN1stPortEtdDt(JSPUtil.getParameter(request, prefix + "n1st_port_etd_dt", ""));
		setExistFlg(JSPUtil.getParameter(request, prefix + "exist_flg", ""));
		setN3rdSkdDirCd(JSPUtil.getParameter(request, prefix + "n3rd_skd_dir_cd", ""));
		setN1stVslCd(JSPUtil.getParameter(request, prefix + "n1st_vsl_cd", ""));
		setN2ndPortEtdDt(JSPUtil.getParameter(request, prefix + "n2nd_port_etd_dt", ""));
		setSkdCngRsnNm(JSPUtil.getParameter(request, prefix + "skd_cng_rsn_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setN4thPodCd(JSPUtil.getParameter(request, prefix + "n4th_pod_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setIrrYdCd(JSPUtil.getParameter(request, prefix + "irr_yd_cd", ""));
		setN1stVvdCd(JSPUtil.getParameter(request, prefix + "n1st_vvd_cd", ""));
		setSearchTp(JSPUtil.getParameter(request, prefix + "search_tp", ""));
		setN1stSkdVoyNo(JSPUtil.getParameter(request, prefix + "n1st_skd_voy_no", ""));
		setFileSize(JSPUtil.getParameter(request, prefix + "file_size", ""));
		setN1stPodCd(JSPUtil.getParameter(request, prefix + "n1st_pod_cd", ""));
		setN3rdVslCd(JSPUtil.getParameter(request, prefix + "n3rd_vsl_cd", ""));
		setN4thPolCd(JSPUtil.getParameter(request, prefix + "n4th_pol_cd", ""));
		setCostWk(JSPUtil.getParameter(request, prefix + "cost_wk", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setN4thRlaneCd(JSPUtil.getParameter(request, prefix + "n4th_rlane_cd", ""));
		setIocCd(JSPUtil.getParameter(request, prefix + "ioc_cd", ""));
		setKeys(JSPUtil.getParameter(request, prefix + "keys", ""));
		setN1stPodYdCd(JSPUtil.getParameter(request, prefix + "n1st_pod_yd_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setPlnAtch(JSPUtil.getParameter(request, prefix + "pln_atch", ""));
		setFileSavId(JSPUtil.getParameter(request, prefix + "file_sav_id", ""));
		setMnTsRmk(JSPUtil.getParameter(request, prefix + "mn_ts_rmk", ""));
		setN2ndPodCd(JSPUtil.getParameter(request, prefix + "n2nd_pod_cd", ""));
		setN5thSkdVoyNo(JSPUtil.getParameter(request, prefix + "n5th_skd_voy_no", ""));
		setMnUpdDt(JSPUtil.getParameter(request, prefix + "mn_upd_dt", ""));
		setN2ndVvdCd(JSPUtil.getParameter(request, prefix + "n2nd_vvd_cd", ""));
		setPhsIoRsnCd(JSPUtil.getParameter(request, prefix + "phs_io_rsn_cd", ""));
		setCntrFullFlg(JSPUtil.getParameter(request, prefix + "cntr_full_flg", ""));
		setN5thSkdDirCd(JSPUtil.getParameter(request, prefix + "n5th_skd_dir_cd", ""));
		setFilePathRmk(JSPUtil.getParameter(request, prefix + "file_path_rmk", ""));
		setSkdCngStsCd(JSPUtil.getParameter(request, prefix + "skd_cng_sts_cd", ""));
		setN4thPortEtdDt(JSPUtil.getParameter(request, prefix + "n4th_port_etd_dt", ""));
		setN3rdPortEtdDt(JSPUtil.getParameter(request, prefix + "n3rd_port_etd_dt", ""));
		setN2ndPolCd(JSPUtil.getParameter(request, prefix + "n2nd_pol_cd", ""));
		setN4thPolYdCd(JSPUtil.getParameter(request, prefix + "n4th_pol_yd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchTsPlanGuideListVO[]
	 */
	public SearchTsPlanGuideListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchTsPlanGuideListVO[]
	 */
	public SearchTsPlanGuideListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchTsPlanGuideListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] n4thSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "n4th_skd_voy_no", length));
			String[] n3rdRlaneCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_rlane_cd", length));
			String[] n5thPortEtdDt = (JSPUtil.getParameter(request, prefix	+ "n5th_port_etd_dt", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] repTrdCd = (JSPUtil.getParameter(request, prefix	+ "rep_trd_cd", length));
			String[] mnCreUsrId = (JSPUtil.getParameter(request, prefix	+ "mn_cre_usr_id", length));
			String[] repSubTrdCd = (JSPUtil.getParameter(request, prefix	+ "rep_sub_trd_cd", length));
			String[] tsRmk = (JSPUtil.getParameter(request, prefix	+ "ts_rmk", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] n2ndVslCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_vsl_cd", length));
			String[] n4thSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "n4th_skd_dir_cd", length));
			String[] n2ndPodYdCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_pod_yd_cd", length));
			String[] n2ndPortEtbDt = (JSPUtil.getParameter(request, prefix	+ "n2nd_port_etb_dt", length));
			String[] n4thVvdCd = (JSPUtil.getParameter(request, prefix	+ "n4th_vvd_cd", length));
			String[] n5thRlaneCd = (JSPUtil.getParameter(request, prefix	+ "n5th_rlane_cd", length));
			String[] n1stRlaneCd = (JSPUtil.getParameter(request, prefix	+ "n1st_rlane_cd", length));
			String[] irrPortCd = (JSPUtil.getParameter(request, prefix	+ "irr_port_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] skdCngRsnCd = (JSPUtil.getParameter(request, prefix	+ "skd_cng_rsn_cd", length));
			String[] mnCreDt = (JSPUtil.getParameter(request, prefix	+ "mn_cre_dt", length));
			String[] n3rdPodCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_pod_cd", length));
			String[] mltPolListCtnt = (JSPUtil.getParameter(request, prefix	+ "mlt_pol_list_ctnt", length));
			String[] fileSeq = (JSPUtil.getParameter(request, prefix	+ "file_seq", length));
			String[] n2ndRlaneCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_rlane_cd", length));
			String[] plnSeq = (JSPUtil.getParameter(request, prefix	+ "pln_seq", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] fileNm = (JSPUtil.getParameter(request, prefix	+ "file_nm", length));
			String[] mnUpdUsrId = (JSPUtil.getParameter(request, prefix	+ "mn_upd_usr_id", length));
			String[] n4thVslCd = (JSPUtil.getParameter(request, prefix	+ "n4th_vsl_cd", length));
			String[] n5thVslCd = (JSPUtil.getParameter(request, prefix	+ "n5th_vsl_cd", length));
			String[] portSkpRsnCd = (JSPUtil.getParameter(request, prefix	+ "port_skp_rsn_cd", length));
			String[] n3rdPolCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_pol_cd", length));
			String[] mltPodListCtnt = (JSPUtil.getParameter(request, prefix	+ "mlt_pod_list_ctnt", length));
			String[] n4thPodYdCd = (JSPUtil.getParameter(request, prefix	+ "n4th_pod_yd_cd", length));
			String[] n2ndSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_skd_dir_cd", length));
			String[] n3rdPodYdCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_pod_yd_cd", length));
			String[] n5thVvdCd = (JSPUtil.getParameter(request, prefix	+ "n5th_vvd_cd", length));
			String[] usrRmk = (JSPUtil.getParameter(request, prefix	+ "usr_rmk", length));
			String[] n2ndPolYdCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_pol_yd_cd", length));
			String[] n1stPortEtbDt = (JSPUtil.getParameter(request, prefix	+ "n1st_port_etb_dt", length));
			String[] n4thPortEtbDt = (JSPUtil.getParameter(request, prefix	+ "n4th_port_etb_dt", length));
			String[] n3rdPortEtbDt = (JSPUtil.getParameter(request, prefix	+ "n3rd_port_etb_dt", length));
			String[] n2ndSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "n2nd_skd_voy_no", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] n5thPolCd = (JSPUtil.getParameter(request, prefix	+ "n5th_pol_cd", length));
			String[] portSkpTpCd = (JSPUtil.getParameter(request, prefix	+ "port_skp_tp_cd", length));
			String[] tsPlnGidDtl = (JSPUtil.getParameter(request, prefix	+ "ts_pln_gid_dtl", length));
			String[] cntrMtyFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_mty_flg", length));
			String[] tsPlnCfmStsCd = (JSPUtil.getParameter(request, prefix	+ "ts_pln_cfm_sts_cd", length));
			String[] mltCrrListCtnt = (JSPUtil.getParameter(request, prefix	+ "mlt_crr_list_ctnt", length));
			String[] n3rdSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "n3rd_skd_voy_no", length));
			String[] n5thPortEtbDt = (JSPUtil.getParameter(request, prefix	+ "n5th_port_etb_dt", length));
			String[] n1stSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "n1st_skd_dir_cd", length));
			String[] n3rdPolYdCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_pol_yd_cd", length));
			String[] n3rdVvdCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_vvd_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] n5thPolYdCd = (JSPUtil.getParameter(request, prefix	+ "n5th_pol_yd_cd", length));
			String[] n1stPortEtdDt = (JSPUtil.getParameter(request, prefix	+ "n1st_port_etd_dt", length));
			String[] existFlg = (JSPUtil.getParameter(request, prefix	+ "exist_flg", length));
			String[] n3rdSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_skd_dir_cd", length));
			String[] n1stVslCd = (JSPUtil.getParameter(request, prefix	+ "n1st_vsl_cd", length));
			String[] n2ndPortEtdDt = (JSPUtil.getParameter(request, prefix	+ "n2nd_port_etd_dt", length));
			String[] skdCngRsnNm = (JSPUtil.getParameter(request, prefix	+ "skd_cng_rsn_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] n4thPodCd = (JSPUtil.getParameter(request, prefix	+ "n4th_pod_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] irrYdCd = (JSPUtil.getParameter(request, prefix	+ "irr_yd_cd", length));
			String[] n1stVvdCd = (JSPUtil.getParameter(request, prefix	+ "n1st_vvd_cd", length));
			String[] searchTp = (JSPUtil.getParameter(request, prefix	+ "search_tp", length));
			String[] n1stSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "n1st_skd_voy_no", length));
			String[] fileSize = (JSPUtil.getParameter(request, prefix	+ "file_size", length));
			String[] n1stPodCd = (JSPUtil.getParameter(request, prefix	+ "n1st_pod_cd", length));
			String[] n3rdVslCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_vsl_cd", length));
			String[] n4thPolCd = (JSPUtil.getParameter(request, prefix	+ "n4th_pol_cd", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] n4thRlaneCd = (JSPUtil.getParameter(request, prefix	+ "n4th_rlane_cd", length));
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] keys = (JSPUtil.getParameter(request, prefix	+ "keys", length));
			String[] n1stPodYdCd = (JSPUtil.getParameter(request, prefix	+ "n1st_pod_yd_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] plnAtch = (JSPUtil.getParameter(request, prefix	+ "pln_atch", length));
			String[] fileSavId = (JSPUtil.getParameter(request, prefix	+ "file_sav_id", length));
			String[] mnTsRmk = (JSPUtil.getParameter(request, prefix	+ "mn_ts_rmk", length));
			String[] n2ndPodCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_pod_cd", length));
			String[] n5thSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "n5th_skd_voy_no", length));
			String[] mnUpdDt = (JSPUtil.getParameter(request, prefix	+ "mn_upd_dt", length));
			String[] n2ndVvdCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_vvd_cd", length));
			String[] phsIoRsnCd = (JSPUtil.getParameter(request, prefix	+ "phs_io_rsn_cd", length));
			String[] cntrFullFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_full_flg", length));
			String[] n5thSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "n5th_skd_dir_cd", length));
			String[] filePathRmk = (JSPUtil.getParameter(request, prefix	+ "file_path_rmk", length));
			String[] skdCngStsCd = (JSPUtil.getParameter(request, prefix	+ "skd_cng_sts_cd", length));
			String[] n4thPortEtdDt = (JSPUtil.getParameter(request, prefix	+ "n4th_port_etd_dt", length));
			String[] n3rdPortEtdDt = (JSPUtil.getParameter(request, prefix	+ "n3rd_port_etd_dt", length));
			String[] n2ndPolCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_pol_cd", length));
			String[] n4thPolYdCd = (JSPUtil.getParameter(request, prefix	+ "n4th_pol_yd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchTsPlanGuideListVO();
				if (n4thSkdVoyNo[i] != null)
					model.setN4thSkdVoyNo(n4thSkdVoyNo[i]);
				if (n3rdRlaneCd[i] != null)
					model.setN3rdRlaneCd(n3rdRlaneCd[i]);
				if (n5thPortEtdDt[i] != null)
					model.setN5thPortEtdDt(n5thPortEtdDt[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (repTrdCd[i] != null)
					model.setRepTrdCd(repTrdCd[i]);
				if (mnCreUsrId[i] != null)
					model.setMnCreUsrId(mnCreUsrId[i]);
				if (repSubTrdCd[i] != null)
					model.setRepSubTrdCd(repSubTrdCd[i]);
				if (tsRmk[i] != null)
					model.setTsRmk(tsRmk[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (n2ndVslCd[i] != null)
					model.setN2ndVslCd(n2ndVslCd[i]);
				if (n4thSkdDirCd[i] != null)
					model.setN4thSkdDirCd(n4thSkdDirCd[i]);
				if (n2ndPodYdCd[i] != null)
					model.setN2ndPodYdCd(n2ndPodYdCd[i]);
				if (n2ndPortEtbDt[i] != null)
					model.setN2ndPortEtbDt(n2ndPortEtbDt[i]);
				if (n4thVvdCd[i] != null)
					model.setN4thVvdCd(n4thVvdCd[i]);
				if (n5thRlaneCd[i] != null)
					model.setN5thRlaneCd(n5thRlaneCd[i]);
				if (n1stRlaneCd[i] != null)
					model.setN1stRlaneCd(n1stRlaneCd[i]);
				if (irrPortCd[i] != null)
					model.setIrrPortCd(irrPortCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (skdCngRsnCd[i] != null)
					model.setSkdCngRsnCd(skdCngRsnCd[i]);
				if (mnCreDt[i] != null)
					model.setMnCreDt(mnCreDt[i]);
				if (n3rdPodCd[i] != null)
					model.setN3rdPodCd(n3rdPodCd[i]);
				if (mltPolListCtnt[i] != null)
					model.setMltPolListCtnt(mltPolListCtnt[i]);
				if (fileSeq[i] != null)
					model.setFileSeq(fileSeq[i]);
				if (n2ndRlaneCd[i] != null)
					model.setN2ndRlaneCd(n2ndRlaneCd[i]);
				if (plnSeq[i] != null)
					model.setPlnSeq(plnSeq[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (fileNm[i] != null)
					model.setFileNm(fileNm[i]);
				if (mnUpdUsrId[i] != null)
					model.setMnUpdUsrId(mnUpdUsrId[i]);
				if (n4thVslCd[i] != null)
					model.setN4thVslCd(n4thVslCd[i]);
				if (n5thVslCd[i] != null)
					model.setN5thVslCd(n5thVslCd[i]);
				if (portSkpRsnCd[i] != null)
					model.setPortSkpRsnCd(portSkpRsnCd[i]);
				if (n3rdPolCd[i] != null)
					model.setN3rdPolCd(n3rdPolCd[i]);
				if (mltPodListCtnt[i] != null)
					model.setMltPodListCtnt(mltPodListCtnt[i]);
				if (n4thPodYdCd[i] != null)
					model.setN4thPodYdCd(n4thPodYdCd[i]);
				if (n2ndSkdDirCd[i] != null)
					model.setN2ndSkdDirCd(n2ndSkdDirCd[i]);
				if (n3rdPodYdCd[i] != null)
					model.setN3rdPodYdCd(n3rdPodYdCd[i]);
				if (n5thVvdCd[i] != null)
					model.setN5thVvdCd(n5thVvdCd[i]);
				if (usrRmk[i] != null)
					model.setUsrRmk(usrRmk[i]);
				if (n2ndPolYdCd[i] != null)
					model.setN2ndPolYdCd(n2ndPolYdCd[i]);
				if (n1stPortEtbDt[i] != null)
					model.setN1stPortEtbDt(n1stPortEtbDt[i]);
				if (n4thPortEtbDt[i] != null)
					model.setN4thPortEtbDt(n4thPortEtbDt[i]);
				if (n3rdPortEtbDt[i] != null)
					model.setN3rdPortEtbDt(n3rdPortEtbDt[i]);
				if (n2ndSkdVoyNo[i] != null)
					model.setN2ndSkdVoyNo(n2ndSkdVoyNo[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (n5thPolCd[i] != null)
					model.setN5thPolCd(n5thPolCd[i]);
				if (portSkpTpCd[i] != null)
					model.setPortSkpTpCd(portSkpTpCd[i]);
				if (tsPlnGidDtl[i] != null)
					model.setTsPlnGidDtl(tsPlnGidDtl[i]);
				if (cntrMtyFlg[i] != null)
					model.setCntrMtyFlg(cntrMtyFlg[i]);
				if (tsPlnCfmStsCd[i] != null)
					model.setTsPlnCfmStsCd(tsPlnCfmStsCd[i]);
				if (mltCrrListCtnt[i] != null)
					model.setMltCrrListCtnt(mltCrrListCtnt[i]);
				if (n3rdSkdVoyNo[i] != null)
					model.setN3rdSkdVoyNo(n3rdSkdVoyNo[i]);
				if (n5thPortEtbDt[i] != null)
					model.setN5thPortEtbDt(n5thPortEtbDt[i]);
				if (n1stSkdDirCd[i] != null)
					model.setN1stSkdDirCd(n1stSkdDirCd[i]);
				if (n3rdPolYdCd[i] != null)
					model.setN3rdPolYdCd(n3rdPolYdCd[i]);
				if (n3rdVvdCd[i] != null)
					model.setN3rdVvdCd(n3rdVvdCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (n5thPolYdCd[i] != null)
					model.setN5thPolYdCd(n5thPolYdCd[i]);
				if (n1stPortEtdDt[i] != null)
					model.setN1stPortEtdDt(n1stPortEtdDt[i]);
				if (existFlg[i] != null)
					model.setExistFlg(existFlg[i]);
				if (n3rdSkdDirCd[i] != null)
					model.setN3rdSkdDirCd(n3rdSkdDirCd[i]);
				if (n1stVslCd[i] != null)
					model.setN1stVslCd(n1stVslCd[i]);
				if (n2ndPortEtdDt[i] != null)
					model.setN2ndPortEtdDt(n2ndPortEtdDt[i]);
				if (skdCngRsnNm[i] != null)
					model.setSkdCngRsnNm(skdCngRsnNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (n4thPodCd[i] != null)
					model.setN4thPodCd(n4thPodCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (irrYdCd[i] != null)
					model.setIrrYdCd(irrYdCd[i]);
				if (n1stVvdCd[i] != null)
					model.setN1stVvdCd(n1stVvdCd[i]);
				if (searchTp[i] != null)
					model.setSearchTp(searchTp[i]);
				if (n1stSkdVoyNo[i] != null)
					model.setN1stSkdVoyNo(n1stSkdVoyNo[i]);
				if (fileSize[i] != null)
					model.setFileSize(fileSize[i]);
				if (n1stPodCd[i] != null)
					model.setN1stPodCd(n1stPodCd[i]);
				if (n3rdVslCd[i] != null)
					model.setN3rdVslCd(n3rdVslCd[i]);
				if (n4thPolCd[i] != null)
					model.setN4thPolCd(n4thPolCd[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (n4thRlaneCd[i] != null)
					model.setN4thRlaneCd(n4thRlaneCd[i]);
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (keys[i] != null)
					model.setKeys(keys[i]);
				if (n1stPodYdCd[i] != null)
					model.setN1stPodYdCd(n1stPodYdCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (plnAtch[i] != null)
					model.setPlnAtch(plnAtch[i]);
				if (fileSavId[i] != null)
					model.setFileSavId(fileSavId[i]);
				if (mnTsRmk[i] != null)
					model.setMnTsRmk(mnTsRmk[i]);
				if (n2ndPodCd[i] != null)
					model.setN2ndPodCd(n2ndPodCd[i]);
				if (n5thSkdVoyNo[i] != null)
					model.setN5thSkdVoyNo(n5thSkdVoyNo[i]);
				if (mnUpdDt[i] != null)
					model.setMnUpdDt(mnUpdDt[i]);
				if (n2ndVvdCd[i] != null)
					model.setN2ndVvdCd(n2ndVvdCd[i]);
				if (phsIoRsnCd[i] != null)
					model.setPhsIoRsnCd(phsIoRsnCd[i]);
				if (cntrFullFlg[i] != null)
					model.setCntrFullFlg(cntrFullFlg[i]);
				if (n5thSkdDirCd[i] != null)
					model.setN5thSkdDirCd(n5thSkdDirCd[i]);
				if (filePathRmk[i] != null)
					model.setFilePathRmk(filePathRmk[i]);
				if (skdCngStsCd[i] != null)
					model.setSkdCngStsCd(skdCngStsCd[i]);
				if (n4thPortEtdDt[i] != null)
					model.setN4thPortEtdDt(n4thPortEtdDt[i]);
				if (n3rdPortEtdDt[i] != null)
					model.setN3rdPortEtdDt(n3rdPortEtdDt[i]);
				if (n2ndPolCd[i] != null)
					model.setN2ndPolCd(n2ndPolCd[i]);
				if (n4thPolYdCd[i] != null)
					model.setN4thPolYdCd(n4thPolYdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchTsPlanGuideListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchTsPlanGuideListVO[]
	 */
	public SearchTsPlanGuideListVO[] getSearchTsPlanGuideListVOs(){
		SearchTsPlanGuideListVO[] vos = (SearchTsPlanGuideListVO[])models.toArray(new SearchTsPlanGuideListVO[models.size()]);
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
		this.n4thSkdVoyNo = this.n4thSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdRlaneCd = this.n3rdRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n5thPortEtdDt = this.n5thPortEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repTrdCd = this.repTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnCreUsrId = this.mnCreUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repSubTrdCd = this.repSubTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsRmk = this.tsRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndVslCd = this.n2ndVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thSkdDirCd = this.n4thSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndPodYdCd = this.n2ndPodYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndPortEtbDt = this.n2ndPortEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thVvdCd = this.n4thVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n5thRlaneCd = this.n5thRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stRlaneCd = this.n1stRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.irrPortCd = this.irrPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdCngRsnCd = this.skdCngRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnCreDt = this.mnCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdPodCd = this.n3rdPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mltPolListCtnt = this.mltPolListCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSeq = this.fileSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndRlaneCd = this.n2ndRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnSeq = this.plnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileNm = this.fileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnUpdUsrId = this.mnUpdUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thVslCd = this.n4thVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n5thVslCd = this.n5thVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portSkpRsnCd = this.portSkpRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdPolCd = this.n3rdPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mltPodListCtnt = this.mltPodListCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thPodYdCd = this.n4thPodYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndSkdDirCd = this.n2ndSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdPodYdCd = this.n3rdPodYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n5thVvdCd = this.n5thVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrRmk = this.usrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndPolYdCd = this.n2ndPolYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPortEtbDt = this.n1stPortEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thPortEtbDt = this.n4thPortEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdPortEtbDt = this.n3rdPortEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndSkdVoyNo = this.n2ndSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n5thPolCd = this.n5thPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portSkpTpCd = this.portSkpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsPlnGidDtl = this.tsPlnGidDtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMtyFlg = this.cntrMtyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsPlnCfmStsCd = this.tsPlnCfmStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mltCrrListCtnt = this.mltCrrListCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdSkdVoyNo = this.n3rdSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n5thPortEtbDt = this.n5thPortEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stSkdDirCd = this.n1stSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdPolYdCd = this.n3rdPolYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdVvdCd = this.n3rdVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n5thPolYdCd = this.n5thPolYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPortEtdDt = this.n1stPortEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.existFlg = this.existFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdSkdDirCd = this.n3rdSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stVslCd = this.n1stVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndPortEtdDt = this.n2ndPortEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdCngRsnNm = this.skdCngRsnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thPodCd = this.n4thPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.irrYdCd = this.irrYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stVvdCd = this.n1stVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchTp = this.searchTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stSkdVoyNo = this.n1stSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSize = this.fileSize .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPodCd = this.n1stPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdVslCd = this.n3rdVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thPolCd = this.n4thPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thRlaneCd = this.n4thRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keys = this.keys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPodYdCd = this.n1stPodYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnAtch = this.plnAtch .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSavId = this.fileSavId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnTsRmk = this.mnTsRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndPodCd = this.n2ndPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n5thSkdVoyNo = this.n5thSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnUpdDt = this.mnUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndVvdCd = this.n2ndVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phsIoRsnCd = this.phsIoRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrFullFlg = this.cntrFullFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n5thSkdDirCd = this.n5thSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.filePathRmk = this.filePathRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdCngStsCd = this.skdCngStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thPortEtdDt = this.n4thPortEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdPortEtdDt = this.n3rdPortEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndPolCd = this.n2ndPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thPolYdCd = this.n4thPolYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

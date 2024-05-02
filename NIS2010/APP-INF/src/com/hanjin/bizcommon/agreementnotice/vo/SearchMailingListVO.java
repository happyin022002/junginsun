/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SearchMailingListVO.java
*@FileTitle : SearchMailingListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.10
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.10  
* 1.0 Creation
=========================================================*/

package com.hanjin.bizcommon.agreementnotice.vo;

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

public class SearchMailingListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMailingListVO> models = new ArrayList<SearchMailingListVO>();
	
	/* Column Info */
	private String ntcN6thUsrIdJbCdFlg = null;
	/* Column Info */
	private String ntcN2ndUsrIdJbCd = null;
	/* Column Info */
	private String ntcUsrId2Nm = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String ntcUsrId6Nm = null;
	/* Column Info */
	private String ofcTpCd = null;
	/* Column Info */
	private String ntcN2ndUsrIdJbCdFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ntcUsrId7Nm = null;
	/* Column Info */
	private String rootPgmNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ntcN1stUsrIdJbCdFlg = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String ntcUsrId5Nm = null;
	/* Column Info */
	private String ntcUsrIdListCtnt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String ntcN7thUsrIdJbCdFlg = null;
	/* Column Info */
	private String ntcN5thUsrIdJbCdFlg = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String ntcUsrId4Nm = null;
	/* Column Info */
	private String ntcN6thUsrIdJbCd = null;
	/* Column Info */
	private String ntcUsrId3Nm = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String ntcN5thUsrIdJbCd = null;
	/* Column Info */
	private String ntcN4thUsrIdJbCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String usrMaxKnt = null;
	/* Column Info */
	private String ntcUsrIdJbCdListCtnt = null;
	/* Column Info */
	private String ntcUsrId2 = null;
	/* Column Info */
	private String sysCd = null;
	/* Column Info */
	private String ntcUsrId3 = null;
	/* Column Info */
	private String agmtMapgNo = null;
	/* Column Info */
	private String ntcN3rdUsrIdJbCdFlg = null;
	/* Column Info */
	private String ntcUsrId4 = null;
	/* Column Info */
	private String ntcN4thUsrIdJbCdFlg = null;
	/* Column Info */
	private String ntcUsrId5 = null;
	/* Column Info */
	private String ntcN7thUsrIdJbCd = null;
	/* Column Info */
	private String ntcUsrId1Nm = null;
	/* Column Info */
	private String ntcUsrId6 = null;
	/* Column Info */
	private String ntcN3rdUsrIdJbCd = null;
	/* Column Info */
	private String ntcUsrId7 = null;
	/* Column Info */
	private String ntcN1stUsrIdJbCd = null;
	/* Column Info */
	private String ctrtCreUsrCount = null;
	/* Column Info */
	private String ntcUsrId1 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchMailingListVO() {}

	public SearchMailingListVO(String ibflag, String pagerows, String ntcUsrId2Nm, String creDt, String ofcTpCd, String ntcUsrId6Nm, String ntcUsrId7Nm, String rootPgmNo, String ctrtOfcCd, String ntcUsrId5Nm, String updUsrId, String updDt, String ntcUsrId4Nm, String ntcUsrId3Nm, String agmtNo, String creUsrId, String ntcUsrId2, String sysCd, String ntcUsrId3, String agmtMapgNo, String ntcUsrId4, String ntcUsrId5, String ntcUsrId1Nm, String ntcUsrId6, String ntcUsrId7, String ntcUsrId1, String ctrtCreUsrCount, String ntcN1stUsrIdJbCd, String ntcN2ndUsrIdJbCd, String ntcN3rdUsrIdJbCd, String ntcN4thUsrIdJbCd, String ntcN5thUsrIdJbCd, String ntcN6thUsrIdJbCd, String ntcN7thUsrIdJbCd, String ntcN1stUsrIdJbCdFlg, String ntcN2ndUsrIdJbCdFlg, String ntcN3rdUsrIdJbCdFlg, String ntcN4thUsrIdJbCdFlg, String ntcN5thUsrIdJbCdFlg, String ntcN6thUsrIdJbCdFlg, String ntcN7thUsrIdJbCdFlg, String ntcUsrIdListCtnt, String ntcUsrIdJbCdListCtnt, String usrMaxKnt) {
		this.ntcN6thUsrIdJbCdFlg = ntcN6thUsrIdJbCdFlg;
		this.ntcN2ndUsrIdJbCd = ntcN2ndUsrIdJbCd;
		this.ntcUsrId2Nm = ntcUsrId2Nm;
		this.creDt = creDt;
		this.ntcUsrId6Nm = ntcUsrId6Nm;
		this.ofcTpCd = ofcTpCd;
		this.ntcN2ndUsrIdJbCdFlg = ntcN2ndUsrIdJbCdFlg;
		this.pagerows = pagerows;
		this.ntcUsrId7Nm = ntcUsrId7Nm;
		this.rootPgmNo = rootPgmNo;
		this.ibflag = ibflag;
		this.ntcN1stUsrIdJbCdFlg = ntcN1stUsrIdJbCdFlg;
		this.ctrtOfcCd = ctrtOfcCd;
		this.ntcUsrId5Nm = ntcUsrId5Nm;
		this.ntcUsrIdListCtnt = ntcUsrIdListCtnt;
		this.updUsrId = updUsrId;
		this.ntcN7thUsrIdJbCdFlg = ntcN7thUsrIdJbCdFlg;
		this.ntcN5thUsrIdJbCdFlg = ntcN5thUsrIdJbCdFlg;
		this.updDt = updDt;
		this.ntcUsrId4Nm = ntcUsrId4Nm;
		this.ntcN6thUsrIdJbCd = ntcN6thUsrIdJbCd;
		this.ntcUsrId3Nm = ntcUsrId3Nm;
		this.agmtNo = agmtNo;
		this.ntcN5thUsrIdJbCd = ntcN5thUsrIdJbCd;
		this.ntcN4thUsrIdJbCd = ntcN4thUsrIdJbCd;
		this.creUsrId = creUsrId;
		this.usrMaxKnt = usrMaxKnt;
		this.ntcUsrIdJbCdListCtnt = ntcUsrIdJbCdListCtnt;
		this.ntcUsrId2 = ntcUsrId2;
		this.sysCd = sysCd;
		this.ntcUsrId3 = ntcUsrId3;
		this.agmtMapgNo = agmtMapgNo;
		this.ntcN3rdUsrIdJbCdFlg = ntcN3rdUsrIdJbCdFlg;
		this.ntcUsrId4 = ntcUsrId4;
		this.ntcN4thUsrIdJbCdFlg = ntcN4thUsrIdJbCdFlg;
		this.ntcUsrId5 = ntcUsrId5;
		this.ntcN7thUsrIdJbCd = ntcN7thUsrIdJbCd;
		this.ntcUsrId1Nm = ntcUsrId1Nm;
		this.ntcUsrId6 = ntcUsrId6;
		this.ntcN3rdUsrIdJbCd = ntcN3rdUsrIdJbCd;
		this.ntcUsrId7 = ntcUsrId7;
		this.ntcN1stUsrIdJbCd = ntcN1stUsrIdJbCd;
		this.ctrtCreUsrCount = ctrtCreUsrCount;
		this.ntcUsrId1 = ntcUsrId1;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ntc_n6th_usr_id_jb_cd_flg", getNtcN6thUsrIdJbCdFlg());
		this.hashColumns.put("ntc_n2nd_usr_id_jb_cd", getNtcN2ndUsrIdJbCd());
		this.hashColumns.put("ntc_usr_id2_nm", getNtcUsrId2Nm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("ntc_usr_id6_nm", getNtcUsrId6Nm());
		this.hashColumns.put("ofc_tp_cd", getOfcTpCd());
		this.hashColumns.put("ntc_n2nd_usr_id_jb_cd_flg", getNtcN2ndUsrIdJbCdFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ntc_usr_id7_nm", getNtcUsrId7Nm());
		this.hashColumns.put("root_pgm_no", getRootPgmNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ntc_n1st_usr_id_jb_cd_flg", getNtcN1stUsrIdJbCdFlg());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("ntc_usr_id5_nm", getNtcUsrId5Nm());
		this.hashColumns.put("ntc_usr_id_list_ctnt", getNtcUsrIdListCtnt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("ntc_n7th_usr_id_jb_cd_flg", getNtcN7thUsrIdJbCdFlg());
		this.hashColumns.put("ntc_n5th_usr_id_jb_cd_flg", getNtcN5thUsrIdJbCdFlg());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ntc_usr_id4_nm", getNtcUsrId4Nm());
		this.hashColumns.put("ntc_n6th_usr_id_jb_cd", getNtcN6thUsrIdJbCd());
		this.hashColumns.put("ntc_usr_id3_nm", getNtcUsrId3Nm());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("ntc_n5th_usr_id_jb_cd", getNtcN5thUsrIdJbCd());
		this.hashColumns.put("ntc_n4th_usr_id_jb_cd", getNtcN4thUsrIdJbCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("usr_max_knt", getUsrMaxKnt());
		this.hashColumns.put("ntc_usr_id_jb_cd_list_ctnt", getNtcUsrIdJbCdListCtnt());
		this.hashColumns.put("ntc_usr_id2", getNtcUsrId2());
		this.hashColumns.put("sys_cd", getSysCd());
		this.hashColumns.put("ntc_usr_id3", getNtcUsrId3());
		this.hashColumns.put("agmt_mapg_no", getAgmtMapgNo());
		this.hashColumns.put("ntc_n3rd_usr_id_jb_cd_flg", getNtcN3rdUsrIdJbCdFlg());
		this.hashColumns.put("ntc_usr_id4", getNtcUsrId4());
		this.hashColumns.put("ntc_n4th_usr_id_jb_cd_flg", getNtcN4thUsrIdJbCdFlg());
		this.hashColumns.put("ntc_usr_id5", getNtcUsrId5());
		this.hashColumns.put("ntc_n7th_usr_id_jb_cd", getNtcN7thUsrIdJbCd());
		this.hashColumns.put("ntc_usr_id1_nm", getNtcUsrId1Nm());
		this.hashColumns.put("ntc_usr_id6", getNtcUsrId6());
		this.hashColumns.put("ntc_n3rd_usr_id_jb_cd", getNtcN3rdUsrIdJbCd());
		this.hashColumns.put("ntc_usr_id7", getNtcUsrId7());
		this.hashColumns.put("ntc_n1st_usr_id_jb_cd", getNtcN1stUsrIdJbCd());
		this.hashColumns.put("ctrt_cre_usr_count", getCtrtCreUsrCount());
		this.hashColumns.put("ntc_usr_id1", getNtcUsrId1());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ntc_n6th_usr_id_jb_cd_flg", "ntcN6thUsrIdJbCdFlg");
		this.hashFields.put("ntc_n2nd_usr_id_jb_cd", "ntcN2ndUsrIdJbCd");
		this.hashFields.put("ntc_usr_id2_nm", "ntcUsrId2Nm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("ntc_usr_id6_nm", "ntcUsrId6Nm");
		this.hashFields.put("ofc_tp_cd", "ofcTpCd");
		this.hashFields.put("ntc_n2nd_usr_id_jb_cd_flg", "ntcN2ndUsrIdJbCdFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ntc_usr_id7_nm", "ntcUsrId7Nm");
		this.hashFields.put("root_pgm_no", "rootPgmNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ntc_n1st_usr_id_jb_cd_flg", "ntcN1stUsrIdJbCdFlg");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("ntc_usr_id5_nm", "ntcUsrId5Nm");
		this.hashFields.put("ntc_usr_id_list_ctnt", "ntcUsrIdListCtnt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("ntc_n7th_usr_id_jb_cd_flg", "ntcN7thUsrIdJbCdFlg");
		this.hashFields.put("ntc_n5th_usr_id_jb_cd_flg", "ntcN5thUsrIdJbCdFlg");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ntc_usr_id4_nm", "ntcUsrId4Nm");
		this.hashFields.put("ntc_n6th_usr_id_jb_cd", "ntcN6thUsrIdJbCd");
		this.hashFields.put("ntc_usr_id3_nm", "ntcUsrId3Nm");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("ntc_n5th_usr_id_jb_cd", "ntcN5thUsrIdJbCd");
		this.hashFields.put("ntc_n4th_usr_id_jb_cd", "ntcN4thUsrIdJbCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("usr_max_knt", "usrMaxKnt");
		this.hashFields.put("ntc_usr_id_jb_cd_list_ctnt", "ntcUsrIdJbCdListCtnt");
		this.hashFields.put("ntc_usr_id2", "ntcUsrId2");
		this.hashFields.put("sys_cd", "sysCd");
		this.hashFields.put("ntc_usr_id3", "ntcUsrId3");
		this.hashFields.put("agmt_mapg_no", "agmtMapgNo");
		this.hashFields.put("ntc_n3rd_usr_id_jb_cd_flg", "ntcN3rdUsrIdJbCdFlg");
		this.hashFields.put("ntc_usr_id4", "ntcUsrId4");
		this.hashFields.put("ntc_n4th_usr_id_jb_cd_flg", "ntcN4thUsrIdJbCdFlg");
		this.hashFields.put("ntc_usr_id5", "ntcUsrId5");
		this.hashFields.put("ntc_n7th_usr_id_jb_cd", "ntcN7thUsrIdJbCd");
		this.hashFields.put("ntc_usr_id1_nm", "ntcUsrId1Nm");
		this.hashFields.put("ntc_usr_id6", "ntcUsrId6");
		this.hashFields.put("ntc_n3rd_usr_id_jb_cd", "ntcN3rdUsrIdJbCd");
		this.hashFields.put("ntc_usr_id7", "ntcUsrId7");
		this.hashFields.put("ntc_n1st_usr_id_jb_cd", "ntcN1stUsrIdJbCd");
		this.hashFields.put("ctrt_cre_usr_count", "ctrtCreUsrCount");
		this.hashFields.put("ntc_usr_id1", "ntcUsrId1");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ntcN6thUsrIdJbCdFlg
	 */
	public String getNtcN6thUsrIdJbCdFlg() {
		return this.ntcN6thUsrIdJbCdFlg;
	}
	
	/**
	 * Column Info
	 * @return ntcN2ndUsrIdJbCd
	 */
	public String getNtcN2ndUsrIdJbCd() {
		return this.ntcN2ndUsrIdJbCd;
	}
	
	/**
	 * Column Info
	 * @return ntcUsrId2Nm
	 */
	public String getNtcUsrId2Nm() {
		return this.ntcUsrId2Nm;
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
	 * @return ntcUsrId6Nm
	 */
	public String getNtcUsrId6Nm() {
		return this.ntcUsrId6Nm;
	}
	
	/**
	 * Column Info
	 * @return ofcTpCd
	 */
	public String getOfcTpCd() {
		return this.ofcTpCd;
	}
	
	/**
	 * Column Info
	 * @return ntcN2ndUsrIdJbCdFlg
	 */
	public String getNtcN2ndUsrIdJbCdFlg() {
		return this.ntcN2ndUsrIdJbCdFlg;
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
	 * @return ntcUsrId7Nm
	 */
	public String getNtcUsrId7Nm() {
		return this.ntcUsrId7Nm;
	}
	
	/**
	 * Column Info
	 * @return rootPgmNo
	 */
	public String getRootPgmNo() {
		return this.rootPgmNo;
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
	 * @return ntcN1stUsrIdJbCdFlg
	 */
	public String getNtcN1stUsrIdJbCdFlg() {
		return this.ntcN1stUsrIdJbCdFlg;
	}
	
	/**
	 * Column Info
	 * @return ctrtOfcCd
	 */
	public String getCtrtOfcCd() {
		return this.ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ntcUsrId5Nm
	 */
	public String getNtcUsrId5Nm() {
		return this.ntcUsrId5Nm;
	}
	
	/**
	 * Column Info
	 * @return ntcUsrIdListCtnt
	 */
	public String getNtcUsrIdListCtnt() {
		return this.ntcUsrIdListCtnt;
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
	 * @return ntcN7thUsrIdJbCdFlg
	 */
	public String getNtcN7thUsrIdJbCdFlg() {
		return this.ntcN7thUsrIdJbCdFlg;
	}
	
	/**
	 * Column Info
	 * @return ntcN5thUsrIdJbCdFlg
	 */
	public String getNtcN5thUsrIdJbCdFlg() {
		return this.ntcN5thUsrIdJbCdFlg;
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
	 * @return ntcUsrId4Nm
	 */
	public String getNtcUsrId4Nm() {
		return this.ntcUsrId4Nm;
	}
	
	/**
	 * Column Info
	 * @return ntcN6thUsrIdJbCd
	 */
	public String getNtcN6thUsrIdJbCd() {
		return this.ntcN6thUsrIdJbCd;
	}
	
	/**
	 * Column Info
	 * @return ntcUsrId3Nm
	 */
	public String getNtcUsrId3Nm() {
		return this.ntcUsrId3Nm;
	}
	
	/**
	 * Column Info
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
	}
	
	/**
	 * Column Info
	 * @return ntcN5thUsrIdJbCd
	 */
	public String getNtcN5thUsrIdJbCd() {
		return this.ntcN5thUsrIdJbCd;
	}
	
	/**
	 * Column Info
	 * @return ntcN4thUsrIdJbCd
	 */
	public String getNtcN4thUsrIdJbCd() {
		return this.ntcN4thUsrIdJbCd;
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
	 * @return usrMaxKnt
	 */
	public String getUsrMaxKnt() {
		return this.usrMaxKnt;
	}
	
	/**
	 * Column Info
	 * @return ntcUsrIdJbCdListCtnt
	 */
	public String getNtcUsrIdJbCdListCtnt() {
		return this.ntcUsrIdJbCdListCtnt;
	}
	
	/**
	 * Column Info
	 * @return ntcUsrId2
	 */
	public String getNtcUsrId2() {
		return this.ntcUsrId2;
	}
	
	/**
	 * Column Info
	 * @return sysCd
	 */
	public String getSysCd() {
		return this.sysCd;
	}
	
	/**
	 * Column Info
	 * @return ntcUsrId3
	 */
	public String getNtcUsrId3() {
		return this.ntcUsrId3;
	}
	
	/**
	 * Column Info
	 * @return agmtMapgNo
	 */
	public String getAgmtMapgNo() {
		return this.agmtMapgNo;
	}
	
	/**
	 * Column Info
	 * @return ntcN3rdUsrIdJbCdFlg
	 */
	public String getNtcN3rdUsrIdJbCdFlg() {
		return this.ntcN3rdUsrIdJbCdFlg;
	}
	
	/**
	 * Column Info
	 * @return ntcUsrId4
	 */
	public String getNtcUsrId4() {
		return this.ntcUsrId4;
	}
	
	/**
	 * Column Info
	 * @return ntcN4thUsrIdJbCdFlg
	 */
	public String getNtcN4thUsrIdJbCdFlg() {
		return this.ntcN4thUsrIdJbCdFlg;
	}
	
	/**
	 * Column Info
	 * @return ntcUsrId5
	 */
	public String getNtcUsrId5() {
		return this.ntcUsrId5;
	}
	
	/**
	 * Column Info
	 * @return ntcN7thUsrIdJbCd
	 */
	public String getNtcN7thUsrIdJbCd() {
		return this.ntcN7thUsrIdJbCd;
	}
	
	/**
	 * Column Info
	 * @return ntcUsrId1Nm
	 */
	public String getNtcUsrId1Nm() {
		return this.ntcUsrId1Nm;
	}
	
	/**
	 * Column Info
	 * @return ntcUsrId6
	 */
	public String getNtcUsrId6() {
		return this.ntcUsrId6;
	}
	
	/**
	 * Column Info
	 * @return ntcN3rdUsrIdJbCd
	 */
	public String getNtcN3rdUsrIdJbCd() {
		return this.ntcN3rdUsrIdJbCd;
	}
	
	/**
	 * Column Info
	 * @return ntcUsrId7
	 */
	public String getNtcUsrId7() {
		return this.ntcUsrId7;
	}
	
	/**
	 * Column Info
	 * @return ntcN1stUsrIdJbCd
	 */
	public String getNtcN1stUsrIdJbCd() {
		return this.ntcN1stUsrIdJbCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtCreUsrCount
	 */
	public String getCtrtCreUsrCount() {
		return this.ctrtCreUsrCount;
	}
	
	/**
	 * Column Info
	 * @return ntcUsrId1
	 */
	public String getNtcUsrId1() {
		return this.ntcUsrId1;
	}
	

	/**
	 * Column Info
	 * @param ntcN6thUsrIdJbCdFlg
	 */
	public void setNtcN6thUsrIdJbCdFlg(String ntcN6thUsrIdJbCdFlg) {
		this.ntcN6thUsrIdJbCdFlg = ntcN6thUsrIdJbCdFlg;
	}
	
	/**
	 * Column Info
	 * @param ntcN2ndUsrIdJbCd
	 */
	public void setNtcN2ndUsrIdJbCd(String ntcN2ndUsrIdJbCd) {
		this.ntcN2ndUsrIdJbCd = ntcN2ndUsrIdJbCd;
	}
	
	/**
	 * Column Info
	 * @param ntcUsrId2Nm
	 */
	public void setNtcUsrId2Nm(String ntcUsrId2Nm) {
		this.ntcUsrId2Nm = ntcUsrId2Nm;
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
	 * @param ntcUsrId6Nm
	 */
	public void setNtcUsrId6Nm(String ntcUsrId6Nm) {
		this.ntcUsrId6Nm = ntcUsrId6Nm;
	}
	
	/**
	 * Column Info
	 * @param ofcTpCd
	 */
	public void setOfcTpCd(String ofcTpCd) {
		this.ofcTpCd = ofcTpCd;
	}
	
	/**
	 * Column Info
	 * @param ntcN2ndUsrIdJbCdFlg
	 */
	public void setNtcN2ndUsrIdJbCdFlg(String ntcN2ndUsrIdJbCdFlg) {
		this.ntcN2ndUsrIdJbCdFlg = ntcN2ndUsrIdJbCdFlg;
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
	 * @param ntcUsrId7Nm
	 */
	public void setNtcUsrId7Nm(String ntcUsrId7Nm) {
		this.ntcUsrId7Nm = ntcUsrId7Nm;
	}
	
	/**
	 * Column Info
	 * @param rootPgmNo
	 */
	public void setRootPgmNo(String rootPgmNo) {
		this.rootPgmNo = rootPgmNo;
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
	 * @param ntcN1stUsrIdJbCdFlg
	 */
	public void setNtcN1stUsrIdJbCdFlg(String ntcN1stUsrIdJbCdFlg) {
		this.ntcN1stUsrIdJbCdFlg = ntcN1stUsrIdJbCdFlg;
	}
	
	/**
	 * Column Info
	 * @param ctrtOfcCd
	 */
	public void setCtrtOfcCd(String ctrtOfcCd) {
		this.ctrtOfcCd = ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ntcUsrId5Nm
	 */
	public void setNtcUsrId5Nm(String ntcUsrId5Nm) {
		this.ntcUsrId5Nm = ntcUsrId5Nm;
	}
	
	/**
	 * Column Info
	 * @param ntcUsrIdListCtnt
	 */
	public void setNtcUsrIdListCtnt(String ntcUsrIdListCtnt) {
		this.ntcUsrIdListCtnt = ntcUsrIdListCtnt;
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
	 * @param ntcN7thUsrIdJbCdFlg
	 */
	public void setNtcN7thUsrIdJbCdFlg(String ntcN7thUsrIdJbCdFlg) {
		this.ntcN7thUsrIdJbCdFlg = ntcN7thUsrIdJbCdFlg;
	}
	
	/**
	 * Column Info
	 * @param ntcN5thUsrIdJbCdFlg
	 */
	public void setNtcN5thUsrIdJbCdFlg(String ntcN5thUsrIdJbCdFlg) {
		this.ntcN5thUsrIdJbCdFlg = ntcN5thUsrIdJbCdFlg;
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
	 * @param ntcUsrId4Nm
	 */
	public void setNtcUsrId4Nm(String ntcUsrId4Nm) {
		this.ntcUsrId4Nm = ntcUsrId4Nm;
	}
	
	/**
	 * Column Info
	 * @param ntcN6thUsrIdJbCd
	 */
	public void setNtcN6thUsrIdJbCd(String ntcN6thUsrIdJbCd) {
		this.ntcN6thUsrIdJbCd = ntcN6thUsrIdJbCd;
	}
	
	/**
	 * Column Info
	 * @param ntcUsrId3Nm
	 */
	public void setNtcUsrId3Nm(String ntcUsrId3Nm) {
		this.ntcUsrId3Nm = ntcUsrId3Nm;
	}
	
	/**
	 * Column Info
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}
	
	/**
	 * Column Info
	 * @param ntcN5thUsrIdJbCd
	 */
	public void setNtcN5thUsrIdJbCd(String ntcN5thUsrIdJbCd) {
		this.ntcN5thUsrIdJbCd = ntcN5thUsrIdJbCd;
	}
	
	/**
	 * Column Info
	 * @param ntcN4thUsrIdJbCd
	 */
	public void setNtcN4thUsrIdJbCd(String ntcN4thUsrIdJbCd) {
		this.ntcN4thUsrIdJbCd = ntcN4thUsrIdJbCd;
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
	 * @param usrMaxKnt
	 */
	public void setUsrMaxKnt(String usrMaxKnt) {
		this.usrMaxKnt = usrMaxKnt;
	}
	
	/**
	 * Column Info
	 * @param ntcUsrIdJbCdListCtnt
	 */
	public void setNtcUsrIdJbCdListCtnt(String ntcUsrIdJbCdListCtnt) {
		this.ntcUsrIdJbCdListCtnt = ntcUsrIdJbCdListCtnt;
	}
	
	/**
	 * Column Info
	 * @param ntcUsrId2
	 */
	public void setNtcUsrId2(String ntcUsrId2) {
		this.ntcUsrId2 = ntcUsrId2;
	}
	
	/**
	 * Column Info
	 * @param sysCd
	 */
	public void setSysCd(String sysCd) {
		this.sysCd = sysCd;
	}
	
	/**
	 * Column Info
	 * @param ntcUsrId3
	 */
	public void setNtcUsrId3(String ntcUsrId3) {
		this.ntcUsrId3 = ntcUsrId3;
	}
	
	/**
	 * Column Info
	 * @param agmtMapgNo
	 */
	public void setAgmtMapgNo(String agmtMapgNo) {
		this.agmtMapgNo = agmtMapgNo;
	}
	
	/**
	 * Column Info
	 * @param ntcN3rdUsrIdJbCdFlg
	 */
	public void setNtcN3rdUsrIdJbCdFlg(String ntcN3rdUsrIdJbCdFlg) {
		this.ntcN3rdUsrIdJbCdFlg = ntcN3rdUsrIdJbCdFlg;
	}
	
	/**
	 * Column Info
	 * @param ntcUsrId4
	 */
	public void setNtcUsrId4(String ntcUsrId4) {
		this.ntcUsrId4 = ntcUsrId4;
	}
	
	/**
	 * Column Info
	 * @param ntcN4thUsrIdJbCdFlg
	 */
	public void setNtcN4thUsrIdJbCdFlg(String ntcN4thUsrIdJbCdFlg) {
		this.ntcN4thUsrIdJbCdFlg = ntcN4thUsrIdJbCdFlg;
	}
	
	/**
	 * Column Info
	 * @param ntcUsrId5
	 */
	public void setNtcUsrId5(String ntcUsrId5) {
		this.ntcUsrId5 = ntcUsrId5;
	}
	
	/**
	 * Column Info
	 * @param ntcN7thUsrIdJbCd
	 */
	public void setNtcN7thUsrIdJbCd(String ntcN7thUsrIdJbCd) {
		this.ntcN7thUsrIdJbCd = ntcN7thUsrIdJbCd;
	}
	
	/**
	 * Column Info
	 * @param ntcUsrId1Nm
	 */
	public void setNtcUsrId1Nm(String ntcUsrId1Nm) {
		this.ntcUsrId1Nm = ntcUsrId1Nm;
	}
	
	/**
	 * Column Info
	 * @param ntcUsrId6
	 */
	public void setNtcUsrId6(String ntcUsrId6) {
		this.ntcUsrId6 = ntcUsrId6;
	}
	
	/**
	 * Column Info
	 * @param ntcN3rdUsrIdJbCd
	 */
	public void setNtcN3rdUsrIdJbCd(String ntcN3rdUsrIdJbCd) {
		this.ntcN3rdUsrIdJbCd = ntcN3rdUsrIdJbCd;
	}
	
	/**
	 * Column Info
	 * @param ntcUsrId7
	 */
	public void setNtcUsrId7(String ntcUsrId7) {
		this.ntcUsrId7 = ntcUsrId7;
	}
	
	/**
	 * Column Info
	 * @param ntcN1stUsrIdJbCd
	 */
	public void setNtcN1stUsrIdJbCd(String ntcN1stUsrIdJbCd) {
		this.ntcN1stUsrIdJbCd = ntcN1stUsrIdJbCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtCreUsrCount
	 */
	public void setCtrtCreUsrCount(String ctrtCreUsrCount) {
		this.ctrtCreUsrCount = ctrtCreUsrCount;
	}
	
	/**
	 * Column Info
	 * @param ntcUsrId1
	 */
	public void setNtcUsrId1(String ntcUsrId1) {
		this.ntcUsrId1 = ntcUsrId1;
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
		setNtcN6thUsrIdJbCdFlg(JSPUtil.getParameter(request, prefix + "ntc_n6th_usr_id_jb_cd_flg", ""));
		setNtcN2ndUsrIdJbCd(JSPUtil.getParameter(request, prefix + "ntc_n2nd_usr_id_jb_cd", ""));
		setNtcUsrId2Nm(JSPUtil.getParameter(request, prefix + "ntc_usr_id2_nm", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setNtcUsrId6Nm(JSPUtil.getParameter(request, prefix + "ntc_usr_id6_nm", ""));
		setOfcTpCd(JSPUtil.getParameter(request, prefix + "ofc_tp_cd", ""));
		setNtcN2ndUsrIdJbCdFlg(JSPUtil.getParameter(request, prefix + "ntc_n2nd_usr_id_jb_cd_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setNtcUsrId7Nm(JSPUtil.getParameter(request, prefix + "ntc_usr_id7_nm", ""));
		setRootPgmNo(JSPUtil.getParameter(request, prefix + "root_pgm_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setNtcN1stUsrIdJbCdFlg(JSPUtil.getParameter(request, prefix + "ntc_n1st_usr_id_jb_cd_flg", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
		setNtcUsrId5Nm(JSPUtil.getParameter(request, prefix + "ntc_usr_id5_nm", ""));
		setNtcUsrIdListCtnt(JSPUtil.getParameter(request, prefix + "ntc_usr_id_list_ctnt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setNtcN7thUsrIdJbCdFlg(JSPUtil.getParameter(request, prefix + "ntc_n7th_usr_id_jb_cd_flg", ""));
		setNtcN5thUsrIdJbCdFlg(JSPUtil.getParameter(request, prefix + "ntc_n5th_usr_id_jb_cd_flg", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setNtcUsrId4Nm(JSPUtil.getParameter(request, prefix + "ntc_usr_id4_nm", ""));
		setNtcN6thUsrIdJbCd(JSPUtil.getParameter(request, prefix + "ntc_n6th_usr_id_jb_cd", ""));
		setNtcUsrId3Nm(JSPUtil.getParameter(request, prefix + "ntc_usr_id3_nm", ""));
		setAgmtNo(JSPUtil.getParameter(request, prefix + "agmt_no", ""));
		setNtcN5thUsrIdJbCd(JSPUtil.getParameter(request, prefix + "ntc_n5th_usr_id_jb_cd", ""));
		setNtcN4thUsrIdJbCd(JSPUtil.getParameter(request, prefix + "ntc_n4th_usr_id_jb_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setUsrMaxKnt(JSPUtil.getParameter(request, prefix + "usr_max_knt", ""));
		setNtcUsrIdJbCdListCtnt(JSPUtil.getParameter(request, prefix + "ntc_usr_id_jb_cd_list_ctnt", ""));
		setNtcUsrId2(JSPUtil.getParameter(request, prefix + "ntc_usr_id2", ""));
		setSysCd(JSPUtil.getParameter(request, prefix + "sys_cd", ""));
		setNtcUsrId3(JSPUtil.getParameter(request, prefix + "ntc_usr_id3", ""));
		setAgmtMapgNo(JSPUtil.getParameter(request, prefix + "agmt_mapg_no", ""));
		setNtcN3rdUsrIdJbCdFlg(JSPUtil.getParameter(request, prefix + "ntc_n3rd_usr_id_jb_cd_flg", ""));
		setNtcUsrId4(JSPUtil.getParameter(request, prefix + "ntc_usr_id4", ""));
		setNtcN4thUsrIdJbCdFlg(JSPUtil.getParameter(request, prefix + "ntc_n4th_usr_id_jb_cd_flg", ""));
		setNtcUsrId5(JSPUtil.getParameter(request, prefix + "ntc_usr_id5", ""));
		setNtcN7thUsrIdJbCd(JSPUtil.getParameter(request, prefix + "ntc_n7th_usr_id_jb_cd", ""));
		setNtcUsrId1Nm(JSPUtil.getParameter(request, prefix + "ntc_usr_id1_nm", ""));
		setNtcUsrId6(JSPUtil.getParameter(request, prefix + "ntc_usr_id6", ""));
		setNtcN3rdUsrIdJbCd(JSPUtil.getParameter(request, prefix + "ntc_n3rd_usr_id_jb_cd", ""));
		setNtcUsrId7(JSPUtil.getParameter(request, prefix + "ntc_usr_id7", ""));
		setNtcN1stUsrIdJbCd(JSPUtil.getParameter(request, prefix + "ntc_n1st_usr_id_jb_cd", ""));
		setCtrtCreUsrCount(JSPUtil.getParameter(request, prefix + "ctrt_cre_usr_count", ""));
		setNtcUsrId1(JSPUtil.getParameter(request, prefix + "ntc_usr_id1", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMailingListVO[]
	 */
	public SearchMailingListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMailingListVO[]
	 */
	public SearchMailingListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMailingListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ntcN6thUsrIdJbCdFlg = (JSPUtil.getParameter(request, prefix	+ "ntc_n6th_usr_id_jb_cd_flg", length));
			String[] ntcN2ndUsrIdJbCd = (JSPUtil.getParameter(request, prefix	+ "ntc_n2nd_usr_id_jb_cd", length));
			String[] ntcUsrId2Nm = (JSPUtil.getParameter(request, prefix	+ "ntc_usr_id2_nm", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] ntcUsrId6Nm = (JSPUtil.getParameter(request, prefix	+ "ntc_usr_id6_nm", length));
			String[] ofcTpCd = (JSPUtil.getParameter(request, prefix	+ "ofc_tp_cd", length));
			String[] ntcN2ndUsrIdJbCdFlg = (JSPUtil.getParameter(request, prefix	+ "ntc_n2nd_usr_id_jb_cd_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ntcUsrId7Nm = (JSPUtil.getParameter(request, prefix	+ "ntc_usr_id7_nm", length));
			String[] rootPgmNo = (JSPUtil.getParameter(request, prefix	+ "root_pgm_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ntcN1stUsrIdJbCdFlg = (JSPUtil.getParameter(request, prefix	+ "ntc_n1st_usr_id_jb_cd_flg", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] ntcUsrId5Nm = (JSPUtil.getParameter(request, prefix	+ "ntc_usr_id5_nm", length));
			String[] ntcUsrIdListCtnt = (JSPUtil.getParameter(request, prefix	+ "ntc_usr_id_list_ctnt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] ntcN7thUsrIdJbCdFlg = (JSPUtil.getParameter(request, prefix	+ "ntc_n7th_usr_id_jb_cd_flg", length));
			String[] ntcN5thUsrIdJbCdFlg = (JSPUtil.getParameter(request, prefix	+ "ntc_n5th_usr_id_jb_cd_flg", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] ntcUsrId4Nm = (JSPUtil.getParameter(request, prefix	+ "ntc_usr_id4_nm", length));
			String[] ntcN6thUsrIdJbCd = (JSPUtil.getParameter(request, prefix	+ "ntc_n6th_usr_id_jb_cd", length));
			String[] ntcUsrId3Nm = (JSPUtil.getParameter(request, prefix	+ "ntc_usr_id3_nm", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] ntcN5thUsrIdJbCd = (JSPUtil.getParameter(request, prefix	+ "ntc_n5th_usr_id_jb_cd", length));
			String[] ntcN4thUsrIdJbCd = (JSPUtil.getParameter(request, prefix	+ "ntc_n4th_usr_id_jb_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] usrMaxKnt = (JSPUtil.getParameter(request, prefix	+ "usr_max_knt", length));
			String[] ntcUsrIdJbCdListCtnt = (JSPUtil.getParameter(request, prefix	+ "ntc_usr_id_jb_cd_list_ctnt", length));
			String[] ntcUsrId2 = (JSPUtil.getParameter(request, prefix	+ "ntc_usr_id2", length));
			String[] sysCd = (JSPUtil.getParameter(request, prefix	+ "sys_cd", length));
			String[] ntcUsrId3 = (JSPUtil.getParameter(request, prefix	+ "ntc_usr_id3", length));
			String[] agmtMapgNo = (JSPUtil.getParameter(request, prefix	+ "agmt_mapg_no", length));
			String[] ntcN3rdUsrIdJbCdFlg = (JSPUtil.getParameter(request, prefix	+ "ntc_n3rd_usr_id_jb_cd_flg", length));
			String[] ntcUsrId4 = (JSPUtil.getParameter(request, prefix	+ "ntc_usr_id4", length));
			String[] ntcN4thUsrIdJbCdFlg = (JSPUtil.getParameter(request, prefix	+ "ntc_n4th_usr_id_jb_cd_flg", length));
			String[] ntcUsrId5 = (JSPUtil.getParameter(request, prefix	+ "ntc_usr_id5", length));
			String[] ntcN7thUsrIdJbCd = (JSPUtil.getParameter(request, prefix	+ "ntc_n7th_usr_id_jb_cd", length));
			String[] ntcUsrId1Nm = (JSPUtil.getParameter(request, prefix	+ "ntc_usr_id1_nm", length));
			String[] ntcUsrId6 = (JSPUtil.getParameter(request, prefix	+ "ntc_usr_id6", length));
			String[] ntcN3rdUsrIdJbCd = (JSPUtil.getParameter(request, prefix	+ "ntc_n3rd_usr_id_jb_cd", length));
			String[] ntcUsrId7 = (JSPUtil.getParameter(request, prefix	+ "ntc_usr_id7", length));
			String[] ntcN1stUsrIdJbCd = (JSPUtil.getParameter(request, prefix	+ "ntc_n1st_usr_id_jb_cd", length));
			String[] ctrtCreUsrCount = (JSPUtil.getParameter(request, prefix	+ "ctrt_cre_usr_count", length));
			String[] ntcUsrId1 = (JSPUtil.getParameter(request, prefix	+ "ntc_usr_id1", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMailingListVO();
				if (ntcN6thUsrIdJbCdFlg[i] != null)
					model.setNtcN6thUsrIdJbCdFlg(ntcN6thUsrIdJbCdFlg[i]);
				if (ntcN2ndUsrIdJbCd[i] != null)
					model.setNtcN2ndUsrIdJbCd(ntcN2ndUsrIdJbCd[i]);
				if (ntcUsrId2Nm[i] != null)
					model.setNtcUsrId2Nm(ntcUsrId2Nm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (ntcUsrId6Nm[i] != null)
					model.setNtcUsrId6Nm(ntcUsrId6Nm[i]);
				if (ofcTpCd[i] != null)
					model.setOfcTpCd(ofcTpCd[i]);
				if (ntcN2ndUsrIdJbCdFlg[i] != null)
					model.setNtcN2ndUsrIdJbCdFlg(ntcN2ndUsrIdJbCdFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ntcUsrId7Nm[i] != null)
					model.setNtcUsrId7Nm(ntcUsrId7Nm[i]);
				if (rootPgmNo[i] != null)
					model.setRootPgmNo(rootPgmNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ntcN1stUsrIdJbCdFlg[i] != null)
					model.setNtcN1stUsrIdJbCdFlg(ntcN1stUsrIdJbCdFlg[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (ntcUsrId5Nm[i] != null)
					model.setNtcUsrId5Nm(ntcUsrId5Nm[i]);
				if (ntcUsrIdListCtnt[i] != null)
					model.setNtcUsrIdListCtnt(ntcUsrIdListCtnt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (ntcN7thUsrIdJbCdFlg[i] != null)
					model.setNtcN7thUsrIdJbCdFlg(ntcN7thUsrIdJbCdFlg[i]);
				if (ntcN5thUsrIdJbCdFlg[i] != null)
					model.setNtcN5thUsrIdJbCdFlg(ntcN5thUsrIdJbCdFlg[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ntcUsrId4Nm[i] != null)
					model.setNtcUsrId4Nm(ntcUsrId4Nm[i]);
				if (ntcN6thUsrIdJbCd[i] != null)
					model.setNtcN6thUsrIdJbCd(ntcN6thUsrIdJbCd[i]);
				if (ntcUsrId3Nm[i] != null)
					model.setNtcUsrId3Nm(ntcUsrId3Nm[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (ntcN5thUsrIdJbCd[i] != null)
					model.setNtcN5thUsrIdJbCd(ntcN5thUsrIdJbCd[i]);
				if (ntcN4thUsrIdJbCd[i] != null)
					model.setNtcN4thUsrIdJbCd(ntcN4thUsrIdJbCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (usrMaxKnt[i] != null)
					model.setUsrMaxKnt(usrMaxKnt[i]);
				if (ntcUsrIdJbCdListCtnt[i] != null)
					model.setNtcUsrIdJbCdListCtnt(ntcUsrIdJbCdListCtnt[i]);
				if (ntcUsrId2[i] != null)
					model.setNtcUsrId2(ntcUsrId2[i]);
				if (sysCd[i] != null)
					model.setSysCd(sysCd[i]);
				if (ntcUsrId3[i] != null)
					model.setNtcUsrId3(ntcUsrId3[i]);
				if (agmtMapgNo[i] != null)
					model.setAgmtMapgNo(agmtMapgNo[i]);
				if (ntcN3rdUsrIdJbCdFlg[i] != null)
					model.setNtcN3rdUsrIdJbCdFlg(ntcN3rdUsrIdJbCdFlg[i]);
				if (ntcUsrId4[i] != null)
					model.setNtcUsrId4(ntcUsrId4[i]);
				if (ntcN4thUsrIdJbCdFlg[i] != null)
					model.setNtcN4thUsrIdJbCdFlg(ntcN4thUsrIdJbCdFlg[i]);
				if (ntcUsrId5[i] != null)
					model.setNtcUsrId5(ntcUsrId5[i]);
				if (ntcN7thUsrIdJbCd[i] != null)
					model.setNtcN7thUsrIdJbCd(ntcN7thUsrIdJbCd[i]);
				if (ntcUsrId1Nm[i] != null)
					model.setNtcUsrId1Nm(ntcUsrId1Nm[i]);
				if (ntcUsrId6[i] != null)
					model.setNtcUsrId6(ntcUsrId6[i]);
				if (ntcN3rdUsrIdJbCd[i] != null)
					model.setNtcN3rdUsrIdJbCd(ntcN3rdUsrIdJbCd[i]);
				if (ntcUsrId7[i] != null)
					model.setNtcUsrId7(ntcUsrId7[i]);
				if (ntcN1stUsrIdJbCd[i] != null)
					model.setNtcN1stUsrIdJbCd(ntcN1stUsrIdJbCd[i]);
				if (ctrtCreUsrCount[i] != null)
					model.setCtrtCreUsrCount(ctrtCreUsrCount[i]);
				if (ntcUsrId1[i] != null)
					model.setNtcUsrId1(ntcUsrId1[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMailingListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMailingListVO[]
	 */
	public SearchMailingListVO[] getSearchMailingListVOs(){
		SearchMailingListVO[] vos = (SearchMailingListVO[])models.toArray(new SearchMailingListVO[models.size()]);
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
		this.ntcN6thUsrIdJbCdFlg = this.ntcN6thUsrIdJbCdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcN2ndUsrIdJbCd = this.ntcN2ndUsrIdJbCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcUsrId2Nm = this.ntcUsrId2Nm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcUsrId6Nm = this.ntcUsrId6Nm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcTpCd = this.ofcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcN2ndUsrIdJbCdFlg = this.ntcN2ndUsrIdJbCdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcUsrId7Nm = this.ntcUsrId7Nm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rootPgmNo = this.rootPgmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcN1stUsrIdJbCdFlg = this.ntcN1stUsrIdJbCdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcUsrId5Nm = this.ntcUsrId5Nm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcUsrIdListCtnt = this.ntcUsrIdListCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcN7thUsrIdJbCdFlg = this.ntcN7thUsrIdJbCdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcN5thUsrIdJbCdFlg = this.ntcN5thUsrIdJbCdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcUsrId4Nm = this.ntcUsrId4Nm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcN6thUsrIdJbCd = this.ntcN6thUsrIdJbCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcUsrId3Nm = this.ntcUsrId3Nm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcN5thUsrIdJbCd = this.ntcN5thUsrIdJbCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcN4thUsrIdJbCd = this.ntcN4thUsrIdJbCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrMaxKnt = this.usrMaxKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcUsrIdJbCdListCtnt = this.ntcUsrIdJbCdListCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcUsrId2 = this.ntcUsrId2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysCd = this.sysCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcUsrId3 = this.ntcUsrId3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtMapgNo = this.agmtMapgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcN3rdUsrIdJbCdFlg = this.ntcN3rdUsrIdJbCdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcUsrId4 = this.ntcUsrId4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcN4thUsrIdJbCdFlg = this.ntcN4thUsrIdJbCdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcUsrId5 = this.ntcUsrId5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcN7thUsrIdJbCd = this.ntcN7thUsrIdJbCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcUsrId1Nm = this.ntcUsrId1Nm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcUsrId6 = this.ntcUsrId6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcN3rdUsrIdJbCd = this.ntcN3rdUsrIdJbCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcUsrId7 = this.ntcUsrId7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcN1stUsrIdJbCd = this.ntcN1stUsrIdJbCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCreUsrCount = this.ctrtCreUsrCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcUsrId1 = this.ntcUsrId1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

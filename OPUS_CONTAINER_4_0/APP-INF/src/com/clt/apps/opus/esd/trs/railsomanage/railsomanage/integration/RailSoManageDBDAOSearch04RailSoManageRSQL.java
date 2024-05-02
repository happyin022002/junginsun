/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RailSoManageDBDAOSearch04RailSoManageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.29
*@LastModifier : 
*@LastVersion : 1.0
* 2010.12.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.railsomanage.railsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailSoManageDBDAOSearch04RailSoManageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * IRG ADJUST  MAIN 조회 SQL
	  * </pre>
	  */
	public RailSoManageDBDAOSearch04RailSoManageRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.railsomanage.railsomanage.integration").append("\n"); 
		query.append("FileName : RailSoManageDBDAOSearch04RailSoManageRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("#set(${lnk_org_nod_cd}=${lnk_org_nod_cd})" ).append("\n"); 
		query.append("#set(${lnk_dest_nod_cd}=${lnk_dest_nod_cd})" ).append("\n"); 
		query.append("#set(${cgo_tp_cd}=${cgo_tp_cd})" ).append("\n"); 
		query.append("#set(${rout_org_nod_cd}=${rout_org_nod_cd})" ).append("\n"); 
		query.append("#set(${rout_dest_nod_cd}=${rout_dest_nod_cd})" ).append("\n"); 
		query.append("#set(${rout_seq}=${rout_seq})" ).append("\n"); 
		query.append("#set(${trsp_bnd_cd}=${trsp_bnd_cd})" ).append("\n"); 
		query.append("#set(${bkg_rcvde_term_cd}=${bkg_rcvde_term_cd})" ).append("\n"); 
		query.append("#set(${key_org}=${key_org})" ).append("\n"); 
		query.append("#set(${key_dest}=${key_dest})" ).append("\n"); 
		query.append("#set(${arr_size}=${arr_size})" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${empty_yn} == 'M')" ).append("\n"); 
		query.append("#foreach(${key} IN ${arr_size})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'CY' BKG_RCVDE_TERM_CD," ).append("\n"); 
		query.append("${lnk_org_nod_cd.get($key)} KEY_ORG ," ).append("\n"); 
		query.append("${lnk_dest_nod_cd.get($key)} KEY_DEST," ).append("\n"); 
		query.append("${cgo_tp_cd.get($key)} CGO_TP_CD," ).append("\n"); 
		query.append("SUBSTR(${lnk_org_nod_cd.get($key)}, 1, 5) FM_NOD_CD," ).append("\n"); 
		query.append("SUBSTR(${lnk_org_nod_cd.get($key)}, 6) FM_NOD_YARD," ).append("\n"); 
		query.append("SUBSTR(${lnk_dest_nod_cd.get($key)}, 1, 5) TO_NOD_CD," ).append("\n"); 
		query.append("SUBSTR(${lnk_dest_nod_cd.get($key)}, 6) TO_NOD_YARD," ).append("\n"); 
		query.append("A.PRIO_SEQ," ).append("\n"); 
		query.append("A.INLND_ROUT_RMK INLND_ROUT_RMK," ).append("\n"); 
		query.append("${lnk_org_nod_cd.get($key)} FROM_NODE," ).append("\n"); 
		query.append("${lnk_dest_nod_cd.get($key)} TO_NODE," ).append("\n"); 
		query.append("A.ROUT_PLN_CD ROUT_PLN_CD," ).append("\n"); 
		query.append("A.ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("A.ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("A.ROUT_SEQ," ).append("\n"); 
		query.append("A.ROUT_ORG_NOD_CD ROUT_ORG_SET," ).append("\n"); 
		query.append("A.ROUT_DEST_NOD_CD ROUT_DEST_SET," ).append("\n"); 
		query.append("A.ROUT_SEQ ROUT_SEQ_SET," ).append("\n"); 
		query.append("MAX( A.INLND_ROUT_INV_BIL_PATT_CD) RAIL_CMB_THRU_TP_CD," ).append("\n"); 
		query.append("MAX( DECODE( B.ROUT_DTL_SEQ, 1, DECODE( B.LNK_ORG_NOD_CD, ${lnk_org_nod_cd.get($key)}, B.LNK_ORG_NOD_CD)||'-('||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD ) )||" ).append("\n"); 
		query.append("MAX( DECODE( B.ROUT_DTL_SEQ, 2, DECODE( B.LNK_ORG_NOD_CD, ${lnk_org_nod_cd.get($key)}, B.LNK_ORG_NOD_CD)||'-('||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD ) )||" ).append("\n"); 
		query.append("MAX( DECODE( B.ROUT_DTL_SEQ, 3, DECODE( B.LNK_ORG_NOD_CD, ${lnk_org_nod_cd.get($key)}, B.LNK_ORG_NOD_CD)||'-('||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD ) )||" ).append("\n"); 
		query.append("MAX( DECODE( B.ROUT_DTL_SEQ, 4, DECODE( B.LNK_ORG_NOD_CD, ${lnk_org_nod_cd.get($key)}, B.LNK_ORG_NOD_CD)||'-('||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD ) )||" ).append("\n"); 
		query.append("MAX( DECODE( B.ROUT_DTL_SEQ, 5, DECODE( B.LNK_ORG_NOD_CD, ${lnk_org_nod_cd.get($key)}, B.LNK_ORG_NOD_CD)||'-('||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD ) )||" ).append("\n"); 
		query.append("MAX( DECODE( B.ROUT_DTL_SEQ, 6, DECODE( B.LNK_ORG_NOD_CD, ${lnk_org_nod_cd.get($key)}, B.LNK_ORG_NOD_CD)||'-('||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD ) )||" ).append("\n"); 
		query.append("MAX( DECODE( B.ROUT_DTL_SEQ, 7, DECODE( B.LNK_ORG_NOD_CD, ${lnk_org_nod_cd.get($key)}, B.LNK_ORG_NOD_CD)||'-('||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD ) )||" ).append("\n"); 
		query.append("MAX( DECODE( B.ROUT_DTL_SEQ, 8, DECODE( B.LNK_ORG_NOD_CD, ${lnk_org_nod_cd.get($key)}, B.LNK_ORG_NOD_CD)||'-('||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD ) )IRG," ).append("\n"); 
		query.append("MAX(DECODE( B.ROUT_DTL_SEQ, 1, NVL( AGMT.AGMT_REF_NO, 'N/A')|| DECODE( D.MAX_SEQ, 1 , '', ' / ') )) ||" ).append("\n"); 
		query.append("MAX(DECODE( B.ROUT_DTL_SEQ, 2, NVL( AGMT.AGMT_REF_NO, 'N/A')|| DECODE( D.MAX_SEQ, 2 , '', ' / ') )) ||" ).append("\n"); 
		query.append("MAX(DECODE( B.ROUT_DTL_SEQ, 3, NVL( AGMT.AGMT_REF_NO, 'N/A')|| DECODE( D.MAX_SEQ, 3 , '', ' / ') )) ||" ).append("\n"); 
		query.append("MAX(DECODE( B.ROUT_DTL_SEQ, 4, NVL( AGMT.AGMT_REF_NO, 'N/A')|| DECODE( D.MAX_SEQ, 4 , '', ' / ') )) ||" ).append("\n"); 
		query.append("MAX(DECODE( B.ROUT_DTL_SEQ, 5, NVL( AGMT.AGMT_REF_NO, 'N/A')|| DECODE( D.MAX_SEQ, 5 , '', ' / ') )) ||" ).append("\n"); 
		query.append("MAX(DECODE( B.ROUT_DTL_SEQ, 6, NVL( AGMT.AGMT_REF_NO, 'N/A')|| DECODE( D.MAX_SEQ, 6 , '', ' / ') )) ||" ).append("\n"); 
		query.append("MAX(DECODE( B.ROUT_DTL_SEQ, 7, NVL( AGMT.AGMT_REF_NO, 'N/A')|| DECODE( D.MAX_SEQ, 7 , '', ' / ') )) ||" ).append("\n"); 
		query.append("MAX(DECODE( B.ROUT_DTL_SEQ, 8, NVL( AGMT.AGMT_REF_NO, 'N/A')|| DECODE( D.MAX_SEQ, 8 , '', ' / ') )) REF_NO ," ).append("\n"); 
		query.append("'' IRG_DROPDOWNLIST" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("PRD_INLND_ROUT_MST A," ).append("\n"); 
		query.append("PRD_INLND_ROUT_DTL B," ).append("\n"); 
		query.append("MDM_VENDOR C," ).append("\n"); 
		query.append("TRS_AGMT_HDR AGMT," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("A.ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("A.ROUT_SEQ," ).append("\n"); 
		query.append("C.MIN_SEQ MIN_SEQ," ).append("\n"); 
		query.append("ROUT_DTL_SEQ MAX_SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("PRD_INLND_ROUT_DTL A," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("ROUT_SEQ," ).append("\n"); 
		query.append("ROUT_DTL_SEQ MIN_SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("PRD_INLND_ROUT_DTL" ).append("\n"); 
		query.append("WHERE LNK_ORG_NOD_CD = ${lnk_org_nod_cd.get($key)}" ).append("\n"); 
		query.append("AND 	ROUT_ORG_NOD_CD = ${rout_org_nod_cd.get($key)}" ).append("\n"); 
		query.append("AND 	ROUT_DEST_NOD_CD = ${rout_dest_nod_cd.get($key)}" ).append("\n"); 
		query.append("AND 	ROUT_SEQ = ${rout_seq.get($key)}" ).append("\n"); 
		query.append("AND 	TRSP_MOD_CD='RD'" ).append("\n"); 
		query.append(") C" ).append("\n"); 
		query.append("WHERE LNK_DEST_NOD_CD = ${lnk_dest_nod_cd.get($key)}" ).append("\n"); 
		query.append("AND 	A.ROUT_ORG_NOD_CD = C.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("AND 	A.ROUT_DEST_NOD_CD = C.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("AND 	A.ROUT_SEQ = C.ROUT_SEQ" ).append("\n"); 
		query.append("AND 	TRSP_MOD_CD='RD'" ).append("\n"); 
		query.append(") D" ).append("\n"); 
		query.append("WHERE A.ROUT_ORG_NOD_CD = B.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("AND 	A.ROUT_DEST_NOD_CD = B.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("AND 	A.ROUT_SEQ = B.ROUT_SEQ" ).append("\n"); 
		query.append("AND 	B.TRSP_AGMT_OFC_CTY_CD = AGMT.TRSP_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND 	B.TRSP_AGMT_SEQ =AGMT.TRSP_AGMT_SEQ(+)" ).append("\n"); 
		query.append("AND 	NVL(A.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND 	B.TRSP_MOD_CD='RD'" ).append("\n"); 
		query.append("AND 	B.VNDR_SEQ = C.VNDR_SEQ" ).append("\n"); 
		query.append("AND 	B.ROUT_ORG_NOD_CD = D.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("AND 	B.ROUT_DEST_NOD_CD = D.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("AND 	B.ROUT_SEQ = D.ROUT_SEQ" ).append("\n"); 
		query.append("AND 	B.ROUT_DTL_SEQ >= D.MIN_SEQ" ).append("\n"); 
		query.append("AND 	B.ROUT_DTL_SEQ <= D.MAX_SEQ" ).append("\n"); 
		query.append("GROUP BY A.PRIO_SEQ, A.INLND_ROUT_RMK, A.ROUT_PLN_CD, A.ROUT_ORG_NOD_CD, A.ROUT_DEST_NOD_CD, A.ROUT_SEQ, B.TRSP_MOD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'CY' BKG_RCVDE_TERM_CD," ).append("\n"); 
		query.append("${lnk_org_nod_cd.get($key)} KEY_ORG ," ).append("\n"); 
		query.append("${lnk_dest_nod_cd.get($key)} KEY_DEST," ).append("\n"); 
		query.append("${cgo_tp_cd.get($key)} CGO_TP_CD," ).append("\n"); 
		query.append("SUBSTR(${lnk_org_nod_cd.get($key)}, 1, 5) FM_NOD_CD," ).append("\n"); 
		query.append("SUBSTR(${lnk_org_nod_cd.get($key)}, 6) FM_NOD_YARD," ).append("\n"); 
		query.append("SUBSTR(${lnk_dest_nod_cd.get($key)}, 1, 5) TO_NOD_CD," ).append("\n"); 
		query.append("SUBSTR(${lnk_dest_nod_cd.get($key)}, 6) TO_NOD_YARD," ).append("\n"); 
		query.append("A.PRIO_SEQ," ).append("\n"); 
		query.append("A.INLND_ROUT_RMK INLND_ROUT_RMK," ).append("\n"); 
		query.append("${lnk_org_nod_cd.get($key)} FROM_NODE," ).append("\n"); 
		query.append("${lnk_dest_nod_cd.get($key)} TO_NODE," ).append("\n"); 
		query.append("A.ROUT_PLN_CD ROUT_PLN_CD," ).append("\n"); 
		query.append("A.ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("A.ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("A.ROUT_SEQ," ).append("\n"); 
		query.append("A.ROUT_ORG_NOD_CD ROUT_ORG_SET," ).append("\n"); 
		query.append("A.ROUT_DEST_NOD_CD ROUT_DEST_SET," ).append("\n"); 
		query.append("A.ROUT_SEQ ROUT_SEQ_SET," ).append("\n"); 
		query.append("MAX( A.INLND_ROUT_INV_BIL_PATT_CD) RAIL_CMB_THRU_TP_CD," ).append("\n"); 
		query.append("MAX( DECODE( B.ROUT_DTL_SEQ, 1, DECODE( B.LNK_ORG_NOD_CD, ${lnk_org_nod_cd.get($key)}, B.LNK_ORG_NOD_CD)||'-('||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD ) )||" ).append("\n"); 
		query.append("MAX( DECODE( B.ROUT_DTL_SEQ, 2, DECODE( B.LNK_ORG_NOD_CD, ${lnk_org_nod_cd.get($key)}, B.LNK_ORG_NOD_CD)||'-('||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD ) )||" ).append("\n"); 
		query.append("MAX( DECODE( B.ROUT_DTL_SEQ, 3, DECODE( B.LNK_ORG_NOD_CD, ${lnk_org_nod_cd.get($key)}, B.LNK_ORG_NOD_CD)||'-('||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD ) )||" ).append("\n"); 
		query.append("MAX( DECODE( B.ROUT_DTL_SEQ, 4, DECODE( B.LNK_ORG_NOD_CD, ${lnk_org_nod_cd.get($key)}, B.LNK_ORG_NOD_CD)||'-('||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD ) )||" ).append("\n"); 
		query.append("MAX( DECODE( B.ROUT_DTL_SEQ, 5, DECODE( B.LNK_ORG_NOD_CD, ${lnk_org_nod_cd.get($key)}, B.LNK_ORG_NOD_CD)||'-('||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD ) )||" ).append("\n"); 
		query.append("MAX( DECODE( B.ROUT_DTL_SEQ, 6, DECODE( B.LNK_ORG_NOD_CD, ${lnk_org_nod_cd.get($key)}, B.LNK_ORG_NOD_CD)||'-('||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD ) )||" ).append("\n"); 
		query.append("MAX( DECODE( B.ROUT_DTL_SEQ, 7, DECODE( B.LNK_ORG_NOD_CD, ${lnk_org_nod_cd.get($key)}, B.LNK_ORG_NOD_CD)||'-('||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD ) )||" ).append("\n"); 
		query.append("MAX( DECODE( B.ROUT_DTL_SEQ, 8, DECODE( B.LNK_ORG_NOD_CD, ${lnk_org_nod_cd.get($key)}, B.LNK_ORG_NOD_CD)||'-('||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD ) )IRG," ).append("\n"); 
		query.append("MAX(DECODE( B.ROUT_DTL_SEQ, 1, NVL( AGMT.AGMT_REF_NO, 'N/A')|| DECODE( D.MAX_SEQ, 1 , '', ' / ') )) ||" ).append("\n"); 
		query.append("MAX(DECODE( B.ROUT_DTL_SEQ, 2, NVL( AGMT.AGMT_REF_NO, 'N/A')|| DECODE( D.MAX_SEQ, 2 , '', ' / ') )) ||" ).append("\n"); 
		query.append("MAX(DECODE( B.ROUT_DTL_SEQ, 3, NVL( AGMT.AGMT_REF_NO, 'N/A')|| DECODE( D.MAX_SEQ, 3 , '', ' / ') )) ||" ).append("\n"); 
		query.append("MAX(DECODE( B.ROUT_DTL_SEQ, 4, NVL( AGMT.AGMT_REF_NO, 'N/A')|| DECODE( D.MAX_SEQ, 4 , '', ' / ') )) ||" ).append("\n"); 
		query.append("MAX(DECODE( B.ROUT_DTL_SEQ, 5, NVL( AGMT.AGMT_REF_NO, 'N/A')|| DECODE( D.MAX_SEQ, 5 , '', ' / ') )) ||" ).append("\n"); 
		query.append("MAX(DECODE( B.ROUT_DTL_SEQ, 6, NVL( AGMT.AGMT_REF_NO, 'N/A')|| DECODE( D.MAX_SEQ, 6 , '', ' / ') )) ||" ).append("\n"); 
		query.append("MAX(DECODE( B.ROUT_DTL_SEQ, 7, NVL( AGMT.AGMT_REF_NO, 'N/A')|| DECODE( D.MAX_SEQ, 7 , '', ' / ') )) ||" ).append("\n"); 
		query.append("MAX(DECODE( B.ROUT_DTL_SEQ, 8, NVL( AGMT.AGMT_REF_NO, 'N/A')|| DECODE( D.MAX_SEQ, 8 , '', ' / ') )) REF_NO ," ).append("\n"); 
		query.append("'' IRG_DROPDOWNLIST" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("PRD_INLND_ROUT_MST A," ).append("\n"); 
		query.append("PRD_INLND_ROUT_DTL B," ).append("\n"); 
		query.append("MDM_VENDOR C," ).append("\n"); 
		query.append("TRS_AGMT_HDR AGMT," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("A.ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("A.ROUT_SEQ," ).append("\n"); 
		query.append("C.MIN_SEQ MIN_SEQ," ).append("\n"); 
		query.append("ROUT_DTL_SEQ MAX_SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("PRD_INLND_ROUT_DTL A," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("ROUT_SEQ," ).append("\n"); 
		query.append("ROUT_DTL_SEQ MIN_SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("PRD_INLND_ROUT_DTL" ).append("\n"); 
		query.append("WHERE LNK_ORG_NOD_CD = ${lnk_org_nod_cd.get($key)}" ).append("\n"); 
		query.append("AND 	ROUT_ORG_NOD_CD = ${rout_org_nod_cd.get($key)}" ).append("\n"); 
		query.append("AND 	ROUT_DEST_NOD_CD = ${rout_dest_nod_cd.get($key)}" ).append("\n"); 
		query.append("AND 	ROUT_SEQ = ${rout_seq.get($key)}" ).append("\n"); 
		query.append("AND 	TRSP_MOD_CD='RD'" ).append("\n"); 
		query.append(") C" ).append("\n"); 
		query.append("WHERE LNK_DEST_NOD_CD = ${lnk_dest_nod_cd.get($key)}" ).append("\n"); 
		query.append("AND 	A.ROUT_ORG_NOD_CD = C.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("AND 	A.ROUT_DEST_NOD_CD = C.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("AND 	A.ROUT_SEQ = C.ROUT_SEQ" ).append("\n"); 
		query.append("AND 	TRSP_MOD_CD='RD'" ).append("\n"); 
		query.append(") D" ).append("\n"); 
		query.append("WHERE A.ROUT_ORG_NOD_CD = B.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("AND 	A.ROUT_DEST_NOD_CD = B.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("AND 	A.ROUT_SEQ = B.ROUT_SEQ" ).append("\n"); 
		query.append("AND 	B.TRSP_AGMT_OFC_CTY_CD = AGMT.TRSP_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND 	B.TRSP_AGMT_SEQ =AGMT.TRSP_AGMT_SEQ(+)" ).append("\n"); 
		query.append("AND 	NVL(A.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND 	B.TRSP_MOD_CD='RD'" ).append("\n"); 
		query.append("AND 	B.VNDR_SEQ = C.VNDR_SEQ" ).append("\n"); 
		query.append("AND 	B.ROUT_ORG_NOD_CD = D.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("AND 	B.ROUT_DEST_NOD_CD = D.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("AND 	B.ROUT_SEQ = D.ROUT_SEQ" ).append("\n"); 
		query.append("AND 	B.ROUT_DTL_SEQ >= D.MIN_SEQ" ).append("\n"); 
		query.append("AND 	B.ROUT_DTL_SEQ <= D.MAX_SEQ" ).append("\n"); 
		query.append("GROUP BY A.PRIO_SEQ, A.INLND_ROUT_RMK, A.ROUT_PLN_CD, A.ROUT_ORG_NOD_CD, A.ROUT_DEST_NOD_CD, A.ROUT_SEQ, B.TRSP_MOD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#foreach(${key} IN ${arr_size})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("${trsp_bnd_cd.get($key)} TRSP_BND_CD," ).append("\n"); 
		query.append("DECODE(${bkg_rcvde_term_cd.get($key)}, 'D', 'DOOR', 'CY') BKG_RCVDE_TERM_CD ," ).append("\n"); 
		query.append("#if(${trsp_bnd_cd.get($key)} == \"'O'\")" ).append("\n"); 
		query.append("${key_dest.get($key)} POLPOD," ).append("\n"); 
		query.append("#elseif(${trsp_bnd_cd.get($key)} == \"'I'\")" ).append("\n"); 
		query.append("${key_org.get($key)} POLPOD," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("${key_org.get($key)} KEY_ORG," ).append("\n"); 
		query.append("${key_dest.get($key)} KEY_DEST," ).append("\n"); 
		query.append("${cgo_tp_cd.get($key)} CGO_TP_CD," ).append("\n"); 
		query.append("SUBSTR(${lnk_org_nod_cd.get($key)}, 1, 5) FM_NOD_CD," ).append("\n"); 
		query.append("SUBSTR(${lnk_org_nod_cd.get($key)}, 6) FM_NOD_YARD," ).append("\n"); 
		query.append("SUBSTR(${lnk_dest_nod_cd.get($key)}, 1, 5) TO_NOD_CD," ).append("\n"); 
		query.append("SUBSTR(${lnk_dest_nod_cd.get($key)}, 6) TO_NOD_YARD," ).append("\n"); 
		query.append("A.PRIO_SEQ," ).append("\n"); 
		query.append("A.INLND_ROUT_RMK INLND_ROUT_RMK," ).append("\n"); 
		query.append("${lnk_org_nod_cd.get($key)} FROM_NODE," ).append("\n"); 
		query.append("${lnk_dest_nod_cd.get($key)} TO_NODE," ).append("\n"); 
		query.append("A.ROUT_PLN_CD ROUT_PLN_CD," ).append("\n"); 
		query.append("A.ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("A.ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("A.ROUT_SEQ," ).append("\n"); 
		query.append("A.ROUT_ORG_NOD_CD ROUT_ORG_SET," ).append("\n"); 
		query.append("A.ROUT_DEST_NOD_CD ROUT_DEST_SET," ).append("\n"); 
		query.append("A.ROUT_SEQ ROUT_SEQ_SET," ).append("\n"); 
		query.append("MAX( A.INLND_ROUT_INV_BIL_PATT_CD) RAIL_CMB_THRU_TP_CD," ).append("\n"); 
		query.append("MAX( DECODE( B.ROUT_DTL_SEQ, 1, DECODE( B.LNK_ORG_NOD_CD, ${lnk_org_nod_cd.get($key)}, B.LNK_ORG_NOD_CD)||'-('||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD ) )||" ).append("\n"); 
		query.append("MAX( DECODE( B.ROUT_DTL_SEQ, 2, DECODE( B.LNK_ORG_NOD_CD, ${lnk_org_nod_cd.get($key)}, B.LNK_ORG_NOD_CD)||'-('||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD ) )||" ).append("\n"); 
		query.append("MAX( DECODE( B.ROUT_DTL_SEQ, 3, DECODE( B.LNK_ORG_NOD_CD, ${lnk_org_nod_cd.get($key)}, B.LNK_ORG_NOD_CD)||'-('||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD ) )||" ).append("\n"); 
		query.append("MAX( DECODE( B.ROUT_DTL_SEQ, 4, DECODE( B.LNK_ORG_NOD_CD, ${lnk_org_nod_cd.get($key)}, B.LNK_ORG_NOD_CD)||'-('||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD ) )||" ).append("\n"); 
		query.append("MAX( DECODE( B.ROUT_DTL_SEQ, 5, DECODE( B.LNK_ORG_NOD_CD, ${lnk_org_nod_cd.get($key)}, B.LNK_ORG_NOD_CD)||'-('||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD ) )||" ).append("\n"); 
		query.append("MAX( DECODE( B.ROUT_DTL_SEQ, 6, DECODE( B.LNK_ORG_NOD_CD, ${lnk_org_nod_cd.get($key)}, B.LNK_ORG_NOD_CD)||'-('||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD ) )||" ).append("\n"); 
		query.append("MAX( DECODE( B.ROUT_DTL_SEQ, 7, DECODE( B.LNK_ORG_NOD_CD, ${lnk_org_nod_cd.get($key)}, B.LNK_ORG_NOD_CD)||'-('||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD ) )||" ).append("\n"); 
		query.append("MAX( DECODE( B.ROUT_DTL_SEQ, 8, DECODE( B.LNK_ORG_NOD_CD, ${lnk_org_nod_cd.get($key)}, B.LNK_ORG_NOD_CD)||'-('||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD ) )IRG," ).append("\n"); 
		query.append("MAX(DECODE( B.ROUT_DTL_SEQ, 1, NVL( AGMT.AGMT_REF_NO, 'N/A')|| DECODE( D.MAX_SEQ, 1 , '', ' / ') )) ||" ).append("\n"); 
		query.append("MAX(DECODE( B.ROUT_DTL_SEQ, 2, NVL( AGMT.AGMT_REF_NO, 'N/A')|| DECODE( D.MAX_SEQ, 2 , '', ' / ') )) ||" ).append("\n"); 
		query.append("MAX(DECODE( B.ROUT_DTL_SEQ, 3, NVL( AGMT.AGMT_REF_NO, 'N/A')|| DECODE( D.MAX_SEQ, 3 , '', ' / ') )) ||" ).append("\n"); 
		query.append("MAX(DECODE( B.ROUT_DTL_SEQ, 4, NVL( AGMT.AGMT_REF_NO, 'N/A')|| DECODE( D.MAX_SEQ, 4 , '', ' / ') )) ||" ).append("\n"); 
		query.append("MAX(DECODE( B.ROUT_DTL_SEQ, 5, NVL( AGMT.AGMT_REF_NO, 'N/A')|| DECODE( D.MAX_SEQ, 5 , '', ' / ') )) ||" ).append("\n"); 
		query.append("MAX(DECODE( B.ROUT_DTL_SEQ, 6, NVL( AGMT.AGMT_REF_NO, 'N/A')|| DECODE( D.MAX_SEQ, 6 , '', ' / ') )) ||" ).append("\n"); 
		query.append("MAX(DECODE( B.ROUT_DTL_SEQ, 7, NVL( AGMT.AGMT_REF_NO, 'N/A')|| DECODE( D.MAX_SEQ, 7 , '', ' / ') )) ||" ).append("\n"); 
		query.append("MAX(DECODE( B.ROUT_DTL_SEQ, 8, NVL( AGMT.AGMT_REF_NO, 'N/A')|| DECODE( D.MAX_SEQ, 8 , '', ' / ') )) REF_NO ," ).append("\n"); 
		query.append("'' IRG_DROPDOWNLIST" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("PRD_INLND_ROUT_MST A," ).append("\n"); 
		query.append("PRD_INLND_ROUT_DTL B," ).append("\n"); 
		query.append("MDM_VENDOR C," ).append("\n"); 
		query.append("TRS_AGMT_HDR AGMT," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("A.ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("A.ROUT_SEQ," ).append("\n"); 
		query.append("C.MIN_SEQ MIN_SEQ," ).append("\n"); 
		query.append("ROUT_DTL_SEQ MAX_SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("PRD_INLND_ROUT_DTL A," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("ROUT_SEQ," ).append("\n"); 
		query.append("ROUT_DTL_SEQ MIN_SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("PRD_INLND_ROUT_DTL" ).append("\n"); 
		query.append("WHERE LNK_ORG_NOD_CD = ${lnk_org_nod_cd.get($key)}" ).append("\n"); 
		query.append("AND 	ROUT_ORG_NOD_CD = ${rout_org_nod_cd.get($key)}" ).append("\n"); 
		query.append("AND 	ROUT_DEST_NOD_CD = ${rout_dest_nod_cd.get($key)}" ).append("\n"); 
		query.append("AND 	ROUT_SEQ = ${rout_seq.get($key)}" ).append("\n"); 
		query.append("AND 	TRSP_MOD_CD='RD'" ).append("\n"); 
		query.append(") C" ).append("\n"); 
		query.append("WHERE LNK_DEST_NOD_CD = ${lnk_dest_nod_cd.get($key)}" ).append("\n"); 
		query.append("AND 	A.ROUT_ORG_NOD_CD = C.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("AND 	A.ROUT_DEST_NOD_CD = C.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("AND 	A.ROUT_SEQ = C.ROUT_SEQ" ).append("\n"); 
		query.append("AND 	TRSP_MOD_CD='RD'" ).append("\n"); 
		query.append(") D" ).append("\n"); 
		query.append("WHERE A.ROUT_ORG_NOD_CD = B.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("AND 	A.ROUT_DEST_NOD_CD = B.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("AND 	A.ROUT_SEQ = B.ROUT_SEQ" ).append("\n"); 
		query.append("AND 	B.TRSP_AGMT_OFC_CTY_CD = AGMT.TRSP_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND 	B.TRSP_AGMT_SEQ =AGMT.TRSP_AGMT_SEQ(+)" ).append("\n"); 
		query.append("AND 	NVL(A.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND 	B.TRSP_MOD_CD='RD'" ).append("\n"); 
		query.append("AND 	B.VNDR_SEQ = C.VNDR_SEQ" ).append("\n"); 
		query.append("AND 	B.ROUT_ORG_NOD_CD = D.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("AND 	B.ROUT_DEST_NOD_CD = D.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("AND 	B.ROUT_SEQ = D.ROUT_SEQ" ).append("\n"); 
		query.append("AND 	B.ROUT_DTL_SEQ >= D.MIN_SEQ" ).append("\n"); 
		query.append("AND 	B.ROUT_DTL_SEQ <= D.MAX_SEQ" ).append("\n"); 
		query.append("GROUP BY A.PRIO_SEQ, A.INLND_ROUT_RMK, A.ROUT_PLN_CD, A.ROUT_ORG_NOD_CD, A.ROUT_DEST_NOD_CD, A.ROUT_SEQ, B.TRSP_MOD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("${trsp_bnd_cd.get($key)} TRSP_BND_CD," ).append("\n"); 
		query.append("DECODE(${bkg_rcvde_term_cd.get($key)}, 'D', 'DOOR', 'CY') BKG_RCVDE_TERM_CD ," ).append("\n"); 
		query.append("#if(${trsp_bnd_cd.get($key)} == \"'O'\")" ).append("\n"); 
		query.append("${key_dest.get($key)} POLPOD," ).append("\n"); 
		query.append("#elseif(${trsp_bnd_cd.get($key)} == \"'I'\")" ).append("\n"); 
		query.append("${key_org.get($key)} POLPOD," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("${key_org.get($key)} KEY_ORG," ).append("\n"); 
		query.append("${key_dest.get($key)} KEY_DEST," ).append("\n"); 
		query.append("${cgo_tp_cd.get($key)} CGO_TP_CD," ).append("\n"); 
		query.append("SUBSTR(${lnk_org_nod_cd.get($key)}, 1, 5) FM_NOD_CD," ).append("\n"); 
		query.append("SUBSTR(${lnk_org_nod_cd.get($key)}, 6) FM_NOD_YARD," ).append("\n"); 
		query.append("SUBSTR(${lnk_dest_nod_cd.get($key)}, 1, 5) TO_NOD_CD," ).append("\n"); 
		query.append("SUBSTR(${lnk_dest_nod_cd.get($key)}, 6) TO_NOD_YARD," ).append("\n"); 
		query.append("A.PRIO_SEQ," ).append("\n"); 
		query.append("A.INLND_ROUT_RMK INLND_ROUT_RMK," ).append("\n"); 
		query.append("${lnk_org_nod_cd.get($key)} FROM_NODE," ).append("\n"); 
		query.append("${lnk_dest_nod_cd.get($key)} TO_NODE," ).append("\n"); 
		query.append("A.ROUT_PLN_CD ROUT_PLN_CD," ).append("\n"); 
		query.append("A.ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("A.ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("A.ROUT_SEQ," ).append("\n"); 
		query.append("A.ROUT_ORG_NOD_CD ROUT_ORG_SET," ).append("\n"); 
		query.append("A.ROUT_DEST_NOD_CD ROUT_DEST_SET," ).append("\n"); 
		query.append("A.ROUT_SEQ ROUT_SEQ_SET," ).append("\n"); 
		query.append("MAX( A.INLND_ROUT_INV_BIL_PATT_CD) RAIL_CMB_THRU_TP_CD," ).append("\n"); 
		query.append("MAX( DECODE( B.ROUT_DTL_SEQ, 1, DECODE( B.LNK_ORG_NOD_CD, ${lnk_org_nod_cd.get($key)}, B.LNK_ORG_NOD_CD)||'-('||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD ) )||" ).append("\n"); 
		query.append("MAX( DECODE( B.ROUT_DTL_SEQ, 2, DECODE( B.LNK_ORG_NOD_CD, ${lnk_org_nod_cd.get($key)}, B.LNK_ORG_NOD_CD)||'-('||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD ) )||" ).append("\n"); 
		query.append("MAX( DECODE( B.ROUT_DTL_SEQ, 3, DECODE( B.LNK_ORG_NOD_CD, ${lnk_org_nod_cd.get($key)}, B.LNK_ORG_NOD_CD)||'-('||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD ) )||" ).append("\n"); 
		query.append("MAX( DECODE( B.ROUT_DTL_SEQ, 4, DECODE( B.LNK_ORG_NOD_CD, ${lnk_org_nod_cd.get($key)}, B.LNK_ORG_NOD_CD)||'-('||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD ) )||" ).append("\n"); 
		query.append("MAX( DECODE( B.ROUT_DTL_SEQ, 5, DECODE( B.LNK_ORG_NOD_CD, ${lnk_org_nod_cd.get($key)}, B.LNK_ORG_NOD_CD)||'-('||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD ) )||" ).append("\n"); 
		query.append("MAX( DECODE( B.ROUT_DTL_SEQ, 6, DECODE( B.LNK_ORG_NOD_CD, ${lnk_org_nod_cd.get($key)}, B.LNK_ORG_NOD_CD)||'-('||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD ) )||" ).append("\n"); 
		query.append("MAX( DECODE( B.ROUT_DTL_SEQ, 7, DECODE( B.LNK_ORG_NOD_CD, ${lnk_org_nod_cd.get($key)}, B.LNK_ORG_NOD_CD)||'-('||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD ) )||" ).append("\n"); 
		query.append("MAX( DECODE( B.ROUT_DTL_SEQ, 8, DECODE( B.LNK_ORG_NOD_CD, ${lnk_org_nod_cd.get($key)}, B.LNK_ORG_NOD_CD)||'-('||C.VNDR_ABBR_NM||')-'||B.LNK_DEST_NOD_CD ) )IRG," ).append("\n"); 
		query.append("MAX(DECODE( B.ROUT_DTL_SEQ, 1, NVL( AGMT.AGMT_REF_NO, 'N/A')|| DECODE( D.MAX_SEQ, 1 , '', ' / ') )) ||" ).append("\n"); 
		query.append("MAX(DECODE( B.ROUT_DTL_SEQ, 2, NVL( AGMT.AGMT_REF_NO, 'N/A')|| DECODE( D.MAX_SEQ, 2 , '', ' / ') )) ||" ).append("\n"); 
		query.append("MAX(DECODE( B.ROUT_DTL_SEQ, 3, NVL( AGMT.AGMT_REF_NO, 'N/A')|| DECODE( D.MAX_SEQ, 3 , '', ' / ') )) ||" ).append("\n"); 
		query.append("MAX(DECODE( B.ROUT_DTL_SEQ, 4, NVL( AGMT.AGMT_REF_NO, 'N/A')|| DECODE( D.MAX_SEQ, 4 , '', ' / ') )) ||" ).append("\n"); 
		query.append("MAX(DECODE( B.ROUT_DTL_SEQ, 5, NVL( AGMT.AGMT_REF_NO, 'N/A')|| DECODE( D.MAX_SEQ, 5 , '', ' / ') )) ||" ).append("\n"); 
		query.append("MAX(DECODE( B.ROUT_DTL_SEQ, 6, NVL( AGMT.AGMT_REF_NO, 'N/A')|| DECODE( D.MAX_SEQ, 6 , '', ' / ') )) ||" ).append("\n"); 
		query.append("MAX(DECODE( B.ROUT_DTL_SEQ, 7, NVL( AGMT.AGMT_REF_NO, 'N/A')|| DECODE( D.MAX_SEQ, 7 , '', ' / ') )) ||" ).append("\n"); 
		query.append("MAX(DECODE( B.ROUT_DTL_SEQ, 8, NVL( AGMT.AGMT_REF_NO, 'N/A')|| DECODE( D.MAX_SEQ, 8 , '', ' / ') )) REF_NO ," ).append("\n"); 
		query.append("'' IRG_DROPDOWNLIST" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("PRD_INLND_ROUT_MST A," ).append("\n"); 
		query.append("PRD_INLND_ROUT_DTL B," ).append("\n"); 
		query.append("MDM_VENDOR C," ).append("\n"); 
		query.append("TRS_AGMT_HDR AGMT," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("A.ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("A.ROUT_SEQ," ).append("\n"); 
		query.append("C.MIN_SEQ MIN_SEQ," ).append("\n"); 
		query.append("ROUT_DTL_SEQ MAX_SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("PRD_INLND_ROUT_DTL A," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("ROUT_SEQ," ).append("\n"); 
		query.append("ROUT_DTL_SEQ MIN_SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("PRD_INLND_ROUT_DTL" ).append("\n"); 
		query.append("WHERE LNK_ORG_NOD_CD = ${lnk_org_nod_cd.get($key)}" ).append("\n"); 
		query.append("AND 	ROUT_ORG_NOD_CD = ${rout_org_nod_cd.get($key)}" ).append("\n"); 
		query.append("AND 	ROUT_DEST_NOD_CD = ${rout_dest_nod_cd.get($key)}" ).append("\n"); 
		query.append("AND 	ROUT_SEQ = ${rout_seq.get($key)}" ).append("\n"); 
		query.append("AND 	TRSP_MOD_CD='RD'" ).append("\n"); 
		query.append(") C" ).append("\n"); 
		query.append("WHERE LNK_DEST_NOD_CD = ${lnk_dest_nod_cd.get($key)}" ).append("\n"); 
		query.append("AND 	A.ROUT_ORG_NOD_CD = C.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("AND 	A.ROUT_DEST_NOD_CD = C.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("AND 	A.ROUT_SEQ = C.ROUT_SEQ" ).append("\n"); 
		query.append("AND 	TRSP_MOD_CD='RD'" ).append("\n"); 
		query.append(") D" ).append("\n"); 
		query.append("WHERE A.ROUT_ORG_NOD_CD = B.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("AND 	A.ROUT_DEST_NOD_CD = B.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("AND 	A.ROUT_SEQ = B.ROUT_SEQ" ).append("\n"); 
		query.append("AND 	B.TRSP_AGMT_OFC_CTY_CD = AGMT.TRSP_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND 	B.TRSP_AGMT_SEQ =AGMT.TRSP_AGMT_SEQ(+)" ).append("\n"); 
		query.append("AND 	NVL(A.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND 	B.TRSP_MOD_CD='RD'" ).append("\n"); 
		query.append("AND 	B.VNDR_SEQ = C.VNDR_SEQ" ).append("\n"); 
		query.append("AND 	B.ROUT_ORG_NOD_CD = D.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("AND 	B.ROUT_DEST_NOD_CD = D.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("AND 	B.ROUT_SEQ = D.ROUT_SEQ" ).append("\n"); 
		query.append("AND 	B.ROUT_DTL_SEQ >= D.MIN_SEQ" ).append("\n"); 
		query.append("AND 	B.ROUT_DTL_SEQ <= D.MAX_SEQ" ).append("\n"); 
		query.append("GROUP BY A.PRIO_SEQ, A.INLND_ROUT_RMK, A.ROUT_PLN_CD, A.ROUT_ORG_NOD_CD, A.ROUT_DEST_NOD_CD, A.ROUT_SEQ, B.TRSP_MOD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
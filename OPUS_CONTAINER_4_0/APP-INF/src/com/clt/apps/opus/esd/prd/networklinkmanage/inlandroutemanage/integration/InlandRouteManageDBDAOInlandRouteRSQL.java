/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InlandRouteManageDBDAOInlandRouteRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandRouteManageDBDAOInlandRouteRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * inland select
	  * </pre>
	  */
	public InlandRouteManageDBDAOInlandRouteRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_org_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_dest_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.integration").append("\n"); 
		query.append("FileName : InlandRouteManageDBDAOInlandRouteRSQL").append("\n"); 
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
		query.append("SELECT                                                                                                        " ).append("\n"); 
		query.append("              rout_org_nod_cd, rout_dest_nod_cd, rn, INLND_ROUT_BKG_FLG  , INLND_ROUT_TMP_FLG,INLND_ROUT_INCL_STTL_FLG,                                  " ).append("\n"); 
		query.append("              org_loc,  org_loc_type,                                                                                          " ).append("\n"); 
		query.append("              dest_loc,  dest_loc_type,                                                                                        " ).append("\n"); 
		query.append("              rout_seq, nvl(prio_seq,0) prio_seq, route,                                                                                       " ).append("\n"); 
		query.append("              sum_tt_time, sum_dw_tt ,                                                         " ).append("\n"); 
		query.append("              ltrim(to_char(trunc(tot_tt/24,0),'00'))||ltrim(to_char(mod(tot_tt,24  ),'00'))  tot_tt," ).append("\n"); 
		query.append("              PCTL_IO_BND_CD,                                                                                             " ).append("\n"); 
		query.append("              N1ST_NOD_CD,N1ST_TRSP_MOD_CD,N1ST_VNDR_SEQ,N1ST_VNDR_NM,N1ST_AGMT_NO,N1ST_agmt_cre_ofc_cd,N1ST_AGMT_REF_NO,            " ).append("\n"); 
		query.append("              N2ND_NOD_CD,N2ND_TRSP_MOD_CD,N2ND_VNDR_SEQ,N2ND_VNDR_NM,N2ND_AGMT_NO,N2ND_agmt_cre_ofc_cd,N2ND_AGMT_REF_NO,          " ).append("\n"); 
		query.append("              N3RD_NOD_CD,N3RD_TRSP_MOD_CD,N3RD_VNDR_SEQ,N3RD_VNDR_NM,N3RD_AGMT_NO,N3RD_agmt_cre_ofc_cd,N3RD_AGMT_REF_NO,          " ).append("\n"); 
		query.append("              N4TH_NOD_CD,N4TH_TRSP_MOD_CD,N4TH_VNDR_SEQ,N4TH_VNDR_NM,N4TH_AGMT_NO,N4TH_agmt_cre_ofc_cd,N4TH_AGMT_REF_NO,          " ).append("\n"); 
		query.append("              N5TH_NOD_CD,N5TH_TRSP_MOD_CD,N5TH_VNDR_SEQ,N5TH_VNDR_NM,N5TH_AGMT_NO,N5TH_agmt_cre_ofc_cd,N5TH_AGMT_REF_NO,          " ).append("\n"); 
		query.append("              N6TH_NOD_CD,N6TH_TRSP_MOD_CD,N6TH_VNDR_SEQ,N6TH_VNDR_NM,N6TH_AGMT_NO,N6TH_agmt_cre_ofc_cd,N6TH_AGMT_REF_NO,N7TH_NOD_CD,          " ).append("\n"); 
		query.append("              CRE_OFC_CD,TO_CHAR(CRE_DT,'YYYY-MM-DD') CRE_DT,INLND_ROUT_RMK, cnst_rmk, decode(cnst_rmk,null,'1','0') cnst_flg," ).append("\n"); 
		query.append("              '' hub_search_gb, '' front_gb , '' undefine_nod,                                                                 " ).append("\n"); 
		query.append("              max(rn) OVER (PARTITION BY rout_org_nod_cd, rout_dest_nod_cd  ORDER BY rout_org_nod_cd, rout_dest_nod_cd) AS group_gubun                                                                " ).append("\n"); 
		query.append("         FROM (                                                                                                                " ).append("\n"); 
		query.append("           SELECT rout_org_nod_cd, rout_dest_nod_cd, INLND_ROUT_BKG_FLG ,INLND_ROUT_TMP_FLG ,rownum rn, INLND_ROUT_INCL_STTL_FLG,                       " ).append("\n"); 
		query.append("                substr( rout_org_nod_cd,1,5) org_loc, substr( rout_org_nod_cd,6) org_loc_type,                                 " ).append("\n"); 
		query.append("                substr( rout_dest_nod_cd,1,5) dest_loc, substr( rout_dest_nod_cd,6) dest_loc_type,                             " ).append("\n"); 
		query.append("                rout_seq, prio_seq, route,                                                                                     " ).append("\n"); 
		query.append("                sum_tt_time, sum_dw_tt , (sum_tt_time + sum_dw_tt) tot_tt," ).append("\n"); 
		query.append("                N1ST_NOD_CD,N1ST_TRSP_MOD_CD,N1ST_VNDR_SEQ,N1ST_VNDR_NM,N1ST_AGMT_NO,N1ST_agmt_cre_ofc_cd,N1ST_AGMT_REF_NO,        " ).append("\n"); 
		query.append("                N2ND_NOD_CD,N2ND_TRSP_MOD_CD,N2ND_VNDR_SEQ,N2ND_VNDR_NM,N2ND_AGMT_NO,N2ND_agmt_cre_ofc_cd,N2ND_AGMT_REF_NO,        " ).append("\n"); 
		query.append("                N3RD_NOD_CD,N3RD_TRSP_MOD_CD,N3RD_VNDR_SEQ,N3RD_VNDR_NM,N3RD_AGMT_NO,N3RD_agmt_cre_ofc_cd,N3RD_AGMT_REF_NO,        " ).append("\n"); 
		query.append("                N4TH_NOD_CD,N4TH_TRSP_MOD_CD,N4TH_VNDR_SEQ,N4TH_VNDR_NM,N4TH_AGMT_NO,N4TH_agmt_cre_ofc_cd,N4TH_AGMT_REF_NO,        " ).append("\n"); 
		query.append("                N5TH_NOD_CD,N5TH_TRSP_MOD_CD,N5TH_VNDR_SEQ,N5TH_VNDR_NM,N5TH_AGMT_NO,N5TH_agmt_cre_ofc_cd,N5TH_AGMT_REF_NO,        " ).append("\n"); 
		query.append("                N6TH_NOD_CD,N6TH_TRSP_MOD_CD,N6TH_VNDR_SEQ,N6TH_VNDR_NM,N6TH_AGMT_NO,N6TH_agmt_cre_ofc_cd,N6TH_AGMT_REF_NO,N7TH_NOD_CD,        " ).append("\n"); 
		query.append("                PCTL_IO_BND_CD, CRE_OFC_CD,CRE_DT,INLND_ROUT_RMK, cnst_rmk" ).append("\n"); 
		query.append("           FROM (                                                                                                              " ).append("\n"); 
		query.append("             SELECT rout_org_nod_cd, rout_dest_nod_cd, rout_seq, prio_seq ,INLND_ROUT_BKG_FLG ,INLND_ROUT_TMP_FLG ,INLND_ROUT_INCL_STTL_FLG             " ).append("\n"); 
		query.append("                    ,rout_org_nod_cd || ' ( ' ||                                                                               " ).append("\n"); 
		query.append("                    MAX(DECODE ( cnt,1 ,(DECODE(rout_dtl_seq ,1 , trsp_mod , ''  )),                                           " ).append("\n"); 
		query.append("                                              (DECODE(rout_dtl_seq ,1 , trsp_mod , ''  ))) ) || ' ) ' ||                       " ).append("\n"); 
		query.append("                    MAX(DECODE(cnt,1,'', DECODE(cnt,1 ,'', DECODE(rout_dtl_seq, 1 , '-'||lnk_dest_nod_cd || ' ( '))))     ||   " ).append("\n"); 
		query.append("                    MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,2 , trsp_mod  || ' ) ', ''  ))) )  ||                      " ).append("\n"); 
		query.append("                    MAX(DECODE(cnt,1,'', DECODE(cnt,2 ,'', DECODE(rout_dtl_seq, 2 , '-'||lnk_dest_nod_cd || ' ( '))))     ||   " ).append("\n"); 
		query.append("                    MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,3 , trsp_mod || ' ) ', ''  ))) )   ||                      " ).append("\n"); 
		query.append("                    MAX(DECODE(cnt,1,'', DECODE(cnt,3 ,'', DECODE(rout_dtl_seq, 3 , '-'||lnk_dest_nod_cd  || ' ( '))))    ||   " ).append("\n"); 
		query.append("                    MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,4 , trsp_mod  || ' ) ', ''  ))) )  ||                      " ).append("\n"); 
		query.append("                    MAX(DECODE(cnt,1,'', DECODE(cnt,4 ,'', DECODE(rout_dtl_seq, 4 , '-'||lnk_dest_nod_cd  || ' ( '))))    ||   " ).append("\n"); 
		query.append("                    MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,5 , trsp_mod || ' ) ', ''  ))) )  ||                       " ).append("\n"); 
		query.append("                    MAX(DECODE(cnt,1,'', DECODE(cnt,5 ,'', DECODE(rout_dtl_seq, 5 , '-'||lnk_dest_nod_cd  || ' ( '))))    ||   " ).append("\n"); 
		query.append("                    MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,6 , trsp_mod || ' ) ', ''  ))) )    ||                     " ).append("\n"); 
		query.append("                    MAX(DECODE(cnt,1,'', DECODE(cnt,6 ,'', DECODE(rout_dtl_seq, 6 , '-'||lnk_dest_nod_cd  || ' ( ' ))))   ||   " ).append("\n"); 
		query.append("                    MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,7 , trsp_mod || ' ) ', ''  ))) )    ||                     " ).append("\n"); 
		query.append("                    MAX(DECODE(cnt,1,'', DECODE(cnt,7 ,'', DECODE(rout_dtl_seq, 7 , '-'||lnk_dest_nod_cd  || ' ( '))))    ||   " ).append("\n"); 
		query.append("                    MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,8 , trsp_mod || ' ) ', ''  ))) )    ||                     " ).append("\n"); 
		query.append("                    MAX(DECODE(cnt,1,'', DECODE(cnt,8 ,'', DECODE(rout_dtl_seq, 8 , '-'||lnk_dest_nod_cd  || ' ( '))))    ||   " ).append("\n"); 
		query.append("                    MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,9 , trsp_mod || ' ) ' , ''  ))) )  ||                      " ).append("\n"); 
		query.append("                    MAX(DECODE(cnt,1,'', DECODE(cnt,9 ,'', DECODE(rout_dtl_seq, 9 , '-'||lnk_dest_nod_cd  || ' ( '))))    ||   " ).append("\n"); 
		query.append("                    MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,10, trsp_mod || ' ) ', ''  ))) )    ||                     " ).append("\n"); 
		query.append("                    MAX(DECODE(cnt,1,'', DECODE(cnt,10,'', DECODE(rout_dtl_seq, 10, '-'||lnk_dest_nod_cd || ' ( '))))     ||   " ).append("\n"); 
		query.append("                    MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,11, trsp_mod || ' ) ' , ''  ))) )  ||                      " ).append("\n"); 
		query.append("                    MAX(DECODE(cnt,1,'', DECODE(cnt,11,'', DECODE(rout_dtl_seq, 11, '-'||lnk_dest_nod_cd || ' ( '))))     ||   " ).append("\n"); 
		query.append("                    MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,12, trsp_mod || ' ) ', ''  ))) )    ||                     " ).append("\n"); 
		query.append("                    MAX(DECODE(cnt,1,'', DECODE(cnt,12,'', DECODE(rout_dtl_seq, 12, '-'||lnk_dest_nod_cd || ' ( '))))     ||   " ).append("\n"); 
		query.append("                    MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,13, trsp_mod || ' ) ', ''  ))) )    ||                     " ).append("\n"); 
		query.append("                    MAX(DECODE(cnt,1,'', DECODE(cnt,13,'', DECODE(rout_dtl_seq, 13, '-'||lnk_dest_nod_cd || ' ( '))))     ||   " ).append("\n"); 
		query.append("                    MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,14, trsp_mod || ' ) ', ''  ))) )    ||                     " ).append("\n"); 
		query.append("                    MAX(DECODE(cnt,1,'', DECODE(cnt,14,'', DECODE(rout_dtl_seq, 14, '-'||lnk_dest_nod_cd  || ' ( '))))    ||   " ).append("\n"); 
		query.append("                    MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,15, trsp_mod || ' ) ', ''  ))) )    ||                     " ).append("\n"); 
		query.append("                    MAX(DECODE(cnt,1,'', DECODE(cnt,15,'', DECODE(rout_dtl_seq, 15, '-'||lnk_dest_nod_cd || ' ( '))))     ||   " ).append("\n"); 
		query.append("                    MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,16, trsp_mod || ' ) ', ''  ))) )    ||                     " ).append("\n"); 
		query.append("                    MAX(DECODE(cnt,1,'', DECODE(cnt,16,'', DECODE(rout_dtl_seq, 16, '-'||lnk_dest_nod_cd  || ' ( ' ))))   ||   " ).append("\n"); 
		query.append("                    MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,17, trsp_mod || ' ) ', ''  ))) )    ||                     " ).append("\n"); 
		query.append("                    MAX(DECODE(cnt,1,'', DECODE(cnt,17,'', DECODE(rout_dtl_seq, 17, '-'||lnk_dest_nod_cd || ' ( '))))     ||   " ).append("\n"); 
		query.append("                    MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,18, trsp_mod || ' ) ', ''  ))) )    ||                     " ).append("\n"); 
		query.append("                    MAX(DECODE(cnt,1,'', DECODE(cnt,18,'', DECODE(rout_dtl_seq, 18, '-'||lnk_dest_nod_cd || ' ( '))))     ||   " ).append("\n"); 
		query.append("                    MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,19, trsp_mod || ' ) ', ''  ))) )    ||                     " ).append("\n"); 
		query.append("                    MAX(DECODE(cnt,1,'', DECODE(cnt,19,'', DECODE(rout_dtl_seq, 19, '-'||lnk_dest_nod_cd || ' ( '))))     ||   " ).append("\n"); 
		query.append("                    MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,20, trsp_mod || ' ) ', ''  ))) )    ||                     " ).append("\n"); 
		query.append("                    MAX(DECODE(cnt,1,'', DECODE(cnt,20,'', DECODE(rout_dtl_seq, 20, '-'||lnk_dest_nod_cd))))                   " ).append("\n"); 
		query.append("                    ||  '-'||rout_dest_nod_cd as route                                                                         " ).append("\n"); 
		query.append("                    , rout_org_nod_cd AS pod0                                                                                  " ).append("\n"); 
		query.append("                    , rout_dest_nod_cd AS del, sum_tt_time,                                                                    " ).append("\n"); 
		query.append("              MAX(DECODE ( cnt,1 , DECODE(rout_dtl_seq ,1 , dest_dw_time , 0  ),                          " ).append("\n"); 
		query.append("                                      DECODE(rout_dtl_seq ,1 , dest_dw_time, 0  )) )  +                   " ).append("\n"); 
		query.append("              MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,2 , dest_dw_time, 0  )) )   +                   " ).append("\n"); 
		query.append("              MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,3 , dest_dw_time, 0  )) )   +                   " ).append("\n"); 
		query.append("              MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,4 , dest_dw_time, 0  )) )   +                   " ).append("\n"); 
		query.append("              MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,5 , dest_dw_time, 0  )) )   +                   " ).append("\n"); 
		query.append("              MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,6 , dest_dw_time, 0  )) )   +                   " ).append("\n"); 
		query.append("              MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,7 , dest_dw_time, 0  )) )   +                   " ).append("\n"); 
		query.append("              MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,8 , dest_dw_time, 0  )) )   +                   " ).append("\n"); 
		query.append("              MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,9 , dest_dw_time, 0  )) )   +                   " ).append("\n"); 
		query.append("              MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,10 , dest_dw_time, 0  )) )   +                  " ).append("\n"); 
		query.append("              MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,11 , dest_dw_time, 0  )) )   +                  " ).append("\n"); 
		query.append("              MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,12 , dest_dw_time, 0  )) )   +                  " ).append("\n"); 
		query.append("              MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,13 , dest_dw_time, 0  )) )   +                  " ).append("\n"); 
		query.append("              MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,14 , dest_dw_time, 0  )) )   +                  " ).append("\n"); 
		query.append("              MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,15 , dest_dw_time, 0  )) )   +                  " ).append("\n"); 
		query.append("              MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,16 , dest_dw_time, 0  )) )   +                  " ).append("\n"); 
		query.append("              MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,17 , dest_dw_time, 0  )) )   +                  " ).append("\n"); 
		query.append("              MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,18 , dest_dw_time, 0  )) )   +                  " ).append("\n"); 
		query.append("              MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,19 , dest_dw_time, 0  )) )   +                  " ).append("\n"); 
		query.append("              MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,20 , dest_dw_time, 0  )) )   sum_dw_tt ,        " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              MAX(DECODE(rout_dtl_seq,1,lnk_org_nod_cd)) n1st_nod_cd,                                          " ).append("\n"); 
		query.append("              MAX(DECODE(rout_dtl_seq,1,trsp_mod_cd)) n1st_trsp_mod_cd,                                        " ).append("\n"); 
		query.append("              MAX(DECODE(rout_dtl_seq,1,vndr_seq)) n1st_vndr_seq,                                              " ).append("\n"); 
		query.append("              MAX(DECODE(rout_dtl_seq,1,vndr_nm)) n1st_vndr_nm,                                                " ).append("\n"); 
		query.append("              MAX(DECODE(rout_dtl_seq,1,agmt_no)) n1st_agmt_no,                                                " ).append("\n"); 
		query.append("              MAX(DECODE(rout_dtl_seq,1,agmt_cre_ofc_cd)) n1st_agmt_cre_ofc_cd,                                        " ).append("\n"); 
		query.append("              MAX(DECODE(rout_dtl_seq,1,AGMT_REF_NO)) n1st_agmt_ref_no,                                        " ).append("\n"); 
		query.append("              MAX(DECODE(cnt,1,rout_dest_nod_cd,DECODE(rout_dtl_seq,2,lnk_org_nod_cd))) n2nd_nod_cd,           " ).append("\n"); 
		query.append("              MAX(DECODE(rout_dtl_seq,2,trsp_mod_cd)) n2nd_trsp_mod_cd,                                        " ).append("\n"); 
		query.append("              MAX(DECODE(rout_dtl_seq,2,vndr_seq)) n2nd_vndr_seq,                                              " ).append("\n"); 
		query.append("              MAX(DECODE(rout_dtl_seq,2,vndr_nm)) n2nd_vndr_nm,                                                " ).append("\n"); 
		query.append("              MAX(DECODE(rout_dtl_seq,2,agmt_no)) n2nd_agmt_no,                                                " ).append("\n"); 
		query.append("              MAX(DECODE(rout_dtl_seq,2,agmt_cre_ofc_cd)) n2nd_agmt_cre_ofc_cd,                                        " ).append("\n"); 
		query.append("              MAX(DECODE(rout_dtl_seq,2,AGMT_REF_NO)) n2nd_agmt_ref_no,                                        " ).append("\n"); 
		query.append("              MAX(DECODE(cnt,2,rout_dest_nod_cd,DECODE(rout_dtl_seq,3,lnk_org_nod_cd))) n3rd_nod_cd,           " ).append("\n"); 
		query.append("              MAX(DECODE(rout_dtl_seq,3,trsp_mod_cd)) n3rd_trsp_mod_cd,                                        " ).append("\n"); 
		query.append("              MAX(DECODE(rout_dtl_seq,3,vndr_seq)) n3rd_vndr_seq,                                              " ).append("\n"); 
		query.append("              MAX(DECODE(rout_dtl_seq,3,vndr_nm)) n3rd_vndr_nm,                                                " ).append("\n"); 
		query.append("              MAX(DECODE(rout_dtl_seq,3,agmt_no)) n3rd_agmt_no,                                                " ).append("\n"); 
		query.append("              MAX(DECODE(rout_dtl_seq,3,agmt_cre_ofc_cd)) n3rd_agmt_cre_ofc_cd,                                        " ).append("\n"); 
		query.append("              MAX(DECODE(rout_dtl_seq,3,AGMT_REF_NO)) n3rd_agmt_ref_no,                                        " ).append("\n"); 
		query.append("              MAX(DECODE(cnt,3,rout_dest_nod_cd,DECODE(rout_dtl_seq,4,lnk_org_nod_cd))) n4th_nod_cd,           " ).append("\n"); 
		query.append("              MAX(DECODE(rout_dtl_seq,4,trsp_mod_cd)) n4th_trsp_mod_cd,                                        " ).append("\n"); 
		query.append("              MAX(DECODE(rout_dtl_seq,4,vndr_seq)) n4th_vndr_seq,                                              " ).append("\n"); 
		query.append("              MAX(DECODE(rout_dtl_seq,4,vndr_nm)) n4th_vndr_nm,                                                " ).append("\n"); 
		query.append("              MAX(DECODE(rout_dtl_seq,4,agmt_no)) n4th_agmt_no,                                                " ).append("\n"); 
		query.append("              MAX(DECODE(rout_dtl_seq,4,agmt_cre_ofc_cd)) n4th_agmt_cre_ofc_cd,                                        " ).append("\n"); 
		query.append("              MAX(DECODE(rout_dtl_seq,4,AGMT_REF_NO)) n4th_agmt_ref_no,                                        " ).append("\n"); 
		query.append("              MAX(DECODE(cnt,4,rout_dest_nod_cd,DECODE(rout_dtl_seq,5,lnk_org_nod_cd))) n5th_nod_cd,           " ).append("\n"); 
		query.append("              MAX(DECODE(rout_dtl_seq,5,trsp_mod_cd)) n5th_trsp_mod_cd,                                        " ).append("\n"); 
		query.append("              MAX(DECODE(rout_dtl_seq,5,vndr_seq)) n5th_vndr_seq,                                              " ).append("\n"); 
		query.append("              MAX(DECODE(rout_dtl_seq,5,vndr_nm)) n5th_vndr_nm,                                                " ).append("\n"); 
		query.append("              MAX(DECODE(rout_dtl_seq,5,agmt_no)) n5th_agmt_no,                                                " ).append("\n"); 
		query.append("              MAX(DECODE(rout_dtl_seq,5,agmt_cre_ofc_cd)) n5th_agmt_cre_ofc_cd,                                        " ).append("\n"); 
		query.append("              MAX(DECODE(rout_dtl_seq,5,AGMT_REF_NO)) n5th_agmt_ref_no,                                        " ).append("\n"); 
		query.append("              MAX(DECODE(cnt,5,rout_dest_nod_cd,DECODE(rout_dtl_seq,6,lnk_org_nod_cd))) n6th_nod_cd,           " ).append("\n"); 
		query.append("              MAX(DECODE(rout_dtl_seq,6,trsp_mod_cd)) n6th_trsp_mod_cd,                                        " ).append("\n"); 
		query.append("              MAX(DECODE(rout_dtl_seq,6,vndr_seq)) n6th_vndr_seq,                                              " ).append("\n"); 
		query.append("              MAX(DECODE(rout_dtl_seq,6,vndr_nm)) n6th_vndr_nm,                                                " ).append("\n"); 
		query.append("              MAX(DECODE(rout_dtl_seq,6,agmt_no)) n6th_agmt_no,                                                " ).append("\n"); 
		query.append("               MAX(DECODE(rout_dtl_seq,6,agmt_cre_ofc_cd)) n6th_agmt_cre_ofc_cd,                                       " ).append("\n"); 
		query.append("              MAX(DECODE(rout_dtl_seq,6,AGMT_REF_NO)) n6th_agmt_ref_no,                                        " ).append("\n"); 
		query.append("              MAX(DECODE(rout_dtl_seq,6,lnk_dest_nod_cd)) n7th_nod_cd,                                        " ).append("\n"); 
		query.append("              PCTL_IO_BND_CD, CRE_OFC_CD,CRE_DT,INLND_ROUT_RMK,  MIN(cnst_rmk) cnst_rmk" ).append("\n"); 
		query.append("                 FROM (                                                                                                        " ).append("\n"); 
		query.append("                       SELECT rout_org_nod_cd, rout_dest_nod_cd, rout_seq, prio_seq,INLND_ROUT_BKG_FLG ,INLND_ROUT_TMP_FLG,INLND_ROUT_INCL_STTL_FLG,    " ).append("\n"); 
		query.append("                              rout_dtl_seq, cnt,lnk_org_nod_cd, lnk_dest_nod_cd,trsp_mod_cd,                                   " ).append("\n"); 
		query.append("                              DECODE(trsp_mod_cd,'TD','TRUCK','RD','RAIL','WD','WATER',trsp_mod_cd) trsp_mod,                   " ).append("\n"); 
		query.append("                              tztm_hrs link_tt_time ,sum_tt_time, org_dw_time,nvl(dest_dw_time,0) dest_dw_time, " ).append("\n"); 
		query.append("                              VNDR_SEQ,VNDR_NM,AGMT_NO,AGMT_REF_NO,agmt_cre_ofc_cd,                                            " ).append("\n"); 
		query.append("                              PCTL_IO_BND_CD, CRE_OFC_CD,CRE_DT,INLND_ROUT_RMK,        										" ).append("\n"); 
		query.append("                              DECODE(lnk_cnst_rmk,'', '', lnk_cnst_rmk||CHR(13))||nod_cnst_rmk cnst_rmk       					" ).append("\n"); 
		query.append("                         FROM (                                                                                                " ).append("\n"); 
		query.append("                           SELECT m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq, decode(m.prio_seq,0,null,m.prio_seq) prio_seq,m.INLND_ROUT_BKG_FLG  , INLND_ROUT_INCL_STTL_FLG,       " ).append("\n"); 
		query.append("                                d.lnk_org_nod_cd,d.lnk_dest_nod_cd, d.rout_dtl_seq,d.trsp_mod_cd,l.tztm_hrs,                   " ).append("\n"); 
		query.append("                                COUNT (*) OVER (PARTITION BY m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq ORDER BY m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq) AS cnt                          " ).append("\n"); 
		query.append("                                ,SUM(l.tztm_hrs) OVER(PARTITION BY m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq ORDER BY m.rout_org_nod_cd,m.rout_dest_nod_cd, m.rout_seq) AS sum_tt_time,                  " ).append("\n"); 
		query.append("                                (SELECT nvl(dry_avg_dwll_hrs,0)  FROM mdm_yard WHERE yd_cd = d.lnk_org_nod_cd ) org_dw_time,   " ).append("\n"); 
		query.append("                                (SELECT nvl(dry_avg_dwll_hrs,0)  FROM mdm_yard WHERE yd_cd = d.lnk_dest_nod_cd ) dest_dw_time  " ).append("\n"); 
		query.append("                                ,INLND_ROUT_TMP_FLG" ).append("\n"); 
		query.append("                                ,lpad(d.vndr_seq,6,0) vndr_seq, v.VNDR_LGL_ENG_NM vndr_nm,                                     " ).append("\n"); 
		query.append("                                (CASE WHEN D.TRSP_AGMT_OFC_CTY_CD IS NOT NULL THEN a.TRSP_AGMT_OFC_CTY_CD||lpad(a.TRSP_AGMT_SEQ,6,'0')                                 " ).append("\n"); 
		query.append("                                      WHEN D.TRSP_AGMT_OFC_CTY_CD IS NULL THEN (SELECT max(TRSP_AGMT_OFC_CTY_CD||lpad(TRSP_AGMT_SEQ,6,'0'))                            " ).append("\n"); 
		query.append("                                                                                FROM TRS_AGMT_APLY_VNDR                                                           " ).append("\n"); 
		query.append("                                                                                WHERE VNDR_SEQ = D.vndr_seq                                                            " ).append("\n"); 
		query.append("                                                                                )                                                                                      " ).append("\n"); 
		query.append("                                 END) agmt_no,                                                                                                                         " ).append("\n"); 
		query.append("                                (CASE WHEN  D.TRSP_AGMT_OFC_CTY_CD IS NOT NULL THEN a.AGMT_REF_NO                                                                      " ).append("\n"); 
		query.append("                                      WHEN  D.TRSP_AGMT_OFC_CTY_CD IS NULL THEN (SELECT AGMT_REF_NO FROM TRS_AGMT_HDR B                                           " ).append("\n"); 
		query.append("                                                                                 WHERE (TRSP_AGMT_OFC_CTY_CD,TRSP_AGMT_SEQ) =                                          " ).append("\n"); 
		query.append("                                                                                  (                                                                                                                                               " ).append("\n"); 
		query.append("                                                                                   SELECT substr(max(TRSP_AGMT_OFC_CTY_CD||lpad(TRSP_AGMT_SEQ,6,'0')),1,3),            " ).append("\n"); 
		query.append("                                                                                          to_number(substr(max(TRSP_AGMT_OFC_CTY_CD||lpad(TRSP_AGMT_SEQ,6,'0')),4,6))  " ).append("\n"); 
		query.append("                                                                                   FROM TRS_AGMT_APLY_VNDR                                                        " ).append("\n"); 
		query.append("                                                                                   WHERE VNDR_SEQ = D.vndr_seq                                                         " ).append("\n"); 
		query.append("                                                                                   )                                                                                   " ).append("\n"); 
		query.append("                                                                                 )                                                                                     " ).append("\n"); 
		query.append("                                 END) AGMT_REF_NO,                                                                                                                     " ).append("\n"); 
		query.append("                                (CASE WHEN  D.TRSP_AGMT_OFC_CTY_CD IS NOT NULL THEN a.CRE_OFC_CD                                                                       " ).append("\n"); 
		query.append("                                      WHEN  D.TRSP_AGMT_OFC_CTY_CD IS NULL THEN (SELECT CRE_OFC_CD FROM TRS_AGMT_HDR B                                            " ).append("\n"); 
		query.append("                                                                                 WHERE (TRSP_AGMT_OFC_CTY_CD,TRSP_AGMT_SEQ) =                                          " ).append("\n"); 
		query.append("                                                                                  (                                                                                                                                                      " ).append("\n"); 
		query.append("                                                                                   SELECT substr(max(TRSP_AGMT_OFC_CTY_CD||lpad(TRSP_AGMT_SEQ,6,'0')),1,3),            " ).append("\n"); 
		query.append("                                                                                          to_number(substr(max(TRSP_AGMT_OFC_CTY_CD||lpad(TRSP_AGMT_SEQ,6,'0')),4,6))  " ).append("\n"); 
		query.append("                                                                                   FROM TRS_AGMT_APLY_VNDR                                                        " ).append("\n"); 
		query.append("                                                                                   WHERE VNDR_SEQ = D.vndr_seq                                                         " ).append("\n"); 
		query.append("                                                                                   )                                                                                   " ).append("\n"); 
		query.append("                                                                                 )                                                                                     " ).append("\n"); 
		query.append("                                END) agmt_cre_ofc_cd,                                                                                                                  " ).append("\n"); 
		query.append("                                m.PCTL_IO_BND_CD, m.CRE_OFC_CD,m.CRE_DT,m.INLND_ROUT_RMK,                                       " ).append("\n"); 
		query.append("        						(select 'Link : '||																																" ).append("\n"); 
		query.append("        								decode(svc_use_flg, 'N', 																												" ).append("\n"); 
		query.append("        								'Your booking route is \"No Service\" area from Network Constraint. Please double check with your supervisor.'||CHR(13), '')||			" ).append("\n"); 
		query.append("        								CHR(9)||lnk_org_nod_cd || ' - ' ||																										" ).append("\n"); 
		query.append("        								lnk_dest_nod_cd || ' : ' ||																												" ).append("\n"); 
		query.append("        								pctl_cnst_itm_nm || ' - ' ||lnk_cnst_rmk 																								" ).append("\n"); 
		query.append("        						 from prd_lnk_cnst_mgmt c																														" ).append("\n"); 
		query.append("        						 where d.lnk_org_nod_cd like c.lnk_org_nod_cd||'%'																								" ).append("\n"); 
		query.append("        						 and d.lnk_dest_nod_cd like c.lnk_dest_nod_cd ||'%'" ).append("\n"); 
		query.append("                                 and nvl(c.delt_flg ,'N') <> 'Y'" ).append("\n"); 
		query.append("								 and NVL(c.spcl_cgo_cntr_tp_cd, 'AL') = DECODE(m.pctl_io_bnd_cd, 'M', 'AL', NVL(c.spcl_cgo_cntr_tp_cd, 'AL'))  																							" ).append("\n"); 
		query.append("        						 and d.trsp_mod_cd = c.trsp_mod_cd " ).append("\n"); 
		query.append("								 and rownum = 1" ).append("\n"); 
		query.append("								) lnk_cnst_rmk,																				" ).append("\n"); 
		query.append("        						(select distinct 'Node : '||" ).append("\n"); 
		query.append("        								DECODE(INSTR(d.lnk_org_nod_cd,org.nod_cd), 1,					 																		" ).append("\n"); 
		query.append("        										decode(org.svc_use_flg, 'N', 																									" ).append("\n"); 
		query.append("        										'Your booking route is \"No Service\" area from Network Constraint. Please double check with your supervisor.'||CHR(13), '')||	" ).append("\n"); 
		query.append("        										CHR(9)||org.nod_cd || ' - ' ||																									" ).append("\n"); 
		query.append("        										org.pctl_cnst_itm_nm || ' - ' ||org.nod_cnst_rmk||CHR(13), '')||" ).append("\n"); 
		query.append("        								DECODE(INSTR(d.lnk_dest_nod_cd,dest.nod_cd), 1,					 																		" ).append("\n"); 
		query.append("        									decode(dest.svc_use_flg, 'N', 																										" ).append("\n"); 
		query.append("        									'Your booking route is \"No Service\" area from Network Constraint. Please double check with your supervisor.'||CHR(13), '')||		" ).append("\n"); 
		query.append("        									CHR(9)||dest.nod_cd || ' - ' ||																										" ).append("\n"); 
		query.append("        									dest.pctl_cnst_itm_nm || ' - ' ||dest.nod_cnst_rmk, '')																				" ).append("\n"); 
		query.append("        						 FROM prd_nod_cnst_mgmt org, prd_nod_cnst_mgmt dest																								" ).append("\n"); 
		query.append("        						 WHERE ( d.lnk_org_nod_cd like org.nod_cd || '%' OR d.lnk_dest_nod_cd like dest.nod_cd || '%' )" ).append("\n"); 
		query.append("                                 AND NVL(org.delt_flg ,'N') <> 'Y'" ).append("\n"); 
		query.append("                                 AND NVL(dest.delt_flg ,'N') <> 'Y'" ).append("\n"); 
		query.append("								 AND NVL(org.spcl_cgo_cntr_tp_cd, 'AL') = DECODE(m.pctl_io_bnd_cd, 'M', 'AL', NVL(org.spcl_cgo_cntr_tp_cd, 'AL'))" ).append("\n"); 
		query.append("								 AND NVL(dest.spcl_cgo_cntr_tp_cd, 'AL') = DECODE(m.pctl_io_bnd_cd, 'M', 'AL', NVL(dest.spcl_cgo_cntr_tp_cd, 'AL'))" ).append("\n"); 
		query.append("                   				 AND (	decode(org.port_pnt_cd, 'POR', 'PORPOL', 'POL', 'PORPOL', 'POD', 'PODDEL', 'DEL', 'PODDEL') =" ).append("\n"); 
		query.append("                       					decode(org.port_pnt_cd, 'ALL', 'ALL', decode(m.pctl_io_bnd_cd, 'O', 'PORPOL', 'I', 'PODDEL', 'B', 'ALL', 'M', '')) " ).append("\n"); 
		query.append("                       					OR" ).append("\n"); 
		query.append("                       					decode(dest.port_pnt_cd, 'POR', 'PORPOL', 'POL', 'PORPOL', 'POD', 'PODDEL', 'DEL', 'PODDEL') =" ).append("\n"); 
		query.append("                       					decode(dest.port_pnt_cd, 'ALL', 'ALL', decode(m.pctl_io_bnd_cd, 'O', 'PORPOL', 'I', 'PODDEL', 'B', 'ALL', 'M', '')))" ).append("\n"); 
		query.append("                   				AND rownum = 1" ).append("\n"); 
		query.append("								) nod_cnst_rmk" ).append("\n"); 
		query.append("                           FROM prd_inlnd_rout_mst m, prd_inlnd_rout_dtl d, prd_inlnd_each_lnk l,mdm_vendor v, TRS_AGMT_HDR a  " ).append("\n"); 
		query.append("                           WHERE m.rout_org_nod_cd LIKE @[i_org_cd] ||'%'                                                                 " ).append("\n"); 
		query.append("                             AND m.rout_dest_nod_cd LIKE @[i_dest_cd] ||'%'" ).append("\n"); 
		query.append("                             AND NVL(m.DELT_FLG,'N') ='N'" ).append("\n"); 
		query.append("                             AND m.rout_org_nod_cd = d.rout_org_nod_cd                                                         " ).append("\n"); 
		query.append("                             AND m.rout_dest_nod_cd = d.rout_dest_nod_cd                                                       " ).append("\n"); 
		query.append("                             AND m.rout_seq = d.rout_seq                                                                       " ).append("\n"); 
		query.append("                             AND d.lnk_org_nod_cd = l.lnk_org_nod_cd                                                           " ).append("\n"); 
		query.append("                             AND d.lnk_dest_nod_cd = l.lnk_dest_nod_cd                                                         " ).append("\n"); 
		query.append("                             AND d.trsp_mod_cd = l.trsp_mod_cd                                                                 " ).append("\n"); 
		query.append("                             AND d.TRSP_AGMT_OFC_CTY_CD = a.TRSP_AGMT_OFC_CTY_CD(+)                                            " ).append("\n"); 
		query.append("                             AND d.TRSP_AGMT_SEQ = a.TRSP_AGMT_SEQ(+)                                                          " ).append("\n"); 
		query.append("                             AND d.vndr_seq = v.vndr_seq(+) " ).append("\n"); 
		query.append("#if ( ${r_inbound} == 'I' )" ).append("\n"); 
		query.append("        					AND m.PCTL_IO_BND_CD ='I'" ).append("\n"); 
		query.append("                            AND EXISTS ( SELECT 'X' FROM PRD_NODE N  WHERE N.NOD_CD = M.ROUT_ORG_NOD_CD ) " ).append("\n"); 
		query.append("                            AND EXISTS ( SELECT 'X' FROM PRD_NODE N  WHERE N.NOD_CD = M.rout_dest_nod_cd )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${r_inbound} == 'O')" ).append("\n"); 
		query.append("        					AND m.PCTL_IO_BND_CD ='O'" ).append("\n"); 
		query.append("                            AND EXISTS ( SELECT 'X' FROM PRD_NODE N  WHERE N.NOD_CD = M.rout_dest_nod_cd ) " ).append("\n"); 
		query.append("                            AND EXISTS ( SELECT 'X' FROM PRD_NODE N  WHERE N.NOD_CD = M.ROUT_ORG_NOD_CD  ) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${r_inbound} == 'B')" ).append("\n"); 
		query.append("							AND m.PCTL_IO_BND_CD ='B' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${r_inbound} == 'M')" ).append("\n"); 
		query.append("							AND m.PCTL_IO_BND_CD ='M'" ).append("\n"); 
		query.append("#end        	" ).append("\n"); 
		query.append("							ORDER BY m.rout_seq, d.rout_dtl_seq                                                " ).append("\n"); 
		query.append("                           )                                                                                              " ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("                          ) m                                                                                             " ).append("\n"); 
		query.append("                 GROUP BY m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq, m.prio_seq,sum_tt_time,INLND_ROUT_BKG_FLG,INLND_ROUT_TMP_FLG,M.INLND_ROUT_INCL_STTL_FLG,    " ).append("\n"); 
		query.append("                          m.PCTL_IO_BND_CD, m.CRE_OFC_CD,m.CRE_DT,m.INLND_ROUT_RMK			                             " ).append("\n"); 
		query.append("                 ORDER BY rout_org_nod_cd, rout_dest_nod_cd, prio_seq                                                     " ).append("\n"); 
		query.append("                 )                                                                                                        " ).append("\n"); 
		query.append("            )                                                                                                             " ).append("\n"); 
		query.append("            ORDER BY   rn" ).append("\n"); 

	}
}
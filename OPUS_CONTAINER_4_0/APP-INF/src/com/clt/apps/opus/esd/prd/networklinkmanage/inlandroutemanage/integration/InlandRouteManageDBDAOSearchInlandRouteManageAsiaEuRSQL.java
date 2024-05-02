/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InlandRouteManageDBDAOSearchInlandRouteManageAsiaEuRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.23
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.23 
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

public class InlandRouteManageDBDAOSearchInlandRouteManageAsiaEuRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchInlandRouteManageAsiaEu
	  * </pre>
	  */
	public InlandRouteManageDBDAOSearchInlandRouteManageAsiaEuRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_del_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nod_tp_cd1",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : InlandRouteManageDBDAOSearchInlandRouteManageAsiaEuRSQL").append("\n"); 
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
		query.append("SELECT T1.*" ).append("\n"); 
		query.append("  ,regexp_substr(T1.agr_str, '[^ |]+', 1, 1) curr_cd" ).append("\n"); 
		query.append("  ,regexp_substr(T1.agr_str, '[^ |]+', 1, 2) ttl_cost" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("	      PRD_GET_INLND_AGMT_RT_FNC(rout_org_nod_cd, rout_dest_nod_cd, rout_seq, 'E') agr_str,   " ).append("\n"); 
		query.append("	      MAX(TO_NUMBER(NVL(prio_seq,0))) OVER (PARTITION BY org_loc, dest_loc  ORDER BY org_loc, dest_loc) AS max_prio_seq, " ).append("\n"); 
		query.append("	      rout_org_nod_cd, rout_dest_nod_cd, rn, inlnd_rout_bkg_flg  , inlnd_rout_tmp_flg, inlnd_rout_incl_sttl_flg, " ).append("\n"); 
		query.append("	      org_loc,  org_loc_type,                                                                                         " ).append("\n"); 
		query.append("	      dest_loc,  dest_loc_type,                                                                                       " ).append("\n"); 
		query.append("	      rout_seq, nvl(prio_seq,0) prio_seq, route,                                                                                      " ).append("\n"); 
		query.append("	      sum_tt_time, sum_dw_tt ," ).append("\n"); 
		query.append("		  LTRIM(TO_CHAR(TRUNC(tot_tt/24,0),'00'))||LTRIM(TO_CHAR(MOD(tot_tt, 24),'00'))  tot_tt,                         " ).append("\n"); 
		query.append("	      '' hub_search_gb, '' front_gb , '' undefine_nod,                                                                " ).append("\n"); 
		query.append("	      MAX(rn) OVER (PARTITION BY rout_org_nod_cd, rout_dest_nod_cd  ORDER BY rout_org_nod_cd, rout_dest_nod_cd) AS group_gubun                                                               " ).append("\n"); 
		query.append("	      ,cre_usr_id,cre_ofc_cd,TO_CHAR(cre_dt,'YYYY-MM-DD') cre_dt,inlnd_rout_rmk , upd_usr_id,TO_CHAR(upd_dt,'YYYY-MM-DD') upd_dt  " ).append("\n"); 
		query.append("	 FROM (                                                                                                               " ).append("\n"); 
		query.append("	   SELECT rout_org_nod_cd, rout_dest_nod_cd, inlnd_rout_bkg_flg ,inlnd_rout_tmp_flg ,inlnd_rout_incl_sttl_flg,ROWNUM rn,                       " ).append("\n"); 
		query.append("		SUBSTR( rout_org_nod_cd,1,5) org_loc, SUBSTR( rout_org_nod_cd,6) org_loc_type,                                " ).append("\n"); 
		query.append("		SUBSTR( rout_dest_nod_cd,1,5) dest_loc, SUBSTR( rout_dest_nod_cd,6) dest_loc_type,                            " ).append("\n"); 
		query.append("		rout_seq, prio_seq, route, sum_tt_time, sum_dw_tt, (sum_tt_time + sum_dw_tt) tot_tt,                                                     " ).append("\n"); 
		query.append("		cre_usr_id,cre_ofc_cd,cre_dt ,inlnd_rout_rmk,upd_usr_id, upd_dt" ).append("\n"); 
		query.append("	   FROM (                                                                                                             " ).append("\n"); 
		query.append("	     SELECT rout_org_nod_cd, rout_dest_nod_cd, rout_seq, prio_seq ,INLND_ROUT_BKG_FLG ,INLND_ROUT_TMP_FLG,INLND_ROUT_INCL_STTL_FLG             " ).append("\n"); 
		query.append("		    ,rout_org_nod_cd || ' ( ' ||                                                                              " ).append("\n"); 
		query.append("		    MAX(DECODE ( cnt,1 ,(DECODE(rout_dtl_seq ,1 , trsp_mod , ''  )),(DECODE(rout_dtl_seq ,1 , trsp_mod , ''  ))) ) || ' ) ' ||                      " ).append("\n"); 
		query.append("		    MAX(DECODE(cnt,1,'', DECODE(cnt,1 ,'', DECODE(rout_dtl_seq, 1 , '-'||lnk_dest_nod_cd || ' ( '))))     ||  " ).append("\n"); 
		query.append("		    MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,2 , trsp_mod  || ' ) ', ''  ))) )  ||                     " ).append("\n"); 
		query.append("		    MAX(DECODE(cnt,1,'', DECODE(cnt,2 ,'', DECODE(rout_dtl_seq, 2 , '-'||lnk_dest_nod_cd || ' ( '))))     ||  " ).append("\n"); 
		query.append("		    MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,3 , trsp_mod || ' ) ', ''  ))) )   ||                     " ).append("\n"); 
		query.append("		    MAX(DECODE(cnt,1,'', DECODE(cnt,3 ,'', DECODE(rout_dtl_seq, 3 , '-'||lnk_dest_nod_cd  || ' ( '))))    ||  " ).append("\n"); 
		query.append("		    MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,4 , trsp_mod  || ' ) ', ''  ))) )  ||                     " ).append("\n"); 
		query.append("		    MAX(DECODE(cnt,1,'', DECODE(cnt,4 ,'', DECODE(rout_dtl_seq, 4 , '-'||lnk_dest_nod_cd  || ' ( '))))    ||  " ).append("\n"); 
		query.append("		    MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,5 , trsp_mod || ' ) ', ''  ))) )  ||                      " ).append("\n"); 
		query.append("		    MAX(DECODE(cnt,1,'', DECODE(cnt,5 ,'', DECODE(rout_dtl_seq, 5 , '-'||lnk_dest_nod_cd  || ' ( '))))    ||  " ).append("\n"); 
		query.append("		    MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,6 , trsp_mod || ' ) ', ''  ))) )    ||                    " ).append("\n"); 
		query.append("		    MAX(DECODE(cnt,1,'', DECODE(cnt,6 ,'', DECODE(rout_dtl_seq, 6 , '-'||lnk_dest_nod_cd  || ' ( ' ))))   ||  " ).append("\n"); 
		query.append("		    MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,7 , trsp_mod || ' ) ', ''  ))) )    ||                    " ).append("\n"); 
		query.append("		    MAX(DECODE(cnt,1,'', DECODE(cnt,7 ,'', DECODE(rout_dtl_seq, 7 , '-'||lnk_dest_nod_cd  || ' ( '))))    ||  " ).append("\n"); 
		query.append("		    MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,8 , trsp_mod || ' ) ', ''  ))) )    ||                    " ).append("\n"); 
		query.append("		    MAX(DECODE(cnt,1,'', DECODE(cnt,8 ,'', DECODE(rout_dtl_seq, 8 , '-'||lnk_dest_nod_cd  || ' ( '))))    ||  " ).append("\n"); 
		query.append("		    MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,9 , trsp_mod || ' ) ' , ''  ))) )  ||                     " ).append("\n"); 
		query.append("		    MAX(DECODE(cnt,1,'', DECODE(cnt,9 ,'', DECODE(rout_dtl_seq, 9 , '-'||lnk_dest_nod_cd  || ' ( '))))    ||  " ).append("\n"); 
		query.append("		    MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,10, trsp_mod || ' ) ', ''  ))) )    ||                    " ).append("\n"); 
		query.append("		    MAX(DECODE(cnt,1,'', DECODE(cnt,10,'', DECODE(rout_dtl_seq, 10, '-'||lnk_dest_nod_cd || ' ( '))))     ||  " ).append("\n"); 
		query.append("		    MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,11, trsp_mod || ' ) ' , ''  ))) )  ||                     " ).append("\n"); 
		query.append("		    MAX(DECODE(cnt,1,'', DECODE(cnt,11,'', DECODE(rout_dtl_seq, 11, '-'||lnk_dest_nod_cd || ' ( '))))     ||  " ).append("\n"); 
		query.append("		    MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,12, trsp_mod || ' ) ', ''  ))) )    ||                    " ).append("\n"); 
		query.append("		    MAX(DECODE(cnt,1,'', DECODE(cnt,12,'', DECODE(rout_dtl_seq, 12, '-'||lnk_dest_nod_cd || ' ( '))))     ||  " ).append("\n"); 
		query.append("		    MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,13, trsp_mod || ' ) ', ''  ))) )    ||                    " ).append("\n"); 
		query.append("		    MAX(DECODE(cnt,1,'', DECODE(cnt,13,'', DECODE(rout_dtl_seq, 13, '-'||lnk_dest_nod_cd || ' ( '))))     ||  " ).append("\n"); 
		query.append("		    MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,14, trsp_mod || ' ) ', ''  ))) )    ||                    " ).append("\n"); 
		query.append("		    MAX(DECODE(cnt,1,'', DECODE(cnt,14,'', DECODE(rout_dtl_seq, 14, '-'||lnk_dest_nod_cd  || ' ( '))))    ||  " ).append("\n"); 
		query.append("		    MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,15, trsp_mod || ' ) ', ''  ))) )    ||                    " ).append("\n"); 
		query.append("		    MAX(DECODE(cnt,1,'', DECODE(cnt,15,'', DECODE(rout_dtl_seq, 15, '-'||lnk_dest_nod_cd || ' ( '))))     ||  " ).append("\n"); 
		query.append("		    MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,16, trsp_mod || ' ) ', ''  ))) )    ||                    " ).append("\n"); 
		query.append("		    MAX(DECODE(cnt,1,'', DECODE(cnt,16,'', DECODE(rout_dtl_seq, 16, '-'||lnk_dest_nod_cd  || ' ( ' ))))   ||  " ).append("\n"); 
		query.append("		    MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,17, trsp_mod || ' ) ', ''  ))) )    ||                    " ).append("\n"); 
		query.append("		    MAX(DECODE(cnt,1,'', DECODE(cnt,17,'', DECODE(rout_dtl_seq, 17, '-'||lnk_dest_nod_cd || ' ( '))))     ||  " ).append("\n"); 
		query.append("		    MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,18, trsp_mod || ' ) ', ''  ))) )    ||                    " ).append("\n"); 
		query.append("		    MAX(DECODE(cnt,1,'', DECODE(cnt,18,'', DECODE(rout_dtl_seq, 18, '-'||lnk_dest_nod_cd || ' ( '))))     ||  " ).append("\n"); 
		query.append("		    MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,19, trsp_mod || ' ) ', ''  ))) )    ||                    " ).append("\n"); 
		query.append("		    MAX(DECODE(cnt,1,'', DECODE(cnt,19,'', DECODE(rout_dtl_seq, 19, '-'||lnk_dest_nod_cd || ' ( '))))     ||  " ).append("\n"); 
		query.append("		    MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,20, trsp_mod || ' ) ', ''  ))) )    ||                    " ).append("\n"); 
		query.append("		    MAX(DECODE(cnt,1,'', DECODE(cnt,20,'', DECODE(rout_dtl_seq, 20, '-'||lnk_dest_nod_cd))))                  " ).append("\n"); 
		query.append("		    ||  '-'||rout_dest_nod_cd as route                                                                        " ).append("\n"); 
		query.append("		    , rout_org_nod_cd AS pod0                                                                                 " ).append("\n"); 
		query.append("		    , rout_dest_nod_cd AS del, sum_tt_time,                                                                   " ).append("\n"); 
		query.append("	      MAX(DECODE ( cnt,1 , DECODE(rout_dtl_seq ,1 , dest_dw_time , 0  ), DECODE(rout_dtl_seq ,1 , dest_dw_time, 0  )) )  +                  " ).append("\n"); 
		query.append("	      MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,2 , dest_dw_time, 0  )) )   +                  " ).append("\n"); 
		query.append("	      MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,3 , dest_dw_time, 0  )) )   +                  " ).append("\n"); 
		query.append("	      MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,4 , dest_dw_time, 0  )) )   +                  " ).append("\n"); 
		query.append("	      MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,5 , dest_dw_time, 0  )) )   +                  " ).append("\n"); 
		query.append("	      MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,6 , dest_dw_time, 0  )) )   +                  " ).append("\n"); 
		query.append("	      MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,7 , dest_dw_time, 0  )) )   +                  " ).append("\n"); 
		query.append("	      MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,8 , dest_dw_time, 0  )) )   +                  " ).append("\n"); 
		query.append("	      MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,9 , dest_dw_time, 0  )) )   +                  " ).append("\n"); 
		query.append("	      MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,10 , dest_dw_time, 0  )) )   +                 " ).append("\n"); 
		query.append("	      MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,11 , dest_dw_time, 0  )) )   +                 " ).append("\n"); 
		query.append("	      MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,12 , dest_dw_time, 0  )) )   +                 " ).append("\n"); 
		query.append("	      MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,13 , dest_dw_time, 0  )) )   +                 " ).append("\n"); 
		query.append("	      MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,14 , dest_dw_time, 0  )) )   +                 " ).append("\n"); 
		query.append("	      MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,15 , dest_dw_time, 0  )) )   +                 " ).append("\n"); 
		query.append("	      MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,16 , dest_dw_time, 0  )) )   +                 " ).append("\n"); 
		query.append("	      MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,17 , dest_dw_time, 0  )) )   +                 " ).append("\n"); 
		query.append("	      MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,18 , dest_dw_time, 0  )) )   +                 " ).append("\n"); 
		query.append("	      MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,19 , dest_dw_time, 0  )) )   +                 " ).append("\n"); 
		query.append("	      MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,20 , dest_dw_time, 0  )) )   sum_dw_tt         " ).append("\n"); 
		query.append("	      ,MAX(DECODE(cnt,1, cre_usr_id, DECODE(rout_dtl_seq,1, cre_usr_id))) cre_usr_id         " ).append("\n"); 
		query.append("	      ,MAX(DECODE(cnt,1, cre_ofc_cd, DECODE(rout_dtl_seq,1, cre_ofc_cd))) cre_ofc_cd         " ).append("\n"); 
		query.append("	      ,MAX(DECODE(cnt,1, cre_dt, DECODE(rout_dtl_seq,1, cre_dt))) cre_dt         " ).append("\n"); 
		query.append("	      ,MAX(DECODE(cnt,1, inlnd_rout_rmk, DECODE(rout_dtl_seq,1, inlnd_rout_rmk))) inlnd_rout_rmk         " ).append("\n"); 
		query.append("	      ,MAX(DECODE(cnt,1, upd_usr_id, DECODE(rout_dtl_seq,1, upd_usr_id))) upd_usr_id     " ).append("\n"); 
		query.append("	      ,MAX(DECODE(cnt,1, upd_dt, DECODE(rout_dtl_seq,1, upd_dt))) upd_dt     " ).append("\n"); 
		query.append("		 FROM (    " ).append("\n"); 
		query.append("		       SELECT rout_org_nod_cd, rout_dest_nod_cd, rout_seq, prio_seq,inlnd_rout_bkg_flg ,inlnd_rout_tmp_flg,inlnd_rout_incl_sttl_flg,   " ).append("\n"); 
		query.append("			      rout_dtl_seq, cnt,lnk_org_nod_cd, lnk_dest_nod_cd,trsp_mod_cd,                                  " ).append("\n"); 
		query.append("			      DECODE(trsp_mod_cd,'TD','TRUCK','RD','RAIL','WD','WATER',trsp_mod_cd) trsp_mod,                              " ).append("\n"); 
		query.append("			      tztm_hrs link_tt_time ,sum_tt_time, org_dw_time,nvl(dest_dw_time,0) dest_dw_time                " ).append("\n"); 
		query.append("			      ,cre_usr_id,cre_ofc_cd,cre_dt ,inlnd_rout_rmk, upd_usr_id, upd_dt                " ).append("\n"); 
		query.append("			 FROM (                                                                                               " ).append("\n"); 
		query.append("			   SELECT m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq, DECODE(m.prio_seq,0,null,m.prio_seq) prio_seq, m.inlnd_rout_bkg_flg ,inlnd_rout_incl_sttl_flg,       " ).append("\n"); 
		query.append("				d.lnk_org_nod_cd,d.lnk_dest_nod_cd, d.rout_dtl_seq,d.trsp_mod_cd,l.tztm_hrs,                  " ).append("\n"); 
		query.append("				COUNT (*) OVER (PARTITION BY m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq ORDER BY m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq) AS cnt,                         " ).append("\n"); 
		query.append("				SUM(l.tztm_hrs) OVER(PARTITION BY m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq ORDER BY m.rout_org_nod_cd,m.rout_dest_nod_cd, m.rout_seq) AS sum_tt_time,                 " ).append("\n"); 
		query.append("				(SELECT nvl(dry_avg_dwll_hrs,0)  FROM mdm_yard WHERE yd_cd = d.lnk_org_nod_cd ) org_dw_time,  " ).append("\n"); 
		query.append("				(SELECT nvl(dry_avg_dwll_hrs,0)  FROM mdm_yard WHERE yd_cd = d.lnk_dest_nod_cd ) dest_dw_time, " ).append("\n"); 
		query.append("				inlnd_rout_tmp_flg,                                                                           " ).append("\n"); 
		query.append("				m.cre_usr_id,m.cre_ofc_cd,m.cre_dt ,m.inlnd_rout_rmk, m.upd_usr_id, m.upd_dt" ).append("\n"); 
		query.append("			   FROM prd_inlnd_rout_mst m, prd_inlnd_rout_dtl d, prd_inlnd_each_lnk l                              " ).append("\n"); 
		query.append("			   WHERE m.rout_org_nod_cd LIKE @[i_org_cd] ||'%'                                                                " ).append("\n"); 
		query.append("			     AND m.rout_dest_nod_cd LIKE @[i_dest_cd] ||'%' 								 " ).append("\n"); 
		query.append("			     AND NVL(m.DELT_FLG,'N') = nvl(@[i_del_flg], 'N') " ).append("\n"); 
		query.append("			     AND m.rout_org_nod_cd = d.rout_org_nod_cd                                                        " ).append("\n"); 
		query.append("			     AND m.rout_dest_nod_cd = d.rout_dest_nod_cd                                                      " ).append("\n"); 
		query.append("			     AND m.rout_seq = d.rout_seq                                                                      " ).append("\n"); 
		query.append("			     AND d.lnk_org_nod_cd = l.lnk_org_nod_cd                                                          " ).append("\n"); 
		query.append("			     AND d.lnk_dest_nod_cd = l.lnk_dest_nod_cd                                                        " ).append("\n"); 
		query.append("			     AND d.trsp_mod_cd = l.trsp_mod_cd                                                          " ).append("\n"); 
		query.append("	#if(${r_inbound} == 'I')    	" ).append("\n"); 
		query.append("				 AND m.pctl_io_bnd_cd ='I' " ).append("\n"); 
		query.append("				 AND EXISTS ( SELECT 'X' FROM PRD_NODE N  WHERE N.NOD_CD = M.ROUT_ORG_NOD_CD  AND  N.NOD_TP_CD  IN ( 'M','B' )) " ).append("\n"); 
		query.append("				 AND EXISTS ( SELECT 'X' FROM PRD_NODE N  WHERE N.NOD_CD = M.ROUT_DEST_NOD_CD AND  DECODE(N.NOD_TP_CD, 'Z', 'Z', 'X') = DECODE(@[nod_tp_cd1], 'Z', 'Z', 'X') ) " ).append("\n"); 
		query.append("	#elseif(${r_inbound} == 'O')  	" ).append("\n"); 
		query.append("				 AND m.pctl_io_bnd_cd ='O' " ).append("\n"); 
		query.append("				 AND EXISTS ( SELECT 'X' FROM PRD_NODE N  WHERE N.NOD_CD = M.ROUT_DEST_NOD_CD AND  N.NOD_TP_CD  IN ( 'M','B' )) " ).append("\n"); 
		query.append("				 AND EXISTS ( SELECT 'X' FROM PRD_NODE N  WHERE N.NOD_CD = M.ROUT_ORG_NOD_CD  AND  DECODE(N.NOD_TP_CD, 'Z', 'Z', 'X') = DECODE(@[nod_tp_cd1], 'Z', 'Z', 'X') ) 		" ).append("\n"); 
		query.append("	#elseif(${r_inbound} == 'B')  	 	" ).append("\n"); 
		query.append("				 AND m.pctl_io_bnd_cd = 'B' " ).append("\n"); 
		query.append("	#elseif(${r_inbound} == 'M')  	 	" ).append("\n"); 
		query.append("				 AND m.pctl_io_bnd_cd = 'M' " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("				 ORDER BY m.rout_seq, d.rout_dtl_seq                                               " ).append("\n"); 
		query.append("			   )" ).append("\n"); 
		query.append("			  ) m                                                                                            " ).append("\n"); 
		query.append("		 GROUP BY m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq, m.prio_seq,sum_tt_time,inlnd_rout_bkg_flg,inlnd_rout_tmp_flg,m.inlnd_rout_incl_sttl_flg   " ).append("\n"); 
		query.append("		 ORDER BY rout_org_nod_cd, rout_dest_nod_cd, prio_seq                                                    " ).append("\n"); 
		query.append("		 )                                                                                                       " ).append("\n"); 
		query.append("	    ) " ).append("\n"); 
		query.append(") T1	    " ).append("\n"); 
		query.append("ORDER BY   rn" ).append("\n"); 

	}
}
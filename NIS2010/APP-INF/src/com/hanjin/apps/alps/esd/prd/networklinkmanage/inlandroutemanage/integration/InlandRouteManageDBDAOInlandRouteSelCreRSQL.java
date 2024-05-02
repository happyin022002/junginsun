/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : InlandRouteManageDBDAOInlandRouteSelCreRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.10
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2011.11.10 박만건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Mangeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandRouteManageDBDAOInlandRouteSelCreRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InlandRouteSelCre
	  * </pre>
	  */
	public InlandRouteManageDBDAOInlandRouteSelCreRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_chk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_chk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("r_inbound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hub_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_dest_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.integration").append("\n"); 
		query.append("FileName : InlandRouteManageDBDAOInlandRouteSelCreRSQL").append("\n"); 
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
		query.append("select rout_org_nod_cd, rout_dest_nod_cd, rn, inlnd_rout_rmk," ).append("\n"); 
		query.append("     org_loc,  org_loc_type," ).append("\n"); 
		query.append("     dest_loc,  dest_loc_type," ).append("\n"); 
		query.append("     rout_seq, prio_seq," ).append("\n"); 
		query.append("     sum_tt_time, sum_dw_tt ,tot_tt,fr.trsp trsp_mod," ).append("\n"); 
		query.append("     ltrim(to_char(trunc(tot_tt/24,0),'00'))||ltrim(to_char(mod(tot_tt,24  ),'00')) fmt_tot_tt," ).append("\n"); 
		query.append("     'Y' hub_search_gb, fr.front_gb front_gb , NOD_CD undefine_nod, group_gubun, NOD_CD," ).append("\n"); 
		query.append("     decode(fr.front_gb,'F', NOD_CD||'( '||fr.trsp||' )'||'-'||route , route||'( '||fr.trsp||' )'||'-'||NOD_CD) route   ," ).append("\n"); 
		query.append("      firstMod" ).append("\n"); 
		query.append(" from (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     select" ).append("\n"); 
		query.append("         rout_org_nod_cd, rout_dest_nod_cd, rn, inlnd_rout_rmk," ).append("\n"); 
		query.append("         org_loc,  org_loc_type," ).append("\n"); 
		query.append("         dest_loc,  dest_loc_type," ).append("\n"); 
		query.append("         rout_seq, prio_seq, route," ).append("\n"); 
		query.append("         sum_tt_time, sum_dw_tt ,tot_tt," ).append("\n"); 
		query.append("         ltrim(to_char(trunc(tot_tt/24,0),'00'))||ltrim(to_char(mod(tot_tt,24  ),'00')) fmt_tot_tt," ).append("\n"); 
		query.append("         length(to_char(trunc(tot_tt/24,0),'00')||to_char(mod(tot_tt,24  ),'00')) aa," ).append("\n"); 
		query.append("         ltrim(to_char(trunc(tot_tt/24,0),'00')) bb,to_char(mod(tot_tt,24  ),'00') cc," ).append("\n"); 
		query.append("          '' hub_search_gb, '' front_gb , '' undefine_nod," ).append("\n"); 
		query.append("         max(rn) OVER (PARTITION BY rout_org_nod_cd, rout_dest_nod_cd  ORDER BY rout_org_nod_cd," ).append("\n"); 
		query.append("                           rout_dest_nod_cd) AS group_gubun," ).append("\n"); 
		query.append("         route  cre_route ,firstMod" ).append("\n"); 
		query.append("     from (" ).append("\n"); 
		query.append("       SELECT rout_org_nod_cd, rout_dest_nod_cd, rownum rn,inlnd_rout_rmk," ).append("\n"); 
		query.append("            substr( rout_org_nod_cd,1,5) org_loc, substr( rout_org_nod_cd,6) org_loc_type," ).append("\n"); 
		query.append("              substr( rout_dest_nod_cd,1,5) dest_loc, substr( rout_dest_nod_cd,6) dest_loc_type," ).append("\n"); 
		query.append("             rout_seq, prio_seq, route," ).append("\n"); 
		query.append("            sum_tt_time, sum_dw_tt , (sum_tt_time + sum_dw_tt) tot_tt ,firstMod" ).append("\n"); 
		query.append("       FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         SELECT   rout_org_nod_cd, rout_dest_nod_cd, rout_seq, prio_seq ,inlnd_rout_rmk" ).append("\n"); 
		query.append("                ,rout_org_nod_cd || ' ( ' ||" ).append("\n"); 
		query.append("                MAX(decode ( cnt,1 ,(decode(ROUT_DTL_SEQ ,1 , trsp_mod , ''  ))," ).append("\n"); 
		query.append("                                                             (decode(ROUT_DTL_SEQ ,1 , trsp_mod , ''  ))) ) || ' ) ' ||" ).append("\n"); 
		query.append("                MAX(DECODE(cnt,1,'', DECODE(cnt,1 ,'', DECODE(rout_dtl_seq, 1 , '-'||lnk_dest_nod_cd || ' ( '))))    ||" ).append("\n"); 
		query.append("                MAX(decode ( cnt,1 , '' , (decode(ROUT_DTL_SEQ ,2 , trsp_mod  || ' ) ', ''  ))) )  ||" ).append("\n"); 
		query.append("                MAX(DECODE(cnt,1,'', DECODE(cnt,2 ,'', DECODE(rout_dtl_seq, 2 , '-'||lnk_dest_nod_cd || ' ( '))))    ||" ).append("\n"); 
		query.append("                MAX(decode ( cnt,1 , '' , (decode(ROUT_DTL_SEQ ,3 , trsp_mod || ' ) ', ''  ))) )   ||" ).append("\n"); 
		query.append("                MAX(DECODE(cnt,1,'', DECODE(cnt,3 ,'', DECODE(rout_dtl_seq, 3 , '-'||lnk_dest_nod_cd  || ' ( '))))    ||" ).append("\n"); 
		query.append("                MAX(decode ( cnt,1 , '' , (decode(ROUT_DTL_SEQ ,4 , trsp_mod  || ' ) ', ''  ))) )  ||" ).append("\n"); 
		query.append("                MAX(DECODE(cnt,1,'', DECODE(cnt,4 ,'', DECODE(rout_dtl_seq, 4 , '-'||lnk_dest_nod_cd  || ' ( '))))    ||" ).append("\n"); 
		query.append("                MAX(decode ( cnt,1 , '' , (decode(ROUT_DTL_SEQ ,5 , trsp_mod || ' ) ', ''  ))) )  ||" ).append("\n"); 
		query.append("                MAX(DECODE(cnt,1,'', DECODE(cnt,5 ,'', DECODE(rout_dtl_seq, 5 , '-'||lnk_dest_nod_cd  || ' ( '))))    ||" ).append("\n"); 
		query.append("                MAX(decode ( cnt,1 , '' , (decode(ROUT_DTL_SEQ ,6 , trsp_mod || ' ) ', ''  ))) )    ||" ).append("\n"); 
		query.append("                MAX(DECODE(cnt,1,'', DECODE(cnt,6 ,'', DECODE(rout_dtl_seq, 6 , '-'||lnk_dest_nod_cd  || ' ( ' ))))   ||" ).append("\n"); 
		query.append("                MAX(decode ( cnt,1 , '' , (decode(ROUT_DTL_SEQ ,7 , trsp_mod || ' ) ', ''  ))) )    ||" ).append("\n"); 
		query.append("                MAX(DECODE(cnt,1,'', DECODE(cnt,7 ,'', DECODE(rout_dtl_seq, 7 , '-'||lnk_dest_nod_cd  || ' ( '))))    ||" ).append("\n"); 
		query.append("                MAX(decode ( cnt,1 , '' , (decode(ROUT_DTL_SEQ ,8 , trsp_mod || ' ) ', ''  ))) )    ||" ).append("\n"); 
		query.append("                MAX(DECODE(cnt,1,'', DECODE(cnt,8 ,'', DECODE(rout_dtl_seq, 8 , '-'||lnk_dest_nod_cd  || ' ( '))))    ||" ).append("\n"); 
		query.append("                MAX(decode ( cnt,1 , '' , (decode(ROUT_DTL_SEQ ,9 , trsp_mod || ' ) ' , ''  ))) )  ||" ).append("\n"); 
		query.append("                MAX(DECODE(cnt,1,'', DECODE(cnt,9 ,'', DECODE(rout_dtl_seq, 9 , '-'||lnk_dest_nod_cd  || ' ( '))))    ||" ).append("\n"); 
		query.append("                MAX(decode ( cnt,1 , '' , (decode(ROUT_DTL_SEQ ,10, trsp_mod || ' ) ', ''  ))) )    ||" ).append("\n"); 
		query.append("                MAX(DECODE(cnt,1,'', DECODE(cnt,10,'', DECODE(rout_dtl_seq, 10, '-'||lnk_dest_nod_cd || ' ( '))))     ||" ).append("\n"); 
		query.append("                MAX(decode ( cnt,1 , '' , (decode(ROUT_DTL_SEQ ,11, trsp_mod || ' ) ' , ''  ))) )  ||" ).append("\n"); 
		query.append("                MAX(DECODE(cnt,1,'', DECODE(cnt,11,'', DECODE(rout_dtl_seq, 11, '-'||lnk_dest_nod_cd || ' ( '))))     ||" ).append("\n"); 
		query.append("                MAX(decode ( cnt,1 , '' , (decode(ROUT_DTL_SEQ ,12, trsp_mod || ' ) ', ''  ))) )    ||" ).append("\n"); 
		query.append("                MAX(DECODE(cnt,1,'', DECODE(cnt,12,'', DECODE(rout_dtl_seq, 12, '-'||lnk_dest_nod_cd || ' ( '))))     ||" ).append("\n"); 
		query.append("                MAX(decode ( cnt,1 , '' , (decode(ROUT_DTL_SEQ ,13, trsp_mod || ' ) ', ''  ))) )    ||" ).append("\n"); 
		query.append("                MAX(DECODE(cnt,1,'', DECODE(cnt,13,'', DECODE(rout_dtl_seq, 13, '-'||lnk_dest_nod_cd || ' ( '))))     ||" ).append("\n"); 
		query.append("                MAX(decode ( cnt,1 , '' , (decode(ROUT_DTL_SEQ ,14, trsp_mod || ' ) ', ''  ))) )    ||" ).append("\n"); 
		query.append("                MAX(DECODE(cnt,1,'', DECODE(cnt,14,'', DECODE(rout_dtl_seq, 14, '-'||lnk_dest_nod_cd  || ' ( '))))    ||" ).append("\n"); 
		query.append("                MAX(decode ( cnt,1 , '' , (decode(ROUT_DTL_SEQ ,15, trsp_mod || ' ) ', ''  ))) )    ||" ).append("\n"); 
		query.append("                MAX(DECODE(cnt,1,'', DECODE(cnt,15,'', DECODE(rout_dtl_seq, 15, '-'||lnk_dest_nod_cd || ' ( '))))     ||" ).append("\n"); 
		query.append("                MAX(decode ( cnt,1 , '' , (decode(ROUT_DTL_SEQ ,16, trsp_mod || ' ) ', ''  ))) )    ||" ).append("\n"); 
		query.append("                MAX(DECODE(cnt,1,'', DECODE(cnt,16,'', DECODE(rout_dtl_seq, 16, '-'||lnk_dest_nod_cd  || ' ( ' ))))   ||" ).append("\n"); 
		query.append("                MAX(decode ( cnt,1 , '' , (decode(ROUT_DTL_SEQ ,17, trsp_mod || ' ) ', ''  ))) )    ||" ).append("\n"); 
		query.append("                MAX(DECODE(cnt,1,'', DECODE(cnt,17,'', DECODE(rout_dtl_seq, 17, '-'||lnk_dest_nod_cd || ' ( '))))     ||" ).append("\n"); 
		query.append("                MAX(decode ( cnt,1 , '' , (decode(ROUT_DTL_SEQ ,18, trsp_mod || ' ) ', ''  ))) )    ||" ).append("\n"); 
		query.append("                MAX(DECODE(cnt,1,'', DECODE(cnt,18,'', DECODE(rout_dtl_seq, 18, '-'||lnk_dest_nod_cd || ' ( '))))     ||" ).append("\n"); 
		query.append("                MAX(decode ( cnt,1 , '' , (decode(ROUT_DTL_SEQ ,19, trsp_mod || ' ) ', ''  ))) )    ||" ).append("\n"); 
		query.append("                MAX(DECODE(cnt,1,'', DECODE(cnt,19,'', DECODE(rout_dtl_seq, 19, '-'||lnk_dest_nod_cd || ' ( '))))     ||" ).append("\n"); 
		query.append("                MAX(decode ( cnt,1 , '' , (decode(ROUT_DTL_SEQ ,20, trsp_mod || ' ) ', ''  ))) )    ||" ).append("\n"); 
		query.append("                MAX(DECODE(cnt,1,'', DECODE(cnt,20,'', DECODE(rout_dtl_seq, 20, '-'||lnk_dest_nod_cd))))" ).append("\n"); 
		query.append("                ||  '-'||rout_dest_nod_cd as route" ).append("\n"); 
		query.append("                , rout_org_nod_cd AS pod0" ).append("\n"); 
		query.append("                , rout_dest_nod_cd AS del, sum_tt_time," ).append("\n"); 
		query.append("      MAX(DECODE ( cnt,1 , DECODE(rout_dtl_seq ,1 , dest_dw_time , 0  )," ).append("\n"); 
		query.append("                              DECODE(rout_dtl_seq ,1 , dest_dw_time, 0  )) )  +" ).append("\n"); 
		query.append("      MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,2 , dest_dw_time, 0  )) )   +" ).append("\n"); 
		query.append("      MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,3 , dest_dw_time, 0  )) )   +" ).append("\n"); 
		query.append("      MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,4 , dest_dw_time, 0  )) )   +" ).append("\n"); 
		query.append("      MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,5 , dest_dw_time, 0  )) )   +" ).append("\n"); 
		query.append("      MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,6 , dest_dw_time, 0  )) )   +" ).append("\n"); 
		query.append("      MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,7 , dest_dw_time, 0  )) )   +" ).append("\n"); 
		query.append("      MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,8 , dest_dw_time, 0  )) )   +" ).append("\n"); 
		query.append("      MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,9 , dest_dw_time, 0  )) )   +" ).append("\n"); 
		query.append("      MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,10 , dest_dw_time, 0  )) )   +" ).append("\n"); 
		query.append("      MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,11 , dest_dw_time, 0  )) )   +" ).append("\n"); 
		query.append("      MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,12 , dest_dw_time, 0  )) )   +" ).append("\n"); 
		query.append("      MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,13 , dest_dw_time, 0  )) )   +" ).append("\n"); 
		query.append("      MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,14 , dest_dw_time, 0  )) )   +" ).append("\n"); 
		query.append("      MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,15 , dest_dw_time, 0  )) )   +" ).append("\n"); 
		query.append("      MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,16 , dest_dw_time, 0  )) )   +" ).append("\n"); 
		query.append("      MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,17 , dest_dw_time, 0  )) )   +" ).append("\n"); 
		query.append("      MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,18 , dest_dw_time, 0  )) )   +" ).append("\n"); 
		query.append("      MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,19 , dest_dw_time, 0  )) )   +" ).append("\n"); 
		query.append("      MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,20 , dest_dw_time, 0  )) )   sum_dw_tt ," ).append("\n"); 
		query.append("      MAX(decode ( cnt,1 ,(decode(ROUT_DTL_SEQ ,1 , trsp_mod , ''  )), (decode(ROUT_DTL_SEQ ,1 , trsp_mod , ''  ))) ) firstMod" ).append("\n"); 
		query.append("             FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                   SELECT rout_org_nod_cd, rout_dest_nod_cd, rout_seq, prio_seq,inlnd_rout_rmk," ).append("\n"); 
		query.append("                          rout_dtl_seq, cnt,lnk_org_nod_cd, lnk_dest_nod_cd,trsp_mod_cd," ).append("\n"); 
		query.append("                          decode(trsp_mod_cd,'TD','TRUCK','RD','RAIL','WD','WATER',trsp_mod_cd) trsp_mod," ).append("\n"); 
		query.append("                          tztm_hrs link_tt_time ,sum_tt_time, org_dw_time,nvl(dest_dw_time,0) dest_dw_time" ).append("\n"); 
		query.append("                     FROM (" ).append("\n"); 
		query.append("                   SELECT   m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq, m.prio_seq," ).append("\n"); 
		query.append("                            d.lnk_org_nod_cd,d.lnk_dest_nod_cd, d.rout_dtl_seq,d.trsp_mod_cd," ).append("\n"); 
		query.append("                            COUNT (*) OVER (PARTITION BY m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq" ).append("\n"); 
		query.append("                            ORDER BY m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq) AS cnt," ).append("\n"); 
		query.append("                            l.tztm_hrs  ,m.inlnd_rout_rmk" ).append("\n"); 
		query.append("                            , sum(l.tztm_hrs) over(PARTITION BY m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq" ).append("\n"); 
		query.append("                            ORDER BY m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq) AS sum_tt_time" ).append("\n"); 
		query.append("                            ,nvl(DECODE(@[r_inbound], 'O', m1.OB_dry_avg_dwll_hrs,M1.IB_dry_avg_dwll_hrs),0) org_dw_time,  nvl(DECODE(@[r_inbound], 'O', m2.OB_dry_avg_dwll_hrs,m2.IB_dry_avg_dwll_hrs),0) dest_dw_time" ).append("\n"); 
		query.append("                       FROM prd_inlnd_rout_mst m, prd_inlnd_rout_dtl d, prd_inlnd_each_lnk l" ).append("\n"); 
		query.append("                            ,mdm_yard m1, mdm_yard m2" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                            , mdm_yard m3" ).append("\n"); 
		query.append("#if(${from_chk} =='Y')" ).append("\n"); 
		query.append("                      WHERE m.rout_org_nod_cd  LIKE @[i_org_cd]||'%'" ).append("\n"); 
		query.append("                        AND m.rout_dest_nod_cd LIKE @[hub_loc_cd]||'%'" ).append("\n"); 
		query.append("#elseif(${to_chk} == 'Y')" ).append("\n"); 
		query.append("					WHERE m.rout_org_nod_cd  LIKE @[hub_loc_cd]||'%'" ).append("\n"); 
		query.append("                        AND m.rout_dest_nod_cd LIKE @[i_dest_cd]||'%'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("					WHERE m.rout_org_nod_cd  LIKE '' ||'%'" ).append("\n"); 
		query.append("                        AND m.rout_dest_nod_cd LIKE '' ||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                        AND m.rout_org_nod_cd = d.rout_org_nod_cd" ).append("\n"); 
		query.append("                        AND m.rout_dest_nod_cd = d.rout_dest_nod_cd" ).append("\n"); 
		query.append("                        AND m.rout_seq = d.rout_seq" ).append("\n"); 
		query.append("#if(${from_chk} == 'Y')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              AND m.rout_dest_nod_cd = m3.YD_CD" ).append("\n"); 
		query.append("              AND m3.hub_yd_flg = 'Y'" ).append("\n"); 
		query.append("#elseif(${to_chk} == 'Y')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              AND m.rout_org_nod_cd = m3.YD_CD" ).append("\n"); 
		query.append("              AND m3.hub_yd_flg = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                        AND d.lnk_org_nod_cd = l.lnk_org_nod_cd" ).append("\n"); 
		query.append("                        AND d.lnk_dest_nod_cd = l.lnk_dest_nod_cd" ).append("\n"); 
		query.append("                        AND d.trsp_mod_cd = l.trsp_mod_cd" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${r_inbound} == 'I')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("						AND m.PCTL_IO_BND_CD ='I'" ).append("\n"); 
		query.append("                       AND EXISTS" ).append("\n"); 
		query.append("                            (" ).append("\n"); 
		query.append("                                SELECT 'X' FROM PRD_NODE N" ).append("\n"); 
		query.append("                                WHERE N.NOD_CD = M.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("                                AND  N.NOD_TP_CD  IN ( 'M','B' )" ).append("\n"); 
		query.append("                             )" ).append("\n"); 
		query.append("                       AND EXISTS" ).append("\n"); 
		query.append("                            (" ).append("\n"); 
		query.append("                                SELECT 'X' FROM PRD_NODE N" ).append("\n"); 
		query.append("                                WHERE N.NOD_CD = M.rout_dest_nod_cd" ).append("\n"); 
		query.append("	#if(${nod_tp1} == 'Z')" ).append("\n"); 
		query.append("                                AND  N.NOD_TP_CD  = 'Z'" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("                                AND  N.NOD_TP_CD  != 'Z'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("                             )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif(${r_inbound} == 'O')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("						AND m.PCTL_IO_BND_CD ='O'" ).append("\n"); 
		query.append("                       AND EXISTS" ).append("\n"); 
		query.append("                            (" ).append("\n"); 
		query.append("                                SELECT 'X' FROM PRD_NODE N" ).append("\n"); 
		query.append("                                WHERE N.NOD_CD = M.rout_dest_nod_cd" ).append("\n"); 
		query.append("                                AND  N.NOD_TP_CD  IN ( 'M','B' )" ).append("\n"); 
		query.append("                             )" ).append("\n"); 
		query.append("                       AND EXISTS" ).append("\n"); 
		query.append("                            (" ).append("\n"); 
		query.append("                                SELECT 'X' FROM PRD_NODE N" ).append("\n"); 
		query.append("                                WHERE N.NOD_CD = M.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("	#if(${nod_tp2} == 'Z')" ).append("\n"); 
		query.append("                                AND  N.NOD_TP_CD  = 'Z'" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("                                AND  N.NOD_TP_CD  != 'Z'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("                             )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("						AND m.PCTL_IO_BND_CD ='B'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                        and m1.YD_CD(+) = d.lnk_org_nod_cd" ).append("\n"); 
		query.append("                        and m2.YD_CD(+) = d.lnk_dest_nod_cd" ).append("\n"); 
		query.append("                   ORDER BY m.rout_seq, d.rout_dtl_seq" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          ) m" ).append("\n"); 
		query.append("         GROUP BY m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq, m.prio_seq,sum_tt_time ,m.inlnd_rout_rmk" ).append("\n"); 
		query.append("         ORDER BY rout_org_nod_cd, rout_dest_nod_cd, prio_seq" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("     ORDER BY  prio_seq" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" ) rout" ).append("\n"); 
		query.append(" ,(select nod_cd from PRD_NODE" ).append("\n"); 
		query.append("  	where loc_cd=DECODE (@[from_chk] ,'Y', SUBSTR(@[i_dest_cd],1,5), DECODE (@[to_chk], 'Y', SUBSTR(@[i_org_cd],1,5), ' '))" ).append("\n"); 
		query.append(" 		AND NOD_CD LIKE DECODE (@[from_chk],'Y', @[i_dest_cd], DECODE (@[to_chk], 'Y', @[i_org_cd], ' '))||'%'" ).append("\n"); 
		query.append(" 		AND  nvl(DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("#if(${r_inbound} == 'I')" ).append("\n"); 
		query.append("	#if(${nod_tp1} == 'Z')" ).append("\n"); 
		query.append("                                AND  NOD_TP_CD  = 'Z'" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("                                AND  NOD_TP_CD  != 'Z'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#elseif(${r_inbound}=='O')" ).append("\n"); 
		query.append("	#if(${nod_tp2}== 'Z')" ).append("\n"); 
		query.append("                                AND  NOD_TP_CD  = 'Z'" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("                                AND  NOD_TP_CD  != 'Z'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("#if(${from_chk} =='Y')" ).append("\n"); 
		query.append(" ,( select  'B'  front_gb, decode(@[trsp_mod_cd],'TD','TRUCK','RD','RAIL','WD','WATER')  trsp from dual where rownum = 1 ) fr" ).append("\n"); 
		query.append("#elseif(${to_chk} == 'Y')" ).append("\n"); 
		query.append(" ,( select  'F'  front_gb, decode(@[trsp_mod_cd],'TD','TRUCK','RD','RAIL','WD','WATER')  trsp from dual where rownum = 1 ) fr" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(" ,( select  ''  front_gb, decode('','TD','TRUCK','RD','RAIL','WD','WATER')  trsp from dual where rownum = 1 ) fr" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
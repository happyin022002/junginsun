/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : InlandRouteManageDBDAOlnlandRouteUSRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.20
*@LastModifier : 
*@LastVersion : 1.0
* 2012.09.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandRouteManageDBDAOlnlandRouteUSRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Inland Route Management USA FULL search
	  * </pre>
	  */
	public InlandRouteManageDBDAOlnlandRouteUSRSQL(){
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
		params.put("i_org_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_optm_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("r_btn_nod_ty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_dest_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_hub_loc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.integration").append("\n"); 
		query.append("FileName : InlandRouteManageDBDAOlnlandRouteUSRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("      max(to_number(nvl(prio_seq,0))) OVER (PARTITION BY org_loc, dest_loc  ORDER BY org_loc, dest_loc" ).append("\n"); 
		query.append("                         ) AS max_prio_seq  , " ).append("\n"); 
		query.append("      rout_org_nod_cd, rout_dest_nod_cd, rn, INLND_ROUT_BKG_FLG  , INLND_ROUT_TMP_FLG, INLND_ROUT_INCL_STTL_FLG," ).append("\n"); 
		query.append("      org_loc,  org_loc_type," ).append("\n"); 
		query.append("      dest_loc,  dest_loc_type," ).append("\n"); 
		query.append("      rout_seq, nvl(prio_seq,0) prio_seq , prio_seq ori_prio_seq ,  route," ).append("\n"); 
		query.append("      sum_tt_time, sum_dw_tt ,--tot_tt," ).append("\n"); 
		query.append("      ltrim(to_char(trunc(tot_tt/24,0),'00'))||ltrim(to_char(mod(tot_tt,24  ),'00'))  tot_tt," ).append("\n"); 
		query.append("      '' hub_search_gb, '' front_gb , '' undefine_nod," ).append("\n"); 
		query.append("      max(rn) OVER (PARTITION BY rout_org_nod_cd, rout_dest_nod_cd  ORDER BY rout_org_nod_cd," ).append("\n"); 
		query.append("                       rout_dest_nod_cd) AS group_gubun ," ).append("\n"); 
		query.append("      decode(trim(WRS_FULL_CMDT_CD),'',0,1) WRS_FULL_CMDT,WRS_FULL_CMDT_CD,cre_usr_id,cre_ofc_cd,to_char(cre_dt,'yyyy-mm-dd') cre_dt,HUB_LOC_CD,inlnd_rout_rmk ,HUB, DELT_FLG --SUBSTR(HUB,6) HUB  --JSY" ).append("\n"); 
		query.append("      ,ROUT_PLN_CD, UPD_USR_ID,to_char(UPD_DT,'yyyy-mm-dd') UPD_DT" ).append("\n"); 
		query.append("      ,INLND_ROUT_OPTM_FLG" ).append("\n"); 
		query.append("      ,LNK_KNT" ).append("\n"); 
		query.append("      ,INLND_TMNL_SHTL_FLG" ).append("\n"); 
		query.append("      , CASE WHEN @[r_inbound] IN ('M','B') THEN 'X'" ).append("\n"); 
		query.append("             WHEN INLND_ROUT_OPTM_FLG = 'N' THEN 'X' -- 의미 없음" ).append("\n"); 
		query.append("             ELSE NVL((SELECT 'N' FROM PRD_INLND_ROUT_MST INQU " ).append("\n"); 
		query.append("                       WHERE INQU.ROUT_ORG_NOD_CD = SUBQ.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("                         AND INQU.ROUT_DEST_NOD_CD = SUBQ.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("                         AND INQU.PCTL_IO_BND_CD = @[r_inbound]" ).append("\n"); 
		query.append("                         AND INQU.ROUT_SEQ <> SUBQ.ROUT_SEQ" ).append("\n"); 
		query.append("                         AND NVL(DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("                         AND ROWNUM = 1), 'Y')" ).append("\n"); 
		query.append("              END AS OPTM_DEL_ABLE_FLG" ).append("\n"); 
		query.append(" FROM ( " ).append("\n"); 
		query.append("   SELECT rout_org_nod_cd, rout_dest_nod_cd, INLND_ROUT_BKG_FLG ,INLND_ROUT_TMP_FLG ,INLND_ROUT_INCL_STTL_FLG,rownum rn, " ).append("\n"); 
		query.append("        substr( rout_org_nod_cd,1,5) org_loc, substr( rout_org_nod_cd,6) org_loc_type," ).append("\n"); 
		query.append("        substr( rout_dest_nod_cd,1,5) dest_loc, substr( rout_dest_nod_cd,6) dest_loc_type," ).append("\n"); 
		query.append("        rout_seq, prio_seq, route," ).append("\n"); 
		query.append("        sum_tt_time, sum_dw_tt , (sum_tt_time + sum_dw_tt) tot_tt," ).append("\n"); 
		query.append("        WRS_FULL_CMDT_CD,cre_usr_id,cre_ofc_cd,cre_dt ,HUB_LOC_CD,inlnd_rout_rmk ,HUB, DELT_FLG,ROUT_PLN_CD, --JSY" ).append("\n"); 
		query.append("        UPD_USR_ID, UPD_DT --JSY" ).append("\n"); 
		query.append("        ,INLND_ROUT_OPTM_FLG" ).append("\n"); 
		query.append("        , LNK_KNT" ).append("\n"); 
		query.append("        , INLND_TMNL_SHTL_FLG" ).append("\n"); 
		query.append("   FROM ( " ).append("\n"); 
		query.append("     SELECT rout_org_nod_cd, rout_dest_nod_cd, rout_seq, prio_seq ,INLND_ROUT_BKG_FLG ,INLND_ROUT_TMP_FLG, " ).append("\n"); 
		query.append("            INLND_ROUT_INCL_STTL_FLG, " ).append("\n"); 
		query.append("            rout_org_nod_cd || ' ( ' || " ).append("\n"); 
		query.append("            MAX(DECODE ( cnt,1 ,(DECODE(rout_dtl_seq ,1 , trsp_mod , ''  )), " ).append("\n"); 
		query.append("                                      (DECODE(rout_dtl_seq ,1 , trsp_mod , ''  ))) ) || ' ) ' ||" ).append("\n"); 
		query.append("            MAX(DECODE(cnt,1,'', DECODE(cnt,1 ,'', DECODE(rout_dtl_seq, 1 , '-'||lnk_dest_nod_cd || ' ( '))))     || " ).append("\n"); 
		query.append("            MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,2 , trsp_mod  || ' ) ', ''  ))) )  || " ).append("\n"); 
		query.append("            MAX(DECODE(cnt,1,'', DECODE(cnt,2 ,'', DECODE(rout_dtl_seq, 2 , '-'||lnk_dest_nod_cd || ' ( '))))     ||" ).append("\n"); 
		query.append("            MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,3 , trsp_mod || ' ) ', ''  ))) )   ||" ).append("\n"); 
		query.append("            MAX(DECODE(cnt,1,'', DECODE(cnt,3 ,'', DECODE(rout_dtl_seq, 3 , '-'||lnk_dest_nod_cd  || ' ( '))))    ||" ).append("\n"); 
		query.append("            MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,4 , trsp_mod  || ' ) ', ''  ))) )  ||" ).append("\n"); 
		query.append("            MAX(DECODE(cnt,1,'', DECODE(cnt,4 ,'', DECODE(rout_dtl_seq, 4 , '-'||lnk_dest_nod_cd  || ' ( '))))    || " ).append("\n"); 
		query.append("            MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,5 , trsp_mod || ' ) ', ''  ))) )  || " ).append("\n"); 
		query.append("            MAX(DECODE(cnt,1,'', DECODE(cnt,5 ,'', DECODE(rout_dtl_seq, 5 , '-'||lnk_dest_nod_cd  || ' ( '))))    || " ).append("\n"); 
		query.append("            MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,6 , trsp_mod || ' ) ', ''  ))) )    || " ).append("\n"); 
		query.append("            MAX(DECODE(cnt,1,'', DECODE(cnt,6 ,'', DECODE(rout_dtl_seq, 6 , '-'||lnk_dest_nod_cd  || ' ( ' ))))   || " ).append("\n"); 
		query.append("            MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,7 , trsp_mod || ' ) ', ''  ))) )    || " ).append("\n"); 
		query.append("            MAX(DECODE(cnt,1,'', DECODE(cnt,7 ,'', DECODE(rout_dtl_seq, 7 , '-'||lnk_dest_nod_cd  || ' ( '))))    || " ).append("\n"); 
		query.append("            MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,8 , trsp_mod || ' ) ', ''  ))) )    || " ).append("\n"); 
		query.append("            MAX(DECODE(cnt,1,'', DECODE(cnt,8 ,'', DECODE(rout_dtl_seq, 8 , '-'||lnk_dest_nod_cd  || ' ( '))))    || " ).append("\n"); 
		query.append("            MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,9 , trsp_mod || ' ) ' , ''  ))) )  || " ).append("\n"); 
		query.append("            MAX(DECODE(cnt,1,'', DECODE(cnt,9 ,'', DECODE(rout_dtl_seq, 9 , '-'||lnk_dest_nod_cd  || ' ( '))))    || " ).append("\n"); 
		query.append("            MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,10, trsp_mod || ' ) ', ''  ))) )    || " ).append("\n"); 
		query.append("            MAX(DECODE(cnt,1,'', DECODE(cnt,10,'', DECODE(rout_dtl_seq, 10, '-'||lnk_dest_nod_cd || ' ( '))))     ||" ).append("\n"); 
		query.append("            MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,11, trsp_mod || ' ) ' , ''  ))) )  ||" ).append("\n"); 
		query.append("            MAX(DECODE(cnt,1,'', DECODE(cnt,11,'', DECODE(rout_dtl_seq, 11, '-'||lnk_dest_nod_cd || ' ( '))))     || " ).append("\n"); 
		query.append("            MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,12, trsp_mod || ' ) ', ''  ))) )    || " ).append("\n"); 
		query.append("            MAX(DECODE(cnt,1,'', DECODE(cnt,12,'', DECODE(rout_dtl_seq, 12, '-'||lnk_dest_nod_cd || ' ( '))))     || " ).append("\n"); 
		query.append("            MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,13, trsp_mod || ' ) ', ''  ))) )    ||" ).append("\n"); 
		query.append("            MAX(DECODE(cnt,1,'', DECODE(cnt,13,'', DECODE(rout_dtl_seq, 13, '-'||lnk_dest_nod_cd || ' ( '))))     || " ).append("\n"); 
		query.append("            MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,14, trsp_mod || ' ) ', ''  ))) )    || " ).append("\n"); 
		query.append("            MAX(DECODE(cnt,1,'', DECODE(cnt,14,'', DECODE(rout_dtl_seq, 14, '-'||lnk_dest_nod_cd  || ' ( '))))    || " ).append("\n"); 
		query.append("            MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,15, trsp_mod || ' ) ', ''  ))) )    ||" ).append("\n"); 
		query.append("            MAX(DECODE(cnt,1,'', DECODE(cnt,15,'', DECODE(rout_dtl_seq, 15, '-'||lnk_dest_nod_cd || ' ( '))))     ||" ).append("\n"); 
		query.append("            MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,16, trsp_mod || ' ) ', ''  ))) )    || " ).append("\n"); 
		query.append("            MAX(DECODE(cnt,1,'', DECODE(cnt,16,'', DECODE(rout_dtl_seq, 16, '-'||lnk_dest_nod_cd  || ' ( ' ))))   || " ).append("\n"); 
		query.append("            MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,17, trsp_mod || ' ) ', ''  ))) )    || " ).append("\n"); 
		query.append("            MAX(DECODE(cnt,1,'', DECODE(cnt,17,'', DECODE(rout_dtl_seq, 17, '-'||lnk_dest_nod_cd || ' ( '))))     || " ).append("\n"); 
		query.append("            MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,18, trsp_mod || ' ) ', ''  ))) )    ||" ).append("\n"); 
		query.append("            MAX(DECODE(cnt,1,'', DECODE(cnt,18,'', DECODE(rout_dtl_seq, 18, '-'||lnk_dest_nod_cd || ' ( '))))     || " ).append("\n"); 
		query.append("            MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,19, trsp_mod || ' ) ', ''  ))) )    || " ).append("\n"); 
		query.append("            MAX(DECODE(cnt,1,'', DECODE(cnt,19,'', DECODE(rout_dtl_seq, 19, '-'||lnk_dest_nod_cd || ' ( '))))     || " ).append("\n"); 
		query.append("            MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,20, trsp_mod || ' ) ', ''  ))) )    || " ).append("\n"); 
		query.append("            MAX(DECODE(cnt,1,'', DECODE(cnt,20,'', DECODE(rout_dtl_seq, 20, '-'||lnk_dest_nod_cd)))) " ).append("\n"); 
		query.append("            ||  '-'||rout_dest_nod_cd as route " ).append("\n"); 
		query.append("            , rout_org_nod_cd AS pod0" ).append("\n"); 
		query.append("            , rout_dest_nod_cd AS del, sum_tt_time, " ).append("\n"); 
		query.append("            MAX(DECODE ( cnt,1 , DECODE(rout_dtl_seq ,1 , dest_dw_time , 0  )," ).append("\n"); 
		query.append("                                    DECODE(rout_dtl_seq ,1 , dest_dw_time, 0  )) )  + " ).append("\n"); 
		query.append("            MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,2 , dest_dw_time, 0  )) )   + " ).append("\n"); 
		query.append("            MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,3 , dest_dw_time, 0  )) )   + " ).append("\n"); 
		query.append("            MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,4 , dest_dw_time, 0  )) )   + " ).append("\n"); 
		query.append("            MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,5 , dest_dw_time, 0  )) )   + " ).append("\n"); 
		query.append("            MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,6 , dest_dw_time, 0  )) )   + " ).append("\n"); 
		query.append("            MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,7 , dest_dw_time, 0  )) )   + " ).append("\n"); 
		query.append("            MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,8 , dest_dw_time, 0  )) )   + " ).append("\n"); 
		query.append("            MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,9 , dest_dw_time, 0  )) )   + " ).append("\n"); 
		query.append("            MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,10 , dest_dw_time, 0  )) )   + " ).append("\n"); 
		query.append("            MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,11 , dest_dw_time, 0  )) )   + " ).append("\n"); 
		query.append("            MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,12 , dest_dw_time, 0  )) )   + " ).append("\n"); 
		query.append("            MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,13 , dest_dw_time, 0  )) )   + " ).append("\n"); 
		query.append("            MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,14 , dest_dw_time, 0  )) )   + " ).append("\n"); 
		query.append("            MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,15 , dest_dw_time, 0  )) )   + " ).append("\n"); 
		query.append("            MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,16 , dest_dw_time, 0  )) )   + " ).append("\n"); 
		query.append("            MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,17 , dest_dw_time, 0  )) )   + " ).append("\n"); 
		query.append("            MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,18 , dest_dw_time, 0  )) )   + " ).append("\n"); 
		query.append("            MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,19 , dest_dw_time, 0  )) )   + " ).append("\n"); 
		query.append("            MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,20 , dest_dw_time, 0  )) )   sum_dw_tt, " ).append("\n"); 
		query.append("            WRS_FULL_CMDT_CD  " ).append("\n"); 
		query.append("           ,MAX(DECODE(cnt,1, cre_usr_id, DECODE(rout_dtl_seq,1, cre_usr_id))) cre_usr_id " ).append("\n"); 
		query.append("           ,MAX(DECODE(cnt,1, cre_ofc_cd, DECODE(rout_dtl_seq,1, cre_ofc_cd))) cre_ofc_cd" ).append("\n"); 
		query.append("           ,MAX(DECODE(cnt,1, cre_dt, DECODE(rout_dtl_seq,1, cre_dt))) cre_dt" ).append("\n"); 
		query.append("           ,MAX(DECODE(cnt,1, HUB_LOC_CD, DECODE(rout_dtl_seq,1, HUB_LOC_CD))) HUB_LOC_CD  " ).append("\n"); 
		query.append("           ,MAX(DECODE(cnt,1, HUB, DECODE(rout_dtl_seq,1, HUB))) HUB " ).append("\n"); 
		query.append("           ,MAX(DECODE(cnt,1, inlnd_rout_rmk, DECODE(rout_dtl_seq,1, inlnd_rout_rmk))) inlnd_rout_rmk   " ).append("\n"); 
		query.append("           ,MAX(DECODE(cnt,1, DELT_FLG, DECODE(rout_dtl_seq,1, DELT_FLG))) DELT_FLG    " ).append("\n"); 
		query.append("           ,MAX(DECODE(cnt,1, ROUT_PLN_CD, DECODE(rout_dtl_seq,1, ROUT_PLN_CD))) ROUT_PLN_CD   " ).append("\n"); 
		query.append("           ,MAX(DECODE(cnt,1, UPD_USR_ID, DECODE(rout_dtl_seq,1, UPD_USR_ID))) UPD_USR_ID     " ).append("\n"); 
		query.append("           ,MAX(DECODE(cnt,1, UPD_DT, DECODE(rout_dtl_seq,1, UPD_DT))) UPD_DT   " ).append("\n"); 
		query.append("           ,MAX(INLND_ROUT_OPTM_FLG) INLND_ROUT_OPTM_FLG" ).append("\n"); 
		query.append("           ,COUNT(1) LNK_KNT" ).append("\n"); 
		query.append("           ,MAX(INLND_TMNL_SHTL_FLG) INLND_TMNL_SHTL_FLG  " ).append("\n"); 
		query.append("         FROM ( " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                   SELECT m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq, decode(m.prio_seq,0,null,m.prio_seq) prio_seq, " ).append("\n"); 
		query.append("                        m.INLND_ROUT_BKG_FLG ,INLND_ROUT_INCL_STTL_FLG , " ).append("\n"); 
		query.append("                        d.lnk_org_nod_cd,d.lnk_dest_nod_cd, d.rout_dtl_seq,d.trsp_mod_cd,l.tztm_hrs, " ).append("\n"); 
		query.append("                        COUNT (*) OVER (PARTITION BY m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq " ).append("\n"); 
		query.append("                           ORDER BY m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq) AS cnt" ).append("\n"); 
		query.append("                        ,SUM(l.tztm_hrs) OVER(PARTITION BY m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq " ).append("\n"); 
		query.append("                           ORDER BY m.rout_org_nod_cd,m.rout_dest_nod_cd, m.rout_seq) AS sum_tt_time, " ).append("\n"); 
		query.append("                        (SELECT nvl(decode(@[r_inbound], 'O', ob_dry_avg_dwll_hrs, ib_dry_avg_dwll_hrs),0)  FROM mdm_yard WHERE yd_cd = d.lnk_org_nod_cd ) org_dw_time, " ).append("\n"); 
		query.append("                        (SELECT nvl(decode(@[r_inbound], 'O', ob_dry_avg_dwll_hrs, ib_dry_avg_dwll_hrs),0)  FROM mdm_yard WHERE yd_cd = d.lnk_dest_nod_cd ) dest_dw_time," ).append("\n"); 
		query.append("                        INLND_ROUT_TMP_FLG , " ).append("\n"); 
		query.append("                        WRS_FULL_CMDT_CD, m.cre_usr_id,m.cre_ofc_cd,m.cre_dt ,m.inlnd_rout_rmk -- JSY " ).append("\n"); 
		query.append("                        ,DECODE(d.trsp_mod_cd,'TD','TRUCK','RD','RAIL','WD','WATER',d.trsp_mod_cd) trsp_mod,M.HUB_LOC_CD," ).append("\n"); 
		query.append("                        (case   when @[r_inbound] = 'B'  then 'OK' " ).append("\n"); 
		query.append("                                when @[r_inbound] = 'I'  and n.nod_tp_cd in ('M','B') and @[r_btn_nod_ty_cd] = 'Z' and n1.nod_tp_cd ='Z' then 'OK' " ).append("\n"); 
		query.append("                                when @[r_inbound] = 'I'  and n.nod_tp_cd in ('M','B') and @[r_btn_nod_ty_cd] = 'Y' and n1.nod_tp_cd <> 'Z' then 'OK' " ).append("\n"); 
		query.append("                                when @[r_inbound] = 'O'  and n1.nod_tp_cd in ('M','B') and @[r_btn_nod_ty_cd] = 'Z' and n.nod_tp_cd ='Z' then 'OK' " ).append("\n"); 
		query.append("                                when @[r_inbound] = 'O'  and n1.nod_tp_cd in ('M','B') and @[r_btn_nod_ty_cd] = 'Y' and n.nod_tp_cd <>'Z' then 'OK' else 'XX'" ).append("\n"); 
		query.append("                         end) check_nod_tp , hub_NOD_CD HUB  ,m.DELT_FLG , m.ROUT_PLN_CD, " ).append("\n"); 
		query.append("                         m.UPD_USR_ID, m.UPD_DT --080821 jsy " ).append("\n"); 
		query.append("                         ,M.INLND_ROUT_OPTM_FLG" ).append("\n"); 
		query.append("                         ,CASE WHEN M.PCTL_IO_BND_CD IN ('I','O') " ).append("\n"); 
		query.append("                                 AND SUBSTR(M.ROUT_ORG_NOD_CD, 1,5) = SUBSTR(M.ROUT_DEST_NOD_CD, 1,5)" ).append("\n"); 
		query.append("                                 AND n.NOD_TP_CD != 'Z' AND n1.NOD_TP_CD != 'Z' " ).append("\n"); 
		query.append("                               THEN NVL((SELECT 'Y' FROM MDM_COUNTRY " ).append("\n"); 
		query.append("                                          WHERE SUBSTR(SCONTI_CD, 1,1) = 'E'" ).append("\n"); 
		query.append("                                            AND CNT_CD = SUBSTR(M.ROUT_ORG_NOD_CD,1,2)), 'N')" ).append("\n"); 
		query.append("                               ELSE 'N' END AS INLND_TMNL_SHTL_FLG " ).append("\n"); 
		query.append("                   FROM prd_inlnd_rout_mst m, prd_inlnd_rout_dtl d, prd_inlnd_each_lnk l, prd_node n, prd_node n1 " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                   WHERE m.rout_org_nod_cd LIKE @[i_org_cd] ||'%' " ).append("\n"); 
		query.append("                     AND m.rout_dest_nod_cd LIKE @[i_dest_cd] ||'%' " ).append("\n"); 
		query.append("                     AND NVL(m.HUB_NOD_CD,'X') LIKE NVL(@[i_hub_loc], NVL(M.HUB_NOD_CD,'X') )||'%'  " ).append("\n"); 
		query.append("                     and m.rout_org_nod_cd = n.nod_cd" ).append("\n"); 
		query.append("                     and m.rout_dest_nod_cd = n1.nod_cd " ).append("\n"); 
		query.append("                     AND m.INLND_ROUT_OPTM_FLG = CASE WHEN @[r_inbound] = 'B' THEN m.INLND_ROUT_OPTM_FLG" ).append("\n"); 
		query.append("                                                      WHEN NVL(@[sch_optm_flg], 'A') = 'A' THEN m.INLND_ROUT_OPTM_FLG" ).append("\n"); 
		query.append("                                                      ELSE DECODE(@[sch_optm_flg], 'C', 'N', @[sch_optm_flg]) END" ).append("\n"); 
		query.append("                     AND NVL(m.DELT_FLG,'N') = nvl( @[i_del_flg],'N') " ).append("\n"); 
		query.append("#if(${sch_optm_flg} == 'C')" ).append("\n"); 
		query.append("                             AND 0 = (SELECT COUNT(1) FROM PRD_INLND_ROUT_MST ML" ).append("\n"); 
		query.append("                                      WHERE ML.ROUT_ORG_NOD_CD = M.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("                                        AND ML.ROUT_DEST_NOD_CD = M.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("                                        AND ML.PCTL_IO_BND_CD = M.PCTL_IO_BND_CD" ).append("\n"); 
		query.append("                                        AND NVL(ML.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("                                        AND ML.INLND_ROUT_OPTM_FLG = 'Y'" ).append("\n"); 
		query.append("                                        AND ROWNUM = 1)" ).append("\n"); 
		query.append("                             AND SUBSTR(M.ROUT_ORG_NOD_CD, 1,5) <> SUBSTR(M.ROUT_DEST_NOD_CD, 1,5)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                     AND m.rout_org_nod_cd = d.rout_org_nod_cd " ).append("\n"); 
		query.append("                     AND m.rout_dest_nod_cd = d.rout_dest_nod_cd " ).append("\n"); 
		query.append("                     AND m.rout_seq = d.rout_seq " ).append("\n"); 
		query.append("                     AND d.lnk_org_nod_cd = l.lnk_org_nod_cd " ).append("\n"); 
		query.append("                     AND d.lnk_dest_nod_cd = l.lnk_dest_nod_cd " ).append("\n"); 
		query.append("                     AND d.trsp_mod_cd = l.trsp_mod_cd " ).append("\n"); 
		query.append("                     AND m.PCTL_IO_BND_CD = @[r_inbound]" ).append("\n"); 
		query.append("                     AND m.AUTO_IRG_FLG <> 'Y' --컬럼추가로 조건값추가 " ).append("\n"); 
		query.append("                   ORDER BY m.rout_seq, d.rout_dtl_seq " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              ) m " ).append("\n"); 
		query.append("     where check_nod_tp ='OK' " ).append("\n"); 
		query.append("     GROUP BY m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq, m.prio_seq,sum_tt_time,INLND_ROUT_BKG_FLG,INLND_ROUT_TMP_FLG, " ).append("\n"); 
		query.append("              m.INLND_ROUT_INCL_STTL_FLG,WRS_FULL_CMDT_CD" ).append("\n"); 
		query.append("     ORDER BY rout_org_nod_cd, rout_dest_nod_cd, prio_seq " ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append(") SUBQ" ).append("\n"); 
		query.append("ORDER BY   rn" ).append("\n"); 

	}
}
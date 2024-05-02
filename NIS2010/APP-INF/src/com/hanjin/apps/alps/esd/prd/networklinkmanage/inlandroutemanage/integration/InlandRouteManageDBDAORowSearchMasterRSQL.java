/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : InlandRouteManageDBDAORowSearchMasterRSQL.java
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

public class InlandRouteManageDBDAORowSearchMasterRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RowSearchMaster
	  * </pre>
	  */
	public InlandRouteManageDBDAORowSearchMasterRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_rout_org_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_rout_dest_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.integration").append("\n"); 
		query.append("FileName : InlandRouteManageDBDAORowSearchMasterRSQL").append("\n"); 
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
		query.append("        	      rout_org_nod_cd, rout_dest_nod_cd, rn,   INLND_ROUT_BKG_FLG  , INLND_ROUT_TMP_FLG," ).append("\n"); 
		query.append("        	      org_loc,  org_loc_type," ).append("\n"); 
		query.append("        	      dest_loc,  dest_loc_type," ).append("\n"); 
		query.append("        	      rout_seq, prio_seq, route," ).append("\n"); 
		query.append("        	      sum_tt_time, sum_dw_tt ,--tot_tt," ).append("\n"); 
		query.append("        	      ltrim(to_char(trunc(tot_tt/24,0),'00'))||ltrim(to_char(mod(tot_tt,24  ),'00'))  tot_tt," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        	      '' hub_search_gb, '' front_gb , '' undefine_nod," ).append("\n"); 
		query.append("        	      max(rn) OVER (PARTITION BY rout_org_nod_cd, rout_dest_nod_cd  ORDER BY rout_org_nod_cd," ).append("\n"); 
		query.append("        	                       rout_dest_nod_cd) AS group_gubun" ).append("\n"); 
		query.append("        	 FROM (" ).append("\n"); 
		query.append("        	 	SELECT rout_org_nod_cd, rout_dest_nod_cd, rownum rn,  INLND_ROUT_BKG_FLG ,INLND_ROUT_TMP_FLG ," ).append("\n"); 
		query.append("        	 	     substr( rout_org_nod_cd,1,5) org_loc, substr( rout_org_nod_cd,6) org_loc_type," ).append("\n"); 
		query.append("        	 	     substr( rout_dest_nod_cd,1,5) dest_loc, substr( rout_dest_nod_cd,6) dest_loc_type," ).append("\n"); 
		query.append("        	 	     rout_seq, prio_seq, route," ).append("\n"); 
		query.append("        	 	     sum_tt_time, sum_dw_tt , (sum_tt_time + sum_dw_tt) tot_tt" ).append("\n"); 
		query.append("        	 	FROM (" ).append("\n"); 
		query.append("        	 	  SELECT rout_org_nod_cd, rout_dest_nod_cd, rout_seq, prio_seq  ,INLND_ROUT_BKG_FLG ,INLND_ROUT_TMP_FLG" ).append("\n"); 
		query.append("        	 	         ,rout_org_nod_cd || ' ( ' ||" ).append("\n"); 
		query.append("        	 	         MAX(DECODE ( cnt,1 ,(DECODE(rout_dtl_seq ,1 , trsp_mod , ''  ))," ).append("\n"); 
		query.append("        	 	                                   (DECODE(rout_dtl_seq ,1 , trsp_mod , ''  ))) ) || ' ) ' ||" ).append("\n"); 
		query.append("        	 	         MAX(DECODE(cnt,1,'', DECODE(cnt,1 ,'', DECODE(rout_dtl_seq, 1 , '-'||lnk_dest_nod_cd || ' ( '))))     ||" ).append("\n"); 
		query.append("        	 	         MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,2 , trsp_mod  || ' ) ', ''  ))) )  ||" ).append("\n"); 
		query.append("        	 	         MAX(DECODE(cnt,1,'', DECODE(cnt,2 ,'', DECODE(rout_dtl_seq, 2 , '-'||lnk_dest_nod_cd || ' ( '))))     ||" ).append("\n"); 
		query.append("        	 	         MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,3 , trsp_mod || ' ) ', ''  ))) )   ||" ).append("\n"); 
		query.append("        	 	         MAX(DECODE(cnt,1,'', DECODE(cnt,3 ,'', DECODE(rout_dtl_seq, 3 , '-'||lnk_dest_nod_cd  || ' ( '))))    ||" ).append("\n"); 
		query.append("        	 	         MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,4 , trsp_mod  || ' ) ', ''  ))) )  ||" ).append("\n"); 
		query.append("        	 	         MAX(DECODE(cnt,1,'', DECODE(cnt,4 ,'', DECODE(rout_dtl_seq, 4 , '-'||lnk_dest_nod_cd  || ' ( '))))    ||" ).append("\n"); 
		query.append("        	 	         MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,5 , trsp_mod || ' ) ', ''  ))) )  ||" ).append("\n"); 
		query.append("        	 	         MAX(DECODE(cnt,1,'', DECODE(cnt,5 ,'', DECODE(rout_dtl_seq, 5 , '-'||lnk_dest_nod_cd  || ' ( '))))    ||" ).append("\n"); 
		query.append("        	 	         MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,6 , trsp_mod || ' ) ', ''  ))) )    ||" ).append("\n"); 
		query.append("        	 	         MAX(DECODE(cnt,1,'', DECODE(cnt,6 ,'', DECODE(rout_dtl_seq, 6 , '-'||lnk_dest_nod_cd  || ' ( ' ))))   ||" ).append("\n"); 
		query.append("        	 	         MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,7 , trsp_mod || ' ) ', ''  ))) )    ||" ).append("\n"); 
		query.append("        	 	         MAX(DECODE(cnt,1,'', DECODE(cnt,7 ,'', DECODE(rout_dtl_seq, 7 , '-'||lnk_dest_nod_cd  || ' ( '))))    ||" ).append("\n"); 
		query.append("        	 	         MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,8 , trsp_mod || ' ) ', ''  ))) )    ||" ).append("\n"); 
		query.append("        	 	         MAX(DECODE(cnt,1,'', DECODE(cnt,8 ,'', DECODE(rout_dtl_seq, 8 , '-'||lnk_dest_nod_cd  || ' ( '))))    ||" ).append("\n"); 
		query.append("        	 	         MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,9 , trsp_mod || ' ) ' , ''  ))) )  ||" ).append("\n"); 
		query.append("        	 	         MAX(DECODE(cnt,1,'', DECODE(cnt,9 ,'', DECODE(rout_dtl_seq, 9 , '-'||lnk_dest_nod_cd  || ' ( '))))    ||" ).append("\n"); 
		query.append("        	 	         MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,10, trsp_mod || ' ) ', ''  ))) )    ||" ).append("\n"); 
		query.append("        	 	         MAX(DECODE(cnt,1,'', DECODE(cnt,10,'', DECODE(rout_dtl_seq, 10, '-'||lnk_dest_nod_cd || ' ( '))))     ||" ).append("\n"); 
		query.append("        	 	         MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,11, trsp_mod || ' ) ' , ''  ))) )  ||" ).append("\n"); 
		query.append("        	 	         MAX(DECODE(cnt,1,'', DECODE(cnt,11,'', DECODE(rout_dtl_seq, 11, '-'||lnk_dest_nod_cd || ' ( '))))     ||" ).append("\n"); 
		query.append("        	 	         MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,12, trsp_mod || ' ) ', ''  ))) )    ||" ).append("\n"); 
		query.append("        	 	         MAX(DECODE(cnt,1,'', DECODE(cnt,12,'', DECODE(rout_dtl_seq, 12, '-'||lnk_dest_nod_cd || ' ( '))))     ||" ).append("\n"); 
		query.append("        	 	         MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,13, trsp_mod || ' ) ', ''  ))) )    ||" ).append("\n"); 
		query.append("        	 	         MAX(DECODE(cnt,1,'', DECODE(cnt,13,'', DECODE(rout_dtl_seq, 13, '-'||lnk_dest_nod_cd || ' ( '))))     ||" ).append("\n"); 
		query.append("        	 	         MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,14, trsp_mod || ' ) ', ''  ))) )    ||" ).append("\n"); 
		query.append("        	 	         MAX(DECODE(cnt,1,'', DECODE(cnt,14,'', DECODE(rout_dtl_seq, 14, '-'||lnk_dest_nod_cd  || ' ( '))))    ||" ).append("\n"); 
		query.append("        	 	         MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,15, trsp_mod || ' ) ', ''  ))) )    ||" ).append("\n"); 
		query.append("        	 	         MAX(DECODE(cnt,1,'', DECODE(cnt,15,'', DECODE(rout_dtl_seq, 15, '-'||lnk_dest_nod_cd || ' ( '))))     ||" ).append("\n"); 
		query.append("        	 	         MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,16, trsp_mod || ' ) ', ''  ))) )    ||" ).append("\n"); 
		query.append("        	 	         MAX(DECODE(cnt,1,'', DECODE(cnt,16,'', DECODE(rout_dtl_seq, 16, '-'||lnk_dest_nod_cd  || ' ( ' ))))   ||" ).append("\n"); 
		query.append("        	 	         MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,17, trsp_mod || ' ) ', ''  ))) )    ||" ).append("\n"); 
		query.append("        	 	         MAX(DECODE(cnt,1,'', DECODE(cnt,17,'', DECODE(rout_dtl_seq, 17, '-'||lnk_dest_nod_cd || ' ( '))))     ||" ).append("\n"); 
		query.append("        	 	         MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,18, trsp_mod || ' ) ', ''  ))) )    ||" ).append("\n"); 
		query.append("        	 	         MAX(DECODE(cnt,1,'', DECODE(cnt,18,'', DECODE(rout_dtl_seq, 18, '-'||lnk_dest_nod_cd || ' ( '))))     ||" ).append("\n"); 
		query.append("        	 	         MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,19, trsp_mod || ' ) ', ''  ))) )    ||" ).append("\n"); 
		query.append("        	 	         MAX(DECODE(cnt,1,'', DECODE(cnt,19,'', DECODE(rout_dtl_seq, 19, '-'||lnk_dest_nod_cd || ' ( '))))     ||" ).append("\n"); 
		query.append("        	 	         MAX(DECODE ( cnt,1 , '' , (DECODE(rout_dtl_seq ,20, trsp_mod || ' ) ', ''  ))) )    ||" ).append("\n"); 
		query.append("        	 	         MAX(DECODE(cnt,1,'', DECODE(cnt,20,'', DECODE(rout_dtl_seq, 20, '-'||lnk_dest_nod_cd))))" ).append("\n"); 
		query.append("        	 	         ||  '-'||rout_dest_nod_cd as route" ).append("\n"); 
		query.append("        	 	         , rout_org_nod_cd AS pod0" ).append("\n"); 
		query.append("        	 	         , rout_dest_nod_cd AS del, sum_tt_time," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                  MAX(DECODE ( cnt,1 , DECODE(rout_dtl_seq ,1 , dest_dw_time , 0  )," ).append("\n"); 
		query.append("                                          DECODE(rout_dtl_seq ,1 , dest_dw_time, 0  )) )  +" ).append("\n"); 
		query.append("                  MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,2 , dest_dw_time, 0  )) )   +" ).append("\n"); 
		query.append("                  MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,3 , dest_dw_time, 0  )) )   +" ).append("\n"); 
		query.append("                  MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,4 , dest_dw_time, 0  )) )   +" ).append("\n"); 
		query.append("                  MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,5 , dest_dw_time, 0  )) )   +" ).append("\n"); 
		query.append("                  MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,6 , dest_dw_time, 0  )) )   +" ).append("\n"); 
		query.append("                  MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,7 , dest_dw_time, 0  )) )   +" ).append("\n"); 
		query.append("                  MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,8 , dest_dw_time, 0  )) )   +" ).append("\n"); 
		query.append("                  MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,9 , dest_dw_time, 0  )) )   +" ).append("\n"); 
		query.append("                  MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,10 , dest_dw_time, 0  )) )   +" ).append("\n"); 
		query.append("                  MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,11 , dest_dw_time, 0  )) )   +" ).append("\n"); 
		query.append("                  MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,12 , dest_dw_time, 0  )) )   +" ).append("\n"); 
		query.append("                  MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,13 , dest_dw_time, 0  )) )   +" ).append("\n"); 
		query.append("                  MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,14 , dest_dw_time, 0  )) )   +" ).append("\n"); 
		query.append("                  MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,15 , dest_dw_time, 0  )) )   +" ).append("\n"); 
		query.append("                  MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,16 , dest_dw_time, 0  )) )   +" ).append("\n"); 
		query.append("                  MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,17 , dest_dw_time, 0  )) )   +" ).append("\n"); 
		query.append("                  MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,18 , dest_dw_time, 0  )) )   +" ).append("\n"); 
		query.append("                  MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,19 , dest_dw_time, 0  )) )   +" ).append("\n"); 
		query.append("                  MAX(DECODE ( cnt,1 ,0, DECODE(rout_dtl_seq ,20 , dest_dw_time, 0  )) )   sum_dw_tt" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        	 	      FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        	 	            SELECT rout_org_nod_cd, rout_dest_nod_cd, rout_seq, prio_seq," ).append("\n"); 
		query.append("        	 	                   rout_dtl_seq, cnt,lnk_org_nod_cd, lnk_dest_nod_cd,trsp_mod_cd," ).append("\n"); 
		query.append("        	 	                   DECODE(trsp_mod_cd,'TD','TRUCK','RD','RAIL','WD','WATER',trsp_mod_cd) trsp_mod," ).append("\n"); 
		query.append("        	 	                   tztm_hrs link_tt_time ,sum_tt_time, org_dw_time,nvl(dest_dw_time,0) dest_dw_time  ,INLND_ROUT_BKG_FLG ,INLND_ROUT_TMP_FLG" ).append("\n"); 
		query.append("        	 	              FROM (" ).append("\n"); 
		query.append("        	 	                SELECT m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq, m.prio_seq," ).append("\n"); 
		query.append("        	 	                     d.lnk_org_nod_cd,d.lnk_dest_nod_cd, d.rout_dtl_seq,d.trsp_mod_cd,l.tztm_hrs," ).append("\n"); 
		query.append("        	 	                     COUNT (*) OVER (PARTITION BY m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq" ).append("\n"); 
		query.append("        	 	                        ORDER BY m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq) AS cnt" ).append("\n"); 
		query.append("        	 	                     ,SUM(l.tztm_hrs) OVER(PARTITION BY m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq" ).append("\n"); 
		query.append("        	 	                        ORDER BY m.rout_org_nod_cd,m.rout_dest_nod_cd, m.rout_seq) AS sum_tt_time," ).append("\n"); 
		query.append("        	 	                     (SELECT nvl(decode(m.PCTL_IO_BND_CD, 'O', OB_dry_avg_dwll_hrs,IB_dry_avg_dwll_hrs),0)  FROM mdm_yard WHERE yd_cd = d.lnk_org_nod_cd ) org_dw_time," ).append("\n"); 
		query.append("        	 	                     (SELECT nvl(decode(m.PCTL_IO_BND_CD, 'O', OB_dry_avg_dwll_hrs,IB_dry_avg_dwll_hrs),0)  FROM mdm_yard WHERE yd_cd = d.lnk_dest_nod_cd ) dest_dw_time,INLND_ROUT_BKG_FLG ,INLND_ROUT_TMP_FLG" ).append("\n"); 
		query.append("        	 	                FROM prd_inlnd_rout_mst m, prd_inlnd_rout_dtl d, prd_inlnd_each_lnk l" ).append("\n"); 
		query.append("        	 	                WHERE m.rout_org_nod_cd = @[i_rout_org_nod_cd]" ).append("\n"); 
		query.append("        	 	                  AND m.rout_dest_nod_cd = @[i_rout_dest_nod_cd]" ).append("\n"); 
		query.append("        	 	                  AND m.rout_seq         = @[i_rout_seq]" ).append("\n"); 
		query.append("        	 	                  AND m.rout_org_nod_cd = d.rout_org_nod_cd" ).append("\n"); 
		query.append("        	 	                  AND m.rout_dest_nod_cd = d.rout_dest_nod_cd" ).append("\n"); 
		query.append("        	 	                  AND m.rout_seq = d.rout_seq" ).append("\n"); 
		query.append("        	 	                  AND d.lnk_org_nod_cd = l.lnk_org_nod_cd" ).append("\n"); 
		query.append("        	 	                  AND d.lnk_dest_nod_cd = l.lnk_dest_nod_cd" ).append("\n"); 
		query.append("        	 	                  AND d.trsp_mod_cd = l.trsp_mod_cd" ).append("\n"); 
		query.append("        	 	                ORDER BY m.rout_seq, d.rout_dtl_seq" ).append("\n"); 
		query.append("        	 	            )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        	 	           ) m" ).append("\n"); 
		query.append("        	 	  GROUP BY m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq, m.prio_seq,sum_tt_time,INLND_ROUT_BKG_FLG ,INLND_ROUT_TMP_FLG" ).append("\n"); 
		query.append("        	 	  ORDER BY rout_org_nod_cd, rout_dest_nod_cd, prio_seq" ).append("\n"); 
		query.append("        	     )" ).append("\n"); 
		query.append("        	)" ).append("\n"); 
		query.append("    	    ORDER BY   prio_seq" ).append("\n"); 

	}
}
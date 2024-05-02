/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchDstSvcRouteRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOSearchDstSvcRouteRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DEST_TRNS_SVC_MOD_CD 조회
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchDstSvcRouteRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ocp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pst_rly_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trunk_lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOSearchDstSvcRouteRSQL").append("\n"); 
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
		query.append("SELECT DST_SVC_MODE" ).append("\n"); 
		query.append("  FROM (SELECT 1 RANK, SVC_MOD_CD DST_SVC_MODE" ).append("\n"); 
		query.append("          FROM MAS_USA_SVC_MOD" ).append("\n"); 
		query.append("         WHERE ORG_RGN_CD = (SELECT NVL(RGN_CD, ' ') FROM MDM_LOCATION WHERE LOC_CD = @[pod_cd])" ).append("\n"); 
		query.append("           AND DEST_RGN_CD = (SELECT NVL(RGN_CD, ' ') FROM MDM_LOCATION WHERE LOC_CD = @[del_cd])" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 2 RANK, 'ELO' ORG_SVC_MODE" ).append("\n"); 
		query.append("          FROM BKG_EQLZ_PORT" ).append("\n"); 
		query.append("         WHERE SLAN_CD      = @[trunk_lane_cd]" ).append("\n"); 
		query.append("           AND LOC_CD       = @[pod_cd]" ).append("\n"); 
		query.append("           AND EQLZ_PORT_CD = @[del_cd]" ).append("\n"); 
		query.append("           AND SKD_DIR_CD   = @[skd_dir_cd]" ).append("\n"); 
		query.append("        union ALL" ).append("\n"); 
		query.append("        select 3 rank, decode(del.loc_chr_cd||pod.loc_chr_cd" ).append("\n"); 
		query.append("               , 'PRTPRT', 'NLO', decode(@[del_cd], @[pod_cd], 'NLO', 'NIP')) DST_SVC_MODE" ).append("\n"); 
		query.append("          from mdm_location del, mdm_location pod" ).append("\n"); 
		query.append("         where del.loc_cd = @[del_cd]   " ).append("\n"); 
		query.append("           and del.delt_flg = 'N'" ).append("\n"); 
		query.append("           and pod.loc_cd = @[pod_cd] " ).append("\n"); 
		query.append("           and pod.delt_flg = 'N'" ).append("\n"); 
		query.append("           AND NVL(@[pst_rly_port_cd], 'X') <> 'X'" ).append("\n"); 
		query.append("        union All   " ).append("\n"); 
		query.append("        select 4 rank, decode(length(@[ocp_cd]), 5, 'COC'," ).append("\n"); 
		query.append("                decode(del.loc_chr_cd||pod.loc_chr_cd" ).append("\n"); 
		query.append("               , 'ECPGCP', 'CLO', 'GCPECP', 'CLO'" ).append("\n"); 
		query.append("               , 'ECPECP', 'CLO', 'WCPWCP', 'CLO', 'PRTPRT', 'CLO'" ).append("\n"); 
		query.append("               , decode(@[del_cd], @[pod_cd], 'CLO'" ).append("\n"); 
		query.append("                   , decode(del.loc_chr_cd||pod.loc_chr_cd" ).append("\n"); 
		query.append("                       , 'ECPWCP', 'CML', 'WCPECP', 'CML'" ).append("\n"); 
		query.append("                       , 'GCPWCP', 'CML', 'WCPGCP', 'CML'" ).append("\n"); 
		query.append("                       , 'CIP'))))  DST_SVC_MODE" ).append("\n"); 
		query.append("          from mdm_location del, mdm_location pod" ).append("\n"); 
		query.append("         where del.loc_cd = @[del_cd]" ).append("\n"); 
		query.append("           and del.delt_flg = 'N'" ).append("\n"); 
		query.append("           and pod.loc_cd = @[pod_cd]" ).append("\n"); 
		query.append("           and pod.delt_flg = 'N'" ).append("\n"); 
		query.append("           AND NVL(@[pst_rly_port_cd], 'X') = 'X')" ).append("\n"); 
		query.append(" where rownum = 1" ).append("\n"); 
		query.append(" order by rank" ).append("\n"); 

	}
}
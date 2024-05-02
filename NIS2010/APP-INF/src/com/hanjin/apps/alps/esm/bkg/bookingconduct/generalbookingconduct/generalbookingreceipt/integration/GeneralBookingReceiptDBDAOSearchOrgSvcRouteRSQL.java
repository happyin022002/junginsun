/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchOrgSvcRouteRSQL.java
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

public class GeneralBookingReceiptDBDAOSearchOrgSvcRouteRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * orgin service mode 조회
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchOrgSvcRouteRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_rly_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : GeneralBookingReceiptDBDAOSearchOrgSvcRouteRSQL").append("\n"); 
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
		query.append("SELECT ORG_SVC_MODE" ).append("\n"); 
		query.append("  FROM (SELECT 1 RANK, SVC_MOD_CD ORG_SVC_MODE" ).append("\n"); 
		query.append("          FROM MAS_USA_SVC_MOD" ).append("\n"); 
		query.append("         WHERE ORG_RGN_CD = (SELECT NVL(RGN_CD, ' ') FROM MDM_LOCATION WHERE LOC_CD = @[pol_cd])" ).append("\n"); 
		query.append("           AND DEST_RGN_CD = (SELECT NVL(RGN_CD, ' ') FROM MDM_LOCATION WHERE LOC_CD = @[por_cd])" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 2 RANK, 'ELO' ORG_SVC_MODE" ).append("\n"); 
		query.append("          FROM BKG_EQLZ_PORT" ).append("\n"); 
		query.append("         WHERE SLAN_CD      = @[trunk_lane_cd]" ).append("\n"); 
		query.append("           AND LOC_CD       = @[pol_cd]" ).append("\n"); 
		query.append("           AND EQLZ_PORT_CD = @[por_cd]" ).append("\n"); 
		query.append("           AND SKD_DIR_CD   = @[skd_dir_cd]" ).append("\n"); 
		query.append("        union ALL" ).append("\n"); 
		query.append("        select 3 rank, decode(por.loc_chr_cd||poL.loc_chr_cd" ).append("\n"); 
		query.append("               , 'PRTPRT', 'NLO', decode(@[por_cd], @[pol_cd], 'NLO', 'NIP')) ORG_SVC_MODE" ).append("\n"); 
		query.append("          from mdm_location por, mdm_location pol" ).append("\n"); 
		query.append("         where por.loc_cd = @[por_cd]   " ).append("\n"); 
		query.append("           and por.delt_flg = 'N'" ).append("\n"); 
		query.append("           and pol.loc_cd = @[pol_cd]   " ).append("\n"); 
		query.append("           and pol.delt_flg = 'N'" ).append("\n"); 
		query.append("           AND NVL(@[pre_rly_port_cd], 'X') <> 'X'" ).append("\n"); 
		query.append("        union All			" ).append("\n"); 
		query.append("        select 4 rank, decode(por.loc_chr_cd||poL.loc_chr_cd" ).append("\n"); 
		query.append("               , 'ECPGCP', 'CLO', 'GCPECP', 'CLO'" ).append("\n"); 
		query.append("               , 'ECPECP', 'CLO', 'WCPWCP', 'CLO', 'PRTPRT', 'CLO'" ).append("\n"); 
		query.append("               , decode(@[por_cd], @[pol_cd], 'CLO'" ).append("\n"); 
		query.append("                   , decode(por.loc_chr_cd||poL.loc_chr_cd" ).append("\n"); 
		query.append("                       , 'ECPWCP', 'CML', 'WCPECP', 'CML'" ).append("\n"); 
		query.append("                       , 'GCPWCP', 'CML', 'WCPGCP', 'CML'" ).append("\n"); 
		query.append("                       , 'CIP'))) ORG_SVC_MODE" ).append("\n"); 
		query.append("          from mdm_location por, mdm_location pol" ).append("\n"); 
		query.append("         where por.loc_cd = @[por_cd]   " ).append("\n"); 
		query.append("           and por.delt_flg = 'N'" ).append("\n"); 
		query.append("           and pol.loc_cd = @[pol_cd]   " ).append("\n"); 
		query.append("           and pol.delt_flg = 'N'" ).append("\n"); 
		query.append("           AND NVL(@[pre_rly_port_cd],'X') = 'X')" ).append("\n"); 
		query.append(" where rownum = 1" ).append("\n"); 
		query.append(" order by rank" ).append("\n"); 

	}
}
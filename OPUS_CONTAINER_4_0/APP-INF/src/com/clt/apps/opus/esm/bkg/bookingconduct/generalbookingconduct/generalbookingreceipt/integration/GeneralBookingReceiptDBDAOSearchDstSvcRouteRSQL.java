/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchDstSvcRouteRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.24
*@LastModifier : 이일민
*@LastVersion : 1.0
* 2011.02.24 이일민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LeeIlMin
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
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
		query.append("SELECT NVL((" ).append("\n"); 
		query.append("            SELECT SVC_MOD_CD" ).append("\n"); 
		query.append("              FROM COA_USA_SVC_MOD" ).append("\n"); 
		query.append("             WHERE ORG_RGN_CD = (SELECT NVL(RGN_CD, ' ') FROM MDM_LOCATION WHERE LOC_CD = @[pod_cd])" ).append("\n"); 
		query.append("               AND DEST_RGN_CD = (SELECT NVL(RGN_CD, ' ') FROM MDM_LOCATION WHERE LOC_CD = @[del_cd])" ).append("\n"); 
		query.append("           )," ).append("\n"); 
		query.append("       NVL((" ).append("\n"); 
		query.append("            SELECT 'ELO'" ).append("\n"); 
		query.append("              FROM BKG_EQLZ_PORT" ).append("\n"); 
		query.append("             WHERE SLAN_CD      = @[trunk_lane_cd]" ).append("\n"); 
		query.append("               AND LOC_CD       = @[pod_cd]" ).append("\n"); 
		query.append("               AND EQLZ_PORT_CD = @[del_cd]" ).append("\n"); 
		query.append("               AND SKD_DIR_CD   = @[skd_dir_cd]" ).append("\n"); 
		query.append("           )," ).append("\n"); 
		query.append("       NVL((" ).append("\n"); 
		query.append("            SELECT DECODE(DEL.LOC_CHR_CD||POD.LOC_CHR_CD, 'PRTPRT', 'NLO', DECODE(@[del_cd], @[pod_cd], 'NLO', 'NIP'))" ).append("\n"); 
		query.append("              FROM MDM_LOCATION DEL, MDM_LOCATION POD" ).append("\n"); 
		query.append("             WHERE DEL.LOC_CD = @[del_cd]   " ).append("\n"); 
		query.append("               AND DEL.DELT_FLG = 'N'" ).append("\n"); 
		query.append("               AND POD.LOC_CD = @[pod_cd] " ).append("\n"); 
		query.append("               AND POD.DELT_FLG = 'N'" ).append("\n"); 
		query.append("               AND NVL(@[pst_rly_port_cd], 'X') <> 'X'" ).append("\n"); 
		query.append("           ),(" ).append("\n"); 
		query.append("            SELECT DECODE(LENGTH(@[ocp_cd]), 5, 'COC'," ).append("\n"); 
		query.append("                   DECODE(DEL.LOC_CHR_CD||POD.LOC_CHR_CD" ).append("\n"); 
		query.append("                 , 'ECPGCP', 'CLO', 'GCPECP', 'CLO'" ).append("\n"); 
		query.append("                 , 'ECPECP', 'CLO', 'WCPWCP', 'CLO', 'PRTPRT', 'CLO'" ).append("\n"); 
		query.append("                 , DECODE(@[del_cd], @[pod_cd], 'CLO'" ).append("\n"); 
		query.append("                 , DECODE(DEL.LOC_CHR_CD||POD.LOC_CHR_CD" ).append("\n"); 
		query.append("                 , 'ECPWCP', 'CML', 'WCPECP', 'CML'" ).append("\n"); 
		query.append("                 , 'GCPWCP', 'CML', 'WCPGCP', 'CML'" ).append("\n"); 
		query.append("                 , 'CIP'))))" ).append("\n"); 
		query.append("              FROM MDM_LOCATION DEL, MDM_LOCATION POD" ).append("\n"); 
		query.append("             WHERE DEL.LOC_CD = @[del_cd]" ).append("\n"); 
		query.append("               AND DEL.DELT_FLG = 'N'" ).append("\n"); 
		query.append("               AND POD.LOC_CD = @[pod_cd]" ).append("\n"); 
		query.append("               AND POD.DELT_FLG = 'N'" ).append("\n"); 
		query.append("               AND NVL(@[pst_rly_port_cd], 'X') = 'X'" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("       ))) AS DST_SVC_MODE" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}
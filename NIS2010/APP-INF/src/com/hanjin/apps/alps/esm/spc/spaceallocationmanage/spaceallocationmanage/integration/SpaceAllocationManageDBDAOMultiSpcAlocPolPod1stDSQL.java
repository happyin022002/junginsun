/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SpaceAllocationManageDBDAOMultiSpcAlocPolPod1stDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.08
*@LastModifier : 신자영
*@LastVersion : 1.0
* 2014.12.08 신자영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SHIN JA YOUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpaceAllocationManageDBDAOMultiSpcAlocPolPod1stDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MultiSpcAlocPolPod044
	  * 2014.08.12 [CHM-201431081] SPC Allocation Control Option 추가 보완 요청건_FNC 우선제거
	  * </pre>
	  */
	public SpaceAllocationManageDBDAOMultiSpcAlocPolPod1stDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("office",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("week",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAOMultiSpcAlocPolPod1stDSQL").append("\n"); 
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
		query.append("DELETE" ).append("\n"); 
		query.append("  FROM SPC_ALOC_POL_POD" ).append("\n"); 
		query.append("  WHERE   " ).append("\n"); 
		query.append("        ( RLANE_CD,    DIR_CD ,    VSL_CD,        SKD_VOY_NO,   SKD_DIR_CD ," ).append("\n"); 
		query.append("          SLS_OFC_CD , POL_YD_CD,  POD_YD_CD,     TS_FLG,       MNL_FLG ," ).append("\n"); 
		query.append("          --20140812 추가" ).append("\n"); 
		query.append("          CUST_CNT_CD, CUST_SEQ, CTRT_NO, USA_BKG_MOD_CD,DEST_LOC_CD" ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append(" IN            " ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append(" WITH PARAMS AS (" ).append("\n"); 
		query.append("    SELECT @[year]             AS YEAR      ," ).append("\n"); 
		query.append("           @[week]              AS WEEK      ," ).append("\n"); 
		query.append("           o.ofc_cd             AS OFC_CD    ," ).append("\n"); 
		query.append("           @[lane]              AS RLANE_CD  ," ).append("\n"); 
		query.append("           @[bound]              AS DIR_CD    ," ).append("\n"); 
		query.append("           @[vsl_cd]  AS VSL_CD    ," ).append("\n"); 
		query.append("           @[skd_voy_no]  AS SKD_VOY_NO," ).append("\n"); 
		query.append("           @[skd_dir_cd]    AS SKD_DIR_CD," ).append("\n"); 
		query.append("           l.conti_cd           AS OFC_CONTI ," ).append("\n"); 
		query.append("           '2'             AS STS" ).append("\n"); 
		query.append("      FROM MDM_LOCATION     L," ).append("\n"); 
		query.append("           MDM_ORGANIZATION O" ).append("\n"); 
		query.append("     WHERE L.LOC_CD = O.LOC_CD" ).append("\n"); 
		query.append("#if (${user_ofc} == 'SZPDC')" ).append("\n"); 
		query.append("       AND O.OFC_CD = @[user_ofc]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	#if (${office} == '')" ).append("\n"); 
		query.append("       AND O.OFC_CD = 'SHARC'" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("       AND O.OFC_CD = @[office]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(",  ALL_DATA AS (" ).append("\n"); 
		query.append("               --Allocation" ).append("\n"); 
		query.append("              SELECT " ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("                     A.RLANE_CD,    " ).append("\n"); 
		query.append("                     A.DIR_CD ,     " ).append("\n"); 
		query.append("                     A.VSL_CD,   " ).append("\n"); 
		query.append("                     A.SKD_VOY_NO,   " ).append("\n"); 
		query.append("                     A.SKD_DIR_CD , " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${office} == '')" ).append("\n"); 
		query.append("                     DECODE(P.OFC_CD, A.SLS_RHQ_CD, A.SLS_OFC_CD, DECODE(A.SLS_RHQ_CD, 'SINRS', A.SLS_OFC_CD, DECODE(A.RLANE_CD, 'WAFIE', A.SLS_RGN_OFC_CD, DECODE(A.TS_FLG, 'Y', A.SLS_RHQ_CD, A.SLS_OFC_CD)))) AS SLS_OFC_CD ," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                     DECODE(P.OFC_CD, A.SLS_RHQ_CD, A.SLS_OFC_CD, DECODE(A.RLANE_CD, 'WAFIE', A.SLS_RGN_OFC_CD, DECODE(A.TS_FLG, 'Y', A.SLS_RHQ_CD, A.SLS_OFC_CD))) AS SLS_OFC_CD ," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("                     A.POL_YD_CD,   " ).append("\n"); 
		query.append("                     A.POD_YD_CD,  " ).append("\n"); 
		query.append("                     A.TS_FLG TS_FLG,   " ).append("\n"); 
		query.append("                     A.MNL_FLG ," ).append("\n"); 
		query.append("                     --20140812 추가" ).append("\n"); 
		query.append("                     A.CUST_CNT_CD,  " ).append("\n"); 
		query.append("                     A.CUST_SEQ,   " ).append("\n"); 
		query.append("                     A.CTRT_NO,   " ).append("\n"); 
		query.append("                     A.USA_BKG_MOD_CD, " ).append("\n"); 
		query.append("                     A.DEST_LOC_CD    " ).append("\n"); 
		query.append("                FROM SPC_ALOC_POL_POD A  ," ).append("\n"); 
		query.append("                     PARAMS      P" ).append("\n"); 
		query.append("               WHERE A.RLANE_CD   = P.RLANE_CD" ).append("\n"); 
		query.append("                 AND A.DIR_CD     = P.DIR_CD" ).append("\n"); 
		query.append("                 AND A.VSL_CD     = P.VSL_CD" ).append("\n"); 
		query.append("                 AND A.SKD_VOY_NO = P.SKD_VOY_NO" ).append("\n"); 
		query.append("                 AND A.SKD_DIR_CD = P.SKD_DIR_CD" ).append("\n"); 
		query.append("                 AND (   (     P.OFC_CONTI = (SELECT CONTI_CD" ).append("\n"); 
		query.append("                                                FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                               WHERE LOC_CD = SUBSTR(A.POL_YD_CD, 1, 5) )" ).append("\n"); 
		query.append("                           AND (   (     A.TS_FLG     = 'N'" ).append("\n"); 
		query.append("                                     AND A.SLS_OFC_CD = A.SLS_RGN_OFC_CD )" ).append("\n"); 
		query.append("                                 OR A.SLS_RGN_OFC_CD IS NULL )" ).append("\n"); 
		query.append("                         ) " ).append("\n"); 
		query.append("         			OR P.RLANE_CD = 'WAFIE' " ).append("\n"); 
		query.append("                      OR" ).append("\n"); 
		query.append("#if (${office} == '')" ).append("\n"); 
		query.append("                         A.SLS_RHQ_CD IN ( P.OFC_CD, 'SINRS' )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                         A.SLS_RHQ_CD = P.OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("                      " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("   SELECT  " ).append("\n"); 
		query.append("             Z.RLANE_CD,    " ).append("\n"); 
		query.append("             Z.DIR_CD ,     " ).append("\n"); 
		query.append("             Z.VSL_CD,   " ).append("\n"); 
		query.append("             Z.SKD_VOY_NO,   " ).append("\n"); 
		query.append("             Z.SKD_DIR_CD ," ).append("\n"); 
		query.append("             Z.SLS_OFC_CD , " ).append("\n"); 
		query.append("             Z.POL_YD_CD,   " ).append("\n"); 
		query.append("             Z.POD_YD_CD,  " ).append("\n"); 
		query.append("             Z.TS_FLG,   " ).append("\n"); 
		query.append("             Z.MNL_FLG," ).append("\n"); 
		query.append("             --20140812 추가" ).append("\n"); 
		query.append("             Z.CUST_CNT_CD,  " ).append("\n"); 
		query.append("             Z.CUST_SEQ,   " ).append("\n"); 
		query.append("             Z.CTRT_NO,  " ).append("\n"); 
		query.append("             Z.USA_BKG_MOD_CD, " ).append("\n"); 
		query.append("             Z.DEST_LOC_CD             " ).append("\n"); 
		query.append("        FROM ALL_DATA Z " ).append("\n"); 
		query.append("#if (${office} == '')" ).append("\n"); 
		query.append("     UNION ALL " ).append("\n"); 
		query.append("        --Allocation" ).append("\n"); 
		query.append("      SELECT" ).append("\n"); 
		query.append("             A.RLANE_CD,    " ).append("\n"); 
		query.append("             A.DIR_CD ,     " ).append("\n"); 
		query.append("             A.VSL_CD,   " ).append("\n"); 
		query.append("             A.SKD_VOY_NO,   " ).append("\n"); 
		query.append("             A.SKD_DIR_CD ," ).append("\n"); 
		query.append("             A.SLS_OFC_CD , " ).append("\n"); 
		query.append("             A.POL_YD_CD,   " ).append("\n"); 
		query.append("             A.POD_YD_CD,  " ).append("\n"); 
		query.append("             A.TS_FLG,   " ).append("\n"); 
		query.append("             A.MNL_FLG," ).append("\n"); 
		query.append("             --20140812 추가" ).append("\n"); 
		query.append("             A.CUST_CNT_CD,  " ).append("\n"); 
		query.append("             A.CUST_SEQ,    " ).append("\n"); 
		query.append("             A.CTRT_NO,   " ).append("\n"); 
		query.append("             A.USA_BKG_MOD_CD, " ).append("\n"); 
		query.append("             A.DEST_LOC_CD              " ).append("\n"); 
		query.append("        FROM SPC_ALOC_POL_POD A  ," ).append("\n"); 
		query.append("             PARAMS      P           " ).append("\n"); 
		query.append("       WHERE A.RLANE_CD   = P.RLANE_CD" ).append("\n"); 
		query.append("         AND A.DIR_CD     = P.DIR_CD" ).append("\n"); 
		query.append("         AND A.VSL_CD     = P.VSL_CD" ).append("\n"); 
		query.append("         AND A.SKD_VOY_NO = P.SKD_VOY_NO" ).append("\n"); 
		query.append("         AND A.SKD_DIR_CD = P.SKD_DIR_CD" ).append("\n"); 
		query.append("         AND A.SLS_OFC_CD IN ('HAMRU', 'NYCRA')" ).append("\n"); 
		query.append("         AND P.RLANE_CD   = 'WAFIE'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}

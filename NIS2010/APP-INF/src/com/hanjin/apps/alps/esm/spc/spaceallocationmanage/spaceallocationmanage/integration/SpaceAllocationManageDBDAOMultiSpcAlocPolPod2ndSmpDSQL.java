/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SpaceAllocationManageDBDAOMultiSpcAlocPolPod2ndSmpDSQL.java
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

public class SpaceAllocationManageDBDAOMultiSpcAlocPolPod2ndSmpDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 성수기 Alloc Copy 시 데이터 삭제
	  * * 2013.06.26 진마리아 [CHM-201325016-01] 성수기 Alloc copy 기능 개발
	  * 2014.08.12 [CHM-201431081] SPC Allocation Control Option 추가 보완 요청건
	  * </pre>
	  */
	public SpaceAllocationManageDBDAOMultiSpcAlocPolPod2ndSmpDSQL(){
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
		params.put("fcast",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : SpaceAllocationManageDBDAOMultiSpcAlocPolPod2ndSmpDSQL").append("\n"); 
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
		query.append("  FROM SPC_ALOC_CUST_POL_POD" ).append("\n"); 
		query.append("  WHERE   " ).append("\n"); 
		query.append("   ( RLANE_CD,    DIR_CD ,     VSL_CD,     SKD_VOY_NO,   SKD_DIR_CD ," ).append("\n"); 
		query.append("     SLS_OFC_CD , POL_YD_CD,   POD_YD_CD,  TS_FLG,       MNL_FLG," ).append("\n"); 
		query.append("     --20140812 추가" ).append("\n"); 
		query.append("     CUST_CNT_CD,  CUST_SEQ, CTRT_NO, USA_BKG_MOD_CD,DEST_LOC_CD ) " ).append("\n"); 
		query.append(" IN            " ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append("  WITH BASE_KEY AS (" ).append("\n"); 
		query.append("    SELECT          " ).append("\n"); 
		query.append("           @[year]       AS YEAR      ," ).append("\n"); 
		query.append("           @[week]       AS WEEK      ," ).append("\n"); 
		query.append("           @[office]     AS RHQ_CD    ," ).append("\n"); 
		query.append("           @[lane]       AS RLANE_CD  ," ).append("\n"); 
		query.append("           @[bound]      AS DIR_CD    ," ).append("\n"); 
		query.append("           @[vsl_cd]      AS VSL_CD    ," ).append("\n"); 
		query.append("           @[skd_voy_no]  AS SKD_VOY_NO," ).append("\n"); 
		query.append("           @[skd_dir_cd]  AS SKD_DIR_CD," ).append("\n"); 
		query.append("           @[fcast]      AS FCAST     ," ).append("\n"); 
		query.append("           L.CONTI_CD    AS OFC_CONTI ," ).append("\n"); 
		query.append("           O.OFC_CD      AS OFC_CD" ).append("\n"); 
		query.append("      FROM MDM_LOCATION     L," ).append("\n"); 
		query.append("           MDM_ORGANIZATION O" ).append("\n"); 
		query.append("     WHERE L.LOC_CD = O.LOC_CD" ).append("\n"); 
		query.append("       AND O.OFC_CD = @[office]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(" SELECT " ).append("\n"); 
		query.append("        D.RLANE_CD,  D.DIR_CD ,  D.VSL_CD,  D.SKD_VOY_NO,  D.SKD_DIR_CD ," ).append("\n"); 
		query.append("        D.SLS_OFC_CD ,  D.POL_YD_CD,  D.POD_YD_CD ,  D.TS_FLG,  D.MNL_FLG," ).append("\n"); 
		query.append("        --20140812 추가" ).append("\n"); 
		query.append("        D.CUST_CNT_CD,  D.CUST_SEQ, D.CTRT_NO, D.USA_BKG_MOD_CD, D.DEST_LOC_CD  " ).append("\n"); 
		query.append("   FROM SPC_ALOC_CUST_POL_POD D," ).append("\n"); 
		query.append("        BASE_KEY         B" ).append("\n"); 
		query.append("  WHERE D.RLANE_CD   = B.RLANE_CD" ).append("\n"); 
		query.append("    AND D.DIR_CD     = B.DIR_CD" ).append("\n"); 
		query.append("    AND D.VSL_CD     = B.VSL_CD" ).append("\n"); 
		query.append("    AND D.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND D.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND (   D.SLS_RHQ_CD = B.RHQ_CD " ).append("\n"); 
		query.append("         OR B.OFC_CONTI = (SELECT CONTI_CD" ).append("\n"); 
		query.append("                             FROM MDM_LOCATION" ).append("\n"); 
		query.append("                            WHERE LOC_CD = SUBSTR(D.POL_YD_CD, 1, 5) )" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    AND D.TS_FLG     = 'N'" ).append("\n"); 
		query.append("  --  AND D.SLS_OFC_CD = D.SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("  UNION ALL    " ).append("\n"); 
		query.append(" SELECT" ).append("\n"); 
		query.append("        D.RLANE_CD,  D.DIR_CD ,  D.VSL_CD,  D.SKD_VOY_NO,  D.SKD_DIR_CD ," ).append("\n"); 
		query.append("        D.SLS_OFC_CD ,  D.POL_YD_CD,  D.POD_YD_CD ,  D.TS_FLG,  D.MNL_FLG," ).append("\n"); 
		query.append("        --20140812 추가" ).append("\n"); 
		query.append("        D.CUST_CNT_CD,  D.CUST_SEQ, D.CTRT_NO, D.USA_BKG_MOD_CD, D.DEST_LOC_CD " ).append("\n"); 
		query.append("   FROM SPC_ALOC_CUST_POL_POD D," ).append("\n"); 
		query.append("        BASE_KEY         B" ).append("\n"); 
		query.append("  WHERE D.RLANE_CD   = B.RLANE_CD" ).append("\n"); 
		query.append("    AND D.DIR_CD     = B.DIR_CD" ).append("\n"); 
		query.append("    AND D.VSL_CD     = B.VSL_CD" ).append("\n"); 
		query.append("    AND D.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND D.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND 'A' <> (SELECT CONTI_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                 WHERE LOC_CD = SUBSTR(D.POL_YD_CD, 1, 5) )" ).append("\n"); 
		query.append("    AND D.TS_FLG     = 'Y'" ).append("\n"); 
		query.append("  --  AND D.SLS_OFC_CD = D.SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("    AND (" ).append("\n"); 
		query.append("          (   " ).append("\n"); 
		query.append("             D.SLS_RHQ_CD = B.RHQ_CD " ).append("\n"); 
		query.append("          OR B.OFC_CONTI = (SELECT CONTI_CD" ).append("\n"); 
		query.append("                              FROM MDM_LOCATION" ).append("\n"); 
		query.append("                             WHERE LOC_CD = SUBSTR(D.POL_YD_CD, 1, 5) )" ).append("\n"); 
		query.append("          ) " ).append("\n"); 
		query.append("          OR DECODE(B.RHQ_CD, 'NYCRA', 'M', 'E') = (SELECT CONTI_CD" ).append("\n"); 
		query.append("                                                      FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                                     WHERE LOC_CD = SUBSTR(D.POL_YD_CD, 1, 5) )" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("  UNION ALL " ).append("\n"); 
		query.append("  SELECT" ).append("\n"); 
		query.append("         D.RLANE_CD,  D.DIR_CD ,  D.VSL_CD,  D.SKD_VOY_NO,  D.SKD_DIR_CD ," ).append("\n"); 
		query.append("         D.SLS_OFC_CD ,  D.POL_YD_CD,  D.POD_YD_CD ,  D.TS_FLG,  D.MNL_FLG," ).append("\n"); 
		query.append("         --20140812 추가" ).append("\n"); 
		query.append("         D.CUST_CNT_CD,  D.CUST_SEQ, D.CTRT_NO, D.USA_BKG_MOD_CD, D.DEST_LOC_CD " ).append("\n"); 
		query.append("    FROM SPC_ALOC_CUST_POL_POD D  ," ).append("\n"); 
		query.append("         BASE_KEY         P " ).append("\n"); 
		query.append("   WHERE D.RLANE_CD   = P.RLANE_CD" ).append("\n"); 
		query.append("   AND D.DIR_CD     = P.DIR_CD" ).append("\n"); 
		query.append("   AND D.VSL_CD     = P.VSL_CD" ).append("\n"); 
		query.append("   AND D.SKD_VOY_NO = P.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND D.SKD_DIR_CD = P.SKD_DIR_CD         " ).append("\n"); 
		query.append("   AND P.RLANE_CD   = 'WAFIE' " ).append("\n"); 
		query.append("#if (${office} == 'HAMRU')" ).append("\n"); 
		query.append("   AND D.SLS_OFC_CD in ('HAMRU', 'NYCRA')" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("   AND D.SLS_OFC_CD = @[office]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}

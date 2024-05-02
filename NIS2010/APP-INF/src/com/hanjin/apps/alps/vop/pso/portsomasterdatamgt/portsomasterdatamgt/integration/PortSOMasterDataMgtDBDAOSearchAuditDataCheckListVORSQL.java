/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : PortSOMasterDataMgtDBDAOSearchAuditDataCheckListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortSOMasterDataMgtDBDAOSearchAuditDataCheckListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 선박 vessel 조회
	  * </pre>
	  */
	public PortSOMasterDataMgtDBDAOSearchAuditDataCheckListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srh_cnd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",200";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_date",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.integration").append("\n"); 
		query.append("FileName : PortSOMasterDataMgtDBDAOSearchAuditDataCheckListVORSQL").append("\n"); 
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
		query.append("SELECT   /*+PUSH_SUBQ */       VSL_CD,     -- Vessel Code" ).append("\n"); 
		query.append("  VSL_ENG_NM,           -- Vessel Name" ).append("\n"); 
		query.append("  decode ( GRS_RGST_TONG_WGT,  NULL , 'X' , RTRIM(RTRIM(TO_CHAR(GRS_RGST_TONG_WGT, 'FM9,999,9,999,9,999,990.0000'), '0'), '.') ) GRS_RGST_TONG_WGT,  -- GRT" ).append("\n"); 
		query.append("  decode ( NET_RGST_TONG_WGT, NULL , 'X' , RTRIM(RTRIM(TO_CHAR(NET_RGST_TONG_WGT, 'FM9,999,9,999,9,999,990.0000'), '0'), '.') ) NET_RGST_TONG_WGT,  -- NRT" ).append("\n"); 
		query.append("  decode ( CNTR_VSL_CLSS_CAPA, NULL , 'X' , RTRIM(RTRIM(TO_CHAR(CNTR_VSL_CLSS_CAPA, 'FM9,999,9,999,9,999,990.0000'), '0'), '.') ) CNTR_VSL_CLSS_CAPA,   -- Class" ).append("\n"); 
		query.append("  decode ( LOA_LEN,  NULL , 'X' , RTRIM(RTRIM(TO_CHAR(LOA_LEN, 'FM9,999,9,999,9,999,990.0000'), '0'), '.') ) LOA_LEN,    -- LOA" ).append("\n"); 
		query.append("  decode ( DWT_WGT,  NULL , 'X' , RTRIM(RTRIM(TO_CHAR(DWT_WGT, 'FM9,999,9,999,9,999,990.0000'), '0'), '.') ) DWT_WGT,    -- DWT" ).append("\n"); 
		query.append("  decode ( MADN_VOY_SUZ_NET_TONG_WGT,  NULL , 'X' , RTRIM(RTRIM(TO_CHAR(MADN_VOY_SUZ_NET_TONG_WGT, 'FM9,999,9,999,9,999,990.0000'), '0'), '.') ) CRW_KNT,    -- Crew Count" ).append("\n"); 
		query.append("  decode ( VSL_RGST_CNT_CD, NULL , 'X' , VSL_RGST_CNT_CD ) VSL_RGST_CNT_CD,   -- Nationallity" ).append("\n"); 
		query.append("  decode ( VSL_DPTH,  NULL , 'X' , RTRIM(RTRIM(TO_CHAR(VSL_DPTH, 'FM9,999,9,999,9,999,990.0000'), '0'), '.') ) VSL_DPTH,    -- Depth" ).append("\n"); 
		query.append("--  CNTR_PNM_CAPA,  " ).append("\n"); 
		query.append("  decode ( CASE WHEN VSL_WDT > 32.3 THEN NULL ELSE CNTR_PNM_CAPA END,  NULL , 'X' , RTRIM(RTRIM(TO_CHAR(CNTR_PNM_CAPA, 'FM9,999,9,999,9,999,990.0000'), '0'), '.') ) CNTR_PNM_CAPA,   -- Allowance TEU " ).append("\n"); 
		query.append("  decode ( VSL_WDT,  NULL , 'X' , RTRIM(RTRIM(TO_CHAR(VSL_WDT, 'FM9,999,9,999,9,999,990.0000'), '0'), '.') ) VSL_WDT,    -- Beam" ).append("\n"); 
		query.append("  decode ( SMR_DRFT_HGT , NULL , 'X' , RTRIM(RTRIM(TO_CHAR(SMR_DRFT_HGT, 'FM9,999,9,999,9,999,990.0000'), '0'), '.') ) SMR_DRFT_HGT   -- Summer Draft" ).append("\n"); 
		query.append("FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("WHERE 1 = @[srh_cnd]" ).append("\n"); 
		query.append("AND    VSL_CD IN (" ).append("\n"); 
		query.append("                        SELECT VSL_CD" ).append("\n"); 
		query.append("                        FROM    VSK_VSL_PORT_SKD T1, MDM_VSL_SVC_LANE T2" ).append("\n"); 
		query.append("                        WHERE   CLPT_SEQ    = 1" ).append("\n"); 
		query.append("                        AND     VPS_ETA_DT  BETWEEN TO_DATE(@[from_date], 'YYYYMM')" ).append("\n"); 
		query.append("                                            AND     LAST_DAY(TO_DATE(@[to_date], 'YYYYMM'))  + 0.99999" ).append("\n"); 
		query.append("                        AND     T1.SLAN_CD  = T2.VSL_SLAN_CD" ).append("\n"); 
		query.append("                        AND     T2.VSL_SVC_TP_CD IN ('I', 'J', 'C')" ).append("\n"); 
		query.append("                        AND     T2.DELT_FLG = 'N'    " ).append("\n"); 
		query.append("                        GROUP BY VSL_CD" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("AND CRR_CD = 'SML'" ).append("\n"); 
		query.append("AND VSL_CLSS_FLG <> 'T'" ).append("\n"); 
		query.append("--AND DECODE(GRS_RGST_TONG_WGT,NULL,NULL,1) * DECODE(NET_RGST_TONG_WGT,NULL,NULL,1) * DECODE(LOA_LEN   ,NULL,NULL,1) = 1" ).append("\n"); 
		query.append("AND 1=1" ).append("\n"); 
		query.append("union all" ).append("\n"); 
		query.append("SELECT   /*+PUSH_SUBQ */       VSL_CD,     -- Vessel Code" ).append("\n"); 
		query.append("  VSL_ENG_NM,           -- Vessel Name" ).append("\n"); 
		query.append("  decode ( GRS_RGST_TONG_WGT,  NULL , 'X' , RTRIM(RTRIM(TO_CHAR(GRS_RGST_TONG_WGT, 'FM9,999,9,999,9,999,990.0000'), '0'), '.') ) GRS_RGST_TONG_WGT,  -- GRT" ).append("\n"); 
		query.append("  decode ( NET_RGST_TONG_WGT, NULL , 'X' , RTRIM(RTRIM(TO_CHAR(NET_RGST_TONG_WGT, 'FM9,999,9,999,9,999,990.0000'), '0'), '.') ) NET_RGST_TONG_WGT,  -- NRT" ).append("\n"); 
		query.append("  decode ( CNTR_VSL_CLSS_CAPA, NULL , 'X' , RTRIM(RTRIM(TO_CHAR(CNTR_VSL_CLSS_CAPA, 'FM9,999,9,999,9,999,990.0000'), '0'), '.') ) CNTR_VSL_CLSS_CAPA,   -- Class" ).append("\n"); 
		query.append("  decode ( LOA_LEN,  NULL , 'X' , RTRIM(RTRIM(TO_CHAR(LOA_LEN, 'FM9,999,9,999,9,999,990.0000'), '0'), '.') ) LOA_LEN,    -- LOA" ).append("\n"); 
		query.append("  decode ( DWT_WGT,  NULL , 'X' , RTRIM(RTRIM(TO_CHAR(DWT_WGT, 'FM9,999,9,999,9,999,990.0000'), '0'), '.') ) DWT_WGT,    -- DWT" ).append("\n"); 
		query.append("  decode ( MADN_VOY_SUZ_NET_TONG_WGT,  NULL , 'X' , RTRIM(RTRIM(TO_CHAR(MADN_VOY_SUZ_NET_TONG_WGT, 'FM9,999,9,999,9,999,990.0000'), '0'), '.') ) CRW_KNT,    -- Crew Count" ).append("\n"); 
		query.append("  decode ( VSL_RGST_CNT_CD, NULL , 'X' , VSL_RGST_CNT_CD ) VSL_RGST_CNT_CD,   -- Nationallity" ).append("\n"); 
		query.append("  decode ( VSL_DPTH,  NULL , 'X' , RTRIM(RTRIM(TO_CHAR(VSL_DPTH, 'FM9,999,9,999,9,999,990.0000'), '0'), '.') ) VSL_DPTH,    -- Depth" ).append("\n"); 
		query.append("--  CNTR_PNM_CAPA,  " ).append("\n"); 
		query.append("  decode ( CASE WHEN VSL_WDT > 32.3 THEN NULL ELSE CNTR_PNM_CAPA END,  NULL , 'X' , RTRIM(RTRIM(TO_CHAR(CNTR_PNM_CAPA, 'FM9,999,9,999,9,999,990.0000'), '0'), '.') ) CNTR_PNM_CAPA,   -- Allowance TEU " ).append("\n"); 
		query.append("  decode ( VSL_WDT,  NULL , 'X' , RTRIM(RTRIM(TO_CHAR(VSL_WDT, 'FM9,999,9,999,9,999,990.0000'), '0'), '.') ) VSL_WDT,    -- Beam" ).append("\n"); 
		query.append("  decode ( SMR_DRFT_HGT , NULL , 'X' , RTRIM(RTRIM(TO_CHAR(SMR_DRFT_HGT, 'FM9,999,9,999,9,999,990.0000'), '0'), '.') ) SMR_DRFT_HGT   -- Summer Draft" ).append("\n"); 
		query.append("FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND    VSL_CD IN (" ).append("\n"); 
		query.append("                        SELECT VSL_CD" ).append("\n"); 
		query.append("                        FROM    VSK_VSL_PORT_SKD T1, MDM_VSL_SVC_LANE T2" ).append("\n"); 
		query.append("                        WHERE   CLPT_SEQ    = 1" ).append("\n"); 
		query.append("                        AND     VPS_ETA_DT  BETWEEN TO_DATE(@[from_date], 'YYYYMM')" ).append("\n"); 
		query.append("                                            AND     LAST_DAY(TO_DATE(@[to_date], 'YYYYMM'))  + 0.99999" ).append("\n"); 
		query.append("                        AND     T1.SLAN_CD  = T2.VSL_SLAN_CD" ).append("\n"); 
		query.append("                        AND     T2.VSL_SVC_TP_CD IN ('I', 'J', 'C')" ).append("\n"); 
		query.append("                        AND     T2.DELT_FLG = 'N'    " ).append("\n"); 
		query.append("                        GROUP BY VSL_CD" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("AND CRR_CD = 'SML'" ).append("\n"); 
		query.append("AND VSL_CLSS_FLG <> 'T'" ).append("\n"); 
		query.append("--AND DECODE(GRS_RGST_TONG_WGT,NULL,NULL,1) * DECODE(NET_RGST_TONG_WGT,NULL,NULL,1) * DECODE(LOA_LEN   ,NULL,NULL,1) = 1  " ).append("\n"); 
		query.append("AND   decode ( GRS_RGST_TONG_WGT,  NULL , 0 , 1 )" ).append("\n"); 
		query.append("*decode ( NET_RGST_TONG_WGT, NULL , 0 , 1 )" ).append("\n"); 
		query.append("*decode ( CNTR_VSL_CLSS_CAPA, NULL , 0 , 1 )" ).append("\n"); 
		query.append("*decode ( LOA_LEN,  NULL , 0 , 1 )" ).append("\n"); 
		query.append("*decode ( DWT_WGT,  NULL , 0 , 1 )" ).append("\n"); 
		query.append("*decode ( MADN_VOY_SUZ_NET_TONG_WGT,  NULL , 0 , 1 )" ).append("\n"); 
		query.append("--*decode ( VSL_RGST_CNT_CD, NULL , 0 , 1 )" ).append("\n"); 
		query.append("--*decode ( VSL_DPTH,  NULL , 0 , 1 ) " ).append("\n"); 
		query.append("*decode ( CASE WHEN VSL_WDT > 32.22 THEN NULL ELSE CNTR_PNM_CAPA END,  NULL , 0 , 1 )" ).append("\n"); 
		query.append("*decode ( VSL_WDT,  NULL , 0 , 1 )" ).append("\n"); 
		query.append("*decode ( SMR_DRFT_HGT , NULL , 0 , 1 ) = 1" ).append("\n"); 
		query.append("and 2=@[srh_cnd]" ).append("\n"); 
		query.append("union all" ).append("\n"); 
		query.append("SELECT   /*+PUSH_SUBQ */       VSL_CD,     -- Vessel Code" ).append("\n"); 
		query.append("  VSL_ENG_NM,           -- Vessel Name" ).append("\n"); 
		query.append("  decode ( GRS_RGST_TONG_WGT,  NULL , 'X' , RTRIM(RTRIM(TO_CHAR(GRS_RGST_TONG_WGT, 'FM9,999,9,999,9,999,990.0000'), '0'), '.') ) GRS_RGST_TONG_WGT,  -- GRT" ).append("\n"); 
		query.append("  decode ( NET_RGST_TONG_WGT, NULL , 'X' , RTRIM(RTRIM(TO_CHAR(NET_RGST_TONG_WGT, 'FM9,999,9,999,9,999,990.0000'), '0'), '.') ) NET_RGST_TONG_WGT,  -- NRT" ).append("\n"); 
		query.append("  decode ( CNTR_VSL_CLSS_CAPA, NULL , 'X' , RTRIM(RTRIM(TO_CHAR(CNTR_VSL_CLSS_CAPA, 'FM9,999,9,999,9,999,990.0000'), '0'), '.') ) CNTR_VSL_CLSS_CAPA,   -- Class" ).append("\n"); 
		query.append("  decode ( LOA_LEN,  NULL , 'X' , RTRIM(RTRIM(TO_CHAR(LOA_LEN, 'FM9,999,9,999,9,999,990.0000'), '0'), '.') ) LOA_LEN,    -- LOA" ).append("\n"); 
		query.append("  decode ( DWT_WGT,  NULL , 'X' , RTRIM(RTRIM(TO_CHAR(DWT_WGT, 'FM9,999,9,999,9,999,990.0000'), '0'), '.') ) DWT_WGT,    -- DWT" ).append("\n"); 
		query.append("  decode ( MADN_VOY_SUZ_NET_TONG_WGT,  NULL , 'X' , RTRIM(RTRIM(TO_CHAR(MADN_VOY_SUZ_NET_TONG_WGT, 'FM9,999,9,999,9,999,990.0000'), '0'), '.') ) CRW_KNT,    -- Crew Count" ).append("\n"); 
		query.append("  decode ( VSL_RGST_CNT_CD, NULL , 'X' , VSL_RGST_CNT_CD ) VSL_RGST_CNT_CD,   -- Nationallity" ).append("\n"); 
		query.append("  decode ( VSL_DPTH,  NULL , 'X' , RTRIM(RTRIM(TO_CHAR(VSL_DPTH, 'FM9,999,9,999,9,999,990.0000'), '0'), '.') ) VSL_DPTH,    -- Depth" ).append("\n"); 
		query.append("--  CNTR_PNM_CAPA,  " ).append("\n"); 
		query.append("  decode ( CASE WHEN VSL_WDT > 32.3 THEN NULL ELSE CNTR_PNM_CAPA END,  NULL , 'X' , RTRIM(RTRIM(TO_CHAR(CNTR_PNM_CAPA, 'FM9,999,9,999,9,999,990.0000'), '0'), '.') ) CNTR_PNM_CAPA,   -- Allowance TEU " ).append("\n"); 
		query.append("  decode ( VSL_WDT,  NULL , 'X' , RTRIM(RTRIM(TO_CHAR(VSL_WDT, 'FM9,999,9,999,9,999,990.0000'), '0'), '.') ) VSL_WDT,    -- Beam" ).append("\n"); 
		query.append("  decode ( SMR_DRFT_HGT , NULL , 'X' , RTRIM(RTRIM(TO_CHAR(SMR_DRFT_HGT, 'FM9,999,9,999,9,999,990.0000'), '0'), '.') ) SMR_DRFT_HGT   -- Summer Draft" ).append("\n"); 
		query.append("FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND    VSL_CD IN (" ).append("\n"); 
		query.append("                        SELECT VSL_CD" ).append("\n"); 
		query.append("                        FROM    VSK_VSL_PORT_SKD T1, MDM_VSL_SVC_LANE T2" ).append("\n"); 
		query.append("                        WHERE   CLPT_SEQ    = 1" ).append("\n"); 
		query.append("                        AND     VPS_ETA_DT  BETWEEN TO_DATE(@[from_date], 'YYYYMM')" ).append("\n"); 
		query.append("                                            AND     LAST_DAY(TO_DATE(@[to_date], 'YYYYMM'))  + 0.99999" ).append("\n"); 
		query.append("                        AND     T1.SLAN_CD  = T2.VSL_SLAN_CD" ).append("\n"); 
		query.append("                        AND     T2.VSL_SVC_TP_CD IN ('I', 'J', 'C')" ).append("\n"); 
		query.append("                        AND     T2.DELT_FLG = 'N'    " ).append("\n"); 
		query.append("                        GROUP BY VSL_CD" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("AND CRR_CD = 'SML'" ).append("\n"); 
		query.append("AND VSL_CLSS_FLG <> 'T'" ).append("\n"); 
		query.append("--AND DECODE(GRS_RGST_TONG_WGT,NULL,NULL,1) * DECODE(NET_RGST_TONG_WGT,NULL,NULL,1) * DECODE(LOA_LEN   ,NULL,NULL,1) = 1  " ).append("\n"); 
		query.append("AND   decode ( GRS_RGST_TONG_WGT,  NULL , 0 , 1 )" ).append("\n"); 
		query.append("*decode ( NET_RGST_TONG_WGT, NULL , 0 , 1 )" ).append("\n"); 
		query.append("*decode ( CNTR_VSL_CLSS_CAPA, NULL , 0 , 1 )" ).append("\n"); 
		query.append("*decode ( LOA_LEN,  NULL , 0 , 1 )" ).append("\n"); 
		query.append("*decode ( DWT_WGT,  NULL , 0 , 1 )" ).append("\n"); 
		query.append("*decode ( MADN_VOY_SUZ_NET_TONG_WGT,  NULL , 0 , 1 )" ).append("\n"); 
		query.append("--*decode ( VSL_RGST_CNT_CD, NULL , 0 , 1 )" ).append("\n"); 
		query.append("--*decode ( VSL_DPTH,  NULL , 0 , 1 ) " ).append("\n"); 
		query.append("*decode ( CASE WHEN VSL_WDT > 32.22 THEN NULL ELSE CNTR_PNM_CAPA END,  NULL , 0 , 1 )" ).append("\n"); 
		query.append("*decode ( VSL_WDT,  NULL , 0 , 1 )" ).append("\n"); 
		query.append("*decode ( SMR_DRFT_HGT , NULL , 0 , 1 ) = 0" ).append("\n"); 
		query.append("and 3=@[srh_cnd]" ).append("\n"); 

	}
}
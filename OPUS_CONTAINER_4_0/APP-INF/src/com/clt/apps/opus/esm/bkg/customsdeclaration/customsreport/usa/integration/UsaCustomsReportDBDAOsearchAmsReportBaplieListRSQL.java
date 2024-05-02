/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : UsaCustomsReportDBDAOsearchAmsReportBaplieListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.18
*@LastModifier : 
*@LastVersion : 1.0
* 2013.11.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsReportDBDAOsearchAmsReportBaplieListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public UsaCustomsReportDBDAOsearchAmsReportBaplieListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("last_pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fromd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tot",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntropr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("excludeca",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fromt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsReportDBDAOsearchAmsReportBaplieListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    A.ID cntr_no ," ).append("\n"); 
		query.append("    A.OPR_CD," ).append("\n"); 
		query.append("    A.POL pol," ).append("\n"); 
		query.append("    A.POD_ISO pod," ).append("\n"); 
		query.append("    A.SZTP," ).append("\n"); 
		query.append("	CASE WHEN (SELECT B.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("    FROM BKG_VVD V, BKG_CONTAINER C,  BKG_BOOKING B" ).append("\n"); 
		query.append("    WHERE A.ID = A.ID" ).append("\n"); 
		query.append("      AND A.ID = C.CNTR_NO(+)" ).append("\n"); 
		query.append("      AND V.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("      AND V.SKD_VOY_NO = A.VOY_NO" ).append("\n"); 
		query.append("      AND V.SKD_DIR_CD = A.DIR_CD" ).append("\n"); 
		query.append("      AND V.POL_CD = A.POL" ).append("\n"); 
		query.append("      AND V.POD_CD = A.POD_ISO" ).append("\n"); 
		query.append("      AND V.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("	  AND V.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("      AND ROWNUM = 1 ) = 'R' THEN 'Rev.Empty'" ).append("\n"); 
		query.append("  	ELSE DECODE (A.FE, 'E','Empty','F','Full','')" ).append("\n"); 
		query.append("	END FM_IND, " ).append("\n"); 
		query.append("    DECODE(SUBSTR(A.SZTP,  1, 1), 	'R',	'REEFER'," ).append("\n"); 
		query.append("				 					'O',	'OPEN TOP'," ).append("\n"); 
		query.append("				 					'F',	'FLAT RACK'," ).append("\n"); 
		query.append("				 					'P',	'PLATFFORM'," ).append("\n"); 
		query.append("				 					'D',	'DRY'," ).append("\n"); 
		query.append("				 					'T',	'TANK'," ).append("\n"); 
		query.append("				 					'A',	'ADJUSTABLE'," ).append("\n"); 
		query.append("				 					'S',	'OPEN TOP SLIDING'," ).append("\n"); 
		query.append("				 					'Q',	'DEAD SPACE'," ).append("\n"); 
		query.append("				 					'XX') fe," ).append("\n"); 
		query.append("    A.BAY||A.ROWW||A.TIER sti_pos," ).append("\n"); 
		query.append("    A.IMDG," ).append("\n"); 
		query.append("    A.UNNO," ).append("\n"); 
		query.append("    A.VSL_CD || A.VOY_NO || A.DIR_CD search_vvd_cd," ).append("\n"); 
		query.append("    A.PORT_CD l_pol," ).append("\n"); 
		query.append("    TO_CHAR(L.SND_DT,'YYYY-MM-DD HH24:MI') sent_time," ).append("\n"); 
		query.append("    L.POD_CD o_pod," ).append("\n"); 
		query.append("	L.ACK_RCV_STS_CD cust_result," ).append("\n"); 
		query.append("	L.RSPN_ERR_RSLT_CD||NVL2(L.RSPN_ERR_DESC, '('||L.RSPN_ERR_DESC||')', null) cust_rspn," ).append("\n"); 
		query.append("	L.CSTMS_RMK1 description," ).append("\n"); 
		query.append("	TO_CHAR(L.RCV_DT,'YYYY-MM-DD HH24:MI') receive_date," ).append("\n"); 
		query.append("	'' vvd," ).append("\n"); 
		query.append("	NVL(@[excludeca], '') excludeca," ).append("\n"); 
		query.append("	'' vsl_eng_nm, -- VO 필드추가용." ).append("\n"); 
		query.append("	'' vsl_voy, -- VO 필드추가용." ).append("\n"); 
		query.append("	'' crr_cd, -- VO 필드추가용." ).append("\n"); 
		query.append("	'' TMP1, -- 임시필드." ).append("\n"); 
		query.append("	'' TMP2, -- 임시필드." ).append("\n"); 
		query.append("	'' TMP3, -- 임시필드." ).append("\n"); 
		query.append("	'' TMP4, -- 임시필드." ).append("\n"); 
		query.append("	'' TMP5  -- 임시필드." ).append("\n"); 
		query.append("FROM BAY_PLAN A, BKG_CSTMS_ADV_STWG_CNTR L, VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("	1=1" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("	and A.VSL_CD 	= SUBSTR(@[vvd],1, 4)" ).append("\n"); 
		query.append("    and A.VOY_NO 	= SUBSTR(@[vvd],5, 4)" ).append("\n"); 
		query.append("    and A.DIR_CD 	= SUBSTR(@[vvd],9, 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${last_pol} != '')" ).append("\n"); 
		query.append("    and A.PORT_CD 	= @[last_pol]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol} != '')" ).append("\n"); 
		query.append("    AND A.POL 		= @[pol]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod} != '')" ).append("\n"); 
		query.append("    AND A.POD_ISO 	= @[pod]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${date_search} =='on')" ).append("\n"); 
		query.append("	#if (${cust_arr_exp} == 'SND')" ).append("\n"); 
		query.append("        AND L.SND_DT" ).append("\n"); 
		query.append("        BETWEEN TO_DATE(REPLACE(@[fromd], '-', '') || REPLACE(@[fromt], ':', '') ,'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("        AND TO_DATE(REPLACE(@[tod], '-', '')   || REPLACE(@[tot], ':', '')   ,'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("	#elseif (${cust_arr_exp} == 'RCV')" ).append("\n"); 
		query.append("        AND L.RCV_DT" ).append("\n"); 
		query.append("        BETWEEN TO_DATE(REPLACE(@[fromd], '-', '') || REPLACE(@[fromt], ':', '') ,'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("        AND TO_DATE(REPLACE(@[tod], '-', '')   || REPLACE(@[tot], ':', '')   ,'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntropr} != '')" ).append("\n"); 
		query.append("    AND A.OPR_CD 	= @[cntropr]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("#if (${excludeca} == 'EXCLUDECA')" ).append("\n"); 
		query.append("	AND A.POD_ISO 	NOT LIKE 'CA%' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	-- 20100426 하동일, 경종윤 " ).append("\n"); 
		query.append("    -- Exclude Canada Import가 이닐 경우 CA, US말고도 미주지역을 거쳐가는 다른 port도 나와야함" ).append("\n"); 
		query.append("	--AND (POD_ISO 	LIKE 'CA%' OR POD_ISO LIKE 'US%') " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	-- 20100608 하동일, 경종윤" ).append("\n"); 
		query.append("	-- 미국 Port 이후 부분만 FROB로 신고 되도록 로직 추가 " ).append("\n"); 
		query.append("	AND A.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("	AND A.VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("	AND A.DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("	AND A.POD_ISO = V.VPS_PORT_CD" ).append("\n"); 
		query.append("	AND V.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("	AND V.CLPT_SEQ >= (" ).append("\n"); 
		query.append("                    SELECT MIN(CLPT_SEQ)" ).append("\n"); 
		query.append("                    FROM VSK_VSL_PORT_SKD " ).append("\n"); 
		query.append("                    WHERE 1=1" ).append("\n"); 
		query.append("				#if (${vvd} != '')" ).append("\n"); 
		query.append("                    AND VSL_CD      = SUBSTR(@[vvd],1, 4)" ).append("\n"); 
		query.append("                    AND SKD_VOY_NO  = SUBSTR(@[vvd],5, 4)" ).append("\n"); 
		query.append("                    AND SKD_DIR_CD  = SUBSTR(@[vvd],9, 1)" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("                    AND VPS_PORT_CD LIKE 'US%'" ).append("\n"); 
		query.append("                    AND NVL(SKD_CNG_STS_CD, 'X') != 'S'" ).append("\n"); 
		query.append("                    AND CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    AND A.VSL_CD = L.VSL_CD(+)" ).append("\n"); 
		query.append("    AND A.VOY_NO = L.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("    AND A.DIR_CD = L.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("    AND A.ID     = L.CNTR_NO(+)" ).append("\n"); 
		query.append("    AND A.PORT_CD = L.LODG_PORT_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND A.PLAN_TYPE= ( SELECT MIN(PLAN_TYPE) FROM BAY_PLAN BB" ).append("\n"); 
		query.append("                 WHERE A.VSL_CD = BB.VSL_CD" ).append("\n"); 
		query.append("                 AND A.VOY_NO = BB.VOY_NO" ).append("\n"); 
		query.append("                 AND A.DIR_CD = BB.DIR_CD" ).append("\n"); 
		query.append("                 AND A.PORT_CD = BB.PORT_CD" ).append("\n"); 
		query.append("                 AND A.ID = BB.ID" ).append("\n"); 
		query.append("                 AND A.CALL_IND = BB.CALL_IND" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND NOT EXISTS (" ).append("\n"); 
		query.append("                    SELECT 'X'" ).append("\n"); 
		query.append("                    FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("                    WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("                    AND CSTMS_DIV_ID= 'BAPLIE_XCLD_CNTR_CD'" ).append("\n"); 
		query.append("                    AND ATTR_CTNT1 = A.ID" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${allerror} == 'ERR') " ).append("\n"); 
		query.append("	and A.POD_ISO <> L.POD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY  " ).append("\n"); 
		query.append("    A.ID" ).append("\n"); 
		query.append("    ,A.OPR_CD" ).append("\n"); 
		query.append("    ,A.POL" ).append("\n"); 
		query.append("    ,A.POD_ISO" ).append("\n"); 
		query.append("    ,A.SZTP" ).append("\n"); 
		query.append("    ,SUBSTR(A.SZTP,  1, 1)" ).append("\n"); 
		query.append("    ,A.BAY||A.ROWW||A.TIER" ).append("\n"); 
		query.append("    ,A.IMDG" ).append("\n"); 
		query.append("    ,A.UNNO" ).append("\n"); 
		query.append("    ,A.VSL_CD || A.VOY_NO || A.DIR_CD" ).append("\n"); 
		query.append("    ,A.PORT_CD" ).append("\n"); 
		query.append("    ,TO_CHAR(L.SND_DT,'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("    ,L.POD_CD" ).append("\n"); 
		query.append("	,L.ACK_RCV_STS_CD" ).append("\n"); 
		query.append("	,L.RSPN_ERR_RSLT_CD||NVL2(L.RSPN_ERR_DESC, '('||L.RSPN_ERR_DESC||')', null)" ).append("\n"); 
		query.append("	,L.CSTMS_RMK1" ).append("\n"); 
		query.append("	,L.RCV_DT" ).append("\n"); 
		query.append("    ,A.VSL_CD" ).append("\n"); 
		query.append("    ,A.VOY_NO" ).append("\n"); 
		query.append("    ,A.DIR_CD" ).append("\n"); 
		query.append("    ,A.FE" ).append("\n"); 

	}
}
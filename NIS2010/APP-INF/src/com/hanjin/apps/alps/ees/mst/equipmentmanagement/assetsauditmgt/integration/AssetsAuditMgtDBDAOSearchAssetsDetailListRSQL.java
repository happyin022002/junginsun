/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : AssetsAuditMgtDBDAOSearchAssetsDetailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.04.05
*@LastModifier : 
*@LastVersion : 1.0
* 2017.04.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AssetsAuditMgtDBDAOSearchAssetsDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAssetsDetailList
	  * </pre>
	  */
	public AssetsAuditMgtDBDAOSearchAssetsDetailListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sel_mnfr_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sel_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sel_col_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sel_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sel_to_prd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sel_lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sel_fm_prd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sel_to_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sel_mftr_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sel_cntr_pfx_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sel_fm_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sel_loc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.integration").append("\n"); 
		query.append("FileName : AssetsAuditMgtDBDAOSearchAssetsDetailListRSQL").append("\n"); 
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
		query.append("SELECT   /*+ USE_NL( T01 T02 ) */" ).append("\n"); 
		query.append("        SEQ" ).append("\n"); 
		query.append("      , T01.VNDR_ABBR_NM" ).append("\n"); 
		query.append("      , T01.MFTR_VNDR_SEQ" ).append("\n"); 
		query.append("      , T01.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      , T01.LSTM_CD" ).append("\n"); 
		query.append("      , T01.CNTR_NO" ).append("\n"); 
		query.append("      , T01.MFT_DT" ).append("\n"); 
		query.append("      , T01.CNTR_STS_CD" ).append("\n"); 
		query.append("      , REPLACE(SUBSTR(T01.CNTR_LOT_INFO, 1, 17), '-'||'-'||'-', NULL) AS LOT_NO" ).append("\n"); 
		query.append("      , T01.RCC_CD" ).append("\n"); 
		query.append("      , T01.LCC_CD" ).append("\n"); 
		query.append("      , T01.SCC_CD" ).append("\n"); 
		query.append("      , T01.CRNT_YD_CD" ).append("\n"); 
		query.append("      , T01.CNMV_STS_CD" ).append("\n"); 
		query.append("      , T01.CNMV_DT" ).append("\n"); 
		query.append("      , NVL(T01.RF_MDL_NM,SUBSTR( T01.CNTR_LOT_INFO, INSTR(T01.CNTR_LOT_INFO, '@', 1, 1) + 1, INSTR(T01.CNTR_LOT_INFO, '@', 1, 2) - INSTR(T01.CNTR_LOT_INFO, '@', 1, 1) - 1)) AS RF_MDL_NM" ).append("\n"); 
		query.append("      , (" ).append("\n"); 
		query.append("        SELECT  NVL(S.VNDR_ABBR_NM, S.VNDR_LGL_ENG_NM) " ).append("\n"); 
		query.append("        FROM    MDM_VENDOR S" ).append("\n"); 
		query.append("        WHERE   S.VNDR_SEQ = NVL(T01.RF_MKR_SEQ,TO_NUMBER(SUBSTR( T01.CNTR_LOT_INFO, INSTR(T01.CNTR_LOT_INFO, '@', 1, 2) + 1)))" ).append("\n"); 
		query.append("        ) AS RF_MKR_SEQ" ).append("\n"); 
		query.append("      , CASE WHEN T01.CNTR_STS_CD IN ('LSO', 'SBO', 'DIO', 'MUO', 'LST', 'SRO', 'SLD', 'SCR', 'DON', 'TLL') THEN" ).append("\n"); 
		query.append("                  TRUNC(T02.CNTR_STS_EVNT_DT) +1 " ).append("\n"); 
		query.append("             ELSE" ).append("\n"); 
		query.append("                  TRUNC(SYSDATE) +1" ).append("\n"); 
		query.append("             END  - TRUNC(T01.ONH_DT) AS USING_DAYS" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        SELECT  ROWNUM AS SEQ" ).append("\n"); 
		query.append("              , (" ).append("\n"); 
		query.append("                SELECT  VNDR_ABBR_NM " ).append("\n"); 
		query.append("                FROM    MDM_VENDOR S" ).append("\n"); 
		query.append("                WHERE   S.VNDR_SEQ = T1.MFTR_VNDR_SEQ" ).append("\n"); 
		query.append("                ) AS VNDR_ABBR_NM" ).append("\n"); 
		query.append("              , T1.MFTR_VNDR_SEQ" ).append("\n"); 
		query.append("              , T1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              , T1.LSTM_CD" ).append("\n"); 
		query.append("              , T1.CNTR_NO" ).append("\n"); 
		query.append("              , TO_CHAR(T1.MFT_DT,'YYYY-MM-DD') AS MFT_DT" ).append("\n"); 
		query.append("              , T1.CNTR_STS_CD" ).append("\n"); 
		query.append("              , T1.RCC_CD" ).append("\n"); 
		query.append("              , T1.LCC_CD" ).append("\n"); 
		query.append("              , T1.SCC_CD" ).append("\n"); 
		query.append("              , T1.CRNT_YD_CD" ).append("\n"); 
		query.append("              , T1.CNMV_STS_CD" ).append("\n"); 
		query.append("              , TO_CHAR(T1.CNMV_DT,'YYYY-MM-DD') AS CNMV_DT" ).append("\n"); 
		query.append("              , T1.RF_MDL_NM" ).append("\n"); 
		query.append("              , T1.RF_MKR_SEQ" ).append("\n"); 
		query.append("              , T1.LST_STS_SEQ" ).append("\n"); 
		query.append("              , T1.ONH_DT" ).append("\n"); 
		query.append("              , (" ).append("\n"); 
		query.append("                SELECT S.LOT_PLN_YR || '-' || S.LOT_LOC_CD  || '-' || S.CNTR_TPSZ_CD || '-' || DECODE(LENGTH(S.LOT_SEQ),1,'00' || S.LOT_SEQ , 2, '0'  || S.LOT_SEQ, 3, S.LOT_SEQ, S.LOT_SEQ )" ).append("\n"); 
		query.append("                       ||'@'|| S.RF_MDL_NM ||'@'|| LTRIM(TO_CHAR(S.RF_MKR_SEQ, '000000'))" ).append("\n"); 
		query.append("                FROM   MST_CNTR_LOT      S" ).append("\n"); 
		query.append("                WHERE  SUBSTR(T1.CNTR_NO,0,10) BETWEEN S.LOT_CNTR_PFX_CD ||S.FM_SER_NO  AND S.LOT_CNTR_PFX_CD ||S.TO_SER_NO" ).append("\n"); 
		query.append("                AND    S.CNTR_TPSZ_CD = T1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                AND    S.LOT_PLN_YR   = TO_CHAR(T1.MFT_DT, 'YYYY') " ).append("\n"); 
		query.append("                AND    ROWNUM         = 1" ).append("\n"); 
		query.append("                )                 AS CNTR_LOT_INFO" ).append("\n"); 
		query.append("        FROM    MST_CONTAINER     T1" ).append("\n"); 
		query.append("        WHERE   1=1" ).append("\n"); 
		query.append("#if (${sel_mftr_vndr_seq} != '') " ).append("\n"); 
		query.append("        AND     T1.MFTR_VNDR_SEQ = @[sel_mftr_vndr_seq]        --Manufacturer-- " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        AND     T1.CNTR_TPSZ_CD  = @[sel_cntr_tpsz_cd]" ).append("\n"); 
		query.append("#if (${sel_mnfr_yr} != '') " ).append("\n"); 
		query.append("        AND     T1.MFT_DT >= TO_DATE(@[sel_mnfr_yr] || '0101 000000','yyyymmdd HH24MISS') AND T1.MFT_DT <= TO_DATE(@[sel_mnfr_yr] || '1231 235959','yyyymmdd HH24MISS')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("        AND     T1.MFT_DT IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sel_fm_prd} != '') " ).append("\n"); 
		query.append("        AND     T1.MFT_DT >= TO_DATE(@[sel_fm_prd],'YYYYMM') " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sel_to_prd} != '') " ).append("\n"); 
		query.append("        AND     T1.MFT_DT <  ADD_MONTHS(TO_DATE(@[sel_to_prd],'YYYYMM'),1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        AND     T1.LSTM_CD = @[sel_lstm_cd]" ).append("\n"); 
		query.append("        AND    DECODE(NVL(@[sel_loc_tp_cd], 'ALL'), 'ALL', '1', 'RCC', T1.RCC_CD,'LCC', T1.LCC_CD, 'ECC', T1.ECC_CD, 'SCC', T1.SCC_CD)" ).append("\n"); 
		query.append("             = DECODE(NVL(@[sel_loc_tp_cd], 'ALL'), 'ALL', '1', @[sel_loc_cd])" ).append("\n"); 
		query.append("#if (${sel_cntr_pfx_cd} != '') " ).append("\n"); 
		query.append("        AND    T1.CNTR_NO LIKE @[sel_cntr_pfx_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sel_fm_ser_no} != '') " ).append("\n"); 
		query.append("        AND    TO_NUMBER(@[sel_fm_ser_no]) <= TO_NUMBER(SUBSTR(T1.CNTR_NO,5,6)) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sel_to_ser_no} != '') " ).append("\n"); 
		query.append("        AND    TO_NUMBER(SUBSTR(T1.CNTR_NO,5,6)) <= TO_NUMBER(@[sel_to_ser_no])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sel_col_nm} == 'SLD' || ${sel_col_nm} == 'TLL' || ${sel_col_nm} == 'DON' || ${sel_col_nm} == 'SCR' || ${sel_col_nm} == 'LST' || ${sel_col_nm} == 'SBO' || ${sel_col_nm} == 'MUO' || ${sel_col_nm} == 'LSO' || ${sel_col_nm} == 'DIO')" ).append("\n"); 
		query.append("AND     T1.CNTR_STS_CD = @[sel_col_nm]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sel_col_nm} == 'ASE')" ).append("\n"); 
		query.append("AND     NOT EXISTS (SELECT 'X' FROM DUAL WHERE T1.CNTR_STS_CD IN ('SLD', 'TLL', 'DON', 'SCR'))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sel_col_nm} == 'ACT')" ).append("\n"); 
		query.append("AND     NOT EXISTS (SELECT 'X' FROM DUAL WHERE T1.CNTR_STS_CD IN ('SLD', 'TLL', 'DON', 'SCR', 'LST', 'SBO', 'MUO', 'LSO', 'DIO'))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        )                   T01" ).append("\n"); 
		query.append("      , MST_CNTR_STS_HIS    T02" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND     T01.CNTR_NO     = T02.CNTR_NO" ).append("\n"); 
		query.append("AND     T01.LST_STS_SEQ = T02.CNTR_STS_SEQ" ).append("\n"); 

	}
}
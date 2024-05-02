/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AssetsAuditMgtDBDAOSearchAssetsDetailLeaseListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.31
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2012.05.31 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dongsun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AssetsAuditMgtDBDAOSearchAssetsDetailLeaseListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAssetsDetailLeaseList
	  * </pre>
	  */
	public AssetsAuditMgtDBDAOSearchAssetsDetailLeaseListRSQL(){
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
		params.put("sel_lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sel_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sel_loc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.integration").append("\n"); 
		query.append("FileName : AssetsAuditMgtDBDAOSearchAssetsDetailLeaseListRSQL").append("\n"); 
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
		query.append("SELECT  ROW_NUMBER() OVER (ORDER BY T01.CNTR_NO)          AS SEQ" ).append("\n"); 
		query.append("      , (" ).append("\n"); 
		query.append("        SELECT  VNDR_ABBR_NM " ).append("\n"); 
		query.append("        FROM    MDM_VENDOR S" ).append("\n"); 
		query.append("        WHERE   S.VNDR_SEQ = T01.MFTR_VNDR_SEQ" ).append("\n"); 
		query.append("        )                                                 AS VNDR_ABBR_NM" ).append("\n"); 
		query.append("      , T01.MFTR_VNDR_SEQ" ).append("\n"); 
		query.append("      , T01.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      , T01.LSTM_CD" ).append("\n"); 
		query.append("      , T01.CNTR_NO" ).append("\n"); 
		query.append("      , TO_CHAR(T01.MFT_DT,'YYYY-MM-DD')                  AS MFT_DT " ).append("\n"); 
		query.append("      , T01.CNTR_STS_CD" ).append("\n"); 
		query.append("      , '' AS LOT_NO" ).append("\n"); 
		query.append("      , T01.RCC_CD" ).append("\n"); 
		query.append("      , T01.LCC_CD" ).append("\n"); 
		query.append("      , T01.SCC_CD" ).append("\n"); 
		query.append("      , T01.CRNT_YD_CD" ).append("\n"); 
		query.append("      , T01.CNMV_STS_CD" ).append("\n"); 
		query.append("      , TO_CHAR(T01.CNMV_DT,'YYYY-MM-DD')                 AS CNMV_DT" ).append("\n"); 
		query.append("      , T01.RF_MDL_NM" ).append("\n"); 
		query.append("      , (" ).append("\n"); 
		query.append("        SELECT  NVL(S.VNDR_ABBR_NM, S.VNDR_LGL_ENG_NM) " ).append("\n"); 
		query.append("        FROM    MDM_VENDOR S" ).append("\n"); 
		query.append("        WHERE   S.VNDR_SEQ = T01.RF_MKR_SEQ" ).append("\n"); 
		query.append("        )                                                  AS RF_MKR_SEQ" ).append("\n"); 
		query.append("      , CASE WHEN T01.CNTR_STS_CD IN ('LSO', 'SBO', 'DIO', 'MUO', 'LST', 'SRO', 'SLD', 'SCR', 'DON', 'TLL') THEN" ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("            SELECT  /*+INDEX_DESC(S XAK1MST_CNTR_STS_HIS) */" ).append("\n"); 
		query.append("                    TRUNC(S.CNTR_STS_EVNT_DT) + 1" ).append("\n"); 
		query.append("            FROM    MST_CNTR_STS_HIS S" ).append("\n"); 
		query.append("            WHERE   S.CNTR_NO       = T01.CNTR_NO" ).append("\n"); 
		query.append("            AND     S.CNTR_STS_SEQ  = T01.LST_STS_SEQ" ).append("\n"); 
		query.append("            AND     ROWNUM          = 1" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("        ELSE" ).append("\n"); 
		query.append("              TRUNC(SYSDATE) +1" ).append("\n"); 
		query.append("        END   - TRUNC(T01.ONH_DT)                            AS USING_DAYS" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        SELECT  T1.*" ).append("\n"); 
		query.append("               , CNTR_STS_CD AS CUR_STS_CD" ).append("\n"); 
		query.append("               , CASE WHEN CNTR_STS_CD IN ('SBI', 'LSO','TLL','SCR', 'SLD', 'SBO','DIO','MUO','LST') THEN 'LSI' ELSE CNTR_STS_CD END AS PRE_STS_CD" ).append("\n"); 
		query.append("        FROM    MST_CONTAINER T1" ).append("\n"); 
		query.append("        WHERE   1=1" ).append("\n"); 
		query.append("        AND     T1.OWNR_CO_CD   = 'H'" ).append("\n"); 
		query.append("        AND     T1.CNTR_TPSZ_CD = @[sel_cntr_tpsz_cd]" ).append("\n"); 
		query.append("        AND     T1.LSTM_CD      = @[sel_lstm_cd]" ).append("\n"); 
		query.append("        AND     DECODE(NVL(@[sel_loc_tp_cd], 'ALL'), 'ALL', '1', 'RCC', T1.RCC_CD,'LCC', T1.LCC_CD, 'ECC', T1.ECC_CD, 'SCC', T1.SCC_CD)" ).append("\n"); 
		query.append("              = DECODE(NVL(@[sel_loc_tp_cd], 'ALL'), 'ALL', '1', @[sel_loc_cd])" ).append("\n"); 
		query.append("     #if (${sel_mnfr_yr} != '') " ).append("\n"); 
		query.append("             AND     T1.MFT_DT >= TO_DATE(@[sel_mnfr_yr] || '0101 000000','yyyymmdd HH24MISS') AND T1.MFT_DT <= TO_DATE(@[sel_mnfr_yr] || '1231 235959','yyyymmdd HH24MISS')" ).append("\n"); 
		query.append("     #else" ).append("\n"); 
		query.append("             AND     T1.MFT_DT IS NULL" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     #if (${sel_fm_prd} != '') " ).append("\n"); 
		query.append("             AND     T1.MFT_DT >= TO_DATE(@[sel_fm_prd],'YYYYMM') " ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     #if (${sel_to_prd} != '') " ).append("\n"); 
		query.append("             AND     T1.MFT_DT <  ADD_MONTHS(TO_DATE(@[sel_to_prd],'YYYYMM'),1)" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     AND DECODE(NVL(@[loc_tp_cd],''),'ALL','1','RCC',T1.RCC_CD,'LCC',T1.LCC_CD,'ECC',T1.ECC_CD,'SCC',T1.SCC_CD) = DECODE(NVL(@[loc_tp_cd],''),'ALL','1',NVL(@[loc_cd],''))" ).append("\n"); 
		query.append("     #if (${sel_cntr_pfx_cd} != '') " ).append("\n"); 
		query.append("             AND    T1.CNTR_NO LIKE @[sel_cntr_pfx_cd] || '%'" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     #if (${sel_fm_ser_no} != '') " ).append("\n"); 
		query.append("             AND    TO_NUMBER(@[sel_fm_ser_no]) <= TO_NUMBER(SUBSTR(T1.CNTR_NO,5,6)) " ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     #if (${sel_to_ser_no} != '') " ).append("\n"); 
		query.append("             AND    TO_NUMBER(SUBSTR(T1.CNTR_NO,5,6)) <= TO_NUMBER(@[sel_to_ser_no])" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     #if (${sel_mftr_vndr_seq} != '') " ).append("\n"); 
		query.append("         AND     T1.MFTR_VNDR_SEQ = @[sel_mftr_vndr_seq]        --Manufacturer-- " ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("        ) T01" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("#if (${sel_col_nm} != 'ASE' && ${sel_col_nm} != 'ACT')" ).append("\n"); 
		query.append("AND     CASE WHEN @[sel_col_nm] IN ( 'LSI', 'MUI', 'DII', 'FND' ) THEN" ).append("\n"); 
		query.append("                  T01.PRE_STS_CD" ).append("\n"); 
		query.append("             WHEN @[sel_col_nm] IN ( 'LSO', 'TLL', 'SBO', 'DIO', 'MUO', 'LST', 'SCR', 'SLD' ) THEN" ).append("\n"); 
		query.append("                  T01.CUR_STS_CD" ).append("\n"); 
		query.append("        END" ).append("\n"); 
		query.append("        =" ).append("\n"); 
		query.append("        CASE WHEN @[sel_col_nm] = 'LSI' THEN" ).append("\n"); 
		query.append("             'LSI'" ).append("\n"); 
		query.append("             WHEN @[sel_col_nm] = 'MUI' THEN" ).append("\n"); 
		query.append("             'MUI'" ).append("\n"); 
		query.append("             WHEN @[sel_col_nm] = 'DII' THEN" ).append("\n"); 
		query.append("             'DII'" ).append("\n"); 
		query.append("             WHEN @[sel_col_nm] = 'FND' THEN" ).append("\n"); 
		query.append("             'FND'" ).append("\n"); 
		query.append("             WHEN @[sel_col_nm] = 'LSO' THEN" ).append("\n"); 
		query.append("             'LSO'" ).append("\n"); 
		query.append("             WHEN @[sel_col_nm] = 'TLL' THEN" ).append("\n"); 
		query.append("             'TLL'" ).append("\n"); 
		query.append("             WHEN @[sel_col_nm] = 'SBO' THEN" ).append("\n"); 
		query.append("             'SBO'" ).append("\n"); 
		query.append("             WHEN @[sel_col_nm] = 'DIO' THEN" ).append("\n"); 
		query.append("             'DIO'" ).append("\n"); 
		query.append("             WHEN @[sel_col_nm] = 'MUO' THEN" ).append("\n"); 
		query.append("             'MUO'" ).append("\n"); 
		query.append("             WHEN @[sel_col_nm] = 'LST' THEN" ).append("\n"); 
		query.append("             'LST'" ).append("\n"); 
		query.append("             WHEN @[sel_col_nm] = 'SCR' THEN" ).append("\n"); 
		query.append("             'SCR'" ).append("\n"); 
		query.append("             WHEN @[sel_col_nm] = 'SLD' THEN" ).append("\n"); 
		query.append("             'SLD'" ).append("\n"); 
		query.append("        END" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sel_col_nm} == 'ASE')" ).append("\n"); 
		query.append("AND     T01.PRE_STS_CD IN ( 'LSI', 'MUI', 'DII', 'FND' )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sel_col_nm} == 'ACT')" ).append("\n"); 
		query.append("AND     NOT EXISTS (SELECT 'X' FROM DUAL WHERE T01.CUR_STS_CD IN ('LSO', 'TLL', 'SBO', 'DIO', 'MUO', 'LST', 'SCR', 'SLD'))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND  @[sel_col_nm] = @[sel_col_nm]" ).append("\n"); 

	}
}
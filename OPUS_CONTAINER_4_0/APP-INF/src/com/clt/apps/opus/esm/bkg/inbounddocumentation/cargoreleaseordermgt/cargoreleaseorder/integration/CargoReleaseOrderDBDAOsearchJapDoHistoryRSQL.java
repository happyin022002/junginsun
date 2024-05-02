/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchJapDoHistoryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOsearchJapDoHistoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Cargo Delivery - DO LIST CHECK REPORT(JAPAN)(UI_BKG-0694)
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchJapDoHistoryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_dt_end",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_dt_start",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("page_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pagerows",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchJapDoHistoryRSQL").append("\n"); 
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
		query.append("/* 이 Query는 bkg_do_dtl의 rlse_sts_cd I값이 각 bkg_no별로 1건을 초과하여 발생할 수 없다는 가정하에서 작성되었다. 아닐 경우 데이터 등록 Application의 오류로 한다.20091228 */" ).append("\n"); 
		query.append("SELECT RSLT.BKG_NO" ).append("\n"); 
		query.append("     , RSLT.VVD" ).append("\n"); 
		query.append("     , RSLT.VSL_CD" ).append("\n"); 
		query.append("     , RSLT.SKD_VOY_NO" ).append("\n"); 
		query.append("     , RSLT.SKD_DIR_CD" ).append("\n"); 
		query.append("     , RSLT.POD_CD" ).append("\n"); 
		query.append("     , RSLT.DEL_CD" ).append("\n"); 
		query.append("     , RSLT.EVNT_OFC_CD" ).append("\n"); 
		query.append("     , RSLT.BL_NO" ).append("\n"); 
		query.append("     , NVL(RSLT.JP_DO_ID, RSLT.DO_NO) AS DO_NO" ).append("\n"); 
		query.append("     , RSLT.EVNT_DT" ).append("\n"); 
		query.append("     , RSLT.EVNT_USR_ID" ).append("\n"); 
		query.append("     , RSLT.DO_RMK" ).append("\n"); 
		query.append("     , REPLACE(CCST.CUST_NM, CHR(10), ' ') AS CN_NM" ).append("\n"); 
		query.append("     , REPLACE(NCST.CUST_NM, CHR(10), ' ') AS NF_NM" ).append("\n"); 
		query.append("     , RSLT.DO_RSN_RMK" ).append("\n"); 
		query.append("     , RSLT.CGO_RMK" ).append("\n"); 
		query.append("     , ROW_COUNT" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("    SELECT INQR.BKG_NO" ).append("\n"); 
		query.append("         , INQR.VSL_CD" ).append("\n"); 
		query.append("         , INQR.SKD_VOY_NO" ).append("\n"); 
		query.append("         , INQR.SKD_DIR_CD" ).append("\n"); 
		query.append("         , INQR.VSL_CD || INQR.SKD_VOY_NO || INQR.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("         , INQR.POD_CD" ).append("\n"); 
		query.append("         , INQR.DEL_CD" ).append("\n"); 
		query.append("         , INQR.BL_NO" ).append("\n"); 
		query.append("         , INQR.EVNT_OFC_CD 								 AS EVNT_OFC_CD" ).append("\n"); 
		query.append("         , INQR.DO_NO 										 AS DO_NO" ).append("\n"); 
		query.append("         , INQR.DO_NO_SPLIT 								 AS DO_NO_SPLIT" ).append("\n"); 
		query.append("         , INQR.JP_DO_ID    								 AS JP_DO_ID" ).append("\n"); 
		query.append("         , INQR.DO_RMK      								 AS DO_RMK" ).append("\n"); 
		query.append("         , TO_CHAR(INQR.EVNT_DT, 'YYYY-MM-DD')  			 AS EVNT_DT" ).append("\n"); 
		query.append("         , INQR.EVNT_USR_ID 								 AS EVNT_USR_ID" ).append("\n"); 
		query.append("         , DECODE(TRIM(INQR.DO_RSN_RMK), NULL, 'No', 'Yes')  AS DO_RSN_RMK    -- IBSheet Grid 버그 및 제약사항으로 해당과 같이 처리" ).append("\n"); 
		query.append("         , INQR.DO_RSN_RMK                					 AS CGO_RMK    -- IBSheet Grid 버그 및 제약사항으로 해당과 같이 처리" ).append("\n"); 
		query.append("         , COUNT(1) OVER () ROW_COUNT" ).append("\n"); 
		query.append("         , ROW_NUMBER() OVER (ORDER BY DECODE(INQR.EVNT_DT, NULL, 1, 0), INQR.EVNT_DT DESC,  INQR.BL_NO) AS ROW_NUM" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("          SELECT BKGM.BKG_NO" ).append("\n"); 
		query.append("               , BVVD.VSL_CD" ).append("\n"); 
		query.append("               , BVVD.SKD_VOY_NO" ).append("\n"); 
		query.append("               , BVVD.SKD_DIR_CD" ).append("\n"); 
		query.append("               , BKGM.POD_CD" ).append("\n"); 
		query.append("               , BKGM.DEL_CD" ).append("\n"); 
		query.append("               , BKGM.BL_NO" ).append("\n"); 
		query.append("               , BKDO.RLSE_SEQ" ).append("\n"); 
		query.append("               , NVL( DOTL.RLSE_STS_CD, 'N') AS RLSE_STS_CD  -- I or N" ).append("\n"); 
		query.append("               , BKDO.DO_PRN_RMK  AS DO_RMK" ).append("\n"); 
		query.append("               , BKDO.CGOR_RMK    AS DO_RSN_RMK" ).append("\n"); 
		query.append("               , BKDO.DO_NO" ).append("\n"); 
		query.append("               , BKDO.DO_NO_SPLIT" ).append("\n"); 
		query.append("               , BKDO.JP_DO_ID" ).append("\n"); 
		query.append("               , DOTL.EVNT_DT" ).append("\n"); 
		query.append("               , DOTL.EVNT_USR_ID" ).append("\n"); 
		query.append("               , DOTL.EVNT_OFC_CD" ).append("\n"); 
		query.append("            FROM BKG_VVD BVVD" ).append("\n"); 
		query.append("               , BKG_BOOKING BKGM" ).append("\n"); 
		query.append("               , BKG_DO BKDO" ).append("\n"); 
		query.append("               , BKG_DO_DTL DOTL" ).append("\n"); 
		query.append("           WHERE BVVD.VSL_PRE_PST_CD IN ('T', 'U')" ).append("\n"); 
		query.append("             AND BKGM.BKG_NO = BVVD.BKG_NO" ).append("\n"); 
		query.append("             AND BKGM.POD_CD = BVVD.POD_CD" ).append("\n"); 
		query.append("             AND NVL(BKGM.BKG_STS_CD, ' ') <> 'X' -- Canceled BL 제거 (20100526)" ).append("\n"); 
		query.append("#if (${rd_flag} == 'F')" ).append("\n"); 
		query.append("             AND BVVD.VSL_CD      = @[vsl_cd]  -- VVD" ).append("\n"); 
		query.append("             AND BVVD.SKD_VOY_NO  = @[skd_voy_no]" ).append("\n"); 
		query.append("             AND BVVD.SKD_DIR_CD  = @[skd_dir_cd]" ).append("\n"); 
		query.append("             AND BVVD.POD_CD      = @[pod_cd]" ).append("\n"); 
		query.append("             AND BKDO.BKG_NO(+)   = BKGM.BKG_NO" ).append("\n"); 
		query.append("             AND DOTL.BKG_NO(+)   = BKDO.BKG_NO" ).append("\n"); 
		query.append("             AND DOTL.RLSE_SEQ(+) = BKDO.RLSE_SEQ" ).append("\n"); 
		query.append("         --    AND DOTL.RLSE_STS_CD(+) = 'I'" ).append("\n"); 
		query.append("#elseif (${rd_flag} == 'S')" ).append("\n"); 
		query.append("             AND DOTL.EVNT_OFC_CD = @[evnt_ofc_cd]  -- Event Date" ).append("\n"); 
		query.append("             AND DOTL.EVNT_DT BETWEEN TO_DATE(@[evnt_dt_start], 'YYYYMMDD') " ).append("\n"); 
		query.append("                              AND (TO_DATE (@[evnt_dt_end], 'YYYYMMDD') + 1)" ).append("\n"); 
		query.append("             AND DOTL.RLSE_STS_CD = 'I'             " ).append("\n"); 
		query.append("             AND BKDO.BKG_NO      = DOTL.BKG_NO" ).append("\n"); 
		query.append("             AND BKDO.RLSE_SEQ    = DOTL.RLSE_SEQ" ).append("\n"); 
		query.append("             AND BKGM.BKG_NO      = BKDO.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         ) INQR" ).append("\n"); 
		query.append("   WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${rd_flag} == 'F' && ${rlse_sts_cd} != '*')" ).append("\n"); 
		query.append("     AND INQR.RLSE_STS_CD = DECODE ('${rlse_sts_cd}', 'Y', 'I', 'N')    " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rd_flag} == 'F' && ${rlse_sts_cd} == '*')" ).append("\n"); 
		query.append("     AND INQR.RLSE_STS_CD NOT IN ('C','D')    -- D/O Cancel된 대상은 조회 결과에서 제외 " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   ORDER BY DECODE(INQR.EVNT_DT, NULL, 1, 0)" ).append("\n"); 
		query.append("          , INQR.EVNT_DT DESC" ).append("\n"); 
		query.append("          ,  INQR.BL_NO" ).append("\n"); 
		query.append("    ) RSLT" ).append("\n"); 
		query.append("    , BKG_CUSTOMER CCST" ).append("\n"); 
		query.append("    , BKG_CUSTOMER NCST" ).append("\n"); 
		query.append("WHERE ROW_NUM BETWEEN (TO_NUMBER(NVL(@[page_no], '1')) -1) * TO_NUMBER(@[pagerows]) +1" ).append("\n"); 
		query.append("                   AND TO_NUMBER(NVL(@[page_no], '1')) * TO_NUMBER(@[pagerows])" ).append("\n"); 
		query.append("  AND CCST.BKG_NO = RSLT.BKG_NO" ).append("\n"); 
		query.append("  AND CCST.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("  AND NCST.BKG_NO = RSLT.BKG_NO" ).append("\n"); 
		query.append("  AND NCST.BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append("-- map JapDoHisSearchVO" ).append("\n"); 

	}
}
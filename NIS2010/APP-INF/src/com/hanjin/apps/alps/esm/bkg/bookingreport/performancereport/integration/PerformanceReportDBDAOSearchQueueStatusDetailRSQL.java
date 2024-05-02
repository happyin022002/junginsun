/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchQueueStatusDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchQueueStatusDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Queue Status Report - 상세 목록을 조회한다.
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchQueueStatusDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_tm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_amd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_aud_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_tm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_doc_inp_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_rt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchQueueStatusDetailRSQL").append("\n"); 
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
		query.append("SELECT (SELECT C.INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("       FROM COM_INTG_CD_DTL C" ).append("\n"); 
		query.append("       WHERE C.INTG_CD_ID = 'CD02405'" ).append("\n"); 
		query.append("       AND C.INTG_CD_VAL_CTNT = S.RGN_OFC_CD) RGN_OFC_CD," ).append("\n"); 
		query.append("       B.BKG_OFC_CD," ).append("\n"); 
		query.append("       R.BKG_NO," ).append("\n"); 
		query.append("       TO_CHAR(R.SR_WRK_STS_DT, 'YYYY-MM-DD HH24:MI:SS') SR_WRK_STS_DT," ).append("\n"); 
		query.append("       NVL(R.BL_DOC_INP_FLG,'N') BL_DOC_INP_FLG, " ).append("\n"); 
		query.append("       NVL(R.BL_RT_FLG,'N') BL_RT_FLG, " ).append("\n"); 
		query.append("       NVL(R.BL_AUD_FLG,'N') BL_AUD_FLG, " ).append("\n"); 
		query.append("       DECODE(R.SR_WRK_STS_CD,'P','Y','N') PND_FLG," ).append("\n"); 
		query.append("       R.SR_WRK_STS_CD," ).append("\n"); 
		query.append("       (SELECT C.INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("        FROM COM_INTG_CD_DTL C" ).append("\n"); 
		query.append("        WHERE C.INTG_CD_ID = 'CD02641'" ).append("\n"); 
		query.append("        AND C.INTG_CD_VAL_CTNT =  NVL((SELECT /*+ INDEX_DESC(H XPKBKG_SR_HIS) */ DECODE(R.SR_CRNT_INFO_CD,'R', FNT_OFC_RTN_CD, '')" ).append("\n"); 
		query.append("                                        FROM BKG_SR_HIS H" ).append("\n"); 
		query.append("                                        WHERE H.BKG_NO = R.BKG_NO" ).append("\n"); 
		query.append("                                        AND H.SR_KND_CD = R.SR_KND_CD" ).append("\n"); 
		query.append("                                        AND H.SR_NO = R.SR_NO" ).append("\n"); 
		query.append("                                        AND H.SR_STS_CD = 'RR'" ).append("\n"); 
		query.append("                                        AND ROWNUM = 1),' ')) FNT_OFC_RTN_CD" ).append("\n"); 
		query.append("FROM BKG_SR_CRNT_RQST R, BKG_BOOKING B," ).append("\n"); 
		query.append("     (SELECT BKG_OFC_CD, RGN_OFC_CD" ).append("\n"); 
		query.append("      FROM (SELECT DISTINCT BKG_OFC_CD, RGN_OFC_CD," ).append("\n"); 
		query.append("                   RANK() OVER (PARTITION BY BKG_OFC_CD ORDER BY DELT_FLG, RGN_OFC_CD) RNK" ).append("\n"); 
		query.append("            FROM BKG_EML_ACCT_STUP)" ).append("\n"); 
		query.append("      WHERE RNK = 1) S" ).append("\n"); 
		query.append("WHERE R.SR_WRK_STS_DT BETWEEN TO_DATE(@[fm_dt]||@[fm_tm],'YYYY-MM-DDHH24:MI') AND TO_DATE(@[to_dt]||@[to_tm]||'59','YYYY-MM-DDHH24:MISS')" ).append("\n"); 
		query.append("AND R.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND B.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("AND R.SR_CRNT_STS_CD <> 'XX'" ).append("\n"); 
		query.append("AND R.DPCS_OFC_CD = NVL('PKGSA', R.DPCS_OFC_CD)" ).append("\n"); 
		query.append("AND B.BKG_OFC_CD = S.BKG_OFC_CD" ).append("\n"); 
		query.append("AND B.BKG_OFC_CD = NVL(@[bkg_ofc_cd], B.BKG_OFC_CD)      " ).append("\n"); 
		query.append("AND R.SR_AMD_TP_CD = DECODE(@[sr_amd_tp_cd], 'L', R.SR_AMD_TP_CD, @[sr_amd_tp_cd])" ).append("\n"); 
		query.append("AND S.RGN_OFC_CD = DECODE(@[rgn_ofc_cd], 'A',RGN_OFC_CD, @[rgn_ofc_cd])" ).append("\n"); 
		query.append("AND NVL(R.BL_DOC_INP_FLG, 'N') = NVL(@[bl_doc_inp_flg], NVL(R.BL_DOC_INP_FLG, 'N'))" ).append("\n"); 
		query.append("AND NVL(R.BL_RT_FLG, 'N') = NVL(@[bl_rt_flg], NVL(R.BL_RT_FLG, 'N'))" ).append("\n"); 
		query.append("AND NVL(R.BL_AUD_FLG, 'N') = NVL(@[bl_aud_flg], NVL(R.BL_AUD_FLG, 'N'))" ).append("\n"); 
		query.append("ORDER BY S.RGN_OFC_CD, B.BKG_OFC_CD, B.BKG_NO" ).append("\n"); 

	}
}
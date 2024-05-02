/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CndExpCustomsTransmissionDBDAOsearchCndCstmsTrsmRsltListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.27
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndExpCustomsTransmissionDBDAOsearchCndCstmsTrsmRsltListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public CndExpCustomsTransmissionDBDAOsearchCndCstmsTrsmRsltListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subcmd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_snd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_snd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpt_flag",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.integration").append("\n"); 
		query.append("FileName : CndExpCustomsTransmissionDBDAOsearchCndCstmsTrsmRsltListRSQL").append("\n"); 
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
		query.append("#if (${rpt_flag} == 'V')" ).append("\n"); 
		query.append("    SELECT  A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD AS VVD_CD" ).append("\n"); 
		query.append("           ,'' POL_CD" ).append("\n"); 
		query.append("           ,'' POD_CD" ).append("\n"); 
		query.append("           ,'' BL_NO" ).append("\n"); 
		query.append("           ,'' CSTMS_FILE_TP_CD" ).append("\n"); 
		query.append("           ,'' CSTMS_TRSM_STS_CD" ).append("\n"); 
		query.append("           ,'' MF_STS_CD" ).append("\n"); 
		query.append("           ,A.CND_ACK_RSPN_CD AS CSTMS_ACK_RCV_RSLT_CD" ).append("\n"); 
		query.append("           ,A.CND_ACK_SUB_CD  AS CSTMS_ACK_PROC_RSLT_CD" ).append("\n"); 
		query.append("           ,'' FULL_MTY_CD" ).append("\n"); 
		query.append("           ,TO_CHAR(A.VSL_ARR_RPT_SND_DT, 'YYYY-MM-DD HH24:MI') AS AMDT_SND_DT" ).append("\n"); 
		query.append("           ,TO_CHAR(A.ACK_DT, 'YYYY-MM-DD HH24:MI') AS CSTMS_ACK_RCV_DT" ).append("\n"); 
		query.append("           ,A.CSTMS_RJCT_ID   AS CSTMS_ACK_RJCT_CD" ).append("\n"); 
		query.append("           ,A.RCV_ERR_CTNT    AS CSTMS_ACK_RJCT_MSG" ).append("\n"); 
		query.append("           ,C1.ATTR_CTNT2 AS ACK_DESC" ).append("\n"); 
		query.append("           ,C2.ATTR_CTNT2 AS RESULT_DESC" ).append("\n"); 
		query.append("           ,D.ERR_CD_DESC" ).append("\n"); 
		query.append("           ,D.ERR_TP_CTNT" ).append("\n"); 
		query.append("      FROM  BKG_CSTMS_CND_VSL A" ).append("\n"); 
		query.append("           ,BKG_HRD_CDG_CTNT C1" ).append("\n"); 
		query.append("           ,BKG_HRD_CDG_CTNT C2" ).append("\n"); 
		query.append("           ,BKG_CSTMS_ADV_ERR D" ).append("\n"); 
		query.append("     WHERE  C1.HRD_CDG_ID(+) = 'CND_ACK_CODE'" ).append("\n"); 
		query.append("       AND  A.CND_ACK_RSPN_CD = C1.ATTR_CTNT1(+)" ).append("\n"); 
		query.append("       AND  C2.HRD_CDG_ID(+) = 'CND_RESULT_CODE'" ).append("\n"); 
		query.append("       AND  A.CND_ACK_SUB_CD  = C2.ATTR_CTNT1(+)" ).append("\n"); 
		query.append("       AND  A.CSTMS_RJCT_ID  = D.CSTMS_ERR_CD(+)" ).append("\n"); 
		query.append("       AND  D.CNT_CD(+) = 'CA'" ).append("\n"); 
		query.append("        #if (${vvd_cd} != '')" ).append("\n"); 
		query.append("           AND  A.VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("           AND  A.SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("           AND  A.SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${s_snd_dt} != '')" ).append("\n"); 
		query.append("           AND  A.VSL_ARR_RPT_SND_DT BETWEEN TO_DATE(@[s_snd_dt] || ' 000000','YYYY-MM-DD HH24MISS') AND TO_DATE(@[e_snd_dt] || ' 235959','YYYY-MM-DD HH24MISS')" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${s_rcv_dt} != '')" ).append("\n"); 
		query.append("           AND  A.ACK_DT BETWEEN TO_DATE(@[s_rcv_dt] || ' 000000','YYYY-MM-DD HH24MISS') AND TO_DATE(@[e_rcv_dt] || ' 235959','YYYY-MM-DD HH24MISS')" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${cstms_ack_proc_rslt_cd} != '')" ).append("\n"); 
		query.append("           AND  A.CND_ACK_SUB_CD IN (${cstms_ack_proc_rslt_cd})" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("  ORDER BY A.ACK_DT" ).append("\n"); 
		query.append("#elseif (${subcmd} != '')" ).append("\n"); 
		query.append("    SELECT  TB.*" ).append("\n"); 
		query.append("           ,C1.ATTR_CTNT2 AS ACK_DESC" ).append("\n"); 
		query.append("           ,C2.ATTR_CTNT2 AS RESULT_DESC" ).append("\n"); 
		query.append("           ,C3.ATTR_CTNT2 AS CSTMS_TRSM_STS_DESC" ).append("\n"); 
		query.append("           ,D.ERR_CD_DESC" ).append("\n"); 
		query.append("           ,D.ERR_TP_CTNT" ).append("\n"); 
		query.append("           ,'' MANIFEST_TTL" ).append("\n"); 
		query.append("           ,'' SENT_BY_A6A" ).append("\n"); 
		query.append("           ,'' SENT_BY_AL" ).append("\n"); 
		query.append("           ,'' TARGET_TTL" ).append("\n"); 
		query.append("           ,'' UNMANIFEST" ).append("\n"); 
		query.append("           ,'' TOTAL" ).append("\n"); 
		query.append("           ,'' PROCESSED" ).append("\n"); 
		query.append("           ,'' ERROR" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("            SELECT  BL.VSL_CD || BL.SKD_VOY_NO || BL.SKD_DIR_CD AS VVD_CD" ).append("\n"); 
		query.append("                   ,BL.CSTMS_POL_CD AS POL_CD" ).append("\n"); 
		query.append("                   ,BL.CSTMS_POD_CD AS POD_CD" ).append("\n"); 
		query.append("                   ,BL.BL_NO" ).append("\n"); 
		query.append("                   ,DECODE(BL.MF_NO, NULL, BL.CSTMS_FILE_TP_CD, '0') AS CSTMS_FILE_TP_CD" ).append("\n"); 
		query.append("                   ,BL.CSTMS_TRSM_STS_CD" ).append("\n"); 
		query.append("                   ,BL.MF_STS_CD" ).append("\n"); 
		query.append("                   ,LOG.CND_ACK_RCV_ID AS CSTMS_ACK_RCV_RSLT_CD" ).append("\n"); 
		query.append("                   ,LOG.CND_ACK_SUB_CD CSTMS_ACK_PROC_RSLT_CD" ).append("\n"); 
		query.append("                   ,BL.FULL_MTY_CD" ).append("\n"); 
		query.append("                   ,TO_CHAR(BL.AMDT_SND_DT, 'YYYY-MM-DD HH24:MI') AS AMDT_SND_DT" ).append("\n"); 
		query.append("                   ,TO_CHAR(LOG.RCV_DT, 'YYYY-MM-DD HH24:MI') AS CSTMS_ACK_RCV_DT" ).append("\n"); 
		query.append("                   ,LOG.CSTMS_RJCT_MSG AS CSTMS_ACK_RJCT_CD" ).append("\n"); 
		query.append("                   ,LOG.CND_ACK_ERR_NOTE_DESC AS CSTMS_ACK_RJCT_MSG" ).append("\n"); 
		query.append("              FROM  BKG_CSTMS_ADV_BL BL" ).append("\n"); 
		query.append("                   ,BKG_CSTMS_ADV_RCV_LOG LOG" ).append("\n"); 
		query.append("             WHERE  BL.CNT_CD = 'CA'" ).append("\n"); 
		query.append("               AND  BL.CNT_CD = LOG.CNT_CD" ).append("\n"); 
		query.append("               AND  BL.BL_NO = LOG.BL_NO" ).append("\n"); 
		query.append("               AND  LOG.IO_BND_CD = 'I'" ).append("\n"); 
		query.append("               AND  LOG.CND_ACK_SUB_CD IN ('37', '21', '01')" ).append("\n"); 
		query.append("    #if (${bl_no} != '')" ).append("\n"); 
		query.append("               AND  BL.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("               AND  BL.FULL_MTY_CD = @[rpt_flag]" ).append("\n"); 
		query.append("        #if (${vvd_cd} != '')" ).append("\n"); 
		query.append("               AND  BL.VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("               AND  BL.SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("               AND  BL.SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${pol_cd} != '')" ).append("\n"); 
		query.append("               AND  BL.CSTMS_POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${pod_cd} != '')" ).append("\n"); 
		query.append("               AND  BL.CSTMS_POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${s_rcv_dt} != '')" ).append("\n"); 
		query.append("               AND  LOG.RCV_DT BETWEEN" ).append("\n"); 
		query.append("                   TO_DATE(REPLACE(@[s_rcv_dt],'-','')||'000000', 'YYYYMMDDHH24MISS') AND" ).append("\n"); 
		query.append("                   TO_DATE(REPLACE(@[e_rcv_dt],'-','')||'235959', 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("               AND  EXISTS" ).append("\n"); 
		query.append("                           (" ).append("\n"); 
		query.append("                            SELECT LG.CNT_CD" ).append("\n"); 
		query.append("                              FROM BKG_CSTMS_ADV_RCV_LOG LG" ).append("\n"); 
		query.append("                             WHERE LG.CNT_CD = BL.CNT_CD" ).append("\n"); 
		query.append("                               AND LG.BL_NO = BL.BL_NO" ).append("\n"); 
		query.append("                               AND LG.IO_BND_CD = 'I'" ).append("\n"); 
		query.append("                               AND LG.CND_ACK_SUB_CD = @[subcmd]" ).append("\n"); 
		query.append("                           )" ).append("\n"); 
		query.append("           ) TB" ).append("\n"); 
		query.append("           ,BKG_HRD_CDG_CTNT C1" ).append("\n"); 
		query.append("           ,BKG_HRD_CDG_CTNT C2" ).append("\n"); 
		query.append("           ,BKG_HRD_CDG_CTNT C3" ).append("\n"); 
		query.append("           ,BKG_CSTMS_ADV_ERR D" ).append("\n"); 
		query.append("      WHERE C1.HRD_CDG_ID(+) = 'CND_ACK_CODE'" ).append("\n"); 
		query.append("        AND TB.CSTMS_ACK_RCV_RSLT_CD = C1.ATTR_CTNT1(+)" ).append("\n"); 
		query.append("        AND C2.HRD_CDG_ID(+) = 'CND_RESULT_CODE'" ).append("\n"); 
		query.append("        AND TB.CSTMS_ACK_PROC_RSLT_CD  = C2.ATTR_CTNT1(+)" ).append("\n"); 
		query.append("        AND C3.HRD_CDG_ID(+) = 'CND_TRSM_STS_CD'" ).append("\n"); 
		query.append("        AND TB.CSTMS_TRSM_STS_CD = C3.ATTR_CTNT1(+)" ).append("\n"); 
		query.append("        AND TB.CSTMS_ACK_RJCT_CD  = D.CSTMS_ERR_CD(+)" ).append("\n"); 
		query.append("        AND D.CNT_CD(+) = 'CA'" ).append("\n"); 
		query.append("   ORDER BY  TB.BL_NO    " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    SELECT  BL.VSL_CD || BL.SKD_VOY_NO || BL.SKD_DIR_CD AS VVD_CD" ).append("\n"); 
		query.append("           ,BL.CSTMS_POL_CD AS POL_CD" ).append("\n"); 
		query.append("           ,BL.CSTMS_POD_CD AS POD_CD" ).append("\n"); 
		query.append("           ,BL.BL_NO" ).append("\n"); 
		query.append("           ,DECODE(BL.MF_NO, NULL, BL.CSTMS_FILE_TP_CD, '0') AS CSTMS_FILE_TP_CD" ).append("\n"); 
		query.append("           ,BL.CSTMS_TRSM_STS_CD" ).append("\n"); 
		query.append("           ,BL.CSTMS_TRSM_STS_CD" ).append("\n"); 
		query.append("           ,BL.CSTMS_ACK_RCV_RSLT_CD" ).append("\n"); 
		query.append("           ,BL.CSTMS_ACK_PROC_RSLT_CD" ).append("\n"); 
		query.append("           ,BL.MF_STS_CD" ).append("\n"); 
		query.append("           ,TO_CHAR(BL.AMDT_SND_DT, 'YYYY-MM-DD HH24:MI') AS AMDT_SND_DT" ).append("\n"); 
		query.append("           ,TO_CHAR(BL.CSTMS_ACK_RCV_DT, 'YYYY-MM-DD HH24:MI') AS CSTMS_ACK_RCV_DT" ).append("\n"); 
		query.append("           ,BL.CSTMS_ACK_RJCT_CD" ).append("\n"); 
		query.append("           ,BL.CSTMS_ACK_RJCT_MSG" ).append("\n"); 
		query.append("           ,C1.ATTR_CTNT2 AS ACK_DESC" ).append("\n"); 
		query.append("           ,C2.ATTR_CTNT2 AS RESULT_DESC" ).append("\n"); 
		query.append("           ,C3.ATTR_CTNT2 AS CSTMS_TRSM_STS_DESC" ).append("\n"); 
		query.append("           ,D.ERR_CD_DESC" ).append("\n"); 
		query.append("           ,D.ERR_TP_CTNT" ).append("\n"); 
		query.append("           ,'' MANIFEST_TTL" ).append("\n"); 
		query.append("           ,'' SENT_BY_A6A" ).append("\n"); 
		query.append("           ,'' SENT_BY_AL" ).append("\n"); 
		query.append("           ,'' TARGET_TTL" ).append("\n"); 
		query.append("           ,'' UNMANIFEST" ).append("\n"); 
		query.append("           ,'' TOTAL" ).append("\n"); 
		query.append("           ,'' PROCESSED" ).append("\n"); 
		query.append("           ,'' ERROR" ).append("\n"); 
		query.append("           ,BL.FULL_MTY_CD" ).append("\n"); 
		query.append("      FROM  BKG_CSTMS_ADV_BL BL" ).append("\n"); 
		query.append("           ,BKG_HRD_CDG_CTNT C1" ).append("\n"); 
		query.append("           ,BKG_HRD_CDG_CTNT C2" ).append("\n"); 
		query.append("           ,BKG_HRD_CDG_CTNT C3" ).append("\n"); 
		query.append("           ,BKG_CSTMS_ADV_ERR D" ).append("\n"); 
		query.append("     WHERE  BL.CNT_CD = 'CA'" ).append("\n"); 
		query.append("       AND  C1.HRD_CDG_ID(+) = 'CND_ACK_CODE'" ).append("\n"); 
		query.append("       AND  BL.CSTMS_ACK_RCV_RSLT_CD = C1.ATTR_CTNT1(+)" ).append("\n"); 
		query.append("       AND  C2.HRD_CDG_ID(+) = 'CND_RESULT_CODE'" ).append("\n"); 
		query.append("       AND  BL.CSTMS_ACK_PROC_RSLT_CD  = C2.ATTR_CTNT1(+)" ).append("\n"); 
		query.append("       AND  C3.HRD_CDG_ID(+) = 'CND_TRSM_STS_CD'" ).append("\n"); 
		query.append("       AND  BL.CSTMS_TRSM_STS_CD = C3.ATTR_CTNT1(+)" ).append("\n"); 
		query.append("       AND  BL.CSTMS_ACK_RJCT_CD  = D.CSTMS_ERR_CD(+)" ).append("\n"); 
		query.append("       AND  D.CNT_CD(+) = 'CA'" ).append("\n"); 
		query.append("       AND  BL.FULL_MTY_CD = @[rpt_flag]" ).append("\n"); 
		query.append("    #if (${bl_no} != '')" ).append("\n"); 
		query.append("       AND  BL.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("        #if (${vvd_cd} != '')" ).append("\n"); 
		query.append("           AND  BL.VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("           AND  BL.SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("           AND  BL.SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${pol_cd} != '')" ).append("\n"); 
		query.append("           AND  BL.CSTMS_POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${pod_cd} != '')" ).append("\n"); 
		query.append("           AND  BL.CSTMS_POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("	    #if (${cstms_trsm_sts_cd} == 'SentByA6A')" ).append("\n"); 
		query.append("	       AND  BL.CSTMS_TRSM_STS_CD = '00'" ).append("\n"); 
		query.append("	    #elseif (${cstms_trsm_sts_cd} == 'AddedByAi')" ).append("\n"); 
		query.append("	       AND  BL.CSTMS_TRSM_STS_CD IN ('04')" ).append("\n"); 
		query.append("	    #elseif (${cstms_trsm_sts_cd} == 'UnManifested')" ).append("\n"); 
		query.append("	       AND  (BL.CSTMS_TRSM_STS_CD IS NULL OR BL.CSTMS_TRSM_STS_CD IN ('03'))" ).append("\n"); 
		query.append("	    #elseif (${cstms_trsm_sts_cd} == 'Manifested')" ).append("\n"); 
		query.append("	       AND  BL.CSTMS_TRSM_STS_CD IN ('00','04')" ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("	    #if (${s_snd_dt} != '')" ).append("\n"); 
		query.append("	       AND  BL.AMDT_SND_DT BETWEEN TO_DATE(@[s_snd_dt] || ' 000000','YYYY-MM-DD HH24MISS') AND TO_DATE(@[e_snd_dt] || ' 235959','YYYY-MM-DD HH24MISS')" ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("	    #if (${s_rcv_dt} != '')" ).append("\n"); 
		query.append("	       AND  BL.CSTMS_ACK_RCV_DT BETWEEN TO_DATE(@[s_rcv_dt] || ' 000000','YYYY-MM-DD HH24MISS') AND TO_DATE(@[e_rcv_dt] || ' 235959','YYYY-MM-DD HH24MISS')" ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("	    #if (${cstms_ack_proc_rslt_cd} != '')" ).append("\n"); 
		query.append("	       AND  BL.CSTMS_ACK_PROC_RSLT_CD IN (${cstms_ack_proc_rslt_cd})" ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
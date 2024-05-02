/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : AvailableOffHireDBDAOAvailableOffHireContainerTargetLocationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.10
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AvailableOffHireDBDAOAvailableOffHireContainerTargetLocationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2016.05.16 / Jiyeon Jeon -> 저장된 Target Off-Hire Location을 불러오는 쿼리
	  * </pre>
	  */
	public AvailableOffHireDBDAOAvailableOffHireContainerTargetLocationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_loc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slb_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.integration").append("\n"); 
		query.append("FileName : AvailableOffHireDBDAOAvailableOffHireContainerTargetLocationRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("CTRT_NO" ).append("\n"); 
		query.append("	, AGMT_NO" ).append("\n"); 
		query.append("    , VNDR_SEQ" ).append("\n"); 
		query.append("	, OLD_AGMT_NO" ).append("\n"); 
		query.append("	, LESSOR_CD" ).append("\n"); 
		query.append("	, AGMT_CTY_CD" ).append("\n"); 
		query.append("	, AGMT_SEQ" ).append("\n"); 
		query.append("	, CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	, LSTM_CD" ).append("\n"); 
		query.append("	, SLB_FLG" ).append("\n"); 
		query.append("	, USE_FLG " ).append("\n"); 
		query.append("    , EQ_LOC_TP_CD" ).append("\n"); 
		query.append("	, EQ_LOC_TP_NM" ).append("\n"); 
		query.append("    , LOC_CD" ).append("\n"); 
		query.append("    , FULL_LOC_TP_CD" ).append("\n"); 
		query.append("	, OFFH_FM_DT" ).append("\n"); 
		query.append("	, OFFH_TO_DT" ).append("\n"); 
		query.append("    , GEN_RMK" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append("    , REM_QTY" ).append("\n"); 
		query.append("    FROM(" ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("       LA.AGMT_CTY_CD" ).append("\n"); 
		query.append("     , LA.AGMT_SEQ" ).append("\n"); 
		query.append("     , LA.VNDR_SEQ" ).append("\n"); 
		query.append("     , LA.LSE_CTRT_NO AS CTRT_NO" ).append("\n"); 
		query.append("     , LA.AGMT_CTY_CD || LTRIM(TO_CHAR(LA.AGMT_SEQ, '000000')) AS AGMT_NO" ).append("\n"); 
		query.append("     , LA.OLD_AGMT_NO AS OLD_AGMT_NO" ).append("\n"); 
		query.append("     , (SELECT MV.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("          FROM MDM_VENDOR MV" ).append("\n"); 
		query.append("         WHERE MV.VNDR_SEQ = LA.VNDR_SEQ) AS LESSOR_CD" ).append("\n"); 
		query.append("	 , LAR.CNTR_TPSZ_CD AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	 , LA.LSTM_CD" ).append("\n"); 
		query.append("	 , LA.SLB_FLG" ).append("\n"); 
		query.append("     ,(SELECT LISTAGG(EQ_LOC_TP_CD, ',') WITHIN GROUP(ORDER BY EQ_LOC_TP_CD) FROM LSE_AGMT_OFFH_PLC WHERE AGMT_SEQ=LA.AGMT_SEQ and CNTR_TPSZ_CD=LAR.CNTR_TPSZ_CD ) AS EQ_LOC_TP_CD" ).append("\n"); 
		query.append("     ,(SELECT LISTAGG((SELECT INTG_CD_VAL_DP_DESC AS CODE_NM FROM   COM_INTG_CD_DTL WHERE  INTG_CD_ID ='CD30026' AND INTG_CD_VAL_CTNT=EQ_LOC_TP_CD), ',') WITHIN GROUP(ORDER BY EQ_LOC_TP_CD) FROM LSE_AGMT_OFFH_PLC WHERE AGMT_SEQ=LA.AGMT_SEQ and CNTR_TPSZ_CD=LAR.CNTR_TPSZ_CD ) AS EQ_LOC_TP_NM" ).append("\n"); 
		query.append("     ,(SELECT LISTAGG(LOC_CD, ',') WITHIN GROUP(ORDER BY EQ_LOC_TP_CD) FROM LSE_AGMT_OFFH_PLC WHERE AGMT_SEQ=LA.AGMT_SEQ and CNTR_TPSZ_CD=LAR.CNTR_TPSZ_CD) AS LOC_CD" ).append("\n"); 
		query.append("     ,(SELECT LISTAGG(EQ_LOC_TP_CD||'|'||LOC_CD, ',') WITHIN GROUP(ORDER BY LOC_CD) FROM LSE_AGMT_OFFH_PLC WHERE AGMT_SEQ=LA.AGMT_SEQ and CNTR_TPSZ_CD=LAR.CNTR_TPSZ_CD) AS FULL_LOC_TP_CD" ).append("\n"); 
		query.append("     , NVL((SELECT COUNT(*)" ).append("\n"); 
		query.append("         FROM MST_CONTAINER MC" ).append("\n"); 
		query.append("        WHERE LA.AGMT_CTY_CD     = MC.AGMT_CTY_CD" ).append("\n"); 
		query.append("          AND LA.AGMT_SEQ        = MC.AGMT_SEQ" ).append("\n"); 
		query.append("          AND MC.CNTR_STS_CD NOT IN ('LSO', 'TLL', 'DON', 'SCR', 'DSP')" ).append("\n"); 
		query.append("         GROUP BY MC.AGMT_CTY_CD, MC.AGMT_SEQ),0) AS REM_QTY" ).append("\n"); 
		query.append("	 ,(SELECT MAX(OFFH_FM_DT) FROM LSE_AGMT_OFFH_PLC WHERE AGMT_SEQ=LA.AGMT_SEQ and CNTR_TPSZ_CD=LAR.CNTR_TPSZ_CD) AS OFFH_FM_DT" ).append("\n"); 
		query.append("	 ,(SELECT MAX(OFFH_TO_DT) FROM LSE_AGMT_OFFH_PLC WHERE AGMT_SEQ=LA.AGMT_SEQ and CNTR_TPSZ_CD=LAR.CNTR_TPSZ_CD) AS OFFH_TO_DT" ).append("\n"); 
		query.append("     ,(SELECT MAX(UPD_DT) FROM LSE_AGMT_OFFH_PLC WHERE AGMT_SEQ=LA.AGMT_SEQ and CNTR_TPSZ_CD=LAR.CNTR_TPSZ_CD) AS UPD_DT" ).append("\n"); 
		query.append("     ,(SELECT MAX(UPD_USR_ID) FROM LSE_AGMT_OFFH_PLC WHERE AGMT_SEQ=LA.AGMT_SEQ and CNTR_TPSZ_CD=LAR.CNTR_TPSZ_CD) AS UPD_USR_ID" ).append("\n"); 
		query.append("     ,(SELECT MAX(GEN_RMK) FROM LSE_AGMT_OFFH_PLC WHERE AGMT_SEQ=LA.AGMT_SEQ and CNTR_TPSZ_CD=LAR.CNTR_TPSZ_CD) AS GEN_RMK" ).append("\n"); 
		query.append("     ,(SELECT MAX(USE_FLG) FROM LSE_AGMT_OFFH_PLC WHERE AGMT_SEQ=LA.AGMT_SEQ and CNTR_TPSZ_CD=LAR.CNTR_TPSZ_CD) AS USE_FLG" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("       LSE_AGREEMENT LA" ).append("\n"); 
		query.append("     , LSE_AGMT_RT LAR" ).append("\n"); 
		query.append("  WHERE 1=1" ).append("\n"); 
		query.append("   AND LA.AGMT_CTY_CD = LAR.AGMT_CTY_CD(+)" ).append("\n"); 
		query.append("   AND LA.AGMT_SEQ    = LAR.AGMT_SEQ(+)   " ).append("\n"); 
		query.append("   AND LAR.CNTR_RNTL_CHG_TP_CD='GENV'" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("   WHERE 1=1" ).append("\n"); 
		query.append("   #if (${ctrt_no} != '') " ).append("\n"); 
		query.append("         AND CTRT_NO = @[ctrt_no]" ).append("\n"); 
		query.append("    #end   " ).append("\n"); 
		query.append("    #if (${agmt_seq} != '') " ).append("\n"); 
		query.append("         AND AGMT_SEQ = @[agmt_seq]   " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append(" 	#if (${lstm_list} != '')  " ).append("\n"); 
		query.append("		AND LSTM_CD IN (" ).append("\n"); 
		query.append("    	#foreach ($key IN ${lstm_list})" ).append("\n"); 
		query.append("     	   #if($velocityCount < $lstm_list.size())" ).append("\n"); 
		query.append("       	     '$key'," ).append("\n"); 
		query.append("       	   #else" ).append("\n"); 
		query.append("       	     '$key'" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${lstm_type_val} == 'ALL' || ${lstm_list} == '')  " ).append("\n"); 
		query.append("		AND LSTM_CD IN ('LP', 'LT', 'ST', 'OF', 'SI', 'MI')" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("    #if (${cntr_tpsz_list} != '') " ).append("\n"); 
		query.append("         AND CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("    #foreach ($key IN ${cntr_tpsz_list})" ).append("\n"); 
		query.append("        #if($velocityCount < $cntr_tpsz_list.size())  " ).append("\n"); 
		query.append("            '$key'," ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            '$key'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append("    #if (${loc_cd_list} != '') " ).append("\n"); 
		query.append("         AND (" ).append("\n"); 
		query.append("    #foreach ($key IN ${loc_cd_list})" ).append("\n"); 
		query.append("		#if($velocityCount == 1)" ).append("\n"); 
		query.append("	 		FULL_LOC_TP_CD LIKE '%'||@[eq_loc_tp_cd]||'|' || '$key'||'%'" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("           OR FULL_LOC_TP_CD LIKE '%'||@[eq_loc_tp_cd]||'|' || '$key'||'%'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${slb_flg} == 'Y') " ).append("\n"); 
		query.append("         AND SLB_FLG = @[slb_flg]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${vndr_seq} != '') " ).append("\n"); 
		query.append("         AND VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("    #end   " ).append("\n"); 
		query.append("	#if (${use_flg} != '') " ).append("\n"); 
		query.append("         AND USE_FLG = @[use_flg]" ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("   #if (${remain} == 'E') " ).append("\n"); 
		query.append("         AND REM_QTY > 0" ).append("\n"); 
		query.append("   #end " ).append("\n"); 
		query.append("   #if (${remain} == 'O') " ).append("\n"); 
		query.append("         AND REM_QTY = 0" ).append("\n"); 
		query.append("   #end " ).append("\n"); 
		query.append("   ORDER BY AGMT_SEQ" ).append("\n"); 

	}
}
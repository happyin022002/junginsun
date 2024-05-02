/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AvailableOffHireDBDAOTargetOffHireContainerAgreementRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.15 
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

public class AvailableOffHireDBDAOTargetOffHireContainerAgreementRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2016.05.19, Jiyeon Jeon - Target off-hire location 등록을 위해 agreement 정보를 불러오는 쿼리
	  * </pre>
	  */
	public AvailableOffHireDBDAOTargetOffHireContainerAgreementRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.integration").append("\n"); 
		query.append("FileName : AvailableOffHireDBDAOTargetOffHireContainerAgreementRSQL").append("\n"); 
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
		query.append("	LR.LSTM_CD" ).append("\n"); 
		query.append("	, CTRT_NO" ).append("\n"); 
		query.append("	, AGMT_NO" ).append("\n"); 
		query.append("	, OLD_AGMT_NO" ).append("\n"); 
		query.append("	, LESSOR_CD" ).append("\n"); 
		query.append("	, LR.AGMT_CTY_CD" ).append("\n"); 
		query.append("	, LR.AGMT_SEQ" ).append("\n"); 
		query.append("	, LR.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	, LP.USE_FLG " ).append("\n"); 
		query.append("    , LP.EQ_LOC_TP_CD" ).append("\n"); 
		query.append("	, LP.EQ_LOC_TP_NM" ).append("\n"); 
		query.append("    , LP.LOC_CD" ).append("\n"); 
		query.append("    , LP.FULL_LOC_TP_CD" ).append("\n"); 
		query.append("	, LP.OFFH_FM_DT" ).append("\n"); 
		query.append("	, LP.OFFH_TO_DT" ).append("\n"); 
		query.append("    , LP.GEN_RMK" ).append("\n"); 
		query.append("    , LP.UPD_USR_ID" ).append("\n"); 
		query.append("    , LP.UPD_DT" ).append("\n"); 
		query.append("	, LR.REM_QTY" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT DISTINCT LR.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	 , LA.AGMT_CTY_CD" ).append("\n"); 
		query.append("     , LA.AGMT_SEQ" ).append("\n"); 
		query.append("	 , LA.LSTM_CD" ).append("\n"); 
		query.append("     , LA.LSE_CTRT_NO AS CTRT_NO" ).append("\n"); 
		query.append("     , LA.AGMT_CTY_CD || LTRIM(TO_CHAR(LA.AGMT_SEQ, '000000')) AS AGMT_NO" ).append("\n"); 
		query.append("     , LA.OLD_AGMT_NO" ).append("\n"); 
		query.append("     , (SELECT MV.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("          FROM MDM_VENDOR MV" ).append("\n"); 
		query.append("         WHERE MV.VNDR_SEQ = LA.VNDR_SEQ) AS LESSOR_CD" ).append("\n"); 
		query.append("	 ,  NVL((SELECT COUNT(*)" ).append("\n"); 
		query.append("                  FROM MST_CONTAINER MC" ).append("\n"); 
		query.append("                 WHERE LA.AGMT_CTY_CD = MC.AGMT_CTY_CD" ).append("\n"); 
		query.append("                   AND LA.AGMT_SEQ = MC.AGMT_SEQ" ).append("\n"); 
		query.append("                   AND MC.CNTR_STS_CD NOT IN ('LSO'," ).append("\n"); 
		query.append("                               'TLL'," ).append("\n"); 
		query.append("                               'DON'," ).append("\n"); 
		query.append("                               'SCR'," ).append("\n"); 
		query.append("                               'DSP')" ).append("\n"); 
		query.append("                 GROUP BY MC.AGMT_CTY_CD," ).append("\n"); 
		query.append("                       MC.AGMT_SEQ), 0) AS REM_QTY" ).append("\n"); 
		query.append("  FROM LSE_AGREEMENT LA" ).append("\n"); 
		query.append("     , LSE_AGMT_RT LR" ).append("\n"); 
		query.append(" WHERE LA.AGMT_CTY_CD = LR.AGMT_CTY_CD" ).append("\n"); 
		query.append("   AND LA.AGMT_SEQ = LR.AGMT_SEQ" ).append("\n"); 
		query.append("   AND LA.AGMT_LST_VER_SEQ = NVL(@[agmt_ver_seq], LA.AGMT_LST_VER_SEQ)" ).append("\n"); 
		query.append("#if (${agmt_seq} != '') " ).append("\n"); 
		query.append("   AND LA.AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lstm_cd} != '') " ).append("\n"); 
		query.append("   AND LA.LSTM_CD = @[lstm_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") LR , (" ).append("\n"); 
		query.append("  SELECT " ).append("\n"); 
		query.append("	AGMT_CTY_CD" ).append("\n"); 
		query.append("	,AGMT_SEQ" ).append("\n"); 
		query.append("	, CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	, SUBSTR(MAX(SYS_CONNECT_BY_PATH(EQ_LOC_TP_CD,',')),2) EQ_LOC_TP_CD" ).append("\n"); 
		query.append("	, SUBSTR(MAX(SYS_CONNECT_BY_PATH(EQ_LOC_TP_NM,',')),2) EQ_LOC_TP_NM" ).append("\n"); 
		query.append("	, SUBSTR(MAX(SYS_CONNECT_BY_PATH(LOC_CD,',')),2) LOC_CD" ).append("\n"); 
		query.append("	, SUBSTR(MAX(SYS_CONNECT_BY_PATH(EQ_LOC_TP_CD||'|'||LOC_CD,',')),2) FULL_LOC_TP_CD" ).append("\n"); 
		query.append("	, OFFH_FM_DT" ).append("\n"); 
		query.append("	, OFFH_TO_DT" ).append("\n"); 
		query.append("	, GEN_RMK" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append("    ,USE_FLG" ).append("\n"); 
		query.append("	FROM (" ).append("\n"); 
		query.append("		SELECT " ).append("\n"); 
		query.append("			ROW_NUMBER() OVER (PARTITION BY AGMT_CTY_CD,AGMT_SEQ, CNTR_TPSZ_CD ORDER BY AGMT_CTY_CD,AGMT_SEQ,CNTR_TPSZ_CD) ROW_RW," ).append("\n"); 
		query.append("			AGMT_CTY_CD," ).append("\n"); 
		query.append("			AGMT_SEQ, " ).append("\n"); 
		query.append("			CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("            SELECT " ).append("\n"); 
		query.append("                INTG_CD_VAL_DP_DESC AS CODE_NM" ).append("\n"); 
		query.append("            FROM   COM_INTG_CD_DTL" ).append("\n"); 
		query.append("            WHERE  INTG_CD_ID ='CD30026' AND INTG_CD_VAL_CTNT=EQ_LOC_TP_CD" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("            EQ_LOC_TP_NM ," ).append("\n"); 
		query.append("			EQ_LOC_TP_CD ," ).append("\n"); 
		query.append("			LOC_CD," ).append("\n"); 
		query.append("			OFFH_FM_DT," ).append("\n"); 
		query.append("			OFFH_TO_DT," ).append("\n"); 
		query.append("		 	GEN_RMK," ).append("\n"); 
		query.append("	     	UPD_USR_ID," ).append("\n"); 
		query.append("     		UPD_DT," ).append("\n"); 
		query.append("     		USE_FLG" ).append("\n"); 
		query.append("		FROM " ).append("\n"); 
		query.append("			LSE_AGMT_OFFH_PLC AA" ).append("\n"); 
		query.append("		) START WITH ROW_RW=1" ).append("\n"); 
		query.append("			CONNECT BY PRIOR ROW_RW=ROW_RW-1 AND PRIOR AGMT_CTY_CD=AGMT_CTY_CD AND PRIOR AGMT_SEQ=AGMT_SEQ AND PRIOR CNTR_TPSZ_CD=CNTR_TPSZ_CD" ).append("\n"); 
		query.append("			GROUP BY   AGMT_CTY_CD,AGMT_SEQ, CNTR_TPSZ_CD, OFFH_FM_DT, OFFH_TO_DT, GEN_RMK, UPD_USR_ID, UPD_DT, USE_FLG" ).append("\n"); 
		query.append("  	) LP" ).append("\n"); 
		query.append("	  WHERE 1=1" ).append("\n"); 
		query.append("   		AND LR.AGMT_CTY_CD 	  = LP.AGMT_CTY_CD(+)" ).append("\n"); 
		query.append("	    AND LR.AGMT_SEQ    	  = LP.AGMT_SEQ(+)" ).append("\n"); 
		query.append("   		AND LR.CNTR_TPSZ_CD    = LP.CNTR_TPSZ_CD(+)" ).append("\n"); 

	}
}
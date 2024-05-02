/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WaiveReportDBDAOSearchAfterBookingFileLetterRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.waivereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WaiveReportDBDAOSearchAfterBookingFileLetterRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * WaiveReportDBDAOSearchAfterBookingFileLetterRSQL
	  * </pre>
	  */
	public WaiveReportDBDAOSearchAfterBookingFileLetterRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.waivereport.integration").append("\n"); 
		query.append("FileName : WaiveReportDBDAOSearchAfterBookingFileLetterRSQL").append("\n"); 
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
		query.append("SELECT  CASE WHEN RFA_NO IS NOT NULL THEN RP_CUST_CD" ).append("\n"); 
		query.append("             WHEN SC_NO IS NOT NULL THEN SP_CUST_CD" ).append("\n"); 
		query.append("             WHEN TAA_NO IS NOT NULL THEN TAA_CUST_CD" ).append("\n"); 
		query.append("             ELSE ''" ).append("\n"); 
		query.append("        END CUST_CD " ).append("\n"); 
		query.append("    ,   CASE WHEN RFA_NO IS NOT NULL THEN RP_CUST_NM" ).append("\n"); 
		query.append("             WHEN SC_NO IS NOT NULL THEN SP_CUST_NM" ).append("\n"); 
		query.append("             WHEN TAA_NO IS NOT NULL THEN TAA_CUST_NM" ).append("\n"); 
		query.append("             ELSE ''" ).append("\n"); 
		query.append("        END CUST_NM" ).append("\n"); 
		query.append("    ,   DAR_NO" ).append("\n"); 
		query.append("    ,   APRO_DT" ).append("\n"); 
		query.append("    ,   GNTE_LTR_NM" ).append("\n"); 
		query.append("	,   FILE_NM" ).append("\n"); 
		query.append("	,   FILE_SIZE" ).append("\n"); 
		query.append("	,   FILE_PATH" ).append("\n"); 
		query.append("	,   AFT_BKG_FILE_DIV_CD" ).append("\n"); 
		query.append("	,	FILE_SAV_ID" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("FROM	" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("		SELECT	DAR_NO" ).append("\n"); 
		query.append("			,	APRO_DT" ).append("\n"); 
		query.append("			,	SC_NO" ).append("\n"); 
		query.append("			,	RFA_NO" ).append("\n"); 
		query.append("			,   TAA_NO" ).append("\n"); 
		query.append("			,	RP_CUST_CD" ).append("\n"); 
		query.append("			,	RP_CUST_NM" ).append("\n"); 
		query.append("			,	SP_CUST_CD" ).append("\n"); 
		query.append("			,	SP_CUST_NM" ).append("\n"); 
		query.append("			,	TAA_CUST_CD" ).append("\n"); 
		query.append("			,	TAA_CUST_NM" ).append("\n"); 
		query.append("			,   GNTE_LTR_NM" ).append("\n"); 
		query.append("			,   FILE_NM" ).append("\n"); 
		query.append("			,   FILE_SIZE" ).append("\n"); 
		query.append("			,   FILE_PATH" ).append("\n"); 
		query.append("			,   AFT_BKG_FILE_DIV_CD" ).append("\n"); 
		query.append("			,	FILE_SAV_ID" ).append("\n"); 
		query.append("			,	COUNT(*) OVER (PARTITION BY DAR_NO) ROWCOUNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		FROM    " ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("		        SELECT  DISTINCT ADJ_RQST.AFT_EXPT_DAR_NO DAR_NO" ).append("\n"); 
		query.append("		            ,   TO_CHAR(ADJ_RQST.APRO_DT,'YYYY-MM-DD') APRO_DT" ).append("\n"); 
		query.append("		            ,   BB.SC_NO" ).append("\n"); 
		query.append("		            ,   BB.RFA_NO" ).append("\n"); 
		query.append("					,   BB.TAA_NO" ).append("\n"); 
		query.append("		            ,   RP_MN.CTRT_CUST_CNT_CD || LPAD(RP_MN.CTRT_CUST_SEQ, 6, '0') RP_CUST_CD" ).append("\n"); 
		query.append("		            ,   (" ).append("\n"); 
		query.append("							SELECT	CUST_LGL_ENG_NM " ).append("\n"); 
		query.append("							FROM 	MDM_CUSTOMER " ).append("\n"); 
		query.append("							WHERE	CUST_CNT_CD = RP_MN.CTRT_CUST_CNT_CD " ).append("\n"); 
		query.append("								AND CUST_SEQ = RP_MN.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("						) RP_CUST_NM" ).append("\n"); 
		query.append("		            ,   SP_PTY.CUST_CNT_CD || LPAD(SP_PTY.CUST_SEQ, 6, '0') SP_CUST_CD" ).append("\n"); 
		query.append("		            ,   (" ).append("\n"); 
		query.append("							SELECT	CUST_LGL_ENG_NM " ).append("\n"); 
		query.append("							FROM	MDM_CUSTOMER " ).append("\n"); 
		query.append("							WHERE	CUST_CNT_CD = SP_PTY.CUST_CNT_CD " ).append("\n"); 
		query.append("								AND CUST_SEQ = SP_PTY.CUST_SEQ " ).append("\n"); 
		query.append("						) SP_CUST_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		            ,   TAA_MN.CTRT_CUST_CNT_CD || LPAD(TAA_MN.CTRT_CUST_SEQ, 6, '0') TAA_CUST_CD" ).append("\n"); 
		query.append("		            ,   (" ).append("\n"); 
		query.append("							SELECT	CUST_LGL_ENG_NM " ).append("\n"); 
		query.append("							FROM 	MDM_CUSTOMER " ).append("\n"); 
		query.append("							WHERE	CUST_CNT_CD = TAA_MN.CTRT_CUST_CNT_CD " ).append("\n"); 
		query.append("								AND CUST_SEQ = TAA_MN.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("						) TAA_CUST_NM" ).append("\n"); 
		query.append("					,   ( SELECT INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("                            FROM COM_INTG_CD_DTL " ).append("\n"); 
		query.append("                           WHERE INTG_CD_ID = 'CD03528' " ).append("\n"); 
		query.append("                             AND INTG_CD_VAL_CTNT = ADJ_RQST.GNTE_LTR_CD " ).append("\n"); 
		query.append("                         ) AS GNTE_LTR_NM" ).append("\n"); 
		query.append("					,   FL.FILE_SAV_ID" ).append("\n"); 
		query.append("                    ,   NVL(T2.FILE_UPLD_NM,'')				AS FILE_NM" ).append("\n"); 
		query.append("                    ,   T2.FILE_SZ_CAPA     				AS FILE_SIZE" ).append("\n"); 
		query.append("                    ,   T2.FILE_PATH_URL    				AS FILE_PATH" ).append("\n"); 
		query.append("	                ,   FL.AFT_BKG_FILE_DIV_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				FROM    DMT_AFT_BKG_FILE_RQST FL" ).append("\n"); 
		query.append("				    ,   COM_UPLD_FILE T2" ).append("\n"); 
		query.append("				    ,   DMT_AFT_BKG_ADJ_RQST ADJ_RQST" ).append("\n"); 
		query.append("					,   DMT_AFT_BKG_ADJ_RQST_DTL ADJ_RQST_DTL" ).append("\n"); 
		query.append("					,   BKG_BOOKING BB" ).append("\n"); 
		query.append("					,   PRI_RP_HDR RP_HDR" ).append("\n"); 
		query.append("					,   PRI_RP_MN RP_MN" ).append("\n"); 
		query.append("					,   PRI_SP_HDR SP_HDR" ).append("\n"); 
		query.append("					,   PRI_SP_CTRT_PTY SP_PTY" ).append("\n"); 
		query.append("					,   PRI_TAA_HDR TAA_HDR" ).append("\n"); 
		query.append("					,   PRI_TAA_MN TAA_MN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				WHERE 1=1" ).append("\n"); 
		query.append("					AND ADJ_RQST.DMDT_EXPT_RQST_STS_CD = 'A'" ).append("\n"); 
		query.append("				    AND FL.AFT_BKG_FILE_DIV_CD = 'LETT01'" ).append("\n"); 
		query.append("                    AND FL.FILE_SAV_ID          = T2.FILE_SAV_ID(+)" ).append("\n"); 
		query.append("                    AND T2.DELT_FLG(+)             = 'N'" ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("				    AND FL.AFT_EXPT_DAR_NO = ADJ_RQST.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("					AND ADJ_RQST.AFT_EXPT_DAR_NO = ADJ_RQST_DTL.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("					AND ADJ_RQST_DTL.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					AND BB.RFA_NO = RP_HDR.RFA_NO(+)" ).append("\n"); 
		query.append("					AND RP_HDR.PROP_NO = RP_MN.PROP_NO(+)" ).append("\n"); 
		query.append("					AND	(" ).append("\n"); 
		query.append("							RP_MN.AMDT_SEQ IS NULL" ).append("\n"); 
		query.append("							OR" ).append("\n"); 
		query.append("							(" ).append("\n"); 
		query.append("								RP_MN.AMDT_SEQ =" ).append("\n"); 
		query.append("								(" ).append("\n"); 
		query.append("									SELECT 	/*+ INDEX_DESC(PRI_RP_MN XPKPRI_RP_MN) */AMDT_SEQ" ).append("\n"); 
		query.append("									FROM	PRI_RP_MN" ).append("\n"); 
		query.append("									WHERE	PROP_NO = RP_MN.PROP_NO" ).append("\n"); 
		query.append("										AND	ROWNUM = 1" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("					AND BB.SC_NO = SP_HDR.SC_NO(+)" ).append("\n"); 
		query.append("					AND SP_HDR.PROP_NO = SP_PTY.PROP_NO(+)" ).append("\n"); 
		query.append("					AND (" ).append("\n"); 
		query.append("							(" ).append("\n"); 
		query.append("								SP_PTY.PRC_CTRT_PTY_TP_CD IS NULL AND SP_PTY.AMDT_SEQ IS NULL" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("							OR " ).append("\n"); 
		query.append("							(" ).append("\n"); 
		query.append("								SP_PTY.PRC_CTRT_PTY_TP_CD = 'C' " ).append("\n"); 
		query.append("								AND " ).append("\n"); 
		query.append("								SP_PTY.AMDT_SEQ = " ).append("\n"); 
		query.append("								(" ).append("\n"); 
		query.append("									SELECT	/*+ INDEX_DESC(PRI_SP_CTRT_PTY XPKPRI_SP_CTRT_PTY) */AMDT_SEQ " ).append("\n"); 
		query.append("									FROM	PRI_SP_CTRT_PTY " ).append("\n"); 
		query.append("									WHERE 	PROP_NO = SP_PTY.PROP_NO" ).append("\n"); 
		query.append("										AND	PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("										AND	ROWNUM = 1" ).append("\n"); 
		query.append("								)				" ).append("\n"); 
		query.append("							)  " ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					AND TAA_HDR.TAA_NO(+) = BB.TAA_NO" ).append("\n"); 
		query.append("					AND TAA_HDR.TAA_PROP_NO = TAA_MN.TAA_PROP_NO(+)" ).append("\n"); 
		query.append("					AND	(" ).append("\n"); 
		query.append("							TAA_MN.AMDT_SEQ IS NULL" ).append("\n"); 
		query.append("							OR" ).append("\n"); 
		query.append("							(" ).append("\n"); 
		query.append("								TAA_MN.AMDT_SEQ =" ).append("\n"); 
		query.append("								(" ).append("\n"); 
		query.append("									SELECT 	/*+ INDEX_DESC(PRI_TAA_MN XFK1PRI_TAA_MN) */AMDT_SEQ" ).append("\n"); 
		query.append("									FROM	PRI_TAA_MN" ).append("\n"); 
		query.append("									WHERE	TAA_PROP_NO = TAA_MN.TAA_PROP_NO" ).append("\n"); 
		query.append("										AND	ROWNUM = 1" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${cust_cd} != '' )" ).append("\n"); 
		query.append("					AND ( RP_MN.CTRT_CUST_CNT_CD || LPAD(RP_MN.CTRT_CUST_SEQ, 6, '0') = @[cust_cd]" ).append("\n"); 
		query.append("                       OR SP_PTY.CUST_CNT_CD || LPAD(SP_PTY.CUST_SEQ, 6, '0') = @[cust_cd]" ).append("\n"); 
		query.append("                       OR TAA_MN.CTRT_CUST_CNT_CD || LPAD(TAA_MN.CTRT_CUST_SEQ, 6, '0') = @[cust_cd]" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${dar_no} != '' )" ).append("\n"); 
		query.append("					AND	FL.AFT_EXPT_DAR_NO IN (" ).append("\n"); 
		query.append("                            #foreach( $dar_no_p in ${tempDarNoList}) " ).append("\n"); 
		query.append("                                #if($velocityCount < $tempDarNoList.size()) " ).append("\n"); 
		query.append("                                   '$dar_no_p', " ).append("\n"); 
		query.append("                                #else " ).append("\n"); 
		query.append("                                   '$dar_no_p' " ).append("\n"); 
		query.append("                                #end " ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
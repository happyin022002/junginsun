/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AgentCanalTransitFeeBCDBDAOsearchCanalTzFeeSumRptRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.25
*@LastModifier : 윤권영
*@LastVersion : 1.0
* 2016.07.25 윤권영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yun Kwon-Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgentCanalTransitFeeBCDBDAOsearchCanalTzFeeSumRptRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCanalTzFeeSumRpt
	  * </pre>
	  */
	public AgentCanalTransitFeeBCDBDAOsearchCanalTzFeeSumRptRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("revyrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.integration").append("\n"); 
		query.append("FileName : AgentCanalTransitFeeBCDBDAOsearchCanalTzFeeSumRptRSQL").append("\n"); 
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
		query.append("SELECT	PAY_TO," ).append("\n"); 
		query.append("		VVD," ).append("\n"); 
		query.append("		VSL_CD," ).append("\n"); 
		query.append("		SKD_VOY_NO," ).append("\n"); 
		query.append("		SKD_DIR_CD," ).append("\n"); 
		query.append("		VSL_NM," ).append("\n"); 
		query.append("		TRNS_DT," ).append("\n"); 
		query.append("		PY_DUE_DT," ).append("\n"); 
		query.append("		DECODE(ADVANCE_PAYMENT_STS,'R','0','Q','1','A','2','P','3',decode(INVOICE_STS,'R','2','Q','2','A','2','0'))||nvl(ESEQ,'1')	ADV_PY_STS," ).append("\n"); 
		query.append("		ADVANCE_PAYMENT_REVMONTH ADV_PY_REV_MON," ).append("\n"); 
		query.append("		INVOICE_STS," ).append("\n"); 
		query.append("		DECODE(INVOICE_STS,'R','0','Q','1','A','2','0')||decode(ISEQ,null,'1',ISEQ-1) INV_STS," ).append("\n"); 
		query.append("		INVOICE_REVMONTH INV_REV_MON," ).append("\n"); 
		query.append("		'' MSA," ).append("\n"); 
		query.append("		RESULT RSLT," ).append("\n"); 
		query.append("		NVL(ESEQ,1) ESEQ," ).append("\n"); 
		query.append("		NVL(ISEQ,2) ISEQ," ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("        	SELECT  max(YD_CD)" ).append("\n"); 
		query.append("            FROM    PSO_TGT_YD_SKD" ).append("\n"); 
		query.append("            WHERE   VSL_CD        = A.VSL_CD" ).append("\n"); 
		query.append("            AND     SKD_VOY_NO    = A.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND     SKD_DIR_CD    = A.SKD_DIR_CD" ).append("\n"); 
		query.append("			AND 	PSO_BZTP_CD   = '5'" ).append("\n"); 
		query.append("            AND 	BUD_SCNR_NO   = '999912' " ).append("\n"); 
		query.append("		    AND     YD_CD         = A.YD_CD" ).append("\n"); 
		query.append("        ) YD_CD ," ).append("\n"); 
		query.append("  		'' REVYRMON ," ).append("\n"); 
		query.append("  		'' PORT_CD ," ).append("\n"); 
		query.append("  		@[vndr_seq] VNDR_SEQ ," ).append("\n"); 
		query.append("  		LANE" ).append("\n"); 
		query.append("  		, (SELECT  max(VNDR_CNT_CD)" ).append("\n"); 
		query.append("		  FROM    MDM_VENDOR" ).append("\n"); 
		query.append("		  WHERE   VNDR_SEQ      = @[vndr_seq]" ).append("\n"); 
		query.append("		  ) VNDR_CNT_CD," ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("        	SELECT" ).append("\n"); 
		query.append("               DECODE(SKD_CNG_STS_CD,'S','SKIP','')" ).append("\n"); 
		query.append("            FROM    PSO_TGT_YD_SKD" ).append("\n"); 
		query.append("            WHERE   VSL_CD        = A.VSL_CD" ).append("\n"); 
		query.append("            AND     SKD_VOY_NO    = A.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND     SKD_DIR_CD    = A.SKD_DIR_CD" ).append("\n"); 
		query.append("			AND 	PSO_BZTP_CD = '5'" ).append("\n"); 
		query.append("            AND 	BUD_SCNR_NO 		= '999912'" ).append("\n"); 
		query.append("            AND     substr(YD_CD, 0, 2) = (SELECT max(VNDR_CNT_CD)" ).append("\n"); 
		query.append("                  							 FROM MDM_VENDOR" ).append("\n"); 
		query.append("                 							WHERE VNDR_SEQ = @[vndr_seq])" ).append("\n"); 
		query.append("        ) PORT_SKIP_STS	" ).append("\n"); 
		query.append("FROM  		" ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			SELECT	(   " ).append("\n"); 
		query.append("			            SELECT  VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("			            FROM    MDM_VENDOR" ).append("\n"); 
		query.append("			            WHERE   VNDR_SEQ      = @[vndr_seq]" ).append("\n"); 
		query.append("			        ) PAY_TO," ).append("\n"); 
		query.append("			        VSL_CD||SKD_VOY_NO||SKD_DIR_CD VVD," ).append("\n"); 
		query.append("			        VSL_CD," ).append("\n"); 
		query.append("			        SKD_VOY_NO," ).append("\n"); 
		query.append("					SKD_DIR_CD," ).append("\n"); 
		query.append("					YD_CD," ).append("\n"); 
		query.append("			        (SELECT VSL_ENG_NM||' ('||A.VSL_CD||')'" ).append("\n"); 
		query.append("			               FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("			              WHERE VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("			        ) VSL_NM," ).append("\n"); 
		query.append("			        (" ).append("\n"); 
		query.append("			            SELECT  VSL_SLAN_CD" ).append("\n"); 
		query.append("			            FROM    VSK_VSL_SKD" ).append("\n"); 
		query.append("			            WHERE   VSL_CD 		= A.VSL_CD " ).append("\n"); 
		query.append("					    AND		SKD_VOY_NO 	= A.SKD_VOY_NO" ).append("\n"); 
		query.append("					    AND     SKD_DIR_CD 	= A.SKD_DIR_CD" ).append("\n"); 
		query.append("			        ) LANE," ).append("\n"); 
		query.append("			        (" ).append("\n"); 
		query.append("			            SELECT  TO_CHAR(VPS_ETA_DT,'YYYY-MM-DD')" ).append("\n"); 
		query.append("			            FROM    VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("			            WHERE   VSL_CD       = A.VSL_CD" ).append("\n"); 
		query.append("			            AND     SKD_VOY_NO   = A.SKD_VOY_NO" ).append("\n"); 
		query.append("			            AND     SKD_DIR_CD   = A.SKD_DIR_CD" ).append("\n"); 
		query.append("			            AND     VPS_PORT_CD  = (SELECT decode(vndr_cnt_cd,'PA','PAPAC','EGSUZ') FROM MDM_VENDOR WHERE VNDR_SEQ=@[vndr_seq])" ).append("\n"); 
		query.append("					) TRNS_DT," ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("						SELECT TO_CHAR(DUE_DT,'YYYY-MM-DD') PY_DUE_DT " ).append("\n"); 
		query.append("						  FROM PSO_CHARGE AA," ).append("\n"); 
		query.append("						  	   PSO_CNL_TZ_FEE BB" ).append("\n"); 
		query.append("						 WHERE AA.ISS_CTY_CD = BB.ISS_CTY_CD " ).append("\n"); 
		query.append("						   AND AA.SO_SEQ     = BB.SO_SEQ" ).append("\n"); 
		query.append("						   AND BB.VSL_CD 	 = A.VSL_CD" ).append("\n"); 
		query.append("						   AND BB.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("						   AND BB.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("						   AND BB.PSO_BZTP_CD= A.PSO_BZTP_CD" ).append("\n"); 
		query.append("						   AND BB.CNL_TZ_BZTP_CD = 'E'" ).append("\n"); 
		query.append("						   AND BB.BUD_SCNR_NO 	 = '999912'" ).append("\n"); 
		query.append("                           AND BB.YD_CD          =  A.YD_CD --추가" ).append("\n"); 
		query.append("					) PY_DUE_DT," ).append("\n"); 
		query.append("			        (" ).append("\n"); 
		query.append("			        	SELECT  DECODE(INV_STS_CD,'D','P',CNL_TZ_PROC_STS_CD) CNL_TZ_PROC_STS_CD" ).append("\n"); 
		query.append("        				FROM    PSO_CNL_TZ_FEE AA, PSO_CHARGE BB, AP_PAY_INV DD" ).append("\n"); 
		query.append("        				WHERE AA.ISS_CTY_CD   = BB.ISS_CTY_CD(+)" ).append("\n"); 
		query.append("        				AND   AA.SO_SEQ       = BB.SO_SEQ(+)" ).append("\n"); 
		query.append("        				AND   AA.VSL_CD       = A.VSL_CD                                    " ).append("\n"); 
		query.append("       	 				AND   AA.SKD_VOY_NO   = A.SKD_VOY_NO" ).append("\n"); 
		query.append("        				AND   AA.SKD_DIR_CD   = A.SKD_DIR_CD" ).append("\n"); 
		query.append("        				AND   BB.INV_RGST_NO  = DD.INV_RGST_NO(+)" ).append("\n"); 
		query.append("        				AND   AA.CNL_TZ_BZTP_CD = 'E'" ).append("\n"); 
		query.append("						AND   AA.BUD_SCNR_NO 	= '999912'" ).append("\n"); 
		query.append("        				AND   NTC_YRMON = REPLACE(@[revyrmon],'-', '')" ).append("\n"); 
		query.append("                        AND   AA.YD_CD          =  A.YD_CD --추가" ).append("\n"); 
		query.append("			        ) ADVANCE_PAYMENT_STS," ).append("\n"); 
		query.append("			        (" ).append("\n"); 
		query.append("			        	SELECT  MAX(REV_YRMON)" ).append("\n"); 
		query.append("			            FROM    PSO_CNL_TZ_FEE" ).append("\n"); 
		query.append("			            WHERE   VSL_CD        = A.VSL_CD" ).append("\n"); 
		query.append("			            AND     SKD_VOY_NO    = A.SKD_VOY_NO" ).append("\n"); 
		query.append("			            AND     SKD_DIR_CD    = A.SKD_DIR_CD" ).append("\n"); 
		query.append("			            AND     PSO_BZTP_CD	  = A.PSO_BZTP_CD" ).append("\n"); 
		query.append("			            AND     CNL_TZ_BZTP_CD = 'E' " ).append("\n"); 
		query.append("                        AND     YD_CD          = A.YD_CD --추가" ).append("\n"); 
		query.append("						AND     BUD_SCNR_NO    = '999912'" ).append("\n"); 
		query.append("			        ) ADVANCE_PAYMENT_REVMONTH," ).append("\n"); 
		query.append("			        (" ).append("\n"); 
		query.append("			        	SELECT  CNL_TZ_PROC_STS_CD" ).append("\n"); 
		query.append("			            FROM    PSO_CNL_TZ_FEE" ).append("\n"); 
		query.append("			            WHERE   VSL_CD        = A.VSL_CD" ).append("\n"); 
		query.append("			            AND     SKD_VOY_NO    = A.SKD_VOY_NO" ).append("\n"); 
		query.append("			            AND     SKD_DIR_CD    = A.SKD_DIR_CD" ).append("\n"); 
		query.append("			            AND     PSO_BZTP_CD	  = A.PSO_BZTP_CD" ).append("\n"); 
		query.append("			            AND     CNL_TZ_BZTP_CD= 'I' " ).append("\n"); 
		query.append("			            AND     NTC_YRMON     = REPLACE(@[revyrmon],'-', '')" ).append("\n"); 
		query.append("                        AND     YD_CD         = A.YD_CD  --추가" ).append("\n"); 
		query.append("                        AND     BUD_SCNR_NO   = '999912'" ).append("\n"); 
		query.append("			        ) INVOICE_STS," ).append("\n"); 
		query.append("			        (" ).append("\n"); 
		query.append("			        	SELECT  REV_YRMON" ).append("\n"); 
		query.append("			            FROM    PSO_CNL_TZ_FEE" ).append("\n"); 
		query.append("			            WHERE   VSL_CD        = A.VSL_CD" ).append("\n"); 
		query.append("			            AND     SKD_VOY_NO    = A.SKD_VOY_NO" ).append("\n"); 
		query.append("			            AND     SKD_DIR_CD    = A.SKD_DIR_CD" ).append("\n"); 
		query.append("			            AND     PSO_BZTP_CD	  = A.PSO_BZTP_CD" ).append("\n"); 
		query.append("			            AND     CNL_TZ_BZTP_CD= 'I' " ).append("\n"); 
		query.append("			            AND     NTC_YRMON     = REPLACE(@[revyrmon],'-', '')" ).append("\n"); 
		query.append("                        AND     YD_CD         = A.YD_CD  --추가" ).append("\n"); 
		query.append("						AND     BUD_SCNR_NO   = '999912'" ).append("\n"); 
		query.append("			        ) INVOICE_REVMONTH," ).append("\n"); 
		query.append("			        (" ).append("\n"); 
		query.append("			        	SELECT  MAX(DIFF_RMK)" ).append("\n"); 
		query.append("			            FROM    PSO_CNL_TZ_FEE" ).append("\n"); 
		query.append("			            WHERE   VSL_CD        = A.VSL_CD" ).append("\n"); 
		query.append("			            AND     SKD_VOY_NO    = A.SKD_VOY_NO" ).append("\n"); 
		query.append("			            AND     SKD_DIR_CD    = A.SKD_DIR_CD" ).append("\n"); 
		query.append("			            AND     PSO_BZTP_CD	  = A.PSO_BZTP_CD" ).append("\n"); 
		query.append("			            AND     NTC_YRMON     = REPLACE(@[revyrmon],'-', '')" ).append("\n"); 
		query.append("                        AND     YD_CD         = A.YD_CD  --추가" ).append("\n"); 
		query.append("						AND     BUD_SCNR_NO   = '999912'" ).append("\n"); 
		query.append("			        ) RESULT," ).append("\n"); 
		query.append("			        (" ).append("\n"); 
		query.append("			        	SELECT  MAX(CALL_SEQ)" ).append("\n"); 
		query.append("			            FROM    PSO_CNL_TZ_FEE" ).append("\n"); 
		query.append("			            WHERE   VSL_CD        = A.VSL_CD" ).append("\n"); 
		query.append("			            AND     SKD_VOY_NO    = A.SKD_VOY_NO" ).append("\n"); 
		query.append("			            AND     SKD_DIR_CD    = A.SKD_DIR_CD" ).append("\n"); 
		query.append("			            AND     PSO_BZTP_CD	  = A.PSO_BZTP_CD" ).append("\n"); 
		query.append("			            AND     CNL_TZ_BZTP_CD= 'E' " ).append("\n"); 
		query.append("                        AND     YD_CD         = A.YD_CD  --추가" ).append("\n"); 
		query.append("			            AND     NTC_YRMON     = REPLACE(@[revyrmon],'-', '')" ).append("\n"); 
		query.append("						AND     BUD_SCNR_NO   = '999912'" ).append("\n"); 
		query.append("			        ) ESEQ," ).append("\n"); 
		query.append("			        (" ).append("\n"); 
		query.append("			        	SELECT  MAX(CALL_SEQ)" ).append("\n"); 
		query.append("			            FROM    PSO_CNL_TZ_FEE" ).append("\n"); 
		query.append("			            WHERE   VSL_CD        = A.VSL_CD" ).append("\n"); 
		query.append("			            AND     SKD_VOY_NO    = A.SKD_VOY_NO" ).append("\n"); 
		query.append("			            AND     SKD_DIR_CD    = A.SKD_DIR_CD" ).append("\n"); 
		query.append("			            AND     PSO_BZTP_CD	  = A.PSO_BZTP_CD" ).append("\n"); 
		query.append("			            AND     CNL_TZ_BZTP_CD= 'I' " ).append("\n"); 
		query.append("                        AND     YD_CD         = A.YD_CD  --추가" ).append("\n"); 
		query.append("			            AND     NTC_YRMON     = REPLACE(@[revyrmon],'-', '')" ).append("\n"); 
		query.append("						AND     BUD_SCNR_NO   = '999912'" ).append("\n"); 
		query.append("			        ) ISEQ" ).append("\n"); 
		query.append("			FROM			" ).append("\n"); 
		query.append("					(	" ).append("\n"); 
		query.append("					    SELECT  PSO_BZTP_CD, VSL_CD,SKD_VOY_NO,SKD_DIR_CD, YD_CD" ).append("\n"); 
		query.append("					    FROM    " ).append("\n"); 
		query.append("					    	(" ).append("\n"); 
		query.append("					            SELECT  5 PSO_BZTP_CD, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD," ).append("\n"); 
		query.append("								        ( SELECT DECODE(VNDR_CNT_CD,'EG','EGSUZT1','PAPACT1')  " ).append("\n"); 
		query.append("                                                                     FROM MDM_VENDOR " ).append("\n"); 
		query.append("                                                                    WHERE VNDR_SEQ = C.CNL_AGN_VNDR_SEQ ) AS YD_CD" ).append("\n"); 
		query.append("					            FROM    PSO_TGT_VVD A, VSK_VSL_SKD B, VSK_CNL_VNDR C" ).append("\n"); 
		query.append("					            WHERE   PSO_BZTP_CD    = '5'" ).append("\n"); 
		query.append("					            AND     EXPN_YRMON     = REPLACE(@[revyrmon],'-', '')" ).append("\n"); 
		query.append("					            AND     A.VSL_CD       = B.VSL_CD " ).append("\n"); 
		query.append("					            AND     A.SKD_VOY_NO   = B.SKD_VOY_NO" ).append("\n"); 
		query.append("					            AND     A.SKD_DIR_CD   = B.SKD_DIR_CD" ).append("\n"); 
		query.append("								AND 	A.BUD_SCNR_NO  = '999912'" ).append("\n"); 
		query.append("					            AND     B.VSL_SLAN_CD  = C.VSL_SLAN_CD      " ).append("\n"); 
		query.append("					            AND     C.CNL_AGN_VNDR_SEQ = @[vndr_seq]             " ).append("\n"); 
		query.append("					            UNION ALL" ).append("\n"); 
		query.append("					            SELECT 5 PSO_BZTP_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, YD_CD" ).append("\n"); 
		query.append("					            FROM    PSO_CNL_TZ_FEE" ).append("\n"); 
		query.append("					            WHERE   PSO_BZTP_CD = '5'" ).append("\n"); 
		query.append("								AND 	BUD_SCNR_NO = '999912'" ).append("\n"); 
		query.append("							    AND		VNDR_SEQ    = @[vndr_seq]" ).append("\n"); 
		query.append("					            AND     NTC_YRMON   = REPLACE(@[revyrmon],'-', '')" ).append("\n"); 
		query.append("					         )        " ).append("\n"); 
		query.append("					    GROUP BY PSO_BZTP_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, YD_CD" ).append("\n"); 
		query.append("					) A" ).append("\n"); 
		query.append("		) A    " ).append("\n"); 
		query.append("WHERE TRNS_DT IS NOT NULL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT	''," ).append("\n"); 
		query.append("		''," ).append("\n"); 
		query.append("		''," ).append("\n"); 
		query.append("		''," ).append("\n"); 
		query.append("		''," ).append("\n"); 
		query.append("		''," ).append("\n"); 
		query.append("		''," ).append("\n"); 
		query.append("		''," ).append("\n"); 
		query.append("		''," ).append("\n"); 
		query.append("		''," ).append("\n"); 
		query.append("		''," ).append("\n"); 
		query.append("		''," ).append("\n"); 
		query.append("		''," ).append("\n"); 
		query.append("		NVL(" ).append("\n"); 
		query.append("		(SELECT DECODE(PSO_MSA_STS_CD, 'R', '0', 'Q', '1', 'A', '2', '0')||'1' " ).append("\n"); 
		query.append("		   FROM PSO_MSA" ).append("\n"); 
		query.append("          WHERE REV_YRMON = REPLACE(@[revyrmon], '-', '')" ).append("\n"); 
		query.append("            AND VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("        ),'01')  MSA,  " ).append("\n"); 
		query.append("        ''," ).append("\n"); 
		query.append("		0," ).append("\n"); 
		query.append("		0," ).append("\n"); 
		query.append("		''," ).append("\n"); 
		query.append("  		''," ).append("\n"); 
		query.append("  		''," ).append("\n"); 
		query.append("  		@[vndr_seq] VNDR_SEQ ," ).append("\n"); 
		query.append("  		'' VSL_SLAN_CD		" ).append("\n"); 
		query.append("  		, (SELECT  max(VNDR_CNT_CD)" ).append("\n"); 
		query.append("		  FROM    MDM_VENDOR" ).append("\n"); 
		query.append("		  WHERE   VNDR_SEQ      = @[vndr_seq]" ).append("\n"); 
		query.append("		  ) VNDR_CNT_CD	," ).append("\n"); 
		query.append("        ''" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("ORDER BY TRNS_DT" ).append("\n"); 

	}
}
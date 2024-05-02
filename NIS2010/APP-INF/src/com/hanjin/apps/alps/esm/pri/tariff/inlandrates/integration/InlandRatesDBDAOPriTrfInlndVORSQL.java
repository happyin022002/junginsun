/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : InlandRatesDBDAOPriTrfInlndVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.04
*@LastModifier : 전윤주
*@LastVersion : 1.0
* 2011.01.04 전윤주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.inlandrates.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeon Yun Joo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandRatesDBDAOPriTrfInlndVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Inland 리스트 조회
	  * </pre>
	  */
	public InlandRatesDBDAOPriTrfInlndVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_inlnd_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_pfx_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.inlandrates.integration").append("\n"); 
		query.append("FileName : InlandRatesDBDAOPriTrfInlndVORSQL").append("\n"); 
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
		query.append("WITH MAX_AMEND_INLND AS (" ).append("\n"); 
		query.append("	SELECT TRF_INLND_SEQ, MAX(AMDT_SEQ) AMDT_SEQ" ).append("\n"); 
		query.append("	  FROM PRI_TRF_INLND" ).append("\n"); 
		query.append("	 WHERE TRF_PFX_CD 	= @[trf_pfx_cd]" ).append("\n"); 
		query.append("	   AND TRF_NO 		= @[trf_no]" ).append("\n"); 
		query.append("	 GROUP BY TRF_INLND_SEQ" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("OFC_TP AS (" ).append("\n"); 
		query.append("    SELECT OFC_TP_CD" ).append("\n"); 
		query.append("      FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("     WHERE OFC_CD = @[rqst_ofc_cd]" ).append("\n"); 
		query.append("       AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT T.TRF_PFX_CD" ).append("\n"); 
		query.append("	 , T.TRF_NO" ).append("\n"); 
		query.append("	 , T.TRF_INLND_SEQ" ).append("\n"); 
		query.append("	 , T.TRF_INLND_AMDT_TP_CD" ).append("\n"); 
		query.append("	 , T.AMDT_SEQ" ).append("\n"); 
		query.append("	 , T.TRF_INLND_NM" ).append("\n"); 
		query.append("	 , T.EFF_DT" ).append("\n"); 
		query.append("	 , T.EXP_DT" ).append("\n"); 
		query.append("	 , T.RQST_OFC_CD" ).append("\n"); 
		query.append("	 , T.APRO_OFC_CD" ).append("\n"); 
		query.append("	 , T.TRF_INLND_STS_CD" ).append("\n"); 
		query.append("	 , T.TRF_INLND_STS_NM" ).append("\n"); 
		query.append("	 , T.CRE_USR_ID" ).append("\n"); 
		query.append("	 , T.CRE_DT" ).append("\n"); 
		query.append("	 , T.UPD_USR_ID" ).append("\n"); 
		query.append("	 , T.UPD_DT" ).append("\n"); 
		query.append("	 , T.PUB_DT" ).append("\n"); 
		query.append("	 , T.BEF_PUB_DT" ).append("\n"); 
		query.append("	 , T.ATCH_FILE_ID" ).append("\n"); 
		query.append("	 , T.ATCH_FILE_NM" ).append("\n"); 
		query.append("	 , CASE WHEN T.TMP_APRO_OFC_CD = T.APRO_OFC_CD THEN 'Y'" ).append("\n"); 
		query.append("		    ELSE 'N' END AS APRO_FLG" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT A.TRF_PFX_CD" ).append("\n"); 
		query.append("		 , A.TRF_NO" ).append("\n"); 
		query.append("		 , A.TRF_INLND_SEQ" ).append("\n"); 
		query.append("		 , A.TRF_INLND_AMDT_TP_CD" ).append("\n"); 
		query.append("		 , A.AMDT_SEQ" ).append("\n"); 
		query.append("		 , A.TRF_INLND_NM" ).append("\n"); 
		query.append("		 , TO_CHAR(A.EFF_DT, 'YYYYMMDD') EFF_DT" ).append("\n"); 
		query.append("		 , TO_CHAR(A.EXP_DT, 'YYYYMMDD') EXP_DT" ).append("\n"); 
		query.append("		 , A.RQST_OFC_CD" ).append("\n"); 
		query.append("		 , A.APRO_OFC_CD" ).append("\n"); 
		query.append("		 , A.TRF_INLND_STS_CD" ).append("\n"); 
		query.append("		 , (SELECT INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("			  FROM COM_INTG_CD_DTL " ).append("\n"); 
		query.append("			 WHERE INTG_CD_ID = 'CD02395' " ).append("\n"); 
		query.append("			   AND INTG_CD_VAL_CTNT = A.TRF_INLND_STS_CD) TRF_INLND_STS_NM" ).append("\n"); 
		query.append("		 , A.CRE_USR_ID" ).append("\n"); 
		query.append("		 , TO_CHAR(A.CRE_DT, 'YYYYMMDD') CRE_DT" ).append("\n"); 
		query.append("		 , A.UPD_USR_ID" ).append("\n"); 
		query.append("		 , TO_CHAR(A.UPD_DT, 'YYYYMMDD-HH24MISS') UPD_DT" ).append("\n"); 
		query.append("		 , TO_CHAR(A.PUB_DT, 'YYYYMMDD') PUB_DT" ).append("\n"); 
		query.append("		 , ( SELECT TO_CHAR(PUB_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("			   FROM PRI_TRF_INLND " ).append("\n"); 
		query.append("			  WHERE TRF_PFX_CD 		= @[trf_pfx_cd]" ).append("\n"); 
		query.append("				AND TRF_NO 			= @[trf_no]" ).append("\n"); 
		query.append("				AND AMDT_SEQ 		= B.AMDT_SEQ - 1 " ).append("\n"); 
		query.append("				AND TRF_INLND_SEQ 	= B.TRF_INLND_SEQ ) BEF_PUB_DT" ).append("\n"); 
		query.append("		 , A.ATCH_FILE_ID" ).append("\n"); 
		query.append("		 , (SELECT FILE_UPLD_NM " ).append("\n"); 
		query.append("			  FROM COM_UPLD_FILE " ).append("\n"); 
		query.append("			 WHERE FILE_SAV_ID = A.ATCH_FILE_ID " ).append("\n"); 
		query.append("			   AND DELT_FLG = 'N') ATCH_FILE_NM" ).append("\n"); 
		query.append("		 , CASE WHEN C.OFC_TP_CD = 'QT' THEN @[apro_ofc_cd]				" ).append("\n"); 
		query.append("				ELSE @[rqst_ofc_cd]" ).append("\n"); 
		query.append("            END AS TMP_APRO_OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	  FROM PRI_TRF_INLND A, MAX_AMEND_INLND B, OFC_TP C" ).append("\n"); 
		query.append("	 WHERE A.TRF_PFX_CD 	= @[trf_pfx_cd]" ).append("\n"); 
		query.append("	   AND A.TRF_NO 		= @[trf_no]" ).append("\n"); 
		query.append("	   AND A.TRF_INLND_SEQ	= @[trf_inlnd_seq]" ).append("\n"); 
		query.append("	   AND B.AMDT_SEQ 		= A.AMDT_SEQ" ).append("\n"); 
		query.append("	   AND B.TRF_INLND_SEQ 	= A.TRF_INLND_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     ) T" ).append("\n"); 
		query.append(" ORDER BY T.TRF_INLND_SEQ" ).append("\n"); 

	}
}
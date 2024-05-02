/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOSearchInterfaceStatusListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOConsultationDBDAOSearchInterfaceStatusListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Interface Status
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOSearchInterfaceStatusListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_duration",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fr_duration",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration").append("\n"); 
		query.append("FileName : TCharterIOConsultationDBDAOSearchInterfaceStatusListVORSQL").append("\n"); 
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
		query.append("SELECT 	AH.CSR_NO, " ).append("\n"); 
		query.append("		AH.VNDR_NO VNDR_SEQ," ).append("\n"); 
		query.append("		(SELECT VNDR_CNT_CD FROM MDM_VENDOR WHERE VNDR_SEQ = AH.VNDR_NO) VNDR_CNT_CD, " ).append("\n"); 
		query.append("		AH.GL_DT EFF_DT, AH.CSR_CURR_CD, AH.CSR_AMT, AH.INV_DESC CSR_DESC" ).append("\n"); 
		query.append("#if (${condition} == 'E')" ).append("\n"); 
		query.append("        , AH.IF_ERR_RSN" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("        , AH.RCV_ERR_RSN IF_ERR_RSN" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM 	AP_INV_HDR AH " ).append("\n"); 
		query.append("WHERE   EXISTS (SELECT 	NULL " ).append("\n"); 
		query.append("				FROM 	FMS_CONSULTATION FI" ).append("\n"); 
		query.append("				WHERE   SUBSTR(AH.CSR_NO,1,2)  = FI.SLP_TP_CD" ).append("\n"); 
		query.append("				AND		SUBSTR(AH.CSR_NO,3,1)  = FI.SLP_FUNC_CD" ).append("\n"); 
		query.append("				AND		SUBSTR(AH.CSR_NO,4,6)  = FI.SLP_OFC_CD" ).append("\n"); 
		query.append("				AND		SUBSTR(AH.CSR_NO,10,6) = FI.SLP_ISS_DT" ).append("\n"); 
		query.append("				AND		SUBSTR(AH.CSR_NO,16,5) = FI.SLP_SER_NO" ).append("\n"); 
		query.append("				AND     FI.APRO_FLG = 'Y'" ).append("\n"); 
		query.append("                AND     NVL(FI.AP_CXL_FLG, 'N') = 'N')" ).append("\n"); 
		query.append("#if (${condition} == 'E') " ).append("\n"); 
		query.append("	AND 	AH.IF_FLG = 'E'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	AND 	AH.IF_FLG = 'Y' AND AH.RCV_ERR_FLG = 'E'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND AH.SRC_CTNT = 'CDAM'" ).append("\n"); 
		query.append("--PDT 승인 결재로 인하여 삭제 민정호(201407)" ).append("\n"); 
		query.append("--AND AH.TJ_OFC_CD  = slp_ofc_cd" ).append("\n"); 
		query.append("#if (${search_csr_no} != '') " ).append("\n"); 
		query.append("	AND		AH.CSR_NO LIKE @[search_csr_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fr_duration} != '') " ).append("\n"); 
		query.append("	AND 	AH.GL_DT >= REPLACE(@[fr_duration],'-','')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${to_duration} != '') " ).append("\n"); 
		query.append("	AND 	AH.GL_DT <= REPLACE(@[to_duration],'-','')" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
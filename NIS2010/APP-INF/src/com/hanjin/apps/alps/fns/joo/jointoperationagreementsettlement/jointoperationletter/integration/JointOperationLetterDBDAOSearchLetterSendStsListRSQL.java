/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JointOperationLetterDBDAOSearchLetterSendStsListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.11
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.03.11 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationLetterDBDAOSearchLetterSendStsListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public JointOperationLetterDBDAOSearchLetterSendStsListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ltr_iss_dt_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ltr_iss_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.integration").append("\n"); 
		query.append("FileName : JointOperationLetterDBDAOSearchLetterSendStsListRSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("A.JO_LTR_SEQ                         ," ).append("\n"); 
		query.append("CASE WHEN A.JO_LTR_TP_CD='M' THEN 'MCS'" ).append("\n"); 
		query.append("WHEN A.JO_LTR_TP_CD='I' THEN 'Invoice' END JO_LTR_TP_CD," ).append("\n"); 
		query.append("A.TRD_CD                             ," ).append("\n"); 
		query.append("A.OFC_CD                             ," ).append("\n"); 
		query.append("A.LTR_ISS_DT                         ," ).append("\n"); 
		query.append("A.LTR_RCVR_CO_NM                     ," ).append("\n"); 
		query.append("A.LTR_RCVR_CNTC_PSON_NM              ," ).append("\n"); 
		query.append("A.LTR_CC_RCVR_CNTC_PSON_NM_CTNT      ," ).append("\n"); 
		query.append("A.LTR_SNDR_CO_NM                     ," ).append("\n"); 
		query.append("A.SNDR_NM                            ," ).append("\n"); 
		query.append("A.LTR_TIT_CTNT                       ," ).append("\n"); 
		query.append("A.TTL_STL_AMT                        ," ).append("\n"); 
		query.append("A.JO_SND_MZD_CD                      ," ).append("\n"); 
		query.append("A.JO_LTR_NO                          ," ).append("\n"); 
		query.append("A.OFC_ADDR                           ," ).append("\n"); 
		query.append("A.N1ST_STMT_CTNT                     ," ).append("\n"); 
		query.append("A.N2ND_STMT_CTNT                     ," ).append("\n"); 
		query.append("A.N3RD_STMT_CTNT                     ," ).append("\n"); 
		query.append("A.SIG_STMT_CTNT                      ," ).append("\n"); 
		query.append("(SELECT S1.ACCT_YRMON    FROM JOO_LTR_STL S1 WHERE S1.JO_LTR_SEQ= A.JO_LTR_SEQ AND ROWNUM=1)ACCT_YRMON," ).append("\n"); 
		query.append("(SELECT S1.JO_CRR_CD     FROM JOO_LTR_STL S1 WHERE S1.JO_LTR_SEQ= A.JO_LTR_SEQ AND ROWNUM=1)JO_CRR_CD," ).append("\n"); 
		query.append("''STL_CMB_SEQ                        ," ).append("\n"); 
		query.append("A.SNDR_EML                           ," ).append("\n"); 
		query.append("CASE WHEN A.EML_SND_NO  IS NOT NULL  THEN  A.RCVR_EML ELSE  '' END   RCVR_EML," ).append("\n"); 
		query.append("A.CC_RCVR_EML_CTNT                   ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("A.EML_SND_NO                         ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("(SELECT   CASE WHEN S1.EML_PROC_STS_CD NOT IN (3,4)  OR S1.EML_PROC_STS_CD IS NULL THEN 'Waiting'" ).append("\n"); 
		query.append("WHEN S1.EML_PROC_STS_CD = 3 THEN 'Completed'" ).append("\n"); 
		query.append("WHEN S1.EML_PROC_STS_CD = 4 THEN 'Failed' END EML_PROC_STS_CD" ).append("\n"); 
		query.append("FROM   COM_EML_SND_INFO S1 WHERE S1.EML_SND_NO =  A.EML_SND_NO)EML_PROC_STS_CD," ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("TO_CHAR(S1.CRE_DT,'yyyy-MM-dd hh24:mi')" ).append("\n"); 
		query.append("FROM   COM_EML_SND_INFO S1 WHERE S1.EML_SND_NO =  A.EML_SND_NO)EML_DT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("(SELECT   CASE WHEN S1.FAX_PROC_STS_CD   IN (1,2) OR  S1.FAX_PROC_STS_CD IS NULL THEN 'Waiting'" ).append("\n"); 
		query.append("WHEN S1.FAX_PROC_STS_CD = 3 THEN 'Processing'" ).append("\n"); 
		query.append("WHEN S1.FAX_PROC_STS_CD = 4 THEN 'Sending'" ).append("\n"); 
		query.append("WHEN S1.FAX_PROC_STS_CD = 5 THEN 'Completed'" ).append("\n"); 
		query.append("WHEN S1.FAX_PROC_STS_CD = 6 THEN 'Failed'" ).append("\n"); 
		query.append("END FAX_PROC_STS_CD" ).append("\n"); 
		query.append("FROM   COM_FAX_SND_INFO S1 WHERE S1.FAX_SND_NO =  A.FAX_SND_NO)FAX_PROC_STS_CD," ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("TO_CHAR(S1.CRE_DT,'yyyy-MM-dd hh24:mi')" ).append("\n"); 
		query.append("FROM   COM_FAX_SND_INFO S1 WHERE S1.FAX_SND_NO =  A.FAX_SND_NO)FAX_DT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("CASE WHEN  A.FAX_SND_NO IS NOT NULL  THEN  A.JO_CNTC_FAX_NO_CTNT ELSE  NULL END  JO_CNTC_FAX_NO_CTNT ," ).append("\n"); 
		query.append("A.RCVR_INFO_CTNT                     ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("A.FAX_SND_NO                         ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("A.DELT_FLG                           ," ).append("\n"); 
		query.append("A.CRE_DT                             ," ).append("\n"); 
		query.append("A.CRE_USR_ID                         ," ).append("\n"); 
		query.append("A.UPD_DT                             ," ).append("\n"); 
		query.append("NVL((SELECT 'Y' FROM JOO_LTR_ATCH_FILE S3 WHERE S3.JO_LTR_SEQ = A.JO_LTR_SEQ AND ROWNUM=1), 'N')  UPD_USR_ID" ).append("\n"); 
		query.append("FROM  JOO_LETTER A" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("#if (${ofc_cd} != '')" ).append("\n"); 
		query.append("AND A.OFC_CD =  @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cre_usr_id} != '')" ).append("\n"); 
		query.append("AND A.CRE_USR_ID =  @[cre_usr_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ltr_iss_dt_fr} != '')" ).append("\n"); 
		query.append("AND A.LTR_ISS_DT  >= TO_DATE(  REPLACE(@[ltr_iss_dt_fr], '-', ''), 'YYYYMMDD' )" ).append("\n"); 
		query.append("AND A.LTR_ISS_DT  <  TO_DATE(  REPLACE(@[ltr_iss_dt_to], '-', ''), 'YYYYMMDD' )+1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.CRE_USR_ID, A.CRE_DT DESC" ).append("\n"); 

	}
}
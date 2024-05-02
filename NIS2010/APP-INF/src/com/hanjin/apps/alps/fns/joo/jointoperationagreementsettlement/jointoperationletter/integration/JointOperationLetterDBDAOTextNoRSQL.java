/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationLetterDBDAOTextNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.30
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.12.30 장강철
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

public class JointOperationLetterDBDAOTextNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public JointOperationLetterDBDAOTextNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_ltr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.integration").append("\n"); 
		query.append("FileName : JointOperationLetterDBDAOTextNoRSQL").append("\n"); 
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
		query.append("A.JO_LTR_SEQ                         ," ).append("\n"); 
		query.append("A.JO_LTR_TP_CD                       ," ).append("\n"); 
		query.append("A.TRD_CD                             ," ).append("\n"); 
		query.append("A.OFC_CD                             ," ).append("\n"); 
		query.append("A.LTR_ISS_DT                         ," ).append("\n"); 
		query.append("A.LTR_RCVR_CO_NM                     ," ).append("\n"); 
		query.append("A.LTR_RCVR_CNTC_PSON_NM              ," ).append("\n"); 
		query.append("A.LTR_CC_RCVR_CNTC_PSON_NM           ," ).append("\n"); 
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
		query.append("A.RCVR_EML                           ," ).append("\n"); 
		query.append("A.CC_RCVR_EML                        ," ).append("\n"); 
		query.append("A.EML_PROC_STS_CD                    ," ).append("\n"); 
		query.append("A.EML_SND_NO                         ," ).append("\n"); 
		query.append("A.EML_DT                             ," ).append("\n"); 
		query.append("A.JO_CNTC_FAX_NO                     ," ).append("\n"); 
		query.append("A.RCVR_INFO_CTNT                     ," ).append("\n"); 
		query.append("A.FAX_PROC_STS_CD                    ," ).append("\n"); 
		query.append("A.FAX_SND_NO                         ," ).append("\n"); 
		query.append("A.FAX_DT                             ," ).append("\n"); 
		query.append("A.DELT_FLG                           ," ).append("\n"); 
		query.append("A.CRE_DT                             ," ).append("\n"); 
		query.append("A.CRE_USR_ID                         ," ).append("\n"); 
		query.append("A.UPD_DT                             ," ).append("\n"); 
		query.append("A.UPD_USR_ID                         ," ).append("\n"); 
		query.append("A.JOINT_OPERATION_LETTER_TEMPLAT" ).append("\n"); 
		query.append("FROM  JOO_LETTER A" ).append("\n"); 
		query.append("WHERE   A.JO_LTR_SEQ = @[jo_ltr_seq]" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationLetterDBDAOSearchMcsLetterRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.10.16 장강철
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

public class JointOperationLetterDBDAOSearchMcsLetterRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public JointOperationLetterDBDAOSearchMcsLetterRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_tmplt_no",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_ltr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.integration").append("\n"); 
		query.append("FileName : JointOperationLetterDBDAOSearchMcsLetterRSQL").append("\n"); 
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
		query.append("SELECT      JO_LTR_TMPLT_SEQ ," ).append("\n"); 
		query.append("OFC_CD                         ," ).append("\n"); 
		query.append("JO_TMPLT_NO                    ," ).append("\n"); 
		query.append("JO_LTR_TP_CD                   ," ).append("\n"); 
		query.append("OFC_ADDR                       ," ).append("\n"); 
		query.append("N1ST_STMT_CTNT                 ," ).append("\n"); 
		query.append("N2ND_STMT_CTNT                 ," ).append("\n"); 
		query.append("N3RD_STMT_CTNT                 ," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT S.BANK_STMT_CTNT --," ).append("\n"); 
		query.append("FROM JOO_LTR_TMPLT S" ).append("\n"); 
		query.append("WHERE S.JO_LTR_TMPLT_SEQ = (" ).append("\n"); 
		query.append("SELECT /*+ index_desc( A  XPKJOO_LTR_TMPLT) */" ).append("\n"); 
		query.append("JO_LTR_TMPLT_SEQ" ).append("\n"); 
		query.append("FROM JOO_LTR_TMPLT A" ).append("\n"); 
		query.append("WHERE OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND JO_LTR_TP_CD = 'B'" ).append("\n"); 
		query.append("AND ROWNUM=1))BANK_STMT_CTNT," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT S.SIG_STMT_CTNT" ).append("\n"); 
		query.append("FROM JOO_LTR_TMPLT S" ).append("\n"); 
		query.append("WHERE S.JO_LTR_TMPLT_SEQ = (" ).append("\n"); 
		query.append("SELECT /*+ index_desc( A  XPKJOO_LTR_TMPLT) */" ).append("\n"); 
		query.append("JO_LTR_TMPLT_SEQ" ).append("\n"); 
		query.append("FROM JOO_LTR_TMPLT A" ).append("\n"); 
		query.append("WHERE OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND JO_LTR_TP_CD = 'B'" ).append("\n"); 
		query.append("AND ROWNUM=1))SIG_STMT_CTNT," ).append("\n"); 
		query.append("CRE_DT                         ," ).append("\n"); 
		query.append("CRE_USR_ID                     ," ).append("\n"); 
		query.append("UPD_DT                         ," ).append("\n"); 
		query.append("UPD_USR_ID" ).append("\n"); 
		query.append("FROM   JOO_LTR_TMPLT" ).append("\n"); 
		query.append("WHERE JO_TMPLT_NO  = @[jo_tmplt_no]" ).append("\n"); 
		query.append("AND  JO_LTR_TP_CD = @[jo_ltr_tp_cd]" ).append("\n"); 
		query.append("AND  CRE_USR_ID   = @[cre_usr_id]" ).append("\n"); 

	}
}
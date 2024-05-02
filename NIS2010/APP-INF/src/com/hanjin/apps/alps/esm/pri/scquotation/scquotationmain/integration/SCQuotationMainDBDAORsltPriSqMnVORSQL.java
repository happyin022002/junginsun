/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCQuotationMainDBDAORsltPriSqMnVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.18
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2010.01.18 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seung-Jun,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCQuotationMainDBDAORsltPriSqMnVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public SCQuotationMainDBDAORsltPriSqMnVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.integration").append("\n"); 
		query.append("FileName : SCQuotationMainDBDAORsltPriSqMnVORSQL").append("\n"); 
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
		query.append("B.QTTN_NO" ).append("\n"); 
		query.append(",	B.QTTN_VER_NO" ).append("\n"); 
		query.append(",	TO_CHAR(B.EFF_DT,'YYYY-MM-DD') AS EFF_DT" ).append("\n"); 
		query.append(",	TO_CHAR(B.EXP_DT, 'YYYY-MM-DD') AS EXP_DT" ).append("\n"); 
		query.append(",	B.SVC_SCP_CD" ).append("\n"); 
		query.append(",	B.CUST_CNT_CD" ).append("\n"); 
		query.append(",	DECODE(LENGTH(B.CUST_SEQ),1,'00000' || B.CUST_SEQ," ).append("\n"); 
		query.append("2,'0000' || B.CUST_SEQ," ).append("\n"); 
		query.append("3,'000' || B.CUST_SEQ," ).append("\n"); 
		query.append("4,'00' || B.CUST_SEQ," ).append("\n"); 
		query.append("5,'0' || B.CUST_SEQ," ).append("\n"); 
		query.append("6,B.CUST_SEQ) AS CUST_SEQ" ).append("\n"); 
		query.append(",	(SELECT CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER" ).append("\n"); 
		query.append("WHERE CUST_CNT_CD   = B.CUST_CNT_CD" ).append("\n"); 
		query.append("AND   CUST_SEQ      = B.CUST_SEQ" ).append("\n"); 
		query.append("AND   DELT_FLG		= 'N') AS CUST_NM" ).append("\n"); 
		query.append(",	B.CNTR_LOD_UT_CD" ).append("\n"); 
		query.append(",	NVL(B.ESTM_MQC_QTY,1) AS ESTM_MQC_QTY" ).append("\n"); 
		query.append(",	TO_NUMBER(ROUND(NVL(B.ESTM_CM_AMT,0),0)) AS ESTM_CM_AMT" ).append("\n"); 
		query.append("--,	TO_CHAR(NVL(B.ESTM_MQC_QTY,0),'999,999,999') AS ESTM_MQC_QTY" ).append("\n"); 
		query.append("--,	TO_CHAR(NVL(B.ESTM_CM_AMT,0),'999,999,999.99') AS ESTM_CM_AMT" ).append("\n"); 
		query.append(",	B.PRC_CUST_TP_CD" ).append("\n"); 
		query.append(",	B.QTTN_SREP_CD" ).append("\n"); 
		query.append(",	B.PROP_NO" ).append("\n"); 
		query.append(",	B.PRS_XCH_RT_YRMON" ).append("\n"); 
		query.append(",	A.QTTN_OFC_CD" ).append("\n"); 
		query.append(",	A.QTTN_STS_CD" ).append("\n"); 
		query.append(",   (SELECT INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("FROM   COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE  INTG_CD_ID = 'CD02195'" ).append("\n"); 
		query.append("AND    INTG_CD_VAL_CTNT = A.QTTN_STS_CD) AS QTTN_STS_NM              --QUOTATION 상태명" ).append("\n"); 
		query.append(",	B.CRE_USR_ID" ).append("\n"); 
		query.append(",	TO_CHAR(B.CRE_DT, 'YYYY-MM-DD') AS CRE_DT" ).append("\n"); 
		query.append(",	B.UPD_USR_ID" ).append("\n"); 
		query.append(",	B.UPD_DT" ).append("\n"); 
		query.append(",	DECODE(NVL(B.PROP_NO,''),'','No','Yes') AS ISCOPY" ).append("\n"); 
		query.append(",	'' AS QTTN_NO_HIDDEN" ).append("\n"); 
		query.append(",	'' AS QTTN_VER_NO_HIDDEN" ).append("\n"); 
		query.append(",	(SELECT SREP_NM" ).append("\n"); 
		query.append("FROM MDM_SLS_REP" ).append("\n"); 
		query.append("WHERE SREP_CD   = B.QTTN_SREP_CD) AS QTTN_SREP_NM" ).append("\n"); 
		query.append(",	(SELECT SVC_SCP_NM" ).append("\n"); 
		query.append("FROM MDM_SVC_SCP" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD   = B.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   DELT_FLG	= 'N') AS SVC_SCP_NM" ).append("\n"); 
		query.append(",	'' AS CRE_DT_FROM" ).append("\n"); 
		query.append(",	'' AS CRE_DT_TO" ).append("\n"); 
		query.append(",	'' AS QTTN_NO_READ" ).append("\n"); 
		query.append(",	'' AS QTTN_VER_NO_READ" ).append("\n"); 
		query.append(",	'' AS QTTN_STATUS" ).append("\n"); 
		query.append("FROM PRI_SQ_HDR A" ).append("\n"); 
		query.append(",	 PRI_SQ_MN B" ).append("\n"); 
		query.append("WHERE	B.QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("#if (${qttn_ver_no} != '')" ).append("\n"); 
		query.append("AND	B.QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND	A.QTTN_NO = B.QTTN_NO" ).append("\n"); 
		query.append("ORDER BY B.QTTN_VER_NO DESC" ).append("\n"); 

	}
}
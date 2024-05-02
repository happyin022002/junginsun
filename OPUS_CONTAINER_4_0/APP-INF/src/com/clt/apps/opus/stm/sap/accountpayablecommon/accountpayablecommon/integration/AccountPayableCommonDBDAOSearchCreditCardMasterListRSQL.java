/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableCommonDBDAOSearchCreditCardMasterListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.13
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableCommonDBDAOSearchCreditCardMasterListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * STM_SAP_0310 - Inquiry by card no. & card seq.
	  * </pre>
	  */
	public AccountPayableCommonDBDAOSearchCreditCardMasterListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crd_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration").append("\n"); 
		query.append("FileName : AccountPayableCommonDBDAOSearchCreditCardMasterListRSQL").append("\n"); 
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
		query.append("SELECT  SCM.CRD_SEQ                            AS CRD_SEQ" ).append("\n"); 
		query.append("      , SCM.CRD_NO                             AS CRD_NO" ).append("\n"); 
		query.append("      , SCM.CRD_PGM_NM                         AS CRD_PGM_NM" ).append("\n"); 
		query.append("      , SCM.CRD_PGM_CD                         AS CRD_PGM_CD" ).append("\n"); 
		query.append("      , SCM.CRD_TP_LU_CD                       AS CRD_TP_LU_CD" ).append("\n"); 
		query.append("      , SCM.CRD_PGM_CURR_CD                    AS CRD_PGM_CURR_CD" ).append("\n"); 
		query.append("      , SCM.CRD_VNDR_NO                        AS VNDR_NO" ).append("\n"); 
		query.append("      , (SELECT MV.VNDR_LGL_ENG_NM  " ).append("\n"); 
		query.append("         FROM  MDM_VENDOR MV" ).append("\n"); 
		query.append("         WHERE MV.VNDR_SEQ = SCM.CRD_VNDR_NO ) AS VNDR_NM" ).append("\n"); 
		query.append("      , SCM.CRD_BRND_LU_CD                     AS CRD_BRND_LU_CD" ).append("\n"); 
		query.append("      , SCM.CRD_CD_CMB_SEQ                     AS CRD_CD_CMB_SEQ" ).append("\n"); 
		query.append("      , SLCC.SGM_CTNT1                         AS COA_CO_CD" ).append("\n"); 
		query.append("      , SLCC.SGM_CTNT2                         AS COA_RGN_CD" ).append("\n"); 
		query.append("      , SLCC.SGM_CTNT3                         AS COA_CTR_CD" ).append("\n"); 
		query.append("      , SLCC.SGM_CTNT4                         AS COA_ACCT_CD" ).append("\n"); 
		query.append("      , SLCC.SGM_CTNT5                         AS COA_INTER_CO_CD" ).append("\n"); 
		query.append("      , SLCC.SGM_CTNT6                         AS COA_VVD_CD" ).append("\n"); 
		query.append("      , SCM.CRD_MBR_NM                         AS CRD_MBR_NM" ).append("\n"); 
		query.append("      , SCM.CRD_DEPT_NM                        AS CRD_DEPT_NM" ).append("\n"); 
		query.append("      , SCM.CRD_DTRB_OFC_CD                    AS CRD_DTRB_OFC_CD" ).append("\n"); 
		query.append("      , TO_CHAR(SCM.CRD_DTRB_DT,'YYYY-MM-DD')  AS CRD_DTRB_DT" ).append("\n"); 
		query.append("      , TO_CHAR(SCM.CRD_INACT_DT,'YYYY-MM-DD') AS CRD_INACT_DT" ).append("\n"); 
		query.append("      , TO_CHAR(SCM.CRD_EXP_DT,'YYYY-MM-DD')   AS CRD_EXP_DT      " ).append("\n"); 
		query.append("      , SCM.CRD_DESC                           AS CRD_DESC" ).append("\n"); 
		query.append("	  , SCM.CRD_EMPE_NO                        AS CRD_EMPE_NO" ).append("\n"); 
		query.append("      , SCM.CRE_USR_ID                         AS USR_ID" ).append("\n"); 
		query.append("FROM    SAP_CRD_MST SCM" ).append("\n"); 
		query.append("      , SCO_LEGR_CD_CMB SLCC" ).append("\n"); 
		query.append("WHERE   SCM.CRD_CD_CMB_SEQ = SLCC.CD_CMB_SEQ(+)" ).append("\n"); 
		query.append("AND     SCM.CRD_NO = REPLACE(@[crd_no], '-', '')" ).append("\n"); 

	}
}
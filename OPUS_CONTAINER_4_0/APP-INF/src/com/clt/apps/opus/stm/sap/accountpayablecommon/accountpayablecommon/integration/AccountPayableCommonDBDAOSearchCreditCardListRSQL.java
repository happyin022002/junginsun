/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableCommonDBDAOSearchCreditCardListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.14
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.14 
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

public class AccountPayableCommonDBDAOSearchCreditCardListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreditCardList Popup
	  * </pre>
	  */
	public AccountPayableCommonDBDAOSearchCreditCardListRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crd_mbr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crd_dtrb_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crd_pgm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crd_pgm_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration").append("\n"); 
		query.append("FileName : AccountPayableCommonDBDAOSearchCreditCardListRSQL").append("\n"); 
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
		query.append("      , SCM.CRD_PGM_CURR_CD                    AS CRD_PGM_CURR_CD" ).append("\n"); 
		query.append("      , SCM.CRD_BRND_LU_CD                     AS CRD_BRND_LU_CD" ).append("\n"); 
		query.append("      , SCM.CRD_MBR_NM                         AS CRD_MBR_NM" ).append("\n"); 
		query.append("      , SCM.CRD_DEPT_NM                        AS CRD_DEPT_NM" ).append("\n"); 
		query.append("      , TO_CHAR(SCM.CRD_DTRB_DT,'YYYY-MM-DD')  AS CRD_DTRB_DT" ).append("\n"); 
		query.append("      , SCM.CRD_DTRB_OFC_CD                    AS CRD_DTRB_OFC_CD" ).append("\n"); 
		query.append("      , TO_CHAR(SCM.CRD_INACT_DT,'YYYY-MM-DD') AS CRD_INACT_DT" ).append("\n"); 
		query.append("      , SCM.CRD_TP_LU_CD                       AS CRD_TP_LU_CD" ).append("\n"); 
		query.append("      , SCM.CRD_VNDR_NO 					   AS VNDR_NO" ).append("\n"); 
		query.append("      ,  (SELECT MV.VNDR_LGL_ENG_NM  " ).append("\n"); 
		query.append("         FROM  MDM_VENDOR MV" ).append("\n"); 
		query.append("         WHERE MV.VNDR_SEQ = SCM.CRD_VNDR_NO ) AS VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("      , SCM.CRD_CD_CMB_SEQ                     AS CRD_CD_CMB_SEQ" ).append("\n"); 
		query.append("      , SLCC.SGM_CTNT1                         AS COMPANY_CODE" ).append("\n"); 
		query.append("      , SLCC.SGM_CTNT2                         AS REGION_CODE" ).append("\n"); 
		query.append("      , SLCC.SGM_CTNT3                         AS CENTER_CODE" ).append("\n"); 
		query.append("      , SLCC.SGM_CTNT4                         AS ACCOUNT_CODE" ).append("\n"); 
		query.append("      , SLCC.SGM_CTNT5                         AS INTERCOMPANYCODE" ).append("\n"); 
		query.append("      , SLCC.SGM_CTNT6                         AS VVDCODE" ).append("\n"); 
		query.append("      , SCM.CRD_DESC                           AS CRD_DESC" ).append("\n"); 
		query.append("      , TO_CHAR(SCM.CRD_EXP_DT,'YYYY-MM-DD')   AS CRD_EXP_DT" ).append("\n"); 
		query.append("FROM    SAP_CRD_MST SCM" ).append("\n"); 
		query.append("      , SCO_LEGR_CD_CMB SLCC" ).append("\n"); 
		query.append("WHERE   SCM.CRD_CD_CMB_SEQ = SLCC.CD_CMB_SEQ(+)" ).append("\n"); 
		query.append("#if     (${crd_no} != '')" ).append("\n"); 
		query.append("AND     SCM.CRD_NO LIKE @[crd_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if     (${crd_pgm_nm} != '')" ).append("\n"); 
		query.append("AND     SCM.CRD_PGM_NM LIKE @[crd_pgm_nm]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if     (${crd_pgm_cd} != '')" ).append("\n"); 
		query.append("AND     SCM.CRD_PGM_CD = @[crd_pgm_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if     (${crd_mbr_nm} != '')" ).append("\n"); 
		query.append("AND     SCM.CRD_MBR_NM LIKE @[crd_mbr_nm]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if     (${crd_dtrb_ofc_cd} != '')" ).append("\n"); 
		query.append("AND     SCM.CRD_DTRB_OFC_CD = @[crd_dtrb_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
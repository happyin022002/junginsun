/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DODInvoiceMgtDBDAOSearchARInterfaceChargeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.dodinvoicemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DODInvoiceMgtDBDAOSearchARInterfaceChargeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchARInterfaceChargeList
	  * </pre>
	  */
	public DODInvoiceMgtDBDAOSearchARInterfaceChargeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dod_inv_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.dodinvoicemgt.integration").append("\n"); 
		query.append("FileName : DODInvoiceMgtDBDAOSearchARInterfaceChargeListRSQL").append("\n"); 
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
		query.append("SELECT ROWNUM CHG_SEQ" ).append("\n"); 
		query.append("      , CHG_CD" ).append("\n"); 
		query.append("      , CHG_FULL_NM" ).append("\n"); 
		query.append("      , CURR_CD" ).append("\n"); 
		query.append("      , PER_TP_CD                     " ).append("\n"); 
		query.append("      , TRF_RT_AMT        " ).append("\n"); 
		query.append("      , RAT_AS_CNTR_QTY                  " ).append("\n"); 
		query.append("	  , CHG_AMT        " ).append("\n"); 
		query.append("      , 0 AS INV_XCH_RT" ).append("\n"); 
		query.append("      , TVA_FLG" ).append("\n"); 
		query.append("      , REP_CHG_CD                  " ).append("\n"); 
		query.append("      , CHG_RMK          " ).append("\n"); 
		query.append("      , CRE_USR_ID" ).append("\n"); 
		query.append("      , CRE_DT" ).append("\n"); 
		query.append("      , @[cre_usr_id] AS  UPD_USR_ID" ).append("\n"); 
		query.append("      , NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd]),SYSDATE) AS UPD_DT" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("SELECT  'DOD' AS CHG_CD" ).append("\n"); 
		query.append("       ,(SELECT CHG_NM FROM MDM_CHARGE WHERE CHG_CD='DOD') AS CHG_FULL_NM" ).append("\n"); 
		query.append("       , A.BIL_CURR_CD AS CURR_CD" ).append("\n"); 
		query.append("       , A.CNTR_TPSZ_CD AS PER_TP_CD                     " ).append("\n"); 
		query.append("       , (A.BIL_AMT + nvl(A.ADD_AMT,0)) AS TRF_RT_AMT        " ).append("\n"); 
		query.append("       , COUNT(A.CNTR_NO) AS RAT_AS_CNTR_QTY                  " ).append("\n"); 
		query.append("	   , (SELECT SUM(B.BIL_AMT + nvl(B.ADD_AMT,0)) " ).append("\n"); 
		query.append("          FROM EAS_DOD_INV_DTL B " ).append("\n"); 
		query.append("          WHERE B.DOD_INV_NO = A.DOD_INV_NO" ).append("\n"); 
		query.append("          AND B.CNTR_TPSZ_CD = A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("          AND B.BIL_AMT = A.BIL_AMT" ).append("\n"); 
		query.append("          AND nvl(B.ADD_AMT,0) = nvl(A.ADD_AMT,0)" ).append("\n"); 
		query.append("      ) AS CHG_AMT        " ).append("\n"); 
		query.append("       , CASE WHEN SUM(A.TAX_AMT) <> 0 THEN 'Y' ELSE 'N' END AS TVA_FLG" ).append("\n"); 
		query.append("       , (SELECT REP_CHG_CD FROM MDM_CHARGE WHERE CHG_CD='DOD') AS REP_CHG_CD                  " ).append("\n"); 
		query.append("       , 'DOD INVOICE CONTAINER ' AS CHG_RMK          " ).append("\n"); 
		query.append("       , A.CRE_USR_ID" ).append("\n"); 
		query.append("       , A.CRE_DT" ).append("\n"); 
		query.append("FROM   EAS_DOD_INV_DTL A" ).append("\n"); 
		query.append("WHERE DOD_INV_NO = @[dod_inv_no]" ).append("\n"); 
		query.append("GROUP BY A.DOD_INV_NO,A.CNTR_TPSZ_CD,A.BIL_CURR_CD, A.BIL_AMT, A.ADD_AMT, A.CRE_USR_ID, A.CRE_DT" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  'TVA' AS CHG_CD" ).append("\n"); 
		query.append("      , 'V.A.T RECEIVED' AS CHG_FULL_NM" ).append("\n"); 
		query.append("      , A.BIL_CURR_CD AS CURR_CD" ).append("\n"); 
		query.append("      , A.CNTR_TPSZ_CD AS PER_TP_CD " ).append("\n"); 
		query.append("      , A.TAX_AMT AS TRF_RT_AMT" ).append("\n"); 
		query.append("      , COUNT(A.CNTR_NO) AS RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append("       ,(SELECT SUM(B.TAX_AMT) " ).append("\n"); 
		query.append("          FROM EAS_DOD_INV_DTL B " ).append("\n"); 
		query.append("          WHERE B.DOD_INV_NO = A.DOD_INV_NO" ).append("\n"); 
		query.append("          AND B.CNTR_TPSZ_CD = A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("          AND B.TAX_AMT = A.TAX_AMT   )  AS CHG_AMT" ).append("\n"); 
		query.append("       , 'N'  AS TVA_FLG" ).append("\n"); 
		query.append("       , 'XXX' AS REP_CHG_CD" ).append("\n"); 
		query.append("       , 'DOD INVOICE CONTAINER' AS CHG_RMK" ).append("\n"); 
		query.append("       , A.CRE_USR_ID" ).append("\n"); 
		query.append("       , A.CRE_DT" ).append("\n"); 
		query.append("FROM   EAS_DOD_INV_DTL A" ).append("\n"); 
		query.append("WHERE DOD_INV_NO = @[dod_inv_no]" ).append("\n"); 
		query.append(" GROUP BY A.DOD_INV_NO, A.CNTR_TPSZ_CD,A.BIL_CURR_CD, A.TAX_AMT, A.CRE_USR_ID, A.CRE_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
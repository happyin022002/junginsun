/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DOFChgTrfmanageDBDAOsearchEasDrffChgTrfDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.30
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2012.03.30 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.transportmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Min Jung Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DOFChgTrfmanageDBDAOsearchEasDrffChgTrfDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Drop-off Charge조회
	  * </pre>
	  */
	public DOFChgTrfmanageDBDAOsearchEasDrffChgTrfDtlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("drff_chg_trf_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("drff_chg_trf_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.transportmanage.integration").append("\n"); 
		query.append("FileName : DOFChgTrfmanageDBDAOsearchEasDrffChgTrfDtlRSQL").append("\n"); 
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
		query.append("D.DRFF_CHG_TRF_SEQ" ).append("\n"); 
		query.append(",D.DRFF_CHG_TRF_VER_NO" ).append("\n"); 
		query.append(",D.DRFF_CHG_TRF_DTL_SEQ" ).append("\n"); 
		query.append(",D.SCC_CD" ).append("\n"); 
		query.append(",D.PORT_INLND_CD" ).append("\n"); 
		query.append(",D.CONTI_CD" ).append("\n"); 
		query.append(",D.POD_CNT_CD" ).append("\n"); 
		query.append(",D.POD_CNT_LIST_CTNT" ).append("\n"); 
		query.append(",D.CURR_CD" ).append("\n"); 
		query.append(",CASE" ).append("\n"); 
		query.append("WHEN D.CURR_LIST_CTNT IS NOT NULL" ).append("\n"); 
		query.append("THEN D.CURR_LIST_CTNT" ).append("\n"); 
		query.append("ELSE 'EUR|USD'||DECODE((SELECT MAX(M.CURR_CD) CURR_CD FROM MDM_COUNTRY M WHERE M.CNT_CD LIKE SUBSTR(D.SCC_CD,1,2)||'%' AND M.CURR_CD NOT IN ('EUR','USD')),NULL,'','','','|')||(" ).append("\n"); 
		query.append("SELECT MAX(M.CURR_CD) CURR_CD FROM MDM_COUNTRY M WHERE M.CNT_CD LIKE SUBSTR(D.SCC_CD,1,2)||'%' AND M.CURR_CD NOT IN ('EUR','USD'))" ).append("\n"); 
		query.append("END CURR_LIST_CTNT" ).append("\n"); 
		query.append(",D.EXP_FLG" ).append("\n"); 
		query.append(",DECODE(MAX(X.D2), 0, 'E', MAX(X.D2)) D2" ).append("\n"); 
		query.append(",DECODE(MAX(X.D4), 0, 'E', MAX(X.D4)) D4" ).append("\n"); 
		query.append(",DECODE(MAX(X.D5), 0, 'E', MAX(X.D5)) D5" ).append("\n"); 
		query.append(",DECODE(MAX(X.R2), 0, 'E', MAX(X.R2)) R2" ).append("\n"); 
		query.append(",DECODE(MAX(X.R5), 0, 'E', MAX(X.R5)) R5" ).append("\n"); 
		query.append(",DECODE(MAX(X.R9), 0, 'E', MAX(X.R9)) R9" ).append("\n"); 
		query.append("FROM EAS_DRFF_CHG_TRF_HDR H, EAS_DRFF_CHG_TRF_DTL D" ).append("\n"); 
		query.append(", ( SELECT" ).append("\n"); 
		query.append("D.DRFF_CHG_TRF_SEQ" ).append("\n"); 
		query.append(",D.DRFF_CHG_TRF_VER_NO" ).append("\n"); 
		query.append(",D.DRFF_CHG_TRF_DTL_SEQ" ).append("\n"); 
		query.append(",DECODE(T.CNTR_TPSZ_CD, 'D2', CHRR_FRT_TAX_VAL, 0) D2" ).append("\n"); 
		query.append(",DECODE(T.CNTR_TPSZ_CD, 'D4', CHRR_FRT_TAX_VAL, 0) D4" ).append("\n"); 
		query.append(",DECODE(T.CNTR_TPSZ_CD, 'D5', CHRR_FRT_TAX_VAL, 0) D5" ).append("\n"); 
		query.append(",DECODE(T.CNTR_TPSZ_CD, 'R2', CHRR_FRT_TAX_VAL, 0) R2" ).append("\n"); 
		query.append(",DECODE(T.CNTR_TPSZ_CD, 'R5', CHRR_FRT_TAX_VAL, 0) R5" ).append("\n"); 
		query.append(",DECODE(T.CNTR_TPSZ_CD, 'R9', CHRR_FRT_TAX_VAL, 0) R9" ).append("\n"); 
		query.append("FROM EAS_DRFF_CHG_TRF_HDR H, EAS_DRFF_CHG_TRF_DTL D, EAS_DRFF_CHG_TRF_TP_SZ T" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND H.DRFF_CHG_TRF_SEQ = D.DRFF_CHG_TRF_SEQ" ).append("\n"); 
		query.append("AND H.DRFF_CHG_TRF_VER_NO = D.DRFF_CHG_TRF_VER_NO" ).append("\n"); 
		query.append("AND NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND H.DRFF_CHG_TRF_SEQ = @[drff_chg_trf_seq]" ).append("\n"); 
		query.append("AND H.DRFF_CHG_TRF_VER_NO = @[drff_chg_trf_ver_no]" ).append("\n"); 
		query.append("AND D.DRFF_CHG_TRF_SEQ = T.DRFF_CHG_TRF_SEQ" ).append("\n"); 
		query.append("AND D.DRFF_CHG_TRF_VER_NO = T.DRFF_CHG_TRF_VER_NO" ).append("\n"); 
		query.append("AND D.DRFF_CHG_TRF_DTL_SEQ = T.DRFF_CHG_TRF_DTL_SEQ" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND H.DRFF_CHG_TRF_SEQ = D.DRFF_CHG_TRF_SEQ" ).append("\n"); 
		query.append("AND H.DRFF_CHG_TRF_VER_NO = D.DRFF_CHG_TRF_VER_NO" ).append("\n"); 
		query.append("AND NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND H.DRFF_CHG_TRF_SEQ = @[drff_chg_trf_seq]" ).append("\n"); 
		query.append("AND H.DRFF_CHG_TRF_VER_NO = @[drff_chg_trf_ver_no]" ).append("\n"); 
		query.append("AND D.DRFF_CHG_TRF_SEQ = X.DRFF_CHG_TRF_SEQ(+)" ).append("\n"); 
		query.append("AND D.DRFF_CHG_TRF_VER_NO = X.DRFF_CHG_TRF_VER_NO(+)" ).append("\n"); 
		query.append("AND D.DRFF_CHG_TRF_DTL_SEQ = X.DRFF_CHG_TRF_DTL_SEQ(+)" ).append("\n"); 
		query.append("GROUP BY    D.DRFF_CHG_TRF_SEQ, D.DRFF_CHG_TRF_VER_NO, D.DRFF_CHG_TRF_DTL_SEQ," ).append("\n"); 
		query.append("D.SCC_CD, D.PORT_INLND_CD, D.CONTI_CD, D.POD_CNT_CD, D.POD_CNT_LIST_CTNT, D.CURR_CD, D.CURR_LIST_CTNT, D.EXP_FLG" ).append("\n"); 
		query.append("ORDER BY D.DRFF_CHG_TRF_DTL_SEQ, D.SCC_CD, D.PORT_INLND_CD, D.CONTI_CD, D.POD_CNT_CD, D.CURR_CD, D.EXP_FLG DESC" ).append("\n"); 

	}
}
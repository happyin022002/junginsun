/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RenewalConsultationDBDAOSearchSettlementTargetListForDelInvoiceNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RenewalConsultationDBDAOSearchSettlementTargetListForDelInvoiceNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 삭제 Invoice No에 해당하는 Settlement Target 목록 조회
	  * </pre>
	  */
	public RenewalConsultationDBDAOSearchSettlementTargetListForDelInvoiceNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.integration").append("\n"); 
		query.append("FileName : RenewalConsultationDBDAOSearchSettlementTargetListForDelInvoiceNoRSQL").append("\n"); 
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
		query.append("SELECT STL.VSL_CD" ).append("\n"); 
		query.append("     , STL.SKD_VOY_NO" ).append("\n"); 
		query.append("     , STL.SKD_DIR_CD" ).append("\n"); 
		query.append("     , STL.REV_DIR_CD" ).append("\n"); 
		query.append("     , STL.REV_YRMON" ).append("\n"); 
		query.append("     , STL.STL_VVD_SEQ" ).append("\n"); 
		query.append("     , STL.STL_TGT_FLG" ).append("\n"); 
		query.append("     , STL.LOCL_CURR_CD" ).append("\n"); 
		query.append("     , (NVL(STL.ACT_AMT,0) + DTL.ACT_AMT) AS ACT_AMT" ).append("\n"); 
		query.append("     , 'Delete from '||DTL_STL_RMK||DECODE(STL.STL_RMK,NULL,'',' ,'||STL.STL_RMK) AS STL_RMK" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT DTL.VSL_CD" ).append("\n"); 
		query.append("             , DTL.SKD_VOY_NO" ).append("\n"); 
		query.append("             , DTL.SKD_DIR_CD" ).append("\n"); 
		query.append("             , DTL.REV_DIR_CD" ).append("\n"); 
		query.append("             , DTL.REV_YRMON" ).append("\n"); 
		query.append("             , DTL.STL_VVD_SEQ" ).append("\n"); 
		query.append("             , SUM(ACT_AMT) AS ACT_AMT" ).append("\n"); 
		query.append("             , LISTAGG (DTL.TMP_STL_RMK, ',') WITHIN GROUP (ORDER BY DTL.TMP_STL_RMK) AS DTL_STL_RMK" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT DTL.VSL_CD" ).append("\n"); 
		query.append("                     , DTL.SKD_VOY_NO" ).append("\n"); 
		query.append("                     , DTL.SKD_DIR_CD" ).append("\n"); 
		query.append("                     , DTL.REV_DIR_CD" ).append("\n"); 
		query.append("                     , DTL.REV_YRMON" ).append("\n"); 
		query.append("                     , DTL.STL_VVD_SEQ" ).append("\n"); 
		query.append("                     , SUM(DTL.ACT_AMT) AS ACT_AMT" ).append("\n"); 
		query.append("                     , DTL.INV_NO||':'||SUM(DTL.ACT_AMT) AS TMP_STL_RMK" ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                        SELECT DTL.*" ).append("\n"); 
		query.append("                          FROM (" ).append("\n"); 
		query.append("                                select DTL.ACCT_YRMON" ).append("\n"); 
		query.append("                                     , DTL.JO_CRR_CD" ).append("\n"); 
		query.append("                                     , DTL.INV_NO" ).append("\n"); 
		query.append("                                     , DTL.RE_DIVR_CD" ).append("\n"); 
		query.append("                                     , DTL.VSL_CD" ).append("\n"); 
		query.append("                                     , DTL.SKD_VOY_NO" ).append("\n"); 
		query.append("                                     , DTL.SKD_DIR_CD" ).append("\n"); 
		query.append("                                     , DTL.REV_DIR_CD" ).append("\n"); 
		query.append("                                     , DTL.REV_YRMON" ).append("\n"); 
		query.append("                                     , DTL.STL_VVD_SEQ" ).append("\n"); 
		query.append("                                     , DTL.ACT_AMT" ).append("\n"); 
		query.append("                                     , DTL.CRE_DT" ).append("\n"); 
		query.append("                                  from JOO_INV_DTL DTL" ).append("\n"); 
		query.append("                                 WHERE 1=1" ).append("\n"); 
		query.append("                                   AND DTL.ACCT_YRMON       = @[acct_yrmon]" ).append("\n"); 
		query.append("                                   AND DTL.JO_CRR_CD        = @[jo_crr_cd]" ).append("\n"); 
		query.append("                                   AND DTL.INV_NO           = @[inv_no]" ).append("\n"); 
		query.append("                                   AND DTL.RE_DIVR_CD       = @[re_divr_cd]" ).append("\n"); 
		query.append("                          ) DTL" ).append("\n"); 
		query.append("                      ORDER BY DTL.CRE_DT, DTL.STL_VVD_SEQ" ).append("\n"); 
		query.append("                   ) DTL" ).append("\n"); 
		query.append("                 GROUP BY DTL.VSL_CD" ).append("\n"); 
		query.append("                     , DTL.SKD_VOY_NO" ).append("\n"); 
		query.append("                     , DTL.SKD_DIR_CD" ).append("\n"); 
		query.append("                     , DTL.REV_DIR_CD" ).append("\n"); 
		query.append("                     , DTL.REV_YRMON" ).append("\n"); 
		query.append("                     , DTL.STL_VVD_SEQ  " ).append("\n"); 
		query.append("                     , DTL.INV_NO" ).append("\n"); 
		query.append("             ) DTL" ).append("\n"); 
		query.append("         GROUP BY DTL.VSL_CD" ).append("\n"); 
		query.append("             , DTL.SKD_VOY_NO" ).append("\n"); 
		query.append("             , DTL.SKD_DIR_CD" ).append("\n"); 
		query.append("             , DTL.REV_DIR_CD" ).append("\n"); 
		query.append("             , DTL.REV_YRMON" ).append("\n"); 
		query.append("             , DTL.STL_VVD_SEQ  " ).append("\n"); 
		query.append("     ) DTL" ).append("\n"); 
		query.append("     , JOO_STL_TGT STL" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND STL.VSL_CD       = DTL.VSL_CD" ).append("\n"); 
		query.append("   AND STL.SKD_VOY_NO   = DTL.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND STL.SKD_DIR_CD   = DTL.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND STL.REV_DIR_CD   = DTL.REV_DIR_CD" ).append("\n"); 
		query.append("   AND STL.REV_YRMON    = DTL.REV_YRMON" ).append("\n"); 
		query.append("   AND STL.STL_VVD_SEQ  = DTL.STL_VVD_SEQ" ).append("\n"); 

	}
}
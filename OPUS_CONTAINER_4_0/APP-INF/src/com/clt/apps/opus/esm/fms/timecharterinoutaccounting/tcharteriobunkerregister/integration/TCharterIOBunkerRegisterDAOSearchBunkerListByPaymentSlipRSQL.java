/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOBunkerRegisterDAOSearchBunkerListByPaymentSlipRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.30
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOBunkerRegisterDAOSearchBunkerListByPaymentSlipRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOBunkerRegisterDAOSearchBunkerListByPaymentSlipRSQL
	  * </pre>
	  */
	public TCharterIOBunkerRegisterDAOSearchBunkerListByPaymentSlipRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.integration").append("\n"); 
		query.append("FileName : TCharterIOBunkerRegisterDAOSearchBunkerListByPaymentSlipRSQL").append("\n"); 
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
		query.append("SELECT BNK_TP_CD," ).append("\n"); 
		query.append("	   ACCT_NM," ).append("\n"); 
		query.append("	   ACCT_CD," ).append("\n"); 
		query.append("	   VVD_BUNKER," ).append("\n"); 
		query.append("	   FLET_MEAS_UT_CD," ).append("\n"); 
		query.append("	   BNK_QTY," ).append("\n"); 
		query.append("	   BNK_PRC_AMT," ).append("\n"); 
		query.append("	   CURR_CD," ).append("\n"); 
		query.append("	   BNK_AMT," ).append("\n"); 
		query.append("       BNK_TP_CD||' '|| FLET_MEAS_UT_CD || ' ' || BNK_QTY || ' * ' || CURR_CD || ' ' || BNK_PRC_AMT BNK_DESC, " ).append("\n"); 
		query.append("       CTR_CD," ).append("\n"); 
		query.append("       SLP_LOC_CD," ).append("\n"); 
		query.append("       FLET_SRC_TP_CD," ).append("\n"); 
		query.append("       FLET_CTRT_NO," ).append("\n"); 
		query.append("       BNK_SEQ," ).append("\n"); 
		query.append("	   VVD_YN," ).append("\n"); 
		query.append("       TO_INV_NO" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT BNK_TP_CD," ).append("\n"); 
		query.append("               (SELECT ACCT_ITM_NM" ).append("\n"); 
		query.append("                  FROM FMS_ACCT_ITM" ).append("\n"); 
		query.append("                 WHERE ACCT_CD = FB.ACCT_CD" ).append("\n"); 
		query.append("                   AND ACCT_ITM_SEQ = FB.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("                   AND ROWNUM = 1) ACCT_NM," ).append("\n"); 
		query.append("               FB.ACCT_CD," ).append("\n"); 
		query.append("               FB.VSL_CD || FB.SKD_VOY_NO || FB.SKD_DIR_CD || FB.REV_DIR_CD VVD_BUNKER," ).append("\n"); 
		query.append("               DECODE(FB.FLET_MEAS_UT_CD,'M','MT','Liter') FLET_MEAS_UT_CD," ).append("\n"); 
		query.append("               TO_CHAR(FB.BNK_QTY,'FM999,999,999,990.000') BNK_QTY," ).append("\n"); 
		query.append("               TO_CHAR(FB.BNK_PRC_AMT,'FM999,999,999,999,999,990.0000') BNK_PRC_AMT," ).append("\n"); 
		query.append("               'USD' CURR_CD," ).append("\n"); 
		query.append("               TO_CHAR(ROUND(FB.BNK_AMT,4),'FM999,999,999,999,999,990.0000') BNK_AMT," ).append("\n"); 
		query.append("               (SELECT AP_CTR_CD" ).append("\n"); 
		query.append("                  FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                 WHERE OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("                   AND ROWNUM = 1) CTR_CD," ).append("\n"); 
		query.append("               (SELECT LOC_CD" ).append("\n"); 
		query.append("                  FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                 WHERE OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("                   AND ROWNUM = 1) SLP_LOC_CD," ).append("\n"); 
		query.append("               '06' FLET_SRC_TP_CD," ).append("\n"); 
		query.append("               FB.FLET_CTRT_NO," ).append("\n"); 
		query.append("               FB.BNK_SEQ," ).append("\n"); 
		query.append("			   (SELECT DECODE(VSL_CD,NULL,'N','Y')" ).append("\n"); 
		query.append("          		  FROM AR_MST_REV_VVD" ).append("\n"); 
		query.append("         		 WHERE    VSL_CD " ).append("\n"); 
		query.append("               		   || SKD_VOY_NO " ).append("\n"); 
		query.append("               		   || SKD_DIR_CD " ).append("\n"); 
		query.append("               		   || RLANE_DIR_CD =    FB.VSL_CD " ).append("\n"); 
		query.append("                                 		 || FB.SKD_VOY_NO " ).append("\n"); 
		query.append("                                 		 || FB.SKD_DIR_CD " ).append("\n"); 
		query.append("                                 		 || FB.REV_DIR_CD" ).append("\n"); 
		query.append("           		   AND DELT_FLG = 'N') VVD_YN," ).append("\n"); 
		query.append("               SUBSTR(FB.FLET_CTRT_NO,1,4) || SUBSTR(FB.FLET_CTRT_NO,13,3) || FB.BNK_TP_CD || FB.ACCT_ITM_SEQ TO_INV_NO" ).append("\n"); 
		query.append("          FROM FMS_BUNKER FB" ).append("\n"); 
		query.append("         WHERE 1 = 1" ).append("\n"); 
		query.append("		   AND FB.SLP_TP_CD IS NULL " ).append("\n"); 
		query.append("           AND FB.AR_SLP_TP_CD IS NULL" ).append("\n"); 
		query.append("           AND FB.VSL_CD IN (SELECT VSL_CD " ).append("\n"); 
		query.append("                               FROM FMS_CONTRACT" ).append("\n"); 
		query.append("                              WHERE FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("                             UNION ALL" ).append("\n"); 
		query.append("                             SELECT VSL_CD" ).append("\n"); 
		query.append("                               FROM FMS_ID_VSL" ).append("\n"); 
		query.append("                              WHERE FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("								AND USE_FLG = 'Y')" ).append("\n"); 
		query.append("          AND FB.BNK_TP_CD IN (" ).append("\n"); 
		query.append("			         #foreach($BNK_TP_CD IN ${bnk_tp_cd_list})" ).append("\n"); 
		query.append("                            #if($bnk_tp_cd_list.hasNext()) '$BNK_TP_CD', #else '$BNK_TP_CD' #end" ).append("\n"); 
		query.append("                     #end" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("          AND SUBSTR(FB.FLET_CTRT_NO,5,2) = SUBSTR(@[flet_ctrt_no],5,2)" ).append("\n"); 
		query.append("       )" ).append("\n"); 

	}
}
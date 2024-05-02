/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SingleTransportationSOManageDBDAOSearchSingleTransportationSOCandidatesListUptUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.26
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2014.06.26 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CJH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SingleTransportationSOManageDBDAOSearchSingleTransportationSOCandidatesListUptUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customer 자료 UPDATE
	  * </pre>
	  */
	public SingleTransportationSOManageDBDAOSearchSingleTransportationSOCandidatesListUptUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.integration").append("\n"); 
		query.append("FileName : SingleTransportationSOManageDBDAOSearchSingleTransportationSOCandidatesListUptUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_SVC_ORD_TMP X" ).append("\n"); 
		query.append("   SET (X.SHPR_CUST_CNT_CD, X.SHPR_CUST_SEQ, X.SHPR_CUST_NM) = " ).append("\n"); 
		query.append("           (SELECT U.CUST_CNT_CD," ).append("\n"); 
		query.append("                   U.CUST_SEQ," ).append("\n"); 
		query.append("                   REPLACE(NVL(U.CUST_NM, ' '),CHR(13)||CHR(10),' ')" ).append("\n"); 
		query.append("              FROM BKG_CUSTOMER U" ).append("\n"); 
		query.append("             WHERE U.BKG_NO = X.BKG_NO" ).append("\n"); 
		query.append("               AND U.BKG_CUST_TP_CD = 'S')" ).append("\n"); 
		query.append("      ,(X.CNEE_CUST_CNT_CD, X.CNEE_CUST_SEQ, X.CNEE_CUST_NM) = " ).append("\n"); 
		query.append("           (SELECT U.CUST_CNT_CD," ).append("\n"); 
		query.append("                   U.CUST_SEQ," ).append("\n"); 
		query.append("                   REPLACE(NVL(U.CUST_NM, ' '),CHR(13)||CHR(10),' ')" ).append("\n"); 
		query.append("              FROM BKG_CUSTOMER U" ).append("\n"); 
		query.append("             WHERE U.BKG_NO = X.BKG_NO" ).append("\n"); 
		query.append("               AND U.BKG_CUST_TP_CD = 'C')" ).append("\n"); 
		query.append("      ,(X.NTFY_CUST_NM) = " ).append("\n"); 
		query.append("           (SELECT REPLACE(NVL(U.CUST_NM, ' '),CHR(13)||CHR(10),' ')" ).append("\n"); 
		query.append("              FROM BKG_CUSTOMER U" ).append("\n"); 
		query.append("             WHERE U.BKG_NO = X.BKG_NO" ).append("\n"); 
		query.append("               AND U.BKG_CUST_TP_CD = 'N')" ).append("\n"); 
		query.append("      #if (${ui_conti_cd} == 'M' )" ).append("\n"); 
		query.append("      ,(X.CNTR_PKUP_NO, X.AVAL_DT, X.LST_FREE_DT) = " ).append("\n"); 
		query.append("           (SELECT PU.PKUP_NO, PU.PKUP_AVAL_DT, PU.LST_FREE_DT" ).append("\n"); 
		query.append("              FROM BKG_PKUP_NTC_PKUP_NO PU" ).append("\n"); 
		query.append("                  ,MDM_LOCATION LOC" ).append("\n"); 
		query.append("             WHERE LOC.LOC_CD = PU.DEL_CD" ).append("\n"); 
		query.append("               AND PU.BKG_NO  = X.BKG_NO" ).append("\n"); 
		query.append("               AND PU.CNTR_NO = X.EQ_NO" ).append("\n"); 
		query.append("               AND PU.PKUP_YD_CD = X.FM_NOD_CD||X.FM_NOD_YD_NO" ).append("\n"); 
		query.append("               AND LOC.DELT_FLG = 'N'" ).append("\n"); 
		query.append("               AND TRS_GET_FOC_INFO_FNC(X.BL_NO, NULL, NULL, NULL) = 'YYY'" ).append("\n"); 
		query.append("               AND PU.UPD_DT = (SELECT MAX(Y.UPD_DT)" ).append("\n"); 
		query.append("                                  FROM BKG_PKUP_NTC_PKUP_NO Y" ).append("\n"); 
		query.append("                                 WHERE Y.BKG_NO  = PU.BKG_NO" ).append("\n"); 
		query.append("                                   AND Y.CNTR_NO = PU.CNTR_NO" ).append("\n"); 
		query.append("                                   AND Y.PKUP_YD_CD = PU.PKUP_YD_CD" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("               AND ROWNUM = 1" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("WHERE TRSP_TMP_SEQ = @[trsp_tmp_seq]" ).append("\n"); 

	}
}
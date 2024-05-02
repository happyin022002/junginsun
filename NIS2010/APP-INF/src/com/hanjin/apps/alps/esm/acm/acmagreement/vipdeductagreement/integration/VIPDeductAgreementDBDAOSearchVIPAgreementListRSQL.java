/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VIPDeductAgreementDBDAOSearchVIPAgreementListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmagreement.vipdeductagreement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VIPDeductAgreementDBDAOSearchVIPAgreementListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VIP deduct agreement 조회.
	  * 2016.08.05 김상현 [CHM-201642499] ALPS > ACM VIP Agreement Creation 상 SC/RFA No. 추가 요청
	  * </pre>
	  */
	public VIPDeductAgreementDBDAOSearchVIPAgreementListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_grp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmagreement.vipdeductagreement.integration").append("\n"); 
		query.append("FileName : VIPDeductAgreementDBDAOSearchVIPAgreementListRSQL").append("\n"); 
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
		query.append("SELECT AGMT.CUST_GRP_ID," ).append("\n"); 
		query.append("  (SELECT CUST_GRP_NM" ).append("\n"); 
		query.append("   FROM MDM_CUST_PERF_GRP" ).append("\n"); 
		query.append("   WHERE CUST_GRP_ID = AGMT.CUST_GRP_ID" ).append("\n"); 
		query.append("  ) AS CUST_GRP_NM," ).append("\n"); 
		query.append("  AGMT.AGMT_SEQ," ).append("\n"); 
		query.append("  AGMT.TRD_CD," ).append("\n"); 
		query.append("  AGMT.DIR_CD," ).append("\n"); 
		query.append("  AGMT.HUL_BND_CD," ).append("\n"); 
		query.append("  AGMT.SUB_TRD_CD," ).append("\n"); 
		query.append("  AGMT.POR_GRP_TP_CD," ).append("\n"); 
		query.append("  AGMT.POR_ROUT_CD," ).append("\n"); 
		query.append("  AGMT.POL_GRP_TP_CD," ).append("\n"); 
		query.append("  AGMT.POL_ROUT_CD," ).append("\n"); 
		query.append("  AGMT.POD_GRP_TP_CD," ).append("\n"); 
		query.append("  AGMT.POD_ROUT_CD," ).append("\n"); 
		query.append("  AGMT.DEL_GRP_TP_CD," ).append("\n"); 
		query.append("  AGMT.DEL_ROUT_CD," ).append("\n"); 
		query.append("  TO_CHAR((SELECT XMLAGG(XMLELEMENT(A, CNTR_TPSZ_CD || ',') ORDER BY AGMT_CNTR_SEQ).EXTRACT('//text()').GETCLOBVAL() CNTR_TPSZ_GRP_NM" ).append("\n"); 
		query.append("           FROM ACM_VIP_AGMT_CNTR" ).append("\n"); 
		query.append("           WHERE CUST_GRP_ID = AGMT.CUST_GRP_ID" ).append("\n"); 
		query.append("             AND AGMT_SEQ = AGMT.AGMT_SEQ" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("  ) AS CNTR_TPSZ_GRP_NM," ).append("\n"); 
		query.append("  AGMT.VIP_BKG_RT," ).append("\n"); 
		query.append("  AGMT.SC_NO," ).append("\n"); 
		query.append("  AGMT.RFA_NO," ).append("\n"); 
		query.append("  AGMT.TAA_NO," ).append("\n"); 
		query.append("  AGMT.FM_EFF_DT," ).append("\n"); 
		query.append("  AGMT.TO_EFF_DT," ).append("\n"); 
		query.append("  AGMT.CRE_USR_ID," ).append("\n"); 
		query.append("  AGMT.CRE_DT," ).append("\n"); 
		query.append("  AGMT.UPD_USR_ID," ).append("\n"); 
		query.append("  AGMT.UPD_DT" ).append("\n"); 
		query.append("FROM ACM_VIP_AGMT AGMT" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${cust_grp_id} != '')" ).append("\n"); 
		query.append("  AND AGMT.CUST_GRP_ID = @[cust_grp_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_tpsz_grp_nm} != '')" ).append("\n"); 
		query.append("  AND EXISTS(SELECT 1" ).append("\n"); 
		query.append("             FROM ACM_VIP_AGMT_CNTR" ).append("\n"); 
		query.append("             WHERE CUST_GRP_ID = AGMT.CUST_GRP_ID" ).append("\n"); 
		query.append("               AND AGMT_SEQ = AGMT.AGMT_SEQ" ).append("\n"); 
		query.append("               AND CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("  #foreach($cntr_tpsz in ${cntr_tpsz_list})" ).append("\n"); 
		query.append("    #if($velocityCount < $cntr_tpsz_list.size()) '$cntr_tpsz', #else '$cntr_tpsz' #end" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${delt_flg} != '')" ).append("\n"); 
		query.append("  AND AGMT.DELT_FLG = @[delt_flg]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  AND AGMT.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY AGMT.CUST_GRP_ID ASC, AGMT.AGMT_SEQ ASC" ).append("\n"); 

	}
}
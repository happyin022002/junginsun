/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralCodeMgtDBDAOsearchGeneralCodeListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.generalcodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeMgtDBDAOsearchGeneralCodeListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * </pre>
	  */
	public GeneralCodeMgtDBDAOsearchGeneralCodeListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_cd_grp_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_cd_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.generalmanage.generalcodemgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeMgtDBDAOsearchGeneralCodeListDataRSQL").append("\n"); 
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
		query.append("SELECT A.MNR_CD_SEQ," ).append("\n"); 
		query.append("       A.EQ_KND_CD," ).append("\n"); 
		query.append("       A.MNR_CD_ID," ).append("\n"); 
		query.append("       A.PRNT_CD_ID," ).append("\n"); 
		query.append("       A.MNR_CD_DP_DESC," ).append("\n"); 
		query.append("       A.MNR_CD_DESC," ).append("\n"); 
		query.append("       A.MNR_CD_DP_SEQ," ).append("\n"); 
		query.append("       A.PAIR_CD_ID," ).append("\n"); 
		query.append("       A.PAIR_CD_DP_DESC," ).append("\n"); 
		query.append("       A.PAIR_CD_DESC," ).append("\n"); 
		query.append("       A.PAIR_REF_CD," ).append("\n"); 
		query.append("       A.PAIR_DP_SEQ," ).append("\n"); 
		query.append("       A.MNR_CD_GRP_NO," ).append("\n"); 
		query.append("       A.MNR_CD_GRP_TP_CD," ).append("\n"); 
		query.append("       A.AGMT_USE_FLG," ).append("\n"); 
		query.append("       A.DELT_FLG," ).append("\n"); 
		query.append("       A.MNR_CD_DFLT_PNT_NO," ).append("\n"); 
		query.append("       A.MNR_ORD_TP_CD," ).append("\n"); 
		query.append("       A.CRE_USR_ID," ).append("\n"); 
		query.append("       A.CRE_DT," ).append("\n"); 
		query.append("       A.UPD_USR_ID," ).append("\n"); 
		query.append("       A.UPD_DT," ).append("\n"); 
		query.append("       A.COST_SHP_SRCH_PATT_NM," ).append("\n"); 
		query.append("       A.ACCT_CD," ).append("\n"); 
		query.append("       DECODE(A.PAIR_CD_ID, null, 'N', 'Y') INTG_FLG ," ).append("\n"); 
		query.append("       A.AGMT_VAL_FLG," ).append("\n"); 
		query.append("       A.AGMT_RT_FLG" ).append("\n"); 
		query.append("  FROM MNR_GEN_CD A" ).append("\n"); 
		query.append(" WHERE A.MNR_CD_GRP_NO = @[mnr_cd_grp_no]" ).append("\n"); 
		query.append("   AND A.MNR_CD_GRP_TP_CD = 'OT'" ).append("\n"); 
		query.append("#if (${mnr_cd_id} != 'All') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${mnr_cd_grp_no} == '1') " ).append("\n"); 
		query.append("   AND A.MNR_CD_ID = @[mnr_cd_id]" ).append("\n"); 
		query.append("#elseif (${mnr_cd_grp_no} == '2') " ).append("\n"); 
		query.append("   AND A.PRNT_CD_ID = @[mnr_cd_id]" ).append("\n"); 
		query.append("#elseif (${mnr_cd_grp_no} == '3') " ).append("\n"); 
		query.append("   AND A.PRNT_CD_ID IN ( SELECT MNR_CD_ID" ).append("\n"); 
		query.append("                           FROM MNR_GEN_CD" ).append("\n"); 
		query.append("                          WHERE MNR_CD_GRP_NO = '2'" ).append("\n"); 
		query.append("                            AND PRNT_CD_ID = @[mnr_cd_id]" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.MNR_CD_DP_SEQ" ).append("\n"); 

	}
}
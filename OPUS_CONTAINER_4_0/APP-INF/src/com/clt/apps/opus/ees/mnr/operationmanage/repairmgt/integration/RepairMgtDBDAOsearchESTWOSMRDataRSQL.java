/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RepairMgtDBDAOsearchESTWOSMRDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.11
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.02.11 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author park myoung sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RepairMgtDBDAOsearchESTWOSMRDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Repair Work Order List 의 Service Provider List 조회
	  * </pre>
	  */
	public RepairMgtDBDAOsearchESTWOSMRDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_dt_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_eq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.integration").append("\n"); 
		query.append("FileName : RepairMgtDBDAOsearchESTWOSMRDataRSQL").append("\n"); 
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
		query.append("SELECT A.VNDR_SEQ" ).append("\n"); 
		query.append(", (SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR WHERE VNDR_SEQ = A.VNDR_SEQ) VNDR_NM" ).append("\n"); 
		query.append(", (SELECT TRSM_MOD_CD FROM MNR_PARTNER WHERE MNR_PRNR_SEQ = A.VNDR_SEQ AND MNR_GRP_TP_CD = 'RPR' AND CTRL_OFC_CD = A.COST_OFC_CD) TRSM_MOD_CD" ).append("\n"); 
		query.append(", (SELECT MNR_CD_DESC FROM MNR_GEN_CD WHERE PRNT_CD_ID = 'CD00016' AND MNR_CD_ID = (SELECT TRSM_MOD_CD FROM MNR_PARTNER WHERE MNR_PRNR_SEQ = A.VNDR_SEQ AND MNR_GRP_TP_CD = 'RPR' AND CTRL_OFC_CD = A.COST_OFC_CD)) TRSM_MOD_NM" ).append("\n"); 
		query.append(", COUNT(A.VNDR_SEQ) PENDING" ).append("\n"); 
		query.append("FROM MNR_RPR_RQST_HDR A" ).append("\n"); 
		query.append("WHERE A.RPR_STS_CD = 'HA'" ).append("\n"); 
		query.append("AND A.RPR_RQST_LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("AND A.COST_OFC_CD = @[cost_ofc_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${eq_knd_cd} != 'A')" ).append("\n"); 
		query.append("AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND A.APRO_DT BETWEEN (SELECT GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[apro_dt_fr], 'YYYY-MM-DD'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) FROM DUAL) AND (SELECT GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[apro_dt_to], 'YYYY-MM-DD')+0.99999,MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) FROM DUAL)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${wo_no} != '')" ).append("\n"); 
		query.append("AND A.MNR_ORD_OFC_CTY_CD||A.MNR_ORD_SEQ IN (" ).append("\n"); 
		query.append("#foreach ($user_wo_no IN ${wo_nos})" ).append("\n"); 
		query.append("#if($velocityCount < $wo_nos.size())" ).append("\n"); 
		query.append("'$user_wo_no'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$user_wo_no'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vndr_seq} != 'A')" ).append("\n"); 
		query.append("AND A.VNDR_SEQ = TO_NUMBER(@[vndr_seq])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rqst_eq_no} != '')" ).append("\n"); 
		query.append("AND A.RQST_EQ_NO = @[rqst_eq_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${status} == 'I')" ).append("\n"); 
		query.append("AND A.MNR_ORD_SEQ  IS NULL" ).append("\n"); 
		query.append("#elseif (${status} == 'R')" ).append("\n"); 
		query.append("AND A.MNR_ORD_SEQ  IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY A.VNDR_SEQ, A.COST_OFC_CD" ).append("\n"); 

	}
}
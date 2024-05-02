/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RepairMgtDBDAOsearchESTWOINFODataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.11
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.02.11 박명신
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author park myoung sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RepairMgtDBDAOsearchESTWOINFODataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Repair W/O Detail 리스트 조회
	  * </pre>
	  */
	public RepairMgtDBDAOsearchESTWOINFODataRSQL(){
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
		params.put("selected_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("apro_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.integration").append("\n"); 
		query.append("FileName : RepairMgtDBDAOsearchESTWOINFODataRSQL").append("\n"); 
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
		query.append(", A.EQ_KND_CD" ).append("\n"); 
		query.append(", (SELECT MNR_CD_DESC FROM MNR_GEN_CD WHERE PRNT_CD_ID = 'CD00002' AND MNR_CD_ID = A.EQ_KND_CD AND ROWNUM = 1) EQ_KND_NM" ).append("\n"); 
		query.append(", A.RQST_EQ_NO" ).append("\n"); 
		query.append(", A.EQ_TPSZ_CD" ).append("\n"); 
		query.append(", A.RQST_REF_NO" ).append("\n"); 
		query.append(", A.RPR_YD_CD" ).append("\n"); 
		query.append(", A.CURR_CD" ).append("\n"); 
		query.append(", A.MNR_WRK_AMT" ).append("\n"); 
		query.append(", A.APRO_OFC_CD" ).append("\n"); 
		query.append(", A.APRO_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),A.APRO_DT,@[user_ofc_cd]),'YYYY-MM-DD') APRO_DT" ).append("\n"); 
		query.append(", TO_CHAR(A.RQST_DT,'YYYY-MM-DD') RQST_DT" ).append("\n"); 
		query.append(", (SELECT MNR_DMG_FLG FROM MNR_EQ_STS WHERE EQ_NO = A.RQST_EQ_NO) MNR_DMG_FLG" ).append("\n"); 
		query.append(", (SELECT MNR_DMG_FLG FROM MNR_EQ_STS WHERE EQ_NO = A.RQST_EQ_NO) HIDDEN_MNR_DMG_FLG" ).append("\n"); 
		query.append(", A.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append(", A.MNR_ORD_SEQ" ).append("\n"); 
		query.append(", A.MNR_ORD_OFC_CTY_CD||A.MNR_ORD_SEQ  WO_NO" ).append("\n"); 
		query.append(", (SELECT TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),CRE_DT,@[user_ofc_cd]),'YYYY-MM-DD') FROM MNR_ORD_HDR WHERE MNR_ORD_OFC_CTY_CD = A.MNR_ORD_OFC_CTY_CD AND MNR_ORD_SEQ = A.MNR_ORD_SEQ) WO_DT" ).append("\n"); 
		query.append(", (SELECT TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),MNR_ORD_SND_DT,@[user_ofc_cd]), 'YYYY-MM-DD') FROM MNR_ORD_HDR WHERE MNR_ORD_OFC_CTY_CD = A.MNR_ORD_OFC_CTY_CD AND MNR_ORD_SEQ = A.MNR_ORD_SEQ) MNR_ORD_SND_DT" ).append("\n"); 
		query.append(", A.RPR_RQST_SEQ" ).append("\n"); 
		query.append(", A.RPR_RQST_VER_NO" ).append("\n"); 
		query.append("FROM MNR_RPR_RQST_HDR A" ).append("\n"); 
		query.append("WHERE A.VNDR_SEQ = TO_NUMBER(@[selected_vndr_seq])" ).append("\n"); 
		query.append("AND A.RPR_STS_CD = 'HA'" ).append("\n"); 
		query.append("AND A.RPR_RQST_LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("AND A.COST_OFC_CD = @[cost_ofc_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${eq_knd_cd} != 'A')" ).append("\n"); 
		query.append("AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND A.APRO_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[apro_dt_fr],'YYYY-MM-DD'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[apro_dt_to],'YYYY-MM-DD'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())+0.99999" ).append("\n"); 
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
		query.append("ORDER BY A.RQST_DT DESC" ).append("\n"); 

	}
}
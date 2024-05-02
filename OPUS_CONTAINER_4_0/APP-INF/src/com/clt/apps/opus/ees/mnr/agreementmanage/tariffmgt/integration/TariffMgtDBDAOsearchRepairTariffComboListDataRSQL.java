/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TariffMgtDBDAOsearchRepairTariffComboListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.04
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.04.04 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author park myoung sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TariffMgtDBDAOsearchRepairTariffComboListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchRepairTariffComboListData
	  * </pre>
	  */
	public TariffMgtDBDAOsearchRepairTariffComboListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("mnr_trf_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_trf_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_dt_fr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.integration").append("\n"); 
		query.append("FileName : TariffMgtDBDAOsearchRepairTariffComboListDataRSQL").append("\n"); 
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
		query.append("SELECT    A.TRF_NO" ).append("\n"); 
		query.append(", A.MNR_TRF_KND_CD" ).append("\n"); 
		query.append(", MNR_COMMON_PKG.MNR_CONV_PARTNER_CD_FNC(A.VNDR_SEQ) AS VNDR_SEQ" ).append("\n"); 
		query.append(", (SELECT B.VNDR_LGL_ENG_NM FROM MDM_VENDOR B WHERE B.VNDR_SEQ = A.VNDR_SEQ) VNDR_NM" ).append("\n"); 
		query.append(", A.EQ_KND_CD" ).append("\n"); 
		query.append(", TO_CHAR(A.EFF_DT,'YYYY-MM-DD') EFF_DT" ).append("\n"); 
		query.append(", A.MNR_MEAS_UT_CD" ).append("\n"); 
		query.append(", A.CURR_CD" ).append("\n"); 
		query.append(", TO_CHAR(A.CRE_DT,'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append(", A.RQST_OFC_CD" ).append("\n"); 
		query.append(", A.CRE_USR_ID" ).append("\n"); 
		query.append(", MNR_COMMON_PKG.MNR_GET_USR_NM_FNC(A.CRE_USR_ID)  CRE_USR_NM" ).append("\n"); 
		query.append(", A.MNR_TRF_STS_CD" ).append("\n"); 
		query.append(", (SELECT C.MNR_CD_DESC FROM MNR_GEN_CD C WHERE C.MNR_CD_ID = A.MNR_TRF_KND_CD AND PRNT_CD_ID = 'CD00011') AS MNR_TRF_KND_NM" ).append("\n"); 
		query.append(", (SELECT C.MNR_CD_DESC FROM MNR_GEN_CD C WHERE C.MNR_CD_ID = A.EQ_KND_CD AND PRNT_CD_ID = 'CD00002') AS EQ_KND_NM" ).append("\n"); 
		query.append(", (SELECT C.MNR_CD_DESC FROM MNR_GEN_CD C WHERE C.MNR_CD_ID = A.MNR_TRF_STS_CD AND PRNT_CD_ID = 'CD00007') AS MNR_TRF_STS_NM" ).append("\n"); 
		query.append(", (SELECT C.MNR_CD_DESC FROM MNR_GEN_CD C WHERE C.MNR_CD_ID = A.MNR_MEAS_UT_CD AND PRNT_CD_ID = 'CD00010') AS MNR_MEAS_UT_NM" ).append("\n"); 
		query.append("FROM MNR_RPR_TRF_HDR A" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.TRF_NO =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT TRF_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT MTH.TRF_NO," ).append("\n"); 
		query.append("MTH.EFF_DT," ).append("\n"); 
		query.append("RANK() OVER(ORDER BY MTH.EFF_DT DESC) AS LVL" ).append("\n"); 
		query.append("FROM MNR_RPR_TRF_HDR MTH" ).append("\n"); 
		query.append("WHERE MTH.RQST_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#if (${mnr_trf_knd_cd} != '')" ).append("\n"); 
		query.append("AND MTH.MNR_TRF_KND_CD = @[mnr_trf_knd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND MTH.CRE_DT BETWEEN TO_DATE(@[cre_dt_fr], 'YYYY-MM-DD') AND TO_DATE(@[cre_dt_to] || '23:59:59', 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("#if (${eq_knd_cd} != '')" ).append("\n"); 
		query.append("AND MTH.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${mnr_trf_sts_cd} != '')" ).append("\n"); 
		query.append("AND MTH.MNR_TRF_STS_CD = @[mnr_trf_sts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND MTH.VNDR_SEQ = TO_NUMBER(@[vndr_seq])" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE LVL = '1'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
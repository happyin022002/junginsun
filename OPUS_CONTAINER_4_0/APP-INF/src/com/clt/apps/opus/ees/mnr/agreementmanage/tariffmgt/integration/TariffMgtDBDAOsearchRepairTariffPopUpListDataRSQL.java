/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TariffMgtDBDAOsearchRepairTariffPopUpListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.14
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TariffMgtDBDAOsearchRepairTariffPopUpListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public TariffMgtDBDAOsearchRepairTariffPopUpListDataRSQL(){
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
		query.append("FileName : TariffMgtDBDAOsearchRepairTariffPopUpListDataRSQL").append("\n"); 
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
		query.append("SELECT A.TRF_NO" ).append("\n"); 
		query.append("	 , A.MNR_TRF_KND_CD" ).append("\n"); 
		query.append("     , MNR_COMMON_PKG.MNR_CONV_PARTNER_CD_FNC(A.VNDR_SEQ) AS VNDR_SEQ" ).append("\n"); 
		query.append("     , (SELECT B.VNDR_LGL_ENG_NM FROM MDM_VENDOR B WHERE B.VNDR_SEQ = A.VNDR_SEQ) VNDR_NM" ).append("\n"); 
		query.append("	 , A.EQ_KND_CD" ).append("\n"); 
		query.append("	 , TO_CHAR(A.EFF_DT,'YYYY-MM-DD') EFF_DT" ).append("\n"); 
		query.append(" 	 , A.MNR_MEAS_UT_CD" ).append("\n"); 
		query.append("	 , A.CURR_CD" ).append("\n"); 
		query.append("	 , TO_CHAR(A.CRE_DT,'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append("     , A.RQST_OFC_CD" ).append("\n"); 
		query.append("	 , A.CRE_USR_ID" ).append("\n"); 
		query.append("	 , MNR_COMMON_PKG.MNR_GET_USR_NM_FNC(A.CRE_USR_ID)  CRE_USR_NM" ).append("\n"); 
		query.append("     , MNR_COMMON_PKG.MNR_CONV_AGMT_NO_FNC(C.AGMT_OFC_CTY_CD,C.AGMT_SEQ)  AGMT_NO" ).append("\n"); 
		query.append("     , A.MNR_TRF_STS_CD" ).append("\n"); 
		query.append("	 , (SELECT C.MNR_CD_DESC FROM MNR_GEN_CD C WHERE C.MNR_CD_ID = A.MNR_TRF_KND_CD AND PRNT_CD_ID = 'CD00011') AS MNR_TRF_KND_NM" ).append("\n"); 
		query.append("	 , (SELECT C.MNR_CD_DESC FROM MNR_GEN_CD C WHERE C.MNR_CD_ID = A.EQ_KND_CD AND PRNT_CD_ID = 'CD00002') AS EQ_KND_NM" ).append("\n"); 
		query.append("	 , (SELECT C.MNR_CD_DESC FROM MNR_GEN_CD C WHERE C.MNR_CD_ID = A.MNR_TRF_STS_CD AND PRNT_CD_ID = 'CD00007') AS MNR_TRF_STS_NM" ).append("\n"); 
		query.append("	 , (SELECT C.MNR_CD_DESC FROM MNR_GEN_CD C WHERE C.MNR_CD_ID = A.MNR_MEAS_UT_CD AND PRNT_CD_ID = 'CD00010') AS MNR_MEAS_UT_NM" ).append("\n"); 
		query.append("  FROM MNR_RPR_TRF_HDR A" ).append("\n"); 
		query.append("     , MNR_AGMT_HDR C" ).append("\n"); 
		query.append(" WHERE A.RQST_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if (${mnr_trf_knd_cd} != 'All') " ).append("\n"); 
		query.append("   AND A.MNR_TRF_KND_CD = @[mnr_trf_knd_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND A.TRF_NO = C.TRF_NO(+)" ).append("\n"); 
		query.append("   AND NVL(C.AGMT_LST_VER_FLG(+),'Y') = 'Y'" ).append("\n"); 
		query.append("   AND A.CRE_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[cre_dt_fr],'YYYY-MM-DD'), MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) " ).append("\n"); 
		query.append("					AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[cre_dt_to]||'23:59:59','YYYY-MM-DD HH24:MI:SS'), MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   #if (${access_system} != 'SPP') " ).append("\n"); 
		query.append("   AND A.MNR_TRF_STS_CD NOT IN ('SD','HD','SS')" ).append("\n"); 
		query.append("   #else " ).append("\n"); 
		query.append("   AND A.MNR_TRF_STS_CD NOT IN ('SD','HD','HS')" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if (${eq_knd_cd} != '')" ).append("\n"); 
		query.append("   AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if (${mnr_trf_sts_cd} != '') " ).append("\n"); 
		query.append("   AND A.MNR_TRF_STS_CD = @[mnr_trf_sts_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if (${vndr_seq} != '') " ).append("\n"); 
		query.append("   AND A.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  ORDER BY A.EFF_DT DESC" ).append("\n"); 

	}
}
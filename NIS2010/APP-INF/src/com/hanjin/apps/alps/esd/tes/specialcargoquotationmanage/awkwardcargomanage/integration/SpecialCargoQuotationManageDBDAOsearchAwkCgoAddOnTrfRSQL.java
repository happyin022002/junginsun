/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpecialCargoQuotationManageDBDAOsearchAwkCgoAddOnTrfRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.23
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.04.23 이혜민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hyemin Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoQuotationManageDBDAOsearchAwkCgoAddOnTrfRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchAwkCgoAddOnTrf
	  * </pre>
	  */
	public SpecialCargoQuotationManageDBDAOsearchAwkCgoAddOnTrfRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cond_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.integration").append("\n"); 
		query.append("FileName : SpecialCargoQuotationManageDBDAOsearchAwkCgoAddOnTrfRSQL").append("\n"); 
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
		query.append("SELECT * FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("AH.FM_LOC_CD" ).append("\n"); 
		query.append(", AH.FM_NOD_YD_NO" ).append("\n"); 
		query.append(", AH.TO_LOC_CD" ).append("\n"); 
		query.append(", AH.TO_NOD_YD_NO" ).append("\n"); 
		query.append(", AH.COND_NO" ).append("\n"); 
		query.append(",(SELECT C.COND_DESC" ).append("\n"); 
		query.append("FROM TES_TRF_COND C" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND C.COND_NO = X.COND_NO) COND_DESC" ).append("\n"); 
		query.append(", AH.TML_AWK_ADON_VER_NO" ).append("\n"); 
		query.append(", X.MAN_LOCL_CURR_CD" ).append("\n"); 
		query.append(", X.MAN_LOCL_AMT_20FT" ).append("\n"); 
		query.append(", X.MAN_LOCL_AMT_40FT" ).append("\n"); 
		query.append(", X.MAN_USD_AMT_20FT" ).append("\n"); 
		query.append(", X.MAN_USD_AMT_40FT" ).append("\n"); 
		query.append(", AH.VNDR_SEQ" ).append("\n"); 
		query.append(", AH.VNDR_NM" ).append("\n"); 
		query.append(", AH.CALC_RMK" ).append("\n"); 
		query.append(", AH.LST_UPD_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR(AH.LST_UPD_DT,'YYYY-MM-DD') LST_UPD_DT" ).append("\n"); 
		query.append(", AH.CRE_USR_ID" ).append("\n"); 
		query.append(", (SELECT Y.OFC_CD FROM MDM_YARD Y WHERE Y.YD_CD LIKE AH.FM_LOC_CD AND ROWNUM = 1) CRE_USR_OFC_CD" ).append("\n"); 
		query.append(", UU.OFC_CD UPD_USR_OFC_CD" ).append("\n"); 
		query.append("," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN TES_OOG_GET_AUTH_YN_FNC(@[lg_ofc_cd], (SELECT Y.OFC_CD FROM MDM_YARD Y WHERE Y.YD_CD LIKE AH.FM_LOC_CD AND ROWNUM = 1)) IS NOT NULL AND TES_OOG_GET_AUTH_YN_FNC(@[lg_ofc_cd], (SELECT Y.OFC_CD FROM MDM_YARD Y WHERE Y.YD_CD LIKE AH.FM_LOC_CD AND ROWNUM = 1)) = 'Y' --// LOGIN OFC를 조건으로 걸기" ).append("\n"); 
		query.append("THEN 'Y'" ).append("\n"); 
		query.append("WHEN TES_OOG_GET_AUTH_YN_FNC(@[lg_ofc_cd], UU.OFC_CD) IS NOT NULL AND TES_OOG_GET_AUTH_YN_FNC(@[lg_ofc_cd], UU.OFC_CD) = 'Y' --// LOGIN OFC를 조건으로 걸기" ).append("\n"); 
		query.append("THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END CHK_AUTH_YN" ).append("\n"); 
		query.append("," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN X.SPCL_CGO_REF_SEQ IS NOT NULL" ).append("\n"); 
		query.append("THEN X.SPCL_CGO_REF_SEQ" ).append("\n"); 
		query.append("WHEN X.SPCL_CGO_REF_SEQ_PM IS NOT NULL" ).append("\n"); 
		query.append("THEN X.SPCL_CGO_REF_SEQ_PM" ).append("\n"); 
		query.append("ELSE TO_NUMBER('')" ).append("\n"); 
		query.append("END SPCL_CGO_REF_SEQ" ).append("\n"); 
		query.append("FROM TES_AWK_CGO_ADON_HDR AH, (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("/** ADD-ON HDR **/" ).append("\n"); 
		query.append("T.FM_LOC_CD, T.FM_NOD_YD_NO, T.TO_LOC_CD, T.TO_NOD_YD_NO, T.COND_NO, MAX(T.TML_AWK_ADON_VER_NO) TML_AWK_ADON_VER_NO," ).append("\n"); 
		query.append("/** UNIT COST MANUAL (LOCL CURR) **/" ).append("\n"); 
		query.append("MAX(LOCL_CURR_CD) MAN_LOCL_CURR_CD," ).append("\n"); 
		query.append("MAX(DECODE(T.CNTR_SZ_CD,'2',T.LOCL_CURR_AMT,'')) MAN_LOCL_AMT_20FT," ).append("\n"); 
		query.append("MAX(DECODE(T.CNTR_SZ_CD,'4',T.LOCL_CURR_AMT,'')) MAN_LOCL_AMT_40FT," ).append("\n"); 
		query.append("/** UNIT COST MANUAL (USD) **/" ).append("\n"); 
		query.append("MAX(DECODE(T.CNTR_SZ_CD,'2',T.USD_AMT,'')) MAN_USD_AMT_20FT," ).append("\n"); 
		query.append("MAX(DECODE(T.CNTR_SZ_CD,'4',T.USD_AMT,'')) MAN_USD_AMT_40FT," ).append("\n"); 
		query.append("MAX(PD.SPCL_CGO_REF_SEQ) SPCL_CGO_REF_SEQ," ).append("\n"); 
		query.append("MAX(PM.SPCL_CGO_REF_SEQ) SPCL_CGO_REF_SEQ_PM" ).append("\n"); 
		query.append("FROM TES_AWK_CGO_ADON_HDR D, TES_AWK_CGO_ADON_TP_SZ T, PRI_SCQ_AWK_ROUT_DTL PD, PRI_SCQ_AWK_ROUT_DTL_TMP PM" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND D.FM_LOC_CD              = T.FM_LOC_CD" ).append("\n"); 
		query.append("AND D.FM_NOD_YD_NO           = T.FM_NOD_YD_NO" ).append("\n"); 
		query.append("AND D.TO_LOC_CD              = T.TO_LOC_CD" ).append("\n"); 
		query.append("AND D.TO_NOD_YD_NO           = T.TO_NOD_YD_NO" ).append("\n"); 
		query.append("AND D.COND_NO                = T.COND_NO" ).append("\n"); 
		query.append("AND D.TML_AWK_ADON_VER_NO    = T.TML_AWK_ADON_VER_NO" ).append("\n"); 
		query.append("AND D.TML_AWK_ADON_VER_NO = (" ).append("\n"); 
		query.append("SELECT MAX(XD.TML_AWK_ADON_VER_NO)" ).append("\n"); 
		query.append("FROM TES_AWK_CGO_ADON_HDR XD" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND XD.FM_LOC_CD              = T.FM_LOC_CD" ).append("\n"); 
		query.append("AND XD.FM_NOD_YD_NO           = T.FM_NOD_YD_NO" ).append("\n"); 
		query.append("AND XD.TO_LOC_CD              = T.TO_LOC_CD" ).append("\n"); 
		query.append("AND XD.TO_NOD_YD_NO           = T.TO_NOD_YD_NO" ).append("\n"); 
		query.append("AND XD.COND_NO                = T.COND_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND T.SPCL_CGO_REF_SEQ = PD.SPCL_CGO_REF_SEQ(+)" ).append("\n"); 
		query.append("AND T.SPCL_CGO_REF_SEQ = PM.SPCL_CGO_REF_SEQ(+)" ).append("\n"); 
		query.append("GROUP BY T.FM_LOC_CD, T.FM_NOD_YD_NO, T.TO_LOC_CD, T.TO_NOD_YD_NO, T.COND_NO" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append(", COM_USER CU, COM_USER UU" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if(${fm_loc_cd} != '' )" ).append("\n"); 
		query.append("AND AH.FM_LOC_CD = @[fm_loc_cd] --// 조회조건: FM_LOC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${to_loc_cd} != '' )" ).append("\n"); 
		query.append("AND AH.TO_LOC_CD = @[to_loc_cd] --// 조회조건: TO_LOC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND AH.FM_LOC_CD 	= X.FM_LOC_CD" ).append("\n"); 
		query.append("AND AH.FM_NOD_YD_NO = X.FM_NOD_YD_NO" ).append("\n"); 
		query.append("AND AH.TO_LOC_CD 	= X.TO_LOC_CD" ).append("\n"); 
		query.append("AND AH.TO_NOD_YD_NO = X.TO_NOD_YD_NO" ).append("\n"); 
		query.append("AND AH.COND_NO 	= X.COND_NO" ).append("\n"); 
		query.append("AND AH.TML_AWK_ADON_VER_NO = (" ).append("\n"); 
		query.append("SELECT MAX(XD.TML_AWK_ADON_VER_NO)" ).append("\n"); 
		query.append("FROM TES_AWK_CGO_ADON_HDR XD" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND XD.FM_LOC_CD              = AH.FM_LOC_CD" ).append("\n"); 
		query.append("AND XD.FM_NOD_YD_NO           = AH.FM_NOD_YD_NO" ).append("\n"); 
		query.append("AND XD.TO_LOC_CD              = AH.TO_LOC_CD" ).append("\n"); 
		query.append("AND XD.TO_NOD_YD_NO           = AH.TO_NOD_YD_NO" ).append("\n"); 
		query.append("AND XD.COND_NO                = AH.COND_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND AH.CRE_USR_ID = CU.USR_ID(+)" ).append("\n"); 
		query.append("AND NVL(CU.USE_FLG(+),'N') = 'Y'" ).append("\n"); 
		query.append("AND AH.LST_UPD_USR_ID = UU.USR_ID(+)" ).append("\n"); 
		query.append("AND NVL(UU.USE_FLG(+),'N') = 'Y'" ).append("\n"); 
		query.append(") P" ).append("\n"); 
		query.append("#if(${cond_no} != '' )" ).append("\n"); 
		query.append("WHERE P.COND_NO = @[cond_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY P.FM_LOC_CD, P.FM_NOD_YD_NO, P.TO_LOC_CD, P.TO_NOD_YD_NO, P.COND_NO" ).append("\n"); 

	}
}
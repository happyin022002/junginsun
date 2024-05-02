/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingListSearchDBDAOsearchBkgListForUsaTmlEdiRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.20
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2016.05.20 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingListSearchDBDAOsearchBkgListForUsaTmlEdiRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBkgListForUsaTmlEdi
	  * </pre>
	  */
	public GeneralBookingListSearchDBDAOsearchBkgListForUsaTmlEdiRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_staff",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ack",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingListSearchDBDAOsearchBkgListForUsaTmlEdiRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append("        , BKG_STS_CD" ).append("\n"); 
		query.append("        , F_M" ).append("\n"); 
		query.append("        , F_H" ).append("\n"); 
		query.append("        , SP" ).append("\n"); 
		query.append("        , T_VVD" ).append("\n"); 
		query.append("        , VVD_HISTORY" ).append("\n"); 
		query.append("        , ETB" ).append("\n"); 
		query.append("        , LANE" ).append("\n"); 
		query.append("        , POL_CD" ).append("\n"); 
		query.append("        , SUBSTR(YD_CD, 6, 2) YD_CD" ).append("\n"); 
		query.append("        , BKG_DATE" ).append("\n"); 
		query.append("        , ACK" ).append("\n"); 
		query.append("        , SEND_DATE" ).append("\n"); 
		query.append("        , ACK_DATE" ).append("\n"); 
		query.append("        , SEND_USR_ID" ).append("\n"); 
		query.append("        , SEND_USR_NM" ).append("\n"); 
		query.append("        , TML_ERR_MSG" ).append("\n"); 
		query.append("  FROM (     " ).append("\n"); 
		query.append("    SELECT /*+ INDEX(VVD XPKBKG_VVD) INDEX(NTC XPKBKG_NTC_HIS) INDEX(TML XPKBKG_TML_EDI_HIS) */" ).append("\n"); 
		query.append("			BK.BKG_NO" ).append("\n"); 
		query.append("            , BK.BKG_STS_CD" ).append("\n"); 
		query.append("            , DECODE(BK.BKG_CGO_TP_CD, 'F', 'F', 'P', 'M') F_M" ).append("\n"); 
		query.append("            , BK.FLEX_HGT_FLG F_H" ).append("\n"); 
		query.append("            , DECODE(BK.DCGO_FLG,    'Y', 'D', NULL)||" ).append("\n"); 
		query.append("              DECODE(BK.RC_FLG,      'Y', 'R', NULL)||" ).append("\n"); 
		query.append("              DECODE(BK.AWK_CGO_FLG, 'Y', 'A', NULL)||" ).append("\n"); 
		query.append("              DECODE(BK.BB_CGO_FLG,  'Y', 'B', NULL) SP" ).append("\n"); 
		query.append("            , BK.VSL_CD||BK.SKD_VOY_NO||BK.SKD_DIR_CD T_VVD" ).append("\n"); 
		query.append("            , TML.VSL_CD||TML.SKD_VOY_NO||TML.SKD_DIR_CD VVD_HISTORY" ).append("\n"); 
		query.append("            , (SELECT TO_CHAR(VPS_ETB_DT, 'YYYY-MM-DD')" ).append("\n"); 
		query.append("                 FROM VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("                WHERE VVD.VSL_CD        = SKD.VSL_CD" ).append("\n"); 
		query.append("                  AND VVD.SKD_VOY_NO    = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("                  AND VVD.SKD_DIR_CD    = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("                  AND VVD.POL_CD        = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("                  AND VVD.pol_CLPT_IND_SEQ  = SKD.CLPT_IND_SEQ) ETB" ).append("\n"); 
		query.append("            , NVL(TML.SLAN_CD, BK.SLAN_CD) LANE" ).append("\n"); 
		query.append("            , NVL(TML.POL_CD, BK.POL_CD) POL_CD" ).append("\n"); 
		query.append("            , NVL(TML.YD_CD,  BK.POL_NOD_CD) YD_CD" ).append("\n"); 
		query.append("            , TO_CHAR(BKG_CRE_DT, 'YYYY-MM-DD HH24:MI') BKG_DATE" ).append("\n"); 
		query.append("            , TML.TML_RSPN_STS_CD ACK" ).append("\n"); 
		query.append("            --, TO_CHAR(TML.SND_DT,  'YYYY-MM-DD HH24:MI') SEND_DATE" ).append("\n"); 
		query.append("            , TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(COM_CONSTANTMGR_PKG.COM_GETBASELOCATIONCODE_FNC(), TML.SND_DT, 'GMT'),  'YYYY-MM-DD HH24:MI') SEND_DATE" ).append("\n"); 
		query.append("            --, TO_CHAR(TML.MODI_DT, 'YYYY-MM-DD HH24:MI') ACK_DATE" ).append("\n"); 
		query.append("            , TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(TML.POL_CD, TML.MODI_DT, 'GMT'), 'YYYY-MM-DD HH24:MI') ACK_DATE" ).append("\n"); 
		query.append("            , TML.SND_USR_ID SEND_USR_ID" ).append("\n"); 
		query.append("            , (SELECT USR.USR_NM FROM COM_USER USR WHERE USR.USR_ID = TML.SND_USR_ID) SEND_USR_NM" ).append("\n"); 
		query.append("            , TML.ERR_MSG TML_ERR_MSG" ).append("\n"); 
		query.append("      FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("            , BKG_VVD VVD" ).append("\n"); 
		query.append("            , BKG_NTC_HIS NTC" ).append("\n"); 
		query.append("            , BKG_TML_EDI_HIS TML" ).append("\n"); 
		query.append("     WHERE BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("       AND VVD.VSL_PRE_PST_CD IN ( 'S', 'T' )" ).append("\n"); 
		query.append("       AND BK.BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("	   AND BK.BKG_STS_CD IN ('F', 'W')" ).append("\n"); 
		query.append("       AND BK.BKG_NO = NTC.BKG_NO(+)" ).append("\n"); 
		query.append("	   AND NTC.BKG_NO = TML.BKG_NO(+)" ).append("\n"); 
		query.append("	   AND NTC.DIFF_RMK = TML.TML_EDI_RQST_NO(+)" ).append("\n"); 
		query.append("       AND 'E'  = NTC.NTC_VIA_CD(+)" ).append("\n"); 
		query.append("       AND 'BT' = NTC.NTC_KND_CD(+)" ).append("\n"); 
		query.append("#if (${bkg_no} != '')" ).append("\n"); 
		query.append("       AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${date_type} == '1')" ).append("\n"); 
		query.append("	#if (${bkg_from_dt} != '')" ).append("\n"); 
		query.append("       AND BK.BKG_CRE_DT > TO_DATE(@[bkg_from_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${bkg_to_dt} != '')" ).append("\n"); 
		query.append("       AND BK.BKG_CRE_DT < TO_DATE(@[bkg_to_dt], 'YYYY-MM-DD') + 1" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#elseif(${date_type} == '2')" ).append("\n"); 
		query.append("	#if (${bkg_from_dt} != '')" ).append("\n"); 
		query.append("       AND NTC.SND_RQST_DT > TO_DATE(@[bkg_from_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${bkg_to_dt} != '')" ).append("\n"); 
		query.append("       AND NTC.SND_RQST_DT < TO_DATE(@[bkg_to_dt], 'YYYY-MM-DD') + 1" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("       AND BK.BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_sts_cd} != 'All' && ${bkg_sts_cd} != '')" ).append("\n"); 
		query.append("       AND BK.BKG_STS_CD = @[bkg_sts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("       AND VVD.VSL_CD     = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("       AND VVD.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("       AND VVD.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("       AND VVD.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_yd_cd} != '')" ).append("\n"); 
		query.append(" 	   AND VVD.POL_YD_CD = @[pol_cd]||@[pol_yd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${slan_cd} != '')" ).append("\n"); 
		query.append("       AND VVD.SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_staff} != '')" ).append("\n"); 
		query.append("       AND BK.DOC_USR_ID = @[bkg_staff]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${edi_send_sts_cd} == 'Y')" ).append("\n"); 
		query.append("  AND SEND_DATE IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--ack --CD02160" ).append("\n"); 
		query.append("--E ERROR " ).append("\n"); 
		query.append("--R REJECT" ).append("\n"); 
		query.append("--S SUCCESS" ).append("\n"); 
		query.append("#if (${ack} != 'All' && ${ack} != '' && ${ack} != 'N')" ).append("\n"); 
		query.append("  AND ACK = @[ack]" ).append("\n"); 
		query.append("#elseif (${ack} == 'N')" ).append("\n"); 
		query.append("  AND ACK IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
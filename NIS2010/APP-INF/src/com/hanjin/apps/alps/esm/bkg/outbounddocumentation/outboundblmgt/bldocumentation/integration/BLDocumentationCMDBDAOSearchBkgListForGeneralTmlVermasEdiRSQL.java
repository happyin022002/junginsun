/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLDocumentationCMDBDAOSearchBkgListForGeneralTmlVermasEdiRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOSearchBkgListForGeneralTmlVermasEdiRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BLDocumentationCMDBDAOSearchBkgListForGeneralTmlVermasEdiRSQL
	  * </pre>
	  */
	public BLDocumentationCMDBDAOSearchBkgListForGeneralTmlVermasEdiRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOSearchBkgListForGeneralTmlVermasEdiRSQL").append("\n"); 
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
		query.append("        , FIRST_VVD" ).append("\n"); 
		query.append("        , ETB" ).append("\n"); 
		query.append("        , LANE" ).append("\n"); 
		query.append("        , POL_CD" ).append("\n"); 
		query.append("        , SUBSTR(POL_YD_CD, 6, 2) POL_YD_CD" ).append("\n"); 
		query.append("        , FWDR_CD MY_FWRD_REF_CD" ).append("\n"); 
		query.append("        , VOYAGE MY_FWRD_VSL_DESC" ).append("\n"); 
		query.append("        , CRN" ).append("\n"); 
		query.append("        , UVI" ).append("\n"); 
		query.append("        , BKG_DATE" ).append("\n"); 
		query.append("        , BKG_STAFF" ).append("\n"); 
		query.append("        , BKG_STAFF_NM" ).append("\n"); 
		query.append("        , SEND_DATE" ).append("\n"); 
		query.append("        , SEND_USR_ID" ).append("\n"); 
		query.append("        , BP_XMRN" ).append("\n"); 
		query.append("        , RESULT" ).append("\n"); 
		query.append("  FROM (     " ).append("\n"); 
		query.append("    SELECT /*+ INDEX(VVD XPKBKG_VVD) INDEX(NTC XPKBKG_NTC_HIS) */" ).append("\n"); 
		query.append("			BK.BKG_NO" ).append("\n"); 
		query.append("            , BK.BKG_STS_CD" ).append("\n"); 
		query.append("            , DECODE(BK.BKG_CGO_TP_CD, 'F', 'F', 'P', 'M') F_M" ).append("\n"); 
		query.append("            , VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD FIRST_VVD" ).append("\n"); 
		query.append("            , (SELECT TO_CHAR(VPS_ETB_DT, 'YYYY-MM-DD')" ).append("\n"); 
		query.append("                 FROM VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("                WHERE VVD.VSL_CD        = SKD.VSL_CD" ).append("\n"); 
		query.append("                  AND VVD.SKD_VOY_NO    = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("                  AND VVD.SKD_DIR_CD    = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("                  AND VVD.POL_CD        = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("                  AND VVD.pol_CLPT_IND_SEQ  = SKD.CLPT_IND_SEQ) ETB" ).append("\n"); 
		query.append("            , VVD.SLAN_CD LANE" ).append("\n"); 
		query.append("            , VVD.POL_CD" ).append("\n"); 
		query.append("            , VVD.POL_YD_CD" ).append("\n"); 
		query.append("            , MY_FWRD_CD FWDR_CD" ).append("\n"); 
		query.append("            , MY_FWRD_VSL_DESC VOYAGE" ).append("\n"); 
		query.append("            , DCHG.CVY_REF_NO CRN" ).append("\n"); 
		query.append("            , DCHG.UQ_VSL_ID_NO UVI" ).append("\n"); 
		query.append("            , TO_CHAR(BKG_CRE_DT, 'YYYY-MM-DD HH:MI') BKG_dATE" ).append("\n"); 
		query.append("            , BK.DOC_USR_ID BKG_STAFF" ).append("\n"); 
		query.append("            , (SELECT USR.USR_NM FROM COM_USER USR WHERE USR.USR_ID = BK.DOC_USR_ID) BKG_STAFF_NM" ).append("\n"); 
		query.append("            , TO_CHAR(NTC.SND_RQST_DT, 'YYYY-MM-DD HH:MI') SEND_DATE" ).append("\n"); 
		query.append("            , NTC.SND_USR_ID SEND_USR_ID" ).append("\n"); 
		query.append("            , NTC.TML_NTC_SND_STS_CD ACK" ).append("\n"); 
		query.append("            , BP_XMRN.CUST_REF_NO_CTNT BP_XMRN" ).append("\n"); 
		query.append("            , (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                 FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                WHERE 'CD02396' = INTG_CD_ID" ).append("\n"); 
		query.append("                  AND INTG_CD_VAL_CTNT = DECODE(NTC.BKG_NTC_SND_RSLT_CD,'A',3,'F',4,'N',4,NULL)" ).append("\n"); 
		query.append("              ) AS RESULT" ).append("\n"); 
		query.append("      FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("            , BKG_VVD VVD" ).append("\n"); 
		query.append("            , BKG_VSL_DCHG_YD DCHG" ).append("\n"); 
		query.append("            , BKG_NTC_HIS NTC" ).append("\n"); 
		query.append("            , BKG_REFERENCE BP_XMRN" ).append("\n"); 
		query.append("     WHERE BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("       AND BK.POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("       AND VVD.VSL_PRE_PST_CD IN ('S', 'T')" ).append("\n"); 
		query.append("       AND VVD.VSL_CD        = DCHG.VSL_CD(+)" ).append("\n"); 
		query.append("       AND VVD.SKD_VOY_NO    = DCHG.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("       AND VVD.SKD_DIR_CD    = DCHG.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("       AND VVD.POL_CD        = DCHG.PORT_CD(+)" ).append("\n"); 
		query.append("       AND VVD.pol_CLPT_IND_SEQ  = DCHG.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("       AND BK.BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("       AND BK.BKG_NO = NTC.BKG_NO(+)" ).append("\n"); 
		query.append("       AND 'E'  = NTC.NTC_VIA_CD(+)" ).append("\n"); 
		query.append("       AND 'VM' = NTC.NTC_KND_CD(+)" ).append("\n"); 
		query.append("       AND BK.BKG_NO                = BP_XMRN.BKG_NO(+)" ).append("\n"); 
		query.append("       AND BP_XMRN.BKG_REF_TP_CD(+) = 'XMRN'" ).append("\n"); 
		query.append("#if (${bkg_no} != '')" ).append("\n"); 
		query.append("       AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_from_dt} != '')" ).append("\n"); 
		query.append("       AND BK.BKG_CRE_DT > TO_DATE(@[bkg_from_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_to_dt} != '')" ).append("\n"); 
		query.append("       AND BK.BKG_CRE_DT < TO_DATE(@[bkg_to_dt], 'YYYY-MM-DD') + 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("       AND BK.BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_sts_cd} != 'All' && ${bkg_sts_cd} != '')" ).append("\n"); 
		query.append("       AND BK.BKG_STS_CD = @[bkg_sts_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	   AND BK.BKG_STS_CD <> 'X'" ).append("\n"); 
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
		query.append("       AND UPPER(BK.DOC_USR_ID) = UPPER(@[bkg_staff])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${edi_send_sts_cd} == 'Y')" ).append("\n"); 
		query.append("  AND SEND_DATE IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
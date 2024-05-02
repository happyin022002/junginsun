/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AusCustomsTransmissionDBDAOsearchBlGeneralForPRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AusCustomsTransmissionDBDAOsearchBlGeneralForPRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public AusCustomsTransmissionDBDAOsearchBlGeneralForPRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.integration").append("\n"); 
		query.append("FileName : AusCustomsTransmissionDBDAOsearchBlGeneralForPRSQL").append("\n"); 
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
		query.append("SELECT NVL(B.BL_NO, '')||DECODE(NVL(B.BL_TP_CD, ''), 'S', '', NVL(B.BL_TP_CD, '')) AS BLNBR," ).append("\n"); 
		query.append("       NVL(VVD.POL_CD, '') AS BLPOL," ).append("\n"); 
		query.append("       NVL(VVD.POD_CD, '') AS BLPOD," ).append("\n"); 
		query.append("       NVL(B.POR_CD, '') AS BLPOR," ).append("\n"); 
		query.append("       NVL(B.DEL_CD, '') AS BLDEL," ).append("\n"); 
		query.append("       DECODE(@[pol_cd], NULL, NVL(B.PST_RLY_PORT_CD, ''), NVL(B.PRE_RLY_PORT_CD, '')) AS BLRLY," ).append("\n"); 
		query.append("       NVL(E.LOC_CD, '') AS BLPLACE," ).append("\n"); 
		query.append("       NVL(TO_CHAR(BL.OBL_ISS_DT, 'RRMMDD'), '') AS BLDATE," ).append("\n"); 
		query.append("       NVL(BCS.CUST_CNT_CD, '')||LPAD(NVL(TO_CHAR(BCS.CUST_SEQ), ''), 6, '0') AS CUST_CD," ).append("\n"); 
		query.append("       DECODE(SCE_TOKEN_NL_FNC(BCS.CUST_NM, 1), NULL, DECODE(SCE_TOKEN_NL_FNC(BCS.CUST_NM, 2), NULL, DECODE(SCE_TOKEN_NL_FNC(BCS.CUST_ADDR, 1), NULL, DECODE(SCE_TOKEN_NL_FNC(BCS.CUST_ADDR, 2), NULL, SCE_TOKEN_NL_FNC(BCS.CUST_ADDR, 3), SCE_TOKEN_NL_FNC(BCS.CUST_ADDR, 2)), (SCE_TOKEN_NL_FNC(BCS.CUST_ADDR, 1))), SCE_TOKEN_NL_FNC(BCS.CUST_NM, 2)), SCE_TOKEN_NL_FNC(BCS.CUST_NM, 1)) AS SHPR1," ).append("\n"); 
		query.append("       DECODE(SCE_TOKEN_NL_FNC(BCS.CUST_NM, 2), NULL, DECODE(SCE_TOKEN_NL_FNC(BCS.CUST_ADDR, 1), NULL, DECODE(SCE_TOKEN_NL_FNC(BCS.CUST_ADDR, 2), NULL, SCE_TOKEN_NL_FNC(BCS.CUST_ADDR, 3), SCE_TOKEN_NL_FNC(BCS.CUST_ADDR, 2)), SCE_TOKEN_NL_FNC(BCS.CUST_ADDR, 1)), SCE_TOKEN_NL_FNC(BCS.CUST_NM, 2)) AS SHPR2," ).append("\n"); 
		query.append("       DECODE(SCE_TOKEN_NL_FNC(BCS.CUST_ADDR, 1), NULL, DECODE(SCE_TOKEN_NL_FNC(BCS.CUST_ADDR, 2), NULL, SCE_TOKEN_NL_FNC(BCS.CUST_ADDR, 3), SCE_TOKEN_NL_FNC(BCS.CUST_ADDR, 2)), SCE_TOKEN_NL_FNC(BCS.CUST_ADDR, 1)) AS SHPR3," ).append("\n"); 
		query.append("       DECODE(SCE_TOKEN_NL_FNC(BCS.CUST_ADDR, 2), NULL, SCE_TOKEN_NL_FNC(BCS.CUST_ADDR, 3), SCE_TOKEN_NL_FNC(BCS.CUST_ADDR, 2)) AS SHPR4," ).append("\n"); 
		query.append("       SCE_TOKEN_NL_FNC(BCS.CUST_ADDR, 3) AS SHPR5," ).append("\n"); 
		query.append("       DECODE(B.CUST_TO_ORD_FLG, 'Y', SCE_TOKEN_NL_FNC(BCN.CUST_NM, 1), DECODE(SCE_TOKEN_NL_FNC(BCC.CUST_NM, 1), NULL, DECODE(SCE_TOKEN_NL_FNC(BCC.CUST_NM, 2), NULL, DECODE(SCE_TOKEN_NL_FNC(BCC.CUST_ADDR, 1), NULL, DECODE(SCE_TOKEN_NL_FNC(BCC.CUST_ADDR, 2), NULL, SCE_TOKEN_NL_FNC(BCC.CUST_ADDR, 3), SCE_TOKEN_NL_FNC(BCC.CUST_ADDR, 2)), (SCE_TOKEN_NL_FNC(BCC.CUST_ADDR, 1))), SCE_TOKEN_NL_FNC(BCC.CUST_NM, 2)), SCE_TOKEN_NL_FNC(BCC.CUST_NM, 1))) AS CNEE1," ).append("\n"); 
		query.append("       DECODE(SCE_TOKEN_NL_FNC(BCC.CUST_NM, 2), NULL, DECODE(SCE_TOKEN_NL_FNC(BCC.CUST_ADDR, 1), NULL, DECODE(SCE_TOKEN_NL_FNC(BCC.CUST_ADDR, 2), NULL, SCE_TOKEN_NL_FNC(BCC.CUST_ADDR, 3), SCE_TOKEN_NL_FNC(BCC.CUST_ADDR, 2)), SCE_TOKEN_NL_FNC(BCC.CUST_ADDR, 1)), SCE_TOKEN_NL_FNC(BCC.CUST_NM, 2)) AS CNEE2," ).append("\n"); 
		query.append("       DECODE(SCE_TOKEN_NL_FNC(BCC.CUST_ADDR, 1), NULL, DECODE(SCE_TOKEN_NL_FNC(BCC.CUST_ADDR, 2), NULL, SCE_TOKEN_NL_FNC(BCC.CUST_ADDR, 3), SCE_TOKEN_NL_FNC(BCC.CUST_ADDR, 2)), SCE_TOKEN_NL_FNC(BCC.CUST_ADDR, 1)) AS CNEE3," ).append("\n"); 
		query.append("       DECODE(SCE_TOKEN_NL_FNC(BCC.CUST_ADDR, 2), NULL, SCE_TOKEN_NL_FNC(BCC.CUST_ADDR, 3), SCE_TOKEN_NL_FNC(BCC.CUST_ADDR, 2)) AS CNEE4," ).append("\n"); 
		query.append("       SCE_TOKEN_NL_FNC(BCC.CUST_ADDR, 3) AS CNEE5," ).append("\n"); 
		query.append("       DECODE(SCE_TOKEN_NL_FNC(BCN.CUST_NM, 1), NULL, DECODE(SCE_TOKEN_NL_FNC(BCN.CUST_NM, 2), NULL, DECODE(SCE_TOKEN_NL_FNC(BCN.CUST_ADDR, 1), NULL, DECODE(SCE_TOKEN_NL_FNC(BCN.CUST_ADDR, 2), NULL, SCE_TOKEN_NL_FNC(BCN.CUST_ADDR, 3), SCE_TOKEN_NL_FNC(BCN.CUST_ADDR, 2)), (SCE_TOKEN_NL_FNC(BCN.CUST_ADDR, 1))), SCE_TOKEN_NL_FNC(BCN.CUST_NM, 2)), SCE_TOKEN_NL_FNC(BCN.CUST_NM, 1)) AS NTFY1," ).append("\n"); 
		query.append("       DECODE(SCE_TOKEN_NL_FNC(BCN.CUST_NM, 2), NULL, DECODE(SCE_TOKEN_NL_FNC(BCN.CUST_ADDR, 1), NULL, DECODE(SCE_TOKEN_NL_FNC(BCN.CUST_ADDR, 2), NULL, SCE_TOKEN_NL_FNC(BCN.CUST_ADDR, 3), SCE_TOKEN_NL_FNC(BCN.CUST_ADDR, 2)), SCE_TOKEN_NL_FNC(BCN.CUST_ADDR, 1)), SCE_TOKEN_NL_FNC(BCN.CUST_NM, 2)) AS NTFY2," ).append("\n"); 
		query.append("       DECODE(SCE_TOKEN_NL_FNC(BCN.CUST_ADDR, 1), NULL, DECODE(SCE_TOKEN_NL_FNC(BCN.CUST_ADDR, 2), NULL, SCE_TOKEN_NL_FNC(BCN.CUST_ADDR, 3), SCE_TOKEN_NL_FNC(BCN.CUST_ADDR, 2)), SCE_TOKEN_NL_FNC(BCN.CUST_ADDR, 1)) AS NTFY3," ).append("\n"); 
		query.append("       DECODE(SCE_TOKEN_NL_FNC(BCN.CUST_ADDR, 2), NULL, SCE_TOKEN_NL_FNC(BCN.CUST_ADDR, 3), SCE_TOKEN_NL_FNC(BCN.CUST_ADDR, 2)) AS NTFY4," ).append("\n"); 
		query.append("       SCE_TOKEN_NL_FNC(BCN.CUST_ADDR, 3) AS NTFY5," ).append("\n"); 
		query.append("       SCE_TOKEN_NL_FNC(BCA.CUST_NM, 1) AS NTFY21," ).append("\n"); 
		query.append("       SCE_TOKEN_NL_FNC(BCA.CUST_NM, 2) AS NTFY22," ).append("\n"); 
		query.append("       SCE_TOKEN_NL_FNC(BCA.CUST_NM, 3) AS NTFY23," ).append("\n"); 
		query.append("       SCE_TOKEN_NL_FNC(BCA.CUST_NM, 4) AS NTFY24," ).append("\n"); 
		query.append("       SCE_TOKEN_NL_FNC(BCA.CUST_NM, 5) AS NTFY25," ).append("\n"); 
		query.append("       SCE_TOKEN_NL_FNC(BCF.CUST_NM, 1) AS FFWD1," ).append("\n"); 
		query.append("       SCE_TOKEN_NL_FNC(BCF.CUST_NM, 2) AS FFWD2," ).append("\n"); 
		query.append("       SCE_TOKEN_NL_FNC(BCF.CUST_NM, 3) AS FFWD3," ).append("\n"); 
		query.append("       SCE_TOKEN_NL_FNC(BCF.CUST_NM, 4) AS FFWD4," ).append("\n"); 
		query.append("       SCE_TOKEN_NL_FNC(BCF.CUST_NM, 5) AS FFWD5," ).append("\n"); 
		query.append("       SCE_TOKEN_NL_FNC(BCE.CUST_NM, 1) AS EXPO1," ).append("\n"); 
		query.append("       SCE_TOKEN_NL_FNC(BCE.CUST_NM, 2) AS EXPO2," ).append("\n"); 
		query.append("       SCE_TOKEN_NL_FNC(BCE.CUST_NM, 3) AS EXPO3," ).append("\n"); 
		query.append("       SCE_TOKEN_NL_FNC(BCE.CUST_NM, 4) AS EXPO4," ).append("\n"); 
		query.append("       SCE_TOKEN_NL_FNC(BCE.CUST_NM, 5) AS EXPO5," ).append("\n"); 
		query.append("       NVL(BL.BL_CPY_KNT, 0) AS BLCOPY," ).append("\n"); 
		query.append("       '1' AS BLORG," ).append("\n"); 
		query.append("       NVL(DOC.PCK_QTY, 0) AS BLPKG," ).append("\n"); 
		query.append("       NVL(DOC.PCK_TP_CD, '') AS BLPKGU," ).append("\n"); 
		query.append("       DECODE(NVL(DOC.WGT_UT_CD, ''), 'LBS', ROUND(NVL(DOC.ACT_WGT, 0)*0.4536, 3), NVL(DOC.ACT_WGT, 0)) AS BLWGT," ).append("\n"); 
		query.append("       DECODE(NVL(DOC.MEAS_UT_CD, ''), 'CBF', ROUND(NVL(DOC.MEAS_QTY, 0)*0.0283, 3), NVL(DOC.MEAS_QTY, 0)) AS BLMEA," ).append("\n"); 
		query.append("       NVL(B.RCV_TERM_CD, '')||NVL(B.DE_TERM_CD, '') AS RDTYPE," ).append("\n"); 
		query.append("       NVL(B.BKG_CGO_TP_CD, '') AS CARGOTYPE," ).append("\n"); 
		query.append("       NVL(CMD.CMDT_NM, '') AS COMMODITY," ).append("\n"); 
		query.append("       TRANSLATE(NVL(B.XTER_RMK, ' '), CHR(10), ' ') AS XTER_RMK," ).append("\n"); 
		query.append("       '' AS AUS_QUAR," ).append("\n"); 
		query.append("       NVL(B.BKG_NO, '') AS BKG_NO," ).append("\n"); 
		query.append("       NVL(B.BKG_CGO_TP_CD, '') AS BKG_CGO_TP_CD," ).append("\n"); 
		query.append("       DECODE(NVL(B.DCGO_FLG, ''), 'N', '0', 'Y', '1') AS BKG_SPE_DG," ).append("\n"); 
		query.append("       DECODE(NVL(B.RC_FLG, ''), 'N', '0', 'Y', '1') AS BKG_SPE_RF," ).append("\n"); 
		query.append("       DECODE(NVL(B.AWK_CGO_FLG, ''), 'N', '0', 'Y', '1') AS BKG_SPE_AK," ).append("\n"); 
		query.append("       DECODE(NVL(B.BB_CGO_FLG, ''), 'N', '0', 'Y', '1') AS BKG_SPE_BB," ).append("\n"); 
		query.append("       DECODE(NVL(B.RD_CGO_FLG, ''), 'N', '0', 'Y', '1') AS BKG_SPE_RD," ).append("\n"); 
		query.append("       NVL(B.REP_CMDT_CD, '') AS CMDT_CD," ).append("\n"); 
		query.append("       TRANSLATE(NVL(COM.REP_CMDT_NM, ' '), CHR(10), ' ') AS CMDT_DESC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_BOOKING B," ).append("\n"); 
		query.append("       MDM_ORGANIZATION E," ).append("\n"); 
		query.append("       MDM_REP_CMDT COM," ).append("\n"); 
		query.append("       MDM_COMMODITY CMD," ).append("\n"); 
		query.append("       BKG_VVD VVD," ).append("\n"); 
		query.append("       BKG_BL_ISS BL," ).append("\n"); 
		query.append("       BKG_RATE RATE," ).append("\n"); 
		query.append("       BKG_BL_DOC DOC," ).append("\n"); 
		query.append("       BKG_CUSTOMER BCC," ).append("\n"); 
		query.append("       BKG_CUSTOMER BCS," ).append("\n"); 
		query.append("       BKG_CUSTOMER BCN," ).append("\n"); 
		query.append("       BKG_CUSTOMER BCA," ).append("\n"); 
		query.append("       BKG_CUSTOMER BCF," ).append("\n"); 
		query.append("       BKG_CUSTOMER BCE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE VVD.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("   AND VVD.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND VVD.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("#if (${pol_cd}!= '')" ).append("\n"); 
		query.append("   AND VVD.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd}!= '')" ).append("\n"); 
		query.append("   AND VVD.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND B.BKG_STS_CD != 'X'" ).append("\n"); 
		query.append("   AND B.BKG_STS_CD != 'S'" ).append("\n"); 
		query.append("   AND B.REP_CMDT_CD = COM.REP_CMDT_CD(+)" ).append("\n"); 
		query.append("   AND B.CMDT_CD = CMD.CMDT_CD(+)" ).append("\n"); 
		query.append("   AND B.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("   AND B.BKG_NO = BL.BKG_NO(+)" ).append("\n"); 
		query.append("   AND BL.OBL_ISS_OFC_CD = E.OFC_CD(+)" ).append("\n"); 
		query.append("   AND B.BKG_NO = RATE.BKG_NO(+)" ).append("\n"); 
		query.append("   AND B.BKG_NO = DOC.BKG_NO" ).append("\n"); 
		query.append("   AND BCC.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("   AND B.BKG_NO=BCC.BKG_NO(+)" ).append("\n"); 
		query.append("   AND B.BKG_NO=BCS.BKG_NO" ).append("\n"); 
		query.append("   AND BCS.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("   AND B.BKG_NO=BCN.BKG_NO(+)" ).append("\n"); 
		query.append("   AND BCN.BKG_CUST_TP_CD(+) = 'N'" ).append("\n"); 
		query.append("   AND B.BKG_NO=BCA.BKG_NO(+)" ).append("\n"); 
		query.append("   AND BCA.BKG_CUST_TP_CD(+) = 'A'" ).append("\n"); 
		query.append("   AND B.BKG_NO=BCF.BKG_NO(+)" ).append("\n"); 
		query.append("   AND BCF.BKG_CUST_TP_CD(+) = 'F'" ).append("\n"); 
		query.append("   AND B.BKG_NO=BCE.BKG_NO(+)" ).append("\n"); 
		query.append("   AND BCE.BKG_CUST_TP_CD(+) = 'E'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" ORDER BY B.BL_NO" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : IndonesiaCustomsTransmissionDBDAOsearchManifestDetail1ListByOpt02RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.indonesia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IndonesiaCustomsTransmissionDBDAOsearchManifestDetail1ListByOpt02RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchManifestDetail1ListByOpt02
	  * </pre>
	  */
	public IndonesiaCustomsTransmissionDBDAOsearchManifestDetail1ListByOpt02RSQL(){
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
		params.put("bound_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mf_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.indonesia.integration").append("\n"); 
		query.append("FileName : IndonesiaCustomsTransmissionDBDAOsearchManifestDetail1ListByOpt02RSQL").append("\n"); 
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
		query.append("SELECT E.VSL_ENG_NM AS DTL_VSL_ENG_NM," ).append("\n"); 
		query.append("       E.CALL_SGN_NO AS DTL_CALL_SGN_NO," ).append("\n"); 
		query.append("       B.VSL_CD AS DTL_VSL_CD," ).append("\n"); 
		query.append("       B.SKD_VOY_NO AS DTL_SKD_VOY_NO," ).append("\n"); 
		query.append("       B.SKD_DIR_CD AS DTL_SKD_DIR_CD," ).append("\n"); 
		query.append("       DECODE(C.BKG_NO, NULL, 'MSG:' || B.BKG_NO, B.BKG_NO) AS BKG_NO," ).append("\n"); 
		query.append("       B.BL_NO," ).append("\n"); 
		query.append("       B.POR_CD," ).append("\n"); 
		query.append("       B.POL_CD," ).append("\n"); 
		query.append("       B.POD_CD," ).append("\n"); 
		query.append("       B.DEL_CD," ).append("\n"); 
		query.append("       TO_CHAR(C.OBL_ISS_DT, 'YYYYMMDD') AS OBL_ISS_DT," ).append("\n"); 
		query.append("#if (${bound_cd} == 'I')" ).append("\n"); 
		query.append("       LTRIM(TO_CHAR(NVL(D.PCK_QTY,0), '99999999')) AS PCK_QTY," ).append("\n"); 
		query.append("#elseif(${bound_cd} == 'O')" ).append("\n"); 
		query.append("       LTRIM(TO_CHAR(NVL(D.PCK_QTY,0), '00000000')) AS PCK_QTY," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("       DECODE(PKG.CSTMS_PCK_TP_CD, NULL, decode(D.PCK_TP_CD, null, 'PK', D.PCK_TP_CD), PKG.CSTMS_PCK_TP_CD) AS PCK_TP_CD," ).append("\n"); 
		query.append("       REPLACE(LTRIM(TO_CHAR(NVL(D.ACT_WGT,0), '00000000000000.0000')), '.', '') AS ACT_WGT," ).append("\n"); 
		query.append("       D.WGT_UT_CD," ).append("\n"); 
		query.append("       REPLACE(LTRIM(TO_CHAR(NVL(D.MEAS_QTY,0), '00000000000000.0000')), '.', '') AS MEAS_QTY," ).append("\n"); 
		query.append("       D.MEAS_UT_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_VVD A," ).append("\n"); 
		query.append("       BKG_BOOKING B," ).append("\n"); 
		query.append("       BKG_BL_ISS C," ).append("\n"); 
		query.append("       BKG_BL_DOC D," ).append("\n"); 
		query.append("       MDM_VSL_CNTR E," ).append("\n"); 
		query.append("       BKG_CSTMS_PCK_TP_CONV PKG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${bound_cd} == 'I')" ).append("\n"); 
		query.append("   AND @[mf_tp_cd] = '02I'" ).append("\n"); 
		query.append("#elseif (${bound_cd} == 'O')" ).append("\n"); 
		query.append("   AND @[mf_tp_cd] = '04E'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND A.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("   AND A.POL_CD = NVL(@[pol_cd], A.POL_CD)" ).append("\n"); 
		query.append("   AND A.POD_CD = NVL(@[pod_cd], A.POD_CD)" ).append("\n"); 
		query.append("   AND B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("   AND B.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("   AND B.BKG_CGO_TP_CD IN ('F', 'R', 'B')" ).append("\n"); 
		query.append("   AND 1 = (CASE WHEN @[bound_cd] = 'O' AND B.POL_CD <> A.POL_CD THEN 1" ).append("\n"); 
		query.append("                 WHEN @[bound_cd] = 'I' AND B.POD_CD <> A.POD_CD THEN 1" ).append("\n"); 
		query.append("                 ELSE 0" ).append("\n"); 
		query.append("            END)" ).append("\n"); 
		query.append("   AND C.BKG_NO(+) = B.BKG_NO" ).append("\n"); 
		query.append("   AND D.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("   AND B.VSL_CD = E.VSL_CD" ).append("\n"); 
		query.append("   AND EXISTS (SELECT '*'" ).append("\n"); 
		query.append("                 FROM BKG_CONTAINER E" ).append("\n"); 
		query.append("                WHERE E.BKG_NO = B.BKG_NO)" ).append("\n"); 
		query.append("   AND D.PCK_TP_CD = PKG.PCK_TP_CD(+)" ).append("\n"); 
		query.append("   AND PKG.CNT_CD(+) = 'ID'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bound_cd} == 'I' || ${bound_cd} == 'O')" ).append("\n"); 
		query.append(" ORDER BY BL_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
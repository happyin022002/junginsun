/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : IndonesiaCustomsTransmissionDBDAOsearchManifestDetail1ListByOpt01RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.09
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.11.09 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.indonesia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IndonesiaCustomsTransmissionDBDAOsearchManifestDetail1ListByOpt01RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchManifestDetail1ListByOpt01
	  * </pre>
	  */
	public IndonesiaCustomsTransmissionDBDAOsearchManifestDetail1ListByOpt01RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mf_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.indonesia.integration").append("\n"); 
		query.append("FileName : IndonesiaCustomsTransmissionDBDAOsearchManifestDetail1ListByOpt01RSQL").append("\n"); 
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
		query.append("SELECT B.*," ).append("\n"); 
		query.append("       CASE WHEN B.CM_PCK_CNT >=2 THEN 'PK' " ).append("\n"); 
		query.append("                                  ELSE CM_PCK_TP_CD" ).append("\n"); 
		query.append("                                  END AS PCK_TP_CD" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("       E.VSL_ENG_NM DTL_VSL_ENG_NM, " ).append("\n"); 
		query.append("       E.CALL_SGN_NO DTL_CALL_SGN_NO, " ).append("\n"); 
		query.append("       B.VSL_CD DTL_VSL_CD, " ).append("\n"); 
		query.append("       B.SKD_VOY_NO DTL_SKD_VOY_NO, " ).append("\n"); 
		query.append("       B.SKD_DIR_CD DTL_SKD_DIR_CD," ).append("\n"); 
		query.append("       B.BKG_NO BKG_NO," ).append("\n"); 
		query.append("       B.BL_NO BL_NO," ).append("\n"); 
		query.append("       B.POR_CD POR_CD, " ).append("\n"); 
		query.append("       B.POL_CD POL_CD, " ).append("\n"); 
		query.append("       B.POD_CD POD_CD, " ).append("\n"); 
		query.append("       B.DEL_CD DEL_CD," ).append("\n"); 
		query.append("       TO_CHAR(C.OBL_ISS_DT, 'YYYYMMDD') OBL_ISS_DT," ).append("\n"); 
		query.append("#if (${bound_cd} == 'I') " ).append("\n"); 
		query.append("       (SELECT LTRIM(TO_CHAR(NVL(SUM(PCK_QTY),0),'99999999')) " ).append("\n"); 
		query.append("        FROM BKG_CNTR_MF_DESC" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND BKG_NO = B.BKG_NO) PCK_QTY," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bound_cd} == 'O') " ).append("\n"); 
		query.append("       (SELECT LTRIM(TO_CHAR(NVL(SUM(PCK_QTY),0),'00000000')) " ).append("\n"); 
		query.append("        FROM BKG_CNTR_MF_DESC" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND BKG_NO = B.BKG_NO) PCK_QTY," ).append("\n"); 
		query.append("#end       " ).append("\n"); 
		query.append("        (SELECT NVL(COUNT(DISTINCT(PCK_TP_CD)),0)" ).append("\n"); 
		query.append("         FROM BKG_CNTR_MF_DESC A" ).append("\n"); 
		query.append("         WHERE A.BKG_NO(+) =B.BKG_NO) CM_PCK_CNT," ).append("\n"); 
		query.append("        (SELECT NVL(PKG.CSTMS_PCK_TP_CD,A.PCK_TP_CD)" ).append("\n"); 
		query.append("         FROM BKG_CNTR_MF_DESC A, BKG_CSTMS_PCK_TP_CONV PKG" ).append("\n"); 
		query.append("         WHERE A.BKG_NO =B.BKG_NO" ).append("\n"); 
		query.append("         AND PKG.PCK_TP_CD(+) =A.PCK_TP_CD" ).append("\n"); 
		query.append("         AND PKG.CNT_CD(+) = 'ID'" ).append("\n"); 
		query.append("         AND ROWNUM=1) CM_PCK_TP_CD," ).append("\n"); 
		query.append("       REPLACE(LTRIM(TO_CHAR(NVL(D.ACT_WGT,0), '00000000000000.0000')), '.', '') ACT_WGT, " ).append("\n"); 
		query.append("       D.WGT_UT_CD WGT_UT_CD," ).append("\n"); 
		query.append("       REPLACE(LTRIM(TO_CHAR(NVL(D.MEAS_QTY,0), '00000000000000.0000')), '.', '') MEAS_QTY, " ).append("\n"); 
		query.append("       D.MEAS_UT_CD MEAS_UT_CD" ).append("\n"); 
		query.append("  FROM BKG_VVD A, BKG_BOOKING B, BKG_BL_ISS C, BKG_BL_DOC D, MDM_VSL_CNTR E" ).append("\n"); 
		query.append("#if (${bound_cd} == 'I')" ).append("\n"); 
		query.append(" WHERE @[mf_tp_cd] = '01I'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bound_cd} == 'O') " ).append("\n"); 
		query.append(" WHERE (@[mf_tp_cd] = '09E' OR @[mf_tp_cd] = '10E')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND A.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("   AND A.POL_CD = NVL(@[pol_cd], A.POL_CD)" ).append("\n"); 
		query.append("   AND A.POD_CD = NVL(@[pod_cd], A.POD_CD)" ).append("\n"); 
		query.append("   AND B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("   AND B.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("   AND B.BKG_CGO_TP_CD IN ('F', 'R', 'B')" ).append("\n"); 
		query.append("   AND B.POL_CD = NVL(@[pol_cd], B.POL_CD)" ).append("\n"); 
		query.append("#if (${bound_cd} == 'I')" ).append("\n"); 
		query.append("   AND B.POD_CD = NVL(@[pod_cd], B.POD_CD)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND B.VSL_CD = E.VSL_CD" ).append("\n"); 
		query.append("   AND C.BKG_NO(+) = B.BKG_NO" ).append("\n"); 
		query.append("   AND D.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("   AND EXISTS (SELECT '*'" ).append("\n"); 
		query.append("                 FROM BKG_CONTAINER E" ).append("\n"); 
		query.append("                WHERE E.BKG_NO = B.BKG_NO)" ).append("\n"); 
		query.append(" ORDER BY BL_NO) B" ).append("\n"); 

	}
}
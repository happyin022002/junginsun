/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : IndonesiaCustomsTransmissionDBDAOsearchManifestDetail1ListByOpt03RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.14
*@LastModifier : 
*@LastVersion : 1.0
* 2010.12.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.indonesia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IndonesiaCustomsTransmissionDBDAOsearchManifestDetail1ListByOpt03RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchManifestDetail1ListByOpt03
	  * </pre>
	  */
	public IndonesiaCustomsTransmissionDBDAOsearchManifestDetail1ListByOpt03RSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.indonesia.integration").append("\n"); 
		query.append("FileName : IndonesiaCustomsTransmissionDBDAOsearchManifestDetail1ListByOpt03RSQL").append("\n"); 
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
		query.append("SELECT '' DTL_VSL_ENG_NM, " ).append("\n"); 
		query.append("       '' DTL_CALL_SGN_NO, " ).append("\n"); 
		query.append("       '' DTL_VSL_CD, " ).append("\n"); 
		query.append("       '' DTL_SKD_VOY_NO, " ).append("\n"); 
		query.append("       '' DTL_SKD_DIR_CD," ).append("\n"); 
		query.append("	   DECODE(C.BKG_NO, NULL, 'MSG:' || B.BKG_NO, B.BKG_NO) BKG_NO," ).append("\n"); 
		query.append("       B.BL_NO BL_NO," ).append("\n"); 
		query.append("       B.POR_CD POR_CD, " ).append("\n"); 
		query.append("       B.POL_CD POL_CD, " ).append("\n"); 
		query.append("       B.POD_CD POD_CD, " ).append("\n"); 
		query.append("       B.DEL_CD DEL_CD," ).append("\n"); 
		query.append("       TO_CHAR(C.OBL_ISS_DT, 'YYYYMMDD') OBL_ISS_DT," ).append("\n"); 
		query.append("#if (${bound_cd} == 'I') " ).append("\n"); 
		query.append("       LTRIM(TO_CHAR(NVL(D.PCK_QTY,0), '99999999')) PCK_QTY, " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bound_cd} == 'O') " ).append("\n"); 
		query.append("       LTRIM(TO_CHAR(NVL(D.PCK_QTY,0), '00000000')) PCK_QTY, " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       D.PCK_TP_CD PCK_TP_CD," ).append("\n"); 
		query.append("       REPLACE(LTRIM(TO_CHAR(NVL(D.ACT_WGT,0), '00000000000000.0000')), '.', '') ACT_WGT, " ).append("\n"); 
		query.append("       D.WGT_UT_CD WGT_UT_CD," ).append("\n"); 
		query.append("       REPLACE(LTRIM(TO_CHAR(NVL(D.MEAS_QTY,0), '00000000000000.0000')), '.', '') MEAS_QTY, " ).append("\n"); 
		query.append("       D.MEAS_UT_CD MEAS_UT_CD" ).append("\n"); 
		query.append("  FROM BKG_VVD A, BKG_BOOKING B, BKG_BL_ISS C, BKG_BL_DOC D," ).append("\n"); 
		query.append("       (SELECT DECODE(@[bound_cd], 'O', @[pol_cd], @[pod_cd]) AS PORT_CD" ).append("\n"); 
		query.append("          FROM DUAL" ).append("\n"); 
		query.append("       ) G" ).append("\n"); 
		query.append("#if (${bound_cd} == 'I') " ).append("\n"); 
		query.append(" WHERE @[mf_tp_cd] = '03I'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bound_cd} == 'O') " ).append("\n"); 
		query.append(" WHERE @[mf_tp_cd] = '05E'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND A.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("   AND 1 = (CASE WHEN @[bound_cd] = 'O' AND A.POD_CD = NVL(@[pod_cd], A.POD_CD) THEN 1" ).append("\n"); 
		query.append("                 WHEN @[bound_cd] = 'I' AND A.POL_CD = NVL(@[pol_cd], A.POL_CD) THEN 1" ).append("\n"); 
		query.append("                 ELSE 0" ).append("\n"); 
		query.append("            END)  " ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("   AND A.POL_CD <> G.PORT_CD" ).append("\n"); 
		query.append("   AND A.POD_CD <> G.PORT_CD" ).append("\n"); 
		query.append("   AND 1 = (SELECT -- Indonesia Port가 POL과 POD 사이에 있음, CLPT_SEQ로 비교" ).append("\n"); 
		query.append("                   CASE WHEN MAX(DECODE(E.VPS_PORT_CD, A.POL_CD, E.CLPT_SEQ, NULL)) < MAX(DECODE(E.VPS_PORT_CD, G.PORT_CD, E.CLPT_SEQ, NULL)) AND" ).append("\n"); 
		query.append("                             MAX(DECODE(E.VPS_PORT_CD, G.PORT_CD, E.CLPT_SEQ, NULL)) < MAX(DECODE(E.VPS_PORT_CD, A.POD_CD, E.CLPT_SEQ, NULL)) THEN 1" ).append("\n"); 
		query.append("                        ELSE 0" ).append("\n"); 
		query.append("                   END" ).append("\n"); 
		query.append("                 FROM VSK_VSL_PORT_SKD E" ).append("\n"); 
		query.append("                WHERE E.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("                  AND E.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                  AND E.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                  AND E.VPS_PORT_CD IN (A.POL_CD, A.POD_CD, G.PORT_CD))" ).append("\n"); 
		query.append("   AND B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("   AND B.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("   AND B.BKG_CGO_TP_CD IN ('F', 'R', 'B')" ).append("\n"); 
		query.append("   AND C.BKG_NO(+) = B.BKG_NO" ).append("\n"); 
		query.append("   AND D.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("   AND EXISTS (SELECT '*'" ).append("\n"); 
		query.append("                 FROM BKG_CONTAINER F" ).append("\n"); 
		query.append("                WHERE F.BKG_NO = B.BKG_NO)" ).append("\n"); 
		query.append("#if (${bound_cd} == 'I') " ).append("\n"); 
		query.append(" ORDER BY BL_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bound_cd} == 'O') " ).append("\n"); 
		query.append(" ORDER BY BL_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : IndonesiaCustomsTransmissionDBDAOsearchManifestDetail1ListByOpt01RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.21
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.21 
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
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("       LTRIM(TO_CHAR(NVL(D.PCK_QTY,0), '99999999')) PCK_QTY, " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bound_cd} == 'O') " ).append("\n"); 
		query.append("       LTRIM(TO_CHAR(NVL(D.PCK_QTY,0), '00000000')) PCK_QTY, " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       NVL(D.PCK_TP_CD,'PK') PCK_TP_CD," ).append("\n"); 
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
		query.append(" ORDER BY BL_NO" ).append("\n"); 

	}
}
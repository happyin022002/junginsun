/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpecialManifestDBDAOserachVslAtCommonRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.27
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2015.11.27 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Minjung Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialManifestDBDAOserachVslAtCommonRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lloyd, vessel name등 Vessel 정보를 조회해옴(Booking 쪽 data)
	  * </pre>
	  */
	public SpecialManifestDBDAOserachVslAtCommonRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("d_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration").append("\n"); 
		query.append("FileName : SpecialManifestDBDAOserachVslAtCommonRSQL").append("\n"); 
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
		query.append("SELECT @[d_type] AS D_TYPE" ).append("\n"); 
		query.append("      ,@[vvd_cd] AS VVD_CD" ).append("\n"); 
		query.append("      ,@[port_cd] AS PORT_CD" ).append("\n"); 
		query.append("      ,B.VSL_CD" ).append("\n"); 
		query.append("      ,B.VSL_ENG_NM" ).append("\n"); 
		query.append("	  ,B.VSL_RGST_CNT_CD AS VSL_CNT_CD" ).append("\n"); 
		query.append("      ,B.LLOYD_NO" ).append("\n"); 
		query.append("      ,B.CALL_SGN_NO" ).append("\n"); 
		query.append("      ,NVL(TO_CHAR(A.VPS_ETA_DT, 'YYYYMMDD'), '')   AS ETA_D  --Arrival DATE" ).append("\n"); 
		query.append("      ,NVL(TO_CHAR(A.VPS_ETA_DT, 'HH24MM'), '')     AS ETA_T  --Arrival TIME" ).append("\n"); 
		query.append("      ,NVL(TO_CHAR(A.VPS_ETD_DT,'YYYYMMDD'),' ')    AS ETD_D  --Departure DATE" ).append("\n"); 
		query.append("      ,NVL(TO_CHAR(A.VPS_ETD_DT,'HH24MM'),' ')      AS ETD_T  --Departure TIME" ).append("\n"); 
		query.append("      ,A.YD_CD AS BRTH_YD_CD                                  --Berth" ).append("\n"); 
		query.append("      ,(SELECT YD_NM AS YD_NAME" ).append("\n"); 
		query.append("          FROM MDM_YARD" ).append("\n"); 
		query.append("         WHERE YD_CD = A.YD_CD" ).append("\n"); 
		query.append("       ) YD_NM" ).append("\n"); 
		query.append("      ,CASE WHEN SUBSTR(@[ofc_cd], 1, 3) = 'ANR'" ).append("\n"); 
		query.append("            THEN (SELECT SVC_RQST_NO" ).append("\n"); 
		query.append("                    FROM BKG_CSTMS_ANR_VVD" ).append("\n"); 
		query.append("                   WHERE VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                     AND SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                     AND SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("            WHEN SUBSTR(@[ofc_cd], 1, 3) = 'FXT'" ).append("\n"); 
		query.append("            THEN (SELECT UQ_VSL_ID_NO" ).append("\n"); 
		query.append("                    FROM BKG_VSL_DCHG_YD" ).append("\n"); 
		query.append("                   WHERE VSL_CD              =  SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                     AND SKD_VOY_NO          =  SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                     AND SKD_DIR_CD          =  SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                     AND PORT_CD             =  @[port_cd]" ).append("\n"); 
		query.append("                     AND CLPT_IND_SEQ        =  '1'" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("            WHEN NVL(@[port_cd],'X') = 'FRFOS'" ).append("\n"); 
		query.append("            THEN (SELECT UQ_VSL_ID_NO" ).append("\n"); 
		query.append("                    FROM BKG_VSL_DCHG_YD" ).append("\n"); 
		query.append("                   WHERE VSL_CD              =  SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                     AND SKD_VOY_NO          =  SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                     AND SKD_DIR_CD          =  SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                     AND PORT_CD             =  @[port_cd]" ).append("\n"); 
		query.append("                     AND CLPT_IND_SEQ        =  '1'" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("            WHEN NVL(@[port_cd],'X') = 'NLRTM'" ).append("\n"); 
		query.append("            THEN (SELECT MAX(NVL(VSL_CALL_REF_NO,''))" ).append("\n"); 
		query.append("                    FROM BKG_CSTMS_RTM_VSL" ).append("\n"); 
		query.append("                   WHERE VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                     AND SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                     AND SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                     AND VSL_CALL_REF_NO LIKE 'NLRTM%'" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("            ELSE ''" ).append("\n"); 
		query.append("        END SVC_RQST_NO" ).append("\n"); 
		query.append("      ,'N' AS LOCAL_DB_YN" ).append("\n"); 
		query.append("  FROM VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("      ,MDM_VSL_CNTR B" ).append("\n"); 
		query.append(" WHERE A.VSL_CD        =  SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO    =  SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD    =  SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("   AND A.VPS_PORT_CD   =  @[port_cd]" ).append("\n"); 
		query.append("   AND NVL(A.SKD_CNG_STS_CD, ' ')    <> 'S'" ).append("\n"); 
		query.append("   AND A.VSL_CD        =  B.VSL_CD" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}
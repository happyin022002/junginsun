/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CndExpCustomsTransmissionDBDAOsearchVesselDepartureRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.12.13
*@LastModifier : 
*@LastVersion : 1.0
* 2017.12.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndExpCustomsTransmissionDBDAOsearchVesselDepartureRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchVesselArrival
	  * </pre>
	  */
	public CndExpCustomsTransmissionDBDAOsearchVesselDepartureRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crw_knt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.integration").append("\n"); 
		query.append("FileName : CndExpCustomsTransmissionDBDAOsearchVesselDepartureRSQL").append("\n"); 
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
		query.append("SELECT  TO_CHAR(A.VSL_SFT_CSTRU_CERTI_EXP_DT,'YYYYMMDD') AS VSL_SFT_CSTRU_CERTI_EXP_DT" ).append("\n"); 
		query.append("       ,TO_CHAR(A.VSL_SFT_RDO_CERTI_EXP_DT  ,'YYYYMMDD') AS VSL_SFT_RDO_CERTI_EXP_DT" ).append("\n"); 
		query.append("       ,TO_CHAR(A.VSL_SFT_EQ_CERTI_EXP_DT   ,'YYYYMMDD') AS VSL_SFT_EQ_CERTI_EXP_DT" ).append("\n"); 
		query.append("       ,TO_CHAR(A.VSL_LOD_LINE_CERTI_EXP_DT ,'YYYYMMDD') AS VSL_LOD_LINE_CERTI_EXP_DT" ).append("\n"); 
		query.append("       ,TO_CHAR(A.VSL_DERAT_CERTI_EXP_DT    ,'YYYYMMDD') AS VSL_DERAT_CERTI_EXP_DT" ).append("\n"); 
		query.append("       ,A.LLOYD_NO" ).append("\n"); 
		query.append("       ,A.VSL_ENG_NM" ).append("\n"); 
		query.append("       ,A.VSL_RGST_CNT_CD" ).append("\n"); 
		query.append("       ,D.LOC_NM AS RGST_PORT_CD" ).append("\n"); 
		query.append("       ,A.RGST_NO" ).append("\n"); 
		query.append("       ,A.NET_RGST_TONG_WGT" ).append("\n"); 
		query.append("       ,A.GRS_RGST_TONG_WGT" ).append("\n"); 
		query.append("       ,A.DWT_WGT" ).append("\n"); 
		query.append("       ,A.LOA_LEN " ).append("\n"); 
		query.append("       ,NVL(@[crw_knt],'') AS CRW_KNT" ).append("\n"); 
		query.append("       ,TO_CHAR(A.RGST_DT, 'YYYYMMDDHHMI') AS RGST_DT" ).append("\n"); 
		query.append("       ,DECODE(B.CND_ACK_CTRL_NO" ).append("\n"); 
		query.append("               , NULL" ).append("\n"); 
		query.append("               , TO_CHAR(SYSDATE,'YMM')||LTRIM(TO_CHAR(BKG_CSTM_EDI_SEQ.NEXTVAL,'000009'),' ') /* BKG_CSTM_EDI_SEQ 6자리 변경으로 YMMDD를 YMM 3자리로 변경 함 총 9자리 */" ).append("\n"); 
		query.append("               , B.CND_ACK_CTRL_NO" ).append("\n"); 
		query.append("              ) AS CND_ACK_CTRL_NO" ).append("\n"); 
		query.append("       ,B.CVY_REF_NO" ).append("\n"); 
		query.append("       ,B.CAP_NM" ).append("\n"); 
		query.append("       ,TO_CHAR(B.ETD_DT, 'YYYYMMDDHHMI') AS ETD_DT" ).append("\n"); 
		query.append("       ,CASE WHEN A.VSL_SFT_CSTRU_CERTI_EXP_DT IS NULL THEN 'Safety Construction' " ).append("\n"); 
		query.append("             WHEN A.VSL_SFT_RDO_CERTI_EXP_DT IS NULL THEN 'Safety Radio'" ).append("\n"); 
		query.append("             WHEN A.VSL_SFT_EQ_CERTI_EXP_DT IS NULL THEN 'Safety Equipment'" ).append("\n"); 
		query.append("             WHEN A.VSL_LOD_LINE_CERTI_EXP_DT IS NULL THEN 'Loadline'" ).append("\n"); 
		query.append("             WHEN A.VSL_DERAT_CERTI_EXP_DT IS NULL THEN 'Derat'" ).append("\n"); 
		query.append("             ELSE ''" ).append("\n"); 
		query.append("        END DT_NULL_CHK" ).append("\n"); 
		query.append("       ,CASE WHEN TO_CHAR(C.VPS_ETD_DT,'YYYYMMDD') > TO_CHAR(A.VSL_SFT_CSTRU_CERTI_EXP_DT,'YYYYMMDD') THEN 'Safety Construction' " ).append("\n"); 
		query.append("             WHEN TO_CHAR(C.VPS_ETD_DT,'YYYYMMDD') > TO_CHAR(A.VSL_SFT_RDO_CERTI_EXP_DT,'YYYYMMDD') THEN 'Safety Radio'" ).append("\n"); 
		query.append("             WHEN TO_CHAR(C.VPS_ETD_DT,'YYYYMMDD') > TO_CHAR(A.VSL_SFT_EQ_CERTI_EXP_DT,'YYYYMMDD') THEN 'Safety Equipment'" ).append("\n"); 
		query.append("             WHEN TO_CHAR(C.VPS_ETD_DT,'YYYYMMDD') > TO_CHAR(A.VSL_LOD_LINE_CERTI_EXP_DT,'YYYYMMDD') THEN 'Loadline'" ).append("\n"); 
		query.append("             WHEN TO_CHAR(C.VPS_ETD_DT,'YYYYMMDD') > TO_CHAR(A.VSL_DERAT_CERTI_EXP_DT,'YYYYMMDD') THEN 'Derat'" ).append("\n"); 
		query.append("             ELSE ''" ).append("\n"); 
		query.append("        END DT_DIFF_CHK" ).append("\n"); 
		query.append("       ,C.VPS_ETA_DT" ).append("\n"); 
		query.append("       ,B.CND_ACK_SUB_CD" ).append("\n"); 
		query.append("       ,B.CND_ACK_RSPN_CD" ).append("\n"); 
		query.append("       ,B.VSL_DEP_RPT_SND_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       ,NVL((" ).append("\n"); 
		query.append("         SELECT  TO_CHAR(D.ACT_ARR_DT,'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("           FROM  VSK_ACT_PORT_SKD  D" ).append("\n"); 
		query.append("          WHERE  D.VSL_CD = A.VSL_CD " ).append("\n"); 
		query.append("            AND  D.SKD_VOY_NO = CASE WHEN C.TURN_PORT_IND_CD IN ('Y', 'N') THEN C.SKD_VOY_NO ELSE C.TURN_SKD_VOY_NO END" ).append("\n"); 
		query.append("            AND  D.SKD_DIR_CD = CASE WHEN C.TURN_PORT_IND_CD IN ('Y', 'N') THEN C.SKD_DIR_CD ELSE C.TURN_SKD_DIR_CD END" ).append("\n"); 
		query.append("            AND  D.VPS_PORT_CD = C.VPS_PORT_CD" ).append("\n"); 
		query.append("        ),  TO_CHAR(C.VPS_ETA_DT,'YYYY-MM-DD HH24:MI'))	AS ACT_ARR_DT" ).append("\n"); 
		query.append("       ,'' AS STATUS" ).append("\n"); 
		query.append("       ,@[pol_cd]                                                      AS POL_CD" ).append("\n"); 
		query.append("       ,(SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = @[pol_cd])     AS POL_NM" ).append("\n"); 
		query.append("       ,C.VPS_PORT_CD                                                  AS POD_CD" ).append("\n"); 
		query.append("       ,(SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = C.VPS_PORT_CD) AS POD_NM" ).append("\n"); 
		query.append("       ,B.VSL_CD AS VSL_CD" ).append("\n"); 
		query.append("       ,B.SKD_VOY_NO AS SKD_VOY_NO" ).append("\n"); 
		query.append("       ,B.SKD_DIR_CD AS SKD_DIR_CD" ).append("\n"); 
		query.append("       ,'' AS CGO_WGT" ).append("\n"); 
		query.append("       ,'' AS TEU_FUL" ).append("\n"); 
		query.append("       ,'' AS FEU_FUL" ).append("\n"); 
		query.append("       ,'' AS OTH_FUL" ).append("\n"); 
		query.append("       ,'' AS TEU_MTY" ).append("\n"); 
		query.append("       ,'' AS FEU_MTY" ).append("\n"); 
		query.append("       ,'' AS OTH_MTY" ).append("\n"); 
		query.append("       ,'' AS VPS_PORT_CD" ).append("\n"); 
		query.append("       ,'' AS DEL_FLAG" ).append("\n"); 
		query.append("       ,'' AS BL_NO" ).append("\n"); 
		query.append("       ,'22' AS CC_TRANS /* 21 - Vessel Import (Inward)    22 - Vessel Export (Outward)    23 - Vessel In-Transit  */" ).append("\n"); 
		query.append("  FROM  MDM_VSL_CNTR A" ).append("\n"); 
		query.append("       ,BKG_CSTMS_CND_XPT_VSL B" ).append("\n"); 
		query.append("       ,VSK_VSL_PORT_SKD C" ).append("\n"); 
		query.append("       ,MDM_LOCATION D" ).append("\n"); 
		query.append(" WHERE  A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("   AND  B.VSL_CD = C.VSL_CD" ).append("\n"); 
		query.append("   AND  B.SKD_VOY_NO = C.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND  B.SKD_DIR_CD = C.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND  A.RGST_PORT_CD = D.LOC_CD(+)" ).append("\n"); 
		query.append("   AND  NVL(C.SKD_CNG_STS_CD, 'N') <> 'S' " ).append("\n"); 
		query.append("   AND  C.CLPT_SEQ = (" ).append("\n"); 
		query.append("                     /* EXPORT CA 이후 첫번째  포트 도착 일자로  수정 */" ).append("\n"); 
		query.append("                      SELECT MIN(CLPT_SEQ) " ).append("\n"); 
		query.append("                        FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                       WHERE VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                         AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                         AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                         AND NVL(SKD_CNG_STS_CD, 'N') <> 'S'" ).append("\n"); 
		query.append("                         /* EXPORT CA 이후 첫번째  포트 도착 일자로  수정 */" ).append("\n"); 
		query.append("                         AND CLPT_SEQ > (" ).append("\n"); 
		query.append("                                         SELECT MAX(CLPT_SEQ)" ).append("\n"); 
		query.append("                                           FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                          WHERE VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                                            AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                                            AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                                            AND NVL(SKD_CNG_STS_CD, 'N') <> 'S'" ).append("\n"); 
		query.append("                                            AND VPS_PORT_CD LIKE 'CA%'" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("   AND  B.VSL_CD         = @[vsl_cd]" ).append("\n"); 
		query.append("   AND  B.SKD_VOY_NO     = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND  B.SKD_DIR_CD     = @[skd_dir_cd]" ).append("\n"); 
		query.append("                            /* EXPORT CA 최종 출발 일자의 PORT로 수정 */" ).append("\n"); 
		query.append("   AND  B.PORT_CD        = (SELECT SUBSTR(MAX(TO_CHAR(VPS_ETD_DT, 'YYYYMMDDHH24MISS')||VPS_PORT_CD),15)" ).append("\n"); 
		query.append("                              FROM VSK_VSL_PORT_SKD " ).append("\n"); 
		query.append("                             WHERE VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                               AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                               AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                               AND VPS_PORT_CD LIKE 'CA%'" ).append("\n"); 
		query.append("                               AND NVL(SKD_CNG_STS_CD,'X') <> 'S')" ).append("\n"); 

	}
}
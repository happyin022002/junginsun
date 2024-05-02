/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CndCustomsTransmissionDBDAOsearchVesselArrivalRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndCustomsTransmissionDBDAOsearchVesselArrivalRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchVesselArrival
	  * </pre>
	  */
	public CndCustomsTransmissionDBDAOsearchVesselArrivalRSQL(){
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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.integration").append("\n"); 
		query.append("FileName : CndCustomsTransmissionDBDAOsearchVesselArrivalRSQL").append("\n"); 
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
		query.append("       ,A.LOA_LEN" ).append("\n"); 
		query.append("       ,NVL(@[crw_knt],'') AS CRW_KNT" ).append("\n"); 
		query.append("       ,TO_CHAR(A.RGST_DT, 'YYYYMMDDHHMI') AS RGST_DT" ).append("\n"); 
		query.append("       ,DECODE(B.CND_ACK_CTRL_NO" ).append("\n"); 
		query.append("           ,NULL" ).append("\n"); 
		query.append("           ,RPAD(TO_CHAR(SYSDATE,'YMMDD'),5,' ')||LTRIM(TO_CHAR(BKG_CSTM_EDI_SEQ.NEXTVAL,'0009'),' ')" ).append("\n"); 
		query.append("           ,B.CND_ACK_CTRL_NO) AS CND_ACK_CTRL_NO" ).append("\n"); 
		query.append("       ,B.CVY_REF_NO" ).append("\n"); 
		query.append("       ,B.CAP_NM" ).append("\n"); 
		query.append("       ,TO_CHAR(B.ETA_DT, 'YYYYMMDDHHMI') AS ETA_DT" ).append("\n"); 
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
		query.append("       ,C.VPS_ETD_DT" ).append("\n"); 
		query.append("       ,B.CND_ACK_SUB_CD" ).append("\n"); 
		query.append("       ,B.CND_ACK_RSPN_CD" ).append("\n"); 
		query.append("       ,B.VSL_ARR_RPT_SND_DT" ).append("\n"); 
		query.append("       ,TO_CHAR(B.ACT_ARR_DT, 'YYYYMMDD:HH24MI') ACT_ARR_DT" ).append("\n"); 
		query.append("       ,'' AS STATUS" ).append("\n"); 
		query.append("       ,'' AS POL_CD" ).append("\n"); 
		query.append("       ,@[pod_cd] AS POD_CD" ).append("\n"); 
		query.append("       ,(SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = @[pod_cd]) AS POD_NM" ).append("\n"); 
		query.append("       ,'' AS VPS_ETA_DT" ).append("\n"); 
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
		query.append("       ,(SELECT DECODE(SUBSTR(VPS_PORT_CD, 1, 2), 'US', '23', '21')" ).append("\n"); 
		query.append("           FROM VSK_VSL_PORT_SKD AA" ).append("\n"); 
		query.append("          WHERE AA.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("            AND AA.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND AA.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND AA.CLPT_SEQ   = (SELECT MAX(BB.CLPT_SEQ)" ).append("\n"); 
		query.append("                                   FROM VSK_VSL_PORT_SKD BB" ).append("\n"); 
		query.append("                                  WHERE BB.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("                                    AND BB.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("                                    AND BB.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                                 )" ).append("\n"); 
		query.append("            AND ROWNUM = 1" ).append("\n"); 
		query.append("        ) AS CC_TRANS" ).append("\n"); 
		query.append("  FROM  MDM_VSL_CNTR A" ).append("\n"); 
		query.append("       ,BKG_CSTMS_CND_VSL B" ).append("\n"); 
		query.append("       ,VSK_VSL_PORT_SKD C" ).append("\n"); 
		query.append("       ,MDM_LOCATION D" ).append("\n"); 
		query.append(" WHERE  A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("   AND  B.VSL_CD = C.VSL_CD" ).append("\n"); 
		query.append("   AND  B.SKD_VOY_NO = C.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND  B.SKD_DIR_CD = C.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND  A.RGST_PORT_CD = D.LOC_CD(+)" ).append("\n"); 
		query.append("   AND  NVL(C.SKD_CNG_STS_CD, 'N') <> 'S' " ).append("\n"); 
		query.append("   AND  C.CLPT_SEQ = (" ).append("\n"); 
		query.append("                      SELECT MAX(CLPT_SEQ) " ).append("\n"); 
		query.append("                        FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                       WHERE VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                         AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                         AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                         AND NVL(SKD_CNG_STS_CD, 'N') <> 'S'" ).append("\n"); 
		query.append("                         AND CLPT_SEQ < (" ).append("\n"); 
		query.append("                                         SELECT MIN(CLPT_SEQ)" ).append("\n"); 
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
		query.append("   AND  B.PORT_CD        = (SELECT SUBSTR(MIN(TO_CHAR(VPS_ETA_DT, 'YYYYMMDDHH24MISS')||VPS_PORT_CD),15)" ).append("\n"); 
		query.append("                              FROM VSK_VSL_PORT_SKD " ).append("\n"); 
		query.append("                             WHERE VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                               AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                               AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                               AND VPS_PORT_CD LIKE 'CA%'" ).append("\n"); 
		query.append("                               AND NVL(SKD_CNG_STS_CD,'X') <> 'S')" ).append("\n"); 

	}
}
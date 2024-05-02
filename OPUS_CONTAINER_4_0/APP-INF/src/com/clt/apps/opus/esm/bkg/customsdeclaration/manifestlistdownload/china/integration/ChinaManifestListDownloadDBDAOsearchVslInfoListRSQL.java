/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChinaManifestListDownloadDBDAOsearchVslInfoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaManifestListDownloadDBDAOsearchVslInfoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BkgCstmsChnVvdVO
	  * </pre>
	  */
	public ChinaManifestListDownloadDBDAOsearchVslInfoListRSQL(){
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
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trans_mode",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.integration").append("\n"); 
		query.append("FileName : ChinaManifestListDownloadDBDAOsearchVslInfoListRSQL").append("\n"); 
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
		query.append("SELECT  VVD.*," ).append("\n"); 
		query.append("      @[usr_id] AS CRE_USR_ID," ).append("\n"); 
		query.append("      @[usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT  SKD.VSL_CD AS VSL_CD," ).append("\n"); 
		query.append("                SKD.SKD_VOY_NO AS SKD_VOY_NO," ).append("\n"); 
		query.append("                SKD.SKD_DIR_CD AS SKD_DIR_CD," ).append("\n"); 
		query.append("                SKD.PORT AS PORT_CD," ).append("\n"); 
		query.append("                NVL(SKD.PRE_PORT,' ') AS PRE_CLPT_CD," ).append("\n"); 
		query.append("                NVL(SKD.NEXT_PORT,' ') AS NXT_CLPT_CD," ).append("\n"); 
		query.append("                REPLACE(VSL.VSL_ENG_NM, CHR(9), ' ') AS VSL_NM," ).append("\n"); 
		query.append("                NVL(VSL.CALL_SGN_NO,' ') AS VSL_CALL_SGN_PORT_LOC_CD," ).append("\n"); 
		query.append("                TO_CHAR(ETA, 'YYYYMMDD HH24MISS') AS ETA_DT," ).append("\n"); 
		query.append("                TO_CHAR(ETD, 'YYYYMMDD HH24MISS') AS ETD_DT," ).append("\n"); 
		query.append("                NVL(SKD.SLAN_CD,' ') AS SLAN_CD," ).append("\n"); 
		query.append("                @[trans_mode] AS CHN_MF_SND_IND_CD," ).append("\n"); 
		query.append("                NVL(VSL.LLOYD_NO,' ') AS LLOYD_NO," ).append("\n"); 
		query.append("                TO_CHAR(ETB, 'YYYYMMDD HH24MISS') AS ETB_DT" ).append("\n"); 
		query.append("        FROM    MDM_VSL_CNTR VSL," ).append("\n"); 
		query.append("                (SELECT VPS.VSL_CD," ).append("\n"); 
		query.append("                        VPS.SKD_VOY_NO," ).append("\n"); 
		query.append("                        VPS.SKD_DIR_CD," ).append("\n"); 
		query.append("                        VPS.VPS_PORT_CD AS PORT," ).append("\n"); 
		query.append("                        VPS2.VPS_PORT_CD AS PRE_PORT," ).append("\n"); 
		query.append("                        VPS.VPS_ETA_DT AS ETA," ).append("\n"); 
		query.append("                        VPS3.VPS_PORT_CD AS NEXT_PORT," ).append("\n"); 
		query.append("                        VPS.VPS_ETD_DT AS ETD," ).append("\n"); 
		query.append("                        VPS.SLAN_CD," ).append("\n"); 
		query.append("                        VPS.VPS_ETB_DT AS ETB," ).append("\n"); 
		query.append("                        ROW_NUMBER() OVER(PARTITION BY VPS.VSL_CD,VPS.SKD_VOY_NO,VPS.SKD_DIR_CD,VPS.VPS_PORT_CD ORDER BY VPS.CLPT_SEQ DESC) AS RNUM" ).append("\n"); 
		query.append("                   FROM VSK_VSL_PORT_SKD VPS," ).append("\n"); 
		query.append("                        VSK_VSL_PORT_SKD VPS2," ).append("\n"); 
		query.append("                        VSK_VSL_PORT_SKD VPS3" ).append("\n"); 
		query.append("                  WHERE VPS.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("                    AND VPS.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("                    AND VPS.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("                    AND VPS.VPS_PORT_CD IN (SELECT DISTINCT BV.POL_CD" ).append("\n"); 
		query.append("                                              FROM BKG_VVD BV, BKG_BOOKING BB" ).append("\n"); 
		query.append("                                             WHERE BV.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("                                               AND (#foreach($field_id in ${field_list})" ).append("\n"); 
		query.append("                                                      #if($velocityCount > 1)" ).append("\n"); 
		query.append("                                                      OR #end      BV.BKG_NO IN ( $field_id )" ).append("\n"); 
		query.append("                                                      #end" ).append("\n"); 
		query.append("                                                   )" ).append("\n"); 
		query.append("#if (${bkg_cgo_tp_cd} != '')" ).append("\n"); 
		query.append("                                               AND DECODE(BB.BKG_CGO_TP_CD,'P','P','F') = @[bkg_cgo_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                               AND BV.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("                                               AND BV.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("                                               AND BV.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("                                               AND BV.POD_CD = @[loc_cd]" ).append("\n"); 
		query.append("                                               AND BB.BKG_STS_CD    NOT IN ('X','S'))" ).append("\n"); 
		query.append("                   AND NVL(VPS.SKD_CNG_STS_CD,' ') <> 'S'" ).append("\n"); 
		query.append("                   AND (VPS.CLPT_IND_SEQ = '1' OR VPS.CLPT_IND_SEQ = '2')" ).append("\n"); 
		query.append("                   AND VPS.VSL_CD = VPS2.VSL_CD(+)" ).append("\n"); 
		query.append("                   AND VPS.SKD_VOY_NO = VPS2.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                   AND VPS.SKD_DIR_CD = VPS2.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                   AND VPS.CLPT_SEQ - 1 = VPS2.CLPT_SEQ(+)" ).append("\n"); 
		query.append("                   AND VPS.VSL_CD = VPS3.VSL_CD(+)" ).append("\n"); 
		query.append("                   AND VPS.SKD_VOY_NO = VPS3.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                   AND VPS.SKD_DIR_CD = VPS3.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                   AND VPS.CLPT_SEQ + 1 = VPS3.CLPT_SEQ(+)" ).append("\n"); 
		query.append("            ) SKD" ).append("\n"); 
		query.append("        WHERE SKD.VSL_CD = VSL.VSL_CD" ).append("\n"); 
		query.append("      AND   RNUM = 1" ).append("\n"); 
		query.append("        UNION ALL /* TRANSMISSION 2차 전송 기준의 POD의 VSL정보 조회용 TRNAS_MODE = 'R'*/" ).append("\n"); 
		query.append("        SELECT  SKD.VSL_CD," ).append("\n"); 
		query.append("                SKD.SKD_VOY_NO," ).append("\n"); 
		query.append("                SKD.SKD_DIR_CD," ).append("\n"); 
		query.append("                SKD.PORT," ).append("\n"); 
		query.append("                NVL(SKD.PRE_PORT,' ')," ).append("\n"); 
		query.append("                NVL(SKD.NEXT_PORT,' ')," ).append("\n"); 
		query.append("                REPLACE(VSL.VSL_ENG_NM, CHR(9), ' ')," ).append("\n"); 
		query.append("                NVL(VSL.CALL_SGN_NO,' ')," ).append("\n"); 
		query.append("                TO_CHAR(ETA, 'YYYYMMDD HH24MISS')," ).append("\n"); 
		query.append("                TO_CHAR(ETD, 'YYYYMMDD HH24MISS')," ).append("\n"); 
		query.append("                NVL(SKD.SLAN_CD,' ')," ).append("\n"); 
		query.append("                'R'," ).append("\n"); 
		query.append("                NVL(VSL.LLOYD_NO,' ')," ).append("\n"); 
		query.append("                TO_CHAR(ETB, 'YYYYMMDD HH24MISS')" ).append("\n"); 
		query.append("        FROM    MDM_VSL_CNTR VSL," ).append("\n"); 
		query.append("                (SELECT VPS.VSL_CD," ).append("\n"); 
		query.append("                        VPS.SKD_VOY_NO," ).append("\n"); 
		query.append("                        VPS.SKD_DIR_CD," ).append("\n"); 
		query.append("                        VPS.VPS_PORT_CD AS PORT," ).append("\n"); 
		query.append("                        VPS2.VPS_PORT_CD AS PRE_PORT," ).append("\n"); 
		query.append("                        VPS.VPS_ETA_DT AS ETA," ).append("\n"); 
		query.append("                        VPS3.VPS_PORT_CD AS NEXT_PORT," ).append("\n"); 
		query.append("                        VPS.VPS_ETD_DT AS ETD," ).append("\n"); 
		query.append("                        VPS.SLAN_CD," ).append("\n"); 
		query.append("                        VPS.VPS_ETB_DT AS ETB" ).append("\n"); 
		query.append("                   FROM VSK_VSL_PORT_SKD VPS," ).append("\n"); 
		query.append("                        VSK_VSL_PORT_SKD VPS2," ).append("\n"); 
		query.append("                        VSK_VSL_PORT_SKD VPS3" ).append("\n"); 
		query.append("                  WHERE VPS.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("                    AND VPS.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("                    AND VPS.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("                    AND VPS.VPS_PORT_CD = @[loc_cd]" ).append("\n"); 
		query.append("                    AND NVL(VPS.SKD_CNG_STS_CD,' ') <> 'S'" ).append("\n"); 
		query.append("                    AND (VPS.CLPT_IND_SEQ = '1' OR VPS.CLPT_IND_SEQ = '2')" ).append("\n"); 
		query.append("                    AND VPS.VSL_CD = VPS2.VSL_CD(+)" ).append("\n"); 
		query.append("                    AND VPS.SKD_VOY_NO = VPS2.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                    AND VPS.SKD_DIR_CD = VPS2.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                    AND VPS.CLPT_SEQ - 1 = VPS2.CLPT_SEQ(+)" ).append("\n"); 
		query.append("                    AND VPS.VSL_CD = VPS3.VSL_CD(+)" ).append("\n"); 
		query.append("                    AND VPS.SKD_VOY_NO = VPS3.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                    AND VPS.SKD_DIR_CD = VPS3.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                    AND VPS.CLPT_SEQ + 1 = VPS3.CLPT_SEQ(+)" ).append("\n"); 
		query.append("                  ORDER BY VPS.CLPT_SEQ DESC" ).append("\n"); 
		query.append("                ) SKD" ).append("\n"); 
		query.append("        WHERE   SKD.VSL_CD = VSL.VSL_CD" ).append("\n"); 
		query.append("        AND     ROWNUM = 1" ).append("\n"); 
		query.append(") VVD" ).append("\n"); 

	}
}
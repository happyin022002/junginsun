/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChinaManifestListDownloadDBDAOsearchBlListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.20 
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

public class ChinaManifestListDownloadDBDAOsearchBlListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BkgCstmsChnBlVO
	  * </pre>
	  */
	public ChinaManifestListDownloadDBDAOsearchBlListRSQL(){
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
		params.put("bkg_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trans_mode",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.integration").append("\n"); 
		query.append("FileName : ChinaManifestListDownloadDBDAOsearchBlListRSQL").append("\n"); 
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
		query.append("SELECT  B.BKG_NO" ).append("\n"); 
		query.append("       ,MAX( B.BKG_NO||CHR(9)||" ).append("\n"); 
		query.append("             B.BL_NO||CHR(9)||" ).append("\n"); 
		query.append("             B.BL_NO_TP||CHR(9)||" ).append("\n"); 
		query.append("             SUBSTR(@[vvd], 1, 4)||CHR(9)||" ).append("\n"); 
		query.append("             SUBSTR(@[vvd], 5, 4)||CHR(9)||" ).append("\n"); 
		query.append("             SUBSTR(@[vvd], 9, 1)||CHR(9)||" ).append("\n"); 
		query.append("             VVD.POL_CD||CHR(9)||" ).append("\n"); 
		query.append("             VVD.POD_CD||CHR(9)||" ).append("\n"); 
		query.append("             B.POR_CD||CHR(9)||" ).append("\n"); 
		query.append("             B.POL_CD||CHR(9)||" ).append("\n"); 
		query.append("             B.POD_CD||CHR(9)||" ).append("\n"); 
		query.append("             B.DEL_CD||CHR(9)||" ).append("\n"); 
		query.append("             NVL(TO_CHAR(BM.OBL_ISS_DT, 'yyyymmdd hh24miss'), ' ')||CHR(9)||" ).append("\n"); 
		query.append("             NVL(TO_CHAR(BCD.BL_OBRD_DT, 'yyyymmdd hh24miss'), (SELECT TO_CHAR(VSL.VPS_ETB_DT, 'yyyymmdd hh24miss') " ).append("\n"); 
		query.append("                                                                  FROM BKG_VVD VVD, VSK_VSL_PORT_SKD VSL" ).append("\n"); 
		query.append("                                                                 WHERE VVD.VSL_CD = VSL.VSL_CD" ).append("\n"); 
		query.append("                                                                   AND VVD.SKD_VOY_NO = VSL.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                   AND VVD.SKD_DIR_CD = VSL.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                                   AND VVD.POL_CD = VSL.VPS_PORT_CD" ).append("\n"); 
		query.append("                                                                   AND VVD.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                                                                   AND VVD.VSL_PRE_PST_CD||VSL_SEQ = (SELECT MAX(VSL_PRE_PST_CD||VSL_SEQ)" ).append("\n"); 
		query.append("                                                                                                        FROM BKG_VVD" ).append("\n"); 
		query.append("                                                                                                       WHERE BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                                                                   AND VSL.CLPT_IND_SEQ = 1)" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("             ))||CHR(9)||" ).append("\n"); 
		query.append("             DECODE(@[trans_mode],'P','21',DECODE(B.DEL_CD,'CNHKG','21',DECODE(SUBSTR(B.DEL_CD,1,2),'CN'," ).append("\n"); 
		query.append("				(SELECT CHN_CSTMS_TRSP_MOD_CD FROM BKG_CSTMS_CHN_DE_MOD" ).append("\n"); 
		query.append("  				WHERE POD_CD = VVD.POD_CD" ).append("\n"); 
		query.append("  				AND DEL_CD = B.DEL_CD ),'21')))||CHR(9)||" ).append("\n"); 
		query.append("             B.RCV_TERM_CD||CHR(9)||" ).append("\n"); 
		query.append("             B.DE_TERM_CD||CHR(9)||" ).append("\n"); 
		query.append("             NVL(BR.FRT_TERM_CD, ' ')||CHR(9)||" ).append("\n"); 
		query.append("             RPAD(REPLACE(REPLACE(NVL(BCD.CSTMS_DESC,' '),CHR(10),' '),CHR(9),' '),256)||CHR(9)||" ).append("\n"); 
		query.append("             NVL(BCD.PCK_QTY,0)||CHR(9)||" ).append("\n"); 
		query.append("             NVL(BCD.PCK_TP_CD,' ')||CHR(9)||" ).append("\n"); 
		query.append("             DECODE(NVL(BCD.WGT_UT_CD,' '),'LBS',ROUND(NVL(BCD.ACT_WGT,0)*0.4536,3), NVL(BCD.ACT_WGT,0))||CHR(9)|| /* 20060707 yong: LBS=>KGS로 환산 */" ).append("\n"); 
		query.append("             DECODE(NVL(BCD.WGT_UT_CD,' '),'LBS','KGS',NVL(BCD.WGT_UT_CD,' '))||CHR(9)||" ).append("\n"); 
		query.append("             DECODE(NVL(BCD.MEAS_UT_CD,' '),'CBF',ROUND(NVL(BCD.MEAS_QTY,0)*0.0283,3), NVL(BCD.MEAS_QTY,0))||CHR(9)|| /* 20060707 yong: CBF=>CBM로 환산 */" ).append("\n"); 
		query.append("             DECODE(BCD.MEAS_QTY,0,' ','CBM')||CHR(9)||" ).append("\n"); 
		query.append("             B.BKG_CGO_TP_CD||CHR(9)|| /* 20051124 yong : cgo type, special dg cargo, special rf cargo D/L되도록 추가 */" ).append("\n"); 
		query.append("             B.DCGO_FLG||CHR(9)||" ).append("\n"); 
		query.append("             B.RC_FLG||CHR(9)||" ).append("\n"); 
		query.append("             NVL(OFC.LOC_CD,' ')||CHR(9)||" ).append("\n"); 
		query.append("             @[trans_mode]||CHR(9)||" ).append("\n"); 
		query.append("             TO_CHAR(SKD.VPS_ETA_DT, 'YYYYMMDD HH24MISS')||CHR(9)||" ).append("\n"); 
		query.append("             VVD.POD_YD_CD||CHR(9)||" ).append("\n"); 
		query.append("             DECODE(@[trans_mode], 'D', VVD.POD_CD, VVD.POL_CD)||CHR(9)||" ).append("\n"); 
		query.append("             VVD.VSL_CD||CHR(9)||" ).append("\n"); 
		query.append("             VVD.SKD_VOY_NO||CHR(9)||" ).append("\n"); 
		query.append("             VVD.SKD_DIR_CD) BL_NO " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM   BKG_BL_ISS BM," ).append("\n"); 
		query.append("       BKG_RATE BR," ).append("\n"); 
		query.append("       BKG_BOOKING B," ).append("\n"); 
		query.append("       BKG_VVD VVD," ).append("\n"); 
		query.append("       BKG_BL_DOC BCD," ).append("\n"); 
		query.append("       MDM_ORGANIZATION OFC," ).append("\n"); 
		query.append("       VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE  1 = 1" ).append("\n"); 
		query.append("AND (#foreach($field_id in ${field_list}) " ).append("\n"); 
		query.append("      	#if($velocityCount > 1)" ).append("\n"); 
		query.append("        OR #end      B.BKG_NO IN ( $field_id )" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if (${bkg_cgo_tp_cd} != '') " ).append("\n"); 
		query.append("AND    DECODE(B.BKG_CGO_TP_CD,'P','P','F') = @[bkg_cgo_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    B.BKG_NO                    =    VVD.BKG_NO" ).append("\n"); 
		query.append("AND    B.BKG_NO                    =    BM.BKG_NO(+)" ).append("\n"); 
		query.append("AND    B.BKG_NO                    =    BR.BKG_NO(+)" ).append("\n"); 
		query.append("AND    BM.OBL_ISS_OFC_CD           =    OFC.OFC_CD(+)" ).append("\n"); 
		query.append("AND    (VVD.VSL_CD, VVD.SKD_VOY_NO, VVD.SKD_DIR_CD) IN (" ).append("\n"); 
		query.append("                                                        (SUBSTR(@[vvd], 1, 4), SUBSTR(@[vvd], 5, 4), SUBSTR(@[vvd], 9, 1))" ).append("\n"); 
		query.append("#if (${vvd2} != '')" ).append("\n"); 
		query.append("                                                       ,(SUBSTR(@[vvd2], 1, 4), SUBSTR(@[vvd2], 5, 4), SUBSTR(@[vvd2], 9, 1))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                                       )" ).append("\n"); 
		query.append("AND    DECODE(@[trans_mode],'D',VVD.POD_CD,VVD.POL_CD) = @[loc_cd]" ).append("\n"); 
		query.append("AND    B.BKG_NO                    =    BCD.BKG_NO(+)" ).append("\n"); 
		query.append("AND    VVD.VSL_CD                  =    SKD.VSL_CD" ).append("\n"); 
		query.append("AND    VVD.SKD_VOY_NO              =    SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    VVD.SKD_DIR_CD              =    SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    VVD.POD_CD                  =    SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("GROUP BY B.BKG_NO" ).append("\n"); 

	}
}
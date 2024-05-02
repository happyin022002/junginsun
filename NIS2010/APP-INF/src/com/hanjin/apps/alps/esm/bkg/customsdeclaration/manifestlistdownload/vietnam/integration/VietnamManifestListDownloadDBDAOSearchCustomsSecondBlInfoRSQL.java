/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : VietnamManifestListDownloadDBDAOSearchCustomsSecondBlInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vietnam.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VietnamManifestListDownloadDBDAOSearchCustomsSecondBlInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCustomsSecondBlInfo
	  * </pre>
	  */
	public VietnamManifestListDownloadDBDAOSearchCustomsSecondBlInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vietnam.integration").append("\n"); 
		query.append("FileName : VietnamManifestListDownloadDBDAOSearchCustomsSecondBlInfoRSQL").append("\n"); 
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
		query.append("SELECT  'SMLM'||BKG.BL_NO BL_NO,  " ).append("\n"); 
		query.append("        CNTR.CNTR_NO, " ).append("\n"); 
		query.append("        CUST1.CUST_NM ||CHR(10)||CHR(13)||CUST1.CUST_ADDR SH_CUST_NM, " ).append("\n"); 
		query.append("        CUST2.CUST_NM ||CHR(10)||CHR(13)||CUST2.CUST_ADDR CN_CUST_NM," ).append("\n"); 
		query.append("        CUST3.CUST_NM ||CHR(10)||CHR(13)||CUST3.CUST_ADDR NF_CUST_NM," ).append("\n"); 
		query.append("        SEAL.CNTR_SEAL_NO, " ).append("\n"); 
		query.append("        MF.CMDT_HS_CD , " ).append("\n"); 
		query.append("        (SUBSTR(BBMD.CMDT_DESC , 1, 3000)) CMDT_DESC," ).append("\n"); 
		query.append("		BL.PCK_QTY PACK_AGE," ).append("\n"); 
		query.append("        BL.PCK_TP_CD PACKAGE_UNIT," ).append("\n"); 
		query.append("        BL.ACT_WGT Net_Weight," ).append("\n"); 
		query.append("        BL.ACT_WGT Gross_Weight, " ).append("\n"); 
		query.append("        BL.WGT_UT_CD GrossUnit, " ).append("\n"); 
		query.append("        BL.MEAS_QTY Demension_tonnage," ).append("\n"); 
		query.append("        ''REF_NO," ).append("\n"); 
		query.append("        ''AJUSTMENT_BASIS," ).append("\n"); 
		query.append("        BKG.POD_NOD_CD POD_CD," ).append("\n"); 
		query.append("        BKG.DEL_NOD_CD DEL_CD," ).append("\n"); 
		query.append("        BKG.POL_NOD_CD POL_CD," ).append("\n"); 
		query.append("        BKG.POR_NOD_CD POR_CD," ).append("\n"); 
		query.append("        MDM.YD_NM FINAL_DEL," ).append("\n"); 
		query.append("        DECODE(SUBSTR(CNTR.CNTR_TPSZ_CD, 2, 1), '2', '20', '4', '40', '5', '40', '7', '45', '8', '48', '9', '48', ' ') CONT_TYPE," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_gubun} == '1')" ).append("\n"); 
		query.append("     	CASE WHEN BKG.POD_CD <> VVD.POD_CD THEN VVD.POD_CD ELSE '' END TS_PORT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("     	CASE WHEN BKG.POL_CD <> VVD.POL_CD THEN VVD.POL_CD ELSE '' END TS_PORT   " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("FROM    BKG_BOOKING BKG, " ).append("\n"); 
		query.append("        BKG_VVD VVD," ).append("\n"); 
		query.append("        BKG_CONTAINER CNTR, " ).append("\n"); 
		query.append("        BKG_CUSTOMER CUST1, " ).append("\n"); 
		query.append("        BKG_CUSTOMER CUST2, " ).append("\n"); 
		query.append("        BKG_CUSTOMER CUST3, " ).append("\n"); 
		query.append("        BKG_CNTR_SEAL_NO SEAL, " ).append("\n"); 
		query.append("        BKG_CNTR_MF_DESC MF, " ).append("\n"); 
		query.append("        BKG_BL_DOC BL," ).append("\n"); 
		query.append("        BKG_BL_MK_DESC BBMD," ).append("\n"); 
		query.append("		MDM_YARD MDM" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("WHERE   BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("AND     BKG.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("AND     BKG.BKG_NO = CUST1.BKG_NO" ).append("\n"); 
		query.append("AND     BKG.BKG_NO = CUST2.BKG_NO" ).append("\n"); 
		query.append("AND     BKG.BKG_NO = CUST3.BKG_NO" ).append("\n"); 
		query.append("AND     BKG.BKG_NO = BBMD.BKG_NO" ).append("\n"); 
		query.append("AND     CNTR.BKG_NO = SEAL.BKG_NO" ).append("\n"); 
		query.append("AND     CNTR.CNTR_NO = SEAL.CNTR_NO" ).append("\n"); 
		query.append("AND     CNTR.CNTR_NO = MF.CNTR_NO" ).append("\n"); 
		query.append("AND     BKG.BKG_NO = MF.BKG_NO" ).append("\n"); 
		query.append("AND     BKG.BKG_NO = BL.BKG_NO" ).append("\n"); 
		query.append("AND     BKG.DEL_NOD_CD = MDM.YD_CD" ).append("\n"); 
		query.append("AND     CUST1.BKG_CUST_TP_CD= 'S'" ).append("\n"); 
		query.append("AND     CUST2.BKG_CUST_TP_CD='C'" ).append("\n"); 
		query.append("AND     CUST3.BKG_CUST_TP_CD ='N'" ).append("\n"); 
		query.append("AND     VVD.VSL_CD = SUBSTR(@[s_vvd],1,4)               " ).append("\n"); 
		query.append("AND     VVD.SKD_VOY_NO = SUBSTR(@[s_vvd],5,4)            " ).append("\n"); 
		query.append("AND     VVD.SKD_DIR_CD = SUBSTR(@[s_vvd],9,1)" ).append("\n"); 
		query.append("AND     BKG.BKG_STS_CD <> 'X'     " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_gubun} == '1')" ).append("\n"); 
		query.append("AND       VVD.POL_CD = @[frm_port_cd]  " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND       VVD.POD_CD = @[frm_port_cd]     " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND		SEAL.CNTR_SEAL_SEQ = 1" ).append("\n"); 

	}
}
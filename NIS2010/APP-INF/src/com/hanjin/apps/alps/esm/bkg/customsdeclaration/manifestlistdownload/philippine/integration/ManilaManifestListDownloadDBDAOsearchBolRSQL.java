/*=========================================================
*Copyright(c) 2018 SM Line
*@FileName : ManilaManifestListDownloadDBDAOsearchBolRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.06.04
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManilaManifestListDownloadDBDAOsearchBolRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Philpplines Manifest 화면의 Bol 탭 정보 조회
	  * </pre>
	  */
	public ManilaManifestListDownloadDBDAOsearchBolRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("reg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.integration").append("\n"); 
		query.append("FileName : ManilaManifestListDownloadDBDAOsearchBolRSQL").append("\n"); 
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
		query.append("SELECT OFC_CD" ).append("\n"); 
		query.append("	 , REG_NO " ).append("\n"); 
		query.append(" 	 , BL_NO" ).append("\n"); 
		query.append("	 , BL_LINE_NO" ).append("\n"); 
		query.append("	 , BL_SUB_LINE_NO" ).append("\n"); 
		query.append("	 , BL_STS" ).append("\n"); 
		query.append("	 , PRE_DOC" ).append("\n"); 
		query.append("	 , BL_TP" ).append("\n"); 
		query.append("	 , BL_NT_CD" ).append("\n"); 
		query.append("	 , UQ_REF_NO" ).append("\n"); 
		query.append("	 , SHPR_NM" ).append("\n"); 
		query.append("	 , SHPR_ADDR1  " ).append("\n"); 
		query.append("	 , SHPR_ADDR2" ).append("\n"); 
		query.append("	 , SHPR_ADDR3" ).append("\n"); 
		query.append("	 , SHPR_ADDR4" ).append("\n"); 
		query.append("	 , CNEE_CD" ).append("\n"); 
		query.append("	 , CNEE_NM" ).append("\n"); 
		query.append("	 , CNEE_ADDR1" ).append("\n"); 
		query.append("	 , CNEE_ADDR2" ).append("\n"); 
		query.append("	 , CNEE_ADDR3" ).append("\n"); 
		query.append("	 , CNEE_ADDR4 " ).append("\n"); 
		query.append("	 , NTFY_CD" ).append("\n"); 
		query.append("	 , NTFY_NM" ).append("\n"); 
		query.append("	 , NTFY_ADDR1" ).append("\n"); 
		query.append("	 , NTFY_ADDR2" ).append("\n"); 
		query.append("	 , NTFY_ADDR3" ).append("\n"); 
		query.append("	 , NTFY_ADDR4" ).append("\n"); 
		query.append("	 , POR_CD" ).append("\n"); 
		query.append("	 , DEL_CD" ).append("\n"); 
		query.append("	 , TOT_CNTR	" ).append("\n"); 
		query.append("	 , PCK_TP" ).append("\n"); 
		query.append("	 , DECODE(PCK_QTY,0,1,PCK_QTY) AS PCK_QTY" ).append("\n"); 
		query.append("	 , LTRIM(TO_CHAR(DECODE(WGT,0,1,WGT),'9999999990.999')) AS WGT" ).append("\n"); 
		query.append("	 , LTRIM(TO_CHAR(DECODE(VOL,0,0.01,VOL),'9999999990.99999')) AS VOL " ).append("\n"); 
		query.append("	 , MK_DESC1" ).append("\n"); 
		query.append("	 , MK_DESC2" ).append("\n"); 
		query.append("	 , MK_DESC3" ).append("\n"); 
		query.append("	 , MK_DESC4" ).append("\n"); 
		query.append("	 , MK_DESC5" ).append("\n"); 
		query.append("	 , MK_DESC6" ).append("\n"); 
		query.append("	 , MK_DESC7" ).append("\n"); 
		query.append("	 , MK_DESC8" ).append("\n"); 
		query.append("	 , MK_DESC9" ).append("\n"); 
		query.append("	 , MK_DESC10" ).append("\n"); 
		query.append("	 , GDS_DESC1" ).append("\n"); 
		query.append("	 , GDS_DESC2" ).append("\n"); 
		query.append("	 , GDS_DESC3" ).append("\n"); 
		query.append("	 , GDS_DESC4" ).append("\n"); 
		query.append("	 , GDS_DESC5" ).append("\n"); 
		query.append("	 , FRE_IND" ).append("\n"); 
		query.append("	 , FRE_VAL" ).append("\n"); 
		query.append("	 , FRE_CUR" ).append("\n"); 
		query.append("	 , CSTMS_VAL" ).append("\n"); 
		query.append("	 , CSTMS_CUR" ).append("\n"); 
		query.append("	 , TRSP_VAL" ).append("\n"); 
		query.append("	 , TRSP_CUR" ).append("\n"); 
		query.append("	 , INSUR_VAL" ).append("\n"); 
		query.append("	 , INSUR_CUR" ).append("\n"); 
		query.append("	 , TOT_SUB_BL" ).append("\n"); 
		query.append("	 , TOT_SEAL" ).append("\n"); 
		query.append("	 , DEL_MOD" ).append("\n"); 
		query.append("	 , INFO1" ).append("\n"); 
		query.append("	 , INFO2" ).append("\n"); 
		query.append("     , ROWNUM AS SEQ" ).append("\n"); 
		query.append("  FROM (SELECT @[ofc_cd] AS OFC_CD" ).append("\n"); 
		query.append("			 , @[reg_no]||'-'||TO_CHAR(SYSDATE, 'YY') AS REG_NO " ).append("\n"); 
		query.append("			 , BB.BL_NO AS BL_NO" ).append("\n"); 
		query.append("			 , ROWNUM AS BL_LINE_NO" ).append("\n"); 
		query.append("			 , '0' AS BL_SUB_LINE_NO" ).append("\n"); 
		query.append("			 , '4' AS BL_STS" ).append("\n"); 
		query.append("			 , '' AS PRE_DOC" ).append("\n"); 
		query.append("			 , 'HBL' AS BL_TP" ).append("\n"); 
		query.append("			 , '23' AS BL_NT_CD" ).append("\n"); 
		query.append("			 , '' AS UQ_REF_NO" ).append("\n"); 
		query.append("			 , BKG_SPCLCHAR_CONV_FNC(NVL(SUBSTR(REPLACE(S.CUST_NM, CHR(13)||CHR(10),'  '),1,35),'NO SHIPPER NAME'),'J') AS SHPR_NM" ).append("\n"); 
		query.append("			 , BKG_SPCLCHAR_CONV_FNC(NVL(SUBSTR(REPLACE(S.CUST_ADDR, CHR(13)||CHR(10),'  '),1,35),''),'J') AS SHPR_ADDR1  " ).append("\n"); 
		query.append("			 , BKG_SPCLCHAR_CONV_FNC(NVL(SUBSTR(REPLACE(S.CUST_ADDR, CHR(13)||CHR(10),'  '),36,35),''),'J') AS SHPR_ADDR2" ).append("\n"); 
		query.append("			 , BKG_SPCLCHAR_CONV_FNC(NVL(SUBSTR(REPLACE(S.CUST_ADDR, CHR(13)||CHR(10),'  '),71,35),''),'J') AS SHPR_ADDR3" ).append("\n"); 
		query.append("			 , BKG_SPCLCHAR_CONV_FNC(NVL(SUBSTR(REPLACE(S.CUST_ADDR, CHR(13)||CHR(10),'  '),106,35),''),'J') AS SHPR_ADDR4" ).append("\n"); 
		query.append("			 , '' AS CNEE_CD" ).append("\n"); 
		query.append("			 , BKG_SPCLCHAR_CONV_FNC(NVL(SUBSTR(REPLACE(C.CUST_NM, CHR(13)||CHR(10),'  '),1,35),'NO CONSIGNEE NAME'),'J') AS CNEE_NM" ).append("\n"); 
		query.append("			 , BKG_SPCLCHAR_CONV_FNC(NVL(SUBSTR(REPLACE(C.CUST_ADDR, CHR(13)||CHR(10),'  '),1,35),''),'J') AS CNEE_ADDR1" ).append("\n"); 
		query.append("			 , BKG_SPCLCHAR_CONV_FNC(NVL(SUBSTR(REPLACE(C.CUST_ADDR, CHR(13)||CHR(10),'  '),36,35),''),'J') AS CNEE_ADDR2" ).append("\n"); 
		query.append("			 , BKG_SPCLCHAR_CONV_FNC(NVL(SUBSTR(REPLACE(C.CUST_ADDR, CHR(13)||CHR(10),'  '),71,35),''),'J') AS CNEE_ADDR3" ).append("\n"); 
		query.append("			 , BKG_SPCLCHAR_CONV_FNC(NVL(SUBSTR(REPLACE(C.CUST_ADDR, CHR(13)||CHR(10),'  '),106,35),''),'J') AS CNEE_ADDR4 " ).append("\n"); 
		query.append("			 , '' AS NTFY_CD" ).append("\n"); 
		query.append("			 , BKG_SPCLCHAR_CONV_FNC(NVL(SUBSTR(REPLACE(N.CUST_NM, CHR(13)||CHR(10),'  '),1,35),''),'J') AS NTFY_NM" ).append("\n"); 
		query.append("			 , BKG_SPCLCHAR_CONV_FNC(NVL(SUBSTR(REPLACE(N.CUST_ADDR, CHR(13)||CHR(10),'  '),1,35),''),'J') AS NTFY_ADDR1" ).append("\n"); 
		query.append("			 , BKG_SPCLCHAR_CONV_FNC(NVL(SUBSTR(REPLACE(N.CUST_ADDR, CHR(13)||CHR(10),'  '),36,35),''),'J') AS NTFY_ADDR2" ).append("\n"); 
		query.append("			 , BKG_SPCLCHAR_CONV_FNC(NVL(SUBSTR(REPLACE(N.CUST_ADDR, CHR(13)||CHR(10),'  '),71,35),''),'J') AS NTFY_ADDR3" ).append("\n"); 
		query.append("			 , BKG_SPCLCHAR_CONV_FNC(NVL(SUBSTR(REPLACE(N.CUST_ADDR, CHR(13)||CHR(10),'  '),106,35),''),'J') AS NTFY_ADDR4" ).append("\n"); 
		query.append("			 , NVL(BB.POL_CD, 'XXXXX') AS POR_CD" ).append("\n"); 
		query.append("			 , BB.POD_CD AS DEL_CD" ).append("\n"); 
		query.append("			 , (SELECT COUNT(CNTR_NO)" ).append("\n"); 
		query.append("				  FROM BKG_CONTAINER BC" ).append("\n"); 
		query.append("				 WHERE BC.BKG_NO = BB.BKG_NO) AS TOT_CNTR	" ).append("\n"); 
		query.append("			 , NVL(DOC.PCK_TP_CD, 'NE') AS PCK_TP" ).append("\n"); 
		query.append("			 , NVL(DOC.PCK_QTY, 0) AS PCK_QTY" ).append("\n"); 
		query.append("			 , NVL(DECODE(NVL(DOC.WGT_UT_CD,'KGS'),'KGS',NVL(DOC.ACT_WGT,0),'LBS',NVL(DOC.ACT_WGT,0)*0.45359),0) AS WGT" ).append("\n"); 
		query.append("			 , NVL(TO_CHAR(DECODE(NVL(DOC.MEAS_UT_CD,'CBM'),'CBM',NVL(DOC.MEAS_QTY,0),'CBF',NVL(DOC.MEAS_QTY,0)*0.02831)),0.00) AS VOL" ).append("\n"); 
		query.append("			 , BKG_SPCLCHAR_CONV_FNC(NVL(SUBSTR(REPLACE(BMD.MK_DESC||BH.BL_MK_DESC, CHR(13)||CHR(10),'  '),1,35),'NO MARKS'),'J') AS MK_DESC1" ).append("\n"); 
		query.append("			 , BKG_SPCLCHAR_CONV_FNC(NVL(SUBSTR(REPLACE(BMD.MK_DESC||BH.BL_MK_DESC, CHR(13)||CHR(10),'  '),36,35),''),'J') AS MK_DESC2" ).append("\n"); 
		query.append("			 , BKG_SPCLCHAR_CONV_FNC(NVL(SUBSTR(REPLACE(BMD.MK_DESC||BH.BL_MK_DESC, CHR(13)||CHR(10),'  '),71,35),''),'J') AS MK_DESC3" ).append("\n"); 
		query.append("			 , BKG_SPCLCHAR_CONV_FNC(NVL(SUBSTR(REPLACE(BMD.MK_DESC||BH.BL_MK_DESC, CHR(13)||CHR(10),'  '),106,35),''),'J') AS MK_DESC4" ).append("\n"); 
		query.append("			 , BKG_SPCLCHAR_CONV_FNC(NVL(SUBSTR(REPLACE(BMD.MK_DESC||BH.BL_MK_DESC, CHR(13)||CHR(10),'  '),141,35),''),'J') AS MK_DESC5" ).append("\n"); 
		query.append("			 , BKG_SPCLCHAR_CONV_FNC(NVL(SUBSTR(REPLACE(BMD.MK_DESC||BH.BL_MK_DESC, CHR(13)||CHR(10),'  '),176,35),''),'J') AS MK_DESC6" ).append("\n"); 
		query.append("			 , BKG_SPCLCHAR_CONV_FNC(NVL(SUBSTR(REPLACE(BMD.MK_DESC||BH.BL_MK_DESC, CHR(13)||CHR(10),'  '),211,35),''),'J') AS MK_DESC7" ).append("\n"); 
		query.append("			 , BKG_SPCLCHAR_CONV_FNC(NVL(SUBSTR(REPLACE(BMD.MK_DESC||BH.BL_MK_DESC, CHR(13)||CHR(10),'  '),246,35),''),'J') AS MK_DESC8" ).append("\n"); 
		query.append("			 , BKG_SPCLCHAR_CONV_FNC(NVL(SUBSTR(REPLACE(BMD.MK_DESC||BH.BL_MK_DESC, CHR(13)||CHR(10),'  '),246,35),''),'J') AS MK_DESC9" ).append("\n"); 
		query.append("			 , BKG_SPCLCHAR_CONV_FNC(NVL(SUBSTR(REPLACE(BMD.MK_DESC||BH.BL_MK_DESC, CHR(13)||CHR(10),'  '),281,35),''),'J') AS MK_DESC10" ).append("\n"); 
		query.append("			 , BKG_SPCLCHAR_CONV_FNC(NVL(SUBSTR(REPLACE(DOC.PCK_CMDT_DESC||DOC.CNTR_CMDT_DESC||BMD.CMDT_DESC||BH.BL_GDS_DESC, CHR(13)||CHR(10),'  '),1,25),'NO GOODS DESCRIPTION'),'J') AS GDS_DESC1" ).append("\n"); 
		query.append("			 , BKG_SPCLCHAR_CONV_FNC(NVL(SUBSTR(REPLACE(DOC.PCK_CMDT_DESC||DOC.CNTR_CMDT_DESC||BMD.CMDT_DESC||BH.BL_GDS_DESC, CHR(13)||CHR(10),'  '),26,35),''),'J') AS GDS_DESC2" ).append("\n"); 
		query.append("			 , BKG_SPCLCHAR_CONV_FNC(NVL(SUBSTR(REPLACE(DOC.PCK_CMDT_DESC||DOC.CNTR_CMDT_DESC||BMD.CMDT_DESC||BH.BL_GDS_DESC, CHR(13)||CHR(10),'  '),61,35),''),'J') AS GDS_DESC3" ).append("\n"); 
		query.append("			 , BKG_SPCLCHAR_CONV_FNC(NVL(SUBSTR(REPLACE(DOC.PCK_CMDT_DESC||DOC.CNTR_CMDT_DESC||BMD.CMDT_DESC||BH.BL_GDS_DESC, CHR(13)||CHR(10),'  '),96,35),''),'J') AS GDS_DESC4" ).append("\n"); 
		query.append("			 , BKG_SPCLCHAR_CONV_FNC(NVL(SUBSTR(REPLACE(DOC.PCK_CMDT_DESC||DOC.CNTR_CMDT_DESC||BMD.CMDT_DESC||BH.BL_GDS_DESC, CHR(13)||CHR(10),'  '),131,35),''),'J') AS GDS_DESC5" ).append("\n"); 
		query.append("			 , 'P' AS FRE_IND" ).append("\n"); 
		query.append("			 , LTRIM(TO_CHAR(0.01,'0.99')) AS FRE_VAL" ).append("\n"); 
		query.append("			 , 'USD' AS FRE_CUR" ).append("\n"); 
		query.append(" 			 , LTRIM(TO_CHAR(0.01,'0.99')) AS CSTMS_VAL" ).append("\n"); 
		query.append("			 , 'USD' AS CSTMS_CUR" ).append("\n"); 
		query.append("			 , LTRIM(TO_CHAR(0.00,'0.99')) AS TRSP_VAL" ).append("\n"); 
		query.append("			 , 'USD' AS TRSP_CUR" ).append("\n"); 
		query.append("			 , '' AS INSUR_VAL" ).append("\n"); 
		query.append("			 , 'USD' AS INSUR_CUR			" ).append("\n"); 
		query.append("			 , '' AS TOT_SUB_BL" ).append("\n"); 
		query.append("			 , '' AS TOT_SEAL" ).append("\n"); 
		query.append("             ,  DECODE(BB.RCV_TERM_CD,'Y','CY-','S','CFS-','CY-')||DECODE(BB.DE_TERM_CD,'Y','CY','S','CFS','CY') DEL_MOD" ).append("\n"); 
		query.append("			 , '' AS INFO1" ).append("\n"); 
		query.append("			 , '' AS INFO2" ).append("\n"); 
		query.append("		 FROM BKG_CUSTOMER S," ).append("\n"); 
		query.append("		      BKG_CUSTOMER C," ).append("\n"); 
		query.append("		      BKG_CUSTOMER N," ).append("\n"); 
		query.append("		      BKG_BOOKING BB," ).append("\n"); 
		query.append("		      BKG_VVD BV," ).append("\n"); 
		query.append("		      BKG_BL_DOC DOC," ).append("\n"); 
		query.append("			  BKG_BL_MK_DESC BMD," ).append("\n"); 
		query.append("			  BKG_HBL BH " ).append("\n"); 
		query.append("		WHERE 1=1" ).append("\n"); 
		query.append("		  AND BB.BKG_NO = BMD.BKG_NO(+)" ).append("\n"); 
		query.append("		  AND BB.BKG_NO = BH.BKG_NO(+)" ).append("\n"); 
		query.append("		  AND BB.BKG_NO = S.BKG_NO(+) " ).append("\n"); 
		query.append("		  AND S.BKG_CUST_TP_CD = 'S' " ).append("\n"); 
		query.append("		  AND BB.BKG_NO = C.BKG_NO(+)  " ).append("\n"); 
		query.append("		  AND C.BKG_CUST_TP_CD = 'C' " ).append("\n"); 
		query.append("		  AND BB.BKG_NO = N.BKG_NO(+)  " ).append("\n"); 
		query.append("		  AND N.BKG_CUST_TP_CD = 'N' " ).append("\n"); 
		query.append("		  AND BB.BKG_NO = BV.BKG_NO " ).append("\n"); 
		query.append("		  AND BB.BKG_NO = DOC.BKG_NO " ).append("\n"); 
		query.append("		  AND BV.VSL_CD = @[vsl_cd] " ).append("\n"); 
		query.append("		  AND BV.SKD_VOY_NO = @[skd_voy_no] " ).append("\n"); 
		query.append("		  AND BV.SKD_DIR_CD = @[skd_dir_cd] " ).append("\n"); 
		query.append("#if (${pol_cd}!= '') " ).append("\n"); 
		query.append("		  AND BV.POL_CD = @[pol_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd}!= '') " ).append("\n"); 
		query.append("		  AND BV.POD_CD = @[pod_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		  AND BB.BKG_STS_CD IN ('F','W') " ).append("\n"); 
		query.append("		  AND BB.BL_NO > ' '" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
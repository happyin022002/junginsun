/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLDocumentationBLDBDAOsearchkeywordByBkg2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationBLDBDAOsearchkeywordByBkg2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BLDocumentationBLDBDAOsearchkeywordByBkgRSQL
	  * 
	  * KW_INCL_FLG가 Y일때와 아닐 때를 구분해 검색한 후, Union으로 
	  * 합쳐서 등급이 가장 높은 위험물 seq를 반환 
	  * </pre>
	  */
	public BLDocumentationBLDBDAOsearchkeywordByBkg2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOsearchkeywordByBkg2RSQL").append("\n"); 
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
		query.append("DISTINCT NON_DCGO_KW_SEQ" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("SELECT KW.NON_DCGO_KW_SEQ" ).append("\n"); 
		query.append("      ,RANK() OVER (PARTITION BY BKG.BKG_NO ORDER BY KW.NON_DCGO_CATE_GRP_CD) RNK" ).append("\n"); 
		query.append("    FROM (SELECT /*+NO_MERGE*/ BKG.BKG_NO" ).append("\n"); 
		query.append("              ,REGEXP_REPLACE(' '|| BKG.INTER_RMK || ' ', '[[:space:]]{2,}', ' ') AS INTER_RMK" ).append("\n"); 
		query.append("              ,REGEXP_REPLACE(' '|| BKG.XTER_RMK || ' ', '[[:space:]]{2,}', ' ') AS XTER_RMK" ).append("\n"); 
		query.append("              ,REGEXP_REPLACE(' '|| DOC.CSTMS_DESC || ' ', '[[:space:]]{2,}', ' ') AS CSTMS_DESC" ).append("\n"); 
		query.append("              ,REGEXP_REPLACE(' '|| BKG.NEW_CUST_APRO_CMDT_NM || ' ', '[[:space:]]{2,}', ' ') AS NEW_CUST_APRO_CMDT_NM" ).append("\n"); 
		query.append("              ,REGEXP_REPLACE(' '|| BKG.NEW_CUST_APRO_RMK || ' ', '[[:space:]]{2,}', ' ') AS NEW_CUST_APRO_RMK                " ).append("\n"); 
		query.append("           FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append("               ,BKG_BL_DOC DOC" ).append("\n"); 
		query.append("           WHERE BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("            AND BKG.BKG_NO = DOC.BKG_NO" ).append("\n"); 
		query.append("         )BKG" ).append("\n"); 
		query.append("         ,(SELECT NON_DCGO_KW_NM,DELT_FLG,NON_DCGO_CATE_GRP_CD,NON_DCGO_KW_SEQ FROM SCG_NON_DG_CGO_KW WHERE KW_INCL_FLG IS NULL) KW" ).append("\n"); 
		query.append("   WHERE (" ).append("\n"); 
		query.append("            BKG.INTER_RMK LIKE '% ' || KW.NON_DCGO_KW_NM || ' %'  " ).append("\n"); 
		query.append("          OR BKG.XTER_RMK LIKE '% ' || KW.NON_DCGO_KW_NM || ' %' " ).append("\n"); 
		query.append("          OR bkg.CSTMS_DESC LIKE '% ' || KW.NON_DCGO_KW_NM || ' %' " ).append("\n"); 
		query.append("          OR BKG.NEW_CUST_APRO_CMDT_NM LIKE '% ' || KW.NON_DCGO_KW_NM || ' %'" ).append("\n"); 
		query.append("          OR BKG.NEW_CUST_APRO_RMK LIKE '% ' || KW.NON_DCGO_KW_NM || ' %'" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("     AND KW.DELT_FLG = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("     SELECT KW.NON_DCGO_KW_SEQ" ).append("\n"); 
		query.append("      ,RANK() OVER (PARTITION BY BKG.BKG_NO ORDER BY KW.NON_DCGO_CATE_GRP_CD) RNK" ).append("\n"); 
		query.append("    from (SELECT /*+ NO_MERGE */ BKG.BKG_NO           " ).append("\n"); 
		query.append("              ,REGEXP_REPLACE(' '|| MK.CMDT_DESC|| ' ', '[[:space:]]{2,}', ' ') AS CMDT_DESC" ).append("\n"); 
		query.append("          FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append("              ,BKG_BL_MK_DESC MK " ).append("\n"); 
		query.append("          WHERE BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("           AND BKG.BKG_NO = MK.BKG_NO" ).append("\n"); 
		query.append("         )BKG" ).append("\n"); 
		query.append("         ,(SELECT NON_DCGO_KW_NM,DELT_FLG,NON_DCGO_CATE_GRP_CD,NON_DCGO_KW_SEQ FROM SCG_NON_DG_CGO_KW WHERE KW_INCL_FLG IS NULL) KW" ).append("\n"); 
		query.append("   where (" ).append("\n"); 
		query.append("           BKG.CMDT_DESC LIKE '% ' || KW.NON_DCGO_KW_NM || ' %'" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("     AND KW.DELT_FLG = 'N' " ).append("\n"); 
		query.append("#if (${cntr_no} != '')     " ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("     SELECT KW.NON_DCGO_KW_SEQ" ).append("\n"); 
		query.append("      ,RANK() OVER (PARTITION BY BKG.BKG_NO ORDER BY KW.NON_DCGO_CATE_GRP_CD) RNK" ).append("\n"); 
		query.append("    from (SELECT /*+ NO_MERGE */ BKG.BKG_NO           " ).append("\n"); 
		query.append("              ,REGEXP_REPLACE(' '|| MF.CNTR_MF_GDS_DESC || ' ', '[[:space:]]{2,}', ' ') AS CNTR_MF_GDS_DESC" ).append("\n"); 
		query.append("          FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append("              ,BKG_CNTR_MF_DESC MF" ).append("\n"); 
		query.append("          WHERE BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("           AND MF.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("           AND BKG.BKG_NO = MF.BKG_NO" ).append("\n"); 
		query.append("         )BKG" ).append("\n"); 
		query.append("         ,(SELECT NON_DCGO_KW_NM,DELT_FLG,NON_DCGO_CATE_GRP_CD,NON_DCGO_KW_SEQ FROM SCG_NON_DG_CGO_KW WHERE KW_INCL_FLG IS NULL) KW" ).append("\n"); 
		query.append("   where (" ).append("\n"); 
		query.append("           BKG.CNTR_MF_GDS_DESC LIKE '% ' || KW.NON_DCGO_KW_NM || ' %'" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("     AND KW.DELT_FLG = 'N' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("SELECT KW.NON_DCGO_KW_SEQ" ).append("\n"); 
		query.append("      ,RANK() OVER (PARTITION BY BKG.BKG_NO ORDER BY KW.NON_DCGO_CATE_GRP_CD) RNK" ).append("\n"); 
		query.append("    from (" ).append("\n"); 
		query.append("        SELECT /*+ NO_MERGE */ BKG.BKG_NO" ).append("\n"); 
		query.append("              ,REGEXP_REPLACE(' '|| BKG.INTER_RMK || ' ', '[[:space:]]{2,}', ' ') AS INTER_RMK" ).append("\n"); 
		query.append("              ,REGEXP_REPLACE(' '|| BKG.XTER_RMK || ' ', '[[:space:]]{2,}', ' ') AS XTER_RMK" ).append("\n"); 
		query.append("              ,REGEXP_REPLACE(' '|| DOC.CSTMS_DESC || ' ', '[[:space:]]{2,}', ' ') AS CSTMS_DESC" ).append("\n"); 
		query.append("              ,REGEXP_REPLACE(' '||(select  MK.CMDT_DESC from BKG_BL_MK_DESC MK WHERE BKG.BKG_NO = MK.BKG_NO)|| ' ', '[[:space:]]{2,}', ' ') AS CMDT_DESC   " ).append("\n"); 
		query.append("#if (${cntr_no} != '')              " ).append("\n"); 
		query.append("              ,REGEXP_REPLACE(' '|| MF.CNTR_MF_GDS_DESC || ' ', '[[:space:]]{2,}', ' ') AS CNTR_MF_GDS_DESC" ).append("\n"); 
		query.append("#end              " ).append("\n"); 
		query.append("              ,REGEXP_REPLACE(' '|| BKG.NEW_CUST_APRO_CMDT_NM || ' ', '[[:space:]]{2,}', ' ') AS NEW_CUST_APRO_CMDT_NM" ).append("\n"); 
		query.append("              ,REGEXP_REPLACE(' '|| BKG.NEW_CUST_APRO_RMK || ' ', '[[:space:]]{2,}', ' ') AS NEW_CUST_APRO_RMK  " ).append("\n"); 
		query.append("          FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append("              ,BKG_BL_DOC DOC" ).append("\n"); 
		query.append("#if (${cntr_no} != '')               " ).append("\n"); 
		query.append("              ,BKG_CNTR_MF_DESC MF" ).append("\n"); 
		query.append("#end              " ).append("\n"); 
		query.append("          WHERE BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("           AND BKG.BKG_NO = DOC.BKG_NO" ).append("\n"); 
		query.append("#if (${cntr_no} != '')           " ).append("\n"); 
		query.append("           AND MF.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("           AND BKG.BKG_NO = MF.BKG_NO" ).append("\n"); 
		query.append("#end               " ).append("\n"); 
		query.append("         )BKG" ).append("\n"); 
		query.append("         ,(SELECT NON_DCGO_KW_NM,DELT_FLG,NON_DCGO_CATE_GRP_CD,NON_DCGO_KW_SEQ FROM SCG_NON_DG_CGO_KW WHERE KW_INCL_FLG = 'Y') KW" ).append("\n"); 
		query.append("   where (" ).append("\n"); 
		query.append("            BKG.INTER_RMK LIKE '%'||KW.NON_DCGO_KW_NM||'%'  " ).append("\n"); 
		query.append("          OR BKG.XTER_RMK LIKE '%'||KW.NON_DCGO_KW_NM||'%' " ).append("\n"); 
		query.append("          OR bkg.CSTMS_DESC LIKE '%'||KW.NON_DCGO_KW_NM||'%' " ).append("\n"); 
		query.append("          OR bkg.CMDT_DESC LIKE '%'||KW.NON_DCGO_KW_NM||'%' " ).append("\n"); 
		query.append("#if (${cntr_no} != '')          " ).append("\n"); 
		query.append("          OR BKG.CNTR_MF_GDS_DESC LIKE '%'||KW.NON_DCGO_KW_NM||'%'" ).append("\n"); 
		query.append("#end           " ).append("\n"); 
		query.append("          OR BKG.NEW_CUST_APRO_CMDT_NM LIKE '%'||KW.NON_DCGO_KW_NM||'%'" ).append("\n"); 
		query.append("          OR BKG.NEW_CUST_APRO_RMK LIKE '%'||KW.NON_DCGO_KW_NM||'%'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("     AND KW.DELT_FLG = 'N'" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("WHERE RNK = 1" ).append("\n"); 

	}
}
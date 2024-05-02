/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLDocumentationBLDBDAOsearchkeywordByBkgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.31
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.31 
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

public class BLDocumentationBLDBDAOsearchkeywordByBkgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BLDocumentationBLDBDAOsearchkeywordByBkgRSQL
	  * </pre>
	  */
	public BLDocumentationBLDBDAOsearchkeywordByBkgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inter_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_cust_apro_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_mf_gds_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_cust_apro_cmdt_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOsearchkeywordByBkgRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT " ).append("\n"); 
		query.append("       NON_DCGO_KW_SEQ" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("SELECT KW.NON_DCGO_KW_SEQ" ).append("\n"); 
		query.append("      ,RANK() OVER (PARTITION BY BKG.BKG_NO ORDER BY KW.NON_DCGO_CATE_GRP_CD) RNK" ).append("\n"); 
		query.append("    from (" ).append("\n"); 
		query.append("        SELECT @[bkg_no] AS BKG_NO" ).append("\n"); 
		query.append("              ,@[inter_rmk] AS INTER_RMK" ).append("\n"); 
		query.append("              ,@[xter_rmk] AS XTER_RMK" ).append("\n"); 
		query.append("              ,@[cstms_desc] AS CSTMS_DESC" ).append("\n"); 
		query.append("              ,@[cmdt_desc] AS CMDT_DESC" ).append("\n"); 
		query.append("#if (${cntr_no} != '')" ).append("\n"); 
		query.append("              ,@[cntr_mf_gds_desc] AS CNTR_MF_GDS_DESC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("              ,@[new_cust_apro_cmdt_nm] AS NEW_CUST_APRO_CMDT_NM" ).append("\n"); 
		query.append("              ,@[new_cust_apro_rmk] AS NEW_CUST_APRO_RMK" ).append("\n"); 
		query.append("          FROM DUAL" ).append("\n"); 
		query.append("         )BKG" ).append("\n"); 
		query.append("         ,(SELECT NON_DCGO_KW_NM,DELT_FLG,NON_DCGO_CATE_GRP_CD,NON_DCGO_KW_SEQ FROM SCG_NON_DG_CGO_KW WHERE KW_INCL_FLG IS NULL) KW" ).append("\n"); 
		query.append("   where (" ).append("\n"); 
		query.append("          BKG.INTER_RMK LIKE '% ' || KW.NON_DCGO_KW_NM || ' %'  " ).append("\n"); 
		query.append("          OR BKG.XTER_RMK LIKE '% ' || KW.NON_DCGO_KW_NM || ' %' " ).append("\n"); 
		query.append("          OR bkg.CSTMS_DESC LIKE '% ' || KW.NON_DCGO_KW_NM || ' %' " ).append("\n"); 
		query.append("          OR bkg.CMDT_DESC LIKE '% ' || KW.NON_DCGO_KW_NM || ' %' " ).append("\n"); 
		query.append("#if (${cntr_no} != '')" ).append("\n"); 
		query.append("          OR BKG.CNTR_MF_GDS_DESC LIKE '% ' || KW.NON_DCGO_KW_NM || ' %'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          OR BKG.NEW_CUST_APRO_CMDT_NM LIKE '% ' || KW.NON_DCGO_KW_NM || ' %'" ).append("\n"); 
		query.append("          OR BKG.NEW_CUST_APRO_RMK LIKE '% ' || KW.NON_DCGO_KW_NM || ' %'" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("     AND KW.DELT_FLG = 'N'" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("     UNION" ).append("\n"); 
		query.append("SELECT KW.NON_DCGO_KW_SEQ" ).append("\n"); 
		query.append("      ,RANK() OVER (PARTITION BY BKG.BKG_NO ORDER BY KW.NON_DCGO_CATE_GRP_CD) RNK" ).append("\n"); 
		query.append("    from (" ).append("\n"); 
		query.append("        SELECT @[bkg_no] AS BKG_NO" ).append("\n"); 
		query.append("              ,@[inter_rmk] AS INTER_RMK" ).append("\n"); 
		query.append("              ,@[xter_rmk] AS XTER_RMK" ).append("\n"); 
		query.append("              ,@[cstms_desc] AS CSTMS_DESC" ).append("\n"); 
		query.append("              ,@[cmdt_desc] AS CMDT_DESC" ).append("\n"); 
		query.append("#if (${cntr_no} != '')" ).append("\n"); 
		query.append("              ,@[cntr_mf_gds_desc] AS CNTR_MF_GDS_DESC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("              ,@[new_cust_apro_cmdt_nm] AS NEW_CUST_APRO_CMDT_NM" ).append("\n"); 
		query.append("              ,@[new_cust_apro_rmk] AS NEW_CUST_APRO_RMK" ).append("\n"); 
		query.append("          FROM DUAL" ).append("\n"); 
		query.append("         )BKG" ).append("\n"); 
		query.append("         ,(SELECT NON_DCGO_KW_NM,DELT_FLG,NON_DCGO_CATE_GRP_CD,NON_DCGO_KW_SEQ FROM SCG_NON_DG_CGO_KW WHERE KW_INCL_FLG = 'Y') KW" ).append("\n"); 
		query.append("   where (" ).append("\n"); 
		query.append("          BKG.INTER_RMK LIKE '%'||KW.NON_DCGO_KW_NM||'%'  " ).append("\n"); 
		query.append("          OR BKG.XTER_RMK LIKE '%'||KW.NON_DCGO_KW_NM||'%' " ).append("\n"); 
		query.append("          OR bkg.CSTMS_DESC LIKE '%'||KW.NON_DCGO_KW_NM||'%' " ).append("\n"); 
		query.append("          OR bkg.CMDT_DESC LIKE '%'||KW.NON_DCGO_KW_NM||'%' " ).append("\n"); 
		query.append("#if (${cntr_no} != '')" ).append("\n"); 
		query.append("          OR BKG.CNTR_MF_GDS_DESC LIKE '%'||KW.NON_DCGO_KW_NM||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          OR BKG.NEW_CUST_APRO_CMDT_NM LIKE '%'||KW.NON_DCGO_KW_NM||'%'" ).append("\n"); 
		query.append("          OR BKG.NEW_CUST_APRO_RMK LIKE '%'||KW.NON_DCGO_KW_NM||'%'" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("     AND KW.DELT_FLG = 'N'    " ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("  WHERE RNK = 1" ).append("\n"); 

	}
}
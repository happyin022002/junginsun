/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : Eur24ManifestDownloadDBDAOAddBkgCstmsEu24OBCustCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.16
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2011.06.16 김경섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24ManifestDownloadDBDAOAddBkgCstmsEu24OBCustCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eur24ManifestDownloadDBDAOAddBkgCstmsEu24OBCustCSQL
	  * </pre>
	  */
	public Eur24ManifestDownloadDBDAOAddBkgCstmsEu24OBCustCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration").append("\n"); 
		query.append("FileName : Eur24ManifestDownloadDBDAOAddBkgCstmsEu24OBCustCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_EUR_IO_CUST" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("   BND_TP_CD,         VSL_CD,            SKD_VOY_NO,       SKD_DIR_CD,      BL_NO,            CSTMS_PORT_CD,  BKG_CUST_TP_CD" ).append("\n"); 
		query.append(" , TRDR_ID_NO,        EORI_NO,          CUST_NM,         CUST_ADDR,        CUST_CTY_NM" ).append("\n"); 
		query.append(" , CSTMS_DECL_CNT_CD, CUST_ZIP_ID,      EUR_CSTMS_ST_NM " ).append("\n"); 
		query.append(" , CRE_USR_ID,        CRE_DT,           UPD_USR_ID,      UPD_DT" ).append("\n"); 
		query.append(" , CUST_CNT_CD,       CUST_SEQ" ).append("\n"); 
		query.append(")  " ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    'O',              X.VSL_CD,         X.SKD_VOY_NO,     X.SKD_DIR_CD,    X.BL_NO,          X.CSTMS_PORT_CD, X.BKG_CUST_TP_CD" ).append("\n"); 
		query.append(" ,  NULL,             EORI_NO,          CUST_NM,         CUST_ADDR,        BKG_SPCLCHAR_CONV_FNC(CUST_CTY_NM,'X')" ).append("\n"); 
		query.append(" , CSTMS_DECL_CNT_CD, BKG_SPCLCHAR_CONV_FNC(CUST_ZIP_ID,'X'),      BKG_SPCLCHAR_CONV_FNC(EUR_CSTMS_ST_NM,'X')" ).append("\n"); 
		query.append(" , @[cre_usr_id],     SYSDATE,          @[cre_usr_id],   SYSDATE         " ).append("\n"); 
		query.append(" , CUST_CNT_CD,       CUST_SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("       SELECT *" ).append("\n"); 
		query.append("       FROM (" ).append("\n"); 
		query.append("        SELECT DISTINCT" ).append("\n"); 
		query.append("               BKG_GET_TOKEN_FNC(COLUMN_VALUE,1) AS VSL_CD" ).append("\n"); 
		query.append("             , BKG_GET_TOKEN_FNC(COLUMN_VALUE,2) AS SKD_VOY_NO" ).append("\n"); 
		query.append("             , BKG_GET_TOKEN_FNC(COLUMN_VALUE,3) AS SKD_DIR_CD" ).append("\n"); 
		query.append("             , BKG_GET_TOKEN_FNC(COLUMN_VALUE,4) AS BL_NO" ).append("\n"); 
		query.append("             , BKG_GET_TOKEN_FNC(COLUMN_VALUE,5) AS CSTMS_PORT_CD" ).append("\n"); 
		query.append("        FROM TABLE(BKG_SPLIT_CLOB_FNC(${cntr_list},'@'))" ).append("\n"); 
		query.append("        WHERE COLUMN_VALUE IS NOT NULL" ).append("\n"); 
		query.append("        ) L," ).append("\n"); 
		query.append("        ( SELECT 'S' BKG_CUST_TP_CD FROM DUAL UNION ALL" ).append("\n"); 
		query.append("          SELECT 'C' BKG_CUST_TP_CD FROM DUAL UNION ALL" ).append("\n"); 
		query.append("          SELECT 'F' BKG_CUST_TP_CD FROM DUAL UNION ALL" ).append("\n"); 
		query.append("          SELECT 'N' BKG_CUST_TP_CD FROM DUAL " ).append("\n"); 
		query.append("        )M" ).append("\n"); 
		query.append("     ) X," ).append("\n"); 
		query.append("     BKG_BOOKING BKG," ).append("\n"); 
		query.append("     BKG_CUSTOMER CUST " ).append("\n"); 
		query.append("WHERE X.BL_NO = BKG.BL_NO" ).append("\n"); 
		query.append("AND BKG.BKG_NO = CUST.BKG_NO" ).append("\n"); 
		query.append("AND X.BKG_CUST_TP_CD = CUST.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("ORDER BY BL_NO,BKG_CUST_TP_CD" ).append("\n"); 

	}
}
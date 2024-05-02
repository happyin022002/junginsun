/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CLLCDLManifestDBDAOaddCdlEdiMndCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.10
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2010.02.10 김승민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM SEUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOaddCdlEdiMndCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addCdlEdiMnd
	  * </pre>
	  */
	public CLLCDLManifestDBDAOaddCdlEdiMndCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOaddCdlEdiMndCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_TML_EDI_GEN_TMP" ).append("\n"); 
		query.append("WITH BKG_CSTMS_TML_EDI_TMP_KEY AS" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("     SELECT  /*+ MATERIALIZE */ " ).append("\n"); 
		query.append("             VVD_CD, POD_CD, BKG_NO, CNTR_NO," ).append("\n"); 
		query.append("             ROW_NUMBER() OVER (PARTITION BY VVD_CD ORDER BY BKG_NO, CNTR_NO) ORD " ).append("\n"); 
		query.append("     FROM    BKG_CSTMS_TML_EDI_TMP" ).append("\n"); 
		query.append("     ORDER BY BKG_NO, CNTR_NO" ).append("\n"); 
		query.append("    ) " ).append("\n"); 
		query.append("SELECT  /*+ ORDERED USE_NL(X DOC BMD) */" ).append("\n"); 
		query.append("        X.ORD    ORD1," ).append("\n"); 
		query.append("        6        ORD2," ).append("\n"); 
		query.append("        1        ORD3,  " ).append("\n"); 
		query.append("        '{DESC'" ).append("\n"); 
		query.append("        || CHR(10) || 'DESC:' || REPLACE(DOC.PCK_CMDT_DESC,'*','-')" ).append("\n"); 
		query.append("        || CHR(10) || 'DESC:' || REPLACE(DOC.CNTR_CMDT_DESC,'*','-')" ).append("\n"); 
		query.append("        || CHR(10) || 'DESC:' || REPLACE(REPLACE(BMD.CMDT_DESC,'*','-'),CHR(10),CHR(10)||'DESC:')" ).append("\n"); 
		query.append("        || CHR(10) || '}DESC'" ).append("\n"); 
		query.append("        || CHR(10) || '{MARK'" ).append("\n"); 
		query.append("        || CHR(10) || 'MARKNO:' || REPLACE(REPLACE(BMD.MK_DESC,'*','-'),CHR(10),CHR(10)||'MARKNO:')" ).append("\n"); 
		query.append("        || CHR(10) || '}MARK'|| CHR(10)" ).append("\n"); 
		query.append("        CMDT_MK_DESC" ).append("\n"); 
		query.append("FROM   (SELECT  BKG_NO," ).append("\n"); 
		query.append("                MIN(ORD)  ORD" ).append("\n"); 
		query.append("        FROM    BKG_CSTMS_TML_EDI_TMP_KEY" ).append("\n"); 
		query.append("        GROUP BY BKG_NO" ).append("\n"); 
		query.append("       )  X," ).append("\n"); 
		query.append("        BKG_BL_DOC     DOC," ).append("\n"); 
		query.append("        BKG_BL_MK_DESC BMD" ).append("\n"); 
		query.append("WHERE   X.BKG_NO   = DOC.BKG_NO" ).append("\n"); 
		query.append("AND     DOC.BKG_NO = BMD.BKG_NO" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BLDocumentationBLDBDAOSearchCntrTpForDZRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.03 
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

public class BLDocumentationBLDBDAOSearchCntrTpForDZRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BLDocumentationBLDBDAOSearchCntrTpForDZRSQL
	  * </pre>
	  */
	public BLDocumentationBLDBDAOSearchCntrTpForDZRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOSearchCntrTpForDZRSQL").append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("SELECT CASE WHEN ETD.CNT = 0 THEN 'DZ'" ).append("\n"); 
		query.append("            WHEN ETD.CNT>0 and CNTR.DRY_CNTR > 0  AND  CNTR.SPCL_CNTR > 0 THEN 'M'" ).append("\n"); 
		query.append("            WHEN ETD.CNT>0 and CNTR.DRY_CNTR > 0  AND  CNTR.SPCL_CNTR = 0 THEN 'D'" ).append("\n"); 
		query.append("            WHEN ETD.CNT>0 and CNTR.SPCL_CNTR > 0 AND  CNTR.DRY_CNTR = 0 THEN 'S'" ).append("\n"); 
		query.append("            ELSE ''" ).append("\n"); 
		query.append("            END AS CNTR_TP" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("    SELECT SUM(DECODE(DECODE(CNTR.RD_CGO_FLG,'Y','D',SUBSTR(CNTR.CNTR_TPSZ_CD,0,1)),'D',1,0)) DRY_CNTR" ).append("\n"); 
		query.append("          ,SUM(DECODE(DECODE(CNTR.RD_CGO_FLG,'Y','D',SUBSTR(CNTR.CNTR_TPSZ_CD,0,1)),'D',0,1)) SPCL_CNTR" ).append("\n"); 
		query.append("      FROM BKG_CNTR_HIS CNTR " ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("       AND CNTR.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("       AND CNTR.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("    )CNTR" ).append("\n"); 
		query.append("   ,(" ).append("\n"); 
		query.append("    SELECT COUNT(*) CNT" ).append("\n"); 
		query.append("     FROM BKG_VVD_HIS VVD, VSK_VSL_PORT_SKD VSK" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("     AND VVD.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("     AND VVD.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("     AND VVD.VSL_CD = VSK.VSL_CD" ).append("\n"); 
		query.append("     AND VVD.SKD_VOY_NO = VSK.SKD_VOY_NO" ).append("\n"); 
		query.append("     AND VVD.SKD_DIR_CD = VSK.SKD_DIR_CD" ).append("\n"); 
		query.append("     AND VVD.POL_CD = VSK.VPS_PORT_CD" ).append("\n"); 
		query.append("     AND VVD.POL_CLPT_IND_SEQ = VSK.CLPT_IND_SEQ" ).append("\n"); 
		query.append("     AND VVD.VSL_PRE_PST_CD||VVD.VSL_SEQ = ( SELECT MIN(VSL_PRE_PST_CD||VSL_SEQ) FROM BKG_VVD_HIS VVD2 WHERE VVD2.BKG_NO = VVD.BKG_NO AND VVD2.CORR_NO= VVD.CORR_NO)" ).append("\n"); 
		query.append("     AND VSK.VPS_ETD_DT >= TO_DATE('201501010000','YYYYMMDDHH24MISS')) ETD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT CASE WHEN ETD.CNT = 0 THEN 'DZ'" ).append("\n"); 
		query.append("            WHEN ETD.CNT>0 and CNTR.DRY_CNTR > 0  AND  CNTR.SPCL_CNTR > 0 THEN 'M'" ).append("\n"); 
		query.append("            WHEN ETD.CNT>0 and CNTR.DRY_CNTR > 0  AND  CNTR.SPCL_CNTR = 0 THEN 'D'" ).append("\n"); 
		query.append("            WHEN ETD.CNT>0 and CNTR.SPCL_CNTR > 0 AND  CNTR.DRY_CNTR = 0 THEN 'S'" ).append("\n"); 
		query.append("            ELSE ''" ).append("\n"); 
		query.append("            END AS CNTR_TP" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("    SELECT SUM(DECODE(DECODE(CNTR.RD_CGO_FLG,'Y','D',SUBSTR(CNTR.CNTR_TPSZ_CD,0,1)),'D',1,0)) DRY_CNTR" ).append("\n"); 
		query.append("          ,SUM(DECODE(DECODE(CNTR.RD_CGO_FLG,'Y','D',SUBSTR(CNTR.CNTR_TPSZ_CD,0,1)),'D',0,1)) SPCL_CNTR" ).append("\n"); 
		query.append("      FROM BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("    WHERE CNTR.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("    ) CNTR" ).append("\n"); 
		query.append("   ,(" ).append("\n"); 
		query.append("    SELECT COUNT(*) CNT" ).append("\n"); 
		query.append("     FROM BKG_VVD VVD, VSK_VSL_PORT_SKD VSK" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("     AND VVD.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("     AND VVD.VSL_CD = VSK.VSL_CD" ).append("\n"); 
		query.append("     AND VVD.SKD_VOY_NO = VSK.SKD_VOY_NO" ).append("\n"); 
		query.append("     AND VVD.SKD_DIR_CD = VSK.SKD_DIR_CD" ).append("\n"); 
		query.append("     AND VVD.POL_CD = VSK.VPS_PORT_CD" ).append("\n"); 
		query.append("     AND VVD.POL_CLPT_IND_SEQ = VSK.CLPT_IND_SEQ" ).append("\n"); 
		query.append("     AND VVD.VSL_PRE_PST_CD||VVD.VSL_SEQ = ( SELECT MIN(VSL_PRE_PST_CD||VSL_SEQ) FROM BKG_VVD VVD2 WHERE VVD2.BKG_NO = VVD.BKG_NO)" ).append("\n"); 
		query.append("     AND VSK.VPS_ETD_DT >= TO_DATE('201501010000','YYYYMMDDHH24MISS')) ETD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
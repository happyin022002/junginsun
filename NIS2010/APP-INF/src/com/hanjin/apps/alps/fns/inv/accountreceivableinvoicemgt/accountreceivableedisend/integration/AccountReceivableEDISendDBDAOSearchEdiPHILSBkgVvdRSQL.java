/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOSearchEdiPHILSBkgVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.14
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOSearchEdiPHILSBkgVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEdiPHILSBkgVvd
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOSearchEdiPHILSBkgVvdRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOSearchEdiPHILSBkgVvdRSQL").append("\n"); 
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
		query.append("WITH  BKG_VVD_T  AS (" ).append("\n"); 
		query.append("                    SELECT VSL_PRE_PST_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, POL_CD, POL_CLPT_IND_SEQ, POD_CD, POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                    FROM   BKG_VVD" ).append("\n"); 
		query.append("                    WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                    ORDER BY VSL_PRE_PST_CD" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("SELECT VSL_PRE_PST_CD, VSL_CD||SKD_VOY_NO||SKD_DIR_CD VVD, " ).append("\n"); 
		query.append("       MAX(POL_CD) POL_CD, MAX(POL_CLPT_IND_SEQ) POL_CLPT_IND_SEQ, MAX(VPS_ETD_DT) VPS_ETD_DT," ).append("\n"); 
		query.append("       MAX(POD_CD) POD_CD, MAX(POD_CLPT_IND_SEQ) POD_CLPT_IND_SEQ, MAX(VPS_ETA_DT) VPS_ETA_DT," ).append("\n"); 
		query.append("       MAX(VSL_ENG_NM) VSL_NM, MAX(CALL_SGN_NO) CALL_SGN_NO, MAX(LLOYD_NO) LLOYD_NO," ).append("\n"); 
		query.append("       MAX(POL_LOC) POL_LOC_NM, MAX(POD_LOC) POD_LOC_NM" ).append("\n"); 
		query.append("FROM  (" ).append("\n"); 
		query.append("            SELECT BV.VSL_PRE_PST_CD, BV.VSL_CD, BV.SKD_VOY_NO, BV.SKD_DIR_CD, " ).append("\n"); 
		query.append("                   BV.POL_CD, BV.POL_CLPT_IND_SEQ, TO_CHAR(VPS.VPS_ETD_DT,'YYYYMMDD') VPS_ETD_DT, '' POD_CD, ''  POD_CLPT_IND_SEQ, '' VPS_ETA_DT" ).append("\n"); 
		query.append("            	,  VSL_ENG_NM, CALL_SGN_NO, LLOYD_NO" ).append("\n"); 
		query.append("           		,  ML.LOC_NM POL_LOC, '' POD_LOC " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("            FROM   BKG_VVD_T BV" ).append("\n"); 
		query.append("                 , VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("                 , MDM_VSL_CNTR MVC" ).append("\n"); 
		query.append("                 , MDM_LOCATION ML" ).append("\n"); 
		query.append("            WHERE  BV.VSL_CD = VPS.VSL_CD" ).append("\n"); 
		query.append("            AND    BV.SKD_VOY_NO = VPS.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND    BV.SKD_DIR_CD = VPS.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND    BV.POL_CD = VPS.VPS_PORT_CD" ).append("\n"); 
		query.append("            AND    BV.POL_CLPT_IND_SEQ = VPS.CLPT_IND_SEQ" ).append("\n"); 
		query.append("            AND    VPS.VSL_CD = MVC.VSL_CD" ).append("\n"); 
		query.append("            AND    BV.POL_CD = ML.LOC_CD" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT BV.VSL_PRE_PST_CD, BV.VSL_CD, BV.SKD_VOY_NO, BV.SKD_DIR_CD, " ).append("\n"); 
		query.append("                   '', '', '', BV.POD_CD, BV.POD_CLPT_IND_SEQ, TO_CHAR(VPS.VPS_ETA_DT,'YYYYMMDD') VPS_ETA_DT" ).append("\n"); 
		query.append("            	,  VSL_ENG_NM, CALL_SGN_NO, LLOYD_NO" ).append("\n"); 
		query.append("            	,  ''  POL_LOC, ML.LOC_NM POD_LOC" ).append("\n"); 
		query.append("            FROM   BKG_VVD_T BV" ).append("\n"); 
		query.append("                 , VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("                 , MDM_VSL_CNTR MVC" ).append("\n"); 
		query.append("                 , MDM_LOCATION ML" ).append("\n"); 
		query.append("            WHERE  BV.VSL_CD = VPS.VSL_CD" ).append("\n"); 
		query.append("            AND    BV.SKD_VOY_NO = VPS.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND    BV.SKD_DIR_CD = VPS.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND    BV.POD_CD = VPS.VPS_PORT_CD" ).append("\n"); 
		query.append("            AND    BV.POD_CLPT_IND_SEQ = VPS.CLPT_IND_SEQ" ).append("\n"); 
		query.append("            AND    VPS.VSL_CD = MVC.VSL_CD" ).append("\n"); 
		query.append("            AND    BV.POD_CD = ML.LOC_CD" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("GROUP BY VSL_PRE_PST_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 
		query.append("ORDER BY VSL_PRE_PST_CD" ).append("\n"); 

	}
}
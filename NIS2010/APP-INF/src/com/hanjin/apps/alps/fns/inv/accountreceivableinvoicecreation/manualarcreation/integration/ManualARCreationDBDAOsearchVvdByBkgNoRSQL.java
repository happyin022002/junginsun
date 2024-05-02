/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ManualARCreationDBDAOsearchVvdByBkgNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.14
*@LastModifier : 
*@LastVersion : 1.0
* 2013.02.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManualARCreationDBDAOsearchVvdByBkgNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ManualARCreationDBDAOsearchVvdByBkgNoRSQL
	  * </pre>
	  */
	public ManualARCreationDBDAOsearchVvdByBkgNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration").append("\n"); 
		query.append("FileName : ManualARCreationDBDAOsearchVvdByBkgNoRSQL").append("\n"); 
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
		query.append("SELECT MAX(POL_VVD) OB_VVD, MAX(POD_VVD) IB_VVD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT BV.VSL_CD || BV.SKD_VOY_NO || BV.SKD_DIR_CD POL_VVD, '' POD_VVD" ).append("\n"); 
		query.append("        FROM   BKG_VVD          BV" ).append("\n"); 
		query.append("              ,VSK_VSL_PORT_SKD ACT" ).append("\n"); 
		query.append("        WHERE  1 = 1 " ).append("\n"); 
		query.append("        AND    BV.VSL_CD = ACT.VSL_CD " ).append("\n"); 
		query.append("        AND    BV.SKD_VOY_NO = ACT.SKD_VOY_NO " ).append("\n"); 
		query.append("        AND    BV.SKD_DIR_CD = ACT.SKD_DIR_CD " ).append("\n"); 
		query.append("        AND    BV.POL_CD = ACT.VPS_PORT_CD " ).append("\n"); 
		query.append("        AND    BV.POL_CLPT_IND_SEQ = ACT.CLPT_IND_SEQ " ).append("\n"); 
		query.append("        AND    BV.BKG_NO = @[bl_no] " ).append("\n"); 
		query.append("        AND    VPS_ETD_DT = (SELECT MIN(VPS_ETD_DT)" ).append("\n"); 
		query.append("                             FROM   BKG_VVD          BV" ).append("\n"); 
		query.append("                                   ,VSK_VSL_PORT_SKD ACT" ).append("\n"); 
		query.append("                             WHERE  1 = 1 " ).append("\n"); 
		query.append("                             AND    BV.VSL_CD = ACT.VSL_CD " ).append("\n"); 
		query.append("                             AND    BV.SKD_VOY_NO = ACT.SKD_VOY_NO " ).append("\n"); 
		query.append("                             AND    BV.SKD_DIR_CD = ACT.SKD_DIR_CD " ).append("\n"); 
		query.append("                             AND    BV.POL_CD = ACT.VPS_PORT_CD " ).append("\n"); 
		query.append("                             AND    BV.POL_CLPT_IND_SEQ = ACT.CLPT_IND_SEQ " ).append("\n"); 
		query.append("                             AND    BV.BKG_NO = @[bl_no])" ).append("\n"); 
		query.append("        UNION " ).append("\n"); 
		query.append("        SELECT '' POL_VVD, BV.VSL_CD || BV.SKD_VOY_NO || BV.SKD_DIR_CD POD_VVD" ).append("\n"); 
		query.append("        FROM   BKG_VVD          BV" ).append("\n"); 
		query.append("              ,VSK_VSL_PORT_SKD ACT" ).append("\n"); 
		query.append("        WHERE  1 = 1" ).append("\n"); 
		query.append("        AND    BV.VSL_CD = ACT.VSL_CD " ).append("\n"); 
		query.append("        AND    BV.SKD_VOY_NO = ACT.SKD_VOY_NO " ).append("\n"); 
		query.append("        AND    BV.SKD_DIR_CD = ACT.SKD_DIR_CD " ).append("\n"); 
		query.append("        AND    BV.POL_CD = ACT.VPS_PORT_CD " ).append("\n"); 
		query.append("        AND    BV.POL_CLPT_IND_SEQ = ACT.CLPT_IND_SEQ " ).append("\n"); 
		query.append("        AND    BV.BKG_NO = @[bl_no] " ).append("\n"); 
		query.append("        AND    VPS_ETD_DT = (SELECT MAX(VPS_ETD_DT)" ).append("\n"); 
		query.append("                             FROM   BKG_VVD   BV" ).append("\n"); 
		query.append("                                   ,VSK_VSL_PORT_SKD ACT" ).append("\n"); 
		query.append("                             WHERE  1 = 1 " ).append("\n"); 
		query.append("                             AND BV.VSL_CD = ACT.VSL_CD " ).append("\n"); 
		query.append("                             AND BV.SKD_VOY_NO = ACT.SKD_VOY_NO " ).append("\n"); 
		query.append("                             AND BV.SKD_DIR_CD = ACT.SKD_DIR_CD " ).append("\n"); 
		query.append("                             AND BV.POL_CD = ACT.VPS_PORT_CD" ).append("\n"); 
		query.append("                             AND BV.POL_CLPT_IND_SEQ = ACT.CLPT_IND_SEQ " ).append("\n"); 
		query.append("                             AND BV.BKG_NO = @[bl_no])" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}
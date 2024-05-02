/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchBLInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.25
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOsearchBLInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Back End Bc 1
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchBLInfoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchBLInfoRSQL").append("\n"); 
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
		query.append("SELECT NVL(MAX(BKG_VVD)             ,MAX(CSTMS_VVD))              AS VVD," ).append("\n"); 
		query.append("       NVL(MAX(BKG_POD_CD)          ,MAX(CSTMS_POD_CD))           AS POD_CD," ).append("\n"); 
		query.append("       NVL(MAX(BKG_DEL_CD)          ,MAX(CSTMS_DEL_CD))           AS DEL_CD," ).append("\n"); 
		query.append("       NVL(MAX(BKG_FINC_CTRL_OFC_CD),MAX(CSTMS_FINC_CTRL_OFC_CD)) AS FINC_CTRL_OFC_CD" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD AS CSTMS_VVD," ).append("\n"); 
		query.append("               A.CSTMS_PORT_CD                      AS CSTMS_POD_CD," ).append("\n"); 
		query.append("               A.DEL_CD                             AS CSTMS_DEL_CD," ).append("\n"); 
		query.append("               B.FINC_CTRL_OFC_CD                   AS CSTMS_FINC_CTRL_OFC_CD," ).append("\n"); 
		query.append("               '' AS BKG_VVD," ).append("\n"); 
		query.append("               '' AS BKG_POD_CD," ).append("\n"); 
		query.append("               '' AS BKG_DEL_CD," ).append("\n"); 
		query.append("               '' AS BKG_FINC_CTRL_OFC_CD" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_BL A," ).append("\n"); 
		query.append("               MDM_LOCATION     B" ).append("\n"); 
		query.append("         WHERE A.BL_NO  = @[bl_no]" ).append("\n"); 
		query.append("           AND A.CSTMS_PORT_CD LIKE 'US%'" ).append("\n"); 
		query.append("           AND A.DEL_CD = B.LOC_CD(+)" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT ''," ).append("\n"); 
		query.append("               ''," ).append("\n"); 
		query.append("               ''," ).append("\n"); 
		query.append("               ''," ).append("\n"); 
		query.append("               A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD ," ).append("\n"); 
		query.append("               A.POD_CD                       ," ).append("\n"); 
		query.append("               B.DEL_CD                       ," ).append("\n"); 
		query.append("               C.FINC_CTRL_OFC_CD             " ).append("\n"); 
		query.append("          FROM  BKG_VVD      A," ).append("\n"); 
		query.append("                     BKG_BOOKING  B," ).append("\n"); 
		query.append("                     MDM_LOCATION C" ).append("\n"); 
		query.append("         WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("            AND B.BL_NO  = @[bl_no]" ).append("\n"); 
		query.append("            AND A.POD_CD LIKE 'US%'" ).append("\n"); 
		query.append("            AND B.DEL_CD = C.LOC_CD(+) " ).append("\n"); 
		query.append("            AND ROWNUM = 1" ).append("\n"); 
		query.append("       )" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ContainerMovementFinderDBDAOSearchAllVVDByBKGRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.01
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementFinderDBDAOSearchAllVVDByBKGRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAllVVDByBKG
	  * </pre>
	  */
	public ContainerMovementFinderDBDAOSearchAllVVDByBKGRSQL(){
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
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.integration").append("\n"); 
		query.append("FileName : ContainerMovementFinderDBDAOSearchAllVVDByBKGRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN VVD.VSL_PRE_PST_CD LIKE 'S' THEN 'PRE'" ).append("\n"); 
		query.append("            WHEN VVD.VSL_PRE_PST_CD LIKE 'T' THEN 'TRUNK'" ).append("\n"); 
		query.append("            WHEN VVD.VSL_PRE_PST_CD LIKE 'U' THEN 'POST'" ).append("\n"); 
		query.append("            ELSE VVD.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("       END AS VSL_PRE_PST_CD, VVD.VSL_SEQ, VVD.SLAN_CD, VVD.VVD, VVD.POL_CD, VVD.POD_CD, VVD.CRE_DT, VVD.UPD_DT" ).append("\n"); 
		query.append("FROM ( SELECT VVD.VSL_PRE_PST_CD, " ).append("\n"); 
		query.append("              VVD.VSL_SEQ, " ).append("\n"); 
		query.append("              VVD.SLAN_CD, " ).append("\n"); 
		query.append("              VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD AS VVD, " ).append("\n"); 
		query.append("              VVD.POL_YD_CD AS POL_CD, " ).append("\n"); 
		query.append("              VVD.POD_YD_CD AS POD_CD, " ).append("\n"); 
		query.append("              VVD.CRE_DT, " ).append("\n"); 
		query.append("              VVD.UPD_DT" ).append("\n"); 
		query.append("        FROM CTM_BKG_VVD VVD" ).append("\n"); 
		query.append("        WHERE VVD.BKG_NO=@[bkg_no]" ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        SELECT VVD.VSL_PRE_PST_CD, " ).append("\n"); 
		query.append("              VVD.VSL_SEQ, " ).append("\n"); 
		query.append("              VVD.SLAN_CD, " ).append("\n"); 
		query.append("               VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD AS VVD, " ).append("\n"); 
		query.append("               VVD.POL_YD_CD AS POL_CD, " ).append("\n"); 
		query.append("              VVD.POD_YD_CD AS POD_CD, " ).append("\n"); 
		query.append("               VVD.CRE_DT, " ).append("\n"); 
		query.append("               VVD.UPD_DT" ).append("\n"); 
		query.append("        FROM BKG_VVD VVD" ).append("\n"); 
		query.append("        WHERE VVD.BKG_NO=@[bkg_no]) VVD" ).append("\n"); 
		query.append("ORDER BY VVD.VSL_PRE_PST_CD, VSL_SEQ" ).append("\n"); 

	}
}
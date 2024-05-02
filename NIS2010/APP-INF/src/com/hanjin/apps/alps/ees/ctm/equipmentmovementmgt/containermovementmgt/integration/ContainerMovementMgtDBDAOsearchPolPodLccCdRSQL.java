/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOsearchPolPodLccCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.15
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2011.07.15 나상보
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sangbo La
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOsearchPolPodLccCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * POL / POD 의 LCC CODE를 조회한다
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOsearchPolPodLccCdRSQL(){
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
		params.put("cntr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOsearchPolPodLccCdRSQL").append("\n"); 
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
		query.append("SELECT  POL_LCC.POL_LCC_CD, POD_LCC.POD_LCC_CD, POL_POD.POL_CD, POL_POD.POD_CD" ).append("\n"); 
		query.append("FROM    " ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT LCC_CD AS POL_LCC_CD FROM MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("        WHERE SCC_CD = (" ).append("\n"); 
		query.append("        SELECT SCC_CD FROM MDM_LOCATION" ).append("\n"); 
		query.append("        WHERE LOC_CD  = (   SELECT  POL_CD  FROM BKG_VVD" ).append("\n"); 
		query.append("                            WHERE   BKG_NO  =   @[bkg_no]" ).append("\n"); 
		query.append("                            AND     VSL_CD  =   SUBSTR(@[cntr_id], 1, 4)" ).append("\n"); 
		query.append("                            AND     SKD_VOY_NO  =   SUBSTR(@[cntr_id], 5, 4)" ).append("\n"); 
		query.append("                            AND     SKD_DIR_CD  =   SUBSTR(@[cntr_id], 9, 1)" ).append("\n"); 
		query.append("                            ))" ).append("\n"); 
		query.append("        )   POL_LCC," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT LCC_CD  AS POD_LCC_CD FROM MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("        WHERE SCC_CD = (" ).append("\n"); 
		query.append("        SELECT SCC_CD FROM MDM_LOCATION" ).append("\n"); 
		query.append("        WHERE LOC_CD  = (   SELECT  POD_CD  FROM BKG_VVD" ).append("\n"); 
		query.append("                            WHERE   BKG_NO  =   @[bkg_no]" ).append("\n"); 
		query.append("                            AND     VSL_CD  =   SUBSTR(@[cntr_id], 1, 4)" ).append("\n"); 
		query.append("                            AND     SKD_VOY_NO  =   SUBSTR(@[cntr_id], 5, 4)" ).append("\n"); 
		query.append("                            AND     SKD_DIR_CD  =   SUBSTR(@[cntr_id], 9, 1)" ).append("\n"); 
		query.append("                            ))" ).append("\n"); 
		query.append("        )   POD_LCC," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT  POL_CD, POD_CD  FROM BKG_BOOKING" ).append("\n"); 
		query.append("                            WHERE   BKG_NO  =   @[bkg_no]" ).append("\n"); 
		query.append("        )   POL_POD" ).append("\n"); 

	}
}
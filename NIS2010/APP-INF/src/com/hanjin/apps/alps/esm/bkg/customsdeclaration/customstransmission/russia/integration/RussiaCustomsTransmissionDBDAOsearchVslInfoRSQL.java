/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RussiaCustomsTransmissionDBDAOsearchVslInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RussiaCustomsTransmissionDBDAOsearchVslInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchVslInfo
	  * </pre>
	  */
	public RussiaCustomsTransmissionDBDAOsearchVslInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.integration").append("\n"); 
		query.append("FileName : RussiaCustomsTransmissionDBDAOsearchVslInfoRSQL").append("\n"); 
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
		query.append("SELECT	SKD.VPS_PORT_CD  AS FST_PORT," ).append("\n"); 
		query.append("    	LOC.LOC_NM       AS FST_PORT_NM," ).append("\n"); 
		query.append("    	TO_CHAR(SKD.VPS_ETB_DT,'YYYYMMDDHH24MI') AS FST_ARR_DT," ).append("\n"); 
		query.append("    	VSL.NATION_CD, " ).append("\n"); 
		query.append("        NVL((SELECT X.CNT_NM FROM MDM_COUNTRY X WHERE X.CNT_CD = VSL.NATION_CD ),'') NATION_NM" ).append("\n"); 
		query.append("FROM	VSK_VSL_PORT_SKD SKD, " ).append("\n"); 
		query.append("	    MDM_LOCATION LOC," ).append("\n"); 
		query.append("     	(SELECT NVL(VSL_RGST_CNT_CD, ' ') NATION_CD" ).append("\n"); 
		query.append("         FROM	MDM_VSL_CNTR" ).append("\n"); 
		query.append("         WHERE	VSL_CD = SUBSTR(@[vvd_cd],1,4)) VSL" ).append("\n"); 
		query.append("WHERE	SKD.VPS_PORT_CD		=       LOC.LOC_CD" ).append("\n"); 
		query.append("AND	    SKD.VSL_CD			=       SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("AND	    SKD.SKD_VOY_NO	    =       SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("AND	    SKD.SKD_DIR_CD		=       SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${mode_type} == 'I') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     LOC.LOC_CD          =    @[pod_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND     LOC.LOC_CD          =    @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND     SKD.VPS_ETB_DT = ( SELECT MIN(VPS_ETB_DT)" ).append("\n"); 
		query.append("                           FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                           WHERE VSL_CD          = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                           AND   SKD_VOY_NO      = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                           AND   SKD_DIR_CD      = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                           " ).append("\n"); 
		query.append("							#if (${mode_type} == 'I') " ).append("\n"); 
		query.append("							AND   VPS_PORT_CD    =@[pod_cd]" ).append("\n"); 
		query.append("							#else" ).append("\n"); 
		query.append("							AND   VPS_PORT_CD    =@[pol_cd]" ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("                            )" ).append("\n"); 

	}
}
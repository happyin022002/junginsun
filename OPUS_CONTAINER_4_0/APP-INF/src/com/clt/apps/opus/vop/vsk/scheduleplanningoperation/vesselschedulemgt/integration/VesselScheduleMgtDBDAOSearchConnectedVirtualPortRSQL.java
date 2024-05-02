/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOSearchConnectedVirtualPortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOSearchConnectedVirtualPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Find first virtual port connected previous and next voyage.
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOSearchConnectedVirtualPortRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration ").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOSearchConnectedVirtualPortRSQL").append("\n"); 
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
		query.append("SELECT       X.VSL_CD,X.TURN_SKD_VOY_NO,X.TURN_SKD_DIR_CD       " ).append("\n"); 
		query.append("              FROM         (" ).append("\n"); 
		query.append("                            SELECT       ROW_NUMBER() OVER (PARTITION BY PS.VSL_CD,PS.SKD_VOY_NO,PS.SKD_DIR_CD ORDER BY DECODE(PS.TURN_PORT_IND_CD,'Y',1,'N',2,9) DESC, PS.CLPT_SEQ ASC) VIR_PORT_SEQ" ).append("\n"); 
		query.append("                                      ,  PS.CLPT_SEQ" ).append("\n"); 
		query.append("                                      ,  PS.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("                                      ,  PS.VSL_CD" ).append("\n"); 
		query.append("                                      ,  PS.SKD_VOY_NO" ).append("\n"); 
		query.append("                                      ,  PS.SKD_DIR_CD" ).append("\n"); 
		query.append("                                      ,  PS.VPS_PORT_CD" ).append("\n"); 
		query.append("                                      ,  PS.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                      ,  PS.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("                                      ,  PS.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                                      ,  PS.TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                            FROM         VSK_VSL_PORT_SKD     PS" ).append("\n"); 
		query.append("                            WHERE        PS.VSL_CD            = @[vsl_cd]" ).append("\n"); 
		query.append("                            AND          PS.SKD_VOY_NO        = @[skd_voy_no]" ).append("\n"); 
		query.append("                            AND          PS.SKD_DIR_CD        = @[skd_dir_cd] " ).append("\n"); 
		query.append("                            AND          PS.TURN_PORT_IND_CD  IN ('D','V','F')  " ).append("\n"); 
		query.append("                            AND          PS.TURN_SKD_VOY_NO IS NOT NULL" ).append("\n"); 
		query.append("						   ) X" ).append("\n"); 
		query.append("              WHERE        X.VIR_PORT_SEQ                     = 1" ).append("\n"); 

	}
}
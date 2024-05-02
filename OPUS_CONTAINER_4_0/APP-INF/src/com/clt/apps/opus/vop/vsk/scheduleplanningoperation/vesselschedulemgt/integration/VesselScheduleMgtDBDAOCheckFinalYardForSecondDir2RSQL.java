/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOCheckFinalYardForSecondDir2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOCheckFinalYardForSecondDir2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * YARD LEVEL FINAL PORT CHECK
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOCheckFinalYardForSecondDir2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("turn_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("turn_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOCheckFinalYardForSecondDir2RSQL").append("\n"); 
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
		query.append("SELECT    	COUNT(1)					AS KNT" ).append("\n"); 
		query.append("FROM      	VSK_PF_SKD_DTL      		PD" ).append("\n"); 
		query.append("WHERE     	1 = 1" ).append("\n"); 
		query.append("AND       	PD.TURN_PORT_IND_CD 		= 'F'" ).append("\n"); 
		query.append("AND       	(PD.VSL_SLAN_CD,PD.PF_SVC_TP_CD)" ).append("\n"); 
		query.append("          	IN" ).append("\n"); 
		query.append("          	(	SELECT VS.VSL_SLAN_CD, VS.PF_SKD_TP_CD " ).append("\n"); 
		query.append("				FROM	VSK_VSL_SKD 	VS " ).append("\n"); 
		query.append("				WHERE 	VS.VSL_CD 		= @[vsl_cd]" ).append("\n"); 
		query.append("				AND 	VS.SKD_VOY_NO 	= @[turn_skd_voy_no]" ).append("\n"); 
		query.append("				AND 	VS.SKD_DIR_CD 	= @[turn_skd_dir_cd]" ).append("\n"); 
		query.append("          	)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND       	PD.YD_CD            		= @[vps_port_cd]||@[tml_cd]" ).append("\n"); 

	}
}
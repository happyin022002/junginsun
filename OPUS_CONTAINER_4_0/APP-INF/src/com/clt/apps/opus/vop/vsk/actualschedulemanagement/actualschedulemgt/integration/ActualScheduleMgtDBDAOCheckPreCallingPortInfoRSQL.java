/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ActualScheduleMgtDBDAOCheckPreCallingPortInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ActualScheduleMgtDBDAOCheckPreCallingPortInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ActualScheduleMgtDBDAOCheckPreCallingPortInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_brth_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_dep_dt",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.integration").append("\n"); 
		query.append("FileName : ActualScheduleMgtDBDAOCheckPreCallingPortInfoRSQL").append("\n"); 
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
		query.append("SELECT  CASE WHEN TO_DATE(@[act_arr_dt], 'YYYYMMDDHH24MI') - PRE_ETD_DT <= 0" ).append("\n"); 
		query.append("			    OR TO_DATE(@[act_brth_dt],'YYYYMMDDHH24MI') - PRE_ETD_DT <= 0" ).append("\n"); 
		query.append("	   	 	    OR TO_DATE(@[act_dep_dt],'YYYYMMDDHH24MI') - PRE_ETD_DT <= 0" ).append("\n"); 
		query.append("             THEN 'N'" ).append("\n"); 
		query.append("             ELSE 'Y'" ).append("\n"); 
		query.append("        END AS CHK_FLG" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        SELECT  (" ).append("\n"); 
		query.append("                SELECT  S1.VPS_ETD_DT" ).append("\n"); 
		query.append("                FROM    VSK_VSL_PORT_SKD S1" ).append("\n"); 
		query.append("                WHERE   VSL_CD      = T1.VSL_CD" ).append("\n"); 
		query.append("                AND     SKD_VOY_NO = CASE WHEN T1.CLPT_SEQ = '1' THEN T1.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("                                          ELSE T1.SKD_VOY_NO" ).append("\n"); 
		query.append("        		                     END" ).append("\n"); 
		query.append("                AND	SKD_DIR_CD = CASE WHEN T1.CLPT_SEQ = '1' THEN T1.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                                      ELSE T1.SKD_DIR_CD" ).append("\n"); 
		query.append("                  	              END" ).append("\n"); 
		query.append("                AND	CLPT_SEQ = CASE WHEN T1.CLPT_SEQ = '1'" ).append("\n"); 
		query.append("                                    THEN (SELECT MAX(CLPT_SEQ) FROM VSK_VSL_PORT_SKD WHERE VSL_CD=T1.VSL_CD AND SKD_VOY_NO = T1.TURN_SKD_VOY_NO AND SKD_DIR_CD = T1.TURN_SKD_DIR_CD 			AND TURN_PORT_IND_CD NOT IN ('D', 'V', 'F'))" ).append("\n"); 
		query.append("                                    ELSE T1.CLPT_SEQ - 1" ).append("\n"); 
		query.append("        		               END" ).append("\n"); 
		query.append("                ) AS PRE_ETD_DT" ).append("\n"); 
		query.append("        FROM	VSK_VSL_PORT_SKD T1" ).append("\n"); 
		query.append("        WHERE	VSL_CD		    = @[vsl_cd]" ).append("\n"); 
		query.append("        AND	    SKD_VOY_NO	    = @[skd_voy_no]" ).append("\n"); 
		query.append("        AND	    SKD_DIR_CD	    = @[skd_dir_cd]" ).append("\n"); 
		query.append("        AND	    VPS_PORT_CD	    = @[vps_port_cd]" ).append("\n"); 
		query.append("        AND	    CLPT_IND_SEQ	= @[clpt_ind_seq]" ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}
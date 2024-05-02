/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOSearchEdiMsgToDLSRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.08
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOSearchEdiMsgToDLSRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEdiMsgToDLS
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOSearchEdiMsgToDLSRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOSearchEdiMsgToDLSRSQL").append("\n"); 
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
		query.append("SELECT  T1.VSL_CD																	AS VSL_CD" ).append("\n"); 
		query.append(", T1.SKD_VOY_NO																AS VOY" ).append("\n"); 
		query.append(", T1.SKD_DIR_CD																AS DIR" ).append("\n"); 
		query.append(", RPAD(NVL(T1.VPS_PORT_CD,   ' '),  5, ' ')									AS POL_LOC" ).append("\n"); 
		query.append(", RPAD(NVL(T1.SLAN_CD,  ' '),  3, ' ')										AS LANE" ).append("\n"); 
		query.append(", RPAD(NVL(VSL_ENG_NM,   ' '), 30, ' ')										AS VSL_NM" ).append("\n"); 
		query.append(", RPAD(NVL(TO_CHAR(T1.VPS_ETB_DT - 0.4, 'RRRRMMDDHH24MI'), ' '), 12, ' ')	AS CCT" ).append("\n"); 
		query.append(", RPAD(NVL(TO_CHAR(T1.VPS_ETB_DT, 'RRRRMMDDHH24MI'), ' '), 12, ' ')			AS ETB" ).append("\n"); 
		query.append(", RPAD(NVL(TO_CHAR(T1.VPS_ETD_DT, 'RRRRMMDDHH24MI'), ' '), 12, ' ')			AS ETD" ).append("\n"); 
		query.append("FROM    VSK_VSL_PORT_SKD T1, MDM_VSL_CNTR T2, VSK_VSL_SKD T3" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND     T1.VSL_CD       = T3.VSL_CD" ).append("\n"); 
		query.append("AND     T1.SKD_VOY_NO   = T3.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     T1.SKD_DIR_CD   = T3.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     T1.VSL_CD		= T2.VSL_CD" ).append("\n"); 
		query.append("AND     T1.VSL_CD		= @[vsl_cd]" ).append("\n"); 
		query.append("AND     T1.SKD_VOY_NO	= @[skd_voy_no]" ).append("\n"); 
		query.append("AND     T1.SKD_DIR_CD	= @[skd_dir_cd]" ).append("\n"); 
		query.append("AND     T3.SKD_STS_CD   = 'ACT'" ).append("\n"); 
		query.append("AND     'KR'            = SUBSTR(T1.VPS_PORT_CD, 1, 2)" ).append("\n"); 
		query.append("ORDER BY CLPT_SEQ" ).append("\n"); 

	}
}
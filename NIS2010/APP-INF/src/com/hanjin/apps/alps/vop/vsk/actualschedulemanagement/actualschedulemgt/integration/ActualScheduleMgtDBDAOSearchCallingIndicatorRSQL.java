/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ActualScheduleMgtDBDAOSearchCallingIndicatorRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.20
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2010.02.20 정진우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Jinwoo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ActualScheduleMgtDBDAOSearchCallingIndicatorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCallingIndicator
	  * </pre>
	  */
	public ActualScheduleMgtDBDAOSearchCallingIndicatorRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.integration").append("\n"); 
		query.append("FileName : ActualScheduleMgtDBDAOSearchCallingIndicatorRSQL").append("\n"); 
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
		query.append("SELECT	NVL(MAX(CLPT_IND_SEQ), '1') AS CLPT_IND_SEQ" ).append("\n"); 
		query.append("FROM	VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE	VSL_CD			= @[vsl_cd]" ).append("\n"); 
		query.append("AND		SKD_VOY_NO		= @[skd_voy_no]" ).append("\n"); 
		query.append("AND		SKD_DIR_CD		= @[skd_dir_cd]" ).append("\n"); 
		query.append("AND		VPS_PORT_CD		= @[vps_port_cd]" ).append("\n"); 
		query.append("AND		YD_CD			= @[yd_cd]" ).append("\n"); 

	}
}
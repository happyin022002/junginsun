/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ExternalFinderDBDAOSearchLaneCodeListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.11
*@LastModifier : 
*@LastVersion : 1.0
* 2010.08.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExternalFinderDBDAOSearchLaneCodeListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ExternalFinderDBDAOSearchLaneCodeListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_svc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.integration").append("\n"); 
		query.append("FileName : ExternalFinderDBDAOSearchLaneCodeListVORSQL").append("\n"); 
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
		query.append("select " ).append("\n"); 
		query.append("	vsl_slan_cd," ).append("\n"); 
		query.append("	vsl_slan_nm," ).append("\n"); 
		query.append("	vsl_svc_tp_cd," ).append("\n"); 
		query.append("	decode(vsl_svc_tp_cd,'O','Off','Trunk') trunk_on_off" ).append("\n"); 
		query.append("from mdm_vsl_svc_lane" ).append("\n"); 
		query.append("where	vsl_slan_cd like '%'||@[vsl_slan_cd]||'%'" ).append("\n"); 
		query.append("and upper(vsl_slan_nm) like '%'||upper(@[vsl_slan_nm])||'%'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vsl_svc_tp_cd} == 'O') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("and vsl_svc_tp_cd = @[vsl_svc_tp_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${vsl_svc_tp_cd} == 'T')  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("and vsl_svc_tp_cd <> 'O'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("and delt_flg = 'N'" ).append("\n"); 

	}
}
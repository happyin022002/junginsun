/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InterfaceScheduleToExternalScnDBDAOInsertPortScnInterfaceCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.13
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternalscn.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InterfaceScheduleToExternalScnDBDAOInsertPortScnInterfaceCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INSERT PORT SCN
	  * </pre>
	  */
	public InterfaceScheduleToExternalScnDBDAOInsertPortScnInterfaceCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insf_dv_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_cssm_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_cssm_voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternalscn.integration").append("\n"); 
		query.append("FileName : InterfaceScheduleToExternalScnDBDAOInsertPortScnInterfaceCSQL").append("\n"); 
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
		query.append("INSERT INTO " ).append("\n"); 
		query.append("       VSK_VSL_CSSM_VOY_NO_IF" ).append("\n"); 
		query.append("      ( " ).append("\n"); 
		query.append("         VSL_CD" ).append("\n"); 
		query.append("       , SKD_VOY_NO" ).append("\n"); 
		query.append("       , SKD_DIR_CD" ).append("\n"); 
		query.append("       , VPS_PORT_CD" ).append("\n"); 
		query.append("       , CSSM_VOY_NO_IF_SEQ" ).append("\n"); 
		query.append("       , VSL_SLAN_CD" ).append("\n"); 
		query.append("       , IB_CSSM_VOY_NO" ).append("\n"); 
		query.append("       , OB_CSSM_VOY_NO" ).append("\n"); 
		query.append("       , INSF_ID" ).append("\n"); 
		query.append("       , INSF_DV_CD" ).append("\n"); 
		query.append("       , CRE_USR_ID" ).append("\n"); 
		query.append("       , CRE_DT" ).append("\n"); 
		query.append("       , UPD_USR_ID" ).append("\n"); 
		query.append("       , UPD_DT " ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("     VALUES" ).append("\n"); 
		query.append("     ( @[vsl_cd]" ).append("\n"); 
		query.append("     , @[skd_voy_no]" ).append("\n"); 
		query.append("     , @[skd_dir_cd] " ).append("\n"); 
		query.append("     , @[vps_port_cd]" ).append("\n"); 
		query.append("     , VSK_VSL_CSSM_VOY_NO_IF_SEQ.NEXTVAL" ).append("\n"); 
		query.append("     , @[vsl_slan_cd]" ).append("\n"); 
		query.append("     , @[ib_cssm_voy_no]" ).append("\n"); 
		query.append("     , @[ob_cssm_voy_no]" ).append("\n"); 
		query.append("     , 'OPEDI002'" ).append("\n"); 
		query.append("     , @[insf_dv_cd]" ).append("\n"); 
		query.append("     , NVL(@[cre_usr_id],'SYSTEM')" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("     , NVL(@[upd_usr_id],'SYSTEM')" ).append("\n"); 
		query.append("     , SYSDATE)" ).append("\n"); 

	}
}
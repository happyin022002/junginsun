/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ConsortiumVoyageMgtDBDAOUpdateConsortiumVoyageUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleutilitymanagement.consortiumvoyagemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConsortiumVoyageMgtDBDAOUpdateConsortiumVoyageUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Update Cssm
	  * </pre>
	  */
	public ConsortiumVoyageMgtDBDAOUpdateConsortiumVoyageUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleutilitymanagement.consortiumvoyagemgt.integration").append("\n"); 
		query.append("FileName : ConsortiumVoyageMgtDBDAOUpdateConsortiumVoyageUSQL").append("\n"); 
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
		query.append("UPDATE 		VSK_VSL_PORT_SKD				X" ).append("\n"); 
		query.append("SET 		X.IB_CSSM_VOY_NO 				= @[ib_cssm_voy_no]" ).append("\n"); 
		query.append("		,	X.OB_CSSM_VOY_NO 				= CASE WHEN TURN_PORT_IND_CD NOT IN ('D','V','F') THEN @[ob_cssm_voy_no] ELSE '' END " ).append("\n"); 
		query.append("		,	X.UPD_USR_ID     				= @[upd_usr_id]" ).append("\n"); 
		query.append("		,	X.UPD_DT         				= SYSDATE" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("			--::ADD:2015-05-15:by TOP::--" ).append("\n"); 
		query.append("		,	X.CSSM_VOY_INIT_CRE_FLG  		= 'N'" ).append("\n"); 
		query.append("			-----------------------------" ).append("\n"); 
		query.append("WHERE		X.VSL_CD          				= @[vsl_cd]" ).append("\n"); 
		query.append("AND 		X.SKD_VOY_NO	  				= @[skd_voy_no]" ).append("\n"); 
		query.append("AND 		X.SKD_DIR_CD    				= @[skd_dir_cd]" ).append("\n"); 
		query.append("AND 		X.VPS_PORT_CD   				= @[vps_port_cd]" ).append("\n"); 
		query.append("AND			X.CLPT_IND_SEQ					= @[clpt_ind_seq]" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ProformaScheduleMgtDBDAOAddVskPfSkdDirCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProformaScheduleMgtDBDAOAddVskPfSkdDirCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VSK_PF_SKD_DIR 테이블에 데이터 생성
	  * </pre>
	  */
	public ProformaScheduleMgtDBDAOAddVskPfSkdDirCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pf_svc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration").append("\n"); 
		query.append("FileName : ProformaScheduleMgtDBDAOAddVskPfSkdDirCSQL").append("\n"); 
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
		query.append("INSERT INTO	VSK_PF_SKD_DIR" ).append("\n"); 
		query.append("          	(	VSL_SLAN_CD" ).append("\n"); 
		query.append("            ,  	PF_SVC_TP_CD" ).append("\n"); 
		query.append("            ,  	VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("            ,  	VSL_SLAN_DIR_SEQ" ).append("\n"); 
		query.append("            ,  	DELT_FLG" ).append("\n"); 
		query.append("            ,  	CRE_USR_ID" ).append("\n"); 
		query.append("            ,  	CRE_DT" ).append("\n"); 
		query.append("            ,	UPD_USR_ID" ).append("\n"); 
		query.append("            ,	UPD_DT " ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("SELECT      	VSL_SLAN_CD" ).append("\n"); 
		query.append("            ,	@[pf_svc_tp_cd]			AS PF_SVC_TP_CD" ).append("\n"); 
		query.append("            ,	VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("            ,	VSL_SLAN_DIR_SEQ" ).append("\n"); 
		query.append("            ,	DELT_FLG" ).append("\n"); 
		query.append("            ,	UPD_USR_ID				AS CRE_USR_ID" ).append("\n"); 
		query.append("            ,	UPD_DT					AS CRE_DT" ).append("\n"); 
		query.append("            ,	'SYSTEM'" ).append("\n"); 
		query.append("            ,	SYSDATE" ).append("\n"); 
		query.append("FROM       		MDM_VSL_SVC_LANE_DIR 	Y" ).append("\n"); 
		query.append("WHERE      		Y.VSL_SLAN_CD        	= @[vsl_slan_cd]" ).append("\n"); 

	}
}
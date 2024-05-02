/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ProformaScheduleMgtDBDAOCheckPfTypeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.27
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.11.27 서창열
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEO CHANG YUL
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProformaScheduleMgtDBDAOCheckPfTypeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CheckPfType
	  * </pre>
	  */
	public ProformaScheduleMgtDBDAOCheckPfTypeRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration").append("\n"); 
		query.append("FileName : ProformaScheduleMgtDBDAOCheckPfTypeRSQL").append("\n"); 
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
		query.append("SELECT	NVL(VSL_SKD, 'N') || ':' || NVL(PF_SKD, 'N') AS FLAG" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("SELECT	'1' AS SEQ,	'Y'	AS VSL_SKD" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 
		query.append("WHERE	EXISTS (	SELECT	'X'" ).append("\n"); 
		query.append("FROM	VSK_VSL_SKD" ).append("\n"); 
		query.append("WHERE	VSL_SLAN_CD		= @[vsl_slan_cd]" ).append("\n"); 
		query.append("AND		PF_SKD_TP_CD	= @[pf_svc_tp_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") T1, (" ).append("\n"); 
		query.append("SELECT	'1' AS SEQ,	'Y'	AS PF_SKD" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 
		query.append("WHERE	EXISTS (	SELECT	'X'" ).append("\n"); 
		query.append("FROM	VSK_PF_SKD" ).append("\n"); 
		query.append("WHERE	VSL_SLAN_CD		= @[vsl_slan_cd]" ).append("\n"); 
		query.append("AND		PF_SVC_TP_CD	= @[pf_svc_tp_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") T2," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT	'1' AS SEQ" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 
		query.append(") T3" ).append("\n"); 
		query.append("WHERE	T3.SEQ	= T1.SEQ	(+)" ).append("\n"); 
		query.append("AND		T3.SEQ	= T2.SEQ	(+)" ).append("\n"); 

	}
}
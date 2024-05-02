/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ProformaScheduleMgtDBDAORemoveVskPfSkdDtlDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.18
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.06.18 서창열
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEO CHANG YUL
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProformaScheduleMgtDBDAORemoveVskPfSkdDtlDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * removeVskPfSkdDtl
	  * </pre>
	  */
	public ProformaScheduleMgtDBDAORemoveVskPfSkdDtlDSQL(){
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
		query.append("DELETE	FROM VSK_PF_SKD_DTL" ).append("\n"); 
		query.append("WHERE	VSL_SLAN_CD		= @[vsl_slan_cd]" ).append("\n"); 
		query.append("AND	    PF_SVC_TP_CD	= @[pf_svc_tp_cd]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.nis2010.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration").append("\n"); 
		query.append("FileName : ProformaScheduleMgtDBDAORemoveVskPfSkdDtlDSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}
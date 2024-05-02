/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Edi214ReceiveDBDAOSearchActualDateInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.01
*@LastModifier : 이중환
*@LastVersion : 1.0
* 2009.12.01 이중환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.visibilitymanage.edi214receive.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Joong Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi214ReceiveDBDAOSearchActualDateInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select actual
	  * </pre>
	  */
	public Edi214ReceiveDBDAOSearchActualDateInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.visibilitymanage.edi214Receive.integration ").append("\n"); 
		query.append("FileName : Edi214ReceiveDBDAOSearchActualDateInfoRSQL").append("\n"); 
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
		query.append("select '' cop_seq," ).append("\n"); 
		query.append("'' upd_dt," ).append("\n"); 
		query.append("'' trsp_wo_seq," ).append("\n"); 
		query.append("'' trsp_so_seq," ).append("\n"); 
		query.append("'' cre_dt," ).append("\n"); 
		query.append("'' rcv_mnt," ).append("\n"); 
		query.append("'' bl_no," ).append("\n"); 
		query.append("'' bnd_seq," ).append("\n"); 
		query.append("'' trsp_wo_ofc_cty_cd," ).append("\n"); 
		query.append("'' trsp_so_ofc_cty_cd," ).append("\n"); 
		query.append("'' act_rcv_no," ).append("\n"); 
		query.append("'' cre_usr_id," ).append("\n"); 
		query.append("'' bkg_no," ).append("\n"); 
		query.append("'' de_cond_cd," ).append("\n"); 
		query.append("'' rcv_dt," ).append("\n"); 
		query.append("'' cntr_no," ).append("\n"); 
		query.append("'' rcv_hr," ).append("\n"); 
		query.append("'' act_rcv_dt," ).append("\n"); 
		query.append("'' upd_usr_id," ).append("\n"); 
		query.append("'' apnt_sts_cd" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}
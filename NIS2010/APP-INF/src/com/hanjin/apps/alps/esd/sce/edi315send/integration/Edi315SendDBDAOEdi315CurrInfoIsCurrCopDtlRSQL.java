/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315SendDBDAOEdi315CurrInfoIsCurrCopDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.17
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOEdi315CurrInfoIsCurrCopDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * for is_curr_cop_dtl vo
	  * </pre>
	  */
	public Edi315SendDBDAOEdi315CurrInfoIsCurrCopDtlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOEdi315CurrInfoIsCurrCopDtlRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("--''curr_cop_no			          ," ).append("\n"); 
		query.append("--''curr_cop_dtl_seq                ," ).append("\n"); 
		query.append("--''curr_stnd_edi_sts_cd            ," ).append("\n"); 
		query.append("--''curr_act_cd                     ," ).append("\n"); 
		query.append("--''curr_act_sts_mapg_cd            ," ).append("\n"); 
		query.append("''curr_event_dt                   ," ).append("\n"); 
		query.append("''curr_event_yard" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}
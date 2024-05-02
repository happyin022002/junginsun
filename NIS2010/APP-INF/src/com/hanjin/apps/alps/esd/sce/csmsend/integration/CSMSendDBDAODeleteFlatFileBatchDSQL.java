/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CSMSendDBDAODeleteFlatFileBatchDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.csmsend.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSMSendDBDAODeleteFlatFileBatchDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DeleteFlatFileBatch
	  * </pre>
	  */
	public CSMSendDBDAODeleteFlatFileBatchDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.csmsend.integration ").append("\n"); 
		query.append("FileName : CSMSendDBDAODeleteFlatFileBatchDSQL").append("\n"); 
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
		query.append("delete" ).append("\n"); 
		query.append("from sce_cntr_sts_msg_flt_file" ).append("\n"); 
		query.append("where edi_snd_yrmondy <= to_char(sysdate - 7, 'yymmdd')" ).append("\n"); 
		query.append("and nvl(rslt_flg, 'N') = 'Y'" ).append("\n"); 

	}
}
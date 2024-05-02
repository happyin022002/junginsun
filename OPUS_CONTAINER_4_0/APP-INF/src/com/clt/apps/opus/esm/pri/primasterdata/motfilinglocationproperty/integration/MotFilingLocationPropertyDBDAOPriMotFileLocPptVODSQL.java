/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MotFilingLocationPropertyDBDAOPriMotFileLocPptVODSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.08
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2014.07.08 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.motfilinglocationproperty.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHLOE MIJIN SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MotFilingLocationPropertyDBDAOPriMotFileLocPptVODSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PriMotFileLocPpt Delete
	  * </pre>
	  */
	public MotFilingLocationPropertyDBDAOPriMotFileLocPptVODSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.primasterdata.motfilinglocationproperty.integration").append("\n"); 
		query.append("FileName : MotFilingLocationPropertyDBDAOPriMotFileLocPptVODSQL").append("\n"); 
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
		query.append("DELETE	PRI_MOT_FILE_LOC_PPT" ).append("\n"); 
		query.append("WHERE   ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("AND     LOC_CD = @[loc_cd]" ).append("\n"); 

	}
}
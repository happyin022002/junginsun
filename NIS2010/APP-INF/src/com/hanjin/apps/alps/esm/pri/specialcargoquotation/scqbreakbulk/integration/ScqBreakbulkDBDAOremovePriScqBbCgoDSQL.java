/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScqBreakbulkDBDAOremovePriScqBbCgoDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.19
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.03.19 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dong-sun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScqBreakbulkDBDAOremovePriScqBbCgoDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * removePriScqBbCgo
	  * </pre>
	  */
	public ScqBreakbulkDBDAOremovePriScqBbCgoDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scq_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scq_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.integration ").append("\n"); 
		query.append("FileName : ScqBreakbulkDBDAOremovePriScqBbCgoDSQL").append("\n"); 
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
		query.append("DELETE PRI_SCQ_BB_CGO         " ).append("\n"); 
		query.append(" WHERE SCQ_RQST_NO = @[scq_rqst_no]     " ).append("\n"); 
		query.append("   AND SCQ_VER_NO  = @[scq_ver_no]       " ).append("\n"); 
		query.append("   AND CGO_SEQ     = @[cgo_seq]" ).append("\n"); 

	}
}
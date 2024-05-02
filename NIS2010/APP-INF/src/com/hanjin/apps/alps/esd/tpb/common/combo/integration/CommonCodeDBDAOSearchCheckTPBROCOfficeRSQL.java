/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CommonCodeDBDAOSearchCheckTPBROCOfficeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.02
*@LastModifier : 
*@LastVersion : 1.0
* 2012.08.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.common.combo.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonCodeDBDAOSearchCheckTPBROCOfficeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCheckTPBROCOffice
	  * </pre>
	  */
	public CommonCodeDBDAOSearchCheckTPBROCOfficeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.common.combo.integration ").append("\n"); 
		query.append("FileName : CommonCodeDBDAOSearchCheckTPBROCOfficeRSQL").append("\n"); 
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
		query.append("SELECT STL_RQST_OFC_CD" ).append("\n"); 
		query.append("FROM TPB_ADJ_STS" ).append("\n"); 
		query.append("WHERE N3PTY_NO = @[n3pty_no]" ).append("\n"); 
		query.append("AND   STL_STS_LST_FLG = 'Y'" ).append("\n"); 

	}
}
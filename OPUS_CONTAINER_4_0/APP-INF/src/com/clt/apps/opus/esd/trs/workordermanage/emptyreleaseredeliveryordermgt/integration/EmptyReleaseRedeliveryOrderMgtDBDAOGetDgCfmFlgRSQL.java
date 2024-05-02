/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EmptyReleaseRedeliveryOrderMgtDBDAOGetDgCfmFlgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.01
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2016.02.01 박찬우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chanwoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyReleaseRedeliveryOrderMgtDBDAOGetDgCfmFlgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DG booking의 Special Cargo Approval 여부를 조회하는 SQL
	  * </pre>
	  */
	public EmptyReleaseRedeliveryOrderMgtDBDAOGetDgCfmFlgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.integration ").append("\n"); 
		query.append("FileName : EmptyReleaseRedeliveryOrderMgtDBDAOGetDgCfmFlgRSQL").append("\n"); 
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
		query.append("SELECT CASE" ).append("\n"); 
		query.append("           WHEN DCGO_FLG = 'N'" ).append("\n"); 
		query.append("           THEN 'Y'" ).append("\n"); 
		query.append("           WHEN BKG_STS_CD <> 'F'" ).append("\n"); 
		query.append("           THEN 'N'" ).append("\n"); 
		query.append("           ELSE 'Y'" ).append("\n"); 
		query.append("       END DG_CFM_FLG" ).append("\n"); 
		query.append("  FROM BKG_BOOKING" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}
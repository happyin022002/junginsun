/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CopDetailReceiveDBDAOSearchCopRailActDtObRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.05
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.copdetailreceive.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOSearchCopRailActDtObRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCopRailActDtOb
	  * </pre>
	  */
	public CopDetailReceiveDBDAOSearchCopRailActDtObRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.copdetailreceive.integration ").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOSearchCopRailActDtObRSQL").append("\n"); 
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
		query.append("SELECT (SELECT COUNT(ACT_DT) FROM   SCE_COP_DTL WHERE  COP_NO      = @[cop_no]" ).append("\n"); 
		query.append("AND    COP_DTL_SEQ < 4000" ).append("\n"); 
		query.append("AND    ACT_CD      = 'FORRAD'" ).append("\n"); 
		query.append("AND    ACT_DT  IS NOT NULL ) cop_actra_chk" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}
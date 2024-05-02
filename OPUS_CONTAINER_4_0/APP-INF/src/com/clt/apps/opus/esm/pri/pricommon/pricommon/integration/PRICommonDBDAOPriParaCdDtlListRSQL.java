/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PRICommonDBDAOPriParaCdDtlListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.03
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.pricommon.pricommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAOPriParaCdDtlListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI_PARA_CD_DTL
	  * </pre>
	  */
	public PRICommonDBDAOPriParaCdDtlListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hrd_cdg_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hrd_cdg_id_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.pricommon.pricommon.integration ").append("\n"); 
		query.append("FileName : PRICommonDBDAOPriParaCdDtlListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("       HRD_CDG_ID" ).append("\n"); 
		query.append("     , HRD_CDG_ID_SEQ" ).append("\n"); 
		query.append("     , ATTR_CTNT1" ).append("\n"); 
		query.append("     , ATTR_CTNT2" ).append("\n"); 
		query.append("     , ATTR_CTNT3" ).append("\n"); 
		query.append("     , ATTR_CTNT4" ).append("\n"); 
		query.append("     , ATTR_CTNT5" ).append("\n"); 
		query.append("     , ATTR_CTNT6" ).append("\n"); 
		query.append("     , ATTR_CTNT7" ).append("\n"); 
		query.append("     , ATTR_CTNT8" ).append("\n"); 
		query.append("     , ATTR_CTNT9" ).append("\n"); 
		query.append("     , ATTR_CTNT10" ).append("\n"); 
		query.append("     , CRE_USR_ID" ).append("\n"); 
		query.append("     , CRE_DT" ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append("     , UPD_DT " ).append("\n"); 
		query.append("  FROM PRI_PARA_CD_DTL" ).append("\n"); 
		query.append(" WHERE HRD_CDG_ID = @[hrd_cdg_id]" ).append("\n"); 
		query.append("#if( ${hrd_cdg_id_seq} != '' ) then" ).append("\n"); 
		query.append("    AND HRD_CDG_ID_SEQ = @[hrd_cdg_id_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PRICommonDBDAOSpScpGrpLocNmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.26
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.11.26 박성수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sungsoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAOSpScpGrpLocNmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Proposal Group Location Name
	  * </pre>
	  */
	public PRICommonDBDAOSpScpGrpLocNmRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAOSpScpGrpLocNmRSQL").append("\n"); 
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
		query.append("SELECT PRC_GRP_LOC_DESC" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_GRP_LOC A" ).append("\n"); 
		query.append("WHERE	PROP_NO = @[etc1]" ).append("\n"); 
		query.append("AND	AMDT_SEQ = @[etc2]" ).append("\n"); 
		query.append("AND SVC_SCP_CD = @[etc3]" ).append("\n"); 
		query.append("AND PRC_GRP_LOC_CD = @[cd]" ).append("\n"); 
		query.append("AND EXISTS (SELECT 'OK'" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_GRP_LOC_DTL S" ).append("\n"); 
		query.append("WHERE S.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("AND S.AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("AND S.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND S.GRP_LOC_SEQ = A.GRP_LOC_SEQ" ).append("\n"); 
		query.append("AND S.SRC_INFO_CD <> 'AD')" ).append("\n"); 

	}
}
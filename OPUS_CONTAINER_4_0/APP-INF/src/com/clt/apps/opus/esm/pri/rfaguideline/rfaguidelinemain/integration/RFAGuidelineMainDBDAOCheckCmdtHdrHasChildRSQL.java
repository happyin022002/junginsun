/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAGuidelineMainDBDAOCheckCmdtHdrHasChildRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.08.11 박성수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaguideline.rfaguidelinemain.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sungsoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAGuidelineMainDBDAOCheckCmdtHdrHasChildRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Confirm시 CMDT_HDR이 Route를 가지는지 여부체크
	  * </pre>
	  */
	public RFAGuidelineMainDBDAOCheckCmdtHdrHasChildRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.rfaguideline.rfaguidelinemain.integration ").append("\n"); 
		query.append("FileName : RFAGuidelineMainDBDAOCheckCmdtHdrHasChildRSQL").append("\n"); 
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
		query.append("SELECT CMDT_HDR_SEQ" ).append("\n"); 
		query.append("FROM PRI_RG_RT_CMDT_HDR A" ).append("\n"); 
		query.append("WHERE NOT EXISTS (SELECT 'OK'" ).append("\n"); 
		query.append("FROM PRI_RG_RT_CMDT_ROUT S" ).append("\n"); 
		query.append("WHERE A.SVC_SCP_CD = S.SVC_SCP_CD" ).append("\n"); 
		query.append("AND A.GLINE_SEQ = S.GLINE_SEQ" ).append("\n"); 
		query.append("AND A.CMDT_HDR_SEQ = S.CMDT_HDR_SEQ)" ).append("\n"); 
		query.append("AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND GLINE_SEQ = @[gline_seq]" ).append("\n"); 

	}
}
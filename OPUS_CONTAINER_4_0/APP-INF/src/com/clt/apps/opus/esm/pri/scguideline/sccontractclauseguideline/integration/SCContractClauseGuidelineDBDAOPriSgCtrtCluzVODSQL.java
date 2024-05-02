/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCContractClauseGuidelineDBDAOPriSgCtrtCluzVODSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.10.23 문동규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline.sccontractclauseguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Moon Dong Gyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCContractClauseGuidelineDBDAOPriSgCtrtCluzVODSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public SCContractClauseGuidelineDBDAOPriSgCtrtCluzVODSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_cluz_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.pri.scguideline.sccontractclauseguideline.integration").append("\n"); 
		query.append("FileName : SCContractClauseGuidelineDBDAOPriSgCtrtCluzVODSQL").append("\n"); 
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
		query.append("DELETE FROM pri_sg_ctrt_cluz" ).append("\n"); 
		query.append("WHERE	svc_scp_cd = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND	gline_seq = @[gline_seq]" ).append("\n"); 
		query.append("AND	ctrt_cluz_seq = @[ctrt_cluz_seq]" ).append("\n"); 

	}
}
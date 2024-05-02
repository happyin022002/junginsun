/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : OperationNPerformMasterDataMgtDBDAORstwgRsnCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.19
*@LastModifier : 
*@LastVersion : 1.0
* 2012.09.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OperationNPerformMasterDataMgtDBDAORstwgRsnCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RstwgRsnCd Select Query
	  * </pre>
	  */
	public OperationNPerformMasterDataMgtDBDAORstwgRsnCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rstwg_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.integration").append("\n"); 
		query.append("FileName : OperationNPerformMasterDataMgtDBDAORstwgRsnCdRSQL").append("\n"); 
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
		query.append("SELECT 		RSTWG_CD_TP_CD" ).append("\n"); 
		query.append("		,	RSTWG_RSN_CD" ).append("\n"); 
		query.append("		,	RSTWG_RSN_CD_FULL_DESC" ).append("\n"); 
		query.append("		,	DELT_FLG" ).append("\n"); 
		query.append("FROM 		OPF_RSTWG_RSN_CD" ).append("\n"); 
		query.append("WHERE 		1 = 1" ).append("\n"); 
		query.append("AND 		RSTWG_CD_TP_CD 		= 'R'				/* [rstwg_cd_tp_cd] 'R' : RESTOW REASON, 'S' : SHIFTING METHOD */" ).append("\n"); 
		query.append("AND 		RSTWG_RSN_CD 		= @[rstwg_rsn_cd]" ).append("\n"); 
		query.append("AND			DELT_FLG 			= @[delt_flg]" ).append("\n"); 

	}
}
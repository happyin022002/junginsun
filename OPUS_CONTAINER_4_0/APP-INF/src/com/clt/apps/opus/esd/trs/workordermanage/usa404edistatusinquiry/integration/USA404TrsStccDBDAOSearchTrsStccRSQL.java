/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : USA404TrsStccDBDAOSearchTrsStccRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.06
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2016.01.06 박찬우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chanwoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USA404TrsStccDBDAOSearchTrsStccRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTrsStcc
	  * </pre>
	  */
	public USA404TrsStccDBDAOSearchTrsStccRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_un_cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_stcc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_stcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration").append("\n"); 
		query.append("FileName : USA404TrsStccDBDAOSearchTrsStccRSQL").append("\n"); 
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
		query.append("SELECT STCC_CD" ).append("\n"); 
		query.append("      ,STCC_SEQ" ).append("\n"); 
		query.append("      ,UN_CMDT_CD" ).append("\n"); 
		query.append("      ,IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("      ,HZD_MTRL_CLSS_CD" ).append("\n"); 
		query.append("      ,PCK_GRP_CD" ).append("\n"); 
		query.append("      ,PCK_GRP_VAL_CD" ).append("\n"); 
		query.append("      ,PRP_SHP_NM" ).append("\n"); 
		query.append("      ,DELT_FLG" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,CRE_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,UPD_DT " ).append("\n"); 
		query.append("  FROM TRS_STCC" ).append("\n"); 
		query.append(" WHERE 1 =1 " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${frm_stcc_cd} != '') " ).append("\n"); 
		query.append("   AND STCC_CD =  @[frm_stcc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${frm_stcc_seq} != '') " ).append("\n"); 
		query.append("   AND STCC_SEQ = @[frm_stcc_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${frm_un_cmdt_cd} != '') " ).append("\n"); 
		query.append("   AND UN_CMDT_CD = @[frm_un_cmdt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY STCC_CD, STCC_SEQ" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SpaceAllocationManageDBDAOSearchRptItemRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.03.30
*@LastModifier : 
*@LastVersion : 1.0
* 2017.03.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpaceAllocationManageDBDAOSearchRptItemRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * History-------------------------
	  * 2011.08.25 김종준 [CHM-201113071-01] control by HO/RHQ 화면과 COA 링크 팝업 추가
	  * </pre>
	  */
	public SpaceAllocationManageDBDAOSearchRptItemRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slct_itm_fom_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAOSearchRptItemRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN INSTR(RPT_ITM_DESC, '$$') != '0' THEN TO_NUMBER(regexp_substr(RPT_ITM_DESC, '[^$$]+', 1))" ).append("\n"); 
		query.append("       ELSE ROWNUM END SEQ," ).append("\n"); 
		query.append("       CASE WHEN INSTR(RPT_ITM_DESC, '$$') != '0' THEN regexp_substr(RPT_ITM_DESC, '[^$$]+', 4)" ).append("\n"); 
		query.append("       ELSE RPT_ITM_DESC END AS RPT_ITM_DESC" ).append("\n"); 
		query.append("    , RPT_ITM_COL_NM " ).append("\n"); 
		query.append("FROM MAS_RPT_ITM_INFO_DTL " ).append("\n"); 
		query.append("WHERE CRE_USR_ID = @[user_id]" ).append("\n"); 
		query.append("  AND SLCT_ITM_FOM_SEQ = @[slct_itm_fom_seq]" ).append("\n"); 
		query.append("ORDER BY SEQ" ).append("\n"); 

	}
}
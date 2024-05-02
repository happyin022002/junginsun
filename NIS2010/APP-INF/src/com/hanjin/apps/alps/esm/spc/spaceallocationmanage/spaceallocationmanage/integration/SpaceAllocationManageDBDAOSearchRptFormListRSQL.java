/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SpaceAllocationManageDBDAOSearchRptFormListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.29
*@LastModifier : 
*@LastVersion : 1.0
* 2011.08.29 
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

public class SpaceAllocationManageDBDAOSearchRptFormListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * History-------------------------
	  * 2011.08.25 김종준 [CHM-201113071-01] control by HO/RHQ 화면과 COA 링크 팝업 추가
	  * </pre>
	  */
	public SpaceAllocationManageDBDAOSearchRptFormListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAOSearchRptFormListRSQL").append("\n"); 
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
		query.append("/*Report Item Infomation 목록을 조회한다*/" ).append("\n"); 
		query.append("	SELECT SLCT_ITM_FOM_SEQ CODE" ).append("\n"); 
		query.append("	      ,SLCT_ITM_FOM_DESC NAME" ).append("\n"); 
		query.append("  	  FROM MAS_RPT_ITM_INFO_MST" ).append("\n"); 
		query.append(" 	 WHERE CRE_USR_ID = @[code]" ).append("\n"); 

	}
}

/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReplanManageDBDAOSearchCopRailChkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.17
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2009.12.17 김인수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReplanManageDBDAOSearchCopRailChkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COP 내에 Rail Direct 운송 type 가 존재하는 지를 확인하여 outbound 존재 여부 || inbound 존재 여부를 명시한다.
	  * ex> ob 존재 / ib 미존재 = OX
	  * 	ob 미존재 / ib 존재 = XI
	  * </pre>
	  */
	public ReplanManageDBDAOSearchCopRailChkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.integration").append("\n"); 
		query.append("FileName : ReplanManageDBDAOSearchCopRailChkRSQL").append("\n"); 
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
		query.append("SELECT O.O_RD_BND||I.I_RD_BND AS COP_RAIL_CHK_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT NVL(MAX(PCTL_IO_BND_CD), 'X') O_RD_BND" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("WHERE PCTL_IO_BND_CD = 'O'" ).append("\n"); 
		query.append("AND TRSP_MOD_CD = 'RD'" ).append("\n"); 
		query.append("AND PCTL_NO = @[pctl_no] ) O," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT NVL(MAX(PCTL_IO_BND_CD), 'X') I_RD_BND" ).append("\n"); 
		query.append("FROM  PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("WHERE PCTL_IO_BND_CD = 'I'" ).append("\n"); 
		query.append("AND TRSP_MOD_CD = 'RD'" ).append("\n"); 
		query.append("AND PCTL_NO = @[pctl_no] ) I" ).append("\n"); 

	}
}
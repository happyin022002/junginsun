/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgCopManageDBDAOSearchCopRailChkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.17
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2009.12.17 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOSearchCopRailChkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * bound 별 rail 운송 존재 여부를 조회한다 (OX: Outbound rail 운송만 존재, XI : Inbound rail 운송만 존재, XX: rail 운송 없음)
	  * </pre>
	  */
	public BkgCopManageDBDAOSearchCopRailChkRSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOSearchCopRailChkRSQL").append("\n"); 
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
		query.append("WHERE PCTL_IO_BND_CD = 'O'" ).append("\n"); 
		query.append("AND TRSP_MOD_CD = 'RD'" ).append("\n"); 
		query.append("AND PCTL_NO = @[pctl_no] ) I" ).append("\n"); 

	}
}
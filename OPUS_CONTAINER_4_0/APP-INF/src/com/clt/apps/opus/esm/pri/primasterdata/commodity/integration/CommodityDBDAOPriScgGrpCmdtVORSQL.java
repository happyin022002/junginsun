/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommodityDBDAOPriScgGrpCmdtVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.26
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.11.26 김재연
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.commodity.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JaeYeon Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommodityDBDAOPriScgGrpCmdtVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI_SCG_GRP_CMDT 테이블 조회
	  * </pre>
	  */
	public CommodityDBDAOPriScgGrpCmdtVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.primasterdata.commodity.integration").append("\n"); 
		query.append("FileName : CommodityDBDAOPriScgGrpCmdtVORSQL").append("\n"); 
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
		query.append("SELECT SCG_GRP_CMDT_SEQ AS SEQ" ).append("\n"); 
		query.append(", SCG_GRP_CMDT_CD AS CD" ).append("\n"); 
		query.append(", SCG_GRP_CMDT_DESC AS NM" ).append("\n"); 
		query.append("FROM PRI_SCG_GRP_CMDT" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORBER BY SCG_GRP_CMDT_CD ASC" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SCReportDBDAORsltMotBsePortListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.19
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2014.05.19 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SongHoJin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCReportDBDAORsltMotBsePortListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MOT Filing Base Port List 조회
	  * </pre>
	  */
	public SCReportDBDAORsltMotBsePortListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.screport.screport.integration").append("\n"); 
		query.append("FileName : SCReportDBDAORsltMotBsePortListRSQL").append("\n"); 
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
		query.append("SELECT  MOT_FILE_LOC_CD AS CD" ).append("\n"); 
		query.append("    ,   MOT_FILE_LOC_NM AS NM" ).append("\n"); 
		query.append("    ,   MOT_FILE_LANE_CD AS ETC1" ).append("\n"); 
		query.append("FROM    PRI_MOT_FILE_LOC_PPT" ).append("\n"); 
		query.append("WHERE   ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("#if(${org_dest_tp_cd} != 'O')" ).append("\n"); 
		query.append("AND     SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("AND     NVL ( DELT_FLG, 'N' ) = 'N'" ).append("\n"); 
		query.append("ORDER   BY MOT_FILE_LOC_CD" ).append("\n"); 

	}
}
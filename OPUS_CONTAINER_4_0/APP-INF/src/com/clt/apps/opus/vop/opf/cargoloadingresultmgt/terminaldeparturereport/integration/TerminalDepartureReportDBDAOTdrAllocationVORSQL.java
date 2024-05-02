/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOTdrAllocationVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.10.28 장석현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Suk Hyun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalDepartureReportDBDAOTdrAllocationVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOTdrAllocationVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("opr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_ind",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAOTdrAllocationVORSQL").append("\n"); 
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
		query.append("SELECT VSL_CD" ).append("\n"); 
		query.append(", VOY_NO" ).append("\n"); 
		query.append(", DIR_CD" ).append("\n"); 
		query.append(", PORT_CD" ).append("\n"); 
		query.append(", CALL_IND" ).append("\n"); 
		query.append(", OPR_CD" ).append("\n"); 
		query.append(", BSA_SLOT" ).append("\n"); 
		query.append(", BSA_WGT" ).append("\n"); 
		query.append(", RELEASE_SLOT" ).append("\n"); 
		query.append(", RELEASE_WGT" ).append("\n"); 
		query.append(", SWAP_SLOT" ).append("\n"); 
		query.append(", SWAP_WGT" ).append("\n"); 
		query.append(", RATIO_TYPE" ).append("\n"); 
		query.append(", UPDATE_USER" ).append("\n"); 
		query.append(", UPDATE_TIME" ).append("\n"); 
		query.append(", CASE WHEN RELEASE_SLOT > 0 THEN 'Fixed' ELSE 'Used' END BSA_TYPE" ).append("\n"); 
		query.append("FROM	TDR_ALLOCATION" ).append("\n"); 
		query.append("WHERE	VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND		VOY_NO = @[voy_no]" ).append("\n"); 
		query.append("AND		DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("AND		PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("AND		CALL_IND = @[call_ind]" ).append("\n"); 
		query.append("AND		OPR_CD = @[opr_cd]" ).append("\n"); 

	}
}
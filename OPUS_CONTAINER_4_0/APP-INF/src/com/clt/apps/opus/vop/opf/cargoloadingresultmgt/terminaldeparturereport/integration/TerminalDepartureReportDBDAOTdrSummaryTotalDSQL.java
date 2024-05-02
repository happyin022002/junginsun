/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOTdrSummaryTotalDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.09
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.11.09 장석현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Suk Hyun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalDepartureReportDBDAOTdrSummaryTotalDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOTdrSummaryTotalDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("status",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration ").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAOTdrSummaryTotalDSQL").append("\n"); 
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
		query.append("DELETE FROM TDR_SUMMARY" ).append("\n"); 
		query.append("WHERE	VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND	VOY_NO = @[voy_no]" ).append("\n"); 
		query.append("AND	DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("AND	PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("AND	CALL_IND = @[call_ind]" ).append("\n"); 
		query.append("AND	STATUS = @[status]" ).append("\n"); 
		query.append("AND	CNTR_TYPE NOT IN ('D', 'R', 'A')" ).append("\n"); 

	}
}
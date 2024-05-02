/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOSearchReceiverInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.26
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalDepartureReportDBDAOSearchReceiverInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * get Send Email Address
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOSearchReceiverInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("spcl_cgo_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAOSearchReceiverInfoRSQL").append("\n"); 
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
		query.append("SELECT X.CNTC_PSON_EML_CTNT" ).append("\n"); 
		query.append("FROM   SCG_CNTC_PNT_ADD     X" ).append("\n"); 
		query.append("     , SCG_RGN_SHP_OPR_PORT Y" ).append("\n"); 
		query.append("     , MDM_VSL_CNTR         VC" ).append("\n"); 
		query.append("     , VSK_VSL_SKD          VS" ).append("\n"); 
		query.append("WHERE  1 = 1 " ).append("\n"); 
		query.append("AND    X.RGN_SHP_OPR_CD     = Y.RGN_SHP_OPR_CD" ).append("\n"); 
		query.append("AND    X.SLAN_CD            = VS.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND    VS.VSL_CD            = VC.VSL_CD" ).append("\n"); 
		query.append("AND    Y.LOC_CD             = @[port_cd]   			-- <<Binding Var : Departure Port >> --" ).append("\n"); 
		query.append("AND    X.CNTC_CATE_CD       = @[spcl_cgo_cate_cd]   -- <<Fixed Value : 'TD':TDR, 'RD':RDR >> --" ).append("\n"); 
		query.append("AND    X.CRR_CD             = VC.CRR_CD" ).append("\n"); 
		query.append("AND    VS.VSL_CD            = @[vsl_cd]    			-- <<Binding Var : Vessel Code >> --" ).append("\n"); 
		query.append("AND    VS.SKD_VOY_NO        = @[voy_no]    			-- <<Binding Var : SKD Voyage No >> --" ).append("\n"); 
		query.append("AND    VS.SKD_DIR_CD        = @[dir_cd]       		-- <<Binding Var : SKD Direction Code >> --" ).append("\n"); 

	}
}
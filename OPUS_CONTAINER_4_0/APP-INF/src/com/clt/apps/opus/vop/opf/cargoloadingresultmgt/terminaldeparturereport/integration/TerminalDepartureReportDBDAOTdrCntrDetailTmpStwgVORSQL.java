/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOTdrCntrDetailTmpStwgVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.06
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.06 
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

public class TerminalDepartureReportDBDAOTdrCntrDetailTmpStwgVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOTdrCntrDetailTmpStwgVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : TerminalDepartureReportDBDAOTdrCntrDetailTmpStwgVORSQL").append("\n"); 
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
		query.append("SELECT D.CNTR_NO," ).append("\n"); 
		query.append("       D.OPR_CD," ).append("\n"); 
		query.append("       D.SZTP," ).append("\n"); 
		query.append("       D.POD," ).append("\n"); 
		query.append("       D.POL," ).append("\n"); 
		query.append("       D.POSITION," ).append("\n"); 
		query.append("       D.WEIGHT," ).append("\n"); 
		query.append("       D.REMARK" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD V, TDR_HEADER H, TDR_CNTR_DETAIL D" ).append("\n"); 
		query.append("WHERE  V.VSL_CD 	  = @[vsl_cd]" ).append("\n"); 
		query.append("AND    V.SKD_VOY_NO   = @[voy_no]" ).append("\n"); 
		query.append("AND    V.SKD_DIR_CD   = @[dir_cd]" ).append("\n"); 
		query.append("AND    V.YD_CD 		  = @[yd_cd]" ).append("\n"); 
		query.append("AND    V.CLPT_IND_SEQ = @[clpt_ind_seq]" ).append("\n"); 
		query.append("AND    V.VSL_CD       = H.VSL_CD" ).append("\n"); 
		query.append("AND    V.SKD_VOY_NO   = H.VOY_NO" ).append("\n"); 
		query.append("AND    V.SKD_DIR_CD   = H.DIR_CD" ).append("\n"); 
		query.append("AND    V.VPS_PORT_CD  = H.PORT_CD" ).append("\n"); 
		query.append("AND    V.CLPT_IND_SEQ = H.CALL_IND" ).append("\n"); 
		query.append("AND    H.VSL_CD       = D.VSL_CD" ).append("\n"); 
		query.append("AND    H.VOY_NO       = D.VOY_NO" ).append("\n"); 
		query.append("AND    H.DIR_CD       = D.DIR_CD" ).append("\n"); 
		query.append("AND    H.PORT_CD      = D.PORT_CD" ).append("\n"); 
		query.append("AND    H.CALL_IND     = D.CALL_IND" ).append("\n"); 
		query.append("AND    D.TEMP_CHK 	  = 'Y'" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TerminalDepartureReportDBDAORHContainerVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.02
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalDepartureReportDBDAORHContainerVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public TerminalDepartureReportDBDAORHContainerVORSQL(){
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
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAORHContainerVORSQL").append("\n"); 
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
		query.append("SELECT C.CNTR_NO,          " ).append("\n"); 
		query.append("       C.SZTP,          " ).append("\n"); 
		query.append("       C.POL,              " ).append("\n"); 
		query.append("       C.OPR_CD,         " ).append("\n"); 
		query.append("       C.PRECELL,      " ).append("\n"); 
		query.append("       C.POSITION,      " ).append("\n"); 
		query.append("       NVL(C.SHIFT_TYPE, '') || NVL(C.SHIFT_RSN, '') AS SHIFT_RSN,           " ).append("\n"); 
		query.append("       C.ACCOUNT,          " ).append("\n"); 
		query.append("       C.PARTY," ).append("\n"); 
		query.append("       C.RESPB_CNTR_NO," ).append("\n"); 
		query.append("   (   SELECT  DECODE ( SIGN ( COUNT(1) ), 1, 'File Attached', NULL )" ).append("\n"); 
		query.append("       FROM    OPF_TDR_ATCH_FILE F" ).append("\n"); 
		query.append("       WHERE   C.VSL_CD   = F.VSL_CD" ).append("\n"); 
		query.append("       AND     C.VOY_NO   = F.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND     C.DIR_CD   = F.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND     C.PORT_CD  = F.VPS_PORT_CD" ).append("\n"); 
		query.append("       AND     C.CALL_IND = F.CLPT_IND_SEQ" ).append("\n"); 
		query.append("       AND     C.STATUS   = F.CNTR_HNDL_KND_CD" ).append("\n"); 
		query.append("       AND     C.CNTR_NO  = F.CNTR_NO" ).append("\n"); 
		query.append("   )   AS FILE_ATCH," ).append("\n"); 
		query.append("   C.FE" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD V, TDR_HEADER H, TDR_CNTR_DETAIL C" ).append("\n"); 
		query.append("WHERE  V.VSL_CD  		= @[vsl_cd]" ).append("\n"); 
		query.append("AND    V.SKD_VOY_NO  	= @[voy_no]" ).append("\n"); 
		query.append("AND    V.SKD_DIR_CD  	= @[dir_cd]" ).append("\n"); 
		query.append("AND    V.YD_CD 			= @[yd_cd]" ).append("\n"); 
		query.append("AND    V.CLPT_IND_SEQ   = @[clpt_ind_seq]" ).append("\n"); 
		query.append("AND    V.VSL_CD       	= H.VSL_CD" ).append("\n"); 
		query.append("AND    V.SKD_VOY_NO   	= H.VOY_NO" ).append("\n"); 
		query.append("AND    V.SKD_DIR_CD   	= H.DIR_CD" ).append("\n"); 
		query.append("AND    V.VPS_PORT_CD  	= H.PORT_CD" ).append("\n"); 
		query.append("AND    V.CLPT_IND_SEQ 	= H.CALL_IND" ).append("\n"); 
		query.append("AND    H.VSL_CD       	= C.VSL_CD" ).append("\n"); 
		query.append("AND    H.VOY_NO       	= C.VOY_NO" ).append("\n"); 
		query.append("AND    H.DIR_CD       	= C.DIR_CD" ).append("\n"); 
		query.append("AND    H.PORT_CD      	= C.PORT_CD" ).append("\n"); 
		query.append("AND    H.CALL_IND     	= C.CALL_IND" ).append("\n"); 
		query.append("AND    C.STATUS         = 'ST'" ).append("\n"); 
		query.append("AND    TRIM(C.PRECELL) IS NOT NULL" ).append("\n"); 

	}
}
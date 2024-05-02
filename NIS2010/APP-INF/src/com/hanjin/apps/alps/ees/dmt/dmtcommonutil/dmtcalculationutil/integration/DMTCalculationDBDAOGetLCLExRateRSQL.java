/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DMTCalculationDBDAOGetLCLExRateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.30
*@LastModifier : 임창빈
*@LastVersion : 1.0
* 2013.12.30 임창빈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lim Chang Bin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCalculationDBDAOGetLCLExRateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetLCLExRate
	  * </pre>
	  */
	public DMTCalculationDBDAOGetLCLExRateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_loc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_loc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cur_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_cur_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voyage_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOGetLCLExRateRSQL").append("\n"); 
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
		query.append("SELECT  TMP_USD_LCL" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        SELECT  ROW_NUMBER() OVER (ORDER BY NO) NO, TMP_USD_LCL" ).append("\n"); 
		query.append("        FROM    (" ).append("\n"); 
		query.append("                SELECT  1 NO, INV_XCH_RT TMP_USD_LCL" ).append("\n"); 
		query.append("                FROM    INV_VVD_XCH_RT" ).append("\n"); 
		query.append("                WHERE   VSL_CD      = @[vsl_cd]" ).append("\n"); 
		query.append("                AND     SKD_VOY_NO  = @[skd_voyage_no]" ).append("\n"); 
		query.append("                AND     SKD_DIR_CD  = @[skd_dir_cd]" ).append("\n"); 
		query.append("                AND     PORT_CD     = DECODE( @[io_bnd], 'I', @[pod_loc], @[pol_loc] )" ).append("\n"); 
		query.append("                AND     LOCL_CURR_CD= @[cur_cd]    -- cur_cd    : Invoice Currency (To)" ).append("\n"); 
		query.append("                AND     CHG_CURR_CD = @[fm_cur_cd] -- fm_cur_cd : Charge Currency (From)" ).append("\n"); 
		query.append("                AND     IO_BND_CD   = @[io_bnd]" ).append("\n"); 
		query.append("                AND     INV_XCH_RT  > 0" ).append("\n"); 
		query.append("                #if (${sql_order} == '1') " ).append("\n"); 
		query.append("                AND	SVC_SCP_CD      IN" ).append("\n"); 
		query.append("                                    (" ).append("\n"); 
		query.append("                                    SELECT  T1.SVC_SCP_CD" ).append("\n"); 
		query.append("                                    FROM    MDM_SVC_SCP_LMT T1," ).append("\n"); 
		query.append("                                            MDM_SVC_SCP_LMT T2" ).append("\n"); 
		query.append("                                    WHERE   T1.RGN_CD     =" ).append("\n"); 
		query.append("                                                            (" ).append("\n"); 
		query.append("                                                            SELECT  RGN_CD FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                                            WHERE   LOC_CD  = @[pol_loc]" ).append("\n"); 
		query.append("                                                            )" ).append("\n"); 
		query.append("                                    AND T1.ORG_DEST_CD	 = 'O'" ).append("\n"); 
		query.append("                                    AND T2.RGN_CD          =" ).append("\n"); 
		query.append("                                                            (" ).append("\n"); 
		query.append("                                                            SELECT  RGN_CD FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                                            WHERE   LOC_CD  = @[pod_loc]" ).append("\n"); 
		query.append("                                                            )" ).append("\n"); 
		query.append("                                    AND      T2.ORG_DEST_CD   = 'D'" ).append("\n"); 
		query.append("                                    AND      T1.SVC_SCP_CD    = T2.SVC_SCP_CD" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("                #elseif (${sql_order} == '2') " ).append("\n"); 
		query.append("                AND     SVC_SCP_CD  = 'OTH'" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                AND     ROWNUM      = 1" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                SELECT  2 NO, ROUND( 1 / INV_XCH_RT, 6) AS TMP_USD_LCL" ).append("\n"); 
		query.append("                FROM    INV_VVD_XCH_RT" ).append("\n"); 
		query.append("                WHERE   VSL_CD      = @[vsl_cd]" ).append("\n"); 
		query.append("                AND     SKD_VOY_NO  = @[skd_voyage_no]" ).append("\n"); 
		query.append("                AND     SKD_DIR_CD  = @[skd_dir_cd]" ).append("\n"); 
		query.append("                AND     PORT_CD     = DECODE( @[io_bnd], 'I', @[pod_loc], @[pol_loc] )" ).append("\n"); 
		query.append("                AND     LOCL_CURR_CD= @[fm_cur_cd]       -- fm_cur_cd : Charge Currency (From)" ).append("\n"); 
		query.append("                AND     CHG_CURR_CD = @[cur_cd]          -- cur_cd    : Invoice Currency (To)" ).append("\n"); 
		query.append("                AND     IO_BND_CD   = @[io_bnd]" ).append("\n"); 
		query.append("                AND     INV_XCH_RT  > 0" ).append("\n"); 
		query.append("                #if (${sql_order} == '1')" ).append("\n"); 
		query.append("                AND    SVC_SCP_CD   IN" ).append("\n"); 
		query.append("                                    (" ).append("\n"); 
		query.append("                                    SELECT  T1.SVC_SCP_CD" ).append("\n"); 
		query.append("                                    FROM    MDM_SVC_SCP_LMT T1," ).append("\n"); 
		query.append("                                            MDM_SVC_SCP_LMT T2" ).append("\n"); 
		query.append("                                    WHERE   T1.RGN_CD       =" ).append("\n"); 
		query.append("                                                            (" ).append("\n"); 
		query.append("                                                            SELECT RGN_CD FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                                            WHERE LOC_CD	= @[pol_loc]" ).append("\n"); 
		query.append("                                                            )" ).append("\n"); 
		query.append("                                    AND     T1.ORG_DEST_CD      = 'O'" ).append("\n"); 
		query.append("                                    AND     T2.RGN_CD           =" ).append("\n"); 
		query.append("                                                                (" ).append("\n"); 
		query.append("                                                                SELECT RGN_CD FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                                                WHERE LOC_CD	= @[pod_loc]" ).append("\n"); 
		query.append("                                                                )" ).append("\n"); 
		query.append("                                    AND     T2.ORG_DEST_CD      = 'D'" ).append("\n"); 
		query.append("                                    AND     T1.SVC_SCP_CD       = T2.SVC_SCP_CD" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("                #elseif (${sql_order} == '2') " ).append("\n"); 
		query.append("                AND     SVC_SCP_CD  = 'OTH'" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                AND     ROWNUM      = 1" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("        WHERE   1=1" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND     NO  = 1" ).append("\n"); 

	}
}
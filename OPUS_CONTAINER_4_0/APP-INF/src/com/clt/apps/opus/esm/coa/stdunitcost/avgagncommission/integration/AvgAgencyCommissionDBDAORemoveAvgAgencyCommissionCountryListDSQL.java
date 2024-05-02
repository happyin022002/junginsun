/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : AvgAgencyCommissionDBDAORemoveAvgAgencyCommissionCountryListDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.11
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.avgagncommission.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AvgAgencyCommissionDBDAORemoveAvgAgencyCommissionCountryListDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public AvgAgencyCommissionDBDAORemoveAvgAgencyCommissionCountryListDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comm_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comm_stnd_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ac_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.avgagncommission.integration ").append("\n"); 
		query.append("FileName : AvgAgencyCommissionDBDAORemoveAvgAgencyCommissionCountryListDSQL").append("\n"); 
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
		query.append("DELETE " ).append("\n"); 
		query.append("  FROM ACM_COMM_CNT_UT_COST A" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.COMM_YRMON         = @[comm_yrmon]" ).append("\n"); 
		query.append("   AND A.CNT_CD             = @[cnt_cd]" ).append("\n"); 
		query.append("   AND A.IO_BND_CD          = @[io_bnd_cd]" ).append("\n"); 
		query.append("   AND A.AC_TP_CD           = @[ac_tp_cd]" ).append("\n"); 
		query.append("   AND A.CNTR_TPSZ_CD       = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("   AND A.COMM_STND_COST_CD  = @[comm_stnd_cost_cd]" ).append("\n"); 
		query.append("   AND A.TRD_CD             = @[trd_cd]" ).append("\n"); 
		query.append("   AND A.SUB_TRD_CD         = @[sub_trd_cd]" ).append("\n"); 

	}
}
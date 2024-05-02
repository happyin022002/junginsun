/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOOpfTmlDepRptDtlVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 
*@LastVersion : 1.0
* 2009.08.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalDepartureReportDBDAOOpfTmlDepRptDtlVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOOpfTmlDepRptDtlVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration ").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAOOpfTmlDepRptDtlVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("TML_PROD_RPT_RSN_CRE_USR_ID" ).append("\n"); 
		query.append(",	TML_PROD_RPT_RSN_CRE_DT" ).append("\n"); 
		query.append(",	TML_PROD_RPT_RSN_CD" ).append("\n"); 
		query.append(",	TML_PROD_RPT_RSN_RMK" ).append("\n"); 
		query.append(",	TDR_EML_SND_NO" ).append("\n"); 
		query.append("FROM OPF_TML_DEP_RPT_DTL" ).append("\n"); 
		query.append("WHERE	VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND	SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND	SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND	CLPT_CD = @[clpt_cd]" ).append("\n"); 
		query.append("AND	CLPT_IND_SEQ = @[clpt_ind_seq]" ).append("\n"); 

	}
}
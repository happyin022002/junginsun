/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PortTimePerformanceMgtDBDAOPerformanceSummaryUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.22
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2013.07.22 원종규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jongkyu Weon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTimePerformanceMgtDBDAOPerformanceSummaryUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceSummary
	  * </pre>
	  */
	public PortTimePerformanceMgtDBDAOPerformanceSummaryUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("update_user",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("except_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("except_pob_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.integration").append("\n"); 
		query.append("FileName : PortTimePerformanceMgtDBDAOPerformanceSummaryUSQL").append("\n"); 
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
		query.append("UPDATE TDR_HEADER" ).append("\n"); 
		query.append(" SET " ).append("\n"); 
		query.append("   EXCEPT_CD = DECODE(@[except_cd], '1', 'Y', null)" ).append("\n"); 
		query.append("  ,EXCEPT_POB_FLG = DECODE(@[except_pob_flg], '1', 'Y', null)" ).append("\n"); 
		query.append("  ,UPD_SYS_CD = 'N' " ).append("\n"); 
		query.append("  ,UPDATE_USER = @[update_user]" ).append("\n"); 
		query.append("  ,UPDATE_TIME = SYSDATE" ).append("\n"); 
		query.append(" WHERE VSL_CD   = @[vsl_cd]" ).append("\n"); 
		query.append("   AND VOY_NO   = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND DIR_CD   = @[skd_dir_cd]" ).append("\n"); 
		query.append("   AND PORT_CD  = @[port_cd]" ).append("\n"); 
		query.append("   AND CALL_IND = @[clpt_ind_seq]" ).append("\n"); 

	}
}
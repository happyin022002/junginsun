/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VoyagePerformanceMgtDBDAOSearchCgoStowageCraneArrangementRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.23
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.voyageperformancemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VoyagePerformanceMgtDBDAOSearchCgoStowageCraneArrangementRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Crane 조회
	  * </pre>
	  */
	public VoyagePerformanceMgtDBDAOSearchCgoStowageCraneArrangementRSQL(){
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
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.voyageperformancemgt.integration").append("\n"); 
		query.append("FileName : VoyagePerformanceMgtDBDAOSearchCgoStowageCraneArrangementRSQL").append("\n"); 
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
		query.append("SELECT   COUNT(1) AS CGO_FROM_STWG_ARRANGEMENT" ).append("\n"); 
		query.append("FROM     (" ).append("\n"); 
		query.append("         --==========================================" ).append("\n"); 
		query.append("          SELECT   DISTINCT        " ).append("\n"); 
		query.append("                   BC.CRANE_ID" ).append("\n"); 
		query.append("          FROM     BAY_CRANE       BC " ).append("\n"); 
		query.append("          WHERE    BC.VSL_CD       = @[vsl_cd]" ).append("\n"); 
		query.append("          AND      BC.VOY_NO       = @[skd_voy_no]" ).append("\n"); 
		query.append("          AND      BC.DIR_CD       = @[skd_dir_cd]" ).append("\n"); 
		query.append("          AND      BC.PORT_CD      = @[vps_port_cd]" ).append("\n"); 
		query.append("          AND      BC.CALL_IND     = @[clpt_ind_seq]" ).append("\n"); 
		query.append("          --AND      BC.JOB_TYPE     IN ('L','D')" ).append("\n"); 
		query.append("         --==========================================     " ).append("\n"); 
		query.append("         ) X" ).append("\n"); 

	}
}
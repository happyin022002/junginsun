/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : RegionDepartureReportDBDAOAddRdrUtilizeCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.07
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RegionDepartureReportDBDAOAddRdrUtilizeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RDR_UTILIZE 생성.
	  * </pre>
	  */
	public RegionDepartureReportDBDAOAddRdrUtilizeCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("region",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("slot_45",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slot_add",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("type",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slot_hc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("slot_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slot_hc20",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("total_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.integration").append("\n"); 
		query.append("FileName : RegionDepartureReportDBDAOAddRdrUtilizeCSQL").append("\n"); 
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
		query.append("INSERT INTO RDR_UTILIZE(VSL_CD" ).append("\n"); 
		query.append(",						VOY_NO" ).append("\n"); 
		query.append(",						DIR_CD" ).append("\n"); 
		query.append(",						REGION" ).append("\n"); 
		query.append(",						OPR_CD" ).append("\n"); 
		query.append(",						TYPE" ).append("\n"); 
		query.append(",						SLOT_QTY" ).append("\n"); 
		query.append(",						WEIGHT" ).append("\n"); 
		query.append(",						SLOT_HC" ).append("\n"); 
		query.append(",						SLOT_45" ).append("\n"); 
		query.append(",						SLOT_ADD" ).append("\n"); 
		query.append(",						UPDATE_USER" ).append("\n"); 
		query.append(",						UPDATE_TIME" ).append("\n"); 
		query.append(",						SLOT_HC20" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES(                 @[vsl_cd]" ).append("\n"); 
		query.append(",					    @[voy_no]" ).append("\n"); 
		query.append(",						@[dir_cd]" ).append("\n"); 
		query.append(",						@[region]" ).append("\n"); 
		query.append(",						@[opr_cd]" ).append("\n"); 
		query.append(",						@[type]" ).append("\n"); 
		query.append(",						@[slot_qty]" ).append("\n"); 
		query.append(",						@[total_wgt]" ).append("\n"); 
		query.append(",						@[slot_hc]" ).append("\n"); 
		query.append(",						@[slot_45]" ).append("\n"); 
		query.append(",						@[slot_add]" ).append("\n"); 
		query.append(",						@[update_user]" ).append("\n"); 
		query.append(",						SYSDATE" ).append("\n"); 
		query.append(",						@[slot_hc20]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RegionDepartureReportDBDAORemoveRdrUtilizeLoadUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.20
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.12.20 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RegionDepartureReportDBDAORemoveRdrUtilizeLoadUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * Ticket ID : CHM-201007765-01
	  * 개발자 : 박희동(2010-12-20)
	  * 수정내용 : UPD_SYS_CD 컬럼추가...N으로 setting
	  * </pre>
	  */
	public RegionDepartureReportDBDAORemoveRdrUtilizeLoadUSQL(){
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
		params.put("opr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.integration").append("\n"); 
		query.append("FileName : RegionDepartureReportDBDAORemoveRdrUtilizeLoadUSQL").append("\n"); 
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
		query.append("UPDATE RDR_UTILIZE" ).append("\n"); 
		query.append("  SET  " ).append("\n"); 
		query.append("       SLOT_HC20    = NULL" ).append("\n"); 
		query.append(",      SLOT_HC      = NULL" ).append("\n"); 
		query.append(",      SLOT_45      = NULL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",      UPDATE_USER  = @[update_user]" ).append("\n"); 
		query.append(",      UPDATE_TIME  = SYSDATE" ).append("\n"); 
		query.append(",      SLOT_ADD     = NULL" ).append("\n"); 
		query.append(",      UPD_SYS_CD   = 'N'" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("      VSL_CD =   @[vsl_cd]" ).append("\n"); 
		query.append("  AND VOY_NO =   @[voy_no]" ).append("\n"); 
		query.append("  AND DIR_CD =   @[dir_cd]" ).append("\n"); 
		query.append("  AND REGION =   @[region]" ).append("\n"); 
		query.append("  AND OPR_CD =   @[opr_cd]" ).append("\n"); 

	}
}
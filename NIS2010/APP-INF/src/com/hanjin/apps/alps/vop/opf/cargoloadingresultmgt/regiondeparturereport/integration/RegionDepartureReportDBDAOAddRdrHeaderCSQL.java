/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RegionDepartureReportDBDAOAddRdrHeaderCSQL.java
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

public class RegionDepartureReportDBDAOAddRdrHeaderCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public RegionDepartureReportDBDAOAddRdrHeaderCSQL(){
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
		params.put("eta",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eta_canal",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("remark",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("next_canal",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nis_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("next_port",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : RegionDepartureReportDBDAOAddRdrHeaderCSQL").append("\n"); 
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
		query.append("INSERT INTO RDR_HEADER( VSL_CD" ).append("\n"); 
		query.append(",                       VOY_NO" ).append("\n"); 
		query.append(",                       DIR_CD" ).append("\n"); 
		query.append(",                       REGION" ).append("\n"); 
		query.append(",                       PORT_CD" ).append("\n"); 
		query.append(",                       RDR_DATE" ).append("\n"); 
		query.append(",                       RDR_USER" ).append("\n"); 
		query.append(",                       NIS_DATE" ).append("\n"); 
		query.append(",                       REMARK" ).append("\n"); 
		query.append(",                       UPDATE_USER" ).append("\n"); 
		query.append(",                       UPDATE_TIME" ).append("\n"); 
		query.append(",                       NEXT_PORT" ).append("\n"); 
		query.append(",                       ETA" ).append("\n"); 
		query.append(",                       NEXT_CANAL" ).append("\n"); 
		query.append(",                       ETA_CANAL" ).append("\n"); 
		query.append(",                       UPDATE_SYS" ).append("\n"); 
		query.append(",                       UPD_SYS_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES( @[vsl_cd]" ).append("\n"); 
		query.append(",       @[voy_no]" ).append("\n"); 
		query.append(",       @[dir_cd]" ).append("\n"); 
		query.append(",       @[region]" ).append("\n"); 
		query.append(",       @[port_cd]" ).append("\n"); 
		query.append(",       SYSDATE" ).append("\n"); 
		query.append(",       @[update_user]" ).append("\n"); 
		query.append(",       @[nis_date]" ).append("\n"); 
		query.append(",       @[remark]" ).append("\n"); 
		query.append(",       @[update_user]" ).append("\n"); 
		query.append(",       SYSDATE" ).append("\n"); 
		query.append(",       @[next_port] " ).append("\n"); 
		query.append(",       TO_DATE(   REPLACE( REPLACE( REPLACE( @[eta],'-') , ':') , ' ')    , 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",       @[next_canal]" ).append("\n"); 
		query.append(",       TO_DATE(   REPLACE( REPLACE( REPLACE( @[eta_canal],'-') , ':') , ' ')    , 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",       'N'" ).append("\n"); 
		query.append(",       'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
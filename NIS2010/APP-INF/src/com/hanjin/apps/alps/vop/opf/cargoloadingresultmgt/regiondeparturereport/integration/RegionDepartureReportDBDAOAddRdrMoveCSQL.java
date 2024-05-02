/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RegionDepartureReportDBDAOAddRdrMoveCSQL.java
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

public class RegionDepartureReportDBDAOAddRdrMoveCSQL implements ISQLTemplate{

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
	public RegionDepartureReportDBDAOAddRdrMoveCSQL(){
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
		params.put("arr_time",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("idx",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("berth_time",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("unberth_time",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dep_time",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : RegionDepartureReportDBDAOAddRdrMoveCSQL").append("\n"); 
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
		query.append("INSERT INTO RDR_MOVE(VSL_CD" ).append("\n"); 
		query.append(",                    VOY_NO" ).append("\n"); 
		query.append(",                    DIR_CD" ).append("\n"); 
		query.append(",                    PORT_CD" ).append("\n"); 
		query.append(",                    CALL_IND" ).append("\n"); 
		query.append(",                    REGION" ).append("\n"); 
		query.append(",                    ARRIVAL_DATE  " ).append("\n"); 
		query.append(",                    BERTH_DATE    " ).append("\n"); 
		query.append(",                    UNBERTH_DATE  " ).append("\n"); 
		query.append(",                    DEPARTURE_DATE" ).append("\n"); 
		query.append(",                    IDX           " ).append("\n"); 
		query.append(",                    UPDATE_USER   " ).append("\n"); 
		query.append(",                    UPDATE_TIME " ).append("\n"); 
		query.append(",                    UPD_SYS_CD" ).append("\n"); 
		query.append(")  " ).append("\n"); 
		query.append("VALUES( @[vsl_cd]" ).append("\n"); 
		query.append(",       @[voy_no]" ).append("\n"); 
		query.append(",       @[dir_cd]        " ).append("\n"); 
		query.append(",       @[port_cd]   " ).append("\n"); 
		query.append(",       (SELECT   NVL( MAX(CALL_IND), 0 )+1 FROM RDR_MOVE A " ).append("\n"); 
		query.append("          WHERE   A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("            AND   A.VOY_NO = @[voy_no]" ).append("\n"); 
		query.append("            AND   A.DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("            AND   A.REGION = @[region]" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append(",       @[region]" ).append("\n"); 
		query.append(",       TO_DATE(@[arr_time],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",       TO_DATE(@[berth_time],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",       TO_DATE(@[unberth_time],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",       TO_DATE(@[dep_time],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",       @[idx]           " ).append("\n"); 
		query.append(",       @[update_user]" ).append("\n"); 
		query.append(",       SYSDATE " ).append("\n"); 
		query.append(",       'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
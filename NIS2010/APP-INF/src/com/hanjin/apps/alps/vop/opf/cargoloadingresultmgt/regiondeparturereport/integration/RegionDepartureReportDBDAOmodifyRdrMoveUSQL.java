/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RegionDepartureReportDBDAOmodifyRdrMoveUSQL.java
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

public class RegionDepartureReportDBDAOmodifyRdrMoveUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RDR_MOVE 수정 처리
	  * Ticket ID : CHM-201007765-01
	  * 개발자 : 박희동(2010-12-20)
	  * 수정내용 : UPD_SYS_CD 컬럼추가...N으로 setting
	  * </pre>
	  */
	public RegionDepartureReportDBDAOmodifyRdrMoveUSQL(){
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
		params.put("dep_time",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("call_ind",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : RegionDepartureReportDBDAOmodifyRdrMoveUSQL").append("\n"); 
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
		query.append("UPDATE    RDR_MOVE" ).append("\n"); 
		query.append("   SET    ARRIVAL_DATE    =  TO_DATE(@[arr_time]    , 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",         BERTH_DATE      =  TO_DATE(@[berth_time]  , 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",         UNBERTH_DATE    =  TO_DATE(@[unberth_time], 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",         DEPARTURE_DATE  =  TO_DATE(@[dep_time]    , 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",         UPDATE_USER     =  @[update_user]" ).append("\n"); 
		query.append(",         UPDATE_TIME     =  SYSDATE" ).append("\n"); 
		query.append(",         UPD_SYS_CD      =  'N'" ).append("\n"); 
		query.append("WHERE     VSL_CD          =   @[vsl_cd]" ).append("\n"); 
		query.append("AND       VOY_NO          =   @[voy_no]" ).append("\n"); 
		query.append("AND       DIR_CD          =   @[dir_cd]" ).append("\n"); 
		query.append("AND       PORT_CD         =   @[port_cd]" ).append("\n"); 
		query.append("AND       CALL_IND        =   @[call_ind]" ).append("\n"); 
		query.append("AND       REGION          =   @[region]" ).append("\n"); 

	}
}
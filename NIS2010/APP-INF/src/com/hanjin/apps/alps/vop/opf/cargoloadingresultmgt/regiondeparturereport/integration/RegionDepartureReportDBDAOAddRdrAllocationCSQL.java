/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RegionDepartureReportDBDAOAddRdrAllocationCSQL.java
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

public class RegionDepartureReportDBDAOAddRdrAllocationCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RDR Allocation 생성
	  * 2010-12-20 
	  * Ticket ID : CHM-201007765-01
	  * 개발자 : 박희동
	  * 수정내용 : UPD_SYS_CD 컬럼추가...N으로 setting
	  * </pre>
	  */
	public RegionDepartureReportDBDAOAddRdrAllocationCSQL(){
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
		params.put("cgo_slot",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("segment",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("basic_slot",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("swap_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("basic_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ratio_type",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cgo_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_type",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("release_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("swap_slot",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("release_slot",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.integration").append("\n"); 
		query.append("FileName : RegionDepartureReportDBDAOAddRdrAllocationCSQL").append("\n"); 
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
		query.append("INSERT INTO  RDR_ALLOCATION" ).append("\n"); 
		query.append("                          (VSL_CD" ).append("\n"); 
		query.append(",                          VOY_NO" ).append("\n"); 
		query.append(",                          DIR_CD" ).append("\n"); 
		query.append(",                          REGION" ).append("\n"); 
		query.append(",                          OPR_CD" ).append("\n"); 
		query.append(",                          SEGMENT" ).append("\n"); 
		query.append(",                          RATIO_TYPE" ).append("\n"); 
		query.append(",                          BSA_TYPE" ).append("\n"); 
		query.append(",                          CGO_WGT" ).append("\n"); 
		query.append(",                          BSA_SLOT" ).append("\n"); 
		query.append(",                          BSA_WGT" ).append("\n"); 
		query.append(",                          RELEASE_SLOT" ).append("\n"); 
		query.append(",                          RELEASE_WGT" ).append("\n"); 
		query.append(",                          SWAP_SLOT" ).append("\n"); 
		query.append(",                          SWAP_WGT" ).append("\n"); 
		query.append(",                          CGO_SLOT" ).append("\n"); 
		query.append(",                          UPDATE_TIME" ).append("\n"); 
		query.append(",                          UPDATE_USER" ).append("\n"); 
		query.append(",                          UPD_SYS_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("VALUES                (  @[vsl_cd]     " ).append("\n"); 
		query.append(",                        @[voy_no]      " ).append("\n"); 
		query.append(",                        @[dir_cd]      " ).append("\n"); 
		query.append(",                        @[region]      " ).append("\n"); 
		query.append(",                        @[opr_cd]      " ).append("\n"); 
		query.append(",                        @[segment]     " ).append("\n"); 
		query.append(",                        @[ratio_type]  " ).append("\n"); 
		query.append(",                        @[bsa_type]    " ).append("\n"); 
		query.append(",                        @[cgo_wgt]     " ).append("\n"); 
		query.append(",                        @[basic_slot]    " ).append("\n"); 
		query.append(",                        @[basic_wgt]     " ).append("\n"); 
		query.append(",                        @[release_slot]" ).append("\n"); 
		query.append(",                        @[release_wgt] " ).append("\n"); 
		query.append(",                        @[swap_slot]   " ).append("\n"); 
		query.append(",                        @[swap_wgt]    " ).append("\n"); 
		query.append(",                        @[cgo_slot]    " ).append("\n"); 
		query.append(",                        SYSDATE   " ).append("\n"); 
		query.append(",                        @[update_user]" ).append("\n"); 
		query.append(",                        'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
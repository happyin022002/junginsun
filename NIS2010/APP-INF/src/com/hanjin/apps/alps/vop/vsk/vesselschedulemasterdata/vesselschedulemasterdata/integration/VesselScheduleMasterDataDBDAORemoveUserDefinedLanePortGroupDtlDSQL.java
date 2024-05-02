/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VesselScheduleMasterDataDBDAORemoveUserDefinedLanePortGroupDtlDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.16
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2012.08.16 이혜민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hyemin Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMasterDataDBDAORemoveUserDefinedLanePortGroupDtlDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Group별 port, lane정보를 VSK_USR_DEF_COND_DTL 테이블에서 삭제합니다.
	  * 
	  * * History
	  * 2012.08.16 이혜민   CHM-201219190-01 Port SKD inquiry group registration 추가
	  * </pre>
	  */
	public VesselScheduleMasterDataDBDAORemoveUserDefinedLanePortGroupDtlDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("use_pgm_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.integration").append("\n"); 
		query.append("FileName : VesselScheduleMasterDataDBDAORemoveUserDefinedLanePortGroupDtlDSQL").append("\n"); 
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
		query.append("DELETE FROM VSK_USR_DEF_COND_DTL   D" ).append("\n"); 
		query.append("WHERE       D.USR_ID               = @[usr_id]   	   /* LOGIN USER ID                                */" ).append("\n"); 
		query.append("AND         D.USE_PGM_NM           = @[use_pgm_nm]     /* MAIN UI ID   : VOP_VSK_0021                  */" ).append("\n"); 

	}
}
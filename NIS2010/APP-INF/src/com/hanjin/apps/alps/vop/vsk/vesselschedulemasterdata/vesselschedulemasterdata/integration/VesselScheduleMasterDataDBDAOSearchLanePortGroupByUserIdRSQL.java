/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VesselScheduleMasterDataDBDAOSearchLanePortGroupByUserIdRSQL.java
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

public class VesselScheduleMasterDataDBDAOSearchLanePortGroupByUserIdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VSK_0021 화면 오픈시 유저별 Lane Group을 조회합니다.
	  * 
	  * * History
	  * 2012.08.16 이혜민   CHM-201219190-01 Port SKD inquiry group registration 추가
	  * </pre>
	  */
	public VesselScheduleMasterDataDBDAOSearchLanePortGroupByUserIdRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.integration").append("\n"); 
		query.append("FileName : VesselScheduleMasterDataDBDAOSearchLanePortGroupByUserIdRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT H.USR_DEF_GRP_NM" ).append("\n"); 
		query.append("FROM     VSK_USR_DEF_COND_HDR  H" ).append("\n"); 
		query.append(",  VSK_USR_DEF_COND_DTL  D" ).append("\n"); 
		query.append("WHERE    H.USR_ID              = D.USR_ID" ).append("\n"); 
		query.append("AND      H.USR_DEF_GRP_NM      = D.USR_DEF_GRP_NM" ).append("\n"); 
		query.append("AND      H.USE_PGM_NM          = D.USE_PGM_NM" ).append("\n"); 
		query.append("AND      H.DELT_FLG            = 'N'" ).append("\n"); 
		query.append("AND      D.DELT_FLG            = 'N'" ).append("\n"); 
		query.append("AND      H.USR_ID              = @[usr_id]" ).append("\n"); 
		query.append("AND      H.USE_PGM_NM          = 'VOP_VSK_0021'" ).append("\n"); 
		query.append("ORDER BY H.USR_DEF_GRP_NM" ).append("\n"); 

	}
}
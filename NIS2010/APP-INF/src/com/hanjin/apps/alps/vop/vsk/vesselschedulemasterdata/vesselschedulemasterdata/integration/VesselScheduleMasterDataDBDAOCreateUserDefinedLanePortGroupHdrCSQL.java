/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VesselScheduleMasterDataDBDAOCreateUserDefinedLanePortGroupHdrCSQL.java
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

public class VesselScheduleMasterDataDBDAOCreateUserDefinedLanePortGroupHdrCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Group별 port, lane정보를 VSK_USR_DEF_COND_HDR 테이블에 저장합니다.
	  * 
	  * * History
	  * 2012.08.16 이혜민   CHM-201219190-01 Port SKD inquiry group registration 추가
	  * </pre>
	  */
	public VesselScheduleMasterDataDBDAOCreateUserDefinedLanePortGroupHdrCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_def_grp_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("use_pgm_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("use_pgm_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.integration").append("\n"); 
		query.append("FileName : VesselScheduleMasterDataDBDAOCreateUserDefinedLanePortGroupHdrCSQL").append("\n"); 
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
		query.append("MERGE INTO   VSK_USR_DEF_COND_HDR          HD" ).append("\n"); 
		query.append("USING        (" ).append("\n"); 
		query.append("SELECT     @[usr_id]           AS USR_ID" ).append("\n"); 
		query.append(", @[usr_def_grp_nm]   AS USR_DEF_GRP_NM" ).append("\n"); 
		query.append(", @[use_pgm_nm]       AS USE_PGM_NM" ).append("\n"); 
		query.append(", @[use_pgm_desc]     AS USE_PGM_DESC" ).append("\n"); 
		query.append(", @[delt_flg]         AS DELT_FLG" ).append("\n"); 
		query.append(", @[cre_usr_id]       AS CRE_USR_ID" ).append("\n"); 
		query.append(", SYSDATE             AS CRE_DT" ).append("\n"); 
		query.append(", @[upd_usr_id]       AS UPD_USR_ID" ).append("\n"); 
		query.append(", SYSDATE             AS UPD_DT" ).append("\n"); 
		query.append("FROM    DUAL" ).append("\n"); 
		query.append(") XX" ).append("\n"); 
		query.append("ON            (" ).append("\n"); 
		query.append("HD.USR_ID                      = XX.USR_ID" ).append("\n"); 
		query.append("AND      HD.USR_DEF_GRP_NM              = XX.USR_DEF_GRP_NM" ).append("\n"); 
		query.append("AND      HD.USE_PGM_NM                  = XX.USE_PGM_NM" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET" ).append("\n"); 
		query.append("HD.UPD_USR_ID     = XX.UPD_USR_ID" ).append("\n"); 
		query.append(", HD.UPD_DT         = XX.UPD_DT" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT   (" ).append("\n"); 
		query.append("HD.USR_ID" ).append("\n"); 
		query.append(", HD.USR_DEF_GRP_NM" ).append("\n"); 
		query.append(", HD.USE_PGM_NM" ).append("\n"); 
		query.append(", HD.USE_PGM_DESC" ).append("\n"); 
		query.append(", HD.DELT_FLG" ).append("\n"); 
		query.append(", HD.CRE_USR_ID" ).append("\n"); 
		query.append(", HD.CRE_DT" ).append("\n"); 
		query.append(", HD.UPD_USR_ID" ).append("\n"); 
		query.append(", HD.UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES   (  XX.USR_ID            /* USR_ID   */" ).append("\n"); 
		query.append(", XX.USR_DEF_GRP_NM    /* USR_DEF_GRP_NM   */" ).append("\n"); 
		query.append(", XX.USE_PGM_NM        /* USE_PGM_NM       */" ).append("\n"); 
		query.append(", XX.USE_PGM_DESC      /* USE_PGM_DESC     */" ).append("\n"); 
		query.append(", XX.DELT_FLG          /* DELT_FLG         */" ).append("\n"); 
		query.append(", XX.CRE_USR_ID        /* CRE_USR_ID       */" ).append("\n"); 
		query.append(", XX.CRE_DT            /* CRE_DT           */" ).append("\n"); 
		query.append(", XX.UPD_USR_ID        /* UPD_USR_ID       */" ).append("\n"); 
		query.append(", XX.UPD_DT            /* UPD_DT           */" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
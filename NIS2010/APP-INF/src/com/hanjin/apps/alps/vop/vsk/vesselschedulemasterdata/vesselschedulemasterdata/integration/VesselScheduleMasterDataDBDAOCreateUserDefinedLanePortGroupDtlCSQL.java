/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VesselScheduleMasterDataDBDAOCreateUserDefinedLanePortGroupDtlCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMasterDataDBDAOCreateUserDefinedLanePortGroupDtlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Group별 port, lane정보를 VSK_USR_DEF_COND_DTL 테이블에 저장합니다.
	  * 
	  * * History
	  * 2012.08.16 이혜민   CHM-201219190-01 Port SKD inquiry group registration 추가
	  * </pre>
	  */
	public VesselScheduleMasterDataDBDAOCreateUserDefinedLanePortGroupDtlCSQL(){
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
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("amp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.integration").append("\n"); 
		query.append("FileName : VesselScheduleMasterDataDBDAOCreateUserDefinedLanePortGroupDtlCSQL").append("\n"); 
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
		query.append("INSERT INTO VSK_USR_DEF_COND_DTL  D" ).append("\n"); 
		query.append("           (    D.USR_ID          /* LOGIN USER ID                       */" ).append("\n"); 
		query.append("             ,  D.USR_DEF_GRP_NM  /* VOP_VSK_9001 팝업화면의 GROUP NAME  */ " ).append("\n"); 
		query.append("             ,  D.USE_PGM_NM      /* MAIN UI ID   : VOP_VSK_0021         */ " ).append("\n"); 
		query.append("             ,  D.VSL_SLAN_CD     /* VOP_VSK_9001 팝업화면의 S.LANE      */" ).append("\n"); 
		query.append("             ,  D.DIR_CD          /* VOP_VSK_9001 팝업화면의 DIR         */" ).append("\n"); 
		query.append("             ,  D.PORT_CD         /* VOP_VSK_9001 팝업화면의 PORT        */" ).append("\n"); 
		query.append("                --------- PK --------------------------------------------             " ).append("\n"); 
		query.append("             ,  D.AMP_TP_CD		 " ).append("\n"); 
		query.append("			 ,  D.DELT_FLG        /* DEFAULT -- N                        */ " ).append("\n"); 
		query.append("             ,  D.CRE_USR_ID      /* LOGIN USER ID                       */" ).append("\n"); 
		query.append("             ,  D.CRE_DT          /* SYSDATE                             */" ).append("\n"); 
		query.append("             ,  D.UPD_USR_ID      /* LOGIN USER ID                       */" ).append("\n"); 
		query.append("             ,  D.UPD_DT          /* SYSDATE                             */" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("VALUES    " ).append("\n"); 
		query.append("		  (  @[usr_id]" ).append("\n"); 
		query.append("			,@[usr_def_grp_nm]" ).append("\n"); 
		query.append("			,@[use_pgm_nm]" ).append("\n"); 
		query.append("#if (${vsl_slan_cd} == '')" ).append("\n"); 
		query.append("			, ' '" ).append("\n"); 
		query.append("			, ' '" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("			,@[vsl_slan_cd]" ).append("\n"); 
		query.append("			,@[dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${port_cd} == '')" ).append("\n"); 
		query.append("			, ' '" ).append("\n"); 
		query.append("#else					" ).append("\n"); 
		query.append("			,@[port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${amp_tp_cd} == ' ')" ).append("\n"); 
		query.append("			,NULL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("			,@[amp_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("			,@[delt_flg]" ).append("\n"); 
		query.append("			,@[cre_usr_id]" ).append("\n"); 
		query.append("			,SYSDATE" ).append("\n"); 
		query.append("			,@[upd_usr_id]" ).append("\n"); 
		query.append("			,SYSDATE" ).append("\n"); 
		query.append("		   )" ).append("\n"); 

	}
}
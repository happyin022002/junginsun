/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OwnDangerousCargoApprovalDBDAOSearchScgNetWeightRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.16
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.07.16 이도형
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dohyoung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnDangerousCargoApprovalDBDAOSearchScgNetWeightRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MPA 1 Cargo 의 Net Weight 조회
	  * </pre>
	  */
	public OwnDangerousCargoApprovalDBDAOSearchScgNetWeightRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : OwnDangerousCargoApprovalDBDAOSearchScgNetWeightRSQL").append("\n"); 
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
		query.append("SELECT SUM(NET_WGT) AS NET_WGT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT SUM(DG.NET_WGT) AS NET_WGT" ).append("\n"); 
		query.append("FROM SCG_DG_CGO DG" ).append("\n"); 
		query.append(", SCG_VVD_APRO_RQST SV" ).append("\n"); 
		query.append(", SCG_AUTHORIZATION SA" ).append("\n"); 
		query.append(", VSK_VSL_PORT_SKD V1" ).append("\n"); 
		query.append(", VSK_VSL_PORT_SKD V2" ).append("\n"); 
		query.append(", VSK_VSL_PORT_SKD VV" ).append("\n"); 
		query.append("WHERE SV.BKG_NO                 = DG.BKG_NO" ).append("\n"); 
		query.append("AND SV.SPCL_CGO_APRO_RQST_SEQ = DG.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("AND SV.VSL_CD                 = V1.VSL_CD" ).append("\n"); 
		query.append("AND SV.SKD_VOY_NO             = V1.SKD_VOY_NO" ).append("\n"); 
		query.append("AND SV.SKD_DIR_CD             = V1.SKD_DIR_CD" ).append("\n"); 
		query.append("AND NVL(SV.POD_CD,' ')        = V1.VPS_PORT_CD" ).append("\n"); 
		query.append("AND SV.VSL_CD                 = V2.VSL_CD" ).append("\n"); 
		query.append("AND SV.SKD_VOY_NO             = V2.SKD_VOY_NO" ).append("\n"); 
		query.append("AND SV.SKD_DIR_CD             = V2.SKD_DIR_CD" ).append("\n"); 
		query.append("AND NVL(SV.POD_CD,' ')        = V2.VPS_PORT_CD" ).append("\n"); 
		query.append("AND SV.VSL_CD                 = VV.VSL_CD" ).append("\n"); 
		query.append("AND SV.SKD_VOY_NO             = VV.SKD_VOY_NO" ).append("\n"); 
		query.append("AND SV.SKD_DIR_CD             = VV.SKD_DIR_CD" ).append("\n"); 
		query.append("AND VV.VPS_PORT_CD           = 'SGSIN'" ).append("\n"); 
		query.append("AND VV.CLPT_SEQ BETWEEN V1.CLPT_SEQ AND V2.CLPT_SEQ" ).append("\n"); 
		query.append("AND ( DG.PSA_NO = '1' OR DG.FLSH_PNT_CDO_TEMP < -25 )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND SV.BKG_NO = SA.BKG_NO" ).append("\n"); 
		query.append("AND SV.SPCL_CGO_APRO_RQST_SEQ = SA.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("AND SV.VSL_PRE_PST_CD = SA.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("AND SV.VSL_SEQ = SA.VSL_SEQ" ).append("\n"); 
		query.append("AND SA.SPCL_CGO_AUTH_CD = 'Y'" ).append("\n"); 
		query.append("AND SV.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND SV.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND SV.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT SUM(CGO.NET_WGT) AS NET_WGT" ).append("\n"); 
		query.append("FROM SCG_PRNR_APRO_RQST RQS" ).append("\n"); 
		query.append(", SCG_PRNR_APRO_RQST_CGO CGO" ).append("\n"); 
		query.append(", VSK_VSL_PORT_SKD V1" ).append("\n"); 
		query.append(", VSK_VSL_PORT_SKD V2" ).append("\n"); 
		query.append(", VSK_VSL_PORT_SKD VV" ).append("\n"); 
		query.append("WHERE RQS.VSL_CD           = V1.VSL_CD" ).append("\n"); 
		query.append("AND RQS.SKD_VOY_NO        = V1.SKD_VOY_NO" ).append("\n"); 
		query.append("AND RQS.SKD_DIR_CD        = V1.SKD_DIR_CD" ).append("\n"); 
		query.append("AND NVL(RQS.POD_CD,' ')   = V1.VPS_PORT_CD" ).append("\n"); 
		query.append("AND RQS.VSL_CD            = V2.VSL_CD" ).append("\n"); 
		query.append("AND RQS.SKD_VOY_NO        = V2.SKD_VOY_NO" ).append("\n"); 
		query.append("AND RQS.SKD_DIR_CD        = V2.SKD_DIR_CD" ).append("\n"); 
		query.append("AND NVL(RQS.POD_CD,' ')   = V2.VPS_PORT_CD" ).append("\n"); 
		query.append("AND RQS.VSL_CD            = VV.VSL_CD" ).append("\n"); 
		query.append("AND RQS.SKD_VOY_NO        = VV.SKD_VOY_NO" ).append("\n"); 
		query.append("AND RQS.SKD_DIR_CD        = VV.SKD_DIR_CD" ).append("\n"); 
		query.append("AND VV.VPS_PORT_CD       = 'SGSIN'" ).append("\n"); 
		query.append("AND VV.CLPT_SEQ BETWEEN V1.CLPT_SEQ AND V2.CLPT_SEQ" ).append("\n"); 
		query.append("AND ( CGO.PSA_NO = 1 OR CGO.FLSH_PNT_CDO_TEMP < -25 )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND CGO.AUTH_STS_CD = 'Y'" ).append("\n"); 
		query.append("AND RQS.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND RQS.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND RQS.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
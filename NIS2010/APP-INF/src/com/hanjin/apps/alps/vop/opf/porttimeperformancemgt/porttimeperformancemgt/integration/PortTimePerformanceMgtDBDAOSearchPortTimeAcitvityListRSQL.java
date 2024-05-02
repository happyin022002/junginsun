/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PortTimePerformanceMgtDBDAOSearchPortTimeAcitvityListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.30
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2013.01.30 원종규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jongkyu Weon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTimePerformanceMgtDBDAOSearchPortTimeAcitvityListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD Port별 Activity Time 정보을 조회 한다.
	  * History------------------------------------------------------------------------------------
	  * 2012.02.20 김민아 [CHM-201215901-01] Port Time Reduction project 개발 (2차)
	  * </pre>
	  */
	public PortTimePerformanceMgtDBDAOSearchPortTimeAcitvityListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_gen_cd_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.integration").append("\n"); 
		query.append("FileName : PortTimePerformanceMgtDBDAOSearchPortTimeAcitvityListRSQL").append("\n"); 
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
		query.append("SELECT  CD.PORT_ACT_GRP_DESC" ).append("\n"); 
		query.append("       ,CD.PORT_ACT_DESC" ).append("\n"); 
		query.append("       ,DECODE(CD.PORT_ACT_CTNT, 'PTA0022', SKD2.BFR_BRTH_ANK_DRP_DT, 'PTA0023', SKD2.BFR_BRTH_ANK_OFF_DT, ACT.WRK_PERF_DT) WRK_PERF_DT" ).append("\n"); 
		query.append("       ,ACT.CNTR_HNDL_KNT" ).append("\n"); 
		query.append("       ,ACT.OP_STPG_CTNT" ).append("\n"); 
		query.append("       ,DECODE(CD.PORT_ACT_CTNT, 'PTA0022',NVL2(SKD2.BFR_BRTH_ANK_DRP_DT,'VMS',''), 'PTA0023',NVL2(SKD2.BFR_BRTH_ANK_OFF_DT,'VMS',''), ACT.SRC_SVR_NM) SRC_SVR_NM" ).append("\n"); 
		query.append("       ,DECODE(CD.PORT_ACT_CTNT, 'PTA0022',SKD2.DIFF_RMK, 'PTA0023',SKD2.DIFF_RMK, ACT.DIFF_RMK) DIFF_RMK" ).append("\n"); 
		query.append("       ,ACT.CRE_USR_ID" ).append("\n"); 
		query.append("       ,ACT.CRE_DT" ).append("\n"); 
		query.append("       ,ACT.UPD_USR_ID" ).append("\n"); 
		query.append("       ,ACT.UPD_DT" ).append("\n"); 
		query.append("       ,CD.PORT_ACT_CTNT" ).append("\n"); 
		query.append("       ,NVL(ACT.VSL_CD       ,@[vsl_cd]      ) AS VSL_CD" ).append("\n"); 
		query.append("       ,NVL(ACT.SKD_VOY_NO   ,@[skd_voy_no]  ) AS SKD_VOY_NO" ).append("\n"); 
		query.append("       ,NVL(ACT.SKD_DIR_CD   ,@[skd_dir_cd]  ) AS SKD_DIR_CD" ).append("\n"); 
		query.append("       ,NVL(ACT.VPS_PORT_CD  ,@[vps_port_cd] ) AS VPS_PORT_CD" ).append("\n"); 
		query.append("       ,NVL(ACT.CLPT_IND_SEQ ,@[clpt_ind_seq]) AS CLPT_IND_SEQ" ).append("\n"); 
		query.append("       ,'' AS ACT_GEN_CD_ID" ).append("\n"); 
		query.append("  FROM  OPF_PORT_TM_ACT ACT" ).append("\n"); 
		query.append("       ,(" ).append("\n"); 
		query.append("        SELECT  (" ).append("\n"); 
		query.append("                SELECT  S.ACT_GEN_CD_VAL_DESC" ).append("\n"); 
		query.append("                FROM    OPF_GEN_CD_DTL S" ).append("\n"); 
		query.append("                WHERE   S.ACT_GEN_CD_ID       = 'CD00004'" ).append("\n"); 
		query.append("                AND     S.ACT_GEN_CD_VAL_CTNT = T.ACT_GEN_CD_GRP_ID" ).append("\n"); 
		query.append("                )                   AS PORT_ACT_GRP_DESC" ).append("\n"); 
		query.append("              , ACT_GEN_CD_VAL_CTNT AS PORT_ACT_CTNT" ).append("\n"); 
		query.append("              , ACT_GEN_CD_VAL_DESC AS PORT_ACT_DESC" ).append("\n"); 
		query.append("        FROM    OPF_GEN_CD_DTL T" ).append("\n"); 
		query.append("        WHERE   ACT_GEN_CD_ID   = @[act_gen_cd_id]" ).append("\n"); 
		query.append("        ORDER BY DP_SEQ" ).append("\n"); 
		query.append("        ) CD" ).append("\n"); 
		query.append("       ,VSK_ACT_PORT_SKD  SKD" ).append("\n"); 
		query.append("	   ,VSK_ACT_PORT_SKD  SKD2" ).append("\n"); 
		query.append(" WHERE  1 = 1" ).append("\n"); 
		query.append("   AND  CD.PORT_ACT_CTNT = ACT.PORT_ACT_CTNT (+)" ).append("\n"); 
		query.append("   AND  ACT.VSL_CD      (+) = @[vsl_cd]" ).append("\n"); 
		query.append("   AND  ACT.SKD_VOY_NO  (+) = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND  ACT.SKD_DIR_CD  (+) = @[skd_dir_cd]" ).append("\n"); 
		query.append("   AND  ACT.VPS_PORT_CD (+) = @[vps_port_cd]" ).append("\n"); 
		query.append("   AND  ACT.CLPT_IND_SEQ(+) = @[clpt_ind_seq]" ).append("\n"); 
		query.append("   AND  SKD2.VSL_CD      (+) = @[vsl_cd]" ).append("\n"); 
		query.append("   AND  SKD2.SKD_VOY_NO  (+) = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND  SKD2.SKD_DIR_CD  (+) = @[skd_dir_cd]" ).append("\n"); 
		query.append("   AND  SKD2.VPS_PORT_CD (+) = @[vps_port_cd]" ).append("\n"); 
		query.append("   AND  SKD2.CLPT_IND_SEQ(+) = @[clpt_ind_seq]" ).append("\n"); 
		query.append("   AND  SKD.VSL_CD      (+) = ACT.VSL_CD" ).append("\n"); 
		query.append("   AND  SKD.SKD_VOY_NO  (+) = ACT.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND  SKD.SKD_DIR_CD  (+) = ACT.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND  SKD.VPS_PORT_CD (+) = ACT.VPS_PORT_CD" ).append("\n"); 
		query.append("   AND  SKD.CLPT_IND_SEQ(+) = ACT.CLPT_IND_SEQ" ).append("\n"); 

	}
}
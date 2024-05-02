/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ActualScheduleMgtDBDAOModifyPortSkdEstmDtRestoreUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.03
*@LastModifier : 황태진
*@LastVersion : 1.0
* 2012.12.03  황태진 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hwang Taejin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ActualScheduleMgtDBDAOModifyPortSkdEstmDtRestoreUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.11.29 CHM-201221263 황태진
	  * [VSK] Actual sked 삭제시 Estimated sked의 원복 로직 적용 요청
	  * </pre>
	  */
	public ActualScheduleMgtDBDAOModifyPortSkdEstmDtRestoreUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("Path : com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.integration").append("\n"); 
		query.append("FileName : ActualScheduleMgtDBDAOModifyPortSkdEstmDtRestoreUSQL").append("\n"); 
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
		query.append("MERGE INTO  VSK_VSL_PORT_SKD      XX" ).append("\n"); 
		query.append("USING      (" ).append("\n"); 
		query.append("            SELECT    GUBUN" ).append("\n"); 
		query.append("                   ,  VSL_CD" ).append("\n"); 
		query.append("                   ,  SKD_VOY_NO" ).append("\n"); 
		query.append("                   ,  SKD_DIR_CD" ).append("\n"); 
		query.append("                   ,  VPS_PORT_CD" ).append("\n"); 
		query.append("                   ,  CLPT_IND_SEQ" ).append("\n"); 
		query.append("                   ,  VPS_ETA_DT" ).append("\n"); 
		query.append("                   ,  VPS_ETB_DT" ).append("\n"); 
		query.append("                   ,  VPS_ETD_DT" ).append("\n"); 
		query.append("                   ,  BFR_VPS_ETA_DT" ).append("\n"); 
		query.append("                   ,  BFR_VPS_ETB_DT" ).append("\n"); 
		query.append("                   ,  BFR_VPS_ETD_DT" ).append("\n"); 
		query.append("            FROM     (SELECT    'X'  GUBUN" ).append("\n"); 
		query.append("                             ,  PS.VSL_CD" ).append("\n"); 
		query.append("                             ,  PS.SKD_VOY_NO" ).append("\n"); 
		query.append("                             ,  PS.SKD_DIR_CD" ).append("\n"); 
		query.append("                             ,  PS.VPS_PORT_CD" ).append("\n"); 
		query.append("                             ,  PS.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                             ,  PS.VPS_ETA_DT" ).append("\n"); 
		query.append("                             ,  PS.VPS_ETB_DT" ).append("\n"); 
		query.append("                             ,  PS.VPS_ETD_DT" ).append("\n"); 
		query.append("                             ,  H.BFR_VPS_ETA_DT" ).append("\n"); 
		query.append("                             ,  H.BFR_VPS_ETB_DT" ).append("\n"); 
		query.append("                             ,  H.BFR_VPS_ETD_DT" ).append("\n"); 
		query.append("                      FROM      VSK_VSL_PORT_SKD    PS    " ).append("\n"); 
		query.append("                             ,  VSK_VSL_SKD_HIS     H" ).append("\n"); 
		query.append("                      WHERE     1 = 1                " ).append("\n"); 
		query.append("                      AND       PS.VSL_CD           = H.BFR_VSL_CD      " ).append("\n"); 
		query.append("                      AND       PS.SKD_VOY_NO       = H.BFR_SKD_VOY_NO  " ).append("\n"); 
		query.append("                      AND       PS.SKD_DIR_CD       = H.BFR_SKD_DIR_CD  " ).append("\n"); 
		query.append("                      AND       PS.VPS_PORT_CD      = H.BFR_VPS_PORT_CD " ).append("\n"); 
		query.append("                      AND       PS.CLPT_IND_SEQ     = H.BFR_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                      AND       PS.VSL_CD           = @[vsl_cd]" ).append("\n"); 
		query.append("                      AND       PS.SKD_VOY_NO       = @[skd_voy_no]" ).append("\n"); 
		query.append("                      AND       PS.SKD_DIR_CD       = @[skd_dir_cd]" ).append("\n"); 
		query.append("                      AND       PS.VPS_PORT_CD      = @[vps_port_cd]" ).append("\n"); 
		query.append("                      AND       PS.CLPT_IND_SEQ     = @[clpt_ind_seq]" ).append("\n"); 
		query.append("                      AND       H.VSKD_TP_CD        = 'P'" ).append("\n"); 
		query.append("                      AND       H.VSKD_CNG_TP_CD    = 'E'   " ).append("\n"); 
		query.append("                      AND       H.VSKD_CNG_NO         = (SELECT   MAX(HIS.VSKD_CNG_NO)" ).append("\n"); 
		query.append("                                                         FROM     VSK_VSL_SKD_HIS       HIS" ).append("\n"); 
		query.append("                                                         WHERE    HIS.VSKD_TP_CD        = H.VSKD_TP_CD" ).append("\n"); 
		query.append("                                                         AND      HIS.BFR_VSL_CD        = H.BFR_VSL_CD" ).append("\n"); 
		query.append("                                                         AND      HIS.BFR_SKD_VOY_NO    = H.BFR_SKD_VOY_NO" ).append("\n"); 
		query.append("                                                         AND      HIS.BFR_SKD_DIR_CD    = H.BFR_SKD_DIR_CD" ).append("\n"); 
		query.append("                                                         AND      HIS.BFR_VPS_PORT_CD   = H.BFR_VPS_PORT_CD" ).append("\n"); 
		query.append("                                                         AND      HIS.BFR_CLPT_IND_SEQ  = H.BFR_CLPT_IND_SEQ " ).append("\n"); 
		query.append("                                                         AND      HIS.VSKD_CNG_TP_CD    = H.VSKD_CNG_TP_CD" ).append("\n"); 
		query.append("                                                         )     " ).append("\n"); 
		query.append("                                                 " ).append("\n"); 
		query.append("                      UNION ALL" ).append("\n"); 
		query.append("                      SELECT    'Y'  GUBUN" ).append("\n"); 
		query.append("                             ,  PS.VSL_CD" ).append("\n"); 
		query.append("                             ,  PS.SKD_VOY_NO" ).append("\n"); 
		query.append("                             ,  PS.SKD_DIR_CD" ).append("\n"); 
		query.append("                             ,  PS.VPS_PORT_CD" ).append("\n"); 
		query.append("                             ,  PS.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                             ,  PS.VPS_ETA_DT" ).append("\n"); 
		query.append("                             ,  PS.VPS_ETB_DT" ).append("\n"); 
		query.append("                             ,  PS.VPS_ETD_DT" ).append("\n"); 
		query.append("                             ,  AK.LST_ETA_DT" ).append("\n"); 
		query.append("                             ,  AK.LST_ETB_DT" ).append("\n"); 
		query.append("                             ,  AK.LST_ETD_DT" ).append("\n"); 
		query.append("                      FROM      VSK_VSL_PORT_SKD    PS" ).append("\n"); 
		query.append("                             ,  VSK_ACT_PORT_SKD    AK" ).append("\n"); 
		query.append("                      WHERE     PS.VSL_CD           = AK.VSL_CD" ).append("\n"); 
		query.append("                      AND       PS.SKD_VOY_NO       = AK.SKD_VOY_NO" ).append("\n"); 
		query.append("                      AND       PS.SKD_DIR_CD       = AK.SKD_DIR_CD" ).append("\n"); 
		query.append("                      AND       PS.VPS_PORT_CD      = AK.VPS_PORT_CD" ).append("\n"); 
		query.append("                      AND       PS.CLPT_IND_SEQ     = AK.CLPT_IND_SEQ  " ).append("\n"); 
		query.append("                      AND       PS.VSL_CD           = @[vsl_cd]" ).append("\n"); 
		query.append("                      AND       PS.SKD_VOY_NO       = @[skd_voy_no]" ).append("\n"); 
		query.append("                      AND       PS.SKD_DIR_CD       = @[skd_dir_cd]" ).append("\n"); 
		query.append("                      AND       PS.VPS_PORT_CD      = @[vps_port_cd]" ).append("\n"); 
		query.append("                      AND       PS.CLPT_IND_SEQ     = @[clpt_ind_seq]" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("            WHERE     ROWNUM    = 1        " ).append("\n"); 
		query.append("            ) YY  " ).append("\n"); 
		query.append("ON          (" ).append("\n"); 
		query.append("            XX.VSL_CD                     = YY.VSL_CD" ).append("\n"); 
		query.append("     AND    XX.SKD_VOY_NO                 = YY.SKD_VOY_NO" ).append("\n"); 
		query.append("     AND    XX.SKD_DIR_CD                 = YY.SKD_DIR_CD" ).append("\n"); 
		query.append("     AND    XX.VPS_PORT_CD                = YY.VPS_PORT_CD" ).append("\n"); 
		query.append("     AND    XX.CLPT_IND_SEQ               = YY.CLPT_IND_SEQ            " ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("WHEN MATCHED THEN  " ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET   " ).append("\n"); 
		query.append("            XX.VPS_ETA_DT         = NVL(YY.BFR_VPS_ETA_DT, XX.VPS_ETA_DT)" ).append("\n"); 
		query.append("      ,     XX.VPS_ETB_DT         = NVL(YY.BFR_VPS_ETB_DT, XX.VPS_ETB_DT)" ).append("\n"); 
		query.append("      ,     XX.VPS_ETD_DT         = NVL(YY.BFR_VPS_ETD_DT, XX.VPS_ETD_DT)" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOModifyVskVslPortSkdByActualUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.25
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOModifyVskVslPortSkdByActualUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * 
	  * 20140227 임예지 [CHM-201429074] ATA, ATB, ATD 개별 삭제뒤 SAVE시 PORT_SKD_STS_CD UPDATE 로직 변경
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOModifyVskVslPortSkdByActualUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_inp_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_etb_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOModifyVskVslPortSkdByActualUSQL").append("\n"); 
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
		query.append("UPDATE  VSK_VSL_PORT_SKD T1" ).append("\n"); 
		query.append("SET     PORT_SKD_STS_CD = ( " ).append("\n"); 
		query.append("		CASE WHEN (SELECT   X.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("  			       FROM     VSK_VSL_PORT_SKD   X" ).append("\n"); 
		query.append("  			       WHERE    1 = 1" ).append("\n"); 
		query.append("  			       AND      X.VSL_CD           = @[vsl_cd]" ).append("\n"); 
		query.append("  			       AND      X.SKD_VOY_NO       = @[skd_voy_no]" ).append("\n"); 
		query.append("   				   AND      X.SKD_DIR_CD       = @[skd_dir_cd]" ).append("\n"); 
		query.append("           		   AND      X.VPS_PORT_CD      = @[vps_port_cd]" ).append("\n"); 
		query.append("          		   AND      X.CLPT_IND_SEQ     = @[clpt_ind_seq]" ).append("\n"); 
		query.append("           ) IN ('Y','N') THEN (SELECT   AK.PORT_SKD_STS_CD" ).append("\n"); 
		query.append("                                FROM     VSK_ACT_PORT_SKD   AK" ).append("\n"); 
		query.append("                                WHERE    1 = 1" ).append("\n"); 
		query.append("                                AND      AK.VSL_CD          = @[vsl_cd]" ).append("\n"); 
		query.append("                                AND      AK.SKD_VOY_NO      = @[skd_voy_no]" ).append("\n"); 
		query.append("                                AND      AK.SKD_DIR_CD      = @[skd_dir_cd]" ).append("\n"); 
		query.append("                                AND      AK.VPS_PORT_CD     = @[vps_port_cd]" ).append("\n"); 
		query.append("                                AND      AK.CLPT_IND_SEQ    = @[clpt_ind_seq]" ).append("\n"); 
		query.append("     	                        )" ).append("\n"); 
		query.append("     	   ELSE" ).append("\n"); 
		query.append("                               (SELECT   AK.PORT_SKD_STS_CD" ).append("\n"); 
		query.append("                                FROM     VSK_VSL_PORT_SKD   X" ).append("\n"); 
		query.append("                                      ,  VSK_ACT_PORT_SKD   AK" ).append("\n"); 
		query.append("                                WHERE    1 = 1" ).append("\n"); 
		query.append("                                AND      X.VSL_CD           = AK.VSL_CD" ).append("\n"); 
		query.append("                                AND      X.TURN_SKD_VOY_NO  = AK.SKD_VOY_NO" ).append("\n"); 
		query.append("                                AND      X.TURN_SKD_DIR_CD  = AK.SKD_DIR_CD" ).append("\n"); 
		query.append("                                AND      X.VPS_PORT_CD      = AK.VPS_PORT_CD" ).append("\n"); 
		query.append("                                AND      X.TURN_CLPT_IND_SEQ= AK.CLPT_IND_SEQ" ).append("\n"); 
		query.append("								AND      X.VSL_CD           = @[vsl_cd]" ).append("\n"); 
		query.append("  			       				AND      X.SKD_VOY_NO       = @[skd_voy_no]" ).append("\n"); 
		query.append("   				   				AND      X.SKD_DIR_CD       = @[skd_dir_cd]" ).append("\n"); 
		query.append("           		   				AND      X.VPS_PORT_CD      = @[vps_port_cd]" ).append("\n"); 
		query.append("          		   				AND      X.CLPT_IND_SEQ     = @[clpt_ind_seq]" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("		END), " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    	YD_CD           = NVL(@[yd_cd], YD_CD)," ).append("\n"); 
		query.append("        CALL_YD_IND_SEQ = (" ).append("\n"); 
		query.append("                            SELECT  DECODE(COUNT(*), 0, 1, COUNT(*))		/* YD_CD 가 변경이 되면 0이 발생할 수 있음. */" ).append("\n"); 
		query.append("                            FROM    VSK_VSL_PORT_SKD T2" ).append("\n"); 
		query.append("                            WHERE   T2.VSL_CD       = T1.VSL_CD" ).append("\n"); 
		query.append("                            AND     T2.SKD_VOY_NO   = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("                            AND     T2.SKD_DIR_CD   = T1.SKD_DIR_CD" ).append("\n"); 
		query.append("                            AND     T2.CLPT_SEQ     <= (SELECT  CLPT_SEQ" ).append("\n"); 
		query.append("                                                      FROM    VSK_VSL_PORT_SKD T3" ).append("\n"); 
		query.append("                                                      WHERE   T2.VSL_CD    = T3.VSL_CD" ).append("\n"); 
		query.append("                                                      AND     SKD_VOY_NO   = @[skd_voy_no]" ).append("\n"); 
		query.append("                                                      AND     SKD_DIR_CD   = @[skd_dir_cd]" ).append("\n"); 
		query.append("                                                      AND     VPS_PORT_CD  = @[vps_port_cd]" ).append("\n"); 
		query.append("                                                      AND     CLPT_IND_SEQ = @[clpt_ind_seq]" ).append("\n"); 
		query.append("                                                     )" ).append("\n"); 
		query.append("                           AND      T2.YD_CD        = @[yd_cd]" ).append("\n"); 
		query.append("                           )," ).append("\n"); 
		query.append("        VPS_ETA_DT      = NVL(TO_DATE(@[vps_eta_dt], 'YYYYMMDDHH24MI'), VPS_ETA_DT)," ).append("\n"); 
		query.append("        VPS_ETB_DT      = NVL(TO_DATE(@[vps_etb_dt], 'YYYYMMDDHH24MI'), VPS_ETB_DT)," ).append("\n"); 
		query.append("        VPS_ETD_DT      = NVL(TO_DATE(@[vps_etd_dt], 'YYYYMMDDHH24MI'), VPS_ETD_DT)," ).append("\n"); 
		query.append("        UPD_USR_ID      = @[upd_usr_id]," ).append("\n"); 
		query.append("        UPD_DT          = SYSDATE," ).append("\n"); 
		query.append("		ACT_INP_FLG		= NVL(@[act_inp_flg], ACT_INP_FLG)" ).append("\n"); 
		query.append("WHERE   VSL_CD       = @[vsl_cd]" ).append("\n"); 
		query.append("AND     SKD_VOY_NO   = @[skd_voy_no]" ).append("\n"); 
		query.append("AND     SKD_DIR_CD   = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND     VPS_PORT_CD  = @[vps_port_cd]" ).append("\n"); 
		query.append("AND     CLPT_IND_SEQ = @[clpt_ind_seq]" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOCheckSkipCallHistoryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.15
*@LastModifier : 
*@LastVersion : 1.0
* 2012.05.15 
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

public class VesselScheduleMgtDBDAOCheckSkipCallHistoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VSL SKD History 정보 중 Skip Call, Skip Call Cancel를 확인한다.
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOCheckSkipCallHistoryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_cng_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOCheckSkipCallHistoryRSQL").append("\n"); 
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
		query.append("SELECT  COUNT(*) SKIP_CANCEL_FLAG" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        SELECT  /*+INDEX(T1 XAK1VSK_VSL_SKD_HIS)*/" ).append("\n"); 
		query.append("                T1.VSKD_CNG_TP_CD" ).append("\n"); 
		query.append("                , ROW_NUMBER() OVER (ORDER BY T1.CRE_DT DESC) AS SEQ" ).append("\n"); 
		query.append("        FROM    VSK_VSL_SKD_HIS     T1," ).append("\n"); 
		query.append("                VSK_VSL_PORT_SKD    T2" ).append("\n"); 
		query.append("        WHERE   1=1" ).append("\n"); 
		query.append("        AND     T1.BFR_VSL_CD          = T2.VSL_CD" ).append("\n"); 
		query.append("        AND     T1.BFR_SKD_VOY_NO      = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND     T1.BFR_SKD_DIR_CD      = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND     T1.BFR_VPS_PORT_CD     = T2.VPS_PORT_CD" ).append("\n"); 
		query.append("        AND     T1.BFR_CLPT_IND_SEQ    = T2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("        AND     T2.SKD_CNG_STS_CD      = 'S'" ).append("\n"); 
		query.append("        AND     T1.BFR_VSL_CD          = @[vsl_cd]" ).append("\n"); 
		query.append("        AND     T1.BFR_SKD_VOY_NO      = @[skd_voy_no]" ).append("\n"); 
		query.append("        AND     T1.BFR_SKD_DIR_CD      = @[skd_dir_cd]" ).append("\n"); 
		query.append("        AND     T1.BFR_VPS_PORT_CD     = @[vps_port_cd]" ).append("\n"); 
		query.append("        AND     T1.BFR_CLPT_IND_SEQ    = @[clpt_ind_seq]" ).append("\n"); 
		query.append("        AND     T1.VSKD_CNG_TP_CD      IN ('S', 'X')" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("WHERE   SEQ = 1" ).append("\n"); 
		query.append("AND     VSKD_CNG_TP_CD  = 'S'" ).append("\n"); 
		query.append("AND     NVL(@[skd_cng_sts_cd], ' ') = ' '  -- Skip Call Cancel" ).append("\n"); 

	}
}
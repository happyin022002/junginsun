/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ProformaScheduleMgtDBDAOSearchVskPfSkdDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProformaScheduleMgtDBDAOSearchVskPfSkdDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VSK_PF_SKD_DTL 조회
	  * </pre>
	  */
	public ProformaScheduleMgtDBDAOSearchVskPfSkdDtlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pf_svc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration").append("\n"); 
		query.append("FileName : ProformaScheduleMgtDBDAOSearchVskPfSkdDtlRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("      VSL_SLAN_CD" ).append("\n"); 
		query.append("    , PF_SVC_TP_CD" ).append("\n"); 
		query.append("    , PORT_CD" ).append("\n"); 
		query.append("    , SKD_DIR_CD" ).append("\n"); 
		query.append("    , CLPT_SEQ" ).append("\n"); 
		query.append("    , PORT_ROTN_SEQ" ).append("\n"); 
		query.append("    , YD_CD" ).append("\n"); 
		query.append("    , CALL_YD_IND_SEQ" ).append("\n"); 
		query.append("    , TURN_PORT_FLG" ).append("\n"); 
		query.append("    , TURN_PORT_IND_CD" ).append("\n"); 
		query.append("    , ETB_DY_CD" ).append("\n"); 
		query.append("    , ETB_DY_NO" ).append("\n"); 
		query.append("    , ETB_TM_HRMNT" ).append("\n"); 
		query.append("    , ETD_DY_CD" ).append("\n"); 
		query.append("    , ETD_DY_NO" ).append("\n"); 
		query.append("    , ETD_TM_HRMNT" ).append("\n"); 
		query.append("    , LNK_DIST" ).append("\n"); 
		query.append("    , LNK_SPD" ).append("\n"); 
		query.append("    , TZTM_HRS" ).append("\n"); 
		query.append("    , SEA_BUF_HRS" ).append("\n"); 
		query.append("    , SEA_BUF_SPD" ).append("\n"); 
		query.append("    , MNVR_IN_HRS" ).append("\n"); 
		query.append("    , MNVR_OUT_HRS" ).append("\n"); 
		query.append("    , IB_IPCGO_QTY" ).append("\n"); 
		query.append("    , IB_OCN_CGO_QTY" ).append("\n"); 
		query.append("    , OB_IPCGO_QTY" ).append("\n"); 
		query.append("    , OB_OCN_CGO_QTY" ).append("\n"); 
		query.append("    , TML_PROD_QTY" ).append("\n"); 
		query.append("    , CRN_KNT" ).append("\n"); 
		query.append("    , ACT_WRK_HRS" ).append("\n"); 
		query.append("    , PORT_BUF_HRS" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append("    , EDW_UPD_DT" ).append("\n"); 
		query.append("FROM  VSK_PF_SKD_DTL" ).append("\n"); 
		query.append("WHERE VSL_SLAN_CD = @[vsl_slan_cd] " ).append("\n"); 
		query.append("  AND PF_SVC_TP_CD = @[pf_svc_tp_cd]" ).append("\n"); 
		query.append("#if (${port_cd} != '') " ).append("\n"); 
		query.append("  AND PORT_CD = @[port_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_dir_cd} != '') " ).append("\n"); 
		query.append("  AND SKD_DIR_CD = @[skd_dir_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${clpt_seq} != '') " ).append("\n"); 
		query.append("  AND CLPT_SEQ = @[clpt_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
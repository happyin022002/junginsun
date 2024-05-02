/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ProformaScheduleMgtDBDAOAddVskPfSkdDtlCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.22
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.02.22 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.budget.proformaschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProformaScheduleMgtDBDAOAddVskPfSkdDtlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VSK_PF_SKD_DTL 다건의 데이터를 생성한다.
	  * 
	  * * History
	  * * 2011.02.22 진마리아 CHM-201108456-01 사업계획용 스케줄 정보 노출 대응을 위한 시스템 업데이트건
	  * </pre>
	  */
	public ProformaScheduleMgtDBDAOAddVskPfSkdDtlCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnvr_in_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_prod_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_ipcgo_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crn_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etd_tm_hrmnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_ocn_cgo_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("turn_port_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("act_wrk_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("turn_port_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnvr_out_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etb_tm_hrmnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_ocn_cgo_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tztm_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etb_dy_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("port_buf_hrs",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lnk_dist",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lnk_spd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("port_rotn_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etb_dy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_ipcgo_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("etd_dy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etd_dy_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sea_buf_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sea_buf_spd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.budget.proformaschedulemgt.integration").append("\n"); 
		query.append("FileName : ProformaScheduleMgtDBDAOAddVskPfSkdDtlCSQL").append("\n"); 
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
		query.append("INSERT INTO VSK_BUD_PF_SKD_DTL" ).append("\n"); 
		query.append("        (VSL_SLAN_CD" ).append("\n"); 
		query.append("          ,PF_SVC_TP_CD" ).append("\n"); 
		query.append("          ,PORT_CD" ).append("\n"); 
		query.append("          ,SKD_DIR_CD" ).append("\n"); 
		query.append("          ,CLPT_SEQ" ).append("\n"); 
		query.append("          ,PORT_ROTN_SEQ" ).append("\n"); 
		query.append("          ,YD_CD" ).append("\n"); 
		query.append("          ,CALL_YD_IND_SEQ" ).append("\n"); 
		query.append("          ,TURN_PORT_FLG" ).append("\n"); 
		query.append("          ,TURN_PORT_IND_CD" ).append("\n"); 
		query.append("          ,ETB_DY_CD" ).append("\n"); 
		query.append("          ,ETB_DY_NO" ).append("\n"); 
		query.append("          ,ETB_TM_HRMNT" ).append("\n"); 
		query.append("          ,ETD_DY_CD" ).append("\n"); 
		query.append("          ,ETD_DY_NO" ).append("\n"); 
		query.append("          ,ETD_TM_HRMNT" ).append("\n"); 
		query.append("          ,LNK_DIST" ).append("\n"); 
		query.append("          ,LNK_SPD" ).append("\n"); 
		query.append("          ,TZTM_HRS" ).append("\n"); 
		query.append("          ,SEA_BUF_HRS" ).append("\n"); 
		query.append("          ,SEA_BUF_SPD" ).append("\n"); 
		query.append("          ,MNVR_IN_HRS" ).append("\n"); 
		query.append("          ,MNVR_OUT_HRS" ).append("\n"); 
		query.append("          ,IB_IPCGO_QTY" ).append("\n"); 
		query.append("          ,IB_OCN_CGO_QTY" ).append("\n"); 
		query.append("          ,OB_IPCGO_QTY" ).append("\n"); 
		query.append("          ,OB_OCN_CGO_QTY" ).append("\n"); 
		query.append("          ,TML_PROD_QTY" ).append("\n"); 
		query.append("          ,CRN_KNT" ).append("\n"); 
		query.append("          ,ACT_WRK_HRS" ).append("\n"); 
		query.append("          ,PORT_BUF_HRS" ).append("\n"); 
		query.append("          ,CRE_USR_ID" ).append("\n"); 
		query.append("          ,CRE_DT" ).append("\n"); 
		query.append("          ,UPD_USR_ID" ).append("\n"); 
		query.append("          ,UPD_DT)" ).append("\n"); 
		query.append(" 	SELECT @[vsl_slan_cd]" ).append("\n"); 
		query.append("          ,@[pf_svc_tp_cd]" ).append("\n"); 
		query.append("          ,@[port_cd]" ).append("\n"); 
		query.append("          ,@[skd_dir_cd]" ).append("\n"); 
		query.append("		  ,(" ).append("\n"); 
		query.append("        	SELECT  TO_CHAR(COUNT(VSL_SLAN_CD) + 1) " ).append("\n"); 
		query.append("        	FROM    VSK_BUD_PF_SKD_DTL" ).append("\n"); 
		query.append("        	WHERE   VSL_SLAN_CD     = @[vsl_slan_cd]" ).append("\n"); 
		query.append("        	AND     PF_SVC_TP_CD    = @[pf_svc_tp_cd]" ).append("\n"); 
		query.append("        	AND     SKD_DIR_CD      = @[skd_dir_cd]" ).append("\n"); 
		query.append("        	AND     PORT_CD         = @[port_cd]" ).append("\n"); 
		query.append("    		) AS CLPT_SEQ" ).append("\n"); 
		query.append("          ,@[port_rotn_seq]" ).append("\n"); 
		query.append("          ,@[yd_cd]" ).append("\n"); 
		query.append("		  ,(" ).append("\n"); 
		query.append("        	SELECT  TO_CHAR(COUNT(VSL_SLAN_CD) + 1) " ).append("\n"); 
		query.append("        	FROM    VSK_BUD_PF_SKD_DTL" ).append("\n"); 
		query.append("        	WHERE   VSL_SLAN_CD     = @[vsl_slan_cd]" ).append("\n"); 
		query.append("        	AND     PF_SVC_TP_CD    = @[pf_svc_tp_cd]" ).append("\n"); 
		query.append("        	AND     SKD_DIR_CD      = @[skd_dir_cd]" ).append("\n"); 
		query.append("        	AND     YD_CD           = @[yd_cd]" ).append("\n"); 
		query.append("    		) AS CALL_YD_IND_SEQ" ).append("\n"); 
		query.append("          ,@[turn_port_flg]" ).append("\n"); 
		query.append("          ,@[turn_port_ind_cd]" ).append("\n"); 
		query.append("          ,@[etb_dy_cd]" ).append("\n"); 
		query.append("          ,@[etb_dy_no]" ).append("\n"); 
		query.append("          ,@[etb_tm_hrmnt]" ).append("\n"); 
		query.append("          ,@[etd_dy_cd]" ).append("\n"); 
		query.append("          ,@[etd_dy_no]" ).append("\n"); 
		query.append("          ,@[etd_tm_hrmnt]" ).append("\n"); 
		query.append("          ,@[lnk_dist]" ).append("\n"); 
		query.append("          ,@[lnk_spd]" ).append("\n"); 
		query.append("          ,@[tztm_hrs]" ).append("\n"); 
		query.append("          ,@[sea_buf_hrs]" ).append("\n"); 
		query.append("          ,@[sea_buf_spd]" ).append("\n"); 
		query.append("          ,@[mnvr_in_hrs]" ).append("\n"); 
		query.append("          ,@[mnvr_out_hrs]" ).append("\n"); 
		query.append("          ,@[ib_ipcgo_qty]" ).append("\n"); 
		query.append("          ,@[ib_ocn_cgo_qty]" ).append("\n"); 
		query.append("          ,@[ob_ipcgo_qty]" ).append("\n"); 
		query.append("          ,@[ob_ocn_cgo_qty]" ).append("\n"); 
		query.append("          ,@[tml_prod_qty]" ).append("\n"); 
		query.append("          ,@[crn_knt]" ).append("\n"); 
		query.append("          ,@[act_wrk_hrs]" ).append("\n"); 
		query.append("          ,@[port_buf_hrs]" ).append("\n"); 
		query.append("		  ,@[cre_usr_id]" ).append("\n"); 
		query.append("		  ,SYSDATE" ).append("\n"); 
		query.append("		  ,@[upd_usr_id]" ).append("\n"); 
		query.append("		  ,SYSDATE" ).append("\n"); 
		query.append("		FROM   DUAL" ).append("\n"); 

	}
}
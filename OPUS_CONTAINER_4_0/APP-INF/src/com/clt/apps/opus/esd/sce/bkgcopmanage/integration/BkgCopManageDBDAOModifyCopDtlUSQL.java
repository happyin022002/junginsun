/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgCopManageDBDAOModifyCopDtlUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.27
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2009.10.27 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOModifyCopDtlUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCE_COP_DTL 에 대한 변경업무 담당
	  * </pre>
	  */
	public BkgCopManageDBDAOModifyCopDtlUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("estm_gdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("stnd_edi_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_rcv_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_expt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_sts_mapg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_snd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("act_dat_rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_act_snd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_msg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("act_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("estm_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOModifyCopDtlUSQL").append("\n"); 
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
		query.append("update sce_cop_dtl A" ).append("\n"); 
		query.append("set" ).append("\n"); 
		query.append("A.ACT_CD          = NVL(@[act_cd]			, A.ACT_CD           )," ).append("\n"); 
		query.append("A.PLN_DT          = NVL(TO_DATE(@[pln_dt], 'YYYYMMDDHH24MISS')           , A.PLN_DT           )," ).append("\n"); 
		query.append("A.ESTM_DT         = NVL(TO_DATE(@[estm_dt], 'YYYYMMDDHH24MISS')          , A.ESTM_DT          )," ).append("\n"); 
		query.append("A.ACT_DT          = NVL(TO_DATE(@[act_dt], 'YYYYMMDDHH24MISS')           , A.ACT_DT           )," ).append("\n"); 
		query.append("A.NOD_CD          = NVL(@[nod_cd]           , A.NOD_CD           )," ).append("\n"); 
		query.append("A.ACT_STS_CD      = NVL(@[act_sts_cd]       , A.ACT_STS_CD       )," ).append("\n"); 
		query.append("A.ACT_RCV_TP_CD   = NVL(@[act_rcv_tp_cd]    , A.ACT_RCV_TP_CD    )," ).append("\n"); 
		query.append("A.EDI_SND_TP_CD   = NVL(@[edi_snd_tp_cd]    , A.EDI_SND_TP_CD    )," ).append("\n"); 
		query.append("A.VSL_CD          = NVL(@[vsl_cd]           , A.VSL_CD           )," ).append("\n"); 
		query.append("A.SKD_VOY_NO      = NVL(@[skd_voy_no]       , A.SKD_VOY_NO       )," ).append("\n"); 
		query.append("A.SKD_DIR_CD      = NVL(@[skd_dir_cd]       , A.SKD_DIR_CD       )," ).append("\n"); 
		query.append("A.CLPT_IND_SEQ    = NVL(@[clpt_ind_seq]     , A.CLPT_IND_SEQ     )," ).append("\n"); 
		query.append("A.VPS_PORT_CD     = NVL(@[vps_port_cd]      , A.VPS_PORT_CD      )," ).append("\n"); 
		query.append("A.ESTM_GDT        = NVL(TO_DATE(@[estm_gdt], 'YYYYMMDDHH24MISS')         , A.ESTM_GDT         )," ).append("\n"); 
		query.append("A.VNDR_SEQ        = NVL(@[vndr_seq]         , A.VNDR_SEQ         )," ).append("\n"); 
		query.append("A.EDI_MSG_TP_CD   = NVL(@[edi_msg_tp_cd]    , A.EDI_MSG_TP_CD    )," ).append("\n"); 
		query.append("A.ACT_STS_MAPG_CD = NVL(@[act_sts_mapg_cd]  , A.ACT_STS_MAPG_CD  )," ).append("\n"); 
		query.append("A.STND_EDI_STS_CD = NVL(@[stnd_edi_sts_cd]  , A.STND_EDI_STS_CD  )," ).append("\n"); 
		query.append("A.EDI_ACT_SND_DT  = NVL(TO_DATE(@[edi_act_snd_dt], 'YYYYMMDDHH24MISS')   , A.EDI_ACT_SND_DT   )," ).append("\n"); 
		query.append("A.ACT_DAT_RCV_DT  = NVL(TO_DATE(@[act_dat_rcv_dt], 'YYYYMMDDHH24MISS')   , A.ACT_DAT_RCV_DT   )," ).append("\n"); 
		query.append("A.COP_EXPT_FLG    = NVL(@[cop_expt_flg]     , A.COP_EXPT_FLG     )," ).append("\n"); 
		query.append("A.CRE_USR_ID      = NVL(@[cre_usr_id]       , A.CRE_USR_ID       )," ).append("\n"); 
		query.append("A.CRE_DT          = NVL(TO_DATE(@[cre_dt], 'YYYYMMDDHH24MISS')  , A.CRE_DT           )," ).append("\n"); 
		query.append("A.UPD_USR_ID      = NVL(@[upd_usr_id]       , A.UPD_USR_ID       )," ).append("\n"); 
		query.append("A.UPD_DT          = sysdate" ).append("\n"); 
		query.append("where" ).append("\n"); 
		query.append("cop_no = @[cop_no]" ).append("\n"); 

	}
}
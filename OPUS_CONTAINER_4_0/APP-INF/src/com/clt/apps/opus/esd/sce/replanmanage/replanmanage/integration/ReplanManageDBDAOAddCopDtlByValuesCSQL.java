/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ReplanManageDBDAOAddCopDtlByValuesCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.19
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.01.19 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.replanmanage.replanmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReplanManageDBDAOAddCopDtlByValuesCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * value 를 받아 COP Detail 에 저장한다.
	  * </pre>
	  */
	public ReplanManageDBDAOAddCopDtlByValuesCSQL(){
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
		params.put("cop_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esd.sce.replanmanage.replanmanage.integration").append("\n"); 
		query.append("FileName : ReplanManageDBDAOAddCopDtlByValuesCSQL").append("\n"); 
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
		query.append("--=================SCE_COP_DTL 생성 관련 ===========================" ).append("\n"); 
		query.append("INSERT INTO SCE_COP_DTL (" ).append("\n"); 
		query.append("COP_NO," ).append("\n"); 
		query.append("COP_DTL_SEQ," ).append("\n"); 
		query.append("ACT_CD," ).append("\n"); 
		query.append("PLN_DT," ).append("\n"); 
		query.append("ESTM_DT," ).append("\n"); 
		query.append("ACT_DT," ).append("\n"); 
		query.append("NOD_CD," ).append("\n"); 
		query.append("ACT_STS_CD," ).append("\n"); 
		query.append("ACT_RCV_TP_CD," ).append("\n"); 
		query.append("EDI_SND_TP_CD," ).append("\n"); 
		query.append("VSL_CD," ).append("\n"); 
		query.append("SKD_VOY_NO," ).append("\n"); 
		query.append("SKD_DIR_CD," ).append("\n"); 
		query.append("CLPT_IND_SEQ," ).append("\n"); 
		query.append("VPS_PORT_CD," ).append("\n"); 
		query.append("ESTM_GDT," ).append("\n"); 
		query.append("VNDR_SEQ," ).append("\n"); 
		query.append("EDI_MSG_TP_CD," ).append("\n"); 
		query.append("ACT_STS_MAPG_CD," ).append("\n"); 
		query.append("STND_EDI_STS_CD," ).append("\n"); 
		query.append("EDI_ACT_SND_DT," ).append("\n"); 
		query.append("ACT_DAT_RCV_DT," ).append("\n"); 
		query.append("COP_EXPT_FLG," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("values" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("@[cop_no]," ).append("\n"); 
		query.append("@[cop_dtl_seq]," ).append("\n"); 
		query.append("@[act_cd]," ).append("\n"); 
		query.append("TO_DATE(@[pln_dt], 'YYYYMMDDHH24MISS')," ).append("\n"); 
		query.append("TO_DATE(@[estm_dt], 'YYYYMMDDHH24MISS')," ).append("\n"); 
		query.append("TO_DATE(@[act_dt], 'YYYYMMDDHH24MISS')," ).append("\n"); 
		query.append("@[nod_cd]," ).append("\n"); 
		query.append("@[act_sts_cd]," ).append("\n"); 
		query.append("@[act_rcv_tp_cd]," ).append("\n"); 
		query.append("@[edi_snd_tp_cd]," ).append("\n"); 
		query.append("@[vsl_cd]," ).append("\n"); 
		query.append("@[skd_voy_no]," ).append("\n"); 
		query.append("@[skd_dir_cd]," ).append("\n"); 
		query.append("@[clpt_ind_seq]," ).append("\n"); 
		query.append("@[vps_port_cd]," ).append("\n"); 
		query.append("GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR(@[nod_cd],1,5), TO_DATE(@[estm_dt], 'YYYYMMDDHH24MISS'), 'GMT')," ).append("\n"); 
		query.append("@[vndr_seq]," ).append("\n"); 
		query.append("@[edi_msg_tp_cd]," ).append("\n"); 
		query.append("@[act_sts_mapg_cd]," ).append("\n"); 
		query.append("@[stnd_edi_sts_cd]," ).append("\n"); 
		query.append("TO_DATE(@[edi_act_snd_dt], 'YYYYMMDDHH24MISS')," ).append("\n"); 
		query.append("TO_DATE(@[act_dat_rcv_dt], 'YYYYMMDDHH24MISS')," ).append("\n"); 
		query.append("@[cop_expt_flg]," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("TO_DATE(@[cre_dt], 'YYYYMMDDHH24MISS')," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("TO_DATE(@[upd_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
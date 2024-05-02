/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CopDetailReceiveDBDAOAddSceActRcvIfCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.31
*@LastModifier : 
*@LastVersion : 1.0
* 2013.10.31 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.copdetailreceive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOAddSceActRcvIfCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Actual 정보를 수신한다.(MVMT/VSK/322/Manual/SPP 등)
	  * </pre>
	  */
	public CopDetailReceiveDBDAOAddSceActRcvIfCSQL(){
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
		params.put("act_umch_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rail_dest_n1st_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bnd_vskd_seq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_yr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("act_sts_mapg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_dlay_rsn_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_id_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdt_ext_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cnmv_split_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vps_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_dlay_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.copdetailreceive.integration").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOAddSceActRcvIfCSQL").append("\n"); 
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
		query.append("INSERT INTO SCE_ACT_RCV_IF(" ).append("\n"); 
		query.append("CNTR_NO" ).append("\n"); 
		query.append(",BKG_NO" ).append("\n"); 
		query.append(",ACT_STS_MAPG_CD" ).append("\n"); 
		query.append(",NOD_CD" ).append("\n"); 
		query.append(",ACT_DT" ).append("\n"); 
		query.append(",EDI_MSG_TP_CD" ).append("\n"); 
		query.append(",CRE_TP_CD" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",VNDR_SEQ" ).append("\n"); 
		query.append(",BND_VSKD_SEQ_CD" ).append("\n"); 
		query.append(",ACT_DAT_RCV_DT" ).append("\n"); 
		query.append(",VSL_CD" ).append("\n"); 
		query.append(",SKD_VOY_NO" ).append("\n"); 
		query.append(",SKD_DIR_CD" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",ACT_RCV_DT" ).append("\n"); 
		query.append(",ACT_RCV_NO" ).append("\n"); 
		query.append(",ACT_RCV_TP_CD" ).append("\n"); 
		query.append(",ACT_UMCH_TP_CD" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",VPS_PORT_CD" ).append("\n"); 
		query.append(",CLPT_IND_SEQ" ).append("\n"); 
		query.append(",VSL_DLAY_RSN_CD" ).append("\n"); 
		query.append(",VSL_DLAY_RSN_DESC" ).append("\n"); 
		query.append(",VPS_LOC_CD" ).append("\n"); 
		query.append(",ACT_CD" ).append("\n"); 
		query.append(",RAIL_DEST_N1ST_ETA_DT" ).append("\n"); 
		query.append(",ACT_GDT" ).append("\n"); 
		query.append(",CNMV_YR" ).append("\n"); 
		query.append(",CNMV_ID_NO" ).append("\n"); 
		query.append(",CNMV_SEQ" ).append("\n"); 
		query.append(",CNMV_SPLIT_NO" ).append("\n"); 
		query.append(",CNMV_CYC_NO" ).append("\n"); 
		query.append(",IMDT_EXT_FLG" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("@[cntr_no]" ).append("\n"); 
		query.append(",@[bkg_no]" ).append("\n"); 
		query.append(",DECODE(@[act_rcv_tp_cd],'21','ATA','22','ATB','23','ATD',@[act_sts_mapg_cd])" ).append("\n"); 
		query.append(",@[nod_cd]" ).append("\n"); 
		query.append(",to_date(@[act_dt],'YYYY/MM/DD HH24:MI:SS')" ).append("\n"); 
		query.append(",@[edi_msg_tp_cd]" ).append("\n"); 
		query.append(",@[cre_tp_cd] " ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",@[vndr_seq]" ).append("\n"); 
		query.append(",@[bnd_vskd_seq_cd]" ).append("\n"); 
		query.append("#if(${getActRcvTpCd}=='1')" ).append("\n"); 
		query.append(",to_date(@[act_dat_rcv_dt],'YYYY/MM/DD HH24:MI:SS')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', sysdate, substr(@[nod_cd],1,5))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",@[vsl_cd]" ).append("\n"); 
		query.append(",@[skd_voy_no]" ).append("\n"); 
		query.append(",@[skd_dir_cd]" ).append("\n"); 
		query.append(",sysdate" ).append("\n"); 
		query.append(",to_char(sysdate,'YYYYMMDD')" ).append("\n"); 
		query.append(",sce_act_rcv_if_seq1.nextval" ).append("\n"); 
		query.append(",DECODE(@[act_rcv_tp_cd],'21','2','22','2','23','2',@[act_rcv_tp_cd])" ).append("\n"); 
		query.append(",DECODE(@[act_rcv_tp_cd],'0','99','4',@[act_umch_tp_cd],'00')" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",@[vps_port_cd]" ).append("\n"); 
		query.append(",@[clpt_ind_seq]" ).append("\n"); 
		query.append(",@[vsl_dlay_rsn_cd]" ).append("\n"); 
		query.append(",@[vsl_dlay_rsn_desc]" ).append("\n"); 
		query.append(",@[vps_loc_cd]" ).append("\n"); 
		query.append(",@[act_cd]" ).append("\n"); 
		query.append(",to_date(@[rail_dest_n1st_eta_dt],'YYYY/MM/DD HH24:MI:SS')" ).append("\n"); 
		query.append(",(CASE WHEN SUBSTR(@[nod_cd],1,5) IS NOT NULL" ).append("\n"); 
		query.append("       THEN GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR(@[nod_cd],1,5), to_date(@[act_dt],'YYYY/MM/DD HH24:MI:SS'), 'GMT')" ).append("\n"); 
		query.append("  END)" ).append("\n"); 
		query.append(",@[cnmv_yr]" ).append("\n"); 
		query.append(",@[cnmv_id_no]" ).append("\n"); 
		query.append(",@[cnmv_seq]" ).append("\n"); 
		query.append(",@[cnmv_split_no]" ).append("\n"); 
		query.append(",@[cnmv_cyc_no]" ).append("\n"); 
		query.append(",@[imdt_ext_flg]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CopDetailReceiveDBDAOAddSceCntrStsMsgTgtCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.24
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.06.24 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.copdetailreceive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOAddSceCntrStsMsgTgtCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddSceCntrStsMsgTgt
	  * </pre>
	  */
	public CopDetailReceiveDBDAOAddSceCntrStsMsgTgtCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("act_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("nod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("act_dat_rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.copdetailreceive.integration").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOAddSceCntrStsMsgTgtCSQL").append("\n"); 
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
		query.append("INSERT INTO SCE_CNTR_STS_MSG_TGT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("CNTR_NO" ).append("\n"); 
		query.append(",BKG_NO" ).append("\n"); 
		query.append(",ACT_STS_MAPG_CD" ).append("\n"); 
		query.append(",NOD_CD" ).append("\n"); 
		query.append(",ACT_DT" ).append("\n"); 
		query.append(",EDI_MSG_TP_CD" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
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
		query.append(",COP_EVNT_SEQ" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT @[cntr_no]" ).append("\n"); 
		query.append(",@[bkg_no]" ).append("\n"); 
		query.append(",@[act_sts_mapg_cd]" ).append("\n"); 
		query.append(",@[nod_cd]" ).append("\n"); 
		query.append(",TO_DATE(@[act_dt],'YYYY/MM/DD HH24:MI:SS')" ).append("\n"); 
		query.append(",@[edi_msg_tp_cd]" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",@[bnd_vskd_seq_cd]" ).append("\n"); 
		query.append(",TO_DATE(@[act_dat_rcv_dt],'YYYY/MM/DD HH24:MI:SS')" ).append("\n"); 
		query.append(",@[vsl_cd]" ).append("\n"); 
		query.append(",@[skd_voy_no]" ).append("\n"); 
		query.append(",@[skd_dir_cd]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",TO_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n"); 
		query.append(",SCE_CNTR_STS_MSG_TGT_SEQ1.NEXTVAL" ).append("\n"); 
		query.append(",'1'" ).append("\n"); 
		query.append(",'00'" ).append("\n"); 
		query.append(",0" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append("FROM DUAL D" ).append("\n"); 

	}
}
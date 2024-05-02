/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCMQCProposalDBDAOPriSpMqcVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.09.15 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCMQCProposalDBDAOPriSpMqcVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * pri_sp_mqc update
	  * </pre>
	  */
	public SCMQCProposalDBDAOPriSpMqcVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_cmnc_amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("src_info_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acpt_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_lod_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_prog_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_mqc_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acpt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fnl_mqc_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acpt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("coffr_mqc_qty",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.integration").append("\n"); 
		query.append("FileName : SCMQCProposalDBDAOPriSpMqcVOUSQL").append("\n"); 
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
		query.append("UPDATE PRI_SP_MQC SET" ).append("\n"); 
		query.append("CNTR_LOD_UT_CD  = NVL(@[cntr_lod_ut_cd], CNTR_LOD_UT_CD)" ).append("\n"); 
		query.append(",	PROP_MQC_QTY    = NVL(@[prop_mqc_qty], NVL(PROP_MQC_QTY,0))" ).append("\n"); 
		query.append(",	COFFR_MQC_QTY   = NVL(@[coffr_mqc_qty], NVL(COFFR_MQC_QTY,0))" ).append("\n"); 
		query.append(",	FNL_MQC_QTY     = NVL(@[fnl_mqc_qty], NVL(FNL_MQC_QTY,0))" ).append("\n"); 
		query.append(",	PRC_PROG_STS_CD = NVL(@[prc_prog_sts_cd], PRC_PROG_STS_CD)" ).append("\n"); 
		query.append(",	SRC_INFO_CD     = NVL(@[src_info_cd], SRC_INFO_CD)" ).append("\n"); 
		query.append(",	N1ST_CMNC_AMDT_SEQ    = NVL(@[n1st_cmnc_amdt_seq], N1ST_CMNC_AMDT_SEQ)" ).append("\n"); 
		query.append(",   ACPT_USR_ID     = DECODE(@[acpt_usr_id],'C','','',ACPT_USR_ID,@[acpt_usr_id])" ).append("\n"); 
		query.append(",   ACPT_OFC_CD     = DECODE(@[acpt_ofc_cd],'C','','',ACPT_OFC_CD,@[acpt_ofc_cd])" ).append("\n"); 
		query.append(",   ACPT_DT         = DECODE(@[acpt_dt],'C',NULL,'', ACPT_DT,TO_DATE(@[acpt_dt],'yyyy-MM-dd'))" ).append("\n"); 
		query.append(",    UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",    UPD_DT = sysdate" ).append("\n"); 
		query.append("WHERE    PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 

	}
}
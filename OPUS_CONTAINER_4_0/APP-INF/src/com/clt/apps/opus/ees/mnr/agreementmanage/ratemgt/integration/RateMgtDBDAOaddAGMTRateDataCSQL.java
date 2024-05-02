/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RateMgtDBDAOaddAGMTRateDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RateMgtDBDAOaddAGMTRateDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * add AGMT Rate
	  * </pre>
	  */
	public RateMgtDBDAOaddAGMTRateDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_dtl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_def_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.integration").append("\n"); 
		query.append("FileName : RateMgtDBDAOaddAGMTRateDataCSQL").append("\n"); 
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
		query.append("INSERT INTO MNR_AGMT_RT (" ).append("\n"); 
		query.append("	AGMT_SEQ" ).append("\n"); 
		query.append(",	AGMT_VER_NO" ).append("\n"); 
		query.append(",	COST_CD" ).append("\n"); 
		query.append(",	COST_DTL_CD" ).append("\n"); 
		query.append(",	MNR_RT_TP_CD" ).append("\n"); 
		query.append(",	RPR_QTY" ).append("\n"); 
		query.append(",	AGMT_RT_AMT" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append(",   USR_DEF_RMK" ).append("\n"); 
		query.append(",   YD_CD" ).append("\n"); 
		query.append(",   AGMT_RT_SEQ" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[agmt_seq]" ).append("\n"); 
		query.append(",	@[agmt_ver_no]" ).append("\n"); 
		query.append(",	@[cost_cd]" ).append("\n"); 
		query.append(",	@[cost_dtl_cd]" ).append("\n"); 
		query.append(",	@[mnr_rt_tp_cd]" ).append("\n"); 
		query.append(",	NVL(@[rpr_qty],0)  " ).append("\n"); 
		query.append(",	NVL(@[agmt_rt_amt],0)  " ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append(",   @[usr_def_rmk]" ).append("\n"); 
		query.append(",   @[yd_cd]" ).append("\n"); 
		query.append(",  (SELECT NVL(MAX(AGMT_RT_SEQ), 0)+1" ).append("\n"); 
		query.append("      FROM MNR_AGMT_RT" ).append("\n"); 
		query.append("     WHERE AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("       AND AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("       AND AGMT_VER_NO = @[agmt_ver_no])" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
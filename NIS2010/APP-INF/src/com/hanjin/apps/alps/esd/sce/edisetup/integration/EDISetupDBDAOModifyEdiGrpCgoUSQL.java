/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EDISetupDBDAOModifyEdiGrpCgoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.01
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edisetup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EDISetupDBDAOModifyEdiGrpCgoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyEdiGrpCgo
	  * </pre>
	  */
	public EDISetupDBDAOModifyEdiGrpCgoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_co_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_edi_snd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_EDI_AUTO_SND_FLG",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_EDI_CGO_RMK",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_EDI_STS_SEQ",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_ORG_CONTI_DESC",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_edi_evnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eai_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_edi_stnd_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_edi_cntr_snd_tp_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_ORG_DEST_CNT_DESC",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_edi_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_DEST_CONTI_DESC",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_edi_vsl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_cust_edi_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_DEST_CNT_DESC",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_edi_snd_itval_hr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_STS_SND_TP_CD",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edisetup.integration").append("\n"); 
		query.append("FileName : EDISetupDBDAOModifyEdiGrpCgoUSQL").append("\n"); 
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
		query.append("update   edi_grp_cgo" ).append("\n"); 
		query.append("set      EDI_EVNT_CD            = @[e_edi_evnt_cd]" ).append("\n"); 
		query.append(",CUST_EDI_STS_CD        = @[e_cust_edi_sts_cd]" ).append("\n"); 
		query.append(",edi_snd_flg            = @[e_edi_snd_flg]" ).append("\n"); 
		query.append(",edi_vsl_tp_cd          = @[e_edi_vsl_tp_cd]" ).append("\n"); 
		query.append(",eai_evnt_dt            = to_date(@[eai_date],'yyyy/mm/dd hh24:mi:ss')" ).append("\n"); 
		query.append(",EDI_SND_ITVAL_HRMNT    = @[e_edi_snd_itval_hr]" ).append("\n"); 
		query.append(",EDI_CNTR_SND_TP_CD     = @[e_edi_cntr_snd_tp_flg]" ).append("\n"); 
		query.append(",ORG_CONTI_DESC         = @[e_ORG_CONTI_DESC]" ).append("\n"); 
		query.append(",ORG_DEST_CNT_DESC      = @[e_ORG_DEST_CNT_DESC]" ).append("\n"); 
		query.append(",DEST_CONTI_DESC        = @[e_DEST_CONTI_DESC]" ).append("\n"); 
		query.append(",DEST_CNT_DESC          = @[e_DEST_CNT_DESC]" ).append("\n"); 
		query.append(",EDI_CGO_RMK            = @[e_EDI_CGO_RMK]" ).append("\n"); 
		query.append(",EDI_AUTO_SND_FLG       = @[e_EDI_AUTO_SND_FLG]" ).append("\n"); 
		query.append(",STS_SND_TP_CD          = @[e_STS_SND_TP_CD]" ).append("\n"); 
		query.append("where   edi_grp_cd      = @[e_edi_grp_cd]" ).append("\n"); 
		query.append("and     co_div_cd       = @[e_co_div_cd]" ).append("\n"); 
		query.append("and     edi_stnd_sts_cd = @[e_edi_stnd_sts_cd]" ).append("\n"); 
		query.append("and     EDI_STS_SEQ     = @[e_EDI_STS_SEQ]" ).append("\n"); 
		query.append("and (" ).append("\n"); 
		query.append("eai_evnt_dt < to_date(@[eai_date],'yyyy/mm/dd hh24:mi:ss')" ).append("\n"); 
		query.append("or" ).append("\n"); 
		query.append("eai_evnt_dt is null" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
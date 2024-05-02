/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EmptyReleaseRedeliveryOrderMgtDBDAOManageSTKSendFaxEmailUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyReleaseRedeliveryOrderMgtDBDAOManageSTKSendFaxEmailUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public EmptyReleaseRedeliveryOrderMgtDBDAOManageSTKSendFaxEmailUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("issue_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("type_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fax_snd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_inst",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("empty_cy",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("email",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("job_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_snd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pd_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.integration").append("\n"); 
		query.append("FileName : EmptyReleaseRedeliveryOrderMgtDBDAOManageSTKSendFaxEmailUSQL").append("\n"); 
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
		query.append("UPDATE CIM_CNTR_STK" ).append("\n"); 
		query.append("   SET STK_ISS_CD = CASE WHEN @[issue_type] = 'D' OR STK_ISS_CD    = 'D'  THEN 'D' " ).append("\n"); 
		query.append("						 WHEN @[issue_type] = 'E' OR STK_ISS_CD    = 'E'  THEN 'E' " ).append("\n"); 
		query.append("                         WHEN @[issue_type] = 'F' OR STK_ISS_CD    = 'F'  THEN 'F'	" ).append("\n"); 
		query.append("					END," ).append("\n"); 
		query.append("       STK_FAX_NO = NVL(@[fax_no], STK_FAX_NO)," ).append("\n"); 
		query.append("       STK_EML = NVL(@[email], STK_EML)," ).append("\n"); 
		query.append("       STK_JB_DT = TO_DATE (@[pd_date], 'YYYY-MM-DD')," ).append("\n"); 
		query.append("       STK_RMK = REPLACE (@[spcl_inst], '^#^', CHR(39))," ).append("\n"); 
		query.append("       STK_OFC_CD = @[user_ofc]," ).append("\n"); 
		query.append("       STK_EVNT_DT = TO_DATE (TO_CHAR (GLOBALDATE_PKG.TIME_CONV_FNC (COM_CONSTANTMGR_PKG.COM_GETBASELOCATIONCODE_FNC(), SYSDATE, GLOBALDATE_PKG.GET_LOCCD_FNC(@[user_ofc])), 'YYYY-MM-DD HH24:MI'), 'YYYY-MM-DD HH24:MI')," ).append("\n"); 
		query.append("       CNTR_STK_JB_CD = 'MT'," ).append("\n"); 
		query.append("       STK_JB_SEQ = DECODE (@[issue_type], 'P', 0, @[job_seq])," ).append("\n"); 
		query.append("       FAX_SND_NO = NVL(@[fax_snd_no], FAX_SND_NO)," ).append("\n"); 
		query.append("	   EML_SND_NO = NVL(@[eml_snd_no], EML_SND_NO)," ).append("\n"); 
		query.append("       UPD_LOCL_DT = GLOBALDATE_PKG.TIME_LOCAL_FNC(SUBSTR (@[empty_cy], 0, 5 ))," ).append("\n"); 
		query.append("       UPD_USR_ID = @[user_id]," ).append("\n"); 
		query.append("       UPD_DT = SYSDATE" ).append("\n"); 
		query.append(" WHERE STK_LOC_CD = SUBSTR (@[empty_cy], 1, 5)" ).append("\n"); 
		query.append("   AND STK_YD_CD = @[empty_cy]" ).append("\n"); 
		query.append("#if (${type} == 'RLS')" ).append("\n"); 
		query.append("   AND STK_GATE_IO_CD = 'O'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND STK_GATE_IO_CD = 'I'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND SO_OFC_CTY_CD = @[so_ofc_cty_cd]" ).append("\n"); 
		query.append("   AND SO_SEQ = @[so_seq]" ).append("\n"); 
		query.append("   AND TRSP_SO_TP_CD = @[type_cd]" ).append("\n"); 

	}
}
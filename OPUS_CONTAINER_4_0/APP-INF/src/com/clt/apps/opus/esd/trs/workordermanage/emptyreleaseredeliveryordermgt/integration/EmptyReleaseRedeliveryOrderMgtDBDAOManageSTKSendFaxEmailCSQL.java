/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EmptyReleaseRedeliveryOrderMgtDBDAOManageSTKSendFaxEmailCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.08
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.08 
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

public class EmptyReleaseRedeliveryOrderMgtDBDAOManageSTKSendFaxEmailCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public EmptyReleaseRedeliveryOrderMgtDBDAOManageSTKSendFaxEmailCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("send_key",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tp",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("type_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mode_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.integration").append("\n"); 
		query.append("FileName : EmptyReleaseRedeliveryOrderMgtDBDAOManageSTKSendFaxEmailCSQL").append("\n"); 
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
		query.append("INSERT INTO CIM_CNTR_STK" ).append("\n"); 
		query.append("            (STK_LOC_CD," ).append("\n"); 
		query.append("             STK_YD_CD," ).append("\n"); 
		query.append("             STK_GATE_IO_CD," ).append("\n"); 
		query.append("             SO_OFC_CTY_CD," ).append("\n"); 
		query.append("             SO_SEQ," ).append("\n"); 
		query.append("             TRSP_SO_TP_CD," ).append("\n"); 
		query.append("             TRSP_CRR_MOD_CD," ).append("\n"); 
		query.append("             CNTR_TPSZ_CD," ).append("\n"); 
		query.append("             CNTR_NO," ).append("\n"); 
		query.append("             BKG_NO," ).append("\n"); 
		query.append("             BL_NO," ).append("\n"); 
		query.append("             IO_BND_CD," ).append("\n"); 
		query.append("             POL_CD," ).append("\n"); 
		query.append("             POD_CD," ).append("\n"); 
		query.append("             VSL_CD," ).append("\n"); 
		query.append("             SKD_VOY_NO," ).append("\n"); 
		query.append("             SKD_DIR_CD," ).append("\n"); 
		query.append("             STK_ISS_CD," ).append("\n"); 
		query.append("             STK_FAX_NO," ).append("\n"); 
		query.append("             STK_EML," ).append("\n"); 
		query.append("             STK_JB_DT," ).append("\n"); 
		query.append("             STK_RMK," ).append("\n"); 
		query.append("             STK_OFC_CD," ).append("\n"); 
		query.append("             STK_EVNT_DT," ).append("\n"); 
		query.append("             CNTR_STK_JB_CD," ).append("\n"); 
		query.append("             STK_JB_SEQ," ).append("\n"); 
		query.append("             CRE_LOCL_DT," ).append("\n"); 
		query.append("             UPD_LOCL_DT," ).append("\n"); 
		query.append("             CRE_USR_ID," ).append("\n"); 
		query.append("             CRE_DT," ).append("\n"); 
		query.append("             UPD_USR_ID," ).append("\n"); 
		query.append("             UPD_DT," ).append("\n"); 
		query.append("             FAX_SND_NO" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("     VALUES (SUBSTR (@[empty_cy], 1, 5)," ).append("\n"); 
		query.append("             @[empty_cy]," ).append("\n"); 
		query.append("			 DECODE(@[type], 'RLS', 'O', 'I')," ).append("\n"); 
		query.append("             @[so_ofc_cty_cd]," ).append("\n"); 
		query.append("             @[so_seq]," ).append("\n"); 
		query.append("             @[type_cd]," ).append("\n"); 
		query.append("             @[mode_cd]," ).append("\n"); 
		query.append("             @[tp]," ).append("\n"); 
		query.append("			 DECODE(@[type], 'RLS', @[eq_no], @[cntr_no])," ).append("\n"); 
		query.append("#if (${type_cd} == 'C' || ${type_cd} == 'M')" ).append("\n"); 
		query.append("             @[bkg_no]," ).append("\n"); 
		query.append("             @[bl_no]," ).append("\n"); 
		query.append("             @[bd]," ).append("\n"); 
		query.append("             @[pol]," ).append("\n"); 
		query.append("             @[pod]," ).append("\n"); 
		query.append("             SUBSTR (@[vvd], 1, 4)," ).append("\n"); 
		query.append("             SUBSTR (@[vvd], 5, 4)," ).append("\n"); 
		query.append("             SUBSTR (@[vvd], 9, 1)," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("             ''," ).append("\n"); 
		query.append("             ''," ).append("\n"); 
		query.append("             ''," ).append("\n"); 
		query.append("             ''," ).append("\n"); 
		query.append("             ''," ).append("\n"); 
		query.append("             ''," ).append("\n"); 
		query.append("             ''," ).append("\n"); 
		query.append("             ''," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("             @[issue_type]," ).append("\n"); 
		query.append("             @[fax_no]," ).append("\n"); 
		query.append("             @[email]," ).append("\n"); 
		query.append("             TO_DATE (@[pd_date], 'YYYY-MM-DD')," ).append("\n"); 
		query.append("             REPLACE (@[spcl_inst], '^#^', CHR(39))," ).append("\n"); 
		query.append("             @[user_ofc]," ).append("\n"); 
		query.append("             TO_DATE (TO_CHAR (GLOBALDATE_PKG.TIME_CONV_FNC (COM_CONSTANTMGR_PKG.COM_GETBASELOCATIONCODE_FNC(), SYSDATE, GLOBALDATE_PKG.GET_LOCCD_FNC(@[user_ofc])), 'YYYY-MM-DD HH24:MI'), 'YYYY-MM-DD HH24:MI')," ).append("\n"); 
		query.append("             'MT'," ).append("\n"); 
		query.append("             @[job_seq]," ).append("\n"); 
		query.append("             GLOBALDATE_PKG.TIME_LOCAL_FNC(SUBSTR (@[empty_cy], 0, 5 ))," ).append("\n"); 
		query.append("             GLOBALDATE_PKG.TIME_LOCAL_FNC(SUBSTR (@[empty_cy], 0, 5 ))," ).append("\n"); 
		query.append("             @[user_id]," ).append("\n"); 
		query.append("             SYSDATE," ).append("\n"); 
		query.append("             @[user_id]," ).append("\n"); 
		query.append("             SYSDATE," ).append("\n"); 
		query.append("             @[send_key]" ).append("\n"); 
		query.append("            )" ).append("\n"); 

	}
}
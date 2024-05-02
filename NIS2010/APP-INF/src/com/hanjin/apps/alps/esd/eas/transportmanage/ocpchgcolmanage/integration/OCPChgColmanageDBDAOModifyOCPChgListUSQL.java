/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : OCPChgColmanageDBDAOModifyOCPChgListUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.12
*@LastModifier : 이정수
*@LastVersion : 1.0
* 2011.04.12 이정수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.transportmanage.ocpchgcolmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Jeong Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OCPChgColmanageDBDAOModifyOCPChgListUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyOCPChgList
	  * </pre>
	  */
	public OCPChgColmanageDBDAOModifyOCPChgListUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rmk_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.transportmanage.ocpchgcolmanage.integration").append("\n"); 
		query.append("FileName : OCPChgColmanageDBDAOModifyOCPChgListUSQL").append("\n"); 
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
		query.append("MERGE INTO  TRS_EXPN_AUD_CNTR_RMK " ).append("\n"); 
		query.append("USING   DUAL" ).append("\n"); 
		query.append("   ON" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("                BKG_NO			= @[bkg_no]" ).append("\n"); 
		query.append("            AND CNTR_NO 		= @[cntr_no]" ).append("\n"); 
		query.append("            AND	EAS_EXPN_TP_CD	= 'OC'" ).append("\n"); 
		query.append("            AND	RMK_CTNT_SEQ	= '1'" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("   WHEN MATCHED THEN" ).append("\n"); 
		query.append("        UPDATE  " ).append("\n"); 
		query.append("           SET" ).append("\n"); 
		query.append("                RMK_CTNT		= @[rmk_ctnt]," ).append("\n"); 
		query.append("                UPD_USR_ID		= @[upd_usr_id]," ).append("\n"); 
		query.append("                UPD_DT 			= GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd])" ).append("\n"); 
		query.append("   WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("        INSERT (" ).append("\n"); 
		query.append("                    BKG_NO," ).append("\n"); 
		query.append("                    CNTR_NO," ).append("\n"); 
		query.append("                    EAS_EXPN_TP_CD," ).append("\n"); 
		query.append("                    RMK_CTNT_SEQ," ).append("\n"); 
		query.append("                    RMK_CTNT," ).append("\n"); 
		query.append("                    CRE_OFC_CD," ).append("\n"); 
		query.append("                    CRE_DT," ).append("\n"); 
		query.append("                    UPD_DT," ).append("\n"); 
		query.append("                    CRE_USR_ID," ).append("\n"); 
		query.append("                    UPD_USR_ID" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("        VALUES  (" ).append("\n"); 
		query.append("                    @[bkg_no]," ).append("\n"); 
		query.append("                    @[cntr_no]," ).append("\n"); 
		query.append("                    'OC'," ).append("\n"); 
		query.append("                    '1'," ).append("\n"); 
		query.append("                    @[rmk_ctnt]," ).append("\n"); 
		query.append("                    @[cre_ofc_cd]," ).append("\n"); 
		query.append("                    GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd])," ).append("\n"); 
		query.append("                    GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd])," ).append("\n"); 
		query.append("                    @[upd_usr_id]," ).append("\n"); 
		query.append("                    @[upd_usr_id]" ).append("\n"); 
		query.append("                 )" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChinaCustomsTransmissionDBDAOaddSendLogBlCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaCustomsTransmissionDBDAOaddSendLogBlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public ChinaCustomsTransmissionDBDAOaddSendLogBlCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_ref_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trans_mode",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.integration").append("\n"); 
		query.append("FileName : ChinaCustomsTransmissionDBDAOaddSendLogBlCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_CHN_SND_LOG_BL" ).append("\n"); 
		query.append("       (EDI_REF_ID," ).append("\n"); 
		query.append("        BL_NO," ).append("\n"); 
		query.append("        BKG_POL_CD," ).append("\n"); 
		query.append("        BKG_POD_CD," ).append("\n"); 
		query.append("        CRE_USR_ID," ).append("\n"); 
		query.append("        CRE_DT," ).append("\n"); 
		query.append("        UPD_USR_ID," ).append("\n"); 
		query.append("        UPD_DT)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("VALUES (@[edi_ref_id]," ).append("\n"); 
		query.append("        @[bl_no]," ).append("\n"); 
		query.append("        (SELECT BKG_POL_CD" ).append("\n"); 
		query.append("           FROM BKG_CSTMS_CHN_BL" ).append("\n"); 
		query.append("          WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("            AND CHN_MF_SND_IND_CD = @[trans_mode])," ).append("\n"); 
		query.append("        (SELECT BKG_POD_CD" ).append("\n"); 
		query.append("           FROM BKG_CSTMS_CHN_BL" ).append("\n"); 
		query.append("          WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("            AND CHN_MF_SND_IND_CD = @[trans_mode])," ).append("\n"); 
		query.append("        @[cre_usr_id]," ).append("\n"); 
		query.append("        SYSDATE," ).append("\n"); 
		query.append("        @[upd_usr_id]," ).append("\n"); 
		query.append("        SYSDATE)" ).append("\n"); 

	}
}
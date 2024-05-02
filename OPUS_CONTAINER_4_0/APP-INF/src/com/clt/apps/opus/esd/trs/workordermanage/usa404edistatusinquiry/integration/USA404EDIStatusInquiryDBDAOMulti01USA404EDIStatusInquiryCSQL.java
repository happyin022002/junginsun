/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : USA404EDIStatusInquiryDBDAOMulti01USA404EDIStatusInquiryCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.09
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2011.03.09 최 선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sun, Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USA404EDIStatusInquiryDBDAOMulti01USA404EDIStatusInquiryCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * multi01USA404EDIStatusInquiry INSERT
	  * </pre>
	  */
	public USA404EDIStatusInquiryDBDAOMulti01USA404EDIStatusInquiryCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlt_trkr_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shpr_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlt_trkr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shpr_cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlt_trkr_fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlt_trkr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shpr_fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration").append("\n"); 
		query.append("FileName : USA404EDIStatusInquiryDBDAOMulti01USA404EDIStatusInquiryCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_TRSP_CFM_MSG_HIS (" ).append("\n"); 
		query.append("TRSP_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("TRSP_SO_SEQ," ).append("\n"); 
		query.append("SND_SEQ," ).append("\n"); 
		query.append("EQ_NO," ).append("\n"); 
		query.append("MSG_TP_CD," ).append("\n"); 
		query.append("SND_TP_CD," ).append("\n"); 
		query.append("EQ_TPSZ_CD," ).append("\n"); 
		query.append("RLT_TRKR_SEQ," ).append("\n"); 
		query.append("RLT_TRKR_NM," ).append("\n"); 
		query.append("RLT_TRKR_FAX_NO," ).append("\n"); 
		query.append("RLT_TRKR_EML," ).append("\n"); 
		query.append("SHPR_CUST_NM," ).append("\n"); 
		query.append("SHPR_FAX_NO," ).append("\n"); 
		query.append("SHPR_EML," ).append("\n"); 
		query.append("SND_DT," ).append("\n"); 
		query.append("SND_OFC_CD," ).append("\n"); 
		query.append("SND_USR_ID," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT," ).append("\n"); 
		query.append("LOCL_CRE_DT," ).append("\n"); 
		query.append("LOCL_UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("@[trsp_so_ofc_cty_cd]," ).append("\n"); 
		query.append("@[trsp_so_seq]," ).append("\n"); 
		query.append("TRS_SND_SEQ1.NEXTVAL," ).append("\n"); 
		query.append("@[eq_no]," ).append("\n"); 
		query.append("'C'," ).append("\n"); 
		query.append("'M'," ).append("\n"); 
		query.append("@[eq_tpsz_cd]," ).append("\n"); 
		query.append("@[rlt_trkr_seq]," ).append("\n"); 
		query.append("@[rlt_trkr_nm]," ).append("\n"); 
		query.append("@[rlt_trkr_fax_no]," ).append("\n"); 
		query.append("@[rlt_trkr_eml]," ).append("\n"); 
		query.append("@[shpr_cust_nm]," ).append("\n"); 
		query.append("@[shpr_fax_no]," ).append("\n"); 
		query.append("@[shpr_eml]," ).append("\n"); 
		query.append("GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[snd_ofc_cd])," ).append("\n"); 
		query.append("@[snd_ofc_cd]," ).append("\n"); 
		query.append("@[snd_usr_id]," ).append("\n"); 
		query.append("@[snd_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[snd_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[snd_ofc_cd])," ).append("\n"); 
		query.append("GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[snd_ofc_cd])" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
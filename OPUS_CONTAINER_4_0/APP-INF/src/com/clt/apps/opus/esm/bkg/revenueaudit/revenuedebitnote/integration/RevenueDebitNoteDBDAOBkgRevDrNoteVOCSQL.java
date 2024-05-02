/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RevenueDebitNoteDBDAOBkgRevDrNoteVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.28
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2010.09.28 김태경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RevenueDebitNoteDBDAOBkgRevDrNoteVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public RevenueDebitNoteDBDAOBkgRevDrNoteVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_corr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rdn_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("respb_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_aud_tool_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rdn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("umch_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("umch_sub_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("umch_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rdn_iss_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("respb_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rct_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rvis_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.integration").append("\n"); 
		query.append("FileName : RevenueDebitNoteDBDAOBkgRevDrNoteVOCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_REV_DR_NOTE (" ).append("\n"); 
		query.append("	RDN_NO" ).append("\n"); 
		query.append(",	RVIS_SEQ" ).append("\n"); 
		query.append(",	BKG_NO" ).append("\n"); 
		query.append(",	ISS_OFC_CD" ).append("\n"); 
		query.append(",	RCT_RHQ_CD" ).append("\n"); 
		query.append(",	RCT_OFC_CD" ).append("\n"); 
		query.append(",	RESPB_OFC_CD" ).append("\n"); 
		query.append(",	UMCH_TP_CD" ).append("\n"); 
		query.append(",	UMCH_SUB_TP_CD" ).append("\n"); 
		query.append(",	RDN_ISS_RSN_CD" ).append("\n"); 
		query.append(",	UMCH_RMK" ).append("\n"); 
		query.append(",	BKG_CORR_NO" ).append("\n"); 
		query.append(",	RDN_STS_CD" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	RDN_ISS_DT" ).append("\n"); 
		query.append(",	RESPB_RHQ_CD" ).append("\n"); 
		query.append(",	REV_AUD_TOOL_CD" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[rdn_no]" ).append("\n"); 
		query.append(",	@[rvis_seq]" ).append("\n"); 
		query.append(",	@[bkg_no]" ).append("\n"); 
		query.append(",	DECODE(NVL(@[iss_ofc_cd],''),'',' ',@[iss_ofc_cd])" ).append("\n"); 
		query.append(",	@[rct_rhq_cd]" ).append("\n"); 
		query.append(",	@[rct_ofc_cd]" ).append("\n"); 
		query.append(",	@[respb_ofc_cd]" ).append("\n"); 
		query.append(",	DECODE(NVL(@[umch_tp_cd],''),'','R',@[umch_tp_cd])" ).append("\n"); 
		query.append(",	@[umch_sub_tp_cd]" ).append("\n"); 
		query.append(",	@[rdn_iss_rsn_cd]" ).append("\n"); 
		query.append(",	@[umch_rmk]" ).append("\n"); 
		query.append(",	@[bkg_corr_no]" ).append("\n"); 
		query.append(",	@[rdn_sts_cd]" ).append("\n"); 
		query.append("#if (${rdn_sts_cd} == 'RV')" ).append("\n"); 
		query.append("	,(SELECT CRE_USR_ID FROM BKG_REV_DR_NOTE" ).append("\n"); 
		query.append("	 WHERE RDN_NO = @[rdn_no]" ).append("\n"); 
		query.append("	   AND RVIS_SEQ = '1'" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	NVL(( SELECT RDN_ISS_DT FROM BKG_REV_DR_NOTE  WHERE RDN_NO = @[rdn_no] AND RVIS_SEQ = 1 ), SYSDATE)" ).append("\n"); 
		query.append(",	@[respb_rhq_cd]" ).append("\n"); 
		query.append(",	@[rev_aud_tool_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
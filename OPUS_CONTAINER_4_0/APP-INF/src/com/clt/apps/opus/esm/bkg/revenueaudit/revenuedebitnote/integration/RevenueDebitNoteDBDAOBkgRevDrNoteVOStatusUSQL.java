/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RevenueDebitNoteDBDAOBkgRevDrNoteVOStatusUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.20
*@LastModifier : 류선우
*@LastVersion : 1.0
* 2010.04.20 류선우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Sun Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RevenueDebitNoteDBDAOBkgRevDrNoteVOStatusUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * rdn 상태 값을 변경
	  * </pre>
	  */
	public RevenueDebitNoteDBDAOBkgRevDrNoteVOStatusUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("rdn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
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
		params.put("umch_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.integration").append("\n"); 
		query.append("FileName : RevenueDebitNoteDBDAOBkgRevDrNoteVOStatusUSQL").append("\n"); 
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
		query.append("UPDATE	BKG_REV_DR_NOTE" ).append("\n"); 
		query.append("SET " ).append("\n"); 
		query.append("	RDN_STS_CD		= @[rdn_sts_cd]" ).append("\n"); 
		query.append(",	UPD_DT			= SYSDATE" ).append("\n"); 
		query.append("#if (${bkg_corr_no} != '') " ).append("\n"); 
		query.append(",	BKG_CORR_NO		= @[bkg_corr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rdn_sts_cd} == 'CL' || ${rdn_sts_cd} == 'ST')" ).append("\n"); 
		query.append(",	UMCH_TP_CD		= @[umch_tp_cd]" ).append("\n"); 
		query.append(",	UMCH_SUB_TP_CD	= @[umch_sub_tp_cd]" ).append("\n"); 
		query.append(",	RDN_ISS_RSN_CD	= @[rdn_iss_rsn_cd]" ).append("\n"); 
		query.append(",	UMCH_RMK		= @[umch_rmk]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE	RDN_NO		= @[rdn_no]" ).append("\n"); 
		query.append("AND		RVIS_SEQ	= @[rvis_seq]" ).append("\n"); 

	}
}
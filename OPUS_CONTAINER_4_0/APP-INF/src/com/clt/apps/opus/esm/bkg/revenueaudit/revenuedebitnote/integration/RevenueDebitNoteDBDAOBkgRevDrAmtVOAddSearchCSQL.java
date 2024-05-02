/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : RevenueDebitNoteDBDAOBkgRevDrAmtVOAddSearchCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.18
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RevenueDebitNoteDBDAOBkgRevDrAmtVOAddSearchCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * amt 의 최근값을 조회하여 신규로 등록
	  * </pre>
	  */
	public RevenueDebitNoteDBDAOBkgRevDrAmtVOAddSearchCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("rdn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.integration").append("\n"); 
		query.append("FileName : RevenueDebitNoteDBDAOBkgRevDrAmtVOAddSearchCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_REV_DR_AMT (" ).append("\n"); 
		query.append("	RDN_NO" ).append("\n"); 
		query.append(",	RVIS_SEQ" ).append("\n"); 
		query.append(",	CURR_CD" ).append("\n"); 
		query.append(",	DR_AMT" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("	RDN_NO" ).append("\n"); 
		query.append(",	(RVIS_SEQ+1) AS RVIS_SEQ" ).append("\n"); 
		query.append(",	CURR_CD" ).append("\n"); 
		query.append(",	DR_AMT" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append("FROM  BKG_REV_DR_AMT" ).append("\n"); 
		query.append("WHERE RDN_NO = @[rdn_no]" ).append("\n"); 
		query.append("AND	  RVIS_SEQ = (SELECT MAX(RVIS_SEQ)" ).append("\n"); 
		query.append("					FROM BKG_REV_DR_AMT" ).append("\n"); 
		query.append("				   WHERE RDN_NO = @[rdn_no])" ).append("\n"); 

	}
}
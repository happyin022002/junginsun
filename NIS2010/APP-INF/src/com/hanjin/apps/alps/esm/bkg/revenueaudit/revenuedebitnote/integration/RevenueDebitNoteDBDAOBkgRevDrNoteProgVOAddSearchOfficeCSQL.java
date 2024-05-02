/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RevenueDebitNoteDBDAOBkgRevDrNoteProgVOAddSearch2CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.06.09 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seung Jun Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RevenueDebitNoteDBDAOBkgRevDrNoteProgVOAddSearchOfficeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * prog_seq 증가하여 복사
	  * </pre>
	  */
	public RevenueDebitNoteDBDAOBkgRevDrNoteProgVOAddSearchOfficeCSQL(){
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
		params.put("rdn_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rdn_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("INSERT INTO BKG_REV_DR_NOTE_PROG (" ).append("\n"); 
		query.append("RDN_NO" ).append("\n"); 
		query.append(",	RVIS_SEQ" ).append("\n"); 
		query.append(",	PROG_SEQ" ).append("\n"); 
		query.append(",	RDN_STS_CD" ).append("\n"); 
		query.append(",	RDN_RMK" ).append("\n"); 
		query.append(",	CRE_OFC_CD" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("RDN_NO" ).append("\n"); 
		query.append(",	RVIS_SEQ AS RVIS_SEQ" ).append("\n"); 
		query.append(",	(PROG_SEQ+1) AS PROG_SEQ" ).append("\n"); 
		query.append(",	@[rdn_sts_cd]" ).append("\n"); 
		query.append(",	@[rdn_rmk]" ).append("\n"); 
		query.append(",	CRE_OFC_CD" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append("FROM  BKG_REV_DR_NOTE_PROG" ).append("\n"); 
		query.append("WHERE RDN_NO = @[rdn_no]" ).append("\n"); 
		query.append("AND	  RVIS_SEQ = @[rvis_seq]" ).append("\n"); 
		query.append("AND	  PROG_SEQ = (SELECT MAX(PROG_SEQ)" ).append("\n"); 
		query.append("FROM BKG_REV_DR_NOTE_PROG" ).append("\n"); 
		query.append("WHERE RDN_NO = @[rdn_no]" ).append("\n"); 
		query.append("AND RVIS_SEQ = @[rvis_seq])" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.esm.bkg.revenueaudit.revenuedebitnote.integration").append("\n"); 
		query.append("FileName : RevenueDebitNoteDBDAOBkgRevDrNoteProgVOAddSearch2CSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}
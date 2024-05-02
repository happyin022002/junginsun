/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PartnerMgtDBDAOsearchDisposalPartnerContactDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.partnermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerMgtDBDAOsearchDisposalPartnerContactDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchDisposalPartnerContactData
	  * </pre>
	  */
	public PartnerMgtDBDAOsearchDisposalPartnerContactDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_prnr_cre_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.generalmanage.partnermgt.integration").append("\n"); 
		query.append("FileName : PartnerMgtDBDAOsearchDisposalPartnerContactDataRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("A.MNR_PRNR_CRE_SEQ" ).append("\n"); 
		query.append(",A.MNR_PRNR_CRE_DTL_SEQ" ).append("\n"); 
		query.append(",A.CNT_CD" ).append("\n"); 
		query.append(",A.OFC_CD" ).append("\n"); 
		query.append(",A.MNR_CNTC_PRNR_NM" ).append("\n"); 
		query.append(",A.INTL_PHN_NO" ).append("\n"); 
		query.append(",A.PHN_NO" ).append("\n"); 
		query.append(",A.INTL_FAX_NO" ).append("\n"); 
		query.append(",A.FAX_NO" ).append("\n"); 
		query.append(",A.MNR_PRNR_EML" ).append("\n"); 
		query.append(",A.PRMRY_CHK_FLG" ).append("\n"); 
		query.append(",A.CNTC_DIV_CD" ).append("\n"); 
		query.append(",A.MNR_PRNR_ADDR" ).append("\n"); 
		query.append(",A.MNR_PRNR_RMK" ).append("\n"); 
		query.append(",DECODE(A.APLY_FLG,'Y','1','0') AS APLY_FLG" ).append("\n"); 
		query.append(",A.CRE_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(A.CRE_DT, 'yyyy-mm-dd') CRE_DT" ).append("\n"); 
		query.append(",A.UPD_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(A.UPD_DT, 'yyyy-mm-dd') UPD_DT" ).append("\n"); 
		query.append("FROM MNR_PRNR_CNTC_PNT A" ).append("\n"); 
		query.append("WHERE A.MNR_PRNR_CRE_SEQ = @[mnr_prnr_cre_seq]" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PickUpNoticeDBDAOmergePkupNtcDtlByEmailUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.22
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.12.22 박미옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Mi Ok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PickUpNoticeDBDAOmergePkupNtcDtlByEmailUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PickUp Notice  수화주 정보를 수정 한다. - Fax
	  * </pre>
	  */
	public PickUpNoticeDBDAOmergePkupNtcDtlByEmailUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_snd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_eml",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cntc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : PickUpNoticeDBDAOmergePkupNtcDtlByEmailUSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_PKUP_NTC_DTL A" ).append("\n"); 
		query.append("USING (SELECT" ).append("\n"); 
		query.append("@[bkg_no] AS BKG_NO" ).append("\n"); 
		query.append(",@[ntc_seq] AS NTC_SEQ" ).append("\n"); 
		query.append(",@[cust_cntc_tp_cd] AS CUST_CNTC_TP_CD" ).append("\n"); 
		query.append(",@[ntc_eml] AS NTC_EML" ).append("\n"); 
		query.append(",@[eml_snd_usr_id] AS EML_SND_USR_ID" ).append("\n"); 
		query.append(",@[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append(",@[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("FROM   DUAL" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("ON (A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND	A.NTC_SEQ = B.NTC_SEQ" ).append("\n"); 
		query.append("AND	A.CUST_CNTC_TP_CD = B.CUST_CNTC_TP_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UPDATE SET" ).append("\n"); 
		query.append("NTC_EML        = B.NTC_EML" ).append("\n"); 
		query.append(",	EML_TP_CD      = 'M'" ).append("\n"); 
		query.append(",	EML_SND_DT     = NULL" ).append("\n"); 
		query.append(",	EML_SND_GDT    = NULL" ).append("\n"); 
		query.append(",	EML_SND_USR_ID = B.EML_SND_USR_ID" ).append("\n"); 
		query.append(",	UPD_USR_ID     = B.UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT         = SYSDATE" ).append("\n"); 
		query.append("WHERE B.NTC_EML IS NOT NULL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("INSERT" ).append("\n"); 
		query.append("(BKG_NO" ).append("\n"); 
		query.append(",NTC_SEQ" ).append("\n"); 
		query.append(",CUST_CNTC_TP_CD" ).append("\n"); 
		query.append(",FAX_NO" ).append("\n"); 
		query.append(",FAX_TP_CD" ).append("\n"); 
		query.append(",FAX_SND_DT" ).append("\n"); 
		query.append(",FAX_SND_GDT" ).append("\n"); 
		query.append(",FAX_SND_USR_ID" ).append("\n"); 
		query.append(",FAX_NTC_SND_ID" ).append("\n"); 
		query.append(",FAX_NTC_SND_RSLT_CD" ).append("\n"); 
		query.append(",NTC_EML" ).append("\n"); 
		query.append(",EML_TP_CD" ).append("\n"); 
		query.append(",EML_SND_DT" ).append("\n"); 
		query.append(",EML_SND_GDT" ).append("\n"); 
		query.append(",EML_SND_USR_ID" ).append("\n"); 
		query.append(",EML_NTC_SND_ID" ).append("\n"); 
		query.append(",EML_NTC_SND_RSLT_CD" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("B.BKG_NO" ).append("\n"); 
		query.append(",B.NTC_SEQ" ).append("\n"); 
		query.append(",B.CUST_CNTC_TP_CD" ).append("\n"); 
		query.append(",NULL" ).append("\n"); 
		query.append(",NULL" ).append("\n"); 
		query.append(",NULL" ).append("\n"); 
		query.append(",NULL" ).append("\n"); 
		query.append(",NULL" ).append("\n"); 
		query.append(",NULL" ).append("\n"); 
		query.append(",NULL" ).append("\n"); 
		query.append(",B.NTC_EML" ).append("\n"); 
		query.append(",'M'" ).append("\n"); 
		query.append(",NULL" ).append("\n"); 
		query.append(",NULL" ).append("\n"); 
		query.append(",B.EML_SND_USR_ID" ).append("\n"); 
		query.append(",NULL" ).append("\n"); 
		query.append(",NULL" ).append("\n"); 
		query.append(",B.CRE_USR_ID" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",B.UPD_USR_ID" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE B.NTC_EML IS NOT NULL" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PickUpNoticeDBDAOaddPkupNtcDtlByBkgNoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.30
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2010.04.30 박미옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park, Mi-Ok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PickUpNoticeDBDAOaddPkupNtcDtlByBkgNoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public PickUpNoticeDBDAOaddPkupNtcDtlByBkgNoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : PickUpNoticeDBDAOaddPkupNtcDtlByBkgNoCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_PKUP_NTC_DTL (" ).append("\n"); 
		query.append("	BKG_NO" ).append("\n"); 
		query.append(",	NTC_SEQ" ).append("\n"); 
		query.append(",	CUST_CNTC_TP_CD" ).append("\n"); 
		query.append(",	FAX_NO" ).append("\n"); 
		query.append(",	FAX_TP_CD" ).append("\n"); 
		query.append(",	FAX_SND_DT" ).append("\n"); 
		query.append(",	FAX_SND_GDT" ).append("\n"); 
		query.append(",	FAX_SND_USR_ID" ).append("\n"); 
		query.append(",	FAX_NTC_SND_ID" ).append("\n"); 
		query.append(",	FAX_NTC_SND_RSLT_CD" ).append("\n"); 
		query.append(",	NTC_EML" ).append("\n"); 
		query.append(",	EML_TP_CD" ).append("\n"); 
		query.append(",	EML_SND_DT" ).append("\n"); 
		query.append(",	EML_SND_GDT" ).append("\n"); 
		query.append(",	EML_SND_USR_ID" ).append("\n"); 
		query.append(",	EML_NTC_SND_ID" ).append("\n"); 
		query.append(",	EML_NTC_SND_RSLT_CD" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("	B.BKG_NO" ).append("\n"); 
		query.append(",	B.NTC_SEQ" ).append("\n"); 
		query.append(",	@[cust_cntc_tp_cd]" ).append("\n"); 
		query.append(",	@[fax_no]" ).append("\n"); 
		query.append(",	'M'" ).append("\n"); 
		query.append(",	NULL" ).append("\n"); 
		query.append(",	NULL" ).append("\n"); 
		query.append(",	NULL" ).append("\n"); 
		query.append(",	NULL" ).append("\n"); 
		query.append(",	NULL" ).append("\n"); 
		query.append(",	@[ntc_eml]" ).append("\n"); 
		query.append(",	'M'" ).append("\n"); 
		query.append(",	NULL" ).append("\n"); 
		query.append(",	NULL" ).append("\n"); 
		query.append(",	NULL" ).append("\n"); 
		query.append(",	NULL" ).append("\n"); 
		query.append(",	NULL" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append("FROM BKG_PKUP_NTC A" ).append("\n"); 
		query.append("    ,BKG_PKUP_NTC B" ).append("\n"); 
		query.append("WHERE A.BKG_NO              = @[bkg_no]" ).append("\n"); 
		query.append("  AND A.NTC_SEQ             = @[ntc_seq]" ).append("\n"); 
		query.append("  AND B.BKG_NO              = A.BKG_NO" ).append("\n"); 
		query.append("  AND B.CNTR_NO             = A.CNTR_NO" ).append("\n"); 
		query.append("  AND B.BKG_CUST_TP_CD      = A.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("  AND B.PKUP_NTC_SND_STS_CD = 'N'" ).append("\n"); 

	}
}
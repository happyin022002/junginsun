/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PickUpNoticeDBDAOmodifyPkupNtcDtlByBkgNoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.30
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PickUpNoticeDBDAOmodifyPkupNtcDtlByBkgNoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public PickUpNoticeDBDAOmodifyPkupNtcDtlByBkgNoUSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : PickUpNoticeDBDAOmodifyPkupNtcDtlByBkgNoUSQL").append("\n"); 
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
		query.append("UPDATE BKG_PKUP_NTC_DTL " ).append("\n"); 
		query.append("SET " ).append("\n"); 
		query.append("	FAX_NO = @[fax_no]" ).append("\n"); 
		query.append(",	FAX_TP_CD = DECODE(FAX_NO,@[fax_no],FAX_TP_CD,'M')" ).append("\n"); 
		query.append(",	NTC_EML = @[ntc_eml]" ).append("\n"); 
		query.append(",	EML_TP_CD = DECODE(NTC_EML,@[ntc_eml],EML_TP_CD,'M')" ).append("\n"); 
		query.append(",	UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE	(BKG_NO, NTC_SEQ)" ).append("\n"); 
		query.append("        IN " ).append("\n"); 
		query.append("        (SELECT B.BKG_NO, B.NTC_SEQ" ).append("\n"); 
		query.append("           FROM BKG_PKUP_NTC A" ).append("\n"); 
		query.append("               ,BKG_PKUP_NTC B" ).append("\n"); 
		query.append("          WHERE A.BKG_NO              = @[bkg_no]" ).append("\n"); 
		query.append("            AND A.NTC_SEQ             = @[ntc_seq]" ).append("\n"); 
		query.append("            AND B.BKG_NO              = A.BKG_NO" ).append("\n"); 
		query.append("            AND B.CNTR_NO             = A.CNTR_NO" ).append("\n"); 
		query.append("            AND B.BKG_CUST_TP_CD      = A.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("            AND B.PKUP_NTC_SND_STS_CD = 'N'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("  AND	CUST_CNTC_TP_CD = @[cust_cntc_tp_cd]" ).append("\n"); 

	}
}
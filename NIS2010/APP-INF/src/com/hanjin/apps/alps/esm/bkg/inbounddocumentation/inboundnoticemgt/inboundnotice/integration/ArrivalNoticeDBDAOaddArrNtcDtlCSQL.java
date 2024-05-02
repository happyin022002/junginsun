/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ArrivalNoticeDBDAOaddArrNtcDtlCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 박성호
*@LastVersion : 1.0
* 2009.10.07 박성호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Sungho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ArrivalNoticeDBDAOaddArrNtcDtlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 946 fax customer 정보 추가
	  * </pre>
	  */
	public ArrivalNoticeDBDAOaddArrNtcDtlCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fax_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ntc_eml",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fax_ntc_snd_rslt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fax_snd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_ntc_snd_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fax_ntc_snd_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("edi_ack_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eml_snd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_ntc_snd_rslt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eml_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fax_snd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : ArrivalNoticeDBDAOaddArrNtcDtlCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_ARR_NTC_DTL (" ).append("\n"); 
		query.append("BKG_NO" ).append("\n"); 
		query.append(",	BKG_CUST_TP_CD" ).append("\n"); 
		query.append(",	CUST_CNTC_TP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",	FAX_NO" ).append("\n"); 
		query.append(",	FAX_TP_CD" ).append("\n"); 
		query.append(",	FAX_SND_DT" ).append("\n"); 
		query.append(",	FAX_SND_GDT" ).append("\n"); 
		query.append(",	FAX_SND_USR_ID" ).append("\n"); 
		query.append(",	FAX_NTC_SND_ID" ).append("\n"); 
		query.append(",	FAX_SND_FLG" ).append("\n"); 
		query.append(",	FAX_NTC_SND_RSLT_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",	NTC_EML" ).append("\n"); 
		query.append(",	EML_TP_CD" ).append("\n"); 
		query.append(",	EML_SND_DT" ).append("\n"); 
		query.append(",	EML_SND_GDT" ).append("\n"); 
		query.append(",	EML_SND_USR_ID" ).append("\n"); 
		query.append(",	EML_NTC_SND_ID" ).append("\n"); 
		query.append(",	EML_SND_FLG" ).append("\n"); 
		query.append(",	EML_NTC_SND_RSLT_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("@[bkg_no]" ).append("\n"); 
		query.append(",	@[bkg_cust_tp_cd]" ).append("\n"); 
		query.append(",	@[cust_cntc_tp_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",	@[fax_no]" ).append("\n"); 
		query.append(",	@[fax_tp_cd]" ).append("\n"); 
		query.append(",   GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',TO_DATE(sysdate, 'YYYY/MM/DD HH24MISS'),@[ofc_cd] )      -- Local Date" ).append("\n"); 
		query.append(",   GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',TO_DATE(sysdate, 'YYYY/MM/DD HH24MISS'),'GMT' ) -- GMT Date" ).append("\n"); 
		query.append(",	@[fax_snd_usr_id]" ).append("\n"); 
		query.append(",	@[fax_ntc_snd_id]" ).append("\n"); 
		query.append(",	@[fax_snd_flg]" ).append("\n"); 
		query.append(",	@[fax_ntc_snd_rslt_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",	@[ntc_eml]" ).append("\n"); 
		query.append(",	@[eml_tp_cd]" ).append("\n"); 
		query.append(",   GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',TO_DATE(sysdate, 'YYYY/MM/DD HH24MISS'),@[ofc_cd] )      -- Local Date" ).append("\n"); 
		query.append(",   GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',TO_DATE(sysdate, 'YYYY/MM/DD HH24MISS'),'GMT' ) -- GMT Date" ).append("\n"); 
		query.append(",	@[eml_snd_usr_id]" ).append("\n"); 
		query.append(",	@[eml_ntc_snd_id]" ).append("\n"); 
		query.append(",	@[eml_snd_flg]" ).append("\n"); 
		query.append(",	@[eml_ntc_snd_rslt_cd]" ).append("\n"); 
		query.append(",	TO_DATE(@[edi_ack_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
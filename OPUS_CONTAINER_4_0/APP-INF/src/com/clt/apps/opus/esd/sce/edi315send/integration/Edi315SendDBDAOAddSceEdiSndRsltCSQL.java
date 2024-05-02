/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : Edi315SendDBDAOAddSceEdiSndRsltCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOAddSceEdiSndRsltCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * for AddSceEdiSndRslt
	  * AddSceEdiSndRslt
	  * Edi315SendDBDAOAddSceEdiSndRsltCSQL
	  * </pre>
	  */
	public Edi315SendDBDAOAddSceEdiSndRsltCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flt_file_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_leg_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_snd_yrmondy",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_sub_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_snd_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("po_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rslt_flag",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_snd_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("man_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_snd_itval_hr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trunk_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pkup_edi_322_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOAddSceEdiSndRsltCSQL").append("\n"); 
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
		query.append("INSERT INTO SCE_EDI_SND_RSLT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("   EDI_GRP_CD," ).append("\n"); 
		query.append("   EDI_STS_CD," ).append("\n"); 
		query.append("   EDI_SUB_STS_CD," ).append("\n"); 
		query.append("   BKG_NO," ).append("\n"); 
		query.append("   CNTR_NO," ).append("\n"); 
		query.append("   PO_NO,             " ).append("\n"); 
		query.append("   EDI_SND_KNT,                                       " ).append("\n"); 
		query.append("   BL_NO," ).append("\n"); 
		query.append("   NOD_CD,              " ).append("\n"); 
		query.append("   ACT_DT,            " ).append("\n"); 
		query.append("   MNL_FLG,             " ).append("\n"); 
		query.append("   EDI_SND_RMK," ).append("\n"); 
		query.append("   EDI_SND_TP_CD," ).append("\n"); 
		query.append("   CRE_USR_ID," ).append("\n"); 
		query.append("   CRE_DT," ).append("\n"); 
		query.append("   UPD_USR_ID," ).append("\n"); 
		query.append("   UPD_DT," ).append("\n"); 
		query.append("   EDI_SND_YRMONDY," ).append("\n"); 
		query.append("   EDI_SND_SEQ," ).append("\n"); 
		query.append("   PKUP_EDI_322_NO," ).append("\n"); 
		query.append("   EDI_SND_RSV_DT," ).append("\n"); 
		query.append("   VSL_CD," ).append("\n"); 
		query.append("   SKD_VOY_NO," ).append("\n"); 
		query.append("   SKD_DIR_CD," ).append("\n"); 
		query.append("   GMT_DT," ).append("\n"); 
		query.append("   FLT_FILE_REF_NO," ).append("\n"); 
		query.append("   COP_NO," ).append("\n"); 
		query.append("   TRSP_LEG_NM" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("			@[edi_grp_cd],--EDI_GRP_CD" ).append("\n"); 
		query.append("			@[edi_sts_cd],--EDI_STS_CD" ).append("\n"); 
		query.append("			@[edi_sub_sts_cd],--EDI_SUB_STS_CD" ).append("\n"); 
		query.append("			@[bkg_no],--BKG_NO" ).append("\n"); 
		query.append("			@[cntr_no],--CNTR_NO" ).append("\n"); 
		query.append("			nvl(@[po_no],'  '),--PO_NO" ).append("\n"); 
		query.append("			@[edi_snd_knt],--EDI_SND_KNT" ).append("\n"); 
		query.append("			@[bl_no],--BL_NO" ).append("\n"); 
		query.append("			@[nod_cd],--NOD_CD" ).append("\n"); 
		query.append("			TO_DATE(substr(@[act_dt], 1, 14), 'YYYY/MM/DD HH24:MI:SS'),--ACT_DT" ).append("\n"); 
		query.append("			nvl(@[man_flg],'N'),--MNL_FLG" ).append("\n"); 
		query.append("			decode(@[rslt_flag],'Y','SUCCESS(SENT)','R','RESERVED','L','SAVED','F','FAIL','N','FAIL',''),--EDI_SND_RMK" ).append("\n"); 
		query.append("			@[rslt_flag],--EDI_SND_TP_CD" ).append("\n"); 
		query.append("			nvl(@[cre_usr_id],'-')," ).append("\n"); 
		query.append("			sysdate," ).append("\n"); 
		query.append("			nvl(@[upd_usr_id],'-')," ).append("\n"); 
		query.append("			sysdate," ).append("\n"); 
		query.append("			nvl(@[edi_snd_yrmondy],to_char(sysdate,'yymmdd')),--EDI_SND_YRMONDY" ).append("\n"); 
		query.append("			nvl(@[edi_snd_seq],'0'),--EDI_SND_SEQ" ).append("\n"); 
		query.append("			@[pkup_edi_322_no],--PKUP_EDI_322_NO" ).append("\n"); 
		query.append("			decode(@[rslt_flag], 'R', sysdate + (TO_NUMBER(@[edi_snd_itval_hr])/24), ''),--EDI_SND_RSV_DT" ).append("\n"); 
		query.append("			substr(@[trunk_vvd],1,4),--VSL_CD" ).append("\n"); 
		query.append("			substr(@[trunk_vvd],5,4),--SKD_VOY_NO" ).append("\n"); 
		query.append("			substr(@[trunk_vvd],9,1),--SKD_DIR_CD" ).append("\n"); 
		query.append("			decode(@[rslt_flag],'L', GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC(),1,5), SYSDATE, SUBSTR(@[nod_cd], 1, 5))" ).append("\n"); 
		query.append("                               ,'K', GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC(),1,5), SYSDATE, SUBSTR(@[nod_cd], 1, 5))" ).append("\n"); 
		query.append("                               ,'Y', GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC(),1,5), SYSDATE, SUBSTR(@[nod_cd], 1, 5))" ).append("\n"); 
		query.append("							   ,'R', GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC(),1,5), SYSDATE, SUBSTR(@[nod_cd], 1, 5))" ).append("\n"); 
		query.append("								   , TO_DATE('20090101000000','yyyymmddhh24miss')),--GMT_DT" ).append("\n"); 
		query.append("			nvl(@[flt_file_ref_no],''),--FLT_FILE_REF_NO" ).append("\n"); 
		query.append("			nvl(@[cop_no],'')," ).append("\n"); 
		query.append("            nvl(@[trsp_leg_nm],'')--2015.08.04 TRSP_LEG_NM" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
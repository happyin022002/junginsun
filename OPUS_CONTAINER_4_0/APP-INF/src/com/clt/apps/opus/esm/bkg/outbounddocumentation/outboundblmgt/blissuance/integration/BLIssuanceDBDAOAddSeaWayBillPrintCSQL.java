/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLIssuanceDBDAOAddSeaWayBillPrintCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOAddSeaWayBillPrintCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Sea Waybill 출력시 BKG_INET_BL_PRN_AUTH 에 저장한다.
	  * </pre>
	  */
	public BLIssuanceDBDAOAddSeaWayBillPrintCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnee_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prn_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnee_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cpy_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wbl_prn_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_obrd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inet_bl_snd_via_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntfy_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prn_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_lgin_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doc_ecd_proc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntfy_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_knt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("shpr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shpr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOAddSeaWayBillPrintCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_INET_BL_PRN_AUTH" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	BKG_NO" ).append("\n"); 
		query.append("	,INFO_SEQ" ).append("\n"); 
		query.append("	,AUTH_DT" ).append("\n"); 
		query.append("	,AUTH_OFC_CD" ).append("\n"); 
		query.append("	,AUTH_USR_ID" ).append("\n"); 
		query.append("	,INET_BL_SND_VIA_CD" ).append("\n"); 
		query.append("	,OBL_KNT" ).append("\n"); 
		query.append("	,CPY_KNT" ).append("\n"); 
		query.append("	,WBL_PRN_DT" ).append("\n"); 
		query.append("	,WBL_PRN_GDT" ).append("\n"); 
		query.append("	,WBL_PRN_KNT" ).append("\n"); 
		query.append("	,DOC_ECD_PROC_FLG" ).append("\n"); 
		query.append("	,PRN_CUST_TP_CD" ).append("\n"); 
		query.append("	,PRN_USR_ID" ).append("\n"); 
		query.append("	,AUTH_LGIN_FLG" ).append("\n"); 
		query.append("	,SHPR_CNT_CD" ).append("\n"); 
		query.append("	,SHPR_SEQ" ).append("\n"); 
		query.append("	,CNEE_CNT_CD" ).append("\n"); 
		query.append("	,CNEE_SEQ" ).append("\n"); 
		query.append("	,NTFY_CNT_CD" ).append("\n"); 
		query.append("	,NTFY_SEQ" ).append("\n"); 
		query.append("	,VSL_CD" ).append("\n"); 
		query.append("	,SKD_VOY_NO" ).append("\n"); 
		query.append("	,SKD_DIR_CD" ).append("\n"); 
		query.append("	,BL_OBRD_DT" ).append("\n"); 
		query.append("	,BL_NO" ).append("\n"); 
		query.append("	,DELT_FLG" ).append("\n"); 
		query.append("	,CRE_USR_ID" ).append("\n"); 
		query.append("	,CRE_DT" ).append("\n"); 
		query.append("	,UPD_USR_ID" ).append("\n"); 
		query.append("	,UPD_DT" ).append("\n"); 
		query.append(")VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	@[bkg_no]" ).append("\n"); 
		query.append("	,(SELECT NVL( MAX(INFO_SEQ), 0) +1 FROM BKG_INET_BL_PRN_AUTH WHERE BKG_NO = @[bkg_no] )" ).append("\n"); 
		query.append("	,NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[auth_ofc_cd]),SYSDATE)" ).append("\n"); 
		query.append("	,@[auth_ofc_cd]" ).append("\n"); 
		query.append("	,@[auth_usr_id]" ).append("\n"); 
		query.append("	,@[inet_bl_snd_via_cd]" ).append("\n"); 
		query.append("	,@[obl_knt]" ).append("\n"); 
		query.append("	,@[cpy_knt]" ).append("\n"); 
		query.append("	,NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[auth_ofc_cd]),SYSDATE)" ).append("\n"); 
		query.append("	,GLOBALDATE_PKG.TIME_CONV_FNC(COM_CONSTANTMGR_PKG.COM_GETBASELOCATIONCODE_FNC(),sysdate,BKG_COM_USER_LOC_FNC(@[upd_usr_id]))" ).append("\n"); 
		query.append("	,@[wbl_prn_knt]" ).append("\n"); 
		query.append("	,@[doc_ecd_proc_flg]" ).append("\n"); 
		query.append("	,@[prn_cust_tp_cd]" ).append("\n"); 
		query.append("	,@[prn_usr_id]" ).append("\n"); 
		query.append("	,@[auth_lgin_flg]" ).append("\n"); 
		query.append("	,@[shpr_cnt_cd]" ).append("\n"); 
		query.append("	,@[shpr_seq]" ).append("\n"); 
		query.append("	,@[cnee_cnt_cd]" ).append("\n"); 
		query.append("	,@[cnee_seq]" ).append("\n"); 
		query.append("	,@[ntfy_cnt_cd]" ).append("\n"); 
		query.append("	,@[ntfy_seq]" ).append("\n"); 
		query.append("	,@[vsl_cd]" ).append("\n"); 
		query.append("	,@[skd_voy_no]" ).append("\n"); 
		query.append("	,@[skd_dir_cd]" ).append("\n"); 
		query.append("	,TO_DATE(@[bl_obrd_dt],'YYYY/MM/DD HH24:MI:SS')" ).append("\n"); 
		query.append("	,@[bl_no]" ).append("\n"); 
		query.append("	,@[delt_flg]" ).append("\n"); 
		query.append("	,@[upd_usr_id]" ).append("\n"); 
		query.append("	,sysdate" ).append("\n"); 
		query.append("	,@[upd_usr_id]" ).append("\n"); 
		query.append("	,sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
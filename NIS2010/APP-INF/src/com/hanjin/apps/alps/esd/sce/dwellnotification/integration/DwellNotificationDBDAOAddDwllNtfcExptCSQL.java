/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DwellNotificationDBDAOAddDwllNtfcExptCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 2013.04.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.dwellnotification.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DwellNotificationDBDAOAddDwllNtfcExptCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Email Sending Exception List을 저장한다.
	  * </pre>
	  */
	public DwellNotificationDBDAOAddDwllNtfcExptCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("enr_dwll_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_vsl_dlay_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_dest_dwll_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tml_dwll_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_dlay_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_tml_dwll_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dwll_expt_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_dwll_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_enr_dwll_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.dwellnotification.integration").append("\n"); 
		query.append("FileName : DwellNotificationDBDAOAddDwllNtfcExptCSQL").append("\n"); 
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
		query.append("MERGE INTO SCE_DWLL_NTFC_CUST_EXPT T" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("USING ( SELECT SUBSTR(@[cust_cd],1,2) DWLL_CUST_CNT_CD" ).append("\n"); 
		query.append(", TO_NUMBER(SUBSTR(@[cust_cd],3,6)) DWLL_CUST_SEQ" ).append("\n"); 
		query.append(", @[sc_no]         SC_NO" ).append("\n"); 
		query.append(", CASE WHEN @[eff_dt] IS NULL THEN TO_CHAR(SYSDATE, 'YYYYMMDD')" ).append("\n"); 
		query.append("WHEN @[eff_dt] <= '09991231' THEN '09991231'" ).append("\n"); 
		query.append("ELSE TO_CHAR(TO_DATE(@[eff_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("+ (TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD'),'YYYYMMDD')" ).append("\n"); 
		query.append("- TO_DATE(TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', SYSDATE, GLOBALDATE_PKG.GET_LOCCD_FNC(@[ofc_cd])), 'YYYYMMDD'),'YYYYMMDD')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", 'YYYYMMDD')" ).append("\n"); 
		query.append("END AS FM_EFF_DT" ).append("\n"); 
		query.append(", CASE WHEN @[exp_dt] IS NULL THEN '99991231'" ).append("\n"); 
		query.append("WHEN @[exp_dt] >= '99991231' THEN '99991231'" ).append("\n"); 
		query.append("ELSE TO_CHAR(TO_DATE(@[exp_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("+ (TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD'),'YYYYMMDD')" ).append("\n"); 
		query.append("- TO_DATE(TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', SYSDATE, GLOBALDATE_PKG.GET_LOCCD_FNC(@[ofc_cd])), 'YYYYMMDD'),'YYYYMMDD')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", 'YYYYMMDD')" ).append("\n"); 
		query.append("END AS  TO_EFF_DT" ).append("\n"); 
		query.append(", DECODE(@[tml_dwll_flg],'1','Y','N')  TML_DWLL_FLG" ).append("\n"); 
		query.append(", DECODE(@[enr_dwll_flg],'1','Y','N')  ENR_DWLL_FLG" ).append("\n"); 
		query.append(", DECODE(@[dest_dwll_flg],'1','Y','N') DEST_DWLL_FLG" ).append("\n"); 
		query.append(", DECODE(@[vsl_dlay_flg],'1','Y','N')  VSL_DLAY_FLG" ).append("\n"); 
		query.append(", DECODE(@[bkg_tml_dwll_flg],'1','Y','N')  BKG_TML_DWLL_FLG" ).append("\n"); 
		query.append(", DECODE(@[bkg_enr_dwll_flg],'1','Y','N')  BKG_ENR_DWLL_FLG" ).append("\n"); 
		query.append(", DECODE(@[bkg_dest_dwll_flg],'1','Y','N') BKG_DEST_DWLL_FLG" ).append("\n"); 
		query.append(", DECODE(@[bkg_vsl_dlay_flg],'1','Y','N')  BKG_VSL_DLAY_FLG" ).append("\n"); 
		query.append("FROM DUAL )S" ).append("\n"); 
		query.append("ON (T.DWLL_CUST_CNT_CD = S.DWLL_CUST_CNT_CD AND T.DWLL_CUST_SEQ = S.DWLL_CUST_SEQ)" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET T.FM_EFF_DT       = S.FM_EFF_DT" ).append("\n"); 
		query.append(", T.TO_EFF_DT       = S.TO_EFF_DT" ).append("\n"); 
		query.append(", T.TML_DWLL_FLG    = S.TML_DWLL_FLG" ).append("\n"); 
		query.append(", T.ENR_DWLL_FLG    = S.ENR_DWLL_FLG" ).append("\n"); 
		query.append(", T.DEST_DWLL_FLG   = S.DEST_DWLL_FLG" ).append("\n"); 
		query.append(", T.VSL_DLAY_FLG    = S.VSL_DLAY_FLG" ).append("\n"); 
		query.append(", T.DWLL_EXPT_RMK   = @[dwll_expt_rmk]" ).append("\n"); 
		query.append(", T.UPD_USR_ID      = @[usr_id]" ).append("\n"); 
		query.append(", T.UPD_DT          = SYSDATE" ).append("\n"); 
		query.append(", T.EXPT_SET_USR_ID = @[usr_id]" ).append("\n"); 
		query.append(", T.EXPT_SET_DT     = SYSDATE" ).append("\n"); 
		query.append(", T.DELT_FLG		  = 'N'" ).append("\n"); 
		query.append(", T.BKG_TML_DWLL_FLG    = S.BKG_TML_DWLL_FLG" ).append("\n"); 
		query.append(", T.BKG_ENR_DWLL_FLG    = S.BKG_ENR_DWLL_FLG" ).append("\n"); 
		query.append(", T.BKG_DEST_DWLL_FLG   = S.BKG_DEST_DWLL_FLG" ).append("\n"); 
		query.append(", T.BKG_VSL_DLAY_FLG    = S.BKG_VSL_DLAY_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (T.SC_NO," ).append("\n"); 
		query.append("T.DWLL_CUST_CNT_CD," ).append("\n"); 
		query.append("T.DWLL_CUST_SEQ," ).append("\n"); 
		query.append("T.CRE_USR_ID," ).append("\n"); 
		query.append("T.CRE_DT," ).append("\n"); 
		query.append("T.UPD_USR_ID," ).append("\n"); 
		query.append("T.UPD_DT," ).append("\n"); 
		query.append("T.FM_EFF_DT," ).append("\n"); 
		query.append("T.TO_EFF_DT," ).append("\n"); 
		query.append("T.TML_DWLL_FLG," ).append("\n"); 
		query.append("T.ENR_DWLL_FLG," ).append("\n"); 
		query.append("T.DEST_DWLL_FLG," ).append("\n"); 
		query.append("T.VSL_DLAY_FLG," ).append("\n"); 
		query.append("T.DWLL_EXPT_RMK," ).append("\n"); 
		query.append("T.EXPT_SET_USR_ID," ).append("\n"); 
		query.append("T.EXPT_SET_DT," ).append("\n"); 
		query.append("T.DELT_FLG," ).append("\n"); 
		query.append("T.BKG_TML_DWLL_FLG," ).append("\n"); 
		query.append("T.BKG_ENR_DWLL_FLG," ).append("\n"); 
		query.append("T.BKG_DEST_DWLL_FLG," ).append("\n"); 
		query.append("T.BKG_VSL_DLAY_FLG )" ).append("\n"); 
		query.append("VALUES (S.SC_NO," ).append("\n"); 
		query.append("S.DWLL_CUST_CNT_CD," ).append("\n"); 
		query.append("S.DWLL_CUST_SEQ," ).append("\n"); 
		query.append("@[usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("S.FM_EFF_DT," ).append("\n"); 
		query.append("S.TO_EFF_DT," ).append("\n"); 
		query.append("S.TML_DWLL_FLG," ).append("\n"); 
		query.append("S.ENR_DWLL_FLG," ).append("\n"); 
		query.append("S.DEST_DWLL_FLG," ).append("\n"); 
		query.append("S.VSL_DLAY_FLG," ).append("\n"); 
		query.append("@[dwll_expt_rmk]," ).append("\n"); 
		query.append("@[usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("'N'," ).append("\n"); 
		query.append("S.BKG_TML_DWLL_FLG," ).append("\n"); 
		query.append("S.BKG_ENR_DWLL_FLG," ).append("\n"); 
		query.append("S.BKG_DEST_DWLL_FLG," ).append("\n"); 
		query.append("S.BKG_VSL_DLAY_FLG )" ).append("\n"); 

	}
}
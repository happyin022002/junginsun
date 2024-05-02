/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingMasterMgtDBDAOBkgEdiGrpCustUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.25
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2010.05.25 김태경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOBkgEdiGrpCustUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BkgEdiGrpCust
	  * </pre>
	  */
	public BookingMasterMgtDBDAOBkgEdiGrpCustUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cfm_auto_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("esvc_bl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_drft_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cfm_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ctrt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("esvc_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_trak_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_drft_auto_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("an_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("co_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOBkgEdiGrpCustUSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_EDI_GRP_CUST TA" ).append("\n"); 
		query.append("USING ( SELECT @[esvc_grp_cd] AS ESVC_GRP_CD," ).append("\n"); 
		query.append("               SUBSTRB(@[co_cd],1,1) AS CO_CD," ).append("\n"); 
		query.append("               NVL(@[cnt_cd],' ') AS CNT_CD," ).append("\n"); 
		query.append("               NVL(@[cust_seq],0) AS CUST_SEQ," ).append("\n"); 
		query.append("               NVL(@[sc_no],' ') AS SC_NO," ).append("\n"); 
		query.append("               @[bkg_cfm_flg] AS BKG_CFM_FLG," ).append("\n"); 
		query.append("               @[bkg_cfm_auto_flg] AS BKG_CFM_AUTO_FLG," ).append("\n"); 
		query.append("               @[bl_drft_auto_flg] AS BL_DRFT_AUTO_FLG," ).append("\n"); 
		query.append("               @[bl_drft_flg] AS BL_DRFT_FLG," ).append("\n"); 
		query.append("               @[cgo_trak_flg] AS CGO_TRAK_FLG," ).append("\n"); 
		query.append("               @[an_flg] AS AN_FLG," ).append("\n"); 
		query.append("               @[esvc_bl_tp_cd] AS ESVC_BL_TP_CD," ).append("\n"); 
		query.append("               @[bkg_ctrt_tp_cd] AS BKG_CTRT_TP_CD," ).append("\n"); 
		query.append("               @[delt_flg] AS DELT_FLG" ).append("\n"); 
		query.append("        FROM   DUAL ) TB" ).append("\n"); 
		query.append("ON    (     TA.ESVC_GRP_CD = TB.ESVC_GRP_CD" ).append("\n"); 
		query.append("        AND TA.CO_CD       = TB.CO_CD" ).append("\n"); 
		query.append("        AND TA.CNT_CD      = TB.CNT_CD" ).append("\n"); 
		query.append("        AND TA.CUST_SEQ    = TB.CUST_SEQ" ).append("\n"); 
		query.append("        AND TA.SC_NO       = TB.SC_NO )" ).append("\n"); 
		query.append("WHEN MATCHED THEN " ).append("\n"); 
		query.append("      UPDATE SET" ).append("\n"); 
		query.append("             BKG_CFM_FLG      = DECODE(TB.BKG_CFM_FLG,'1','Y','Y','Y','N')," ).append("\n"); 
		query.append("             BKG_CFM_AUTO_FLG = DECODE(TB.BKG_CFM_AUTO_FLG,'1','Y','Y','Y','N')," ).append("\n"); 
		query.append("             BL_DRFT_AUTO_FLG = DECODE(TB.BL_DRFT_AUTO_FLG,'1','Y','Y','Y','N')," ).append("\n"); 
		query.append("             BL_DRFT_FLG      = DECODE(TB.BL_DRFT_FLG,'1','Y','Y','Y','N')," ).append("\n"); 
		query.append("             CGO_TRAK_FLG     = DECODE(TB.CGO_TRAK_FLG,'1','Y','Y','Y','N')," ).append("\n"); 
		query.append("             AN_FLG           = DECODE(TB.AN_FLG,'1','Y','Y','Y','N')," ).append("\n"); 
		query.append("             ESVC_BL_TP_CD    = TB.ESVC_BL_TP_CD," ).append("\n"); 
		query.append("             BKG_CTRT_TP_CD   = TB.BKG_CTRT_TP_CD," ).append("\n"); 
		query.append("             DELT_FLG         = DECODE(TB.DELT_FLG,'1','Y','Y','Y','N')," ).append("\n"); 
		query.append("             UPD_USR_ID       = 'System'," ).append("\n"); 
		query.append("             UPD_DT           = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN " ).append("\n"); 
		query.append("      INSERT ( ESVC_GRP_CD,      CO_CD,            CNT_CD, " ).append("\n"); 
		query.append("               CUST_SEQ,         SC_NO," ).append("\n"); 
		query.append("               BKG_CFM_FLG, " ).append("\n"); 
		query.append("               BKG_CFM_AUTO_FLG," ).append("\n"); 
		query.append("               BL_DRFT_AUTO_FLG," ).append("\n"); 
		query.append("               BL_DRFT_FLG," ).append("\n"); 
		query.append("               CGO_TRAK_FLG," ).append("\n"); 
		query.append("               AN_FLG," ).append("\n"); 
		query.append("               ESVC_BL_TP_CD,    BKG_CTRT_TP_CD," ).append("\n"); 
		query.append("               DELT_FLG,         " ).append("\n"); 
		query.append("               CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT )" ).append("\n"); 
		query.append("      VALUES ( TB.ESVC_GRP_CD,      TB.CO_CD,            TB.CNT_CD," ).append("\n"); 
		query.append("               TB.CUST_SEQ,         TB.SC_NO," ).append("\n"); 
		query.append("               DECODE(TB.BKG_CFM_FLG,'1','Y','Y','Y','N')," ).append("\n"); 
		query.append("               DECODE(TB.BKG_CFM_AUTO_FLG,'1','Y','Y','Y','N')," ).append("\n"); 
		query.append("               DECODE(TB.BL_DRFT_AUTO_FLG,'1','Y','Y','Y','N')," ).append("\n"); 
		query.append("               DECODE(TB.BL_DRFT_FLG,'1','Y','Y','Y','N')," ).append("\n"); 
		query.append("               DECODE(TB.CGO_TRAK_FLG,'1','Y','Y','Y','N')," ).append("\n"); 
		query.append("               DECODE(TB.AN_FLG,'1','Y','Y','Y','N')," ).append("\n"); 
		query.append("               TB.ESVC_BL_TP_CD,    TB.BKG_CTRT_TP_CD," ).append("\n"); 
		query.append("               DECODE(TB.DELT_FLG,'1','Y','Y','Y','N')," ).append("\n"); 
		query.append("               'System', SYSDATE, 'System', SYSDATE )" ).append("\n"); 

	}
}
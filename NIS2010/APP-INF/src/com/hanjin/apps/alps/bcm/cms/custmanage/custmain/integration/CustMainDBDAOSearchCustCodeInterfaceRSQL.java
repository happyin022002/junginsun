/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : CustMainDBDAOSearchCustCodeInterfaceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.19
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.cms.custmanage.custmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustMainDBDAOSearchCustCodeInterfaceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Interface
	  * </pre>
	  */
	public CustMainDBDAOSearchCustCodeInterfaceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.cms.custmanage.custmain.integration").append("\n"); 
		query.append("FileName : CustMainDBDAOSearchCustCodeInterfaceRSQL").append("\n"); 
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
		query.append("SELECT MC.Cust_Cnt_Cd         " ).append("\n"); 
		query.append("      ,MC.Cust_Seq           " ).append("\n"); 
		query.append("      ,Cntr_Div_Flg        " ).append("\n"); 
		query.append("      ,Blk_Div_Flg         " ).append("\n"); 
		query.append("      ,CUST_GRP_ID Cust_Grp_Cd         " ).append("\n"); 
		query.append("      ,Cust_Lgl_Eng_Nm      " ).append("\n"); 
		query.append("      ,Cust_Locl_Lang_Nm    " ).append("\n"); 
		query.append("      ,Cust_Abbr_Nm        " ).append("\n"); 
		query.append("      ,Rvis_Cntr_Cust_Tp_Cd  " ).append("\n"); 
		query.append("      ,Blk_Cust_Tp_Cd       " ).append("\n"); 
		query.append("      ,'' Dmst_Frgn_Div_Cd     " ).append("\n"); 
		query.append("      ,Indiv_Corp_Div_Cd" ).append("\n"); 
		query.append("      ,Ofc_Cd Mst_Ofc_Id          " ).append("\n"); 
		query.append("      ,Ofc_Cd             " ).append("\n"); 
		query.append("      ,'' Blk_Cnt_Cd          " ).append("\n"); 
		query.append("      ,Cust_Ip            " ).append("\n"); 
		query.append("      ,Cust_Eml           " ).append("\n"); 
		query.append("      ,Cust_Url           " ).append("\n"); 
		query.append("      ,MCC.Ownr_Nm            " ).append("\n"); 
		query.append("      ,MCC.Bzct_Nm            " ).append("\n"); 
		query.append("      ,MCC.BZTP_NM Bztp_Desc          " ).append("\n"); 
		query.append("      ,Fndt_Dt            " ).append("\n"); 
		query.append("      ,Cust_Rgst_No        " ).append("\n"); 
		query.append("      ,'' Cust_Clss_Lvl_Cd     " ).append("\n"); 
		query.append("      ,Finc_Sts_Lvl_Cd      " ).append("\n"); 
		query.append("      ,MC.Loc_Cd             " ).append("\n"); 
		query.append("      ,Capi_Curr_Cd        " ).append("\n"); 
		query.append("      ,Capi_Amt           " ).append("\n"); 
		query.append("      ,'' Sell_Curr_Cd        " ).append("\n"); 
		query.append("      ,'' Sell_Amt           " ).append("\n"); 
		query.append("      ,Lstk_Flg           " ).append("\n"); 
		query.append("      ,Empe_Knt           " ).append("\n"); 
		query.append("      ,'' N1_St_Bkg_Dt         " ).append("\n"); 
		query.append("      ,rfnd_psdo_vndr_seq N1_St_Bkg_No         " ).append("\n"); 
		query.append("      ,'' N1_St_Bkg_No_Split    " ).append("\n"); 
		query.append("      ,Vndr_Seq           " ).append("\n"); 
		query.append("      ,Cust_Rmk           " ).append("\n"); 
		query.append("      ,VBS_CLSS_CD Val_Bse_Segm_Clss_Cd  " ).append("\n"); 
		query.append("      ,NBS_CLSS_CD1 Nds_Bse_Segm_Clss_Cd1 " ).append("\n"); 
		query.append("      ,NBS_CLSS_CD2 Nds_Bse_Segm_Clss_Cd2 " ).append("\n"); 
		query.append("      ,NBS_CLSS_CD3 Nds_Bse_Segm_Clss_Cd3 " ).append("\n"); 
		query.append("      ,MCCP.INTL_PHN_NO Mn_Intl_Phn_No       " ).append("\n"); 
		query.append("      ,'' Mn_Arct_Pnn_No       " ).append("\n"); 
		query.append("      ,'' Mn_Phn_No           " ).append("\n"); 
		query.append("      ,MCCP.PHN_NO Mn_Full_Phn_No       " ).append("\n"); 
		query.append("      ,MCCP.INTL_FAX_NO Mn_Intl_Fax_No       " ).append("\n"); 
		query.append("      ,'' Mn_Arct_Fax_No       " ).append("\n"); 
		query.append("      ,'' Mn_Fax_No           " ).append("\n"); 
		query.append("      ,MCCP.FAX_NO Mn_Full_Fax_No       " ).append("\n"); 
		query.append("      ,Cust_Sts_Cd         " ).append("\n"); 
		query.append("      ,MC.Crm_Row_Id          " ).append("\n"); 
		query.append("      ,Nvocc_Hjs_Scac_Cd    " ).append("\n"); 
		query.append("      ,Nvocc_Bd_No         " ).append("\n"); 
		query.append("      ,Nvocc_Lic_No        " ).append("\n"); 
		query.append("      ,Nvocc_Bd_Amt        " ).append("\n"); 
		query.append("      ,TO_CHAR(NVOCC_BD_ST_EFF_DT,'YYYYMMDDHH24MISS') Nvocc_Bd_Strt_Eff_Dt  " ).append("\n"); 
		query.append("      ,TO_CHAR(Nvocc_Bd_End_Eff_Dt,'YYYYMMDDHH24MISS')   Nvocc_Bd_End_Eff_Dt" ).append("\n"); 
		query.append("      ,Frt_Fwrd_Fmc_No      " ).append("\n"); 
		query.append("      ,'' Frt_Fwrd_Eff_Dt      " ).append("\n"); 
		query.append("      ,'' Fmc_No_Cd           " ).append("\n"); 
		query.append("      ,Indus_Desc         " ).append("\n"); 
		query.append("      ,Crnt_Vol_Knt        " ).append("\n"); 
		query.append("      ,CMPT_DESC Cpeti_Desc         " ).append("\n"); 
		query.append("      ,Spcl_Req_Desc       " ).append("\n"); 
		query.append("      ,Prf_Svc_Desc        " ).append("\n"); 
		query.append("      ,Prf_Svc_Dtl_Desc     " ).append("\n"); 
		query.append("      ,Prf_Grp_Cmdt_Cd      " ).append("\n"); 
		query.append("      ,PRF_REP_CMDT_CD Prf_Repre_Cmdt_Cd    " ).append("\n"); 
		query.append("      ,Prf_Cntr_Tpsz_Cd     " ).append("\n"); 
		query.append("      ,Srep_Cd            " ).append("\n"); 
		query.append("      ,Cts_No             " ).append("\n"); 
		query.append("      ,'' Bfr_Ofc_Id          " ).append("\n"); 
		query.append("      ,'' Bfr_Ofc_Cd          " ).append("\n"); 
		query.append("      ,'' Bfr_Ofc_Chng_Dt      " ).append("\n"); 
		query.append("      ,MC.Cre_Usr_Id          " ).append("\n"); 
		query.append("      ,TO_CHAR(MC.Cre_Dt,'YYYYMMDDHH24MISS')   Cre_Dt           " ).append("\n"); 
		query.append("      ,MC.Upd_Usr_Id          " ).append("\n"); 
		query.append("      ,TO_CHAR(MC.Upd_Dt,'YYYYMMDDHH24MISS')   Upd_Dt          " ).append("\n"); 
		query.append("      ,DECODE(SLS_DELT_EFF_DT, NULL, 'N', 'Y') Delt_Flg           " ).append("\n"); 
		query.append("      ,Modi_Cust_Cnt_Cd     " ).append("\n"); 
		query.append("      ,Modi_Cust_Seq       " ).append("\n"); 
		query.append("      ,'' O_Mst_Ofc_Id         " ).append("\n"); 
		query.append("      ,'' O_Ofc_Cd            " ).append("\n"); 
		query.append("      ,'' Rtn_Eml            " ).append("\n"); 
		query.append("      ,MCA.CRM_ROW_ID Cust_Addr_Row_Id     " ).append("\n"); 
		query.append("      ,DECODE(MCA.DELT_FLG, NULL, 'N', 'N','N', 'Y') Cust_Addr_Sts_Cd     " ).append("\n"); 
		query.append("      ,MCA.ADDR_TP_CD Addr_Tp_Cd          " ).append("\n"); 
		query.append("      ,MCA.PRMRY_CHK_FLG Prmry_Chk_Flg       " ).append("\n"); 
		query.append("      ,MCA.BZET_ADDR Bzet_Addr          " ).append("\n"); 
		query.append("      ,MCA.CTY_NM Cty_Nm             " ).append("\n"); 
		query.append("      ,MCA.STE_CD Ste_Cd             " ).append("\n"); 
		query.append("      ,MCA.ZIP_CD Zip_Cd             " ).append("\n"); 
		query.append("      ,MCA.CNT_CD Cnt_Cd             " ).append("\n"); 
		query.append("      ,'' Ssidi_Co_Cd         " ).append("\n"); 
		query.append("      ,Key_Acct_Flg        " ).append("\n"); 
		query.append("      ,TO_CHAR(KEY_ACCT_ST_EFF_DT, 'YYYYMMDD') Key_Acct_Strt_Eff_Dt  " ).append("\n"); 
		query.append("      ,TO_CHAR(KEY_ACCT_END_EFF_DT, 'YYYYMMDD') Key_Acct_End_Eff_Dt   " ).append("\n"); 
		query.append("      ,'' Delt_Eff_Dt         " ).append("\n"); 
		query.append("      ,'' Sls_Delt_Flg        " ).append("\n"); 
		query.append("      ,'' Key_Acct_Mgr_Glo_Usr_Id" ).append("\n"); 
		query.append("      ,'' Key_Acct_Mgr_Glo_Usr_Nm" ).append("\n"); 
		query.append("      ,Addr_Seq           " ).append("\n"); 
		query.append("      ,'' Sub_S_Co_Fm_Dt        " ).append("\n"); 
		query.append("      ,'' Sub_S_Co_To_Dt       " ).append("\n"); 
		query.append("      ,Bkg_Alt_Rsn         " ).append("\n"); 
		query.append("      ,TO_CHAR(Bkg_Alt_Fm_Dt,'YYYYMMDDHH24MISS')  Bkg_Alt_Fm_Dt      " ).append("\n"); 
		query.append("      ,TO_CHAR(Bkg_Alt_To_Dt,'YYYYMMDDHH24MISS')  Bkg_Alt_To_Dt      " ).append("\n"); 
		query.append("      ,Bkg_Alt_Msg         " ).append("\n"); 
		query.append("      ,Bkg_Alt_Cre_Usr_Id    " ).append("\n"); 
		query.append("      ,TO_CHAR(Bkg_Alt_Cre_Dt,'YYYYMMDDHH24MISS') Bkg_Alt_Cre_Dt" ).append("\n"); 
		query.append("      ,Nmd_Cust_Flg        " ).append("\n"); 
		query.append("      ,Mlt_Trd_Acct_Flg     " ).append("\n"); 
		query.append("      ,Oti_Orz_No          " ).append("\n"); 
		query.append("      ,Rf_Acct_Flg         " ).append("\n"); 
		query.append("      ,Sls_Delt_Eff_Rsn_Cd   " ).append("\n"); 
		query.append("      ,New_Key_Acct_Flg    " ).append("\n"); 
		query.append("      ,Glo_Acct_Flg        " ).append("\n"); 
		query.append("      ,Rgn_Acct_Flg               " ).append("\n"); 
		query.append("FROM MDM_CUSTOMER MC" ).append("\n"); 
		query.append("     , MDM_LOCATION ML" ).append("\n"); 
		query.append("     , MDM_CUST_CNTC_PNT MCCP" ).append("\n"); 
		query.append("     , (SELECT * FROM MDM_CUST_ADDR MCA WHERE MCA.CUST_CNT_CD = @[cust_cnt_cd] AND MCA.CUST_SEQ = @[cust_seq] AND MCA.ADDR_TP_CD='1' AND MCA.PRMRY_CHK_FLG='Y' AND ROWNUM = 1) MCA" ).append("\n"); 
		query.append("     , MDM_CR_CUST MCC" ).append("\n"); 
		query.append("WHERE MC.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("AND MC.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("AND MC.LOC_CD = ML.LOC_CD" ).append("\n"); 
		query.append("AND MC.CUST_CNT_CD = MCCP.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND MC.CUST_SEQ = MCCP.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND MCCP.CUST_CNTC_PNT_SEQ(+) = 1" ).append("\n"); 
		query.append("AND MC.CUST_CNT_CD = MCA.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND MC.CUST_SEQ = MCA.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND MC.CUST_CNT_CD <> 'TB'" ).append("\n"); 
		query.append("AND MC.CUST_CNT_CD = MCC.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND MC.CUST_SEQ = MCC.CUST_SEQ(+)" ).append("\n"); 

	}
}
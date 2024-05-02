/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : CustMainDBDAOSearchCrCustInterfaceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.03.30
*@LastModifier : 
*@LastVersion : 1.0
* 2018.03.30 
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

public class CustMainDBDAOSearchCrCustInterfaceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Credit customer interface
	  * </pre>
	  */
	public CustMainDBDAOSearchCrCustInterfaceRSQL(){
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
		query.append("FileName : CustMainDBDAOSearchCrCustInterfaceRSQL").append("\n"); 
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
		query.append("SELECT MCC.Cust_Cnt_Cd            " ).append("\n"); 
		query.append("    ,MCC.Cust_Seq              " ).append("\n"); 
		query.append("    ,Act_Cust_Cnt_Cd         " ).append("\n"); 
		query.append("    ,Act_Cust_Seq           " ).append("\n"); 
		query.append("    ,Cust_Rlse_Ctrl_Flg      " ).append("\n"); 
		query.append("    ,Cr_Flg                " ).append("\n"); 
		query.append("    ,Cr_Curr_Cd             " ).append("\n"); 
		query.append("    ,Cr_Amt                " ).append("\n"); 
		query.append("    ,Cr_Clt_Ofc_Cd           " ).append("\n"); 
		query.append("    ,Cr_Clt_Ofc_Cd Cr_Clt_Mst_Ofc_Id1       " ).append("\n"); 
		query.append("    ,HJSEAI_PKG.H_ENCODE(Cr_Cust_Rmk, 'UTF8' ,'UTF8') Cr_Cust_Rmk" ).append("\n"); 
		query.append("    ,Ib_Cr_Term_Dys          " ).append("\n"); 
		query.append("    ,Ob_Cr_Term_Dys          " ).append("\n"); 
		query.append("    ,Pay_Div_Cd             " ).append("\n"); 
		query.append("    ,MCC.CR_ST_DT  Cr_Strt_Dt             " ).append("\n"); 
		query.append("    ,Cr_End_Dt Cr_End_Dt" ).append("\n"); 
		query.append("    ,Cr_Cust_Tp_Cd           " ).append("\n"); 
		query.append("    ,Kr_Ib_Ofc_Cd            " ).append("\n"); 
		query.append("    ,MCC.KR_IB_OFC_CD Kr_Ib_Mst_Ofc_Id         " ).append("\n"); 
		query.append("    ,Ob_Eml                " ).append("\n"); 
		query.append("    ,Ib_Eml                " ).append("\n"); 
		query.append("    ,Xch_Rt_Div_Cd           " ).append("\n"); 
		query.append("    ,MCC.CNG_INDIV_CD Chng_Indiv_Cd          " ).append("\n"); 
		query.append("    ,MCC.DY_XCH_APLY_ST_DT Dy_Xch_Appl_Strt_Dt      " ).append("\n"); 
		query.append("    ,Iss_Div_Cd             " ).append("\n"); 
		query.append("    ,Bank_Acct_No           " ).append("\n"); 
		query.append("    ,Bfr_Cr_Clt_Ofc_Cd Bfr_Cr_Clt_Ofc_Id        " ).append("\n"); 
		query.append("    ,Bfr_Cr_Clt_Ofc_Cd        " ).append("\n"); 
		query.append("    ,MCC.BFR_OFC_CNG_DT Bfr_Ofc_Chng_Dt         " ).append("\n"); 
		query.append("    ,Bfr_Kr_Ib_Ofc_Cd Bfr_Kr_Ib_Ofc_Id         " ).append("\n"); 
		query.append("    ,Bfr_Kr_Ib_Ofc_Cd         " ).append("\n"); 
		query.append("    ,HJSEAI_PKG.H_ENCODE(Cntc_Pson_Nm, 'UTF8' ,'UTF8') Cntc_Pson_Nm" ).append("\n"); 
		query.append("    ,'' Due_Dt_Crte_Div_Cd       " ).append("\n"); 
		query.append("    ,Pay_Dt_Dy1             " ).append("\n"); 
		query.append("    ,Pay_Dt_Dy2             " ).append("\n"); 
		query.append("    ,Pay_Dt_Dy3             " ).append("\n"); 
		query.append("    ,Pay_Dt_Dy4             " ).append("\n"); 
		query.append("    ,HJSEAI_PKG.H_ENCODE(Locl_Nm, 'UTF8' ,'UTF8') Locl_Nm" ).append("\n"); 
		query.append("    ,HJSEAI_PKG.H_ENCODE(Locl_Addr1, 'UTF8' ,'UTF8') Locl_Addr1" ).append("\n"); 
		query.append("    ,HJSEAI_PKG.H_ENCODE(Locl_Addr2, 'UTF8' ,'UTF8') Locl_Addr2" ).append("\n"); 
		query.append("    ,HJSEAI_PKG.H_ENCODE(Locl_Addr3, 'UTF8' ,'UTF8') Locl_Addr3" ).append("\n"); 
		query.append("    ,HJSEAI_PKG.H_ENCODE(Locl_Addr4, 'UTF8' ,'UTF8') Locl_Addr4" ).append("\n"); 
		query.append("    ,Locl_Zip_Cd            " ).append("\n"); 
		query.append("    ,Ib_Phn_No              " ).append("\n"); 
		query.append("    ,Ib_Fax_No              " ).append("\n"); 
		query.append("    ,MCC.Cre_Usr_Id             " ).append("\n"); 
		query.append("    ,TO_CHAR(MCC.Cre_Dt,'YYYYMMDDHH24MISS') Cre_Dt               " ).append("\n"); 
		query.append("    ,MCC.Upd_Usr_Id             " ).append("\n"); 
		query.append("    ,TO_CHAR(MCC.Upd_Dt,'YYYYMMDDHH24MISS') Upd_Dt" ).append("\n"); 
		query.append("    ,MCC.Delt_Flg              " ).append("\n"); 
		query.append("    ,Ob_Phn_No              " ).append("\n"); 
		query.append("    ,Ob_Fax_No              " ).append("\n"); 
		query.append("    ,HJSEAI_PKG.H_ENCODE(Ownr_Nm, 'UTF8' ,'UTF8') Ownr_Nm" ).append("\n"); 
		query.append("    ,HJSEAI_PKG.H_ENCODE(Bzct_Nm, 'UTF8' ,'UTF8') Bzct_Nm" ).append("\n"); 
		query.append("    ,HJSEAI_PKG.H_ENCODE(MCC.BZTP_NM, 'UTF8' ,'UTF8') Bztp_Desc             " ).append("\n"); 
		query.append("    ,Inv_Due_Dt_Dp_Flg        " ).append("\n"); 
		query.append("    ,Indiv_Corp_Div_Cd       " ).append("\n"); 
		query.append("    ,Cust_Rgst_No           " ).append("\n"); 
		query.append("    ,Riss_Inv_Flg           " ).append("\n"); 
		query.append("    ,MC.Inv_Iss_Curr_Tp_Cd       " ).append("\n"); 
		query.append("    ,Cust_Rlse_Ctrl_Rmk      " ).append("\n"); 
		query.append("    ,Sub_Sys_Nm             " ).append("\n"); 
		query.append("    ,Auto_Inv_Ib_Flg         " ).append("\n"); 
		query.append("    ,Auto_Inv_Ib_Hjs_Ref_No    " ).append("\n"); 
		query.append("    ,Auto_Inv_Ib_Hjs_Ref_Phn_No " ).append("\n"); 
		query.append("    ,Auto_Inv_Ib_Cust_Ref_No_Flg" ).append("\n"); 
		query.append("    ,Auto_Inv_Ib_Locl_Chg_Flg  " ).append("\n"); 
		query.append("    ,Auto_Inv_Ib_Eml         " ).append("\n"); 
		query.append("    ,Auto_Inv_Ob_Flg         " ).append("\n"); 
		query.append("    ,Auto_Inv_Ob_Hjs_Ref_No    " ).append("\n"); 
		query.append("    ,Auto_Inv_Ob_Hjs_Ref_Phn_No " ).append("\n"); 
		query.append("    ,Auto_Inv_Ob_Cust_Ref_No_Flg" ).append("\n"); 
		query.append("    ,Auto_Inv_Ob_Locl_Chg_Flg  " ).append("\n"); 
		query.append("    ,Auto_Inv_Ob_Eml         " ).append("\n"); 
		query.append("    ,'' Auto_Rmdr_Snd_Flg       " ).append("\n"); 
		query.append("    ,'' Auto_Rmdr_Hjs_Ref_No     " ).append("\n"); 
		query.append("    ,'' Auto_Rmdr_Hjs_Ref_PhnNo  " ).append("\n"); 
		query.append("    ,'' Auto_Rmdr_Snd_Term_Cd    " ).append("\n"); 
		query.append("    ,'' Auto_Rmdr_Ib_Eml        " ).append("\n"); 
		query.append("    ,'' Auto_Rmdr_Ob_Eml        " ).append("\n"); 
		query.append("    ,'' Local_Info_Rmrk        " ).append("\n"); 
		query.append("    ,Pay_Dt_Dy5             " ).append("\n"); 
		query.append("    ,MCC.PAY_WK_DY_CD Pay_Wk_Day             " ).append("\n"); 
		query.append("    ,Pay_Tp_Cd              " ).append("\n"); 
		query.append("FROM MDM_CR_CUST MCC" ).append("\n"); 
		query.append("     ,MDM_CUSTOMER MC" ).append("\n"); 
		query.append("WHERE MCC.CUST_CNT_CD = MC.CUST_CNT_CD" ).append("\n"); 
		query.append("AND MCC.CUST_SEQ = MC.CUST_SEQ" ).append("\n"); 
		query.append("AND MC.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("AND MC.CUST_SEQ    = @[cust_seq]" ).append("\n"); 

	}
}
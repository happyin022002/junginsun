/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TransferOrderIssueDBDAOBkgTroActCustExtVOEQRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOBkgTroActCustExtVOEQRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_BKG_0905 tab2 detail select sql -> BkgTroActCustExtVO use !!  VO생성하지말것! SQL만 사용함
	  * </pre>
	  */
	public TransferOrderIssueDBDAOBkgTroActCustExtVOEQRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("tro_act_rep_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOBkgTroActCustExtVOEQRSQL").append("\n"); 
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
		query.append("SELECT A.TRO_ACT_CUST_KND_CD," ).append("\n"); 
		query.append("       A.TRO_VNDR_SEQ," ).append("\n"); 
		query.append("       A.OFC_CD," ).append("\n"); 
		query.append("       A.TRO_ACT_REP_SEQ," ).append("\n"); 
		query.append("       A.CNT_CD," ).append("\n"); 
		query.append("       A.CUST_SEQ," ).append("\n"); 
		query.append("       A.VNDR_SEQ," ).append("\n"); 
		query.append("       A.LOC_CD," ).append("\n"); 
		query.append("       SUBSTR(A.ZN_CD, 6, 2) ZN_CD," ).append("\n"); 
		query.append("       A.ACT_SHPR_NM," ).append("\n"); 
		query.append("       A.ACT_SHPR_ADDR," ).append("\n"); 
		query.append("       A.ACT_SHPR_ADDR1," ).append("\n"); 
		query.append("       A.ACT_SHPR_ADDR2," ).append("\n"); 
		query.append("       A.ACT_SHPR_ADDR3," ).append("\n"); 
		query.append("       A.CNTC_PSON_NM," ).append("\n"); 
		query.append("       A.CNTC_PHN_NO," ).append("\n"); 
		query.append("       A.CNTC_FAX_NO," ).append("\n"); 
		query.append("       A.CNTC_MPHN_NO," ).append("\n"); 
		query.append("       A.CNTC_EML," ).append("\n"); 
		query.append("       A.DOR_ZIP_ID," ).append("\n"); 
		query.append("       A.DIFF_RMK," ).append("\n"); 
		query.append("       B.VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("       A.CRE_USR_ID," ).append("\n"); 
		query.append("       A.CRE_DT," ).append("\n"); 
		query.append("       A.UPD_USR_ID," ).append("\n"); 
		query.append("       A.UPD_DT" ).append("\n"); 
		query.append("  FROM BKG_TRO_ACT_CUST A," ).append("\n"); 
		query.append("       MDM_VENDOR B" ).append("\n"); 
		query.append(" WHERE A.VNDR_SEQ = B.VNDR_SEQ(+)" ).append("\n"); 
		query.append("   AND A.TRO_ACT_CUST_KND_CD = 'E'" ).append("\n"); 
		query.append("   AND A.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("   AND A.TRO_ACT_REP_SEQ = @[tro_act_rep_seq]" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UserSetupMgtDBDAOSearchCustChkPntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.12
*@LastModifier : Do Soon Choi
*@LastVersion : 1.0
* 2015.08.12 Do Soon Choi
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do Soon Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UserSetupMgtDBDAOSearchCustChkPntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCustChkPnt
	  * </pre>
	  */
	public UserSetupMgtDBDAOSearchCustChkPntRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chk_pnt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.integration").append("\n"); 
		query.append("FileName : UserSetupMgtDBDAOSearchCustChkPntRSQL").append("\n"); 
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
		query.append("SELECT M.CUST_CNT_CD " ).append("\n"); 
		query.append("       ,LPAD(M.CUST_SEQ,6,0) CUST_SEQ" ).append("\n"); 
		query.append("	   ,C3.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("       ,M.BKG_OFC_CD" ).append("\n"); 
		query.append("	   ,M.CHK_PNT_TP_CD" ).append("\n"); 
		query.append("	   ,M.CUST_CHK_PNT_SEQ" ).append("\n"); 
		query.append("	   ,M.CHK_PNT_ITM_SEQ" ).append("\n"); 
		query.append("       ,C1.CHK_PNT_ITM_NM" ).append("\n"); 
		query.append("	   ,M.CHK_PNT_ITM_TP_SEQ" ).append("\n"); 
		query.append("       ,C2.CHK_PNT_ITM_TP_NM" ).append("\n"); 
		query.append("       ,M.CHK_PNT_RMK" ).append("\n"); 
		query.append("       ,M.PIC_EML" ).append("\n"); 
		query.append("       ,M.ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("       ,M.ATCH_FILE_KNT" ).append("\n"); 
		query.append("	   ,M.DELT_FLG" ).append("\n"); 
		query.append("	   ,M.CRE_USR_ID" ).append("\n"); 
		query.append("	   ,M.CRE_DT" ).append("\n"); 
		query.append("	   ,M.UPD_USR_ID" ).append("\n"); 
		query.append("	   ,M.UPD_DT" ).append("\n"); 
		query.append("	   ,U.USR_NM" ).append("\n"); 
		query.append("       ,U.OFC_CD" ).append("\n"); 
		query.append("  FROM BKG_CUST_CHK_PNT M," ).append("\n"); 
		query.append("       BKG_CHK_PNT_ITM  C1," ).append("\n"); 
		query.append("       BKG_CHK_PNT_ITM_TP C2," ).append("\n"); 
		query.append("	   MDM_CUSTOMER C3," ).append("\n"); 
		query.append("	   COM_USER U       " ).append("\n"); 
		query.append(" WHERE M.CHK_PNT_TP_CD = C1.CHK_PNT_TP_CD(+)" ).append("\n"); 
		query.append("   AND M.CHK_PNT_ITM_SEQ = C1.CHK_PNT_ITM_SEQ(+)" ).append("\n"); 
		query.append("   AND NVL(C1.DELT_FLG(+),'N') = 'N'" ).append("\n"); 
		query.append("   AND M.CHK_PNT_TP_CD = C2.CHK_PNT_TP_CD(+)" ).append("\n"); 
		query.append("   AND M.CHK_PNT_ITM_SEQ = C2.CHK_PNT_ITM_SEQ(+)" ).append("\n"); 
		query.append("   AND M.CHK_PNT_ITM_TP_SEQ = C2.CHK_PNT_ITM_TP_SEQ(+)" ).append("\n"); 
		query.append("   AND NVL(C2.DELT_FLG(+),'N') = 'N'" ).append("\n"); 
		query.append("   AND M.CUST_CNT_CD = C3.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("   AND M.CUST_SEQ = C3.CUST_SEQ(+)   " ).append("\n"); 
		query.append("   AND M.UPD_USR_ID = U.USR_ID(+)" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '' && ${cust_seq} !='') " ).append("\n"); 
		query.append("   AND M.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("   AND M.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND M.CHK_PNT_TP_CD = @[chk_pnt_tp_cd]" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '') " ).append("\n"); 
		query.append("   AND (M.BKG_OFC_CD = @[bkg_ofc_cd] OR NVL(M.BKG_OFC_CD,'N') = 'N')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${delt_flg} == '') " ).append("\n"); 
		query.append("   AND NVL(M.DELT_FLG,'N') = NVL(@[delt_flg],'N')" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}